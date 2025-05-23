package ku;

import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.processor.c;
import com.tencent.av.r;
import com.tencent.av.utils.e;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends EffectConfigBase<a> {
    public b(VideoAppInterface videoAppInterface) {
        super(videoAppInterface);
    }

    private String S() {
        if (QLog.isColorLevel()) {
            QLog.i("ZplanAvatarManager", 2, "getBgConfigJson");
        }
        a U = U();
        if (U == null) {
            return null;
        }
        if (!U.isUsable() && !C(U)) {
            QLog.e("ZplanAvatarManager", 1, "getBgConfigJson zplanAvatarItem is not usable");
            return null;
        }
        try {
            File file = new File(y(U) + "video_zplan_background_spring_festival" + File.separator + "config.json");
            if (file.exists()) {
                String readFileContent = FileUtils.readFileContent(file);
                if (QLog.isColorLevel()) {
                    QLog.i("ZplanAvatarManager", 2, "getBgConfigJson configStr: " + readFileContent);
                }
                return FileUtils.readFileContent(file);
            }
            QLog.e("ZplanAvatarManager", 1, "configJsonFile not exist");
            return null;
        } catch (Exception e16) {
            QLog.e("ZplanAvatarManager", 1, "getBgConfigJson exception", e16);
            return null;
        }
    }

    private a U() {
        a w3 = w("video_zplan_background_spring_festival");
        if (w3 == null) {
            QLog.e("ZplanAvatarManager", 1, "getBgZplanAvatarItem ZplanAvatarItem is null");
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ZplanAvatarManager", 2, "getBgZplanAvatarItem " + w3.toString());
        }
        return w3;
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    protected boolean B() {
        return true;
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    protected void H() {
        List<a> i3 = ((c) ((hu.a) this.f73316e.B(15)).n(4)).i(com.tencent.av.b.o(), "zplan_avatar_update_template.json", "zplan_avatar_default_template.json");
        this.f73303i = i3;
        I(i3);
    }

    public ArrayList<dx.c> R() {
        if (QLog.isColorLevel()) {
            QLog.i("ZplanAvatarManager", 2, "getAllConfigBg");
        }
        String S = S();
        if (TextUtils.isEmpty(S)) {
            return null;
        }
        ArrayList<dx.c> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(S);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                dx.c cVar = new dx.c();
                cVar.k(jSONObject.getString("bg_name"));
                cVar.m(jSONObject.getLong("start_time"));
                cVar.l(jSONObject.getLong("end_time"));
                arrayList.add(cVar);
            }
            Collections.sort(arrayList);
            return arrayList;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public String T(String str) {
        return Z(str);
    }

    public String V() {
        ArrayList<dx.c> R = R();
        if (R != null && R.size() > 0) {
            Iterator<dx.c> it = R.iterator();
            while (it.hasNext()) {
                dx.c next = it.next();
                if (QLog.isColorLevel()) {
                    QLog.i("ZplanAvatarManager", 2, "getCurrentBgName ZplanAvatarBgConfig: " + next.toString());
                }
                if (!TextUtils.isEmpty(next.getBgName()) && NetConnInfoCenter.getServerTime() >= next.getStartTime() && NetConnInfoCenter.getServerTime() <= next.getEndTime() && FileUtils.fileExists(T(next.getBgName()))) {
                    if (QLog.isColorLevel()) {
                        QLog.i("ZplanAvatarManager", 2, "getCurrentBgName get right bg " + next.toString());
                    }
                    return next.getBgName();
                }
            }
        }
        return null;
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public String v(a aVar) {
        if (aVar != null) {
            return com.tencent.av.b.q() + aVar.getMd5();
        }
        return null;
    }

    public String X() {
        return Z("plane2.gltf");
    }

    public long Y() {
        ArrayList<dx.c> R = R();
        if (R != null && R.size() > 0) {
            long serverTime = NetConnInfoCenter.getServerTime();
            Iterator<dx.c> it = R.iterator();
            while (it.hasNext()) {
                long startTime = it.next().getStartTime() - serverTime;
                if (startTime > 0) {
                    return startTime;
                }
            }
            return -1L;
        }
        QLog.e("ZplanAvatarManager", 1, "getNextBgShowTimeDelay empty list");
        return -1L;
    }

    public String Z(String str) {
        a U = U();
        if (U == null) {
            return null;
        }
        if (!U.isUsable() && !C(U)) {
            return null;
        }
        String str2 = y(U) + "video_zplan_background_spring_festival" + File.separator + str;
        QLog.i("ZplanAvatarManager", 2, "getPath path is " + str2);
        return str2;
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public String y(a aVar) {
        if (aVar != null) {
            return com.tencent.av.b.r() + aVar.getMd5() + File.separator;
        }
        return "";
    }

    public boolean b0() {
        boolean z16;
        if (FileUtils.fileExists(X()) && FileUtils.fileExists(T(V()))) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("ZplanAvatarManager", 1, "isBgResOk" + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.EffectConfigBase
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public void D(a aVar) {
        if (aVar != null && "video_zplan_background_spring_festival".equalsIgnoreCase(aVar.getId()) && this.f73316e != null && r.h0() != null) {
            r.h0().F3(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public boolean i(String str) {
        super.G();
        List<T> list = this.f73303i;
        if (list != 0) {
            for (T t16 : list) {
                long d16 = e.d();
                if (e.k()) {
                    QLog.w("ZplanAvatarManager", 1, "preDownloadResource, seq[" + d16 + "], res[" + t16.getResUrl() + "], icon[" + t16.getIconUrl() + "]");
                }
                if (t16.a() && !TextUtils.isEmpty(t16.getResUrl()) && !t16.isUsable() && !C(t16)) {
                    N(d16, t16);
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    public int r() {
        return 0;
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    protected Class<?> x() {
        return a.class;
    }
}

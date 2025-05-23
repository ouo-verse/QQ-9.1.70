package com.qzone.business.tianshu;

import android.text.TextUtils;
import com.qzone.business.tianshu.model.QZoneQuickCommentInfo;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneCommentQuickInputHelper extends b {

    /* renamed from: e, reason: collision with root package name */
    private static volatile QZoneCommentQuickInputHelper f44830e = null;

    /* renamed from: f, reason: collision with root package name */
    public static int f44831f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static int f44832g = 1;

    /* renamed from: h, reason: collision with root package name */
    public static int f44833h = 2;

    /* renamed from: b, reason: collision with root package name */
    private boolean f44834b;

    /* renamed from: c, reason: collision with root package name */
    private QZoneQuickCommentInfo f44835c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<a> f44836d;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
        void a(QZoneQuickCommentInfo qZoneQuickCommentInfo);
    }

    private List<q5.a> m(Map<String, String> map, int i3) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty() && i3 > 0) {
            String str = map.get("card_list");
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                        q5.a aVar = new q5.a();
                        aVar.f428352a = f44832g;
                        aVar.f428353b = jSONArray.getJSONObject(i16).optString("text");
                        aVar.f428354c = jSONArray.getJSONObject(i16).optString("pic");
                        aVar.f428355d = jSONArray.getJSONObject(i16).optString("url");
                        aVar.f428356e = jSONArray.getJSONObject(i16).optString("text_color");
                        aVar.f428357f = jSONArray.getJSONObject(i16).optString("text_dark_color");
                        aVar.f428358g = jSONArray.getJSONObject(i16).optString(LayoutAttrDefine.BG_Color);
                        aVar.f428359h = jSONArray.getJSONObject(i16).optString("bg_dark_color");
                        arrayList.add(aVar);
                    }
                } catch (JSONException e16) {
                    QLog.e("QZoneCommentQuickInputHelper", 1, "parse card_list fail " + e16);
                }
            }
            String str2 = map.get("text");
            if (!TextUtils.isEmpty(str2)) {
                try {
                    String[] split = str2.split(",");
                    Random random = new Random();
                    HashSet<Integer> hashSet = new HashSet();
                    int min = Math.min(i3, split.length);
                    while (hashSet.size() < min) {
                        hashSet.add(Integer.valueOf(random.nextInt(split.length)));
                    }
                    for (Integer num : hashSet) {
                        q5.a aVar2 = new q5.a();
                        aVar2.f428352a = f44831f;
                        if (num.intValue() < split.length) {
                            aVar2.f428353b = split[num.intValue()];
                        }
                        arrayList.add(aVar2);
                    }
                } catch (Exception e17) {
                    QLog.e("QZoneCommentQuickInputHelper", 1, "[getCommentCardItems] fail " + e17);
                }
            }
        }
        return arrayList;
    }

    public static QZoneCommentQuickInputHelper n() {
        if (f44830e == null) {
            synchronized (QZoneCommentQuickInputHelper.class) {
                if (f44830e == null) {
                    f44830e = new QZoneCommentQuickInputHelper();
                }
            }
        }
        return f44830e;
    }

    private byte[] o() {
        return com.qzone.reborn.util.i.b().e("quickCommentTianshuTrans", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            byte[] o16 = o();
            if (o16 != null) {
                TianShuAccess.AdItem adItem = new TianShuAccess.AdItem();
                adItem.mergeFrom(o16);
                if (adItem.has()) {
                    this.f44856a = adItem;
                    t();
                }
            }
        } catch (Exception e16) {
            QLog.e("QZoneCommentQuickInputHelper", 1, "mergeFrom fail " + e16);
        }
    }

    private void s() {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.qzone.business.tianshu.QZoneCommentQuickInputHelper.1
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneCommentQuickInputHelper.this.f44856a != null) {
                    com.qzone.reborn.util.i.b().m("quickCommentTianshuTrans", QZoneCommentQuickInputHelper.this.f44856a.toByteArray());
                }
            }
        });
    }

    private void t() {
        TianShuAccess.AdItem adItem = this.f44856a;
        if (adItem == null) {
            return;
        }
        List<TianShuAccess.MapEntry> list = adItem.argList.get();
        if (bl.b(this.f44856a.argList.get())) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (TianShuAccess.MapEntry mapEntry : list) {
            String str = mapEntry.key.get();
            String str2 = mapEntry.value.get();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                hashMap.put(str, str2);
            }
        }
        QZoneQuickCommentInfo qZoneQuickCommentInfo = new QZoneQuickCommentInfo(this.f44856a);
        this.f44835c = qZoneQuickCommentInfo;
        qZoneQuickCommentInfo.setShowMax(com.qzone.album.util.o.a(hashMap.get("show_max"), 10));
        this.f44835c.setEntrancePic(hashMap.get("entrance_pic"));
        this.f44835c.setCardList(m(hashMap, this.f44835c.showMax));
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.business.tianshu.QZoneCommentQuickInputHelper.2
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneCommentQuickInputHelper.this.f44836d == null || QZoneCommentQuickInputHelper.this.f44836d.get() == 0 || QZoneCommentQuickInputHelper.this.f44835c == null) {
                    return;
                }
                ((a) QZoneCommentQuickInputHelper.this.f44836d.get()).a(QZoneCommentQuickInputHelper.this.f44835c);
            }
        });
    }

    @Override // com.qzone.business.tianshu.b
    int b() {
        return gdt_analysis_event.EVENT_MOTIVE_CREATE_VIEW_FAILED;
    }

    @Override // com.qzone.business.tianshu.b
    List<Integer> c() {
        return null;
    }

    @Override // com.qzone.business.tianshu.b
    protected void f(int i3) {
        s();
        t();
    }

    public void p(a aVar) {
        this.f44836d = new WeakReference<>(aVar);
        if (!this.f44834b) {
            this.f44834b = true;
            a();
        }
        if (this.f44856a != null && this.f44835c != null) {
            t();
        } else {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.qzone.business.tianshu.QZoneCommentQuickInputHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    QZoneCommentQuickInputHelper.this.q();
                }
            });
        }
    }

    public void l() {
        this.f44836d = null;
        this.f44834b = false;
    }

    public void r() {
        this.f44836d = null;
    }
}

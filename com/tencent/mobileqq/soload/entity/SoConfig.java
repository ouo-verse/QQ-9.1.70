package com.tencent.mobileqq.soload.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadConfBean;
import com.tencent.mobileqq.soload.util.h;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SoConfig implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<SoConfig> CREATOR;

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f288675f;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, SoInfo> f288676d;

    /* renamed from: e, reason: collision with root package name */
    public int f288677e;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<SoConfig> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SoConfig createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SoConfig) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new SoConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SoConfig[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (SoConfig[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new SoConfig[i3];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements Comparator<ai> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoConfig.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ai aiVar, ai aiVar2) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aiVar, (Object) aiVar2)).intValue();
            }
            int i16 = 0;
            if (aiVar == null) {
                i3 = 0;
            } else {
                i3 = aiVar.f202267a;
            }
            if (aiVar2 != null) {
                i16 = aiVar2.f202267a;
            }
            return i16 - i3;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21922);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f288675f = new byte[0];
            CREATOR = new a();
        }
    }

    public SoConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f288676d = new HashMap();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Map<String, SoInfo> a(SoLoadConfBean soLoadConfBean) {
        HashMap hashMap = new HashMap();
        if (soLoadConfBean != null && soLoadConfBean.confFiles != null) {
            return e(soLoadConfBean);
        }
        return hashMap;
    }

    private Map<String, SoInfo> e(SoLoadConfBean soLoadConfBean) {
        HashMap hashMap = new HashMap();
        Iterator<ai> it = k(soLoadConfBean).iterator();
        while (it.hasNext()) {
            f(hashMap, it.next());
        }
        return hashMap;
    }

    private void f(Map<String, SoInfo> map, ai aiVar) {
        if (!TextUtils.isEmpty(aiVar.f202268b)) {
            try {
                JSONArray optJSONArray = new JSONObject(aiVar.f202268b).optJSONArray("so_info_list");
                if (optJSONArray != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        SoInfo create = SoInfo.create(optJSONArray.optJSONObject(i3));
                        if (create != null) {
                            if (map.containsKey(create.name)) {
                                SoInfo soInfo = map.get(create.name);
                                if (soInfo == null) {
                                    map.put(create.name, create);
                                } else {
                                    map.put(create.name, soInfo.merge(create));
                                }
                            } else {
                                map.put(create.name, create);
                            }
                        }
                    }
                }
            } catch (Throwable th5) {
                QLog.e("SoLoadWidget.SoConfig", 1, th5, new Object[0]);
                h.h(aiVar.f202267a + "", th5.getMessage());
            }
        }
    }

    public static SoConfig g() {
        QLog.i("SoLoadWidget.SoConfig", 2, "<<<readConfig<<<");
        return (SoConfig) p03.a.o().f("sl.config", SoConfig.class, new SoConfig());
    }

    private List<ai> k(SoLoadConfBean soLoadConfBean) {
        try {
            LinkedList linkedList = new LinkedList(Arrays.asList(soLoadConfBean.confFiles));
            Collections.sort(linkedList, new b());
            return linkedList;
        } catch (Throwable unused) {
            return new LinkedList(Arrays.asList(soLoadConfBean.confFiles));
        }
    }

    public boolean b() {
        Map<String, SoInfo> map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f288677e == AppSetting.f() && (map = this.f288676d) != null && map.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        Map<String, SoInfo> map = this.f288676d;
        if (map != null && map.get(str) != null) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return 0;
    }

    public void j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.soload.entity.SoConfig.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SoConfig.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    QLog.i("SoLoadWidget.SoConfig", 2, "<<<saveConfig<<<");
                    p03.a.o().k("sl.config", SoConfig.this);
                }
            }
        };
        if (z16) {
            runnable.run();
        } else {
            ThreadManager.getFileThreadHandler().post(runnable);
        }
    }

    public void l(SoLoadConfBean soLoadConfBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) soLoadConfBean);
            return;
        }
        this.f288676d = a(soLoadConfBean);
        this.f288677e = AppSetting.f();
        j(false);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "SoConfig{mSoInfos=" + this.f288676d + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) parcel, i3);
        } else {
            parcel.writeInt(this.f288677e);
            parcel.writeMap(this.f288676d);
        }
    }

    protected SoConfig(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f288676d = new HashMap();
        this.f288677e = parcel.readInt();
        parcel.readMap(this.f288676d, SoConfig.class.getClassLoader());
    }
}

package com.tencent.mobileqq.service.qzone;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QZoneTitleTabManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final CopyOnWriteArrayList<TabInfo> f286388a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile int f286389b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75012);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f286388a = new CopyOnWriteArrayList<>();
            f286389b = 0;
        }
    }

    public static void a(Intent intent) {
        if (intent != null) {
            intent.putParcelableArrayListExtra("key_tab_intent", b());
        }
    }

    public static ArrayList<TabInfo> b() {
        ArrayList<TabInfo> arrayList = new ArrayList<>(2);
        arrayList.addAll(f286388a);
        QLog.i("QZoneTitleTabManager", 1, "getTabInfos:" + arrayList);
        return arrayList;
    }

    static boolean c(TabInfo tabInfo) {
        if (tabInfo == null) {
            return false;
        }
        if (HttpUtil.isValidUrl(tabInfo.f286395m) && !TextUtils.isEmpty(tabInfo.f286391e)) {
            return true;
        }
        int i3 = tabInfo.f286390d;
        if (i3 == 51) {
            if (TextUtils.isEmpty(tabInfo.f286391e)) {
                return false;
            }
            return true;
        }
        if (i3 == 15) {
            if (!HttpUtil.isValidUrl(tabInfo.f286395m)) {
                tabInfo.f286395m = "https://h5.qzone.qq.com/secret/list/{uin}/secret?_proxy=1&_wv=3&source=tab";
            }
            return true;
        }
        if (i3 != 51) {
            return false;
        }
        return true;
    }

    public static void d(String str) {
        if (f286389b > 1) {
            return;
        }
        String string = BaseApplicationImpl.getApplication().getSharedPreferences("qzone_tab_info_" + str, 0).getString("qzone_tab_key", "");
        if (QLog.isColorLevel()) {
            QLog.i("QZoneTitleTabManager", 2, "loadTabInfo:" + string);
        }
        try {
            if (!TextUtils.isEmpty(string)) {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray.length() > 0) {
                    int length = jSONArray.length();
                    ArrayList arrayList = new ArrayList(2);
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        TabInfo tabInfo = new TabInfo();
                        tabInfo.a(jSONObject);
                        arrayList.add(tabInfo);
                    }
                    e(arrayList);
                    if (f286389b <= 1) {
                        CopyOnWriteArrayList<TabInfo> copyOnWriteArrayList = f286388a;
                        copyOnWriteArrayList.clear();
                        copyOnWriteArrayList.addAll(arrayList);
                        return;
                    }
                    return;
                }
                return;
            }
            QLog.i("QZoneTitleTabManager", 2, "\u672c\u5730\u6ca1\u6709title\u4e0a\u53d1\u73b0tab\u7684\u914d\u7f6e");
        } catch (JSONException e16) {
            QLog.e("QZoneTitleTabManager", 2, e16, new Object[0]);
        }
    }

    private static ArrayList<TabInfo> e(ArrayList<TabInfo> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            if (arrayList.size() == 1) {
                ArrayList<TabInfo> arrayList2 = new ArrayList<>(1);
                TabInfo tabInfo = arrayList.get(0);
                if (tabInfo != null && tabInfo.f286390d == 50) {
                    String str = tabInfo.f286391e;
                    if (TextUtils.isEmpty(str)) {
                        str = HardCodeUtil.qqStr(R.string.hvk);
                    }
                    arrayList2.add(new TabInfo(tabInfo.f286390d, str));
                    return arrayList2;
                }
                return arrayList2;
            }
            if (arrayList.size() >= 2) {
                ArrayList<TabInfo> arrayList3 = new ArrayList<>(2);
                TabInfo tabInfo2 = arrayList.get(0);
                TabInfo tabInfo3 = arrayList.get(1);
                if (tabInfo2.f286390d == 50) {
                    if (TextUtils.isEmpty(tabInfo2.f286391e)) {
                        tabInfo2.f286391e = HardCodeUtil.qqStr(R.string.s9z);
                    }
                } else {
                    tabInfo2.f286390d = 50;
                    tabInfo2.f286391e = HardCodeUtil.qqStr(R.string.s_0);
                }
                arrayList3.add(tabInfo2);
                if (c(tabInfo3)) {
                    arrayList3.add(tabInfo3);
                } else {
                    QLog.e("QZoneTitleTabManager", 1, "procesConfig not support secondTab:" + tabInfo3);
                }
                return arrayList3;
            }
        } else {
            QLog.i("QZoneTitleTabManager", 2, "processConfig:" + arrayList);
        }
        return null;
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class TabInfo implements Parcelable {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<TabInfo> CREATOR;

        /* renamed from: d, reason: collision with root package name */
        public int f286390d;

        /* renamed from: e, reason: collision with root package name */
        public String f286391e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f286392f;

        /* renamed from: h, reason: collision with root package name */
        public int f286393h;

        /* renamed from: i, reason: collision with root package name */
        public int f286394i;

        /* renamed from: m, reason: collision with root package name */
        public String f286395m;

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class a implements Parcelable.Creator<TabInfo> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TabInfo createFromParcel(Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (TabInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                return new TabInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public TabInfo[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (TabInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return new TabInfo[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75011);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 10)) {
                redirector.redirect((short) 10);
            } else {
                CREATOR = new a();
            }
        }

        public TabInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f286392f = true;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) jSONObject);
                return;
            }
            this.f286390d = jSONObject.optInt("id");
            this.f286391e = jSONObject.optString("name");
            this.f286393h = jSONObject.optInt("actionType", -1);
            this.f286394i = jSONObject.optInt("subActionType", -1);
            this.f286392f = jSONObject.optBoolean("rememberAnchor", false);
            this.f286395m = jSONObject.optString("url");
        }

        public JSONObject b() throws JSONException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (JSONObject) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f286390d);
            jSONObject.put("name", this.f286391e);
            jSONObject.put("actionType", this.f286393h);
            jSONObject.put("subActionType", this.f286394i);
            jSONObject.put("rememberAnchor", this.f286392f);
            jSONObject.put("url", this.f286395m);
            return jSONObject;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return 0;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            try {
                return b().toString();
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("QZoneTitleTabManager", 2, "", e16);
                }
                return "";
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) parcel, i3);
                return;
            }
            parcel.writeInt(this.f286390d);
            parcel.writeString(this.f286391e);
            parcel.writeInt(this.f286393h);
            parcel.writeInt(this.f286394i);
            parcel.writeByte(this.f286392f ? (byte) 1 : (byte) 0);
            parcel.writeString(this.f286395m);
        }

        public TabInfo(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            this.f286392f = true;
            this.f286390d = i3;
            this.f286391e = str;
        }

        protected TabInfo(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
                return;
            }
            this.f286392f = true;
            this.f286390d = parcel.readInt();
            this.f286391e = parcel.readString();
            this.f286393h = parcel.readInt();
            this.f286394i = parcel.readInt();
            this.f286392f = parcel.readByte() != 0;
            this.f286395m = parcel.readString();
        }
    }
}

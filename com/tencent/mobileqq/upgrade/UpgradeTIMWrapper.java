package com.tencent.mobileqq.upgrade;

import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
/* loaded from: classes20.dex */
public class UpgradeTIMWrapper implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<UpgradeTIMWrapper> CREATOR;
    public String C;
    public String D;

    /* renamed from: d, reason: collision with root package name */
    public String f306192d;

    /* renamed from: e, reason: collision with root package name */
    public String f306193e;

    /* renamed from: f, reason: collision with root package name */
    public String f306194f;

    /* renamed from: h, reason: collision with root package name */
    public String f306195h;

    /* renamed from: i, reason: collision with root package name */
    public String f306196i;

    /* renamed from: m, reason: collision with root package name */
    public int f306197m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements Parcelable.Creator<UpgradeTIMWrapper> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UpgradeTIMWrapper createFromParcel(Parcel parcel) {
            int i3;
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (UpgradeTIMWrapper) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            try {
                i3 = parcel.readInt();
                try {
                    str = parcel.readString();
                    try {
                        str2 = parcel.readString();
                    } catch (Exception e16) {
                        e = e16;
                        e.printStackTrace();
                        str2 = null;
                        return new UpgradeTIMWrapper(readString, readString2, readString3, readString4, readString5, i3, str, str2);
                    }
                } catch (Exception e17) {
                    e = e17;
                    str = null;
                    e.printStackTrace();
                    str2 = null;
                    return new UpgradeTIMWrapper(readString, readString2, readString3, readString4, readString5, i3, str, str2);
                }
            } catch (Exception e18) {
                e = e18;
                i3 = 0;
            }
            return new UpgradeTIMWrapper(readString, readString2, readString3, readString4, readString5, i3, str, str2);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public UpgradeTIMWrapper[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (UpgradeTIMWrapper[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77143);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            CREATOR = new a();
        }
    }

    public UpgradeTIMWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static UpgradeTIMWrapper a(String str) {
        UpgradeTIMWrapper upgradeTIMWrapper = new UpgradeTIMWrapper();
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (name.equalsIgnoreCase("title")) {
                        upgradeTIMWrapper.f306192d = newPullParser.nextText();
                    } else if (name.equalsIgnoreCase("content")) {
                        upgradeTIMWrapper.f306193e = newPullParser.nextText();
                    } else if (name.equalsIgnoreCase("downloadPageUrlAndroid")) {
                        upgradeTIMWrapper.f306194f = newPullParser.nextText();
                    } else if (name.equalsIgnoreCase("lBtnText")) {
                        upgradeTIMWrapper.f306195h = newPullParser.nextText();
                    } else if (name.equalsIgnoreCase("rBtnText")) {
                        upgradeTIMWrapper.f306196i = newPullParser.nextText();
                    } else if (name.equalsIgnoreCase("tipOn")) {
                        try {
                            upgradeTIMWrapper.f306197m = Integer.valueOf(newPullParser.nextText()).intValue();
                        } catch (NumberFormatException e16) {
                            e16.printStackTrace();
                            QLog.w("UpgradeTIMWrapper", 2, e16.getMessage());
                        }
                    } else if (name.equalsIgnoreCase("tipTitle")) {
                        upgradeTIMWrapper.C = newPullParser.nextText();
                    } else if (name.equalsIgnoreCase("androidTipURL")) {
                        upgradeTIMWrapper.D = newPullParser.nextText();
                    }
                }
            }
        } catch (Exception e17) {
            if (QLog.isDevelopLevel()) {
                QLog.d("UpgradeTIMWrapper", 4, "parseConfig UpgradeTIMWrapper : " + e17.getMessage());
            }
            e17.printStackTrace();
        }
        return upgradeTIMWrapper;
    }

    public static void b(QQAppInterface qQAppInterface, UpgradeTIMWrapper upgradeTIMWrapper) {
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeTIMWrapper", 2, "save tim tip configs, banner on: ", Integer.valueOf(upgradeTIMWrapper.f306197m));
        }
        SharedPreferences.Editor edit = qQAppInterface.getApplication().getSharedPreferences("upgrade_tim_banner_" + qQAppInterface.getCurrentAccountUin(), 0).edit();
        try {
            edit.putInt("upgrade_tim_banner_switch", upgradeTIMWrapper.f306197m);
            edit.putString("upgrade_tim_banner_title", upgradeTIMWrapper.C);
            edit.putString("upgrade_tim_banner_url", upgradeTIMWrapper.D);
            edit.commit();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void c(String str) {
        if (!TextUtils.isEmpty("upgrade_config_tim_info") && !TextUtils.isEmpty(str)) {
            FileUtils.writeFile(new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config_tim").getAbsolutePath(), "upgrade_config_tim_info", str);
            if (QLog.isColorLevel()) {
                QLog.i("UpgradeTIMWrapper", 2, "UpgradeTIMWrapper save upgrade_config_tim to file finish.");
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f306192d);
        parcel.writeString(this.f306193e);
        parcel.writeString(this.f306194f);
        parcel.writeString(this.f306195h);
        parcel.writeString(this.f306196i);
        parcel.writeInt(this.f306197m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
    }

    public UpgradeTIMWrapper(String str, String str2, String str3, String str4, String str5, int i3, String str6, String str7) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, str5, Integer.valueOf(i3), str6, str7);
            return;
        }
        this.f306192d = str;
        this.f306193e = str2;
        this.f306194f = str3;
        this.f306195h = str4;
        this.f306196i = str5;
        this.f306197m = i3;
        this.C = str6;
        this.D = str7;
    }
}

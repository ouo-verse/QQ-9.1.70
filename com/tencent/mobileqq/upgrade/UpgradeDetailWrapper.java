package com.tencent.mobileqq.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Xml;
import androidx.annotation.NonNull;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upgrade.bean.UpgradeStrategy;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import kotlinx.coroutines.DebugKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import protocol.KQQConfig.UpgradeInfo;

/* compiled from: P */
/* loaded from: classes20.dex */
public class UpgradeDetailWrapper implements Parcelable, IConfigData {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<UpgradeDetailWrapper> CREATOR;
    public int C;
    public int D;
    public String E;

    /* renamed from: d, reason: collision with root package name */
    public UpgradeInfo f306170d;

    /* renamed from: e, reason: collision with root package name */
    public UpgradeInfo f306171e;

    /* renamed from: f, reason: collision with root package name */
    public ApkUpdateDetail f306172f;

    /* renamed from: h, reason: collision with root package name */
    public b f306173h;

    /* renamed from: i, reason: collision with root package name */
    public volatile NewUpgradeConfig f306174i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f306175m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements Parcelable.Creator<UpgradeDetailWrapper> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UpgradeDetailWrapper createFromParcel(Parcel parcel) {
            String str;
            UpgradeInfo upgradeInfo;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (UpgradeDetailWrapper) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            ApkUpdateDetail apkUpdateDetail = null;
            if (parcel.readInt() == 1) {
                upgradeInfo = new UpgradeInfo();
                upgradeInfo.iAppid = parcel.readInt();
                upgradeInfo.bAppType = parcel.readByte();
                upgradeInfo.iUpgradeType = parcel.readInt();
                upgradeInfo.iUpgradeSdkId = parcel.readInt();
                upgradeInfo.strTitle = parcel.readString();
                upgradeInfo.strNewTitle = parcel.readString();
                upgradeInfo.strUpgradeDesc = parcel.readString();
                upgradeInfo.strUrl = parcel.readString();
                upgradeInfo.iActionType = parcel.readInt();
                upgradeInfo.bNewSwitch = parcel.readByte();
                upgradeInfo.iNewTimeStamp = parcel.readInt();
                upgradeInfo.strUpgradePageUrl = parcel.readString();
                upgradeInfo.iIncrementUpgrade = parcel.readInt();
                upgradeInfo.iTipsType = parcel.readInt();
                upgradeInfo.strBannerPicUrl = parcel.readString();
                upgradeInfo.strNewUpgradeDescURL = parcel.readString();
                upgradeInfo.iDisplayDay = parcel.readInt();
                upgradeInfo.iTipsWaitDay = parcel.readInt();
                upgradeInfo.strProgressName = parcel.readString();
                upgradeInfo.strNewTipsDescURL = parcel.readString();
                upgradeInfo.strNewSoftwareURL = parcel.readString();
                str = parcel.readString();
                boolean z17 = false;
                if (parcel.readInt() == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                upgradeInfo.is64 = z16;
                if (parcel.readInt() == 1) {
                    z17 = true;
                }
                upgradeInfo.isValid = z17;
            } else {
                str = "";
                upgradeInfo = null;
            }
            if (parcel.readInt() == 1) {
                apkUpdateDetail = new ApkUpdateDetail();
                apkUpdateDetail.fileMd5 = parcel.readString();
                apkUpdateDetail.newapksize = parcel.readInt();
                apkUpdateDetail.packageName = parcel.readString();
                apkUpdateDetail.patchsize = parcel.readInt();
                apkUpdateDetail.sigMd5 = parcel.readString();
                apkUpdateDetail.updatemethod = parcel.readInt();
                apkUpdateDetail.url = parcel.readString();
                apkUpdateDetail.versioncode = parcel.readInt();
                apkUpdateDetail.versionname = parcel.readString();
            }
            UpgradeDetailWrapper upgradeDetailWrapper = new UpgradeDetailWrapper(upgradeInfo, apkUpdateDetail);
            upgradeDetailWrapper.E = str;
            upgradeDetailWrapper.f306173h = UpgradeDetailWrapper.a(upgradeInfo);
            return upgradeDetailWrapper;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public UpgradeDetailWrapper[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (UpgradeDetailWrapper[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new UpgradeDetailWrapper[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f306176a;

        /* renamed from: b, reason: collision with root package name */
        public long f306177b;

        /* renamed from: c, reason: collision with root package name */
        public String f306178c;

        /* renamed from: d, reason: collision with root package name */
        public int f306179d;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f306179d = -1;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77135);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            CREATOR = new a();
        }
    }

    public UpgradeDetailWrapper(UpgradeInfo upgradeInfo, ApkUpdateDetail apkUpdateDetail) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) upgradeInfo, (Object) apkUpdateDetail);
            return;
        }
        this.f306175m = false;
        this.C = 0;
        this.D = 0;
        this.E = "";
        this.f306170d = upgradeInfo;
        this.f306172f = apkUpdateDetail;
    }

    public static b a(UpgradeInfo upgradeInfo) {
        String str;
        b bVar = null;
        if (upgradeInfo == null || (str = upgradeInfo.strProgressName) == null) {
            return null;
        }
        String[] split = str.split("\\|");
        try {
            b bVar2 = new b();
            try {
                bVar2.f306176a = split[2];
                bVar2.f306178c = split[1];
                bVar2.f306177b = Long.parseLong(split[0]);
                bVar2.f306179d = Integer.parseInt(split[3]);
                return bVar2;
            } catch (Exception e16) {
                e = e16;
                bVar = bVar2;
                QLog.e("UpgradeController_Config", 1, "createNewApkInfoFrom fail", e);
                return bVar;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private void c(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        if ("iUpgradeSdkId64".equalsIgnoreCase(str)) {
            this.f306171e.iUpgradeSdkId64 = Integer.parseInt(xmlPullParser.nextText());
            return;
        }
        if ("strProgressName64".equalsIgnoreCase(str)) {
            this.f306171e.strProgressName64 = xmlPullParser.nextText();
        } else if ("strNewSoftwareURL64".equalsIgnoreCase(str)) {
            this.f306171e.strNewSoftwareURL64 = xmlPullParser.nextText();
        } else if ("strNewSoftwareMD564".equalsIgnoreCase(str)) {
            this.f306171e.strNewSoftwareMD564 = xmlPullParser.nextText();
        }
    }

    private void f(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        if (com.tencent.mobileqq.upgrade.manager.b.a(this.f306174i, this.f306171e, xmlPullParser, str) || g(xmlPullParser, str)) {
            return;
        }
        com.tencent.mobileqq.upgrade.manager.b.b(this.f306171e, xmlPullParser, str);
    }

    private boolean g(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        if (str.equalsIgnoreCase("status")) {
            String nextText = xmlPullParser.nextText();
            if ("on".equalsIgnoreCase(nextText)) {
                this.C = 1;
                return true;
            }
            if (!DebugKt.DEBUG_PROPERTY_VALUE_OFF.equalsIgnoreCase(nextText)) {
                return true;
            }
            this.C = 2;
            return true;
        }
        if (str.equalsIgnoreCase("jumpMarketSupportPhone")) {
            this.E = xmlPullParser.nextText();
            return true;
        }
        return false;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f306171e == null) {
            this.f306171e = new UpgradeInfo();
        }
        if (this.f306174i == null) {
            this.f306174i = NewUpgradeConfig.getInstance();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    public void e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            return;
        }
        QLog.i("UpgradeController_Config", 1, "parseConfig start, " + str2);
        b();
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    f(newPullParser, name);
                    c(newPullParser, name);
                }
            }
        } catch (Exception e16) {
            this.f306174i.dialog = null;
            QLog.e("UpgradeController_Config", 1, "parseConfig fail.", e16);
        }
        com.tencent.mobileqq.upgrade.manager.a.c(this.f306171e);
        k();
    }

    public boolean j(@NonNull UpgradeStrategy upgradeStrategy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) upgradeStrategy)).booleanValue();
        }
        boolean z16 = true;
        QLog.i("UpgradeController_Config", 1, "parseConfig start, shiply");
        b();
        try {
            com.tencent.mobileqq.upgrade.shiply.b.a(this, upgradeStrategy);
        } catch (Throwable th5) {
            this.f306174i.dialog = null;
            QLog.e("UpgradeController_Config", 1, "parseShiplyUpgradeStrategy fail", th5);
            z16 = false;
        }
        com.tencent.mobileqq.upgrade.manager.a.c(this.f306171e);
        k();
        return z16;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.d("UpgradeController_Config", 1, "mTempUpgradeInfo, sdkId=" + this.f306171e.iUpgradeSdkId + ", sdkId64=" + this.f306171e.iUpgradeSdkId64 + ", type=" + this.f306171e.iUpgradeType + ", strUrl=" + this.f306171e.strUrl + ", pageUrl=" + this.f306171e.strUpgradePageUrl + ", descURL=" + this.f306171e.strNewUpgradeDescURL + ", actionType=" + this.f306171e.iActionType + ", newSw=" + ((int) this.f306171e.bNewSwitch) + ", newStamp=" + this.f306171e.iNewTimeStamp + ", incUpg=" + this.f306171e.iIncrementUpgrade + ", tipsType=" + this.f306171e.iTipsType + ", PROGName=" + this.f306171e.strProgressName + ", PROGName64=" + this.f306171e.strProgressName64 + ", apkURL=" + this.f306171e.strNewSoftwareURL + ", apkURL64=" + this.f306171e.strNewSoftwareURL64 + ", apkMD5=" + this.f306171e.strNewSoftwareMD5 + ", apkMD564=" + this.f306171e.strNewSoftwareMD564 + ", bGray=" + ((int) this.f306171e.bGray) + ", btnDesc=" + this.f306171e.strButtonDesc + ", CLBtnDesc=" + this.f306171e.strCancelButtonDesc + ", title=" + this.f306171e.strTitle + ", newTitle=" + this.f306171e.strNewTitle + ", UpgDesc=" + this.f306171e.strUpgradeDesc + ", is64=" + this.f306171e.is64 + ", isValid=" + this.f306171e.isValid);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mNewUpgradeConfig dialog, id=");
        sb5.append(this.f306174i.dialog.f306149a);
        sb5.append(", name=");
        sb5.append(this.f306174i.dialog.f306150b);
        sb5.append(", time=");
        sb5.append(this.f306174i.dialog.f306151c);
        sb5.append(", showTime=");
        sb5.append(this.f306174i.dialog.f306152d);
        sb5.append(", title=");
        sb5.append(this.f306174i.dialog.f306153e);
        sb5.append(", newTitle=");
        sb5.append(this.f306174i.dialog.f306154f);
        sb5.append(", content=");
        sb5.append(this.f306174i.dialog.f306155g);
        sb5.append(", desc=");
        sb5.append(this.f306174i.dialog.f306156h);
        sb5.append(", INSTFail=");
        sb5.append(this.f306174i.dialog.f306157i);
        sb5.append(", info=");
        sb5.append(this.f306174i.dialog.f306158j);
        sb5.append(", rate=");
        sb5.append(this.f306174i.dialog.f306159k);
        sb5.append(", barContent=");
        sb5.append(this.f306174i.dialog.f306160l);
        sb5.append(", barContent2=");
        sb5.append(this.f306174i.dialog.f306161m);
        sb5.append(", lBtnText=");
        sb5.append(this.f306174i.dialog.f306162n);
        sb5.append(", rBtnText=");
        sb5.append(this.f306174i.dialog.f306163o);
        sb5.append(", dlMaxTimes=");
        sb5.append(this.f306174i.dialog.f306165q);
        sb5.append(", dlDayRate=");
        sb5.append(this.f306174i.dialog.f306166r);
        sb5.append(", INSTMaxTimes=");
        sb5.append(this.f306174i.dialog.f306167s);
        sb5.append(", INSTDayRate=");
        sb5.append(this.f306174i.dialog.f306168t);
        sb5.append(", preloadSw=");
        sb5.append(this.C);
        sb5.append(", suppJumpMarket=");
        sb5.append(this.E);
        QLog.d("UpgradeController_Config", 1, sb5.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        if (this.f306170d != null) {
            parcel.writeInt(1);
            parcel.writeInt(this.f306170d.iAppid);
            parcel.writeByte(this.f306170d.bAppType);
            parcel.writeInt(this.f306170d.iUpgradeType);
            parcel.writeInt(this.f306170d.iUpgradeSdkId);
            parcel.writeString(this.f306170d.strTitle);
            parcel.writeString(this.f306170d.strNewTitle);
            parcel.writeString(this.f306170d.strUpgradeDesc);
            parcel.writeString(this.f306170d.strUrl);
            parcel.writeInt(this.f306170d.iActionType);
            parcel.writeByte(this.f306170d.bNewSwitch);
            parcel.writeInt(this.f306170d.iNewTimeStamp);
            parcel.writeString(this.f306170d.strUpgradePageUrl);
            parcel.writeInt(this.f306170d.iIncrementUpgrade);
            parcel.writeInt(this.f306170d.iTipsType);
            parcel.writeString(this.f306170d.strBannerPicUrl);
            parcel.writeString(this.f306170d.strNewUpgradeDescURL);
            parcel.writeInt(this.f306170d.iDisplayDay);
            parcel.writeInt(this.f306170d.iTipsWaitDay);
            parcel.writeString(this.f306170d.strProgressName);
            parcel.writeString(this.f306170d.strNewTipsDescURL);
            parcel.writeString(this.f306170d.strNewSoftwareURL);
            parcel.writeString(this.E);
            parcel.writeInt(this.f306170d.is64 ? 1 : 0);
            parcel.writeInt(this.f306170d.isValid ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        if (this.f306172f != null) {
            parcel.writeInt(1);
            parcel.writeString(this.f306172f.fileMd5);
            parcel.writeInt(this.f306172f.newapksize);
            parcel.writeString(this.f306172f.packageName);
            parcel.writeInt(this.f306172f.patchsize);
            parcel.writeString(this.f306172f.sigMd5);
            parcel.writeInt(this.f306172f.updatemethod);
            parcel.writeString(this.f306172f.url);
            parcel.writeInt(this.f306172f.versioncode);
            parcel.writeString(this.f306172f.versionname);
            return;
        }
        parcel.writeInt(0);
    }
}

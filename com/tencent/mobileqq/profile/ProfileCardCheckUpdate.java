package com.tencent.mobileqq.profile;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.ProfileCardLabelUtil;
import com.tencent.mobileqq.util.ProfileCardTemplateUtil;
import com.tencent.mobileqq.util.z;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.pb.profilecard.SummaryCardUpdate$SUpdateReq;
import com.tencent.pb.profilecard.SummaryCardUpdate$SUpdateReqBatch;
import com.tencent.pb.profilecard.SummaryCardUpdate$SUpdateRsp;
import com.tencent.pb.profilecard.SummaryCardUpdate$SUpdateRspBatch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class ProfileCardCheckUpdate implements com.tencent.mobileqq.service.profile.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f259989d;

    /* renamed from: e, reason: collision with root package name */
    int f259990e;

    public ProfileCardCheckUpdate(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f259990e = 0;
            this.f259989d = qQAppInterface;
        }
    }

    private SummaryCardUpdate$SUpdateReq b(int i3, String str) {
        SummaryCardUpdate$SUpdateReq summaryCardUpdate$SUpdateReq = new SummaryCardUpdate$SUpdateReq();
        summaryCardUpdate$SUpdateReq.cmd.set(i3);
        summaryCardUpdate$SUpdateReq.uin.set(this.f259989d.getLongAccountUin());
        summaryCardUpdate$SUpdateReq.version.set(str);
        summaryCardUpdate$SUpdateReq.client_version.set(AppSetting.f99551k);
        summaryCardUpdate$SUpdateReq.platform.set(109);
        if (i3 == 5) {
            summaryCardUpdate$SUpdateReq.appname.set("fun_call");
        }
        return summaryCardUpdate$SUpdateReq;
    }

    private boolean h() {
        boolean z16;
        try {
            long j3 = this.f259989d.getPreferences().getLong("nextCheckUpdateTimeMillis", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(j3));
                String format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(currentTimeMillis));
                StringBuilder sb5 = new StringBuilder();
                sb5.append("isSendTemplateCheckUpdate nextCheckUpdateTime=");
                sb5.append(format);
                sb5.append(",systemTimestamp=");
                sb5.append(format2);
                sb5.append(",isSend=");
                if (currentTimeMillis > j3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, sb5.toString());
            }
            if (currentTimeMillis <= j3) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private boolean i() {
        return false;
    }

    private boolean j() {
        boolean z16;
        try {
            long j3 = this.f259989d.getPreferences().getLong("nextCheckLabelUpdateTimeMillis", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(j3));
                String format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(currentTimeMillis));
                StringBuilder sb5 = new StringBuilder();
                sb5.append("isSendCheckLabelUpdate nextCheckUpdateTime=");
                sb5.append(format);
                sb5.append(",systemTimestamp=");
                sb5.append(format2);
                sb5.append(",isSend=");
                if (currentTimeMillis > j3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, sb5.toString());
            }
            File file = new File(ProfileCardTemplateUtil.f(this.f259989d.getApplication()));
            if (currentTimeMillis <= j3) {
                if (file.exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private boolean k() {
        boolean z16;
        try {
            long j3 = BaseApplicationImpl.getApplication().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getLong("specialcareCheckUpdateTime", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(j3));
                String format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(currentTimeMillis));
                StringBuilder sb5 = new StringBuilder();
                sb5.append("isSendSpecialCareUpdate nextCheckUpdateTime=");
                sb5.append(format);
                sb5.append(",systemTimestamp=");
                sb5.append(format2);
                sb5.append(",isSend=");
                if (currentTimeMillis > j3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, sb5.toString());
            }
            if (currentTimeMillis <= j3) {
                if (new File(BaseApplicationImpl.getApplication().getApplicationContext().getFilesDir(), "pddata/vas/special_remind/new_config.json").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private boolean m() {
        return false;
    }

    public void a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
        } else {
            if (VasToggle.FEATURE_BATCH_UPDATE.isEnable(true)) {
                return;
            }
            ThreadManagerV2.excute(new Runnable(str, str2) { // from class: com.tencent.mobileqq.profile.ProfileCardCheckUpdate.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f259991d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f259992e;

                {
                    this.f259991d = str;
                    this.f259992e = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ProfileCardCheckUpdate.this, str, str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate start downloadLabelConfigJson url=" + this.f259991d + MttLoader.QQBROWSER_PARAMS_VERSION + this.f259992e);
                    }
                    try {
                        File file = new File(ProfileCardTemplateUtil.f(ProfileCardCheckUpdate.this.f259989d.getApplication()) + ".tmp");
                        com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(this.f259991d, file);
                        gVar.S = "profileCardDownload";
                        gVar.R = "VIP_profilecard";
                        boolean z16 = true;
                        gVar.V = (byte) 1;
                        gVar.Q = true;
                        int o16 = DownloaderFactory.o(gVar, ProfileCardCheckUpdate.this.f259989d);
                        if (o16 != 0) {
                            z16 = false;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate downloadLabelConfigJson result code=" + o16);
                        }
                        if (z16) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate downloadLabelConfigJson update label config  success version=" + this.f259992e);
                            }
                            ProfileCardCheckUpdate.this.f259989d.getPreferences().edit().putString("profileLabelVersion", this.f259992e).commit();
                            ProfileCardLabelUtil.c(file);
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }, 128, null, false);
        }
    }

    public void c(SummaryCardUpdate$SUpdateRsp summaryCardUpdate$SUpdateRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) summaryCardUpdate$SUpdateRsp);
            return;
        }
        if (VasToggle.FEATURE_BATCH_UPDATE.isEnable(true)) {
            return;
        }
        int i3 = summaryCardUpdate$SUpdateRsp.code.get();
        String str = summaryCardUpdate$SUpdateRsp.version.get();
        String str2 = summaryCardUpdate$SUpdateRsp.url.get();
        int i16 = summaryCardUpdate$SUpdateRsp.interv.get();
        summaryCardUpdate$SUpdateRsp.buff.get();
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleFunCallRsp data code=" + i3 + MttLoader.QQBROWSER_PARAMS_VERSION + str + JefsClass.INDEX_URL + str2 + ",interval=" + i16);
        }
        if (i3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate code == 0" + i16);
                return;
            }
            return;
        }
        ReportCenter.f().r("SummaryCardUpdate.EM_RT_FUN_CALL", 100, i3, this.f259989d.getCurrentAccountUin(), VipFunCallConstants.MM_APPID, HardCodeUtil.qqStr(R.string.pdu), true);
    }

    public void d(SummaryCardUpdate$SUpdateRsp summaryCardUpdate$SUpdateRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) summaryCardUpdate$SUpdateRsp);
            return;
        }
        if (VasToggle.FEATURE_BATCH_UPDATE.isEnable(true)) {
            return;
        }
        int i3 = summaryCardUpdate$SUpdateRsp.code.get();
        String str = summaryCardUpdate$SUpdateRsp.version.get();
        String str2 = summaryCardUpdate$SUpdateRsp.url.get();
        int i16 = summaryCardUpdate$SUpdateRsp.interv.get();
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleSpecialCareRsp data code=" + i3 + MttLoader.QQBROWSER_PARAMS_VERSION + str + JefsClass.INDEX_URL + str2 + ",interval=" + i16);
        }
        if (i3 == 0) {
            SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
            String string = sharedPreferences.getString("specialcare_config", "");
            if (i16 >= 0) {
                sharedPreferences.edit().putLong("specialcareCheckUpdateTime", System.currentTimeMillis() + (i16 * 1000)).commit();
            }
            if (str2 != null && !str2.equals(string)) {
                sharedPreferences.edit().putString("specialcare_config", str2).commit();
                sharedPreferences.edit().putBoolean(AppConstants.Preferences.SPECIAL_CARE_RED_POINT_ONE, true).commit();
                sharedPreferences.edit().putBoolean(AppConstants.Preferences.SPECIAL_CARE_RED_POINT_TWO, true).commit();
                if (!VasToggle.BUG_103479615.isEnable(true)) {
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.profile.ProfileCardCheckUpdate.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileCardCheckUpdate.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
                                IQvipSpecialSoundManager specialSoundManager = VasUtil.getService().getSpecialSoundManager();
                                specialSoundManager.updateSpecialSoundConfig();
                                specialSoundManager.parseSpecialSoundConfigFile();
                            }
                        }
                    }, 5, null, true);
                    return;
                }
                return;
            }
            return;
        }
        ReportCenter.f().r("SummaryCardUpdate.EM_RT_SPECIAL_REMIND", 100, i3, this.f259989d.getCurrentAccountUin(), VipFunCallConstants.MM_APPID, HardCodeUtil.qqStr(R.string.pes), true);
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public ReqItem d2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ReqItem) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        if (VasToggle.FEATURE_BATCH_UPDATE.isEnable(true) || !l()) {
            return null;
        }
        SharedPreferences preferences = this.f259989d.getPreferences();
        preferences.edit().putLong("nextCheckUpdateTimeMillis", System.currentTimeMillis() + 3600000).commit();
        String string = preferences.getString("cardTemplateVersion", "0");
        String string2 = preferences.getString("profileLabelVersion", "0");
        String string3 = preferences.getString("profileFuncallVersion", "0");
        String string4 = preferences.getString("WebviewCGIWhitelistVersion", "0");
        ReqItem reqItem = new ReqItem();
        reqItem.eServiceID = 122;
        SummaryCardUpdate$SUpdateReqBatch summaryCardUpdate$SUpdateReqBatch = new SummaryCardUpdate$SUpdateReqBatch();
        if ((1 & this.f259990e) != 0) {
            summaryCardUpdate$SUpdateReqBatch.reqs.add(b(3, string));
        }
        if ((this.f259990e & 2) != 0) {
            summaryCardUpdate$SUpdateReqBatch.reqs.add(b(4, string2));
        }
        if ((this.f259990e & 4) != 0) {
            summaryCardUpdate$SUpdateReqBatch.reqs.add(b(5, string3));
        }
        if ((this.f259990e & 8) != 0) {
            SummaryCardUpdate$SUpdateReq b16 = b(5, string3);
            b16.appname.set("special_remind");
            summaryCardUpdate$SUpdateReqBatch.reqs.add(b16);
        }
        if ((this.f259990e & 16) != 0) {
            SummaryCardUpdate$SUpdateReq b17 = b(6, string4);
            b17.appname.set(MobileQQ.PREF_WHITE_LIST_KEY);
            summaryCardUpdate$SUpdateReqBatch.reqs.add(b17);
        }
        byte[] byteArray = summaryCardUpdate$SUpdateReqBatch.toByteArray();
        int length = byteArray.length;
        int i16 = length + 4;
        byte[] bArr = new byte[i16];
        System.arraycopy(z.d(i16), 0, bArr, 0, 4);
        System.arraycopy(byteArray, 0, bArr, 4, length);
        reqItem.vecParam = bArr;
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "getCheckUpdateItemData uin=" + this.f259989d.getLongAccountUin() + ",cardVersion=" + string + "labelVersion=" + string2 + ",client_version=" + AppSetting.f99551k + ",dataLen=" + i16);
        }
        return reqItem;
    }

    public void e(SummaryCardUpdate$SUpdateRsp summaryCardUpdate$SUpdateRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) summaryCardUpdate$SUpdateRsp);
            return;
        }
        if (VasToggle.FEATURE_BATCH_UPDATE.isEnable(true)) {
            return;
        }
        int i3 = summaryCardUpdate$SUpdateRsp.code.get();
        String str = summaryCardUpdate$SUpdateRsp.version.get();
        String str2 = summaryCardUpdate$SUpdateRsp.url.get();
        int i16 = summaryCardUpdate$SUpdateRsp.interv.get();
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleSummaryLabelRsp data code=" + i3 + MttLoader.QQBROWSER_PARAMS_VERSION + str + JefsClass.INDEX_URL + str2 + ",interval=" + i16);
        }
        if (i3 == 0) {
            SharedPreferences preferences = this.f259989d.getPreferences();
            if (i16 >= 0) {
                preferences.edit().putLong("nextCheckLabelUpdateTimeMillis", System.currentTimeMillis() + (i16 * 1000)).commit();
            }
            if (!preferences.getString("profileLabelVersion", "0").equals(str) && str2 != null) {
                a(str2, str);
                return;
            }
            return;
        }
        ReportCenter.f().r("SummaryCardUpdate.EM_RT_SUMMARY_LABEL", 100, i3, this.f259989d.getCurrentAccountUin(), VipFunCallConstants.MM_APPID, HardCodeUtil.qqStr(R.string.pdz), true);
    }

    public void f(SummaryCardUpdate$SUpdateRsp summaryCardUpdate$SUpdateRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) summaryCardUpdate$SUpdateRsp);
            return;
        }
        if (VasToggle.FEATURE_BATCH_UPDATE.isEnable(true)) {
            return;
        }
        int i3 = summaryCardUpdate$SUpdateRsp.code.get();
        String str = summaryCardUpdate$SUpdateRsp.version.get();
        String str2 = summaryCardUpdate$SUpdateRsp.url.get();
        int i16 = summaryCardUpdate$SUpdateRsp.interv.get();
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleSummaryUpdateRsp data code=" + i3 + MttLoader.QQBROWSER_PARAMS_VERSION + str + JefsClass.INDEX_URL + str2 + ",interval=" + i16);
        }
        if (i3 == 0) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && i16 >= 0) {
                SharedPreferences.Editor edit = this.f259989d.getPreferences().edit();
                edit.putLong("nextCheckUpdateTimeMillis", System.currentTimeMillis() + (i16 * 1000));
                edit.putString("cardTemplateServerUrl", str2);
                edit.putString("cardTemplateServerVersion", str);
                edit.commit();
                return;
            }
            return;
        }
        ReportCenter.f().r("SummaryCardUpdate.EM_RT_SUMMARY_UPDATE", 100, i3, this.f259989d.getCurrentAccountUin(), VipFunCallConstants.MM_APPID, HardCodeUtil.qqStr(R.string.pei), true);
    }

    public void g(SummaryCardUpdate$SUpdateRsp summaryCardUpdate$SUpdateRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) summaryCardUpdate$SUpdateRsp);
        }
    }

    public boolean l() {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        boolean h16 = h();
        boolean j3 = j();
        boolean i19 = i();
        boolean k3 = k();
        boolean m3 = m();
        int i26 = this.f259990e | (h16 ? 1 : 0);
        this.f259990e = i26;
        if (!j3) {
            i18 = 0;
        }
        int i27 = i18 | i26;
        this.f259990e = i27;
        if (i19) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        int i28 = i27 | i3;
        this.f259990e = i28;
        if (k3) {
            i16 = 8;
        } else {
            i16 = 0;
        }
        int i29 = i28 | i16;
        this.f259990e = i29;
        if (m3) {
            i17 = 16;
        } else {
            i17 = 0;
        }
        this.f259990e = i29 | i17;
        if (!h16 && !j3 && !i19 && !k3 && !m3) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public void l2(RespItem respItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) respItem);
            return;
        }
        if (VasToggle.FEATURE_BATCH_UPDATE.isEnable(true)) {
            return;
        }
        if (respItem != null) {
            byte b16 = respItem.cResult;
            byte[] bArr = respItem.vecUpdate;
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "handleCheckUpdateItemData result=" + ((int) b16) + ",dataLen=" + bArr.length);
            }
            if (b16 == 2) {
                try {
                    if (bArr.length > 4) {
                        int longData = ((int) PkgTools.getLongData(bArr, 0)) - 4;
                        byte[] bArr2 = new byte[longData];
                        PkgTools.copyData(bArr2, 0, bArr, 4, longData);
                        SummaryCardUpdate$SUpdateRspBatch summaryCardUpdate$SUpdateRspBatch = new SummaryCardUpdate$SUpdateRspBatch();
                        summaryCardUpdate$SUpdateRspBatch.mergeFrom(bArr2);
                        if (summaryCardUpdate$SUpdateRspBatch.rsps.size() < 0) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate SUpdateRspBatch have no rsp");
                                return;
                            }
                            return;
                        }
                        for (SummaryCardUpdate$SUpdateRsp summaryCardUpdate$SUpdateRsp : summaryCardUpdate$SUpdateRspBatch.rsps.get()) {
                            if (summaryCardUpdate$SUpdateRsp != null) {
                                int i3 = summaryCardUpdate$SUpdateRsp.cmd.get();
                                if (i3 == 3) {
                                    f(summaryCardUpdate$SUpdateRsp);
                                } else if (i3 == 4) {
                                    e(summaryCardUpdate$SUpdateRsp);
                                } else if (i3 == 5) {
                                    PBStringField pBStringField = summaryCardUpdate$SUpdateRsp.appname;
                                    if (pBStringField != null && pBStringField.get().equals("special_remind")) {
                                        d(summaryCardUpdate$SUpdateRsp);
                                    } else {
                                        c(summaryCardUpdate$SUpdateRsp);
                                    }
                                } else if (i3 == 6) {
                                    g(summaryCardUpdate$SUpdateRsp);
                                }
                            }
                        }
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate Exception msg=" + e16.getMessage());
                    }
                    e16.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleCheckUpdateItemData respitem is null");
        }
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public int w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return 3;
    }
}

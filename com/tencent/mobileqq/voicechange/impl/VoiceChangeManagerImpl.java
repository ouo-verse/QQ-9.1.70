package com.tencent.mobileqq.voicechange.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.temp.api.IVoiceChangeTempApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.voicechange.IVoiceChangeHelper;
import com.tencent.mobileqq.voicechange.IVoiceChangeManager;
import com.tencent.mobileqq.voicechange.IVoiceTuneUtil;
import com.tencent.mobileqq.voicechange.QQVoiceChangerThread;
import com.tencent.mobileqq.voicechange.d;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.audio.l;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VoiceChangeManagerImpl implements IVoiceChangeManager {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "VoiceChangeManager";
    public static String[] TagIconURLs;
    public String VOICECHANGE_ROOT_DIR;
    ArrayList<String> mUrlList;
    f picDownloadListener;
    public HashMap<String, com.tencent.mobileqq.voicechange.f> taskStateRecord;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VoiceChangeManagerImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
                return;
            }
            if (gVar == null) {
                if (VoiceChangeManagerImpl.this.mUrlList.size() > 0) {
                    String remove = VoiceChangeManagerImpl.this.mUrlList.remove(0);
                    if (QLog.isColorLevel()) {
                        QLog.d(VoiceChangeManagerImpl.TAG, 2, "picDownloadListener mUrlList.size()=" + VoiceChangeManagerImpl.this.mUrlList.size() + ", url=" + remove);
                    }
                    if (TextUtils.isEmpty(remove)) {
                        QLog.e(VoiceChangeManagerImpl.TAG, 1, "picDownloadListener url = null");
                        onDone(null);
                        return;
                    }
                    File file = new File(VoiceChangeManagerImpl.this.getVoiceChangeRootDir() + remove.substring(remove.lastIndexOf("/") + 1));
                    if (file.isFile() && file.exists()) {
                        if (QLog.isColorLevel()) {
                            QLog.d(VoiceChangeManagerImpl.TAG, 2, "picDownloadListener  file.exists()");
                        }
                        onDone(null);
                        return;
                    } else {
                        Bundle bundle = new Bundle();
                        g gVar2 = new g(remove, file);
                        gVar2.Q = true;
                        ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(1).startDownload(gVar2, VoiceChangeManagerImpl.this.picDownloadListener, bundle);
                        return;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(VoiceChangeManagerImpl.TAG, 2, "picDownloadListener mUrlList.size() = 0");
                    return;
                }
                return;
            }
            super.onDone(gVar);
            gVar.h();
            if (gVar.i() == 3 && gVar.f313006d == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(VoiceChangeManagerImpl.TAG, 2, "picDownloadListener downloadOk task.key = " + gVar.f313004c);
                }
            } else {
                QLog.e(VoiceChangeManagerImpl.TAG, 1, "picDownloadListener download Error task.key = " + gVar.f313004c);
            }
            onDone(null);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46761);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            TagIconURLs = new String[]{null, null, null};
        }
    }

    public VoiceChangeManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.taskStateRecord = new HashMap<>();
        this.mUrlList = new ArrayList<>();
        this.picDownloadListener = new a();
    }

    private void deleteOtherTmpFilesOnFeatureIfNeeded(String str, String str2, int i3, Runnable runnable) {
        if (l.a()) {
            ((IVoiceTuneUtil) QRoute.api(IVoiceTuneUtil.class)).asyncDeleteOtherTmpFile(str, str2, i3, runnable);
        } else {
            ((IVoiceTuneUtil) QRoute.api(IVoiceTuneUtil.class)).deleteOtherTmpFiles(str, str2, i3);
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queryStateByPath$0(String str, IVoiceChangeHelper.a aVar, com.tencent.mobileqq.voicechange.f fVar) {
        this.taskStateRecord.remove(str);
        aVar.onCompressFinished(str, fVar.f313162a.f313143f, fVar.f313165d);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "queryStateByPath onCompressFinished filePath=" + str + " time=" + fVar.f313165d + " voiceType=" + fVar.f313162a.f313143f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$voiceChangeEnd$1(com.tencent.mobileqq.voicechange.f fVar, String str, int i3, int i16, int i17) {
        fVar.f313167f.onCompressFinished(str, i3, i16);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "finishedCompress onCompressFinished filePath=" + str + " time=" + i16 + " changeType=" + i17);
        }
        this.taskStateRecord.remove(str);
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceChangeManager
    public String getTagIconURL(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        if (i3 >= 0) {
            String[] strArr = TagIconURLs;
            if (i3 < strArr.length) {
                return strArr[i3];
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceChangeManager
    public String getVoiceChangeRootDir() {
        String absolutePath;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.VOICECHANGE_ROOT_DIR == null) {
            File externalFilesDir = BaseApplication.getContext().getExternalFilesDir(null);
            if (externalFilesDir != null) {
                absolutePath = externalFilesDir.getParent();
            } else {
                absolutePath = BaseApplication.getContext().getFilesDir().getAbsolutePath();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(absolutePath);
            String str = File.separator;
            sb5.append(str);
            sb5.append("Tencent");
            sb5.append(str);
            sb5.append("MobileQQ");
            sb5.append(str);
            sb5.append("voiceChange");
            sb5.append(str);
            this.VOICECHANGE_ROOT_DIR = sb5.toString();
        }
        return this.VOICECHANGE_ROOT_DIR;
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceChangeManager
    public boolean isVoiceChangeFinished(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isVoiceChangeFinished called path=" + str);
        }
        com.tencent.mobileqq.voicechange.f fVar = this.taskStateRecord.get(str);
        if (fVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "no task path=" + str);
                return false;
            }
            return false;
        }
        return fVar.f313166e;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x024e A[Catch: Exception -> 0x0303, TryCatch #1 {Exception -> 0x0303, blocks: (B:43:0x00e4, B:45:0x00ec, B:47:0x00f6, B:49:0x00fc, B:54:0x010b, B:56:0x0111, B:59:0x0149, B:66:0x0154, B:68:0x015f, B:69:0x017b, B:70:0x0192, B:72:0x0195, B:78:0x01a1, B:80:0x01a7, B:85:0x01cf, B:87:0x01d9, B:89:0x01df, B:90:0x01fc, B:92:0x0202, B:94:0x020a, B:96:0x0210, B:98:0x0224, B:100:0x022a, B:103:0x024e, B:104:0x0252, B:106:0x0258, B:110:0x0262, B:112:0x026f, B:135:0x0279, B:74:0x019a), top: B:42:0x00e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0252 A[Catch: Exception -> 0x0303, TryCatch #1 {Exception -> 0x0303, blocks: (B:43:0x00e4, B:45:0x00ec, B:47:0x00f6, B:49:0x00fc, B:54:0x010b, B:56:0x0111, B:59:0x0149, B:66:0x0154, B:68:0x015f, B:69:0x017b, B:70:0x0192, B:72:0x0195, B:78:0x01a1, B:80:0x01a7, B:85:0x01cf, B:87:0x01d9, B:89:0x01df, B:90:0x01fc, B:92:0x0202, B:94:0x020a, B:96:0x0210, B:98:0x0224, B:100:0x022a, B:103:0x024e, B:104:0x0252, B:106:0x0258, B:110:0x0262, B:112:0x026f, B:135:0x0279, B:74:0x019a), top: B:42:0x00e4 }] */
    @Override // com.tencent.mobileqq.voicechange.IVoiceChangeManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean preCheckData(ArrayList<com.tencent.mobileqq.voicechange.c> arrayList, JSONObject jSONObject, AppRuntime appRuntime) {
        String str;
        boolean z16;
        JSONObject jSONObject2;
        boolean z17;
        int i3;
        JSONObject jSONObject3;
        String str2;
        String str3;
        String str4;
        String str5;
        int[] iArr;
        String str6;
        String str7;
        com.tencent.mobileqq.voicechange.c cVar;
        int i16;
        int i17;
        int i18;
        String str8;
        int i19;
        int i26;
        String string;
        String string2;
        String str9;
        VoiceChangeManagerImpl voiceChangeManagerImpl = this;
        ArrayList<com.tencent.mobileqq.voicechange.c> arrayList2 = arrayList;
        String str10 = "tag";
        String str11 = VipFunCallConstants.KEY_FEET_TYPE;
        String str12 = ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY;
        String str13 = "operationInfo";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, arrayList, jSONObject, appRuntime)).booleanValue();
        }
        if (appRuntime == null) {
            return false;
        }
        File file = new File(getVoiceChangeRootDir());
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "preCheckData start");
        }
        if (jSONObject == null) {
            str = "description";
            z16 = false;
            jSONObject2 = VasUpdateUtil.getJSONFromLocal(appRuntime, VasUpdateConstants.SCID_CHANGEVOICE, false, null);
        } else {
            str = "description";
            z16 = false;
            jSONObject2 = jSONObject;
        }
        int[] iArr2 = IVoiceTuneUtil.VOICE_TYPES;
        if (jSONObject2 == null) {
            QLog.e(TAG, 1, "preCheckData null == xydata");
            return z16;
        }
        try {
            int[] iArr3 = iArr2;
            long optLong = jSONObject2.optLong("timestamp", 0L);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            JSONArray jSONArray = jSONObject2.getJSONArray("VoiceChangeModels");
            String str14 = "name";
            JSONObject jSONObject4 = jSONObject2;
            int i27 = 0;
            while (i27 < jSONArray.length()) {
                JSONObject jSONObject5 = jSONArray.getJSONObject(i27);
                JSONArray jSONArray2 = jSONArray;
                if (jSONObject5 != null && jSONObject5.getJSONArray("baseInfo") != null) {
                    String str15 = str10;
                    str2 = str11;
                    if (jSONObject5.getJSONArray("baseInfo").getJSONObject(0) != null && jSONObject5.getJSONArray(str13) != null) {
                        JSONArray jSONArray3 = jSONObject5.getJSONArray(str13);
                        int i28 = 0;
                        JSONObject jSONObject6 = null;
                        while (true) {
                            try {
                                int i29 = -1;
                                if (i28 >= jSONArray3.length()) {
                                    break;
                                }
                                JSONObject jSONObject7 = jSONObject5.getJSONArray(str13).getJSONObject(i28);
                                if (jSONObject7 != null && jSONObject7.has(str12)) {
                                    i29 = jSONObject7.getInt(str12);
                                }
                                JSONArray jSONArray4 = jSONArray3;
                                int i36 = i29;
                                jSONObject6 = jSONObject7;
                                if (i36 != 0 && i36 != 2) {
                                    if (QLog.isColorLevel()) {
                                        StringBuilder sb5 = new StringBuilder();
                                        str9 = str12;
                                        sb5.append("preCheckData continue platformId=");
                                        sb5.append(i36);
                                        sb5.append(", i=");
                                        sb5.append(i27);
                                        sb5.append(", timestamp:");
                                        sb5.append(optLong);
                                        sb5.append(", o=");
                                        sb5.append(i28);
                                        QLog.d(TAG, 2, sb5.toString());
                                    } else {
                                        str9 = str12;
                                    }
                                    jSONObject6 = null;
                                } else {
                                    str9 = str12;
                                }
                                i28++;
                                jSONArray3 = jSONArray4;
                                str12 = str9;
                            } catch (Exception e16) {
                                e = e16;
                                voiceChangeManagerImpl = this;
                                z17 = true;
                                QLog.e(TAG, 1, "preCheckData jsonEx:" + e.getMessage());
                                voiceChangeManagerImpl.picDownloadListener.onDone(null);
                                return z17;
                            }
                        }
                        str3 = str12;
                        if (jSONObject6 == null) {
                            jSONObject6 = new JSONObject();
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "preCheckData continue null == itemJsonOpera, i=" + i27 + ", timestamp:" + optLong);
                            }
                        }
                        JSONObject jSONObject8 = jSONObject6;
                        JSONObject jSONObject9 = jSONObject5.getJSONArray("baseInfo").getJSONObject(0);
                        int i37 = jSONObject9.getInt("voiceID");
                        int i38 = 6;
                        iArr = iArr3;
                        str4 = str13;
                        while (true) {
                            if (i38 < iArr.length) {
                                if (iArr[i38] == i37) {
                                    break;
                                }
                                i38++;
                            } else {
                                i38 = -1;
                                break;
                            }
                        }
                        if (i38 < 0) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "preCheckData not in VOICE_TYPES[] out:i=" + i27 + ", timestamp:" + optLong);
                            }
                        } else {
                            if (arrayList2 != null) {
                                cVar = arrayList2.get(i38);
                            } else {
                                cVar = null;
                            }
                            if (cVar == null) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "preCheckData null == voiceChangeData out:i=" + i27 + ", timestamp:" + optLong);
                                }
                            } else {
                                if (jSONObject8.has(ViewStickEventHelper.IS_SHOW)) {
                                    i16 = jSONObject8.getInt(ViewStickEventHelper.IS_SHOW);
                                } else {
                                    i16 = 2;
                                }
                                if (i16 != 0 && jSONObject8.has("QQVersion")) {
                                    i17 = i16;
                                    if (((IVoiceChangeTempApi) QRoute.api(IVoiceChangeTempApi.class)).isLaterVersion(jSONObject8.getString("QQVersion"), AppSetting.f99551k)) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d(TAG, 2, "preCheckData Version out:i=" + i27 + ", timestamp:" + optLong);
                                        }
                                        i18 = 0;
                                        if (i18 != 0) {
                                            cVar.f313148d = i18;
                                        } else {
                                            if (jSONObject8.has("isEnable")) {
                                                if (jSONObject8.getInt("isEnable") == 1) {
                                                    i18 = 2;
                                                } else {
                                                    i18 = 1;
                                                }
                                            }
                                            String string3 = jSONObject9.getString("icon");
                                            if (TextUtils.isEmpty(string3)) {
                                                QLog.e(TAG, 1, "preCheckData url Error null:");
                                                voiceChangeManagerImpl = this;
                                            } else {
                                                string3 = ((IVoiceChangeTempApi) QRoute.api(IVoiceChangeTempApi.class)).getContentPicHost() + string3;
                                                voiceChangeManagerImpl = this;
                                                if (!voiceChangeManagerImpl.mUrlList.contains(string3)) {
                                                    voiceChangeManagerImpl.mUrlList.add(string3);
                                                }
                                            }
                                            cVar.f313148d = i18;
                                            if (1 == i18) {
                                                cVar.f313150f = 1;
                                                cVar.f313149e = 0;
                                                str6 = str15;
                                                str8 = str2;
                                            } else {
                                                str8 = str2;
                                                if (jSONObject8.has(str8)) {
                                                    i19 = jSONObject8.getInt(str8);
                                                } else {
                                                    i19 = 1;
                                                }
                                                cVar.f313150f = i19;
                                                str6 = str15;
                                                if (jSONObject8.has(str6)) {
                                                    i26 = jSONObject8.getInt(str6);
                                                } else {
                                                    i26 = 0;
                                                }
                                                cVar.f313149e = i26;
                                            }
                                            str7 = str14;
                                            if (TextUtils.isEmpty(jSONObject9.getString(str7))) {
                                                str2 = str8;
                                                string = cVar.f313146b;
                                            } else {
                                                str2 = str8;
                                                string = jSONObject9.getString(str7);
                                            }
                                            cVar.f313146b = string;
                                            str5 = str;
                                            if (TextUtils.isEmpty(jSONObject9.getString(str5))) {
                                                string2 = cVar.f313147c;
                                            } else {
                                                string2 = jSONObject9.getString(str5);
                                            }
                                            cVar.f313147c = string2;
                                            cVar.f313151g.f313152a = string3;
                                            i27++;
                                            str = str5;
                                            str14 = str7;
                                            iArr3 = iArr;
                                            str10 = str6;
                                            jSONArray = jSONArray2;
                                            str11 = str2;
                                            str13 = str4;
                                            str12 = str3;
                                            arrayList2 = arrayList;
                                        }
                                    }
                                } else {
                                    i17 = i16;
                                }
                                i18 = i17;
                                if (i18 != 0) {
                                }
                            }
                        }
                        voiceChangeManagerImpl = this;
                        str5 = str;
                        str7 = str14;
                        str6 = str15;
                        i27++;
                        str = str5;
                        str14 = str7;
                        iArr3 = iArr;
                        str10 = str6;
                        jSONArray = jSONArray2;
                        str11 = str2;
                        str13 = str4;
                        str12 = str3;
                        arrayList2 = arrayList;
                    }
                    str3 = str12;
                    str4 = str13;
                    str5 = str;
                    str7 = str14;
                    str6 = str15;
                    iArr = iArr3;
                } else {
                    str2 = str11;
                    str3 = str12;
                    str4 = str13;
                    str5 = str;
                    iArr = iArr3;
                    str6 = str10;
                    str7 = str14;
                }
                QLog.e(TAG, 1, "preCheckData JsonErr:i=" + i27 + ", timestamp:" + optLong);
                i27++;
                str = str5;
                str14 = str7;
                iArr3 = iArr;
                str10 = str6;
                jSONArray = jSONArray2;
                str11 = str2;
                str13 = str4;
                str12 = str3;
                arrayList2 = arrayList;
            }
            if (TextUtils.isEmpty(TagIconURLs[0]) || TextUtils.isEmpty(TagIconURLs[1]) || TextUtils.isEmpty(TagIconURLs[2])) {
                JSONArray jSONArray5 = jSONObject4.getJSONArray("commmonData");
                if (jSONArray5 != null) {
                    i3 = 0;
                    jSONObject3 = jSONArray5.getJSONObject(0);
                } else {
                    i3 = 0;
                    jSONObject3 = null;
                }
                if (jSONObject3 != null) {
                    String[] strArr = {"vipIcon", "svipIcon", "activityIcon"};
                    for (int i39 = i3; i39 < 3; i39++) {
                        JSONObject jSONObject10 = jSONObject3.getJSONObject(strArr[i39]);
                        if (jSONObject10 != null) {
                            String string4 = jSONObject10.getString("src");
                            if (TextUtils.isEmpty(string4)) {
                                QLog.e(TAG, 1, "preCheckData common url Error null:" + strArr[i39]);
                            } else {
                                String str16 = ((IVoiceChangeTempApi) QRoute.api(IVoiceChangeTempApi.class)).getContentPicHost() + string4;
                                if (!voiceChangeManagerImpl.mUrlList.contains(str16)) {
                                    voiceChangeManagerImpl.mUrlList.add(str16);
                                }
                                TagIconURLs[i39] = str16;
                            }
                        }
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "preCheckData run ok");
            }
            z17 = true;
        } catch (Exception e17) {
            e = e17;
        }
        voiceChangeManagerImpl.picDownloadListener.onDone(null);
        return z17;
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceChangeManager
    public synchronized boolean queryStateByPath(final String str, final IVoiceChangeHelper.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) aVar)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "queryStateByPath called path=" + str);
        }
        final com.tencent.mobileqq.voicechange.f fVar = this.taskStateRecord.get(str);
        if (fVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "no task path=" + str);
            }
            return false;
        }
        if (fVar.f313166e) {
            com.tencent.mobileqq.voicechange.b bVar = fVar.f313162a;
            deleteOtherTmpFilesOnFeatureIfNeeded(str, bVar.f313138a, bVar.f313144g, new Runnable() { // from class: com.tencent.mobileqq.voicechange.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    VoiceChangeManagerImpl.this.lambda$queryStateByPath$0(str, aVar, fVar);
                }
            });
        } else {
            fVar.f313167f = aVar;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceChangeManager
    public void requestToCancel(com.tencent.mobileqq.voicechange.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bVar);
            return;
        }
        com.tencent.mobileqq.voicechange.f fVar = this.taskStateRecord.get(bVar.f313138a);
        if (fVar != null) {
            fVar.f313164c.u();
            this.taskStateRecord.remove(bVar.f313138a);
        }
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceChangeManager
    public void requestToPause(com.tencent.mobileqq.voicechange.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bVar);
            return;
        }
        com.tencent.mobileqq.voicechange.f fVar = this.taskStateRecord.get(bVar.f313138a);
        if (fVar != null) {
            fVar.f313164c.G = false;
            this.taskStateRecord.remove(bVar.f313138a);
        }
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceChangeManager
    public void requestToSend(Context context, com.tencent.mobileqq.voicechange.b bVar, String str, com.tencent.mobileqq.voicechange.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            requestToSend(context, bVar, str, aVar, null);
        } else {
            iPatchRedirector.redirect((short) 10, this, context, bVar, str, aVar);
        }
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceChangeManager
    public void requestToStart(Context context, com.tencent.mobileqq.voicechange.b bVar, String str, com.tencent.mobileqq.voicechange.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            requestToStart(context, bVar, str, aVar, d.a());
        } else {
            iPatchRedirector.redirect((short) 12, this, context, bVar, str, aVar);
        }
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceChangeManager
    public void voiceChangeEnd(int i3, final String str, String str2, final int i16, final int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        final int msToSec = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).msToSec(i3);
        final com.tencent.mobileqq.voicechange.f fVar = this.taskStateRecord.get(str);
        QLog.i(TAG, 1, "voiceChangeEnd  filePath:" + str);
        if (fVar != null) {
            if (fVar.f313167f != null) {
                deleteOtherTmpFilesOnFeatureIfNeeded(str, str2, i16, new Runnable() { // from class: com.tencent.mobileqq.voicechange.impl.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        VoiceChangeManagerImpl.this.lambda$voiceChangeEnd$1(fVar, str, i17, msToSec, i16);
                    }
                });
            } else {
                fVar.f313166e = true;
                fVar.f313165d = msToSec;
            }
        }
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceChangeManager
    public void requestToSend(Context context, com.tencent.mobileqq.voicechange.b bVar, String str, com.tencent.mobileqq.voicechange.a aVar, IVoiceChangeHelper.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, context, bVar, str, aVar, aVar2);
            return;
        }
        if (this.taskStateRecord.get(bVar.f313138a) == null) {
            requestToStart(context, bVar, str, aVar);
        }
        com.tencent.mobileqq.voicechange.f fVar = this.taskStateRecord.get(bVar.f313138a);
        if (aVar2 != null) {
            fVar.f313167f = aVar2;
        }
        fVar.f313164c.v();
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceChangeManager
    public void requestToStart(Context context, com.tencent.mobileqq.voicechange.b bVar, String str, com.tencent.mobileqq.voicechange.a aVar, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, context, bVar, str, aVar, dVar);
            return;
        }
        QLog.i(TAG, 1, "requestToStart changeType:" + bVar.f313144g);
        com.tencent.mobileqq.voicechange.f fVar = this.taskStateRecord.get(bVar.f313138a);
        if (fVar != null) {
            fVar.f313164c.G = false;
        }
        com.tencent.mobileqq.voicechange.f fVar2 = new com.tencent.mobileqq.voicechange.f();
        fVar2.f313162a = bVar;
        fVar2.f313163b = dVar;
        fVar2.f313164c = new QQVoiceChangerThread(context, bVar, dVar, str, aVar);
        this.taskStateRecord.put(bVar.f313138a, fVar2);
        fVar2.f313164c.start();
    }
}

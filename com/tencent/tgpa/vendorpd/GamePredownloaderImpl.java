package com.tencent.tgpa.vendorpd;

import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tgpa.vendorpd.GamePredownloader;
import com.tencent.tgpa.vendorpd.a.b;
import com.tencent.tgpa.vendorpd.b.a;
import com.tencent.tgpa.vendorpd.b.d;
import com.tencent.tgpa.vendorpd.b.f;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes26.dex */
class GamePredownloaderImpl implements GamePredownloader {
    static IPatchRedirector $redirector_;
    private static String appChannel;
    private static boolean enableDebug;
    private String apiKey;
    private String apiSecret;
    private String deviceId;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12642);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            appChannel = "default";
            enableDebug = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GamePredownloaderImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private b getRequester() {
        b.C9915b c9915b = new b.C9915b();
        if (enableDebug) {
            f.c("sdk will request the test env, make sure don't do this in the release app!");
            c9915b.a(enableDebug);
        }
        String str = this.apiKey;
        if (str != null && this.apiSecret != null) {
            c9915b.c(str).d(this.apiSecret);
        } else {
            f.d("request params error, ple check the apiKey & apiSecret!");
            c9915b.c("").d("");
        }
        String str2 = this.deviceId;
        if (str2 == null) {
            f.c("request params error, ple check the device id!");
            c9915b.e("");
        } else {
            c9915b.e(str2);
        }
        String str3 = appChannel;
        if (str3 == null) {
            f.d("request params error, ple check the channel!");
            c9915b.b("");
        } else {
            c9915b.b(str3);
        }
        if (a.a() == null) {
            f.d("request params error, ple check the context!");
            c9915b.a("");
        } else {
            c9915b.a(a.a().getPackageName());
        }
        return c9915b.a();
    }

    @Override // com.tencent.tgpa.vendorpd.GamePredownloader
    public int combinePackage(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? combinePackage(context, str, new CombinationInfo(str2, str3, str4, str5, str6)).getCode() : ((Integer) iPatchRedirector.redirect((short) 9, this, context, str, str2, str3, str4, str5, str6)).intValue();
    }

    @Override // com.tencent.tgpa.vendorpd.GamePredownloader
    public void enableDebug(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            enableDebug = z16;
        }
    }

    @Override // com.tencent.tgpa.vendorpd.GamePredownloader
    public void getGameVersionUpdateInfo(Context context, String str, ArrayList<String> arrayList, GameCallback gameCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, str, arrayList, gameCallback);
            return;
        }
        f.a("Start to get game version predownload info.");
        a.a(context);
        appChannel = str;
        getRequester().a(gameCallback).a(context, arrayList);
        f.b("Start to get game version update info , wait for callback.");
    }

    @Override // com.tencent.tgpa.vendorpd.GamePredownloader
    public void reportPreDownladInfo(Context context, HashMap<String, String> hashMap) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) hashMap);
            return;
        }
        a.a(context);
        if (hashMap.containsKey(WadlProxyConsts.CHANNEL) && (str = hashMap.get(WadlProxyConsts.CHANNEL)) != null) {
            appChannel = str;
        }
        hashMap.put("event_name", "PreDownloadFile");
        hashMap.put("load_time", String.valueOf(System.currentTimeMillis() / 1000));
        getRequester().a(hashMap);
    }

    @Override // com.tencent.tgpa.vendorpd.GamePredownloader
    public void setApiKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.apiKey = str;
        }
    }

    @Override // com.tencent.tgpa.vendorpd.GamePredownloader
    public void setApiSecret(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.apiSecret = str;
        }
    }

    @Override // com.tencent.tgpa.vendorpd.GamePredownloader
    public void setDeviceIdentifier(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.deviceId = str;
        }
    }

    @Override // com.tencent.tgpa.vendorpd.GamePredownloader
    public void setLogAble(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            f.a(z16);
        }
    }

    public GamePredownloader.CombinationError combinePackage(Context context, String str, CombinationInfo combinationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (GamePredownloader.CombinationError) iPatchRedirector.redirect((short) 10, this, context, str, combinationInfo);
        }
        f.a("Start to combine predownloaded package.");
        if (context == null) {
            return GamePredownloader.CombinationError.ContextIsNULL;
        }
        if (str == null) {
            return GamePredownloader.CombinationError.ChannelIsNULL;
        }
        if (combinationInfo.cdnUrl == null) {
            return GamePredownloader.CombinationError.CDNUrlOrMD5IsNULL;
        }
        if (combinationInfo.gamePackageName == null) {
            return GamePredownloader.CombinationError.GamePackageNameIsNULL;
        }
        String str2 = combinationInfo.predownFilePath;
        if (str2 == null) {
            return GamePredownloader.CombinationError.PredownFilePathIsNULL;
        }
        if (!d.b(str2)) {
            return GamePredownloader.CombinationError.PredownFilePathNotExsit;
        }
        com.tencent.tgpa.vendorpd.a.a aVar = new com.tencent.tgpa.vendorpd.a.a(combinationInfo);
        aVar.a();
        a.a(context);
        appChannel = str;
        String a16 = getRequester().a(context.getPackageName(), combinationInfo);
        aVar.c();
        GamePredownloader.CombinationError a17 = aVar.a(a16);
        GamePredownloader.CombinationError combinationError = GamePredownloader.CombinationError.Success;
        if (a17 == combinationError) {
            f.a("request combine info success!");
            a17 = aVar.a(a16, combinationInfo);
        } else {
            f.b("request combine info failed. error code: %d", Integer.valueOf(a17.getCode()));
        }
        if (a17 == combinationError) {
            f.a("combine apk success.");
        } else {
            f.b("combine apk failed. error code: %d", Integer.valueOf(a17.getCode()));
        }
        aVar.b();
        HashMap<String, String> d16 = aVar.d();
        d16.put("status", a17 == combinationError ? "0" : "1");
        d16.put("error_code", String.valueOf(a17.getCode()));
        getRequester().a(d16);
        return a17;
    }
}

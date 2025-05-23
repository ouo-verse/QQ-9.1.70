package com.tencent.mobileqq.vfs;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import java.io.File;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet<String> f312451a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashSet<String> f312452b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f312453c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f312454d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f312455e;

    /* renamed from: f, reason: collision with root package name */
    public static String f312456f;

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f312457g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42118);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashSet<String> hashSet = new HashSet<>();
        f312451a = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        f312452b = hashSet2;
        StringBuilder sb5 = new StringBuilder();
        String str = AppConstants.SDCARD_PATH;
        sb5.append(str);
        sb5.append("chatpic");
        String str2 = File.separator;
        sb5.append(str2);
        String sb6 = sb5.toString();
        f312453c = sb6;
        f312454d = str + AppConstants.PATH_URLDRAWABLE_DISKCACHE + str2;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(str);
        sb7.append("vasSplashAD/");
        String sb8 = sb7.toString();
        f312455e = sb8;
        f312456f = str + "ptt" + str2;
        hashSet2.add(str + str2 + "flashchat" + str2);
        hashSet2.add(AppConstants.SDCARD_POKE);
        hashSet2.add(AppConstants.SDCARD_NEW_POKE);
        hashSet2.add(AppConstants.SDCARD_PE);
        hashSet2.add(AppConstants.SDCARD_PATH_EMOJIS);
        StringBuilder sb9 = new StringBuilder();
        String str3 = AppConstants.SDCARD_ROOT;
        sb9.append(str3);
        sb9.append("/tencent/MobileQQ/.troop/pic_effects/");
        hashSet2.add(sb9.toString());
        hashSet2.add(str + ".troop/enter_effects/");
        hashSet2.add(str + AppConstants.PATH_GIFT);
        hashSet2.add(str + "qav/");
        hashSet2.add(str + "new_ptv_template/");
        hashSet2.add(str + "ptv_template/");
        hashSet2.add(str + "funcall/");
        hashSet2.add(str + "pddata/prd/av_redpacket/");
        hashSet2.add(str + "pddata/prd/early");
        hashSet2.add(str + "hotimage/");
        hashSet2.add(str + "pddata/vas/");
        hashSet2.add(str + ".profilecard/");
        hashSet2.add(str + AppConstants.PATH_CUSTOM_HEAD);
        hashSet2.add(str + ".hiboom_font/");
        hashSet2.add(str + ".font_info/");
        hashSet2.add(str + ".font_effect/");
        hashSet2.add(str + ".pendant/");
        hashSet2.add(str + ".vaspoke/");
        hashSet2.add(str + "system_background/");
        hashSet2.add(str + ".CorlorNick/");
        hashSet2.add(str + "custom_background/");
        hashSet2.add(str + AppConstants.PATH_STAR_HEAD);
        hashSet2.add(str + "rbt/");
        hashSet2.add(str + ".vipicon/");
        hashSet2.add(str + "webso/offline/");
        hashSet2.add(str + ".readInjoy/");
        hashSet2.add(sb8);
        hashSet2.add(AppConstants.SDCARD_SHORTVIDEO_SAVE);
        hashSet2.add(str3 + "/Tencent/ReaderZone/style/");
        hashSet2.add(str3 + "/Tencent/ReaderZone/font/");
        hashSet2.add(str + ".apollo/");
        hashSet2.add(str + "DoutuRes" + str2);
        hashSet2.add(str3 + "/tencent/TMAssistantSDK/Download/com.tencent.mobileqq" + str2);
        StringBuilder sb10 = new StringBuilder();
        sb10.append(str3);
        sb10.append(PreDownloadConstants.SDCRAD_DIR);
        hashSet2.add(sb10.toString());
        hashSet2.add(str3 + "/tencent/MobileQQ/pddata/APP/offline/html5/");
        hashSet2.add(str3 + "/tencent/MobileQQ/pddata/APP/offline/tmp/");
        hashSet2.add(str3 + "/tencent/MobileQQ/ShareScreenShots");
        hashSet2.add(str + "status_ic");
        hashSet2.add(str + "troopgamecard/res/");
        hashSet.add(str + AppConstants.PATH_URLDRAWABLE_DISKCACHE + str2);
        hashSet.add(sb6);
        hashSet.add(str + "photo/");
        hashSet.add(str + "thumb/");
        hashSet.add(str + "shortvideo" + str2);
        hashSet.add(f312456f);
        hashSet.add(AppConstants.SUBSCRIBE_DRAFT);
        hashSet.add(AppConstants.SUBSCRIBE_DRAFT_SIMPLE);
        hashSet.add(str3 + "/Tencent/QQfile_recv/");
        hashSet.add(AppConstants.SDCARD_HOMEWORK_AUDIO);
        hashSet.add(AppConstants.SDCARD_HOMEWORK_ATTACH);
        hashSet.add(str + ".Rock" + str2);
        StringBuilder sb11 = new StringBuilder();
        sb11.append(str3);
        sb11.append("/Tencent/QQ_Collection/");
        hashSet.add(sb11.toString());
        f312457g = new String[]{str + "keyword_emotion", str + ".sticker_recommended_pics", str3 + "/Tencent/QQ_CameraEmo", str + ".diy", str + "Scribble", str + ".emotionsm", str3 + "/Tencent/QQ_Favorite", str + "hotpic", str + "hugeimagecache", str + "ArkApp", str + AppConstants.SDCARD_PATH_ZHITU, str + "msgbackup", str + "qqmusic", str + "aio_long_shot", str + "tim_theme_aio", str + "qim_theme_aio", str + "nativemem", str + "pddata/prd/ar_promotion", str + "pddata/app/offline/html5", str + "iar", str3 + "/AVReportCenter"};
    }
}

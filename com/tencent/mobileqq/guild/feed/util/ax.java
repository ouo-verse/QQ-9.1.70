package com.tencent.mobileqq.guild.feed.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import androidx.fragment.app.Fragment;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.IocPromise;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.dt.api.ScanPicData;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.feed.FeedImpeachData;
import com.tencent.mobileqq.guild.feed.feedsquare.data.SectionInfo;
import com.tencent.mobileqq.guild.feed.fragment.GuildEmojiTransFragment;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedTroopInitBean;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameManager;
import com.tencent.mobileqq.guild.quiprofile.GuildActivityWrapper;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.utils.cg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProInteraction;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.util.URLUtil;
import h44.OpenRobotProfileCardArgs;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ax {

    /* renamed from: d, reason: collision with root package name */
    private static SimpleDateFormat f223857d;

    /* renamed from: a, reason: collision with root package name */
    private static final SimpleDateFormat f223854a = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_MINUTES_FORMAT);

    /* renamed from: b, reason: collision with root package name */
    private static final String f223855b = TimeZone.getDefault().getID();

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f223856c = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public static final int f223858e = w.a("qqguild", "guild_sort_mode", 1).intValue();

    public static <T> IocPromise<T> A(Class<T> cls, View view) {
        if (cls != null && view != null) {
            return RFWIocAbilityProvider.g().getIoc(cls).originView(view);
        }
        return null;
    }

    public static int B(long j3, long j16) {
        long j17 = j16 - j3;
        if (j17 < 60000) {
            return 1;
        }
        if (j17 < 3600000) {
            return 2;
        }
        if (j17 < 86400000) {
            return 3;
        }
        if (j17 < 604800000) {
            return 4;
        }
        return 6;
    }

    private static int C(Context context) {
        int instantScreenWidth = DisplayUtil.getInstantScreenWidth(context);
        int instantScreenHeight = DisplayUtil.getInstantScreenHeight(context);
        if (!mk1.e.g()) {
            return Math.max(instantScreenWidth, instantScreenHeight);
        }
        return instantScreenHeight;
    }

    private static int D(Context context) {
        int instantScreenWidth = DisplayUtil.getInstantScreenWidth(context);
        int instantScreenHeight = DisplayUtil.getInstantScreenHeight(context);
        if (!mk1.e.g()) {
            return Math.min(instantScreenWidth, instantScreenHeight);
        }
        return instantScreenWidth;
    }

    public static boolean E(long j3) {
        if (j3 == 10027) {
            return true;
        }
        return false;
    }

    public static boolean F(long j3) {
        if (j3 != 10009 && j3 != 10047) {
            return false;
        }
        return true;
    }

    public static boolean G(GuildFeedBaseInitBean guildFeedBaseInitBean) {
        if (guildFeedBaseInitBean == null) {
            return false;
        }
        return guildFeedBaseInitBean instanceof GuildFeedTroopInitBean;
    }

    public static boolean H(String str) {
        return cg.f307525d.matcher(str).matches();
    }

    public static void I(Activity activity, String str, String str2, String str3, String str4, int i3, JumpGuildParam.JoinInfoParam joinInfoParam) {
        GuildProfileData guildProfileData = new GuildProfileData(str, "", str3, 0, 7);
        guildProfileData.getGuildBaseProfileData().r(str2);
        if (joinInfoParam != null && i3 > 0 && !TextUtils.isEmpty(joinInfoParam.getMainSource()) && !TextUtils.isEmpty(joinInfoParam.getSubSource())) {
            guildProfileData.getGuildBaseProfileData().z(joinInfoParam.getMainSource());
            guildProfileData.getGuildBaseProfileData().E(joinInfoParam.getSubSource());
        }
        if (!TextUtils.isEmpty(str4)) {
            guildProfileData.setFeedImpeachData(new FeedImpeachData(0, str4, "", ""));
        }
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildProfileDialog(activity, guildProfileData);
    }

    public static <T> void J(@Nullable T t16, Consumer<T> consumer) {
        if (t16 == null) {
            QLog.w("GuildFeedUtils", 1, "optional is null, consumer=" + consumer.getClass().getCanonicalName());
            return;
        }
        consumer.accept(t16);
    }

    public static void K(Activity activity, GuildFeedBaseInitBean guildFeedBaseInitBean) {
        if (activity != null && activity.getIntent() != null) {
            activity.getIntent().putExtra(com.tencent.mobileqq.guild.feed.b.f218115a, guildFeedBaseInitBean);
        }
    }

    public static void L(Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtra(com.tencent.mobileqq.guild.feed.b.f218116b, bundle);
        }
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("guild_emoji_source_from", "guild_emoji_source_from_feed_detail");
        intent.addFlags(268435456);
        QPublicTransFragmentActivity.start(BaseApplication.getContext(), intent, GuildEmojiTransFragment.class);
    }

    public static void M(String str, String str2) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        BaseApplication context = BaseApplication.getContext();
        if (((ITroopRobotService) peekAppRuntime.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(str2)) {
            ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).openRobotProfileCard(new OpenRobotProfileCardArgs(context, str2, str, 10, 0, null));
        } else {
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).openTroopmemberCard(peekAppRuntime, context, str, str2, -1, -1, null);
        }
    }

    public static String a(String str) {
        return URLUtil.addParameter(URLUtil.addParameter(URLUtil.addParameter(str, "_wv", String.valueOf(16777223L)), "_wwv", String.valueOf(193L)), "_fv", String.valueOf(0L));
    }

    public static String b(String str) {
        return URLUtil.addParameter(URLUtil.addParameter(str, "_wv", String.valueOf(4099L)), "_wwv", String.valueOf(192L));
    }

    public static void c(View view, int i3, int i16) {
        if (view != null && i3 != 0 && i16 != 0) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int width = viewGroup.getWidth();
            int height = viewGroup.getHeight();
            float f16 = i3 / i16;
            float f17 = width / f16;
            float f18 = height;
            if (f17 > f18) {
                width = (int) (f18 * f16);
            } else {
                height = (int) f17;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            view.setLayoutParams(layoutParams);
            return;
        }
        QLog.d("GuildFeedUtils", 1, "[adjustViewSizeFromParent] input parameter error");
    }

    public static int d(View view, int i3, int i16) {
        int intValue;
        int intValue2;
        if (i16 != 0 && i3 != 0) {
            BaseApplication context = BaseApplication.getContext();
            if (i(context)) {
                QLog.d("GuildFeedUtils", 1, "adjust video size, screen size error. ");
                DisplayUtil.init(context);
            }
            int D = D(context);
            int C = C(context);
            QLog.i("GuildFeedUtils", 1, String.format("[printVideoViewSize]  orientation=%d, screenWidth=%d, screenHeight=%d", Integer.valueOf(context.getResources().getConfiguration().orientation), Integer.valueOf(D), Integer.valueOf(C)));
            if (i3 == -1 && i16 == -1) {
                intValue2 = -1;
                intValue = -1;
            } else {
                Pair<Integer, Integer> e16 = e(i3, i16, D, C);
                intValue = ((Integer) e16.first).intValue();
                intValue2 = ((Integer) e16.second).intValue();
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(intValue, intValue2);
            }
            layoutParams.width = D;
            layoutParams.height = C;
            layoutParams.gravity = 17;
            if (intValue2 != -1 && intValue != -1) {
                int min = (D - Math.min(intValue, D)) / 2;
                int min2 = (C - Math.min(intValue2, C)) / 2;
                view.setPadding(min, min2, min, min2);
            }
            if (view instanceof ImageView) {
                ((ImageView) view).setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            view.setLayoutParams(layoutParams);
            return intValue2;
        }
        QLog.d("GuildFeedUtils", 1, "setSize origin size zero");
        return 0;
    }

    public static Pair<Integer, Integer> e(int i3, int i16, int i17, int i18) {
        float f16 = i3 * 1.0f;
        float f17 = i16 * 1.0f;
        float max = Math.max(f16 / i17, f17 / i18);
        return new Pair<>(Integer.valueOf((int) (f16 / max)), Integer.valueOf((int) (f17 / max)));
    }

    public static boolean f(GuildFeedBaseInitBean guildFeedBaseInitBean, Activity activity) {
        if (!(activity instanceof QBaseActivity)) {
            QLog.e("GuildFeedUtils", 1, "checkIsCurrentChannel is not QBaseActivity");
            return false;
        }
        QBaseActivity qBaseActivity = (QBaseActivity) activity;
        if (guildFeedBaseInitBean != null && !TextUtils.isEmpty(guildFeedBaseInitBean.getChannelId())) {
            if (guildFeedBaseInitBean.getGuildId().equals(t(qBaseActivity)) && guildFeedBaseInitBean.getChannelId().equals(s(qBaseActivity))) {
                return true;
            }
            return false;
        }
        QLog.e("GuildFeedUtils", 1, "checkIsCurrentChannel mInitBean is null return");
        return false;
    }

    public static boolean g(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("atAllNum");
            int optInt2 = jSONObject.optInt("atOnlineNum");
            int optInt3 = jSONObject.optInt("atRoleNum");
            if (optInt > 0 || optInt2 > 0 || optInt3 > 0) {
                return ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).isNeedInterceptOfAt(str, optInt, optInt2, optInt3);
            }
            return false;
        }
        return false;
    }

    public static boolean h(String str, String str2, List<String> list, List<String> list2) {
        IGuildSpeechApi iGuildSpeechApi = (IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class);
        if (iGuildSpeechApi.isNeedInterceptLink(str, str2)) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (iGuildSpeechApi.containLink(it.next())) {
                    iGuildSpeechApi.showInterceptLinkSendToast();
                    return true;
                }
            }
        }
        Iterator<String> it5 = list.iterator();
        while (it5.hasNext()) {
            if (iGuildSpeechApi.isNeedInterceptKeyword(str, str2, it5.next())) {
                ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).showInterceptKeywordSendToast();
                return true;
            }
        }
        if (list2 != null && !list2.isEmpty() && ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).isNeedInterceptQrCode(str, str2)) {
            Iterator<String> it6 = list2.iterator();
            while (it6.hasNext()) {
                ScannerResult decodeQQCodeFromFile = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(Uri.parse("file://" + new File(it6.next()).getAbsolutePath()), (Context) BaseApplication.getContext(), 3, false);
                if (decodeQQCodeFromFile != null && (decodeQQCodeFromFile.l() || decodeQQCodeFromFile.j())) {
                    ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).showInterceptQrCodeSendToast();
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean i(Context context) {
        boolean z16;
        if (context == null) {
            return false;
        }
        int instantScreenWidth = DisplayUtil.getInstantScreenWidth(context);
        int instantScreenHeight = DisplayUtil.getInstantScreenHeight(context);
        if (instantScreenHeight <= 0 || instantScreenWidth <= 0) {
            return true;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (instantScreenHeight >= instantScreenWidth) {
                return false;
            }
            return true;
        }
        if (instantScreenHeight <= instantScreenWidth) {
            return false;
        }
        return true;
    }

    public static void j(Intent intent, String str, String str2, String str3, String str4) {
        ScanPicData scanPicData = new ScanPicData();
        scanPicData.u(str);
        scanPicData.w(12);
        if (!TextUtils.isEmpty(str2)) {
            scanPicData.v(str2);
        }
        scanPicData.x(str3);
        scanPicData.s(str4);
        intent.putExtra("o3_scan_pic_data", scanPicData);
        QLog.i("GuildFeedUtils", 1, "fillQRSecureData guildId=" + str4 + " posterId=" + str3 + " scanUrl empty " + TextUtils.isEmpty(str2));
    }

    public static String k(long j3) {
        try {
            long j16 = j3 % 60;
            long j17 = (j3 / 60) % 60;
            long j18 = (j3 / 3600) % 24;
            if (j18 > 0) {
                return String.format("%d:%02d:%02d", Long.valueOf(j18), Long.valueOf(j17), Long.valueOf(j16));
            }
            return String.format("%02d:%02d", Long.valueOf(j17), Long.valueOf(j16));
        } catch (Exception e16) {
            QLog.e("TimeStampUtils", 1, e16, new Object[0]);
            return "";
        }
    }

    public static boolean l(int i3) {
        if (i3 != 14 && i3 != 16) {
            return false;
        }
        return true;
    }

    public static AppRuntime m(Context context) {
        if (context instanceof AppActivity) {
            return ((AppActivity) context).getAppRuntime();
        }
        return null;
    }

    public static JSONObject n(int i3, int i16, int i17) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("atAllNum", i3);
            jSONObject.put("atOnlineNum", i16);
            jSONObject.put("atRoleNum", i17);
            return jSONObject;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static GuildFeedBaseInitBean o(Fragment fragment) {
        Intent intent;
        if (fragment == null) {
            return new GuildFeedBaseInitBean();
        }
        Bundle arguments = fragment.getArguments();
        if (arguments != null && arguments.containsKey(com.tencent.mobileqq.guild.feed.b.f218115a)) {
            return (GuildFeedBaseInitBean) arguments.getSerializable(com.tencent.mobileqq.guild.feed.b.f218115a);
        }
        if (fragment.getActivity() != null && (intent = fragment.getActivity().getIntent()) != null && intent.getSerializableExtra(com.tencent.mobileqq.guild.feed.b.f218115a) != null) {
            return (GuildFeedBaseInitBean) intent.getSerializableExtra(com.tencent.mobileqq.guild.feed.b.f218115a);
        }
        return new GuildFeedBaseInitBean();
    }

    @Nullable
    public static String p(xj1.e eVar, String str, int i3) {
        if (eVar == null) {
            QLog.w("GuildFeedUtils", 1, "sectionInfoIoc is null!");
            return null;
        }
        List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> b16 = eVar.b();
        if (b16 != null && !b16.isEmpty()) {
            Iterator<com.tencent.mobileqq.guild.feed.feedsquare.data.l> it = b16.iterator();
            while (it.hasNext()) {
                SectionInfo sectionInfo = it.next().getSectionInfo();
                if (sectionInfo.getType() == i3 && str.equals(sectionInfo.getChannelId())) {
                    return sectionInfo.getName();
                }
            }
        }
        return null;
    }

    public static GuildFeedBaseInitBean q(Context context) {
        Intent intent;
        if (context instanceof GuildActivityWrapper) {
            return q(((GuildActivityWrapper) context).getBase());
        }
        if ((context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null && intent.getSerializableExtra(com.tencent.mobileqq.guild.feed.b.f218115a) != null) {
            return (GuildFeedBaseInitBean) intent.getSerializableExtra(com.tencent.mobileqq.guild.feed.b.f218115a);
        }
        return null;
    }

    public static int r(QBaseActivity qBaseActivity) {
        GuildCenterPanelController f16 = GuildMainFrameManager.f();
        if (f16 != null) {
            return f16.t();
        }
        return -1;
    }

    public static String s(QBaseActivity qBaseActivity) {
        GuildCenterPanelController f16 = GuildMainFrameManager.f();
        if (f16 != null) {
            return f16.x().f227301c;
        }
        return null;
    }

    public static String t(QBaseActivity qBaseActivity) {
        GuildCenterPanelController f16 = GuildMainFrameManager.f();
        if (f16 != null) {
            return f16.x().f227300b;
        }
        return null;
    }

    public static String u() {
        String str;
        String v3 = v();
        if (!TextUtils.isEmpty(v3)) {
            String str2 = f223856c.get(v3);
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        try {
            str = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getSelfTinyId();
        } catch (Exception e16) {
            QLog.e("GuildFeedUtils", 1, "getSelfTinyId. error=" + e16.getMessage());
            str = "";
        }
        if (TextUtils.isEmpty(str) || "0".equals(str)) {
            return "";
        }
        if (!TextUtils.isEmpty(v3)) {
            f223856c.put(v3, str);
        }
        return str;
    }

    public static String v() {
        return ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).appInterface().getAccount();
    }

    public static String w(long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        long j16 = currentTimeMillis - j3;
        int B = B(j3, currentTimeMillis);
        if (B != 1) {
            if (B != 2) {
                if (B != 3) {
                    if (B != 4) {
                        return x(j3, currentTimeMillis);
                    }
                    return ((((j16 / 1000) / 60) / 60) / 24) + HardCodeUtil.qqStr(R.string.f145710s8);
                }
                return (((j16 / 1000) / 60) / 60) + HardCodeUtil.qqStr(R.string.f145680s5);
            }
            return ((j16 / 1000) / 60) + HardCodeUtil.qqStr(R.string.f145690s6);
        }
        return HardCodeUtil.qqStr(R.string.f145700s7);
    }

    public static String x(long j3, long j16) {
        Date date;
        if (f223857d == null) {
            f223857d = new SimpleDateFormat("yy-MM-dd HH:mm");
        }
        SimpleDateFormat simpleDateFormat = f223857d;
        if (j3 == 0) {
            date = new Date();
        } else {
            date = new Date(j3);
        }
        String format = simpleDateFormat.format(date);
        if (TextUtils.isEmpty(format) || format.split(" ").length != 2) {
            return " ";
        }
        String[] split = format.split(" ");
        String str = f223855b;
        Time time = new Time(str);
        time.set(j3);
        Time time2 = new Time(str);
        time2.set(j16);
        if (time.year == time2.year) {
            int i3 = time2.yearDay;
            int i16 = time.yearDay;
            if (i3 == i16) {
                return HardCodeUtil.qqStr(R.string.f157751nr) + " " + split[1];
            }
            if (i16 == i3 - 1) {
                return HardCodeUtil.qqStr(R.string.f158551px) + " " + split[1];
            }
            if (split[0].length() > 3) {
                return split[0].substring(3);
            }
            return format;
        }
        return split[0];
    }

    public static String y(long j3) {
        Object valueOf;
        Object valueOf2;
        Object valueOf3;
        Object valueOf4;
        int i3 = (int) (((float) j3) / 1000.0f);
        int i16 = i3 / 3600;
        int i17 = i3 / 60;
        int i18 = i3 % 60;
        if (i16 > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i16);
            sb5.append(":");
            if (i17 < 10) {
                valueOf3 = "0" + i17;
            } else {
                valueOf3 = Integer.valueOf(i17);
            }
            sb5.append(valueOf3);
            sb5.append(":");
            if (i18 < 10) {
                valueOf4 = "0" + i18;
            } else {
                valueOf4 = Integer.valueOf(i18);
            }
            sb5.append(valueOf4);
            return sb5.toString();
        }
        StringBuilder sb6 = new StringBuilder();
        if (i17 < 10) {
            valueOf = "0" + i17;
        } else {
            valueOf = Integer.valueOf(i17);
        }
        sb6.append(valueOf);
        sb6.append(":");
        if (i18 < 10) {
            valueOf2 = "0" + i18;
        } else {
            valueOf2 = Integer.valueOf(i18);
        }
        sb6.append(valueOf2);
        return sb6.toString();
    }

    public static String z(long j3, long j16, GProInteraction gProInteraction) {
        long max = Math.max(j3, j16) * 1000;
        long j17 = gProInteraction.timestamp * 1000;
        int i3 = gProInteraction.type;
        if (i3 != 1 && i3 != 2) {
            return w(max);
        }
        long currentTimeMillis = System.currentTimeMillis() - j17;
        if (currentTimeMillis > 259200000) {
            return w(max);
        }
        if (currentTimeMillis < 60000) {
            return HardCodeUtil.qqStr(R.string.f145700s7);
        }
        if (currentTimeMillis < 3600000) {
            return (currentTimeMillis / 60000) + HardCodeUtil.qqStr(R.string.f145690s6);
        }
        if (currentTimeMillis < 86400000) {
            return (currentTimeMillis / 3600000) + HardCodeUtil.qqStr(R.string.f145680s5);
        }
        return (currentTimeMillis / 86400000) + HardCodeUtil.qqStr(R.string.f145710s8);
    }
}

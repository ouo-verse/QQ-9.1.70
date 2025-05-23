package com.tencent.mobileqq.guild.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.config.QQGuildMCBean;
import com.tencent.mobileqq.guild.config.QQGuildMCParser;
import com.tencent.mobileqq.guild.message.api.IGuildNicknameApi;
import com.tencent.mobileqq.guild.nt.misc.api.IAppInfoApi;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoActivity;
import com.tencent.mobileqq.guild.util.security.api.ISecurityTipHelper;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.Cdo;
import com.tencent.mobileqq.qqguildsdk.data.GProLocationInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.URLUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.json.JSONException;
import org.json.JSONObject;
import r12.a;

/* compiled from: P */
/* loaded from: classes14.dex */
public class ch {

    /* renamed from: a, reason: collision with root package name */
    public static long f235508a;

    /* renamed from: b, reason: collision with root package name */
    public static final GuildDTReportApiImpl f235509b = new GuildDTReportApiImpl();

    /* renamed from: c, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f235510c = new d();

    /* renamed from: d, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f235511d = new e();

    /* renamed from: e, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f235512e = new f();

    /* renamed from: f, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f235513f = new g();

    /* renamed from: g, reason: collision with root package name */
    private static String f235514g = "";

    /* renamed from: h, reason: collision with root package name */
    private static int f235515h = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.util.security.i f235516d;

        a(com.tencent.mobileqq.guild.util.security.i iVar) {
            this.f235516d = iVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            com.tencent.mobileqq.guild.util.security.i iVar = this.f235516d;
            if (iVar != null) {
                iVar.onClick();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.util.security.i f235517d;

        b(com.tencent.mobileqq.guild.util.security.i iVar) {
            this.f235517d = iVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            com.tencent.mobileqq.guild.util.security.i iVar = this.f235517d;
            if (iVar != null) {
                iVar.onDismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.util.security.i f235518d;

        c(com.tencent.mobileqq.guild.util.security.i iVar) {
            this.f235518d = iVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            com.tencent.mobileqq.guild.util.security.i iVar = this.f235518d;
            if (iVar != null) {
                iVar.onDismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class d implements DownloadParams.DecodeHandler {
        d() {
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            if (QLog.isDevelopLevel()) {
                QLog.d("URLDrawableDecodeHandler", 4, "ROUND_FACE_DECODER");
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 2) {
                    return BaseImageUtil.getRoundedCornerBitmap(bitmap, 0.0f, iArr[0], iArr[1]);
                }
            }
            return BaseImageUtil.getRoundFaceBitmap(bitmap, 50, 50);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class e implements DownloadParams.DecodeHandler {
        e() {
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            if (QLog.isDevelopLevel()) {
                QLog.d("URLDrawableDecodeHandler", 4, "ROUND_6DP_FACE_DECODER");
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 2) {
                    Bitmap roundedCornerBitmap2 = BaseImageUtil.getRoundedCornerBitmap2(bitmap, ViewUtils.dpToPx(6.0f), iArr[0], iArr[1]);
                    QLog.d("URLDrawableDecodeHandler", 4, "tag instanceof int[]\uff0croundParams[0] = " + iArr[0] + ", roundParams[1] = " + iArr[1]);
                    return roundedCornerBitmap2;
                }
            }
            Bitmap roundedCornerBitmap22 = BaseImageUtil.getRoundedCornerBitmap2(bitmap, ViewUtils.dpToPx(6.0f), downloadParams.reqWidth, downloadParams.reqHeight);
            QLog.d("URLDrawableDecodeHandler", 4, "else \uff0creqWidth[0] = " + downloadParams.reqWidth + ", reqHeight[1] = " + downloadParams.reqHeight);
            return roundedCornerBitmap22;
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class f implements DownloadParams.DecodeHandler {
        f() {
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            if (QLog.isDevelopLevel()) {
                QLog.d("URLDrawableDecodeHandler", 4, "ROUND_FACE_DECODER3");
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 3) {
                    return ch.b0(bitmap, iArr[0], iArr[1], iArr[2], 0);
                }
            }
            return BaseImageUtil.getRoundFaceBitmap(bitmap, 50, 50);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class g implements DownloadParams.DecodeHandler {
        g() {
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            if (QLog.isDevelopLevel()) {
                QLog.d("URLDrawableDecodeHandler", 4, "ROUND_FACE_DECODER");
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 2) {
                    return BaseImageUtil.getClipCenterRectBitmap(bitmap, iArr[0], iArr[1]);
                }
            }
            return BaseImageUtil.getClipCenterRectBitmap(bitmap, 50, 50);
        }
    }

    public static String A(IGProUserInfo iGProUserInfo, int i3) {
        if (iGProUserInfo == null) {
            return "";
        }
        String avatarMeta = iGProUserInfo.getAvatarMeta();
        if (TextUtils.isEmpty(avatarMeta)) {
            return "";
        }
        String fullAvatarUrl = ((IGPSService) S0(IGPSService.class, "")).getFullAvatarUrl(new com.tencent.mobileqq.qqguildsdk.data.cw(iGProUserInfo.getTinyId(), avatarMeta), i3);
        if (TextUtils.isEmpty(fullAvatarUrl)) {
            return "";
        }
        return fullAvatarUrl;
    }

    public static boolean A0(String str, Long l3) {
        IGPSService iGPSService = (IGPSService) R0(IGPSService.class);
        ArrayList<Long> guildUserChannelCategoryAdminList = iGPSService.getGuildUserChannelCategoryAdminList(str, iGPSService.getSelfTinyId());
        if (guildUserChannelCategoryAdminList != null && guildUserChannelCategoryAdminList.contains(l3)) {
            return true;
        }
        return false;
    }

    @Nullable
    public static IGProChannelInfo B(String str) {
        return ((IGPSService) m().getRuntimeService(IGPSService.class, "")).getChannelInfo(str);
    }

    public static boolean B0() {
        return new File(SSODebugUtil.SSO_CONF_DIR, SSODebugUtil.SSO_CONF_FILENAME).exists();
    }

    @Nullable
    public static IGProChannelInfo C(AppRuntime appRuntime, String str, String str2) {
        return B(str2);
    }

    public static boolean C0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Long.parseLong(str) <= 0) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            QLog.e("QQGuildUtil", 1, e16, new Object[0]);
            return true;
        }
    }

    public static int D(String str) {
        IGProChannelInfo B = B(str);
        if (B == null) {
            return 0;
        }
        return B.getType();
    }

    public static boolean D0(String str) {
        boolean z16;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        if (!"http".equalsIgnoreCase(parse.getScheme()) && !"https".equalsIgnoreCase(parse.getScheme())) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 || TextUtils.isEmpty(parse.getHost())) {
            return false;
        }
        return true;
    }

    public static com.tencent.mobileqq.guild.config.y E() {
        return (com.tencent.mobileqq.guild.config.y) com.tencent.mobileqq.config.am.s().x(733);
    }

    public static boolean E0() {
        return true;
    }

    public static void F(AppRuntime appRuntime, String str, String str2, INetEngineListener iNetEngineListener) {
        if (appRuntime == null) {
            return;
        }
        try {
            HttpNetReq httpNetReq = new HttpNetReq();
            httpNetReq.mReqUrl = str;
            httpNetReq.mHttpMethod = 0;
            httpNetReq.mOutPath = str2;
            httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
            httpNetReq.mExcuteTimeLimit = 30000L;
            httpNetReq.mCallback = iNetEngineListener;
            ((IHttpEngineService) appRuntime.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        } catch (Exception unused) {
            QLog.e("QQGuildUtil", 1, "download fail, appRuntime null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F0(Activity activity, String str, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        cx.a(activity, str);
    }

    public static IGProChannelInfo G(@NonNull List<IGProChannelInfo> list) {
        for (IGProChannelInfo iGProChannelInfo : list) {
            if (iGProChannelInfo.getType() == 1) {
                return iGProChannelInfo;
            }
        }
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public static String H(AppRuntime appRuntime, String str, String str2) {
        return ((IGuildNicknameApi) QRoute.api(IGuildNicknameApi.class)).getDisplayName(appRuntime, str, str2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H0(int i3, String str) {
        QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), i3, str, 0).show();
    }

    @Nullable
    public static Cdo I() {
        return ((IGPSService) l().getRuntimeService(IGPSService.class, "")).getFaceAuthInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I0(int i3, int i16) {
        QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), i3, i16, 0).show();
    }

    public static Drawable J(String str, int i3, Drawable drawable, boolean z16) {
        return K(str, i3, drawable, z16, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J0(Activity activity, Cdo cdo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        i1(activity, cdo.getVerifyUrl());
        EventCollector.getInstance().onViewClicked(view);
    }

    public static Drawable K(String str, int i3, Drawable drawable, boolean z16, boolean z17) {
        Drawable drawable2;
        URLDrawable uRLDrawable;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (drawable != null) {
            drawable2 = drawable;
        } else {
            drawable2 = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        obtain.mLoadingDrawable = drawable2;
        if (drawable == null) {
            drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        obtain.mFailedDrawable = drawable;
        obtain.mRequestHeight = i3;
        obtain.mRequestWidth = i3;
        obtain.mUseMemoryCache = z17;
        try {
            uRLDrawable = URLDrawable.getDrawable(str, obtain);
            if (z16) {
                try {
                    uRLDrawable.setTag(new int[]{i3, i3});
                    uRLDrawable.setDecodeHandler(f235510c);
                } catch (Exception e16) {
                    e = e16;
                    QLog.e("QQGuildUtil", 1, e, new Object[0]);
                    return uRLDrawable;
                }
            }
        } catch (Exception e17) {
            e = e17;
            uRLDrawable = null;
        }
        return uRLDrawable;
    }

    public static boolean K0() {
        boolean c16 = QQGuildMCParser.INSTANCE.c("100561", "isShowGuildHelpAndFeedback", false);
        if (!c16) {
            QLog.i("QQGuildUtil", 1, "needShowHelpAndFeedback: is false");
        }
        return c16;
    }

    public static IGProGuildInfo L(String str) {
        return ((IGPSService) R0(IGPSService.class)).getGuildInfo(str);
    }

    public static void L0(Context context, String str, String str2, int i3, String str3, int i16) {
        if (i3 <= 0) {
            i3 = 9;
        }
        String v3 = v(str, str2, i3, i16);
        new Bundle().putInt("titleBarStyle", 10);
        cx.a(context, v3);
        QLog.i(str3, 1, "openGuildDetailEmptyH5Page jumpUrl: " + v3);
    }

    public static IGProGuildInfo M(String str) {
        return L(str);
    }

    public static void M0(Context context, String str, String str2, int i3) {
        cx.a(context, URLUtil.addParameter(str, "from", String.valueOf(i3)));
    }

    public static int N() {
        List<IGProGuildInfo> guildList = ((IGPSService) R0(IGPSService.class)).getGuildList();
        if (guildList == null) {
            return 0;
        }
        return guildList.size();
    }

    public static Boolean N0(Context context, @NonNull String str) {
        QLog.i("QQGuildUtil", 2, str);
        Uri parse = Uri.parse(str);
        if (SchemaUtils.SCHEMA_MQQAPI.equals(parse.getScheme())) {
            if (!"hippy".equals(parse.getAuthority())) {
                return Boolean.FALSE;
            }
            if (!"/open".equals(parse.getPath())) {
                return Boolean.FALSE;
            }
            String queryParameter = parse.getQueryParameter("bundleName");
            if (queryParameter == null) {
                return Boolean.FALSE;
            }
            OpenHippyInfo openHippyInfo = new OpenHippyInfo();
            openHippyInfo.bundleName = queryParameter;
            String queryParameter2 = parse.getQueryParameter("url");
            if (queryParameter2 != null) {
                openHippyInfo.url = queryParameter2;
                Z0(queryParameter2, openHippyInfo);
            }
            openHippyInfo.isStatusBarDarkFont = parse.getBooleanQueryParameter(OpenHippyInfo.EXTRA_KEY_IS_STATUSBAR_DARKFONT, true);
            openHippyInfo.isEnbaleRightFling = parse.getBooleanQueryParameter(OpenHippyInfo.EXTRA_KEY_IS_ENABLE_RIGHT_FLING, false);
            openHippyInfo.updateJsBundleType = 1;
            openHippyInfo.isTransparent = parse.getBooleanQueryParameter(OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT, true);
            openHippyInfo.isAnimated = parse.getBooleanQueryParameter(OpenHippyInfo.EXTRA_KEY_IS_ANIMATED, false);
            openHippyInfo.backgroundColor = parse.getQueryParameter("backgroundColor");
            return Boolean.valueOf(((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).openHippyPage(context, openHippyInfo));
        }
        return Boolean.FALSE;
    }

    public static String O() {
        return QQGuildMCParser.INSTANCE.f("100545", "guildMyOrderUrl", "mqqapi://ecommerce/open?target=2&channel=3&src_type=internal&version=1");
    }

    public static void O0(Context context, String str) {
        P0(context, str, new ArrayList(), "");
    }

    public static String P() {
        String g16 = g();
        String versionName = ((IAppInfoApi) QRoute.api(IAppInfoApi.class)).getVersionName();
        String d16 = zu1.a.d();
        return URLUtil.addParameterWithoutEncode(URLUtil.addParameterWithoutEncode(URLUtil.addParameterWithoutEncode(bs.d(), "uin", g16), "version", versionName), "device", "Android_" + d16);
    }

    public static void P0(Context context, String str, ArrayList<String> arrayList, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("channelId", "0");
        bundle.putString("guildId", str);
        bundle.putInt("robotType", 0);
        bundle.putStringArrayList("robot_uins", arrayList);
        bundle.putString("openRobotProfileCardRobotUin", str2);
        Intent intent = new Intent(context, (Class<?>) RobotInfoActivity.class);
        intent.putExtra("com.tencent.mobileqq.guild.robot.audio.robotListView.RobotListFragment", bundle);
        intent.putExtra("GUILD_ROBOT_SHOW_UI_KEY", "com.tencent.mobileqq.guild.robot.audio.robotListView.RobotListFragment");
        context.startActivity(intent);
    }

    public static IGProChannelInfo Q(@NonNull String str, AppRuntime appRuntime) {
        List<IGProChannelInfo> channelList = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getChannelList(str);
        if (channelList != null && channelList.size() != 0) {
            return R(channelList);
        }
        QLog.e("QQGuildUtil", 2, "getHomePageChannel: list = " + channelList, "guildId = " + str);
        return null;
    }

    public static AppRuntime Q0() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    public static IGProChannelInfo R(@NonNull List<IGProChannelInfo> list) {
        return G(list);
    }

    public static <T extends IRuntimeService> T R0(@NonNull Class<T> cls) {
        return (T) S0(cls, "");
    }

    public static String S() {
        return f235514g;
    }

    public static <T extends IRuntimeService> T S0(@NonNull Class<T> cls, String str) {
        return (T) l().getRuntimeService(cls, str);
    }

    public static String T() {
        return QQGuildMCParser.INSTANCE.f("100559", "guildOwnerOperationUrl", "https://qun.qq.com/guild/h5/guild-school/index.html?_wv=54181&_wwv=128");
    }

    public static void T0(View view, String str, ClickPolicy clickPolicy, ExposurePolicy exposurePolicy, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        if (map != null) {
            VideoReport.setElementParams(view, map);
        }
        VideoReport.setElementExposePolicy(view, exposurePolicy);
        VideoReport.setElementClickPolicy(view, clickPolicy);
    }

    public static int U() {
        return QQGuildMCParser.INSTANCE.d("100575", "robotAuthCacheMaxDuration", 0);
    }

    public static void U0(View view, String str, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        if (map != null) {
            VideoReport.setElementParams(view, map);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public static String V() {
        return QQGuildMCParser.INSTANCE.f("100546", "pushMsgSettingLink", "https://qun.qq.com/guild/h5/robot-push-settings/index.html");
    }

    public static void V0(View view, String str, IDynamicParams iDynamicParams) {
        VideoReport.setElementId(view, str);
        if (iDynamicParams != null) {
            VideoReport.setEventDynamicParams(view, iDynamicParams);
        }
        y(view);
    }

    public static QQGuildMCBean W(String str) {
        return bs.f235483a.h(str);
    }

    public static void W0(View view, String str, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        if (map != null) {
            VideoReport.setElementParams(view, map);
        }
        y(view);
    }

    public static int X() {
        QQGuildMCBean.d robotSlashCmd = W("100593").getGuildConfigBean().getRobotSlashCmd();
        if (QLog.isColorLevel()) {
            QLog.d("QQGuildUtil", 2, "mRobotCmdSortGuildLimit = " + robotSlashCmd.getRobotCmdSortGuildLimit());
        }
        return robotSlashCmd.getRobotCmdSortGuildLimit();
    }

    public static void X0(View view, String str, IDynamicParams iDynamicParams) {
        VideoReport.setElementId(view, str);
        if (iDynamicParams != null) {
            VideoReport.setEventDynamicParams(view, iDynamicParams);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public static int Y() {
        QQGuildMCBean.d robotSlashCmd = W("100593").getGuildConfigBean().getRobotSlashCmd();
        if (QLog.isColorLevel()) {
            QLog.d("QQGuildUtil", 2, "robotCommandSortLimit = " + robotSlashCmd.getRobotCmdSortRobotLimit());
        }
        return robotSlashCmd.getRobotCmdSortRobotLimit();
    }

    public static void Y0(View view, String str, ClickPolicy clickPolicy, ExposurePolicy exposurePolicy) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, clickPolicy);
        VideoReport.setElementExposePolicy(view, exposurePolicy);
    }

    public static int Z() {
        return QQGuildMCParser.INSTANCE.d("100577", "robotDirectMessageMaxActiveMessageCount", 0);
    }

    private static void Z0(@NonNull String str, OpenHippyInfo openHippyInfo) {
        Uri parse = Uri.parse(str);
        if (parse.isHierarchical()) {
            String host = parse.getHost();
            if (!TextUtils.isEmpty(host)) {
                String[] split = host.split("\\.");
                if (split.length > 0) {
                    int max = Math.max(0, split.length - 3);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(split[max]);
                    while (true) {
                        max++;
                        if (max >= split.length) {
                            break;
                        }
                        sb5.append('.');
                        sb5.append(split[max]);
                    }
                    openHippyInfo.domain = sb5.toString();
                    if (QLog.isColorLevel()) {
                        QLog.i("QQGuildUtil", 2, "openGameRankPage, domain=" + openHippyInfo.domain);
                    }
                }
            }
        }
    }

    public static String a0() {
        return E().f216288z0;
    }

    public static boolean a1(@NonNull Context context, IGProSecurityResult iGProSecurityResult, com.tencent.mobileqq.guild.util.security.i iVar) {
        if (iGProSecurityResult.get$actionCode() == 200 && !TextUtils.isEmpty(iGProSecurityResult.getStrPrompt())) {
            DialogUtil.createCustomDialog(context, 230, (String) null, iGProSecurityResult.getStrPrompt(), (String) null, context.getString(R.string.f146610un), new a(iVar), (DialogInterface.OnClickListener) null, new b(iVar)).show();
            return true;
        }
        return false;
    }

    public static Bitmap b0(Bitmap bitmap, int i3, int i16, int i17, int i18) {
        int i19;
        int i26;
        Rect rect;
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            if (bitmap.getWidth() < i3) {
                i19 = (i3 - bitmap.getWidth()) / 2;
            } else {
                i19 = 0;
            }
            if (bitmap.getHeight() < i16) {
                i26 = (i16 - bitmap.getHeight()) / 2;
            } else {
                i26 = 0;
            }
            Rect rect2 = new Rect(i19, i26, bitmap.getWidth() - i19, bitmap.getHeight() - i26);
            Rect rect3 = new Rect(i19, i26, i3 - i19, i16 - i26);
            RectF rectF = new RectF(rect3);
            if (i18 != 1) {
                if (i18 != 2) {
                    if (i18 != 3) {
                        if (i18 != 4) {
                            rect = null;
                        } else {
                            rect = new Rect(-i17, 0, i3 - i17, i16);
                        }
                    } else {
                        rect = new Rect(i17, 0, i3 + i17, i16);
                    }
                } else {
                    rect = new Rect(0, -i17, i3, i16 - i17);
                }
            } else {
                rect = new Rect(0, i17, i3, i16 + i17);
            }
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-16777216);
            float f16 = i17;
            canvas.drawRoundRect(rectF, f16, f16, paint);
            if (rect != null) {
                canvas.drawRect(rect, paint);
            }
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect2, rect3, paint);
            bitmap.recycle();
            return createBitmap;
        } catch (Throwable th5) {
            th5.printStackTrace();
            if (QLog.isDevelopLevel()) {
                QLog.w("QQGuildUtil", 2, "ROUND_CORNER_DECODER bitmap == null, ", th5);
                return null;
            }
            return null;
        }
    }

    public static boolean b1(@NonNull final Activity activity, @Nullable IGProSecurityResult iGProSecurityResult, com.tencent.mobileqq.guild.util.security.i iVar) {
        if (iGProSecurityResult != null && iGProSecurityResult.get$actionCode() == 102) {
            String strDetail = iGProSecurityResult.getStrDetail();
            try {
                if (TextUtils.isEmpty(strDetail)) {
                    return false;
                }
                final String optString = new JSONObject(strDetail).optString("verify_url");
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                QQCustomDialog negativeButton = DialogUtil.createCustomDialog(activity, 230).setTitle("\u8d26\u53f7\u5b9e\u540d\u8ba4\u8bc1").setMessage("\u4e3a\u4e86\u6ee1\u8db3\u76f8\u5173\u6cd5\u5f8b\u6cd5\u89c4\u7684\u7f51\u7edc\u5b9e\u540d\u5236\u8981\u6c42\uff0c\u8bf7\u63d0\u4f9b\u771f\u5b9e\u4fe1\u606f\u8fdb\u884c\u5b9e\u540d\u8ba4\u8bc1\u3002").setPositiveButton(R.string.f142570jq, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.util.ce
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        ch.F0(activity, optString, dialogInterface, i3);
                    }
                }).setNegativeButton(R.string.f140850f3, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.util.cf
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        dialogInterface.dismiss();
                    }
                });
                negativeButton.setCancelable(true);
                negativeButton.setCanceledOnTouchOutside(true);
                negativeButton.show();
                negativeButton.setOnDismissListener(new c(iVar));
                return true;
            } catch (JSONException e16) {
                QLog.e("QQGuildUtil", 1, "security.detail=" + strDetail + " security.prompt=" + iGProSecurityResult.getStrPrompt(), e16);
            }
        }
        return false;
    }

    public static String c0(Context context, String str) {
        return new File(new File(context.getFilesDir(), "qqguildcofig"), str).getPath();
    }

    public static void c1(IGProSecurityResult iGProSecurityResult) {
        ((ISecurityTipHelper) QRoute.api(ISecurityTipHelper.class)).showSecurityTipByApi(iGProSecurityResult, MobileQQ.sMobileQQ.getApplicationContext(), 0, "", false);
    }

    public static String d0(IGProUserInfo iGProUserInfo) {
        if (iGProUserInfo == null) {
            return "";
        }
        String name = iGProUserInfo.getName();
        if (!TextUtils.isEmpty(name)) {
            return name;
        }
        return QQGuildUIUtil.r(R.string.f143020ky);
    }

    public static void d1(final int i3, final int i16) {
        g1(new Runnable() { // from class: com.tencent.mobileqq.guild.util.cg
            @Override // java.lang.Runnable
            public final void run() {
                ch.I0(i3, i16);
            }
        });
    }

    public static String e0(ev evVar) {
        String memberName;
        if (evVar == null) {
            return "";
        }
        if (TextUtils.isEmpty(evVar.getMemberName())) {
            memberName = evVar.getNickName();
        } else {
            memberName = evVar.getMemberName();
        }
        if (!TextUtils.isEmpty(memberName)) {
            return memberName;
        }
        return QQGuildUIUtil.r(R.string.f143020ky);
    }

    public static void e1(final int i3, @NonNull final String str) {
        g1(new Runnable() { // from class: com.tencent.mobileqq.guild.util.cc
            @Override // java.lang.Runnable
            public final void run() {
                ch.H0(i3, str);
            }
        });
    }

    @NonNull
    public static String f() {
        return ((IGPSService) R0(IGPSService.class)).getSelfTinyId();
    }

    public static boolean f0(IGProUserInfo iGProUserInfo) {
        if (iGProUserInfo.getUserType() == 1 || iGProUserInfo.getUserType() == 2) {
            return true;
        }
        return false;
    }

    public static void f1(String str) {
        e1(0, str);
    }

    @NonNull
    public static String g() {
        String account = l().getAccount();
        if (account == null) {
            return "null";
        }
        return account;
    }

    public static boolean g0(String str) {
        IGPSService iGPSService = (IGPSService) R0(IGPSService.class);
        ArrayList<Long> guildUserChannelCategoryAdminList = iGPSService.getGuildUserChannelCategoryAdminList(str, iGPSService.getSelfTinyId());
        if (guildUserChannelCategoryAdminList != null && !guildUserChannelCategoryAdminList.isEmpty()) {
            return true;
        }
        return false;
    }

    private static void g1(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        }
    }

    public static boolean h() {
        if (f235515h == 2) {
            return true;
        }
        return false;
    }

    public static boolean h0(String str) {
        IGProChannelInfo channelInfo;
        if (TextUtils.isEmpty(str) || (channelInfo = ((IGPSService) R0(IGPSService.class)).getChannelInfo(str)) == null || !channelInfo.isChannelOrCategoryAdmin()) {
            return false;
        }
        return true;
    }

    public static void h1(final Activity activity, String str) {
        final Cdo faceAuthInfo = ((IGPSService) l().getRuntimeService(IGPSService.class, "")).getFaceAuthInfo();
        if (faceAuthInfo == null) {
            QLog.i("QQGuildUtil", 1, "showVisitorCertificationTipsToast: auth info is null.");
        } else if (faceAuthInfo.a() != 1) {
            QLog.i("QQGuildUtil", 1, "showVisitorCertificationTipsToast: auth info status error.");
        } else {
            r12.a.a(activity, new a.C11105a(activity.getString(R.string.f157201m_), activity.getString(R.string.f157191m9), new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.util.cd
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ch.J0(activity, faceAuthInfo, view);
                }
            })).b();
        }
    }

    public static Context i() {
        return MobileQQ.sMobileQQ;
    }

    public static boolean i0() {
        return com.tencent.mobileqq.guild.config.z.f216289a.b("100560", "directMsgSwitch", true);
    }

    public static void i1(Activity activity, String str) {
        k1(activity, str, "", "");
    }

    public static <T> T j(@NonNull Class<T> cls) {
        return (T) l().getBusinessHandler(cls.getName());
    }

    public static boolean j0(String str) {
        return !((IGPSService) R0(IGPSService.class)).isGuildMember(str);
    }

    public static void j1(Activity activity, String str, String str2) {
        m1(activity, str, "", "", true, str2, false);
    }

    public static <T> T k(@NonNull String str) {
        return (T) l().getBusinessHandler(str);
    }

    public static boolean k0() {
        return o02.b.b();
    }

    public static void k1(Activity activity, String str, String str2, String str3) {
        l1(activity, str, str2, str3, true);
    }

    @NonNull
    public static AppInterface l() {
        return (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    public static boolean l0(@Nullable IGProGuildInfo iGProGuildInfo) {
        if (iGProGuildInfo != null && (iGProGuildInfo.getUserType() == 2 || iGProGuildInfo.getUserType() == 1)) {
            return true;
        }
        return false;
    }

    private static void l1(Activity activity, String str, String str2, String str3, boolean z16) {
        m1(activity, str, str2, str3, z16, "", false);
    }

    @NonNull
    public static AppRuntime m() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    public static boolean m0(String str) {
        return l0(((IGPSService) R0(IGPSService.class)).getGuildInfo(str));
    }

    private static void m1(Activity activity, String str, String str2, String str3, boolean z16, String str4, boolean z17) {
        if (activity != null && !TextUtils.isEmpty(str)) {
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(activity);
            if (LiuHaiUtils.hasNotchInScreenByVersion(activity)) {
                statusBarHeight = LiuHaiUtils.getNotchInScreenHeight(activity);
            }
            String n3 = n(str, "nav_height", String.valueOf(statusBarHeight));
            if (AppSetting.t(activity)) {
                n3 = p1(n3);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(QQBrowserActivity.EXTRA_FINISH_ANIMATION_OUT_TO_RIGHT, z16);
            if (!str2.isEmpty() && !str3.isEmpty()) {
                bundle.putInt("titleBarStyle", 8);
                bundle.putString("guild_channel_name", str2);
                bundle.putString("guild_channel_avatar_url", str3);
                bundle.putBoolean("hide_title_left_arrow", z17);
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQGuildUtil", 2, "Jumping to a H5 page: " + n3);
            }
            cx.d(activity, n3, str4, bundle);
            activity.overridePendingTransition(R.anim.f154632p4, R.anim.f154442w);
            return;
        }
        QLog.e("QQGuildUtil", 1, "startNewH5Activity() error url:", str);
    }

    public static String n(String str, String str2, String str3) {
        String str4;
        char c16 = '?';
        if (str.indexOf(63) != -1) {
            c16 = Typography.amp;
        }
        if (TextUtils.isEmpty(str2)) {
            str4 = c16 + "";
        } else {
            str4 = c16 + str2 + '=' + str3;
        }
        if (str.lastIndexOf(ContainerUtils.FIELD_DELIMITER) == str.length() - 1) {
            str4 = str2 + '=' + str3;
        }
        return str + str4;
    }

    public static boolean n0(String str) {
        IGPSService iGPSService = (IGPSService) R0(IGPSService.class);
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(str);
        if (guildInfo == null) {
            return false;
        }
        return TextUtils.equals(guildInfo.getCreatorId(), iGPSService.getSelfTinyId());
    }

    public static void n1(Activity activity, String str, String str2, String str3, boolean z16, boolean z17) {
        m1(activity, str, str2, str3, true, "", z17);
    }

    public static boolean o(QBaseActivity qBaseActivity, String str) {
        IGPSService iGPSService = (IGPSService) qBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "");
        List<com.tencent.mobileqq.qqguildsdk.data.cy> channelCategoryList = iGPSService.getChannelCategoryList(str);
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(str);
        if (guildInfo != null) {
            guildInfo.getUserType();
        }
        Iterator<com.tencent.mobileqq.qqguildsdk.data.cy> it = channelCategoryList.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            Iterator<IGProChannelInfo> it5 = it.next().getChannelList().iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                IGProChannelInfo next = it5.next();
                boolean a16 = ao.a(next);
                if (next.getType() == 1 && next.getTalkPermission() != 0 && a16) {
                    z16 = true;
                    break;
                }
            }
            if (z16) {
                break;
            }
        }
        return z16;
    }

    public static boolean o0() {
        return QQGuildMCParser.INSTANCE.c("100559", "isGuildOwnerOperationShow", true);
    }

    public static void o1(Activity activity, String str) {
        l1(activity, str, "", "", false);
    }

    public static boolean p(IGProSecurityResult iGProSecurityResult) {
        if (iGProSecurityResult != null && iGProSecurityResult.get$actionCode() != 0) {
            return false;
        }
        return true;
    }

    public static boolean p0(IGProUserInfo iGProUserInfo) {
        if (iGProUserInfo.getUserType() == 2) {
            return true;
        }
        return false;
    }

    public static String p1(String str) {
        if (str == null) {
            return null;
        }
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("_wwv");
        int i3 = 2;
        try {
            i3 = 2 | Integer.parseInt(queryParameter);
            return parse.buildUpon().encodedQuery(parse.getQuery().replace("_wwv=" + queryParameter, "_wwv=" + i3)).build().toString();
        } catch (NumberFormatException unused) {
            return parse.buildUpon().appendQueryParameter("_wwv", i3 + "").build().toString();
        }
    }

    public static boolean q(String str) {
        return false;
    }

    public static boolean q0(String str) {
        IGProGuildInfo L = L(str);
        if (L != null && L.isVisibleForVisitor() && L.isInteractiveForVisitor()) {
            return true;
        }
        return false;
    }

    public static void q1(@NonNull Activity activity, int i3, String str) {
        r1(activity, i3, str, null);
    }

    public static boolean r(String str) {
        return false;
    }

    public static <T> boolean r0(List<T> list) {
        if (list != null && list.size() != 0) {
            return false;
        }
        return true;
    }

    public static void r1(@NonNull Activity activity, int i3, String str, @Nullable IGProSecurityResult iGProSecurityResult) {
        t1(activity, i3, str, iGProSecurityResult);
    }

    public static boolean s(String str) {
        return false;
    }

    public static boolean s0() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static void s1(@NonNull Context context, int i3, String str) {
        t1(context, i3, str, null);
    }

    public static String t(int i3) {
        return String.format("#%06X", Integer.valueOf(i3 & 16777215));
    }

    public static boolean t0(IGProGuildInfo iGProGuildInfo) {
        if (iGProGuildInfo == null) {
            return false;
        }
        if (iGProGuildInfo.getUserType() != 2 && iGProGuildInfo.getUserType() != 1) {
            return false;
        }
        return true;
    }

    @Deprecated
    public static void t1(@NonNull Context context, int i3, String str, @Nullable IGProSecurityResult iGProSecurityResult) {
        if (context == null) {
            return;
        }
        if (i3 == 0 && p(iGProSecurityResult)) {
            return;
        }
        if (iGProSecurityResult != null && iGProSecurityResult.get$actionCode() != 0) {
            if (a1(context, iGProSecurityResult, null)) {
                return;
            }
            if ((context instanceof Activity) && b1((Activity) context, iGProSecurityResult, null)) {
                return;
            }
            if (!TextUtils.isEmpty(iGProSecurityResult.getStrPrompt())) {
                str = iGProSecurityResult.getStrPrompt();
            } else {
                str = context.getResources().getString(R.string.f155591hx);
            }
        } else if (i3 == 22000) {
            str = context.getResources().getString(R.string.f138640_4);
        } else if (i3 == 22001) {
            str = context.getResources().getString(R.string.f138630_3);
        } else if (i3 == 22005) {
            str = context.getResources().getString(R.string.f138620_2);
        } else if (i3 == 29001) {
            str = context.getResources().getString(R.string.f141830hq);
        } else if (i3 == 30006) {
            str = context.getResources().getString(R.string.f1519018y);
        } else if (i3 == 10011) {
            str = context.getResources().getString(R.string.f15193191);
        } else if (i3 == 54006) {
            str = context.getResources().getString(R.string.f146240tn);
        } else if (i3 == -93) {
            str = context.getResources().getString(R.string.f1511016s);
        } else if ((i3 == 29100 || i3 == 29101) && !str.isEmpty()) {
            DialogUtil.createCustomDialog(context, 230, (String) null, str, (String) null, context.getString(R.string.f146610un), new h(), (DialogInterface.OnClickListener) null).show();
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getResources().getString(R.string.f141910hy);
        }
        QQToast.makeText(context, 1, str, 1).show();
    }

    public static String u(String str, String str2, int i3) {
        return v(str, str2, i3, 0);
    }

    public static boolean u0(AppRuntime appRuntime, String str) {
        if (appRuntime != null && !TextUtils.isEmpty(str)) {
            IGPSService iGPSService = (IGPSService) appRuntime.getRuntimeService(IGPSService.class, "");
            return t0(iGPSService.getGuildInfo(iGPSService.getGuildIdOf(str)));
        }
        return false;
    }

    public static void u1(Context context, String str) {
        QQToast.makeText(context, 2, str, 1).show();
    }

    public static String v(String str, String str2, int i3, int i16) {
        StringBuilder sb5 = new StringBuilder(n("https://qun.qq.com/guild/h5/invalid-share/index.html?", "", ""));
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("guild_id");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(str);
        }
        if (!TextUtils.isEmpty(str2) && !"0".equals(str2)) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("channel_id");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(str2);
        }
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("business_type");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(i3);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("errCode");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(i16);
        QLog.d("QQGuildUtil", 1, "createGuildH5EmptyUri: " + ((Object) sb5));
        return sb5.toString();
    }

    public static boolean v0(IGProGuildInfo iGProGuildInfo) {
        if (iGProGuildInfo == null || iGProGuildInfo.getUserType() != 2) {
            return false;
        }
        return true;
    }

    public static GProLocationInfo v1(ev evVar) {
        GProLocationInfo gProLocationInfo = new GProLocationInfo();
        gProLocationInfo.q(evVar.i());
        gProLocationInfo.r(evVar.p());
        gProLocationInfo.s(evVar.getProvince());
        gProLocationInfo.t(evVar.c());
        gProLocationInfo.m(evVar.getCity());
        gProLocationInfo.n(evVar.g());
        return gProLocationInfo;
    }

    public static void w(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean w0(IGProUserInfo iGProUserInfo) {
        if (iGProUserInfo.getRobotType() == 1) {
            return true;
        }
        return false;
    }

    public static void x(View view) {
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }

    public static boolean x0() {
        Object obj;
        com.tencent.mobileqq.guild.config.y E = E();
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[1];
            if (("isShowDefaultRoleGroup: " + E) != null) {
                obj = Boolean.valueOf(E.I);
            } else {
                obj = "null";
            }
            objArr[0] = obj;
            QLog.d("QQGuildUtil", 2, objArr);
        }
        if (E == null || E.D == null) {
            return false;
        }
        return E.I;
    }

    public static void y(View view) {
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public static boolean y0() {
        return com.tencent.mobileqq.guild.config.z.f216289a.b("100545", "isShowGuildMyOrder", false);
    }

    public static String z(IGProUserInfo iGProUserInfo) {
        return A(iGProUserInfo, 0);
    }

    public static boolean z0() {
        return QQGuildMCParser.INSTANCE.c("100597", "isShowSetGlobalTopMsg", true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class h implements DialogInterface.OnClickListener {
        h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}

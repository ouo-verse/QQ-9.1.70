package com.tencent.robot.aio.share.util;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;
import com.tencent.mobileqq.sharehelper.d;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.utils.c;
import com.tencent.util.QQCustomArkDialogUtil;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007J:\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007J*\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007J:\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0007J:\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0007J:\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\bH\u0007J \u0010\u001c\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0007J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J0\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0003J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u0004H\u0003J \u0010\"\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0003JB\u0010$\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0003\u00a8\u0006'"}, d2 = {"Lcom/tencent/robot/aio/share/util/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "arkString", "", "enableMultiSelection", "", "requestCode", "", "g", "uin", "uinType", "i", "e", "shareUrl", "description", "title", PhotoCategorySummaryInfo.AVATAR_URL, "Ljava/lang/Runnable;", "finishRunnable", "j", "shareTitle", "l", "reqCode", h.F, "clipBoardLabel", "f", "Landroid/content/Intent;", "a", "b", "Lcom/tencent/robot/aio/share/util/a$a;", "d", "c", "shareType", "k", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f367345a = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0082\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\u000bR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\u000bR\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0014\u0010\u000bR\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0011\u0010\u000b\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/robot/aio/share/util/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "appName", "b", "c", QQCustomArkDialogUtil.APP_VIEW, "appVersion", "d", "g", "prompt", "e", "f", PublicAccountMessageUtilImpl.META_NAME, DownloadInfo.spKey_Config, ark.APP_SPECIFIC_BIZSRC, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.aio.share.util.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class ArkShareInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String appName;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String appView;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String appVersion;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String prompt;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String meta;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String config;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String bizSrc;

        public ArkShareInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
            this.appName = str;
            this.appView = str2;
            this.appVersion = str3;
            this.prompt = str4;
            this.meta = str5;
            this.config = str6;
            this.bizSrc = str7;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getAppName() {
            return this.appName;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getAppVersion() {
            return this.appVersion;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getAppView() {
            return this.appView;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getBizSrc() {
            return this.bizSrc;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final String getConfig() {
            return this.config;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ArkShareInfo)) {
                return false;
            }
            ArkShareInfo arkShareInfo = (ArkShareInfo) other;
            if (Intrinsics.areEqual(this.appName, arkShareInfo.appName) && Intrinsics.areEqual(this.appView, arkShareInfo.appView) && Intrinsics.areEqual(this.appVersion, arkShareInfo.appVersion) && Intrinsics.areEqual(this.prompt, arkShareInfo.prompt) && Intrinsics.areEqual(this.meta, arkShareInfo.meta) && Intrinsics.areEqual(this.config, arkShareInfo.config) && Intrinsics.areEqual(this.bizSrc, arkShareInfo.bizSrc)) {
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final String getMeta() {
            return this.meta;
        }

        @Nullable
        /* renamed from: g, reason: from getter */
        public final String getPrompt() {
            return this.prompt;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int hashCode6;
            String str = this.appName;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.appView;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.appVersion;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str4 = this.prompt;
            if (str4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str4.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            String str5 = this.meta;
            if (str5 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str5.hashCode();
            }
            int i26 = (i19 + hashCode5) * 31;
            String str6 = this.config;
            if (str6 == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = str6.hashCode();
            }
            int i27 = (i26 + hashCode6) * 31;
            String str7 = this.bizSrc;
            if (str7 != null) {
                i3 = str7.hashCode();
            }
            return i27 + i3;
        }

        @NotNull
        public String toString() {
            return "ArkShareInfo(appName=" + this.appName + ", appView=" + this.appView + ", appVersion=" + this.appVersion + ", prompt=" + this.prompt + ", meta=" + this.meta + ", config=" + this.config + ", bizSrc=" + this.bizSrc + ")";
        }
    }

    a() {
    }

    @JvmStatic
    private static final Intent a(String arkString, boolean enableMultiSelection) {
        int i3;
        Intent intent = new Intent();
        ArkShareInfo d16 = d(arkString);
        intent.putExtra("forward_type", 27);
        intent.putExtra("is_ark_display_share", true);
        if (enableMultiSelection) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, i3);
        intent.putExtra("scale", ViewUtils.getDensity());
        intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 1);
        intent.putExtra("forward_ark_app_name", d16.getAppName());
        intent.putExtra("forward_ark_app_ver", d16.getAppVersion());
        intent.putExtra("forward_ark_app_view", d16.getAppView());
        intent.putExtra("forward_ark_app_meta", d16.getMeta());
        intent.putExtra("forward_ark_app_prompt", d16.getPrompt());
        intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, d16.getConfig());
        intent.putExtra("forward_ark_biz_src", d16.getBizSrc());
        intent.putExtra("appName", d16.getAppName());
        intent.putExtra(QQCustomArkDialogUtil.APP_MIN_VERSION, d16.getAppVersion());
        intent.putExtra(QQCustomArkDialogUtil.APP_VIEW, d16.getAppView());
        intent.putExtra(QQCustomArkDialogUtil.META_DATA, d16.getMeta());
        return intent;
    }

    @JvmStatic
    private static final Intent b(Activity activity, String arkString, boolean enableMultiSelection, int uinType, String uin) {
        Intent a16 = a(arkString, enableMultiSelection);
        a16.putExtras(c(activity, uinType, uin));
        return a16;
    }

    @JvmStatic
    private static final Intent c(Activity activity, int uinType, String uin) {
        Intent intent = new Intent();
        intent.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        intent.putExtra("key_direct_show_uin_type", uinType);
        intent.putExtra("key_direct_show_uin", uin);
        intent.putExtra("caller_name", activity.getClass().getSimpleName());
        intent.putExtra("forward_source_business_type", BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD);
        intent.putExtra("forward_source_sub_business_type", "");
        return intent;
    }

    @JvmStatic
    private static final ArkShareInfo d(String arkString) {
        return new ArkShareInfo(c.d(arkString, null), c.g(arkString, null), c.f(arkString, null), c.e(arkString, null), c.c(arkString), c.b(arkString), c.a(arkString, null));
    }

    @JvmStatic
    public static final void e(@NotNull Activity activity, @NotNull String arkString, boolean enableMultiSelection, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(arkString, "arkString");
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(activity, a(arkString, enableMultiSelection), requestCode);
        if (QLog.isDebugVersion()) {
            QLog.d("RobotSessionShareActionSheetArkLinkShareUtil", 4, "shareToChannel success");
        }
    }

    @JvmStatic
    public static final void f(@NotNull Activity activity, @NotNull String clipBoardLabel, @NotNull String shareUrl) {
        ClipboardManager clipboardManager;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(clipBoardLabel, "clipBoardLabel");
        Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
        Object systemService = activity.getSystemService("clipboard");
        Unit unit = null;
        if (systemService instanceof ClipboardManager) {
            clipboardManager = (ClipboardManager) systemService;
        } else {
            clipboardManager = null;
        }
        if (clipboardManager != null) {
            ClipboardMonitor.setPrimaryClip(clipboardManager, ClipData.newPlainText(clipBoardLabel, shareUrl));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            return;
        }
        QQToastUtil.showQQToast(2, "\u590d\u5236\u6210\u529f");
        if (QLog.isDebugVersion()) {
            QLog.d("RobotSessionShareActionSheetArkLinkShareUtil", 4, "shareToClipboard success");
        }
    }

    @JvmStatic
    public static final void g(@NotNull Activity activity, @NotNull String arkString, boolean enableMultiSelection, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(arkString, "arkString");
        RouteUtils.startActivityForResult(activity, a(arkString, enableMultiSelection), RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, requestCode);
        if (QLog.isDebugVersion()) {
            QLog.d("RobotSessionShareActionSheetArkLinkShareUtil", 4, "shareToFriends success");
        }
    }

    @JvmStatic
    public static final void h(@NotNull Activity activity, @NotNull String shareUrl, @NotNull String description, @NotNull String shareTitle, @NotNull String avatarUrl, int reqCode) {
        ArrayList<String> arrayListOf;
        String currentUin;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(shareTitle, "shareTitle");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        d dVar = new d();
        dVar.n(description);
        dVar.j("");
        dVar.p(shareTitle);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(avatarUrl);
        dVar.l(arrayListOf);
        dVar.o(shareUrl);
        AppInterface e16 = bg.e();
        if (e16 != null && (currentUin = e16.getCurrentUin()) != null) {
            dVar.i(currentUin);
            dVar.m(reqCode);
            ((IShareActionHelper) QRoute.api(IShareActionHelper.class)).doShareToQZoneWithLink("", activity, dVar);
            if (QLog.isDebugVersion()) {
                QLog.d("RobotSessionShareActionSheetArkLinkShareUtil", 4, "shareToQzone success");
            }
        }
    }

    @JvmStatic
    public static final void i(@NotNull Activity activity, @NotNull String arkString, boolean enableMultiSelection, @NotNull String uin, int uinType, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(arkString, "arkString");
        Intrinsics.checkNotNullParameter(uin, "uin");
        RouteUtils.startActivityForResult(activity, b(activity, arkString, enableMultiSelection, uinType, uin), RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS, requestCode);
        if (QLog.isDebugVersion()) {
            QLog.d("RobotSessionShareActionSheetArkLinkShareUtil", 4, "shareToSpecifiedFriend success");
        }
    }

    @JvmStatic
    public static final void j(@NotNull Activity activity, @NotNull String shareUrl, @NotNull String description, @NotNull String title, @NotNull String avatarUrl, @Nullable Runnable finishRunnable) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        k(activity, shareUrl, description, title, avatarUrl, 9, finishRunnable);
        if (QLog.isDebugVersion()) {
            QLog.d("RobotSessionShareActionSheetArkLinkShareUtil", 4, "shareToWechat success");
        }
    }

    @JvmStatic
    private static final void k(Activity activity, String shareUrl, String description, String title, String avatarUrl, int shareType, Runnable finishRunnable) {
        ((IShareActionHelper) QRoute.api(IShareActionHelper.class)).doShareLinkToWeChat("", shareType, shareUrl, activity, String.valueOf(System.currentTimeMillis()), description, title, avatarUrl, finishRunnable);
    }

    @JvmStatic
    public static final void l(@NotNull Activity activity, @NotNull String shareUrl, @NotNull String description, @NotNull String shareTitle, @NotNull String avatarUrl, @Nullable Runnable finishRunnable) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(shareTitle, "shareTitle");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        k(activity, shareUrl, description, shareTitle, avatarUrl, 10, finishRunnable);
        if (QLog.isDebugVersion()) {
            QLog.d("RobotSessionShareActionSheetArkLinkShareUtil", 4, "shareToWechatCircle success");
        }
    }
}

package com.tencent.state.square;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.ISquareSummaryView;
import com.tencent.state.square.api.SquareSummaryViewConfig;
import com.tencent.state.square.config.MsgBoxConfig;
import com.tencent.state.square.config.PerformanceConfig;
import com.tencent.state.square.data.SquareDeviceInfo;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.io.File;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0005H&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\u0010H&J\b\u0010\u0014\u001a\u00020\u0005H&J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u0005H&J\b\u0010\u001a\u001a\u00020\u0003H'J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H&J\b\u0010\u001d\u001a\u00020\u0005H&J\b\u0010\u001e\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0003H\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\b\u001a\u00020\tH&J\u0012\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\b\u001a\u00020\tH&J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\n\u0010(\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010)\u001a\u00020\u0010H\u0016J\b\u0010*\u001a\u00020\u0010H&J\b\u0010+\u001a\u00020\u0005H&J\b\u0010,\u001a\u00020\u000bH&J\b\u0010-\u001a\u00020\u0003H\u0016J\b\u0010.\u001a\u00020\u0003H&J\b\u0010/\u001a\u000200H&J\b\u00101\u001a\u00020\u0010H&J\b\u00102\u001a\u00020\u0010H&J\b\u00103\u001a\u00020\u0003H\u0016J\u001c\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u00106\u001a\u000207H&J\b\u00108\u001a\u00020\u0005H&J\u0012\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\u0005H&J\b\u0010<\u001a\u00020\u0005H&J\u0010\u0010=\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010>\u001a\u00020\u0003H&J\b\u0010?\u001a\u00020\u0003H&J\u0010\u0010@\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010A\u001a\u00020\u0003H\u0016J\u0012\u0010B\u001a\u00020\u00032\b\u0010C\u001a\u0004\u0018\u00010DH&J\b\u0010E\u001a\u00020\u0003H&J\u0012\u0010F\u001a\u00020\u00032\b\u0010G\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010H\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0003H&J\u0018\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020KH&J3\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00052!\u0010P\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\bR\u0012\b\bS\u0012\u0004\b\b(T\u0012\u0004\u0012\u00020N0QH&J\u0018\u0010U\u001a\u00020N2\u0006\u0010V\u001a\u00020\u00102\u0006\u0010W\u001a\u00020\u000bH&J\u0010\u0010X\u001a\u00020N2\u0006\u0010Y\u001a\u00020\u0003H'J\u0018\u0010Z\u001a\u00020N2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u0010H&J\u0010\u0010^\u001a\u00020N2\u0006\u0010_\u001a\u00020\u0003H&J\u0010\u0010`\u001a\u00020N2\u0006\u0010a\u001a\u00020\u0003H&J\u0010\u0010b\u001a\u00020N2\u0006\u0010c\u001a\u00020\u0010H\u0016J\u0010\u0010d\u001a\u00020N2\u0006\u0010c\u001a\u00020\u0010H\u0016J\u0010\u0010e\u001a\u00020N2\u0006\u0010\b\u001a\u00020\tH&J3\u0010f\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00052!\u0010P\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\bR\u0012\b\bS\u0012\u0004\b\b(T\u0012\u0004\u0012\u00020N0QH&J$\u0010g\u001a\u0004\u0018\u00010h2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020\u00052\b\b\u0002\u0010l\u001a\u00020mH&JU\u0010n\u001a\u00020N2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010o\u001a\u00020\u00052\u0006\u0010p\u001a\u00020\u00052\u0006\u0010q\u001a\u00020\u00052\b\u0010r\u001a\u0004\u0018\u00010\u00052!\u0010P\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\bR\u0012\b\bS\u0012\u0004\b\b(s\u0012\u0004\u0012\u00020N0QH&J@\u0010n\u001a\u00020N2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010o\u001a\u00020\u00052\u0006\u0010t\u001a\u00020\u00052\b\u0010r\u001a\u0004\u0018\u00010\u00052\u0006\u0010u\u001a\u00020\u00032\f\u0010P\u001a\b\u0012\u0004\u0012\u00020N0vH&J\"\u0010w\u001a\u00020N2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010x\u001a\u00020\u00102\b\b\u0002\u0010y\u001a\u00020\u0010H&J$\u0010w\u001a\u00020N2\u0006\u0010\b\u001a\u00020\t2\b\u0010z\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010y\u001a\u00020\u0010H&J&\u0010{\u001a\u00020N2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010z\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010y\u001a\u00020\u0010H\u0016J\b\u0010|\u001a\u00020NH&J\u0010\u0010}\u001a\u00020N2\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006~"}, d2 = {"Lcom/tencent/state/square/ICommonUtils;", "", "checkZplanAccessible", "", "uin", "", "enableZPlanFilamentBase", "formatTimeForMsgBox", "context", "Landroid/content/Context;", "time", "", "getAppReportVersionName", "getApplication", "Landroid/app/Application;", "getAvatarGender", "", "()Ljava/lang/Integer;", "getCpuCoreNum", "getCpuMaxFreq", "getCurrentAccountUin", "getDebugFragment", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "pageType", "Lcom/tencent/state/square/DebugPageType;", "getDeviceName", "getForbidLocalRecord", "getFriendRemarkName", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getGpuInfo", "getMsgBoxConfig", "Lcom/tencent/state/square/config/MsgBoxConfig;", "getNeedReportPlaySuccess", "getNeedShieldTeenager", "getPagImageView", "Lcom/tencent/state/square/api/ISquarePagView;", "getPagView", "getPerformanceConfig", "Lcom/tencent/state/square/config/PerformanceConfig;", "getQZoneFeedsBubbleText", "getQZoneHomePageUrl", "getQZonePrivacyDialogShowLimitDay", "getRAMSize", "getSelfTinyId", "getServerTime", "getShaderUseMulti", "getSquareDebug", "getSquareDeviceInfo", "Lcom/tencent/state/square/data/SquareDeviceInfo;", "getSquareFilamentPlayCountIncludeMe", "getSquarePlayCountIncludeMe", "getStudyMode", "getSummaryView", "Lcom/tencent/state/square/api/ISquareSummaryView;", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/api/SquareSummaryViewConfig;", "getSystemVersion", "getUrlDrawableFile", "Ljava/io/File;", "url", "getUserAppearanceKey", "hasSendFriendRequest", "isApngLoaded", "isBackgroundStop", "isCurrentAccount", "isDebugVersion", "isDrawableReady", "urlDrawable", "Lcom/tencent/image/URLDrawable;", "isLikeIconUseHug", "isSongPlaying", "songMid", "isSwitchOn", "key", "loadRawConfig", "", VipFunCallConstants.KEY_GROUP, "paiYiPaiFriend", "", "friendUin", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "phoneVibrate", "from", "duration", "setForbidLocalRecord", "forbidden", "setImmersiveStatus", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "color", "setNeedShieldTeenager", "needShieldTeenager", "setSquareDebug", "isDebug", "setSquareFilamentPlayCountIncludeMe", "playCount", "setSquarePlayCountIncludeMe", "setStandardFont", "shouldShowSmallHomeEntry", "showCallOutPopupWindow", "Landroid/widget/PopupWindow;", "decor", "Landroid/view/View;", "text", "style", "Lcom/tencent/state/square/CalloutPopupWindowStyle;", "showDialog", "msg", "rightText", "leftText", "title", "isConfirm", "midText", "isSelect", "Lkotlin/Function0;", UIJsPlugin.EVENT_SHOW_TOAST, PoiListCacheRecord.WEIGHT_TYPE, "type", "message", "showToastSafely", "startZPlanEngineWhenNotReady", "unSetStandardFont", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface ICommonUtils {
    boolean checkZplanAccessible(@NotNull String uin);

    boolean enableZPlanFilamentBase();

    @NotNull
    String formatTimeForMsgBox(@NotNull Context context, long time);

    @NotNull
    String getAppReportVersionName();

    @Nullable
    Application getApplication();

    @Nullable
    Integer getAvatarGender();

    int getCpuCoreNum();

    int getCpuMaxFreq();

    @NotNull
    String getCurrentAccountUin();

    @Nullable
    QPublicBaseFragment getDebugFragment(@NotNull DebugPageType pageType);

    @NotNull
    String getDeviceName();

    @Deprecated(message = "8968\u7248\u672c\u540e\uff0c\u672c\u5730\u5f55\u5236\u4f7f\u7528Filament\uff0c\u5f00\u5173\u548cFilament\u4fdd\u6301\u4e00\u81f4")
    /* renamed from: getForbidLocalRecord */
    boolean getForbiddenLocalRecord();

    @NotNull
    String getFriendRemarkName(@NotNull String uin, @NotNull String defaultValue);

    @NotNull
    String getGpuInfo();

    @NotNull
    MsgBoxConfig getMsgBoxConfig();

    boolean getNeedReportPlaySuccess();

    boolean getNeedShieldTeenager();

    @Nullable
    ISquarePagView getPagImageView(@NotNull Context context);

    @Nullable
    ISquarePagView getPagView(@NotNull Context context);

    @NotNull
    PerformanceConfig getPerformanceConfig();

    @NotNull
    String getQZoneFeedsBubbleText();

    @Nullable
    String getQZoneHomePageUrl();

    int getQZonePrivacyDialogShowLimitDay();

    int getRAMSize();

    @NotNull
    String getSelfTinyId();

    long getServerTime();

    boolean getShaderUseMulti();

    boolean getSquareDebug();

    @NotNull
    SquareDeviceInfo getSquareDeviceInfo();

    /* renamed from: getSquareFilamentPlayCountIncludeMe */
    int getFilamentPlayCountIncludeMe();

    /* renamed from: getSquarePlayCountIncludeMe */
    int getPlayCountIncludeMe();

    boolean getStudyMode();

    @Nullable
    ISquareSummaryView getSummaryView(@NotNull Context context, @NotNull SquareSummaryViewConfig config);

    @NotNull
    String getSystemVersion();

    @Nullable
    File getUrlDrawableFile(@NotNull String url);

    @NotNull
    String getUserAppearanceKey();

    boolean hasSendFriendRequest(@NotNull String uin);

    boolean isApngLoaded();

    boolean isBackgroundStop();

    boolean isCurrentAccount(@NotNull String uin);

    boolean isDebugVersion();

    boolean isDrawableReady(@Nullable URLDrawable urlDrawable);

    boolean isLikeIconUseHug();

    boolean isSongPlaying(@Nullable String songMid);

    boolean isSwitchOn(@NotNull String key, boolean defaultValue);

    @NotNull
    byte[] loadRawConfig(@NotNull String group, @NotNull byte[] defaultValue);

    void paiYiPaiFriend(@NotNull String friendUin, @NotNull Function1<? super Boolean, Unit> callback);

    void phoneVibrate(int from, long duration);

    @Deprecated(message = "8968\u7248\u672c\u540e\uff0c\u672c\u5730\u5f55\u5236\u4f7f\u7528Filament\uff0c\u5f00\u5173\u548cFilament\u4fdd\u6301\u4e00\u81f4")
    void setForbidLocalRecord(boolean forbidden);

    void setImmersiveStatus(@NotNull Activity activity, int color);

    void setNeedShieldTeenager(boolean needShieldTeenager);

    void setSquareDebug(boolean isDebug);

    void setSquareFilamentPlayCountIncludeMe(int playCount);

    void setSquarePlayCountIncludeMe(int playCount);

    void setStandardFont(@NotNull Context context);

    void shouldShowSmallHomeEntry(@NotNull String friendUin, @NotNull Function1<? super Boolean, Unit> callback);

    @Nullable
    PopupWindow showCallOutPopupWindow(@NotNull View decor, @NotNull String text, @NotNull CalloutPopupWindowStyle style);

    void showDialog(@NotNull Context context, @NotNull String msg2, @NotNull String rightText, @NotNull String leftText, @Nullable String title, @NotNull Function1<? super Boolean, Unit> callback);

    void showDialog(@NotNull Context context, @NotNull String msg2, @NotNull String midText, @Nullable String title, boolean isSelect, @NotNull Function0<Unit> callback);

    void showToast(@NotNull Context context, int r26, int type);

    void showToast(@NotNull Context context, @Nullable String message, int type);

    void showToastSafely(@Nullable Context context, @Nullable String message, int type);

    void startZPlanEngineWhenNotReady();

    void unSetStandardFont(@NotNull Context context);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        @Nullable
        public static Integer getAvatarGender(@NotNull ICommonUtils iCommonUtils) {
            return 1;
        }

        public static boolean getNeedShieldTeenager(@NotNull ICommonUtils iCommonUtils) {
            return false;
        }

        @NotNull
        public static PerformanceConfig getPerformanceConfig(@NotNull ICommonUtils iCommonUtils) {
            return new PerformanceConfig();
        }

        @NotNull
        public static String getQZoneFeedsBubbleText(@NotNull ICommonUtils iCommonUtils) {
            return "\u6211\u66f4\u65b0\u4e86\u8bf4\u8bf4";
        }

        @Nullable
        public static String getQZoneHomePageUrl(@NotNull ICommonUtils iCommonUtils) {
            return null;
        }

        public static int getQZonePrivacyDialogShowLimitDay(@NotNull ICommonUtils iCommonUtils) {
            return 7;
        }

        public static boolean getShaderUseMulti(@NotNull ICommonUtils iCommonUtils) {
            return true;
        }

        public static boolean getStudyMode(@NotNull ICommonUtils iCommonUtils) {
            return false;
        }

        public static /* synthetic */ ISquareSummaryView getSummaryView$default(ICommonUtils iCommonUtils, Context context, SquareSummaryViewConfig squareSummaryViewConfig, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    squareSummaryViewConfig = new SquareSummaryViewConfig(0.0f, 0, 3, null);
                }
                return iCommonUtils.getSummaryView(context, squareSummaryViewConfig);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSummaryView");
        }

        public static boolean isDebugVersion(@NotNull ICommonUtils iCommonUtils) {
            return true;
        }

        public static /* synthetic */ PopupWindow showCallOutPopupWindow$default(ICommonUtils iCommonUtils, View view, String str, CalloutPopupWindowStyle calloutPopupWindowStyle, int i3, Object obj) {
            CalloutPopupWindowStyle calloutPopupWindowStyle2;
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    calloutPopupWindowStyle2 = new CalloutPopupWindowStyle(0.0f, 0, 0, 0, 0, 0, 0, 0, 0, 511, null);
                } else {
                    calloutPopupWindowStyle2 = calloutPopupWindowStyle;
                }
                return iCommonUtils.showCallOutPopupWindow(view, str, calloutPopupWindowStyle2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showCallOutPopupWindow");
        }

        public static /* synthetic */ void showToast$default(ICommonUtils iCommonUtils, Context context, String str, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    i3 = 0;
                }
                iCommonUtils.showToast(context, str, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showToast");
        }

        public static void showToastSafely(@NotNull ICommonUtils iCommonUtils, @Nullable Context context, @Nullable String str, int i3) {
            if (context != null) {
                try {
                    iCommonUtils.showToast(context, str, i3);
                } catch (Exception e16) {
                    SquareBaseKt.getSquareLog().e("ICommonUtils", "showToastSafely error", e16);
                }
            }
        }

        public static /* synthetic */ void showToastSafely$default(ICommonUtils iCommonUtils, Context context, String str, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    i3 = 0;
                }
                iCommonUtils.showToastSafely(context, str, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showToastSafely");
        }

        public static /* synthetic */ void showToast$default(ICommonUtils iCommonUtils, Context context, int i3, int i16, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 4) != 0) {
                    i16 = 0;
                }
                iCommonUtils.showToast(context, i3, i16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showToast");
        }

        public static void setSquareFilamentPlayCountIncludeMe(@NotNull ICommonUtils iCommonUtils, int i3) {
        }

        public static void setSquarePlayCountIncludeMe(@NotNull ICommonUtils iCommonUtils, int i3) {
        }
    }
}

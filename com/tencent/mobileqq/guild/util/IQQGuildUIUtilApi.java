package com.tencent.mobileqq.guild.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u00012J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u0003H&J\u0012\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u0003H'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u001e\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u0011\u001a\u00020\u0005H&J\u0012\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u0003H&J/\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u00032\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00170\u0016\"\u0004\u0018\u00010\u0017H&\u00a2\u0006\u0002\u0010\u0018J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u001a\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\nH&J2\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!2\b\b\u0002\u0010#\u001a\u00020$H&J\u001a\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0&2\b\b\u0001\u0010\u0014\u001a\u00020\u0003H&J\"\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030&2\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0006\u001a\u00020\u0003H&J\u001a\u0010)\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u0003H&J\u0012\u0010-\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\nH&J \u0010.\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u000201H&\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/util/IQQGuildUIUtilApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "dp2px", "", "dp", "", "res", "Landroid/content/res/Resources;", "getColor", "context", "Landroid/content/Context;", "id", "getScreenHeight", "getScreenWidth", "getScreenWidthForSplit", "useWidthPixel", "", "getSplitRatioOfFunction", "getString", "", "resId", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "isInSplitViewMode", "isPhone", "ctx", "launchFragmentInSplitMode", "", "intent", "Landroid/content/Intent;", "fragmentClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", AppConstants.Preferences.LAUNCH_MODE, "Lcom/tencent/mobileqq/pad/LaunchMode;", "obtainBubbleDrawableBitmap", "Landroidx/lifecycle/LiveData;", "Landroid/graphics/Bitmap;", "obtainDrawableColor", "setStatusBarColor", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "color", "shouldLaunchInSplitViewMode", "showQuitAioDialog", "factoryName", "reason", "Lcom/tencent/mobileqq/guild/util/IQQGuildUIUtilApi$QuitReason;", "QuitReason", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IQQGuildUIUtilApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/util/IQQGuildUIUtilApi$QuitReason;", "", "(Ljava/lang/String;I)V", "VISIBILITY_CHANGE", "KICK_OUT", "CHANNEL_DESTROY", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum QuitReason {
        VISIBILITY_CHANGE,
        KICK_OUT,
        CHANNEL_DESTROY
    }

    int dp2px(float dp5, @Nullable Resources res);

    @Deprecated(message = "\u8bf7\u4f7f\u7528getColor(context: Context, @ColorRes id: Int)")
    int getColor(@ColorRes int id5);

    int getColor(@NotNull Context context, @ColorRes int id5);

    int getScreenHeight(@NotNull Context context);

    int getScreenWidth(@NotNull Context context);

    int getScreenWidthForSplit(boolean useWidthPixel, @Nullable Context context);

    float getSplitRatioOfFunction();

    @NotNull
    String getString(@StringRes int resId);

    @NotNull
    String getString(@StringRes int resId, @NotNull Object... args);

    boolean isInSplitViewMode(@Nullable Context context);

    boolean isPhone(@Nullable Context ctx);

    void launchFragmentInSplitMode(@NotNull Context context, @NotNull Intent intent, @NotNull Class<? extends QPublicBaseFragment> fragmentClass, @NotNull LaunchMode launchMode);

    @NotNull
    LiveData<Bitmap> obtainBubbleDrawableBitmap(@DrawableRes int resId);

    @NotNull
    LiveData<Integer> obtainDrawableColor(@NotNull Context context, @DrawableRes int res);

    void setStatusBarColor(@Nullable Activity activity, int color);

    boolean shouldLaunchInSplitViewMode(@Nullable Context context);

    void showQuitAioDialog(@NotNull Context context, @NotNull String factoryName, @NotNull QuitReason reason);
}

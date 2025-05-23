package com.tencent.mobileqq.guild.util.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import androidx.annotation.DrawableRes;
import androidx.lifecycle.LiveData;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.temp.api.IGuildActivityApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.theme.QuiBitmapResourceObtainColorHelper;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bv;
import com.tencent.mobileqq.guild.util.impl.QQGuildUIUtilApiImpl;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.pad.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J-\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00180\u0017\"\u0004\u0018\u00010\u0018H\u0016\u00a2\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0016J0\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0'2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\"\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040'2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0007\u001a\u00020\u0004H\u0016J\u001a\u0010*\u001a\u00020\u001e2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u0004H\u0016J\u0012\u0010.\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010/\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u000202H\u0016\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/util/impl/QQGuildUIUtilApiImpl;", "Lcom/tencent/mobileqq/guild/util/IQQGuildUIUtilApi;", "()V", "dp2px", "", "dp", "", "res", "Landroid/content/res/Resources;", "getColor", "context", "Landroid/content/Context;", "id", "getScreenHeight", "getScreenWidth", "getScreenWidthForSplit", "useWidthPixel", "", "getSplitRatioOfFunction", "getString", "", "resId", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "isInSplitViewMode", "isPhone", "ctx", "launchFragmentInSplitMode", "", "intent", "Landroid/content/Intent;", "fragmentClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", AppConstants.Preferences.LAUNCH_MODE, "Lcom/tencent/mobileqq/pad/LaunchMode;", "obtainBubbleDrawableBitmap", "Landroidx/lifecycle/LiveData;", "Landroid/graphics/Bitmap;", "obtainDrawableColor", "setStatusBarColor", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "color", "shouldLaunchInSplitViewMode", "showQuitAioDialog", "factoryName", "reason", "Lcom/tencent/mobileqq/guild/util/IQQGuildUIUtilApi$QuitReason;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class QQGuildUIUtilApiImpl implements IQQGuildUIUtilApi {
    @Override // com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi
    public int dp2px(float dp5, @Nullable Resources res) {
        return QQGuildUIUtil.e(dp5, res);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi
    public int getColor(int id5) {
        return QQGuildUIUtil.h(id5);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi
    public int getScreenHeight(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return bv.a(context);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi
    public int getScreenWidth(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return bv.b(context);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi
    public int getScreenWidthForSplit(boolean useWidthPixel, @Nullable Context context) {
        return GuildSplitViewUtils.f235370a.i(useWidthPixel, context);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi
    public float getSplitRatioOfFunction() {
        if (e.a() == SplitViewState.STATE_FLAT) {
            return e.g();
        }
        return 1.0f;
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi
    @NotNull
    public String getString(int resId) {
        String r16 = QQGuildUIUtil.r(resId);
        Intrinsics.checkNotNullExpressionValue(r16, "getString(resId)");
        return r16;
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi
    public boolean isInSplitViewMode(@Nullable Context context) {
        return GuildSplitViewUtils.f235370a.n(context);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi
    public boolean isPhone(@Nullable Context ctx) {
        if (ctx == null) {
            ctx = BaseApplication.getContext();
        }
        if (PadUtil.a(ctx) == DeviceType.PHONE) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi
    public void launchFragmentInSplitMode(@NotNull Context context, @NotNull Intent intent, @NotNull Class<? extends QPublicBaseFragment> fragmentClass, @NotNull LaunchMode launchMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        Intrinsics.checkNotNullParameter(launchMode, "launchMode");
        GuildSplitViewUtils.f235370a.v(context, intent, fragmentClass, false, launchMode);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi
    @NotNull
    public LiveData<Bitmap> obtainBubbleDrawableBitmap(int resId) {
        return QuiBitmapResourceObtainColorHelper.f235295a.e(resId);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi
    @NotNull
    public LiveData<Integer> obtainDrawableColor(@NotNull Context context, @DrawableRes int res) {
        Intrinsics.checkNotNullParameter(context, "context");
        return QuiBitmapResourceObtainColorHelper.g(context, res);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi
    public void setStatusBarColor(@Nullable Activity activity, int color) {
        QQGuildUIUtil.L(activity, color);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi
    public boolean shouldLaunchInSplitViewMode(@Nullable Context context) {
        return GuildSplitViewUtils.f235370a.D(context);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi
    public void showQuitAioDialog(@NotNull Context context, @NotNull String factoryName, @NotNull IQQGuildUIUtilApi.QuitReason reason) {
        int i3;
        Context context2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(factoryName, "factoryName");
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).transChannelType(factoryName) != 1) {
            return;
        }
        if (reason == IQQGuildUIUtilApi.QuitReason.VISIBILITY_CHANGE) {
            i3 = R.string.f141890hw;
        } else if (reason == IQQGuildUIUtilApi.QuitReason.KICK_OUT) {
            i3 = R.string.f140120d4;
        } else {
            i3 = R.string.f156611ko;
        }
        if ((context instanceof Activity) && ((IGuildActivityApi) QRoute.api(IGuildActivityApi.class)).isGuildChatActivity((Activity) context)) {
            context2 = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getSplashActivity();
        } else {
            context2 = context;
        }
        if (context2 != null) {
            DialogUtil.createCustomDialog(context2, 230, (String) null, HardCodeUtil.qqStr(i3), (String) null, context.getString(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: c12.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i16) {
                    QQGuildUIUtilApiImpl.showQuitAioDialog$lambda$0(dialogInterface, i16);
                }
            }, (DialogInterface.OnClickListener) null).show();
        }
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi
    public int getColor(@NotNull Context context, int id5) {
        Intrinsics.checkNotNullParameter(context, "context");
        return QQGuildUIUtil.i(context, id5);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi
    @NotNull
    public String getString(int resId, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        String s16 = QQGuildUIUtil.s(resId, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(s16, "getString(resId, *args)");
        return s16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showQuitAioDialog$lambda$0(DialogInterface dialogInterface, int i3) {
    }
}

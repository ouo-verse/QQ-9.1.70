package com.tencent.mobileqq.vas.util;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/util/VasPadUtils;", "", "()V", "getSplitLeftWidth", "", "context", "Landroid/content/Context;", "getSplitRightWidth", "isPadLandscape", "", "isPadSplitLandscape", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasPadUtils {

    @NotNull
    public static final VasPadUtils INSTANCE = new VasPadUtils();

    VasPadUtils() {
    }

    public final int getSplitLeftWidth(@Nullable Context context) {
        View view;
        if (!isPadSplitLandscape(context) || !(context instanceof QBaseActivity)) {
            return -1;
        }
        FragmentManager supportFragmentManager = ((QBaseActivity) context).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.supportFragmentManager");
        Fragment findFragmentById = supportFragmentManager.findFragmentById(R.id.vea);
        if (findFragmentById == null || (view = findFragmentById.getView()) == null) {
            return -1;
        }
        return view.getWidth();
    }

    public final int getSplitRightWidth(@Nullable Context context) {
        if (isPadSplitLandscape(context) && (context instanceof QBaseActivity)) {
            return ImmersiveUtils.getScreenHeight() - getSplitLeftWidth(context);
        }
        return -1;
    }

    public final boolean isPadLandscape(@Nullable Context context) {
        if (context == null || !AppSetting.p(context) || context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        return true;
    }

    public final boolean isPadSplitLandscape(@Nullable Context context) {
        if (context == null || !AppSetting.t(context) || !isPadLandscape(context)) {
            return false;
        }
        return true;
    }
}

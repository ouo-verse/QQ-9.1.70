package com.tencent.icgame.game.liveroom.impl.room.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.util.x;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a:\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u001a\u0016\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f\u001a\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f\u001aB\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00162\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u000f\u001a<\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002\u00a8\u0006\u001f"}, d2 = {"Landroid/content/Context;", "context", "Landroid/view/View;", "containerView", "Lcom/tencent/icgame/game/liveroom/impl/room/util/o;", DownloadInfo.spKey_Config, "Landroid/widget/PopupWindow;", "e", "Lkotlin/Function1;", "", "preShow", "f", "", "size", "b", "", "d", "originW", "originH", "folderWishW", "folderWishH", "isSupportFolder", "Lkotlin/Pair;", "c", "Lcom/tencent/icgame/game/liveroom/impl/room/util/PopWindowType;", "type", "realWidth", "realHeight", "", "param", "a", "ic-game-timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class n {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f115702a;

        static {
            int[] iArr = new int[PopWindowType.values().length];
            try {
                iArr[PopWindowType.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PopWindowType.WEB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f115702a = iArr;
        }
    }

    private static final PopupWindow a(PopWindowType popWindowType, Context context, View view, int i3, int i16, Object obj) {
        int i17 = a.f115702a[popWindowType.ordinal()];
        if (i17 != 1) {
            if (i17 != 2) {
                return new PopupWindow(view, i3, i16);
            }
            return new com.tencent.icgame.game.liveroom.impl.room.livewebdialog.g(view, i3, i16);
        }
        return new PopupWindow(view, i3, i16);
    }

    public static final int b(@NotNull Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!d(i3)) {
            return x.c(context.getApplicationContext(), i3);
        }
        return i3;
    }

    @NotNull
    public static final Pair<Integer, Integer> c(@NotNull Context context, int i3, int i16, int i17, int i18, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (z16 && (b.a(context) || b.c(context) || ut0.a.d(context))) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "context.resources.displayMetrics");
            i3 = displayMetrics.widthPixels;
            int i19 = displayMetrics.heightPixels;
            if (i3 > i17 || d(i17)) {
                i3 = i17;
            }
            if (i19 <= i18 && !d(i18)) {
                i16 = i19;
            } else {
                i16 = i18;
            }
        }
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public static final boolean d(int i3) {
        if (i3 != -2 && i3 != -1) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final PopupWindow e(@NotNull Context context, @NotNull View containerView, @NotNull o config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        Intrinsics.checkNotNullParameter(config, "config");
        return f(context, containerView, config, null);
    }

    @NotNull
    public static final PopupWindow f(@NotNull Context context, @Nullable View view, @NotNull o config, @Nullable Function1<? super PopupWindow, Unit> function1) {
        int originWidth;
        int originHeight;
        int folderWidth;
        int folderHeight;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        if (config.getIsOriginDp()) {
            originWidth = b(context, config.getOriginWidth());
        } else {
            originWidth = config.getOriginWidth();
        }
        int i3 = originWidth;
        if (config.getIsOriginDp()) {
            originHeight = b(context, config.getOriginHeight());
        } else {
            originHeight = config.getOriginHeight();
        }
        int i16 = originHeight;
        if (config.getIsFolderDp()) {
            folderWidth = b(context, config.getFolderWidth());
        } else {
            folderWidth = config.getFolderWidth();
        }
        int i17 = folderWidth;
        if (config.getIsFolderDp()) {
            folderHeight = b(context, config.getFolderHeight());
        } else {
            folderHeight = config.getFolderHeight();
        }
        Pair<Integer, Integer> c16 = c(context, i3, i16, i17, folderHeight, config.getIsSupportFolder());
        PopupWindow a16 = a(config.getPopType(), context, view, c16.getFirst().intValue(), c16.getSecond().intValue(), config.getParam());
        a16.setBackgroundDrawable(new ColorDrawable(config.getColor()));
        if (config.getIsShowAnim()) {
            a16.setAnimationStyle(config.getAnimationStyle());
        }
        a16.setOutsideTouchable(config.getIsOutsideTouchable());
        a16.setTouchable(config.getIsTouchable());
        a16.setFocusable(config.getIsFocusable());
        if (function1 != null) {
            function1.invoke(a16);
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                a16.showAtLocation(activity.getWindow().getDecorView(), config.getCom.tencent.ditto.shell.LayoutAttrDefine.Gravity.Gravity java.lang.String(), 0, 0);
            }
        } else {
            Activity topActivity = Foreground.getTopActivity();
            if (!topActivity.isFinishing() && !topActivity.isDestroyed()) {
                a16.showAtLocation(topActivity.getWindow().getDecorView(), config.getCom.tencent.ditto.shell.LayoutAttrDefine.Gravity.Gravity java.lang.String(), 0, 0);
            }
        }
        return a16;
    }
}

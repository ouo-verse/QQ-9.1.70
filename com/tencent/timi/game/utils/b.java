package com.tencent.timi.game.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.av.utils.ba;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import vn4.TimiPicInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u0002\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0003\u001a\u001e\u0010\u000b\u001a\u0004\u0018\u00010\n*\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b\u001a\u001c\u0010\u000e\u001a\u0004\u0018\u00010\n*\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b\u001a\u001b\u0010\u0012\u001a\u00020\u0011*\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a\n\u0010\u0014\u001a\u00020\u0004*\u00020\u000f\"\u0015\u0010\u0017\u001a\u00020\u0000*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0015\u0010\u001b\u001a\u00020\u0018*\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0015\u0010\u001b\u001a\u00020\u0018*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\"\u0017\u0010\"\u001a\u0004\u0018\u00010\u001f*\u00020\u001e8F\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u0006#"}, d2 = {"", tl.h.F, "k", "", "", "i", "Lcom/tencent/image/URLImageView;", "url", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "options", "Lcom/tencent/image/URLDrawable;", "g", "Lvn4/a;", "timiPicInfo", "f", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "", "e", "(Ltrpc/yes/common/CommonOuterClass$QQUserId;Ljava/lang/Long;)Z", "j", "a", "(I)I", "dp", "", "b", "(F)F", "dpf", "c", "(I)F", "Landroid/view/View;", "Landroid/app/Activity;", "d", "(Landroid/view/View;)Landroid/app/Activity;", "hostActivity", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {
    public static final int a(int i3) {
        return (int) ba.dp2px(BaseApplication.getContext(), i3);
    }

    public static final float b(float f16) {
        return ba.dp2px(BaseApplication.getContext(), f16);
    }

    public static final float c(int i3) {
        return ba.dp2px(BaseApplication.getContext(), i3);
    }

    @Nullable
    public static final Activity d(@NotNull View view) {
        ViewGroup viewGroup;
        Context context;
        FrameLayout frameLayout;
        View childAt;
        Intrinsics.checkNotNullParameter(view, "<this>");
        View rootView = view.getRootView();
        if (rootView instanceof ViewGroup) {
            viewGroup = (ViewGroup) rootView;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null && (frameLayout = (FrameLayout) viewGroup.findViewById(R.id.content)) != null && (childAt = frameLayout.getChildAt(0)) != null) {
            context = childAt.getContext();
        } else {
            context = null;
        }
        if (!(context instanceof Activity)) {
            return null;
        }
        return (Activity) context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
    
        if (r0 != r7.longValue()) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean e(@NotNull CommonOuterClass$QQUserId commonOuterClass$QQUserId, @Nullable Long l3) {
        Intrinsics.checkNotNullParameter(commonOuterClass$QQUserId, "<this>");
        if (commonOuterClass$QQUserId.uid.get() != 0) {
            long j3 = commonOuterClass$QQUserId.uid.get();
            if (l3 != null) {
            }
        }
        if (commonOuterClass$QQUserId.yes_uid.get() != 0) {
            long j16 = commonOuterClass$QQUserId.yes_uid.get();
            if (l3 != null && j16 == l3.longValue()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static final URLDrawable f(@NotNull URLImageView uRLImageView, @NotNull TimiPicInfo timiPicInfo, @NotNull URLDrawable.URLDrawableOptions options) {
        Intrinsics.checkNotNullParameter(uRLImageView, "<this>");
        Intrinsics.checkNotNullParameter(timiPicInfo, "timiPicInfo");
        Intrinsics.checkNotNullParameter(options, "options");
        int picType = timiPicInfo.getPicType();
        if (picType != 1 && picType != 2) {
            if (picType == 3) {
                options.mPlayGifImage = false;
                options.mUseApngImage = true;
            }
        } else {
            options.mPlayGifImage = true;
            options.mUseApngImage = false;
        }
        return g(uRLImageView, timiPicInfo.getUrl(), options);
    }

    @Nullable
    public static final URLDrawable g(@NotNull URLImageView uRLImageView, @Nullable String str, @NotNull URLDrawable.URLDrawableOptions options) {
        boolean z16;
        Intrinsics.checkNotNullParameter(uRLImageView, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        boolean z17 = false;
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
            }
        }
        URLDrawable uRLDrawable = null;
        if (!z17) {
            return null;
        }
        try {
            uRLDrawable = ((ei4.a) mm4.b.b(ei4.a.class)).m(str, options);
            uRLImageView.setImageDrawable(uRLDrawable);
            return uRLDrawable;
        } catch (Exception e16) {
            l.f("URLImageView", "setUrlSafety failed, url:" + str, e16);
            return uRLDrawable;
        }
    }

    public static final int h(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 != 3) {
            return 1;
        }
        return 4;
    }

    @NotNull
    public static final String i(long j3) {
        String o16 = ((ll4.a) mm4.b.b(ll4.a.class)).o(j3);
        Intrinsics.checkNotNullExpressionValue(o16, "getService(ILoginCoreSer\u2026nsignedLongToString(this)");
        return o16;
    }

    @NotNull
    public static final String j(@NotNull CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        Intrinsics.checkNotNullParameter(commonOuterClass$QQUserId, "<this>");
        return commonOuterClass$QQUserId.uid.get() + "_" + commonOuterClass$QQUserId.yes_uid.get();
    }

    public static final int k(int i3) {
        switch (i3) {
            case 101:
            default:
                return 1;
            case 102:
                return 6;
            case 103:
                return 7;
            case 104:
                return 8;
            case 105:
                return 9;
        }
    }
}

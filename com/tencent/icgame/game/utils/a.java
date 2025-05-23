package com.tencent.icgame.game.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.av.utils.ba;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001b\u0010\f\u001a\u00020\u000b*\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\t\"\u0015\u0010\u0012\u001a\u00020\u000f*\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u0015\u0010\u0016\u001a\u00020\u0013*\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u0018*\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001c"}, d2 = {"", "", "f", "Lcom/tencent/image/URLImageView;", "url", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "options", "Lcom/tencent/image/URLDrawable;", "e", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "userId", "", "d", "(Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;Ljava/lang/Long;)Z", "g", "", "a", "(I)I", "dp", "", "b", "(I)F", "dpf", "Landroid/view/View;", "Landroid/app/Activity;", "c", "(Landroid/view/View;)Landroid/app/Activity;", "hostActivity", "ic-game-timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a {
    public static final int a(int i3) {
        return (int) ba.dp2px(BaseApplication.getContext(), i3);
    }

    public static final float b(int i3) {
        return ba.dp2px(BaseApplication.getContext(), i3);
    }

    @Nullable
    public static final Activity c(@NotNull View view) {
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
    public static final boolean d(@NotNull CommonOuterClass$QQUserId commonOuterClass$QQUserId, @Nullable Long l3) {
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
    public static final URLDrawable e(@NotNull URLImageView uRLImageView, @Nullable String str, @NotNull URLDrawable.URLDrawableOptions options) {
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
            uRLDrawable = ((bv0.a) qx0.a.b(bv0.a.class)).m(str, options);
            uRLImageView.setImageDrawable(uRLDrawable);
            return uRLDrawable;
        } catch (Exception e16) {
            g.e("URLImageView", "setUrlSafety failed, url:" + str, e16);
            return uRLDrawable;
        }
    }

    @NotNull
    public static final String f(long j3) {
        String o16 = ((mx0.a) qx0.a.b(mx0.a.class)).o(j3);
        Intrinsics.checkNotNullExpressionValue(o16, "getService(ILoginCoreSer\u2026nsignedLongToString(this)");
        return o16;
    }

    @NotNull
    public static final String g(@NotNull CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        Intrinsics.checkNotNullParameter(commonOuterClass$QQUserId, "<this>");
        return commonOuterClass$QQUserId.uid.get() + "_" + commonOuterClass$QQUserId.yes_uid.get();
    }
}

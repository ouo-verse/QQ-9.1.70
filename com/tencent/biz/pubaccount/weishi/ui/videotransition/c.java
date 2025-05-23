package com.tencent.biz.pubaccount.weishi.ui.videotransition;

import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi.main.WSMainContainerFragment;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.k;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J \u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007JJ\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0007J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0007J\b\u0010\u0019\u001a\u00020\u000eH\u0007J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0007J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0007J\"\u0010#\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0007J\u0012\u0010$\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0002J\u0012\u0010'\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%H\u0007J\u0012\u0010(\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%H\u0007J\u0012\u0010)\u001a\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010%H\u0007J\u0014\u0010+\u001a\u0004\u0018\u00010\u00102\b\u0010*\u001a\u0004\u0018\u00010\u001aH\u0007R\u0017\u0010/\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0014\u00101\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u00100R \u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/ui/videotransition/c;", "", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/k;", "params", "Landroid/content/Intent;", "intent", "", "isPerformEndTransitionNoStart", "p", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "context", "Ljava/lang/Class;", "fragmentClass", "Landroid/graphics/RectF;", "enterStartAnimLocation", "Landroid/graphics/drawable/Drawable;", "coverDrawable", "", "requestCode", "o", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "a", "d", "Landroid/view/View;", "view", "l", h.F, "", "rootWidth", "rootHeight", "LUserGrowth/stSimpleMetaFeed;", "feed", "c", "f", "Landroid/os/Bundle;", "bundle", "j", "i", "g", "itemView", "b", "I", "e", "()I", "IMAGE_VIEW_FOR_ANIM_BOTTOM_MARGIN", "Landroid/graphics/RectF;", "cacheEnterStartAnimRect", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "cacheDrawableRef", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f81667a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int IMAGE_VIEW_FOR_ANIM_BOTTOM_MARGIN = ScreenUtil.dip2px(46.0f);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final RectF cacheEnterStartAnimRect = new RectF();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static WeakReference<Drawable> cacheDrawableRef;

    c() {
    }

    @JvmStatic
    public static final Drawable a() {
        WeakReference<Drawable> weakReference = cacheDrawableRef;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        WeakReference<Drawable> weakReference2 = cacheDrawableRef;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        cacheDrawableRef = null;
        return drawable;
    }

    @JvmStatic
    public static final RectF c(float rootWidth, float rootHeight, stSimpleMetaFeed feed) {
        float f16;
        float f17;
        float f18 = rootHeight - IMAGE_VIEW_FOR_ANIM_BOTTOM_MARGIN;
        float f19 = f81667a.f(feed);
        if (f19 < 0.64285713f) {
            f17 = f18;
            f16 = 0.0f;
        } else {
            float f26 = rootWidth / f19;
            f16 = (f18 - f26) / 2;
            f17 = f26 + f16;
        }
        return new RectF(0.0f, f16, rootWidth, f17);
    }

    @JvmStatic
    public static final RectF d() {
        return cacheEnterStartAnimRect;
    }

    @JvmStatic
    public static final void l(View view) {
        RectF rectF = cacheEnterStartAnimRect;
        RectF h16 = h(view);
        Intrinsics.checkNotNull(h16);
        rectF.set(h16);
    }

    @JvmStatic
    public static final boolean n(k params, Intent intent, boolean isPerformEndTransitionNoStart) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Context e16 = params.e();
        Intrinsics.checkNotNullExpressionValue(e16, "params.context");
        return o(e16, WSMainContainerFragment.class, intent, h(params.b()), b(params.b()), isPerformEndTransitionNoStart, params.s());
    }

    @JvmStatic
    public static final boolean o(Context context, Class<?> fragmentClass, Intent intent, RectF enterStartAnimLocation, Drawable coverDrawable, boolean isPerformEndTransitionNoStart, int requestCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra("public_fragment_class", WSMainContainerFragment.class.getName());
        intent.putExtra("key_is_need_perform_end_transition_no_start", isPerformEndTransitionNoStart);
        boolean z16 = context instanceof Activity;
        Class<?> cls = PublicTransFragmentActivity.class;
        if (z16 && coverDrawable != null) {
            intent.setClass(context, cls);
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("key_is_need_perform_transition", true);
            intent.putExtra("key_enter_start_anim_location", enterStartAnimLocation);
            x.j("WSVideoTransitionAnimUtil", "startActivityWithTransition() with animation. fragmentClass = " + fragmentClass.getSimpleName());
            k(coverDrawable);
            f81667a.m(context, intent, requestCode);
            ((Activity) context).overridePendingTransition(0, 0);
            return true;
        }
        x.j("WSVideoTransitionAnimUtil", "startActivityWithTransition() no animation. context = " + context + ", coverDrawable = " + coverDrawable + ", fragmentClass = " + fragmentClass.getSimpleName());
        if (!isPerformEndTransitionNoStart) {
            cls = PublicFragmentActivity.class;
        }
        intent.setClass(context, cls);
        if (!z16) {
            intent.setFlags(268435456);
        }
        f81667a.m(context, intent, requestCode);
        return false;
    }

    @JvmStatic
    public static final boolean p(k params, Intent intent, boolean isPerformEndTransitionNoStart) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Context e16 = params.e();
        Intrinsics.checkNotNullExpressionValue(e16, "params.context");
        return q(e16, WSMainContainerFragment.class, intent, h(params.b()), b(params.b()), isPerformEndTransitionNoStart, 0, 64, null);
    }

    public final int e() {
        return IMAGE_VIEW_FOR_ANIM_BOTTOM_MARGIN;
    }

    private final float f(stSimpleMetaFeed feed) {
        stMetaUgcImage stmetaugcimage;
        int i3;
        int i16;
        stMetaUgcImage stmetaugcimage2;
        int i17;
        int i18;
        ArrayList<stMetaUgcImage> arrayList = feed != null ? feed.images : null;
        if (arrayList == null) {
            return 0.0f;
        }
        if (arrayList.size() > 1 && (stmetaugcimage2 = arrayList.get(1)) != null && (i17 = stmetaugcimage2.width) != 0 && (i18 = stmetaugcimage2.height) != 0) {
            return i17 / i18;
        }
        if (arrayList.size() <= 0 || (stmetaugcimage = arrayList.get(0)) == null || (i3 = stmetaugcimage.width) == 0 || (i16 = stmetaugcimage.height) == 0) {
            return 0.0f;
        }
        return i3 / i16;
    }

    @JvmStatic
    public static final RectF g(Bundle bundle) {
        RectF rectF = bundle != null ? (RectF) bundle.getParcelable("key_enter_start_anim_location") : null;
        return rectF == null ? new RectF() : rectF;
    }

    private final void m(Context context, Intent intent, int requestCode) {
        if (requestCode > 0 && (context instanceof Activity)) {
            ((Activity) context).startActivityForResult(intent, requestCode);
        } else {
            context.startActivity(intent);
        }
    }

    @JvmStatic
    public static final Drawable b(View itemView) {
        ImageView imageView = itemView != null ? (ImageView) itemView.findViewWithTag("transitionAnim") : null;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    @JvmStatic
    public static final RectF h(View view) {
        ImageView imageView = view != null ? (ImageView) view.findViewWithTag("transitionAnim") : null;
        if (imageView == null) {
            return null;
        }
        int[] iArr = new int[2];
        imageView.getLocationInWindow(iArr);
        float f16 = iArr[0];
        float f17 = iArr[1];
        return new RectF(f16, f17, imageView.getWidth() + f16, imageView.getHeight() + f17);
    }

    @JvmStatic
    public static final boolean i(Bundle bundle) {
        if (bundle != null) {
            return bundle.getBoolean("key_is_need_perform_end_transition_no_start", false);
        }
        return false;
    }

    @JvmStatic
    public static final boolean j(Bundle bundle) {
        if (bundle != null) {
            return bundle.getBoolean("key_is_need_perform_transition", false);
        }
        return false;
    }

    @JvmStatic
    public static final void k(Drawable coverDrawable) {
        if (coverDrawable == null) {
            return;
        }
        cacheDrawableRef = new WeakReference<>(coverDrawable);
    }

    public static /* synthetic */ boolean q(Context context, Class cls, Intent intent, RectF rectF, Drawable drawable, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 64) != 0) {
            i3 = 0;
        }
        return o(context, cls, intent, rectF, drawable, z16, i3);
    }
}

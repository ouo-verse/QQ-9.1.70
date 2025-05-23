package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.matchfriend.widget.RoundCornerImageView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$StImage;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J(\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00022\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0014R\u0016\u0010\u001d\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/section/QQStrangerImageSection;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/section/a;", "", "sizeType", "Landroid/graphics/Point;", "viewSize", "", "url", "", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", HippyTKDListViewAdapter.X, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "data", "position", "", "", "payload", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "d", "Landroid/view/View;", "imageLayout", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "imageIv", "f", "narrowImageIv", tl.h.F, "I", "<init>", "()V", "i", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerImageSection extends a {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    private static final Lazy<Boolean> f244291m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View imageLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView imageIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView narrowImageIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int position;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/section/QQStrangerImageSection$a;", "", "", "downgradeUrlDrawable$delegate", "Lkotlin/Lazy;", "b", "()Z", "downgradeUrlDrawable", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.QQStrangerImageSection$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) QQStrangerImageSection.f244291m.getValue()).booleanValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Boolean> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.QQStrangerImageSection$Companion$downgradeUrlDrawable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqstranger_feed_image_url_drawable", false));
            }
        });
        f244291m = lazy;
    }

    private final Drawable x(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_fill_standard_primary));
        return gradientDrawable;
    }

    private final void z(Point viewSize, String url) {
        ImageView imageView = this.imageIv;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIv");
            imageView = null;
        }
        imageView.setVisibility(0);
        ImageView imageView3 = this.narrowImageIv;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("narrowImageIv");
            imageView3 = null;
        }
        imageView3.setVisibility(8);
        ImageView imageView4 = this.imageIv;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIv");
            imageView4 = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView4.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = viewSize.x;
            layoutParams.height = viewSize.y;
            ImageView imageView5 = this.imageIv;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageIv");
                imageView5 = null;
            }
            imageView5.setLayoutParams(layoutParams);
        }
        ImageView imageView6 = this.imageIv;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIv");
            imageView6 = null;
        }
        Context context = imageView6.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "imageIv.context");
        Drawable x16 = x(context);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = x16;
        obtain.mFailedDrawable = x16;
        obtain.mRequestWidth = viewSize.x;
        obtain.mRequestHeight = viewSize.y;
        ImageView imageView7 = this.imageIv;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIv");
            imageView7 = null;
        }
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        drawable.setDecodeHandler(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.c(0));
        imageView7.setImageDrawable(drawable);
        if (QLog.isDevelopLevel()) {
            ImageView imageView8 = this.imageIv;
            if (imageView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageIv");
            } else {
                imageView2 = imageView8;
            }
            QLog.d("QQStrangerImageSection", 1, "loadImageByURLDrawable viewId:" + imageView2.hashCode() + " url:" + url);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindData(FeedPB$Feed data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.position = position;
        FeedPB$StImage c16 = u72.a.c(data);
        View view = null;
        if (c16 == null) {
            View view2 = this.imageLayout;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageLayout");
            } else {
                view = view2;
            }
            view.setVisibility(8);
            return;
        }
        String url = c16.url.get();
        if (url == null || url.length() == 0) {
            View view3 = this.imageLayout;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageLayout");
            } else {
                view = view3;
            }
            view.setVisibility(8);
            return;
        }
        View view4 = this.imageLayout;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageLayout");
            view4 = null;
        }
        view4.setVisibility(0);
        int i3 = c16.width.get();
        int i16 = c16.high.get();
        if (i3 <= 0 || i16 <= 0) {
            i3 = 100;
            i16 = 100;
        }
        ImageView imageView = this.imageIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIv");
            imageView = null;
        }
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "imageIv.context");
        int c17 = com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.a.c(context, i3, i16);
        ImageView imageView2 = this.imageIv;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIv");
        } else {
            view = imageView2;
        }
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "imageIv.context");
        Point f16 = com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.a.f(context2, c17, i3, i16);
        if (INSTANCE.b()) {
            Intrinsics.checkNotNullExpressionValue(url, "url");
            z(f16, url);
        } else {
            Intrinsics.checkNotNullExpressionValue(url, "url");
            y(c17, f16, url);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.ol8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.layout_image)");
        this.imageLayout = findViewById;
        View findViewById2 = containerView.findViewById(R.id.oks);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.iv_image)");
        this.imageIv = (ImageView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.okt);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.iv_image_narrow)");
        this.narrowImageIv = (ImageView) findViewById3;
        ImageView imageView = this.imageIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIv");
            imageView = null;
        }
        RoundCornerImageView roundCornerImageView = imageView instanceof RoundCornerImageView ? (RoundCornerImageView) imageView : null;
        if (roundCornerImageView != null) {
            int e16 = com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.e(2);
            roundCornerImageView.setCorner(e16, e16, e16, e16);
        }
        KeyEvent.Callback callback = this.narrowImageIv;
        if (callback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("narrowImageIv");
            callback = null;
        }
        RoundCornerImageView roundCornerImageView2 = callback instanceof RoundCornerImageView ? (RoundCornerImageView) callback : null;
        if (roundCornerImageView2 != null) {
            int e17 = com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.e(2);
            roundCornerImageView2.setCorner(e17, e17, e17, e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.or7};
    }

    private final void y(int sizeType, Point viewSize, String url) {
        ImageView imageView;
        if (sizeType == 3) {
            ImageView imageView2 = this.imageIv;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageIv");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
            ImageView imageView3 = this.narrowImageIv;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("narrowImageIv");
                imageView3 = null;
            }
            imageView3.setVisibility(0);
            ImageView imageView4 = this.narrowImageIv;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("narrowImageIv");
                imageView4 = null;
            }
            ViewGroup.LayoutParams layoutParams = imageView4.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = viewSize.x;
                layoutParams.height = viewSize.y;
                ImageView imageView5 = this.imageIv;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageIv");
                    imageView5 = null;
                }
                imageView5.setLayoutParams(layoutParams);
            }
            imageView = this.narrowImageIv;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("narrowImageIv");
                imageView = null;
            }
        } else {
            ImageView imageView6 = this.narrowImageIv;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("narrowImageIv");
                imageView6 = null;
            }
            imageView6.setVisibility(8);
            ImageView imageView7 = this.imageIv;
            if (imageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageIv");
                imageView7 = null;
            }
            imageView7.setVisibility(0);
            ImageView imageView8 = this.imageIv;
            if (imageView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageIv");
                imageView8 = null;
            }
            ViewGroup.LayoutParams layoutParams2 = imageView8.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = viewSize.x;
                layoutParams2.height = viewSize.y;
                ImageView imageView9 = this.imageIv;
                if (imageView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageIv");
                    imageView9 = null;
                }
                imageView9.setLayoutParams(layoutParams2);
            }
            imageView = this.imageIv;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageIv");
                imageView = null;
            }
        }
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "realImageView.context");
        Drawable x16 = x(context);
        Option option = Option.obtain().setTargetView(imageView).setRequestWidth(viewSize.x).setRequestHeight(viewSize.y).setUrl(url).setLoadingDrawable(x16).setFailDrawable(x16);
        com.tencent.libra.util.a aVar = com.tencent.libra.util.a.f118813a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        aVar.m(option, "kuikly");
        QQPicLoader.f201806a.e(option, null);
        if (QLog.isDevelopLevel()) {
            QLog.d("QQStrangerImageSection", 1, "loadImageByLibra targetView:" + imageView.hashCode() + " viewSize:" + viewSize + " " + sizeType + " url:" + url);
        }
    }
}

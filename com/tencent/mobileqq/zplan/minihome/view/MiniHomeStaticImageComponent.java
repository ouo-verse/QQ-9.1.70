package com.tencent.mobileqq.zplan.minihome.view;

import android.graphics.drawable.Drawable;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/view/MiniHomeStaticImageComponent;", "", "", "imageUrlOrPath", "", "isNightTheme", "", "d", "c", "Landroid/widget/FrameLayout;", "a", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "staticImageView", "<init>", "(Landroid/widget/FrameLayout;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeStaticImageComponent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final FrameLayout container;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ImageView staticImageView;

    public MiniHomeStaticImageComponent(FrameLayout container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.container = container;
        ImageView imageView = new ImageView(container.getContext());
        imageView.setVisibility(8);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.staticImageView = imageView;
        container.addView(imageView);
    }

    public final void c() {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.view.MiniHomeStaticImageComponent$hideImageView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ImageView imageView;
                QLog.i("MiniHomeStaticImageComponent", 1, "staticImageView hide");
                imageView = MiniHomeStaticImageComponent.this.staticImageView;
                imageView.setVisibility(8);
            }
        });
    }

    public final void d(final String imageUrlOrPath, final boolean isNightTheme) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.view.MiniHomeStaticImageComponent$showImageView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FrameLayout frameLayout;
                boolean z16;
                ImageView imageView;
                ImageView imageView2;
                try {
                    int i3 = isNightTheme ? R.drawable.f159885il4 : R.drawable.f159884il3;
                    frameLayout = this.container;
                    Drawable drawable = frameLayout.getContext().getResources().getDrawable(i3);
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mLoadingDrawable = drawable;
                    obtain.mFailedDrawable = drawable;
                    if (URLUtil.isNetworkUrl(imageUrlOrPath)) {
                        drawable = URLDrawable.getDrawable(imageUrlOrPath, obtain);
                    } else {
                        String str = imageUrlOrPath;
                        if (str != null && str.length() != 0) {
                            z16 = false;
                            if (!z16 && com.tencent.zplan.common.utils.c.f385288a.h(imageUrlOrPath)) {
                                drawable = URLDrawable.getFileDrawable(imageUrlOrPath, obtain);
                            }
                        }
                        z16 = true;
                        if (!z16) {
                            drawable = URLDrawable.getFileDrawable(imageUrlOrPath, obtain);
                        }
                    }
                    QLog.i("MiniHomeStaticImageComponent", 1, "staticImageView show, image:" + imageUrlOrPath + ", isNightTheme:" + isNightTheme);
                    imageView = this.staticImageView;
                    imageView.setImageDrawable(drawable);
                    imageView2 = this.staticImageView;
                    imageView2.setVisibility(0);
                } catch (Throwable th5) {
                    QLog.w("MiniHomeStaticImageComponent", 1, "setImageDrawable error for: " + imageUrlOrPath, th5);
                }
            }
        });
    }
}

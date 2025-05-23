package com.tencent.mobileqq.gamecenter.qa.view;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.C11728RoundRectUrlImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0010\u001a\u001a\u00020\b\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0002H\u0016J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006H\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/view/c;", "Landroidx/viewpager/widget/PagerAdapter;", "", "getCount", "Landroid/view/View;", "view", "", "object", "", "isViewFromObject", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "position", "instantiateItem", "", "getPageWidth", "obj", "", "destroyItem", "", "", "d", "Ljava/util/List;", "mUrlList", "e", "Z", "mIsGuildManager", "f", UserInfo.SEX_FEMALE, "pageWidthFactor", tl.h.F, "Ljava/lang/Integer;", "pageWidth", "<init>", "(Ljava/util/List;Z)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c extends PagerAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> mUrlList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean mIsGuildManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float pageWidthFactor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer pageWidth;

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/view/c$a", "Lcom/tencent/image/URLDrawableDownListener;", "Landroid/view/View;", "view", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "throwable", "onLoadFailed", "onLoadCancelled", "Ljava/lang/InterruptedException;", "e", "onLoadInterrupted", "", "i", "onLoadProgressed", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements URLDrawableDownListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f213148d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ C11728RoundRectUrlImageView f213149e;

        a(ImageView imageView, C11728RoundRectUrlImageView c11728RoundRectUrlImageView) {
            this.f213148d = imageView;
            this.f213149e = c11728RoundRectUrlImageView;
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(@NotNull View view, @NotNull URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(@NotNull View view, @NotNull URLDrawable urlDrawable, @NotNull Throwable throwable) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.f213148d.setVisibility(0);
            this.f213149e.setBackgroundResource(R.drawable.jpx);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(@NotNull View view, @NotNull URLDrawable urlDrawable, @NotNull InterruptedException e16) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Intrinsics.checkNotNullParameter(e16, "e");
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(@NotNull View view, @NotNull URLDrawable urlDrawable, int i3) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(@NotNull View view, @NotNull URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            this.f213148d.setVisibility(8);
            this.f213149e.setBackgroundColor(0);
        }
    }

    public c(@NotNull List<String> mUrlList, boolean z16) {
        Integer valueOf;
        Intrinsics.checkNotNullParameter(mUrlList, "mUrlList");
        this.mUrlList = mUrlList;
        this.mIsGuildManager = z16;
        this.pageWidth = 0;
        if (!z16) {
            valueOf = Integer.valueOf(com.tencent.mobileqq.utils.x.a(283.0f));
        } else {
            valueOf = Integer.valueOf(com.tencent.mobileqq.utils.x.a(227.0f));
        }
        this.pageWidth = valueOf;
        Intrinsics.checkNotNull(valueOf);
        this.pageWidthFactor = (valueOf.intValue() + com.tencent.mobileqq.utils.x.a(16.0f)) / ViewUtils.getScreenWidth();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object obj) {
        View view;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (obj instanceof View) {
            view = (View) obj;
        } else {
            view = null;
        }
        if (view != null) {
            container.removeView(view);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.mUrlList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public float getPageWidth(int position) {
        return this.pageWidthFactor;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup container, int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.ebs, container, false);
        View findViewById = view.findViewById(R.id.xjq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<RoundR\u2026mageView>(R.id.img_guide)");
        C11728RoundRectUrlImageView c11728RoundRectUrlImageView = (C11728RoundRectUrlImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.f97005j8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById<RoundR\u2026eView>(R.id.thumb_failed)");
        ImageView imageView = (ImageView) findViewById2;
        ViewGroup.LayoutParams layoutParams = c11728RoundRectUrlImageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (position == 0) {
            layoutParams2.leftMargin = com.tencent.mobileqq.utils.x.a(16.0f);
            layoutParams2.rightMargin = 0;
        } else if (position == getF373114d() - 1) {
            layoutParams2.rightMargin = com.tencent.mobileqq.utils.x.a(16.0f);
            layoutParams2.leftMargin = 0;
        }
        Integer num = this.pageWidth;
        Intrinsics.checkNotNull(num);
        layoutParams2.width = num.intValue();
        c11728RoundRectUrlImageView.setAllRadius(com.tencent.mobileqq.utils.x.a(8.0f));
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        c11728RoundRectUrlImageView.setImageDrawable(URLDrawable.getDrawable(this.mUrlList.get(position), obtain));
        imageView.setVisibility(8);
        c11728RoundRectUrlImageView.setURLDrawableDownListener(new a(imageView, c11728RoundRectUrlImageView));
        container.addView(view);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object object) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(object, "object");
        return Intrinsics.areEqual(view, object);
    }
}

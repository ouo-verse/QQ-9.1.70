package com.tencent.timi.game.userinfo.impl.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.userinfo.impl.view.widget.InnerTagMeasureLinear;
import com.tencent.timi.game.utils.d;
import fh4.b;
import fh4.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAchievement;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 B\u001b\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b\u001f\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006$"}, d2 = {"Lcom/tencent/timi/game/userinfo/impl/view/widget/InnerTagView;", "Landroid/widget/FrameLayout;", "", "e", "Lcom/tencent/image/URLDrawable;", "bgDrawable", "d", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "b", "c", "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleAchievement;", "data", "setData", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "nickTagIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "nickTagTextView", "f", "bgImageView", "Lcom/tencent/timi/game/userinfo/impl/view/widget/InnerTagMeasureLinear;", h.F, "Lcom/tencent/timi/game/userinfo/impl/view/widget/InnerTagMeasureLinear;", "tagLinearView", "", "i", "Z", "showTagIcon", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class InnerTagView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView nickTagIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView nickTagTextView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView bgImageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private InnerTagMeasureLinear tagLinearView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean showTagIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/timi/game/userinfo/impl/view/widget/InnerTagView$a", "Lcom/tencent/timi/game/userinfo/impl/view/widget/InnerTagMeasureLinear$a;", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements InnerTagMeasureLinear.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ URLDrawable f380272b;

        a(URLDrawable uRLDrawable) {
            this.f380272b = uRLDrawable;
        }

        @Override // com.tencent.timi.game.userinfo.impl.view.widget.InnerTagMeasureLinear.a
        public void a() {
            InnerTagView.this.d(this.f380272b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTagView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        e();
    }

    private final URLDrawable.URLDrawableOptions b() {
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#F89700"));
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        obtain.mRequestHeight = b.b(12);
        return obtain;
    }

    private final URLDrawable.URLDrawableOptions c() {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        obtain.mRequestHeight = b.b(10);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(URLDrawable bgDrawable) {
        int i3;
        ViewGroup.LayoutParams layoutParams;
        InnerTagMeasureLinear innerTagMeasureLinear = this.tagLinearView;
        int i16 = 0;
        if (innerTagMeasureLinear != null) {
            i3 = innerTagMeasureLinear.getMeasuredWidth();
        } else {
            i3 = 0;
        }
        ImageView imageView = this.bgImageView;
        if (imageView != null) {
            i16 = imageView.getMeasuredWidth();
        }
        if (i3 != i16) {
            ImageView imageView2 = this.bgImageView;
            if (imageView2 != null) {
                layoutParams = imageView2.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((ViewGroup.LayoutParams) ((FrameLayout.LayoutParams) layoutParams)).width = i3;
                ImageView imageView3 = this.bgImageView;
                if (imageView3 != null) {
                    imageView3.setLayoutParams(layoutParams);
                }
                ImageView imageView4 = this.bgImageView;
                if (imageView4 != null) {
                    imageView4.requestLayout();
                }
                ImageView imageView5 = this.bgImageView;
                if (imageView5 != null) {
                    imageView5.setImageDrawable(bgDrawable);
                }
            }
        }
    }

    private final void e() {
        LayoutInflater.from(getContext()).inflate(R.layout.hxg, this);
        this.nickTagIcon = (ImageView) findViewById(R.id.zqu);
        this.nickTagTextView = (TextView) findViewById(R.id.zqv);
        this.bgImageView = (ImageView) findViewById(R.id.a7w);
        this.tagLinearView = (InnerTagMeasureLinear) findViewById(R.id.f920556u);
    }

    public final void setData(@NotNull YesGameInfoOuterClass$YesGameRoleAchievement data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.showTagIcon) {
            String str = data.icon.get();
            if (!TextUtils.isEmpty(str)) {
                ImageView imageView = this.nickTagIcon;
                if (imageView != null) {
                    g.o(imageView, true);
                }
                d.f380295a.d(str, this.nickTagIcon, c());
            } else {
                ImageView imageView2 = this.nickTagIcon;
                if (imageView2 != null) {
                    g.o(imageView2, false);
                }
            }
        }
        TextView textView = this.nickTagTextView;
        if (textView != null) {
            textView.setText(data.text.get());
        }
        URLDrawable a16 = d.f380295a.a(data.background.get(), b());
        InnerTagMeasureLinear innerTagMeasureLinear = this.tagLinearView;
        if (innerTagMeasureLinear != null) {
            innerTagMeasureLinear.setMeasureListener(new a(a16));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        e();
    }
}

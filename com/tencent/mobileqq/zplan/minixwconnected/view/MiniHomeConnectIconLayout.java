package com.tencent.mobileqq.zplan.minixwconnected.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectIconLayout;", "Landroid/widget/RelativeLayout;", "Landroid/widget/ImageView;", "d", "Lkotlin/Lazy;", "a", "()Landroid/widget/ImageView;", "iconImgView", "Landroid/widget/TextView;", "e", "b", "()Landroid/widget/TextView;", "iconTextView", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "iconImgDrawable", "", "iconText", "<init>", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeConnectIconLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy iconImgView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy iconTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeConnectIconLayout(final Context context, final Drawable drawable, final String iconText) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iconText, "iconText");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectIconLayout$iconImgView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                ImageView imageView = new ImageView(context);
                Drawable drawable2 = drawable;
                imageView.setTag("iconImgView");
                if (drawable2 != null) {
                    imageView.setImageDrawable(drawable2);
                }
                imageView.setBackgroundResource(R.drawable.i3z);
                imageView.setPadding(0, com.tencent.sqshow.zootopia.utils.i.b(12), 0, com.tencent.sqshow.zootopia.utils.i.b(12));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.tencent.sqshow.zootopia.utils.i.b(48), com.tencent.sqshow.zootopia.utils.i.b(48));
                layoutParams.addRule(14);
                layoutParams.addRule(10);
                imageView.setLayoutParams(layoutParams);
                return imageView;
            }
        });
        this.iconImgView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectIconLayout$iconTextView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textView = new TextView(context);
                String str = iconText;
                Context context2 = context;
                textView.setTag("iconTextView");
                textView.setText(str);
                textView.setTextSize(12.0f);
                textView.setTextColor(context2.getResources().getColor(R.color.f7985q));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.tencent.sqshow.zootopia.utils.i.b(20));
                layoutParams.addRule(14);
                layoutParams.addRule(12);
                layoutParams.topMargin = com.tencent.sqshow.zootopia.utils.i.b(4);
                textView.setLayoutParams(layoutParams);
                return textView;
            }
        });
        this.iconTextView = lazy2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.tencent.sqshow.zootopia.utils.i.b(73), com.tencent.sqshow.zootopia.utils.i.b(84));
        layoutParams.addRule(12);
        setLayoutParams(layoutParams);
        addView(a());
        addView(b());
    }

    private final ImageView a() {
        return (ImageView) this.iconImgView.getValue();
    }

    private final TextView b() {
        return (TextView) this.iconTextView.getValue();
    }
}

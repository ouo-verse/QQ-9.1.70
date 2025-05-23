package com.tencent.timi.game.profile.impl.view.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.timi.game.widget.MediumBoldTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nr2.ar;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0010\u0010\u0014B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0010\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/timi/game/profile/impl/view/record/ProfileSmobaRecordView;", "Lcom/tencent/timi/game/profile/impl/view/record/BaseProfileSmobaRecordView;", "Landroid/content/Context;", "context", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "t", "a", "Lnr2/ar;", "i", "Lnr2/ar;", "binding", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ProfileSmobaRecordView extends BaseProfileSmobaRecordView {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ar binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSmobaRecordView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        ar f16 = ar.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        z(context);
    }

    @Override // com.tencent.timi.game.profile.impl.view.record.BaseProfileSmobaRecordView, co4.b
    public void a() {
        LinearLayout root = this.binding.f420861d.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.firstDescribeItem.root");
        LinearLayout root2 = this.binding.f420871n.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.secondDescribeItem.root");
        LinearLayout root3 = this.binding.f420872o.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "binding.thirdDescribeItem.root");
        u(root, root2, root3);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec((int) Math.round(getMeasuredWidth() * 0.358d), 1073741824));
    }

    @Override // com.tencent.timi.game.profile.impl.view.record.BaseProfileSmobaRecordView
    public void t() {
        ImageView imageView = this.binding.f420868k;
        if (imageView != null) {
            y(imageView, i());
        }
        MediumBoldTextView mediumBoldTextView = this.binding.f420865h;
        if (mediumBoldTextView != null) {
            mediumBoldTextView.setText(h());
        }
        MediumBoldTextView mediumBoldTextView2 = this.binding.f420866i;
        if (mediumBoldTextView2 != null) {
            mediumBoldTextView2.setText(g());
        }
        LinearLayout root = this.binding.f420861d.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.firstDescribeItem.root");
        LinearLayout root2 = this.binding.f420871n.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.secondDescribeItem.root");
        LinearLayout root3 = this.binding.f420872o.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "binding.thirdDescribeItem.root");
        u(root, root2, root3);
        ar arVar = this.binding;
        x(arVar.f420862e, arVar.f420870m);
        RoundImageView roundImageView = this.binding.f420859b;
        if (roundImageView != null) {
            roundImageView.setmRadius(8, false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSmobaRecordView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ar f16 = ar.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        z(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSmobaRecordView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        ar f16 = ar.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        z(context);
    }

    private final void z(Context context) {
    }
}

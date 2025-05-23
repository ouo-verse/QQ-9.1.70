package com.tencent.timi.game.profile.impl.view.record;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import fh4.b;
import fh4.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nr2.an;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\f\u0010\u0010B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\f\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/timi/game/profile/impl/view/record/MessageSmobaRecordView;", "Lcom/tencent/timi/game/profile/impl/view/record/BaseProfileSmobaRecordView;", "Landroid/content/Context;", "context", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "t", "a", "Lnr2/an;", "i", "Lnr2/an;", "binding", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class MessageSmobaRecordView extends BaseProfileSmobaRecordView {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final an binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageSmobaRecordView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        an f16 = an.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        z(context);
    }

    private final void z(Context context) {
        LinearLayout linearLayout = this.binding.f420835b;
        if (linearLayout != null) {
            g.f(linearLayout, b.b(4), Color.parseColor("#FEFAF1"));
        }
    }

    @Override // com.tencent.timi.game.profile.impl.view.record.BaseProfileSmobaRecordView, co4.b
    public void a() {
        LinearLayout root = this.binding.f420836c.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.firstDescribeItem.root");
        LinearLayout root2 = this.binding.f420844k.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.secondDescribeItem.root");
        LinearLayout root3 = this.binding.f420845l.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "binding.thirdDescribeItem.root");
        u(root, root2, root3);
    }

    @Override // com.tencent.timi.game.profile.impl.view.record.BaseProfileSmobaRecordView
    public void t() {
        ImageView imageView = this.binding.f420841h;
        if (imageView != null) {
            y(imageView, i());
        }
        LinearLayout root = this.binding.f420836c.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.firstDescribeItem.root");
        LinearLayout root2 = this.binding.f420844k.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.secondDescribeItem.root");
        LinearLayout root3 = this.binding.f420845l.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "binding.thirdDescribeItem.root");
        u(root, root2, root3);
        an anVar = this.binding;
        x(anVar.f420837d, anVar.f420843j);
        TextView textView = this.binding.f420839f;
        if (textView != null) {
            textView.setText(g());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageSmobaRecordView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        an f16 = an.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        z(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageSmobaRecordView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        an f16 = an.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        z(context);
    }
}

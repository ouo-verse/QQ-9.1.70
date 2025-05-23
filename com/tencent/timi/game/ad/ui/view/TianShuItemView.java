package com.tencent.timi.game.ad.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nr2.aj;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vn4.TimiPicInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/timi/game/ad/ui/view/TianShuItemView;", "Lcom/tencent/timi/game/ad/ui/view/BaseOperationSingleItemView;", "Lcom/tencent/timi/game/ui/widget/RoundCornerImageView;", "c", "Lvn4/a;", "d", "Landroid/widget/TextView;", "e", "", "b", "Lnr2/aj;", "i", "Lnr2/aj;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "", MiniChatConstants.MINI_APP_LANDSCAPE, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TianShuItemView extends BaseOperationSingleItemView {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private aj binding;

    public /* synthetic */ TianShuItemView(Context context, AttributeSet attributeSet, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, z16);
    }

    @Override // com.tencent.timi.game.ad.ui.view.BaseOperationSingleItemView
    @NotNull
    protected RoundCornerImageView c() {
        RoundCornerImageView roundCornerImageView = this.binding.f420816b;
        Intrinsics.checkNotNullExpressionValue(roundCornerImageView, "binding.operationIgv");
        return roundCornerImageView;
    }

    @Override // com.tencent.timi.game.ad.ui.view.BaseOperationSingleItemView
    @NotNull
    protected TimiPicInfo d() {
        return getData().getPic();
    }

    @Override // com.tencent.timi.game.ad.ui.view.BaseOperationSingleItemView
    @NotNull
    protected TextView e() {
        TextView textView = this.binding.f420817c;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.timerTxv");
        return textView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TianShuItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, boolean z16) {
        super(context, attributeSet, i3, z16);
        Intrinsics.checkNotNullParameter(context, "context");
        aj g16 = aj.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
    }

    @Override // com.tencent.timi.game.ad.ui.view.BaseOperationSingleItemView
    public void b() {
    }
}

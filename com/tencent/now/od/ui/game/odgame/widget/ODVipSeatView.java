package com.tencent.now.od.ui.game.odgame.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.now.od.ui.common.widget.VipSeatView;
import com.tencent.od.res.VoiceGameRes;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pn3.a;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0006\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/now/od/ui/game/odgame/widget/ODVipSeatView;", "Lcom/tencent/now/od/ui/common/widget/VipSeatView;", "", "initView", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "odMatchResultBg", "G", "odMatchSeatNo", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "odChoosingState", "I", "odHat", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "J", "a", "qq-live-od-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class ODVipSeatView extends VipSeatView {

    @NotNull
    private static final Map<Integer, String> K;

    @NotNull
    private static final Map<Integer, VoiceGameRes> L;

    @NotNull
    private static final Map<Integer, VoiceGameRes> M;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView odMatchResultBg;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView odMatchSeatNo;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView odChoosingState;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView odHat;

    static {
        Map<Integer, String> mapOf;
        Map<Integer, VoiceGameRes> mapOf2;
        Map<Integer, VoiceGameRes> mapOf3;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, "\u9009\u62e9\u4e2d"), TuplesKt.to(2, "\u5df2\u9009\u62e9"));
        K = mapOf;
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(1, a.f426516h0), TuplesKt.to(2, a.f426518i0));
        L = mapOf2;
        mapOf3 = MapsKt__MapsKt.mapOf(TuplesKt.to(1, a.T), TuplesKt.to(2, a.U), TuplesKt.to(3, a.V), TuplesKt.to(4, a.W), TuplesKt.to(5, a.X), TuplesKt.to(6, a.Y), TuplesKt.to(7, a.Z), TuplesKt.to(8, a.f426502a0));
        M = mapOf3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ODVipSeatView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.now.od.ui.common.widget.VipSeatView
    public void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.f167668e00, this);
        super.initView();
        View findViewById = findViewById(R.id.zw8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.od_match_result_bg)");
        this.odMatchResultBg = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.zw9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.od_match_seat_no)");
        this.odMatchSeatNo = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.zw5);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.od_choosing_state)");
        this.odChoosingState = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.zw6);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.od_hat)");
        ImageView imageView = (ImageView) findViewById4;
        this.odHat = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("odHat");
            imageView = null;
        }
        vn3.a.b(imageView, a.f426524l0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ODVipSeatView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ODVipSeatView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ODVipSeatView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}

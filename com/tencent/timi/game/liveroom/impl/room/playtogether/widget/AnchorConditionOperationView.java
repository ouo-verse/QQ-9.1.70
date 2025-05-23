package com.tencent.timi.game.liveroom.impl.room.playtogether.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.AnchorPlayTogetherPresenter;
import com.tencent.timi.game.widget.MediumBoldTextView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ug4.a;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorConditionOperationView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/AnchorPlayTogetherPresenter$a;", "actionButton", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/AnchorPlayTogetherPresenter;", "presenter", "", "e", "Lnr2/g;", "d", "Lnr2/g;", "binding", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class AnchorConditionOperationView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final nr2.g binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorConditionOperationView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(AnchorPlayTogetherPresenter.a actionButton, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(actionButton, "$actionButton");
        actionButton.b().invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map g(AnchorPlayTogetherPresenter anchorPlayTogetherPresenter, String str) {
        String str2;
        Map mutableMapOf;
        Pair[] pairArr = new Pair[2];
        if (anchorPlayTogetherPresenter == null || (str2 = Integer.valueOf(anchorPlayTogetherPresenter.getMCurCondition()).toString()) == null) {
            str2 = "0";
        }
        pairArr[0] = TuplesKt.to("qqlive_play_teamrequire", str2);
        pairArr[1] = TuplesKt.to("zengzhi_moduleid", "em_qqlive_palysetting");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map h(String str) {
        Map mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zengzhi_moduleid", "em_qqlive_palysetting"));
        return mutableMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map i(AnchorPlayTogetherPresenter anchorPlayTogetherPresenter, String str) {
        String str2;
        Map mutableMapOf;
        Pair[] pairArr = new Pair[2];
        if (anchorPlayTogetherPresenter == null || (str2 = Integer.valueOf(anchorPlayTogetherPresenter.getMCurCondition()).toString()) == null) {
            str2 = "0";
        }
        pairArr[0] = TuplesKt.to("qqlive_play_teamrequire", str2);
        pairArr[1] = TuplesKt.to("zengzhi_moduleid", "em_qqlive_palysetting");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    public final void e(@NotNull final AnchorPlayTogetherPresenter.a actionButton, @Nullable final AnchorPlayTogetherPresenter presenter) {
        Intrinsics.checkNotNullParameter(actionButton, "actionButton");
        MediumBoldTextView mediumBoldTextView = this.binding.f421060b;
        if (mediumBoldTextView != null) {
            mediumBoldTextView.setVisibility(8);
            mediumBoldTextView.setVisibility(0);
            mediumBoldTextView.setText(actionButton.getText());
            mediumBoldTextView.setTextColor(actionButton.getTextColor());
            mediumBoldTextView.setBackgroundDrawable(yn4.c.b(actionButton.getBgDrawable()));
            mediumBoldTextView.setActivated(actionButton.getEnable());
            mediumBoldTextView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.widget.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnchorConditionOperationView.f(AnchorPlayTogetherPresenter.a.this, view);
                }
            });
        }
        if (actionButton.getMode() == 1) {
            mm4.a b16 = mm4.b.b(ug4.a.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
            MediumBoldTextView mediumBoldTextView2 = this.binding.f421060b;
            Intrinsics.checkNotNullExpressionValue(mediumBoldTextView2, "binding.actionBtn");
            a.C11346a.a((ug4.a) b16, mediumBoldTextView2, false, null, "em_qqlive_play_createteam", null, 22, null);
            VideoReport.setEventDynamicParams(this.binding.f421060b, new IDynamicParams() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.widget.f
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map g16;
                    g16 = AnchorConditionOperationView.g(AnchorPlayTogetherPresenter.this, str);
                    return g16;
                }
            });
            return;
        }
        if (actionButton.getMode() == 2) {
            mm4.a b17 = mm4.b.b(ug4.a.class);
            Intrinsics.checkNotNullExpressionValue(b17, "getService(ILiveReportService::class.java)");
            MediumBoldTextView mediumBoldTextView3 = this.binding.f421060b;
            Intrinsics.checkNotNullExpressionValue(mediumBoldTextView3, "binding.actionBtn");
            a.C11346a.a((ug4.a) b17, mediumBoldTextView3, false, null, "em_qqlive_play_close", null, 22, null);
            VideoReport.setEventDynamicParams(this.binding.f421060b, new IDynamicParams() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.widget.g
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map h16;
                    h16 = AnchorConditionOperationView.h(str);
                    return h16;
                }
            });
            mm4.a b18 = mm4.b.b(ug4.a.class);
            Intrinsics.checkNotNullExpressionValue(b18, "getService(ILiveReportService::class.java)");
            MediumBoldTextView mediumBoldTextView4 = this.binding.f421060b;
            Intrinsics.checkNotNullExpressionValue(mediumBoldTextView4, "binding.actionBtn");
            a.C11346a.a((ug4.a) b18, mediumBoldTextView4, false, null, "em_qqlive_play_savesetting", null, 22, null);
            VideoReport.setEventDynamicParams(this.binding.f421060b, new IDynamicParams() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.widget.h
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map i3;
                    i3 = AnchorConditionOperationView.i(AnchorPlayTogetherPresenter.this, str);
                    return i3;
                }
            });
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorConditionOperationView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ AnchorConditionOperationView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorConditionOperationView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        nr2.g f16 = nr2.g.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        setOrientation(0);
        setPadding(fh4.b.b(16), 0, fh4.b.b(16), 0);
    }
}

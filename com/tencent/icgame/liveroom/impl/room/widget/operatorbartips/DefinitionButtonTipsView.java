package com.tencent.icgame.liveroom.impl.room.widget.operatorbartips;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.icgame.api.ITimiGameApi;
import com.tencent.icgame.liveroom.impl.room.widget.operatorbartips.DefinitionButtonTipsView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.icgame.context.QQLiveContext;
import com.tencent.mobileqq.icgame.techreport.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import xw0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001 B\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aB\u001b\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u0019\u0010\u001dB#\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001e\u001a\u00020\n\u00a2\u0006\u0004\b\u0019\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006!"}, d2 = {"Lcom/tencent/icgame/liveroom/impl/room/widget/operatorbartips/DefinitionButtonTipsView;", "Landroid/widget/FrameLayout;", "", "eventId", "", "g", h.F, "Lcom/tencent/icgame/liveroom/impl/room/widget/operatorbartips/DefinitionButtonTipsView$a;", "listener", "setOnListener", "", "e", "d", "i", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "switchDefinitionTv", "Lcom/tencent/icgame/liveroom/impl/room/widget/operatorbartips/DefinitionButtonTipsView$a;", "mListener", "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "mAutoHideRunnable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class DefinitionButtonTipsView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView switchDefinitionTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a mListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable mAutoHideRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/icgame/liveroom/impl/room/widget/operatorbartips/DefinitionButtonTipsView$a;", "", "", "a", "onHide", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void onHide();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefinitionButtonTipsView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.fc6, this);
        TextView textView = (TextView) findViewById(R.id.f911454d);
        this.switchDefinitionTv = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: ry0.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DefinitionButtonTipsView.c(DefinitionButtonTipsView.this, view);
                }
            });
        }
        g("dt_imp");
        h("ev_icgame_show_switch_definition_tips");
        this.mAutoHideRunnable = new Runnable() { // from class: ry0.c
            @Override // java.lang.Runnable
            public final void run() {
                DefinitionButtonTipsView.f(DefinitionButtonTipsView.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(DefinitionButtonTipsView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.mListener;
        if (aVar != null) {
            aVar.a();
        }
        this$0.g("dt_clck");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(DefinitionButtonTipsView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.mListener;
        if (aVar != null) {
            aVar.onHide();
        }
    }

    private final void g(String eventId) {
        HashMap hashMap = new HashMap();
        hashMap.put("dt_eid", "em_qqlive_poor_network_notice");
        hashMap.put("dt_pgid", "pg_icgame_audience");
        hashMap.putAll(b.f448881a.e());
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent(eventId, hashMap);
    }

    private final void h(String eventId) {
        Map mapOf;
        try {
            String str = "";
            QQLiveContext b16 = QQLiveContext.INSTANCE.b("1078");
            if (b16 != null) {
                str = b16.getTraceId();
            }
            b bVar = b.f448881a;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(AudienceReportConst.ROOM_ID, String.valueOf(bVar.h())), TuplesKt.to("room_type", String.valueOf(bVar.s())), TuplesKt.to("user_id", String.valueOf(bVar.u())), TuplesKt.to("ext1", str));
            d.g(eventId, mapOf);
        } catch (Exception unused) {
            rt0.a.INSTANCE.h("DefinitionController", "reportToEagle", "send video quality fail! ");
        }
    }

    public final void d() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mAutoHideRunnable);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.mAutoHideRunnable, com.tencent.icgame.game.liveroom.impl.room.definition.a.INSTANCE.a().getTipsShowTime());
    }

    public final int e() {
        return ViewUtils.dpToPx(34.0f);
    }

    public final void i() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mAutoHideRunnable);
    }

    public final void setOnListener(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListener = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefinitionButtonTipsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.fc6, this);
        TextView textView = (TextView) findViewById(R.id.f911454d);
        this.switchDefinitionTv = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: ry0.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DefinitionButtonTipsView.c(DefinitionButtonTipsView.this, view);
                }
            });
        }
        g("dt_imp");
        h("ev_icgame_show_switch_definition_tips");
        this.mAutoHideRunnable = new Runnable() { // from class: ry0.c
            @Override // java.lang.Runnable
            public final void run() {
                DefinitionButtonTipsView.f(DefinitionButtonTipsView.this);
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefinitionButtonTipsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.fc6, this);
        TextView textView = (TextView) findViewById(R.id.f911454d);
        this.switchDefinitionTv = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: ry0.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DefinitionButtonTipsView.c(DefinitionButtonTipsView.this, view);
                }
            });
        }
        g("dt_imp");
        h("ev_icgame_show_switch_definition_tips");
        this.mAutoHideRunnable = new Runnable() { // from class: ry0.c
            @Override // java.lang.Runnable
            public final void run() {
                DefinitionButtonTipsView.f(DefinitionButtonTipsView.this);
            }
        };
    }
}

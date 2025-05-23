package com.tencent.sqshow.zootopia.nativeui.view.history;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.bw;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u00101\u001a\u000200\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u0012\b\b\u0002\u00104\u001a\u00020\u0010\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001c\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u001c\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\tJ$\u0010\u0012\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\u0006\u0010\u0011\u001a\u00020\u0010R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R6\u0010'\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010#0\"j\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010#`$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u0014R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,\u00a8\u00067"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/history/PortalStoreHistoryControllerView;", "Landroid/widget/FrameLayout;", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "p", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/LiveData;", "Lw74/a;", "historyData", DomainData.DOMAIN_NAME, "Lm94/g;", "j", "Ls94/c;", "", "slotId", "k", "d", "I", "SPECIAL_SLOT_ID", "Ln74/bw;", "e", "Ln74/bw;", "mBinding", "Lcom/tencent/sqshow/zootopia/nativeui/view/history/g;", "f", "Lcom/tencent/sqshow/zootopia/nativeui/view/history/g;", "getListener", "()Lcom/tencent/sqshow/zootopia/nativeui/view/history/g;", "setListener", "(Lcom/tencent/sqshow/zootopia/nativeui/view/history/g;)V", "listener", "Ljava/util/HashMap;", "Lm94/j;", "Lkotlin/collections/HashMap;", tl.h.F, "Ljava/util/HashMap;", "historyListData", "i", "currentSlotId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "lastEnable", BdhLogUtil.LogTag.Tag_Conn, "nextEnable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreHistoryControllerView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean nextEnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int SPECIAL_SLOT_ID;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final bw mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private g listener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private HashMap<Integer, m94.j> historyListData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int currentSlotId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean lastEnable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreHistoryControllerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(PortalStoreHistoryControllerView this$0, com.tencent.sqshow.zootopia.nativeui.data.j channel, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(channel, "$channel");
        if (this$0.historyListData.get(Integer.valueOf(this$0.currentSlotId)) == null) {
            return;
        }
        if (this$0.lastEnable) {
            ZplanViewReportHelper mReporter = channel.getReporter().getMReporter();
            ImageView imageView = this$0.mBinding.f418943c;
            Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.lastIgv");
            ZplanViewReportHelper.f(mReporter, imageView, "em_zplan_rewind", null, 4, null);
        }
        g gVar = this$0.listener;
        if (gVar != null) {
            gVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(PortalStoreHistoryControllerView this$0, com.tencent.sqshow.zootopia.nativeui.data.j channel, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(channel, "$channel");
        if (this$0.historyListData.get(Integer.valueOf(this$0.currentSlotId)) == null) {
            return;
        }
        if (this$0.nextEnable) {
            ZplanViewReportHelper mReporter = channel.getReporter().getMReporter();
            ImageView imageView = this$0.mBinding.f418944d;
            Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.nextIgv");
            ZplanViewReportHelper.f(mReporter, imageView, "em_zplan_recover", null, 4, null);
        }
        g gVar = this$0.listener;
        if (gVar != null) {
            gVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        m94.j jVar = this.historyListData.get(Integer.valueOf(this.currentSlotId));
        if (jVar == null) {
            this.mBinding.f418943c.setAlpha(0.3f);
            this.mBinding.f418944d.setAlpha(0.3f);
            this.lastEnable = false;
            this.nextEnable = false;
            return;
        }
        if (jVar.b()) {
            this.mBinding.f418943c.setAlpha(1.0f);
            this.lastEnable = true;
        } else {
            this.mBinding.f418943c.setAlpha(0.3f);
            this.lastEnable = false;
        }
        if (jVar.a()) {
            this.mBinding.f418944d.setAlpha(1.0f);
            this.nextEnable = true;
        } else {
            this.mBinding.f418944d.setAlpha(0.3f);
            this.nextEnable = false;
        }
    }

    public final void j(LifecycleOwner owner, LiveData<m94.g> historyData) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(historyData, "historyData");
        final Function1<m94.g, Unit> function1 = new Function1<m94.g, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.history.PortalStoreHistoryControllerView$bindHistoryLiveData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(m94.g gVar) {
                invoke2(gVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(m94.g gVar) {
                int i3;
                HashMap hashMap;
                int i16;
                PortalStoreHistoryControllerView portalStoreHistoryControllerView = PortalStoreHistoryControllerView.this;
                i3 = portalStoreHistoryControllerView.SPECIAL_SLOT_ID;
                portalStoreHistoryControllerView.currentSlotId = i3;
                hashMap = PortalStoreHistoryControllerView.this.historyListData;
                i16 = PortalStoreHistoryControllerView.this.SPECIAL_SLOT_ID;
                hashMap.put(Integer.valueOf(i16), gVar);
                PortalStoreHistoryControllerView.this.s();
            }
        };
        historyData.observe(owner, new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.history.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStoreHistoryControllerView.l(Function1.this, obj);
            }
        });
    }

    public final void k(LifecycleOwner owner, LiveData<s94.c> historyData, final int slotId) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(historyData, "historyData");
        this.currentSlotId = slotId;
        s();
        final Function1<s94.c, Unit> function1 = new Function1<s94.c, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.history.PortalStoreHistoryControllerView$bindHistoryLiveData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(s94.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(s94.c cVar) {
                HashMap hashMap;
                int slotId2 = cVar.getSlotId();
                int i3 = slotId;
                if (slotId2 != i3) {
                    return;
                }
                this.currentSlotId = i3;
                hashMap = this.historyListData;
                hashMap.put(Integer.valueOf(slotId), cVar);
                this.s();
            }
        };
        historyData.observe(owner, new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.history.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStoreHistoryControllerView.m(Function1.this, obj);
            }
        });
    }

    public final void n(LifecycleOwner owner, LiveData<w74.a> historyData) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(historyData, "historyData");
        final Function1<w74.a, Unit> function1 = new Function1<w74.a, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.history.PortalStoreHistoryControllerView$bindUgcColorHistoryLiveData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(w74.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(w74.a aVar) {
                int i3;
                HashMap hashMap;
                int i16;
                PortalStoreHistoryControllerView portalStoreHistoryControllerView = PortalStoreHistoryControllerView.this;
                i3 = portalStoreHistoryControllerView.SPECIAL_SLOT_ID;
                portalStoreHistoryControllerView.currentSlotId = i3;
                hashMap = PortalStoreHistoryControllerView.this.historyListData;
                i16 = PortalStoreHistoryControllerView.this.SPECIAL_SLOT_ID;
                hashMap.put(Integer.valueOf(i16), aVar);
                PortalStoreHistoryControllerView.this.s();
            }
        };
        historyData.observe(owner, new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.history.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStoreHistoryControllerView.o(Function1.this, obj);
            }
        });
    }

    public final void p(final com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        ZplanViewReportHelper mReporter = channel.getReporter().getMReporter();
        ImageView imageView = this.mBinding.f418943c;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.lastIgv");
        mReporter.g(imageView, "em_zplan_rewind", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        this.mBinding.f418943c.setImageDrawable(ie0.a.f().o(getContext(), R.drawable.ih8, R.color.qui_common_icon_primary, 1000));
        this.mBinding.f418943c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.history.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PortalStoreHistoryControllerView.q(PortalStoreHistoryControllerView.this, channel, view);
            }
        });
        ZplanViewReportHelper mReporter2 = channel.getReporter().getMReporter();
        ImageView imageView2 = this.mBinding.f418944d;
        Intrinsics.checkNotNullExpressionValue(imageView2, "mBinding.nextIgv");
        mReporter2.g(imageView2, "em_zplan_recover", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        this.mBinding.f418944d.setImageDrawable(ie0.a.f().o(getContext(), R.drawable.ih9, R.color.qui_common_icon_primary, 1000));
        this.mBinding.f418944d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.history.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PortalStoreHistoryControllerView.r(PortalStoreHistoryControllerView.this, channel, view);
            }
        });
    }

    public final void setListener(g gVar) {
        this.listener = gVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreHistoryControllerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PortalStoreHistoryControllerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStoreHistoryControllerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.SPECIAL_SLOT_ID = -1;
        bw f16 = bw.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        this.historyListData = new HashMap<>();
        this.currentSlotId = this.SPECIAL_SLOT_ID;
    }
}

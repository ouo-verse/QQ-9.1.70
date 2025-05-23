package com.tencent.mobileqq.zplan.aio.panel.panel.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.aio.panel.page.view.PageView;
import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/panel/view/AbstractPanelLayout;", "Landroid/widget/RelativeLayout;", "", "dx", "dy", "", "d", "", "c", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/Panel;", "Lkotlinx/coroutines/flow/StateFlow;", "a", "()Lkotlinx/coroutines/flow/StateFlow;", "setDataSource", "(Lkotlinx/coroutines/flow/StateFlow;)V", "dataSource", "b", "()Lcom/tencent/mobileqq/zplan/aio/panel/panel/Panel;", "value", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class AbstractPanelLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private StateFlow<Panel> dataSource;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AbstractPanelLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final StateFlow<Panel> a() {
        return this.dataSource;
    }

    public final Panel b() {
        StateFlow<Panel> stateFlow = this.dataSource;
        Intrinsics.checkNotNull(stateFlow);
        return stateFlow.getValue();
    }

    public final void setDataSource(StateFlow<Panel> stateFlow) {
        this.dataSource = stateFlow;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AbstractPanelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AbstractPanelLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractPanelLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public boolean c() {
        if (((RecyclerView) findViewById(R.id.r6z)) == null) {
            return false;
        }
        return !r0.canScrollVertically(-1);
    }

    public final void d(int dx5, int dy5) {
        Sequence<View> emptySequence;
        Sequence mapNotNull;
        PageView pageView = (PageView) findViewById(R.id.r6z);
        ViewGroup viewGroup = null;
        if (pageView != null) {
            ViewParent parent = pageView.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            }
        }
        if (viewGroup == null || (emptySequence = ViewGroupKt.getChildren(viewGroup)) == null) {
            emptySequence = SequencesKt__SequencesKt.emptySequence();
        }
        mapNotNull = SequencesKt___SequencesKt.mapNotNull(emptySequence, new Function1<View, PageView>() { // from class: com.tencent.mobileqq.zplan.aio.panel.panel.view.AbstractPanelLayout$touchItems$3
            @Override // kotlin.jvm.functions.Function1
            public final PageView invoke(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it instanceof PageView) {
                    return (PageView) it;
                }
                return null;
            }
        });
        Iterator it = mapNotNull.iterator();
        while (it.hasNext()) {
            ((PageView) it.next()).onScrolled(dx5, dy5);
        }
    }

    public static /* synthetic */ void e(AbstractPanelLayout abstractPanelLayout, int i3, int i16, int i17, Object obj) {
        if (obj == null) {
            if ((i17 & 1) != 0) {
                i3 = 0;
            }
            if ((i17 & 2) != 0) {
                i16 = 0;
            }
            abstractPanelLayout.d(i3, i16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: touchItems");
    }
}

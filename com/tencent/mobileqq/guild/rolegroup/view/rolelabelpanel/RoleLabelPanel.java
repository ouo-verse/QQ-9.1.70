package com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import hy1.a;
import hy1.b;
import hy1.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u000bB\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bB\u001b\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001a\u0010\u001eB#\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010 B+\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010!\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\"J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\u0014\u0010\u0012\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelPanel;", "Landroid/widget/LinearLayout;", "", "e", "", "c", "Lhy1/a;", "b", "Lhy1/b;", "d", "", "a", "Lhy1/g;", "listener", "setOnLabelClickListener", "", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", "labelList", "f", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "labelListView", "Lhy1/a;", "flowAdapter", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class RoleLabelPanel extends LinearLayout {

    /* renamed from: h, reason: collision with root package name */
    private static final int f232846h = ViewUtils.dpToPx(10.0f);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecyclerView labelListView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private a flowAdapter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoleLabelPanel(@NotNull Context context) {
        this(context, null, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public boolean a() {
        return true;
    }

    @NotNull
    public a b() {
        return new a();
    }

    public int c() {
        return R.layout.f6r;
    }

    @NotNull
    public b d() {
        return new b(f232846h, 3);
    }

    public final void e() {
        View findViewById = LayoutInflater.from(getContext()).inflate(c(), this).findViewById(R.id.eap);
        Intrinsics.checkNotNullExpressionValue(findViewById, "content.findViewById(R.id.list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.labelListView = recyclerView;
        a aVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("labelListView");
            recyclerView = null;
        }
        recyclerView.setOverScrollMode(2);
        this.flowAdapter = b();
        b d16 = d();
        RecyclerView recyclerView2 = this.labelListView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("labelListView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(d16);
        RecyclerView recyclerView3 = this.labelListView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("labelListView");
            recyclerView3 = null;
        }
        a aVar2 = this.flowAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flowAdapter");
        } else {
            aVar = aVar2;
        }
        recyclerView3.setAdapter(aVar);
    }

    public final void f(@NotNull List<RoleLabelData> labelList) {
        Intrinsics.checkNotNullParameter(labelList, "labelList");
        ArrayList arrayList = new ArrayList();
        RoleLabelData roleLabelData = new RoleLabelData("add_label_group_id", 0, "\u6dfb\u52a0", 0, null, null, false, false, 0, 506, null);
        arrayList.add(new RoleLabelData("more_label_group_id", 0, null, 0, null, null, false, false, 0, 510, null));
        if (a()) {
            arrayList.add(roleLabelData);
        }
        arrayList.addAll(labelList);
        a aVar = this.flowAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flowAdapter");
            aVar = null;
        }
        aVar.m0(arrayList);
    }

    public final void setOnLabelClickListener(@NotNull g listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        a aVar = this.flowAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flowAdapter");
            aVar = null;
        }
        aVar.l0(listener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoleLabelPanel(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoleLabelPanel(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoleLabelPanel(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        e();
    }
}

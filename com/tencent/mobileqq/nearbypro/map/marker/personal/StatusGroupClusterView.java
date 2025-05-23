package com.tencent.mobileqq.nearbypro.map.marker.personal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import bb2.d;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.part.a;
import com.tencent.mobileqq.nearbypro.utils.h;
import com.tencent.mobileqq.nearbypro.utils.u;
import hb2.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001fB\u001d\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0019\u0010\u001aB\u001b\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u0019\u0010\u001dJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0000H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/marker/personal/StatusGroupClusterView;", "Landroid/widget/FrameLayout;", "Lbb2/d;", "Lhb2/c;", "", "c", "", "count", "j", "clickedData", "Lcom/tencent/mobileqq/nearbypro/part/a;", "host", "Landroid/view/MotionEvent;", "clickEvent", "i", "b", "markerItemData", "k", "d", "Lcom/tencent/mobileqq/nearbypro/part/a;", "e", "I", "curCount", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/nearbypro/part/a;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "f", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class StatusGroupClusterView extends FrameLayout implements d<c> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a host;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int curCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusGroupClusterView(@NotNull Context context, @Nullable a aVar) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.host = aVar;
        c();
    }

    private final void c() {
        u uVar = u.f253961a;
        a aVar = this.host;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        uVar.a(aVar, context, R.layout.fns, this, "StatusGroupClusterView");
        h.f253950a.d((TextView) findViewById(R.id.bal));
    }

    private final void j(int count) {
        this.curCount = count;
        if (count > 999) {
            findViewById(R.id.zen).setVisibility(0);
            count = 999;
        } else {
            findViewById(R.id.zen).setVisibility(8);
        }
        ((TextView) findViewById(R.id.bal)).setText(String.valueOf(count));
    }

    @Override // bb2.d
    public void f(@NotNull a aVar) {
        d.a.a(this, aVar);
    }

    @Override // bb2.d
    public void h() {
        d.a.b(this);
    }

    @Override // bb2.d
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void e(@NotNull c clickedData, @NotNull a host, @NotNull MotionEvent clickEvent) {
        Intrinsics.checkNotNullParameter(clickedData, "clickedData");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(clickEvent, "clickEvent");
        d.a.c(this, clickedData, host, clickEvent);
        host.t5("MSG_ON_CLUSTER_CLICK", clickedData);
    }

    @Override // bb2.d
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void g(@NotNull c markerItemData) {
        Intrinsics.checkNotNullParameter(markerItemData, "markerItemData");
        ga2.a c16 = j.c();
        if (c16.isColorLevel()) {
            c16.e("StatusGroupClusterView", "update newCount=" + markerItemData.d().size() + " curCount=" + this.curCount);
        }
        if (markerItemData.d().size() != this.curCount) {
            j(markerItemData.d().size());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusGroupClusterView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        c();
    }

    @Override // bb2.d
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public StatusGroupClusterView d() {
        return this;
    }
}

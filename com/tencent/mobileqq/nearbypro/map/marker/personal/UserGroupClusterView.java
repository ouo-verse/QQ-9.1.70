package com.tencent.mobileqq.nearbypro.map.marker.personal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import bb2.d;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.utils.h;
import com.tencent.mobileqq.nearbypro.utils.u;
import gb2.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u000fB\u001d\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0019\u0010\u001aB\u001b\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u0019\u0010\u001dJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0000H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/marker/personal/UserGroupClusterView;", "Landroid/widget/FrameLayout;", "Lbb2/d;", "Lgb2/a;", "", "b", "", "count", "i", "clickedData", "Lcom/tencent/mobileqq/nearbypro/part/a;", "host", "Landroid/view/MotionEvent;", "clickEvent", "c", "a", "markerItemData", "j", "d", "I", "curCount", "e", "Lcom/tencent/mobileqq/nearbypro/part/a;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/nearbypro/part/a;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "f", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class UserGroupClusterView extends FrameLayout implements d<a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int curCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.nearbypro.part.a host;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserGroupClusterView(@NotNull Context context, @Nullable com.tencent.mobileqq.nearbypro.part.a aVar) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.host = aVar;
        b();
    }

    private final void b() {
        u uVar = u.f253961a;
        com.tencent.mobileqq.nearbypro.part.a aVar = this.host;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        uVar.a(aVar, context, R.layout.fnk, this, "UserGroupClusterView");
        h.f253950a.d((TextView) findViewById(R.id.bal));
    }

    private final void i(int count) {
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
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void e(@NotNull a clickedData, @NotNull com.tencent.mobileqq.nearbypro.part.a host, @NotNull MotionEvent clickEvent) {
        Intrinsics.checkNotNullParameter(clickedData, "clickedData");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(clickEvent, "clickEvent");
        d.a.c(this, clickedData, host, clickEvent);
        host.t5("MSG_ON_CLUSTER_CLICK", clickedData);
    }

    @Override // bb2.d
    public void f(@NotNull com.tencent.mobileqq.nearbypro.part.a aVar) {
        d.a.a(this, aVar);
    }

    @Override // bb2.d
    public void h() {
        d.a.b(this);
    }

    @Override // bb2.d
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void g(@NotNull a markerItemData) {
        Intrinsics.checkNotNullParameter(markerItemData, "markerItemData");
        if (markerItemData.d().size() != this.curCount) {
            i(markerItemData.d().size());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserGroupClusterView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        b();
    }

    @Override // bb2.d
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UserGroupClusterView d() {
        return this;
    }
}

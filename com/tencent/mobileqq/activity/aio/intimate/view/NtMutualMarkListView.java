package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0007\u001a\u00020\u0006R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/view/NtMutualMarkListView;", "Landroid/widget/FrameLayout;", "Landroid/view/MotionEvent;", "ev", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "", "a", "Lcom/tencent/aio/frame/api/a;", "d", "Lcom/tencent/aio/frame/api/a;", "getHelper", "()Lcom/tencent/aio/frame/api/a;", "setHelper", "(Lcom/tencent/aio/frame/api/a;)V", "helper", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class NtMutualMarkListView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.frame.api.a helper;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NtMutualMarkListView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a() {
        this.helper = null;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        com.tencent.aio.frame.api.a aVar;
        com.tencent.aio.frame.api.b a16;
        com.tencent.aio.frame.api.a aVar2;
        com.tencent.aio.frame.api.b a17;
        com.tencent.aio.frame.api.a aVar3;
        com.tencent.aio.frame.api.b a18;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (ev5.getAction() == 0 && (aVar3 = this.helper) != null && (a18 = aVar3.a()) != null) {
            a18.requestDisallowInterceptTouchEvent(true);
        }
        if (ev5.getAction() == 1 && (aVar2 = this.helper) != null && (a17 = aVar2.a()) != null) {
            a17.requestDisallowInterceptTouchEvent(false);
        }
        if (ev5.getAction() == 3 && (aVar = this.helper) != null && (a16 = aVar.a()) != null) {
            a16.requestDisallowInterceptTouchEvent(false);
        }
        return super.onInterceptTouchEvent(ev5);
    }

    public final void setHelper(@Nullable com.tencent.aio.frame.api.a aVar) {
        this.helper = aVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NtMutualMarkListView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ NtMutualMarkListView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NtMutualMarkListView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.helper = new com.tencent.aio.frame.api.a(this);
    }
}

package com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.mobileqq.guild.home.views.embeddable.ScrollableLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/fragments/tabs/fragments/ScrollableContainer;", "Lcom/tencent/mobileqq/guild/home/views/embeddable/ScrollableLayout;", "Lcom/tencent/mobileqq/guild/homev2/fragments/tabs/fragments/ScrollableContainer$a;", "listener", "", "setNestedTouchListener", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "N", "Lcom/tencent/mobileqq/guild/homev2/fragments/tabs/fragments/ScrollableContainer$a;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ScrollableContainer extends ScrollableLayout {

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private a listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/fragments/tabs/fragments/ScrollableContainer$a;", "", "Landroid/view/MotionEvent;", "ev", "", "onTouchEvent", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface a {
        void onTouchEvent(@NotNull MotionEvent ev5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableContainer(@NotNull Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.guild.home.views.embeddable.ScrollableLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        a aVar = this.listener;
        if (aVar != null) {
            aVar.onTouchEvent(ev5);
        }
        return super.dispatchTouchEvent(ev5);
    }

    public final void setNestedTouchListener(@Nullable a listener) {
        this.listener = listener;
    }
}

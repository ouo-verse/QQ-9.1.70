package com.tencent.qqguild.directmessage.aio.input.container;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.aio.base.mvvm.a;
import com.tencent.aio.base.mvvm.b;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqguild.directmessage.aio.input.UIState;
import com.tencent.qqguild.directmessage.aio.input.c;
import com.tencent.qqguild.directmessage.aio.input.inputbar.InputBarViewBinder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J&\u0010\u0011\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u000f\u0012\u0006\b\u0001\u0012\u00020\u00100\u00010\u000e2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0016\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/container/InputContainerViewBinder;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqguild/directmessage/aio/input/c;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "Landroid/content/Context;", "context", "com/tencent/qqguild/directmessage/aio/input/container/InputContainerViewBinder$interceptTouchLinearLayout$1", "c1", "(Landroid/content/Context;)Lcom/tencent/qqguild/directmessage/aio/input/container/InputContainerViewBinder$interceptTouchLinearLayout$1;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/aio/base/mvvm/b;", "b1", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class InputContainerViewBinder extends a<c, UIState> {
    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.qqguild.directmessage.aio.input.container.InputContainerViewBinder$interceptTouchLinearLayout$1] */
    private final InputContainerViewBinder$interceptTouchLinearLayout$1 c1(final Context context) {
        return new LinearLayout(context) { // from class: com.tencent.qqguild.directmessage.aio.input.container.InputContainerViewBinder$interceptTouchLinearLayout$1
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                super.dispatchTouchEvent(ev5);
                return true;
            }
        };
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public b<c, UIState> getViewModel() {
        return new ys3.a();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<a<? extends ol3.b, ? extends MviUIState>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new a[]{new com.tencent.guild.aio.component.publisher.c(), new InputBarViewBinder(), new zs3.a(null, 1, 0 == true ? 1 : 0), new xs3.b(hostView)});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        InputContainerViewBinder$interceptTouchLinearLayout$1 c16 = c1(createViewParams.a());
        FrameLayout.LayoutParams a16 = com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -1, -2);
        a16.gravity = 80;
        c16.setLayoutParams(a16);
        c16.setOrientation(1);
        return c16;
    }
}

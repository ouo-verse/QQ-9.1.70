package com.tencent.mobileqq.mini.entry.aio;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.base.mvvm.a;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVM;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J&\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\r\u0012\u0006\b\u0001\u0012\u00020\u000e0\u00010\f2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0006\u0010\u0011\u001a\u00020\u0010R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/aio/MiniAIOInputContainerVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "", "getInputBarHeight", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "Landroid/widget/FrameLayout;", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniAIOInputContainerVB extends a<at.a, InputUIState> {
    private FrameLayout container;

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public BaseVM<at.a, InputUIState, com.tencent.aio.api.runtime.a> createVM() {
        return new MiniAIOInputContainerVM();
    }

    public final int getInputBarHeight() {
        return getHostView().getMeasuredHeight();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public List<a<? extends b, ? extends MviUIState>> initializeChildVB(View hostView) {
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        return new ArrayList();
    }

    @Override // com.tencent.mvi.mvvm.b
    public View onCreateView(com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        frameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.container = frameLayout;
        return frameLayout;
    }
}

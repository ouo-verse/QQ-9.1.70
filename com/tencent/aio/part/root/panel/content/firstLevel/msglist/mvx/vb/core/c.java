package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
import at.b;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007\u00a2\u0006\u0004\b$\u0010%J#\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0000\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0017J\u001f\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J#\u0010\u0018\u001a\u00020\u00072\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016H\u0010\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aH\u0016J\u001a\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0017J\n\u0010!\u001a\u0004\u0018\u00010 H\u0016R\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006&"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/c;", "Lat/b;", "I", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB;", PM.BASE, "", Constants.BASE_IN_PLUGIN_ID, "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB;)V", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "childView", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "uiHelper", "T0", "state", "u0", "(Lcom/tencent/aio/base/mvi/part/MsgListUiState;Lcom/tencent/aio/api/list/IListUIOperationApi;)V", "S0", "p", "Lcom/tencent/aio/base/mvvm/b;", "vm", "e1", "(Lcom/tencent/aio/base/mvvm/b;)V", "", "Lkotlin/Pair;", "", "e", h.F, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB$b;", "E1", "L", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public abstract class c<I extends at.b, S extends MsgListUiState> extends AbsMsgListVB<I, S> {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    private AbsMsgListVB<I, S> base;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    public final void D1(@NotNull AbsMsgListVB<I, S> base) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) base);
            return;
        }
        Intrinsics.checkNotNullParameter(base, "base");
        this.base = base;
        AbsMsgListVB.b E1 = E1();
        if (E1 != null) {
            AbsMsgListVB<I, S> absMsgListVB = this.base;
            if (absMsgListVB == null) {
                Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
            }
            absMsgListVB.C1(E1);
            C1(E1);
        }
    }

    @Nullable
    public AbsMsgListVB.b E1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (AbsMsgListVB.b) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.aio.api.list.j
    public void S0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        AbsMsgListVB<I, S> absMsgListVB = this.base;
        if (absMsgListVB == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        absMsgListVB.S0();
    }

    @Override // com.tencent.aio.api.list.j
    @SuppressLint({"ClickableViewAccessibility"})
    @NotNull
    public View T0(@NotNull com.tencent.mvi.api.help.a createViewParams, @NotNull View childView, @NotNull IListUIOperationApi uiHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, createViewParams, childView, uiHelper);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        AbsMsgListVB<I, S> absMsgListVB = this.base;
        if (absMsgListVB == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        return absMsgListVB.T0(createViewParams, childView, uiHelper);
    }

    @Override // et.a
    @NotNull
    public List<Pair<Integer, Integer>> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        AbsMsgListVB<I, S> absMsgListVB = this.base;
        if (absMsgListVB == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        return absMsgListVB.e();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB
    public void e1(@NotNull com.tencent.aio.base.mvvm.b<I, S> vm5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) vm5);
            return;
        }
        Intrinsics.checkNotNullParameter(vm5, "vm");
        super.e1(vm5);
        AbsMsgListVB<I, S> absMsgListVB = this.base;
        if (absMsgListVB == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        absMsgListVB.attachVM(vm5);
    }

    @Override // et.a
    @NotNull
    public List<Pair<Integer, Integer>> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        AbsMsgListVB<I, S> absMsgListVB = this.base;
        if (absMsgListVB == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        return absMsgListVB.h();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    @CallSuper
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onDestroy();
        AbsMsgListVB<I, S> absMsgListVB = this.base;
        if (absMsgListVB == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        absMsgListVB.destroy();
    }

    @Override // com.tencent.aio.api.list.j
    public void p(@NotNull IListUIOperationApi uiHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) uiHelper);
            return;
        }
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        AbsMsgListVB<I, S> absMsgListVB = this.base;
        if (absMsgListVB == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        absMsgListVB.p(uiHelper);
    }

    @Override // com.tencent.aio.api.list.j
    public void u0(@NotNull S state, @NotNull IListUIOperationApi uiHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) state, (Object) uiHelper);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        AbsMsgListVB<I, S> absMsgListVB = this.base;
        if (absMsgListVB == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        absMsgListVB.u0(state, uiHelper);
    }
}

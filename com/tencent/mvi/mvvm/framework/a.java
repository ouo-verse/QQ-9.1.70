package com.tencent.mvi.mvvm.framework;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\b\b\u0002\u0010\u0006*\u00020\u00052\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007B\u0007\u00a2\u0006\u0004\b \u0010!J<\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0017\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0011H\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u001b\u001a\u00020\u0011H\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001d\u001a\u00020\u001cH\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2 = {"Lcom/tencent/mvi/mvvm/framework/a;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/mvvm/framework/FrameworkVB;", "Landroid/content/Context;", "outContext", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/mvi/runtime/strategy/b;", "strategyService", "", "Lcom/tencent/mvi/dispatcher/b;", "vbCollection", "Landroid/view/View;", "emptyTestView", "parseVBTreeNodes", "host", "", "setDispatchHost$mvi_debug", "(Landroid/view/View;)V", "setDispatchHost", "getDispatchHost$mvi_debug", "()Landroid/view/View;", "getDispatchHost", "", "createViewMustOnMain", "vbNode", "Lcom/tencent/mvi/dispatcher/b;", "<init>", "()V", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public abstract class a<I extends ol3.b, S extends MviUIState, C extends com.tencent.mvi.api.runtime.b> extends FrameworkVB<I, S, C> {
    static IPatchRedirector $redirector_;
    private com.tencent.mvi.dispatcher.b vbNode;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public static /* synthetic */ com.tencent.mvi.dispatcher.b parseVBTreeNodes$default(a aVar, Context context, ViewGroup viewGroup, com.tencent.mvi.runtime.strategy.b bVar, List list, View view, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                viewGroup = null;
            }
            ViewGroup viewGroup2 = viewGroup;
            if ((i3 & 4) != 0) {
                bVar = new com.tencent.mvi.runtime.strategy.a();
            }
            return aVar.parseVBTreeNodes(context, viewGroup2, bVar, list, view);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: parseVBTreeNodes");
    }

    public boolean createViewMustOnMain() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @NotNull
    public final synchronized View getDispatchHost$mvi_debug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return getMHost$mvi_debug();
    }

    @NotNull
    public com.tencent.mvi.dispatcher.b parseVBTreeNodes(@NotNull Context outContext, @Nullable ViewGroup viewGroup, @NotNull com.tencent.mvi.runtime.strategy.b strategyService, @NotNull List<com.tencent.mvi.dispatcher.b> vbCollection, @NotNull View emptyTestView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (com.tencent.mvi.dispatcher.b) iPatchRedirector.redirect((short) 1, this, outContext, viewGroup, strategyService, vbCollection, emptyTestView);
        }
        Intrinsics.checkNotNullParameter(outContext, "outContext");
        Intrinsics.checkNotNullParameter(strategyService, "strategyService");
        Intrinsics.checkNotNullParameter(vbCollection, "vbCollection");
        Intrinsics.checkNotNullParameter(emptyTestView, "emptyTestView");
        setMContext(outContext);
        setMStrategyService(strategyService);
        onPreCreate();
        com.tencent.mvi.dispatcher.b bVar = new com.tencent.mvi.dispatcher.b(this, viewGroup);
        this.vbNode = bVar;
        Intrinsics.checkNotNull(bVar);
        vbCollection.add(bVar);
        List<BaseVB<? extends ol3.b, ? extends MviUIState, C>> initializeChildVB = initializeChildVB(emptyTestView);
        if (initializeChildVB != null) {
            getMChildren().addAll(initializeChildVB);
            Iterator<T> it = initializeChildVB.iterator();
            while (it.hasNext()) {
                BaseVB baseVB = (BaseVB) it.next();
                if (baseVB != null) {
                    com.tencent.mvi.dispatcher.b parseVBTreeNodes = baseVB.parseVBTreeNodes(outContext, null, strategyService, vbCollection, emptyTestView);
                    com.tencent.mvi.dispatcher.b bVar2 = this.vbNode;
                    Intrinsics.checkNotNull(bVar2);
                    bVar2.j(parseVBTreeNodes);
                    com.tencent.mvi.dispatcher.b bVar3 = this.vbNode;
                    Intrinsics.checkNotNull(bVar3);
                    parseVBTreeNodes.l(bVar3);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.mvi.mvvm.framework.DispatchVB<*, *, *>");
                }
            }
            com.tencent.mvi.dispatcher.b bVar4 = this.vbNode;
            Intrinsics.checkNotNull(bVar4);
            return bVar4;
        }
        com.tencent.mvi.dispatcher.b bVar5 = this.vbNode;
        Intrinsics.checkNotNull(bVar5);
        return bVar5;
    }

    public final synchronized void setDispatchHost$mvi_debug(@NotNull View host) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) host);
        } else {
            Intrinsics.checkNotNullParameter(host, "host");
            setMHost$mvi_debug(host);
        }
    }
}

package com.tencent.input.base.mvicompat;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.b;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\u000e\b\u0002\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u0005*\b\b\u0003\u0010\b*\u00020\u000722\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n0\t2\b\u0012\u0004\u0012\u00028\u00030\u000b2\u00020\fB\u000f\u0012\u0006\u0010\"\u001a\u00028\u0002\u00a2\u0006\u0004\b#\u0010$JT\u0010\u0012\u001a\u00020\u00112*\u0010\u000f\u001a&\u0012\u0004\u0012\u00020\u000e\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n0\r2\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0004J\u0014\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u00140\u0013J\u0017\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00028\u0003H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016\u00a8\u0006%"}, d2 = {"Lcom/tencent/input/base/mvicompat/g;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/input/base/mvicompat/b;", "H", "Landroidx/viewbinding/ViewBinding;", "V", "Lcom/tencent/input/base/mvicompat/DelegateMediator;", "Lcom/tencent/input/base/mvicompat/c;", "Lcom/tencent/input/base/mvicompat/d;", "Lcom/tencent/mvi/api/ability/c;", "", "", "table", "delegate", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Ljava/lang/Class;", "l", "binding", "c", "(Landroidx/viewbinding/ViewBinding;)V", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "d", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "a", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", "host", "<init>", "(Lcom/tencent/input/base/mvicompat/b;)V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public abstract class g<I extends ol3.b, S extends MviUIState, H extends b<I>, V extends ViewBinding> extends DelegateMediator<I, S, H, c<I, S, H, V>> implements d<V>, com.tencent.mvi.api.ability.c {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull H host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) host);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Iterator it = h().iterator();
        while (it.hasNext()) {
            ((c) it.next()).a();
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void c(@NotNull V binding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) binding);
            return;
        }
        Intrinsics.checkNotNullParameter(binding, "binding");
        Iterator it = h().iterator();
        while (it.hasNext()) {
            ((c) it.next()).c(binding);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) reuseParam);
            return;
        }
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        Iterator it = h().iterator();
        while (it.hasNext()) {
            ((c) it.next()).d(reuseParam);
        }
    }

    @Override // com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bundle) iPatchRedirector.redirect((short) 8, (Object) this, (Object) stateCmd);
        }
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        Bundle bundle = new Bundle();
        Iterator it = h().iterator();
        while (it.hasNext()) {
            Bundle generateVBState = ((c) it.next()).generateVBState(stateCmd);
            if (generateVBState != null) {
                if (!(!generateVBState.isEmpty())) {
                    generateVBState = null;
                }
                if (generateVBState != null) {
                    bundle.putAll(generateVBState);
                }
            }
        }
        return bundle;
    }

    @NotNull
    public final List<Class<? extends S>> l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Iterable h16 = h();
        ArrayList arrayList = new ArrayList();
        Iterator it = h16.iterator();
        while (it.hasNext()) {
            List<Class<? extends S>> observerStates = ((c) it.next()).getObserverStates();
            if (observerStates == null) {
                observerStates = CollectionsKt__CollectionsKt.emptyList();
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, observerStates);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.input.base.mvicompat.DelegateMediator
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public final void k(@NotNull Map<String, c<I, S, H, V>> table, @NotNull c<I, S, H, V> delegate) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) table, (Object) delegate);
            return;
        }
        Intrinsics.checkNotNullParameter(table, "table");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        List<Class<? extends S>> observerStates = delegate.getObserverStates();
        if (observerStates != null) {
            Iterator<T> it = observerStates.iterator();
            while (it.hasNext()) {
                String canonicalName = ((Class) it.next()).getCanonicalName();
                if (canonicalName != null) {
                    if (canonicalName.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        canonicalName = null;
                    }
                    if (canonicalName != null) {
                        table.put(canonicalName, delegate);
                    }
                }
            }
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Iterator it = h().iterator();
        while (it.hasNext()) {
            ((c) it.next()).onDestroy();
        }
    }
}

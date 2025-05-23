package com.tencent.input.base.mvicompat;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.b;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\b\b\u0002\u0010\u0006*\u00020\u0005*\u000e\b\u0003\u0010\b*\b\u0012\u0004\u0012\u00028\u00010\u000722\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0003\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n0\t2\b\u0012\u0004\u0012\u00028\u00020\u000bB\u000f\u0012\u0006\u0010\u0018\u001a\u00028\u0003\u00a2\u0006\u0004\b\u0019\u0010\u001aJT\u0010\u0011\u001a\u00020\u00102*\u0010\u000e\u001a&\u0012\u0004\u0012\u00020\r\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n0\f2\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0004J\u001f\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00028\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/input/base/mvicompat/h;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/input/base/mvicompat/b;", "H", "Lcom/tencent/input/base/mvicompat/DelegateMediator;", "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/input/base/mvicompat/f;", "", "", "table", "delegate", "", "l", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "b", "(Lcom/tencent/mvi/api/runtime/b;Z)V", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "host", "<init>", "(Lcom/tencent/input/base/mvicompat/b;)V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public abstract class h<I extends ol3.b, S extends MviUIState, C extends com.tencent.mvi.api.runtime.b, H extends b<S>> extends DelegateMediator<S, I, H, e<I, S, C, H>> implements f<C> {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull H host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) host);
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void b(@NotNull C context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Iterator it = h().iterator();
        while (it.hasNext()) {
            ((e) it.next()).b(context, reuse);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.input.base.mvicompat.DelegateMediator
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final void k(@NotNull Map<String, e<I, S, C, H>> table, @NotNull e<I, S, C, H> delegate) {
        String canonicalName;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) table, (Object) delegate);
            return;
        }
        Intrinsics.checkNotNullParameter(table, "table");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Class<? extends I> d06 = delegate.d0();
        if (d06 != null && (canonicalName = d06.getCanonicalName()) != null) {
            table.put(canonicalName, delegate);
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        List asReversed;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            asReversed = CollectionsKt__ReversedViewsKt.asReversed(h());
            Iterator it = asReversed.iterator();
            while (it.hasNext()) {
                ((e) it.next()).onDestroy();
            }
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this);
    }
}

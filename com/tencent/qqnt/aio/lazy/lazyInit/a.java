package com.tencent.qqnt.aio.lazy.lazyInit;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.mvvm.BaseVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nR\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/lazy/lazyInit/a;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "initIntent", "Lcom/tencent/qqnt/aio/lazy/lazyInit/b;", "b1", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "d", "Lcom/tencent/mvi/base/route/MsgIntent;", "getInitIntent", "()Lcom/tencent/mvi/base/route/MsgIntent;", "<init>", "(Lcom/tencent/mvi/base/route/MsgIntent;)V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class a<I extends ol3.b, S extends MviUIState> extends com.tencent.aio.base.mvvm.a<I, S> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgIntent initIntent;

    public a(@NotNull MsgIntent initIntent) {
        Intrinsics.checkNotNullParameter(initIntent, "initIntent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) initIntent);
        } else {
            this.initIntent = initIntent;
        }
    }

    @NotNull
    public abstract b<I, S> b1(@NotNull MsgIntent initIntent);

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public final BaseVM<I, S, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseVM) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return b1(this.initIntent);
    }
}

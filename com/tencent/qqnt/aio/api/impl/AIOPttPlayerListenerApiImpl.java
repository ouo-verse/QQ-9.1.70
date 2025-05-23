package com.tencent.qqnt.aio.api.impl;

import com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttAudioPlayerManager;
import com.tencent.mobileqq.aio.msglist.holder.component.ptt.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.api.IAIOPttPlayerListenerApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOPttPlayerListenerApiImpl;", "Lcom/tencent/qqnt/aio/api/IAIOPttPlayerListenerApi;", "()V", "addPttPlayerStartListener", "", "msgId", "", "audioPath", "", "onStart", "Lkotlin/Function0;", "removePttPlayerStartListener", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AIOPttPlayerListenerApiImpl implements IAIOPttPlayerListenerApi {
    static IPatchRedirector $redirector_;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/aio/api/impl/AIOPttPlayerListenerApiImpl$a", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/c;", "", "msgId", "", "path", "", "d", "", "currentPosition", "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements com.tencent.mobileqq.aio.msglist.holder.component.ptt.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f348893a;

        a(Function0<Unit> function0) {
            this.f348893a = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0);
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.c
        public void a(long msgId, @NotNull String path, int currentPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Long.valueOf(msgId), path, Integer.valueOf(currentPosition));
            } else {
                Intrinsics.checkNotNullParameter(path, "path");
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.c
        public void b(long msgId, @NotNull String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Long.valueOf(msgId), path);
            } else {
                Intrinsics.checkNotNullParameter(path, "path");
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.c
        public void c(long j3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), Boolean.valueOf(z16));
            } else {
                c.a.b(this, j3, z16);
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.c
        public void d(long msgId, @NotNull String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(msgId), path);
            } else {
                Intrinsics.checkNotNullParameter(path, "path");
                this.f348893a.invoke();
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.c
        public void e(long j3, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Float.valueOf(f16));
            } else {
                c.a.a(this, j3, f16);
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.c
        public void g(long j3, @NotNull String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                c.a.c(this, j3, str, i3, i16);
            }
        }
    }

    public AIOPttPlayerListenerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IAIOPttPlayerListenerApi
    public void addPttPlayerStartListener(long msgId, @NotNull String audioPath, @NotNull Function0<Unit> onStart) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(msgId), audioPath, onStart);
            return;
        }
        Intrinsics.checkNotNullParameter(audioPath, "audioPath");
        Intrinsics.checkNotNullParameter(onStart, "onStart");
        AIOPttAudioPlayerManager.f191706d.y(msgId, audioPath, new a(onStart));
    }

    @Override // com.tencent.qqnt.aio.api.IAIOPttPlayerListenerApi
    public void removePttPlayerStartListener(long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, msgId);
        } else {
            AIOPttAudioPlayerManager.f191706d.F(msgId);
        }
    }
}

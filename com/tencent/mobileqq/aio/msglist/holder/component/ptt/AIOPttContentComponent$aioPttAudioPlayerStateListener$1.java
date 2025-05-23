package com.tencent.mobileqq.aio.msglist.holder.component.ptt;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.Window;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J(\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0003H\u0016R\u0016\u0010\u0018\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0017\u00a8\u0006\u0019"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent$aioPttAudioPlayerStateListener$1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/c;", "Lkotlin/Function1;", "", "", "callback", DomainData.DOMAIN_NAME, "", "msgId", "", "path", "d", "", "currentPosition", "a", "b", "duration", "g", "", "speed", "e", "isNearToEar", "c", "Z", "waveViewEnable", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOPttContentComponent$aioPttAudioPlayerStateListener$1 implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean waveViewEnable;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AIOPttContentComponent f191728b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AIOPttContentComponent$aioPttAudioPlayerStateListener$1(AIOPttContentComponent aIOPttContentComponent) {
        this.f191728b = aIOPttContentComponent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOPttContentComponent);
        } else {
            this.waveViewEnable = true;
        }
    }

    private final void n(final Function1<? super Boolean, Unit> callback) {
        Handler G2;
        G2 = this.f191728b.G2();
        final AIOPttContentComponent aIOPttContentComponent = this.f191728b;
        G2.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.o
            @Override // java.lang.Runnable
            public final void run() {
                AIOPttContentComponent$aioPttAudioPlayerStateListener$1.o(AIOPttContentComponent.this, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(AIOPttContentComponent this$0, final Function1 callback) {
        final boolean z16;
        Handler handler;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (!com.tencent.mobileqq.qqaudio.audioplayer.c.f(this$0.getContext()) && !com.tencent.mobileqq.qqaudio.audioplayer.c.c(this$0.getContext())) {
            z16 = false;
        } else {
            z16 = true;
        }
        handler = this$0.handler;
        handler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.q
            @Override // java.lang.Runnable
            public final void run() {
                AIOPttContentComponent$aioPttAudioPlayerStateListener$1.p(Function1.this, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 callback, boolean z16) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(AIOPttContentComponent this$0, float f16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        z.INSTANCE.b(R.raw.f169414l, new AIOPttContentComponent.b(this$0, f16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(AIOPttContentComponent this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(new d.ad(z16));
        AIOPttUtil.f191743a.k(this$0.getContext(), Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(AIOPttContentComponent this$0, AIOPttContentComponent$aioPttAudioPlayerStateListener$1 this$1) {
        boolean z16;
        Window window;
        c03.a aVar;
        c03.a aVar2;
        Drawable drawable;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        if (!this$0.isPlayingWhenStartSeek) {
            drawable = this$0.aioPttPlay;
            this$0.E3(drawable);
        }
        z16 = this$0.isVasBubble;
        Activity activity = null;
        if (z16) {
            this$0.z2().f444829f.setVisibility(8);
            Object drawable2 = this$0.z2().f444829f.getDrawable();
            if (drawable2 instanceof c03.a) {
                aVar = (c03.a) drawable2;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                aVar.stop();
            }
            Object drawable3 = this$0.z2().f444840q.getDrawable();
            if (drawable3 instanceof c03.a) {
                aVar2 = (c03.a) drawable3;
            } else {
                aVar2 = null;
            }
            if (aVar2 != null) {
                aVar2.stop();
            }
        }
        this$1.waveViewEnable = false;
        Context mContext = this$0.getMContext();
        if (mContext instanceof Activity) {
            activity = (Activity) mContext;
        }
        if (activity != null && (window = activity.getWindow()) != null) {
            window.clearFlags(128);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(AIOPttContentComponent$aioPttAudioPlayerStateListener$1 this$0, AIOPttContentComponent this$1, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        if (!this$0.waveViewEnable) {
            return;
        }
        float f16 = i3 / i16;
        this$1.z2().f444826c.setProgress(f16);
        this$1.D3(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(AIOPttContentComponent this$0, AIOPttContentComponent$aioPttAudioPlayerStateListener$1 this$1) {
        Drawable drawable;
        boolean z16;
        Window window;
        c03.a aVar;
        c03.a aVar2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        drawable = this$0.aioPttPlay;
        this$0.E3(drawable);
        this$0.z2().f444826c.m();
        this$0.z2().f444826c.setCanSupportSlide(false);
        z16 = this$0.isVasBubble;
        Activity activity = null;
        if (z16) {
            this$0.z2().f444829f.setVisibility(8);
            Object drawable2 = this$0.z2().f444829f.getDrawable();
            if (drawable2 instanceof c03.a) {
                aVar = (c03.a) drawable2;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                aVar.stop();
            }
            Object drawable3 = this$0.z2().f444840q.getDrawable();
            if (drawable3 instanceof c03.a) {
                aVar2 = (c03.a) drawable3;
            } else {
                aVar2 = null;
            }
            if (aVar2 != null) {
                aVar2.stop();
            }
        }
        this$1.waveViewEnable = false;
        Context mContext = this$0.getMContext();
        if (mContext instanceof Activity) {
            activity = (Activity) mContext;
        }
        if (activity != null && (window = activity.getWindow()) != null) {
            window.clearFlags(128);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.c
    public void a(long msgId, @NotNull String path, int currentPosition) {
        boolean U2;
        Handler handler;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(msgId), path, Integer.valueOf(currentPosition));
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        U2 = this.f191728b.U2(msgId);
        if (U2) {
            handler = this.f191728b.handler;
            final AIOPttContentComponent aIOPttContentComponent = this.f191728b;
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.k
                @Override // java.lang.Runnable
                public final void run() {
                    AIOPttContentComponent$aioPttAudioPlayerStateListener$1.s(AIOPttContentComponent.this, this);
                }
            });
            if (this.f191728b.z2().f444826c.getVisibility() == 0) {
                f16 = this.f191728b.z2().f444826c.j();
            } else {
                f16 = 0.0f;
            }
            AIOPttUtil.f191743a.j(AIOPttContentComponent.Y1(this.f191728b).getMsgId(), currentPosition, f16);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.c
    public void b(long msgId, @NotNull String path) {
        boolean U2;
        Handler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(msgId), path);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        U2 = this.f191728b.U2(msgId);
        if (U2) {
            handler = this.f191728b.handler;
            final AIOPttContentComponent aIOPttContentComponent = this.f191728b;
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.m
                @Override // java.lang.Runnable
                public final void run() {
                    AIOPttContentComponent$aioPttAudioPlayerStateListener$1.u(AIOPttContentComponent.this, this);
                }
            });
            this.f191728b.currentSpeed = 1.0f;
            AIOPttUtil.f191743a.i(AIOPttContentComponent.Y1(this.f191728b).getMsgId());
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.c
    public void c(long msgId, boolean isNearToEar) {
        Handler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(msgId), Boolean.valueOf(isNearToEar));
            return;
        }
        final boolean z16 = !isNearToEar;
        handler = this.f191728b.handler;
        final AIOPttContentComponent aIOPttContentComponent = this.f191728b;
        handler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.p
            @Override // java.lang.Runnable
            public final void run() {
                AIOPttContentComponent$aioPttAudioPlayerStateListener$1.r(AIOPttContentComponent.this, z16);
            }
        });
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.c
    public void d(long msgId, @NotNull String path) {
        boolean U2;
        Drawable drawable;
        boolean z16;
        Window window;
        c03.a aVar;
        c03.a aVar2;
        Drawable drawable2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(msgId), path);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        U2 = this.f191728b.U2(msgId);
        if (U2) {
            if (!this.f191728b.isPlayingWhenStartSeek) {
                AIOPttContentComponent aIOPttContentComponent = this.f191728b;
                drawable2 = aIOPttContentComponent.aioPttPause;
                aIOPttContentComponent.E3(drawable2);
            }
            final AIOPttContentComponent aIOPttContentComponent2 = this.f191728b;
            n(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttContentComponent$aioPttAudioPlayerStateListener$1$onStart$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOPttContentComponent.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17) {
                    AppRuntime y26;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, z17);
                        return;
                    }
                    if (z17) {
                        return;
                    }
                    y26 = AIOPttContentComponent.this.y2();
                    boolean b16 = com.tencent.mobileqq.qqaudio.audioplayer.c.b(y26);
                    boolean n3 = AIOPttAudioPlayerManager.f191706d.n();
                    QLog.d("AIOPttContentComponent", 1, "playAudio: speakerPhoneOn:" + b16 + ", nearToEar:" + n3);
                    AIOPttContentComponent.this.sendIntent(new d.ad(!n3 && b16));
                }
            });
            z16 = this.f191728b.isVasBubble;
            Activity activity = null;
            if (z16) {
                this.f191728b.z2().f444829f.setVisibility(0);
                Object drawable3 = this.f191728b.z2().f444829f.getDrawable();
                if (drawable3 instanceof c03.a) {
                    aVar = (c03.a) drawable3;
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    aVar.restart();
                }
                Object drawable4 = this.f191728b.z2().f444840q.getDrawable();
                if (drawable4 instanceof c03.a) {
                    aVar2 = (c03.a) drawable4;
                } else {
                    aVar2 = null;
                }
                if (aVar2 != null) {
                    aVar2.restart();
                }
            }
            this.waveViewEnable = true;
            Context mContext = this.f191728b.getMContext();
            if (mContext instanceof Activity) {
                activity = (Activity) mContext;
            }
            if (activity != null && (window = activity.getWindow()) != null) {
                window.addFlags(128);
            }
            AIOPttUtil.f191743a.i(AIOPttContentComponent.Y1(this.f191728b).getMsgId());
            return;
        }
        AIOPttContentComponent aIOPttContentComponent3 = this.f191728b;
        drawable = aIOPttContentComponent3.aioPttPlay;
        aIOPttContentComponent3.E3(drawable);
        if (this.f191728b.z2().f444826c.getVisibility() == 0) {
            this.f191728b.z2().f444826c.m();
            this.f191728b.z2().f444826c.setCanSupportSlide(false);
        }
        this.f191728b.D3(1.0f);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.c
    public void e(long msgId, final float speed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(msgId), Float.valueOf(speed));
        } else if (AIOPttContentComponent.INSTANCE.a()) {
            final AIOPttContentComponent aIOPttContentComponent = this.f191728b;
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.n
                @Override // java.lang.Runnable
                public final void run() {
                    AIOPttContentComponent$aioPttAudioPlayerStateListener$1.q(AIOPttContentComponent.this, speed);
                }
            });
        } else {
            z.INSTANCE.b(R.raw.f169414l, new AIOPttContentComponent.b(this.f191728b, speed));
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.c
    public void g(long msgId, @NotNull String path, final int currentPosition, final int duration) {
        boolean U2;
        Handler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(msgId), path, Integer.valueOf(currentPosition), Integer.valueOf(duration));
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        U2 = this.f191728b.U2(msgId);
        if (U2 && currentPosition != 0) {
            handler = this.f191728b.handler;
            final AIOPttContentComponent aIOPttContentComponent = this.f191728b;
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.l
                @Override // java.lang.Runnable
                public final void run() {
                    AIOPttContentComponent$aioPttAudioPlayerStateListener$1.t(AIOPttContentComponent$aioPttAudioPlayerStateListener$1.this, aIOPttContentComponent, currentPosition, duration);
                }
            });
        }
    }
}

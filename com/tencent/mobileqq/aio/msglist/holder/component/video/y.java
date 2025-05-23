package com.tencent.mobileqq.aio.msglist.holder.component.video;

import com.tencent.mobileqq.mediafocus.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00042\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0002H&R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/y;", "", "", "f", "d", "i", "", "a", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "Lcom/tencent/mobileqq/qdispatchqueue/h;", "kotlin.jvm.PlatformType", "b", "Lcom/tencent/mobileqq/qdispatchqueue/h;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "Lcom/tencent/mobileqq/mediafocus/b$c;", "c", "Lcom/tencent/mobileqq/mediafocus/b$c;", "mediaFocusChangeListener", "<init>", "(Ljava/lang/String;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class y {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.qdispatchqueue.h queue;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b.c mediaFocusChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/y$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.video.y$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64013);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public y(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tag);
            return;
        }
        this.tag = tag;
        this.queue = com.tencent.mobileqq.qdispatchqueue.d.a("MediaFocusHandler");
        this.mediaFocusChangeListener = new b.c() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.w
            @Override // com.tencent.mobileqq.mediafocus.b.c
            public final void a(int i3) {
                y.h(y.this, i3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        QQAudioUtils.i(MobileQQ.sMobileQQ, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        QQAudioUtils.i(MobileQQ.sMobileQQ, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(y this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.i("MediaFocusHandler", 2, "[onFocusChange] this=" + this$0.hashCode() + " tag=" + this$0.tag + " focusChange=" + i3);
        }
        if (i3 == -3 || i3 == -2 || i3 == -1) {
            this$0.i();
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MediaFocusHandler", 1, "[abandonFocus] this=" + hashCode() + " tag=" + this.tag);
        }
        this.queue.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.v
            @Override // java.lang.Runnable
            public final void run() {
                y.e();
            }
        });
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MediaFocusHandler", 1, "[gainMediaFocus] this=" + hashCode() + " tag=" + this.tag);
        }
        this.queue.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.x
            @Override // java.lang.Runnable
            public final void run() {
                y.g();
            }
        });
    }

    public abstract void i();
}

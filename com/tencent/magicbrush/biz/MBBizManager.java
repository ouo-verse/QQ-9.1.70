package com.tencent.magicbrush.biz;

import androidx.annotation.Keep;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001J+\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0082 J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0007J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001c\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/magicbrush/biz/MBBizManager;", "", "", "inst", "", "bizName", "path", "Ljava/nio/ByteBuffer;", "result", "", "nativeOnReadFileCallback", "serviceName", "onCreatePublicService", "", "preloadOnly", "a", "onDestroyPublicService", "to", "msg", "onPostMsgToBiz", "onPostMsgToPublicService", "from", "readFileFromBiz", NotificationActivity.KEY_ALIAS, "version", "onRequirePlugin", "stack", "onJsException", "J", "lib-magicbrush-nano_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes9.dex */
public final class MBBizManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public long inst;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends Lambda implements Function1 {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f147377b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f147378c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            super(1);
            this.f147377b = str;
            this.f147378c = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MBBizManager.this, str, str2);
            }
        }

        public final void a(ByteBuffer byteBuffer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) byteBuffer);
            } else {
                if (byteBuffer != null && !byteBuffer.isDirect()) {
                    throw new IllegalArgumentException("read file callback buffer must be direct");
                }
                MBBizManager mBBizManager = MBBizManager.this;
                mBBizManager.nativeOnReadFileCallback(mBBizManager.inst, this.f147377b, this.f147378c, byteBuffer);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((ByteBuffer) obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeOnReadFileCallback(long inst, String bizName, String path, ByteBuffer result);

    @Keep
    @NotNull
    public final String onCreatePublicService(@NotNull String serviceName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this, (Object) serviceName);
        }
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        return a(serviceName, false);
    }

    @Keep
    public final void onDestroyPublicService(@NotNull String serviceName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) serviceName);
        } else {
            Intrinsics.checkNotNullParameter(serviceName, "serviceName");
            throw null;
        }
    }

    @Keep
    public final void onJsException(@NotNull String msg2, @NotNull String stack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msg2, (Object) stack);
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(stack, "stack");
            throw null;
        }
    }

    @Keep
    public final void onPostMsgToBiz(@NotNull String to5, @NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) to5, (Object) msg2);
        } else {
            Intrinsics.checkNotNullParameter(to5, "to");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            throw null;
        }
    }

    @Keep
    public final void onPostMsgToPublicService(@NotNull String to5, @NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) to5, (Object) msg2);
        } else {
            Intrinsics.checkNotNullParameter(to5, "to");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            throw null;
        }
    }

    @Keep
    @NotNull
    public final String onRequirePlugin(@NotNull String alias, @NotNull String version) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) alias, (Object) version);
        }
        Intrinsics.checkNotNullParameter(alias, "alias");
        Intrinsics.checkNotNullParameter(version, "version");
        throw null;
    }

    @Keep
    public final void readFileFromBiz(@NotNull String from, @NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) from, (Object) path);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(path, "path");
        new a(from, path);
        throw null;
    }

    public final String a(String serviceName, boolean preloadOnly) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, serviceName, Boolean.valueOf(preloadOnly));
        }
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        throw null;
    }
}

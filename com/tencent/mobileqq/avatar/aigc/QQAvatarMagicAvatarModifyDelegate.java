package com.tencent.mobileqq.avatar.aigc;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.aigc.QQAvatarMagicAvatarModifyDelegate;
import com.tencent.mobileqq.avatar.api.IQQAvatarIpcUpdateAvatarUtilsApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import i83.b;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0002\u0005\bB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/avatar/aigc/QQAvatarMagicAvatarModifyDelegate;", "Li83/b;", "Li83/a;", "avatarContext", "", "a", "<init>", "()V", "QQAvatarUpdateUserAvatarException", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class QQAvatarMagicAvatarModifyDelegate implements i83.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/avatar/aigc/QQAvatarMagicAvatarModifyDelegate$QQAvatarUpdateUserAvatarException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "msg", "", "(Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class QQAvatarUpdateUserAvatarException extends RuntimeException {
        static IPatchRedirector $redirector_;

        @Nullable
        private final String msg;

        public QQAvatarUpdateUserAvatarException(@Nullable String str) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            } else {
                this.msg = str;
            }
        }

        @Nullable
        public final String getMsg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.msg;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/avatar/aigc/QQAvatarMagicAvatarModifyDelegate$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.avatar.aigc.QQAvatarMagicAvatarModifyDelegate$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/avatar/aigc/QQAvatarMagicAvatarModifyDelegate$b", "Lcom/tencent/mobileqq/avatar/api/IQQAvatarIpcUpdateAvatarUtilsApi$a;", "", "success", "", "msg", "", "onResult", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements IQQAvatarIpcUpdateAvatarUtilsApi.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i83.a f199920a;

        b(i83.a aVar) {
            this.f199920a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(boolean z16, String str, i83.a avatarContext) {
            QQAvatarUpdateUserAvatarException qQAvatarUpdateUserAvatarException;
            Intrinsics.checkNotNullParameter(avatarContext, "$avatarContext");
            if (z16) {
                qQAvatarUpdateUserAvatarException = null;
            } else {
                try {
                    qQAvatarUpdateUserAvatarException = new QQAvatarUpdateUserAvatarException(str);
                } catch (Exception e16) {
                    QLog.e("magicAvatar.QQAvatarMagicAvatarModifyDelegate", 1, "magicAvatarUpdated onResult catch exp", e16);
                    return;
                }
            }
            avatarContext.X5(z16, qQAvatarUpdateUserAvatarException);
        }

        @Override // com.tencent.mobileqq.avatar.api.IQQAvatarIpcUpdateAvatarUtilsApi.a
        public void onResult(final boolean success, @Nullable final String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(success), msg2);
                return;
            }
            QLog.i("magicAvatar.QQAvatarMagicAvatarModifyDelegate", 1, "magicAvatarUpdated onResult success? " + success + ", msg: " + msg2);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final i83.a aVar = this.f199920a;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.avatar.aigc.b
                @Override // java.lang.Runnable
                public final void run() {
                    QQAvatarMagicAvatarModifyDelegate.b.b(success, msg2, aVar);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17216);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQAvatarMagicAvatarModifyDelegate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String path, i83.a avatarContext, boolean z16) {
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(avatarContext, "$avatarContext");
        File file = new File(path);
        if (file.exists() && file.isFile() && file.length() > 0) {
            ((IQQAvatarIpcUpdateAvatarUtilsApi) QRoute.api(IQQAvatarIpcUpdateAvatarUtilsApi.class)).setUserAvatar(path, z16, new b(avatarContext));
            return;
        }
        QLog.e("magicAvatar.QQAvatarMagicAvatarModifyDelegate", 1, "magicAvatarUpdated file check fail. exist? " + file.exists() + ", isFile? " + file.isFile() + ", length: " + file.length());
        try {
            avatarContext.X5(false, new QQAvatarUpdateUserAvatarException("file check error"));
        } catch (Exception e16) {
            QLog.e("magicAvatar.QQAvatarMagicAvatarModifyDelegate", 1, "magicAvatarUpdated catch exp", e16);
        }
    }

    @Override // i83.b
    public void a(@NotNull final i83.a avatarContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) avatarContext);
            return;
        }
        Intrinsics.checkNotNullParameter(avatarContext, "avatarContext");
        final String y75 = avatarContext.y7();
        final boolean m46 = avatarContext.m4();
        QLog.i("magicAvatar.QQAvatarMagicAvatarModifyDelegate", 1, "magicAvatarUpdated path: " + y75 + ", syncQzone: " + m46);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.avatar.aigc.a
            @Override // java.lang.Runnable
            public final void run() {
                QQAvatarMagicAvatarModifyDelegate.c(y75, avatarContext, m46);
            }
        }, 240, null, false);
    }

    @Override // i83.b
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            b.a.a(this);
        }
    }
}

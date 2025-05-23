package com.tencent.mobileqq.app.message.messageclean;

import com.tencent.mobileqq.app.message.messageclean.x;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028VX\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/app/message/messageclean/r;", "Lcom/tencent/mobileqq/app/message/messageclean/x;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "b", "Ljava/util/concurrent/CopyOnWriteArrayList;", "a", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "cachePathList", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class r implements x {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final r f196240a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<String> cachePathList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54229);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f196240a = new r();
            cachePathList = new CopyOnWriteArrayList<>();
        }
    }

    r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.x
    @NotNull
    public CopyOnWriteArrayList<String> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>(cachePathList);
            com.tencent.mobileqq.app.message.filescan.d dVar = com.tencent.mobileqq.app.message.filescan.d.f195978a;
            copyOnWriteArrayList.add(dVar.a() + "/databases/" + peekAppRuntime.getCurrentUin() + "_msg_file_info_since_890.db");
            copyOnWriteArrayList.add(dVar.a() + "/databases/" + peekAppRuntime.getCurrentUin() + "_msg_file_info.db");
            return copyOnWriteArrayList;
        }
        return cachePathList;
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.x
    public void clearCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            x.a.a(this);
        }
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.x
    public long getCacheSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return x.a.b(this);
    }
}

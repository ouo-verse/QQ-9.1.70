package com.tencent.mobileqq.tbstool;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005R<\u0010\u0010\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\rj\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/tbstool/a;", "", "", "sessionId", "Lcom/tencent/mobileqq/tbstool/fileview/b;", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "cb", "", "b", "c", "originSessionId", "entity", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "onFileBrowserActivityDataChangeListenerMap", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f291409a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, com.tencent.mobileqq.tbstool.fileview.b<FileManagerEntity>> onFileBrowserActivityDataChangeListenerMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22632);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f291409a = new a();
            onFileBrowserActivityDataChangeListenerMap = new HashMap<>();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(long originSessionId, @NotNull FileManagerEntity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(originSessionId), entity);
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        com.tencent.mobileqq.tbstool.fileview.b<FileManagerEntity> bVar = onFileBrowserActivityDataChangeListenerMap.get(Long.valueOf(originSessionId));
        if (bVar != null) {
            bVar.execute(entity);
        }
    }

    public final void b(long sessionId, @NotNull com.tencent.mobileqq.tbstool.fileview.b<FileManagerEntity> cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(sessionId), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(cb5, "cb");
        if (sessionId <= 0) {
            return;
        }
        onFileBrowserActivityDataChangeListenerMap.put(Long.valueOf(sessionId), cb5);
    }

    public final void c(long sessionId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, sessionId);
        } else {
            if (sessionId <= 0) {
                return;
            }
            onFileBrowserActivityDataChangeListenerMap.remove(Long.valueOf(sessionId));
        }
    }
}

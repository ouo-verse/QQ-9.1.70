package com.tencent.mobileqq.app.message.messageclean;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.message.messageclean.x;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R(\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/app/message/messageclean/bn;", "Lcom/tencent/mobileqq/app/message/messageclean/x;", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "kotlin.jvm.PlatformType", "b", "Ljava/util/concurrent/CopyOnWriteArrayList;", "a", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "cachePathList", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class bn implements x {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bn f196204a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<String> cachePathList;

    static {
        ArrayList arrayListOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54285);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f196204a = new bn();
        com.tencent.mobileqq.app.message.filescan.d dVar = com.tencent.mobileqq.app.message.filescan.d.f195978a;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(dVar.d() + "/cache/meme", dVar.d() + "/cache/record/resource");
        cachePathList = new CopyOnWriteArrayList<>(arrayListOf);
    }

    bn() {
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
        return cachePathList;
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.x
    public void clearCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            x.a.a(this);
            ((IZPlanApi) QRoute.api(IZPlanApi.class)).clearRecordCache();
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

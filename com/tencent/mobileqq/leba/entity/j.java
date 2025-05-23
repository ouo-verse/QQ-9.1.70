package com.tencent.mobileqq.leba.entity;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.DeleteTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/leba/entity/j;", "", "", "Lcom/tencent/mobileqq/leba/entity/LebaPluginConfig;", "list", "", "b", "a", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f240495a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17751);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f240495a = new j();
        }
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final List<LebaPluginConfig> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        List<? extends Entity> query = MobileQQ.sMobileQQ.peekAppRuntime().getEntityManagerFactory().createEntityManager().query(LebaPluginConfig.class);
        ArrayList arrayList = new ArrayList();
        if (query == null) {
            QLog.e("LebaPluginConfigDbHelper", 1, "loadAll result: null ");
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : query) {
            if (obj instanceof LebaPluginConfig) {
                arrayList2.add(obj);
            }
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    public final boolean b(@NotNull List<LebaPluginConfig> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(list, "list");
        EntityManager createEntityManager = MobileQQ.sMobileQQ.peekAppRuntime().getEntityManagerFactory().createEntityManager();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DeleteTransaction(LebaPluginConfig.class.getSimpleName(), null, null));
        Iterator<LebaPluginConfig> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new PersistTransaction(it.next()));
        }
        boolean doMultiDBOperateByTransaction = createEntityManager.doMultiDBOperateByTransaction(arrayList);
        QLog.i("LebaPluginConfigDbHelper", 1, "saveAll result: " + doMultiDBOperateByTransaction);
        return doMultiDBOperateByTransaction;
    }
}

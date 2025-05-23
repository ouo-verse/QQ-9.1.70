package com.tencent.qqnt.ntrelation.intimateinfo.manager.cache;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.persistence.transaction.DeleteTransaction;
import com.tencent.mobileqq.persistence.transaction.DropTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.bus.event.u;
import com.tencent.qqnt.ntrelation.intimateinfo.bean.NTIntimateBaseEntity;
import com.tencent.qqnt.ntrelation.intimateinfo.bean.NTMutualMarkEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J>\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b2\u0006\u0010\f\u001a\u00020\u000b2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J:\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\u0010\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bH\u0002Jl\u0010\u0018\u001a\u00020\u00022\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fH\u0002J\"\u0010\u001c\u001a\u00020\u00022\u0010\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J3\u0010\u001f\u001a\u00020\u00022\u0010\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0016\u0010#\u001a\u00020\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020!H\u0002J\u0006\u0010$\u001a\u00020\u0002J\u001e\u0010%\u001a\u00020\u00022\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00040\rj\b\u0012\u0004\u0012\u00020\u0004`\u000fJ\"\u0010'\u001a\u00020\u00062\u001a\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fJ\u0010\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000bR\"\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/ntrelation/intimateinfo/manager/cache/MutualMarkCacheEntityManager;", "", "", h.F, "Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/a;", "simpleInfo", "", "needToSave", "", "Lcom/tencent/mobileqq/persistence/transaction/BaseTransaction;", DomainData.DOMAIN_NAME, "", "uid", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/NTMutualMarkEntity;", "Lkotlin/collections/ArrayList;", "infos", "o", "newList", "dbList", "i", "originInfoList", "infoNeedUpdateDB", "infoNeedToDelete", "f", "list", "Lcom/tencent/mobileqq/persistence/Entity;", "entity", "e", "", "type", "d", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;)V", "Lkotlin/Function0;", "block", "l", "k", "p", "mutualMarks", "j", "g", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "mutualMarkCacheFromDB", "c", "Z", "isKernelInitFinish", "Lcom/tencent/mobileqq/persistence/EntityManager;", "Lcom/tencent/mobileqq/persistence/EntityManager;", "entityManager", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MutualMarkCacheEntityManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MutualMarkCacheEntityManager f360092a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<String, com.tencent.qqnt.ntrelation.intimateinfo.bean.a> mutualMarkCacheFromDB;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isKernelInitFinish;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static EntityManager entityManager;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37114);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f360092a = new MutualMarkCacheEntityManager();
            mutualMarkCacheFromDB = new ConcurrentHashMap<>();
        }
    }

    MutualMarkCacheEntityManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d(List<BaseTransaction<?>> list, String uid, Long type) {
        String str;
        String[] strArr;
        String tableName = new NTMutualMarkEntity().getTableName();
        if (type == null) {
            str = "uid=?";
        } else {
            str = "uid=?, type=?";
        }
        if (type == null) {
            strArr = new String[]{uid};
        } else {
            strArr = new String[]{uid, type.toString()};
        }
        list.add(new DeleteTransaction(tableName, str, strArr));
    }

    private final void e(List<BaseTransaction<?>> list, Entity entity) {
        list.add(new PersistOrReplaceTransaction(entity));
    }

    private final void f(ArrayList<NTMutualMarkEntity> newList, ArrayList<NTMutualMarkEntity> originInfoList, ArrayList<NTMutualMarkEntity> infoNeedUpdateDB, ArrayList<NTMutualMarkEntity> infoNeedToDelete) {
        boolean z16;
        boolean z17;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = newList.iterator();
        while (true) {
            boolean z18 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            NTMutualMarkEntity nTMutualMarkEntity = (NTMutualMarkEntity) next;
            if (originInfoList != null && !originInfoList.isEmpty()) {
                Iterator<T> it5 = originInfoList.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    NTMutualMarkEntity nTMutualMarkEntity2 = (NTMutualMarkEntity) it5.next();
                    if (nTMutualMarkEntity2.isSameIcon(nTMutualMarkEntity) && !Intrinsics.areEqual(nTMutualMarkEntity2, nTMutualMarkEntity)) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        z18 = true;
                        break;
                    }
                }
            }
            if (z18) {
                arrayList.add(next);
            }
        }
        infoNeedUpdateDB.addAll(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : newList) {
            NTMutualMarkEntity nTMutualMarkEntity3 = (NTMutualMarkEntity) obj;
            if (originInfoList != null) {
                z16 = originInfoList.contains(nTMutualMarkEntity3);
            } else {
                z16 = false;
            }
            if (!z16) {
                arrayList2.add(obj);
            }
        }
        infoNeedUpdateDB.addAll(arrayList2);
        if (originInfoList != null) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : originInfoList) {
                if (!newList.contains((NTMutualMarkEntity) obj2)) {
                    arrayList3.add(obj2);
                }
            }
            infoNeedToDelete.addAll(arrayList3);
        }
    }

    private final void h() {
        l(MutualMarkCacheEntityManager$loadDataFromDB$1.INSTANCE);
    }

    private final boolean i(String uid, ArrayList<NTMutualMarkEntity> newList, List<BaseTransaction<?>> dbList) {
        Unit unit;
        ArrayList<NTMutualMarkEntity> arrayList = new ArrayList<>();
        ArrayList<NTMutualMarkEntity> arrayList2 = new ArrayList<>();
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar = mutualMarkCacheFromDB.get(uid);
        ArrayList<NTMutualMarkEntity> arrayList3 = null;
        if (aVar != null) {
            f360092a.f(newList, aVar.l(), arrayList, arrayList2);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            if (!isKernelInitFinish) {
                if (mutualMarkCacheFromDB.contains(uid)) {
                    com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar2 = mutualMarkCacheFromDB.get(uid);
                    if (aVar2 != null) {
                        arrayList3 = aVar2.l();
                    }
                    f360092a.f(newList, arrayList3, arrayList, arrayList2);
                } else {
                    f360092a.d(dbList, uid, null);
                    Iterator<T> it = newList.iterator();
                    while (it.hasNext()) {
                        f360092a.e(dbList, (NTMutualMarkEntity) it.next());
                    }
                }
                newList = arrayList;
            }
            arrayList = newList;
        }
        for (NTMutualMarkEntity nTMutualMarkEntity : arrayList2) {
            f360092a.d(dbList, nTMutualMarkEntity.uid, Long.valueOf(nTMutualMarkEntity.type));
        }
        Iterator<T> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            f360092a.e(dbList, (NTMutualMarkEntity) it5.next());
        }
        if (arrayList2.isEmpty() && arrayList.isEmpty()) {
            return false;
        }
        return true;
    }

    private final void l(final Function0<Unit> block) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.intimateinfo.manager.cache.a
            @Override // java.lang.Runnable
            public final void run() {
                MutualMarkCacheEntityManager.m(Function0.this);
            }
        }, 32, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    private final List<BaseTransaction<?>> n(com.tencent.qqnt.ntrelation.intimateinfo.bean.a simpleInfo, boolean needToSave) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        ArrayList<NTMutualMarkEntity> l3 = simpleInfo.l();
        if (l3 != null && !l3.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && needToSave) {
            NTIntimateBaseEntity nTIntimateBaseEntity = new NTIntimateBaseEntity();
            nTIntimateBaseEntity.updateByNTIntimateSimpleInfo(simpleInfo);
            arrayList.add(new PersistOrReplaceTransaction(nTIntimateBaseEntity));
            return arrayList;
        }
        arrayList.add(new DeleteTransaction(new NTIntimateBaseEntity().getTableName(), "uid=?", new String[]{simpleInfo.getUid()}));
        return arrayList;
    }

    private final List<BaseTransaction<?>> o(String uid, ArrayList<NTMutualMarkEntity> infos, boolean needToSave) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(uid)) {
            if (infos != null && !infos.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && needToSave) {
                i(uid, infos, arrayList);
                return arrayList;
            }
        }
        d(arrayList, uid, null);
        return arrayList;
    }

    @Nullable
    public final com.tencent.qqnt.ntrelation.intimateinfo.bean.a g(@NotNull String uid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.qqnt.ntrelation.intimateinfo.bean.a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) uid);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        if (isKernelInitFinish) {
            return new com.tencent.qqnt.ntrelation.intimateinfo.bean.a(uid, "");
        }
        return mutualMarkCacheFromDB.get(uid);
    }

    public final boolean j(@Nullable ArrayList<NTMutualMarkEntity> mutualMarks) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) mutualMarks)).booleanValue();
        }
        if (mutualMarks == null) {
            return false;
        }
        Iterator<T> it = mutualMarks.iterator();
        while (it.hasNext()) {
            if (((NTMutualMarkEntity) it.next()).isWearing) {
                return true;
            }
        }
        return false;
    }

    public final void k() {
        EntityManager entityManager2;
        EntityManagerFactory entityManagerFactory;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (entityManagerFactory = peekAppRuntime.getEntityManagerFactory()) != null) {
            entityManager2 = entityManagerFactory.createEntityManager();
        } else {
            entityManager2 = null;
        }
        entityManager = entityManager2;
        mutualMarkCacheFromDB.clear();
        h();
    }

    public final void p(@NotNull ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> infos) {
        Boolean bool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) infos);
            return;
        }
        Intrinsics.checkNotNullParameter(infos, "infos");
        QLog.i("MutualMarkCacheEntityManager", 1, "updateCacheFromKernel info size " + infos.size());
        ArrayList arrayList = new ArrayList();
        if (!isKernelInitFinish) {
            arrayList.add(new DropTransaction((Class<? extends Entity>) NTMutualMarkEntity.class));
            arrayList.add(new DropTransaction((Class<? extends Entity>) NTIntimateBaseEntity.class));
            isKernelInitFinish = true;
        }
        mutualMarkCacheFromDB = new ConcurrentHashMap<>();
        ArrayList arrayList2 = new ArrayList();
        String str = "updateCacheFromKernel ";
        for (com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar : infos) {
            MutualMarkCacheEntityManager mutualMarkCacheEntityManager = f360092a;
            boolean j3 = mutualMarkCacheEntityManager.j(aVar.l());
            arrayList.addAll(mutualMarkCacheEntityManager.o(aVar.getUid(), aVar.l(), j3));
            arrayList.addAll(mutualMarkCacheEntityManager.n(aVar, j3));
            if (j3) {
                str = ((Object) str) + " " + aVar;
            }
            arrayList2.add(aVar.getUid());
        }
        if (!arrayList.isEmpty()) {
            EntityManager entityManager2 = entityManager;
            if (entityManager2 != null) {
                bool = Boolean.valueOf(entityManager2.doMultiDBOperateByTransaction(arrayList));
            } else {
                bool = null;
            }
            QLog.e("MutualMarkCacheEntityManager", 1, "save db result " + bool + " dbListSize " + arrayList.size() + " " + ((Object) str) + " ");
        }
        ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new u(arrayList2));
    }
}

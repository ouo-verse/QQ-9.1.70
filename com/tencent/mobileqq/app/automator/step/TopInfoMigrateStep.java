package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.ContactTopData;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014R\u0014\u0010\u0013\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00148B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/app/automator/step/TopInfoMigrateStep;", "Lcom/tencent/mobileqq/app/automator/AsyncStep;", "Lcom/tencent/mobileqq/app/automator/Automator;", "", "l", "", "Lcom/tencent/mobileqq/data/RecentUser;", "k", "", "uin", "Lcom/tencent/qqnt/kernel/nativeinterface/ContactTopData;", "g", tl.h.F, "uid", "d", "", "doStep", "j", "()Ljava/lang/String;", "topInfoUpdateKey", "", "value", "i", "()Z", DomainData.DOMAIN_NAME, "(Z)V", "hasMigrate", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class TopInfoMigrateStep extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/app/automator/step/TopInfoMigrateStep$a;", "", "", "TAG", "Ljava/lang/String;", "TOP_INFO_UPDATE_KEY_PREFIX", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.automator.step.TopInfoMigrateStep$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54117);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TopInfoMigrateStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final ContactTopData d(String uid) {
        ContactTopData contactTopData = new ContactTopData();
        contactTopData.uin = 0L;
        contactTopData.chatType = 8;
        contactTopData.uid = uid;
        return contactTopData;
    }

    private final ContactTopData g(String uin) {
        Long longOrNull;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            ContactTopData contactTopData = new ContactTopData();
            contactTopData.uin = longValue;
            contactTopData.chatType = 103;
            contactTopData.uid = "";
            return contactTopData;
        }
        return null;
    }

    private final ContactTopData h() {
        ContactTopData contactTopData = new ContactTopData();
        contactTopData.uin = AppConstants.SERVICE_ACCOUNT_FOLDER_UIN_LONGVALUE;
        contactTopData.chatType = 30;
        contactTopData.uid = "";
        return contactTopData;
    }

    private final boolean i() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(j(), false);
    }

    private final String j() {
        String str;
        AppRuntime peekAppRuntime;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        return "top_info_update_key_" + str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [com.tencent.mobileqq.persistence.EntityManager] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.tencent.mobileqq.persistence.EntityManager] */
    private final List<RecentUser> k() {
        List list;
        ?? r46;
        Throwable th5;
        Automator automator;
        QQAppInterface qQAppInterface;
        com.tencent.mobileqq.persistence.l entityManagerFactory;
        List list2 = null;
        list2 = null;
        EntityManager entityManager = null;
        try {
            try {
                automator = (Automator) this.mAutomator;
            } catch (Exception e16) {
                e = e16;
                list = null;
            }
            if (automator != null && (qQAppInterface = automator.E) != null && (entityManagerFactory = qQAppInterface.getEntityManagerFactory()) != null) {
                r46 = entityManagerFactory.createEntityManager();
                if (r46 != null) {
                    try {
                        List query = r46.query(RecentUser.class, false, "showUpTime>?", new String[]{"0"}, null, null, "showUpTime desc", null);
                        if (query instanceof List) {
                            list2 = query;
                        }
                        if (list2 == null) {
                            list2 = CollectionsKt__CollectionsKt.emptyList();
                        }
                        try {
                            r46.close();
                        } catch (Exception e17) {
                            QLog.e("TopInfoMigrateStep", 1, " em.close()", e17);
                        }
                    } catch (Exception e18) {
                        e = e18;
                        list = null;
                        entityManager = r46;
                        QLog.e("TopInfoMigrateStep", 1, "getRecentUsersFromDB", e);
                        if (entityManager != null) {
                            try {
                                entityManager.close();
                            } catch (Exception e19) {
                                QLog.e("TopInfoMigrateStep", 1, " em.close()", e19);
                            }
                        }
                        list2 = list;
                        return list2;
                    } catch (Throwable th6) {
                        th5 = th6;
                        if (r46 != null) {
                            try {
                                r46.close();
                            } catch (Exception e26) {
                                QLog.e("TopInfoMigrateStep", 1, " em.close()", e26);
                            }
                        }
                        throw th5;
                    }
                    return list2;
                }
            }
            return null;
        } catch (Throwable th7) {
            r46 = list2;
            th5 = th7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        aa aaVar;
        IKernelService iKernelService;
        List<RecentUser> k3 = k();
        if (k3 == null) {
            QLog.e("TopInfoMigrateStep", 1, "get top info list failed!");
            return;
        }
        QLog.d("TopInfoMigrateStep", 1, "getTopRecentUserFromDB size: " + k3.size());
        ArrayList<ContactTopData> arrayList = new ArrayList<>();
        Iterator<RecentUser> it = k3.iterator();
        while (true) {
            aaVar = null;
            ContactTopData g16 = null;
            aaVar = null;
            if (!it.hasNext()) {
                break;
            }
            RecentUser next = it.next();
            int i3 = next.type;
            if (i3 != 1008) {
                if (i3 != 6000) {
                    if (i3 != 6003) {
                        if (i3 != 6005) {
                            if (i3 == 7230) {
                                g16 = h();
                            }
                        } else {
                            g16 = d(PeerUid.DATALINE_PHONE_UID);
                        }
                    } else {
                        g16 = d(PeerUid.DATALINE_PAD_UID);
                    }
                } else {
                    g16 = d(PeerUid.DATALINE_PC_UID);
                }
            } else {
                String str = next.uin;
                Intrinsics.checkNotNullExpressionValue(str, "topRecentUser.uin");
                g16 = g(str);
            }
            if (g16 != null) {
                arrayList.add(g16);
            }
        }
        if (arrayList.isEmpty()) {
            QLog.d("TopInfoMigrateStep", 1, "no data need to migrate");
            n(true);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            aaVar = iKernelService.getRecentContactService();
        }
        if (aaVar == null) {
            QLog.e("TopInfoMigrateStep", 1, "fail to get RecentContactService");
            return;
        }
        QLog.d("TopInfoMigrateStep", 1, "setContactListTop data size: " + arrayList.size());
        aaVar.setContactListTop(true, arrayList, new IOperateCallback() { // from class: com.tencent.mobileqq.app.automator.step.q
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i16, String str2) {
                TopInfoMigrateStep.m(TopInfoMigrateStep.this, i16, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(TopInfoMigrateStep this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("TopInfoMigrateStep", 1, "setContactListTop result: " + i3 + " msg " + str);
        if (i3 == 0) {
            this$0.n(true);
        }
    }

    private final void n(boolean z16) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(j(), z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (i()) {
            if (QLog.isColorLevel()) {
                QLog.d("TopInfoMigrateStep", 2, "hasMigrate, no need to do step");
            }
            return 7;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.automator.step.p
            @Override // java.lang.Runnable
            public final void run() {
                TopInfoMigrateStep.this.l();
            }
        }, 32, null, true);
        return 7;
    }
}

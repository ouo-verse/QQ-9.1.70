package com.tencent.relation.common.nt.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.proxy.IRecentForwardUserProxy;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.nt.api.IRelationMsgService;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J$\u0010\u0013\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/relation/common/nt/api/impl/RelationMsgServiceImpl;", "Lcom/tencent/relation/common/nt/api/IRelationMsgService;", "", "chatType", "", "needUin2Uid", "Lcom/tencent/relation/common/nt/data/a;", "qqRelationContact", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "cb", "", "deleteRecentContacts", "", "getPeerUid", "Ljava/util/ArrayList;", "", "sortedContactList", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "changedList", "deleteRecentForwardContacts", "<init>", "()V", "Companion", "a", "relation-common-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RelationMsgServiceImpl implements IRelationMsgService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "RelationMsgServiceImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/relation/common/nt/api/impl/RelationMsgServiceImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "relation-common-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.relation.common.nt.api.impl.RelationMsgServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21749);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RelationMsgServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean needUin2Uid(int chatType) {
        if (chatType == 1 || chatType == 100) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.relation.common.nt.api.IRelationMsgService
    public void deleteRecentContacts(@NotNull com.tencent.relation.common.nt.data.a qqRelationContact, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qqRelationContact, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(qqRelationContact, "qqRelationContact");
        int l3 = com.tencent.nt.adapter.session.c.l(qqRelationContact.c());
        String peerUid = getPeerUid(qqRelationContact);
        aa recentContactService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getRecentContactService();
        Contact contact = new Contact(l3, peerUid, "");
        ArrayList<Contact> arrayList = new ArrayList<>();
        arrayList.add(contact);
        if (recentContactService != null) {
            recentContactService.a0(arrayList, cb5);
        }
    }

    @Override // com.tencent.relation.common.nt.api.IRelationMsgService
    public void deleteRecentForwardContacts(@NotNull ArrayList<Long> sortedContactList, @NotNull ArrayList<RecentContactInfo> changedList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) sortedContactList, (Object) changedList);
            return;
        }
        Intrinsics.checkNotNullParameter(sortedContactList, "sortedContactList");
        Intrinsics.checkNotNullParameter(changedList, "changedList");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "deleteRecentForwardContacts is error! app in null!");
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(sortedContactList);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(changedList);
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            RecentContactInfo recentContactInfo = (RecentContactInfo) it.next();
            if (!arrayList2.contains(Long.valueOf(recentContactInfo.contactId))) {
                long j3 = recentContactInfo.peerUin;
                if (j3 != 0) {
                    arrayList.add(String.valueOf(j3));
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        IRecentForwardUserProxy recentForwardCache = ((IRecentUserProxyService) peekAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentForwardCache();
        Intrinsics.checkNotNullExpressionValue(recentForwardCache, "app.getRuntimeService(IR\u2026).getRecentForwardCache()");
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            recentForwardCache.clearSpecificRecentUser((String) it5.next());
        }
    }

    @Override // com.tencent.relation.common.nt.api.IRelationMsgService
    @NotNull
    public String getPeerUid(@NotNull com.tencent.relation.common.nt.data.a qqRelationContact) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) qqRelationContact);
        }
        Intrinsics.checkNotNullParameter(qqRelationContact, "qqRelationContact");
        if (needUin2Uid(com.tencent.nt.adapter.session.c.l(qqRelationContact.c()))) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(qqRelationContact.b());
            Intrinsics.checkNotNullExpressionValue(uidFromUin, "api(IRelationNTUinAndUid\u2026in(qqRelationContact.uin)");
            return uidFromUin;
        }
        if (TextUtils.isEmpty(qqRelationContact.a())) {
            return qqRelationContact.b();
        }
        return qqRelationContact.a();
    }
}

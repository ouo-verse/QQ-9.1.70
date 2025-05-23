package com.tencent.relation.common.nt.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.relation.common.nt.api.IRelationOneWayFriendApi;
import com.tencent.relation.common.utils.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/relation/common/nt/api/impl/RelationOneWayFriendApiImpl;", "Lcom/tencent/relation/common/nt/api/IRelationOneWayFriendApi;", "", "peerUid", "", "deleteOneWayFriendGrayTipsIfNeed", "<init>", "()V", "Companion", "a", "relation-common-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RelationOneWayFriendApiImpl implements IRelationOneWayFriendApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "RelationOneWayFriendApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/relation/common/nt/api/impl/RelationOneWayFriendApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "relation-common-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.relation.common.nt.api.impl.RelationOneWayFriendApiImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21768);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RelationOneWayFriendApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteOneWayFriendGrayTipsIfNeed$lambda$0(int i3, String str) {
        if (i3 == 0) {
            return;
        }
        QLog.e(TAG, 1, "deleteIcebreakerTopicArk is error! error msg is " + str);
    }

    @Override // com.tencent.relation.common.nt.api.IRelationOneWayFriendApi
    public void deleteOneWayFriendGrayTipsIfNeed(@NotNull String peerUid) {
        w msgService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) peerUid);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        long d16 = i.c().d(peerUid);
        if (d16 == 0) {
            return;
        }
        i.c().j(peerUid, 0L);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")).getMsgService()) == null) {
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(d16));
        msgService.deleteMsg(new Contact(1, peerUid, ""), arrayList, new IOperateCallback() { // from class: com.tencent.relation.common.nt.api.impl.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                RelationOneWayFriendApiImpl.deleteOneWayFriendGrayTipsIfNeed$lambda$0(i3, str);
            }
        });
    }
}

package com.tencent.qqnt.kernel.invorker;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.invorker.g;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener;
import com.tencent.qqnt.kernel.nativeinterface.NotificationCommonInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactExtra;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.bh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/kernel/invorker/k;", "Lcom/tencent/qqnt/kernel/invorker/KBaseInvorkService;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", ReportConstant.COSTREPORT_PREFIX, "r", "u", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRecentContactListener;", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRecentContactListener;", "listener", "Lcom/tencent/qqnt/kernel/api/IKernelService;", "kernelService", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/invorker/f;", "notify", "<init>", "(Lcom/tencent/qqnt/kernel/api/IKernelService;Lmqq/app/AppRuntime;Lcom/tencent/qqnt/kernel/invorker/f;)V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class k extends KBaseInvorkService {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private IKernelRecentContactListener listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001c\u0010\u000f\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/qqnt/kernel/invorker/k$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRecentContactListener;", "Ljava/util/ArrayList;", "", "sortedContactList", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "changedList", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactExtra;", WadlProxyConsts.EXTRA_DATA, "", "onRecentContactListChanged", "Ljava/util/HashMap;", "", "", "changes", "onMsgUnreadCountUpdate", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements IKernelRecentContactListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener
        public /* synthetic */ void onDeletedContactsNotify(ArrayList arrayList) {
            bh.a(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener
        public void onMsgUnreadCountUpdate(@NotNull HashMap<String, Integer> changes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) changes);
            } else {
                Intrinsics.checkNotNullParameter(changes, "changes");
                k.this.t("onMsgUnreadCountUpdate", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("changes", Integer.valueOf(changes.size()))));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener
        public void onRecentContactListChanged(@NotNull ArrayList<Long> sortedContactList, @NotNull ArrayList<RecentContactInfo> changedList, @NotNull RecentContactExtra extraData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, sortedContactList, changedList, extraData);
                return;
            }
            Intrinsics.checkNotNullParameter(sortedContactList, "sortedContactList");
            Intrinsics.checkNotNullParameter(changedList, "changedList");
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            k.this.t("onRecentContactListChanged", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("sortedContactList", Integer.valueOf(sortedContactList.size())), TuplesKt.to("changedList", k.this.A(changedList))));
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener
        public /* synthetic */ void onRecentContactListChangedVer2(ArrayList arrayList, int i3) {
            bh.d(this, arrayList, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener
        public /* synthetic */ void onRecentContactNotification(ArrayList arrayList, NotificationCommonInfo notificationCommonInfo, int i3) {
            bh.e(this, arrayList, notificationCommonInfo, i3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull IKernelService kernelService, @NotNull AppRuntime app, @NotNull f notify) {
        super("\u6700\u8fd1\u8054\u7cfb\u4eba", aa.class, kernelService, app, notify);
        Intrinsics.checkNotNullParameter(kernelService, "kernelService");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(notify, "notify");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, kernelService, app, notify);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> A(ArrayList<RecentContactInfo> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("changedList size(" + arrayList.size() + ")\n");
        for (RecentContactInfo recentContactInfo : arrayList) {
            arrayList2.add(com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("guildName", ex3.a.g(recentContactInfo)), TuplesKt.to("channelName", ex3.a.c(recentContactInfo)), TuplesKt.to("chatType", Integer.valueOf(recentContactInfo.chatType)), TuplesKt.to("\u53d1\u9001\u65b9", recentContactInfo.sendNickName)) + "\n\n");
        }
        return arrayList2;
    }

    @Override // com.tencent.qqnt.kernel.invorker.KBaseInvorkService
    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.listener = new a();
        com.tencent.qqnt.kernel.api.j p16 = p();
        Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.IRecentContactService");
        aa aaVar = (aa) p16;
        IKernelRecentContactListener iKernelRecentContactListener = this.listener;
        if (iKernelRecentContactListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            iKernelRecentContactListener = null;
        }
        aaVar.l(iKernelRecentContactListener);
    }

    @Override // com.tencent.qqnt.kernel.invorker.KBaseInvorkService
    public void s() {
        List<? extends Object> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        g.d e16 = e("getRecentContactList", "\u83b7\u53d6\u6700\u8fd1\u8054\u7cfb\u4eba\u5217\u8868");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(this);
        e16.b("default", listOf);
    }

    @Override // com.tencent.qqnt.kernel.invorker.KBaseInvorkService
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.qqnt.kernel.api.j p16 = p();
        Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.IRecentContactService");
        aa aaVar = (aa) p16;
        IKernelRecentContactListener iKernelRecentContactListener = this.listener;
        if (iKernelRecentContactListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            iKernelRecentContactListener = null;
        }
        aaVar.b0(iKernelRecentContactListener);
    }
}

package com.tencent.qqnt.kernel.invorker;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.m;
import com.tencent.qqnt.kernel.invorker.g;
import com.tencent.qqnt.kernel.nativeinterface.AvatarUrlType;
import com.tencent.qqnt.kernel.nativeinterface.BuddyCategory;
import com.tencent.qqnt.kernel.nativeinterface.BuddyReqInfo;
import com.tencent.qqnt.kernel.nativeinterface.BuddySetting;
import com.tencent.qqnt.kernel.nativeinterface.BuddyVerify;
import com.tencent.qqnt.kernel.nativeinterface.DoubtBuddyReqListRsp;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener;
import com.tencent.qqnt.kernel.nativeinterface.UserSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b*\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\fR\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/kernel/invorker/KBuddyInvorkService;", "Lcom/tencent/qqnt/kernel/invorker/KBaseInvorkService;", "", "J", UserInfo.SEX_FEMALE, "H", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/BuddyCategory;", "", "", "K", "G", "I", ReportConstant.COSTREPORT_PREFIX, "r", "u", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBuddyListener;", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBuddyListener;", "listener", "", "l", "showCheckBuddy", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "checkBuddyList", DomainData.DOMAIN_NAME, "Ljava/lang/String;", "buddyName", "Lcom/tencent/qqnt/kernel/api/IKernelService;", "kernelService", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/invorker/f;", "notify", "<init>", "(Lcom/tencent/qqnt/kernel/api/IKernelService;Lmqq/app/AppRuntime;Lcom/tencent/qqnt/kernel/invorker/f;)V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class KBuddyInvorkService extends KBaseInvorkService {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private IKernelBuddyListener listener;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int showCheckBuddy;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> checkBuddyList;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String buddyName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/qqnt/kernel/invorker/KBuddyInvorkService$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBuddyListener;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/BuddyCategory;", "data", "", "onBuddyListChange", "", "uid", "nick", "onNickUpdated", "remark", "onBuddyRemarkUpdated", "onAvatarUrlUpdated", "Lcom/tencent/qqnt/kernel/nativeinterface/BuddyReqInfo;", "onBuddyReqChange", "Lcom/tencent/qqnt/kernel/nativeinterface/BuddySetting;", "setting", "onCheckBuddySettingResult", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements IKernelBuddyListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) KBuddyInvorkService.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onAddBuddyNeedVerify(BuddyVerify buddyVerify) {
            ab.a(this, buddyVerify);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onAddMeSettingChanged(int i3, HashMap hashMap) {
            ab.b(this, i3, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public void onAvatarUrlUpdated(@NotNull String uid) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uid);
            } else {
                Intrinsics.checkNotNullParameter(uid, "uid");
                KBuddyInvorkService.this.t("onAvatarUrlUpdated", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("uid", uid)));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onBlockChanged(HashMap hashMap) {
            ab.d(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onBuddyDeleted(String str) {
            ab.e(this, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public void onBuddyListChange(@NotNull ArrayList<BuddyCategory> data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            int i3 = KBuddyInvorkService.this.showCheckBuddy;
            if (i3 != -1) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        KBuddyInvorkService kBuddyInvorkService = KBuddyInvorkService.this;
                        Iterator<T> it = data.iterator();
                        while (it.hasNext()) {
                            ArrayList<UserSimpleInfo> arrayList = ((BuddyCategory) it.next()).buddyList;
                            Intrinsics.checkNotNullExpressionValue(arrayList, "category.buddyList");
                            for (UserSimpleInfo userSimpleInfo : arrayList) {
                                if (kBuddyInvorkService.checkBuddyList.contains(userSimpleInfo.coreInfo.uid)) {
                                    String str = userSimpleInfo.coreInfo.nick;
                                    Intrinsics.checkNotNullExpressionValue(str, "info.coreInfo.nick");
                                    String str2 = userSimpleInfo.coreInfo.uid;
                                    Intrinsics.checkNotNullExpressionValue(str2, "info.coreInfo.uid");
                                    kBuddyInvorkService.t(str, str2);
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                KBuddyInvorkService.this.t("addChekcBuddy", "\u597d\u53cb\u5217\u8868\u5982\u4e0b\uff08\u65e0\u663e\u793a\u5219\u4e0d\u4e3a\u597d\u53cb\uff09\uff1a");
                KBuddyInvorkService kBuddyInvorkService2 = KBuddyInvorkService.this;
                Iterator<T> it5 = data.iterator();
                while (it5.hasNext()) {
                    ArrayList<UserSimpleInfo> arrayList2 = ((BuddyCategory) it5.next()).buddyList;
                    Intrinsics.checkNotNullExpressionValue(arrayList2, "category.buddyList");
                    for (UserSimpleInfo userSimpleInfo2 : arrayList2) {
                        if (Intrinsics.areEqual(userSimpleInfo2.coreInfo.nick, kBuddyInvorkService2.buddyName)) {
                            String str3 = userSimpleInfo2.coreInfo.nick;
                            Intrinsics.checkNotNullExpressionValue(str3, "info.coreInfo.nick");
                            String str4 = userSimpleInfo2.coreInfo.uid;
                            Intrinsics.checkNotNullExpressionValue(str4, "info.coreInfo.uid");
                            kBuddyInvorkService2.t(str3, str4);
                        }
                    }
                }
                KBuddyInvorkService.this.showCheckBuddy = -1;
                return;
            }
            KBuddyInvorkService kBuddyInvorkService3 = KBuddyInvorkService.this;
            kBuddyInvorkService3.t("onBuddyListChange", com.tencent.qqnt.kernel.internel.a.f359089a.a(kBuddyInvorkService3.K(data)));
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onBuddyListChangedV2(boolean z16) {
            ab.g(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public void onBuddyRemarkUpdated(@NotNull String uid, @NotNull String remark) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uid, (Object) remark);
                return;
            }
            Intrinsics.checkNotNullParameter(uid, "uid");
            Intrinsics.checkNotNullParameter(remark, "remark");
            KBuddyInvorkService.this.t("onBuddyRemarkUpdated", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("uid", uid), TuplesKt.to("remark", remark)));
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public void onBuddyReqChange(@NotNull BuddyReqInfo data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) data);
            } else {
                Intrinsics.checkNotNullParameter(data, "data");
                KBuddyInvorkService.this.t("onBuddyReqChange", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("data", data)));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onBuddyReqUnreadCntChange(int i3) {
            ab.j(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public void onCheckBuddySettingResult(@NotNull BuddySetting setting) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) setting);
            } else {
                Intrinsics.checkNotNullParameter(setting, "setting");
                KBuddyInvorkService.this.t("onCheckBuddySettingResult", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("setting", setting.buddyUid)));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onDelBatchBuddyInfos(ArrayList arrayList) {
            ab.l(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onDoubtBuddyReqChange(DoubtBuddyReqListRsp doubtBuddyReqListRsp) {
            ab.m(this, doubtBuddyReqListRsp);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onDoubtBuddyReqUnreadNumChange(int i3) {
            ab.n(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public void onNickUpdated(@NotNull String uid, @NotNull String nick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uid, (Object) nick);
                return;
            }
            Intrinsics.checkNotNullParameter(uid, "uid");
            Intrinsics.checkNotNullParameter(nick, "nick");
            KBuddyInvorkService.this.t("onNickUpdated", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("uid", uid), TuplesKt.to("nick", nick)));
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onSmartInfos(String str, String str2, int i3) {
            ab.p(this, str, str2, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onSpacePermissionInfos(HashMap hashMap) {
            ab.q(this, hashMap);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KBuddyInvorkService(@NotNull IKernelService kernelService, @NotNull AppRuntime app, @NotNull f notify) {
        super("\u597d\u53cb", m.class, kernelService, app, notify);
        Intrinsics.checkNotNullParameter(kernelService, "kernelService");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(notify, "notify");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, kernelService, app, notify);
            return;
        }
        this.showCheckBuddy = -1;
        this.checkBuddyList = new ArrayList();
        this.buddyName = "";
    }

    private final void F() {
        c("\u68c0\u6d4b\u662f\u5426\u4e3a\u597d\u53cb", "\u8f93\u5165\u597d\u53cbuid\u5217\u8868\uff0c\u5982'uid1 uid2 ...'", new Function2<List<? extends Object>, List<? extends String>, Unit>() { // from class: com.tencent.qqnt.kernel.invorker.KBuddyInvorkService$addCheckBuddy$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) KBuddyInvorkService.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Object> list, List<? extends String> list2) {
                invoke2(list, (List<String>) list2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<? extends Object> preParas, @NotNull List<String> cmds) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) preParas, (Object) cmds);
                    return;
                }
                Intrinsics.checkNotNullParameter(preParas, "preParas");
                Intrinsics.checkNotNullParameter(cmds, "cmds");
                KBuddyInvorkService.this.checkBuddyList.clear();
                KBuddyInvorkService kBuddyInvorkService = KBuddyInvorkService.this;
                Iterator<T> it = cmds.iterator();
                while (it.hasNext()) {
                    kBuddyInvorkService.checkBuddyList.add((String) it.next());
                }
                com.tencent.qqnt.kernel.api.j p16 = KBuddyInvorkService.this.p();
                Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.IBuddyService");
                ((m) p16).getBuddyList(true, null);
                KBuddyInvorkService.this.showCheckBuddy = 0;
            }
        });
    }

    private final void G() {
        List<? extends Object> listOf;
        List<? extends Object> listOf2;
        List<? extends Object> listOf3;
        g.d c16 = c("\u83b7\u53d6\u597d\u53cb\u5934\u50cf", "\u8f93\u5165\u597d\u53cbuid\u5217\u8868\uff0c\u5982'uid1 uid2 ...'", new Function2<List<? extends Object>, List<? extends String>, Unit>() { // from class: com.tencent.qqnt.kernel.invorker.KBuddyInvorkService$addGetAvatarUrl$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) KBuddyInvorkService.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Object> list, List<? extends String> list2) {
                invoke2(list, (List<String>) list2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<? extends Object> preParas, @NotNull List<String> cmds) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) preParas, (Object) cmds);
                    return;
                }
                Intrinsics.checkNotNullParameter(preParas, "preParas");
                Intrinsics.checkNotNullParameter(cmds, "cmds");
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<T> it = cmds.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) it.next());
                }
                com.tencent.qqnt.kernel.api.j p16 = KBuddyInvorkService.this.p();
                Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.IBuddyService");
                Object obj = preParas.get(0);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.qqnt.kernel.nativeinterface.AvatarUrlType");
                Map<String, String> g16 = ((m) p16).g(arrayList, (AvatarUrlType) obj);
                if (g16 != null) {
                    KBuddyInvorkService kBuddyInvorkService = KBuddyInvorkService.this;
                    for (Map.Entry<String, String> entry : g16.entrySet()) {
                        kBuddyInvorkService.t(entry.getKey(), entry.getValue());
                    }
                }
            }
        });
        listOf = CollectionsKt__CollectionsJVMKt.listOf(AvatarUrlType.SIZE_40);
        c16.b("SIZE_40", listOf);
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(AvatarUrlType.SIZE_100);
        c16.b("SIZE_100", listOf2);
        listOf3 = CollectionsKt__CollectionsJVMKt.listOf(AvatarUrlType.SIZE_140);
        c16.b("SIZE_140", listOf3);
    }

    private final void H() {
        List<? extends Object> listOf;
        List<? extends Object> listOf2;
        g.d f16 = f("getBuddySimpleInfo", "\u83b7\u53d6\u597d\u53cb\u7b80\u5355\u8d44\u6599", "\u8f93\u5165\u597d\u53cbuid\u5217\u8868\uff0c\u5982'uid1 uid2 ...'", new Function2<List<? extends Object>, List<? extends String>, g.a>() { // from class: com.tencent.qqnt.kernel.invorker.KBuddyInvorkService$addGetBuddySimpleInfo$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) KBuddyInvorkService.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ g.a invoke(List<? extends Object> list, List<? extends String> list2) {
                return invoke2(list, (List<String>) list2);
            }

            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final g.a invoke2(@NotNull List<? extends Object> preParas, @NotNull List<String> cmds) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (g.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) preParas, (Object) cmds);
                }
                Intrinsics.checkNotNullParameter(preParas, "preParas");
                Intrinsics.checkNotNullParameter(cmds, "cmds");
                ArrayList arrayList = new ArrayList();
                arrayList.add(preParas.get(0));
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it = cmds.iterator();
                while (it.hasNext()) {
                    arrayList2.add((String) it.next());
                }
                arrayList.add(arrayList2);
                arrayList.add(KBuddyInvorkService.this);
                return g.INSTANCE.a(arrayList);
            }
        });
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Boolean.TRUE);
        f16.b("\u5f3a\u5237", listOf);
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(Boolean.FALSE);
        f16.b("\u975e\u5f3a\u5237", listOf2);
    }

    private final void I() {
        c("\u83b7\u53d6\u597d\u53cbuid", "\u8f93\u5165\u597d\u53cb\u6635\u79f0'", new Function2<List<? extends Object>, List<? extends String>, Unit>(this) { // from class: com.tencent.qqnt.kernel.invorker.KBuddyInvorkService$addGetBuddyUid$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ KBuddyInvorkService $cb;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$cb = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) KBuddyInvorkService.this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Object> list, List<? extends String> list2) {
                invoke2(list, (List<String>) list2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<? extends Object> preParas, @NotNull List<String> cmds) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) preParas, (Object) cmds);
                    return;
                }
                Intrinsics.checkNotNullParameter(preParas, "preParas");
                Intrinsics.checkNotNullParameter(cmds, "cmds");
                KBuddyInvorkService.this.buddyName = cmds.get(0);
                com.tencent.qqnt.kernel.api.j p16 = KBuddyInvorkService.this.p();
                Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.IBuddyService");
                ((m) p16).getBuddyList(false, this.$cb);
                KBuddyInvorkService.this.showCheckBuddy = 1;
            }
        });
    }

    private final void J() {
        List<? extends Object> listOf;
        List<? extends Object> listOf2;
        g.d f16 = f("setTop", "\u7f6e\u9876", "\u8f93\u5165\u597d\u53cbuid", new Function2<List<? extends Object>, List<? extends String>, g.a>() { // from class: com.tencent.qqnt.kernel.invorker.KBuddyInvorkService$addSetTop$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) KBuddyInvorkService.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ g.a invoke(List<? extends Object> list, List<? extends String> list2) {
                return invoke2(list, (List<String>) list2);
            }

            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final g.a invoke2(@NotNull List<? extends Object> preParas, @NotNull List<String> cmds) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (g.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) preParas, (Object) cmds);
                }
                Intrinsics.checkNotNullParameter(preParas, "preParas");
                Intrinsics.checkNotNullParameter(cmds, "cmds");
                ArrayList arrayList = new ArrayList();
                if (cmds.isEmpty()) {
                    return g.INSTANCE.b("may be lack of uid!");
                }
                arrayList.add(cmds.get(0));
                Object obj = preParas.get(0);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                arrayList.add(Boolean.valueOf(((Boolean) obj).booleanValue()));
                arrayList.add(KBuddyInvorkService.this);
                return g.INSTANCE.a(arrayList);
            }
        });
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Boolean.TRUE);
        f16.b("\u8bbe\u7f6e", listOf);
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(Boolean.FALSE);
        f16.b("\u53d6\u6d88", listOf2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> K(ArrayList<BuddyCategory> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("size(" + arrayList.size() + ")\n");
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            ArrayList<UserSimpleInfo> arrayList3 = ((BuddyCategory) it.next()).buddyList;
            Intrinsics.checkNotNullExpressionValue(arrayList3, "category.buddyList");
            for (UserSimpleInfo userSimpleInfo : arrayList3) {
                arrayList2.add(com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("uid", userSimpleInfo.coreInfo.uid), TuplesKt.to("name", userSimpleInfo.coreInfo.nick), TuplesKt.to("url", "")) + "\n\n");
            }
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
        Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.IBuddyService");
        m mVar = (m) p16;
        IKernelBuddyListener iKernelBuddyListener = this.listener;
        if (iKernelBuddyListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            iKernelBuddyListener = null;
        }
        mVar.I(iKernelBuddyListener);
    }

    @Override // com.tencent.qqnt.kernel.invorker.KBaseInvorkService
    public void s() {
        List<? extends Object> listOf;
        List<? extends Object> listOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        g.d e16 = e("getBuddyList", "\u83b7\u53d6\u597d\u53cb\u5217\u8868");
        listOf = CollectionsKt__CollectionsKt.listOf(Boolean.TRUE, this);
        e16.b("\u5f3a\u5237", listOf);
        listOf2 = CollectionsKt__CollectionsKt.listOf(Boolean.FALSE, this);
        e16.b("\u975e\u5f3a\u5237", listOf2);
        F();
        H();
        G();
        I();
        J();
    }

    @Override // com.tencent.qqnt.kernel.invorker.KBaseInvorkService
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.qqnt.kernel.api.j p16 = p();
        Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.IBuddyService");
        m mVar = (m) p16;
        IKernelBuddyListener iKernelBuddyListener = this.listener;
        if (iKernelBuddyListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            iKernelBuddyListener = null;
        }
        mVar.A(iKernelBuddyListener);
    }
}

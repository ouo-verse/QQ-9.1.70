package com.tencent.qqnt.kernel.invorker;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.invorker.g;
import com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener;
import com.tencent.qqnt.kernel.nativeinterface.StatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/kernel/invorker/KProfileInvorkService;", "Lcom/tencent/qqnt/kernel/invorker/KBaseInvorkService;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ReportConstant.COSTREPORT_PREFIX, "r", "u", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelProfileListener;", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelProfileListener;", "listener", "Lcom/tencent/qqnt/kernel/api/IKernelService;", "kernelService", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/invorker/f;", "notify", "<init>", "(Lcom/tencent/qqnt/kernel/api/IKernelService;Lmqq/app/AppRuntime;Lcom/tencent/qqnt/kernel/invorker/f;)V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class KProfileInvorkService extends KBaseInvorkService {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private IKernelProfileListener listener;

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J0\u0010\u000e\u001a\u00020\u00072&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0005H\u0016J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/qqnt/kernel/invorker/KProfileInvorkService$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelProfileListener;", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UserSimpleInfo;", "Lkotlin/collections/HashMap;", "profiles", "", "onProfileSimpleChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/UserDetailInfo;", "info", "onUserDetailInfoChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/StatusInfo;", "status", "onStatusUpdate", "onSelfStatusChanged", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements IKernelProfileListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) KProfileInvorkService.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public void onProfileSimpleChanged(@NotNull HashMap<String, UserSimpleInfo> profiles) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) profiles);
            } else {
                Intrinsics.checkNotNullParameter(profiles, "profiles");
                KProfileInvorkService.this.t("onProfileSimpleChanged", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("profiles", Integer.valueOf(profiles.size()))));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public void onSelfStatusChanged(@Nullable StatusInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) info);
            } else {
                KProfileInvorkService.this.t("onSelfStatusChanged", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("info", info)));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public /* synthetic */ void onStatusAsyncFieldUpdate(HashMap hashMap) {
            be.c(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public void onStatusUpdate(@Nullable HashMap<String, StatusInfo> status) {
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) status);
                return;
            }
            KProfileInvorkService kProfileInvorkService = KProfileInvorkService.this;
            com.tencent.qqnt.kernel.internel.a aVar = com.tencent.qqnt.kernel.internel.a.f359089a;
            Object[] objArr = new Object[1];
            if (status != null) {
                num = Integer.valueOf(status.size());
            } else {
                num = null;
            }
            objArr[0] = TuplesKt.to("status", num);
            kProfileInvorkService.t("onStatusUpdate", aVar.b(objArr));
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public /* synthetic */ void onStrangerRemarkChanged(HashMap hashMap) {
            be.e(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public void onUserDetailInfoChanged(@Nullable UserDetailInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) info);
            } else {
                KProfileInvorkService.this.t("onProfileDetailInfoChanged", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("info", info)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProfileInvorkService(@NotNull IKernelService kernelService, @NotNull AppRuntime app, @NotNull f notify) {
        super("\u8d44\u6599", y.class, kernelService, app, notify);
        Intrinsics.checkNotNullParameter(kernelService, "kernelService");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(notify, "notify");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, kernelService, app, notify);
        }
    }

    private final void A() {
        List<? extends Object> listOf;
        List<? extends Object> listOf2;
        g.d f16 = f("getUserSimpleInfo", "\u83b7\u53d6\u7528\u6237\u7b80\u5355\u8d44\u6599", "\u8f93\u5165\u597d\u53cbuid\u5217\u8868\uff0c\u5982'uid1 uid2 ... '", new Function2<List<? extends Object>, List<? extends String>, g.a>() { // from class: com.tencent.qqnt.kernel.invorker.KProfileInvorkService$addGetUserSimpleInfo$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) KProfileInvorkService.this);
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
                arrayList.add(KProfileInvorkService.this);
                return g.INSTANCE.a(arrayList);
            }
        });
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Boolean.TRUE);
        f16.b("\u5f3a\u5237", listOf);
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(Boolean.FALSE);
        f16.b("\u975e\u5f3a\u5237", listOf2);
    }

    private final void z() {
        f("getAvatarInfo", "\u83b7\u53d6\u5934\u50cf", "\u8f93\u5165\u597d\u53cbuid\u5217\u8868\uff0c\u5982'uid1 uid2 ... '", new Function2<List<? extends Object>, List<? extends String>, g.a>() { // from class: com.tencent.qqnt.kernel.invorker.KProfileInvorkService$addGetAvatarInfo$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) KProfileInvorkService.this);
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
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it = cmds.iterator();
                while (it.hasNext()) {
                    arrayList2.add((String) it.next());
                }
                arrayList.add(arrayList2);
                arrayList.add(KProfileInvorkService.this);
                return g.INSTANCE.a(arrayList);
            }
        });
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
        Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.IProfileService");
        y yVar = (y) p16;
        IKernelProfileListener iKernelProfileListener = this.listener;
        if (iKernelProfileListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            iKernelProfileListener = null;
        }
        yVar.r0(iKernelProfileListener);
    }

    @Override // com.tencent.qqnt.kernel.invorker.KBaseInvorkService
    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            A();
            z();
        }
    }

    @Override // com.tencent.qqnt.kernel.invorker.KBaseInvorkService
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.qqnt.kernel.api.j p16 = p();
        Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.IProfileService");
        y yVar = (y) p16;
        IKernelProfileListener iKernelProfileListener = this.listener;
        if (iKernelProfileListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            iKernelProfileListener = null;
        }
        yVar.D0(iKernelProfileListener);
    }
}

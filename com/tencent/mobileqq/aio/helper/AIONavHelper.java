package com.tencent.mobileqq.aio.helper;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleKt;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.event.AIOMsgReadEvent;
import com.tencent.mobileqq.aio.lateinit.aioreserve1.AIOReserve1CreateModelIntent;
import com.tencent.mobileqq.aio.msg.service.AIOMsgService;
import com.tencent.mobileqq.aio.reserve1.navigation.NavigationMsgIntent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ContactMsgBoxInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgsBoxesCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0016R\u0016\u0010\u0013\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/AIONavHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", "e", "j", "i", "", "getId", "", "getTag", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "", "interestedIn", "state", "onMoveToState", "d", "Lcom/tencent/aio/main/businesshelper/b;", "mHelperParam", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "mContext", "Landroidx/lifecycle/LifecycleCoroutineScope;", "f", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "<init>", "()V", tl.h.F, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class AIONavHelper implements com.tencent.aio.main.businesshelper.h {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b mHelperParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LifecycleCoroutineScope scope;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/AIONavHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.AIONavHelper$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48855);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIONavHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void e() {
        QLog.d("AIONavHelper", 1, "getNavigationInfo");
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        final Contact b16 = com.tencent.mobileqq.aio.utils.o.b(aVar.g().r().c());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.helper.k
            @Override // java.lang.Runnable
            public final void run() {
                AIONavHelper.g(Contact.this, this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Contact contact, final AIONavHelper this$0) {
        ArrayList<Contact> arrayListOf;
        Intrinsics.checkNotNullParameter(contact, "$contact");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AIOMsgService aIOMsgService = AIOMsgService.f190196a;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(contact);
        aIOMsgService.i(arrayListOf, new IGetMsgsBoxesCallback() { // from class: com.tencent.mobileqq.aio.helper.l
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetMsgsBoxesCallback
            public final void onMsgBoxesInfo(int i3, String str, ArrayList arrayList) {
                AIONavHelper.h(AIONavHelper.this, i3, str, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(final AIONavHelper this$0, final int i3, String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("AIONavHelper", 1, "getNavigationInfo result: " + i3 + ", " + str + ", " + arrayList.size());
        com.tencent.qqnt.aio.util.d.c(new Function0<Unit>(i3, arrayList) { // from class: com.tencent.mobileqq.aio.helper.AIONavHelper$getNavigationInfo$1$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<ContactMsgBoxInfo> $infoList;
            final /* synthetic */ int $result;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$result = i3;
                this.$infoList = arrayList;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, AIONavHelper.this, Integer.valueOf(i3), arrayList);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tencent.aio.api.runtime.a aVar;
                com.tencent.aio.api.runtime.a aVar2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                aVar = AIONavHelper.this.mContext;
                com.tencent.aio.api.runtime.a aVar3 = null;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    aVar = null;
                }
                aVar.e().h(AIOMsgReadEvent.SendMsgReadEvent.f188413d);
                if (this.$result == 0) {
                    ArrayList<ContactMsgBoxInfo> infoList = this.$infoList;
                    Intrinsics.checkNotNullExpressionValue(infoList, "infoList");
                    if (!infoList.isEmpty()) {
                        aVar2 = AIONavHelper.this.mContext;
                        if (aVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        } else {
                            aVar3 = aVar2;
                        }
                        com.tencent.mvi.base.route.j e16 = aVar3.e();
                        ArrayList<ContactMsgBoxInfo> infoList2 = this.$infoList;
                        Intrinsics.checkNotNullExpressionValue(infoList2, "infoList");
                        e16.h(new AIOReserve1CreateModelIntent("aio_navigation", new NavigationMsgIntent.UpdateNavigationList(infoList2, true)));
                    }
                }
            }
        });
    }

    private final void i() {
        LifecycleCoroutineScope lifecycleCoroutineScope = null;
        Flow flowOn = FlowKt.flowOn(FlowKt.onEach(AIOMsgService.f190196a.q(), new AIONavHelper$listenMsgUpdate$1(this, null)), Dispatchers.getMain());
        LifecycleCoroutineScope lifecycleCoroutineScope2 = this.scope;
        if (lifecycleCoroutineScope2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scope");
        } else {
            lifecycleCoroutineScope = lifecycleCoroutineScope2;
        }
        FlowKt.launchIn(flowOn, lifecycleCoroutineScope);
    }

    private final void j() {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        LifecycleCoroutineScope lifecycleCoroutineScope = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        Flow flowOn = FlowKt.flowOn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).contactMsgBoxChangedFlow(), new AIONavHelper$listenNavigationUpdate$1(com.tencent.mobileqq.aio.utils.o.b(aVar.g().r().c()).peerUid, this, null)), Dispatchers.getMain());
        LifecycleCoroutineScope lifecycleCoroutineScope2 = this.scope;
        if (lifecycleCoroutineScope2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scope");
        } else {
            lifecycleCoroutineScope = lifecycleCoroutineScope2;
        }
        FlowKt.launchIn(flowOn, lifecycleCoroutineScope);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 56;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "AIONavHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (int[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new int[]{0, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        this.mHelperParam = param;
        this.mContext = param.a();
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        Lifecycle lifecycle = bVar.a().d().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "mHelperParam.aioContext.lifecycleOwner.lifecycle");
        this.scope = LifecycleKt.getCoroutineScope(lifecycle);
        e();
        j();
        i();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            h.a.b(this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, state);
        }
    }
}

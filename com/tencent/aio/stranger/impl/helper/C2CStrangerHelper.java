package com.tencent.aio.stranger.impl.helper;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.aio.stranger.api.IStrangerAdapterApi;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.toast.QUIBottomToast;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.event.ShortCutBarEvent;
import com.tencent.mobileqq.aio.input.AIOInputMsgIntent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.interceptor.e;
import com.tencent.qqnt.aio.shortcutbar.i;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.global.settings.api.IGlobalSettingsApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/aio/stranger/impl/helper/C2CStrangerHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "panelEntry", "", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "o", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/aio/main/businesshelper/b;", "Lcom/tencent/aio/api/runtime/a;", "e", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/qqnt/aio/shortcutbar/i;", "f", "Lcom/tencent/qqnt/aio/shortcutbar/i;", "getPanelClickListener", "()Lcom/tencent/qqnt/aio/shortcutbar/i;", "setPanelClickListener", "(Lcom/tencent/qqnt/aio/shortcutbar/i;)V", "panelClickListener", "Lcom/tencent/qqnt/aio/interceptor/e;", h.F, "Lkotlin/Lazy;", "k", "()Lcom/tencent/qqnt/aio/interceptor/e;", "mSub", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/a;", "mAction1", "<init>", "()V", "a", "aio_stranger_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class C2CStrangerHelper implements com.tencent.aio.main.businesshelper.h {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b param;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private i panelClickListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mSub;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.base.route.a mAction1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/stranger/impl/helper/C2CStrangerHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_stranger_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aio.stranger.impl.helper.C2CStrangerHelper$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/aio/stranger/impl/helper/C2CStrangerHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_stranger_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) C2CStrangerHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
                return;
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof AIOTitleEvent.SubTitleRequestEvent) {
                C2CStrangerHelper.this.o(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/aio/stranger/impl/helper/C2CStrangerHelper$c", "Lcom/tencent/qqnt/aio/shortcutbar/i;", "", "id", "", "isSelected", "b", "a", "aio_stranger_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class c implements i {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) C2CStrangerHelper.this);
            }
        }

        @Override // com.tencent.qqnt.aio.shortcutbar.i
        public boolean a(int id5, boolean isSelected) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return C2CStrangerHelper.this.i(id5);
            }
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(id5), Boolean.valueOf(isSelected))).booleanValue();
        }

        @Override // com.tencent.qqnt.aio.shortcutbar.i
        public boolean b(int id5, boolean isSelected) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return C2CStrangerHelper.this.i(id5);
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(id5), Boolean.valueOf(isSelected))).booleanValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35111);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public C2CStrangerHelper() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(C2CStrangerHelper$mSub$2.INSTANCE);
            this.mSub = lazy;
            this.mAction1 = new b();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i(int panelEntry) {
        String string;
        String str;
        int d16;
        d.e eVar;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        View view = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        FragmentActivity requireActivity = aVar.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "aioContext.fragment.requireActivity()");
        if (panelEntry != 1000) {
            if (panelEntry != 1015) {
                string = null;
            } else {
                string = requireActivity.getString(R.string.f75);
            }
        } else {
            string = requireActivity.getString(R.string.f7k);
        }
        int i3 = 0;
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        String string2 = requireActivity.getString(R.string.ykg);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.add_friend_to_do)");
        if (panelEntry != 1000) {
            if (panelEntry != 1015) {
                str = "0";
            } else {
                str = "1";
            }
        } else {
            str = "2";
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("toast_type", str);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.aio.stranger.impl.helper.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2CStrangerHelper.j(C2CStrangerHelper.this, hashMap, view2);
            }
        };
        if (!com.tencent.qqnt.util.b.f362976b.isSplitViewMode(requireActivity)) {
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                aVar2 = null;
            }
            k k3 = aVar2.e().k(AIOInputMsgIntent.GetInputDialogAnchor.f189144d);
            if (k3 instanceof d.e) {
                eVar = (d.e) k3;
            } else {
                eVar = null;
            }
            if (eVar != null) {
                view = eVar.a();
            }
            int[] iArr = new int[2];
            if (view != null) {
                view.getLocationInWindow(iArr);
            }
            if (view != null) {
                i3 = iArr[1];
            }
            ViewUtils viewUtils = ViewUtils.f352270a;
            d16 = (viewUtils.d() - i3) + viewUtils.b(26);
        } else {
            ViewUtils viewUtils2 = ViewUtils.f352270a;
            d16 = viewUtils2.d() - viewUtils2.a(76.0f);
        }
        QUIBottomToast.Companion companion = QUIBottomToast.INSTANCE;
        companion.a(requireActivity, 0, string2 + string, requireActivity.getString(R.string.f170048dx), onClickListener, d16).n();
        com.tencent.mobileqq.aio.utils.b.q("em_bas_lead_toast", hashMap);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(C2CStrangerHelper this$0, HashMap params, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(params, "$params");
        this$0.m();
        com.tencent.mobileqq.aio.utils.b.l("em_bas_lead_toast", params);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e k() {
        return (e) this.mSub.getValue();
    }

    private final void m() {
        w msgService;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        AIOContact c16 = aVar.g().r().c();
        final int e16 = c16.e();
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar2 = aVar3;
        }
        final FragmentActivity requireActivity = aVar2.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "aioContext.fragment.requireActivity()");
        final String j3 = c16.j();
        final String g16 = c16.g();
        if (e16 == 111) {
            ((IStrangerAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IStrangerAdapterApi.class)).addContactFriend(requireActivity, j3, g16);
        } else if (e16 == 100 && (msgService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getMsgService()) != null) {
            msgService.getTempChatInfo(e16, j3, new IGetTempChatInfoCallback() { // from class: com.tencent.aio.stranger.impl.helper.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback
                public final void onResult(int i3, String str, TempChatInfo tempChatInfo) {
                    C2CStrangerHelper.n(FragmentActivity.this, g16, j3, e16, this, i3, str, tempChatInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(FragmentActivity context, String nickName, String peerUid, int i3, C2CStrangerHelper this$0, int i16, String str, TempChatInfo tempChatInfo) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(nickName, "$nickName");
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i16 == 0) {
            IStrangerAdapterApi iStrangerAdapterApi = (IStrangerAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IStrangerAdapterApi.class);
            String str2 = tempChatInfo.groupCode;
            Intrinsics.checkNotNullExpressionValue(str2, "tmpChatInfo.groupCode");
            iStrangerAdapterApi.addFriendFromStrangerChat(context, nickName, str2, peerUid, i3);
            return;
        }
        QLog.d(this$0.getTag(), 1, "getTempChatInfo: error->" + i16 + ", msg->" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(MsgIntent intent) {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        LifecycleOwner d16 = aVar.d();
        Intrinsics.checkNotNullExpressionValue(d16, "aioContext.lifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), null, null, new C2CStrangerHelper$handleSubTitleRequest$1(this, null), 3, null);
    }

    private final void p() {
        IGlobalSettingsApi iGlobalSettingsApi = (IGlobalSettingsApi) QRoute.api(IGlobalSettingsApi.class);
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        iGlobalSettingsApi.onEnterChat(bVar.a());
    }

    private final void q() {
        if (!com.tencent.aio.stranger.a.f69857a.b()) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        if (aVar.g().r().c().e() == 102) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar3 = null;
        }
        if (aVar3.e() == null) {
            QLog.e(getTag(), 1, "[initAndAddListener] aioContext.getMessenger() == null");
            return;
        }
        if (this.panelClickListener == null) {
            this.panelClickListener = new c();
        }
        com.tencent.aio.api.runtime.a aVar4 = this.aioContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar2 = aVar4;
        }
        aVar2.e().h(new ShortCutBarEvent.SetShortcutPanelClickListener(this.panelClickListener));
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 22;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "C2CStrangerHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (int[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new int[]{0, 4};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.aioContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            a16 = null;
        }
        a16.e().d(Reflection.getOrCreateKotlinClass(AIOTitleEvent.SubTitleRequestEvent.class).getQualifiedName(), this.mAction1);
        q();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        h.a.b(this);
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        aVar.e().b(Reflection.getOrCreateKotlinClass(AIOTitleEvent.SubTitleRequestEvent.class).getQualifiedName(), this.mAction1);
        com.tencent.aio.stranger.a.f69857a.a(null);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, state);
        } else if (state == 4) {
            p();
        }
    }
}

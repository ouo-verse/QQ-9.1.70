package com.tencent.mobileqq.nearbypro.aio.helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearbypro.aio.api.INearbyProAIOHelperApi;
import com.tencent.mobileqq.nearbypro.aio.event.NearbyProAioMsgEvent;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qqnt.aio.menu.MenuMsgEvent;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.i;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\"\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000fH\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/nearbypro/aio/helper/d;", "Lcom/tencent/aio/main/businesshelper/h;", "", "e", "k", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "j", "Ljava/lang/Runnable;", "callback", "g", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getId", "", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/widget/ActionSheet;", "Lcom/tencent/widget/ActionSheet;", "mActionSheet", "Lcom/tencent/mvi/base/route/a;", "f", "Lcom/tencent/mvi/base/route/a;", "mAction1", "com/tencent/mobileqq/nearbypro/aio/helper/d$b", h.F, "Lcom/tencent/mobileqq/nearbypro/aio/helper/d$b;", "mMsgListener", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes15.dex */
public final class d implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ActionSheet mActionSheet;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.base.route.a mAction1 = new a();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b mMsgListener = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/nearbypro/aio/helper/d$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        a() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            d.this.j(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/nearbypro/aio/helper/d$b", "Lcom/tencent/qqnt/msg/i;", "", "msgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "errorCode", "", "errorMsg", "", "onSendMsgError", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends i {
        b() {
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onSendMsgError(long msgId, @Nullable Contact peer, int errorCode, @Nullable String errorMsg) {
            j.c().e(d.this.getTag(), "onSendMsgError: " + msgId + ", " + peer + ", " + errorCode + ", " + errorMsg);
            SimpleEventBus.getInstance().dispatchEvent(new NearbyProAioMsgEvent(msgId, peer, errorCode, errorMsg));
        }
    }

    private final void e() {
        w msgService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, ProcessConstant.NEARBY)).getMsgService()) != null) {
            msgService.addMsgListener(this.mMsgListener);
        }
    }

    private final void g(final Runnable callback) {
        final Context context;
        Fragment c16;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (c16 = aVar.c()) != null) {
            context = c16.getContext();
        } else {
            context = null;
        }
        if (context == null) {
            j.c().c(getTag(), "delCheck failure, context == null");
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.nearbypro.aio.helper.b
            @Override // java.lang.Runnable
            public final void run() {
                d.h(d.this, context, callback);
            }
        };
        Object systemService = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        boolean isActive = inputMethodManager.isActive();
        if ((context instanceof Activity) && isActive) {
            inputMethodManager.hideSoftInputFromWindow(((Activity) context).getWindow().getDecorView().getWindowToken(), 0);
            ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, 60L);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(final d this$0, Context context, final Runnable callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Dialog createDialog = ActionSheetHelper.createDialog(context, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        this$0.mActionSheet = (ActionSheet) createDialog;
        Intrinsics.checkNotNull(context);
        String string = context.getResources().getString(R.string.f170122k7);
        Intrinsics.checkNotNull(string, "null cannot be cast to non-null type kotlin.CharSequence");
        ActionSheet actionSheet = this$0.mActionSheet;
        if (actionSheet != null) {
            actionSheet.setMainTitle(string);
        }
        ActionSheet actionSheet2 = this$0.mActionSheet;
        if (actionSheet2 != null) {
            actionSheet2.addButton(R.string.f170102k5, 3);
        }
        ActionSheet actionSheet3 = this$0.mActionSheet;
        if (actionSheet3 != null) {
            actionSheet3.addCancelButton(R.string.cancel);
        }
        ActionSheet actionSheet4 = this$0.mActionSheet;
        if (actionSheet4 != null) {
            actionSheet4.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.nearbypro.aio.helper.c
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i3) {
                    d.i(callback, this$0, view, i3);
                }
            });
        }
        ActionSheet actionSheet5 = this$0.mActionSheet;
        if (actionSheet5 != null) {
            actionSheet5.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Runnable callback, d this$0, View view, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            callback.run();
        }
        ActionSheet actionSheet = this$0.mActionSheet;
        if (actionSheet != null) {
            actionSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(MsgIntent intent) {
        if (intent instanceof MenuMsgEvent.DelCheckEvent) {
            j.c().c(getTag(), "MenuMsgEvent.DelCheckEvent");
            g(((MenuMsgEvent.DelCheckEvent) intent).a());
        }
    }

    private final void k() {
        w msgService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, ProcessConstant.NEARBY)).getMsgService()) != null) {
            msgService.removeMsgListener(this.mMsgListener);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return ((INearbyProAIOHelperApi) QRoute.api(INearbyProAIOHelperApi.class)).getNearbyProMsgHelperId();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "NearbyProMsgHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[0];
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.aioContext = a16;
        Intrinsics.checkNotNull(a16);
        a16.e().d(Reflection.getOrCreateKotlinClass(MenuMsgEvent.DelCheckEvent.class).getQualifiedName(), this.mAction1);
        e();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        com.tencent.mvi.base.route.j e16;
        h.a.b(this);
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.b(Reflection.getOrCreateKotlinClass(MenuMsgEvent.DelCheckEvent.class).getQualifiedName(), this.mAction1);
        }
        k();
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}

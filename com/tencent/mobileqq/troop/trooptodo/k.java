package com.tencent.mobileqq.troop.trooptodo;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.api.msg.impl.GuildMsgElementApiImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.trooptodo.d;
import com.tencent.mobileqq.troop.trooptodo.handler.TroopToDoHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010$R\u0014\u0010(\u001a\u00020&8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/troop/trooptodo/k;", "", "", "f", "l", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/troop/trooptodo/d;", "model", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "msgSeq", tl.h.F, "r", "j", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "", "e", "Lcom/tencent/aio/api/runtime/a;", "a", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/troop/trooptodo/TroopToDoReporter;", "b", "Lcom/tencent/mobileqq/troop/trooptodo/TroopToDoReporter;", "reporter", "<set-?>", "c", "Lcom/tencent/mobileqq/troop/trooptodo/d;", "d", "()Lcom/tencent/mobileqq/troop/trooptodo/d;", "Ljava/lang/String;", "taskStatusText", "", "Z", "taskStatusVisibility", "Lcom/tencent/common/app/AppInterface;", "()Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lcom/tencent/mobileqq/troop/trooptodo/TroopToDoReporter;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopToDoReporter reporter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d model;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String taskStatusText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean taskStatusVisibility;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/trooptodo/k$a;", "", "", "BTN_CLOSE", "I", "BTN_RECALL", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.trooptodo.k$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62023);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public k(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull TroopToDoReporter reporter) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext, (Object) reporter);
            return;
        }
        this.aioContext = aioContext;
        this.reporter = reporter;
        this.model = new d();
        this.taskStatusText = "";
    }

    private final AppInterface c() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        return (AppInterface) peekAppRuntime;
    }

    private final void f() {
        boolean startsWith$default;
        String b16 = this.model.b();
        Intrinsics.checkNotNullExpressionValue(b16, "model.content");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(b16, GuildMsgElementApiImpl.DESC_ELEMENT_FILE, false, 2, null);
        if (startsWith$default) {
            Contact contact = new Contact();
            contact.chatType = this.aioContext.g().r().c().e();
            contact.peerUid = this.aioContext.g().r().c().j();
            ((IMsgService) QRoute.api(IMsgService.class)).getSingleMsg(contact, this.model.c().f301781b, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.troop.trooptodo.i
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    k.g(k.this, i3, str, arrayList);
                }
            });
            return;
        }
        if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppScheme(this.model.c().f301784e)) {
            h(this.model.c().f301781b);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("url", this.model.c().f301784e);
        RouteUtils.startActivity(this.aioContext.c().getContext(), intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(k this$0, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0 && arrayList.size() > 0) {
            MsgRecord msgRecord = (MsgRecord) arrayList.get(0);
            if (msgRecord.msgType == 3) {
                Context context = this$0.aioContext.c().getContext();
                if (context != null) {
                    IRichMediaBrowserApi iRichMediaBrowserApi = (IRichMediaBrowserApi) QRoute.api(IRichMediaBrowserApi.class);
                    AppInterface c16 = this$0.c();
                    Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type mqq.app.AppRuntime");
                    Intrinsics.checkNotNullExpressionValue(msgRecord, "msgRecord");
                    iRichMediaBrowserApi.enterFileBrowser(c16, context, new AIOMsgItem(msgRecord));
                    return;
                }
                return;
            }
        }
        this$0.h(this$0.model.c().f301781b);
    }

    private final void h(long msgSeq) {
        QLog.i("TroopToDoTipsBarNew", 1, "[handlerMsgLocation] msgSeq = " + msgSeq);
        this.aioContext.e().h(new MsgNavigationEvent.NavigateBySeqEvent("TroopToDoTipsBarNew", msgSeq, 0L, true, null, false, false, null, 192, null));
    }

    private final void i(d model) {
        if (model.c().f301783d == 3) {
            q();
            return;
        }
        if (model.c().f301783d == 1) {
            if (n.d(c(), model.c().f301780a)) {
                p();
            }
        } else {
            QLog.e("TroopToDoTipsBarNew", 4, "initTaskStatusBtn state error: " + model);
        }
    }

    private final void l() {
        d.b c16 = this.model.c();
        Intrinsics.checkNotNullExpressionValue(c16, "model.rawInfo");
        BusinessHandler businessHandler = c().getBusinessHandler(TroopToDoHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.trooptodo.handler.TroopToDoHandler");
        ((TroopToDoHandler) businessHandler).G2(c16.f301780a, c16.f301781b, c16.f301782c);
        this.reporter.f();
    }

    private final void n() {
        Dialog createDialog = ActionSheetHelper.createDialog(this.aioContext.c().getContext(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.setMainTitle(R.string.f236617eu);
        actionSheet.addButton(R.string.f236627ev);
        actionSheet.addButton(R.string.f236607et);
        actionSheet.addCancelButton(R.string.f236597es);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.trooptodo.j
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                k.o(k.this, actionSheet, view, i3);
            }
        });
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(k this$0, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        if (i3 != 0) {
            if (i3 != 1) {
                QLog.e("TroopToDoTipsBarNew", 1, "actionSheet: trigger default");
            } else {
                this$0.l();
            }
        } else {
            d.b c16 = this$0.model.c();
            Intrinsics.checkNotNullExpressionValue(c16, "model.rawInfo");
            BusinessHandler businessHandler = this$0.c().getBusinessHandler(TroopToDoHandler.class.getName());
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.trooptodo.handler.TroopToDoHandler");
            ((TroopToDoHandler) businessHandler).K2(c16.f301780a, c16.f301781b, c16.f301782c);
        }
        actionSheet.dismiss();
    }

    private final void q() {
        String string = BaseApplication.getContext().getString(R.string.f236657ey);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026o_task_status_un_clicked)");
        this.taskStatusText = string;
        this.taskStatusVisibility = false;
    }

    @NotNull
    public final d d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.model;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (this.taskStatusVisibility) {
            return this.taskStatusText;
        }
        return "";
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (a.a("TroopToDoTipsBarNewonBannerClick")) {
            return;
        }
        if (this.model.d() == -1) {
            QLog.e("TroopToDoTipsBarNew", 1, "onBannerClick: model is not initialized");
            return;
        }
        if (this.model.d() == 2) {
            f();
            this.reporter.i();
        } else if (this.model.d() == 1) {
            h(this.model.c().f301781b);
            this.reporter.j();
        }
        this.taskStatusVisibility = true;
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (a.a("TroopToDoTipsBarNewonClose")) {
            return;
        }
        if (this.model.d() == -1) {
            QLog.e("TroopToDoTipsBarNew", 1, "onClose: model is not initialized");
        } else if (n.d(c(), this.model.c().f301780a)) {
            n();
        } else {
            l();
        }
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (a.a("TroopToDoTipsBarNewonComplete")) {
            return;
        }
        if (this.model.d() == -1) {
            QLog.e("TroopToDoTipsBarNew", 1, "onComplete: model is not initialized");
            return;
        }
        d.b c16 = this.model.c();
        Intrinsics.checkNotNullExpressionValue(c16, "model.rawInfo");
        QRouteApi api = QRoute.api(ITroopListRepoApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopListRepoApi::class.java)");
        if (ITroopListRepoApi.a.b((ITroopListRepoApi) api, String.valueOf(c16.f301780a), "TroopToDoTipsBarNew", false, 4, null)) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f236587er, 0).show();
            return;
        }
        this.reporter.g();
        if (Intrinsics.areEqual(this.taskStatusText, BaseApplication.getContext().getString(R.string.f236647ex))) {
            return;
        }
        BusinessHandler businessHandler = c().getBusinessHandler(TroopToDoHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.trooptodo.handler.TroopToDoHandler");
        ((TroopToDoHandler) businessHandler).H2(c16.f301780a, c16.f301781b, c16.f301782c);
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        String string = BaseApplication.getContext().getString(R.string.f236647ex);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026o_do_task_status_clicked)");
        this.taskStatusText = string;
        this.taskStatusVisibility = true;
    }

    public final void r(@NotNull d model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) model);
            return;
        }
        Intrinsics.checkNotNullParameter(model, "model");
        this.model = model;
        i(model);
    }
}

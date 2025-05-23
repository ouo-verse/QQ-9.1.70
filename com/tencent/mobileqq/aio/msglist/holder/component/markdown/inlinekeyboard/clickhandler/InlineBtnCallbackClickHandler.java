package com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.clickhandler;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.aio.data.AIOParam;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.nativeinterface.IClickInlineKeyboardButtonCallback;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardClickInfo;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardElement;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.f;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 (2\u0016\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001j\u0002`\u0005:\u0001(B\u0007\u00a2\u0006\u0004\b&\u0010'JD\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00062\n\u0010\b\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J4\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\n\u0010\b\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J&\u0010\u001b\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\n\u001a\u00020\t2\n\u0010\b\u001a\u00060\u0003j\u0002`\u0004H\u0002J0\u0010#\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u001eH\u0002J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001eH\u0002J@\u0010%\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00062\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0016\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/inlinekeyboard/clickhandler/InlineBtnCallbackClickHandler;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/compat/b;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/InlineBtnPayload;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/AIOInlineBoardClickHandler;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "btnView", "payload", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "ctx", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardElement;", "inlineKeyboardElement", "", "o", "", "btnKey", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/compat/a;", "inlineKeyboardApi", "Lkotlinx/coroutines/Job;", "g", "timeOutJob", "l", "Lcom/tencent/aio/api/runtime/a;", "aioContext", h.F, "k", "Landroid/content/Context;", "context", "", "status", "promptType", QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT, "promptIcon", "i", "f", DomainData.DOMAIN_NAME, "<init>", "()V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class InlineBtnCallbackClickHandler implements com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/inlinekeyboard/clickhandler/InlineBtnCallbackClickHandler$a;", "", "", "ERROR_TIMEOUT", "I", "STATUS_OK", "", "TAG", "Ljava/lang/String;", "TEXT_OK", "", "TIME_OUT_INTERVAL", "J", "TOAST_NETWORK_ERROR", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.clickhandler.InlineBtnCallbackClickHandler$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61419);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public InlineBtnCallbackClickHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int f(int promptIcon) {
        if (promptIcon != 0) {
            if (promptIcon != 2) {
                if (promptIcon == 3) {
                    return 2;
                }
                return 0;
            }
            return 1;
        }
        return -1;
    }

    private final Job g(final String btnKey, com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.a inlineKeyboardApi) {
        Job launch$default;
        final WeakReference weakReference = new WeakReference(inlineKeyboardApi);
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new InlineBtnCallbackClickHandler$createTimeoutJob$1(null), 3, null);
        launch$default.invokeOnCompletion(new Function1<Throwable, Unit>(weakReference, btnKey) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.clickhandler.InlineBtnCallbackClickHandler$createTimeoutJob$2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $btnKey;
            final /* synthetic */ WeakReference<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.a> $weakApi;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$weakApi = weakReference;
                this.$btnKey = btnKey;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference, (Object) btnKey);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) th5);
                    return;
                }
                if (th5 != null && !(th5 instanceof CancellationException)) {
                    QLog.e("InlineBtnCallbackClickHandler", 1, "timeOutJob exception happen! " + th5);
                }
                com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.a aVar = this.$weakApi.get();
                if (aVar != null) {
                    aVar.c(this.$btnKey);
                }
            }
        });
        return launch$default;
    }

    private final String h(com.tencent.aio.api.runtime.a aioContext) {
        Long z06;
        String l3;
        AIOParam g16 = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        long a16 = su3.c.a(g16);
        String j3 = aioContext.g().r().c().j();
        int e16 = aioContext.g().r().c().e();
        QLog.d("InlineBtnCallbackClickHandler", 1, "getPeerUinStr chatType=" + e16 + " uin=" + a16 + " uid=" + j3);
        if (e16 == 2) {
            return j3;
        }
        if (a16 != 0) {
            return String.valueOf(a16);
        }
        ag l16 = f.l();
        if (l16 == null || (z06 = l16.z0(j3)) == null || (l3 = z06.toString()) == null) {
            return "";
        }
        return l3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(Context context, int status, int promptType, String promptText, int promptIcon) {
        if (promptType != 1) {
            if (promptType == 2) {
                QQToast.makeText(context, f(promptIcon), promptText, 0).show();
                return;
            }
            return;
        }
        DialogUtil.createCustomDialog(context, 230, promptText, "", "", "\u597d\u7684", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.clickhandler.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                InlineBtnCallbackClickHandler.j(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.a inlineKeyboardApi, com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, AIOMsgItem payload) {
        InlineKeyboardButton inlineKeyboardButton;
        boolean z16;
        Object e16 = btnModel.e();
        if (e16 instanceof InlineKeyboardButton) {
            inlineKeyboardButton = (InlineKeyboardButton) e16;
        } else {
            inlineKeyboardButton = null;
        }
        if (inlineKeyboardButton == null) {
            return;
        }
        String str = inlineKeyboardButton.groupId;
        boolean z17 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            String str2 = inlineKeyboardButton.visitedLabel;
            Intrinsics.checkNotNullExpressionValue(str2, "selectButton.visitedLabel");
            if (str2.length() > 0) {
                z17 = true;
            }
            if (!z17 || Intrinsics.areEqual(inlineKeyboardButton.label, inlineKeyboardButton.visitedLabel)) {
                return;
            }
        }
        if (inlineKeyboardApi != null) {
            inlineKeyboardApi.d(payload, btnModel);
        }
    }

    private final void l(com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b ctx, InlineKeyboardElement inlineKeyboardElement, final AIOMsgItem payload, final com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, final Job timeOutJob) {
        com.tencent.aio.api.runtime.a a16 = ctx.a();
        if (a16 == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(ctx.b());
        ((IMsgService) QRoute.api(IMsgService.class)).clickInlineKeyboardButton(new InlineKeyboardClickInfo("", h(a16), inlineKeyboardElement.botAppid, payload.getMsgSeq(), btnModel.c(), btnModel.a().a(), 0, a16.g().r().c().e()), new IClickInlineKeyboardButtonCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.clickhandler.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IClickInlineKeyboardButtonCallback
            public final void onResult(int i3, String str, int i16, String str2, int i17, int i18) {
                InlineBtnCallbackClickHandler.m(Job.this, this, weakReference, btnModel, payload, i3, str, i16, str2, i17, i18);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(final Job timeOutJob, final InlineBtnCallbackClickHandler this$0, final WeakReference weakApi, final com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, final AIOMsgItem payload, final int i3, final String str, final int i16, final String str2, final int i17, final int i18) {
        Intrinsics.checkNotNullParameter(timeOutJob, "$timeOutJob");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(weakApi, "$weakApi");
        Intrinsics.checkNotNullParameter(btnModel, "$btnModel");
        Intrinsics.checkNotNullParameter(payload, "$payload");
        com.tencent.qqnt.aio.util.d.c(new Function0<Unit>(i3, str, timeOutJob, this$0, i16, i17, str2, i18, weakApi, btnModel, payload) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.clickhandler.InlineBtnCallbackClickHandler$invokeBackend$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a $btnModel;
            final /* synthetic */ String $errMsg;
            final /* synthetic */ AIOMsgItem $payload;
            final /* synthetic */ int $promptIcon;
            final /* synthetic */ String $promptText;
            final /* synthetic */ int $promptType;
            final /* synthetic */ int $result;
            final /* synthetic */ int $status;
            final /* synthetic */ Job $timeOutJob;
            final /* synthetic */ WeakReference<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.a> $weakApi;
            final /* synthetic */ InlineBtnCallbackClickHandler this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$result = i3;
                this.$errMsg = str;
                this.$timeOutJob = timeOutJob;
                this.this$0 = this$0;
                this.$status = i16;
                this.$promptType = i17;
                this.$promptText = str2;
                this.$promptIcon = i18;
                this.$weakApi = weakApi;
                this.$btnModel = btnModel;
                this.$payload = payload;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, timeOutJob, this$0, Integer.valueOf(i16), Integer.valueOf(i17), str2, Integer.valueOf(i18), weakApi, btnModel, payload);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                int i19 = this.$result;
                if (i19 != 0) {
                    QQToast.makeText(BaseApplication.getContext(), i19 == 1002 ? VSNetLightQUICBaseRequest.NETWORK_ERROR_HINT : this.$errMsg, 0).show();
                    Job job = this.$timeOutJob;
                    String errMsg = this.$errMsg;
                    Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                    JobKt__JobKt.cancel$default(job, errMsg, null, 2, null);
                    return;
                }
                InlineBtnCallbackClickHandler inlineBtnCallbackClickHandler = this.this$0;
                BaseApplication context = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                int i26 = this.$status;
                int i27 = this.$promptType;
                String str3 = this.$promptText;
                if (str3 == null) {
                    str3 = "";
                }
                inlineBtnCallbackClickHandler.i(context, i26, i27, str3, this.$promptIcon);
                Job.DefaultImpls.cancel$default(this.$timeOutJob, (CancellationException) null, 1, (Object) null);
                if (this.$status == 0) {
                    this.this$0.k(this.$weakApi.get(), this.$btnModel, this.$payload);
                }
            }
        });
    }

    private final void o(InlineBtnView<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> btnView, AIOMsgItem payload, com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b ctx, InlineKeyboardElement inlineKeyboardElement) {
        com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.a b16 = ctx.b();
        if (b16 == null) {
            return;
        }
        String a16 = b16.a(btnView);
        Job g16 = g(a16, b16);
        b16.b(a16, btnView);
        l(ctx, inlineKeyboardElement, payload, btnModel, g16);
    }

    @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b ctx, @NotNull InlineBtnView<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> btnView, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, @Nullable AIOMsgItem payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, ctx, btnView, btnModel, payload);
            return;
        }
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(btnView, "btnView");
        Intrinsics.checkNotNullParameter(btnModel, "btnModel");
        if (payload != null && ctx.a() != null) {
            com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.a b16 = ctx.b();
            if (b16 != null && b16.e(payload, btnModel)) {
                z16 = true;
            }
            if (z16) {
                return;
            }
            InlineKeyboardElement a16 = com.tencent.mobileqq.aio.msglist.holder.component.markdown.utils.a.f191110a.a(payload.getMsgRecord());
            if (a16 == null) {
                QLog.e("InlineBtnCallbackClickHandler", 1, "inlineKeyboardElement should not be null");
            } else {
                o(btnView, payload, btnModel, ctx, a16);
            }
        }
    }
}

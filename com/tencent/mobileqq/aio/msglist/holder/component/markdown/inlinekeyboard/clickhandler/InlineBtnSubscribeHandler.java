package com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.clickhandler;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.SubscribeMsgTemplateID;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000  2\u0016\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001j\u0002`\u0005:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ<\u0010\r\u001a\u00020\f2\n\u0010\u0006\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\nH\u0002J \u0010\u0011\u001a\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u00120\u00122\n\u0010\u0006\u001a\u00060\u0003j\u0002`\u0004H\u0002J\u0014\u0010\u0015\u001a\u00020\u00142\n\u0010\u0006\u001a\u00060\u0003j\u0002`\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J@\u0010\u0019\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00022\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\n2\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/inlinekeyboard/clickhandler/InlineBtnSubscribeHandler;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/compat/b;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/InlineBtnPayload;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/AIOInlineBoardClickHandler;", "payload", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "ctx", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "btnView", "", h.F, "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/SubscribeMsgTemplateID;", "kotlin.jvm.PlatformType", "e", "", "d", "", "c", "Landroid/content/Context;", "context", "f", "g", "", "a", "I", "mDialogState", "<init>", "()V", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class InlineBtnSubscribeHandler implements com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f191045b;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mDialogState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/inlinekeyboard/clickhandler/InlineBtnSubscribeHandler$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61459);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f191045b = new a(null);
        }
    }

    public InlineBtnSubscribeHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final long c(AIOMsgItem payload) {
        if (payload.getMsgRecord().chatType == 2) {
            return payload.getMsgRecord().peerUin;
        }
        return 0L;
    }

    private final String d(AIOMsgItem payload) {
        boolean z16;
        MsgRecord msgRecord = payload.getMsgRecord();
        String str = msgRecord.sendMemberName;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!(true ^ z16)) {
            str = null;
        }
        if (str == null) {
            return msgRecord.sendNickName;
        }
        return str;
    }

    private final ArrayList<SubscribeMsgTemplateID> e(com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel) {
        InlineKeyboardButton inlineKeyboardButton;
        ArrayList<SubscribeMsgTemplateID> arrayList;
        Object e16 = btnModel.e();
        if (e16 instanceof InlineKeyboardButton) {
            inlineKeyboardButton = (InlineKeyboardButton) e16;
        } else {
            inlineKeyboardButton = null;
        }
        if (inlineKeyboardButton == null || (arrayList = inlineKeyboardButton.subscribeDataTemplateIds) == null || !(!arrayList.isEmpty())) {
            return null;
        }
        return arrayList;
    }

    private final void f(Context context) {
        QQToast.makeText(context, R.string.f170250ys0, 0, 0).show();
    }

    private final void h(AIOMsgItem payload, com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b ctx, InlineBtnView<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> btnView) {
        long j3 = payload.getMsgRecord().senderUin;
        long c16 = c(payload);
        String robotName = d(payload);
        ArrayList<SubscribeMsgTemplateID> e16 = e(btnModel);
        if (e16 == null) {
            Context context = btnView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "btnView.context");
            f(context);
            QLog.e("InlineBtnSubscribeHandler", 1, "[performClick], templateIds is null");
            return;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.a b16 = ctx.b();
        if (b16 == null) {
            return;
        }
        final String a16 = b16.a(btnView);
        b16.b(a16, btnView);
        final WeakReference weakReference = new WeakReference(ctx);
        IRobotServiceApi iRobotServiceApi = (IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class);
        Context context2 = btnView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "btnView.context");
        Intrinsics.checkNotNullExpressionValue(robotName, "robotName");
        iRobotServiceApi.showTicketRequestDialog(context2, c16, j3, robotName, e16, new Function1<Integer, Unit>(weakReference, this, a16) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.clickhandler.InlineBtnSubscribeHandler$performClickInternal$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $keyOfBtn;
            final /* synthetic */ WeakReference<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b> $weakCtx;
            final /* synthetic */ InlineBtnSubscribeHandler this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.clickhandler.InlineBtnSubscribeHandler$performClickInternal$1$1", f = "InlineBtnSubscribeHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.clickhandler.InlineBtnSubscribeHandler$performClickInternal$1$1, reason: invalid class name */
            /* loaded from: classes11.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $it;
                final /* synthetic */ String $keyOfBtn;
                final /* synthetic */ WeakReference<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b> $weakCtx;
                int label;
                final /* synthetic */ InlineBtnSubscribeHandler this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(InlineBtnSubscribeHandler inlineBtnSubscribeHandler, int i3, WeakReference<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b> weakReference, String str, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = inlineBtnSubscribeHandler;
                    this.$it = i3;
                    this.$weakCtx = weakReference;
                    this.$keyOfBtn = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, inlineBtnSubscribeHandler, Integer.valueOf(i3), weakReference, str, continuation);
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                    }
                    return new AnonymousClass1(this.this$0, this.$it, this.$weakCtx, this.$keyOfBtn, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b bVar;
                    com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.a b16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.this$0.mDialogState = this.$it;
                            int i3 = this.$it;
                            if ((i3 == 2 || i3 == 0) && (bVar = this.$weakCtx.get()) != null && (b16 = bVar.b()) != null) {
                                b16.c(this.$keyOfBtn);
                            }
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$weakCtx = weakReference;
                this.this$0 = this;
                this.$keyOfBtn = a16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, weakReference, this, a16);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                com.tencent.aio.api.runtime.a a17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3);
                    return;
                }
                com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b bVar = this.$weakCtx.get();
                if (bVar == null || (a17 = bVar.a()) == null) {
                    return;
                }
                LifecycleOwner d16 = a17.d();
                Intrinsics.checkNotNullExpressionValue(d16, "aioContext.lifecycleOwner");
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), Dispatchers.getMain().getImmediate(), null, new AnonymousClass1(this.this$0, i3, this.$weakCtx, this.$keyOfBtn, null), 2, null);
            }
        });
    }

    @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b ctx, @NotNull InlineBtnView<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> btnView, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, @Nullable AIOMsgItem payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, ctx, btnView, btnModel, payload);
            return;
        }
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(btnView, "btnView");
        Intrinsics.checkNotNullParameter(btnModel, "btnModel");
        if (payload != null && !FastClickUtils.isFastDoubleClick("InlineBtnSubscribeHandler")) {
            int i3 = this.mDialogState;
            if (i3 != 0) {
                QLog.i("InlineBtnSubscribeHandler", 1, "[performClick]: dialog state=" + i3);
                return;
            }
            h(payload, btnModel, ctx, btnView);
        }
    }
}

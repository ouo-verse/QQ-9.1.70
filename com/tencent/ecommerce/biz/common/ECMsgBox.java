package com.tencent.ecommerce.biz.common;

import android.content.Context;
import android.view.View;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.biz.register.refactoring.utils.ECRegisterSuccessEvent;
import com.tencent.ecommerce.biz.router.ECScheme;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 !2\u00020\u0001:\u0001\u0005B/\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017j\u0004\u0018\u0001`\u0018\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\rR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R%\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017j\u0004\u0018\u0001`\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/ecommerce/biz/common/ECMsgBox;", "", "Lorg/json/JSONObject;", "msgBox", "", "a", "c", "b", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "Ljava/lang/ref/WeakReference;", "weakReference", "Lcom/tencent/ecommerce/base/ui/g;", "Lcom/tencent/ecommerce/base/ui/g;", "chatDialog", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lcom/tencent/ecommerce/biz/register/refactoring/utils/c;", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "successRegisterObserver", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "d", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "dialogCallback", "Lkotlin/Function0;", "Lcom/tencent/ecommerce/base/ui/ISimpleChatDialogOnBackPressed;", "e", "Lkotlin/jvm/functions/Function0;", "getOnBackPressedCallBack", "()Lkotlin/jvm/functions/Function0;", "onBackPressedCallBack", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;Lkotlin/jvm/functions/Function0;)V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECMsgBox {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<Context> weakReference;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final g chatDialog;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final EventObserver<ECRegisterSuccessEvent> successRegisterObserver = new b();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final IECSchemeCallback dialogCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> onBackPressedCallBack;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/utils/c;", "event", "", "a", "(Lcom/tencent/ecommerce/biz/register/refactoring/utils/c;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b<T> implements EventObserver<ECRegisterSuccessEvent> {
        b() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onEvent(ECRegisterSuccessEvent eCRegisterSuccessEvent) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("regSuccess", eCRegisterSuccessEvent.isSuccessRegistered);
            ECMsgBox.this.dialogCallback.onCallbackFinished(jSONObject);
        }
    }

    public ECMsgBox(Context context, IECSchemeCallback iECSchemeCallback, Function0<Unit> function0) {
        this.dialogCallback = iECSchemeCallback;
        this.onBackPressedCallBack = function0;
        this.weakReference = new WeakReference<>(context);
        this.chatDialog = new g(context);
    }

    public final void b() {
        LifecycleEventBus.f100688b.e(this.successRegisterObserver);
        if (this.weakReference.get() != null) {
            this.chatDialog.dismiss();
        }
    }

    public final void c() {
        LifecycleEventBus.f100688b.d(ThreadMode.ORIGIN, ECRegisterSuccessEvent.class, this.successRegisterObserver);
        if (this.weakReference.get() != null) {
            this.chatDialog.show();
        }
    }

    public final void a(JSONObject msgBox) {
        final String optString = msgBox.optString("title", "");
        final String optString2 = msgBox.optString("text", "");
        JSONObject optJSONObject = msgBox.optJSONObject("left_btn");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        final JSONObject jSONObject = optJSONObject;
        JSONObject optJSONObject2 = msgBox.optJSONObject("right_btn");
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        final JSONObject jSONObject2 = optJSONObject2;
        final String optString3 = jSONObject.optString("text", "\u53d6\u6d88");
        final String optString4 = jSONObject2.optString("text", "\u7acb\u5373\u67e5\u770b");
        final boolean optBoolean = jSONObject.optBoolean("should_keep_msg_box");
        final boolean optBoolean2 = jSONObject.optBoolean("should_pop_page");
        g gVar = this.chatDialog;
        gVar.setTitle(optString2.length() == 0 ? "" : optString);
        gVar.Y(optString2.length() == 0 ? optString : optString2);
        gVar.b0(optString3);
        gVar.f0(optString4);
        gVar.c0(this.onBackPressedCallBack);
        gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.common.ECMsgBox$createAMsgBox$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                if (!optBoolean && optBoolean2) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("cancelDialog", true);
                    ECMsgBox.this.dialogCallback.onCallbackFinished(jSONObject3);
                }
                cg0.a.b("ECMsgBox", "[showMessageBox] leftBtnInfoUrl = " + jSONObject.optString("url"));
            }
        });
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.common.ECMsgBox$createAMsgBox$$inlined$apply$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                ECScheme.g(jSONObject2.optString("url"), null, 2, null);
                cg0.a.b("ECMsgBox", "[showMessageBox] rightBtnInfoUrl = " + jSONObject2.optString("url"));
            }
        });
    }
}

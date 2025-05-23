package com.tencent.mobileqq.wink.aiavatar.base;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ai.GenerateBtnStatusUpdateEvent;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.aigc.utils.WinkAIGCRequestUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import qshadow.ShadowAIGCStatus$GetStatusReply;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0013\u0010\u0006\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J$\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\u0004J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001c\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001f\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010%\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/base/WinkAIAvatarGenerateBtnViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "action", "", "R1", "Z1", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "X1", "c2", "Q1", "b2", "P1", "Landroid/content/Context;", "context", "", "openVipPayDialog", "Lkotlin/Function0;", "onShare", "O1", "W1", "T1", "", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "Lqshadow/ShadowAIGCStatus$GetStatusReply;", "i", "Landroidx/lifecycle/MutableLiveData;", "_generateBtnStatus", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "generateBtnStatus", BdhLogUtil.LogTag.Tag_Conn, "Z", "isSvipDialogPop", "()Z", "setSvipDialogPop", "(Z)V", "<init>", "()V", "D", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIAvatarGenerateBtnViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isSvipDialogPop;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<ShadowAIGCStatus$GetStatusReply> _generateBtnStatus;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<ShadowAIGCStatus$GetStatusReply> generateBtnStatus;

    public WinkAIAvatarGenerateBtnViewModel() {
        MutableLiveData<ShadowAIGCStatus$GetStatusReply> mutableLiveData = new MutableLiveData<>();
        this._generateBtnStatus = mutableLiveData;
        this.generateBtnStatus = mutableLiveData;
    }

    private final void R1(int action) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new WinkAIAvatarGenerateBtnViewModel$doGenerateBtnAction$1(action, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(WinkAIAvatarGenerateBtnViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.X1();
        this$0.isSvipDialogPop = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Z1(Continuation<? super Unit> continuation) {
        WinkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1 winkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1;
        Object coroutine_suspended;
        int i3;
        WinkAIAvatarGenerateBtnViewModel winkAIAvatarGenerateBtnViewModel;
        ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply;
        final ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply2;
        if (continuation instanceof WinkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1) {
            winkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1 = (WinkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1) continuation;
            int i16 = winkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        winkAIAvatarGenerateBtnViewModel = (WinkAIAvatarGenerateBtnViewModel) winkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    WinkAIGCRequestUtils winkAIGCRequestUtils = WinkAIGCRequestUtils.f317926a;
                    winkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1.L$0 = this;
                    winkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1.label = 1;
                    obj = winkAIGCRequestUtils.f("qzone_ai_avatar", 1, winkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    winkAIAvatarGenerateBtnViewModel = this;
                }
                shadowAIGCStatus$GetStatusReply = (ShadowAIGCStatus$GetStatusReply) obj;
                winkAIAvatarGenerateBtnViewModel._generateBtnStatus.postValue(shadowAIGCStatus$GetStatusReply);
                if (shadowAIGCStatus$GetStatusReply == null) {
                    shadowAIGCStatus$GetStatusReply2 = com.tencent.mobileqq.wink.request.a.a(shadowAIGCStatus$GetStatusReply);
                } else {
                    shadowAIGCStatus$GetStatusReply2 = null;
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.aiavatar.base.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkAIAvatarGenerateBtnViewModel.a2(ShadowAIGCStatus$GetStatusReply.this);
                    }
                });
                return Unit.INSTANCE;
            }
        }
        winkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1 = new WinkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1(this, continuation);
        Object obj2 = winkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1.label;
        if (i3 == 0) {
        }
        shadowAIGCStatus$GetStatusReply = (ShadowAIGCStatus$GetStatusReply) obj2;
        winkAIAvatarGenerateBtnViewModel._generateBtnStatus.postValue(shadowAIGCStatus$GetStatusReply);
        if (shadowAIGCStatus$GetStatusReply == null) {
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.aiavatar.base.e
            @Override // java.lang.Runnable
            public final void run() {
                WinkAIAvatarGenerateBtnViewModel.a2(ShadowAIGCStatus$GetStatusReply.this);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
        WinkAIAvatarUtils.f317678a.y(shadowAIGCStatus$GetStatusReply);
        if (shadowAIGCStatus$GetStatusReply != null) {
            SimpleEventBus.getInstance().dispatchEvent(new GenerateBtnStatusUpdateEvent(shadowAIGCStatus$GetStatusReply));
        }
    }

    public final boolean O1(@NotNull Context context, boolean openVipPayDialog, @NotNull Function0<Unit> onShare) {
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onShare, "onShare");
        ShadowAIGCStatus$GetStatusReply value = this.generateBtnStatus.getValue();
        boolean z19 = true;
        if (value != null && com.tencent.mobileqq.wink.request.a.f(value)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (com.tencent.mobileqq.wink.request.a.e(value).length() <= 0) {
                z19 = false;
            }
            if (z19) {
                QQToast.makeText(context, com.tencent.mobileqq.wink.request.a.e(value), 0).show();
            }
            return false;
        }
        if (value != null && com.tencent.mobileqq.wink.request.a.h(value)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            if (com.tencent.mobileqq.wink.request.a.e(value).length() <= 0) {
                z19 = false;
            }
            if (z19) {
                QQToast.makeText(context, com.tencent.mobileqq.wink.request.a.e(value), 0).show();
            }
            onShare.invoke();
            return false;
        }
        if (value != null && com.tencent.mobileqq.wink.request.a.j(value)) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z18) {
            return true;
        }
        if (openVipPayDialog) {
            W1(context);
        } else {
            QQToast.makeText(context, com.tencent.mobileqq.wink.request.a.e(value), 0).show();
        }
        return false;
    }

    public final void P1() {
        R1(3);
    }

    public final void Q1() {
        R1(1);
    }

    @NotNull
    public final LiveData<ShadowAIGCStatus$GetStatusReply> S1() {
        return this.generateBtnStatus;
    }

    public final void T1() {
        if (this.isSvipDialogPop && NetworkUtil.isNetworkAvailable()) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.aiavatar.base.f
                @Override // java.lang.Runnable
                public final void run() {
                    WinkAIAvatarGenerateBtnViewModel.U1(WinkAIAvatarGenerateBtnViewModel.this);
                }
            }, 300L);
        }
    }

    public final void W1(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ShadowAIGCStatus$GetStatusReply value = this.generateBtnStatus.getValue();
        boolean z16 = false;
        if (value != null && com.tencent.mobileqq.wink.request.a.j(value)) {
            z16 = true;
        }
        if (z16) {
            this.isSvipDialogPop = true;
            com.tencent.mobileqq.wink.f.l(context, com.tencent.mobileqq.wink.request.a.d(value));
        }
    }

    public final void X1() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new WinkAIAvatarGenerateBtnViewModel$requestGenerateBtnStatus$1(this, null), 3, null);
    }

    public final void b2() {
        R1(99);
    }

    public final void c2() {
        R1(2);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "WinkAIAvatarResultUIStateViewModel";
    }
}

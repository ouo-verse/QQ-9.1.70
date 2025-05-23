package com.tencent.qqnt.aio.assistedchat.aiservice;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.CompoundButton;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitch;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitchType;
import com.tencent.qqnt.aio.assistedchat.reply_suggestion.ReplySuggestionFrequencyHelper;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0013\u0010\u0006\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0016\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0014J@\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0016\u0010$\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030#\u0012\u0004\u0012\u00020\u00040\"R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00064"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/aiservice/AIServiceUtil;", "", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "I", "D", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Activity;", "", "dtPageId", "Landroid/content/DialogInterface$OnClickListener;", "onConfirm", "E", "key", ReportConstant.COSTREPORT_PREFIX, "", "iconType", "msg", "J", "B", "Lkotlinx/coroutines/CoroutineScope;", "scope", "L", "K", "chatType", "r", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "showIcon", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/widget/listitem/a;", "notifyChangedListener", "Lcom/tencent/qqnt/aio/assistedchat/aiservice/d;", "t", "Lmqq/util/WeakReference;", "Lcom/tencent/qqnt/aio/assistedchat/aiservice/AIServiceOpenInformDialog;", "b", "Lmqq/util/WeakReference;", "openInformDialogRef", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitch;", "c", "Lkotlin/Lazy;", "y", "()Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitch;", "aiServiceSwitch", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIServiceUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AIServiceUtil f349008a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<AIServiceOpenInformDialog> openInformDialogRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy aiServiceSwitch;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58287);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f349008a = new AIServiceUtil();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) AIServiceUtil$aiServiceSwitch$2.INSTANCE);
        aiServiceSwitch = lazy;
    }

    AIServiceUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean A() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || !peekAppRuntime.isLogin()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        List listOf;
        com.tencent.qqnt.aio.assistedchat.config.d f16 = com.tencent.qqnt.aio.assistedchat.config.a.INSTANCE.a().f();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 104, 119});
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            new ReplySuggestionFrequencyHelper(((Number) it.next()).intValue(), "", f16).l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        List listOf;
        QLog.d("AIServiceUtil", 1, "openSwitchAIService");
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.context, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.context, QMMKVFile.FILE_COMMON)");
        fromV2.putBoolean(s("ai_service_need_show_open_dialog"), false);
        IAssistedChatSwitchAdapterApi iAssistedChatSwitchAdapterApi = (IAssistedChatSwitchAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatSwitchAdapterApi.class);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(y());
        IAssistedChatSwitchAdapterApi.a.a(iAssistedChatSwitchAdapterApi, listOf, 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object D(Continuation<? super Unit> continuation) {
        String str;
        Continuation intercepted;
        List<AssistedChatSwitch> listOf;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        IAssistedChatSwitchAdapterApi iAssistedChatSwitchAdapterApi = (IAssistedChatSwitchAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatSwitchAdapterApi.class);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(f349008a.y());
        iAssistedChatSwitchAdapterApi.reqGetSwitch(str, listOf, new Function1<List<? extends com.tencent.qqnt.aio.assistedchat.model.d>, Unit>(cancellableContinuationImpl) { // from class: com.tencent.qqnt.aio.assistedchat.aiservice.AIServiceUtil$reqAIServiceSwitch$2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ CancellableContinuation<Object> $continuation;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$continuation = cancellableContinuationImpl;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuationImpl);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.qqnt.aio.assistedchat.model.d> list) {
                invoke2((List<com.tencent.qqnt.aio.assistedchat.model.d>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<com.tencent.qqnt.aio.assistedchat.model.d> items) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) items);
                } else {
                    Intrinsics.checkNotNullParameter(items, "items");
                    this.$continuation.resume(null, AnonymousClass1.INSTANCE);
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended2) {
            return result;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(Activity activity, final String dtPageId, final DialogInterface.OnClickListener onConfirm) {
        final Map mutableMapOf;
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            final String str = "em_bas_ai_assistant_close_pop";
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("dt_pgid", dtPageId), TuplesKt.to("dt_eid", "em_bas_ai_assistant_close_pop"));
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 0, "", "\u5173\u95ed\u540e\uff0c\u56de\u590d\u63a8\u8350\u7b49\u529f\u80fd\u5c06\u65e0\u6cd5\u4f7f\u7528\u3002", "\u53d6\u6d88", "\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.aiservice.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AIServiceUtil.G(onConfirm, mutableMapOf, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.aiservice.j
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AIServiceUtil.H(mutableMapOf, dialogInterface, i3);
                }
            });
            createCustomDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.qqnt.aio.assistedchat.aiservice.k
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    AIServiceUtil.F(dtPageId, str, mutableMapOf, dialogInterface);
                }
            });
            createCustomDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(String dtPageId, String elementId, Map reportParam, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dtPageId, "$dtPageId");
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        Intrinsics.checkNotNullParameter(reportParam, "$reportParam");
        VideoReport.setPageId(dialogInterface, dtPageId);
        VideoReport.setElementId(dialogInterface, elementId);
        VideoReport.reportEvent("dt_imp", dialogInterface, reportParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(DialogInterface.OnClickListener onConfirm, Map reportParam, DialogInterface dialogInterface, int i3) {
        Map mapOf;
        Map plus;
        Intrinsics.checkNotNullParameter(onConfirm, "$onConfirm");
        Intrinsics.checkNotNullParameter(reportParam, "$reportParam");
        onConfirm.onClick(dialogInterface, i3);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("click_type", "2"));
        VideoReport.setElementParams(dialogInterface, mapOf);
        plus = MapsKt__MapsKt.plus(reportParam, mapOf);
        VideoReport.reportEvent("dt_clck", dialogInterface, plus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Map reportParam, DialogInterface dialogInterface, int i3) {
        Map mapOf;
        Map plus;
        Intrinsics.checkNotNullParameter(reportParam, "$reportParam");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("click_type", "1"));
        VideoReport.setElementParams(dialogInterface, mapOf);
        plus = MapsKt__MapsKt.plus(reportParam, mapOf);
        VideoReport.reportEvent("dt_clck", dialogInterface, plus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(FragmentActivity activity) {
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            try {
                AIServiceOpenInformDialog aIServiceOpenInformDialog = new AIServiceOpenInformDialog(AIServiceUtil$showAIServiceOpenInformDialog$1.INSTANCE);
                openInformDialogRef = new WeakReference<>(aIServiceOpenInformDialog);
                FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
                aIServiceOpenInformDialog.Ch(supportFragmentManager, "AIServiceUtil");
                QLog.d("AIServiceUtil", 1, "showAIServiceOpenInformDialog");
                return;
            } catch (Exception e16) {
                QLog.w("AIServiceUtil", 1, "show dialog error ", e16);
                return;
            }
        }
        QLog.d("AIServiceUtil", 1, "unable to show dialog, because activity state is invalid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(int iconType, String msg2) {
        QQToast.makeText(BaseApplication.context, iconType, msg2, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String s(String key) {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        return key + "_" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(MutableLiveData clickSwitchLiveData, String dtPageId, CompoundButton compoundButton, boolean z16) {
        String str;
        Map mapOf;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(clickSwitchLiveData, "$clickSwitchLiveData");
        Intrinsics.checkNotNullParameter(dtPageId, "$dtPageId");
        clickSwitchLiveData.setValue(Boolean.valueOf(z16));
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("dt_pgid", dtPageId);
        pairArr[1] = TuplesKt.to("dt_eid", "em_bas_ai_assistant_btn");
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        pairArr[2] = TuplesKt.to("current_state", str);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        VideoReport.reportEvent("dt_clck", mapOf);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(Ref.BooleanRef hasOnBind, String dtPageId, d config, View it) {
        String str;
        Map mapOf;
        Intrinsics.checkNotNullParameter(hasOnBind, "$hasOnBind");
        Intrinsics.checkNotNullParameter(dtPageId, "$dtPageId");
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(it, "it");
        if (hasOnBind.element) {
            return;
        }
        hasOnBind.element = true;
        VideoReport.setElementExposePolicy(it, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(it, ClickPolicy.REPORT_NONE);
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("dt_pgid", dtPageId);
        pairArr[1] = TuplesKt.to("dt_eid", "em_bas_ai_assistant_btn");
        if (config.M()) {
            str = "1";
        } else {
            str = "2";
        }
        pairArr[2] = TuplesKt.to("current_state", str);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        VideoReport.reportEvent("dt_imp", mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AssistedChatSwitch y() {
        return (AssistedChatSwitch) aiServiceSwitch.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean z() {
        List listOf;
        IAssistedChatAdapterApi iAssistedChatAdapterApi = (IAssistedChatAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatAdapterApi.class);
        if (!iAssistedChatAdapterApi.isReplySuggestionExperiment(1)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{104, 119});
            Iterator it = listOf.iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                if (iAssistedChatAdapterApi.isReplySuggestionExperiment(intValue)) {
                    MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.context, "common_mmkv_configurations");
                    Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.context, QMMKVFile.FILE_COMMON)");
                    if (fromV2.getBoolean(f349008a.s("ai_service_exp_activate" + intValue), false)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void K() {
        AIServiceOpenInformDialog aIServiceOpenInformDialog;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        WeakReference<AIServiceOpenInformDialog> weakReference = openInformDialogRef;
        if (weakReference != null && (aIServiceOpenInformDialog = weakReference.get()) != null) {
            aIServiceOpenInformDialog.dismiss();
        }
        WeakReference<AIServiceOpenInformDialog> weakReference2 = openInformDialogRef;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        openInformDialogRef = null;
    }

    public final void L(@NotNull FragmentActivity activity, @NotNull CoroutineScope scope) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) scope);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scope, "scope");
        BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), null, new AIServiceUtil$tryToShowAIServiceDialog$1(new WeakReference(activity), null), 2, null);
    }

    public final void r(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, chatType);
            return;
        }
        if (!((IAssistedChatAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatAdapterApi.class)).isReplySuggestionExperiment(chatType)) {
            return;
        }
        QLog.d("AIServiceUtil", 1, "activateAIServiceExperiment chatType=" + chatType);
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.context, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.context, QMMKVFile.FILE_COMMON)");
        fromV2.putBoolean(s("ai_service_exp_activate" + chatType), true);
    }

    @Nullable
    public final d t(@NotNull Activity activity, @NotNull LifecycleOwner lifecycleOwner, boolean showIcon, @NotNull final String dtPageId, @NotNull final Function1<? super com.tencent.mobileqq.widget.listitem.a<?>, Unit> notifyChangedListener) {
        String str;
        List<AssistedChatSwitch> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (d) iPatchRedirector.redirect((short) 5, this, activity, lifecycleOwner, Boolean.valueOf(showIcon), dtPageId, notifyChangedListener);
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(dtPageId, "dtPageId");
        Intrinsics.checkNotNullParameter(notifyChangedListener, "notifyChangedListener");
        if (!z()) {
            return null;
        }
        IAssistedChatSwitchAdapterApi iAssistedChatSwitchAdapterApi = (IAssistedChatSwitchAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatSwitchAdapterApi.class);
        AssistedChatSwitch assistedChatSwitch = new AssistedChatSwitch(AssistedChatSwitchType.AI_SERVICE, 0);
        final MutableLiveData mutableLiveData = new MutableLiveData();
        final MutableLiveData mutableLiveData2 = new MutableLiveData();
        final d dVar = new d(iAssistedChatSwitchAdapterApi.isSwitchOn(assistedChatSwitch), showIcon, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.qqnt.aio.assistedchat.aiservice.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                AIServiceUtil.u(MutableLiveData.this, dtPageId, compoundButton, z16);
            }
        });
        final AIServiceUtil$getAIServiceSettingConfig$2$1 aIServiceUtil$getAIServiceSettingConfig$2$1 = new AIServiceUtil$getAIServiceSettingConfig$2$1(activity, dVar, notifyChangedListener, dtPageId, iAssistedChatSwitchAdapterApi, assistedChatSwitch);
        mutableLiveData2.observe(lifecycleOwner, new Observer() { // from class: com.tencent.qqnt.aio.assistedchat.aiservice.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AIServiceUtil.v(Function1.this, obj);
            }
        });
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>(notifyChangedListener) { // from class: com.tencent.qqnt.aio.assistedchat.aiservice.AIServiceUtil$getAIServiceSettingConfig$2$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function1<com.tencent.mobileqq.widget.listitem.a<?>, Unit> $notifyChangedListener;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.$notifyChangedListener = notifyChangedListener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) d.this, (Object) notifyChangedListener);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isChecked) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) isChecked);
                } else {
                    if (Intrinsics.areEqual(Boolean.valueOf(d.this.M()), isChecked)) {
                        return;
                    }
                    d dVar2 = d.this;
                    Intrinsics.checkNotNullExpressionValue(isChecked, "isChecked");
                    dVar2.R(isChecked.booleanValue());
                    this.$notifyChangedListener.invoke(d.this);
                }
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.qqnt.aio.assistedchat.aiservice.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AIServiceUtil.w(Function1.this, obj);
            }
        });
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "MobileQQ.sMobileQQ.peekA\u2026?.currentAccountUin ?: \"\"");
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(assistedChatSwitch);
        iAssistedChatSwitchAdapterApi.reqGetSwitch(str, listOf, new Function1<List<? extends com.tencent.qqnt.aio.assistedchat.model.d>, Unit>(mutableLiveData) { // from class: com.tencent.qqnt.aio.assistedchat.aiservice.AIServiceUtil$getAIServiceSettingConfig$2$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ MutableLiveData<Boolean> $refreshSwitchLiveData;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$refreshSwitchLiveData = mutableLiveData;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mutableLiveData);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.qqnt.aio.assistedchat.model.d> list) {
                invoke2((List<com.tencent.qqnt.aio.assistedchat.model.d>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<com.tencent.qqnt.aio.assistedchat.model.d> it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.isEmpty()) {
                    return;
                }
                this.$refreshSwitchLiveData.postValue(Boolean.valueOf(it.get(0).b()));
            }
        });
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        dVar.S(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.qqnt.aio.assistedchat.aiservice.h
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                AIServiceUtil.x(Ref.BooleanRef.this, dtPageId, dVar, view);
            }
        });
        return dVar;
    }
}

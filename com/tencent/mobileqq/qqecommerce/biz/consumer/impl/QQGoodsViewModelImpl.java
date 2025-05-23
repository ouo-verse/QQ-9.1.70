package com.tencent.mobileqq.qqecommerce.biz.consumer.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.ecommerce.base.router.api.IECLogicCallback;
import com.tencent.ecommerce.biz.consumer.ui.api.IECGoodsViewModel;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqecommerce.biz.consumer.api.IQQGoodsViewModel;
import com.tencent.mobileqq.qqecommerce.biz.consumer.impl.QQGoodsViewModelImpl;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.impl.QQECommerceSdkImpl;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import lh0.c;
import lh0.d;
import mqq.util.WeakReference;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 *2\u00020\u0001:\u0001 By\u0012\u0006\u00102\u001a\u00020\u0002\u0012\u0006\u00103\u001a\u00020\u0016\u0012\b\u00104\u001a\u0004\u0018\u00010\u0002\u0012\b\u00105\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u00106\u001a\u00020\u0016\u0012\u0006\u00107\u001a\u00020\u0016\u0012\b\u00108\u001a\u0004\u0018\u00010\u0002\u0012\b\u00109\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010;\u001a\u00020\u0016\u0012\u0006\u0010<\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010=\u001a\u00020\u0012\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0016H\u0016R$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u00101\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b.\u00100\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/consumer/impl/QQGoodsViewModelImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/consumer/api/IQQGoodsViewModel;", "", "url", "", h.F, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "i", "Landroid/os/Message;", "msg", "Landroid/view/ViewGroup;", "e", "wrapperView", "bigWrapperView", "setWrapperView", "viewGroup", "setTopWrapperView", "", "isContinuation", "onWrapperViewAppear", "onWrapperViewDisappear", "", "progress", "duration", "onVideoProgressChange", "action", "Lorg/json/JSONObject;", "params", "sendTopViewEvent", "sendXingHuanCardEvent", "Lcom/tencent/ecommerce/biz/consumer/ui/api/IECGoodsViewModel;", "a", "Lcom/tencent/ecommerce/biz/consumer/ui/api/IECGoodsViewModel;", "f", "()Lcom/tencent/ecommerce/biz/consumer/ui/api/IECGoodsViewModel;", "k", "(Lcom/tencent/ecommerce/biz/consumer/ui/api/IECGoodsViewModel;)V", "viewModel", "Ljava/util/ArrayDeque;", "b", "Ljava/util/ArrayDeque;", "d", "()Ljava/util/ArrayDeque;", "msgQueue", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "()Landroid/os/Handler;", "handler", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "businessId", "businessScene", "contentId", "contentScene", "videoIndex", "authorUin", "sealTransfer", "traceId", "pageId", "fromPageId", "isTopViewPreload", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZ)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQGoodsViewModelImpl implements IQQGoodsViewModel {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private IECGoodsViewModel viewModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ArrayDeque<Message> msgQueue;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/consumer/impl/QQGoodsViewModelImpl$1", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "onResult", "", "result", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.consumer.impl.QQGoodsViewModelImpl$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    public static final class AnonymousClass1 implements IECLogicCallback {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(final QQGoodsViewModelImpl this$0, HashMap result) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(result, "$result");
            Object obj = result.get("PARAM_VIEW_MODEL_OBJECT");
            this$0.k(obj instanceof IECGoodsViewModel ? (IECGoodsViewModel) obj : null);
            IECGoodsViewModel viewModel = this$0.getViewModel();
            if (viewModel != null) {
                viewModel.addJumpLisenter(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.consumer.impl.QQGoodsViewModelImpl$1$onResult$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String url) {
                        Intrinsics.checkNotNullParameter(url, "url");
                        QQGoodsViewModelImpl.this.h(url);
                    }
                });
            }
            Iterator<T> it = this$0.d().iterator();
            while (it.hasNext()) {
                this$0.getHandler().sendMessage((Message) it.next());
            }
        }

        @Override // com.tencent.ecommerce.base.router.api.IECLogicCallback
        public void onResult(final HashMap<String, Object> result) {
            Intrinsics.checkNotNullParameter(result, "result");
            Handler handler = QQGoodsViewModelImpl.this.getHandler();
            final QQGoodsViewModelImpl qQGoodsViewModelImpl = QQGoodsViewModelImpl.this;
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.consumer.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    QQGoodsViewModelImpl.AnonymousClass1.b(QQGoodsViewModelImpl.this, result);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0094\u0001\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0012j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fR\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/consumer/impl/QQGoodsViewModelImpl$a;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "", "businessId", "businessScene", "contentId", "contentScene", "videoIndex", "authorUin", "sealTransfer", "traceId", "pageId", "fromPageId", "", "isContinuation", "isTopViewPreload", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "MSG_ON_APPEAR", "I", "MSG_ON_DISAPPEAR", "MSG_ON_VIDEO_PROGRESS_CHANGE", "MSG_SET_TOP", "MSG_SET_TOP_VIEW_EVENT", "MSG_SET_WRAPPER", "MSG_XING_HUAN_CARD_EVENT", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.consumer.impl.QQGoodsViewModelImpl$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HashMap<String, String> a(String uniqueId, int businessId, String businessScene, String contentId, int contentScene, int videoIndex, String authorUin, String sealTransfer, String traceId, int pageId, String fromPageId, boolean isContinuation, boolean isTopViewPreload) {
            HashMap<String, String> hashMapOf;
            Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
            Intrinsics.checkNotNullParameter(fromPageId, "fromPageId");
            Pair[] pairArr = new Pair[13];
            pairArr[0] = new Pair("PARAM_UNIQUE_ID", uniqueId);
            pairArr[1] = new Pair("PARAM_BUSINESS_ID", String.valueOf(businessId));
            pairArr[2] = new Pair("PARAM_BUSINESS_SCENE", businessScene == null ? "" : businessScene);
            pairArr[3] = new Pair("PARAM_CONTENT_ID", contentId == null ? "" : contentId);
            pairArr[4] = new Pair("PARAM_CONTENT_SCENE", String.valueOf(contentScene));
            pairArr[5] = new Pair("PARAM_VIDEO_INDEX", String.valueOf(videoIndex));
            pairArr[6] = new Pair("PARAM_AUTHOR_UIN", authorUin == null ? "" : authorUin);
            pairArr[7] = new Pair("PARAM_SEAL_TRANSFER", sealTransfer == null ? "" : sealTransfer);
            pairArr[8] = new Pair("PARAM_TRACE_ID", traceId != null ? traceId : "");
            pairArr[9] = new Pair("PARAM_PAGE_ID", String.valueOf(pageId));
            pairArr[10] = new Pair("PARAM_SOURCE_FROM", fromPageId);
            pairArr[11] = new Pair("PARAM_IS_CONTINUATION", String.valueOf(isContinuation));
            pairArr[12] = new Pair("PARAM_IS_TOP_VIEW_PRELOAD", String.valueOf(isTopViewPreload));
            hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
            return hashMapOf;
        }

        Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ViewGroup e(Message msg2) {
        Object obj = msg2.obj;
        WeakReference weakReference = obj instanceof WeakReference ? (WeakReference) obj : null;
        if (weakReference != null) {
            return (ViewGroup) weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0010. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean g(QQGoodsViewModelImpl this$0, Message msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        switch (msg2.what) {
            case 1:
                Object obj = msg2.obj;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.ArrayList<mqq.util.WeakReference<android.view.ViewGroup>>{ kotlin.collections.TypeAliasesKt.ArrayList<mqq.util.WeakReference<android.view.ViewGroup>> }");
                ArrayList arrayList = (ArrayList) obj;
                ViewGroup viewGroup = (ViewGroup) ((WeakReference) arrayList.get(0)).get();
                ViewGroup viewGroup2 = arrayList.size() > 1 ? (ViewGroup) ((WeakReference) arrayList.get(1)).get() : null;
                if (viewGroup != null) {
                    this$0.setWrapperView(viewGroup, viewGroup2);
                }
                return true;
            case 2:
                ViewGroup e16 = this$0.e(msg2);
                if (e16 != null) {
                    this$0.setTopWrapperView(e16);
                }
                return true;
            case 3:
                Object obj2 = msg2.obj;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                this$0.onWrapperViewAppear(((Boolean) obj2).booleanValue());
                return true;
            case 4:
                this$0.onWrapperViewDisappear();
                return true;
            case 5:
                Object obj3 = msg2.obj;
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.tencent.ecommerce.biz.consumer.event.ECVideoEvent");
                c cVar = (c) obj3;
                this$0.onVideoProgressChange(cVar.getCom.tencent.mobileqq.tritonaudio.InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME java.lang.String(), cVar.getDuration());
                return true;
            case 6:
                Object obj4 = msg2.obj;
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.tencent.ecommerce.biz.consumer.event.ECTopViewEvent");
                lh0.b bVar = (lh0.b) obj4;
                this$0.sendTopViewEvent(bVar.getAction(), bVar.getParams());
                return true;
            case 7:
                QLog.d("QQGoodsViewModelImpl", 1, "sendXingHuanCardEvent from handler");
                Object obj5 = msg2.obj;
                Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type com.tencent.ecommerce.biz.consumer.event.ECXingHuanEvent");
                this$0.sendXingHuanCardEvent(((d) obj5).getAction());
                return true;
            default:
                return false;
        }
    }

    private final void i(Activity activity, String url) {
        Intent intent = new Intent(activity, (Class<?>) PreloadWebService.class);
        if (!TextUtils.isEmpty(url)) {
            intent.putExtra("url", url);
        }
        activity.startService(intent);
    }

    /* renamed from: c, reason: from getter */
    public final Handler getHandler() {
        return this.handler;
    }

    public final ArrayDeque<Message> d() {
        return this.msgQueue;
    }

    /* renamed from: f, reason: from getter */
    public final IECGoodsViewModel getViewModel() {
        return this.viewModel;
    }

    public final void k(IECGoodsViewModel iECGoodsViewModel) {
        this.viewModel = iECGoodsViewModel;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.consumer.api.IQQGoodsViewModel
    public void onVideoProgressChange(int progress, int duration) {
        IECGoodsViewModel iECGoodsViewModel = this.viewModel;
        if (iECGoodsViewModel != null) {
            iECGoodsViewModel.sendEvent(new c(progress, duration));
            return;
        }
        Message obtainMessage = this.handler.obtainMessage(5);
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "handler.obtainMessage(MS\u2026ON_VIDEO_PROGRESS_CHANGE)");
        obtainMessage.obj = new c(progress, duration);
        this.msgQueue.addLast(obtainMessage);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.consumer.api.IQQGoodsViewModel
    public void onWrapperViewAppear(boolean isContinuation) {
        IECGoodsViewModel iECGoodsViewModel = this.viewModel;
        if (iECGoodsViewModel != null) {
            iECGoodsViewModel.onWrapperViewAppear(isContinuation);
        } else {
            Message obtainMessage = this.handler.obtainMessage(3);
            Intrinsics.checkNotNullExpressionValue(obtainMessage, "handler.obtainMessage(MSG_ON_APPEAR)");
            obtainMessage.obj = Boolean.valueOf(isContinuation);
            this.msgQueue.addLast(obtainMessage);
        }
        try {
            QBaseActivity sTopActivity = QBaseActivity.sTopActivity;
            Intrinsics.checkNotNullExpressionValue(sTopActivity, "sTopActivity");
            j(this, sTopActivity, null, 2, null);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("QQGoodsViewModelImpl", 2, "preloadWebview, error=", th5);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.consumer.api.IQQGoodsViewModel
    public void onWrapperViewDisappear() {
        IECGoodsViewModel iECGoodsViewModel = this.viewModel;
        if (iECGoodsViewModel != null) {
            iECGoodsViewModel.onWrapperViewDisappear();
            return;
        }
        Message obtainMessage = this.handler.obtainMessage(4);
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "handler.obtainMessage(MSG_ON_DISAPPEAR)");
        this.msgQueue.addLast(obtainMessage);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.consumer.api.IQQGoodsViewModel
    public void sendTopViewEvent(int action, JSONObject params) {
        Intrinsics.checkNotNullParameter(params, "params");
        IECGoodsViewModel iECGoodsViewModel = this.viewModel;
        if (iECGoodsViewModel != null) {
            iECGoodsViewModel.sendEvent(new lh0.b(action, params));
            return;
        }
        Message obtainMessage = this.handler.obtainMessage(6);
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "handler.obtainMessage(MSG_SET_TOP_VIEW_EVENT)");
        obtainMessage.obj = new lh0.b(action, params);
        this.msgQueue.addLast(obtainMessage);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.consumer.api.IQQGoodsViewModel
    public void sendXingHuanCardEvent(int action) {
        IECGoodsViewModel iECGoodsViewModel = this.viewModel;
        if (iECGoodsViewModel != null) {
            iECGoodsViewModel.sendEvent(new d(action));
            return;
        }
        Message obtainMessage = this.handler.obtainMessage(7);
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "handler.obtainMessage(MSG_XING_HUAN_CARD_EVENT)");
        obtainMessage.obj = new d(action);
        this.msgQueue.addLast(obtainMessage);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.consumer.api.IQQGoodsViewModel
    public void setTopWrapperView(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        IECGoodsViewModel iECGoodsViewModel = this.viewModel;
        if (iECGoodsViewModel != null) {
            iECGoodsViewModel.setTopWrapperView(viewGroup);
            return;
        }
        Message obtainMessage = this.handler.obtainMessage(2);
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "handler.obtainMessage(MSG_SET_TOP)");
        obtainMessage.obj = new WeakReference(viewGroup);
        this.msgQueue.addLast(obtainMessage);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.consumer.api.IQQGoodsViewModel
    public void setWrapperView(ViewGroup wrapperView, ViewGroup bigWrapperView) {
        Intrinsics.checkNotNullParameter(wrapperView, "wrapperView");
        IECGoodsViewModel iECGoodsViewModel = this.viewModel;
        if (iECGoodsViewModel != null) {
            iECGoodsViewModel.setWrapperView(wrapperView, bigWrapperView);
            return;
        }
        Message obtainMessage = this.handler.obtainMessage(1);
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "handler.obtainMessage(MSG_SET_WRAPPER)");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new WeakReference(wrapperView));
        if (bigWrapperView != null) {
            arrayList.add(new WeakReference(bigWrapperView));
        }
        obtainMessage.obj = arrayList;
        this.msgQueue.addLast(obtainMessage);
    }

    public QQGoodsViewModelImpl(String uniqueId, int i3, String str, String str2, int i16, int i17, String str3, String str4, String str5, int i18, String fromPageId, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fromPageId, "fromPageId");
        this.msgQueue = new ArrayDeque<>();
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.mobileqq.qqecommerce.biz.consumer.impl.a
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean g16;
                g16 = QQGoodsViewModelImpl.g(QQGoodsViewModelImpl.this, message);
                return g16;
            }
        });
        if (!QQECommerceSdkImpl.INSTANCE.b()) {
            QLog.e("QQGoodsViewModelImpl", 2, "QQGoodsViewModelImpl: \u5f53\u524d\u65b9\u6cd5\u53ea\u652f\u6301\u5728\u4e3b\u8fdb\u7a0b\u8c03\u7528\uff0c\u8bf7\u5148\u4f7f\u7528QIPC\u8f6c\u5316\u8fdb\u7a0b");
        } else {
            af2.d.f26007a.a(117, INSTANCE.a(uniqueId, i3, str, str2, i16, i17, str3, str4, str5, i18, fromPageId, z16, z17), new AnonymousClass1());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String url) {
        boolean contains$default;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "mqqapi://ecommerce/open?target=59", false, 2, (Object) null);
        if (contains$default) {
            QCirclePluginUtil.setIsECFloatWebViewOnShow(true);
        }
    }

    static /* synthetic */ void j(QQGoodsViewModelImpl qQGoodsViewModelImpl, Activity activity, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        qQGoodsViewModelImpl.i(activity, str);
    }
}

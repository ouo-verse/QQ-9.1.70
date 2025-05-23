package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.router.api.IECLogicCallback;
import com.tencent.ecommerce.biz.hr.api.IECHRViewModel;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 B2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010#\u001a\u00020\u0007\u00a2\u0006\u0004\b@\u0010AJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J6\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u001e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0002J6\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J$\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00072\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tH\u0016R\u001a\u0010#\u001a\u00020\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020-0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R0\u0010:\u001a\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u0004\u0018\u000105j\u0004\u0018\u0001`78\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109RX\u0010?\u001a\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u0004\u0018\u000105j\u0004\u0018\u0001`72 \u0010;\u001a\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u0004\u0018\u000105j\u0004\u0018\u0001`78V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b<\u0010=\"\u0004\b\u001f\u0010>\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/QQHRViewModelImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/e;", "Landroid/content/Context;", "context", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "", "pageName", "", "", "params", "Landroid/util/Size;", "size", DomainData.DOMAIN_NAME, "Landroid/view/View;", "ecHrView", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "msg", "Lkotlin/Function0;", "pendingTask", "r", "onCreate", DKHippyEvent.EVENT_STOP, "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, AdMetricTag.EVENT_NAME, "data", "sendEvent", "a", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "scene", "Landroid/widget/FrameLayout;", "b", "Landroid/widget/FrameLayout;", "qqHrViewWrapper", "Lcom/tencent/ecommerce/biz/hr/api/IECHRViewModel;", "c", "Lcom/tencent/ecommerce/biz/hr/api/IECHRViewModel;", "ecHRViewModel", "Ljava/util/ArrayDeque;", "Landroid/os/Message;", "d", "Ljava/util/ArrayDeque;", "msgQueue", "Landroid/os/Handler;", "e", "Landroid/os/Handler;", "handler", "Lkotlin/Function2;", "Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/QQECHRViewEventCallback;", "f", "Lkotlin/jvm/functions/Function2;", "_hrEventCallback", "value", "getHrEventCallback", "()Lkotlin/jvm/functions/Function2;", "(Lkotlin/jvm/functions/Function2;)V", "hrEventCallback", "<init>", "(Ljava/lang/String;)V", "g", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQHRViewModelImpl implements com.tencent.mobileqq.qqecommerce.biz.hr.api.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String scene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private FrameLayout qqHrViewWrapper;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private IECHRViewModel ecHRViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ArrayDeque<Message> msgQueue;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function2<? super String, ? super JSONObject, Unit> _hrEventCallback;

    public QQHRViewModelImpl(String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.scene = scene;
        this.msgQueue = new ArrayDeque<>();
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.c
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean l3;
                l3 = QQHRViewModelImpl.l(QQHRViewModelImpl.this, message);
                return l3;
            }
        });
        af2.d.f26007a.a(124, new HashMap<>(), new IECLogicCallback() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.QQHRViewModelImpl.1
            @Override // com.tencent.ecommerce.base.router.api.IECLogicCallback
            public void onResult(HashMap<String, Object> result) {
                Intrinsics.checkNotNullParameter(result, "result");
                QQHRViewModelImpl qQHRViewModelImpl = QQHRViewModelImpl.this;
                Object obj = result.get("PARAM_HR_VIEW_MODEL_OBJECT");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.ecommerce.biz.hr.api.IECHRViewModel");
                qQHRViewModelImpl.ecHRViewModel = (IECHRViewModel) obj;
                IECHRViewModel iECHRViewModel = QQHRViewModelImpl.this.ecHRViewModel;
                if (iECHRViewModel != null) {
                    final QQHRViewModelImpl qQHRViewModelImpl2 = QQHRViewModelImpl.this;
                    iECHRViewModel.setEventCallback(new Function2<String, JSONObject, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.QQHRViewModelImpl$1$onResult$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(String str, JSONObject jSONObject) {
                            invoke2(str, jSONObject);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String eventName, JSONObject data) {
                            Function2 function2;
                            Intrinsics.checkNotNullParameter(eventName, "eventName");
                            Intrinsics.checkNotNullParameter(data, "data");
                            function2 = QQHRViewModelImpl.this._hrEventCallback;
                            if (function2 != null) {
                                function2.invoke(eventName, data);
                            }
                        }
                    });
                }
                QQHRViewModelImpl.this.q();
            }
        });
    }

    private final void j(View ecHrView) {
        ecHrView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = this.qqHrViewWrapper;
        if (frameLayout != null) {
            frameLayout.addView(ecHrView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(QQHRViewModelImpl this$0, Message msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 == 1) {
            int hashCode = this$0.hashCode();
            IECHRViewModel iECHRViewModel = this$0.ecHRViewModel;
            int hashCode2 = iECHRViewModel != null ? iECHRViewModel.hashCode() : 0;
            QLog.i("QQHRViewModelImpl", 1, "run onCreate msg: hashCode: " + hashCode + ", " + hashCode2 + ", scene: " + this$0.getScene());
            Object obj = msg2.obj;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function0<kotlin.Unit>");
            ((Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 0)).invoke();
        } else if (i3 == 2) {
            int hashCode3 = this$0.hashCode();
            IECHRViewModel iECHRViewModel2 = this$0.ecHRViewModel;
            int hashCode4 = iECHRViewModel2 != null ? iECHRViewModel2.hashCode() : 0;
            QLog.i("QQHRViewModelImpl", 1, "run onResume msg: hashCode: " + hashCode3 + ", " + hashCode4 + ", scene: " + this$0.getScene());
            Object obj2 = msg2.obj;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Function0<kotlin.Unit>");
            ((Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj2, 0)).invoke();
        } else if (i3 == 3) {
            int hashCode5 = this$0.hashCode();
            IECHRViewModel iECHRViewModel3 = this$0.ecHRViewModel;
            int hashCode6 = iECHRViewModel3 != null ? iECHRViewModel3.hashCode() : 0;
            QLog.i("QQHRViewModelImpl", 1, "run onStop msg: hashCode: " + hashCode5 + ", " + hashCode6 + ", scene: " + this$0.getScene());
            Object obj3 = msg2.obj;
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Function0<kotlin.Unit>");
            ((Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj3, 0)).invoke();
        } else if (i3 == 4) {
            int hashCode7 = this$0.hashCode();
            IECHRViewModel iECHRViewModel4 = this$0.ecHRViewModel;
            int hashCode8 = iECHRViewModel4 != null ? iECHRViewModel4.hashCode() : 0;
            QLog.i("QQHRViewModelImpl", 1, "run onDestroy msg: hashCode: " + hashCode7 + ", " + hashCode8 + ", scene: " + this$0.getScene());
            Object obj4 = msg2.obj;
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Function0<kotlin.Unit>");
            ((Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj4, 0)).invoke();
        } else {
            if (i3 != 5) {
                return false;
            }
            int hashCode9 = this$0.hashCode();
            IECHRViewModel iECHRViewModel5 = this$0.ecHRViewModel;
            int hashCode10 = iECHRViewModel5 != null ? iECHRViewModel5.hashCode() : 0;
            QLog.i("QQHRViewModelImpl", 1, "run senEvent msg: hashCode: " + hashCode9 + ", " + hashCode10 + ", scene: " + this$0.getScene());
            Object obj5 = msg2.obj;
            Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Function0<kotlin.Unit>");
            ((Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj5, 0)).invoke();
        }
        return true;
    }

    private final void m(Context context) {
        if (this.qqHrViewWrapper == null) {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setClipChildren(false);
            this.qqHrViewWrapper = frameLayout;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(Context context, String pageName, Map<String, ? extends Object> params, Size size) {
        View onCreate;
        IECHRViewModel iECHRViewModel = this.ecHRViewModel;
        if (iECHRViewModel == null || (onCreate = iECHRViewModel.onCreate(context, pageName, params, size)) == null) {
            return;
        }
        j(onCreate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        final FrameLayout frameLayout = this.qqHrViewWrapper;
        if (frameLayout != null) {
            IECHRViewModel iECHRViewModel = this.ecHRViewModel;
            if (iECHRViewModel != null) {
                iECHRViewModel.onDestroy();
            }
            frameLayout.setVisibility(8);
            frameLayout.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.d
                @Override // java.lang.Runnable
                public final void run() {
                    QQHRViewModelImpl.p(QQHRViewModelImpl.this, frameLayout);
                }
            }, 500L);
            return;
        }
        IECHRViewModel iECHRViewModel2 = this.ecHRViewModel;
        if (iECHRViewModel2 != null) {
            iECHRViewModel2.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(QQHRViewModelImpl this$0, FrameLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        int hashCode = this$0.hashCode();
        IECHRViewModel iECHRViewModel = this$0.ecHRViewModel;
        Integer valueOf = iECHRViewModel != null ? Integer.valueOf(iECHRViewModel.hashCode()) : null;
        QLog.i("QQHRViewModelImpl", 1, "hashCode: " + hashCode + ", hrViewModel: " + valueOf + ", scene: " + this$0.getScene() + ", did destroy hrViewModel");
        ViewExtKt.a(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        Iterator<T> it = this.msgQueue.iterator();
        while (it.hasNext()) {
            this.handler.sendMessage((Message) it.next());
        }
        this.msgQueue.clear();
    }

    private final void r(int msg2, Function0<Unit> pendingTask) {
        Message obtainMessage = this.handler.obtainMessage(msg2);
        obtainMessage.obj = pendingTask;
        this.msgQueue.addLast(obtainMessage);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.e
    public void a(Function2<? super String, ? super JSONObject, Unit> function2) {
        this._hrEventCallback = function2;
    }

    /* renamed from: k, reason: from getter */
    public String getScene() {
        return this.scene;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.e
    public View onCreate(final Context context, final String pageName, final Map<String, ? extends Object> params, final Size size) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(params, "params");
        int hashCode = hashCode();
        IECHRViewModel iECHRViewModel = this.ecHRViewModel;
        Integer valueOf = iECHRViewModel != null ? Integer.valueOf(iECHRViewModel.hashCode()) : null;
        QLog.i("QQHRViewModelImpl", 1, "QQHRViewModel onCreate, " + hashCode + ", hrViewModel: " + valueOf + ", scene: " + getScene());
        m(context);
        if (this.ecHRViewModel != null) {
            n(context, pageName, params, size);
        } else {
            r(1, new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.QQHRViewModelImpl$onCreate$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QQHRViewModelImpl.this.n(context, pageName, params, size);
                }
            });
        }
        FrameLayout frameLayout = this.qqHrViewWrapper;
        Intrinsics.checkNotNull(frameLayout);
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.e
    public void onDestroy() {
        int hashCode = hashCode();
        IECHRViewModel iECHRViewModel = this.ecHRViewModel;
        Integer valueOf = iECHRViewModel != null ? Integer.valueOf(iECHRViewModel.hashCode()) : null;
        QLog.i("QQHRViewModelImpl", 1, "QQHRViewModel onDestroy, hashCode: " + hashCode + ", hrViewModel: " + valueOf + ", scene: " + getScene());
        if (this.ecHRViewModel != null) {
            o();
        } else {
            r(4, new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.QQHRViewModelImpl$onDestroy$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QQHRViewModelImpl.this.o();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.e
    public void onResume() {
        int hashCode = hashCode();
        IECHRViewModel iECHRViewModel = this.ecHRViewModel;
        QLog.i("QQHRViewModelImpl", 1, "QQHRViewModel onResume, hashCode: " + hashCode + ", hrViewModel: " + (iECHRViewModel != null ? Integer.valueOf(iECHRViewModel.hashCode()) : null));
        IECHRViewModel iECHRViewModel2 = this.ecHRViewModel;
        if (iECHRViewModel2 != null) {
            iECHRViewModel2.onResume();
        } else {
            r(2, new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.QQHRViewModelImpl$onResume$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IECHRViewModel iECHRViewModel3 = QQHRViewModelImpl.this.ecHRViewModel;
                    if (iECHRViewModel3 != null) {
                        iECHRViewModel3.onResume();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.e
    public void onStop() {
        int hashCode = hashCode();
        IECHRViewModel iECHRViewModel = this.ecHRViewModel;
        Integer valueOf = iECHRViewModel != null ? Integer.valueOf(iECHRViewModel.hashCode()) : null;
        QLog.i("QQHRViewModelImpl", 1, "QQHRViewModel onStop, hashCode: " + hashCode + ", hrViewModel: " + valueOf + ", scene: " + getScene());
        IECHRViewModel iECHRViewModel2 = this.ecHRViewModel;
        if (iECHRViewModel2 != null) {
            iECHRViewModel2.onStop();
        } else {
            r(3, new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.QQHRViewModelImpl$onStop$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IECHRViewModel iECHRViewModel3 = QQHRViewModelImpl.this.ecHRViewModel;
                    if (iECHRViewModel3 != null) {
                        iECHRViewModel3.onStop();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.e
    public void sendEvent(final String eventName, final Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(data, "data");
        int hashCode = hashCode();
        IECHRViewModel iECHRViewModel = this.ecHRViewModel;
        Integer valueOf = iECHRViewModel != null ? Integer.valueOf(iECHRViewModel.hashCode()) : null;
        QLog.i("QQHRViewModelImpl", 1, "QQHRViewModel sendEvent: " + eventName + ", hashCode: " + hashCode + ", hrViewModel: " + valueOf + ", scene: " + getScene());
        IECHRViewModel iECHRViewModel2 = this.ecHRViewModel;
        if (iECHRViewModel2 != null) {
            iECHRViewModel2.sendEvent(eventName, data);
        } else {
            r(5, new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.QQHRViewModelImpl$sendEvent$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IECHRViewModel iECHRViewModel3 = QQHRViewModelImpl.this.ecHRViewModel;
                    if (iECHRViewModel3 != null) {
                        iECHRViewModel3.sendEvent(eventName, data);
                    }
                }
            });
        }
    }
}

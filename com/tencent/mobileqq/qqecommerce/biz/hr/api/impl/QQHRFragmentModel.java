package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.Fragment;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ecommerce.base.router.api.IECLogicCallback;
import com.tencent.ecommerce.biz.hr.api.IECHRFragmentModel;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J(\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\u000bj\u0002`\rH\u0016J$\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/QQHRFragmentModel;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/d;", "", "f", "", "msg", "Lkotlin/Function0;", "pendingTask", "g", "Landroid/os/Bundle;", "bundle", "Lkotlin/Function1;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/QQHRFragmentCallback;", "callback", "getFragment", "", AdMetricTag.EVENT_NAME, "", "", "data", "sendEvent", "manualOnStop", "Lcom/tencent/ecommerce/biz/hr/api/IECHRFragmentModel;", "a", "Lcom/tencent/ecommerce/biz/hr/api/IECHRFragmentModel;", "qqHRFragmentModel", "Ljava/util/ArrayDeque;", "Landroid/os/Message;", "b", "Ljava/util/ArrayDeque;", "msgQueue", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "handler", "<init>", "()V", "d", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQHRFragmentModel implements com.tencent.mobileqq.qqecommerce.biz.hr.api.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private IECHRFragmentModel qqHRFragmentModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ArrayDeque<Message> msgQueue = new ArrayDeque<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.b
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean e16;
            e16 = QQHRFragmentModel.e(message);
            return e16;
        }
    });

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/hr/api/impl/QQHRFragmentModel$a", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "result", "", "onResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements IECLogicCallback {
        a() {
        }

        @Override // com.tencent.ecommerce.base.router.api.IECLogicCallback
        public void onResult(HashMap<String, Object> result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QQHRFragmentModel qQHRFragmentModel = QQHRFragmentModel.this;
            Object obj = result.get("fragment_model");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.ecommerce.biz.hr.api.IECHRFragmentModel");
            qQHRFragmentModel.qqHRFragmentModel = (IECHRFragmentModel) obj;
            QQHRFragmentModel.this.f();
        }
    }

    public QQHRFragmentModel() {
        af2.d.f26007a.a(127, new HashMap<>(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 == 1) {
            Object obj = msg2.obj;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function0<kotlin.Unit>");
            ((Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 0)).invoke();
        } else if (i3 == 2) {
            Object obj2 = msg2.obj;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Function0<kotlin.Unit>");
            ((Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj2, 0)).invoke();
        } else {
            if (i3 != 3) {
                return false;
            }
            Object obj3 = msg2.obj;
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Function0<kotlin.Unit>");
            ((Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj3, 0)).invoke();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        Iterator<T> it = this.msgQueue.iterator();
        while (it.hasNext()) {
            this.handler.sendMessage((Message) it.next());
        }
        this.msgQueue.clear();
    }

    private final void g(int msg2, Function0<Unit> pendingTask) {
        Message obtainMessage = this.handler.obtainMessage(msg2);
        obtainMessage.obj = pendingTask;
        this.msgQueue.addLast(obtainMessage);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.d
    public void getFragment(final Bundle bundle, final Function1<? super Fragment, Unit> callback) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IECHRFragmentModel iECHRFragmentModel = this.qqHRFragmentModel;
        if (iECHRFragmentModel != null) {
            iECHRFragmentModel.getFragment(bundle, callback);
        } else {
            g(1, new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.QQHRFragmentModel$getFragment$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    IECHRFragmentModel iECHRFragmentModel2;
                    iECHRFragmentModel2 = QQHRFragmentModel.this.qqHRFragmentModel;
                    if (iECHRFragmentModel2 != null) {
                        iECHRFragmentModel2.getFragment(bundle, callback);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.d
    public void manualOnStop() {
        IECHRFragmentModel iECHRFragmentModel = this.qqHRFragmentModel;
        if (iECHRFragmentModel != null) {
            iECHRFragmentModel.manualOnStop();
        } else {
            g(3, new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.QQHRFragmentModel$manualOnStop$1$1
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
                    IECHRFragmentModel iECHRFragmentModel2;
                    iECHRFragmentModel2 = QQHRFragmentModel.this.qqHRFragmentModel;
                    if (iECHRFragmentModel2 != null) {
                        iECHRFragmentModel2.manualOnStop();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.d
    public void sendEvent(final String eventName, final Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(data, "data");
        IECHRFragmentModel iECHRFragmentModel = this.qqHRFragmentModel;
        if (iECHRFragmentModel != null) {
            iECHRFragmentModel.sendEvent(eventName, data);
        } else {
            g(2, new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.QQHRFragmentModel$sendEvent$1$1
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
                    IECHRFragmentModel iECHRFragmentModel2;
                    iECHRFragmentModel2 = QQHRFragmentModel.this.qqHRFragmentModel;
                    if (iECHRFragmentModel2 != null) {
                        iECHRFragmentModel2.sendEvent(eventName, data);
                    }
                }
            });
        }
    }
}

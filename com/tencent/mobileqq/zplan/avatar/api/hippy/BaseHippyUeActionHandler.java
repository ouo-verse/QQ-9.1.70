package com.tencent.mobileqq.zplan.avatar.api.hippy;

import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import l13.ZPlanHippyResult;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \t2\u00020\u0001:\u0001\u000fB!\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0006\u0010\u0007\u001a\u00020\u0005J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0004J\b\u0010\n\u001a\u00020\u0005H\u0004J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0004R\u001a\u0010\u0013\u001a\u00020\u000e8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00148\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/api/hippy/BaseHippyUeActionHandler;", "", "", "g", "j", "", "c", "f", "Lcom/tencent/mobileqq/zplan/avatar/api/hippy/a;", "d", h.F, "Ll13/a;", "result", "i", "", "a", "I", "getActionType", "()I", "actionType", "Lorg/json/JSONObject;", "b", "Lorg/json/JSONObject;", "e", "()Lorg/json/JSONObject;", "param", "Lcom/tencent/mtt/hippy/modules/Promise;", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "<init>", "(ILorg/json/JSONObject;Lcom/tencent/mtt/hippy/modules/Promise;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class BaseHippyUeActionHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int actionType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final JSONObject param;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Promise promise;

    public BaseHippyUeActionHandler(@HippyUeActionType int i3, JSONObject param, Promise promise) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.actionType = i3;
        this.param = param;
        this.promise = promise;
    }

    private final String g() {
        return "HippyUeAction_" + j();
    }

    public abstract void c();

    /* JADX INFO: Access modifiers changed from: protected */
    public final a d() {
        return ((te3.a) vb3.a.f441346a.b(te3.a.class)).m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e, reason: from getter */
    public final JSONObject getParam() {
        return this.param;
    }

    public final void f() {
        QLog.i(g(), 1, "handleAction actionType:" + this.actionType + ", param:" + this.param);
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.avatar.api.hippy.BaseHippyUeActionHandler$handleAction$1
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
                BaseHippyUeActionHandler.this.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h() {
        i(ZPlanHippyResult.INSTANCE.a("native not ready!"));
        QLog.e(g(), 1, "notifyInterfaceError");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i(ZPlanHippyResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        String jSONObject = result.b().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "result.toJson().toString()");
        if (result.getResult() == 0) {
            this.promise.resolve(jSONObject);
        } else {
            this.promise.reject(jSONObject);
        }
        QLog.i(g(), 1, "notifyResult: " + jSONObject);
    }

    public abstract String j();
}

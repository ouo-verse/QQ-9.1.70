package com.tencent.mobileqq.wxmini.ad.kuikly.module;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015JG\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002JI\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wxmini/ad/kuikly/module/b;", "Li01/e;", "", "method", "", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "Lcom/tencent/mobileqq/wxmini/ad/kuikly/module/a;", "a", "call", "Lcom/tencent/mobileqq/wxmini/ad/kuikly/module/c;", "d", "Lcom/tencent/mobileqq/wxmini/ad/kuikly/module/c;", "mClickHandler", "<init>", "()V", "e", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final c mClickHandler = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wxmini/ad/kuikly/module/b$b", "Lcom/tencent/mobileqq/wxmini/ad/kuikly/module/a;", "", "result", "", "invoke", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wxmini.ad.kuikly.module.b$b, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C9102b implements a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f327597a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f327598b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f327599c;

        C9102b(Function1<Object, Unit> function1, String str, Object obj) {
            this.f327597a = function1;
            this.f327598b = str;
            this.f327599c = obj;
        }

        @Override // com.tencent.mobileqq.wxmini.ad.kuikly.module.a
        public void invoke(Object result) {
            try {
                Function1<Object, Unit> function1 = this.f327597a;
                if (function1 != null) {
                    function1.invoke(result);
                }
                QLog.i("WxMiniGameCenterAdKuiklyModule", 1, "[invoke] method:" + this.f327598b + " params:" + this.f327599c + " result:" + result);
            } catch (Throwable th5) {
                QLog.e("WxMiniGameCenterAdKuiklyModule", 1, "[invoke] method:" + this.f327598b + " params:" + this.f327599c + " result:" + result, th5);
            }
        }
    }

    private final a a(String method, Object params, Function1<Object, Unit> callback) {
        return new C9102b(callback, method, params);
    }

    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.i("WxMiniGameCenterAdKuiklyModule", 1, "[call] method:" + method + " params:" + params);
        e eVar = new e();
        eVar.f327600a = getActivity();
        eVar.f327601b = a(method, params, callback);
        eVar.f327602c = method;
        eVar.f327603d = params;
        if (Intrinsics.areEqual(method, "handleClick")) {
            this.mClickHandler.b(eVar);
            return Unit.INSTANCE;
        }
        QLog.e("WxMiniGameCenterAdKuiklyModule", 1, "[call] error, unknown method, method:" + method + " params:" + params);
        return Unit.INSTANCE;
    }
}

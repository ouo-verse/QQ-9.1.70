package com.tencent.mobileqq.qqecommerce.biz.kuikly.container;

import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.ResError;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.config.ExecuteContextMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0087\u0001\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012j\u0010\u0018\u001af\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bj\u0004\u0018\u0001`\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002J\u0006\u0010\u0006\u001a\u00020\u0003R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tRz\u0010\u0018\u001af\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bj\u0004\u0018\u0001`\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/m;", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/k;", "", "resError", "a", "b", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyRenderView;", "d", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyRenderView;", "renderView", "Lkotlin/Function4;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/config/ExecuteContextMode;", "Lkotlin/ParameterName;", "name", "mode", "", "state", "", "contextCode", "assetsPath", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/LoadResultCallback;", "e", "Lkotlin/jvm/functions/Function4;", "result", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/c;", "f", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/c;", "dexResFetcher", "<init>", "(Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyRenderView;Lkotlin/jvm/functions/Function4;Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/c;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class m implements Function1<ResError, Unit> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QQKuiklyRenderView renderView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Function4<? super ExecuteContextMode, ? super Integer, ? super String, ? super String, Unit> result;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c dexResFetcher;

    public m(QQKuiklyRenderView qQKuiklyRenderView, Function4<? super ExecuteContextMode, ? super Integer, ? super String, ? super String, Unit> function4, com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c cVar) {
        this.renderView = qQKuiklyRenderView;
        this.result = function4;
        this.dexResFetcher = cVar;
    }

    public void a(ResError resError) {
        QQKuiklyRenderView qQKuiklyRenderView;
        Function4<? super ExecuteContextMode, ? super Integer, ? super String, ? super String, Unit> function4;
        Intrinsics.checkNotNullParameter(resError, "resError");
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c cVar = this.dexResFetcher;
        if (cVar == null || (qQKuiklyRenderView = this.renderView) == null || (function4 = this.result) == null) {
            return;
        }
        qQKuiklyRenderView.i0(resError, function4, cVar);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ResError resError) {
        a(resError);
        return Unit.INSTANCE;
    }

    public final void b() {
        this.renderView = null;
        this.result = null;
        this.dexResFetcher = null;
    }
}

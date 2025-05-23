package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C11732b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR \u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/PAGSoLoader;", "", "", "success", "", "k", "l", "Lkotlin/Function0;", "cb", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "Z", "isReady", "b", "isLoadStarted", "", "c", "Ljava/util/List;", "readyCallbacks", "", "d", "I", "leftLoadTimes", "<init>", "()V", "e", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
final class PAGSoLoader {

    /* renamed from: f, reason: collision with root package name */
    private static boolean f263097f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isReady;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isLoadStarted;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final List<Function0<Unit>> readyCallbacks;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int leftLoadTimes;

    public PAGSoLoader() {
        this.isReady = f263097f || QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPagSoLoader().loadPagSo();
        this.readyCallbacks = new ArrayList();
        this.leftLoadTimes = 3;
        if (this.isReady) {
            return;
        }
        QLog.d("PAGSoLoader", 1, "start pre download pag so");
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPagSoLoader().downloadPagSo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(final boolean success) {
        C11732b.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.PAGSoLoader$handleLoadDone$1
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
                int i3;
                int i16;
                int i17;
                List list;
                List list2;
                if (success) {
                    PAGSoLoader.f263097f = true;
                    this.isReady = true;
                    list = this.readyCallbacks;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((Function0) it.next()).invoke();
                    }
                    list2 = this.readyCallbacks;
                    list2.clear();
                    return;
                }
                PAGSoLoader pAGSoLoader = this;
                i3 = pAGSoLoader.leftLoadTimes;
                pAGSoLoader.leftLoadTimes = i3 - 1;
                i16 = this.leftLoadTimes;
                QLog.e("PAGSoLoader", 1, "load pag so failed left times: " + i16);
                i17 = this.leftLoadTimes;
                if (i17 > 0) {
                    this.l();
                }
            }
        });
    }

    public final void m(final Function0<Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        C11732b.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.PAGSoLoader$onReady$1
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
                boolean z16;
                List list;
                boolean z17;
                z16 = PAGSoLoader.this.isReady;
                if (!z16) {
                    list = PAGSoLoader.this.readyCallbacks;
                    list.add(cb5);
                    z17 = PAGSoLoader.this.isLoadStarted;
                    if (z17) {
                        return;
                    }
                    PAGSoLoader.this.isLoadStarted = true;
                    PAGSoLoader.this.l();
                    return;
                }
                cb5.invoke();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        QLog.d("PAGSoLoader", 1, "start load pag so async");
        final WeakReference weakReference = new WeakReference(this);
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPagSoLoader().loadPagSoAsync(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.PAGSoLoader$loadAsync$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                QLog.d("PAGSoLoader", 1, "load pag async result: " + z16);
                PAGSoLoader pAGSoLoader = weakReference.get();
                if (pAGSoLoader != null) {
                    pAGSoLoader.k(z16);
                }
            }
        });
    }
}

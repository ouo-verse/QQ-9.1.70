package com.tencent.mobileqq.zplan.aigc;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitParentFragment$buildWatchAdItem$1$onItemClick$1", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "result", "", "e", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SuitParentFragment$buildWatchAdItem$1$onItemClick$1 implements com.tencent.mobileqq.zootopia.api.e<Integer> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ SuitParentFragment f330000d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SuitParentFragment$buildWatchAdItem$1$onItemClick$1(SuitParentFragment suitParentFragment) {
        this.f330000d = suitParentFragment;
    }

    public void e(int result) {
        QLog.i("SuitParentFragment", 1, "requestWatchAdQualification onResultSuccess: " + result);
        if (result == 1) {
            final SuitParentFragment suitParentFragment = this.f330000d;
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitParentFragment$buildWatchAdItem$1$onItemClick$1$onResultSuccess$1
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
                    SuitParentFragment.this.Ei();
                }
            });
        } else if (result != 2) {
            this.f330000d.Mi(false);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.bl
                @Override // java.lang.Runnable
                public final void run() {
                    SuitParentFragment$buildWatchAdItem$1$onItemClick$1.g();
                }
            });
        } else {
            this.f330000d.Mi(false);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.bk
                @Override // java.lang.Runnable
                public final void run() {
                    SuitParentFragment$buildWatchAdItem$1$onItemClick$1.f();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.zootopia.api.e
    public /* bridge */ /* synthetic */ void onResultSuccess(Integer num) {
        e(num.intValue());
    }

    @Override // com.tencent.mobileqq.zootopia.api.e
    public void onResultFailure(int error, String message) {
        QLog.i("SuitParentFragment", 1, "requestWatchAdQualification onResultFailure");
        this.f330000d.Mi(false);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.bj
            @Override // java.lang.Runnable
            public final void run() {
                SuitParentFragment$buildWatchAdItem$1$onItemClick$1.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        QQToastUtil.showQQToast(0, R.string.xs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        QQToastUtil.showQQToast(0, R.string.xkr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        QQToastUtil.showQQToast(0, R.string.xs_);
    }
}

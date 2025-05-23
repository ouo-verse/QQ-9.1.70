package com.tencent.sqshow.zootopia.nativeui.view.detail;

import android.os.Handler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.NormalDressStrategy;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.util.QQToastUtil;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import m94.DressErrorMsg;
import n74.u;
import t74.o;
import uv4.az;
import uv4.ba;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/detail/GoodsDetailDialogView$launchAd$adHelper$1$1", "Lt74/o$b;", "", "success", "", "b", "profitable", "c", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class GoodsDetailDialogView$launchAd$adHelper$1$1 implements o.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoodsDetailDialogView f371640a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ az f371641b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoodsDetailDialogView$launchAd$adHelper$1$1(GoodsDetailDialogView goodsDetailDialogView, az azVar) {
        this.f371640a = goodsDetailDialogView;
        this.f371641b = azVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(GoodsDetailDialogView this$0) {
        u uVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToastUtil.showQQToast(0, R.string.xs_);
        uVar = this$0.dialogBinding;
        uVar.f419423f.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(GoodsDetailDialogView this$0) {
        u uVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        uVar = this$0.dialogBinding;
        uVar.f419423f.setEnabled(true);
    }

    @Override // t74.o.b
    public void a(boolean success) {
        QLog.i("GoodsDetailDialogView", 1, "ZPlanAdHelper onReportResult " + success);
        if (success) {
            this.f371641b.f440288o.f440307h++;
            this.f371640a.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().K().put(Long.valueOf(this.f371641b.f440274a), this.f371641b);
            this.f371640a.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().L().postValue(this.f371640a.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().K());
            ba baVar = this.f371641b.f440288o;
            if (baVar.f440308i == baVar.f440307h) {
                QLog.e("GoodsDetailDialogView", 1, "ZPlanAvatarChangeManager.refreshPannel");
                final GoodsDetailDialogView goodsDetailDialogView = this.f371640a;
                final az azVar = this.f371641b;
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.GoodsDetailDialogView$launchAd$adHelper$1$1$onReportResult$1

                    /* compiled from: P */
                    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/detail/GoodsDetailDialogView$launchAd$adHelper$1$1$onReportResult$1$a", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
                    /* loaded from: classes34.dex */
                    public static final class a implements m94.h {
                        a() {
                        }

                        @Override // m94.h
                        public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
                            Intrinsics.checkNotNullParameter(task, "task");
                            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                            QLog.i("GoodsDetailDialogView", 1, "dressOnOrOffClothes ONLY_OFF onError");
                        }

                        @Override // m94.h
                        public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
                            Intrinsics.checkNotNullParameter(task, "task");
                            QLog.i("GoodsDetailDialogView", 1, "dressOnOrOffClothes ONLY_OFF onSuccess");
                        }
                    }

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
                        b94.d avatarDressController = GoodsDetailDialogView.this.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getAvatarDressController();
                        if (avatarDressController != null) {
                            avatarDressController.Lf(azVar, new a(), NormalDressStrategy.ONLY_OFF);
                        }
                    }
                });
                f94.c.f398021a.c(false);
                this.f371640a.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().K().remove(Long.valueOf(this.f371641b.f440274a));
                this.f371640a.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().L().postValue(this.f371640a.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().K());
                QQToastUtil.showQQToastInUiThread(2, BaseApplication.getContext().getString(R.string.xsa));
                return;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = BaseApplication.getContext().getString(R.string.xs9);
            Intrinsics.checkNotNullExpressionValue(string, "getContext()\n           \u2026_activity_ad_count_toast)");
            ba baVar2 = this.f371641b.f440288o;
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(baVar2.f440308i - baVar2.f440307h)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QQToastUtil.showQQToastInUiThread(0, format);
        }
    }

    @Override // t74.o.b
    public void b(boolean success) {
        QLog.i("GoodsDetailDialogView", 1, "ZPlanAdHelper onRequestResult " + success);
        if (success) {
            return;
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final GoodsDetailDialogView goodsDetailDialogView = this.f371640a;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.o
            @Override // java.lang.Runnable
            public final void run() {
                GoodsDetailDialogView$launchAd$adHelper$1$1.f(GoodsDetailDialogView.this);
            }
        });
    }

    @Override // t74.o.b
    public void c(boolean profitable) {
        QLog.i("GoodsDetailDialogView", 1, "ZPlanAdHelper onShowResult " + profitable);
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final GoodsDetailDialogView goodsDetailDialogView = this.f371640a;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.p
            @Override // java.lang.Runnable
            public final void run() {
                GoodsDetailDialogView$launchAd$adHelper$1$1.g(GoodsDetailDialogView.this);
            }
        });
    }
}

package com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zootopia.download.DownloadDialogUtils;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views.ZPlanSingleItemShoppingCartDialogView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarCommonOperateHelper;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.util.QQToastUtil;
import com.tencent.util.URLUtil;
import fi3.as;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001BBl\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010+\u001a\u00020(\u0012S\u00104\u001aO\u0012A\u0012?\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00050\u0012j\u0011`/\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(0\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00050\u0012j\u0002`1\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J4\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0012H\u0002J\u001a\u0010\u0018\u001a\u00020\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0012\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010 H\u0014J\u0006\u0010#\u001a\u00020\u0005J\b\u0010$\u001a\u00020\u0005H\u0016J\u0012\u0010'\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010%H\u0016R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*Ra\u00104\u001aO\u0012A\u0012?\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00050\u0012j\u0011`/\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(0\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00050\u0012j\u0002`18\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/zplan/nativeui/impl/view/dialog/views/ZPlanSingleItemShoppingCartDialogView;", "Landroid/app/Dialog;", "Landroid/content/DialogInterface$OnShowListener;", "Landroid/view/Window;", "window", "", "w", "j", "", "url", "Landroid/graphics/drawable/Drawable;", "p", "u", "Landroid/content/Context;", "context", "", "currentGoldCoin", "diffGoldCoin", "Lkotlin/Function1;", "", "callback", "y", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/f;", "r", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "Landroid/view/View;", "contentView", "Landroid/animation/AnimatorSet;", "o", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", HippyTKDListViewAdapter.X, "onBackPressed", "Landroid/content/DialogInterface;", "dialog", "onShow", "Lcom/tencent/mobileqq/zplan/nativeui/impl/view/dialog/views/a;", "d", "Lcom/tencent/mobileqq/zplan/nativeui/impl/view/dialog/views/a;", "itemData", "Lkotlin/ParameterName;", "name", "success", "Lcom/tencent/mobileqq/zplan/nativeui/impl/view/dialog/views/ZPlanShoppingCartBuyFinishCallback;", "finishCallback", "Lcom/tencent/mobileqq/zplan/nativeui/impl/view/dialog/views/ZPlanShoppingCartRequester;", "e", "Lkotlin/jvm/functions/Function1;", "buyRequester", "Lfi3/as;", "f", "Lfi3/as;", "viewBinding", tl.h.F, "I", "curGoldCoin", "i", "Z", "animating", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/zplan/nativeui/impl/view/dialog/views/a;Lkotlin/jvm/functions/Function1;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanSingleItemShoppingCartDialogView extends Dialog implements DialogInterface.OnShowListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final SingleItemShoppingCartData itemData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function1<Function1<? super Boolean, Unit>, Unit> buyRequester;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final as viewBinding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int curGoldCoin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean animating;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/nativeui/impl/view/dialog/views/ZPlanSingleItemShoppingCartDialogView$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f334867a;

        b(ImageView imageView) {
            this.f334867a = imageView;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            int width = view.getWidth();
            int height = view.getHeight();
            ImageView getOutline = this.f334867a;
            Intrinsics.checkNotNullExpressionValue(getOutline, "getOutline");
            outline.setRoundRect(0, 0, width, height, kotlin.g.c(getOutline, 4.0f));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/nativeui/impl/view/dialog/views/ZPlanSingleItemShoppingCartDialogView$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/f;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(com.tencent.sqshow.zootopia.data.f result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ZPlanSingleItemShoppingCartDialogView.this.u();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QQToastUtil.showQQToastInUiThread(1, "\u83b7\u53d6\u91d1\u5e01\u4f59\u989d\u5931\u8d25");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/nativeui/impl/view/dialog/views/ZPlanSingleItemShoppingCartDialogView$d", "Loc4/a;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d extends oc4.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f334869d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZPlanSingleItemShoppingCartDialogView f334870e;

        d(View view, ZPlanSingleItemShoppingCartDialogView zPlanSingleItemShoppingCartDialogView) {
            this.f334869d = view;
            this.f334870e = zPlanSingleItemShoppingCartDialogView;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f334870e.animating = false;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            this.f334869d.setVisibility(0);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/nativeui/impl/view/dialog/views/ZPlanSingleItemShoppingCartDialogView$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/f;", "result", "", "b", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> f334872e;

        e(com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> eVar) {
            this.f334872e = eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ZPlanSingleItemShoppingCartDialogView this$0, com.tencent.sqshow.zootopia.data.f result) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(result, "$result");
            this$0.viewBinding.f398931r.setText(com.tencent.sqshow.zootopia.utils.e.f373267a.a(result.getGoldCoin()));
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(final com.tencent.sqshow.zootopia.data.f result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (result.getGoldCoinRet() == 0) {
                ZPlanSingleItemShoppingCartDialogView.this.curGoldCoin = result.getGoldCoin();
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final ZPlanSingleItemShoppingCartDialogView zPlanSingleItemShoppingCartDialogView = ZPlanSingleItemShoppingCartDialogView.this;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanSingleItemShoppingCartDialogView.e.c(ZPlanSingleItemShoppingCartDialogView.this, result);
                    }
                });
            } else {
                QQToastUtil.showQQToastInUiThread(1, "\u83b7\u53d6\u91d1\u5e01\u4f59\u989d\u5931\u8d25");
            }
            com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> eVar = this.f334872e;
            if (eVar != null) {
                eVar.onResultSuccess(result);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QQToastUtil.showQQToastInUiThread(1, "\u83b7\u53d6\u91d1\u5e01\u4f59\u989d\u5931\u8d25");
            com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> eVar = this.f334872e;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ZPlanSingleItemShoppingCartDialogView(Context context, SingleItemShoppingCartData itemData, Function1<? super Function1<? super Boolean, Unit>, Unit> buyRequester) {
        super(context, R.style.f2432107);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        Intrinsics.checkNotNullParameter(buyRequester, "buyRequester");
        this.itemData = itemData;
        this.buyRequester = buyRequester;
        Window window = getWindow();
        if (window != null) {
            w(window);
        }
        as g16 = as.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.viewBinding = g16;
    }

    private final void j() {
        this.viewBinding.f398915b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanSingleItemShoppingCartDialogView.k(ZPlanSingleItemShoppingCartDialogView.this, view);
            }
        });
        s(this, null, 1, null);
        this.viewBinding.f398919f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanSingleItemShoppingCartDialogView.l(ZPlanSingleItemShoppingCartDialogView.this, view);
            }
        });
        ImageView imageView = this.viewBinding.f398927n;
        imageView.setBackgroundColor(imageView.getResources().getColor(R.color.qui_common_fill_standard_primary));
        imageView.setImageDrawable(p(this.itemData.getIconUrl()));
        imageView.setClipToOutline(true);
        imageView.setOutlineProvider(new b(imageView));
        this.viewBinding.f398925l.setBackground(p(this.itemData.getCornerUrl()));
        this.viewBinding.f398928o.setText(this.itemData.getText());
        this.viewBinding.f398929p.setText(String.valueOf(this.itemData.getPrice()));
        this.viewBinding.f398916c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanSingleItemShoppingCartDialogView.m(ZPlanSingleItemShoppingCartDialogView.this, view);
            }
        });
        setOnShowListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(ZPlanSingleItemShoppingCartDialogView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ZPlanSingleItemShoppingCartDialogView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ZPlanSingleItemShoppingCartDialogView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!iZPlanApi.isNetworkAvailable(context)) {
            QQToastUtil.showQQToastInUiThread(1, this$0.getContext().getResources().getString(R.string.f171139ci4));
            QLog.w("ZPlanCoupleAvatarShoppingCartDialogView", 1, "buyBtn click networkAvailable false, return!");
        } else if (this$0.curGoldCoin <= 0) {
            this$0.r(new c());
        } else {
            this$0.u();
        }
    }

    private final void n() {
        LinearLayout linearLayout = this.viewBinding.f398917d;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "viewBinding.cartContainer");
        if (this.animating) {
            return;
        }
        this.animating = true;
        o(linearLayout).start();
    }

    private final AnimatorSet o(View contentView) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new d(contentView, this));
        View view = this.viewBinding.f398915b;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, view.getAlpha(), 1.0f);
        ofFloat.setDuration(200L);
        animatorSet.play(ofFloat);
        contentView.setTranslationY(i.b(250));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(contentView, "translationY", contentView.getTranslationY(), 0.0f);
        ofFloat2.setDuration(200L);
        animatorSet.play(ofFloat2);
        return animatorSet;
    }

    private final Drawable p(String url) {
        if (!URLUtil.isValidUrl(url)) {
            Drawable TRANSPARENT = com.tencent.mobileqq.urldrawable.b.f306350a;
            Intrinsics.checkNotNullExpressionValue(TRANSPARENT, "TRANSPARENT");
            return TRANSPARENT;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable(url, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(url, URLDraw\u2026ts.TRANSPARENT\n        })");
        return drawable2;
    }

    private final void q() {
        dismiss();
    }

    private final void r(com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> callback) {
        yb4.e.h(yb4.e.f450058a, "request_immediately", new e(callback), 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ZPlanSingleItemShoppingCartDialogView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        if (this.curGoldCoin >= this.itemData.getPrice()) {
            v();
            return;
        }
        final int price = this.itemData.getPrice() - this.curGoldCoin;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        y(context, this.curGoldCoin, price, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views.ZPlanSingleItemShoppingCartDialogView$processItemPay$1
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
                if (z16) {
                    AvatarCommonOperateHelper avatarCommonOperateHelper = AvatarCommonOperateHelper.f371049a;
                    int i3 = price;
                    final ZPlanSingleItemShoppingCartDialogView zPlanSingleItemShoppingCartDialogView = this;
                    avatarCommonOperateHelper.n(i3, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views.ZPlanSingleItemShoppingCartDialogView$processItemPay$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z17) {
                            if (z17) {
                                ZPlanSingleItemShoppingCartDialogView.this.v();
                            } else {
                                QLog.i("ZPlanCoupleAvatarShoppingCartDialogView", 1, "cancel pay");
                            }
                        }
                    });
                    return;
                }
                QLog.i("ZPlanCoupleAvatarShoppingCartDialogView", 1, "choose not to pay");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        this.viewBinding.f398922i.h(500L);
        this.buyRequester.invoke(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views.ZPlanSingleItemShoppingCartDialogView$sendBuyReqToServer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                ZPlanSingleItemShoppingCartDialogView.this.viewBinding.f398922i.e();
                ZPlanSingleItemShoppingCartDialogView.this.dismiss();
            }
        });
    }

    private final void w(Window window) {
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (Build.VERSION.SDK_INT >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        window.setAttributes(attributes);
    }

    private final void y(Context context, int currentGoldCoin, int diffGoldCoin, Function1<? super Boolean, Unit> callback) {
        DownloadDialogUtils.f327978a.t(new ZPlanSingleItemShoppingCartDialogView$showPayDialog$1(context, currentGoldCoin, diffGoldCoin, callback));
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        q();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.viewBinding.getRoot());
        j();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialog) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views.b
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanSingleItemShoppingCartDialogView.t(ZPlanSingleItemShoppingCartDialogView.this);
            }
        });
    }

    public final void x() {
        show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void s(ZPlanSingleItemShoppingCartDialogView zPlanSingleItemShoppingCartDialogView, com.tencent.mobileqq.zootopia.api.e eVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            eVar = null;
        }
        zPlanSingleItemShoppingCartDialogView.r(eVar);
    }
}

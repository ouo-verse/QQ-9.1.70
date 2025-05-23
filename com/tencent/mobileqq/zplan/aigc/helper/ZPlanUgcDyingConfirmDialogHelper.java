package com.tencent.mobileqq.zplan.aigc.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.zplan.aigc.view.dialog.DyeingColorConfirmDialogView;
import com.tencent.qphone.base.util.QLog;
import ga4.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\tB!\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/ZPlanUgcDyingConfirmDialogHelper;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "f", "Landroid/content/Context;", "context", "", tl.h.F, "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "getContainer", "()Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroidx/lifecycle/LifecycleOwner;", "b", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lzd3/a;", "c", "Lzd3/a;", "d", "()Lzd3/a;", "dtReporter", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "e", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "g", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "mChannel", "Lga4/h;", "Lga4/h;", "dismissListener", "<init>", "(Landroid/view/ViewGroup;Landroidx/lifecycle/LifecycleOwner;Lzd3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanUgcDyingConfirmDialogHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup container;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final zd3.a dtReporter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ga4.h dismissListener;

    public ZPlanUgcDyingConfirmDialogHelper(ViewGroup container, LifecycleOwner lifecycleOwner, zd3.a aVar) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.container = container;
        this.lifecycleOwner = lifecycleOwner;
        this.dtReporter = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.sqshow.zootopia.nativeui.data.j f() {
        ga4.i iVar = new ga4.i(this.container);
        com.tencent.sqshow.zootopia.nativeui.data.repo.i iVar2 = new com.tencent.sqshow.zootopia.nativeui.data.repo.i();
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = new com.tencent.sqshow.zootopia.nativeui.data.j(null, iVar);
        jVar.Z(this.lifecycleOwner);
        jVar.T(iVar2);
        return jVar;
    }

    /* renamed from: d, reason: from getter */
    public final zd3.a getDtReporter() {
        return this.dtReporter;
    }

    /* renamed from: e, reason: from getter */
    public final com.tencent.sqshow.zootopia.nativeui.data.j getMChannel() {
        return this.mChannel;
    }

    public final void g(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
        this.mChannel = jVar;
    }

    public final void h(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        t74.l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.helper.ZPlanUgcDyingConfirmDialogHelper$showDyeingConfirmDialog$1

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/aigc/helper/ZPlanUgcDyingConfirmDialogHelper$showDyeingConfirmDialog$1$a", "Lga4/h;", "Lga4/g;", "panelDialog", "", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements ga4.h {
                a() {
                }

                @Override // ga4.h
                public void a(ga4.g panelDialog) {
                    Intrinsics.checkNotNullParameter(panelDialog, "panelDialog");
                    QLog.i("ZPlanUgcDyingConfirmDialogHelper", 1, "DyeingConfirm dialog panel onDismiss");
                }

                @Override // ga4.h
                public void b(ga4.g panelDialog) {
                    Intrinsics.checkNotNullParameter(panelDialog, "panelDialog");
                    h.a.a(this, panelDialog);
                    QLog.i("ZPlanUgcDyingConfirmDialogHelper", 1, "DyeingConfirm dialog panel onShow");
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
                com.tencent.sqshow.zootopia.nativeui.data.j f16;
                ga4.f dialogController;
                ga4.h hVar;
                ZPlanUgcDyingConfirmDialogHelper zPlanUgcDyingConfirmDialogHelper = ZPlanUgcDyingConfirmDialogHelper.this;
                f16 = zPlanUgcDyingConfirmDialogHelper.f();
                zPlanUgcDyingConfirmDialogHelper.g(f16);
                Context context2 = context;
                com.tencent.sqshow.zootopia.nativeui.data.j mChannel = ZPlanUgcDyingConfirmDialogHelper.this.getMChannel();
                Intrinsics.checkNotNull(mChannel);
                final DyeingColorConfirmDialogView dyeingColorConfirmDialogView = new DyeingColorConfirmDialogView(context2, null, 0, mChannel, ZPlanUgcDyingConfirmDialogHelper.this.getDtReporter(), 6, null);
                ZPlanUgcDyingConfirmDialogHelper.this.dismissListener = new a();
                com.tencent.sqshow.zootopia.nativeui.data.j mChannel2 = ZPlanUgcDyingConfirmDialogHelper.this.getMChannel();
                if (mChannel2 != null && (dialogController = mChannel2.getDialogController()) != null) {
                    hVar = ZPlanUgcDyingConfirmDialogHelper.this.dismissListener;
                    dialogController.c(new WeakReference<>(hVar));
                }
                com.tencent.mobileqq.zplan.aigc.share.b.f330597a.e("https://downv6.qq.com/shadow_qqcamera/zshow/ZTPDye/ztp_dyeing_modal_image@3x.png", "custom_color_head_pic.png", "zplan_aigc_protocol", new com.tencent.mobileqq.zplan.aigc.share.d() { // from class: com.tencent.mobileqq.zplan.aigc.helper.ZPlanUgcDyingConfirmDialogHelper$showDyeingConfirmDialog$1.2
                    @Override // com.tencent.mobileqq.zplan.aigc.share.d
                    public void onFailure(String error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        QLog.e("ZPlanUgcDyingConfirmDialogHelper", 1, "download head picture failed");
                    }

                    @Override // com.tencent.mobileqq.zplan.aigc.share.d
                    public void onSuccess(final Bitmap bitmap) {
                        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                        t74.l lVar = t74.l.f435563a;
                        final DyeingColorConfirmDialogView dyeingColorConfirmDialogView2 = DyeingColorConfirmDialogView.this;
                        lVar.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.helper.ZPlanUgcDyingConfirmDialogHelper$showDyeingConfirmDialog$1$2$onSuccess$1
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
                                DyeingColorConfirmDialogView.this.setHeadPicBitmap(bitmap);
                                DyeingColorConfirmDialogView dyeingColorConfirmDialogView3 = DyeingColorConfirmDialogView.this;
                                if (dyeingColorConfirmDialogView3 != null) {
                                    dyeingColorConfirmDialogView3.show();
                                }
                            }
                        });
                    }
                });
            }
        });
    }
}

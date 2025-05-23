package com.tencent.aelight.camera.ae.flashshow.ui.panel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautyItem;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautySecondarySelectedWrapper;
import com.tencent.aelight.camera.ae.camera.ui.panel.ar;
import com.tencent.aelight.camera.ae.camera.ui.panel.bj;
import com.tencent.aelight.camera.ae.camera.ui.panel.bk;
import com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.ui.LSCaptureController;
import com.tencent.aelight.camera.ae.flashshow.ui.panel.LSEffectListHolder;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u00013B\u0019\u0012\u0006\u00100\u001a\u00020/\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0014\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0006\u0010\u0017\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u0019\u001a\u00020\u0003R\u0017\u0010\u001e\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00064"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/LSBeautyProviderView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/LSEffectListHolder$b;", "", "t", "D", "k", "r", DomainData.DOMAIN_NAME, "Landroid/app/Activity;", ReportConstant.COSTREPORT_PREFIX, "B", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aelight/camera/ae/flashshow/ui/LSCaptureController;", "controller", "Llq/b;", "partManager", "setControllerAndManager", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "b", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "I", "getRightBeautyBtnMode", "()I", "rightBeautyBtnMode", "Lcom/tencent/aelight/camera/ae/flashshow/LSMiddleCameraUnit;", "e", "Lcom/tencent/aelight/camera/ae/flashshow/LSMiddleCameraUnit;", "lifecycleOwner", "f", "Lcom/tencent/aelight/camera/ae/flashshow/ui/LSCaptureController;", tl.h.F, "Llq/b;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyProviderViewModel;", "i", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyProviderViewModel;", "beautyViewModel", "Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/LSEffectListHolder;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/LSEffectListHolder;", "primaryBeautyListManager", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;I)V", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class LSBeautyProviderView extends FrameLayout implements LSEffectListHolder.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int rightBeautyBtnMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LSMiddleCameraUnit lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LSCaptureController controller;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private lq.b partManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AEBeautyProviderViewModel beautyViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LSEffectListHolder primaryBeautyListManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LSBeautyProviderView(Context context, int i3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rightBeautyBtnMode = i3;
        this.primaryBeautyListManager = new LSEffectListHolder(context, this, this, i3);
    }

    private final void B() {
        Map mapOf;
        VideoReport.setElementId(this, "em_xsj_beauty_clear");
        VideoReport.setElementParams(this, com.tencent.aelight.camera.ae.flashshow.ab.c().e());
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("xsj_eid", "em_xsj_beauty_clear"));
        VideoReport.reportEvent("ev_xsj_camera_action", this, mapOf);
    }

    private final void C() {
        Map mapOf;
        VideoReport.setElementId(this, "em_xsj_beauty_reset");
        VideoReport.setElementParams(this, com.tencent.aelight.camera.ae.flashshow.ab.c().e());
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("xsj_eid", "em_xsj_beauty_reset"));
        VideoReport.reportEvent("ev_xsj_camera_action", this, mapOf);
    }

    private final void D() {
        LSEffectListHolder.d(this.primaryBeautyListManager, false, 1, null);
        this.primaryBeautyListManager.i();
    }

    private final void k() {
        Activity s16 = s();
        if (s16 == null) {
            ms.a.c("LSBeautyProviderView", "the context is not activity");
            r();
            return;
        }
        if (s16.isFinishing()) {
            ms.a.c("LSBeautyProviderView", "the activity is finished.");
            r();
            return;
        }
        QQCustomDialog qQCustomDialog = new QQCustomDialog(s16, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(R.string.y1p);
        qQCustomDialog.setMessage("");
        qQCustomDialog.setNegativeButton(R.string.y0p, new DialogInterface.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                LSBeautyProviderView.l(dialogInterface, i3);
            }
        });
        qQCustomDialog.setPositiveButton(R.string.y0z, new DialogInterface.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                LSBeautyProviderView.m(LSBeautyProviderView.this, dialogInterface, i3);
            }
        });
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(LSBeautyProviderView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r();
    }

    private final void n() {
        Activity s16 = s();
        if (s16 != null && !s16.isFinishing()) {
            QQCustomDialog qQCustomDialog = new QQCustomDialog(s16, R.style.qZoneInputDialog);
            qQCustomDialog.setContentView(R.layout.f167856jn);
            qQCustomDialog.setTitle(R.string.y1q);
            qQCustomDialog.setMessage("");
            qQCustomDialog.setNegativeButton(R.string.y0p, new DialogInterface.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.o
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    LSBeautyProviderView.p(dialogInterface, i3);
                }
            });
            qQCustomDialog.setPositiveButton(R.string.y0z, new DialogInterface.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.p
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    LSBeautyProviderView.o(LSBeautyProviderView.this, dialogInterface, i3);
                }
            });
            qQCustomDialog.setCanceledOnTouchOutside(false);
            qQCustomDialog.show();
            return;
        }
        ms.a.c("LSBeautyProviderView", "alertResetDialog the context is not activity or finish");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(LSBeautyProviderView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AEBeautyProviderViewModel aEBeautyProviderViewModel = this$0.beautyViewModel;
        if (aEBeautyProviderViewModel != null) {
            aEBeautyProviderViewModel.i2();
        }
        this$0.C();
    }

    private final void r() {
        AEBeautyProviderViewModel aEBeautyProviderViewModel = this.beautyViewModel;
        if (aEBeautyProviderViewModel != null) {
            aEBeautyProviderViewModel.Q1();
        }
        B();
    }

    private final Activity s() {
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            return (Activity) context;
        }
        ms.a.c("LSBeautyProviderView", "getTopActivity");
        return Foreground.getTopActivity();
    }

    private final void t() {
        MutableLiveData<com.tencent.aelight.camera.ae.camera.ui.panel.f> X1;
        MutableLiveData<com.tencent.aelight.camera.ae.camera.ui.panel.b> T1;
        LiveData<BeautySecondarySelectedWrapper> Z1;
        LiveData<com.tencent.aelight.camera.ae.camera.ui.panel.b> a26;
        LiveData<List<com.tencent.aelight.camera.ae.camera.ui.panel.b>> U1;
        LSMiddleCameraUnit lSMiddleCameraUnit = this.lifecycleOwner;
        if (lSMiddleCameraUnit != null) {
            AEBeautyProviderViewModel aEBeautyProviderViewModel = (AEBeautyProviderViewModel) com.tencent.aelight.camera.ae.n.a(lSMiddleCameraUnit).get(AEBeautyProviderViewModel.class);
            this.beautyViewModel = aEBeautyProviderViewModel;
            if (aEBeautyProviderViewModel != null && (U1 = aEBeautyProviderViewModel.U1()) != null) {
                U1.observe(lSMiddleCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.h
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        LSBeautyProviderView.u(LSBeautyProviderView.this, (List) obj);
                    }
                });
            }
            AEBeautyProviderViewModel aEBeautyProviderViewModel2 = this.beautyViewModel;
            if (aEBeautyProviderViewModel2 != null && (a26 = aEBeautyProviderViewModel2.a2()) != null) {
                a26.observe(lSMiddleCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.i
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        LSBeautyProviderView.v(LSBeautyProviderView.this, (com.tencent.aelight.camera.ae.camera.ui.panel.b) obj);
                    }
                });
            }
            AEBeautyProviderViewModel aEBeautyProviderViewModel3 = this.beautyViewModel;
            if (aEBeautyProviderViewModel3 != null && (Z1 = aEBeautyProviderViewModel3.Z1()) != null) {
                Z1.observe(lSMiddleCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.j
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        LSBeautyProviderView.w(LSBeautyProviderView.this, (BeautySecondarySelectedWrapper) obj);
                    }
                });
            }
            AEBeautyProviderViewModel aEBeautyProviderViewModel4 = this.beautyViewModel;
            if (aEBeautyProviderViewModel4 != null && (T1 = aEBeautyProviderViewModel4.T1()) != null) {
                T1.observe(lSMiddleCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.k
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        LSBeautyProviderView.x(LSBeautyProviderView.this, (com.tencent.aelight.camera.ae.camera.ui.panel.b) obj);
                    }
                });
            }
            AEBeautyProviderViewModel aEBeautyProviderViewModel5 = this.beautyViewModel;
            if (aEBeautyProviderViewModel5 == null || (X1 = aEBeautyProviderViewModel5.X1()) == null) {
                return;
            }
            X1.observe(lSMiddleCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.l
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    LSBeautyProviderView.y(LSBeautyProviderView.this, (com.tencent.aelight.camera.ae.camera.ui.panel.f) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(LSBeautyProviderView this$0, List configs) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LSEffectListHolder lSEffectListHolder = this$0.primaryBeautyListManager;
        Intrinsics.checkNotNullExpressionValue(configs, "configs");
        List list = configs;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new ar((com.tencent.aelight.camera.ae.camera.ui.panel.b) it.next()));
        }
        lSEffectListHolder.j(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(LSBeautyProviderView this$0, com.tencent.aelight.camera.ae.camera.ui.panel.b bVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bVar.getType() == BeautyItem.NONE.getType()) {
            this$0.primaryBeautyListManager.m();
            return;
        }
        LSEffectListHolder lSEffectListHolder = this$0.primaryBeautyListManager;
        BeautyRealConfig.TYPE type = bVar.getType();
        LSEffectListHolder.l(lSEffectListHolder, type != null ? Integer.valueOf(type.ordinal()).toString() : null, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(LSBeautyProviderView this$0, BeautySecondarySelectedWrapper beautySecondarySelectedWrapper) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LSEffectListHolder.d(this$0.primaryBeautyListManager, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(LSBeautyProviderView this$0, com.tencent.aelight.camera.ae.camera.ui.panel.b bVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LSEffectListHolder.d(this$0.primaryBeautyListManager, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(LSBeautyProviderView this$0, com.tencent.aelight.camera.ae.camera.ui.panel.f fVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LSEffectListHolder.d(this$0.primaryBeautyListManager, false, 1, null);
    }

    public final void A() {
        D();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.panel.LSEffectListHolder.b
    public void b(bj item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (bk.a(item)) {
            k();
            return;
        }
        if (item instanceof ar) {
            com.tencent.aelight.camera.ae.camera.ui.panel.b beautyConfig = ((ar) item).getBeautyConfig();
            if (beautyConfig.getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String() == BeautyItem.RESET) {
                n();
                return;
            }
            AEBeautyProviderViewModel aEBeautyProviderViewModel = this.beautyViewModel;
            if (aEBeautyProviderViewModel != null) {
                aEBeautyProviderViewModel.j2(beautyConfig);
            }
            beautyConfig.getKey();
            AEProviderViewModel.Companion companion = AEProviderViewModel.INSTANCE;
            companion.b(beautyConfig);
            companion.p(beautyConfig);
        }
    }

    public final void q() {
        this.primaryBeautyListManager.k(null, false);
    }

    public final void setControllerAndManager(LSCaptureController controller, lq.b partManager) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(partManager, "partManager");
        this.controller = controller;
        this.partManager = partManager;
        this.lifecycleOwner = (LSMiddleCameraUnit) partManager.b(65537, new Object[0]);
        t();
    }

    public final void z() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(DialogInterface dialogInterface, int i3) {
    }
}

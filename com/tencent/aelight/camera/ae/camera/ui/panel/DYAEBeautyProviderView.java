package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectListHolder;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
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

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0003J\u0006\u0010\u0017\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0003R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEBeautyProviderView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListHolder$b;", "", "r", "D", "k", DomainData.DOMAIN_NAME, "B", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aelight/camera/ae/camera/ui/AECaptureController;", "controller", "Lcom/tencent/aelight/camera/ae/part/c;", "partManager", "setControllerAndManager", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "b", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/aelight/camera/ae/AEPituCameraUnit;", "d", "Lcom/tencent/aelight/camera/ae/AEPituCameraUnit;", "lifecycleOwner", "e", "Lcom/tencent/aelight/camera/ae/camera/ui/AECaptureController;", "f", "Lcom/tencent/aelight/camera/ae/part/c;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyProviderViewModel;", tl.h.F, "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyProviderViewModel;", "beautyViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListHolder;", "i", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListHolder;", "primaryBeautyListManager", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class DYAEBeautyProviderView extends FrameLayout implements DYAEEffectListHolder.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AEPituCameraUnit lifecycleOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AECaptureController controller;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aelight.camera.ae.part.c partManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AEBeautyProviderViewModel beautyViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final DYAEEffectListHolder primaryBeautyListManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DYAEBeautyProviderView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.primaryBeautyListManager = new DYAEEffectListHolder(context, this, this, 0, 8, null);
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
        DYAEEffectListHolder.d(this.primaryBeautyListManager, false, 1, null);
        this.primaryBeautyListManager.i();
    }

    private final void k() {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(getContext(), R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(R.string.y1p);
        qQCustomDialog.setMessage("");
        qQCustomDialog.setNegativeButton(R.string.y0p, new DialogInterface.OnClickListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.bc
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DYAEBeautyProviderView.l(dialogInterface, i3);
            }
        });
        qQCustomDialog.setPositiveButton(R.string.y0z, new DialogInterface.OnClickListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.bd
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DYAEBeautyProviderView.m(DYAEBeautyProviderView.this, dialogInterface, i3);
            }
        });
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(DYAEBeautyProviderView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AEBeautyProviderViewModel aEBeautyProviderViewModel = this$0.beautyViewModel;
        if (aEBeautyProviderViewModel != null) {
            aEBeautyProviderViewModel.Q1();
        }
        this$0.B();
    }

    private final void n() {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(getContext(), R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(R.string.y1q);
        qQCustomDialog.setMessage("");
        qQCustomDialog.setNegativeButton(R.string.y0p, new DialogInterface.OnClickListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.ba
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DYAEBeautyProviderView.p(dialogInterface, i3);
            }
        });
        qQCustomDialog.setPositiveButton(R.string.y0z, new DialogInterface.OnClickListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.bb
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DYAEBeautyProviderView.o(DYAEBeautyProviderView.this, dialogInterface, i3);
            }
        });
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(DYAEBeautyProviderView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AEBeautyProviderViewModel aEBeautyProviderViewModel = this$0.beautyViewModel;
        if (aEBeautyProviderViewModel != null) {
            aEBeautyProviderViewModel.i2();
        }
        this$0.C();
    }

    private final void r() {
        MutableLiveData<f> X1;
        MutableLiveData<b> T1;
        LiveData<BeautySecondarySelectedWrapper> Z1;
        LiveData<b> a26;
        LiveData<List<b>> U1;
        AEPituCameraUnit aEPituCameraUnit = this.lifecycleOwner;
        if (aEPituCameraUnit != null) {
            AEBeautyProviderViewModel aEBeautyProviderViewModel = (AEBeautyProviderViewModel) com.tencent.aelight.camera.ae.n.a(aEPituCameraUnit).get(AEBeautyProviderViewModel.class);
            this.beautyViewModel = aEBeautyProviderViewModel;
            if (aEBeautyProviderViewModel != null && (U1 = aEBeautyProviderViewModel.U1()) != null) {
                U1.observe(aEPituCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.av
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DYAEBeautyProviderView.s(DYAEBeautyProviderView.this, (List) obj);
                    }
                });
            }
            AEBeautyProviderViewModel aEBeautyProviderViewModel2 = this.beautyViewModel;
            if (aEBeautyProviderViewModel2 != null && (a26 = aEBeautyProviderViewModel2.a2()) != null) {
                a26.observe(aEPituCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.aw
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DYAEBeautyProviderView.t(DYAEBeautyProviderView.this, (b) obj);
                    }
                });
            }
            AEBeautyProviderViewModel aEBeautyProviderViewModel3 = this.beautyViewModel;
            if (aEBeautyProviderViewModel3 != null && (Z1 = aEBeautyProviderViewModel3.Z1()) != null) {
                Z1.observe(aEPituCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.ax
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DYAEBeautyProviderView.u(DYAEBeautyProviderView.this, (BeautySecondarySelectedWrapper) obj);
                    }
                });
            }
            AEBeautyProviderViewModel aEBeautyProviderViewModel4 = this.beautyViewModel;
            if (aEBeautyProviderViewModel4 != null && (T1 = aEBeautyProviderViewModel4.T1()) != null) {
                T1.observe(aEPituCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.ay
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DYAEBeautyProviderView.v(DYAEBeautyProviderView.this, (b) obj);
                    }
                });
            }
            AEBeautyProviderViewModel aEBeautyProviderViewModel5 = this.beautyViewModel;
            if (aEBeautyProviderViewModel5 == null || (X1 = aEBeautyProviderViewModel5.X1()) == null) {
                return;
            }
            X1.observe(aEPituCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.az
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DYAEBeautyProviderView.w(DYAEBeautyProviderView.this, (f) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(DYAEBeautyProviderView this$0, List configs) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DYAEEffectListHolder dYAEEffectListHolder = this$0.primaryBeautyListManager;
        Intrinsics.checkNotNullExpressionValue(configs, "configs");
        List list = configs;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new ar((b) it.next()));
        }
        dYAEEffectListHolder.j(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(DYAEBeautyProviderView this$0, b bVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bVar.getType() == BeautyItem.NONE.getType()) {
            this$0.primaryBeautyListManager.m();
            return;
        }
        DYAEEffectListHolder dYAEEffectListHolder = this$0.primaryBeautyListManager;
        BeautyRealConfig.TYPE type = bVar.getType();
        DYAEEffectListHolder.l(dYAEEffectListHolder, type != null ? Integer.valueOf(type.ordinal()).toString() : null, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(DYAEBeautyProviderView this$0, BeautySecondarySelectedWrapper beautySecondarySelectedWrapper) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DYAEEffectListHolder.d(this$0.primaryBeautyListManager, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(DYAEBeautyProviderView this$0, b bVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DYAEEffectListHolder.d(this$0.primaryBeautyListManager, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(DYAEBeautyProviderView this$0, f fVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DYAEEffectListHolder.d(this$0.primaryBeautyListManager, false, 1, null);
    }

    public final void A() {
        AEBeautyProviderViewModel aEBeautyProviderViewModel = this.beautyViewModel;
        if (aEBeautyProviderViewModel != null) {
            aEBeautyProviderViewModel.f2();
        }
        D();
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectListHolder.b
    public void b(bj item, int position) {
        String str;
        Intrinsics.checkNotNullParameter(item, "item");
        if (bk.a(item)) {
            k();
            return;
        }
        if (item instanceof ar) {
            b beautyConfig = ((ar) item).getBeautyConfig();
            if (beautyConfig.getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String() == BeautyItem.RESET) {
                n();
                return;
            }
            AEBeautyProviderViewModel aEBeautyProviderViewModel = this.beautyViewModel;
            if (aEBeautyProviderViewModel != null) {
                aEBeautyProviderViewModel.j2(beautyConfig);
            }
            String key = beautyConfig.getKey();
            AEProviderViewModel.Companion companion = AEProviderViewModel.INSTANCE;
            int b16 = companion.b(beautyConfig);
            f p16 = companion.p(beautyConfig);
            com.tencent.aelight.camera.ae.report.b b17 = com.tencent.aelight.camera.ae.report.b.b();
            if (p16 == null || (str = p16.getName()) == null) {
                str = "";
            }
            b17.Q(key, str, b16);
        }
    }

    public final void q() {
        this.primaryBeautyListManager.k(null, false);
    }

    public final void setControllerAndManager(AECaptureController controller, com.tencent.aelight.camera.ae.part.c partManager) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(partManager, "partManager");
        this.controller = controller;
        this.partManager = partManager;
        this.lifecycleOwner = (AEPituCameraUnit) partManager.b(65537, new Object[0]);
        r();
    }

    public final void z() {
        D();
    }

    public final void x() {
    }

    public final void y() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(DialogInterface dialogInterface, int i3) {
    }
}

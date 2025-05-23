package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectListHolder;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0003R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEBodyProviderView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListHolder$b;", "", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "g", "Lcom/tencent/aelight/camera/ae/camera/ui/AECaptureController;", "controller", "Lcom/tencent/aelight/camera/ae/part/c;", "partManager", "setControllerAndManager", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "b", "p", "o", DomainData.DOMAIN_NAME, "Lcom/tencent/aelight/camera/ae/AEPituCameraUnit;", "d", "Lcom/tencent/aelight/camera/ae/AEPituCameraUnit;", "lifecycleOwner", "e", "Lcom/tencent/aelight/camera/ae/camera/ui/AECaptureController;", "f", "Lcom/tencent/aelight/camera/ae/part/c;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBodyProviderViewModel;", tl.h.F, "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBodyProviderViewModel;", "bodyViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListHolder;", "i", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListHolder;", "primaryBeautyListManager", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class DYAEBodyProviderView extends FrameLayout implements DYAEEffectListHolder.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AEPituCameraUnit lifecycleOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AECaptureController controller;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aelight.camera.ae.part.c partManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AEBodyProviderViewModel bodyViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final DYAEEffectListHolder primaryBeautyListManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DYAEBodyProviderView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.primaryBeautyListManager = new DYAEEffectListHolder(context, this, this, 0, 8, null);
    }

    private final void g() {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(getContext(), R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(R.string.y1r);
        qQCustomDialog.setMessage("");
        qQCustomDialog.setNegativeButton(R.string.y0p, new DialogInterface.OnClickListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.bh
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DYAEBodyProviderView.h(dialogInterface, i3);
            }
        });
        qQCustomDialog.setPositiveButton(R.string.y0z, new DialogInterface.OnClickListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.bi
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DYAEBodyProviderView.i(DYAEBodyProviderView.this, dialogInterface, i3);
            }
        });
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(DYAEBodyProviderView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AEBodyProviderViewModel aEBodyProviderViewModel = this$0.bodyViewModel;
        if (aEBodyProviderViewModel != null) {
            aEBodyProviderViewModel.Q1();
        }
    }

    private final void j() {
        MutableLiveData<b> R1;
        LiveData<b> U1;
        LiveData<List<b>> S1;
        AEPituCameraUnit aEPituCameraUnit = this.lifecycleOwner;
        if (aEPituCameraUnit != null) {
            AEBodyProviderViewModel aEBodyProviderViewModel = (AEBodyProviderViewModel) com.tencent.aelight.camera.ae.n.a(aEPituCameraUnit).get(AEBodyProviderViewModel.class);
            this.bodyViewModel = aEBodyProviderViewModel;
            if (aEBodyProviderViewModel != null && (S1 = aEBodyProviderViewModel.S1()) != null) {
                S1.observe(aEPituCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.be
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DYAEBodyProviderView.k(DYAEBodyProviderView.this, (List) obj);
                    }
                });
            }
            AEBodyProviderViewModel aEBodyProviderViewModel2 = this.bodyViewModel;
            if (aEBodyProviderViewModel2 != null && (U1 = aEBodyProviderViewModel2.U1()) != null) {
                U1.observe(aEPituCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.bf
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DYAEBodyProviderView.l(DYAEBodyProviderView.this, (b) obj);
                    }
                });
            }
            AEBodyProviderViewModel aEBodyProviderViewModel3 = this.bodyViewModel;
            if (aEBodyProviderViewModel3 == null || (R1 = aEBodyProviderViewModel3.R1()) == null) {
                return;
            }
            R1.observe(aEPituCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.bg
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DYAEBodyProviderView.m(DYAEBodyProviderView.this, (b) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(DYAEBodyProviderView this$0, List configs) {
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
    public static final void l(DYAEBodyProviderView this$0, b bVar) {
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
    public static final void m(DYAEBodyProviderView this$0, b bVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DYAEEffectListHolder.d(this$0.primaryBeautyListManager, false, 1, null);
    }

    private final void q() {
        DYAEEffectListHolder.d(this.primaryBeautyListManager, false, 1, null);
        this.primaryBeautyListManager.i();
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectListHolder.b
    public void b(bj item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (bk.a(item)) {
            g();
            return;
        }
        if (item instanceof ar) {
            b beautyConfig = ((ar) item).getBeautyConfig();
            if (beautyConfig.getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String() == BeautyItem.RESET) {
                return;
            }
            AEBodyProviderViewModel aEBodyProviderViewModel = this.bodyViewModel;
            if (aEBodyProviderViewModel != null) {
                aEBodyProviderViewModel.a2(beautyConfig);
            }
            com.tencent.aelight.camera.ae.report.b.b().T(beautyConfig.getKey(), AEProviderViewModel.INSTANCE.b(beautyConfig));
        }
    }

    public final void o() {
        q();
    }

    public final void p() {
        AEBodyProviderViewModel aEBodyProviderViewModel = this.bodyViewModel;
        if (aEBodyProviderViewModel != null) {
            aEBodyProviderViewModel.X1();
        }
        q();
    }

    public final void setControllerAndManager(AECaptureController controller, com.tencent.aelight.camera.ae.part.c partManager) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(partManager, "partManager");
        this.controller = controller;
        this.partManager = partManager;
        this.lifecycleOwner = (AEPituCameraUnit) partManager.b(65537, new Object[0]);
        j();
    }

    public final void n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(DialogInterface dialogInterface, int i3) {
    }
}

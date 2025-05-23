package com.tencent.aelight.camera.ae.flashshow.ui.panel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBodyProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautyItem;
import com.tencent.aelight.camera.ae.camera.ui.panel.ar;
import com.tencent.aelight.camera.ae.camera.ui.panel.bj;
import com.tencent.aelight.camera.ae.camera.ui.panel.bk;
import com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.ui.LSCaptureController;
import com.tencent.aelight.camera.ae.flashshow.ui.panel.LSEffectListHolder;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010%\u001a\u00020\u000e\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0003R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006("}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/LSBodyProviderView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/LSEffectListHolder$b;", "", "j", "p", "g", "Lcom/tencent/aelight/camera/ae/flashshow/ui/LSCaptureController;", "controller", "Llq/b;", "partManager", "setControllerAndManager", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "b", "o", DomainData.DOMAIN_NAME, "Lcom/tencent/aelight/camera/ae/flashshow/AEFlashShowCameraUnit;", "d", "Lcom/tencent/aelight/camera/ae/flashshow/AEFlashShowCameraUnit;", "lifecycleOwner", "e", "Lcom/tencent/aelight/camera/ae/flashshow/ui/LSCaptureController;", "f", "Llq/b;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBodyProviderViewModel;", tl.h.F, "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBodyProviderViewModel;", "bodyViewModel", "Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/LSEffectListHolder;", "i", "Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/LSEffectListHolder;", "primaryBeautyListManager", "Landroid/content/Context;", "context", "rightBeautyBtnMode", "<init>", "(Landroid/content/Context;I)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class LSBodyProviderView extends FrameLayout implements LSEffectListHolder.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AEFlashShowCameraUnit lifecycleOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LSCaptureController controller;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private lq.b partManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AEBodyProviderViewModel bodyViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final LSEffectListHolder primaryBeautyListManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LSBodyProviderView(Context context, int i3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.primaryBeautyListManager = new LSEffectListHolder(context, this, this, i3);
    }

    private final void g() {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(getContext(), R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(R.string.y1r);
        qQCustomDialog.setMessage("");
        qQCustomDialog.setNegativeButton(R.string.y0p, new DialogInterface.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                LSBodyProviderView.h(dialogInterface, i3);
            }
        });
        qQCustomDialog.setPositiveButton(R.string.y0z, new DialogInterface.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.u
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                LSBodyProviderView.i(LSBodyProviderView.this, dialogInterface, i3);
            }
        });
        qQCustomDialog.setCanceledOnTouchOutside(false);
        if (getContext() != null && (getContext() instanceof Activity)) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            if (((Activity) context).isFinishing()) {
                return;
            }
            Context context2 = getContext();
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
            if (((Activity) context2).isDestroyed()) {
                return;
            }
        }
        qQCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(LSBodyProviderView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AEBodyProviderViewModel aEBodyProviderViewModel = this$0.bodyViewModel;
        if (aEBodyProviderViewModel != null) {
            aEBodyProviderViewModel.Q1();
        }
    }

    private final void j() {
        MutableLiveData<com.tencent.aelight.camera.ae.camera.ui.panel.b> R1;
        LiveData<com.tencent.aelight.camera.ae.camera.ui.panel.b> U1;
        LiveData<List<com.tencent.aelight.camera.ae.camera.ui.panel.b>> S1;
        AEFlashShowCameraUnit aEFlashShowCameraUnit = this.lifecycleOwner;
        if (aEFlashShowCameraUnit != null) {
            AEBodyProviderViewModel aEBodyProviderViewModel = (AEBodyProviderViewModel) com.tencent.aelight.camera.ae.n.a(aEFlashShowCameraUnit).get(AEBodyProviderViewModel.class);
            this.bodyViewModel = aEBodyProviderViewModel;
            if (aEBodyProviderViewModel != null && (S1 = aEBodyProviderViewModel.S1()) != null) {
                S1.observe(aEFlashShowCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.q
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        LSBodyProviderView.k(LSBodyProviderView.this, (List) obj);
                    }
                });
            }
            AEBodyProviderViewModel aEBodyProviderViewModel2 = this.bodyViewModel;
            if (aEBodyProviderViewModel2 != null && (U1 = aEBodyProviderViewModel2.U1()) != null) {
                U1.observe(aEFlashShowCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.r
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        LSBodyProviderView.l(LSBodyProviderView.this, (com.tencent.aelight.camera.ae.camera.ui.panel.b) obj);
                    }
                });
            }
            AEBodyProviderViewModel aEBodyProviderViewModel3 = this.bodyViewModel;
            if (aEBodyProviderViewModel3 == null || (R1 = aEBodyProviderViewModel3.R1()) == null) {
                return;
            }
            R1.observe(aEFlashShowCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.s
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    LSBodyProviderView.m(LSBodyProviderView.this, (com.tencent.aelight.camera.ae.camera.ui.panel.b) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(LSBodyProviderView this$0, List configs) {
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
    public static final void l(LSBodyProviderView this$0, com.tencent.aelight.camera.ae.camera.ui.panel.b bVar) {
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
    public static final void m(LSBodyProviderView this$0, com.tencent.aelight.camera.ae.camera.ui.panel.b bVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LSEffectListHolder.d(this$0.primaryBeautyListManager, false, 1, null);
    }

    private final void p() {
        LSEffectListHolder.d(this.primaryBeautyListManager, false, 1, null);
        this.primaryBeautyListManager.i();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.panel.LSEffectListHolder.b
    public void b(bj item, int position) {
        AEBodyProviderViewModel aEBodyProviderViewModel;
        Intrinsics.checkNotNullParameter(item, "item");
        if (bk.a(item)) {
            g();
            return;
        }
        if (item instanceof ar) {
            com.tencent.aelight.camera.ae.camera.ui.panel.b beautyConfig = ((ar) item).getBeautyConfig();
            if (beautyConfig.getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String() == BeautyItem.RESET || (aEBodyProviderViewModel = this.bodyViewModel) == null) {
                return;
            }
            aEBodyProviderViewModel.a2(beautyConfig);
        }
    }

    public final void o() {
        p();
    }

    public final void setControllerAndManager(LSCaptureController controller, lq.b partManager) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(partManager, "partManager");
        this.controller = controller;
        this.partManager = partManager;
        this.lifecycleOwner = (AEFlashShowCameraUnit) partManager.b(65537, new Object[0]);
        j();
    }

    public final void n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(DialogInterface dialogInterface, int i3) {
    }
}

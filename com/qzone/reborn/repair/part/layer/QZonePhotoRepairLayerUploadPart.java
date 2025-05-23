package com.qzone.reborn.repair.part.layer;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.reborn.repair.bean.QZoneRepairTaskStateBean;
import com.qzone.reborn.repair.viewmodel.QZonePhotoRepairLayerViewModel;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0019\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/repair/part/layer/QZonePhotoRepairLayerUploadPart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "", "initViewModel", "", "status", "G9", "(Ljava/lang/Integer;)V", "B9", "D9", "Lcom/qzone/reborn/repair/bean/QZoneRepairTaskStateBean;", "taskBean", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "d", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mUploadBtn", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "e", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "mPhotoRepairViewModel", "", "f", "Z", "mCanAutoShowShareAction", "<init>", "()V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePhotoRepairLayerUploadPart extends RFWLayerBasePart {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QUIButton mUploadBtn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZonePhotoRepairLayerViewModel mPhotoRepairViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mCanAutoShowShareAction;

    private final void B9() {
        fo.b j3 = new fo.b().k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE);
        QUIButton qUIButton = this.mUploadBtn;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUploadBtn");
            qUIButton = null;
        }
        fo.c.o(qUIButton, "em_qz_upload", j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(QZonePhotoRepairLayerUploadPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void F9(QZoneRepairTaskStateBean taskBean) {
        if (lc.b.d()) {
            a9.f.f25725a.c().i(new zn.c(taskBean));
        } else {
            SimpleEventBus.getInstance().registerReceiver(new zn.c(taskBean));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(Integer status) {
        if (this.mCanAutoShowShareAction && status != null && status.intValue() == 2) {
            QLog.i("QZonePhotoRepairLayerUploadPart", 1, "[showUploadPicSuccess] success");
            this.mCanAutoShowShareAction = false;
            com.qzone.reborn.util.i.b().l("auto_show_share_action", false);
            xn.b bVar = (xn.b) PartIOCKt.getIocInterface(this, xn.b.class);
            if (bVar != null) {
                bVar.j4();
            }
        }
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(QZonePhotoRepairLayerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZonePhotoR\u2026yerViewModel::class.java)");
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel = (QZonePhotoRepairLayerViewModel) viewModel;
        this.mPhotoRepairViewModel = qZonePhotoRepairLayerViewModel;
        if (qZonePhotoRepairLayerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
            qZonePhotoRepairLayerViewModel = null;
        }
        MutableLiveData<QZonePhotoRepairLayerViewModel.Companion.RepairStatusData> n26 = qZonePhotoRepairLayerViewModel.n2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<QZonePhotoRepairLayerViewModel.Companion.RepairStatusData, Unit> function1 = new Function1<QZonePhotoRepairLayerViewModel.Companion.RepairStatusData, Unit>() { // from class: com.qzone.reborn.repair.part.layer.QZonePhotoRepairLayerUploadPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QZonePhotoRepairLayerViewModel.Companion.RepairStatusData repairStatusData) {
                invoke2(repairStatusData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QZonePhotoRepairLayerViewModel.Companion.RepairStatusData repairStatusData) {
                QZonePhotoRepairLayerUploadPart.this.G9(repairStatusData.getStatus());
            }
        };
        n26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.repair.part.layer.aj
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZonePhotoRepairLayerUploadPart.C9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.nar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026zone_repair_layer_upload)");
        QUIButton qUIButton = (QUIButton) findViewById;
        this.mUploadBtn = qUIButton;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUploadBtn");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.repair.part.layer.ai
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZonePhotoRepairLayerUploadPart.E9(QZonePhotoRepairLayerUploadPart.this, view);
            }
        });
        initViewModel();
        B9();
    }

    private final void D9() {
        String str;
        this.mCanAutoShowShareAction = com.qzone.reborn.util.i.b().d("auto_show_share_action", true);
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel = this.mPhotoRepairViewModel;
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel2 = null;
        if (qZonePhotoRepairLayerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
            qZonePhotoRepairLayerViewModel = null;
        }
        String srUrl = qZonePhotoRepairLayerViewModel.k2().getSrUrl();
        if (TextUtils.isEmpty(srUrl)) {
            QLog.e("QZonePhotoRepairLayerUploadPart", 1, "[onHandleClickUploadView] srUrl is null");
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (URLUtil.isNetworkUrl(srUrl)) {
            IPicLoader c16 = com.tencent.mobileqq.qzone.picload.c.a().c();
            str = c16 != null ? c16.getPicLocalPath(Option.obtain().setUrl(srUrl)) : null;
        } else {
            str = srUrl;
        }
        if (!TextUtils.isEmpty(str)) {
            Intrinsics.checkNotNull(str);
            arrayList.add(str);
        }
        Context context = getContext();
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel3 = this.mPhotoRepairViewModel;
        if (qZonePhotoRepairLayerViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
            qZonePhotoRepairLayerViewModel3 = null;
        }
        Intent F = com.qzone.common.activities.base.ak.F(context, 0, null, null, qZonePhotoRepairLayerViewModel3.k2().getAlbumId(), null, null, "uploadphoto", 12);
        boolean z16 = !URLUtil.isNetworkUrl(srUrl);
        F.putStringArrayListExtra("QZoneUploadPhotoActivity.key_selected_image_path", arrayList);
        F.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, 7);
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel4 = this.mPhotoRepairViewModel;
        if (qZonePhotoRepairLayerViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
            qZonePhotoRepairLayerViewModel4 = null;
        }
        F.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_REPAIR_SR_TASK_ID, qZonePhotoRepairLayerViewModel4.k2().getTaskId());
        F.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_REPAIR_SR_URL, srUrl);
        F.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_SR_BY_OPR, z16);
        F.putExtra("IsBack", true);
        if (z16) {
            QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel5 = this.mPhotoRepairViewModel;
            if (qZonePhotoRepairLayerViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
                qZonePhotoRepairLayerViewModel5 = null;
            }
            F9(qZonePhotoRepairLayerViewModel5.k2());
        }
        if (lc.b.d()) {
            String uinString = LoginData.getInstance().getUinString();
            Intrinsics.checkNotNullExpressionValue(uinString, "getInstance().uinString");
            ho.i.x().l(getContext(), new QZAlbumxUploadAlbumInitBean(uinString, 0, false, null, 0), F);
            return;
        }
        QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
        qZonePublishMoodInitBean.I0(0);
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel6 = this.mPhotoRepairViewModel;
        if (qZonePhotoRepairLayerViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
            qZonePhotoRepairLayerViewModel6 = null;
        }
        qZonePublishMoodInitBean.l0(qZonePhotoRepairLayerViewModel6.k2().getAlbumId());
        qZonePublishMoodInitBean.C0("uploadphoto");
        qZonePublishMoodInitBean.O0(12);
        qZonePublishMoodInitBean.v0(Boolean.FALSE);
        qZonePublishMoodInitBean.P0(UUID.randomUUID().toString());
        qZonePublishMoodInitBean.Q0(com.qzone.reborn.util.l.f59550a.j(12));
        qZonePublishMoodInitBean.t0(7);
        qZonePublishMoodInitBean.F0(arrayList);
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel7 = this.mPhotoRepairViewModel;
        if (qZonePhotoRepairLayerViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
        } else {
            qZonePhotoRepairLayerViewModel2 = qZonePhotoRepairLayerViewModel7;
        }
        qZonePublishMoodInitBean.D0(qZonePhotoRepairLayerViewModel2.k2().getTaskId());
        qZonePublishMoodInitBean.E0(srUrl);
        qZonePublishMoodInitBean.z0(Boolean.valueOf(z16));
        ho.i.w().h(getContext(), qZonePublishMoodInitBean, F);
    }
}

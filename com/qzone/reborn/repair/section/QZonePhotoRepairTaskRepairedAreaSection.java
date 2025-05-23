package com.qzone.reborn.repair.section;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.reborn.base.l;
import com.qzone.reborn.repair.bean.QZoneRepairTaskStateBean;
import com.qzone.reborn.repair.utils.QZonePhotoRepairTaskQueueManger;
import com.qzone.reborn.repair.viewmodel.i;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.LoadingUtil;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00012B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J*\u0010\u0018\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0014J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R#\u0010/\u001a\n **\u0004\u0018\u00010)0)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcom/qzone/reborn/repair/section/QZonePhotoRepairTaskRepairedAreaSection;", "Lcom/qzone/reborn/base/l;", "Lwn/d;", "Lxn/d;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "w", "Lcom/qzone/reborn/repair/bean/QZoneRepairTaskStateBean;", "taskBean", "y", BdhLogUtil.LogTag.Tag_Conn, "D", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B3", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvUploadBtn", "Lcom/qzone/reborn/repair/viewmodel/i;", "f", "Lcom/qzone/reborn/repair/viewmodel/i;", "taskListViewModel", h.F, "Lcom/qzone/reborn/repair/bean/QZoneRepairTaskStateBean;", "repairingTaskBean", "i", "Z", "isRepairingByOpr", "Landroid/app/Dialog;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", HippyTKDListViewAdapter.X, "()Landroid/app/Dialog;", "repairDialog", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePhotoRepairTaskRepairedAreaSection extends l<wn.d> implements xn.d {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvUploadBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private i taskListViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneRepairTaskStateBean repairingTaskBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isRepairingByOpr;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy repairDialog;

    public QZonePhotoRepairTaskRepairedAreaSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Dialog>() { // from class: com.qzone.reborn.repair.section.QZonePhotoRepairTaskRepairedAreaSection$repairDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Dialog invoke() {
                Activity p16;
                p16 = QZonePhotoRepairTaskRepairedAreaSection.this.p();
                return LoadingUtil.showLoadingDialog(p16, "\u4e0a\u4f20\u4e2d", false);
            }
        });
        this.repairDialog = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void B(QZonePhotoRepairTaskRepairedAreaSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.w()) {
            QZoneRepairTaskStateBean qZoneRepairTaskStateBean = new QZoneRepairTaskStateBean(null, 1, null);
            String str = ((wn.d) this$0.mData).getRsTask().task_id.get();
            Intrinsics.checkNotNullExpressionValue(str, "mData.rsTask.task_id.get()");
            qZoneRepairTaskStateBean.setTaskId(str);
            String str2 = ((wn.d) this$0.mData).getRsTask().album_id.get();
            Intrinsics.checkNotNullExpressionValue(str2, "mData.rsTask.album_id.get()");
            qZoneRepairTaskStateBean.setAlbumId(str2);
            String str3 = ((wn.d) this$0.mData).getRsTask().lloc.get();
            Intrinsics.checkNotNullExpressionValue(str3, "mData.rsTask.lloc.get()");
            qZoneRepairTaskStateBean.setLloc(str3);
            String str4 = ((wn.d) this$0.mData).getRsTask().src_url.get();
            Intrinsics.checkNotNullExpressionValue(str4, "mData.rsTask.src_url.get()");
            qZoneRepairTaskStateBean.setSrOriginUrl(str4);
            qZoneRepairTaskStateBean.setSrStatus(Integer.valueOf(((wn.d) this$0.mData).getRsTask().status.get()));
            String str5 = ((wn.d) this$0.mData).getRsTask().sr_url.get();
            Intrinsics.checkNotNullExpressionValue(str5, "mData.rsTask.sr_url.get()");
            qZoneRepairTaskStateBean.setSrUrl(str5);
            this$0.y(qZoneRepairTaskStateBean);
        } else {
            this$0.D();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void C(QZoneRepairTaskStateBean taskBean) {
        if (lc.b.d()) {
            a9.f.f25725a.c().i(new zn.c(taskBean));
        } else {
            SimpleEventBus.getInstance().registerReceiver(new zn.c(taskBean));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void D() {
        if (this.isRepairingByOpr) {
            QLog.i("QZonePhotoRepairTaskRepairedAreaSection", 1, "[repairPhotoAndUpload] isRepairing");
            return;
        }
        this.isRepairingByOpr = true;
        QZoneRepairTaskStateBean qZoneRepairTaskStateBean = new QZoneRepairTaskStateBean(null, 1, null);
        String str = ((wn.d) this.mData).getRsTask().task_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "mData.rsTask.task_id.get()");
        qZoneRepairTaskStateBean.setTaskId(str);
        String str2 = ((wn.d) this.mData).getRsTask().album_id.get();
        Intrinsics.checkNotNullExpressionValue(str2, "mData.rsTask.album_id.get()");
        qZoneRepairTaskStateBean.setAlbumId(str2);
        String str3 = ((wn.d) this.mData).getRsTask().lloc.get();
        Intrinsics.checkNotNullExpressionValue(str3, "mData.rsTask.lloc.get()");
        qZoneRepairTaskStateBean.setLloc(str3);
        String str4 = ((wn.d) this.mData).getRsTask().src_url.get();
        Intrinsics.checkNotNullExpressionValue(str4, "mData.rsTask.src_url.get()");
        qZoneRepairTaskStateBean.setSrOriginUrl(str4);
        qZoneRepairTaskStateBean.setSilentRepair(true);
        QZonePhotoRepairTaskQueueManger.Companion companion = QZonePhotoRepairTaskQueueManger.INSTANCE;
        companion.a().I(this);
        companion.a().O(qZoneRepairTaskStateBean);
        Dialog x16 = x();
        if (x16 != null) {
            ef.d.f(x16, p());
        }
        this.repairingTaskBean = qZoneRepairTaskStateBean;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean w() {
        return !TextUtils.isEmpty(((wn.d) this.mData).getRsTask().sr_url.get());
    }

    private final Dialog x() {
        return (Dialog) this.repairDialog.getValue();
    }

    private final void y(QZoneRepairTaskStateBean taskBean) {
        String srUrl = taskBean.getSrUrl();
        if (TextUtils.isEmpty(srUrl)) {
            QLog.e("QZonePhotoRepairTaskRepairedAreaSection", 1, "[onHandleClickUploadView] srUrl is null");
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        String d16 = URLUtil.isNetworkUrl(srUrl) ? com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(srUrl)) : srUrl;
        if (!TextUtils.isEmpty(d16)) {
            arrayList.add(d16);
        }
        QLog.i("QZonePhotoRepairTaskRepairedAreaSection", 1, "[onHandleClickUploadView] srLocalPath=" + d16);
        Intent F = ak.F(p(), 0, null, null, taskBean.getAlbumId(), null, null, "uploadphoto", 12);
        boolean isNetworkUrl = URLUtil.isNetworkUrl(srUrl) ^ true;
        F.putStringArrayListExtra("QZoneUploadPhotoActivity.key_selected_image_path", arrayList);
        F.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, 7);
        F.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_REPAIR_SR_TASK_ID, taskBean.getTaskId());
        F.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_REPAIR_SR_URL, srUrl);
        F.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_SR_BY_OPR, isNetworkUrl);
        F.putExtra("IsBack", true);
        if (isNetworkUrl) {
            C(taskBean);
        }
        if (lc.b.d()) {
            String uinString = LoginData.getInstance().getUinString();
            Intrinsics.checkNotNullExpressionValue(uinString, "getInstance().uinString");
            ho.i.x().l(p(), new QZAlbumxUploadAlbumInitBean(uinString, 0, false, null, 0), F);
            return;
        }
        QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
        qZonePublishMoodInitBean.I0(0);
        qZonePublishMoodInitBean.l0(taskBean.getAlbumId());
        qZonePublishMoodInitBean.C0("uploadphoto");
        qZonePublishMoodInitBean.O0(12);
        qZonePublishMoodInitBean.v0(Boolean.FALSE);
        qZonePublishMoodInitBean.P0(UUID.randomUUID().toString());
        qZonePublishMoodInitBean.Q0(com.qzone.reborn.util.l.f59550a.j(12));
        qZonePublishMoodInitBean.t0(7);
        qZonePublishMoodInitBean.F0(arrayList);
        qZonePublishMoodInitBean.D0(taskBean.getTaskId());
        qZonePublishMoodInitBean.E0(srUrl);
        qZonePublishMoodInitBean.z0(Boolean.valueOf(isNetworkUrl));
        ho.i.w().h(p(), qZonePublishMoodInitBean, F);
    }

    private final void z() {
        ViewModel t16 = t(i.class);
        Intrinsics.checkNotNullExpressionValue(t16, "getViewModel(QZonePhotoR\u2026istViewModel::class.java)");
        this.taskListViewModel = (i) t16;
    }

    @Override // xn.d
    public void B3(QZoneRepairTaskStateBean taskBean) {
        Intrinsics.checkNotNullParameter(taskBean, "taskBean");
        QZoneRepairTaskStateBean qZoneRepairTaskStateBean = this.repairingTaskBean;
        if (Intrinsics.areEqual(qZoneRepairTaskStateBean != null ? qZoneRepairTaskStateBean.getTaskId() : null, taskBean.getTaskId())) {
            QZoneRepairTaskStateBean qZoneRepairTaskStateBean2 = this.repairingTaskBean;
            if (Intrinsics.areEqual(qZoneRepairTaskStateBean2 != null ? qZoneRepairTaskStateBean2.getSrOriginUrl() : null, taskBean.getSrOriginUrl())) {
                if (p() != null && !p().isFinishing()) {
                    QZoneRepairTaskStateBean qZoneRepairTaskStateBean3 = this.repairingTaskBean;
                    if (qZoneRepairTaskStateBean3 == null) {
                        return;
                    }
                    try {
                        Integer srStatus = taskBean.getSrStatus();
                        if (srStatus != null && srStatus.intValue() == 3) {
                            QLog.e("QZonePhotoRepairTaskRepairedAreaSection", 1, "[onStateChange] repair fail, taskBean=" + taskBean);
                            this.isRepairingByOpr = false;
                            Dialog x16 = x();
                            if (x16 != null) {
                                x16.hide();
                            }
                            return;
                        }
                        Integer srStatus2 = taskBean.getSrStatus();
                        if (srStatus2 != null && srStatus2.intValue() == 1) {
                            QLog.i("QZonePhotoRepairTaskRepairedAreaSection", 1, "[onStateChange] repair success, taskBean=" + taskBean);
                            qZoneRepairTaskStateBean3.setSrUrl(taskBean.getSrUrl());
                            y(qZoneRepairTaskStateBean3);
                            this.isRepairingByOpr = false;
                            Dialog x17 = x();
                            if (x17 != null) {
                                x17.hide();
                            }
                        }
                        return;
                    } catch (Exception e16) {
                        QLog.e("QZonePhotoRepairTaskRepairedAreaSection", 1, "[onStateChange] exception", e16);
                        return;
                    }
                }
                QLog.i("QZonePhotoRepairTaskRepairedAreaSection", 1, "[onStateChange] activity is finished");
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        QZonePhotoRepairTaskQueueManger.INSTANCE.a().P(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        z();
        View findViewById = containerView.findViewById(R.id.f196166);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.btn_upload)");
        TextView textView = (TextView) findViewById;
        this.tvUploadBtn = textView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvUploadBtn");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.repair.section.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZonePhotoRepairTaskRepairedAreaSection.B(QZonePhotoRepairTaskRepairedAreaSection.this, view);
            }
        });
        fo.b j3 = new fo.b().k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE);
        TextView textView3 = this.tvUploadBtn;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvUploadBtn");
        } else {
            textView2 = textView3;
        }
        fo.c.o(textView2, "em_qz_upload", j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nov};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindData(wn.d data, int position, List<Object> payload) {
    }
}

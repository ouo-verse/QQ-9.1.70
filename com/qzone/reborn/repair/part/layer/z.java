package com.qzone.reborn.repair.part.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import androidx.core.util.Consumer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.repair.viewmodel.QZonePhotoRepairLayerViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.util.QZonePermission;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0016\u0010\u0014\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/repair/part/layer/z;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Lxn/a;", "", "initViewModel", "G9", "", "picUrl", "H9", "filePath", "K9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "P9", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Q7", "d", "Landroid/view/View;", "mSaveView", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "e", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "mPhotoRepairViewModel", "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class z extends RFWLayerBasePart implements xn.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mSaveView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZonePhotoRepairLayerViewModel mPhotoRepairViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/repair/part/layer/z$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f59238b;

        b(String str) {
            this.f59238b = str;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            z zVar = z.this;
            String str = this.f59238b;
            Intrinsics.checkNotNull(str);
            zVar.K9(str);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/repair/part/layer/z$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f59240b;

        c(String str) {
            this.f59240b = str;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            z.this.H9(this.f59240b);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            super.onDenied(permissions, results);
            QLog.d("QZonePhotoRepairLayerSavePart", 1, "saveSrPicToLocal requestPermissions denied...");
            QQToastUtil.showQQToastInUiThread(1, "\u6ca1\u6709\u5b58\u50a8\u6743\u9650\uff0c\u4fdd\u5b58\u5931\u8d25");
        }
    }

    private final void G9() {
        fo.b j3 = new fo.b().k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE);
        View view = this.mSaveView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSaveView");
            view = null;
        }
        fo.c.o(view, "em_qz_save", j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(String picUrl) {
        QLog.d("QZonePhotoRepairLayerSavePart", 1, "doSaveActionWithPermission url:" + picUrl);
        if (TextUtils.isEmpty(picUrl)) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.repair.part.layer.v
                @Override // java.lang.Runnable
                public final void run() {
                    z.I9();
                }
            });
        } else if (URLUtil.isNetworkUrl(picUrl)) {
            tk.h.Q(getActivity(), picUrl, false);
        } else {
            tk.h.i(getActivity(), picUrl, "", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(z this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QZonePhotoRepairLayerSavePart", 1, "click saveSrPicToLocal");
        this$0.P9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(String filePath) {
        final BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        RFWSaveUtil.insertMedia(context, filePath, new Consumer() { // from class: com.qzone.reborn.repair.part.layer.x
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                z.L9(context, (RFWSaveMediaResultBean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(final Context context, final RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        Intrinsics.checkNotNullParameter(context, "$context");
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.repair.part.layer.y
            @Override // java.lang.Runnable
            public final void run() {
                z.M9(context, rFWSaveMediaResultBean);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Context context, RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        Intrinsics.checkNotNullParameter(context, "$context");
        boolean z16 = false;
        if (rFWSaveMediaResultBean != null && rFWSaveMediaResultBean.isSuccess) {
            z16 = true;
        }
        String string = context.getString(z16 ? R.string.h4_ : R.string.g2q);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     \u2026ve_fail\n                )");
        QQToastUtil.showQQToast(2, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(final z this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final String m3 = com.qzone.reborn.repair.utils.o.f59329a.m(this$0.getActivity(), bitmap);
        if (TextUtils.isEmpty(m3)) {
            QLog.e("QZonePhotoRepairLayerSavePart", 1, "filePath is null");
        } else {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.repair.part.layer.w
                @Override // java.lang.Runnable
                public final void run() {
                    z.O9(z.this, m3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(z this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.startup.permission.a.f(this$0.getActivity())) {
            QQPermissionFactory.getQQPermission(this$0.getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_PIC)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b(str));
        } else {
            Intrinsics.checkNotNull(str);
            this$0.K9(str);
        }
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(QZonePhotoRepairLayerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZonePhotoR\u2026yerViewModel::class.java)");
        this.mPhotoRepairViewModel = (QZonePhotoRepairLayerViewModel) viewModel;
    }

    public void P9() {
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel = this.mPhotoRepairViewModel;
        if (qZonePhotoRepairLayerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
            qZonePhotoRepairLayerViewModel = null;
        }
        String srUrl = qZonePhotoRepairLayerViewModel.k2().getSrUrl();
        if (!QZonePermission.requestStoragePermission(getActivity(), new c(srUrl), QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM)) {
            QLog.e("QZonePhotoRepairLayerSavePart", 1, "[MORE_SAVE] don't has store permission");
        } else {
            H9(srUrl);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        PartIOCKt.registerIoc(this, this, xn.a.class);
        View findViewById = rootView.findViewById(R.id.nac);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026.qzone_repair_layer_save)");
        this.mSaveView = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSaveView");
            findViewById = null;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.repair.part.layer.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                z.J9(z.this, view);
            }
        });
        initViewModel();
        G9();
    }

    @Override // xn.a
    public void Q7(final Bitmap bitmap) {
        if (bitmap == null) {
            QLog.e("QZonePhotoRepairLayerSavePart", 1, "bitmap is null");
        } else {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.qzone.reborn.repair.part.layer.t
                @Override // java.lang.Runnable
                public final void run() {
                    z.N9(z.this, bitmap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9() {
        QQToastUtil.showQQToast(1, R.string.f174762wq);
    }
}

package com.qzone.reborn.albumx.qzonex.part.upload;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.events.QZoneUploadPhotoPageFinishEvent;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016R#\u0010\u001a\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR#\u0010\"\u001a\n \u0015*\u0004\u0018\u00010\u001e0\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/upload/QZAlbumxUploadAlbumPart;", "Lcom/qzone/reborn/part/publish/common/uploadAlbum/QZonePublishUploadAlbumPart;", "Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", "it", "", "U9", "T9", "", "clickUpload", "Q9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "G9", "L9", "Lqc/b;", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", "S9", "()Lqc/b;", "uploadVm", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", "initBean", "Lqc/e;", BdhLogUtil.LogTag.Tag_Conn, "R9", "()Lqc/e;", "selectAlbumBarVm", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxUploadAlbumPart extends QZonePublishUploadAlbumPart {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy selectAlbumBarVm;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy uploadVm;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZAlbumxUploadAlbumInitBean initBean;

    public QZAlbumxUploadAlbumPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<qc.b>() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.QZAlbumxUploadAlbumPart$uploadVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final qc.b invoke() {
                return (qc.b) QZAlbumxUploadAlbumPart.this.getViewModel(qc.b.class);
            }
        });
        this.uploadVm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<qc.e>() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.QZAlbumxUploadAlbumPart$selectAlbumBarVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final qc.e invoke() {
                return (qc.e) QZAlbumxUploadAlbumPart.this.getViewModel(qc.e.class);
            }
        });
        this.selectAlbumBarVm = lazy2;
    }

    private final void Q9(boolean clickUpload) {
        QLog.d("QZAlbumxUploadAlbumPart", 1, "[dispatchFinishEvent] come from = " + clickUpload);
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean = this.initBean;
        if (qZAlbumxUploadAlbumInitBean == null) {
            return;
        }
        Intrinsics.checkNotNull(qZAlbumxUploadAlbumInitBean);
        if (qZAlbumxUploadAlbumInitBean.getFromType() == 8) {
            SimpleEventBus.getInstance().dispatchEvent(new QZoneUploadPhotoPageFinishEvent(clickUpload, 1), true);
        }
    }

    private final qc.e R9() {
        return (qc.e) this.selectAlbumBarVm.getValue();
    }

    private final qc.b S9() {
        return (qc.b) this.uploadVm.getValue();
    }

    private final void T9() {
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean = this.initBean;
        if (qZAlbumxUploadAlbumInitBean == null || qZAlbumxUploadAlbumInitBean.getFromType() != 3) {
            return;
        }
        U9(qZAlbumxUploadAlbumInitBean);
    }

    private final void U9(QZAlbumxUploadAlbumInitBean it) {
        String str;
        String name;
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = new QZAlbumxAlbumDetailInitBean(it.getUin());
        CommonAlbumInfo albumInfo = it.getAlbumInfo();
        String str2 = "";
        if (albumInfo == null || (str = albumInfo.getAlbumId()) == null) {
            str = "";
        }
        qZAlbumxAlbumDetailInitBean.setAlbumId(str);
        CommonAlbumInfo albumInfo2 = it.getAlbumInfo();
        if (albumInfo2 != null && (name = albumInfo2.getName()) != null) {
            str2 = name;
        }
        qZAlbumxAlbumDetailInitBean.setAlbumName(str2);
        vb.b x16 = ho.i.x();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        x16.g(activity, qZAlbumxAlbumDetailInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart
    public void G9() {
        qc.b S9 = S9();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        com.qzone.reborn.part.publish.common.inputarea.d inputAreaVm = H9();
        Intrinsics.checkNotNullExpressionValue(inputAreaVm, "inputAreaVm");
        sl.b locationVm = I9();
        Intrinsics.checkNotNullExpressionValue(locationVm, "locationVm");
        qc.e selectAlbumBarVm = R9();
        Intrinsics.checkNotNullExpressionValue(selectAlbumBarVm, "selectAlbumBarVm");
        tl.h mediaPickerVm = J9();
        Intrinsics.checkNotNullExpressionValue(mediaPickerVm, "mediaPickerVm");
        if (S9.R1(context, inputAreaVm, locationVm, selectAlbumBarVm, mediaPickerVm)) {
            T9();
            getActivity().setResult(-1);
            getPartHost().getHostActivity().finish();
        }
        Q9(true);
    }

    @Override // com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart
    public void L9() {
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean = this.initBean;
        if (qZAlbumxUploadAlbumInitBean != null) {
            if (qZAlbumxUploadAlbumInitBean.getFromType() == 3) {
                U9(qZAlbumxUploadAlbumInitBean);
            }
            Q9(false);
        }
    }

    @Override // com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        LiveData<String> d26 = S9().d2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.QZAlbumxUploadAlbumPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                QQToast.makeText(QZAlbumxUploadAlbumPart.this.getContext(), str, 1, 0).show();
            }
        };
        d26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxUploadAlbumPart.V9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        super.onPartCreate(activity, savedInstanceState);
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean = (activity == null || (intent = activity.getIntent()) == null) ? null : (QZAlbumxUploadAlbumInitBean) intent.getParcelableExtra("key_bundle_common_init_bean");
        this.initBean = qZAlbumxUploadAlbumInitBean instanceof QZAlbumxUploadAlbumInitBean ? qZAlbumxUploadAlbumInitBean : null;
    }
}

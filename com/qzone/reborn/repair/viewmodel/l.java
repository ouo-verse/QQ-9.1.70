package com.qzone.reborn.repair.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.base.n;
import com.qzone.reborn.repair.bean.QZonePhotoRepairMainInitBean;
import com.qzone.reborn.repair.request.QZoneQueryPermissionsRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.SuperResolution$QueryPermissionsRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/repair/viewmodel/l;", "Lcom/qzone/reborn/base/n;", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "R1", "Landroid/content/Context;", "context", "S1", "", "Q1", "Lcom/qzone/reborn/repair/bean/QZonePhotoRepairMainInitBean;", "i", "Lcom/qzone/reborn/repair/bean/QZonePhotoRepairMainInitBean;", "O1", "()Lcom/qzone/reborn/repair/bean/QZonePhotoRepairMainInitBean;", "setInitBean", "(Lcom/qzone/reborn/repair/bean/QZonePhotoRepairMainInitBean;)V", "initBean", "Landroidx/lifecycle/MutableLiveData;", "Lqzone/SuperResolution$QueryPermissionsRsp;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "P1", "()Landroidx/lifecycle/MutableLiveData;", "setPermissionRspLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "permissionRspLiveData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class l extends n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZonePhotoRepairMainInitBean initBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<SuperResolution$QueryPermissionsRsp> permissionRspLiveData = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(final l this$0, BaseRequest baseRequest, boolean z16, long j3, String str, final SuperResolution$QueryPermissionsRsp superResolution$QueryPermissionsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(this$0.getTAG(), 1, "queryPermissionRequest  | traceId=" + baseRequest.getTraceId() + " | isSuccess=" + z16 + " | retCode=" + j3 + " | errMsg=" + str + " | rsp=" + superResolution$QueryPermissionsRsp);
        if (z16 && j3 == 0 && superResolution$QueryPermissionsRsp != null) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.repair.viewmodel.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.U1(l.this, superResolution$QueryPermissionsRsp);
                }
            });
            QLog.i(this$0.getTAG(), 1, "queryPermissionRequest rsp data | rsp.enable_sr=" + superResolution$QueryPermissionsRsp.enable_sr.get() + " | rsp.pp_button_hint=" + superResolution$QueryPermissionsRsp.pp_button_hint.get() + " | rsp.pp_bottom_hint1=" + superResolution$QueryPermissionsRsp.pp_bottom_hint1.get() + " | rsp.pp_bottom_hint2=" + superResolution$QueryPermissionsRsp.pp_bottom_hint2.get() + " | rsp.rp_pay_type=" + superResolution$QueryPermissionsRsp.rp_pay_type.get() + " | rsp.pp_pay_type=" + superResolution$QueryPermissionsRsp.pp_pay_type.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(l this$0, SuperResolution$QueryPermissionsRsp superResolution$QueryPermissionsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.permissionRspLiveData.postValue(superResolution$QueryPermissionsRsp);
    }

    /* renamed from: O1, reason: from getter */
    public final QZonePhotoRepairMainInitBean getInitBean() {
        return this.initBean;
    }

    public final MutableLiveData<SuperResolution$QueryPermissionsRsp> P1() {
        return this.permissionRspLiveData;
    }

    public final boolean Q1() {
        PBBoolField pBBoolField;
        SuperResolution$QueryPermissionsRsp value = this.permissionRspLiveData.getValue();
        return value != null && (pBBoolField = value.enable_sr) != null && pBBoolField.get();
    }

    public final void S1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        sendRequest(context, new QZoneQueryPermissionsRequest(), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.repair.viewmodel.j
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                l.T1(l.this, baseRequest, z16, j3, str, (SuperResolution$QueryPermissionsRsp) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZonePhotoRepairViewModel";
    }

    public final void R1(Activity activity) {
        Intent intent;
        Bundle extras;
        if (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null) {
            return;
        }
        this.initBean = (QZonePhotoRepairMainInitBean) extras.getSerializable("qzone_route_bean");
    }
}

package com.qzone.reborn.qzmoment.publish.part;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.qzone.widget.MoodPicLabel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkpublish.util.WinkCommonUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoErrorCode;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b extends an.a implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private MoodPicLabel f59016d;

    /* renamed from: e, reason: collision with root package name */
    private QQPermission f59017e;

    /* renamed from: f, reason: collision with root package name */
    private LocationManager f59018f;

    /* renamed from: h, reason: collision with root package name */
    private pn.b f59019h;

    /* renamed from: i, reason: collision with root package name */
    private LbsDataV2.PoiInfo f59020i;

    /* renamed from: m, reason: collision with root package name */
    public int f59021m = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends QQPermission.BasePermissionsListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public boolean isShowGuide(List<String> list) {
            return false;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            b bVar = b.this;
            bVar.I9(bVar.getContext());
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            QLog.w("QZMPublishLbsPart", 1, "jumpToPoiFragment... deny");
            if (b.this.f59017e.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                b bVar = b.this;
                bVar.I9(bVar.getContext());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.reborn.qzmoment.publish.part.b$b, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public class DialogInterfaceOnClickListenerC0495b implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC0495b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            b.this.getActivity().startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 0);
        }
    }

    private QQCustomDialog F9(Context context, String str, String str2, int i3, int i16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.a0y);
        qQCustomDialog.setContentView(R.layout.gu7);
        qQCustomDialog.setBackground(R.drawable.qvideo_skin_toast_and_dialog_background);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessage(str2);
        qQCustomDialog.setNegativeButton(i3, onClickListener2);
        qQCustomDialog.setPositiveButton(i16, onClickListener);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        return qQCustomDialog;
    }

    private void H9(LbsDataV2.PoiInfo poiInfo) {
        MoodPicLabel moodPicLabel;
        String str = poiInfo.poiId;
        if (str == null || !str.equals("invalide_poi_id") || (moodPicLabel = this.f59016d) == null) {
            return;
        }
        moodPicLabel.setText("\u6dfb\u52a0\u5730\u70b9");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I9(Context context) {
        Bundle bundle = new Bundle();
        LbsDataV2.PoiInfo poiInfo = this.f59020i;
        if (poiInfo != null) {
            bundle.putParcelable("key_current_poi", poiInfo);
            this.f59021m = 1;
        }
        bundle.putInt("key_app_id", WiFiPhotoErrorCode.ERR_FILEBRIDGE_NOT_FOLDER);
        bundle.putInt("key_lbs_state", this.f59021m);
        QZoneHelper.forwardToMoodSelectLocation(context, WinkCommonUtil.getCurrentAccount(), 1208, bundle);
    }

    private void J9() {
        if (!this.f59018f.isProviderEnabled("gps")) {
            K9();
            return;
        }
        if (!E9()) {
            QQPermission qQPermission = this.f59017e;
            if (qQPermission == null) {
                return;
            }
            qQPermission.requestPermissions(vx.a.f443628a, 2, new a());
            return;
        }
        I9(getContext());
    }

    private void K9() {
        try {
            F9(getContext(), uq3.c.b1(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "secondary_qcircle_no_gps_title", "\u65e0\u6cd5\u5b9a\u4f4d"), uq3.c.b1(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "secondary_qcircle_no_gps_content", "\u65e0\u6cd5\u83b7\u53d6\u5230\u4f60\u7684\u4f4d\u7f6e\u4fe1\u606f\uff0c\u8bf7\u6253\u5f00\u5b9a\u4f4d\u670d\u52a1\u3002"), R.string.cancel, R.string.f171000bk1, new DialogInterfaceOnClickListenerC0495b(), new c()).show();
        } catch (Exception e16) {
            QLog.e("QZMPublishLbsPart", 1, "Exception:", e16);
        }
    }

    public boolean E9() {
        return !vx.a.a(this.f59017e);
    }

    public void G9(Intent intent) {
        LbsDataV2.PoiInfo poiInfo = (LbsDataV2.PoiInfo) intent.getExtras().getParcelable(QZoneHelper.INDEX_MOOD_SELECT_LOCATION_ITEM_SELECT_POI);
        if (poiInfo != null && !poiInfo.poiId.equals("invalide_poi_id")) {
            this.f59020i = poiInfo;
            this.f59019h.T1(poiInfo);
            MoodPicLabel moodPicLabel = this.f59016d;
            if (moodPicLabel != null) {
                moodPicLabel.setText(poiInfo.poiName);
                return;
            }
            return;
        }
        this.f59019h.T1(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.ml6) {
            if (getPartManager().getPart(QZMPublishInputPart.class.getName()) != null) {
                ((QZMPublishInputPart) getPartManager().getPart(QZMPublishInputPart.class.getName())).Q9();
            }
            J9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        MoodPicLabel moodPicLabel = (MoodPicLabel) view.findViewById(R.id.ml6);
        this.f59016d = moodPicLabel;
        moodPicLabel.setOnClickListener(this);
        fo.c.o(this.f59016d, "em_bas_add_location", null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        this.f59019h = (pn.b) getViewModel(pn.b.class);
        this.f59018f = (LocationManager) getActivity().getSystemService("location");
        this.f59017e = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QZONE, QQPermissionConstants.Business.SCENE.QQ_QZONE_SELECT_LOCATION));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i3 != 1208 || i16 != -1 || intent == null || intent.getExtras() == null) {
            return;
        }
        G9(intent);
        Parcelable parcelable = intent.getExtras().getParcelable(QZoneHelper.INDEX_MOOD_SELECT_LOCATION_ITEM_SELECT_POI);
        if (parcelable instanceof LbsDataV2.PoiInfo) {
            H9((LbsDataV2.PoiInfo) parcelable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}

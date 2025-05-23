package com.qzone.reborn.albumx.qzone.vas.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.albumx.qzone.bean.init.QZoneAlbumxExpicPicInitBean;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/vas/part/f;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "d", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "secNavBar", "Lcom/qzone/reborn/albumx/qzone/bean/init/QZoneAlbumxExpicPicInitBean;", "e", "Lcom/qzone/reborn/albumx/qzone/bean/init/QZoneAlbumxExpicPicInitBean;", "initBean", "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class f extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QUISecNavBar secNavBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneAlbumxExpicPicInitBean initBean;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getActivity().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        String str;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.nbq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_title_nav)");
        QUISecNavBar qUISecNavBar = (QUISecNavBar) findViewById;
        this.secNavBar = qUISecNavBar;
        QUISecNavBar qUISecNavBar2 = null;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secNavBar");
            qUISecNavBar = null;
        }
        qUISecNavBar.setBaseClickListener(BaseAction.ACTION_LEFT_BUTTON, new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzone.vas.part.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.D9(f.this, view);
            }
        });
        QUISecNavBar qUISecNavBar3 = this.secNavBar;
        if (qUISecNavBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secNavBar");
            qUISecNavBar3 = null;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        qUISecNavBar3.R(activity);
        QUISecNavBar qUISecNavBar4 = this.secNavBar;
        if (qUISecNavBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secNavBar");
        } else {
            qUISecNavBar2 = qUISecNavBar4;
        }
        QZoneAlbumxExpicPicInitBean qZoneAlbumxExpicPicInitBean = this.initBean;
        boolean z16 = false;
        if (qZoneAlbumxExpicPicInitBean != null && qZoneAlbumxExpicPicInitBean.getPhotoStatus() == 0) {
            z16 = true;
        }
        if (z16) {
            str = "\u5373\u5c06\u964d\u7ea7\u7684\u7167\u7247";
        } else {
            str = "\u53ef\u6062\u590d\u539f\u56fe\u7684\u7167\u7247";
        }
        qUISecNavBar2.setCenterText(str);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        super.onPartCreate(activity, savedInstanceState);
        Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_bundle_common_init_bean");
        QZoneAlbumxExpicPicInitBean qZoneAlbumxExpicPicInitBean = serializableExtra instanceof QZoneAlbumxExpicPicInitBean ? (QZoneAlbumxExpicPicInitBean) serializableExtra : null;
        this.initBean = qZoneAlbumxExpicPicInitBean;
        QLog.d("QZoneAlbumExpirePicTitlePart", 1, "onPartCreate: " + qZoneAlbumxExpicPicInitBean);
    }
}

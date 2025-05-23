package com.tencent.biz.qqcircle.immersive.part.profilecard;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\b*\u0001\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/profilecard/QFSSetDynamicAvatarPart;", "Lcom/tencent/biz/qqcircle/immersive/part/profilecard/a;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "A9", "x9", "z9", "com/tencent/biz/qqcircle/immersive/part/profilecard/QFSSetDynamicAvatarPart$finishBroadcastReceiver$1", h.F, "Lcom/tencent/biz/qqcircle/immersive/part/profilecard/QFSSetDynamicAvatarPart$finishBroadcastReceiver$1;", "finishBroadcastReceiver", "uin", "<init>", "(Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSetDynamicAvatarPart extends a {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QFSSetDynamicAvatarPart$finishBroadcastReceiver$1 finishBroadcastReceiver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.tencent.biz.qqcircle.immersive.part.profilecard.QFSSetDynamicAvatarPart$finishBroadcastReceiver$1] */
    public QFSSetDynamicAvatarPart(@NotNull String uin) {
        super(uin);
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.finishBroadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.biz.qqcircle.immersive.part.profilecard.QFSSetDynamicAvatarPart$finishBroadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                QLog.d(QFSSetDynamicAvatarPart.this.getTAG(), 1, "finishBroadcastReceiver ");
                QFSSetDynamicAvatarPart.this.getActivity().onBackPressed();
            }
        };
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.profilecard.a
    protected void A9() {
        this.f88240d.setText(getContext().getResources().getString(R.string.f193804a7));
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.profilecard.a, com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSetDynamicAvatarPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.profilecard.a, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        Activity activity = getActivity();
        if (activity != null) {
            activity.registerReceiver(this.finishBroadcastReceiver, new IntentFilter(QCircleScheme.AttrQQPublish.BROADCAST_WINK_DYNAMIC_AVATAR_FINISH));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.profilecard.a
    public void x9() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LIVE_AVATAR_ENTRANCE, "4");
        VideoReport.setElementId(this.f88240d, "em_xsj_live_avatar_entrance");
        VideoReport.setElementParams(this.f88240d, buildElementParams);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.profilecard.a
    public void z9() {
        ((IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class)).launcherPersonalCoverFeedPageScheme(QCircleScheme.AttrQQPublish.OPENPERSONALCOVERFEEDPAGE_AVATAR_FROM, "4", 1);
    }
}

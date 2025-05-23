package com.qzone.reborn.feedx.part;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.google.protobuf.nano.MessageNano;
import com.qzone.reborn.base.QZoneBaseBlockContainer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/reborn/feedx/part/e;", "Lcom/qzone/reborn/base/k;", "", "J9", "", "data", "Lcom/qzone/proto/b;", "I9", "F9", "H9", "K9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "d", "J", "uin", "<init>", "(J)V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class e extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long uin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/feedx/part/e$b", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends ProtoUtils.TroopProtocolObserver {
        b() {
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, byte[] data, Bundle bundle) {
            if (errorCode == 0 && data != null) {
                com.qzone.proto.b I9 = e.this.I9(data);
                if (I9 != null) {
                    e.this.F9(I9);
                    return;
                } else {
                    QLog.e("QZoneAdelieAdminDynamicPart", 1, "requestQZoneAdelieAdmin error. data parse error. ");
                    return;
                }
            }
            QLog.e("QZoneAdelieAdminDynamicPart", 1, "requestQZoneAdelieAdmin error. data is null. code: " + errorCode);
        }
    }

    public e(long j3) {
        this.uin = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(final com.qzone.proto.b data) {
        View findViewById;
        QLog.e("QZoneAdelieAdminDynamicPart", 1, "handleAdminData data = " + data + ".");
        if (data.f50096a == 0) {
            return;
        }
        String str = data.f50097b;
        Intrinsics.checkNotNullExpressionValue(str, "data.manageUrl");
        if (str.length() == 0) {
            return;
        }
        View partRootView = getPartRootView();
        ViewStub viewStub = partRootView != null ? (ViewStub) partRootView.findViewById(R.id.f162791mn4) : null;
        View inflate = viewStub != null ? viewStub.inflate() : null;
        if (inflate != null && (findViewById = inflate.findViewById(R.id.f162895n70)) != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.G9(e.this, data, view);
                }
            });
        }
        H9();
        K9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(e this$0, com.qzone.proto.b data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchQZoneScheme(this$0.getContext(), data.f50097b);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void H9() {
        View partRootView = getPartRootView();
        View findViewById = partRootView != null ? partRootView.findViewById(R.id.ncv) : null;
        if (findViewById == null) {
            return;
        }
        View partRootView2 = getPartRootView();
        ViewGroup viewGroup = partRootView2 instanceof ViewGroup ? (ViewGroup) partRootView2 : null;
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeView(findViewById);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.qzone.proto.b I9(byte[] data) {
        try {
            return com.qzone.proto.b.c(data);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QZoneAdelieAdminDynamicPart", 1, "parseAdminRsp parse failed.", e16);
            return null;
        }
    }

    private final void J9() {
        AppRuntime peekAppRuntime;
        if (((IRobotServiceApi) QRoute.api(IRobotServiceApi.class)).isRobotUin(String.valueOf(this.uin)) && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
            com.qzone.proto.a aVar = new com.qzone.proto.a();
            aVar.f50095a = this.uin;
            ProtoUtils.a(peekAppRuntime, new b(), MessageNano.toByteArray(aVar), "OidbSvcTrpcTcp.0x9325", 37669, 0);
        }
    }

    private final void K9() {
        View partRootView = getPartRootView();
        QZoneBaseBlockContainer qZoneBaseBlockContainer = partRootView != null ? (QZoneBaseBlockContainer) partRootView.findViewById(R.id.nch) : null;
        if (qZoneBaseBlockContainer == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = qZoneBaseBlockContainer.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin + com.qzone.util.ar.e(93.0f));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        J9();
    }
}

package com.tencent.mobileqq.icgame.room.pendant.component;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.IQQLiveSDKManager;
import com.tencent.mobileqq.icgame.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.icgame.api.pendant.IQQLiveModulePendant;
import com.tencent.mobileqq.icgame.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.icgame.framework.component.b;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.report.capability.spatialaudio.TVKDeviceSpatialAudioCapabilityReportConstant;
import d42.g;
import fu0.c;
import i22.OrientationChangedEvent;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rv0.SoftKeyBoardStateEvent;
import tl.h;
import y32.ConfigurationChangeEvent;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 C2\u00020\u0001:\u0001DB\u000f\u0012\u0006\u0010@\u001a\u00020?\u00a2\u0006\u0004\bA\u0010BJ\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\"\u0010\n\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u001fR\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b%\u0010&R#\u0010-\u001a\n (*\u0004\u0018\u00010'0'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00105R\u0016\u00108\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010:\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00105R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/pendant/component/QQLivePendantComponent;", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "", "topMargin", "rightMargin", "", "y", "bottomMargin", HippyTKDListViewAdapter.X, "", "b", "", "o", "p", DomainData.DOMAIN_NAME, "k", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Li22/d;", "event", "t", "Ly32/a;", ReportConstant.COSTREPORT_PREFIX, "w", "Ld42/g;", "v", "", "expand", "r", "Lrv0/h;", "u", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "Lcom/tencent/mobileqq/icgame/room/pendant/component/a;", TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT, "Lcom/tencent/mobileqq/icgame/room/pendant/component/a;", "Lfu0/c;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "c", "()Lfu0/c;", "liveRoomService", "Ll42/a;", "f", "Ll42/a;", "pendantManager", h.F, "Ljava/lang/String;", "selfUid", "Z", "isInited", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "videoLandscape", BdhLogUtil.LogTag.Tag_Conn, "activityLandscape", "Landroid/widget/RelativeLayout$LayoutParams;", "D", "Landroid/widget/RelativeLayout$LayoutParams;", "originLayoutParams", "Lf32/a;", "cc", "<init>", "(Lf32/a;)V", "E", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class QQLivePendantComponent extends b {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean activityLandscape;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout.LayoutParams originLayoutParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy liveRoomService;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final l42.a pendantManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String selfUid;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isInited;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean videoLandscape;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    @InjectService(key = a.class)
    private a support;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLivePendantComponent(@NotNull f32.a cc5) {
        super(cc5);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(cc5, "cc");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.icgame.room.pendant.component.QQLivePendantComponent$liveRoomService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                return (c) qx0.a.b(c.class);
            }
        });
        this.liveRoomService = lazy;
        this.pendantManager = new l42.a();
        this.selfUid = "";
    }

    private final long b() {
        LiveAnchorInfo liveAnchorInfo;
        h22.a aVar = this.qqLiveRoomService;
        h22.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        if (aVar.c()) {
            h22.a aVar3 = this.qqLiveRoomService;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            } else {
                aVar2 = aVar3;
            }
            QQLiveAnchorRoomInfo anchorRoomInfo = aVar2.getAnchorRoomInfo();
            if (anchorRoomInfo == null) {
                return 0L;
            }
            return anchorRoomInfo.uid;
        }
        h22.a aVar4 = this.qqLiveRoomService;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar2 = aVar4;
        }
        LiveInfo curLiveInfo = aVar2.getCurLiveInfo();
        if (curLiveInfo == null || (liveAnchorInfo = curLiveInfo.anchorInfo) == null) {
            return 0L;
        }
        return liveAnchorInfo.uid;
    }

    private final c c() {
        return (c) this.liveRoomService.getValue();
    }

    private final long n() {
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        return aVar.getRoomId();
    }

    private final String o() {
        IQQLiveSDK f16;
        String str;
        if (!TextUtils.isEmpty(this.selfUid)) {
            return this.selfUid;
        }
        if (c() == null) {
            f16 = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getQQLiveAppId());
        } else {
            f16 = c().f();
        }
        if (f16 != null) {
            str = f16.getAppRuntime().getAccount();
            Intrinsics.checkNotNullExpressionValue(str, "qqLiveSDK.appRuntime.account");
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            this.selfUid = str;
        }
        return str;
    }

    private final void p() {
        boolean z16;
        boolean c16 = com.tencent.icgame.game.liveroom.impl.room.util.b.c(getComponentContext().getContext());
        rt0.a.INSTANCE.j("ICGamePendant|ICGamePendantComponent", "roomId " + n() + "  videoLandscape " + this.videoLandscape + ", isFolderScreenOpen " + c16);
        l42.a aVar = this.pendantManager;
        if (this.videoLandscape && c16) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar.j(z16);
    }

    private final void x(FrameLayout container, float bottomMargin, float rightMargin) {
        ViewParent viewParent;
        ViewGroup.LayoutParams layoutParams = null;
        if (container != null) {
            viewParent = container.getParent();
        } else {
            viewParent = null;
        }
        LinearLayout linearLayout = (LinearLayout) viewParent;
        if (linearLayout != null) {
            layoutParams = linearLayout.getLayoutParams();
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.bottomMargin = t42.h.a(getComponentContext().getContext(), bottomMargin);
        layoutParams2.rightMargin = t42.h.a(getComponentContext().getContext(), rightMargin);
    }

    private final void y(FrameLayout container, float topMargin, float rightMargin) {
        ViewGroup.LayoutParams layoutParams;
        if (container != null) {
            layoutParams = container.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = t42.h.a(getComponentContext().getContext(), topMargin);
        layoutParams2.rightMargin = t42.h.a(getComponentContext().getContext(), rightMargin);
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
        w();
    }

    public final void q() {
        IQQLiveModulePendant iQQLiveModulePendant;
        String str;
        if (this.isInited) {
            return;
        }
        h22.a aVar = this.qqLiveRoomService;
        a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        long roomId = aVar.getRoomId();
        if (roomId == 0) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).a("ICGamePendant|ICGamePendantComponent", "init pendant, room id is 0!");
            e32.c.e(new IllegalAccessException("pendant init but room id is 0!"));
            return;
        }
        long b16 = b();
        IQQLiveSDK f16 = c().f();
        String str2 = "";
        if (f16 == null) {
            if (!TextUtils.isEmpty("")) {
                str = "";
            } else {
                str = com.tencent.mobileqq.icgame.base.room.a.a(f16);
            }
            QLog.w("CheckNull", 1, IQQLiveSDK.class.getSimpleName() + ',' + str);
        }
        if (f16 != null) {
            iQQLiveModulePendant = f16.createPendantModule();
        } else {
            iQQLiveModulePendant = null;
        }
        if (iQQLiveModulePendant == null) {
            if (TextUtils.isEmpty("")) {
                str2 = com.tencent.mobileqq.icgame.base.room.a.a(iQQLiveModulePendant);
            }
            QLog.w("CheckNull", 1, IQQLiveModulePendant.class.getSimpleName() + ',' + str2);
        }
        if (iQQLiveModulePendant == null) {
            return;
        }
        l42.a C = this.pendantManager.A(roomId).v(b16).C(o());
        h22.a aVar3 = this.qqLiveRoomService;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar3 = null;
        }
        l42.a x16 = C.B(aVar3.getRoomType()).x(iQQLiveModulePendant);
        a aVar4 = this.support;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT);
            aVar4 = null;
        }
        l42.a w3 = x16.w(aVar4.b());
        a aVar5 = this.support;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT);
            aVar5 = null;
        }
        l42.a z16 = w3.z(aVar5.c());
        a aVar6 = this.support;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT);
        } else {
            aVar2 = aVar6;
        }
        z16.y(aVar2.a()).k();
        this.isInited = true;
        p();
    }

    public final void r(boolean expand2) {
        rt0.a.INSTANCE.j("ICGamePendant|ICGamePendantComponent", "onAutoCollapseViewExpand, expand:" + expand2 + ", activityLandscape:" + this.activityLandscape);
        if (this.activityLandscape) {
            this.pendantManager.u(expand2);
        }
    }

    public final void s(@NotNull ConfigurationChangeEvent event) {
        boolean z16;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getNewConfig().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.activityLandscape = z16;
        p();
    }

    public final void t(@NotNull OrientationChangedEvent event) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(event, "event");
        this.activityLandscape = event.getIsLandscape();
        a aVar = null;
        if (this.originLayoutParams == null) {
            a aVar2 = this.support;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT);
                aVar2 = null;
            }
            FrameLayout c16 = aVar2.c();
            if (c16 != null) {
                layoutParams = c16.getLayoutParams();
            } else {
                layoutParams = null;
            }
            this.originLayoutParams = (RelativeLayout.LayoutParams) layoutParams;
        }
        if (event.getIsLandscape()) {
            a aVar3 = this.support;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT);
                aVar3 = null;
            }
            y(aVar3.c(), 56.0f, 36.0f);
            a aVar4 = this.support;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT);
            } else {
                aVar = aVar4;
            }
            x(aVar.a(), 52.0f, 24.0f);
            this.pendantManager.u(false);
        } else {
            a aVar5 = this.support;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT);
                aVar5 = null;
            }
            y(aVar5.c(), 5.0f, 12.0f);
            a aVar6 = this.support;
            if (aVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT);
            } else {
                aVar = aVar6;
            }
            x(aVar.a(), 0.0f, 0.0f);
            this.pendantManager.u(true);
        }
        p();
    }

    public final void u(@NotNull SoftKeyBoardStateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.activityLandscape && event.getIsShowing()) {
            this.pendantManager.u(false);
        }
    }

    public final void v(@NotNull g event) {
        boolean z16;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getWidth() > event.getHeight()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.videoLandscape = z16;
        rt0.a.INSTANCE.j("ICGamePendant|ICGamePendantComponent", "roomId " + n() + " video orientation change, videoLandscape " + this.videoLandscape);
        p();
    }

    public final void w() {
        this.isInited = false;
        this.videoLandscape = false;
        this.pendantManager.E();
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
    }
}

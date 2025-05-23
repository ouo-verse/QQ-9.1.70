package com.tencent.mobileqq.zplan.minixwconnected.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.filament.zplan.scene.xwconnect.MiniHomeConnectScene;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerOpRspData;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerOpType;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerUiData;
import com.tencent.filament.zplan.scene.xwconnect.data.h;
import com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectFocusStateHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectHuatengHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectPlayCoupleActionHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectSceneEventHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.b;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.pbjava.CoupleActionChannel$PlayCoupleActionReq;
import com.tencent.filament.zplanservice.pbjava.CoupleActionChannel$PlayCoupleActionRsp;
import com.tencent.filament.zplanservice.pbjava.huateng.HuatengSvr$FlowerViewData;
import com.tencent.filament.zplanservice.pbjava.sceneevent.NativeDoFlowerOp$NativeDoFlowerOpReq;
import com.tencent.filament.zplanservice.pbjava.sceneevent.NativeDoFlowerOp$NativeFlowerStartPreview;
import com.tencent.filament.zplanservice.pbjava.sceneevent.NativeDoFlowerOp$NativeFlowerStopPreview;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneEvent;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneStateChange$NativeStateChangeEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.minihome.MapMode;
import com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController;
import com.tencent.mobileqq.zplan.minixwconnected.data.ActionData;
import com.tencent.mobileqq.zplan.minixwconnected.data.GuestActionInfo;
import com.tencent.mobileqq.zplan.minixwconnected.data.StartUpParams;
import com.tencent.mobileqq.zplan.minixwconnected.data.StartupParamConfig;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import dl0.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import mqq.util.WeakReference;
import ri3.FlowerOpRsp;
import ri3.MapModeInfo;
import zk0.a;
import zk0.b;
import zk0.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ed\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001s\u0018\u0000 \u00122\u00020\u0001:\u0001IB\u001f\u0012\u0006\u0010v\u001a\u00020]\u0012\u0006\u0010M\u001a\u00020H\u0012\u0006\u0010S\u001a\u00020N\u00a2\u0006\u0004\bw\u0010xJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0017H\u0002J&\u0010\u001d\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010 \u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010!\u001a\u00020\u0002H\u0016J\b\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020\u0002H\u0016J\n\u0010&\u001a\u0004\u0018\u00010%H\u0016J&\u0010.\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,J\u0018\u00102\u001a\u00020\u00022\u0006\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u00020*J\u000e\u00104\u001a\u00020\u00022\u0006\u00103\u001a\u00020*J\u000e\u00107\u001a\u00020\u00022\u0006\u00106\u001a\u000205J\u000e\u00109\u001a\u00020\u00022\u0006\u00108\u001a\u00020*J \u0010?\u001a\u00020\u00022\u0006\u0010:\u001a\u00020*2\u0006\u0010<\u001a\u00020;2\b\u0010>\u001a\u0004\u0018\u00010=J#\u0010C\u001a\u00020\u00022\u0006\u0010:\u001a\u00020*2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020A0@\u00a2\u0006\u0004\bC\u0010DJ\u000e\u0010E\u001a\u00020\u00022\u0006\u0010:\u001a\u00020*J\n\u0010G\u001a\u00020F*\u00020AR\u0017\u0010M\u001a\u00020H8\u0006\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0017\u0010S\u001a\u00020N8\u0006\u00a2\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u001e\u0010`\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010c\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u001e\u0010e\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010_R\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR \u0010r\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020o0n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010u\u001a\u00020s8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010t\u00a8\u0006y"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectMapComponent;", "Lcom/tencent/mobileqq/zplan/minixwconnected/c;", "", HippyTKDListViewAdapter.X, "y", "E", "D", UserInfo.SEX_FEMALE, "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectFocusStateHandler$c;", "event", "p", "Lzk0/c$c;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectPlayCoupleActionHandler$c;", "r", "Lzk0/b$b;", "o", "Lzk0/b$a;", "l", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/b$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectHuatengHandler$d;", "t", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectHuatengHandler$c;", DomainData.DOMAIN_NAME, "", "topMaskUrl", "bottomMaskUrl", "bottomMaskFocusUrl", "B", "", "param", OperateCustomButton.OPERATE_CREATE, HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "resume", "pause", "destroy", "Landroid/view/View;", "w", "", "masterActionId", "guestActionId", "", "focusUin", "", "needReport", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/zplan/minihome/MapMode;", "targetState", "hostUin", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "visitUin", "G", "Lx45/h;", "recommendUserInfo", "H", "refreshBlockUin", BdhLogUtil.LogTag.Tag_Conn, "reqUin", "Lcom/tencent/filament/zplan/scene/xwconnect/data/FlowerOpType;", "opType", "", "opData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Lp55/h;", "flowerViewDataList", "u", "(J[Lp55/h;)V", "v", "Lcom/tencent/filament/zplanservice/pbjava/huateng/HuatengSvr$FlowerViewData;", "k", "Lri3/c;", "a", "Lri3/c;", "getViewModel", "()Lri3/c;", "viewModel", "Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "b", "Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "getController", "()Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "controller", "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", "c", "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", "nativeApp", "Lcom/tencent/zplan/zplantracing/b;", "d", "Lcom/tencent/zplan/zplantracing/b;", "rootSpan", "Lmqq/util/WeakReference;", "Landroid/content/Context;", "e", "Lmqq/util/WeakReference;", "contextRef", "f", "Landroid/view/View;", "textureView", "g", "controllerRef", "Landroid/content/BroadcastReceiver;", tl.h.F, "Landroid/content/BroadcastReceiver;", "broadcastReceiver", "Lcom/tencent/mobileqq/zplan/minixwconnected/data/c;", "i", "Lcom/tencent/mobileqq/zplan/minixwconnected/data/c;", "startUpParams", "", "Lcom/tencent/mobileqq/zplan/minixwconnected/data/b;", "j", "Ljava/util/Map;", "masterActionIdToGuestActionInfoMap", "com/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectMapComponent$action$1", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectMapComponent$action$1;", "action", "context", "<init>", "(Landroid/content/Context;Lri3/c;Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeConnectMapComponent implements com.tencent.mobileqq.zplan.minixwconnected.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ri3.c viewModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final MiniHomeConnectedController controller;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private IFilamentNativeAppV2305 nativeApp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.zplan.zplantracing.b rootSpan;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private WeakReference<Context> contextRef;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View textureView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private WeakReference<MiniHomeConnectedController> controllerRef;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private BroadcastReceiver broadcastReceiver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private StartUpParams startUpParams;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Map<Integer, GuestActionInfo> masterActionIdToGuestActionInfoMap;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final MiniHomeConnectMapComponent$action$1 action;

    /* JADX WARN: Type inference failed for: r3v2, types: [com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectMapComponent$action$1] */
    public MiniHomeConnectMapComponent(Context context, ri3.c viewModel, MiniHomeConnectedController controller) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.viewModel = viewModel;
        this.controller = controller;
        this.masterActionIdToGuestActionInfoMap = new LinkedHashMap();
        this.action = new tk0.a() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectMapComponent$action$1
            @Override // tk0.a
            public void call(tk0.b event) {
                Intrinsics.checkNotNullParameter(event, "event");
                QLog.i("MiniHomeConnectMapComponent", 1, "IZPlanBusinessAction.call, event: " + event);
                boolean z16 = event instanceof c.StartupParam;
                if (z16) {
                    MiniHomeConnectMapComponent.this.s(z16 ? (c.StartupParam) event : null);
                    return;
                }
                boolean z17 = event instanceof MiniHomeConnectPlayCoupleActionHandler.c;
                if (z17) {
                    MiniHomeConnectMapComponent.this.r(z17 ? (MiniHomeConnectPlayCoupleActionHandler.c) event : null);
                    return;
                }
                boolean z18 = event instanceof b.OnClickGift;
                if (z18) {
                    MiniHomeConnectMapComponent.this.o(z18 ? (b.OnClickGift) event : null);
                    return;
                }
                boolean z19 = event instanceof b.OnClickCreateMiniXW;
                if (z19) {
                    MiniHomeConnectMapComponent.this.l(z19 ? (b.OnClickCreateMiniXW) event : null);
                    return;
                }
                boolean z26 = event instanceof MiniHomeConnectFocusStateHandler.c;
                if (z26) {
                    MiniHomeConnectMapComponent.this.p(z26 ? (MiniHomeConnectFocusStateHandler.c) event : null);
                    return;
                }
                boolean z27 = event instanceof b.C1119b;
                if (z27) {
                    MiniHomeConnectMapComponent.this.q(z27 ? (b.C1119b) event : null);
                    return;
                }
                boolean z28 = event instanceof MiniHomeConnectHuatengHandler.d;
                if (z28) {
                    MiniHomeConnectMapComponent.this.t(z28 ? (MiniHomeConnectHuatengHandler.d) event : null);
                    return;
                }
                boolean z29 = event instanceof MiniHomeConnectHuatengHandler.c;
                if (z29) {
                    MiniHomeConnectMapComponent.this.n(z29 ? (MiniHomeConnectHuatengHandler.c) event : null);
                }
            }
        };
        this.contextRef = new WeakReference<>(context);
        this.controllerRef = new WeakReference<>(controller);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
    
        if ((r7.length() > 0) == true) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void B(String topMaskUrl, String bottomMaskUrl, String bottomMaskFocusUrl) {
        boolean z16;
        boolean z17;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        boolean z18 = true;
        if (topMaskUrl != null) {
            if (topMaskUrl.length() > 0) {
                z16 = true;
                if (z16) {
                    URLDrawable.getDrawable(topMaskUrl, obtain);
                }
                if (bottomMaskUrl != null) {
                    if (bottomMaskUrl.length() > 0) {
                        z17 = true;
                        if (z17) {
                            URLDrawable.getDrawable(bottomMaskUrl, obtain);
                        }
                        if (bottomMaskFocusUrl != null) {
                        }
                        z18 = false;
                        if (z18) {
                            URLDrawable.getDrawable(bottomMaskFocusUrl, obtain);
                            return;
                        }
                        return;
                    }
                }
                z17 = false;
                if (z17) {
                }
                if (bottomMaskFocusUrl != null) {
                }
                z18 = false;
                if (z18) {
                }
            }
        }
        z16 = false;
        if (z16) {
        }
        if (bottomMaskUrl != null) {
        }
        z17 = false;
        if (z17) {
        }
        if (bottomMaskFocusUrl != null) {
        }
        z18 = false;
        if (z18) {
        }
    }

    private final void F() {
        WeakReference<Context> weakReference;
        Context context;
        QLog.i("MiniHomeConnectMapComponent", 1, "unregisterQQAppStateBroadcast");
        try {
            BroadcastReceiver broadcastReceiver = this.broadcastReceiver;
            if (broadcastReceiver == null || (weakReference = this.contextRef) == null || (context = weakReference.get()) == null) {
                return;
            }
            context.unregisterReceiver(broadcastReceiver);
        } catch (Throwable th5) {
            QLog.e("MiniHomeConnectMapComponent", 1, "destroy, unregisterReceiver failed.", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(b.C1119b event) {
        boolean z16 = true;
        QLog.i("MiniHomeConnectMapComponent", 1, "doOnMaskLayerDataReady");
        if (event == null) {
            return;
        }
        String str = event.getReq().top_mask_layer_url.get();
        String str2 = event.getReq().bottom_mask_layer_url.get();
        String str3 = event.getReq().bottom_mask_layer_focus_url.get();
        if (str == null || str.length() == 0) {
            if (str2 == null || str2.length() == 0) {
                if (str3 != null && str3.length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    return;
                }
            }
        }
        B(str, str2, str3);
        this.controller.e0(str, str2, str3);
    }

    private final void x() {
        sk0.a aVar;
        Context context;
        QLog.i("MiniHomeConnectMapComponent", 1, "initEngine");
        WeakReference<Context> weakReference = this.contextRef;
        if (weakReference == null || (context = weakReference.get()) == null) {
            aVar = null;
        } else {
            FilamentUrlTemplate F = FilamentFeatureUtil.f106409g.F();
            fl0.a aVar2 = fl0.a.f399763a;
            aVar = new sk0.a(F, true, context, 25, (k) aVar2.a(k.class), (dl0.d) aVar2.a(dl0.d.class), (dl0.g) aVar2.a(dl0.g.class));
        }
        IFilamentNativeAppV2305 c16 = aVar != null ? FilamentRenderFactory.f105773b.c(aVar) : null;
        this.nativeApp = c16;
        QLog.i("MiniHomeConnectMapComponent", 1, "startWithEntry, nativeApp: " + c16);
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            com.tencent.zplan.zplantracing.b bVar = this.rootSpan;
            iFilamentNativeAppV2305.startWithEntry(bVar != null ? bVar.c() : null, "bundle/scenes/mini_home_connect/main.js");
        }
    }

    public final void A(int masterActionId, int guestActionId, long focusUin, boolean needReport) {
        QLog.i("MiniHomeConnectMapComponent", 1, "playCoupleAction nativeApp: " + this.nativeApp + ", masterActionId: " + masterActionId + ", guestActionId: " + guestActionId + ", needReport: " + needReport);
        if (needReport) {
            Map<Integer, GuestActionInfo> map = this.masterActionIdToGuestActionInfoMap;
            Integer valueOf = Integer.valueOf(masterActionId);
            GuestActionInfo guestActionInfo = map.get(valueOf);
            if (guestActionInfo == null) {
                guestActionInfo = new GuestActionInfo(focusUin, guestActionId, 0);
                map.put(valueOf, guestActionInfo);
            }
            GuestActionInfo guestActionInfo2 = guestActionInfo;
            guestActionInfo2.d(guestActionInfo2.getTimes() + 1);
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            CoupleActionChannel$PlayCoupleActionReq coupleActionChannel$PlayCoupleActionReq = new CoupleActionChannel$PlayCoupleActionReq();
            coupleActionChannel$PlayCoupleActionReq.action_id.set(masterActionId);
            iFilamentNativeAppV2305.dispatchEvent(new MiniHomeConnectPlayCoupleActionHandler.b(coupleActionChannel$PlayCoupleActionReq));
        }
    }

    public final void G(long visitUin) {
        QLog.i("MiniHomeConnectMapComponent", 1, "visitNeighbor nativeApp: " + this.nativeApp);
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            SceneEvent sceneEvent = new SceneEvent();
            sceneEvent.uin.set(visitUin);
            sceneEvent.scene_event.set(1);
            iFilamentNativeAppV2305.dispatchEvent(new MiniHomeConnectSceneEventHandler.b(sceneEvent));
        }
    }

    public final void H(x45.h recommendUserInfo) {
        Intrinsics.checkNotNullParameter(recommendUserInfo, "recommendUserInfo");
        QLog.i("MiniHomeConnectMapComponent", 1, "visitStranger nativeApp: " + this.nativeApp);
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            SceneEvent sceneEvent = new SceneEvent();
            sceneEvent.uin.set(recommendUserInfo.f447212a);
            sceneEvent.scene_event.set(2);
            iFilamentNativeAppV2305.dispatchEvent(new MiniHomeConnectSceneEventHandler.b(sceneEvent));
        }
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void create(Object param) {
        StartUpParams startUpParams = param instanceof StartUpParams ? (StartUpParams) param : null;
        if (startUpParams == null) {
            startUpParams = new StartUpParams(null, null, null, null, null, false, 63, null);
        }
        this.startUpParams = startUpParams;
        QLog.i("MiniHomeConnectMapComponent", 1, "create, startUpParams: " + startUpParams);
        x();
        y();
        E();
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void createView() {
        TextureView view;
        QLog.i("MiniHomeConnectMapComponent", 1, "createView nativeApp: " + this.nativeApp + ", create textureView.");
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 == null || (view = iFilamentNativeAppV2305.getView()) == null) {
            return;
        }
        this.textureView = view;
        D();
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void destroy() {
        QLog.i("MiniHomeConnectMapComponent", 1, "onDestroy nativeApp: " + this.nativeApp);
        F();
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.destroy();
        }
        this.nativeApp = null;
    }

    public final HuatengSvr$FlowerViewData k(p55.h hVar) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        HuatengSvr$FlowerViewData huatengSvr$FlowerViewData = new HuatengSvr$FlowerViewData();
        huatengSvr$FlowerViewData.field_res.set(hVar.f425400a);
        huatengSvr$FlowerViewData.flower_res.set(hVar.f425401b);
        return huatengSvr$FlowerViewData;
    }

    public final void m(long reqUin, FlowerOpType opType, byte[] opData) {
        Intrinsics.checkNotNullParameter(opType, "opType");
        QLog.i("MiniHomeConnectMapComponent", 1, "doFlowerOp");
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            NativeDoFlowerOp$NativeDoFlowerOpReq nativeDoFlowerOp$NativeDoFlowerOpReq = new NativeDoFlowerOp$NativeDoFlowerOpReq();
            nativeDoFlowerOp$NativeDoFlowerOpReq.uin.set(reqUin);
            nativeDoFlowerOp$NativeDoFlowerOpReq.f106426op.set(opType.getValue());
            if (opData != null) {
                nativeDoFlowerOp$NativeDoFlowerOpReq.op_data.set(ByteStringMicro.copyFrom(opData));
            }
            iFilamentNativeAppV2305.dispatchEvent(new MiniHomeConnectHuatengHandler.b(nativeDoFlowerOp$NativeDoFlowerOpReq));
        }
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void pause() {
        QLog.i("MiniHomeConnectMapComponent", 1, "onPause nativeApp: " + this.nativeApp);
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.pause();
        }
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void resume() {
        QLog.i("MiniHomeConnectMapComponent", 1, "onResume nativeApp: " + this.nativeApp);
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.resume();
        }
    }

    public final void u(long reqUin, p55.h[] flowerViewDataList) {
        Intrinsics.checkNotNullParameter(flowerViewDataList, "flowerViewDataList");
        QLog.i("MiniHomeConnectMapComponent", 1, "doStartPreview");
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            NativeDoFlowerOp$NativeFlowerStartPreview nativeDoFlowerOp$NativeFlowerStartPreview = new NativeDoFlowerOp$NativeFlowerStartPreview();
            nativeDoFlowerOp$NativeFlowerStartPreview.uin.set(reqUin);
            PBRepeatMessageField<HuatengSvr$FlowerViewData> pBRepeatMessageField = nativeDoFlowerOp$NativeFlowerStartPreview.flower_view_list;
            ArrayList arrayList = new ArrayList(flowerViewDataList.length);
            for (p55.h hVar : flowerViewDataList) {
                arrayList.add(k(hVar));
            }
            pBRepeatMessageField.set(arrayList);
            iFilamentNativeAppV2305.dispatchEvent(new MiniHomeConnectHuatengHandler.e(nativeDoFlowerOp$NativeFlowerStartPreview));
        }
    }

    public View w() {
        QLog.i("MiniHomeConnectMapComponent", 1, "getView " + Log.getStackTraceString(new Throwable("\u8c03\u7528\u6808\u6253\u5370")));
        return this.textureView;
    }

    public final void z(MapMode targetState, long hostUin) {
        Intrinsics.checkNotNullParameter(targetState, "targetState");
        QLog.i("MiniHomeConnectMapComponent", 1, "nativeStateChagne nativeApp: " + this.nativeApp);
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            SceneStateChange$NativeStateChangeEvent sceneStateChange$NativeStateChangeEvent = new SceneStateChange$NativeStateChangeEvent();
            sceneStateChange$NativeStateChangeEvent.host_uin.set(hostUin);
            sceneStateChange$NativeStateChangeEvent.state.set(targetState.getValue());
            iFilamentNativeAppV2305.dispatchEvent(new MiniHomeConnectFocusStateHandler.b(sceneStateChange$NativeStateChangeEvent));
        }
    }

    private final void D() {
        Context context;
        QLog.i("MiniHomeConnectMapComponent", 1, "registerQQAppStateBroadcast");
        if (this.broadcastReceiver == null) {
            this.broadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectMapComponent$registerQQAppStateBroadcast$1
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
                
                    r3 = r3.nativeApp;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
                
                    r3 = r3.nativeApp;
                 */
                @Override // android.content.BroadcastReceiver
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onReceive(Context context2, Intent intent) {
                    IFilamentNativeAppV2305 iFilamentNativeAppV2305;
                    IFilamentNativeAppV2305 iFilamentNativeAppV23052;
                    QLog.i("MiniHomeConnectMapComponent", 1, "broadcastReceiver.onReceive, action: " + (intent != null ? intent.getAction() : null));
                    if (intent != null) {
                        MiniHomeConnectMapComponent miniHomeConnectMapComponent = MiniHomeConnectMapComponent.this;
                        String action = intent.getAction();
                        if (action != null) {
                            int hashCode = action.hashCode();
                            if (hashCode != -1631108101) {
                                if (hashCode == -652791834 && action.equals(IECScreenReceiver.ACTION_QQ_BACKGROUND) && iFilamentNativeAppV23052 != null) {
                                    iFilamentNativeAppV23052.dispatchEvent(a.C11692a.f452692a);
                                    return;
                                }
                                return;
                            }
                            if (!action.equals(IECScreenReceiver.ACTION_QQ_FOREGROUND) || iFilamentNativeAppV2305 == null) {
                                return;
                            }
                            iFilamentNativeAppV2305.dispatchEvent(a.b.f452693a);
                        }
                    }
                }
            };
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IECScreenReceiver.ACTION_QQ_FOREGROUND);
        intentFilter.addAction(IECScreenReceiver.ACTION_QQ_BACKGROUND);
        WeakReference<Context> weakReference = this.contextRef;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        context.registerReceiver(this.broadcastReceiver, intentFilter);
    }

    private final void E() {
        QLog.i("MiniHomeConnectMapComponent", 1, "startScene");
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            com.tencent.zplan.zplantracing.b bVar = this.rootSpan;
            iFilamentNativeAppV2305.dispatchEvent(bVar != null ? bVar.c() : null, MiniHomeConnectScene.Companion.EVENT.INIT_HOME_CONNECT.name(), null);
        }
    }

    private final void y() {
        QLog.i("MiniHomeConnectMapComponent", 1, "initEvent");
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(c.StartupParam.class)), this.action);
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23052 = this.nativeApp;
        if (iFilamentNativeAppV23052 != null) {
            iFilamentNativeAppV23052.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(MiniHomeConnectFocusStateHandler.c.class)), this.action);
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23053 = this.nativeApp;
        if (iFilamentNativeAppV23053 != null) {
            iFilamentNativeAppV23053.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(MiniHomeConnectPlayCoupleActionHandler.c.class)), this.action);
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23054 = this.nativeApp;
        if (iFilamentNativeAppV23054 != null) {
            iFilamentNativeAppV23054.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(b.OnClickGift.class)), this.action);
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23055 = this.nativeApp;
        if (iFilamentNativeAppV23055 != null) {
            iFilamentNativeAppV23055.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(b.OnClickCreateMiniXW.class)), this.action);
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23056 = this.nativeApp;
        if (iFilamentNativeAppV23056 != null) {
            iFilamentNativeAppV23056.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(b.C1119b.class)), this.action);
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23057 = this.nativeApp;
        if (iFilamentNativeAppV23057 != null) {
            iFilamentNativeAppV23057.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(MiniHomeConnectHuatengHandler.d.class)), this.action);
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23058 = this.nativeApp;
        if (iFilamentNativeAppV23058 != null) {
            iFilamentNativeAppV23058.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(MiniHomeConnectHuatengHandler.c.class)), this.action);
        }
    }

    public final void C(long refreshBlockUin) {
        QLog.i("MiniHomeConnectMapComponent", 1, "refreshMap");
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            SceneEvent sceneEvent = new SceneEvent();
            sceneEvent.uin.set(refreshBlockUin);
            sceneEvent.scene_event.set(0);
            iFilamentNativeAppV2305.dispatchEvent(new MiniHomeConnectSceneEventHandler.b(sceneEvent));
        }
    }

    public final void v(long reqUin) {
        QLog.i("MiniHomeConnectMapComponent", 1, "doStopPreView");
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            NativeDoFlowerOp$NativeFlowerStopPreview nativeDoFlowerOp$NativeFlowerStopPreview = new NativeDoFlowerOp$NativeFlowerStopPreview();
            nativeDoFlowerOp$NativeFlowerStopPreview.uin.set(reqUin);
            iFilamentNativeAppV2305.dispatchEvent(new MiniHomeConnectHuatengHandler.f(nativeDoFlowerOp$NativeFlowerStopPreview));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(b.OnClickGift event) {
        MiniHomeConnectedController miniHomeConnectedController;
        String l3 = event != null ? Long.valueOf(event.getUin()).toString() : null;
        if (l3 == null || l3.length() == 0) {
            QLog.e("MiniHomeConnectMapComponent", 1, "doOnClickGift error, friendUin in event empty.");
            return;
        }
        WeakReference<MiniHomeConnectedController> weakReference = this.controllerRef;
        if (weakReference == null || (miniHomeConnectedController = weakReference.get()) == null) {
            return;
        }
        miniHomeConnectedController.g0(l3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(MiniHomeConnectPlayCoupleActionHandler.c event) {
        CoupleActionChannel$PlayCoupleActionRsp rsp;
        PBBoolField pBBoolField;
        QLog.i("MiniHomeConnectMapComponent", 1, "doOnPlayCoupleActionRspEvent, success: " + ((event == null || (rsp = event.getRsp()) == null || (pBBoolField = rsp.success) == null) ? false : pBBoolField.get()));
        if (event != null) {
            this.controller.c0(event.getReqActionId());
        }
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        Intrinsics.checkNotNull(f16);
        CorountineFunKt.e(f16, "MiniHomeConnectMapComponent requestReportPlayActionEvent", null, null, null, new MiniHomeConnectMapComponent$doOnPlayCoupleActionRspEvent$2(event, this, null), 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s(c.StartupParam event) {
        String e16;
        long j3;
        String str;
        ActionData actionData;
        if (event == null) {
            return;
        }
        StartUpParams startUpParams = this.startUpParams;
        if (startUpParams == null || (e16 = startUpParams.getFriendUin()) == null) {
            e16 = bb.f335811a.e();
        }
        long j16 = 0;
        long parseLong = e16 != null ? Long.parseLong(e16) : 0L;
        StartUpParams startUpParams2 = this.startUpParams;
        MapMode modeType = startUpParams2 != null ? startUpParams2.getModeType() : null;
        try {
            StartUpParams startUpParams3 = this.startUpParams;
            if (startUpParams3 == null || (str = startUpParams3.getPageData()) == null) {
                str = "";
            }
            actionData = (ActionData) new Gson().fromJson(str, ActionData.class);
            QLog.i("MiniHomeConnectMapComponent", 1, "actionData: " + actionData);
            j3 = actionData.getActionId();
        } catch (Throwable th5) {
            th = th5;
            j3 = 0;
        }
        try {
            j16 = actionData.getActionUin();
        } catch (Throwable th6) {
            th = th6;
            QLog.i("MiniHomeConnectMapComponent", 1, "parse page data error=" + th);
            long j17 = j16;
            long j18 = j3;
            QLog.i("MiniHomeConnectMapComponent", 1, "ZPlanSceneStartupEvent.StartupParam event, startupparams: " + this.startUpParams + ", centerUin: " + parseLong + ", focus: " + modeType + ", actionId: " + j18 + ", actionUin: " + j17);
            c.a callback = event.getCallback();
            if (modeType == MapMode.GLOBAL) {
            }
            StartupParamConfig startupParamConfig = StartupParamConfig.f334482a;
            callback.a(new c.Param(parseLong, r10, j18, j17, startupParamConfig.a(), startupParamConfig.b(), this.controller.L()));
        }
        long j172 = j16;
        long j182 = j3;
        QLog.i("MiniHomeConnectMapComponent", 1, "ZPlanSceneStartupEvent.StartupParam event, startupparams: " + this.startUpParams + ", centerUin: " + parseLong + ", focus: " + modeType + ", actionId: " + j182 + ", actionUin: " + j172);
        c.a callback2 = event.getCallback();
        boolean z16 = modeType == MapMode.GLOBAL;
        StartupParamConfig startupParamConfig2 = StartupParamConfig.f334482a;
        callback2.a(new c.Param(parseLong, z16, j182, j172, startupParamConfig2.a(), startupParamConfig2.b(), this.controller.L()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(b.OnClickCreateMiniXW event) {
        MiniHomeConnectedController miniHomeConnectedController;
        if (event == null) {
            return;
        }
        long uin = event.getUin();
        String e16 = bb.f335811a.e();
        boolean z16 = false;
        if (e16 != null && uin == Long.parseLong(e16)) {
            z16 = true;
        }
        if (!z16) {
            QLog.e("MiniHomeConnectMapComponent", 1, "not self, return.");
            return;
        }
        WeakReference<MiniHomeConnectedController> weakReference = this.controllerRef;
        if (weakReference == null || (miniHomeConnectedController = weakReference.get()) == null) {
            return;
        }
        miniHomeConnectedController.f0(uin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(MiniHomeConnectHuatengHandler.c event) {
        FlowerOpType flowerOpType;
        if (event == null) {
            return;
        }
        QLog.i("MiniHomeConnectMapComponent", 1, "doFlowerOpRsp, " + event.getReqOp());
        FlowerOpRspData a16 = FlowerOpRspData.INSTANCE.a(event.getRsp());
        if (a16 != null) {
            ri3.c cVar = this.viewModel;
            h.Companion companion = com.tencent.filament.zplan.scene.xwconnect.data.h.INSTANCE;
            int reqOp = event.getReqOp();
            FlowerOpType[] values = FlowerOpType.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    flowerOpType = null;
                    break;
                }
                flowerOpType = values[i3];
                if (flowerOpType.getValue() == reqOp) {
                    break;
                } else {
                    i3++;
                }
            }
            if (flowerOpType != null) {
                cVar.P1(new FlowerOpRsp(flowerOpType, a16));
                return;
            }
            throw new IllegalArgumentException("Invalid value: " + reqOp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(MiniHomeConnectFocusStateHandler.c event) {
        if (event == null) {
            return;
        }
        long j3 = event.getReq().host_uin.get();
        boolean z16 = event.getReq().host_have_own_room.get();
        this.viewModel.R1(new MapModeInfo(MapMode.INSTANCE.a(event.getReq().state.get(), MapMode.UNKNOWN), Long.valueOf(j3), Boolean.valueOf(z16), event.getReq().host_name.get()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(MiniHomeConnectHuatengHandler.d event) {
        if (event == null) {
            return;
        }
        QLog.i("MiniHomeConnectMapComponent", 1, "doShowFlowerUi");
        FlowerUiData a16 = FlowerUiData.INSTANCE.a(event.getReq());
        if (a16 != null) {
            this.viewModel.Q1(a16);
        }
    }
}

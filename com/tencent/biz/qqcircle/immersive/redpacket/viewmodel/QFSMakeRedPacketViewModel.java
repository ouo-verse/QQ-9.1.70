package com.tencent.biz.qqcircle.immersive.redpacket.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.datacardcover.interceptor.QFSGetCoverFeedRequest;
import com.tencent.biz.qqcircle.immersive.redpacket.request.QFSGetRedPacketNumRequest;
import com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.QFSMakeRedPacketViewModel;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.wink.listener.IRedPacketCategoryListener;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.sender.call.Call;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudDatacard$GetRedPocketNumberRsp;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 L2\u00020\u0001:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J,\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0002J,\u0010\n\u001a\u00020\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0002J(\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0016J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u001e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020.0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010\u001eR\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020.0 8\u0006\u00a2\u0006\f\n\u0004\b1\u0010\"\u001a\u0004\b2\u0010$R \u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000205040\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010\u001eR#\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000205040 8\u0006\u00a2\u0006\f\n\u0004\b8\u0010\"\u001a\u0004\b9\u0010$R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020@0?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020@0?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010BR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006N"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/QFSMakeRedPacketViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "f2", "X1", "T1", "Lkotlin/Function0;", "action1", "action2", "R1", "U1", "Landroid/content/Context;", "context", "", ZPlanPublishSource.FROM_SCHEME, MiniAppGetGameTaskTicketServlet.KEY_TASKID, "k2", "getLogTag", "Landroid/content/Intent;", "intent", "j2", "e2", "d2", SemanticAttributes.DbSystemValues.H2, "", "isH5", "i2", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/a;", "i", "Landroidx/lifecycle/MutableLiveData;", "_dialogState", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "W1", "()Landroidx/lifecycle/LiveData;", "dialogState", "Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/b;", "numberData", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/interceptor/a;", "D", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/interceptor/a;", "coverFeedUIStateManager", "", "E", "_makeRedPacketRemainNum", UserInfo.SEX_FEMALE, ICustomDataEditor.STRING_ARRAY_PARAM_2, "makeRedPacketRemainNum", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "G", "_redPacketMaterial", "H", "c2", "redPacketMaterial", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "I", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "Lcom/tencent/richframework/sender/call/Call$OnRspCallBack;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "J", "Lcom/tencent/richframework/sender/call/Call$OnRspCallBack;", "getRemainNumCallback", "K", "getFeedNumCallback", "Lcom/tencent/mobileqq/wink/listener/IRedPacketCategoryListener;", "L", "Lcom/tencent/mobileqq/wink/listener/IRedPacketCategoryListener;", "getMaterialCallback", "<init>", "()V", "M", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSMakeRedPacketViewModel extends BaseViewModel {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final IWinkEditorResourceAPI N;

    @NotNull
    private static final IAECameraLauncher P;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private volatile NumData numberData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.biz.qqcircle.immersive.datacardcover.interceptor.a coverFeedUIStateManager;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<long[]> _makeRedPacketRemainNum;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<long[]> makeRedPacketRemainNum;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<MetaCategory>> _redPacketMaterial;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<MetaCategory>> redPacketMaterial;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private QCircleInitBean initBean;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Call.OnRspCallBack<QCircleBaseRequest> getRemainNumCallback;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Call.OnRspCallBack<QCircleBaseRequest> getFeedNumCallback;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final IRedPacketCategoryListener getMaterialCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<DialogState> _dialogState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<DialogState> dialogState;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/QFSMakeRedPacketViewModel$a;", "", "T", "Landroidx/lifecycle/MutableLiveData;", "value", "", "b", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "", "TAG", "Ljava/lang/String;", "Lcom/tencent/aelight/camera/entry/api/IAECameraLauncher;", "aeCameraLauncherApi", "Lcom/tencent/aelight/camera/entry/api/IAECameraLauncher;", "Lcom/tencent/mobileqq/wink/api/IWinkEditorResourceAPI;", "winkResApi", "Lcom/tencent/mobileqq/wink/api/IWinkEditorResourceAPI;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.QFSMakeRedPacketViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(MutableLiveData this_setValueSafely, Object obj) {
            Intrinsics.checkNotNullParameter(this_setValueSafely, "$this_setValueSafely");
            this_setValueSafely.setValue(obj);
        }

        public final <T> void b(@NotNull final MutableLiveData<T> mutableLiveData, final T t16) {
            Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
            if (RFWThreadManager.isMainThread()) {
                mutableLiveData.setValue(t16);
            } else {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSMakeRedPacketViewModel.Companion.c(MutableLiveData.this, t16);
                    }
                });
            }
        }

        Companion() {
        }
    }

    static {
        QRouteApi api = QRoute.api(IWinkEditorResourceAPI.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IWinkEditorResourceAPI::class.java)");
        N = (IWinkEditorResourceAPI) api;
        QRouteApi api2 = QRoute.api(IAECameraLauncher.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(IAECameraLauncher::class.java)");
        P = (IAECameraLauncher) api2;
    }

    public QFSMakeRedPacketViewModel() {
        com.tencent.biz.qqcircle.immersive.redpacket.util.d.f89585a.h();
        MutableLiveData<DialogState> mutableLiveData = new MutableLiveData<>();
        this._dialogState = mutableLiveData;
        this.dialogState = mutableLiveData;
        this.numberData = new NumData(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        this.coverFeedUIStateManager = new com.tencent.biz.qqcircle.immersive.datacardcover.interceptor.a();
        MutableLiveData<long[]> mutableLiveData2 = new MutableLiveData<>();
        this._makeRedPacketRemainNum = mutableLiveData2;
        this.makeRedPacketRemainNum = mutableLiveData2;
        MutableLiveData<List<MetaCategory>> mutableLiveData3 = new MutableLiveData<>();
        this._redPacketMaterial = mutableLiveData3;
        this.redPacketMaterial = mutableLiveData3;
        this.getRemainNumCallback = new Call.OnRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.d
            @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
            public final void onReceive(boolean z16, long j3, String str, Object obj, Object obj2, Bundle bundle) {
                QFSMakeRedPacketViewModel.g2(QFSMakeRedPacketViewModel.this, z16, j3, str, (QCircleBaseRequest) obj, obj2, bundle);
            }
        };
        this.getFeedNumCallback = new Call.OnRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.e
            @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
            public final void onReceive(boolean z16, long j3, String str, Object obj, Object obj2, Bundle bundle) {
                QFSMakeRedPacketViewModel.Z1(QFSMakeRedPacketViewModel.this, z16, j3, str, (QCircleBaseRequest) obj, obj2, bundle);
            }
        };
        this.getMaterialCallback = new IRedPacketCategoryListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.f
            @Override // com.tencent.mobileqq.wink.listener.IRedPacketCategoryListener
            public final void onRedPacketCategoryReady(List list) {
                QFSMakeRedPacketViewModel.b2(QFSMakeRedPacketViewModel.this, list);
            }
        };
    }

    private final void R1(final Function0<Unit> action1, final Function0<Unit> action2) {
        QLog.d("QFSMakeRedPacketViewModel", 1, "checkBeforeJump, numberData:" + this.numberData);
        if (!this.numberData.c()) {
            return;
        }
        if (!uq3.c.C0()) {
            Integer remainNum = this.numberData.getRemainNum();
            Intrinsics.checkNotNull(remainNum);
            if (remainNum.intValue() <= 0) {
                return;
            }
        }
        INSTANCE.b(this._dialogState, new DialogState(1, null, 2, null));
        boolean isCameraResReady = P.isCameraResReady(new IAEMultiDownloadCallBack() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.c
            @Override // com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack
            public final void onAEMultiDownloadFinish(AEResInfo aEResInfo, boolean z16, int i3) {
                QFSMakeRedPacketViewModel.S1(QFSMakeRedPacketViewModel.this, action1, action2, aEResInfo, z16, i3);
            }
        });
        QLog.d("QFSMakeRedPacketViewModel", 1, "checkBeforeJump, isResReady:" + isCameraResReady);
        if (isCameraResReady) {
            U1(action1, action2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(QFSMakeRedPacketViewModel this$0, Function0 function0, Function0 function02, AEResInfo aEResInfo, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QFSMakeRedPacketViewModel", 1, "checkBeforeJump, downloaded:" + z16 + ", errorType:" + i3);
        if (z16) {
            this$0.U1(function0, function02);
            return;
        }
        Companion companion = INSTANCE;
        companion.b(this$0._dialogState, new DialogState(2, null, 2, null));
        MutableLiveData<DialogState> mutableLiveData = this$0._dialogState;
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f19154453);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qfs_make_\u2026_packet_click_res_failed)");
        companion.b(mutableLiveData, new DialogState(7, a16));
    }

    private final void T1() {
        QLog.d("QFSMakeRedPacketViewModel", 1, "checkDataReady, numberData:" + this.numberData);
        if (!this.numberData.c()) {
            return;
        }
        Companion companion = INSTANCE;
        companion.b(this._dialogState, new DialogState(2, null, 2, null));
        if (this.numberData.d()) {
            companion.b(this._dialogState, new DialogState(3, null, 2, null));
            return;
        }
        Integer remainNum = this.numberData.getRemainNum();
        if (remainNum != null && remainNum.intValue() == 0 && !uq3.c.C0()) {
            companion.b(this._dialogState, new DialogState(5, null, 2, null));
        }
    }

    private final void U1(Function0<Unit> action1, Function0<Unit> action2) {
        INSTANCE.b(this._dialogState, new DialogState(2, null, 2, null));
        Integer feedNum = this.numberData.getFeedNum();
        Intrinsics.checkNotNull(feedNum);
        if (feedNum.intValue() <= 0) {
            if (action1 != null) {
                action1.invoke();
            }
        } else if (action2 != null) {
            action2.invoke();
        }
    }

    private final void X1() {
        QLog.d("QFSMakeRedPacketViewModel", 1, "getFeedNum ");
        QCircleRequestCall j3 = com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().j(this.coverFeedUIStateManager);
        String currentAccount = QCircleCommonUtil.getCurrentAccount();
        Intrinsics.checkNotNullExpressionValue(currentAccount, "getCurrentAccount()");
        j3.addRequest(new QFSGetCoverFeedRequest.b(currentAccount).f(8).a()).m250setRspOnCallBack((Call.OnRspCallBack) this.getFeedNumCallback).execute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(QFSMakeRedPacketViewModel this$0, boolean z16, long j3, String str, QCircleBaseRequest qCircleBaseRequest, Object obj, Bundle bundle) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QFSMakeRedPacketViewModel", 1, "getFeedNumCallback, onReceive, traceId: " + qCircleBaseRequest.getTraceId() + ", isSuccess: " + z16 + ", retCode: " + j3 + ", errMsg: " + str + ", isCache: " + VSNetworkHelper.isProtocolCache(str));
        if (obj instanceof UIStateData) {
            UIStateData uIStateData = (UIStateData) obj;
            if (uIStateData.getState() == 4) {
                this$0.numberData.i(-1);
                this$0.T1();
                return;
            }
            NumData numData = this$0.numberData;
            List list = (List) uIStateData.getData();
            if (list != null) {
                i3 = list.size();
            } else {
                i3 = 0;
            }
            numData.i(Integer.valueOf(i3));
            this$0.T1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(QFSMakeRedPacketViewModel this$0, List list) {
        boolean z16;
        List<MetaCategory> emptyList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w("QFSMakeRedPacketViewModel", 1, "getRedPacketMaterialCategory, ret is null or empty ");
            MutableLiveData<List<MetaCategory>> mutableLiveData = this$0._redPacketMaterial;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            mutableLiveData.postValue(emptyList);
            return;
        }
        QLog.w("QFSMakeRedPacketViewModel", 1, "getRedPacketMaterialCategory, data size:" + list.size());
        this$0._redPacketMaterial.postValue(list);
    }

    private final void f2() {
        QLog.d("QFSMakeRedPacketViewModel", 1, "getRemainNum ");
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().addRequest(new QFSGetRedPacketNumRequest.a().a()).m250setRspOnCallBack((Call.OnRspCallBack) this.getRemainNumCallback).execute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(QFSMakeRedPacketViewModel this$0, boolean z16, long j3, String str, QCircleBaseRequest qCircleBaseRequest, Object obj, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QFSMakeRedPacketViewModel", 1, "getRemainNumCallback, onReceive, traceId: " + qCircleBaseRequest.getTraceId() + ", isSuccess: " + z16 + ", retCode: " + j3 + ", errMsg: " + str);
        if (obj instanceof FeedCloudDatacard$GetRedPocketNumberRsp) {
            if (z16 && j3 == 0) {
                FeedCloudDatacard$GetRedPocketNumberRsp feedCloudDatacard$GetRedPocketNumberRsp = (FeedCloudDatacard$GetRedPocketNumberRsp) obj;
                long j16 = feedCloudDatacard$GetRedPocketNumberRsp.left_num.get();
                long j17 = feedCloudDatacard$GetRedPocketNumberRsp.check_num.get();
                QLog.d("QFSMakeRedPacketViewModel", 1, "getRemainNumCallback, onReceive, leftNum:" + j16 + ", checkNum:" + j17);
                this$0._makeRedPacketRemainNum.postValue(new long[]{j16, j17});
                this$0.numberData.j(Integer.valueOf((int) j16));
                this$0.T1();
                return;
            }
            this$0.numberData.j(-1);
            this$0.T1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k2(Context context, String scheme, String taskId) {
        HashMap<String, String> hashMap;
        com.tencent.biz.qqcircle.immersive.redpacket.util.d dVar = com.tencent.biz.qqcircle.immersive.redpacket.util.d.f89585a;
        QCircleInitBean qCircleInitBean = this.initBean;
        if (qCircleInitBean != null && (hashMap = qCircleInitBean.getSchemeAttrs()) != null) {
            if (taskId == null) {
                return;
            }
            hashMap.put("taskid", taskId);
            Unit unit = Unit.INSTANCE;
        } else {
            hashMap = null;
        }
        dVar.f(context, scheme, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void l2(QFSMakeRedPacketViewModel qFSMakeRedPacketViewModel, Context context, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        qFSMakeRedPacketViewModel.k2(context, str, str2);
    }

    @NotNull
    public final LiveData<DialogState> W1() {
        return this.dialogState;
    }

    @NotNull
    public final LiveData<long[]> a2() {
        return this.makeRedPacketRemainNum;
    }

    @NotNull
    public final LiveData<List<MetaCategory>> c2() {
        return this.redPacketMaterial;
    }

    public final void d2() {
        N.getRedPacketMaterialCategory(this.getMaterialCallback);
    }

    public final void e2() {
        QLog.d("QFSMakeRedPacketViewModel", 1, "getRemainAndFeedNum, numberData:" + this.numberData);
        INSTANCE.b(this._dialogState, new DialogState(1, null, 2, null));
        if (this.numberData.h()) {
            f2();
        }
        if (this.numberData.f()) {
            X1();
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMakeRedPacketViewModel";
    }

    public final void h2(@NotNull final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.d("QFSMakeRedPacketViewModel", 1, "handMakeRedPacket ");
        R1(new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.QFSMakeRedPacketViewModel$handMakeRedPacket$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QFSMakeRedPacketViewModel.l2(QFSMakeRedPacketViewModel.this, context, null, "qqhongbao-1", 2, null);
            }
        }, new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.QFSMakeRedPacketViewModel$handMakeRedPacket$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QCircleInitBean qCircleInitBean;
                com.tencent.biz.qqcircle.immersive.redpacket.util.d dVar = com.tencent.biz.qqcircle.immersive.redpacket.util.d.f89585a;
                Context context2 = context;
                qCircleInitBean = this.initBean;
                dVar.d(context2, qCircleInitBean != null ? qCircleInitBean.getSchemeAttrs() : null);
            }
        });
    }

    public final void i2(@NotNull final Context context, @NotNull final String scheme, boolean isH5) {
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        if (isH5) {
            function0 = new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.QFSMakeRedPacketViewModel$handleTemplateClick$action$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.tencent.biz.qqcircle.immersive.redpacket.util.d.f89585a.e(context, scheme);
                }
            };
        } else {
            function0 = new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.QFSMakeRedPacketViewModel$handleTemplateClick$action$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QFSMakeRedPacketViewModel.this.k2(context, scheme, "qqhongbao-2");
                }
            };
        }
        R1(function0, function0);
    }

    public final void j2(@NotNull Intent intent) {
        QCircleInitBean qCircleInitBean;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
        if (serializableExtra instanceof QCircleInitBean) {
            qCircleInitBean = (QCircleInitBean) serializableExtra;
        } else {
            qCircleInitBean = null;
        }
        this.initBean = qCircleInitBean;
    }
}

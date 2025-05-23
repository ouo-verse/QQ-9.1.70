package com.tencent.mobileqq.qwallet.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.data.TenPayInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppGroup;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$Declaim;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$RedDot;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$VirtualEntity;
import com.qwallet.utils.QWalletUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tenpay.api.TenpayInterface;
import cooperation.qwallet.plugin.ipc.QWalletRedTouchInfo;
import cooperation.qwallet.plugin.ipc.TickReq;
import cooperation.qwallet.plugin.ipc.WalletHomeReq;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b`\u0010aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\b\u0010\u001b\u001a\u00020\u0006H\u0007J \u0010!\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u000e\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0002J\u0014\u0010&\u001a\u00020\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120$J\u0014\u0010)\u001a\u00020\u00062\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0$R(\u0010/\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R(\u00102\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b1\u0010.R$\u0010:\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020<0;8\u0006\u00a2\u0006\f\n\u0004\b1\u0010=\u001a\u0004\b>\u0010?R\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020A0;8\u0006\u00a2\u0006\f\n\u0004\b>\u0010=\u001a\u0004\bB\u0010?R#\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0$0;8\u0006\u00a2\u0006\f\n\u0004\bE\u0010=\u001a\u0004\bF\u0010?R/\u0010J\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120$\u0012\u0004\u0012\u00020\u001c0H0;8\u0006\u00a2\u0006\f\n\u0004\bI\u0010=\u001a\u0004\b0\u0010?R#\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0$0;8\u0006\u00a2\u0006\f\n\u0004\bL\u0010=\u001a\u0004\b4\u0010?R\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00040;8\u0006\u00a2\u0006\f\n\u0004\bN\u0010=\u001a\u0004\b+\u0010?R\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010WR\u0014\u0010Z\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010YR$\u0010_\u001a\u0012\u0012\u0004\u0012\u00020\u001c0[j\b\u0012\u0004\u0012\u00020\u001c`\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/HomeLegacyBizManager;", "Landroidx/lifecycle/LifecycleObserver;", "", "path", "", "p", "", DomainData.DOMAIN_NAME, "isAppLoadFinished", "Landroid/os/ResultReceiver;", "receiver", ReportConstant.COSTREPORT_PREFIX, "Landroid/content/Context;", "context", "l", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "r", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$RedDot;", "carouselRedDot", "c", "w", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onCreate", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "redPath", "d", "", "carouselRedDotList", "u", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppGroup;", "appList", "t", "<set-?>", "e", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "tenpayData", "f", "i", "iapData", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$Declaim;", tl.h.F, "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$Declaim;", "g", "()Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$Declaim;", "v", "(Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$Declaim;)V", "declaim", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qwallet/data/TenPayInfo;", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroidx/lifecycle/MutableLiveData;", "tenpayInfoLiveData", "", "j", "qcoinLiveData", "Lcooperation/qwallet/plugin/ipc/QWalletRedTouchInfo;", BdhLogUtil.LogTag.Tag_Conn, "o", "trueRedPointLiveData", "Lkotlin/Pair;", "D", "carouselRedDotLiveData", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$VirtualEntity;", "E", "h5VirtualEntities", UserInfo.SEX_FEMALE, "appSwitched", "Lcom/qwallet/activity/patternlock/biz/a;", "G", "Lcom/qwallet/activity/patternlock/biz/a;", "mPatternLockBiz", "H", "I", "stayType", "J", "stayStart", "Z", "isMainProcess", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "K", "Ljava/util/ArrayList;", "currentAppIdList", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HomeLegacyBizManager implements LifecycleObserver {

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private static com.qwallet.activity.patternlock.biz.a mPatternLockBiz;

    /* renamed from: I, reason: from kotlin metadata */
    private static long stayStart;

    /* renamed from: J, reason: from kotlin metadata */
    private static final boolean isMainProcess;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private static final ArrayList<Integer> currentAppIdList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String tenpayData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String iapData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static QWalletHomePage$Declaim declaim;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final HomeLegacyBizManager f277929d = new HomeLegacyBizManager();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<TenPayInfo> tenpayInfoLiveData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<Long> qcoinLiveData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private static final MutableLiveData<List<QWalletRedTouchInfo>> trueRedPointLiveData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private static final MutableLiveData<Pair<List<QWalletHomePage$RedDot>, Integer>> carouselRedDotLiveData = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private static final MutableLiveData<List<QWalletHomePage$VirtualEntity>> h5VirtualEntities = new MutableLiveData<>();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private static final MutableLiveData<Boolean> appSwitched = new MutableLiveData<>();

    /* renamed from: H, reason: from kotlin metadata */
    private static int stayType = 1;

    static {
        boolean z16 = true;
        if (MobileQQ.sProcessId != 1) {
            z16 = false;
        }
        isMainProcess = z16;
        currentAppIdList = new ArrayList<>();
    }

    HomeLegacyBizManager() {
    }

    private final boolean c(QWalletHomePage$RedDot carouselRedDot) {
        if (!currentAppIdList.contains(Integer.valueOf(carouselRedDot.app_id.get())) || !d.f278053a.c(carouselRedDot)) {
            return false;
        }
        String g16 = QWalletUtils.g(carouselRedDot.app_id.get());
        Intrinsics.checkNotNullExpressionValue(g16, "getSwitchAppKey(carouselRedDot.app_id.get())");
        return com.tencent.mobileqq.qwallet.utils.g.c(g16, true);
    }

    private final void l(Context context) {
        ResultReceiver resultReceiver = new ResultReceiver() { // from class: com.tencent.mobileqq.qwallet.home.HomeLegacyBizManager$getTenpayData$queryTenpayResultReceiver$1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, @NotNull Bundle resultData) {
                Intrinsics.checkNotNullParameter(resultData, "resultData");
                super.onReceiveResult(resultCode, resultData);
                String string = resultData.getString("retmsg");
                if (string == null) {
                    string = "";
                }
                if (resultCode == 0) {
                    HomeLegacyBizManager.tenpayData = string;
                    try {
                        TenPayInfo d16 = TenPayInfo.d(new JSONObject(string));
                        HomeLegacyBizManager.f277929d.m().postValue(d16);
                        com.tencent.mobileqq.qwallet.utils.g.l("qwallet_is_pws_enter_" + com.tencent.mobileqq.base.a.c(), d16.a());
                        return;
                    } catch (JSONException e16) {
                        QLog.e("HomeLegacyBizManager", 1, "onReceiveResult: parse tenpayInfo fail", e16);
                        return;
                    }
                }
                QLog.e("HomeLegacyBizManager", 1, "qwallet.cgi fail: " + resultCode + " " + string);
            }
        };
        HashMap hashMap = new HashMap();
        hashMap.put(com.tencent.mobileqq.msf.core.c0.j.T0, "appid#0|bargainor_id#0|channel#wallet");
        TenpayInterface.requestData(context, "qwallet", com.tencent.mobileqq.base.a.c(), hashMap, resultReceiver);
    }

    private final void n() {
        final Handler handler = new Handler(Looper.getMainLooper());
        s(true, new ResultReceiver(handler) { // from class: com.tencent.mobileqq.qwallet.home.HomeLegacyBizManager$getTrueRedPoint$resultReceiver$1
            /* JADX WARN: Code restructure failed: missing block: B:9:0x0033, code lost:
            
                r3 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r3);
             */
            @Override // android.os.ResultReceiver
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            protected void onReceiveResult(int code, @Nullable Bundle data) {
                ArrayList arrayList;
                List<QWalletRedTouchInfo> filterNotNull;
                if (data == null) {
                    return;
                }
                Serializable serializable = data.getSerializable("_qwallet_ipc_WalletHome_resp");
                if (serializable instanceof ArrayList) {
                    arrayList = (ArrayList) serializable;
                } else {
                    arrayList = null;
                }
                QLog.d("HomeLegacyBizManager", 1, "getTrueRedPoint: " + arrayList + " ");
                if (arrayList != null && filterNotNull != null) {
                    HomeLegacyBizManager.f277929d.o().setValue(filterNotNull);
                }
            }
        });
    }

    @JvmStatic
    public static final boolean p(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        List<QWalletRedTouchInfo> value = trueRedPointLiveData.getValue();
        Object obj = null;
        if (value != null) {
            Iterator<T> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((QWalletRedTouchInfo) next).path, path)) {
                    obj = next;
                    break;
                }
            }
            obj = (QWalletRedTouchInfo) obj;
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    private final void r(Activity activity) {
        ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).queryQbData(activity, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.qwallet.home.HomeLegacyBizManager$queryQbData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String result) {
                Intrinsics.checkNotNullParameter(result, "result");
                try {
                    JSONObject jSONObject = new JSONObject(result);
                    if (jSONObject.optInt("ret", -1) == 0) {
                        HomeLegacyBizManager.iapData = result;
                        HomeLegacyBizManager.f277929d.j().postValue(Long.valueOf(jSONObject.optInt("qb_balance") + jSONObject.optLong("qd_balance")));
                    }
                } catch (JSONException e16) {
                    QLog.e("HomeLegacyBizManager", 1, "onFinish: parse qcoin failed", e16);
                }
            }
        });
    }

    private final void s(boolean isAppLoadFinished, ResultReceiver receiver) {
        WalletHomeReq walletHomeReq = new WalletHomeReq();
        walletHomeReq.type = 1;
        walletHomeReq.fromReceiver = receiver;
        walletHomeReq.isAppLoadFinished = isAppLoadFinished;
        ArrayList<String> arrayList = new ArrayList<>();
        walletHomeReq.redTouchPaths = arrayList;
        arrayList.add("100007.100013");
        walletHomeReq.redTouchPaths.add("100007.100014");
        walletHomeReq.redTouchPaths.add("100007.100014.100015");
        walletHomeReq.redTouchPaths.add("100007.100016");
        walletHomeReq.redTouchPaths.add("100007.100009");
        walletHomeReq.redTouchPaths.add("100007.100009.100010");
        walletHomeReq.redTouchPaths.add("100007.102100");
        walletHomeReq.redTouchPaths.add("100007.102200");
        walletHomeReq.redTouchPaths.add("100007.102300");
        walletHomeReq.redTouchPaths.add("100007.100016.100017");
        walletHomeReq.redTouchPaths.add("100007.100016.100061");
        walletHomeReq.redTouchPaths.add("100007.100016.100062");
        walletHomeReq.redTouchPaths.add("100007.100016.100063");
        walletHomeReq.redTouchPaths.add("100007.100016.100064");
        QWalletUtils.u(walletHomeReq);
    }

    private final void w() {
        List<QWalletHomePage$RedDot> first;
        Pair<List<QWalletHomePage$RedDot>, Integer> value = carouselRedDotLiveData.getValue();
        if (value != null && (first = value.getFirst()) != null) {
            u(first);
        }
    }

    public final void d(@NotNull String redPath) {
        Intrinsics.checkNotNullParameter(redPath, "redPath");
        List<QWalletRedTouchInfo> value = trueRedPointLiveData.getValue();
        if (value != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                if (!Intrinsics.areEqual(((QWalletRedTouchInfo) obj).path, redPath)) {
                    arrayList.add(obj);
                }
            }
            trueRedPointLiveData.setValue(arrayList);
        }
        TickReq tickReq = new TickReq();
        tickReq.tickType = 1;
        tickReq.redpointPath = redPath;
        QWalletUtils.u(tickReq);
    }

    @NotNull
    public final MutableLiveData<Boolean> e() {
        return appSwitched;
    }

    @NotNull
    public final MutableLiveData<Pair<List<QWalletHomePage$RedDot>, Integer>> f() {
        return carouselRedDotLiveData;
    }

    @Nullable
    public final QWalletHomePage$Declaim g() {
        return declaim;
    }

    @NotNull
    public final MutableLiveData<List<QWalletHomePage$VirtualEntity>> h() {
        return h5VirtualEntities;
    }

    @Nullable
    public final String i() {
        return iapData;
    }

    @NotNull
    public final MutableLiveData<Long> j() {
        return qcoinLiveData;
    }

    @Nullable
    public final String k() {
        return tenpayData;
    }

    @NotNull
    public final MutableLiveData<TenPayInfo> m() {
        return tenpayInfoLiveData;
    }

    @NotNull
    public final MutableLiveData<List<QWalletRedTouchInfo>> o() {
        return trueRedPointLiveData;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (isMainProcess) {
            QLog.i("HomeLegacyBizManager", 1, "onCreate: isMainProcess not show lock screen");
        } else {
            try {
                com.qwallet.activity.patternlock.biz.a b16 = com.qwallet.activity.patternlock.biz.c.a().b(0);
                mPatternLockBiz = b16;
                if (owner instanceof Activity) {
                    if (b16 != null) {
                        b16.e(new WeakReference<>(owner));
                    }
                    com.qwallet.activity.patternlock.biz.a aVar = mPatternLockBiz;
                    if (aVar != null) {
                        aVar.d();
                    }
                }
            } catch (Throwable th5) {
                QLog.e("HomeLegacyBizManager", 1, QLog.getStackTraceString(th5));
            }
        }
        n();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        tenpayData = null;
        iapData = null;
        declaim = null;
        com.qwallet.activity.patternlock.biz.a aVar = mPatternLockBiz;
        if (aVar != null) {
            aVar.f();
        }
        com.qwallet.activity.patternlock.biz.a aVar2 = mPatternLockBiz;
        if (aVar2 != null) {
            aVar2.a();
        }
        mPatternLockBiz = null;
        List<QWalletRedTouchInfo> value = trueRedPointLiveData.getValue();
        if (value != null) {
            for (QWalletRedTouchInfo qWalletRedTouchInfo : value) {
                if (qWalletRedTouchInfo.isForH5()) {
                    HomeLegacyBizManager homeLegacyBizManager = f277929d;
                    String str = qWalletRedTouchInfo.path;
                    Intrinsics.checkNotNullExpressionValue(str, "it.path");
                    homeLegacyBizManager.d(str);
                }
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        u.m("index.staytime", String.valueOf(NetConnInfoCenter.getServerTimeMillis() - stayStart), String.valueOf(stayStart), "android", null, stayType, 16, null);
        stayType = 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (owner instanceof Activity) {
            l((Context) owner);
            r((Activity) owner);
            com.qwallet.activity.patternlock.biz.a aVar = mPatternLockBiz;
            if (aVar != null) {
                aVar.h();
            }
            w();
        }
        QWalletUtils.q();
        stayStart = NetConnInfoCenter.getServerTimeMillis();
    }

    public final void q(int requestCode, int resultCode, @Nullable Intent data) {
        com.qwallet.activity.patternlock.biz.a aVar = mPatternLockBiz;
        if (aVar != null) {
            aVar.g(requestCode, resultCode);
        }
    }

    public final void t(@NotNull List<QWalletHomePage$AppGroup> appList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(appList, "appList");
        ArrayList<Integer> arrayList = currentAppIdList;
        arrayList.clear();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = appList.iterator();
        while (it.hasNext()) {
            List<QWalletHomePage$AppInfo> list = ((QWalletHomePage$AppGroup) it.next()).apps.get();
            Intrinsics.checkNotNullExpressionValue(list, "it.apps.get()");
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, list);
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            arrayList3.add(Integer.valueOf(((QWalletHomePage$AppInfo) it5.next()).f41686id.get()));
        }
        arrayList.addAll(arrayList3);
    }

    public final void u(@NotNull List<QWalletHomePage$RedDot> carouselRedDotList) {
        Object obj;
        int i3;
        PBInt32Field pBInt32Field;
        Intrinsics.checkNotNullParameter(carouselRedDotList, "carouselRedDotList");
        Iterator<T> it = carouselRedDotList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (f277929d.c((QWalletHomePage$RedDot) obj)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        QWalletHomePage$RedDot qWalletHomePage$RedDot = (QWalletHomePage$RedDot) obj;
        MutableLiveData<Pair<List<QWalletHomePage$RedDot>, Integer>> mutableLiveData = carouselRedDotLiveData;
        if (qWalletHomePage$RedDot != null && (pBInt32Field = qWalletHomePage$RedDot.app_id) != null) {
            i3 = pBInt32Field.get();
        } else {
            i3 = 0;
        }
        mutableLiveData.setValue(new Pair<>(carouselRedDotList, Integer.valueOf(i3)));
    }

    public final void v(@Nullable QWalletHomePage$Declaim qWalletHomePage$Declaim) {
        declaim = qWalletHomePage$Declaim;
    }
}

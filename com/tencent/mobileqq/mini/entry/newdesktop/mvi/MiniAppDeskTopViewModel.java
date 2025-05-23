package com.tencent.mobileqq.mini.entry.newdesktop.mvi;

import android.os.Bundle;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entity.AppBubbleRecordEntity;
import com.tencent.mobileqq.mini.entry.MiniAppRedDotEntity;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataMiniAppAdManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.DesktopMiniAppReqListener;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopIntent;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopUIState;
import com.tencent.mobileqq.mini.entry.newdesktop.repository.DesktopRedDotParseHelper;
import com.tencent.mobileqq.mini.entry.newdesktop.repository.DesktopRepositoryImpl;
import com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopRepository;
import com.tencent.mobileqq.mini.entry.newdesktop.repository.MiniAppDesktopLocalDataHelper;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.mini.util.MiniAppToastUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import eipc.EIPCModule;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 ~2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001~B\u0007\u00a2\u0006\u0004\b|\u0010}J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J \u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u001cH\u0002J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020#H\u0002J \u0010(\u001a\u00020\u00042\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020)H\u0002J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020+H\u0002J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020-H\u0002J\u0018\u00100\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u001aH\u0002J\u0018\u00103\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u001aH\u0002J\b\u00104\u001a\u00020\u0004H\u0002J\u0018\u00108\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00152\u0006\u00107\u001a\u000206H\u0002J8\u0010<\u001a\u00020\u00042.\u0010;\u001a*\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%09j\u0014\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%`:H\u0002J\u0010\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u00020=H\u0002J$\u0010C\u001a\u00020\u00042\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010AH\u0002J\u0010\u0010D\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020AH\u0002J\b\u0010E\u001a\u00020\u0015H\u0002J8\u0010F\u001a\u00020\u00152.\u0010;\u001a*\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%09j\u0014\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%`:H\u0002J\"\u0010I\u001a\u0004\u0018\u00010\r2\u0006\u0010G\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010H\u001a\u00020\u001aJ\u0010\u0010J\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J&\u0010N\u001a\u00020\u0004\"\u0004\b\u0000\u0010K*\b\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010L\u001a\u00020\u001a2\u0006\u0010M\u001a\u00020\u001aJ\u0006\u0010O\u001a\u00020\u0004J\u0016\u0010P\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001aJ&\u0010T\u001a\u00020S2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020\u001aJ\b\u0010U\u001a\u00020\u001eH\u0016J\u000e\u0010W\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u0015J\u000e\u0010Y\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u0015J\u000e\u0010[\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u0015J\u000e\u0010]\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020\u0015J\u000e\u0010_\u001a\u00020\u00042\u0006\u0010^\u001a\u00020\u0015R\u0016\u0010a\u001a\u00020`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR>\u0010c\u001a*\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%09j\u0014\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%`:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010e\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010g\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010fR\u0018\u0010i\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u001a\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00150k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u001a\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00150k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010mR\u001a\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00150k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010mR\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00150k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010mR\u001a\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00150k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010mR\u001d\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00150r8\u0006\u00a2\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR\u001d\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00150r8\u0006\u00a2\u0006\f\n\u0004\bw\u0010t\u001a\u0004\bw\u0010vR\u001d\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00150r8\u0006\u00a2\u0006\f\n\u0004\bX\u0010t\u001a\u0004\bX\u0010vR\u001d\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00150r8\u0006\u00a2\u0006\f\n\u0004\b\\\u0010t\u001a\u0004\b\\\u0010vR\u001d\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00150r8\u0006\u00a2\u0006\f\n\u0004\b^\u0010t\u001a\u0004\b^\u0010vR\u001a\u0010x\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopViewModel;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopBaseViewModel;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent;", "", "registerMiniAppRedDotObserver", "Landroid/os/Bundle;", "params", "Leipc/EIPCModule;", "eipcModule", "queryMyMiniAppInfo", "checkIsInMyAppList", "setRecentStartMiniAppListener", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "miniAppInfo", "updateRecentStartMiniAppInfo", "moveRecentAppExistMiniApp", "resetGdtMiniAppShowState", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$DeleteDesktopMiniApp;", "miniAppDesktopIntent", "deleteMiniAppInfo", "", "isSuccess", "Lorg/json/JSONObject;", "ret", "deleteItemResponse", "", "moduleType", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "getDeleteItemIndex", "", "appId", "deleteDesktopMiniAppInfo", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$MyMiniAppSwitchPosition;", "myMiniAppSwitchPosition", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$InsertMyMiniAppToTopById;", "insertMyMiniAppToTopById", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "miniAppList", "removeMiniAppItem", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$RemoveMyMiniAppTopById;", "removeMyMiniAppTopById", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$MyMiniAppDraggingTempSwitchPosition;", "myMiniAppDraggingTempSwitchPosition", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$RecentAppInsertMyAppDraggingTempSwitchPosition;", "recentAppInsertMyAppDraggingTempSwitchPosition", "position", "insertMiniAppInfo", "insertMiniAppId", "newPosition", "isNeedResetMyMiniAppInfoForInsertMiniApp", "getMiniAppDesktopLocalInfo", FileReaderHelper.OPEN_FILE_FROM_FORCE, "Lcom/tencent/mobileqq/mini/entry/desktop/GetAppListV2Scene;", "scene", "getMiniAppDesktopNetworkInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "miniAppInfoMap", "requestGdtMiniAppInfo", "Ljava/lang/Runnable;", "runnable", "runningInMainThread", "recentMiniAppInfo", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAdInfo", "insertGdtAdInfo", "convertAdDataToMiniAppInfo", "isOperateToMuch", "isTriggerAdShowByAppCount", "dataModule", "verType", "getMiniAppInfoByDesktopDataInfoMap", "handleIntent", "T", "index1", "index2", "swap", "initLocalDataState", "miniAppBubbleUpdateAppBubbleRecord", "text", "clickCount", "Lcom/tencent/mobileqq/mini/entity/AppBubbleRecordEntity;", "miniAppBubbleEnsureBubbleRecord", "getLogTag", "state", "updateSubLayoutOpenState", "isUserAccountFirstOpen", "setUserAccountFirstOpenDesktop", "isStartAppMiniAppFirstOpen", "setStartAppDesktopFirstOpen", "isDesktopOpen", "setDesktopOpen", "isAccountChange", "setAccountChange", "Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/IDesktopRepository;", "mMiniAppRepository", "Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/IDesktopRepository;", "mMiniAppInfoMap", "Ljava/util/HashMap;", "mIsNetworkDone", "Z", "mIsInitLocalData", "Lcom/tencent/mobileqq/applets/a;", "mRedDotObserver", "Lcom/tencent/mobileqq/applets/a;", "Landroidx/lifecycle/MutableLiveData;", "mSubLayoutOpenState", "Landroidx/lifecycle/MutableLiveData;", "mIsStartAppFirstOpenDesktop", "mIsUserAccountFirstOpen", "mIsDesktopOpen", "mIsAccountChange", "Landroidx/lifecycle/LiveData;", "subLayoutOpenState", "Landroidx/lifecycle/LiveData;", "getSubLayoutOpenState", "()Landroidx/lifecycle/LiveData;", "isStartAppFirstOpenDesktop", "mNoneValueIntent", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent;", "getMNoneValueIntent", "()Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent;", "<init>", "()V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class MiniAppDeskTopViewModel extends MiniAppDesktopBaseViewModel<MiniAppDeskTopUIState, MiniAppDeskTopIntent> {
    private static final int GDT_MINI_APP_MIN_SIZE = 5;
    private static final int MINI_APP_IN_MY_APP_TYPE = 1;
    private static final int MINI_APP_NOT_IN_MY_APP_TYPE = 0;
    private final LiveData<Boolean> isAccountChange;
    private final LiveData<Boolean> isDesktopOpen;
    private final LiveData<Boolean> isStartAppFirstOpenDesktop;
    private final LiveData<Boolean> isUserAccountFirstOpen;
    private final MutableLiveData<Boolean> mIsAccountChange;
    private final MutableLiveData<Boolean> mIsDesktopOpen;
    private boolean mIsInitLocalData;
    private final MutableLiveData<Boolean> mIsStartAppFirstOpenDesktop;
    private final MutableLiveData<Boolean> mIsUserAccountFirstOpen;
    private final MiniAppDeskTopIntent mNoneValueIntent;
    private com.tencent.mobileqq.applets.a mRedDotObserver;
    private final MutableLiveData<Boolean> mSubLayoutOpenState;
    private final LiveData<Boolean> subLayoutOpenState;
    private IDesktopRepository mMiniAppRepository = new DesktopRepositoryImpl();
    private HashMap<Integer, List<DesktopItemInfo>> mMiniAppInfoMap = new HashMap<>();
    private boolean mIsNetworkDone = true;

    public MiniAppDeskTopViewModel() {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this.mSubLayoutOpenState = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this.mIsStartAppFirstOpenDesktop = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this.mIsUserAccountFirstOpen = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this.mIsDesktopOpen = mutableLiveData4;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>();
        this.mIsAccountChange = mutableLiveData5;
        this.subLayoutOpenState = mutableLiveData;
        this.isStartAppFirstOpenDesktop = mutableLiveData2;
        this.isUserAccountFirstOpen = mutableLiveData3;
        this.isDesktopOpen = mutableLiveData4;
        this.isAccountChange = mutableLiveData5;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.mvi.a
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppDeskTopViewModel._init_$lambda$0(MiniAppDeskTopViewModel.this);
            }
        }, 16, null, true);
        this.mNoneValueIntent = MiniAppDeskTopIntent.NONE.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(MiniAppDeskTopViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setRecentStartMiniAppListener();
    }

    private final void checkIsInMyAppList(Bundle params, EIPCModule eipcModule) {
        if (!(eipcModule instanceof MiniAppTransferModule)) {
            QLog.e(getTAG(), 1, "eipcModule is not MiniAppTransferModule type!");
            return;
        }
        if (params.containsKey("appId") && params.containsKey("callbackId")) {
            String string = params.getString("appId");
            int i3 = params.getInt("callbackId");
            Bundle bundle = new Bundle();
            MiniAppInfo miniAppInfoByDesktopDataInfoMap = getMiniAppInfoByDesktopDataInfoMap(3, string, 3);
            if (miniAppInfoByDesktopDataInfoMap == null) {
                bundle.putBoolean("isAdded", false);
            } else {
                bundle.putBoolean("isAdded", true);
            }
            QLog.i(getTAG(), 1, "checkIsInMyAppList isAdded:" + miniAppInfoByDesktopDataInfoMap);
            eipcModule.callbackResult(i3, EIPCResult.createResult(0, bundle));
            return;
        }
        QLog.e(getTAG(), 1, "appId\u3001callbackId has not contain!");
    }

    private final DesktopAppInfo convertAdDataToMiniAppInfo(GdtAd gdtAdInfo) {
        MiniAppInfo miniAppInfo = new MiniAppInfo();
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = gdtAdInfo.info;
        Intrinsics.checkNotNull(adInfo);
        miniAppInfo.appId = adInfo.display_info.mini_program_id.get();
        qq_ad_get.QQAdGetRsp.AdInfo adInfo2 = gdtAdInfo.info;
        Intrinsics.checkNotNull(adInfo2);
        miniAppInfo.name = adInfo2.display_info.mini_program_name.get();
        qq_ad_get.QQAdGetRsp.AdInfo adInfo3 = gdtAdInfo.info;
        Intrinsics.checkNotNull(adInfo3);
        miniAppInfo.iconUrl = adInfo3.display_info.basic_info.img.get();
        miniAppInfo.isGdtMiniAppAd = true;
        miniAppInfo.gdtAdInfo = gdtAdInfo;
        miniAppInfo.verType = 3;
        DesktopAppInfo desktopAppInfo = new DesktopAppInfo(1, miniAppInfo);
        String tag = getTAG();
        qq_ad_get.QQAdGetRsp.AdInfo adInfo4 = gdtAdInfo.info;
        Intrinsics.checkNotNull(adInfo4);
        String str = adInfo4.display_info.mini_program_id.get();
        qq_ad_get.QQAdGetRsp.AdInfo adInfo5 = gdtAdInfo.info;
        Intrinsics.checkNotNull(adInfo5);
        QLog.d(tag, 1, "gdt mini app info appId:" + str + " appName:" + adInfo5.display_info.mini_program_name.get());
        return desktopAppInfo;
    }

    private final void deleteDesktopMiniAppInfo(int moduleType, String appId) {
        List<DesktopItemInfo> list = this.mMiniAppInfoMap.get(Integer.valueOf(moduleType));
        if (list == null || list.isEmpty()) {
            QLog.d(getTAG(), 1, "deleteShowMiniAppInfo moduleType:" + moduleType + " miniAppInfoMap is isNullOrEmpty!");
            return;
        }
        List<DesktopItemInfo> list2 = this.mMiniAppInfoMap.get(Integer.valueOf(moduleType));
        Intrinsics.checkNotNull(list2);
        Iterator<DesktopItemInfo> it = list2.iterator();
        while (it.hasNext()) {
            DesktopItemInfo next = it.next();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo");
            DesktopAppInfo desktopAppInfo = (DesktopAppInfo) next;
            if (desktopAppInfo.mMiniAppInfo.appId.equals(appId)) {
                it.remove();
                QLog.d(getTAG(), 1, "DeleteDesktopMiniApp cache name:" + desktopAppInfo.mMiniAppInfo.name);
                return;
            }
        }
    }

    private final void deleteItemResponse(MiniAppDeskTopIntent.DeleteDesktopMiniApp miniAppDesktopIntent, boolean isSuccess, JSONObject ret) {
        int deleteItemIndex = getDeleteItemIndex(miniAppDesktopIntent.getModuleType(), miniAppDesktopIntent.getDesktopAppInfo());
        if (isSuccess) {
            if (miniAppDesktopIntent.getDesktopAppInfo().mMiniAppInfo.isGdtMiniAppAd) {
                this.mMiniAppRepository.deleteGdtMiniAppCacheInfo(miniAppDesktopIntent.getDesktopAppInfo());
            }
            IDesktopRepository iDesktopRepository = this.mMiniAppRepository;
            MiniAppInfo miniAppInfo = miniAppDesktopIntent.getDesktopAppInfo().mMiniAppInfo;
            Intrinsics.checkNotNullExpressionValue(miniAppInfo, "miniAppDesktopIntent.desktopAppInfo.mMiniAppInfo");
            iDesktopRepository.deleteMiniAppDbInfo(miniAppInfo);
            this.mMiniAppRepository.updateMiniAppPositionInMmkv(this.mMiniAppInfoMap);
            MiniAppToastUtil.show(BaseApplication.getContext(), 2, R.string.f167032bu, 0);
        } else {
            List<DesktopItemInfo> list = this.mMiniAppInfoMap.get(Integer.valueOf(miniAppDesktopIntent.getModuleType()));
            if (list != null) {
                list.add(deleteItemIndex, miniAppDesktopIntent.getDesktopAppInfo());
            }
            resetGdtMiniAppShowState();
            getMUiState().postValue(new MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo(this.mMiniAppInfoMap, 0));
            MiniAppToastUtil.show(BaseApplication.getContext(), 2, R.string.f167022bt, 0);
        }
        this.mIsNetworkDone = true;
        QLog.d(getTAG(), 1, "DeleteDesktopMiniApp isSuc:" + isSuccess + "_ret:" + ret + "_name:" + miniAppDesktopIntent.getDesktopAppInfo().mMiniAppInfo.name);
    }

    private final void deleteMiniAppInfo(final MiniAppDeskTopIntent.DeleteDesktopMiniApp miniAppDesktopIntent) {
        if (isOperateToMuch()) {
            QLog.i(getTAG(), 1, "deleteMiniAppInfo isOperateToMuch!");
            return;
        }
        int moduleType = miniAppDesktopIntent.getModuleType();
        String str = miniAppDesktopIntent.getDesktopAppInfo().mMiniAppInfo.appId;
        Intrinsics.checkNotNullExpressionValue(str, "miniAppDesktopIntent.des\u2026ppInfo.mMiniAppInfo.appId");
        deleteDesktopMiniAppInfo(moduleType, str);
        resetGdtMiniAppShowState();
        getMUiState().postValue(new MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo(this.mMiniAppInfoMap, 0));
        if (miniAppDesktopIntent.getModuleType() == 3) {
            IDesktopRepository iDesktopRepository = this.mMiniAppRepository;
            MiniAppInfo miniAppInfo = miniAppDesktopIntent.getDesktopAppInfo().mMiniAppInfo;
            Intrinsics.checkNotNullExpressionValue(miniAppInfo, "miniAppDesktopIntent.desktopAppInfo.mMiniAppInfo");
            iDesktopRepository.operateMiniAppToMyMiniApp(miniAppInfo, 0, -1, -1, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.mvi.c
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                    MiniAppDeskTopViewModel.deleteMiniAppInfo$lambda$2(MiniAppDeskTopViewModel.this, miniAppDesktopIntent, z16, jSONObject);
                }
            });
        } else {
            IDesktopRepository iDesktopRepository2 = this.mMiniAppRepository;
            MiniAppInfo miniAppInfo2 = miniAppDesktopIntent.getDesktopAppInfo().mMiniAppInfo;
            Intrinsics.checkNotNullExpressionValue(miniAppInfo2, "miniAppDesktopIntent.desktopAppInfo.mMiniAppInfo");
            iDesktopRepository2.deleteDesktopMiniApp(miniAppInfo2, miniAppDesktopIntent.getModuleType(), new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.mvi.d
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                    MiniAppDeskTopViewModel.deleteMiniAppInfo$lambda$3(MiniAppDeskTopViewModel.this, miniAppDesktopIntent, z16, jSONObject);
                }
            });
        }
        this.mIsNetworkDone = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteMiniAppInfo$lambda$2(MiniAppDeskTopViewModel this$0, MiniAppDeskTopIntent.DeleteDesktopMiniApp miniAppDesktopIntent, boolean z16, JSONObject ret) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(miniAppDesktopIntent, "$miniAppDesktopIntent");
        Intrinsics.checkNotNullExpressionValue(ret, "ret");
        this$0.deleteItemResponse(miniAppDesktopIntent, z16, ret);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteMiniAppInfo$lambda$3(MiniAppDeskTopViewModel this$0, MiniAppDeskTopIntent.DeleteDesktopMiniApp miniAppDesktopIntent, boolean z16, JSONObject ret) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(miniAppDesktopIntent, "$miniAppDesktopIntent");
        Intrinsics.checkNotNullExpressionValue(ret, "ret");
        this$0.deleteItemResponse(miniAppDesktopIntent, z16, ret);
    }

    private final int getDeleteItemIndex(int moduleType, DesktopAppInfo deleteMiniAppInfo) {
        List<DesktopItemInfo> list = this.mMiniAppInfoMap.get(Integer.valueOf(moduleType));
        int i3 = 0;
        if (list == null || list.isEmpty()) {
            QLog.d(getTAG(), 1, "deleteShowMiniAppInfo moduleType:" + moduleType + " miniAppInfoMap is isNullOrEmpty!");
            return -1;
        }
        List<DesktopItemInfo> list2 = this.mMiniAppInfoMap.get(Integer.valueOf(moduleType));
        if (list2 != null) {
            for (Object obj : list2) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                DesktopItemInfo desktopItemInfo = (DesktopItemInfo) obj;
                String str = deleteMiniAppInfo.mMiniAppInfo.appId;
                Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo");
                if (str.equals(((DesktopAppInfo) desktopItemInfo).mMiniAppInfo.appId)) {
                    return i3;
                }
                i3 = i16;
            }
        }
        return -1;
    }

    private final void getMiniAppDesktopLocalInfo() {
        if (this.mIsInitLocalData) {
            QLog.d(getTAG(), 1, "getMiniAppDesktopLocalInfo data is already init!");
        } else {
            this.mMiniAppRepository.getMiniAppDesktopLocalCacheInfo(new MiniAppDesktopLocalDataHelper.MiniAppLocalDataCallback() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopViewModel$getMiniAppDesktopLocalInfo$1
                @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.MiniAppDesktopLocalDataHelper.MiniAppLocalDataCallback
                public void getLocalDataFailed(String errorMsg) {
                    QLog.e(MiniAppDeskTopViewModel.this.getTAG(), 1, "getLocalDataFailed errorMsg:" + errorMsg);
                }

                @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.MiniAppDesktopLocalDataHelper.MiniAppLocalDataCallback
                public void getLocalDataSuccess(HashMap<Integer, List<DesktopItemInfo>> miniAppUIDataMap) {
                    HashMap hashMap;
                    Intrinsics.checkNotNullParameter(miniAppUIDataMap, "miniAppUIDataMap");
                    QLog.d(MiniAppDeskTopViewModel.this.getTAG(), 1, "getLocalDataSuccess!");
                    MiniAppDeskTopViewModel.this.mMiniAppInfoMap = miniAppUIDataMap;
                    MutableLiveData<MiniAppDeskTopUIState> mUiState = MiniAppDeskTopViewModel.this.getMUiState();
                    hashMap = MiniAppDeskTopViewModel.this.mMiniAppInfoMap;
                    mUiState.postValue(new MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo(hashMap, 0));
                    MiniAppDeskTopViewModel.this.mIsInitLocalData = true;
                }
            });
        }
    }

    private final void getMiniAppDesktopNetworkInfo(boolean force, GetAppListV2Scene scene) {
        if (MiniAppUtils.isTeenagerMode()) {
            QLog.e(getTAG(), 1, "is TeenMode!");
            this.mMiniAppInfoMap.clear();
            return;
        }
        QLog.i(getTAG(), 1, "do getDesktopMiniAppRemoteInfo:" + force);
        this.mMiniAppRepository.getDesktopMiniAppRemoteInfo(force, true ^ this.mMiniAppInfoMap.isEmpty(), scene, new DesktopMiniAppReqListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopViewModel$getMiniAppDesktopNetworkInfo$1
            @Override // com.tencent.mobileqq.mini.entry.newdesktop.DesktopMiniAppReqListener
            public void getMiniAppInfoFailed(String errorMsg, Long errorCode) {
                HashMap hashMap;
                MutableLiveData<MiniAppDeskTopUIState> mUiState = MiniAppDeskTopViewModel.this.getMUiState();
                hashMap = MiniAppDeskTopViewModel.this.mMiniAppInfoMap;
                mUiState.postValue(new MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo(hashMap, 0));
                QLog.e(MiniAppDeskTopViewModel.this.getTAG(), 1, "getMiniAppInfoFailed errorMsg:" + errorMsg + "  errorCode:" + errorCode);
            }

            @Override // com.tencent.mobileqq.mini.entry.newdesktop.DesktopMiniAppReqListener
            public void getMiniAppInfoSuccess(HashMap<Integer, List<DesktopItemInfo>> miniAppInfoMap) {
                IDesktopRepository iDesktopRepository;
                IDesktopRepository iDesktopRepository2;
                HashMap hashMap;
                Intrinsics.checkNotNullParameter(miniAppInfoMap, "miniAppInfoMap");
                QLog.i(MiniAppDeskTopViewModel.this.getTAG(), 1, "getMiniAppInfoSuccess! miniAppInfoMap:" + miniAppInfoMap);
                MiniAppDeskTopViewModel.this.mMiniAppInfoMap = miniAppInfoMap;
                iDesktopRepository = MiniAppDeskTopViewModel.this.mMiniAppRepository;
                iDesktopRepository.updateMiniAppPositionInMmkv(miniAppInfoMap);
                iDesktopRepository2 = MiniAppDeskTopViewModel.this.mMiniAppRepository;
                iDesktopRepository2.updateMiniAppDbInfoWithBatch(miniAppInfoMap);
                MiniAppDeskTopViewModel.this.getMUiState().postValue(new MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo(miniAppInfoMap, 0));
                MiniAppDeskTopViewModel miniAppDeskTopViewModel = MiniAppDeskTopViewModel.this;
                hashMap = miniAppDeskTopViewModel.mMiniAppInfoMap;
                miniAppDeskTopViewModel.requestGdtMiniAppInfo(hashMap);
            }
        });
    }

    private final void insertMiniAppInfo(final DesktopAppInfo miniAppInfo, final int position) {
        if (isOperateToMuch()) {
            QLog.i(getTAG(), 1, "insertMiniAppInfo isOperateToMuch!");
            return;
        }
        QLog.d(getTAG(), 1, "insert name:" + miniAppInfo.mMiniAppInfo.name + " position:" + position);
        String str = miniAppInfo.mMiniAppInfo.appId;
        Intrinsics.checkNotNullExpressionValue(str, "miniAppInfo.mMiniAppInfo.appId");
        if (!isNeedResetMyMiniAppInfoForInsertMiniApp(str, position)) {
            QLog.i(getTAG(), 1, "not need reset my mini app info for insert!");
            getMUiState().postValue(new MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo(this.mMiniAppInfoMap, 3));
            return;
        }
        final List<DesktopItemInfo> list = this.mMiniAppInfoMap.get(3);
        List<DesktopItemInfo> list2 = this.mMiniAppInfoMap.get(3);
        Intrinsics.checkNotNull(list2);
        if (position >= list2.size()) {
            Intrinsics.checkNotNull(list);
            list.add(new DesktopAppInfo(3, miniAppInfo.mMiniAppInfo));
        } else {
            Intrinsics.checkNotNull(list);
            list.add(position, new DesktopAppInfo(3, miniAppInfo.mMiniAppInfo));
        }
        getMUiState().postValue(new MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo(this.mMiniAppInfoMap, 0));
        IDesktopRepository iDesktopRepository = this.mMiniAppRepository;
        MiniAppInfo miniAppInfo2 = miniAppInfo.mMiniAppInfo;
        Intrinsics.checkNotNullExpressionValue(miniAppInfo2, "miniAppInfo.mMiniAppInfo");
        iDesktopRepository.operateMiniAppToMyMiniApp(miniAppInfo2, 1, -1, position, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.mvi.b
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                MiniAppDeskTopViewModel.insertMiniAppInfo$lambda$8(MiniAppDeskTopViewModel.this, miniAppInfo, list, position, z16, jSONObject);
            }
        });
        this.mIsNetworkDone = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void insertMiniAppInfo$lambda$8(MiniAppDeskTopViewModel this$0, DesktopAppInfo miniAppInfo, List list, int i3, boolean z16, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(miniAppInfo, "$miniAppInfo");
        if (z16) {
            this$0.mMiniAppRepository.insertMiniAppDbInfo(miniAppInfo);
            this$0.mMiniAppRepository.updateMiniAppPositionInMmkv(this$0.mMiniAppInfoMap);
            MiniAppToastUtil.show(BaseApplication.getContext(), 2, R.string.f213375q1, 0);
        } else {
            if (list != null) {
            }
            this$0.getMUiState().postValue(new MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo(this$0.mMiniAppInfoMap, 3));
            MiniAppToastUtil.show(BaseApplication.getContext(), 1, R.string.f213385q2, 0);
        }
        this$0.mIsNetworkDone = true;
        QLog.d(this$0.getTAG(), 1, "insertMiniAppToMyMiniApp isSuc:" + z16 + " ret:" + jSONObject + " name" + miniAppInfo.mMiniAppInfo.name);
    }

    private final void insertMyMiniAppToTopById(MiniAppDeskTopIntent.InsertMyMiniAppToTopById miniAppDesktopIntent) {
        Object obj;
        boolean z16 = true;
        if (isOperateToMuch()) {
            QLog.i(getTAG(), 1, "insertMiniAppInfo isOperateToMuch!");
            return;
        }
        List<DesktopItemInfo> list = this.mMiniAppInfoMap.get(1);
        if (list != null && !list.isEmpty()) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        List<DesktopItemInfo> list2 = this.mMiniAppInfoMap.get(1);
        if (list2 != null) {
            obj = null;
            for (Object obj2 : list2) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo");
                if (((DesktopAppInfo) obj2).mMiniAppInfo.appId.equals(miniAppDesktopIntent.getMiniAppId())) {
                    obj = obj2;
                }
            }
        } else {
            obj = null;
        }
        if (obj != null) {
            List<DesktopItemInfo> list3 = this.mMiniAppInfoMap.get(3);
            DesktopAppInfo desktopAppInfo = (DesktopAppInfo) obj;
            desktopAppInfo.mMiniAppInfo.updateTimeStamp();
            String str = desktopAppInfo.mMiniAppInfo.appId;
            Intrinsics.checkNotNullExpressionValue(str, "insertDesktopAppInfo!!.mMiniAppInfo.appId");
            removeMiniAppItem(list3, str);
            if (list3 != null) {
                list3.add(0, new DesktopAppInfo(3, desktopAppInfo.mMiniAppInfo));
            }
            this.mMiniAppRepository.insertMiniAppDbInfo(desktopAppInfo);
            this.mMiniAppRepository.updateMiniAppPositionInMmkv(this.mMiniAppInfoMap);
            getMUiState().postValue(new MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo(this.mMiniAppInfoMap, 3));
            miniAppDesktopIntent.getEipcModule().callbackResult(miniAppDesktopIntent.getCallbackId(), EIPCResult.createResult(0, null));
            return;
        }
        miniAppDesktopIntent.getEipcModule().callbackResult(miniAppDesktopIntent.getCallbackId(), EIPCResult.createResult(-100, null));
    }

    private final boolean isNeedResetMyMiniAppInfoForInsertMiniApp(String insertMiniAppId, int newPosition) {
        List<DesktopItemInfo> list = this.mMiniAppInfoMap.get(3);
        if (list != null) {
            int i3 = 0;
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                DesktopItemInfo desktopItemInfo = (DesktopItemInfo) obj;
                if ((desktopItemInfo instanceof DesktopAppInfo) && ((DesktopAppInfo) desktopItemInfo).mMiniAppInfo.appId.equals(insertMiniAppId) && newPosition == i3) {
                    return false;
                }
                i3 = i16;
            }
        }
        List<DesktopItemInfo> list2 = this.mMiniAppInfoMap.get(3);
        Intrinsics.checkNotNull(list2);
        Iterator<DesktopItemInfo> it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DesktopItemInfo next = it.next();
            if ((next instanceof DesktopAppInfo) && ((DesktopAppInfo) next).mMiniAppInfo.appId.equals(insertMiniAppId)) {
                it.remove();
                break;
            }
        }
        return true;
    }

    private final boolean isOperateToMuch() {
        if (this.mIsNetworkDone) {
            return false;
        }
        QLog.i(getTAG(), 1, "insertMiniAppInfo mIsLastNetworkDone is false!");
        MiniAppToastUtil.show(BaseApplication.getContext(), 1, R.string.f213405q4, 0);
        return true;
    }

    private final void moveRecentAppExistMiniApp(MiniAppInfo miniAppInfo) {
        List<DesktopItemInfo> mutableListOf;
        List<DesktopItemInfo> list = this.mMiniAppInfoMap.get(1);
        Intrinsics.checkNotNull(list);
        Iterator<DesktopItemInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DesktopItemInfo next = it.next();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo");
            if (((DesktopAppInfo) next).mMiniAppInfo.appId.equals(miniAppInfo.appId)) {
                it.remove();
                break;
            }
        }
        List<DesktopItemInfo> list2 = this.mMiniAppInfoMap.get(1);
        if (list2 == null || list2.isEmpty()) {
            HashMap<Integer, List<DesktopItemInfo>> hashMap = this.mMiniAppInfoMap;
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new DesktopAppInfo(1, miniAppInfo));
            hashMap.put(1, mutableListOf);
        } else {
            List<DesktopItemInfo> list3 = this.mMiniAppInfoMap.get(1);
            if (list3 != null) {
                list3.add(0, new DesktopAppInfo(1, miniAppInfo));
            }
        }
        miniAppInfo.isGdtMiniAppAd = false;
    }

    private final void myMiniAppDraggingTempSwitchPosition(MiniAppDeskTopIntent.MyMiniAppDraggingTempSwitchPosition miniAppDesktopIntent) {
        List<DesktopItemInfo> list = this.mMiniAppInfoMap.get(3);
        if (list == null || list.isEmpty()) {
            QLog.i(getTAG(), 1, "my app is empty!");
            return;
        }
        if (miniAppDesktopIntent.getFromPosition() >= 0) {
            int fromPosition = miniAppDesktopIntent.getFromPosition();
            List<DesktopItemInfo> list2 = this.mMiniAppInfoMap.get(3);
            Intrinsics.checkNotNull(list2);
            if (fromPosition < list2.size() && miniAppDesktopIntent.getToPosition() >= 0) {
                int toPosition = miniAppDesktopIntent.getToPosition();
                List<DesktopItemInfo> list3 = this.mMiniAppInfoMap.get(3);
                Intrinsics.checkNotNull(list3);
                if (toPosition < list3.size()) {
                    QLog.i(getTAG(), 1, "myMiniAppDraggingTempSwitchPosition fromPosition:" + miniAppDesktopIntent.getFromPosition() + " toPosition:" + miniAppDesktopIntent.getToPosition());
                    List<DesktopItemInfo> list4 = this.mMiniAppInfoMap.get(3);
                    List mutableList = list4 != null ? CollectionsKt___CollectionsKt.toMutableList((Collection) list4) : null;
                    if (mutableList != null) {
                        mutableList.add(miniAppDesktopIntent.getToPosition(), mutableList.remove(miniAppDesktopIntent.getFromPosition()));
                    }
                    MutableLiveData<MiniAppDeskTopUIState> mUiState = getMUiState();
                    Intrinsics.checkNotNull(mutableList);
                    mUiState.postValue(new MiniAppDeskTopUIState.MyMiniAppDraggingTempSwitchPosition(mutableList));
                    return;
                }
            }
        }
        QLog.i(getTAG(), 1, "wrong fromPosition:" + miniAppDesktopIntent.getFromPosition() + ", toPosition:" + miniAppDesktopIntent.getToPosition() + "!");
    }

    private final void myMiniAppSwitchPosition(final MiniAppDeskTopIntent.MyMiniAppSwitchPosition miniAppDesktopIntent) {
        if (isOperateToMuch()) {
            QLog.i(getTAG(), 1, "myMiniAppSwitchPosition isOperateToMuch!");
            return;
        }
        final List<DesktopItemInfo> list = this.mMiniAppInfoMap.get(3);
        List<DesktopItemInfo> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            QLog.i(getTAG(), 1, "myMiniAppSwitchPosition MyApp is null or empty!");
            return;
        }
        if (miniAppDesktopIntent.getNewIndex() < list.size() && miniAppDesktopIntent.getOldIndex() < list.size()) {
            DesktopItemInfo desktopItemInfo = list.get(miniAppDesktopIntent.getOldIndex());
            Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo");
            final DesktopAppInfo desktopAppInfo = (DesktopAppInfo) desktopItemInfo;
            list.add(miniAppDesktopIntent.getNewIndex(), list.remove(miniAppDesktopIntent.getOldIndex()));
            getMUiState().postValue(new MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo(this.mMiniAppInfoMap, 3));
            IDesktopRepository iDesktopRepository = this.mMiniAppRepository;
            MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
            Intrinsics.checkNotNullExpressionValue(miniAppInfo, "draggingMiniApp.mMiniAppInfo");
            iDesktopRepository.operateMiniAppToMyMiniApp(miniAppInfo, 1, miniAppDesktopIntent.getOldIndex(), miniAppDesktopIntent.getNewIndex(), new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.mvi.e
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                    MiniAppDeskTopViewModel.myMiniAppSwitchPosition$lambda$5(MiniAppDeskTopViewModel.this, desktopAppInfo, miniAppDesktopIntent, list, z16, jSONObject);
                }
            });
            this.mIsNetworkDone = false;
            return;
        }
        QLog.i(getTAG(), 1, "myMiniAppSwitchPosition newIndex and oldIndex is invalid!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void myMiniAppSwitchPosition$lambda$5(MiniAppDeskTopViewModel this$0, DesktopAppInfo draggingMiniApp, MiniAppDeskTopIntent.MyMiniAppSwitchPosition miniAppDesktopIntent, List list, boolean z16, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(draggingMiniApp, "$draggingMiniApp");
        Intrinsics.checkNotNullParameter(miniAppDesktopIntent, "$miniAppDesktopIntent");
        if (z16) {
            this$0.mMiniAppRepository.insertMiniAppDbInfo(draggingMiniApp);
            this$0.mMiniAppRepository.updateMiniAppPositionInMmkv(this$0.mMiniAppInfoMap);
            QLog.i(this$0.getTAG(), 1, "myMiniAppSwitchPosition oldIndex:" + miniAppDesktopIntent.getOldIndex() + " newIndex:" + miniAppDesktopIntent.getNewIndex() + "!");
        } else {
            this$0.swap(list, miniAppDesktopIntent.getOldIndex(), miniAppDesktopIntent.getNewIndex());
            this$0.getMUiState().postValue(new MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo(this$0.mMiniAppInfoMap, 3));
        }
        this$0.mIsNetworkDone = true;
        QLog.d(this$0.getTAG(), 1, "insertMiniAppToMyMiniApp isSuc:" + z16 + "_ret:" + jSONObject);
    }

    private final void queryMyMiniAppInfo(Bundle params, EIPCModule eipcModule) {
        if (!(eipcModule instanceof MiniAppTransferModule)) {
            QLog.e(getTAG(), 1, "eipcModule is not MiniAppTransferModule type!");
            return;
        }
        if (params.containsKey("appid") && params.containsKey("verType") && params.containsKey("callbackId")) {
            String string = params.getString("appid");
            int i3 = params.getInt("verType");
            int i16 = params.getInt("callbackId");
            try {
                MiniAppInfo miniAppInfoByDesktopDataInfoMap = getMiniAppInfoByDesktopDataInfoMap(3, string, i3);
                QLog.d(getTAG(), 2, "miniappInfo : " + miniAppInfoByDesktopDataInfoMap);
                Bundle bundle = new Bundle();
                if (miniAppInfoByDesktopDataInfoMap != null) {
                    bundle.putParcelable("miniappinfo", miniAppInfoByDesktopDataInfoMap);
                    bundle.putInt(MiniChatConstants.MINI_APP_TOP_TYPE, 1);
                } else {
                    bundle.putInt(MiniChatConstants.MINI_APP_TOP_TYPE, 0);
                }
                ArrayList<Integer> a16 = MiniAppConfProcessor.j().a();
                if (a16 != null) {
                    bundle.putIntegerArrayList("backHomeSceneList", a16);
                }
                eipcModule.callbackResult(i16, EIPCResult.createResult(0, bundle));
                return;
            } catch (Throwable unused) {
                eipcModule.callbackResult(i16, EIPCResult.createResult(-102, null));
                return;
            }
        }
        QLog.e(getTAG(), 1, "appid\u3001verType\u3001callbackId has not contain!");
    }

    private final void recentAppInsertMyAppDraggingTempSwitchPosition(MiniAppDeskTopIntent.RecentAppInsertMyAppDraggingTempSwitchPosition miniAppDesktopIntent) {
        List<DesktopItemInfo> list = this.mMiniAppInfoMap.get(3);
        List mutableList = list != null ? CollectionsKt___CollectionsKt.toMutableList((Collection) list) : null;
        Intrinsics.checkNotNull(mutableList);
        Iterator it = mutableList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo");
            if (((DesktopAppInfo) next).mMiniAppInfo.appId.equals(miniAppDesktopIntent.getDesktopAppInfo().mMiniAppInfo.appId)) {
                it.remove();
                break;
            }
        }
        if (miniAppDesktopIntent.getPosition() <= mutableList.size() - 1) {
            mutableList.add(miniAppDesktopIntent.getPosition(), miniAppDesktopIntent.getDesktopAppInfo());
        }
        getMUiState().postValue(new MiniAppDeskTopUIState.MyMiniAppDraggingTempSwitchPosition(mutableList));
    }

    private final void registerMiniAppRedDotObserver() {
        QLog.i(getTAG(), 1, "registerRedDotObserver");
        if (this.mRedDotObserver != null) {
            QLog.i(getTAG(), 1, "redDotObserver is set!");
            return;
        }
        this.mRedDotObserver = new com.tencent.mobileqq.applets.a() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopViewModel$registerMiniAppRedDotObserver$1
            @Override // com.tencent.mobileqq.applets.a
            protected void onGetAppletsPushUnreadInfo(Object obj) {
                HashMap<Integer, List<DesktopItemInfo>> hashMap;
                HashMap hashMap2;
                QLog.i(MiniAppDeskTopViewModel.this.getTAG(), 1, "onGetAppletsPushUnreadInfo!");
                if (MiniAppConfProcessor.i() && (obj instanceof MiniAppRedDotEntity)) {
                    DesktopRedDotParseHelper companion = DesktopRedDotParseHelper.Companion.getInstance();
                    hashMap = MiniAppDeskTopViewModel.this.mMiniAppInfoMap;
                    companion.setDesktopRedDotInfo(hashMap, (MiniAppRedDotEntity) obj);
                    MutableLiveData<MiniAppDeskTopUIState> mUiState = MiniAppDeskTopViewModel.this.getMUiState();
                    hashMap2 = MiniAppDeskTopViewModel.this.mMiniAppInfoMap;
                    mUiState.postValue(new MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo(hashMap2, 0));
                }
            }

            @Override // com.tencent.mobileqq.applets.a
            protected void onReceiveAppletsMessageUnreadInfo(Map<String, Integer> unreadMsgInfoMap) {
                HashMap hashMap;
                HashMap<Integer, List<DesktopItemInfo>> hashMap2;
                HashMap hashMap3;
                Intrinsics.checkNotNullParameter(unreadMsgInfoMap, "unreadMsgInfoMap");
                QLog.i(MiniAppDeskTopViewModel.this.getTAG(), 1, "onReceiveAppletsMessageUnreadInfo: " + unreadMsgInfoMap);
                hashMap = MiniAppDeskTopViewModel.this.mMiniAppInfoMap;
                if (!(!hashMap.isEmpty()) || unreadMsgInfoMap.isEmpty()) {
                    return;
                }
                DesktopRedDotParseHelper companion = DesktopRedDotParseHelper.Companion.getInstance();
                hashMap2 = MiniAppDeskTopViewModel.this.mMiniAppInfoMap;
                companion.initDesktopRedDotData(hashMap2, unreadMsgInfoMap);
                MutableLiveData<MiniAppDeskTopUIState> mUiState = MiniAppDeskTopViewModel.this.getMUiState();
                hashMap3 = MiniAppDeskTopViewModel.this.mMiniAppInfoMap;
                mUiState.postValue(new MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo(hashMap3, 0));
            }
        };
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(this.mRedDotObserver);
        }
    }

    private final void removeMyMiniAppTopById(MiniAppDeskTopIntent.RemoveMyMiniAppTopById miniAppDesktopIntent) {
        if (isOperateToMuch()) {
            QLog.i(getTAG(), 1, "removeMyMiniAppTopById isOperateToMuch!");
            return;
        }
        List<DesktopItemInfo> list = this.mMiniAppInfoMap.get(3);
        if (list == null || list.isEmpty()) {
            QLog.i(getTAG(), 1, "removeMyMiniAppTopById my app is empty!");
            return;
        }
        List<DesktopItemInfo> list2 = this.mMiniAppInfoMap.get(3);
        Intrinsics.checkNotNull(list2);
        Object obj = null;
        for (Object obj2 : list2) {
            if ((obj2 instanceof DesktopAppInfo) && ((DesktopAppInfo) obj2).mMiniAppInfo.appId.equals(miniAppDesktopIntent.getMiniAppId())) {
                obj = obj2;
            }
        }
        if (obj != null) {
            DesktopAppInfo desktopAppInfo = (DesktopAppInfo) obj;
            String str = desktopAppInfo.mMiniAppInfo.appId;
            Intrinsics.checkNotNullExpressionValue(str, "removeDesktopAppInfo!!.mMiniAppInfo.appId");
            deleteDesktopMiniAppInfo(3, str);
            this.mMiniAppRepository.insertMiniAppDbInfo(desktopAppInfo);
            this.mMiniAppRepository.updateMiniAppPositionInMmkv(this.mMiniAppInfoMap);
            getMUiState().postValue(new MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo(this.mMiniAppInfoMap, 3));
            miniAppDesktopIntent.getEipcModule().callbackResult(miniAppDesktopIntent.getCallbackId(), EIPCResult.createResult(0, null));
            return;
        }
        miniAppDesktopIntent.getEipcModule().callbackResult(miniAppDesktopIntent.getCallbackId(), EIPCResult.createResult(-100, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestGdtMiniAppInfo(HashMap<Integer, List<DesktopItemInfo>> miniAppInfoMap) {
        if (miniAppInfoMap.isEmpty()) {
            QLog.i(getTAG(), 1, "miniAppInfoMap is empty!");
        } else if (!isTriggerAdShowByAppCount(miniAppInfoMap)) {
            QLog.e(getTAG(), 1, "isTriggerAdShowByAppCount is false!");
        } else {
            this.mMiniAppRepository.getDesktopGdtAppInfo(new MiniAppDeskTopViewModel$requestGdtMiniAppInfo$1(this, miniAppInfoMap));
        }
    }

    private final void resetGdtMiniAppShowState() {
        DesktopAppInfo desktopAppInfo;
        boolean z16 = true;
        List list = this.mMiniAppInfoMap.get(1);
        Intrinsics.checkNotNull(list);
        List list2 = list;
        Iterator it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                z16 = false;
                desktopAppInfo = null;
                break;
            }
            Object next = it.next();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo");
            desktopAppInfo = (DesktopAppInfo) next;
            if (desktopAppInfo.mMiniAppInfo.isGdtMiniAppAd) {
                it.remove();
                break;
            }
        }
        if (!z16 || desktopAppInfo == null) {
            return;
        }
        if (list2.size() != 5 && list2.size() != 6) {
            if (list2.size() > 6) {
                list2.add(6, desktopAppInfo);
                return;
            }
            return;
        }
        list2.add(desktopAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runningInMainThread(Runnable runnable) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
            QLog.i(getTAG(), 1, "main thread runnable: " + Reflection.getOrCreateKotlinClass(runnable.getClass()).getSimpleName());
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(runnable);
        QLog.i(getTAG(), 1, "sub thread runnable: " + Reflection.getOrCreateKotlinClass(runnable.getClass()).getSimpleName());
    }

    private final void setRecentStartMiniAppListener() {
        MiniAppUtils.setRecentStartMiniAppListener(new MiniAppDeskTopViewModel$setRecentStartMiniAppListener$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateRecentStartMiniAppInfo(MiniAppInfo miniAppInfo) {
        if (!MiniAppUtils.isTeenagerMode() && !this.mMiniAppInfoMap.isEmpty() && this.mMiniAppInfoMap.get(1) != null) {
            moveRecentAppExistMiniApp(miniAppInfo);
            this.mMiniAppRepository.updateMiniAppPositionInMmkv(this.mMiniAppInfoMap);
            this.mMiniAppRepository.insertMiniAppDbInfo(new DesktopAppInfo(1, miniAppInfo));
            resetGdtMiniAppShowState();
            getMUiState().postValue(new MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo(this.mMiniAppInfoMap, 1));
            return;
        }
        QLog.d(getTAG(), 1, "updateRecentStartMiniAppInfo mMiniAppInfoMap is empty or recentApp is null!");
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "MiniAppDeskTopViewModel";
    }

    public final MiniAppInfo getMiniAppInfoByDesktopDataInfoMap(int dataModule, String appId, int verType) {
        List<DesktopItemInfo> list = this.mMiniAppInfoMap.get(Integer.valueOf(dataModule));
        List<DesktopItemInfo> list2 = list;
        if (!(list2 == null || list2.isEmpty()) && appId != null) {
            for (DesktopItemInfo desktopItemInfo : list) {
                if (desktopItemInfo instanceof DesktopAppInfo) {
                    DesktopAppInfo desktopAppInfo = (DesktopAppInfo) desktopItemInfo;
                    if (desktopAppInfo.mMiniAppInfo.appId.equals(appId)) {
                        MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
                        if (miniAppInfo.verType == verType) {
                            return miniAppInfo;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return null;
        }
        QLog.e(getTAG(), 1, "MyApp is null or empty or appId is null!");
        return null;
    }

    public final LiveData<Boolean> getSubLayoutOpenState() {
        return this.subLayoutOpenState;
    }

    public final LiveData<Boolean> isAccountChange() {
        return this.isAccountChange;
    }

    public final LiveData<Boolean> isDesktopOpen() {
        return this.isDesktopOpen;
    }

    public final LiveData<Boolean> isStartAppFirstOpenDesktop() {
        return this.isStartAppFirstOpenDesktop;
    }

    public final LiveData<Boolean> isUserAccountFirstOpen() {
        return this.isUserAccountFirstOpen;
    }

    public final AppBubbleRecordEntity miniAppBubbleEnsureBubbleRecord(String appId, int moduleType, String text, int clickCount) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(text, "text");
        return this.mMiniAppRepository.miniAppBubbleEnsureBubbleRecord(appId, moduleType, text, clickCount);
    }

    public final void miniAppBubbleUpdateAppBubbleRecord(String appId, int moduleType) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.mMiniAppRepository.miniAppBubbleUpdateAppBubbleRecord(appId, moduleType);
    }

    public final void setAccountChange(boolean isAccountChange) {
        this.mIsAccountChange.setValue(Boolean.valueOf(isAccountChange));
    }

    public final void setDesktopOpen(boolean isDesktopOpen) {
        if (Intrinsics.areEqual(Boolean.valueOf(isDesktopOpen), this.mIsDesktopOpen.getValue())) {
            return;
        }
        this.mIsDesktopOpen.setValue(Boolean.valueOf(isDesktopOpen));
    }

    public final void setStartAppDesktopFirstOpen(boolean isStartAppMiniAppFirstOpen) {
        if (Intrinsics.areEqual(Boolean.valueOf(isStartAppMiniAppFirstOpen), this.mIsStartAppFirstOpenDesktop.getValue())) {
            return;
        }
        this.mIsStartAppFirstOpenDesktop.setValue(Boolean.valueOf(isStartAppMiniAppFirstOpen));
    }

    public final void setUserAccountFirstOpenDesktop(boolean isUserAccountFirstOpen) {
        if (Intrinsics.areEqual(Boolean.valueOf(isUserAccountFirstOpen), this.mIsUserAccountFirstOpen.getValue())) {
            return;
        }
        this.mIsUserAccountFirstOpen.setValue(Boolean.valueOf(isUserAccountFirstOpen));
    }

    public final <T> void swap(List<T> list, int i3, int i16) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        T t16 = list.get(i3);
        list.set(i3, list.get(i16));
        list.set(i16, t16);
    }

    public final void updateSubLayoutOpenState(boolean state) {
        if (Intrinsics.areEqual(Boolean.valueOf(state), this.mSubLayoutOpenState.getValue())) {
            return;
        }
        this.mSubLayoutOpenState.setValue(Boolean.valueOf(state));
    }

    private final boolean isTriggerAdShowByAppCount(HashMap<Integer, List<DesktopItemInfo>> miniAppInfoMap) {
        List<DesktopItemInfo> list = miniAppInfoMap.get(1);
        Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
        Intrinsics.checkNotNull(valueOf);
        return valueOf.intValue() >= 5;
    }

    private final void removeMiniAppItem(List<DesktopItemInfo> miniAppList, String appId) {
        List<DesktopItemInfo> list = miniAppList;
        if (list == null || list.isEmpty()) {
            return;
        }
        Intrinsics.checkNotNull(miniAppList);
        Iterator<DesktopItemInfo> it = miniAppList.iterator();
        while (it.hasNext()) {
            DesktopItemInfo next = it.next();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo");
            if (((DesktopAppInfo) next).mMiniAppInfo.appId.equals(appId)) {
                it.remove();
                return;
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDesktopBaseViewModel
    public MiniAppDeskTopIntent getMNoneValueIntent() {
        return this.mNoneValueIntent;
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDesktopBaseViewModel
    public void handleIntent(MiniAppDeskTopIntent miniAppDesktopIntent) {
        Intrinsics.checkNotNullParameter(miniAppDesktopIntent, "miniAppDesktopIntent");
        QLog.d(getTAG(), 1, "handleIntent:" + miniAppDesktopIntent);
        if (miniAppDesktopIntent instanceof MiniAppDeskTopIntent.GetMiniAppDesktopLocalData) {
            getMiniAppDesktopLocalInfo();
            return;
        }
        if (miniAppDesktopIntent instanceof MiniAppDeskTopIntent.GetMiniAppDesktopNetworkData) {
            MiniAppDeskTopIntent.GetMiniAppDesktopNetworkData getMiniAppDesktopNetworkData = (MiniAppDeskTopIntent.GetMiniAppDesktopNetworkData) miniAppDesktopIntent;
            getMiniAppDesktopNetworkInfo(getMiniAppDesktopNetworkData.getForce(), getMiniAppDesktopNetworkData.getScene());
            return;
        }
        if (miniAppDesktopIntent instanceof MiniAppDeskTopIntent.InsertMyMiniApp) {
            MiniAppDeskTopIntent.InsertMyMiniApp insertMyMiniApp = (MiniAppDeskTopIntent.InsertMyMiniApp) miniAppDesktopIntent;
            insertMiniAppInfo(insertMyMiniApp.getDesktopAppInfo(), insertMyMiniApp.getPosition());
            return;
        }
        if (miniAppDesktopIntent instanceof MiniAppDeskTopIntent.DeleteDesktopMiniApp) {
            deleteMiniAppInfo((MiniAppDeskTopIntent.DeleteDesktopMiniApp) miniAppDesktopIntent);
            return;
        }
        if (miniAppDesktopIntent instanceof MiniAppDeskTopIntent.MyMiniAppSwitchPosition) {
            myMiniAppSwitchPosition((MiniAppDeskTopIntent.MyMiniAppSwitchPosition) miniAppDesktopIntent);
            return;
        }
        if (miniAppDesktopIntent instanceof MiniAppDeskTopIntent.InsertMyMiniAppToTopById) {
            insertMyMiniAppToTopById((MiniAppDeskTopIntent.InsertMyMiniAppToTopById) miniAppDesktopIntent);
            return;
        }
        if (miniAppDesktopIntent instanceof MiniAppDeskTopIntent.RemoveMyMiniAppTopById) {
            removeMyMiniAppTopById((MiniAppDeskTopIntent.RemoveMyMiniAppTopById) miniAppDesktopIntent);
            return;
        }
        if (miniAppDesktopIntent instanceof MiniAppDeskTopIntent.MyMiniAppDraggingTempSwitchPosition) {
            myMiniAppDraggingTempSwitchPosition((MiniAppDeskTopIntent.MyMiniAppDraggingTempSwitchPosition) miniAppDesktopIntent);
            return;
        }
        if (miniAppDesktopIntent instanceof MiniAppDeskTopIntent.RecentAppInsertMyAppDraggingTempSwitchPosition) {
            recentAppInsertMyAppDraggingTempSwitchPosition((MiniAppDeskTopIntent.RecentAppInsertMyAppDraggingTempSwitchPosition) miniAppDesktopIntent);
            return;
        }
        if (miniAppDesktopIntent instanceof MiniAppDeskTopIntent.UpdateMiniAppDesktopInfo) {
            getMUiState().postValue(new MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo(this.mMiniAppInfoMap, 0));
            return;
        }
        if (miniAppDesktopIntent instanceof MiniAppDeskTopIntent.RegisterMiniAppRedDotObserverEvent) {
            registerMiniAppRedDotObserver();
            return;
        }
        if (miniAppDesktopIntent instanceof MiniAppDeskTopIntent.QueryMyMiniAppInfo) {
            MiniAppDeskTopIntent.QueryMyMiniAppInfo queryMyMiniAppInfo = (MiniAppDeskTopIntent.QueryMyMiniAppInfo) miniAppDesktopIntent;
            queryMyMiniAppInfo(queryMyMiniAppInfo.getParams(), queryMyMiniAppInfo.getEipcModule());
        } else if (miniAppDesktopIntent instanceof MiniAppDeskTopIntent.CheckIsInMyAppList) {
            MiniAppDeskTopIntent.CheckIsInMyAppList checkIsInMyAppList = (MiniAppDeskTopIntent.CheckIsInMyAppList) miniAppDesktopIntent;
            checkIsInMyAppList(checkIsInMyAppList.getParams(), checkIsInMyAppList.getEipcModule());
        }
    }

    public final void initLocalDataState() {
        this.mIsInitLocalData = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertGdtAdInfo(List<DesktopItemInfo> recentMiniAppInfo, GdtAd gdtAdInfo) {
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo;
        PBStringField pBStringField;
        if (recentMiniAppInfo != null && recentMiniAppInfo.size() >= 5 && gdtAdInfo != null) {
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = gdtAdInfo.info;
            String str = (adInfo == null || (displayInfo = adInfo.display_info) == null || (pBStringField = displayInfo.mini_program_id) == null) ? null : pBStringField.get();
            for (DesktopItemInfo desktopItemInfo : recentMiniAppInfo) {
                if ((desktopItemInfo instanceof DesktopAppInfo) && ((DesktopAppInfo) desktopItemInfo).mMiniAppInfo.appId.equals(str)) {
                    QLog.i(getTAG(), 1, "remove repeat gdt ad appId:" + str);
                    return;
                }
            }
            DesktopAppInfo convertAdDataToMiniAppInfo = convertAdDataToMiniAppInfo(gdtAdInfo);
            if (recentMiniAppInfo.size() == 5) {
                recentMiniAppInfo.add(convertAdDataToMiniAppInfo);
            } else {
                recentMiniAppInfo.add(6, convertAdDataToMiniAppInfo);
            }
            DesktopDataMiniAppAdManager.getInstance().setGdtAdInfo(gdtAdInfo);
            return;
        }
        QLog.e(getTAG(), 1, "not need insert gdt ad!");
    }

    static /* synthetic */ void insertGdtAdInfo$default(MiniAppDeskTopViewModel miniAppDeskTopViewModel, List list, GdtAd gdtAd, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                gdtAd = null;
            }
            miniAppDeskTopViewModel.insertGdtAdInfo(list, gdtAd);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertGdtAdInfo");
    }
}

package com.tencent.mobileqq.mini.entry.newdesktop.repository;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetDropdownAppListRsp;
import NS_MINI_INTERFACE.INTERFACE$StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE$StSearchModuleInfo;
import NS_MINI_INTERFACE.INTERFACE$StUserAppInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.RecommendAppInfo;
import com.tencent.mobileqq.mini.entry.GdtAdManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopBannerModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataMiniAppAdManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopSearchInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.DesktopMiniAppReqListener;
import com.tencent.mobileqq.mini.entry.newdesktop.repository.MiniAppDesktopRemoteDataHelper;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 C2\u00020\u0001:\u0001CB\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J(\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J(\u0010\"\u001a\u00020#2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\bH\u0002J\u001a\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H\u0002J0\u0010.\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J*\u00102\u001a\u00020\u00102\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\b2\u0006\u0010 \u001a\u00020!H\u0002JP\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u0002052.\u00106\u001a*\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002090807j\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020908`:2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\bH\u0002Jf\u0010;\u001a\u00020\u00102\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010=2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020-0=2.\u00106\u001a*\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002090807j\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020908`:2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\bH\u0002J@\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020A2.\u00106\u001a*\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002090807j\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020908`:H\u0002J \u0010B\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/DesktopRemoteRepository;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/IDesktopRemoteRepository;", "()V", "mExtInfo", "LNS_COMM/COMM$StCommonExt;", "mHasPullSearchData", "", "mLastRequestStartTs", "", "mRecommendAppList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/mini/apkg/RecommendAppInfo;", "Lkotlin/collections/ArrayList;", "mRefreshConfig", "Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/MiniAppRequestRefreshConfig;", "deleteDesktopMiniApp", "", "miniAppInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "moduleType", "", "listener", "Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;", "deleteRecentPlayLoadMoreApp", "getDesktopGdtAppInfo", "miniAppAdCallback", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopDataMiniAppAdManager$MiniAppAdCallback;", "getDesktopMiniAppRemoteInfo", FileReaderHelper.OPEN_FILE_FROM_FORCE, "isUseCache", "scene", "Lcom/tencent/mobileqq/mini/entry/desktop/GetAppListV2Scene;", "miniAppReqListener", "Lcom/tencent/mobileqq/mini/entry/newdesktop/DesktopMiniAppReqListener;", "initMiniAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "appInfo", "LNS_MINI_INTERFACE/INTERFACE$StUserAppInfo;", "requestStartTs", "isGetMiniAppValid", "isSuc", "ret", "Lorg/json/JSONObject;", "isParseDesktopTitleInfo", "moduleInfo", "LNS_MINI_INTERFACE/INTERFACE$StModuleInfo;", "operateMiniAppToMyMiniApp", MiniChatConstants.MINI_APP_TOP_TYPE, "oldPositionIndex", "newPositionIndex", "parseMiniAppListResp", "parserMiniAppInfo", "dropdownAppListRsp", "LNS_MINI_INTERFACE/INTERFACE$StGetDropdownAppListRsp;", "miniAppUIDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "Lkotlin/collections/HashMap;", "parserMiniAppInfoToMap", "fixApps", "", "dropdownAppInfo", "parserMiniAppSearchInfo", "searchModuleInfo", "LNS_MINI_INTERFACE/INTERFACE$StSearchModuleInfo;", "sendMiniAppListRequest", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class DesktopRemoteRepository implements IDesktopRemoteRepository {
    private static final long DATA_NOT_EXPIRED_CODE = 1000;
    private static final String DATA_NOT_EXPIRED_MSG = "getDesktopMiniAppRemoteInfo is not isExpired!";
    public static final int INSERT_TOP_TYPE_INDEX = 1;
    public static final int REMOVE_TOP_TYPE_INDEX = 0;
    private static final int RESPONSE_FINISH_INDEX = 1;
    private static final String TAG = "DesktopRemoteRepository";
    private boolean mHasPullSearchData;
    private long mLastRequestStartTs;
    private COMM.StCommonExt mExtInfo = new COMM.StCommonExt();
    private ArrayList<RecommendAppInfo> mRecommendAppList = new ArrayList<>();
    private MiniAppRequestRefreshConfig mRefreshConfig = new MiniAppRequestRefreshConfig();

    private final DesktopAppInfo initMiniAppInfo(int moduleType, INTERFACE$StUserAppInfo appInfo, GetAppListV2Scene scene, long requestStartTs) {
        DesktopAppInfo desktopAppInfo = new DesktopAppInfo(moduleType, MiniAppInfo.from(appInfo));
        desktopAppInfo.requestScene = scene.ordinal();
        desktopAppInfo.requestStartTs = requestStartTs;
        MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
        if (miniAppInfo != null && miniAppInfo.isLimitedAccessApp()) {
            desktopAppInfo.dragEnable = false;
        }
        MiniAppInfo miniAppInfo2 = desktopAppInfo.mMiniAppInfo;
        if (miniAppInfo2 != null) {
            miniAppInfo2.debugInfo = null;
        }
        desktopAppInfo.requestStartTs = this.mLastRequestStartTs;
        return desktopAppInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean isGetMiniAppValid(boolean isSuc, JSONObject ret) {
        if (!isSuc && ret == null) {
            QLog.e(TAG, 1, "miniAppListRequestFailed!");
            return false;
        }
        if (!isSuc) {
            Long valueOf = ret != null ? Long.valueOf(ret.optLong("retCode")) : null;
            if ((valueOf != null && ((int) valueOf.longValue()) == 1000) == false) {
                this.mRefreshConfig.setLastRequestTime(GetAppListV2Scene.DROP_DOWN, 0L);
            }
            QLog.e(TAG, 1, "miniAppListRequestFailed retCode=" + valueOf);
            return false;
        }
        if (ret != null && 0 != ret.optLong("retCode")) {
            QLog.e(TAG, 1, "isSuc miniAppListRequestFailed retCode=" + ret.optLong("retCode"));
            return false;
        }
        Object opt = ret != null ? ret.opt("response") : null;
        if (opt == null) {
            QLog.e(TAG, 1, "miniAppListRequestFailed response is null!");
            return false;
        }
        if (((INTERFACE$StGetDropdownAppListRsp) opt).useOld.get() != 1) {
            return true;
        }
        QLog.e(TAG, 1, "sendUserAppListRequest, reuse old data.");
        return false;
    }

    private final boolean isParseDesktopTitleInfo(INTERFACE$StModuleInfo moduleInfo) {
        int i3 = moduleInfo.moduleType.get();
        String moduleTitle = moduleInfo.title.get();
        if (i3 != 1 && i3 != 3 && i3 != 2) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(moduleTitle, "moduleTitle");
        return !(moduleTitle.length() == 0);
    }

    private final void parserMiniAppInfo(INTERFACE$StGetDropdownAppListRsp dropdownAppListRsp, HashMap<Integer, List<DesktopItemInfo>> miniAppUIDataMap, GetAppListV2Scene scene, long requestStartTs) {
        List<INTERFACE$StModuleInfo> list = dropdownAppListRsp.modules.get();
        if (list != null && !list.isEmpty() && !StudyModeManager.t()) {
            INTERFACE$StSearchModuleInfo searchModuleInfo = dropdownAppListRsp.searchInfo.get();
            Intrinsics.checkNotNullExpressionValue(searchModuleInfo, "searchModuleInfo");
            parserMiniAppSearchInfo(searchModuleInfo, miniAppUIDataMap);
            parserMiniAppInfoToMap(dropdownAppListRsp.fixApps.get(), list, miniAppUIDataMap, scene, requestStartTs);
            return;
        }
        QLog.d(TAG, 1, "StudyMode and DropdownAppListRsp is empty!");
    }

    private final void parserMiniAppSearchInfo(INTERFACE$StSearchModuleInfo searchModuleInfo, HashMap<Integer, List<DesktopItemInfo>> miniAppUIDataMap) {
        List<DesktopItemInfo> mutableList;
        INTERFACE$StUserAppInfo iNTERFACE$StUserAppInfo;
        QLog.d(TAG, 1, "parserMiniAppSearchInfo");
        ArrayList arrayList = new ArrayList();
        this.mHasPullSearchData = false;
        if (searchModuleInfo.searchApp.get() != null && (iNTERFACE$StUserAppInfo = searchModuleInfo.searchApp.get()) != null) {
            arrayList.add(new DesktopSearchInfo(MiniAppInfo.from(iNTERFACE$StUserAppInfo), searchModuleInfo.keywords.get(), 15));
            this.mHasPullSearchData = true;
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        miniAppUIDataMap.put(15, mutableList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendMiniAppListRequest$lambda$0(DesktopRemoteRepository this$0, GetAppListV2Scene scene, long j3, DesktopMiniAppReqListener miniAppReqListener, boolean z16, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(scene, "$scene");
        Intrinsics.checkNotNullParameter(miniAppReqListener, "$miniAppReqListener");
        if (this$0.isGetMiniAppValid(z16, jSONObject)) {
            QLog.e(TAG, 1, "GetMiniApp is valid!");
            this$0.parseMiniAppListResp(jSONObject, scene, j3, miniAppReqListener);
        } else {
            miniAppReqListener.getMiniAppInfoFailed(jSONObject != null ? jSONObject.optString("errMsg") : null, jSONObject != null ? Long.valueOf(jSONObject.optLong("retCode")) : null);
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopRemoteRepository
    public void deleteDesktopMiniApp(MiniAppInfo miniAppInfo, int moduleType, MiniAppCmdInterface listener) {
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.d(TAG, 1, "deleteDesktopMiniApp miniAppInfo:" + miniAppInfo);
        MiniAppCmdUtil.getInstance().delUserApp(miniAppInfo.appId, miniAppInfo.verType, miniAppInfo.recommend, 1, null, moduleType, listener);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopRemoteRepository
    public void getDesktopGdtAppInfo(DesktopDataMiniAppAdManager.MiniAppAdCallback miniAppAdCallback) {
        Intrinsics.checkNotNullParameter(miniAppAdCallback, "miniAppAdCallback");
        QLog.d(TAG, 1, "getDesktopGdtAppInfo!");
        GdtAd gdtAdInfo = DesktopDataMiniAppAdManager.getInstance().getGdtAdInfo();
        if (GdtAdManager.getInstance().isValidGdtAdRequest()) {
            DesktopDataMiniAppAdManager.getInstance().loadGdtMiniAppAd(miniAppAdCallback);
        } else if (gdtAdInfo != null) {
            miniAppAdCallback.onGetMiniAppAdSuccess(gdtAdInfo, -1);
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopRemoteRepository
    public void getDesktopMiniAppRemoteInfo(boolean force, boolean isUseCache, GetAppListV2Scene scene, DesktopMiniAppReqListener miniAppReqListener) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(miniAppReqListener, "miniAppReqListener");
        QLog.d(TAG, 1, "getDesktopMiniAppRemoteInfo force:" + force + " scene:" + scene);
        if (!force && !this.mRefreshConfig.isExpired(GetAppListV2Scene.DROP_DOWN)) {
            QLog.d(TAG, 1, DATA_NOT_EXPIRED_MSG);
            miniAppReqListener.getMiniAppInfoFailed(DATA_NOT_EXPIRED_MSG, 1000L);
            return;
        }
        this.mLastRequestStartTs = System.currentTimeMillis();
        MiniAppDesktopRemoteDataHelper.Companion companion = MiniAppDesktopRemoteDataHelper.INSTANCE;
        companion.getInstance().setExtInfoGdtCookie(this.mExtInfo);
        companion.getInstance().setExtInfoTeenager(this.mExtInfo);
        sendMiniAppListRequest(isUseCache, scene, miniAppReqListener);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopRemoteRepository
    public void operateMiniAppToMyMiniApp(MiniAppInfo miniAppInfo, int topType, int oldPositionIndex, int newPositionIndex, MiniAppCmdInterface listener) {
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.d(TAG, 1, "operateMiniAppToMyMiniApp miniAppInfo:" + miniAppInfo + " moduleType:" + newPositionIndex);
        MiniAppCmdUtil.getInstance().setUserAppTop(miniAppInfo.appId, topType, miniAppInfo.verType, oldPositionIndex, newPositionIndex, null, listener);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopRemoteRepository
    public void deleteRecentPlayLoadMoreApp() {
        QLog.d(TAG, 1, "deleteRecentPlayLoadMoreApp");
    }

    private final void parseMiniAppListResp(JSONObject ret, GetAppListV2Scene scene, long requestStartTs, DesktopMiniAppReqListener miniAppReqListener) {
        Object opt = ret != null ? ret.opt("response") : null;
        Intrinsics.checkNotNull(opt, "null cannot be cast to non-null type NS_MINI_INTERFACE.INTERFACE.StGetDropdownAppListRsp");
        INTERFACE$StGetDropdownAppListRsp iNTERFACE$StGetDropdownAppListRsp = (INTERFACE$StGetDropdownAppListRsp) opt;
        COMM.StCommonExt stCommonExt = iNTERFACE$StGetDropdownAppListRsp.extInfo.get();
        Intrinsics.checkNotNullExpressionValue(stCommonExt, "response.extInfo.get()");
        this.mExtInfo = stCommonExt;
        MiniAppUtils.saveGdtCookie(iNTERFACE$StGetDropdownAppListRsp.extInfo.get());
        if (1 != iNTERFACE$StGetDropdownAppListRsp.isFinished.get()) {
            miniAppReqListener.getMiniAppInfoFailed(ret.optString("errMsg"), Long.valueOf(ret.optLong("retCode")));
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            MiniAppUtils.handlePreloadAppDataV2(peekAppRuntime.getApp(), iNTERFACE$StGetDropdownAppListRsp);
        }
        HashMap<Integer, List<DesktopItemInfo>> hashMap = new HashMap<>();
        parserMiniAppInfo(iNTERFACE$StGetDropdownAppListRsp, hashMap, scene, requestStartTs);
        miniAppReqListener.getMiniAppInfoSuccess(hashMap);
        MiniAppRequestRefreshConfig miniAppRequestRefreshConfig = this.mRefreshConfig;
        GetAppListV2Scene getAppListV2Scene = GetAppListV2Scene.DROP_DOWN;
        miniAppRequestRefreshConfig.setLastRequestTime(getAppListV2Scene, System.currentTimeMillis());
        this.mRefreshConfig.setRefreshInterval(getAppListV2Scene, iNTERFACE$StGetDropdownAppListRsp.freshInternal.get());
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime2, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        String currentAccountUin = ((AppInterface) peekAppRuntime2).getCurrentAccountUin();
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool("mini_get_app_list_new_" + currentAccountUin, true);
        QLog.d(TAG, 1, "setMiniAppListRequestSuccess");
    }

    private final void sendMiniAppListRequest(boolean isUseCache, final GetAppListV2Scene scene, final DesktopMiniAppReqListener miniAppReqListener) {
        QLog.d(TAG, 1, "sendMiniAppListRequest!");
        final long currentTimeMillis = System.currentTimeMillis();
        MiniAppCmdUtil.getInstance().getUserAppListV2(this.mExtInfo, scene, this.mRecommendAppList, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), isUseCache ? 1 : 0, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.repository.f
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                DesktopRemoteRepository.sendMiniAppListRequest$lambda$0(DesktopRemoteRepository.this, scene, currentTimeMillis, miniAppReqListener, z16, jSONObject);
            }
        });
    }

    private final void parserMiniAppInfoToMap(List<INTERFACE$StUserAppInfo> fixApps, List<INTERFACE$StModuleInfo> dropdownAppInfo, HashMap<Integer, List<DesktopItemInfo>> miniAppUIDataMap, GetAppListV2Scene scene, long requestStartTs) {
        List<DesktopItemInfo> mutableList;
        List<DesktopItemInfo> mutableList2;
        List<DesktopItemInfo> mutableList3;
        List<DesktopItemInfo> mutableList4;
        int coerceAtMost;
        List<DesktopItemInfo> mutableList5;
        int i3;
        boolean z16 = true;
        QLog.d(TAG, 1, "parserMiniAppInfo dropdownAppInfo:" + dropdownAppInfo.size());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        HashSet<String> hashSet = new HashSet<>();
        List<INTERFACE$StUserAppInfo> list = fixApps;
        int i16 = 2;
        if (!(list == null || list.isEmpty())) {
            for (INTERFACE$StUserAppInfo iNTERFACE$StUserAppInfo : fixApps) {
                DesktopAppInfo desktopAppInfo = new DesktopAppInfo(2, MiniAppInfo.from(iNTERFACE$StUserAppInfo));
                desktopAppInfo.setIsFixApp(true);
                desktopAppInfo.deleteEnable = false;
                desktopAppInfo.dragEnable = false;
                desktopAppInfo.dropEnable = false;
                desktopAppInfo.requestScene = scene.ordinal();
                desktopAppInfo.requestStartTs = requestStartTs;
                arrayList6.add(desktopAppInfo);
                hashSet.add(iNTERFACE$StUserAppInfo.appInfo.appId.get());
            }
            arrayList5.addAll(arrayList6);
            MiniAppDesktopLocalDataHelper.INSTANCE.getInstance().setRecommendListFixAppIdSet(hashSet);
        }
        for (INTERFACE$StModuleInfo iNTERFACE$StModuleInfo : dropdownAppInfo) {
            int i17 = iNTERFACE$StModuleInfo.moduleType.get();
            if (i17 == 14) {
                DesktopBannerModuleInfo desktopBannerModuleInfo = new DesktopBannerModuleInfo(iNTERFACE$StModuleInfo);
                desktopBannerModuleInfo.requestScene = scene.ordinal();
                desktopBannerModuleInfo.requestStartTs = requestStartTs;
                arrayList2.add(desktopBannerModuleInfo);
            } else if (iNTERFACE$StModuleInfo.userAppList.get() != null) {
                List<INTERFACE$StUserAppInfo> list2 = iNTERFACE$StModuleInfo.userAppList.get();
                Intrinsics.checkNotNullExpressionValue(list2, "moduleInfo.userAppList.get()");
                if (list2.isEmpty() ^ z16) {
                    if (isParseDesktopTitleInfo(iNTERFACE$StModuleInfo)) {
                        DesktopAppModuleInfo desktopAppModuleInfo = new DesktopAppModuleInfo(i17, iNTERFACE$StModuleInfo.title.get(), iNTERFACE$StModuleInfo.jumpMoreApp.get());
                        desktopAppModuleInfo.requestScene = scene.ordinal();
                        desktopAppModuleInfo.requestStartTs = requestStartTs;
                        arrayList.add(desktopAppModuleInfo);
                    }
                    List<INTERFACE$StUserAppInfo> list3 = iNTERFACE$StModuleInfo.userAppList.get();
                    Intrinsics.checkNotNullExpressionValue(list3, "moduleInfo.userAppList.get()");
                    for (INTERFACE$StUserAppInfo it : list3) {
                        if (i17 == 1) {
                            i3 = i17;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            arrayList3.add(initMiniAppInfo(i3, it, scene, requestStartTs));
                        } else if (i17 == 2) {
                            i3 = i17;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            arrayList5.add(initMiniAppInfo(i3, it, scene, requestStartTs));
                        } else if (i17 != 3) {
                            i3 = i17;
                        } else {
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            i3 = i17;
                            arrayList4.add(initMiniAppInfo(i17, it, scene, requestStartTs));
                        }
                        i17 = i3;
                    }
                    i16 = 2;
                    z16 = true;
                }
            }
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        miniAppUIDataMap.put(16, mutableList);
        mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        miniAppUIDataMap.put(14, mutableList2);
        mutableList3 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
        miniAppUIDataMap.put(1, mutableList3);
        mutableList4 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList4);
        miniAppUIDataMap.put(3, mutableList4);
        Integer valueOf = Integer.valueOf(i16);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(arrayList5.size(), 10);
        mutableList5 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList5.subList(0, coerceAtMost));
        miniAppUIDataMap.put(valueOf, mutableList5);
    }
}

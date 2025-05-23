package com.tencent.mobileqq.mini.entry.expDesktop.repository;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetDropdownAppListRsp;
import NS_MINI_INTERFACE.INTERFACE$StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE$StModuleLayout;
import NS_MINI_INTERFACE.INTERFACE$StUserAppInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.RecommendAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopBannerModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.DesktopExpMiniAppReqListener;
import com.tencent.mobileqq.mini.entry.expDesktop.DesktopExpMoreMiniAppReqListener;
import com.tencent.mobileqq.mini.entry.expDesktop.DesktopExpRankMiniAppReqListener;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupBannerInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopRankSubTabAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopRankTabAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.repository.MiniAppExpDesktopRemoteDataHelper;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 L2\u00020\u0001:\u0001LB\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001cH\u0016J(\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\"H\u0016J\"\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0019\u001a\u00020\"H\u0002J \u0010'\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*2\u0006\u0010!\u001a\u00020\u000eH\u0002J\u0012\u0010+\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u001a\u0010,\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J0\u0010-\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J0\u00101\u001a\u0012\u0012\u0004\u0012\u00020(0\bj\b\u0012\u0004\u0012\u00020(`\n2\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020*\u0018\u0001032\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J \u00104\u001a\b\u0012\u0004\u0012\u00020(052\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u00106\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0019\u001a\u00020\"H\u0002J \u00107\u001a\u0012\u0012\u0004\u0012\u0002080\bj\b\u0012\u0004\u0012\u000208`\n2\u0006\u00109\u001a\u00020\u0004H\u0002J \u0010:\u001a\u0012\u0012\u0004\u0012\u0002080\bj\b\u0012\u0004\u0012\u000208`\n2\u0006\u00109\u001a\u00020\u0004H\u0002J4\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020=2\"\u0010>\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020@0?j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020@`AH\u0002J2\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\b2\"\u0010D\u001a\u001e\u0012\u0004\u0012\u000208\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020F0\bj\b\u0012\u0004\u0012\u00020F`\n0EH\u0002J4\u0010G\u001a\u00020\u00102\u0006\u0010<\u001a\u00020=2\"\u0010H\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020@0?j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020@`AH\u0002J\u0018\u0010I\u001a\u00020\u00102\u0006\u0010J\u001a\u00020K2\u0006\u0010\u0019\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/ExpDesktopRemoteRepository;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/IExpDesktopRemoteRepository;", "()V", "mExtInfo", "LNS_COMM/COMM$StCommonExt;", "mLastRequestStartTs", "", "mRecommendAppList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/mini/apkg/RecommendAppInfo;", "Lkotlin/collections/ArrayList;", "mRefreshConfig", "Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/MiniAppExpRequestRefreshConfig;", "mScene", "Lcom/tencent/mobileqq/mini/entry/desktop/GetAppListV2Scene;", "deleteDesktopMiniApp", "", "miniAppInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "moduleType", "", "listener", "Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;", "deleteRecentPlayLoadMoreApp", "getDesktopMiniAppMoreModuleRemoteInfo", "miniAppReqListener", "Lcom/tencent/mobileqq/mini/entry/expDesktop/DesktopExpMoreMiniAppReqListener;", "getDesktopMiniAppRankModuleRemoteInfo", "Lcom/tencent/mobileqq/mini/entry/expDesktop/DesktopExpRankMiniAppReqListener;", "getDesktopMiniAppRemoteInfo", FileReaderHelper.OPEN_FILE_FROM_FORCE, "", "isUseCache", "scene", "Lcom/tencent/mobileqq/mini/entry/expDesktop/DesktopExpMiniAppReqListener;", "getMiniAppExpDataInfo", "isSuc", "ret", "Lorg/json/JSONObject;", "initMiniAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "appInfo", "LNS_MINI_INTERFACE/INTERFACE$StUserAppInfo;", "isGetMiniAppUseOld", "isGetMiniAppValid", "operateMiniAppToMyMiniApp", MiniChatConstants.MINI_APP_TOP_TYPE, "oldPositionIndex", "newPositionIndex", "parseAppListToMiniAppInfo", "appList", "", "parseMiniAppListResp", "", "parseMiniExpAppListResp", "parseModuleHostSceneInfo", "", "extInfo", "parseModuleViaInfo", "parsePersonalModuleAppInfo", "moduleInfo", "LNS_MINI_INTERFACE/INTERFACE$StModuleInfo;", "personalModuleMap", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "Lkotlin/collections/HashMap;", "parseSubTabModuleInfoToRankModule", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopRankTabAppInfo;", "subTabMapInfo", "", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopRankSubTabAppInfo;", "parserMiniAppBannerInfo", "miniAppInfoMap", "parserMiniAppInfo", "response", "LNS_MINI_INTERFACE/INTERFACE$StGetDropdownAppListRsp;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ExpDesktopRemoteRepository implements IExpDesktopRemoteRepository {
    public static final long DATA_NOT_EXPIRED_CODE = 1000;
    private static final String DATA_NOT_EXPIRED_MSG = "getDesktopMiniAppRemoteInfo is not isExpired!";
    public static final int INSERT_TOP_TYPE_INDEX = 1;
    public static final int REMOVE_TOP_TYPE_INDEX = 0;
    public static final String REPORT_KEY_HOST_SCENE = "host_scene";
    public static final String REPORT_KEY_HOST_SCENE_2 = "host_scene_2";
    public static final String REPORT_KEY_VIA = "via";
    public static final String REPORT_KEY_VIA_2 = "via_2";
    private static final String TAG = "ExpDesktopRemoteRepository";
    private long mLastRequestStartTs;
    private COMM.StCommonExt mExtInfo = new COMM.StCommonExt();
    private ArrayList<RecommendAppInfo> mRecommendAppList = new ArrayList<>();
    private MiniAppExpRequestRefreshConfig mRefreshConfig = new MiniAppExpRequestRefreshConfig();
    private GetAppListV2Scene mScene = GetAppListV2Scene.UN_KNOWN;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDesktopMiniAppMoreModuleRemoteInfo$lambda$2(ExpDesktopRemoteRepository this$0, int i3, DesktopExpMoreMiniAppReqListener miniAppReqListener, boolean z16, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(miniAppReqListener, "$miniAppReqListener");
        QLog.d(TAG, 1, "getDesktopMiniAppMoreModuleRemoteInfo isSuc:" + z16 + " ret:" + jSONObject);
        if (this$0.isGetMiniAppValid(z16, jSONObject)) {
            miniAppReqListener.getMiniAppInfoSuccess(this$0.parseMiniAppListResp(jSONObject, i3));
        } else {
            miniAppReqListener.getMiniAppInfoFailed(jSONObject != null ? jSONObject.optString("errMsg") : null, jSONObject != null ? Long.valueOf(jSONObject.optLong("retCode")) : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDesktopMiniAppRankModuleRemoteInfo$lambda$1(ExpDesktopRemoteRepository this$0, int i3, DesktopExpRankMiniAppReqListener miniAppReqListener, boolean z16, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(miniAppReqListener, "$miniAppReqListener");
        QLog.d(TAG, 1, "sendMiniAppListSpecificModuleRequest isSuc:" + z16 + " ret:" + jSONObject);
        if (this$0.isGetMiniAppValid(z16, jSONObject)) {
            miniAppReqListener.getMiniAppInfoSuccess(this$0.parseMiniAppListResp(jSONObject, i3));
        } else {
            miniAppReqListener.getMiniAppInfoFailed(jSONObject != null ? jSONObject.optString("errMsg") : null, jSONObject != null ? Long.valueOf(jSONObject.optLong("retCode")) : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDesktopMiniAppRemoteInfo$lambda$0(ExpDesktopRemoteRepository this$0, DesktopExpMiniAppReqListener miniAppReqListener, boolean z16, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(miniAppReqListener, "$miniAppReqListener");
        QLog.d(TAG, 1, "exp sendMiniAppListRequest isSuc:" + z16 + " ret:" + jSONObject);
        this$0.getMiniAppExpDataInfo(z16, jSONObject, miniAppReqListener);
    }

    private final void getMiniAppExpDataInfo(boolean isSuc, JSONObject ret, DesktopExpMiniAppReqListener miniAppReqListener) {
        if (!isGetMiniAppValid(isSuc, ret)) {
            QLog.i(TAG, 1, "GetMiniApp is invalid!");
            DesktopExpMiniAppReqListener.DefaultImpls.getMiniAppInfoFailed$default(miniAppReqListener, ret != null ? ret.optString("errMsg") : null, ret != null ? Long.valueOf(ret.optLong("retCode")) : null, false, 4, null);
            return;
        }
        if (isGetMiniAppUseOld(ret)) {
            QLog.i(TAG, 1, "getMiniAppExpDataInfo isGetMiniAppUseOld!");
            miniAppReqListener.getMiniAppInfoFailed(ret != null ? ret.optString("errMsg") : null, ret != null ? Long.valueOf(ret.optLong("retCode")) : null, false);
            return;
        }
        Object opt = ret != null ? ret.opt("response") : null;
        Intrinsics.checkNotNull(opt, "null cannot be cast to non-null type NS_MINI_INTERFACE.INTERFACE.StGetDropdownAppListRsp");
        List<INTERFACE$StModuleInfo> list = ((INTERFACE$StGetDropdownAppListRsp) opt).modules.get();
        if (list != null && !list.isEmpty()) {
            if (StudyModeManager.t()) {
                QLog.i(TAG, 1, "DropdownAppListRsp is study mode!");
                return;
            } else {
                parseMiniExpAppListResp(ret, miniAppReqListener);
                return;
            }
        }
        DesktopExpMiniAppReqListener.DefaultImpls.getMiniAppInfoFailed$default(miniAppReqListener, "DropdownAppListRsp is empty!", -1L, false, 4, null);
        QLog.i(TAG, 1, "DropdownAppListRsp is empty!");
    }

    private final DesktopAppInfo initMiniAppInfo(int moduleType, INTERFACE$StUserAppInfo appInfo, GetAppListV2Scene scene) {
        DesktopAppInfo desktopAppInfo = new DesktopAppInfo(moduleType, MiniAppInfo.from(appInfo));
        desktopAppInfo.requestScene = scene.ordinal();
        desktopAppInfo.requestStartTs = this.mLastRequestStartTs;
        MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
        if (miniAppInfo != null && miniAppInfo.isLimitedAccessApp()) {
            desktopAppInfo.dragEnable = false;
        }
        MiniAppInfo miniAppInfo2 = desktopAppInfo.mMiniAppInfo;
        if (miniAppInfo2 != null) {
            miniAppInfo2.debugInfo = null;
        }
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
                this.mRefreshConfig.setLastRequestTime(this.mScene, 0L);
            }
            QLog.e(TAG, 1, "miniAppListRequestFailed retCode=" + valueOf);
            return false;
        }
        if (ret != null && 0 != ret.optLong("retCode")) {
            QLog.e(TAG, 1, "isSuc miniAppListRequestFailed retCode=" + ret.optLong("retCode"));
            return false;
        }
        if ((ret != null ? ret.opt("response") : null) != null) {
            return true;
        }
        QLog.e(TAG, 1, "miniAppListRequestFailed response is null!");
        return false;
    }

    private final ArrayList<DesktopAppInfo> parseAppListToMiniAppInfo(List<INTERFACE$StUserAppInfo> appList, int moduleType) {
        ArrayList<DesktopAppInfo> arrayList = new ArrayList<>();
        List<INTERFACE$StUserAppInfo> list = appList;
        if (!(list == null || list.isEmpty())) {
            Iterator<T> it = appList.iterator();
            while (it.hasNext()) {
                DesktopAppInfo initMiniAppInfo = initMiniAppInfo(moduleType, (INTERFACE$StUserAppInfo) it.next(), this.mScene);
                arrayList.add(initMiniAppInfo);
                if (QLog.isDebugVersion()) {
                    QLog.d(TAG, 1, "Module_type_App appName:" + initMiniAppInfo.mMiniAppInfo.name);
                }
            }
        }
        return arrayList;
    }

    private final ArrayList<String> parseModuleHostSceneInfo(COMM.StCommonExt extInfo) {
        ArrayList<String> arrayListOf;
        ArrayList<String> arrayListOf2;
        List<COMM.Entry> list;
        PBRepeatMessageField<COMM.Entry> pBRepeatMessageField = extInfo.mapInfo;
        if (pBRepeatMessageField == null || pBRepeatMessageField.get().isEmpty()) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("", "");
            return arrayListOf;
        }
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf("", "");
        PBRepeatMessageField<COMM.Entry> pBRepeatMessageField2 = extInfo.mapInfo;
        if (pBRepeatMessageField2 != null && (list = pBRepeatMessageField2.get()) != null) {
            for (COMM.Entry entry : list) {
                QLog.i(TAG, 1, "parseModuleHostSceneInfo key:" + entry.key.get() + " value:" + entry.value.get());
                if (Intrinsics.areEqual("host_scene", entry.key.get())) {
                    arrayListOf2.set(0, entry.value.get());
                } else if (Intrinsics.areEqual(REPORT_KEY_HOST_SCENE_2, entry.key.get())) {
                    arrayListOf2.set(1, entry.value.get());
                }
            }
        }
        return arrayListOf2;
    }

    private final ArrayList<String> parseModuleViaInfo(COMM.StCommonExt extInfo) {
        ArrayList<String> arrayListOf;
        ArrayList<String> arrayListOf2;
        List<COMM.Entry> list;
        PBRepeatMessageField<COMM.Entry> pBRepeatMessageField = extInfo.mapInfo;
        if (pBRepeatMessageField == null || pBRepeatMessageField.get().isEmpty()) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("", "");
            return arrayListOf;
        }
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf("", "");
        PBRepeatMessageField<COMM.Entry> pBRepeatMessageField2 = extInfo.mapInfo;
        if (pBRepeatMessageField2 != null && (list = pBRepeatMessageField2.get()) != null) {
            for (COMM.Entry entry : list) {
                if (Intrinsics.areEqual("via", entry.key.get())) {
                    arrayListOf2.set(0, entry.value.get());
                } else if (Intrinsics.areEqual(REPORT_KEY_VIA_2, entry.key.get())) {
                    arrayListOf2.set(1, entry.value.get());
                }
            }
        }
        return arrayListOf2;
    }

    private final void parsePersonalModuleAppInfo(INTERFACE$StModuleInfo moduleInfo, HashMap<Integer, DesktopItemInfo> personalModuleMap) {
        int i3 = moduleInfo.moduleType.get();
        DesktopItemInfo desktopItemInfo = personalModuleMap.get(Integer.valueOf(i3));
        Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
        ExpDesktopGroupAppInfo expDesktopGroupAppInfo = (ExpDesktopGroupAppInfo) desktopItemInfo;
        String str = moduleInfo.title.get();
        Intrinsics.checkNotNullExpressionValue(str, "moduleInfo.title.get()");
        expDesktopGroupAppInfo.setModuleTitle(str);
        expDesktopGroupAppInfo.setGroupAppInfo(parseAppListToMiniAppInfo(moduleInfo.userAppList.get(), i3));
        COMM.StCommonExt stCommonExt = moduleInfo.extInfo;
        Intrinsics.checkNotNullExpressionValue(stCommonExt, "moduleInfo.extInfo");
        expDesktopGroupAppInfo.setVia(parseModuleViaInfo(stCommonExt));
        COMM.StCommonExt stCommonExt2 = moduleInfo.extInfo;
        Intrinsics.checkNotNullExpressionValue(stCommonExt2, "moduleInfo.extInfo");
        expDesktopGroupAppInfo.setHostScene(parseModuleHostSceneInfo(stCommonExt2));
        expDesktopGroupAppInfo.setIsFinished(moduleInfo.isFinished.get() == 1);
    }

    private final ArrayList<ExpDesktopRankTabAppInfo> parseSubTabModuleInfoToRankModule(Map<String, ArrayList<ExpDesktopRankSubTabAppInfo>> subTabMapInfo) {
        ArrayList<ExpDesktopRankTabAppInfo> arrayList = new ArrayList<>();
        for (Map.Entry<String, ArrayList<ExpDesktopRankSubTabAppInfo>> entry : subTabMapInfo.entrySet()) {
            arrayList.add(new ExpDesktopRankTabAppInfo(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    private final void parserMiniAppBannerInfo(INTERFACE$StModuleInfo moduleInfo, HashMap<Integer, DesktopItemInfo> miniAppInfoMap) {
        DesktopBannerModuleInfo desktopBannerModuleInfo = new DesktopBannerModuleInfo(moduleInfo);
        desktopBannerModuleInfo.requestScene = this.mScene.ordinal();
        desktopBannerModuleInfo.requestStartTs = this.mLastRequestStartTs;
        if (miniAppInfoMap.get(14) == null) {
            ExpDesktopGroupBannerInfo expDesktopGroupBannerInfo = new ExpDesktopGroupBannerInfo(14, new ArrayList());
            expDesktopGroupBannerInfo.getGroupBannerInfo().add(desktopBannerModuleInfo);
            miniAppInfoMap.put(14, expDesktopGroupBannerInfo);
        } else {
            DesktopItemInfo desktopItemInfo = miniAppInfoMap.get(14);
            Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupBannerInfo");
            ((ExpDesktopGroupBannerInfo) desktopItemInfo).getGroupBannerInfo().add(desktopBannerModuleInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void parserMiniAppInfo$lambda$3(DesktopExpMiniAppReqListener miniAppReqListener, HashMap personalModuleMap, List recommendModules, ArrayList rankModules) {
        Intrinsics.checkNotNullParameter(miniAppReqListener, "$miniAppReqListener");
        Intrinsics.checkNotNullParameter(personalModuleMap, "$personalModuleMap");
        Intrinsics.checkNotNullParameter(recommendModules, "$recommendModules");
        Intrinsics.checkNotNullParameter(rankModules, "$rankModules");
        miniAppReqListener.getMiniAppInfoSuccess(personalModuleMap, recommendModules, rankModules);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopRemoteRepository
    public void deleteDesktopMiniApp(MiniAppInfo miniAppInfo, int moduleType, MiniAppCmdInterface listener) {
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.d(TAG, 1, "deleteDesktopMiniApp miniAppInfo:" + miniAppInfo);
        MiniAppCmdUtil.getInstance().delUserApp(miniAppInfo.appId, miniAppInfo.verType, miniAppInfo.recommend, 1, null, moduleType, listener);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopRemoteRepository
    public void getDesktopMiniAppMoreModuleRemoteInfo(final int moduleType, final DesktopExpMoreMiniAppReqListener miniAppReqListener) {
        List listOf;
        Intrinsics.checkNotNullParameter(miniAppReqListener, "miniAppReqListener");
        QLog.d(TAG, 1, "getDesktopMiniAppMoreModuleRemoteInfo moduleType: " + moduleType);
        MiniAppCmdUtil miniAppCmdUtil = MiniAppCmdUtil.getInstance();
        COMM.StCommonExt stCommonExt = this.mExtInfo;
        GetAppListV2Scene getAppListV2Scene = GetAppListV2Scene.DROP_DOWN;
        ArrayList<RecommendAppInfo> arrayList = new ArrayList<>();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(moduleType));
        miniAppCmdUtil.getUserAppListV3(stCommonExt, getAppListV2Scene, arrayList, new ArrayList<>(listOf), new ArrayList<>(), new ArrayList<>(), 1, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.repository.g
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                ExpDesktopRemoteRepository.getDesktopMiniAppMoreModuleRemoteInfo$lambda$2(ExpDesktopRemoteRepository.this, moduleType, miniAppReqListener, z16, jSONObject);
            }
        });
        QLog.d(TAG, 1, "sendMiniAppListSpecificModuleRequest!");
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopRemoteRepository
    public void getDesktopMiniAppRankModuleRemoteInfo(final int moduleType, final DesktopExpRankMiniAppReqListener miniAppReqListener) {
        List listOf;
        Intrinsics.checkNotNullParameter(miniAppReqListener, "miniAppReqListener");
        MiniAppCmdUtil miniAppCmdUtil = MiniAppCmdUtil.getInstance();
        COMM.StCommonExt stCommonExt = this.mExtInfo;
        GetAppListV2Scene getAppListV2Scene = GetAppListV2Scene.DROP_DOWN;
        ArrayList<RecommendAppInfo> arrayList = this.mRecommendAppList;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(moduleType));
        miniAppCmdUtil.getUserAppListV3(stCommonExt, getAppListV2Scene, arrayList, new ArrayList<>(listOf), new ArrayList<>(), new ArrayList<>(), 0, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.repository.e
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                ExpDesktopRemoteRepository.getDesktopMiniAppRankModuleRemoteInfo$lambda$1(ExpDesktopRemoteRepository.this, moduleType, miniAppReqListener, z16, jSONObject);
            }
        });
        this.mScene = getAppListV2Scene;
        this.mLastRequestStartTs = System.currentTimeMillis();
        QLog.d(TAG, 1, "sendMiniAppListSpecificModuleRequest!");
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopRemoteRepository
    public void getDesktopMiniAppRemoteInfo(boolean force, boolean isUseCache, GetAppListV2Scene scene, final DesktopExpMiniAppReqListener miniAppReqListener) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(miniAppReqListener, "miniAppReqListener");
        QLog.d(TAG, 1, "getDesktopMiniAppRemoteInfo force:" + force + " scene:" + scene + " isUseCache:" + isUseCache);
        if (!force && !this.mRefreshConfig.isExpired(scene)) {
            QLog.d(TAG, 1, DATA_NOT_EXPIRED_MSG);
            DesktopExpMiniAppReqListener.DefaultImpls.getMiniAppInfoFailed$default(miniAppReqListener, DATA_NOT_EXPIRED_MSG, 1000L, false, 4, null);
            return;
        }
        this.mLastRequestStartTs = System.currentTimeMillis();
        MiniAppExpDesktopRemoteDataHelper.Companion companion = MiniAppExpDesktopRemoteDataHelper.INSTANCE;
        companion.getInstance().setExtInfoGdtCookie(this.mExtInfo);
        companion.getInstance().setExtInfoTeenager(this.mExtInfo);
        this.mScene = scene;
        MiniAppCmdUtil.getInstance().getUserAppListV3(this.mExtInfo, this.mScene, this.mRecommendAppList, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), isUseCache ? 1 : 0, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.repository.f
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                ExpDesktopRemoteRepository.getDesktopMiniAppRemoteInfo$lambda$0(ExpDesktopRemoteRepository.this, miniAppReqListener, z16, jSONObject);
            }
        });
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopRemoteRepository
    public void operateMiniAppToMyMiniApp(MiniAppInfo miniAppInfo, int topType, int oldPositionIndex, int newPositionIndex, MiniAppCmdInterface listener) {
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.d(TAG, 1, "operateMiniAppToMyMiniApp miniAppInfo:" + miniAppInfo + " moduleType:" + newPositionIndex);
        MiniAppCmdUtil.getInstance().setUserAppTop(miniAppInfo.appId, topType, miniAppInfo.verType, oldPositionIndex, newPositionIndex, null, listener);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopRemoteRepository
    public void deleteRecentPlayLoadMoreApp() {
        QLog.d(TAG, 1, "deleteRecentPlayLoadMoreApp");
    }

    private final boolean isGetMiniAppUseOld(JSONObject ret) {
        Object opt = ret != null ? ret.opt("response") : null;
        Intrinsics.checkNotNull(opt, "null cannot be cast to non-null type NS_MINI_INTERFACE.INTERFACE.StGetDropdownAppListRsp");
        if (((INTERFACE$StGetDropdownAppListRsp) opt).useOld.get() != 1) {
            return false;
        }
        QLog.e(TAG, 1, "sendUserAppListRequest, reuse old data.");
        return true;
    }

    private final List<DesktopAppInfo> parseMiniAppListResp(JSONObject ret, int moduleType) {
        Object opt = ret != null ? ret.opt("response") : null;
        Intrinsics.checkNotNull(opt, "null cannot be cast to non-null type NS_MINI_INTERFACE.INTERFACE.StGetDropdownAppListRsp");
        List<INTERFACE$StModuleInfo> list = ((INTERFACE$StGetDropdownAppListRsp) opt).modules.get();
        if (list != null && !list.isEmpty() && !StudyModeManager.t()) {
            for (INTERFACE$StModuleInfo iNTERFACE$StModuleInfo : list) {
                int i3 = iNTERFACE$StModuleInfo.moduleType.get();
                if (moduleType == i3 && iNTERFACE$StModuleInfo.userAppList.get() != null) {
                    return parseAppListToMiniAppInfo(iNTERFACE$StModuleInfo.userAppList.get(), i3);
                }
            }
            return new ArrayList();
        }
        QLog.d(TAG, 1, "StudyMode and DropdownAppListRsp is empty!");
        return new ArrayList();
    }

    private final void parseMiniExpAppListResp(JSONObject ret, DesktopExpMiniAppReqListener miniAppReqListener) {
        Object opt = ret != null ? ret.opt("response") : null;
        Intrinsics.checkNotNull(opt, "null cannot be cast to non-null type NS_MINI_INTERFACE.INTERFACE.StGetDropdownAppListRsp");
        INTERFACE$StGetDropdownAppListRsp iNTERFACE$StGetDropdownAppListRsp = (INTERFACE$StGetDropdownAppListRsp) opt;
        COMM.StCommonExt stCommonExt = iNTERFACE$StGetDropdownAppListRsp.extInfo.get();
        Intrinsics.checkNotNullExpressionValue(stCommonExt, "response.extInfo.get()");
        this.mExtInfo = stCommonExt;
        MiniAppUtils.saveGdtCookie(iNTERFACE$StGetDropdownAppListRsp.extInfo.get());
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            MiniAppUtils.handlePreloadAppDataV2(MobileQQ.sMobileQQ.peekAppRuntime().getApp(), iNTERFACE$StGetDropdownAppListRsp);
        }
        parserMiniAppInfo(iNTERFACE$StGetDropdownAppListRsp, miniAppReqListener);
        this.mRefreshConfig.setLastRequestTime(this.mScene, this.mLastRequestStartTs);
        this.mRefreshConfig.setRefreshInterval(this.mScene, iNTERFACE$StGetDropdownAppListRsp.freshInternal.get());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        String currentAccountUin = ((AppInterface) peekAppRuntime).getCurrentAccountUin();
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool("mini_get_app_list_exp_" + currentAccountUin, true);
        QLog.d(TAG, 1, "setMiniAppListRequestSuccess");
    }

    private final void parserMiniAppInfo(INTERFACE$StGetDropdownAppListRsp response, final DesktopExpMiniAppReqListener miniAppReqListener) {
        ArrayList arrayListOf;
        ArrayList arrayListOf2;
        final HashMap<Integer, DesktopItemInfo> hashMap = new HashMap<>();
        String string = BaseApplicationImpl.getApplication().getString(R.string.f169847xy0);
        Intrinsics.checkNotNullExpressionValue(string, "getApplication().getStri\u2026tring.min_app_recent_use)");
        ArrayList arrayList = new ArrayList();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("", "");
        hashMap.put(1, new ExpDesktopGroupAppInfo(string, 1, arrayList, arrayListOf, null, false, 48, null));
        int i3 = 3;
        String string2 = BaseApplicationImpl.getApplication().getString(R.string.xxt);
        Intrinsics.checkNotNullExpressionValue(string2, "getApplication().getStri\u2026string.min_app_mine_play)");
        ArrayList arrayList2 = new ArrayList();
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf("", "");
        hashMap.put(3, new ExpDesktopGroupAppInfo(string2, 3, arrayList2, arrayListOf2, null, false, 48, null));
        final ArrayList arrayList3 = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (INTERFACE$StModuleInfo moduleInfo : response.modules.get()) {
            int i16 = moduleInfo.moduleType.get();
            QLog.i(TAG, 1, "moduleType:" + i16);
            if (i16 == 1 || i16 == i3) {
                Intrinsics.checkNotNullExpressionValue(moduleInfo, "moduleInfo");
                parsePersonalModuleAppInfo(moduleInfo, hashMap);
            } else if (i16 != 14) {
                String moduleTitle = moduleInfo.title.get();
                INTERFACE$StModuleLayout iNTERFACE$StModuleLayout = moduleInfo.layout.get();
                if (!(moduleTitle == null || moduleTitle.length() == 0) && iNTERFACE$StModuleLayout != null) {
                    int i17 = iNTERFACE$StModuleLayout.direction.get();
                    if (i17 == 1) {
                        ArrayList<DesktopAppInfo> parseAppListToMiniAppInfo = parseAppListToMiniAppInfo(moduleInfo.userAppList.get(), i16);
                        COMM.StCommonExt stCommonExt = moduleInfo.extInfo;
                        Intrinsics.checkNotNullExpressionValue(stCommonExt, "moduleInfo.extInfo");
                        ArrayList<String> parseModuleViaInfo = parseModuleViaInfo(stCommonExt);
                        COMM.StCommonExt stCommonExt2 = moduleInfo.extInfo;
                        Intrinsics.checkNotNullExpressionValue(stCommonExt2, "moduleInfo.extInfo");
                        ArrayList<String> parseModuleHostSceneInfo = parseModuleHostSceneInfo(stCommonExt2);
                        boolean z16 = moduleInfo.isFinished.get() == 1;
                        Intrinsics.checkNotNullExpressionValue(moduleTitle, "moduleTitle");
                        arrayList3.add(new ExpDesktopGroupAppInfo(moduleTitle, i16, parseAppListToMiniAppInfo, parseModuleViaInfo, parseModuleHostSceneInfo, z16));
                    } else if (i17 == 2) {
                        ArrayList<DesktopAppInfo> parseAppListToMiniAppInfo2 = parseAppListToMiniAppInfo(moduleInfo.userAppList.get(), i16);
                        String aggregate = iNTERFACE$StModuleLayout.aggregate.get();
                        COMM.StCommonExt stCommonExt3 = moduleInfo.extInfo;
                        Intrinsics.checkNotNullExpressionValue(stCommonExt3, "moduleInfo.extInfo");
                        ArrayList<String> parseModuleViaInfo2 = parseModuleViaInfo(stCommonExt3);
                        COMM.StCommonExt stCommonExt4 = moduleInfo.extInfo;
                        Intrinsics.checkNotNullExpressionValue(stCommonExt4, "moduleInfo.extInfo");
                        ArrayList<String> parseModuleHostSceneInfo2 = parseModuleHostSceneInfo(stCommonExt4);
                        boolean z17 = moduleInfo.isFinished.get() == 1;
                        Intrinsics.checkNotNullExpressionValue(moduleTitle, "moduleTitle");
                        ExpDesktopRankSubTabAppInfo expDesktopRankSubTabAppInfo = new ExpDesktopRankSubTabAppInfo(moduleTitle, i16, parseAppListToMiniAppInfo2, parseModuleViaInfo2, parseModuleHostSceneInfo2, z17);
                        if (!linkedHashMap.containsKey(aggregate)) {
                            Intrinsics.checkNotNullExpressionValue(aggregate, "aggregate");
                            linkedHashMap.put(aggregate, new ArrayList<>());
                        }
                        ArrayList<ExpDesktopRankSubTabAppInfo> arrayList4 = linkedHashMap.get(aggregate);
                        if (arrayList4 != null) {
                            arrayList4.add(expDesktopRankSubTabAppInfo);
                        }
                    }
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(moduleInfo, "moduleInfo");
                parserMiniAppBannerInfo(moduleInfo, hashMap);
            }
            i3 = 3;
        }
        final ArrayList<ExpDesktopRankTabAppInfo> parseSubTabModuleInfoToRankModule = parseSubTabModuleInfoToRankModule(linkedHashMap);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.repository.d
            @Override // java.lang.Runnable
            public final void run() {
                ExpDesktopRemoteRepository.parserMiniAppInfo$lambda$3(DesktopExpMiniAppReqListener.this, hashMap, arrayList3, parseSubTabModuleInfoToRankModule);
            }
        });
    }
}

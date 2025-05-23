package com.tencent.mobileqq.mini.entry.expDesktop.mvi;

import android.os.Bundle;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.DesktopExpMiniAppReqListener;
import com.tencent.mobileqq.mini.entry.expDesktop.DesktopExpMoreMiniAppReqListener;
import com.tencent.mobileqq.mini.entry.expDesktop.DesktopExpRankMiniAppReqListener;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopRankTabAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopIntent;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopUIState;
import com.tencent.mobileqq.mini.entry.expDesktop.repository.ExpDesktopRepositoryImpl;
import com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopLocalMmkvRepository;
import com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopRepository;
import com.tencent.mobileqq.mini.entry.expDesktop.repository.MiniAppExpDesktopLocalDataHelper;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniAppListDiffUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.mini.util.MiniAppToastUtil;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import eipc.EIPCModule;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001dB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020#H\u0002J\u0018\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0007H\u0002J\u0010\u00101\u001a\u00020#2\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u00102\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00172\u0006\u00101\u001a\u000203H\u0002J\b\u00104\u001a\u00020,H\u0016J\b\u00105\u001a\u00020#H\u0002J\u0018\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\nH\u0002J\u0010\u00109\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0017H\u0002J\u0010\u0010:\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0017H\u0002J\"\u0010;\u001a\u0004\u0018\u00010!2\u0006\u0010<\u001a\u00020\u00172\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010=\u001a\u00020\u0017J\u0010\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020\u0003H\u0016J\u0006\u0010@\u001a\u00020#J\u0018\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u0002032\u0006\u0010C\u001a\u00020\u0017H\u0002J\u0010\u0010D\u001a\u00020#2\u0006\u0010.\u001a\u00020EH\u0002J\u0018\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020,2\u0006\u0010H\u001a\u00020\u0017H\u0002J\b\u0010I\u001a\u00020\u0007H\u0002J\u0010\u0010J\u001a\u00020#2\u0006\u0010B\u001a\u00020!H\u0002J\u0010\u0010K\u001a\u00020#2\u0006\u0010?\u001a\u00020LH\u0002J\u0010\u0010M\u001a\u00020#2\u0006\u0010.\u001a\u00020NH\u0002J\u0018\u0010O\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J,\u0010P\u001a\u00020#2\u001a\u0010Q\u001a\u0016\u0012\u0004\u0012\u000203\u0018\u00010Rj\n\u0012\u0004\u0012\u000203\u0018\u0001`S2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010T\u001a\u00020#2\u0006\u0010.\u001a\u00020UH\u0002J\u0010\u0010V\u001a\u00020#2\u0006\u0010W\u001a\u00020XH\u0002J\u000e\u0010Y\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0007J\u000e\u0010Z\u001a\u00020#2\u0006\u0010[\u001a\u00020\nJ\b\u0010\\\u001a\u00020#H\u0002J\u0010\u0010]\u001a\u00020#2\u0006\u0010B\u001a\u00020!H\u0002J\u000e\u0010^\u001a\u00020#2\u0006\u0010_\u001a\u00020\u0007J&\u0010`\u001a\u00020#\"\u0004\b\u0000\u0010a*\b\u0012\u0004\u0012\u0002Ha0\u001a2\u0006\u0010b\u001a\u00020\u00172\u0006\u0010c\u001a\u00020\u0017R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006e"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopViewModel;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopBaseViewModel;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopIntent;", "()V", "isDesktopOpen", "Landroidx/lifecycle/LiveData;", "", "()Landroidx/lifecycle/LiveData;", "isPreloadInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/GetAppListV2Scene;", "mIsDesktopOpen", "Landroidx/lifecycle/MutableLiveData;", "mIsInitLocalData", "mIsNetworkDone", "mIsPreloadInfo", "mMiniAppRepository", "Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/IExpDesktopRepository;", "mNoneValueIntent", "getMNoneValueIntent", "()Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopIntent;", "mPersonalModuleMap", "", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "mRankModules", "", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopRankTabAppInfo;", "mRecommendModules", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopGroupAppInfo;", "mSubLayoutOpenState", "checkIfAppExist", "info", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "checkIsInMyAppList", "", "params", "Landroid/os/Bundle;", "eipcModule", "Leipc/EIPCModule;", "clearDesktopAllMiniInfo", "deleteDesktopMiniAppInfo", "moduleType", "appId", "", "deleteItemResponse", "miniAppDesktopIntent", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopIntent$DeleteDesktopMiniApp;", "isSuccess", "deleteMiniAppInfo", "getDeleteItemIndex", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "getLogTag", "getMiniAppDesktopLocalInfo", "getMiniAppDesktopNetworkInfo", FileReaderHelper.OPEN_FILE_FROM_FORCE, "scene", "getModuleMoreMiniAppInfo", "getModuleRankMiniAppInfo", "getPersonalModuleMiniAppInfoById", "dataModule", "verType", "handleIntent", "miniAppExpDesktopIntent", "initLocalDataState", "insertMiniAppInfo", "miniAppInfo", "position", "insertMyMiniAppToTopById", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopIntent$InsertMyMiniAppToTopById;", "isNeedResetMyMiniAppInfoForInsertMiniApp", "insertMiniAppId", "newPosition", "isOperateToMuch", "moveRecentAppExistMiniApp", "myMiniAppDraggingTempSwitchPosition", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopIntent$MyMiniAppDraggingTempSwitchPosition;", "myMiniAppSwitchPosition", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopIntent$MyMiniAppSwitchPosition;", "queryMyMiniAppInfo", "removeMiniAppItem", "miniAppList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "removeMyMiniAppTopById", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopIntent$RemoveMyMiniAppTopById;", "runningInMainThread", "runnable", "Ljava/lang/Runnable;", "setDesktopOpen", "setPreloadInfo", "preloadInfoScene", "setRecentStartMiniAppListener", "updateRecentStartMiniAppInfo", "updateSubLayoutOpenState", "state", "swap", "T", "index1", "index2", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public class MiniAppExpDesktopViewModel extends MiniAppExpDesktopBaseViewModel<MiniAppExpDesktopUIState, MiniAppExpDesktopIntent> {
    private static final int MINI_APP_IN_MY_APP_TYPE = 1;
    private static final int MINI_APP_NOT_IN_MY_APP_TYPE = 0;
    private final LiveData<Boolean> isDesktopOpen;
    private final LiveData<GetAppListV2Scene> isPreloadInfo;
    private final MutableLiveData<Boolean> mIsDesktopOpen;
    private boolean mIsInitLocalData;
    private final MutableLiveData<GetAppListV2Scene> mIsPreloadInfo;
    private final MiniAppExpDesktopIntent mNoneValueIntent = MiniAppExpDesktopIntent.NONE.INSTANCE;
    private IExpDesktopRepository mMiniAppRepository = new ExpDesktopRepositoryImpl();
    private boolean mIsNetworkDone = true;
    private Map<Integer, DesktopItemInfo> mPersonalModuleMap = new LinkedHashMap();
    private List<ExpDesktopGroupAppInfo> mRecommendModules = new ArrayList();
    private List<ExpDesktopRankTabAppInfo> mRankModules = new ArrayList();
    private final MutableLiveData<Boolean> mSubLayoutOpenState = new MutableLiveData<>();

    public MiniAppExpDesktopViewModel() {
        MutableLiveData<GetAppListV2Scene> mutableLiveData = new MutableLiveData<>();
        this.mIsPreloadInfo = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this.mIsDesktopOpen = mutableLiveData2;
        this.isDesktopOpen = mutableLiveData2;
        this.isPreloadInfo = mutableLiveData;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.mvi.d
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppExpDesktopViewModel._init_$lambda$0(MiniAppExpDesktopViewModel.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(MiniAppExpDesktopViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setRecentStartMiniAppListener();
    }

    private final boolean checkIfAppExist(MiniAppInfo info) {
        ArrayList<DesktopAppInfo> groupAppInfo;
        ArrayList<DesktopAppInfo> groupAppInfo2;
        Object obj;
        DesktopItemInfo desktopItemInfo = this.mPersonalModuleMap.get(1);
        Object obj2 = null;
        if (desktopItemInfo != null) {
            ExpDesktopGroupAppInfo expDesktopGroupAppInfo = desktopItemInfo instanceof ExpDesktopGroupAppInfo ? (ExpDesktopGroupAppInfo) desktopItemInfo : null;
            if (expDesktopGroupAppInfo != null && (groupAppInfo2 = expDesktopGroupAppInfo.getGroupAppInfo()) != null) {
                Iterator<T> it = groupAppInfo2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual(((DesktopAppInfo) obj).mMiniAppInfo.appId, info != null ? info.appId : null)) {
                        break;
                    }
                }
                if (obj != null) {
                    return true;
                }
            }
        }
        DesktopItemInfo desktopItemInfo2 = this.mPersonalModuleMap.get(3);
        if (desktopItemInfo2 != null) {
            ExpDesktopGroupAppInfo expDesktopGroupAppInfo2 = desktopItemInfo2 instanceof ExpDesktopGroupAppInfo ? (ExpDesktopGroupAppInfo) desktopItemInfo2 : null;
            if (expDesktopGroupAppInfo2 != null && (groupAppInfo = expDesktopGroupAppInfo2.getGroupAppInfo()) != null) {
                Iterator<T> it5 = groupAppInfo.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    Object next = it5.next();
                    if (Intrinsics.areEqual(((DesktopAppInfo) next).mMiniAppInfo.appId, info != null ? info.appId : null)) {
                        obj2 = next;
                        break;
                    }
                }
                if (obj2 != null) {
                    return true;
                }
            }
        }
        return false;
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
            MiniAppInfo personalModuleMiniAppInfoById = getPersonalModuleMiniAppInfoById(3, string, 3);
            if (personalModuleMiniAppInfoById == null) {
                bundle.putBoolean("isAdded", false);
            } else {
                bundle.putBoolean("isAdded", true);
            }
            QLog.i(getTAG(), 1, "checkIsInMyAppList isAdded:" + personalModuleMiniAppInfoById);
            eipcModule.callbackResult(i3, EIPCResult.createResult(0, bundle));
            return;
        }
        QLog.e(getTAG(), 1, "appId\u3001callbackId has not contain!");
    }

    private final void clearDesktopAllMiniInfo() {
        this.mPersonalModuleMap.clear();
        this.mRecommendModules.clear();
        this.mRankModules.clear();
    }

    private final void deleteDesktopMiniAppInfo(int moduleType, String appId) {
        DesktopItemInfo desktopItemInfo = this.mPersonalModuleMap.get(Integer.valueOf(moduleType));
        Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
        Iterator<DesktopAppInfo> it = ((ExpDesktopGroupAppInfo) desktopItemInfo).getGroupAppInfo().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "mPersonalModuleMap[modul\u2026GroupAppInfo().iterator()");
        while (it.hasNext()) {
            DesktopAppInfo next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            DesktopAppInfo desktopAppInfo = next;
            if (desktopAppInfo.mMiniAppInfo.appId.equals(appId)) {
                it.remove();
                QLog.d(getTAG(), 1, "DeleteDesktopMiniApp cache name:" + desktopAppInfo.mMiniAppInfo.name);
                return;
            }
        }
    }

    private final void deleteItemResponse(MiniAppExpDesktopIntent.DeleteDesktopMiniApp miniAppDesktopIntent, boolean isSuccess) {
        int deleteItemIndex = getDeleteItemIndex(miniAppDesktopIntent.getModuleType(), miniAppDesktopIntent.getDesktopAppInfo());
        if (isSuccess) {
            if (!checkIfAppExist(miniAppDesktopIntent.getDesktopAppInfo().mMiniAppInfo)) {
                IExpDesktopRepository iExpDesktopRepository = this.mMiniAppRepository;
                MiniAppInfo miniAppInfo = miniAppDesktopIntent.getDesktopAppInfo().mMiniAppInfo;
                Intrinsics.checkNotNullExpressionValue(miniAppInfo, "miniAppDesktopIntent.desktopAppInfo.mMiniAppInfo");
                iExpDesktopRepository.deleteMiniAppDbInfo(miniAppInfo);
            }
            IExpDesktopLocalMmkvRepository.DefaultImpls.updateMiniAppPositionInMmkv$default(this.mMiniAppRepository, this.mPersonalModuleMap, null, null, 6, null);
            MiniAppToastUtil.show(BaseApplication.getContext(), 2, R.string.f167032bu, 0);
        } else {
            DesktopItemInfo desktopItemInfo = this.mPersonalModuleMap.get(Integer.valueOf(miniAppDesktopIntent.getModuleType()));
            Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
            ((ExpDesktopGroupAppInfo) desktopItemInfo).getGroupAppInfo().add(deleteItemIndex, miniAppDesktopIntent.getDesktopAppInfo());
            getMUiState().postValue(new MiniAppExpDesktopUIState.UpdateDesktopPersonalMiniAppInfo(this.mPersonalModuleMap, miniAppDesktopIntent.getModuleType()));
            MiniAppToastUtil.show(BaseApplication.getContext(), 2, R.string.f167022bt, 0);
        }
        this.mIsNetworkDone = true;
    }

    private final void deleteMiniAppInfo(final MiniAppExpDesktopIntent.DeleteDesktopMiniApp miniAppDesktopIntent) {
        if (isOperateToMuch()) {
            QLog.i(getTAG(), 1, "deleteMiniAppInfo isOperateToMuch!");
            return;
        }
        int moduleType = miniAppDesktopIntent.getModuleType();
        String str = miniAppDesktopIntent.getDesktopAppInfo().mMiniAppInfo.appId;
        Intrinsics.checkNotNullExpressionValue(str, "miniAppDesktopIntent.des\u2026ppInfo.mMiniAppInfo.appId");
        deleteDesktopMiniAppInfo(moduleType, str);
        getMUiState().postValue(new MiniAppExpDesktopUIState.UpdateDesktopPersonalMiniAppInfo(this.mPersonalModuleMap, miniAppDesktopIntent.getModuleType()));
        if (miniAppDesktopIntent.getModuleType() == 3) {
            IExpDesktopRepository iExpDesktopRepository = this.mMiniAppRepository;
            MiniAppInfo miniAppInfo = miniAppDesktopIntent.getDesktopAppInfo().mMiniAppInfo;
            Intrinsics.checkNotNullExpressionValue(miniAppInfo, "miniAppDesktopIntent.desktopAppInfo.mMiniAppInfo");
            iExpDesktopRepository.operateMiniAppToMyMiniApp(miniAppInfo, 0, -1, -1, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.mvi.b
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                    MiniAppExpDesktopViewModel.deleteMiniAppInfo$lambda$3(MiniAppExpDesktopViewModel.this, miniAppDesktopIntent, z16, jSONObject);
                }
            });
        } else {
            IExpDesktopRepository iExpDesktopRepository2 = this.mMiniAppRepository;
            MiniAppInfo miniAppInfo2 = miniAppDesktopIntent.getDesktopAppInfo().mMiniAppInfo;
            Intrinsics.checkNotNullExpressionValue(miniAppInfo2, "miniAppDesktopIntent.desktopAppInfo.mMiniAppInfo");
            iExpDesktopRepository2.deleteDesktopMiniApp(miniAppInfo2, miniAppDesktopIntent.getModuleType(), new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.mvi.c
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                    MiniAppExpDesktopViewModel.deleteMiniAppInfo$lambda$4(MiniAppExpDesktopViewModel.this, miniAppDesktopIntent, z16, jSONObject);
                }
            });
        }
        this.mIsNetworkDone = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteMiniAppInfo$lambda$3(MiniAppExpDesktopViewModel this$0, MiniAppExpDesktopIntent.DeleteDesktopMiniApp miniAppDesktopIntent, boolean z16, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(miniAppDesktopIntent, "$miniAppDesktopIntent");
        this$0.deleteItemResponse(miniAppDesktopIntent, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteMiniAppInfo$lambda$4(MiniAppExpDesktopViewModel this$0, MiniAppExpDesktopIntent.DeleteDesktopMiniApp miniAppDesktopIntent, boolean z16, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(miniAppDesktopIntent, "$miniAppDesktopIntent");
        this$0.deleteItemResponse(miniAppDesktopIntent, z16);
    }

    private final int getDeleteItemIndex(int moduleType, DesktopAppInfo deleteMiniAppInfo) {
        DesktopItemInfo desktopItemInfo = this.mPersonalModuleMap.get(Integer.valueOf(moduleType));
        Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
        int i3 = 0;
        for (Object obj : ((ExpDesktopGroupAppInfo) desktopItemInfo).getGroupAppInfo()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (deleteMiniAppInfo.mMiniAppInfo.appId.equals(((DesktopAppInfo) obj).mMiniAppInfo.appId)) {
                return i3;
            }
            i3 = i16;
        }
        return -1;
    }

    private final void getMiniAppDesktopLocalInfo() {
        if (this.mIsInitLocalData) {
            QLog.d(getTAG(), 1, "getMiniAppDesktopLocalInfo data is already init!");
        } else {
            this.mMiniAppRepository.getMiniAppDesktopLocalCacheInfo(new MiniAppExpDesktopLocalDataHelper.MiniAppLocalDataCallback() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopViewModel$getMiniAppDesktopLocalInfo$1
                @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.MiniAppExpDesktopLocalDataHelper.MiniAppLocalDataCallback
                public void getLocalDataFailed(String errorMsg) {
                    QLog.e(MiniAppExpDesktopViewModel.this.getTAG(), 1, "getLocalDataFailed errorMsg:" + errorMsg);
                }

                @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.MiniAppExpDesktopLocalDataHelper.MiniAppLocalDataCallback
                public void getLocalDataSuccess(Map<Integer, DesktopItemInfo> personalModuleMap, List<ExpDesktopGroupAppInfo> recommendModules, List<ExpDesktopRankTabAppInfo> rankModules) {
                    Map map;
                    List list;
                    List list2;
                    Intrinsics.checkNotNullParameter(personalModuleMap, "personalModuleMap");
                    Intrinsics.checkNotNullParameter(recommendModules, "recommendModules");
                    Intrinsics.checkNotNullParameter(rankModules, "rankModules");
                    MiniAppExpDesktopViewModel.this.mPersonalModuleMap = personalModuleMap;
                    MiniAppExpDesktopViewModel.this.mRecommendModules = recommendModules;
                    MiniAppExpDesktopViewModel.this.mRankModules = rankModules;
                    MutableLiveData<MiniAppExpDesktopUIState> mUiState = MiniAppExpDesktopViewModel.this.getMUiState();
                    map = MiniAppExpDesktopViewModel.this.mPersonalModuleMap;
                    list = MiniAppExpDesktopViewModel.this.mRecommendModules;
                    list2 = MiniAppExpDesktopViewModel.this.mRankModules;
                    mUiState.postValue(new MiniAppExpDesktopUIState.UpdateDesktopAllMiniAppInfo(map, list, list2));
                    MiniAppExpDesktopViewModel.this.mIsInitLocalData = true;
                    QLog.d(MiniAppExpDesktopViewModel.this.getTAG(), 1, "getLocalDataSuccess!");
                }
            });
        }
    }

    private final void getMiniAppDesktopNetworkInfo(boolean force, GetAppListV2Scene scene) {
        if (MiniAppUtils.isTeenagerMode()) {
            clearDesktopAllMiniInfo();
            QLog.e(getTAG(), 1, "getMiniAppDesktopNetworkInfo is teenagerMode!");
        } else {
            this.mMiniAppRepository.getDesktopMiniAppRemoteInfo(force, this.mIsInitLocalData, scene, new DesktopExpMiniAppReqListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopViewModel$getMiniAppDesktopNetworkInfo$1
                @Override // com.tencent.mobileqq.mini.entry.expDesktop.DesktopExpMiniAppReqListener
                public void getMiniAppInfoSuccess(Map<Integer, DesktopItemInfo> personalModuleMap, List<ExpDesktopGroupAppInfo> recommendModules, List<ExpDesktopRankTabAppInfo> rankModules) {
                    Map map;
                    List list;
                    List list2;
                    IExpDesktopRepository iExpDesktopRepository;
                    Map<Integer, DesktopItemInfo> map2;
                    List<ExpDesktopGroupAppInfo> list3;
                    List<ExpDesktopRankTabAppInfo> list4;
                    IExpDesktopRepository iExpDesktopRepository2;
                    Map<Integer, DesktopItemInfo> map3;
                    List<ExpDesktopGroupAppInfo> list5;
                    List<ExpDesktopRankTabAppInfo> list6;
                    Intrinsics.checkNotNullParameter(personalModuleMap, "personalModuleMap");
                    Intrinsics.checkNotNullParameter(recommendModules, "recommendModules");
                    Intrinsics.checkNotNullParameter(rankModules, "rankModules");
                    MiniAppExpDesktopViewModel.this.mPersonalModuleMap = personalModuleMap;
                    MiniAppExpDesktopViewModel.this.mRecommendModules = recommendModules;
                    MiniAppExpDesktopViewModel.this.mRankModules = rankModules;
                    MutableLiveData<MiniAppExpDesktopUIState> mUiState = MiniAppExpDesktopViewModel.this.getMUiState();
                    map = MiniAppExpDesktopViewModel.this.mPersonalModuleMap;
                    list = MiniAppExpDesktopViewModel.this.mRecommendModules;
                    list2 = MiniAppExpDesktopViewModel.this.mRankModules;
                    mUiState.postValue(new MiniAppExpDesktopUIState.UpdateDesktopAllMiniAppInfo(map, list, list2));
                    iExpDesktopRepository = MiniAppExpDesktopViewModel.this.mMiniAppRepository;
                    map2 = MiniAppExpDesktopViewModel.this.mPersonalModuleMap;
                    list3 = MiniAppExpDesktopViewModel.this.mRecommendModules;
                    list4 = MiniAppExpDesktopViewModel.this.mRankModules;
                    iExpDesktopRepository.updateMiniAppPositionInMmkv(map2, list3, list4);
                    iExpDesktopRepository2 = MiniAppExpDesktopViewModel.this.mMiniAppRepository;
                    map3 = MiniAppExpDesktopViewModel.this.mPersonalModuleMap;
                    list5 = MiniAppExpDesktopViewModel.this.mRecommendModules;
                    list6 = MiniAppExpDesktopViewModel.this.mRankModules;
                    iExpDesktopRepository2.updateMiniAppDbInfoWithBatch(map3, list5, list6);
                    QLog.i(MiniAppExpDesktopViewModel.this.getTAG(), 1, "getMiniAppInfoSuccess!");
                }

                @Override // com.tencent.mobileqq.mini.entry.expDesktop.DesktopExpMiniAppReqListener
                public void getMiniAppInfoFailed(String errorMsg, Long errorCode, boolean isShowErrorToast) {
                    if ((errorCode == null || errorCode.longValue() != 1000) && isShowErrorToast) {
                        MiniAppToastUtil.show(BaseApplication.getContext(), 1, R.string.kmg, 0);
                    }
                    QLog.e(MiniAppExpDesktopViewModel.this.getTAG(), 1, "getMiniAppInfoFailed errorMsg:" + errorMsg + "  errorCode:" + errorCode);
                }
            });
        }
    }

    private final void getModuleMoreMiniAppInfo(final int moduleType) {
        QLog.i(getTAG(), 1, "getModuleMoreMiniAppInfo moduleType:" + moduleType);
        this.mMiniAppRepository.getDesktopMiniAppMoreModuleRemoteInfo(moduleType, new DesktopExpMoreMiniAppReqListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopViewModel$getModuleMoreMiniAppInfo$1
            @Override // com.tencent.mobileqq.mini.entry.expDesktop.DesktopExpMoreMiniAppReqListener
            public void getMiniAppInfoFailed(String errorMsg, Long errorCode) {
                QLog.e(MiniAppExpDesktopViewModel.this.getTAG(), 1, "getModuleMoreMiniAppInfo errorMsg:" + errorMsg + "  errorCode:" + errorCode);
                MiniAppToastUtil.show(BaseApplication.getContext(), 1, R.string.kmg, 0);
            }

            @Override // com.tencent.mobileqq.mini.entry.expDesktop.DesktopExpMoreMiniAppReqListener
            public void getMiniAppInfoSuccess(List<DesktopAppInfo> moreModuleAppList) {
                Map map;
                Intrinsics.checkNotNullParameter(moreModuleAppList, "moreModuleAppList");
                map = MiniAppExpDesktopViewModel.this.mPersonalModuleMap;
                Object obj = map.get(Integer.valueOf(moduleType));
                ExpDesktopGroupAppInfo expDesktopGroupAppInfo = obj instanceof ExpDesktopGroupAppInfo ? (ExpDesktopGroupAppInfo) obj : null;
                if (expDesktopGroupAppInfo != null) {
                    expDesktopGroupAppInfo.setGroupAppInfo(bg.f302144a.n(MiniAppListDiffUtils.INSTANCE.getDiffListInfoFromLocalToMoreList(expDesktopGroupAppInfo.getGroupAppInfo(), moreModuleAppList)));
                }
                MiniAppExpDesktopViewModel.this.getMUiState().postValue(new MiniAppExpDesktopUIState.UpdateDesktopMoreMiniAppInfo(moduleType, moreModuleAppList));
            }
        });
    }

    private final void getModuleRankMiniAppInfo(final int moduleType) {
        QLog.i(getTAG(), 1, "queryRankMiniAppInfo start moduleType:" + moduleType);
        this.mMiniAppRepository.getDesktopMiniAppRankModuleRemoteInfo(moduleType, new DesktopExpRankMiniAppReqListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopViewModel$getModuleRankMiniAppInfo$1
            @Override // com.tencent.mobileqq.mini.entry.expDesktop.DesktopExpRankMiniAppReqListener
            public void getMiniAppInfoFailed(String errorMsg, Long errorCode) {
                QLog.e(MiniAppExpDesktopViewModel.this.getTAG(), 1, "queryRankMiniAppInfo errorMsg:" + errorMsg + "  errorCode:" + errorCode);
                MiniAppToastUtil.show(BaseApplication.getContext(), 1, R.string.kmg, 0);
            }

            @Override // com.tencent.mobileqq.mini.entry.expDesktop.DesktopExpRankMiniAppReqListener
            public void getMiniAppInfoSuccess(List<DesktopAppInfo> rankModuleList) {
                Intrinsics.checkNotNullParameter(rankModuleList, "rankModuleList");
                MiniAppExpDesktopViewModel.this.getMUiState().postValue(new MiniAppExpDesktopUIState.UpdateDesktopRankMiniAppInfo(moduleType, rankModuleList));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleIntent$lambda$2(MiniAppExpDesktopViewModel this$0, MiniAppExpDesktopIntent miniAppExpDesktopIntent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(miniAppExpDesktopIntent, "$miniAppExpDesktopIntent");
        this$0.insertMyMiniAppToTopById((MiniAppExpDesktopIntent.InsertMyMiniAppToTopById) miniAppExpDesktopIntent);
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
            getMUiState().postValue(new MiniAppExpDesktopUIState.UpdateDesktopPersonalMiniAppInfo(this.mPersonalModuleMap, 3));
            return;
        }
        DesktopItemInfo desktopItemInfo = this.mPersonalModuleMap.get(3);
        Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
        final ArrayList<DesktopAppInfo> groupAppInfo = ((ExpDesktopGroupAppInfo) desktopItemInfo).getGroupAppInfo();
        if (position >= groupAppInfo.size()) {
            groupAppInfo.add(new DesktopAppInfo(3, miniAppInfo.mMiniAppInfo));
        } else {
            groupAppInfo.add(position, new DesktopAppInfo(3, miniAppInfo.mMiniAppInfo));
        }
        getMUiState().postValue(new MiniAppExpDesktopUIState.UpdateDesktopPersonalMiniAppInfo(this.mPersonalModuleMap, 3));
        IExpDesktopRepository iExpDesktopRepository = this.mMiniAppRepository;
        MiniAppInfo miniAppInfo2 = miniAppInfo.mMiniAppInfo;
        Intrinsics.checkNotNullExpressionValue(miniAppInfo2, "miniAppInfo.mMiniAppInfo");
        iExpDesktopRepository.operateMiniAppToMyMiniApp(miniAppInfo2, 1, -1, position, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.mvi.f
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                MiniAppExpDesktopViewModel.insertMiniAppInfo$lambda$13(MiniAppExpDesktopViewModel.this, miniAppInfo, groupAppInfo, position, z16, jSONObject);
            }
        });
        this.mIsNetworkDone = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void insertMiniAppInfo$lambda$13(MiniAppExpDesktopViewModel this$0, DesktopAppInfo miniAppInfo, ArrayList myMiniAppInfo, int i3, boolean z16, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(miniAppInfo, "$miniAppInfo");
        Intrinsics.checkNotNullParameter(myMiniAppInfo, "$myMiniAppInfo");
        if (z16) {
            this$0.mMiniAppRepository.insertMiniAppDbInfo(miniAppInfo);
            IExpDesktopLocalMmkvRepository.DefaultImpls.updateMiniAppPositionInMmkv$default(this$0.mMiniAppRepository, this$0.mPersonalModuleMap, null, null, 6, null);
            MiniAppToastUtil.show(BaseApplication.getContext(), 2, R.string.f213375q1, 0);
        } else {
            myMiniAppInfo.remove(i3);
            this$0.getMUiState().postValue(new MiniAppExpDesktopUIState.UpdateDesktopPersonalMiniAppInfo(this$0.mPersonalModuleMap, 3));
            MiniAppToastUtil.show(BaseApplication.getContext(), 1, R.string.f213385q2, 0);
        }
        this$0.mIsNetworkDone = true;
        QLog.d(this$0.getTAG(), 1, "insertMiniAppToMyMiniApp isSuc:" + z16 + " ret:" + jSONObject + " name" + miniAppInfo.mMiniAppInfo.name);
    }

    private final void insertMyMiniAppToTopById(MiniAppExpDesktopIntent.InsertMyMiniAppToTopById miniAppDesktopIntent) {
        DesktopAppInfo desktopAppInfo;
        if (isOperateToMuch()) {
            QLog.i(getTAG(), 1, "insertMiniAppInfo isOperateToMuch!");
            return;
        }
        if (this.mPersonalModuleMap.get(1) != null) {
            DesktopItemInfo desktopItemInfo = this.mPersonalModuleMap.get(1);
            Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
            desktopAppInfo = null;
            for (DesktopAppInfo desktopAppInfo2 : ((ExpDesktopGroupAppInfo) desktopItemInfo).getGroupAppInfo()) {
                if (desktopAppInfo2.mMiniAppInfo.appId.equals(miniAppDesktopIntent.getMiniAppId())) {
                    desktopAppInfo = desktopAppInfo2;
                }
            }
        } else {
            QLog.e(getTAG(), 1, "insertMyMiniAppToTopById error, mPersonalModuleMap[INTERFACE.Module_RecentApp] == null!!", new Throwable("Module_RecentApp"));
            desktopAppInfo = null;
        }
        if (desktopAppInfo != null && this.mPersonalModuleMap.get(3) != null) {
            DesktopItemInfo desktopItemInfo2 = this.mPersonalModuleMap.get(3);
            Intrinsics.checkNotNull(desktopItemInfo2, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
            ArrayList<DesktopAppInfo> groupAppInfo = ((ExpDesktopGroupAppInfo) desktopItemInfo2).getGroupAppInfo();
            desktopAppInfo.mMiniAppInfo.updateTimeStamp();
            String str = desktopAppInfo.mMiniAppInfo.appId;
            Intrinsics.checkNotNullExpressionValue(str, "insertDesktopAppInfo!!.mMiniAppInfo.appId");
            removeMiniAppItem(groupAppInfo, str);
            groupAppInfo.add(0, new DesktopAppInfo(3, desktopAppInfo.mMiniAppInfo));
            this.mMiniAppRepository.insertMiniAppDbInfo(desktopAppInfo);
            IExpDesktopLocalMmkvRepository.DefaultImpls.updateMiniAppPositionInMmkv$default(this.mMiniAppRepository, this.mPersonalModuleMap, null, null, 6, null);
            getMUiState().postValue(new MiniAppExpDesktopUIState.UpdateDesktopPersonalMiniAppInfo(this.mPersonalModuleMap, 3));
            miniAppDesktopIntent.getEipcModule().callbackResult(miniAppDesktopIntent.getCallbackId(), EIPCResult.createResult(0, null));
            return;
        }
        if (this.mPersonalModuleMap.get(3) == null) {
            QLog.e(getTAG(), 1, "insertMyMiniAppToTopById error, mPersonalModuleMap[INTERFACE.Module_MyApp] == null!!", new Throwable("Module_MyApp"));
        }
        miniAppDesktopIntent.getEipcModule().callbackResult(miniAppDesktopIntent.getCallbackId(), EIPCResult.createResult(-100, null));
    }

    private final boolean isNeedResetMyMiniAppInfoForInsertMiniApp(String insertMiniAppId, int newPosition) {
        DesktopItemInfo desktopItemInfo = this.mPersonalModuleMap.get(3);
        Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
        int i3 = 0;
        for (Object obj : ((ExpDesktopGroupAppInfo) desktopItemInfo).getGroupAppInfo()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (((DesktopAppInfo) obj).mMiniAppInfo.appId.equals(insertMiniAppId) && newPosition == i3) {
                return false;
            }
            i3 = i16;
        }
        DesktopItemInfo desktopItemInfo2 = this.mPersonalModuleMap.get(3);
        Intrinsics.checkNotNull(desktopItemInfo2, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
        Iterator<DesktopAppInfo> it = ((ExpDesktopGroupAppInfo) desktopItemInfo2).getGroupAppInfo().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "mPersonalModuleMap[INTER\u2026GroupAppInfo().iterator()");
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DesktopAppInfo next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            if (next.mMiniAppInfo.appId.equals(insertMiniAppId)) {
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
        DesktopAppInfo next;
        DesktopItemInfo desktopItemInfo = this.mPersonalModuleMap.get(1);
        Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
        ArrayList<DesktopAppInfo> groupAppInfo = ((ExpDesktopGroupAppInfo) desktopItemInfo).getGroupAppInfo();
        if (groupAppInfo.isEmpty()) {
            QLog.e(getTAG(), 1, "moveRecentAppExistMiniApp recentAppInfos is empty!");
            groupAppInfo.add(new DesktopAppInfo(1, miniAppInfo));
            return;
        }
        Iterator<DesktopAppInfo> it = groupAppInfo.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "recentAppInfos.iterator()");
        while (it.hasNext()) {
            try {
                next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            } catch (NullPointerException e16) {
                QLog.e(getTAG(), 1, "moveRecentAppExistMiniApp error!", e16);
            } catch (ConcurrentModificationException e17) {
                QLog.e(getTAG(), 1, "moveRecentAppExistMiniApp error!", e17);
            }
            if (next.mMiniAppInfo.appId.equals(miniAppInfo.appId)) {
                it.remove();
                break;
            }
            continue;
        }
        if (groupAppInfo.isEmpty()) {
            groupAppInfo.add(new DesktopAppInfo(1, miniAppInfo));
        } else {
            groupAppInfo.add(0, new DesktopAppInfo(1, miniAppInfo));
        }
    }

    private final void myMiniAppDraggingTempSwitchPosition(MiniAppExpDesktopIntent.MyMiniAppDraggingTempSwitchPosition miniAppExpDesktopIntent) {
        List mutableList;
        DesktopItemInfo desktopItemInfo = this.mPersonalModuleMap.get(3);
        Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
        ExpDesktopGroupAppInfo expDesktopGroupAppInfo = (ExpDesktopGroupAppInfo) desktopItemInfo;
        expDesktopGroupAppInfo.startTempSwitch(miniAppExpDesktopIntent.getFromPosition());
        List<DesktopAppInfo> originInfoWhenSwitch = expDesktopGroupAppInfo.getOriginInfoWhenSwitch();
        if (originInfoWhenSwitch.isEmpty()) {
            QLog.i(getTAG(), 1, "my app is empty!");
            return;
        }
        if (miniAppExpDesktopIntent.getFromPosition() >= 0 && miniAppExpDesktopIntent.getFromPosition() < originInfoWhenSwitch.size() && miniAppExpDesktopIntent.getToPosition() >= 0 && miniAppExpDesktopIntent.getToPosition() < originInfoWhenSwitch.size()) {
            QLog.i(getTAG(), 1, "myMiniAppDraggingTempSwitchPosition fromPosition:" + miniAppExpDesktopIntent.getFromPosition() + " toPosition:" + miniAppExpDesktopIntent.getToPosition());
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) originInfoWhenSwitch);
            mutableList.add(miniAppExpDesktopIntent.getToPosition(), mutableList.remove(miniAppExpDesktopIntent.getFromPosition()));
            getMUiState().postValue(new MiniAppExpDesktopUIState.MyMiniAppDraggingTempSwitchPosition(mutableList));
            return;
        }
        QLog.i(getTAG(), 1, "wrong fromPosition:" + miniAppExpDesktopIntent.getFromPosition() + ", toPosition:" + miniAppExpDesktopIntent.getToPosition() + "!");
    }

    private final void myMiniAppSwitchPosition(final MiniAppExpDesktopIntent.MyMiniAppSwitchPosition miniAppDesktopIntent) {
        if (isOperateToMuch()) {
            QLog.i(getTAG(), 1, "myMiniAppSwitchPosition isOperateToMuch!");
            return;
        }
        DesktopItemInfo desktopItemInfo = this.mPersonalModuleMap.get(3);
        Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
        ExpDesktopGroupAppInfo expDesktopGroupAppInfo = (ExpDesktopGroupAppInfo) desktopItemInfo;
        expDesktopGroupAppInfo.startTempSwitch(miniAppDesktopIntent.getOldIndex());
        final ArrayList<DesktopAppInfo> groupAppInfo = expDesktopGroupAppInfo.getGroupAppInfo();
        groupAppInfo.clear();
        groupAppInfo.addAll(expDesktopGroupAppInfo.getOriginInfoWhenSwitch());
        expDesktopGroupAppInfo.endTempSwitch();
        if (groupAppInfo.isEmpty()) {
            QLog.i(getTAG(), 1, "myMiniAppSwitchPosition MyApp is null or empty!");
            return;
        }
        if (miniAppDesktopIntent.getNewIndex() < groupAppInfo.size() && miniAppDesktopIntent.getOldIndex() < groupAppInfo.size()) {
            DesktopAppInfo desktopAppInfo = groupAppInfo.get(miniAppDesktopIntent.getOldIndex());
            Intrinsics.checkNotNull(desktopAppInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo");
            final DesktopAppInfo desktopAppInfo2 = desktopAppInfo;
            groupAppInfo.add(miniAppDesktopIntent.getNewIndex(), groupAppInfo.remove(miniAppDesktopIntent.getOldIndex()));
            getMUiState().postValue(new MiniAppExpDesktopUIState.UpdateDesktopPersonalMiniAppInfo(this.mPersonalModuleMap, 3));
            IExpDesktopRepository iExpDesktopRepository = this.mMiniAppRepository;
            MiniAppInfo miniAppInfo = desktopAppInfo2.mMiniAppInfo;
            Intrinsics.checkNotNullExpressionValue(miniAppInfo, "draggingMiniApp.mMiniAppInfo");
            iExpDesktopRepository.operateMiniAppToMyMiniApp(miniAppInfo, 1, miniAppDesktopIntent.getOldIndex(), miniAppDesktopIntent.getNewIndex(), new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.mvi.e
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                    MiniAppExpDesktopViewModel.myMiniAppSwitchPosition$lambda$12(MiniAppExpDesktopViewModel.this, desktopAppInfo2, miniAppDesktopIntent, groupAppInfo, z16, jSONObject);
                }
            });
            this.mIsNetworkDone = false;
            return;
        }
        QLog.i(getTAG(), 1, "myMiniAppSwitchPosition newIndex and oldIndex is invalid!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void myMiniAppSwitchPosition$lambda$12(MiniAppExpDesktopViewModel this$0, DesktopAppInfo draggingMiniApp, MiniAppExpDesktopIntent.MyMiniAppSwitchPosition miniAppDesktopIntent, ArrayList myMiniAppInfo, boolean z16, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(draggingMiniApp, "$draggingMiniApp");
        Intrinsics.checkNotNullParameter(miniAppDesktopIntent, "$miniAppDesktopIntent");
        Intrinsics.checkNotNullParameter(myMiniAppInfo, "$myMiniAppInfo");
        if (z16) {
            this$0.mMiniAppRepository.insertMiniAppDbInfo(draggingMiniApp);
            IExpDesktopLocalMmkvRepository.DefaultImpls.updateMiniAppPositionInMmkv$default(this$0.mMiniAppRepository, this$0.mPersonalModuleMap, null, null, 6, null);
            QLog.i(this$0.getTAG(), 1, "myMiniAppSwitchPosition oldIndex:" + miniAppDesktopIntent.getOldIndex() + " newIndex:" + miniAppDesktopIntent.getNewIndex() + "!");
        } else {
            this$0.swap(myMiniAppInfo, miniAppDesktopIntent.getOldIndex(), miniAppDesktopIntent.getNewIndex());
            this$0.getMUiState().postValue(new MiniAppExpDesktopUIState.UpdateDesktopPersonalMiniAppInfo(this$0.mPersonalModuleMap, 3));
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
                MiniAppInfo personalModuleMiniAppInfoById = getPersonalModuleMiniAppInfoById(3, string, i3);
                QLog.d(getTAG(), 2, "miniappInfo : " + personalModuleMiniAppInfoById);
                Bundle bundle = new Bundle();
                if (personalModuleMiniAppInfoById != null) {
                    bundle.putParcelable("miniappinfo", personalModuleMiniAppInfoById);
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

    private final void removeMyMiniAppTopById(MiniAppExpDesktopIntent.RemoveMyMiniAppTopById miniAppDesktopIntent) {
        if (isOperateToMuch()) {
            QLog.i(getTAG(), 1, "removeMyMiniAppTopById isOperateToMuch!");
            return;
        }
        DesktopItemInfo desktopItemInfo = this.mPersonalModuleMap.get(3);
        Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
        DesktopAppInfo desktopAppInfo = null;
        for (DesktopAppInfo desktopAppInfo2 : ((ExpDesktopGroupAppInfo) desktopItemInfo).getGroupAppInfo()) {
            if (desktopAppInfo2.mMiniAppInfo.appId.equals(miniAppDesktopIntent.getMiniAppId())) {
                desktopAppInfo = desktopAppInfo2;
            }
        }
        if (desktopAppInfo != null) {
            String str = desktopAppInfo.mMiniAppInfo.appId;
            Intrinsics.checkNotNullExpressionValue(str, "removeDesktopAppInfo!!.mMiniAppInfo.appId");
            deleteDesktopMiniAppInfo(3, str);
            this.mMiniAppRepository.insertMiniAppDbInfo(desktopAppInfo);
            IExpDesktopLocalMmkvRepository.DefaultImpls.updateMiniAppPositionInMmkv$default(this.mMiniAppRepository, this.mPersonalModuleMap, null, null, 6, null);
            getMUiState().postValue(new MiniAppExpDesktopUIState.UpdateDesktopPersonalMiniAppInfo(this.mPersonalModuleMap, 3));
            miniAppDesktopIntent.getEipcModule().callbackResult(miniAppDesktopIntent.getCallbackId(), EIPCResult.createResult(0, null));
            return;
        }
        miniAppDesktopIntent.getEipcModule().callbackResult(miniAppDesktopIntent.getCallbackId(), EIPCResult.createResult(-100, null));
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
        MiniAppUtils.setRecentStartMiniAppListener(new MiniAppExpDesktopViewModel$setRecentStartMiniAppListener$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateRecentStartMiniAppInfo(MiniAppInfo miniAppInfo) {
        if (!MiniAppUtils.isTeenagerMode() && !this.mPersonalModuleMap.isEmpty() && this.mPersonalModuleMap.get(1) != null) {
            moveRecentAppExistMiniApp(miniAppInfo);
            IExpDesktopLocalMmkvRepository.DefaultImpls.updateMiniAppPositionInMmkv$default(this.mMiniAppRepository, this.mPersonalModuleMap, null, null, 6, null);
            this.mMiniAppRepository.insertMiniAppDbInfo(new DesktopAppInfo(1, miniAppInfo));
            getMUiState().postValue(new MiniAppExpDesktopUIState.UpdateDesktopPersonalMiniAppInfo(this.mPersonalModuleMap, 1));
            return;
        }
        QLog.d(getTAG(), 1, "updateRecentStartMiniAppInfo mMiniAppInfoMap is empty or recentApp is null!");
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "MiniAppExpDeskTopViewModel";
    }

    public final MiniAppInfo getPersonalModuleMiniAppInfoById(int dataModule, String appId, int verType) {
        if (this.mPersonalModuleMap.get(Integer.valueOf(dataModule)) == null || !(this.mPersonalModuleMap.get(Integer.valueOf(dataModule)) instanceof ExpDesktopGroupAppInfo)) {
            QLog.i(getTAG(), 1, "getPersonalModuleMiniAppInfoById get mini app info false!");
            return null;
        }
        if (dataModule == 1 || dataModule == 3) {
            DesktopItemInfo desktopItemInfo = this.mPersonalModuleMap.get(Integer.valueOf(dataModule));
            Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
            for (DesktopAppInfo desktopAppInfo : ((ExpDesktopGroupAppInfo) desktopItemInfo).getGroupAppInfo()) {
                if (desktopAppInfo.mMiniAppInfo.appId.equals(appId)) {
                    MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
                    if (miniAppInfo.verType == verType) {
                        return miniAppInfo;
                    }
                }
            }
        }
        return null;
    }

    public final LiveData<Boolean> isDesktopOpen() {
        return this.isDesktopOpen;
    }

    public final LiveData<GetAppListV2Scene> isPreloadInfo() {
        return this.isPreloadInfo;
    }

    public final void setDesktopOpen(boolean isDesktopOpen) {
        if (Intrinsics.areEqual(Boolean.valueOf(isDesktopOpen), this.mIsDesktopOpen.getValue())) {
            return;
        }
        this.mIsDesktopOpen.setValue(Boolean.valueOf(isDesktopOpen));
    }

    public final void setPreloadInfo(GetAppListV2Scene preloadInfoScene) {
        Intrinsics.checkNotNullParameter(preloadInfoScene, "preloadInfoScene");
        this.mIsPreloadInfo.setValue(preloadInfoScene);
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

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopBaseViewModel
    public MiniAppExpDesktopIntent getMNoneValueIntent() {
        return this.mNoneValueIntent;
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopBaseViewModel
    public void handleIntent(final MiniAppExpDesktopIntent miniAppExpDesktopIntent) {
        Intrinsics.checkNotNullParameter(miniAppExpDesktopIntent, "miniAppExpDesktopIntent");
        QLog.d(getTAG(), 1, "handleIntent:" + miniAppExpDesktopIntent);
        if (miniAppExpDesktopIntent instanceof MiniAppExpDesktopIntent.GetMiniAppDesktopLocalData) {
            getMiniAppDesktopLocalInfo();
            return;
        }
        if (miniAppExpDesktopIntent instanceof MiniAppExpDesktopIntent.GetMiniAppDesktopNetworkData) {
            MiniAppExpDesktopIntent.GetMiniAppDesktopNetworkData getMiniAppDesktopNetworkData = (MiniAppExpDesktopIntent.GetMiniAppDesktopNetworkData) miniAppExpDesktopIntent;
            getMiniAppDesktopNetworkInfo(getMiniAppDesktopNetworkData.getForce(), getMiniAppDesktopNetworkData.getScene());
            return;
        }
        if (miniAppExpDesktopIntent instanceof MiniAppExpDesktopIntent.InsertMyMiniApp) {
            MiniAppExpDesktopIntent.InsertMyMiniApp insertMyMiniApp = (MiniAppExpDesktopIntent.InsertMyMiniApp) miniAppExpDesktopIntent;
            insertMiniAppInfo(insertMyMiniApp.getDesktopAppInfo(), insertMyMiniApp.getPosition());
            return;
        }
        if (miniAppExpDesktopIntent instanceof MiniAppExpDesktopIntent.DeleteDesktopMiniApp) {
            deleteMiniAppInfo((MiniAppExpDesktopIntent.DeleteDesktopMiniApp) miniAppExpDesktopIntent);
            return;
        }
        if (miniAppExpDesktopIntent instanceof MiniAppExpDesktopIntent.InsertMyMiniAppToTopById) {
            runningInMainThread(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.mvi.a
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppExpDesktopViewModel.handleIntent$lambda$2(MiniAppExpDesktopViewModel.this, miniAppExpDesktopIntent);
                }
            });
            return;
        }
        if (miniAppExpDesktopIntent instanceof MiniAppExpDesktopIntent.RemoveMyMiniAppTopById) {
            removeMyMiniAppTopById((MiniAppExpDesktopIntent.RemoveMyMiniAppTopById) miniAppExpDesktopIntent);
            return;
        }
        if (miniAppExpDesktopIntent instanceof MiniAppExpDesktopIntent.MyMiniAppDraggingTempSwitchPosition) {
            myMiniAppDraggingTempSwitchPosition((MiniAppExpDesktopIntent.MyMiniAppDraggingTempSwitchPosition) miniAppExpDesktopIntent);
            return;
        }
        if (miniAppExpDesktopIntent instanceof MiniAppExpDesktopIntent.MyMiniAppSwitchPosition) {
            myMiniAppSwitchPosition((MiniAppExpDesktopIntent.MyMiniAppSwitchPosition) miniAppExpDesktopIntent);
            return;
        }
        if (miniAppExpDesktopIntent instanceof MiniAppExpDesktopIntent.UpdateDesktopAllMiniAppInfo) {
            getMUiState().postValue(new MiniAppExpDesktopUIState.UpdateDesktopAllMiniAppInfo(this.mPersonalModuleMap, this.mRecommendModules, this.mRankModules));
            return;
        }
        if (miniAppExpDesktopIntent instanceof MiniAppExpDesktopIntent.GetModuleRankMiniAppInfo) {
            getModuleRankMiniAppInfo(((MiniAppExpDesktopIntent.GetModuleRankMiniAppInfo) miniAppExpDesktopIntent).getModuleType());
            return;
        }
        if (miniAppExpDesktopIntent instanceof MiniAppExpDesktopIntent.QueryMyMiniAppInfo) {
            MiniAppExpDesktopIntent.QueryMyMiniAppInfo queryMyMiniAppInfo = (MiniAppExpDesktopIntent.QueryMyMiniAppInfo) miniAppExpDesktopIntent;
            queryMyMiniAppInfo(queryMyMiniAppInfo.getParams(), queryMyMiniAppInfo.getEipcModule());
        } else if (miniAppExpDesktopIntent instanceof MiniAppExpDesktopIntent.CheckIsInMyAppList) {
            MiniAppExpDesktopIntent.CheckIsInMyAppList checkIsInMyAppList = (MiniAppExpDesktopIntent.CheckIsInMyAppList) miniAppExpDesktopIntent;
            checkIsInMyAppList(checkIsInMyAppList.getParams(), checkIsInMyAppList.getEipcModule());
        } else if (miniAppExpDesktopIntent instanceof MiniAppExpDesktopIntent.GetModuleMoreMiniAppInfo) {
            getModuleMoreMiniAppInfo(((MiniAppExpDesktopIntent.GetModuleMoreMiniAppInfo) miniAppExpDesktopIntent).getModuleType());
        }
    }

    public final void initLocalDataState() {
        this.mIsInitLocalData = false;
    }

    private final void removeMiniAppItem(ArrayList<DesktopAppInfo> miniAppList, String appId) {
        if (miniAppList == null || miniAppList.isEmpty()) {
            return;
        }
        Iterator<DesktopAppInfo> it = miniAppList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "miniAppList.iterator()");
        while (it.hasNext()) {
            DesktopAppInfo next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            if (next.mMiniAppInfo.appId.equals(appId)) {
                it.remove();
                return;
            }
        }
    }
}

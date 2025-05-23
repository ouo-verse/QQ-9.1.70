package com.tencent.mobileqq.mini.entry.newdesktop.repository;

import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entity.AppBubbleRecordEntity;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataMiniAppAdManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.DesktopMiniAppReqListener;
import com.tencent.mobileqq.mini.entry.newdesktop.bean.PositionItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.repository.MiniAppDesktopLocalDataHelper;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.xweb.FileReaderHelper;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J(\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020$H\u0016J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0016J\u0010\u0010(\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J(\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u000eH\u0016J\b\u0010/\u001a\u00020\nH\u0016J\u0018\u00100\u001a\u00020\n2\u0006\u0010+\u001a\u00020,2\u0006\u0010\r\u001a\u00020\u000eH\u0016J0\u00101\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J8\u00105\u001a\u00020\n2.\u00106\u001a*\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090807j\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020908`:H\u0016J8\u0010;\u001a\u00020\n2.\u00106\u001a*\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090807j\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020908`:H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/DesktopRepositoryImpl;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/IDesktopRepository;", "()V", "mDesktopLocalDbRepository", "Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/DesktopLocalDbRepository;", "mDesktopLocalSpRepository", "Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/DesktopLocalMmkvRepository;", "mDesktopRemoteRepository", "Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/DesktopRemoteRepository;", "deleteDesktopMiniApp", "", "miniAppInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "moduleType", "", "listener", "Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;", "deleteGdtMiniAppCacheInfo", "desktopAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "deleteMiniAppCacheInfo", "deleteMiniAppDbInfo", "deleteRecentPlayLoadMoreApp", "getDesktopGdtAppInfo", "miniAppAdCallback", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopDataMiniAppAdManager$MiniAppAdCallback;", "getDesktopMiniAppRemoteInfo", FileReaderHelper.OPEN_FILE_FROM_FORCE, "", "isUseCache", "scene", "Lcom/tencent/mobileqq/mini/entry/desktop/GetAppListV2Scene;", "miniAppReqListener", "Lcom/tencent/mobileqq/mini/entry/newdesktop/DesktopMiniAppReqListener;", "getMiniAppDesktopLocalCacheInfo", "localDataCallback", "Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/MiniAppDesktopLocalDataHelper$MiniAppLocalDataCallback;", "getMiniAppPositionInMmkv", "", "Lcom/tencent/mobileqq/mini/entry/newdesktop/bean/PositionItemInfo;", "insertMiniAppDbInfo", "miniAppBubbleEnsureBubbleRecord", "Lcom/tencent/mobileqq/mini/entity/AppBubbleRecordEntity;", "appId", "", "text", "clickCount", "miniAppBubblePreloadAddFromDB", "miniAppBubbleUpdateAppBubbleRecord", "operateMiniAppToMyMiniApp", MiniChatConstants.MINI_APP_TOP_TYPE, "oldPositionIndex", "newPositionIndex", "updateMiniAppDbInfoWithBatch", "miniAppUIDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "Lkotlin/collections/HashMap;", "updateMiniAppPositionInMmkv", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class DesktopRepositoryImpl implements IDesktopRepository {
    private DesktopRemoteRepository mDesktopRemoteRepository = new DesktopRemoteRepository();
    private DesktopLocalDbRepository mDesktopLocalDbRepository = new DesktopLocalDbRepository();
    private DesktopLocalMmkvRepository mDesktopLocalSpRepository = new DesktopLocalMmkvRepository();

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopRemoteRepository
    public void deleteDesktopMiniApp(MiniAppInfo miniAppInfo, int moduleType, MiniAppCmdInterface listener) {
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mDesktopRemoteRepository.deleteDesktopMiniApp(miniAppInfo, moduleType, listener);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalDbRepository
    public void deleteGdtMiniAppCacheInfo(DesktopAppInfo desktopAppInfo) {
        Intrinsics.checkNotNullParameter(desktopAppInfo, "desktopAppInfo");
        this.mDesktopLocalDbRepository.deleteGdtMiniAppCacheInfo(desktopAppInfo);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalDbRepository
    public void deleteMiniAppCacheInfo(MiniAppInfo miniAppInfo) {
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        this.mDesktopLocalDbRepository.deleteMiniAppCacheInfo(miniAppInfo);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalDbRepository
    public void deleteMiniAppDbInfo(MiniAppInfo miniAppInfo) {
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        this.mDesktopLocalDbRepository.deleteMiniAppDbInfo(miniAppInfo);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopRemoteRepository
    public void deleteRecentPlayLoadMoreApp() {
        this.mDesktopRemoteRepository.deleteRecentPlayLoadMoreApp();
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopRemoteRepository
    public void getDesktopGdtAppInfo(DesktopDataMiniAppAdManager.MiniAppAdCallback miniAppAdCallback) {
        Intrinsics.checkNotNullParameter(miniAppAdCallback, "miniAppAdCallback");
        this.mDesktopRemoteRepository.getDesktopGdtAppInfo(miniAppAdCallback);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopRemoteRepository
    public void getDesktopMiniAppRemoteInfo(boolean force, boolean isUseCache, GetAppListV2Scene scene, DesktopMiniAppReqListener miniAppReqListener) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(miniAppReqListener, "miniAppReqListener");
        this.mDesktopRemoteRepository.getDesktopMiniAppRemoteInfo(force, isUseCache, scene, miniAppReqListener);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalDbRepository
    public void getMiniAppDesktopLocalCacheInfo(MiniAppDesktopLocalDataHelper.MiniAppLocalDataCallback localDataCallback) {
        Intrinsics.checkNotNullParameter(localDataCallback, "localDataCallback");
        this.mDesktopLocalDbRepository.getMiniAppDesktopLocalCacheInfo(localDataCallback);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalMmkvRepository
    public List<PositionItemInfo> getMiniAppPositionInMmkv() {
        return this.mDesktopLocalSpRepository.getMiniAppPositionInMmkv();
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalDbRepository
    public void insertMiniAppDbInfo(DesktopAppInfo desktopAppInfo) {
        Intrinsics.checkNotNullParameter(desktopAppInfo, "desktopAppInfo");
        this.mDesktopLocalDbRepository.insertMiniAppDbInfo(desktopAppInfo);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalDbRepository
    public AppBubbleRecordEntity miniAppBubbleEnsureBubbleRecord(String appId, int moduleType, String text, int clickCount) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(text, "text");
        return this.mDesktopLocalDbRepository.miniAppBubbleEnsureBubbleRecord(appId, moduleType, text, clickCount);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalDbRepository
    public void miniAppBubblePreloadAddFromDB() {
        this.mDesktopLocalDbRepository.miniAppBubblePreloadAddFromDB();
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalDbRepository
    public void miniAppBubbleUpdateAppBubbleRecord(String appId, int moduleType) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.mDesktopLocalDbRepository.miniAppBubbleUpdateAppBubbleRecord(appId, moduleType);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopRemoteRepository
    public void operateMiniAppToMyMiniApp(MiniAppInfo miniAppInfo, int topType, int oldPositionIndex, int newPositionIndex, MiniAppCmdInterface listener) {
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mDesktopRemoteRepository.operateMiniAppToMyMiniApp(miniAppInfo, topType, oldPositionIndex, newPositionIndex, listener);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalDbRepository
    public void updateMiniAppDbInfoWithBatch(HashMap<Integer, List<DesktopItemInfo>> miniAppUIDataMap) {
        Intrinsics.checkNotNullParameter(miniAppUIDataMap, "miniAppUIDataMap");
        this.mDesktopLocalDbRepository.updateMiniAppDbInfoWithBatch(miniAppUIDataMap);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalMmkvRepository
    public void updateMiniAppPositionInMmkv(HashMap<Integer, List<DesktopItemInfo>> miniAppUIDataMap) {
        Intrinsics.checkNotNullParameter(miniAppUIDataMap, "miniAppUIDataMap");
        this.mDesktopLocalSpRepository.updateMiniAppPositionInMmkv(miniAppUIDataMap);
    }
}

package com.tencent.mobileqq.mini.entry.expDesktop.repository;

import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.DesktopExpMiniAppReqListener;
import com.tencent.mobileqq.mini.entry.expDesktop.DesktopExpMoreMiniAppReqListener;
import com.tencent.mobileqq.mini.entry.expDesktop.DesktopExpRankMiniAppReqListener;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopRankTabAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.repository.MiniAppExpDesktopLocalDataHelper;
import com.tencent.mobileqq.mini.entry.newdesktop.bean.PositionItemInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.xweb.FileReaderHelper;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0018H\u0016J(\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J\u0010\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\nH\u0016J0\u0010*\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J8\u0010.\u001a\u00020\n2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u000201002\f\u00102\u001a\b\u0012\u0004\u0012\u000204032\f\u00105\u001a\b\u0012\u0004\u0012\u00020603H\u0016J8\u00107\u001a\u00020\n2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u000201002\f\u00102\u001a\b\u0012\u0004\u0012\u000204032\f\u00105\u001a\b\u0012\u0004\u0012\u00020603H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/ExpDesktopRepositoryImpl;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/IExpDesktopRepository;", "()V", "mDesktopLocalDbRepository", "Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/ExpDesktopLocalDbRepository;", "mDesktopLocalSpRepository", "Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/ExpDesktopLocalMmkvRepository;", "mDesktopRemoteRepository", "Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/ExpDesktopRemoteRepository;", "deleteDesktopMiniApp", "", "miniAppInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "moduleType", "", "listener", "Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;", "deleteMiniAppCacheInfo", "deleteMiniAppDbInfo", "deleteRecentPlayLoadMoreApp", "getDesktopMiniAppMoreModuleRemoteInfo", "miniAppReqListener", "Lcom/tencent/mobileqq/mini/entry/expDesktop/DesktopExpMoreMiniAppReqListener;", "getDesktopMiniAppRankModuleRemoteInfo", "Lcom/tencent/mobileqq/mini/entry/expDesktop/DesktopExpRankMiniAppReqListener;", "getDesktopMiniAppRemoteInfo", FileReaderHelper.OPEN_FILE_FROM_FORCE, "", "isUseCache", "scene", "Lcom/tencent/mobileqq/mini/entry/desktop/GetAppListV2Scene;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/DesktopExpMiniAppReqListener;", "getMiniAppDesktopLocalCacheInfo", "localDataCallback", "Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/MiniAppExpDesktopLocalDataHelper$MiniAppLocalDataCallback;", "getMiniAppPositionInMmkv", "", "Lcom/tencent/mobileqq/mini/entry/newdesktop/bean/PositionItemInfo;", "insertMiniAppDbInfo", "desktopAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "miniAppBubblePreloadAddFromDB", "operateMiniAppToMyMiniApp", MiniChatConstants.MINI_APP_TOP_TYPE, "oldPositionIndex", "newPositionIndex", "updateMiniAppDbInfoWithBatch", "personalModuleMap", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "recommendModule", "", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopGroupAppInfo;", "rankModules", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopRankTabAppInfo;", "updateMiniAppPositionInMmkv", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ExpDesktopRepositoryImpl implements IExpDesktopRepository {
    private ExpDesktopRemoteRepository mDesktopRemoteRepository = new ExpDesktopRemoteRepository();
    private ExpDesktopLocalDbRepository mDesktopLocalDbRepository = new ExpDesktopLocalDbRepository();
    private ExpDesktopLocalMmkvRepository mDesktopLocalSpRepository = new ExpDesktopLocalMmkvRepository();

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopRemoteRepository
    public void deleteDesktopMiniApp(MiniAppInfo miniAppInfo, int moduleType, MiniAppCmdInterface listener) {
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mDesktopRemoteRepository.deleteDesktopMiniApp(miniAppInfo, moduleType, listener);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopLocalDbRepository
    public void deleteMiniAppCacheInfo(MiniAppInfo miniAppInfo) {
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        this.mDesktopLocalDbRepository.deleteMiniAppCacheInfo(miniAppInfo);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopLocalDbRepository
    public void deleteMiniAppDbInfo(MiniAppInfo miniAppInfo) {
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        this.mDesktopLocalDbRepository.deleteMiniAppDbInfo(miniAppInfo);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopRemoteRepository
    public void deleteRecentPlayLoadMoreApp() {
        this.mDesktopRemoteRepository.deleteRecentPlayLoadMoreApp();
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopRemoteRepository
    public void getDesktopMiniAppMoreModuleRemoteInfo(int moduleType, DesktopExpMoreMiniAppReqListener miniAppReqListener) {
        Intrinsics.checkNotNullParameter(miniAppReqListener, "miniAppReqListener");
        this.mDesktopRemoteRepository.getDesktopMiniAppMoreModuleRemoteInfo(moduleType, miniAppReqListener);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopRemoteRepository
    public void getDesktopMiniAppRankModuleRemoteInfo(int moduleType, DesktopExpRankMiniAppReqListener miniAppReqListener) {
        Intrinsics.checkNotNullParameter(miniAppReqListener, "miniAppReqListener");
        this.mDesktopRemoteRepository.getDesktopMiniAppRankModuleRemoteInfo(moduleType, miniAppReqListener);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopRemoteRepository
    public void getDesktopMiniAppRemoteInfo(boolean force, boolean isUseCache, GetAppListV2Scene scene, DesktopExpMiniAppReqListener miniAppReqListener) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(miniAppReqListener, "miniAppReqListener");
        this.mDesktopRemoteRepository.getDesktopMiniAppRemoteInfo(force, isUseCache, scene, miniAppReqListener);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopLocalDbRepository
    public void getMiniAppDesktopLocalCacheInfo(MiniAppExpDesktopLocalDataHelper.MiniAppLocalDataCallback localDataCallback) {
        Intrinsics.checkNotNullParameter(localDataCallback, "localDataCallback");
        this.mDesktopLocalDbRepository.getMiniAppDesktopLocalCacheInfo(localDataCallback);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopLocalMmkvRepository
    public List<PositionItemInfo> getMiniAppPositionInMmkv() {
        return this.mDesktopLocalSpRepository.getMiniAppPositionInMmkv();
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopLocalDbRepository
    public void insertMiniAppDbInfo(DesktopAppInfo desktopAppInfo) {
        Intrinsics.checkNotNullParameter(desktopAppInfo, "desktopAppInfo");
        this.mDesktopLocalDbRepository.insertMiniAppDbInfo(desktopAppInfo);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopLocalDbRepository
    public void miniAppBubblePreloadAddFromDB() {
        this.mDesktopLocalDbRepository.miniAppBubblePreloadAddFromDB();
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopRemoteRepository
    public void operateMiniAppToMyMiniApp(MiniAppInfo miniAppInfo, int topType, int oldPositionIndex, int newPositionIndex, MiniAppCmdInterface listener) {
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mDesktopRemoteRepository.operateMiniAppToMyMiniApp(miniAppInfo, topType, oldPositionIndex, newPositionIndex, listener);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopLocalDbRepository
    public void updateMiniAppDbInfoWithBatch(Map<Integer, DesktopItemInfo> personalModuleMap, List<ExpDesktopGroupAppInfo> recommendModule, List<ExpDesktopRankTabAppInfo> rankModules) {
        Intrinsics.checkNotNullParameter(personalModuleMap, "personalModuleMap");
        Intrinsics.checkNotNullParameter(recommendModule, "recommendModule");
        Intrinsics.checkNotNullParameter(rankModules, "rankModules");
        this.mDesktopLocalDbRepository.updateMiniAppDbInfoWithBatch(personalModuleMap, recommendModule, rankModules);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopLocalMmkvRepository
    public void updateMiniAppPositionInMmkv(Map<Integer, DesktopItemInfo> personalModuleMap, List<ExpDesktopGroupAppInfo> recommendModule, List<ExpDesktopRankTabAppInfo> rankModules) {
        Intrinsics.checkNotNullParameter(personalModuleMap, "personalModuleMap");
        Intrinsics.checkNotNullParameter(recommendModule, "recommendModule");
        Intrinsics.checkNotNullParameter(rankModules, "rankModules");
        this.mDesktopLocalSpRepository.updateMiniAppPositionInMmkv(personalModuleMap, recommendModule, rankModules);
    }
}

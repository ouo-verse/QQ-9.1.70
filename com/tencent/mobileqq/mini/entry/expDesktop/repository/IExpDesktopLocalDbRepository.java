package com.tencent.mobileqq.mini.entry.expDesktop.repository;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopRankTabAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.repository.MiniAppExpDesktopLocalDataHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&J<\u0010\u000e\u001a\u00020\u00032\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/IExpDesktopLocalDbRepository;", "", "deleteMiniAppCacheInfo", "", "entity", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "deleteMiniAppDbInfo", "getMiniAppDesktopLocalCacheInfo", "localDataCallback", "Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/MiniAppExpDesktopLocalDataHelper$MiniAppLocalDataCallback;", "insertMiniAppDbInfo", "desktopAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "miniAppBubblePreloadAddFromDB", "updateMiniAppDbInfoWithBatch", "personalModuleMap", "", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "recommendModule", "", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopGroupAppInfo;", "rankModules", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopRankTabAppInfo;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public interface IExpDesktopLocalDbRepository {
    void deleteMiniAppCacheInfo(MiniAppInfo entity);

    void deleteMiniAppDbInfo(MiniAppInfo entity);

    void getMiniAppDesktopLocalCacheInfo(MiniAppExpDesktopLocalDataHelper.MiniAppLocalDataCallback localDataCallback);

    void insertMiniAppDbInfo(DesktopAppInfo desktopAppInfo);

    void miniAppBubblePreloadAddFromDB();

    void updateMiniAppDbInfoWithBatch(Map<Integer, DesktopItemInfo> personalModuleMap, List<ExpDesktopGroupAppInfo> recommendModule, List<ExpDesktopRankTabAppInfo> rankModules);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void updateMiniAppDbInfoWithBatch$default(IExpDesktopLocalDbRepository iExpDesktopLocalDbRepository, Map map, List list, List list2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    list = new ArrayList();
                }
                if ((i3 & 4) != 0) {
                    list2 = new ArrayList();
                }
                iExpDesktopLocalDbRepository.updateMiniAppDbInfoWithBatch(map, list, list2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateMiniAppDbInfoWithBatch");
        }
    }
}

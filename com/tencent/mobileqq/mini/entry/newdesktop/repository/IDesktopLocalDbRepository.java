package com.tencent.mobileqq.mini.entry.newdesktop.repository;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entity.AppBubbleRecordEntity;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.repository.MiniAppDesktopLocalDataHelper;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0013H&J\b\u0010\u0016\u001a\u00020\u0003H&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J8\u0010\u0018\u001a\u00020\u00032.\u0010\u0019\u001a*\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aj\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b`\u001dH&\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/IDesktopLocalDbRepository;", "", "deleteGdtMiniAppCacheInfo", "", "desktopAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "deleteMiniAppCacheInfo", "entity", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "deleteMiniAppDbInfo", "getMiniAppDesktopLocalCacheInfo", "localDataCallback", "Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/MiniAppDesktopLocalDataHelper$MiniAppLocalDataCallback;", "insertMiniAppDbInfo", "miniAppBubbleEnsureBubbleRecord", "Lcom/tencent/mobileqq/mini/entity/AppBubbleRecordEntity;", "appId", "", "moduleType", "", "text", "clickCount", "miniAppBubblePreloadAddFromDB", "miniAppBubbleUpdateAppBubbleRecord", "updateMiniAppDbInfoWithBatch", "miniAppUIDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "Lkotlin/collections/HashMap;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public interface IDesktopLocalDbRepository {
    void deleteGdtMiniAppCacheInfo(DesktopAppInfo desktopAppInfo);

    void deleteMiniAppCacheInfo(MiniAppInfo entity);

    void deleteMiniAppDbInfo(MiniAppInfo entity);

    void getMiniAppDesktopLocalCacheInfo(MiniAppDesktopLocalDataHelper.MiniAppLocalDataCallback localDataCallback);

    void insertMiniAppDbInfo(DesktopAppInfo desktopAppInfo);

    AppBubbleRecordEntity miniAppBubbleEnsureBubbleRecord(String appId, int moduleType, String text, int clickCount);

    void miniAppBubblePreloadAddFromDB();

    void miniAppBubbleUpdateAppBubbleRecord(String appId, int moduleType);

    void updateMiniAppDbInfoWithBatch(HashMap<Integer, List<DesktopItemInfo>> miniAppUIDataMap);
}

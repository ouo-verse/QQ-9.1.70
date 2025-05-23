package com.tencent.mobileqq.mini.entry.newdesktop.repository;

import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataMiniAppAdManager;
import com.tencent.mobileqq.mini.entry.newdesktop.DesktopMiniAppReqListener;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J0\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/IDesktopRemoteRepository;", "", "deleteDesktopMiniApp", "", "miniAppInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "moduleType", "", "listener", "Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;", "deleteRecentPlayLoadMoreApp", "getDesktopGdtAppInfo", "miniAppAdCallback", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopDataMiniAppAdManager$MiniAppAdCallback;", "getDesktopMiniAppRemoteInfo", FileReaderHelper.OPEN_FILE_FROM_FORCE, "", "isUseCache", "scene", "Lcom/tencent/mobileqq/mini/entry/desktop/GetAppListV2Scene;", "miniAppReqListener", "Lcom/tencent/mobileqq/mini/entry/newdesktop/DesktopMiniAppReqListener;", "operateMiniAppToMyMiniApp", MiniChatConstants.MINI_APP_TOP_TYPE, "oldPositionIndex", "newPositionIndex", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public interface IDesktopRemoteRepository {
    void deleteDesktopMiniApp(MiniAppInfo miniAppInfo, int moduleType, MiniAppCmdInterface listener);

    void deleteRecentPlayLoadMoreApp();

    void getDesktopGdtAppInfo(DesktopDataMiniAppAdManager.MiniAppAdCallback miniAppAdCallback);

    void getDesktopMiniAppRemoteInfo(boolean force, boolean isUseCache, GetAppListV2Scene scene, DesktopMiniAppReqListener miniAppReqListener);

    void operateMiniAppToMyMiniApp(MiniAppInfo miniAppInfo, int topType, int oldPositionIndex, int newPositionIndex, MiniAppCmdInterface listener);
}

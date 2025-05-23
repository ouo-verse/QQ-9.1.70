package com.tencent.mobileqq.mini.entry.expDesktop.repository;

import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.mini.entry.expDesktop.DesktopExpMiniAppReqListener;
import com.tencent.mobileqq.mini.entry.expDesktop.DesktopExpMoreMiniAppReqListener;
import com.tencent.mobileqq.mini.entry.expDesktop.DesktopExpRankMiniAppReqListener;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000fH&J(\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u0016H&J0\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/IExpDesktopRemoteRepository;", "", "deleteDesktopMiniApp", "", "miniAppInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "moduleType", "", "listener", "Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;", "deleteRecentPlayLoadMoreApp", "getDesktopMiniAppMoreModuleRemoteInfo", "miniAppReqListener", "Lcom/tencent/mobileqq/mini/entry/expDesktop/DesktopExpMoreMiniAppReqListener;", "getDesktopMiniAppRankModuleRemoteInfo", "Lcom/tencent/mobileqq/mini/entry/expDesktop/DesktopExpRankMiniAppReqListener;", "getDesktopMiniAppRemoteInfo", FileReaderHelper.OPEN_FILE_FROM_FORCE, "", "isUseCache", "scene", "Lcom/tencent/mobileqq/mini/entry/desktop/GetAppListV2Scene;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/DesktopExpMiniAppReqListener;", "operateMiniAppToMyMiniApp", MiniChatConstants.MINI_APP_TOP_TYPE, "oldPositionIndex", "newPositionIndex", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public interface IExpDesktopRemoteRepository {
    void deleteDesktopMiniApp(MiniAppInfo miniAppInfo, int moduleType, MiniAppCmdInterface listener);

    void deleteRecentPlayLoadMoreApp();

    void getDesktopMiniAppMoreModuleRemoteInfo(int moduleType, DesktopExpMoreMiniAppReqListener miniAppReqListener);

    void getDesktopMiniAppRankModuleRemoteInfo(int moduleType, DesktopExpRankMiniAppReqListener miniAppReqListener);

    void getDesktopMiniAppRemoteInfo(boolean force, boolean isUseCache, GetAppListV2Scene scene, DesktopExpMiniAppReqListener miniAppReqListener);

    void operateMiniAppToMyMiniApp(MiniAppInfo miniAppInfo, int topType, int oldPositionIndex, int newPositionIndex, MiniAppCmdInterface listener);
}

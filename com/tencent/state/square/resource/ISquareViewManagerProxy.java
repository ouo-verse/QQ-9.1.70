package com.tencent.state.square.resource;

import com.tencent.state.map.IMapItemViewManager;
import com.tencent.state.map.IMapViewManipulator;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.friendsetting.SettingTipsController;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/square/resource/ISquareViewManagerProxy;", "", "getScreenViewManager", "Lcom/tencent/state/map/IMapItemViewManager;", "getSquareRoleManager", "Lcom/tencent/state/square/resource/ISquareRoleManager;", "getSquareViewAbility", "Lcom/tencent/state/map/IMapViewManipulator;", "getSquareViewUpdater", "Lcom/tencent/state/square/ISquareViewUpdater;", "getTipsController", "Lcom/tencent/state/square/friendsetting/SettingTipsController;", "getViewBridge", "Lcom/tencent/state/square/resource/ISquareViewBridge;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface ISquareViewManagerProxy {
    IMapItemViewManager getScreenViewManager();

    ISquareRoleManager getSquareRoleManager();

    IMapViewManipulator getSquareViewAbility();

    ISquareViewUpdater getSquareViewUpdater();

    SettingTipsController getTipsController();

    ISquareViewBridge getViewBridge();
}

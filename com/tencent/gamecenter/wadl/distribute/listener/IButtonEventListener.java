package com.tencent.gamecenter.wadl.distribute.listener;

import android.view.View;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/listener/IButtonEventListener;", "", NodeProps.ON_CLICK, "", "view", "Landroid/view/View;", "onDownloadTaskStatusChange", "appId", "", "progress", "", "taskStatus", "", "onFollowOrSubscribeStatusChange", "followStatus", "subscribeStatus", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface IButtonEventListener {
    void onClick(@NotNull View view);

    void onDownloadTaskStatusChange(@NotNull String appId, float progress, int taskStatus);

    void onFollowOrSubscribeStatusChange(@NotNull String appId, int followStatus, int subscribeStatus);
}

package com.tencent.mobileqq.groupvideo.api;

import android.content.Context;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.intervideo.groupvideo.h;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0001\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\n\u0010\n\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\u000f\u001a\u00020\u0004H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/api/IGroupVideoDebugApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "", "openDebugPage", "openPluginManualApply", "Lcom/tencent/mobileqq/intervideo/groupvideo/h;", "groupVideoManager", "setGroupVideoManager", "getGroupVideoManager", "Lcom/tencent/mobileqq/groupvideo/api/IGroupVideoDebugApi$a;", "manager", "setDebugPluginManager", "getDebugPluginManager", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "a", "group-video-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGroupVideoDebugApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/api/IGroupVideoDebugApi$a;", "", "", "isDebugEnabled", "enable", "", "enableDebug", "", "pluginId", "a", "b", "group-video-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface a {
        boolean a(@NotNull String pluginId);

        void b(@NotNull String pluginId);

        void enableDebug(boolean enable);

        boolean isDebugEnabled();
    }

    @Nullable
    a getDebugPluginManager();

    @Nullable
    h getGroupVideoManager();

    void onDestroy();

    void openDebugPage(@NotNull Context context);

    void openPluginManualApply(@NotNull Context context);

    void setDebugPluginManager(@NotNull a manager);

    void setGroupVideoManager(@NotNull h groupVideoManager);
}

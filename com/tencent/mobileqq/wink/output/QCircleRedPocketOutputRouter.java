package com.tencent.mobileqq.wink.output;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import b93.OutputData;
import b93.a;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import com.tencent.mobileqq.wink.output.QCircleRedPocketOutputRouter;
import com.tencent.mobileqq.winkpublish.MediaInfo;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RoutePage(desc = "\u5c0f\u4e16\u754c\u8c03\u7528wink\u5236\u4f5c\u7ea2\u5305\u7684\u8f93\u51fa\u8def\u7531", path = "/wink/output/qcircle/red_pocket")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/output/QCircleRedPocketOutputRouter;", "Lb93/a;", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "onBack", "Lb93/b;", "outputData", "onOutput", "<init>", "()V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleRedPocketOutputRouter implements a {

    @NotNull
    public static final String TAG = "QCircleRedPocketOutputRouter";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onOutput$lambda$3() {
        SimpleEventBus.getInstance().dispatchEvent(new WinkFinishActivityEvent(false, false, 0, null, 15, null), true);
    }

    @Override // b93.a
    public boolean interceptExitWink() {
        return a.C0112a.a(this);
    }

    @Override // b93.a
    public void onBack(@NotNull Context context, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // b93.a
    public void onOutput(@NotNull Context context, @NotNull OutputData outputData) {
        Object obj;
        TaskInfo taskInfo;
        Object firstOrNull;
        String str;
        Serializable serializable;
        HashMap hashMap;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outputData, "outputData");
        if (outputData.getOutputPoint() == 64) {
            Bundle bundle = outputData.getBundle();
            Activity activity = null;
            if (bundle != null) {
                obj = bundle.get(QQWinkConstants.TASKINFO);
            } else {
                obj = null;
            }
            if (obj instanceof TaskInfo) {
                taskInfo = (TaskInfo) obj;
            } else {
                taskInfo = null;
            }
            if (taskInfo == null) {
                SimpleEventBus.getInstance().dispatchEvent(new WinkFinishActivityEvent(false, false, 0, null, 15, null), true);
                return;
            }
            Bundle bundle2 = new Bundle();
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) taskInfo.getMediaInfos());
            MediaInfo mediaInfo = (MediaInfo) firstOrNull;
            if (mediaInfo != null) {
                str = mediaInfo.getMediaPath();
            } else {
                str = null;
            }
            bundle2.putString(QCircleScheme.AttrRedPacket.RED_PACKET_PREVIEW_LOCAL_VIDEO_PATH, str);
            bundle2.putString(QCircleScheme.AttrRedPacket.RED_PACKET_PREVIEW_LOCAL_COVER_PATH, taskInfo.getCoverUrl());
            bundle2.putString(QCircleScheme.AttrRedPacket.RED_PACKET_PREVIEW_FEED_ID, taskInfo.getFeedId());
            bundle2.putLong(QCircleScheme.AttrRedPacket.RED_PACKET_PREVIEW_FEED_CREATE_TIME, taskInfo.getFeedTime());
            bundle2.putString(QCircleScheme.AttrRedPacket.RED_PACKET_PREVIEW_FEED_POSTER_ID, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
            Bundle bundle3 = outputData.getBundle();
            if (bundle3 != null) {
                serializable = bundle3.getSerializable("key_attrs");
            } else {
                serializable = null;
            }
            if (serializable instanceof HashMap) {
                hashMap = (HashMap) serializable;
            } else {
                hashMap = null;
            }
            if (hashMap != null) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    bundle2.putString((String) entry.getKey(), (String) entry.getValue());
                }
            }
            if (context instanceof Activity) {
                activity = (Activity) context;
            }
            if (activity != null) {
                ((IQCircleNativeFrameApi) QRoute.api(IQCircleNativeFrameApi.class)).launchRedPacketPreviewPage(activity, bundle2);
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: b93.c
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleRedPocketOutputRouter.onOutput$lambda$3();
                }
            }, 1000L);
        }
    }
}

package com.tencent.mobileqq.wink.api;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Size;
import b93.OutputData;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mobileqq.wink.listener.GenerateListener;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0002H&J<\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J&\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0015\u001a\u00020\u0014H&JB\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0004H&Js\u0010-\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\b2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010!2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+2\u0006\u0010\u0019\u001a\u00020\u0004H&\u00a2\u0006\u0004\b-\u0010.J\u0010\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0004H&J(\u00104\u001a\u00020\u00022\b\b\u0002\u00101\u001a\u00020\u00142\b\b\u0002\u00102\u001a\u00020)2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0012H&J\u0010\u00106\u001a\u00020\u00022\u0006\u00105\u001a\u00020)H&J\u0018\u00107\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u0004H&\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IWinkAPI;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "cleanCache", "", "localPath", "flagUselessFile", "initWinkLruCache", "", "outputPoint", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "outputMedias", "originalMedias", "Landroid/os/Bundle;", "bundle", "Lb93/b;", "retrieveOutputData", "Landroid/content/Intent;", "intent", "", "isRunningPublishTask", "mediaPath", "selectStartTime", "selectDurationTime", "bussinessName", "needShowSelectStart", "needShowThumb", "reportSessionId", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "createWinkEditorSegClipFragment", "videoPath", "videoDuration", "Landroid/util/Size;", QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, "startTime", "duration", "outputSize", "Landroid/graphics/Rect;", "outputRect", QAdRewardDefine$VideoParams.CACHE_PATH, "", "frameTime", "Lcom/tencent/mobileqq/wink/listener/GenerateListener;", "listener", "generateApng", "(Ljava/lang/String;Ljava/lang/Long;Landroid/util/Size;JJLandroid/util/Size;Landroid/graphics/Rect;Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/mobileqq/wink/listener/GenerateListener;Ljava/lang/String;)V", WadlProxyConsts.PARAM_FILENAME, "getWinkCachePath", "isIpc", QzoneIPCModule.RESULT_CODE, "data", "exitWink", com.heytap.mcssdk.a.a.f36094d, "notifyZoneWriteOperation", "appendMedia2QZoneMood", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWinkAPI extends QRouteApi {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void exitWink$default(IWinkAPI iWinkAPI, boolean z16, int i3, Intent intent, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 1) != 0) {
                    z16 = false;
                }
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                if ((i16 & 4) != 0) {
                    intent = null;
                }
                iWinkAPI.exitWink(z16, i3, intent);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exitWink");
        }

        public static /* synthetic */ OutputData retrieveOutputData$default(IWinkAPI iWinkAPI, long j3, List list, List list2, Bundle bundle, int i3, Object obj) {
            List list3;
            Bundle bundle2;
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    list3 = null;
                } else {
                    list3 = list2;
                }
                if ((i3 & 8) != 0) {
                    bundle2 = null;
                } else {
                    bundle2 = bundle;
                }
                return iWinkAPI.retrieveOutputData(j3, list, list3, bundle2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: retrieveOutputData");
        }
    }

    void appendMedia2QZoneMood(boolean isIpc, @NotNull String data);

    void cleanCache();

    @Nullable
    BasePartFragment createWinkEditorSegClipFragment(@NotNull String mediaPath, long selectStartTime, long selectDurationTime, @NotNull String bussinessName, boolean needShowSelectStart, boolean needShowThumb, @NotNull String reportSessionId);

    void exitWink(boolean isIpc, int resultCode, @Nullable Intent data);

    void flagUselessFile(@NotNull String localPath);

    void generateApng(@NotNull String videoPath, @Nullable Long videoDuration, @Nullable Size videoSize, long startTime, long duration, @Nullable Size outputSize, @Nullable Rect outputRect, @Nullable String cachePath, @Nullable Integer frameTime, @NotNull GenerateListener listener, @NotNull String bussinessName);

    @NotNull
    String getWinkCachePath(@NotNull String fileName);

    void initWinkLruCache();

    boolean isRunningPublishTask();

    void notifyZoneWriteOperation(int taskID);

    @NotNull
    OutputData retrieveOutputData(long outputPoint, @NotNull List<? extends LocalMediaInfo> outputMedias, @NotNull Intent intent);

    @NotNull
    OutputData retrieveOutputData(long outputPoint, @NotNull List<? extends LocalMediaInfo> outputMedias, @Nullable List<? extends LocalMediaInfo> originalMedias, @Nullable Bundle bundle);
}

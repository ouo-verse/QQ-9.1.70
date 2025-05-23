package com.tencent.mobileqq.zplan.meme.api;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.a;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.record.model.BatchRecordRequestParams;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J-\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a2\u0006\u0004\b\b\u0010\tJ5\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a2\u0006\u0004\b\b\u0010\fJ5\u0010\u000f\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H&J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H&J\b\u0010\u0019\u001a\u00020\u0007H&J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH&J\u001a\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020 2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&Jf\u00101\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\"2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00132\u0014\u00100\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010/\u0012\u0004\u0012\u00020\u00070.H&J\u0018\u00104\u001a\u00020\u00072\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\u0013H&J\b\u00105\u001a\u00020\u0013H&\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/api/IMemeHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/zplan/meme/action/MemeAction;", "T", "action", "Lcom/tencent/zplan/meme/a;", "listener", "", "recordAction", "(Lcom/tencent/zplan/meme/action/MemeAction;Lcom/tencent/zplan/meme/a;)V", "", "highPriority", "(Lcom/tencent/zplan/meme/action/MemeAction;ZLcom/tencent/zplan/meme/a;)V", "Lcom/tencent/zplan/meme/Priority;", "priority", "recordActionWithPriority", "(Lcom/tencent/zplan/meme/action/MemeAction;Lcom/tencent/zplan/meme/Priority;Lcom/tencent/zplan/meme/a;)V", "Ljava/io/File;", "getRecord", "", "apngPath", "gifPath", "convertApng2Gif", "sharpPPath", "convertSharpP2Gif", "destroyForAccountChange", "", WidgetCacheConstellationData.INTERVAL, "adapterToBrickFrameInterval", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "params", "recordSingleActionByResourceCenter", "Lcom/tencent/zplan/record/model/BatchRecordRequestParams;", "recordBatchActionByResourceCenter", "", "actionId", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "width", "height", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "scene", "", "timeout", "avatarCharacterString", "dressKey", "Lkotlin/Function1;", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "callback", "recordSingleActionByResourceCenterWithTimeout", "pause", "refer", "toggleQueuePauseState", "getLoadingResUrl", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IMemeHelper extends QRouteApi {
    float adapterToBrickFrameInterval(float interval);

    boolean convertApng2Gif(@NotNull String apngPath, @NotNull String gifPath);

    boolean convertSharpP2Gif(@NotNull String sharpPPath, @NotNull String gifPath);

    void destroyForAccountChange();

    @NotNull
    String getLoadingResUrl();

    @Nullable
    File getRecord(@NotNull MemeAction action);

    <T extends MemeAction> void recordAction(@NotNull T action, @Nullable a listener);

    <T extends MemeAction> void recordAction(@NotNull T action, boolean highPriority, @Nullable a listener);

    <T extends MemeAction> void recordActionWithPriority(@NotNull T action, @NotNull Priority priority, @Nullable a listener);

    void recordBatchActionByResourceCenter(@NotNull BatchRecordRequestParams params, @Nullable a listener);

    void recordSingleActionByResourceCenter(@NotNull SingleRecordRequestParams params, @Nullable a listener);

    void recordSingleActionByResourceCenterWithTimeout(int actionId, @NotNull String senderUin, int width, int height, @NotNull MODE mode, int scene, long timeout, @NotNull String avatarCharacterString, @NotNull String dressKey, @NotNull Function1<? super ZPlanRecordResource, Unit> callback);

    void toggleQueuePauseState(boolean pause, @NotNull String refer);
}

package com.tencent.mobileqq.zplan.meme.api.impl;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.zplan.meme.api.IMemeHelper;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.record.model.BatchRecordRequestParams;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b6\u00107J\u0011\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0019\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0096\u0001J\t\u0010\r\u001a\u00020\fH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J.\u0010\u0016\u001a\u00020\f\"\b\b\u0000\u0010\u0013*\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0096\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017J6\u0010\u0016\u001a\u00020\f\"\b\b\u0000\u0010\u0013*\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0096\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0019J6\u0010\u001c\u001a\u00020\f\"\b\b\u0000\u0010\u0013*\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0096\u0001\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\u001b\u0010\"\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020!2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0096\u0001Jg\u00102\u001a\u00020\f2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020#2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020#2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\u0014\u00101\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000100\u0012\u0004\u0012\u00020\f0/H\u0096\u0001J\u0019\u00105\u001a\u00020\f2\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\u0005H\u0096\u0001\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/api/impl/MemeHelperImpl;", "Lcom/tencent/mobileqq/zplan/meme/api/IMemeHelper;", "", WidgetCacheConstellationData.INTERVAL, "adapterToBrickFrameInterval", "", "apngPath", "gifPath", "", "convertApng2Gif", "sharpPPath", "convertSharpP2Gif", "", "destroyForAccountChange", "getLoadingResUrl", "Lcom/tencent/zplan/meme/action/MemeAction;", "action", "Ljava/io/File;", "getRecord", "T", "Lcom/tencent/zplan/meme/a;", "listener", "recordAction", "(Lcom/tencent/zplan/meme/action/MemeAction;Lcom/tencent/zplan/meme/a;)V", "highPriority", "(Lcom/tencent/zplan/meme/action/MemeAction;ZLcom/tencent/zplan/meme/a;)V", "Lcom/tencent/zplan/meme/Priority;", "priority", "recordActionWithPriority", "(Lcom/tencent/zplan/meme/action/MemeAction;Lcom/tencent/zplan/meme/Priority;Lcom/tencent/zplan/meme/a;)V", "Lcom/tencent/zplan/record/model/BatchRecordRequestParams;", "params", "recordBatchActionByResourceCenter", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "recordSingleActionByResourceCenter", "", "actionId", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "width", "height", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "scene", "", "timeout", "avatarCharacterString", "dressKey", "Lkotlin/Function1;", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "callback", "recordSingleActionByResourceCenterWithTimeout", "pause", "refer", "toggleQueuePauseState", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MemeHelperImpl implements IMemeHelper {
    private final /* synthetic */ MemeHelper $$delegate_0 = MemeHelper.INSTANCE;

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public float adapterToBrickFrameInterval(float interval) {
        return this.$$delegate_0.adapterToBrickFrameInterval(interval);
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public boolean convertApng2Gif(String apngPath, String gifPath) {
        Intrinsics.checkNotNullParameter(apngPath, "apngPath");
        Intrinsics.checkNotNullParameter(gifPath, "gifPath");
        return this.$$delegate_0.convertApng2Gif(apngPath, gifPath);
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public boolean convertSharpP2Gif(String sharpPPath, String gifPath) {
        Intrinsics.checkNotNullParameter(sharpPPath, "sharpPPath");
        Intrinsics.checkNotNullParameter(gifPath, "gifPath");
        return this.$$delegate_0.convertSharpP2Gif(sharpPPath, gifPath);
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public void destroyForAccountChange() {
        this.$$delegate_0.destroyForAccountChange();
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public String getLoadingResUrl() {
        return this.$$delegate_0.getLoadingResUrl();
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public File getRecord(MemeAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return this.$$delegate_0.getRecord(action);
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public <T extends MemeAction> void recordAction(T action, com.tencent.zplan.meme.a listener) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.$$delegate_0.recordAction(action, listener);
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public <T extends MemeAction> void recordActionWithPriority(T action, Priority priority, com.tencent.zplan.meme.a listener) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(priority, "priority");
        this.$$delegate_0.recordActionWithPriority(action, priority, listener);
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public void recordBatchActionByResourceCenter(BatchRecordRequestParams params, com.tencent.zplan.meme.a listener) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.$$delegate_0.recordBatchActionByResourceCenter(params, listener);
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public void recordSingleActionByResourceCenter(SingleRecordRequestParams params, com.tencent.zplan.meme.a listener) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.$$delegate_0.recordSingleActionByResourceCenter(params, listener);
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public void recordSingleActionByResourceCenterWithTimeout(int actionId, String senderUin, int width, int height, MODE mode, int scene, long timeout, String avatarCharacterString, String dressKey, Function1<? super ZPlanRecordResource, Unit> callback) {
        Intrinsics.checkNotNullParameter(senderUin, "senderUin");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(avatarCharacterString, "avatarCharacterString");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.$$delegate_0.recordSingleActionByResourceCenterWithTimeout(actionId, senderUin, width, height, mode, scene, timeout, avatarCharacterString, dressKey, callback);
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public void toggleQueuePauseState(boolean pause, String refer) {
        Intrinsics.checkNotNullParameter(refer, "refer");
        this.$$delegate_0.toggleQueuePauseState(pause, refer);
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public <T extends MemeAction> void recordAction(T action, boolean highPriority, com.tencent.zplan.meme.a listener) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.$$delegate_0.recordAction(action, highPriority, listener);
    }
}

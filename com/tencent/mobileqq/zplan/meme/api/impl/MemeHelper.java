package com.tencent.mobileqq.zplan.meme.api.impl;

import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.zplan.meme.api.IMemeHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.ZPlanSharePreRecordUtil;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.model.UploadConfig;
import com.tencent.zplan.common.utils.h;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.encoder.apng.MemeApngEncoder;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.record.model.BatchRecordRequestParams;
import com.tencent.zplan.record.model.ExpireConfig;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bD\u0010EJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0005J+\u0010\r\u001a\u00020\f\"\b\b\u0000\u0010\b*\u00020\u00072\u0006\u0010\t\u001a\u00028\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ3\u0010\r\u001a\u00020\f\"\b\b\u0000\u0010\b*\u00020\u00072\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u0010J3\u0010\u0013\u001a\u00020\f\"\b\b\u0000\u0010\b*\u00020\u00072\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u001a\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020 2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016Jf\u00101\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00172\u0014\u00100\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010/\u0012\u0004\u0012\u00020\f0.H\u0016J\u001a\u00103\u001a\u00020\f2\u0006\u0010!\u001a\u0002022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u00105\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u00010\u0017J\u0018\u00108\u001a\u00020\f2\u0006\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u0017H\u0016J\b\u00109\u001a\u00020\u0017H\u0016R\u0014\u0010:\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b:\u0010;R#\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/api/impl/MemeHelper;", "Lcom/tencent/mobileqq/zplan/meme/api/IMemeHelper;", "", "", "shouldPauseRecordQueue", "", "toBrickFrameInterval", "Lcom/tencent/zplan/meme/action/MemeAction;", "T", "action", "Lcom/tencent/zplan/meme/a;", "listener", "", "recordAction", "(Lcom/tencent/zplan/meme/action/MemeAction;Lcom/tencent/zplan/meme/a;)V", "highPriority", "(Lcom/tencent/zplan/meme/action/MemeAction;ZLcom/tencent/zplan/meme/a;)V", "Lcom/tencent/zplan/meme/Priority;", "priority", "recordActionWithPriority", "(Lcom/tencent/zplan/meme/action/MemeAction;Lcom/tencent/zplan/meme/Priority;Lcom/tencent/zplan/meme/a;)V", "Ljava/io/File;", "getRecord", "", "apngPath", "gifPath", "convertApng2Gif", "sharpPPath", "convertSharpP2Gif", "destroyForAccountChange", WidgetCacheConstellationData.INTERVAL, "adapterToBrickFrameInterval", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "params", "recordSingleActionByResourceCenter", "actionId", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "width", "height", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "scene", "", "timeout", "avatarCharacterString", "dressKey", "Lkotlin/Function1;", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "callback", "recordSingleActionByResourceCenterWithTimeout", "Lcom/tencent/zplan/record/model/BatchRecordRequestParams;", "recordBatchActionByResourceCenter", "avatarSceneParams", "notifyEnterAvatarScene", "pause", "refer", "toggleQueuePauseState", "getLoadingResUrl", "TAG", "Ljava/lang/String;", "", "CONTINUE_RECORD_SCENES$delegate", "Lkotlin/Lazy;", "getCONTINUE_RECORD_SCENES", "()Ljava/util/List;", "CONTINUE_RECORD_SCENES", "ENGINE_FRAME_MINIMUM", UserInfo.SEX_FEMALE, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MemeHelper implements IMemeHelper {

    /* renamed from: CONTINUE_RECORD_SCENES$delegate, reason: from kotlin metadata */
    private static final Lazy CONTINUE_RECORD_SCENES;
    private static final float ENGINE_FRAME_MINIMUM = 0.033333335f;
    public static final MemeHelper INSTANCE = new MemeHelper();
    public static final String TAG = "MemeHelper";

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends Integer>>() { // from class: com.tencent.mobileqq.zplan.meme.api.impl.MemeHelper$CONTINUE_RECORD_SCENES$2
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Integer> invoke() {
                return ZPlanFeatureSwitch.f369852a.c1();
            }
        });
        CONTINUE_RECORD_SCENES = lazy;
    }

    MemeHelper() {
    }

    private final List<Integer> getCONTINUE_RECORD_SCENES() {
        return (List) CONTINUE_RECORD_SCENES.getValue();
    }

    private final boolean shouldPauseRecordQueue(int i3) {
        List<Integer> continue_record_scenes = getCONTINUE_RECORD_SCENES();
        return (continue_record_scenes == null || continue_record_scenes.contains(Integer.valueOf(i3))) ? false : true;
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public float adapterToBrickFrameInterval(float interval) {
        return toBrickFrameInterval(interval);
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public boolean convertApng2Gif(String apngPath, String gifPath) {
        Intrinsics.checkNotNullParameter(apngPath, "apngPath");
        Intrinsics.checkNotNullParameter(gifPath, "gifPath");
        return MemeApngEncoder.INSTANCE.a(apngPath, gifPath);
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public boolean convertSharpP2Gif(String sharpPPath, String gifPath) {
        Intrinsics.checkNotNullParameter(sharpPPath, "sharpPPath");
        Intrinsics.checkNotNullParameter(gifPath, "gifPath");
        return e.f333985a.a(sharpPPath, gifPath);
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public void destroyForAccountChange() {
        Meme.f385754h.h();
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public String getLoadingResUrl() {
        return ZPlanFeatureSwitch.f369852a.F1();
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public File getRecord(MemeAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return Meme.f385754h.o(action.getKey());
    }

    public final void notifyEnterAvatarScene(String avatarSceneParams) {
        QLog.i(TAG, 1, "notifyEnterAvatarScene: " + avatarSceneParams);
        JSONObject b16 = h.f385294a.b(avatarSceneParams);
        if (b16 == null) {
            return;
        }
        int optInt = b16.optInt("ViewType", 0);
        toggleQueuePauseState(shouldPauseRecordQueue(optInt), "EnterAvatarScene:" + optInt);
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public <T extends MemeAction> void recordAction(T action, com.tencent.zplan.meme.a listener) {
        Intrinsics.checkNotNullParameter(action, "action");
        Meme.y(Meme.f385754h, action, false, listener, 2, null);
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public <T extends MemeAction> void recordActionWithPriority(T action, Priority priority, com.tencent.zplan.meme.a listener) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Meme.f385754h.A(action, priority, listener);
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public void recordBatchActionByResourceCenter(BatchRecordRequestParams params, com.tencent.zplan.meme.a listener) {
        Intrinsics.checkNotNullParameter(params, "params");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MemeHelper$recordBatchActionByResourceCenter$1(params, listener, null), 3, null);
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public void recordSingleActionByResourceCenter(SingleRecordRequestParams params, com.tencent.zplan.meme.a listener) {
        Intrinsics.checkNotNullParameter(params, "params");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MemeHelper$recordSingleActionByResourceCenter$1(params, listener, null), 3, null);
    }

    public final float toBrickFrameInterval(float f16) {
        float f17 = f16 / 1000.0f;
        if (f17 < ENGINE_FRAME_MINIMUM) {
            return ENGINE_FRAME_MINIMUM;
        }
        return f17;
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public void toggleQueuePauseState(boolean pause, String refer) {
        Intrinsics.checkNotNullParameter(refer, "refer");
        Meme.H(Meme.f385754h, pause, refer, null, 4, null);
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    public <T extends MemeAction> void recordAction(T action, boolean highPriority, com.tencent.zplan.meme.a listener) {
        Intrinsics.checkNotNullParameter(action, "action");
        Meme.f385754h.x(action, highPriority, listener);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00af  */
    @Override // com.tencent.mobileqq.zplan.meme.api.IMemeHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void recordSingleActionByResourceCenterWithTimeout(int actionId, String senderUin, int width, int height, MODE mode, int scene, long timeout, String avatarCharacterString, String dressKey, Function1<? super ZPlanRecordResource, Unit> callback) {
        AvatarCharacterInfo avatarCharacterInfo;
        Intrinsics.checkNotNullParameter(senderUin, "senderUin");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(avatarCharacterString, "avatarCharacterString");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i(TAG, 1, "recordSingleActionByResourceCenterWithTimeout");
        BusinessConfig businessConfig = new BusinessConfig(0, false, false, false, null, 0, null, null, null, null, null, null, null, false, null, 0, null, 131071, null);
        if (avatarCharacterString.length() > 0) {
            if (dressKey.length() > 0) {
                try {
                    avatarCharacterInfo = new AvatarCharacterInfo(fx4.a.a(new JSONObject(avatarCharacterString)), dressKey);
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "convertToAvatarCharacter error", th5);
                }
                AvatarCharacterInfo avatarCharacterInfo2 = avatarCharacterInfo;
                if (scene == 201) {
                    businessConfig.G(ZPlanSharePreRecordUtil.f371750a.d());
                    if (businessConfig.getTargetEngine() instanceof EngineType.Filament) {
                        businessConfig.A(Boolean.TRUE);
                        QLog.i(TAG, 1, "filament record, enableUserData = true");
                    }
                }
                if (mode == MODE.FRAME) {
                    businessConfig.y(0);
                    businessConfig.C(BusinessConfig.FrameType.PNG);
                }
                SingleRecordRequestParams singleRecordRequestParams = new SingleRecordRequestParams(actionId, senderUin, null, width, height, mode, businessConfig, scene, AppTheme.DAY, Priority.HIGH, new UploadConfig(ZPlanFeatureSwitch.f369852a.b0(), UploadConfig.UploadTarget.CDN, true, false, 8, null), new ExpireConfig(false, 0L, 0L, 7, null), 0, false, null, null, 57344, null);
                singleRecordRequestParams.x(avatarCharacterInfo2);
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MemeHelper$recordSingleActionByResourceCenterWithTimeout$1(timeout, callback, singleRecordRequestParams, null), 3, null);
            }
        }
        avatarCharacterInfo = null;
        AvatarCharacterInfo avatarCharacterInfo22 = avatarCharacterInfo;
        if (scene == 201) {
        }
        if (mode == MODE.FRAME) {
        }
        SingleRecordRequestParams singleRecordRequestParams2 = new SingleRecordRequestParams(actionId, senderUin, null, width, height, mode, businessConfig, scene, AppTheme.DAY, Priority.HIGH, new UploadConfig(ZPlanFeatureSwitch.f369852a.b0(), UploadConfig.UploadTarget.CDN, true, false, 8, null), new ExpireConfig(false, 0L, 0L, 7, null), 0, false, null, null, 57344, null);
        singleRecordRequestParams2.x(avatarCharacterInfo22);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MemeHelper$recordSingleActionByResourceCenterWithTimeout$1(timeout, callback, singleRecordRequestParams2, null), 3, null);
    }
}

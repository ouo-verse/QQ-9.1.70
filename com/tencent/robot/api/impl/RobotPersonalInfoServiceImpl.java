package com.tencent.robot.api.impl;

import android.os.Bundle;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener;
import com.tencent.qqnt.kernel.nativeinterface.RobotFeature;
import com.tencent.qqnt.kernel.nativeinterface.StoryBaseInfo;
import com.tencent.robot.adelie.homepage.utils.StoryUtils;
import com.tencent.robot.api.IRobotPersonalInfoApi;
import com.tencent.robot.api.IRobotPersonalInfoService;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u00010\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J,\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u001a\u0010\"\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000eH\u0016J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u0018\u0010&\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R0\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001f0,j\b\u0012\u0004\u0012\u00020\u001f`-0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/robot/api/impl/RobotPersonalInfoServiceImpl;", "Lcom/tencent/robot/api/IRobotPersonalInfoService;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotFeature;", "robotFeature", "", "updateRobotFeature", "getRobotFeature", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "robotUid", "Lkotlin/Function2;", "", "callback", "getRobotPersonalInfoAsync", "isAutoTtsSwitchOpened", "updateAutoTtsSwitchState", "uid", "Lcom/tencent/qqnt/kernel/nativeinterface/StoryBaseInfo;", "storyBaseInfo", "addToCache", "removeFromCache", "getStoryBaseInfo", "uin", "", "chatType", "Landroid/os/Bundle;", "fillStoryBaseInfo", "doOnDrawCompleteAfter", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRobotListener;", "listener", "addRobotListener", "removeRobotListener", "isClear", "putMsgRecordStatus", "getMsgRecordStatus", "mRobotFeature", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotFeature;", "", "mRobotListenerId", "J", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "mRobotListenerMap", "Ljava/util/Map;", "com/tencent/robot/api/impl/RobotPersonalInfoServiceImpl$mRobotListener$1", "mRobotListener", "Lcom/tencent/robot/api/impl/RobotPersonalInfoServiceImpl$mRobotListener$1;", "<init>", "()V", "Companion", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotPersonalInfoServiceImpl implements IRobotPersonalInfoService {

    @NotNull
    public static final String MMKV_KEY_AIO_ROBOT_STORY_MSG_DELETE = "mmkv_key_aio_robot_story_msg_delete_";

    @NotNull
    public static final String MMKV_KEY_AIO_ROBOT_STORY_UID = "mmkv_key_aio_robot_story_uid_";

    @NotNull
    public static final String MMKV_KEY_AIO_ROBOT_STORY_UID_SET = "mmkv_key_aio_robot_story_uid_set";

    @NotNull
    private static final String TAG = "RobotPersonalInfoServiceImpl-RobotStory";

    @Nullable
    private RobotFeature mRobotFeature;

    @NotNull
    private static final Map<String, StoryBaseInfo> sStoryInfoMap = new LinkedHashMap();

    @NotNull
    private static final Set<String> sStoryInfoUidSet = new LinkedHashSet();
    private long mRobotListenerId = Long.MIN_VALUE;

    @NotNull
    private final Map<String, HashSet<IKernelRobotListener>> mRobotListenerMap = new LinkedHashMap();

    @NotNull
    private final RobotPersonalInfoServiceImpl$mRobotListener$1 mRobotListener = new RobotPersonalInfoServiceImpl$mRobotListener$1(this);

    private final RobotFeature getRobotFeature() {
        RobotFeature robotFeature;
        synchronized (this) {
            robotFeature = this.mRobotFeature;
        }
        return robotFeature;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRobotPersonalInfoAsync$lambda$0(RobotPersonalInfoServiceImpl this$0, Function2 callback, int i3, String str, GroupRobotProfile groupRobotProfile) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        boolean z16 = true;
        QLog.i(TAG, 1, "getRobotPersonalInfoAsync result = " + i3 + "\uff0c" + groupRobotProfile.robotFeature);
        this$0.updateRobotFeature(groupRobotProfile.robotFeature);
        if (i3 != 0) {
            z16 = false;
        }
        callback.invoke(Boolean.valueOf(z16), this$0.getRobotFeature());
    }

    private final void updateRobotFeature(RobotFeature robotFeature) {
        synchronized (this) {
            this.mRobotFeature = robotFeature;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.robot.api.IRobotPersonalInfoService
    public void addRobotListener(@NotNull String uid, @NotNull IKernelRobotListener listener) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.i(TAG, 1, "addRobotListener uid=" + uid + ", listener=" + listener);
        if (this.mRobotListenerMap.get(uid) == null) {
            this.mRobotListenerMap.put(uid, new HashSet<>());
        }
        HashSet<IKernelRobotListener> hashSet = this.mRobotListenerMap.get(uid);
        if (hashSet != null) {
            hashSet.add(listener);
        }
    }

    @Override // com.tencent.robot.api.IRobotPersonalInfoService
    public void addToCache(@NotNull String uid, @NotNull StoryBaseInfo storyBaseInfo) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(storyBaseInfo, "storyBaseInfo");
        synchronized (this) {
            Map<String, StoryBaseInfo> map = sStoryInfoMap;
            if (q64.a.b(storyBaseInfo, map.get(uid))) {
                QLog.i(TAG, 1, "addToCache \u91cd\u590d\u4e86\uff0c\u76f4\u63a5\u8fd4\u56de storyBaseInfo = " + storyBaseInfo);
                return;
            }
            QLog.i(TAG, 1, "addToCache storyBaseInfo = " + storyBaseInfo);
            map.put(uid, storyBaseInfo);
            Set<String> set = sStoryInfoUidSet;
            set.add(uid);
            QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").putStringSet(MMKV_KEY_AIO_ROBOT_STORY_UID_SET, set);
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            String str = MMKV_KEY_AIO_ROBOT_STORY_UID + uid;
            StoryInfoParcelable storyInfoParcelable = new StoryInfoParcelable();
            storyInfoParcelable.x(storyBaseInfo.storyId);
            String str2 = storyBaseInfo.name;
            Intrinsics.checkNotNullExpressionValue(str2, "storyBaseInfo.name");
            storyInfoParcelable.s(str2);
            String str3 = storyBaseInfo.title;
            Intrinsics.checkNotNullExpressionValue(str3, "storyBaseInfo.title");
            storyInfoParcelable.z(str3);
            String str4 = storyBaseInfo.introduce;
            Intrinsics.checkNotNullExpressionValue(str4, "storyBaseInfo.introduce");
            storyInfoParcelable.r(str4);
            String str5 = storyBaseInfo.pic;
            Intrinsics.checkNotNullExpressionValue(str5, "storyBaseInfo.pic");
            storyInfoParcelable.w(str5);
            String str6 = storyBaseInfo.dayBackground;
            Intrinsics.checkNotNullExpressionValue(str6, "storyBaseInfo.dayBackground");
            storyInfoParcelable.o(str6);
            String str7 = storyBaseInfo.nightBackground;
            Intrinsics.checkNotNullExpressionValue(str7, "storyBaseInfo.nightBackground");
            storyInfoParcelable.t(str7);
            String str8 = storyBaseInfo.dayBackgroundColor;
            Intrinsics.checkNotNullExpressionValue(str8, "storyBaseInfo.dayBackgroundColor");
            storyInfoParcelable.p(str8);
            String str9 = storyBaseInfo.nightBackgroundColor;
            Intrinsics.checkNotNullExpressionValue(str9, "storyBaseInfo.nightBackgroundColor");
            storyInfoParcelable.u(str9);
            String str10 = storyBaseInfo.dayDynamicPic;
            Intrinsics.checkNotNullExpressionValue(str10, "storyBaseInfo.dayDynamicPic");
            storyInfoParcelable.q(str10);
            String str11 = storyBaseInfo.nightDynamicPic;
            Intrinsics.checkNotNullExpressionValue(str11, "storyBaseInfo.nightDynamicPic");
            storyInfoParcelable.v(str11);
            storyInfoParcelable.y(storyBaseInfo.storyType);
            Unit unit = Unit.INSTANCE;
            fromV2.putParcelable(str, storyInfoParcelable);
        }
    }

    @Override // com.tencent.robot.api.IRobotPersonalInfoService
    public void doOnDrawCompleteAfter() {
        Set<String> stringSet = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getStringSet(MMKV_KEY_AIO_ROBOT_STORY_UID_SET, new LinkedHashSet());
        if (stringSet == null) {
            QLog.i(TAG, 1, "doOnDrawCompleteAfter sStoryInfoUidSet empty");
            return;
        }
        QLog.i(TAG, 1, "doOnDrawCompleteAfter sStoryInfoUidSet = " + stringSet);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : stringSet) {
            StoryInfoParcelable storyInfoParcelable = (StoryInfoParcelable) QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getParcelable(MMKV_KEY_AIO_ROBOT_STORY_UID + str, StoryInfoParcelable.class, new StoryInfoParcelable(), false);
            if (storyInfoParcelable != null) {
                StoryBaseInfo storyBaseInfo = new StoryBaseInfo();
                storyBaseInfo.storyId = storyInfoParcelable.getCom.tencent.mobileqq.wink.api.QQWinkConstants.STORY_ID java.lang.String();
                storyBaseInfo.name = storyInfoParcelable.getName();
                storyBaseInfo.title = storyInfoParcelable.getTitle();
                storyBaseInfo.introduce = storyInfoParcelable.getIntroduce();
                storyBaseInfo.pic = storyInfoParcelable.getPic();
                storyBaseInfo.dayBackground = storyInfoParcelable.getDayBackground();
                storyBaseInfo.nightBackground = storyInfoParcelable.getNightBackground();
                storyBaseInfo.dayBackgroundColor = storyInfoParcelable.getDayBackgroundColor();
                storyBaseInfo.nightBackgroundColor = storyInfoParcelable.getNightBackgroundColor();
                storyBaseInfo.dayDynamicPic = storyInfoParcelable.getDayDynamicPic();
                storyBaseInfo.nightDynamicPic = storyInfoParcelable.getNightDynamicPic();
                storyBaseInfo.storyType = storyInfoParcelable.getStoryType();
                QLog.i(TAG, 1, "doOnDrawCompleteAfter uid=" + str + ", " + storyBaseInfo);
                linkedHashMap.put(str, storyBaseInfo);
            }
        }
        synchronized (this) {
            sStoryInfoUidSet.addAll(linkedHashMap.keySet());
            sStoryInfoMap.putAll(linkedHashMap);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.robot.api.IRobotPersonalInfoService
    @NotNull
    public Bundle fillStoryBaseInfo(@NotNull String uid, @NotNull String uin, int chatType) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(uin, "uin");
        return StoryUtils.f366640a.p(uid, uin, chatType);
    }

    @Override // com.tencent.robot.api.IRobotPersonalInfoService
    public boolean getMsgRecordStatus(@NotNull String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        return QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getBoolean(MMKV_KEY_AIO_ROBOT_STORY_MSG_DELETE + uid, false);
    }

    @Override // com.tencent.robot.api.IRobotPersonalInfoService
    public void getRobotPersonalInfoAsync(@NotNull String robotUid, @NotNull final Function2<? super Boolean, ? super RobotFeature, Unit> callback) {
        Intrinsics.checkNotNullParameter(robotUid, "robotUid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!AppNetConnInfo.isNetSupport()) {
            callback.invoke(Boolean.FALSE, null);
            return;
        }
        QLog.i(TAG, 1, "getRobotPersonalInfoAsync robotUid = " + robotUid);
        ((IRobotPersonalInfoApi) QRoute.api(IRobotPersonalInfoApi.class)).fetchRobotPersonalInfoFromServer(robotUid, new IGetGroupRobotProfileCallback() { // from class: com.tencent.robot.api.impl.j
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
            public final void onResult(int i3, String str, GroupRobotProfile groupRobotProfile) {
                RobotPersonalInfoServiceImpl.getRobotPersonalInfoAsync$lambda$0(RobotPersonalInfoServiceImpl.this, callback, i3, str, groupRobotProfile);
            }
        });
    }

    @Override // com.tencent.robot.api.IRobotPersonalInfoService
    @Nullable
    public StoryBaseInfo getStoryBaseInfo(@NotNull String uid) {
        StoryBaseInfo storyBaseInfo;
        Intrinsics.checkNotNullParameter(uid, "uid");
        synchronized (this) {
            storyBaseInfo = sStoryInfoMap.get(uid);
        }
        return storyBaseInfo;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        long j3;
        ac a16 = u64.h.a();
        if (a16 != null) {
            j3 = a16.addKernelRobotListener(this.mRobotListener);
        } else {
            j3 = Long.MIN_VALUE;
        }
        this.mRobotListenerId = j3;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        ac a16 = u64.h.a();
        if (a16 != null) {
            a16.removeKernelRobotListener(this.mRobotListenerId);
        }
        updateRobotFeature(null);
    }

    @Override // com.tencent.robot.api.IRobotPersonalInfoService
    public void putMsgRecordStatus(@NotNull String uid, boolean isClear) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        if (isClear) {
            QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").putBoolean(MMKV_KEY_AIO_ROBOT_STORY_MSG_DELETE + uid, true);
            return;
        }
        QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").remove(MMKV_KEY_AIO_ROBOT_STORY_MSG_DELETE + uid);
    }

    @Override // com.tencent.robot.api.IRobotPersonalInfoService
    public void removeFromCache(@NotNull String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        QLog.i(TAG, 1, "removeFromCache uid = " + uid);
        synchronized (this) {
            Set<String> set = sStoryInfoUidSet;
            if (!set.contains(uid)) {
                return;
            }
            set.remove(uid);
            QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").putStringSet(MMKV_KEY_AIO_ROBOT_STORY_UID_SET, set);
            QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").remove(MMKV_KEY_AIO_ROBOT_STORY_UID + uid);
            StoryBaseInfo remove = sStoryInfoMap.remove(uid);
            QLog.i(TAG, 1, "removeFromCache storyBaseInfo = " + remove);
            StoryBaseInfo storyBaseInfo = remove;
        }
    }

    @Override // com.tencent.robot.api.IRobotPersonalInfoService
    public void removeRobotListener(@NotNull String uid, @Nullable IKernelRobotListener listener) {
        boolean z16;
        Intrinsics.checkNotNullParameter(uid, "uid");
        HashSet<IKernelRobotListener> hashSet = this.mRobotListenerMap.get(uid);
        if (hashSet != null && !hashSet.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.i(TAG, 1, "removeRobotListener uid=" + uid + ", listener isNullOrEmpty");
            return;
        }
        if (listener == null) {
            QLog.i(TAG, 1, "removeRobotListener uid=" + uid + ", remove all listeners=" + this.mRobotListenerMap.remove(uid));
            return;
        }
        QLog.i(TAG, 1, "removeRobotListener uid=" + uid + ", ret=" + hashSet.remove(listener) + ", listener=" + listener);
        if (hashSet.isEmpty()) {
            this.mRobotListenerMap.remove(uid);
        }
    }

    @Override // com.tencent.robot.api.IRobotPersonalInfoService
    public void updateAutoTtsSwitchState(boolean isAutoTtsSwitchOpened) {
        int i3;
        synchronized (this) {
            RobotFeature robotFeature = this.mRobotFeature;
            if (robotFeature != null) {
                if (isAutoTtsSwitchOpened) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                robotFeature.autoTts = i3;
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}

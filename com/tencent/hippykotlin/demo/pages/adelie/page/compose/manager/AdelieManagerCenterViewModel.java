package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager;

import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.ListStateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo;
import com.tencent.hippykotlin.demo.pages.adelie.page.kuikly.manager.AdelieManagerViewModel$DisplayDataOption;
import com.tencent.hippykotlin.demo.pages.adelie.page.kuikly.manager.TroopInfo;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.e;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import h25.ab;
import h25.g;
import h25.u;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieManagerCenterViewModel {
    public boolean disableProfile;
    public StateHolder<Float> last7DaysFriendGrowthRate;
    public StateHolder<Float> last7DaysMsgGrowthRate;
    public StateHolder<Float> last7DaysVisitorGrowthRate;
    public StateHolder<PageState> pageState;
    public StateHolder<Integer> permissionType;
    public StateHolder<ab> qZoneInfo;
    public ListStateHolder<AdelieRedDotModule$Companion$RedDotInfo> redDotList;
    public final StateHolder<g> robotControlInfo;
    public long robotUin;
    public final StateHolder<Boolean> showRejectDialog;
    public final StateHolder<TroopInfo> troopInfo;
    public StateHolder<Boolean> troopSettingEnable;
    public u userIdentityInfo;
    public AdelieManagerViewModel$DisplayDataOption displayDataOption = new AdelieManagerViewModel$DisplayDataOption("\u5982\u4f55\u5feb\u901f\u6709\u6548\u7684\u63d0\u5347\u6570\u636e\u8868\u73b0\uff1f", "mqqguild://guild/openfeeddetail?guild_id=594930274008823756&channel_id=638514516&feed_id=B_a46386665fc305001441152191622628080X60&poster_tinyid=144115219162262808&createtime=1720083364&invite_code=23aLIzfIOtn&needOpenWeb=0&shareSource=5&sourceId=share&subSourceId=others");
    public String robotUid = "";
    public StateHolder<String> avatarUrl = new StateHolder<>("");
    public StateHolder<String> nickName = new StateHolder<>("");
    public StateHolder<String> recycleTips = new StateHolder<>("");
    public StateHolder<String> recycleTimeMark = new StateHolder<>("");
    public StateHolder<Long> friendCount = new StateHolder<>(-1L);
    public StateHolder<Long> msgCount = new StateHolder<>(-1L);
    public StateHolder<Long> visitorCount = new StateHolder<>(-1L);
    public StateHolder<Long> last7DaysFriendCount = new StateHolder<>(-1L);
    public StateHolder<Long> last7DaysMsgCount = new StateHolder<>(-1L);
    public StateHolder<Long> last7DaysVisitorCount = new StateHolder<>(-1L);

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public enum PageState {
        LOADING,
        SUCCESS,
        ERROR
    }

    public AdelieManagerCenterViewModel() {
        Float valueOf = Float.valueOf(Float.NaN);
        this.last7DaysFriendGrowthRate = new StateHolder<>(valueOf);
        this.last7DaysMsgGrowthRate = new StateHolder<>(valueOf);
        this.last7DaysVisitorGrowthRate = new StateHolder<>(valueOf);
        this.troopInfo = new StateHolder<>(new TroopInfo());
        Boolean bool = Boolean.FALSE;
        this.troopSettingEnable = new StateHolder<>(bool);
        int i3 = 0;
        String str = null;
        this.qZoneInfo = new StateHolder<>(new ab(i3, null, str, 0, 0, 31, null));
        this.redDotList = new ListStateHolder<>();
        this.robotControlInfo = new StateHolder<>(new g(i3, 0, str, 7, null));
        this.showRejectDialog = new StateHolder<>(bool);
        this.pageState = new StateHolder<>(PageState.LOADING);
        this.permissionType = new StateHolder<>(0);
    }

    public final void bindGroupChatToRobot(String str, List<String> list, Function1<? super Boolean, Unit> function1) {
        KLog.INSTANCE.i("AdelieManagerCenterViewModel", "bindGroupChatToRobot, botUid:" + str + ", troopUins:" + list);
        BuildersKt.e(e.f117232d, null, null, new AdelieManagerCenterViewModel$bindGroupChatToRobot$1(str, list, function1, null), 3, null);
    }

    public final boolean bitOP(int i3) {
        g value = this.robotControlInfo._state.getValue();
        return ((1 << i3) & (value != null ? value.f404203d : 0)) > 0;
    }

    public final void fetchRobotInfo(String str, Function1<? super Boolean, Unit> function1) {
        StateHolder<PageState> stateHolder = this.pageState;
        stateHolder._state.setValue(PageState.LOADING);
        BuildersKt.e(e.f117232d, null, null, new AdelieManagerCenterViewModel$fetchRobotInfo$1(str, function1, this, null), 3, null);
    }

    public final boolean isFetchDataFinish() {
        if (this.pageState._state.getValue() == PageState.SUCCESS) {
            return true;
        }
        ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u9875\u9762\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", QToastMode.Warning);
        return false;
    }

    public final void updateTroopInfo(String str, String str2) {
        TroopInfo troopInfo = new TroopInfo();
        ReadWriteProperty readWriteProperty = troopInfo.uin$delegate;
        KProperty<?>[] kPropertyArr = TroopInfo.$$delegatedProperties;
        readWriteProperty.setValue(troopInfo, kPropertyArr[0], str);
        troopInfo.name$delegate.setValue(troopInfo, kPropertyArr[1], str2);
        this.troopInfo._state.setValue(troopInfo);
    }
}

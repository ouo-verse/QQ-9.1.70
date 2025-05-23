package com.tencent.state;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.map.MapViewKt;
import com.tencent.state.square.ItemStruct;
import com.tencent.state.square.MoveItem;
import com.tencent.state.square.MoveResult;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.guide.CreateRoleGuideConfig;
import com.tencent.state.square.guide.CreateRolePageConfig;
import com.tencent.state.square.guide.CreateRoleRedDotBubbleConfig;
import com.tencent.state.square.guide.PublishStatusGuideConfig;
import com.tencent.state.square.guide.SquareNoviceGuideConfig;
import com.tencent.state.square.layout.MoveCommand;
import com.tencent.state.square.layout.MoveRequest;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010P\u001a\u00020QJ(\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\b2\u0018\u0010U\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020X0W0VJ\u001c\u0010Y\u001a\u00020S2\u0006\u0010T\u001a\u00020\b2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020X0[J\"\u0010\\\u001a\u00020S2\u0006\u0010T\u001a\u00020\b2\u0012\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020X0]J\u001c\u0010^\u001a\u00020S2\u0006\u0010T\u001a\u00020\b2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020a0`J\u001c\u0010b\u001a\u00020S2\u0006\u0010T\u001a\u00020\b2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020c0`J\u001c\u0010d\u001a\u00020S2\u0006\u0010T\u001a\u00020\b2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020e0`J\"\u0010f\u001a\u00020S2\u0006\u0010T\u001a\u00020\b2\u0012\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020g0]J\u001c\u0010h\u001a\u00020S2\u0006\u0010T\u001a\u00020\b2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020j0VR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001a\u0010 \u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001a\u0010#\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001a\u0010&\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001a\u0010)\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u001a\u0010,\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001a\u0010/\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u0010\u0016R\u001a\u00102\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u0010\u0016R\u001a\u00105\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0014\"\u0004\b7\u0010\u0016R\u001a\u00108\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0014\"\u0004\b:\u0010\u0016R\u001a\u0010;\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0014\"\u0004\b=\u0010\u0016R\u001a\u0010>\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0014\"\u0004\b@\u0010\u0016R\u001a\u0010A\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0014\"\u0004\bC\u0010\u0016R\u001a\u0010D\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u000b\"\u0004\bF\u0010\rR\u001a\u0010G\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0014\"\u0004\bI\u0010\u0016R\u001a\u0010J\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0014\"\u0004\bL\u0010\u0016R\u001a\u0010M\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0014\"\u0004\bO\u0010\u0016\u00a8\u0006k"}, d2 = {"Lcom/tencent/state/SquareDebug;", "", "()V", "CPU_CORE_NUM_DEFAULT", "", "CPU_MAX_FREQ_DEFAULT", "RAM_SIZE_DEFAULT", "TAG", "", "cpuCoreNum", "getCpuCoreNum", "()I", "setCpuCoreNum", "(I)V", "cpuMaxFreq", "getCpuMaxFreq", "setCpuMaxFreq", "drawableMonitor", "", "getDrawableMonitor", "()Z", "setDrawableMonitor", "(Z)V", "enableAddMulti", "getEnableAddMulti", "setEnableAddMulti", "enableAvatarDebugInfo", "getEnableAvatarDebugInfo", "setEnableAvatarDebugInfo", "enableBatteryMock", "getEnableBatteryMock", "setEnableBatteryMock", "enableChatLandUseCache", "getEnableChatLandUseCache", "setEnableChatLandUseCache", "enableDynamicSortDebug", "getEnableDynamicSortDebug", "setEnableDynamicSortDebug", "enableFilamentDetail", "getEnableFilamentDetail", "setEnableFilamentDetail", "enableFilamentIndex", "getEnableFilamentIndex", "setEnableFilamentIndex", "enableFilamentIndexDebug", "getEnableFilamentIndexDebug", "setEnableFilamentIndexDebug", "enableIndexUseCache", "getEnableIndexUseCache", "setEnableIndexUseCache", "enableMockUnReadMsg", "getEnableMockUnReadMsg", "setEnableMockUnReadMsg", "enableRecordGuest", "getEnableRecordGuest", "setEnableRecordGuest", "enableRecordLand", "getEnableRecordLand", "setEnableRecordLand", "forceShowAddTroopDialog", "getForceShowAddTroopDialog", "setForceShowAddTroopDialog", "mockNoviceGuide", "getMockNoviceGuide", "setMockNoviceGuide", "needShieldTeenager", "getNeedShieldTeenager", "setNeedShieldTeenager", "ramSize", "getRamSize", "setRamSize", "shortMsgBoxReadedExpireDuration", "getShortMsgBoxReadedExpireDuration", "setShortMsgBoxReadedExpireDuration", "shortShowAddTroopExpireDuration", "getShortShowAddTroopExpireDuration", "setShortShowAddTroopExpireDuration", "studyMode", "getStudyMode", "setStudyMode", "mockNoviceGuideConfig", "Lcom/tencent/state/square/guide/SquareNoviceGuideConfig;", "printAreaInfo", "", "logMsg", "areaList", "Landroid/util/SparseArray;", "Ljava/util/TreeMap;", "Lcom/tencent/state/square/ItemStruct;", "printItemStructInfo", "result", "", "printItemStructInfoMap", "", "printMoveCommandInfo", "cmdList", "", "Lcom/tencent/state/square/layout/MoveCommand;", "printMoveItemInfo", "Lcom/tencent/state/square/MoveItem;", "printMoveRequestInfo", "Lcom/tencent/state/square/layout/MoveRequest;", "printMoveResultInfo", "Lcom/tencent/state/square/MoveResult;", "printMoveViewInfo", "list", "Landroid/view/View;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class SquareDebug {
    public static final int CPU_CORE_NUM_DEFAULT = 8;
    public static final int CPU_MAX_FREQ_DEFAULT = 3000;
    public static final int RAM_SIZE_DEFAULT = 8000;
    private static final String TAG = "SquareDebug";
    private static boolean drawableMonitor;
    private static boolean enableAvatarDebugInfo;
    private static boolean enableBatteryMock;
    private static boolean enableDynamicSortDebug;
    private static boolean enableFilamentIndexDebug;
    private static boolean enableMockUnReadMsg;
    private static boolean forceShowAddTroopDialog;
    private static boolean mockNoviceGuide;
    private static boolean needShieldTeenager;
    private static boolean shortMsgBoxReadedExpireDuration;
    private static boolean shortShowAddTroopExpireDuration;
    private static boolean studyMode;
    public static final SquareDebug INSTANCE = new SquareDebug();
    private static boolean enableAddMulti = true;
    private static boolean enableFilamentDetail = true;
    private static boolean enableFilamentIndex = true;
    private static boolean enableRecordGuest = true;
    private static boolean enableRecordLand = true;
    private static boolean enableIndexUseCache = true;
    private static boolean enableChatLandUseCache = true;
    private static int cpuCoreNum = -1;
    private static int cpuMaxFreq = -1;
    private static int ramSize = -1;

    SquareDebug() {
    }

    public final int getCpuCoreNum() {
        return cpuCoreNum;
    }

    public final int getCpuMaxFreq() {
        return cpuMaxFreq;
    }

    public final boolean getDrawableMonitor() {
        return drawableMonitor;
    }

    public final boolean getEnableAddMulti() {
        return enableAddMulti;
    }

    public final boolean getEnableAvatarDebugInfo() {
        return enableAvatarDebugInfo;
    }

    public final boolean getEnableBatteryMock() {
        return enableBatteryMock;
    }

    public final boolean getEnableChatLandUseCache() {
        return enableChatLandUseCache;
    }

    public final boolean getEnableDynamicSortDebug() {
        return enableDynamicSortDebug;
    }

    public final boolean getEnableFilamentDetail() {
        return enableFilamentDetail;
    }

    public final boolean getEnableFilamentIndex() {
        return enableFilamentIndex;
    }

    public final boolean getEnableFilamentIndexDebug() {
        return enableFilamentIndexDebug;
    }

    public final boolean getEnableIndexUseCache() {
        return enableIndexUseCache;
    }

    public final boolean getEnableMockUnReadMsg() {
        return enableMockUnReadMsg;
    }

    public final boolean getEnableRecordGuest() {
        return enableRecordGuest;
    }

    public final boolean getEnableRecordLand() {
        return enableRecordLand;
    }

    public final boolean getForceShowAddTroopDialog() {
        return forceShowAddTroopDialog;
    }

    public final boolean getMockNoviceGuide() {
        return mockNoviceGuide;
    }

    public final boolean getNeedShieldTeenager() {
        return needShieldTeenager;
    }

    public final int getRamSize() {
        return ramSize;
    }

    public final boolean getShortMsgBoxReadedExpireDuration() {
        return shortMsgBoxReadedExpireDuration;
    }

    public final boolean getShortShowAddTroopExpireDuration() {
        return shortShowAddTroopExpireDuration;
    }

    public final boolean getStudyMode() {
        return studyMode;
    }

    public final SquareNoviceGuideConfig mockNoviceGuideConfig() {
        SquareNoviceGuideConfig squareNoviceGuideConfig = new SquareNoviceGuideConfig(null, null, 3, null);
        squareNoviceGuideConfig.setPublishStatusGuideConfig(new PublishStatusGuideConfig(false, 65525L, "https://vat-zplan-1251316161.file.myqcloud.com/square/noviceguidance/status_guide3.pag", true));
        squareNoviceGuideConfig.setCreateRoleGuideConfig(new CreateRoleGuideConfig(true, 65525L, "https://vat-zplan-1251316161.file.myqcloud.com/square/noviceguidance/role_born2.pag", new CreateRolePageConfig("https://vat-zplan-1251316161.file.myqcloud.com/square/noviceguidance/role_guide_alert.pag", "\u6b22\u8fce\u6765\u5230QQ\u52a8\u6001\u5e7f\u573a", "\u6253\u626e\u4e0b\u81ea\u5df1\uff0c\u548c\u670b\u53cb\u4eec\u4e00\u8d77\u73a9\u5427\uff01", "\u7acb\u5373\u88c5\u626e", "mqqapi://zplan/openPage?src_type=app&version=1.0&pageID=12&subReferer=em_square_create_avatar_guide_window"), new CreateRoleRedDotBubbleConfig(false, "\u6253\u626e\u81ea\u5df1\uff0c\u548c\u670b\u53cb\u4eec\u4e00\u8d77\u73a9\u5427\uff01", 3, "mqqapi://zplan/openPage?src_type=app&version=1.0&pageID=12&subReferer=em_square_create_avatar_guide_window")));
        return squareNoviceGuideConfig;
    }

    public final void printAreaInfo(final String logMsg, SparseArray<TreeMap<Integer, ItemStruct>> areaList) {
        Intrinsics.checkNotNullParameter(logMsg, "logMsg");
        Intrinsics.checkNotNullParameter(areaList, "areaList");
        if (Square.INSTANCE.getConfig().isDebug() && SquareBaseKt.getSquareLog().isColorLevel()) {
            if (areaList.size() <= 0) {
                SquareBaseKt.getSquareLog().d(TAG, logMsg + ", empty");
                return;
            }
            VasExtensionsKt.forEach(areaList, new Function2<Integer, TreeMap<Integer, ItemStruct>, Unit>() { // from class: com.tencent.state.SquareDebug$printAreaInfo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, TreeMap<Integer, ItemStruct> treeMap) {
                    invoke(num.intValue(), treeMap);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, TreeMap<Integer, ItemStruct> treeMap) {
                    Intrinsics.checkNotNullParameter(treeMap, "treeMap");
                    for (Map.Entry<Integer, ItemStruct> entry : treeMap.entrySet()) {
                        SquareBaseKt.getSquareLog().d("SquareDebug", logMsg + ", area:" + i3 + ", rank:" + entry.getKey().intValue() + ", " + entry.getValue());
                    }
                }
            });
        }
    }

    public final void printItemStructInfo(String logMsg, List<ItemStruct> result) {
        Intrinsics.checkNotNullParameter(logMsg, "logMsg");
        Intrinsics.checkNotNullParameter(result, "result");
        if (Square.INSTANCE.getConfig().isDebug() && SquareBaseKt.getSquareLog().isColorLevel()) {
            if (result.isEmpty()) {
                SquareBaseKt.getSquareLog().d(TAG, logMsg + ", empty");
                return;
            }
            for (ItemStruct itemStruct : result) {
                SquareBaseKt.getSquareLog().d(TAG, logMsg + ", " + itemStruct);
            }
        }
    }

    public final void printItemStructInfoMap(String logMsg, Map<Integer, ItemStruct> result) {
        Intrinsics.checkNotNullParameter(logMsg, "logMsg");
        Intrinsics.checkNotNullParameter(result, "result");
        if (Square.INSTANCE.getConfig().isDebug() && SquareBaseKt.getSquareLog().isColorLevel()) {
            if (result.isEmpty()) {
                SquareBaseKt.getSquareLog().d(TAG, logMsg + ", empty");
                return;
            }
            for (Map.Entry<Integer, ItemStruct> entry : result.entrySet()) {
                SquareBaseKt.getSquareLog().d(TAG, logMsg + ", index:" + entry.getKey().intValue() + ", " + entry.getValue());
            }
        }
    }

    public final void printMoveCommandInfo(String logMsg, List<MoveCommand> cmdList) {
        Intrinsics.checkNotNullParameter(logMsg, "logMsg");
        Intrinsics.checkNotNullParameter(cmdList, "cmdList");
        if (Square.INSTANCE.getConfig().isDebug() && SquareBaseKt.getSquareLog().isColorLevel()) {
            if (cmdList.isEmpty()) {
                SquareBaseKt.getSquareLog().d(TAG, logMsg + ", empty");
                return;
            }
            for (MoveCommand moveCommand : cmdList) {
                SquareBaseKt.getSquareLog().d(TAG, logMsg + ", " + moveCommand);
            }
        }
    }

    public final void printMoveItemInfo(String logMsg, List<MoveItem> result) {
        Intrinsics.checkNotNullParameter(logMsg, "logMsg");
        Intrinsics.checkNotNullParameter(result, "result");
        if (Square.INSTANCE.getConfig().isDebug() && SquareBaseKt.getSquareLog().isColorLevel()) {
            if (result.isEmpty()) {
                SquareBaseKt.getSquareLog().d(TAG, logMsg + ", empty");
                return;
            }
            for (MoveItem moveItem : result) {
                SquareBaseKt.getSquareLog().d(TAG, logMsg + ", type:" + moveItem.getUnitType() + ", uin:" + moveItem.getUin());
            }
        }
    }

    public final void printMoveRequestInfo(String logMsg, List<MoveRequest> result) {
        Intrinsics.checkNotNullParameter(logMsg, "logMsg");
        Intrinsics.checkNotNullParameter(result, "result");
        if (Square.INSTANCE.getConfig().isDebug() && SquareBaseKt.getSquareLog().isColorLevel()) {
            if (result.isEmpty()) {
                SquareBaseKt.getSquareLog().d(TAG, logMsg + ", empty");
                return;
            }
            for (MoveRequest moveRequest : result) {
                SquareBaseKt.getSquareLog().d(TAG, logMsg + ", " + moveRequest);
            }
        }
    }

    public final void printMoveResultInfo(String logMsg, Map<MoveItem, MoveResult> result) {
        Intrinsics.checkNotNullParameter(logMsg, "logMsg");
        Intrinsics.checkNotNullParameter(result, "result");
        if (Square.INSTANCE.getConfig().isDebug() && SquareBaseKt.getSquareLog().isColorLevel()) {
            if (result.isEmpty()) {
                SquareBaseKt.getSquareLog().d(TAG, logMsg + ", empty");
                return;
            }
            for (Map.Entry<MoveItem, MoveResult> entry : result.entrySet()) {
                SquareBaseKt.getSquareLog().d(TAG, logMsg + ", {" + entry.getKey().getUnitType() + '-' + entry.getKey().getUin() + MsgSummary.STR_COLON + entry.getValue() + '}');
            }
        }
    }

    public final void printMoveViewInfo(final String logMsg, SparseArray<View> list) {
        Intrinsics.checkNotNullParameter(logMsg, "logMsg");
        Intrinsics.checkNotNullParameter(list, "list");
        if (Square.INSTANCE.getConfig().isDebug() && SquareBaseKt.getSquareLog().isColorLevel()) {
            if (list.size() <= 0) {
                SquareBaseKt.getSquareLog().d(TAG, logMsg + ", empty");
                return;
            }
            VasExtensionsKt.forEach(list, new Function2<Integer, View, Unit>() { // from class: com.tencent.state.SquareDebug$printMoveViewInfo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, View view) {
                    invoke(num.intValue(), view);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r4v4, types: [com.tencent.state.map.MapItem] */
                /* JADX WARN: Type inference failed for: r4v8, types: [com.tencent.state.map.MapItem] */
                public final void invoke(int i3, View view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    MapViewHolder<?> mapViewHolder = MapViewKt.getMapViewHolder(view);
                    if (mapViewHolder != null) {
                        SquareLogger squareLog = SquareBaseKt.getSquareLog();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(logMsg);
                        sb5.append(", listIndex:");
                        sb5.append(i3);
                        sb5.append(", holderIndex:");
                        sb5.append(mapViewHolder.getIndex());
                        sb5.append(", type:");
                        ?? data = mapViewHolder.getData();
                        sb5.append(data != 0 ? Integer.valueOf(data.getType()) : null);
                        sb5.append(", uin:");
                        ?? data2 = mapViewHolder.getData();
                        sb5.append(data2 != 0 ? data2.getUin() : null);
                        squareLog.d("SquareDebug", sb5.toString());
                    }
                }
            });
        }
    }

    public final void setCpuCoreNum(int i3) {
        cpuCoreNum = i3;
    }

    public final void setCpuMaxFreq(int i3) {
        cpuMaxFreq = i3;
    }

    public final void setDrawableMonitor(boolean z16) {
        drawableMonitor = z16;
    }

    public final void setEnableAddMulti(boolean z16) {
        enableAddMulti = z16;
    }

    public final void setEnableAvatarDebugInfo(boolean z16) {
        enableAvatarDebugInfo = z16;
    }

    public final void setEnableBatteryMock(boolean z16) {
        enableBatteryMock = z16;
    }

    public final void setEnableChatLandUseCache(boolean z16) {
        enableChatLandUseCache = z16;
    }

    public final void setEnableDynamicSortDebug(boolean z16) {
        enableDynamicSortDebug = z16;
    }

    public final void setEnableFilamentDetail(boolean z16) {
        enableFilamentDetail = z16;
    }

    public final void setEnableFilamentIndex(boolean z16) {
        enableFilamentIndex = z16;
    }

    public final void setEnableFilamentIndexDebug(boolean z16) {
        enableFilamentIndexDebug = z16;
    }

    public final void setEnableIndexUseCache(boolean z16) {
        enableIndexUseCache = z16;
    }

    public final void setEnableMockUnReadMsg(boolean z16) {
        enableMockUnReadMsg = z16;
    }

    public final void setEnableRecordGuest(boolean z16) {
        enableRecordGuest = z16;
    }

    public final void setEnableRecordLand(boolean z16) {
        enableRecordLand = z16;
    }

    public final void setForceShowAddTroopDialog(boolean z16) {
        forceShowAddTroopDialog = z16;
    }

    public final void setMockNoviceGuide(boolean z16) {
        mockNoviceGuide = z16;
    }

    public final void setNeedShieldTeenager(boolean z16) {
        needShieldTeenager = z16;
    }

    public final void setRamSize(int i3) {
        ramSize = i3;
    }

    public final void setShortMsgBoxReadedExpireDuration(boolean z16) {
        shortMsgBoxReadedExpireDuration = z16;
    }

    public final void setShortShowAddTroopExpireDuration(boolean z16) {
        shortShowAddTroopExpireDuration = z16;
    }

    public final void setStudyMode(boolean z16) {
        studyMode = z16;
    }
}

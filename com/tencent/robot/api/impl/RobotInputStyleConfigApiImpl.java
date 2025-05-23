package com.tencent.robot.api.impl;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.aio.input.shortcutbar.RobotPlusPanelIdListEvent;
import com.tencent.robot.aio.input.styleconfig.InputStyleType;
import com.tencent.robot.api.IRobotInputStyleConfigApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/api/impl/RobotInputStyleConfigApiImpl;", "Lcom/tencent/robot/api/IRobotInputStyleConfigApi;", "", "robotUin", "", "", "getPlusPanelAppIdList", "Lcom/tencent/robot/aio/input/styleconfig/a;", "inputStyleConfig", "", "saveInputStyleConfigToMMKV", "getInputStyleConfigFromMMKV", "createDefaultInputStyleConfig", "deleteInputStyleConfigFromMMKV", "<init>", "()V", "Companion", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotInputStyleConfigApiImpl implements IRobotInputStyleConfigApi {

    @NotNull
    private static final String KEY_INPUT_STYLE_CONFIG = "_key_qq_robot_input_style_config_json_";

    @NotNull
    private static final String KEY_INPUT_STYLE_PLUS_LIST = "plusPanelAppIdList";

    @NotNull
    private static final String KEY_INPUT_STYLE_SHORTCUT_LIST = "shortcutIdList";

    @NotNull
    private static final String KEY_INPUT_STYLE_SLASH_PLANE = "isSupportSlashPanel";

    @NotNull
    private static final String KEY_INPUT_STYLE_TYPE = "inputStyleType";

    @NotNull
    private static final String TAG = "RobotInputStyleConfigApiImpl";

    @Override // com.tencent.robot.api.IRobotInputStyleConfigApi
    @NotNull
    public com.tencent.robot.aio.input.styleconfig.a createDefaultInputStyleConfig() {
        List emptyList;
        List emptyList2;
        InputStyleType inputStyleType = InputStyleType.STYLE_SINGLE_BASE;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        return new com.tencent.robot.aio.input.styleconfig.a(inputStyleType, emptyList, emptyList2, false);
    }

    @Override // com.tencent.robot.api.IRobotInputStyleConfigApi
    public void deleteInputStyleConfigFromMMKV(@Nullable String robotUin) {
        boolean z16;
        String str;
        if (robotUin != null && robotUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").removeKey(str + KEY_INPUT_STYLE_CONFIG + robotUin);
    }

    @Override // com.tencent.robot.api.IRobotInputStyleConfigApi
    @Nullable
    public com.tencent.robot.aio.input.styleconfig.a getInputStyleConfigFromMMKV(@Nullable String robotUin) {
        boolean z16;
        String str;
        boolean z17;
        if (robotUin != null && robotUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        String jsonString = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString(str + KEY_INPUT_STYLE_CONFIG + robotUin, "");
        Intrinsics.checkNotNullExpressionValue(jsonString, "jsonString");
        if (jsonString.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            try {
                JSONObject jSONObject = new JSONObject(jsonString);
                String optString = jSONObject.optString(KEY_INPUT_STYLE_TYPE, InputStyleType.STYLE_DEFAULT.name());
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(KEY\u2026eType.STYLE_DEFAULT.name)");
                InputStyleType valueOf = InputStyleType.valueOf(optString);
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray(KEY_INPUT_STYLE_SHORTCUT_LIST);
                if (optJSONArray != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(KEY_INPUT_STYLE_SHORTCUT_LIST)");
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        arrayList.add(Integer.valueOf(optJSONArray.getInt(i3)));
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                JSONArray optJSONArray2 = jSONObject.optJSONArray(KEY_INPUT_STYLE_PLUS_LIST);
                if (optJSONArray2 != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONArray2, "optJSONArray(KEY_INPUT_STYLE_PLUS_LIST)");
                    int length2 = optJSONArray2.length();
                    for (int i16 = 0; i16 < length2; i16++) {
                        arrayList2.add(Integer.valueOf(optJSONArray2.getInt(i16)));
                    }
                }
                return new com.tencent.robot.aio.input.styleconfig.a(valueOf, arrayList, arrayList2, jSONObject.optBoolean(KEY_INPUT_STYLE_SLASH_PLANE, false));
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getInputStyleConfigFromMMKV " + e16.getMessage());
            }
        }
        return null;
    }

    @Override // com.tencent.robot.api.IRobotInputStyleConfigApi
    @NotNull
    public List<Integer> getPlusPanelAppIdList(@Nullable String robotUin) {
        boolean z16;
        List<Integer> emptyList;
        if (robotUin != null && robotUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        RobotPlusPanelIdListEvent robotPlusPanelIdListEvent = new RobotPlusPanelIdListEvent(robotUin, new ArrayList());
        SimpleEventBus.getInstance().dispatchEvent(robotPlusPanelIdListEvent);
        return robotPlusPanelIdListEvent.getIdList();
    }

    @Override // com.tencent.robot.api.IRobotInputStyleConfigApi
    public void saveInputStyleConfigToMMKV(@Nullable String robotUin, @NotNull com.tencent.robot.aio.input.styleconfig.a inputStyleConfig) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(inputStyleConfig, "inputStyleConfig");
        if (robotUin != null && robotUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentUin();
            } else {
                str = null;
            }
            if (str == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY_INPUT_STYLE_TYPE, inputStyleConfig.getInputStyleType().name());
            jSONObject.put(KEY_INPUT_STYLE_SHORTCUT_LIST, new JSONArray((Collection) inputStyleConfig.c()));
            jSONObject.put(KEY_INPUT_STYLE_PLUS_LIST, new JSONArray((Collection) inputStyleConfig.b()));
            jSONObject.put(KEY_INPUT_STYLE_SLASH_PLANE, inputStyleConfig.getIsSupportSlashPanel());
            QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeString(str + KEY_INPUT_STYLE_CONFIG + robotUin, jSONObject.toString());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "saveInputStyleConfigToMMKV " + e16.getMessage());
        }
    }
}

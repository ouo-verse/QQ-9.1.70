package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt;
import com.tencent.hippykotlin.demo.pages.foundation.density.QQHostCustomDensity;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQCommonNApiModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenThemeMode;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.ntcompose.activity.ComponentActivity;
import com.tencent.ntcompose.activity.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public class BaseComponentActivity extends ComponentActivity {
    public QQHostCustomDensity hostCustomDensity;
    public MutableState<Boolean> nightModel;

    public BaseComponentActivity() {
        MutableState<Boolean> mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.nightModel = mutableStateOf$default;
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public Map<String, Module> createExternalModules() {
        HashMap hashMap = new HashMap();
        CommonModulesKt.registerCommonModules(getPager());
        return hashMap;
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity, com.tencent.kuikly.core.pager.b
    public final boolean debugUIInspector() {
        if (!getPageData().getIsAccessibilityRunning() && getPageData().u()) {
            return getPageData().n().g("isDevDebug", false);
        }
        return false;
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity, com.tencent.kuikly.core.pager.b
    public final boolean isNightMode() {
        super.isNightMode();
        if (this.nightModel.getValue() == null) {
            updateNightModeValue(getPageData().n());
        }
        Boolean value = this.nightModel.getValue();
        if (value != null) {
            return value.booleanValue();
        }
        return false;
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public void onCreate(a aVar) {
        super.onCreate(aVar);
        QUITokenThemeMode quiTokenThemeMode = quiTokenThemeMode();
        if (quiTokenThemeMode != null) {
            getPager().getExtProps().put("quiTokenThemeMode", quiTokenThemeMode);
        }
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity, com.tencent.kuikly.core.pager.b
    public void onCreatePager(String str, e eVar) {
        com.tencent.kuikly.core.nvi.serialization.json.a aVar = com.tencent.kuikly.core.nvi.serialization.json.a.f117418a;
        aVar.b(true);
        e m3 = eVar.m("param");
        if (Intrinsics.areEqual(m3 != null ? m3.p("kr_fast_json") : null, DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
            aVar.b(false);
        }
        super.onCreatePager(str, eVar);
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public void pageWillDestroy() {
        super.pageWillDestroy();
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity, com.tencent.kuikly.core.pager.b
    public final float pagerDensity() {
        Float f16;
        if (this.hostCustomDensity == null) {
            QQHostCustomDensity qQHostCustomDensity = new QQHostCustomDensity();
            qQHostCustomDensity.init(getPageData());
            this.hostCustomDensity = qQHostCustomDensity;
        }
        QQHostCustomDensity qQHostCustomDensity2 = this.hostCustomDensity;
        if (qQHostCustomDensity2 != null) {
            if (!Intrinsics.areEqual(qQHostCustomDensity2.useHostDisplayMetrics, Boolean.TRUE) || (f16 = qQHostCustomDensity2.hostDensity) == null) {
                f16 = null;
            }
            if (f16 != null) {
                return f16.floatValue();
            }
        }
        return super.pagerDensity();
    }

    public QUITokenThemeMode quiTokenThemeMode() {
        return null;
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void themeDidChanged(e eVar) {
        super.themeDidChanged(eVar);
        updateNightModeValue(eVar);
    }

    public final void updateNightModeValue(e eVar) {
        this.nightModel.setValue(Boolean.valueOf(eVar.f(MiniGamePAHippyBaseFragment.KEY_THEME)));
        Boolean value = this.nightModel.getValue();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(value, bool) || quiTokenThemeMode() != QUITokenThemeMode.ONLY_DAY_AND_NIGHT) {
            return;
        }
        QQCommonNApiModule.Companion companion = QQCommonNApiModule.Companion;
        if (((QQCommonNApiModule) c.f117352a.g().acquireModule("QQCommonNApiModule")).isDarkTheme()) {
            this.nightModel.setValue(bool);
        }
    }
}

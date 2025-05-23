package com.tencent.hippykotlin.demo.pages.base;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt;
import com.tencent.hippykotlin.demo.pages.foundation.density.QQHostCustomDensity;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQCommonNApiModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenThemeMode;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.a;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes31.dex */
public abstract class BasePager extends Pager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BasePager.class, "nightModel", "getNightModel()Ljava/lang/Boolean;", 0)};
    public QQHostCustomDensity hostCustomDensity;
    public final ReadWriteProperty nightModel$delegate = c.a(null);
    public boolean pagerAppear = true;

    @Override // com.tencent.kuikly.core.pager.Pager
    public Map<String, Module> createExternalModules() {
        HashMap hashMap = new HashMap();
        CommonModulesKt.registerCommonModules(this);
        return hashMap;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public void created() {
        super.created();
        QUITokenThemeMode quiTokenThemeMode = quiTokenThemeMode();
        if (quiTokenThemeMode != null) {
            getExtProps().put("quiTokenThemeMode", quiTokenThemeMode);
        }
        isNightMode();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public boolean debugUIInspector() {
        if (getPageData().u()) {
            return getPageData().n().g("isDevDebug", false);
        }
        return false;
    }

    public final Boolean getNightModel() {
        return (Boolean) this.nightModel$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final boolean isNightMode() {
        super.isNightMode();
        if (getNightModel() == null) {
            updateNightModeValue(getPageData().n());
        }
        Boolean nightModel = getNightModel();
        Intrinsics.checkNotNull(nightModel);
        return nightModel.booleanValue();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void onCreatePager(String str, e eVar) {
        a aVar = a.f117418a;
        aVar.b(true);
        e m3 = eVar.m("param");
        if (Intrinsics.areEqual(m3 != null ? m3.p("kr_fast_json") : null, DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
            aVar.b(false);
        }
        super.onCreatePager(str, eVar);
    }

    @Override // com.tencent.kuikly.core.pager.Pager
    public void pageDidAppear() {
        super.pageDidAppear();
        this.pagerAppear = true;
    }

    @Override // com.tencent.kuikly.core.pager.Pager
    public void pageDidDisappear() {
        super.pageDidDisappear();
        this.pagerAppear = false;
    }

    @Override // com.tencent.kuikly.core.pager.Pager
    public void pageWillDestroy() {
        super.pageWillDestroy();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
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

    @Override // com.tencent.kuikly.core.pager.Pager
    public void themeDidChanged(e eVar) {
        super.themeDidChanged(eVar);
        updateNightModeValue(eVar);
    }

    public final void updateNightModeValue(e eVar) {
        Boolean valueOf = Boolean.valueOf(eVar.f(MiniGamePAHippyBaseFragment.KEY_THEME));
        ReadWriteProperty readWriteProperty = this.nightModel$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        readWriteProperty.setValue(this, kPropertyArr[0], valueOf);
        Boolean nightModel = getNightModel();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(nightModel, bool) || quiTokenThemeMode() != QUITokenThemeMode.ONLY_DAY_AND_NIGHT) {
            return;
        }
        QQCommonNApiModule.Companion companion = QQCommonNApiModule.Companion;
        if (((QQCommonNApiModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQCommonNApiModule")).isDarkTheme()) {
            this.nightModel$delegate.setValue(this, kPropertyArr[0], bool);
        }
    }
}

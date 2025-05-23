package com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQContext;
import com.tencent.kuikly.core.coroutines.e;
import com.tencent.kuikly.core.manager.c;
import h25.ar;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieSettingComposeViewModel {
    public MutableState<Boolean> accessible;
    public final AdelieKuiklyBaseModule adelieKuiklyBaseModule;
    public MutableState<ar> assistantInfo;
    public final e requestScope = e.f117232d;

    public AdelieSettingComposeViewModel() {
        MutableState<Boolean> mutableStateOf$default;
        MutableState<ar> mutableStateOf$default2;
        AdelieKuiklyBaseModule adelieKuiklyBaseModule = (AdelieKuiklyBaseModule) c.f117352a.g().acquireModule("AdelieKuiklyBaseModule");
        this.adelieKuiklyBaseModule = adelieKuiklyBaseModule;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("is_switch_on_");
        m3.append(QQContext.INSTANCE.getUin());
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(Boolean.parseBoolean(AdelieKuiklyBaseModule.getStringFromCache$default(adelieKuiklyBaseModule, m3.toString(), "false", 12))), null, 2, null);
        this.accessible = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.assistantInfo = mutableStateOf$default2;
    }
}

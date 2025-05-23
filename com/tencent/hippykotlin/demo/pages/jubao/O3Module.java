package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class O3Module extends Module {
    public final String hmac(String str, String str2) {
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("content", str, "key", str2);
        Unit unit = Unit.INSTANCE;
        return toNative(false, "hmac", m3.toString(), null, true).toString();
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "QQKuiklySecurityModule";
    }

    public final void sendRequest(String str, e eVar, Function1<? super e, Unit> function1) {
        e eVar2 = new e();
        eVar2.v("cmd", str);
        eVar2.v("data", eVar);
        Unit unit = Unit.INSTANCE;
        toNative(false, "sendRequest", eVar2.toString(), function1, false);
    }

    public final void uploadChatMsgs(String str, String str2, String str3, String str4, String str5, String str6, Function1<? super e, Unit> function1) {
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m(IECDtReport.ACTION_IDENTIFIER, str, "chatuin", str2);
        m3.v("chattype", str3);
        m3.v("groupcode", str4);
        m3.v("eviluin", str5);
        m3.v("msgs", str6);
        Unit unit = Unit.INSTANCE;
        toNative(false, "uploadChatMsgs", m3.toString(), function1, false);
    }

    public final void dismiss() {
        toNative(false, "dismiss", "", null, false);
    }

    public final void floatingViewSlideToMaxHeight() {
        updateFloatingView$default(this, 3, 580, Boolean.FALSE, null, 20);
    }

    public final void floatingViewSlideToMidHeight() {
        updateFloatingView$default(this, 2, 400, Boolean.TRUE, null, 20);
    }

    public static void updateFloatingView$default(O3Module o3Module, int i3, Integer num, Boolean bool, Boolean bool2, int i16) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        if ((i16 & 2) != 0) {
            num = null;
        }
        if ((i16 & 8) != 0) {
            bool = null;
        }
        if ((i16 & 16) != 0) {
            bool2 = null;
        }
        o3Module.getClass();
        e eVar = new e();
        if (i3 != 0) {
            eVar.t("heightType", BoxType$EnumUnboxingSharedUtility.ordinal(i3));
        }
        if (num != null) {
            eVar.t("height", num.intValue());
        }
        if (bool != null) {
            eVar.w("enableDefaultHeight", bool.booleanValue());
        }
        if (bool2 != null) {
            eVar.w("contentDraggable", bool2.booleanValue());
        }
        Unit unit = Unit.INSTANCE;
        o3Module.toNative(false, "updateFloatingView", eVar.toString(), null, false);
    }
}

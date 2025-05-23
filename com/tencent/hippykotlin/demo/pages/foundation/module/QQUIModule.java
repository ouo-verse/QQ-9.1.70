package com.tencent.hippykotlin.demo.pages.foundation.module;

import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQUtils;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenThemeMode;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQUIModule extends Module {

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[QUITokenThemeMode.values().length];
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void openAlertDialog$default(QQUIModule qQUIModule, String str, String str2, String str3, String str4, Function2 function2) {
        qQUIModule.openAlertDialog(str, str2, str3, str4, "", false, function2);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "QQUIModule";
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        if (com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken.INSTANCE.isNightMode() != false) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void openAlertDialog(String str, String str2, String str3, String str4, String str5, boolean z16, final Function2<? super Boolean, ? super Boolean, Unit> function2) {
        b g16 = c.f117352a.g();
        Pager pager = g16 instanceof Pager ? (Pager) g16 : null;
        QUITokenThemeMode quiTokenThemeMode = pager != null ? QUITokenKt.quiTokenThemeMode(pager) : null;
        int i3 = quiTokenThemeMode == null ? -1 : WhenMappings.$EnumSwitchMapping$0[quiTokenThemeMode.ordinal()];
        String str6 = "day";
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    str6 = "";
                }
            }
            str6 = "night";
        }
        if (!(QQUtils.INSTANCE.compare("9.0.65") >= 0)) {
            if (function2 != null) {
                function2.invoke(Boolean.TRUE, Boolean.FALSE);
                return;
            }
            return;
        }
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("titleText", str, "contentText", str2);
        m3.v("leftButtonText", str3);
        m3.v("rightButtonText", str4);
        m3.v("checkText", str5);
        m3.w("checked", z16);
        m3.v("theme", str6);
        Unit unit = Unit.INSTANCE;
        toNative(false, "openAlertDialog", m3.toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule$openAlertDialog$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
            
                if (r5.g("isRightButtonClick", false) == true) goto L8;
             */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(e eVar) {
                boolean z17;
                e eVar2 = eVar;
                if (eVar2 != null) {
                    z17 = true;
                }
                z17 = false;
                if (z17) {
                    Function2<Boolean, Boolean, Unit> function22 = function2;
                    if (function22 != null) {
                        function22.invoke(Boolean.TRUE, Boolean.valueOf(eVar2.g("checked", false)));
                    }
                } else {
                    Function2<Boolean, Boolean, Unit> function23 = function2;
                    if (function23 != null) {
                        Boolean bool = Boolean.FALSE;
                        function23.invoke(bool, bool);
                    }
                }
                return Unit.INSTANCE;
            }
        }, true);
    }
}

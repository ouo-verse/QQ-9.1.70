package com.tencent.hippykotlin.demo.pages.vas_base.report.keport;

import b01.b;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.vas_base.SessionIdGenerator;
import com.tencent.hippykotlin.demo.pages.vas_base.report.Utils;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zz0.a;

/* loaded from: classes33.dex */
public final class LogParam implements b {
    public static final Lazy<String> platform$delegate;
    public final String content;
    public final e custom;
    public final int level;
    public final String module;
    public static final Companion Companion = new Companion();
    public static final long baseTime = a.f453719a.a();
    public static final String sessionId = SessionIdGenerator.INSTANCE.getSessionId();

    /* loaded from: classes33.dex */
    public static final class Companion {
    }

    static {
        Lazy<String> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.keport.LogParam$Companion$platform$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return Utils.INSTANCE.platform();
            }
        });
        platform$delegate = lazy;
    }

    public LogParam(int i3, String str, String str2, e eVar) {
        this.level = i3;
        this.content = str;
        this.module = str2;
        this.custom = eVar;
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.module, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.content, BoxType$EnumUnboxingSharedUtility.ordinal(this.level) * 31, 31), 31);
        e eVar = this.custom;
        return m3 + (eVar == null ? 0 : eVar.hashCode());
    }

    @Override // b01.b
    public final e serialization() {
        final long a16 = a.f453719a.a();
        return new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.keport.LogParam$serialization$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                eVar2.z("timestamps", Long.valueOf(a16));
                eVar2.z("offsetTime", Long.valueOf(a16 - LogParam.baseTime));
                eVar2.z("level", LogLevel$EnumUnboxingLocalUtility.getTag(this.level));
                eVar2.z("content", this.content);
                eVar2.z("platform", LogParam.platform$delegate.getValue());
                c cVar = c.f117352a;
                eVar2.z("appVersion", cVar.g().getPageData().getAppVersion());
                eVar2.z("resVersion", Long.valueOf(PageDataExtKt.getResVersion(cVar.g().getPageData())));
                eVar2.z("uin", cVar.g().getPageData().n().q("uin", ""));
                eVar2.z("page", cVar.g().getPageName());
                eVar2.z("module", this.module);
                eVar2.z("network", Utils.INSTANCE.network());
                eVar2.z("sessionId", LogParam.sessionId);
                eVar2.z("custom", this.custom);
                return Unit.INSTANCE;
            }
        });
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("LogParam(level=");
        m3.append(LogLevel$EnumUnboxingLocalUtility.stringValueOf(this.level));
        m3.append(", content=");
        m3.append(this.content);
        m3.append(", module=");
        m3.append(this.module);
        m3.append(", custom=");
        m3.append(this.custom);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogParam)) {
            return false;
        }
        LogParam logParam = (LogParam) obj;
        return this.level == logParam.level && Intrinsics.areEqual(this.content, logParam.content) && Intrinsics.areEqual(this.module, logParam.module) && Intrinsics.areEqual(this.custom, logParam.custom);
    }
}

package com.tencent.hippykotlin.demo.pages.nearby.mood_group.data;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Point;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class UtilsKt {
    public static final Point parsePointFromJson(e eVar) {
        if (eVar == null) {
            KLog.INSTANCE.e("NBPMoodGroupConfig", "parsePoint jsonObj is null");
            return null;
        }
        return new Point((float) eVar.h(HippyTKDListViewAdapter.X), (float) eVar.h("y"));
    }

    public static final w parseSizeFromJson(e eVar) {
        if (eVar == null) {
            KLog.INSTANCE.e("NBPMoodGroupConfig", "parseSize jsonObj is null");
            return null;
        }
        return new w((float) eVar.h("width"), (float) eVar.h("height"));
    }

    public static final h toColor(String str) {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, RelationNTPushServiceImpl.PRE_HEX_STRING, false, 2, null);
        if (startsWith$default) {
            return new h(h.INSTANCE.o(str));
        }
        return QUIToken.color$default(str);
    }
}

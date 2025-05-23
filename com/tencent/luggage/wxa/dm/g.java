package com.tencent.luggage.wxa.dm;

import android.webkit.URLUtil;
import com.tencent.luggage.wxa.dm.e;
import com.tencent.luggage.wxa.ic.l;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f124389a = new HashMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements e.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.dm.e.a
        public final void b(int i3) {
            if (i3 >= 0) {
                g.this.f124389a.put(Integer.valueOf(i3), null);
            }
        }
    }

    public final e a(String iconPath, d errorHandler, l service, int i3) {
        Intrinsics.checkNotNullParameter(iconPath, "iconPath");
        Intrinsics.checkNotNullParameter(errorHandler, "errorHandler");
        Intrinsics.checkNotNullParameter(service, "service");
        e a16 = a(iconPath, errorHandler, service);
        a16.a(i3);
        a16.a(new a());
        e eVar = (e) this.f124389a.get(Integer.valueOf(i3));
        if (eVar != null) {
            eVar.a();
        }
        this.f124389a.put(Integer.valueOf(i3), a16);
        return a16;
    }

    public final e a(String str, d dVar, l lVar) {
        boolean startsWith$default;
        if (true != (URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str))) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "wxfile://", false, 2, null);
            if (true == startsWith$default) {
                return new j(str, dVar, lVar);
            }
            if (true == a(str)) {
                return new i(str, dVar, lVar);
            }
            return new c(str, dVar);
        }
        return new h(str, dVar, lVar);
    }

    public final boolean a(String str) {
        boolean endsWith$default;
        boolean endsWith$default2;
        boolean endsWith$default3;
        boolean endsWith$default4;
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, ".png", false, 2, null);
        if (!endsWith$default) {
            endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(str, ".jpg", false, 2, null);
            if (!endsWith$default2) {
                endsWith$default3 = StringsKt__StringsJVMKt.endsWith$default(str, ".bmp", false, 2, null);
                if (!endsWith$default3) {
                    endsWith$default4 = StringsKt__StringsJVMKt.endsWith$default(str, QzoneEmotionUtils.SIGN_ICON_URL_END, false, 2, null);
                    if (!endsWith$default4) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

package com.tencent.android.androidbypass.richui.event;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ(\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u001e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000b\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/android/androidbypass/richui/event/b;", "", "Lorg/json/JSONObject;", "jsonObject", "dataJson", "Ljava/util/ArrayList;", "Lcom/tencent/android/androidbypass/richui/event/c;", "Lkotlin/collections/ArrayList;", "c", "Lcom/tencent/android/androidbypass/richui/event/g;", h.F, "", "value", "", "i", "", "g", "Lcom/tencent/android/androidbypass/richui/event/e;", "e", "Lcom/tencent/android/androidbypass/richui/event/f;", "f", "Lcom/tencent/android/androidbypass/richui/event/d;", "d", "Lcom/tencent/android/androidbypass/richui/event/a;", "b", "key", "a", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final b f72325a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18567);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f72325a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    private final ArrayList<c> c(JSONObject jsonObject, JSONObject dataJson) {
        ArrayList<c> arrayList = new ArrayList<>();
        if (jsonObject.has("visibleCtr")) {
            JSONObject jSONObject = jsonObject.getJSONObject("visibleCtr");
            Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObject.getJSONObject\u2026nstants.EVENT_VISIBLECTR)");
            g h16 = h(jSONObject, dataJson);
            if (h16 != null) {
                arrayList.add(h16);
            }
        }
        if (jsonObject.has("resetLayout")) {
            JSONObject jSONObject2 = jsonObject.getJSONObject("resetLayout");
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.getJSONObject\u2026stants.EVENT_RESETLAYOUT)");
            e e16 = e(jSONObject2, dataJson);
            if (e16 != null) {
                arrayList.add(e16);
            }
        }
        if (jsonObject.has("resetWidth")) {
            JSONObject jSONObject3 = jsonObject.getJSONObject("resetWidth");
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonObject.getJSONObject\u2026nstants.EVENT_RESETWIDTH)");
            f f16 = f(jSONObject3, dataJson);
            if (f16 != null) {
                arrayList.add(f16);
            }
        }
        if (jsonObject.has("resetHeight")) {
            JSONObject jSONObject4 = jsonObject.getJSONObject("resetHeight");
            Intrinsics.checkNotNullExpressionValue(jSONObject4, "jsonObject.getJSONObject\u2026stants.EVENT_RESETHEIGHT)");
            d d16 = d(jSONObject4, dataJson);
            if (d16 != null) {
                arrayList.add(d16);
            }
        }
        return arrayList;
    }

    private final d d(JSONObject jsonObject, JSONObject dataJson) {
        try {
            String a16 = a(jsonObject, dataJson, "height");
            if (!TextUtils.isEmpty(a16)) {
                d dVar = new d();
                dVar.b(Float.parseFloat(a16));
                if (dVar.a() > 0.0f) {
                    return dVar;
                }
            }
            return null;
        } catch (Exception e16) {
            com.tencent.android.androidbypass.config.a.f72049a.e("EventUtils", "parseResetHeight " + e16);
            return null;
        }
    }

    private final e e(JSONObject jsonObject, JSONObject dataJson) {
        try {
            e eVar = new e();
            eVar.f(Boolean.parseBoolean(a(jsonObject, dataJson, "needReset")));
            if (!eVar.b()) {
                return null;
            }
            eVar.e((float) jsonObject.optDouble("height"));
            eVar.h((float) jsonObject.optDouble("width"));
            eVar.g((float) jsonObject.optDouble("ratio"));
            return eVar;
        } catch (Exception e16) {
            com.tencent.android.androidbypass.config.a.f72049a.e("EventUtils", "parseResetLayout " + e16);
            return null;
        }
    }

    private final f f(JSONObject jsonObject, JSONObject dataJson) {
        try {
            String a16 = a(jsonObject, dataJson, "width");
            if (!TextUtils.isEmpty(a16)) {
                f fVar = new f();
                fVar.b(Float.parseFloat(a16));
                if (fVar.a() > 0.0f) {
                    return fVar;
                }
            }
            return null;
        } catch (Exception e16) {
            com.tencent.android.androidbypass.config.a.f72049a.e("EventUtils", "parseResetWidth " + e16);
            return null;
        }
    }

    private final int g(String value) {
        if (value != null) {
            int hashCode = value.hashCode();
            if (hashCode != -1901805651) {
                if (hashCode == 3178655 && value.equals("gone")) {
                    return 3;
                }
            } else if (value.equals(QZoneJsConstants.DYNAMIC_ALBUM_INVISIBLE)) {
                return 1;
            }
        }
        return 0;
    }

    private final g h(JSONObject jsonObject, JSONObject dataJson) {
        try {
            g gVar = new g();
            com.tencent.android.androidbypass.richui.utils.a aVar = com.tencent.android.androidbypass.richui.utils.a.f72343a;
            gVar.e(i(aVar.a(jsonObject, dataJson, NodeProps.VISIBLE)));
            gVar.f(g(jsonObject.optString("visibleBehave")));
            gVar.d(aVar.a(jsonObject, dataJson, "src"));
            return gVar;
        } catch (Exception e16) {
            com.tencent.android.androidbypass.config.a.f72049a.e("EventUtils", "parseVisibleCtr " + e16);
            return null;
        }
    }

    private final boolean i(String value) {
        boolean equals$default;
        if (!TextUtils.isEmpty(value)) {
            equals$default = StringsKt__StringsJVMKt.equals$default(value, "false", false, 2, null);
            if (!equals$default) {
                StringsKt__StringsJVMKt.equals$default(value, "true", false, 2, null);
                return true;
            }
            return false;
        }
        return false;
    }

    @NotNull
    public final String a(@NotNull JSONObject jsonObject, @NotNull JSONObject dataJson, @NotNull String key) {
        boolean startsWith$default;
        String removePrefix;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, jsonObject, dataJson, key);
        }
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(dataJson, "dataJson");
        Intrinsics.checkNotNullParameter(key, "key");
        String content = jsonObject.optString(key);
        Intrinsics.checkNotNullExpressionValue(content, "content");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(content, "$$", false, 2, null);
        if (startsWith$default) {
            removePrefix = StringsKt__StringsKt.removePrefix(content, (CharSequence) "$$");
            content = dataJson.optString(removePrefix);
        }
        Intrinsics.checkNotNullExpressionValue(content, "content");
        return content;
    }

    @Nullable
    public final a b(@Nullable JSONObject jsonObject, @NotNull JSONObject dataJson) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (a) iPatchRedirector.redirect((short) 1, (Object) this, (Object) jsonObject, (Object) dataJson);
        }
        Intrinsics.checkNotNullParameter(dataJson, "dataJson");
        if (jsonObject != null) {
            a aVar = new a();
            if (jsonObject.has("init")) {
                b bVar = f72325a;
                JSONObject jSONObject = jsonObject.getJSONObject("init");
                Intrinsics.checkNotNullExpressionValue(jSONObject, "it.getJSONObject(EventConstants.EVENT_INIT)");
                aVar.b(bVar.c(jSONObject, dataJson));
            }
            if (jsonObject.has("update")) {
                b bVar2 = f72325a;
                JSONObject jSONObject2 = jsonObject.getJSONObject("update");
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "it.getJSONObject(EventConstants.EVENT_UPDATE)");
                aVar.c(bVar2.c(jSONObject2, dataJson));
            }
            return aVar;
        }
        return null;
    }
}

package jc2;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Ljc2/a;", "", "", "content", "Ljc2/b;", "a", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f409780a = new a();

    a() {
    }

    @JvmStatic
    @NotNull
    public static final b a(@NotNull String content) {
        int i3;
        int i16;
        JSONObject jSONObject;
        HashMap<String, String> hashMap;
        Intrinsics.checkNotNullParameter(content, "content");
        b bVar = new b(new ArrayList(), "", new HashMap());
        try {
            JSONObject jSONObject2 = new JSONObject(content);
            QLog.d("AutoOnlineStatusParser", 1, "[status][parser] parse json: " + jSONObject2);
            try {
                String optString = jSONObject2.optString("weather_jump_schema", "");
                if (optString != null) {
                    bVar.f409781a = optString;
                }
                JSONArray optJSONArray = jSONObject2.optJSONArray("weather_url");
                if (optJSONArray != null) {
                    i3 = optJSONArray.length();
                } else {
                    i3 = 0;
                }
                int i17 = 0;
                while (true) {
                    JSONObject jSONObject3 = null;
                    if (i17 >= i3) {
                        break;
                    }
                    if (optJSONArray != null) {
                        jSONObject3 = optJSONArray.getJSONObject(i17);
                    }
                    if (jSONObject3 != null) {
                        String optString2 = jSONObject3.optString("weather_id", "");
                        String optString3 = jSONObject3.optString("weather_small_url", "");
                        String optString4 = jSONObject3.optString("weather_big_url", "");
                        String optString5 = jSONObject3.optString("weather_aio_url", "");
                        bVar.f409782b.add(new c(optString2, optString3, optString4, optString5, jSONObject3.optString("big_url", optString5)));
                    }
                    i17++;
                }
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("ext_icon");
                if (optJSONArray2 != null) {
                    i16 = optJSONArray2.length();
                } else {
                    i16 = 0;
                }
                for (int i18 = 0; i18 < i16; i18++) {
                    if (optJSONArray2 != null) {
                        jSONObject = optJSONArray2.getJSONObject(i18);
                    } else {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        String optString6 = jSONObject.optString("icon_key", "");
                        String optString7 = jSONObject.optString("icon_url", "");
                        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7) && (hashMap = bVar.f409783c) != null) {
                            hashMap.put(optString6, optString7);
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.e("AutoOnlineStatusParser", 1, "parse " + e16);
            }
            return bVar;
        } catch (JSONException e17) {
            QLog.e("AutoOnlineStatusParser", 1, "parse " + e17);
            return bVar;
        }
    }
}

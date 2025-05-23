package com.tencent.qqnt.aio.assistedchat.cache;

import android.util.Base64;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0000*\u00020\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/cache/a;", "", "b", "a", "aio_ext_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0024 A[Catch: Exception -> 0x003c, TryCatch #0 {Exception -> 0x003c, blocks: (B:3:0x0008, B:5:0x0017, B:12:0x0024, B:14:0x0035, B:15:0x0037), top: B:2:0x0008 }] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final a a(@NotNull String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("data");
            if (optString != null && optString.length() != 0) {
                z16 = false;
                if (!z16) {
                    return null;
                }
                byte[] decode = Base64.decode(optString, 0);
                long optLong = jSONObject.optLong("timestamp", 0L);
                if (decode == null) {
                    decode = new byte[0];
                }
                return new a(decode, optLong);
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Exception e16) {
            QLog.e("AssistedChatCacheEntity", 1, "toCacheEntity exception: ", e16);
            return null;
        }
    }

    @Nullable
    public static final String b(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        try {
            JSONObject jSONObject = new JSONObject();
            boolean z16 = false;
            String encodeToString = Base64.encodeToString(aVar.a(), 0);
            if (encodeToString == null || encodeToString.length() == 0) {
                z16 = true;
            }
            if (!z16) {
                jSONObject.put("data", encodeToString);
            }
            jSONObject.put("timestamp", aVar.b());
            return jSONObject.toString();
        } catch (Exception e16) {
            QLog.e("AssistedChatCacheEntity", 1, "toJson exception: ", e16);
            return null;
        }
    }
}

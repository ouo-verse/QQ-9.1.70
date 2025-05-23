package a52;

import android.text.TextUtils;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.icgame.data.message.LiveMessageData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import rt0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/icgame/data/message/LiveMessageData$SpeakerInfo;", "speakerInfo", "La52/c;", "b", "", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "Lpy0/b;", "a", "ic-game-widget-kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d {
    private static final py0.b a(byte[] bArr) {
        try {
            py0.b[] bVarArr = py0.a.c(bArr).f428044a;
            Intrinsics.checkNotNullExpressionValue(bVarArr, "businessData.rptMsgDataItem");
            for (py0.b bVar : bVarArr) {
                if (bVar.f428046a == 37) {
                    return bVar;
                }
            }
            return null;
        } catch (InvalidProtocolBufferNanoException e16) {
            a.Companion companion = rt0.a.INSTANCE;
            String message = e16.getMessage();
            if (message == null) {
                message = "";
            }
            companion.a("ICGameShare|ShareUserUtil", "parse data failed:", message);
            return null;
        }
    }

    @Nullable
    public static final ShareUserInfo b(@NotNull LiveMessageData.SpeakerInfo speakerInfo) {
        String str = "";
        Intrinsics.checkNotNullParameter(speakerInfo, "speakerInfo");
        byte[] bArr = speakerInfo.mBusinessData;
        if (bArr != null) {
            try {
                Intrinsics.checkNotNullExpressionValue(bArr, "speakerInfo.mBusinessData");
                py0.b a16 = a(bArr);
                if (a16 != null && !TextUtils.isEmpty(a16.f428047b)) {
                    JSONObject jSONObject = new JSONObject(a16.f428047b);
                    long optLong = jSONObject.optLong("sharerUID", 0L);
                    String optString = jSONObject.optString("sharerNick", "");
                    Intrinsics.checkNotNullExpressionValue(optString, "jsonObj.optString(\"sharerNick\", \"\")");
                    ShareUserInfo shareUserInfo = new ShareUserInfo(optLong, optString);
                    rt0.a.INSTANCE.k("ICGameShare|ShareUserUtil", "parse share user", String.valueOf(shareUserInfo));
                    return shareUserInfo;
                }
                rt0.a.INSTANCE.k("ICGameShare|ShareUserUtil", "get bypass data", "data is null");
                return null;
            } catch (JSONException e16) {
                a.Companion companion = rt0.a.INSTANCE;
                String message = e16.getMessage();
                if (message != null) {
                    str = message;
                }
                companion.a("ICGameShare|ShareUserUtil", "parse json failed:", str);
                return null;
            }
        }
        return null;
    }
}

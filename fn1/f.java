package fn1;

import android.text.Editable;
import com.tencent.guild.api.msg.impl.GuildMsgElementApiImpl;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import en1.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0016"}, d2 = {"Lfn1/f;", "Len1/a;", "Landroid/text/Editable;", "editable", "", "emojiId", "", "d", "serverEmoId", "emojiType", "", "b", "type", "localId", "c", "Lorg/json/JSONObject;", "contentJson", "Len1/a$a;", "result", "a", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f implements en1.a {
    private final String b(int serverEmoId, int emojiType) {
        int serverToLocal = ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).serverToLocal(String.valueOf(serverEmoId), emojiType);
        if (serverToLocal < 0) {
            QLog.i("EmoticonProcessor", 1, "convertEmoServerIdToEmoCode error: localeCode invalid");
            return "";
        }
        String c16 = c(emojiType, serverToLocal);
        if (c16 == null) {
            return GuildMsgElementApiImpl.DESC_ELEMENT_EMOJI;
        }
        return c16;
    }

    private final String c(int type, int localId) {
        if (type != 1) {
            if (type != 2) {
                return null;
            }
            return TextUtils.getEmojiString(localId);
        }
        return QQSysFaceUtil.getFaceString(localId);
    }

    private final void d(Editable editable, int emojiId) {
        editable.append((CharSequence) new QQText(b(emojiId, 1), 2, 18, null, null));
    }

    @Override // en1.a
    public void a(@NotNull JSONObject contentJson, @NotNull a.C10251a result) {
        Integer intOrNull;
        int i3;
        Intrinsics.checkNotNullParameter(contentJson, "contentJson");
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            String string = contentJson.getJSONObject("emoji_content").getString("id");
            Intrinsics.checkNotNullExpressionValue(string, "emojiInfoObj.getString(EMOJI_ID)");
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(string);
            if (intOrNull != null) {
                i3 = intOrNull.intValue();
            } else {
                i3 = 0;
            }
            d(result.getTextContent(), i3);
        } catch (Exception e16) {
            result.getTextContent().append(GuildMsgElementApiImpl.DESC_ELEMENT_EMOJI);
            QLog.d("EmoticonProcessor", 1, "EmoticonProcessor exception = " + e16.getMessage());
        }
    }
}

package com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text;

import android.text.Editable;
import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import om1.RestoreInfo;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/restorer/text/b;", "Lpm1/a;", "Landroid/text/Editable;", "editable", "Lorg/json/JSONObject;", "contentJson", "patternJson", "", "c", "b", "Lom1/b;", "restoreResult", "Lom1/a;", "restoreInfo", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b implements pm1.a {
    private final void b(Editable editable, JSONObject contentJson, JSONObject patternJson) {
        editable.append((CharSequence) contentJson.getJSONObject("text_content").optString("text"));
    }

    private final void c(Editable editable, JSONObject contentJson, JSONObject patternJson) {
        String string = patternJson.getString("emojiType");
        Intrinsics.checkNotNullExpressionValue(string, "patternJson.getString(EMOJI_TYPE)");
        int parseInt = Integer.parseInt(string);
        editable.append((CharSequence) TextUtils.getSysEmotcationString(((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).serverToLocal(patternJson.getString("emojiId").toString(), parseInt)));
    }

    @Override // pm1.a
    public void a(@NotNull JSONObject contentJson, @NotNull JSONObject patternJson, @NotNull om1.b restoreResult, @NotNull RestoreInfo restoreInfo) {
        Intrinsics.checkNotNullParameter(contentJson, "contentJson");
        Intrinsics.checkNotNullParameter(patternJson, "patternJson");
        Intrinsics.checkNotNullParameter(restoreResult, "restoreResult");
        Intrinsics.checkNotNullParameter(restoreInfo, "restoreInfo");
        try {
            String string = patternJson.getString("emojiType");
            Intrinsics.checkNotNullExpressionValue(string, "patternJson.getString(EMOJI_TYPE)");
            int parseInt = Integer.parseInt(string);
            if (parseInt != 1) {
                if (parseInt == 2) {
                    b(restoreResult.getMEditable(), contentJson, patternJson);
                }
            } else {
                c(restoreResult.getMEditable(), contentJson, patternJson);
            }
        } catch (Exception e16) {
            QLog.d("EmoticonProcessor", 1, "EmoticonProcessor exception = " + e16.getMessage());
        }
    }
}

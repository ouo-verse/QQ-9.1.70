package com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import om1.RestoreInfo;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/restorer/text/d;", "Lpm1/a;", "Lorg/json/JSONObject;", "contentJson", "", "b", "", "name", "c", "patternJson", "Lom1/b;", "restoreResult", "Lom1/a;", "restoreInfo", "", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d implements pm1.a {
    private final int b(JSONObject contentJson) {
        return contentJson.getJSONObject("channel_content").getJSONObject("channelInfo").getJSONObject("sign").optInt("channel_type", 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
    
        if (r0 == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String c(String name) {
        boolean startsWith$default;
        boolean startsWith$default2;
        if (name.length() > 1) {
            startsWith$default2 = StringsKt__StringsKt.startsWith$default((CharSequence) name, '#', false, 2, (Object) null);
        }
        startsWith$default = StringsKt__StringsKt.startsWith$default((CharSequence) name, '*', false, 2, (Object) null);
        if (!startsWith$default) {
            return name;
        }
        String substring = name.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @Override // pm1.a
    public void a(@NotNull JSONObject contentJson, @NotNull JSONObject patternJson, @NotNull om1.b restoreResult, @NotNull RestoreInfo restoreInfo) {
        Intrinsics.checkNotNullParameter(contentJson, "contentJson");
        Intrinsics.checkNotNullParameter(patternJson, "patternJson");
        Intrinsics.checkNotNullParameter(restoreResult, "restoreResult");
        Intrinsics.checkNotNullParameter(restoreInfo, "restoreInfo");
        if (restoreInfo.getIsFilterGuildRelativeSpan()) {
            return;
        }
        EditText editText = (EditText) restoreInfo.a().f().findViewById(R.id.wcw);
        JSONObject jSONObject = patternJson.getJSONObject("guild_info");
        String string = jSONObject.getString("channel_id");
        String hashtagName = jSONObject.getString("name");
        int i3 = jSONObject.getInt("at_type");
        if (editText != null) {
            editText.measure(View.MeasureSpec.makeMeasureSpec(ScreenUtil.SCREEN_WIDTH, 1073741824), 0);
        }
        Activity f16 = restoreInfo.a().f();
        Intrinsics.checkNotNullExpressionValue(hashtagName, "hashtagName");
        restoreResult.getMEditable().append((CharSequence) com.tencent.guild.aio.input.at.utils.d.w(f16, string, c(hashtagName), b(contentJson), editText, 0, false, false, i3, null));
    }
}

package com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.tencent.guild.api.IGuildAioPopupPanelConfigApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import om1.RestoreInfo;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/restorer/text/c;", "Lpm1/a;", "", "b", "Lorg/json/JSONObject;", "contentJson", "patternJson", "Lom1/b;", "restoreResult", "Lom1/a;", "restoreInfo", "", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements pm1.a {
    private final boolean b() {
        return ((IGuildAioPopupPanelConfigApi) QRoute.api(IGuildAioPopupPanelConfigApi.class)).isEnableTroopList();
    }

    @Override // pm1.a
    public void a(@NotNull JSONObject contentJson, @NotNull JSONObject patternJson, @NotNull om1.b restoreResult, @NotNull RestoreInfo restoreInfo) {
        String str;
        Intrinsics.checkNotNullParameter(contentJson, "contentJson");
        Intrinsics.checkNotNullParameter(patternJson, "patternJson");
        Intrinsics.checkNotNullParameter(restoreResult, "restoreResult");
        Intrinsics.checkNotNullParameter(restoreInfo, "restoreInfo");
        Activity f16 = restoreInfo.a().f();
        EditText editText = (EditText) f16.findViewById(R.id.wcw);
        JSONObject optJSONObject = contentJson.optJSONObject("group_content");
        String str2 = null;
        if (optJSONObject != null) {
            str = optJSONObject.optString("group_code");
        } else {
            str = null;
        }
        if (optJSONObject != null) {
            str2 = optJSONObject.optString("group_name");
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && b()) {
            if (editText != null) {
                editText.measure(View.MeasureSpec.makeMeasureSpec(ScreenUtil.SCREEN_WIDTH, 1073741824), 0);
            }
            QQProAvatarDrawable qQProAvatarDrawable = new QQProAvatarDrawable();
            qQProAvatarDrawable.q(f16, 4, str);
            restoreResult.getMEditable().append((CharSequence) com.tencent.guild.aio.input.at.utils.e.t(f16, str, str2, editText, qQProAvatarDrawable));
        }
    }
}

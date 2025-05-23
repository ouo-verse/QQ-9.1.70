package com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text;

import android.widget.EditText;
import com.tencent.guild.aio.input.at.utils.data.AtRoleInfo;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import om1.RestoreInfo;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0002J(\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/restorer/text/a;", "Lpm1/a;", "Lorg/json/JSONObject;", "patternJson", "Lom1/b;", "restoreResult", "Lom1/a;", "restoreInfo", "", "c", "b", "d", "roleInfo", "e", "contentJson", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements pm1.a {
    private final void b(JSONObject patternJson, om1.b restoreResult, RestoreInfo restoreInfo) {
        String string = patternJson.getJSONObject(QCircleAlphaUserReporter.KEY_USER).getString("nick");
        restoreResult.getMEditable().append((CharSequence) com.tencent.guild.aio.input.at.utils.b.q(restoreInfo.a().f(), "0", string, string, (EditText) restoreInfo.a().f().findViewById(R.id.wcw), 0, false, false, 1, null));
    }

    private final void c(JSONObject patternJson, om1.b restoreResult, RestoreInfo restoreInfo) {
        JSONObject jSONObject = patternJson.getJSONObject(QCircleAlphaUserReporter.KEY_USER);
        String string = jSONObject.getString("id");
        String string2 = jSONObject.getString("nick");
        restoreResult.getMEditable().append((CharSequence) com.tencent.guild.aio.input.at.utils.b.q(restoreInfo.a().f(), string, string2, string2, (EditText) restoreInfo.a().f().findViewById(R.id.wcw), 0, false, false, 2, null));
    }

    private final void d(JSONObject patternJson, om1.b restoreResult, RestoreInfo restoreInfo) {
        String string = patternJson.getJSONObject(QCircleAlphaUserReporter.KEY_USER).getString("nick");
        restoreResult.getMEditable().append((CharSequence) com.tencent.guild.aio.input.at.utils.b.q(restoreInfo.a().f(), "0", string, string, (EditText) restoreInfo.a().f().findViewById(R.id.wcw), 0, false, false, 64, null));
    }

    private final void e(om1.b restoreResult, RestoreInfo restoreInfo, JSONObject roleInfo) {
        String name = roleInfo.getString("name");
        String string = roleInfo.getString("role_id");
        Intrinsics.checkNotNullExpressionValue(string, "roleInfo.getString(\"role_id\")");
        Intrinsics.checkNotNullExpressionValue(name, "name");
        AtRoleInfo atRoleInfo = new AtRoleInfo(string, name, roleInfo.getLong("color"));
        restoreResult.getMEditable().append((CharSequence) com.tencent.guild.aio.input.at.utils.b.q(restoreInfo.a().f(), "0", name, name, (EditText) restoreInfo.a().f().findViewById(R.id.wcw), 0, false, false, 8, atRoleInfo));
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
        JSONObject jSONObject = contentJson.getJSONObject("at_content");
        int i3 = jSONObject.getInt("type");
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        d(patternJson, restoreResult, restoreInfo);
                        return;
                    }
                    return;
                }
                b(patternJson, restoreResult, restoreInfo);
                return;
            }
            JSONObject atRoleInfo = jSONObject.getJSONObject("role_group_id");
            Intrinsics.checkNotNullExpressionValue(atRoleInfo, "atRoleInfo");
            e(restoreResult, restoreInfo, atRoleInfo);
            return;
        }
        c(patternJson, restoreResult, restoreInfo);
    }
}

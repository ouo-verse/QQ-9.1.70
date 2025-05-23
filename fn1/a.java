package fn1;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import en1.a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lfn1/a;", "Len1/a;", "", "spanContent", "Landroid/text/SpannableString;", "b", "Lorg/json/JSONObject;", "contentJson", "Len1/a$a;", "result", "", "a", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements en1.a {
    private final SpannableString b(String spanContent) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s%s", Arrays.copyOf(new Object[]{"@", spanContent}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return new SpannableString(format);
    }

    @Override // en1.a
    public void a(@NotNull JSONObject contentJson, @NotNull a.C10251a result) {
        Intrinsics.checkNotNullParameter(contentJson, "contentJson");
        Intrinsics.checkNotNullParameter(result, "result");
        JSONObject jSONObject = contentJson.getJSONObject("at_content");
        int i3 = jSONObject.getInt("type");
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3 || i3 == 4) {
                    String nickName = jSONObject.getJSONObject("guild_info").getString("name");
                    SpannableStringBuilder textContent = result.getTextContent();
                    Intrinsics.checkNotNullExpressionValue(nickName, "nickName");
                    textContent.append((CharSequence) b(nickName));
                    return;
                }
                return;
            }
            String name = jSONObject.getJSONObject("role_group_id").getString("name");
            SpannableStringBuilder textContent2 = result.getTextContent();
            Intrinsics.checkNotNullExpressionValue(name, "name");
            textContent2.append((CharSequence) b(name));
            return;
        }
        String nickName2 = jSONObject.getJSONObject(QCircleAlphaUserReporter.KEY_USER).getString("nick");
        SpannableStringBuilder textContent3 = result.getTextContent();
        Intrinsics.checkNotNullExpressionValue(nickName2, "nickName");
        textContent3.append((CharSequence) b(nickName2));
    }
}

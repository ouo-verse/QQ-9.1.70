package fn1;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.guild.feed.widget.u;
import com.tencent.mobileqq.guild.util.GuildChannelIconUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.theme.SkinnableBitmapDrawable;
import en1.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lfn1/e;", "Len1/a;", "Lorg/json/JSONObject;", "contentJson", "Len1/a$a;", "result", "", "a", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e implements en1.a {

    /* renamed from: b, reason: collision with root package name */
    private static final int f400102b = ViewUtils.dip2px(16.0f);

    @Override // en1.a
    public void a(@NotNull JSONObject contentJson, @NotNull a.C10251a result) {
        int i3;
        Intrinsics.checkNotNullParameter(contentJson, "contentJson");
        Intrinsics.checkNotNullParameter(result, "result");
        JSONObject jSONObject = contentJson.getJSONObject("channel_content").getJSONObject("channelInfo");
        String string = jSONObject.getString("name");
        boolean z16 = jSONObject.getBoolean("is_square");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        String channelId = jSONObject.getJSONObject("sign").getString("channel_id");
        Intrinsics.checkNotNullExpressionValue(channelId, "channelId");
        if (z16) {
            i3 = 512;
        } else {
            i3 = 16;
        }
        Drawable drawable = null;
        Drawable drawable2 = ContextCompat.getDrawable(BaseApplication.getContext(), GuildChannelIconUtil.d(channelId, i3, null, 4, null));
        if (drawable2 instanceof SkinnableBitmapDrawable) {
            drawable = ((SkinnableBitmapDrawable) drawable2).mutate2();
        } else if (drawable2 != null) {
            drawable = drawable2.mutate();
        }
        if (drawable != null) {
            int i16 = f400102b;
            drawable.setBounds(0, 0, i16, i16);
            spannableStringBuilder.setSpan(new u(drawable, 1), 0, 1, 33);
        }
        result.getTextContent().append((CharSequence) spannableStringBuilder);
    }
}

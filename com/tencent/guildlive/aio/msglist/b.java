package com.tencent.guildlive.aio.msglist;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.guild.aio.component.combinestyle.p;
import com.tencent.guild.aio.util.h;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010%\u001a\u00020#\u00a2\u0006\u0004\b&\u0010'J \u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J(\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0006J\u001e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0004J&\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J\u001e\u0010!\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fR\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/guildlive/aio/msglist/b;", "", "Landroid/text/TextPaint;", "paint", "", c.E, "", "nick", "a", "roleType", "name", "f", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Lcom/tencent/guild/aio/util/h$a;", "c", "d", "e", "Landroid/text/SpannableStringBuilder;", "style", "where", "nickName", "identityName", "", "g", "builder", "nameColor", h.F, "start", "end", "textColor", "j", "suffixColor", "i", "b", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "textView", "<init>", "(Landroid/widget/TextView;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, String> f112790c = new HashMap<>();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView textView;

    public b(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        this.textView = textView;
    }

    private final String a(TextPaint paint, int len, String nick) {
        HashMap<String, String> hashMap = f112790c;
        if (hashMap.containsKey(nick)) {
            String str = hashMap.get(nick);
            Intrinsics.checkNotNull(str);
            return str;
        }
        for (int length = nick.length() - 1; length > 0; length--) {
            String substring = nick.substring(0, length);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            if (paint.measureText(substring) <= len) {
                f112790c.put(nick, substring);
                return substring;
            }
        }
        return nick;
    }

    private final h.MemberRoleInfo c(GuildMsgItem msgItem) {
        return com.tencent.guild.aio.util.h.f112401a.d(msgItem);
    }

    private final String f(int roleType, String name) {
        if (roleType != 2 && roleType != 4 && roleType != 5) {
            if (roleType != 6) {
                if (roleType != 7) {
                    return "";
                }
                return name;
            }
            String string = this.textView.getContext().getString(R.string.f158281p7);
            Intrinsics.checkNotNullExpressionValue(string, "textView.context.getStri\u2026tring.guild_visitor_icon)");
            return string;
        }
        return name;
    }

    @NotNull
    public final String b(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        h.MemberRoleInfo c16 = c(msgItem);
        if (c16 == null) {
            return "";
        }
        return f(c16.getType(), c16.getName());
    }

    @NotNull
    public final String d(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return e(yr0.a.b(msgItem));
    }

    @NotNull
    public final String e(@NotNull String nick) {
        Intrinsics.checkNotNullParameter(nick, "nick");
        int dimensionPixelSize = this.textView.getContext().getResources().getDimensionPixelSize(R.dimen.cg_);
        if (this.textView.getPaint().measureText(nick) > dimensionPixelSize) {
            TextPaint paint = this.textView.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "textView.paint");
            return a(paint, dimensionPixelSize, nick) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return nick;
    }

    public final void g(@NotNull SpannableStringBuilder style, int where, @NotNull String nickName, @NotNull String identityName) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(identityName, "identityName");
        style.insert(where, (CharSequence) (nickName + identityName + "\uff1a"));
    }

    public final void h(@NotNull SpannableStringBuilder builder, @NotNull String nickName, int nameColor) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        builder.setSpan(new bq0.h(0, nameColor, 0, this.textView, 0, nickName.length()), 0, nickName.length(), 33);
    }

    public final void i(@NotNull SpannableStringBuilder builder, @NotNull String nickName, int suffixColor) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        int length = nickName.length();
        int i3 = length + 1;
        builder.setSpan(new bq0.h(0, suffixColor, 0, this.textView, length, i3), length, i3, 33);
    }

    public final void j(@NotNull SpannableStringBuilder builder, int start, int end, int textColor) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        wr0.a aVar = wr0.a.f446116a;
        builder.setSpan(new p(new p.SpanBuilder(Color.parseColor("#FF79798C"), 0, 0, -1, aVar.a(3.0f), aVar.a(3.0f), aVar.a(2.0f), aVar.a(11.0f), 6, null)), start, end, 33);
    }
}

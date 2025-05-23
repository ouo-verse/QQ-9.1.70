package com.tencent.mobileqq.guild.mainframe.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018B\u001b\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u0017\u0010\u001bB#\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u0017\u0010\u001eJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/view/GuildChannelNameTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "text", "a", "str", "b", "", "setTitleTextWithNetwork", "", "connected", "setTitleText", "", h.F, "Ljava/lang/CharSequence;", "disconnectSuffix", "i", "ellipsisSuffix", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "originalText", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildChannelNameTextView extends AppCompatTextView {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence disconnectSuffix;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence ellipsisSuffix;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String originalText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildChannelNameTextView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final String a(String text) {
        float ceil = (float) Math.ceil(getPaint().measureText(this.ellipsisSuffix.toString()));
        float ceil2 = (float) Math.ceil(getPaint().measureText(this.disconnectSuffix.toString()));
        float paddingLeft = getPaddingLeft() + getPaddingRight();
        if (getPaint().measureText(text) + ceil2 + paddingLeft < getMaxWidth() * getMaxLines()) {
            return text + ((Object) this.disconnectSuffix);
        }
        for (int length = text.length(); length > 0; length--) {
            String substring = text.substring(0, length);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            if (getPaint().measureText(substring) + ceil + ceil2 + paddingLeft < getMaxWidth() * getMaxLines()) {
                return substring + ((Object) this.ellipsisSuffix) + ((Object) this.disconnectSuffix);
            }
        }
        return text;
    }

    private final String b(String str) {
        Pattern compile = Pattern.compile("\r|\n");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(\"\\r|\\n\")");
        Matcher matcher = compile.matcher(str);
        Intrinsics.checkNotNullExpressionValue(matcher, "p.matcher(str)");
        String replaceAll = matcher.replaceAll("");
        Intrinsics.checkNotNullExpressionValue(replaceAll, "m.replaceAll(\"\")");
        return replaceAll;
    }

    public static /* synthetic */ void setTitleText$default(GuildChannelNameTextView guildChannelNameTextView, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        guildChannelNameTextView.setTitleText(str, z16);
    }

    public final void setTitleText(@NotNull String text, boolean connected) {
        CharSequence trim;
        CharSequence trim2;
        Intrinsics.checkNotNullParameter(text, "text");
        this.originalText = text;
        if (connected) {
            trim2 = StringsKt__StringsKt.trim((CharSequence) text);
            setText(trim2.toString());
        } else {
            trim = StringsKt__StringsKt.trim((CharSequence) text);
            setText(a(trim.toString()));
        }
    }

    public final void setTitleTextWithNetwork(@Nullable String text) {
        if (TextUtils.isEmpty(text)) {
            text = "\u672a\u77e5\u9891\u9053";
        } else {
            Intrinsics.checkNotNull(text);
        }
        setTitleText(b(text), NetworkUtil.isNetworkAvailable());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildChannelNameTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildChannelNameTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        CharSequence text = getResources().getText(R.string.f143200lf);
        Intrinsics.checkNotNullExpressionValue(text, "resources.getText(R.string.guild_disconnected)");
        this.disconnectSuffix = text;
        CharSequence text2 = getResources().getText(R.string.f143450m4);
        Intrinsics.checkNotNullExpressionValue(text2, "resources.getText(R.string.guild_ellipsis_end)");
        this.ellipsisSuffix = text2;
        this.originalText = "";
    }
}

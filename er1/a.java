package er1;

import android.content.Context;
import android.graphics.Typeface;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.guild.mainframe.view.GuildDragTextView;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007J \u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J4\u0010\u0015\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0011\u001a\u00020\u00062\b\b\u0001\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0016\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010$\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u0012\u0004\b\"\u0010#\u001a\u0004\b\u001f\u0010!R \u0010'\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b%\u0010 \u0012\u0004\b&\u0010#\u001a\u0004\b\u001c\u0010!R \u0010*\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b(\u0010 \u0012\u0004\b)\u0010#\u001a\u0004\b(\u0010!R \u0010-\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b+\u0010 \u0012\u0004\b,\u0010#\u001a\u0004\b+\u0010!R \u0010/\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u001a\u0010 \u0012\u0004\b.\u0010#\u001a\u0004\b%\u0010!\u00a8\u00061"}, d2 = {"Ler1/a;", "", "Landroid/content/Context;", "context", "", "isActive", "", "a", "Lcom/tencent/mobileqq/activity/recent/cur/DragTextView;", "dragTextView", "", "k", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildDragTextView;", "", "count", "isStrongUnread", "j", "textColor", "backgroundColor", "", "unreadHeightDp", "i", "", "fname", "Landroid/graphics/Typeface;", "l", "g", h.F, "b", "Landroid/graphics/Typeface;", "sTypeface", "c", "I", "()I", "getItemBackground$annotations", "()V", "itemBackground", "d", "getChannelNameColor$annotations", "channelNameColor", "e", "getSummaryHighlightColor$annotations", "summaryHighlightColor", "f", "getSummaryNormalColor$annotations", "summaryNormalColor", "getRightTextColor$annotations", "rightTextColor", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Typeface sTypeface;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f397046a = new a();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @DrawableRes
    private static final int itemBackground = R.drawable.guild_token_overlay_item_bg_select;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @ColorRes
    private static final int channelNameColor = R.color.qui_common_text_primary;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @ColorRes
    private static final int summaryHighlightColor = R.color.qui_common_feedback_error;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @ColorRes
    private static final int summaryNormalColor = R.color.qui_common_text_secondary_light;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @ColorRes
    private static final int rightTextColor = R.color.qui_common_text_secondary_light;

    a() {
    }

    @JvmStatic
    public static final int a(@NotNull Context context, boolean isActive) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (QQTheme.isVasTheme()) {
            if (isActive) {
                return QQGuildUIUtil.i(context, R.color.qui_common_text_primary);
            }
            return GuildUIUtils.f235378a.v(QQGuildUIUtil.i(context, R.color.qui_common_text_primary), 0.6f, false);
        }
        if (isActive) {
            return QQGuildUIUtil.i(context, R.color.qui_common_brand_standard);
        }
        return QQGuildUIUtil.i(context, R.color.qui_common_text_primary);
    }

    public static final int b() {
        return channelNameColor;
    }

    public static final int c() {
        return itemBackground;
    }

    public static final int d() {
        return rightTextColor;
    }

    public static final int e() {
        return summaryHighlightColor;
    }

    public static final int f() {
        return summaryNormalColor;
    }

    @JvmStatic
    public static final void i(@NotNull GuildDragTextView dragTextView, long count, @ColorInt int textColor, @ColorInt int backgroundColor, float unreadHeightDp) {
        String valueOf;
        Intrinsics.checkNotNullParameter(dragTextView, "dragTextView");
        if (count <= 0) {
            QLog.e("ChannelStyle", 1, "showUnreadCount error: count = " + count);
            dragTextView.setVisibility(8);
            return;
        }
        dragTextView.setVisibility(0);
        dragTextView.setTextColor(textColor);
        dragTextView.setBackground(GuildUIUtils.f235378a.h(backgroundColor, (unreadHeightDp / 2.0f) + 1));
        if (count > 99) {
            valueOf = "99+";
        } else {
            valueOf = String.valueOf(count);
        }
        dragTextView.getLayoutParams().height = QQGuildUIUtil.f(unreadHeightDp);
        if (valueOf.length() == 1) {
            dragTextView.getLayoutParams().width = QQGuildUIUtil.f(unreadHeightDp);
            dragTextView.setPadding(0, 0, 0, 0);
        } else {
            dragTextView.getLayoutParams().width = -2;
            dragTextView.setPadding(QQGuildUIUtil.f(5.0f), 0, QQGuildUIUtil.f(5.0f), 0);
        }
        dragTextView.setText(valueOf);
        dragTextView.setTypeface(f397046a.h());
    }

    @JvmStatic
    public static final void j(@NotNull GuildDragTextView dragTextView, long count, boolean isStrongUnread) {
        int i3;
        Intrinsics.checkNotNullParameter(dragTextView, "dragTextView");
        if (isStrongUnread) {
            i3 = R.color.qui_common_feedback_error;
        } else {
            i3 = R.color.qui_common_fill_standard_quaternary;
        }
        Context context = dragTextView.getContext();
        i(dragTextView, count, QQGuildUIUtil.i(context, R.color.qui_common_text_allwhite_primary), QQGuildUIUtil.i(context, i3), 18.0f);
    }

    @JvmStatic
    public static final void k(@NotNull DragTextView dragTextView) {
        Intrinsics.checkNotNullParameter(dragTextView, "dragTextView");
        dragTextView.setBackground(GuildUIUtils.f235378a.h(QQGuildUIUtil.i(dragTextView.getContext(), R.color.qui_common_fill_standard_quaternary), 5.0f));
        dragTextView.setVisibility(0);
        dragTextView.setText("");
        dragTextView.getLayoutParams().height = QQGuildUIUtil.f(9.0f);
        dragTextView.getLayoutParams().width = QQGuildUIUtil.f(9.0f);
    }

    private final Typeface l(String fname) {
        try {
            return Typeface.create(fname, 0);
        } catch (RuntimeException e16) {
            QLog.w("ChannelStyle", 1, "[tryCreateTypeface] e=", e16);
            return null;
        }
    }

    public final int g(@NotNull Context context, boolean isActive) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (QQTheme.isVasTheme()) {
            if (isActive) {
                return QQGuildUIUtil.i(context, R.color.qui_common_text_primary);
            }
            return GuildUIUtils.f235378a.v(QQGuildUIUtil.i(context, R.color.qui_common_text_primary), 0.6f, false);
        }
        return QQGuildUIUtil.i(context, R.color.qui_common_text_primary);
    }

    @Nullable
    public final Typeface h() {
        Typeface typeface = sTypeface;
        if (typeface == null) {
            typeface = l(PTSNodeTextBase.FONT_FAMILY_SANS_SERIF_MEDIUM);
            if (typeface == null) {
                typeface = Typeface.DEFAULT;
            }
            sTypeface = typeface;
        }
        return typeface;
    }
}

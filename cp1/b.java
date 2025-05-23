package cp1;

import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.NoticeBubbleInfo;
import com.tencent.mobileqq.guild.mainframe.view.GuildDragTextView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.TypefaceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000f"}, d2 = {"Lcp1/b;", "", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/g;", "data", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildDragTextView;", "dragTextView", "", "grayDrawableResId", "grayTextColor", "", "from", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f391535a = new b();

    b() {
    }

    public final void a(@NotNull NoticeBubbleInfo data, @NotNull GuildDragTextView dragTextView, int grayDrawableResId, int grayTextColor, @NotNull String from) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(dragTextView, "dragTextView");
        Intrinsics.checkNotNullParameter(from, "from");
        Logger.f235387a.d().d("Guild.NewHome.GuildNoticeMsgInboxUtils", 1, "updateUnreadCount data:" + data + " from:" + from);
        dragTextView.setTag(data);
        if (data.getUnreadCount() > 0 && data.getUnreadType() != 0) {
            dragTextView.setVisibility(0);
            int unreadType = data.getUnreadType();
            if (unreadType != 1 && unreadType != 2) {
                if (unreadType != 4) {
                    dragTextView.setVisibility(8);
                } else {
                    dragTextView.setText("");
                    ViewGroup.LayoutParams layoutParams = dragTextView.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = QQGuildUIUtil.f(3.5f);
                    ViewGroup.LayoutParams layoutParams2 = dragTextView.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = QQGuildUIUtil.f(3.5f);
                    dragTextView.getLayoutParams().width = QQGuildUIUtil.f(9.0f);
                    dragTextView.getLayoutParams().height = QQGuildUIUtil.f(9.0f);
                    dragTextView.setMinWidth(QQGuildUIUtil.f(9.0f));
                    dragTextView.setBackgroundResource(R.drawable.guild_page_strong_unread_red_bg);
                }
            } else {
                ViewGroup.LayoutParams layoutParams3 = dragTextView.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin = 0;
                ViewGroup.LayoutParams layoutParams4 = dragTextView.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = 0;
                if (data.getUnreadCount() < 100) {
                    str = String.valueOf(data.getUnreadCount());
                } else {
                    str = "99+";
                }
                dragTextView.setText(str);
                dragTextView.getLayoutParams().width = -2;
                dragTextView.getLayoutParams().height = QQGuildUIUtil.f(16.0f);
                dragTextView.setMinWidth(QQGuildUIUtil.f(16.0f));
                if (data.getUnreadType() == 1) {
                    grayDrawableResId = R.drawable.guild_page_strong_unread_red_bg;
                }
                dragTextView.setBackgroundResource(grayDrawableResId);
                Resources resources = dragTextView.getResources();
                if (data.getUnreadType() == 1) {
                    grayTextColor = R.color.qui_common_text_allwhite_primary;
                }
                dragTextView.setTextColor(resources.getColor(grayTextColor));
                dragTextView.setTypeface(TypefaceProvider.c(dragTextView.getContext(), "fonts/DIN-NextLT-Pro-QQ.ttf"));
            }
            dragTextView.requestLayout();
            return;
        }
        dragTextView.setVisibility(8);
    }
}

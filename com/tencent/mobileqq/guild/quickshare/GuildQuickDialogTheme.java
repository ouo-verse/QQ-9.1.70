package com.tencent.mobileqq.guild.quickshare;

import com.tencent.mobileqq.R;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B?\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fj\u0002\b\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/quickshare/GuildQuickDialogTheme;", "", "backgroundRes", "", "splitLineBg", "moreShareBg", "tipsColor", "userNameColor", "closeIconRes", "moreShareRes", "(Ljava/lang/String;IIIIIIII)V", "getBackgroundRes", "()I", "getCloseIconRes", "getMoreShareBg", "getMoreShareRes", "getSplitLineBg", "getTipsColor", "getUserNameColor", "DARK", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public enum GuildQuickDialogTheme {
    DARK(R.drawable.guild_quick_share_dark_bg, R.drawable.guild_quick_share_line_bg, R.drawable.guild_oval_313138, R.color.f157130bn1, R.color.bmz, R.drawable.guild_close_e8e9ea, R.drawable.guild_share_white);

    private final int backgroundRes;
    private final int closeIconRes;
    private final int moreShareBg;
    private final int moreShareRes;
    private final int splitLineBg;
    private final int tipsColor;
    private final int userNameColor;

    GuildQuickDialogTheme(int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        this.backgroundRes = i3;
        this.splitLineBg = i16;
        this.moreShareBg = i17;
        this.tipsColor = i18;
        this.userNameColor = i19;
        this.closeIconRes = i26;
        this.moreShareRes = i27;
    }

    public final int getBackgroundRes() {
        return this.backgroundRes;
    }

    public final int getCloseIconRes() {
        return this.closeIconRes;
    }

    public final int getMoreShareBg() {
        return this.moreShareBg;
    }

    public final int getMoreShareRes() {
        return this.moreShareRes;
    }

    public final int getSplitLineBg() {
        return this.splitLineBg;
    }

    public final int getTipsColor() {
        return this.tipsColor;
    }

    public final int getUserNameColor() {
        return this.userNameColor;
    }
}

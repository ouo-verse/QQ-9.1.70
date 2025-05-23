package com.tencent.mobileqq.guild.config.subconfig.parser;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/config/subconfig/parser/c;", "Ltg1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "I", "getGrayShowIntervalDay", "()I", "grayShowIntervalDay", "c", "getMsgCountTenSecondsAgo", "msgCountTenSecondsAgo", "<init>", "(II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.config.subconfig.parser.c, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildChannelNotifySettingsGrayBean extends tg1.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int grayShowIntervalDay;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int msgCountTenSecondsAgo;

    public GuildChannelNotifySettingsGrayBean(int i3, int i16) {
        super(107);
        this.grayShowIntervalDay = i3;
        this.msgCountTenSecondsAgo = i16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildChannelNotifySettingsGrayBean)) {
            return false;
        }
        GuildChannelNotifySettingsGrayBean guildChannelNotifySettingsGrayBean = (GuildChannelNotifySettingsGrayBean) other;
        if (this.grayShowIntervalDay == guildChannelNotifySettingsGrayBean.grayShowIntervalDay && this.msgCountTenSecondsAgo == guildChannelNotifySettingsGrayBean.msgCountTenSecondsAgo) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.grayShowIntervalDay * 31) + this.msgCountTenSecondsAgo;
    }

    @Override // tg1.a
    @NotNull
    public String toString() {
        return "GuildChannelNotifySettingsGrayBean(grayShowIntervalDay=" + this.grayShowIntervalDay + ", msgCountTenSecondsAgo=" + this.msgCountTenSecondsAgo + ")";
    }
}

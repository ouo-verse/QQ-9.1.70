package com.tencent.mobileqq.guild.config.subconfig.parser;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/config/subconfig/parser/d;", "Ltg1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Z", "canReport", "<init>", "(Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.config.subconfig.parser.d, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildNotificationReportBean extends tg1.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @JvmField
    public final boolean canReport;

    public GuildNotificationReportBean(boolean z16) {
        super(103);
        this.canReport = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof GuildNotificationReportBean) && this.canReport == ((GuildNotificationReportBean) other).canReport) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        boolean z16 = this.canReport;
        if (z16) {
            return 1;
        }
        return z16 ? 1 : 0;
    }

    @Override // tg1.a
    @NotNull
    public String toString() {
        return "GuildNotificationReportBean(canReport=" + this.canReport + ")";
    }
}

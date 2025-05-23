package o02;

import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\tR*\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0003\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lo02/c;", "", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "b", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "a", "()Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "(Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;)V", "getAppReportSourceInfo$annotations", "()V", "appReportSourceInfo", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f421702a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static GuildAppReportSourceInfo appReportSourceInfo;

    c() {
    }

    @Nullable
    public static final GuildAppReportSourceInfo a() {
        return appReportSourceInfo;
    }

    public static final void b(@Nullable GuildAppReportSourceInfo guildAppReportSourceInfo) {
        appReportSourceInfo = guildAppReportSourceInfo;
    }
}

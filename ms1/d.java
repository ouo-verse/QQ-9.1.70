package ms1;

import android.os.Bundle;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lms1/d;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "", "fromClick", "Lls1/a;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f417492a = new d();

    d() {
    }

    @NotNull
    public final ls1.a a(@NotNull IGProChannelInfo channelInfo, @NotNull FacadeArgsData facadeArgsData, boolean fromClick) {
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        int type = channelInfo.getType();
        if (type != 1 && type != 2 && type != 5) {
            if (type != 6) {
                if (type != 7) {
                    String guildId = channelInfo.getGuildId();
                    Intrinsics.checkNotNullExpressionValue(guildId, "channelInfo.guildId");
                    String channelUin = channelInfo.getChannelUin();
                    Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo.channelUin");
                    return new ls1.c(guildId, channelUin, "");
                }
            } else {
                String guildId2 = channelInfo.getGuildId();
                Intrinsics.checkNotNullExpressionValue(guildId2, "channelInfo.guildId");
                Bundle bundle = facadeArgsData.C;
                Intrinsics.checkNotNullExpressionValue(bundle, "facadeArgsData.extra");
                return new b(guildId2, channelInfo, bundle);
            }
        }
        String guildId3 = channelInfo.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId3, "channelInfo.guildId");
        Bundle bundle2 = facadeArgsData.C;
        Intrinsics.checkNotNullExpressionValue(bundle2, "facadeArgsData.extra");
        return new c(guildId3, channelInfo, bundle2, fromClick);
    }
}

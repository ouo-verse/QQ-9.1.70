package ap1;

import android.content.Context;
import com.tencent.guild.aio.factory.b;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ms1.d;
import ns1.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lap1/a;", "", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "", "fromClick", "Landroid/content/Context;", "context", "b", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private FacadeArgsData facadeArgsData;

    public final void a(@NotNull FacadeArgsData facadeArgsData) {
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        this.facadeArgsData = facadeArgsData;
    }

    public final boolean b(@NotNull IGProChannelInfo channelInfo, boolean fromClick, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Intrinsics.checkNotNullParameter(context, "context");
        if (channelInfo.getType() == 1) {
            b.Companion companion = b.INSTANCE;
            String channelUin = channelInfo.getChannelUin();
            Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo.channelUin");
            String guildId = channelInfo.getGuildId();
            Intrinsics.checkNotNullExpressionValue(guildId, "channelInfo.guildId");
            companion.c(channelUin, guildId);
        }
        FacadeArgsData facadeArgsData = null;
        if (ch.j0(channelInfo.getGuildId())) {
            c cVar = c.f421244a;
            FacadeArgsData facadeArgsData2 = this.facadeArgsData;
            if (facadeArgsData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            } else {
                facadeArgsData = facadeArgsData2;
            }
            return cVar.a(channelInfo, facadeArgsData, fromClick).jump(context);
        }
        d dVar = d.f417492a;
        FacadeArgsData facadeArgsData3 = this.facadeArgsData;
        if (facadeArgsData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
        } else {
            facadeArgsData = facadeArgsData3;
        }
        return dVar.a(channelInfo, facadeArgsData, fromClick).jump(context);
    }
}

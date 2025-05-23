package ek1;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import mk1.e;
import org.jetbrains.annotations.NotNull;
import xj1.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\t\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0017J\b\u0010\n\u001a\u00020\tH\u0017J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016R\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lek1/a;", "Lxj1/c;", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "b", "", "getGuildId", "", "getBusinessType", "a", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "c", "getChannelName", "d", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "getInitBean", "()Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "initBean", "<init>", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedBaseInitBean initBean;

    public a(@NotNull GuildFeedBaseInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
    }

    @Override // xj1.c
    @SuppressLint({"WrongConstant"})
    public int a() {
        return e.f(this.initBean, d());
    }

    @Override // xj1.c
    @NotNull
    public JumpGuildParam.JoinInfoParam b() {
        JumpGuildParam.JoinInfoParam joinInfoParam = this.initBean.getJoinInfoParam();
        Intrinsics.checkNotNullExpressionValue(joinInfoParam, "initBean.joinInfoParam");
        return joinInfoParam;
    }

    @Override // xj1.c
    @Deprecated(message = "\u8fd9\u91cc\u8981\u4e0b\u67b6,section\u4e0d\u80fd\u76f4\u63a5\u611f\u77e5initBean", replaceWith = @ReplaceWith(expression = "otherMethod", imports = {}))
    @NotNull
    /* renamed from: c, reason: from getter */
    public GuildFeedBaseInitBean getInitBean() {
        return this.initBean;
    }

    public int d() {
        return 0;
    }

    @Override // xj1.c
    public int getBusinessType() {
        return this.initBean.getBusinessType();
    }

    @Override // xj1.c
    @NotNull
    public String getChannelName() {
        String channelName = this.initBean.getChannelName();
        if (channelName == null) {
            return "";
        }
        return channelName;
    }

    @Override // xj1.c
    @NotNull
    public String getGuildId() {
        String guildId = this.initBean.getGuildId();
        if (guildId == null) {
            return "";
        }
        return guildId;
    }
}

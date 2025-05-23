package ej1;

import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.guild.feed.gallery.part.f;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0013\u0010\u0011J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lej1/c;", "Lcom/tencent/biz/richframework/part/Part;", "", "args", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$h;", "x9", "", "action", "getMessage", "", "onBackEvent", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "d", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "getInitBean", "()Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "setInitBean", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;)V", "initBean", "<init>", "e", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildFeedDetailInitBean initBean;

    public c(@NotNull GuildFeedDetailInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
    }

    private final a.OnCommentMainFeedDataResult x9(Object args) {
        f.SendInputContentExtData sendInputContentExtData;
        if (args instanceof f.SendInputContentExtData) {
            sendInputContentExtData = (f.SendInputContentExtData) args;
        } else {
            sendInputContentExtData = null;
        }
        if (sendInputContentExtData != null) {
            String guildId = this.initBean.getGuildId();
            String channelId = this.initBean.getChannelId();
            String feedId = this.initBean.getFeedId();
            if (!Intrinsics.areEqual(sendInputContentExtData.getGuildId(), guildId.toString()) || !Intrinsics.areEqual(sendInputContentExtData.getChannelId(), channelId.toString()) || !Intrinsics.areEqual(sendInputContentExtData.getFeedId(), feedId)) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "getCommentFeedMainData sendExtData and curItem not match sendExtData:" + sendInputContentExtData + " curGuildId:" + guildId + " curChannelId:" + channelId + " curFeedId:" + feedId;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("FeedCommentInputHelperPart", 1, (String) it.next(), null);
                }
                return null;
            }
        }
        return mk1.e.f416895a.i(new a.OnCommentMainFeedDataResult(null, 1, null), this.initBean);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "message_get_comment_feed_data")) {
            return x9(args);
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        getActivity().finish();
        return true;
    }
}

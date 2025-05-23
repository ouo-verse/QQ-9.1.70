package ao0;

import android.content.Context;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\fH&\u00a8\u0006\u000e"}, d2 = {"Lao0/f;", "", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "a", "Landroid/content/Context;", "context", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "", "b", "", "getTag", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface f {
    boolean a(@NotNull GuildMsgItem msgItem);

    void b(@NotNull GuildMsgItem msgItem, @Nullable Context context, @NotNull AIOParam aioParam);

    @NotNull
    String getTag();
}

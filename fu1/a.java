package fu1;

import com.tencent.mobileqq.guild.message.lastmsg.LastMessage;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH&\u00a8\u0006\f"}, d2 = {"Lfu1/a;", "", "", "result", "", "errMsg", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "Lkotlin/collections/ArrayList;", "msgAbstracts", "", "onResult", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface a {
    void onResult(int result, @NotNull String errMsg, @NotNull ArrayList<LastMessage> msgAbstracts);
}

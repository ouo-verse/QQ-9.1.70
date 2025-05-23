package lq0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.util.Consumer;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPlusPanelFeature;
import java.util.List;
import kotlin.Metadata;
import lq0.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007H&J\b\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0014\u001a\u00020\u0013H&J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H&\u00a8\u0006\u001b"}, d2 = {"Llq0/i;", "", "", "guildId", "channelId", "", "fromCacheOnly", "Landroidx/core/util/Consumer;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotPlusPanelFeature;", "consumer", "Llq0/f;", "e", "Llq0/g;", "a", "Landroid/content/Context;", "context", "Llq0/h;", "d", "Lmq0/i;", "c", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Llq0/c$a;", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface i {
    @NotNull
    g a();

    @NotNull
    c.a b(@NotNull LayoutInflater inflater, @NotNull ViewGroup parent);

    @NotNull
    mq0.i c();

    @NotNull
    h d(@NotNull Context context);

    @NotNull
    List<f> e(@NotNull String guildId, @NotNull String channelId, boolean fromCacheOnly, @Nullable Consumer<List<GProGuildRobotPlusPanelFeature>> consumer);
}

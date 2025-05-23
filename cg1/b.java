package cg1;

import android.view.View;
import com.tencent.mobileqq.guild.discovery.widget.voiceavatar.MineVoiceAvatarLayout;
import com.tencent.mobileqq.qqguildsdk.data.IGProFeedSummary;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\tH&J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\fH&J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H&\u00a8\u0006\u0019"}, d2 = {"Lcg1/b;", "", "Lcom/tencent/mobileqq/guild/discovery/widget/voiceavatar/MineVoiceAvatarLayout;", "mediaAvatarLayout", "", "r1", "Landroid/view/View;", "cardView", "A0", "", "a", "itemView", "", "position", "Ldg1/b;", "itemData", ICustomDataEditor.STRING_PARAM_1, "", "channelId", "channelType", "z0", "channelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProFeedSummary;", "feedSummary", "q1", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public interface b {
    void A0(@NotNull View cardView);

    boolean a();

    void q1(@NotNull dg1.b channelInfo, @NotNull IGProFeedSummary feedSummary);

    void r1(@NotNull MineVoiceAvatarLayout mediaAvatarLayout);

    void s1(@NotNull View itemView, int position, @NotNull dg1.b itemData);

    void z0(@NotNull String channelId, int channelType);
}

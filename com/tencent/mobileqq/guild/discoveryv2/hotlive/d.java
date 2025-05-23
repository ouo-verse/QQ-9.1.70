package com.tencent.mobileqq.guild.discoveryv2.hotlive;

import android.view.View;
import com.tencent.mobileqq.guild.discoveryv2.hotlive.view.VoicingLinearLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\tH&J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000eH&J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;", "", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/view/VoicingLinearLayout;", "mediaAvatarLayout", "", "c", "Landroid/view/View;", "cardView", "A0", "", "a", "itemView", "", "position", "Lgi1/a;", "itemData", "e", "channelInfo", "d", "view", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface d {
    void A0(@NotNull View cardView);

    boolean a();

    void b(@NotNull View view);

    void c(@NotNull VoicingLinearLayout mediaAvatarLayout);

    void d(@NotNull gi1.a channelInfo);

    void e(@NotNull View itemView, int position, @NotNull gi1.a itemData);
}

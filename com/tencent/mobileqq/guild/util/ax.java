package com.tencent.mobileqq.guild.util;

import android.widget.ImageView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/util/ax;", "", "Landroid/widget/ImageView;", "guildStatusIv", "", "guildStatus", "", "isDefault", "", "a", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ax {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ax f235454a = new ax();

    ax() {
    }

    @JvmStatic
    public static final void a(@Nullable ImageView guildStatusIv, int guildStatus, boolean isDefault) {
        if (guildStatusIv == null) {
            return;
        }
        guildStatusIv.setVisibility(0);
        if (guildStatus != 1) {
            if (guildStatus != 9) {
                if (guildStatus != 17) {
                    if (guildStatus != 4) {
                        if (guildStatus != 5) {
                            if (guildStatus != 6) {
                                if (isDefault) {
                                    guildStatusIv.setImageResource(R.drawable.guild_recent_channel_icon);
                                    return;
                                } else {
                                    guildStatusIv.setVisibility(8);
                                    return;
                                }
                            }
                            guildStatusIv.setImageResource(R.drawable.guild_status_icon_screen_share);
                            return;
                        }
                    } else {
                        guildStatusIv.setImageResource(R.drawable.guild_status_icon_audio);
                        return;
                    }
                } else {
                    guildStatusIv.setImageResource(R.drawable.guild_status_icon_music);
                    return;
                }
            }
            guildStatusIv.setImageResource(R.drawable.guild_status_icon_play);
            return;
        }
        guildStatusIv.setImageResource(R.drawable.guild_status_icon_live);
    }
}

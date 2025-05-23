package com.tencent.mobileqq.guild.picload.listener;

import android.os.Looper;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.app.ThreadManagerV2;

/* loaded from: classes14.dex */
public abstract class GuildPicStateListener implements IPicLoadStateListener {

    /* renamed from: d, reason: collision with root package name */
    private final boolean f231094d;

    public GuildPicStateListener(boolean z16) {
        this.f231094d = z16;
    }

    public static GuildPicStateListener b(final GuildPicStateListener... guildPicStateListenerArr) {
        if (guildPicStateListenerArr == null) {
            return null;
        }
        return new GuildPicStateListener(false) { // from class: com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener.1
            @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
            public void c(final LoadState loadState, final Option option) {
                for (final GuildPicStateListener guildPicStateListener : guildPicStateListenerArr) {
                    if (guildPicStateListener != null) {
                        if (guildPicStateListener.f231094d && Looper.myLooper() != Looper.getMainLooper()) {
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    guildPicStateListener.onStateChange(loadState, option);
                                }
                            });
                        } else {
                            guildPicStateListener.onStateChange(loadState, option);
                        }
                    }
                }
            }
        };
    }

    public abstract void c(LoadState loadState, Option option);

    @Override // com.tencent.libra.listener.IPicLoadStateListener
    public final void onStateChange(final LoadState loadState, final Option option) {
        if (this.f231094d && Looper.myLooper() != Looper.getMainLooper()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener.2
                @Override // java.lang.Runnable
                public void run() {
                    GuildPicStateListener.this.c(loadState, option);
                }
            });
        } else {
            c(loadState, option);
        }
    }
}

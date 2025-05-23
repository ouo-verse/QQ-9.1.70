package com.tencent.mobileqq.guild.avatar;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildAvatarDownloader {
    static /* bridge */ /* synthetic */ AtomicInteger a(GuildAvatarDownloader guildAvatarDownloader) {
        throw null;
    }

    static /* bridge */ /* synthetic */ int b(GuildAvatarDownloader guildAvatarDownloader) {
        throw null;
    }

    static /* bridge */ /* synthetic */ AtomicInteger c(GuildAvatarDownloader guildAvatarDownloader) {
        throw null;
    }

    static /* bridge */ /* synthetic */ DownloadRunnable[] d(GuildAvatarDownloader guildAvatarDownloader) {
        throw null;
    }

    static /* bridge */ /* synthetic */ Thread[] e(GuildAvatarDownloader guildAvatarDownloader) {
        throw null;
    }

    static /* bridge */ /* synthetic */ HashSet f(GuildAvatarDownloader guildAvatarDownloader) {
        throw null;
    }

    static /* bridge */ /* synthetic */ ArrayList g(GuildAvatarDownloader guildAvatarDownloader) {
        throw null;
    }

    static /* bridge */ /* synthetic */ int h(GuildAvatarDownloader guildAvatarDownloader) {
        throw null;
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class DownloadRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private int f214645d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f214646e;
        final /* synthetic */ GuildAvatarDownloader this$0;

        @Override // java.lang.Runnable
        public void run() {
            String str;
            int i3;
            int i16 = 0;
            while (true) {
                if ((i16 < GuildAvatarDownloader.b(null) || GuildAvatarDownloader.g(null).size() > 0) && this.f214646e) {
                    synchronized (GuildAvatarDownloader.g(null)) {
                        int size = GuildAvatarDownloader.g(null).size();
                        if (size == 0) {
                            GuildAvatarDownloader.c(null).incrementAndGet();
                            try {
                                GuildAvatarDownloader.g(null).wait(30000L);
                            } catch (InterruptedException unused) {
                                QLog.e("GuildAvatarDownloader", 1, "downloadRunnable interrupted");
                            }
                            GuildAvatarDownloader.c(null).decrementAndGet();
                            i3 = i16 + 1;
                            str = null;
                        } else {
                            if (size > GuildAvatarDownloader.h(null)) {
                                str = (String) GuildAvatarDownloader.g(null).remove(size - 1);
                            } else {
                                str = (String) GuildAvatarDownloader.g(null).remove(0);
                            }
                            i3 = 0;
                        }
                    }
                    if (str != null) {
                        a(str);
                        synchronized (GuildAvatarDownloader.f(null)) {
                            GuildAvatarDownloader.f(null).remove(str);
                        }
                        Thread.yield();
                    }
                    i16 = i3;
                }
            }
            synchronized (GuildAvatarDownloader.e(null)) {
                if (this.f214645d < GuildAvatarDownloader.e(null).length) {
                    GuildAvatarDownloader.e(null)[this.f214645d] = null;
                    GuildAvatarDownloader.d(null)[this.f214645d] = null;
                }
            }
            GuildAvatarDownloader.a(null).decrementAndGet();
        }

        private void a(String str) {
        }
    }
}

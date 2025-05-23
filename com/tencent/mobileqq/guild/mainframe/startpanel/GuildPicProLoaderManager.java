package com.tencent.mobileqq.guild.mainframe.startpanel;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.config.GuildCoverInfo;
import com.tencent.mobileqq.guild.mainframe.util.j;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes14.dex */
public class GuildPicProLoaderManager {

    /* renamed from: e, reason: collision with root package name */
    private static volatile GuildPicProLoaderManager f227495e;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, Boolean> f227496a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, Boolean> f227497b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private int f227498c;

    /* renamed from: d, reason: collision with root package name */
    private int f227499d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class a extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f227505e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z16, String str) {
            super(z16);
            this.f227505e = str;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState loadState, Option option) {
            if ((loadState == LoadState.STATE_SUCCESS || loadState == LoadState.STATE_DOWNLOAD_SUCCESS) && option != null && option.getCacheKey() != null) {
                GuildPicProLoaderManager.this.f227496a.put(this.f227505e, Boolean.TRUE);
                if (QLog.isColorLevel()) {
                    QLog.d("Guild.MF.PIC-GuildPicProLoaderManager", 2, "loadImage succ guildId=" + this.f227505e + " cachekey=" + option.getCacheKey().toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class b extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f227507e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f227508f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z16, String str, String str2) {
            super(z16);
            this.f227507e = str;
            this.f227508f = str2;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState loadState, Option option) {
            if ((loadState == LoadState.STATE_SUCCESS || loadState == LoadState.STATE_DOWNLOAD_SUCCESS) && option != null && option.getCacheKey() != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("Guild.MF.PIC-GuildPicProLoaderManager", 2, "loadGuildAvatarImage succ, guildId=", this.f227507e, " avatarUrl", this.f227508f, " cachekey=" + option.getCacheKey().toString());
                }
                GuildPicProLoaderManager.this.f227497b.put(this.f227507e, Boolean.TRUE);
            }
        }
    }

    public static GuildPicProLoaderManager g() {
        if (f227495e == null) {
            synchronized (GuildPicProLoaderManager.class) {
                if (f227495e == null) {
                    f227495e = new GuildPicProLoaderManager();
                }
            }
        }
        return f227495e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, String str2, int i3, int i16, int i17) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.PIC-GuildPicProLoaderManager", 2, "loadImage " + str2, " priority=", Integer.valueOf(i3));
        }
        e.a().f(v.e(str2, true, Integer.valueOf(i16), Integer.valueOf(i17)).setPriority(i3), new a(true, str));
        this.f227496a.put(str, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, String str2) {
        e.a().f(v.e(str2, true, Integer.valueOf(QQGuildUIUtil.f(140.0f)), Integer.valueOf(QQGuildUIUtil.f(140.0f))), new b(true, str, str2));
    }

    public void j(Context context, final String str, final boolean z16) {
        if (this.f227496a.containsKey(str)) {
            return;
        }
        final int c16 = com.tencent.mobileqq.guild.mainframe.helper.a.c(context);
        final int i3 = (int) (c16 * 0.46629214f);
        if (this.f227498c == 0 || this.f227499d == 0) {
            this.f227498c = c16;
            this.f227499d = i3;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.GuildPicProLoaderManager.1
            @Override // java.lang.Runnable
            public void run() {
                int i16;
                j.c("Guild.MF.PIC-GuildPicProLoaderManager");
                if (z16) {
                    i16 = 1;
                } else {
                    i16 = 2;
                }
                String c17 = GuildCoverInfo.e(str).c();
                String a16 = GuildCoverInfo.e(str).a();
                if (!TextUtils.isEmpty(c17)) {
                    int i17 = i16;
                    GuildPicProLoaderManager.this.h(str, c17, i17, c16, i3);
                    GuildPicProLoaderManager.this.h(str, a16, i17, c16, i3);
                } else {
                    IGProGuildInfo guildInfo = ((IGPSService) ch.l().getRuntimeService(IGPSService.class, "")).getGuildInfo(str);
                    if (guildInfo != null) {
                        GuildPicProLoaderManager guildPicProLoaderManager = GuildPicProLoaderManager.this;
                        guildPicProLoaderManager.h(str, guildInfo.getCoverUrl(guildPicProLoaderManager.f227498c, GuildPicProLoaderManager.this.f227499d), i16, c16, i3);
                    }
                }
                j.a("Guild.MF.PIC-GuildPicProLoaderManager");
            }
        }, 16, null, true);
    }

    public void k(final String str) {
        if (this.f227497b.containsKey(str)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.GuildPicProLoaderManager.2
            @Override // java.lang.Runnable
            public void run() {
                GuildPicProLoaderManager.this.f227497b.put(str, Boolean.FALSE);
                IGProGuildInfo guildInfo = ((IGPSService) ch.l().getRuntimeService(IGPSService.class, "")).getGuildInfo(str);
                if (guildInfo == null) {
                    return;
                }
                GuildPicProLoaderManager.this.i(str, guildInfo.getAvatarUrl(100));
            }
        }, 16, null, true);
    }
}

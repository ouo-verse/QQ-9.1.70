package com.tencent.mobileqq.guild.discover;

import com.tencent.mobileqq.guild.config.GuildDiscoverBannerConfBean;
import com.tencent.mobileqq.guild.config.GuildHotSearchItem;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumChannel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/discover/d;", "", "", "value", "", "b", "", "Lcom/tencent/mobileqq/guild/config/j;", "Ljava/util/List;", "guildHotSearchList", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProForumChannel;", "c", "guildHotFeedChannelList", "", "d", "Ljava/lang/String;", "guildHotFeedChannelTraceId", "Le12/a;", "Lcom/tencent/mobileqq/guild/config/i;", "e", "Le12/a;", "a", "()Le12/a;", "bannerConf", "f", "searchSugTraceId", "g", "Z", "getSupportAsyncInflater", "()Z", "setSupportAsyncInflater", "(Z)V", "supportAsyncInflater", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f216503a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<GuildHotSearchItem> guildHotSearchList = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<IGProForumChannel> guildHotFeedChannelList = new ArrayList();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String guildHotFeedChannelTraceId = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final e12.a<GuildDiscoverBannerConfBean> bannerConf = new e12.a<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String searchSugTraceId = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static boolean supportAsyncInflater = bw.f235485a.s();

    d() {
    }

    @JvmStatic
    public static final void b(boolean value) {
        supportAsyncInflater = value;
        bw.f235485a.W0(value);
        QLog.i("Guild.search.GuildSearchCache", 1, "[updateSearchResSupportAsyncInflate] value = " + value);
    }

    @NotNull
    public final e12.a<GuildDiscoverBannerConfBean> a() {
        return bannerConf;
    }
}

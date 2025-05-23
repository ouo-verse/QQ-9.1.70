package com.tencent.mobileqq.guild.home.viewmodels;

import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.distribute.data.GameDistributeInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.home.viewmodels.GuildHomeHeaderRepository;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildHomeHeaderGroupChatInfo;
import com.tencent.mobileqq.guild.util.GuildBannerPalette;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildMainFrameHeaderInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pr1.VisitorColorPicker;
import vh2.ax;
import vh2.v;

/* compiled from: P */
@Deprecated(message = "2025.01\u9891\u9053\u6539\u7248\uff0c\u5f03\u7528com.tencent.mobileqq.guild.home\u5305\u4e0b\u4ee3\u7801\uff0c\u6539\u4e3ahomev2\u5305\u4e0b")
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0011\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0004RSTUB\t\b\u0002\u00a2\u0006\u0004\bP\u0010QJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0007J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u001cJ\u0010\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020!J\u000e\u0010#\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020!J\u0010\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010'\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020&J\u000e\u0010(\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020&J\u000e\u0010)\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0002H\u0016R!\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R-\u00106\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020,028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u00105R!\u00108\u001a\b\u0012\u0004\u0012\u00020\u00160,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010.\u001a\u0004\b7\u00100R!\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001c0,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010.\u001a\u0004\b9\u00100R!\u0010<\u001a\b\u0012\u0004\u0012\u00020!0,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010.\u001a\u0004\b;\u00100R!\u0010>\u001a\b\u0012\u0004\u0012\u00020&0,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010.\u001a\u0004\b=\u00100R'\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010.\u001a\u0004\b?\u00105R'\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010.\u001a\u0004\bA\u00105R)\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001a028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010.\u001a\u0004\bD\u00105R)\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001f028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010.\u001a\u0004\bF\u00105R)\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010$028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010.\u001a\u0004\bH\u00105R\u0014\u0010K\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010N\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeHeaderRepository;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "guildId", "", "isSubThread", "", "I", "pageId", "H", "G", "L", "P", "O", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "E", "com/tencent/mobileqq/guild/home/viewmodels/GuildHomeHeaderRepository$e", "k", "()Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeHeaderRepository$e;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeHeaderRepository$a;", "listener", "g", "l", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildMainFrameHeaderInfo;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeHeaderRepository$b;", "j", "o", "Lcom/tencent/gamecenter/wadl/distribute/data/GameDistributeInfo;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeHeaderRepository$c;", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/d;", "u", "Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeHeaderRepository$d;", "i", DomainData.DOMAIN_NAME, "M", "account", "onAccountChanged", "", "e", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/util/Set;", "activeGuildIdSet", "", "f", "p", "()Ljava/util/Map;", "activeGuildHomePages", "r", "coverListenerSet", "D", "headerListenerSet", "t", "gameListenerSet", "v", "groupChatListenerSet", "w", "guildCoverColorCache", "y", "guildCoverUrlCache", UserInfo.SEX_FEMALE, "B", "guildHeaderCache", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "guildGameCache", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "guildGroupChatCache", "Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeHeaderRepository$e;", "gproServiceObserver", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "J", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "<init>", "()V", "a", "b", "c", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeHeaderRepository implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: C */
    @NotNull
    private static final Lazy groupChatListenerSet;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private static final Lazy guildCoverColorCache;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private static final Lazy guildCoverUrlCache;

    /* renamed from: F */
    @NotNull
    private static final Lazy guildHeaderCache;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private static final Lazy guildGameCache;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private static final Lazy guildGroupChatCache;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private static final e gproServiceObserver;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private static IGPSService gProService;

    /* renamed from: d */
    @NotNull
    public static final GuildHomeHeaderRepository f225337d;

    /* renamed from: e, reason: from kotlin metadata */
    @NotNull
    private static final Lazy activeGuildIdSet;

    /* renamed from: f, reason: from kotlin metadata */
    @NotNull
    private static final Lazy activeGuildHomePages;

    /* renamed from: h */
    @NotNull
    private static final Lazy coverListenerSet;

    /* renamed from: i, reason: from kotlin metadata */
    @NotNull
    private static final Lazy headerListenerSet;

    /* renamed from: m */
    @NotNull
    private static final Lazy gameListenerSet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeHeaderRepository$a;", "", "", "guildId", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "colorInfo", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface a {
        void a(@NotNull String guildId, @NotNull GuildHomeCoverColors colorInfo);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeHeaderRepository$b;", "", "", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildMainFrameHeaderInfo;", "headerIndo", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void a(@NotNull String guildId, @Nullable IGProGuildMainFrameHeaderInfo headerIndo);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeHeaderRepository$c;", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface c {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeHeaderRepository$d;", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface d {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/home/viewmodels/GuildHomeHeaderRepository$e", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onGuildInfoUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e extends GPServiceObserver {
        e() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            boolean contains;
            IGProGuildInfo guildInfo;
            GuildHomeHeaderRepository guildHomeHeaderRepository = GuildHomeHeaderRepository.f225337d;
            contains = CollectionsKt___CollectionsKt.contains(guildHomeHeaderRepository.q(), guildId);
            if (contains && (guildInfo = GuildHomeHeaderRepository.gProService.getGuildInfo(guildId)) != null) {
                guildHomeHeaderRepository.M(guildInfo);
            }
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        GuildHomeHeaderRepository guildHomeHeaderRepository = new GuildHomeHeaderRepository();
        f225337d = guildHomeHeaderRepository;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Set<String>>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.GuildHomeHeaderRepository$activeGuildIdSet$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<String> invoke() {
                return new LinkedHashSet();
            }
        });
        activeGuildIdSet = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, Set<String>>>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.GuildHomeHeaderRepository$activeGuildHomePages$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, Set<String>> invoke() {
                return new LinkedHashMap();
            }
        });
        activeGuildHomePages = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Set<a>>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.GuildHomeHeaderRepository$coverListenerSet$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<GuildHomeHeaderRepository.a> invoke() {
                return new LinkedHashSet();
            }
        });
        coverListenerSet = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Set<b>>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.GuildHomeHeaderRepository$headerListenerSet$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<GuildHomeHeaderRepository.b> invoke() {
                return new LinkedHashSet();
            }
        });
        headerListenerSet = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Set<c>>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.GuildHomeHeaderRepository$gameListenerSet$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<GuildHomeHeaderRepository.c> invoke() {
                return new LinkedHashSet();
            }
        });
        gameListenerSet = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<Set<d>>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.GuildHomeHeaderRepository$groupChatListenerSet$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<GuildHomeHeaderRepository.d> invoke() {
                return new LinkedHashSet();
            }
        });
        groupChatListenerSet = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, GuildHomeCoverColors>>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.GuildHomeHeaderRepository$guildCoverColorCache$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, GuildHomeCoverColors> invoke() {
                return new LinkedHashMap();
            }
        });
        guildCoverColorCache = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, String>>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.GuildHomeHeaderRepository$guildCoverUrlCache$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, String> invoke() {
                return new LinkedHashMap();
            }
        });
        guildCoverUrlCache = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, IGProGuildMainFrameHeaderInfo>>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.GuildHomeHeaderRepository$guildHeaderCache$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, IGProGuildMainFrameHeaderInfo> invoke() {
                return new LinkedHashMap();
            }
        });
        guildHeaderCache = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, GameDistributeInfo>>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.GuildHomeHeaderRepository$guildGameCache$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, GameDistributeInfo> invoke() {
                return new LinkedHashMap();
            }
        });
        guildGameCache = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, GuildHomeHeaderGroupChatInfo>>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.GuildHomeHeaderRepository$guildGroupChatCache$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, GuildHomeHeaderGroupChatInfo> invoke() {
                return new LinkedHashMap();
            }
        });
        guildGroupChatCache = lazy11;
        e k3 = guildHomeHeaderRepository.k();
        gproServiceObserver = k3;
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        gProService = (IGPSService) S0;
        AccountChangedNotifier.f214789d.a(guildHomeHeaderRepository);
        gProService.addObserver(k3);
    }

    GuildHomeHeaderRepository() {
    }

    private final Map<String, GuildHomeHeaderGroupChatInfo> A() {
        return (Map) guildGroupChatCache.getValue();
    }

    private final Map<String, IGProGuildMainFrameHeaderInfo> B() {
        return (Map) guildHeaderCache.getValue();
    }

    private final Set<b> D() {
        return (Set) headerListenerSet.getValue();
    }

    private final void E(IGProGuildInfo guildInfo) {
        if (guildInfo != null && guildInfo.isMember()) {
            gProService.fetchGuildInfoWithSource(guildInfo.getGuildID(), 104, new v() { // from class: com.tencent.mobileqq.guild.home.viewmodels.c
                @Override // vh2.v
                public final void a(int i3, String str, IGProGuildInfo iGProGuildInfo) {
                    GuildHomeHeaderRepository.F(i3, str, iGProGuildInfo);
                }
            });
        }
    }

    public static final void F(int i3, String str, IGProGuildInfo iGProGuildInfo) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.headerBars.GuildHomeHeaderRepository", 2, "loadGuildInfoForRefresh result:" + i3 + " errMsg:" + str);
        }
    }

    @JvmStatic
    public static final void G(@NotNull String guildId, @NotNull String pageId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Logger logger = Logger.f235387a;
        boolean z16 = true;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.headerBars.GuildHomeHeaderRepository", 1, "onGuildHomeDestroy gId:" + guildId + " page:" + pageId);
        }
        GuildHomeHeaderRepository guildHomeHeaderRepository = f225337d;
        Set<String> set = guildHomeHeaderRepository.p().get(guildId);
        if (set != null) {
            set.remove(pageId);
        }
        Set<String> set2 = guildHomeHeaderRepository.p().get(guildId);
        if (set2 == null || !set2.isEmpty()) {
            z16 = false;
        }
        if (z16) {
            guildHomeHeaderRepository.q().remove(guildId);
        }
    }

    @JvmStatic
    public static final void H(@NotNull String guildId, @NotNull String pageId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.headerBars.GuildHomeHeaderRepository", 1, "onGuildHomeResume gId:" + guildId + " page:" + pageId);
        }
        GuildHomeHeaderRepository guildHomeHeaderRepository = f225337d;
        if (guildHomeHeaderRepository.p().get(guildId) == null) {
            guildHomeHeaderRepository.p().put(guildId, new LinkedHashSet());
        }
        Set<String> set = guildHomeHeaderRepository.p().get(guildId);
        if (set != null) {
            set.add(pageId);
        }
    }

    @JvmStatic
    public static final void I(@NotNull final String guildId, boolean isSubThread) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        long currentTimeMillis = System.currentTimeMillis();
        GuildHomeHeaderRepository guildHomeHeaderRepository = f225337d;
        guildHomeHeaderRepository.q().add(guildId);
        if (isSubThread) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.home.viewmodels.b
                @Override // java.lang.Runnable
                public final void run() {
                    GuildHomeHeaderRepository.K(guildId);
                }
            }, 16, null, false);
        } else {
            guildHomeHeaderRepository.L(guildId);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.headerBars.GuildHomeHeaderRepository", 1, "preActiveGuild gId:" + guildId + " isSubThread:" + isSubThread + " cost: " + (currentTimeMillis2 - currentTimeMillis) + " ms");
        }
    }

    public static /* synthetic */ void J(String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        I(str, z16);
    }

    public static final void K(String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        f225337d.L(guildId);
    }

    private final void L(String guildId) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.headerBars.GuildHomeHeaderRepository", 1, "preloadData gId:" + guildId);
        }
        IGProGuildInfo guildInfo = gProService.getGuildInfo(guildId);
        if (guildInfo != null) {
            f225337d.M(guildInfo);
        }
        P(guildId);
        O(guildId);
        E(guildInfo);
        com.tencent.mobileqq.guild.home.helper.g.f224866a.d(MiscKt.l(guildId));
    }

    public static final void N(IGProGuildInfo guildInfo, long j3, Bitmap bitmap) {
        GuildHomeCoverColors c16;
        boolean z16;
        Intrinsics.checkNotNullParameter(guildInfo, "$guildInfo");
        long currentTimeMillis = System.currentTimeMillis();
        int e16 = GuildBannerPalette.e(bitmap);
        boolean b16 = VisitorColorPicker.INSTANCE.b(e16);
        long currentTimeMillis2 = System.currentTimeMillis();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            String guildID = guildInfo.getGuildID();
            if (bitmap != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            d16.d("Guild.MF.headerBars.GuildHomeHeaderRepository", 1, "preloadGuildCoverData OK gId:" + guildID + " hasBitmap:" + z16 + " mainColor:" + e16 + " isMainColorLight:" + b16 + " cost: " + (currentTimeMillis - j3) + " " + (currentTimeMillis2 - currentTimeMillis));
        }
        if (b16) {
            c16 = GuildHomeCoverColors.INSTANCE.b(2, e16);
        } else {
            c16 = GuildHomeCoverColors.INSTANCE.c(1, e16);
        }
        GuildHomeHeaderRepository guildHomeHeaderRepository = f225337d;
        Map<String, GuildHomeCoverColors> w3 = guildHomeHeaderRepository.w();
        String guildID2 = guildInfo.getGuildID();
        Intrinsics.checkNotNullExpressionValue(guildID2, "guildInfo.guildID");
        w3.put(guildID2, c16);
        for (a aVar : guildHomeHeaderRepository.r()) {
            String guildID3 = guildInfo.getGuildID();
            Intrinsics.checkNotNullExpressionValue(guildID3, "guildInfo.guildID");
            aVar.a(guildID3, c16);
        }
    }

    private final void P(final String guildId) {
        final long currentTimeMillis = System.currentTimeMillis();
        gProService.getGuildMainFrameHeaderInfo(MiscKt.l(guildId), new ax() { // from class: com.tencent.mobileqq.guild.home.viewmodels.d
            @Override // vh2.ax
            public final void a(int i3, String str, long j3, IGProGuildMainFrameHeaderInfo iGProGuildMainFrameHeaderInfo) {
                GuildHomeHeaderRepository.Q(guildId, currentTimeMillis, i3, str, j3, iGProGuildMainFrameHeaderInfo);
            }
        });
    }

    public static final void Q(String guildId, long j3, int i3, String str, long j16, IGProGuildMainFrameHeaderInfo iGProGuildMainFrameHeaderInfo) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        long currentTimeMillis = System.currentTimeMillis();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.headerBars.GuildHomeHeaderRepository", 1, "preloadGuildHeaderData getGuildMainFrameHeaderInfo OK gId:" + guildId + " cost: " + (currentTimeMillis - j3));
        }
        if (i3 != 0) {
            return;
        }
        GuildHomeHeaderRepository guildHomeHeaderRepository = f225337d;
        guildHomeHeaderRepository.B().put(guildId, iGProGuildMainFrameHeaderInfo);
        Iterator<T> it = guildHomeHeaderRepository.D().iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(guildId, iGProGuildMainFrameHeaderInfo);
        }
    }

    private final e k() {
        return new e();
    }

    private final Map<String, Set<String>> p() {
        return (Map) activeGuildHomePages.getValue();
    }

    public final Set<String> q() {
        return (Set) activeGuildIdSet.getValue();
    }

    private final Set<a> r() {
        return (Set) coverListenerSet.getValue();
    }

    private final Set<c> t() {
        return (Set) gameListenerSet.getValue();
    }

    private final Set<d> v() {
        return (Set) groupChatListenerSet.getValue();
    }

    private final Map<String, GuildHomeCoverColors> w() {
        return (Map) guildCoverColorCache.getValue();
    }

    private final Map<String, String> y() {
        return (Map) guildCoverUrlCache.getValue();
    }

    private final Map<String, GameDistributeInfo> z() {
        return (Map) guildGameCache.getValue();
    }

    @Nullable
    public final IGProGuildMainFrameHeaderInfo C(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.headerBars.GuildHomeHeaderRepository", 1, "getHeaderInfoCache gId:" + guildId);
        }
        return B().get(guildId);
    }

    public final void M(@NotNull final IGProGuildInfo guildInfo) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        final long currentTimeMillis = System.currentTimeMillis();
        String coverUrl = guildInfo.getCoverUrl(0, 0);
        Map<String, String> y16 = y();
        String guildID = guildInfo.getGuildID();
        Intrinsics.checkNotNullExpressionValue(guildID, "guildInfo.guildID");
        Intrinsics.checkNotNullExpressionValue(coverUrl, "coverUrl");
        y16.put(guildID, coverUrl);
        com.tencent.mobileqq.guild.util.v.f(coverUrl, 0, 0, new GuildLevelRoleView.a() { // from class: com.tencent.mobileqq.guild.home.viewmodels.a
            @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
            public final void a(Bitmap bitmap) {
                GuildHomeHeaderRepository.N(IGProGuildInfo.this, currentTimeMillis, bitmap);
            }
        });
    }

    public final void g(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        r().add(listener);
    }

    public final void h(@NotNull c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        t().add(listener);
    }

    public final void i(@NotNull d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        v().add(listener);
    }

    public final void j(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        D().add(listener);
    }

    public final void l(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        r().remove(listener);
    }

    public final void m(@NotNull c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        t().remove(listener);
    }

    public final void n(@NotNull d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        v().remove(listener);
    }

    public final void o(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        D().remove(listener);
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        IGPSService iGPSService = gProService;
        e eVar = gproServiceObserver;
        iGPSService.deleteObserver(eVar);
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGPSService iGPSService2 = (IGPSService) S0;
        gProService = iGPSService2;
        iGPSService2.addObserver(eVar);
    }

    @Nullable
    public final GameDistributeInfo s(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.headerBars.GuildHomeHeaderRepository", 1, "getGameInfoCache gId:" + guildId);
        }
        return z().get(guildId);
    }

    @Nullable
    public final GuildHomeHeaderGroupChatInfo u(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.headerBars.GuildHomeHeaderRepository", 1, "getGroupChatCache gId:" + guildId);
        }
        return A().get(guildId);
    }

    @Nullable
    public final GuildHomeCoverColors x(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.headerBars.GuildHomeHeaderRepository", 1, "getGuildCoverInfoCache gId:" + guildId);
        }
        return w().get(guildId);
    }

    private final void O(String guildId) {
    }
}

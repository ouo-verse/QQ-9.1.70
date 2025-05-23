package com.tencent.qqnt.troopmemberlist.cache;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfoExt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.annotation.Service;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001f J\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J2\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH&J&\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\nH&J4\u0010\u0011\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\nH&J \u0010\u0012\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\bH&J \u0010\u0017\u001a\u00020\r2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015H&J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H&J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H&J\u0016\u0010\u001d\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/cache/ITroopMemberCacheService;", "Lmqq/app/api/IRuntimeService;", "", "troopUin", "memberUin", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "getMemberInfo", "getMemberInfoWithExtInfo", "", "memberUins", "", "withExt", "member", "", "putMemberInfo", "members", "allInCache", "putMemberList", "remove", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfoExt;", "Lkotlin/collections/ArrayList;", "extInfos", "putExtInfo", "uid", "getUinFromUid", "uin", "getUidFromUin", "memberList", "saveUinUid", "Config", "a", "c", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface ITroopMemberCacheService extends IRuntimeService {
    public static final IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String CONFIG_ID = "102300";

    /* renamed from: Config, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int STRATEGY_ALL_IN_ONE = 2;
    public static final int STRATEGY_ALL_IN_ONE_WITH_AIO_CACHE = 4;
    public static final int STRATEGY_LIMIT_BIG_TROOP = 3;
    public static final int STRATEGY_TWELVE_TROOP = 1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/cache/ITroopMemberCacheService$a;", "", "", "e", "c", "d", "", "f", "a", "b", "I", "cacheApiStrategy", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f362856a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static int cacheApiStrategy;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63527);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 8)) {
                redirector.redirect((short) 8);
            } else {
                f362856a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return com.tencent.mobileqq.troop.config.b.f294691a.d(ITroopMemberCacheService.CONFIG_ID, "aioCachePerSize", 6);
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return com.tencent.mobileqq.troop.config.b.f294691a.d(ITroopMemberCacheService.CONFIG_ID, "cacheAIOCount", 20);
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            int i3 = cacheApiStrategy;
            if (i3 != 0) {
                return i3;
            }
            int d16 = com.tencent.mobileqq.troop.config.b.f294691a.d(ITroopMemberCacheService.CONFIG_ID, "cacheStrategy", 1);
            cacheApiStrategy = d16;
            return d16;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return com.tencent.mobileqq.troop.config.b.f294691a.d(ITroopMemberCacheService.CONFIG_ID, "eachTroopMaxMemberSize", 48);
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return com.tencent.mobileqq.troop.config.b.f294691a.d(ITroopMemberCacheService.CONFIG_ID, QzoneConfig.SECONDARY_VIDEO_MAX_CACHE_SIZE, 500);
        }

        public final boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return com.tencent.mobileqq.troop.config.b.f294691a.b(ITroopMemberCacheService.CONFIG_ID, "dealCacheInfoWhenNTChanged", true);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class b {
        public static /* synthetic */ void a(ITroopMemberCacheService iTroopMemberCacheService, String str, List list, boolean z16, boolean z17, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                if ((i3 & 8) != 0) {
                    z17 = false;
                }
                iTroopMemberCacheService.putMemberList(str, list, z16, z17);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: putMemberList");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&J\u001e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u000e\u001a\u00020\fH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/cache/ITroopMemberCacheService$c;", "", "", "troopUin", "memberUin", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "get", "", "memberInfos", "", "put", "remove", "", "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface c {
        int a(@NotNull String troopUin);

        int b();

        @Nullable
        TroopMemberInfo get(@NotNull String troopUin, @NotNull String memberUin);

        void put(@NotNull String troopUin, @NotNull List<? extends TroopMemberInfo> memberInfos);

        void remove(@NotNull String troopUin, @NotNull List<String> memberUin);
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(63534), (Class<?>) ITroopMemberCacheService.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f362856a;
        }
    }

    @Nullable
    TroopMemberInfo getMemberInfo(@Nullable String troopUin, @Nullable String memberUin);

    @Nullable
    List<TroopMemberInfo> getMemberInfo(@Nullable String troopUin, @Nullable List<String> memberUins, boolean withExt);

    @Nullable
    TroopMemberInfo getMemberInfoWithExtInfo(@Nullable String troopUin, @Nullable String memberUin);

    @NotNull
    String getUidFromUin(@NotNull String uin);

    @NotNull
    String getUinFromUid(@NotNull String uid);

    void putExtInfo(@NotNull ArrayList<TroopMemberInfoExt> extInfos);

    void putMemberInfo(@Nullable String troopUin, @Nullable TroopMemberInfo member, boolean withExt);

    void putMemberList(@Nullable String troopUin, @NotNull List<? extends TroopMemberInfo> members, boolean withExt, boolean allInCache);

    void remove(@Nullable String troopUin, @NotNull List<String> members);

    void saveUinUid(@NotNull List<? extends TroopMemberInfo> memberList);
}

package com.tencent.qqnt.troopmemberlist;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001\"B5\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0016R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R4\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0016`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/FetchDiffTroopMemberRunnable;", "Ljava/lang/Runnable;", "", "groupUin", "", "e", "memberUin", "f", TencentLocation.RUN_MODE, "", "d", "Ljava/util/List;", "troopUins", "memberUins", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/qqnt/troopmemberlist/e;", tl.h.F, "Lcom/tencent/qqnt/troopmemberlist/e;", "callback", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "Lkotlin/collections/HashMap;", "i", "Ljava/util/HashMap;", "map", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "size", "<init>", "(Ljava/util/List;Ljava/util/List;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/qqnt/troopmemberlist/e;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class FetchDiffTroopMemberRunnable implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> troopUins;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> memberUins;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e callback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, TroopMemberInfo> map;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int size;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/FetchDiffTroopMemberRunnable$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.troopmemberlist.FetchDiffTroopMemberRunnable$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/troopmemberlist/FetchDiffTroopMemberRunnable$b", "Lcom/tencent/qqnt/troopmemberlist/f;", "", "isSuccess", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberList", "", "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f362745b;

        b(String str) {
            this.f362745b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FetchDiffTroopMemberRunnable.this, (Object) str);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.f
        public void a(boolean isSuccess, @NotNull List<? extends TroopMemberInfo> troopMemberList) {
            int collectionSizeOrDefault;
            int mapCapacity;
            int coerceAtLeast;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), troopMemberList);
                return;
            }
            Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
            List<? extends TroopMemberInfo> list = troopMemberList;
            String str = this.f362745b;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (Object obj : list) {
                String str2 = ((TroopMemberInfo) obj).memberuin;
                Intrinsics.checkNotNullExpressionValue(str2, "it.memberuin");
                linkedHashMap.put(com.tencent.qqnt.troopmemberlist.b.a(str, str2), obj);
            }
            FetchDiffTroopMemberRunnable.this.callback.a(linkedHashMap);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/troopmemberlist/FetchDiffTroopMemberRunnable$c", "Lcom/tencent/qqnt/troopmemberlist/g;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberInfo", "", "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements g {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f362747b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f362748c;

        c(String str, String str2) {
            this.f362747b = str;
            this.f362748c = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, FetchDiffTroopMemberRunnable.this, str, str2);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.g
        public void a(@Nullable TroopMemberInfo troopMemberInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                HashMap hashMap = FetchDiffTroopMemberRunnable.this.map;
                FetchDiffTroopMemberRunnable fetchDiffTroopMemberRunnable = FetchDiffTroopMemberRunnable.this;
                String str = this.f362747b;
                String str2 = this.f362748c;
                synchronized (hashMap) {
                    fetchDiffTroopMemberRunnable.map.put(com.tencent.qqnt.troopmemberlist.b.a(str, str2), troopMemberInfo);
                    fetchDiffTroopMemberRunnable.size--;
                    if (fetchDiffTroopMemberRunnable.size == 0) {
                        fetchDiffTroopMemberRunnable.callback.a(fetchDiffTroopMemberRunnable.map);
                    }
                    Unit unit = Unit.INSTANCE;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberInfo);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27644);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FetchDiffTroopMemberRunnable(@NotNull List<String> troopUins, @NotNull List<String> memberUins, @Nullable LifecycleOwner lifecycleOwner, @NotNull e callback) {
        Intrinsics.checkNotNullParameter(troopUins, "troopUins");
        Intrinsics.checkNotNullParameter(memberUins, "memberUins");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUins, memberUins, lifecycleOwner, callback);
            return;
        }
        this.troopUins = troopUins;
        this.memberUins = memberUins;
        this.lifecycleOwner = lifecycleOwner;
        this.callback = callback;
        this.map = new HashMap<>();
    }

    private final void e(String groupUin) {
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberUinListInfo(groupUin, this.memberUins, false, this.lifecycleOwner, "FetchDiffTroopMemberRun", new b(groupUin));
    }

    private final void f(String groupUin, String memberUin) {
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(groupUin, memberUin, false, this.lifecycleOwner, "FetchDiffTroopMemberRun", new c(groupUin, memberUin));
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.size = this.troopUins.size();
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.troopUins);
        if (hashSet.size() == 1) {
            e(this.troopUins.get(0));
            return;
        }
        int size = this.troopUins.size();
        for (int i3 = 0; i3 < size; i3++) {
            f(this.troopUins.get(i3), this.memberUins.get(i3));
        }
    }
}

package com.tencent.mobileqq.troop.troopnotification.repo;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.inner.TroopLifecycleCallback;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSingleScreenNotifiesCallback;
import com.tencent.qqnt.notification.ITroopNotificationInnerService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00182\u00020\u0001:\u0002),B\u0007\u00a2\u0006\u0004\b:\u0010;J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J4\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\tH\u0002J\u0016\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J(\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J6\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u001e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002JI\u0010#\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b27\u0010\"\u001a3\u0012%\u0012#\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\t\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00070\u001dj\u0002`!Jm\u0010&\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022U\u0010\"\u001aQ\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070$j\u0002`%R \u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020(0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R&\u0010-\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/Rp\u00106\u001aW\u0012S\u0012Q\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070$j\u0002`%018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105RR\u00109\u001a9\u00125\u00123\u0012%\u0012#\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\t\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00070\u001dj\u0002`!018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00103\u001a\u0004\b8\u00105\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/repo/TroopNotificationListRepo;", "", "", "category", "", "Lcom/tencent/qqnt/notification/f;", "notificationList", "", DomainData.DOMAIN_NAME, "", "cacheMap", "i", "cache", "", "l", "seq", "requestNum", "callbackId", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "nextStartSeq", "", "hasMore", "data", "f", "resultData", tl.h.F, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "notificationMap", "Lcom/tencent/mobileqq/troop/troopnotification/repo/FirstScreenNotificationCallback;", "callback", "o", "Lkotlin/Function3;", "Lcom/tencent/mobileqq/troop/troopnotification/repo/GetNotificationCallback;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "Lcom/tencent/mobileqq/troop/troopnotification/repo/TroopNotificationListRepo$b;", "a", "Ljava/util/Map;", "requestState", "b", "firstScreenNotification", "c", "I", "firstScreenCallbackId", "Lcom/tencent/qqnt/inner/TroopLifecycleCallback;", "d", "Lkotlin/Lazy;", "k", "()Lcom/tencent/qqnt/inner/TroopLifecycleCallback;", "getNotificationCallback", "e", "j", "firstScreenNotificationCallback", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopNotificationListRepo {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, b> requestState;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, List<com.tencent.qqnt.notification.f>> firstScreenNotification;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int firstScreenCallbackId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy getNotificationCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy firstScreenNotificationCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/repo/TroopNotificationListRepo$a;", "", "", "NUM_FIRST_SCREEN", "I", "NUM_PER_PAGE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopnotification.repo.TroopNotificationListRepo$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0011\u001a\u0004\b\n\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/repo/TroopNotificationListRepo$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "e", "(J)V", "nextSeq", "Z", "()Z", "d", "(Z)V", "hasMore", "c", "f", "isRequesting", "<init>", "(JZZ)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long nextSeq;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean hasMore;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean isRequesting;

        public b() {
            this(0L, false, false, 7, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
                return;
            }
            iPatchRedirector.redirect((short) 16, (Object) this);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.hasMore;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.nextSeq;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return this.isRequesting;
        }

        public final void d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, z16);
            } else {
                this.hasMore = z16;
            }
        }

        public final void e(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, j3);
            } else {
                this.nextSeq = j3;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.nextSeq == bVar.nextSeq && this.hasMore == bVar.hasMore && this.isRequesting == bVar.isRequesting) {
                return true;
            }
            return false;
        }

        public final void f(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, z16);
            } else {
                this.isRequesting = z16;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
            }
            int a16 = androidx.fragment.app.a.a(this.nextSeq) * 31;
            boolean z16 = this.hasMore;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (a16 + i16) * 31;
            boolean z17 = this.isRequesting;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return "RequestState(nextSeq=" + this.nextSeq + ", hasMore=" + this.hasMore + ", isRequesting=" + this.isRequesting + ")";
        }

        public b(long j3, boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            this.nextSeq = j3;
            this.hasMore = z16;
            this.isRequesting = z17;
        }

        public /* synthetic */ b(long j3, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? true : z16, (i3 & 4) != 0 ? false : z17);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59686);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopNotificationListRepo() {
        Map<Integer, b> mutableMapOf;
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        boolean z16 = false;
        long j3 = 0;
        boolean z17 = false;
        int i3 = 7;
        DefaultConstructorMarker defaultConstructorMarker = null;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(0, new b(0L, z16, false, 7, null)), TuplesKt.to(1, new b(j3, z17, z16, i3, defaultConstructorMarker)), TuplesKt.to(2, new b(j3, z17, z16, i3, defaultConstructorMarker)), TuplesKt.to(-1000, new b(0L, false, z17, 7, null)));
        this.requestState = mutableMapOf;
        this.firstScreenNotification = new LinkedHashMap();
        lazy = LazyKt__LazyJVMKt.lazy(TroopNotificationListRepo$getNotificationCallback$2.INSTANCE);
        this.getNotificationCallback = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(TroopNotificationListRepo$firstScreenNotificationCallback$2.INSTANCE);
        this.firstScreenNotificationCallback = lazy2;
    }

    private final void f(final int category, final long nextStartSeq, final boolean hasMore, final List<com.tencent.qqnt.notification.f> data, final int callbackId) {
        bg.k(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.repo.d
            @Override // java.lang.Runnable
            public final void run() {
                TroopNotificationListRepo.g(TroopNotificationListRepo.this, category, callbackId, data, hasMore, nextStartSeq);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(TroopNotificationListRepo this$0, int i3, int i16, List data, boolean z16, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        b bVar = this$0.requestState.get(Integer.valueOf(i3));
        if (bVar != null) {
            bVar.e(j3);
            boolean z17 = false;
            bVar.f(false);
            if (z16 && j3 > 0) {
                z17 = true;
            }
            bVar.d(z17);
        }
        if (i16 == this$0.firstScreenCallbackId) {
            this$0.n(i3, data);
            return;
        }
        this$0.h(i3, data);
        Function3<Integer, Boolean, List<com.tencent.qqnt.notification.f>, Unit> f16 = this$0.k().f(i16);
        if (f16 != null) {
            f16.invoke(Integer.valueOf(i3), Boolean.valueOf(z16), data);
        }
    }

    private final void h(int category, List<com.tencent.qqnt.notification.f> resultData) {
        com.tencent.qqnt.notification.f fVar;
        Object firstOrNull;
        Object lastOrNull;
        List<com.tencent.qqnt.notification.f> list = this.firstScreenNotification.get(Integer.valueOf(category));
        if (list != null) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list);
            fVar = (com.tencent.qqnt.notification.f) lastOrNull;
        } else {
            fVar = null;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) resultData);
        com.tencent.qqnt.notification.f fVar2 = (com.tencent.qqnt.notification.f) firstOrNull;
        if (fVar2 != null && fVar != null && fVar2.j().seq == fVar.j().seq) {
            CollectionsKt__MutableCollectionsKt.removeFirst(resultData);
            if (QLog.isColorLevel()) {
                QLog.d("TroopNotificationListRepo", 2, "filterFirstScreenNotification: filter msg.seq=" + fVar2.j().seq);
            }
        }
    }

    private final List<com.tencent.qqnt.notification.f> i(int category, Map<Integer, ? extends List<com.tencent.qqnt.notification.f>> cacheMap) {
        List<com.tencent.qqnt.notification.f> list;
        List<com.tencent.qqnt.notification.f> list2;
        if (cacheMap != null) {
            list = cacheMap.get(Integer.valueOf(category));
        } else {
            list = null;
        }
        if (category == -1000) {
            return list;
        }
        boolean z16 = false;
        if (cacheMap != null && (list2 = cacheMap.get(0)) != null && (!list2.isEmpty())) {
            z16 = true;
        }
        if (!z16) {
            return null;
        }
        return list;
    }

    private final TroopLifecycleCallback<Function1<Map<Integer, ? extends List<com.tencent.qqnt.notification.f>>, Unit>> j() {
        return (TroopLifecycleCallback) this.firstScreenNotificationCallback.getValue();
    }

    private final TroopLifecycleCallback<Function3<Integer, Boolean, List<com.tencent.qqnt.notification.f>, Unit>> k() {
        return (TroopLifecycleCallback) this.getNotificationCallback.getValue();
    }

    private final long l(List<com.tencent.qqnt.notification.f> cache) {
        Object lastOrNull;
        GroupNotifyMsg j3;
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) cache);
        com.tencent.qqnt.notification.f fVar = (com.tencent.qqnt.notification.f) lastOrNull;
        if (fVar != null && (j3 = fVar.j()) != null) {
            return j3.seq;
        }
        return 0L;
    }

    private final int m(int category) {
        if (category == -1000) {
            return 0;
        }
        return category;
    }

    private final void n(int category, List<com.tencent.qqnt.notification.f> notificationList) {
        Function1<Map<Integer, ? extends List<com.tencent.qqnt.notification.f>>, Unit> f16;
        this.firstScreenNotification.put(Integer.valueOf(category), notificationList);
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationListRepo", 2, "onGetFirstPageNotification: category=" + category + ", notificationList.size=" + notificationList.size() + ", curSize=" + this.firstScreenNotification.size());
        }
        if (this.firstScreenNotification.size() == this.requestState.size() && (f16 = j().f(this.firstScreenCallbackId)) != null) {
            f16.invoke(this.firstScreenNotification);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(TroopNotificationListRepo this$0, LifecycleOwner lifecycleOwner, Function1 callback) {
        Map<Integer, List<com.tencent.qqnt.notification.f>> map;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.firstScreenNotification.clear();
        this$0.firstScreenCallbackId = this$0.j().h(lifecycleOwner, callback);
        ITroopNotificationInnerService iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
        if (iTroopNotificationInnerService != null) {
            map = iTroopNotificationInnerService.getFirstPageNotification();
        } else {
            map = null;
        }
        for (Map.Entry<Integer, b> entry : this$0.requestState.entrySet()) {
            int intValue = entry.getKey().intValue();
            b value = entry.getValue();
            if (!value.c()) {
                value.e(0L);
                value.d(true);
                value.f(true);
                List<com.tencent.qqnt.notification.f> i3 = this$0.i(intValue, map);
                QLog.d("TroopNotificationListRepo", 1, "getFirstScreenNotification: get cache, category=" + intValue + ", cache=" + i3);
                if (i3 != null) {
                    this$0.f(intValue, this$0.l(i3), true, i3, this$0.firstScreenCallbackId);
                } else {
                    this$0.s(intValue, 0L, 20, this$0.firstScreenCallbackId);
                }
            } else {
                QLog.e("TroopNotificationListRepo", 1, "getFirstScreenNotification: error requesting category=" + intValue + ", state=" + value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(TroopNotificationListRepo this$0, int i3, LifecycleOwner lifecycleOwner, Function3 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "$lifecycleOwner");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        b bVar = this$0.requestState.get(Integer.valueOf(i3));
        if (bVar != null && !bVar.c() && bVar.a()) {
            bVar.f(true);
            this$0.s(i3, bVar.b(), 20, this$0.k().h(lifecycleOwner, callback));
        } else if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationListRepo", 2, "requestNextPageNotificationList: stop request, category=" + i3 + ", state=" + bVar);
        }
    }

    private final void s(final int category, final long seq, int requestNum, final int callbackId) {
        boolean z16;
        QLog.d("TroopNotificationListRepo", 1, "requestNotificationList: category=" + category + ", seq=" + seq + ", requestNum=" + requestNum);
        if (category == -1000) {
            z16 = true;
        } else {
            z16 = false;
        }
        int m3 = m(category);
        final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("getSingleScreenNotifiesV2", null, "TroopNotificationListRepo-requestNotificationList-" + z16 + "-" + m3, false, false, 18, null);
        s i3 = bg.i(null, 1, null);
        if (i3 != null) {
            final boolean z17 = z16;
            i3.getSingleScreenNotifiesV2(z16, seq, requestNum, m3, new IGetGroupSingleScreenNotifiesCallback() { // from class: com.tencent.mobileqq.troop.troopnotification.repo.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSingleScreenNotifiesCallback
                public final void onResult(long j3, long j16, boolean z18, ArrayList arrayList, ArrayList arrayList2) {
                    TroopNotificationListRepo.t(com.tencent.qqnt.report.m.this, z17, category, seq, this, callbackId, j3, j16, z18, arrayList, arrayList2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(com.tencent.qqnt.report.m cmdReport, boolean z16, final int i3, long j3, final TroopNotificationListRepo this$0, final int i16, final long j16, final long j17, final boolean z17, final ArrayList arrayList, final ArrayList arrayList2) {
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cmdReport.f();
        QLog.d("TroopNotificationListRepo", 1, "onResult: isDoubt=" + z16 + ", category=" + i3 + ", seq=" + j3 + ", curReadedSeq=" + j16 + ", nextStartSeq=" + j17 + ", hasMore=" + z17 + ", notifies.size=" + arrayList.size() + ", templates.size=" + arrayList2.size());
        bg.f302144a.j(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.repo.e
            @Override // java.lang.Runnable
            public final void run() {
                TroopNotificationListRepo.u(i3, arrayList, arrayList2, j16, this$0, j17, z17, i16);
            }
        });
        com.tencent.qqnt.report.m.c(cmdReport, 0, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(int i3, ArrayList notifies, ArrayList templates, long j3, TroopNotificationListRepo this$0, long j16, boolean z16, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.troop.troopnotification.utils.b bVar = com.tencent.mobileqq.troop.troopnotification.utils.b.f300925a;
        Intrinsics.checkNotNullExpressionValue(notifies, "notifies");
        Intrinsics.checkNotNullExpressionValue(templates, "templates");
        this$0.f(i3, j16, z16, bVar.h(i3, notifies, templates, j3, "TroopNotificationListRepo-requestNotificationList"), i16);
    }

    public final void o(@Nullable final LifecycleOwner lifecycleOwner, @NotNull final Function1<? super Map<Integer, ? extends List<com.tencent.qqnt.notification.f>>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) lifecycleOwner, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            bg.k(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.repo.a
                @Override // java.lang.Runnable
                public final void run() {
                    TroopNotificationListRepo.p(TroopNotificationListRepo.this, lifecycleOwner, callback);
                }
            });
        }
    }

    public final void q(@NotNull final LifecycleOwner lifecycleOwner, final int category, @NotNull final Function3<? super Integer, ? super Boolean, ? super List<com.tencent.qqnt.notification.f>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, lifecycleOwner, Integer.valueOf(category), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(callback, "callback");
        bg.k(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.repo.b
            @Override // java.lang.Runnable
            public final void run() {
                TroopNotificationListRepo.r(TroopNotificationListRepo.this, category, lifecycleOwner, callback);
            }
        });
    }
}

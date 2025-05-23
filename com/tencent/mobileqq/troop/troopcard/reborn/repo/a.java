package com.tencent.mobileqq.troop.troopcard.reborn.repo;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.mizarproto.passthrough.FunctionLockMsg$FunctionLockBeatRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0005\u0005\u0013\u0016\n\u0018J\u001f\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJC\u0010\u0013\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0016\u001a\u00020\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a;", "", "", "troopUin", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$c;", "d", "(Ljava/lang/String;Landroidx/lifecycle/LifecycleOwner;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "statOption", "authKey", "authSig", "", "joinGroupTransInfo", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$b;", "b", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$d;", "c", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$c;", "", "", "a", "Z", "b", "()Z", "isSuccess", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "<init>", "(ZLcom/tencent/mobileqq/data/troop/TroopInfo;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final TroopInfo troopInfo;

        public c(boolean z16, @Nullable TroopInfo troopInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), troopInfo);
            } else {
                this.isSuccess = z16;
                this.troopInfo = troopInfo;
            }
        }

        @Nullable
        public final TroopInfo a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (TroopInfo) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.troopInfo;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.isSuccess;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0010\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "isHighRiskTroop", "()Z", "b", "getCanWithoutVerify", "canWithoutVerify", "canJoinTroopWithoutVerify", "<init>", "(ZZ)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final /* data */ class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isHighRiskTroop;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final boolean canWithoutVerify;

        public d(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else {
                this.isHighRiskTroop = z16;
                this.canWithoutVerify = z17;
            }
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            if (!this.isHighRiskTroop && this.canWithoutVerify) {
                return true;
            }
            return false;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof d)) {
                return false;
            }
            d dVar = (d) other;
            if (this.isHighRiskTroop == dVar.isHighRiskTroop && this.canWithoutVerify == dVar.canWithoutVerify) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            boolean z16 = this.isHighRiskTroop;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.canWithoutVerify;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "QueryCanJoinTroopWithoutVerifyResult(isHighRiskTroop=" + this.isHighRiskTroop + ", canWithoutVerify=" + this.canWithoutVerify + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u000e\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$e;", "", "", "a", "Z", "d", "()Z", "isSuccess", "", "b", "I", "()I", "errorCode", "", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "errorMsg", "", "Lcom/tencent/mobileqq/data/troop/TroopClipPic;", "Ljava/util/List;", "()Ljava/util/List;", "troopClipPicList", "<init>", "(ZILjava/lang/String;Ljava/util/List;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int errorCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String errorMsg;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<TroopClipPic> troopClipPicList;

        public e(boolean z16, int i3, @NotNull String errorMsg, @NotNull List<? extends TroopClipPic> troopClipPicList) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            Intrinsics.checkNotNullParameter(troopClipPicList, "troopClipPicList");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3), errorMsg, troopClipPicList);
                return;
            }
            this.isSuccess = z16;
            this.errorCode = i3;
            this.errorMsg = errorMsg;
            this.troopClipPicList = troopClipPicList;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.errorCode;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.errorMsg;
        }

        @NotNull
        public final List<TroopClipPic> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (List) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.troopClipPicList;
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.isSuccess;
        }
    }

    @Nullable
    Object a(@Nullable String str, @NotNull Continuation<? super TroopInfo> continuation);

    @Nullable
    Object b(@Nullable String str, int i3, @Nullable String str2, @Nullable String str3, @Nullable byte[] bArr, @NotNull Continuation<? super b> continuation);

    @Nullable
    Object c(@Nullable String str, @NotNull String str2, @NotNull Continuation<? super d> continuation);

    @Nullable
    Object d(@Nullable String str, @Nullable LifecycleOwner lifecycleOwner, @NotNull Continuation<? super c> continuation);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u000e\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\f\u001a\u0004\b\b\u0010\rR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0003\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$a;", "", "", "a", "Z", "d", "()Z", "isSuccess", "b", "c", "isDisBind", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", "groupInfo", "", "", "Ljava/util/List;", "()Ljava/util/List;", "allMemberList", "<init>", "(ZZLcom/tencent/mobileqq/data/troop/TroopInfo;Ljava/util/List;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.repo.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C8792a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final boolean isDisBind;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final TroopInfo groupInfo;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<String> allMemberList;

        public C8792a(boolean z16, boolean z17, @NotNull TroopInfo groupInfo, @NotNull List<String> allMemberList) {
            Intrinsics.checkNotNullParameter(groupInfo, "groupInfo");
            Intrinsics.checkNotNullParameter(allMemberList, "allMemberList");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17), groupInfo, allMemberList);
                return;
            }
            this.isSuccess = z16;
            this.isDisBind = z17;
            this.groupInfo = groupInfo;
            this.allMemberList = allMemberList;
        }

        @NotNull
        public final List<String> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (List) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.allMemberList;
        }

        @NotNull
        public final TroopInfo b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (TroopInfo) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.groupInfo;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.isDisBind;
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isSuccess;
        }

        public /* synthetic */ C8792a(boolean z16, boolean z17, TroopInfo troopInfo, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, z17, troopInfo, (i3 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), troopInfo, list, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\tB7\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0018\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u0012\u0010\u0017R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\t\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "e", "()Z", "isSuccess", "b", "I", "()I", QzoneIPCModule.RESULT_CODE, "c", "d", "securityTipId", "", "J", "()J", "securityTime", "Ltrpc/mizarproto/passthrough/FunctionLockMsg$FunctionLockBeatRsp;", "Ltrpc/mizarproto/passthrough/FunctionLockMsg$FunctionLockBeatRsp;", "()Ltrpc/mizarproto/passthrough/FunctionLockMsg$FunctionLockBeatRsp;", "functionLockBeatRsp", "<init>", "(ZIIJLtrpc/mizarproto/passthrough/FunctionLockMsg$FunctionLockBeatRsp;)V", "f", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int resultCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int securityTipId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long securityTime;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final FunctionLockMsg$FunctionLockBeatRsp functionLockBeatRsp;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$b$a;", "", "", "RESULT_CODE_SECURITY_TIP", "I", "RESULT_CODE_TEMPORARY_BAN", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.repo.a$b$a, reason: collision with other inner class name and from kotlin metadata */
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

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57228);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 17)) {
                redirector.redirect((short) 17);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public b(boolean z16, int i3, int i16, long j3, @Nullable FunctionLockMsg$FunctionLockBeatRsp functionLockMsg$FunctionLockBeatRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), functionLockMsg$FunctionLockBeatRsp);
                return;
            }
            this.isSuccess = z16;
            this.resultCode = i3;
            this.securityTipId = i16;
            this.securityTime = j3;
            this.functionLockBeatRsp = functionLockMsg$FunctionLockBeatRsp;
        }

        @Nullable
        public final FunctionLockMsg$FunctionLockBeatRsp a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (FunctionLockMsg$FunctionLockBeatRsp) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.functionLockBeatRsp;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.resultCode;
        }

        public final long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
            }
            return this.securityTime;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.securityTipId;
        }

        public final boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isSuccess;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.isSuccess == bVar.isSuccess && this.resultCode == bVar.resultCode && this.securityTipId == bVar.securityTipId && this.securityTime == bVar.securityTime && Intrinsics.areEqual(this.functionLockBeatRsp, bVar.functionLockBeatRsp)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
            }
            boolean z16 = this.isSuccess;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int a16 = ((((((r06 * 31) + this.resultCode) * 31) + this.securityTipId) * 31) + androidx.fragment.app.a.a(this.securityTime)) * 31;
            FunctionLockMsg$FunctionLockBeatRsp functionLockMsg$FunctionLockBeatRsp = this.functionLockBeatRsp;
            if (functionLockMsg$FunctionLockBeatRsp == null) {
                hashCode = 0;
            } else {
                hashCode = functionLockMsg$FunctionLockBeatRsp.hashCode();
            }
            return a16 + hashCode;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return "JoinTroopResult(isSuccess=" + this.isSuccess + ", resultCode=" + this.resultCode + ", securityTipId=" + this.securityTipId + ", securityTime=" + this.securityTime + ", functionLockBeatRsp=" + this.functionLockBeatRsp + ")";
        }

        public /* synthetic */ b(boolean z16, int i3, int i16, long j3, FunctionLockMsg$FunctionLockBeatRsp functionLockMsg$FunctionLockBeatRsp, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, i3, (i17 & 4) != 0 ? 0 : i16, (i17 & 8) != 0 ? 0L : j3, (i17 & 16) != 0 ? null : functionLockMsg$FunctionLockBeatRsp);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), functionLockMsg$FunctionLockBeatRsp, Integer.valueOf(i17), defaultConstructorMarker);
        }
    }
}

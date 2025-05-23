package com.tencent.mobileqq.troop.troopcreate.api;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\fJD\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u0006H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/api/ITroopCreateContactDataProvider;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "Lkotlin/collections/ArrayList;", "robotList", "", "uinsToHide", "Lcom/tencent/mobileqq/troop/troopcreate/api/ITroopCreateContactDataProvider$a;", "loadContactData", "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopCreateContactDataProvider extends QRouteApi {

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\u001c\u0010\u0015\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00010\tj\b\u0012\u0004\u0012\u00020\u0001`\u000b0\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR-\u0010\u0015\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00010\tj\b\u0012\u0004\u0012\u00020\u0001`\u000b0\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0011\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/api/ITroopCreateContactDataProvider$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "groups", "Landroid/util/SparseArray;", "b", "Landroid/util/SparseArray;", "c", "()Landroid/util/SparseArray;", "members", "", "J", "()J", "setLoadDataTime", "(J)V", "loadDataTime", "<init>", "(Ljava/util/ArrayList;Landroid/util/SparseArray;J)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<b> groups;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final SparseArray<ArrayList<Object>> members;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private long loadDataTime;

        public a(@NotNull ArrayList<b> groups, @NotNull SparseArray<ArrayList<Object>> members, long j3) {
            Intrinsics.checkNotNullParameter(groups, "groups");
            Intrinsics.checkNotNullParameter(members, "members");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, groups, members, Long.valueOf(j3));
                return;
            }
            this.groups = groups;
            this.members = members;
            this.loadDataTime = j3;
        }

        @NotNull
        public final ArrayList<b> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.groups;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.loadDataTime;
        }

        @NotNull
        public final SparseArray<ArrayList<Object>> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (SparseArray) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.members;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (Intrinsics.areEqual(this.groups, aVar.groups) && Intrinsics.areEqual(this.members, aVar.members) && this.loadDataTime == aVar.loadDataTime) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return (((this.groups.hashCode() * 31) + this.members.hashCode()) * 31) + androidx.fragment.app.a.a(this.loadDataTime);
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "Result(groups=" + this.groups + ", members=" + this.members + ", loadDataTime=" + this.loadDataTime + ")";
        }
    }

    @NotNull
    a loadContactData(@NotNull Context context, @NotNull ArrayList<RobotCoreInfo> robotList, @Nullable ArrayList<String> uinsToHide);
}

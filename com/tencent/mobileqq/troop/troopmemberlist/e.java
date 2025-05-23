package com.tencent.mobileqq.troop.troopmemberlist;

import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007JR\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmemberlist/e;", "", "", "troopUin", "", "sortType", "", "a", "", "timeCost", "memberCount", "maxIndex", "", "hadEnterSearch", "readFromDB", "convertDataCost", "convertDataOpt", "b", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f300629a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58572);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f300629a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@Nullable String troopUin, int sortType) {
        HashMap hashMap = new HashMap();
        hashMap.put("listType", String.valueOf(sortType));
        if (troopUin == null) {
            troopUin = "";
        }
        hashMap.put("groupCode", troopUin);
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("actGroupMemberListOpen", hashMap);
    }

    @JvmStatic
    public static final void b(long timeCost, int memberCount, int maxIndex, boolean hadEnterSearch, boolean readFromDB, long convertDataCost, int convertDataOpt, @Nullable String troopUin, int sortType) {
        HashMap hashMap = new HashMap();
        hashMap.put("costTime", String.valueOf(timeCost));
        hashMap.put("totalMemberCount", String.valueOf(memberCount));
        hashMap.put("listType", String.valueOf(sortType));
        if (troopUin == null) {
            troopUin = "";
        }
        hashMap.put("groupCode", troopUin);
        hashMap.put("maxIndex", String.valueOf(maxIndex));
        hashMap.put("hadEnterSearch", String.valueOf(hadEnterSearch));
        hashMap.put("readFromDB", String.valueOf(readFromDB));
        hashMap.put("convertDataCost", String.valueOf(convertDataCost));
        hashMap.put("convertDataOpt", String.valueOf(convertDataOpt));
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("actGroupMemberListShow", hashMap);
        if (QLog.isColorLevel()) {
            QLog.d(TroopMemberListActivity.TAG_TIME, 2, "final time cost: ", Long.valueOf(timeCost), ", maxIndex:", Integer.valueOf(maxIndex), ", readFromDB: ", Boolean.valueOf(readFromDB));
        }
    }
}

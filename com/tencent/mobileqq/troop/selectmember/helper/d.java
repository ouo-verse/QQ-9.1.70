package com.tencent.mobileqq.troop.selectmember.helper;

import android.app.Activity;
import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.qqnt.troopmemberlist.TroopMemberListRepo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/helper/d;", "", "Landroid/app/Activity;", EventKey.ACT, "", "troopUin", "", "a", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "b", "", "fetchType", "", "c", "", "d", "", "Ljava/util/Map;", "hadFetchTroopMemberListInProcess", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f298358a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Boolean> hadFetchTroopMemberListInProcess;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54828);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f298358a = new d();
            hadFetchTroopMemberListInProcess = new HashMap();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final long a(Activity act, String troopUin) {
        if (act == null) {
            return 0L;
        }
        return b(act).getLong("key_last_update_time" + troopUin, 0L);
    }

    private final SharedPreferences b(Activity act) {
        String str;
        AppInterface e16 = bg.e();
        if (e16 != null) {
            str = e16.getCurrentAccountUin();
        } else {
            str = null;
        }
        return act.getSharedPreferences(DeviceProfileManager.KEY_LAST_UPDATE_TIME + str, 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c(@Nullable Activity act, @Nullable String troopUin, int fetchType) {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, act, troopUin, Integer.valueOf(fetchType))).booleanValue();
        }
        if (fetchType == 2) {
            return false;
        }
        if (fetchType == 3) {
            return true;
        }
        long a16 = a(act, troopUin);
        long abs = Math.abs(System.currentTimeMillis() - a16);
        if (TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin) != null) {
            Boolean bool = hadFetchTroopMemberListInProcess.get(troopUin);
            if (bool != null && bool.booleanValue()) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18 && TroopMemberListRepo.INSTANCE.isTroopMemberListExpired(troopUin)) {
                z16 = true;
                if (a16 == 0 && (a16 <= 0 || abs <= MiniBoxNoticeInfo.MIN_5)) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopMemberTimeValidity", 2, "[needRequestServer] cacheExpired:" + z17 + ", seqExpired:" + z16 + ", lastUpdateTime:" + a16 + ", timeDiff:" + abs);
                }
                if (z17 && !z16) {
                    return false;
                }
            }
        }
        z16 = false;
        if (a16 == 0) {
        }
        z17 = true;
        if (QLog.isColorLevel()) {
        }
        return z17 ? true : true;
    }

    public final void d(@Nullable Activity act, @Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) act, (Object) troopUin);
            return;
        }
        if (act == null) {
            return;
        }
        b(act).edit().putLong("key_last_update_time" + troopUin, System.currentTimeMillis()).commit();
    }
}

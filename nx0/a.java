package nx0;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.icgame.game.utils.g;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.env.ServerEnv;
import com.tencent.timi.game.utils.y;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.util.LogUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a implements mx0.a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Long> f421515a = new HashMap();

    private SharedPreferences N3() {
        return QMMKV.fromSpAdapter(BaseApplication.getContext(), "icgame_common_account_" + ServerEnv.b(), QMMKVFile.FILE_ICGAME);
    }

    @Override // mx0.a
    public String B() {
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount != null) {
            return firstSimpleAccount.getUin();
        }
        return "";
    }

    @Override // mx0.a
    public CommonOuterClass$QQUserId E() {
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
        commonOuterClass$QQUserId.yes_uid.set(g3());
        commonOuterClass$QQUserId.uid.set(h());
        return commonOuterClass$QQUserId;
    }

    public long g3() {
        String B = B();
        Long l3 = f421515a.get(B);
        if (l3 != null) {
            return l3.longValue();
        }
        Long valueOf = Long.valueOf(N3().getLong("key_yes_uid_" + B, 0L));
        if (valueOf.longValue() != 0) {
            f421515a.put(B, valueOf);
        }
        return valueOf.longValue();
    }

    @Override // mx0.a
    public long h() {
        try {
            return Long.parseLong(B());
        } catch (NumberFormatException e16) {
            g.e("ICGameLoginCoreImpl", "convert uid to long error", e16);
            return 0L;
        }
    }

    @Override // mx0.a
    public String o(long j3) {
        return y.b(j3);
    }

    @Override // mx0.a
    public void v(String str, long j3) {
        g.a("ICGameLoginCoreImpl", "saveYesUid uin:" + LogUtil.getSafePrintUin(str) + ", yesUid:" + j3);
        f421515a.put(str, Long.valueOf(j3));
        N3().edit().putLong("key_yes_uid_" + str, j3).apply();
    }

    @Override // mm4.a
    public void o2() {
    }

    @Override // mm4.a
    public void init(Context context) {
    }
}

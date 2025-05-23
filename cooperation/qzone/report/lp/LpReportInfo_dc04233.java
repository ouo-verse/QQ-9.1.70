package cooperation.qzone.report.lp;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_dc04233 implements LpReportInfo {
    private static final String KIND_CARD_SP = "king_card_sp";
    private static final String SP_KEY = "lastReportTime";
    private static final String TAG = "LpReportInfo_dc04233";
    public int isKingCard;
    public String qua;
    public long uin;

    public LpReportInfo_dc04233(long j3, int i3) {
        this.uin = j3;
        this.isKingCard = i3;
    }

    private boolean isNeedReport() {
        SharedPreferences sharedPreferences = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getSharedPreferences(KIND_CARD_SP);
        String string = sharedPreferences.getString(SP_KEY, "");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        if (TextUtils.isEmpty(string)) {
            sharedPreferences.edit().putString(SP_KEY, simpleDateFormat.format(date)).apply();
            return true;
        }
        try {
            double time = ((date.getTime() - simpleDateFormat.parse(string).getTime()) * 1.0d) / 3600000.0d;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "dc04233 offest time = " + time);
            }
            if (time >= 24.0d) {
                sharedPreferences.edit().putString(SP_KEY, simpleDateFormat.format(date)).apply();
                return true;
            }
            return false;
        } catch (ParseException e16) {
            e16.printStackTrace();
            sharedPreferences.edit().putString(SP_KEY, simpleDateFormat.format(date)).apply();
            return true;
        }
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "dc04233 uin: " + this.uin + " isKingCard: " + this.isKingCard;
    }

    public void report() {
        if (isNeedReport()) {
            LpReportManager.getInstance().reportToDC04233(this, false, false);
        } else if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "dc04233 has report");
        }
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("uin", String.valueOf(this.uin));
        hashMap.put("is_kingcard", String.valueOf(this.isKingCard));
        LpReportUtils.safePut(hashMap, "qua", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        return hashMap;
    }
}

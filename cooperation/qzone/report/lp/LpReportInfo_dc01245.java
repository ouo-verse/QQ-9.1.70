package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_dc01245 implements LpReportInfo {
    public static final int EXPOSE_BAR = 12;
    public static final int EXPOSE_DETAIL = 4;
    public static final int EXPOSE_END = 5;
    public static final int EXPOSE_FRIENDFEED = 2;
    public static final int EXPOSE_MYSHUOSHUO = 13;
    public static final int EXPOSE_PUSH = 11;
    public static final int EXPOSE_USERHOME = 3;
    public int expose_src;
    public String qua;
    public int reserve1;
    public int reserve2;
    public int reserve3;
    public long uin;
    public int zhubo_type;
    public long zhubo_uin;

    public LpReportInfo_dc01245(long j3, long j16, int i3, int i16) {
        this.zhubo_uin = j3;
        this.uin = j16;
        this.expose_src = i3;
        this.zhubo_type = i16;
    }

    public static void report(long j3, long j16, int i3, int i16) {
        LpReportManager.getInstance().reportToDC01245(new LpReportInfo_dc01245(j3, j16, i3, i16), false, true);
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "dc01245 expose_src\uff1a" + this.expose_src;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("zhubo_uin", String.valueOf(this.zhubo_uin));
        long j3 = this.uin;
        if (j3 != 0) {
            hashMap.put("uin", String.valueOf(j3));
        } else {
            hashMap.put("uin", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount());
        }
        hashMap.put("expose_time", String.valueOf(System.currentTimeMillis()));
        hashMap.put("expose_src", String.valueOf(this.expose_src));
        hashMap.put("qua", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        hashMap.put("zhubo_type", String.valueOf(this.zhubo_type));
        hashMap.put("reserve1", String.valueOf(this.reserve1));
        hashMap.put("reserve2", String.valueOf(this.reserve2));
        hashMap.put("reserve3", String.valueOf(this.reserve3));
        return hashMap;
    }
}

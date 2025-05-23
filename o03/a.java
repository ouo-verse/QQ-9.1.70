package o03;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.vas.comm.api.notify.ServiceAssMsgTemplateItem;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements b {
    @Override // o03.b
    public void a(long j3, boolean z16) {
        String str = "1";
        WadlReportBuilder ext = new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("914719").setOperModule("9435").setOpertype("8").setExt(1, "943501").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD);
        if (!z16) {
            str = "2";
        }
        ext.setExt(6, str).setGameAppId(String.valueOf(j3)).report();
    }

    @Override // o03.b
    public void b(String str, boolean z16) {
        String str2 = "1";
        WadlReportBuilder ext = new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("914721").setOperModule("9435").setOpertype("20").setExt(1, "943501").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD);
        if (!z16) {
            str2 = "2";
        }
        ext.setExt(6, str2).setExt(2, str).setGameAppId(str).report();
    }

    @Override // o03.b
    public void c(long j3, boolean z16) {
        String str = "1";
        WadlReportBuilder ext = new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("914718").setOperModule("9435").setOpertype("20").setExt(1, "943501").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD);
        if (!z16) {
            str = "2";
        }
        ext.setExt(6, str).setGameAppId(String.valueOf(j3)).report();
    }

    @Override // o03.b
    public void d(int i3, String str, ArrayList<ServiceAssMsgTemplateItem> arrayList) {
        String str2 = "1";
        WadlReportBuilder ext = new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("914720").setOperModule("9435").setOpertype("8").setExt(1, "943501").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD);
        if (i3 != 1) {
            str2 = "2";
        }
        ext.setExt(6, str2).setExt(2, str).setGameAppId(str).report();
    }

    @Override // o03.b
    public void e(long j3) {
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("914717").setOperModule("9435").setOpertype("7").setGameAppId(String.valueOf(j3)).setExt(1, "943501").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(6, "0").report();
    }
}

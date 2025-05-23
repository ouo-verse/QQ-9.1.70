package hc0;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeAction;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.biz.qqcircle.tedgers2.datapool.DataPoolConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tedger.outapi.beans.EdgeAction;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.delegate.d;
import common.config.service.QzoneConfig;
import hc0.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class r implements com.tencent.tedger.outapi.delegate.d {

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.biz.qqcircle.tedgers2.datapool.a f404725a;

    /* renamed from: b, reason: collision with root package name */
    private a f404726b;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        List<e30.b> a();

        void b(String str, List<EdgeItem> list);
    }

    public r(com.tencent.tedger.outapi.delegate.f fVar) {
        this.f404725a = new com.tencent.biz.qqcircle.tedgers2.datapool.a(new dc0.b(fVar));
    }

    private List<EdgeItem> e() {
        return ic0.b.c(bc0.a.g().h(), 2);
    }

    private void g(Map<String, Object> map, d.a aVar) {
        ArrayList arrayList = new ArrayList();
        List<QFSEdgeItem> e16 = this.f404725a.e(Integer.MAX_VALUE);
        if (e16 != null) {
            arrayList.addAll(e16);
        }
        arrayList.addAll(e());
        aVar.a(new EdgeStatus(), arrayList, new HashMap());
    }

    private void h(Map<String, Object> map, final d.a aVar) {
        List<EdgeItem> list;
        final a aVar2 = this.f404726b;
        if (aVar2 != null) {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_tedge_enable_main_thread_get_feed_list", true)) {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: hc0.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        r.k(r.a.this, aVar);
                    }
                });
                return;
            }
            List<e30.b> a16 = aVar2.a();
            if (a16 != null) {
                list = ic0.b.c(a16, 0);
            } else {
                list = null;
            }
            aVar.a(new EdgeStatus(), list, null);
            return;
        }
        aVar.a(new EdgeStatus(), null, null);
        QLog.e("TEDGEQFS_QFSRerankItemDelegate", 1, "[getUnExposuredItems] clientRerankDelegate is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(List list, d.a aVar) {
        List<EdgeItem> list2;
        if (list != null) {
            list2 = ic0.b.c(list, 0);
        } else {
            list2 = null;
        }
        aVar.a(new EdgeStatus(), list2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(a aVar, final d.a aVar2) {
        final List<e30.b> a16 = aVar.a();
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: hc0.q
            @Override // java.lang.Runnable
            public final void run() {
                r.j(a16, aVar2);
            }
        });
    }

    @Override // com.tencent.tedger.outapi.delegate.d
    public EdgeStatus a(String str, EdgeAction edgeAction, List<EdgeItem> list) {
        List<QFSEdgeItem> a16 = ic0.b.a(list);
        QLog.d("TEDGEQFS_QFSRerankItemDelegate", 1, "[onRankFinished] mClientRerankDelegate:" + this.f404726b + ",reqId:" + str + ",qfsEdgeItems size:" + a16.size());
        if ((edgeAction instanceof QFSEdgeAction) && ((QFSEdgeAction) edgeAction).pageRefreshToken != cc0.e.f30630e) {
            QLog.e("TEDGEQFS_QFSRerankItemDelegate", 1, "[onRankFinished] pageRefresh token have reset");
            ic0.d.c("pageToken refresh");
            return new EdgeStatus();
        }
        c.f404686a++;
        ic0.e.b(list, str);
        a aVar = this.f404726b;
        if (aVar != null) {
            aVar.b(str, list);
            this.f404725a.h(a16);
            return new EdgeStatus();
        }
        QLog.e("TEDGEQFS_QFSRerankItemDelegate", 1, "[onRankFinished] mClientRerankDelegate is null");
        EdgeStatus edgeStatus = new EdgeStatus();
        edgeStatus.setCode(-101L);
        edgeStatus.setMsg("mClientRerankDelegate is null");
        ic0.d.c("mClientRerankDelegate is null");
        return edgeStatus;
    }

    @Override // com.tencent.tedger.outapi.delegate.d
    public void b(String str, List<EdgeItem> list, Map<String, Object> map, d.a aVar) {
        if (str.equals("cloud_rerank_data_source_type")) {
            c.d(list, map, aVar);
        } else if (str.equals("unexposed_data_source_type")) {
            h(map, aVar);
        } else if (str.equals("client_rerank_data_source_type")) {
            g(map, aVar);
        }
    }

    @NonNull
    public com.tencent.biz.qqcircle.tedgers2.datapool.a f() {
        return this.f404725a;
    }

    public void i(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        JSONObject jSONObject2;
        String str5 = "";
        try {
            jSONObject2 = jSONObject.getJSONObject("candidate_params");
            str = jSONObject2.getString("seal_max_size");
            try {
                str2 = jSONObject2.getString("seal_min_size");
                try {
                    str3 = jSONObject2.getString("detail_min_size");
                    try {
                        str4 = jSONObject2.getString("detail_add_num");
                    } catch (Exception e16) {
                        e = e16;
                        str4 = "";
                    }
                } catch (Exception e17) {
                    e = e17;
                    str3 = "";
                    str4 = str3;
                    QLog.e("TEDGEQFS_QFSRerankItemDelegate", 1, "QFSRankEdgeDataCenter parse candidate failed,e:" + e);
                    int a16 = ic0.f.a(str, 50);
                    int a17 = ic0.f.a(str2, 30);
                    int a18 = ic0.f.a(str3, 12);
                    int a19 = ic0.f.a(str4, 6);
                    long a26 = ic0.f.a(str5, QzoneConfig.DefaultValue.MOOD_RECENT_NEW_PHOTO_TIME) * 1000;
                    DataPoolConfig dataPoolConfig = new DataPoolConfig();
                    dataPoolConfig.f92464a = true;
                    dataPoolConfig.f92467d = a18;
                    dataPoolConfig.f92465b = a17;
                    dataPoolConfig.f92466c = a16;
                    dataPoolConfig.f92470g = a26;
                    dataPoolConfig.f92472i = a19;
                    this.f404725a.j(dataPoolConfig);
                    this.f404725a.k();
                }
            } catch (Exception e18) {
                e = e18;
                str2 = "";
                str3 = str2;
                str4 = str3;
                QLog.e("TEDGEQFS_QFSRerankItemDelegate", 1, "QFSRankEdgeDataCenter parse candidate failed,e:" + e);
                int a162 = ic0.f.a(str, 50);
                int a172 = ic0.f.a(str2, 30);
                int a182 = ic0.f.a(str3, 12);
                int a192 = ic0.f.a(str4, 6);
                long a262 = ic0.f.a(str5, QzoneConfig.DefaultValue.MOOD_RECENT_NEW_PHOTO_TIME) * 1000;
                DataPoolConfig dataPoolConfig2 = new DataPoolConfig();
                dataPoolConfig2.f92464a = true;
                dataPoolConfig2.f92467d = a182;
                dataPoolConfig2.f92465b = a172;
                dataPoolConfig2.f92466c = a162;
                dataPoolConfig2.f92470g = a262;
                dataPoolConfig2.f92472i = a192;
                this.f404725a.j(dataPoolConfig2);
                this.f404725a.k();
            }
        } catch (Exception e19) {
            e = e19;
            str = "";
            str2 = str;
        }
        try {
            str5 = jSONObject2.getString("timeout");
        } catch (Exception e26) {
            e = e26;
            QLog.e("TEDGEQFS_QFSRerankItemDelegate", 1, "QFSRankEdgeDataCenter parse candidate failed,e:" + e);
            int a1622 = ic0.f.a(str, 50);
            int a1722 = ic0.f.a(str2, 30);
            int a1822 = ic0.f.a(str3, 12);
            int a1922 = ic0.f.a(str4, 6);
            long a2622 = ic0.f.a(str5, QzoneConfig.DefaultValue.MOOD_RECENT_NEW_PHOTO_TIME) * 1000;
            DataPoolConfig dataPoolConfig22 = new DataPoolConfig();
            dataPoolConfig22.f92464a = true;
            dataPoolConfig22.f92467d = a1822;
            dataPoolConfig22.f92465b = a1722;
            dataPoolConfig22.f92466c = a1622;
            dataPoolConfig22.f92470g = a2622;
            dataPoolConfig22.f92472i = a1922;
            this.f404725a.j(dataPoolConfig22);
            this.f404725a.k();
        }
        int a16222 = ic0.f.a(str, 50);
        int a17222 = ic0.f.a(str2, 30);
        int a18222 = ic0.f.a(str3, 12);
        int a19222 = ic0.f.a(str4, 6);
        long a26222 = ic0.f.a(str5, QzoneConfig.DefaultValue.MOOD_RECENT_NEW_PHOTO_TIME) * 1000;
        DataPoolConfig dataPoolConfig222 = new DataPoolConfig();
        dataPoolConfig222.f92464a = true;
        dataPoolConfig222.f92467d = a18222;
        dataPoolConfig222.f92465b = a17222;
        dataPoolConfig222.f92466c = a16222;
        dataPoolConfig222.f92470g = a26222;
        dataPoolConfig222.f92472i = a19222;
        this.f404725a.j(dataPoolConfig222);
        this.f404725a.k();
    }

    public void l() {
        this.f404725a.d();
    }

    public void m(a aVar) {
        this.f404726b = aVar;
    }
}

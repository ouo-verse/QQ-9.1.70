package lo0;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.ey;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import vh2.m;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f415066a;

    /* renamed from: b, reason: collision with root package name */
    private final AppInterface f415067b;

    /* renamed from: c, reason: collision with root package name */
    private int f415068c = 0;

    /* renamed from: d, reason: collision with root package name */
    private final List<a> f415069d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private ey f415070e;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void a(ey eyVar);
    }

    public b(AppInterface appInterface, String str) {
        this.f415067b = appInterface;
        this.f415066a = str;
    }

    private void b() {
        if (this.f415068c != 0) {
            return;
        }
        this.f415068c = 1;
        ((IGPSService) this.f415067b.getRuntimeService(IGPSService.class, "")).fetchRemainAtSetInfo(this.f415066a, new m() { // from class: lo0.a
            @Override // vh2.m
            public final void a(int i3, String str, ey eyVar) {
                b.this.d(i3, str, eyVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(int i3, String str, ey eyVar) {
        if (i3 != 0) {
            this.f415068c = 0;
            return;
        }
        this.f415068c = 2;
        this.f415070e = eyVar;
        e(eyVar);
        Iterator<a> it = this.f415069d.iterator();
        while (it.hasNext()) {
            it.next().a(eyVar);
        }
        this.f415069d.clear();
    }

    private void e(ey eyVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("atAllNum", eyVar.getRemainingAtAllCount());
            jSONObject.put("atOnlineNum", eyVar.getRemainingAtOnlCount());
            jSONObject.put("atRoleNum", eyVar.getRemainingAtRoleCount());
            jSONObject.put("atNotifyNum", eyVar.getRemainingAtNotifyTimes());
            ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).saveAtRemainNum(this.f415066a, jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void c(a aVar) {
        if (this.f415068c == 2) {
            aVar.a(this.f415070e);
        } else {
            this.f415069d.add(aVar);
            b();
        }
    }
}

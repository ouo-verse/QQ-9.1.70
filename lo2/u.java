package lo2;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon$ResultItem;
import unite.DynamicSearch$ResultItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class u extends m implements View.OnClickListener {

    /* renamed from: f0, reason: collision with root package name */
    public static final String f415277f0 = "u";

    /* renamed from: b0, reason: collision with root package name */
    public JSONObject f415278b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f415279c0;

    /* renamed from: d0, reason: collision with root package name */
    public String f415280d0;

    /* renamed from: e0, reason: collision with root package name */
    public String f415281e0;

    /* JADX INFO: Access modifiers changed from: protected */
    public u(String str, long j3, List<String> list, int i3, JSONObject jSONObject, int i16, DynamicSearch$ResultItem dynamicSearch$ResultItem) {
        super(str, j3, list, dynamicSearch$ResultItem, i3);
        this.f415278b0 = jSONObject;
        this.f415279c0 = i16;
        X(jSONObject);
    }

    @Override // lo2.m
    public int K(int i3) {
        switch (i3) {
            case 8:
            case 9:
            case 10:
            case 11:
                return i3;
            default:
                return 1;
        }
    }

    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        v(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        HashMap<com.tencent.mobileqq.search.model.v, SearchUtils.d> hashMap = SearchUtils.f284965n;
        if (hashMap.containsKey(this)) {
            SearchUtils.d dVar = hashMap.get(this);
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                jSONObject.put("event_src", "client");
                jSONObject.put("obj_lct", dVar.f284978c);
                jSONObject.put("get_src", "web");
                jSONObject.put("extra_info", this.f415280d0);
                jSONObject.put("tepl", this.M);
            } catch (JSONException e16) {
                QLog.e(f415277f0, 2, "e = " + e16);
            }
            com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(this.J + "").obj2(this.f415281e0).ver1(this.N).ver2(com.tencent.mobileqq.search.report.b.a(this.R)).ver7(jSONObject.toString()).session_id(appInterface.getCurrentAccountUin() + SearchUtils.f284963l));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public u(String str, long j3, List<String> list, int i3, JSONObject jSONObject, int i16, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem) {
        super(str, j3, list, unifySearchCommon$ResultItem, i3);
        this.f415278b0 = jSONObject;
        this.f415279c0 = i16;
        X(jSONObject);
    }

    public void W(com.tencent.mobileqq.search.business.net.view.i iVar) {
    }

    public void X(JSONObject jSONObject) {
    }
}

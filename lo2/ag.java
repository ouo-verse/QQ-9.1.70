package lo2;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.sugreport.NetSearchSugWXReport;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsIcon;
import com.tencent.qqnt.kernel.nativeinterface.UfsResultItem;
import com.tencent.qqnt.kernel.nativeinterface.UfsSugWordInfo;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ag extends m {

    /* renamed from: b0, reason: collision with root package name */
    private final String f415115b0;

    /* renamed from: c0, reason: collision with root package name */
    private final UfsSugWordInfo f415116c0;

    /* renamed from: d0, reason: collision with root package name */
    private final JSONObject f415117d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f415118e0;

    public ag(String str, long j3, List<String> list, UfsResultItem ufsResultItem, int i3) {
        super(str, j3, list, ufsResultItem, i3);
        this.f415118e0 = false;
        String str2 = ufsResultItem.name;
        this.f415115b0 = str2 == null ? "" : str2;
        String g16 = SearchUtils.g(this.K);
        this.K = g16;
        this.K = W(g16);
        UfsSugWordInfo ufsSugWordInfo = ufsResultItem.sugWordInfo;
        this.f415116c0 = ufsSugWordInfo;
        JSONObject a16 = com.tencent.mobileqq.search.util.ad.f284990a.a(this.M);
        this.f415117d0 = a16;
        if (QLog.isDebugVersion() && a16 != null) {
            ufsSugWordInfo.tag = NetSearchSugWXReport.f284428a.e(a16);
        }
    }

    private String W(String str) {
        try {
            String string = new JSONObject(this.M).getString("trace_id");
            if (!TextUtils.isEmpty(str)) {
                return Uri.parse(str).buildUpon().appendQueryParameter("sug_trace_id", string).toString();
            }
            return str;
        } catch (JSONException e16) {
            QLog.w(m.f415228a0, 1, "addSchemaSugTraceId json error", e16);
            return str;
        }
    }

    private void b0() {
        NetSearchSugWXReport netSearchSugWXReport = NetSearchSugWXReport.f284428a;
        if (netSearchSugWXReport.f(this.f415116c0.sugWordType, this.f415117d0)) {
            netSearchSugWXReport.g(NetSearchSugWXReport.ReqBusinessType.LOCAL_SEARCH, NetSearchSugWXReport.SugReportActionType.CLICK, this.Y, this.Z, this.N, this.f415115b0, this.f415117d0);
        }
    }

    @Override // lo2.m
    protected boolean G() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // lo2.m
    public void T() {
        super.T();
        b0();
    }

    public UfsIcon X() {
        return this.f415116c0.icon;
    }

    public JSONObject Y() {
        return this.f415117d0;
    }

    public UfsSugWordInfo Z() {
        return this.f415116c0;
    }

    public String a0() {
        return this.f415116c0.tag;
    }

    public String toString() {
        return "NetSearchTemplateSuggestWordsItem{name='" + this.f415115b0 + "', id='" + this.G + "', groupMask=" + this.J + ", keyword='" + this.N + "', from=" + this.R + ", source=" + this.C + ", sugWordInfo=" + this.f415116c0 + "} " + super.toString();
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitle() {
        return this.f415115b0;
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        if (this.f415116c0.sugWordType == 1) {
            T();
            com.tencent.mobileqq.search.searchdetail.util.k.f284749a.f(view.getContext(), this.K);
        } else {
            super.v(view);
        }
    }
}

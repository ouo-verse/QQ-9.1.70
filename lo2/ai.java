package lo2;

import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsLayoutContentCollections;
import com.tencent.qqnt.kernel.nativeinterface.UfsResultItem;
import com.tencent.shadow.dynamic.host.Constant;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon$ResultItem;
import unite.DynamicSearch$ResultItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ai extends m {

    /* renamed from: b0, reason: collision with root package name */
    public a f415125b0;

    /* renamed from: c0, reason: collision with root package name */
    public b f415126c0;

    /* renamed from: d0, reason: collision with root package name */
    public ArrayList<c> f415127d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f415128e0;

    /* renamed from: f0, reason: collision with root package name */
    protected boolean f415129f0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f415130a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f415131b;

        /* renamed from: c, reason: collision with root package name */
        public String f415132c;

        public a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f415134a;

        /* renamed from: b, reason: collision with root package name */
        public String f415135b;

        /* renamed from: c, reason: collision with root package name */
        public int f415136c;

        /* renamed from: d, reason: collision with root package name */
        public int f415137d;

        /* renamed from: e, reason: collision with root package name */
        public CharSequence f415138e;

        /* renamed from: f, reason: collision with root package name */
        public String f415139f;

        public b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public CharSequence f415141a;

        /* renamed from: b, reason: collision with root package name */
        public String f415142b;

        /* renamed from: c, reason: collision with root package name */
        public int f415143c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f415144d;

        public c() {
        }
    }

    public ai(String str, long j3, List<String> list, DynamicSearch$ResultItem dynamicSearch$ResultItem, int i3) {
        super(str, j3, list, dynamicSearch$ResultItem, i3);
        this.f415129f0 = false;
    }

    @Override // lo2.m
    public int K(int i3) {
        if (i3 != 128) {
            switch (i3) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    return i3;
                default:
                    return 1;
            }
        }
        return i3;
    }

    @Override // lo2.m
    public boolean N() {
        return true;
    }

    @Override // lo2.m
    public boolean P() {
        if ("\u81ea\u6740".equals(this.N) && this.J == 1000000) {
            return true;
        }
        return false;
    }

    @Override // lo2.m
    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
        boolean z16;
        boolean z17;
        boolean z18;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("needRightCenter") == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f415128e0 = z16;
            JSONObject optJSONObject = jSONObject.optJSONObject("imageInfo");
            if (optJSONObject != null) {
                R(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("actionInfo");
            if (optJSONObject2 != null) {
                a aVar = new a();
                this.f415125b0 = aVar;
                aVar.f415130a = optJSONObject2.optInt("type");
                this.f415125b0.f415131b = optJSONObject2.optString("word");
                this.f415125b0.f415132c = optJSONObject2.optString(WadlProxyConsts.KEY_JUMP_URL);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("headIconInfo");
            if (optJSONObject3 != null) {
                b bVar = new b();
                this.f415126c0 = bVar;
                bVar.f415134a = optJSONObject3.optInt("type");
                this.f415126c0.f415135b = optJSONObject3.optString("iconUrl");
                this.f415126c0.f415136c = optJSONObject3.optInt("iconWidth");
                this.f415126c0.f415137d = optJSONObject3.optInt("iconHeight");
                this.f415126c0.f415138e = optJSONObject3.optString("tagText");
                this.f415126c0.f415139f = optJSONObject3.optString("tagBgColor");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("lineList");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    if (!TextUtils.isEmpty(jSONObject2.optString("word"))) {
                        if (this.f415127d0 == null) {
                            this.f415127d0 = new ArrayList<>();
                        }
                        c cVar = new c();
                        cVar.f415141a = jSONObject2.optString("word");
                        cVar.f415142b = jSONObject2.optString(MessageForRichState.SIGN_MSG_FONT_TYPE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
                        cVar.f415143c = jSONObject2.optInt("maxLines");
                        if (jSONObject2.optInt("needHighlight") == 1) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        cVar.f415144d = z18;
                        this.f415127d0.add(cVar);
                    } else if (jSONObject2.optJSONArray("words") != null) {
                        if (this.f415127d0 == null) {
                            this.f415127d0 = new ArrayList<>();
                        }
                        c cVar2 = new c();
                        cVar2.f415141a = SearchUtils.q(jSONObject2.optJSONArray("words"));
                        cVar2.f415142b = jSONObject2.optString(MessageForRichState.SIGN_MSG_FONT_TYPE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
                        cVar2.f415143c = jSONObject2.optInt("maxLines");
                        if (jSONObject2.optInt("needHighlight") == 1) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        cVar2.f415144d = z17;
                        this.f415127d0.add(cVar2);
                    }
                }
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(m.f415228a0, 2, e16.toString());
            }
        }
    }

    @Override // lo2.m
    public void U() {
        super.U();
        if (P()) {
            com.tencent.mobileqq.search.report.b.e(null, 0, this.R, "0X800BDC2", 0, 0, null, null);
        } else if (this.J == Constant.FROM_ID_START_ACTIVITY) {
            com.tencent.mobileqq.search.report.b.e(null, 0, this.R, "0X8009D50", 0, 0, null, null);
        }
    }

    public boolean W() {
        return this.f415129f0;
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        ArrayList<c> arrayList;
        if ((this.J == Constant.FROM_ID_START_ACTIVITY || P()) && (arrayList = this.f415127d0) != null && arrayList.size() > 0) {
            return this.f415127d0.get(0).f415141a;
        }
        return super.getTitleSpans();
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        String str;
        super.v(view);
        if (this.J == Constant.FROM_ID_START_ACTIVITY) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (getUin() != null) {
                str = getUin();
            } else {
                str = "";
            }
            ReportController.o(peekAppRuntime, "dc00898", "", str, "auth_search", "clk_content", 0, 0, "", "", "", "");
            if (O()) {
                com.tencent.mobileqq.search.report.b.e(null, 0, this.R, "0X800AC12", 0, 0, "", "");
            }
            com.tencent.mobileqq.search.report.b.e(null, 0, this.R, "0X8009D51", 0, 0, null, null);
            return;
        }
        if (P()) {
            com.tencent.mobileqq.search.report.b.e(null, 0, this.R, "0X800BDC3", 0, 0, null, null);
        }
    }

    public ai(String str, long j3, List<String> list, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem, int i3) {
        super(str, j3, list, unifySearchCommon$ResultItem, i3);
        this.f415129f0 = false;
    }

    public ai(String str, long j3, List<String> list, UfsResultItem ufsResultItem, int i3) {
        super(str, j3, list, ufsResultItem, i3);
        this.f415129f0 = false;
    }
}

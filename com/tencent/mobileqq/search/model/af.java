package com.tencent.mobileqq.search.model;

import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsLayoutContentCollections;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon$ResultItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class af extends lo2.m {

    /* renamed from: b0, reason: collision with root package name */
    public List<lo2.u> f283492b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f283493c0;

    @Override // com.tencent.mobileqq.search.model.z
    public void F(int i3) {
        super.F(i3);
        List<lo2.u> list = this.f283492b0;
        if (list != null) {
            Iterator<lo2.u> it = list.iterator();
            while (it.hasNext()) {
                it.next().F(i3);
            }
        }
    }

    @Override // lo2.m
    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("items");
            List<lo2.u> list = this.f283492b0;
            if (list == null) {
                this.f283492b0 = new ArrayList();
            } else {
                list.clear();
            }
            if (jSONArray == null) {
                return;
            }
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    this.f283492b0.add(new ag(this.N, this.J, this.L, this.R, jSONArray.getJSONObject(i3), this.f283548i, (UnifySearchCommon$ResultItem) H()));
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(lo2.m.f415228a0, 2, "vas_search_parsejson, e = " + e16);
                        return;
                    }
                    return;
                }
            }
        } catch (JSONException e17) {
            if (QLog.isColorLevel()) {
                QLog.e(lo2.m.f415228a0, 2, "vas_search_parsejson, e = " + e17);
            }
        }
    }

    public void W(int i3) {
        if (i3 > 0 && !this.f283493c0) {
            this.f283493c0 = true;
            if (this.J == 1106) {
                MobileReportManager.getInstance().reportAction("", "", SearchConstants.PLATFORM, "7", "1", 111, 1, System.currentTimeMillis());
                com.tencent.mobileqq.search.report.b.e(null, 0, this.R, SearchConstants.INDIVIDUATION_SEE_SOUP, 0, 0, null, null);
            }
        }
    }
}

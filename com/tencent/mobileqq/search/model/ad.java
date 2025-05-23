package com.tencent.mobileqq.search.model;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsLayoutContentCollections;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon$ResultItem;
import unite.DynamicSearch$ResultItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ad extends lo2.m {

    /* renamed from: d0, reason: collision with root package name */
    public static final String f283477d0 = "ad";

    /* renamed from: b0, reason: collision with root package name */
    protected final String f283478b0;

    /* renamed from: c0, reason: collision with root package name */
    public ArrayList<lo2.u> f283479c0;

    public ad(String str, long j3, List<String> list, DynamicSearch$ResultItem dynamicSearch$ResultItem, int i3) {
        super(str, j3, list, dynamicSearch$ResultItem, i3);
        this.f283478b0 = VideoTemplateParser.ITEM_LIST;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007e A[Catch: JSONException -> 0x0086, TRY_LEAVE, TryCatch #1 {JSONException -> 0x0086, blocks: (B:11:0x0023, B:15:0x002c, B:20:0x007e, B:24:0x003b, B:26:0x0043, B:27:0x005b, B:29:0x0063), top: B:10:0x0023, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0083 A[SYNTHETIC] */
    @Override // lo2.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
        ae aeVar;
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(VideoTemplateParser.ITEM_LIST);
            ArrayList<lo2.u> arrayList = this.f283479c0;
            if (arrayList == null) {
                this.f283479c0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            if (jSONArray == null) {
                return;
            }
            for (int i3 = 0; i3 < jSONArray.length() && i3 < 5; i3++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    int optInt = jSONObject.optInt("type");
                    if (optInt == 1) {
                        if (H() instanceof DynamicSearch$ResultItem) {
                            aeVar = new ae(this.N, this.J, this.L, this.R, jSONObject, optInt, (DynamicSearch$ResultItem) H(), i3 + 1);
                        } else if (H() instanceof UnifySearchCommon$ResultItem) {
                            aeVar = new ae(this.N, this.J, this.L, this.R, jSONObject, optInt, (UnifySearchCommon$ResultItem) H(), i3 + 1);
                        }
                        if (aeVar == null) {
                            this.f283479c0.add(aeVar);
                        }
                    }
                    aeVar = null;
                    if (aeVar == null) {
                    }
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(f283477d0, 2, "parseLayoutExtensions, e = " + e16);
                        return;
                    }
                    return;
                }
            }
        } catch (JSONException e17) {
            if (QLog.isColorLevel()) {
                QLog.e(f283477d0, 2, "parseLayoutExtensions, e = " + e17);
            }
        }
    }

    @Override // com.tencent.mobileqq.search.model.z, com.tencent.mobileqq.search.model.y
    public int p() {
        return 2;
    }

    @Override // com.tencent.mobileqq.search.model.z, com.tencent.mobileqq.search.model.y
    public int q() {
        return 1;
    }

    public ad(String str, long j3, List<String> list, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem, int i3) {
        super(str, j3, list, unifySearchCommon$ResultItem, i3);
        this.f283478b0 = VideoTemplateParser.ITEM_LIST;
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    public void v(View view) {
    }
}

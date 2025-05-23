package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
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
public class ac extends lo2.m {

    /* renamed from: k0, reason: collision with root package name */
    public static final String f283467k0 = "ac";

    /* renamed from: b0, reason: collision with root package name */
    protected final String f283468b0;

    /* renamed from: c0, reason: collision with root package name */
    protected final String f283469c0;

    /* renamed from: d0, reason: collision with root package name */
    protected final String f283470d0;

    /* renamed from: e0, reason: collision with root package name */
    protected final String f283471e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f283472f0;

    /* renamed from: g0, reason: collision with root package name */
    public CharSequence f283473g0;

    /* renamed from: h0, reason: collision with root package name */
    public String f283474h0;

    /* renamed from: i0, reason: collision with root package name */
    public ArrayList<lo2.u> f283475i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f283476j0;

    public ac(String str, long j3, List<String> list, DynamicSearch$ResultItem dynamicSearch$ResultItem, int i3) {
        super(str, j3, list, dynamicSearch$ResultItem, i3);
        this.f283468b0 = VideoTemplateParser.ITEM_LIST;
        this.f283469c0 = "Type";
        this.f283470d0 = "moreText";
        this.f283471e0 = "moreUrl";
        this.f283476j0 = 0;
    }

    @Override // lo2.m
    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
        ae aeVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f283472f0 = jSONObject.optInt("Type");
            this.f283473g0 = jSONObject.optString("moreText");
            this.f283474h0 = jSONObject.optString("moreUrl");
            JSONArray optJSONArray = jSONObject.optJSONArray(VideoTemplateParser.ITEM_LIST);
            ArrayList<lo2.u> arrayList = this.f283475i0;
            if (arrayList == null) {
                this.f283475i0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                int optInt = optJSONObject.optInt("type");
                if (optInt == 0) {
                    optInt = 1;
                }
                int i16 = optInt;
                if (H() instanceof DynamicSearch$ResultItem) {
                    aeVar = new ae(this.N, this.J, this.L, this.R, optJSONObject, i16, (DynamicSearch$ResultItem) H(), i3 + 1);
                } else if (H() instanceof UnifySearchCommon$ResultItem) {
                    aeVar = new ae(this.N, this.J, this.L, this.R, optJSONObject, i16, (UnifySearchCommon$ResultItem) H(), i3 + 1);
                } else {
                    aeVar = null;
                }
                if (aeVar != null) {
                    this.f283475i0.add(aeVar);
                }
            }
            if (this.f283475i0.size() > 0 && (this.f283475i0.get(0) instanceof ae) && !TextUtils.isEmpty(((ae) this.f283475i0.get(0)).f283486j0) && ((ae) this.f283475i0.get(0)).f283486j0.contains("qcircle")) {
                com.tencent.mobileqq.search.report.b.e(null, 0, this.R, "0X800BA22", 0, 0, null, null);
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(f283467k0, 2, "layout 13 parse layout error :" + e16.toString());
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

    public ac(String str, long j3, List<String> list, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem, int i3) {
        super(str, j3, list, unifySearchCommon$ResultItem, i3);
        this.f283468b0 = VideoTemplateParser.ITEM_LIST;
        this.f283469c0 = "Type";
        this.f283470d0 = "moreText";
        this.f283471e0 = "moreUrl";
        this.f283476j0 = 0;
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    public void v(View view) {
    }
}

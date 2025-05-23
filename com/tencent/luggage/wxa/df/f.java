package com.tencent.luggage.wxa.df;

import android.os.Looper;
import android.view.View;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.luggage.wxa.ol.f0;
import com.tencent.luggage.wxa.ol.k;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.s0;
import com.tencent.luggage.wxa.xd.v;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends v {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "restoreWebviewFocus";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends s0 {

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.v f124213h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ boolean f124214i;

        public a(com.tencent.luggage.wxa.kj.v vVar, boolean z16) {
            this.f124213h = vVar;
            this.f124214i = z16;
        }

        @Override // com.tencent.luggage.wxa.tn.s0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a() {
            f.this.a(this.f124213h, this.f124214i);
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.kj.v vVar, JSONObject jSONObject) {
        new a(vVar, jSONObject.optBoolean(WSPublicAccReport.SOP_NAME_FOCUS, false)).a(new b0(Looper.getMainLooper()));
        return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
    }

    public final void a(com.tencent.luggage.wxa.kj.v vVar, boolean z16) {
        k.a().c(vVar);
        View contentView = vVar.D0().getContentView();
        if (z16) {
            f0 a16 = f0.a(contentView, vVar.z0());
            if (a16 != null) {
                a16.setShowDoneButton(false);
            }
            contentView.requestFocus();
        }
    }
}

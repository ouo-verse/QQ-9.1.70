package com.tencent.luggage.wxa.se;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.mobileqq.R;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends com.tencent.luggage.wxa.ee.b {
    public static final int CTRL_INDEX = 67;
    public static final String NAME = "insertCanvas";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements g.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.dd.a f140302a;

        public a(com.tencent.luggage.wxa.dd.a aVar) {
            this.f140302a = aVar;
        }

        @Override // com.tencent.luggage.wxa.xd.g.b
        public void onBackground() {
            this.f140302a.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements g.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.dd.a f140304a;

        public b(com.tencent.luggage.wxa.dd.a aVar) {
            this.f140304a = aVar;
        }

        @Override // com.tencent.luggage.wxa.xd.g.d
        public void onForeground() {
            this.f140304a.d();
        }
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public boolean enableGesture() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public boolean enableLongClick() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.getInt("canvasId");
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public View inflateView(com.tencent.luggage.wxa.xd.f fVar, JSONObject jSONObject) {
        Context context = fVar.getContext();
        com.tencent.luggage.wxa.dd.a aVar = new com.tencent.luggage.wxa.dd.a(context);
        aVar.getDrawContext().a((com.tencent.luggage.wxa.vc.e) fVar.b(com.tencent.luggage.wxa.vc.e.class));
        aVar.getDrawContext().a(fVar);
        aVar.setContentDescription(context.getString(R.string.ywd));
        fVar.a(new a(aVar));
        fVar.b(new b(aVar));
        return new com.tencent.luggage.wxa.ye.b(context, aVar);
    }
}

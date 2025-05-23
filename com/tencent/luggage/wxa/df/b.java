package com.tencent.luggage.wxa.df;

import android.os.Looper;
import com.tencent.luggage.wxa.ol.p0;
import com.tencent.luggage.wxa.ol.r;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.s0;
import com.tencent.luggage.wxa.xd.v;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends v {
    private static final int CTRL_INDEX = 583;
    private static final String NAME = "getSelectedTextRange";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends s0 {

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.v f124201h;

        public a(com.tencent.luggage.wxa.kj.v vVar) {
            this.f124201h = vVar;
        }

        @Override // com.tencent.luggage.wxa.tn.s0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int[] a() {
            return b.this.a(this.f124201h);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.kj.v vVar, JSONObject jSONObject) {
        int[] iArr = (int[]) new a(vVar).a(new b0(Looper.getMainLooper()));
        if (iArr == null) {
            return makeReturnJson("fail:no focused input");
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("start", Integer.valueOf(iArr[0]));
        hashMap.put("end", Integer.valueOf(iArr[1]));
        return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap);
    }

    public final int[] a(com.tencent.luggage.wxa.kj.v vVar) {
        p0 a16 = r.a(vVar);
        if (a16 == null) {
            return null;
        }
        return new int[]{a16.d().getSelectionStart(), a16.d().getSelectionEnd()};
    }
}

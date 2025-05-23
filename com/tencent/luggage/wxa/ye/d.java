package com.tencent.luggage.wxa.ye;

import android.graphics.BitmapFactory;
import com.tencent.luggage.wxa.gh.c;
import com.tencent.luggage.wxa.nb.a;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d extends k0 implements c.InterfaceC6243c {
    private static final int CTRL_INDEX = 677;
    public static final String NAME = "onImageViewLoad";

    /* renamed from: a, reason: collision with root package name */
    public final a.c f145568a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.xd.f f145569b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends HashMap {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitmapFactory.Options f145570a;

        public a(BitmapFactory.Options options) {
            this.f145570a = options;
            put("width", Integer.valueOf(options.outWidth));
            put("height", Integer.valueOf(options.outHeight));
        }
    }

    public d(int i3, a.c cVar, com.tencent.luggage.wxa.xd.f fVar) {
        setData("viewId", Integer.valueOf(i3));
        this.f145568a = cVar;
        this.f145569b = fVar;
    }

    @Override // com.tencent.luggage.wxa.gh.c.InterfaceC6243c
    public void a(BitmapFactory.Options options) {
        if (options != null) {
            setData("errMsg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
            setData("size", new a(options));
        } else {
            setData("errMsg", "fail");
        }
        a.c cVar = this.f145568a;
        if (cVar != null && "webview".equals(cVar.a("sendTo", (String) null))) {
            this.f145569b.a(this);
        } else {
            this.f145569b.a(this, (int[]) null);
        }
    }
}

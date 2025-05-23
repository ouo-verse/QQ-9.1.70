package com.tencent.luggage.wxa.bf;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 116;
    private static final String NAME = "getSavedFileInfo";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f122555a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f122556b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f122557c;

        public a(com.tencent.luggage.wxa.xd.d dVar, String str, int i3) {
            this.f122555a = dVar;
            this.f122556b = str;
            this.f122557c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f122555a.isRunning()) {
                return;
            }
            com.tencent.luggage.wxa.cp.v absoluteFile = this.f122555a.getFileSystem().getAbsoluteFile(this.f122556b);
            if (absoluteFile == null) {
                this.f122555a.a(this.f122557c, p.this.makeReturnJson(String.format(Locale.US, "fail no such file \"%s\"", this.f122556b)));
                return;
            }
            HashMap hashMap = new HashMap(3);
            hashMap.put("size", Long.valueOf(absoluteFile.s()));
            hashMap.put(WadlProxyConsts.CREATE_TIME, Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(absoluteFile.r())));
            this.f122555a.a(this.f122557c, p.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        String optString = jSONObject.optString("filePath", "");
        if (com.tencent.luggage.wxa.tn.w0.c(optString)) {
            dVar.a(i3, makeReturnJson("fail:invalid data"));
        } else {
            b.f122521b.execute(new a(dVar, optString, i3));
        }
    }
}

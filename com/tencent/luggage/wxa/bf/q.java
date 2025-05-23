package com.tencent.luggage.wxa.bf;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.rc.r;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class q extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 115;
    private static final String NAME = "getSavedFileList";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f122559a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f122560b;

        public a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f122559a = dVar;
            this.f122560b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f122559a.isRunning()) {
                return;
            }
            List<r.a> savedFileList = this.f122559a.getFileSystem().getSavedFileList();
            JSONArray jSONArray = new JSONArray();
            if (savedFileList != null && savedFileList.size() > 0) {
                for (r.a aVar : savedFileList) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("filePath", aVar.a());
                        jSONObject.put("size", aVar.b());
                        jSONObject.put(WadlProxyConsts.CREATE_TIME, TimeUnit.MILLISECONDS.toSeconds(aVar.lastModified()));
                        jSONArray.mo162put(jSONObject);
                    } catch (Exception unused) {
                    }
                }
            }
            HashMap hashMap = new HashMap(1);
            hashMap.put("fileList", jSONArray);
            this.f122559a.a(this.f122560b, q.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        b.f122521b.execute(new a(dVar, i3));
    }
}

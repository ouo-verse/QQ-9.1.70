package com.tencent.luggage.wxa.r2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.os.ResultReceiver;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.jsapi.file.LuggageOpenDocumentProxyUI;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.fa.b;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.mm.plugin.appbrand.ipc.ResultReceiverFixLeak;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.lang.ref.WeakReference;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 99;
    private static final String NAME = "openDocument";

    /* renamed from: a, reason: collision with root package name */
    public static long f139054a = -1;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.r2.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6659a extends ResultReceiver {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f139055a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f139056b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6659a(Handler handler, WeakReference weakReference, int i3) {
            super(handler);
            this.f139055a = weakReference;
            this.f139056b = i3;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int i3, Bundle bundle) {
            a aVar;
            String str;
            d dVar = (d) this.f139055a.get();
            if (dVar != null) {
                int i16 = this.f139056b;
                if (i3 == 0) {
                    aVar = a.this;
                    str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
                } else {
                    aVar = a.this;
                    str = "fail:internal error";
                }
                dVar.a(i16, aVar.makeReturnJson(str));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(d dVar, JSONObject jSONObject, int i3) {
        long c16 = w0.c();
        if (c16 - f139054a < 1000) {
            dVar.a(i3, makeReturnJson("fail:document viewer already starting"));
            return;
        }
        f139054a = c16;
        String optString = jSONObject.optString("filePath");
        if (w0.c(optString)) {
            dVar.a(i3, makeReturnJson("fail:invalid data"));
            return;
        }
        v absoluteFile = dVar.getFileSystem().getAbsoluteFile(optString);
        if (absoluteFile == null) {
            dVar.a(i3, makeReturnJson("fail:file doesn't exist"));
            return;
        }
        String g16 = absoluteFile.g();
        String name = FilenameUtils.getName(optString);
        String extension = FilenameUtils.getExtension(optString);
        String optString2 = jSONObject.optString(TagName.FILE_TYPE);
        if (!w0.c(optString2)) {
            extension = optString2;
        }
        Intent intent = new Intent(dVar.getContext(), (Class<?>) LuggageOpenDocumentProxyUI.class);
        if (!(dVar.getContext() instanceof Activity)) {
            intent.setFlags(268435456);
        }
        intent.putExtra("filePath", g16);
        intent.putExtra(WadlProxyConsts.PARAM_FILENAME, name);
        intent.putExtra("fileExt", extension);
        intent.putExtra("receiver", ResultReceiverFixLeak.a(new C6659a(null, new WeakReference(dVar), i3), dVar.getContext()));
        if (!StringUtils.endsWith(g16, extension)) {
            x.a(g16, g16 + "." + extension, false);
        }
        Context context = dVar.getContext();
        b.a(context, intent);
        context.startActivity(intent);
    }
}

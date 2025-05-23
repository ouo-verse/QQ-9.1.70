package com.tencent.luggage.wxa.jf;

import android.text.TextUtils;
import com.tencent.luggage.wxa.jf.d;
import com.tencent.luggage.wxa.mc.j0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends com.tencent.luggage.wxa.jf.a {
    public static final int CTRL_INDEX = 351;

    @NotNull
    public static final String NAME = "navigateToDevMiniProgram";

    /* renamed from: a, reason: collision with root package name */
    public static final a f131009a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements d.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f131010a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f131011b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g f131012c;

        public b(com.tencent.luggage.wxa.ic.d dVar, int i3, g gVar) {
            this.f131010a = dVar;
            this.f131011b = i3;
            this.f131012c = gVar;
        }

        @Override // com.tencent.luggage.wxa.jf.d.c
        public /* synthetic */ void a(com.tencent.luggage.wxa.fd.i iVar) {
            l.a(this, iVar);
        }

        @Override // com.tencent.luggage.wxa.jf.d.c
        public final void a(boolean z16, String str) {
            String str2;
            String sb5;
            if (z16) {
                sb5 = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
            } else {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("fail");
                if (TextUtils.isEmpty(str)) {
                    str2 = "";
                } else {
                    str2 = TokenParser.SP + str;
                }
                sb6.append(str2);
                sb5 = sb6.toString();
            }
            this.f131010a.a(this.f131011b, this.f131012c.makeReturnJson(sb5));
        }
    }

    static {
        com.tencent.luggage.wxa.rj.a.a(NAME);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d service, JSONObject data, int i3) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(data, "data");
        String appId = data.optString("appId");
        String downloadURL = data.optString("downloadURL");
        String checkSumMd5 = data.optString("checkSumMd5");
        String optString = data.optString("envVersion");
        com.tencent.luggage.wxa.jf.b bVar = com.tencent.luggage.wxa.jf.b.DEVELOP;
        com.tencent.luggage.wxa.jf.b a16 = com.tencent.luggage.wxa.jf.b.a(optString, bVar);
        String optString2 = data.optString("relativeURL");
        String extoptions = data.optString("extoptions");
        if (w0.c(appId)) {
            service.a(i3, makeReturnJson("fail:appID is empty"));
            return;
        }
        if (bVar == a16 && !TextUtils.isEmpty(checkSumMd5)) {
            Intrinsics.checkNotNullExpressionValue(appId, "appId");
            Intrinsics.checkNotNullExpressionValue(downloadURL, "downloadURL");
            Intrinsics.checkNotNullExpressionValue(checkSumMd5, "checkSumMd5");
            Intrinsics.checkNotNullExpressionValue(extoptions, "extoptions");
            if (!a(appId, downloadURL, checkSumMd5, extoptions)) {
                w.b("MicroMsg.AppBrand.JsApiNavigateToDevMiniProgram", "invoke with appId:" + service.getAppId() + ", callbackId:" + i3 + ", precondition(appId:" + appId + ") for dev failed");
                service.a(i3, makeReturnJson("fail save packageInfo failed"));
                return;
            }
        }
        d.a aVar = new d.a();
        aVar.f130988a = i3;
        aVar.f130989b = data.optInt("scene", 0);
        aVar.f130990c = data.optString("sceneNote");
        aVar.f130991d = data.optInt("preScene", 0);
        aVar.f130992e = data.optString("preSceneNote");
        aVar.f130997j = data.optBoolean("noRelaunchIfPathUnchanged", false);
        e().a(service, appId, a16.f130986a, optString2, aVar, data, new b(service, i3, this));
    }

    @Override // com.tencent.luggage.wxa.jf.a
    public d e() {
        j INSTANCE = j.f131023a;
        Intrinsics.checkNotNullExpressionValue(INSTANCE, "INSTANCE");
        return INSTANCE;
    }

    public boolean a(String appId, String downloadURL, String checkSumMd5, String extoptions) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(downloadURL, "downloadURL");
        Intrinsics.checkNotNullParameter(checkSumMd5, "checkSumMd5");
        Intrinsics.checkNotNullParameter(extoptions, "extoptions");
        try {
            com.tencent.luggage.wxa.ii.h.a().a(appId, 1, extoptions);
            if (j0.a().a(appId, 1, downloadURL, checkSumMd5)) {
                k.a(appId, 1);
            }
            return true;
        } catch (Exception e16) {
            w.b("MicroMsg.AppBrand.JsApiNavigateToDevMiniProgram", "flushDevPkg failed by exception " + e16);
            return false;
        }
    }
}

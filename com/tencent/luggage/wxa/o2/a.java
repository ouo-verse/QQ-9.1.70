package com.tencent.luggage.wxa.o2;

import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.r3.a;
import com.tencent.luggage.wxa.rc.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.y8.c;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import java.nio.ByteBuffer;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = -2;

    @NotNull
    public static final String NAME = "uploadToCommonCDN";

    /* renamed from: a, reason: collision with root package name */
    public static final C6530a f136084a = new C6530a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.o2.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6530a {
        public C6530a() {
        }

        public /* synthetic */ C6530a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f136085a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f136086b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f136087c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(l lVar, int i3, a aVar) {
            super(1);
            this.f136085a = lVar;
            this.f136086b = i3;
            this.f136087c = aVar;
        }

        public final void a(a.b it) {
            Intrinsics.checkNotNullParameter(it, "it");
            if (it.a() == 0) {
                l lVar = this.f136085a;
                int i3 = this.f136086b;
                a aVar = this.f136087c;
                HashMap hashMap = new HashMap();
                hashMap.put("fileUrl", it.b());
                hashMap.put("thumbUrl", it.c());
                Unit unit = Unit.INSTANCE;
                lVar.a(i3, aVar.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
                return;
            }
            this.f136085a.a(this.f136086b, this.f136087c.makeReturnJson("fail:cdn com upload error " + it.a()));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((a.b) obj);
            return Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l env, JSONObject jSONObject, int i3) {
        Intrinsics.checkNotNullParameter(env, "env");
        w.d("Luggage.JsApiUploadToCommonCDN", "invoke appId:" + env.getAppId() + ", callbackId:" + i3 + ", data:" + jSONObject);
        if ((jSONObject != null ? jSONObject.length() : 0) <= 1) {
            env.a(i3, makeReturnJson("fail:invalid data"));
            return;
        }
        Intrinsics.checkNotNull(jSONObject);
        int optInt = jSONObject.optInt("appType");
        int optInt2 = jSONObject.optInt(TagName.FILE_TYPE);
        String a16 = a(jSONObject.optString("filePath"), env);
        Object opt = jSONObject.opt("thumbFileData");
        ByteBuffer byteBuffer = opt instanceof ByteBuffer ? (ByteBuffer) opt : null;
        String a17 = a(jSONObject.optString("thumbFilePath"), env);
        Object opt2 = jSONObject.opt("thumbFileData");
        if (opt2 instanceof ByteBuffer) {
        }
        boolean optBoolean = jSONObject.optBoolean("isStorageMode");
        int optInt3 = jSONObject.optInt("snsUploadVersion");
        if ((a16 == null || a16.length() == 0) && byteBuffer == null) {
            env.a(i3, makeReturnJson("fail:filePath and fileData invalid"));
            return;
        }
        String optString = jSONObject.optString(PreDownloadConstants.RPORT_KEY_FILE_KEY);
        if (optString == null || optString.length() == 0) {
            byte[] bytes = (a16 + w0.c()).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            optString = c.a(bytes);
        }
        com.tencent.luggage.wxa.r3.a.f139058a.a(new a.C6660a(optInt, optInt2, optString, a16, a17, optBoolean, optInt3), new b(env, i3, this));
    }

    public final String a(String str, l lVar) {
        v absoluteFile;
        if (str == null || str.length() == 0) {
            return str;
        }
        r fileSystem = lVar.getFileSystem();
        if (fileSystem == null || (absoluteFile = fileSystem.getAbsoluteFile(str)) == null) {
            return null;
        }
        return absoluteFile.g();
    }
}

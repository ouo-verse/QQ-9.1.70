package com.tencent.luggage.wxa.jj;

import com.tencent.luggage.wxa.c5.e;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.eo.g;
import com.tencent.luggage.wxa.ij.b;
import com.tencent.luggage.wxa.k0.d;
import com.tencent.luggage.wxa.rc.l;
import com.tencent.luggage.wxa.tk.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.io.FilenameUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f131187a = new c();

    /* JADX WARN: Removed duplicated region for block: B:32:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0054 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String a(e runtime, String str) {
        CharSequence trim;
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        String str2;
        l createTempFileFrom;
        boolean startsWith$default4;
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        if (w0.c(str)) {
            w.f("MicroMsg.OpenMsgMaterialLogic", "preProcessNativeExtraData4OpenMsgMaterial fail, nativeExtraDataStr is null");
            return str;
        }
        b.a aVar = com.tencent.luggage.wxa.ij.b.f130607c;
        Intrinsics.checkNotNull(str);
        com.tencent.luggage.wxa.ij.b a16 = aVar.a(str);
        if (a16 == null) {
            w.f("MicroMsg.OpenMsgMaterialLogic", "preProcessNativeExtraData4OpenMsgMaterial fail, openMaterialNativeExtraDataForOpenMsg is null");
            return str;
        }
        b.a(runtime).a(a16);
        w.d("MicroMsg.OpenMsgMaterialLogic", "preProcessNativeExtraData4OpenMsgMaterial openMaterialNativeExtraDataForOpenMsg:" + a16.a().size());
        for (com.tencent.luggage.wxa.ij.c cVar : a16.a()) {
            if (Intrinsics.areEqual(cVar.e(), "unsupported")) {
                w.a("MicroMsg.OpenMsgMaterialLogic", "preProcessNativeExtraData4OpenMsgMaterial, un support ignore: " + cVar);
            } else if (!Intrinsics.areEqual(cVar.e(), "text/message")) {
                trim = StringsKt__StringsKt.trim((CharSequence) cVar.c());
                String obj = trim.toString();
                w.a("MicroMsg.OpenMsgMaterialLogic", "preProcessNativeExtraData4OpenMsgMaterial, originMaterialPath: " + obj);
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(obj, "http://", false, 2, null);
                if (startsWith$default) {
                    continue;
                } else {
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(obj, "https://", false, 2, null);
                    if (startsWith$default2) {
                        continue;
                    } else {
                        String e16 = cVar.e();
                        startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(e16, "image", false, 2, null);
                        if (!startsWith$default3) {
                            startsWith$default4 = StringsKt__StringsJVMKt.startsWith$default(e16, "video", false, 2, null);
                            if (!startsWith$default4) {
                                str2 = FilenameUtils.getName(obj);
                                Intrinsics.checkNotNullExpressionValue(str2, "getName(originMaterialPath)");
                                String extension = FilenameUtils.getExtension(obj);
                                v vVar = new v(obj);
                                int s16 = (int) vVar.s();
                                w.a("MicroMsg.OpenMsgMaterialLogic", "preProcessNativeExtraData4OpenMsgMaterial, fileName: " + str2 + ", fileExt: " + extension + "\uff0cfileSize: " + s16);
                                if (com.tencent.luggage.wxa.uk.l.f142757a.a(obj)) {
                                    w.d("MicroMsg.OpenMsgMaterialLogic", "originMaterialPath is wxam file");
                                    v allocTempFile = runtime.P().allocTempFile("appbrand_temp_" + System.currentTimeMillis());
                                    try {
                                        Intrinsics.checkNotNull(allocTempFile);
                                        allocTempFile.c();
                                        w.d("MicroMsg.OpenMsgMaterialLogic", "tempFile exist:" + allocTempFile.e() + ", path:" + allocTempFile.g());
                                        d.a(g.a(com.tencent.luggage.wxa.hm.a.class));
                                        allocTempFile.g();
                                        throw null;
                                    } catch (Exception e17) {
                                        w.a("MicroMsg.OpenMsgMaterialLogic", e17, "", new Object[0]);
                                        w.d("MicroMsg.OpenMsgMaterialLogic", "break, use origin Material Path");
                                    }
                                }
                                i iVar = new i();
                                createTempFileFrom = runtime.P().createTempFileFrom(vVar, extension, false, iVar);
                                Intrinsics.checkNotNullExpressionValue(createTempFileFrom, "runtime.fileSystem.creat\u2026tempPathRef\n            )");
                                w.a("MicroMsg.OpenMsgMaterialLogic", "preProcessNativeExtraData4OpenMsgMaterial, result: " + createTempFileFrom);
                                if (l.OK != createTempFileFrom) {
                                    String newMaterialPath = (String) iVar.f141499a;
                                    w.a("MicroMsg.OpenMsgMaterialLogic", "preProcessNativeExtraData4OpenMsgMaterial, newMaterialPath: " + newMaterialPath);
                                    Intrinsics.checkNotNullExpressionValue(newMaterialPath, "newMaterialPath");
                                    cVar.b(newMaterialPath);
                                    cVar.a(str2);
                                    cVar.a(s16);
                                }
                            }
                        }
                        str2 = "";
                        String extension2 = FilenameUtils.getExtension(obj);
                        v vVar2 = new v(obj);
                        int s162 = (int) vVar2.s();
                        w.a("MicroMsg.OpenMsgMaterialLogic", "preProcessNativeExtraData4OpenMsgMaterial, fileName: " + str2 + ", fileExt: " + extension2 + "\uff0cfileSize: " + s162);
                        if (com.tencent.luggage.wxa.uk.l.f142757a.a(obj)) {
                        }
                        i iVar2 = new i();
                        createTempFileFrom = runtime.P().createTempFileFrom(vVar2, extension2, false, iVar2);
                        Intrinsics.checkNotNullExpressionValue(createTempFileFrom, "runtime.fileSystem.creat\u2026tempPathRef\n            )");
                        w.a("MicroMsg.OpenMsgMaterialLogic", "preProcessNativeExtraData4OpenMsgMaterial, result: " + createTempFileFrom);
                        if (l.OK != createTempFileFrom) {
                        }
                    }
                }
            } else {
                w.a("MicroMsg.OpenMsgMaterialLogic", "preProcessNativeExtraData4OpenMsgMaterial, message ignore: " + cVar);
            }
        }
        return a16.b();
    }
}

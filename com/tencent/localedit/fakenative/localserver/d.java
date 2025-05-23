package com.tencent.localedit.fakenative.localserver;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.local_edit.andserver.http.HttpMethod;
import com.tencent.localedit.fakenative.meta.ChunkImportRequestData;
import com.tencent.localedit.fakenative.meta.FileIORequestData;
import com.tencent.localedit.fakenative.meta.ResourceRequestData;
import com.tencent.mobileqq.activity.NotificationActivity;
import java.io.InputStream;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/localedit/fakenative/localserver/d;", "Lcom/tencent/localedit/fakenative/localserver/n;", "Lcom/tencent/local_edit/andserver/http/b;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/localedit/fakenative/meta/FileIORequestData;", "i", "g", "f", "Lcom/tencent/local_edit/andserver/http/multipart/e;", "", "d", tl.h.F, "Lcom/tencent/localedit/fakenative/meta/ResourceRequestData;", "j", "Lcom/tencent/localedit/fakenative/meta/ChunkImportRequestData;", "e", "<init>", "()V", "a", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class d implements n<com.tencent.local_edit.andserver.http.b> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f119917a;

        static {
            int[] iArr = new int[HttpMethod.values().length];
            iArr[HttpMethod.POST.ordinal()] = 1;
            iArr[HttpMethod.GET.ordinal()] = 2;
            f119917a = iArr;
        }
    }

    private final String d(com.tencent.local_edit.andserver.http.multipart.e request) {
        com.tencent.local_edit.andserver.http.multipart.b f16;
        InputStream stream;
        String k3;
        String parameter;
        int lastIndexOf$default;
        boolean z16;
        int intValue;
        Integer num = null;
        if (request == null || (f16 = request.f("file")) == null || (stream = f16.getStream()) == null) {
            k3 = null;
        } else {
            k3 = w11.a.f444159a.k(stream);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            if (request == null) {
                parameter = null;
            } else {
                parameter = request.getParameter("name");
            }
            if (parameter == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(UUID.randomUUID());
                sb5.append((Object) k3);
                return sb5.toString();
            }
            String parameter2 = request.getParameter("lastModified");
            if (parameter2 == null) {
                parameter2 = String.valueOf(System.currentTimeMillis());
            }
            Intrinsics.checkNotNullExpressionValue(parameter2, "request.getParameter(\"la\u2026tem.currentTimeMillis()}\"");
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) parameter, ".", 0, false, 6, (Object) null);
            Integer valueOf = Integer.valueOf(lastIndexOf$default);
            if (valueOf.intValue() != -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                num = valueOf;
            }
            if (num == null) {
                intValue = parameter.length();
            } else {
                intValue = num.intValue();
            }
            String substring = parameter.substring(0, intValue);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            String sb6 = new StringBuilder(Intrinsics.stringPlus(substring, k3)).insert(intValue, Intrinsics.stringPlus("_", parameter2)).toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder(\"${name.su\u2026lastModified\").toString()");
            return sb6;
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(Result.m476constructorimpl(ResultKt.createFailure(th5)));
            if (m479exceptionOrNullimpl != null) {
                x11.b.f446855a.b("LocalServerRequestParser", Intrinsics.stringPlus("generateFileName failed, e:", m479exceptionOrNullimpl));
            }
            StringBuilder sb7 = new StringBuilder();
            sb7.append(UUID.randomUUID());
            sb7.append((Object) k3);
            return sb7.toString();
        }
    }

    private final FileIORequestData f(com.tencent.local_edit.andserver.http.b request) {
        int parseInt;
        long parseLong;
        String parameter = request.getParameter("globalPadId");
        if (parameter == null) {
            parameter = String.valueOf(UUID.randomUUID());
        }
        String str = parameter;
        Intrinsics.checkNotNullExpressionValue(str, "it.getParameter(\"globalP\u2026?: \"${UUID.randomUUID()}\"");
        String parameter2 = request.getParameter("localFilePath");
        String parameter3 = request.getParameter("docType");
        if (parameter3 == null) {
            parseInt = 0;
        } else {
            parseInt = Integer.parseInt(parameter3);
        }
        String parameter4 = request.getParameter("title");
        String parameter5 = request.getParameter("data");
        String parameter6 = request.getParameter(NotificationActivity.PASSWORD);
        String parameter7 = request.getParameter("traceKey");
        String parameter8 = request.getParameter("offset");
        long j3 = 0;
        if (parameter8 == null) {
            parseLong = 0;
        } else {
            parseLong = Long.parseLong(parameter8);
        }
        String parameter9 = request.getParameter("length");
        if (parameter9 != null) {
            j3 = Long.parseLong(parameter9);
        }
        return new FileIORequestData(str, parameter2, Integer.valueOf(parseInt), parameter4, parameter5, parameter6, parameter7, Long.valueOf(parseLong), Long.valueOf(j3), request.getParameter("filePath"), request.getParameter("url"));
    }

    private final FileIORequestData g(com.tencent.local_edit.andserver.http.b request) {
        com.tencent.local_edit.andserver.http.e body = request.getBody();
        if (body == null) {
            return new FileIORequestData(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        }
        JSONObject jSONObject = new JSONObject(body.a());
        String optString = jSONObject.optString("globalPadId");
        if (optString == null) {
            optString = String.valueOf(UUID.randomUUID());
        }
        String str = optString;
        String optString2 = jSONObject.optString("localFilePath");
        int optInt = jSONObject.optInt("docType", 0);
        String optString3 = jSONObject.optString("title");
        String optString4 = jSONObject.optString("data");
        String optString5 = jSONObject.optString(NotificationActivity.PASSWORD);
        String optString6 = jSONObject.optString("traceKey");
        long optLong = jSONObject.optLong("offset");
        long optLong2 = jSONObject.optLong("length");
        return new FileIORequestData(str, optString2, Integer.valueOf(optInt), optString3, optString4, optString5, optString6, Long.valueOf(optLong), Long.valueOf(optLong2), jSONObject.optString("filePath"), jSONObject.optString("url"));
    }

    private final FileIORequestData i(com.tencent.local_edit.andserver.http.b request) {
        int i3 = b.f119917a[request.getMethod().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return new FileIORequestData(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
            }
            return f(request);
        }
        return g(request);
    }

    @Override // com.tencent.localedit.fakenative.localserver.n
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ChunkImportRequestData c(@NotNull com.tencent.local_edit.andserver.http.b request) {
        int parseInt;
        int parseInt2;
        int parseInt3;
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            Result.Companion companion = Result.INSTANCE;
            String parameter = request.getParameter("globalPadId");
            String parameter2 = request.getParameter("localFilePath");
            String parameter3 = request.getParameter("docType");
            int i3 = 0;
            if (parameter3 == null) {
                parseInt = 0;
            } else {
                parseInt = Integer.parseInt(parameter3);
            }
            String parameter4 = request.getParameter(NotificationActivity.PASSWORD);
            String parameter5 = request.getParameter("chunkIndex");
            if (parameter5 == null) {
                parseInt2 = 0;
            } else {
                parseInt2 = Integer.parseInt(parameter5);
            }
            String parameter6 = request.getParameter("chunkSize");
            if (parameter6 == null) {
                parseInt3 = 0;
            } else {
                parseInt3 = Integer.parseInt(parameter6);
            }
            String parameter7 = request.getParameter("isStart");
            if (parameter7 != null) {
                i3 = Integer.parseInt(parameter7);
            }
            return new ChunkImportRequestData(parameter, parameter2, Integer.valueOf(parseInt), parameter4, Integer.valueOf(parseInt2), Integer.valueOf(parseInt3), Integer.valueOf(i3));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Object m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                x11.b.f446855a.b("LocalServerRequestParser", Intrinsics.stringPlus("parseChunkRequest failed, e:", m479exceptionOrNullimpl));
            }
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                m476constructorimpl = null;
            }
            Object obj = (Void) m476constructorimpl;
            if (obj == null) {
                return new ChunkImportRequestData(null, null, null, null, null, null, null, 127, null);
            }
            return (ChunkImportRequestData) obj;
        }
    }

    @Override // com.tencent.localedit.fakenative.localserver.n
    @NotNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public FileIORequestData b(@NotNull com.tencent.local_edit.andserver.http.b request) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(i(request));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            x11.b.f446855a.b("LocalServerRequestParser", Intrinsics.stringPlus("parseFileRequest e:", m479exceptionOrNullimpl));
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        FileIORequestData fileIORequestData = (FileIORequestData) m476constructorimpl;
        if (fileIORequestData == null) {
            return new FileIORequestData(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        }
        return fileIORequestData;
    }

    @Override // com.tencent.localedit.fakenative.localserver.n
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public ResourceRequestData a(@NotNull com.tencent.local_edit.andserver.http.b request) {
        Object m476constructorimpl;
        byte[] bytes;
        Long valueOf;
        Intrinsics.checkNotNullParameter(request, "request");
        Object obj = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            com.tencent.local_edit.andserver.http.multipart.e eVar = (com.tencent.local_edit.andserver.http.multipart.e) request;
            String parameter = request.getParameter("globalPadId");
            if (parameter == null) {
                parameter = String.valueOf(UUID.randomUUID());
            }
            Intrinsics.checkNotNullExpressionValue(parameter, "request.getParameter(\"gl\u2026?: \"${UUID.randomUUID()}\"");
            com.tencent.local_edit.andserver.http.multipart.b f16 = eVar.f("file");
            String d16 = d(eVar);
            if (f16 == null) {
                bytes = null;
            } else {
                bytes = f16.getBytes();
            }
            if (f16 == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(f16.getSize());
            }
            ResourceRequestData resourceRequestData = new ResourceRequestData(bytes, d16, valueOf, parameter);
            x11.b.f446855a.d("LocalServerRequestParser", "parseFileRequest uri=" + ((com.tencent.local_edit.andserver.http.multipart.e) request).getURI() + " body=" + resourceRequestData);
            m476constructorimpl = Result.m476constructorimpl(resourceRequestData);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            x11.b.f446855a.b("LocalServerRequestParser", Intrinsics.stringPlus("parseResourceRequest failed, e:", m479exceptionOrNullimpl));
        }
        if (!Result.m482isFailureimpl(m476constructorimpl)) {
            obj = m476constructorimpl;
        }
        ResourceRequestData resourceRequestData2 = (ResourceRequestData) obj;
        if (resourceRequestData2 == null) {
            return new ResourceRequestData(null, null, null, null, 15, null);
        }
        return resourceRequestData2;
    }
}

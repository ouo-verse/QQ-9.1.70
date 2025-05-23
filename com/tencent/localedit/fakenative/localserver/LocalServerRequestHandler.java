package com.tencent.localedit.fakenative.localserver;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.localedit.LocalEditSDK;
import com.tencent.localedit.fakenative.meta.ChunkConvertResult;
import com.tencent.localedit.fakenative.meta.ChunkImportRequestData;
import com.tencent.localedit.fakenative.meta.CommonConvertResult;
import com.tencent.localedit.fakenative.meta.ConvertPerformanceData;
import com.tencent.localedit.fakenative.meta.FileIORequestData;
import com.tencent.localedit.fakenative.meta.ImageData;
import com.tencent.localedit.fakenative.meta.LoadConvertOptions;
import com.tencent.localedit.fakenative.meta.LocalServerResponse;
import com.tencent.localedit.fakenative.meta.ResourceRequestData;
import com.tencent.localedit.fakenative.meta.SaveConvertOptions;
import com.tencent.localedit.fakenative.preload.FilePreloadManager;
import com.tencent.localedit.fakenative.resource.ResourceScheduler;
import com.tencent.localedit.fakenative.resource.SaveSuccessTask;
import com.tencent.localedit.fakenative.resource.a;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.qqmini.miniapp.widget.InnerWebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import x11.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b(\u0010)J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003H\u0002J0\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010$\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/localedit/fakenative/localserver/LocalServerRequestHandler;", "Lcom/tencent/localedit/fakenative/localserver/a;", "Lcom/tencent/local_edit/andserver/http/b;", "", "globalPadId", "Lcom/tencent/localedit/fakenative/meta/ConvertPerformanceData;", "f", WadlProxyConsts.PARAM_FILENAME, "b", "srcPath", "", "g", "localFilePath", "tempDataPath", "oldDataPath", "data", "e", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/local_edit/andserver/http/h;", "loadFile", "fileStat", InnerWebView.API_UPLOAD_IMAGE, "loadDocs", "saveDocs", "chunkImport", InnerWebView.API_DOWNLOAD_IMAGE, "report", "Lcom/tencent/localedit/fakenative/localserver/n;", "a", "Lkotlin/Lazy;", "c", "()Lcom/tencent/localedit/fakenative/localserver/n;", "parser", "Lcom/tencent/localedit/fakenative/preload/FilePreloadManager;", "d", "()Lcom/tencent/localedit/fakenative/preload/FilePreloadManager;", "preloadManager", "Lcom/tencent/localedit/fakenative/resource/ResourceScheduler;", "Lcom/tencent/localedit/fakenative/resource/ResourceScheduler;", "resourceScheduler", "<init>", "()V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class LocalServerRequestHandler extends a<com.tencent.local_edit.andserver.http.b> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy parser;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy preloadManager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ResourceScheduler resourceScheduler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/localedit/fakenative/localserver/LocalServerRequestHandler$b", "Lcom/tencent/localedit/fakenative/resource/c;", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public static final class b extends com.tencent.localedit.fakenative.resource.c {
        b(LocalServerRequestHandler$schedulerReleaseChunkConverter$2 localServerRequestHandler$schedulerReleaseChunkConverter$2) {
            super(localServerRequestHandler$schedulerReleaseChunkConverter$2, null, 2, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/localedit/fakenative/localserver/LocalServerRequestHandler$c", "Lcom/tencent/localedit/fakenative/resource/c;", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public static final class c extends com.tencent.localedit.fakenative.resource.c {
        c(LocalServerRequestHandler$uploadImage$2 localServerRequestHandler$uploadImage$2) {
            super(localServerRequestHandler$uploadImage$2, null, 2, null);
        }
    }

    public LocalServerRequestHandler() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.localedit.fakenative.localserver.LocalServerRequestHandler$parser$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final d invoke() {
                return new d();
            }
        });
        this.parser = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FilePreloadManager>() { // from class: com.tencent.localedit.fakenative.localserver.LocalServerRequestHandler$preloadManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FilePreloadManager invoke() {
                return (FilePreloadManager) LocalEditSDK.INSTANCE.getManager(FilePreloadManager.class);
            }
        });
        this.preloadManager = lazy2;
        this.resourceScheduler = d().getResourceScheduler();
    }

    private final String b(String globalPadId, String fileName) {
        return "https://docs.qq.com/local-edit/media/" + globalPadId + '/' + fileName;
    }

    private final n<com.tencent.local_edit.andserver.http.b> c() {
        return (n) this.parser.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FilePreloadManager d() {
        return (FilePreloadManager) this.preloadManager.getValue();
    }

    private final void e(String localFilePath, String tempDataPath, String oldDataPath, String globalPadId, String data) {
        this.resourceScheduler.b(new SaveSuccessTask(localFilePath, data, tempDataPath, oldDataPath, globalPadId));
    }

    private final ConvertPerformanceData f(String globalPadId) {
        return d().getTrackerCache().remove(globalPadId);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.localedit.fakenative.localserver.LocalServerRequestHandler$schedulerReleaseChunkConverter$2] */
    private final void g(final String srcPath) {
        this.resourceScheduler.b(new b(new Function0<Unit>() { // from class: com.tencent.localedit.fakenative.localserver.LocalServerRequestHandler$schedulerReleaseChunkConverter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LocalEditSDK.INSTANCE.getConvert().getDelegate().e(srcPath);
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r10v5 */
    @Override // com.tencent.localedit.fakenative.localserver.a
    @NotNull
    public String chunkImport(@NotNull com.tencent.local_edit.andserver.http.b request) {
        com.tencent.kuikly.core.coroutines.d dVar;
        ?? r102;
        Object runBlocking$default;
        Intrinsics.checkNotNullParameter(request, "request");
        ChunkImportRequestData c16 = c().c(request);
        x11.b bVar = x11.b.f446855a;
        bVar.a("LocalServerRequest", Intrinsics.stringPlus("Local_edit chunkImport info = ", c16));
        LocalEditSDK localEditSDK = LocalEditSDK.INSTANCE;
        com.tencent.localedit.fakenative.resource.e cache = localEditSDK.getCache();
        String localFilePath = c16.getLocalFilePath();
        if (localFilePath == null) {
            localFilePath = "";
        }
        String d16 = cache.d(localFilePath);
        if (d16 == null) {
            bVar.a("LocalServerRequest", "Local_edit chunkImport file not exist");
            return new LocalServerResponse(23004, null, null, 0, 14, null).toJsonString();
        }
        Integer chunkIndex = c16.getChunkIndex();
        int intValue = chunkIndex == null ? 0 : chunkIndex.intValue();
        Integer chunkSize = c16.getChunkSize();
        int intValue2 = chunkSize == null ? 0 : chunkSize.intValue();
        String globalPadId = c16.getGlobalPadId();
        if (globalPadId == null) {
            globalPadId = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(globalPadId, "randomUUID().toString()");
        }
        Integer isStart = c16.isStart();
        if (isStart != null && isStart.intValue() == 0) {
            dVar = null;
            r102 = 1;
        } else {
            dVar = null;
            r102 = 1;
            FilePreloadManager.trackConvertData$default(d(), globalPadId, true, null, false, 12, null);
            String password = c16.getPassword();
            String b16 = localEditSDK.getCache().b(d16, globalPadId, password == null || password.length() == 0 ? null : "pw");
            String stringPlus = Intrinsics.stringPlus(localEditSDK.getCache().o(globalPadId), "/");
            String str = "https://docs.qq.com/local-edit/media/" + globalPadId + '/';
            Integer docType = c16.getDocType();
            localEditSDK.getConvert().getDelegate().b(new LoadConvertOptions(docType == null ? 0 : docType.intValue(), stringPlus, c16.getLocalFilePath(), b16, null, str, c16.getPassword(), Integer.valueOf(intValue), Integer.valueOf(intValue2), 16, null));
        }
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(dVar, new LocalServerRequestHandler$chunkImport$result$1(d16, intValue, intValue2, dVar), r102, dVar);
        ChunkConvertResult chunkConvertResult = (ChunkConvertResult) runBlocking$default;
        bVar.a("LocalServerRequest", Intrinsics.stringPlus("Local_edit chunkImport result = ", chunkConvertResult));
        int i3 = chunkConvertResult.retCode;
        if (i3 != 0) {
            String str2 = chunkConvertResult.retMsg;
            return new LocalServerResponse(i3, str2 == null ? "" : str2, null, 0, 12, null).toJsonString();
        }
        int i16 = chunkConvertResult.total;
        if (intValue2 + intValue >= i16) {
            g(d16);
        }
        if (intValue == 0) {
            d().trackConvertData(globalPadId, false, Boolean.FALSE, r102);
        }
        bVar.a("LocalServerRequest", "Local_edit chunkImport end");
        String str3 = chunkConvertResult.data;
        return new LocalServerResponse(0, null, str3 == null ? "" : str3, i16, 3, null).toJsonString();
    }

    @Override // com.tencent.localedit.fakenative.localserver.a
    @NotNull
    public String downloadImage(@NotNull com.tencent.local_edit.andserver.http.b request) {
        Intrinsics.checkNotNullParameter(request, "request");
        FileIORequestData b16 = c().b(request);
        String j3 = w11.a.f444159a.j(b16.getUrl());
        File file = new File(LocalEditSDK.INSTANCE.getCache().o(b16.getGlobalPadId()) + '/' + j3);
        if (!file.exists() ? w11.b.f444160a.a(b16.getUrl(), file) : true) {
            Bitmap decodeFile = BitmapFactory.decodeFile(file.getPath());
            ImageData imageData = new ImageData(b(b16.getGlobalPadId(), j3), decodeFile == null ? null : Integer.valueOf(decodeFile.getHeight()), decodeFile != null ? Integer.valueOf(decodeFile.getWidth()) : null, Long.valueOf(file.length()));
            if (decodeFile != null) {
                decodeFile.recycle();
            }
            return new LocalServerResponse(0, null, imageData.toJson(), 0, 11, null).toJsonString();
        }
        return new LocalServerResponse(23006, null, null, 0, 14, null).toJsonString();
    }

    @Override // com.tencent.localedit.fakenative.localserver.a
    @NotNull
    public String fileStat(@NotNull com.tencent.local_edit.andserver.http.b request) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(request, "request");
        String filePath = c().b(request).getFilePath();
        if (filePath == null) {
            filePath = "";
        }
        File file = new File(filePath);
        x11.b bVar = x11.b.f446855a;
        bVar.d("LocalServerRequest", "fileStat path=" + filePath + TokenParser.SP);
        if (file.exists()) {
            bVar.d("LocalServerRequest", "fileStat \u6587\u4ef6\u5b58\u5728");
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("size", Long.valueOf(file.length())));
            return new LocalServerResponse(0, null, new JSONObject(mapOf), 0, 11, null).toJsonString();
        }
        bVar.b("LocalServerRequest", "fileStat \u6587\u4ef6\u4e0d\u5b58\u5728");
        return new LocalServerResponse(23004, null, null, 0, 14, null).toJsonString();
    }

    @Override // com.tencent.localedit.fakenative.localserver.a
    @NotNull
    public String loadDocs(@NotNull com.tencent.local_edit.andserver.http.b request) {
        Object runBlocking$default;
        Intrinsics.checkNotNullParameter(request, "request");
        FileIORequestData b16 = c().b(request);
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new LocalServerRequestHandler$loadDocs$result$1(this, b16, null), 1, null);
        String str = (String) runBlocking$default;
        if (str != null) {
            return str;
        }
        x11.b.f446855a.a("LocalServerRequest", Intrinsics.stringPlus("Local_edit loadDocs no preload task: ", b16.getLocalFilePath()));
        return d().loadDocs(b16);
    }

    @Override // com.tencent.localedit.fakenative.localserver.a
    @NotNull
    public com.tencent.local_edit.andserver.http.h loadFile(@NotNull com.tencent.local_edit.andserver.http.b request) {
        Intrinsics.checkNotNullParameter(request, "request");
        long currentTimeMillis = System.currentTimeMillis();
        FileIORequestData b16 = c().b(request);
        if ((b16.getOffset() != null && b16.getLength() != null ? b16 : null) == null) {
            x11.b.f446855a.b("LocalServerRequest", "loadFile failed, parseResourceRequest is error");
            return new l11.b(new LocalServerResponse(23002, null, null, 0, 14, null).toJsonString());
        }
        String filePath = b16.getFilePath();
        if (filePath == null) {
            filePath = "";
        }
        File file = new File(filePath);
        File file2 = file.exists() ? file : null;
        if (file2 == null) {
            x11.b.f446855a.b("LocalServerRequest", "loadFile failed, file is not exists");
            return new l11.b(new LocalServerResponse(23004, null, null, 0, 14, null).toJsonString());
        }
        w11.a aVar = w11.a.f444159a;
        Long offset = b16.getOffset();
        Intrinsics.checkNotNull(offset);
        long longValue = offset.longValue();
        Long length = b16.getLength();
        Intrinsics.checkNotNull(length);
        byte[] g16 = aVar.g(longValue, file2, (int) length.longValue());
        if (g16 == null) {
            g16 = new byte[0];
        }
        x11.b.f446855a.d("LocalServerRequest", Intrinsics.stringPlus("loadFile cost=", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        return new l11.a(new ByteArrayInputStream(g16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.localedit.fakenative.localserver.a
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String report(@NotNull com.tencent.local_edit.andserver.http.b request) {
        com.tencent.local_edit.andserver.http.e body;
        String str;
        Throwable m479exceptionOrNullimpl;
        JSONObject jSONObject;
        String action;
        String globalPadId;
        ConvertPerformanceData convertPerformanceData;
        Intrinsics.checkNotNullParameter(request, "request");
        x11.b.f446855a.d("LocalServerRequest", Intrinsics.stringPlus("report params:", request.getBody()));
        x11.d reporter = LocalEditSDK.INSTANCE.getReporter();
        if (reporter != null && (body = request.getBody()) != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                jSONObject = new JSONObject(body.a());
                action = jSONObject.optString("type");
            } catch (Throwable th5) {
                th = th5;
            }
            if (Intrinsics.areEqual(action, "load") && (convertPerformanceData = d().getTrackerCache().get((globalPadId = jSONObject.optString("globalPadId")))) != null) {
                if (!convertPerformanceData.canUse()) {
                    convertPerformanceData = null;
                }
                if (convertPerformanceData != null) {
                    Map<String, Object> map = convertPerformanceData.toMap();
                    JSONObject optJSONObject = jSONObject.optJSONObject("metrics");
                    if (optJSONObject != null) {
                        for (Map.Entry<String, Object> entry : map.entrySet()) {
                            optJSONObject.put(entry.getKey(), entry.getValue());
                        }
                        Intrinsics.checkNotNullExpressionValue(globalPadId, "globalPadId");
                        try {
                            f(globalPadId);
                            Intrinsics.checkNotNullExpressionValue(action, "action");
                            d.a.a(reporter, action, jSONObject, 0, 0, 12, null);
                            str = Result.m476constructorimpl(new LocalServerResponse(0, null, null, 0, 15, null).toJsonString());
                        } catch (Throwable th6) {
                            th = th6;
                            Result.Companion companion2 = Result.INSTANCE;
                            str = Result.m476constructorimpl(ResultKt.createFailure(th));
                            m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(str);
                            if (m479exceptionOrNullimpl != null) {
                            }
                            r1 = Result.m482isFailureimpl(str) ? null : str;
                            if (r1 != null) {
                            }
                        }
                        m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(str);
                        if (m479exceptionOrNullimpl != null) {
                            x11.b.f446855a.b("LocalServerRequest", Intrinsics.stringPlus("report parse failed, e:", m479exceptionOrNullimpl));
                        }
                        r1 = Result.m482isFailureimpl(str) ? null : str;
                    }
                }
            }
            Intrinsics.checkNotNullExpressionValue(action, "action");
            d.a.a(reporter, action, jSONObject, 0, 0, 12, null);
            str = Result.m476constructorimpl(new LocalServerResponse(0, null, null, 0, 15, null).toJsonString());
            m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(str);
            if (m479exceptionOrNullimpl != null) {
            }
            r1 = Result.m482isFailureimpl(str) ? null : str;
        }
        return r1 != null ? new LocalServerResponse(23008, null, null, 0, 14, null).toJsonString() : r1;
    }

    @Override // com.tencent.localedit.fakenative.localserver.a
    @NotNull
    public String saveDocs(@NotNull com.tencent.local_edit.andserver.http.b request) {
        Object runBlocking$default;
        Intrinsics.checkNotNullParameter(request, "request");
        FileIORequestData b16 = c().b(request);
        x11.b bVar = x11.b.f446855a;
        bVar.d("LocalServerRequest", Intrinsics.stringPlus("Local_edit saveDocs info = ", b16));
        String globalPadId = b16.getGlobalPadId();
        String localFilePath = b16.getLocalFilePath();
        String str = localFilePath != null ? localFilePath : "";
        LocalEditSDK localEditSDK = LocalEditSDK.INSTANCE;
        String b17 = a.C5961a.b(localEditSDK.getCache(), str, globalPadId, null, 4, null);
        String stringPlus = Intrinsics.stringPlus(localEditSDK.getCache().o(globalPadId), "/");
        String b18 = localEditSDK.getCache().b(str, globalPadId, FaceUtil.IMG_TEMP);
        w11.a aVar = w11.a.f444159a;
        String data = b16.getData();
        if (data == null) {
            data = "";
        }
        aVar.r(data, b18);
        Integer docType = b16.getDocType();
        String str2 = str;
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new LocalServerRequestHandler$saveDocs$result$1(new SaveConvertOptions(docType == null ? 0 : docType.intValue(), b18, str, null, "https://docs.qq.com/local-edit/media/" + globalPadId + '/', stringPlus, b16.getPassword(), 8, null), null), 1, null);
        CommonConvertResult commonConvertResult = (CommonConvertResult) runBlocking$default;
        bVar.d("LocalServerRequest", Intrinsics.stringPlus("Local_edit saveDocs result = ", commonConvertResult));
        if (commonConvertResult.getCode() != 0) {
            return new LocalServerResponse(commonConvertResult.getCode(), commonConvertResult.getMessage(), null, 0, 12, null).toJsonString();
        }
        String data2 = b16.getData();
        e(str2, b18, b17, globalPadId, data2 != null ? data2 : "");
        bVar.d("LocalServerRequest", "Local_edit saveDocs end");
        return new LocalServerResponse(0, null, null, 0, 15, null).toJsonString();
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [com.tencent.localedit.fakenative.localserver.LocalServerRequestHandler$uploadImage$2] */
    @Override // com.tencent.localedit.fakenative.localserver.a
    @NotNull
    public String uploadImage(@NotNull com.tencent.local_edit.andserver.http.b request) {
        Intrinsics.checkNotNullParameter(request, "request");
        ResourceRequestData a16 = c().a(request);
        String fileName = a16.getFileName();
        boolean z16 = false;
        if (!(fileName == null || fileName.length() == 0) && a16.getFileBytes() != null) {
            z16 = true;
        }
        if (!z16) {
            a16 = null;
        }
        if (a16 == null) {
            x11.b.f446855a.b("LocalServerRequest", "uploadImage failed, parseResourceRequest is error");
            return new LocalServerResponse(23002, null, null, 0, 14, null).toJsonString();
        }
        String fileName2 = a16.getFileName();
        if (fileName2 == null) {
            fileName2 = "tmp_image.jpg";
        }
        byte[] fileBytes = a16.getFileBytes();
        final ByteArrayInputStream byteArrayInputStream = fileBytes == null ? null : new ByteArrayInputStream(fileBytes);
        final String str = LocalEditSDK.INSTANCE.getCache().o(a16.getGlobalPadId()) + '/' + fileName2;
        this.resourceScheduler.b(new c(new Function0<Unit>() { // from class: com.tencent.localedit.fakenative.localserver.LocalServerRequestHandler$uploadImage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                w11.a.f444159a.q(byteArrayInputStream, str);
            }
        }));
        byte[] fileBytes2 = a16.getFileBytes();
        Bitmap decodeStream = BitmapFactory.decodeStream(fileBytes2 == null ? null : new ByteArrayInputStream(fileBytes2));
        ImageData imageData = new ImageData(b(a16.getGlobalPadId(), fileName2), decodeStream == null ? null : Integer.valueOf(decodeStream.getHeight()), decodeStream != null ? Integer.valueOf(decodeStream.getWidth()) : null, a16.getFileSize());
        x11.b.f446855a.d("LocalServerRequest", "Local_edit uploadImage finish");
        return new LocalServerResponse(0, null, imageData.toJson(), 0, 11, null).toJsonString();
    }
}

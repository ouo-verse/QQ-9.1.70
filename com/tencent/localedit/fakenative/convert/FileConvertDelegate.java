package com.tencent.localedit.fakenative.convert;

import com.tencent.localedit.JNI;
import com.tencent.localedit.LocalEditSDK;
import com.tencent.localedit.fakenative.meta.ChunkConvertResult;
import com.tencent.localedit.fakenative.meta.CommonConvertResult;
import com.tencent.localedit.fakenative.meta.LoadConvertOptions;
import com.tencent.localedit.fakenative.meta.SaveConvertOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u001b\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0018\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0016R&\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001aR&\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/localedit/fakenative/convert/FileConvertDelegate;", "Lcom/tencent/localedit/fakenative/convert/a;", "Lorg/json/JSONObject;", "Lcom/tencent/localedit/fakenative/meta/CommonConvertResult;", "j", "Lcom/tencent/localedit/fakenative/meta/LoadConvertOptions;", "options", "c", "(Lcom/tencent/localedit/fakenative/meta/LoadConvertOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/localedit/fakenative/meta/SaveConvertOptions;", "f", "(Lcom/tencent/localedit/fakenative/meta/SaveConvertOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "srcPath", "", "chunkIndex", "chunkSize", "Lcom/tencent/localedit/fakenative/meta/ChunkConvertResult;", "a", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "b", "e", "filePath", "d", "Lkotlin/Function2;", "Lkotlin/jvm/functions/Function2;", "saveMappings", "loadMappings", "<init>", "()V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class FileConvertDelegate extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<String, JSONObject, Unit> saveMappings = new Function2<String, JSONObject, Unit>() { // from class: com.tencent.localedit.fakenative.convert.FileConvertDelegate$saveMappings$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, JSONObject jSONObject) {
            invoke2(str, jSONObject);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String parseName, @NotNull JSONObject json) {
            Intrinsics.checkNotNullParameter(parseName, "parseName");
            Intrinsics.checkNotNullParameter(json, "json");
            JSONArray jSONArray = json.getJSONArray(parseName);
            int length = jSONArray.length();
            if (length <= 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                int i16 = i3 + 1;
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(i)");
                String n3 = LocalEditSDK.INSTANCE.getCache().n(jSONObject.optString("from"));
                if (n3 != null) {
                    jSONObject.put("to", n3);
                }
                if (i16 >= length) {
                    return;
                } else {
                    i3 = i16;
                }
            }
        }
    };

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<String, JSONObject, Unit> loadMappings = new Function2<String, JSONObject, Unit>() { // from class: com.tencent.localedit.fakenative.convert.FileConvertDelegate$loadMappings$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, JSONObject jSONObject) {
            invoke2(str, jSONObject);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String parseName, @NotNull JSONObject json) {
            String removePrefix;
            Intrinsics.checkNotNullParameter(parseName, "parseName");
            Intrinsics.checkNotNullParameter(json, "json");
            JSONArray jSONArray = json.getJSONArray(parseName);
            int length = jSONArray.length();
            if (length <= 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                int i16 = i3 + 1;
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(i)");
                String localPath = jSONObject.optString("from");
                Intrinsics.checkNotNullExpressionValue(localPath, "localPath");
                removePrefix = StringsKt__StringsKt.removePrefix(localPath, (CharSequence) Intrinsics.stringPlus(LocalEditSDK.INSTANCE.getCache().m(), "/"));
                jSONObject.put("to", Intrinsics.stringPlus("https://docs.qq.com/local-edit/media/", removePrefix));
                if (i16 >= length) {
                    return;
                } else {
                    i3 = i16;
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public final CommonConvertResult j(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("retCode", 23003);
        String optString = jSONObject.optString("retMsg");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(\"retMsg\")");
        return new CommonConvertResult(optInt, optString);
    }

    @Override // com.tencent.localedit.fakenative.convert.a
    @Nullable
    public Object a(@NotNull String str, int i3, int i16, @NotNull Continuation<? super ChunkConvertResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FileConvertDelegate$chunkImport$2(i3, i16, str, null), continuation);
    }

    @Override // com.tencent.localedit.fakenative.convert.a
    public void b(@NotNull LoadConvertOptions options) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(options, "options");
        try {
            Result.Companion companion = Result.INSTANCE;
            int docType = options.getDocType();
            String originFilePath = options.getOriginFilePath();
            if (originFilePath == null) {
                originFilePath = "";
            }
            String dataFilePath = options.getDataFilePath();
            if (dataFilePath == null) {
                dataFilePath = "";
            }
            String uriPattern = options.getUriPattern();
            if (uriPattern == null) {
                uriPattern = "";
            }
            JNI.initChunkConverter(docType, 1, 1, originFilePath, dataFilePath, uriPattern, options.getTmpPath(), options.getPassword());
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            x11.b.f446855a.b("FileConvertDelegate", Intrinsics.stringPlus("Local_edit initChunkConverter Exception: ", m479exceptionOrNullimpl));
        }
    }

    @Override // com.tencent.localedit.fakenative.convert.a
    @Nullable
    public Object c(@NotNull LoadConvertOptions loadConvertOptions, @NotNull Continuation<? super CommonConvertResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FileConvertDelegate$load$2(loadConvertOptions, this, null), continuation);
    }

    @Override // com.tencent.localedit.fakenative.convert.a
    public void d(@Nullable String filePath) {
        if (filePath != null) {
            e(filePath);
        }
    }

    @Override // com.tencent.localedit.fakenative.convert.a
    public void e(@NotNull String srcPath) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(srcPath, "srcPath");
        x11.b.f446855a.d("FileConvertDelegate", Intrinsics.stringPlus("Local_edit releaseChunkConverter srcPath: ", srcPath));
        try {
            Result.Companion companion = Result.INSTANCE;
            JNI.releaseChunkConverter(srcPath);
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            x11.b.f446855a.b("FileConvertDelegate", Intrinsics.stringPlus("Local_edit releaseChunkConverter Exception: ", m479exceptionOrNullimpl));
        }
    }

    @Override // com.tencent.localedit.fakenative.convert.a
    @Nullable
    public Object f(@NotNull SaveConvertOptions saveConvertOptions, @NotNull Continuation<? super CommonConvertResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FileConvertDelegate$save$2(saveConvertOptions, this, null), continuation);
    }
}

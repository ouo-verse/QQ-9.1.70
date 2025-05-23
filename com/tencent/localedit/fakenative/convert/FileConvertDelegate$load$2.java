package com.tencent.localedit.fakenative.convert;

import com.tencent.localedit.JNI;
import com.tencent.localedit.LocalEditSDK;
import com.tencent.localedit.fakenative.meta.CommonConvertResult;
import com.tencent.localedit.fakenative.meta.LoadConvertOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/localedit/fakenative/meta/CommonConvertResult;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.tencent.localedit.fakenative.convert.FileConvertDelegate$load$2", f = "FileConvertDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class FileConvertDelegate$load$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CommonConvertResult>, Object> {
    final /* synthetic */ LoadConvertOptions $options;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FileConvertDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileConvertDelegate$load$2(LoadConvertOptions loadConvertOptions, FileConvertDelegate fileConvertDelegate, Continuation<? super FileConvertDelegate$load$2> continuation) {
        super(2, continuation);
        this.$options = loadConvertOptions;
        this.this$0 = fileConvertDelegate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FileConvertDelegate$load$2 fileConvertDelegate$load$2 = new FileConvertDelegate$load$2(this.$options, this.this$0, continuation);
        fileConvertDelegate$load$2.L$0 = obj;
        return fileConvertDelegate$load$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m476constructorimpl;
        String str;
        String str2;
        CommonConvertResult j3;
        Function2 function2;
        Function2 function22;
        String str3;
        String str4;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LoadConvertOptions loadConvertOptions = this.$options;
            FileConvertDelegate fileConvertDelegate = this.this$0;
            try {
                Result.Companion companion = Result.INSTANCE;
                int docType = loadConvertOptions.getDocType();
                String originFilePath = loadConvertOptions.getOriginFilePath();
                if (originFilePath == null) {
                    str = "";
                } else {
                    str = originFilePath;
                }
                String dataFilePath = loadConvertOptions.getDataFilePath();
                if (dataFilePath == null) {
                    str2 = "";
                } else {
                    str2 = dataFilePath;
                }
                String ImportExport = JNI.ImportExport(docType, 1, 1, str, str2, loadConvertOptions.getUriPattern(), null, loadConvertOptions.getTmpPath(), loadConvertOptions.getPassword());
                x11.b bVar = x11.b.f446855a;
                bVar.d("FileConvertDelegate", Intrinsics.stringPlus("Local_edit load firstResult=", ImportExport));
                JSONObject jSONObject = new JSONObject(ImportExport);
                j3 = fileConvertDelegate.j(jSONObject);
                if (j3.getCode() != 0) {
                    bVar.b("FileConvertDelegate", Intrinsics.stringPlus("Local_edit load firstResult err: ", Boxing.boxInt(j3.getCode())));
                } else if (!jSONObject.has("data")) {
                    bVar.d("FileConvertDelegate", "Local_edit load firstResult is finish");
                } else {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    function2 = fileConvertDelegate.loadMappings;
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "this");
                    function2.invoke("imageMappings", jSONObject2);
                    function22 = fileConvertDelegate.loadMappings;
                    function22.invoke("attachmentMappings", jSONObject2);
                    bVar.d("FileConvertDelegate", "Local_edit load firstResult mappingsData finish");
                    String stringPlus = Intrinsics.stringPlus(LocalEditSDK.INSTANCE.getCache().m(), "/res.json");
                    w11.a aVar = w11.a.f444159a;
                    String jSONObject3 = jSONObject2.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject3, "mappingsData.toString()");
                    aVar.r(jSONObject3, stringPlus);
                    int docType2 = loadConvertOptions.getDocType();
                    String originFilePath2 = loadConvertOptions.getOriginFilePath();
                    if (originFilePath2 == null) {
                        str3 = "";
                    } else {
                        str3 = originFilePath2;
                    }
                    String dataFilePath2 = loadConvertOptions.getDataFilePath();
                    if (dataFilePath2 == null) {
                        str4 = "";
                    } else {
                        str4 = dataFilePath2;
                    }
                    String ImportExport2 = JNI.ImportExport(docType2, 1, 1, str3, str4, loadConvertOptions.getUriPattern(), stringPlus, loadConvertOptions.getTmpPath(), loadConvertOptions.getPassword());
                    bVar.d("FileConvertDelegate", Intrinsics.stringPlus("Local_edit load finalResult=", ImportExport2));
                    j3 = fileConvertDelegate.j(new JSONObject(ImportExport2));
                }
                m476constructorimpl = Result.m476constructorimpl(j3);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                x11.b.f446855a.b("FileConvertDelegate", Intrinsics.stringPlus("Local_edit load Exception: ", m479exceptionOrNullimpl));
            }
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                m476constructorimpl = null;
            }
            CommonConvertResult commonConvertResult = (CommonConvertResult) m476constructorimpl;
            if (commonConvertResult == null) {
                return new CommonConvertResult(23003, null, 2, null);
            }
            return commonConvertResult;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super CommonConvertResult> continuation) {
        return ((FileConvertDelegate$load$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

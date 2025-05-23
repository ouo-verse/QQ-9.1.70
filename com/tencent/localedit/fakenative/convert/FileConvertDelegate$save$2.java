package com.tencent.localedit.fakenative.convert;

import com.tencent.localedit.JNI;
import com.tencent.localedit.LocalEditSDK;
import com.tencent.localedit.fakenative.meta.CommonConvertResult;
import com.tencent.localedit.fakenative.meta.SaveConvertOptions;
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
@DebugMetadata(c = "com.tencent.localedit.fakenative.convert.FileConvertDelegate$save$2", f = "FileConvertDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class FileConvertDelegate$save$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CommonConvertResult>, Object> {
    final /* synthetic */ SaveConvertOptions $options;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FileConvertDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileConvertDelegate$save$2(SaveConvertOptions saveConvertOptions, FileConvertDelegate fileConvertDelegate, Continuation<? super FileConvertDelegate$save$2> continuation) {
        super(2, continuation);
        this.$options = saveConvertOptions;
        this.this$0 = fileConvertDelegate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FileConvertDelegate$save$2 fileConvertDelegate$save$2 = new FileConvertDelegate$save$2(this.$options, this.this$0, continuation);
        fileConvertDelegate$save$2.L$0 = obj;
        return fileConvertDelegate$save$2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0030, code lost:
    
        r10 = 2;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m476constructorimpl;
        String str;
        String str2;
        String str3;
        CommonConvertResult j3;
        Function2 function2;
        Function2 function22;
        Unit unit;
        String str4;
        String str5;
        String str6;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SaveConvertOptions saveConvertOptions = this.$options;
            FileConvertDelegate fileConvertDelegate = this.this$0;
            try {
                Result.Companion companion = Result.INSTANCE;
                String uriPattern = saveConvertOptions.getUriPattern();
                boolean z16 = false;
                if (uriPattern != null && uriPattern.length() > 0) {
                    z16 = true;
                }
                int i3 = 3;
                if (z16) {
                    str = saveConvertOptions.getTmpPath();
                } else {
                    str = null;
                }
                int docType = saveConvertOptions.getDocType();
                String dataFilePath = saveConvertOptions.getDataFilePath();
                if (dataFilePath == null) {
                    str2 = "";
                } else {
                    str2 = dataFilePath;
                }
                String outputFilePath = saveConvertOptions.getOutputFilePath();
                if (outputFilePath == null) {
                    str3 = "";
                } else {
                    str3 = outputFilePath;
                }
                String ImportExport = JNI.ImportExport(docType, i3, 1, str2, str3, saveConvertOptions.getUriPattern(), null, str, saveConvertOptions.getPassword());
                x11.b bVar = x11.b.f446855a;
                bVar.d("FileConvertDelegate", Intrinsics.stringPlus("Local_edit save firstResult=", ImportExport));
                JSONObject jSONObject = new JSONObject(ImportExport);
                j3 = fileConvertDelegate.j(jSONObject);
                if (j3.getCode() != 0) {
                    bVar.b("FileConvertDelegate", Intrinsics.stringPlus("Local_edit save firstResult err: ", Boxing.boxInt(j3.getCode())));
                } else if (z16) {
                    bVar.d("FileConvertDelegate", "Local_edit save firstResult is finish");
                } else {
                    Boolean boxBoolean = Boxing.boxBoolean(jSONObject.has("data"));
                    if (!boxBoolean.booleanValue()) {
                        boxBoolean = null;
                    }
                    if (boxBoolean == null) {
                        unit = null;
                        str4 = null;
                    } else {
                        boxBoolean.booleanValue();
                        bVar.d("FileConvertDelegate", "Local_edit save firstResult has data");
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        function2 = fileConvertDelegate.saveMappings;
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "this");
                        function2.invoke("imageMappings", jSONObject2);
                        function22 = fileConvertDelegate.saveMappings;
                        function22.invoke("attachmentMappings", jSONObject2);
                        bVar.d("FileConvertDelegate", "Local_edit save firstResult mappingsData finish");
                        String stringPlus = Intrinsics.stringPlus(LocalEditSDK.INSTANCE.getCache().m(), "/res.json");
                        w11.a aVar = w11.a.f444159a;
                        String jSONObject3 = jSONObject2.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject3, "mappingsData.toString()");
                        Intrinsics.checkNotNull(stringPlus);
                        aVar.r(jSONObject3, stringPlus);
                        unit = Unit.INSTANCE;
                        str4 = stringPlus;
                    }
                    if (unit == null) {
                        bVar.d("FileConvertDelegate", "Local_edit save firstResult is finish");
                    }
                    int docType2 = saveConvertOptions.getDocType();
                    String dataFilePath2 = saveConvertOptions.getDataFilePath();
                    if (dataFilePath2 == null) {
                        str5 = "";
                    } else {
                        str5 = dataFilePath2;
                    }
                    String outputFilePath2 = saveConvertOptions.getOutputFilePath();
                    if (outputFilePath2 == null) {
                        str6 = "";
                    } else {
                        str6 = outputFilePath2;
                    }
                    String ImportExport2 = JNI.ImportExport(docType2, 2, 1, str5, str6, null, str4, null, saveConvertOptions.getPassword());
                    bVar.d("FileConvertDelegate", Intrinsics.stringPlus("Local_edit save finalResult=", ImportExport2));
                    j3 = fileConvertDelegate.j(new JSONObject(ImportExport2));
                }
                m476constructorimpl = Result.m476constructorimpl(j3);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                x11.b.f446855a.b("FileConvertDelegate", Intrinsics.stringPlus("Local_edit save Exception: ", m479exceptionOrNullimpl));
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
        return ((FileConvertDelegate$save$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

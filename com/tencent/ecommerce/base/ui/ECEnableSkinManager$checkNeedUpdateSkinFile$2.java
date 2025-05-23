package com.tencent.ecommerce.base.ui;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.base.ui.ECEnableSkinManager$checkNeedUpdateSkinFile$2", f = "ECEnableSkinManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes32.dex */
public final class ECEnableSkinManager$checkNeedUpdateSkinFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ ECEnableSkinManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECEnableSkinManager$checkNeedUpdateSkinFile$2(ECEnableSkinManager eCEnableSkinManager, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCEnableSkinManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECEnableSkinManager$checkNeedUpdateSkinFile$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((ECEnableSkinManager$checkNeedUpdateSkinFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f8  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String k3;
        String str;
        Charset charset;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String readText;
        CharSequence trim;
        Context context;
        String str2;
        String readText2;
        CharSequence trim2;
        String str3 = "";
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            k3 = this.this$0.k();
            File file = new File(k3);
            if (!file.exists()) {
                return Boxing.boxBoolean(true);
            }
            try {
                charset = Charsets.UTF_8;
                Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
                if (inputStreamReader instanceof BufferedReader) {
                    bufferedReader = (BufferedReader) inputStreamReader;
                } else {
                    bufferedReader = new BufferedReader(inputStreamReader, 8192);
                }
                try {
                    readText = TextStreamsKt.readText(bufferedReader2);
                    CloseableKt.closeFinally(bufferedReader2, null);
                } finally {
                }
            } catch (Throwable th5) {
                th = th5;
                str = "";
            }
            if (readText != null) {
                trim = StringsKt__StringsKt.trim((CharSequence) readText);
                str = trim.toString();
                try {
                    context = this.this$0.context;
                    AssetManager assets = context.getAssets();
                    str2 = ECEnableSkinManager.f101032h;
                    InputStream open = assets.open(str2);
                    try {
                        Reader inputStreamReader2 = new InputStreamReader(open, charset);
                        if (inputStreamReader2 instanceof BufferedReader) {
                            bufferedReader2 = (BufferedReader) inputStreamReader2;
                        } else {
                            bufferedReader2 = new BufferedReader(inputStreamReader2, 8192);
                        }
                        try {
                            readText2 = TextStreamsKt.readText(bufferedReader2);
                            CloseableKt.closeFinally(bufferedReader2, null);
                            CloseableKt.closeFinally(open, null);
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    cg0.a.a("ECSkin.ECEnableSkinManager", "checkNeedUpdateSkinFile", "check failed, e=" + th.getMessage());
                    cg0.a.b("ECSkin.ECEnableSkinManager", "localVersion=" + str + " assetsVersion=" + str3);
                    if (!(str.length() != 0)) {
                    }
                    return Boxing.boxBoolean(true);
                }
                if (readText2 != null) {
                    trim2 = StringsKt__StringsKt.trim((CharSequence) readText2);
                    str3 = trim2.toString();
                    cg0.a.b("ECSkin.ECEnableSkinManager", "localVersion=" + str + " assetsVersion=" + str3);
                    if (!(str.length() != 0)) {
                        if (!(str3.length() == 0)) {
                            return Boxing.boxBoolean(!Intrinsics.areEqual(str, str3));
                        }
                    }
                    return Boxing.boxBoolean(true);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

package com.tencent.ecommerce.base.ui;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.base.ui.ECEnableSkinManager$copyAssetsToLocalFile$2", f = "ECEnableSkinManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes32.dex */
public final class ECEnableSkinManager$copyAssetsToLocalFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    int label;
    final /* synthetic */ ECEnableSkinManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECEnableSkinManager$copyAssetsToLocalFile$2(ECEnableSkinManager eCEnableSkinManager, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCEnableSkinManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECEnableSkinManager$copyAssetsToLocalFile$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
        return ((ECEnableSkinManager$copyAssetsToLocalFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Context context;
        String str;
        String j3;
        Context context2;
        String str2;
        String k3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                context = this.this$0.context;
                AssetManager assets = context.getAssets();
                str = ECEnableSkinManager.f101031g;
                InputStream open = assets.open(str);
                try {
                    j3 = this.this$0.j();
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(j3));
                    try {
                        Long boxLong = Boxing.boxLong(ByteStreamsKt.copyTo$default(open, fileOutputStream, 0, 2, null));
                        CloseableKt.closeFinally(fileOutputStream, null);
                        Boxing.boxLong(boxLong.longValue());
                        CloseableKt.closeFinally(open, null);
                        context2 = this.this$0.context;
                        AssetManager assets2 = context2.getAssets();
                        str2 = ECEnableSkinManager.f101032h;
                        open = assets2.open(str2);
                        try {
                            k3 = this.this$0.k();
                            fileOutputStream = new FileOutputStream(new File(k3));
                            try {
                                Long boxLong2 = Boxing.boxLong(ByteStreamsKt.copyTo$default(open, fileOutputStream, 0, 2, null));
                                CloseableKt.closeFinally(fileOutputStream, null);
                                Long boxLong3 = Boxing.boxLong(boxLong2.longValue());
                                CloseableKt.closeFinally(open, null);
                                return boxLong3;
                            } finally {
                                try {
                                    throw th;
                                } finally {
                                }
                            }
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    } finally {
                    }
                } finally {
                }
            } catch (IOException unused) {
                cg0.a.a("ECSkin.ECEnableSkinManager", "copyAssetsToLocalFile", "\u52a0\u8f7d\u76ae\u80a4\u5305\u5931\u8d25\uff0c\u8bf7\u786e\u8ba4 SDK \u4e2d\u662f\u5426\u5b58\u5728\u76ae\u80a4\u5305\uff1b\u540c\u65f6\u5982\u679c\u662f\u4f7f\u7528 rC \u547d\u4ee4\u672c\u5730\u7f16\u8bd1\u7684\u624b\uff31\uff0c\u4f1a\u9020\u6210\u65e0\u6cd5\u8bfb\u53d6\u7535\u5546\u4e2d assets \u7684\u95ee\u9898\uff0c\u5efa\u8bae\u4f7f\u7528\u84dd\u76fe\u5305");
                return Unit.INSTANCE;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

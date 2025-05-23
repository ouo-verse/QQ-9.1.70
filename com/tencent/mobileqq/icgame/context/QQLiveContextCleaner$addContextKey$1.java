package com.tencent.mobileqq.icgame.context;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
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
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.icgame.context.QQLiveContextCleaner$addContextKey$1", f = "QQLiveContextCleaner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
public final class QQLiveContextCleaner$addContextKey$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveContextCleaner$addContextKey$1(String str, Continuation<? super QQLiveContextCleaner$addContextKey$1> continuation) {
        super(2, continuation);
        this.$key = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QQLiveContextCleaner$addContextKey$1(this.$key, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String h16;
        String h17;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_ICGAME);
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_ICGAME)");
            QQLiveContextCleaner qQLiveContextCleaner = QQLiveContextCleaner.f237249e;
            String subVersion = AppSetting.f99551k;
            Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
            h16 = qQLiveContextCleaner.h(subVersion);
            Set<String> decodeStringSet = from.decodeStringSet(h16, new LinkedHashSet());
            decodeStringSet.add(this.$key);
            Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
            h17 = qQLiveContextCleaner.h(subVersion);
            from.encodeStringSet(h17, decodeStringSet);
            QLog.i("ICGameContextCleaner", 1, "[addContextKey] key=" + this.$key + ", contextKeySet size=" + Boxing.boxInt(decodeStringSet.size()));
            if (QLog.isColorLevel()) {
                QLog.d("ICGameContextCleaner", 2, "[addContextKey] key set=" + decodeStringSet);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QQLiveContextCleaner$addContextKey$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

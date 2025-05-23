package com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message;

import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageItem;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/data_source/message/MessageLocalDataSource;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/b;", "Lkotlin/collections/ArrayList;", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "newMessageList", "", "c", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "messageId", "", "b", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Loe2/a;", "a", "Lkotlin/Lazy;", "e", "()Loe2/a;", DownloadInfo.spKey_Config, "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MessageLocalDataSource {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy config;

    public MessageLocalDataSource() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<oe2.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.MessageLocalDataSource$config$2
            @Override // kotlin.jvm.functions.Function0
            public final oe2.a invoke() {
                return new oe2.a();
            }
        });
        this.config = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final oe2.a e() {
        return (oe2.a) this.config.getValue();
    }

    public final Object b(String str, Continuation<? super Integer> continuation) {
        Continuation intercepted;
        boolean isBlank;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        String jSONArray = new JSONArray().toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray, "JSONArray().toString()");
        String string = e().getString("sp_key_ecom_local_messages", jSONArray, Boxing.boxBoolean(true));
        isBlank = StringsKt__StringsJVMKt.isBlank(string);
        if (!isBlank) {
            jSONArray = string;
        }
        JSONArray jSONArray2 = new JSONArray(jSONArray);
        int length = jSONArray2.length();
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            Object obj = jSONArray2.get(i3);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
            if (Intrinsics.areEqual(((JSONObject) obj).optString("messageId"), str)) {
                jSONArray2.remove(i3);
                break;
            }
            i3++;
        }
        if (i3 != -1) {
            oe2.a e16 = e();
            String jSONArray3 = jSONArray2.toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray3, "localArray.toString()");
            e16.setString("sp_key_ecom_local_messages", jSONArray3, Boxing.boxBoolean(true));
        }
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Boxing.boxInt(i3)));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final Object c(List<MessageItem> list, Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        e().setString("sp_key_ecom_local_messages", "", Boxing.boxBoolean(true));
        JSONArray jSONArray = new JSONArray();
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            jSONArray.put(i3, ((MessageItem) obj).k());
            i3 = i16;
        }
        oe2.a e16 = e();
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "localArray.toString()");
        e16.setString("sp_key_ecom_local_messages", jSONArray2, Boxing.boxBoolean(true));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return result == coroutine_suspended2 ? result : Unit.INSTANCE;
    }

    public final Object d(Continuation<? super ArrayList<MessageItem>> continuation) {
        Continuation intercepted;
        boolean isBlank;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        ArrayList arrayList = new ArrayList();
        String jSONArray = new JSONArray().toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray, "JSONArray().toString()");
        String string = e().getString("sp_key_ecom_local_messages", jSONArray, Boxing.boxBoolean(true));
        isBlank = StringsKt__StringsJVMKt.isBlank(string);
        if (!isBlank) {
            jSONArray = string;
        }
        JSONArray jSONArray2 = new JSONArray(jSONArray);
        int length = jSONArray2.length();
        for (int i3 = 0; i3 < length; i3++) {
            Object obj = jSONArray2.get(i3);
            JSONObject jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
            if (jSONObject != null) {
                arrayList.add(MessageItem.INSTANCE.a(jSONObject));
            }
        }
        cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(arrayList));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}

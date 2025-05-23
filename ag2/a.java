package ag2;

import com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.MessageRepositoryImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lag2/a;", "", "", "cookie", "", "a", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "messageId", "", "c", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/repository/MessageRepositoryImpl$b;", "b", "()Lkotlinx/coroutines/flow/StateFlow;", "messagesState", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public interface a {
    Object a(byte[] bArr, Continuation<? super Unit> continuation);

    StateFlow<MessageRepositoryImpl.b> b();

    Object c(String str, Continuation<? super Boolean> continuation);
}

package com.tencent.guild.aio.article.data;

import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\tH&JE\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f2%\u0010\n\u001a!\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\u0012H&JO\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162%\u0010\n\u001a!\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\u0019H&J?\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00042%\u0010\n\u001a!\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\u0019H&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/guild/aio/article/data/g;", "", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "", "msgSeq", "Lkotlin/Function1;", "Lcom/tencent/guild/aio/article/data/k;", "", "Lcom/tencent/guild/aio/article/data/QueryMsgRecordCallback;", "callback", "b", "", "msgSeqList", "Lcom/tencent/guild/aio/article/data/j;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/guild/aio/article/data/QueryMsgRecordListCallback;", "a", "mainMsgSeq", "beginMsgSeq", "Lcom/tencent/guild/aio/article/data/ArticleMsgPullType;", "pullType", "Lcom/tencent/guild/aio/article/data/l;", "Lcom/tencent/guild/aio/article/data/QueryMsgSeqListCallback;", "c", "d", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface g {
    void a(@NotNull Contact contact, @NotNull List<Long> msgSeqList, @NotNull Function1<? super j, Unit> callback);

    void b(@NotNull Contact contact, long msgSeq, @NotNull Function1<? super k, Unit> callback);

    void c(@NotNull Contact contact, long mainMsgSeq, long beginMsgSeq, @NotNull ArticleMsgPullType pullType, @NotNull Function1<? super QueryMsgSeqListResult, Unit> callback);

    void d(@NotNull Contact contact, long mainMsgSeq, @NotNull Function1<? super QueryMsgSeqListResult, Unit> callback);
}

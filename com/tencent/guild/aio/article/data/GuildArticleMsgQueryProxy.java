package com.tencent.guild.aio.article.data;

import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020 \u00a2\u0006\u0004\b$\u0010%JO\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072%\u0010\u0010\u001a!\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tj\u0002`\u000fH\u0002J.\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\tj\u0002`\u0014J5\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162%\u0010\u0010\u001a!\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tj\u0002`\u000fJ=\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00042%\u0010\u0010\u001a!\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tj\u0002`\u000fJ=\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00042%\u0010\u0010\u001a!\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tj\u0002`\u000fJ=\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042%\u0010\u0010\u001a!\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tj\u0002`\u000fJ=\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042%\u0010\u0010\u001a!\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tj\u0002`\u000fJM\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072%\u0010\u0010\u001a!\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tj\u0002`\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/guild/aio/article/data/GuildArticleMsgQueryProxy;", "", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "", "mainMsgSeq", "beginMsgSeq", "Lcom/tencent/guild/aio/article/data/ArticleMsgPullType;", "pullType", "Lkotlin/Function1;", "Lcom/tencent/guild/aio/article/data/i;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/guild/aio/article/data/LoadMsgRecordListCallback;", "callback", "b", "msgSeq", "Lcom/tencent/guild/aio/article/data/k;", "Lcom/tencent/guild/aio/article/data/QueryMsgRecordCallback;", tl.h.F, "Lcom/tencent/guild/aio/article/data/f;", "sessionInfo", "d", "f", "e", "g", "c", "Lcom/tencent/guild/aio/article/data/l;", "Lcom/tencent/guild/aio/article/data/QueryMsgSeqListCallback;", "i", "Lcom/tencent/guild/aio/article/data/g;", "a", "Lcom/tencent/guild/aio/article/data/g;", "mMsgQuery", "<init>", "(Lcom/tencent/guild/aio/article/data/g;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildArticleMsgQueryProxy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g mMsgQuery;

    public GuildArticleMsgQueryProxy(@NotNull g mMsgQuery) {
        Intrinsics.checkNotNullParameter(mMsgQuery, "mMsgQuery");
        this.mMsgQuery = mMsgQuery;
    }

    private final void b(final Contact contact, long mainMsgSeq, long beginMsgSeq, ArticleMsgPullType pullType, final Function1<? super i, Unit> callback) {
        i(contact, mainMsgSeq, beginMsgSeq, pullType, new Function1<QueryMsgSeqListResult, Unit>() { // from class: com.tencent.guild.aio.article.data.GuildArticleMsgQueryProxy$loadArticleMsgRecordList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QueryMsgSeqListResult queryMsgSeqListResult) {
                invoke2(queryMsgSeqListResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull final QueryMsgSeqListResult queryMsgSeqListResult) {
                g gVar;
                Intrinsics.checkNotNullParameter(queryMsgSeqListResult, "queryMsgSeqListResult");
                if (queryMsgSeqListResult.getIsSuccess()) {
                    gVar = GuildArticleMsgQueryProxy.this.mMsgQuery;
                    Contact contact2 = contact;
                    ArrayList<Long> c16 = queryMsgSeqListResult.c();
                    final Function1<i, Unit> function1 = callback;
                    gVar.a(contact2, c16, new Function1<QueryMsgRecordListResult, Unit>() { // from class: com.tencent.guild.aio.article.data.GuildArticleMsgQueryProxy$loadArticleMsgRecordList$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(QueryMsgRecordListResult queryMsgRecordListResult) {
                            invoke2(queryMsgRecordListResult);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull QueryMsgRecordListResult it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            function1.invoke(new i(it.getIsSuccess(), it.getErrorMsg(), it.b(), queryMsgSeqListResult.getUpIsFinish(), queryMsgSeqListResult.getDownIsFinish()));
                        }
                    });
                    return;
                }
                callback.invoke(new i(queryMsgSeqListResult.getIsSuccess(), queryMsgSeqListResult.getErrorMsg(), new ArrayList(), queryMsgSeqListResult.getUpIsFinish(), queryMsgSeqListResult.getDownIsFinish()));
            }
        });
    }

    public final void c(@NotNull final Contact contact, long mainMsgSeq, @NotNull final Function1<? super i, Unit> callback) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mMsgQuery.d(contact, mainMsgSeq, new Function1<QueryMsgSeqListResult, Unit>() { // from class: com.tencent.guild.aio.article.data.GuildArticleMsgQueryProxy$loadBottomMostMsgRecordList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QueryMsgSeqListResult queryMsgSeqListResult) {
                invoke2(queryMsgSeqListResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull final QueryMsgSeqListResult queryMsgSeqListResult) {
                g gVar;
                Intrinsics.checkNotNullParameter(queryMsgSeqListResult, "queryMsgSeqListResult");
                if (queryMsgSeqListResult.getIsSuccess()) {
                    gVar = GuildArticleMsgQueryProxy.this.mMsgQuery;
                    Contact contact2 = contact;
                    ArrayList<Long> c16 = queryMsgSeqListResult.c();
                    final Function1<i, Unit> function1 = callback;
                    gVar.a(contact2, c16, new Function1<QueryMsgRecordListResult, Unit>() { // from class: com.tencent.guild.aio.article.data.GuildArticleMsgQueryProxy$loadBottomMostMsgRecordList$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(QueryMsgRecordListResult queryMsgRecordListResult) {
                            invoke2(queryMsgRecordListResult);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull QueryMsgRecordListResult it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            function1.invoke(new i(it.getIsSuccess(), it.getErrorMsg(), it.b(), queryMsgSeqListResult.getUpIsFinish(), queryMsgSeqListResult.getDownIsFinish()));
                        }
                    });
                    return;
                }
                callback.invoke(new i(queryMsgSeqListResult.getIsSuccess(), queryMsgSeqListResult.getErrorMsg(), new ArrayList(), queryMsgSeqListResult.getUpIsFinish(), queryMsgSeqListResult.getDownIsFinish()));
            }
        });
    }

    public final void d(@NotNull f sessionInfo, @NotNull Function1<? super i, Unit> callback) {
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        long mMainMsgSeq = sessionInfo.getMMainMsgSeq();
        ArticleMsgPullType articleMsgPullType = ArticleMsgPullType.PULL_DOWN;
        if (sessionInfo.getMLaunchFromType() == 2) {
            mMainMsgSeq = sessionInfo.getMRspMsgSeq();
            articleMsgPullType = ArticleMsgPullType.PULL_TWO_WAY;
        }
        b(sessionInfo.getMContact(), sessionInfo.getMMainMsgSeq(), mMainMsgSeq, articleMsgPullType, callback);
    }

    public final void e(@NotNull f sessionInfo, long beginMsgSeq, @NotNull Function1<? super i, Unit> callback) {
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        b(sessionInfo.getMContact(), sessionInfo.getMMainMsgSeq(), beginMsgSeq, ArticleMsgPullType.PULL_DOWN, callback);
    }

    public final void f(@NotNull f sessionInfo, long beginMsgSeq, @NotNull Function1<? super i, Unit> callback) {
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        b(sessionInfo.getMContact(), sessionInfo.getMMainMsgSeq(), beginMsgSeq, ArticleMsgPullType.PULL_UP, callback);
    }

    public final void g(@NotNull Contact contact, long mainMsgSeq, @NotNull Function1<? super i, Unit> callback) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(callback, "callback");
        b(contact, mainMsgSeq, mainMsgSeq, ArticleMsgPullType.PULL_DOWN, callback);
    }

    public final void h(@NotNull Contact contact, long msgSeq, @NotNull Function1<? super QueryMsgRecordResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mMsgQuery.b(contact, msgSeq, callback);
    }

    public final void i(@NotNull Contact contact, final long mainMsgSeq, final long beginMsgSeq, @NotNull ArticleMsgPullType pullType, @NotNull final Function1<? super QueryMsgSeqListResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(pullType, "pullType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mMsgQuery.c(contact, mainMsgSeq, beginMsgSeq, pullType, new Function1<QueryMsgSeqListResult, Unit>() { // from class: com.tencent.guild.aio.article.data.GuildArticleMsgQueryProxy$queryArticleMsgSeqList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QueryMsgSeqListResult queryMsgSeqListResult) {
                invoke2(queryMsgSeqListResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QueryMsgSeqListResult it) {
                ArrayList arrayListOf;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getIsSuccess() && beginMsgSeq == mainMsgSeq && it.c().isEmpty()) {
                    Function1<QueryMsgSeqListResult, Unit> function1 = callback;
                    boolean isSuccess = it.getIsSuccess();
                    String errorMsg = it.getErrorMsg();
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(mainMsgSeq));
                    function1.invoke(new QueryMsgSeqListResult(isSuccess, errorMsg, arrayListOf, it.getUpIsFinish(), it.getDownIsFinish()));
                    return;
                }
                callback.invoke(new QueryMsgSeqListResult(it.getIsSuccess(), it.getErrorMsg(), it.c(), it.getUpIsFinish(), it.getDownIsFinish()));
            }
        });
    }
}

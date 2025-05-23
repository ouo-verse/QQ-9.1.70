package com.tencent.guild.aio.article.data;

import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.dm;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import vh2.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b \u0010!J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J0\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\rH\u0016JE\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00102%\u0010\u000e\u001a!\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\f0\nj\u0002`\u0016H\u0016JO\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2%\u0010\u000e\u001a!\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\f0\nj\u0002`\u001dH\u0016J?\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\b2%\u0010\u000e\u001a!\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\f0\nj\u0002`\u001dH\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/guild/aio/article/data/e;", "Lcom/tencent/guild/aio/article/data/g;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "i", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "", "msgSeq", "Lkotlin/Function1;", "Lcom/tencent/guild/aio/article/data/k;", "", "Lcom/tencent/guild/aio/article/data/QueryMsgRecordCallback;", "callback", "b", "", "msgSeqList", "Lcom/tencent/guild/aio/article/data/j;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/guild/aio/article/data/QueryMsgRecordListCallback;", "a", "mainMsgSeq", "beginMsgSeq", "Lcom/tencent/guild/aio/article/data/ArticleMsgPullType;", "pullType", "Lcom/tencent/guild/aio/article/data/l;", "Lcom/tencent/guild/aio/article/data/QueryMsgSeqListCallback;", "c", "d", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e implements g {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f109826a;

        static {
            int[] iArr = new int[ArticleMsgPullType.values().length];
            try {
                iArr[ArticleMsgPullType.PULL_DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArticleMsgPullType.PULL_UP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArticleMsgPullType.PULL_TWO_WAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f109826a = iArr;
        }
    }

    private final boolean i(MsgRecord msgRecord) {
        Long l3;
        if (msgRecord != null && msgRecord.sendType != 3 && msgRecord.sendStatus == 2) {
            return true;
        }
        Long l16 = null;
        if (msgRecord != null) {
            l3 = Long.valueOf(msgRecord.msgSeq);
        } else {
            l3 = null;
        }
        if (msgRecord != null) {
            l16 = Long.valueOf(msgRecord.msgId);
        }
        QLog.d("GuildArticleMsgQuery", 1, "isRoamMsg false msgSeq = " + l3 + " msgId = " + l16);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 callback, long j3, int i3, String errMsg, String str, String str2, ArrayList comments, boolean z16, boolean z17) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (i3 != 0) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            callback.invoke(new QueryMsgSeqListResult(false, errMsg, new ArrayList(), z16, z17));
            return;
        }
        Intrinsics.checkNotNullExpressionValue(comments, "comments");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(comments, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = comments.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((dm) it.next()).getMsgSeq()));
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        if (arrayList2.isEmpty()) {
            arrayList2.add(Long.valueOf(j3));
        }
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        callback.invoke(new QueryMsgSeqListResult(true, errMsg, arrayList2, z16, z17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(e this$0, Function1 callback, int i3, String errMsg, ArrayList msgList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : msgList) {
            if (this$0.i((MsgRecord) obj)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            callback.invoke(new QueryMsgRecordResult(true, errMsg, (MsgRecord) arrayList.get(0)));
        } else {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            callback.invoke(new QueryMsgRecordResult(false, errMsg, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(e this$0, Function1 callback, int i3, String errMsg, ArrayList msgList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : msgList) {
            if (this$0.i((MsgRecord) obj)) {
                arrayList.add(obj);
            }
        }
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        callback.invoke(new QueryMsgRecordListResult(z16, errMsg, arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 callback, int i3, String errMsg, String str, String str2, ArrayList comments, boolean z16, boolean z17) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (i3 != 0) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            callback.invoke(new QueryMsgSeqListResult(false, errMsg, new ArrayList(), z16, z17));
            return;
        }
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        Intrinsics.checkNotNullExpressionValue(comments, "comments");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(comments, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = comments.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((dm) it.next()).getMsgSeq()));
        }
        callback.invoke(new QueryMsgSeqListResult(true, errMsg, new ArrayList(arrayList), z16, z17));
    }

    @Override // com.tencent.guild.aio.article.data.g
    public void a(@NotNull Contact contact, @NotNull List<Long> msgSeqList, @NotNull final Function1<? super QueryMsgRecordListResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(msgSeqList, "msgSeqList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (msgSeqList.isEmpty()) {
            callback.invoke(new QueryMsgRecordListResult(true, "", new ArrayList()));
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.addAll(msgSeqList);
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgsBySeqs(contact, arrayList, new IMsgOperateCallback() { // from class: com.tencent.guild.aio.article.data.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList2) {
                e.l(e.this, callback, i3, str, arrayList2);
            }
        });
    }

    @Override // com.tencent.guild.aio.article.data.g
    public void b(@NotNull Contact contact, long msgSeq, @NotNull final Function1<? super QueryMsgRecordResult, Unit> callback) {
        ArrayList<Long> arrayListOf;
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(msgSeq));
        iMsgService.getMsgsBySeqs(contact, arrayListOf, new IMsgOperateCallback() { // from class: com.tencent.guild.aio.article.data.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                e.k(e.this, callback, i3, str, arrayList);
            }
        });
    }

    @Override // com.tencent.guild.aio.article.data.g
    public void c(@NotNull Contact contact, long mainMsgSeq, long beginMsgSeq, @NotNull ArticleMsgPullType pullType, @NotNull final Function1<? super QueryMsgSeqListResult, Unit> callback) {
        long j3;
        long j16;
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(pullType, "pullType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        int i3 = b.f109826a[pullType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    j16 = 0;
                } else {
                    j16 = 20;
                }
                j3 = j16;
            } else {
                j16 = 20;
                j3 = 0;
            }
        } else {
            j3 = 20;
            j16 = 0;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).fetchComments(contact.guildId, contact.peerUid, mainMsgSeq, beginMsgSeq, j16, j3, new p() { // from class: com.tencent.guild.aio.article.data.c
            @Override // vh2.p
            public final void a(int i16, String str, String str2, String str3, ArrayList arrayList, boolean z16, boolean z17) {
                e.m(Function1.this, i16, str, str2, str3, arrayList, z16, z17);
            }
        });
    }

    @Override // com.tencent.guild.aio.article.data.g
    public void d(@NotNull Contact contact, final long mainMsgSeq, @NotNull final Function1<? super QueryMsgSeqListResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).fetchLatestComments(contact.guildId, contact.peerUid, mainMsgSeq, 20L, new p() { // from class: com.tencent.guild.aio.article.data.d
            @Override // vh2.p
            public final void a(int i3, String str, String str2, String str3, ArrayList arrayList, boolean z16, boolean z17) {
                e.j(Function1.this, mainMsgSeq, i3, str, str2, str3, arrayList, z16, z17);
            }
        });
    }
}

package com.tencent.guild.aio.article.data;

import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 92\u00020\u0001:\u0001;B\u000f\u0012\u0006\u0010=\u001a\u00020:\u00a2\u0006\u0004\bR\u0010SJ \u0010\u0007\u001a\u00020\u00042\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0006\u0010 \u001a\u00020\fJ\u0006\u0010!\u001a\u00020\fJ\b\u0010\"\u001a\u0004\u0018\u00010\bJ\u0006\u0010$\u001a\u00020#J\u0006\u0010%\u001a\u00020\fJ\u000e\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&J\u0006\u0010*\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020\u0004J\u000e\u0010,\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u0017\u0010-\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b/\u0010.J\u0006\u00100\u001a\u00020\u0004J\u0006\u00101\u001a\u00020\u0004J\u0006\u00102\u001a\u00020\u0004J\u000e\u00103\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\u0014\u00106\u001a\u00020\u00042\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001604J\u0014\u00107\u001a\u00020\u00042\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001604J\u0006\u00108\u001a\u00020\nJ\u0006\u00109\u001a\u00020\nR\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00160L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00160L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010NR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00160L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010N\u00a8\u0006T"}, d2 = {"Lcom/tencent/guild/aio/article/data/GuildArticleMsgListCenter;", "Ljava/util/Observable;", "Lkotlin/Function1;", "Lcom/tencent/guild/aio/article/data/k;", "", "Lcom/tencent/guild/aio/article/data/QueryMsgRecordCallback;", "callback", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "u", "", "beginMsgSeq", "Lcom/tencent/guild/aio/article/data/i;", "result", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "E", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Conn, "w", "Lcom/tencent/aio/data/msglist/a;", "msg", tl.h.F, "g", "Lcom/tencent/guild/aio/article/data/h;", "state", "K", "value", "M", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "l", "", "j", DomainData.DOMAIN_NAME, "Ljava/util/Observer;", "observer", "G", "H", "D", "r", HippyTKDListViewAdapter.X, "t", "(Ljava/lang/Long;)V", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "o", "v", "", TabPreloadItem.TAB_NAME_MESSAGE, "B", "L", "I", "i", "Lcom/tencent/guild/aio/article/data/f;", "a", "Lcom/tencent/guild/aio/article/data/f;", "mSession", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "mMainHandler", "Lcom/tencent/guild/aio/article/data/GuildArticleMsgQueryProxy;", "c", "Lcom/tencent/guild/aio/article/data/GuildArticleMsgQueryProxy;", "mQueryProxy", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mUpIsFinish", "e", "mDownIsFinish", "Ljava/util/concurrent/CopyOnWriteArrayList;", "f", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mFirstPageMsgItemCache", "mTopMostPageMsgItemCache", "mBottomMostPageMsgItemCache", "<init>", "(Lcom/tencent/guild/aio/article/data/f;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildArticleMsgListCenter extends Observable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f mSession;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mMainHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildArticleMsgQueryProxy mQueryProxy;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean mUpIsFinish;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean mDownIsFinish;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> mFirstPageMsgItemCache;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> mTopMostPageMsgItemCache;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> mBottomMostPageMsgItemCache;

    public GuildArticleMsgListCenter(@NotNull f mSession) {
        Intrinsics.checkNotNullParameter(mSession, "mSession");
        this.mSession = mSession;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mQueryProxy = new GuildArticleMsgQueryProxy(new e());
        this.mUpIsFinish = new AtomicBoolean(false);
        this.mDownIsFinish = new AtomicBoolean(false);
        this.mFirstPageMsgItemCache = new CopyOnWriteArrayList<>();
        this.mTopMostPageMsgItemCache = new CopyOnWriteArrayList<>();
        this.mBottomMostPageMsgItemCache = new CopyOnWriteArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(i result) {
        QLog.d("GuildArticleMsgListCenter", 1, "onLoadTopMostMsgRecordList isSuccess = " + result.getIsSuccess() + " errorMsg = " + result.getErrorMsg() + " msgListSize = " + result.c().size());
        if (result.getIsSuccess()) {
            ArrayList<MsgRecord> c16 = result.c();
            ArrayList arrayList = new ArrayList();
            for (Object obj : c16) {
                if (u((MsgRecord) obj)) {
                    arrayList.add(obj);
                }
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (hashSet.add(Long.valueOf(((MsgRecord) obj2).msgSeq))) {
                    arrayList2.add(obj2);
                }
            }
            synchronized (this) {
                this.mTopMostPageMsgItemCache.clear();
                this.mTopMostPageMsgItemCache.addAll(com.tencent.guild.api.msg.service.l.f112634a.g(arrayList2));
            }
        }
    }

    private final void C() {
        QLog.d("GuildArticleMsgListCenter", 1, "preLoadBottomMostMsgRecordList");
        this.mQueryProxy.c(this.mSession.getMContact(), this.mSession.getMMainMsgSeq(), new Function1<i, Unit>() { // from class: com.tencent.guild.aio.article.data.GuildArticleMsgListCenter$preLoadBottomMostMsgRecordList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(i iVar) {
                invoke2(iVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull i it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildArticleMsgListCenter.this.w(it);
            }
        });
    }

    private final void E() {
        QLog.d("GuildArticleMsgListCenter", 1, "preLoadTopMostMsgRecordList");
        this.mQueryProxy.g(this.mSession.getMContact(), this.mSession.getMMainMsgSeq(), new Function1<i, Unit>() { // from class: com.tencent.guild.aio.article.data.GuildArticleMsgListCenter$preLoadTopMostMsgRecordList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(i iVar) {
                invoke2(iVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull i it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildArticleMsgListCenter.this.A(it);
            }
        });
    }

    private final void F(Function1<? super QueryMsgRecordResult, Unit> callback) {
        this.mQueryProxy.h(this.mSession.getMContact(), this.mSession.getMMainMsgSeq(), callback);
    }

    private final void J(boolean value) {
        this.mDownIsFinish.set(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(h state) {
        setChanged();
        notifyObservers(state);
    }

    private final void M(boolean value) {
        this.mUpIsFinish.set(value);
    }

    private final void g(com.tencent.aio.data.msglist.a msg2) {
        if (!this.mBottomMostPageMsgItemCache.isEmpty()) {
            if (this.mBottomMostPageMsgItemCache.size() >= 20) {
                CollectionsKt__MutableCollectionsKt.removeFirst(this.mBottomMostPageMsgItemCache);
            }
            this.mBottomMostPageMsgItemCache.add(msg2);
        }
    }

    private final void h(com.tencent.aio.data.msglist.a msg2) {
        if ((!this.mTopMostPageMsgItemCache.isEmpty()) && this.mTopMostPageMsgItemCache.size() < 20) {
            this.mTopMostPageMsgItemCache.add(msg2);
        }
    }

    private final boolean u(MsgRecord msgRecord) {
        if (msgRecord.msgId != k() && msgRecord.msgType != 9) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(i result) {
        QLog.d("GuildArticleMsgListCenter", 1, "onLoadBottomMostMsgRecordList isSuccess = " + result.getIsSuccess() + " errorMsg = " + result.getErrorMsg() + " msgListSize = " + result.c().size());
        if (result.getIsSuccess()) {
            ArrayList<MsgRecord> c16 = result.c();
            ArrayList arrayList = new ArrayList();
            for (Object obj : c16) {
                if (u((MsgRecord) obj)) {
                    arrayList.add(obj);
                }
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (hashSet.add(Long.valueOf(((MsgRecord) obj2).msgSeq))) {
                    arrayList2.add(obj2);
                }
            }
            synchronized (this) {
                this.mBottomMostPageMsgItemCache.clear();
                this.mBottomMostPageMsgItemCache.addAll(com.tencent.guild.api.msg.service.l.f112634a.g(arrayList2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(long beginMsgSeq, i result) {
        List emptyList;
        Object first;
        QLog.i("GuildArticleMsgListCenter", 1, "onLoadNextPageMsgRecordList, beginMsgSeq = " + beginMsgSeq + ", isSuccess = " + result.getIsSuccess() + ", size = " + result.c().size() + " upIsFinished = " + result.getUpIsFinish() + " downIsFinished = " + result.getDownIsFinish());
        if (!result.getIsSuccess() || !(!result.c().isEmpty())) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            K(new h(3, false, emptyList));
            return;
        }
        J(result.getDownIsFinish());
        ArrayList<MsgRecord> c16 = result.c();
        ArrayList arrayList = new ArrayList();
        for (Object obj : c16) {
            if (u((MsgRecord) obj)) {
                arrayList.add(obj);
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (hashSet.add(Long.valueOf(((MsgRecord) obj2).msgSeq))) {
                arrayList2.add(obj2);
            }
        }
        if (!arrayList2.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
            if (((MsgRecord) first).msgSeq == beginMsgSeq) {
                CollectionsKt__MutableCollectionsKt.removeFirst(arrayList2);
            }
        }
        K(new h(3, true, com.tencent.guild.api.msg.service.l.f112634a.g(arrayList2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(long beginMsgSeq, i result) {
        List emptyList;
        Object last;
        QLog.i("GuildArticleMsgListCenter", 1, "onLoadPrePageMsgResultList, beginMsgSeq = " + beginMsgSeq + ", isSuccess = " + result.getIsSuccess() + ", size = " + result.c().size() + "  upIsFinished = " + result.getUpIsFinish() + " downIsFinished = " + result.getDownIsFinish());
        if (!result.getIsSuccess() || !(!result.c().isEmpty())) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            K(new h(2, false, emptyList));
            return;
        }
        M(result.getUpIsFinish());
        ArrayList<MsgRecord> c16 = result.c();
        ArrayList arrayList = new ArrayList();
        for (Object obj : c16) {
            if (u((MsgRecord) obj)) {
                arrayList.add(obj);
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (hashSet.add(Long.valueOf(((MsgRecord) obj2).msgSeq))) {
                arrayList2.add(obj2);
            }
        }
        if (!arrayList2.isEmpty()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList2);
            if (((MsgRecord) last).msgSeq == beginMsgSeq) {
                CollectionsKt__MutableCollectionsKt.removeLast(arrayList2);
            }
        }
        K(new h(2, true, com.tencent.guild.api.msg.service.l.f112634a.g(arrayList2)));
    }

    public final void B(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        synchronized (this) {
            for (com.tencent.aio.data.msglist.a aVar : msgList) {
                h(aVar);
                g(aVar);
            }
            this.mDownIsFinish.set(false);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void D() {
        QLog.d("GuildArticleMsgListCenter", 1, "preLoadMsgRecordList begin");
        F(new Function1<QueryMsgRecordResult, Unit>() { // from class: com.tencent.guild.aio.article.data.GuildArticleMsgListCenter$preLoadMsgRecordList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QueryMsgRecordResult queryMsgRecordResult) {
                invoke2(queryMsgRecordResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QueryMsgRecordResult it) {
                f fVar;
                List listOf;
                f fVar2;
                Intrinsics.checkNotNullParameter(it, "it");
                boolean isSuccess = it.getIsSuccess();
                String errorMsg = it.getErrorMsg();
                MsgRecord msgRecord = it.getMsgRecord();
                Long valueOf = msgRecord != null ? Long.valueOf(msgRecord.msgSeq) : null;
                MsgRecord msgRecord2 = it.getMsgRecord();
                QLog.d("GuildArticleMsgListCenter", 1, "queryMainMsgRecord isSuccess = " + isSuccess + "  errorMsg = " + errorMsg + "  mainMsgSeq = " + valueOf + " mainMsgId = " + (msgRecord2 != null ? Long.valueOf(msgRecord2.msgId) : null));
                if (!it.getIsSuccess() || it.getMsgRecord() == null) {
                    fVar = GuildArticleMsgListCenter.this.mSession;
                    QLog.d("GuildArticleMsgListCenter", 1, "queryMainMsgRecord error! channelId = " + fVar.a());
                    return;
                }
                com.tencent.guild.api.msg.service.l lVar = com.tencent.guild.api.msg.service.l.f112634a;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(it.getMsgRecord());
                GuildArticleMsgListCenter.this.K(new h(0, it.getIsSuccess(), lVar.g(listOf)));
                fVar2 = GuildArticleMsgListCenter.this.mSession;
                fVar2.g(it.getMsgRecord());
            }
        });
        r();
        E();
        C();
    }

    public final void G(@NotNull Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        addObserver(observer);
    }

    public final void H(@NotNull Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        deleteObserver(observer);
    }

    public final boolean I() {
        return this.mUpIsFinish.get();
    }

    public final void L(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        synchronized (this) {
            Iterator<? extends com.tencent.aio.data.msglist.a> it = msgList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.aio.data.msglist.a next = it.next();
                int size = this.mTopMostPageMsgItemCache.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (next.getMsgId() == this.mTopMostPageMsgItemCache.get(i3).getMsgId()) {
                        this.mTopMostPageMsgItemCache.set(i3, next);
                    }
                }
            }
            for (com.tencent.aio.data.msglist.a aVar : msgList) {
                int size2 = this.mBottomMostPageMsgItemCache.size();
                for (int i16 = 0; i16 < size2; i16++) {
                    if (aVar.getMsgId() == this.mBottomMostPageMsgItemCache.get(i16).getMsgId()) {
                        this.mBottomMostPageMsgItemCache.set(i16, aVar);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean i() {
        return this.mDownIsFinish.get();
    }

    public final int j() {
        return this.mSession.getMLaunchFromType();
    }

    public final long k() {
        MsgRecord mMainMsgRecord = this.mSession.getMMainMsgRecord();
        if (mMainMsgRecord != null) {
            return mMainMsgRecord.msgId;
        }
        return 0L;
    }

    @Nullable
    public final MsgRecord l() {
        return this.mSession.getMMainMsgRecord();
    }

    public final long m() {
        return this.mSession.getMMainMsgSeq();
    }

    public final long n() {
        return this.mSession.getMRspMsgSeq();
    }

    public final void o() {
        List emptyList;
        List list;
        Object first;
        QLog.d("GuildArticleMsgListCenter", 1, "handleJumpToBottomMostMsg begin");
        if (!this.mBottomMostPageMsgItemCache.isEmpty()) {
            list = CollectionsKt___CollectionsKt.toList(this.mBottomMostPageMsgItemCache);
            K(new h(5, true, list));
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.mBottomMostPageMsgItemCache);
            if (((com.tencent.aio.data.msglist.a) first).getMsgSeq() != m()) {
                M(false);
                return;
            }
            return;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        K(new h(5, false, emptyList));
    }

    public final void p() {
        List emptyList;
        List list;
        Object last;
        Object last2;
        QLog.d("GuildArticleMsgListCenter", 1, "handleJumpToTopMostMsg begin");
        if (!this.mTopMostPageMsgItemCache.isEmpty()) {
            list = CollectionsKt___CollectionsKt.toList(this.mTopMostPageMsgItemCache);
            K(new h(4, true, list));
            if (!this.mBottomMostPageMsgItemCache.isEmpty()) {
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.mTopMostPageMsgItemCache);
                long msgSeq = ((com.tencent.aio.data.msglist.a) last).getMsgSeq();
                last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.mBottomMostPageMsgItemCache);
                if (msgSeq != ((com.tencent.aio.data.msglist.a) last2).getMsgSeq()) {
                    J(false);
                    return;
                }
                return;
            }
            return;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        K(new h(4, false, emptyList));
    }

    public final void q() {
        List list;
        List listOf;
        QLog.d("GuildArticleMsgListCenter", 1, "loadFirstPage begin");
        if (this.mSession.getMMainMsgRecord() != null) {
            QLog.d("GuildArticleMsgListCenter", 1, "loadFirstPage updateLoadMsgPageState LOAD_MAIN_MSG");
            com.tencent.guild.api.msg.service.l lVar = com.tencent.guild.api.msg.service.l.f112634a;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(this.mSession.getMMainMsgRecord());
            K(new h(0, true, lVar.g(listOf)));
        }
        if (!this.mFirstPageMsgItemCache.isEmpty()) {
            QLog.d("GuildArticleMsgListCenter", 1, "loadFirstPage updateLoadMsgPageState LOAD_FIRST_PAGE");
            list = CollectionsKt___CollectionsKt.toList(this.mFirstPageMsgItemCache);
            K(new h(1, true, list));
        }
    }

    public final void r() {
        QLog.i("GuildArticleMsgListCenter", 1, "loadFirstPageMsgRecordList");
        this.mQueryProxy.d(this.mSession, new Function1<i, Unit>() { // from class: com.tencent.guild.aio.article.data.GuildArticleMsgListCenter$loadFirstPageMsgRecordList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(i iVar) {
                invoke2(iVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull i it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildArticleMsgListCenter.this.x(it);
            }
        });
    }

    public final void s(@Nullable final Long beginMsgSeq) {
        QLog.i("GuildArticleMsgListCenter", 1, "loadNextPageMsgRecordList, beginMsgSeq = " + beginMsgSeq + " downIsFinished = " + this.mDownIsFinish.get());
        if (beginMsgSeq != null && !this.mDownIsFinish.get()) {
            this.mQueryProxy.e(this.mSession, beginMsgSeq.longValue(), new Function1<i, Unit>() { // from class: com.tencent.guild.aio.article.data.GuildArticleMsgListCenter$loadNextPageMsgRecordList$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(i iVar) {
                    invoke2(iVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull i it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    GuildArticleMsgListCenter.this.y(beginMsgSeq.longValue(), it);
                }
            });
        }
    }

    public final void t(@Nullable final Long beginMsgSeq) {
        QLog.i("GuildArticleMsgListCenter", 1, "loadPrePageMsgRecordList, beginMsgSeq = " + beginMsgSeq + "  upIsFinish = " + this.mUpIsFinish.get());
        if (beginMsgSeq != null && !this.mUpIsFinish.get()) {
            if (beginMsgSeq.longValue() == this.mSession.getMMainMsgSeq()) {
                M(true);
            } else {
                this.mQueryProxy.f(this.mSession, beginMsgSeq.longValue(), new Function1<i, Unit>() { // from class: com.tencent.guild.aio.article.data.GuildArticleMsgListCenter$loadPrePageMsgRecordList$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(i iVar) {
                        invoke2(iVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull i it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        GuildArticleMsgListCenter.this.z(beginMsgSeq.longValue(), it);
                    }
                });
            }
        }
    }

    public final void v(@NotNull com.tencent.aio.data.msglist.a msg2) {
        Object first;
        List list;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        synchronized (this) {
            h(msg2);
            g(msg2);
            if (!this.mBottomMostPageMsgItemCache.isEmpty()) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.mBottomMostPageMsgItemCache);
                if (((com.tencent.aio.data.msglist.a) first).getMsgSeq() != m()) {
                    M(false);
                }
                list = CollectionsKt___CollectionsKt.toList(this.mBottomMostPageMsgItemCache);
                K(new h(5, true, list));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void x(@NotNull i result) {
        List emptyList;
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.i("GuildArticleMsgListCenter", 1, "onLoadFirstPageMsgRecordList, isSuccess = " + result.getIsSuccess() + ", size = " + result.c().size() + "  upIsFinish = " + result.getUpIsFinish() + "  downIsFinish = " + result.getDownIsFinish());
        if (!result.getIsSuccess() || !(!result.c().isEmpty())) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            K(new h(1, false, emptyList));
            return;
        }
        M(result.getUpIsFinish());
        J(result.getDownIsFinish());
        ArrayList<MsgRecord> c16 = result.c();
        ArrayList arrayList = new ArrayList();
        for (Object obj : c16) {
            if (u((MsgRecord) obj)) {
                arrayList.add(obj);
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (hashSet.add(Long.valueOf(((MsgRecord) obj2).msgSeq))) {
                arrayList2.add(obj2);
            }
        }
        List<GuildMsgItem> g16 = com.tencent.guild.api.msg.service.l.f112634a.g(arrayList2);
        this.mFirstPageMsgItemCache.clear();
        this.mFirstPageMsgItemCache.addAll(g16);
        K(new h(1, true, g16));
    }
}

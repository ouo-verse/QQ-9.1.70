package com.tencent.mobileqq.reminder.db.real.engine;

import android.text.TextUtils;
import cm2.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.reminder.db.b;
import com.tencent.mobileqq.reminder.util.QQConstants;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 62\u00020\u0001:\u00017B\u000f\u0012\u0006\u0010'\u001a\u00020\u0001\u00a2\u0006\u0004\b4\u00105J\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002J\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J)\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0016\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J%\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ1\u0010\"\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0 H\u0016\u00a2\u0006\u0004\b\"\u0010#J#\u0010$\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010)R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R&\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u000e0/j\b\u0012\u0004\u0012\u00020\u000e`08\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/reminder/db/real/engine/CacheDataEngine;", "Lcom/tencent/mobileqq/reminder/db/real/engine/a;", "Lcom/tencent/mobileqq/reminder/db/b;", "g", "f", "", "e", "", "activateFriendsUin", "", "uinTypeActivateFriends", "", "getMsgList", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/util/List;", "", "uniseq", "removeMsgByUniseq", "(Ljava/lang/String;Ljava/lang/Integer;J)V", "list", "account", "", "isBackgroundStop", "addMessage", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)V", "messageRecord", "b", "removeMsgByMessageRecord", "Lcom/tencent/mobileqq/reminder/db/entity/b;", "getLastMessage", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/tencent/mobileqq/reminder/db/entity/b;", "uin", "type", "Lkotlin/Function0;", "delegate", "getUnreadCount", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)I", "setReaded", "(Ljava/lang/String;Ljava/lang/Integer;)V", "Lcom/tencent/mobileqq/reminder/db/real/engine/a;", "dbEngine", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "unReadCount", "Ljava/util/LinkedList;", h.F, "Ljava/util/LinkedList;", "cacheData", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "i", "Ljava/util/HashSet;", "uniseqSet", "<init>", "(Lcom/tencent/mobileqq/reminder/db/real/engine/a;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class CacheDataEngine extends com.tencent.mobileqq.reminder.db.real.engine.a {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final a f281041m;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.reminder.db.real.engine.a dbEngine;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicInteger unReadCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinkedList<com.tencent.mobileqq.reminder.db.b> cacheData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashSet<Long> uniseqSet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/reminder/db/real/engine/CacheDataEngine$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class b<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.mobileqq.reminder.db.b) t17).getTime()), Long.valueOf(((com.tencent.mobileqq.reminder.db.b) t16).getTime()));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28619);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f281041m = new a(null);
        }
    }

    public CacheDataEngine(@NotNull com.tencent.mobileqq.reminder.db.real.engine.a dbEngine) {
        Intrinsics.checkNotNullParameter(dbEngine, "dbEngine");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dbEngine);
            return;
        }
        this.dbEngine = dbEngine;
        this.unReadCount = new AtomicInteger(0);
        this.cacheData = new LinkedList<>();
        this.uniseqSet = new HashSet<>();
    }

    private final void e() {
        if (!a()) {
            a.C0203a.b(this, null, null, 3, null);
        }
    }

    private final com.tencent.mobileqq.reminder.db.b f(com.tencent.mobileqq.reminder.db.b bVar) {
        if (bVar.getIsread()) {
            this.unReadCount.decrementAndGet();
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.reminder.db.b g(com.tencent.mobileqq.reminder.db.b bVar) {
        if (!bVar.getIsread()) {
            this.unReadCount.incrementAndGet();
        }
        return bVar;
    }

    @Override // cm2.a
    public synchronized void addMessage(@NotNull List<? extends com.tencent.mobileqq.reminder.db.b> list, @Nullable String account, @Nullable Boolean isBackgroundStop) {
        Sequence asSequence;
        Sequence filter;
        Sequence sortedWith;
        Sequence map;
        List<? extends com.tencent.mobileqq.reminder.db.b> list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, list, account, isBackgroundStop);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        if (!a()) {
            getMsgList(QQConstants.ACTIVATE_FRIENDS_UIN, 9002);
        }
        asSequence = CollectionsKt___CollectionsKt.asSequence(list);
        filter = SequencesKt___SequencesKt.filter(asSequence, new Function1<com.tencent.mobileqq.reminder.db.b, Boolean>() { // from class: com.tencent.mobileqq.reminder.db.real.engine.CacheDataEngine$addMessage$addList$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CacheDataEngine.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull b it) {
                HashSet hashSet;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                hashSet = CacheDataEngine.this.uniseqSet;
                return Boolean.valueOf(!hashSet.contains(Long.valueOf(it.getUniseq())));
            }
        });
        sortedWith = SequencesKt___SequencesKt.sortedWith(filter, new b());
        map = SequencesKt___SequencesKt.map(sortedWith, new Function1<com.tencent.mobileqq.reminder.db.b, com.tencent.mobileqq.reminder.db.b>() { // from class: com.tencent.mobileqq.reminder.db.real.engine.CacheDataEngine$addMessage$addList$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CacheDataEngine.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final b invoke(@NotNull b it) {
                HashSet hashSet;
                b g16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (b) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                hashSet = CacheDataEngine.this.uniseqSet;
                hashSet.add(Long.valueOf(it.getUniseq()));
                g16 = CacheDataEngine.this.g(it);
                return g16;
            }
        });
        list2 = SequencesKt___SequencesKt.toList(map);
        if (list2.isEmpty()) {
            com.tencent.mobileqq.reminder.db.a.i("CacheDataEngine", "needAdd empty return", null, 4, null);
            return;
        }
        com.tencent.mobileqq.reminder.db.a.i("CacheDataEngine", "addMessage " + list, null, 4, null);
        this.cacheData.addAll(0, list2);
        this.dbEngine.addMessage(list2, account, isBackgroundStop);
    }

    @Override // cm2.a
    @Nullable
    public synchronized com.tencent.mobileqq.reminder.db.entity.b getLastMessage(@Nullable String activateFriendsUin, @Nullable Integer uinTypeActivateFriends) {
        Object first;
        String w3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.reminder.db.entity.b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) activateFriendsUin, (Object) uinTypeActivateFriends);
        }
        e();
        if (a()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.cacheData);
            com.tencent.mobileqq.reminder.db.entity.b g16 = com.tencent.mobileqq.reminder.db.a.g((com.tencent.mobileqq.reminder.db.b) first);
            if (TextUtils.isEmpty(g16.getMsg())) {
                w3 = g16.getMsg();
            } else {
                w3 = cq.w(g16.getMsg(), 2);
            }
            com.tencent.mobileqq.reminder.db.a.i("CacheDataEngine", "getLastMessage uniseq: " + g16.getUniseq() + " msgType " + g16.getMsgType() + " msg:" + w3 + " time:" + g16.getTime(), null, 4, null);
            return g16;
        }
        return null;
    }

    @Override // cm2.a
    @NotNull
    public synchronized List<com.tencent.mobileqq.reminder.db.b> getMsgList(@Nullable String activateFriendsUin, @Nullable Integer uinTypeActivateFriends) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activateFriendsUin, (Object) uinTypeActivateFriends);
        }
        QLog.e("CacheDataEngine", 4, "getMsgList", new Throwable(VasPerfReportUtils.WHILE_GET_LIST));
        if (a()) {
            ArrayList arrayList = new ArrayList(this.cacheData);
            com.tencent.mobileqq.reminder.db.a.b("CacheDataEngine", "getMsgList: return cache " + arrayList.size(), null, 4, null);
            return arrayList;
        }
        List<com.tencent.mobileqq.reminder.db.b> msgList = this.dbEngine.getMsgList(activateFriendsUin, uinTypeActivateFriends);
        this.cacheData.clear();
        this.uniseqSet.clear();
        for (com.tencent.mobileqq.reminder.db.b bVar : msgList) {
            this.cacheData.add(g(bVar));
            this.uniseqSet.add(Long.valueOf(bVar.getUniseq()));
        }
        b(true);
        com.tencent.mobileqq.reminder.db.a.b("CacheDataEngine", "getMsgList: return db " + msgList.size(), null, 4, null);
        return msgList;
    }

    public synchronized int getUnreadCount(@Nullable String uin, @Nullable Integer type, @NotNull Function0<Integer> delegate) {
        int coerceAtLeast;
        int coerceAtLeast2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, uin, type, delegate)).intValue();
        }
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        if (a()) {
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(0, this.unReadCount.get());
            com.tencent.mobileqq.reminder.db.a.i("CacheDataEngine", "getUnreadCount " + coerceAtLeast2, null, 4, null);
            return coerceAtLeast2;
        }
        e();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, this.unReadCount.get());
        com.tencent.mobileqq.reminder.db.a.i("CacheDataEngine", "getUnreadCount  mustCheckFetchList " + coerceAtLeast, null, 4, null);
        return coerceAtLeast;
    }

    public synchronized void removeMsgByMessageRecord(@NotNull com.tencent.mobileqq.reminder.db.b messageRecord, boolean b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, messageRecord, Boolean.valueOf(b16));
        } else {
            Intrinsics.checkNotNullParameter(messageRecord, "messageRecord");
            removeMsgByUniseq(null, null, messageRecord.getUniseq());
        }
    }

    @Override // cm2.a
    public synchronized void removeMsgByUniseq(@Nullable String activateFriendsUin, @Nullable Integer uinTypeActivateFriends, long uniseq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activateFriendsUin, uinTypeActivateFriends, Long.valueOf(uniseq));
            return;
        }
        if (!this.uniseqSet.contains(Long.valueOf(uniseq))) {
            com.tencent.mobileqq.reminder.db.a.i("CacheDataEngine", "removeMsgByUniseq fail, not have " + uniseq, null, 4, null);
            return;
        }
        com.tencent.mobileqq.reminder.db.a.i("CacheDataEngine", "removeMsgByUniseq, uniseq-> " + uniseq, null, 4, null);
        Iterator<com.tencent.mobileqq.reminder.db.b> it = this.cacheData.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "cacheData.iterator()");
        while (it.hasNext()) {
            com.tencent.mobileqq.reminder.db.b next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            com.tencent.mobileqq.reminder.db.b bVar = next;
            if (bVar.getUniseq() == uniseq) {
                it.remove();
                f(bVar);
                this.uniseqSet.remove(Long.valueOf(bVar.getUniseq()));
                this.dbEngine.removeMsgByUniseq(activateFriendsUin, uinTypeActivateFriends, uniseq);
                return;
            }
        }
    }

    @Override // cm2.a
    public synchronized void setReaded(@Nullable String activateFriendsUin, @Nullable Integer uinTypeActivateFriends) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activateFriendsUin, (Object) uinTypeActivateFriends);
            return;
        }
        com.tencent.mobileqq.reminder.db.a.b("CacheDataEngine", "setReaded ", null, 4, null);
        this.unReadCount.set(0);
        Iterator<T> it = this.cacheData.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.reminder.db.b) it.next()).setIsread(true);
        }
        this.dbEngine.setReaded(activateFriendsUin, uinTypeActivateFriends);
    }
}

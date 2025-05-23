package com.tencent.mobileqq.guild.inbox.startpanel;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mobileqq.guild.message.directmessage.model.data.InboxNoticeNode;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.InboxNoticeNodeRepository;
import com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ThreadUtils;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.cq;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildInboxC2CViewModel extends com.tencent.mobileqq.mvvm.c<wy1.a> implements com.tencent.mobileqq.guild.message.directmessage.model.repositories.l, com.tencent.mobileqq.guild.message.directmessage.model.repositories.m {
    private static final Comparator<p> R = new Comparator() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.f
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int q26;
            q26 = GuildInboxC2CViewModel.q2((p) obj, (p) obj2);
            return q26;
        }
    };
    public static final ViewModelProvider.Factory S = new b();
    private final MediatorLiveData<c> C;
    private final cn<Boolean> D;
    private final AtomicBoolean E;
    private boolean F;
    private IGPSService G;
    private IGuildMsgReadedService H;
    private com.tencent.mobileqq.guild.avatar.a I;
    private final GPServiceObserver J;
    private boolean K;
    private String L;
    private boolean M;
    private int N;
    private HashSet<Long> P;
    private HashSet<Long> Q;

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<List<p>> f226219i;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<List<p>> f226220m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a extends GPServiceObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserDisplayNameUpdate(String str) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.C2C.GuildInboxC2CViewModel", 2, "onUserDisplayNameUpdate: " + str);
            }
            List list = (List) GuildInboxC2CViewModel.this.f226219i.getValue();
            if (list != null && !list.isEmpty()) {
                int i3 = 0;
                while (true) {
                    if (i3 < list.size()) {
                        if (TextUtils.equals(str, ((p) list.get(i3)).f226298h)) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 == -1) {
                    return;
                }
                p pVar = (p) list.get(i3);
                String guildUserDisplayNameInternal = GuildInboxC2CViewModel.this.G.getGuildUserDisplayNameInternal(pVar.F, pVar.f226298h);
                if (!TextUtils.isEmpty(guildUserDisplayNameInternal) && !TextUtils.equals(guildUserDisplayNameInternal, pVar.f226299i)) {
                    pVar.f226299i = guildUserDisplayNameInternal;
                    list.set(i3, pVar);
                    GuildInboxC2CViewModel.this.f226219i.postValue(list);
                    if (QLog.isColorLevel()) {
                        QLog.i("Guild.C2C.GuildInboxC2CViewModel", 2, "onUserDisplayNameUpdate: find node is update " + pVar);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class b implements ViewModelProvider.Factory {
        b() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new GuildInboxC2CViewModel(new wy1.a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        public List<p> f226223a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public boolean f226224b;
    }

    public GuildInboxC2CViewModel(wy1.a aVar) {
        super(aVar);
        this.f226219i = new MutableLiveData<>(Collections.emptyList());
        this.f226220m = new MutableLiveData<>(Collections.emptyList());
        this.C = new MediatorLiveData<>();
        this.D = new cn<>();
        this.E = new AtomicBoolean(false);
        this.F = false;
        int i3 = d.S;
        this.I = new com.tencent.mobileqq.guild.avatar.a(i3, i3);
        this.J = e2();
        this.M = false;
        this.N = 0;
        this.P = new HashSet<>();
        this.Q = new HashSet<>();
        k2();
    }

    private void W1() {
        ThreadUtils.f(new Runnable() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.GuildInboxC2CViewModel.3
            @Override // java.lang.Runnable
            public void run() {
                if (!GuildInboxC2CViewModel.this.E.compareAndSet(true, false)) {
                    if (QLog.isDebugVersion()) {
                        QLog.d("Guild.C2C.GuildInboxC2CViewModel", 4, "asyncUpdateC2CMessageNodeList: no change, ignore");
                    }
                } else {
                    List c26 = GuildInboxC2CViewModel.this.c2(DirectMessageNodeRepository.N());
                    GuildInboxC2CViewModel.this.M = true;
                    GuildInboxC2CViewModel.this.f226219i.postValue(c26);
                }
            }
        });
    }

    private void Z1(String str) {
        this.H.setGuildMsgReaded(str, 8, true);
    }

    private void a2(String str) {
        InboxNoticeNodeRepository.m(az.c(str, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<p> c2(List<DirectMessageNode> list) {
        boolean z16;
        boolean z17;
        long uptimeMillis = SystemClock.uptimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        for (DirectMessageNode directMessageNode : list) {
            if (directMessageNode.getIsVisible() && !directMessageNode.getIsInBlack()) {
                p pVar = new p();
                pVar.f226295d = 0;
                pVar.f226296e = directMessageNode.getGuildId();
                pVar.f226297f = directMessageNode.getChannelId();
                pVar.f226298h = directMessageNode.getSource().getTinyId();
                pVar.F = directMessageNode.getSource().getGuildId();
                pVar.f226300m = directMessageNode.m() / 1000;
                pVar.G = directMessageNode.getMemberType();
                IGuildUnreadCntService.b bVar = new IGuildUnreadCntService.b();
                bVar.f230840d = directMessageNode.b();
                bVar.f230841e = directMessageNode.getNotifyType();
                pVar.C = bVar;
                if (directMessageNode.getNotifyType() == 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                pVar.I = z16;
                pVar.D = com.tencent.mobileqq.guild.summary.c.c(directMessageNode.getLastMessage(), directMessageNode.getDraftInfo());
                if (!TextUtils.isEmpty(directMessageNode.getSource().getGuildId()) && !TextUtils.isEmpty(directMessageNode.getSource().getTinyId())) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                pVar.H = z17;
                if (z17) {
                    arrayList2.add(directMessageNode.getGuildId());
                } else {
                    y2(directMessageNode, pVar);
                }
                arrayList.add(pVar);
                if (i3 < 50 && QLog.isDebugVersion()) {
                    QLog.d("Guild.C2C.GuildInboxC2CViewModel", 4, "convert from [", Integer.valueOf(i3), "]", directMessageNode);
                    QLog.d("Guild.C2C.GuildInboxC2CViewModel", 4, "convert to [", Integer.valueOf(i3), "]", pVar);
                }
                i3++;
            } else if (QLog.isColorLevel()) {
                QLog.d("Guild.C2C.GuildInboxC2CViewModel", 2, "convert node ", directMessageNode, " is INVISIBLE");
            }
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        if (QLog.isDebugVersion()) {
            QLog.d("Guild.C2C.GuildInboxC2CViewModel", 4, "convertDirectMessageNodesToUiDataList() usage: ", Long.valueOf(uptimeMillis2), " ms");
        }
        QLog.i("Guild.C2C.GuildInboxC2CViewModel", 1, "need update guildIds: " + arrayList2);
        return arrayList;
    }

    private List<p> d2(List<InboxNoticeNode> list) {
        int i3;
        ArrayList arrayList = new ArrayList();
        for (InboxNoticeNode inboxNoticeNode : list) {
            if (inboxNoticeNode.getIsVisible()) {
                p b16 = yp1.a.b(inboxNoticeNode.getType());
                b16.f226300m = inboxNoticeNode.getMessageTime();
                if (!TextUtils.isEmpty(inboxNoticeNode.getMessage())) {
                    b16.D = com.tencent.mobileqq.guild.summary.c.b(inboxNoticeNode.getMessage());
                }
                cq redPoint = inboxNoticeNode.getRedPoint();
                if (n2(redPoint)) {
                    IGuildUnreadCntService.b bVar = b16.C;
                    bVar.f230840d = redPoint.f265932b;
                    if (redPoint.f265934d == 0) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    bVar.f230841e = i3;
                }
                arrayList.add(b16);
                if (QLog.isDebugVersion()) {
                    QLog.d("Guild.C2C.GuildInboxC2CViewModel", 4, "convertInboxNoticeNodesToUiDataList() uiData: ", b16);
                }
            }
        }
        return arrayList;
    }

    private GPServiceObserver e2() {
        return new a();
    }

    private void j2() {
        this.f226219i.setValue(Collections.emptyList());
        DirectMessageNodeRepository.z(new com.tencent.mobileqq.guild.base.repository.h() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.h
            @Override // com.tencent.mobileqq.guild.base.repository.h
            public final void a(ri1.a aVar, Object obj) {
                GuildInboxC2CViewModel.this.p2(aVar, (List) obj);
            }
        });
    }

    private void k2() {
        this.C.addSource(this.f226219i, new Observer() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildInboxC2CViewModel.this.s2((List) obj);
            }
        });
        this.C.addSource(this.f226220m, new Observer() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildInboxC2CViewModel.this.s2((List) obj);
            }
        });
    }

    private void l2() {
        InboxNoticeNodeRepository.o();
        this.f226220m.postValue(d2(InboxNoticeNodeRepository.t()));
    }

    private void m2() {
        this.G = (IGPSService) ch.R0(IGPSService.class);
        this.H = (IGuildMsgReadedService) ch.R0(IGuildMsgReadedService.class);
    }

    private boolean n2(cq cqVar) {
        if (cqVar != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild.C2C.GuildInboxC2CViewModel", 2, "getNoticeRedPoint redPoint:", cqVar);
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildInboxC2CViewModel", 2, "the officialNodeUIData unread Info is null");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o2(ArrayList arrayList, ri1.a aVar, List list) {
        boolean z16;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.P.remove((Long) it.next());
        }
        int i3 = 0;
        if (!aVar.d()) {
            QLog.e("Guild.C2C.GuildInboxC2CViewModel", 1, "DirectMessageNodeRepository.fetchDirectList error", aVar);
            return;
        }
        if (list != null) {
            Iterator it5 = list.iterator();
            while (it5.hasNext()) {
                DirectMessageNode directMessageNode = (DirectMessageNode) it5.next();
                if (!TextUtils.isEmpty(directMessageNode.getSource().getGuildId()) && !TextUtils.isEmpty(directMessageNode.getSource().getTinyId())) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    this.Q.remove(Long.valueOf(Long.parseLong(directMessageNode.getGuildId())));
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(directMessageNode.getSource().getTinyId());
                    this.I.g(directMessageNode.getSource().getGuildId(), arrayList2);
                }
            }
        }
        r2(list);
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            objArr[0] = "DirectMessageNodeRepository.fetchDirectList success:result";
            if (list != null) {
                i3 = list.size();
            }
            objArr[1] = Integer.valueOf(i3);
            QLog.d("Guild.C2C.GuildInboxC2CViewModel", 2, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p2(ri1.a aVar, List list) {
        if (!aVar.d()) {
            QLog.e("Guild.C2C.GuildInboxC2CViewModel", 1, "DirectMessageNodeRepository.fetchList error", aVar);
            return;
        }
        r2(list);
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildInboxC2CViewModel", 2, "DirectMessageNodeRepository.fetchList success:result", Integer.valueOf(list.size()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int q2(p pVar, p pVar2) {
        long j3 = pVar.f226300m;
        long j16 = pVar2.f226300m;
        if (j3 > j16) {
            return -1;
        }
        if (j3 < j16) {
            return 1;
        }
        return 0;
    }

    private void r2(List<DirectMessageNode> list) {
        if (list == null) {
            if (QLog.isColorLevel()) {
                QLog.e("Guild.C2C.GuildInboxC2CViewModel", 2, "onDirectMessageNodesUpdate is null");
            }
        } else {
            this.E.set(true);
            W1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void s2(Object obj) {
        long uptimeMillis = SystemClock.uptimeMillis();
        List<p> arrayList = new ArrayList<>();
        Collection<? extends p> collection = (List) this.f226219i.getValue();
        if (collection != null && this.K) {
            arrayList.addAll(collection);
        }
        List<p> value = this.f226220m.getValue();
        if (value != null && !value.isEmpty()) {
            arrayList.addAll(value);
        }
        Collections.sort(arrayList, R);
        x2(arrayList);
        c value2 = this.C.getValue();
        if (value2 == null) {
            value2 = new c();
        }
        value2.f226223a = arrayList;
        if (this.F && this.M) {
            value2.f226224b = true;
            this.F = false;
            w2(arrayList);
        } else {
            value2.f226224b = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Guild.C2C.GuildInboxC2CViewModel", 2, "onInboxListUpdate fromInit=" + value2.f226224b + " data size=" + arrayList.size());
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildInboxC2CViewModel", 2, "onInboxListUpdate() usage: ", Long.valueOf(uptimeMillis2), " ms");
        }
        this.C.setValue(value2);
        if (this.F) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.C2C.GuildInboxC2CViewModel", 2, "jumpToCurSelInboxItem when init");
            }
            this.D.setValue(Boolean.TRUE);
        }
    }

    private void w2(List<p> list) {
        p c16;
        if (TextUtils.isEmpty(this.L) && (c16 = p.c(list)) != null) {
            c16.E = true;
            this.L = c16.f226296e;
        }
    }

    private void x2(List<p> list) {
        boolean z16 = false;
        for (int i3 = 0; i3 < list.size(); i3++) {
            p pVar = list.get(i3);
            p a16 = pVar.a(this.L);
            if (a16 != null) {
                list.set(i3, a16);
                pVar = a16;
            }
            if (pVar.E) {
                z16 = true;
            }
        }
        if (!z16) {
            this.L = "";
            w2(list);
        }
    }

    private void y2(DirectMessageNode directMessageNode, p pVar) {
        String guildUserDisplayNameInternal = this.G.getGuildUserDisplayNameInternal(directMessageNode.getSource().getGuildId(), directMessageNode.getSource().getTinyId());
        if (TextUtils.isEmpty(guildUserDisplayNameInternal)) {
            guildUserDisplayNameInternal = directMessageNode.getSource().getRemarkName();
        }
        if (TextUtils.isEmpty(guildUserDisplayNameInternal)) {
            guildUserDisplayNameInternal = directMessageNode.getSource().getNickName();
        }
        if (TextUtils.isEmpty(guildUserDisplayNameInternal)) {
            guildUserDisplayNameInternal = QQGuildUIUtil.r(R.string.f143020ky);
        }
        pVar.f226299i = guildUserDisplayNameInternal;
    }

    public void X1(int i3, int i16, boolean z16) {
        c value = this.C.getValue();
        if (value == null) {
            return;
        }
        List<p> list = value.f226223a;
        int size = list.size();
        int min = Math.min(i16 + 20, size - 1);
        final ArrayList arrayList = new ArrayList();
        for (int max = Math.max(i3 - 20, 0); max < min; max++) {
            p pVar = list.get(max);
            Long valueOf = Long.valueOf(pVar.f226296e);
            if (pVar.f226295d == 0 && pVar.H && !this.P.contains(valueOf)) {
                arrayList.add(valueOf);
            }
        }
        if (!arrayList.isEmpty()) {
            if (z16 && this.Q.size() == arrayList.size() && this.Q.containsAll(arrayList)) {
                QLog.i("Guild.C2C.GuildInboxC2CViewModel", 1, "no need to checkGuildInfo guildIds: " + arrayList);
                return;
            }
            QLog.i("Guild.C2C.GuildInboxC2CViewModel", 1, "checkGuildInfo guildIds: " + arrayList);
            this.P.addAll(arrayList);
            this.Q.clear();
            this.Q.addAll(arrayList);
            DirectMessageNodeRepository.x(arrayList, new com.tencent.mobileqq.guild.base.repository.h() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.e
                @Override // com.tencent.mobileqq.guild.base.repository.h
                public final void a(ri1.a aVar, Object obj) {
                    GuildInboxC2CViewModel.this.o2(arrayList, aVar, (List) obj);
                }
            });
        }
    }

    public void addListener() {
        this.G.addObserver(this.J);
        DirectMessageNodeRepository.p(this);
        InboxNoticeNodeRepository.k(this);
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildInboxC2CViewModel", 2, "addListener");
        }
    }

    public void b2(int i3, String str) {
        if (!this.K) {
            if (QLog.isColorLevel()) {
                QLog.w("Guild.C2C.GuildInboxC2CViewModel", 2, "direct msg switch off");
            }
        } else {
            if (i3 == 1) {
                a2(str);
            } else {
                Z1(str);
            }
            if (QLog.isColorLevel()) {
                QLog.d("Guild.C2C.GuildInboxC2CViewModel", 2, "clearUnreadMsg inboxType: ", Integer.valueOf(i3), "inboxKey", str);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.directmessage.model.repositories.m
    public void d9(List<InboxNoticeNode> list) {
        this.f226220m.setValue(d2(list));
    }

    public p f2(int i3, String str) {
        c value = this.C.getValue();
        if (value == null) {
            return null;
        }
        for (int i16 = 0; i16 < value.f226223a.size(); i16++) {
            if (value.f226223a.get(i16).f226295d == i3 && TextUtils.equals(str, value.f226223a.get(i16).f226296e)) {
                return value.f226223a.get(i16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildInboxC2CViewModel", 2, "findItem didn't find item, size:", Integer.valueOf(value.f226223a.size()));
        }
        return null;
    }

    public MutableLiveData<c> g2() {
        return this.C;
    }

    public int h2() {
        c value = this.C.getValue();
        if (value == null) {
            return 0;
        }
        return value.f226223a.size();
    }

    public cn<Boolean> i2() {
        return this.D;
    }

    public void init() {
        this.K = ch.i0();
        this.F = true;
        this.M = false;
        m2();
        l2();
        j2();
        addListener();
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildInboxC2CViewModel", 2, "init mIsDirectMsgOn:", Boolean.valueOf(this.K));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.F = false;
        this.I.c();
    }

    @Override // com.tencent.mobileqq.guild.message.directmessage.model.repositories.l
    public void r0(List<DirectMessageNode> list) {
        r2(list);
    }

    public void removeListener() {
        this.G.deleteObserver(this.J);
        DirectMessageNodeRepository.W(this);
        InboxNoticeNodeRepository.z(this);
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildInboxC2CViewModel", 2, "removeListener");
        }
    }

    public void t2(int i3) {
        if (i3 < this.N) {
            return;
        }
        this.N = i3;
        c value = this.C.getValue();
        if (value == null) {
            return;
        }
        List<p> list = value.f226223a;
        int size = list.size() - 1;
        int min = Math.min(i3 + 6, size);
        for (int min2 = Math.min(i3 + 1, size); min2 < min; min2++) {
            p pVar = list.get(min2);
            if (pVar.f226295d == 0 && !pVar.H) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(pVar.f226298h);
                this.I.g(pVar.F, arrayList);
            }
        }
    }

    public void u2(final String str) {
        ThreadUtils.f(new Runnable() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.GuildInboxC2CViewModel.1
            @Override // java.lang.Runnable
            public void run() {
                List list = (List) GuildInboxC2CViewModel.this.f226220m.getValue();
                if (list != null && !list.isEmpty()) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < list.size()) {
                            if (TextUtils.equals(((p) list.get(i3)).f226296e, str)) {
                                break;
                            } else {
                                i3++;
                            }
                        } else {
                            i3 = -1;
                            break;
                        }
                    }
                    if (i3 != -1) {
                        list.remove(i3);
                        GuildInboxC2CViewModel.this.f226220m.postValue(list);
                        InboxNoticeNodeRepository.A(str, false);
                    }
                }
            }
        });
    }

    public void v2(String str) {
        this.L = str;
        s2(null);
    }
}

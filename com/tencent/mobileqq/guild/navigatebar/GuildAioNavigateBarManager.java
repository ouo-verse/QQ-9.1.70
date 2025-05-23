package com.tencent.mobileqq.guild.navigatebar;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.data.BaseMessageNavigateInfo;
import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import com.tencent.mobileqq.guild.data.ChannelMsgEventCollection;
import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService;
import com.tencent.mobileqq.guild.message.k;
import com.tencent.mobileqq.troop.data.d;
import com.tencent.mobileqq.troop.navigatebar.NavConstants;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildAioNavigateBarManager extends com.tencent.mobileqq.troop.navigatebar.b {
    public HashMap<String, Long> C;

    /* renamed from: e, reason: collision with root package name */
    final String f230911e;

    /* renamed from: f, reason: collision with root package name */
    private final ConcurrentHashMap<String, List<GuildMessageNavigateInfo>> f230912f;

    /* renamed from: h, reason: collision with root package name */
    volatile boolean f230913h;

    /* renamed from: i, reason: collision with root package name */
    private final k f230914i;

    /* renamed from: m, reason: collision with root package name */
    IGuardInterface f230915m;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class c implements Comparator<GuildMessageNavigateInfo> {
        protected c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(GuildMessageNavigateInfo guildMessageNavigateInfo, GuildMessageNavigateInfo guildMessageNavigateInfo2) {
            return Long.compare(guildMessageNavigateInfo2.msgseq, guildMessageNavigateInfo.msgseq);
        }
    }

    public GuildAioNavigateBarManager() {
        this.f230911e = "GuildAio.NavigateBar.Manager";
        this.f230912f = new ConcurrentHashMap<>();
        this.f230913h = false;
        this.f230914i = new a();
        this.f230915m = new b();
        this.C = new HashMap<>();
    }

    static void h(List<GuildMessageNavigateInfo> list, GuildMessageNavigateInfo guildMessageNavigateInfo) {
        for (GuildMessageNavigateInfo guildMessageNavigateInfo2 : list) {
            if (p(guildMessageNavigateInfo2, guildMessageNavigateInfo)) {
                long j3 = guildMessageNavigateInfo.msgseq;
                if (j3 != guildMessageNavigateInfo.shmsgseq) {
                    guildMessageNavigateInfo2.msgseq = j3;
                    return;
                }
                return;
            }
        }
        list.add(guildMessageNavigateInfo);
    }

    private List<Long> i(String str, int i3, boolean z16) {
        List<GuildMessageNavigateInfo> k3 = k(str, i3);
        ArrayList arrayList = new ArrayList();
        if (bl.b(k3)) {
            return arrayList;
        }
        StringBuilder sb5 = new StringBuilder(", channelId=");
        sb5.append(str);
        sb5.append(", type=");
        sb5.append(i3);
        sb5.append(", returnUniSeq=");
        sb5.append(z16);
        sb5.append(", seq=");
        for (GuildMessageNavigateInfo guildMessageNavigateInfo : k3) {
            if (z16) {
                arrayList.add(Long.valueOf(guildMessageNavigateInfo.msgseq));
                sb5.append(guildMessageNavigateInfo.msgseq);
                sb5.append(",");
            } else {
                arrayList.add(Long.valueOf(guildMessageNavigateInfo.shmsgseq));
                sb5.append(guildMessageNavigateInfo.shmsgseq);
                sb5.append(",");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("GuildAio.NavigateBar.Manager", 2, " getMultiNavigateMsgSeqList:" + sb5.toString() + " size=" + arrayList.size());
        }
        return arrayList;
    }

    private synchronized void l() {
        HashMap<String, List<ChannelMsgEvent>> allChannelMsgEventList = ((IGuildMessageBoxDataService) this.f297981d.getRuntimeService(IGuildMessageBoxDataService.class, "")).getAllChannelMsgEventList();
        if (allChannelMsgEventList == null) {
            QLog.d("GuildAio.NavigateBar.Manager", 1, "[initGuildAtAllNavigateInfo] msgEventMap == null");
            return;
        }
        for (Map.Entry<String, List<ChannelMsgEvent>> entry : allChannelMsgEventList.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && entry.getValue() != null) {
                for (ChannelMsgEvent channelMsgEvent : entry.getValue()) {
                    if (channelMsgEvent != null && channelMsgEvent.eventType == 100) {
                        GuildMessageNavigateInfo guildMessageNavigateInfo = new GuildMessageNavigateInfo();
                        String key = entry.getKey();
                        guildMessageNavigateInfo.channelId = key;
                        guildMessageNavigateInfo.type = 14;
                        long j3 = channelMsgEvent.msgSeq;
                        guildMessageNavigateInfo.shmsgseq = j3;
                        guildMessageNavigateInfo.msgseq = j3;
                        List<GuildMessageNavigateInfo> list = this.f230912f.get(key);
                        if (list == null) {
                            list = new ArrayList<>();
                            this.f230912f.put(guildMessageNavigateInfo.channelId, list);
                        }
                        if (!list.contains(guildMessageNavigateInfo)) {
                            list.add(guildMessageNavigateInfo);
                            q(guildMessageNavigateInfo.channelId, guildMessageNavigateInfo.type, guildMessageNavigateInfo.shmsgseq, 0L, "", list.size());
                        }
                    }
                }
                t(entry.getKey());
                QLog.d("GuildAio.NavigateBar.Manager", 1, "[initGuildAtAllNavigateInfo] channel: " + entry.getKey() + ",  eventList size=" + entry.getValue().size());
            }
        }
    }

    private synchronized void m() {
        HashMap<String, List<ChannelMsgEvent>> allChannelMsgEventList = ((IGuildMessageBoxDataService) this.f297981d.getRuntimeService(IGuildMessageBoxDataService.class, "")).getAllChannelMsgEventList();
        if (allChannelMsgEventList == null) {
            QLog.d("GuildAio.NavigateBar.Manager", 1, "[initGuildAtMeNavigateInfo] msgEventMap == null");
            return;
        }
        for (Map.Entry<String, List<ChannelMsgEvent>> entry : allChannelMsgEventList.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && entry.getValue() != null) {
                for (ChannelMsgEvent channelMsgEvent : entry.getValue()) {
                    if (channelMsgEvent != null && channelMsgEvent.eventType == 1) {
                        GuildMessageNavigateInfo guildMessageNavigateInfo = new GuildMessageNavigateInfo();
                        String key = entry.getKey();
                        guildMessageNavigateInfo.channelId = key;
                        guildMessageNavigateInfo.type = 23;
                        long j3 = channelMsgEvent.msgSeq;
                        guildMessageNavigateInfo.shmsgseq = j3;
                        guildMessageNavigateInfo.msgseq = j3;
                        List<GuildMessageNavigateInfo> list = this.f230912f.get(key);
                        if (list == null) {
                            list = new ArrayList<>();
                            this.f230912f.put(guildMessageNavigateInfo.channelId, list);
                        }
                        if (!list.contains(guildMessageNavigateInfo)) {
                            list.add(guildMessageNavigateInfo);
                            q(guildMessageNavigateInfo.channelId, guildMessageNavigateInfo.type, guildMessageNavigateInfo.shmsgseq, 0L, "", list.size());
                        }
                    }
                }
                t(entry.getKey());
                QLog.d("GuildAio.NavigateBar.Manager", 1, "[initGuildAtMeNavigateInfo] channel: " + entry.getKey() + ",  eventList size=" + entry.getValue().size());
            }
        }
    }

    static boolean p(GuildMessageNavigateInfo guildMessageNavigateInfo, GuildMessageNavigateInfo guildMessageNavigateInfo2) {
        String str = guildMessageNavigateInfo.channelId;
        if (str == null || !str.equals(guildMessageNavigateInfo2.channelId) || guildMessageNavigateInfo.type != guildMessageNavigateInfo2.type) {
            return false;
        }
        long j3 = guildMessageNavigateInfo.msgseq;
        if (j3 == 0 || j3 != guildMessageNavigateInfo2.msgseq) {
            long j16 = guildMessageNavigateInfo.shmsgseq;
            if (j16 == 0 || j16 != guildMessageNavigateInfo2.shmsgseq) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.b
    public synchronized void b(String str, int i3) {
        QLog.d("GuildAio.NavigateBar.Manager", 1, "clearGuildMsgNavigateInfo: channelId = " + str + ", type = " + i3);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        n();
        if (this.f230912f.containsKey(str)) {
            List<GuildMessageNavigateInfo> list = this.f230912f.get(str);
            if (bl.b(list)) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                GuildMessageNavigateInfo guildMessageNavigateInfo = list.get(size);
                if (i3 == guildMessageNavigateInfo.type || i3 == 0) {
                    if (guildMessageNavigateInfo.status == BaseMessageNavigateInfo.STATUS_ADD) {
                        list.remove(size);
                    } else {
                        guildMessageNavigateInfo.status = BaseMessageNavigateInfo.STATUS_DELETE;
                    }
                }
            }
            if (list.isEmpty()) {
                this.f230912f.remove(str);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.b
    public synchronized List<Long> c(String str, int i3) {
        return i(str, i3, true);
    }

    void e() {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.registerCallBack(this.f230915m);
        }
    }

    protected synchronized String j() {
        StringBuilder sb5;
        sb5 = new StringBuilder();
        sb5.append("mapGuildNavigateInfo: size = ");
        sb5.append(this.f230912f.size());
        sb5.append(" {");
        int i3 = 0;
        for (Map.Entry<String, List<GuildMessageNavigateInfo>> entry : this.f230912f.entrySet()) {
            List<GuildMessageNavigateInfo> value = entry.getValue();
            sb5.append(entry.getKey());
            sb5.append(": size = ");
            sb5.append(value == null ? 0 : value.size());
            sb5.append("->{ ");
            if (value != null) {
                Iterator<GuildMessageNavigateInfo> it = value.iterator();
                int i16 = 0;
                while (it.hasNext()) {
                    sb5.append(it.next().toString());
                    sb5.append(" ");
                    i16++;
                    if (i16 >= 10) {
                        break;
                    }
                }
            }
            sb5.append(" } ");
            i3++;
            if (i3 >= 20) {
                break;
            }
        }
        sb5.append(" }");
        return sb5.toString();
    }

    public synchronized List<GuildMessageNavigateInfo> k(String str, int i3) {
        n();
        List<GuildMessageNavigateInfo> list = this.f230912f.get(str);
        if (bl.b(list)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i16 = 0; i16 < size; i16++) {
            GuildMessageNavigateInfo guildMessageNavigateInfo = list.get(i16);
            if (guildMessageNavigateInfo.status != BaseMessageNavigateInfo.STATUS_DELETE && (guildMessageNavigateInfo.type == i3 || i3 == 0)) {
                arrayList.add(guildMessageNavigateInfo);
            }
        }
        return arrayList;
    }

    public synchronized void n() {
        if (this.f230913h) {
            return;
        }
        this.f230913h = true;
        if (QLog.isColorLevel()) {
            QLog.d("GuildAio.NavigateBar.Manager", 2, "initGuildMessageNavigateInfo before, " + j());
        }
        m();
        l();
        if (QLog.isColorLevel()) {
            QLog.d("GuildAio.NavigateBar.Manager", 2, "initGuildMessageNavigateInfo after, " + j());
        }
        this.f297981d.addObserver(this.f230914i);
    }

    protected void o() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.navigatebar.GuildAioNavigateBarManager.3
            @Override // java.lang.Runnable
            public void run() {
                GuildAioNavigateBarManager.this.n();
            }
        }, 32, null, true);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        this.f297981d.removeObserver(this.f230914i);
        r();
    }

    void q(String str, int i3, long j3, long j16, String str2, int i16) {
        QLog.d("GuildAio.NavigateBar.Manager", 1, "addGuildMsgNavigateInfo, channel-id=" + str + ", navType=" + i3 + ", shMsgSeq=" + j3 + ", uniSeq=" + j16 + ", summary=" + str2 + ", infoCount=" + i16);
    }

    void r() {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.unregisterCallback(this.f230915m);
        }
    }

    public synchronized boolean s(String str, long j3) {
        List<GuildMessageNavigateInfo> list = this.f230912f.get(str);
        boolean z16 = false;
        if (list == null) {
            return false;
        }
        for (GuildMessageNavigateInfo guildMessageNavigateInfo : list) {
            if (guildMessageNavigateInfo.shmsgseq == j3 || guildMessageNavigateInfo.msgseq == j3) {
                int i3 = guildMessageNavigateInfo.status;
                int i16 = BaseMessageNavigateInfo.STATUS_DELETE;
                if (i3 != i16) {
                    guildMessageNavigateInfo.status = i16;
                    z16 = true;
                }
            }
        }
        return z16;
    }

    protected synchronized void t(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List<GuildMessageNavigateInfo> list = this.f230912f.get(str);
        if (list == null) {
            return;
        }
        Collections.sort(list, new c());
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends k {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.message.k
        protected void a(boolean z16, List<ChannelMsgEventCollection> list) {
            List<ChannelMsgEvent> list2;
            if (!z16 || list == null || list.isEmpty()) {
                return;
            }
            for (ChannelMsgEventCollection channelMsgEventCollection : list) {
                if (channelMsgEventCollection != null && (list2 = channelMsgEventCollection.msgEventList) != null) {
                    for (ChannelMsgEvent channelMsgEvent : list2) {
                        if (channelMsgEvent != null && channelMsgEvent.eventType == 100) {
                            GuildAioNavigateBarManager guildAioNavigateBarManager = GuildAioNavigateBarManager.this;
                            String str = channelMsgEvent.channelId;
                            long j3 = channelMsgEvent.msgSeq;
                            guildAioNavigateBarManager.f(str, 14, j3, j3, "", null);
                        }
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.message.k
        protected void b(boolean z16, List<ChannelMsgEventCollection> list) {
            List<ChannelMsgEvent> list2;
            if (!z16 || list == null || list.isEmpty()) {
                return;
            }
            for (ChannelMsgEventCollection channelMsgEventCollection : list) {
                if (channelMsgEventCollection != null && (list2 = channelMsgEventCollection.msgEventList) != null) {
                    for (ChannelMsgEvent channelMsgEvent : list2) {
                        if (channelMsgEvent != null && channelMsgEvent.eventType == 1) {
                            GuildAioNavigateBarManager guildAioNavigateBarManager = GuildAioNavigateBarManager.this;
                            String str = channelMsgEvent.channelId;
                            long j3 = channelMsgEvent.msgSeq;
                            guildAioNavigateBarManager.f(str, 23, j3, j3, "", null);
                        }
                    }
                }
            }
        }
    }

    private void g(String str, int i3, long j3, GuildMessageNavigateInfo guildMessageNavigateInfo, List<GuildMessageNavigateInfo> list) {
        GuildMessageNavigateInfo guildMessageNavigateInfo2;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                guildMessageNavigateInfo2 = null;
                break;
            } else {
                if (i3 == list.get(size).type) {
                    guildMessageNavigateInfo2 = list.get(size);
                    break;
                }
                size--;
            }
        }
        int a16 = NavConstants.a(i3);
        if (i3 != 1 && guildMessageNavigateInfo2 != null && guildMessageNavigateInfo2.status != BaseMessageNavigateInfo.STATUS_DELETE && !d.f(NavConstants.a(guildMessageNavigateInfo2.type), guildMessageNavigateInfo2.shmsgseq, a16, j3)) {
            QLog.d("GuildAio.NavigateBar.Manager", 1, "addGuildMsgNavigateInfo, but do not need update, shMsgSeq = " + j3);
            return;
        }
        if (size >= 0) {
            list.remove(size);
        }
        d(guildMessageNavigateInfo2, guildMessageNavigateInfo, i3);
        list.add(guildMessageNavigateInfo);
        QLog.d("GuildAio.NavigateBar.Manager", 1, "addGuildMsgNavigateInfo  guildMessageNavigateInfoList = " + list);
        t(str);
    }

    public synchronized void f(String str, int i3, long j3, long j16, String str2, Object obj) {
        if (i3 <= 0) {
            return;
        }
        GuildMessageNavigateInfo guildMessageNavigateInfo = new GuildMessageNavigateInfo();
        guildMessageNavigateInfo.type = i3;
        guildMessageNavigateInfo.channelId = str;
        guildMessageNavigateInfo.shmsgseq = j3;
        guildMessageNavigateInfo.msgseq = j16;
        guildMessageNavigateInfo.summary = str2;
        guildMessageNavigateInfo.extObj = obj;
        List<GuildMessageNavigateInfo> list = this.f230912f.get(str);
        if (bl.b(list)) {
            guildMessageNavigateInfo.status = BaseMessageNavigateInfo.STATUS_ADD;
            ArrayList arrayList = new ArrayList();
            arrayList.add(guildMessageNavigateInfo);
            this.f230912f.put(str, arrayList);
            q(str, i3, j3, j16, str2, arrayList.size());
            return;
        }
        if (!com.tencent.mobileqq.guild.navigatebar.b.a()) {
            g(str, i3, j3, guildMessageNavigateInfo, list);
        } else {
            guildMessageNavigateInfo.status = BaseMessageNavigateInfo.STATUS_ADD;
            h(list, guildMessageNavigateInfo);
            t(str);
        }
        q(str, i3, j3, j16, str2, list.size());
    }

    public GuildAioNavigateBarManager(AppInterface appInterface) {
        super(appInterface);
        this.f230911e = "GuildAio.NavigateBar.Manager";
        this.f230912f = new ConcurrentHashMap<>();
        this.f230913h = false;
        this.f230914i = new a();
        this.f230915m = new b();
        this.C = new HashMap<>();
        o();
        e();
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements IGuardInterface {
        b() {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean z16) {
        }
    }
}

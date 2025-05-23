package com.tencent.guild.aio.chosen.data;

import android.os.Looper;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeSet;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GuildChosenMsgListDataManager extends Observable {

    /* renamed from: a, reason: collision with root package name */
    private final Contact f110091a;

    /* renamed from: b, reason: collision with root package name */
    private final String f110092b;

    /* renamed from: c, reason: collision with root package name */
    private final String f110093c;

    /* renamed from: e, reason: collision with root package name */
    private final BaseQQAppInterface f110095e = (BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();

    /* renamed from: d, reason: collision with root package name */
    private final TreeSet<MsgRecord> f110094d = new TreeSet<>(new a());

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public enum RefreshType {
        REFRESH_JUMP_BOTTOM,
        REFRESH_NONE
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Comparator<MsgRecord> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MsgRecord msgRecord, MsgRecord msgRecord2) {
            return (int) (msgRecord.getMsgSeq() - msgRecord2.getMsgSeq());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements IMsgOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RefreshType f110098a;

        b(RefreshType refreshType) {
            this.f110098a = refreshType;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
        public void onResult(int i3, String str, ArrayList<MsgRecord> arrayList) {
            if (i3 == 0) {
                GuildChosenMsgListDataManager.this.e(arrayList);
                GuildChosenMsgListDataManager.this.j(new c(true, this.f110098a, new ArrayList(GuildChosenMsgListDataManager.this.f110094d)));
            } else {
                QLog.d("GuildChosenMsgListDataManager", 1, "getDispersionRoamMsg fail or empty " + str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f110100a;

        /* renamed from: b, reason: collision with root package name */
        private final RefreshType f110101b;

        /* renamed from: c, reason: collision with root package name */
        private final List<MsgRecord> f110102c;

        public c(boolean z16, RefreshType refreshType, List<MsgRecord> list) {
            this.f110100a = z16;
            this.f110101b = refreshType;
            this.f110102c = list;
        }

        public boolean a() {
            return this.f110100a;
        }

        public List<MsgRecord> b() {
            return this.f110102c;
        }

        public RefreshType c() {
            return this.f110101b;
        }
    }

    public GuildChosenMsgListDataManager(Contact contact) {
        this.f110091a = contact;
        this.f110092b = contact.getGuildId();
        this.f110093c = contact.getPeerUid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<? extends MsgRecord> list) {
        this.f110094d.clear();
        this.f110094d.addAll(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final Object obj) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            setChanged();
            notifyObservers(obj);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.guild.aio.chosen.data.GuildChosenMsgListDataManager.3
                @Override // java.lang.Runnable
                public void run() {
                    GuildChosenMsgListDataManager.this.setChanged();
                    GuildChosenMsgListDataManager.this.notifyObservers(obj);
                }
            });
        }
    }

    public void f(Observer observer) {
        addObserver(observer);
    }

    public void g() {
        this.f110094d.clear();
    }

    public void h(ArrayList<Long> arrayList, RefreshType refreshType) {
        if (arrayList.isEmpty()) {
            this.f110094d.clear();
            j(new c(true, refreshType, new ArrayList(this.f110094d)));
        }
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgsBySeqs(this.f110091a, arrayList, new b(refreshType));
    }

    public void i(Observer observer) {
        deleteObserver(observer);
    }

    public void k(RefreshType refreshType) {
        IGProChannelInfo channelInfo = ((IGPSService) this.f110095e.getRuntimeService(IGPSService.class)).getChannelInfo(this.f110093c);
        if (channelInfo == null) {
            QLog.d("GuildChosenMsgListDataManager", 2, "queryTopMsgForChannel, IGProChannelInfo==null, return null");
            return;
        }
        ArrayList<IGProTopMsg> topMsgList = channelInfo.getTopMsgList();
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < topMsgList.size(); i3++) {
            arrayList.add(Long.valueOf(topMsgList.get(i3).getTopMsgSeq()));
        }
        h(arrayList, refreshType);
    }
}

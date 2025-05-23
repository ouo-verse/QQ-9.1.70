package com.tencent.mobileqq.guild.message;

import android.os.Looper;
import android.util.Pair;
import bu1.a;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.List;
import tencent.im.group_pro_proto.eventflow.msg_event$MsgEvent;
import tencent.im.group_pro_proto.synclogic.synclogic$ChannelMsgRsp;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildEventFlowObserver implements BusinessObserver {
    public static final int C;
    public static final int D;
    public static final int E;

    /* renamed from: d, reason: collision with root package name */
    private static int f230085d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f230086e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static final int f230087f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f230088h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f230089i;

    /* renamed from: m, reason: collision with root package name */
    public static final int f230090m;

    static {
        int i3 = 0 + 1;
        int i16 = i3 + 1;
        f230087f = i3;
        int i17 = i16 + 1;
        f230088h = i16;
        int i18 = i17 + 1;
        f230089i = i17;
        int i19 = i18 + 1;
        f230090m = i18;
        int i26 = i19 + 1;
        C = i19;
        int i27 = i26 + 1;
        D = i26;
        f230085d = i27 + 1;
        E = i27;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i3, boolean z16, Object obj) {
        q(i3, z16, obj);
        o(i3, z16, obj);
        n(i3, z16, obj);
        k(i3, z16, obj);
        l(i3, z16, obj);
        m(i3, z16, obj);
        r(i3, z16, obj);
        p(i3, z16, obj);
    }

    private void k(int i3, boolean z16, Object obj) {
        String str;
        List<MessageRecord> list;
        synclogic$ChannelMsgRsp synclogic_channelmsgrsp;
        ToServiceMsg toServiceMsg;
        if (i3 != f230089i) {
            return;
        }
        ToServiceMsg toServiceMsg2 = null;
        List<MessageRecord> list2 = null;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 4) {
                str = (String) objArr[0];
                Object obj2 = objArr[1];
                if (obj2 instanceof ToServiceMsg) {
                    toServiceMsg = (ToServiceMsg) obj2;
                } else {
                    toServiceMsg = null;
                }
                Object obj3 = objArr[2];
                if (obj3 instanceof synclogic$ChannelMsgRsp) {
                    synclogic_channelmsgrsp = (synclogic$ChannelMsgRsp) obj3;
                } else {
                    synclogic_channelmsgrsp = null;
                }
                Object obj4 = objArr[3];
                if (obj4 instanceof List) {
                    list2 = (List) obj4;
                }
                list = list2;
                toServiceMsg2 = toServiceMsg;
                b(str, toServiceMsg2, synclogic_channelmsgrsp, list);
            }
        }
        str = "";
        list = null;
        synclogic_channelmsgrsp = null;
        b(str, toServiceMsg2, synclogic_channelmsgrsp, list);
    }

    private void l(int i3, boolean z16, Object obj) {
        if (i3 != f230090m) {
            return;
        }
        d();
    }

    private void m(int i3, boolean z16, Object obj) {
        String str;
        if (i3 != C) {
            return;
        }
        List<msg_event$MsgEvent> list = null;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 2) {
                str = (String) objArr[0];
                Object obj2 = objArr[1];
                if (obj2 instanceof List) {
                    list = (List) obj2;
                }
                e(str, list);
            }
        }
        str = "";
        e(str, list);
    }

    private void n(int i3, boolean z16, Object obj) {
        String str;
        if (i3 != f230088h) {
            return;
        }
        boolean z17 = false;
        List<Pair<Long, a.b>> list = null;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 3) {
                str = (String) objArr[0];
                Object obj2 = objArr[1];
                if (obj2 instanceof List) {
                    list = (List) obj2;
                }
                z17 = ((Boolean) objArr[2]).booleanValue();
                f(str, list, z17);
            }
        }
        str = "";
        f(str, list, z17);
    }

    private void o(int i3, boolean z16, Object obj) {
        String str;
        if (i3 != f230087f) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 1) {
                str = (String) objArr[0];
                h(str);
            }
        }
        str = "";
        h(str);
    }

    private void p(int i3, boolean z16, Object obj) {
        String str;
        if (i3 != E) {
            return;
        }
        MessageRecord messageRecord = null;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 2) {
                str = (String) objArr[0];
                Object obj2 = objArr[1];
                if (obj2 instanceof MessageRecord) {
                    messageRecord = (MessageRecord) obj2;
                }
                c(str, messageRecord);
            }
        }
        str = "";
        c(str, messageRecord);
    }

    private void q(int i3, boolean z16, Object obj) {
        String str;
        if (i3 != f230086e) {
            return;
        }
        boolean z17 = false;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 2) {
                z17 = ((Boolean) objArr[0]).booleanValue();
                str = (String) objArr[1];
                i(z16, z17, str);
            }
        }
        str = "";
        i(z16, z17, str);
    }

    private void r(int i3, boolean z16, Object obj) {
        String str;
        if (i3 != D) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 1) {
                str = (String) objArr[0];
                g(str);
            }
        }
        str = "";
        g(str);
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(final int i3, final boolean z16, final Object obj) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            j(i3, z16, obj);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.GuildEventFlowObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    GuildEventFlowObserver.this.j(i3, z16, obj);
                }
            });
        }
    }

    protected void d() {
    }

    protected void g(String str) {
    }

    protected void h(String str) {
    }

    protected void c(String str, MessageRecord messageRecord) {
    }

    protected void e(String str, List<msg_event$MsgEvent> list) {
    }

    protected void f(String str, List<Pair<Long, a.b>> list, boolean z16) {
    }

    protected void i(boolean z16, boolean z17, String str) {
    }

    protected void b(String str, ToServiceMsg toServiceMsg, synclogic$ChannelMsgRsp synclogic_channelmsgrsp, List<MessageRecord> list) {
    }
}

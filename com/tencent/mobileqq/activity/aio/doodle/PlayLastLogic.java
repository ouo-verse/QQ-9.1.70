package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes10.dex */
public class PlayLastLogic {

    /* renamed from: q, reason: collision with root package name */
    private static String f178487q = "PlayLastLogic";

    /* renamed from: r, reason: collision with root package name */
    private static PlayLastLogic f178488r;

    /* renamed from: i, reason: collision with root package name */
    private Runnable f178497i;

    /* renamed from: n, reason: collision with root package name */
    private WeakReference<BaseDoodleMsgLayout> f178502n;

    /* renamed from: o, reason: collision with root package name */
    private int f178503o;

    /* renamed from: p, reason: collision with root package name */
    private int f178504p;

    /* renamed from: a, reason: collision with root package name */
    private long f178489a = -1;

    /* renamed from: b, reason: collision with root package name */
    private long f178490b = -1;

    /* renamed from: c, reason: collision with root package name */
    private boolean f178491c = false;

    /* renamed from: d, reason: collision with root package name */
    private long f178492d = -1;

    /* renamed from: e, reason: collision with root package name */
    private int f178493e = -1;

    /* renamed from: f, reason: collision with root package name */
    private int f178494f = 0;

    /* renamed from: g, reason: collision with root package name */
    private Map<Integer, i> f178495g = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    public int f178496h = 0;

    /* renamed from: j, reason: collision with root package name */
    private Handler f178498j = null;

    /* renamed from: k, reason: collision with root package name */
    private int f178499k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f178500l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f178501m = 0;

    PlayLastLogic() {
    }

    private int b(int i3, boolean z16) {
        WeakReference<BaseDoodleMsgLayout> weakReference;
        BaseDoodleMsgLayout baseDoodleMsgLayout;
        if (QLog.isColorLevel()) {
            QLog.d(f178487q, 2, "checkPlayable: bRealPlay:" + z16);
        }
        i iVar = this.f178495g.get(Integer.valueOf(i3));
        if (iVar != null && (weakReference = iVar.f178550d) != null && (baseDoodleMsgLayout = weakReference.get()) != null) {
            if (baseDoodleMsgLayout.getGlobalVisibleRect(new Rect()) && r3.height() > baseDoodleMsgLayout.getHeight() * 0.9d) {
                if (!baseDoodleMsgLayout.isPlaying() && this.f178489a != iVar.f178549c && baseDoodleMsgLayout.isDataValid()) {
                    if (z16) {
                        j(baseDoodleMsgLayout, false);
                        if (iVar.f178549c == this.f178492d) {
                            this.f178491c = true;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f178487q, 2, "checkPlayable: lastID:" + this.f178490b + "lasUniID" + this.f178492d + " lastMsgPlayed:" + this.f178491c + " playedID:" + this.f178489a);
                    }
                    return 1;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f178487q, 2, "checkPlayable: can not play:" + iVar.f178547a + "uniID:" + iVar.f178549c + " mPlayedID:" + this.f178489a);
                }
                if (!baseDoodleMsgLayout.isPlaying()) {
                    return 2;
                }
                return 3;
            }
            if (QLog.isColorLevel()) {
                QLog.d(f178487q, 2, "checkPlayable: invisible MsgID:" + iVar.f178547a + "uniID:" + iVar.f178549c);
            }
        }
        return 0;
    }

    private void c(int i3, int i16) {
        int i17;
        if (this.f178495g.size() == 0) {
            return;
        }
        Iterator<Map.Entry<Integer, i>> it = this.f178495g.entrySet().iterator();
        while (it.hasNext()) {
            i value = it.next().getValue();
            if (value == null || (i17 = value.f178548b) < i3 || i17 > i16) {
                it.remove();
            }
        }
    }

    public static void d() {
        synchronized (PlayLastLogic.class) {
            PlayLastLogic playLastLogic = f178488r;
            if (playLastLogic != null) {
                playLastLogic.m();
                f178488r = null;
            }
        }
    }

    public static long e(ChatMessage chatMessage) {
        int i3 = chatMessage.istroop;
        if (i3 != 1 && i3 != 3000) {
            return chatMessage.time;
        }
        return chatMessage.shmsgseq;
    }

    public static long f(ChatMessage chatMessage) {
        return chatMessage.uniseq;
    }

    public static PlayLastLogic g() {
        synchronized (PlayLastLogic.class) {
            if (f178488r == null) {
                f178488r = new PlayLastLogic();
            }
        }
        return f178488r;
    }

    private void i(boolean z16) {
        int i3;
        WeakReference<BaseDoodleMsgLayout> weakReference;
        BaseDoodleMsgLayout baseDoodleMsgLayout;
        if (this.f178495g.size() == 0) {
            return;
        }
        for (i iVar : this.f178495g.values()) {
            if (iVar != null && (i3 = iVar.f178548b) >= this.f178499k && i3 <= this.f178500l && (weakReference = iVar.f178550d) != null && (baseDoodleMsgLayout = weakReference.get()) != null) {
                baseDoodleMsgLayout.c(z16);
            }
        }
    }

    private void k(boolean z16, int i3) {
        i iVar;
        WeakReference<BaseDoodleMsgLayout> weakReference;
        BaseDoodleMsgLayout baseDoodleMsgLayout;
        BaseDoodleMsgLayout baseDoodleMsgLayout2;
        if (z16) {
            if (!this.f178491c && this.f178490b >= 0) {
                this.f178491c = true;
                for (i iVar2 : this.f178495g.values()) {
                    if (iVar2.f178549c == this.f178492d) {
                        WeakReference<BaseDoodleMsgLayout> weakReference2 = iVar2.f178550d;
                        if (weakReference2 != null && (baseDoodleMsgLayout2 = weakReference2.get()) != null) {
                            baseDoodleMsgLayout2.stop();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            return;
        }
        for (int i16 = this.f178500l; i16 >= this.f178499k; i16--) {
            if (i16 != i3 && (iVar = this.f178495g.get(Integer.valueOf(i16))) != null && ((iVar.f178547a > this.f178490b || iVar.f178549c == this.f178492d) && (weakReference = iVar.f178550d) != null && (baseDoodleMsgLayout = weakReference.get()) != null)) {
                baseDoodleMsgLayout.stop();
            }
        }
    }

    private void n(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(f178487q, 2, "restartPlayTimer:" + i3);
        }
        if (this.f178498j == null) {
            this.f178498j = new Handler(Looper.getMainLooper());
        }
        if (this.f178497i != null) {
            this.f178498j.removeCallbacksAndMessages(null);
        }
        if (i3 < 0) {
            return;
        }
        if (this.f178497i == null) {
            this.f178497i = new Runnable() { // from class: com.tencent.mobileqq.activity.aio.doodle.PlayLastLogic.1
                @Override // java.lang.Runnable
                public void run() {
                    PlayLastLogic playLastLogic = PlayLastLogic.this;
                    if (playLastLogic.f178496h == 0) {
                        playLastLogic.r(true);
                    }
                }
            };
        }
        this.f178498j.postDelayed(this.f178497i, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
    
        if (r4 != 3) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005d, code lost:
    
        if (r4 != 3) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r(boolean z16) {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d(f178487q, 2, "strategy2 :" + z16 + " StartPos:" + this.f178499k + "EndPos:" + this.f178500l);
        }
        int i16 = -1;
        if (this.f178501m == 0) {
            i3 = this.f178500l;
            while (true) {
                if (i3 < this.f178499k) {
                    break;
                }
                int b16 = b(i3, z16);
                if (b16 > 0) {
                    if (b16 != 1) {
                    }
                } else {
                    i3--;
                }
            }
        } else {
            i3 = this.f178499k;
            while (true) {
                if (i3 > this.f178500l) {
                    break;
                }
                int b17 = b(i3, z16);
                if (b17 > 0) {
                    if (b17 != 1) {
                    }
                } else {
                    i3++;
                }
            }
            i16 = i3;
        }
        k(false, i16);
    }

    public boolean h(long j3, long j16) {
        if (j16 > this.f178490b && j3 != this.f178492d) {
            return true;
        }
        if (this.f178492d == j3 && !this.f178491c) {
            return true;
        }
        return false;
    }

    public void j(BaseDoodleMsgLayout baseDoodleMsgLayout, boolean z16) {
        BaseDoodleMsgLayout baseDoodleMsgLayout2;
        if (baseDoodleMsgLayout == null) {
            return;
        }
        WeakReference<BaseDoodleMsgLayout> weakReference = this.f178502n;
        if (weakReference != null && (baseDoodleMsgLayout2 = weakReference.get()) != null && baseDoodleMsgLayout2.isPlaying()) {
            if (z16 && baseDoodleMsgLayout2 == baseDoodleMsgLayout) {
                baseDoodleMsgLayout2.stop();
                return;
            } else {
                if (!z16 && baseDoodleMsgLayout2 == baseDoodleMsgLayout) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f178487q, 2, "playLayout: same layout, ans is playing, return:");
                        return;
                    }
                    return;
                }
                baseDoodleMsgLayout2.stop();
            }
        }
        this.f178502n = new WeakReference<>(baseDoodleMsgLayout);
        baseDoodleMsgLayout.play();
        Iterator<i> it = this.f178495g.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i next = it.next();
            WeakReference<BaseDoodleMsgLayout> weakReference2 = next.f178550d;
            if (weakReference2 != null && weakReference2.get() == baseDoodleMsgLayout) {
                this.f178489a = next.f178549c;
                if (QLog.isColorLevel()) {
                    QLog.d(f178487q, 2, "playLayout: lastPlayedID:" + this.f178489a);
                }
            }
        }
        if (z16) {
            n(-1);
        }
    }

    public void l(long j3, long j16, int i3, BaseDoodleMsgLayout baseDoodleMsgLayout) {
        boolean z16;
        BaseDoodleMsgLayout baseDoodleMsgLayout2;
        if (QLog.isColorLevel()) {
            QLog.d(f178487q, 2, "registLayout:" + j16 + " pos:" + i3 + " uniid:" + j3);
        }
        this.f178495g.put(Integer.valueOf(i3), new i(j3, j16, i3, baseDoodleMsgLayout));
        if (this.f178496h != 0) {
            baseDoodleMsgLayout2 = baseDoodleMsgLayout;
            z16 = true;
        } else {
            z16 = false;
            baseDoodleMsgLayout2 = baseDoodleMsgLayout;
        }
        baseDoodleMsgLayout2.c(z16);
        if (h(j3, j16)) {
            if (QLog.isColorLevel()) {
                QLog.d(f178487q, 2, "registLayout: is new msg, lastID:" + this.f178490b + " uniID:" + j3);
            }
            if (this.f178496h == 0) {
                n(1000);
                return;
            } else {
                this.f178491c = true;
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(f178487q, 2, "registLayout: is old msg, lastID:" + this.f178490b + " uniID:" + j3 + " lastMsgPlayed:" + this.f178491c + " playedID:" + this.f178489a);
        }
    }

    public void m() {
        this.f178492d = -1L;
        this.f178490b = -1L;
        this.f178489a = -1L;
        this.f178495g.clear();
        this.f178491c = false;
        this.f178493e = 0;
        this.f178496h = 0;
        if (this.f178497i != null) {
            new Handler(Looper.getMainLooper()).removeCallbacksAndMessages(null);
        }
        this.f178497i = null;
        this.f178498j = null;
    }

    public void o(List<ChatMessage> list) {
        if (list != null && list.size() != 0) {
            long e16 = e(list.get(list.size() - 1));
            long f16 = f(list.get(list.size() - 1));
            if (e16 > this.f178490b && this.f178492d != f16) {
                k(true, -1);
                if (this.f178490b < 0) {
                    this.f178491c = list.get(list.size() - 1).isread;
                } else {
                    this.f178491c = false;
                }
                this.f178490b = e16;
                this.f178492d = f16;
                if (QLog.isColorLevel()) {
                    QLog.d(f178487q, 2, "setLastMsgID: a new msg");
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(f178487q, 2, "setLastMsgID:" + this.f178490b + " :" + this.f178492d);
            }
        }
    }

    public void p(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        if (i3 == 0 && i17 > 0) {
            i16--;
        }
        if (i3 + i16 == i19 && i18 > 0) {
            i16--;
        }
        int i29 = i3 - i17;
        if (this.f178504p == i28 && this.f178503o == i27) {
            int i36 = this.f178493e;
            if (i29 > i36) {
                this.f178501m = 0;
            } else if (i29 < i36) {
                this.f178501m = 1;
            } else {
                int i37 = this.f178494f;
                if (i26 < i37) {
                    this.f178501m = 0;
                } else if (i26 > i37) {
                    this.f178501m = 1;
                }
            }
            this.f178494f = i26;
            this.f178493e = i29;
            if (i29 < 0) {
                i29 = 0;
            }
            this.f178499k = i29;
            int i38 = (i16 + i29) - 1;
            this.f178500l = i38;
            if (i38 < i29) {
                this.f178500l = i29;
                return;
            }
            return;
        }
        this.f178504p = i28;
        this.f178503o = i27;
        this.f178501m = 0;
        this.f178494f = i26;
        this.f178493e = i29;
        if (i29 < 0) {
            i29 = 0;
        }
        this.f178499k = i29;
        int i39 = (i16 + i29) - 1;
        this.f178500l = i39;
        if (i39 < i29) {
            this.f178500l = i29;
        }
    }

    public void q(int i3) {
        this.f178496h = i3;
        if (i3 == 0) {
            n(1000);
            c(this.f178499k, this.f178500l);
            i(false);
            r(false);
            return;
        }
        n(-1);
        i(true);
    }
}

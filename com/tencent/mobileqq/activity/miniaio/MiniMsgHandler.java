package com.tencent.mobileqq.activity.miniaio;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MiniMsgHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<Integer, ArrayList<RecentBaseData>> f183453d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f183454e;

    /* renamed from: f, reason: collision with root package name */
    Comparator<RecentBaseData> f183455f;

    /* renamed from: h, reason: collision with root package name */
    private QQAppInterface f183456h;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.miniaio.MiniMsgHandler$2, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f183457d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f183458e;
        final /* synthetic */ MiniMsgHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            RecentBaseData b16 = com.tencent.mobileqq.activity.recent.g.c().b(com.tencent.mobileqq.activity.recent.g.d(this.f183457d, this.f183458e));
            if (b16 == null) {
                return;
            }
            b16.update(this.this$0.f183456h, BaseApplication.getContext());
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(b16) { // from class: com.tencent.mobileqq.activity.miniaio.MiniMsgHandler.2.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ RecentBaseData f183459d;

                {
                    this.f183459d = b16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) b16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        AnonymousClass2.this.getClass();
                        throw null;
                    }
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Comparator<RecentBaseData> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MiniMsgHandler.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(RecentBaseData recentBaseData, RecentBaseData recentBaseData2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) recentBaseData, (Object) recentBaseData2)).intValue();
            }
            if ((recentBaseData instanceof RecentUserBaseData) && (recentBaseData2 instanceof RecentUserBaseData)) {
                RecentUser recentUser = ((RecentUserBaseData) recentBaseData).mUser;
                long max = Math.max(recentUser.lastmsgtime, recentUser.lastmsgdrafttime);
                RecentUser recentUser2 = ((RecentUserBaseData) recentBaseData2).mUser;
                long max2 = Math.max(recentUser2.lastmsgtime, recentUser2.lastmsgdrafttime);
                if (max > max2) {
                    return -1;
                }
                if (max < max2) {
                    return 1;
                }
            }
            return 0;
        }
    }

    public MiniMsgHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f183453d = new ConcurrentHashMap<>();
        this.f183455f = new a();
        this.f183456h = qQAppInterface;
        this.f183454e = new Handler(ThreadManagerV2.getRecentThreadLooper());
    }

    private boolean H2(int i3) {
        if (i3 == -2050) {
            return true;
        }
        return false;
    }

    public void E2(Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) num);
        } else {
            this.f183453d.remove(num);
        }
    }

    public void F2(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if ((i3 == 1 || i3 == 0 || i3 == 3000 || i3 == 10014) && !H2(i16)) {
            h.v().B();
            if (!TextUtils.isEmpty(str)) {
                h.v().A(str, i3);
            }
        }
    }

    public void G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            h.v().B();
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroy();
        Handler handler = this.f183454e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, toServiceMsg, fromServiceMsg, obj);
        }
    }
}

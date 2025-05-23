package com.tencent.mobileqq.flashchat;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatPanel;
import com.tencent.mobileqq.panel.RichTextPanelRecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FlashChatTextEffectView extends RichTextPanelRecyclerView implements Handler.Callback {
    static IPatchRedirector $redirector_;
    private static final int[] D;
    public HashMap<Integer, Long> C;

    /* renamed from: e, reason: collision with root package name */
    GridLayoutManager f209829e;

    /* renamed from: f, reason: collision with root package name */
    WeakReference<a61.c> f209830f;

    /* renamed from: h, reason: collision with root package name */
    com.tencent.mobileqq.flashchat.b f209831h;

    /* renamed from: i, reason: collision with root package name */
    public MqqHandler f209832i;

    /* renamed from: m, reason: collision with root package name */
    ArrayList<FlashChatPanel.b> f209833m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends com.tencent.mobileqq.flashchat.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlashChatTextEffectView.this);
            }
        }

        @Override // com.tencent.mobileqq.flashchat.b
        public void c(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            super.c(z16, bundle);
            if (z16) {
                FlashChatTextEffectView.this.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        d f209837d;

        /* renamed from: e, reason: collision with root package name */
        int f209838e;

        /* renamed from: f, reason: collision with root package name */
        MessageForArkFlashChat f209839f;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                d dVar = this.f209837d;
                if (dVar != null) {
                    dVar.t0(view, getPosition(), this.f209838e);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view)).booleanValue();
            } else {
                d dVar = this.f209837d;
                if (dVar != null) {
                    dVar.zb(view, getPosition(), this.f209838e);
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71970);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            D = new int[]{10000, 12000, 7000, 8000, 8000};
        }
    }

    public FlashChatTextEffectView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f209831h = new a();
        this.f209832i = null;
        this.f209833m = new ArrayList<>();
        this.C = new HashMap<>();
    }

    private static void e(b bVar) {
        MessageForArkFlashChat messageForArkFlashChat;
        if (bVar != null && (messageForArkFlashChat = bVar.f209839f) != null) {
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(messageForArkFlashChat.ark_app_message.appName, new Runnable() { // from class: com.tencent.mobileqq.flashchat.FlashChatTextEffectView.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    MessageForArkFlashChat messageForArkFlashChat2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    b bVar2 = b.this;
                    if (bVar2 != null && (messageForArkFlashChat2 = bVar2.f209839f) != null) {
                        messageForArkFlashChat2.stopAnim();
                        b.this.f209839f.playAnim();
                    }
                }
            });
        }
    }

    private static void o(b bVar) {
        MessageForArkFlashChat messageForArkFlashChat;
        if (bVar != null && (messageForArkFlashChat = bVar.f209839f) != null) {
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(messageForArkFlashChat.ark_app_message.appName, new Runnable() { // from class: com.tencent.mobileqq.flashchat.FlashChatTextEffectView.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    MessageForArkFlashChat messageForArkFlashChat2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    b bVar2 = b.this;
                    if (bVar2 != null && (messageForArkFlashChat2 = bVar2.f209839f) != null) {
                        messageForArkFlashChat2.stopAnim();
                    }
                }
            });
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        MqqHandler mqqHandler = this.f209832i;
        if (mqqHandler != null) {
            mqqHandler.removeCallbacksAndMessages(null);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    public FlashChatPanel.b f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (FlashChatPanel.b) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        if (i3 >= this.f209833m.size()) {
            return null;
        }
        return this.f209833m.get(i3);
    }

    public FlashChatItem g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (FlashChatItem) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        try {
            throw null;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        throw null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        b bVar;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) message)).booleanValue();
        }
        Object obj = message.obj;
        if (obj instanceof b) {
            bVar = (b) obj;
        } else {
            bVar = null;
        }
        int i3 = message.what;
        boolean z16 = true;
        if (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) {
            int[] iArr = D;
            if (i3 < iArr.length) {
                j3 = iArr[i3];
            } else {
                j3 = 7000;
            }
            Long l3 = this.C.get(Integer.valueOf(i3));
            long uptimeMillis = SystemClock.uptimeMillis();
            if (l3 == null) {
                this.C.put(Integer.valueOf(message.what), Long.valueOf(SystemClock.uptimeMillis()));
            } else if (uptimeMillis - l3.longValue() < j3) {
                z16 = false;
            }
            if (z16) {
                this.C.put(Integer.valueOf(message.what), Long.valueOf(uptimeMillis));
                if (QLog.isColorLevel()) {
                    QLog.i("shinkencai", 2, "plays position:" + message.what);
                }
                if (bVar != null) {
                    e(bVar);
                }
                Message obtain = Message.obtain();
                obtain.what = message.what;
                obtain.obj = message.obj;
                this.f209832i.sendMessageDelayed(obtain, j3);
            }
        }
        return false;
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        WeakReference<a61.c> weakReference = this.f209830f;
        if (weakReference != null && weakReference.get() != null) {
            ArrayList<FlashChatItem> l3 = ((FlashChatManager) this.f209830f.get().f25577b.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).l();
            this.f209833m.clear();
            Iterator<FlashChatItem> it = l3.iterator();
            while (it.hasNext()) {
                FlashChatItem next = it.next();
                FlashChatPanel.b bVar = new FlashChatPanel.b();
                int i3 = next.f209775id;
                bVar.f209823d = i3;
                if (i3 != -100000) {
                    bVar.f209821b = HardCodeUtil.qqStr(R.string.ml7);
                    bVar.f209820a = next.name;
                    bVar.f209822c = false;
                    bVar.f209824e = next;
                    this.f209833m.add(bVar);
                }
            }
            throw null;
        }
        QLog.w("FlashChatTextEffectView", 1, "BaseChatPie released");
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        for (int i3 = 0; i3 <= this.f209829e.getChildCount(); i3++) {
            View childAt = this.f209829e.getChildAt(i3);
            if (childAt != null) {
                RecyclerView.ViewHolder childViewHolder = getChildViewHolder(childAt);
                if (childViewHolder instanceof b) {
                    o((b) childViewHolder);
                }
            }
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    public void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        throw null;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        AppRuntime runtime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, i3);
            return;
        }
        super.onVisibilityChanged(view, i3);
        WeakReference<a61.c> weakReference = this.f209830f;
        if (weakReference != null && weakReference.get() != null) {
            runtime = this.f209830f.get().f25577b;
        } else {
            runtime = BaseApplicationImpl.getApplication().getRuntime();
        }
        if (i3 == 0) {
            runtime.registObserver(this.f209831h);
        } else {
            runtime.unRegistObserver(this.f209831h);
        }
    }
}

package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.adapter.g;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ChatHistoryStructMsgView extends ChatHistoryViewBase implements AbsListView.OnScrollListener, Handler.Callback {
    static IPatchRedirector $redirector_;
    private static int U;
    com.tencent.mobileqq.adapter.g C;
    boolean D;
    View.OnClickListener E;
    View.OnClickListener F;
    String G;
    int H;
    public String I;
    ArrayList<Object> J;
    private RelativeLayout K;
    private TextView L;
    boolean M;
    long N;
    long P;
    long Q;
    int R;
    View S;
    protected final MqqHandler T;

    /* renamed from: f, reason: collision with root package name */
    final String f175318f;

    /* renamed from: h, reason: collision with root package name */
    QQAppInterface f175319h;

    /* renamed from: i, reason: collision with root package name */
    Context f175320i;

    /* renamed from: m, reason: collision with root package name */
    XListView f175321m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryStructMsgView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!(view.getTag() instanceof String)) {
                ChatMessage chatMessage = (ChatMessage) ((g.a) view.getTag()).f187183f;
                if (ChatHistoryStructMsgView.this.g()) {
                    if (ChatHistoryStructMsgView.this.f175325e.S2(chatMessage)) {
                        ChatHistoryStructMsgView.this.f175325e.U2(chatMessage);
                    } else if (!ChatHistoryStructMsgView.this.f175325e.R2()) {
                        ChatHistoryStructMsgView.this.f175325e.J2(chatMessage);
                    }
                }
                ChatHistoryStructMsgView.this.C.notifyDataSetChanged();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66777);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            U = 30;
        }
    }

    public ChatHistoryStructMsgView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f175318f = "ChatHistory_Struct";
        this.D = false;
        this.J = new ArrayList<>();
        this.M = false;
        this.N = Long.MAX_VALUE;
        this.P = Long.MAX_VALUE;
        this.Q = Long.MAX_VALUE;
        this.R = 3;
        this.T = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    }

    private void n() {
        if (this.F != null) {
            return;
        }
        this.F = new a();
    }

    @Override // com.tencent.mobileqq.activity.ChatHistoryViewBase
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.D = false;
            this.C.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.activity.ChatHistoryViewBase
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.D = true;
            this.C.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.activity.ChatHistoryViewBase
    public View e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.K;
    }

    @Override // com.tencent.mobileqq.activity.ChatHistoryViewBase
    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.D;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 1) {
            if (this.J.isEmpty()) {
                this.L.setVisibility(0);
                this.f175321m.setVisibility(4);
            } else {
                this.L.setVisibility(8);
                this.S.setVisibility(8);
                this.f175321m.setVisibility(0);
                this.C.f187175f = (ArrayList) this.J.clone();
            }
            this.C.notifyDataSetChanged();
        }
        return false;
    }

    public void l(Intent intent, QQAppInterface qQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, intent, qQAppInterface, context);
            return;
        }
        this.f175319h = qQAppInterface;
        this.f175320i = context;
        this.G = intent.getStringExtra("uin");
        this.H = intent.getIntExtra("uintype", 0);
        this.I = intent.getStringExtra("uinname");
        n();
        RelativeLayout relativeLayout = (RelativeLayout) View.inflate(this.f175320i, R.layout.bzk, null);
        this.K = relativeLayout;
        TextView textView = (TextView) relativeLayout.findViewById(R.id.bwv);
        this.L = textView;
        textView.setVisibility(0);
        XListView xListView = (XListView) this.K.findViewById(R.id.j4g);
        this.f175321m = xListView;
        xListView.setCacheColorHint(0);
        this.f175321m.setOnScrollListener(this);
        View inflate = View.inflate(this.f175320i, R.layout.bzj, null);
        this.S = inflate;
        inflate.setVisibility(0);
        this.f175321m.addFooterView(this.S);
        o(true);
        com.tencent.mobileqq.adapter.g gVar = new com.tencent.mobileqq.adapter.g(this.f175320i, (ArrayList) this.J.clone(), this.F, this.E, this);
        this.C = gVar;
        this.f175321m.setAdapter((ListAdapter) gVar);
    }

    public void m(List<ChatMessage> list) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
            return;
        }
        if (list != null && !list.isEmpty()) {
            this.J.removeAll(list);
            Iterator<Object> it = this.J.iterator();
            loop0: while (true) {
                obj = null;
                int i3 = 0;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof String) {
                        if (i3 == 0) {
                            obj = next;
                        }
                        i3++;
                        if (i3 == 2) {
                            break loop0;
                        }
                    }
                }
            }
            if (obj != null) {
                this.J.remove(obj);
            }
            this.T.sendEmptyMessage(1);
        }
    }

    public void o(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            ThreadManagerV2.post(new Runnable(z16) { // from class: com.tencent.mobileqq.activity.ChatHistoryStructMsgView.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f175322d;

                {
                    this.f175322d = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ChatHistoryStructMsgView.this, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    List<MessageRecord> O;
                    AbsStructMsg absStructMsg;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f175322d) {
                        QQMessageFacade messageFacade = ChatHistoryStructMsgView.this.f175319h.getMessageFacade();
                        ChatHistoryStructMsgView chatHistoryStructMsgView = ChatHistoryStructMsgView.this;
                        O = messageFacade.E(chatHistoryStructMsgView.G, chatHistoryStructMsgView.H, new int[]{MessageRecord.MSG_TYPE_STRUCT_MSG}, ChatHistoryStructMsgView.U);
                    } else if (com.tencent.imcore.message.ao.u(ChatHistoryStructMsgView.this.H)) {
                        ChatHistoryStructMsgView chatHistoryStructMsgView2 = ChatHistoryStructMsgView.this;
                        chatHistoryStructMsgView2.P--;
                        QQMessageFacade messageFacade2 = chatHistoryStructMsgView2.f175319h.getMessageFacade();
                        ChatHistoryStructMsgView chatHistoryStructMsgView3 = ChatHistoryStructMsgView.this;
                        O = messageFacade2.O(chatHistoryStructMsgView3.G, chatHistoryStructMsgView3.H, chatHistoryStructMsgView3.N, chatHistoryStructMsgView3.R, chatHistoryStructMsgView3.P, new int[]{MessageRecord.MSG_TYPE_STRUCT_MSG}, ChatHistoryStructMsgView.U);
                    } else {
                        QQMessageFacade messageFacade3 = ChatHistoryStructMsgView.this.f175319h.getMessageFacade();
                        ChatHistoryStructMsgView chatHistoryStructMsgView4 = ChatHistoryStructMsgView.this;
                        O = messageFacade3.O(chatHistoryStructMsgView4.G, chatHistoryStructMsgView4.H, chatHistoryStructMsgView4.N, chatHistoryStructMsgView4.R, chatHistoryStructMsgView4.Q, new int[]{MessageRecord.MSG_TYPE_STRUCT_MSG}, ChatHistoryStructMsgView.U);
                    }
                    if (O != null && O.size() < ChatHistoryStructMsgView.U) {
                        ChatHistoryStructMsgView.this.M = true;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    if (O != null && !O.isEmpty()) {
                        for (int size = O.size() - 1; size >= 0; size--) {
                            MessageRecord messageRecord = O.get(size);
                            if (com.tencent.mobileqq.adapter.g.b(messageRecord)) {
                                long j3 = messageRecord.shmsgseq;
                                ChatHistoryStructMsgView chatHistoryStructMsgView5 = ChatHistoryStructMsgView.this;
                                if (j3 < chatHistoryStructMsgView5.P) {
                                    chatHistoryStructMsgView5.P = j3;
                                }
                                int i3 = messageRecord.versionCode;
                                if (i3 < chatHistoryStructMsgView5.R) {
                                    chatHistoryStructMsgView5.R = i3;
                                }
                                if (messageRecord.getId() > 0) {
                                    long id5 = messageRecord.getId();
                                    ChatHistoryStructMsgView chatHistoryStructMsgView6 = ChatHistoryStructMsgView.this;
                                    if (id5 < chatHistoryStructMsgView6.N) {
                                        chatHistoryStructMsgView6.N = messageRecord.getId();
                                    }
                                }
                                long j16 = messageRecord.time;
                                ChatHistoryStructMsgView chatHistoryStructMsgView7 = ChatHistoryStructMsgView.this;
                                if (j16 < chatHistoryStructMsgView7.Q) {
                                    chatHistoryStructMsgView7.Q = j16;
                                }
                                if ((messageRecord instanceof MessageForStructing) && (absStructMsg = ((MessageForStructing) messageRecord).structingMsg) != null && (absStructMsg instanceof AbsShareMsg)) {
                                    AbsShareMsg absShareMsg = (AbsShareMsg) absStructMsg;
                                    if (j16 >= 1548460800 && com.tencent.mobileqq.filemanager.data.e.g(absShareMsg.mMsgUrl)) {
                                    }
                                }
                                String c16 = com.tencent.mobileqq.filemanager.util.ap.c(messageRecord.time * 1000);
                                if (!linkedHashMap.containsKey(c16)) {
                                    linkedHashMap.put(c16, new ArrayList());
                                }
                                ((List) linkedHashMap.get(c16)).add(messageRecord);
                            }
                        }
                    }
                    ChatHistoryStructMsgView chatHistoryStructMsgView8 = ChatHistoryStructMsgView.this;
                    if (chatHistoryStructMsgView8.J == null) {
                        chatHistoryStructMsgView8.J = new ArrayList<>();
                    }
                    for (String str : linkedHashMap.keySet()) {
                        if (!ChatHistoryStructMsgView.this.J.contains(str)) {
                            ChatHistoryStructMsgView.this.J.add(str);
                        }
                        ChatHistoryStructMsgView.this.J.addAll((Collection) linkedHashMap.get(str));
                    }
                    ChatHistoryStructMsgView.this.T.sendEmptyMessage(1);
                    if (QLog.isColorLevel()) {
                        QLog.d("ChatHistoryStruct", 2, "initEntity, size: " + ChatHistoryStructMsgView.this.J.size());
                    }
                }
            }, 10, null, true);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) absListView, i3);
        } else if (i3 == 0 && !this.M) {
            this.S.setVisibility(0);
            o(false);
            this.C.notifyDataSetChanged();
        }
    }
}

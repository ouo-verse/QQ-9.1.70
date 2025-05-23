package com.tencent.mobileqq.newfriend.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.contact.connections.c;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.guild.api.IGuildAddQQFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.msg.f;
import com.tencent.mobileqq.newfriend.msg.g;
import com.tencent.mobileqq.newfriend.msg.j;
import com.tencent.mobileqq.newfriend.msg.k;
import com.tencent.mobileqq.newfriend.msg.o;
import com.tencent.mobileqq.newfriend.msg.p;
import com.tencent.mobileqq.newfriend.msg.q;
import com.tencent.mobileqq.newfriend.msg.r;
import com.tencent.mobileqq.newfriend.ui.builder.ContactMatchBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBindContactGuideBuilderV3;
import com.tencent.mobileqq.newfriend.ui.builder.PhoneContactAddBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.QIMFollowerAddBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.QIMNotifyAddFriendBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.c;
import com.tencent.mobileqq.newfriend.ui.builder.d;
import com.tencent.mobileqq.newfriend.ui.builder.e;
import com.tencent.mobileqq.newfriend.ui.builder.h;
import com.tencent.mobileqq.newfriend.ui.builder.i;
import com.tencent.mobileqq.newfriend.ui.builder.k;
import com.tencent.mobileqq.newfriend.ui.builder.l;
import com.tencent.mobileqq.newfriend.ui.builder.m;
import com.tencent.mobileqq.newfriend.ui.builder.n;
import com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView;
import com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi;
import com.tencent.mobileqq.pymk.api.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.richstatus.e;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.widget.SwipListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tencent.mobileim.structmsg.structmsg$StructMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class SystemMsgListAdapter extends com.tencent.mobileqq.newfriend.ui.adapter.a implements SwipListView.SwipListListener, nb2.a, DecodeTaskCompletionListener, e, Handler.Callback {
    static IPatchRedirector $redirector_;
    public Context C;
    public List<d> D;
    public Hashtable<String, Bitmap> E;
    public NewFriendServiceImpl F;
    public FlingHandler G;
    public XListView H;
    public Handler I;
    public ConcurrentLinkedQueue<Long> J;
    public c K;
    public MutableLiveData<Boolean> L;
    private final com.tencent.mobileqq.pymk.c M;
    private CopyOnWriteArrayList<MayKnowRecommend> N;
    private final b P;
    private final com.tencent.mobileqq.pymk.api.a Q;
    protected Runnable R;

    /* renamed from: f, reason: collision with root package name */
    public int f254091f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f254092h;

    /* renamed from: i, reason: collision with root package name */
    public IFaceDecoder f254093i;

    /* renamed from: m, reason: collision with root package name */
    public AppInterface f254094m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends com.tencent.mobileqq.pymk.api.d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SystemMsgListAdapter.this);
            }
        }

        @Override // com.tencent.mobileqq.pymk.api.d, com.tencent.mobileqq.pymk.api.a
        public void d(@NotNull List<? extends MayKnowRecommend> list, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, list, Boolean.valueOf(z16));
                return;
            }
            SystemMsgListAdapter.this.N.clear();
            SystemMsgListAdapter.this.N.addAll(list);
            SystemMsgListAdapter.this.h(0L);
            QLog.d("SystemMsgListAdapter", 2, "onDataChange recommendData", cq.w(list.toString(), 2));
        }
    }

    public SystemMsgListAdapter(Context context, AppInterface appInterface, XListView xListView, SystemMsgListView systemMsgListView, int i3, FlingHandler flingHandler) {
        super(systemMsgListView);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, xListView, systemMsgListView, Integer.valueOf(i3), flingHandler);
            return;
        }
        this.f254092h = true;
        this.D = new ArrayList();
        this.E = new Hashtable<>();
        this.I = null;
        this.J = new ConcurrentLinkedQueue<>();
        this.L = new MutableLiveData<>();
        com.tencent.mobileqq.pymk.c cVar = new com.tencent.mobileqq.pymk.c("pg_kl_new_friends");
        this.M = cVar;
        this.N = new CopyOnWriteArrayList<>();
        this.P = ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).getPYMKMediaUtil();
        a aVar = new a();
        this.Q = aVar;
        this.R = new Runnable() { // from class: com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SystemMsgListAdapter.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    SystemMsgListAdapter.this.v();
                }
            }
        };
        this.K = new c();
        this.f254091f = i3;
        this.C = context;
        this.f254094m = appInterface;
        this.H = xListView;
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(appInterface);
        this.f254093i = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        this.F = (NewFriendServiceImpl) this.f254094m.getRuntimeService(INewFriendService.class, "");
        this.I = new Handler(Looper.getMainLooper(), this);
        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).addListener(this, this.f254094m);
        cVar.l(aVar);
        cVar.s(false, new ArrayList<>());
        this.F.addListener(this);
        this.G = flingHandler;
        this.F.reSetLastSysMsgTotalCount(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.P.b(this.N, new Function0<Unit>() { // from class: com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SystemMsgListAdapter.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                MobileQQ.sMobileQQ.peekAppRuntime().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter.3.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            SystemMsgListAdapter.this.notifyDataSetChanged();
                        }
                    }
                });
                return null;
            }
        });
    }

    private boolean r(com.tencent.mobileqq.newfriend.msg.c cVar) {
        MessageForSystemMsg messageForSystemMsg;
        structmsg$StructMsg structmsg_structmsg;
        if (cVar == null || (messageForSystemMsg = cVar.f254022d) == null || (structmsg_structmsg = messageForSystemMsg.structMsg) == null || structmsg_structmsg.f436065msg == null) {
            return false;
        }
        boolean isFromGuild = ((IGuildAddQQFriendApi) QRoute.api(IGuildAddQQFriendApi.class)).isFromGuild(cVar.f254022d.structMsg.f436065msg.src_id.get(), cVar.f254022d.structMsg.f436065msg.sub_src_id.get());
        int i3 = cVar.f254022d.structMsg.f436065msg.sub_type.get();
        if (!isFromGuild) {
            return false;
        }
        if (i3 != 13 && i3 != 6 && i3 != 5 && i3 != 4 && i3 != 0) {
            return false;
        }
        return true;
    }

    private void u(k kVar) {
        ArrayList<com.tencent.mobileqq.activity.contact.connections.a> arrayList;
        if (kVar != null && (arrayList = kVar.f254039d) != null && arrayList.size() != 0) {
            ArrayList<com.tencent.mobileqq.activity.contact.connections.a> arrayList2 = kVar.f254039d;
            SystemMsgListView systemMsgListView = this.f254101e;
            if (systemMsgListView != null) {
                systemMsgListView.y(arrayList2, a());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("SystemMsgListAdapter", 2, "refreshHead null");
        }
    }

    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        if (this.H != null) {
            if (QLog.isColorLevel()) {
                QLog.d("SystemMsgListAdapter", 2, "onResume firstVisible: " + this.H.getFirstVisiblePosition() + " lastvisible: " + this.H.getLastVisiblePosition());
            }
            this.H.removeCallbacks(this.R);
            this.H.postDelayed(this.R, 1000L);
        }
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        if (this.H != null) {
            if (QLog.isColorLevel()) {
                QLog.d("SystemMsgListAdapter", 2, "stopVisibleExpose firstVisible: " + this.H.getFirstVisiblePosition() + " lastvisible: " + this.H.getLastVisiblePosition());
            }
            this.H.removeCallbacks(this.R);
        }
        this.P.onPause();
    }

    @Override // com.tencent.mobileqq.newfriend.ui.adapter.a
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
        }
        c cVar = this.K;
        if (cVar != null) {
            return cVar.f181262a;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.newfriend.ui.adapter.a
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        c cVar = this.K;
        if (cVar != null) {
            return cVar.f181263b;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.newfriend.ui.adapter.a
    public Bitmap c(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Bitmap) iPatchRedirector.redirect((short) 20, (Object) this, i3, (Object) str);
        }
        Bitmap bitmapFromCache = this.f254093i.getBitmapFromCache(i3, str);
        if (bitmapFromCache != null) {
            return bitmapFromCache;
        }
        if (!this.f254093i.isPausing()) {
            this.f254093i.requestDecodeFace(str, i3, true, (byte) 0);
        }
        return BaseImageUtil.getDefaultFaceBitmap();
    }

    @Override // com.tencent.mobileqq.newfriend.ui.adapter.a
    public IFaceDecoder d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (IFaceDecoder) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.f254093i;
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        this.H.setOnScrollListener(null);
        this.F.reSetLastSysMsgTotalCount(0);
        this.F.removeListener(this);
        this.M.r();
        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).removeListener(this, this.f254094m);
        Handler handler = this.I;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.D.clear();
        this.f254093i.setDecodeTaskCompletionListener(null);
        this.f254093i.destory();
    }

    @Override // com.tencent.mobileqq.newfriend.ui.adapter.a
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        int firstVisiblePosition = this.H.getFirstVisiblePosition();
        if (firstVisiblePosition == 0) {
            return 0;
        }
        return firstVisiblePosition - 1;
    }

    @Override // com.tencent.mobileqq.newfriend.ui.adapter.a
    public void f(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SystemMsgListAdapter", 2, "onConnectionTabSelected tabId : " + i3 + ", position =" + i16);
        }
        z(i3, i16);
        SystemMsgListView systemMsgListView = this.f254101e;
        if (systemMsgListView != null) {
            systemMsgListView.setStickHeadSelection(i16);
        }
        h(0L);
    }

    @Override // com.tencent.mobileqq.newfriend.ui.adapter.a
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            h(400L);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.D.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        if (i3 >= 0 && i3 < this.D.size()) {
            return this.D.get(i3);
        }
        return new Object();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View h16;
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            view2 = view;
            h16 = (View) iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            h16 = ((d) getItem(i3)).h(i3, view);
            view2 = h16;
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return h16;
    }

    @Override // com.tencent.mobileqq.newfriend.ui.adapter.a
    public void h(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
            return;
        }
        Handler handler = this.I;
        if (handler != null) {
            handler.removeMessages(1);
            handler.sendEmptyMessageDelayed(1, j3);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 1) {
            t(a());
            return false;
        }
        if (i3 == 2) {
            notifyDataSetChanged();
            return false;
        }
        if (i3 == 3) {
            u((k) message.obj);
            return false;
        }
        return false;
    }

    @Override // com.tencent.widget.SwipListView.SwipListListener
    public void hideMenuPop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.adapter.a
    public void i(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) dVar);
            return;
        }
        List<d> list = this.D;
        if (list != null && list.size() > 0) {
            this.D.remove(dVar);
        }
    }

    @Override // com.tencent.widget.SwipListView.SwipListListener
    public void interceptTouchEvent(boolean z16) {
        TopGestureLayout topGestureLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
            return;
        }
        FlingHandler flingHandler = this.G;
        if (flingHandler != null && (flingHandler instanceof FlingGestureHandler) && (topGestureLayout = ((FlingGestureHandler) flingHandler).mTopLayout) != null) {
            topGestureLayout.setInterceptTouchFlag(!z16);
        }
    }

    public void m(com.tencent.mobileqq.newfriend.ui.builder.a aVar) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) aVar);
            return;
        }
        String str = aVar.N;
        if (str != null && str.length() > 0 && (bitmap5 = this.E.get(aVar.N)) != null) {
            aVar.I.setImageBitmap(bitmap5);
        }
        String str2 = aVar.P;
        if (str2 != null && str2.length() > 0 && (bitmap4 = this.E.get(aVar.P)) != null) {
            aVar.J.setImageBitmap(bitmap4);
        }
        String str3 = aVar.Q;
        if (str3 != null && str3.length() > 0 && (bitmap3 = this.E.get(aVar.Q)) != null) {
            aVar.K.setImageBitmap(bitmap3);
        }
        String str4 = aVar.R;
        if (str4 != null && str4.length() > 0 && (bitmap2 = this.E.get(aVar.R)) != null) {
            aVar.L.setImageBitmap(bitmap2);
        }
        String str5 = aVar.S;
        if (str5 != null && str5.length() > 0 && (bitmap = this.E.get(aVar.S)) != null) {
            aVar.M.setImageBitmap(bitmap);
        }
    }

    public void n(long j3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, j3);
            return;
        }
        if (j3 == 0) {
            return;
        }
        if (this.J.size() > 0) {
            Iterator<Long> it = this.J.iterator();
            while (it.hasNext()) {
                Long next = it.next();
                if (next != null && next.longValue() == j3) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (z16) {
            g();
        }
        if (QLog.isColorLevel()) {
            QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "checkIfNeedUpdate discussUin: %d needRefresh: %b", Long.valueOf(j3), Boolean.valueOf(z16)));
        }
    }

    @Override // com.tencent.widget.XBaseAdapter, android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            super.notifyDataSetChanged();
        }
    }

    @Override // nb2.a
    public void onContactCountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            g();
        }
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        d.b bVar;
        String str2;
        Bitmap bitmap2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (bitmap != null) {
            this.E.put(str, bitmap);
        }
        if (i3 <= 0) {
            int childCount = this.H.getChildCount();
            for (int i17 = 0; i17 < childCount; i17++) {
                Object tag = this.H.getChildAt(i17).getTag();
                if (tag != null) {
                    if (tag instanceof com.tencent.mobileqq.newfriend.ui.builder.a) {
                        m((com.tencent.mobileqq.newfriend.ui.builder.a) tag);
                    } else if (!(tag instanceof k.a) && !(tag instanceof i.a) && !(tag instanceof e.a) && !(tag instanceof l.h) && !(tag instanceof h.b) && (str2 = (bVar = (d.b) tag).D) != null && str2.length() > 0 && (bitmap2 = this.E.get(bVar.D)) != null) {
                        bVar.f254114d.setImageBitmap(bitmap2);
                    }
                }
            }
            this.E.clear();
        }
    }

    @Override // com.tencent.mobileqq.richstatus.e
    public void onGetIcon(int i3, int i16, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), bitmap);
        } else if (i16 == ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getSizeSmall() && bitmap != null) {
            notifyDataSetChanged();
        }
    }

    @Override // nb2.a
    public void onMayKnowStatesChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SystemMsgListAdapter", 2, "onMayKnowStatesChanged");
        }
        Handler handler = this.I;
        if (handler != null) {
            handler.removeMessages(2);
            handler.sendEmptyMessageDelayed(2, 200L);
            handler.removeMessages(1);
            handler.sendEmptyMessageDelayed(1, 2000L);
        }
    }

    @Override // nb2.a
    public void onUnreadChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            g();
        }
    }

    public c p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (c) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.K;
    }

    public d q(com.tencent.mobileqq.newfriend.msg.i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (d) iPatchRedirector.redirect((short) 7, (Object) this, (Object) iVar);
        }
        if (iVar instanceof com.tencent.mobileqq.newfriend.msg.c) {
            n nVar = new n(this.C, this.f254094m, this, iVar);
            if (r((com.tencent.mobileqq.newfriend.msg.c) iVar)) {
                return null;
            }
            long j3 = nVar.F;
            if (j3 != 0) {
                this.J.add(Long.valueOf(j3));
            }
            return nVar;
        }
        if (iVar instanceof com.tencent.mobileqq.newfriend.msg.l) {
            return new com.tencent.mobileqq.newfriend.ui.builder.k(this.C, this.f254094m, this, iVar);
        }
        if (iVar instanceof j) {
            return new i(this.C, this.f254094m, this, iVar);
        }
        if (iVar instanceof com.tencent.mobileqq.newfriend.msg.e) {
            return new com.tencent.mobileqq.newfriend.ui.builder.e(this.C, this.f254094m, this, iVar);
        }
        if (iVar instanceof f) {
            return new NewFriendBindContactGuideBuilderV3(this.C, this.f254094m, this, iVar);
        }
        if (iVar instanceof p) {
            return new PhoneContactAddBuilder(this.C, this.f254094m, this, iVar);
        }
        if (iVar instanceof q) {
            return new QIMFollowerAddBuilder(this.C, this.f254094m, this, iVar);
        }
        if (iVar instanceof r) {
            return new QIMNotifyAddFriendBuilder(this.C, this.f254094m, this, iVar);
        }
        if (iVar instanceof o) {
            return new m(this.C, this.f254094m, this, iVar);
        }
        if (iVar instanceof com.tencent.mobileqq.newfriend.msg.m) {
            return new l(this.C, this.f254094m, this, iVar);
        }
        if (iVar instanceof com.tencent.mobileqq.newfriend.msg.h) {
            return new h(this.C, this.f254094m, this, iVar);
        }
        if (!(iVar instanceof g)) {
            return null;
        }
        return new com.tencent.mobileqq.newfriend.ui.builder.g(this.C, this.f254094m, this, iVar, this.P);
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            this.f254093i.cancelPendingRequests();
            this.f254093i.pause();
        }
    }

    public void t(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SystemMsgListAdapter.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    SystemMsgListAdapter systemMsgListAdapter = SystemMsgListAdapter.this;
                    NewFriendServiceImpl newFriendServiceImpl = systemMsgListAdapter.F;
                    if (newFriendServiceImpl != null && systemMsgListAdapter.f254094m != null && systemMsgListAdapter.L != null && systemMsgListAdapter.f254101e != null) {
                        newFriendServiceImpl.loadNewFriendMsgData(true, systemMsgListAdapter.N);
                        ArrayList<com.tencent.mobileqq.newfriend.msg.i> mixedNewFriendDatas = SystemMsgListAdapter.this.F.getMixedNewFriendDatas();
                        SystemMsgListAdapter.this.o();
                        SystemMsgListAdapter.this.f254094m.runOnUiThread(new Runnable(mixedNewFriendDatas) { // from class: com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter.2.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ ArrayList f254095d;

                            {
                                this.f254095d = mixedNewFriendDatas;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) mixedNewFriendDatas);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                SystemMsgListAdapter.this.J.clear();
                                SystemMsgListAdapter.this.D.clear();
                                Boolean bool = Boolean.FALSE;
                                Iterator it = this.f254095d.iterator();
                                while (it.hasNext()) {
                                    com.tencent.mobileqq.newfriend.msg.i iVar = (com.tencent.mobileqq.newfriend.msg.i) it.next();
                                    d q16 = SystemMsgListAdapter.this.q(iVar);
                                    if (q16 != null) {
                                        SystemMsgListAdapter.this.D.add(q16);
                                    }
                                    if (iVar instanceof com.tencent.mobileqq.newfriend.msg.m) {
                                        bool = Boolean.TRUE;
                                    }
                                }
                                if (!SystemMsgListAdapter.this.M.p().isEmpty()) {
                                    List<d> list = SystemMsgListAdapter.this.D;
                                    SystemMsgListAdapter systemMsgListAdapter2 = SystemMsgListAdapter.this;
                                    list.add(new com.tencent.mobileqq.newfriend.ui.builder.b(systemMsgListAdapter2.C, systemMsgListAdapter2.f254094m, systemMsgListAdapter2, null, systemMsgListAdapter2.M.q()));
                                }
                                SystemMsgListAdapter.this.L.postValue(bool);
                                SystemMsgListAdapter.this.f254101e.x();
                                SystemMsgListAdapter.this.notifyDataSetChanged();
                                SystemMsgListAdapter systemMsgListAdapter3 = SystemMsgListAdapter.this;
                                if (systemMsgListAdapter3.f254092h) {
                                    if (systemMsgListAdapter3.f254091f == 2 && systemMsgListAdapter3.F.getUnreadSystemMessageCount() == 0 && SystemMsgListAdapter.this.F.getAllUnreadMessageCount() > 0 && SystemMsgListAdapter.this.F.getRceommendShowCount() >= 3) {
                                        SystemMsgListAdapter.this.f254101e.setSelection(SystemMsgListAdapter.this.F.getRecommendSubTitleIndex());
                                    }
                                    SystemMsgListAdapter.this.f254092h = false;
                                }
                            }
                        });
                    }
                }
            }, null, true);
        }
    }

    @Override // com.tencent.widget.SwipListView.SwipListListener
    public void updateCurShowRightView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) view);
            return;
        }
        int i3 = -1;
        if (view != null) {
            Object tag = view.getTag(-1);
            if (tag instanceof Integer) {
                i3 = ((Integer) tag).intValue();
            }
        }
        this.f254100d = i3;
    }

    public void v() {
        ArrayList<com.tencent.mobileqq.activity.contact.connections.a> n3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SystemMsgListAdapter", 2, "onResume firstVisible: " + this.H.getFirstVisiblePosition() + " lastvisible: " + this.H.getLastVisiblePosition());
        }
        if (getCount() > 0 && this.H.isShown()) {
            this.H.removeCallbacks(this.R);
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList<Integer> arrayList3 = new ArrayList<>();
            ArrayList<byte[]> arrayList4 = new ArrayList<>();
            ArrayList arrayList5 = new ArrayList();
            for (int firstVisiblePosition = this.H.getFirstVisiblePosition(); firstVisiblePosition <= this.H.getLastVisiblePosition() && firstVisiblePosition < getCount(); firstVisiblePosition++) {
                d dVar = (d) getItem(firstVisiblePosition);
                if (dVar instanceof com.tencent.mobileqq.newfriend.ui.builder.c) {
                    com.tencent.mobileqq.newfriend.ui.builder.c cVar = (com.tencent.mobileqq.newfriend.ui.builder.c) dVar;
                    arrayList.add(cVar.q());
                    arrayList2.add(cVar.p());
                    arrayList3.add(Integer.valueOf(cVar.o()));
                    arrayList4.add(cVar.n());
                } else if ((dVar instanceof com.tencent.mobileqq.newfriend.ui.builder.j) && (n3 = ((com.tencent.mobileqq.newfriend.ui.builder.j) dVar).n()) != null) {
                    arrayList5.addAll(n3);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("SystemMsgListAdapter", 2, "reportRecommendFrdExpose exp_uins: " + arrayList + " exp_reasons:" + arrayList2 + " exp_positions:" + arrayList3 + " algh_ids:" + arrayList4);
            }
            ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).reportRecommendExpose(this.f254094m, a(), arrayList, arrayList2, arrayList3, arrayList4, 0);
        }
        this.M.u(59);
    }

    public void w(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else if (i3 + i16 > i17 - 5 && !this.M.q()) {
            this.M.t(new ArrayList<>());
        }
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else if (this.f254093i.isPausing()) {
            this.f254093i.resume();
        }
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        int childCount = this.H.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            Object tag = this.H.getChildAt(i3).getTag();
            if (tag instanceof n.b) {
                n.v((n.b) tag, this, this.f254094m);
            } else if (tag instanceof ContactMatchBuilder.a) {
                ContactMatchBuilder.a aVar = (ContactMatchBuilder.a) tag;
                aVar.f254114d.setImageBitmap(c(11, aVar.D));
            } else if (tag instanceof c.a) {
                c.a aVar2 = (c.a) tag;
                aVar2.f254114d.setImageBitmap(c(1, aVar2.D));
            } else if (tag instanceof PhoneContactAddBuilder.a) {
                PhoneContactAddBuilder.a aVar3 = (PhoneContactAddBuilder.a) tag;
                aVar3.f254114d.setImageBitmap(c(11, aVar3.D));
            } else if (tag instanceof com.tencent.mobileqq.newfriend.ui.builder.a) {
                com.tencent.mobileqq.newfriend.ui.builder.a aVar4 = (com.tencent.mobileqq.newfriend.ui.builder.a) tag;
                String str = aVar4.N;
                if (str != null && str.length() > 0) {
                    aVar4.I.setImageBitmap(c(11, aVar4.N));
                }
                String str2 = aVar4.P;
                if (str2 != null && str2.length() > 0) {
                    aVar4.J.setImageBitmap(c(11, aVar4.P));
                }
                String str3 = aVar4.Q;
                if (str3 != null && str3.length() > 0) {
                    aVar4.K.setImageBitmap(c(11, aVar4.Q));
                }
                String str4 = aVar4.R;
                if (str4 != null && str4.length() > 0) {
                    aVar4.L.setImageBitmap(c(11, aVar4.R));
                }
                String str5 = aVar4.S;
                if (str5 != null && str5.length() > 0) {
                    aVar4.M.setImageBitmap(c(11, aVar4.S));
                }
            } else if (tag instanceof m.a) {
                m.a aVar5 = (m.a) tag;
                aVar5.f254114d.setImageBitmap(c(1, aVar5.D));
            }
        }
    }

    public void z(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        com.tencent.mobileqq.activity.contact.connections.c cVar = this.K;
        if (cVar != null) {
            cVar.f181263b = i16;
            cVar.f181262a = i3;
        }
    }
}

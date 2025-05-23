package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: P */
/* loaded from: classes10.dex */
public class i extends BaseAdapter implements DecodeTaskCompletionListener, AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_;
    private IFaceDecoder C;
    private ListView D;
    protected d E;
    protected boolean F;
    public boolean G;
    private int H;
    private View.OnClickListener I;
    protected View.OnClickListener J;

    /* renamed from: d, reason: collision with root package name */
    private Context f187188d;

    /* renamed from: e, reason: collision with root package name */
    QQAppInterface f187189e;

    /* renamed from: f, reason: collision with root package name */
    private LayoutInflater f187190f;

    /* renamed from: h, reason: collision with root package name */
    private List<DiscussionInfo> f187191h;

    /* renamed from: i, reason: collision with root package name */
    private List<Entity> f187192i;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<Object> f187193m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements Comparator<Entity> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ HashMap f187194d;

        a(HashMap hashMap) {
            this.f187194d = hashMap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this, (Object) hashMap);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Entity entity, Entity entity2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) entity, (Object) entity2)).intValue();
            }
            long longValue = ((Long) this.f187194d.get(((DiscussionInfo) entity).uin)).longValue();
            long longValue2 = ((Long) this.f187194d.get(((DiscussionInfo) entity2).uin)).longValue();
            if (longValue < longValue2) {
                return -1;
            }
            if (longValue > longValue2) {
                return 1;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DiscussionInfo discussionInfo;
            d dVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Object tag = view.getTag();
                if ((tag instanceof e) && (discussionInfo = ((e) tag).f187202e) != null && (dVar = i.this.E) != null) {
                    dVar.a(discussionInfo);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((SlideDetectListView) i.this.D).j0();
                View view2 = (View) view.getParent();
                if (view2 instanceof ShaderAnimLayout) {
                    ((ShaderAnimLayout) view2).b();
                }
                Object tag = view.getTag();
                if (tag instanceof DiscussionInfo) {
                    DiscussionInfo discussionInfo = (DiscussionInfo) tag;
                    if (NetworkUtil.getSystemNetwork(i.this.f187188d) == 0) {
                        BaseActivity baseActivity = (BaseActivity) i.this.f187188d;
                        QQToast.makeText(baseActivity, R.string.dqp, 0).show(baseActivity.getTitleBarHeight());
                    } else if (!discussionInfo.hasCollect && ((com.tencent.mobileqq.app.n) i.this.f187189e.getManager(QQManagerFactory.DISCUSSION_MANAGER)).r() >= 80) {
                        BaseActivity baseActivity2 = (BaseActivity) i.this.f187188d;
                        QQToast.makeText(baseActivity2, i.this.f187188d.getString(R.string.dqo, String.valueOf(80)), 0).show(baseActivity2.getTitleBarHeight());
                    } else {
                        DiscussionHandler discussionHandler = (DiscussionHandler) i.this.f187189e.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
                        if (discussionInfo.hasCollect) {
                            str = "0X8006898";
                        } else {
                            str = "0X8006897";
                        }
                        String str2 = str;
                        ReportController.o(i.this.f187189e, "CliOper", "", "", str2, str2, 0, 0, "", "", "", "");
                        if (discussionInfo.hasCollect) {
                            discussionHandler.s4(Long.valueOf(discussionInfo.uin).longValue());
                        } else {
                            discussionHandler.K2(Long.valueOf(discussionInfo.uin).longValue());
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface d {
        void a(DiscussionInfo discussionInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f187198a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f187199b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f187200c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f187201d;

        /* renamed from: e, reason: collision with root package name */
        public DiscussionInfo f187202e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f187203f;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public i(Context context, d dVar, ListView listView, QQAppInterface qQAppInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, dVar, listView, qQAppInterface, Boolean.valueOf(z16));
            return;
        }
        this.f187191h = new ArrayList();
        this.f187192i = new ArrayList();
        this.f187193m = new ArrayList<>();
        this.F = false;
        this.G = true;
        this.H = 0;
        this.I = new b();
        this.J = new c();
        this.f187188d = context;
        this.f187189e = qQAppInterface;
        this.f187190f = LayoutInflater.from(context);
        if (z16) {
            e();
        }
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(qQAppInterface);
        this.C = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        this.D = listView;
        this.E = dVar;
        listView.setOnScrollListener(this);
    }

    private void e() {
        long j3;
        long j16;
        long j17;
        this.f187191h = ((com.tencent.mobileqq.app.n) this.f187189e.getManager(QQManagerFactory.DISCUSSION_MANAGER)).k();
        HashMap hashMap = new HashMap();
        String string = this.f187188d.getResources().getString(R.string.i_t);
        String string2 = this.f187188d.getResources().getString(R.string.a6u);
        for (DiscussionInfo discussionInfo : this.f187191h) {
            String o16 = com.tencent.mobileqq.utils.ac.o(this.f187188d, discussionInfo);
            String d16 = ChnToSpell.d(o16, 1);
            if (!o16.matches(string) && !o16.contains(string2)) {
                j3 = 0;
            } else {
                j3 = 65536;
            }
            if (d16 != null && d16.length() != 0) {
                if (StringUtil.isAsciiAlpha(d16.charAt(0))) {
                    j17 = d16.charAt(0);
                } else if (Character.isDigit(d16.charAt(0))) {
                    j17 = 65534;
                }
                j16 = j17 | j3;
                hashMap.put(discussionInfo.uin, Long.valueOf(j16));
            }
            j16 = j3 | WebSocketProtocol.PAYLOAD_SHORT_MAX;
            hashMap.put(discussionInfo.uin, Long.valueOf(j16));
        }
        Collections.sort(this.f187191h, new a(hashMap));
        this.f187192i.clear();
        for (DiscussionInfo discussionInfo2 : this.f187191h) {
            if (discussionInfo2.hasCollect) {
                this.f187192i.add(discussionInfo2);
            }
        }
        this.f187193m.clear();
        if (this.f187191h.size() > 0) {
            int size = this.f187192i.size();
            if (size > 0) {
                this.f187193m.add(Integer.valueOf(size));
                this.f187193m.addAll(this.f187192i);
            }
            this.f187193m.add(Integer.valueOf(size));
            this.f187193m.addAll(this.f187191h);
        }
    }

    private void f(String str, Bitmap bitmap) {
        int childCount = this.D.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            Object tag = this.D.getChildAt(i3).getTag();
            if (tag != null && (tag instanceof e)) {
                e eVar = (e) tag;
                if (str == null && !TextUtils.isEmpty(eVar.f187198a)) {
                    bitmap = this.C.getBitmapFromCache(101, eVar.f187198a);
                    if (bitmap != null) {
                        eVar.f187199b.setBackgroundDrawable(new BitmapDrawable(this.f187188d.getResources(), bitmap));
                    } else {
                        this.C.requestDecodeFace(eVar.f187198a, 101, true);
                    }
                } else if (TextUtils.equals(str, eVar.f187198a)) {
                    eVar.f187199b.setBackgroundDrawable(new BitmapDrawable(this.f187188d.getResources(), bitmap));
                    return;
                }
            }
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.C.destory();
        }
    }

    public DiscussionInfo d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (DiscussionInfo) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        if (i3 >= 0 && i3 < this.f187193m.size()) {
            return (DiscussionInfo) this.f187193m.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f187193m.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        return this.f187193m.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this, i3)).longValue();
        }
        Object item = getItem(i3);
        if (item instanceof DiscussionInfo) {
            return Long.parseLong(((DiscussionInfo) item).uin);
        }
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
        }
        if (getItem(i3) instanceof Integer) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        e eVar;
        View view3;
        e eVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            view3 = view;
            view = (View) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            if (getItemViewType(i3) == 1) {
                if (view == null) {
                    view = this.f187190f.inflate(R.layout.f167915m8, viewGroup, false);
                    eVar2 = new e();
                    eVar2.f187199b = (ImageView) view.findViewById(R.id.icon);
                    eVar2.f187200c = (TextView) view.findViewById(R.id.text1);
                    eVar2.f187201d = (TextView) view.findViewById(R.id.text2);
                    eVar2.f187203f = (ImageView) view.findViewById(R.id.blw);
                    eVar2.f187199b.setImageBitmap(null);
                    eVar2.f187199b.setClickable(false);
                    eVar2.f187201d.setVisibility(0);
                    view.setTag(eVar2);
                    view.setOnClickListener(this.I);
                    ((Button) view.findViewById(R.id.blp)).setOnClickListener(this.J);
                } else {
                    eVar2 = (e) view.getTag();
                }
                DiscussionInfo discussionInfo = (DiscussionInfo) getItem(i3);
                String str = discussionInfo.uin;
                eVar2.f187200c.setText(com.tencent.mobileqq.utils.ac.o(this.f187188d, discussionInfo));
                eVar2.f187201d.setText(String.format("(%d)", Integer.valueOf(((com.tencent.mobileqq.app.n) this.f187189e.getManager(QQManagerFactory.DISCUSSION_MANAGER)).q(str))));
                Bitmap bitmapFromCache = this.C.getBitmapFromCache(101, str);
                if (bitmapFromCache == null) {
                    eVar2.f187199b.setBackgroundDrawable(BaseImageUtil.getDefaultDiscusionFaceDrawable());
                } else {
                    eVar2.f187199b.setBackgroundDrawable(new BitmapDrawable(this.D.getResources(), bitmapFromCache));
                }
                if (this.H == 0) {
                    this.C.requestDecodeFace(str, 101, false);
                }
                eVar2.f187198a = str;
                eVar2.f187202e = discussionInfo;
                if (this.F) {
                    eVar2.f187203f.setVisibility(0);
                } else {
                    eVar2.f187203f.setVisibility(8);
                }
            } else {
                if (view == null) {
                    eVar = new e();
                    view2 = this.f187190f.inflate(R.layout.f167914m7, viewGroup, false);
                    eVar.f187200c = (TextView) view2.findViewById(R.id.bmd);
                    view2.setTag(eVar);
                } else {
                    view2 = view;
                    eVar = (e) view.getTag();
                }
                eVar.f187198a = "";
                if (i3 == 0 && this.f187192i.size() > 0) {
                    eVar.f187200c.setText(R.string.f171131ce2);
                } else {
                    eVar.f187200c.setText(R.string.cdr);
                }
                view = view2;
            }
            view3 = view;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            e();
            super.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
        } else if (bitmap != null && this.H == 0) {
            f(str, bitmap);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) absListView, i3);
            return;
        }
        this.H = i3;
        if (i3 == 0) {
            f(null, null);
            this.C.resume();
        } else {
            this.C.pause();
            this.C.cancelPendingRequests();
        }
    }
}

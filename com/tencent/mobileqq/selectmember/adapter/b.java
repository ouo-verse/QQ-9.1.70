package com.tencent.mobileqq.selectmember.adapter;

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
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IDiscussionHandlerService;
import com.tencent.mobileqq.troop.api.IDiscussionService;
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
/* loaded from: classes18.dex */
public class b extends BaseAdapter implements DecodeTaskCompletionListener, AbsListView.OnScrollListener {
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
    private Context f285926d;

    /* renamed from: e, reason: collision with root package name */
    AppInterface f285927e;

    /* renamed from: f, reason: collision with root package name */
    private LayoutInflater f285928f;

    /* renamed from: h, reason: collision with root package name */
    private List<DiscussionInfo> f285929h;

    /* renamed from: i, reason: collision with root package name */
    private List<Entity> f285930i;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<Object> f285931m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements Comparator<Entity> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ HashMap f285932d;

        a(HashMap hashMap) {
            this.f285932d = hashMap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) hashMap);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Entity entity, Entity entity2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) entity, (Object) entity2)).intValue();
            }
            long longValue = ((Long) this.f285932d.get(((DiscussionInfo) entity).uin)).longValue();
            long longValue2 = ((Long) this.f285932d.get(((DiscussionInfo) entity2).uin)).longValue();
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
    /* renamed from: com.tencent.mobileqq.selectmember.adapter.b$b, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    class ViewOnClickListenerC8570b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        ViewOnClickListenerC8570b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
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
                if ((tag instanceof e) && (discussionInfo = ((e) tag).f285940e) != null && (dVar = b.this.E) != null) {
                    dVar.a(discussionInfo);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            IDiscussionService iDiscussionService;
            int discussionManager_COLLECT_MAX_Value;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((SlideDetectListView) b.this.D).j0();
                View view2 = (View) view.getParent();
                if (view2 instanceof ShaderAnimLayout) {
                    ((ShaderAnimLayout) view2).b();
                }
                Object tag = view.getTag();
                if (tag instanceof DiscussionInfo) {
                    DiscussionInfo discussionInfo = (DiscussionInfo) tag;
                    if (NetworkUtil.getSystemNetwork(b.this.f285926d) == 0) {
                        QBaseActivity qBaseActivity = (QBaseActivity) b.this.f285926d;
                        QQToast.makeText(qBaseActivity, R.string.dqp, 0).show(qBaseActivity.getTitleBarHeight());
                    } else if (!discussionInfo.hasCollect && iDiscussionService.getFavoriteCount() >= (discussionManager_COLLECT_MAX_Value = (iDiscussionService = (IDiscussionService) b.this.f285927e.getRuntimeService(IDiscussionService.class, "")).getDiscussionManager_COLLECT_MAX_Value())) {
                        QBaseActivity qBaseActivity2 = (QBaseActivity) b.this.f285926d;
                        QQToast.makeText(qBaseActivity2, b.this.f285926d.getString(R.string.dqo, String.valueOf(discussionManager_COLLECT_MAX_Value)), 0).show(qBaseActivity2.getTitleBarHeight());
                    } else {
                        IDiscussionHandlerService iDiscussionHandlerService = (IDiscussionHandlerService) b.this.f285927e.getRuntimeService(IDiscussionHandlerService.class, "");
                        if (discussionInfo.hasCollect) {
                            str = "0X8006898";
                        } else {
                            str = "0X8006897";
                        }
                        String str2 = str;
                        ReportController.o(b.this.f285927e, "CliOper", "", "", str2, str2, 0, 0, "", "", "", "");
                        if (discussionInfo.hasCollect) {
                            iDiscussionHandlerService.unCollectDiscussion(Long.valueOf(discussionInfo.uin).longValue());
                        } else {
                            iDiscussionHandlerService.collectDiscussion(Long.valueOf(discussionInfo.uin).longValue());
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface d {
        void a(DiscussionInfo discussionInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f285936a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f285937b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f285938c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f285939d;

        /* renamed from: e, reason: collision with root package name */
        public DiscussionInfo f285940e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f285941f;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* synthetic */ e(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
    }

    public b(Context context, d dVar, ListView listView, AppInterface appInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, dVar, listView, appInterface, Boolean.valueOf(z16));
            return;
        }
        this.f285929h = new ArrayList();
        this.f285930i = new ArrayList();
        this.f285931m = new ArrayList<>();
        this.F = false;
        this.G = true;
        this.H = 0;
        this.I = new ViewOnClickListenerC8570b();
        this.J = new c();
        this.f285926d = context;
        this.f285927e = appInterface;
        this.f285928f = LayoutInflater.from(context);
        if (z16) {
            d();
        }
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(appInterface);
        this.C = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        this.D = listView;
        this.E = dVar;
        listView.setOnScrollListener(this);
    }

    private void d() {
        long j3;
        long j16;
        long j17;
        this.f285929h = (ArrayList) ((IDiscussionService) this.f285927e.getRuntimeService(IDiscussionService.class, "")).getDiscussList();
        HashMap hashMap = new HashMap();
        String string = this.f285926d.getResources().getString(R.string.i_t);
        String string2 = this.f285926d.getResources().getString(R.string.a6u);
        for (DiscussionInfo discussionInfo : this.f285929h) {
            String e16 = com.tencent.mobileqq.selectmember.util.a.e(this.f285926d, discussionInfo);
            String d16 = ChnToSpell.d(e16, 1);
            if (!e16.matches(string) && !e16.contains(string2)) {
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
        Collections.sort(this.f285929h, new a(hashMap));
        this.f285930i.clear();
        for (DiscussionInfo discussionInfo2 : this.f285929h) {
            if (discussionInfo2.hasCollect) {
                this.f285930i.add(discussionInfo2);
            }
        }
        this.f285931m.clear();
        if (this.f285929h.size() > 0) {
            int size = this.f285930i.size();
            if (size > 0) {
                this.f285931m.add(Integer.valueOf(size));
                this.f285931m.addAll(this.f285930i);
            }
            this.f285931m.add(Integer.valueOf(size));
            this.f285931m.addAll(this.f285929h);
        }
    }

    private void e(String str, Bitmap bitmap) {
        int childCount = this.D.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            Object tag = this.D.getChildAt(i3).getTag();
            if (tag != null && (tag instanceof e)) {
                e eVar = (e) tag;
                if (str == null && !TextUtils.isEmpty(eVar.f285936a)) {
                    bitmap = this.C.getBitmapFromCache(101, eVar.f285936a);
                    if (bitmap != null) {
                        eVar.f285937b.setBackgroundDrawable(new BitmapDrawable(this.f285926d.getResources(), bitmap));
                    } else {
                        this.C.requestDecodeFace(eVar.f285936a, 101, true);
                    }
                } else if (TextUtils.equals(str, eVar.f285936a)) {
                    eVar.f285937b.setBackgroundDrawable(new BitmapDrawable(this.f285926d.getResources(), bitmap));
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

    public void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.F = z16;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f285931m.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        return this.f285931m.get(i3);
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
            a aVar = null;
            if (getItemViewType(i3) == 1) {
                if (view == null) {
                    view = this.f285928f.inflate(R.layout.f167915m8, viewGroup, false);
                    eVar2 = new e(aVar);
                    eVar2.f285937b = (ImageView) view.findViewById(R.id.icon);
                    eVar2.f285938c = (TextView) view.findViewById(R.id.text1);
                    eVar2.f285939d = (TextView) view.findViewById(R.id.text2);
                    eVar2.f285941f = (ImageView) view.findViewById(R.id.blw);
                    eVar2.f285937b.setImageBitmap(null);
                    eVar2.f285937b.setClickable(false);
                    eVar2.f285939d.setVisibility(0);
                    view.setTag(eVar2);
                    view.setOnClickListener(this.I);
                    ((Button) view.findViewById(R.id.blp)).setOnClickListener(this.J);
                } else {
                    eVar2 = (e) view.getTag();
                }
                DiscussionInfo discussionInfo = (DiscussionInfo) getItem(i3);
                String str = discussionInfo.uin;
                eVar2.f285938c.setText(com.tencent.mobileqq.selectmember.util.a.e(this.f285926d, discussionInfo));
                eVar2.f285939d.setText(String.format("(%d)", Integer.valueOf(((IDiscussionService) this.f285927e.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(str))));
                Bitmap bitmapFromCache = this.C.getBitmapFromCache(101, str);
                if (bitmapFromCache == null) {
                    eVar2.f285937b.setBackgroundDrawable(BaseImageUtil.getDefaultDiscusionFaceDrawable());
                } else {
                    eVar2.f285937b.setBackgroundDrawable(new BitmapDrawable(this.D.getResources(), bitmapFromCache));
                }
                if (this.H == 0) {
                    this.C.requestDecodeFace(str, 101, false);
                }
                eVar2.f285936a = str;
                eVar2.f285940e = discussionInfo;
                if (this.F) {
                    eVar2.f285941f.setVisibility(0);
                } else {
                    eVar2.f285941f.setVisibility(8);
                }
            } else {
                if (view == null) {
                    eVar = new e(aVar);
                    view2 = this.f285928f.inflate(R.layout.f167914m7, viewGroup, false);
                    eVar.f285938c = (TextView) view2.findViewById(R.id.bmd);
                    view2.setTag(eVar);
                } else {
                    view2 = view;
                    eVar = (e) view.getTag();
                }
                eVar.f285936a = "";
                if (i3 == 0 && this.f285930i.size() > 0) {
                    eVar.f285938c.setText(R.string.f171131ce2);
                } else {
                    eVar.f285938c.setText(R.string.cdr);
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
            d();
            super.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
        } else if (bitmap != null && this.H == 0) {
            e(str, bitmap);
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
            e(null, null);
            this.C.resume();
        } else {
            this.C.pause();
            this.C.cancelPendingRequests();
        }
    }
}

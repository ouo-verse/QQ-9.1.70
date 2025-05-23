package com.tencent.mobileqq.forward;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes12.dex */
public class ForwardPreviewTroopMemberController extends m {
    static IPatchRedirector $redirector_;

    /* renamed from: p, reason: collision with root package name */
    public static int f210753p;

    /* renamed from: q, reason: collision with root package name */
    public static int f210754q;

    /* renamed from: h, reason: collision with root package name */
    private RecyclerView f210755h;

    /* renamed from: i, reason: collision with root package name */
    private QQAppInterface f210756i;

    /* renamed from: j, reason: collision with root package name */
    private String f210757j;

    /* renamed from: k, reason: collision with root package name */
    private c f210758k;

    /* renamed from: l, reason: collision with root package name */
    private GridLayoutManager f210759l;

    /* renamed from: m, reason: collision with root package name */
    private IFaceDecoder f210760m;

    /* renamed from: n, reason: collision with root package name */
    private DecodeTaskCompletionListener f210761n;

    /* renamed from: o, reason: collision with root package name */
    private RecyclerView.OnScrollListener f210762o;

    /* loaded from: classes12.dex */
    class a implements DecodeTaskCompletionListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardPreviewTroopMemberController.this);
            }
        }

        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
                return;
            }
            QLog.i("Forward.Preview.Dialog", 1, "onDecodeTaskCompleted uin: " + str);
            if (ForwardPreviewTroopMemberController.this.f210755h == null || ForwardPreviewTroopMemberController.this.f210760m.isPausing()) {
                return;
            }
            int findFirstVisibleItemPosition = ForwardPreviewTroopMemberController.this.f210759l.findFirstVisibleItemPosition();
            int childCount = ForwardPreviewTroopMemberController.this.f210755h.getChildCount();
            for (int i17 = 1; i17 < childCount; i17++) {
                if (((String) ForwardPreviewTroopMemberController.this.f210758k.f210770f.get((findFirstVisibleItemPosition + i17) - 1).first).equals(str)) {
                    e eVar = (e) ForwardPreviewTroopMemberController.this.f210755h.getChildViewHolder(ForwardPreviewTroopMemberController.this.f210755h.getChildAt(i17));
                    if (eVar instanceof d) {
                        ((d) eVar).f210773e.setImageBitmap(bitmap);
                    } else {
                        QLog.e("Forward.Preview.Dialog", 2, "onDecodeTaskCompleted viewHolder in wrong instance ! ");
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    class b extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardPreviewTroopMemberController.this);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, i3);
                return;
            }
            QLog.i("Forward.Preview.Dialog", 1, "onScrollStateChanged state: " + i3);
            if (i3 != 0) {
                ForwardPreviewTroopMemberController.this.f210760m.pause();
            } else if (ForwardPreviewTroopMemberController.this.f210760m.isPausing()) {
                ForwardPreviewTroopMemberController.this.f210760m.resume();
                ForwardPreviewTroopMemberController.this.f210758k.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class c extends RecyclerView.Adapter<e> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        QQAppInterface f210768d;

        /* renamed from: e, reason: collision with root package name */
        Context f210769e;

        /* renamed from: f, reason: collision with root package name */
        List<Pair<String, String>> f210770f;

        /* renamed from: h, reason: collision with root package name */
        IFaceDecoder f210771h;

        /* loaded from: classes12.dex */
        class a extends GridLayoutManager.SpanSizeLookup {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
                }
                if (c.this.getItemViewType(i3) == ForwardPreviewTroopMemberController.f210754q) {
                    return 5;
                }
                return 1;
            }
        }

        public c(QQAppInterface qQAppInterface, Context context, IFaceDecoder iFaceDecoder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, context, iFaceDecoder);
                return;
            }
            this.f210768d = qQAppInterface;
            this.f210769e = context;
            this.f210771h = iFaceDecoder;
            this.f210770f = new ArrayList();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            List<Pair<String, String>> list = this.f210770f;
            if (list != null && list.size() != 0) {
                return this.f210770f.size() + 1;
            }
            return 0;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
            }
            if (i3 == 0) {
                return ForwardPreviewTroopMemberController.f210754q;
            }
            return ForwardPreviewTroopMemberController.f210753p;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) recyclerView);
                return;
            }
            super.onAttachedToRecyclerView(recyclerView);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                ((GridLayoutManager) layoutManager).setSpanSizeLookup(new a());
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(e eVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) eVar, i3);
            } else {
                int i16 = eVar.f210775d;
                if (i16 != ForwardPreviewTroopMemberController.f210754q && i16 == ForwardPreviewTroopMemberController.f210753p) {
                    int i17 = i3 - 1;
                    if (i17 < 0) {
                        QLog.e("Forward.Preview.Dialog", 2, "type normal in wrong index");
                    }
                    Pair<String, String> pair = this.f210770f.get(i17);
                    if (eVar instanceof d) {
                        ((d) eVar).b((String) pair.first, (String) pair.second, this.f210771h);
                    }
                }
            }
            EventCollector.getInstance().onRecyclerBindViewHolder(eVar, i3, getItemId(i3));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public e onCreateViewHolder(ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (e) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup, i3);
            }
            if (i3 == ForwardPreviewTroopMemberController.f210754q) {
                View view = new View(this.f210769e);
                view.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.f210769e.getResources().getDimensionPixelSize(R.dimen.f158885rl)));
                return new e(view);
            }
            return new d(LayoutInflater.from(this.f210769e).inflate(R.layout.f167971o5, viewGroup, false));
        }

        public void r(List<Pair<String, String>> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            } else if (list != null && !list.isEmpty()) {
                this.f210770f.clear();
                this.f210770f.addAll(list);
                notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class d extends e {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f210773e;

        /* renamed from: f, reason: collision with root package name */
        public TextView f210774f;

        public d(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            this.f210775d = ForwardPreviewTroopMemberController.f210753p;
            this.f210773e = (ImageView) view.findViewById(R.id.dic);
            this.f210774f = (TextView) view.findViewById(R.id.kfc);
            view.setTag(this);
        }

        public void b(String str, String str2, IFaceDecoder iFaceDecoder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, iFaceDecoder);
                return;
            }
            if (str2 == null) {
                str2 = str;
            }
            this.f210774f.setText(new QQText(str2, 2));
            Bitmap bitmapFromCache = iFaceDecoder.getBitmapFromCache(1, str);
            if (bitmapFromCache == null) {
                bitmapFromCache = BaseImageUtil.getDefaultFaceBitmap();
                if (!iFaceDecoder.isPausing()) {
                    iFaceDecoder.requestDecodeFace(str, 1, false);
                }
            }
            this.f210773e.setImageBitmap(bitmapFromCache);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class e extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public int f210775d;

        public e(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.f210775d = ForwardPreviewTroopMemberController.f210754q;
                view.setTag(this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72148);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f210753p = 0;
            f210754q = 1;
        }
    }

    public ForwardPreviewTroopMemberController(QQCustomDialog qQCustomDialog) {
        super(qQCustomDialog);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQCustomDialog);
            return;
        }
        this.f210757j = "";
        this.f210761n = new a();
        this.f210762o = new b();
    }

    private LifecycleOwner r() {
        QQCustomDialog qQCustomDialog = this.f211035g;
        if (qQCustomDialog != null && (qQCustomDialog.getContext() instanceof LifecycleOwner)) {
            return (LifecycleOwner) this.f211035g.getContext();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(boolean z16, List list, String str) {
        if (z16 && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                TroopMemberInfo troopMemberInfo = (TroopMemberInfo) it.next();
                arrayList.add(new Pair(troopMemberInfo.memberuin, troopMemberInfo.nickInfo.getShowName()));
            }
            d();
            this.f210758k.r(arrayList);
            return;
        }
        v(str, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(final String str, final boolean z16, final List list) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.forward.q
            @Override // java.lang.Runnable
            public final void run() {
                ForwardPreviewTroopMemberController.this.s(z16, list, str);
            }
        });
    }

    private void u(String str) {
        ThreadManager.getFileThreadHandler().post(new Runnable(str) { // from class: com.tencent.mobileqq.forward.ForwardPreviewTroopMemberController.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f210763d;

            {
                this.f210763d = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardPreviewTroopMemberController.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Map<String, DiscussionMemberInfo> n3 = ((com.tencent.mobileqq.app.n) ForwardPreviewTroopMemberController.this.f210756i.getManager(QQManagerFactory.DISCUSSION_MANAGER)).n(this.f210763d);
                ArrayList arrayList = new ArrayList();
                if (n3 != null && !n3.isEmpty()) {
                    for (DiscussionMemberInfo discussionMemberInfo : n3.values()) {
                        if (discussionMemberInfo != null) {
                            String str2 = discussionMemberInfo.inteRemark;
                            if (TextUtils.isEmpty(str2)) {
                                str2 = discussionMemberInfo.memberName;
                            }
                            if (TextUtils.isEmpty(str2)) {
                                str2 = discussionMemberInfo.memberUin;
                            }
                            arrayList.add(new Pair(discussionMemberInfo.memberUin, str2));
                        }
                    }
                }
                QLog.i("Forward.Preview.Dialog", 1, "loadDiscussionMember discussion mem list size is: " + arrayList.size());
                ThreadManager.getUIHandler().post(new Runnable(arrayList) { // from class: com.tencent.mobileqq.forward.ForwardPreviewTroopMemberController.1.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ List f210764d;

                    {
                        this.f210764d = arrayList;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) arrayList);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (ForwardPreviewTroopMemberController.this.f210758k != null) {
                            ForwardPreviewTroopMemberController.this.d();
                            ForwardPreviewTroopMemberController.this.f210758k.r(this.f210764d);
                        }
                    }
                });
            }
        });
    }

    private void v(final String str, boolean z16) {
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(str, r(), z16, "Forward.Preview.Dialog", new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.forward.p
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z17, List list) {
                ForwardPreviewTroopMemberController.this.t(str, z17, list);
            }
        });
    }

    @Override // com.tencent.mobileqq.forward.m
    protected View a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f210755h == null) {
            this.f210755h = new RecyclerView(this.f211030b);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f211030b, 5);
            this.f210759l = gridLayoutManager;
            this.f210755h.setLayoutManager(gridLayoutManager);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            int f16 = BaseAIOUtils.f(5.0f, this.f211030b.getResources());
            layoutParams.rightMargin = f16;
            layoutParams.leftMargin = f16;
            this.f210755h.setLayoutParams(layoutParams);
            this.f210755h.setOverScrollMode(2);
        }
        return this.f210755h;
    }

    @Override // com.tencent.mobileqq.forward.m
    protected int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT;
    }

    @Override // com.tencent.mobileqq.forward.m
    protected void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.i("Forward.Preview.Dialog", 1, "onDestroy.");
        IFaceDecoder iFaceDecoder = this.f210760m;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
    }

    public void q(QQAppInterface qQAppInterface, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, str, str2, Integer.valueOf(i3));
            return;
        }
        QLog.i("Forward.Preview.Dialog", 1, "bindData title: " + str + " uin: " + str2);
        this.f210756i = qQAppInterface;
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        this.f210757j = str2;
        h(str);
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) this.f210756i.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.f210756i);
        this.f210760m = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this.f210761n);
        c cVar = new c(this.f210756i, this.f211030b, this.f210760m);
        this.f210758k = cVar;
        this.f210755h.setAdapter(cVar);
        this.f210755h.addOnScrollListener(this.f210762o);
        i();
        if (i3 == 1) {
            v(this.f210757j, !((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).isTroopMemberInfoDBInited(this.f210757j));
        } else if (i3 == 3000) {
            u(this.f210757j);
        }
    }
}

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
import com.tencent.mobileqq.app.HardCodeUtil;
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
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes12.dex */
public class ForwardTroopMemberControllerForMiniPie {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    public static int f210913m;

    /* renamed from: n, reason: collision with root package name */
    public static int f210914n;

    /* renamed from: a, reason: collision with root package name */
    private RecyclerView f210915a;

    /* renamed from: b, reason: collision with root package name */
    private RelativeLayout f210916b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f210917c;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f210918d;

    /* renamed from: e, reason: collision with root package name */
    private String f210919e;

    /* renamed from: f, reason: collision with root package name */
    private c f210920f;

    /* renamed from: g, reason: collision with root package name */
    private GridLayoutManager f210921g;

    /* renamed from: h, reason: collision with root package name */
    private IFaceDecoder f210922h;

    /* renamed from: i, reason: collision with root package name */
    private Context f210923i;

    /* renamed from: j, reason: collision with root package name */
    private float f210924j;

    /* renamed from: k, reason: collision with root package name */
    private DecodeTaskCompletionListener f210925k;

    /* renamed from: l, reason: collision with root package name */
    private RecyclerView.OnScrollListener f210926l;

    /* loaded from: classes12.dex */
    class a implements DecodeTaskCompletionListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardTroopMemberControllerForMiniPie.this);
            }
        }

        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
                return;
            }
            QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "onDecodeTaskCompleted uin: " + str);
            if (ForwardTroopMemberControllerForMiniPie.this.f210915a == null || ForwardTroopMemberControllerForMiniPie.this.f210922h.isPausing()) {
                return;
            }
            int findFirstVisibleItemPosition = ForwardTroopMemberControllerForMiniPie.this.f210921g.findFirstVisibleItemPosition();
            int childCount = ForwardTroopMemberControllerForMiniPie.this.f210915a.getChildCount();
            for (int i17 = 1; i17 < childCount; i17++) {
                if (((String) ForwardTroopMemberControllerForMiniPie.this.f210920f.f210933e.get((findFirstVisibleItemPosition + i17) - 1).first).equals(str)) {
                    e eVar = (e) ForwardTroopMemberControllerForMiniPie.this.f210915a.getChildViewHolder(ForwardTroopMemberControllerForMiniPie.this.f210915a.getChildAt(i17));
                    if (eVar instanceof d) {
                        ((d) eVar).f210937e.setImageBitmap(bitmap);
                    } else {
                        QLog.e("ForwardTroopMemberControllerForMiniPie", 2, "onDecodeTaskCompleted viewHolder in wrong instance ! ");
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardTroopMemberControllerForMiniPie.this);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, i3);
                return;
            }
            QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "onScrollStateChanged state: " + i3);
            if (i3 != 0) {
                ForwardTroopMemberControllerForMiniPie.this.f210922h.pause();
            } else if (ForwardTroopMemberControllerForMiniPie.this.f210922h.isPausing()) {
                ForwardTroopMemberControllerForMiniPie.this.f210922h.resume();
                ForwardTroopMemberControllerForMiniPie.this.f210920f.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class c extends RecyclerView.Adapter<e> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        Context f210932d;

        /* renamed from: e, reason: collision with root package name */
        List<Pair<String, String>> f210933e;

        /* renamed from: f, reason: collision with root package name */
        IFaceDecoder f210934f;

        /* renamed from: h, reason: collision with root package name */
        float f210935h;

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
                if (c.this.getItemViewType(i3) == ForwardTroopMemberControllerForMiniPie.f210914n) {
                    return 5;
                }
                return 1;
            }
        }

        public c(Context context, IFaceDecoder iFaceDecoder, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, iFaceDecoder, Float.valueOf(f16));
                return;
            }
            this.f210935h = 1.0f;
            this.f210932d = context;
            this.f210934f = iFaceDecoder;
            this.f210933e = new ArrayList();
            this.f210935h = f16;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            List<Pair<String, String>> list = this.f210933e;
            if (list != null && list.size() != 0) {
                return this.f210933e.size() + 1;
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
                return ForwardTroopMemberControllerForMiniPie.f210914n;
            }
            return ForwardTroopMemberControllerForMiniPie.f210913m;
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
                int i16 = eVar.f210939d;
                if (i16 != ForwardTroopMemberControllerForMiniPie.f210914n && i16 == ForwardTroopMemberControllerForMiniPie.f210913m) {
                    int i17 = i3 - 1;
                    if (i17 < 0) {
                        QLog.e("ForwardTroopMemberControllerForMiniPie", 2, "type normal in wrong index");
                    }
                    Pair<String, String> pair = this.f210933e.get(i17);
                    if (eVar instanceof d) {
                        ((d) eVar).b((String) pair.first, (String) pair.second, this.f210934f);
                    }
                }
            }
            EventCollector.getInstance().onRecyclerBindViewHolder(eVar, i3, getItemId(i3));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public e onCreateViewHolder(ViewGroup viewGroup, int i3) {
            ViewGroup.LayoutParams layoutParams;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (e) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup, i3);
            }
            if (i3 == ForwardTroopMemberControllerForMiniPie.f210914n) {
                View view = new View(this.f210932d);
                int dimensionPixelSize = this.f210932d.getResources().getDimensionPixelSize(R.dimen.f158885rl);
                float f16 = this.f210935h;
                if (f16 != 0.0f) {
                    dimensionPixelSize = (int) (dimensionPixelSize / f16);
                }
                view.setLayoutParams(new RelativeLayout.LayoutParams(-1, dimensionPixelSize));
                return new e(view);
            }
            View inflate = LayoutInflater.from(this.f210932d).inflate(R.layout.f167971o5, viewGroup, false);
            if (this.f210935h != 0.0f && inflate != null) {
                ViewGroup.LayoutParams layoutParams2 = inflate.getLayoutParams();
                layoutParams2.height = BaseAIOUtils.f(80.0f / this.f210935h, this.f210932d.getResources());
                inflate.setLayoutParams(layoutParams2);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.dic);
                if (imageView != null && (layoutParams = imageView.getLayoutParams()) != null) {
                    int f17 = BaseAIOUtils.f(40.0f / this.f210935h, this.f210932d.getResources());
                    layoutParams.width = f17;
                    layoutParams.height = f17;
                    imageView.setLayoutParams(layoutParams);
                }
                TextView textView = (TextView) inflate.findViewById(R.id.kfc);
                if (textView != null) {
                    textView.setTextSize(2, (int) (10.0d / this.f210935h));
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                    float f18 = marginLayoutParams.leftMargin;
                    float f19 = this.f210935h;
                    marginLayoutParams.setMargins((int) (f18 / f19), (int) (marginLayoutParams.topMargin / f19), (int) (marginLayoutParams.rightMargin / f19), (int) (marginLayoutParams.bottomMargin / f19));
                    textView.setLayoutParams(marginLayoutParams);
                    if (SimpleModeHelper.A()) {
                        textView.setTextColor(-8355712);
                    }
                }
            }
            return new d(inflate);
        }

        public void r(List<Pair<String, String>> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            } else if (list != null && !list.isEmpty()) {
                this.f210933e.clear();
                this.f210933e.addAll(list);
                notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class d extends e {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f210937e;

        /* renamed from: f, reason: collision with root package name */
        public TextView f210938f;

        public d(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            this.f210939d = ForwardTroopMemberControllerForMiniPie.f210913m;
            this.f210937e = (ImageView) view.findViewById(R.id.dic);
            this.f210938f = (TextView) view.findViewById(R.id.kfc);
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
            this.f210938f.setText(new QQText(str2, 2));
            Bitmap bitmapFromCache = iFaceDecoder.getBitmapFromCache(1, str);
            if (bitmapFromCache == null) {
                bitmapFromCache = BaseImageUtil.getDefaultFaceBitmap();
                if (!iFaceDecoder.isPausing()) {
                    iFaceDecoder.requestDecodeFace(str, 1, false);
                }
            }
            this.f210937e.setImageBitmap(bitmapFromCache);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class e extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public int f210939d;

        public e(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.f210939d = ForwardTroopMemberControllerForMiniPie.f210914n;
                view.setTag(this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72255);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f210913m = 0;
            f210914n = 1;
        }
    }

    public ForwardTroopMemberControllerForMiniPie(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f210919e = "";
        this.f210924j = 1.0f;
        this.f210925k = new a();
        this.f210926l = new b();
        this.f210923i = context;
        m();
    }

    private LifecycleOwner j() {
        Object obj = this.f210923i;
        if (obj instanceof LifecycleOwner) {
            return (LifecycleOwner) obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        RecyclerView recyclerView = this.f210915a;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        TextView textView = this.f210917c;
        if (textView != null) {
            textView.setVisibility(4);
        }
    }

    private void m() {
        if (this.f210916b == null) {
            this.f210916b = new RelativeLayout(this.f210923i);
            this.f210916b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.f210917c == null) {
            this.f210917c = new TextView(this.f210923i);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(15);
            this.f210917c.setLayoutParams(layoutParams);
            this.f210917c.setText(HardCodeUtil.qqStr(R.string.mrj));
            this.f210917c.setTextSize(2, (int) (16.0d / this.f210924j));
            this.f210917c.setTextColor(this.f210923i.getResources().getColor(R.color.skin_hint_input));
        }
        if (this.f210915a == null) {
            this.f210915a = new RecyclerView(this.f210923i);
            int i3 = 5;
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f210923i, 5);
            this.f210921g = gridLayoutManager;
            this.f210915a.setLayoutManager(gridLayoutManager);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            float f16 = this.f210924j;
            if (f16 != 0.0f) {
                i3 = (int) (5 / f16);
            }
            int f17 = BaseAIOUtils.f(i3, this.f210923i.getResources());
            layoutParams2.rightMargin = f17;
            layoutParams2.leftMargin = f17;
            this.f210915a.setLayoutParams(layoutParams2);
            this.f210915a.setOverScrollMode(2);
        }
        RelativeLayout relativeLayout = this.f210916b;
        if (relativeLayout != null) {
            relativeLayout.addView(this.f210915a);
            this.f210916b.addView(this.f210917c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(List list) {
        l();
        this.f210920f.r(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(String str, boolean z16, List list) {
        if (z16 && !list.isEmpty()) {
            final ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                TroopMemberInfo troopMemberInfo = (TroopMemberInfo) it.next();
                arrayList.add(new Pair(troopMemberInfo.memberuin, troopMemberInfo.nickInfo.getShowName()));
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.forward.aa
                @Override // java.lang.Runnable
                public final void run() {
                    ForwardTroopMemberControllerForMiniPie.this.n(arrayList);
                }
            });
            return;
        }
        q(str, true);
    }

    private void p(String str) {
        ThreadManager.getFileThreadHandler().post(new Runnable(str) { // from class: com.tencent.mobileqq.forward.ForwardTroopMemberControllerForMiniPie.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f210927d;

            {
                this.f210927d = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardTroopMemberControllerForMiniPie.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Map<String, DiscussionMemberInfo> n3 = ((com.tencent.mobileqq.app.n) ForwardTroopMemberControllerForMiniPie.this.f210918d.getManager(QQManagerFactory.DISCUSSION_MANAGER)).n(this.f210927d);
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
                QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "loadDiscussionMember discussion mem list size is: " + arrayList.size());
                ThreadManager.getUIHandler().post(new Runnable(arrayList) { // from class: com.tencent.mobileqq.forward.ForwardTroopMemberControllerForMiniPie.1.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ List f210928d;

                    {
                        this.f210928d = arrayList;
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
                        } else if (ForwardTroopMemberControllerForMiniPie.this.f210920f != null) {
                            ForwardTroopMemberControllerForMiniPie.this.l();
                            ForwardTroopMemberControllerForMiniPie.this.f210920f.r(this.f210928d);
                        }
                    }
                });
            }
        });
    }

    private void q(final String str, boolean z16) {
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(str, j(), z16, "ForwardTroopMemberControllerForMiniPie", new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.forward.z
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z17, List list) {
                ForwardTroopMemberControllerForMiniPie.this.o(str, z17, list);
            }
        });
    }

    private void s() {
        TextView textView = this.f210917c;
        if (textView != null) {
            textView.setVisibility(0);
        }
        RecyclerView recyclerView = this.f210915a;
        if (recyclerView != null) {
            recyclerView.setVisibility(4);
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "destroy.");
        IFaceDecoder iFaceDecoder = this.f210922h;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        this.f210918d = null;
    }

    public View k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f210916b;
    }

    public void r(QQAppInterface qQAppInterface, String str, int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, str, Integer.valueOf(i3), Float.valueOf(f16));
            return;
        }
        QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "setTroopInfo  uin: " + str);
        this.f210918d = qQAppInterface;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.f210919e = str;
        QQAppInterface qQAppInterface2 = this.f210918d;
        if (qQAppInterface2 != null) {
            IFaceDecoder iQQAvatarService = ((IQQAvatarService) qQAppInterface2.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.f210918d);
            this.f210922h = iQQAvatarService;
            iQQAvatarService.setDecodeTaskCompletionListener(this.f210925k);
            this.f210924j = f16;
            c cVar = new c(this.f210923i, this.f210922h, f16);
            this.f210920f = cVar;
            this.f210915a.setAdapter(cVar);
            this.f210915a.addOnScrollListener(this.f210926l);
            s();
            if (i3 == 1) {
                q(this.f210919e, !((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).isTroopMemberInfoDBInited(this.f210919e));
            } else if (i3 == 3000) {
                p(this.f210919e);
            }
        }
    }
}

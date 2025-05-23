package com.qzone.homepage.ui.component.newpanel;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.common.account.LoginData;
import com.qzone.personalize.music.model.UserMusicInfo;
import com.qzone.util.ar;
import com.qzone.widget.AvatarImageView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.media.image.view.AsyncImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.music.BroadcastMusicInfo;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QUA;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes39.dex */
public class PanelPopupAdapter extends BaseAdapter {
    private boolean C;
    private ArrayList<HomePanelItem> D;
    private x6.a E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private List<ExtendViewFlipper> K;
    private IRedTouchManager L;
    private boolean M;

    /* renamed from: d, reason: collision with root package name */
    private Activity f47725d;

    /* renamed from: e, reason: collision with root package name */
    private i f47726e;

    /* renamed from: f, reason: collision with root package name */
    private j f47727f;

    /* renamed from: h, reason: collision with root package name */
    private LayoutInflater f47728h;

    /* renamed from: i, reason: collision with root package name */
    private long f47729i;

    /* renamed from: m, reason: collision with root package name */
    private long f47730m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view != null && PanelPopupAdapter.this.f47727f != null) {
                PanelPopupAdapter.this.f47727f.a(PanelPopupAdapter.this, ((Integer) view.getTag()).intValue(), 2);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f47736d;

        b(int i3) {
            this.f47736d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view != null && PanelPopupAdapter.this.f47726e != null) {
                PanelPopupAdapter.this.f47726e.a(PanelPopupAdapter.this, this.f47736d, 1);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f47738d;

        c(int i3) {
            this.f47738d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view != null && PanelPopupAdapter.this.f47727f != null) {
                PanelPopupAdapter.this.f47727f.a(PanelPopupAdapter.this, this.f47738d, 2);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f47740a;

        /* renamed from: b, reason: collision with root package name */
        public RelativeLayout f47741b;

        /* renamed from: c, reason: collision with root package name */
        public AsyncImageView f47742c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f47743d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f47744e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f47745f;

        /* renamed from: g, reason: collision with root package name */
        public ExtendViewFlipper f47746g;

        /* renamed from: h, reason: collision with root package name */
        public RelativeLayout f47747h;

        /* renamed from: i, reason: collision with root package name */
        public RelativeLayout f47748i;
    }

    public PanelPopupAdapter(Activity activity, ArrayList<HomePanelItem> arrayList, long j3) {
        this(activity, arrayList, j3, false);
    }

    private void c(HomePanelItem homePanelItem) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new Runnable() { // from class: com.qzone.homepage.ui.component.newpanel.PanelPopupAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                QZoneFeedAlertService.getInstance().cleanNewGameCount();
            }
        }, 3000L);
        IRedTouchManager i3 = i();
        if (homePanelItem.businessAppInfoBytes != null && i3 != null) {
            BusinessInfoCheckUpdate.AppInfo appInfo = new BusinessInfoCheckUpdate.AppInfo();
            try {
                appInfo.mergeFrom(homePanelItem.businessAppInfoBytes);
            } catch (Exception e16) {
                RFWLog.fatal("PanelPopupAdapter", RFWLog.USR, e16);
            }
            i3.onRedTouchItemClick(appInfo, null);
        }
        homePanelItem.businessAppInfoBytes = null;
    }

    private void f() {
        List<ExtendViewFlipper> list = this.K;
        if (list != null) {
            for (ExtendViewFlipper extendViewFlipper : list) {
                if (extendViewFlipper != null) {
                    extendViewFlipper.g();
                }
            }
            this.K.clear();
        }
    }

    private Drawable g(QUIListItemBackgroundType qUIListItemBackgroundType) {
        if (this.G != 0 && qUIListItemBackgroundType == QUIListItemBackgroundType.FullWidth) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(this.G);
            return gradientDrawable;
        }
        return qUIListItemBackgroundType.getBackground(this.f47725d, 1000);
    }

    private QUIListItemBackgroundType h(int i3) {
        if (!this.M) {
            return QUIListItemBackgroundType.FullWidth;
        }
        if (getCount() <= 1) {
            return QUIListItemBackgroundType.AllRound;
        }
        if (i3 == 0) {
            return QUIListItemBackgroundType.TopRound;
        }
        if (i3 == getCount() - 1) {
            return QUIListItemBackgroundType.BottomRound;
        }
        return QUIListItemBackgroundType.NoneRound;
    }

    private IRedTouchManager i() {
        if (this.L == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.e("PanelPopupAdapter", 1, "[getMiniGameRedTouchManager] initMiniGameRedTouchManager failed");
                return null;
            }
            this.L = (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        }
        return this.L;
    }

    private void l(HomePanelItem homePanelItem) {
        int i3;
        String str;
        int i16 = this.F;
        if (i16 == 0) {
            i3 = 126;
        } else if (i16 != 1) {
            return;
        } else {
            i3 = 127;
        }
        int i17 = homePanelItem.tabId * 100;
        ArrayList<RedInfo> arrayList = homePanelItem.redInfos;
        if (arrayList != null && arrayList.size() > 0) {
            str = "1";
        } else {
            str = "0";
        }
        LpReportInfo_pf00064.allReport(i3, i17, 1, str);
    }

    private void x(View view, d dVar, int i3, HomePanelItem homePanelItem) {
        View.OnClickListener cVar;
        if (this.F <= 1) {
            cVar = new b(i3);
        } else {
            cVar = new c(i3);
        }
        dVar.f47741b.setOnClickListener(cVar);
        if (dVar.f47741b.getVisibility() == 0) {
            view.setOnClickListener(cVar);
        } else {
            view.setOnClickListener(null);
        }
    }

    private void z(d dVar, int i3, HomePanelItem homePanelItem) {
        if (dVar.f47748i.getTag() == null) {
            return;
        }
        if (this.F <= 1) {
            if (!((Boolean) dVar.f47748i.getTag()).booleanValue() || dVar.f47748i.getChildCount() <= 0) {
                return;
            }
            dVar.f47748i.setVisibility(0);
            dVar.f47741b.setVisibility(8);
            return;
        }
        if (!((Boolean) dVar.f47748i.getTag()).booleanValue() || dVar.f47748i.getChildCount() <= 0) {
            return;
        }
        dVar.f47748i.removeAllViews();
        dVar.f47748i.setVisibility(8);
        dVar.f47741b.setVisibility(0);
    }

    public void d(int i3) {
        HomePanelItem homePanelItem;
        ArrayList<RedInfo> arrayList;
        ArrayList<HomePanelItem> arrayList2 = this.D;
        if (arrayList2 == null || i3 >= arrayList2.size() || (homePanelItem = this.D.get(i3)) == null) {
            return;
        }
        if (homePanelItem.tabId == 17) {
            c(homePanelItem);
            homePanelItem.showRed = false;
            notifyDataSetChanged();
        } else {
            if (!homePanelItem.needClearRed || !homePanelItem.showRed || (arrayList = homePanelItem.redInfos) == null || arrayList.size() <= 0) {
                return;
            }
            homePanelItem.showRed = false;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<HomePanelItem> arrayList = this.D;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        ArrayList<HomePanelItem> arrayList = this.D;
        if (arrayList == null) {
            return null;
        }
        return arrayList.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    protected int j() {
        return R.layout.bg5;
    }

    public x6.a k() {
        return this.E;
    }

    public void n(int i3) {
        this.G = i3;
        notifyDataSetChanged();
    }

    public void o(i iVar) {
        this.f47726e = iVar;
    }

    public void p(j jVar) {
        this.f47727f = jVar;
    }

    public void q(int i3) {
        this.F = i3;
        QZLog.i("PanelPopupAdapter", "jinqianli@PopupWindowPanelManager, setManagerMode:" + i3);
    }

    public void r(int i3) {
        this.J = i3;
    }

    public void s(x6.a aVar) {
        this.E = aVar;
    }

    public void v(d dVar, HomePanelItem homePanelItem) {
        IRedTouchManager i3 = i();
        if (i3 == null) {
            return;
        }
        BusinessInfoCheckUpdate.AppInfo appInfo = i3.getAppInfo(2, "140112");
        if (appInfo == null) {
            QLog.e("PanelPopupAdapter", 1, "[updateGameEntranceRedPoint] get red app info is null");
            return;
        }
        boolean b16 = com.qzone.business.tianshu.l.b(appInfo);
        QLog.d("PanelPopupAdapter", 1, "[updateGameEntranceRedPoint] need show red point: ", Boolean.valueOf(b16));
        if (b16) {
            dVar.f47744e.setVisibility(0);
            homePanelItem.businessAppInfoBytes = appInfo.toByteArray();
            i3.onRedTouchItemExposure(appInfo, null);
            return;
        }
        dVar.f47744e.setVisibility(8);
    }

    public PanelPopupAdapter(Activity activity, ArrayList<HomePanelItem> arrayList, long j3, boolean z16) {
        this.F = 1;
        this.J = 255;
        this.f47725d = activity;
        this.D = arrayList;
        this.f47729i = j3;
        long uin = LoginData.getInstance().getUin();
        this.f47730m = uin;
        this.C = this.f47729i != uin;
        this.f47728h = LayoutInflater.from(this.f47725d);
        this.H = activity.getResources().getColor(R.color.qui_common_text_primary);
        this.I = activity.getResources().getColor(R.color.qui_common_text_secondary);
        this.K = new ArrayList();
        this.M = z16;
    }

    public void e() {
        this.D = null;
        this.E = null;
        this.f47725d = null;
        this.f47726e = null;
        this.f47727f = null;
        f();
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        d dVar;
        if (view == null) {
            view = this.f47728h.inflate(j(), (ViewGroup) null);
            dVar = new d();
            dVar.f47748i = (RelativeLayout) view.findViewById(R.id.h9v);
            dVar.f47740a = (ImageView) view.findViewById(R.id.em_);
            dVar.f47741b = (RelativeLayout) view.findViewById(R.id.h9y);
            dVar.f47747h = (RelativeLayout) view.findViewById(R.id.iag);
            dVar.f47742c = (AsyncImageView) view.findViewById(R.id.fhz);
            dVar.f47743d = (TextView) view.findViewById(R.id.f166481fi3);
            dVar.f47744e = (ImageView) view.findViewById(R.id.f224003m);
            dVar.f47746g = (ExtendViewFlipper) view.findViewById(R.id.fhw);
            dVar.f47745f = (ImageView) view.findViewById(R.id.fhx);
            view.setTag(dVar);
        } else {
            dVar = (d) view.getTag();
        }
        m(dVar, view, i3);
        dVar.f47743d.setTextColor(this.H);
        ar.a(view, this.J);
        HomePanelItem homePanelItem = this.D.get(i3);
        u(dVar, i3, homePanelItem);
        A(dVar, i3, homePanelItem);
        w(dVar, i3, homePanelItem);
        z(dVar, i3, homePanelItem);
        y(dVar, i3, homePanelItem);
        x(view, dVar, i3, homePanelItem);
        l(homePanelItem);
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    private void m(d dVar, final View view, int i3) {
        if (view == null) {
            return;
        }
        QUIListItemBackgroundType h16 = h(i3);
        Drawable g16 = g(h16);
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable background = h16.getBackground(this.f47725d, 1000);
        background.setColorFilter(new PorterDuffColorFilter(this.f47725d.getResources().getColor(R.color.qui_common_overlay_standard_primary), PorterDuff.Mode.SRC_ATOP));
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_selected}, background);
        stateListDrawable.addState(new int[]{-33685832}, g16);
        view.setBackground(stateListDrawable);
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.qzone.homepage.ui.component.newpanel.PanelPopupAdapter.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (view == null) {
                    return false;
                }
                int action = motionEvent.getAction();
                if (action == 0) {
                    view.post(new Runnable() { // from class: com.qzone.homepage.ui.component.newpanel.PanelPopupAdapter.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            View view3 = view;
                            if (view3 != null) {
                                view3.setPressed(true);
                            }
                        }
                    });
                } else if (action == 1 || action == 3) {
                    view.post(new Runnable() { // from class: com.qzone.homepage.ui.component.newpanel.PanelPopupAdapter.5.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View view3 = view;
                            if (view3 != null) {
                                view3.setPressed(false);
                            }
                        }
                    });
                }
                return false;
            }
        };
        dVar.f47740a.setOnTouchListener(onTouchListener);
        dVar.f47741b.setOnTouchListener(onTouchListener);
    }

    public void t(ArrayList<HomePanelItem> arrayList) {
        if (arrayList == null) {
            return;
        }
        ArrayList<HomePanelItem> arrayList2 = this.D;
        if (arrayList2 == null) {
            this.D = new ArrayList<>();
        } else {
            arrayList2.clear();
        }
        this.D.addAll(arrayList);
    }

    protected void u(d dVar, int i3, HomePanelItem homePanelItem) {
        String a16;
        if (dVar == null || homePanelItem == null) {
            return;
        }
        if (TextUtils.isEmpty(homePanelItem.iconUrl)) {
            dVar.f47742c.setImageResource(homePanelItem.iconDrawableId);
        } else {
            dVar.f47742c.setAsyncImage(homePanelItem.iconUrl);
        }
        if (!TextUtils.isEmpty(homePanelItem.text)) {
            if (this.C) {
                x6.a aVar = this.E;
                if (aVar != null) {
                    a16 = com.qzone.util.l.a(aVar.gender == 1 ? R.string.oz_ : R.string.oz8);
                } else {
                    a16 = com.qzone.util.l.a(R.string.oza);
                }
            } else {
                a16 = com.qzone.util.l.a(R.string.oz9);
            }
            String replace = homePanelItem.text.replace("{gender}", a16);
            homePanelItem.text = replace;
            String replace2 = replace.replace("{uin}", String.valueOf(this.f47729i));
            homePanelItem.text = replace2;
            homePanelItem.text = replace2.replace("{loginuin}", String.valueOf(this.f47730m));
        }
        if (!TextUtils.isEmpty(homePanelItem.jumpUrl)) {
            String replace3 = homePanelItem.jumpUrl.replace("{uin}", String.valueOf(this.f47729i));
            homePanelItem.jumpUrl = replace3;
            String replace4 = replace3.replace("{hostuin}", String.valueOf(this.f47729i));
            homePanelItem.jumpUrl = replace4;
            String replace5 = replace4.replace("{loginuin}", String.valueOf(this.f47730m));
            homePanelItem.jumpUrl = replace5;
            homePanelItem.jumpUrl = replace5.replace("{qua}", QUA.getQUA3());
        }
        dVar.f47748i.setTag(Boolean.FALSE);
        dVar.f47743d.setText(homePanelItem.text);
    }

    protected void w(d dVar, int i3, HomePanelItem homePanelItem) {
        if (dVar == null || homePanelItem == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.f47741b.getLayoutParams();
        int i16 = this.F;
        if (i16 == 2) {
            if (homePanelItem.canEdit) {
                dVar.f47740a.setImageResource(R.drawable.qui_add_filled_feedback_normal);
                AccessibilityUtil.p(dVar.f47740a, com.qzone.util.l.a(R.string.f2201568c));
                dVar.f47740a.setVisibility(0);
            } else {
                dVar.f47740a.setVisibility(4);
            }
            layoutParams.setMargins(ar.e(12.0f), 0, 0, 0);
            dVar.f47747h.setVisibility(8);
        } else if (i16 == 3) {
            if (homePanelItem.canEdit) {
                dVar.f47740a.setImageResource(R.drawable.f13780s);
                AccessibilityUtil.p(dVar.f47740a, com.qzone.util.l.a(R.string.f2201968g));
                dVar.f47740a.setVisibility(0);
            } else {
                dVar.f47740a.setVisibility(4);
            }
            dVar.f47747h.setVisibility(8);
            layoutParams.setMargins(ar.e(12.0f), 0, 0, 0);
        } else {
            dVar.f47740a.setVisibility(8);
            dVar.f47747h.setVisibility(0);
            layoutParams.setMargins(0, 0, 0, 0);
        }
        dVar.f47740a.setTag(Integer.valueOf(i3));
        dVar.f47740a.setOnClickListener(new a());
    }

    public void y(d dVar, int i3, HomePanelItem homePanelItem) {
        RelativeLayout relativeLayout;
        if (dVar == null || homePanelItem == null) {
            return;
        }
        dVar.f47744e.setVisibility(8);
        dVar.f47746g.removeAllViews();
        dVar.f47746g.setVisibility(8);
        this.K.remove(dVar.f47746g);
        if (homePanelItem.showRed) {
            if (homePanelItem.tabId == 17) {
                v(dVar, homePanelItem);
            }
            ArrayList<RedInfo> arrayList = homePanelItem.redInfos;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            LayoutInflater from = LayoutInflater.from(this.f47725d);
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                RedInfo redInfo = arrayList.get(i16);
                if (redInfo != null) {
                    if (dVar.f47746g.getChildAt(i16) != null) {
                        relativeLayout = (RelativeLayout) dVar.f47746g.getChildAt(i16);
                    } else {
                        try {
                            relativeLayout = (RelativeLayout) from.inflate(R.layout.bg8, (ViewGroup) null);
                            dVar.f47746g.addView(relativeLayout);
                        } catch (InflateException unused) {
                            QZLog.e("PanelPopupAdapter", "jinqianli@PopupWindowPanelManager RedInfo layout inflate exception!");
                            return;
                        }
                    }
                    TextView textView = (TextView) relativeLayout.findViewById(R.id.kln);
                    String str = redInfo.summary;
                    if (!TextUtils.isEmpty(str) && str.length() > 5) {
                        str = str.substring(0, 5) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                    }
                    textView.setTextColor(this.I);
                    textView.setText(str);
                    AvatarImageView avatarImageView = (AvatarImageView) relativeLayout.findViewById(R.id.kll);
                    if (avatarImageView != null) {
                        long j3 = redInfo.uin;
                        if (j3 != 0) {
                            avatarImageView.j(j3);
                        } else {
                            avatarImageView.setAsyncImage(redInfo.logo);
                        }
                        avatarImageView.setVisibility(0);
                    }
                }
            }
            if (dVar.f47746g.getChildCount() > arrayList.size()) {
                dVar.f47746g.removeViews(arrayList.size(), dVar.f47746g.getChildCount() - arrayList.size());
            }
            if (dVar.f47746g.getChildCount() > 1 && arrayList.size() > 1) {
                dVar.f47746g.setAutoStart(true);
                dVar.f47746g.i();
            } else {
                dVar.f47746g.setAutoStart(false);
                dVar.f47746g.j();
            }
            dVar.f47746g.setVisibility(0);
            this.K.add(dVar.f47746g);
        }
    }

    public void A(d dVar, int i3, HomePanelItem homePanelItem) {
        int size;
        if (dVar == null || homePanelItem == null || this.E == null) {
            return;
        }
        dVar.f47745f.setVisibility(0);
        dVar.f47741b.setVisibility(0);
        dVar.f47748i.removeAllViews();
        dVar.f47748i.setVisibility(8);
        dVar.f47748i.setTag(Boolean.FALSE);
        if (homePanelItem.tabId != 7) {
            dVar.f47745f.setVisibility(0);
            return;
        }
        View g16 = e8.f.a().c().g(this.f47725d, this.f47729i, 1);
        x6.a aVar = this.E;
        int i16 = aVar.bgVoiceType;
        if (2 == i16) {
            ArrayList<BroadcastMusicInfo> arrayList = aVar.allFmBroadCastList;
            if (arrayList != null && arrayList.size() > 0) {
                size = this.E.allFmBroadCastList.size();
                e8.d c16 = e8.f.a().c();
                ArrayList<BroadcastMusicInfo> arrayList2 = this.E.allFmBroadCastList;
                int size2 = arrayList2.size();
                x6.a aVar2 = this.E;
                c16.a(g16, arrayList2, true, size2, aVar2.wifiAutoPlayFlag, aVar2.playMode, 2, aVar2.bgVoiceType, aVar2.loopPlaybackType);
            }
            size = 0;
        } else if (1 == i16) {
            ArrayList<UserMusicInfo> arrayList3 = aVar.allFmList;
            if (arrayList3 != null && arrayList3.size() > 0) {
                size = this.E.allFmList.size();
                e8.d c17 = e8.f.a().c();
                ArrayList<UserMusicInfo> arrayList4 = this.E.allFmList;
                int size3 = arrayList4.size();
                x6.a aVar3 = this.E;
                c17.h(g16, arrayList4, true, size3, aVar3.wifiAutoPlayFlag, aVar3.playMode, 2, aVar3.bgVoiceType, aVar3.loopPlaybackType);
            }
            size = 0;
        } else {
            ArrayList<UserMusicInfo> arrayList5 = aVar.allMusicList;
            if (arrayList5 != null && arrayList5.size() > 0) {
                size = this.E.allMusicList.size();
                e8.d c18 = e8.f.a().c();
                x6.a aVar4 = this.E;
                c18.h(g16, aVar4.allMusicList, aVar4.musicCanPlay, aVar4.allMusicNums, aVar4.wifiAutoPlayFlag, aVar4.playMode, 2, aVar4.bgVoiceType, aVar4.loopPlaybackType);
            }
            size = 0;
        }
        if (size > 0) {
            dVar.f47748i.setTag(Boolean.TRUE);
            dVar.f47748i.setVisibility(0);
            dVar.f47741b.setVisibility(8);
            dVar.f47748i.addView(g16);
            dVar.f47743d.setText(homePanelItem.text);
        } else {
            dVar.f47741b.setVisibility(0);
            dVar.f47748i.setVisibility(8);
            dVar.f47743d.setText(homePanelItem.text);
        }
        if (g16 != null) {
            ((TextView) g16.findViewById(R.id.f166643gu2)).setTextColor(this.H);
            ((TextView) g16.findViewById(R.id.gu6)).setTextColor(this.I);
            g16.findViewById(R.id.klo).setVisibility(8);
        }
    }
}

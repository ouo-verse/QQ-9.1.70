package com.tencent.mobileqq.activity.weather;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.messageclean.ak;
import com.tencent.mobileqq.app.message.messageclean.u;
import com.tencent.mobileqq.app.message.messageclean.v;
import com.tencent.mobileqq.app.message.messageclean.w;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chathistory.api.IChatHistoryApi;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b extends com.tencent.mobileqq.adapter.c implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private ArrayList<com.tencent.mobileqq.app.message.messageclean.g> C;
    private QQAppInterface D;
    private ak E;
    private Bitmap F;
    private View G;
    private final boolean H;
    private boolean I;
    private final View.OnClickListener J;

    /* renamed from: i, reason: collision with root package name */
    private final Context f186647i;

    /* renamed from: m, reason: collision with root package name */
    private HashMap<Long, ArrayList<com.tencent.mobileqq.app.message.messageclean.g>> f186648m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 1) {
                Object tag = view.getTag();
                if (!(tag instanceof c)) {
                    return true;
                }
                c cVar = (c) tag;
                if (b.this.q(motionEvent.getX(), motionEvent.getY())) {
                    b.this.t(cVar.f186652a);
                    ((com.tencent.mobileqq.adapter.c) b.this).f187153f.setSelection(cVar.f186652a);
                } else {
                    b.this.E.q2((com.tencent.mobileqq.app.message.messageclean.g) b.this.getGroup(cVar.f186652a));
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.weather.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class ViewOnClickListenerC7215b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.app.message.messageclean.h f186650d;

        ViewOnClickListenerC7215b(com.tencent.mobileqq.app.message.messageclean.h hVar) {
            this.f186650d = hVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) hVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                IChatHistoryApi iChatHistoryApi = (IChatHistoryApi) QRoute.api(IChatHistoryApi.class);
                Context context = view.getContext();
                com.tencent.mobileqq.app.message.messageclean.h hVar = this.f186650d;
                iChatHistoryApi.jumpChatHistoryCategoryActivity(context, new com.tencent.qqnt.chathistory.api.a(hVar.f196217b, hVar.f196222g, hVar.f196218c, 1));
                StorageReport.k().y();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f186652a;

        /* renamed from: b, reason: collision with root package name */
        public CheckBox f186653b;

        /* renamed from: c, reason: collision with root package name */
        public QQProAvatarView f186654c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f186655d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f186656e;

        /* renamed from: f, reason: collision with root package name */
        public TextView f186657f;

        /* renamed from: g, reason: collision with root package name */
        public CheckBox f186658g;

        /* renamed from: h, reason: collision with root package name */
        public LinearLayout f186659h;

        /* renamed from: i, reason: collision with root package name */
        public View f186660i;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f186661a;

        /* renamed from: b, reason: collision with root package name */
        public int f186662b;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public b(Context context, QQAppInterface qQAppInterface, ExpandableListView expandableListView, ak akVar) {
        super(context, qQAppInterface, expandableListView);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, expandableListView, akVar);
            return;
        }
        this.I = false;
        this.J = new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.weather.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.this.r(view);
            }
        };
        this.f186647i = context;
        this.f186648m = akVar.getRepository().m();
        this.C = akVar.getRepository().o();
        this.D = qQAppInterface;
        this.E = akVar;
        this.F = BaseImageUtil.getDefaultFaceBitmap();
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101382", false);
        this.H = isSwitchOn;
        this.I = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("proavatar_clear_list_load_switch", false);
        QLog.d("SessionCleanListAdapter", 1, "SessionCleanListAdapter useNewLoading: " + isSwitchOn + ", loadBaseAvatarSwitch: " + this.I);
    }

    private void j(com.tencent.mobileqq.app.message.messageclean.g gVar, c cVar, boolean z16) {
        int i3;
        int i16 = gVar.f196216a;
        if (i16 != 10003 && i16 != 10004) {
            QLog.i("SessionCleanListAdapter", 1, "bindData entry : type " + gVar.f196216a + " invalid");
            return;
        }
        if (i16 == 10003) {
            w wVar = (w) gVar;
            cVar.f186655d.setVisibility(0);
            cVar.f186658g.setVisibility(0);
            cVar.f186660i.setVisibility(8);
            cVar.f186660i.setOnClickListener(null);
            if (QQTheme.isNowThemeIsNight()) {
                i3 = R.drawable.jns;
            } else {
                i3 = R.drawable.jnr;
            }
            cVar.f186655d.setImageResource(i3);
            if (wVar.f196256j == null) {
                wVar.f196256j = ((IQQGuildAvatarApi) this.D.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(wVar.f196255i, 100, 100, (String) null);
                QLog.i("SessionCleanListAdapter", 4, "bindData guild uid: " + wVar.f196253g + " load guildIconDrawable");
            }
            cVar.f186654c.setImageDrawable(wVar.f196256j);
            if (!z16) {
                cVar.f186659h.setTag(Integer.valueOf(cVar.f186652a));
                cVar.f186659h.setOnClickListener(this.J);
            }
            VideoReport.setElementId(cVar.f186659h, "em_bas_expansion_channel");
        } else {
            com.tencent.mobileqq.app.message.messageclean.h hVar = (com.tencent.mobileqq.app.message.messageclean.h) gVar;
            cVar.f186655d.setVisibility(8);
            cVar.f186658g.setVisibility(8);
            cVar.f186659h.setOnClickListener(null);
            QLog.i("SessionCleanListAdapter", 4, "bindData uin: " + hVar.f196223h + " + type: " + hVar.f196224i + " loadBasicMsgHeader");
            int i17 = hVar.f196224i;
            if (i17 != 6000 && i17 != 6003 && i17 != 6005) {
                s(hVar.f196223h, i17, cVar);
                if (this.H) {
                    cVar.f186660i.setVisibility(0);
                    cVar.f186660i.setOnClickListener(new ViewOnClickListenerC7215b(hVar));
                } else {
                    cVar.f186660i.setVisibility(8);
                    cVar.f186660i.setOnClickListener(null);
                }
            } else {
                cVar.f186654c.setImageResource(l(hVar.f196222g));
                cVar.f186660i.setVisibility(8);
                cVar.f186660i.setOnClickListener(null);
            }
        }
        cVar.f186656e.setText(gVar.f196218c);
        cVar.f186657f.setText(gVar.f196219d);
        cVar.f186653b.setChecked(gVar.f196220e);
        cVar.f186658g.setChecked(this.f187153f.isGroupExpanded(cVar.f186652a));
    }

    private void k(c cVar, @NonNull View view) {
        cVar.f186653b = (CheckBox) view.findViewById(R.id.axa);
        cVar.f186654c = (QQProAvatarView) view.findViewById(R.id.icon);
        cVar.f186655d = (ImageView) view.findViewById(R.id.wim);
        cVar.f186656e = (TextView) view.findViewById(R.id.jfk);
        cVar.f186657f = (TextView) view.findViewById(R.id.f94925dl);
        cVar.f186658g = (CheckBox) view.findViewById(R.id.dv_);
        cVar.f186659h = (LinearLayout) view.findViewById(R.id.f75663zk);
        cVar.f186660i = view.findViewById(R.id.svw);
        view.setTag(cVar);
    }

    private int l(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1834626455:
                if (str.equals(PeerUid.DATALINE_PHONE_UID)) {
                    c16 = 0;
                    break;
                }
                break;
            case -1656358474:
                if (str.equals(PeerUid.DATALINE_PAD_UID)) {
                    c16 = 1;
                    break;
                }
                break;
            case 1930502276:
                if (str.equals(PeerUid.DATALINE_PC_UID)) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return R.drawable.qfile_dataline_user_aio;
            case 1:
                return R.drawable.qfile_dataline_ipad_recent;
            case 2:
                return R.drawable.qfile_dataline_pc_recent;
            default:
                return 0;
        }
    }

    private List<com.tencent.mobileqq.app.message.messageclean.g> m(int i3) {
        long j3;
        com.tencent.mobileqq.app.message.messageclean.g gVar = (com.tencent.mobileqq.app.message.messageclean.g) getGroup(i3);
        if (gVar.f196216a == 10004) {
            j3 = Long.parseLong(((com.tencent.mobileqq.app.message.messageclean.h) gVar).f196223h);
        } else {
            j3 = ((w) gVar).f196253g;
        }
        return this.f186648m.get(Long.valueOf(j3));
    }

    private View n(int i3, int i16, View view, int i17) {
        SessionCleanCategoryItemView sessionCleanCategoryItemView;
        if (view == null) {
            sessionCleanCategoryItemView = new SessionCleanCategoryItemView(this.f186647i);
            sessionCleanCategoryItemView.setTag(new d());
        } else {
            sessionCleanCategoryItemView = (SessionCleanCategoryItemView) view;
        }
        sessionCleanCategoryItemView.a((com.tencent.mobileqq.app.message.messageclean.g) getChild(i3, i16));
        return sessionCleanCategoryItemView;
    }

    @NonNull
    private View o(int i3, int i16, View view, int i17) {
        e eVar;
        SessionCleanChannelItemView sessionCleanChannelItemView;
        if (view == null) {
            sessionCleanChannelItemView = new SessionCleanChannelItemView(this.f186647i);
            eVar = new e();
            sessionCleanChannelItemView.setOnClickListener(this);
            sessionCleanChannelItemView.setTag(eVar);
        } else {
            eVar = (e) view.getTag();
            sessionCleanChannelItemView = (SessionCleanChannelItemView) view;
        }
        eVar.f186661a = i3;
        eVar.f186662b = i16;
        sessionCleanChannelItemView.a((com.tencent.mobileqq.app.message.messageclean.g) getChild(i3, i16));
        return sessionCleanChannelItemView;
    }

    private int p(int i3, int i16) {
        int i17 = ((com.tencent.mobileqq.app.message.messageclean.g) getChild(i3, i16)).f196216a;
        if (i17 == 10001) {
            return 0;
        }
        if (i17 == 10002) {
            return 1;
        }
        QLog.e("SessionCleanListAdapter", 1, "innerGetChildType groupPosition: " + i3 + " childPosition: " + i16 + " type invalid");
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(float f16, float f17) {
        int dip2px = ScreenUtil.dip2px(104.0f);
        int dip2px2 = (ScreenUtil.dip2px(68.0f) - ScreenUtil.dip2px(20.0f)) - (ScreenUtil.dip2px(6.0f) * 2);
        int dip2px3 = ScreenUtil.dip2px(68.0f);
        int dip2px4 = ScreenUtil.dip2px(68.0f) + dip2px + ScreenUtil.dip2px(20.0f);
        if (f16 >= dip2px && f16 <= dip2px4 && f17 >= dip2px2 && f17 <= dip2px3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            Integer num = (Integer) tag;
            u(view, num.intValue());
            t(num.intValue());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void s(String str, int i3, c cVar) {
        QQProAvatarDrawable qQProAvatarDrawable;
        QLog.i("SessionCleanListAdapter", 4, "loadBasicMsgHeader  uin: " + str + " type: " + i3 + " load start ");
        if (this.I) {
            Drawable drawable = cVar.f186654c.s().getDrawable();
            if (drawable instanceof QQProAvatarDrawable) {
                qQProAvatarDrawable = (QQProAvatarDrawable) drawable;
            } else {
                qQProAvatarDrawable = new QQProAvatarDrawable();
                cVar.f186654c.setImageDrawable(qQProAvatarDrawable);
            }
            if (i3 != 0 && i3 != 1000 && i3 != 1004) {
                if (i3 == 1) {
                    qQProAvatarDrawable.q(this.f186647i, 4, str);
                    return;
                } else {
                    if (i3 == 3000) {
                        qQProAvatarDrawable.q(this.f186647i, 101, str);
                        return;
                    }
                    return;
                }
            }
            qQProAvatarDrawable.q(this.f186647i, 1, str);
            return;
        }
        if (i3 != 0 && i3 != 1000 && i3 != 1004) {
            if (i3 == 1) {
                cVar.f186654c.w(4, str);
                return;
            } else {
                if (i3 == 3000) {
                    cVar.f186654c.w(101, str);
                    return;
                }
                return;
            }
        }
        cVar.f186654c.w(1, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i3) {
        if (this.f187153f.isGroupExpanded(i3)) {
            this.f187153f.collapseGroup(i3);
        } else {
            this.f187153f.expandGroup(i3);
        }
    }

    private void u(View view, int i3) {
        com.tencent.mobileqq.app.message.messageclean.g gVar = (com.tencent.mobileqq.app.message.messageclean.g) getGroup(i3);
        if (gVar.f196216a != 10003) {
            QLog.i("SessionCleanListAdapter", 4, "reportIndicateEvent itemType is not GuildType ignore");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_channel_id", Long.valueOf(((w) gVar).f196253g));
        VideoReport.reportEvent("dt_clck", view, hashMap);
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public void configHeaderView(View view, int i3) {
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) view, i3);
            return;
        }
        if (view == null) {
            return;
        }
        if (((c) view.getTag()) == null) {
            cVar = new c();
            k(cVar, view);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.f186652a = i3;
        j((com.tencent.mobileqq.app.message.messageclean.g) getGroup(i3), cVar, true);
    }

    @Override // com.tencent.mobileqq.adapter.c
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            super.destroy();
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return m(i3).get(i16);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16))).longValue();
        }
        Object child = getChild(i3, i16);
        if (child instanceof v) {
            return ((v) child).f196250i;
        }
        if (child instanceof u) {
            return ((u) child).f196246g;
        }
        QLog.e("SessionCleanListAdapter", 1, "getChildId groupPosition: " + i3 + " childPosition: " + i16 + " type invalid");
        return 0L;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildType(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return p(i3, i16);
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (View) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), view, viewGroup);
        }
        int p16 = p(i3, i16);
        if (p16 != 0 && p16 != 1) {
            QLog.e("SessionCleanListAdapter", 1, "getChildView childType invalid  : " + p16);
            return view;
        }
        if (p16 == 0) {
            return o(i3, i16, view, p16);
        }
        return n(i3, i16, view, p16);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, i3)).intValue();
        }
        if (m(i3) == null) {
            return 0;
        }
        return m(i3).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
        return this.C.get(i3);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.C.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this, i3)).longValue();
        }
        return 0L;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (View) iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Boolean.valueOf(z16), view, viewGroup);
        }
        if (view != null) {
            cVar = (c) view.getTag();
        } else {
            view = LayoutInflater.from(this.f186647i).inflate(R.layout.hq5, viewGroup, false);
            cVar = new c();
            k(cVar, view);
            view.setOnClickListener(this);
        }
        cVar.f186652a = i3;
        j((com.tencent.mobileqq.app.message.messageclean.g) getGroup(i3), cVar, false);
        return view;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public int getHeaderViewLayoutResourceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return R.layout.hq5;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.ExpandableListAdapter
    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.C.isEmpty();
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public boolean needHideBackgroundGroup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) view);
        } else {
            Object tag = view.getTag();
            if (tag instanceof c) {
                c cVar = (c) tag;
                QLog.d("SessionCleanListAdapter", 1, "getGroupCount is " + getGroupCount() + " ,groupIndex is " + cVar.f186652a);
                if (getGroupCount() > cVar.f186652a && getGroupCount() != 0) {
                    this.E.q2((com.tencent.mobileqq.app.message.messageclean.g) getGroup(cVar.f186652a));
                } else {
                    QLog.d("SessionCleanListAdapter", 1, "cause IndexOutOfBoundsException");
                }
            } else if (tag instanceof e) {
                e eVar = (e) tag;
                this.E.q2((com.tencent.mobileqq.app.message.messageclean.g) getChild(eVar.f186661a, eVar.f186662b));
            } else {
                QLog.i("SessionCleanListAdapter", 1, "onClick  view tag invalid");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.E.j2();
        }
    }

    public void w(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else {
            this.G = view;
            view.setOnTouchListener(new a());
        }
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.E.k2();
        }
    }
}

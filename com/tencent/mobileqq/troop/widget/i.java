package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class i implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    protected HashMap<Integer, c> C;
    long D;
    int E;

    /* renamed from: d, reason: collision with root package name */
    protected Context f302551d;

    /* renamed from: e, reason: collision with root package name */
    protected QQAppInterface f302552e;

    /* renamed from: f, reason: collision with root package name */
    protected SessionInfo f302553f;

    /* renamed from: h, reason: collision with root package name */
    protected Drawable f302554h;

    /* renamed from: i, reason: collision with root package name */
    protected Drawable f302555i;

    /* renamed from: m, reason: collision with root package name */
    protected Drawable f302556m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends c {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.troop.widget.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        class C8836a extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            ImageView f302558d;

            /* renamed from: e, reason: collision with root package name */
            TextView f302559e;

            /* renamed from: f, reason: collision with root package name */
            TextView f302560f;

            /* renamed from: g, reason: collision with root package name */
            LinearLayout f302561g;

            C8836a() {
                super();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }
        }

        a() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x022a  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x023a  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x02f6  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0247  */
        @Override // com.tencent.mobileqq.troop.widget.i.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected View b(View view, TroopFeedItem troopFeedItem, int i3, boolean z16) {
            View view2;
            Drawable drawable;
            boolean z17;
            int i16;
            int i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, this, view, troopFeedItem, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
            if (view == null) {
                view2 = LayoutInflater.from(i.this.f302551d).inflate(R.layout.ah8, (ViewGroup) null);
            } else {
                view2 = view;
            }
            C8836a c8836a = (C8836a) view2.getTag();
            if (c8836a == null) {
                c8836a = new C8836a();
                c8836a.f302558d = (ImageView) view2.findViewById(R.id.pic);
                c8836a.f302559e = (TextView) view2.findViewById(R.id.title);
                c8836a.f302560f = (TextView) view2.findViewById(R.id.content);
                c8836a.f302561g = (LinearLayout) view2.findViewById(R.id.f163841a5);
                view2.setOnClickListener(i.this);
                view2.setTag(c8836a);
            }
            c8836a.f302564b = i3;
            c8836a.f302563a = troopFeedItem;
            c8836a.f302559e.setSingleLine(false);
            c8836a.f302559e.setMaxLines(2);
            c8836a.f302559e.setText("[" + troopFeedItem.tag + "] " + troopFeedItem.title);
            c8836a.f302558d.setVisibility(0);
            c8836a.f302561g.setVisibility(8);
            c8836a.f302560f.setVisibility(0);
            c8836a.f302560f.setSingleLine(false);
            c8836a.f302560f.setMaxLines(2);
            c8836a.f302560f.setText("");
            c8836a.f302558d.setBackgroundDrawable(null);
            c8836a.f302558d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            String str = HardCodeUtil.qqStr(R.string.ue_) + troopFeedItem.tag + " " + troopFeedItem.title;
            int i18 = troopFeedItem.type;
            if (i18 == 5) {
                i iVar = i.this;
                if (iVar.f302555i == null) {
                    iVar.f302555i = iVar.f302551d.getResources().getDrawable(R.drawable.e1m);
                }
                drawable = i.this.f302555i;
            } else if (i18 == 132) {
                i iVar2 = i.this;
                if (iVar2.f302556m == null) {
                    iVar2.f302556m = iVar2.f302551d.getResources().getDrawable(R.drawable.e1o);
                }
                drawable = i.this.f302556m;
            } else {
                i iVar3 = i.this;
                if (iVar3.f302554h == null) {
                    iVar3.f302554h = iVar3.f302551d.getResources().getDrawable(R.drawable.e1m);
                }
                drawable = i.this.f302554h;
            }
            if (!StringUtil.isEmpty(troopFeedItem.picPath)) {
                try {
                    int f16 = BaseAIOUtils.f(61.0f, i.this.f302551d.getResources());
                    String str2 = troopFeedItem.picPath;
                    Drawable drawable2 = i.this.f302554h;
                    drawable = URLDrawable.getDrawable(str2, f16, f16, drawable2, drawable2);
                } catch (IllegalArgumentException unused) {
                }
            }
            if (troopFeedItem.isStoryType() || ((i17 = troopFeedItem.type) != 5 && i17 != 19 && i17 != 99)) {
                if (!StringUtil.isEmpty(troopFeedItem.publishUin)) {
                    str = str + " " + troopFeedItem.publishUin;
                    ((TextView) c8836a.f302561g.findViewById(R.id.nickname)).setText(troopFeedItem.publishUin);
                }
                if (!StringUtil.isEmpty(troopFeedItem.feedTime)) {
                    try {
                        String str3 = HardCodeUtil.qqStr(R.string.uec) + com.tencent.mobileqq.troop.data.m.a(Long.parseLong(troopFeedItem.feedTime));
                        ((TextView) c8836a.f302561g.findViewById(R.id.f163840a4)).setText(str3);
                        str = str + str3;
                        z17 = true;
                    } catch (NumberFormatException unused2) {
                        if (QLog.isColorLevel()) {
                            QLog.e("TroopFeedViewFactory", 2, "item.feedTime:" + troopFeedItem.feedTime);
                        }
                    }
                    if (z17) {
                        c8836a.f302561g.setVisibility(0);
                        c8836a.f302560f.setVisibility(8);
                    }
                    i16 = troopFeedItem.type;
                    if (i16 != 131) {
                        c8836a.f302558d.setImageResource(FileManagerUtil.getFileIconResId(troopFeedItem.title));
                    } else if (i16 != 5 && i16 != 19) {
                        if (i16 != 133 && i16 != 18 && i16 != 0) {
                            if (i16 == 12) {
                                c8836a.f302558d.setImageResource(R.drawable.e1r);
                            } else if (i16 != 10 && i16 != 132) {
                                if (troopFeedItem.orginType == 99) {
                                    c8836a.f302558d.setImageDrawable(drawable);
                                    c8836a.f302560f.setText(troopFeedItem.content);
                                    if (!troopFeedItem.tag.equals(HardCodeUtil.qqStr(R.string.ue7))) {
                                        c8836a.f302559e.setSingleLine(true);
                                        c8836a.f302559e.setMaxLines(1);
                                    }
                                    str = str + " " + troopFeedItem.content;
                                }
                            } else {
                                c8836a.f302558d.setScaleType(ImageView.ScaleType.CENTER);
                                c8836a.f302558d.setBackgroundDrawable(drawable);
                                c8836a.f302558d.setImageResource(R.drawable.e1q);
                            }
                        } else {
                            c8836a.f302558d.setImageDrawable(drawable);
                        }
                    } else {
                        c8836a.f302558d.setImageDrawable(drawable);
                        c8836a.f302560f.setText(troopFeedItem.content);
                        c8836a.f302559e.setSingleLine(true);
                        c8836a.f302559e.setMaxLines(1);
                        str = str + " " + troopFeedItem.content;
                    }
                    if (!z16) {
                        str = str + " " + HardCodeUtil.qqStr(R.string.ued);
                    }
                    view2.setContentDescription(str);
                    return view2;
                }
            }
            z17 = false;
            if (z17) {
            }
            i16 = troopFeedItem.type;
            if (i16 != 131) {
            }
            if (!z16) {
            }
            view2.setContentDescription(str);
            return view2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        TroopFeedItem f302563a;

        /* renamed from: b, reason: collision with root package name */
        int f302564b;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public abstract class c {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        public View a(TroopFeedItem troopFeedItem, int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, this, troopFeedItem, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
            return b(null, troopFeedItem, i3, z16);
        }

        protected abstract View b(View view, TroopFeedItem troopFeedItem, int i3, boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d extends c {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes19.dex */
        class a extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            ImageView f302568d;

            /* renamed from: e, reason: collision with root package name */
            TextView f302569e;

            /* renamed from: f, reason: collision with root package name */
            LinearLayout f302570f;

            /* renamed from: g, reason: collision with root package name */
            TextView f302571g;

            /* renamed from: h, reason: collision with root package name */
            TextView f302572h;

            a() {
                super();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
                }
            }
        }

        d() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.widget.i.c
        protected View b(View view, TroopFeedItem troopFeedItem, int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, this, view, troopFeedItem, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
            if (view == null) {
                view = LayoutInflater.from(i.this.f302551d).inflate(R.layout.ah9, (ViewGroup) null);
            }
            a aVar = (a) view.getTag();
            if (aVar == null) {
                aVar = new a();
                aVar.f302568d = (ImageView) view.findViewById(R.id.pic);
                aVar.f302569e = (TextView) view.findViewById(R.id.title);
                aVar.f302570f = (LinearLayout) view.findViewById(R.id.l0a);
                aVar.f302571g = (TextView) view.findViewById(R.id.l0d);
                aVar.f302572h = (TextView) view.findViewById(R.id.l0e);
                view.setOnClickListener(i.this);
                view.setTag(aVar);
            }
            aVar.f302564b = i3;
            aVar.f302563a = troopFeedItem;
            aVar.f302569e.setText("[" + troopFeedItem.tag + "] " + troopFeedItem.title);
            aVar.f302571g.setText(troopFeedItem.content);
            aVar.f302570f.setVisibility(0);
            String str = HardCodeUtil.qqStr(R.string.ue9) + troopFeedItem.tag + " " + troopFeedItem.title + " " + troopFeedItem.content;
            if (!StringUtil.isEmpty(troopFeedItem.ex_1)) {
                aVar.f302572h.setText(troopFeedItem.ex_1);
                str = str + " " + troopFeedItem.ex_1;
            } else {
                aVar.f302570f.setVisibility(8);
            }
            aVar.f302568d.setImageResource(R.drawable.e1r);
            if (!z16) {
                str = str + " " + HardCodeUtil.qqStr(R.string.ue5);
            }
            view.setContentDescription(str);
            return view;
        }
    }

    protected c a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (c) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                return new a();
            }
            return new d();
        }
        return new a();
    }

    protected int b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
        }
        return 0;
    }

    public View c(TroopFeedItem troopFeedItem, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, troopFeedItem, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        if (this.C.get(2) != null) {
            return null;
        }
        int b16 = b(troopFeedItem.type);
        c cVar = this.C.get(Integer.valueOf(b16));
        if (cVar == null) {
            cVar = a(b16);
            this.C.put(Integer.valueOf(b16), cVar);
        }
        if (cVar == null) {
            return null;
        }
        return cVar.a(troopFeedItem, i3, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        Object tag;
        TroopFeedItem troopFeedItem;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            view.getTag();
            if (SystemClock.uptimeMillis() - this.D >= this.E) {
                this.D = SystemClock.uptimeMillis();
                Intent intent = new Intent(this.f302551d, (Class<?>) QQBrowserActivity.class);
                TroopInfo k3 = ((TroopManager) this.f302552e.getManager(QQManagerFactory.TROOP_MANAGER)).k(this.f302553f.f179557e);
                String currentAccountUin = this.f302552e.getCurrentAccountUin();
                if (k3 != null && currentAccountUin != null) {
                    if (k3.isOwner()) {
                        i3 = 0;
                    } else if (k3.isOwnerOrAdmin()) {
                        i3 = 1;
                    }
                    intent.putExtra("url", String.format("https://web.qun.qq.com/qqweb/m/qun/notification/index.html?gc=%s&role=%d&_bid=2223&_wv=1031", this.f302553f.f179557e, Integer.valueOf(i3)));
                    this.f302551d.startActivity(intent);
                    tag = view.getTag();
                    if ((tag instanceof b) && (troopFeedItem = ((b) tag).f302563a) != null && troopFeedItem.isStoryType()) {
                        ReportController.o(this.f302552e, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_story_pgc", 0, 0, this.f302553f.f179557e, "", "", "");
                    }
                }
                i3 = 2;
                intent.putExtra("url", String.format("https://web.qun.qq.com/qqweb/m/qun/notification/index.html?gc=%s&role=%d&_bid=2223&_wv=1031", this.f302553f.f179557e, Integer.valueOf(i3)));
                this.f302551d.startActivity(intent);
                tag = view.getTag();
                if (tag instanceof b) {
                    ReportController.o(this.f302552e, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_story_pgc", 0, 0, this.f302553f.f179557e, "", "", "");
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}

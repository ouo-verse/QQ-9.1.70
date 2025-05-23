package com.tencent.mobileqq.troopgift;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.NTPanelEntrance;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troopgift.e;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.helper.TroopBirthGiftHelper;
import com.tencent.qqnt.aio.helper.ee;
import com.tencent.trpcprotocol.qqva.va_group_gift.service.GroupGiftBirth$BirthBless;
import com.tencent.trpcprotocol.qqva.va_group_gift.service.GroupGiftBirth$UserBirth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends PopupWindow {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Activity f302829a;

    /* renamed from: b, reason: collision with root package name */
    private GridView f302830b;

    /* renamed from: c, reason: collision with root package name */
    private List<c> f302831c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<String> f302832d;

    /* renamed from: e, reason: collision with root package name */
    private CardView f302833e;

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f302834f;

    /* renamed from: g, reason: collision with root package name */
    private String f302835g;

    /* renamed from: h, reason: collision with root package name */
    private Handler f302836h;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            c cVar = (c) message.obj;
            if (cVar == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("to_uin", cVar.f302840b);
            TroopBirthGiftHelper.Companion companion = TroopBirthGiftHelper.INSTANCE;
            hashMap.put("birthday_time", companion.h(cVar.f302842d));
            companion.p("19", "avatar", "", "4", 101, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                e.this.t();
                HashMap hashMap = new HashMap();
                hashMap.put("receiver_uin", no0.a.a(",", e.this.f302832d));
                TroopBirthGiftHelper.INSTANCE.p("19", "send", "", "4", 102, hashMap);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f302839a;

        /* renamed from: b, reason: collision with root package name */
        String f302840b;

        /* renamed from: c, reason: collision with root package name */
        String f302841c;

        /* renamed from: d, reason: collision with root package name */
        String f302842d;

        /* renamed from: e, reason: collision with root package name */
        boolean f302843e;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f302839a = false;
                this.f302843e = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes19.dex */
        class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f302845d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f302846e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f302847f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ HashMap f302848h;

            a(int i3, int i16, b bVar, HashMap hashMap) {
                this.f302845d = i3;
                this.f302846e = i16;
                this.f302847f = bVar;
                this.f302848h = hashMap;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, d.this, Integer.valueOf(i3), Integer.valueOf(i16), bVar, hashMap);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3;
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    c cVar = (c) e.this.f302831c.get(this.f302845d);
                    boolean z16 = true;
                    cVar.f302843e = !cVar.f302843e;
                    e.this.f302831c.set(this.f302845d, cVar);
                    if (cVar.f302843e) {
                        if (!e.this.f302832d.contains(cVar.f302840b)) {
                            if (e.this.f302832d.size() >= this.f302846e) {
                                QQToast.makeText(e.this.f302829a, 0, e.this.f302829a.getString(R.string.f2335777m, Integer.valueOf(this.f302846e)), 4000).show();
                            } else {
                                e.this.f302832d.add(cVar.f302840b);
                            }
                        }
                    } else {
                        e.this.f302832d.remove(cVar.f302840b);
                    }
                    ImageView imageView = this.f302847f.f302853d;
                    Resources resources = e.this.f302829a.getResources();
                    if (cVar.f302843e) {
                        i3 = R.drawable.f161905ni2;
                    } else {
                        i3 = R.drawable.f161906ni3;
                    }
                    imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, i3, null));
                    CardView cardView = e.this.f302833e;
                    if (e.this.f302832d.size() <= 0) {
                        z16 = false;
                    }
                    cardView.setClickable(z16);
                    if (e.this.f302832d.size() > 0) {
                        e.this.f302833e.setCardBackgroundColor(Color.parseColor("#0099FF"));
                    } else {
                        e.this.f302833e.setCardBackgroundColor(Color.parseColor("#80CCFF"));
                    }
                    this.f302848h.put("to_uin", cVar.f302840b);
                    HashMap hashMap = this.f302848h;
                    TroopBirthGiftHelper.Companion companion = TroopBirthGiftHelper.INSTANCE;
                    hashMap.put("birthday_time", companion.h(cVar.f302842d));
                    companion.p("19", "avatar", "", "4", 102, this.f302848h);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes19.dex */
        class b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            ImageView f302850a;

            /* renamed from: b, reason: collision with root package name */
            TextView f302851b;

            /* renamed from: c, reason: collision with root package name */
            TextView f302852c;

            /* renamed from: d, reason: collision with root package name */
            ImageView f302853d;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
                }
            }
        }

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(c cVar, TroopMemberInfo troopMemberInfo) {
            String str;
            if (troopMemberInfo != null) {
                if (TextUtils.isEmpty(troopMemberInfo.friendnick)) {
                    str = troopMemberInfo.troopnick;
                } else {
                    str = troopMemberInfo.friendnick;
                }
                if (!TextUtils.isEmpty(str)) {
                    cVar.f302841c = str;
                }
            }
            if (!e.this.f302831c.contains(cVar)) {
                e.this.f302831c.add(cVar);
            }
        }

        private void c(c cVar) {
            Message message = new Message();
            message.what = cVar.f302840b.hashCode();
            e.this.f302836h.removeMessages(message.what);
            message.obj = cVar;
            e.this.f302836h.sendMessageDelayed(message, 5000L);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return e.this.f302831c.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            b bVar;
            int i16;
            int i17;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                HashMap hashMap = new HashMap();
                if (view == null) {
                    bVar = new b();
                    view2 = LayoutInflater.from(e.this.f302829a).inflate(R.layout.h5l, (ViewGroup) e.this.f302830b, false);
                    bVar.f302850a = (ImageView) view2.findViewById(R.id.a2o);
                    bVar.f302851b = (TextView) view2.findViewById(R.id.nickname);
                    bVar.f302852c = (TextView) view2.findViewById(R.id.f164612aa0);
                    bVar.f302853d = (ImageView) view2.findViewById(R.id.f166842im2);
                    view2.setTag(bVar);
                    view2.setOnClickListener(new a(i3, 5, bVar, hashMap));
                } else {
                    view2 = view;
                    bVar = (b) view.getTag();
                }
                TextView textView = bVar.f302851b;
                int i18 = -1;
                if (QQTheme.isNowThemeIsNight()) {
                    i16 = -1;
                } else {
                    i16 = -16777216;
                }
                textView.setTextColor(i16);
                TextView textView2 = bVar.f302852c;
                if (!QQTheme.isNowThemeIsNight()) {
                    i18 = -16777216;
                }
                textView2.setTextColor(i18);
                c cVar = (c) e.this.f302831c.get(i3);
                bVar.f302850a.setImageDrawable(FaceDrawable.getFaceDrawable(e.this.f302834f, 1, cVar.f302840b));
                bVar.f302851b.setText(cVar.f302841c);
                bVar.f302852c.setText(cVar.f302842d);
                ImageView imageView = bVar.f302853d;
                Resources resources = e.this.f302829a.getResources();
                if (cVar.f302843e) {
                    i17 = R.drawable.f161905ni2;
                } else {
                    i17 = R.drawable.f161906ni3;
                }
                imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, i17, null));
                c(cVar);
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        public void setData(List<GroupGiftBirth$UserBirth> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
                return;
            }
            e.this.f302831c.clear();
            String currentAccountUin = e.this.f302834f.getCurrentAccountUin();
            for (GroupGiftBirth$UserBirth groupGiftBirth$UserBirth : list) {
                if (!TextUtils.equals(currentAccountUin, groupGiftBirth$UserBirth.uid.get())) {
                    ITroopMemberInfoService iTroopMemberInfoService = (ITroopMemberInfoService) e.this.f302834f.getRuntimeService(ITroopMemberInfoService.class, "");
                    final c cVar = new c();
                    cVar.f302840b = groupGiftBirth$UserBirth.uid.get();
                    cVar.f302842d = e.this.r(groupGiftBirth$UserBirth);
                    cVar.f302843e = false;
                    cVar.f302839a = e.this.q(groupGiftBirth$UserBirth);
                    cVar.f302841c = groupGiftBirth$UserBirth.uid.get();
                    e.this.f302831c.add(cVar);
                    iTroopMemberInfoService.getTroopMemberInfoAsync(e.this.f302835g, groupGiftBirth$UserBirth.uid.get(), "PickBirthFriendsPanel", new ITroopMemberInfoService.a() { // from class: com.tencent.mobileqq.troopgift.f
                        @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
                        public final void a(TroopMemberInfo troopMemberInfo) {
                            e.d.this.b(cVar, troopMemberInfo);
                        }
                    });
                    if (!e.this.f302831c.contains(cVar)) {
                        e.this.f302831c.add(cVar);
                    }
                }
            }
            e.this.o();
            e.this.v();
        }
    }

    public e(Activity activity, String str) {
        super(activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) str);
            return;
        }
        this.f302831c = new ArrayList();
        this.f302832d = new ArrayList<>();
        this.f302836h = new a();
        this.f302834f = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        this.f302829a = activity;
        this.f302835g = str;
    }

    private int n() {
        int screenWidth = (ViewUtils.getScreenWidth() - this.f302830b.getPaddingLeft()) - this.f302830b.getPaddingRight();
        int requestedHorizontalSpacing = this.f302830b.getRequestedHorizontalSpacing();
        return (screenWidth + requestedHorizontalSpacing) / (requestedHorizontalSpacing + this.f302830b.getRequestedColumnWidth());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        int min = Math.min(this.f302831c.size(), 4);
        ViewGroup.LayoutParams layoutParams = this.f302830b.getLayoutParams();
        if (s(min) > ViewUtils.getScreenWidth()) {
            min = n();
            QLog.i("PickBirthFriendsPanel", 1, "over screenWidth, adjust columns to :" + min);
        }
        if (min < 4) {
            layoutParams.width = s(min);
        } else {
            layoutParams.width = -1;
        }
        this.f302830b.setNumColumns(min);
        this.f302830b.setLayoutParams(layoutParams);
    }

    private void p(View view) {
        if (QQTheme.isNowThemeIsNight()) {
            setBackgroundDrawable(ResourcesCompat.getDrawable(this.f302829a.getResources(), R.drawable.kyf, null));
            ((TextView) view.findViewById(R.id.title)).setTextColor(-1);
            ((TextView) view.findViewById(R.id.f166931j64)).setTextColor(-1);
        } else {
            setBackgroundDrawable(ResourcesCompat.getDrawable(this.f302829a.getResources(), R.drawable.kyg, null));
            ((TextView) view.findViewById(R.id.title)).setTextColor(-16777216);
            ((TextView) view.findViewById(R.id.f166931j64)).setTextColor(-16777216);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(GroupGiftBirth$UserBirth groupGiftBirth$UserBirth) {
        List<GroupGiftBirth$BirthBless> list = groupGiftBirth$UserBirth.bless_list.get();
        if (list != null && !list.isEmpty()) {
            String currentAccountUin = this.f302834f.getCurrentAccountUin();
            Iterator<GroupGiftBirth$BirthBless> it = list.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(currentAccountUin, it.next().wisher.get())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String r(GroupGiftBirth$UserBirth groupGiftBirth$UserBirth) {
        String g16 = TroopBirthGiftHelper.INSTANCE.g(groupGiftBirth$UserBirth.time.get() * 1000, this.f302829a);
        if (q(groupGiftBirth$UserBirth)) {
            return "\u5df2\u795d\u798f";
        }
        return g16;
    }

    private int s(int i3) {
        return this.f302830b.getPaddingLeft() + this.f302830b.getPaddingRight() + (this.f302830b.getRequestedColumnWidth() * i3) + ((i3 - 1) * this.f302830b.getRequestedHorizontalSpacing());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        c cVar;
        if (this.f302832d.isEmpty()) {
            return;
        }
        String next = this.f302832d.iterator().next();
        Iterator<c> it = this.f302831c.iterator();
        while (true) {
            if (it.hasNext()) {
                cVar = it.next();
                if (TextUtils.equals(next, cVar.f302840b)) {
                    break;
                }
            } else {
                cVar = null;
                break;
            }
        }
        if (cVar == null) {
            QLog.e("PickBirthFriendsPanel", 1, "birthInfoFirst is null, mUinSelected = " + this.f302832d);
            return;
        }
        Intent intent = new Intent();
        if (this.f302832d.size() > 5) {
            Activity activity = this.f302829a;
            QQToast.makeText(activity, 0, activity.getString(R.string.f2335777m, 5), 4000).show();
            return;
        }
        if (this.f302832d.size() > 1) {
            intent.putStringArrayListExtra("multi_receivers", this.f302832d);
        } else {
            intent.putExtra("member_uin", cVar.f302840b);
        }
        intent.putExtra("member_display_name", cVar.f302841c);
        String str = cVar.f302841c;
        if (str == null || str.isEmpty()) {
            QLog.e("PickBirthFriendsPanel", 1, "nickname is null, " + cVar.f302840b);
        }
        ee.INSTANCE.e(this.f302829a, this.f302835g, intent, NTPanelEntrance.TROOP_BIRTH_PICK_MEMBER);
    }

    private void u(List<GroupGiftBirth$UserBirth> list) {
        d dVar = new d();
        this.f302830b.setNumColumns(Math.min(list.size(), 4));
        this.f302830b.setColumnWidth(ViewUtils.dip2px(60.0f));
        this.f302830b.setHorizontalSpacing(ViewUtils.dip2px(30.0f));
        dVar.setData(list);
        this.f302830b.setAdapter((ListAdapter) dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        c next;
        if (!this.f302831c.isEmpty()) {
            int min = Math.min(this.f302831c.size(), 5);
            this.f302832d.clear();
            int i3 = 0;
            int i16 = 0;
            for (c cVar : this.f302831c) {
                if (!cVar.f302839a) {
                    this.f302831c.get(i3).f302843e = true;
                    if (!this.f302832d.contains(cVar.f302840b)) {
                        this.f302832d.add(cVar.f302840b);
                    }
                    i16++;
                    if (i16 >= min) {
                        break;
                    }
                }
                i3++;
            }
            if (i16 == 0 && (next = this.f302831c.iterator().next()) != null) {
                next.f302843e = true;
                if (!this.f302832d.contains(next.f302840b)) {
                    this.f302832d.add(next.f302840b);
                }
            }
        }
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        View inflate = LayoutInflater.from(this.f302829a).inflate(R.layout.h5m, (ViewGroup) this.f302830b, false);
        this.f302830b = (GridView) inflate.findViewById(R.id.vf9);
        CardView cardView = (CardView) inflate.findViewById(R.id.tgm);
        this.f302833e = cardView;
        cardView.setOnClickListener(new b());
        TroopBirthGiftHelper.Companion companion = TroopBirthGiftHelper.INSTANCE;
        companion.p("19", "send", "", "4", 101, null);
        List<GroupGiftBirth$UserBirth> o16 = companion.o(this.f302835g);
        if (o16.isEmpty()) {
            QLog.i("PickBirthFriendsPanel", 1, "birthList is empty, can`t show panel");
            return;
        }
        u(o16);
        setContentView(inflate);
        p(inflate);
        setOutsideTouchable(true);
        setFocusable(true);
        setWidth(-1);
        setHeight(-2);
        showAtLocation(this.f302829a.getWindow().getDecorView(), 80, 0, 0);
    }
}

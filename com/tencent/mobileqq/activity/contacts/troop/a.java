package com.tencent.mobileqq.activity.contacts.troop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.contacts.base.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.n;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.widget.SwipRightMenuBuilder;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends com.tencent.mobileqq.activity.contacts.base.c {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f181814m;

    /* renamed from: n, reason: collision with root package name */
    private static final int[] f181815n;

    /* renamed from: o, reason: collision with root package name */
    private static final int[] f181816o;

    /* renamed from: k, reason: collision with root package name */
    private n f181817k;

    /* renamed from: l, reason: collision with root package name */
    private int f181818l;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.contacts.troop.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C7160a extends c.C7154c {
        static IPatchRedirector $redirector_;
        public int C;
        public TextView D;
        public TextView E;
        public ImageView F;
        public ImageView G;
        public TextView H;
        public ImageView I;
        public boolean J;

        public C7160a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68168);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f181814m = new int[]{R.string.bnq};
        f181815n = new int[]{R.drawable.cjb};
        f181816o = new int[]{R.id.eqg};
    }

    public a(QQAppInterface qQAppInterface, Context context, Entity entity, int i3) {
        super(qQAppInterface, context, entity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, context, entity, Integer.valueOf(i3));
            return;
        }
        this.f181818l = i3;
        this.f181501a = b(this.f181504d);
        if (i3 == 2) {
            this.f181817k = (n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        }
        this.f181502b = 0;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c
    public View a(int i3, int i16, View view, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        C7160a c7160a;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), view, viewGroup, onClickListener);
        }
        if (view != null && (view.getTag() instanceof C7160a)) {
            c7160a = (C7160a) view.getTag();
        } else {
            View inflate = LayoutInflater.from(this.f181504d).inflate(R.layout.f167915m8, (ViewGroup) null);
            C7160a c7160a2 = new C7160a();
            View createView = this.f181501a.createView(this.f181504d, inflate, c7160a2, -1);
            c7160a2.D = (TextView) createView.findViewById(R.id.text1);
            QQProAvatarView qQProAvatarView = (QQProAvatarView) createView.findViewById(R.id.icon);
            c7160a2.f187116f = qQProAvatarView;
            ((RelativeLayout.LayoutParams) qQProAvatarView.getLayoutParams()).leftMargin = BaseAIOUtils.f(12.0f, this.f181504d.getResources());
            c7160a2.E = (TextView) createView.findViewById(R.id.text2);
            createView.setTag(c7160a2);
            view = createView;
            c7160a = c7160a2;
        }
        c7160a.leftView.setBackgroundResource(R.drawable.f160540jm);
        if (this.f181818l == 2) {
            DiscussionInfo discussionInfo = (DiscussionInfo) this.f181505e;
            c7160a.f187114d = discussionInfo.uin;
            c7160a.f181513m = discussionInfo;
            c7160a.f187115e = 101;
            c7160a.D.setText(discussionInfo.discussionName);
            c7160a.E.setVisibility(0);
            c7160a.E.setText(String.format("(%d)", Integer.valueOf(this.f181817k.q(discussionInfo.uin))));
        } else {
            TroopInfo troopInfo = (TroopInfo) this.f181505e;
            c7160a.f187114d = troopInfo.troopuin;
            c7160a.f181513m = troopInfo;
            c7160a.f187115e = 4;
            c7160a.D.setText(troopInfo.getTroopDisplayName());
            c7160a.E.setVisibility(8);
        }
        c7160a.D.setTextColor(this.f181504d.getResources().getColor(R.color.skin_black_theme_version2));
        n(view, i16, c7160a, onClickListener);
        l(view, 3, c7160a.f187114d);
        return view;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c
    protected int[] e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (int[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return f181815n;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c
    protected int[] f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (int[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return f181816o;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c
    protected void g(int i3, SwipRightMenuBuilder.SwipRightMenuItem[] swipRightMenuItemArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) swipRightMenuItemArr);
            return;
        }
        if (swipRightMenuItemArr != null && swipRightMenuItemArr.length > 0) {
            int i16 = 0;
            if (swipRightMenuItemArr.length > 0) {
                SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem = swipRightMenuItemArr[0];
                swipRightMenuItem.menuId = 0;
                swipRightMenuItem.menuType = 0;
                i16 = 1;
            }
            while (i16 < swipRightMenuItemArr.length) {
                SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem2 = swipRightMenuItemArr[i16];
                swipRightMenuItem2.menuId = -1;
                swipRightMenuItem2.menuType = -1;
                i16++;
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c
    protected int[] h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return f181814m;
    }
}

package com.tencent.mobileqq.qqgamepub.web;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter;
import com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper;
import com.tencent.mobileqq.qqgamepub.view.GameArkView;
import com.tencent.mobileqq.qqgamepub.view.MoreMsgHeaderView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f extends PagerAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQGameWebPresenter f264843d;

    /* renamed from: e, reason: collision with root package name */
    private Context f264844e;

    /* renamed from: f, reason: collision with root package name */
    private ViewPager f264845f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.qqgamepub.model.a f264846h;

    public f(QQGameWebPresenter qQGameWebPresenter, Context context, ViewPager viewPager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQGameWebPresenter, context, viewPager);
            return;
        }
        this.f264843d = qQGameWebPresenter;
        this.f264844e = context;
        this.f264845f = viewPager;
        this.f264846h = new com.tencent.mobileqq.qqgamepub.model.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d(RelativeLayout relativeLayout, com.tencent.mobileqq.qqgamepub.view.a aVar, QQGameMsgInfo qQGameMsgInfo, int i3) {
        aVar.b(qQGameMsgInfo, this.f264844e, i3, "1");
        k(aVar, i3);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        View view = (View) aVar;
        layoutParams.addRule(13, view.getId());
        relativeLayout.addView(view, layoutParams);
    }

    private void e(com.tencent.mobileqq.qqgamepub.view.a aVar, RelativeLayout relativeLayout, QQGameMsgInfo qQGameMsgInfo) {
        TextView textView;
        RelativeLayout.LayoutParams layoutParams;
        if (aVar instanceof MoreMsgHeaderView) {
            return;
        }
        if (qQGameMsgInfo != null) {
            Pair<TextView, RelativeLayout.LayoutParams> f16 = QQGameUIHelper.f(qQGameMsgInfo, this.f264844e);
            textView = (TextView) f16.first;
            layoutParams = (RelativeLayout.LayoutParams) f16.second;
        } else {
            textView = null;
            layoutParams = null;
        }
        if (textView != null && layoutParams != null) {
            relativeLayout.addView(textView, layoutParams);
        }
    }

    private boolean f(com.tencent.mobileqq.qqgamepub.view.a aVar, int i3) {
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("WebHeadPageAdapter", 2, "headerView = null");
            }
            return false;
        }
        if (h().j(aVar) && !h().i(i3)) {
            return false;
        }
        return true;
    }

    private com.tencent.mobileqq.qqgamepub.view.a g(int i3) {
        com.tencent.mobileqq.qqgamepub.view.a aVar;
        if (h().m(i3)) {
            aVar = h().c(i3);
        } else {
            aVar = null;
        }
        if (!f(aVar, i3)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WebHeadPageAdapter", 2, "headerView = " + aVar.getClass().getSimpleName());
        }
        View view = (View) aVar;
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        return aVar;
    }

    private com.tencent.mobileqq.qqgamepub.model.a h() {
        if (this.f264846h == null) {
            this.f264846h = new com.tencent.mobileqq.qqgamepub.model.a();
        }
        return this.f264846h;
    }

    private QQGameMsgInfo i(int i3) {
        QQGameMsgInfo qQGameMsgInfo;
        if (i3 < h().h()) {
            qQGameMsgInfo = h().d(i3);
        } else {
            qQGameMsgInfo = null;
        }
        if (qQGameMsgInfo == null) {
            qQGameMsgInfo = new QQGameMsgInfo();
        }
        qQGameMsgInfo.loadArkResPath = this.f264843d.z();
        return qQGameMsgInfo;
    }

    private void k(com.tencent.mobileqq.qqgamepub.view.a aVar, int i3) {
        if (i3 == this.f264845f.getCurrentItem()) {
            this.f264843d.i().t(aVar);
            if (aVar instanceof GameArkView) {
                GameArkView gameArkView = (GameArkView) aVar;
                gameArkView.setPrePause(false);
                com.tencent.mobileqq.qqgamepub.utils.b.c().g(gameArkView);
                return;
            }
            com.tencent.mobileqq.qqgamepub.utils.b.c().g(null);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, viewGroup, Integer.valueOf(i3), obj);
        } else {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return Math.max(h().e(), 1);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, obj)).intValue();
        }
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewGroup, i3);
        }
        if (h().k()) {
            return j(viewGroup);
        }
        com.tencent.mobileqq.qqgamepub.view.a g16 = g(i3);
        if (g16 != null) {
            RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            QQGameMsgInfo i16 = i(i3);
            d(relativeLayout, g16, i16, i3);
            e(g16, relativeLayout, i16);
            viewGroup.addView(relativeLayout, layoutParams);
            return relativeLayout;
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, obj)).booleanValue();
        }
        if (view == obj) {
            return true;
        }
        return false;
    }

    public View j(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this, (Object) viewGroup);
        }
        View inflate = LayoutInflater.from(this.f264844e).inflate(R.layout.f167988oe, (ViewGroup) null, false);
        ((ImageView) inflate.findViewById(R.id.bwj)).setImageDrawable(URLDrawable.getDrawable(MiniGamePublicAccountConst.EMPTY_MSG));
        viewGroup.addView(inflate);
        return inflate;
    }

    public void l(com.tencent.mobileqq.qqgamepub.model.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        this.f264846h.g().clear();
        this.f264846h.f().clear();
        this.f264846h.g().addAll(aVar.g());
        this.f264846h.f().addAll(aVar.f());
        notifyDataSetChanged();
    }
}

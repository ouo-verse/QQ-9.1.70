package com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist.page.ApplyListPageView;
import com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist.page.InviteListPageView;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;

/* loaded from: classes17.dex */
public class ChatRoomViewPager extends ViewPager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private b f271754d;

    /* loaded from: classes17.dex */
    class a implements ViewPager.OnPageChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatRoomViewPager.this);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else if (i3 == 0) {
                ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).traverseExposure();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                if (ChatRoomViewPager.this.f271754d == null) {
                    return;
                }
                if (i3 == 0) {
                    ChatRoomViewPager.this.f271754d.f271756d.g();
                } else {
                    ChatRoomViewPager.this.f271754d.f271757e.i();
                }
            }
        }
    }

    /* loaded from: classes17.dex */
    private class b extends PagerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        ApplyListPageView f271756d;

        /* renamed from: e, reason: collision with root package name */
        InviteListPageView f271757e;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatRoomViewPager.this);
            } else {
                this.f271756d = new ApplyListPageView(ChatRoomViewPager.this.getContext());
                this.f271757e = new InviteListPageView(ChatRoomViewPager.this.getContext());
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i3, @NonNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, viewGroup, Integer.valueOf(i3), obj);
            } else if (obj instanceof View) {
                viewGroup.removeView((View) obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return 2;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i3) {
            View view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewGroup, i3);
            }
            if (i3 == 0) {
                view = this.f271756d;
            } else {
                view = this.f271757e;
            }
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, obj)).booleanValue();
            }
            if (view == obj) {
                return true;
            }
            return false;
        }
    }

    public ChatRoomViewPager(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        b bVar = this.f271754d;
        if (bVar != null) {
            return bVar.f271756d.i();
        }
        return 0;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (getContext() instanceof FragmentActivity) {
            b bVar = new b();
            this.f271754d = bVar;
            setAdapter(bVar);
            addOnPageChangeListener(new a());
        }
    }

    public void setCallBack(qi2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
            return;
        }
        b bVar = this.f271754d;
        if (bVar != null) {
            bVar.f271756d.setCallBack(aVar);
            this.f271754d.f271757e.setCallBack(aVar);
        }
    }

    public void setInviteList(List<qn3.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        b bVar = this.f271754d;
        if (bVar != null) {
            bVar.f271757e.setData(list);
        }
    }

    public void setWaitingList(List<qn3.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            return;
        }
        b bVar = this.f271754d;
        if (bVar != null) {
            bVar.f271756d.setData(list);
        }
    }

    public ChatRoomViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }
}

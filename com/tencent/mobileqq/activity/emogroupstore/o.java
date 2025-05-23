package com.tencent.mobileqq.activity.emogroupstore;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.ao;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class o extends PagerAdapter {
    static IPatchRedirector $redirector_;
    private View.OnClickListener C;

    /* renamed from: d, reason: collision with root package name */
    private LinkedList<URLImageView> f182153d;

    /* renamed from: e, reason: collision with root package name */
    private Context f182154e;

    /* renamed from: f, reason: collision with root package name */
    private final LifecycleCoroutineScope f182155f;

    /* renamed from: h, reason: collision with root package name */
    private List<EmoticonFromGroupEntity> f182156h;

    /* renamed from: i, reason: collision with root package name */
    private ViewPager f182157i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.emosm.favroaming.l f182158m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                o oVar = o.this;
                EmoticonFromGroupEntity f16 = oVar.f(oVar.f182157i.getCurrentItem());
                if (f16 != null) {
                    if (f16.msgRecord != null && f16.msgElement != null) {
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("extra.IS_FROM_GROUP_EMO", true);
                        ((IRichMediaBrowserApi) QRoute.api(IRichMediaBrowserApi.class)).enterImagePreview(peekAppRuntime, o.this.f182154e, (ImageView) view, new AIOMsgItem(f16.msgRecord), f16.msgElement, true, bundle, null, false);
                    } else {
                        QLog.e("ImgPreviewAdapter.msgnull", 1, "img click msg is null.");
                    }
                } else {
                    QLog.e("ImgPreviewAdapter.emonull", 1, "img click emo is null.");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(QQAppInterface qQAppInterface, Context context, LifecycleCoroutineScope lifecycleCoroutineScope, ViewPager viewPager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, context, lifecycleCoroutineScope, viewPager);
            return;
        }
        this.C = new a();
        this.f182154e = context;
        this.f182157i = viewPager;
        this.f182155f = lifecycleCoroutineScope;
        this.f182153d = new LinkedList<>();
        this.f182158m = ((ao) qQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308430h;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, viewGroup, Integer.valueOf(i3), obj);
            return;
        }
        URLImageView uRLImageView = (URLImageView) obj;
        viewGroup.removeView(uRLImageView);
        this.f182153d.add(uRLImageView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmoticonFromGroupEntity f(int i3) {
        List<EmoticonFromGroupEntity> list = this.f182156h;
        if (list == null) {
            return null;
        }
        return list.get(i3);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        List<EmoticonFromGroupEntity> list = this.f182156h;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, obj)).intValue();
        }
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        URLImageView uRLImageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewGroup, i3);
        }
        if (this.f182153d.size() > 0) {
            uRLImageView = this.f182153d.removeFirst();
        } else {
            uRLImageView = new URLImageView(this.f182154e);
            uRLImageView.setLayoutParams(new Gallery.LayoutParams(ScreenUtil.dip2px(166.0f), ScreenUtil.dip2px(166.0f)));
            uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            uRLImageView.setBackgroundColor(this.f182154e.getResources().getColor(R.color.f156896el));
        }
        ExtensionsKt.c(this.f182156h.get(i3), this.f182158m, uRLImageView, 1, -1, this.f182155f);
        uRLImageView.setOnClickListener(this.C);
        viewGroup.addView(uRLImageView);
        return uRLImageView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, obj)).booleanValue();
        }
        if (view == obj) {
            return true;
        }
        return false;
    }

    public void setData(List<EmoticonFromGroupEntity> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            this.f182156h = list;
        }
    }
}

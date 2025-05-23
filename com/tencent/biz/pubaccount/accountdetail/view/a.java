package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.impl.PublicAccountConfigAttrImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends b {
    public a(Context context, ArrayList<IPublicAccountConfigAttr.a> arrayList, ay.a aVar, String str, String str2) {
        super(context, arrayList, aVar, str, str2);
    }

    private View d(IPublicAccountConfigAttr.a aVar) {
        RelativeLayout relativeLayout = new RelativeLayout(this.f79256b);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        URLImageView uRLImageView = new URLImageView(this.f79256b);
        uRLImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        uRLImageView.setBackgroundDrawable(URLDrawable.getDrawable(aVar.f79339k, (Drawable) null, (Drawable) null, true));
        uRLImageView.setImageDrawable(new ColorDrawable(Color.parseColor(GameCenterVideoViewController.GRAY_MASK)));
        uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        relativeLayout.addView(uRLImageView);
        relativeLayout.setTag(aVar);
        relativeLayout.setOnClickListener(this.f79260f);
        return relativeLayout;
    }

    private RelativeLayout e() {
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBannerViewWrapper", 2, "buildView!");
        }
        Resources resources = this.f79256b.getResources();
        int f16 = BaseAIOUtils.f(160.0f, resources);
        int f17 = BaseAIOUtils.f(20.0f, resources);
        RelativeLayout relativeLayout = new RelativeLayout(this.f79256b);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, f16 + f17));
        relativeLayout.setPadding(0, f17, 0, 0);
        AccountDetailBannerViewPager accountDetailBannerViewPager = new AccountDetailBannerViewPager(this.f79256b);
        accountDetailBannerViewPager.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(accountDetailBannerViewPager);
        ArrayList<View> arrayList = new ArrayList<>();
        Iterator<IPublicAccountConfigAttr.a> it = this.f79255a.iterator();
        while (it.hasNext()) {
            arrayList.add(d(it.next()));
        }
        C0802a c0802a = new C0802a();
        c0802a.d(arrayList);
        accountDetailBannerViewPager.setAdapter(c0802a);
        AccountDetailBannerIndicator accountDetailBannerIndicator = new AccountDetailBannerIndicator(this.f79256b, arrayList.size());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(12, -1);
        layoutParams.setMargins(0, 0, 0, BaseAIOUtils.f(10.0f, resources));
        accountDetailBannerIndicator.setLayoutParams(layoutParams);
        relativeLayout.addView(accountDetailBannerIndicator);
        accountDetailBannerViewPager.setIndicator(accountDetailBannerIndicator);
        accountDetailBannerViewPager.setCurrentItem(LockFreeTaskQueueCore.MAX_CAPACITY_MASK - (LockFreeTaskQueueCore.MAX_CAPACITY_MASK % arrayList.size()));
        relativeLayout.setClickable(false);
        relativeLayout.setOnClickListener(null);
        return relativeLayout;
    }

    public static View f(Context context, View view, ViewGroup viewGroup, PublicAccountConfigAttrImpl publicAccountConfigAttrImpl, int i3, ay.a aVar, String str, String str2) {
        RelativeLayout relativeLayout;
        Object tag;
        ArrayList<IPublicAccountConfigAttr.a> b16 = b.b(publicAccountConfigAttrImpl, i3);
        if (b16.isEmpty()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AccountDetailBannerViewWrapper", 2, "createView return convertView!");
            }
            return view;
        }
        if (view != null && (view instanceof RelativeLayout) && (tag = (relativeLayout = (RelativeLayout) view).getTag()) != null && (tag instanceof a) && ((a) tag).a(b16)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AccountDetailBannerViewWrapper", 2, "createView reuse!");
            }
            return relativeLayout;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("AccountDetailBannerViewWrapper", 2, "createView new create!");
        }
        a aVar2 = new a(context, b16, aVar, str, str2);
        RelativeLayout e16 = aVar2.e();
        e16.setTag(aVar2);
        return e16;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.accountdetail.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public static class C0802a extends PagerAdapter {

        /* renamed from: d, reason: collision with root package name */
        protected ArrayList<View> f79254d = new ArrayList<>();

        public void d(ArrayList<View> arrayList) {
            this.f79254d = arrayList;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            if (this.f79254d.size() <= 1) {
                return this.f79254d.size();
            }
            return Integer.MAX_VALUE;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            int size = this.f79254d.size();
            int i16 = size > 1 ? i3 % size : i3;
            if (i3 < 0) {
                i16 += size;
            }
            viewGroup.removeView(this.f79254d.get(i16));
            viewGroup.addView(this.f79254d.get(i16));
            if (QLog.isDevelopLevel()) {
                QLog.d("AccountDetailBannerViewWrapper", 2, "instantiateItem->pos:" + i3 + ", newPos:" + i16);
            }
            return this.f79254d.get(i16);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == ((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        }
    }
}

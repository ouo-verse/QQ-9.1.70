package com.tencent.biz.qqcircle.richframework.compat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CompatSlideFragment extends QCircleBaseFragment {
    private ViewPager C;
    private a D;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class a extends FragmentPagerAdapter {

        /* renamed from: d, reason: collision with root package name */
        private final ArrayList<Fragment> f91888d;

        /* renamed from: e, reason: collision with root package name */
        private CompatPublicFragment f91889e;

        public a(FragmentManager fragmentManager, Intent intent) {
            super(fragmentManager);
            ArrayList<Fragment> arrayList = new ArrayList<>();
            this.f91888d = arrayList;
            try {
                arrayList.add(d(intent, intent.getStringExtra("KEY_LEFT_FRAGMENT_CLASS_NAME")));
                CompatPublicFragment d16 = d(intent, intent.getStringExtra("KEY_RIGHT_FRAGMENT_CLASS_NAME"));
                this.f91889e = d16;
                arrayList.add(d16);
            } catch (ClassNotFoundException e16) {
                e16.printStackTrace();
            } catch (IllegalAccessException e17) {
                e17.printStackTrace();
            } catch (InstantiationException e18) {
                e18.printStackTrace();
            }
        }

        private CompatPublicFragment d(Intent intent, String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
            CompatPublicFragment compatPublicFragment = (CompatPublicFragment) Class.forName(str).newInstance();
            compatPublicFragment.setArguments(intent.getExtras());
            return compatPublicFragment;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return this.f91888d.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i3) {
            if (i3 < this.f91888d.size()) {
                return this.f91888d.get(i3);
            }
            return null;
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g5v;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "CompatSlideFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        this.C = (ViewPager) ((QCircleBaseFragment) this).mContentView.findViewById(R.id.f1203379_);
        a aVar = new a(getChildFragmentManager(), getActivity().getIntent());
        this.D = aVar;
        this.C.setAdapter(aVar);
        this.C.setOffscreenPageLimit(2);
    }

    public void ph(int i3) {
        ViewPager viewPager = this.C;
        if (viewPager != null) {
            viewPager.setCurrentItem(i3);
        }
    }
}

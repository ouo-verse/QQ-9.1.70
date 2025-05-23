package com.tencent.biz.qqcircle.richframework.part.list.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.search.QFSPersonalPanelPart;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleLikeListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QFSMessageBoxListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QFSMessageListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QFSMessageSecondListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QFSMessageSecondPushMoreListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QFSPrivateMessageListBlock;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.widget.MultiTabViewPager;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class PublicListFragment extends QCircleBaseFragment {
    private static final ArrayList<String> M;
    private static final ArrayList<String> N;
    protected com.tencent.biz.qqcircle.richframework.part.list.base.a C;
    protected d D;
    protected ArrayList<String> F;
    protected List<BasePartFragment> G;
    protected MultiTabViewPager H;
    protected FrameLayout I;
    protected a J;
    protected ArrayList<BaseListBlock> E = new ArrayList<>();
    private boolean K = false;
    private boolean L = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends FragmentPagerAdapter {
        a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return PublicListFragment.this.G.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i3) {
            if (i3 < PublicListFragment.this.G.size()) {
                return PublicListFragment.this.G.get(i3);
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i3) {
            d dVar = PublicListFragment.this.D;
            if (dVar == null) {
                return "";
            }
            return dVar.C9(i3, "");
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        M = arrayList;
        ArrayList<String> arrayList2 = new ArrayList<>();
        N = arrayList2;
        arrayList.add(QFSMessageListBlock.class.getName());
        arrayList.add(QFSMessageSecondListBlock.class.getName());
        arrayList.add(QFSMessageSecondPushMoreListBlock.class.getName());
        arrayList.add(QCircleLikeListBlock.class.getName());
        arrayList.add(QFSPrivateMessageListBlock.class.getName());
        arrayList2.add(QFSMessageBoxListBlock.class.getName());
    }

    private void rh(View view) {
        this.H = (MultiTabViewPager) view.findViewById(R.id.f12031798);
        this.J = new a(getChildFragmentManager());
        List<BasePartFragment> list = this.G;
        if (list != null && list.size() > 1) {
            this.H.setOffscreenPageLimit(this.G.size() - 1);
        }
        this.H.setAdapter(this.J);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        this.C = new com.tencent.biz.qqcircle.richframework.part.list.base.a(this.E);
        d dVar = new d(this.E);
        this.D = dVar;
        arrayList.add(dVar);
        arrayList.add(this.C);
        QFSPersonalPanelPart qFSPersonalPanelPart = new QFSPersonalPanelPart();
        qFSPersonalPanelPart.ca(1);
        arrayList.add(qFSPersonalPanelPart);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g5b;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "PublicListFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        if (!this.K && !this.L) {
            return QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_default);
        }
        return QFSQUIUtilsKt.d(getContext(), R.color.qui_common_bg_bottom_standard);
    }

    protected void initIntentData() {
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra("public_list_block_class_array")) {
            try {
                this.E = new ArrayList<>();
                this.G = new ArrayList();
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("public_list_block_class_array");
                this.F = stringArrayListExtra;
                Iterator<String> it = stringArrayListExtra.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    String next = it.next();
                    if (getActivity() != null && getActivity().getIntent() != null) {
                        getActivity().getIntent().putExtra(BaseListBlock.PAGE_BLOCK_POSITION, i3);
                    }
                    BaseListBlock ph5 = ph(intent, next);
                    if (ph5 != null) {
                        PublicListInnerFragment Ah = PublicListInnerFragment.Ah(intent.getStringExtra("key_empty_block"));
                        Ah.Eh(ph5, i3);
                        Ah.Fh(i3);
                        this.E.add(ph5);
                        this.G.add(Ah);
                        if (M.contains(next)) {
                            this.K = true;
                        } else if (N.contains(next)) {
                            this.L = true;
                        }
                    }
                    BasePartFragment qh5 = qh(next);
                    if (qh5 != null) {
                        this.G.add(qh5);
                    }
                    QLog.d("PublicListFragment", 1, "[initIntentData] position: " + i3);
                    i3++;
                }
                return;
            } catch (Exception e16) {
                QLog.e("PublicListFragment", 1, "initIntentData error" + e16.getMessage());
                getActivity().finish();
                return;
            }
        }
        QLog.e("PublicListFragment", 1, "intent can't be null");
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        return !QCircleCommonUtil.isInNightMode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needAdjustImmersive() {
        if (getActivity() == null || getParentFragmentManager() != getActivity().getSupportFragmentManager()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needSupportFullScreen() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        ArrayList<BaseListBlock> arrayList = this.E;
        if (arrayList != null) {
            Iterator<BaseListBlock> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onActivityResult(i3, i16, intent);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        initIntentData();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Iterator<BaseListBlock> it = this.E.iterator();
        while (it.hasNext()) {
            if (it.next().onBackEvent()) {
                return true;
            }
        }
        return super.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        this.I = (FrameLayout) view.findViewById(R.id.idg);
        rh(view);
        FrameLayout frameLayout = this.I;
        if (frameLayout != null) {
            if (this.K) {
                frameLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.kkg));
            } else if (this.L) {
                frameLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.qui_common_bg_bottom_standard_bg));
            }
        }
    }

    public BaseListBlock ph(Intent intent, String str) {
        BaseListBlock baseListBlock = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            BaseListBlock baseListBlock2 = (BaseListBlock) Class.forName(str).getConstructor(Bundle.class).newInstance(getActivity().getIntent().getExtras());
            try {
                if (intent.hasExtra("public_list_init_data") && intent.getSerializableExtra("public_list_init_data") != null) {
                    baseListBlock2.setDatas((ArrayList) intent.getSerializableExtra("public_list_init_data"));
                }
                if (intent.hasExtra("key_bundle_common_init_bean")) {
                    baseListBlock2.setInitBean(intent.getSerializableExtra("key_bundle_common_init_bean"));
                }
                return baseListBlock2;
            } catch (Exception e16) {
                e = e16;
                baseListBlock = baseListBlock2;
                QLog.e("PublicListFragment", 1, "initAdapterError" + e.getMessage());
                return baseListBlock;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public BasePartFragment qh(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return (BasePartFragment) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e16) {
            QLog.e("PublicListFragment", 1, "initAdapterError" + e16.getMessage());
            return null;
        }
    }
}

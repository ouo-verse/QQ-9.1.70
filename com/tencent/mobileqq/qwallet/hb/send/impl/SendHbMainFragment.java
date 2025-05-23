package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.panel.RedPacketManager;
import com.tencent.mobileqq.qwallet.hb.send.PanelEntryData;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.ViewPagerTabLayout2;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import qk2.MakeHbBulletinConfig;

/* compiled from: P */
/* loaded from: classes16.dex */
public class SendHbMainFragment extends BaseHbFragment implements View.OnClickListener {
    private static final String P = HardCodeUtil.qqStr(R.string.f172682tb2);
    private final List<b> K = new ArrayList();
    private final HbInfo.a L = new HbInfo.a();
    private String M;
    private ViewPagerTabLayout2 N;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a extends FragmentPagerAdapter {
        a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public QBaseFragment getItem(int i3) {
            return ((b) SendHbMainFragment.this.K.get(i3)).f277696c;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return SendHbMainFragment.this.K.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i3) {
            return ((b) SendHbMainFragment.this.K.get(i3)).f277695b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f277694a;

        /* renamed from: b, reason: collision with root package name */
        public String f277695b;

        /* renamed from: c, reason: collision with root package name */
        public BaseHbFragment f277696c;

        b(int i3, String str, BaseHbFragment baseHbFragment) {
            this.f277694a = i3;
            this.f277695b = str;
            this.f277696c = baseHbFragment;
        }
    }

    private int Ch() {
        return HbInfo.b(this.G, x05.c.j(this.C.getString("bus_type"), 2));
    }

    private String Dh(@NonNull PanelEntryData panelEntryData) {
        String title = panelEntryData.getTitle();
        if (!TextUtils.isEmpty(title)) {
            int indexOf = title.indexOf(P);
            if (indexOf != -1) {
                title = title.substring(0, indexOf);
            }
        } else {
            title = null;
        }
        if (TextUtils.isEmpty(title)) {
            return P;
        }
        return title;
    }

    private boolean Eh(Bundle bundle) {
        BaseHbFragment yh5;
        int i3 = bundle.getInt("tabMask", 0);
        boolean z16 = bundle.getBoolean("isFromPanel");
        this.K.clear();
        if (QLog.isColorLevel()) {
            QLog.i("SendHbMainFragment", 2, "initHbData... isFromPanel:" + z16 + " tabMask:" + i3);
        }
        if (i3 != 0) {
            if ((i3 & 2) == 2) {
                Bundle bundle2 = new Bundle(bundle);
                bundle2.putString("bus_type", "2");
                UsualHbFragment usualHbFragment = new UsualHbFragment();
                usualHbFragment.setArguments(bundle2);
                this.K.add(new b(1, HardCodeUtil.qqStr(R.string.f172680tb0), usualHbFragment));
            }
            if ((i3 & 1) == 1) {
                Bundle bundle3 = new Bundle(bundle);
                bundle3.putString("bus_type", "1");
                UsualHbFragment usualHbFragment2 = new UsualHbFragment();
                usualHbFragment2.setArguments(bundle3);
                this.K.add(new b(0, HardCodeUtil.qqStr(R.string.f172681tb1), usualHbFragment2));
            }
        } else {
            ArrayList<PanelEntryData> arrayList = new ArrayList();
            if (z16) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("panelEntryData");
                if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                    arrayList.addAll(parcelableArrayList);
                } else {
                    QLog.e("SendHbMainFragment", 1, "isFromPanel but cacheData isEmpty");
                    arrayList.addAll(RedPacketManager.h(null));
                    z16 = false;
                }
            } else {
                arrayList.addAll(RedPacketManager.h(null));
            }
            for (PanelEntryData panelEntryData : arrayList) {
                if (panelEntryData != null) {
                    try {
                        if (!TextUtils.isEmpty(panelEntryData.getTitle()) && (yh5 = yh(panelEntryData, bundle, z16)) != null) {
                            this.K.add(new b(panelEntryData.getType(), Dh(panelEntryData), yh5));
                        }
                    } catch (Throwable th5) {
                        QLog.e("SendHbMainFragment", 1, th5, new Object[0]);
                    }
                }
            }
        }
        return !this.K.isEmpty();
    }

    private void Fh(View view) {
        boolean z16;
        try {
            int isSupporImmersive = ImmersiveUtils.isSupporImmersive();
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(this.D);
            if (isSupporImmersive == 1) {
                SendHbActivity sendHbActivity = this.D;
                if (!QQTheme.isNowThemeIsNight()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                com.tencent.mobileqq.qwallet.utils.d.b(sendHbActivity, z16);
                View findViewById = view.findViewById(R.id.jg8);
                findViewById.getLayoutParams().height = statusBarHeight;
                findViewById.requestLayout();
                if (QLog.isColorLevel()) {
                    QLog.i("SendHbMainFragment", 2, "initImmersive:" + isSupporImmersive + " barHeight: " + statusBarHeight);
                }
            }
        } catch (Throwable th5) {
            QLog.e("SendHbMainFragment", 1, th5, new Object[0]);
        }
    }

    private void Gh(View view) {
        final TipsBar tipsBar = (TipsBar) view.findViewById(R.id.lkb);
        final MakeHbBulletinConfig makeHbBulletinConfig = (MakeHbBulletinConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig("qwallet_make_hb_bulletin_config", new MakeHbBulletinConfig());
        if (!Kh(makeHbBulletinConfig)) {
            tipsBar.setVisibility(8);
            return;
        }
        tipsBar.setBarType(1);
        tipsBar.setTipsIcon(getResources().getDrawable(R.drawable.common_black_tips_icon_info));
        if (tipsBar.r() != null) {
            tipsBar.r().setVisibility(0);
        }
        tipsBar.setVisibility(0);
        tipsBar.setTipsText(makeHbBulletinConfig.getContent());
        tipsBar.setEnabled(true);
        tipsBar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SendHbMainFragment.this.Lh(makeHbBulletinConfig, view2);
            }
        });
        tipsBar.setCloseListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.af
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SendHbMainFragment.Mh(TipsBar.this, makeHbBulletinConfig, view2);
            }
        });
    }

    private void Ih(View view, Bundle bundle) {
        HbInfo.c(bundle, this.L);
        this.M = this.L.recv_type;
        Fh(view);
        Hh(view, bundle.getString("hbTitle", getString(R.string.e7g)));
        if (!Eh(bundle)) {
            QLog.i("SendHbMainFragment", 1, "initHbData failed...");
            QQToast.makeText(this.D, HardCodeUtil.qqStr(R.string.taz), 0).show();
            this.D.finish();
            return;
        }
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.meu);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(new a(getChildFragmentManager()));
        int Ch = Ch();
        viewPager.setCurrentItem(zh(Ch), false);
        this.N = (ViewPagerTabLayout2) view.findViewById(R.id.j_o);
        String[] strArr = new String[this.K.size()];
        for (int i3 = 0; i3 < this.K.size(); i3++) {
            strArr[i3] = this.K.get(i3).f277695b;
        }
        this.N.setTabData(strArr);
        this.N.setViewPager(viewPager);
        this.N.setCurrentPosition(zh(Ch));
        Gh(view);
    }

    public static boolean Jh(String str, String str2) {
        long a16 = com.tencent.mobileqq.qwallet.impl.d.a(str);
        long a17 = com.tencent.mobileqq.qwallet.impl.d.a(str2);
        if (a16 != -1 && a17 != -1 && a16 < a17) {
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            if (serverTimeMillis >= a16 && serverTimeMillis <= a17) {
                return true;
            }
        }
        return false;
    }

    private boolean Kh(@Nullable MakeHbBulletinConfig makeHbBulletinConfig) {
        if (makeHbBulletinConfig == null || TextUtils.isEmpty(makeHbBulletinConfig.getContent())) {
            return false;
        }
        if (!Jh(makeHbBulletinConfig.getBeginTime(), makeHbBulletinConfig.getEndTime())) {
            if (QLog.isColorLevel()) {
                QLog.w("SendHbMainFragment", 2, "isBulletinValidDate:false,start_time:" + makeHbBulletinConfig.getBeginTime() + " end_time:" + makeHbBulletinConfig.getEndTime());
            }
            return false;
        }
        if (makeHbBulletinConfig.getId() == MobileQQ.sMobileQQ.getSharedPreferences("red_packet", 0).getInt("red_packet_bulletin", -1)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lh(MakeHbBulletinConfig makeHbBulletinConfig, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!x05.c.f()) {
            String url = makeHbBulletinConfig.getUrl();
            if (!TextUtils.isEmpty(url)) {
                th(url);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Mh(TipsBar tipsBar, MakeHbBulletinConfig makeHbBulletinConfig, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        tipsBar.setVisibility(8);
        MobileQQ.sMobileQQ.getSharedPreferences("red_packet", 0).edit().putInt("red_packet_bulletin", makeHbBulletinConfig.getId()).apply();
        EventCollector.getInstance().onViewClicked(view);
    }

    private BaseHbFragment yh(PanelEntryData panelEntryData, Bundle bundle, boolean z16) {
        Bundle bundle2 = new Bundle(bundle);
        int type = panelEntryData.getType();
        bundle2.putString("panel_name", panelEntryData.getTitle());
        Integer a16 = HbInfo.a(type);
        BaseHbFragment baseHbFragment = null;
        if (a16 == null) {
            return null;
        }
        bundle2.putString(WadlProxyConsts.CHANNEL, String.valueOf(a16));
        if (type != 0) {
            if (type != 1) {
                if (type != 2 && type != 6) {
                    if (type == 11 && (z16 || HbInfo.f277198f.contains(this.M))) {
                        baseHbFragment = new ExclusiveHbFragment();
                    }
                } else if (z16 || !HbInfo.f277199g.contains(this.M)) {
                    baseHbFragment = new LingHbFragment();
                }
            } else if (z16 || HbInfo.f277197e.contains(this.M)) {
                baseHbFragment = new UsualHbFragment();
                bundle2.putString("bus_type", "2");
            }
        } else {
            baseHbFragment = new UsualHbFragment();
            bundle2.putString("bus_type", "1");
        }
        if (baseHbFragment != null) {
            baseHbFragment.setArguments(bundle2);
        } else if (QLog.isColorLevel()) {
            QLog.i("SendHbMainFragment", 2, "buildHbFragment...fragment is null,panelData:" + panelEntryData.toString());
        }
        return baseHbFragment;
    }

    public BaseHbFragment Ah() {
        try {
            return this.K.get(this.N.m()).f277696c;
        } catch (Throwable th5) {
            QLog.e("SendHbMainFragment", 1, th5, new Object[0]);
            return null;
        }
    }

    public int Bh() {
        try {
            return this.K.get(this.N.m()).f277694a;
        } catch (Throwable th5) {
            QLog.e("SendHbMainFragment", 1, th5, new Object[0]);
            return 1;
        }
    }

    public void Hh(View view, String str) {
        ((TextView) view.findViewById(R.id.ivTitleName)).setText(str);
        view.findViewById(R.id.ivTitleBtnLeft).setOnClickListener(this);
    }

    public void Nh() {
        int Bh = Bh();
        switch (Bh) {
            case 7:
                this.D.addHbUploadData("ksong.wrappacket.back");
                break;
            case 8:
                this.D.addHbUploadData("phiz.wrappacket.back");
                break;
            case 9:
                this.D.addHbUploadData("idiom.wrappacket.back");
                break;
            case 10:
                this.D.addHbUploadData("draw.wrappacket.back");
                break;
            case 11:
                this.D.addHbUploadData("only.wrappacket.back");
                break;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SendHbMainFragment", 2, "reportHbBack,curType:" + Bh);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        BaseHbFragment Ah = Ah();
        if (Ah != null) {
            Ah.onActivityResult(i3, i16, intent);
        }
        if (QLog.isColorLevel()) {
            QLog.i("SendHbMainFragment", 2, "onActivityResult, requestCode:" + i3 + " resultCode:" + i16 + " curFragment:" + Ah);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.ivTitleBtnLeft) {
            Nh();
            this.D.cancelCallBack();
            this.D.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.cci, (ViewGroup) null);
        Ih(inflate, getArguments());
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z16) {
        BaseHbFragment Ah;
        super.onHiddenChanged(z16);
        if (!z16 && (Ah = Ah()) != null && (Ah instanceof UsualHbFragment)) {
            Ah.setArguments(getArguments());
            Ah.onHiddenChanged(false);
        }
    }

    public int zh(int i3) {
        int i16;
        Iterator<b> it = this.K.iterator();
        while (true) {
            if (it.hasNext()) {
                b next = it.next();
                if (next.f277694a == i3) {
                    i16 = this.K.indexOf(next);
                    break;
                }
            } else {
                i16 = 0;
                break;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("SendHbMainFragment", 2, "findPositionByType, type:" + i3 + " pos:" + i16);
        }
        return i16;
    }
}

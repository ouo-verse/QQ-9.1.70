package com.qzone.reborn.feedx.fragment;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.qzone.app.ResourcePreloader;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.QZoneBaseFeedxFragment;
import com.qzone.reborn.event.QZoneFeedxRefreshEvent;
import com.qzone.reborn.event.QZoneHolidayRefreshFeedEvent;
import com.qzone.reborn.feedx.block.t;
import com.qzone.reborn.feedx.block.v;
import com.qzone.reborn.feedx.block.y;
import com.qzone.reborn.feedx.part.bz;
import com.qzone.reborn.feedx.part.p;
import com.qzone.reborn.feedx.viewmodel.q;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.Page;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.theme.SkinData;
import com.tencent.theme.SkinnableColorStateList;
import gf.k;
import gf.n;
import java.util.ArrayList;
import java.util.List;
import n6.d;
import n6.e;
import ve.i;

/* compiled from: P */
@Page(business = Business.QZone, type = PageHierarchy.MainPage)
/* loaded from: classes37.dex */
public class QZoneFriendFeedXFragment extends QZoneBaseFeedxFragment implements d.a, k, e.c, SimpleEventReceiver, com.tencent.mobileqq.pad.f, com.tencent.mobileqq.pad.d {
    public static final String TAG = "QZoneFriendFeedXFragment";
    private com.qzone.reborn.feedx.block.k mEmptyPageBlock;
    protected q mFeedDataViewModel;
    private y mFeedListAdapter;
    private v mHeaderBlock;
    private n6.d mHotBannerIoc;
    protected bz mListBlockPart;
    private gf.q mReadDivideLineIoc;
    protected n mTopBannerIoc;
    private t mTopEntranceBlock;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleHolidayRefreshEvent, reason: merged with bridge method [inline-methods] */
    public void lambda$onReceiveEvent$1(SimpleBaseEvent simpleBaseEvent) {
        RFWLog.d(TAG, RFWLog.USR, "receive holiday refresh event, event: " + simpleBaseEvent);
        bz bzVar = this.mListBlockPart;
        if (bzVar != null) {
            bzVar.refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleRefreshEvent, reason: merged with bridge method [inline-methods] */
    public void lambda$onReceiveEvent$0(SimpleBaseEvent simpleBaseEvent) {
        QZoneFeedxRefreshEvent qZoneFeedxRefreshEvent = (QZoneFeedxRefreshEvent) simpleBaseEvent;
        if ((qZoneFeedxRefreshEvent.getContext() == null || qZoneFeedxRefreshEvent.getContext() == getActivity()) && this.mListBlockPart != null) {
            RFWLog.d(TAG, RFWLog.USR, "receive a refresh event, context: " + qZoneFeedxRefreshEvent.getContext() + ", scrollToTop: " + qZoneFeedxRefreshEvent.getIsScrollToTop());
            this.mListBlockPart.K9();
        }
    }

    private void initViewModel() {
        this.mFeedDataViewModel = (q) getViewModel(q.class);
    }

    private void parseIntent(Intent intent) {
        if (intent.hasExtra("key_push_trans_channel")) {
            String stringExtra = intent.getStringExtra("key_push_trans_channel");
            try {
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.mFeedDataViewModel.R2(com.qzone.proxy.feedcomponent.util.b.a(stringExtra, 0));
                }
            } catch (Exception unused) {
                QLog.e(TAG, 1, "wrong base64", stringExtra);
            }
        }
        ro.a a16 = ro.a.a(intent);
        if (a16 != null) {
            this.mFeedDataViewModel.S2(a16.c());
        }
        this.mFeedDataViewModel.T2(intent);
    }

    private void printBackgroundInfo(View view) {
        ColorStateList color;
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        try {
            Drawable background = view.findViewById(R.id.n2d).getBackground();
            StringBuilder sb5 = new StringBuilder("QZoneFriendFeedXFragment Background");
            if (background instanceof GradientDrawable) {
                sb5.append(" GradientDrawable");
                color = ((GradientDrawable) background).getColor();
                if (color != null) {
                    sb5.append(", color=");
                    sb5.append(Integer.toHexString(color.getDefaultColor()));
                }
                if (color instanceof SkinnableColorStateList) {
                    SkinData skinData = ((SkinnableColorStateList) color).skinData;
                    sb5.append(", skinData=");
                    sb5.append(skinData);
                }
            }
            QLog.i("QZoneQUIProfile", 1, sb5.toString());
        } catch (Exception e16) {
            QLog.e("QZoneQUIProfile", 1, "QZoneFriendFeedXFragment printBackgroundInfo error:", e16);
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        bz bzVar = new bz(R.id.n2d, buildBlockList(false), false);
        this.mListBlockPart = bzVar;
        arrayList.add(bzVar);
        arrayList.addAll(new ve.k().c(new i().g("1").e(getMFromDtPageId())));
        arrayList.add(new p());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<MultiViewBlock> buildBlockList(boolean z16) {
        ArrayList arrayList = new ArrayList();
        v vVar = new v(null);
        this.mHeaderBlock = vVar;
        arrayList.add(vVar);
        if (z16) {
            t tVar = new t(null);
            this.mTopEntranceBlock = tVar;
            arrayList.add(tVar);
        }
        com.qzone.reborn.feedx.block.k kVar = new com.qzone.reborn.feedx.block.k(null);
        this.mEmptyPageBlock = kVar;
        arrayList.add(kVar);
        y yVar = new y(null);
        this.mFeedListAdapter = yVar;
        arrayList.add(yVar);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    public ViewStub getBannerContainerViewStub() {
        v vVar = this.mHeaderBlock;
        if (vVar != null && vVar.getSingleBlockRootView() != null) {
            return (ViewStub) this.mHeaderBlock.getSingleBlockRootView().findViewById(R.id.mzq);
        }
        QLog.e(TAG, 1, "getBannerContainerViewStub error: " + this.mHeaderBlock);
        return null;
    }

    @Override // n6.e.c
    public n6.d getBannerManager() {
        return this.mHotBannerIoc;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFeedxFragment
    public com.qzone.reborn.base.c getBlockPart() {
        return this.mListBlockPart;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ci9;
    }

    public int getCoverForegroundTrans() {
        return 0;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_bas_social_updates";
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneFeedxRefreshEvent.class);
        arrayList.add(QZoneHolidayRefreshFeedEvent.class);
        return arrayList;
    }

    @Override // com.qzone.reborn.feedx.viewmodel.a
    public tc.b getFeedxViewModel() {
        if (this.mFeedDataViewModel == null) {
            this.mFeedDataViewModel = (q) getViewModel(q.class);
        }
        return this.mFeedDataViewModel;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFeedxFragment
    public com.qzone.reborn.feedx.block.b getHeaderBlock() {
        return this.mHeaderBlock;
    }

    public BusinessFeedData getItemAtPosition(int i3) {
        y yVar = this.mFeedListAdapter;
        if (yVar != null) {
            return yVar.getItem(i3);
        }
        return null;
    }

    @Override // gf.k
    public int getPageType() {
        return 1;
    }

    public String getRefer() {
        return "1";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.qzone.util.ap.a
    public int getReportPageId() {
        return 12;
    }

    @Override // n6.e.c
    public FrameLayout getTopBannerContainer() {
        if (getActivity() != null) {
            ViewStub viewStub = (ViewStub) getActivity().findViewById(R.id.n1r);
            if (viewStub != null) {
                return (FrameLayout) viewStub.inflate().findViewById(R.id.n1q);
            }
            QLog.e(TAG, 4, "getTopBannerContainerViewStub error, viewStub is null");
            return null;
        }
        QLog.e(TAG, 1, "getTopBannerContainerViewStub error");
        return null;
    }

    public void initIoc() {
        n6.e eVar = new n6.e(getActivity(), this);
        this.mTopBannerIoc = eVar;
        registerIoc(eVar, n.class);
        n6.d dVar = new n6.d(getActivity(), this);
        this.mHotBannerIoc = dVar;
        registerIoc(dVar, gf.g.class);
        n6.a aVar = new n6.a();
        this.mReadDivideLineIoc = aVar;
        registerIoc(aVar, gf.q.class);
        registerIoc(this, k.class);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        q qVar = this.mFeedDataViewModel;
        if (qVar != null) {
            qVar.O2(System.currentTimeMillis());
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFeedxFragment, com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        lg.g.f414459a.k(System.currentTimeMillis());
        this.mTopBannerIoc.c();
        super.onDestroy();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFeedDataViewModel.T2(intent);
        this.mFeedDataViewModel.u2();
    }

    @Override // com.qzone.reborn.base.QZoneBaseFeedxFragment, com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        FragmentActivity activity = getActivity();
        if (activity != null && pl.a.f426446a.A() && com.qzone.reborn.configx.g.f53821a.b().n0()) {
            QLog.i(TAG, 1, "recreateFriendFeedWhenThemeChange");
            activity.onBackPressed();
            ho.i.j().a(activity, activity.getIntent());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneFeedxRefreshEvent) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.fragment.g
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneFriendFeedXFragment.this.lambda$onReceiveEvent$0(simpleBaseEvent);
                }
            });
        } else if (simpleBaseEvent instanceof QZoneHolidayRefreshFeedEvent) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.fragment.h
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneFriendFeedXFragment.this.lambda$onReceiveEvent$1(simpleBaseEvent);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        syncLoginStatus();
        ResourcePreloader.b().d();
        printBackgroundInfo(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        QLog.d(TAG, 1, "contentView.getContext: " + view.getContext());
        initIoc();
        initViewModel();
        if (getActivity() != null) {
            parseIntent(getActivity().getIntent());
        }
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        return false;
    }

    @Override // com.tencent.mobileqq.pad.d
    public boolean shouldDispatchActivityResult() {
        return true;
    }

    @Override // com.tencent.mobileqq.pad.d
    public boolean shouldDispatchPostThemeChanged() {
        return true;
    }

    @Override // n6.d.a
    public void notifyFirstFeedUpdateView() {
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
    }
}

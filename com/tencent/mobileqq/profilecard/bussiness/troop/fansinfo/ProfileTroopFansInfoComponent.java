package com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.IdolAdapter;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.fans.data.a;
import com.tencent.mobileqq.troop.utils.b;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xef6.oidb_0xef6$IdolInfo;
import tencent.im.oidb.cmd0xef6.oidb_0xef6$RspBody;

/* loaded from: classes16.dex */
public class ProfileTroopFansInfoComponent extends AbsQQProfileContentComponent implements IdolAdapter.IdolAdapterCallBack, AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileTroopFansInfoComponent";
    protected boolean bEnterWeb;
    private boolean hasReportExposure;
    private Handler mHandler;
    private boolean mHasScrollToTroopFans;
    protected IdolAdapter mIdolAdapter;
    private boolean mScrollToTroopFans;
    private a mTroopFansInfo;

    /* loaded from: classes16.dex */
    public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;
        private int space;

        public SpacesItemDecoration(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.space = i3;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, rect, view, recyclerView, state);
            } else {
                rect.right = this.space;
            }
        }
    }

    public ProfileTroopFansInfoComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        } else {
            this.bEnterWeb = false;
            this.hasReportExposure = false;
        }
    }

    private ArrayList<a.C8682a> convSvrRsp(oidb_0xef6$RspBody oidb_0xef6_rspbody) {
        ArrayList<a.C8682a> arrayList = new ArrayList<>();
        if (oidb_0xef6_rspbody == null) {
            return arrayList;
        }
        if (oidb_0xef6_rspbody.idol_list.has()) {
            List<oidb_0xef6$IdolInfo> list = oidb_0xef6_rspbody.idol_list.get();
            for (int i3 = 0; i3 < list.size(); i3++) {
                oidb_0xef6$IdolInfo oidb_0xef6_idolinfo = list.get(i3);
                a.C8682a c8682a = new a.C8682a();
                if (oidb_0xef6_idolinfo.idol_id.has()) {
                    c8682a.f295404a = oidb_0xef6_idolinfo.idol_id.get();
                }
                if (oidb_0xef6_idolinfo.avatar.has()) {
                    c8682a.f295406c = oidb_0xef6_idolinfo.avatar.get();
                }
                if (oidb_0xef6_idolinfo.pic.has()) {
                    c8682a.f295407d = oidb_0xef6_idolinfo.pic.get();
                }
                if (oidb_0xef6_idolinfo.name.has()) {
                    c8682a.f295405b = oidb_0xef6_idolinfo.name.get();
                }
                if (oidb_0xef6_idolinfo.rank.has()) {
                    c8682a.f295408e = oidb_0xef6_idolinfo.rank.get();
                }
                if (oidb_0xef6_idolinfo.score.has()) {
                    c8682a.f295409f = oidb_0xef6_idolinfo.score.get();
                }
                arrayList.add(c8682a);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "convSvrRsp idolItems:" + arrayList.toString());
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleGetIdolInfoOfCard(boolean z16, long j3, Object obj, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "handleGetIdolInfoOfCard isSuccess:" + z16 + " memberUin:" + j3 + " errCode:" + i3);
        }
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).allInOne != null && !TextUtils.isEmpty(((ProfileCardInfo) data).allInOne.uin) && String.valueOf(j3).equals(((ProfileCardInfo) this.mData).allInOne.uin) && z16 && obj != null && (obj instanceof oidb_0xef6$RspBody)) {
            ArrayList<a.C8682a> convSvrRsp = convSvrRsp((oidb_0xef6$RspBody) obj);
            a aVar = new a();
            this.mTroopFansInfo = aVar;
            aVar.f295403a = convSvrRsp;
            notifyUpdateUI();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [android.view.View, VIEW] */
    private boolean makeOrRefreshIdolList(ProfileCardInfo profileCardInfo) {
        a aVar;
        boolean z16 = true;
        if (b.b() && profileCardInfo != null && (aVar = this.mTroopFansInfo) != null && aVar.f295403a.size() != 0) {
            if (this.mViewContainer == 0) {
                ?? inflate = this.mActivity.getLayoutInflater().inflate(R.layout.frz, (ViewGroup) null);
                this.mViewContainer = inflate;
                RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.d9m);
                if (recyclerView != null) {
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity, 0, false);
                    linearLayoutManager.setAutoMeasureEnabled(true);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.addItemDecoration(new SpacesItemDecoration(ViewUtils.dpToPx(8.0f)));
                    if (this.mIdolAdapter == null) {
                        this.mIdolAdapter = new IdolAdapter(this.mActivity, profileCardInfo.troopUin, this);
                    }
                    recyclerView.setAdapter(this.mIdolAdapter);
                    recyclerViewEventListener(recyclerView);
                    reportExposure();
                }
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "makeOrRefreshIdolList show panel!");
                }
            } else {
                z16 = false;
            }
            IdolAdapter idolAdapter = this.mIdolAdapter;
            if (idolAdapter != null) {
                idolAdapter.setList(this.mTroopFansInfo.f295403a);
            }
            VIEW view = this.mViewContainer;
            if (view != 0) {
                View findViewById = ((View) view).findViewById(R.id.f164866b64);
                TextView textView = (TextView) findViewById.findViewById(R.id.jj7);
                findViewById.findViewById(R.id.icon);
                textView.setText(getTitleText(profileCardInfo));
                findViewById.setContentDescription(getTitleText(profileCardInfo));
                updateItemTheme(null, textView, null, null);
            }
            return z16;
        }
        if (this.mViewContainer != 0) {
            this.mViewContainer = null;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "makeOrRefreshIdolList remove panel!");
        }
        return z16;
    }

    private void notifyUpdateUI() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "notifyUpdateUI");
        }
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null) {
            iProfileActivityDelegate.notifyCardUpdate();
        }
    }

    private void recyclerViewEventListener(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return;
        }
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.ProfileTroopFansInfoComponent.1
            static IPatchRedirector $redirector_;
            private boolean mCheckInterceptTouch;
            private float mLastTouchDownX;
            private float mLastTouchDownY;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileTroopFansInfoComponent.this);
                }
            }

            private boolean moveHorizontal(MotionEvent motionEvent) {
                if (Math.abs(this.mLastTouchDownX - motionEvent.getX()) > Math.abs(this.mLastTouchDownY - motionEvent.getY())) {
                    return true;
                }
                return false;
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
            
                if (r0 != 3) goto L27;
             */
            @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onInterceptTouchEvent(RecyclerView recyclerView2, MotionEvent motionEvent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView2, (Object) motionEvent)).booleanValue();
                }
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            if (!this.mCheckInterceptTouch) {
                                this.mCheckInterceptTouch = true;
                                if (moveHorizontal(motionEvent) && recyclerView2.getParent() != null) {
                                    recyclerView2.getParent().requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                    if (recyclerView2.getParent() != null) {
                        recyclerView2.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                } else {
                    this.mLastTouchDownX = motionEvent.getX();
                    this.mLastTouchDownY = motionEvent.getY();
                    this.mCheckInterceptTouch = false;
                }
                return false;
            }

            @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
            public void onRequestDisallowInterceptTouchEvent(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, z16);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
            public void onTouchEvent(RecyclerView recyclerView2, MotionEvent motionEvent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) recyclerView2, (Object) motionEvent);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void reqFansInfo() {
        DATA data;
        if (b.b() && NetworkUtil.isNetworkAvailable(this.mActivity) && (data = this.mData) != 0) {
            AllInOne allInOne = ((ProfileCardInfo) data).allInOne;
        }
    }

    private void scrollToTroopFans() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.ProfileTroopFansInfoComponent.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileTroopFansInfoComponent.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int top;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (((AbsComponent) ProfileTroopFansInfoComponent.this).mViewContainer != null && (top = ((View) ((AbsComponent) ProfileTroopFansInfoComponent.this).mViewContainer).getTop()) >= 0 && ((AbsProfileComponent) ProfileTroopFansInfoComponent.this).mDelegate != null) {
                        ((AbsProfileComponent) ProfileTroopFansInfoComponent.this).mDelegate.scrollToMoreInfoView(top);
                    }
                }
            }, 1000L);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 1027;
    }

    protected String getGenderName(ProfileCardInfo profileCardInfo) {
        Card card;
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) profileCardInfo);
        }
        String string2 = this.mActivity.getString(R.string.f20598573);
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            if (card.shGender == 1) {
                string = this.mActivity.getString(R.string.f20597572);
            } else {
                string = this.mActivity.getString(R.string.f20598573);
            }
            return string;
        }
        return string2;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_FANS_INFO;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String getTitleText(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, (Object) profileCardInfo);
        }
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).allInOne != null && !TextUtils.isEmpty(((ProfileCardInfo) data).allInOne.uin) && ((ProfileCardInfo) this.mData).allInOne.uin.equals(this.mApp.getCurrentUin())) {
            return this.mActivity.getString(R.string.f20601576);
        }
        return String.format(this.mActivity.getString(R.string.f20602577), getGenderName(profileCardInfo));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.IdolAdapter.IdolAdapterCallBack
    public void gotoWeb() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).allInOne != null && !TextUtils.isEmpty(((ProfileCardInfo) data).allInOne.uin) && ((ProfileCardInfo) this.mData).allInOne.uin.equals(this.mApp.getCurrentUin())) {
            this.bEnterWeb = true;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i16 == -1 && i3 == 1012) {
            reqFansInfo();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        super.onCreate(qBaseActivity, bundle);
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null) {
            iProfileActivityDelegate.addProfileScrollListener(this);
        }
        Intent intent = this.mActivity.getIntent();
        if (intent != null) {
            this.mScrollToTroopFans = intent.getBooleanExtra("profile_scroll_to_troop_fans", false);
        }
        this.mHandler = new Handler(Looper.getMainLooper());
        reqFansInfo();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null) {
            iProfileActivityDelegate.removeProfileScrollListener(this);
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onPause();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onResume();
        if (this.bEnterWeb) {
            this.bEnterWeb = false;
            reqFansInfo();
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) absListView, i3);
        } else if (i3 == 0) {
            reportExposure();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.IdolAdapter.IdolAdapterCallBack
    public void onUpdateItemTheme(TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) textView);
        } else {
            updateItemTheme(textView, (View) null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void reportExposure() {
        VIEW view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else if (!this.hasReportExposure && (view = this.mViewContainer) != 0) {
            ((View) view).post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.ProfileTroopFansInfoComponent.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileTroopFansInfoComponent.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (ProfileUtils.isVisible((View) ((AbsComponent) ProfileTroopFansInfoComponent.this).mViewContainer) && !ProfileTroopFansInfoComponent.this.hasReportExposure) {
                        ReportController.o(null, "dc00898", "", "", "0X800B597", "0X800B597", 0, 0, "", "", "", "");
                        ProfileTroopFansInfoComponent.this.hasReportExposure = true;
                    }
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? super.lambda$checkValidComponent$3((ProfileTroopFansInfoComponent) profileCardInfo) | makeOrRefreshIdolList((ProfileCardInfo) this.mData) : ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) profileCardInfo)).booleanValue();
    }
}

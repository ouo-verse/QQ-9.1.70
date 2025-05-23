package com.tencent.mobileqq.profilecard.bussiness.achievement.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.bussiness.achievement.LifeAchivementHelper;
import com.tencent.mobileqq.profilecard.bussiness.achievement.bean.LifeAchivementData;
import com.tencent.mobileqq.profilecard.bussiness.achievement.handler.LifeAchievementHandler;
import com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementAdapter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* loaded from: classes16.dex */
public class LifeAchivementPanelView extends ProfileContentTitleView {
    static IPatchRedirector $redirector_ = null;
    static final String ADD_BADGE_URL = "https://downv6.qq.com/qq_relation/life_achivement/add_badge_v2.png";
    static final String DEFAULT_BADGE_URL = "https://downv6.qq.com/qq_relation/life_achivement/default_badge_v2.png";
    static final String EMPTY_VIEW_BACKGROUND_URL = "https://downv6.qq.com/qq_relation/life_achivement/lifeachivement_empty_bg.png";
    static final String TAG = "LifeAchivementPanelView";
    LifeAchivementAdapter achivementAdapter;
    RecyclerView achivementList;
    Button addAchivementBtn;
    RelativeLayout emptyView;
    private boolean isFriend;
    private boolean isSelf;
    LifeAchivementAdapter.OnItemClickListener itemClickListener;
    LifeAchievementHandler lifeAchievementHandler;
    String userOpenID;
    long userUin;

    public LifeAchivementPanelView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void initAchivementList() {
        RecyclerView recyclerView = new RecyclerView(getContext());
        this.achivementList = recyclerView;
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementPanelView.3
            static IPatchRedirector $redirector_;
            private boolean mCheckInterceptTouch;
            private float mLastTouchDownX;
            private float mLastTouchDownY;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LifeAchivementPanelView.this);
                }
            }

            private boolean moveHorizontal(MotionEvent motionEvent) {
                if (Math.abs(this.mLastTouchDownX - motionEvent.getX()) > Math.abs(this.mLastTouchDownY - motionEvent.getY())) {
                    return true;
                }
                return false;
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
            
                if (r4 != 3) goto L23;
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
                                if (moveHorizontal(motionEvent)) {
                                    LifeAchivementPanelView.this.getParent().requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                    LifeAchivementPanelView.this.getParent().requestDisallowInterceptTouchEvent(false);
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
        this.achivementList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementPanelView.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LifeAchivementPanelView.this);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                int i16 = 2;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView2, i3);
                    return;
                }
                super.onScrollStateChanged(recyclerView2, i3);
                if (i3 == 0) {
                    if (LifeAchivementPanelView.this.isSelf) {
                        i16 = 1;
                    }
                    ReportController.o(null, "", "", "", "0X800AE55", "0X800AE55", i16, 0, "", "", "", "");
                }
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.achivementList.setLayoutManager(linearLayoutManager);
        this.achivementList.addItemDecoration(new LifeAchivementAdapter.SpacesItemDecoration(Utils.n(5.0f, getResources()), Utils.n(0.0f, getResources())));
        this.itemClickListener = new LifeAchivementAdapter.OnItemClickListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementPanelView.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LifeAchivementPanelView.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementAdapter.OnItemClickListener
            public void onClickAchivement(View view, int i3) {
                int i16;
                int i17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(LifeAchivementPanelView.TAG, 2, "onClickAchivement position = " + i3);
                }
                LifeAchivementData dataByPosition = LifeAchivementPanelView.this.achivementAdapter.getDataByPosition(i3);
                if (dataByPosition != null) {
                    int i18 = dataByPosition.type;
                    if (i18 == 2) {
                        LifeAchivementHelper.jumpToLifeAchivementMiniAppAchivementListPage(((ProfileContentTitleView) LifeAchivementPanelView.this).mContext, LifeAchivementPanelView.this.userOpenID);
                        if (LifeAchivementPanelView.this.isSelf) {
                            i17 = 1;
                        } else {
                            i17 = 2;
                        }
                        ReportController.o(null, "", "", "", "0X800AE59", "0X800AE59", i17, 0, "", "", "", "");
                        return;
                    }
                    if (i18 == 1) {
                        LifeAchivementHelper.jumpToLifeAchivementMiniAppAddPage(((ProfileContentTitleView) LifeAchivementPanelView.this).mContext);
                        ReportController.o(null, "", "", "", "0X800AE54", "0X800AE54", 2, 0, "", "", "", "");
                        return;
                    }
                    LifeAchivementHelper.jumpToLifeAchivementMiniAppAchiivementDetailPage(((ProfileContentTitleView) LifeAchivementPanelView.this).mContext, LifeAchivementPanelView.this.userOpenID, dataByPosition.f260664id);
                    if (LifeAchivementPanelView.this.isSelf) {
                        i16 = 1;
                    } else {
                        i16 = 2;
                    }
                    ReportController.o(null, "", "", "", "0X800AE58", "0X800AE58", i16, 0, "", "", "", "");
                }
            }

            @Override // com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementAdapter.OnItemClickListener
            public void onClickPraise(View view, int i3) {
                int i16;
                int i17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, i3);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(LifeAchivementPanelView.TAG, 2, "onClickPraise position = " + i3 + ",isSelf = " + LifeAchivementPanelView.this.isSelf + ",isFriend = " + LifeAchivementPanelView.this.isFriend);
                }
                LifeAchivementHelper.setViewClickInterval(view);
                if (!LifeAchivementPanelView.this.isSelf && !LifeAchivementPanelView.this.isFriend) {
                    QQToast.makeText(((ProfileContentTitleView) LifeAchivementPanelView.this).mContext, view.getResources().getString(R.string.f199654q0), 0).show();
                    return;
                }
                LifeAchivementData dataByPosition = LifeAchivementPanelView.this.achivementAdapter.getDataByPosition(i3);
                if (dataByPosition == null) {
                    if (QLog.isColorLevel()) {
                        QLog.i(LifeAchivementPanelView.TAG, 2, "onClickPraise return for null data");
                        return;
                    }
                    return;
                }
                if (dataByPosition.hasPraised) {
                    i16 = 2;
                } else {
                    i16 = 1;
                }
                LifeAchivementPanelView.this.updateLocalPraiseData(dataByPosition, i3, i16);
                LifeAchivementPanelView lifeAchivementPanelView = LifeAchivementPanelView.this;
                LifeAchievementHandler lifeAchievementHandler = lifeAchivementPanelView.lifeAchievementHandler;
                if (lifeAchievementHandler != null) {
                    lifeAchievementHandler.praiseLifeAchievement(lifeAchivementPanelView.userUin, dataByPosition.f260664id, i16);
                }
                if (LifeAchivementPanelView.this.isSelf) {
                    i17 = 1;
                } else {
                    i17 = 2;
                }
                ReportController.o(null, "", "", "", "0X800AE56", "0X800AE56", i17, 0, "", "", "", "");
            }
        };
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "init ");
        }
        LifeAchivementAdapter lifeAchivementAdapter = new LifeAchivementAdapter(getContext(), null, this.itemClickListener);
        this.achivementAdapter = lifeAchivementAdapter;
        this.achivementList.setAdapter(lifeAchivementAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLocalPraiseData(LifeAchivementData lifeAchivementData, int i3, int i16) {
        if (i16 == 1) {
            lifeAchivementData.hasPraised = true;
            lifeAchivementData.praiseNum++;
        } else if (i16 == 2) {
            lifeAchivementData.hasPraised = false;
            lifeAchivementData.praiseNum--;
        }
        this.achivementAdapter.notifyItemChanged(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.init();
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.h0u, (ViewGroup) this, false);
        this.emptyView = relativeLayout;
        Button button = (Button) relativeLayout.findViewById(R.id.yc8);
        this.addAchivementBtn = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementPanelView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LifeAchivementPanelView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(LifeAchivementPanelView.TAG, 2, "addAchivementBtn onClicked");
                    }
                    LifeAchivementHelper.jumpToLifeAchivementMiniAppAddPage(((ProfileContentTitleView) LifeAchivementPanelView.this).mContext);
                    ReportController.o(null, "", "", "", "0X800AE54", "0X800AE54", 1, 0, "", "", "", "");
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        URLImageView uRLImageView = (URLImageView) this.emptyView.findViewById(R.id.yc7);
        if (uRLImageView != null) {
            uRLImageView.setImageURL(EMPTY_VIEW_BACKGROUND_URL);
            uRLImageView.setVisibility(0);
        }
        initAchivementList();
        this.mTitleContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementPanelView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LifeAchivementPanelView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                int i3 = 2;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.i(LifeAchivementPanelView.TAG, 2, "DATA_TYPE_LIFE_ACHIVEMENT_TITLE on click");
                    }
                    LifeAchivementHelper.jumpToLifeAchivementMiniAppAchivementListPage(((ProfileContentTitleView) LifeAchivementPanelView.this).mContext, LifeAchivementPanelView.this.userOpenID);
                    if (LifeAchivementPanelView.this.isSelf) {
                        i3 = 1;
                    }
                    ReportController.o(null, "", "", "", "0X800AE57", "0X800AE57", i3, 0, "", "", "", "");
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.mTitleContainer.setContentDescription(getResources().getString(R.string.zof));
    }

    public void setLifeAchievementHandler(LifeAchievementHandler lifeAchievementHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) lifeAchievementHandler);
        } else {
            this.lifeAchievementHandler = lifeAchievementHandler;
        }
    }

    public void showAchivementList(ArrayList<LifeAchivementData> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) arrayList, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "showAchivementList dataArrayList.size() = " + arrayList.size() + ",totalCount = " + i3);
        }
        removeContentViews();
        addContentView(this.achivementList);
        this.achivementAdapter.updateDatas(arrayList, i3, this.isSelf);
    }

    public void showEmptyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "showEmptyView");
        }
        removeContentViews();
        addContentView(this.emptyView);
    }

    public void updateUserInfo(ProfileCardInfo profileCardInfo, Card card, String str) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, profileCardInfo, card, str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        boolean isPaTypeFriend = ProfilePAUtils.isPaTypeFriend(profileCardInfo.allInOne);
        boolean z16 = true;
        try {
            j3 = Long.valueOf(card.uin).longValue();
        } catch (NumberFormatException e16) {
            QLog.d(TAG, 1, "updateUserInfo exception ", e16);
            j3 = 0;
        }
        if (profileCardInfo.allInOne.f260789pa != 0) {
            z16 = false;
        }
        this.isFriend = isPaTypeFriend;
        this.userOpenID = str;
        this.isSelf = z16;
        this.userUin = j3;
    }

    public LifeAchivementPanelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }
}

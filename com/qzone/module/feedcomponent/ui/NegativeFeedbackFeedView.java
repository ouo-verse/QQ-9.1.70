package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.module.feedcomponent.ui.NegativeFeedbackAdapter;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellNegativeFeedback;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class NegativeFeedbackFeedView extends AbsFeedView {
    public static final int MODE_FEED = 1;
    public static final int MODE_VIDEO = 2;
    private static String choose = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ChooseReasonWhyYouNotInterest", "\u9009\u62e9\u4f60\u4e0d\u611f\u5174\u8da3\u7684\u539f\u56e0");
    private static String commit = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CommitReasonWhyYouNotInterest", "\u63d0\u4ea4\u539f\u56e0");
    private static String hasChoose = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ChooseSomeReason", "\u5df2\u9009\u62e9");
    private static String reason = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "HowManyReason", "\u4e2a\u539f\u56e0");
    private ImageView closeIv;
    private FbGridView contentGv;
    private BusinessFeedData currentFeedData;
    private int currentMode;
    private int currentSelectNumber;
    private NegativeFeedbackAdapter fbAdapter;
    private RelativeLayout feedBackRl;
    private View fill;
    private View gap;
    private ArrayList<CellNegativeFeedback.negativeFbInfo> infos;
    NegativeFeedbackAdapter.SelectionChangeListener listener;
    protected OnCloseListener mCloseListener;
    private Context mContext;
    protected int mFeedPosition;
    protected com.qzone.proxy.feedcomponent.ui.g mOnFeedElementClickListener;
    private View mRootView;
    protected onSubmitLisetener mSubmitListener;
    private int mTrans;
    private TextView submitTv;
    private TextView titleTv;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface OnCloseListener {
        void onClick(View view, FeedElement feedElement, int i3, Object obj);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface onSubmitLisetener {
        void onClick(View view, FeedElement feedElement, int i3, Object obj);
    }

    public NegativeFeedbackFeedView(Context context) {
        super(context);
        this.mTrans = 255;
        this.infos = new ArrayList<>();
        this.currentMode = -1;
        this.currentSelectNumber = 0;
        this.currentFeedData = null;
        this.mCloseListener = null;
        this.mSubmitListener = null;
        this.listener = new NegativeFeedbackAdapter.SelectionChangeListener() { // from class: com.qzone.module.feedcomponent.ui.NegativeFeedbackFeedView.5
            @Override // com.qzone.module.feedcomponent.ui.NegativeFeedbackAdapter.SelectionChangeListener
            public void onSelectedChanged(int i3) {
                Log.d("test", "selectNumber : " + i3);
                NegativeFeedbackFeedView.this.currentSelectNumber = i3;
                NegativeFeedbackFeedView.this.updateUI();
            }
        };
        this.mContext = context;
        setOrientation(1);
        setBackgroundColor(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.NegativeFeedbackFeedView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        View view = new View(context);
        this.gap = view;
        int i3 = this.currentMode;
        if (i3 == 1) {
            view.setBackgroundColor(com.qzone.adapter.feedcomponent.j.s());
        } else if (i3 == 2) {
            view.setBackgroundColor(-14211285);
        }
        this.gap.setLayoutParams(new LinearLayout.LayoutParams(-1, AreaConst.dp15));
        addView(this.gap);
        View inflate = LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(FSUploadConst.ERR_UPLOAD_RESULT_ILLEGAL), (ViewGroup) null);
        this.mRootView = inflate;
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.mRootView.setBackgroundColor(0);
        addView(this.mRootView);
        this.feedBackRl = (RelativeLayout) this.mRootView.findViewById(com.qzone.adapter.feedcomponent.j.O(2683));
        this.titleTv = (TextView) this.mRootView.findViewById(com.qzone.adapter.feedcomponent.j.O(2677));
        this.closeIv = (ImageView) this.mRootView.findViewById(com.qzone.adapter.feedcomponent.j.O(2678));
        this.contentGv = (FbGridView) this.mRootView.findViewById(com.qzone.adapter.feedcomponent.j.O(2679));
        this.submitTv = (TextView) this.mRootView.findViewById(com.qzone.adapter.feedcomponent.j.O(2680));
        this.fill = this.mRootView.findViewById(com.qzone.adapter.feedcomponent.j.O(2685));
        this.closeIv.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.NegativeFeedbackFeedView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                NegativeFeedbackFeedView negativeFeedbackFeedView;
                OnCloseListener onCloseListener;
                EventCollector.getInstance().onViewClickedBefore(view2);
                if (NegativeFeedbackFeedView.this.currentMode != 1) {
                    if (NegativeFeedbackFeedView.this.currentMode == 2 && (onCloseListener = (negativeFeedbackFeedView = NegativeFeedbackFeedView.this).mCloseListener) != null) {
                        onCloseListener.onClick(negativeFeedbackFeedView, FeedElement.FEED_NEGATIVE_FEEDBACK_DEL_BUTTON_CLICK, negativeFeedbackFeedView.mFeedPosition, null);
                    }
                } else {
                    NegativeFeedbackFeedView negativeFeedbackFeedView2 = NegativeFeedbackFeedView.this;
                    com.qzone.proxy.feedcomponent.ui.g gVar = negativeFeedbackFeedView2.mOnFeedElementClickListener;
                    if (gVar != null) {
                        gVar.onClick(negativeFeedbackFeedView2, FeedElement.FEED_NEGATIVE_FEEDBACK_DEL_BUTTON_CLICK, negativeFeedbackFeedView2.mFeedPosition, null);
                    }
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.submitTv.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.NegativeFeedbackFeedView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                NegativeFeedbackFeedView negativeFeedbackFeedView;
                onSubmitLisetener onsubmitlisetener;
                EventCollector.getInstance().onViewClickedBefore(view2);
                ArrayList<CellNegativeFeedback.negativeFbInfo> selectInfos = NegativeFeedbackFeedView.this.fbAdapter != null ? NegativeFeedbackFeedView.this.fbAdapter.getSelectInfos() : null;
                if (NegativeFeedbackFeedView.this.currentMode != 1) {
                    if (NegativeFeedbackFeedView.this.currentMode == 2 && (onsubmitlisetener = (negativeFeedbackFeedView = NegativeFeedbackFeedView.this).mSubmitListener) != null) {
                        onsubmitlisetener.onClick(negativeFeedbackFeedView, FeedElement.FEED_NEGATIVE_FEEDBACK_SUBMIT_BUTTON_CLICK, negativeFeedbackFeedView.mFeedPosition, selectInfos);
                    }
                } else {
                    NegativeFeedbackFeedView negativeFeedbackFeedView2 = NegativeFeedbackFeedView.this;
                    com.qzone.proxy.feedcomponent.ui.g gVar = negativeFeedbackFeedView2.mOnFeedElementClickListener;
                    if (gVar != null) {
                        gVar.onClick(negativeFeedbackFeedView2, FeedElement.FEED_NEGATIVE_FEEDBACK_SUBMIT_BUTTON_CLICK, negativeFeedbackFeedView2.mFeedPosition, selectInfos);
                    }
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
    }

    private void setBackGroundAlpha() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && childAt.getBackground() != null) {
                childAt.getBackground().setAlpha(this.mTrans);
            }
            if (childAt instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) childAt;
                int childCount2 = relativeLayout.getChildCount();
                for (int i16 = 0; i16 < childCount2; i16++) {
                    View childAt2 = relativeLayout.getChildAt(i16);
                    if (childAt2 != null && childAt2.getBackground() != null) {
                        childAt2.getBackground().setAlpha(this.mTrans);
                    }
                    if (childAt2 instanceof FbGridView) {
                        FbGridView fbGridView = (FbGridView) childAt2;
                        int childCount3 = fbGridView.getChildCount();
                        for (int i17 = 0; i17 < childCount3; i17++) {
                            View childAt3 = fbGridView.getChildAt(i17);
                            if (childAt3 != null && childAt3.getBackground() != null) {
                                childAt3.getBackground().setAlpha(this.mTrans);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUI() {
        int i3 = this.currentMode;
        if (i3 == 1) {
            this.feedBackRl.setBackgroundColor(-1);
            this.titleTv.setTextColor(-16777216);
            this.closeIv.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(823));
            this.submitTv.setTextColor(-4473925);
            this.submitTv.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(825));
            this.gap.setBackgroundColor(com.qzone.adapter.feedcomponent.j.s());
        } else if (i3 == 2) {
            this.feedBackRl.setBackgroundColor(-14211285);
            this.titleTv.setTextColor(-10066330);
            this.closeIv.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(824));
            this.submitTv.setTextColor(-12237496);
            this.submitTv.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO));
            this.gap.setVisibility(8);
        }
        int i16 = this.currentSelectNumber;
        if (i16 == 0) {
            this.titleTv.setText(choose);
            this.submitTv.setText(commit);
            this.submitTv.setEnabled(false);
        } else if (i16 > 0) {
            this.titleTv.setText(hasChoose + this.currentSelectNumber + reason);
            this.submitTv.setText(commit);
            int i17 = this.currentMode;
            if (i17 == 1) {
                this.submitTv.setTextColor(-14132067);
            } else if (i17 == 2) {
                this.submitTv.setTextColor(-1);
            }
            this.submitTv.setEnabled(true);
        }
        if (this.currentMode == 1) {
            setBackGroundAlpha();
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    /* renamed from: getFeedPosition */
    public int getMFeedPosition() {
        return this.mFeedPosition;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean hasVideoPlayed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAlwaysAutoPlayFeed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAutoVideoFeed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setAlpha(int i3) {
        this.mTrans = i3;
        if (this.currentMode == 1) {
            setBackGroundAlpha();
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setFeedPosition(int i3) {
        this.mFeedPosition = i3;
    }

    public void setOnCloseLinstener(OnCloseListener onCloseListener) {
        this.mCloseListener = onCloseListener;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.mOnFeedElementClickListener = gVar;
    }

    public void setOnSubmitListener(onSubmitLisetener onsubmitlisetener) {
        this.mSubmitListener = onsubmitlisetener;
    }

    public void setData(BusinessFeedData businessFeedData, int i3) {
        CellNegativeFeedback cellNegativeFeedback;
        CellNegativeFeedback cellNegativeFeedback2;
        ArrayList<CellNegativeFeedback.negativeFbInfo> arrayList;
        this.currentSelectNumber = 0;
        this.currentFeedData = businessFeedData;
        this.currentMode = i3;
        ArrayList<CellNegativeFeedback.negativeFbInfo> arrayList2 = this.infos;
        if (arrayList2 != null) {
            arrayList2.clear();
            BusinessFeedData businessFeedData2 = this.currentFeedData;
            if (businessFeedData2 != null && (cellNegativeFeedback2 = businessFeedData2.cellNegativeFeedback) != null && (arrayList = cellNegativeFeedback2.nagativeFbInfos) != null && arrayList.size() > 0) {
                Iterator<CellNegativeFeedback.negativeFbInfo> it = this.currentFeedData.cellNegativeFeedback.nagativeFbInfos.iterator();
                while (it.hasNext()) {
                    CellNegativeFeedback.negativeFbInfo next = it.next();
                    if (next != null) {
                        this.infos.add(next);
                    }
                }
            }
        }
        BusinessFeedData businessFeedData3 = this.currentFeedData;
        if (businessFeedData3 != null && businessFeedData3.isGDTAdvFeed() && (cellNegativeFeedback = this.currentFeedData.cellNegativeFeedback) != null && !TextUtils.isEmpty(cellNegativeFeedback.leftTitle) && !TextUtils.isEmpty(this.currentFeedData.cellNegativeFeedback.buttonTxt)) {
            CellNegativeFeedback cellNegativeFeedback3 = this.currentFeedData.cellNegativeFeedback;
            choose = cellNegativeFeedback3.leftTitle;
            commit = cellNegativeFeedback3.buttonTxt;
        } else {
            choose = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ChooseReasonWhyYouNotInterest", "\u9009\u62e9\u4f60\u4e0d\u611f\u5174\u8da3\u7684\u539f\u56e0");
            commit = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CommitReasonWhyYouNotInterest", "\u63d0\u4ea4\u539f\u56e0");
        }
        updateUI();
        NegativeFeedbackAdapter negativeFeedbackAdapter = new NegativeFeedbackAdapter(this.mContext, this.listener);
        this.fbAdapter = negativeFeedbackAdapter;
        negativeFeedbackAdapter.setData(this.infos, this.currentMode);
        this.contentGv.setAdapter((ListAdapter) this.fbAdapter);
        this.contentGv.setSelector(new ColorDrawable(0));
        this.contentGv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.qzone.module.feedcomponent.ui.NegativeFeedbackFeedView.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i16, long j3) {
                EventCollector.getInstance().onItemClickBefore(adapterView, view, i16, j3);
                Log.d("test", "position : " + i16);
                if (view instanceof FbGridView) {
                    FbGridView fbGridView = (FbGridView) view;
                    if (fbGridView.getChildCount() > 0 && (fbGridView.getChildAt(0) instanceof CheckBox)) {
                        fbGridView.getChildAt(0).performClick();
                    }
                }
                EventCollector.getInstance().onItemClick(adapterView, view, i16, j3);
            }
        });
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdle() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdleOnDetail(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateScrolling() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasRecommHeader(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasSearchSeparator(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setNeedFillBlackArea(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedEventListener(com.qzone.proxy.feedcomponent.ui.h hVar) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void startFlashNickName() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateLikeInfo(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateRecommAction(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTransparentBackground(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void reportFeed(BusinessFeedData businessFeedData, int i3) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void showSearchSeparator(boolean z16, String str) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTitle(BusinessFeedData businessFeedData, Boolean bool) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateSpecialFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
    }
}

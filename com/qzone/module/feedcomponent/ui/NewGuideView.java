package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.CanvasEnhancedAvatarArea;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGuiding;
import com.qzone.proxy.feedcomponent.model.GuideButton;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.ditto.widget.DittoListArea;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class NewGuideView extends AbsFeedView {
    private int feedPosition;
    private NewGuideCanvasView guideCanvasView;
    private int mAlpha;
    private com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener;

    public NewGuideView(Context context) {
        super(context);
        this.mAlpha = 255;
        initView();
    }

    private void initView() {
        this.guideCanvasView = new NewGuideCanvasView(getContext());
        addView(this.guideCanvasView, new LinearLayout.LayoutParams(-1, -2));
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
        this.mAlpha = i3;
        int m3 = com.qzone.adapter.feedcomponent.j.m();
        setBackgroundColor(Color.argb(i3, Color.red(m3), Color.green(m3), Color.blue(m3)));
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setData(BusinessFeedData businessFeedData) {
        super.setData(businessFeedData);
        this.guideCanvasView.setFeedData(businessFeedData);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setFeedPosition(int i3) {
        this.feedPosition = i3;
        this.guideCanvasView.setFeedPosition(i3);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.onFeedElementClickListener = gVar;
        this.guideCanvasView.setOnFeedElementClickListener(gVar);
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

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class NewGuideCanvasView extends QzoneCanvasAreaView {
        private ListAdapter adapter;

        @DittoField
        DittoListArea avatars;
        private BusinessFeedData businessFeedData;

        @DittoField
        AsyncCanvasImageArea button;

        @DittoField
        DittoArea card;

        @DittoField
        AsyncCanvasImageArea contentBackgroundImage;

        @DittoField
        RichCanvasTextArea leftTitle;

        @DittoField
        DittoArea moreIndicator;

        @DittoField
        AsyncCanvasImageArea moreIndicatorIcon;

        @DittoField
        RichCanvasTextArea moreIndicatorText;

        @DittoField
        DittoImageArea rightIcon;

        @DittoField
        RichCanvasTextArea subSummary;

        @DittoField
        RichCanvasTextArea summary;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes39.dex */
        public class ListAdapter implements DittoListArea.ListAreaAdapter {
            private List<User> users;

            ListAdapter() {
            }

            @Override // com.tencent.ditto.widget.DittoListArea.ListAreaAdapter
            public DittoArea getArea(DittoListArea dittoListArea, int i3, int i16) {
                LayoutAttrSet layoutAttrSet = new LayoutAttrSet();
                int i17 = AreaManager.dp37;
                layoutAttrSet.height = i17;
                layoutAttrSet.width = i17;
                layoutAttrSet.addLayoutAttr(LayoutAttrDefine.BorderWidth, "2dp");
                layoutAttrSet.addLayoutAttr(LayoutAttrDefine.BorderColor, TipsElementData.DEFAULT_COLOR);
                layoutAttrSet.addLayoutAttr(LayoutAttrDefine.BorderRadius, "18.5dp");
                CanvasEnhancedAvatarArea canvasEnhancedAvatarArea = new CanvasEnhancedAvatarArea(NewGuideCanvasView.this, layoutAttrSet);
                if (i16 == 4 && this.users.size() > 5) {
                    canvasEnhancedAvatarArea.setMaskType(1);
                } else {
                    canvasEnhancedAvatarArea.setMaskType(0);
                }
                canvasEnhancedAvatarArea.setUser(this.users.get(i16));
                return canvasEnhancedAvatarArea;
            }

            @Override // com.tencent.ditto.widget.DittoListArea.ListAreaAdapter
            public int numberOfRows(DittoListArea dittoListArea, int i3) {
                List<User> list = this.users;
                if (list == null) {
                    return 0;
                }
                return Math.min(list.size(), 5);
            }

            public void setUsers(List<User> list) {
                this.users = list;
            }
        }

        public NewGuideCanvasView(Context context) {
            super(context);
            this.adapter = new ListAdapter();
            setContentAreaForJsonFile("qzone_canvas_ui_new_function_guide.json");
            int screenWidth = ViewUtils.getScreenWidth() - AreaManager.dp18;
            LayoutAttrSet layoutAttr = this.contentBackgroundImage.getLayoutAttr();
            layoutAttr.width = screenWidth;
            layoutAttr.height = (int) ((screenWidth / 718.0f) * 406.0f);
            this.card.setShadowDrawable(AreaManager.QZONE_NEW_GUIDE_SHADOW_BG);
            DittoArea dittoArea = this.card;
            int i3 = AreaConst.f48747dp2;
            int i16 = AreaConst.f48749dp4;
            dittoArea.setShadowSize(i3, i16, i3, i16);
            this.rightIcon.setImageResource(com.qzone.adapter.feedcomponent.j.h(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY));
            this.rightIcon.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.subSummary.setMaxLines(1);
            this.summary.setMaxLines(1);
            this.avatars.setAdapter(this.adapter);
            this.avatars.setItemInterval(AreaManager.dp9);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @DittoOnClick(IndividuationUrlHelper.UrlId.CARD_HOME)
        public void onCardClick(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
            com.qzone.proxy.feedcomponent.ui.g gVar;
            if (this.businessFeedData.getCellGuiding().vecButton == null || this.businessFeedData.getCellGuiding().vecButton.size() == 0) {
                return;
            }
            String str = this.businessFeedData.getCellGuiding().vecButton.get(0).actionUrl;
            if (TextUtils.isEmpty(str) || (gVar = this.onFeedElementClickListener) == null) {
                return;
            }
            FeedElement feedElement = FeedElement.URL;
            int i3 = this.feedPosition;
            gVar.onClick(this, feedElement, i3, new com.qzone.proxy.feedcomponent.model.e(str, "", i3));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @DittoOnClick("rightIcon")
        public void onFeedbackClicked(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
            com.qzone.proxy.feedcomponent.ui.g gVar = this.onFeedElementClickListener;
            if (gVar != null) {
                FeedElement feedElement = FeedElement.FEEDBACK;
                int i3 = this.feedPosition;
                gVar.onClick(this, feedElement, i3, Integer.valueOf(i3));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @DittoOnClick("moreIndicator")
        public void onMoreClicked(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
            com.qzone.proxy.feedcomponent.ui.g gVar;
            String str = this.businessFeedData.getCellGuiding().action_url;
            if (!TextUtils.isEmpty(str) && (gVar = this.onFeedElementClickListener) != null) {
                FeedElement feedElement = FeedElement.URL;
                int i3 = this.feedPosition;
                gVar.onClick(this, feedElement, i3, new com.qzone.proxy.feedcomponent.model.e(str, "", i3));
            }
            com.qzone.adapter.feedcomponent.i.H().g(302, 102, 2, "", this.businessFeedData.getCellGuiding().guiding_type + "", "");
        }

        public void setFeedData(BusinessFeedData businessFeedData) {
            boolean z16;
            this.businessFeedData = businessFeedData;
            CellGuiding cellGuiding = businessFeedData.getCellGuiding();
            if (TextUtils.isEmpty(cellGuiding.button_title) && TextUtils.isEmpty(cellGuiding.button_icon)) {
                this.moreIndicator.setVisibility(8);
            } else {
                if (TextUtils.isEmpty(cellGuiding.button_title)) {
                    this.moreIndicatorText.setVisibility(8);
                } else {
                    this.moreIndicatorText.setText(cellGuiding.button_title);
                    this.moreIndicatorText.setVisibility(0);
                }
                if (TextUtils.isEmpty(cellGuiding.button_icon)) {
                    this.moreIndicatorIcon.setVisibility(8);
                } else {
                    this.moreIndicatorIcon.setAsyncImage(null, cellGuiding.button_icon, null, null);
                    this.moreIndicatorIcon.setVisibility(0);
                }
            }
            this.contentBackgroundImage.setAsyncImage(null, cellGuiding.pic.getCurrentUrl().url, null, null);
            this.leftTitle.setTextColor(com.qzone.adapter.feedcomponent.j.o());
            this.leftTitle.setText(cellGuiding.title);
            ArrayList<User> arrayList = cellGuiding.vecUsers;
            if (arrayList != null && arrayList.size() != 0) {
                this.adapter.setUsers(cellGuiding.vecUsers);
                this.avatars.reloadRows();
                this.avatars.setVisibility(0);
                z16 = true;
            } else {
                this.adapter.setUsers(null);
                this.avatars.reloadRows();
                this.avatars.setVisibility(8);
                z16 = false;
            }
            if (TextUtils.isEmpty(cellGuiding.summary)) {
                this.summary.setVisibility(8);
            } else {
                this.summary.setText(cellGuiding.summary);
                this.summary.setVisibility(0);
            }
            if (TextUtils.isEmpty(cellGuiding.subSummary)) {
                this.subSummary.setVisibility(8);
            } else {
                this.subSummary.setText(cellGuiding.subSummary);
                this.subSummary.setVisibility(0);
            }
            if (z16) {
                this.summary.setTextSize(17.0f);
                this.subSummary.setTextSize(14.0f);
            } else {
                this.summary.setTextSize(22.0f);
                this.subSummary.setTextSize(14.0f);
            }
            ArrayList<GuideButton> arrayList2 = cellGuiding.vecButton;
            if (arrayList2 != null && arrayList2.size() != 0) {
                this.button.setAsyncImage(null, cellGuiding.vecButton.get(0).picUrl, null, null);
                this.button.setVisibility(0);
            } else {
                this.button.setVisibility(8);
                this.button.setAsyncImage(null, null, null, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @DittoOnClick("root")
        public void onRootClick(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateSpecialFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
    }
}

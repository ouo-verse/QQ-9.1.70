package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.qzone.adapter.feedcomponent.IResult;
import com.qzone.adapter.feedcomponent.IServiceCallback;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.CanvasAvatarArea;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGuiding;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.LinearAreaLayout;
import com.tencent.ditto.widget.RelativeAreaLayout;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BirthdayCardFeedView extends AbsFeedView {
    CanvasBirthdayView birthdayView;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class CanvasBirthdayView extends QzoneCanvasAreaView {
        String actionUrl;

        @DittoField
        AsyncCanvasImageArea birthdayCardBg;

        @DittoField
        DittoButtonArea birthdayCardButton;

        @DittoField
        DittoButtonArea birthdayCardButtonClicked;

        @DittoField
        LinearAreaLayout birthdayCardCheckLin;

        @DittoField
        RichCanvasTextArea birthdayCardCheckTitle;

        @DittoField
        AsyncCanvasImageArea birthdayCardClose;

        @DittoField
        CanvasAvatarArea birthdayCardIcon;

        @DittoField
        AsyncCanvasImageArea birthdayCardSelect;

        @DittoField
        RichCanvasTextArea birthdayCardTitle;

        @DittoField
        AsyncCanvasImageArea birthdayCardUnSelect;

        @DittoField
        AsyncCanvasImageArea birthdayRootBg;

        @DittoField
        RelativeAreaLayout birthdayRootContainer;
        BusinessFeedData businessFeedData;
        String decorationPicUrl;
        String defaultMoreUrl;
        String eventId;
        boolean isSelectShuoshuo;
        String isSyncShuoshuo;

        @DittoField
        AsyncCanvasImageArea moreIcon;

        @DittoField
        LinearAreaLayout moreLin;

        @DittoField
        RichCanvasTextArea moreTitle;
        String picData;
        String ruleId;
        String titleName;

        public CanvasBirthdayView(Context context) {
            this(context, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void init(Context context, BusinessFeedData businessFeedData) {
            Map<String, String> map;
            this.businessFeedData = businessFeedData;
            setContentAreaForJsonFile("qzone_canvas_ui_birthday_card.json");
            CellGuiding cellGuiding = businessFeedData.getCellGuiding();
            if (cellGuiding != null && (map = cellGuiding.extendInfo) != null) {
                this.titleName = cellGuiding.title;
                this.picData = map.get("back_pic_url");
                this.decorationPicUrl = cellGuiding.extendInfo.get("decoration_pic_url");
                this.isSyncShuoshuo = cellGuiding.extendInfo.get("is_sync_shuoshuo");
                this.eventId = cellGuiding.extendInfo.get("event_id");
                this.ruleId = cellGuiding.extendInfo.get("rule_id");
                String str = cellGuiding.action_url;
                this.actionUrl = str;
                if (TextUtils.isEmpty(str)) {
                    this.actionUrl = this.defaultMoreUrl;
                }
                if (this.isSyncShuoshuo.equals("1")) {
                    this.birthdayCardCheckLin.setVisibility(0);
                }
                this.birthdayCardTitle.setText(this.titleName);
                this.birthdayCardClose.setScaleType(ImageView.ScaleType.FIT_XY);
                this.birthdayCardClose.setImageResource(com.qzone.adapter.feedcomponent.j.h(726));
                this.birthdayRootBg.setAsyncImage(null, this.picData, null, null);
                this.birthdayCardBg.setAsyncImage(null, this.decorationPicUrl, null, null);
                this.birthdayCardIcon.setAvatar(com.qzone.adapter.feedcomponent.i.H().j0(), AreaManager.dp68, AreaManager.DEFAULT_AVATAR);
                this.birthdayCardButtonClicked.setBackgroundDrawable(context.getResources().getDrawable(com.qzone.adapter.feedcomponent.j.h(733)));
                this.birthdayCardButton.setBackgroundDrawable(context.getResources().getDrawable(com.qzone.adapter.feedcomponent.j.h(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION)));
                this.moreIcon.setImageResource(com.qzone.adapter.feedcomponent.j.h(com.tencent.luggage.wxa.ci.a.CTRL_INDEX));
                this.birthdayCardSelect.setImageResource(com.qzone.adapter.feedcomponent.j.h(com.tencent.luggage.wxa.ci.b.CTRL_INDEX));
                this.birthdayCardUnSelect.setImageResource(com.qzone.adapter.feedcomponent.j.h(com.tencent.luggage.wxa.wh.b.CTRL_INDEX));
                if (cellGuiding.isDressed) {
                    this.birthdayCardButton.setVisibility(8);
                    this.birthdayCardButtonClicked.setVisibility(0);
                }
                com.qzone.adapter.feedcomponent.i.H().D1();
                return;
            }
            this.birthdayRootContainer.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @DittoOnClick("birthdayCardButton")
        public void birthdayCardButtonClick(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
            if (this.birthdayCardButton.getVisibility() == 0) {
                com.qzone.adapter.feedcomponent.i.H().F1(this.eventId, this.ruleId, this.isSelectShuoshuo, this.actionUrl, new IServiceCallback() { // from class: com.qzone.module.feedcomponent.ui.BirthdayCardFeedView.CanvasBirthdayView.1
                    @Override // com.qzone.adapter.feedcomponent.IServiceCallback
                    public void onResult(IResult iResult) {
                        if (iResult.getReturnCode() == 0) {
                            CanvasBirthdayView.this.birthdayCardButton.setVisibility(8);
                            CanvasBirthdayView.this.birthdayCardButtonClicked.setVisibility(0);
                            CanvasBirthdayView.this.postInvalidate();
                            CanvasBirthdayView.this.businessFeedData.getCellGuiding().isDressed = true;
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @DittoOnClick("birthdayCardSelect")
        public void birthdayCardCheckClick(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
            this.birthdayCardUnSelect.setVisibility(0);
            this.birthdayCardSelect.setVisibility(8);
            this.isSelectShuoshuo = false;
            postInvalidate();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @DittoOnClick("birthdayCardClose")
        public void birthdayCardCloseClick(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
            this.birthdayRootContainer.setVisibility(8);
            this.businessFeedData.setCellGuiding(null);
            postInvalidate();
            if (dittoArea.getTttReportArea() != -1) {
                reportTTTClick(dittoArea.getTttReportArea());
            }
            com.qzone.adapter.feedcomponent.i.H().E1();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @DittoOnClick("birthdayCardUnSelect")
        public void birthdayCardUnSelectClick(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
            this.birthdayCardUnSelect.setVisibility(8);
            this.birthdayCardSelect.setVisibility(0);
            this.isSelectShuoshuo = true;
            postInvalidate();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @DittoOnClick("moreLin")
        public void moreLinClick(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
            com.qzone.adapter.feedcomponent.i.H().G1(this.actionUrl);
        }

        public CanvasBirthdayView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.titleName = "";
            this.picData = "";
            this.decorationPicUrl = "";
            this.isSyncShuoshuo = "";
            this.eventId = "";
            this.ruleId = "";
            this.actionUrl = "";
            this.isSelectShuoshuo = false;
            this.defaultMoreUrl = "https://h5.qzone.qq.com/show/home?_wv=131072&_fv=0&_wwv=128&reddot=0_1616487453%2C32_0%2C33_0%2C34_0%2C35_0%2C36_0%2C38_0%2C7_0%2C39_0%2C17_0%2C18_0%2C19_0%2C21_0%2C23_0%2C24_0%2C27_0%2C29_0%2C30_0%2C31_0";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @DittoOnClick("birthdayRootContainer")
        public void birthdayRootContainerClick(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        }
    }

    public BirthdayCardFeedView(Context context) {
        super(context);
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
    public void setFeedPosition(int i3) {
        this.birthdayView.setFeedPosition(i3);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.birthdayView.setOnFeedElementClickListener(gVar);
    }

    public BirthdayCardFeedView(Context context, BusinessFeedData businessFeedData) {
        this(context);
        initView(context, businessFeedData);
    }

    private void initView(Context context, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        CanvasBirthdayView canvasBirthdayView = new CanvasBirthdayView(context);
        this.birthdayView = canvasBirthdayView;
        canvasBirthdayView.init(context, businessFeedData);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        setPadding(20, 26, 20, 0);
        addView(this.birthdayView, layoutParams);
        setBackgroundColor(-1);
        setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.BirthdayCardFeedView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
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
    public void setAlpha(int i3) {
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

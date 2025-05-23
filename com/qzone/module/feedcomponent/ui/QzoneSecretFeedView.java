package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.module.feedcomponent.manage.SecretTemplateItemData;
import com.qzone.module.feedcomponent.manage.SecretTemplateManager;
import com.qzone.module.feedcomponent.util.SecrectImageLoader;
import com.qzone.module.feedcomponent.view.CornerImageView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ClickedPoint;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.widget.AsyncImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneSecretFeedView extends AbsFeedView implements SecrectImageLoader.TemplateSetter {
    private static String APPID = "appid";
    private static String CELLID = "cellid";
    private static String FEEDFROM = "feedfrom";
    private static String OPEN_BY_COMMENT = "is_click_comment";
    private static String SUBID = "subid";
    private static final String TAG = "SecretFeedViewHolder";
    private static String UGCKEY = "ugckey";
    private static String defaultHeadUrl = "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_secret_feed_index_head01.png";
    private static String hotabelUrl = "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_secret_feed_hot.png";
    QzoneSecretCanvasFeedView canvasSecretView;
    Context context;
    BusinessFeedData data;
    View divider;
    ImageView dropMenu;
    CornerImageView feedBackground;
    View feedBody;
    TextView feedCommentNum;
    CellTextView feedContent;
    TextView feedFrom;
    AsyncImageView feedHead;
    ImageView feedMask;
    TextView feedPraiseNum;
    View grayLine;
    boolean hasZan;
    AsyncImageView hotLabel;
    protected int mFeedPosition;
    protected com.qzone.proxy.feedcomponent.ui.g mOnFeedElementClickListener;
    TextView moreSecret;
    private int pos;
    LinearLayout secretFeedLayout;
    View viewMore;

    public QzoneSecretFeedView(Context context) {
        super(context);
        this.feedBackground = null;
        this.feedMask = null;
        this.feedHead = null;
        this.feedFrom = null;
        this.feedContent = null;
        this.moreSecret = null;
        this.dropMenu = null;
        this.feedPraiseNum = null;
        this.feedCommentNum = null;
        this.data = null;
        this.hotLabel = null;
        this.hasZan = false;
        this.divider = null;
        this.grayLine = null;
        this.secretFeedLayout = null;
        this.viewMore = null;
        this.pos = 0;
        init(context);
        handleOnclick();
    }

    private void handleOnclick() {
        this.feedBody.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretFeedView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                QzoneSecretFeedView qzoneSecretFeedView = QzoneSecretFeedView.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = qzoneSecretFeedView.mOnFeedElementClickListener;
                if (gVar != null) {
                    gVar.onClick(qzoneSecretFeedView, FeedElement.QZOEN_SECRET_FEED_BODY_CLICK, qzoneSecretFeedView.mFeedPosition, qzoneSecretFeedView.data);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.moreSecret.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretFeedView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                QzoneSecretFeedView qzoneSecretFeedView = QzoneSecretFeedView.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = qzoneSecretFeedView.mOnFeedElementClickListener;
                if (gVar != null) {
                    gVar.onClick(qzoneSecretFeedView, FeedElement.QZOEN_SECRET_FEED_MORE_CLICK, qzoneSecretFeedView.mFeedPosition, qzoneSecretFeedView.data);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.dropMenu.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretFeedView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                QzoneSecretFeedView qzoneSecretFeedView = QzoneSecretFeedView.this;
                if (qzoneSecretFeedView.mOnFeedElementClickListener != null) {
                    boolean z16 = false;
                    if (qzoneSecretFeedView.data.getLocalInfoV2() != null && QzoneSecretFeedView.this.data.getLocalInfoV2().fakeType == 0) {
                        z16 = true;
                    }
                    if (!z16) {
                        view.getLocationOnScreen(new int[2]);
                        ClickedPoint clickedPoint = new ClickedPoint(0, 0, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                        QzoneSecretFeedView qzoneSecretFeedView2 = QzoneSecretFeedView.this;
                        qzoneSecretFeedView2.mOnFeedElementClickListener.onClick(qzoneSecretFeedView2, FeedElement.QZOEN_SECRET_FEED_DROP_MENU_CLICK, qzoneSecretFeedView2.mFeedPosition, clickedPoint);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.feedContent.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretFeedView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                QzoneSecretFeedView qzoneSecretFeedView = QzoneSecretFeedView.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = qzoneSecretFeedView.mOnFeedElementClickListener;
                if (gVar != null) {
                    gVar.onClick(qzoneSecretFeedView, FeedElement.QZOEN_SECRET_FEED_CONTENT_CLICK, qzoneSecretFeedView.mFeedPosition, qzoneSecretFeedView.data);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.viewMore.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretFeedView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                QzoneSecretFeedView qzoneSecretFeedView = QzoneSecretFeedView.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = qzoneSecretFeedView.mOnFeedElementClickListener;
                if (gVar != null) {
                    gVar.onClick(qzoneSecretFeedView, FeedElement.QZOEN_SECRET_FEED_MORE_CLICK, qzoneSecretFeedView.mFeedPosition, qzoneSecretFeedView.data);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1709), (ViewGroup) null);
        this.feedBody = inflate;
        addView(inflate);
        LinearLayout linearLayout = (LinearLayout) findViewById(com.qzone.adapter.feedcomponent.j.O(2746));
        this.secretFeedLayout = linearLayout;
        linearLayout.setBackgroundColor(com.qzone.adapter.feedcomponent.j.m());
        CornerImageView cornerImageView = (CornerImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2735));
        this.feedBackground = cornerImageView;
        cornerImageView.setRadius(new float[]{ViewUtils.dpToPx(4.0f), ViewUtils.dpToPx(4.0f), ViewUtils.dpToPx(4.0f), ViewUtils.dpToPx(4.0f), 0.0f, 0.0f, 0.0f, 0.0f});
        this.feedMask = (ImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2734));
        this.feedHead = (AsyncImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2736));
        this.feedFrom = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2737));
        this.feedContent = (CellTextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2738));
        this.moreSecret = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2739));
        this.dropMenu = (ImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2740));
        this.feedPraiseNum = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2741));
        this.feedCommentNum = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2742));
        this.hotLabel = (AsyncImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2743));
        this.divider = findViewById(com.qzone.adapter.feedcomponent.j.O(2744));
        View findViewById = findViewById(com.qzone.adapter.feedcomponent.j.O(2745));
        this.grayLine = findViewById;
        findViewById.setVisibility(8);
        this.viewMore = findViewById(com.qzone.adapter.feedcomponent.j.O(2842));
        this.canvasSecretView = (QzoneSecretCanvasFeedView) findViewById(com.qzone.adapter.feedcomponent.j.O(2841));
    }

    private boolean isUseBackGroundPicture(BusinessFeedData businessFeedData) {
        return (businessFeedData.getPictureInfo() == null || businessFeedData.getPictureInfo().pics == null || businessFeedData.getPictureInfo().pics.size() <= 0 || businessFeedData.getPictureInfo().pics.get(0) == null || businessFeedData.getPictureInfo().pics.get(0).getCurrentUrl() == null || TextUtils.isEmpty(businessFeedData.getPictureInfo().pics.get(0).getCurrentUrl().url)) ? false : true;
    }

    private void setBackground(BusinessFeedData businessFeedData) {
        if (businessFeedData.getPictureInfo() == null || businessFeedData.getPictureInfo().pics == null || businessFeedData.getPictureInfo().pics.size() <= 0 || businessFeedData.getPictureInfo().pics.get(0) == null || businessFeedData.getPictureInfo().pics.get(0).getCurrentUrl() == null || TextUtils.isEmpty(businessFeedData.getPictureInfo().pics.get(0).getCurrentUrl().url)) {
            return;
        }
        this.feedBackground.setAsyncImage(businessFeedData.getPictureInfo().pics.get(0).getCurrentUrl().url);
        this.feedBackground.setAsyncImageListener(new SecrectImageLoader(this));
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
        Drawable background;
        Drawable background2;
        LinearLayout linearLayout = this.secretFeedLayout;
        if (linearLayout != null && (background2 = linearLayout.getBackground()) != null) {
            background2.setAlpha(i3);
        }
        View view = this.divider;
        if (view == null || (background = view.getBackground()) == null) {
            return;
        }
        background.setAlpha(i3);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setData(BusinessFeedData businessFeedData) {
        String str;
        String str2;
        String str3;
        this.data = businessFeedData;
        this.feedBackground.setImageDrawable(null);
        this.dropMenu.setTag(businessFeedData);
        if (businessFeedData.getLikeInfoV2() != null) {
            this.hasZan = businessFeedData.getLikeInfoV2().isLiked;
        }
        if (businessFeedData.getTemplate() == null) {
            str = "1";
        } else {
            str = businessFeedData.getTemplate().templateId;
        }
        setTemplate(str, false);
        setBackground(businessFeedData);
        if (businessFeedData.getCellSummaryV2() == null) {
            str2 = "";
        } else {
            str2 = businessFeedData.getCellSummaryV2().summary;
        }
        this.feedContent.setRichText(str2);
        this.feedContent.setTextGravity(1);
        this.feedHead.setImageDrawable(null);
        if (businessFeedData.getUser() != null && businessFeedData.getUser().strPortraitId != null) {
            this.feedHead.setAsyncImage(businessFeedData.getUser().strPortraitId);
        } else {
            this.feedHead.setAsyncImage(defaultHeadUrl);
        }
        if (businessFeedData.getTitleInfoV2() == null) {
            str3 = "";
        } else {
            str3 = businessFeedData.getTitleInfoV2().relation_type;
        }
        TextView textView = this.feedFrom;
        if (TextUtils.isEmpty(str3)) {
            str3 = "\u670b\u53cb";
        }
        textView.setText(str3);
        if (businessFeedData.getHeader() != null && businessFeedData.getHeader().type == 2) {
            this.hotLabel.setAsyncImage(hotabelUrl);
            this.hotLabel.setVisibility(0);
        } else {
            this.hotLabel.setVisibility(8);
        }
        if (businessFeedData.getLikeInfoV2() != null && businessFeedData.getLikeInfoV2().likeNum != 0) {
            this.feedPraiseNum.setText(String.valueOf(businessFeedData.getLikeInfoV2().likeNum));
        } else {
            this.feedPraiseNum.setText("");
        }
        if (businessFeedData.getCommentInfoV2() != null && businessFeedData.getCommentInfoV2().commentNum != 0) {
            this.feedCommentNum.setText(String.valueOf(businessFeedData.getCommentInfoV2().commentNum));
        } else {
            this.feedCommentNum.setText("");
        }
        this.canvasSecretView.setFeedData(businessFeedData);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setFeedPosition(int i3) {
        this.mFeedPosition = i3;
        QzoneSecretCanvasFeedView qzoneSecretCanvasFeedView = this.canvasSecretView;
        if (qzoneSecretCanvasFeedView != null) {
            qzoneSecretCanvasFeedView.setFeedPosition(i3);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.mOnFeedElementClickListener = gVar;
        QzoneSecretCanvasFeedView qzoneSecretCanvasFeedView = this.canvasSecretView;
        if (qzoneSecretCanvasFeedView != null) {
            qzoneSecretCanvasFeedView.setOnFeedElementClickListener(gVar);
        }
    }

    @Override // com.qzone.module.feedcomponent.util.SecrectImageLoader.TemplateSetter
    public void setTemplate(String str, boolean z16) {
        SecretTemplateItemData secretTemplateById = SecretTemplateManager.getInstance().getSecretTemplateById(str);
        if (secretTemplateById != null) {
            if (!isUseBackGroundPicture(this.data)) {
                this.feedBackground.setImageDrawable(new ColorDrawable(secretTemplateById.backgroundColor));
            } else {
                this.feedBackground.setBackgroundColor(0);
            }
            this.feedBackground.setRadius(new float[]{ViewUtils.dpToPx(4.0f), ViewUtils.dpToPx(4.0f), ViewUtils.dpToPx(4.0f), ViewUtils.dpToPx(4.0f), 0.0f, 0.0f, 0.0f, 0.0f});
            this.feedFrom.setTextColor(-1);
            this.feedContent.setTextColor(-1);
            if (isUseBackGroundPicture(this.data)) {
                this.feedMask.setImageResource(com.qzone.adapter.feedcomponent.j.h(833));
                this.feedMask.setVisibility(0);
            } else {
                this.feedMask.setVisibility(8);
            }
        }
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
    public void setOnFeedFirstDrawListener(com.qzone.proxy.feedcomponent.ui.i iVar) {
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

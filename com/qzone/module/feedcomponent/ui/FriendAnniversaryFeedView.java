package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGuiding;
import com.qzone.proxy.feedcomponent.model.GuideButton;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.component.media.image.processor.AdvRoundCornerProcessor;
import com.tencent.component.media.image.processor.OvalProcessor;
import com.tencent.component.media.image.view.AsyncImageView;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FriendAnniversaryFeedView extends AbsFeedView {
    private static final String AVATAR_CROWN_URL = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-photo/feed/day/birth_banner_avatar_crow.png";
    private static int DESC_SEPERATE_LINE_WIDTH_LIMIT = FeedGlobalEnv.g().getScreenWidth() - com.qzone.proxy.feedcomponent.util.g.a(55.0f);
    CellGuiding cellGuiding;
    View feedBody;
    BusinessFeedData feedData;
    private boolean isFriendBrithdayMessageFeed;
    private boolean isMySelfBrithdayFeed;
    AsyncImageView mBackgroundPic;
    View mContentArea;
    TextView mDesc2;
    AsyncImageView mDropdownButton;
    protected int mFeedPosition;
    TextView mKnowDayDesc;
    AsyncImageView mLeftAvatar;
    RelativeLayout mLeftAvaterLayout;
    View mLeftOperationArea;
    RelativeLayout mLeftOperationLayout;
    AsyncImageView mMiddleAvatarCrown;
    AsyncImageView mMiddleAvater;
    RelativeLayout mMidleAvaterLayout;
    protected com.qzone.proxy.feedcomponent.ui.g mOnFeedElementClickListener;
    View mOperationSeperationLine;
    AsyncImageView mOpertaionIcon1;
    AsyncImageView mOpertaionIcon2;
    TextView mOpertaionText1;
    TextView mOpertaionText2;
    View mPicArea;
    AsyncImageView mRightAvatar;
    AsyncImageView mRightAvatar2;
    AsyncImageView mRightAvatar3;
    RelativeLayout mRightAvaterLayout;
    RelativeLayout mRightAvaterLayout1;
    RelativeLayout mRightAvaterLayout2;
    AsyncImageView mRightColorAvater;
    View mRightOperationArea;
    RelativeLayout mRightOperationLayout;
    TextView mRightTextCover;
    TextView mTitle;
    TextView mTitle1;
    TextView mTitle2;
    TextView mTitle3;
    int mTrans;
    private long middleUin;

    public FriendAnniversaryFeedView(Context context) {
        super(context);
        this.mTrans = 255;
        this.isFriendBrithdayMessageFeed = false;
        this.isMySelfBrithdayFeed = false;
        setOrientation(1);
        setBackgroundColor(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FriendAnniversaryFeedView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        View inflate = LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1682), (ViewGroup) null);
        this.feedBody = inflate;
        inflate.setBackgroundColor(com.qzone.adapter.feedcomponent.j.m());
        addView(this.feedBody);
        View findViewById = findViewById(com.qzone.adapter.feedcomponent.j.O(2484));
        this.mPicArea = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FriendAnniversaryFeedView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                FriendAnniversaryFeedView friendAnniversaryFeedView = FriendAnniversaryFeedView.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = friendAnniversaryFeedView.mOnFeedElementClickListener;
                if (gVar != null) {
                    gVar.onClick(friendAnniversaryFeedView, FeedElement.FEED_FRIEND_ANNIVERSARY_PIC_AREA_CLICKED, friendAnniversaryFeedView.mFeedPosition, friendAnniversaryFeedView.cellGuiding);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        View findViewById2 = findViewById(com.qzone.adapter.feedcomponent.j.O(2485));
        this.mLeftOperationArea = findViewById2;
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FriendAnniversaryFeedView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                FriendAnniversaryFeedView friendAnniversaryFeedView = FriendAnniversaryFeedView.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = friendAnniversaryFeedView.mOnFeedElementClickListener;
                if (gVar != null) {
                    gVar.onClick(friendAnniversaryFeedView, FeedElement.FEED_FRIEND_ANNIVERSARY_LEFT_BUTTON_CLICKED, friendAnniversaryFeedView.mFeedPosition, friendAnniversaryFeedView.cellGuiding);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        View findViewById3 = findViewById(com.qzone.adapter.feedcomponent.j.O(2486));
        this.mRightOperationArea = findViewById3;
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FriendAnniversaryFeedView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                FriendAnniversaryFeedView friendAnniversaryFeedView = FriendAnniversaryFeedView.this;
                friendAnniversaryFeedView.mOnFeedElementClickListener.onClick(friendAnniversaryFeedView, FeedElement.FEED_FRIEND_ANNIVERSARY_RIGHT_BUTTON_CLICKED, friendAnniversaryFeedView.mFeedPosition, friendAnniversaryFeedView.feedData);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        AsyncImageView asyncImageView = (AsyncImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2487));
        this.mDropdownButton = asyncImageView;
        asyncImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FriendAnniversaryFeedView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                FriendAnniversaryFeedView friendAnniversaryFeedView = FriendAnniversaryFeedView.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = friendAnniversaryFeedView.mOnFeedElementClickListener;
                if (gVar != null) {
                    AsyncImageView asyncImageView2 = friendAnniversaryFeedView.mDropdownButton;
                    FeedElement feedElement = FeedElement.FEEDBACK;
                    int i3 = friendAnniversaryFeedView.mFeedPosition;
                    gVar.onClick(asyncImageView2, feedElement, i3, Integer.valueOf(i3));
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.mTitle = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2488));
        this.mBackgroundPic = (AsyncImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2489));
        this.mLeftAvatar = (AsyncImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2490));
        this.mRightAvatar = (AsyncImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2491));
        this.mRightAvatar2 = (AsyncImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2500));
        this.mRightAvatar3 = (AsyncImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2501));
        this.mMiddleAvater = (AsyncImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2508));
        this.mMiddleAvatarCrown = (AsyncImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2779));
        this.mRightColorAvater = (AsyncImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2502));
        this.mRightTextCover = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2503));
        this.mLeftAvaterLayout = (RelativeLayout) findViewById(com.qzone.adapter.feedcomponent.j.O(2704));
        this.mRightAvaterLayout = (RelativeLayout) findViewById(com.qzone.adapter.feedcomponent.j.O(2705));
        this.mRightAvaterLayout1 = (RelativeLayout) findViewById(com.qzone.adapter.feedcomponent.j.O(2504));
        this.mRightAvaterLayout2 = (RelativeLayout) findViewById(com.qzone.adapter.feedcomponent.j.O(2505));
        this.mLeftOperationLayout = (RelativeLayout) findViewById(com.qzone.adapter.feedcomponent.j.O(2506));
        this.mRightOperationLayout = (RelativeLayout) findViewById(com.qzone.adapter.feedcomponent.j.O(2507));
        this.mMidleAvaterLayout = (RelativeLayout) findViewById(com.qzone.adapter.feedcomponent.j.O(2706));
        this.mTitle1 = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2599));
        this.mTitle2 = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2600));
        this.mTitle3 = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.QCIRCLE_SHOW_FULE_TIPS));
        this.mDesc2 = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2493));
        this.mOpertaionIcon1 = (AsyncImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2494));
        this.mOpertaionIcon2 = (AsyncImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2495));
        this.mOpertaionText1 = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2496));
        this.mOpertaionText2 = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2497));
        this.mKnowDayDesc = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2498));
        this.mContentArea = findViewById(com.qzone.adapter.feedcomponent.j.O(2499));
        this.mOperationSeperationLine = findViewById(com.qzone.adapter.feedcomponent.j.O(2780));
        this.mMiddleAvater.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FriendAnniversaryFeedView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                FriendAnniversaryFeedView friendAnniversaryFeedView = FriendAnniversaryFeedView.this;
                if (friendAnniversaryFeedView.mOnFeedElementClickListener != null && !friendAnniversaryFeedView.isFriendBrithdayMessageFeed) {
                    FriendAnniversaryFeedView friendAnniversaryFeedView2 = FriendAnniversaryFeedView.this;
                    friendAnniversaryFeedView2.mOnFeedElementClickListener.onClick(friendAnniversaryFeedView2.mDropdownButton, FeedElement.USER_AVATAR, friendAnniversaryFeedView2.mFeedPosition, Long.valueOf(friendAnniversaryFeedView2.middleUin));
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    private int measureStringWidth(TextView textView, String str) {
        Rect rect = new Rect();
        textView.getPaint().getTextBounds(str, 0, str.length(), rect);
        rect.height();
        return rect.width();
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
        View view = this.feedBody;
        if (view != null) {
            com.qzone.reborn.feedx.widget.i.a(view, i3);
        }
        View view2 = this.mContentArea;
        if (view2 != null) {
            com.qzone.reborn.feedx.widget.i.a(view2, this.mTrans);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setFeedPosition(int i3) {
        this.mFeedPosition = i3;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.mOnFeedElementClickListener = gVar;
    }

    private String getTitleSeperateString(TextView textView, String str, String str2, String str3) {
        if (textView != null && !TextUtils.isEmpty(str2)) {
            String str4 = str + str2 + str3;
            if (measureStringWidth(textView, str4) > DESC_SEPERATE_LINE_WIDTH_LIMIT * 2) {
                for (int length = str2.length() - 1; length >= 0; length--) {
                    String str5 = str + str2.substring(0, length) + MiniBoxNoticeInfo.APPNAME_SUFFIX + str3;
                    if (measureStringWidth(textView, str5) < DESC_SEPERATE_LINE_WIDTH_LIMIT * 2) {
                        return str5;
                    }
                }
            }
            return str4;
        }
        return str + str3;
    }

    private String handleEnglishLongNickName(TextView textView, String str) {
        for (int i3 = 0; i3 < str.length() - 1; i3++) {
            if (measureStringWidth(textView, str.substring(0, i3)) >= DESC_SEPERATE_LINE_WIDTH_LIMIT) {
                StringBuilder sb5 = new StringBuilder();
                int i16 = i3 - 2;
                sb5.append(str.substring(0, i16));
                sb5.append(" ");
                sb5.append(str.substring(i16, str.length() - 1));
                return sb5.toString();
            }
        }
        return str;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setData(BusinessFeedData businessFeedData) {
        int i3;
        GuideButton guideButton;
        String handleEnglishLongNickName;
        Map<String, String> map;
        ArrayList<User> arrayList;
        User user;
        User user2;
        User user3;
        PictureItem pictureItem;
        Map<String, String> map2;
        Map<String, String> map3;
        if (businessFeedData != null) {
            this.feedData = businessFeedData;
            CellGuiding cellGuiding = businessFeedData.getCellGuiding();
            this.cellGuiding = cellGuiding;
            if (cellGuiding != null) {
                if (cellGuiding.guiding_type == 5) {
                    this.isFriendBrithdayMessageFeed = true;
                } else {
                    this.isFriendBrithdayMessageFeed = false;
                }
                TextView textView = this.mTitle;
                if (textView != null && (map3 = cellGuiding.extendInfo) != null) {
                    textView.setText(map3.get("sub_title"));
                }
                if (this.isFriendBrithdayMessageFeed && (map2 = this.cellGuiding.extendInfo) != null) {
                    String str = map2.get("sub_guide_type");
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            this.isMySelfBrithdayFeed = Integer.valueOf(str).intValue() == 1;
                        } catch (Exception unused) {
                            this.isMySelfBrithdayFeed = false;
                        }
                    }
                }
                if (this.mBackgroundPic == null || (pictureItem = this.cellGuiding.pic) == null || pictureItem.currentUrl == null) {
                    i3 = 0;
                } else {
                    int screenWidth = FeedGlobalEnv.g().getScreenWidth() - com.qzone.proxy.feedcomponent.util.g.a(16.0f);
                    PictureUrl pictureUrl = this.cellGuiding.pic.currentUrl;
                    i3 = (int) (pictureUrl.height * (screenWidth / pictureUrl.width));
                    this.mBackgroundPic.setAsyncImageProcessor(new AdvRoundCornerProcessor(new float[]{10.0f, 10.0f, 10.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f}, screenWidth, i3));
                    this.mBackgroundPic.setAsyncImage(this.cellGuiding.pic.currentUrl.url);
                }
                if (this.isFriendBrithdayMessageFeed) {
                    if (this.isMySelfBrithdayFeed) {
                        this.middleUin = com.qzone.adapter.feedcomponent.i.H().j0();
                    } else {
                        ArrayList<User> arrayList2 = this.cellGuiding.vecUsers;
                        if (arrayList2 != null && arrayList2.size() > 0 && (user3 = this.cellGuiding.vecUsers.get(0)) != null) {
                            this.middleUin = user3.uin;
                        }
                    }
                    String str2 = this.middleUin > 0 ? "avatar://" + this.middleUin : null;
                    AsyncImageView asyncImageView = this.mMiddleAvater;
                    if (asyncImageView != null) {
                        asyncImageView.setAsyncImageProcessor(new OvalProcessor());
                        this.mMiddleAvater.setAsyncImage(str2);
                        this.mMiddleAvater.setVisibility(0);
                        this.mMidleAvaterLayout.setVisibility(0);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mMidleAvaterLayout.getLayoutParams();
                        marginLayoutParams.topMargin = i3 - com.qzone.proxy.feedcomponent.util.g.a(38.0f);
                        this.mMidleAvaterLayout.setLayoutParams(marginLayoutParams);
                        this.mLeftAvaterLayout.setVisibility(8);
                        this.mRightAvaterLayout.setVisibility(8);
                        this.mRightAvaterLayout1.setVisibility(8);
                        this.mRightAvaterLayout2.setVisibility(8);
                        AsyncImageView asyncImageView2 = this.mMiddleAvatarCrown;
                        if (asyncImageView2 != null) {
                            asyncImageView2.setAsyncImage(com.qzone.adapter.feedcomponent.j.D(AVATAR_CROWN_URL));
                            this.mMiddleAvatarCrown.setVisibility(0);
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mMiddleAvatarCrown.getLayoutParams();
                            marginLayoutParams2.topMargin = i3 - com.qzone.proxy.feedcomponent.util.g.a(58.0f);
                            this.mMiddleAvatarCrown.setLayoutParams(marginLayoutParams2);
                        }
                    }
                }
                String str3 = "";
                if (!this.isMySelfBrithdayFeed && (arrayList = this.cellGuiding.vecUsers) != null && arrayList.size() > 1) {
                    for (int i16 = 1; i16 < this.cellGuiding.vecUsers.size(); i16++) {
                        if (this.cellGuiding.vecUsers.get(i16) != null) {
                            String str4 = this.cellGuiding.vecUsers.get(i16).nickName;
                            if (i16 != 1) {
                                str3 = str3 + "\u3001" + str4;
                            } else {
                                str3 = str3 + str4;
                            }
                        }
                    }
                    User user4 = this.cellGuiding.vecUsers.get(0);
                    if (user4 != null) {
                        String str5 = user4.uin > 0 ? "avatar://" + user4.uin : null;
                        AsyncImageView asyncImageView3 = this.mLeftAvatar;
                        if (asyncImageView3 != null) {
                            asyncImageView3.setAsyncImageProcessor(new OvalProcessor());
                            this.mLeftAvatar.setAsyncImage(str5);
                        }
                    }
                    User user5 = this.cellGuiding.vecUsers.get(1);
                    if (user5 != null) {
                        String str6 = user5.uin > 0 ? "avatar://" + user5.uin : null;
                        AsyncImageView asyncImageView4 = this.mRightAvatar;
                        if (asyncImageView4 != null) {
                            asyncImageView4.setAsyncImageProcessor(new OvalProcessor());
                            this.mRightAvatar.setAsyncImage(str6);
                        }
                    }
                    if (this.cellGuiding.vecUsers.size() > 2 && (user2 = this.cellGuiding.vecUsers.get(2)) != null) {
                        this.mRightAvaterLayout1.setVisibility(0);
                        String str7 = user2.uin > 0 ? "avatar://" + user2.uin : null;
                        AsyncImageView asyncImageView5 = this.mRightAvatar2;
                        if (asyncImageView5 != null) {
                            asyncImageView5.setAsyncImageProcessor(new OvalProcessor());
                            this.mRightAvatar2.setAsyncImage(str7);
                        }
                    }
                    if (this.cellGuiding.vecUsers.size() > 3 && (user = this.cellGuiding.vecUsers.get(3)) != null) {
                        this.mRightAvaterLayout2.setVisibility(0);
                        String str8 = user.uin > 0 ? "avatar://" + user.uin : null;
                        AsyncImageView asyncImageView6 = this.mRightAvatar3;
                        if (asyncImageView6 != null) {
                            asyncImageView6.setAsyncImageProcessor(new OvalProcessor());
                            this.mRightAvatar3.setAsyncImage(str8);
                            this.mRightAvatar3.setVisibility(0);
                        }
                    }
                    if (this.cellGuiding.vecUsers.size() > 4) {
                        this.mRightTextCover.setText(String.valueOf(this.cellGuiding.vecUsers.size()));
                        this.mRightTextCover.setVisibility(0);
                        AsyncImageView asyncImageView7 = this.mRightColorAvater;
                        if (asyncImageView7 != null) {
                            asyncImageView7.setAsyncImageProcessor(new OvalProcessor());
                            this.mRightColorAvater.setImageDrawable(AreaManager.FEED_ANNIVERSARY_COLOR_COVER);
                            this.mRightColorAvater.setVisibility(0);
                        }
                    }
                }
                ArrayList<String> arrayList3 = new ArrayList<>();
                ArrayList<User> arrayList4 = this.cellGuiding.vecUsers;
                if (arrayList4 != null) {
                    Iterator<User> it = arrayList4.iterator();
                    while (it.hasNext()) {
                        User next = it.next();
                        if (next != null && !TextUtils.isEmpty(next.nickName)) {
                            arrayList3.add(next.nickName);
                        }
                    }
                }
                TextView textView2 = this.mKnowDayDesc;
                if (textView2 != null && (map = this.cellGuiding.extendInfo) != null) {
                    textView2.setText(map.get("know_day"));
                }
                Map<String, String> map4 = this.cellGuiding.extendInfo;
                if (map4 != null) {
                    String str9 = map4.get("title1");
                    String str10 = this.cellGuiding.extendInfo.get("title2");
                    String str11 = this.cellGuiding.extendInfo.get("title3");
                    String str12 = this.cellGuiding.extendInfo.get("title4");
                    if (this.isFriendBrithdayMessageFeed) {
                        if (this.isMySelfBrithdayFeed) {
                            handleEnglishLongNickName = handleNicknameTruncate(this.mTitle2, str9, arrayList3, str11, str12);
                        } else {
                            TextView textView3 = this.mTitle2;
                            handleEnglishLongNickName = handleEnglishLongNickName(textView3, getTitleSeperateString(textView3, str9, str10, str11));
                        }
                    } else {
                        TextView textView4 = this.mTitle2;
                        handleEnglishLongNickName = handleEnglishLongNickName(textView4, getTitleSeperateString(textView4, str9, str3, str11));
                    }
                    TextView textView5 = this.mTitle2;
                    if (textView5 != null) {
                        textView5.setText(handleEnglishLongNickName);
                    }
                }
                TextView textView6 = this.mDesc2;
                if (textView6 != null) {
                    textView6.setText(this.cellGuiding.summary);
                }
                ArrayList<GuideButton> arrayList5 = this.cellGuiding.vecButton;
                if (arrayList5 == null || arrayList5.size() <= 0) {
                    return;
                }
                GuideButton guideButton2 = this.cellGuiding.vecButton.get(0);
                if (guideButton2 != null) {
                    this.mLeftOperationLayout.setVisibility(0);
                    AsyncImageView asyncImageView8 = this.mOpertaionIcon1;
                    if (asyncImageView8 != null) {
                        asyncImageView8.setAsyncImage(guideButton2.picUrl);
                    }
                    TextView textView7 = this.mOpertaionText1;
                    if (textView7 != null) {
                        textView7.setText(guideButton2.buttonTitle);
                    }
                }
                if (this.cellGuiding.vecButton.size() <= 1 || (guideButton = this.cellGuiding.vecButton.get(1)) == null) {
                    return;
                }
                this.mRightOperationLayout.setVisibility(0);
                AsyncImageView asyncImageView9 = this.mOpertaionIcon2;
                if (asyncImageView9 != null) {
                    asyncImageView9.setAsyncImage(guideButton.picUrl);
                }
                TextView textView8 = this.mOpertaionText2;
                if (textView8 != null) {
                    textView8.setText(guideButton.buttonTitle);
                }
            }
        }
    }

    private String handleNicknameTruncate(TextView textView, String str, ArrayList<String> arrayList, String str2, String str3) {
        if (textView != null && arrayList != null && arrayList.size() != 0) {
            if (str == null) {
                str = "";
            }
            if (arrayList.size() > 1 && str3 != null) {
                StringBuilder sb5 = new StringBuilder();
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    if (i3 > 0) {
                        sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                    }
                    sb5.append(arrayList);
                }
                String str4 = str + ((Object) sb5) + str3;
                if (measureStringWidth(textView, str4) <= DESC_SEPERATE_LINE_WIDTH_LIMIT * 2) {
                    return str4;
                }
            }
            int i16 = 0;
            int i17 = 0;
            while (i16 < arrayList.size()) {
                String str5 = (i16 > 0 ? str + "\u3001" : str) + arrayList.get(i16);
                int measureStringWidth = measureStringWidth(textView, str5 + str2);
                if (measureStringWidth > DESC_SEPERATE_LINE_WIDTH_LIMIT * 2) {
                    break;
                }
                i16++;
                str = str5;
                i17 = measureStringWidth;
            }
            if (i16 < arrayList.size() && i17 < DESC_SEPERATE_LINE_WIDTH_LIMIT * 2) {
                if (measureStringWidth(textView, (str + "\u3001" + MiniBoxNoticeInfo.APPNAME_SUFFIX) + str2) >= DESC_SEPERATE_LINE_WIDTH_LIMIT * 2) {
                    return str + str2;
                }
                String str6 = arrayList.get(i16);
                for (int length = str6.length() - 1; length >= 1; length--) {
                    String str7 = (i16 > 0 ? str + "\u3001" : str) + str6.substring(0, length) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                    if (measureStringWidth(textView, str7 + str2) <= DESC_SEPERATE_LINE_WIDTH_LIMIT * 2) {
                        return str7 + str2;
                    }
                }
            }
            return str + str2;
        }
        return str + str2;
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

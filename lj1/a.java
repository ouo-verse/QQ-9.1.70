package lj1;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.guild.feed.FeedImpeachData;
import com.tencent.mobileqq.guild.feed.detail.FeedInteractiveData;
import com.tencent.mobileqq.guild.feed.detail.GuildFeedDetailWebViewFragment;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishEditPostInitBean;
import com.tencent.mobileqq.guild.feed.usecases.GuildFeedArkShareInfo;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import nj1.FeedWebDetailParams;
import pk1.b;

/* compiled from: P */
/* loaded from: classes13.dex */
public interface a extends b<GuildFeedDetailInitBean> {
    void deleteLocalCache();

    void finish();

    GuildFeedBaseInitBean getDetailInitBean();

    FeedInteractiveData getFeedInteractiveData();

    Bitmap getScreenBitmap();

    boolean isNativeEmojiClick();

    void jumpNativePublish(String str, String str2, String str3, String str4, int i3, String str5, int i16, GuildFeedReportSourceInfo guildFeedReportSourceInfo);

    void jumpPublish(GuildFeedPublishEditPostInitBean guildFeedPublishEditPostInitBean);

    void jumpUserSummary(String str, String str2, String str3, int i3, String str4, String str5, FeedImpeachData feedImpeachData);

    void noteUserWriteOrStay(String str, String str2, String str3);

    void recoverComment4Web(GuildFeedDetailWebViewFragment.f fVar);

    void setDefaultPlaceholder(String str);

    void setFeedCacheCallback(GuildFeedDetailWebViewFragment.g gVar);

    void setNativeEmojiClick(boolean z16);

    void setSendCommentCallBack(GuildFeedDetailWebViewFragment.g gVar);

    void setSendOtherFeedCommentCallBack(GuildFeedDetailWebViewFragment.g gVar);

    void showEmoji(boolean z16);

    void showGuildHashtag();

    void showInputPop(nj1.a aVar);

    void showInputPopForRecommendFeed(bj1.a aVar, String str, int i3);

    void showMoveHashtagEmptyToastMsg();

    void showShare(Context context, GuildFeedArkShareInfo guildFeedArkShareInfo);

    void supportAt(boolean z16);

    void supportPic(boolean z16);

    void updateBottomBarVisible(boolean z16);

    void updateGuildFeedInfo(String str, String str2, String str3);

    void updateWebParams(FeedWebDetailParams feedWebDetailParams);
}

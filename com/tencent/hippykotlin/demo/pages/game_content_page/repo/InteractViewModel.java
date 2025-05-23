package com.tencent.hippykotlin.demo.pages.game_content_page.repo;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.Comment;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GameFeed;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.Like;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.Share;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class InteractViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(InteractViewModel.class, "likeCountTxt", "getLikeCountTxt()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(InteractViewModel.class, "likeStatus", "getLikeStatus()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(InteractViewModel.class, "commentCountTxt", "getCommentCountTxt()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(InteractViewModel.class, "shareCountTxt", "getShareCountTxt()Ljava/lang/String;", 0)};
    public final ReadWriteProperty likeCountTxt$delegate = c.a("\u8d5e");
    public final ReadWriteProperty likeStatus$delegate = c.a(0);
    public final ReadWriteProperty commentCountTxt$delegate = c.a("\u8bc4\u8bba");
    public final ReadWriteProperty shareCountTxt$delegate = c.a("\u5206\u4eab");

    public InteractViewModel(GameFeed gameFeed) {
        boolean z16 = false;
        Utils utils = Utils.INSTANCE;
        Like like = gameFeed.like;
        setLikeCountTxt(utils.formatCountNumber(like != null ? like.getCount() : 0));
        Like like2 = gameFeed.like;
        if (like2 != null && like2.getCount() == 0) {
            setLikeCountTxt("\u8d5e");
        }
        Like like3 = gameFeed.like;
        setLikeStatus(like3 != null ? like3.getStatus() : 0);
        Comment comment = gameFeed.comment;
        setCommentCountTxt(utils.formatCountNumber(comment != null ? comment.getCount() : 0));
        Comment comment2 = gameFeed.comment;
        if (comment2 != null && comment2.getCount() == 0) {
            setCommentCountTxt("\u8bc4\u8bba");
        }
        Share share = gameFeed.share;
        setShareCountTxt(utils.formatCountNumber(share != null ? share.getCount() : 0));
        Share share2 = gameFeed.share;
        if (share2 != null && share2.getCount() == 0) {
            z16 = true;
        }
        if (z16) {
            setShareCountTxt("\u5206\u4eab");
        }
    }

    public final void setCommentCountTxt(String str) {
        this.commentCountTxt$delegate.setValue(this, $$delegatedProperties[2], str);
    }

    public final void setLikeCountTxt(String str) {
        this.likeCountTxt$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public final void setLikeStatus(int i3) {
        this.likeStatus$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(i3));
    }

    public final void setShareCountTxt(String str) {
        this.shareCountTxt$delegate.setValue(this, $$delegatedProperties[3], str);
    }
}

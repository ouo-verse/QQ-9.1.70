package com.tencent.biz.pubaccount.weishi.profile.header;

import android.graphics.drawable.Drawable;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0002H&J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0002H&J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH&J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001bH&J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001bH&\u00a8\u0006\""}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/profile/header/g;", "", "", PhotoCategorySummaryInfo.AVATAR_URL, "", "b", "nick", "setNick", "", "rightSmallBtnRes", "setRightSmallBtnImage", "text", "", "textSize", "Landroid/graphics/drawable/Drawable;", "bgDrawable", "setRightBigBtnImage", "Lcom/tencent/biz/pubaccount/weishi/profile/header/i;", "sexInfo", "setSex", "location", "locationDrawable", "setLocation", "coverUrl", "a", "signature", "setSignature", "", "followCntText", "setFollowCnt", "fansCntText", "setFansCnt", "receivePraiseCnt", "setReceivePraiseCnt", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public interface g {
    void a(String coverUrl);

    void b(String avatarUrl);

    void setFansCnt(CharSequence fansCntText);

    void setFollowCnt(CharSequence followCntText);

    void setLocation(String location, Drawable locationDrawable);

    void setNick(String nick);

    void setReceivePraiseCnt(CharSequence receivePraiseCnt);

    void setRightBigBtnImage(String text, float textSize, Drawable bgDrawable);

    void setRightSmallBtnImage(int rightSmallBtnRes);

    void setSex(i sexInfo);

    void setSignature(String signature);
}

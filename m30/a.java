package m30;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.beans.QFSFollowRecommendParseInfo;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.utils.l;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudMeta$StFollowRecomInfo;
import feedcloud.FeedCloudMeta$StFollowUser;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {
    public static void a(View view) {
        if (view == null) {
            return;
        }
        view.setPadding(view.getPaddingLeft(), RFWImmersiveUtils.getStatusBarHeight() * (-1), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static boolean b() {
        return l.d("exp_xsj_newfriends_pymk_1505");
    }

    public static QFSFollowRecommendParseInfo c(FeedCloudMeta$StFollowRecomInfo feedCloudMeta$StFollowRecomInfo) {
        QFSFollowRecommendParseInfo qFSFollowRecommendParseInfo = new QFSFollowRecommendParseInfo();
        if (feedCloudMeta$StFollowRecomInfo == null) {
            return qFSFollowRecommendParseInfo;
        }
        int size = feedCloudMeta$StFollowRecomInfo.followUsers.size();
        String str = feedCloudMeta$StFollowRecomInfo.followText.get();
        String str2 = feedCloudMeta$StFollowRecomInfo.commFriendText.get();
        String str3 = feedCloudMeta$StFollowRecomInfo.commGroupText.get();
        if (size == 1 && !TextUtils.isEmpty(str) && feedCloudMeta$StFollowRecomInfo.followUsers.get(0) != null) {
            ArrayList arrayList = new ArrayList();
            FeedCloudMeta$StFollowUser feedCloudMeta$StFollowUser = feedCloudMeta$StFollowRecomInfo.followUsers.get(0);
            if (!TextUtils.isEmpty(feedCloudMeta$StFollowUser.head_url.get())) {
                arrayList.add(feedCloudMeta$StFollowUser.head_url.get());
            } else {
                arrayList.add(feedCloudMeta$StFollowUser.uid.get() + "");
            }
            qFSFollowRecommendParseInfo.setAvatarUrls(arrayList);
            qFSFollowRecommendParseInfo.setRecommendStr(feedCloudMeta$StFollowUser.nick.get() + str);
            return qFSFollowRecommendParseInfo;
        }
        if (size > 1 && !TextUtils.isEmpty(str)) {
            int min = Math.min(size, 3);
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < min; i3++) {
                FeedCloudMeta$StFollowUser feedCloudMeta$StFollowUser2 = feedCloudMeta$StFollowRecomInfo.followUsers.get(i3);
                if (feedCloudMeta$StFollowUser2 != null) {
                    if (!TextUtils.isEmpty(feedCloudMeta$StFollowUser2.head_url.get())) {
                        arrayList2.add(feedCloudMeta$StFollowUser2.head_url.get());
                    } else {
                        arrayList2.add(feedCloudMeta$StFollowUser2.uid.get() + "");
                    }
                }
            }
            qFSFollowRecommendParseInfo.setAvatarUrls(arrayList2);
            qFSFollowRecommendParseInfo.setRecommendStr(str);
            return qFSFollowRecommendParseInfo;
        }
        if (!TextUtils.isEmpty(str2)) {
            qFSFollowRecommendParseInfo.setRecommendStr(str2);
            return qFSFollowRecommendParseInfo;
        }
        if (!TextUtils.isEmpty(str3)) {
            qFSFollowRecommendParseInfo.setRecommendStr(str3);
        }
        return qFSFollowRecommendParseInfo;
    }

    public static void d(View view) {
        if (view == null) {
            return;
        }
        int c16 = QFSQUIUtilsKt.c(view.getContext(), R.color.qui_common_text_secondary, 0.1f);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{c16, c16});
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(cx.a(34.0f));
        view.setBackground(gradientDrawable);
    }
}

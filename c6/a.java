package c6;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.qzone.common.activities.FeedActionPanelActivity;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.util.ToastUtil;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {
    public static String d(View view) {
        AbsFeedView absFeedView;
        String str = "";
        if (view != null) {
            if (view instanceof AbsFeedView) {
                absFeedView = (AbsFeedView) view;
            } else {
                ViewParent parent = view.getParent();
                while (true) {
                    if (parent == null) {
                        absFeedView = null;
                        break;
                    }
                    if (parent instanceof AbsFeedView) {
                        absFeedView = (AbsFeedView) parent;
                        break;
                    }
                    parent = parent.getParent();
                }
            }
            if (absFeedView != null) {
                int i3 = absFeedView.mLastTouchDownX;
                int density = absFeedView.mLastTouchDownY - ((int) (FeedGlobalEnv.g().getDensity() * 35.0f));
                int i16 = absFeedView.mLastTouchUpX;
                int density2 = absFeedView.mLastTouchUpY - ((int) (FeedGlobalEnv.g().getDensity() * 35.0f));
                long currentTimeMillis = System.currentTimeMillis() - absFeedView.mLastTouchDownTime;
                long currentTimeMillis2 = System.currentTimeMillis() - absFeedView.mLastTouchUpTime;
                int height = absFeedView.getHeight() - ((int) (FeedGlobalEnv.g().getDensity() * 35.0f));
                int width = absFeedView.getWidth();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ec", "" + currentTimeMillis);
                    jSONObject.put("sc", "" + currentTimeMillis2);
                    jSONObject.put("aa", "" + i3);
                    jSONObject.put("ab", "" + density);
                    jSONObject.put("ba", "" + i16);
                    jSONObject.put("bb", "" + density2);
                    jSONObject.put("da", "" + width);
                    jSONObject.put(TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "" + height);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                str = jSONObject.toString();
            }
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e17) {
            e17.printStackTrace();
            return str;
        }
    }

    public static int e(BusinessFeedData businessFeedData) {
        int i3;
        Comment comment;
        int i16 = FeedActionPanelActivity.I1;
        if (businessFeedData == null) {
            return i16;
        }
        if (4 != businessFeedData.getFeedCommInfo().appid) {
        }
        if (businessFeedData.isHideSecretComment()) {
            i3 = FeedActionPanelActivity.I1;
        } else {
            i3 = FeedActionPanelActivity.J1;
        }
        CellCommentInfo commentInfo = businessFeedData.getOriginalInfoSafe().getCommentInfo();
        if (commentInfo == null || (comment = commentInfo.mainComment) == null || comment.isFake) {
            return i3;
        }
        User user = comment.user;
        long j3 = user != null ? user.uin : 0L;
        if (comment.isPrivate) {
            return FeedActionPanelActivity.K1;
        }
        return j3 != 0 ? FeedActionPanelActivity.I1 : i3;
    }

    public static void h(int i3) {
        ToastUtil.n(i3);
    }

    public static void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ToastUtil.r(str);
    }

    public static void j(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ToastUtil.s(str, i3);
    }

    public static String a(CellLeftThumb cellLeftThumb) {
        PictureItem pictureItem;
        PictureUrl pictureUrl;
        if (cellLeftThumb != null && (pictureItem = cellLeftThumb.getPictureItem()) != null && (pictureUrl = pictureItem.bigUrl) != null) {
            return pictureUrl.url;
        }
        return "";
    }

    public static AbsFeedView b(View view) {
        if (view != null) {
            if (view instanceof AbsFeedView) {
                return (AbsFeedView) view;
            }
            for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof AbsFeedView) {
                    return (AbsFeedView) parent;
                }
            }
        }
        return null;
    }

    public static int c(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return 5;
        }
        if (businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().isLikeRecommFamousFeed()) {
            return 4;
        }
        if (businessFeedData.isSubFeed) {
            return 6;
        }
        return (businessFeedData.getFeedCommInfo() == null || !businessFeedData.getFeedCommInfo().needAdvReport()) ? 5 : 7;
    }

    public static BusinessFeedData f(BusinessFeedData businessFeedData, FeedElement feedElement) {
        BusinessFeedData businessFeedData2;
        BusinessFeedData businessFeedData3;
        if (businessFeedData != null && feedElement != FeedElement.FEEDBACK && feedElement != FeedElement.PRAISE_BUTTON && feedElement != FeedElement.COMMENT_BUTTON && feedElement != FeedElement.FORWARD_BUTTON && feedElement != FeedElement.DROPDOWN_BUTTON && feedElement != FeedElement.FEED_NEGATIVE_FEEDBACK_SUBMIT_BUTTON_CLICK && feedElement != FeedElement.FEED_NEGATIVE_FEEDBACK_DEL_BUTTON_CLICK) {
            if (businessFeedData.isSingleAdvContainerFeed()) {
                ArrayList<BusinessFeedData> recBusinessFeedDatas = businessFeedData.getRecBusinessFeedDatas();
                if (businessFeedData.currShowIndex >= 0 && recBusinessFeedDatas != null) {
                    int size = recBusinessFeedDatas.size();
                    int i3 = businessFeedData.currShowIndex;
                    if (size > i3 && (businessFeedData3 = recBusinessFeedDatas.get(i3)) != null && businessFeedData3.getRecommAction() != null) {
                        return businessFeedData3;
                    }
                }
            } else if (businessFeedData.isMultiAdvContainerFeed() && businessFeedData.getFeedCommInfo().isBizRecomFamousFeeds()) {
                ArrayList<BusinessFeedData> recBusinessFeedDatas2 = businessFeedData.getRecBusinessFeedDatas();
                if (businessFeedData.currShowIndex >= 0 && recBusinessFeedDatas2 != null) {
                    int size2 = recBusinessFeedDatas2.size();
                    int i16 = businessFeedData.currShowIndex;
                    if (size2 > i16 && (businessFeedData2 = recBusinessFeedDatas2.get(i16)) != null) {
                        return businessFeedData2;
                    }
                }
            }
        }
        return businessFeedData;
    }

    public static String g(Object obj, String str) {
        if (obj == null) {
            return str;
        }
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }
}

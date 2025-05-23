package g10;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi.t;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    public static void a(WSAddCommentEvent wSAddCommentEvent, List<stSimpleMetaFeed> list) {
        x.b("WSGridEventUtils", "WSAddCommentEvent feedId = " + wSAddCommentEvent.getFeedId() + "; position = " + wSAddCommentEvent.getPosition() + "; num = " + wSAddCommentEvent.getCommentNum());
        for (stSimpleMetaFeed stsimplemetafeed : list) {
            if (TextUtils.equals(stsimplemetafeed.f25129id, wSAddCommentEvent.getFeedId())) {
                stsimplemetafeed.total_comment_num = (int) wSAddCommentEvent.getCommentNum();
                return;
            }
        }
    }

    public static void b(FollowEvent followEvent, List<stSimpleMetaFeed> list) {
        for (stSimpleMetaFeed stsimplemetafeed : list) {
            stSimpleMetaPerson stsimplemetaperson = stsimplemetafeed.poster;
            if (stsimplemetaperson != null && TextUtils.equals(stsimplemetaperson.f25130id, followEvent.getPersonId())) {
                stsimplemetafeed.poster.followStatus = followEvent.getIsFollow();
            }
        }
    }

    public static void c(LikeRspEvent likeRspEvent, t tVar, List<stSimpleMetaFeed> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            stSimpleMetaFeed stsimplemetafeed = list.get(i3);
            if (TextUtils.equals(stsimplemetafeed.f25129id, likeRspEvent.getFeedId())) {
                int rspIsDing = likeRspEvent.getRspIsDing();
                int i16 = stsimplemetafeed.is_ding;
                if (rspIsDing != i16) {
                    if (i16 == 1) {
                        stsimplemetafeed.ding_count--;
                    } else {
                        stsimplemetafeed.ding_count++;
                    }
                }
                stsimplemetafeed.is_ding = likeRspEvent.getRspIsDing();
                tVar.notifyItemChanged(i3);
                return;
            }
        }
    }
}

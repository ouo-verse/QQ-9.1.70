package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class o {
    public static List<String> a(List<QFSCommentAtEntity> list, int i3) {
        ArrayList arrayList = new ArrayList();
        if (RFSafeListUtils.getSize(list) == 0) {
            return arrayList;
        }
        for (QFSCommentAtEntity qFSCommentAtEntity : list) {
            if (!TextUtils.isEmpty(qFSCommentAtEntity.g())) {
                arrayList.add(qFSCommentAtEntity.g());
            } else {
                arrayList.add(qFSCommentAtEntity.uin);
            }
            if (arrayList.size() >= i3) {
                break;
            }
        }
        return arrayList;
    }

    public static String b(@NonNull List<FeedCloudMeta$StUser> list, int i3) {
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < list.size(); i16++) {
            if (i16 < i3 - 1 && i16 != list.size() - 1) {
                sb5.append(list.get(i16).nick.get());
                sb5.append("\u3001");
            } else {
                sb5.append(list.get(i16).nick.get());
                return sb5.toString();
            }
        }
        return sb5.toString();
    }

    public static List<String> c(List<FeedCloudMeta$StUser> list, int i3) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (FeedCloudMeta$StUser feedCloudMeta$StUser : list) {
            if (!TextUtils.isEmpty(feedCloudMeta$StUser.icon.iconUrl.get())) {
                arrayList.add(feedCloudMeta$StUser.icon.iconUrl.get());
            } else {
                arrayList.add(feedCloudMeta$StUser.f398463id.get());
            }
            if (arrayList.size() >= i3) {
                break;
            }
        }
        return arrayList;
    }
}

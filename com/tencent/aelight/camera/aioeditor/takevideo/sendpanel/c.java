package com.tencent.aelight.camera.aioeditor.takevideo.sendpanel;

import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c implements Comparator<RecentUser> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(RecentUser recentUser, RecentUser recentUser2) {
        long max = Math.max(recentUser.lastmsgtime, recentUser.lastmsgdrafttime);
        long max2 = Math.max(recentUser2.lastmsgtime, recentUser2.lastmsgdrafttime);
        if (recentUser.lastmsgtime <= 0 && recentUser.lastmsgdrafttime <= 0) {
            max = Math.max(max, recentUser.opTime);
        }
        if (recentUser2.lastmsgtime <= 0 && recentUser2.lastmsgdrafttime <= 0) {
            max2 = Math.max(max2, recentUser2.opTime);
        }
        if (max > max2) {
            return -1;
        }
        return max < max2 ? 1 : 0;
    }
}

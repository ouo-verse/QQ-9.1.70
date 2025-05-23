package com.tencent.mobileqq.troop.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface IDiscussionHandlerService extends IRuntimeService {
    void addDiscussMember(long j3, Object obj);

    void checkPstnIconInfoAndUpdate(String str);

    void collectDiscussion(long j3);

    void createDiscuss(String str, Object obj, int i3);

    void createDiscuss(String str, Object obj, int i3, long j3);

    void getAtAllRemainCountInfo(String str, String str2);

    Bitmap getDiscussionFaceIcon(String str, boolean z16);

    void kickOutMemberFromDiscussion(long j3, long j16);

    void unCollectDiscussion(long j3);

    void updateDiscussionIcon(String str, boolean z16);
}

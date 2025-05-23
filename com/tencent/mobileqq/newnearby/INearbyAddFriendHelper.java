package com.tencent.mobileqq.newnearby;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyAddFriendHelper extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
        void a(List<Boolean> list);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface c {
        void a(boolean z16);
    }

    void addFriend(long j3);

    void addFriendFromYQ(long j3, int i3, int i16, int i17);

    void canAddFriend(long j3, a aVar);

    void isFriend(long j3, c cVar);

    void isFriend(List<Long> list, b bVar);

    boolean isFromNearby(int i3, int i16, byte[] bArr);
}

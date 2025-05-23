package com.tencent.biz.pubaccount.api;

import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.ArrayList;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountObserver extends QRouteApi {
    public static final int TYPE_ACCOUNT_DETAIL_DYNAMIC_LIST = 107;
    public static final int TYPE_ACCOUNT_DETAIL_FUNCTION_FLAG = 109;
    public static final int TYPE_DOWN_PUBLIC_ACCOUNT = 103;
    public static final int TYPE_FOLLOW_PUBLIC_ACCOUNT = 101;
    public static final int TYPE_GET_GUIDE_FRIENDS = 110;
    public static final int TYPE_GET_HISTORY_MESSAGE = 105;
    public static final int TYPE_GET_PUBLIC_NOTIFICATION = 106;
    public static final int TYPE_GET_RECOMMEND_LIST = 104;
    public static final int TYPE_GET_SUBSCRIBE_STATUS = 111;
    public static final int TYPE_GET_USER_FOLLOW_LIST = 100;
    public static final int TYPE_SET_KANDIAN_SUBSCRIBE = 108;
    public static final int TYPE_SET_RECVMSG_STATUS = 112;
    public static final int TYPE_UNFOLLOW_PUBLIC_ACCOUNT = 102;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Object f79351a;

        /* renamed from: b, reason: collision with root package name */
        public int f79352b;
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f79353a;

        /* renamed from: b, reason: collision with root package name */
        public long f79354b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f79355c;

        /* renamed from: d, reason: collision with root package name */
        public Object f79356d;
    }

    /* loaded from: classes4.dex */
    public static abstract class c {
        public void onFollowPublicAccount(int i3, Object obj) {
        }

        public void onUnfollowPublicAccount(int i3, Object obj) {
        }

        public void onFollowPublicAccount(boolean z16, int i3) {
        }

        public void onUnfollowPublicAccount(boolean z16, String str) {
        }

        public void onFollowPublicAccount(boolean z16, String str) {
        }

        public void onDestroy() {
        }

        public void onDownPublicAccount() {
        }

        public void onGetHistoryMsgRet(int i3) {
        }

        public void onUpdateRecommendList(boolean z16) {
        }

        public void onDynamicListGet(boolean z16, int i3) {
        }

        public void onGetGuideFriends(boolean z16, ArrayList<Long> arrayList) {
        }

        public void onPublicAccountNotification(boolean z16, boolean z17) {
        }

        public void onSetRecvMsgState(boolean z16, Object obj) {
        }

        public void onUpdateFunctionFlag(boolean z16, IPublicAccountConfigAttr.a aVar) {
        }

        public void onUpdateUserFollowList(int i3, boolean z16) {
        }

        public void onGetPublicAccountSubscribeStatus(boolean z16, long j3, int i3) {
        }

        public void onSetPublicAccountSubscribeStatus(boolean z16, int i3, long j3) {
        }
    }

    BusinessObserver getBusinessObserver();

    void onDynamicListGet(boolean z16, int i3);

    void onFollowPublicAccount(boolean z16, String str);

    void onUnfollowPublicAccount(boolean z16, String str);

    void onUpdate(int i3, boolean z16, Object obj);

    void setOnCallback(c cVar);
}

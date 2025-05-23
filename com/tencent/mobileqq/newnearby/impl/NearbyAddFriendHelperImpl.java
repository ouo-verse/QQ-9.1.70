package com.tencent.mobileqq.newnearby.impl;

import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.newnearby.INearbyAddFriendHelper;
import com.tencent.mobileqq.newnearby.servlet.ServletObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.protocol.NearbyRelation$SsoIsFriendReq;
import com.tencent.mobileqq.protocol.NearbyRelation$SsoIsFriendRsp;
import com.tencent.mobileqq.protocol.NearbyRelation$SsoIsShowNearbyAddFriendButtonReq;
import com.tencent.mobileqq.protocol.NearbyRelation$SsoIsShowNearbyAddFriendButtonRsp;
import com.tencent.mobileqq.protocol.trpcNearbyAccount$SsoGetOpenIDByTinyIDReq;
import com.tencent.mobileqq.protocol.trpcNearbyAccount$SsoGetOpenIDByTinyIDRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyAddFriendHelperImpl implements INearbyAddFriendHelper {
    private static final String TAG = "NearbyAddFriendHelperImpl";

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends ServletObserver {
        a(INearbyAddFriendHelper.a aVar) {
        }

        @Override // com.tencent.mobileqq.newnearby.servlet.ServletObserver
        public void c(int i3, byte[] bArr, Bundle bundle) {
            if (i3 == 0) {
                NearbyRelation$SsoIsShowNearbyAddFriendButtonRsp nearbyRelation$SsoIsShowNearbyAddFriendButtonRsp = new NearbyRelation$SsoIsShowNearbyAddFriendButtonRsp();
                try {
                    nearbyRelation$SsoIsShowNearbyAddFriendButtonRsp.mergeFrom(bArr);
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e(NearbyAddFriendHelperImpl.TAG, 1, "canAddFriend error: " + e16);
                }
                int i16 = nearbyRelation$SsoIsShowNearbyAddFriendButtonRsp.ret_code.get();
                if (i16 != 0) {
                    QLog.e(NearbyAddFriendHelperImpl.TAG, 2, "canAddFriend error:" + i16 + "-" + nearbyRelation$SsoIsShowNearbyAddFriendButtonRsp.ret_msg.get());
                    throw null;
                }
                nearbyRelation$SsoIsShowNearbyAddFriendButtonRsp.is_show.get();
                throw null;
            }
            QLog.e(NearbyAddFriendHelperImpl.TAG, 2, "canAddFriend error:" + i3);
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b extends ServletObserver {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ INearbyAddFriendHelper.b f254208f;

        b(INearbyAddFriendHelper.b bVar) {
            this.f254208f = bVar;
        }

        @Override // com.tencent.mobileqq.newnearby.servlet.ServletObserver
        public void c(int i3, byte[] bArr, Bundle bundle) {
            if (i3 != 0) {
                QLog.e(NearbyAddFriendHelperImpl.TAG, 2, "nearby judge isFriend fail");
                this.f254208f.a(Collections.singletonList(Boolean.TRUE));
                return;
            }
            NearbyRelation$SsoIsFriendRsp nearbyRelation$SsoIsFriendRsp = new NearbyRelation$SsoIsFriendRsp();
            try {
                nearbyRelation$SsoIsFriendRsp.mergeFrom(bArr);
                if (nearbyRelation$SsoIsFriendRsp.ret_code.get() != 0) {
                    QQToast.makeText(QBaseActivity.sTopActivity, 1, nearbyRelation$SsoIsFriendRsp.ret_msg.get(), 1).show();
                } else {
                    this.f254208f.a(NearbyAddFriendHelperImpl.this.decodeIsFriendRsp(nearbyRelation$SsoIsFriendRsp.is_friend.get()));
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e(NearbyAddFriendHelperImpl.TAG, 1, "isFriend error: " + e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class c extends ServletObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.newnearby.servlet.ServletObserver
        public void c(int i3, byte[] bArr, Bundle bundle) {
            if (i3 != 0) {
                NearbyAddFriendHelperImpl.this.showAbnormalDialog();
                QLog.e(NearbyAddFriendHelperImpl.TAG, 2, "addFriend fail: " + i3);
                return;
            }
            trpcNearbyAccount$SsoGetOpenIDByTinyIDRsp trpcnearbyaccount_ssogetopenidbytinyidrsp = new trpcNearbyAccount$SsoGetOpenIDByTinyIDRsp();
            try {
                trpcnearbyaccount_ssogetopenidbytinyidrsp.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e(NearbyAddFriendHelperImpl.TAG, 1, "addFriend error: " + e16);
            }
            int i16 = trpcnearbyaccount_ssogetopenidbytinyidrsp.ret_code.get();
            if (i16 != 0) {
                QLog.e(NearbyAddFriendHelperImpl.TAG, 2, "addFriend error:" + i16 + "-" + trpcnearbyaccount_ssogetopenidbytinyidrsp.ret_msg.get());
                NearbyAddFriendHelperImpl.this.showAbnormalDialog();
                return;
            }
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(BaseApplication.getContext(), ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(BaseApplication.getContext(), 3, trpcnearbyaccount_ssogetopenidbytinyidrsp.openid.get(), String.valueOf(trpcnearbyaccount_ssogetopenidbytinyidrsp.appid.get()), 3007, trpcnearbyaccount_ssogetopenidbytinyidrsp.sub_source_id.get(), null, null, null, "", null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Boolean> decodeIsFriendRsp(String str) {
        String[] split = str.split(",");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            arrayList.add(Boolean.valueOf("1".equals(str2)));
        }
        return arrayList;
    }

    private void doAddFriend(long j3, int i3, int i16, int i17, int i18) {
        if (!NetworkUtil.isNetworkAvailable()) {
            showAbnormalDialog();
            return;
        }
        trpcNearbyAccount$SsoGetOpenIDByTinyIDReq trpcnearbyaccount_ssogetopenidbytinyidreq = new trpcNearbyAccount$SsoGetOpenIDByTinyIDReq();
        trpcnearbyaccount_ssogetopenidbytinyidreq.tinyid.set(j3);
        trpcnearbyaccount_ssogetopenidbytinyidreq.source_id.set(i3);
        trpcnearbyaccount_ssogetopenidbytinyidreq.second_source_id.set(i16);
        trpcnearbyaccount_ssogetopenidbytinyidreq.third_source_id.set(i17);
        trpcnearbyaccount_ssogetopenidbytinyidreq.scene.set(i18);
        QLog.i(TAG, 2, "addFriendByTinyID=" + j3);
        com.tencent.mobileqq.newnearby.servlet.b.a(new d(i17, i18, i3, i16), trpcnearbyaccount_ssogetopenidbytinyidreq.toByteArray(), "trpc.nearby.trpc_nearby_account.NearbyAccount.SsoGetOpenIDByTinyID");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAbnormalDialog() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        pb2.a.a(qBaseActivity, qBaseActivity.getString(R.string.x_u), R.string.x_s, 0, null, new e()).show();
    }

    @Override // com.tencent.mobileqq.newnearby.INearbyAddFriendHelper
    public void addFriend(long j3) {
        trpcNearbyAccount$SsoGetOpenIDByTinyIDReq trpcnearbyaccount_ssogetopenidbytinyidreq = new trpcNearbyAccount$SsoGetOpenIDByTinyIDReq();
        trpcnearbyaccount_ssogetopenidbytinyidreq.tinyid.set(j3);
        trpcnearbyaccount_ssogetopenidbytinyidreq.source_id.set(3007L);
        com.tencent.mobileqq.newnearby.servlet.b.a(new c(), trpcnearbyaccount_ssogetopenidbytinyidreq.toByteArray(), "trpc.nearby.trpc_nearby_account.NearbyAccount.SsoGetOpenIDByTinyID");
    }

    @Override // com.tencent.mobileqq.newnearby.INearbyAddFriendHelper
    public void canAddFriend(long j3, INearbyAddFriendHelper.a aVar) {
        NearbyRelation$SsoIsShowNearbyAddFriendButtonReq nearbyRelation$SsoIsShowNearbyAddFriendButtonReq = new NearbyRelation$SsoIsShowNearbyAddFriendButtonReq();
        nearbyRelation$SsoIsShowNearbyAddFriendButtonReq.to_tiny_id.set(j3);
        com.tencent.mobileqq.newnearby.servlet.b.a(new a(aVar), nearbyRelation$SsoIsShowNearbyAddFriendButtonReq.toByteArray(), "trpc.nearby.trpc_nearby_relation.NearbyRelation.SsoIsShowNearbyAddFriendButton");
    }

    @Override // com.tencent.mobileqq.newnearby.INearbyAddFriendHelper
    public void isFriend(long j3, final INearbyAddFriendHelper.c cVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j3));
        isFriend(arrayList, new INearbyAddFriendHelper.b() { // from class: com.tencent.mobileqq.newnearby.impl.a
            @Override // com.tencent.mobileqq.newnearby.INearbyAddFriendHelper.b
            public final void a(List list) {
                NearbyAddFriendHelperImpl.lambda$isFriend$0(INearbyAddFriendHelper.c.this, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class d extends ServletObserver {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f254211f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f254212h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f254213i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f254214m;

        d(int i3, int i16, int i17, int i18) {
            this.f254211f = i3;
            this.f254212h = i16;
            this.f254213i = i17;
            this.f254214m = i18;
        }

        @Override // com.tencent.mobileqq.newnearby.servlet.ServletObserver
        public void c(int i3, byte[] bArr, Bundle bundle) {
            if (i3 != 0) {
                QLog.e(NearbyAddFriendHelperImpl.TAG, 2, "notifyServerEnterSource fail");
                return;
            }
            trpcNearbyAccount$SsoGetOpenIDByTinyIDRsp trpcnearbyaccount_ssogetopenidbytinyidrsp = new trpcNearbyAccount$SsoGetOpenIDByTinyIDRsp();
            try {
                trpcnearbyaccount_ssogetopenidbytinyidrsp.mergeFrom(bArr);
                if (trpcnearbyaccount_ssogetopenidbytinyidrsp.ret_code.get() != 0) {
                    QQToast.makeText(QBaseActivity.sTopActivity, 1, trpcnearbyaccount_ssogetopenidbytinyidrsp.ret_msg.get(), 1).show();
                    return;
                }
                String str = trpcnearbyaccount_ssogetopenidbytinyidrsp.openid.get();
                QLog.d(NearbyAddFriendHelperImpl.TAG, 2, "get openid=" + str);
                String valueOf = String.valueOf(trpcnearbyaccount_ssogetopenidbytinyidrsp.appid.get());
                ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).setsOpenId(valueOf);
                ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(BaseApplication.getContext(), ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(BaseApplication.getContext(), 3, str, valueOf, this.f254213i, this.f254214m, String.valueOf(this.f254211f).concat("_" + this.f254212h).getBytes(), (String) null, (String) null, (String) null, "", (String) null));
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e(NearbyAddFriendHelperImpl.TAG, 1, "getNearbyUserInfo error: " + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$isFriend$0(INearbyAddFriendHelper.c cVar, List list) {
        if (list != null && !list.isEmpty()) {
            cVar.a(((Boolean) list.get(0)).booleanValue());
        } else {
            cVar.a(false);
        }
    }

    @Override // com.tencent.mobileqq.newnearby.INearbyAddFriendHelper
    public void isFriend(List<Long> list, INearbyAddFriendHelper.b bVar) {
        if (!NetworkUtil.isNetworkAvailable()) {
            showAbnormalDialog();
            bVar.a(Collections.singletonList(Boolean.TRUE));
        } else {
            NearbyRelation$SsoIsFriendReq nearbyRelation$SsoIsFriendReq = new NearbyRelation$SsoIsFriendReq();
            nearbyRelation$SsoIsFriendReq.to_tinyids.set(list);
            com.tencent.mobileqq.newnearby.servlet.b.a(new b(bVar), nearbyRelation$SsoIsFriendReq.toByteArray(), "trpc.nearby.trpc_nearby_relation.NearbyRelation.SsoIsFriend");
        }
    }

    @Override // com.tencent.mobileqq.newnearby.INearbyAddFriendHelper
    public void addFriendFromYQ(long j3, int i3, int i16, int i17) {
        doAddFriend(j3, 3007, i3, i16, i17);
    }

    @Override // com.tencent.mobileqq.newnearby.INearbyAddFriendHelper
    public boolean isFromNearby(int i3, int i16, byte[] bArr) {
        return i3 == 3007 || (i3 == 3024 && bArr != null && "5010_1".equals(new String(bArr)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}

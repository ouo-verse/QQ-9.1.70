package com.tencent.biz.pubaccount.api.impl;

import com.tencent.biz.pubaccount.accountdetail.jce.SetRecvMsgStateRsp;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes32.dex */
public class PublicAccountObserverImpl implements BusinessObserver, IPublicAccountObserver {
    private IPublicAccountObserver.c mOnCallback;

    public void onDestroy() {
        IPublicAccountObserver.c cVar = this.mOnCallback;
        if (cVar != null) {
            cVar.onDestroy();
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver
    public void onDynamicListGet(boolean z16, int i3) {
        IPublicAccountObserver.c cVar = this.mOnCallback;
        if (cVar != null) {
            cVar.onDynamicListGet(z16, i3);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver
    public void onFollowPublicAccount(boolean z16, String str) {
        IPublicAccountObserver.c cVar = this.mOnCallback;
        if (cVar != null) {
            cVar.onFollowPublicAccount(z16, str);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver
    public void onUnfollowPublicAccount(boolean z16, String str) {
        IPublicAccountObserver.c cVar = this.mOnCallback;
        if (cVar != null) {
            cVar.onUnfollowPublicAccount(z16, str);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver
    public void setOnCallback(IPublicAccountObserver.c cVar) {
        this.mOnCallback = cVar;
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public final void onUpdate(int i3, boolean z16, Object obj) {
        long j3;
        int i16;
        if (100 == i3) {
            IPublicAccountObserver.b bVar = (IPublicAccountObserver.b) obj;
            IPublicAccountObserver.c cVar = this.mOnCallback;
            if (cVar != null) {
                cVar.onUpdateUserFollowList(bVar.f79353a, bVar.f79355c);
                return;
            }
            return;
        }
        if (101 == i3) {
            if (obj instanceof IPublicAccountObserver.a) {
                IPublicAccountObserver.a aVar = (IPublicAccountObserver.a) obj;
                IPublicAccountObserver.c cVar2 = this.mOnCallback;
                if (cVar2 != null) {
                    cVar2.onFollowPublicAccount(aVar.f79352b, (PublicAccountInfo) aVar.f79351a);
                    return;
                }
                return;
            }
            if (obj instanceof Integer) {
                IPublicAccountObserver.c cVar3 = this.mOnCallback;
                if (cVar3 != null) {
                    cVar3.onFollowPublicAccount(z16, ((Integer) obj).intValue());
                    return;
                }
                return;
            }
            IPublicAccountObserver.c cVar4 = this.mOnCallback;
            if (cVar4 != null) {
                cVar4.onFollowPublicAccount(z16, String.valueOf(obj));
                return;
            }
            return;
        }
        if (102 == i3) {
            if (obj instanceof IPublicAccountObserver.a) {
                IPublicAccountObserver.a aVar2 = (IPublicAccountObserver.a) obj;
                IPublicAccountObserver.c cVar5 = this.mOnCallback;
                if (cVar5 != null) {
                    cVar5.onUnfollowPublicAccount(aVar2.f79352b, (PublicAccountInfo) aVar2.f79351a);
                    return;
                }
                return;
            }
            IPublicAccountObserver.c cVar6 = this.mOnCallback;
            if (cVar6 != null) {
                cVar6.onUnfollowPublicAccount(z16, String.valueOf(obj));
                return;
            }
            return;
        }
        if (103 == i3) {
            IPublicAccountObserver.c cVar7 = this.mOnCallback;
            if (cVar7 != null) {
                cVar7.onDownPublicAccount();
                return;
            }
            return;
        }
        if (104 == i3) {
            IPublicAccountObserver.c cVar8 = this.mOnCallback;
            if (cVar8 != null) {
                cVar8.onUpdateRecommendList(z16);
                return;
            }
            return;
        }
        if (105 == i3) {
            int intValue = ((Integer) obj).intValue();
            IPublicAccountObserver.c cVar9 = this.mOnCallback;
            if (cVar9 != null) {
                cVar9.onGetHistoryMsgRet(intValue);
                return;
            }
            return;
        }
        if (106 == i3) {
            IPublicAccountObserver.c cVar10 = this.mOnCallback;
            if (cVar10 != null) {
                cVar10.onPublicAccountNotification(z16, ((Boolean) obj).booleanValue());
                return;
            }
            return;
        }
        if (109 == i3) {
            IPublicAccountConfigAttr.a aVar3 = (IPublicAccountConfigAttr.a) obj;
            IPublicAccountObserver.c cVar11 = this.mOnCallback;
            if (cVar11 != null) {
                cVar11.onUpdateFunctionFlag(z16, aVar3);
                return;
            }
            return;
        }
        if (108 == i3) {
            HashMap hashMap = (HashMap) obj;
            IPublicAccountObserver.c cVar12 = this.mOnCallback;
            if (cVar12 != null) {
                cVar12.onSetPublicAccountSubscribeStatus(z16, ((Integer) hashMap.get("seq")).intValue(), ((Long) hashMap.get("uin")).longValue());
                return;
            }
            return;
        }
        if (110 == i3) {
            IPublicAccountObserver.c cVar13 = this.mOnCallback;
            if (cVar13 != null) {
                cVar13.onGetGuideFriends(z16, (ArrayList) obj);
                return;
            }
            return;
        }
        if (111 == i3) {
            HashMap hashMap2 = (HashMap) obj;
            if (hashMap2 != null) {
                j3 = ((Long) hashMap2.get("uin")).longValue();
                i16 = ((Integer) hashMap2.get("status")).intValue();
            } else {
                j3 = 0;
                i16 = 0;
            }
            IPublicAccountObserver.c cVar14 = this.mOnCallback;
            if (cVar14 != null) {
                cVar14.onGetPublicAccountSubscribeStatus(z16, j3, i16);
                return;
            }
            return;
        }
        if (112 == i3 && (obj instanceof SetRecvMsgStateRsp)) {
            SetRecvMsgStateRsp setRecvMsgStateRsp = (SetRecvMsgStateRsp) obj;
            IPublicAccountObserver.c cVar15 = this.mOnCallback;
            if (cVar15 != null) {
                cVar15.onSetRecvMsgState(z16, setRecvMsgStateRsp);
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver
    public BusinessObserver getBusinessObserver() {
        return this;
    }
}

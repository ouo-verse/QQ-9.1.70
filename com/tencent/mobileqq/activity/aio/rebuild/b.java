package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.data.e;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.p;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private SessionInfo f179826a;

    /* renamed from: b, reason: collision with root package name */
    private gd1.a f179827b;

    /* renamed from: c, reason: collision with root package name */
    private gd1.a f179828c;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f179829d;

    /* renamed from: e, reason: collision with root package name */
    private Context f179830e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f179831f;

    /* renamed from: g, reason: collision with root package name */
    private MsgRecord f179832g;

    public b(SessionInfo sessionInfo, gd1.a aVar, gd1.a aVar2, QQAppInterface qQAppInterface, Context context, MsgRecord msgRecord) {
        this.f179826a = sessionInfo;
        this.f179827b = aVar;
        this.f179828c = aVar2;
        this.f179829d = qQAppInterface;
        this.f179830e = context;
        this.f179832g = msgRecord;
        this.f179831f = ((Boolean) p.c(context, "gamebox", sessionInfo.f179557e, "addfriend_tips", Boolean.FALSE)).booleanValue();
    }

    private void c() {
        this.f179826a = null;
        this.f179827b = null;
        this.f179828c = null;
        this.f179830e = null;
        this.f179829d = null;
        this.f179832g = null;
        this.f179831f = false;
    }

    private void d() {
        this.f179831f = true;
        p.e(this.f179830e, "gamebox", this.f179826a.f179557e, false, "addfriend_tips", Boolean.TRUE);
    }

    private boolean e(int[] iArr) {
        if (iArr[0] < 3 && iArr[1] < 3 && iArr[2] < 2) {
            return false;
        }
        d();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(String str, ArrayList arrayList) {
        if (g(arrayList)) {
            e.c(str);
            ReportController.n(this.f179829d, "P_CliOper", "dc00898", this.f179826a.f179557e, "0X800BF34", "0X800BF34", 0, 1, 0, "", "", "", "");
        }
        c();
    }

    private boolean g(List<MsgRecord> list) {
        if (list == null || list.size() == 0 || this.f179831f || this.f179828c == null || this.f179827b == null) {
            return false;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(this.f179828c.f401938b));
        if (this.f179828c != null && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "GameMsgHelper")) {
            return false;
        }
        int[] iArr = {0, 0, 0};
        boolean z16 = true;
        for (int i3 = 0; i3 < list.size(); i3++) {
            MsgRecord msgRecord = list.get(i3);
            if (msgRecord.getMsgType() != 11) {
                try {
                    if ((msgRecord.getSenderUin() + "").equals(this.f179826a.f179557e)) {
                        iArr[0] = iArr[0] + 1;
                    } else {
                        if ((msgRecord.getSenderUin() + "").equals(this.f179829d.getCurrentUin())) {
                            iArr[1] = iArr[1] + 1;
                        }
                    }
                    if (i3 > 1) {
                        if (!(list.get(i3 - 1).getSenderUin() + "").equals(msgRecord.getSenderUin() + "") && z16) {
                            iArr[2] = iArr[2] + 1;
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                    }
                } catch (Exception e16) {
                    QLog.e("GameMsgHelper", 1, e16, new Object[0]);
                }
            }
        }
        if (this.f179832g != null) {
            if ((this.f179832g.getSenderUin() + "").equals(this.f179829d.getCurrentUin())) {
                iArr[1] = iArr[1] + 1;
            }
            if (list.size() > 0) {
                if (!(this.f179832g.getSenderUin() + "").equals(list.get(list.size() - 1).getSenderUin() + "") && z16) {
                    iArr[2] = iArr[2] + 1;
                }
            }
        }
        return e(iArr);
    }

    public void b(final String str) {
        ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getMsgList(str, 105, 100, new IGameMsgNtApi.b() { // from class: com.tencent.mobileqq.activity.aio.rebuild.a
            @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi.b
            public final void onSuccess(ArrayList arrayList) {
                b.this.f(str, arrayList);
            }
        });
    }
}

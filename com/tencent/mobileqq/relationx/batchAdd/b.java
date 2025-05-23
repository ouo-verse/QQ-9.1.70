package com.tencent.mobileqq.relationx.batchAdd;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qqnt.troopmemberlist.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import tencent.im.oidb.cmd0x777.cmd0x777$AddFrdInfo;
import tencent.im.oidb.cmd0x777.cmd0x777$ClientExtention;
import tencent.im.oidb.cmd0x777.cmd0x777$Permission;
import tencent.im.oidb.cmd0x777.cmd0x777$ReqBody;
import tencent.im.oidb.cmd0x777.cmd0x777$RspBody;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<Long> f280694a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<cmd0x777$AddFrdInfo> f280695b;

    /* renamed from: c, reason: collision with root package name */
    private final long[] f280696c;

    /* renamed from: d, reason: collision with root package name */
    private String f280697d;

    /* renamed from: e, reason: collision with root package name */
    private String f280698e;

    /* renamed from: f, reason: collision with root package name */
    private int f280699f;

    /* renamed from: g, reason: collision with root package name */
    private String f280700g;

    /* renamed from: h, reason: collision with root package name */
    private int f280701h;

    /* renamed from: i, reason: collision with root package name */
    private int f280702i;

    /* renamed from: j, reason: collision with root package name */
    private int f280703j;

    /* renamed from: k, reason: collision with root package name */
    private int f280704k;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f280694a = new ArrayList<>();
        this.f280695b = new ArrayList<>();
        this.f280696c = new long[30];
        this.f280699f = 0;
        this.f280700g = null;
        this.f280701h = 0;
        this.f280702i = 0;
        this.f280697d = null;
    }

    private ByteStringMicro c() {
        cmd0x777$ClientExtention cmd0x777_clientextention = new cmd0x777$ClientExtention();
        cmd0x777_clientextention.bytes_permission.set(ByteStringMicro.copyFrom(d(this.f280704k).toByteArray()));
        return ByteStringMicro.copyFrom(cmd0x777_clientextention.toByteArray());
    }

    public static void g(Context context, int i3, String str, String str2, String str3, String str4) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 30);
            intent.putExtra("group_uin", str2);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_GROUPCODE, str);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 30);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 4);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 30);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, 30);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_EXIT_ANIMATION, 3);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_BATCH_ADDFRD_SCENE_TYPE, i3);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_BATCH_ADDFRD_MAYKNOW_STRATEGY, str4);
            if (!TextUtils.isEmpty(str3)) {
                intent.putExtra(ISelectMemberActivityConstants.PARAM_BATCH_ADDFRD_RECOMMAND_UIN, str3);
            }
            ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(context, intent);
            ((Activity) context).overridePendingTransition(R.anim.f154454a3, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(FriendListHandler friendListHandler, ArrayList arrayList, boolean z16, List list) {
        int commonFrdCnt;
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            TroopMemberInfo troopMemberInfo = (TroopMemberInfo) it.next();
            hashMap.put(troopMemberInfo.memberuin, troopMemberInfo);
        }
        FriendsManager friendsManager = (FriendsManager) friendListHandler.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        boolean z17 = false;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            cmd0x777$AddFrdInfo cmd0x777_addfrdinfo = (cmd0x777$AddFrdInfo) arrayList.get(i3);
            if (cmd0x777_addfrdinfo != null) {
                if (cmd0x777_addfrdinfo.uint32_send_req_flag.get() == 2) {
                    TroopMemberInfo troopMemberInfo2 = (TroopMemberInfo) hashMap.get(String.valueOf(cmd0x777_addfrdinfo.uint64_uin.get()));
                    if (troopMemberInfo2 != null) {
                        if (!TextUtils.isEmpty(troopMemberInfo2.troopnick)) {
                            cmd0x777_addfrdinfo.bytes_remark.set(troopMemberInfo2.troopnick);
                        } else if (!TextUtils.isEmpty(troopMemberInfo2.friendnick)) {
                            cmd0x777_addfrdinfo.bytes_remark.set(troopMemberInfo2.friendnick);
                        }
                        PBUInt32Field pBUInt32Field = cmd0x777_addfrdinfo.uint32_send_req_result;
                        if (troopMemberInfo2.noCommonFrdCnt()) {
                            commonFrdCnt = 0;
                        } else {
                            commonFrdCnt = troopMemberInfo2.getCommonFrdCnt();
                        }
                        pBUInt32Field.set(commonFrdCnt);
                    } else if (QLog.isDevelopLevel()) {
                        QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "sendResult TroopMemberInfo is null [troopUin: %s, memberUin: %s] ", this.f280697d, Long.valueOf(cmd0x777_addfrdinfo.uint64_uin.get())));
                    }
                }
                if (cmd0x777_addfrdinfo.uint32_send_req_flag.get() != Integer.MIN_VALUE) {
                    z17 = true;
                }
                if (cmd0x777_addfrdinfo.uint32_send_req_flag.get() == 1) {
                    if (cmd0x777_addfrdinfo.uint32_send_req_result.get() != 0) {
                        friendsManager.y0(Long.toString(cmd0x777_addfrdinfo.uint64_uin.get()), false);
                    }
                } else {
                    friendsManager.y0(Long.toString(cmd0x777_addfrdinfo.uint64_uin.get()), false);
                }
            }
        }
        this.f280695b.clear();
        friendListHandler.notifyUI(107, z17, new Object[]{this.f280697d, arrayList});
        if (QLog.isDevelopLevel()) {
            QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "sendResult isSuc: %s, troop: %s, size: %s", Boolean.valueOf(z17), this.f280697d, Integer.valueOf(arrayList.size())));
        }
    }

    private void i(final FriendListHandler friendListHandler) {
        if (friendListHandler == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("BatchAddFriendData", 4, "sendResult friendListHandler is null ");
            }
        } else {
            final ArrayList arrayList = (ArrayList) this.f280695b.clone();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(String.valueOf(((cmd0x777$AddFrdInfo) it.next()).uint64_uin.get()));
            }
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberUinListInfoWithExtInfo(this.f280697d, arrayList2, false, null, "BatchAddFriendData", new f() { // from class: com.tencent.mobileqq.relationx.batchAdd.a
                @Override // com.tencent.qqnt.troopmemberlist.f
                public final void a(boolean z16, List list) {
                    b.this.h(friendListHandler, arrayList, z16, list);
                }
            });
        }
    }

    public static void j(QQAppInterface qQAppInterface, Activity activity, String str, List<cmd0x777$AddFrdInfo> list) {
        String str2;
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("BatchAddFriendData", 4, "showResult not in ui thread !");
                return;
            }
            return;
        }
        if (activity != null && list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            for (cmd0x777$AddFrdInfo cmd0x777_addfrdinfo : list) {
                if (cmd0x777_addfrdinfo != null) {
                    if (cmd0x777_addfrdinfo.uint32_send_req_flag.get() == 1) {
                        if (cmd0x777_addfrdinfo.uint32_send_req_result.get() == 0) {
                            i3++;
                        } else {
                            i16++;
                        }
                    } else if (cmd0x777_addfrdinfo.uint32_send_req_flag.get() == 2) {
                        i17++;
                        if (cmd0x777_addfrdinfo.uint32_allow_type.get() == 1) {
                            i19++;
                        } else if (cmd0x777_addfrdinfo.uint32_allow_type.get() == 2) {
                            arrayList.add(cmd0x777_addfrdinfo);
                        }
                    } else {
                        i18++;
                    }
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "showResult total: %s, sendOk: %s, sendFail: %s, notSend: %s, clientFail: %s, refuseAdd: %s, answerQuestion: %s", Integer.valueOf(list.size()), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(arrayList.size())));
            }
            if (i3 > 0) {
                QQToast.makeText(BaseApplication.getContext(), 0, HardCodeUtil.qqStr(R.string.jzy), 0).show();
            } else if (i16 > 0 || i18 > 0) {
                QQToast.makeText(BaseApplication.getContext(), 0, HardCodeUtil.qqStr(R.string.f171647k01), 0).show();
            }
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                String str3 = null;
                cmd0x777$AddFrdInfo cmd0x777_addfrdinfo2 = null;
                cmd0x777$AddFrdInfo cmd0x777_addfrdinfo3 = null;
                while (it.hasNext()) {
                    cmd0x777$AddFrdInfo cmd0x777_addfrdinfo4 = (cmd0x777$AddFrdInfo) it.next();
                    if (cmd0x777_addfrdinfo2 != null && cmd0x777_addfrdinfo4.uint32_send_req_result.get() <= cmd0x777_addfrdinfo2.uint32_send_req_result.get()) {
                        if (cmd0x777_addfrdinfo3 == null || cmd0x777_addfrdinfo4.uint32_send_req_result.get() > cmd0x777_addfrdinfo3.uint32_send_req_result.get()) {
                            cmd0x777_addfrdinfo3 = cmd0x777_addfrdinfo4;
                        }
                    } else {
                        cmd0x777_addfrdinfo3 = cmd0x777_addfrdinfo2;
                        cmd0x777_addfrdinfo2 = cmd0x777_addfrdinfo4;
                    }
                }
                if (arrayList.size() == 1 && cmd0x777_addfrdinfo2 != null) {
                    str3 = cmd0x777_addfrdinfo2.bytes_remark.get();
                } else if (arrayList.size() == 2 && cmd0x777_addfrdinfo2 != null && cmd0x777_addfrdinfo3 != null) {
                    str3 = String.format(Locale.getDefault(), "%s\u3001%s", cmd0x777_addfrdinfo2.bytes_remark.get(), cmd0x777_addfrdinfo3.bytes_remark.get());
                } else if (cmd0x777_addfrdinfo2 != null && cmd0x777_addfrdinfo3 != null) {
                    str3 = String.format(Locale.getDefault(), "%s\u3001%s\u7b49%s\u4f4d\u597d\u53cb", cmd0x777_addfrdinfo2.bytes_remark.get(), cmd0x777_addfrdinfo3.bytes_remark.get(), Integer.valueOf(arrayList.size()));
                }
                QQCustomDialog createNoTitleDialog = DialogUtil.createNoTitleDialog(activity, String.format(Locale.getDefault(), HardCodeUtil.qqStr(R.string.f171651k05), str3), 0, 0, null, null);
                createNoTitleDialog.setPositiveButton(R.string.f171151ok, new a());
                if (!activity.isFinishing()) {
                    createNoTitleDialog.show();
                }
                ReportController.o(qQAppInterface, "dc00899", "Grp_addFrd", "", "frd_select", "notAdd_exp", 0, 0, str, String.valueOf(i17), "", "");
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            if (activity == null) {
                str2 = "showResult context is null !";
            } else {
                str2 = "showResult list is null or size is zero !";
            }
            QLog.d("BatchAddFriendData", 4, str2);
        }
    }

    public synchronized void b(FriendListHandler friendListHandler) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) friendListHandler);
            return;
        }
        if (friendListHandler == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("BatchAddFriendData", 4, "doSendBatchAddFriendForTroopMember friendListHandler is null ");
            }
            return;
        }
        FriendsManager friendsManager = (FriendsManager) friendListHandler.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        int min = Math.min(this.f280694a.size(), this.f280696c.length);
        this.f280699f = min;
        if (min > 0) {
            try {
                j3 = Long.parseLong(this.f280698e);
            } catch (Throwable th5) {
                th5.printStackTrace();
                j3 = 0;
            }
            cmd0x777$ReqBody cmd0x777_reqbody = new cmd0x777$ReqBody();
            cmd0x777_reqbody.uint64_group_uin.set(j3);
            cmd0x777_reqbody.bytes_msg.set(this.f280700g);
            cmd0x777_reqbody.uint32_source_id.set(this.f280701h);
            cmd0x777_reqbody.uint32_sub_source_id.set(this.f280702i);
            cmd0x777_reqbody.uint32_friend_group.set(this.f280703j);
            cmd0x777_reqbody.bytes_client_ext.set(c());
            for (int i3 = this.f280699f - 1; i3 >= 0; i3--) {
                long longValue = this.f280694a.remove(i3).longValue();
                this.f280696c[i3] = longValue;
                cmd0x777_reqbody.rpt_uint64_uin.add(Long.valueOf(longValue));
                friendsManager.y0(Long.toString(longValue), true);
            }
            ToServiceMsg makeOIDBPkg = friendListHandler.makeOIDBPkg("OidbSvc.0x777", 1911, 1, cmd0x777_reqbody.toByteArray());
            makeOIDBPkg.extraData.putLongArray("send_uin_array", this.f280696c);
            friendListHandler.sendPbReq(makeOIDBPkg);
            if (QLog.isDevelopLevel()) {
                QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "doSendBatchAddFriendForTroopMember sending: %s pending: %s", Integer.valueOf(this.f280699f), Integer.valueOf(this.f280694a.size())));
            }
        } else {
            i(friendListHandler);
        }
    }

    public cmd0x777$Permission d(int i3) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (cmd0x777$Permission) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        cmd0x777$Permission cmd0x777_permission = new cmd0x777$Permission();
        boolean z18 = false;
        if ((i3 & 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (((i3 >> 1) & 1) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (((i3 >> 2) & 1) == 1) {
            z18 = true;
        }
        cmd0x777_permission.qzone_not_watch.set(z18);
        cmd0x777_permission.qzone_not_watched.set(z17);
        cmd0x777_permission.only_chat.set(z16);
        return cmd0x777_permission;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(FriendListHandler friendListHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        List<cmd0x777$AddFrdInfo> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, friendListHandler, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (friendListHandler == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("BatchAddFriendData", 4, "handleAddBatchTroopMembers friendListHandler is null ");
                return;
            }
            return;
        }
        long[] longArray = toServiceMsg.extraData.getLongArray("send_uin_array");
        int i16 = this.f280699f;
        if (i16 > 0 && longArray != null && longArray.length >= i16) {
            for (int i17 = 0; i17 < this.f280699f; i17++) {
                if (longArray[i17] == this.f280696c[i17]) {
                }
            }
            z16 = true;
            if (z16) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("BatchAddFriendData", 4, "handleAddBatchTroopMembers is not cur sending resp!");
                    return;
                }
                return;
            }
            int i18 = this.f280699f;
            cmd0x777$RspBody cmd0x777_rspbody = new cmd0x777$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x777_rspbody);
            if (parseOIDBPkg == 0) {
                arrayList = cmd0x777_rspbody.rpt_add_frd_info.get();
            } else {
                arrayList = new ArrayList<>();
                for (int i19 = 0; i19 < i18; i19++) {
                    cmd0x777$AddFrdInfo cmd0x777_addfrdinfo = new cmd0x777$AddFrdInfo();
                    cmd0x777_addfrdinfo.uint64_uin.set(this.f280696c[i19]);
                    cmd0x777_addfrdinfo.uint32_send_req_flag.set(Integer.MIN_VALUE);
                    arrayList.add(cmd0x777_addfrdinfo);
                }
            }
            this.f280699f = 0;
            if (arrayList != null && arrayList.size() > 0) {
                this.f280695b.addAll(arrayList);
            }
            if (QLog.isDevelopLevel()) {
                Locale locale = Locale.getDefault();
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf(parseOIDBPkg);
                objArr[1] = Integer.valueOf(i18);
                if (arrayList != null) {
                    i3 = arrayList.size();
                }
                objArr[2] = Integer.valueOf(i3);
                objArr[3] = Integer.valueOf(this.f280695b.size());
                objArr[4] = Integer.valueOf(this.f280694a.size());
                QLog.d("BatchAddFriendData", 4, String.format(locale, "handleAddBatchTroopMembers result: %s sending: %s, cur:%s  total: %s pending: %s", objArr));
            }
            if (this.f280694a.size() > 0) {
                b(friendListHandler);
                return;
            } else {
                i(friendListHandler);
                return;
            }
        }
        z16 = false;
        if (z16) {
        }
    }

    public boolean f(String str, String str2, String str3, List<String> list, boolean z16, int i3, int i16, int i17, int i18) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, str, str2, str3, list, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18))).booleanValue();
        }
        if (list != null && !list.isEmpty()) {
            if (z16) {
                this.f280694a.clear();
                this.f280695b.clear();
                this.f280699f = 0;
            }
            if (this.f280694a.size() <= 0 && this.f280695b.size() <= 0 && this.f280699f <= 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "init isSending pending: %s result: %s curSending: ", Integer.valueOf(this.f280694a.size()), Integer.valueOf(this.f280695b.size()), Integer.valueOf(this.f280699f)));
                }
                return false;
            }
            this.f280697d = str;
            this.f280698e = str2;
            this.f280700g = str3;
            this.f280701h = i3;
            this.f280702i = i16;
            this.f280704k = i18;
            this.f280703j = i17;
            for (String str4 : list) {
                if (str4 != null && !str4.isEmpty()) {
                    try {
                        this.f280694a.add(Long.valueOf(Long.parseLong(str4)));
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "init pending: %s, troopuin: %s, troopcode: %s, sourceId: %s, subSourceId: %s, msg: %s", Integer.valueOf(this.f280694a.size()), this.f280697d, this.f280698e, Integer.valueOf(this.f280701h), Integer.valueOf(this.f280702i), this.f280700g));
            }
            return true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("BatchAddFriendData", 4, "init uinList is null or empty!");
        }
        return false;
    }
}

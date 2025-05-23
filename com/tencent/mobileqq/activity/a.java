package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_common$GroupInfo;
import tencent.im.msg.im_common$User;
import tencent.im.msg.im_imagent$ImAgentHead;
import tencent.im.msg.im_imagent$ImAgentPackage;
import tencent.im.msg.im_imagent$Signature;
import tencent.im.msg.im_msg$ContentHead;
import tencent.im.msg.im_msg$Group;
import tencent.im.msg.im_msg$Msg;
import tencent.im.msg.im_msg$MsgHead;
import tencent.im.msg.im_msg$MsgSendReq;
import tencent.im.msg.im_msg$RoutingHead;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$GeneralFlags;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.msg.im_msg_body$Text;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f177652a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class DialogInterfaceOnClickListenerC7116a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f177653d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f177654e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f177655f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f177656h;

        DialogInterfaceOnClickListenerC7116a(Activity activity, String str, int i3, boolean z16) {
            this.f177653d = activity;
            this.f177654e = str;
            this.f177655f = i3;
            this.f177656h = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, activity, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            VasH5PayUtil.openH5Pay(this.f177653d, "mvip.n.a.gnew_apply", this.f177654e, 3, false, false, "", "", true, true);
            ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A4FB", this.f177655f, 0, "", "", "", "");
            if (this.f177656h) {
                a.d(this.f177655f, 1);
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f177657d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f177658e;

        b(boolean z16, int i3) {
            this.f177657d = z16;
            this.f177658e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            dialogInterface.dismiss();
            if (this.f177657d) {
                a.d(this.f177658e, 0);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66587);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f177652a = (int) (System.currentTimeMillis() & (-1));
        }
    }

    public static byte[] b(int i3, String str, String str2, long j3, long j16, int i16) {
        Object valueOf;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
        if (!TextUtils.isEmpty(str2)) {
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
            im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(str2));
            im_msg_body_elem.text.set(im_msg_body_text);
            im_msg_body_richtext.elems.add(im_msg_body_elem);
            im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
            im_msg_body$GeneralFlags im_msg_body_generalflags = new im_msg_body$GeneralFlags();
            generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
            generalflags_resvattr.uint32_troop_pobing_template.set(i16);
            generalflags_resvattr.uint32_is_ice_break_msg.set(1);
            im_msg_body_generalflags.bytes_pb_reserve.set(ByteStringMicro.copyFrom(generalflags_resvattr.toByteArray()));
            im_msg_body_elem2.general_flags.set(im_msg_body_generalflags);
            im_msg_body_richtext.elems.add(im_msg_body_elem2);
        }
        im_msg_body$MsgBody im_msg_body_msgbody = new im_msg_body$MsgBody();
        im_msg_body_msgbody.rich_text.set(im_msg_body_richtext);
        im_msg$Msg im_msg_msg = new im_msg$Msg();
        im_msg_msg.body.set(im_msg_body_msgbody);
        im_msg$Group im_msg_group = new im_msg$Group();
        im_common$User im_common_user = new im_common$User();
        im_common_user.uin.set(j3);
        im_common_user.app_id.set(1001);
        im_common_user.instance_id.set(1);
        im_common_user.client_ip.set((int) com.dataline.util.d.a());
        im_common_user.platform_id.set(109);
        im_common_user.version.set(AppSetting.f());
        im_msg_group.sender.set(im_common_user);
        im_msg_group.sender.uin.set(j3);
        im_msg_group.group_info.set(new im_common$GroupInfo());
        im_msg_group.group_info.group_id.set(j16);
        im_msg_group.group_info.group_type.set(1);
        im_msg$RoutingHead im_msg_routinghead = new im_msg$RoutingHead();
        im_msg_routinghead.group.set(im_msg_group);
        im_msg$ContentHead im_msg_contenthead = new im_msg$ContentHead();
        PBUInt32Field pBUInt32Field = im_msg_contenthead.seq;
        int i17 = f177652a;
        f177652a = i17 + 1;
        pBUInt32Field.set(i17);
        im_msg$MsgHead im_msg_msghead = new im_msg$MsgHead();
        im_msg_msghead.content_head.set(im_msg_contenthead);
        im_msg_msghead.routing_head.set(im_msg_routinghead);
        im_msg_msg.head.set(im_msg_msghead);
        im_imagent$Signature im_imagent_signature = new im_imagent$Signature();
        im_imagent_signature.key_type.set(1);
        im_imagent_signature.session_app_id.set(256);
        im_imagent$ImAgentHead im_imagent_imagenthead = new im_imagent$ImAgentHead();
        im_imagent_imagenthead.command.set(3);
        im_imagent_imagenthead.signature.set(im_imagent_signature);
        im_imagent_imagenthead.req_user.set(im_common_user);
        PBUInt32Field pBUInt32Field2 = im_imagent_imagenthead.seq;
        int i18 = f177652a;
        f177652a = i18 + 1;
        pBUInt32Field2.set(i18);
        im_msg$MsgSendReq im_msg_msgsendreq = new im_msg$MsgSendReq();
        im_msg_msgsendreq.f435953msg.set(im_msg_msg);
        im_imagent$ImAgentPackage im_imagent_imagentpackage = new im_imagent$ImAgentPackage();
        im_imagent_imagentpackage.head.set(im_imagent_imagenthead);
        im_imagent_imagentpackage.msg_send_req.set(im_msg_msgsendreq);
        byte[] byteArray = im_imagent_imagentpackage.toByteArray();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(byteArray.length + 8);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            try {
                dataOutputStream.writeInt(byteArray.length + 8);
                dataOutputStream.write(123);
                dataOutputStream.write(123);
                dataOutputStream.write(byteArray);
                dataOutputStream.write(125);
                dataOutputStream.write(125);
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("composeRichMsg, result len:");
                if (byteArray2 == null) {
                    valueOf = "null";
                } else {
                    valueOf = Integer.valueOf(byteArray2.length);
                }
                sb5.append(valueOf);
                QLog.e("AddFriendVerifyUtils", 1, sb5.toString());
                try {
                    byteArrayOutputStream.close();
                    dataOutputStream.close();
                } catch (Exception unused) {
                }
                return byteArray2;
            } catch (Exception e16) {
                e16.printStackTrace();
                try {
                    byteArrayOutputStream.close();
                    dataOutputStream.close();
                } catch (Exception unused2) {
                }
                return null;
            }
        } catch (Throwable th5) {
            try {
                byteArrayOutputStream.close();
                dataOutputStream.close();
            } catch (Exception unused3) {
            }
            throw th5;
        }
    }

    private static int c() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return 0;
        }
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(peekAppRuntime.getCurrentAccountUin()), "AddFriendVerifyUtils");
        if (vasSimpleInfoWithUid == null) {
            return 0;
        }
        com.tencent.mobileqq.vip.api.f highestVipType = com.tencent.mobileqq.vip.api.d.a().getHighestVipType(vasSimpleInfoWithUid);
        if (highestVipType.c()) {
            return 3;
        }
        if (highestVipType.d()) {
            return 1;
        }
        if (!highestVipType.e()) {
            return 0;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(int i3, int i16) {
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.VIPKey.KEY_FOR_VIP_TYPE, Integer.valueOf(c()));
        hashMap.put("btn_type", Integer.valueOf(i16));
        hashMap.put("value_add_module", Integer.valueOf(i3));
        VideoReport.reportEvent("ev_group_open_vip_pop_clck", hashMap);
    }

    private static void e(int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.VIPKey.KEY_FOR_VIP_TYPE, Integer.valueOf(c()));
        hashMap.put("value_add_module", Integer.valueOf(i3));
        VideoReport.reportEvent("ev_group_open_vip_pop_imp", hashMap);
    }

    public static void f(Activity activity, int i3, boolean z16) {
        String qqStr;
        String str;
        int i16;
        String qqStr2 = HardCodeUtil.qqStr(R.string.j4m);
        if (i3 != 4002) {
            if (i3 != 5002) {
                if (i3 != 12002) {
                    if (i3 != 16002) {
                        QLog.e("AddFriendVerifyUtils", 1, "showPayDialog, UNKOWN errorCode: " + i3);
                        return;
                    }
                    QQToast.makeText(activity, 1, HardCodeUtil.qqStr(R.string.j49), 1).show();
                    return;
                }
                qqStr = HardCodeUtil.qqStr(R.string.j3r);
                str = "SVHHZLH";
                i16 = 3;
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.j3s);
                str = "CJCLUBT";
                i16 = 2;
            }
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.j3l);
            str = "LTMCLUB";
            i16 = 1;
        }
        if (z16) {
            e(i16);
        }
        int i17 = i16;
        ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A4FA", i16, 0, "", "", "", "");
        DialogUtil.createCustomDialog(activity, 230, qqStr2, String.format(HardCodeUtil.qqStr(R.string.j47), qqStr, qqStr), HardCodeUtil.qqStr(R.string.j4l), String.format(HardCodeUtil.qqStr(R.string.j4a), qqStr), new DialogInterfaceOnClickListenerC7116a(activity, str, i17, z16), new b(z16, i17)).show();
    }
}

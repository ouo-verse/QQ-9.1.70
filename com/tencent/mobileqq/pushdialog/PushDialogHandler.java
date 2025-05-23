package com.tencent.mobileqq.pushdialog;

import OnlinePushPack.MsgInfo;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.graytip.UniteEntity;
import com.tencent.mobileqq.graytip.i;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0xe3e.oidb_0xe3e$ResvAttr;
import tencent.im.s2c.msgtype0x210.submsgtype0x122.submsgtype0x122$MsgBody;

/* loaded from: classes16.dex */
public class PushDialogHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static volatile PushDialogHandler f261328c;

    /* renamed from: a, reason: collision with root package name */
    private EntityManager f261329a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f261330b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74307);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f261328c = null;
        }
    }

    public PushDialogHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f261329a = null;
            this.f261330b = null;
        }
    }

    private Handler a() {
        if (this.f261330b == null) {
            this.f261330b = new Handler(Looper.getMainLooper());
        }
        return this.f261330b;
    }

    public static PushDialogHandler b() {
        if (f261328c == null) {
            synchronized (PushDialogHandler.class) {
                if (f261328c == null) {
                    f261328c = new PushDialogHandler();
                }
            }
        }
        return f261328c;
    }

    private void d(long j3, PushDialogTemplate pushDialogTemplate, byte[] bArr) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!peekAppRuntime.isBackgroundStop && !peekAppRuntime.isBackgroundPause) {
            UniteEntity uniteEntity = null;
            try {
                byte[] bArr2 = pushDialogTemplate.templ_content;
                if (bArr2 != null) {
                    uniteEntity = i.l(new String(bArr2, "utf-8"));
                }
            } catch (Exception e16) {
                QLog.w("PushDialogHandler", 1, "showCommonGlobalDialog", e16);
            }
            if (uniteEntity == null) {
                QLog.w("PushDialogHandler", 1, "showCommonGlobalDialog parse unitEntity is null");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("PushDialogHandler", 2, "showCommonGlobalDialog busId=" + j3);
            }
            Intent intent = new Intent();
            intent.putExtra("type", 20);
            intent.putExtra("commonDialogTemplate", uniteEntity);
            intent.putExtra("businessId", j3);
            if ((j3 == 10169 || j3 == 10171) && bArr != null) {
                try {
                    oidb_0xe3e$ResvAttr oidb_0xe3e_resvattr = new oidb_0xe3e$ResvAttr();
                    oidb_0xe3e_resvattr.mergeFrom(bArr);
                    intent.putExtra(TangramHippyConstants.LOGIN_TYPE, oidb_0xe3e_resvattr.uint32_qqlogin_type.get());
                } catch (Exception e17) {
                    QLog.w("PushDialogHandler", 1, "decoding loginType is fail", e17);
                }
            }
            intent.setFlags(872415232);
            RouteUtils.startActivity(peekAppRuntime.getApp(), intent, RouterConstants.UI_ROUTER_NOTIFICATION);
        }
    }

    private void e(long j3, long j16, submsgtype0x122$MsgBody submsgtype0x122_msgbody) {
        UniteEntity uniteEntity;
        int i3;
        byte[] byteArray = submsgtype0x122_msgbody.bytes_content.get().toByteArray();
        if (byteArray != null) {
            int i16 = 2;
            try {
                String str = new String(byteArray, "utf-8");
                if (QLog.isColorLevel()) {
                    QLog.d("PushDialogHandler", 2, "configContent : ", str);
                }
                uniteEntity = i.l(str);
            } catch (UnsupportedEncodingException e16) {
                QLog.e("PushDialogHandler", 1, "e:", e16);
                uniteEntity = null;
            }
            if (uniteEntity != null) {
                UniteEntity.Note rootNote = uniteEntity.getRootNote();
                if (rootNote.getNoteType() != 6) {
                    QLog.e("PushDialogHandler", 1, "error note type:", Integer.valueOf(rootNote.getNoteType()));
                    return;
                }
                ArrayList<UniteEntity.Note> subNotes = rootNote.getSubNotes();
                if (subNotes != null) {
                    String str2 = "";
                    String str3 = "";
                    String str4 = str3;
                    String str5 = str4;
                    String str6 = str5;
                    String str7 = str6;
                    String str8 = str7;
                    String str9 = str8;
                    String str10 = str9;
                    String str11 = str10;
                    for (UniteEntity.Note note : subNotes) {
                        HashMap<Integer, Object> fields = note.getFields();
                        ArrayList<UniteEntity.Note> subNotes2 = note.getSubNotes();
                        if (note.getNoteType() == 7) {
                            str2 = (String) fields.get(Integer.valueOf(i16));
                        } else if (note.getNoteType() == 8) {
                            if (subNotes2 != null && subNotes2.size() != 0) {
                                for (UniteEntity.Note note2 : subNotes2) {
                                    HashMap<Integer, Object> fields2 = note2.getFields();
                                    if (note2.getNoteType() == i16) {
                                        if (fields2 != null) {
                                            String str12 = (String) fields2.get(Integer.valueOf(i16));
                                            if (!TextUtils.isEmpty(str12)) {
                                                str3 = str12;
                                            }
                                        }
                                    } else if (note2.getNoteType() == 3 && fields2 != null) {
                                        str4 = (String) fields2.get(Integer.valueOf(i16));
                                        str5 = (String) fields2.get(4);
                                    }
                                }
                            }
                        } else if (note.getNoteType() == 9 && subNotes2 != null) {
                            int i17 = 0;
                            for (UniteEntity.Note note3 : subNotes2) {
                                if (note3.getNoteType() == 10) {
                                    HashMap<Integer, Object> fields3 = note3.getFields();
                                    String str13 = (String) fields3.get(2);
                                    String str14 = (String) fields3.get(4);
                                    if (i17 == 0) {
                                        str9 = str14;
                                        str6 = str13;
                                    } else if (i17 == 1) {
                                        str10 = str14;
                                        str7 = str13;
                                    } else {
                                        i3 = 2;
                                        if (i17 == 2) {
                                            str11 = str14;
                                            str8 = str13;
                                        }
                                        i17++;
                                    }
                                    i3 = 2;
                                    i17++;
                                } else {
                                    i3 = 2;
                                }
                                i16 = i3;
                            }
                        }
                        i16 = i16;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("public_fragment_window_feature", 1);
                    intent.putExtra("BusiType", j16);
                    intent.putExtra("Title", str2);
                    intent.putExtra("Message", str3);
                    intent.putExtra("contentUrlText", str4);
                    intent.putExtra("contentUrlValue", str5);
                    intent.putExtra("btnText1", str6);
                    intent.putExtra("btnText2", str7);
                    intent.putExtra("btnText3", str8);
                    intent.putExtra("btnAction1", str9);
                    intent.putExtra("btnAction2", str10);
                    intent.putExtra("btnAction3", str11);
                    QPublicFragmentActivity.b.d(intent, QPublicTransFragmentActivity.class, ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).getHintDlgFragment());
                }
            }
        }
    }

    public void c(submsgtype0x122$MsgBody submsgtype0x122_msgbody, MsgInfo msgInfo, QQAppInterface qQAppInterface) {
        long j3;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, submsgtype0x122_msgbody, msgInfo, qQAppInterface);
            return;
        }
        if (submsgtype0x122_msgbody.uint64_busi_type.has()) {
            submsgtype0x122_msgbody.uint64_busi_type.get();
        }
        long j16 = 0;
        if (submsgtype0x122_msgbody.uint64_busi_id.has()) {
            j3 = submsgtype0x122_msgbody.uint64_busi_id.get();
        } else {
            j3 = 0;
        }
        if (submsgtype0x122_msgbody.uint32_ctrl_flag.has()) {
            submsgtype0x122_msgbody.uint32_ctrl_flag.get();
        }
        if (submsgtype0x122_msgbody.uint32_c2c_type.has()) {
            submsgtype0x122_msgbody.uint32_c2c_type.get();
        }
        if (submsgtype0x122_msgbody.uint32_service_type.has()) {
            submsgtype0x122_msgbody.uint32_service_type.get();
        }
        byte[] bArr2 = null;
        if (submsgtype0x122_msgbody.bytes_content.has()) {
            bArr = submsgtype0x122_msgbody.bytes_content.get().toByteArray();
        } else {
            bArr = null;
        }
        if (submsgtype0x122_msgbody.uint64_templ_id.has()) {
            j16 = submsgtype0x122_msgbody.uint64_templ_id.get();
        }
        long j17 = j16;
        if (submsgtype0x122_msgbody.bytes_pb_reserv.has()) {
            bArr2 = submsgtype0x122_msgbody.bytes_pb_reserv.get().toByteArray();
        }
        byte[] bArr3 = bArr2;
        if (bArr != null && bArr.length > 0) {
            try {
                new String(bArr, "utf-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        } else if (QLog.isColorLevel()) {
            QLog.e("PushDialogHandler", 2, "handleC2COnlinePushMsgGrayTipResp fail content is null");
        }
        if (j3 == 1001) {
            e(j3, j17, submsgtype0x122_msgbody);
            return;
        }
        PushDialogTemplate pushDialogTemplate = new PushDialogTemplate(submsgtype0x122_msgbody, msgInfo.lFromUin, msgInfo.getURealMsgTime() * 1000);
        if (pushDialogTemplate.isShowInGlobal()) {
            d(j3, pushDialogTemplate, bArr3);
        } else if (a.f261334a.a(String.valueOf(msgInfo.lFromUin))) {
            a().post(new Runnable(msgInfo, pushDialogTemplate) { // from class: com.tencent.mobileqq.pushdialog.PushDialogHandler.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ MsgInfo f261331d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ PushDialogTemplate f261332e;

                {
                    this.f261331d = msgInfo;
                    this.f261332e = pushDialogTemplate;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PushDialogHandler.this, msgInfo, pushDialogTemplate);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    a aVar = a.f261334a;
                    if (aVar.a(String.valueOf(this.f261331d.lFromUin))) {
                        aVar.c(String.valueOf(this.f261331d.lFromUin), this.f261332e, 102, 101);
                    }
                }
            });
        } else {
            this.f261329a = qQAppInterface.getEntityManagerFactory().createEntityManager();
            PushDialogDbUtil.c().d(this.f261329a, pushDialogTemplate);
        }
    }
}

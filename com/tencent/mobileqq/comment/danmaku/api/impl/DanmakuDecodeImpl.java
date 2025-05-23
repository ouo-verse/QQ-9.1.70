package com.tencent.mobileqq.comment.danmaku.api.impl;

import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.comment.danmaku.api.IDanmakuDecode;
import com.tencent.mobileqq.comment.e;
import com.tencent.mobileqq.comment.oidb.oidb_0xdea$Comment;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.o;
import com.tencent.mobileqq.troop.data.c;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.msg.im_msg_body$AnonymousGroupMsg;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DanmakuDecodeImpl implements IDanmakuDecode {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DanmakuDecodeImpl";

    public DanmakuDecodeImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.comment.danmaku.api.IDanmakuDecode
    public List<DanmuItemBean> decodeCommentList(List<oidb_0xdea$Comment> list, long j3, Paint paint, int i3) {
        QQAppInterface qQAppInterface;
        char c16;
        String str;
        List<im_msg_body$Elem> list2;
        long j16;
        long j17;
        long j18;
        long j19;
        o.a J1;
        boolean z16;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        char c17 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, this, list, Long.valueOf(j3), paint, Integer.valueOf(i3));
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) runtime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        o oVar = new o();
        for (oidb_0xdea$Comment oidb_0xdea_comment : list) {
            try {
                im_msg_body$MsgBody im_msg_body_msgbody = new im_msg_body$MsgBody();
                im_msg_body_msgbody.mergeFrom(oidb_0xdea_comment.bytes_comment_msg.get().toByteArray());
                im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
                im_msg_body_richtext.mergeFrom(im_msg_body_msgbody.rich_text.get().toByteArray());
                list2 = im_msg_body_richtext.elems.get();
                j16 = oidb_0xdea_comment.uint64_comment_uin.get();
                j17 = oidb_0xdea_comment.uint64_seq.get();
                j18 = oidb_0xdea_comment.uint32_comment_ctime.get();
                j19 = oidb_0xdea_comment.uint64_comment_location.get();
                c cVar = new c();
                cVar.f294891a = String.valueOf(j3);
                cVar.f294892b = 1;
                StringBuilder sb5 = new StringBuilder();
                str = TAG;
                try {
                    J1 = oVar.J1(list2, sb5, j17, cVar, j18);
                } catch (Exception e16) {
                    e = e16;
                    c16 = 4;
                }
            } catch (Exception e17) {
                e = e17;
                c16 = c17;
                str = TAG;
            }
            if (TextUtils.isEmpty(J1.f286322c)) {
                c17 = 4;
            } else {
                if (TextUtils.isEmpty(J1.f286320a.mAnonymousNickName) && J1.f286323d != null && !TextUtils.isEmpty(J1.f286322c) && J1.f286322c.length() > J1.f286323d.textLen + 1 && J1.f286322c.startsWith(J1.f286324e)) {
                    String substring = J1.f286322c.substring(J1.f286323d.textLen + 1);
                    if (!TextUtils.isEmpty(substring)) {
                        J1.f286322c = substring;
                    }
                }
                String stringUtf8 = oidb_0xdea_comment.bytes_nick.get().toStringUtf8();
                int i16 = oidb_0xdea_comment.uint32_source.get();
                if (TextUtils.isEmpty(stringUtf8)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(str, 2, "decodeCommentList, use local nickname, seq:", Long.valueOf(j17));
                    }
                    c16 = 4;
                } else {
                    c16 = 4;
                    if (i16 == 4) {
                        try {
                            Friends u16 = ((FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).u(String.valueOf(j16));
                            if (u16 != null && u16.isFriend() && !TextUtils.isEmpty(u16.remark)) {
                                stringUtf8 = u16.remark;
                                if (QLog.isColorLevel()) {
                                    QLog.d(str, 2, "decodeCommentList, use local remake, seq:", Long.valueOf(j17));
                                }
                            }
                        } catch (Exception e18) {
                            e = e18;
                            QLog.d(str, 1, "decodeCommentList, e:" + e);
                            c17 = c16;
                        }
                    }
                }
                try {
                    DanmuItemBean danmuItemBean = new DanmuItemBean(j16, j17, j18, j19, J1.f286322c, e.a(paint, stringUtf8, i3));
                    arrayList.add(danmuItemBean);
                    for (im_msg_body$Elem im_msg_body_elem : list2) {
                        if (im_msg_body_elem.anon_group_msg.has()) {
                            im_msg_body$AnonymousGroupMsg im_msg_body_anonymousgroupmsg = im_msg_body_elem.anon_group_msg.get();
                            byte[] byteArray = im_msg_body_anonymousgroupmsg.str_anon_nick.get().toByteArray();
                            if (im_msg_body_anonymousgroupmsg.uint32_flags.get() > 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            danmuItemBean.C = z16;
                            if (byteArray == null) {
                                str2 = "";
                            } else {
                                str2 = new String(byteArray);
                            }
                            danmuItemBean.D = str2;
                            danmuItemBean.E = im_msg_body_anonymousgroupmsg.uint32_head_portrait.get();
                            QLog.d(str, 1, "decodeCommentList, \u533f\u540d\u6d88\u606f,", danmuItemBean);
                        }
                    }
                } catch (Exception e19) {
                    e = e19;
                    QLog.d(str, 1, "decodeCommentList, e:" + e);
                    c17 = c16;
                }
                c17 = c16;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "decodeCommentList, " + arrayList.toString());
        }
        return arrayList;
    }
}

package com.tencent.mobileqq.dating;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import appoint.define.appoint_define$AppointID;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$NearByMessageType;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f203429a;

    /* renamed from: b, reason: collision with root package name */
    public static String f203430b;

    /* renamed from: c, reason: collision with root package name */
    public static Intent f203431c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71472);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f203429a = "";
        f203430b = "";
        f203431c = null;
    }

    public static boolean a(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface == null) {
            return true;
        }
        return qQAppInterface.getMessageFacade().getLastMessage(str, 1010).hasReply;
    }

    public static String b(appoint_define$AppointID appoint_define_appointid) {
        PBStringField pBStringField;
        if (appoint_define_appointid != null && (pBStringField = appoint_define_appointid.str_request_id) != null && pBStringField.has()) {
            return appoint_define_appointid.str_request_id.get();
        }
        return null;
    }

    public static im_msg_body$Elem c(MessageRecord messageRecord) {
        int i3;
        int i16 = messageRecord.istroop;
        if ((i16 == 1010 || i16 == 1001) && (((i3 = messageRecord.msgtype) == -1000 || i3 == -2000) && !TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr("nearby_clearing_msg")))) {
            im_msg_body$NearByMessageType im_msg_body_nearbymessagetype = new im_msg_body$NearByMessageType();
            int i17 = messageRecord.msgtype;
            if (i17 == -1000) {
                im_msg_body_nearbymessagetype.uint32_type.set(1);
            } else if (i17 == -2000) {
                im_msg_body_nearbymessagetype.uint32_type.set(2);
            }
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            im_msg_body_elem.near_by_msg.set(im_msg_body_nearbymessagetype);
            return im_msg_body_elem;
        }
        return null;
    }

    public static boolean d(QQAppInterface qQAppInterface, String str, int i3) {
        ConversationFacade conversationFacade;
        if (TextUtils.isEmpty(str) || (conversationFacade = qQAppInterface.getConversationFacade()) == null || conversationFacade.V(str, i3) <= 0) {
            return false;
        }
        return true;
    }

    public static boolean e(QQAppInterface qQAppInterface, String str, int i3) {
        ConversationFacade conversationFacade;
        if (TextUtils.isEmpty(str) || (conversationFacade = qQAppInterface.getConversationFacade()) == null || conversationFacade.W(str, i3) <= 0) {
            return false;
        }
        return true;
    }

    public static boolean f(Activity activity) {
        if (activity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
            return true;
        }
        return false;
    }

    public static String g(long j3, int i3, boolean z16) {
        int i16;
        SimpleDateFormat simpleDateFormat;
        String str;
        String str2;
        String str3;
        SimpleDateFormat simpleDateFormat2;
        String str4;
        String str5;
        Long valueOf = Long.valueOf(NetConnInfoCenter.getServerTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(valueOf.longValue());
        Long valueOf2 = Long.valueOf(j3 * 1000);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(valueOf2.longValue());
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(1970, 0, 1, 0, 0, 0);
        long time = calendar3.getTime().getTime() - 1000;
        long longValue = ((valueOf.longValue() - time) / 1000) / 86400;
        long longValue2 = ((valueOf2.longValue() - time) / 1000) / 86400;
        boolean z17 = false;
        if (longValue2 == longValue) {
            i16 = R.string.i3f;
        } else if (longValue2 == longValue + 1) {
            i16 = R.string.i3g;
        } else if (longValue2 == longValue + 2) {
            i16 = R.string.f170173i4;
        } else if (longValue2 == longValue - 1) {
            i16 = R.string.ihd;
        } else if (longValue2 == longValue - 2) {
            i16 = R.string.f170578ul;
        } else {
            if (calendar2.get(1) == calendar.get(1)) {
                z17 = true;
            }
            i16 = -1;
        }
        if (i3 == 5) {
            if (i16 != -1) {
                return BaseApplication.getContext().getResources().getString(i16);
            }
            if (!z17) {
                if (z16) {
                    str5 = "yyyy\u5e74M\u6708d\u65e5";
                } else {
                    str5 = TuxDateStringUtils.TUX_COMMON_DATE_FORMAT;
                }
                simpleDateFormat2 = new SimpleDateFormat(str5);
            } else {
                if (z16) {
                    str4 = "M\u6708d\u65e5";
                } else {
                    str4 = "MM-dd";
                }
                simpleDateFormat2 = new SimpleDateFormat(str4);
            }
            return simpleDateFormat2.format(calendar2.getTime());
        }
        if (i16 != -1) {
            BaseApplication context = BaseApplication.getContext();
            if (z16) {
                str3 = ",H\u70b9m\u5206";
            } else {
                str3 = " HH:mm";
            }
            return context.getResources().getString(i16) + new SimpleDateFormat(str3).format(calendar2.getTime());
        }
        if (!z17) {
            if (z16) {
                str2 = "yyyy\u5e74M\u6708d\u65e5,HH\u70b9mm\u5206";
            } else {
                str2 = TuxDateStringUtils.TUX_COMMON_MINUTES_FORMAT;
            }
            simpleDateFormat = new SimpleDateFormat(str2);
        } else {
            if (z16) {
                str = "M\u6708d\u65e5,H\u70b9m\u5206";
            } else {
                str = "MM-dd HH:mm";
            }
            simpleDateFormat = new SimpleDateFormat(str);
        }
        return simpleDateFormat.format(calendar2.getTime());
    }

    public static String h(long j3, boolean z16) {
        String str;
        long j16 = j3 * 1000;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        int i3 = (int) (serverTimeMillis / 86400000);
        int i16 = (int) (j16 / 86400000);
        long j17 = serverTimeMillis - j16;
        int i17 = ((int) j17) / 86400000;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j16);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(serverTimeMillis);
        String str2 = "yyyy\u5e74M\u6708d\u65e5 H\u70b9m\u5206";
        if (i17 < 0) {
            if (!z16) {
                str2 = TuxDateStringUtils.TUX_COMMON_MINUTES_FORMAT;
            }
            return new SimpleDateFormat(str2).format(calendar.getTime());
        }
        if (i17 == 0) {
            int i18 = (int) (j17 / 3600000);
            if (i18 <= 0) {
                return HardCodeUtil.qqStr(R.string.lam);
            }
            return String.format("%d\u5c0f\u65f6\u524d", Integer.valueOf(i18));
        }
        String str3 = "H\u70b9m\u5206";
        if (i3 == i16 + 1) {
            if (!z16) {
                str3 = DateUtil.DATE_FORMAT_HOUR;
            }
            return String.format(HardCodeUtil.qqStr(R.string.lan), new SimpleDateFormat(str3).format(calendar.getTime()));
        }
        if (i3 == i16 + 2) {
            if (!z16) {
                str3 = DateUtil.DATE_FORMAT_HOUR;
            }
            return String.format(HardCodeUtil.qqStr(R.string.lao), new SimpleDateFormat(str3).format(calendar.getTime()));
        }
        if (calendar.get(1) == calendar2.get(1)) {
            if (z16) {
                str = "M\u6708d\u65e5 H\u70b9m\u5206";
            } else {
                str = "MM-dd HH:mm";
            }
            return new SimpleDateFormat(str).format(calendar.getTime());
        }
        if (!z16) {
            str2 = TuxDateStringUtils.TUX_COMMON_MINUTES_FORMAT;
        }
        return new SimpleDateFormat(str2).format(calendar.getTime());
    }

    public static void i(String str, Object... objArr) {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(", [");
            for (Object obj : objArr) {
                sb5.append(obj);
                sb5.append(",");
            }
            sb5.append("]");
            QLog.i(LogTag.DATING, 2, sb5.toString());
        }
    }

    public static void j(String str, Object... objArr) {
    }
}

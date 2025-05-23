package com.tencent.mobileqq.freshnews;

import appoint.define.appoint_define$Elem;
import appoint.define.appoint_define$Face;
import appoint.define.appoint_define$RichText;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static String a(appoint_define$RichText appoint_define_richtext) {
        List<appoint_define$Elem> list;
        String str;
        appoint_define$Face appoint_define_face;
        int i3;
        if (appoint_define_richtext == null) {
            return "";
        }
        if (appoint_define_richtext.rpt_msg_elems.has()) {
            list = appoint_define_richtext.rpt_msg_elems.get();
        } else {
            list = null;
        }
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (appoint_define$Elem appoint_define_elem : list) {
            if (appoint_define_elem != null) {
                if (!appoint_define_elem.str_content.has()) {
                    str = "";
                } else {
                    str = appoint_define_elem.str_content.get();
                }
                sb5.append(str);
                if (appoint_define_elem.msg_face_info.has()) {
                    appoint_define_face = appoint_define_elem.msg_face_info.get();
                } else {
                    appoint_define_face = null;
                }
                if (appoint_define_face != null) {
                    if (appoint_define_face.uint32_index.has()) {
                        i3 = appoint_define_face.uint32_index.get();
                    } else {
                        i3 = -1;
                    }
                    if (i3 >= 0) {
                        sb5.append((char) 20);
                        sb5.append((char) QQSysFaceUtil.convertToLocal(i3));
                    }
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("FreshNewsUtil", 4, "getStringFromRichText, result=" + sb5.toString());
        }
        return sb5.toString();
    }
}

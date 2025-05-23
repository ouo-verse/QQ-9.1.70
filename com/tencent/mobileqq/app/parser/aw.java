package com.tencent.mobileqq.app.parser;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class aw {
    static IPatchRedirector $redirector_;

    public static av a(JumpParserResult jumpParserResult, ArrayList<JumpParserBean> arrayList) {
        Class cls;
        if (jumpParserResult != null && arrayList != null) {
            try {
                if (jumpParserResult.getUrl() != null) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < arrayList.size()) {
                            JumpParserBean jumpParserBean = arrayList.get(i3);
                            if (jumpParserResult.getUrl().startsWith(jumpParserBean.getParserKey())) {
                                cls = jumpParserBean.getParserClass();
                                break;
                            }
                            i3++;
                        } else {
                            cls = null;
                            break;
                        }
                    }
                    if (cls == null) {
                        return null;
                    }
                    Object newInstance = cls.newInstance();
                    if (newInstance instanceof av) {
                        return (av) newInstance;
                    }
                    QLog.e("JumpParserFactory", 1, "createJumpParser error: not extends JumpParserBase");
                    return null;
                }
            } catch (Exception e16) {
                QLog.e("JumpParserFactory", 1, "createJumpParser error: " + e16.getMessage());
                return null;
            }
        }
        QLog.e("JumpParserFactory", 1, "createJumpParser error: param is null");
        return null;
    }
}

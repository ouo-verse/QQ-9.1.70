package com.tencent.avbiz;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Set<a> f77364a;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void m(Intent intent);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38201);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f77364a = new CopyOnWriteArraySet();
        }
    }

    public static void a(a aVar) {
        if (aVar != null) {
            f77364a.add(aVar);
        }
    }

    public static void b(AVBusiness aVBusiness) {
        if (aVBusiness == null) {
            QLog.d("QFP-AVFocusNotifyUtils", 1, "[notifyCloseAVFocusAction] business should not be null.");
            return;
        }
        try {
            String name = aVBusiness.getName();
            long requestType = aVBusiness.getRequestType();
            String processName = aVBusiness.getProcessName();
            Intent intent = new Intent();
            intent.setAction("av_action_close_focus");
            intent.putExtra("av_msg_name", name);
            intent.putExtra("av_msg_type", requestType);
            intent.putExtra("av_msg_process_name", processName);
            if ("com.tencent.mobileqq".equals(AVBizUtils.getProcessName())) {
                c(intent);
            } else {
                BaseApplication.getContext().sendBroadcast(intent);
            }
            QLog.d("QFP-AVFocusNotifyUtils", 1, "[notifyCloseAVFocusAction] name: " + name + " | type: " + requestType + " | processName: " + processName);
        } catch (Throwable th5) {
            QLog.e("QFP-AVFocusNotifyUtils", 1, "[sendAVMsgGainFocus] error: ", th5);
        }
    }

    private static void c(Intent intent) {
        Set<a> set = f77364a;
        if (set.isEmpty()) {
            return;
        }
        Iterator<a> it = set.iterator();
        while (it.hasNext()) {
            it.next().m(intent);
        }
    }

    public static void d(AVBusiness aVBusiness) {
        if (aVBusiness == null) {
            QLog.d("QFP-AVFocusNotifyUtils", 1, "[notifyRequestAVFocusAction] business should not be null.");
            return;
        }
        try {
            String name = aVBusiness.getName();
            long requestType = aVBusiness.getRequestType();
            String processName = aVBusiness.getProcessName();
            Intent intent = new Intent();
            intent.setAction("av_action_request_focus");
            intent.putExtra("av_msg_name", name);
            intent.putExtra("av_msg_type", requestType);
            intent.putExtra("av_msg_process_name", processName);
            if ("com.tencent.mobileqq".equals(AVBizUtils.getProcessName())) {
                c(intent);
            } else {
                BaseApplication.getContext().sendBroadcast(intent);
            }
            QLog.d("QFP-AVFocusNotifyUtils", 1, "[notifyRequestAVFocusAction] name: " + name + " | type: " + requestType + " | processName: " + processName);
        } catch (Throwable th5) {
            QLog.e("QFP-AVFocusNotifyUtils", 1, "[sendAVMsgLossFocus] error: ", th5);
        }
    }
}

package com.tencent.mobileqq.imcore.proxy.msg;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static a f238041a;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        void a(Context context, BaseQQAppInterface baseQQAppInterface, Message message, int i3, MsgSummary msgSummary, boolean z16, boolean z17);
    }

    public static void a(Context context, BaseQQAppInterface baseQQAppInterface, Message message, int i3, MsgSummary msgSummary, boolean z16, boolean z17) {
        a aVar = f238041a;
        if (aVar != null) {
            aVar.a(context, baseQQAppInterface, message, i3, msgSummary, z16, z17);
        }
    }

    public static void b(a aVar) {
        f238041a = aVar;
    }
}

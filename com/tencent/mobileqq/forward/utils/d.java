package com.tencent.mobileqq.forward.utils;

import android.content.Intent;
import com.tencent.guild.api.share.IGuildForwardUtilsApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.nt.adapter.session.h;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUidInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/forward/utils/d;", "", "", "uinType", "", "uin", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "", "g", "e", "Landroid/content/Intent;", "intent", "d", "f", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f211078a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58158);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f211078a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void g(int uinType, final String uin, final MsgElement msgElement) {
        HashSet<Long> hashSetOf;
        ArrayList<MsgElement> arrayListOf;
        final int l3 = com.tencent.nt.adapter.session.c.l(uinType);
        if (h.f339139a.a(uinType)) {
            hashSetOf = SetsKt__SetsKt.hashSetOf(Long.valueOf(Long.parseLong(uin)));
            ag l16 = com.tencent.qqnt.msg.f.l();
            if (l16 != null) {
                l16.getUid(hashSetOf, new IKernelGetUidInfoCallback() { // from class: com.tencent.mobileqq.forward.utils.b
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUidInfoCallback
                    public final void onResult(HashMap hashMap) {
                        d.i(uin, l3, msgElement, hashMap);
                    }
                });
                return;
            }
            return;
        }
        Contact contact = new Contact(l3, uin, "");
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(msgElement);
            e16.F(0L, contact, arrayListOf, new IOperateCallback() { // from class: com.tencent.mobileqq.forward.utils.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    d.h(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(int i3, String str) {
        QLog.d("DatalineForwardUtils", 1, "forward result = " + i3 + ", err = " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String uin, int i3, MsgElement msgElement, HashMap hashMap) {
        ArrayList<MsgElement> arrayListOf;
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(msgElement, "$msgElement");
        String str = (String) hashMap.get(Long.valueOf(Long.parseLong(uin)));
        if (str != null) {
            Contact contact = new Contact(i3, str, "");
            w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(msgElement);
                e16.F(0L, contact, arrayListOf, new IOperateCallback() { // from class: com.tencent.mobileqq.forward.utils.c
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i16, String str2) {
                        d.j(i16, str2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(int i3, String str) {
        QLog.d("DatalineForwardUtils", 1, "forward result = " + i3 + ", err = " + str);
    }

    public final void d(@NotNull Intent intent, int uinType, @NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, intent, Integer.valueOf(uinType), uin);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(uin, "uin");
        String stringExtra = intent.getStringExtra(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE);
        if (stringExtra == null) {
            return;
        }
        g(uinType, uin, ((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createTextElement(stringExtra));
    }

    public final void e(int uinType, @NotNull String uin, @NotNull MsgElement msgElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(uinType), uin, msgElement);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        g(uinType, uin, msgElement);
    }

    public final void f(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        int intExtra = intent.getIntExtra("forward_type", Integer.MAX_VALUE);
        int i3 = 1;
        if (intExtra != -1) {
            if (intExtra != 1) {
                i3 = 3;
                if (intExtra != 3 && intExtra != 21) {
                    i3 = -1;
                }
            } else {
                i3 = 2;
            }
        }
        ((IGuildForwardUtilsApi) QRoute.api(IGuildForwardUtilsApi.class)).forwardToGuild(intent, i3);
    }
}

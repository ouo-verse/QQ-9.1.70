package com.tencent.mobileqq.groupvideo.net;

import android.text.TextUtils;
import com.tencent.mobileqq.groupvideo.api.GroupVideoRemoteResponse;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.GroupVideoCmdReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupVideoCmdRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGroupVideoCmdRequestRsp;
import com.tencent.util.UiThreadUtil;
import com.tencent.widget.ProcessUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J4\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R0\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/net/d;", "", "", "cmdType", "", "data", "Lcom/tencent/mobileqq/groupvideo/api/a;", "callback", "", "c", "ssoCmd", "", "ssoCmdStr", "serializationType", "f", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "oidbCMDMap", "<init>", "()V", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f213812a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, Integer> oidbCMDMap;

    static {
        HashMap<Integer, Integer> hashMapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24521);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f213812a = new d();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(4752, 4752), TuplesKt.to(4753, 4753), TuplesKt.to(4754, 4754));
        oidbCMDMap = hashMapOf;
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c(int cmdType, byte[] data, final com.tencent.mobileqq.groupvideo.api.a callback) {
        com.tencent.qqnt.kernel.api.e eVar;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            eVar = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getAVSDKService();
        } else {
            eVar = null;
        }
        if (eVar == null) {
            if (callback != null) {
                callback.b(new GroupVideoRemoteResponse(-1, "avsdkService or runtime is null!", null));
            }
        } else {
            QLog.d("GroupVideoOIDBHandler", 1, "startGroupVideoCmdRequestFromA cmdType " + cmdType);
            eVar.startGroupVideoCmdRequestFromAVSDK(new GroupVideoCmdReq(cmdType, data), new IGroupVideoCmdRequestRsp() { // from class: com.tencent.mobileqq.groupvideo.net.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupVideoCmdRequestRsp
                public final void onResult(int i3, String str, GroupVideoCmdRsp groupVideoCmdRsp) {
                    d.d(com.tencent.mobileqq.groupvideo.api.a.this, i3, str, groupVideoCmdRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final com.tencent.mobileqq.groupvideo.api.a aVar, final int i3, String str, GroupVideoCmdRsp groupVideoCmdRsp) {
        byte[] bArr;
        QLog.d("GroupVideoOIDBHandler", 1, "startGroupVideoCmdRequestFromAVSDK result " + i3 + ", errMsg: " + str);
        if (str == null) {
            str = "";
        }
        if (groupVideoCmdRsp != null) {
            bArr = groupVideoCmdRsp.pbBuf;
        } else {
            bArr = null;
        }
        final GroupVideoRemoteResponse groupVideoRemoteResponse = new GroupVideoRemoteResponse(i3, str, bArr);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.groupvideo.net.c
            @Override // java.lang.Runnable
            public final void run() {
                d.e(i3, aVar, groupVideoRemoteResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(int i3, com.tencent.mobileqq.groupvideo.api.a aVar, GroupVideoRemoteResponse remoteResponse) {
        Intrinsics.checkNotNullParameter(remoteResponse, "$remoteResponse");
        if (i3 == 0) {
            if (aVar != null) {
                aVar.a(remoteResponse);
            }
        } else if (aVar != null) {
            aVar.b(remoteResponse);
        }
    }

    public final void f(int ssoCmd, @Nullable String ssoCmdStr, @Nullable byte[] data, int serializationType, @Nullable com.tencent.mobileqq.groupvideo.api.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(ssoCmd), ssoCmdStr, data, Integer.valueOf(serializationType), callback);
            return;
        }
        if (ssoCmd != 0 && data != null) {
            if (!AppNetConnInfo.isNetSupport()) {
                QLog.i("GroupVideoOIDBHandler", 1, "#sendRequest: without network!! return null");
                GroupVideoRemoteResponse groupVideoRemoteResponse = new GroupVideoRemoteResponse(-1, "#sendRequest: without network!! return null", null);
                if (callback != null) {
                    callback.b(groupVideoRemoteResponse);
                    return;
                }
                return;
            }
            String currentProcessName = ProcessUtil.getCurrentProcessName(BaseApplication.context);
            QLog.i("GroupVideoOIDBHandler", 1, "#sendRequest: ssoCmd " + ssoCmd + " curProcessName " + currentProcessName);
            if (TextUtils.equals(currentProcessName, "com.tencent.mobileqq")) {
                Integer num = oidbCMDMap.get(Integer.valueOf(ssoCmd));
                if (num == null) {
                    num = 4752;
                }
                c(num.intValue(), data, callback);
                return;
            }
            return;
        }
        QLog.e("GroupVideoOIDBHandler", 1, "sendRequest error, params is invalid.");
        if (callback != null) {
            callback.b(new GroupVideoRemoteResponse(-1, "send request params invalid", null));
        }
    }
}

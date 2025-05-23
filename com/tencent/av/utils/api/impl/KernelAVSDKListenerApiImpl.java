package com.tencent.av.utils.api.impl;

import android.os.Bundle;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.qav_rtc_push_online$LoginPushMsg;
import com.tencent.av.qav_rtc_push_online$RoomInfo;
import com.tencent.av.r;
import com.tencent.av.utils.api.IKernelAVSDKListenerApi;
import com.tencent.av.utils.s;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes32.dex */
public class KernelAVSDKListenerApiImpl implements IKernelAVSDKListenerApi {
    private static String TAG = "KernelAVSDKListenerApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        int f77012a = 0;

        /* renamed from: b, reason: collision with root package name */
        long f77013b = 0;

        /* renamed from: c, reason: collision with root package name */
        int f77014c = 0;

        /* renamed from: d, reason: collision with root package name */
        long[] f77015d = null;

        /* renamed from: e, reason: collision with root package name */
        String[] f77016e = null;

        b() {
        }
    }

    private void onRecvMultiVideoS2C_0x95_forGroup_new(QQAppInterface qQAppInterface, b bVar) {
        s.g().j(qQAppInterface, String.valueOf(bVar.f77013b), new a(qQAppInterface, bVar));
    }

    @Override // com.tencent.av.utils.api.IKernelAVSDKListenerApi
    public IKernelAVSDKListener getKernelAVSDKListener() {
        return new iv.a();
    }

    @Override // com.tencent.av.utils.api.IKernelAVSDKListenerApi
    public void onRecvMultiVideoS2C_0x210_0x14c_loginPush(qav_rtc_push_online$LoginPushMsg qav_rtc_push_online_loginpushmsg) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null || !(runtime instanceof QQAppInterface)) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        if (!qav_rtc_push_online_loginpushmsg.rooms.has()) {
            QLog.e(TAG, 1, "onRecvMultiVideoS2C_0x210_0x14c_loginPush failed. no rooms field.");
            return;
        }
        List<qav_rtc_push_online$RoomInfo> list = qav_rtc_push_online_loginpushmsg.rooms.get();
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            b bVar = new b();
            if (list.get(i3).business_type.has()) {
                bVar.f77012a = list.get(i3).business_type.get();
            }
            if (list.get(i3).group_id.has()) {
                bVar.f77013b = list.get(i3).group_id.get();
            }
            if (list.get(i3).user_num.has()) {
                bVar.f77014c = list.get(i3).user_num.get();
            }
            if (list.get(i3).users.has() && list.get(i3).users.get().size() > 0) {
                int size = list.get(i3).users.get().size();
                bVar.f77015d = new long[size];
                bVar.f77016e = new String[size];
                for (int i16 = 0; i16 < size; i16++) {
                    bVar.f77015d[i16] = list.get(i3).users.get(i3).uin.get();
                    bVar.f77016e[i16] = list.get(i3).users.get(i3).uid.get();
                }
            }
            arrayList.add(bVar);
        }
        QLog.i(TAG, 1, "onRecvMultiVideoS2C_0x210_0x14c_loginPush. size: " + arrayList.size());
        if (arrayList.size() == 0) {
            return;
        }
        for (int i17 = 0; i17 < arrayList.size(); i17++) {
            b bVar2 = (b) arrayList.get(i17);
            QLog.i(TAG, 1, "onRecvMultiVideoS2C_0x210_0x14c_loginPush. i: " + i17 + ", roomInfo[businessType: " + bVar2.f77012a + ", groupId: " + bVar2.f77013b + ", userNum: " + bVar2.f77014c + ", uinList: " + Arrays.toString(bVar2.f77015d) + ", uidList: " + Arrays.toString(bVar2.f77016e) + "].");
            int i18 = bVar2.f77012a;
            if (i18 == 1) {
                onRecvMultiVideoS2C_0x95_forDiscuss_new(qQAppInterface, bVar2);
            } else if (i18 == 2) {
                onRecvMultiVideoS2C_0x95_forGroup_new(qQAppInterface, bVar2);
            } else if (i18 == 10) {
                onRecvMultiVideoS2C_0x95_forGroupNew_new(qQAppInterface, bVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements s.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f77009a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f77010b;

        a(QQAppInterface qQAppInterface, b bVar) {
            this.f77009a = qQAppInterface;
            this.f77010b = bVar;
        }

        @Override // com.tencent.av.utils.s.d
        public void a(int i3, s.f fVar, int i16) {
            if (i3 == 0) {
                this.f77009a.getAVNotifyCenter().I0(10, 1, this.f77010b.f77013b, null, r10.f77014c);
                AVNotifyCenter aVNotifyCenter = this.f77009a.getAVNotifyCenter();
                b bVar = this.f77010b;
                aVNotifyCenter.Z0(7, bVar.f77013b, 2, 0, 0, 21, bVar.f77014c);
                this.f77009a.getAVNotifyCenter().m0(21, 1, this.f77010b.f77013b, 0L);
            }
        }
    }

    private void onRecvMultiVideoS2C_0x95_forDiscuss_new(QQAppInterface qQAppInterface, b bVar) {
        qQAppInterface.getAVNotifyCenter().I0(9, 2, bVar.f77013b, bVar.f77015d, bVar.f77014c);
        qQAppInterface.getAVNotifyCenter().m0(21, 2, bVar.f77013b, 0L);
    }

    private void onRecvMultiVideoS2C_0x95_forGroupNew_new(QQAppInterface qQAppInterface, b bVar) {
        qQAppInterface.getAVNotifyCenter().I0(11, 1, bVar.f77013b, null, bVar.f77014c);
        qQAppInterface.getAVNotifyCenter().Z0(6, bVar.f77013b, 10, 0, 0, 21, bVar.f77014c);
        qQAppInterface.getAVNotifyCenter().m0(21, 1, bVar.f77014c, 0L);
    }

    @Override // com.tencent.av.utils.api.IKernelAVSDKListenerApi
    public void processMultiVideoOnlineMsg(Bundle bundle, String str, final boolean z16) {
        if (bundle == null || r.h0() == null) {
            return;
        }
        final int i3 = bundle.getInt("cmd_type");
        final byte[] byteArray = bundle.getByteArray("cmd_content");
        MqqHandler D = r.h0().D();
        if (D != null) {
            D.post(new Runnable() { // from class: com.tencent.av.utils.api.impl.KernelAVSDKListenerApiImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d(KernelAVSDKListenerApiImpl.TAG, 1, "processMultiVideoOnlineMsg async. cmd[" + i3 + "].");
                    if (r.h0() != null) {
                        r.h0().l0().receiveSSOMultiVideoMsg(i3, byteArray, z16);
                    }
                }
            });
            return;
        }
        QLog.d(TAG, 1, "processMultiVideoOnlineMsg sync. cmd[" + i3 + "].");
        r.h0().l0().receiveSSOMultiVideoMsg(i3, byteArray, z16);
    }

    @Override // com.tencent.av.utils.api.IKernelAVSDKListenerApi
    public void processSharpVideoOnlineMsg(final Bundle bundle, String str) {
        if (bundle == null || r.h0() == null) {
            return;
        }
        r.h0().h3(System.currentTimeMillis());
        final long j3 = bundle.getLong("onLineStatus");
        final boolean z16 = bundle.getBoolean("isRequest");
        MqqHandler D = r.h0().D();
        if (D != null) {
            D.post(new Runnable() { // from class: com.tencent.av.utils.api.impl.KernelAVSDKListenerApiImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d(KernelAVSDKListenerApiImpl.TAG, 1, "processSharpVideoOnlineMsg async. onLineStatus[" + j3 + "], isRequest[" + z16 + "].");
                    if (r.h0() != null) {
                        r.h0().l0().receiveSharpVideoMsg(bundle);
                    }
                }
            });
            return;
        }
        r.h0().l0().receiveSharpVideoMsg(bundle);
        QLog.d(TAG, 1, "processSharpVideoOnlineMsg sync. onLineStatus[" + j3 + "], isRequest[" + z16 + "].");
    }
}

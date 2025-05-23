package com.tencent.mobileqq.streamtransfile;

import QQService.StreamData;
import QQService.StreamInfo;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.cs.ptt_reserve.ptt_reserve$ReserveStruct;
import tencent.im.msg.im_msg_body$GeneralFlags;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static void A(String str, short s16) {
        c cVar;
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.containsKey(str) && (cVar = b16.get(str)) != null) {
            cVar.n(s16);
        }
    }

    public static void B(String str, long j3) {
        c cVar;
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.containsKey(str) && (cVar = b16.get(str)) != null) {
            cVar.f290264k = j3;
        }
    }

    public static void C(String str, long j3) {
        c cVar;
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.containsKey(str) && (cVar = b16.get(str)) != null) {
            cVar.f290263j = j3;
        }
    }

    public static void D(String str, long j3) {
        c cVar;
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.containsKey(str) && (cVar = b16.get(str)) != null) {
            cVar.l(j3);
        }
    }

    public static boolean a(String str, short s16) {
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.containsKey(str) && b16.get(str).h() == s16) {
            return false;
        }
        return true;
    }

    public static void b(String str) {
        c cVar;
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.containsKey(str) && (cVar = b16.get(str)) != null) {
            int size = cVar.g().size();
            cVar.k((short) size);
            if (size >= 1) {
                cVar.g().get(cVar.g().size() - 1).f(true);
            }
        }
    }

    public static void c(String str, QQAppInterface qQAppInterface, String str2, long j3, int i3, int i16, long j16, Bundle bundle) {
        d(str, qQAppInterface, str2, j3, false, i3, i16, j16, bundle);
    }

    public static void d(String str, QQAppInterface qQAppInterface, String str2, long j3, boolean z16, int i3, int i16, long j16, Bundle bundle) {
        c cVar;
        short s16;
        List<a> g16;
        HashMap<String, c> b16 = d.b();
        int pttRecordTime = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).getPttRecordTime(i3);
        if (b16 != null && b16.containsKey(str) && (cVar = b16.get(str)) != null) {
            cVar.f290262i = z16;
            if (cVar.a() == 0 && (g16 = cVar.g()) != null && g16.size() > 0) {
                short s17 = -1;
                for (a aVar : g16) {
                    if (aVar.d() == aVar.e().length && !aVar.b()) {
                        s17 = aVar.c();
                        aVar.g(true);
                    } else if (!aVar.b() && aVar.a()) {
                        s17 = aVar.c();
                        aVar.g(true);
                    }
                }
                s16 = s17;
            } else {
                s16 = -1;
            }
            if (s16 != -1 && j3 != 0) {
                z(qQAppInterface, str2, str, j3, s16, pttRecordTime, i16, j16, bundle);
            }
        }
    }

    public static boolean e(String str, byte[] bArr, int i3, short s16) {
        return f(str, bArr, i3, s16, false);
    }

    public static boolean f(String str, byte[] bArr, int i3, short s16, boolean z16) {
        a aVar;
        HashMap<String, c> b16 = d.b();
        int i16 = 0;
        if (b16 == null || !b16.containsKey(str)) {
            return false;
        }
        c cVar = b16.get(str);
        if (!z16) {
            try {
                cVar.o(bArr, i3);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("StreamDataManager", 2, "write fail", e16);
                }
            }
        }
        if (cVar.a() == 0) {
            List<a> g16 = cVar.g();
            if (g16.size() == 0) {
                a aVar2 = new a(cVar.f290265l);
                System.arraycopy(bArr, 0, aVar2.e(), 0, i3);
                aVar2.i(i3);
                short h16 = cVar.h();
                aVar2.h(h16);
                g16.add(aVar2);
                cVar.m((short) (h16 + 1));
            } else {
                a aVar3 = g16.get(g16.size() - 1);
                byte[] e17 = aVar3.e();
                if (aVar3.d() < e17.length) {
                    int length = e17.length - aVar3.d();
                    if (length >= i3) {
                        System.arraycopy(bArr, 0, aVar3.e(), aVar3.d(), i3);
                        aVar3.i(aVar3.d() + i3);
                    } else {
                        if (i3 <= length) {
                            System.arraycopy(bArr, 0, aVar3.e(), aVar3.d(), i3);
                            aVar3.i(aVar3.d() + i3);
                            return true;
                        }
                        System.arraycopy(bArr, 0, aVar3.e(), aVar3.d(), length);
                        aVar3.i(aVar3.e().length);
                        int i17 = i3 - length;
                        a aVar4 = new a(cVar.f290265l);
                        System.arraycopy(bArr, length, aVar4.e(), 0, i17);
                        aVar4.i(i17);
                        short h17 = cVar.h();
                        aVar4.h(h17);
                        g16.add(aVar4);
                        cVar.m((short) (h17 + 1));
                    }
                } else {
                    a aVar5 = new a(cVar.f290265l);
                    System.arraycopy(bArr, 0, aVar5.e(), 0, i3);
                    aVar5.i(i3);
                    short h18 = cVar.h();
                    aVar5.h(h18);
                    g16.add(aVar5);
                    cVar.m((short) (h18 + 1));
                }
            }
        } else if (cVar.a() == 1) {
            List<a> g17 = cVar.g();
            int length2 = bArr.length;
            while (length2 > 0) {
                if (g17.size() == 0) {
                    aVar = new a(cVar.f290265l);
                    g17.add(aVar);
                } else {
                    aVar = g17.get(g17.size() - 1);
                    if (aVar.e().length - aVar.d() <= 0) {
                        aVar = new a(cVar.f290265l);
                        g17.add(aVar);
                    }
                }
                int length3 = aVar.e().length - aVar.d();
                if (length3 >= length2) {
                    length3 = length2;
                }
                System.arraycopy(bArr, i16, aVar.e(), aVar.d(), length3);
                i16 += length3;
                length2 -= length3;
                aVar.i(aVar.d() + length3);
                aVar.h(s16);
            }
            cVar.m((short) (s16 + 1));
        }
        return true;
    }

    public static boolean g(String str) {
        List<String> a16 = d.a();
        if (a16 != null && !a16.contains(str)) {
            a16.add(str);
            return true;
        }
        return false;
    }

    public static boolean h(AppRuntime appRuntime, int i3, String str, int i16, int i17) {
        HashMap<String, c> b16 = d.b();
        if (b16 != null && !b16.containsKey(str)) {
            c cVar = new c(appRuntime, i3, str, i16);
            cVar.j(i17);
            synchronized (b16) {
                b16.put(str, cVar);
            }
            return true;
        }
        return false;
    }

    public static void i(String str) {
        c cVar;
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.containsKey(str) && (cVar = b16.get(str)) != null) {
            cVar.b();
        }
    }

    public static void j(String str, boolean z16) {
        c cVar;
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.containsKey(str) && (cVar = b16.get(str)) != null) {
            cVar.c(z16);
        }
    }

    public static boolean k(String str) {
        List<String> a16 = d.a();
        if (a16 != null && a16.contains(str)) {
            return true;
        }
        return false;
    }

    public static File l(String str) {
        c cVar;
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.containsKey(str) && (cVar = b16.get(str)) != null) {
            return cVar.e();
        }
        return null;
    }

    public static short m(String str) {
        c cVar;
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.containsKey(str) && (cVar = b16.get(str)) != null) {
            return cVar.i();
        }
        return (short) -1;
    }

    public static String n(int i3, int i16) {
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.size() > 0) {
            for (String str : b16.keySet()) {
                c cVar = b16.get(str);
                if (cVar.d() == i3 && cVar.a() == i16) {
                    return str;
                }
            }
        }
        return null;
    }

    public static short o(String str) {
        c cVar;
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.containsKey(str) && (cVar = b16.get(str)) != null) {
            return cVar.f();
        }
        return (short) 0;
    }

    public static boolean p(String str) {
        c cVar;
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.containsKey(str) && (cVar = b16.get(str)) != null) {
            return cVar.f290262i;
        }
        return false;
    }

    public static int q(String str) {
        c cVar;
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.containsKey(str) && (cVar = b16.get(str)) != null) {
            int size = cVar.g().size();
            if (size >= 1) {
                int i3 = size - 1;
                if (!cVar.g().get(i3).b()) {
                    return i3;
                }
                return size;
            }
            return size;
        }
        return 0;
    }

    public static int r(String str, short s16) {
        c cVar;
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.containsKey(str) && (cVar = b16.get(str)) != null) {
            if (s16 <= cVar.g().size()) {
                return cVar.g().get(s16 - 1).d();
            }
            QLog.w("StreamDataManager", 2, "getRecordedSize error shPackSeq: " + ((int) s16) + "sfi.getStreamData().size(): " + cVar.g().size());
        }
        return 0;
    }

    public static int s(String str) {
        c cVar;
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.containsKey(str) && (cVar = b16.get(str)) != null) {
            return cVar.g().size();
        }
        return 0;
    }

    public static int t(String str) {
        c cVar;
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.containsKey(str) && (cVar = b16.get(str)) != null) {
            return cVar.d();
        }
        return -1;
    }

    public static short u(String str) {
        c cVar;
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.containsKey(str) && (cVar = b16.get(str)) != null) {
            return cVar.h();
        }
        return (short) 0;
    }

    public static byte[] v(String str, short s16) {
        c cVar;
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.containsKey(str) && (cVar = b16.get(str)) != null) {
            a aVar = cVar.g().get(s16 - 1);
            byte[] e16 = aVar.e();
            int d16 = aVar.d();
            if (d16 != e16.length) {
                byte[] bArr = new byte[d16];
                System.arraycopy(e16, 0, bArr, 0, d16);
                return bArr;
            }
            return e16;
        }
        return null;
    }

    public static void w(QQAppInterface qQAppInterface, StreamInfo streamInfo, StreamData streamData, long j3, long j16, long j17, long j18, ptt_reserve$ReserveStruct ptt_reserve_reservestruct) {
        String n3 = n(streamInfo.iMsgId, 1);
        String valueOf = String.valueOf(streamInfo.lFromUIN);
        String valueOf2 = String.valueOf(streamInfo.lToUIN);
        if (n3 == null) {
            String transferFilePath = TransFileUtil.getTransferFilePath(valueOf2, null, 2, null);
            int O = Utils.O(streamInfo.pttFormat);
            n3 = MessageForPtt.getLocalFilePath(O, transferFilePath);
            h(qQAppInterface, O, n3, 1, streamInfo.iMsgId);
            C(n3, (short) streamInfo.msgSeq);
            B(n3, streamInfo.random);
            if (QLog.isColorLevel()) {
                QLog.d("StreamDataManager", 2, "onReceiveStreamAction  key is:" + n3 + ",msgSeq is:" + streamInfo.msgSeq + ",random is:" + streamInfo.random);
            }
        }
        String str = n3;
        Bundle bundle = new Bundle();
        im_msg_body$GeneralFlags im_msg_body_generalflags = new im_msg_body$GeneralFlags();
        try {
            im_msg_body_generalflags.mergeFrom(ptt_reserve_reservestruct.bytes_general_flags.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("StreamDataManager", 1, "pb merge failed.", e16);
        }
        bundle.putInt("DiyTextId", im_msg_body_generalflags.uint32_bubble_diy_text_id.get());
        bundle.putInt("DiyPendantId", (int) j18);
        x(qQAppInterface, valueOf, str, -1000L, streamInfo, streamData, j3, j16, j17, bundle);
    }

    private static boolean x(QQAppInterface qQAppInterface, String str, String str2, long j3, StreamInfo streamInfo, StreamData streamData, long j16, long j17, long j18, Bundle bundle) {
        if (qQAppInterface == null) {
            return false;
        }
        ITransFileController iTransFileController = (ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class);
        if (!iTransFileController.containsProcessor(str + str2, j3)) {
            BuddyTransfileProcessor buddyTransfileProcessor = new BuddyTransfileProcessor(str, str2, false, null, null, 2, -1, false, (TransFileControllerImpl) iTransFileController, j3);
            buddyTransfileProcessor.setId(j3);
            buddyTransfileProcessor.getFileMsg().filePath = str2;
            String str3 = str + str2 + j3;
            buddyTransfileProcessor.setKey(str3);
            iTransFileController.addProcessor(str3, buddyTransfileProcessor);
            buddyTransfileProcessor.startReceiveOneStreamPack(streamInfo, streamData, j16, j17, j18, bundle);
            return true;
        }
        BuddyTransfileProcessor buddyTransfileProcessor2 = (BuddyTransfileProcessor) iTransFileController.findProcessor(str + str2 + j3);
        if (buddyTransfileProcessor2 != null) {
            buddyTransfileProcessor2.startReceiveOneStreamPack(streamInfo, streamData, j16, j17, j18, bundle);
        }
        return false;
    }

    public static boolean y(String str) {
        List<String> a16 = d.a();
        if (a16 != null && a16.contains(str)) {
            a16.remove(str);
            return true;
        }
        return false;
    }

    public static boolean z(QQAppInterface qQAppInterface, String str, String str2, long j3, short s16, int i3, int i16, long j16, Bundle bundle) {
        if (qQAppInterface == null) {
            return false;
        }
        ITransFileController iTransFileController = (ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class);
        if (!iTransFileController.containsProcessor(str, j3)) {
            BuddyTransfileProcessor buddyTransfileProcessor = new BuddyTransfileProcessor(str, str2, true, null, null, 2, -1, false, (TransFileControllerImpl) iTransFileController, j3);
            buddyTransfileProcessor.setId(j3);
            buddyTransfileProcessor.createStreamThreadPool();
            buddyTransfileProcessor.setKey(str + j3);
            iTransFileController.addProcessor(str + j3, buddyTransfileProcessor);
            buddyTransfileProcessor.startSendOneStreamPack(s16, false, i3, i16, j16, bundle);
            return true;
        }
        BuddyTransfileProcessor buddyTransfileProcessor2 = (BuddyTransfileProcessor) iTransFileController.findProcessor(str, j3);
        if (buddyTransfileProcessor2 != null) {
            buddyTransfileProcessor2.startSendOneStreamPack(s16, false, i3, i16, j16, bundle);
        }
        return false;
    }
}

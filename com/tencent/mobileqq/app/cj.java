package com.tencent.mobileqq.app;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.qav_rtc_push_online$LoginPushMsg;
import com.tencent.av.service.k;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.av.utils.api.IKernelAVSDKListenerApi;
import com.tencent.av.utils.s;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.api.IGroupVideoWrapper;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.NewIntent;
import msf.msgcomm.nt_msg_common$Msg;
import tencent.im.s2c.msgtype0x210.submsgtype0xcf.submsgtype0xcf$MsgBody;
import trpc.qq_av.av_appsvr.GroupInvite$GroupInviteMsgBody;
import trpc.qq_av.av_appsvr.PushOnline$PushOnlineMsg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class cj implements Handler.Callback {
    static IPatchRedirector $redirector_;
    static ArrayList<h> C;
    static ArrayList<String> D;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f195421d;

    /* renamed from: e, reason: collision with root package name */
    AVNotifyCenter f195422e;

    /* renamed from: f, reason: collision with root package name */
    byte[] f195423f;

    /* renamed from: h, reason: collision with root package name */
    boolean f195424h;

    /* renamed from: i, reason: collision with root package name */
    Vector<byte[]> f195425i;

    /* renamed from: m, reason: collision with root package name */
    Handler f195426m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements k.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f195427a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f195428b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ byte[] f195429c;

        a(int i3, long j3, byte[] bArr) {
            this.f195427a = i3;
            this.f195428b = j3;
            this.f195429c = bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, cj.this, Integer.valueOf(i3), Long.valueOf(j3), bArr);
            }
        }

        @Override // com.tencent.av.service.k.a
        public void a(com.tencent.av.service.k kVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) kVar);
            } else {
                kVar.e(this.f195427a, this.f195428b, this.f195429c);
                kVar.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements s.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f195431a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f195432b;

        b(long j3, int i3) {
            this.f195431a = j3;
            this.f195432b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, cj.this, Long.valueOf(j3), Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.av.utils.s.d
        public void a(int i3, s.f fVar, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), fVar, Integer.valueOf(i16));
            } else if (i3 == 0) {
                cj.this.f195422e.I0(10, 1, this.f195431a, null, this.f195432b);
                cj.this.f195422e.Z0(7, this.f195431a, 2, 0, 0, 21, this.f195432b);
                cj.this.f195422e.m0(21, 1, this.f195431a, 0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c implements IGroupVideoWrapper.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cj.this);
            }
        }

        @Override // cooperation.groupvideo.api.IGroupVideoWrapper.a
        public void a(IGroupVideoWrapper iGroupVideoWrapper) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) iGroupVideoWrapper);
            } else {
                iGroupVideoWrapper.processS2C(cj.this.f195423f);
                iGroupVideoWrapper.uninitialize();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class d implements k.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cj.this);
            }
        }

        @Override // com.tencent.av.service.k.a
        public void a(com.tencent.av.service.k kVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) kVar);
            } else {
                kVar.d(cj.this.f195423f);
                kVar.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class e implements s.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f195436a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f195437b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f195438c;

        /* compiled from: P */
        /* loaded from: classes11.dex */
        class a implements IGroupVideoWrapper.a {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
                }
            }

            @Override // cooperation.groupvideo.api.IGroupVideoWrapper.a
            public void a(IGroupVideoWrapper iGroupVideoWrapper) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) iGroupVideoWrapper);
                } else {
                    iGroupVideoWrapper.processS2C(cj.this.f195423f);
                    iGroupVideoWrapper.uninitialize();
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes11.dex */
        class b implements k.a {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
                }
            }

            @Override // com.tencent.av.service.k.a
            public void a(com.tencent.av.service.k kVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) kVar);
                } else {
                    kVar.d(cj.this.f195423f);
                    kVar.h();
                }
            }
        }

        e(long j3, int i3, long j16) {
            this.f195436a = j3;
            this.f195437b = i3;
            this.f195438c = j16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, cj.this, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16));
            }
        }

        @Override // com.tencent.av.utils.s.d
        public void a(int i3, s.f fVar, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), fVar, Integer.valueOf(i16));
                return;
            }
            if (i3 == 0) {
                AVNotifyCenter aVNotifyCenter = cj.this.f195422e;
                if (aVNotifyCenter != null) {
                    aVNotifyCenter.Z0(3, this.f195436a, this.f195437b, 0, 0, 20, 1);
                    cj.this.f195422e.X0(this.f195436a, true);
                    cj.this.f195422e.m0(21, 1, Long.valueOf(this.f195436a).longValue(), 0L);
                }
                VideoMsgTools.m(cj.this.f195421d, 1, 13, false, Long.toString(this.f195436a), Long.toString(this.f195438c), false, null, false, this.f195437b, new Object[0]);
                if (this.f195437b == 2) {
                    new cooperation.groupvideo.b(cj.this.f195421d).a(new a());
                } else {
                    new com.tencent.av.service.k(BaseApplication.getContext()).b(new b());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class f implements IGroupVideoWrapper.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f195442a;

        f(byte[] bArr) {
            this.f195442a = bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cj.this, (Object) bArr);
            }
        }

        @Override // cooperation.groupvideo.api.IGroupVideoWrapper.a
        public void a(IGroupVideoWrapper iGroupVideoWrapper) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) iGroupVideoWrapper);
            } else {
                iGroupVideoWrapper.processS2C(this.f195442a);
                iGroupVideoWrapper.uninitialize();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class g implements k.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f195444a;

        g(byte[] bArr) {
            this.f195444a = bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cj.this, (Object) bArr);
            }
        }

        @Override // com.tencent.av.service.k.a
        public void a(com.tencent.av.service.k kVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) kVar);
            } else {
                kVar.d(this.f195444a);
                kVar.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class h {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f195446a;

        /* renamed from: b, reason: collision with root package name */
        public long f195447b;

        /* renamed from: c, reason: collision with root package name */
        public nt_msg_common$Msg f195448c;

        /* renamed from: d, reason: collision with root package name */
        public AtomicBoolean f195449d;

        public h(nt_msg_common$Msg nt_msg_common_msg, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, nt_msg_common_msg, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            this.f195449d = null;
            this.f195448c = nt_msg_common_msg;
            this.f195446a = j3;
            this.f195447b = j16;
            this.f195449d = new AtomicBoolean(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class i implements Comparator<h> {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(h hVar, h hVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) hVar, (Object) hVar2)).intValue();
            }
            long j3 = hVar.f195447b;
            long j16 = hVar2.f195447b;
            if (j3 < j16) {
                return -1;
            }
            if (j3 > j16) {
                return 1;
            }
            return 0;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(Friends.TERM_TYPE_WIN8);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
            return;
        }
        C = null;
        try {
            C = new ArrayList<>();
            if (QLog.isColorLevel()) {
                QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg create successful!");
            }
        } catch (Exception unused) {
        }
        D = null;
        try {
            D = new ArrayList<>();
            if (QLog.isColorLevel()) {
                QLog.d("QQGAudioMsgHandler", 2, "sCacheMsgList create successful!");
            }
        } catch (Exception unused2) {
        }
    }

    public cj(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f195421d = null;
        this.f195423f = new byte[170];
        this.f195424h = false;
        this.f195425i = new Vector<>();
        this.f195421d = qQAppInterface;
        this.f195426m = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        this.f195422e = this.f195421d.getAVNotifyCenter();
    }

    private void B(ByteBuffer byteBuffer, int i3) {
        long j3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            short s16 = byteBuffer.getShort();
            long[] jArr = null;
            for (int i18 = 0; i18 < s16; i18++) {
                short s17 = byteBuffer.getShort();
                int i19 = byteBuffer.getShort();
                switch (s17) {
                    case 1:
                        j3 = byteBuffer.getInt();
                        break;
                    case 2:
                        i16 = byteBuffer.getInt();
                        break;
                    case 3:
                        byteBuffer.getInt();
                        break;
                    case 4:
                        int i26 = i19 / 8;
                        long[] jArr2 = new long[i26];
                        for (int i27 = 0; i27 < i26; i27++) {
                            jArr2[i27] = byteBuffer.getLong();
                        }
                        jArr = jArr2;
                        break;
                    case 5:
                        byteBuffer.getInt();
                        break;
                    case 6:
                        byteBuffer.getInt();
                        break;
                    default:
                        byteBuffer.get(new byte[i19], 0, i19);
                        break;
                }
            }
            long j16 = j3;
            this.f195422e.I0(9, 2, j16, jArr, i16);
            this.f195422e.m0(21, 2, j16, 0L);
        }
    }

    private void C(ByteBuffer byteBuffer, int i3) {
        long j3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            short s16 = byteBuffer.getShort();
            for (int i18 = 0; i18 < s16; i18++) {
                short s17 = byteBuffer.getShort();
                int i19 = byteBuffer.getShort();
                switch (s17) {
                    case 1:
                        j3 = com.tencent.av.s.e(byteBuffer.getInt());
                        break;
                    case 2:
                        i16 = byteBuffer.getInt();
                        break;
                    case 3:
                        byteBuffer.getInt();
                        break;
                    case 4:
                        int i26 = i19 / 8;
                        long[] jArr = new long[i26];
                        for (int i27 = 0; i27 < i26; i27++) {
                            jArr[i27] = byteBuffer.getLong();
                        }
                        break;
                    case 5:
                        byteBuffer.getInt();
                        break;
                    case 6:
                        byteBuffer.getInt();
                        break;
                    default:
                        byteBuffer.get(new byte[i19], 0, i19);
                        break;
                }
            }
            com.tencent.av.utils.s.g().j(this.f195421d, String.valueOf(j3), new b(j3, i16));
        }
    }

    private void D(ByteBuffer byteBuffer, int i3) {
        Object valueOf;
        String sb5;
        long j3 = 0;
        int i16 = i3;
        int i17 = 0;
        int i18 = 0;
        while (i17 < i16) {
            short s16 = byteBuffer.getShort();
            byte[] bArr = null;
            int i19 = -1;
            int i26 = -1;
            int i27 = -1;
            long[] jArr = null;
            for (int i28 = 0; i28 < s16; i28++) {
                short s17 = byteBuffer.getShort();
                int i29 = byteBuffer.getShort();
                switch (s17) {
                    case 1:
                        j3 = com.tencent.av.s.e(byteBuffer.getInt());
                        break;
                    case 2:
                        i18 = byteBuffer.getInt();
                        break;
                    case 3:
                        i19 = byteBuffer.getInt();
                        break;
                    case 4:
                        int i36 = i29 / 8;
                        jArr = new long[i36];
                        for (int i37 = 0; i37 < i36; i37++) {
                            jArr[i37] = byteBuffer.getLong();
                        }
                        break;
                    case 5:
                        i26 = byteBuffer.getInt();
                        break;
                    case 6:
                        i27 = byteBuffer.getInt();
                        break;
                    case 7:
                        bArr = new byte[i29];
                        byteBuffer.get(bArr, 0, i29);
                        break;
                    default:
                        byteBuffer.get(new byte[i29], 0, i29);
                        break;
                }
            }
            if (QQAudioHelper.j()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("onRecvMultiVideoS2C_0x95, index[");
                sb6.append(i17);
                sb6.append("], GroupId[");
                sb6.append(j3);
                sb6.append("], roomUserNum[");
                sb6.append(i18);
                sb6.append("], busitype[");
                sb6.append(i19);
                sb6.append("], shortnum[");
                sb6.append(i26);
                sb6.append("], createtime[");
                sb6.append(i27);
                sb6.append("], ppt[");
                Object obj = "null";
                if (bArr == null) {
                    sb5 = "null";
                } else {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(bArr.length);
                    sb7.append("|");
                    if (bArr.length == 0) {
                        valueOf = "";
                    } else {
                        valueOf = Byte.valueOf(bArr[0]);
                    }
                    sb7.append(valueOf);
                    sb5 = sb7.toString();
                }
                sb6.append(sb5);
                sb6.append("], uinList[");
                if (jArr != null) {
                    obj = Integer.valueOf(jArr.length);
                }
                sb6.append(obj);
                sb6.append("]");
                QLog.w("QQGAudioMsgHandler", 1, sb6.toString());
            }
            this.f195422e.I0(11, 1, j3, null, i18);
            this.f195422e.Z0(6, j3, 10, 0, 0, 21, i18);
            this.f195422e.m0(21, 1, j3, 0L);
            i17++;
            i16 = i3;
        }
    }

    private void F(byte[] bArr) {
        byte[] bArr2 = new byte[1];
        int i3 = 0;
        System.arraycopy(bArr, 11, bArr2, 0, 1);
        if (QLog.isColorLevel()) {
            QLog.w("QQGAudioMsgHandler", 1, "onRecvRoomDestroy, cAuthType[" + ((int) bArr2[0]) + "]");
        }
        if (bArr2[0] != 3) {
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        long n3 = this.f195422e.n();
        int o16 = this.f195422e.o();
        if (n3 > 0) {
            i3 = this.f195422e.l(n3);
        }
        if (o16 == 1 && i3 == 2) {
            new cooperation.groupvideo.b(this.f195421d).a(new f(bArr));
        } else {
            new com.tencent.av.service.k(context).b(new g(bArr));
        }
    }

    private void K(int i3, byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        long a16 = com.tencent.av.utils.w.a();
        if (!new com.tencent.av.service.k(BaseApplication.getContext()).b(new a(i3, a16, bArr2))) {
            com.tencent.av.utils.w.b(this.f195421d, i3, a16, bArr2);
        }
    }

    private boolean d(byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.i("QQGAudioMsgHandler", 2, "receive handleMultiCommonPushOnline buffer: " + Arrays.toString(bArr));
        }
        try {
            PushOnline$PushOnlineMsg pushOnline$PushOnlineMsg = new PushOnline$PushOnlineMsg();
            pushOnline$PushOnlineMsg.mergeFrom(bArr);
            if (QLog.isColorLevel()) {
                QLog.i("QQGAudioMsgHandler", 2, "handleMultiCommonPushOnline video_msg_type.has() : " + pushOnline$PushOnlineMsg.video_msg_type.has() + " video_msg_type:" + pushOnline$PushOnlineMsg.video_msg_type.get());
            }
            if (pushOnline$PushOnlineMsg.video_msg_type.get() >= 32) {
                QLog.e("QQGAudioMsgHandler", 1, "handleMultiCommonPushOnline should not handle by qav");
                return false;
            }
            int i3 = pushOnline$PushOnlineMsg.push_type.get();
            if (QLog.isColorLevel()) {
                QLog.i("QQGAudioMsgHandler", 2, "handleMultiCommonPushOnline pushType: " + i3);
            }
            if (i3 == 0) {
                return false;
            }
            if (i3 != 1 && i3 != 2) {
                QLog.e("QQGAudioMsgHandler", 1, "pushType " + i3 + " not adapted");
            }
            return true;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QQGAudioMsgHandler", 1, "handleMultiCommonPushOnline parse pb failed" + Log.getStackTraceString(new Throwable(e16)));
            return false;
        }
    }

    private void e(long j3, long j16) {
        if (QLog.isColorLevel()) {
            QLog.d("QQGAudioMsgHandler", 2, "handleMultiInviteForDiscuss discussId is" + j16 + "InviteUin:" + j3);
        }
        ((DiscussionHandler) this.f195421d.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).J2(j16);
        AVNotifyCenter aVNotifyCenter = this.f195422e;
        if (aVNotifyCenter != null) {
            aVNotifyCenter.I0(7, 2, j16, new long[]{j3}, 1L);
        }
        String l3 = Long.toString(j16);
        String l16 = Long.toString(j3);
        ((com.tencent.mobileqq.qcall.f) this.f195421d.getManager(QQManagerFactory.RECENT_CALL_FACADE)).c(0, j16, l16, "");
        if (!this.f195421d.getAVNotifyCenter().e0()) {
            VideoMsgTools.l(this.f195421d, 3000, 13, false, l3, l16, false, null, true, new Object[0]);
        }
    }

    private void f(long j3, long j16, int i3) {
        if (QLog.isColorLevel()) {
            QLog.w("QQGAudioMsgHandler", 1, "handleMultiInviteForGroup, groupUin[" + j16 + "], InviteUin[" + j3 + "]");
        }
        AVNotifyCenter aVNotifyCenter = this.f195422e;
        if (aVNotifyCenter != null) {
            long[] jArr = {j3};
            if (aVNotifyCenter.y(1, j16) == 0) {
                this.f195422e.Z0(5, j16, 10, 0, 0, 20, 1);
                this.f195422e.I0(8, 1, j16, jArr, 1L);
                this.f195422e.m0(21, 1, Long.valueOf(j16).longValue(), 0L);
            }
        }
        VideoMsgTools.m(this.f195421d, 1, 13, false, Long.toString(j16), Long.toString(j3), false, null, false, i3, new Object[0]);
    }

    private boolean g(byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.i("QQGAudioMsgHandler", 2, "handleMultiInvitePush buffer" + Arrays.toString(bArr));
        }
        try {
            GroupInvite$GroupInviteMsgBody groupInvite$GroupInviteMsgBody = new GroupInvite$GroupInviteMsgBody();
            groupInvite$GroupInviteMsgBody.mergeFrom(bArr);
            if (QLog.isColorLevel()) {
                QLog.i("QQGAudioMsgHandler", 2, "handleMultiInvitePush video_msg_type.has() : " + groupInvite$GroupInviteMsgBody.video_msg_type.has() + " video_msg_type:" + groupInvite$GroupInviteMsgBody.video_msg_type.get());
            }
            if (groupInvite$GroupInviteMsgBody.video_msg_type.get() >= 32) {
                QLog.e("QQGAudioMsgHandler", 1, "handleMultiInvitePush should not handle by qav");
                return false;
            }
            int i3 = groupInvite$GroupInviteMsgBody.flag.get();
            int i16 = groupInvite$GroupInviteMsgBody.relation_type.get();
            long j3 = groupInvite$GroupInviteMsgBody.from_uin.get();
            if (QLog.isColorLevel()) {
                QLog.i("QQGAudioMsgHandler", 2, "handleMultiInvitePush avType: " + i3 + " relationType: " + i16 + "inviteUin: " + j3);
            }
            if (i16 == 2) {
                e(j3, groupInvite$GroupInviteMsgBody.relation_id.get());
            } else if (i16 == 1 && i3 == 10) {
                f(j3, groupInvite$GroupInviteMsgBody.relation_id.get(), i3);
            }
            if (i16 == 1 && i3 == 2) {
                return false;
            }
            return true;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QQGAudioMsgHandler", 1, "handleMultiInvitePush parse pb failed" + Log.getStackTraceString(new Throwable(e16)));
            return false;
        }
    }

    private void l(int i3, long j3) {
        int length;
        if (i3 != 0) {
            ArrayList<h> arrayList = C;
            if (arrayList != null && !arrayList.isEmpty()) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->msgList size=" + C.size());
                }
                for (int i16 = 0; i16 < C.size(); i16++) {
                    h hVar = C.get(i16);
                    if (hVar != null && hVar.f195446a == j3 && hVar.f195449d.compareAndSet(false, true)) {
                        long j16 = hVar.f195448c.routing_head.from_uin.get();
                        if (QLog.isColorLevel()) {
                            QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode-> fromUin: " + j16 + "friendUin: " + j3);
                        }
                        VideoMsgTools.l(this.f195421d, 0, 6, true, Long.toString(j3), Long.toString(j16), false, null, false, hVar.f195448c);
                    }
                }
                return;
            }
            return;
        }
        ArrayList<h> arrayList2 = C;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->msgList size=" + C.size());
            }
            ArrayList arrayList3 = new ArrayList();
            for (int i17 = 0; i17 < C.size(); i17++) {
                h hVar2 = C.get(i17);
                if (hVar2 != null && hVar2.f195446a == j3 && hVar2.f195449d.compareAndSet(false, true)) {
                    arrayList3.add(hVar2);
                }
            }
            Collections.sort(arrayList3, new i());
            for (int i18 = 0; i18 < arrayList3.size() - 1; i18++) {
                h hVar3 = (h) arrayList3.get(i18);
                long j17 = hVar3.f195448c.routing_head.from_uin.get();
                if (QLog.isColorLevel()) {
                    QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->list =" + ((h) arrayList3.get(i18)).f195447b + " inviteUin = " + j17);
                }
                VideoMsgTools.l(this.f195421d, 0, 6, true, Long.toString(j3), Long.toString(j17), false, null, false, hVar3.f195448c);
            }
            if (arrayList3.size() > 0) {
                byte[] byteArray = ((h) arrayList3.get(arrayList3.size() - 1)).f195448c.body.get().msg_content.get().toByteArray();
                byte[] bArr = this.f195423f;
                if (bArr == null || (length = byteArray.length) < 40) {
                    return;
                }
                if (bArr.length < length) {
                    this.f195423f = new byte[length];
                }
                System.arraycopy(byteArray, 0, this.f195423f, 0, length);
                u(this.f195423f);
            }
        }
    }

    public void A(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bArr);
            return;
        }
        AVCoreLog.printAllUserLog("QQGAudioMsgHandler", "onRecvMultiVideoS2C_0x95.");
        if (!h()) {
            return;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.getShort();
        wrap.getLong();
        short s16 = wrap.getShort();
        if (s16 > 0) {
            B(wrap, s16);
        }
        short s17 = wrap.getShort();
        if (s17 > 0) {
            C(wrap, s17);
        }
        short s18 = wrap.getShort();
        if (s18 > 0) {
            D(wrap, s18);
        }
        this.f195424h = true;
        Vector<byte[]> vector = this.f195425i;
        if (vector != null) {
            int size = vector.size();
            if (size > 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    b(this.f195425i.elementAt(i3));
                }
            }
            this.f195425i.clear();
        }
    }

    public void E(int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bArr);
            return;
        }
        if (i3 != 768) {
            if (i3 != 769) {
                QLog.e("QQGAudioMsgHandler", 1, "cmd " + i3 + " not adapted");
                return;
            }
            if (com.tencent.av.utils.ax.d()) {
                if (d(bArr)) {
                    K(i3, bArr);
                    return;
                }
                return;
            }
            K(i3, bArr);
            return;
        }
        if (com.tencent.av.utils.ax.d()) {
            if (g(bArr)) {
                K(i3, bArr);
                return;
            }
            return;
        }
        K(i3, bArr);
    }

    public void G(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) bArr);
            return;
        }
        Intent intent = new Intent("tencent.video.q2v.VisitorSendGift");
        intent.putExtra("data", bArr);
        this.f195421d.getApp().sendBroadcast(intent);
    }

    void H(long j3, int i3, byte b16) {
        if (this.f195421d == null) {
            return;
        }
        AVCoreLog.printAllUserLog("QQGAudioMsgHandler", String.format("queryRoomMemberNum| discussId=%d, dataType= %d, wReserve=%s", Long.valueOf(j3), Integer.valueOf(i3), Byte.valueOf(b16)));
        byte[] bArr = new byte[33];
        bArr[0] = (byte) 0;
        bArr[1] = (byte) 48;
        long longValue = Long.valueOf(this.f195421d.getCurrentAccountUin()).longValue();
        for (int i16 = 0; i16 < 8; i16++) {
            bArr[i16 + 2] = (byte) (255 & (longValue >> ((7 - i16) * 8)));
        }
        bArr[10] = 0;
        bArr[11] = 0;
        bArr[12] = 0;
        bArr[13] = 0;
        bArr[14] = 0;
        bArr[15] = (byte) i3;
        bArr[16] = 4;
        for (int i17 = 0; i17 < 4; i17++) {
            bArr[i17 + 17] = (byte) ((j3 >> ((3 - i17) * 8)) & 255);
        }
        for (int i18 = 0; i18 < 8; i18++) {
            bArr[i18 + 21] = (byte) ((531 >> ((7 - i18) * 8)) & 255);
        }
        bArr[29] = 0;
        bArr[30] = 0;
        bArr[31] = 0;
        bArr[32] = b16;
        NewIntent newIntent = new NewIntent(this.f195421d.getApplication(), com.tencent.mobileqq.servlet.r.class);
        newIntent.putExtra("ver", (byte) 0);
        newIntent.putExtra("type", (byte) 1);
        newIntent.putExtra("cscmd", (short) 462);
        newIntent.putExtra("selfuin", longValue);
        newIntent.putExtra("toUin", j3);
        newIntent.putExtra("vMsg", bArr);
        newIntent.putExtra("reqType", 8);
        this.f195421d.startServlet(newIntent);
    }

    void I(byte[] bArr, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("QQGAudioMsgHandler", 2, String.format("sendRoomInfoBroadcast, type[%s]", Integer.valueOf(i3)));
        }
        Intent intent = new Intent("tencent.video.q2v.MultiVideo");
        String currentAccountUin = this.f195421d.getCurrentAccountUin();
        intent.putExtra("type", i3);
        intent.putExtra("uin", currentAccountUin);
        intent.putExtra("buffer", bArr);
        this.f195421d.getApp().sendBroadcast(intent);
    }

    void J(int i3, byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.d("QQGAudioMsgHandler", 2, "showDevNotSurportMsg-->MsgType" + i3);
        }
        if (i3 == 141) {
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, (bArr[10] & 255) + 34, bArr2, 0, 4);
            VideoMsgTools.l(this.f195421d, 3000, 18, false, String.valueOf(com.tencent.av.s.c(bArr2, 4)), this.f195421d.getCurrentAccountUin(), false, null, false, new Object[0]);
            return;
        }
        if (i3 == 7) {
            int i16 = (bArr[10] & 255) + 19;
            byte[] bArr3 = new byte[8];
            System.arraycopy(bArr, i16, bArr3, 0, 8);
            com.tencent.av.s.b(bArr3, 8);
            byte[] bArr4 = new byte[4];
            System.arraycopy(bArr, i16 + 12, bArr4, 0, 4);
            VideoMsgTools.l(this.f195421d, 1, 18, false, String.valueOf(com.tencent.av.s.c(bArr4, 4)), this.f195421d.getCurrentAccountUin(), false, null, false, new Object[0]);
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        this.f195424h = false;
        Vector<byte[]> vector = this.f195425i;
        if (vector != null) {
            vector.clear();
        }
        ArrayList<h> arrayList = C;
        if (arrayList != null && !arrayList.isEmpty()) {
            C.clear();
            if (QLog.isColorLevel()) {
                QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is clear in clearOnLineQueue");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is empty!");
        }
    }

    void b(byte[] bArr) {
        if (this.f195422e != null && this.f195421d != null) {
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, (bArr[10] & 255) + 34, bArr2, 0, 4);
            long c16 = com.tencent.av.s.c(bArr2, 4);
            QLog.d("QQGAudioMsgHandler", 1, "dealGAudioOfflineMsg discussId is:" + c16);
            if (this.f195422e.y(2, c16) > 0) {
                ((DiscussionHandler) this.f195421d.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).J2(c16);
                String currentAccountUin = this.f195421d.getCurrentAccountUin();
                Intent intent = new Intent("tencent.video.q2v.RecvMultiVideoCall");
                intent.putExtra("uin", currentAccountUin);
                intent.putExtra("buffer", bArr);
                this.f195421d.getApp().sendBroadcast(intent);
                QLog.d("QQGAudioMsgHandler", 1, "dealGAudioOfflineMsg sendBroadcast discussId is:" + c16);
            }
        }
    }

    public void c(nt_msg_common$Msg nt_msg_common_msg, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, nt_msg_common_msg, str, Long.valueOf(j3));
            return;
        }
        ArrayList<h> arrayList = C;
        if (arrayList != null && this.f195426m != null) {
            arrayList.add(new h(nt_msg_common_msg, Long.valueOf(str).longValue(), j3));
            H(Long.valueOf(str).longValue(), 4, (byte) 8);
            this.f195426m.sendEmptyMessageDelayed(1, 10000L);
        }
    }

    boolean h() {
        if (!AVCoreSystemInfo.isSupportSharpAudio()) {
            if (QLog.isColorLevel()) {
                QLog.d("QQGAudioMsgHandler", 2, "device not surpport Sharp audio");
                return false;
            }
            return false;
        }
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ArrayList<h> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) message)).booleanValue();
        }
        if (message != null && (arrayList = C) != null) {
            try {
                if (message.what == 1) {
                    if (arrayList.isEmpty()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is empty!");
                        }
                        return true;
                    }
                    C.clear();
                    if (QLog.isColorLevel()) {
                        QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is clear after 10 seconds");
                    }
                }
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQGAudioMsgHandler", 2, "handleMessage sDoubleMeetingMsg error!");
                }
            }
        }
        return true;
    }

    void i(long j3, int i3) {
        AVNotifyCenter aVNotifyCenter = this.f195422e;
        if (aVNotifyCenter != null && this.f195421d != null) {
            if (aVNotifyCenter.y(1, j3) > 0) {
                this.f195422e.I0(3, 1, j3, null, 0L);
                VideoMsgTools.m(this.f195421d, 1, 14, false, String.valueOf(j3), this.f195421d.getCurrentAccountUin(), false, null, false, i3, new Object[0]);
                this.f195422e.m0(21, 1, j3, 0L);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.w("QQGAudioMsgHandler", 2, "MultiRoomMemberNum is 0");
                }
                this.f195422e.m0(23, 1, j3, 0L);
            }
            if (i3 == 2) {
                this.f195422e.X0(j3, false);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("QQGAudioMsgHandler", 2, "onGroupChatRoomDestroy-->can not get mNotifycenter or mapp");
        }
    }

    void j(long j3) {
        AVNotifyCenter aVNotifyCenter = this.f195422e;
        if (aVNotifyCenter != null && this.f195421d != null) {
            long y16 = aVNotifyCenter.y(2, j3);
            QLog.w("QQGAudioMsgHandler", 1, "onMultiRoomDestroy, discussId[" + j3 + "], roomMemberNum[" + y16 + "]");
            if (y16 > 0) {
                this.f195422e.I0(4, 2, j3, null, 0L);
                String valueOf = String.valueOf(j3);
                String currentAccountUin = this.f195421d.getCurrentAccountUin();
                this.f195422e.m0(21, 2, j3, 0L);
                ((DiscussionHandler) this.f195421d.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).S2(j3);
                VideoMsgTools.l(this.f195421d, 3000, 14, false, valueOf, currentAccountUin, false, null, false, new Object[0]);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x0074. Please report as an issue. */
    public void k(byte[] bArr, int i3) {
        char c16;
        int i16;
        int i17;
        byte b16;
        String currentAccountUin;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) bArr, i3);
            return;
        }
        QQAppInterface qQAppInterface = this.f195421d;
        if (qQAppInterface != null && (currentAccountUin = qQAppInterface.getCurrentAccountUin()) != null) {
            Long.valueOf(currentAccountUin).longValue();
        }
        byte[] bArr2 = new byte[2];
        System.arraycopy(bArr, 8, bArr2, 0, 2);
        char c17 = 1;
        int i18 = ((bArr2[0] & 255) << 8) | ((bArr2[1] & 255) << 0);
        if (QLog.isColorLevel()) {
            QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->tlvNum=" + i18);
        }
        byte[] bArr3 = new byte[4];
        byte[] bArr4 = new byte[8];
        int i19 = 10;
        int i26 = 0;
        while (i26 < i18) {
            System.arraycopy(bArr, i19, bArr2, 0, 2);
            i19 += 2;
            switch (((bArr2[c17] & 255) << 0) | ((bArr2[0] & 255) << 8)) {
                case 1:
                    int i27 = i19 + 2;
                    c16 = 4;
                    System.arraycopy(bArr, i27, bArr3, 0, 4);
                    i19 = i27 + 4;
                    com.tencent.av.s.b(bArr3, 4);
                    break;
                case 2:
                case 5:
                case 6:
                case 7:
                case 9:
                    i19 += 6;
                    c16 = 4;
                    break;
                case 3:
                    System.arraycopy(bArr, i19, bArr2, 0, 2);
                    i16 = i19 + 2;
                    i17 = (bArr2[0] & 255) << 8;
                    b16 = bArr2[1];
                    i19 = i16 + (i17 | ((b16 & 255) << 0));
                    c16 = 4;
                    break;
                case 4:
                    i19 += 10;
                    c16 = 4;
                    break;
                case 8:
                    System.arraycopy(bArr, i19, bArr2, 0, 2);
                    i16 = i19 + 2;
                    i17 = (bArr2[0] & 255) << 8;
                    b16 = bArr2[1];
                    i19 = i16 + (i17 | ((b16 & 255) << 0));
                    c16 = 4;
                    break;
                case 10:
                    System.arraycopy(bArr, i19, bArr2, 0, 2);
                    i19 += 2;
                    int i28 = (((bArr2[0] & 255) << 8) | ((bArr2[c17] & 255) << 0)) / 8;
                    long[] jArr = new long[i28];
                    if (QLog.isColorLevel()) {
                        QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->userNum=" + i28);
                    }
                    for (int i29 = 0; i29 < i28; i29++) {
                        System.arraycopy(bArr, i19, bArr4, 0, 8);
                        i19 += 8;
                        com.tencent.av.s.b(bArr4, 8);
                    }
                    c16 = 4;
                    break;
                default:
                    c16 = 4;
                    break;
            }
            i26++;
            c17 = 1;
        }
        System.arraycopy(bArr, i19, bArr2, 0, 2);
        int i36 = ((bArr2[1] & 255) << 0) | ((bArr2[0] & 255) << 8);
        if (QLog.isColorLevel()) {
            QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->wReverseLen=" + i36);
        }
        byte[] bArr5 = new byte[i36];
        System.arraycopy(bArr, i19 + 2, bArr5, 0, i36);
        long b17 = com.tencent.av.s.b(bArr5, i36);
        if (QLog.isColorLevel()) {
            QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->uin=" + b17);
        }
        l(i3, b17);
    }

    public void m(submsgtype0xcf$MsgBody submsgtype0xcf_msgbody) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) submsgtype0xcf_msgbody);
            return;
        }
        Intent putExtra = new Intent("tencent.video.q2v.random1V1OnlinePush").putExtra("rsptype", submsgtype0xcf_msgbody.uint32_rsptype.get());
        if (TextUtils.isEmpty(submsgtype0xcf_msgbody.string_rspbody.get())) {
            str = "";
        } else {
            str = submsgtype0xcf_msgbody.string_rspbody.get();
        }
        this.f195421d.getApp().sendBroadcast(putExtra.putExtra("rspbody", str));
    }

    public void n(byte[] bArr) {
        long[] jArr;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bArr);
            return;
        }
        AVCoreLog.printAllUserLog("QQGAudioMsgHandler", "onRecvAppTipMsgData.");
        if (!h()) {
            return;
        }
        int i16 = 2;
        byte[] bArr2 = new byte[2];
        byte[] bArr3 = new byte[4];
        byte[] bArr4 = new byte[8];
        int i17 = 0;
        System.arraycopy(bArr, 0, bArr2, 0, 2);
        int i18 = ((bArr2[0] & 255) << 8) | ((bArr2[1] & 255) << 0);
        if (i18 < 4) {
            return;
        }
        long[] jArr2 = null;
        int i19 = 2;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        long j3 = 0;
        while (true) {
            long[] jArr3 = jArr2;
            if (i27 < i18) {
                System.arraycopy(bArr, i19, bArr2, i17, i16);
                i19 += 2;
                int i29 = (bArr2[i17] & 255) << 8;
                int i36 = i18;
                int i37 = 0;
                int i38 = ((bArr2[1] & 255) << 0) | i29;
                if (i38 != 1) {
                    if (i38 != 2) {
                        if (i38 != 3) {
                            if (i38 != 4) {
                                i3 = 0;
                            } else {
                                System.arraycopy(bArr, i19, bArr2, 0, 2);
                                i19 += 2;
                                int i39 = ((bArr2[0] & 255) << 8) | ((bArr2[1] & 255) << 0);
                                if (i39 <= 0) {
                                    return;
                                }
                                int i46 = i39 / 8;
                                long[] jArr4 = new long[i46];
                                int i47 = 0;
                                while (i47 < i46) {
                                    System.arraycopy(bArr, i19, bArr4, i37, 8);
                                    i19 += 8;
                                    jArr4[i47] = com.tencent.av.s.b(bArr4, 8);
                                    i47++;
                                    i37 = 0;
                                }
                                i28 = i46;
                                jArr2 = jArr4;
                                i3 = i37;
                                i27++;
                                i17 = i3;
                                i18 = i36;
                                i16 = 2;
                            }
                        } else {
                            i19 += 6;
                        }
                    } else {
                        int i48 = i19 + 2;
                        System.arraycopy(bArr, i48, bArr3, 0, 4);
                        i19 = i48 + 4;
                        i26 = com.tencent.av.s.a(bArr3, 4);
                        long j16 = j3;
                        if (i26 == 0) {
                            j(j16);
                            Intent intent = new Intent();
                            intent.setAction("tencent.video.q2v.membersChange");
                            intent.putExtra("relationType", 2);
                            intent.putExtra("relationId", j16);
                            intent.putExtra("Exit", true);
                            this.f195421d.getApp().sendBroadcast(intent);
                            return;
                        }
                    }
                    jArr2 = jArr3;
                    i3 = 0;
                    i27++;
                    i17 = i3;
                    i18 = i36;
                    i16 = 2;
                } else {
                    int i49 = i19 + 2;
                    i3 = 0;
                    System.arraycopy(bArr, i49, bArr3, 0, 4);
                    i19 = i49 + 4;
                    j3 = com.tencent.av.s.b(bArr3, 4);
                }
                jArr2 = jArr3;
                i27++;
                i17 = i3;
                i18 = i36;
                i16 = 2;
            } else {
                int i56 = i16;
                int i57 = i17;
                long j17 = j3;
                System.arraycopy(bArr, i19, bArr2, i57, i56);
                int i58 = ((bArr2[i57] & 255) << 8) | ((bArr2[1] & 255) << i57);
                if (QLog.isColorLevel()) {
                    QLog.d("QQGAudioMsgHandler", 2, "TLV-NUMBER = " + i58);
                }
                int i59 = i19 + 2;
                int i65 = i28;
                int[] iArr = new int[i65];
                o(bArr, i59, iArr, i65, i58, bArr2);
                QLog.w("QQGAudioMsgHandler", 1, "onRecvAppTipMsgData, roomUserNum[" + i26 + "], qqUserLen[" + i65 + "]");
                if (this.f195422e == null) {
                    return;
                }
                long longValue = Long.valueOf(this.f195421d.getCurrentAccountUin()).longValue();
                if (i26 == 1 && jArr3 != null) {
                    jArr = jArr3;
                    if (jArr.length >= 1 && longValue == jArr[0] && this.f195422e.n() == 0) {
                        if (this.f195422e.y(2, j17) == 0) {
                            H(j17, 1, (byte) 1);
                            return;
                        }
                        return;
                    }
                } else {
                    jArr = jArr3;
                }
                this.f195422e.K0(2, j17, jArr, iArr, i26);
                this.f195422e.m0(21, 2, j17, 0L);
                Intent intent2 = new Intent();
                intent2.setAction("tencent.video.q2v.membersChange");
                intent2.putExtra("relationType", 2);
                intent2.putExtra("relationId", j17);
                intent2.putExtra("Exit", false);
                this.f195421d.getApp().sendBroadcast(intent2);
                return;
            }
        }
    }

    public int o(byte[] bArr, int i3, int[] iArr, int i16, int i17, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, bArr, Integer.valueOf(i3), iArr, Integer.valueOf(i16), Integer.valueOf(i17), bArr2)).intValue();
        }
        int[] iArr2 = new int[i16];
        for (int i18 = 0; i18 < i17; i18++) {
            System.arraycopy(bArr, i3, bArr2, 0, 2);
            int i19 = i3 + 2;
            int i26 = ((bArr2[0] & 255) << 8) | ((bArr2[1] & 255) << 0);
            System.arraycopy(bArr, i19, bArr2, 0, 2);
            i3 = i19 + 2;
            int i27 = ((bArr2[0] & 255) << 8) | ((bArr2[1] & 255) << 0);
            if (i26 != 8) {
                if (i26 == 9) {
                    if (i27 == i16) {
                        System.arraycopy(bArr, i3, bArr2, 0, i27);
                        for (int i28 = 0; i28 < i27; i28++) {
                            iArr2[i28] = bArr2[i28];
                        }
                    }
                }
                i3 += i27;
            } else if (i27 == i16) {
                System.arraycopy(bArr, i3, bArr2, 0, i27);
                for (int i29 = 0; i29 < i27; i29++) {
                    iArr[i29] = bArr2[i29];
                }
                i3 += i27;
            }
        }
        return i3;
    }

    public void p(long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), Boolean.valueOf(z16));
        } else if (this.f195421d != null) {
            Intent intent = new Intent("tencent.video.q2v.ChangeVisitorSpeakMode");
            intent.putExtra("groupId", j3);
            intent.putExtra("visitorSpeakEnabled", z16);
            this.f195421d.getApp().sendBroadcast(intent);
        }
    }

    void q(byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.d("QQGAudioMsgHandler", 2, "onRecvGroupVideoInvite");
        }
        int i3 = (bArr[10] & 255) + 19;
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, i3, bArr2, 0, 8);
        long b16 = com.tencent.av.s.b(bArr2, 8);
        int i16 = i3 + 8;
        byte[] bArr3 = new byte[4];
        System.arraycopy(bArr, i16, bArr3, 0, 4);
        int a16 = com.tencent.av.s.a(bArr3, 4);
        byte[] bArr4 = new byte[4];
        System.arraycopy(bArr, i16 + 4, bArr4, 0, 4);
        long b17 = com.tencent.av.s.b(bArr4, 4);
        com.tencent.av.utils.s.g().j(this.f195421d, String.valueOf(b17), new e(b17, a16, b16));
    }

    public void r(int i3, String str, int i16, long[] jArr, int i17, int i18, int i19, int i26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), str, Integer.valueOf(i16), jArr, Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
        } else {
            if (i17 != 14 && i17 != 2 && com.tencent.av.utils.af.H()) {
                return;
            }
            s(i3, str, i16, jArr, i17, i18, i19, i26);
        }
    }

    public void s(int i3, String str, int i16, long[] jArr, int i17, int i18, int i19, int i26) {
        long j3;
        int i27;
        int i28;
        long j16;
        int i29;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), str, Integer.valueOf(i16), jArr, Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
            return;
        }
        QLog.w("QQGAudioMsgHandler", 1, "onRecvGroupVideoMemberNumber, relationType[" + i3 + "], relationId[" + str + "], memberNum[" + i16 + "], avtype[" + i17 + "], gameId[" + i19 + "], liveExtraMode[" + i26 + "],memberList[" + Arrays.toString(jArr) + "]");
        try {
            j3 = Long.parseLong(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("QQGAudioMsgHandler", 1, "onRecvGroupVideoMemberNumber", e16);
            j3 = 0;
        }
        if (j3 == 0) {
            return;
        }
        this.f195421d.getAVNotifyCenter().N0(str, i17);
        if (i17 == 14) {
            i27 = 2;
        } else {
            i27 = i17;
        }
        if (i16 <= 0) {
            i28 = 23;
        } else {
            i28 = 21;
        }
        int i36 = i28;
        AVNotifyCenter.i p16 = this.f195421d.getAVNotifyCenter().p(j3);
        if (p16 != null && (i29 = p16.f73809c) > 0 && i16 == 0) {
            this.f195422e.I0(5, 1, j3, null, i29);
        }
        this.f195421d.getAVNotifyCenter().H0(j3, i27, i16);
        int i37 = i27;
        long j17 = j3;
        this.f195421d.getAVNotifyCenter().a1(4, j3, i37, i18, i19, i26, i36, i16);
        if (i16 == 0) {
            j16 = j17;
            i(j16, i37);
            this.f195422e.m0(21, 1, j16, 0L);
        } else {
            j16 = j17;
            this.f195422e.I0(6, 1, j16, jArr, i16);
            this.f195422e.B0(10, j16, i37);
            if (i37 == 2 && i3 == 1 && ((com.tencent.mobileqq.troop.utils.bh) this.f195421d.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER)).a(str) == 1) {
                this.f195421d.getAVNotifyCenter().X0(j16, true);
            }
            this.f195422e.m0(21, 1, j16, 0L);
        }
        if (this.f195421d.getAVNotifyCenter().A(str) == 14) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("tencent.video.q2v.membersChange");
        intent.putExtra("relationType", 1);
        intent.putExtra("avtype", i37);
        intent.putExtra("relationId", j16);
        if (i16 == 0) {
            intent.putExtra("Exit", true);
        } else {
            intent.putExtra("Exit", false);
        }
        this.f195421d.getApp().sendBroadcast(intent);
    }

    public void t(long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), Boolean.valueOf(z16));
        } else if (this.f195421d != null) {
            Intent intent = new Intent("tencent.video.q2v.KickOutVisitor");
            intent.putExtra("groupId", j3);
            intent.putExtra("isAllVisitor", z16);
            this.f195421d.getApp().sendBroadcast(intent);
        }
    }

    void u(byte[] bArr) {
        int i3 = (bArr[10] & 255) + 19;
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, i3, bArr2, 0, 8);
        long b16 = com.tencent.av.s.b(bArr2, 8);
        int i16 = i3 + 8;
        byte[] bArr3 = new byte[4];
        System.arraycopy(bArr, i16, bArr3, 0, 4);
        int a16 = com.tencent.av.s.a(bArr3, 4);
        int i17 = i16 + 4;
        byte[] bArr4 = new byte[2];
        System.arraycopy(bArr, i17, bArr4, 0, 2);
        int i18 = ((bArr4[0] & 255) << 8) | ((bArr4[1] & 255) << 0);
        if (i18 != 3 && i18 != 2 && i18 == 2 && a16 != 10) {
            if (QLog.isColorLevel()) {
                QLog.d("QQGAudioMsgHandler", 2, "Current version is only surpport discussion and friend. RelationType=" + i18);
                return;
            }
            return;
        }
        if (i18 == 2) {
            byte[] bArr5 = new byte[4];
            System.arraycopy(bArr, i17 + 3, bArr5, 0, 4);
            e(b16, com.tencent.av.s.c(bArr5, 4));
        } else if (i18 == 1 && a16 == 10) {
            byte[] bArr6 = new byte[4];
            System.arraycopy(bArr, i17 + 3, bArr6, 0, 4);
            f(b16, com.tencent.av.s.c(bArr6, 4), a16);
        }
        if (i18 == 1 && a16 == 2) {
            new cooperation.groupvideo.b(this.f195421d).a(new c());
        } else {
            new com.tencent.av.service.k(BaseApplication.getContext()).b(new d());
        }
    }

    public void v(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
            return;
        }
        byte[] bArr2 = new byte[2];
        System.arraycopy(bArr, 0, bArr2, 0, 2);
        if ((((bArr2[0] & 255) << 8) | ((bArr2[1] & 255) << 0)) == 49) {
            w(bArr);
        }
        if (this.f195421d != null) {
            Intent intent = new Intent("tencent.video.q2v.MultiVideo");
            this.f195421d.getCurrentAccountUin();
            intent.putExtra("type", 30);
            intent.putExtra("buffer", bArr);
            this.f195421d.getApp().sendBroadcast(intent);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x00ec. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w(byte[] bArr) {
        String str;
        long j3;
        int a16;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        char c16;
        String str2;
        long j16;
        int i26;
        int i27;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        int i28;
        int i29;
        int i36;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bArr);
            return;
        }
        AVCoreLog.printAllUserLog("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31.");
        if (this.f195422e == null) {
            return;
        }
        QQAppInterface qQAppInterface = this.f195421d;
        if (qQAppInterface != null) {
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            if (currentAccountUin != null) {
                str = currentAccountUin;
                j3 = Long.valueOf(currentAccountUin).longValue();
                int i37 = 2;
                byte[] bArr5 = new byte[2];
                byte[] bArr6 = new byte[4];
                int i38 = 0;
                System.arraycopy(bArr, 2, bArr6, 0, 4);
                a16 = com.tencent.av.s.a(bArr6, 4);
                char c17 = 1;
                if (a16 == 0) {
                    byte[] bArr7 = new byte[2];
                    System.arraycopy(bArr, bArr.length - 2, bArr7, 0, 2);
                    AVCoreLog.printAllUserLog("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31| retCode wR0=" + ((int) bArr7[0]) + " wR1=" + ((int) bArr7[1]));
                    if (bArr7[0] == 3) {
                        k(bArr, a16);
                        return;
                    } else {
                        AVCoreLog.printErrorLog("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31|wrong retCode.");
                        return;
                    }
                }
                byte[] bArr8 = new byte[2];
                System.arraycopy(bArr, bArr.length - 2, bArr8, 0, 2);
                AVCoreLog.printAllUserLog("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31| relation type wR0=" + ((int) bArr8[0]) + " wR1=" + ((int) bArr8[1]));
                byte b16 = bArr8[0];
                if (b16 == 1) {
                    i3 = 1;
                } else {
                    if (b16 != 2) {
                        if (b16 == 3) {
                            k(bArr, a16);
                            return;
                        }
                        AVCoreLog.printErrorLog("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31|wrong relation type.");
                    }
                    i3 = 2;
                }
                int i39 = 8;
                System.arraycopy(bArr, 8, bArr5, 0, 2);
                int i46 = ((bArr5[0] & 255) << 8) | ((bArr5[1] & 255) << 0);
                int i47 = 10;
                int i48 = 0;
                long[] jArr = null;
                long j17 = 0;
                while (i48 < i46) {
                    System.arraycopy(bArr, i47, bArr5, i38, i37);
                    i47 += i37;
                    switch (((bArr5[c17] & 255) << i38) | ((bArr5[i38] & 255) << i39)) {
                        case 1:
                            i16 = i48;
                            i17 = i46;
                            i18 = i3;
                            i19 = i38;
                            c16 = c17;
                            str2 = str;
                            j16 = j3;
                            i26 = 2;
                            i27 = 8;
                            bArr2 = bArr5;
                            int i49 = i47 + 2;
                            bArr3 = bArr6;
                            System.arraycopy(bArr, i49, bArr3, i19, 4);
                            i47 = i49 + 4;
                            j17 = com.tencent.av.s.b(bArr3, 4);
                            break;
                        case 2:
                        case 5:
                        case 6:
                        case 7:
                        case 9:
                            i16 = i48;
                            i17 = i46;
                            i18 = i3;
                            i19 = i38;
                            c16 = c17;
                            bArr4 = bArr6;
                            str2 = str;
                            j16 = j3;
                            i26 = 2;
                            i27 = 8;
                            bArr2 = bArr5;
                            i47 += 6;
                            bArr3 = bArr4;
                            break;
                        case 3:
                            i16 = i48;
                            i17 = i46;
                            i18 = i3;
                            i19 = i38;
                            c16 = c17;
                            bArr4 = bArr6;
                            str2 = str;
                            j16 = j3;
                            i26 = 2;
                            i27 = 8;
                            bArr2 = bArr5;
                            System.arraycopy(bArr, i47, bArr2, i19, 2);
                            i28 = i47 + 2;
                            i29 = (bArr2[i19] & 255) << 8;
                            i36 = bArr2[c16];
                            i47 = i28 + (i29 | ((i36 & 255) << i19));
                            bArr3 = bArr4;
                            break;
                        case 4:
                            i16 = i48;
                            i17 = i46;
                            i18 = i3;
                            i19 = i38;
                            c16 = c17;
                            bArr4 = bArr6;
                            str2 = str;
                            j16 = j3;
                            i26 = 2;
                            i27 = 8;
                            bArr2 = bArr5;
                            i47 += 10;
                            bArr3 = bArr4;
                            break;
                        case 8:
                            i16 = i48;
                            i17 = i46;
                            i18 = i3;
                            i19 = i38;
                            c16 = c17;
                            bArr4 = bArr6;
                            str2 = str;
                            j16 = j3;
                            i26 = 2;
                            i27 = 8;
                            bArr2 = bArr5;
                            System.arraycopy(bArr, i47, bArr2, i19, 2);
                            i28 = i47 + 2;
                            i29 = (bArr2[i19] & 255) << 8;
                            i36 = bArr2[c16];
                            i47 = i28 + (i29 | ((i36 & 255) << i19));
                            bArr3 = bArr4;
                            break;
                        case 10:
                            System.arraycopy(bArr, i47, bArr5, i38, 2);
                            int i56 = i47 + 2;
                            int i57 = (((bArr5[i38] & 255) << 8) | ((bArr5[c17] & 255) << i38)) / 8;
                            long[] jArr2 = new long[i57];
                            i16 = i48;
                            i17 = i46;
                            int i58 = i3;
                            i19 = i38;
                            c16 = c17;
                            long j18 = j3;
                            bArr4 = bArr6;
                            String str3 = str;
                            i27 = 8;
                            i18 = i58;
                            str2 = str;
                            j16 = j3;
                            i26 = 2;
                            bArr2 = bArr5;
                            i47 = x(bArr, i56, i57, jArr2, j18, str3, i58, j17);
                            jArr = jArr2;
                            bArr3 = bArr4;
                            break;
                        default:
                            i16 = i48;
                            i17 = i46;
                            i18 = i3;
                            i19 = i38;
                            c16 = c17;
                            bArr3 = bArr6;
                            str2 = str;
                            j16 = j3;
                            i26 = 2;
                            i27 = 8;
                            bArr2 = bArr5;
                            break;
                    }
                    bArr6 = bArr3;
                    i48 = i16 + 1;
                    i38 = i19;
                    bArr5 = bArr2;
                    i37 = i26;
                    i39 = i27;
                    i46 = i17;
                    c17 = c16;
                    str = str2;
                    j3 = j16;
                    i3 = i18;
                }
                int i59 = i3;
                if (jArr != null && jArr.length > 0) {
                    long j19 = j17;
                    this.f195422e.J0(i59, j19, jArr);
                    this.f195422e.m0(21, i59, j19, 0L);
                    return;
                }
                return;
            }
            str = currentAccountUin;
        } else {
            str = null;
        }
        j3 = 0;
        int i372 = 2;
        byte[] bArr52 = new byte[2];
        byte[] bArr62 = new byte[4];
        int i382 = 0;
        System.arraycopy(bArr, 2, bArr62, 0, 4);
        a16 = com.tencent.av.s.a(bArr62, 4);
        char c172 = 1;
        if (a16 == 0) {
        }
    }

    public int x(byte[] bArr, int i3, int i16, long[] jArr, long j3, String str, int i17, long j16) {
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 1;
        int i26 = 8;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), jArr, Long.valueOf(j3), str, Integer.valueOf(i17), Long.valueOf(j16))).intValue();
        }
        byte[] bArr2 = new byte[8];
        int i27 = i3;
        int i28 = 0;
        boolean z16 = false;
        while (i28 < i16) {
            System.arraycopy(bArr, i27, bArr2, 0, i26);
            int i29 = i27 + 8;
            long b16 = com.tencent.av.s.b(bArr2, i26);
            jArr[i28] = b16;
            if (b16 == j3 && this.f195422e.n() == 0) {
                i18 = i29;
                if (0 == this.f195422e.y(i17, j16)) {
                    z16 = true;
                }
            } else {
                i18 = i29;
            }
            i28++;
            i27 = i18;
            i26 = 8;
        }
        int i36 = i27;
        if (z16) {
            String l3 = Long.toString(j16);
            if (i17 == 2) {
                i19 = 3000;
            }
            VideoMsgTools.l(this.f195421d, i19, 13, false, l3, str, true, null, true, new Object[0]);
        }
        return i36;
    }

    public void y(byte[] bArr) {
        int length;
        byte[] bArr2;
        int length2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
            return;
        }
        byte[] bArr3 = new byte[2];
        System.arraycopy(bArr, 0, bArr3, 0, 2);
        int i3 = ((bArr3[1] & 255) << 0) | ((bArr3[0] & 255) << 8);
        if (QLog.isColorLevel()) {
            QLog.d("QQGAudioMsgHandler", 2, String.format("onRecvMultiVideoS2CData msgType=0x%X", Integer.valueOf(i3)));
        }
        if (!h()) {
            if (141 == i3 || 7 == i3) {
                J(i3, bArr);
                return;
            }
            return;
        }
        if (i3 != 7) {
            if (i3 != 59) {
                if (i3 != 141) {
                    if (i3 != 149) {
                        if (i3 == 195 && !com.tencent.av.utils.ax.d()) {
                            I(bArr, 27);
                            return;
                        }
                        return;
                    }
                    if (com.tencent.av.utils.af.H()) {
                        return;
                    }
                    A(bArr);
                    return;
                }
                if (com.tencent.av.utils.ax.d() || (bArr2 = this.f195423f) == null || (length2 = bArr.length) < 40) {
                    return;
                }
                if (bArr2.length < length2) {
                    this.f195423f = new byte[length2];
                }
                System.arraycopy(bArr, 0, this.f195423f, 0, length2);
                u(this.f195423f);
                return;
            }
            if (com.tencent.av.utils.af.H()) {
                return;
            }
            F(bArr);
            return;
        }
        byte[] bArr4 = this.f195423f;
        if (bArr4 == null || (length = bArr.length) < 40) {
            return;
        }
        if (bArr4.length < length) {
            this.f195423f = new byte[length];
        }
        System.arraycopy(bArr, 0, this.f195423f, 0, length);
        q(bArr);
    }

    public void z(qav_rtc_push_online$LoginPushMsg qav_rtc_push_online_loginpushmsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) qav_rtc_push_online_loginpushmsg);
            return;
        }
        if (!h()) {
            return;
        }
        ((IKernelAVSDKListenerApi) QRoute.api(IKernelAVSDKListenerApi.class)).onRecvMultiVideoS2C_0x210_0x14c_loginPush(qav_rtc_push_online_loginpushmsg);
        this.f195424h = true;
        Vector<byte[]> vector = this.f195425i;
        if (vector != null) {
            int size = vector.size();
            if (size > 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    b(this.f195425i.elementAt(i3));
                }
            }
            this.f195425i.clear();
        }
    }
}

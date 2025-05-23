package com.tencent.mobileqq.filemanager.core;

import android.util.Pair;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.message.ProcessorDispatcherInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes12.dex */
public class OnlineFileSessionWorker {

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f207510a;

    /* renamed from: b, reason: collision with root package name */
    long f207511b;

    /* renamed from: d, reason: collision with root package name */
    FileManagerEntity f207513d = null;

    /* renamed from: e, reason: collision with root package name */
    private Timer f207514e = null;

    /* renamed from: f, reason: collision with root package name */
    private Object f207515f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private Timer f207516g = null;

    /* renamed from: h, reason: collision with root package name */
    private Object f207517h = new Object();

    /* renamed from: i, reason: collision with root package name */
    long f207518i = 0;

    /* renamed from: j, reason: collision with root package name */
    long f207519j = 0;

    /* renamed from: k, reason: collision with root package name */
    long f207520k = 0;

    /* renamed from: l, reason: collision with root package name */
    long f207521l = 0;

    /* renamed from: m, reason: collision with root package name */
    a f207522m = new a();

    /* renamed from: c, reason: collision with root package name */
    private e f207512c = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        int f207524a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f207525b = 0;

        /* renamed from: c, reason: collision with root package name */
        boolean f207526c = false;

        /* renamed from: d, reason: collision with root package name */
        boolean f207527d = false;

        /* renamed from: e, reason: collision with root package name */
        boolean f207528e = false;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class aa extends e {
        public aa() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateSaveToWeiYunByPCWhenToOffFailed";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void q() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(11, 7);
                OnlineFileSessionWorker.this.h(11, 7);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateSaveToWeiYunByPC)");
                this.f207544a = new y();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ab extends m {
        public ab() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.m, com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateSenderCancelSend";
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class ac extends e {
        public ac() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateSenderCancelSendWhenPause";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void q() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(11, 8);
                OnlineFileSessionWorker.this.h(11, 8);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateSenderCancelSend)");
                this.f207544a = new ab();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ad extends e {
        public ad() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateSenderCancelSendWhenToOffFailed";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void q() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(11, 8);
                OnlineFileSessionWorker.this.h(11, 8);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateSenderCancelSend)");
                this.f207544a = new ab();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class af extends e {
        public af() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void a() {
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. doSomeThingOnUploadDone entity is null");
                return;
            }
            fileManagerEntity.fProgress = 0.0f;
            fileManagerEntity.setCloudType(1);
            OnlineFileSessionWorker.this.T(1, 3);
            OnlineFileSessionWorker.this.h(1, 3);
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().b(true, 22, new Object[]{Long.valueOf(fileManagerEntity.nSessionId), Long.valueOf(fileManagerEntity.nOLfileSessionId)});
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateGotoOffFileProcess)");
            this.f207544a = new q();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateUploadingWhenPause";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void l(long j3) {
            e(j3);
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void p(boolean z16) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
                return;
            }
            if (z16) {
                onlineFileSessionWorker.s();
                OnlineFileSessionWorker.this.T(10, 11);
                OnlineFileSessionWorker.this.h(10, 14);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadingWhenPause)");
                this.f207544a = new af();
                return;
            }
            onlineFileSessionWorker.T(10, 10);
            OnlineFileSessionWorker.this.h(10, 10);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateChangeToOffFailedWhenPause)");
            this.f207544a = new i();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("OLfile session[");
            sb5.append(OnlineFileSessionWorker.this.f207511b);
            sb5.append("]  recv failed!!");
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, sb5.toString());
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void q() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.h(9, 14);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadingWhenRecv)");
                this.f207544a = new ag();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void r() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(10, 9);
                OnlineFileSessionWorker.this.h(10, 9);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateCancelUploadWhenPause)");
                this.f207544a = new g();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean t(int i3, String str, long j3) {
            String str2;
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
                return false;
            }
            fileManagerEntity.Uuid = new String(str);
            fileManagerEntity.fProgress = 0.0f;
            if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0 && (str2 = fileManagerEntity.Uuid) != null && str2.length() != 0) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerEngine().m(fileManagerEntity, 7);
            }
            OnlineFileSessionWorker.this.P(j3, fileManagerEntity.peerUin);
            fileManagerEntity.setCloudType(1);
            OnlineFileSessionWorker.this.T(1, 3);
            OnlineFileSessionWorker.this.h(1, 3);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadoneWhenPause)");
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().b(true, 22, new Object[]{Long.valueOf(fileManagerEntity.nSessionId), Long.valueOf(fileManagerEntity.nOLfileSessionId)});
            this.f207544a = new ai();
            return true;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void u(int i3, String str) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(10, 12);
                OnlineFileSessionWorker.this.h(10, 12);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateExcepInvalidWhenPause)");
                this.f207544a = new o();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void v(int i3, int i16) {
            d(i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ag extends e {
        public ag() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void a() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "StateUploadingWhenRecv OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. doSomeThingOnUploadDone entity is null");
                return;
            }
            onlineFileSessionWorker.f207510a.getFileManagerNotifyCenter().b(true, 22, new Object[]{Long.valueOf(fileManagerEntity.nSessionId), Long.valueOf(fileManagerEntity.nOLfileSessionId)});
            fileManagerEntity.fProgress = 0.0f;
            fileManagerEntity.setCloudType(1);
            OnlineFileSessionWorker.this.T(1, 0);
            OnlineFileSessionWorker.this.h(1, 2);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "StateUploadingWhenRecv OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + ". doSomeThingOnUploadDone start recv offline file....)");
            OnlineFileSessionWorker.this.f207510a.getFileManagerRSCenter().g(OnlineFileSessionWorker.this.f207511b, fileManagerEntity.uniseq, fileManagerEntity.peerUin, fileManagerEntity.peerType, 1);
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 10, null, 6, null);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "StateUploadingWhenRecv OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateGotoOffFileProcess)");
            this.f207544a = new q();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateUploadingWhenRecv";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void j(int i3) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
            if (fileManagerEntity != null) {
                onlineFileSessionWorker.T(9, 11);
                OnlineFileSessionWorker.this.h(9, 11);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateLocalFailedWhenRecv)");
                this.f207544a = new t();
                OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 6, null);
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. onFailedOfLocalSomeThingHappen entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void l(long j3) {
            e(j3);
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void m() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(10, -2);
                OnlineFileSessionWorker.this.h(10, 14);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadingWhenPause)");
                this.f207544a = new af();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void p(boolean z16) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
                return;
            }
            if (z16) {
                onlineFileSessionWorker.s();
                OnlineFileSessionWorker.this.T(9, 11);
                OnlineFileSessionWorker.this.h(9, 14);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadingWhenRecv)");
                this.f207544a = new ag();
                return;
            }
            onlineFileSessionWorker.T(9, 10);
            OnlineFileSessionWorker.this.h(9, 10);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateChangeToOffFailedWhenRecv)");
            this.f207544a = new j();
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 6, null);
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + OnlineFileSessionWorker.this.f207511b + "]  recv failed!!");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void r() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
            if (fileManagerEntity != null) {
                onlineFileSessionWorker.T(11, 9);
                OnlineFileSessionWorker.this.h(11, 9);
                OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 0, null);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateCancelUploadWhenRecv)");
                this.f207544a = new h();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean t(int i3, String str, long j3) {
            String str2;
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
                return false;
            }
            fileManagerEntity.Uuid = new String(str);
            if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0 && (str2 = fileManagerEntity.Uuid) != null && str2.length() != 0) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerEngine().m(fileManagerEntity, 7);
            }
            OnlineFileSessionWorker.this.P(j3, fileManagerEntity.peerUin);
            if (fileManagerEntity.fProgress < 0.9f) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. start make progress pass to 100% directly");
                this.f207546c = true;
                OnlineFileSessionWorker.this.w(1.0f);
            } else {
                a();
            }
            return true;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void u(int i3, String str) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
            if (fileManagerEntity != null) {
                onlineFileSessionWorker.T(9, 12);
                OnlineFileSessionWorker.this.h(9, 12);
                OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 5, null);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateExcepInvalidWhenRecv)");
                this.f207544a = new p();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void v(int i3, int i16) {
            d(i3, i16);
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void w() {
            if (!y(DKHippyEvent.EVENT_STOP)) {
                OnlineFileSessionWorker.this.Q(9, 11, true);
                x("StateLocalFailedWhenRecv");
                this.f207544a = new t();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ah extends m {
        public ah() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.m, com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateUploadoneWhenChangeToOff";
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class ai extends m {
        public ai() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.m, com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateUploadoneWhenPause";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class aj extends e {
        public aj() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateWaitResultWhenPause";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void f(boolean z16) {
            if (y("onAskSenderUpProgressResult")) {
                return;
            }
            if (z16) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + " recv  success response of ask progress,  waiting the notify of progress");
                return;
            }
            OnlineFileSessionWorker.this.q(2);
            if (!OnlineFileSessionWorker.this.a0()) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. state:" + this.f207544a.c() + " ask progress server result = false and no handle it. here waiting response of sender on recv");
                return;
            }
            OnlineFileSessionWorker.this.u(false);
            OnlineFileSessionWorker.this.T(10, 10);
            OnlineFileSessionWorker.this.h(10, 10);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateChangeToOffFailedWhenPause)");
            this.f207544a = new i();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void g() {
            if (y("onAskSenderUpProgressTimeOut")) {
                return;
            }
            QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. state:" + this.f207544a.c() + " you had recv the file, but ask progress time out!!!!!, recvCmdSucAndHadTryCount =" + OnlineFileSessionWorker.this.f207522m.f207524a);
            OnlineFileSessionWorker.this.q(2);
            if (!OnlineFileSessionWorker.this.a0()) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. state:" + this.f207544a.c() + " ask progress time out and no handle it. here waiting response of sender when recv");
                return;
            }
            OnlineFileSessionWorker.this.u(false);
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207522m.f207524a < Long.MAX_VALUE) {
                onlineFileSessionWorker.Q(10, 10, true);
                x("StateChangeToOffFailedWhenPause");
                this.f207544a = new i();
            } else {
                onlineFileSessionWorker.Q(10, 12, true);
                x("StateExcepInvalidWhenPause");
                this.f207544a = new o();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void k(int i3) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
            boolean z16 = true;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. onFileRequestBeHandledByPC entity is null");
                return;
            }
            if (5 != i3) {
                onlineFileSessionWorker.X();
            } else {
                onlineFileSessionWorker.X();
            }
            if (i3 == 1) {
                OnlineFileSessionWorker.this.T(10, 5);
                OnlineFileSessionWorker.this.h(10, 5);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateAcceptByPCWhenPause)");
                this.f207544a = new c();
            } else if (i3 == 2) {
                OnlineFileSessionWorker.this.T(10, 6);
                OnlineFileSessionWorker.this.h(10, 6);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateRefuseByPCWhenPause)");
                this.f207544a = new v();
            } else if (i3 == 3) {
                OnlineFileSessionWorker.this.T(10, 8);
                OnlineFileSessionWorker.this.h(10, 8);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateSenderCancelSendWhenPause)");
                this.f207544a = new ac();
            } else if (i3 == 4) {
                OnlineFileSessionWorker.this.T(10, 7);
                OnlineFileSessionWorker.this.h(10, 7);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateSaveToWeiYunByPCWhenPause)");
                this.f207544a = new z();
            } else {
                if (i3 == 5) {
                    OnlineFileSessionWorker.this.s();
                    OnlineFileSessionWorker.this.T(10, 11);
                    OnlineFileSessionWorker.this.h(10, 14);
                    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadingWhenPause)");
                    this.f207544a = new af();
                } else {
                    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + OnlineFileSessionWorker.this.f207511b + "]  is not foud . handledbypc type error:" + i3);
                }
                z16 = false;
            }
            if (z16) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 0, null);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void n() {
            if (OnlineFileSessionWorker.this.f207513d == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. state:" + this.f207544a.c() + "onRecvButSenderReplayTimeOut entity is null");
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. state:" + this.f207544a.c() + " you had recv the file, but sender replay time out!!!! recvCmdSucAndHadTryCount=" + OnlineFileSessionWorker.this.f207522m.f207524a);
            OnlineFileSessionWorker.this.q(1);
            if (!OnlineFileSessionWorker.this.a0()) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. state:" + this.f207544a.c() + " sender replay time out and no handle it. here waiting response of asking progress");
                return;
            }
            OnlineFileSessionWorker.this.u(false);
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207522m.f207524a < Long.MAX_VALUE) {
                onlineFileSessionWorker.Q(10, 10, true);
                x("StateChangeToOffFailedWhenPause");
                this.f207544a = new i();
            } else {
                onlineFileSessionWorker.Q(10, 12, true);
                x("StateExcepInvalidWhenPause");
                this.f207544a = new o();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void p(boolean z16) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d == null) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. onRecvOnLineFileResult entity is null");
                return;
            }
            if (z16) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + " recv  success response of accept,  waiting the cmd of starting upload");
                return;
            }
            onlineFileSessionWorker.q(1);
            if (!OnlineFileSessionWorker.this.a0()) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. state:" + this.f207544a.c() + " recvonlinefile result = false and no handle it. here waiting response of asking progress");
                return;
            }
            OnlineFileSessionWorker.this.u(false);
            OnlineFileSessionWorker.this.T(10, 10);
            OnlineFileSessionWorker.this.h(10, 10);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateChangeToOffFailedWhenPause)");
            this.f207544a = new i();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("OLfile session[");
            sb5.append(OnlineFileSessionWorker.this.f207511b);
            sb5.append("]  recv failed!!");
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, sb5.toString());
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void q() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(9, 10);
                OnlineFileSessionWorker.this.h(9, 15);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateWaitResultWhenRecv)");
                this.f207544a = new ak();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void r() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.Q(10, 9, true);
                x("StateCancelUploadWhenPause");
                this.f207544a = new g();
            } else {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void s() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d == null) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. onSenderReplayComeOnRecv entity is null");
                return;
            }
            onlineFileSessionWorker.u(true);
            OnlineFileSessionWorker.this.s();
            OnlineFileSessionWorker.this.T(10, 11);
            OnlineFileSessionWorker.this.h(10, 14);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadingWhenPause)");
            this.f207544a = new af();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean t(int i3, String str, long j3) {
            String str2;
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
                return false;
            }
            fileManagerEntity.Uuid = new String(str);
            fileManagerEntity.fProgress = 0.0f;
            if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0 && (str2 = fileManagerEntity.Uuid) != null && str2.length() != 0) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerEngine().m(fileManagerEntity, 7);
            }
            OnlineFileSessionWorker.this.P(j3, fileManagerEntity.peerUin);
            fileManagerEntity.setCloudType(1);
            OnlineFileSessionWorker.this.T(1, 3);
            OnlineFileSessionWorker.this.h(1, 3);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadoneWhenPause)");
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().b(true, 22, new Object[]{Long.valueOf(fileManagerEntity.nSessionId), Long.valueOf(fileManagerEntity.nOLfileSessionId)});
            this.f207544a = new ai();
            return true;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void u(int i3, String str) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.Q(10, 12, true);
                x("StateExcepInvalidWhenPause");
                this.f207544a = new o();
            } else {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void v(int i3, int i16) {
            if (y("onSenderUploadProgressNotify")) {
                return;
            }
            OnlineFileSessionWorker.this.u(true);
            OnlineFileSessionWorker.this.s();
            d(i3, i16);
            OnlineFileSessionWorker.this.R(10, 11);
            OnlineFileSessionWorker.this.Q(10, 14, false);
            x("StateUploadingWhenPause");
            this.f207544a = new af();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b extends m {
        public b() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.m, com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateAcceptByPC";
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class c extends e {
        public c() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateAcceptByPCWhenPause";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void q() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(11, 5);
                OnlineFileSessionWorker.this.h(11, 5);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateAcceptByPC)");
                this.f207544a = new b();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d extends e {
        public d() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateAcceptByPCWhenToOffFailed";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void q() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(11, 5);
                OnlineFileSessionWorker.this.h(11, 5);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateAcceptByPC)");
                this.f207544a = new b();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f extends e {
        public f() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateCancelUploadWhenChangeToOff";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean o() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(11, 9);
                OnlineFileSessionWorker.this.h(11, 9);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateCancelUploadWhenRecv)");
                this.f207544a = new h();
                return true;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class g extends e {
        public g() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateCancelUploadWhenPause";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void q() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(11, 9);
                OnlineFileSessionWorker.this.h(11, 9);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateCancelUploadWhenRecv)");
                this.f207544a = new h();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class h extends m {
        public h() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.m, com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateCancelUploadWhenRecv";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class i extends e {
        public i() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateChangeToOffFailedWhenPause";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void f(boolean z16) {
            if (z16) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + " recv  success response of ask progress, not handle it");
                return;
            }
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + " recv  failed response of ask progress, not handle it");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void k(int i3) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
            boolean z16 = true;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. onFileRequestBeHandledByPC entity is null");
                return;
            }
            if (5 != i3) {
                onlineFileSessionWorker.X();
            } else {
                onlineFileSessionWorker.Z();
            }
            if (i3 == 1) {
                OnlineFileSessionWorker.this.T(10, 5);
                OnlineFileSessionWorker.this.h(10, 5);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateAcceptByPCWhenPause)");
                this.f207544a = new c();
            } else if (i3 == 2) {
                OnlineFileSessionWorker.this.T(10, 6);
                OnlineFileSessionWorker.this.h(10, 6);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateRefuseByPCWhenPause)");
                this.f207544a = new v();
            } else if (i3 == 3) {
                OnlineFileSessionWorker.this.T(10, 8);
                OnlineFileSessionWorker.this.h(10, 8);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateSenderCancelSendWhenPause)");
                this.f207544a = new ac();
            } else if (i3 == 4) {
                OnlineFileSessionWorker.this.T(10, 7);
                OnlineFileSessionWorker.this.h(10, 7);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateSaveToWeiYunByPCWhenPause)");
                this.f207544a = new z();
            } else {
                if (i3 == 5) {
                    OnlineFileSessionWorker.this.s();
                    OnlineFileSessionWorker.this.T(10, 11);
                    OnlineFileSessionWorker.this.h(10, 14);
                    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateChangeToOffWhenPause)");
                    this.f207544a = new k();
                } else {
                    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + OnlineFileSessionWorker.this.f207511b + "]  is not foud . handledbypc type error:" + i3);
                }
                z16 = false;
            }
            if (z16) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 0, null);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void p(boolean z16) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d == null) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. StateWaitingRecvResult entity is null");
                return;
            }
            if (z16) {
                onlineFileSessionWorker.s();
                OnlineFileSessionWorker.this.Q(10, 11, true);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateLocalFailedWhenPause)");
                this.f207544a = new s();
                return;
            }
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateChangeToOffFailedWhenPause)");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void q() {
            if (y("onResumeTrans")) {
                return;
            }
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "start send recv cmd.... [" + OnlineFileSessionWorker.this.f207522m.f207524a + "-" + OnlineFileSessionWorker.this.f207522m.f207525b + "]");
            if (OnlineFileSessionWorker.this.t(fileManagerEntity.peerUin, fileManagerEntity.nOLfileSessionId)) {
                OnlineFileSessionWorker.this.h(9, 14);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateWaitResultWhenRecv)");
                this.f207544a = new ak();
                OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 10, null, 6, null);
                FileManagerNotifyCenter fileManagerNotifyCenter = OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter();
                FileManagerEntity fileManagerEntity2 = OnlineFileSessionWorker.this.f207513d;
                fileManagerNotifyCenter.c(fileManagerEntity2.uniseq, fileManagerEntity2.nSessionId, fileManagerEntity2.peerUin, fileManagerEntity2.peerType, 16, null, 0, null);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void r() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.Q(10, 9, true);
                x("StateCancelUploadWhenPause");
                this.f207544a = new g();
            } else {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void s() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.s();
                OnlineFileSessionWorker.this.Q(10, 11, true);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateLocalFailedWhenPause)");
                this.f207544a = new s();
                return;
            }
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. onSenderReplayComeOnRecv entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean t(int i3, String str, long j3) {
            String str2;
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
                return false;
            }
            fileManagerEntity.Uuid = new String(str);
            fileManagerEntity.fProgress = 0.0f;
            if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0 && (str2 = fileManagerEntity.Uuid) != null && str2.length() != 0) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerEngine().m(fileManagerEntity, 7);
            }
            OnlineFileSessionWorker.this.P(j3, fileManagerEntity.peerUin);
            fileManagerEntity.setCloudType(1);
            OnlineFileSessionWorker.this.T(1, 3);
            OnlineFileSessionWorker.this.h(1, 3);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadoneWhenPause)");
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().b(true, 22, new Object[]{Long.valueOf(fileManagerEntity.nSessionId), Long.valueOf(fileManagerEntity.nOLfileSessionId)});
            this.f207544a = new ai();
            return true;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void u(int i3, String str) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.Q(10, 12, true);
                x("StateExcepInvalidWhenPause");
                this.f207544a = new o();
            } else {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void v(int i3, int i16) {
            if (!y("onSenderUploadProgressNotify")) {
                OnlineFileSessionWorker.this.s();
                d(i3, i16);
                OnlineFileSessionWorker.this.R(10, 11);
                OnlineFileSessionWorker.this.Q(10, 14, false);
                x("StateUploadingWhenPause");
                this.f207544a = new af();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class j extends e {
        public j() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateChangeToOffFailedWhenRecv";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void f(boolean z16) {
            if (z16) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + " recv  success response of ask progress, not handle it");
                return;
            }
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + " recv  failed response of ask progress, not handle it");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void k(int i3) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
            boolean z16 = true;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. onFileRequestBeHandledByPC entity is null");
                return;
            }
            if (5 != i3) {
                onlineFileSessionWorker.X();
            } else {
                onlineFileSessionWorker.Z();
            }
            if (i3 == 1) {
                OnlineFileSessionWorker.this.T(13, 5);
                OnlineFileSessionWorker.this.h(13, 5);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateAcceptByPCWhenToOffFailed)");
                this.f207544a = new d();
            } else if (i3 == 2) {
                OnlineFileSessionWorker.this.T(13, 6);
                OnlineFileSessionWorker.this.h(13, 6);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateRefuseByPCWhenToOffFailed)");
                this.f207544a = new w();
            } else if (i3 == 3) {
                OnlineFileSessionWorker.this.T(13, 8);
                OnlineFileSessionWorker.this.h(13, 8);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateSenderCancelSendWhenToOffFailed)");
                this.f207544a = new ad();
            } else if (i3 == 4) {
                OnlineFileSessionWorker.this.T(13, 7);
                OnlineFileSessionWorker.this.h(13, 7);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateSaveToWeiYunByPCWhenToOffFailed)");
                this.f207544a = new aa();
            } else {
                if (i3 == 5) {
                    OnlineFileSessionWorker.this.s();
                    OnlineFileSessionWorker.this.T(13, 11);
                    OnlineFileSessionWorker.this.h(13, 14);
                    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateChangeToOffWhenToOffFailed)");
                    this.f207544a = new l();
                } else {
                    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + OnlineFileSessionWorker.this.f207511b + "]  is not foud . handledbypc type error:" + i3);
                }
                z16 = false;
            }
            if (z16) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 0, null);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void p(boolean z16) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d == null) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. StateWaitingRecvResult entity is null");
                return;
            }
            if (z16) {
                onlineFileSessionWorker.s();
                OnlineFileSessionWorker.this.Q(9, 11, true);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateLocalFailedWhenRecv)");
                this.f207544a = new t();
                return;
            }
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateChangeToOffFailedWhenRecv)");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void q() {
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
                return;
            }
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "start send recv cmd.... [" + OnlineFileSessionWorker.this.f207522m.f207524a + "-" + OnlineFileSessionWorker.this.f207522m.f207525b + "]");
            if (OnlineFileSessionWorker.this.t(fileManagerEntity.peerUin, fileManagerEntity.nOLfileSessionId)) {
                OnlineFileSessionWorker.this.h(9, 14);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateWaitResultWhenRecv)");
                this.f207544a = new ak();
                OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 10, null, 6, null);
                FileManagerNotifyCenter fileManagerNotifyCenter = OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter();
                FileManagerEntity fileManagerEntity2 = OnlineFileSessionWorker.this.f207513d;
                fileManagerNotifyCenter.c(fileManagerEntity2.uniseq, fileManagerEntity2.nSessionId, fileManagerEntity2.peerUin, fileManagerEntity2.peerType, 16, null, 0, null);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void r() {
            if (!y("onSenderCancelUpload")) {
                OnlineFileSessionWorker.this.Q(11, 9, true);
                x("StateCancelUploadWhenRecv");
                this.f207544a = new h();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void s() {
            if (!y("onSenderReplayComeOnRecv")) {
                OnlineFileSessionWorker.this.s();
                OnlineFileSessionWorker.this.Q(9, 11, true);
                x("StateLocalFailedWhenRecv");
                this.f207544a = new t();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean t(int i3, String str, long j3) {
            String str2;
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
                return false;
            }
            fileManagerEntity.Uuid = new String(str);
            fileManagerEntity.fProgress = 0.0f;
            if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0 && (str2 = fileManagerEntity.Uuid) != null && str2.length() != 0) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerEngine().m(fileManagerEntity, 7);
            }
            OnlineFileSessionWorker.this.P(j3, fileManagerEntity.peerUin);
            fileManagerEntity.setCloudType(1);
            OnlineFileSessionWorker.this.T(1, 0);
            OnlineFileSessionWorker.this.h(1, 0);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateGotoOffFileProcess)");
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().b(true, 22, new Object[]{Long.valueOf(fileManagerEntity.nSessionId), Long.valueOf(fileManagerEntity.nOLfileSessionId)});
            this.f207544a = new q();
            return true;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void u(int i3, String str) {
            if (!y("onSenderUploadException")) {
                OnlineFileSessionWorker.this.Q(9, 12, true);
                x("StateExcepInvalidWhenRecv");
                this.f207544a = new p();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void v(int i3, int i16) {
            if (!y("onSenderUploadProgressNotify")) {
                OnlineFileSessionWorker.this.s();
                d(i3, i16);
                OnlineFileSessionWorker.this.Q(9, 11, true);
                x("StateLocalFailedWhenRecv");
                this.f207544a = new t();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class k extends e {
        public k() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateChangeToOffWhenPause";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void q() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(9, 11);
                OnlineFileSessionWorker.this.h(9, 14);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadingWhenRecv)");
                this.f207544a = new ag();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class l extends e {
        public l() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateChangeToOffWhenToOffFailed";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void q() {
            if (!y("onResumeTrans")) {
                OnlineFileSessionWorker.this.R(9, 11);
                OnlineFileSessionWorker.this.Q(9, 14, false);
                x("StateUploadingWhenRecv");
                this.f207544a = new ag();
                OnlineFileSessionWorker.this.g(true, 0L);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void r() {
            if (!y("onSenderCancelUpload")) {
                OnlineFileSessionWorker.this.Q(11, 9, true);
                x("StateCancelUploadWhenRecv");
                this.f207544a = new h();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean t(int i3, String str, long j3) {
            String str2;
            if (y("onSenderUploadCompleted")) {
                return false;
            }
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            fileManagerEntity.Uuid = new String(str);
            fileManagerEntity.fProgress = 0.0f;
            if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0 && (str2 = fileManagerEntity.Uuid) != null && str2.length() != 0) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerEngine().m(fileManagerEntity, 7);
            }
            OnlineFileSessionWorker.this.P(j3, fileManagerEntity.peerUin);
            fileManagerEntity.setCloudType(1);
            OnlineFileSessionWorker.this.Q(1, 0, true);
            x("StateGotoOffFileProcess");
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().b(true, 22, new Object[]{Long.valueOf(fileManagerEntity.nSessionId), Long.valueOf(fileManagerEntity.nOLfileSessionId)});
            this.f207544a = new q();
            return true;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void u(int i3, String str) {
            if (!y("onSenderUploadException")) {
                OnlineFileSessionWorker.this.Q(9, 12, true);
                x("StateExcepInvalidWhenRecv");
                this.f207544a = new p();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void v(int i3, int i16) {
            d(i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class m extends e {
        m() {
            super();
            this.f207545b = true;
            this.f207546c = true;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateEnd";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class n extends e {
        public n() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateExcepInvalidWhenChangeToOff";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean o() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(9, 12);
                OnlineFileSessionWorker.this.h(9, 12);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateExcepInvalidWhenRecv)");
                this.f207544a = new p();
                return true;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
            return false;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean t(int i3, String str, long j3) {
            String str2;
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
                return false;
            }
            fileManagerEntity.Uuid = new String(str);
            fileManagerEntity.fProgress = 0.0f;
            if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0 && (str2 = fileManagerEntity.Uuid) != null && str2.length() != 0) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerEngine().m(fileManagerEntity, 7);
            }
            fileManagerEntity.setCloudType(1);
            OnlineFileSessionWorker.this.T(11, 13);
            OnlineFileSessionWorker.this.h(11, 13);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadoneWhenChangeToOff)");
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().b(true, 22, new Object[]{Long.valueOf(fileManagerEntity.nSessionId), Long.valueOf(fileManagerEntity.nOLfileSessionId)});
            this.f207544a = new ah();
            return true;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void v(int i3, int i16) {
            d(i3, i16);
            OnlineFileSessionWorker.this.T(11, 11);
            OnlineFileSessionWorker.this.h(11, 14);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadingWhenChangeToOff)");
            this.f207544a = new ae();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class o extends e {
        public o() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateExcepInvalidWhenPause";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void k(int i3) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
            boolean z16 = true;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. onFileRequestBeHandledByPC entity is null");
                return;
            }
            if (5 != i3) {
                onlineFileSessionWorker.X();
            } else {
                onlineFileSessionWorker.Z();
            }
            if (i3 == 1) {
                OnlineFileSessionWorker.this.T(10, 5);
                OnlineFileSessionWorker.this.h(10, 5);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateAcceptByPCWhenPause)");
                this.f207544a = new c();
            } else if (i3 == 2) {
                OnlineFileSessionWorker.this.T(10, 6);
                OnlineFileSessionWorker.this.h(10, 6);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateRefuseByPCWhenPause)");
                this.f207544a = new v();
            } else if (i3 == 3) {
                OnlineFileSessionWorker.this.T(10, 8);
                OnlineFileSessionWorker.this.h(10, 8);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateSenderCancelSendWhenPause)");
                this.f207544a = new ac();
            } else if (i3 == 4) {
                OnlineFileSessionWorker.this.T(10, 7);
                OnlineFileSessionWorker.this.h(10, 7);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateSaveToWeiYunByPCWhenPause)");
                this.f207544a = new z();
            } else {
                if (i3 == 5) {
                    OnlineFileSessionWorker.this.s();
                    OnlineFileSessionWorker.this.T(10, 11);
                    OnlineFileSessionWorker.this.h(10, 14);
                    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadingWhenPause)");
                    this.f207544a = new af();
                } else {
                    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + OnlineFileSessionWorker.this.f207511b + "]  is not foud . handledbypc type error:" + i3);
                }
                z16 = false;
            }
            if (z16) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 0, null);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void q() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(9, 12);
                OnlineFileSessionWorker.this.h(9, 12);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateExcepInvalidWhenRecv)");
                this.f207544a = new p();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void r() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.Q(10, 9, true);
                x("StateCancelUploadWhenPause");
                this.f207544a = new g();
            } else {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void s() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.s();
                OnlineFileSessionWorker.this.Q(10, 11, true);
                x("StateLocalFailedWhenPause");
                this.f207544a = new s();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. onSenderReplayComeOnRecv entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean t(int i3, String str, long j3) {
            String str2;
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
                return false;
            }
            fileManagerEntity.Uuid = new String(str);
            fileManagerEntity.fProgress = 0.0f;
            if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0 && (str2 = fileManagerEntity.Uuid) != null && str2.length() != 0) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerEngine().m(fileManagerEntity, 7);
            }
            OnlineFileSessionWorker.this.P(j3, fileManagerEntity.peerUin);
            fileManagerEntity.setCloudType(1);
            OnlineFileSessionWorker.this.T(1, 3);
            OnlineFileSessionWorker.this.h(1, 3);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateGotoOffFileProcess)");
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().b(true, 22, new Object[]{Long.valueOf(fileManagerEntity.nSessionId), Long.valueOf(fileManagerEntity.nOLfileSessionId)});
            this.f207544a = new q();
            return true;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void u(int i3, String str) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.Q(10, 12, true);
                x("StateExcepInvalidWhenPause");
                this.f207544a = new o();
            } else {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void v(int i3, int i16) {
            d(i3, i16);
            OnlineFileSessionWorker.this.T(10, 11);
            OnlineFileSessionWorker.this.h(10, 14);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadingWhenPause)");
            this.f207544a = new af();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class p extends m {
        public p() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.m, com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateExcepInvalidWhenRecv";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void k(int i3) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
            boolean z16 = true;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. onFileRequestBeHandledByPC entity is null");
                return;
            }
            if (5 != i3) {
                onlineFileSessionWorker.X();
            } else {
                onlineFileSessionWorker.Z();
            }
            if (i3 == 1) {
                OnlineFileSessionWorker.this.T(11, 5);
                OnlineFileSessionWorker.this.h(11, 5);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateAcceptByPC)");
                this.f207544a = new b();
            } else if (i3 == 2) {
                OnlineFileSessionWorker.this.T(11, 6);
                OnlineFileSessionWorker.this.h(11, 6);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateRefuseByPC)");
                this.f207544a = new u();
            } else if (i3 == 3) {
                OnlineFileSessionWorker.this.T(11, 8);
                OnlineFileSessionWorker.this.h(11, 8);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateSenderCancelSend)");
                this.f207544a = new ab();
            } else if (i3 == 4) {
                OnlineFileSessionWorker.this.T(11, 7);
                OnlineFileSessionWorker.this.h(11, 7);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateSaveToWeiYunByPC)");
                this.f207544a = new y();
            } else {
                if (i3 == 5) {
                    OnlineFileSessionWorker.this.s();
                    OnlineFileSessionWorker.this.T(11, 11);
                    OnlineFileSessionWorker.this.h(11, 14);
                    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadingWhenChangeToOff)");
                    this.f207544a = new ae();
                } else {
                    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + OnlineFileSessionWorker.this.f207511b + "]  is not foud . handledbypc type error:" + i3);
                }
                z16 = false;
            }
            if (z16) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 0, null);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void r() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.Q(11, 9, true);
                x("StateCancelUploadWhenRecv");
                this.f207544a = new h();
            } else {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void s() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
            if (fileManagerEntity != null) {
                onlineFileSessionWorker.s();
                OnlineFileSessionWorker.this.Q(9, 11, true);
                x("StateLocalFailedWhenRecv");
                this.f207544a = new t();
                OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 6, null);
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. onFailedOfLocalSomeThingHappen entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean t(int i3, String str, long j3) {
            String str2;
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
                return false;
            }
            fileManagerEntity.Uuid = new String(str);
            fileManagerEntity.fProgress = 0.0f;
            if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0 && (str2 = fileManagerEntity.Uuid) != null && str2.length() != 0) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerEngine().m(fileManagerEntity, 5);
            }
            fileManagerEntity.setCloudType(1);
            OnlineFileSessionWorker.this.T(1, 0);
            OnlineFileSessionWorker.this.h(1, 0);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateGotoOffFileProcess)");
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().b(true, 22, new Object[]{Long.valueOf(fileManagerEntity.nSessionId), Long.valueOf(fileManagerEntity.nOLfileSessionId)});
            this.f207544a = new q();
            return true;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void u(int i3, String str) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.Q(9, 12, true);
                x("StateExcepInvalidWhenRecv");
                this.f207544a = new p();
            } else {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void v(int i3, int i16) {
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
                return;
            }
            d(i3, i16);
            OnlineFileSessionWorker.this.T(9, 11);
            OnlineFileSessionWorker.this.h(9, 11);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateLocalFailedWhenRecv)");
            this.f207544a = new t();
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class q extends m {
        public q() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.m, com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateGotoOffFileProcess";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class s extends e {
        public s() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateLocalFailedWhenPause";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void l(long j3) {
            e(j3);
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void q() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.h(9, 14);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadingWhenRecv)");
                this.f207544a = new ag();
                OnlineFileSessionWorker.this.g(true, 0L);
                FileManagerNotifyCenter fileManagerNotifyCenter = OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter();
                FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
                fileManagerNotifyCenter.c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 16, null, 0, null);
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void r() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.Q(10, 9, true);
                x("StateCancelUploadWhenPause");
                this.f207544a = new g();
            } else {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean t(int i3, String str, long j3) {
            String str2;
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
                return false;
            }
            fileManagerEntity.Uuid = new String(str);
            fileManagerEntity.fProgress = 0.0f;
            if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0 && (str2 = fileManagerEntity.Uuid) != null && str2.length() != 0) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerEngine().m(fileManagerEntity, 7);
            }
            OnlineFileSessionWorker.this.P(j3, fileManagerEntity.peerUin);
            fileManagerEntity.setCloudType(1);
            OnlineFileSessionWorker.this.T(1, 3);
            OnlineFileSessionWorker.this.h(1, 3);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateGotoOffFileProcess)");
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().b(true, 22, new Object[]{Long.valueOf(fileManagerEntity.nSessionId), Long.valueOf(fileManagerEntity.nOLfileSessionId)});
            this.f207544a = new q();
            return true;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void u(int i3, String str) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.Q(10, 12, true);
                x("StateExcepInvalidWhenPause");
                this.f207544a = new o();
            } else {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void v(int i3, int i16) {
            d(i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class t extends e {
        public t() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateLocalFailedWhenRecv";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void l(long j3) {
            e(j3);
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void q() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.h(9, 14);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadingWhenRecv)");
                this.f207544a = new ag();
                OnlineFileSessionWorker.this.g(true, 0L);
                FileManagerNotifyCenter fileManagerNotifyCenter = OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter();
                FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
                fileManagerNotifyCenter.c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 16, null, 0, null);
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void r() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.Q(11, 9, true);
                x("StateCancelUploadWhenRecv");
                this.f207544a = new h();
            } else {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean t(int i3, String str, long j3) {
            String str2;
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
                return false;
            }
            fileManagerEntity.Uuid = new String(str);
            fileManagerEntity.fProgress = 0.0f;
            if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0 && (str2 = fileManagerEntity.Uuid) != null && str2.length() != 0) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerEngine().m(fileManagerEntity, 7);
            }
            OnlineFileSessionWorker.this.P(j3, fileManagerEntity.peerUin);
            fileManagerEntity.setCloudType(1);
            OnlineFileSessionWorker.this.T(1, 0);
            OnlineFileSessionWorker.this.h(1, 0);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateGotoOffFileProcess)");
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().b(true, 22, new Object[]{Long.valueOf(fileManagerEntity.nSessionId), Long.valueOf(fileManagerEntity.nOLfileSessionId)});
            this.f207544a = new q();
            return true;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void u(int i3, String str) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.Q(9, 12, true);
                x("StateExcepInvalidWhenRecv");
                this.f207544a = new p();
            } else {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void v(int i3, int i16) {
            d(i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class u extends m {
        public u() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.m, com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateRefuseByPC";
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class v extends e {
        public v() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateRefuseByPCWhenPause";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void q() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(11, 6);
                OnlineFileSessionWorker.this.h(11, 6);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateRefuseByPC)");
                this.f207544a = new u();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class w extends e {
        public w() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateRefuseByPCWhenToOffFailed";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void q() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(11, 6);
                OnlineFileSessionWorker.this.h(11, 6);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateRefuseByPC)");
                this.f207544a = new u();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class x extends e {
        public x() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateRequest";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void i() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.Q(9, 12, true);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateExcepInvalidWhenRecv)");
                this.f207544a = new p();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. onCheckIsTooLongSession entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void k(int i3) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
            boolean z16 = true;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. onFileRequestBeHandledByPC entity is null");
                return;
            }
            if (5 != i3) {
                onlineFileSessionWorker.X();
            } else {
                onlineFileSessionWorker.Z();
            }
            if (i3 == 1) {
                OnlineFileSessionWorker.this.Q(11, 5, true);
                x("StateAcceptByPC");
                this.f207544a = new b();
            } else if (i3 == 2) {
                OnlineFileSessionWorker.this.Q(11, 6, true);
                x("StateRefuseByPC");
                this.f207544a = new u();
            } else if (i3 == 3) {
                OnlineFileSessionWorker.this.Q(11, 8, true);
                x("StateSenderCancelSend");
                this.f207544a = new ab();
            } else if (i3 == 4) {
                OnlineFileSessionWorker.this.Q(11, 7, true);
                x("StateSaveToWeiYunByPC");
                this.f207544a = new y();
            } else {
                if (i3 == 5) {
                    OnlineFileSessionWorker.this.s();
                    OnlineFileSessionWorker.this.R(11, 11);
                    OnlineFileSessionWorker.this.Q(11, 14, false);
                    x("StateUploadingWhenChangeToOff");
                    this.f207544a = new ae();
                } else {
                    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + OnlineFileSessionWorker.this.f207511b + "]  is not foud . handledbypc type error:" + i3);
                }
                z16 = false;
            }
            if (z16) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 0, null);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean o() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
            if (fileManagerEntity != null) {
                onlineFileSessionWorker.T(9, 10);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "start send recv cmd.... [" + OnlineFileSessionWorker.this.f207522m.f207524a + "-" + OnlineFileSessionWorker.this.f207522m.f207525b + "]");
                boolean t16 = OnlineFileSessionWorker.this.t(fileManagerEntity.peerUin, fileManagerEntity.nOLfileSessionId);
                if (t16) {
                    OnlineFileSessionWorker.this.h(9, 15);
                    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateWaitResultWhenRecv)");
                    this.f207544a = new ak();
                } else {
                    OnlineFileSessionWorker.this.h(9, 10);
                    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateChangeToOffFailedWhenRecv)");
                    this.f207544a = new j();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("OLfilesession[");
                    sb5.append(OnlineFileSessionWorker.this.f207511b);
                    sb5.append("]  failure to send recv cmd!!! ");
                    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, sb5.toString());
                }
                OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 10, null, 6, null);
                return t16;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
            return false;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void r() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
            if (fileManagerEntity != null) {
                onlineFileSessionWorker.Q(11, 9, true);
                OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 5, null);
                x("StateCancelUploadWhenRecv");
                this.f207544a = new h();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean t(int i3, String str, long j3) {
            String str2;
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
                return false;
            }
            fileManagerEntity.Uuid = new String(str);
            fileManagerEntity.fProgress = 0.0f;
            if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0 && (str2 = fileManagerEntity.Uuid) != null && str2.length() != 0) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerEngine().m(fileManagerEntity, 7);
            }
            fileManagerEntity.setCloudType(1);
            OnlineFileSessionWorker.this.Q(1, -1, true);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateGotoOffFileProcess)");
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().b(true, 22, new Object[]{Long.valueOf(fileManagerEntity.nSessionId), Long.valueOf(fileManagerEntity.nOLfileSessionId)});
            this.f207544a = new q();
            return true;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void u(int i3, String str) {
            super.u(i3, str);
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void v(int i3, int i16) {
            OnlineFileSessionWorker.this.s();
            d(i3, i16);
            OnlineFileSessionWorker.this.R(11, 11);
            OnlineFileSessionWorker.this.Q(11, 14, false);
            x("StateUploadingWhenChangeToOff");
            this.f207544a = new ae();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class y extends m {
        public y() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.m, com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateSaveToWeiYunByPC";
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class z extends e {
        public z() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateSaveToWeiYunByPCWhenPause";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void q() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(11, 7);
                OnlineFileSessionWorker.this.h(11, 7);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateSaveToWeiYunByPC)");
                this.f207544a = new y();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }
    }

    public OnlineFileSessionWorker(QQAppInterface qQAppInterface, long j3) {
        this.f207510a = qQAppInterface;
        this.f207511b = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i3, int i16, boolean z16) {
        if (this.f207513d == null) {
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] setCurStateOfEntityTo can not find entity . state change :(" + this.f207512c.c() + "-> StateEnd)");
            this.f207512c = new m();
            return;
        }
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state:" + this.f207512c.c() + " curstate of entity change: (opType:" + this.f207513d.nOpType + " status:" + this.f207513d.status + ") -> (opType:" + i3 + "  status:" + i16 + ") savedb=" + z16);
        FileManagerEntity fileManagerEntity = this.f207513d;
        fileManagerEntity.nOpType = i3;
        fileManagerEntity.status = i16;
        if (z16) {
            this.f207510a.getFileManagerDataCenter().f0(this.f207513d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i3, int i16) {
        FileManagerEntity fileManagerEntity = this.f207513d;
        if (fileManagerEntity == null) {
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] setDBStateOfEntityTo can not find entity . state change :(" + this.f207512c.c() + "-> StateEnd)");
            this.f207512c = new m();
            return;
        }
        FileManagerEntity m177clone = fileManagerEntity.m177clone();
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state:" + this.f207512c.c() + " curstate: (opType:" + this.f207513d.nOpType + " status:" + this.f207513d.status + ").  save state:(opType:" + i3 + "  status:" + i16 + ") to DB");
        m177clone.nOpType = i3;
        m177clone.status = i16;
        this.f207510a.getFileManagerDataCenter().f0(m177clone);
    }

    private boolean S(int i3, int i16) {
        boolean m3;
        if (i3 != -1) {
            if (i3 != 1) {
                if (i3 != 13) {
                    switch (i3) {
                        case 9:
                            m3 = k(i16);
                            break;
                        case 10:
                            m3 = l(i16);
                            break;
                        case 11:
                            m3 = i(i16);
                            break;
                        default:
                            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] error optype:" + i3);
                            m3 = false;
                            break;
                    }
                } else {
                    m3 = j(i16);
                }
            } else {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateGotoOffFileProcess)");
                this.f207512c = new q();
                m3 = true;
            }
        } else {
            m3 = m(i16);
        }
        if (!m3) {
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] goto next state failed. state change :(" + this.f207512c.c() + "-> StateEnd)");
            this.f207512c = new m();
        }
        return m3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i3, int i16) {
        FileManagerEntity fileManagerEntity = this.f207513d;
        if (fileManagerEntity == null) {
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] setStateToDatabase can not find entity . state change :(" + this.f207512c.c() + "-> StateEnd)");
            this.f207512c = new m();
            return;
        }
        FileManagerEntity m177clone = fileManagerEntity.m177clone();
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "] current status(opType:" + m177clone.nOpType + " status:" + m177clone.status + "). saveto db(opType:" + i3 + "  status:" + i16 + ")");
        if (-2 != i3) {
            m177clone.nOpType = i3;
        }
        if (-2 != i16) {
            m177clone.status = i16;
        }
        this.f207510a.getFileManagerDataCenter().f0(m177clone);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i3, int i16) {
        FileManagerEntity fileManagerEntity = this.f207513d;
        if (fileManagerEntity != null) {
            fileManagerEntity.nOpType = i3;
            fileManagerEntity.status = i16;
        }
    }

    private boolean i(int i3) {
        switch (i3) {
            case 4:
            case 10:
            case 15:
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] can not set the status. when BE_PC_HANDLED:" + i3);
                return false;
            case 5:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateAcceptByPC)");
                this.f207512c = new b();
                break;
            case 6:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateRefuseByPC)");
                this.f207512c = new u();
                break;
            case 7:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateSaveToWeiYunByPC)");
                this.f207512c = new y();
                break;
            case 8:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateSenderCancelSend)");
                this.f207512c = new ab();
                break;
            case 9:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateCancelUploadWhenChangeToOff)");
                this.f207512c = new f();
                break;
            case 11:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateLocalFailedWhenChangeToOff)");
                this.f207512c = new r();
                break;
            case 12:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateExcepInvalidWhenChangeToOff)");
                this.f207512c = new n();
                break;
            case 13:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateUploadoneWhenChangeToOff)");
                this.f207512c = new ah();
                break;
            case 14:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateUploadingWhenChangeToOff)");
                this.f207512c = new ae();
                break;
            default:
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] no status. when BE_PC_HANDLED:" + i3);
                return false;
        }
        return true;
    }

    private boolean j(int i3) {
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 7) {
                    if (i3 != 8) {
                        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] can not set the status. when BE_PC_HANDLED_ON_RECV2OFF_FAILED:" + i3);
                        return false;
                    }
                    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateSenderCancelSendWhenToOffFailed)");
                    this.f207512c = new ad();
                    return true;
                }
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateSaveToWeiYunByPCWhenToOffFailed)");
                this.f207512c = new aa();
                return true;
            }
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateRefuseByPCWhenToOffFailed)");
            this.f207512c = new w();
            return true;
        }
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateAcceptByPCWhenToOffFailed)");
        this.f207512c = new d();
        return true;
    }

    private boolean k(int i3) {
        switch (i3) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 13:
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] can not set the status. when GOTO_UPLOAD:" + i3);
                return false;
            case 9:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateCancelUploadWhenRecv)");
                this.f207512c = new h();
                break;
            case 10:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateChangeToOffFailedWhenRecv)");
                this.f207512c = new j();
                break;
            case 11:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateLocalFailedWhenRecv)");
                this.f207512c = new t();
                break;
            case 12:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateExcepInvalidWhenRecv)");
                this.f207512c = new p();
                break;
            case 14:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateUploadingWhenRecv)");
                this.f207512c = new ag();
                break;
            case 15:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateWaitResultWhenRecv)");
                this.f207512c = new ak();
                break;
            default:
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] no status. when GOTO_UPLOAD:" + i3);
                return false;
        }
        return true;
    }

    private boolean l(int i3) {
        switch (i3) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 13:
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] can not set the status. when STOP_UPLOAD:" + i3);
                return false;
            case 9:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateCancelUploadWhenPause)");
                this.f207512c = new g();
                break;
            case 10:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateChangeToOffFailedWhenPause)");
                this.f207512c = new i();
                break;
            case 11:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateLocalFailedWhenPause)");
                this.f207512c = new s();
                break;
            case 12:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateExcepInvalidWhenPause)");
                this.f207512c = new o();
                break;
            case 14:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateUploadingWhenPause)");
                this.f207512c = new af();
                break;
            case 15:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateWaitResultWhenPause)");
                this.f207512c = new aj();
                break;
            default:
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] no status. when STOP_UPLOAD:" + i3);
                return false;
        }
        return true;
    }

    private boolean m(int i3) {
        switch (i3) {
            case 4:
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state change :(" + this.f207512c.c() + "->StateRequest)");
                this.f207512c = new x();
                return true;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] can not set the status. when TYPE_UNKNOW:" + i3);
                return false;
            default:
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] no status. when TYPE_UNKNOW:" + i3);
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        FileManagerEntity fileManagerEntity = this.f207513d;
        if (fileManagerEntity != null) {
            if (0 != fileManagerEntity.lastTime) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state :" + this.f207512c.c() + " initForMakeProgress. but had init. lastTime =" + this.f207513d.lastTime);
            }
            this.f207513d.lastTime = System.currentTimeMillis();
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state :" + this.f207512c.c() + " initForMakeProgress lastTime =" + this.f207513d.lastTime);
        }
    }

    public void A() {
        if (this.f207513d == null) {
            return;
        }
        long K0 = com.tencent.mobileqq.service.message.e.K0();
        if (this.f207513d.getCloudType() == 0 && K0 - this.f207513d.srvTime > 172800) {
            QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] state :" + this.f207512c.c() + " is too long session and invaild!!!! invaild time=172800");
            this.f207512c.i();
            this.f207512c = this.f207512c.b();
        }
    }

    public void B() {
        this.f207512c.a();
        this.f207512c = this.f207512c.b();
    }

    public void C(int i3) {
        this.f207512c.k(i3);
        this.f207512c = this.f207512c.b();
        n();
    }

    public void D(long j3) {
        this.f207512c.l(j3);
        this.f207512c = this.f207512c.b();
    }

    public void E(int i3) {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "]  state:" + this.f207512c.c() + " stopWaitSenderReplayOnRecvTimer ant stopWaitAskUpProgressResultTimer. when onNetworkChanged");
        X();
        this.f207512c.j(1);
        this.f207512c = this.f207512c.b();
    }

    public void F() {
        this.f207512c.m();
        this.f207512c = this.f207512c.b();
    }

    public void G() {
        this.f207512c.n();
        this.f207512c = this.f207512c.b();
    }

    public boolean H() {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "]  state:" + this.f207512c.c() + " user recv online file....!!");
        boolean o16 = this.f207512c.o();
        this.f207512c = this.f207512c.b();
        return o16;
    }

    public void I(boolean z16) {
        if (z16) {
            this.f207522m.f207524a++;
            V();
        } else {
            this.f207522m.f207525b++;
        }
        this.f207512c.p(z16);
        this.f207512c = this.f207512c.b();
    }

    public void J() {
        this.f207512c.q();
        this.f207512c = this.f207512c.b();
    }

    public void K() {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "]  state:" + this.f207512c.c() + " stopWaitSenderReplayOnRecvTimer ant stopWaitAskUpProgressResultTimer. when onSenderCancelUpload");
        X();
        this.f207512c.r();
        this.f207512c = this.f207512c.b();
    }

    public void L() {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "]  state:" + this.f207512c.c() + " stopWaitSenderReplayOnRecvTimer. stopWaitAskUpProgressResultTimer. when onSenderReplayComeOnRecv");
        Z();
        Y();
        this.f207512c.s();
        this.f207512c = this.f207512c.b();
    }

    public boolean M(int i3, String str, long j3) {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "]  state:" + this.f207512c.c() + " stopWaitSenderReplayOnRecvTimer ant stopWaitAskUpProgressResultTimer. when onSenderUploadCompleted");
        X();
        boolean t16 = this.f207512c.t(i3, str, j3);
        this.f207512c = this.f207512c.b();
        return t16;
    }

    public void N(int i3, String str) {
        this.f207512c.u(i3, str);
        this.f207512c = this.f207512c.b();
    }

    public void O(int i3, int i16) {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "]  state:" + this.f207512c.c() + " stopWaitAskUpProgressResultTimer. stopWaitSenderReplayOnRecvTimer. when onSenderUploadProgressNotify");
        Y();
        Z();
        this.f207512c.v(i3, i16);
        this.f207512c = this.f207512c.b();
    }

    void P(long j3, String str) {
        MessageRecord messageRecord;
        if (j3 != 0 && j3 != this.f207521l) {
            boolean z16 = false;
            List<MessageRecord> Q = this.f207510a.getMessageFacade().Q(str, 0);
            if (Q != null && !Q.isEmpty()) {
                for (int size = Q.size() - 1; size >= 0; size--) {
                    messageRecord = Q.get(size);
                    if (!com.tencent.mobileqq.service.message.remote.a.c(messageRecord.issend)) {
                        break;
                    }
                }
            }
            messageRecord = null;
            if (messageRecord == null || messageRecord.isread) {
                z16 = true;
            }
            if (z16) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] setMsgReadedAndReport curFriendUin is " + str + ", shmsgseq  is " + j3);
                ArrayList<Pair<Long, Long>> arrayList = new ArrayList<>();
                arrayList.add(new Pair<>(Long.valueOf(str), Long.valueOf(j3)));
                ((com.tencent.imcore.message.i) this.f207510a.getMsgHandler().getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_C2C)).T0(arrayList);
                this.f207521l = j3;
            }
        }
    }

    void U(long j3) {
        if (0 == j3) {
            if (FileManagerUtil.is2GOr3G()) {
                j3 = 50000;
            } else {
                j3 = 30000;
            }
        }
        synchronized (this.f207517h) {
            if (this.f207516g != null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "] state:" + this.f207512c.c() + " failure to startWaitAskUpProgressResultTimer ant it is runing");
                return;
            }
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "] state:" + this.f207512c.c() + " startWaitAskUpProgressResultTimer. outTimerInterval=" + j3);
            BaseTimer baseTimer = new BaseTimer();
            this.f207516g = baseTimer;
            baseTimer.schedule(new TimerTask() { // from class: com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207513d.nSessionId + "] state:" + OnlineFileSessionWorker.this.f207512c.c() + " WaitAskUpProgressResultTimer time out!!!!!!!");
                    OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().b(true, 43, new Object[]{Long.valueOf(OnlineFileSessionWorker.this.f207513d.nSessionId)});
                    OnlineFileSessionWorker.this.Y();
                }
            }, j3);
        }
    }

    void V() {
        long j3;
        if (FileManagerUtil.is2GOr3G()) {
            j3 = 50000;
        } else {
            j3 = 30000;
        }
        synchronized (this.f207515f) {
            if (this.f207514e != null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "] state:" + this.f207512c.c() + " failure to startWaitSenderReplayOnRecvTimer ant it is runing");
                return;
            }
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "] state:" + this.f207512c.c() + " startWaitSenderReplayOnRecvTimer. outTimerInterval=" + j3);
            BaseTimer baseTimer = new BaseTimer();
            this.f207514e = baseTimer;
            baseTimer.schedule(new TimerTask() { // from class: com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207513d.nSessionId + "] state:" + OnlineFileSessionWorker.this.f207512c.c() + " WaitSenderReplayOnRecvTimer time out!!!!!!!");
                    OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().b(true, 42, new Object[]{Long.valueOf(OnlineFileSessionWorker.this.f207513d.nSessionId)});
                    OnlineFileSessionWorker.this.Z();
                }
            }, j3);
        }
    }

    public void W() {
        if (this.f207512c != null && this.f207513d != null) {
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "]  state:" + this.f207512c.c() + " stop worker...");
            X();
            this.f207512c.w();
            this.f207513d = null;
            this.f207511b = 0L;
            this.f207512c = this.f207512c.b();
        }
    }

    void X() {
        Z();
        Y();
    }

    void Y() {
        synchronized (this.f207517h) {
            Timer timer = this.f207516g;
            if (timer != null) {
                timer.cancel();
                this.f207516g = null;
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "]  state:" + this.f207512c.c() + " stopWaitAskUpProgressResultTimer");
            } else {
                QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "]  state:" + this.f207512c.c() + " stopWaitAskUpProgressResultTimer.but timer had stop");
            }
        }
    }

    void Z() {
        synchronized (this.f207515f) {
            Timer timer = this.f207514e;
            if (timer != null) {
                timer.cancel();
                this.f207514e = null;
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "]  state:" + this.f207512c.c() + " stopWaitSenderReplayOnRecvTimer");
            } else {
                QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "]  state:" + this.f207512c.c() + " stopWaitSenderReplayOnRecvTimer.but timer had stop");
            }
        }
    }

    boolean a0() {
        a aVar = this.f207522m;
        if (!aVar.f207528e) {
            return true;
        }
        if (aVar.f207526c && aVar.f207527d) {
            return true;
        }
        return false;
    }

    boolean g(boolean z16, long j3) {
        if (this.f207516g == null) {
            FileManagerEntity fileManagerEntity = this.f207513d;
            if (fileManagerEntity == null) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "]. askUpProgress entity is null");
                return false;
            }
            int i3 = fileManagerEntity.nOlSenderProgress;
            FileTransferHandler fileTransferHandler = this.f207510a.getFileTransferHandler();
            FileManagerEntity fileManagerEntity2 = this.f207513d;
            boolean Y0 = fileTransferHandler.Y0(fileManagerEntity2.peerUin, fileManagerEntity2.nOLfileSessionId);
            this.f207518i++;
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "] state:" + this.f207512c.c() + " ask upload progress isSuccess = " + Y0 + ". askUpProgressCount=" + this.f207518i);
            if (Y0) {
                U(j3);
            }
            return Y0;
        }
        QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "]. askUpProgress is going on. return");
        return false;
    }

    void n() {
        FileManagerEntity fileManagerEntity = this.f207513d;
        if (fileManagerEntity != null) {
            int i3 = fileManagerEntity.status;
            if (5 == i3 || 6 == i3 || 7 == i3) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "]  state:" + this.f207512c.c() + " checkAndDeleteRecordFromFM mEntity.nOpType = " + this.f207513d.nOpType);
                this.f207513d.bDelInFM = true;
                this.f207510a.getFileManagerProxy().o(this.f207513d, false);
                this.f207510a.getFileManagerNotifyCenter().b(true, 3, null);
                return;
            }
            return;
        }
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[]  state:" + this.f207512c.c() + " checkAndDeleteRecordFromFM. mEntity = null");
    }

    boolean o() {
        FileManagerEntity fileManagerEntity = this.f207513d;
        if (fileManagerEntity == null) {
            return false;
        }
        if (fileManagerEntity.nOlSenderProgress == 0 && fileManagerEntity.fOlRecvSpeed <= 1.0E-7f) {
            return false;
        }
        return true;
    }

    boolean p() {
        FileManagerEntity fileManagerEntity = this.f207513d;
        if (fileManagerEntity == null || -1 == fileManagerEntity.nOlSenderProgress) {
            return false;
        }
        return true;
    }

    void q(int i3) {
        if (1 == i3) {
            if (this.f207522m.f207528e) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "]  state:" + this.f207512c.c() + " recv olfile is going on. but the resp of sender is error");
                this.f207522m.f207526c = true;
                return;
            }
            return;
        }
        if (2 == i3 && this.f207522m.f207528e) {
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "]  state:" + this.f207512c.c() + " recv olfile is going on. but the resp of ask progress is error");
            this.f207522m.f207527d = true;
        }
    }

    public boolean r(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] init failed. state change :(" + this.f207512c.c() + "-> StateEnd)");
            this.f207512c = new m();
            return false;
        }
        this.f207513d = fileManagerEntity;
        boolean S = S(fileManagerEntity.nOpType, fileManagerEntity.status);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "] init state to:" + this.f207512c.c());
        return S;
    }

    boolean t(String str, long j3) {
        if (this.f207522m.f207528e) {
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "]  state:" + this.f207512c.c() + " internalRecvOnlineFile. recv is going on, why?? ");
        }
        boolean b16 = this.f207510a.getFileTransferHandler().b1(str, j3);
        if (!b16) {
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "]  state:" + this.f207512c.c() + " internalRecvOnlineFile. recv cmd send failed.... ");
            a aVar = this.f207522m;
            aVar.f207525b = aVar.f207525b + 1;
        } else {
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "]  state:" + this.f207512c.c() + " internalRecvOnlineFile. recv cmd send success, and will ask progress .... ");
            a aVar2 = this.f207522m;
            aVar2.f207528e = true;
            aVar2.f207526c = false;
            aVar2.f207527d = false;
            if (!g(true, 0L)) {
                QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207511b + "]  state:" + this.f207512c.c() + " internalRecvOnlineFile. ask progress failed.... ");
                q(2);
            }
        }
        return b16;
    }

    void u(boolean z16) {
        a aVar = this.f207522m;
        if (aVar.f207528e) {
            aVar.f207528e = false;
            aVar.f207526c = false;
            aVar.f207527d = false;
            if (z16) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.f207511b + "]  internalRecvOnlineFileOver.recv success!!");
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.f207511b + "]  internalRecvOnlineFileOver.recv failed!!");
        }
    }

    public boolean v() {
        return this.f207512c.f207545b;
    }

    void w(final float f16) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.3
            @Override // java.lang.Runnable
            public void run() {
                float f17;
                FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
                if (fileManagerEntity == null) {
                    return;
                }
                while (true) {
                    f17 = fileManagerEntity.fProgress;
                    float f18 = f16;
                    if (f17 >= f18) {
                        break;
                    }
                    OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
                    if (onlineFileSessionWorker.f207513d == null) {
                        break;
                    }
                    float f19 = f17 + 0.05f;
                    if (f19 > f18) {
                        fileManagerEntity.fProgress = f18;
                    } else {
                        fileManagerEntity.fProgress = f19;
                    }
                    onlineFileSessionWorker.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 16, null, 0, null);
                    try {
                        LockMethodProxy.sleep(100L);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
                if (f17 >= 1.0f && OnlineFileSessionWorker.this.f207513d != null) {
                    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + fileManagerEntity.nSessionId + "] state:" + OnlineFileSessionWorker.this.f207512c.c() + " make progress. direct pass to 1.0 and notify make done");
                    OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().b(true, 41, new Object[]{Long.valueOf(fileManagerEntity.nSessionId)});
                }
            }
        }, 8, null, true);
    }

    public void x(boolean z16) {
        if (!z16) {
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "]  state:" + this.f207512c.c() + " stopWaitAskUpProgressResultTimer. when onAskSenderUpProgressResult = false");
            Y();
        }
        this.f207512c.f(z16);
        this.f207512c = this.f207512c.b();
    }

    public void y() {
        this.f207512c.g();
        this.f207512c = this.f207512c.b();
    }

    public void z() {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.f207513d.nSessionId + "]  state:" + this.f207512c.c() + " stopWaitAskUpProgressResultTimer. when onAskUpProgressAndSessionInvaid");
        Y();
        this.f207512c.h();
        this.f207512c = this.f207512c.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ae extends e {
        public ae() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateUploadingWhenChangeToOff";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void l(long j3) {
            e(j3);
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean o() {
            if (!y("onRecvOnLineFile")) {
                OnlineFileSessionWorker.this.R(9, 11);
                OnlineFileSessionWorker.this.Q(9, 14, false);
                x("StateUploadingWhenRecv");
                this.f207544a = new ag();
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void r() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(11, 9);
                OnlineFileSessionWorker.this.h(11, 9);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateCancelUploadWhenRecv)");
                this.f207544a = new h();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean t(int i3, String str, long j3) {
            String str2;
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
                return false;
            }
            fileManagerEntity.Uuid = new String(str);
            fileManagerEntity.fProgress = 0.0f;
            if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0 && (str2 = fileManagerEntity.Uuid) != null && str2.length() != 0) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerEngine().m(fileManagerEntity, 7);
            }
            fileManagerEntity.setCloudType(1);
            OnlineFileSessionWorker.this.T(11, 13);
            OnlineFileSessionWorker.this.h(11, 13);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadoneWhenChangeToOff)");
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().b(true, 22, new Object[]{Long.valueOf(fileManagerEntity.nSessionId), Long.valueOf(fileManagerEntity.nOLfileSessionId)});
            this.f207544a = new ah();
            return true;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void u(int i3, String str) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(11, 12);
                OnlineFileSessionWorker.this.h(11, 12);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateExcepInvalidWhenChangeToOff");
                this.f207544a = new n();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void v(int i3, int i16) {
            d(i3, i16);
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void w() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ak extends e {
        public ak() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void a() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "StateWaitResultWhenRecv OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. doSomeThingOnUploadDone entity is null");
                return;
            }
            onlineFileSessionWorker.f207510a.getFileManagerNotifyCenter().b(true, 22, new Object[]{Long.valueOf(fileManagerEntity.nSessionId), Long.valueOf(fileManagerEntity.nOLfileSessionId)});
            fileManagerEntity.fProgress = 0.0f;
            fileManagerEntity.setCloudType(1);
            OnlineFileSessionWorker.this.T(1, 0);
            OnlineFileSessionWorker.this.h(1, 2);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "StateWaitResultWhenRecv OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + ". doSomeThingOnUploadDone start recv offline file....)");
            OnlineFileSessionWorker.this.f207510a.getFileManagerRSCenter().g(OnlineFileSessionWorker.this.f207511b, fileManagerEntity.uniseq, fileManagerEntity.peerUin, fileManagerEntity.peerType, 1);
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 10, null, 6, null);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "StateWaitResultWhenRecv OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateGotoOffFileProcess)");
            this.f207544a = new q();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateWaitResultWhenRecv";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void f(boolean z16) {
            if (y("onAskSenderUpProgressResult")) {
                return;
            }
            if (z16) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + " recv  success response of ask progress,  waiting the notify of progress");
                return;
            }
            OnlineFileSessionWorker.this.q(2);
            if (!OnlineFileSessionWorker.this.a0()) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. state:" + this.f207544a.c() + "ask progress server result = false and no handle it. here waiting response of sender on recv");
                return;
            }
            OnlineFileSessionWorker.this.u(false);
            OnlineFileSessionWorker.this.T(9, 10);
            OnlineFileSessionWorker.this.h(9, 10);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateChangeToOffFailedWhenRecv)");
            this.f207544a = new j();
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
            onlineFileSessionWorker.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 6, null);
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void g() {
            if (y("onAskSenderUpProgressTimeOut")) {
                return;
            }
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. state:" + this.f207544a.c() + " you had recv the file, but  ask progress time out!!!!, recvCmdSucAndHadTryCount =" + OnlineFileSessionWorker.this.f207522m.f207524a);
            OnlineFileSessionWorker.this.q(2);
            if (!OnlineFileSessionWorker.this.a0()) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. state:" + this.f207544a.c() + " ask progress time out and no handle it. here waiting response of sender when recv");
                return;
            }
            OnlineFileSessionWorker.this.u(false);
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207522m.f207524a < Long.MAX_VALUE) {
                onlineFileSessionWorker.Q(9, 10, true);
                x("StateChangeToOffFailedWhenRecv");
                this.f207544a = new j();
                OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 15, null);
                return;
            }
            onlineFileSessionWorker.Q(9, 12, true);
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 5, null);
            x("StateExcepInvalidWhenRecv");
            this.f207544a = new p();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void j(int i3) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
            if (fileManagerEntity != null) {
                onlineFileSessionWorker.T(9, 10);
                OnlineFileSessionWorker.this.h(9, 10);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateChangeToOffFailedWhenRecv)");
                this.f207544a = new j();
                OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 6, null);
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. onFailedOfLocalSomeThingHappen entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void k(int i3) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
            boolean z16 = true;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. onFileRequestBeHandledByPC entity is null");
                return;
            }
            if (5 != i3) {
                onlineFileSessionWorker.X();
            } else {
                onlineFileSessionWorker.X();
            }
            if (i3 == 1) {
                OnlineFileSessionWorker.this.T(11, 5);
                OnlineFileSessionWorker.this.h(11, 5);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateAcceptByPC)");
                this.f207544a = new b();
            } else if (i3 == 2) {
                OnlineFileSessionWorker.this.T(11, 6);
                OnlineFileSessionWorker.this.h(11, 6);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateRefuseByPC)");
                this.f207544a = new u();
            } else if (i3 == 3) {
                OnlineFileSessionWorker.this.T(11, 8);
                OnlineFileSessionWorker.this.h(11, 8);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateSenderCancelSend)");
                this.f207544a = new ab();
            } else if (i3 == 4) {
                OnlineFileSessionWorker.this.T(11, 7);
                OnlineFileSessionWorker.this.h(11, 7);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateSaveToWeiYunByPC)");
                this.f207544a = new y();
            } else {
                if (i3 == 5) {
                    OnlineFileSessionWorker.this.s();
                    OnlineFileSessionWorker.this.T(9, 11);
                    OnlineFileSessionWorker.this.h(9, 14);
                    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadingWhenRecv)");
                    this.f207544a = new ag();
                } else {
                    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + OnlineFileSessionWorker.this.f207511b + "]  is not foud . handledbypc type error:" + i3);
                }
                z16 = false;
            }
            if (z16) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 0, null);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void m() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.T(10, -2);
                OnlineFileSessionWorker.this.h(10, 15);
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateWaitResultWhenPause)");
                this.f207544a = new aj();
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. onPauseTrans entity is null");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void n() {
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. state:" + this.f207544a.c() + " onRecvButSenderReplayTimeOut entity is null");
                return;
            }
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. state:" + this.f207544a.c() + " you had recv the file, but sender replay time out!!!!, recvCmdSucAndHadTryCount =" + OnlineFileSessionWorker.this.f207522m.f207524a);
            OnlineFileSessionWorker.this.q(1);
            if (!OnlineFileSessionWorker.this.a0()) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. state:" + this.f207544a.c() + " sender replay time out and no handle it. here waiting response of asking progress");
                return;
            }
            OnlineFileSessionWorker.this.u(false);
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207522m.f207524a < Long.MAX_VALUE) {
                onlineFileSessionWorker.Q(9, 10, true);
                x("StateChangeToOffFailedWhenRecv");
                this.f207544a = new j();
                OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 15, null);
                return;
            }
            onlineFileSessionWorker.Q(9, 12, true);
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 5, null);
            x("StateExcepInvalidWhenRecv");
            this.f207544a = new p();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void p(boolean z16) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
            if (fileManagerEntity == null) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. StateWaitingRecvResult entity is null");
                return;
            }
            if (z16) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + " recv  success response of accept,  waiting the cmd of starting upload");
                return;
            }
            onlineFileSessionWorker.q(1);
            if (!OnlineFileSessionWorker.this.a0()) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. state:" + this.f207544a.c() + " recvonlinefile result = false and no handle it. here waiting response of asking progress");
                return;
            }
            OnlineFileSessionWorker.this.u(false);
            OnlineFileSessionWorker.this.T(9, 10);
            OnlineFileSessionWorker.this.h(9, 10);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateChangeToOffFailedWhenRecv)");
            this.f207544a = new j();
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 6, null);
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + OnlineFileSessionWorker.this.f207511b + "]  recv failed!!");
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void r() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.Q(11, 9, true);
                x("StateCancelUploadWhenRecv");
                this.f207544a = new h();
            } else {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void s() {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d == null) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. onSenderReplayComeOnRecv entity is null");
                return;
            }
            onlineFileSessionWorker.u(true);
            OnlineFileSessionWorker.this.s();
            OnlineFileSessionWorker.this.T(9, 11);
            OnlineFileSessionWorker.this.h(9, 14);
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateUploadingWhenRecv)");
            this.f207544a = new ag();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean t(int i3, String str, long j3) {
            String str2;
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
                return false;
            }
            fileManagerEntity.Uuid = new String(str);
            if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0 && (str2 = fileManagerEntity.Uuid) != null && str2.length() != 0) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerEngine().m(fileManagerEntity, 7);
            }
            OnlineFileSessionWorker.this.P(j3, fileManagerEntity.peerUin);
            if (fileManagerEntity.fProgress < 0.9f) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. start make progress pass to 100% directly");
                this.f207546c = true;
                OnlineFileSessionWorker.this.w(1.0f);
            } else {
                a();
            }
            return true;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void u(int i3, String str) {
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d != null) {
                onlineFileSessionWorker.Q(9, 12, true);
                x("StateExcepInvalidWhenRecv");
                this.f207544a = new p();
            } else {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void v(int i3, int i16) {
            if (y("onSenderUploadProgressNotify")) {
                return;
            }
            OnlineFileSessionWorker.this.u(true);
            OnlineFileSessionWorker.this.s();
            d(i3, i16);
            OnlineFileSessionWorker.this.R(9, 11);
            OnlineFileSessionWorker.this.Q(9, 14, false);
            x("StateUploadingWhenRecv");
            this.f207544a = new ag();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void w() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        protected e f207544a = this;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f207545b = false;

        /* renamed from: c, reason: collision with root package name */
        protected boolean f207546c = false;

        e() {
        }

        protected void a() {
            QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]  state:" + OnlineFileSessionWorker.this.f207512c.c() + " can not handle doSomeThingOnUploadDone:");
        }

        e b() {
            return this.f207544a;
        }

        protected String c() {
            return "StateBase";
        }

        protected final void d(int i3, int i16) {
            int i17;
            boolean z16;
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] make progress entity = null.handleProgressNotify");
                return;
            }
            if (i16 > 100) {
                QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] handleProgressNotify progress > 100. progress=" + i16);
                return;
            }
            if (i3 == 0 || (i16 <= (i17 = fileManagerEntity.nOlSenderProgress) && (i17 != 0 || fileManagerEntity.fOlRecvSpeed > 1.0E-7f))) {
                z16 = true;
            } else {
                z16 = false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (z16) {
                QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]  handleProgressNotify. state:" + OnlineFileSessionWorker.this.f207512c.c() + ". averspeed = " + i3 + ". progress = " + i16 + ". nOlSenderProgress =" + OnlineFileSessionWorker.this.f207513d.nOlSenderProgress + ". err notify. return");
                OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
                FileManagerEntity fileManagerEntity2 = onlineFileSessionWorker.f207513d;
                if (-1 == fileManagerEntity2.nOlSenderProgress) {
                    fileManagerEntity2.nOlSenderProgress = 0;
                    fileManagerEntity2.lastTime = currentTimeMillis;
                    int i18 = fileManagerEntity2.status;
                    if (i18 != 14 && i18 != 15) {
                        onlineFileSessionWorker.f207510a.getFileManagerDataCenter().f0(OnlineFileSessionWorker.this.f207513d);
                        return;
                    }
                    FileManagerEntity m177clone = fileManagerEntity2.m177clone();
                    m177clone.status = 11;
                    OnlineFileSessionWorker.this.f207510a.getFileManagerDataCenter().f0(m177clone);
                    return;
                }
                return;
            }
            this.f207546c = false;
            e(currentTimeMillis);
            FileManagerEntity fileManagerEntity3 = OnlineFileSessionWorker.this.f207513d;
            float f16 = ((100 - i16) / 100.0f) / ((i3 * 1024) / ((float) fileManagerEntity3.fileSize));
            float f17 = fileManagerEntity3.fProgress;
            fileManagerEntity3.fOlRecvSpeed = (0.9f - f17) / f16;
            fileManagerEntity3.lastTime = currentTimeMillis;
            fileManagerEntity3.nOlSenderProgress = i16;
            fileManagerEntity3.fOlRecvProgressOnNotify = f17;
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]  -----handleProgressNotify. state:" + OnlineFileSessionWorker.this.f207512c.c() + ". averspeed = " + i3 + ". progress = " + i16 + ". fOlRecvSpeed = " + OnlineFileSessionWorker.this.f207513d.fOlRecvSpeed + "f/s. fOlRecvProgressOnNotify =" + OnlineFileSessionWorker.this.f207513d.fOlRecvProgressOnNotify);
            OnlineFileSessionWorker onlineFileSessionWorker2 = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity4 = onlineFileSessionWorker2.f207513d;
            int i19 = fileManagerEntity4.status;
            if (i19 != 14 && i19 != 15) {
                onlineFileSessionWorker2.f207510a.getFileManagerDataCenter().f0(OnlineFileSessionWorker.this.f207513d);
                return;
            }
            FileManagerEntity m177clone2 = fileManagerEntity4.m177clone();
            m177clone2.status = 11;
            OnlineFileSessionWorker.this.f207510a.getFileManagerDataCenter().f0(m177clone2);
        }

        protected final void e(long j3) {
            long j16;
            float f16;
            OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
            if (onlineFileSessionWorker.f207513d == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] make progress entity = null.makeProgress");
                return;
            }
            if (this.f207546c || !onlineFileSessionWorker.p()) {
                return;
            }
            OnlineFileSessionWorker onlineFileSessionWorker2 = OnlineFileSessionWorker.this;
            if (0 == onlineFileSessionWorker2.f207520k) {
                onlineFileSessionWorker2.f207520k = FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE;
                long j17 = onlineFileSessionWorker2.f207513d.fileSize;
                long j18 = ((float) j17) * 0.1f;
                if (j17 > GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                    onlineFileSessionWorker2.f207520k = j18 / 60;
                    if (j17 > QZoneHelper.Constants.SUPPORT_MIX_MUSIC_DEFAULT) {
                        onlineFileSessionWorker2.f207520k = j18 / 120;
                        if (j17 > 1073741824) {
                            onlineFileSessionWorker2.f207520k = j18 / 180;
                        }
                    }
                }
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207513d.nSessionId + "] initGoSpeed =" + OnlineFileSessionWorker.this.f207520k + "b/s");
            }
            OnlineFileSessionWorker onlineFileSessionWorker3 = OnlineFileSessionWorker.this;
            float f17 = onlineFileSessionWorker3.f207513d.fOlRecvSpeed;
            if (!onlineFileSessionWorker3.o()) {
                OnlineFileSessionWorker onlineFileSessionWorker4 = OnlineFileSessionWorker.this;
                long j19 = onlineFileSessionWorker4.f207513d.fileSize;
                j16 = (long) (((j19 * (1.0d - r8.fOlRecvProgressOnNotify)) / 102400.0d) * 2000.0d);
                f17 = ((float) onlineFileSessionWorker4.f207520k) / ((float) j19);
            } else {
                j16 = ((0.9f - OnlineFileSessionWorker.this.f207513d.fOlRecvProgressOnNotify) * 2000.0f) / f17;
            }
            if (j16 <= 30000) {
                j16 = 30000;
            }
            OnlineFileSessionWorker onlineFileSessionWorker5 = OnlineFileSessionWorker.this;
            FileManagerEntity fileManagerEntity = onlineFileSessionWorker5.f207513d;
            long j26 = fileManagerEntity.lastTime;
            if (j3 - j26 > j16) {
                QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207513d.nSessionId + "] state:" + OnlineFileSessionWorker.this.f207512c.c() + " the progress maker think time out. timeOutInterval=" + j16 + "curRecvSpeed = " + f17 + ".lastTime =" + OnlineFileSessionWorker.this.f207513d.lastTime + ". makeTime =" + j3);
                if (!OnlineFileSessionWorker.this.o()) {
                    OnlineFileSessionWorker.this.g(true, 0L);
                    this.f207546c = true;
                    return;
                } else {
                    OnlineFileSessionWorker.this.g(true, 0L);
                    this.f207546c = true;
                    return;
                }
            }
            float f18 = ((float) (j3 - j26)) / 1000.0f;
            float f19 = f17 * f18;
            float f26 = fileManagerEntity.fOlRecvProgressOnNotify + f19;
            if (!onlineFileSessionWorker5.o()) {
                if (OnlineFileSessionWorker.this.f207513d.fProgress <= 0.1f) {
                    f16 = f17;
                    if (Math.abs(r3 - 0.1f) >= 1.0E-8d) {
                        if (f26 > 0.1f) {
                            OnlineFileSessionWorker.this.f207513d.fProgress = 0.1f;
                        } else {
                            OnlineFileSessionWorker.this.f207513d.fProgress = f26;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                f16 = f17;
                if (OnlineFileSessionWorker.this.f207513d.fProgress <= 0.9f && Math.abs(r3 - 0.9f) >= 1.0E-8d) {
                    if (f26 > 0.9f) {
                        OnlineFileSessionWorker.this.f207513d.fProgress = 0.9f;
                    } else {
                        OnlineFileSessionWorker.this.f207513d.fProgress = f26;
                    }
                } else {
                    return;
                }
            }
            OnlineFileSessionWorker onlineFileSessionWorker6 = OnlineFileSessionWorker.this;
            if (j3 - onlineFileSessionWorker6.f207519j > 50000) {
                onlineFileSessionWorker6.f207519j = j3;
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207513d.nSessionId + "] -----state:" + OnlineFileSessionWorker.this.f207512c.c() + " the making progress of upload is: " + OnlineFileSessionWorker.this.f207513d.fProgress + "[curRecvSpeed=" + f16 + ".maketime=" + j3 + ".lastTime=" + OnlineFileSessionWorker.this.f207513d.lastTime + "f/s. makeTime_s=" + f18 + "s. addProgress = " + f19 + ". timeOutInterval=" + j16 + ". filesize=" + OnlineFileSessionWorker.this.f207513d.fileSize + ". nOlSenderProgress=" + OnlineFileSessionWorker.this.f207513d.nOlSenderProgress + ". fOlRecvProgressOnNotify =" + OnlineFileSessionWorker.this.f207513d.fOlRecvProgressOnNotify + " ] ");
            }
            FileManagerNotifyCenter fileManagerNotifyCenter = OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter();
            FileManagerEntity fileManagerEntity2 = OnlineFileSessionWorker.this.f207513d;
            fileManagerNotifyCenter.c(fileManagerEntity2.uniseq, fileManagerEntity2.nSessionId, fileManagerEntity2.peerUin, fileManagerEntity2.peerType, 16, null, 0, null);
        }

        protected void f(boolean z16) {
            if (z16) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + " recv  success response of ask progress");
                return;
            }
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + " recv  failed response of ask progress");
            OnlineFileSessionWorker.this.Y();
            g();
        }

        protected void g() {
            u(4, null);
        }

        protected void h() {
            u(3, null);
        }

        protected void j(int i3) {
            QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]  state:" + OnlineFileSessionWorker.this.f207512c.c() + " can not handle onFailedOfLocalSomeThingHappen. type:" + i3);
        }

        protected void k(int i3) {
            String str;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                str = "unknow:" + String.valueOf(i3);
                            } else {
                                str = "(pc change to off trans)";
                            }
                        } else {
                            str = "(pc save to weiyun)";
                        }
                    } else {
                        str = "(pc cancel send";
                    }
                } else {
                    str = "(pc refuse)";
                }
            } else {
                str = "(pc accept)";
            }
            QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state:" + OnlineFileSessionWorker.this.f207512c.c() + " can not handle onFileRequestBeHandledByPC.handleType = " + str);
        }

        protected void m() {
            QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]  state:" + OnlineFileSessionWorker.this.f207512c.c() + " can not handle onPauseTrans. ");
        }

        protected void n() {
            QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]  state:" + OnlineFileSessionWorker.this.f207512c.c() + " can not handle onRecvButSenderReplayTimeOut:");
        }

        protected boolean o() {
            QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]  state:" + OnlineFileSessionWorker.this.f207512c.c() + " can not handle onRecvOnLineFile.");
            return true;
        }

        protected void p(boolean z16) {
            QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]  state:" + OnlineFileSessionWorker.this.f207512c.c() + " can not handle onRecvOnLineFileResult. ret:" + z16);
        }

        protected void q() {
            QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]  state:" + OnlineFileSessionWorker.this.f207512c.c() + " can not handle onResumeTrans. ");
        }

        protected void r() {
            QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]  state:" + OnlineFileSessionWorker.this.f207512c.c() + " can not handle onSenderCancelUpload. ");
        }

        protected void s() {
            QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]  state:" + OnlineFileSessionWorker.this.f207512c.c() + " can not handle onSenderReplayComeOnRecv:");
        }

        protected boolean t(int i3, String str, long j3) {
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            if (fileManagerEntity == null) {
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. recvOnLineFile entity is null");
                return false;
            }
            fileManagerEntity.Uuid = new String(str);
            QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]  state:" + OnlineFileSessionWorker.this.f207512c.c() + " can not handle onSenderUploadCompleted. type:" + i3 + "time:" + j3);
            return false;
        }

        protected void u(int i3, String str) {
            QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]  state:" + OnlineFileSessionWorker.this.f207512c.c() + " can not handle onSenderUploadException. errcode:" + i3 + " resason:" + str);
        }

        protected void v(int i3, int i16) {
            QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]  state:" + OnlineFileSessionWorker.this.f207512c.c() + " can not handle onSenderUploadProgressNotify. speed:" + i3 + " progress:" + i16);
        }

        protected void w() {
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->StateEnd)");
            this.f207544a = new m();
        }

        protected final void x(String str) {
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "] state change :(" + this.f207544a.c() + "->" + str + ")");
        }

        protected final boolean y(String str) {
            if (OnlineFileSessionWorker.this.f207513d == null) {
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + OnlineFileSessionWorker.this.f207511b + "]. state:" + this.f207544a.c() + str + " entity is null ");
                return true;
            }
            return false;
        }

        protected void i() {
        }

        protected void l(long j3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class r extends e {
        public r() {
            super();
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected String c() {
            return "StateLocalFailedWhenChangeToOff";
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void l(long j3) {
            e(j3);
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean o() {
            if (!y("onRecvOnLineFile")) {
                OnlineFileSessionWorker.this.R(9, 11);
                OnlineFileSessionWorker.this.Q(9, 14, false);
                x("StateUploadingWhenRecv");
                this.f207544a = new ag();
                OnlineFileSessionWorker onlineFileSessionWorker = OnlineFileSessionWorker.this;
                FileManagerEntity fileManagerEntity = onlineFileSessionWorker.f207513d;
                FileManagerNotifyCenter fileManagerNotifyCenter = onlineFileSessionWorker.f207510a.getFileManagerNotifyCenter();
                FileManagerEntity fileManagerEntity2 = OnlineFileSessionWorker.this.f207513d;
                fileManagerNotifyCenter.c(fileManagerEntity2.uniseq, fileManagerEntity2.nSessionId, fileManagerEntity2.peerUin, fileManagerEntity2.peerType, 16, null, 0, null);
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void r() {
            if (!y("onSenderCancelUpload")) {
                OnlineFileSessionWorker.this.Q(11, 9, true);
                x("StateCancelUploadWhenRecv");
                this.f207544a = new h();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected boolean t(int i3, String str, long j3) {
            String str2;
            if (y("onSenderUploadCompleted")) {
                return false;
            }
            FileManagerEntity fileManagerEntity = OnlineFileSessionWorker.this.f207513d;
            fileManagerEntity.Uuid = new String(str);
            fileManagerEntity.fProgress = 0.0f;
            if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0 && (str2 = fileManagerEntity.Uuid) != null && str2.length() != 0) {
                OnlineFileSessionWorker.this.f207510a.getFileManagerEngine().m(fileManagerEntity, 7);
            }
            fileManagerEntity.setCloudType(1);
            OnlineFileSessionWorker.this.Q(11, 13, true);
            x("StateUploadoneWhenChangeToOff");
            OnlineFileSessionWorker.this.f207510a.getFileManagerNotifyCenter().b(true, 22, new Object[]{Long.valueOf(fileManagerEntity.nSessionId), Long.valueOf(fileManagerEntity.nOLfileSessionId)});
            this.f207544a = new ah();
            return true;
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void u(int i3, String str) {
            if (!y("onSenderUploadException")) {
                OnlineFileSessionWorker.this.Q(11, 12, true);
                x("StateExcepInvalidWhenChangeToOff");
                this.f207544a = new n();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void v(int i3, int i16) {
            d(i3, i16);
        }

        @Override // com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.e
        protected void w() {
        }
    }
}

package com.tencent.qqnt.aio.helper;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.z;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/aio/helper/z;", "Lcom/tencent/aio/main/businesshelper/h;", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", "onMoveToState", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/filemanager/app/FMObserver;", "e", "Lcom/tencent/mobileqq/filemanager/app/FMObserver;", "observer", "<init>", "()V", "f", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes23.dex */
public final class z implements com.tencent.aio.main.businesshelper.h {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FMObserver observer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/helper/z$a;", "", "", CommonConstant.RETKEY.RETCODE, "Ljava/lang/String;", "RET_MSG", "TAG", "TASK_ID", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.helper.z$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JD\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0014J,\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0014J\"\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0014J2\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0014\u00a8\u0006\u0016"}, d2 = {"com/tencent/qqnt/aio/helper/z$b", "Lcom/tencent/mobileqq/filemanager/app/FMObserver;", "", "isSuccess", "", "uniseq", "sessionId", "", "strUin", "", "peerType", "errCode", "retMsg", "", ExifInterface.LATITUDE_SOUTH, "strFileId", "retCode", "k0", "j0", "isShowCancel", "muniseq", "T", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b extends FMObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) z.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f1(AppRuntime appRuntime, long j3, boolean z16, int i3, String str, z this$0, long j16) {
            com.tencent.mvi.base.route.j e16;
            Intrinsics.checkNotNullParameter(appRuntime, "$appRuntime");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FileManagerEntity D = ((QQAppInterface) appRuntime).getFileManagerDataCenter().D(j3);
            if (D == null) {
                return;
            }
            if (!z16) {
                FileManagerUtil.dealWithTransFileFaild(j3, i3, str);
                D.bDelInFM = false;
                ((IOpenWeiyunVipHelper) QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(null, i3);
            } else {
                int i16 = D.nOpType;
                if (i16 == 4 || i16 == 6 || i16 == 20) {
                    com.tencent.mobileqq.filemanager.util.ah.D(j3);
                }
            }
            com.tencent.aio.api.runtime.a aVar = this$0.aioContext;
            if (aVar != null && (e16 = aVar.e()) != null) {
                e16.h(new AIOMsgListEvent.FileTransferEndEvent(j16, z16));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g1(QQAppInterface qQAppInterface, long j3, long j16, z this$0) {
            com.tencent.mvi.base.route.j e16;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FileManagerEntity D = qQAppInterface.getFileManagerDataCenter().D(j3);
            if (D == null) {
                QLog.i("C2CAIOFileHelper", 1, "[onFileTransferProgress]: error, entity is null");
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("C2CAIOFileHelper", 4, "[onFileTransferProgress]: progress is " + (D.fProgress * 100) + ", uniseq is " + j16);
            }
            com.tencent.aio.api.runtime.a aVar = this$0.aioContext;
            if (aVar != null && (e16 = aVar.e()) != null) {
                e16.h(new AIOMsgListEvent.FileTransferProgressEvent(j16, (int) (D.fProgress * 100)));
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void S(final boolean isSuccess, final long uniseq, final long sessionId, @Nullable String strUin, int peerType, final int errCode, @Nullable final String retMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Long.valueOf(uniseq), Long.valueOf(sessionId), strUin, Integer.valueOf(peerType), Integer.valueOf(errCode), retMsg);
                return;
            }
            QLog.d("C2CAIOFileHelper", 1, "recive TransferEnd, rmove task[" + sessionId + "]! elementId is " + uniseq + ", isSuccess is " + isSuccess);
            ((IOpenWeiyunVipHelper) QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(null, errCode);
            final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null || !(peekAppRuntime instanceof QQAppInterface)) {
                return;
            }
            final z zVar = z.this;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.aa
                @Override // java.lang.Runnable
                public final void run() {
                    z.b.f1(AppRuntime.this, sessionId, isSuccess, errCode, retMsg, zVar, uniseq);
                }
            }, 32, null, false);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void T(boolean isShowCancel, final long muniseq, final long sessionId, @Nullable String strUin, int peerType) {
            final QQAppInterface qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(isShowCancel), Long.valueOf(muniseq), Long.valueOf(sessionId), strUin, Integer.valueOf(peerType));
                return;
            }
            super.T(isShowCancel, muniseq, sessionId, strUin, peerType);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                qQAppInterface = (QQAppInterface) peekAppRuntime;
            } else {
                qQAppInterface = null;
            }
            if (qQAppInterface == null) {
                QLog.e("C2CAIOFileHelper", 1, "[onFileTransferProgress]: error, mApp == null");
            } else {
                final z zVar = z.this;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.ab
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.b.g1(QQAppInterface.this, sessionId, muniseq, zVar);
                    }
                }, 32, null, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void j0(int retCode, long sessionId, @Nullable String retMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(retCode), Long.valueOf(sessionId), retMsg);
                return;
            }
            super.j0(retCode, sessionId, retMsg);
            com.tencent.mobileqq.filemanager.util.ah.C(sessionId, retCode, retMsg);
            ((IOpenWeiyunVipHelper) QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(null, retCode);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void k0(long sessionId, @Nullable String strFileId, int retCode, @Nullable String retMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Long.valueOf(sessionId), strFileId, Integer.valueOf(retCode), retMsg);
            } else {
                super.k0(sessionId, strFileId, retCode, retMsg);
                com.tencent.mobileqq.filemanager.util.ah.D(sessionId);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63511);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.observer = new b();
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return cw.f350644j0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "C2CAIOFileHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[]{0, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || !(peekAppRuntime instanceof QQAppInterface)) {
            return;
        }
        this.aioContext = param.a();
        ((QQAppInterface) peekAppRuntime).getFileManagerNotifyCenter().addObserver(this.observer);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        h.a.b(this);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || !(peekAppRuntime instanceof QQAppInterface)) {
            return;
        }
        ((QQAppInterface) peekAppRuntime).getFileManagerNotifyCenter().deleteObserver(this.observer);
        this.aioContext = null;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, state);
        }
    }
}

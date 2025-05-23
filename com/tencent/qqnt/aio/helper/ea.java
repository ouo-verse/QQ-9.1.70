package com.tencent.qqnt.aio.helper;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ea;", "Lcom/tencent/aio/main/businesshelper/h;", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", "onCreate", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/troop/utils/TroopFileError$d;", "d", "Lcom/tencent/mobileqq/troop/utils/TroopFileError$d;", "getBizTroopObserver", "()Lcom/tencent/mobileqq/troop/utils/TroopFileError$d;", "setBizTroopObserver", "(Lcom/tencent/mobileqq/troop/utils/TroopFileError$d;)V", "bizTroopObserver", "Lcom/tencent/mobileqq/filemanager/app/FMObserver;", "e", "Lcom/tencent/mobileqq/filemanager/app/FMObserver;", "observer", "<init>", "()V", "f", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class ea implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TroopFileError.d bizTroopObserver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final FMObserver observer = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JD\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0014\u00a8\u0006\u000f"}, d2 = {"com/tencent/qqnt/aio/helper/ea$b", "Lcom/tencent/mobileqq/filemanager/app/FMObserver;", "", "isSuccess", "", "uniseq", "sessionId", "", "strUin", "", "peerType", "errCode", "retMsg", "", ExifInterface.LATITUDE_SOUTH, "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends FMObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void S(boolean isSuccess, long uniseq, long sessionId, String strUin, int peerType, int errCode, String retMsg) {
            FileManagerEntity D;
            QLog.d("TroopFileHelper", 1, "recive TransferEnd, rmove task[" + sessionId + "]! elementId is " + uniseq + ", isSuccess is " + isSuccess);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null || !(peekAppRuntime instanceof QQAppInterface) || (D = ((QQAppInterface) peekAppRuntime).getFileManagerDataCenter().D(sessionId)) == null) {
                return;
            }
            if (!isSuccess) {
                com.tencent.mobileqq.filemanager.util.ah.C(sessionId, errCode, retMsg);
            } else if (D.nOpType == 6) {
                com.tencent.mobileqq.filemanager.util.ah.D(sessionId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AppRuntime appRuntime, com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(appRuntime, "$appRuntime");
        Intrinsics.checkNotNullParameter(param, "$param");
        AIOParam g16 = param.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
        TroopFileManager.F((QQAppInterface) appRuntime, su3.c.a(g16));
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350647k0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "TroopFileHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(final com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (peekAppRuntime instanceof QQAppInterface)) {
            Context context = param.a().c().getContext();
            if (context != null) {
                AIOParam g16 = param.a().g();
                Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
                this.bizTroopObserver = new TroopFileError.d(context, su3.c.a(g16), (QQAppInterface) peekAppRuntime);
            }
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            TroopFileError.a(qQAppInterface, this.bizTroopObserver);
            qQAppInterface.getFileManagerNotifyCenter().addObserver(this.observer);
            Boolean isSwitchOn = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("105712", Boolean.TRUE);
            Intrinsics.checkNotNullExpressionValue(isSwitchOn, "api(IUnitedConfig::class\u2026OAD_MANAGER_CONFIG, true)");
            if (isSwitchOn.booleanValue()) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.dz
                    @Override // java.lang.Runnable
                    public final void run() {
                        ea.b(AppRuntime.this, param);
                    }
                }, 32, null, true);
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (peekAppRuntime instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            TroopFileError.f(qQAppInterface, this.bizTroopObserver);
            this.bizTroopObserver = null;
            qQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.observer);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 3, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        TroopFileError.d dVar;
        if (state != 3 || (dVar = this.bizTroopObserver) == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null || qQAppInterface.containObserver(dVar, false)) {
            return;
        }
        TroopFileError.a(qQAppInterface, this.bizTroopObserver);
        if (QLog.isColorLevel()) {
            QLog.i("TroopFileHelper", 1, "on resume, add observer again.");
        }
    }
}

package com.tencent.hippykotlin.demo.pages.qqflash_transfer.model;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.ntcompose.foundation.scheduler.SchedulerKt;
import java.util.List;
import java.util.Map;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import ws3.ab;
import ws3.cs;
import ws3.cx;
import ws3.i;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1 implements cs {
    public final /* synthetic */ cx $callback;
    public final /* synthetic */ String $fileSetId;
    public final /* synthetic */ List<ab> $files;
    public final /* synthetic */ boolean $needDownloadAllFiles;
    public final /* synthetic */ QQFlashTransferViewModel this$0;

    public QQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1(QQFlashTransferViewModel qQFlashTransferViewModel, boolean z16, String str, List<ab> list, cx cxVar) {
        this.this$0 = qQFlashTransferViewModel;
        this.$needDownloadAllFiles = z16;
        this.$fileSetId = str;
        this.$files = list;
        this.$callback = cxVar;
    }

    public static final void access$onCheckDeviceStatus(QQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1 qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1, int i3, String str) {
        qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.getClass();
        KLog kLog = KLog.INSTANCE;
        kLog.d("QQFlashTransferFileListViewModel", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("checkDeviceStatus. onCheckDeviceStatus. deviceStatus: ", i3, ", notice: ", str));
        qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.this$0.deviceStateProcessInfo.notice = str;
        if (i3 == 0) {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("checkDeviceStatus compressedFileFolderID=");
            m3.append(qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.this$0.compressedFileFolderId);
            m3.append(" parentId=");
            m3.append(qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.this$0.parentId.getValue());
            m3.append(" clusterId=");
            m3.append(qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.this$0.clusterId);
            m3.append(" isDownloadFileset=");
            NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(m3, qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.$needDownloadAllFiles, kLog, "QQFlashTransferFileListViewModel");
            qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.this$0.internalStartDownloadFileList(qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.$fileSetId, qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.$needDownloadAllFiles, qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.$files, qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.$callback);
            return;
        }
        if (str.length() > 0) {
            if (i3 == 1 || i3 == 2) {
                qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.this$0.deviceStateProcessInfo.showAlertDialog.setValue(Boolean.TRUE);
                qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.$callback.mo120onResultjXDDuk8(-1, str, UInt.m570constructorimpl(i3));
            } else {
                if (i3 != 4) {
                    return;
                }
                DeviceStateProcessInfo deviceStateProcessInfo = qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.this$0.deviceStateProcessInfo;
                deviceStateProcessInfo.fileSetId = qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.$fileSetId;
                deviceStateProcessInfo.files = qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.$files;
                deviceStateProcessInfo.callback = qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.$callback;
                deviceStateProcessInfo.needDownloadAllFiles = qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.$needDownloadAllFiles;
                deviceStateProcessInfo.showAskDialog.setValue(Boolean.TRUE);
                qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.$callback.mo120onResultjXDDuk8(-1, "", UInt.m570constructorimpl(i3));
            }
        }
    }

    @Override // ws3.cs
    public final void onCheckDeviceStatus(final i iVar) {
        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1$onCheckDeviceStatus$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                if (i.this.f446371a.isEmpty()) {
                    QQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.access$onCheckDeviceStatus(this, 0, "");
                } else {
                    for (Map.Entry<Integer, String> entry : i.this.f446371a.entrySet()) {
                        QQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.access$onCheckDeviceStatus(this, entry.getKey().intValue(), entry.getValue());
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }
}

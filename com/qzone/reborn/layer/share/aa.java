package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.util.ToastUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class aa extends QZoneBaseShareAction {

    /* renamed from: j, reason: collision with root package name */
    private Handler f58163j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                ToastUtil.o(R.string.gkh, 4);
                return;
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
                ToastUtil.o(R.string.gkk, 4);
                return;
            }
            Object obj = message.obj;
            if (obj == null || !(obj instanceof String)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(QzoneIPCModule.PIC_PATH, (String) obj);
            int i16 = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QzoneIPCModule", QzoneIPCModule.ACTION_SAVE_CUSTOMEMOTION, bundle).data.getInt(QzoneIPCModule.RESULT_CODE);
            if (i16 != 0) {
                if (i16 == 2) {
                    ToastUtil.o(R.string.f170070f0, 4);
                } else {
                    ToastUtil.o(R.string.cwa, 4);
                }
            }
            if (QZLog.isColorLevel()) {
                QZLog.i("QZoneFeedxShareSaveCustomEmo", "resultcode:" + i16);
            }
        }
    }

    public aa(Activity activity) {
        super(activity);
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    void j(f fVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (fVar.f58179c.isVideo()) {
            return;
        }
        if (this.f58163j == null) {
            this.f58163j = new a();
        }
        f(3, VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE), this.f58163j);
        LpReportInfo_pf00064.allReport(134, 1, 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void x(Message message) {
        super.x(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack != null && unpack.what == 1000065) {
            j(this.f58107b, this.f58114i);
        }
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public int[] s() {
        return new int[]{48};
    }
}

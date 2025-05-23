package com.tencent.mobileqq.mini.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
import com.tencent.mobileqq.mini.config.FileMaterialConfig;
import com.tencent.mobileqq.mini.config.FileMaterialConfigParser;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.ui.FileMaterialAppListDialog;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0002J$\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/mini/api/impl/MiniAppFileMaterialServiceImpl;", "Lcom/tencent/mobileqq/mini/api/IMiniAppFileMaterialService;", "()V", "getFileMimeTypeImpl", "", "filePath", "isFileSupported", "", "isMimeTypeSupported", "mimeType", "isMimeTypeSupportedImpl", "reportMenuItemClickedOrExposed", "", "isClick", "showAppListDialog", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "showSupportedAppList", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppFileMaterialServiceImpl implements IMiniAppFileMaterialService {
    private static final String TAG = "MiniAppFileMaterialServiceImpl";

    private final boolean isMimeTypeSupportedImpl(String mimeType) {
        FileMaterialConfig config = FileMaterialConfigParser.getConfig();
        if (config != null) {
            return config.isMimeTypeSupported(mimeType);
        }
        return false;
    }

    private final void reportMenuItemClickedOrExposed(String mimeType, boolean isClick) {
        String str;
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(QCommonOnlineExpProviderImpl.EXP_QQ_MINI_APP_AIO_FILE);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEnti\u2026EXP_QQ_MINI_APP_AIO_FILE)");
        if (isClick) {
            str = "click";
        } else {
            str = "expo";
        }
        MiniProgramLpReportDC04239.reportAsync(MiniProgramLpReportDC04239.FILE_MATERIAL_ACTION_TYPE, MiniProgramLpReportDC04239.FILE_MATERIAL_SUB_ACTION_MENU, str, mimeType, expEntity.getGrayId(), "");
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService
    public String getFileMimeTypeImpl(String filePath) {
        FileMaterialConfig config = FileMaterialConfigParser.getConfig();
        if (config != null) {
            return config.getFileMimeType(filePath);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService
    public boolean isFileSupported(String filePath) {
        String fileMimeTypeImpl = getFileMimeTypeImpl(filePath);
        if (fileMimeTypeImpl == null || fileMimeTypeImpl.length() == 0) {
            return false;
        }
        return isMimeTypeSupported(fileMimeTypeImpl);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService
    public boolean isMimeTypeSupported(String mimeType) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        boolean isMimeTypeSupportedImpl = isMimeTypeSupportedImpl(mimeType);
        if (isMimeTypeSupportedImpl) {
            reportMenuItemClickedOrExposed(mimeType, false);
        }
        return isMimeTypeSupportedImpl;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService
    public void showSupportedAppList(Activity activity, String filePath) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (filePath == null || filePath.length() == 0) {
            return;
        }
        String fileMimeTypeImpl = getFileMimeTypeImpl(filePath);
        if (fileMimeTypeImpl == null || fileMimeTypeImpl.length() == 0) {
            return;
        }
        showAppListDialog(activity, filePath, fileMimeTypeImpl);
    }

    private final void showAppListDialog(Activity activity, String filePath, String mimeType) {
        if (filePath == null || filePath.length() == 0) {
            QLog.e(TAG, 1, "showAppListDialog: filePath is empty");
            return;
        }
        File file = new File(filePath);
        if (!file.exists()) {
            QLog.e(TAG, 1, "showAppListDialog: file not exist");
            return;
        }
        if (mimeType == null || mimeType.length() == 0) {
            QLog.e(TAG, 1, "showAppListDialog: unknown mimeType");
        } else if (StudyModeManager.t()) {
            QQToast.makeText(activity, activity.getResources().getString(R.string.f185153nt), 0).show();
            QLog.e(TAG, 1, "showAppListDialog: getStudyMode error");
        } else {
            reportMenuItemClickedOrExposed(mimeType, true);
            new FileMaterialAppListDialog(activity, file, mimeType).show();
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService
    public void showSupportedAppList(Activity activity, String filePath, String mimeType) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        showAppListDialog(activity, filePath, mimeType);
    }
}

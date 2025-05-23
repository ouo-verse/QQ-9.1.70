package com.tencent.mobileqq.qrscan.api.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanCacheApi;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.qrscan.h;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BitmapUtil;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qrscan/api/impl/ScanCacheApiImpl;", "Lcom/tencent/mobileqq/qrscan/api/IScanCacheApi;", "", "checkFolder", "Lcom/tencent/mobileqq/qrscan/h;", "data", "saveTempCameraData", "", "getTempCameraDataPath", QCircleLpReportDc05507.KEY_CLEAR, "folderDir", "Ljava/lang/String;", "cameraDataPath", "<init>", "()V", "Companion", "a", "qqqrscan-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ScanCacheApiImpl implements IScanCacheApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "ScanCacheApiImpl";

    @NotNull
    private final String cameraDataPath;

    @NotNull
    private final String folderDir;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qrscan/api/impl/ScanCacheApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqqrscan-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qrscan.api.impl.ScanCacheApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22865);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ScanCacheApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        String absolutePath = MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath();
        String str = File.separator;
        String str2 = absolutePath + str + "scanner";
        this.folderDir = str2;
        this.cameraDataPath = str2 + str + "scan_temp_camera_data";
    }

    private final void checkFolder() {
        File file = new File(this.folderDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(this.folderDir, ".nomedia");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e16) {
                QLog.e(TAG, 1, "checkFolder error. ", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanCacheApi
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (q.p(this.cameraDataPath)) {
            q.d(this.cameraDataPath);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanCacheApi
    @Nullable
    public String getTempCameraDataPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (q.p(this.cameraDataPath)) {
            return this.cameraDataPath;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanCacheApi
    public void saveTempCameraData(@Nullable h data) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
            return;
        }
        if (data != null) {
            bArr = data.f276637a;
        } else {
            bArr = null;
        }
        if (bArr == null) {
            return;
        }
        try {
            Bitmap decodeBitmapFromYuv = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeBitmapFromYuv(data.f276637a, data.f276638b, data.f276639c);
            checkFolder();
            q.q(BitmapUtil.rotateBitmap(90, decodeBitmapFromYuv), this.cameraDataPath);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "tempSaveCameraData error: ", e16);
        }
    }
}

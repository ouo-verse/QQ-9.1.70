package com.tencent.mobileqq.vas.updatesystem.business;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasAioData;
import com.tencent.mobileqq.vas.font.report.VasFontReporter;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FontBusiness extends QQVasUpdateBusiness {
    public static final long BID = 5;
    public static final String FONT_DOWN_LOAD_PATH_NEW = QQVasUpdateBusiness.getVasRootDir() + ".font_info/";
    public static final int FONT_TYPE_FANGZHENG = 2;
    public static final int FONT_TYPE_FZCOLOR = 3;
    public static final int FONT_TYPE_FZCOLOR_2 = 4;
    public static final int FONT_TYPE_HANYI = 1;
    public static final String SCID_FONT_PREFIX = "font.main.android.";
    protected static final String TAG = "font_info";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IDownLoadListener f311176a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f311177b;

        a(IDownLoadListener iDownLoadListener, String str) {
            this.f311176a = iDownLoadListener;
            this.f311177b = str;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            this.f311176a.onLoadFail(updateListenerParams);
            FontBusiness.this.reportErrorCase(updateListenerParams, this.f311177b);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            this.f311176a.onLoadSuccess(updateListenerParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportErrorCase(@NonNull final UpdateListenerParams updateListenerParams, final String str) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.vas.updatesystem.business.FontBusiness.2
            @Override // java.lang.Runnable
            public void run() {
                String replace = VasFontReporter.ERROR_FILE_DOWNLOAD.replace("{id}", str).replace("{errorCode}", String.valueOf(updateListenerParams.mErrorCode)).replace("{httpCode}", String.valueOf(updateListenerParams.mHttpCode));
                if (updateListenerParams.mErrorCode == 24) {
                    if (FontBusiness.this.getScid(((IVasAioData) QRoute.api(IVasAioData.class)).getAioVasMsgData(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin()).getFontId()).equals(str)) {
                        VasFontReporter.INSTANCE.report(replace);
                        return;
                    }
                    return;
                }
                VasFontReporter.INSTANCE.report(replace);
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManagerV2.excute(runnable, 16, null, false);
        } else {
            runnable.run();
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public void addDownLoadListener(String str, IDownLoadListener iDownLoadListener) {
        super.addDownLoadListener(str, new a(iDownLoadListener, str));
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 5L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return TAG;
    }

    public String getFontPath(int i3) {
        return getSavePath(i3) + File.separator + i3 + ".ttf";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getScidPrefix() {
        return "font.main.android.";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableFileClean() {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isFileExists(int i3) {
        return new File(getFontPath(i3)).exists();
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public void addDownLoadListener(int i3, IDownLoadListener iDownLoadListener) {
        addDownLoadListener(getScid(i3), iDownLoadListener);
    }
}

package com.tencent.mobileqq.search.model;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileOutputStream;
import java.io.IOException;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class SearchEntryDataModel extends v {
    protected static final Object C = new Object();

    /* renamed from: f, reason: collision with root package name */
    public int f283456f;

    /* renamed from: h, reason: collision with root package name */
    protected int f283457h;

    /* renamed from: i, reason: collision with root package name */
    protected byte[] f283458i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f283459m;

    public SearchEntryDataModel(int i3, int i16) {
        this.f283456f = i3;
        this.f283457h = i16;
    }

    public static boolean m(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr2 == null || iArr.length != iArr2.length) {
            return true;
        }
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] != iArr2[i3]) {
                return true;
            }
        }
        return false;
    }

    public abstract void k(byte[] bArr);

    public void l() {
        synchronized (C) {
            byte[] fileToBytes = FileUtils.fileToBytes(BaseApplication.getContext().getFileStreamPath("search_discovery_sp_prefix_unifypref_search_model_data" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin() + "_" + this.f283456f + "_" + this.f283457h));
            this.f283458i = fileToBytes;
            k(fileToBytes);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        if (this.f283458i == null) {
            if (QLog.isColorLevel()) {
                QLog.e("SearchEntryDataModel", 2, "saveDataToLocal, mRawData is null");
                return;
            }
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.search.model.SearchEntryDataModel.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                StringBuilder sb5;
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        fileOutputStream = BaseApplication.getContext().openFileOutput("search_discovery_sp_prefix_unifypref_search_model_data" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin() + "_" + SearchEntryDataModel.this.f283456f + "_" + SearchEntryDataModel.this.f283457h, 0);
                        QLog.d("SearchEntryDataModel818searchProto_new", 2, "saveDataToLocal");
                        synchronized (SearchEntryDataModel.C) {
                            byte[] bArr = SearchEntryDataModel.this.f283458i;
                            if (bArr != null) {
                                fileOutputStream.write(bArr);
                                fileOutputStream.flush();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e16) {
                                e = e16;
                                if (QLog.isColorLevel()) {
                                    str = "SearchEntryDataModel";
                                    sb5 = new StringBuilder();
                                    sb5.append("saveDataToLocal, ");
                                    sb5.append(QLog.getStackTraceString(e));
                                    QLog.e(str, 2, sb5.toString());
                                }
                            }
                        }
                    } catch (IOException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.e("SearchEntryDataModel", 2, "saveDataToLocal, " + QLog.getStackTraceString(e17));
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e18) {
                                e = e18;
                                if (QLog.isColorLevel()) {
                                    str = "SearchEntryDataModel";
                                    sb5 = new StringBuilder();
                                    sb5.append("saveDataToLocal, ");
                                    sb5.append(QLog.getStackTraceString(e));
                                    QLog.e(str, 2, sb5.toString());
                                }
                            }
                        }
                    }
                } catch (Throwable th5) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e19) {
                            if (QLog.isColorLevel()) {
                                QLog.e("SearchEntryDataModel", 2, "saveDataToLocal, " + QLog.getStackTraceString(e19));
                            }
                        }
                    }
                    throw th5;
                }
            }
        }, 5, null, true);
    }

    @NonNull
    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("SearchEntryDataModel{mModelType=");
        sb5.append(this.f283456f);
        sb5.append(", mTabType=");
        sb5.append(this.f283457h);
        sb5.append(", mRawData is null?");
        if (this.f283458i == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(", hide_top_divider=");
        sb5.append(this.f283459m);
        sb5.append('}');
        return sb5.toString();
    }
}

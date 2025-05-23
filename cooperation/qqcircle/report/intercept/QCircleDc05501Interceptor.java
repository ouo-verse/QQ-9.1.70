package cooperation.qqcircle.report.intercept;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleDc05501Interceptor extends QCircleDcBaseInterceptor {
    @Override // cooperation.qqcircle.report.intercept.QCircleDcBaseInterceptor
    public int getDcId() {
        return 5501;
    }

    @Override // cooperation.qqcircle.report.intercept.QCircleDcBaseInterceptor
    @NonNull
    public String[] getFilterKeyList() {
        return new String[]{"device_info"};
    }
}

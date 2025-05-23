package fa1;

import android.R;
import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.colornote.data.ColorNote;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i implements b {
    private QQAppInterface a() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    @Override // fa1.b
    public int getType() {
        return R.array.emailAddressTypes;
    }

    @Override // fa1.b
    public void launch(Context context, ColorNote colorNote) {
        QQAppInterface a16 = a();
        if (a16 != null) {
            ((z61.d) a16.getManager(QQManagerFactory.UPCOMING_MSG_PRE_MANAGER)).t(context, colorNote);
        }
    }

    @Override // fa1.b
    public void onCreate(Context context, ColorNote colorNote, Bundle bundle) {
    }
}

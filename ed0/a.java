package ed0;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.security.InvalidParameterException;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static QQAppInterface a() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        throw new InvalidParameterException("can't get AppInterface");
    }
}

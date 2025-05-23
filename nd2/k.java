package nd2;

import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import cooperation.photoplus.sticker.Sticker;

/* compiled from: P */
/* loaded from: classes16.dex */
public class k extends j {

    /* renamed from: a, reason: collision with root package name */
    static final String[] f419967a = {"PAReportInfo", "CircleBuddy ", "CircleGroup ", Sticker.TAG, "TopicInfo", "FriendMore", "FreshNewsNotify", "QQCardFolder", "bubble_diytext", "ApolloGameBtnData", "ApolloGameActivityConfig", "CardProfilev2", "SecMsgSession"};

    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        String a16 = a(chain);
        if (ArrayUtils.contains(f419967a, a16)) {
            if (QLog.isColorLevel()) {
                QLog.d("ForceIgnoreInterceptor", 2, "check table with " + a16 + " is force ignored");
                return null;
            }
            return null;
        }
        return chain.proceed();
    }
}

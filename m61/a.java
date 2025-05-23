package m61;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    public static boolean a(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            return false;
        }
        return ((ICameraEmoRoamingManagerService) qQAppInterface.getRuntimeService(ICameraEmoRoamingManagerService.class)).getIsNeedShowGuide();
    }
}

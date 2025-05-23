package mqq.app.msghandle;

import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.qphone.base.BaseConstants;
import java.util.Arrays;
import mqq.inject.MqqInjectorManager;

/* loaded from: classes28.dex */
public class HighPriorityCMDProvider implements Provider<String[]> {
    private static String[] concat(String[] strArr, String[] strArr2) {
        String[] strArr3 = (String[]) Arrays.copyOf(strArr, strArr.length + strArr2.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Provider
    public String[] get() {
        return concat(new String[]{BaseConstants.CMD_NEW_REGPRXYSVC_PBSYNCMSG, BaseConstants.CMD_MSG_PBSENDMSG}, MqqInjectorManager.instance().highPriorityCommand());
    }
}

package mqq.inject;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface IMqqInjector {
    String getSDKPrivatePath(String str);

    boolean getSwitch(Context context, String str, boolean z16, boolean z17);

    boolean getSwitch(String str, boolean z16);

    String getVersion();

    void handleSendTimeForSendMsgPb(ToServiceMsg toServiceMsg, String str);

    String[] highPriorityCommand();

    boolean isDebugVersion();

    boolean isGrayVersion();

    boolean isPublicVersion();

    boolean isUiTest();

    ToServiceMsg makeOIDBPkg(OidbWrapper oidbWrapper, String str, int i3, int i16, byte[] bArr, long j3, BusinessObserver businessObserver, boolean z16);

    int parseOIDBPkg(FromServiceMsg fromServiceMsg, Object obj, MessageMicro messageMicro);

    int parseOIDBPkg(FromServiceMsg fromServiceMsg, Object obj, MessageMicro messageMicro, MessageMicro messageMicro2);

    void postNeedFixStartStepCapturedException(@NonNull Throwable th5);

    void report(String str, Map<String, String> map);

    String[] tempServletPreferSSOCommand();

    void tryDumpUiHierarchyToFile(View view);
}

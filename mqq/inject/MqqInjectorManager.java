package mqq.inject;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.mqq.a;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MqqInjectorManager implements IMqqInjector {
    private static final String TAG = "MqqInjectorManager";

    @ConfigInject(configPath = "AutoInjectYml/Foundation/mqq/Inject_mqq_decouple_qqbase.yml", version = 1)
    public static ArrayList<Class<? extends IMqqInjector>> sInjectorList;
    private static volatile MqqInjectorManager sInstance;
    private IMqqInjector injector;

    static {
        ArrayList<Class<? extends IMqqInjector>> arrayList = new ArrayList<>();
        sInjectorList = arrayList;
        arrayList.add(a.class);
    }

    MqqInjectorManager() {
        this.injector = new DefaultMqqInjectorImpl();
        if (sInjectorList.size() == 0) {
            return;
        }
        try {
            this.injector = sInjectorList.get(0).newInstance();
        } catch (IllegalAccessException | InstantiationException e16) {
            QLog.e(TAG, 1, "IMqqInjector new instance fail: ", e16);
        }
    }

    public static MqqInjectorManager instance() {
        if (sInstance == null) {
            synchronized (MqqInjectorManager.class) {
                if (sInstance == null) {
                    sInstance = new MqqInjectorManager();
                }
            }
        }
        return sInstance;
    }

    @Override // mqq.inject.IMqqInjector
    public String getSDKPrivatePath(String str) {
        return this.injector.getSDKPrivatePath(str);
    }

    @Override // mqq.inject.IMqqInjector
    public boolean getSwitch(Context context, String str, boolean z16, boolean z17) {
        return this.injector.getSwitch(context, str, z16, z17);
    }

    @Override // mqq.inject.IMqqInjector
    public String getVersion() {
        return this.injector.getVersion();
    }

    @Override // mqq.inject.IMqqInjector
    public void handleSendTimeForSendMsgPb(ToServiceMsg toServiceMsg, String str) {
        this.injector.handleSendTimeForSendMsgPb(toServiceMsg, str);
    }

    @Override // mqq.inject.IMqqInjector
    public String[] highPriorityCommand() {
        return this.injector.highPriorityCommand();
    }

    @Override // mqq.inject.IMqqInjector
    public boolean isDebugVersion() {
        return this.injector.isDebugVersion();
    }

    @Override // mqq.inject.IMqqInjector
    public boolean isGrayVersion() {
        return this.injector.isGrayVersion();
    }

    @Override // mqq.inject.IMqqInjector
    public boolean isPublicVersion() {
        return this.injector.isPublicVersion();
    }

    @Override // mqq.inject.IMqqInjector
    public boolean isUiTest() {
        return this.injector.isUiTest();
    }

    @Override // mqq.inject.IMqqInjector
    public ToServiceMsg makeOIDBPkg(OidbWrapper oidbWrapper, String str, int i3, int i16, byte[] bArr, long j3, BusinessObserver businessObserver, boolean z16) {
        return this.injector.makeOIDBPkg(oidbWrapper, str, i3, i16, bArr, j3, businessObserver, z16);
    }

    @Override // mqq.inject.IMqqInjector
    public int parseOIDBPkg(FromServiceMsg fromServiceMsg, Object obj, MessageMicro messageMicro) {
        return this.injector.parseOIDBPkg(fromServiceMsg, obj, messageMicro);
    }

    @Override // mqq.inject.IMqqInjector
    public void postNeedFixStartStepCapturedException(@NonNull Throwable th5) {
        this.injector.postNeedFixStartStepCapturedException(th5);
    }

    @Override // mqq.inject.IMqqInjector
    public void report(String str, Map<String, String> map) {
        this.injector.report(str, map);
    }

    @Override // mqq.inject.IMqqInjector
    public String[] tempServletPreferSSOCommand() {
        return this.injector.tempServletPreferSSOCommand();
    }

    @Override // mqq.inject.IMqqInjector
    public void tryDumpUiHierarchyToFile(View view) {
        this.injector.tryDumpUiHierarchyToFile(view);
    }

    @Override // mqq.inject.IMqqInjector
    public boolean getSwitch(String str, boolean z16) {
        return this.injector.getSwitch(str, z16);
    }

    @Override // mqq.inject.IMqqInjector
    public int parseOIDBPkg(FromServiceMsg fromServiceMsg, Object obj, MessageMicro messageMicro, MessageMicro messageMicro2) {
        return this.injector.parseOIDBPkg(fromServiceMsg, obj, messageMicro, messageMicro2);
    }
}

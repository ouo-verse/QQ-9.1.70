package fr;

import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.music.g;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager;
import com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final e[] f400346a = new e[15];

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<Integer, Object> f400347b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final f f400348a = new f();
    }

    f() {
    }

    private boolean a() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
            QLog.d("QIMManager", 2, "check process: " + runtime);
        }
        return (runtime instanceof QQAppInterface) || (runtime instanceof ToolRuntimePeak);
    }

    public static e c(int i3) {
        return a.f400348a.g(i3);
    }

    public static f d() {
        return a.f400348a;
    }

    public static AppInterface e() {
        return (AppInterface) f();
    }

    private static AppRuntime f() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        return runtime instanceof QQAppInterface ? runtime : BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak");
    }

    public static e i(int i3) {
        return a.f400348a.f400346a[i3];
    }

    public e g(int i3) {
        Object obj;
        e[] eVarArr = this.f400346a;
        e eVar = eVarArr[i3];
        if (eVar != null) {
            return eVar;
        }
        synchronized (eVarArr) {
            if (!this.f400347b.containsKey(Integer.valueOf(i3))) {
                this.f400347b.put(Integer.valueOf(i3), new Object());
            }
            obj = this.f400347b.get(Integer.valueOf(i3));
        }
        synchronized (obj) {
            e eVar2 = this.f400346a[i3];
            if (eVar2 != null) {
                return eVar2;
            }
            if (a()) {
                switch (i3) {
                    case 1:
                        eVar2 = new com.tencent.aelight.camera.aioeditor.capture.paster.e();
                        break;
                    case 2:
                        eVar2 = new QIMMusicConfigManager();
                        break;
                    case 3:
                        eVar2 = new QIMPtvTemplateManager();
                        break;
                    case 4:
                        eVar2 = new PasterDataManager();
                        break;
                    case 5:
                        eVar2 = new com.tencent.aelight.camera.aioeditor.capture.data.d();
                        break;
                    case 7:
                        eVar2 = new DynamicTextConfigManager();
                        break;
                    case 8:
                        eVar2 = new g();
                        break;
                    case 12:
                        eVar2 = new QIMInformationPasterManager();
                        break;
                    case 13:
                        eVar2 = new com.tencent.aelight.camera.aioeditor.d();
                        break;
                    case 14:
                        eVar2 = new wr.a();
                        break;
                }
                this.f400346a[i3] = eVar2;
                if (eVar2 != null) {
                    eVar2.e();
                    hd0.c.l("QIMManager", "onInit manager : %s", eVar2);
                }
                return eVar2;
            }
            throw new RuntimeException("invalid process");
        }
    }

    public boolean h(int i3) {
        return this.f400346a[i3] != null;
    }

    public void b() {
        Object obj;
        int i3 = 0;
        while (true) {
            e[] eVarArr = this.f400346a;
            if (i3 >= eVarArr.length) {
                return;
            }
            synchronized (eVarArr) {
                if (!this.f400347b.containsKey(Integer.valueOf(i3))) {
                    this.f400347b.put(Integer.valueOf(i3), new Object());
                }
                obj = this.f400347b.get(Integer.valueOf(i3));
            }
            synchronized (obj) {
                e eVar = this.f400346a[i3];
                if (eVar != null) {
                    hd0.c.l("QIMManager", "destroy manager : %s", eVar);
                    eVar.d();
                }
                this.f400346a[i3] = null;
            }
            i3++;
        }
    }
}

package i74;

import android.content.Intent;
import android.view.KeyEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u0000 \n2\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\"\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u001a\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001aR\u001a\u0010\u001f\u001a\u00020\u001b8\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00028DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Li74/a;", "", "Lmqq/app/AppActivity;", "host", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "e", "j", "i", "f", "", "requestCode", "requestCode2", "Landroid/content/Intent;", "data", "c", "intent", h.F, "", "d", "keyCode", "Landroid/view/KeyEvent;", "event", "g", "b", "Lmqq/app/AppActivity;", "", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "logicName", "k", "()Lmqq/app/AppActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "()V", "superqqshow-portal-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AppActivity host;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String logicName = "";

    public void a() {
        QLog.i("ZPlanSameStyle", 1, getLogicName() + " beforeOnCreate");
    }

    public void b() {
        QLog.i("ZPlanSameStyle", 1, getLogicName() + " beforeFinish");
    }

    public void c(int requestCode, int requestCode2, Intent data) {
        QLog.i("ZPlanSameStyle", 1, getLogicName() + " doOnActivityResult, resultCode = " + requestCode + ", requestCode = " + requestCode2);
    }

    public boolean d() {
        QLog.i("ZPlanSameStyle", 1, getLogicName() + " doOnBackPressed");
        return false;
    }

    public void e() {
        QLog.i("ZPlanSameStyle", 1, getLogicName() + " doOnCreate");
    }

    public void f() {
        QLog.i("ZPlanSameStyle", 1, getLogicName() + " doOnDestroy");
    }

    public boolean g(int keyCode, KeyEvent event) {
        QLog.i("ZPlanSameStyle", 1, getLogicName() + " doOnKeyDown keyCode:" + keyCode + ", event:" + event);
        return false;
    }

    public void h(Intent intent) {
        QLog.i("ZPlanSameStyle", 1, getLogicName() + " doOnNewIntent");
    }

    public void i() {
        QLog.i("ZPlanSameStyle", 1, getLogicName() + " doOnPause");
    }

    public void j() {
        QLog.i("ZPlanSameStyle", 1, getLogicName() + " doOnResume");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AppActivity k() {
        AppActivity appActivity = this.host;
        if (appActivity != null) {
            return appActivity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("host");
        return null;
    }

    /* renamed from: l, reason: from getter */
    protected String getLogicName() {
        return this.logicName;
    }

    public void m(AppActivity host) {
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
    }
}

package g72;

import android.content.Intent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.main.api.b;
import com.tencent.mobileqq.main.api.c;
import com.tencent.mobileqq.main.api.d;
import com.tencent.mobileqq.main.loginpart.DrawerFramePart;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import com.tencent.mobileqq.util.af;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001\u0003B\u001d\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0015R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001b\u00a8\u0006\""}, d2 = {"Lg72/a;", "Lcom/tencent/mobileqq/main/api/b;", "", "a", "b", "", "e", QAdLoginDefine$LoginStatus.IS_LOGIN, "c", "d", "onCreate", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onAccountChanged", "onPostThemeChanged", "onDrawComplete", "onLogout", "Lcom/tencent/mobileqq/main/api/d;", "Lcom/tencent/mobileqq/main/api/d;", "_proxy", "Z", "_isRegisterInUser", "_isRegisterCommon", "_isDoLoginUserStateBefore", "", "Lcom/tencent/mobileqq/main/api/c;", "Ljava/util/List;", "_partList", "", "list", "<init>", "(Lcom/tencent/mobileqq/main/api/d;Ljava/util/List;)V", "f", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final d _proxy;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean _isRegisterInUser;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean _isRegisterCommon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean _isDoLoginUserStateBefore;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List<c> _partList;

    public a(d _proxy, List<? extends c> list) {
        Intrinsics.checkNotNullParameter(_proxy, "_proxy");
        Intrinsics.checkNotNullParameter(list, "list");
        this._proxy = _proxy;
        ArrayList arrayList = new ArrayList();
        this._partList = arrayList;
        arrayList.addAll(list);
        arrayList.add(new DrawerFramePart());
        if (af.i()) {
            arrayList.add(new com.tencent.mobileqq.main.loginpart.c());
        }
    }

    private final void a() {
        if (this._isRegisterCommon) {
            return;
        }
        this._isRegisterCommon = true;
        if (QLog.isDebugVersion()) {
            QLog.d("MainFrameHost", 4, "[doCommonRegisterAction]");
        }
        Iterator<T> it = this._partList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(this._proxy);
        }
    }

    private final void b() {
        if (this._isRegisterCommon) {
            this._isRegisterCommon = false;
            if (QLog.isDebugVersion()) {
                QLog.d("MainFrameHost", 4, "[doCommonUnRegisterAction]");
            }
            Iterator<T> it = this._partList.iterator();
            while (it.hasNext()) {
                ((c) it.next()).c(this._proxy);
            }
        }
    }

    private final void c(boolean isLogin) {
        if (this._isRegisterInUser || !e()) {
            return;
        }
        this._isRegisterInUser = true;
        this._isDoLoginUserStateBefore = isLogin;
        if (QLog.isDebugVersion()) {
            QLog.d("MainFrameHost", 4, "[doRegisterInUserState] isLogin=" + isLogin);
        }
        Iterator<T> it = this._partList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).g(this._proxy, isLogin);
        }
    }

    private final void d(boolean isLogin) {
        if (this._isRegisterInUser) {
            this._isRegisterInUser = false;
            if (QLog.isDebugVersion()) {
                QLog.d("MainFrameHost", 4, "[doUnRegisterInUserState] isLogin=" + isLogin);
            }
            Iterator<T> it = this._partList.iterator();
            while (it.hasNext()) {
                ((c) it.next()).b(this._proxy, isLogin);
            }
        }
    }

    private final boolean e() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return peekAppRuntime != null && peekAppRuntime.isLogin();
    }

    @Override // com.tencent.mobileqq.main.api.b
    public void onAccountChanged() {
        if (QLog.isDebugVersion()) {
            QLog.d("MainFrameHost", 4, "[onAccountChanged]");
        }
        Iterator<T> it = this._partList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).h(this._proxy);
        }
    }

    @Override // com.tencent.mobileqq.main.api.b
    public void onCreate() {
        Intent intent;
        if (QLog.isColorLevel()) {
            QLog.d("MainFrameHost", 2, "[onCreate] isRegisterInUser=" + this._isRegisterInUser + ", isRegisterCommon=" + this._isRegisterCommon);
        }
        Iterator<T> it = this._partList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).d(this._proxy);
        }
        a();
        QBaseActivity activity = this._proxy.getActivity();
        c(Intrinsics.areEqual((activity == null || (intent = activity.getIntent()) == null) ? null : Boolean.valueOf(intent.getBooleanExtra("k_from_login", false)), Boolean.TRUE));
    }

    @Override // com.tencent.mobileqq.main.api.b
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("MainFrameHost", 2, "[onDestroy] isRegisterInUser=" + this._isRegisterInUser + ", isRegisterCommon=" + this._isRegisterCommon);
        }
        b();
        d(false);
        Iterator<T> it = this._partList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).f(this._proxy);
        }
    }

    @Override // com.tencent.mobileqq.main.api.b
    public void onDrawComplete() {
        Iterator<T> it = this._partList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).i(this._proxy);
        }
    }

    @Override // com.tencent.mobileqq.main.api.b
    public void onLogout() {
        if (QLog.isColorLevel()) {
            QLog.d("MainFrameHost", 2, "[onLogout] isRegisterInUser=" + this._isRegisterInUser);
        }
        d(true);
    }

    @Override // com.tencent.mobileqq.main.api.b
    public void onPause() {
        Iterator<T> it = this._partList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).j(this._proxy);
        }
    }

    @Override // com.tencent.mobileqq.main.api.b
    public void onPostThemeChanged() {
        Iterator<T> it = this._partList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).onPostThemeChanged();
        }
    }

    @Override // com.tencent.mobileqq.main.api.b
    public void onResume() {
        Iterator<T> it = this._partList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).e(this._proxy);
        }
    }
}

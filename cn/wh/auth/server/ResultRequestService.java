package cn.wh.auth.server;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;

/* compiled from: P */
/* loaded from: classes.dex */
public class ResultRequestService {

    /* renamed from: a, reason: collision with root package name */
    private cn.wh.auth.server.a f31126a;

    /* renamed from: b, reason: collision with root package name */
    private final Activity f31127b;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface a {
        void onActivityResult(int i3, int i16, Intent intent);
    }

    public ResultRequestService(Activity activity) {
        this.f31127b = activity;
    }

    private cn.wh.auth.server.a e(FragmentManager fragmentManager) {
        return (cn.wh.auth.server.a) fragmentManager.findFragmentByTag("on_wh_local_result_dispatcher");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public cn.wh.auth.server.a f(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        cn.wh.auth.server.a e16 = e(fragmentManager);
        if (e16 == null) {
            cn.wh.auth.server.a aVar = new cn.wh.auth.server.a();
            fragmentManager.beginTransaction().add(aVar, "on_wh_local_result_dispatcher").commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
            return aVar;
        }
        return e16;
    }

    public void g(final Intent intent, final a aVar) {
        this.f31127b.runOnUiThread(new Runnable() { // from class: cn.wh.auth.server.ResultRequestService.1
            @Override // java.lang.Runnable
            public void run() {
                if (ResultRequestService.this.f31126a == null) {
                    ResultRequestService resultRequestService = ResultRequestService.this;
                    resultRequestService.f31126a = resultRequestService.f(resultRequestService.f31127b);
                }
                ResultRequestService.this.f31126a.e(intent, aVar);
            }
        });
    }
}

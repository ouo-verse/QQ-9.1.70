package oicq.wlogin_sdk.request;

import android.widget.Toast;
import java.util.TimerTask;
import oicq.wlogin_sdk.request.e;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Toast f422879a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f422880b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e.a f422881c;

    public d(e.a aVar, Toast toast, int i3) {
        this.f422881c = aVar;
        this.f422879a = toast;
        this.f422880b = i3;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f422881c.a(this.f422879a, this.f422880b + 1);
    }
}

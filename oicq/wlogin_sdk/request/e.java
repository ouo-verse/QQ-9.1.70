package oicq.wlogin_sdk.request;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class e extends BaseThread {

    /* renamed from: a, reason: collision with root package name */
    public Context f422884a;

    /* renamed from: b, reason: collision with root package name */
    public ErrMsg f422885b;

    /* renamed from: c, reason: collision with root package name */
    public Runnable f422886c = new a();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements Runnable {
        public a() {
        }

        public final void a(Toast toast, int i3) {
            if (i3 > 5) {
                return;
            }
            toast.show();
            new BaseTimer().schedule(new d(this, toast, i3), 30L);
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            if (eVar.f422884a != null && eVar.f422885b != null) {
                try {
                    LinearLayout linearLayout = new LinearLayout(e.this.f422884a);
                    linearLayout.setOrientation(1);
                    linearLayout.setBackgroundColor(-7829368);
                    linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                    TextView textView = new TextView(e.this.f422884a);
                    textView.getPaint().setFakeBoldText(true);
                    textView.setText(e.this.f422885b.getTitle());
                    linearLayout.addView(textView, 0, new LinearLayout.LayoutParams(-1, -2));
                    TextView textView2 = new TextView(e.this.f422884a);
                    textView2.setText(e.this.f422885b.getMessage());
                    linearLayout.addView(textView2, 1, new LinearLayout.LayoutParams(-1, -2));
                    Toast toast = new Toast(e.this.f422884a);
                    toast.setGravity(17, 0, 0);
                    toast.setDuration(1);
                    toast.setView(linearLayout);
                    a(toast, 0);
                } catch (Exception e16) {
                    util.printException(e16);
                }
            }
        }
    }

    public e(Context context, ErrMsg errMsg) {
        this.f422884a = context;
        a(errMsg);
    }

    public void a(ErrMsg errMsg) {
        if (errMsg != null) {
            try {
                this.f422885b = (ErrMsg) errMsg.clone();
                return;
            } catch (CloneNotSupportedException e16) {
                e16.printStackTrace();
            }
        }
        this.f422885b = null;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        new Handler(Looper.getMainLooper()).post(this.f422886c);
    }
}

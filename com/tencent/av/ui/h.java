package com.tencent.av.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.avcore.jni.config.ConfigInfoJni;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name */
    private Context f75945e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f75946f = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f75947h = false;

    /* renamed from: i, reason: collision with root package name */
    private ViewStub f75948i = null;

    /* renamed from: m, reason: collision with root package name */
    private BroadcastReceiver f75949m = new a();

    /* renamed from: d, reason: collision with root package name */
    private long[] f75944d = new long[6];

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE")) {
                if (!h.this.f75946f) {
                    h.this.f75946f = true;
                }
                zv.c.c().a("update", ConfigInfoJni.getSharpConfigVersionFromFile(context));
                return;
            }
            if (action.equals("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD") && !h.this.f75947h) {
                h.this.f75947h = true;
            }
        }
    }

    public h(Context context) {
        this.f75945e = context;
    }

    private void g(View view) {
        Activity activity = (Activity) this.f75945e;
        if (this.f75948i == null) {
            ViewStub viewStub = (ViewStub) activity.findViewById(R.id.f30060nb);
            this.f75948i = viewStub;
            viewStub.inflate();
        }
        activity.findViewById(R.id.g7m).setVisibility(0);
        TextView textView = (TextView) activity.findViewById(R.id.g7o);
        TextView textView2 = (TextView) activity.findViewById(R.id.g7n);
        int sharpConfigVersionFromFile = ConfigInfoJni.getSharpConfigVersionFromFile(this.f75945e);
        String e16 = e(ConfigInfoJni.getSharpConfigPayloadFromFile(this.f75945e));
        String str = e16 + "\n----------\n";
        String str2 = str + e(pu.c.h(this.f75945e));
        textView.setText(sharpConfigVersionFromFile + "|" + zv.c.c().b("load"));
        textView2.setText(str2);
    }

    String e(String str) {
        char c16;
        String[] split = str.split("\n");
        StringBuilder sb5 = new StringBuilder(new String());
        int i3 = 0;
        for (String str2 : split) {
            int length = str2.length();
            if (length >= 2) {
                c16 = str2.charAt(length - 2);
            } else {
                c16 = 0;
            }
            if (c16 == '}') {
                i3--;
            }
            for (int i16 = 0; i16 < i3; i16++) {
                sb5.append("\t");
            }
            sb5.append(str2);
            sb5.append("\n");
            if (c16 == '{') {
                i3++;
            }
        }
        return sb5.toString();
    }

    public void f() {
        Activity activity = (Activity) this.f75945e;
        View findViewById = activity.findViewById(R.id.g7l);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
            findViewById.setVisibility(0);
        }
        View findViewById2 = activity.findViewById(R.id.g7n);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this);
        }
        View findViewById3 = activity.findViewById(R.id.g7m);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(this);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
        intentFilter.addAction("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD");
        this.f75945e.registerReceiver(this.f75949m, intentFilter);
    }

    public void h() {
        this.f75945e.unregisterReceiver(this.f75949m);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.g7l) {
            long[] jArr = this.f75944d;
            System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
            long[] jArr2 = this.f75944d;
            jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
            if (this.f75944d[0] >= SystemClock.uptimeMillis() - 2000) {
                g(view);
            }
        } else if (id5 == R.id.g7m || id5 == R.id.g7n) {
            ((Activity) this.f75945e).findViewById(R.id.g7m).setVisibility(8);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}

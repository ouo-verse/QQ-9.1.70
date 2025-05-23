package com.tencent.smtt.sdk.plugin;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Process;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.utils.q;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes23.dex */
public class c extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final Context f369492a;

    public c(Context context) {
        super(context);
        this.f369492a = context;
        a();
    }

    private String b() {
        int tbsSDKVersion = WebView.getTbsSDKVersion(this.f369492a);
        return "\u5185\u6838\u7248\u672c\u4fe1\u606f\uff1a" + QbSdk.getTbsVersion(this.f369492a) + ",(" + a(this.f369492a) + ")\n\nSDK\u7248\u672c\u4fe1\u606f\uff1a" + tbsSDKVersion;
    }

    private void a() {
        LinearLayout linearLayout = new LinearLayout(this.f369492a);
        linearLayout.setOrientation(1);
        linearLayout.addView(a(q.a(this.f369492a).f369793a, 1));
        linearLayout.addView(a(b(), 2));
        addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
    }

    private File b(Context context) {
        return new File(QbSdk.getTbsFolderDir(context), "core_share");
    }

    private Button a(boolean z16, int i3) {
        Button button = new Button(getContext());
        button.setText(z16 ? "\u5207\u6362\u4e3aX5\u5185\u6838" : "\u5207\u6362\u4e3a\u7cfb\u7edf\u5185\u6838");
        button.setId(i3);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.smtt.sdk.plugin.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                q.a(c.this.f369492a).f369793a = !q.a(c.this.f369492a).f369793a;
                q.a(c.this.f369492a).c();
                c.this.a((Button) view);
                AlertDialog.Builder builder = new AlertDialog.Builder(c.this.f369492a);
                builder.setTitle("\u63d0\u793a");
                builder.setMessage("\u8bbe\u7f6e\u6210\u529f!\u70b9\u51fb\u201c\u91cd\u542f\u201d\u540e\u751f\u6548");
                builder.setPositiveButton("\u91cd\u542f", new DialogInterface.OnClickListener() { // from class: com.tencent.smtt.sdk.plugin.c.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i16) {
                        SystemMethodProxy.killProcess(Process.myPid());
                    }
                });
                builder.setNegativeButton("\u53d6\u6d88", new DialogInterface.OnClickListener() { // from class: com.tencent.smtt.sdk.plugin.c.1.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i16) {
                    }
                });
                builder.create().show();
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        return button;
    }

    private TextView a(String str, int i3) {
        TextView textView = new TextView(getContext());
        textView.setId(i3);
        textView.setText(str);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Button button) {
        button.setText(q.a(this.f369492a).f369793a ? "\u5207\u6362\u4e3aX5\u5185\u6838" : "\u5207\u6362\u4e3a\u7cfb\u7edf\u5185\u6838");
    }

    private String a(Context context) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file = new File(b(context), "tbs.conf");
            if (!file.exists()) {
                return null;
            }
            Properties properties = new Properties();
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream);
                bufferedInputStream.close();
                String property = properties.getProperty("tbs_core_build_number");
                if (property == null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    return null;
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException unused2) {
                }
                return property;
            } catch (Exception unused3) {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return null;
            } catch (Throwable th5) {
                th = th5;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        } catch (Exception unused6) {
            bufferedInputStream = null;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void a(WebView webView, Context context) {
        webView.addView(new c(context), new FrameLayout.LayoutParams(-1, -1));
    }
}

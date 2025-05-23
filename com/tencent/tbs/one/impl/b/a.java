package com.tencent.tbs.one.impl.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.optional.TBSOneDebugPlugin;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class a extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private static TBSOneManager.Policy f374611a;

    /* renamed from: b, reason: collision with root package name */
    private final String f374612b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f374613c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f374614d;

    public a(@NonNull Context context, String str) {
        super(context);
        this.f374613c = new Handler(Looper.getMainLooper());
        this.f374612b = str;
        this.f374614d = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.f374614d, layoutParams);
        com.tencent.tbs.one.impl.common.a.a(context, new TBSOneCallback<TBSOneDebugPlugin>() { // from class: com.tencent.tbs.one.impl.b.a.1
            @Override // com.tencent.tbs.one.TBSOneCallback
            public final /* synthetic */ void onCompleted(TBSOneDebugPlugin tBSOneDebugPlugin) {
                final TBSOneDebugPlugin tBSOneDebugPlugin2 = tBSOneDebugPlugin;
                a.a(a.this, new Runnable() { // from class: com.tencent.tbs.one.impl.b.a.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.a(a.this);
                        View createDebuggingView = tBSOneDebugPlugin2.createDebuggingView(a.this.getContext(), a.this.f374612b);
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                        layoutParams2.gravity = 17;
                        a.this.addView(createDebuggingView, layoutParams2);
                        a.a(a.this, "\u52a0\u8f7d\u8c03\u8bd5\u7ec4\u4ef6\u6210\u529f");
                    }
                });
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onError(int i3, String str2) {
                a.a(a.this, new Runnable() { // from class: com.tencent.tbs.one.impl.b.a.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.a(a.this);
                        a.a(a.this, "\u52a0\u8f7d\u8c03\u8bd5\u7ec4\u4ef6\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                    }
                });
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onProgressChanged(int i3, final int i16) {
                a.a(a.this, new Runnable() { // from class: com.tencent.tbs.one.impl.b.a.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.a(a.this, String.format("\u5df2\u52a0\u8f7d %d", Integer.valueOf(i16)));
                    }
                });
            }
        }, f374611a);
    }

    static /* synthetic */ void a(a aVar, String str) {
        Toast.makeText(aVar.getContext(), str, 0).show();
    }

    public static void setDebuggerPolicy(TBSOneManager.Policy policy) {
        f374611a = policy;
    }

    static /* synthetic */ void a(a aVar, Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            aVar.f374613c.post(runnable);
        }
    }

    static /* synthetic */ void a(a aVar) {
        aVar.removeView(aVar.f374614d);
    }
}

package com.tencent.gamematrix.gmcg.base.helper;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.base.utils.CGAppUtil;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGBaseHelper {
    private static final int RUN_ON_MAIN_THREAD = 1;
    private static Context mAppContext = null;
    private static boolean mEnableDebug = false;
    private static Handler mMainThreadHandler;

    public static synchronized boolean enableDebug() {
        boolean z16;
        synchronized (CGBaseHelper.class) {
            z16 = mEnableDebug;
        }
        return z16;
    }

    public static synchronized Context getAppContext() {
        Context context;
        synchronized (CGBaseHelper.class) {
            context = mAppContext;
            if (context == null) {
                context = CGAppUtil.getApplicationByReflection();
            }
        }
        return context;
    }

    public static String getRequestID() {
        return UUID.randomUUID().toString();
    }

    public static void init(@NonNull Context context) {
        init(context, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showToast$0(String str) {
        Toast.makeText(getAppContext(), str, 0).show();
    }

    public static void runOnMainThread(Runnable runnable) {
        if (mMainThreadHandler != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = runnable;
            mMainThreadHandler.sendMessage(obtain);
        }
    }

    public static void showToast(final String str) {
        if (getAppContext() != null) {
            runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.base.helper.a
                @Override // java.lang.Runnable
                public final void run() {
                    CGBaseHelper.lambda$showToast$0(str);
                }
            });
        }
    }

    public static void showToastLongTime(String str) {
        if (getAppContext() != null) {
            Toast.makeText(getAppContext(), str, 1).show();
        }
    }

    public static void init(@NonNull Context context, boolean z16) {
        mAppContext = context.getApplicationContext();
        mEnableDebug = z16;
        mMainThreadHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.gamematrix.gmcg.base.helper.CGBaseHelper.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Runnable runnable;
                if (message.what == 1 && (runnable = (Runnable) message.obj) != null) {
                    runnable.run();
                }
            }
        };
    }
}

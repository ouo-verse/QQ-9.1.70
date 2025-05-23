package d5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;

/* compiled from: P */
/* loaded from: classes38.dex */
public interface u {
    void a(Intent intent, int i3);

    boolean b(int i3);

    void c(Runnable runnable, long j3);

    <V extends View> V findViewById(int i3);

    void finish();

    Activity getActivity();

    Context getContext();

    Fragment getFragment();

    Handler getHandler();

    Intent getIntent();

    Resources getResources();

    String getString(int i3);

    Window getWindow();

    boolean isDestroyed();

    boolean isFinishing();

    void overridePendingTransition(int i3, int i16);

    void post(Runnable runnable);

    Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter);

    void sendBroadcast(Intent intent);

    void setResult(int i3);

    void setResult(int i3, Intent intent);

    void startActivity(Intent intent);

    void startActivityForResult(Intent intent, int i3);

    void unregisterReceiver(BroadcastReceiver broadcastReceiver);
}

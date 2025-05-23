package com.epicgames.ue4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BootCompleteReceiver extends BroadcastReceiver {
    public static Logger Log = new Logger("UE4", "BootCompleteReceiver");

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class Task extends AsyncTask<Void, Void, Void> {
        private WeakReference<Context> context;
        private BroadcastReceiver.PendingResult pendingResult;

        Task(BroadcastReceiver.PendingResult pendingResult, Context context) {
            this.pendingResult = pendingResult;
            this.context = new WeakReference<>(context.getApplicationContext());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            SharedPreferences sharedPreferences;
            int parseInt;
            JSONObject jSONObject;
            Context context = this.context.get();
            if (context == null || (sharedPreferences = context.getSharedPreferences("LocalNotificationPreferences", 0)) == null) {
                return null;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(sharedPreferences.getString("notificationDetails", "{}"));
                Iterator keys = jSONObject2.keys();
                boolean z16 = false;
                while (keys.hasNext()) {
                    try {
                        String str = (String) keys.next();
                        parseInt = Integer.parseInt(str);
                        jSONObject = jSONObject2.getJSONObject(str);
                    } catch (NumberFormatException | JSONException e16) {
                        BootCompleteReceiver.Log.error("Error reading notification details", e16);
                        keys.remove();
                    }
                    if (!GameActivity.LocalNotificationScheduleAtTime(context, parseInt, jSONObject.getString("local-notification-targetDateTime"), jSONObject.getBoolean("local-notification-localTime"), jSONObject.getString(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_TITLE), jSONObject.getString(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_BODY), jSONObject.getString(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_ACTION), jSONObject.getString(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_ACTION_EVENT))) {
                        keys.remove();
                        z16 = true;
                    }
                }
                if (z16) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("notificationDetails", jSONObject2.toString());
                    edit.commit();
                }
            } catch (JSONException e17) {
                BootCompleteReceiver.Log.error("Error reading notification details", e17);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Void r16) {
            super.onPostExecute((Task) r16);
            this.pendingResult.finish();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        new Task(goAsync(), context).execute(new Void[0]);
    }
}

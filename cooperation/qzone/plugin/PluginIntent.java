package cooperation.qzone.plugin;

import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.ArrayList;
import mqq.app.NewIntent;
import mqq.app.Servlet;

/* loaded from: classes38.dex */
public class PluginIntent extends NewIntent {
    public ArrayList<UPDATE_INFO> module_update_infos;
    OnResultListner onResultListner;
    public ArrayList<UPDATE_INFO> update_infos;

    /* loaded from: classes38.dex */
    public interface OnResultListner {
        void onRecieve(Intent intent, FromServiceMsg fromServiceMsg);
    }

    public PluginIntent(Context context, Class<? extends Servlet> cls) {
        super(context, cls);
    }

    public OnResultListner getResultListner() {
        return this.onResultListner;
    }

    public void setResultListner(OnResultListner onResultListner) {
        this.onResultListner = onResultListner;
    }
}

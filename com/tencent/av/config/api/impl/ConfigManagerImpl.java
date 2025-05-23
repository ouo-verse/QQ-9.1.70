package com.tencent.av.config.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.av.config.api.IConfigManager;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.avcore.jni.config.ConfigInfoJni;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ConfigManagerImpl implements IConfigManager {
    private static final String TAG = "ConfigManagerImpl";
    private BroadcastReceiver mBroadcastReceiver;
    private IConfigParser mConfigBaseParser = null;
    private int mVersion = 0;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE")) {
                ConfigManagerImpl.this.reload(context);
            } else if (action.equals("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD")) {
                ConfigManagerImpl.this.reload(context);
            }
        }
    }

    public ConfigManagerImpl() {
        this.mBroadcastReceiver = null;
        this.mBroadcastReceiver = new a();
    }

    @Override // com.tencent.av.config.api.IConfigManager
    public IConfigParser getConfigParser(Context context) {
        if (this.mConfigBaseParser == null) {
            synchronized (IConfigParser.class) {
                if (this.mConfigBaseParser == null) {
                    String sharpConfigPayloadFromFile = ConfigInfoJni.getSharpConfigPayloadFromFile(context);
                    this.mVersion = ConfigInfoJni.getSharpConfigVersionFromFile(context);
                    IConfigParser iConfigParser = (IConfigParser) QRoute.api(IConfigParser.class);
                    iConfigParser.setData(sharpConfigPayloadFromFile);
                    this.mConfigBaseParser = iConfigParser;
                    QLog.w(TAG, 1, "getParser, Version[" + this.mVersion + "], data[\n" + sharpConfigPayloadFromFile + "\n]");
                }
            }
        }
        return this.mConfigBaseParser;
    }

    @Override // com.tencent.av.config.api.IConfigManager
    public void onCreate(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
        intentFilter.addAction("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD");
        context.registerReceiver(this.mBroadcastReceiver, intentFilter);
    }

    @Override // com.tencent.av.config.api.IConfigManager
    public void onDestroy(Context context) {
        BroadcastReceiver broadcastReceiver = this.mBroadcastReceiver;
        if (broadcastReceiver != null) {
            context.unregisterReceiver(broadcastReceiver);
            this.mBroadcastReceiver = null;
        }
    }

    void reload(Context context) {
        if (this.mConfigBaseParser == null) {
            return;
        }
        int sharpConfigVersionFromFile = ConfigInfoJni.getSharpConfigVersionFromFile(context);
        if (this.mVersion != sharpConfigVersionFromFile || this.mConfigBaseParser.isEmpty()) {
            synchronized (IConfigParser.class) {
                QLog.w(TAG, 1, "reload, Version[" + this.mVersion + "->" + sharpConfigVersionFromFile + "]");
                this.mConfigBaseParser = null;
                this.mVersion = 0;
            }
        }
    }
}

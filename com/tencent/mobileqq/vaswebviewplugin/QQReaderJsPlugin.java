package com.tencent.mobileqq.vaswebviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class QQReaderJsPlugin extends VasWebviewJsPlugin {
    public static final String BROADCAST_ADD_BOOKSHELF = "com.tencent.mobileqq.jsPlugin.AddToBookShelf";
    public static final String NAMESPACE = "qqreader";
    private static final String TAG = "QQReaderJsPlugin";
    private BroadcastReceiver mReceiver;

    private void addBookShelfReceiver() {
        registerReceiver();
    }

    private void registerReceiver() {
        if (this.mReceiver == null) {
            this.mReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.vaswebviewplugin.QQReaderJsPlugin.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    Bundle extras = intent.getExtras();
                    if (QLog.isColorLevel()) {
                        QLog.d(QQReaderJsPlugin.TAG, 2, "onReceive action:" + action);
                    }
                    if (!QQReaderJsPlugin.BROADCAST_ADD_BOOKSHELF.equals(action) || extras == null) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", extras.getString("bookId"));
                        jSONObject.put("nbid", extras.getString("bookNewId"));
                    } catch (JSONException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e(QQReaderJsPlugin.TAG, 2, e16.getMessage());
                        }
                    }
                    QQReaderJsPlugin.this.dispatchJsEvent("qqReaderCenterSucceedAddingToShelf", jSONObject, null);
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(BROADCAST_ADD_BOOKSHELF);
            this.mRuntime.a().registerReceiver(this.mReceiver, intentFilter);
        }
    }

    private void unregisterReceiver() {
        if (this.mReceiver != null) {
            this.mRuntime.a().unregisterReceiver(this.mReceiver);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return NAMESPACE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest, url=" + str);
        }
        if (!NAMESPACE.equals(str2) || str == null || str3 == null || !"addBookShelfReceiver".equals(str3)) {
            return false;
        }
        addBookShelfReceiver();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver();
    }
}

package com.tenpay.cache;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tenpay.QwLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DiskCache {
    private static final String TAG = "DiskCache";
    private ICacheEnc encrypter;
    private SharedPreferences mShare;
    private String name;
    private Worker worker;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class Worker {
        private static final String KEY_SETK = "cipherKey";
        private static final String KEY_SETT = "cacheTime";
        private static final String KEY_SETV = "cipherText";
        private static final int STATUS_COMMIT_TO_DISK = 3;
        private static final int STATUS_INVALIDATE = 2;
        private static final int STATUS_REMOVE = 1;
        private static final int STATUS_SETVALUE = 0;
        private SharedPreferences.Editor editor;
        private volatile ServiceHandler mServiceHandler;
        private volatile int num;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes27.dex */
        public final class ServiceHandler extends Handler {
            ServiceHandler(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                QwLog.i("handle msg = " + message.what);
                synchronized (DiskCache.class) {
                    int i3 = message.what;
                    if (i3 == 0) {
                        Worker.this.onHandleSetValue((Bundle) message.obj);
                    } else if (i3 != 1) {
                        if (i3 == 2) {
                            Worker.this.onHandleInvalidate();
                        } else if (i3 == 3) {
                            Worker.this.onHandleCommit();
                        }
                    } else {
                        Worker.this.editor.remove((String) message.obj);
                    }
                }
                if (3 != message.what) {
                    sendEmptyMessageDelayed(3, 300L);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void onHandleCommit() {
            int i3 = this.num - 1;
            this.num = i3;
            if (i3 <= 0) {
                QwLog.i("commit num = " + this.num);
                this.editor.commit();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onHandleInvalidate() {
            int i3;
            Map<String, ?> all = DiskCache.this.mShare.getAll();
            if (all == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, ?> next = it.next();
                try {
                    if (Long.parseLong(((String) next.getValue()).substring(0, 10)) - (System.currentTimeMillis() / 1000) <= 0) {
                        arrayList.add(next.getKey());
                    }
                } catch (NumberFormatException e16) {
                    e16.printStackTrace();
                }
            }
            for (i3 = 0; i3 < arrayList.size(); i3++) {
                QwLog.i("time over remove key : " + ((String) arrayList.get(i3)));
                this.editor.remove((String) arrayList.get(i3));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onHandleSetValue(Bundle bundle) {
            String string = bundle.getString(KEY_SETK);
            String string2 = bundle.getString(KEY_SETT);
            String cacheEnc = DiskCache.this.encrypter.cacheEnc(bundle.getString(KEY_SETV));
            if (cacheEnc != null) {
                this.editor.putString(DiskCache.this.encrypter.hashKey(string), string2 + cacheEnc);
            }
        }

        public synchronized void inspectAll() {
            Message obtainMessage = this.mServiceHandler.obtainMessage(2);
            this.num++;
            this.mServiceHandler.sendMessage(obtainMessage);
        }

        public synchronized void remove(String str) {
            Message obtainMessage = this.mServiceHandler.obtainMessage(1);
            obtainMessage.obj = DiskCache.this.encrypter.hashKey(str);
            this.num++;
            this.mServiceHandler.sendMessage(obtainMessage);
        }

        public synchronized void setValue(String str, String str2, String str3) {
            synchronized (DiskCache.class) {
                Message obtainMessage = this.mServiceHandler.obtainMessage(0);
                Bundle bundle = new Bundle();
                bundle.putString(KEY_SETK, str);
                bundle.putString(KEY_SETT, str3);
                bundle.putString(KEY_SETV, str2);
                obtainMessage.obj = bundle;
                this.num++;
                this.mServiceHandler.sendMessage(obtainMessage);
            }
        }

        @SuppressLint({"CommitPrefEdits"})
        Worker() {
            this.num = 0;
            this.editor = DiskCache.this.mShare.edit();
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("IOWorker[" + DiskCache.this.name + "]");
            baseHandlerThread.start();
            this.mServiceHandler = new ServiceHandler(baseHandlerThread.getLooper());
        }
    }

    public DiskCache(Context context, String str, ICacheEnc iCacheEnc) {
        if (!TextUtils.isEmpty(str) && context != null) {
            this.encrypter = iCacheEnc;
            this.mShare = context.getSharedPreferences(str, 0);
            this.name = str;
            Worker worker = new Worker();
            this.worker = worker;
            worker.inspectAll();
            return;
        }
        throw new NullPointerException("name must specify...");
    }

    public String getValue(String str) {
        synchronized (DiskCache.class) {
            QwLog.i("get cache from disk : " + str);
            String string = this.mShare.getString(this.encrypter.hashKey(str), null);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            String substring = string.substring(0, 10);
            String cacheDec = this.encrypter.cacheDec(string.substring(10));
            QwLog.i("return cache from disk cache...");
            return String.format("%s%s", substring, cacheDec);
        }
    }

    public Worker getWorker() {
        return this.worker;
    }
}

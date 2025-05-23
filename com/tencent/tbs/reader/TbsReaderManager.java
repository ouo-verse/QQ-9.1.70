package com.tencent.tbs.reader;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import re4.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TbsReaderManager {
    public static final String TAG = "TbsReaderManager";
    protected ITbsReader mReader = null;
    protected TbsReaderCore mReaderCore = null;
    private String tempPath;

    private boolean isDebugFile(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString("filePath");
        if (TextUtils.isEmpty(string) || string.lastIndexOf("65b46dc5-21ad-4098-bf53-9b2fc9edf259.xlsx") <= 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbsReaderCore createReaderCore(Context context, ITbsReaderCallback iTbsReaderCallback, int i3) {
        ITbsReader createTbsReader = ReaderEngine.getInstance().createTbsReader(context.getApplicationContext(), Integer.valueOf(i3), iTbsReaderCallback);
        this.mReader = createTbsReader;
        return new TbsReaderCore(context, createTbsReader);
    }

    public void destroy() {
        TbsReaderCore tbsReaderCore = this.mReaderCore;
        if (tbsReaderCore != null) {
            tbsReaderCore.destroy();
        }
        this.mReaderCore = null;
        ITbsReader iTbsReader = this.mReader;
        if (iTbsReader != null) {
            iTbsReader.destroy();
        }
        this.mReader = null;
    }

    public void doAction(Integer num, Object obj, Object obj2) {
        ITbsReader iTbsReader = this.mReader;
        if (iTbsReader != null) {
            iTbsReader.doCommand(num, obj, obj2);
        }
    }

    public ReaderPluginPreLoad getPluginPre(Context context) {
        return new ReaderPluginPreLoad(context, this.mReader);
    }

    public ITbsReader getTbsReader() {
        return this.mReader;
    }

    public boolean initReader(Context context, ITbsReaderCallback iTbsReaderCallback) {
        TbsReaderCore createReaderCore = createReaderCore(context, iTbsReaderCallback, 3);
        this.mReaderCore = createReaderCore;
        if (createReaderCore == null) {
            return false;
        }
        if (createReaderCore.init(context)) {
            b.d("TbsReaderManager", "initReader, Success");
            return true;
        }
        b.b("TbsReaderManager", "initReader, Failed, Due to TbsReaderCore.init() failed");
        return false;
    }

    public void onSizeChanged(Integer num, Integer num2) {
        TbsReaderCore tbsReaderCore = this.mReaderCore;
        if (tbsReaderCore != null) {
            tbsReaderCore.onSizeChanged(num, num2);
        }
    }

    public int openFileReader(Context context, Bundle bundle, ITbsReaderCallback iTbsReaderCallback, FrameLayout frameLayout) {
        View view;
        if (isDebugFile(bundle)) {
            b.d("TbsReaderManager", "openFileReader, isDebug: true");
            view = ReaderEngine.getInstance().createDebugView(context);
            if (view != null) {
                try {
                    new AlertDialog.Builder(context).setView(view).show();
                    return 0;
                } catch (Throwable unused) {
                }
            }
        } else {
            view = null;
        }
        b.d("TbsReaderManager", "openFileReader, isDebug: false");
        return this.mReaderCore.openFile(context, bundle, frameLayout, view);
    }

    public void setTempPath(String str) {
        this.tempPath = str;
    }
}

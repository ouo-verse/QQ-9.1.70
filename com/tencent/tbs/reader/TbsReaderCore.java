package com.tencent.tbs.reader;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.tbs.logger.e;
import com.tencent.tbs.reader.ITbsReader;
import re4.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TbsReaderCore {
    public static final String TAG = "TbsReaderCore";
    protected ITbsReader.IReaderCore mReaderCore;

    public TbsReaderCore(Context context, ITbsReader iTbsReader) {
        this.mReaderCore = null;
        if (iTbsReader != null) {
            this.mReaderCore = iTbsReader.getReaderCore();
        }
    }

    public void closeFile() {
        ITbsReader.IReaderCore iReaderCore = this.mReaderCore;
        if (iReaderCore != null) {
            iReaderCore.closeFile();
        }
    }

    public void destroy() {
        closeFile();
        ITbsReader.IReaderCore iReaderCore = this.mReaderCore;
        if (iReaderCore != null) {
            iReaderCore.destroy();
        }
        this.mReaderCore = null;
    }

    public boolean init(Context context) {
        ITbsReader.IReaderCore iReaderCore = this.mReaderCore;
        if (iReaderCore != null) {
            return iReaderCore.init(context);
        }
        return false;
    }

    public void onSizeChanged(Integer num, Integer num2) {
        ITbsReader.IReaderCore iReaderCore = this.mReaderCore;
        if (iReaderCore != null) {
            iReaderCore.onSizeChanged(num, num2);
        }
    }

    public int openFile(Context context, Bundle bundle, FrameLayout frameLayout, View view) {
        int i3;
        b.d(TAG, "openFile, start. param:" + bundle.toString());
        ITbsReader.IReaderCore iReaderCore = this.mReaderCore;
        if (iReaderCore != null) {
            int openFile = iReaderCore.openFile(context, bundle, frameLayout, view);
            if (openFile != 0) {
                i3 = 1101;
            } else {
                i3 = 1100;
            }
            ReaderEngine.getInstance().report(i3, "ViewOpenFile:" + openFile, null);
            String str = "openFile, result = " + openFile;
            Log.i(TAG, str);
            e.i(TAG, str);
            b.d(TAG, str);
            return openFile;
        }
        e.g(TAG, "openFile, init failed!");
        b.b(TAG, "openFile, init failed!");
        return -1;
    }
}

package com.tencent.tbs.reader;

import android.content.Context;
import com.tencent.tbs.reader.ITbsReader;

/* loaded from: classes26.dex */
public class ReaderPluginPreLoad {
    public static final String TAG = "ReaderPluginPreLoad";
    protected ITbsReader.IReaderPlugin mReaderPlugin;

    public ReaderPluginPreLoad(Context context, ITbsReader iTbsReader) {
        this.mReaderPlugin = null;
        if (iTbsReader != null) {
            this.mReaderPlugin = iTbsReader.getReaderPlugin();
        }
        ITbsReader.IReaderPlugin iReaderPlugin = this.mReaderPlugin;
        if (iReaderPlugin != null) {
            iReaderPlugin.initPlugin(context);
        }
    }

    public void destroy() {
        ITbsReader.IReaderPlugin iReaderPlugin = this.mReaderPlugin;
        if (iReaderPlugin != null) {
            iReaderPlugin.destroy();
        }
    }

    public int downloadPlugin(Context context, String str) {
        ITbsReader.IReaderPlugin iReaderPlugin = this.mReaderPlugin;
        if (iReaderPlugin != null) {
            return iReaderPlugin.downloadPlugin(context, str);
        }
        return 0;
    }
}

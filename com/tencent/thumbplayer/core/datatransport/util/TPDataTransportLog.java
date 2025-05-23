package com.tencent.thumbplayer.core.datatransport.util;

import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportLogListener;

/* loaded from: classes26.dex */
public class TPDataTransportLog implements ITPDataTransportLog {
    private static final String DEFAULT_LOG_TAG = "tpdlnative";
    private String mFileName;
    private ITPDataTransportLogListener mLogListener;

    public TPDataTransportLog(@NonNull String str) {
        this.mFileName = str;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog
    public void d(String str) {
        d("tpdlnative", this.mFileName, 0, str);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog
    public void e(String str) {
        e("tpdlnative", this.mFileName, 0, str);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog
    public void i(String str) {
        i("tpdlnative", this.mFileName, 0, str);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog
    public void w(String str) {
        w("tpdlnative", this.mFileName, 0, str);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog
    public void d(String str, String str2, int i3, String str3) {
        if (this.mLogListener == null) {
            this.mLogListener = TPDataTransportLogFactory.getInstance().getLogListener();
        }
        ITPDataTransportLogListener iTPDataTransportLogListener = this.mLogListener;
        if (iTPDataTransportLogListener != null) {
            iTPDataTransportLogListener.d(str, "[" + str2 + ":" + i3 + "]" + str3);
            return;
        }
        Log.d("[D][" + str + "][" + str2 + ":" + i3 + "]", str3);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog
    public void e(String str, String str2, int i3, String str3) {
        if (this.mLogListener == null) {
            this.mLogListener = TPDataTransportLogFactory.getInstance().getLogListener();
        }
        ITPDataTransportLogListener iTPDataTransportLogListener = this.mLogListener;
        if (iTPDataTransportLogListener != null) {
            iTPDataTransportLogListener.e(str, "[" + str2 + ":" + i3 + "]" + str3);
            return;
        }
        Log.e("[e][" + str + "][" + str2 + ":" + i3 + "]", str3);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog
    public void i(String str, String str2, int i3, String str3) {
        if (this.mLogListener == null) {
            this.mLogListener = TPDataTransportLogFactory.getInstance().getLogListener();
        }
        ITPDataTransportLogListener iTPDataTransportLogListener = this.mLogListener;
        if (iTPDataTransportLogListener != null) {
            iTPDataTransportLogListener.i(str, "[" + str2 + ":" + i3 + "]" + str3);
            return;
        }
        Log.i("[I][" + str + "][" + str2 + ":" + i3 + "]", str3);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog
    public void w(String str, String str2, int i3, String str3) {
        if (this.mLogListener == null) {
            this.mLogListener = TPDataTransportLogFactory.getInstance().getLogListener();
        }
        ITPDataTransportLogListener iTPDataTransportLogListener = this.mLogListener;
        if (iTPDataTransportLogListener != null) {
            iTPDataTransportLogListener.w(str, "[" + str2 + ":" + i3 + "]" + str3);
            return;
        }
        Log.i("[W][" + str + "][" + str2 + ":" + i3 + "]", str3);
    }
}

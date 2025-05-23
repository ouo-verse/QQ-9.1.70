package com.tencent.thumbplayer.common.log;

import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportLogListener;

/* loaded from: classes26.dex */
public class TPDataTransportLogImpl implements ITPDataTransportLogListener {
    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportLogListener
    public void d(String str, String str2) {
        TPLogUtil.d(str, str2);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportLogListener
    public void e(String str, String str2) {
        TPLogUtil.e(str, str2);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportLogListener
    public void i(String str, String str2) {
        TPLogUtil.i(str, str2);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportLogListener
    public void w(String str, String str2) {
        TPLogUtil.w(str, str2);
    }
}

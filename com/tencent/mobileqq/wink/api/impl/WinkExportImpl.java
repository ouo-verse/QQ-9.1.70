package com.tencent.mobileqq.wink.api.impl;

import com.tencent.mobileqq.wink.api.IWinkExport;
import com.tencent.mobileqq.wink.editor.export.q;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkExportImpl implements IWinkExport {
    @Override // com.tencent.mobileqq.wink.api.IWinkExport
    public int getHDMode(String str) {
        return com.tencent.mobileqq.wink.editor.export.j.t().s(str);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkExport
    public void setHDMode(String str, Boolean bool) {
        com.tencent.mobileqq.wink.editor.export.j.t().O(str, bool.booleanValue());
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkExport
    public void setUploadSpeed(int i3, long j3, long j16) {
        q.e(i3, j3, j16);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkExport
    public boolean supportHDMode(String str) {
        return com.tencent.mobileqq.wink.editor.export.j.t().R(str);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkExport
    public void requestGenerateVideo(String str) {
    }
}

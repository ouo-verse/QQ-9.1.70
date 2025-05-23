package com.tencent.mobileqq.qqvideoedit.api.impl;

import com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditExport;
import com.tencent.mobileqq.qqvideoedit.editor.export.a;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQVideoEditExportImpl implements IQQVideoEditExport {
    @Override // com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditExport
    public int getHDMode(String str) {
        return a.g().f(str);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditExport
    public void requestGenerateVideo(String str) {
        a.g().p(str);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditExport
    public void setHDMode(String str, Boolean bool) {
        a.g().r(str, bool.booleanValue());
    }

    @Override // com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditExport
    public boolean supportHDMode(String str) {
        return a.g().t(str);
    }
}

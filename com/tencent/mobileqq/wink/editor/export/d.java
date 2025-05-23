package com.tencent.mobileqq.wink.editor.export;

import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.tavcut.core.render.exporter.ExportOutput;

/* compiled from: P */
/* loaded from: classes21.dex */
public interface d {
    void a(ExportOutput exportOutput, WinkEditDataWrapper winkEditDataWrapper, WinkExportParams winkExportParams, c cVar);

    boolean b(WinkExportParams winkExportParams, c cVar);

    void cancel();
}

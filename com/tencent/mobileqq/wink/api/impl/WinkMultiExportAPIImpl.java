package com.tencent.mobileqq.wink.api.impl;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.api.IWinkMultiExportAPI;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.export.WinkMultiExportTaskCore;
import com.tencent.mobileqq.wink.export.model.WinkExportTask;
import com.tencent.mobileqq.wink.model.WinkExportParams;

/* loaded from: classes21.dex */
public class WinkMultiExportAPIImpl implements IWinkMultiExportAPI {
    @Override // com.tencent.mobileqq.wink.api.IWinkMultiExportAPI
    public void addTask(WinkExportTask winkExportTask, x73.a aVar) {
        com.tencent.mobileqq.wink.export.d.t().p(winkExportTask, aVar);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkMultiExportAPI
    public void addTaskToMain(WinkExportTask winkExportTask) {
        WinkMultiExportTaskCore.w().r(winkExportTask);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkMultiExportAPI
    public void cancelTask(String str) {
        com.tencent.mobileqq.wink.export.d.t().r(str);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkMultiExportAPI
    public void cancelTaskToMain(String str) {
        WinkMultiExportTaskCore.w().u(str);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkMultiExportAPI
    public LocalMediaInfo getExportVideoInfo(String str) {
        return WinkExportUtils.x(str);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkMultiExportAPI
    public WinkExportParams getExportVideoParams(String str) {
        return WinkExportUtils.y(str);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkMultiExportAPI
    public boolean hasRunningTask() {
        return com.tencent.mobileqq.wink.export.d.t().u();
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkMultiExportAPI
    public void setScene(String str) {
        WinkMultiExportTaskCore.w().O(str);
    }
}

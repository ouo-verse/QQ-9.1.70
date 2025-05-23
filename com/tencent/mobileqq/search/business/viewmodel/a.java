package com.tencent.mobileqq.search.business.viewmodel;

import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/search/business/viewmodel/a;", "", "", "keyword", "", "isFirstReq", PreDownloadConstants.RPORT_KEY_REQ_TIME, "", QzoneIPCModule.RESULT_CODE, "errorMsg", "", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface a {
    void a(@NotNull String keyword, boolean isFirstReq, @NotNull String reqTime, int resultCode, @NotNull String errorMsg);
}

package com.tencent.mobileqq.search.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/search/api/ISearchDetailAppendDataService;", "Lmqq/app/api/IRuntimeService;", "canReqAppendData", "", "setAppendIntervalTime", "", "intervalTime", "", "setLatestAppendTime", "reqTimeMillSeconds", "", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public interface ISearchDetailAppendDataService extends IRuntimeService {
    boolean canReqAppendData();

    void setAppendIntervalTime(int intervalTime);

    void setLatestAppendTime(long reqTimeMillSeconds);
}

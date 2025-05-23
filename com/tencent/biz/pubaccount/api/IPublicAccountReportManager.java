package com.tencent.biz.pubaccount.api;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountReportManager extends IRuntimeService {
    void addReporting(Entity entity);

    void scheduleReport();
}

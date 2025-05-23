package com.tencent.mobileqq.search.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.nativeinterface.CoreInfo;
import java.util.List;
import java.util.Map;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes18.dex */
public interface IUserRemarkService extends IRuntimeService {
    List<CoreInfo> getExistStrangerRemarks();

    String getStrangerRemarkByUid(String str);

    String getStrangerRemarkByUin(String str);

    Map<String, String> getStrangerRemarksByUids(List<String> list);
}

package com.tencent.qqnt.emotion.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes24.dex */
public interface IEmoticonManager extends IRuntimeService {
    String getSmallEmoticonDescription(String str, String str2);

    String syncGetEmoticonDescriptionById(String str, String str2);
}

package com.tencent.mobileqq.matchfriend.reborn.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.xweb.internal.ConstValue;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/api/IQQStrangerRuntimeService;", "Lmqq/app/api/IRuntimeService;", ConstValue.EXTEND_CONFIG_KEY_HAS_LOGIN, "", "hasRegister", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public interface IQQStrangerRuntimeService extends IRuntimeService {
    boolean hasLogin();

    boolean hasRegister();
}

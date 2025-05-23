package com.tencent.qqnt.chats.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = true, process = {""})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/api/IChatsConfigRuntimeService;", "Lmqq/app/api/IRuntimeService;", "nickUseNTOrder", "", "updateNickUseNTOrder", "", "isUse", "chats_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public interface IChatsConfigRuntimeService extends IRuntimeService {
    boolean nickUseNTOrder();

    void updateNickUseNTOrder(boolean isUse);
}

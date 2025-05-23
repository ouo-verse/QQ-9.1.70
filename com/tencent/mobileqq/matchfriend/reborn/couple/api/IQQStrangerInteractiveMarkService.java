package com.tencent.mobileqq.matchfriend.reborn.couple.api;

import com.tencent.mobileqq.matchfriend.reborn.couple.b;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H&J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H&J\u001a\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/couple/api/IQQStrangerInteractiveMarkService;", "Lmqq/app/api/IRuntimeService;", "", "chatType", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "tinyIdList", "", "batchGetInteractiveMark", "peerTinyId", "", "canShownInOftenChatTab", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/b;", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "getCoupleMgr", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface IQQStrangerInteractiveMarkService extends IRuntimeService {
    void batchGetInteractiveMark(int chatType, @NotNull ArrayList<String> tinyIdList);

    boolean canShownInOftenChatTab(int chatType, @NotNull String peerTinyId);

    @Nullable
    b<? extends QQStrangerInteractiveMarkModel> getCoupleMgr(int chatType);
}

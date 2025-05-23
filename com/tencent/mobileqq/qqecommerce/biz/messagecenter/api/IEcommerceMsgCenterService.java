package com.tencent.mobileqq.qqecommerce.biz.messagecenter.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageItem;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001e\u0010\t\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00040\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/IEcommerceMsgCenterService;", "Lmqq/app/api/IRuntimeService;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "appInterface", "", "tryClearRedDotIfNeeded", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/b;", "callback", "fetchRedDotMessage", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface IEcommerceMsgCenterService extends IRuntimeService {
    void fetchRedDotMessage(@NotNull Function1<? super MessageItem, Unit> callback);

    void tryClearRedDotIfNeeded(@NotNull BaseQQAppInterface appInterface);
}

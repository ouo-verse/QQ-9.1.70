package com.tencent.mobileqq.util.conversationtitlebutton.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.util.conversationtitlebutton.ConversationTitleBtnConfig;
import com.tencent.mobileqq.util.conversationtitlebutton.c;
import com.tencent.mobileqq.util.conversationtitlebutton.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u001c\u0010\f\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/api/IConversationTitleBtnFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/util/conversationtitlebutton/c;", "conversation", "Lcom/tencent/mobileqq/util/conversationtitlebutton/d;", "createConversationTitleBtn", "Lcom/tencent/mobileqq/tianshu/data/BusinessInfoCheckUpdateItem$DynamicRedPointPathInterface;", "createTitleButtonDynamicRedPoint", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/util/conversationtitlebutton/a;", "", "callback", "createConversationTitleBtnConfig", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes20.dex */
public interface IConversationTitleBtnFactory extends QRouteApi {
    @NotNull
    d createConversationTitleBtn(@NotNull c conversation);

    void createConversationTitleBtnConfig(@NotNull Function1<? super ConversationTitleBtnConfig, Unit> callback);

    @NotNull
    BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface createTitleButtonDynamicRedPoint();
}

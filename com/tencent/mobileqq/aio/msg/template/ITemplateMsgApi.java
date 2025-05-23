package com.tencent.mobileqq.aio.msg.template;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J&\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\nH&J\b\u0010\u000f\u001a\u00020\nH&J\u0019\u0010\u0012\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&\u00a2\u0006\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/template/ITemplateMsgApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/template/a;", "createTemplateMsgView", "", "appName", "bizName", "viewName", "", "isTemplateMsg", "isDebug", "", "setIsDebug", "getIsDebug", "", "msgRecordChatType", "convertMsgRecordChatType", "(Ljava/lang/Integer;)I", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface ITemplateMsgApi extends QRouteApi {
    int convertMsgRecordChatType(@Nullable Integer msgRecordChatType);

    @Nullable
    a createTemplateMsgView(@Nullable Context context);

    boolean getIsDebug();

    boolean isTemplateMsg(@Nullable String appName, @Nullable String bizName, @Nullable String viewName);

    void setIsDebug(boolean isDebug);
}

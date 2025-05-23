package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\nJ$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/manager/IExpandConversationManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "cursor", "", "pageCount", "Lcom/tencent/mobileqq/qqexpand/manager/IExpandConversationManager$a;", "callback", "", "getConversationList", "a", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IExpandConversationManager extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H&J\u001a\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/manager/IExpandConversationManager$a;", "", "", "hasFinish", "", "cursor", "", "Lug2/a;", "conversations", "", "a", "", "errorCode", "errorMsg", "onFail", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a {
        void a(boolean hasFinish, @Nullable String cursor, @Nullable List<? extends ug2.a> conversations);

        void onFail(int errorCode, @Nullable String errorMsg);
    }

    void getConversationList(@Nullable String cursor, int pageCount, @Nullable a callback);
}

package com.tencent.biz.pubaccount.api;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\bg\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&J0\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002H&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002H&J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/pubaccount/api/IPublicAccountMsgExtMrg;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "", "", "key2Value", "", "setExt", "key2Default", "getExt", "", "getPubMsgId", "msg", "getBusiIdExtra", "getBytesOacMsgExtend", PublicAccountMessageUtilImpl.ITEM_ACTION_DATA, "getOriginalParam", "Companion", "a", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountMsgExtMrg extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f79350a;

    @NotNull
    public static final String PA_MSG_EXTRA_INFO_TYPE = "pa_msg_extra_info_type";

    @NotNull
    public static final String PA_MSG_HAS_READ = "pa_msg_has_read";

    @NotNull
    public static final String PA_MSG_ID = "pa_msg_id";

    @NotNull
    public static final String PA_MSG_TEMPLATE_ID = "pa_msg_template_id";

    @NotNull
    public static final String PA_MSG_UNREAD_FLAG = "pa_msg_unread_flag";

    @NotNull
    public static final String PA_SEND_FLAG = "pa_send_flag";

    @NotNull
    public static final String PA_SHOULD_REPORT = "pa_should_report";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/biz/pubaccount/api/IPublicAccountMsgExtMrg$a;", "", "<init>", "()V", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f79350a = new Companion();

        Companion() {
        }
    }

    @NotNull
    String getBusiIdExtra(@NotNull MsgRecord msg2);

    @NotNull
    String getBytesOacMsgExtend(@NotNull MsgRecord msg2);

    @NotNull
    Map<String, Object> getExt(@NotNull MsgRecord msgRecord, @NotNull Map<String, ? extends Object> key2Default);

    @NotNull
    String getOriginalParam(@NotNull String actionData);

    long getPubMsgId(@NotNull MsgRecord msgRecord);

    void setExt(@NotNull MsgRecord msgRecord, @NotNull Map<String, ? extends Object> key2Value);
}

package com.tencent.qqnt.chathistory.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JV\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u000726\u0010\t\u001a2\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00030\nH\u0016J\u001e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/chathistory/api/IChatHistoryMultiActionApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "deleteChatFile", "", "peer", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "msgRecordList", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "deleteCallBack", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "result", "", "errMsg", "saveMedia", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "chathistory_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IChatHistoryMultiActionApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static void a(@NotNull IChatHistoryMultiActionApi iChatHistoryMultiActionApi, @NotNull Contact peer, @NotNull List<MsgRecord> msgRecordList, @NotNull Function2<? super Integer, ? super String, Unit> deleteCallBack) {
            Intrinsics.checkNotNullParameter(peer, "peer");
            Intrinsics.checkNotNullParameter(msgRecordList, "msgRecordList");
            Intrinsics.checkNotNullParameter(deleteCallBack, "deleteCallBack");
        }

        public static void b(@NotNull IChatHistoryMultiActionApi iChatHistoryMultiActionApi, @NotNull Activity activity, @NotNull List<MsgRecord> msgRecordList) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(msgRecordList, "msgRecordList");
        }
    }

    void deleteChatFile(@NotNull Contact peer, @NotNull List<MsgRecord> msgRecordList, @NotNull Function2<? super Integer, ? super String, Unit> deleteCallBack);

    void saveMedia(@NotNull Activity activity, @NotNull List<MsgRecord> msgRecordList);
}

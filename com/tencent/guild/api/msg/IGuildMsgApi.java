package com.tencent.guild.api.msg;

import android.content.Context;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.tencent.aio.data.msglist.a;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\nH&J\b\u0010\u000f\u001a\u00020\u0006H&J\b\u0010\u0010\u001a\u00020\u0006H&J\b\u0010\u0011\u001a\u00020\u0006H&Jo\u0010 \u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00042M\u0010\u001f\u001aI\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u001d\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\r0\u0017H&J\u001a\u0010\"\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006#"}, d2 = {"Lcom/tencent/guild/api/msg/IGuildMsgApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "isSendFail", "", "getMsgSendUid", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "createAIOMsgTextView", "tv", "", "fixTextViewANRForAnd10", "getNTKernelExtDataPath", "getNTKernelDBPath", "getNTKernelTempPath", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "msgSeq", QCircleDaTongConstant.ElementParamValue.PROFILE_GUEST_TYPE, "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "ret", NotificationCompat.CATEGORY_ERROR, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "cb", "getAnnouncement", AppConstants.Key.COLUMN_MSG_SEQ, "locateToMessage", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGuildMsgApi extends QRouteApi {
    @NotNull
    TextView createAIOMsgTextView(@NotNull Context context);

    void fixTextViewANRForAnd10(@NotNull TextView tv5);

    void getAnnouncement(@NotNull Contact peer, long msgSeq, boolean guest, @NotNull Function3<? super Integer, ? super String, ? super MsgRecord, Unit> cb5);

    @NotNull
    String getMsgSendUid(@NotNull a msgItem);

    @NotNull
    String getNTKernelDBPath();

    @NotNull
    String getNTKernelExtDataPath();

    @NotNull
    String getNTKernelTempPath();

    boolean isSendFail(@NotNull a msgItem);

    void locateToMessage(long msgseq, @Nullable Context context);
}

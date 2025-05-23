package com.tencent.state.publicchat.view;

import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/publicchat/view/MsgExpReporter;", "", "()V", "reportDate", "", "reportUin", "reportedMsgIds", "", "", "sdf", "Ljava/text/SimpleDateFormat;", "currentDateStr", "report", "", "msg", "Lcom/tencent/state/publicchat/data/MsgInfo;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MsgExpReporter {
    private static final String TAG = "MsgExpReporter";
    private String reportUin;
    private final SimpleDateFormat sdf = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.CHINA);
    private String reportDate = currentDateStr();
    private final Set<Long> reportedMsgIds = new LinkedHashSet();

    private final String currentDateStr() {
        String format = this.sdf.format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "sdf.format(Date())");
        return format;
    }

    public final synchronized void report(MsgInfo msg2) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        long msgId = msg2.getHeader().getMsgId();
        boolean sys = msg2.getSys();
        String currentDateStr = currentDateStr();
        String currentAccountUin = SquareBaseKt.getSquareCommon().getCurrentAccountUin();
        if ((!Intrinsics.areEqual(this.reportDate, currentDateStr)) || (!Intrinsics.areEqual(this.reportUin, currentAccountUin))) {
            SquareBaseKt.getSquareLog().d(TAG, "\u7f13\u5b58\u91cd\u7f6e " + currentDateStr + TokenParser.SP + currentAccountUin);
            this.reportDate = currentDateStr;
            this.reportUin = currentAccountUin;
            this.reportedMsgIds.clear();
        }
        if (this.reportedMsgIds.contains(Long.valueOf(msgId))) {
            return;
        }
        this.reportedMsgIds.add(Long.valueOf(msgId));
        SquareBaseKt.getSquareLog().d(TAG, "\u6d88\u606f\u66dd\u5149\u4e0a\u62a5 isSys=" + sys + " msgId=" + msgId);
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("zplan_message_type", Integer.valueOf(sys ? 1 : 2));
        pairArr[1] = TuplesKt.to("zplan_msg_id", Long.valueOf(msgId));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        squareReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_CHAT_MSG_EXP_CTN, mutableMapOf);
    }
}

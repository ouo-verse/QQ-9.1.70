package com.tencent.robot.aio.share.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.utils.d;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import com.tencent.robot.aio.share.RobotSessionShareActionExecutor;
import com.tencent.robot.aio.share.RobotSessionShareInfo;
import com.tencent.robot.aio.share.RobotSessionShareParams;
import com.tencent.robot.aio.share.ShareStatus;
import com.tencent.util.LoadingUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a*\u0010\n\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b\u001a*\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b\u001aQ\u0010\u001b\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00132!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0015\u001aQ\u0010\u001c\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u00132!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0015H\u0002\u001a\u0016\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013\u001a\u0014\u0010\u001f\u001a\u00020\u001e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u001a\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013\u001a\u000e\u0010!\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013\u001aV\u0010%\u001a\u00020\u00192\b\b\u0002\u0010\u0014\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u001026\u0010\u001a\u001a2\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00190\"\u001a\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u0011H\u0002\u001aF\u0010.\u001a\u00020\u00192\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00190+2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190\u0015\u001aJ\u0010/\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00132\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00190\"\u00a8\u00060"}, d2 = {"Lcom/tencent/robot/aio/share/util/RobotMsgCheckResult;", "result", "", "msg", "Lcom/tencent/robot/aio/share/util/b;", "b", "Lcom/tencent/robot/aio/share/d;", "shareStatus", "Lcom/tencent/robot/aio/share/RobotSessionShareInfo;", "robotSessionShareInfo", "c", "d", "Landroid/content/Context;", "context", "", "robotUin", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", TabPreloadItem.TAB_NAME_MESSAGE, "", "type", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "checkResult", "", "callback", "e", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "g", "k", "l", "Lkotlin/Function2;", "Lcom/tencent/robot/aio/share/util/RobotMsgPreCheckResult;", "code", "f", DomainData.DOMAIN_NAME, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/robot/aio/share/RobotSessionShareParams;", "params", "Lkotlin/Function0;", "callbackAfterShare", "callBackAfterResponse", "i", "j", "robot-business-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotMsgExtKt {
    @NotNull
    public static final MsgCheckResult b(@NotNull RobotMsgCheckResult result, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new MsgCheckResult(result, msg2, null, null);
    }

    @NotNull
    public static final MsgCheckResult c(@NotNull RobotMsgCheckResult result, @NotNull String msg2, @Nullable ShareStatus shareStatus, @Nullable RobotSessionShareInfo robotSessionShareInfo) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new MsgCheckResult(result, msg2, shareStatus, robotSessionShareInfo);
    }

    @NotNull
    public static final MsgCheckResult d(@NotNull RobotMsgCheckResult result, @NotNull String msg2, @Nullable ShareStatus shareStatus, @Nullable RobotSessionShareInfo robotSessionShareInfo) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new MsgCheckResult(result, msg2, shareStatus, robotSessionShareInfo);
    }

    public static final void e(@NotNull final Context context, final long j3, @NotNull final List<? extends AIOMsgItem> msgList, final int i3, @NotNull final Function1<? super MsgCheckResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        f(i3, msgList, new Function2<RobotMsgPreCheckResult, String, Unit>() { // from class: com.tencent.robot.aio.share.util.RobotMsgExtKt$checkMsgAndFetchShareInfoThenDo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(RobotMsgPreCheckResult robotMsgPreCheckResult, String str) {
                invoke2(robotMsgPreCheckResult, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RobotMsgPreCheckResult rsult, @NotNull String msg2) {
                Intrinsics.checkNotNullParameter(rsult, "rsult");
                Intrinsics.checkNotNullParameter(msg2, "msg");
                if (RobotMsgPreCheckResult.CHECK_SUCCESS == rsult) {
                    RobotMsgExtKt.h(context, j3, msgList, i3, callback);
                } else {
                    callback.invoke(RobotMsgExtKt.b(RobotMsgCheckResult.RESULT_PRE_CHECK_FAIL, msg2));
                }
            }
        });
    }

    public static final void f(int i3, @NotNull List<? extends AIOMsgItem> msgList, @NotNull Function2<? super RobotMsgPreCheckResult, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String k3 = k(i3);
        List<? extends AIOMsgItem> list = msgList;
        boolean z16 = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (n((AIOMsgItem) it.next())) {
                    z16 = true;
                    break;
                }
            }
        }
        if (z16) {
            callback.invoke(RobotMsgPreCheckResult.CHECK_EXPIRED, "7\u5929\u524d\u6d88\u606f\u6682\u4e0d\u652f\u6301" + k3);
            return;
        }
        if (msgList.size() > 30) {
            callback.invoke(RobotMsgPreCheckResult.CHECK_OVERSIZE, "\u6700\u591a\u652f\u6301" + k3 + "30\u6761\u804a\u5929\u8bb0\u5f55");
            return;
        }
        if (msgList.isEmpty()) {
            callback.invoke(RobotMsgPreCheckResult.CHECK_EMPTY, "\u8bf7\u9009\u62e9\u8981" + k3 + "\u7684\u5185\u5bb9");
            return;
        }
        callback.invoke(RobotMsgPreCheckResult.CHECK_SUCCESS, "");
    }

    public static final boolean g(@NotNull List<? extends AIOMsgItem> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        List<? extends AIOMsgItem> list = msgList;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (d.G(((AIOMsgItem) it.next()).getMsgRecord())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Context context, long j3, List<? extends AIOMsgItem> list, final int i3, final Function1<? super MsgCheckResult, Unit> function1) {
        j(context, j3, list, i3, new Function2<ShareStatus, RobotSessionShareInfo, Unit>() { // from class: com.tencent.robot.aio.share.util.RobotMsgExtKt$executeWhenPreCheckSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ShareStatus shareStatus, RobotSessionShareInfo robotSessionShareInfo) {
                invoke2(shareStatus, robotSessionShareInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ShareStatus shareStatus, @Nullable RobotSessionShareInfo robotSessionShareInfo) {
                Intrinsics.checkNotNullParameter(shareStatus, "shareStatus");
                if (shareStatus.getIsSuccess() && robotSessionShareInfo != null) {
                    function1.invoke(RobotMsgExtKt.d(RobotMsgCheckResult.RESULT_SUCCESS, "", shareStatus, robotSessionShareInfo));
                } else {
                    function1.invoke(RobotMsgExtKt.c(RobotMsgCheckResult.RESULT_FETCH_SHARE_INFO_FAIL, RobotMsgExtKt.m(shareStatus, i3), shareStatus, robotSessionShareInfo));
                }
            }
        });
    }

    public static final void i(@NotNull Activity activity, @NotNull RobotSessionShareParams params, @NotNull List<? extends AIOMsgItem> msgList, @NotNull Function0<Unit> callbackAfterShare, @NotNull final Function1<? super ShareStatus, Unit> callBackAfterResponse) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Intrinsics.checkNotNullParameter(callbackAfterShare, "callbackAfterShare");
        Intrinsics.checkNotNullParameter(callBackAfterResponse, "callBackAfterResponse");
        final Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(activity, "\u52a0\u8f7d\u4e2d", false);
        showLoadingDialog.show();
        RobotSessionShareActionExecutor.f367323a.k(activity, params, msgList, callbackAfterShare, new Function1<ShareStatus, Unit>() { // from class: com.tencent.robot.aio.share.util.RobotMsgExtKt$fetchInfoAndShareWithLoading$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ShareStatus shareStatus) {
                invoke2(shareStatus);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ShareStatus status) {
                Intrinsics.checkNotNullParameter(status, "status");
                showLoadingDialog.dismiss();
                callBackAfterResponse.invoke(status);
            }
        });
    }

    public static final void j(@NotNull Context context, long j3, @NotNull List<? extends AIOMsgItem> msgList, int i3, @NotNull final Function2<? super ShareStatus, ? super RobotSessionShareInfo, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(context, "\u52a0\u8f7d\u4e2d", false);
        showLoadingDialog.show();
        RobotSessionShareActionExecutor.f367323a.l(j3, msgList, i3, new Function2<ShareStatus, RobotSessionShareInfo, Unit>() { // from class: com.tencent.robot.aio.share.util.RobotMsgExtKt$fetchShareInfoWithLoading$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ShareStatus shareStatus, RobotSessionShareInfo robotSessionShareInfo) {
                invoke2(shareStatus, robotSessionShareInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ShareStatus status, @Nullable RobotSessionShareInfo robotSessionShareInfo) {
                Intrinsics.checkNotNullParameter(status, "status");
                showLoadingDialog.dismiss();
                callback.invoke(status, robotSessionShareInfo);
            }
        });
    }

    @NotNull
    public static final String k(int i3) {
        if (i3 != 1) {
            if (i3 == 2 || i3 != 4) {
                return "\u5206\u4eab";
            }
            return "\u8f6c\u53d1";
        }
        return "\u6536\u85cf";
    }

    @NotNull
    public static final String l(int i3) {
        if (i3 != 1) {
            if (i3 == 2) {
                return ShareJsPlugin.ERRMSG_INVITE_REQUIRE;
            }
            if (i3 != 3) {
                if (i3 != 4) {
                    return ShareJsPlugin.ERRMSG_INVITE_REQUIRE;
                }
                return "\u8f6c\u53d1\u5931\u8d25";
            }
            return "\u751f\u6210\u5206\u4eab\u56fe\u5931\u8d25";
        }
        return "\u6536\u85cf\u5931\u8d25";
    }

    @NotNull
    public static final String m(@NotNull ShareStatus shareStatus, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(shareStatus, "shareStatus");
        if (shareStatus.getErrCode() > 20000) {
            if (shareStatus.getErrMsg().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return shareStatus.getErrMsg();
            }
        }
        return l(i3);
    }

    private static final boolean n(AIOMsgItem aIOMsgItem) {
        if ((System.currentTimeMillis() / 1000) - aIOMsgItem.getMsgRecord().msgTime > JoinTimeType.SEVEN_DAY) {
            return true;
        }
        return false;
    }
}

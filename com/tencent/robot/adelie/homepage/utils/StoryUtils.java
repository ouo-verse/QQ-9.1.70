package com.tencent.robot.adelie.homepage.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.CommandCbRequest;
import com.tencent.qqnt.kernel.nativeinterface.CommandCbRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.ICommandCbCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFetchRobotStoryHalfViewCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElement;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownStyle;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.QueryHalfViewDataReq;
import com.tencent.qqnt.kernel.nativeinterface.QueryHalfViewDataRsp;
import com.tencent.qqnt.kernel.nativeinterface.RobotBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotStoryActionSetReq;
import com.tencent.qqnt.kernel.nativeinterface.StoryAction;
import com.tencent.qqnt.kernel.nativeinterface.StoryBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.StoryKeyType;
import com.tencent.qqnt.kernel.nativeinterface.StoryUserKV;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.adelie.homepage.AdelieUtils;
import com.tencent.robot.aio.story.event.CloseSplashAIOEvent;
import com.tencent.robot.api.IRobotPersonalInfoService;
import com.tencent.robot.api.IRobotProfileInfoApi;
import com.tencent.util.LoadingUtil;
import java.net.URLEncoder;
import java.util.List;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bD\u0010EJ \u0010\u0007\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u001e\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0002J\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011Js\u0010\u001f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00112K\u0010\u001e\u001aG\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\r0\u0017J}\u0010\"\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010 2K\u0010\u001e\u001aG\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\r0\u0017Jh\u0010-\u001a\u00020\r2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010\u00022\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u001126\u0010\u001e\u001a2\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\r0+J\u000e\u00100\u001a\u00020\r2\u0006\u0010/\u001a\u00020.J \u00103\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u00010\b2\u0006\u0010/\u001a\u00020.2\u0006\u00102\u001a\u00020\u0011JF\u00107\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u00010\b2\u0006\u00104\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u00105\u001a\u00020\u00022\b\b\u0002\u00102\u001a\u00020\u00112\b\b\u0002\u00106\u001a\u00020\u0011J<\u0010:\u001a\u00020\r2\u0006\u00104\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010\f\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00109\u001a\u0004\u0018\u000108J\u001e\u0010;\u001a\u0002082\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010=\u001a\u0004\u0018\u00010<J\u0010\u0010>\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010?\u001a\u00020\r2\u0006\u0010/\u001a\u00020.J\u000e\u0010@\u001a\u00020\u00112\u0006\u0010/\u001a\u00020.R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006F"}, d2 = {"Lcom/tencent/robot/adelie/homepage/utils/StoryUtils;", "", "", "title", "", "", "specialChars", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/kernel/nativeinterface/StoryBaseInfo;", "storyBaseInfo", "", "chatType", "uid", "", "j", "tips", "k", "", "isClear", "D", "optId", "filterData", "isLocal", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "success", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataRsp;", "rsp", "cb", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "cookie", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/content/Context;", "content", "", "uin", "callbackData", "Lcom/tencent/qqnt/kernel/nativeinterface/StoryAction;", "storyAction", "withLoading", "Lkotlin/Function2;", "errMsgResId", UserInfo.SEX_FEMALE, "Lcom/tencent/aio/api/runtime/a;", "aioContext", "t", "storyInfo", "initiative", "w", "context", "nick", "closeLastAIO", "v", "Landroid/os/Bundle;", "bundle", "u", "p", "Lcom/tencent/robot/api/IRobotPersonalInfoService;", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", ReportConstant.COSTREPORT_PREFIX, "b", "Ljava/util/List;", "spChars", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class StoryUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final StoryUtils f366640a = new StoryUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Character> spChars;

    static {
        List<Character> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Character[]{'\\', '`', '*', Character.valueOf(util.base64_pad_url), '{', '}', '[', ']', '(', ')', '#', '+', '-', '.', '!'});
        spChars = listOf;
    }

    StoryUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(QueryHalfViewDataReq req, final Function3 cb5) {
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("StoryUtils-RobotStory", 1, "fetchRobotStoryHalfViewData req:" + req);
        ac O = AdelieUtils.f365929a.O();
        if (O != null) {
            O.fetchRobotStoryHalfViewData(req, new IFetchRobotStoryHalfViewCallback() { // from class: com.tencent.robot.adelie.homepage.utils.t
                @Override // com.tencent.qqnt.kernel.nativeinterface.IFetchRobotStoryHalfViewCallback
                public final void onResult(int i3, String str, QueryHalfViewDataRsp queryHalfViewDataRsp) {
                    StoryUtils.C(Function3.this, i3, str, queryHalfViewDataRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(final Function3 cb5, final int i3, final String str, final QueryHalfViewDataRsp queryHalfViewDataRsp) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("StoryUtils-RobotStory", 1, "fetchRobotStoryHalfViewData callback result:" + i3 + ", errMsg:" + str + ", robotCardRsp:" + queryHalfViewDataRsp);
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.utils.StoryUtils$refreshRobotHalfViewData$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function3<Boolean, String, QueryHalfViewDataRsp, Unit> function3 = cb5;
                Boolean valueOf = Boolean.valueOf(i3 == 0);
                String errMsg = str;
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                QueryHalfViewDataRsp rsp = queryHalfViewDataRsp;
                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                function3.invoke(valueOf, errMsg, rsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(int i3, String str) {
        QLog.i("StoryUtils-RobotStory", 1, "reportRobotStoryActionData callback result:" + i3 + ", errMsg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void G(final Function2 cb5, final int i3, final boolean z16, final Ref.ObjectRef dialog, String str, StoryAction storyAction, int i16, String str2, GroupRobotProfile groupRobotProfile) {
        RobotBaseInfo robotBaseInfo;
        String str3;
        Dialog dialog2;
        Dialog dialog3;
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(storyAction, "$storyAction");
        if (groupRobotProfile != null) {
            robotBaseInfo = groupRobotProfile.robotData;
        } else {
            robotBaseInfo = null;
        }
        if (robotBaseInfo == null) {
            QLog.e("StoryUtils-RobotStory", 1, "setRobotStoryEnter robotData is null");
            cb5.invoke(Boolean.FALSE, Integer.valueOf(i3));
            if (z16 && (dialog3 = (Dialog) dialog.element) != null) {
                dialog3.dismiss();
                return;
            }
            return;
        }
        ac O = AdelieUtils.f365929a.O();
        if (O == null) {
            QLog.e("StoryUtils-RobotStory", 1, "setRobotStoryEnter service is null");
            cb5.invoke(Boolean.FALSE, Integer.valueOf(i3));
            if (z16 && (dialog2 = (Dialog) dialog.element) != null) {
                dialog2.dismiss();
                return;
            }
            return;
        }
        long j3 = robotBaseInfo.appid;
        long j16 = robotBaseInfo.robotUin;
        if (str == null) {
            str3 = "";
        } else {
            str3 = str;
        }
        CommandCbRequest commandCbRequest = new CommandCbRequest(0L, 0L, j3, j16, "", str3, 0, 0L, 0L, 1, storyAction, robotBaseInfo.robotUid);
        QLog.e("StoryUtils-RobotStory", 1, "setRobotStoryEnter req=" + commandCbRequest);
        O.setRobotStoryEnter(commandCbRequest, new ICommandCbCallback() { // from class: com.tencent.robot.adelie.homepage.utils.s
            @Override // com.tencent.qqnt.kernel.nativeinterface.ICommandCbCallback
            public final void onResult(int i17, String str4, CommandCbRsp commandCbRsp) {
                StoryUtils.H(Function2.this, i3, z16, dialog, i17, str4, commandCbRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(final Function2 cb5, final int i3, final boolean z16, final Ref.ObjectRef dialog, final int i16, final String str, final CommandCbRsp commandCbRsp) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.utils.v
            @Override // java.lang.Runnable
            public final void run() {
                StoryUtils.I(i16, str, commandCbRsp, cb5, i3, z16, dialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void I(int i3, String str, CommandCbRsp commandCbRsp, Function2 cb5, int i16, boolean z16, Ref.ObjectRef dialog) {
        Dialog dialog2;
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        boolean z17 = true;
        QLog.d("StoryUtils-RobotStory", 1, "setRobotStoryEnter result=" + i3 + ", errMsg=" + str + ", response=" + commandCbRsp);
        if (i3 != 0) {
            z17 = false;
        }
        cb5.invoke(Boolean.valueOf(z17), Integer.valueOf(i16));
        if (z16 && (dialog2 = (Dialog) dialog.element) != null) {
            dialog2.dismiss();
        }
    }

    private final void j(StoryBaseInfo storyBaseInfo, int chatType, String uid) {
        String z16 = z(storyBaseInfo.title, spChars);
        String str = "[" + z16 + "](mqqapi://markdown/template?id=5";
        String str2 = str + "&text1=" + URLEncoder.encode(storyBaseInfo.title, "UTF-8") + "&text2=" + URLEncoder.encode(storyBaseInfo.introduce, "UTF-8") + "&plot_id=" + storyBaseInfo.storyId + ")";
        QLog.d("StoryUtils-RobotStory", 1, "addStoryCardMsg uid=" + uid + ", content=" + str2);
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 14;
        MarkdownElement markdownElement = new MarkdownElement();
        markdownElement.content = str2;
        MarkdownStyle markdownStyle = new MarkdownStyle();
        markdownStyle.layOut = "hide_avatar_and_center";
        markdownElement.style = markdownStyle;
        msgElement.markdownElement = markdownElement;
        AdelieUtils.f365929a.P(chatType, uid, msgElement, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(QueryHalfViewDataReq req, final Function3 cb5) {
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("StoryUtils-RobotStory", 1, "fetchRobotStoryHalfViewData req:" + req);
        ac O = AdelieUtils.f365929a.O();
        if (O != null) {
            O.fetchRobotStoryHalfViewData(req, new IFetchRobotStoryHalfViewCallback() { // from class: com.tencent.robot.adelie.homepage.utils.u
                @Override // com.tencent.qqnt.kernel.nativeinterface.IFetchRobotStoryHalfViewCallback
                public final void onResult(int i3, String str, QueryHalfViewDataRsp queryHalfViewDataRsp) {
                    StoryUtils.o(Function3.this, i3, str, queryHalfViewDataRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(final Function3 cb5, final int i3, final String str, final QueryHalfViewDataRsp queryHalfViewDataRsp) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("StoryUtils-RobotStory", 1, "fetchRobotStoryHalfViewData callback result:" + i3 + ", errMsg:" + str + ", robotCardRsp:" + queryHalfViewDataRsp);
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.utils.StoryUtils$fetchRobotStoryHalfViewData$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function3<Boolean, String, QueryHalfViewDataRsp, Unit> function3 = cb5;
                Boolean valueOf = Boolean.valueOf(i3 == 0);
                String errMsg = str;
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                QueryHalfViewDataRsp rsp = queryHalfViewDataRsp;
                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                function3.invoke(valueOf, errMsg, rsp);
            }
        });
    }

    public static /* synthetic */ void x(StoryUtils storyUtils, StoryBaseInfo storyBaseInfo, Context context, long j3, String str, String str2, boolean z16, boolean z17, int i3, Object obj) {
        String str3;
        boolean z18;
        boolean z19;
        if ((i3 & 16) != 0) {
            str3 = "";
        } else {
            str3 = str2;
        }
        if ((i3 & 32) != 0) {
            z18 = true;
        } else {
            z18 = z16;
        }
        if ((i3 & 64) != 0) {
            z19 = true;
        } else {
            z19 = z17;
        }
        storyUtils.v(storyBaseInfo, context, j3, str, str3, z18, z19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "$aioContext");
        com.tencent.mvi.base.route.j e16 = aioContext.e();
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_force_close_aio", true);
        Unit unit = Unit.INSTANCE;
        e16.h(new ExternalCommIntent("close_aio", bundle));
    }

    private final String z(String title, List<Character> specialChars) {
        boolean z16;
        boolean z17;
        if (title != null && title.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        while (i3 < title.length()) {
            int codePointAt = title.codePointAt(i3);
            char[] charArray = Character.toChars(codePointAt);
            Intrinsics.checkNotNullExpressionValue(charArray, "charArray");
            String str = new String(charArray);
            int length = charArray.length;
            int i16 = 0;
            while (true) {
                if (i16 < length) {
                    if (specialChars.contains(Character.valueOf(charArray[i16]))) {
                        z17 = true;
                        break;
                    }
                    i16++;
                } else {
                    z17 = false;
                    break;
                }
            }
            if (z17) {
                sb5.append('\\');
            }
            sb5.append(str);
            i3 += Character.charCount(codePointAt);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "escapedTitle.toString()");
        return sb6;
    }

    public final void A(@NotNull String uid, int optId, @NotNull String filterData, boolean isLocal, @Nullable byte[] cookie, @NotNull final Function3<? super Boolean, ? super String, ? super QueryHalfViewDataRsp, Unit> cb5) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(filterData, "filterData");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        final QueryHalfViewDataReq queryHalfViewDataReq = new QueryHalfViewDataReq();
        queryHalfViewDataReq.uid = uid;
        queryHalfViewDataReq.optId = optId;
        queryHalfViewDataReq.filterData = filterData;
        queryHalfViewDataReq.getLocalData = isLocal;
        queryHalfViewDataReq.pagingCookie = cookie;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.utils.o
            @Override // java.lang.Runnable
            public final void run() {
                StoryUtils.B(QueryHalfViewDataReq.this, cb5);
            }
        }, 128, null, true);
    }

    public final void D(@NotNull String uid, boolean isClear) {
        StoryBaseInfo storyBaseInfo;
        Intrinsics.checkNotNullParameter(uid, "uid");
        IRobotPersonalInfoService r16 = r();
        if (r16 != null) {
            storyBaseInfo = r16.getStoryBaseInfo(uid);
        } else {
            storyBaseInfo = null;
        }
        if (storyBaseInfo == null) {
            QLog.i("StoryUtils-RobotStory", 1, "reportRobotStoryActionData storyBaseInfo == null");
            return;
        }
        RobotStoryActionSetReq robotStoryActionSetReq = new RobotStoryActionSetReq();
        robotStoryActionSetReq.robotUid = uid;
        StoryUserKV storyUserKV = robotStoryActionSetReq.storyKV;
        storyUserKV.keyType = StoryKeyType.AIOSTORY;
        storyUserKV.storyInfo = storyBaseInfo;
        storyUserKV.isClear = isClear;
        QLog.i("StoryUtils-RobotStory", 1, "reportRobotStoryActionData req:" + robotStoryActionSetReq);
        ac O = AdelieUtils.f365929a.O();
        if (O != null) {
            O.reportRobotStoryActionData(robotStoryActionSetReq, new IOperateCallback() { // from class: com.tencent.robot.adelie.homepage.utils.r
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    StoryUtils.E(i3, str);
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, android.app.Dialog] */
    public final void F(@NotNull Context content, long uin, @Nullable final String callbackData, @NotNull final StoryAction storyAction, final boolean withLoading, @NotNull final Function2<? super Boolean, ? super Integer, Unit> cb5) {
        final int i3;
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(storyAction, "storyAction");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        QLog.d("StoryUtils-RobotStory", 1, "setRobotStoryEnter uin=" + StringUtil.getSimpleUinForPrint(String.valueOf(uin)) + ", callbackData=" + callbackData + ", storyAction=" + storyAction);
        if (!AppNetConnInfo.isNetSupport()) {
            cb5.invoke(Boolean.FALSE, Integer.valueOf(R.string.ci7));
            return;
        }
        if (storyAction == StoryAction.QUITSTORY) {
            i3 = R.string.f223556gj;
        } else {
            i3 = R.string.f223536gh;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (withLoading) {
            ?? showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(content, 2, true);
            objectRef.element = showOnlyLoadingImageDialog;
            showOnlyLoadingImageDialog.show();
        }
        ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).getRobotProfileInfoFromLocal(String.valueOf(uin), null, new IGetGroupRobotProfileCallback() { // from class: com.tencent.robot.adelie.homepage.utils.q
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
            public final void onResult(int i16, String str, GroupRobotProfile groupRobotProfile) {
                StoryUtils.G(Function2.this, i3, withLoading, objectRef, callbackData, storyAction, i16, str, groupRobotProfile);
            }
        });
    }

    public final void k(@NotNull String uid, int chatType, @NotNull String tips) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(tips, "tips");
        QLog.i("StoryUtils-RobotStory", 1, "addLocalStoryTips uid=" + uid + ", tips=" + tips);
        LocalGrayTip m3 = LocalGrayTip.LocalGrayTipBuilder.i(new LocalGrayTip.LocalGrayTipBuilder(uid, chatType, JsonGrayBusiId.UI_ROBOT_AIO_STORY, 0, true, false, null, 8, null), tips, 0, 2, null).m();
        INtGrayTipApi iNtGrayTipApi = (INtGrayTipApi) QRoute.api(INtGrayTipApi.class);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        iNtGrayTipApi.addLocalGrayTip(peekAppRuntime, m3, null);
    }

    public final void l(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        int e16 = aioContext.g().r().c().e();
        String j3 = aioContext.g().r().c().j();
        AIOParam g16 = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        long a16 = su3.c.a(g16);
        String g17 = aioContext.g().r().c().g();
        Context context = aioContext.c().getContext();
        if (context == null) {
            return;
        }
        QLog.i("StoryUtils-RobotStory", 1, "exitStoryAIO uid=" + j3 + " nick=" + g17);
        IRobotPersonalInfoService r16 = r();
        if (r16 != null) {
            r16.removeFromCache(j3);
        }
        String string = context.getString(R.string.f223566gk);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.robot_story_exit_tips)");
        k(j3, e16, string);
        ((IAIOStarterApi) QRoute.api(IAIOStarterApi.class)).navigateToAIOActivity(context, 1, j3, g17, 67108864, a16, new Bundle());
        if (aioContext.g().l().getBoolean("key_from_splash_activity")) {
            aioContext.e().h(new ExternalCommIntent("close_aio", new Bundle()));
        }
    }

    public final void m(@NotNull String uid, int optId, @NotNull String filterData, boolean isLocal, @NotNull final Function3<? super Boolean, ? super String, ? super QueryHalfViewDataRsp, Unit> cb5) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(filterData, "filterData");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        final QueryHalfViewDataReq queryHalfViewDataReq = new QueryHalfViewDataReq();
        queryHalfViewDataReq.uid = uid;
        queryHalfViewDataReq.optId = optId;
        queryHalfViewDataReq.filterData = filterData;
        queryHalfViewDataReq.getLocalData = isLocal;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.utils.p
            @Override // java.lang.Runnable
            public final void run() {
                StoryUtils.n(QueryHalfViewDataReq.this, cb5);
            }
        }, 128, null, true);
    }

    @NotNull
    public final Bundle p(@NotNull String uid, @NotNull String uin, int chatType) {
        boolean z16;
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (chatType != 1) {
            return new Bundle();
        }
        if (uid.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
            Intrinsics.checkNotNullExpressionValue(uid, "api(IRelationNTUinAndUid\u2026.java).getUidFromUin(uin)");
            QLog.i("StoryUtils-RobotStory", 1, "fillStoryBaseInfo uin=" + StringUtil.getSimpleUinForPrint(uin) + ", newUid=" + uid);
        }
        StoryBaseInfo q16 = q(uid);
        QLog.i("StoryUtils-RobotStory", 1, "fillStoryBaseInfo newUid=" + uid + " " + q16);
        if (q16 == null) {
            return new Bundle();
        }
        Bundle bundle = new Bundle();
        bundle.putLong("key_robot_story_id", q16.storyId);
        bundle.putString("key_robot_story_data", q16.callbackData);
        bundle.putString("key_robot_story_name", q16.name);
        bundle.putString("key_day_bg", q16.dayBackground);
        bundle.putString("key_night_bg", q16.nightBackground);
        bundle.putString("key_day_color", q16.dayBackgroundColor);
        bundle.putString("key_night_color", q16.nightBackgroundColor);
        bundle.putString("key_day_dynamic_bg", q16.dayDynamicPic);
        bundle.putString("key_night_dynamic_bg", q16.nightDynamicPic);
        return bundle;
    }

    @Nullable
    public final StoryBaseInfo q(@NotNull String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        IRobotPersonalInfoService r16 = r();
        if (r16 != null) {
            return r16.getStoryBaseInfo(uid);
        }
        return null;
    }

    @Nullable
    public final IRobotPersonalInfoService r() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return (IRobotPersonalInfoService) peekAppRuntime.getRuntimeService(IRobotPersonalInfoService.class, "");
        }
        return null;
    }

    public final boolean s(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        int i3 = aioContext.g().l().getInt("key_robot_story_aio_from", 0);
        if (i3 != 1 && i3 != 2) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0035, code lost:
    
        if (r1.getMsgRecordStatus(r0) == true) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t(@NotNull final com.tencent.aio.api.runtime.a aioContext) {
        boolean z16;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        final Context context = aioContext.c().getContext();
        if (context == null) {
            return;
        }
        String j3 = aioContext.g().r().c().j();
        if (AdelieUtils.f365929a.T(aioContext)) {
            IRobotPersonalInfoService r16 = r();
            if (r16 != null) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                IRobotPersonalInfoService r17 = r();
                if (r17 != null) {
                    r17.putMsgRecordStatus(j3, false);
                }
                String string = aioContext.g().l().getString("key_robot_story_data");
                AIOParam g16 = aioContext.g();
                Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
                F(context, su3.c.a(g16), string, StoryAction.QUITSTORY, true, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.robot.adelie.homepage.utils.StoryUtils$onResume$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                        invoke(bool.booleanValue(), num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z17, int i3) {
                        if (z17) {
                            StoryUtils storyUtils = StoryUtils.f366640a;
                            storyUtils.D(com.tencent.aio.api.runtime.a.this.g().r().c().j(), true);
                            storyUtils.l(com.tencent.aio.api.runtime.a.this);
                            return;
                        }
                        QQToast.makeText(context, 1, i3, 1).show();
                    }
                });
            }
        }
    }

    public final void u(@NotNull Context context, long uin, @NotNull String uid, @NotNull String nick, @Nullable StoryBaseInfo storyInfo, @Nullable Bundle bundle) {
        Bundle bundle2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        if (storyInfo == null) {
            QLog.d("StoryUtils-RobotStory", 1, "openStoryAIO return, storyInfo == null");
            return;
        }
        QLog.d("StoryUtils-RobotStory", 1, "openStoryAIO uid=" + uid + ", " + storyInfo);
        String name = storyInfo.name;
        if (name.length() > 13) {
            Intrinsics.checkNotNullExpressionValue(name, "name");
            String substring = name.substring(0, 13);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            name = substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        String string = context.getString(R.string.f223546gi, name);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026t_story_enter_tips, name)");
        k(uid, 1, string);
        j(storyInfo, 1, uid);
        IRobotPersonalInfoService r16 = r();
        if (r16 != null) {
            r16.addToCache(uid, storyInfo);
        }
        IRobotPersonalInfoService r17 = r();
        if (r17 != null) {
            r17.removeRobotListener(uid, null);
        }
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        Bundle bundle3 = bundle2;
        bundle3.putBoolean("key_robot_story_aio_initiative", true);
        bundle3.putInt("key_robot_story_aio_from", 2);
        ((IAIOStarterApi) QRoute.api(IAIOStarterApi.class)).navigateToAIOActivity(context, 1, uid, nick, 67108864, uin, bundle3);
        SimpleEventBus.getInstance().dispatchEvent(CloseSplashAIOEvent.INSTANCE);
    }

    public final void v(@Nullable StoryBaseInfo storyInfo, @NotNull Context context, long uin, @NotNull String uid, @NotNull String nick, boolean initiative, boolean closeLastAIO) {
        int i3;
        Activity activity;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        if (storyInfo == null) {
            QLog.d("StoryUtils-RobotStory", 1, "openStoryAIO return, storyInfo == null");
            return;
        }
        QLog.d("StoryUtils-RobotStory", 1, "openStoryAIO uin=" + uin + " uid=" + uid + " " + storyInfo);
        String name = storyInfo.name;
        if (name.length() > 13) {
            Intrinsics.checkNotNullExpressionValue(name, "name");
            String substring = name.substring(0, 13);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            name = substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        String string = context.getString(R.string.f223546gi, name);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026t_story_enter_tips, name)");
        k(uid, 1, string);
        j(storyInfo, 1, uid);
        IRobotPersonalInfoService r16 = r();
        if (r16 != null) {
            r16.addToCache(uid, storyInfo);
        }
        Intent intent = null;
        if (initiative) {
            IRobotPersonalInfoService r17 = r();
            if (r17 != null) {
                r17.removeRobotListener(uid, null);
            }
            i3 = 1;
        } else {
            i3 = 0;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_robot_story_aio_initiative", initiative);
        bundle.putInt("key_robot_story_aio_from", i3);
        ((IAIOStarterApi) QRoute.api(IAIOStarterApi.class)).navigateToAIOActivity(context, 1, uid, nick, 67108864, uin, bundle);
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            intent = activity.getIntent();
        }
        if (intent != null && closeLastAIO && intent.getBooleanExtra("key_from_splash_activity", false)) {
            com.tencent.qqnt.aio.activity.h hVar = com.tencent.qqnt.aio.activity.h.f348481a;
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("key_force_close_aio", true);
            Unit unit = Unit.INSTANCE;
            hVar.c(new ExternalCommIntent("close_aio", bundle2));
        }
    }

    public final void w(@Nullable StoryBaseInfo storyInfo, @NotNull final com.tencent.aio.api.runtime.a aioContext, boolean initiative) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        if (storyInfo == null) {
            QLog.d("StoryUtils-RobotStory", 1, "openStoryAIO return, storyInfo == null");
            return;
        }
        Context context = aioContext.c().getContext();
        if (context == null) {
            return;
        }
        AIOParam g16 = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        v(storyInfo, context, su3.c.a(g16), aioContext.g().r().c().j(), aioContext.g().r().c().g(), initiative, false);
        if (aioContext.g().l().getBoolean("key_from_splash_activity")) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.robot.adelie.homepage.utils.w
                @Override // java.lang.Runnable
                public final void run() {
                    StoryUtils.y(com.tencent.aio.api.runtime.a.this);
                }
            }, 300L);
        }
    }
}

package com.tencent.qqnt.msg.api;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.api.t;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.AttaReportData;
import com.tencent.qqnt.kernel.nativeinterface.ContactMsgBoxInfo;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DevInfo;
import com.tencent.qqnt.kernel.nativeinterface.FeedBackDataForMsg;
import com.tencent.qqnt.kernel.nativeinterface.FeedBackMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupAnonymousInfo;
import com.tencent.qqnt.kernel.nativeinterface.IClickInlineKeyboardButtonCallback;
import com.tencent.qqnt.kernel.nativeinterface.IForwardOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetAioFirstViewLatestMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGuildBinaryDataCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGuildGroupBubbleCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgAbstractsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgEmojiLikesListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgSeqCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgsBoxesCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetRecentUseEmojiListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGuestGetMsgAbstractsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGuildMatchedOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgsRspOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRenameAnonymousChatNickCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetMsgEmojiLikesCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetMsgEmojiLikesForRoleCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISwitchAnonymousChatCallback;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardClickInfo;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.MatchKey;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.MsgTypeFilter;
import com.tencent.qqnt.kernel.nativeinterface.MsgsReq;
import com.tencent.qqnt.kernel.nativeinterface.QueryMsgsParams;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernel.nativeinterface.SceneInfoParam;
import com.tencent.qqnt.kernel.nativeinterface.TargetFileInfo;
import com.tencent.qqnt.kernel.nativeinterface.TofuRecordElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.LocalGrayTipElement;
import com.tencent.qqnt.msg.data.d;
import com.tencent.qqnt.msg.data.e;
import com.tencent.qqnt.msg.data.f;
import com.tencent.qqnt.msg.data.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d2\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J(\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015H&J:\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&Jd\u0010!\u001a\u00020\u00042\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0013j\b\u0012\u0004\u0012\u00020\u0018`\u00152\u0006\u0010\u001c\u001a\u00020\u00112\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0013j\b\u0012\u0004\u0012\u00020\u0011`\u00152\u001a\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u00152\u0006\u0010 \u001a\u00020\u001fH&J \u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0007H&J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&H&J\u0010\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0&H&JP\u00102\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u001a\u00100\u001a\u0016\u0012\u0004\u0012\u00020/\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020/\u0018\u0001`\u00152\b\u0010\b\u001a\u0004\u0018\u000101H&J\u0010\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u00020-H&J:\u0010;\u001a\u00020\u00042\u0006\u00106\u001a\u0002052\u0016\u00107\u001a\u0012\u0012\u0004\u0012\u0002050\u0013j\b\u0012\u0004\u0012\u000205`\u00152\u0006\u00108\u001a\u00020+2\b\u0010:\u001a\u0004\u0018\u000109H&J\"\u0010=\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u00010<H&J\"\u0010>\u001a\u00020\u00042\u0006\u00106\u001a\u0002052\u0010\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u000105\u0018\u00010\u0013H&J\u0012\u0010?\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\u0010\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020@H&J\u0010\u0010C\u001a\u00020\u00042\u0006\u0010A\u001a\u00020@H&J\u0012\u0010E\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010DH&J>\u0010K\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010F\u001a\u00020\u00182\b\u0010G\u001a\u0004\u0018\u0001052\u0006\u0010H\u001a\u00020\u00182\u0006\u0010I\u001a\u00020-2\b\u0010 \u001a\u0004\u0018\u00010JH&J^\u0010R\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010F\u001a\u00020\u00182\b\u0010G\u001a\u0004\u0018\u0001052\u0006\u0010H\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u00182\u0006\u0010M\u001a\u00020\u00182\u0006\u0010I\u001a\u00020-2\u0006\u0010N\u001a\u00020-2\u0006\u0010P\u001a\u00020O2\b\u0010 \u001a\u0004\u0018\u00010QH&JP\u0010W\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010F\u001a\u00020\u00182\b\u0010G\u001a\u0004\u0018\u0001052\u0006\u0010H\u001a\u00020\u00182\b\u0010S\u001a\u0004\u0018\u0001052\u0006\u0010T\u001a\u00020-2\u0006\u0010U\u001a\u00020+2\b\u0010 \u001a\u0004\u0018\u00010VH&J4\u0010\\\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\"\u0010[\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020Y0Xj\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020Y`ZH&JA\u0010_\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020^0\u0013j\b\u0012\u0004\u0012\u00020^`\u00150]2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010F\u001a\u00020\u00182\u0006\u0010N\u001a\u00020-H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b_\u0010`J:\u0010b\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010a\u001a\u00020\u00182\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\b\u0010 \u001a\u0004\u0018\u00010\u0007H&J\"\u0010d\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010a\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010cH&J\"\u0010e\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010a\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010\u0007H&J4\u0010g\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0016\u0010f\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0013j\b\u0012\u0004\u0012\u00020\u0018`\u00152\b\u0010\b\u001a\u0004\u0018\u000101H&J\u001c\u0010k\u001a\u00020\u00042\b\u0010i\u001a\u0004\u0018\u00010h2\b\u0010:\u001a\u0004\u0018\u00010jH&J*\u0010p\u001a\u00020\u00042\u0006\u0010l\u001a\u00020\u00112\u0006\u0010n\u001a\u00020m2\u0006\u0010o\u001a\u00020-2\b\u0010 \u001a\u0004\u0018\u00010\u0007H&J\"\u0010s\u001a\u00020\u00042\u0006\u0010l\u001a\u00020\u00112\u0006\u0010r\u001a\u00020q2\b\u0010 \u001a\u0004\u0018\u00010\u0007H&J<\u0010v\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010t\u001a\u00020\u00182\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00108\u001a\u00020+2\b\u0010:\u001a\u0004\u0018\u00010uH&J:\u0010z\u001a\u00020\u00042\u0006\u0010w\u001a\u00020+2\u0006\u0010x\u001a\u00020\u00182\u0016\u0010y\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0013j\b\u0012\u0004\u0012\u00020\u0018`\u00152\b\u0010 \u001a\u0004\u0018\u00010\u0007H&J:\u0010{\u001a\u00020\u00042\u0006\u0010w\u001a\u00020+2\u0006\u0010x\u001a\u00020\u00182\u0016\u0010y\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0013j\b\u0012\u0004\u0012\u00020\u0018`\u00152\b\u0010 \u001a\u0004\u0018\u00010\u0007H&J\b\u0010|\u001a\u00020\u0004H&J\u001c\u0010~\u001a\u00020\u00042\b\u0010}\u001a\u0004\u0018\u00010^2\b\u0010 \u001a\u0004\u0018\u00010\u0007H&J2\u0010\u007f\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\b\u0010 \u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\u0081\u0001\u001a\u00020\u00042\u0007\u0010\u0080\u0001\u001a\u00020+H&J3\u0010\u0082\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&JZ\u0010\u0082\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152%\u0010\u0084\u0001\u001a \u0012\u0004\u0012\u00020+\u0012\u0005\u0012\u00030\u0083\u00010Xj\u000f\u0012\u0004\u0012\u00020+\u0012\u0005\u0012\u00030\u0083\u0001`Z2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J;\u0010\u0082\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J0\u0010\u0086\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010&2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-H&J \u0010\u0087\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010&2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010,\u001a\u00020+H&J\u000f\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110&H&J\u0017\u0010\u008b\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u008a\u00010\u0089\u00010&H&J\u0010\u0010\u008d\u0001\u001a\t\u0012\u0005\u0012\u00030\u008c\u00010&H&J!\u0010\u008e\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030\u008a\u00010\u0013j\t\u0012\u0005\u0012\u00030\u008a\u0001`\u00150&H&J#\u0010\u008f\u0001\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u00150&H&J\u0010\u0010\u0090\u0001\u001a\t\u0012\u0005\u0012\u00030\u008a\u00010&H&J!\u0010\u0091\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030\u008a\u00010\u0013j\t\u0012\u0005\u0012\u00030\u008a\u0001`\u00150&H&J\u0010\u0010\u0093\u0001\u001a\t\u0012\u0005\u0012\u00030\u0092\u00010&H&J\u0010\u0010\u0094\u0001\u001a\t\u0012\u0005\u0012\u00030\u0092\u00010&H&J\u0010\u0010\u0095\u0001\u001a\t\u0012\u0005\u0012\u00030\u0092\u00010&H&J\u0010\u0010\u0097\u0001\u001a\t\u0012\u0005\u0012\u00030\u0096\u00010&H&J\u001b\u0010\u0098\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J1\u0010\u0099\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u0010\b\u001a\u000201H'J/\u0010\u009c\u0001\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0007\u0010\u009a\u0001\u001a\u00020\u00182\u0007\u0010\u009b\u0001\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u000101H&J5\u0010\u009d\u0001\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010F\u001a\u00020\u00182\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\b\u0010\b\u001a\u0004\u0018\u000101H'J\u001e\u0010\u00a1\u0001\u001a\u00020\u00042\b\u0010\u009f\u0001\u001a\u00030\u009e\u00012\t\u0010 \u001a\u0005\u0018\u00010\u00a0\u0001H&J=\u0010\u00a2\u0001\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u001e\u0010\u001b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0013j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u0001`\u00152\b\u0010\b\u001a\u0004\u0018\u000101H&J%\u0010\u00a3\u0001\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010F\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u000101H&J/\u0010\u00a6\u0001\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0007\u0010\u00a4\u0001\u001a\u00020\u00182\u0007\u0010\u00a5\u0001\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u000101H&J#\u0010\u00a9\u0001\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0007\u0010\u00a7\u0001\u001a\u0002052\u0007\u0010\u00a8\u0001\u001a\u00020+H&J#\u0010\u00aa\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J$\u0010\u00ac\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0007\u0010\u00ab\u0001\u001a\u00020^2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001b\u0010\u00ad\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0013\u0010\u00ae\u0001\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J#\u0010\u00af\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010\u0007H&J#\u0010\u00b0\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010\u0007H&J#\u0010\u00b1\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J5\u0010\u00b2\u0001\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0013j\b\u0012\u0004\u0012\u00020\u0018`\u00152\b\u0010\b\u001a\u0004\u0018\u000101H&J\u001a\u0010\u00b4\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0007\u0010\b\u001a\u00030\u00b3\u0001H&J%\u0010\u00b5\u0001\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010\u0007H&J7\u0010\u00b6\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u00152\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J6\u0010\u00ba\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0007\u0010\u00b7\u0001\u001a\u00020\u00182\u0007\u0010\u00b8\u0001\u001a\u00020\u00182\u0007\u0010\u00b9\u0001\u001a\u00020Y2\b\u0010 \u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u00bc\u0001\u001a\t\u0012\u0005\u0012\u00030\u00bb\u00010&H&J!\u0010\u00bd\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010,\u001a\u00020+2\u0006\u0010 \u001a\u000201H&J\"\u0010\u00bf\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010,\u001a\u00020+2\u0007\u0010 \u001a\u00030\u00be\u0001H&J.\u0010\u00c1\u0001\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0007\u0010\u00c0\u0001\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u000101H&J+\u0010\u00c3\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0007\u0010\u00b7\u0001\u001a\u00020\u00182\u0007\u0010\u00c2\u0001\u001a\u00020\u00182\u0006\u0010 \u001a\u000201H&J3\u0010\u00c4\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\b\u0010:\u001a\u0004\u0018\u00010\u0007H&J\u001b\u0010\u00c5\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010:\u001a\u0004\u0018\u00010cH&J\u001b\u0010\u00c6\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\u0007H&J+\u0010\u00c9\u0001\u001a\u00020\u00042\u0017\u0010\u00c7\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0013j\b\u0012\u0004\u0012\u00020\u0011`\u00152\u0007\u0010 \u001a\u00030\u00c8\u0001H&J!\u0010\u00cb\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030\u00ca\u00010\u0013j\t\u0012\u0005\u0012\u00030\u00ca\u0001`\u00150&H&JH\u0010\u00d0\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0019\u0010\u00cd\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u00cc\u00010\u0013j\t\u0012\u0005\u0012\u00030\u00cc\u0001`\u00152\u0007\u0010\u00ce\u0001\u001a\u00020-2\u0007\u0010\u00cf\u0001\u001a\u00020-2\b\u0010 \u001a\u0004\u0018\u00010\u0007H&J$\u0010\u00d2\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0007\u0010\u00d1\u0001\u001a\u00020-2\b\u0010 \u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\u00d4\u0001\u001a\u00020\u00042\u0007\u0010\u00d3\u0001\u001a\u00020+H&J\u0012\u0010\u00d5\u0001\u001a\u00020\u00042\u0007\u0010\u00d3\u0001\u001a\u00020+H&J\u0012\u0010\u00d6\u0001\u001a\u00020\u00042\u0007\u0010\u00d3\u0001\u001a\u00020+H&J\u0012\u0010\u00d7\u0001\u001a\u00020\u00042\u0007\u0010\u00d3\u0001\u001a\u00020+H&J\u001e\u0010\u00d9\u0001\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\t\u0010 \u001a\u0005\u0018\u00010\u00d8\u0001H&J.\u0010\u00db\u0001\u001a\u00020\u00042#\u0010\u00da\u0001\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u0002050Xj\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u000205`ZH&J\u001b\u0010\u00dc\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\u0007H&J%\u0010\u00df\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0007\u0010\u00dd\u0001\u001a\u00020-2\t\u0010 \u001a\u0005\u0018\u00010\u00de\u0001H&J\u0010\u0010\u00e1\u0001\u001a\t\u0012\u0005\u0012\u00030\u00e0\u00010&H&J\u0010\u0010\u00e3\u0001\u001a\t\u0012\u0005\u0012\u00030\u00e2\u00010&H&J,\u0010\u00e6\u0001\u001a\u00020\u00042\u0007\u0010\u00a8\u0001\u001a\u00020+2\u0007\u0010\u00e4\u0001\u001a\u00020+2\u0007\u0010\u00e5\u0001\u001a\u0002052\u0006\u0010 \u001a\u00020\u0007H&J(\u0010\u00ea\u0001\u001a\u00020\u00042\t\u0010\u00e7\u0001\u001a\u0004\u0018\u0001052\u0007\u0010\u00e8\u0001\u001a\u00020-2\t\u0010 \u001a\u0005\u0018\u00010\u00e9\u0001H&J\u001f\u0010\u00ec\u0001\u001a\u00020\u00042\t\u0010\u00e7\u0001\u001a\u0004\u0018\u0001052\t\u0010 \u001a\u0005\u0018\u00010\u00eb\u0001H&J\u0017\u0010\u00ee\u0001\u001a\u0005\u0018\u00010\u00ed\u00012\t\u0010\u00e7\u0001\u001a\u0004\u0018\u000105H&J4\u0010\u00f1\u0001\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0007\u0010\u00a5\u0001\u001a\u00020\u00182\u0006\u0010F\u001a\u00020\u00182\b\u0010\u00f0\u0001\u001a\u00030\u00ef\u00012\u0006\u0010 \u001a\u000201H&J\u0017\u0010\u00f2\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u008a\u00010\u0089\u00010&H&J\u0010\u0010\u00f3\u0001\u001a\t\u0012\u0005\u0012\u00030\u008a\u00010&H&J\u001c\u0010\u00f7\u0001\u001a\u00020\u00042\b\u0010\u00f5\u0001\u001a\u00030\u00f4\u00012\u0007\u0010 \u001a\u00030\u00f6\u0001H&J\u001c\u0010\u00f8\u0001\u001a\u00020\u00042\u0007\u0010\u00a8\u0001\u001a\u00020+2\b\u0010 \u001a\u0004\u0018\u00010DH&J\u0014\u0010\u00f9\u0001\u001a\u0004\u0018\u00010\u0018H&\u00a2\u0006\u0006\b\u00f9\u0001\u0010\u00fa\u0001J-\u0010\u00ff\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u00fc\u0001\u001a\u00030\u00fb\u00012\b\u0010\u00fe\u0001\u001a\u00030\u00fd\u00012\u0006\u0010 \u001a\u00020\u0007H&J\u0012\u0010\u0081\u0002\u001a\u00020\u00042\u0007\u0010\u0080\u0002\u001a\u00020-H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0082\u0002"}, d2 = {"Lcom/tencent/qqnt/msg/api/IMsgService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/qqnt/kernel/api/w;", "service", "", "init", "Lcom/tencent/qqnt/kernel/api/t;", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "listener", "getOnLineDev", "Lcom/tencent/qqnt/kernel/nativeinterface/DevInfo;", "devInfo", "kickOffLine", "getMsgSetting", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgSetting;", "msgSetting", "setMsgSetting", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "addSendMsg", "", "msgId", "sendMsgWithMsgId", "msgIds", "srcContact", "dstContacts", "commentElements", "Lcom/tencent/qqnt/kernel/nativeinterface/IForwardOperateCallback;", "cb", "forwardMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/TargetFileInfo;", "fileInfo", "dstContact", "forwardFile", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/msg/data/b;", "registerChannelFreqLimitInfoUpdateNotificationFlow", "Lcom/tencent/qqnt/msg/data/c;", "registerDraftUpdateNotificationFlow", "", "cnt", "", "queryOrder", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgTypeFilter;", "typeFilters", "Lcom/tencent/qqnt/kernel/nativeinterface/IMsgOperateCallback;", "getMsgsByTypeFilters", WSPublicAccReport.SOP_NAME_FOCUS, "setFocusOnGuild", "", "guildId", "channelIds", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "Lcom/tencent/qqnt/kernel/nativeinterface/IGuestGetMsgAbstractsCallback;", "result", "getGuestMsgAbstracts", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgAbstractsCallback;", "getMsgAbstract", "refreshMsgAbstracts", "getChannelFreqLimitInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "getReq", "getRichMediaElement", "cancelGetRichMediaElement", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetRecentUseEmojiListCallback;", "getRecentUseEmojiList", "msgSeq", "emojiId", "emojiType", "setEmoji", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetMsgEmojiLikesCallback;", "setMsgEmojiLikes", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "taskType", "isGuest", "Lcom/tencent/qqnt/kernel/nativeinterface/AttaReportData;", "attaReportData", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetMsgEmojiLikesForRoleCallback;", "setMsgEmojiLikesForRole", "cookie", "bForward", "number", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgEmojiLikesListCallback;", "getMsgEmojiLikesList", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "msgEventInfo", "setCurOnScreenMsgForMsgEvent", "Lcom/tencent/qqnt/msg/api/c;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "getMsgsBySeqsSuspend", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rootSeq", "setReplyDraft", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetDraftOperateCallback;", "getReplyDraft", "deleteReplyDraft", "msgSeqList", "getMsgsBySeqs", "Lcom/tencent/qqnt/kernel/nativeinterface/MatchKey;", "matchKey", "Lcom/tencent/qqnt/kernel/nativeinterface/IGuildMatchedOperateCallback;", "isGuildChannelSync", "contact", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/LocalGrayTipElement;", "localGrayTipType", "needStore", "addLocalGrayTipMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/TofuRecordElement;", "tofuRecordElement", "addLocalTofuRecordMsg", "startSeq", "Lcom/tencent/qqnt/kernel/nativeinterface/IGuestMsgOperateCallback;", "getGuestMsgByRange", "businessType", QQBrowserActivity.KEY_MSG_TYPE, "msgSubType", "registerSysMsgNotification", "unregisterSysMsgNotification", "startGuildMsgSync", "msg", "insertGameResultAsMsgToDb", "sendSummonMsg", "scenes", "onScenesChangeForSilenceMode", SmsPlugin.API_SEND_SMS, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "msgAttr", "Lcom/tencent/qqnt/msg/data/e;", "getMsgList", "getLatestDbMsgList", "receiveClearMsgRecordsFlow", "", "Lcom/tencent/qqnt/msg/d;", "registerReceiveMsgNotificationFlow", "Lcom/tencent/qqnt/msg/data/h;", "receiveSysMsgNotificationFlow", "registerMsgInfoListAddNotificationFlow", "registerOnMsgDeleteNotificationFlow", "registerSendMsgNotificationFlow", "registerMsgStatusUpdateNotificationFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "registerRichMediaDownloadCompleteFlow", "registerRichMediaUploadCompleteFlow", "registerRichMediaDownloadProgressFlow", "Lcom/tencent/qqnt/msg/data/f;", "sendMsgErrorNotificationFlow", "setMsgRead", "getMsgs", "beginSeq", "endSeq", "getMsgsBySeqRange", "getMsgsBySeqAndCount", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgsReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/IMsgsRspOperateCallback;", "getMsgsExt", "getMsgsByMsgId", "getSingleMsg", "msgClientSeq", "msgTime", "getMsgByClientSeqAndTime", "peerUid", "chatType", "cancelSendMsg", "resendMsg", "lastMsg", "setMsgReadAndReport", "setLocalMsgRead", "getContactUnreadCnt", "stopGenerateMsg", "regenerateMsg", "recallMsg", "getRecallMsgsByMsgId", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgSeqCallback;", "getFirstUnreadMsgSeq", "reeditRecallMsg", "deleteMsg", "rootMsgId", "elemId", "extBufForUI", "updateElementExtBufForUI", "Lcom/tencent/qqnt/msg/data/d;", "registerDeleteMsgNotificationFlow", "getLatestDbMsgs", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAioFirstViewLatestMsgCallback;", "getAioFirstViewLatestMsgs", "sourceMsgSeq", "getSourceOfReplyMsg", "replyMsgId", "getSourceOfReplyMsgV2", "setDraft", "getDraft", "deleteDraft", "contacts", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgsBoxesCallback;", "getABatchOfContactMsgBoxInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/ContactMsgBoxInfo;", "contactMsgBoxChangedFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/SceneInfoParam;", "sceneInfo", "isLocal", "isDelete", "setGroupGuildMsgRead", "needSummary", "fetchGroupGuildUnread", "flag", "setGroupGuildFlag", "setGuildUDCFlag", "setBuildMode", "setGuildTabUserFlag", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGuildBinaryDataCallback;", "getGuildGroupTransData", "map", "setConfigurationServiceData", "setGroupGuildBubbleRead", "needFetch", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGuildGroupBubbleCallback;", "getGuildGroupBubble", "Lcom/tencent/qqnt/kernel/nativeinterface/CustomWithdrawConfig;", "registerCustomWithdrawConfigUpdateFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/InputStatusInfo;", "getOnInputStatusPush", "eventType", "toUid", "sendInputStatusReq", "groupId", "isAnonymousChat", "Lcom/tencent/qqnt/kernel/nativeinterface/ISwitchAnonymousChatCallback;", "switchAnonymousChat", "Lcom/tencent/qqnt/kernel/nativeinterface/IRenameAnonymousChatNickCallback;", "renameAnonyChatNick", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupAnonymousInfo;", "getAnonymousInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryMsgsParams;", "params", "queryMsgsWithFilterEx", "registerFileComeNotificationFlow", "registerSecurityNotificationFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardClickInfo;", "inlineKeyboardClickInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IClickInlineKeyboardButtonCallback;", "clickInlineKeyboardButton", "getRecentEmojiList", "getGroupMsgStorageTime", "()Ljava/lang/Long;", "Lcom/tencent/qqnt/kernel/nativeinterface/FeedBackMsgInfo;", "msgInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/FeedBackDataForMsg;", "feedBackData", "likeOrDislikeReportForMsg", "richFlag", "setMsgRichInfoFlag", "msg_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IMsgService extends QRouteApi {
    void addLocalGrayTipMsg(@NotNull Contact contact, @NotNull LocalGrayTipElement localGrayTipType, boolean needStore, @Nullable IOperateCallback cb5);

    void addLocalTofuRecordMsg(@NotNull Contact contact, @NotNull TofuRecordElement tofuRecordElement, @Nullable IOperateCallback cb5);

    void addSendMsg(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements);

    void cancelGetRichMediaElement(@NotNull RichMediaElementGetReq getReq);

    void cancelSendMsg(long msgId, @NotNull String peerUid, int chatType);

    void clickInlineKeyboardButton(@NotNull InlineKeyboardClickInfo inlineKeyboardClickInfo, @NotNull IClickInlineKeyboardButtonCallback cb5);

    @NotNull
    Flow<ArrayList<ContactMsgBoxInfo>> contactMsgBoxChangedFlow();

    void deleteDraft(@NotNull Contact peer, @Nullable IOperateCallback cb5);

    void deleteMsg(@NotNull Contact peer, @Nullable ArrayList<Long> msgId, @Nullable IOperateCallback listener);

    void deleteReplyDraft(@NotNull Contact peer, long rootSeq, @Nullable IOperateCallback cb5);

    void fetchGroupGuildUnread(@NotNull Contact peer, boolean needSummary, @Nullable IOperateCallback cb5);

    void forwardFile(@NotNull TargetFileInfo fileInfo, @NotNull Contact dstContact, @NotNull IOperateCallback cb5);

    void forwardMsg(@NotNull ArrayList<Long> msgIds, @NotNull Contact srcContact, @NotNull ArrayList<Contact> dstContacts, @Nullable ArrayList<MsgElement> commentElements, @NotNull IForwardOperateCallback cb5);

    void getABatchOfContactMsgBoxInfo(@NotNull ArrayList<Contact> contacts, @NotNull IGetMsgsBoxesCallback cb5);

    void getAioFirstViewLatestMsgs(@NotNull Contact peer, int cnt, @NotNull IGetAioFirstViewLatestMsgCallback cb5);

    @Nullable
    GroupAnonymousInfo getAnonymousInfo(@Nullable String groupId);

    void getChannelFreqLimitInfo(@Nullable Contact peer);

    void getContactUnreadCnt(@Nullable IOperateCallback listener);

    void getDraft(@NotNull Contact peer, @Nullable IGetDraftOperateCallback result);

    void getFirstUnreadMsgSeq(@NotNull Contact peer, @NotNull IGetMsgSeqCallback listener);

    @Nullable
    Long getGroupMsgStorageTime();

    void getGuestMsgAbstracts(@NotNull String guildId, @NotNull ArrayList<String> channelIds, int random, @Nullable IGuestGetMsgAbstractsCallback result);

    void getGuestMsgByRange(@Nullable Contact peer, long startSeq, int cnt, boolean queryOrder, int random, @Nullable IGuestMsgOperateCallback result);

    void getGuildGroupBubble(@NotNull Contact peer, boolean needFetch, @Nullable IGetGuildGroupBubbleCallback cb5);

    void getGuildGroupTransData(@Nullable Contact peer, @Nullable IGetGuildBinaryDataCallback cb5);

    @NotNull
    Flow<e> getLatestDbMsgList(@NotNull Contact peer, int cnt);

    void getLatestDbMsgs(@NotNull Contact peer, int cnt, @NotNull IMsgOperateCallback cb5);

    void getMsgAbstract(@NotNull Contact peer, long msgId, @Nullable IGetMsgAbstractsCallback listener);

    void getMsgByClientSeqAndTime(@Nullable Contact peer, long msgClientSeq, long msgTime, @Nullable IMsgOperateCallback listener);

    void getMsgEmojiLikesList(@Nullable Contact peer, long msgSeq, @Nullable String emojiId, long emojiType, @Nullable String cookie, boolean bForward, int number, @Nullable IGetMsgEmojiLikesListCallback cb5);

    @NotNull
    Flow<e> getMsgList(@NotNull Contact peer, long msgId, int cnt, boolean queryOrder);

    void getMsgSetting(@Nullable IOperateCallback listener);

    @Deprecated(message = "9.0.30\u5f00\u59cb\u5e9f\u5f03\uff0c\u7531getMsgsExt\u66ff\u4ee3", replaceWith = @ReplaceWith(expression = "getMsgsExt", imports = {}))
    void getMsgs(@NotNull Contact peer, long msgId, int cnt, boolean queryOrder, @NotNull IMsgOperateCallback listener);

    void getMsgsByMsgId(@Nullable Contact peer, @Nullable ArrayList<Long> msgIds, @Nullable IMsgOperateCallback listener);

    @Deprecated(message = "9.0.30\u5f00\u59cb\u5e9f\u5f03\uff0c\u7531getMsgsExt\u66ff\u4ee3", replaceWith = @ReplaceWith(expression = "getMsgsExt", imports = {}))
    void getMsgsBySeqAndCount(@Nullable Contact peer, long msgSeq, int cnt, boolean queryOrder, @Nullable IMsgOperateCallback listener);

    void getMsgsBySeqRange(@Nullable Contact peer, long beginSeq, long endSeq, @Nullable IMsgOperateCallback listener);

    void getMsgsBySeqs(@Nullable Contact peer, @NotNull ArrayList<Long> msgSeqList, @Nullable IMsgOperateCallback listener);

    @Nullable
    Object getMsgsBySeqsSuspend(@NotNull Contact contact, long j3, boolean z16, @NotNull Continuation<? super c<ArrayList<MsgRecord>>> continuation);

    void getMsgsByTypeFilters(@Nullable Contact peer, long msgId, int cnt, boolean queryOrder, @Nullable ArrayList<MsgTypeFilter> typeFilters, @Nullable IMsgOperateCallback listener);

    void getMsgsExt(@NotNull MsgsReq req, @Nullable IMsgsRspOperateCallback cb5);

    @NotNull
    Flow<InputStatusInfo> getOnInputStatusPush();

    void getOnLineDev(@Nullable IOperateCallback listener);

    void getRecallMsgsByMsgId(@Nullable Contact peer, @NotNull ArrayList<Long> msgIds, @Nullable IMsgOperateCallback listener);

    void getRecentEmojiList(int chatType, @Nullable IGetRecentUseEmojiListCallback cb5);

    void getRecentUseEmojiList(@Nullable IGetRecentUseEmojiListCallback cb5);

    void getReplyDraft(@NotNull Contact peer, long rootSeq, @Nullable IGetDraftOperateCallback cb5);

    void getRichMediaElement(@NotNull RichMediaElementGetReq getReq);

    void getSingleMsg(@Nullable Contact peer, long msgSeq, @Nullable IMsgOperateCallback listener);

    void getSourceOfReplyMsg(@Nullable Contact peer, long msgId, long sourceMsgSeq, @Nullable IMsgOperateCallback cb5);

    void getSourceOfReplyMsgV2(@NotNull Contact peer, long rootMsgId, long replyMsgId, @NotNull IMsgOperateCallback cb5);

    void init(@Nullable t service);

    void init(@Nullable w service);

    void insertGameResultAsMsgToDb(@Nullable MsgRecord msg2, @Nullable IOperateCallback cb5);

    void isGuildChannelSync(@Nullable MatchKey matchKey, @Nullable IGuildMatchedOperateCallback result);

    void kickOffLine(@NotNull DevInfo devInfo, @Nullable IOperateCallback listener);

    void likeOrDislikeReportForMsg(@NotNull Contact peer, @NotNull FeedBackMsgInfo msgInfo, @NotNull FeedBackDataForMsg feedBackData, @NotNull IOperateCallback cb5);

    void onScenesChangeForSilenceMode(int scenes);

    void queryMsgsWithFilterEx(long msgId, long msgTime, long msgSeq, @NotNull QueryMsgsParams params, @NotNull IMsgOperateCallback cb5);

    void recallMsg(@NotNull Contact peer, long msgId, @Nullable IOperateCallback listener);

    @NotNull
    Flow<Contact> receiveClearMsgRecordsFlow();

    @NotNull
    Flow<h> receiveSysMsgNotificationFlow();

    void reeditRecallMsg(@Nullable Contact peer, long msgId, @Nullable IOperateCallback cb5);

    void refreshMsgAbstracts(@NotNull String guildId, @Nullable ArrayList<String> channelIds);

    void regenerateMsg(@NotNull Contact peer, long msgId, @Nullable IOperateCallback cb5);

    @NotNull
    Flow<com.tencent.qqnt.msg.data.b> registerChannelFreqLimitInfoUpdateNotificationFlow();

    @NotNull
    Flow<CustomWithdrawConfig> registerCustomWithdrawConfigUpdateFlow();

    @NotNull
    Flow<d> registerDeleteMsgNotificationFlow();

    @NotNull
    Flow<com.tencent.qqnt.msg.data.c> registerDraftUpdateNotificationFlow();

    @NotNull
    Flow<List<com.tencent.qqnt.msg.d>> registerFileComeNotificationFlow();

    @NotNull
    Flow<ArrayList<com.tencent.qqnt.msg.d>> registerMsgInfoListAddNotificationFlow();

    @NotNull
    Flow<ArrayList<com.tencent.qqnt.msg.d>> registerMsgStatusUpdateNotificationFlow();

    @NotNull
    Flow<ArrayList<Long>> registerOnMsgDeleteNotificationFlow();

    @NotNull
    Flow<List<com.tencent.qqnt.msg.d>> registerReceiveMsgNotificationFlow();

    @NotNull
    Flow<FileTransNotifyInfo> registerRichMediaDownloadCompleteFlow();

    @NotNull
    Flow<FileTransNotifyInfo> registerRichMediaDownloadProgressFlow();

    @NotNull
    Flow<FileTransNotifyInfo> registerRichMediaUploadCompleteFlow();

    @NotNull
    Flow<com.tencent.qqnt.msg.d> registerSecurityNotificationFlow();

    @NotNull
    Flow<com.tencent.qqnt.msg.d> registerSendMsgNotificationFlow();

    void registerSysMsgNotification(int businessType, long msgType, @NotNull ArrayList<Long> msgSubType, @Nullable IOperateCallback cb5);

    void renameAnonyChatNick(@Nullable String groupId, @Nullable IRenameAnonymousChatNickCallback cb5);

    void resendMsg(@NotNull Contact peer, long msgId, @Nullable IOperateCallback listener);

    void sendInputStatusReq(int chatType, int eventType, @NotNull String toUid, @NotNull IOperateCallback cb5);

    void sendMsg(@NotNull Contact peer, long msgId, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback listener);

    void sendMsg(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback listener);

    void sendMsg(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements, @NotNull HashMap<Integer, MsgAttributeInfo> msgAttr, @Nullable IOperateCallback listener);

    @NotNull
    Flow<f> sendMsgErrorNotificationFlow();

    void sendMsgWithMsgId(@NotNull Contact peer, long msgId, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback listener);

    void sendSummonMsg(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback cb5);

    void setBuildMode(int flag);

    void setConfigurationServiceData(@NotNull HashMap<Long, String> map);

    void setCurOnScreenMsgForMsgEvent(@NotNull Contact peer, @NotNull HashMap<Long, byte[]> msgEventInfo);

    void setDraft(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback result);

    void setFocusOnGuild(boolean focus);

    void setGroupGuildBubbleRead(@NotNull Contact peer, @Nullable IOperateCallback cb5);

    void setGroupGuildFlag(int flag);

    void setGroupGuildMsgRead(@NotNull Contact peer, @NotNull ArrayList<SceneInfoParam> sceneInfo, boolean isLocal, boolean isDelete, @Nullable IOperateCallback cb5);

    void setGuildTabUserFlag(int flag);

    void setGuildUDCFlag(int flag);

    void setLocalMsgRead(@NotNull Contact peer, @Nullable IOperateCallback listener);

    void setMsgEmojiLikes(@Nullable Contact peer, long msgSeq, @Nullable String emojiId, long emojiType, boolean setEmoji, @Nullable ISetMsgEmojiLikesCallback cb5);

    void setMsgEmojiLikesForRole(@Nullable Contact peer, long msgSeq, @Nullable String emojiId, long emojiType, long taskId, long taskType, boolean setEmoji, boolean isGuest, @NotNull AttaReportData attaReportData, @Nullable ISetMsgEmojiLikesForRoleCallback cb5);

    void setMsgRead(@NotNull Contact peer, @Nullable IOperateCallback listener);

    void setMsgReadAndReport(@NotNull Contact peer, @NotNull MsgRecord lastMsg, @Nullable IOperateCallback listener);

    void setMsgRichInfoFlag(boolean richFlag);

    void setMsgSetting(@NotNull MsgSetting msgSetting, @Nullable IOperateCallback listener);

    void setReplyDraft(@NotNull Contact peer, long rootSeq, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback cb5);

    void startGuildMsgSync();

    void stopGenerateMsg(@NotNull Contact peer, long msgId, @Nullable IOperateCallback cb5);

    void switchAnonymousChat(@Nullable String groupId, boolean isAnonymousChat, @Nullable ISwitchAnonymousChatCallback cb5);

    void unregisterSysMsgNotification(int businessType, long msgType, @NotNull ArrayList<Long> msgSubType, @Nullable IOperateCallback cb5);

    void updateElementExtBufForUI(@NotNull Contact peer, long rootMsgId, long elemId, @NotNull byte[] extBufForUI, @Nullable IOperateCallback cb5);
}

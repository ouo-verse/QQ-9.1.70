package com.tencent.qqnt.msg.api.impl;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
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
import com.tencent.qqnt.msg.MsgService;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.data.e;
import com.tencent.qqnt.msg.data.f;
import com.tencent.qqnt.msg.data.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d8\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\u00a2\u0006\u0006\b\u0081\u0002\u0010\u0082\u0002J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J(\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015H\u0016J:\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J2\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016JF\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J:\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J.\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020!H\u0016J\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001dH\u0016J\u001e\u0010(\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020'0\u0013j\b\u0012\u0004\u0012\u00020'`\u00150#H\u0016J\"\u0010)\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u00150#H\u0016J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00110#H\u0016J\u0014\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0+0#H\u0016J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020-0#H\u0016J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020'0#H\u0016J\u001e\u00100\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020'0\u0013j\b\u0012\u0004\u0012\u00020'`\u00150#H\u0016J\u000e\u00102\u001a\b\u0012\u0004\u0012\u0002010#H\u0016J\u000e\u00103\u001a\b\u0012\u0004\u0012\u0002010#H\u0016J\u000e\u00104\u001a\b\u0012\u0004\u0012\u0002010#H\u0016J\u000e\u00106\u001a\b\u0012\u0004\u0012\u0002050#H\u0016J\u001a\u00107\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J0\u00109\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\b\u001a\u000208H\u0016J,\u0010<\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u000108H\u0016J4\u0010>\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010=\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020!2\b\u0010\b\u001a\u0004\u0018\u000108H\u0016J\u001a\u0010C\u001a\u00020\u00042\u0006\u0010@\u001a\u00020?2\b\u0010B\u001a\u0004\u0018\u00010AH\u0016J<\u0010E\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u001e\u0010D\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0013j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u0001`\u00152\b\u0010\b\u001a\u0004\u0018\u000108H\u0016J$\u0010F\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010=\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u000108H\u0016J,\u0010I\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010G\u001a\u00020\u00182\u0006\u0010H\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u000108H\u0016J \u0010M\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020\u001dH\u0016J\"\u0010N\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010Q\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010P\u001a\u00020O2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010R\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010S\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010T\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010U\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010V\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J4\u0010W\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0016\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0013j\b\u0012\u0004\u0012\u00020\u0018`\u00152\b\u0010\b\u001a\u0004\u0018\u000108H\u0016J\u0018\u0010Y\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020XH\u0016J$\u0010Z\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0016J6\u0010[\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u00152\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J2\u0010`\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020\u00182\u0006\u0010]\u001a\u00020\u00182\u0006\u0010_\u001a\u00020^2\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010b\u001a\b\u0012\u0004\u0012\u00020a0#H\u0016J \u0010c\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010B\u001a\u000208H\u0016J \u0010e\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010B\u001a\u00020dH\u0016J,\u0010g\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010f\u001a\u00020\u00182\b\u0010B\u001a\u0004\u0018\u000108H\u0016J(\u0010i\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020\u00182\u0006\u0010h\u001a\u00020\u00182\u0006\u0010B\u001a\u000208H\u0016J2\u0010k\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\b\u0010j\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010m\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010j\u001a\u0004\u0018\u00010lH\u0016J\u001a\u0010n\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010j\u001a\u0004\u0018\u00010\u0007H\u0016J(\u0010q\u001a\u00020\u00042\u0016\u0010o\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0013j\b\u0012\u0004\u0012\u00020\u0011`\u00152\u0006\u0010B\u001a\u00020pH\u0016J\u001e\u0010s\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020r0\u0013j\b\u0012\u0004\u0012\u00020r`\u00150#H\u0016JB\u0010x\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0016\u0010u\u001a\u0012\u0012\u0004\u0012\u00020t0\u0013j\b\u0012\u0004\u0012\u00020t`\u00152\u0006\u0010v\u001a\u00020!2\u0006\u0010w\u001a\u00020!2\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010z\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010y\u001a\u00020!2\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010|\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u001dH\u0016J\u0010\u0010}\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u001dH\u0016J\u0010\u0010~\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u001dH\u0016J\u0010\u0010\u007f\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u001dH\u0016J\u001e\u0010\u0081\u0001\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\t\u0010B\u001a\u0005\u0018\u00010\u0080\u0001H\u0016Ji\u0010\u0086\u0001\u001a\u00020\u00042\u0016\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0013j\b\u0012\u0004\u0012\u00020\u0018`\u00152\u0007\u0010\u0082\u0001\u001a\u00020\u00112\u0017\u0010\u0083\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0013j\b\u0012\u0004\u0012\u00020\u0011`\u00152\u001b\u0010\u0084\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u00152\u0007\u0010B\u001a\u00030\u0085\u0001H\u0016J$\u0010\u008a\u0001\u001a\u00020\u00042\b\u0010\u0088\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0089\u0001\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u0007H\u0016J\u0010\u0010\u008c\u0001\u001a\t\u0012\u0005\u0012\u00030\u008b\u00010#H\u0016J\u0012\u0010\u008e\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u008d\u00010#H\u0016JT\u0010\u0091\u0001\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020!2\u001d\u0010\u0090\u0001\u001a\u0018\u0012\u0005\u0012\u00030\u008f\u0001\u0018\u00010\u0013j\u000b\u0012\u0005\u0012\u00030\u008f\u0001\u0018\u0001`\u00152\b\u0010\b\u001a\u0004\u0018\u000108H\u0016J\u0012\u0010\u0093\u0001\u001a\u00020\u00042\u0007\u0010\u0092\u0001\u001a\u00020!H\u0016J?\u0010\u0098\u0001\u001a\u00020\u00042\u0007\u0010\u0094\u0001\u001a\u00020J2\u0017\u0010\u0095\u0001\u001a\u0012\u0012\u0004\u0012\u00020J0\u0013j\b\u0012\u0004\u0012\u00020J`\u00152\u0007\u0010\u0096\u0001\u001a\u00020\u001d2\t\u0010j\u001a\u0005\u0018\u00010\u0097\u0001H\u0016J$\u0010\u009a\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\t\u0010\b\u001a\u0005\u0018\u00010\u0099\u0001H\u0016J%\u0010\u009b\u0001\u001a\u00020\u00042\u0007\u0010\u0094\u0001\u001a\u00020J2\u0011\u0010\u0095\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010J\u0018\u00010\u0013H\u0016J\u0013\u0010\u009c\u0001\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0013\u0010\u009f\u0001\u001a\u00020\u00042\b\u0010\u009e\u0001\u001a\u00030\u009d\u0001H\u0016J\u0013\u0010\u00a0\u0001\u001a\u00020\u00042\b\u0010\u009e\u0001\u001a\u00030\u009d\u0001H\u0016J\u0014\u0010\u00a2\u0001\u001a\u00020\u00042\t\u0010B\u001a\u0005\u0018\u00010\u00a1\u0001H\u0016JC\u0010\u00a7\u0001\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010=\u001a\u00020\u00182\t\u0010\u00a3\u0001\u001a\u0004\u0018\u00010J2\u0007\u0010\u00a4\u0001\u001a\u00020\u00182\u0007\u0010\u00a5\u0001\u001a\u00020!2\t\u0010B\u001a\u0005\u0018\u00010\u00a6\u0001H\u0016Jh\u0010\u00ae\u0001\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010=\u001a\u00020\u00182\t\u0010\u00a3\u0001\u001a\u0004\u0018\u00010J2\u0007\u0010\u00a4\u0001\u001a\u00020\u00182\u0007\u0010\u00a8\u0001\u001a\u00020\u00182\u0007\u0010\u00a9\u0001\u001a\u00020\u00182\u0007\u0010\u00a5\u0001\u001a\u00020!2\u0007\u0010\u00aa\u0001\u001a\u00020!2\b\u0010\u00ac\u0001\u001a\u00030\u00ab\u00012\t\u0010B\u001a\u0005\u0018\u00010\u00ad\u0001H\u0016JW\u0010\u00b3\u0001\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010=\u001a\u00020\u00182\t\u0010\u00a3\u0001\u001a\u0004\u0018\u00010J2\u0007\u0010\u00a4\u0001\u001a\u00020\u00182\t\u0010\u00af\u0001\u001a\u0004\u0018\u00010J2\u0007\u0010\u00b0\u0001\u001a\u00020!2\u0007\u0010\u00b1\u0001\u001a\u00020\u001d2\t\u0010B\u001a\u0005\u0018\u00010\u00b2\u0001H\u0016J&\u0010\u00b5\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0013\u0010\u00b4\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020^0\u001cH\u0016JF\u0010\u00b7\u0001\u001a\u0019\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020O0\u0013j\b\u0012\u0004\u0012\u00020O`\u00150\u00b6\u00012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\u00182\u0007\u0010\u00aa\u0001\u001a\u00020!H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0006\b\u00b7\u0001\u0010\u00b8\u0001J<\u0010\u00ba\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0007\u0010\u00b9\u0001\u001a\u00020\u00182\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u00bb\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0007\u0010\u00b9\u0001\u001a\u00020\u00182\b\u0010B\u001a\u0004\u0018\u00010lH\u0016J$\u0010\u00bc\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0007\u0010\u00b9\u0001\u001a\u00020\u00182\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0016J6\u0010\u00be\u0001\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0017\u0010\u00bd\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0013j\b\u0012\u0004\u0012\u00020\u0018`\u00152\b\u0010\b\u001a\u0004\u0018\u000108H\u0016J \u0010\u00c2\u0001\u001a\u00020\u00042\n\u0010\u00c0\u0001\u001a\u0005\u0018\u00010\u00bf\u00012\t\u0010j\u001a\u0005\u0018\u00010\u00c1\u0001H\u0016J/\u0010\u00c7\u0001\u001a\u00020\u00042\u0007\u0010\u00c3\u0001\u001a\u00020\u00112\b\u0010\u00c5\u0001\u001a\u00030\u00c4\u00012\u0007\u0010\u00c6\u0001\u001a\u00020!2\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\u00ca\u0001\u001a\u00020\u00042\u0007\u0010\u00c3\u0001\u001a\u00020\u00112\b\u0010\u00c9\u0001\u001a\u00030\u00c8\u00012\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0016J@\u0010\u00cd\u0001\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0007\u0010\u00cb\u0001\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020!2\u0007\u0010\u0096\u0001\u001a\u00020\u001d2\t\u0010j\u001a\u0005\u0018\u00010\u00cc\u0001H\u0016J>\u0010\u00d1\u0001\u001a\u00020\u00042\u0007\u0010\u00ce\u0001\u001a\u00020\u001d2\u0007\u0010\u00cf\u0001\u001a\u00020\u00182\u0017\u0010\u00d0\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0013j\b\u0012\u0004\u0012\u00020\u0018`\u00152\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0016J>\u0010\u00d2\u0001\u001a\u00020\u00042\u0007\u0010\u00ce\u0001\u001a\u00020\u001d2\u0007\u0010\u00cf\u0001\u001a\u00020\u00182\u0017\u0010\u00d0\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0013j\b\u0012\u0004\u0012\u00020\u0018`\u00152\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0016J\t\u0010\u00d3\u0001\u001a\u00020\u0004H\u0016J\u001e\u0010\u00d5\u0001\u001a\u00020\u00042\t\u0010\u00d4\u0001\u001a\u0004\u0018\u00010O2\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0016J3\u0010\u00d6\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u00d8\u0001\u001a\u00020\u00042\u0007\u0010\u00d7\u0001\u001a\u00020\u001dH\u0016J\u001e\u0010\u00da\u0001\u001a\u00020\u00042\u0013\u0010\u00d9\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020J0\u001cH\u0016J\u001b\u0010\u00db\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0016J%\u0010\u00de\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0007\u0010\u00dc\u0001\u001a\u00020!2\t\u0010B\u001a\u0005\u0018\u00010\u00dd\u0001H\u0016J\u0010\u0010\u00e0\u0001\u001a\t\u0012\u0005\u0012\u00030\u00df\u00010#H\u0016J\u0010\u0010\u00e2\u0001\u001a\t\u0012\u0005\u0012\u00030\u00e1\u00010#H\u0016J+\u0010\u00e5\u0001\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u001d2\u0007\u0010\u00e3\u0001\u001a\u00020\u001d2\u0007\u0010\u00e4\u0001\u001a\u00020J2\u0006\u0010B\u001a\u00020\u0007H\u0016J3\u0010\u00e8\u0001\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010H\u001a\u00020\u00182\u0006\u0010=\u001a\u00020\u00182\b\u0010\u00e7\u0001\u001a\u00030\u00e6\u00012\u0006\u0010B\u001a\u000208H\u0016J(\u0010\u00ec\u0001\u001a\u00020\u00042\t\u0010\u00e9\u0001\u001a\u0004\u0018\u00010J2\u0007\u0010\u00ea\u0001\u001a\u00020!2\t\u0010B\u001a\u0005\u0018\u00010\u00eb\u0001H\u0016J\u001f\u0010\u00ee\u0001\u001a\u00020\u00042\t\u0010\u00e9\u0001\u001a\u0004\u0018\u00010J2\t\u0010B\u001a\u0005\u0018\u00010\u00ed\u0001H\u0016J\u0017\u0010\u00f0\u0001\u001a\u0005\u0018\u00010\u00ef\u00012\t\u0010\u00e9\u0001\u001a\u0004\u0018\u00010JH\u0016J\u0015\u0010\u00f1\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0+0#H\u0016J\u000f\u0010\u00f2\u0001\u001a\b\u0012\u0004\u0012\u00020'0#H\u0016J\u001c\u0010\u00f6\u0001\u001a\u00020\u00042\b\u0010\u00f4\u0001\u001a\u00030\u00f3\u00012\u0007\u0010B\u001a\u00030\u00f5\u0001H\u0016J\u001c\u0010\u00f7\u0001\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u001d2\t\u0010B\u001a\u0005\u0018\u00010\u00a1\u0001H\u0016J\u0014\u0010\u00f8\u0001\u001a\u0004\u0018\u00010\u0018H\u0016\u00a2\u0006\u0006\b\u00f8\u0001\u0010\u00f9\u0001J-\u0010\u00fe\u0001\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u00fb\u0001\u001a\u00030\u00fa\u00012\b\u0010\u00fd\u0001\u001a\u00030\u00fc\u00012\u0006\u0010B\u001a\u00020\u0007H\u0016J\u0012\u0010\u0080\u0002\u001a\u00020\u00042\u0007\u0010\u00ff\u0001\u001a\u00020!H\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0083\u0002"}, d2 = {"Lcom/tencent/qqnt/msg/api/impl/MsgServiceImpl;", "Lcom/tencent/qqnt/msg/api/IMsgService;", "Lcom/tencent/qqnt/kernel/api/w;", "service", "", "init", "Lcom/tencent/qqnt/kernel/api/t;", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "listener", "getOnLineDev", "Lcom/tencent/qqnt/kernel/nativeinterface/DevInfo;", "devInfo", "kickOffLine", "getMsgSetting", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgSetting;", "msgSetting", "setMsgSetting", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "addSendMsg", "", "msgId", "sendMsgWithMsgId", SmsPlugin.API_SEND_SMS, "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "msgAttr", "cnt", "", "queryOrder", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/msg/data/e;", "getMsgList", "getLatestDbMsgList", "Lcom/tencent/qqnt/msg/d;", "registerMsgInfoListAddNotificationFlow", "registerOnMsgDeleteNotificationFlow", "receiveClearMsgRecordsFlow", "", "registerReceiveMsgNotificationFlow", "Lcom/tencent/qqnt/msg/data/h;", "receiveSysMsgNotificationFlow", "registerSendMsgNotificationFlow", "registerMsgStatusUpdateNotificationFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "registerRichMediaDownloadCompleteFlow", "registerRichMediaUploadCompleteFlow", "registerRichMediaDownloadProgressFlow", "Lcom/tencent/qqnt/msg/data/f;", "sendMsgErrorNotificationFlow", "setMsgRead", "Lcom/tencent/qqnt/kernel/nativeinterface/IMsgOperateCallback;", "getMsgs", "beginSeq", "endSeq", "getMsgsBySeqRange", "msgSeq", "getMsgsBySeqAndCount", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgsReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/IMsgsRspOperateCallback;", "cb", "getMsgsExt", "msgIds", "getMsgsByMsgId", "getSingleMsg", "msgClientSeq", "msgTime", "getMsgByClientSeqAndTime", "", "peerUid", "chatType", "cancelSendMsg", "resendMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "lastMsg", "setMsgReadAndReport", "setLocalMsgRead", "getContactUnreadCnt", "stopGenerateMsg", "regenerateMsg", "recallMsg", "getRecallMsgsByMsgId", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgSeqCallback;", "getFirstUnreadMsgSeq", "reeditRecallMsg", "deleteMsg", "rootMsgId", "elemId", "", "extBufForUI", "updateElementExtBufForUI", "Lcom/tencent/qqnt/msg/data/d;", "registerDeleteMsgNotificationFlow", "getLatestDbMsgs", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAioFirstViewLatestMsgCallback;", "getAioFirstViewLatestMsgs", "sourceMsgSeq", "getSourceOfReplyMsg", "replyMsgId", "getSourceOfReplyMsgV2", "result", "setDraft", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetDraftOperateCallback;", "getDraft", "deleteDraft", "contacts", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgsBoxesCallback;", "getABatchOfContactMsgBoxInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/ContactMsgBoxInfo;", "contactMsgBoxChangedFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/SceneInfoParam;", "sceneInfo", "isLocal", "isDelete", "setGroupGuildMsgRead", "needSummary", "fetchGroupGuildUnread", "flag", "setGroupGuildFlag", "setGuildUDCFlag", "setBuildMode", "setGuildTabUserFlag", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGuildBinaryDataCallback;", "getGuildGroupTransData", "srcContact", "dstContacts", "commentElements", "Lcom/tencent/qqnt/kernel/nativeinterface/IForwardOperateCallback;", "forwardMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/TargetFileInfo;", "fileInfo", "dstContact", "forwardFile", "Lcom/tencent/qqnt/msg/data/b;", "registerChannelFreqLimitInfoUpdateNotificationFlow", "Lcom/tencent/qqnt/msg/data/c;", "registerDraftUpdateNotificationFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgTypeFilter;", "typeFilters", "getMsgsByTypeFilters", WSPublicAccReport.SOP_NAME_FOCUS, "setFocusOnGuild", "guildId", "channelIds", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "Lcom/tencent/qqnt/kernel/nativeinterface/IGuestGetMsgAbstractsCallback;", "getGuestMsgAbstracts", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgAbstractsCallback;", "getMsgAbstract", "refreshMsgAbstracts", "getChannelFreqLimitInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "getReq", "getRichMediaElement", "cancelGetRichMediaElement", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetRecentUseEmojiListCallback;", "getRecentUseEmojiList", "emojiId", "emojiType", "setEmoji", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetMsgEmojiLikesCallback;", "setMsgEmojiLikes", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "taskType", "isGuest", "Lcom/tencent/qqnt/kernel/nativeinterface/AttaReportData;", "attaReportData", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetMsgEmojiLikesForRoleCallback;", "setMsgEmojiLikesForRole", "cookie", "bForward", "number", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgEmojiLikesListCallback;", "getMsgEmojiLikesList", "msgEventInfo", "setCurOnScreenMsgForMsgEvent", "Lcom/tencent/qqnt/msg/api/c;", "getMsgsBySeqsSuspend", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rootSeq", "setReplyDraft", "getReplyDraft", "deleteReplyDraft", "msgSeqList", "getMsgsBySeqs", "Lcom/tencent/qqnt/kernel/nativeinterface/MatchKey;", "matchKey", "Lcom/tencent/qqnt/kernel/nativeinterface/IGuildMatchedOperateCallback;", "isGuildChannelSync", "contact", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/LocalGrayTipElement;", "localGrayTipType", "needStore", "addLocalGrayTipMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/TofuRecordElement;", "tofuRecordElement", "addLocalTofuRecordMsg", "startSeq", "Lcom/tencent/qqnt/kernel/nativeinterface/IGuestMsgOperateCallback;", "getGuestMsgByRange", "businessType", QQBrowserActivity.KEY_MSG_TYPE, "msgSubType", "registerSysMsgNotification", "unregisterSysMsgNotification", "startGuildMsgSync", "msg", "insertGameResultAsMsgToDb", "sendSummonMsg", "scenes", "onScenesChangeForSilenceMode", "map", "setConfigurationServiceData", "setGroupGuildBubbleRead", "needFetch", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGuildGroupBubbleCallback;", "getGuildGroupBubble", "Lcom/tencent/qqnt/kernel/nativeinterface/CustomWithdrawConfig;", "registerCustomWithdrawConfigUpdateFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/InputStatusInfo;", "getOnInputStatusPush", "eventType", "toUid", "sendInputStatusReq", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryMsgsParams;", "params", "queryMsgsWithFilterEx", "groupId", "isAnonymousChat", "Lcom/tencent/qqnt/kernel/nativeinterface/ISwitchAnonymousChatCallback;", "switchAnonymousChat", "Lcom/tencent/qqnt/kernel/nativeinterface/IRenameAnonymousChatNickCallback;", "renameAnonyChatNick", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupAnonymousInfo;", "getAnonymousInfo", "registerFileComeNotificationFlow", "registerSecurityNotificationFlow", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardClickInfo;", "inlineKeyboardClickInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IClickInlineKeyboardButtonCallback;", "clickInlineKeyboardButton", "getRecentEmojiList", "getGroupMsgStorageTime", "()Ljava/lang/Long;", "Lcom/tencent/qqnt/kernel/nativeinterface/FeedBackMsgInfo;", "msgInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/FeedBackDataForMsg;", "feedBackData", "likeOrDislikeReportForMsg", "richFlag", "setMsgRichInfoFlag", "<init>", "()V", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MsgServiceImpl implements IMsgService {
    static IPatchRedirector $redirector_;

    public MsgServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void addLocalGrayTipMsg(@NotNull Contact contact, @NotNull LocalGrayTipElement localGrayTipType, boolean needStore, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, this, contact, localGrayTipType, Boolean.valueOf(needStore), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(localGrayTipType, "localGrayTipType");
        MsgService.f359521a.g(contact, localGrayTipType, needStore, cb5);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void addLocalTofuRecordMsg(@NotNull Contact contact, @NotNull TofuRecordElement tofuRecordElement, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, this, contact, tofuRecordElement, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(tofuRecordElement, "tofuRecordElement");
        MsgService.f359521a.h(contact, tofuRecordElement, cb5);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void addSendMsg(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) peer, (Object) msgElements);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        MsgService.f359521a.i(peer, msgElements);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void cancelGetRichMediaElement(@NotNull RichMediaElementGetReq getReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this, (Object) getReq);
        } else {
            Intrinsics.checkNotNullParameter(getReq, "getReq");
            MsgService.f359521a.j(getReq);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void cancelSendMsg(long msgId, @NotNull String peerUid, int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Long.valueOf(msgId), peerUid, Integer.valueOf(chatType));
        } else {
            Intrinsics.checkNotNullParameter(peerUid, "peerUid");
            MsgService.f359521a.k(msgId, peerUid, chatType);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void clickInlineKeyboardButton(@NotNull InlineKeyboardClickInfo inlineKeyboardClickInfo, @NotNull IClickInlineKeyboardButtonCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
            iPatchRedirector.redirect((short) 108, (Object) this, (Object) inlineKeyboardClickInfo, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(inlineKeyboardClickInfo, "inlineKeyboardClickInfo");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        MsgService.f359521a.m(inlineKeyboardClickInfo, cb5);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<ArrayList<ContactMsgBoxInfo>> contactMsgBoxChangedFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return (Flow) iPatchRedirector.redirect((short) 56, (Object) this);
        }
        return MsgService.f359521a.n();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void deleteDraft(@NotNull Contact peer, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) peer, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            MsgService.f359521a.o(peer, result);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void deleteMsg(@NotNull Contact peer, @Nullable ArrayList<Long> msgId, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, this, peer, msgId, listener);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            MsgService.f359521a.p(peer, msgId, listener);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void deleteReplyDraft(@NotNull Contact peer, long rootSeq, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, this, peer, Long.valueOf(rootSeq), cb5);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            MsgService.f359521a.r(peer, rootSeq, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void fetchGroupGuildUnread(@NotNull Contact peer, boolean needSummary, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, this, peer, Boolean.valueOf(needSummary), cb5);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            MsgService.f359521a.t(peer, needSummary, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void forwardFile(@NotNull TargetFileInfo fileInfo, @NotNull Contact dstContact, @NotNull IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, this, fileInfo, dstContact, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
        Intrinsics.checkNotNullParameter(dstContact, "dstContact");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        MsgService.f359521a.u(fileInfo, dstContact, cb5);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void forwardMsg(@NotNull ArrayList<Long> msgIds, @NotNull Contact srcContact, @NotNull ArrayList<Contact> dstContacts, @Nullable ArrayList<MsgElement> commentElements, @NotNull IForwardOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, this, msgIds, srcContact, dstContacts, commentElements, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(msgIds, "msgIds");
        Intrinsics.checkNotNullParameter(srcContact, "srcContact");
        Intrinsics.checkNotNullParameter(dstContacts, "dstContacts");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        MsgService.f359521a.v(msgIds, srcContact, dstContacts, commentElements, cb5);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getABatchOfContactMsgBoxInfo(@NotNull ArrayList<Contact> contacts, @NotNull IGetMsgsBoxesCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) contacts, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(contacts, "contacts");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        MsgService.f359521a.w(contacts, cb5);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getAioFirstViewLatestMsgs(@NotNull Contact peer, int cnt, @NotNull IGetAioFirstViewLatestMsgCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, peer, Integer.valueOf(cnt), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        MsgService.f359521a.x(peer, cnt, cb5);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @Nullable
    public GroupAnonymousInfo getAnonymousInfo(@Nullable String groupId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            return (GroupAnonymousInfo) iPatchRedirector.redirect((short) 105, (Object) this, (Object) groupId);
        }
        return MsgService.f359521a.y(groupId);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getChannelFreqLimitInfo(@Nullable Contact peer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, (Object) this, (Object) peer);
        } else {
            MsgService.f359521a.z(peer);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getContactUnreadCnt(@Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) listener);
        } else {
            MsgService.f359521a.A(listener);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getDraft(@NotNull Contact peer, @Nullable IGetDraftOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) peer, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            MsgService.f359521a.B(peer, result);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getFirstUnreadMsgSeq(@NotNull Contact peer, @NotNull IGetMsgSeqCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) peer, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(listener, "listener");
        MsgService.f359521a.C(peer, listener);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @Nullable
    public Long getGroupMsgStorageTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 110)) {
            return (Long) iPatchRedirector.redirect((short) 110, (Object) this);
        }
        return MsgService.f359521a.D();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getGuestMsgAbstracts(@NotNull String guildId, @NotNull ArrayList<String> channelIds, int random, @Nullable IGuestGetMsgAbstractsCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, this, guildId, channelIds, Integer.valueOf(random), result);
            return;
        }
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelIds, "channelIds");
        MsgService.f359521a.E(guildId, channelIds, random, result);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getGuestMsgByRange(@Nullable Contact peer, long startSeq, int cnt, boolean queryOrder, int random, @Nullable IGuestMsgOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            iPatchRedirector.redirect((short) 89, this, peer, Long.valueOf(startSeq), Integer.valueOf(cnt), Boolean.valueOf(queryOrder), Integer.valueOf(random), result);
        } else {
            MsgService.f359521a.F(peer, startSeq, cnt, queryOrder, random, result);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getGuildGroupBubble(@NotNull Contact peer, boolean needFetch, @Nullable IGetGuildGroupBubbleCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            iPatchRedirector.redirect((short) 98, this, peer, Boolean.valueOf(needFetch), cb5);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            MsgService.f359521a.G(peer, needFetch, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getGuildGroupTransData(@Nullable Contact peer, @Nullable IGetGuildBinaryDataCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, (Object) peer, (Object) cb5);
        } else {
            MsgService.f359521a.H(peer, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<e> getLatestDbMsgList(@NotNull Contact peer, int cnt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Flow) iPatchRedirector.redirect((short) 14, (Object) this, (Object) peer, cnt);
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        return MsgService.f359521a.I(peer, cnt);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getLatestDbMsgs(@NotNull Contact peer, int cnt, @NotNull IMsgOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, peer, Integer.valueOf(cnt), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        MsgService.f359521a.K(peer, cnt, cb5);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getMsgAbstract(@NotNull Contact peer, long msgId, @Nullable IGetMsgAbstractsCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, this, peer, Long.valueOf(msgId), listener);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            MsgService.f359521a.L(peer, msgId, listener);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getMsgByClientSeqAndTime(@Nullable Contact peer, long msgClientSeq, long msgTime, @Nullable IMsgOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, peer, Long.valueOf(msgClientSeq), Long.valueOf(msgTime), listener);
        } else {
            MsgService.f359521a.M(peer, msgClientSeq, msgTime, listener);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getMsgEmojiLikesList(@Nullable Contact peer, long msgSeq, @Nullable String emojiId, long emojiType, @Nullable String cookie, boolean bForward, int number, @Nullable IGetMsgEmojiLikesListCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, this, peer, Long.valueOf(msgSeq), emojiId, Long.valueOf(emojiType), cookie, Boolean.valueOf(bForward), Integer.valueOf(number), cb5);
        } else {
            MsgService.f359521a.N(peer, msgSeq, emojiId, emojiType, cookie, bForward, number, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<e> getMsgList(@NotNull Contact peer, long msgId, int cnt, boolean queryOrder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Flow) iPatchRedirector.redirect((short) 13, this, peer, Long.valueOf(msgId), Integer.valueOf(cnt), Boolean.valueOf(queryOrder));
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        return MsgService.f359521a.O(peer, msgId, cnt, queryOrder);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getMsgSetting(@Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) listener);
        } else {
            MsgService.f359521a.Q(listener);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getMsgs(@NotNull Contact peer, long msgId, int cnt, boolean queryOrder, @NotNull IMsgOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, peer, Long.valueOf(msgId), Integer.valueOf(cnt), Boolean.valueOf(queryOrder), listener);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(listener, "listener");
        MsgService.f359521a.T(peer, msgId, cnt, queryOrder, listener);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getMsgsByMsgId(@Nullable Contact peer, @Nullable ArrayList<Long> msgIds, @Nullable IMsgOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, peer, msgIds, listener);
        } else {
            MsgService.f359521a.U(peer, msgIds, listener);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getMsgsBySeqAndCount(@Nullable Contact peer, long msgSeq, int cnt, boolean queryOrder, @Nullable IMsgOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, peer, Long.valueOf(msgSeq), Integer.valueOf(cnt), Boolean.valueOf(queryOrder), listener);
        } else {
            MsgService.f359521a.V(peer, msgSeq, cnt, queryOrder, listener);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getMsgsBySeqRange(@Nullable Contact peer, long beginSeq, long endSeq, @Nullable IMsgOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, peer, Long.valueOf(beginSeq), Long.valueOf(endSeq), listener);
        } else {
            MsgService.f359521a.W(peer, beginSeq, endSeq, listener);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getMsgsBySeqs(@Nullable Contact peer, @NotNull ArrayList<Long> msgSeqList, @Nullable IMsgOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, this, peer, msgSeqList, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(msgSeqList, "msgSeqList");
        if (peer != null) {
            MsgService.f359521a.X(peer, msgSeqList, listener);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @Nullable
    public Object getMsgsBySeqsSuspend(@NotNull Contact contact, long j3, boolean z16, @NotNull Continuation<? super com.tencent.qqnt.msg.api.c<ArrayList<MsgRecord>>> continuation) {
        Continuation intercepted;
        List<Long> mutableListOf;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 81)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            final ArrayList arrayList = new ArrayList();
            if (z16) {
                MsgService.f359521a.F(contact, 1 + j3, 1, true, new Random().nextInt(), new IGuestMsgOperateCallback(arrayList, cancellableContinuationImpl) { // from class: com.tencent.qqnt.msg.api.impl.MsgServiceImpl$getMsgsBySeqsSuspend$2$1
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ ArrayList<MsgRecord> f359566a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ CancellableContinuation<com.tencent.qqnt.msg.api.c<ArrayList<MsgRecord>>> f359567b;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        this.f359566a = arrayList;
                        this.f359567b = cancellableContinuationImpl;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) arrayList, (Object) cancellableContinuationImpl);
                        }
                    }

                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback
                    public final void onResult(int i3, String errMsg, ArrayList<MsgRecord> arrayList2, HashMap<Long, Integer> hashMap) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), errMsg, arrayList2, hashMap);
                            return;
                        }
                        this.f359566a.addAll(arrayList2);
                        ArrayList<MsgRecord> arrayList3 = this.f359566a;
                        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                        this.f359567b.resume(new com.tencent.qqnt.msg.api.c<>(arrayList3, i3, errMsg), AnonymousClass1.INSTANCE);
                    }
                });
            } else {
                MsgService msgService = MsgService.f359521a;
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Boxing.boxLong(j3));
                msgService.X(contact, mutableListOf, new IMsgOperateCallback(arrayList, cancellableContinuationImpl) { // from class: com.tencent.qqnt.msg.api.impl.MsgServiceImpl$getMsgsBySeqsSuspend$2$2
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ ArrayList<MsgRecord> f359568a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ CancellableContinuation<com.tencent.qqnt.msg.api.c<ArrayList<MsgRecord>>> f359569b;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        this.f359568a = arrayList;
                        this.f359569b = cancellableContinuationImpl;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) arrayList, (Object) cancellableContinuationImpl);
                        }
                    }

                    @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                    public final void onResult(int i3, String errMsg, ArrayList<MsgRecord> arrayList2) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), errMsg, arrayList2);
                            return;
                        }
                        this.f359568a.addAll(arrayList2);
                        ArrayList<MsgRecord> arrayList3 = this.f359568a;
                        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                        this.f359569b.resume(new com.tencent.qqnt.msg.api.c<>(arrayList3, i3, errMsg), AnonymousClass1.INSTANCE);
                    }
                });
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 81, this, contact, Long.valueOf(j3), Boolean.valueOf(z16), continuation);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getMsgsByTypeFilters(@Nullable Contact peer, long msgId, int cnt, boolean queryOrder, @Nullable ArrayList<MsgTypeFilter> typeFilters, @Nullable IMsgOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, this, peer, Long.valueOf(msgId), Integer.valueOf(cnt), Boolean.valueOf(queryOrder), typeFilters, listener);
        } else {
            MsgService.f359521a.Y(peer, msgId, cnt, queryOrder, typeFilters, listener);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getMsgsExt(@NotNull MsgsReq req, @Nullable IMsgsRspOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            MsgService.f359521a.Z(req, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<InputStatusInfo> getOnInputStatusPush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            return (Flow) iPatchRedirector.redirect((short) 100, (Object) this);
        }
        return MsgService.f359521a.h0();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getOnLineDev(@Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
        } else {
            MsgService.f359521a.j0(listener);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getRecallMsgsByMsgId(@Nullable Contact peer, @NotNull ArrayList<Long> msgIds, @Nullable IMsgOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, peer, msgIds, listener);
        } else {
            Intrinsics.checkNotNullParameter(msgIds, "msgIds");
            MsgService.f359521a.u0(peer, msgIds, listener);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getRecentEmojiList(int chatType, @Nullable IGetRecentUseEmojiListCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 109)) {
            iPatchRedirector.redirect((short) 109, (Object) this, chatType, (Object) cb5);
        } else {
            MsgService.f359521a.w0(chatType, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getRecentUseEmojiList(@Nullable IGetRecentUseEmojiListCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, (Object) cb5);
        } else {
            MsgService.f359521a.x0(cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getReplyDraft(@NotNull Contact peer, long rootSeq, @Nullable IGetDraftOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, this, peer, Long.valueOf(rootSeq), cb5);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            MsgService.f359521a.y0(peer, rootSeq, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getRichMediaElement(@NotNull RichMediaElementGetReq getReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this, (Object) getReq);
        } else {
            Intrinsics.checkNotNullParameter(getReq, "getReq");
            MsgService.f359521a.z0(getReq);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getSingleMsg(@Nullable Contact peer, long msgSeq, @Nullable IMsgOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, peer, Long.valueOf(msgSeq), listener);
        } else {
            MsgService.f359521a.A0(peer, msgSeq, listener);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getSourceOfReplyMsg(@Nullable Contact peer, long msgId, long sourceMsgSeq, @Nullable IMsgOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, peer, Long.valueOf(msgId), Long.valueOf(sourceMsgSeq), cb5);
        } else {
            MsgService.f359521a.B0(peer, msgId, sourceMsgSeq, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void getSourceOfReplyMsgV2(@NotNull Contact peer, long rootMsgId, long replyMsgId, @NotNull IMsgOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, peer, Long.valueOf(rootMsgId), Long.valueOf(replyMsgId), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        MsgService.f359521a.C0(peer, rootMsgId, replyMsgId, cb5);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void init(@Nullable w service) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            MsgService.f359521a.E0(service);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) service);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void insertGameResultAsMsgToDb(@Nullable MsgRecord msg2, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            iPatchRedirector.redirect((short) 93, (Object) this, (Object) msg2, (Object) cb5);
        } else {
            MsgService.f359521a.F0(msg2, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void isGuildChannelSync(@Nullable MatchKey matchKey, @Nullable IGuildMatchedOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, (Object) this, (Object) matchKey, (Object) result);
        } else {
            MsgService.f359521a.G0(matchKey, result);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void kickOffLine(@NotNull DevInfo devInfo, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) devInfo, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(devInfo, "devInfo");
            MsgService.f359521a.H0(devInfo, listener);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void likeOrDislikeReportForMsg(@NotNull Contact peer, @NotNull FeedBackMsgInfo msgInfo, @NotNull FeedBackDataForMsg feedBackData, @NotNull IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 111)) {
            iPatchRedirector.redirect((short) 111, this, peer, msgInfo, feedBackData, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        Intrinsics.checkNotNullParameter(feedBackData, "feedBackData");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        MsgService.f359521a.I0(peer, msgInfo, feedBackData, cb5);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void onScenesChangeForSilenceMode(int scenes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            iPatchRedirector.redirect((short) 95, (Object) this, scenes);
        } else {
            MsgService.f359521a.M0(scenes);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void queryMsgsWithFilterEx(long msgId, long msgTime, long msgSeq, @NotNull QueryMsgsParams params, @NotNull IMsgOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            iPatchRedirector.redirect((short) 102, this, Long.valueOf(msgId), Long.valueOf(msgTime), Long.valueOf(msgSeq), params, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        MsgService.f359521a.N0(msgId, msgTime, msgSeq, params, cb5);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void recallMsg(@NotNull Contact peer, long msgId, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, peer, Long.valueOf(msgId), listener);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            MsgService.f359521a.O0(peer, msgId, listener);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<Contact> receiveClearMsgRecordsFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Flow) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return MsgService.f359521a.P0();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<h> receiveSysMsgNotificationFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Flow) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return MsgService.f359521a.R0();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void reeditRecallMsg(@Nullable Contact peer, long msgId, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, peer, Long.valueOf(msgId), cb5);
        } else {
            MsgService.f359521a.S0(peer, msgId, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void refreshMsgAbstracts(@NotNull String guildId, @Nullable ArrayList<String> channelIds) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, (Object) this, (Object) guildId, (Object) channelIds);
        } else {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            MsgService.f359521a.T0(guildId, channelIds);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void regenerateMsg(@NotNull Contact peer, long msgId, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, peer, Long.valueOf(msgId), cb5);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            MsgService.f359521a.U0(peer, msgId, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<com.tencent.qqnt.msg.data.b> registerChannelFreqLimitInfoUpdateNotificationFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return (Flow) iPatchRedirector.redirect((short) 66, (Object) this);
        }
        return MsgService.f359521a.l();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<CustomWithdrawConfig> registerCustomWithdrawConfigUpdateFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            return (Flow) iPatchRedirector.redirect((short) 99, (Object) this);
        }
        return MsgService.f359521a.V0();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<com.tencent.qqnt.msg.data.d> registerDeleteMsgNotificationFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (Flow) iPatchRedirector.redirect((short) 47, (Object) this);
        }
        return MsgService.f359521a.q();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<com.tencent.qqnt.msg.data.c> registerDraftUpdateNotificationFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return (Flow) iPatchRedirector.redirect((short) 67, (Object) this);
        }
        return MsgService.f359521a.s();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<List<com.tencent.qqnt.msg.d>> registerFileComeNotificationFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
            return (Flow) iPatchRedirector.redirect((short) 106, (Object) this);
        }
        return MsgService.f359521a.W0();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<ArrayList<com.tencent.qqnt.msg.d>> registerMsgInfoListAddNotificationFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Flow) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return MsgService.f359521a.J0();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<ArrayList<com.tencent.qqnt.msg.d>> registerMsgStatusUpdateNotificationFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Flow) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return MsgService.f359521a.K0();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<ArrayList<Long>> registerOnMsgDeleteNotificationFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Flow) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return MsgService.f359521a.L0();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<List<com.tencent.qqnt.msg.d>> registerReceiveMsgNotificationFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Flow) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return MsgService.f359521a.Q0();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<FileTransNotifyInfo> registerRichMediaDownloadCompleteFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Flow) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return MsgService.f359521a.b1();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<FileTransNotifyInfo> registerRichMediaDownloadProgressFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (Flow) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return MsgService.f359521a.c1();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<FileTransNotifyInfo> registerRichMediaUploadCompleteFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Flow) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return MsgService.f359521a.d1();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<com.tencent.qqnt.msg.d> registerSecurityNotificationFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
            return (Flow) iPatchRedirector.redirect((short) 107, (Object) this);
        }
        return MsgService.f359521a.X0();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<com.tencent.qqnt.msg.d> registerSendMsgNotificationFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Flow) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return MsgService.f359521a.j1();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void registerSysMsgNotification(int businessType, long msgType, @NotNull ArrayList<Long> msgSubType, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, this, Integer.valueOf(businessType), Long.valueOf(msgType), msgSubType, cb5);
        } else {
            Intrinsics.checkNotNullParameter(msgSubType, "msgSubType");
            MsgService.f359521a.Y0(businessType, msgType, msgSubType, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void renameAnonyChatNick(@Nullable String groupId, @Nullable IRenameAnonymousChatNickCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 104)) {
            iPatchRedirector.redirect((short) 104, (Object) this, (Object) groupId, (Object) cb5);
        } else {
            MsgService.f359521a.Z0(groupId, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void resendMsg(@NotNull Contact peer, long msgId, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, peer, Long.valueOf(msgId), listener);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            MsgService.f359521a.a1(peer, msgId, listener);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void sendInputStatusReq(int chatType, int eventType, @NotNull String toUid, @NotNull IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            iPatchRedirector.redirect((short) 101, this, Integer.valueOf(chatType), Integer.valueOf(eventType), toUid, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(toUid, "toUid");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        MsgService.f359521a.e1(chatType, eventType, toUid, cb5);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void sendMsg(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, peer, msgElements, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        MsgService.f359521a.g1(peer, msgElements, listener);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    @NotNull
    public Flow<f> sendMsgErrorNotificationFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (Flow) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return MsgService.f359521a.i1();
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void sendMsgWithMsgId(@NotNull Contact peer, long msgId, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, peer, Long.valueOf(msgId), msgElements, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        MsgService.f359521a.f1(peer, msgId, msgElements, listener);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void sendSummonMsg(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            iPatchRedirector.redirect((short) 94, this, peer, msgElements, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        MsgService.f359521a.k1(peer, msgElements, cb5);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void setBuildMode(int flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, flag);
        } else {
            MsgService.f359521a.l1(flag);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void setConfigurationServiceData(@NotNull HashMap<Long, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            iPatchRedirector.redirect((short) 96, (Object) this, (Object) map);
        } else {
            Intrinsics.checkNotNullParameter(map, "map");
            MsgService.f359521a.m1(map);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void setCurOnScreenMsgForMsgEvent(@NotNull Contact peer, @NotNull HashMap<Long, byte[]> msgEventInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, (Object) peer, (Object) msgEventInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgEventInfo, "msgEventInfo");
        MsgService.f359521a.n1(peer, msgEventInfo);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void setDraft(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, peer, msgElements, result);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        MsgService.f359521a.o1(peer, msgElements, result);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void setFocusOnGuild(boolean focus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, focus);
        } else {
            MsgService.f359521a.p1(focus);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void setGroupGuildBubbleRead(@NotNull Contact peer, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            iPatchRedirector.redirect((short) 97, (Object) this, (Object) peer, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            MsgService.f359521a.q1(peer, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void setGroupGuildFlag(int flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, flag);
        } else {
            MsgService.f359521a.r1(flag);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void setGroupGuildMsgRead(@NotNull Contact peer, @NotNull ArrayList<SceneInfoParam> sceneInfo, boolean isLocal, boolean isDelete, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, this, peer, sceneInfo, Boolean.valueOf(isLocal), Boolean.valueOf(isDelete), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(sceneInfo, "sceneInfo");
        MsgService.f359521a.s1(peer, sceneInfo, isLocal, isDelete, cb5);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void setGuildTabUserFlag(int flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, flag);
        } else {
            MsgService.f359521a.t1(flag);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void setGuildUDCFlag(int flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, flag);
        } else {
            MsgService.f359521a.u1(flag);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void setLocalMsgRead(@NotNull Contact peer, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) peer, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            MsgService.f359521a.v1(peer, listener);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void setMsgEmojiLikes(@Nullable Contact peer, long msgSeq, @Nullable String emojiId, long emojiType, boolean setEmoji, @Nullable ISetMsgEmojiLikesCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, this, peer, Long.valueOf(msgSeq), emojiId, Long.valueOf(emojiType), Boolean.valueOf(setEmoji), cb5);
        } else {
            MsgService.f359521a.w1(peer, msgSeq, emojiId, emojiType, setEmoji, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void setMsgEmojiLikesForRole(@Nullable Contact peer, long msgSeq, @Nullable String emojiId, long emojiType, long taskId, long taskType, boolean setEmoji, boolean isGuest, @NotNull AttaReportData attaReportData, @Nullable ISetMsgEmojiLikesForRoleCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, this, peer, Long.valueOf(msgSeq), emojiId, Long.valueOf(emojiType), Long.valueOf(taskId), Long.valueOf(taskType), Boolean.valueOf(setEmoji), Boolean.valueOf(isGuest), attaReportData, cb5);
        } else {
            Intrinsics.checkNotNullParameter(attaReportData, "attaReportData");
            MsgService.f359521a.x1(peer, msgSeq, emojiId, emojiType, taskId, taskType, setEmoji, isGuest, attaReportData, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void setMsgRead(@NotNull Contact peer, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) peer, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            MsgService.f359521a.z1(peer, listener);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void setMsgReadAndReport(@NotNull Contact peer, @NotNull MsgRecord lastMsg, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, peer, lastMsg, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(lastMsg, "lastMsg");
        MsgService.f359521a.A1(peer, lastMsg, listener);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void setMsgRichInfoFlag(boolean richFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 112)) {
            iPatchRedirector.redirect((short) 112, (Object) this, richFlag);
        } else {
            MsgService.f359521a.B1(richFlag);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void setMsgSetting(@NotNull MsgSetting msgSetting, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) msgSetting, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(msgSetting, "msgSetting");
            MsgService.f359521a.C1(msgSetting, listener);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void setReplyDraft(@NotNull Contact peer, long rootSeq, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, this, peer, Long.valueOf(rootSeq), msgElements, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        MsgService.f359521a.E1(peer, rootSeq, msgElements, cb5);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void startGuildMsgSync() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            iPatchRedirector.redirect((short) 92, (Object) this);
        } else {
            MsgService.f359521a.F1();
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void stopGenerateMsg(@NotNull Contact peer, long msgId, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, peer, Long.valueOf(msgId), cb5);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            MsgService.f359521a.G1(peer, msgId, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void switchAnonymousChat(@Nullable String groupId, boolean isAnonymousChat, @Nullable ISwitchAnonymousChatCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            iPatchRedirector.redirect((short) 103, this, groupId, Boolean.valueOf(isAnonymousChat), cb5);
        } else {
            MsgService.f359521a.H1(groupId, isAnonymousChat, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void unregisterSysMsgNotification(int businessType, long msgType, @NotNull ArrayList<Long> msgSubType, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            iPatchRedirector.redirect((short) 91, this, Integer.valueOf(businessType), Long.valueOf(msgType), msgSubType, cb5);
        } else {
            Intrinsics.checkNotNullParameter(msgSubType, "msgSubType");
            MsgService.f359521a.I1(businessType, msgType, msgSubType, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void updateElementExtBufForUI(@NotNull Contact peer, long rootMsgId, long elemId, @NotNull byte[] extBufForUI, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, peer, Long.valueOf(rootMsgId), Long.valueOf(elemId), extBufForUI, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(extBufForUI, "extBufForUI");
        MsgService.f359521a.J1(peer, rootMsgId, elemId, extBufForUI, cb5);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void init(@Nullable t service) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            MsgService.f359521a.D0(service);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) service);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void sendMsg(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements, @NotNull HashMap<Integer, MsgAttributeInfo> msgAttr, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, peer, msgElements, msgAttr, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        Intrinsics.checkNotNullParameter(msgAttr, "msgAttr");
        MsgService.f359521a.h1(peer, msgElements, msgAttr, listener);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgService
    public void sendMsg(@NotNull Contact peer, long msgId, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, peer, Long.valueOf(msgId), msgElements, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        MsgService.f359521a.f1(peer, msgId, msgElements, listener);
    }
}

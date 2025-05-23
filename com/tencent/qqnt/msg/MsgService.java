package com.tencent.qqnt.msg;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.t;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.AttaReportData;
import com.tencent.qqnt.kernel.nativeinterface.ContactMsgBoxInfo;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DevInfo;
import com.tencent.qqnt.kernel.nativeinterface.FeedBackDataForMsg;
import com.tencent.qqnt.kernel.nativeinterface.FeedBackMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.FirstViewGroupGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.FreqLimitInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupAnonymousInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupGuildNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildMsgAbFlag;
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
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import com.tencent.qqnt.kernel.nativeinterface.MatchKey;
import com.tencent.qqnt.kernel.nativeinterface.MiscData;
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
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.LocalGrayTipElement;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.common.nt_msg_common$Msg;
import tencent.im.msg.nt_sys_msg_common$Msg;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002\u00a2\u0006\u0006\b\u00e6\u0002\u0010\u00e7\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012H\u0007J0\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\bJT\u0010\"\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\"\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dj\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f` 2\b\u0010\t\u001a\u0004\u0018\u00010\bJ8\u0010%\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010$\u001a\u00020#2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0018\u0010&\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\t\u001a\u0004\u0018\u00010\bJ \u0010(\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010$\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010\bJ \u0010)\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010$\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010\bJ \u0010*\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010$\u001a\u00020#2\b\u0010\t\u001a\u0004\u0018\u00010\bJ2\u0010-\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020#0\u0018j\b\u0012\u0004\u0012\u00020#`\u001a2\b\u0010\t\u001a\u0004\u0018\u00010,J\"\u0010.\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010\bJ4\u0010/\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u001a\u0010+\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020#\u0018\u0001`\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\bJ0\u00104\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020#2\u0006\u00103\u001a\u0002022\b\u0010'\u001a\u0004\u0018\u00010\bJ\u0016\u00106\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u000205J0\u0010:\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010$\u001a\u00020#2\u0006\u00107\u001a\u00020\u001e2\u0006\u00109\u001a\u0002082\u0006\u0010\t\u001a\u00020,H\u0007J*\u0010=\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020#2\b\u0010\t\u001a\u0004\u0018\u00010,J&\u0010@\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010>\u001a\b\u0012\u0004\u0012\u00020#0\u00132\b\u0010?\u001a\u0004\u0018\u00010,J\u001a\u0010C\u001a\u00020\u00042\b\u0010B\u001a\u0004\u0018\u00010A2\b\u0010'\u001a\u0004\u0018\u00010\bJ4\u0010E\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010D\u001a\u00020#2\u0006\u00107\u001a\u00020\u001e2\u0006\u00109\u001a\u0002082\b\u0010\t\u001a\u0004\u0018\u00010,H\u0007J\u0018\u0010I\u001a\u00020\u00042\u0006\u0010G\u001a\u00020F2\b\u0010'\u001a\u0004\u0018\u00010HJ:\u0010J\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u001e\u0010+\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\u0018j\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u0001`\u001a2\b\u0010\t\u001a\u0004\u0018\u00010,J\"\u0010K\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010D\u001a\u00020#2\b\u0010\t\u001a\u0004\u0018\u00010,J*\u0010N\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010L\u001a\u00020#2\u0006\u0010M\u001a\u00020#2\b\u0010\t\u001a\u0004\u0018\u00010,J\u001e\u0010R\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010P\u001a\u00020O2\u0006\u0010Q\u001a\u00020\u001eJN\u0010U\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020#2\u0006\u00107\u001a\u00020\u001e2\u0006\u00109\u001a\u0002082\u001a\u0010T\u001a\u0016\u0012\u0004\u0012\u00020S\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020S\u0018\u0001`\u001a2\b\u0010\t\u001a\u0004\u0018\u00010,J\u000e\u0010W\u001a\u00020\u00042\u0006\u0010V\u001a\u000208J \u0010X\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010$\u001a\u00020#2\b\u0010\t\u001a\u0004\u0018\u00010\bJ \u0010Z\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020A2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0018\u0010[\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\t\u001a\u0004\u0018\u00010\bJ \u0010]\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010$\u001a\u00020#2\b\u0010\t\u001a\u0004\u0018\u00010\\J\"\u0010`\u001a\u00020\u00042\b\u0010^\u001a\u0004\u0018\u00010O2\u0010\u0010_\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010O\u0018\u00010\u0018J\u0010\u0010a\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u000e\u0010d\u001a\u00020\u00042\u0006\u0010c\u001a\u00020bJ\u000e\u0010e\u001a\u00020\u00042\u0006\u0010c\u001a\u00020bJ\u0010\u0010g\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010fJ<\u0010l\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010D\u001a\u00020#2\b\u0010h\u001a\u0004\u0018\u00010O2\u0006\u0010i\u001a\u00020#2\u0006\u0010j\u001a\u0002082\b\u0010'\u001a\u0004\u0018\u00010kJ\\\u0010s\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010D\u001a\u00020#2\b\u0010h\u001a\u0004\u0018\u00010O2\u0006\u0010i\u001a\u00020#2\u0006\u0010m\u001a\u00020#2\u0006\u0010n\u001a\u00020#2\u0006\u0010j\u001a\u0002082\u0006\u0010o\u001a\u0002082\u0006\u0010q\u001a\u00020p2\b\u0010'\u001a\u0004\u0018\u00010rJN\u0010x\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010D\u001a\u00020#2\b\u0010h\u001a\u0004\u0018\u00010O2\u0006\u0010i\u001a\u00020#2\b\u0010t\u001a\u0004\u0018\u00010O2\u0006\u0010u\u001a\u0002082\u0006\u0010v\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010wJ2\u0010z\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\"\u0010y\u001a\u001e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u0002020\u001dj\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u000202` J\u0010\u0010{\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001e\u0010|\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u0018j\b\u0012\u0004\u0012\u00020\u0014`\u001a0\u0012H\u0007J\"\u0010}\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020#\u0018\u0001`\u001a0\u0012H\u0007J\u0010\u0010\u007f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010~0\u0012H\u0007J:\u0010\u0081\u0001\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0007\u0010\u0080\u0001\u001a\u00020#2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\b\u0010'\u001a\u0004\u0018\u00010\bJ#\u0010\u0083\u0001\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0007\u0010\u0080\u0001\u001a\u00020#2\t\u0010'\u001a\u0005\u0018\u00010\u0082\u0001J\"\u0010\u0084\u0001\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0007\u0010\u0080\u0001\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010\bJ\u001e\u0010\u0088\u0001\u001a\u00020\u00042\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00012\t\u0010?\u001a\u0005\u0018\u00010\u0087\u0001J-\u0010\u008d\u0001\u001a\u00020\u00042\u0007\u0010\u0089\u0001\u001a\u00020\u00162\b\u0010\u008b\u0001\u001a\u00030\u008a\u00012\u0007\u0010\u008c\u0001\u001a\u0002082\b\u0010'\u001a\u0004\u0018\u00010\bJ$\u0010\u0090\u0001\u001a\u00020\u00042\u0007\u0010\u0089\u0001\u001a\u00020\u00162\b\u0010\u008f\u0001\u001a\u00030\u008e\u00012\b\u0010'\u001a\u0004\u0018\u00010\bJ;\u0010\u0093\u0001\u001a\u00020\u00042\u0006\u0010^\u001a\u00020O2\u0016\u0010_\u001a\u0012\u0012\u0004\u0012\u00020O0\u0018j\b\u0012\u0004\u0012\u00020O`\u001a2\u0007\u0010\u0091\u0001\u001a\u00020\u001e2\t\u0010?\u001a\u0005\u0018\u00010\u0092\u0001J>\u0010\u0096\u0001\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0007\u0010\u0094\u0001\u001a\u00020#2\u0006\u00107\u001a\u00020\u001e2\u0006\u00109\u001a\u0002082\u0007\u0010\u0091\u0001\u001a\u00020\u001e2\t\u0010?\u001a\u0005\u0018\u00010\u0095\u0001J<\u0010\u009a\u0001\u001a\u00020\u00042\u0007\u0010\u0097\u0001\u001a\u00020\u001e2\u0007\u0010\u0098\u0001\u001a\u00020#2\u0017\u0010\u0099\u0001\u001a\u0012\u0012\u0004\u0012\u00020#0\u0018j\b\u0012\u0004\u0012\u00020#`\u001a2\b\u0010'\u001a\u0004\u0018\u00010\bJ<\u0010\u009b\u0001\u001a\u00020\u00042\u0007\u0010\u0097\u0001\u001a\u00020\u001e2\u0007\u0010\u0098\u0001\u001a\u00020#2\u0017\u0010\u0099\u0001\u001a\u0012\u0012\u0004\u0012\u00020#0\u0018j\b\u0012\u0004\u0012\u00020#`\u001a2\b\u0010'\u001a\u0004\u0018\u00010\bJ\u0007\u0010\u009c\u0001\u001a\u00020\u0004J1\u0010\u009d\u0001\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\b\u0010'\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u009f\u0001\u001a\u00020\u00042\u0007\u0010\u009e\u0001\u001a\u00020\u001eJ0\u0010\u00a1\u0001\u001a\t\u0012\u0005\u0012\u00030\u00a0\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010$\u001a\u00020#2\u0006\u00107\u001a\u00020\u001e2\u0006\u00109\u001a\u000208H\u0007J \u0010\u00a2\u0001\u001a\t\u0012\u0005\u0012\u00030\u00a0\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u001eH\u0007J\u000f\u0010\u00a3\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012H\u0007J\u0010\u0010\u00a5\u0001\u001a\t\u0012\u0005\u0012\u00030\u00a4\u00010\u0012H\u0007J\u000f\u0010\u00a6\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\u0012H\u0007J\u001f\u0010\u00a7\u0001\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u0018j\b\u0012\u0004\u0012\u00020\u0014`\u001a0\u0012H\u0007J\u0010\u0010\u00a9\u0001\u001a\t\u0012\u0005\u0012\u00030\u00a8\u00010\u0012H\u0007J\u0010\u0010\u00aa\u0001\u001a\t\u0012\u0005\u0012\u00030\u00a8\u00010\u0012H\u0007J\u0010\u0010\u00ab\u0001\u001a\t\u0012\u0005\u0012\u00030\u00a8\u00010\u0012H\u0007J\u0010\u0010\u00ad\u0001\u001a\t\u0012\u0005\u0012\u00030\u00ac\u00010\u0012H\u0007J\u0010\u0010\u00af\u0001\u001a\t\u0012\u0005\u0012\u00030\u00ae\u00010\u0012H\u0007J\u001f\u0010\u00b0\u0001\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020,J \u0010\u00b2\u0001\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u001e2\u0007\u0010'\u001a\u00030\u00b1\u0001J,\u0010\u00b4\u0001\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020#2\u0007\u0010\u00b3\u0001\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010,J(\u0010\u00b6\u0001\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u00100\u001a\u00020#2\u0007\u0010\u00b5\u0001\u001a\u00020#2\u0006\u0010'\u001a\u00020,J1\u0010\u00b7\u0001\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\b\u0010?\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u00b8\u0001\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\t\u0010?\u001a\u0005\u0018\u00010\u0082\u0001J\u0019\u0010\u00b9\u0001\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010'\u001a\u0004\u0018\u00010\bJ)\u0010\u00bc\u0001\u001a\u00020\u00042\u0017\u0010\u00ba\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0018j\b\u0012\u0004\u0012\u00020\u0016`\u001a2\u0007\u0010'\u001a\u00030\u00bb\u0001J\u001f\u0010\u00be\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030\u00bd\u00010\u0018j\t\u0012\u0005\u0012\u00030\u00bd\u0001`\u001a0\u0012JF\u0010\u00c3\u0001\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0019\u0010\u00c0\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u00bf\u00010\u0018j\t\u0012\u0005\u0012\u00030\u00bf\u0001`\u001a2\u0007\u0010\u00c1\u0001\u001a\u0002082\u0007\u0010\u00c2\u0001\u001a\u0002082\b\u0010'\u001a\u0004\u0018\u00010\bJ\"\u0010\u00c5\u0001\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0007\u0010\u00c4\u0001\u001a\u0002082\b\u0010'\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u00c7\u0001\u001a\u00020\u00042\u0007\u0010\u00c6\u0001\u001a\u00020\u001eJ\u0010\u0010\u00c8\u0001\u001a\u00020\u00042\u0007\u0010\u00c6\u0001\u001a\u00020\u001eJ\u0010\u0010\u00c9\u0001\u001a\u00020\u00042\u0007\u0010\u00c6\u0001\u001a\u00020\u001eJ\u0010\u0010\u00ca\u0001\u001a\u00020\u00042\u0007\u0010\u00c6\u0001\u001a\u00020\u001eJ\u001c\u0010\u00cc\u0001\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\t\u0010'\u001a\u0005\u0018\u00010\u00cb\u0001J'\u0010\u00cd\u0001\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aJg\u0010\u00d2\u0001\u001a\u00020\u00042\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020#0\u0018j\b\u0012\u0004\u0012\u00020#`\u001a2\u0007\u0010\u00ce\u0001\u001a\u00020\u00162\u0017\u0010\u00cf\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0018j\b\u0012\u0004\u0012\u00020\u0016`\u001a2\u001b\u0010\u00d0\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a2\u0007\u0010'\u001a\u00030\u00d1\u0001J\"\u0010\u00d6\u0001\u001a\u00020\u00042\b\u0010\u00d4\u0001\u001a\u00030\u00d3\u00012\u0007\u0010\u00d5\u0001\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\bJ\u0010\u0010\u00d8\u0001\u001a\t\u0012\u0005\u0012\u00030\u00d7\u00010\u0012H\u0007J,\u0010\u00da\u0001\u001a\u00020\u00042#\u0010\u00d9\u0001\u001a\u001e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020O0\u001dj\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020O` J\u0019\u0010\u00db\u0001\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010'\u001a\u0004\u0018\u00010\bJ#\u0010\u00de\u0001\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0007\u0010\u00dc\u0001\u001a\u0002082\t\u0010'\u001a\u0005\u0018\u00010\u00dd\u0001J\u0010\u0010\u00e0\u0001\u001a\t\u0012\u0005\u0012\u00030\u00df\u00010\u0012H\u0007J\u0010\u0010\u00e2\u0001\u001a\t\u0012\u0005\u0012\u00030\u00e1\u00010\u0012H\u0007J)\u0010\u00e5\u0001\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u001e2\u0007\u0010\u00e3\u0001\u001a\u00020\u001e2\u0007\u0010\u00e4\u0001\u001a\u00020O2\u0006\u0010?\u001a\u00020\bJ1\u0010\u00e8\u0001\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010M\u001a\u00020#2\u0006\u0010D\u001a\u00020#2\b\u0010\u00e7\u0001\u001a\u00030\u00e6\u00012\u0006\u0010'\u001a\u00020,J\u001a\u0010\u00ec\u0001\u001a\u00020\u00042\b\u0010\u00ea\u0001\u001a\u00030\u00e9\u00012\u0007\u0010'\u001a\u00030\u00eb\u0001J&\u0010\u00f0\u0001\u001a\u00020\u00042\t\u0010\u00ed\u0001\u001a\u0004\u0018\u00010O2\u0007\u0010\u00ee\u0001\u001a\u0002082\t\u0010'\u001a\u0005\u0018\u00010\u00ef\u0001J\u001d\u0010\u00f2\u0001\u001a\u00020\u00042\t\u0010\u00ed\u0001\u001a\u0004\u0018\u00010O2\t\u0010'\u001a\u0005\u0018\u00010\u00f1\u0001J\u0015\u0010\u00f4\u0001\u001a\u0005\u0018\u00010\u00f3\u00012\t\u0010\u00ed\u0001\u001a\u0004\u0018\u00010OJ\u0015\u0010\u00f5\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012H\u0007J\r\u0010\u00f6\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\u0012J\u0019\u0010\u00f7\u0001\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010fJ\u0012\u0010\u00f8\u0001\u001a\u0004\u0018\u00010#\u00a2\u0006\u0006\b\u00f8\u0001\u0010\u00f9\u0001J+\u0010\u00fe\u0001\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u00fb\u0001\u001a\u00030\u00fa\u00012\b\u0010\u00fd\u0001\u001a\u00030\u00fc\u00012\u0006\u0010'\u001a\u00020\bJ\u0010\u0010\u0080\u0002\u001a\u00020\u00042\u0007\u0010\u00ff\u0001\u001a\u000208R>\u0010\u008a\u0002\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u0083\u0002\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u0081\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u0084\u0002\u0010\u0085\u0002\u001a\u0006\b\u0086\u0002\u0010\u0087\u0002\"\u0006\b\u0088\u0002\u0010\u0089\u0002RS\u0010\u0092\u0002\u001a,\u0012\u0004\u0012\u00020\u001e\u0012!\u0012\u001f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\u0018j\b\u0012\u0004\u0012\u00020\u000b`\u001a\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u008c\u0002\u0010\u008d\u0002\u001a\u0006\b\u008e\u0002\u0010\u008f\u0002\"\u0006\b\u0090\u0002\u0010\u0091\u0002RD\u0010\u0097\u0002\u001a\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u0093\u0002\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u0094\u0002\u0010\u008d\u0002\u001a\u0006\b\u0095\u0002\u0010\u008f\u0002\"\u0006\b\u0096\u0002\u0010\u0091\u0002RC\u0010\u009b\u0002\u001a\u001c\u0012\u0004\u0012\u00020\u001e\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u0098\u0002\u0010\u008d\u0002\u001a\u0006\b\u0099\u0002\u0010\u008f\u0002\"\u0006\b\u009a\u0002\u0010\u0091\u0002RC\u0010\u009f\u0002\u001a\u001c\u0012\u0004\u0012\u00020\u001e\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u009c\u0002\u0010\u008d\u0002\u001a\u0006\b\u009d\u0002\u0010\u008f\u0002\"\u0006\b\u009e\u0002\u0010\u0091\u0002RI\u0010\u00a2\u0002\u001a\"\u0012\u0004\u0012\u00020\u001e\u0012\u0017\u0012\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008d\u0002\u001a\u0006\b\u00a0\u0002\u0010\u008f\u0002\"\u0006\b\u00a1\u0002\u0010\u0091\u0002RI\u0010\u00a4\u0002\u001a,\u0012\u0004\u0012\u00020\u001e\u0012!\u0012\u001f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u0018j\b\u0012\u0004\u0012\u00020\u0014`\u001a\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000X\u0080\u0004\u00a2\u0006\u0010\n\u0006\b\u0090\u0001\u0010\u008d\u0002\u001a\u0006\b\u00a3\u0002\u0010\u008f\u0002RW\u0010\u00a7\u0002\u001a0\u0012\u0004\u0012\u00020\u001e\u0012%\u0012#\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020#\u0018\u0001`\u001a\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u00cd\u0001\u0010\u008d\u0002\u001a\u0006\b\u00a5\u0002\u0010\u008f\u0002\"\u0006\b\u00a6\u0002\u0010\u0091\u0002RC\u0010\u00aa\u0002\u001a\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u00d7\u0001\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0017\n\u0005\be\u0010\u008d\u0002\u001a\u0006\b\u00a8\u0002\u0010\u008f\u0002\"\u0006\b\u00a9\u0002\u0010\u0091\u0002RD\u0010\u00ad\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0013\u0012\u0011\u0012\u0006\u0012\u0004\u0018\u00010~\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0017\n\u0005\bR\u0010\u008d\u0002\u001a\u0006\b\u00ab\u0002\u0010\u008f\u0002\"\u0006\b\u00ac\u0002\u0010\u0091\u0002RD\u0010\u00b0\u0002\u001a\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u00a8\u0001\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u00d8\u0001\u0010\u008d\u0002\u001a\u0006\b\u00ae\u0002\u0010\u008f\u0002\"\u0006\b\u00af\u0002\u0010\u0091\u0002RD\u0010\u00b3\u0002\u001a\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u00a8\u0001\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u00ec\u0001\u0010\u008d\u0002\u001a\u0006\b\u00b1\u0002\u0010\u008f\u0002\"\u0006\b\u00b2\u0002\u0010\u0091\u0002RD\u0010\u00b6\u0002\u001a\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u00a8\u0001\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u00be\u0001\u0010\u008d\u0002\u001a\u0006\b\u00b4\u0002\u0010\u008f\u0002\"\u0006\b\u00b5\u0002\u0010\u0091\u0002RD\u0010\u00b9\u0002\u001a\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u00ac\u0001\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u00b9\u0001\u0010\u008d\u0002\u001a\u0006\b\u00b7\u0002\u0010\u008f\u0002\"\u0006\b\u00b8\u0002\u0010\u0091\u0002RP\u0010\u00be\u0002\u001a*\u0012\u0004\u0012\u00020\u001e\u0012\u001f\u0012\u001d\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0005\u0012\u00030\u00bb\u00020\u00ba\u0002\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0017\n\u0005\b/\u0010\u008d\u0002\u001a\u0006\b\u00bc\u0002\u0010\u008f\u0002\"\u0006\b\u00bd\u0002\u0010\u0091\u0002RD\u0010\u00c2\u0002\u001a\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u00bf\u0002\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u00af\u0001\u0010\u008d\u0002\u001a\u0006\b\u00c0\u0002\u0010\u008f\u0002\"\u0006\b\u00c1\u0002\u0010\u0091\u0002R2\u0010\u00c7\u0002\u001a\u0014\u0012\u0005\u0012\u00030\u00c3\u00020\u0018j\t\u0012\u0005\u0012\u00030\u00c3\u0002`\u001a8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0084\u0001\u0010\u00c4\u0002\u001a\u0006\b\u00c5\u0002\u0010\u00c6\u0002R9\u0010\u00c9\u0002\u001a\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u00a4\u0001\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000X\u0080\u0004\u00a2\u0006\u000f\n\u0005\b\u007f\u0010\u008d\u0002\u001a\u0006\b\u00c8\u0002\u0010\u008f\u0002RI\u0010\u00cb\u0002\u001a,\u0012\u0004\u0012\u00020\u001e\u0012!\u0012\u001f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u0018j\b\u0012\u0004\u0012\u00020\u0014`\u001a\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000X\u0080\u0004\u00a2\u0006\u0010\n\u0006\b\u00c5\u0001\u0010\u008d\u0002\u001a\u0006\b\u00ca\u0002\u0010\u008f\u0002R9\u0010\u00d1\u0002\u001a\u0012\u0012\u0005\u0012\u00030\u00a0\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0082\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u00d6\u0001\u0010\u00cc\u0002\u001a\u0006\b\u00cd\u0002\u0010\u00ce\u0002\"\u0006\b\u00cf\u0002\u0010\u00d0\u0002R9\u0010\u00d4\u0002\u001a\u0012\u0012\u0005\u0012\u00030\u00ae\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0082\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u00d2\u0001\u0010\u00cc\u0002\u001a\u0006\b\u00d2\u0002\u0010\u00ce\u0002\"\u0006\b\u00d3\u0002\u0010\u00d0\u0002RC\u0010\u00d7\u0002\u001a\u001c\u0012\u0004\u0012\u00020\u001e\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u00bc\u0001\u0010\u008d\u0002\u001a\u0006\b\u00d5\u0002\u0010\u008f\u0002\"\u0006\b\u00d6\u0002\u0010\u0091\u0002R=\u0010\u00d8\u0002\u001a(\u0012#\u0012!\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030\u00bd\u00010\u0018j\t\u0012\u0005\u0012\u00030\u00bd\u0001`\u001a\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u0081\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b2\u0001\u0010\u0085\u0002RD\u0010\u00db\u0002\u001a\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u00df\u0001\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u00f4\u0001\u0010\u008d\u0002\u001a\u0006\b\u00d9\u0002\u0010\u008f\u0002\"\u0006\b\u00da\u0002\u0010\u0091\u0002R1\u0010\u00dc\u0002\u001a\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u00e1\u0001\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\ba\u0010\u008d\u0002RH\u0010\u00df\u0002\u001a\"\u0012\u0004\u0012\u00020\u001e\u0012\u0017\u0012\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u008b\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0017\n\u0005\b{\u0010\u008d\u0002\u001a\u0006\b\u00dd\u0002\u0010\u008f\u0002\"\u0006\b\u00de\u0002\u0010\u0091\u0002R=\u0010\u00e5\u0002\u001a(\u0012#\u0012!\u0012\u0016\u0012\u00140\u0014\u00a2\u0006\u000f\b\u00e1\u0002\u0012\n\b\u00e2\u0002\u0012\u0005\b\b(\u00e3\u0002\u0012\u0004\u0012\u00020\u00040\u0082\u00020\u00e0\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b8\u0001\u0010\u00e4\u0002\u00a8\u0006\u00e8\u0002"}, d2 = {"Lcom/tencent/qqnt/msg/MsgService;", "", "Lcom/tencent/qqnt/kernel/api/w;", "service", "", "E0", "Lcom/tencent/qqnt/kernel/api/t;", "D0", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "listener", "j0", "Lcom/tencent/qqnt/kernel/nativeinterface/DevInfo;", "devInfo", "H0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgSetting;", "msgSetting", "C1", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/tencent/qqnt/msg/d;", "Q0", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "g1", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "Lkotlin/collections/HashMap;", "msgAttrs", "h1", "", "msgId", "f1", "z1", "cb", Constants.APK_CERTIFICATE, "U0", "O0", "msgIds", "Lcom/tencent/qqnt/kernel/nativeinterface/IMsgOperateCallback;", "u0", "S0", "p", "rootMsgId", "elemId", "", "extBufForUI", "J1", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgSeqCallback;", BdhLogUtil.LogTag.Tag_Conn, "cnt", "", "queryOrder", "T", "beginSeq", "endSeq", "W", "seqList", "result", "X", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "F0", "msgSeq", "V", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgsReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/IMsgsRspOperateCallback;", "Z", "U", "A0", "msgClientSeq", "msgTime", "M", "", "peerUid", "chatType", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgTypeFilter;", "typeFilters", "Y", WSPublicAccReport.SOP_NAME_FOCUS, "p1", ICustomDataEditor.STRING_ARRAY_PARAM_1, "lastMsg", "A1", "v1", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgAbstractsCallback;", "L", "guildId", "channelIds", "T0", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "getReq", "z0", "j", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetRecentUseEmojiListCallback;", "x0", "emojiId", "emojiType", "setEmoji", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetMsgEmojiLikesCallback;", "w1", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "taskType", "isGuest", "Lcom/tencent/qqnt/kernel/nativeinterface/AttaReportData;", "attaReportData", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetMsgEmojiLikesForRoleCallback;", "x1", "cookie", "bForward", "number", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgEmojiLikesListCallback;", "N", "msgEventInfo", ICustomDataEditor.NUMBER_PARAM_1, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "J0", "L0", "Lcom/tencent/qqnt/msg/data/c;", ReportConstant.COSTREPORT_PREFIX, "rootSeq", "E1", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetDraftOperateCallback;", "y0", "r", "Lcom/tencent/qqnt/kernel/nativeinterface/MatchKey;", "matchKey", "Lcom/tencent/qqnt/kernel/nativeinterface/IGuildMatchedOperateCallback;", "G0", "contact", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/LocalGrayTipElement;", "localGrayTipType", "needStore", "g", "Lcom/tencent/qqnt/kernel/nativeinterface/TofuRecordElement;", "tofuRecordElement", tl.h.F, QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "Lcom/tencent/qqnt/kernel/nativeinterface/IGuestGetMsgAbstractsCallback;", "E", "startSeq", "Lcom/tencent/qqnt/kernel/nativeinterface/IGuestMsgOperateCallback;", UserInfo.SEX_FEMALE, "businessType", QQBrowserActivity.KEY_MSG_TYPE, "msgSubType", "Y0", "I1", "F1", "k1", "scenes", "M0", "Lcom/tencent/qqnt/msg/data/e;", "O", "I", "P0", "Lcom/tencent/qqnt/msg/data/h;", "R0", "j1", "K0", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "b1", "c1", "d1", "Lcom/tencent/qqnt/msg/data/f;", "i1", "Lcom/tencent/qqnt/msg/data/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "K", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAioFirstViewLatestMsgCallback;", HippyTKDListViewAdapter.X, "sourceMsgSeq", "B0", "replyMsgId", "C0", "o1", "B", "o", "contacts", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgsBoxesCallback;", "w", "Lcom/tencent/qqnt/kernel/nativeinterface/ContactMsgBoxInfo;", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/SceneInfoParam;", "sceneInfo", "isLocal", "isDelete", ICustomDataEditor.STRING_PARAM_1, "needSummary", "t", "flag", "r1", "l1", "u1", "t1", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGuildBinaryDataCallback;", "H", "i", "srcContact", "dstContacts", "commentElements", "Lcom/tencent/qqnt/kernel/nativeinterface/IForwardOperateCallback;", "v", "Lcom/tencent/qqnt/kernel/nativeinterface/TargetFileInfo;", "fileInfo", "dstContact", "u", "Lcom/tencent/qqnt/msg/data/b;", "l", "map", "m1", "q1", "needFetch", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGuildGroupBubbleCallback;", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/CustomWithdrawConfig;", "V0", "Lcom/tencent/qqnt/kernel/nativeinterface/InputStatusInfo;", "h0", "eventType", "toUid", "e1", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryMsgsParams;", "params", "N0", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardClickInfo;", "inlineKeyboardClickInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IClickInlineKeyboardButtonCallback;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "groupId", "isAnonymousChat", "Lcom/tencent/qqnt/kernel/nativeinterface/ISwitchAnonymousChatCallback;", "H1", "Lcom/tencent/qqnt/kernel/nativeinterface/IRenameAnonymousChatNickCallback;", "Z0", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupAnonymousInfo;", "y", "W0", "X0", "w0", "D", "()Ljava/lang/Long;", "Lcom/tencent/qqnt/kernel/nativeinterface/FeedBackMsgInfo;", "msgInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/FeedBackDataForMsg;", "feedBackData", "I0", "richFlag", "B1", "", "Lkotlin/Function1;", "Ltencent/im/common/nt_msg_common$Msg;", "b", "Ljava/util/List;", "v0", "()Ljava/util/List;", "setReceiveSysMsgFlowListeners$msg_impl_release", "(Ljava/util/List;)V", "receiveSysMsgFlowListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "k0", "()Ljava/util/concurrent/ConcurrentHashMap;", "setOnLineDevListeners$msg_impl_release", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "onLineDevListeners", "Lcom/tencent/qqnt/kernel/nativeinterface/KickedInfo;", "d", "i0", "setOnKickedOffLineListeners$msg_impl_release", "onKickedOffLineListeners", "e", "o0", "setOnMsgSettingUpdateListeners$msg_impl_release", "onMsgSettingUpdateListeners", "f", "a0", "setOnAddSendMsgListeners$msg_impl_release", "onAddSendMsgListeners", "p0", "setOnReceiveMsgListeners$msg_impl_release", "onReceiveMsgListeners", "m0", "onMsgInfoListAddListeners", "l0", "setOnMsgDeleteListeners$msg_impl_release", "onMsgDeleteListeners", "b0", "setOnChannelFreqLimitInfoUpdateListeners$msg_impl_release", "onChannelFreqLimitInfoUpdateListeners", "e0", "setOnDraftUpdateListeners$msg_impl_release", "onDraftUpdateListeners", "s0", "setOnRichMediaUploadCompleteListeners$msg_impl_release", "onRichMediaUploadCompleteListeners", "q0", "setOnRichMediaDownloadCompleteListeners$msg_impl_release", "onRichMediaDownloadCompleteListeners", "r0", "setOnRichMediaDownloadProgresses$msg_impl_release", "onRichMediaDownloadProgresses", "t0", "setOnSendMsgErrorListeners$msg_impl_release", "onSendMsgErrorListeners", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "getOnUnreadCntInfoListeners$msg_impl_release", "setOnUnreadCntInfoListeners$msg_impl_release", "onUnreadCntInfoListeners", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupGuildNotifyInfo;", "g0", "setOnGroupGuildNotifyListeners$msg_impl_release", "onGroupGuildNotifyListeners", "Lcom/tencent/qqnt/msg/api/b;", "Lkotlin/Lazy;", BdhLogUtil.LogTag.Tag_Req, "()Ljava/util/ArrayList;", "msgStaticCallbackList", ExifInterface.LATITUDE_SOUTH, "msgSysMsgNotificationListeners", "n0", "onMsgInfoListUpdateListeners", "Lkotlin/jvm/functions/Function1;", "getMsgListCallback$msg_impl_release", "()Lkotlin/jvm/functions/Function1;", "y1", "(Lkotlin/jvm/functions/Function1;)V", "msgListCallback", "getOnMsgDelListener$msg_impl_release", Constants.BASE_IN_PLUGIN_ID, "onMsgDelListener", "c0", "setOnClearMsgRecordsListeners$msg_impl_release", "onClearMsgRecordsListeners", "onMsgBoxChangedListeners", "d0", "setOnCustomWithRawListeners$msg_impl_release", "onCustomWithRawListeners", "onInputStatusListeners", "f0", "setOnFileMsgComeListeners$msg_impl_release", "onFileMsgComeListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/ParameterName;", "name", QQPermissionConstants.Permission.AUIDO_GROUP, "Ljava/util/concurrent/CopyOnWriteArrayList;", "msgSecurityNotifyListeners", "<init>", "()V", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MsgService {
    static IPatchRedirector $redirector_;

    /* renamed from: A, reason: from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<List<? extends d>, Unit>> onFileMsgComeListeners;

    /* renamed from: B, reason: from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<Function1<d, Unit>> msgSecurityNotifyListeners;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MsgService f359521a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static List<Function1<nt_msg_common$Msg, Unit>> receiveSysMsgFlowListeners;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<ArrayList<DevInfo>, Unit>> onLineDevListeners;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<KickedInfo, Unit>> onKickedOffLineListeners;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<MsgSetting, Unit>> onMsgSettingUpdateListeners;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<d, Unit>> onAddSendMsgListeners;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<List<? extends d>, Unit>> onReceiveMsgListeners;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, Function1<ArrayList<d>, Unit>> onMsgInfoListAddListeners;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<ArrayList<Long>, Unit>> onMsgDeleteListeners;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<com.tencent.qqnt.msg.data.b, Unit>> onChannelFreqLimitInfoUpdateListeners;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<com.tencent.qqnt.msg.data.c, Unit>> onDraftUpdateListeners;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<FileTransNotifyInfo, Unit>> onRichMediaUploadCompleteListeners;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<FileTransNotifyInfo, Unit>> onRichMediaDownloadCompleteListeners;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<FileTransNotifyInfo, Unit>> onRichMediaDownloadProgresses;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<com.tencent.qqnt.msg.data.f, Unit>> onSendMsgErrorListeners;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<Map<Integer, UnreadCntInfo>, Unit>> onUnreadCntInfoListeners;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<GroupGuildNotifyInfo, Unit>> onGroupGuildNotifyListeners;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy msgStaticCallbackList;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, Function1<com.tencent.qqnt.msg.data.h, Unit>> msgSysMsgNotificationListeners;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, Function1<ArrayList<d>, Unit>> onMsgInfoListUpdateListeners;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Function1<? super com.tencent.qqnt.msg.data.e, Unit> msgListCallback;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Function1<? super com.tencent.qqnt.msg.data.d, Unit> onMsgDelListener;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<Contact, Unit>> onClearMsgRecordsListeners;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Function1<ArrayList<ContactMsgBoxInfo>, Unit>> onMsgBoxChangedListeners;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<CustomWithdrawConfig, Unit>> onCustomWithRawListeners;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, Function1<InputStatusInfo, Unit>> onInputStatusListeners;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/msg/MsgService$a", "Lcom/tencent/qqnt/kernel/invorker/b;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "a", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a extends com.tencent.qqnt.kernel.invorker.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.kernel.invorker.b
        public void a(@NotNull Contact peer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) peer);
                return;
            }
            Intrinsics.checkNotNullParameter(peer, "peer");
            Iterator<Map.Entry<Integer, Function1<Contact, Unit>>> it = MsgService.f359521a.c0().entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().invoke(peer);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000K\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J$\u0010\r\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016\u00a8\u0006\u001a"}, d2 = {"com/tencent/qqnt/msg/MsgService$b", "Lcom/tencent/qqnt/msg/b;", "Ljava/util/ArrayList;", "", "msgBuf", "", "onRecvS2CMsg", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "bFind", "Lcom/tencent/qqnt/kernel/nativeinterface/FreqLimitInfo;", "freqLimitInfo", "onChannelFreqLimitInfoUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/FirstViewGroupGuildInfo;", "firstViewGroupGuildInfos", "onFirstViewGroupGuildMapping", "", "flag", "onRecvUDCFlag", "onRecvGroupGuildFlag", "Lcom/tencent/qqnt/kernel/nativeinterface/GuildMsgAbFlag;", "onGuildMsgAbFlagChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupGuildNotifyInfo;", "notifyInfo", "onGroupGuildUpdate", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b extends com.tencent.qqnt.msg.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.msg.b, com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
        public void onChannelFreqLimitInfoUpdate(@Nullable Contact peer, boolean bFind, @Nullable FreqLimitInfo freqLimitInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, peer, Boolean.valueOf(bFind), freqLimitInfo);
                return;
            }
            super.onChannelFreqLimitInfoUpdate(peer, bFind, freqLimitInfo);
            if (freqLimitInfo != null) {
                Iterator<Function1<com.tencent.qqnt.msg.data.b, Unit>> it = MsgService.f359521a.b0().values().iterator();
                while (it.hasNext()) {
                    it.next().invoke(new com.tencent.qqnt.msg.data.b(peer, bFind, freqLimitInfo));
                }
            }
        }

        @Override // com.tencent.qqnt.msg.b, com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
        public void onFirstViewGroupGuildMapping(@Nullable ArrayList<FirstViewGroupGuildInfo> firstViewGroupGuildInfos) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) firstViewGroupGuildInfos);
            } else {
                if (firstViewGroupGuildInfos == null) {
                    return;
                }
                super.onFirstViewGroupGuildMapping(firstViewGroupGuildInfos);
                Iterator it = MsgService.f359521a.R().iterator();
                while (it.hasNext()) {
                    ((com.tencent.qqnt.msg.api.b) it.next()).onFirstViewGroupGuildMapping(firstViewGroupGuildInfos);
                }
            }
        }

        @Override // com.tencent.qqnt.msg.b, com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
        public void onGroupGuildUpdate(@Nullable GroupGuildNotifyInfo notifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) notifyInfo);
                return;
            }
            if (notifyInfo == null) {
                return;
            }
            super.onGroupGuildUpdate(notifyInfo);
            Iterator it = MsgService.f359521a.R().iterator();
            while (it.hasNext()) {
                ((com.tencent.qqnt.msg.api.b) it.next()).onGroupGuildUpdate(notifyInfo);
            }
            Iterator<Function1<GroupGuildNotifyInfo, Unit>> it5 = MsgService.f359521a.g0().values().iterator();
            while (it5.hasNext()) {
                it5.next().invoke(notifyInfo);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
        public void onGuildMsgAbFlagChanged(@NotNull GuildMsgAbFlag flag) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) flag);
                return;
            }
            Intrinsics.checkNotNullParameter(flag, "flag");
            Iterator it = MsgService.f359521a.R().iterator();
            while (it.hasNext()) {
                ((com.tencent.qqnt.msg.api.b) it.next()).onGuildMsgAbFlagChanged(flag);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
        public void onRecvGroupGuildFlag(int flag) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, flag);
                return;
            }
            Iterator it = MsgService.f359521a.R().iterator();
            while (it.hasNext()) {
                ((com.tencent.qqnt.msg.api.b) it.next()).onRecvGroupGuildFlag(flag);
            }
        }

        @Override // com.tencent.qqnt.msg.b, com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
        public void onRecvS2CMsg(@NotNull ArrayList<Byte> msgBuf) {
            byte[] byteArray;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgBuf);
                return;
            }
            Intrinsics.checkNotNullParameter(msgBuf, "msgBuf");
            super.onRecvS2CMsg(msgBuf);
            byteArray = CollectionsKt___CollectionsKt.toByteArray(msgBuf);
            Iterator it = MsgService.f359521a.R().iterator();
            while (it.hasNext()) {
                ((com.tencent.qqnt.msg.api.b) it.next()).b(byteArray);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
        public void onRecvUDCFlag(int flag) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, flag);
                return;
            }
            Iterator it = MsgService.f359521a.R().iterator();
            while (it.hasNext()) {
                ((com.tencent.qqnt.msg.api.b) it.next()).onRecvUDCFlag(flag);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u00ab\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0012\u001a\u00020\u00062\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0002j\b\u0012\u0004\u0012\u00020\u000e`\u0004H\u0016J$\u0010\u0015\u001a\u00020\u00062\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0004H\u0016JD\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001b2\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0004H\u0016J$\u0010\u001e\u001a\u00020\u00062\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u0004H\u0016J$\u0010\u001f\u001a\u00020\u00062\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u0004H\u0016J(\u0010#\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0002j\b\u0012\u0004\u0012\u00020\u0018`\u0004H\u0016J*\u0010'\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u00022\u0006\u0010&\u001a\u00020\u0018H\u0016J\u0012\u0010*\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010+\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010,\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J,\u00101\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010.\u001a\u00020\u00162\b\u00100\u001a\u0004\u0018\u00010/H\u0016J>\u00106\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00162\b\u00100\u001a\u0004\u0018\u00010/2\b\u00105\u001a\u0004\u0018\u000104H\u0016JX\u0010;\u001a\u00020\u00062N\u0010:\u001aJ\u0012\u0004\u0012\u00020\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020807\u0018\u000107j,\u0012\u0004\u0012\u00020\u0016\u0012 \u0012\u001e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020807j\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000208`9\u0018\u0001`9H\u0016J\u0018\u0010>\u001a\u00020\u00062\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u0002H\u0016J\u0018\u0010A\u001a\u00020\u00062\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010\u0002H\u0016J\u0012\u0010D\u001a\u00020\u00062\b\u0010C\u001a\u0004\u0018\u00010BH\u0016J\u0012\u0010G\u001a\u00020\u00062\b\u0010F\u001a\u0004\u0018\u00010EH\u0016J\u0018\u0010H\u001a\u00020\u00062\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0002H\u0016J\u0012\u0010J\u001a\u00020\u00062\b\u0010I\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006K"}, d2 = {"com/tencent/qqnt/msg/MsgService$c", "Lcom/tencent/qqnt/msg/i;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/DevInfo;", "Lkotlin/collections/ArrayList;", "devList", "", "onLineDev", "Lcom/tencent/qqnt/kernel/nativeinterface/KickedInfo;", "kickedInfo", "onKickedOffLine", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgSetting;", "msgSetting", "onMsgSettingUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "onAddSendMsg", TabPreloadItem.TAB_NAME_MESSAGE, "onRecvMsg", "", "msgBuf", "onRecvSysMsg", "", "businessType", "", QQBrowserActivity.KEY_MSG_TYPE, "msgSubType", "", TPReportKeys.Common.COMMON_ONLINE, "onSysMsgNotification", "onMsgInfoListAdd", "onMsgInfoListUpdate", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "msgIds", "onMsgDelete", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElements", "draftTime", "onDraftUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "onRichMediaUploadComplete", "onRichMediaDownloadComplete", "onRichMediaProgerssUpdate", "msgId", "errorCode", "", "errorMsg", "onSendMsgError", QCircleLpReportDc010001.KEY_SUBTYPE, "retCode", "", "transInfo", "onRecvMsgSvrRspTransInfo", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "Lkotlin/collections/HashMap;", "newUnreadCntInfos", "onContactUnreadCntUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/ContactMsgBoxInfo;", "contactMsgBoxInfos", "onMsgBoxChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/MiscData;", "dataList", "onMiscDataChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/CustomWithdrawConfig;", DownloadInfo.spKey_Config, "onCustomWithdrawConfigUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/InputStatusInfo;", "inputStatusInfo", "onInputStatusPush", "onFileMsgCome", "msg", "onMsgSecurityNotify", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c extends i {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onAddSendMsg(@NotNull MsgRecord msgRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgRecord);
                return;
            }
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            super.onAddSendMsg(msgRecord);
            long j3 = msgRecord.msgId;
            int hashCode = hashCode();
            MsgService msgService = MsgService.f359521a;
            QLog.i("IMsgListenerAdapter", 1, "[onAddSendMsg]: msgId=" + j3 + ", listener=" + hashCode + ", onAddSendMsgListener size=" + msgService.a0().size());
            Iterator<Function1<d, Unit>> it = msgService.a0().values().iterator();
            while (it.hasNext()) {
                it.next().invoke(j.INSTANCE.a(msgRecord));
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onContactUnreadCntUpdate(@Nullable HashMap<Integer, HashMap<String, UnreadCntInfo>> newUnreadCntInfos) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, (Object) this, (Object) newUnreadCntInfos);
                return;
            }
            super.onContactUnreadCntUpdate(newUnreadCntInfos);
            if (newUnreadCntInfos != null) {
                com.tencent.qqnt.msg.unread.b.f359711a.i(newUnreadCntInfos);
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onCustomWithdrawConfigUpdate(@Nullable CustomWithdrawConfig config) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                iPatchRedirector.redirect((short) 21, (Object) this, (Object) config);
                return;
            }
            super.onCustomWithdrawConfigUpdate(config);
            if (config != null) {
                for (Function1<CustomWithdrawConfig, Unit> function1 : MsgService.f359521a.d0().values()) {
                    QLog.d("IMsgListenerAdapter", 1, "onCustomWithdrawConfigUpdate listener invoke");
                    function1.invoke(config);
                }
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onDraftUpdate(@Nullable Contact peer, @Nullable ArrayList<MsgElement> msgElements, long draftTime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, this, peer, msgElements, Long.valueOf(draftTime));
                return;
            }
            super.onDraftUpdate(peer, msgElements, draftTime);
            if (peer != null) {
                Iterator<Function1<com.tencent.qqnt.msg.data.c, Unit>> it = MsgService.f359521a.e0().values().iterator();
                while (it.hasNext()) {
                    it.next().invoke(new com.tencent.qqnt.msg.data.c(peer, msgElements, draftTime));
                }
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onFileMsgCome(@Nullable ArrayList<MsgRecord> msgList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                iPatchRedirector.redirect((short) 23, (Object) this, (Object) msgList);
                return;
            }
            super.onFileMsgCome(msgList);
            if (msgList != null) {
                Iterator<Function1<List<? extends d>, Unit>> it = MsgService.f359521a.f0().values().iterator();
                while (it.hasNext()) {
                    it.next().invoke(m.b(msgList));
                }
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onInputStatusPush(@Nullable InputStatusInfo inputStatusInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                iPatchRedirector.redirect((short) 22, (Object) this, (Object) inputStatusInfo);
                return;
            }
            super.onInputStatusPush(inputStatusInfo);
            if (inputStatusInfo != null) {
                for (Function1 function1 : MsgService.onInputStatusListeners.values()) {
                    QLog.d("IMsgListenerAdapter", 1, "onInputStatusPush listener invoke");
                    function1.invoke(inputStatusInfo);
                }
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onKickedOffLine(@NotNull KickedInfo kickedInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) kickedInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(kickedInfo, "kickedInfo");
            super.onKickedOffLine(kickedInfo);
            Iterator<Function1<KickedInfo, Unit>> it = MsgService.f359521a.i0().values().iterator();
            while (it.hasNext()) {
                it.next().invoke(kickedInfo);
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onLineDev(@NotNull ArrayList<DevInfo> devList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) devList);
                return;
            }
            Intrinsics.checkNotNullParameter(devList, "devList");
            super.onLineDev(devList);
            Iterator<Function1<ArrayList<DevInfo>, Unit>> it = MsgService.f359521a.k0().values().iterator();
            while (it.hasNext()) {
                it.next().invoke(devList);
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onMiscDataChanged(@Nullable ArrayList<MiscData> dataList) {
            Object first;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                iPatchRedirector.redirect((short) 20, (Object) this, (Object) dataList);
                return;
            }
            super.onMiscDataChanged(dataList);
            boolean z16 = false;
            if (dataList != null && dataList.size() == 0) {
                z16 = true;
            }
            if (!z16 && dataList != null) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) dataList);
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onMsgBoxChanged(@Nullable ArrayList<ContactMsgBoxInfo> contactMsgBoxInfos) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this, (Object) contactMsgBoxInfos);
                return;
            }
            super.onMsgBoxChanged(contactMsgBoxInfos);
            if (contactMsgBoxInfos == null) {
                return;
            }
            Iterator it = MsgService.onMsgBoxChangedListeners.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(contactMsgBoxInfos);
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onMsgDelete(@NotNull Contact peer, @NotNull ArrayList<Long> msgIds) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) peer, (Object) msgIds);
                return;
            }
            Intrinsics.checkNotNullParameter(peer, "peer");
            Intrinsics.checkNotNullParameter(msgIds, "msgIds");
            super.onMsgDelete(peer, msgIds);
            Iterator<Function1<ArrayList<Long>, Unit>> it = MsgService.f359521a.l0().values().iterator();
            while (it.hasNext()) {
                it.next().invoke(msgIds);
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onMsgInfoListAdd(@Nullable ArrayList<MsgRecord> msgList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) msgList);
                return;
            }
            super.onMsgInfoListAdd(msgList);
            if (msgList != null) {
                Iterator<Function1<ArrayList<d>, Unit>> it = MsgService.f359521a.m0().values().iterator();
                while (it.hasNext()) {
                    it.next().invoke(m.b(msgList));
                }
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onMsgInfoListUpdate(@Nullable ArrayList<MsgRecord> msgList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) msgList);
                return;
            }
            super.onMsgInfoListUpdate(msgList);
            if (msgList != null) {
                Iterator<Function1<ArrayList<d>, Unit>> it = MsgService.f359521a.n0().values().iterator();
                while (it.hasNext()) {
                    it.next().invoke(m.b(msgList));
                }
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onMsgSecurityNotify(@Nullable MsgRecord msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                iPatchRedirector.redirect((short) 24, (Object) this, (Object) msg2);
                return;
            }
            super.onMsgSecurityNotify(msg2);
            for (Function1 function1 : MsgService.msgSecurityNotifyListeners) {
                if (msg2 != null) {
                    function1.invoke(m.c(msg2));
                }
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onMsgSettingUpdate(@NotNull MsgSetting msgSetting) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgSetting);
                return;
            }
            Intrinsics.checkNotNullParameter(msgSetting, "msgSetting");
            super.onMsgSettingUpdate(msgSetting);
            Iterator<Function1<MsgSetting, Unit>> it = MsgService.f359521a.o0().values().iterator();
            while (it.hasNext()) {
                it.next().invoke(msgSetting);
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRecvMsg(@NotNull ArrayList<MsgRecord> msgList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgList);
                return;
            }
            Intrinsics.checkNotNullParameter(msgList, "msgList");
            super.onRecvMsg(msgList);
            if (QLog.isDevelopLevel()) {
                for (MsgRecord msgRecord : msgList) {
                    if (msgRecord.chatType == 1) {
                        QLog.i("IMsgListenerAdapter", 4, "[onRecvMsg]: uid=" + msgRecord.peerUid + ", msgId=" + msgRecord.msgId);
                    }
                }
            }
            Iterator it = MsgService.f359521a.R().iterator();
            while (it.hasNext()) {
                ((com.tencent.qqnt.msg.api.b) it.next()).onRecvMsg(msgList);
            }
            Iterator<Function1<List<? extends d>, Unit>> it5 = MsgService.f359521a.p0().values().iterator();
            while (it5.hasNext()) {
                it5.next().invoke(m.b(msgList));
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRecvMsgSvrRspTransInfo(long msgId, @Nullable Contact peer, int subType, int retCode, @Nullable String errorMsg, @Nullable byte[] transInfo) {
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, this, Long.valueOf(msgId), peer, Integer.valueOf(subType), Integer.valueOf(retCode), errorMsg, transInfo);
                return;
            }
            Integer num2 = null;
            if (peer != null) {
                num = Integer.valueOf(peer.chatType);
            } else {
                num = null;
            }
            if (transInfo != null) {
                num2 = Integer.valueOf(transInfo.length);
            }
            QLog.d("IMsgListenerAdapter", 1, "msgService svr_trans_info onRecvMsgSvrRspTransInfo  msgId: " + msgId + "  chatType:" + num + " subType:" + subType + " retCode:" + retCode + " size:" + num2);
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRecvSysMsg(@Nullable ArrayList<Byte> msgBuf) {
            nt_msg_common$Msg c16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) msgBuf);
                return;
            }
            if (msgBuf != null && (c16 = MsgUtil.f359547a.c(msgBuf)) != null) {
                Iterator<T> it = MsgService.f359521a.v0().iterator();
                while (it.hasNext()) {
                    ((Function1) it.next()).invoke(c16);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("IMsgListenerAdapter", 2, "onRecvSysMsg");
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaDownloadComplete(@Nullable FileTransNotifyInfo notifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) notifyInfo);
                return;
            }
            super.onRichMediaDownloadComplete(notifyInfo);
            if (notifyInfo != null) {
                Iterator<Function1<FileTransNotifyInfo, Unit>> it = MsgService.f359521a.q0().values().iterator();
                while (it.hasNext()) {
                    it.next().invoke(notifyInfo);
                }
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaProgerssUpdate(@Nullable FileTransNotifyInfo notifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) notifyInfo);
                return;
            }
            super.onRichMediaProgerssUpdate(notifyInfo);
            if (notifyInfo != null) {
                Iterator<Function1<FileTransNotifyInfo, Unit>> it = MsgService.f359521a.r0().values().iterator();
                while (it.hasNext()) {
                    it.next().invoke(notifyInfo);
                }
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaUploadComplete(@Nullable FileTransNotifyInfo notifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) notifyInfo);
                return;
            }
            super.onRichMediaUploadComplete(notifyInfo);
            if (notifyInfo != null) {
                Iterator<Function1<FileTransNotifyInfo, Unit>> it = MsgService.f359521a.s0().values().iterator();
                while (it.hasNext()) {
                    it.next().invoke(notifyInfo);
                }
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onSendMsgError(long msgId, @Nullable Contact peer, int errorCode, @Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, this, Long.valueOf(msgId), peer, Integer.valueOf(errorCode), errorMsg);
                return;
            }
            super.onSendMsgError(msgId, peer, errorCode, errorMsg);
            Iterator<Function1<com.tencent.qqnt.msg.data.f, Unit>> it = MsgService.f359521a.t0().values().iterator();
            while (it.hasNext()) {
                it.next().invoke(new com.tencent.qqnt.msg.data.f(msgId, peer, errorCode, errorMsg));
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onSysMsgNotification(int businessType, long msgType, long msgSubType, boolean online, @Nullable ArrayList<Byte> msgBuf) {
            nt_msg_common$Msg nt_msg_common_msg;
            com.tencent.qqnt.msg.data.h hVar;
            nt_msg_common$Msg c16;
            nt_sys_msg_common$Msg nt_sys_msg_common_msg;
            nt_sys_msg_common$Msg b16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Integer.valueOf(businessType), Long.valueOf(msgType), Long.valueOf(msgSubType), Boolean.valueOf(online), msgBuf);
                return;
            }
            super.onSysMsgNotification(businessType, msgType, msgSubType, online, msgBuf);
            QLog.d("IMsgListenerAdapter", 2, "onSysMsgNotification, businessType=" + businessType + ", msgType=" + msgType + ", online=" + online + ", msgSubType=" + msgSubType);
            if (businessType == 0) {
                if (msgBuf != null && (b16 = MsgUtil.f359547a.b(msgBuf)) != null) {
                    nt_sys_msg_common_msg = b16;
                } else {
                    nt_sys_msg_common_msg = null;
                }
                hVar = new com.tencent.qqnt.msg.data.h(businessType, msgType, msgSubType, null, nt_sys_msg_common_msg);
            } else {
                if (msgBuf != null && (c16 = MsgUtil.f359547a.c(msgBuf)) != null) {
                    nt_msg_common_msg = c16;
                } else {
                    nt_msg_common_msg = null;
                }
                hVar = new com.tencent.qqnt.msg.data.h(businessType, msgType, msgSubType, nt_msg_common_msg, null);
            }
            Iterator it = MsgService.f359521a.R().iterator();
            while (it.hasNext()) {
                ((com.tencent.qqnt.msg.api.b) it.next()).a(hVar);
            }
            Iterator<Function1<com.tencent.qqnt.msg.data.h, Unit>> it5 = MsgService.f359521a.S().values().iterator();
            while (it5.hasNext()) {
                it5.next().invoke(hVar);
            }
        }
    }

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39594);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 159)) {
            redirector.redirect((short) 159);
            return;
        }
        f359521a = new MsgService();
        receiveSysMsgFlowListeners = new ArrayList();
        onLineDevListeners = new ConcurrentHashMap<>();
        onKickedOffLineListeners = new ConcurrentHashMap<>();
        onMsgSettingUpdateListeners = new ConcurrentHashMap<>();
        onAddSendMsgListeners = new ConcurrentHashMap<>();
        onReceiveMsgListeners = new ConcurrentHashMap<>();
        onMsgInfoListAddListeners = new ConcurrentHashMap<>();
        onMsgDeleteListeners = new ConcurrentHashMap<>();
        onChannelFreqLimitInfoUpdateListeners = new ConcurrentHashMap<>();
        onDraftUpdateListeners = new ConcurrentHashMap<>();
        onRichMediaUploadCompleteListeners = new ConcurrentHashMap<>();
        onRichMediaDownloadCompleteListeners = new ConcurrentHashMap<>();
        onRichMediaDownloadProgresses = new ConcurrentHashMap<>();
        onSendMsgErrorListeners = new ConcurrentHashMap<>();
        onUnreadCntInfoListeners = new ConcurrentHashMap<>();
        onGroupGuildNotifyListeners = new ConcurrentHashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(MsgService$msgStaticCallbackList$2.INSTANCE);
        msgStaticCallbackList = lazy;
        msgSysMsgNotificationListeners = new ConcurrentHashMap<>();
        onMsgInfoListUpdateListeners = new ConcurrentHashMap<>();
        onClearMsgRecordsListeners = new ConcurrentHashMap<>();
        List<Function1<ArrayList<ContactMsgBoxInfo>, Unit>> synchronizedList = Collections.synchronizedList(new ArrayList());
        Intrinsics.checkNotNullExpressionValue(synchronizedList, "synchronizedList(mutableListOf())");
        onMsgBoxChangedListeners = synchronizedList;
        onCustomWithRawListeners = new ConcurrentHashMap<>();
        onInputStatusListeners = new ConcurrentHashMap<>();
        onFileMsgComeListeners = new ConcurrentHashMap<>();
        msgSecurityNotifyListeners = new CopyOnWriteArrayList<>();
    }

    MsgService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Ref.ObjectRef msgListCallback2, int i3, int i16, String errMsg, ArrayList msgList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgListCallback2, "$msgListCallback");
        Function1 function1 = (Function1) msgListCallback2.element;
        if (function1 != null) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
            ArrayList<d> b16 = m.b(msgList);
            if (msgList.size() >= i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            function1.invoke(new com.tencent.qqnt.msg.data.e(i16, errMsg, b16, z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(int i3, int i16, String errMsg, ArrayList msgList) {
        boolean z16;
        Function1<? super com.tencent.qqnt.msg.data.e, Unit> function1 = msgListCallback;
        if (function1 != null) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
            ArrayList<d> b16 = m.b(msgList);
            if (msgList.size() >= i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            function1.invoke(new com.tencent.qqnt.msg.data.e(i16, errMsg, b16, z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<com.tencent.qqnt.msg.api.b> R() {
        return (ArrayList) msgStaticCallbackList.getValue();
    }

    public final void A(@Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            iPatchRedirector.redirect((short) 91, (Object) this, (Object) listener);
            return;
        }
        w e16 = f.e();
        if (e16 != null) {
            e16.getContactUnreadCnt(listener);
        }
    }

    public final void A0(@Nullable Contact peer, long msgSeq, @Nullable IMsgOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, this, peer, Long.valueOf(msgSeq), listener);
            return;
        }
        w e16 = f.e();
        if (e16 != null) {
            e16.getSingleMsg(peer, msgSeq, listener);
        }
    }

    public final void A1(@NotNull Contact peer, @NotNull MsgRecord lastMsg, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, this, peer, lastMsg, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(lastMsg, "lastMsg");
        w e16 = f.e();
        if (e16 != null) {
            e16.setMsgReadAndReport(peer, lastMsg, listener);
        }
    }

    public final void B(@NotNull Contact peer, @Nullable IGetDraftOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 127)) {
            iPatchRedirector.redirect((short) 127, (Object) this, (Object) peer, (Object) result);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        w e16 = f.e();
        if (e16 != null) {
            e16.getDraft(peer, result);
        }
    }

    public final void B0(@Nullable Contact peer, long msgId, long sourceMsgSeq, @Nullable IMsgOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 124)) {
            iPatchRedirector.redirect((short) 124, this, peer, Long.valueOf(msgId), Long.valueOf(sourceMsgSeq), cb5);
            return;
        }
        w e16 = f.e();
        if (e16 != null) {
            e16.getSourceOfReplyMsg(peer, msgId, sourceMsgSeq, cb5);
        }
    }

    public final void B1(boolean richFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 158)) {
            iPatchRedirector.redirect((short) 158, (Object) this, richFlag);
            return;
        }
        w e16 = f.e();
        if (e16 != null) {
            e16.setMsgRichInfoFlag(richFlag);
        }
    }

    public final void C(@NotNull Contact peer, @NotNull IGetMsgSeqCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this, (Object) peer, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(listener, "listener");
        w e16 = f.e();
        if (e16 != null) {
            e16.getFirstUnreadMsgSeq(peer, listener);
        }
    }

    public final void C0(@NotNull Contact peer, long rootMsgId, long replyMsgId, @NotNull IMsgOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 125)) {
            iPatchRedirector.redirect((short) 125, this, peer, Long.valueOf(rootMsgId), Long.valueOf(replyMsgId), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        w e16 = f.e();
        if (e16 != null) {
            e16.getSourceOfReplyMsgV2(peer, rootMsgId, replyMsgId, cb5);
        }
    }

    public final void C1(@NotNull MsgSetting msgSetting, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) msgSetting, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(msgSetting, "msgSetting");
        w e16 = f.e();
        if (e16 != null) {
            e16.setMsgSetting(msgSetting, listener);
        }
    }

    @Nullable
    public final Long D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 156)) {
            return (Long) iPatchRedirector.redirect((short) 156, (Object) this);
        }
        w e16 = f.e();
        if (e16 != null) {
            return e16.getGroupMsgStorageTime();
        }
        return null;
    }

    public final void D0(@Nullable t service) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) service);
        } else if (service != null) {
            service.q(new b());
        }
    }

    public final void D1(@Nullable Function1<? super com.tencent.qqnt.msg.data.d, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) function1);
        } else {
            onMsgDelListener = function1;
        }
    }

    public final void E(@NotNull String guildId, @NotNull ArrayList<String> channelIds, int random, @Nullable IGuestGetMsgAbstractsCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 104)) {
            iPatchRedirector.redirect((short) 104, this, guildId, channelIds, Integer.valueOf(random), result);
            return;
        }
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelIds, "channelIds");
        t d16 = f.d();
        if (d16 != null) {
            d16.getGuestMsgAbstracts(guildId, channelIds, random, result);
        }
    }

    public final void E0(@Nullable w service) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) service);
            return;
        }
        QLog.d("MsgService", 1, "init");
        c cVar = new c();
        QLog.i("MsgService", 1, "[addMsgListener]: listener=" + cVar.hashCode());
        if (service != null) {
            service.addMsgListener(cVar);
        }
        if (service != null) {
            service.m0(new a());
        }
    }

    public final void E1(@NotNull Contact peer, long rootSeq, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            iPatchRedirector.redirect((short) 98, this, peer, Long.valueOf(rootSeq), msgElements, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        w e16 = f.e();
        if (e16 != null) {
            e16.setReplyDraft(peer, rootSeq, msgElements, cb5);
        }
    }

    public final void F(@Nullable Contact peer, long startSeq, int cnt, boolean queryOrder, int random, @Nullable IGuestMsgOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            iPatchRedirector.redirect((short) 105, this, peer, Long.valueOf(startSeq), Integer.valueOf(cnt), Boolean.valueOf(queryOrder), Integer.valueOf(random), result);
            return;
        }
        t d16 = f.d();
        if (d16 != null) {
            d16.getGuestMsgByRange(peer, startSeq, cnt, queryOrder, random, result);
        }
    }

    public final void F0(@Nullable MsgRecord msg2, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, (Object) msg2, (Object) cb5);
            return;
        }
        t d16 = f.d();
        if (d16 != null) {
            d16.insertGameResultAsMsgToDb(msg2, cb5);
        }
    }

    public final void F1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
            iPatchRedirector.redirect((short) 108, (Object) this);
            return;
        }
        t d16 = f.d();
        if (d16 != null) {
            d16.startGuildMsgSync();
        }
    }

    public final void G(@NotNull Contact peer, boolean needFetch, @Nullable IGetGuildGroupBubbleCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 144)) {
            iPatchRedirector.redirect((short) 144, this, peer, Boolean.valueOf(needFetch), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        t d16 = f.d();
        if (d16 != null) {
            d16.getGuildGroupBubble(peer, needFetch, cb5);
        }
    }

    public final void G0(@Nullable MatchKey matchKey, @Nullable IGuildMatchedOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            iPatchRedirector.redirect((short) 101, (Object) this, (Object) matchKey, (Object) result);
            return;
        }
        t d16 = f.d();
        if (d16 != null) {
            d16.isGuildChannelSync(matchKey, result);
        }
    }

    public final void G1(@NotNull Contact peer, long msgId, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, this, peer, Long.valueOf(msgId), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        w e16 = f.e();
        if (e16 != null) {
            e16.stopGenerateMsg(peer, msgId, cb5);
        }
    }

    public final void H(@Nullable Contact peer, @Nullable IGetGuildBinaryDataCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 137)) {
            iPatchRedirector.redirect((short) 137, (Object) this, (Object) peer, (Object) cb5);
            return;
        }
        t d16 = f.d();
        if (d16 != null) {
            d16.getGuildGroupTransData(peer, cb5);
        }
    }

    public final void H0(@NotNull DevInfo devInfo, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) devInfo, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(devInfo, "devInfo");
        w e16 = f.e();
        if (e16 != null) {
            e16.kickOffLine(devInfo, listener);
        }
    }

    public final void H1(@Nullable String groupId, boolean isAnonymousChat, @Nullable ISwitchAnonymousChatCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 150)) {
            iPatchRedirector.redirect((short) 150, this, groupId, Boolean.valueOf(isAnonymousChat), cb5);
            return;
        }
        w e16 = f.e();
        if (e16 != null) {
            e16.switchAnonymousChat(groupId, isAnonymousChat, cb5);
        }
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<com.tencent.qqnt.msg.data.e> I(@NotNull Contact peer, final int cnt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 112)) {
            return (Flow) iPatchRedirector.redirect((short) 112, (Object) this, (Object) peer, cnt);
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        w e16 = f.e();
        if (e16 != null) {
            e16.getLatestDbMsgs(peer, cnt, new IMsgOperateCallback() { // from class: com.tencent.qqnt.msg.l
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    MsgService.J(Ref.ObjectRef.this, cnt, i3, str, arrayList);
                }
            });
        }
        return FlowKt.callbackFlow(new MsgService$getLatestDbMsgList$2(objectRef, null));
    }

    public final void I0(@NotNull Contact peer, @NotNull FeedBackMsgInfo msgInfo, @NotNull FeedBackDataForMsg feedBackData, @NotNull IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 157)) {
            iPatchRedirector.redirect((short) 157, this, peer, msgInfo, feedBackData, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        Intrinsics.checkNotNullParameter(feedBackData, "feedBackData");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        w e16 = f.e();
        if (e16 != null) {
            e16.likeOrDislikeReportForMsg(peer, msgInfo, feedBackData, cb5);
        }
    }

    public final void I1(int businessType, long msgType, @NotNull ArrayList<Long> msgSubType, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
            iPatchRedirector.redirect((short) 107, this, Integer.valueOf(businessType), Long.valueOf(msgType), msgSubType, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(msgSubType, "msgSubType");
        w e16 = f.e();
        if (e16 != null) {
            e16.unregisterSysMsgNotification(businessType, msgType, msgSubType, cb5);
        }
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<ArrayList<d>> J0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            return (Flow) iPatchRedirector.redirect((short) 95, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgService", 2, "msgInfoListAddNotificationFlow");
        }
        return FlowKt.callbackFlow(new MsgService$msgInfoListAddNotificationFlow$1(null));
    }

    public final void J1(@NotNull Contact peer, long rootMsgId, long elemId, @NotNull byte[] extBufForUI, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, this, peer, Long.valueOf(rootMsgId), Long.valueOf(elemId), extBufForUI, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(extBufForUI, "extBufForUI");
        w e16 = f.e();
        if (e16 != null) {
            e16.updateElementExtBufForUI(peer, rootMsgId, elemId, extBufForUI, cb5);
        }
    }

    public final void K(@NotNull Contact peer, int cnt, @NotNull IMsgOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 122)) {
            iPatchRedirector.redirect((short) 122, this, peer, Integer.valueOf(cnt), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        w e16 = f.e();
        if (e16 != null) {
            e16.getLatestDbMsgs(peer, cnt, cb5);
        }
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<ArrayList<d>> K0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 116)) {
            return (Flow) iPatchRedirector.redirect((short) 116, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgService", 2, "msgStatusUpdateNotificationFlow");
        }
        return FlowKt.callbackFlow(new MsgService$msgStatusUpdateNotificationFlow$1(null));
    }

    public final void L(@NotNull Contact peer, long msgId, @Nullable IGetMsgAbstractsCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, this, peer, Long.valueOf(msgId), listener);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        w e16 = f.e();
        if (e16 != null) {
            e16.getMsgAbstract(peer, msgId, listener);
        }
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<ArrayList<Long>> L0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            return (Flow) iPatchRedirector.redirect((short) 96, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgService", 2, "onMsgDeleteNotificationFlow");
        }
        return FlowKt.callbackFlow(new MsgService$onMsgDeleteNotificationFlow$1(null));
    }

    public final void M(@Nullable Contact peer, long msgClientSeq, long msgTime, @Nullable IMsgOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, this, peer, Long.valueOf(msgClientSeq), Long.valueOf(msgTime), listener);
            return;
        }
        w e16 = f.e();
        if (e16 != null) {
            e16.getMsgByClientSeqAndTime(peer, msgClientSeq, msgTime, listener);
        }
    }

    public final void M0(int scenes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 110)) {
            iPatchRedirector.redirect((short) 110, (Object) this, scenes);
            return;
        }
        t d16 = f.d();
        if (d16 != null) {
            d16.onScenesChangeForSilenceMode(scenes);
        }
    }

    public final void N(@Nullable Contact peer, long msgSeq, @Nullable String emojiId, long emojiType, @Nullable String cookie, boolean bForward, int number, @Nullable IGetMsgEmojiLikesListCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            iPatchRedirector.redirect((short) 89, this, peer, Long.valueOf(msgSeq), emojiId, Long.valueOf(emojiType), cookie, Boolean.valueOf(bForward), Integer.valueOf(number), cb5);
            return;
        }
        w e16 = f.e();
        if (e16 != null) {
            e16.getMsgEmojiLikesList(peer, msgSeq, emojiId, emojiType, cookie, bForward, number, cb5);
        }
    }

    public final void N0(long msgId, long msgTime, long msgSeq, @NotNull QueryMsgsParams params, @NotNull IMsgOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 148)) {
            iPatchRedirector.redirect((short) 148, this, Long.valueOf(msgId), Long.valueOf(msgTime), Long.valueOf(msgSeq), params, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        QLog.d("MsgService", 2, "queryMsgsWithFilterEx");
        w e16 = f.e();
        if (e16 != null) {
            e16.queryMsgsWithFilterEx(msgId, msgTime, msgSeq, params, cb5);
        }
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<com.tencent.qqnt.msg.data.e> O(@NotNull Contact peer, long msgId, final int cnt, boolean queryOrder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 111)) {
            return (Flow) iPatchRedirector.redirect((short) 111, this, peer, Long.valueOf(msgId), Integer.valueOf(cnt), Boolean.valueOf(queryOrder));
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        w e16 = f.e();
        if (e16 != null) {
            e16.getMsgs(peer, msgId, cnt, queryOrder, new IMsgOperateCallback() { // from class: com.tencent.qqnt.msg.k
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    MsgService.P(cnt, i3, str, arrayList);
                }
            });
        }
        return FlowKt.callbackFlow(new MsgService$getMsgList$2(null));
    }

    public final void O0(@NotNull Contact peer, long msgId, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, this, peer, Long.valueOf(msgId), listener);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        w e16 = f.e();
        if (e16 != null) {
            e16.recallMsg(peer, msgId, listener);
        }
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<Contact> P0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 113)) {
            return (Flow) iPatchRedirector.redirect((short) 113, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgService", 2, "receiveClearMsgRecordsFlow");
        }
        return FlowKt.callbackFlow(new MsgService$receiveClearMsgRecordsFlow$1(null));
    }

    public final void Q(@Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) listener);
            return;
        }
        w e16 = f.e();
        if (e16 != null) {
            e16.getMsgSetting(listener);
        }
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<List<d>> Q0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (Flow) iPatchRedirector.redirect((short) 53, (Object) this);
        }
        return FlowKt.callbackFlow(new MsgService$receiveMsgNotificationFlow$1(null));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<com.tencent.qqnt.msg.data.h> R0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 114)) {
            return (Flow) iPatchRedirector.redirect((short) 114, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgService", 2, "receiveMsgNotificationFlow");
        }
        return FlowKt.callbackFlow(new MsgService$receiveSysMsgNotificationFlow$1(null));
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<com.tencent.qqnt.msg.data.h, Unit>> S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return msgSysMsgNotificationListeners;
    }

    public final void S0(@Nullable Contact peer, long msgId, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, this, peer, Long.valueOf(msgId), cb5);
            return;
        }
        w e16 = f.e();
        if (e16 != null) {
            e16.reeditRecallMsg(peer, msgId, cb5);
        }
    }

    @Deprecated(message = "9.0.30\u5f00\u59cb\u5e9f\u5f03\uff0c\u7531getMsgsExt\u66ff\u4ee3", replaceWith = @ReplaceWith(expression = "getMsgsExt", imports = {}))
    public final void T(@NotNull Contact peer, long msgId, int cnt, boolean queryOrder, @NotNull IMsgOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, this, peer, Long.valueOf(msgId), Integer.valueOf(cnt), Boolean.valueOf(queryOrder), listener);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(listener, "listener");
        w e16 = f.e();
        if (e16 != null) {
            e16.getMsgs(peer, msgId, cnt, queryOrder, listener);
        }
    }

    public final void T0(@Nullable String guildId, @Nullable ArrayList<String> channelIds) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this, (Object) guildId, (Object) channelIds);
            return;
        }
        t d16 = f.d();
        if (d16 != null) {
            d16.refreshMsgAbstracts(guildId, channelIds);
        }
    }

    public final void U(@Nullable Contact peer, @Nullable ArrayList<Long> msgIds, @Nullable IMsgOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, this, peer, msgIds, listener);
            return;
        }
        w e16 = f.e();
        if (e16 != null) {
            e16.getMsgsByMsgId(peer, msgIds, listener);
        }
    }

    public final void U0(@NotNull Contact peer, long msgId, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, this, peer, Long.valueOf(msgId), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        w e16 = f.e();
        if (e16 != null) {
            e16.regenerateMsg(peer, msgId, cb5);
        }
    }

    @Deprecated(message = "9.0.30\u5f00\u59cb\u5e9f\u5f03\uff0c\u7531getMsgsExt\u66ff\u4ee3", replaceWith = @ReplaceWith(expression = "getMsgsExt", imports = {}))
    public final void V(@Nullable Contact peer, long msgSeq, int cnt, boolean queryOrder, @Nullable IMsgOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, this, peer, Long.valueOf(msgSeq), Integer.valueOf(cnt), Boolean.valueOf(queryOrder), listener);
            return;
        }
        w e16 = f.e();
        if (e16 != null) {
            e16.getMsgsBySeqAndCount(peer, msgSeq, cnt, queryOrder, listener);
        }
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<CustomWithdrawConfig> V0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 145)) {
            return (Flow) iPatchRedirector.redirect((short) 145, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgService", 2, "registerCustomWithdrawConfigUpdateFlow");
        }
        return FlowKt.callbackFlow(new MsgService$registerCustomWithdrawConfigUpdateFlow$1(null));
    }

    public final void W(@Nullable Contact peer, long beginSeq, long endSeq, @Nullable IMsgOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, this, peer, Long.valueOf(beginSeq), Long.valueOf(endSeq), listener);
            return;
        }
        t d16 = f.d();
        if (d16 != null) {
            d16.getMsgsBySeqRange(peer, beginSeq, endSeq, listener);
        }
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<List<d>> W0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 153)) {
            return (Flow) iPatchRedirector.redirect((short) 153, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgService", 2, "fileComeNotificationFlow");
        }
        return FlowKt.callbackFlow(new MsgService$registerFileComeNotificationFlow$1(null));
    }

    public final void X(@NotNull Contact peer, @NotNull List<Long> seqList, @Nullable IMsgOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, this, peer, seqList, result);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(seqList, "seqList");
        t d16 = f.d();
        if (d16 != null) {
            d16.getMsgsBySeqList(peer, new ArrayList<>(seqList), result);
        }
    }

    @NotNull
    public final Flow<d> X0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 154)) {
            return (Flow) iPatchRedirector.redirect((short) 154, (Object) this);
        }
        return FlowKt.callbackFlow(new MsgService$registerSecurityNotifyFlow$1(null));
    }

    public final void Y(@Nullable Contact peer, long msgId, int cnt, boolean queryOrder, @Nullable ArrayList<MsgTypeFilter> typeFilters, @Nullable IMsgOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, this, peer, Long.valueOf(msgId), Integer.valueOf(cnt), Boolean.valueOf(queryOrder), typeFilters, listener);
            return;
        }
        w e16 = f.e();
        if (e16 != null) {
            e16.getMsgsByTypeFilters(peer, msgId, cnt, queryOrder, typeFilters, listener);
        }
    }

    public final void Y0(int businessType, long msgType, @NotNull ArrayList<Long> msgSubType, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
            iPatchRedirector.redirect((short) 106, this, Integer.valueOf(businessType), Long.valueOf(msgType), msgSubType, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(msgSubType, "msgSubType");
        w e16 = f.e();
        if (e16 != null) {
            e16.registerSysMsgNotification(businessType, msgType, msgSubType, cb5);
        }
    }

    public final void Z(@NotNull MsgsReq req, @Nullable IMsgsRspOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, (Object) this, (Object) req, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        w e16 = f.e();
        if (e16 != null) {
            e16.getMsgsExt(req, cb5);
        }
    }

    public final void Z0(@Nullable String groupId, @Nullable IRenameAnonymousChatNickCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 151)) {
            iPatchRedirector.redirect((short) 151, (Object) this, (Object) groupId, (Object) cb5);
            return;
        }
        w e16 = f.e();
        if (e16 != null) {
            e16.renameAnonyChatNick(groupId, cb5);
        }
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<d, Unit>> a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return onAddSendMsgListeners;
    }

    public final void a1(@NotNull Contact peer, long msgId, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, this, peer, Long.valueOf(msgId), listener);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        w e16 = f.e();
        if (e16 != null) {
            e16.resendMsg(peer, msgId, listener);
        }
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<com.tencent.qqnt.msg.data.b, Unit>> b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return onChannelFreqLimitInfoUpdateListeners;
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<FileTransNotifyInfo> b1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 117)) {
            return (Flow) iPatchRedirector.redirect((short) 117, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgService", 2, "richMediaDownloadCompleteFlow");
        }
        return FlowKt.callbackFlow(new MsgService$richMediaDownloadCompleteFlow$1(null));
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<Contact, Unit>> c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 41, (Object) this);
        }
        return onClearMsgRecordsListeners;
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<FileTransNotifyInfo> c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 118)) {
            return (Flow) iPatchRedirector.redirect((short) 118, (Object) this);
        }
        return FlowKt.callbackFlow(new MsgService$richMediaDownloadProgressFlow$1(null));
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<CustomWithdrawConfig, Unit>> d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        return onCustomWithRawListeners;
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<FileTransNotifyInfo> d1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 119)) {
            return (Flow) iPatchRedirector.redirect((short) 119, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgService", 2, "richMediaDownloadCompleteFlow");
        }
        return FlowKt.callbackFlow(new MsgService$richMediaUploadCompleteFlow$1(null));
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<com.tencent.qqnt.msg.data.c, Unit>> e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return onDraftUpdateListeners;
    }

    public final void e1(int chatType, int eventType, @NotNull String toUid, @NotNull IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 147)) {
            iPatchRedirector.redirect((short) 147, this, Integer.valueOf(chatType), Integer.valueOf(eventType), toUid, result);
            return;
        }
        Intrinsics.checkNotNullParameter(toUid, "toUid");
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.d("MsgService", 2, "sendInputStatusReq");
        w e16 = f.e();
        if (e16 != null) {
            e16.sendShowInputStatusReq(chatType, eventType, toUid, result);
        }
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<List<? extends d>, Unit>> f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        return onFileMsgComeListeners;
    }

    public final void f1(@NotNull Contact peer, long msgId, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, this, peer, Long.valueOf(msgId), msgElements, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        w e16 = f.e();
        if (e16 != null) {
            e16.F(msgId, peer, msgElements, listener);
        }
    }

    public final void g(@NotNull Contact contact, @NotNull LocalGrayTipElement localGrayTipType, boolean needStore, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            iPatchRedirector.redirect((short) 102, this, contact, localGrayTipType, Boolean.valueOf(needStore), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(localGrayTipType, "localGrayTipType");
        w e16 = f.e();
        if (e16 != null) {
            e16.addLocalGrayTipMsg(contact, localGrayTipType, needStore, cb5);
        }
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<GroupGuildNotifyInfo, Unit>> g0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return onGroupGuildNotifyListeners;
    }

    public final void g1(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, peer, msgElements, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        w e16 = f.e();
        if (e16 != null) {
            e16.F(0L, peer, msgElements, listener);
        }
    }

    public final void h(@NotNull Contact contact, @NotNull TofuRecordElement tofuRecordElement, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            iPatchRedirector.redirect((short) 103, this, contact, tofuRecordElement, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(tofuRecordElement, "tofuRecordElement");
        w e16 = f.e();
        if (e16 != null) {
            e16.addLocalTofuRecordMsg(contact, tofuRecordElement, cb5);
        }
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<InputStatusInfo> h0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 146)) {
            return (Flow) iPatchRedirector.redirect((short) 146, (Object) this);
        }
        QLog.d("MsgService", 2, "getOnInputStatusPush");
        return FlowKt.callbackFlow(new MsgService$getOnInputStatusPush$1(null));
    }

    public final void h1(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements, @NotNull HashMap<Integer, MsgAttributeInfo> msgAttrs, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, this, peer, msgElements, msgAttrs, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        Intrinsics.checkNotNullParameter(msgAttrs, "msgAttrs");
        w e16 = f.e();
        if (e16 != null) {
            e16.sendMsg(0L, peer, msgElements, msgAttrs, listener);
        }
    }

    public final void i(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 138)) {
            iPatchRedirector.redirect((short) 138, (Object) this, (Object) peer, (Object) msgElements);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        w e16 = f.e();
        if (e16 != null) {
            Long j06 = e16.j0(peer.chatType);
            if (j06 != null) {
                j3 = j06.longValue();
            } else {
                j3 = 0;
            }
            e16.o0(j3, peer, msgElements);
        }
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<KickedInfo, Unit>> i0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return onKickedOffLineListeners;
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<com.tencent.qqnt.msg.data.f> i1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 120)) {
            return (Flow) iPatchRedirector.redirect((short) 120, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgService", 2, "sendMsgErrorNotificationFlow");
        }
        return FlowKt.callbackFlow(new MsgService$sendMsgErrorNotificationFlow$1(null));
    }

    public final void j(@NotNull RichMediaElementGetReq getReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, (Object) this, (Object) getReq);
            return;
        }
        Intrinsics.checkNotNullParameter(getReq, "getReq");
        w e16 = f.e();
        if (e16 != null) {
            e16.cancelGetRichMediaElement(getReq);
        }
    }

    public final void j0(@Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) listener);
            return;
        }
        w e16 = f.e();
        if (e16 != null) {
            e16.getOnLineDev(listener);
        }
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<d> j1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 115)) {
            return (Flow) iPatchRedirector.redirect((short) 115, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgService", 2, "sendMsgNotificationFlow");
        }
        return FlowKt.callbackFlow(new MsgService$sendMsgNotificationFlow$1(null));
    }

    public final void k(long msgId, @NotNull String peerUid, int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, this, Long.valueOf(msgId), peerUid, Integer.valueOf(chatType));
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        w e16 = f.e();
        if (e16 != null) {
            e16.cancelSendMsg(msgId, peerUid, chatType);
        }
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<ArrayList<DevInfo>, Unit>> k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return onLineDevListeners;
    }

    public final void k1(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 109)) {
            iPatchRedirector.redirect((short) 109, this, peer, msgElements, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        t d16 = f.d();
        if (d16 != null) {
            d16.sendSummonMsg(peer, msgElements, cb5);
        }
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<com.tencent.qqnt.msg.data.b> l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 141)) {
            return (Flow) iPatchRedirector.redirect((short) 141, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgService", 2, "channelFreqLimitInfoUpdateNotificationFlow");
        }
        return FlowKt.callbackFlow(new MsgService$channelFreqLimitInfoUpdateNotificationFlow$1(null));
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<ArrayList<Long>, Unit>> l0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return onMsgDeleteListeners;
    }

    public final void l1(int flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 134)) {
            iPatchRedirector.redirect((short) 134, (Object) this, flag);
            return;
        }
        t d16 = f.d();
        if (d16 != null) {
            d16.setBuildMode(flag);
        }
    }

    public final void m(@NotNull InlineKeyboardClickInfo inlineKeyboardClickInfo, @NotNull IClickInlineKeyboardButtonCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 149)) {
            iPatchRedirector.redirect((short) 149, (Object) this, (Object) inlineKeyboardClickInfo, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(inlineKeyboardClickInfo, "inlineKeyboardClickInfo");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        QLog.d("MsgService", 2, "clickInlineKeyboardButton");
        w e16 = f.e();
        if (e16 != null) {
            e16.clickInlineKeyboardButton(inlineKeyboardClickInfo, cb5);
        }
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<ArrayList<d>, Unit>> m0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return onMsgInfoListAddListeners;
    }

    public final void m1(@NotNull HashMap<Long, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 142)) {
            iPatchRedirector.redirect((short) 142, (Object) this, (Object) map);
            return;
        }
        Intrinsics.checkNotNullParameter(map, "map");
        t d16 = f.d();
        if (d16 != null) {
            d16.setConfigurationServiceData(map);
        }
    }

    @NotNull
    public final Flow<ArrayList<ContactMsgBoxInfo>> n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 130)) {
            return (Flow) iPatchRedirector.redirect((short) 130, (Object) this);
        }
        return FlowKt.callbackFlow(new MsgService$contactMsgBoxChangedFlow$1(null));
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<ArrayList<d>, Unit>> n0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return onMsgInfoListUpdateListeners;
    }

    public final void n1(@NotNull Contact peer, @NotNull HashMap<Long, byte[]> msgEventInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, (Object) this, (Object) peer, (Object) msgEventInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgEventInfo, "msgEventInfo");
        w e16 = f.e();
        if (e16 != null) {
            e16.setCurOnScreenMsgForMsgEvent(peer, msgEventInfo);
        }
    }

    public final void o(@NotNull Contact peer, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 128)) {
            iPatchRedirector.redirect((short) 128, (Object) this, (Object) peer, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        w e16 = f.e();
        if (e16 != null) {
            e16.deleteDraft(peer, cb5);
        }
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<MsgSetting, Unit>> o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return onMsgSettingUpdateListeners;
    }

    public final void o1(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 126)) {
            iPatchRedirector.redirect((short) 126, this, peer, msgElements, result);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        w e16 = f.e();
        if (e16 != null) {
            e16.setDraft(peer, msgElements, result);
        }
    }

    public final void p(@NotNull Contact peer, @Nullable ArrayList<Long> msgIds, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, this, peer, msgIds, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        w e16 = f.e();
        if (e16 != null) {
            e16.deleteMsg(peer, msgIds, listener);
        }
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<List<? extends d>, Unit>> p0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return onReceiveMsgListeners;
    }

    public final void p1(boolean focus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this, focus);
            return;
        }
        t d16 = f.d();
        if (d16 != null) {
            d16.setFocusOnGuild(focus);
        }
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<com.tencent.qqnt.msg.data.d> q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 121)) {
            return (Flow) iPatchRedirector.redirect((short) 121, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgService", 2, "deleteMsgNotificationFlow");
        }
        return FlowKt.callbackFlow(new MsgService$deleteMsgNotificationFlow$1(null));
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<FileTransNotifyInfo, Unit>> q0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return onRichMediaDownloadCompleteListeners;
    }

    public final void q1(@NotNull Contact peer, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 143)) {
            iPatchRedirector.redirect((short) 143, (Object) this, (Object) peer, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        t d16 = f.d();
        if (d16 != null) {
            d16.setGroupGuildBubbleRead(peer, cb5);
        }
    }

    public final void r(@NotNull Contact peer, long rootSeq, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            iPatchRedirector.redirect((short) 100, this, peer, Long.valueOf(rootSeq), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        w e16 = f.e();
        if (e16 != null) {
            e16.deleteReplyDraft(peer, rootSeq, cb5);
        }
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<FileTransNotifyInfo, Unit>> r0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return onRichMediaDownloadProgresses;
    }

    public final void r1(int flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 133)) {
            iPatchRedirector.redirect((short) 133, (Object) this, flag);
            return;
        }
        t d16 = f.d();
        if (d16 != null) {
            d16.setGroupGuildFlag(flag);
        }
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<com.tencent.qqnt.msg.data.c> s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            return (Flow) iPatchRedirector.redirect((short) 97, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgService", 2, "draftUpdateNotificationFlow");
        }
        return FlowKt.callbackFlow(new MsgService$draftUpdateNotificationFlow$1(null));
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<FileTransNotifyInfo, Unit>> s0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return onRichMediaUploadCompleteListeners;
    }

    public final void s1(@NotNull Contact peer, @NotNull ArrayList<SceneInfoParam> sceneInfo, boolean isLocal, boolean isDelete, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 131)) {
            iPatchRedirector.redirect((short) 131, this, peer, sceneInfo, Boolean.valueOf(isLocal), Boolean.valueOf(isDelete), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(sceneInfo, "sceneInfo");
        t d16 = f.d();
        if (d16 != null) {
            d16.setGroupGuildMsgRead(peer, sceneInfo, isLocal, isDelete, cb5);
        }
    }

    public final void t(@NotNull Contact peer, boolean needSummary, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 132)) {
            iPatchRedirector.redirect((short) 132, this, peer, Boolean.valueOf(needSummary), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        t d16 = f.d();
        if (d16 != null) {
            d16.fetchGroupGuildUnread(peer, needSummary, cb5);
        }
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<com.tencent.qqnt.msg.data.f, Unit>> t0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return onSendMsgErrorListeners;
    }

    public final void t1(int flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 136)) {
            iPatchRedirector.redirect((short) 136, (Object) this, flag);
            return;
        }
        t d16 = f.d();
        if (d16 != null) {
            d16.setGuildTabUserFlag(flag);
        }
    }

    public final void u(@NotNull TargetFileInfo fileInfo, @NotNull Contact dstContact, @NotNull IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 140)) {
            iPatchRedirector.redirect((short) 140, this, fileInfo, dstContact, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
        Intrinsics.checkNotNullParameter(dstContact, "dstContact");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        w e16 = f.e();
        if (e16 != null) {
            e16.forwardFile(fileInfo, dstContact, cb5);
        }
    }

    public final void u0(@Nullable Contact peer, @NotNull ArrayList<Long> msgIds, @Nullable IMsgOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, this, peer, msgIds, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(msgIds, "msgIds");
        w e16 = f.e();
        if (e16 != null) {
            e16.getRecallMsgsByMsgId(peer, msgIds, listener);
        }
    }

    public final void u1(int flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 135)) {
            iPatchRedirector.redirect((short) 135, (Object) this, flag);
            return;
        }
        t d16 = f.d();
        if (d16 != null) {
            d16.setGuildUDCFlag(flag);
        }
    }

    public final void v(@NotNull ArrayList<Long> msgIds, @NotNull Contact srcContact, @NotNull ArrayList<Contact> dstContacts, @Nullable ArrayList<MsgElement> commentElements, @NotNull IForwardOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 139)) {
            iPatchRedirector.redirect((short) 139, this, msgIds, srcContact, dstContacts, commentElements, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(msgIds, "msgIds");
        Intrinsics.checkNotNullParameter(srcContact, "srcContact");
        Intrinsics.checkNotNullParameter(dstContacts, "dstContacts");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        w e16 = f.e();
        if (e16 != null) {
            e16.forwardMsg(msgIds, srcContact, dstContacts, commentElements, cb5);
        }
    }

    @NotNull
    public final List<Function1<nt_msg_common$Msg, Unit>> v0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return receiveSysMsgFlowListeners;
    }

    public final void v1(@NotNull Contact peer, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, (Object) peer, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        w e16 = f.e();
        if (e16 != null) {
            e16.setLocalMsgRead(peer, listener);
        }
    }

    public final void w(@NotNull ArrayList<Contact> contacts, @NotNull IGetMsgsBoxesCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 129)) {
            iPatchRedirector.redirect((short) 129, (Object) this, (Object) contacts, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(contacts, "contacts");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        w e16 = f.e();
        if (e16 != null) {
            e16.getABatchOfContactMsgBoxInfo(contacts, cb5);
        }
    }

    public final void w0(int chatType, @Nullable IGetRecentUseEmojiListCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 155)) {
            iPatchRedirector.redirect((short) 155, (Object) this, chatType, (Object) cb5);
            return;
        }
        w e16 = f.e();
        if (e16 != null) {
            e16.getRecentEmojiList(chatType, cb5);
        }
    }

    public final void w1(@Nullable Contact peer, long msgSeq, @Nullable String emojiId, long emojiType, boolean setEmoji, @Nullable ISetMsgEmojiLikesCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, this, peer, Long.valueOf(msgSeq), emojiId, Long.valueOf(emojiType), Boolean.valueOf(setEmoji), cb5);
            return;
        }
        w e16 = f.e();
        if (e16 != null) {
            e16.setMsgEmojiLikes(peer, msgSeq, emojiId, emojiType, setEmoji, cb5);
        }
    }

    public final void x(@NotNull Contact peer, int cnt, @NotNull IGetAioFirstViewLatestMsgCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 123)) {
            iPatchRedirector.redirect((short) 123, this, peer, Integer.valueOf(cnt), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        w e16 = f.e();
        if (e16 != null) {
            e16.getAioFirstViewLatestMsgs(peer, cnt, cb5);
        }
    }

    public final void x0(@Nullable IGetRecentUseEmojiListCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, (Object) this, (Object) cb5);
            return;
        }
        w e16 = f.e();
        if (e16 != null) {
            e16.getRecentUseEmojiList(cb5);
        }
    }

    public final void x1(@Nullable Contact peer, long msgSeq, @Nullable String emojiId, long emojiType, long taskId, long taskType, boolean setEmoji, boolean isGuest, @NotNull AttaReportData attaReportData, @Nullable ISetMsgEmojiLikesForRoleCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, this, peer, Long.valueOf(msgSeq), emojiId, Long.valueOf(emojiType), Long.valueOf(taskId), Long.valueOf(taskType), Boolean.valueOf(setEmoji), Boolean.valueOf(isGuest), attaReportData, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(attaReportData, "attaReportData");
        w e16 = f.e();
        if (e16 != null) {
            e16.setMsgEmojiLikesForRole(peer, msgSeq, emojiId, emojiType, taskId, taskType, setEmoji, isGuest, attaReportData, cb5);
        }
    }

    @Nullable
    public final GroupAnonymousInfo y(@Nullable String groupId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 152)) {
            return (GroupAnonymousInfo) iPatchRedirector.redirect((short) 152, (Object) this, (Object) groupId);
        }
        w e16 = f.e();
        if (e16 != null) {
            return e16.getAnonymousInfo(groupId);
        }
        return null;
    }

    public final void y0(@NotNull Contact peer, long rootSeq, @Nullable IGetDraftOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            iPatchRedirector.redirect((short) 99, this, peer, Long.valueOf(rootSeq), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        w e16 = f.e();
        if (e16 != null) {
            e16.getReplyDraft(peer, rootSeq, cb5);
        }
    }

    public final void y1(@Nullable Function1<? super com.tencent.qqnt.msg.data.e, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) function1);
        } else {
            msgListCallback = function1;
        }
    }

    public final void z(@Nullable Contact peer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this, (Object) peer);
            return;
        }
        t d16 = f.d();
        if (d16 != null) {
            d16.getChannelFreqLimitInfo(peer);
        }
    }

    public final void z0(@NotNull RichMediaElementGetReq getReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, (Object) this, (Object) getReq);
            return;
        }
        Intrinsics.checkNotNullParameter(getReq, "getReq");
        w e16 = f.e();
        if (e16 != null) {
            e16.getRichMediaElement(getReq);
        }
    }

    public final void z1(@NotNull Contact peer, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, (Object) peer, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        w e16 = f.e();
        if (e16 != null) {
            e16.setMsgRead(peer, listener);
        }
    }
}

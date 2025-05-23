package com.tencent.qqnt.kernel.api;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qqnt.kernel.nativeinterface.AddLocalRecordMsgParams;
import com.tencent.qqnt.kernel.nativeinterface.AttaReportData;
import com.tencent.qqnt.kernel.nativeinterface.BackGroundInfo;
import com.tencent.qqnt.kernel.nativeinterface.DataMigrationMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.DataMigrationResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.DelMarketEmojiTabReq;
import com.tencent.qqnt.kernel.nativeinterface.DevInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicGetHotWordsReqBody;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicGetJumpInfoReqBody;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchReqBody;
import com.tencent.qqnt.kernel.nativeinterface.EnterOrExitAioInfo;
import com.tencent.qqnt.kernel.nativeinterface.FeedBackDataForMsg;
import com.tencent.qqnt.kernel.nativeinterface.FeedBackMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.FetchBottomEmojiTableListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetArgMsgConfigReqInfo;
import com.tencent.qqnt.kernel.nativeinterface.GetArkToMarkdownMsgTemplateReqInfo;
import com.tencent.qqnt.kernel.nativeinterface.GetMsgsAndStatusRecord;
import com.tencent.qqnt.kernel.nativeinterface.GroupAnonymousInfo;
import com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.ICanImportCallback;
import com.tencent.qqnt.kernel.nativeinterface.IClearMsgRecordsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IClickInlineKeyboardButtonCallback;
import com.tencent.qqnt.kernel.nativeinterface.IDataImportTableNamesCallback;
import com.tencent.qqnt.kernel.nativeinterface.IDataMigrationGetAvailableContactListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IDataMigrationGetMsgListCalback;
import com.tencent.qqnt.kernel.nativeinterface.IDelMarketEmojiTableCallback;
import com.tencent.qqnt.kernel.nativeinterface.IEmojiGetHotPicHotWordsResultCallback;
import com.tencent.qqnt.kernel.nativeinterface.IEmojiGetHotPicSearchResultCallback;
import com.tencent.qqnt.kernel.nativeinterface.IEmojiHotPicGetJumpInfoResultCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFetchBottomEmojiTableListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IForwardOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetAioFirstViewLatestMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetArkMsgConfigCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetArkToMarkdownMsgTemplateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetHotPicInfoListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetMarketEmoticonEncryptKeysCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetMiscDataCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgAbstractsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgEmojiLikesListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgSeqCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgWithStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgsBoxesCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetMultiMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetRecentUseEmojiListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IJoinDragonGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgImportToolListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.IModifyBottomEmojiTableSwitchStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMoveBottomEmojiTableCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgsRspOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateHiddenSessionCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQueryCalendarCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQueryFirstRoamMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQueryMsgsAndAbstractsWithFilterCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRenameAnonymousChatNickCallback;
import com.tencent.qqnt.kernel.nativeinterface.IReplyMsgWithSourceMsgInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetMsgEmojiLikesCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetMsgEmojiLikesForRoleCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISwitchAnonymousChatCallback;
import com.tencent.qqnt.kernel.nativeinterface.ITaskFinishCallback;
import com.tencent.qqnt.kernel.nativeinterface.ITempChatSigListener;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardClickInfo;
import com.tencent.qqnt.kernel.nativeinterface.JoinDragonGroupEmojiReq;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.LocalAVRecordElement;
import com.tencent.qqnt.kernel.nativeinterface.MiscData;
import com.tencent.qqnt.kernel.nativeinterface.MiscKeyInfo;
import com.tencent.qqnt.kernel.nativeinterface.ModifyBottomEmojiTableSwitchStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.MoveBottomEmojiTableReq;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.MsgTypeFilter;
import com.tencent.qqnt.kernel.nativeinterface.MsgsReq;
import com.tencent.qqnt.kernel.nativeinterface.MultiMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.PublicAccountInfo;
import com.tencent.qqnt.kernel.nativeinterface.QueryMsgsParams;
import com.tencent.qqnt.kernel.nativeinterface.RecentHiddenSesionInfo;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaFilePathInfo;
import com.tencent.qqnt.kernel.nativeinterface.SourceMsgInfoForReplyMsg;
import com.tencent.qqnt.kernel.nativeinterface.TargetFileInfo;
import com.tencent.qqnt.kernel.nativeinterface.TempChatPrepareInfo;
import com.tencent.qqnt.kernel.nativeinterface.TofuActionButton;
import com.tencent.qqnt.kernel.nativeinterface.TofuRecordElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.JsonGrayElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.LocalGrayTipElement;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00cc\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH&J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u001a\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J$\u0010\u001e\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u001a\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J:\u0010)\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001a2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J^\u0010/\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001a2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'2\"\u0010.\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*j\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,`-2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J0\u00100\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001a2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'H&J \u00104\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\rH&J\u0019\u00106\u001a\u0004\u0018\u00010#2\u0006\u00105\u001a\u00020+H&\u00a2\u0006\u0004\b6\u00107Jd\u0010>\u001a\u00020\u00042\u0016\u00108\u001a\u0012\u0012\u0004\u0012\u00020#0%j\b\u0012\u0004\u0012\u00020#`'2\u0006\u00109\u001a\u00020\u001a2\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u001a0%j\b\u0012\u0004\u0012\u00020\u001a`'2\u001a\u0010;\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010%j\n\u0012\u0004\u0012\u00020&\u0018\u0001`'2\u0006\u0010=\u001a\u00020<H&J|\u0010A\u001a\u00020\u00042\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020#0%j\b\u0012\u0004\u0012\u00020#`'2\u0016\u0010@\u001a\u0012\u0012\u0004\u0012\u00020#0%j\b\u0012\u0004\u0012\u00020#`'2\u0006\u00109\u001a\u00020\u001a2\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u001a0%j\b\u0012\u0004\u0012\u00020\u001a`'2\u001a\u0010;\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010%j\n\u0012\u0004\u0012\u00020&\u0018\u0001`'2\u0006\u0010=\u001a\u00020<H&J \u0010E\u001a\u00020\u00042\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020\rH&JT\u0010H\u001a\u00020\u00042\u0016\u0010G\u001a\u0012\u0012\u0004\u0012\u00020F0%j\b\u0012\u0004\u0012\u00020F`'2\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001a2\u001a\u0010;\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010%j\n\u0012\u0004\u0012\u00020&\u0018\u0001`'2\u0006\u0010=\u001a\u00020\rH&J(\u0010L\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010I\u001a\u00020#2\u0006\u0010J\u001a\u00020#2\u0006\u0010=\u001a\u00020KH&J\b\u0010M\u001a\u00020\u0004H&J4\u0010R\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010N\u001a\u00020#2\u0006\u0010O\u001a\u00020+2\u0006\u0010P\u001a\u00020\u001c2\b\u0010\u000e\u001a\u0004\u0018\u00010QH'JD\u0010U\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010N\u001a\u00020#2\u0006\u0010O\u001a\u00020+2\u0006\u0010P\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u001c2\b\u0010\u000e\u001a\u0004\u0018\u00010QH'J\u001a\u0010Y\u001a\u00020\u00042\u0006\u0010W\u001a\u00020V2\b\u0010=\u001a\u0004\u0018\u00010XH&J\u001c\u0010\\\u001a\u00020\u00042\b\u0010[\u001a\u0004\u0018\u00010Z2\b\u0010=\u001a\u0004\u0018\u00010\rH&J$\u0010`\u001a\u00020\u00042\u0006\u00105\u001a\u00020+2\b\u0010^\u001a\u0004\u0018\u00010]2\b\u0010=\u001a\u0004\u0018\u00010_H&J<\u0010a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u001e\u00108\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010%j\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u0001`'2\b\u0010\u000e\u001a\u0004\u0018\u00010QH&J,\u0010c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010$\u001a\u00020#2\u0006\u0010b\u001a\u00020#2\b\u0010=\u001a\u0004\u0018\u00010QH&J(\u0010e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010I\u001a\u00020#2\u0006\u0010d\u001a\u00020#2\u0006\u0010=\u001a\u00020QH&J$\u0010f\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010N\u001a\u00020#2\b\u0010=\u001a\u0004\u0018\u00010QH&J,\u0010i\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010g\u001a\u00020#2\u0006\u0010h\u001a\u00020#2\b\u0010=\u001a\u0004\u0018\u00010QH&JP\u0010l\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010$\u001a\u00020#2\u0006\u0010O\u001a\u00020+2\u0006\u0010P\u001a\u00020\u001c2\u001a\u0010k\u001a\u0016\u0012\u0004\u0012\u00020j\u0018\u00010%j\n\u0012\u0004\u0012\u00020j\u0018\u0001`'2\b\u0010=\u001a\u0004\u0018\u00010QH&J \u0010m\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010^\u001a\u00020]2\u0006\u00105\u001a\u00020+H&J\"\u0010n\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J$\u0010o\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010$\u001a\u00020#2\b\u0010=\u001a\u0004\u0018\u00010\rH&J\u0018\u0010s\u001a\u00020\u00042\u0006\u0010q\u001a\u00020p2\u0006\u0010=\u001a\u00020rH&J(\u0010v\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#2\u0006\u0010u\u001a\u00020t2\u0006\u0010=\u001a\u00020\rH&J\"\u0010w\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#2\b\u0010=\u001a\u0004\u0018\u00010\rH&J\"\u0010x\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#2\b\u0010=\u001a\u0004\u0018\u00010\rH&J\"\u0010y\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#2\b\u0010=\u001a\u0004\u0018\u00010\rH&J4\u0010z\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0016\u00108\u001a\u0012\u0012\u0004\u0012\u00020#0%j\b\u0012\u0004\u0012\u00020#`'2\b\u0010\u0003\u001a\u0004\u0018\u00010QH&J6\u0010{\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u001a\u00108\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010%j\n\u0012\u0004\u0012\u00020#\u0018\u0001`'2\b\u0010=\u001a\u0004\u0018\u00010\rH&J2\u0010~\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010I\u001a\u00020#2\u0006\u0010|\u001a\u00020#2\u0006\u0010}\u001a\u00020\u00172\b\u0010=\u001a\u0004\u0018\u00010\rH&J+\u0010\u0080\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u007f\u001a\u00020\u00172\b\u0010=\u001a\u0004\u0018\u00010\rH&J\u0011\u0010\u0081\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH&J\u0013\u0010\u0084\u0001\u001a\u00020\u00042\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001H&J\u0013\u0010\u0085\u0001\u001a\u00020\u00042\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001H&J\u0015\u0010\u0088\u0001\u001a\u0004\u0018\u00010]2\b\u0010\u0087\u0001\u001a\u00030\u0086\u0001H&J\u0015\u0010\u0089\u0001\u001a\u0004\u0018\u00010]2\b\u0010\u0087\u0001\u001a\u00030\u0086\u0001H&J\u0015\u0010\u008a\u0001\u001a\u0004\u0018\u00010]2\b\u0010\u0087\u0001\u001a\u00030\u0086\u0001H&J*\u0010\u008c\u0001\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001a2\u0007\u0010\u008b\u0001\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020\rH&J*\u0010\u008d\u0001\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001a2\u0007\u0010\u008b\u0001\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020\rH&J?\u0010\u0094\u0001\u001a\u00020\u00042\u0007\u0010\u008e\u0001\u001a\u00020]2\u0007\u0010\u008f\u0001\u001a\u00020]2\u0007\u0010\u0090\u0001\u001a\u00020+2\u0007\u0010\u0091\u0001\u001a\u00020+2\u0007\u0010\u0092\u0001\u001a\u00020\u001c2\u0007\u0010=\u001a\u00030\u0093\u0001H&J\u001c\u0010\u0098\u0001\u001a\u00020\u00042\b\u0010\u0096\u0001\u001a\u00030\u0095\u00012\u0007\u0010=\u001a\u00030\u0097\u0001H&J\u001c\u0010\u009b\u0001\u001a\u00020\u00042\b\u0010\u0096\u0001\u001a\u00030\u0099\u00012\u0007\u0010=\u001a\u00030\u009a\u0001H&J \u0010\u009e\u0001\u001a\u00020\u00042\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u009c\u00012\t\u0010=\u001a\u0005\u0018\u00010\u009d\u0001H&J\u001b\u0010\u00a1\u0001\u001a\u00020\u00042\u0007\u0010W\u001a\u00030\u009f\u00012\u0007\u0010=\u001a\u00030\u00a0\u0001H&J\u001b\u0010\u00a2\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u0013\u0010\u00a3\u0001\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J%\u0010\u00a6\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u00a5\u0001\u001a\u00030\u00a4\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J#\u0010\u00a7\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u001b\u0010\u00a8\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH&J$\u0010\u00aa\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#2\t\u0010=\u001a\u0005\u0018\u00010\u00a9\u0001H&J\u001c\u0010\u00ac\u0001\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0007\u0010\u00ab\u0001\u001a\u00020\u001cH&J!\u0010\u00ad\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020+2\u0006\u0010=\u001a\u00020QH&J*\u0010\u00af\u0001\u001a\u00020\u00042\u0017\u0010\u00ae\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001a0%j\b\u0012\u0004\u0012\u00020\u001a`'2\u0006\u0010=\u001a\u00020QH&J\"\u0010\u00b1\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020+2\u0007\u0010=\u001a\u00030\u00b0\u0001H&J1\u0010\u00b2\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#2\u0006\u0010O\u001a\u00020+2\u0006\u0010P\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020QH'J1\u0010\u00b3\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#2\u0006\u0010O\u001a\u00020+2\u0006\u0010P\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020QH'J \u0010\u00b7\u0001\u001a\u00020\u00042\n\u0010\u00b5\u0001\u001a\u0005\u0018\u00010\u00b4\u00012\t\u0010=\u001a\u0005\u0018\u00010\u00b6\u0001H&J\u0013\u0010\u00b8\u0001\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J,\u0010\u00b8\u0001\u001a\u00020\u00042\u0017\u0010\u00b9\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001a0%j\b\u0012\u0004\u0012\u00020\u001a`'2\b\u0010=\u001a\u0004\u0018\u00010\rH&J)\u0010\u00ba\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#2\u0006\u0010|\u001a\u00020#2\u0006\u0010=\u001a\u00020\rH&J\u001b\u0010\u00bd\u0001\u001a\u00020\u00042\u0007\u0010W\u001a\u00030\u00bb\u00012\u0007\u00103\u001a\u00030\u00bc\u0001H&J\u001c\u0010\u00c1\u0001\u001a\u00020\u00042\b\u0010\u00bf\u0001\u001a\u00030\u00be\u00012\u0007\u00103\u001a\u00030\u00c0\u0001H&J\u001a\u0010\u00c3\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0007\u0010=\u001a\u00030\u00c2\u0001H&J#\u0010\u00c6\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0007\u0010\u00c4\u0001\u001a\u00020#2\u0007\u0010=\u001a\u00030\u00c5\u0001H&JL\u0010\u00ca\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010h\u001a\u00020#2\u0007\u0010\u00c7\u0001\u001a\u00020#2\u0006\u0010O\u001a\u00020+2\u0007\u0010\u00c8\u0001\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020\u001c2\u0007\u0010\u00c9\u0001\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020QH'J\u0014\u0010\u00cc\u0001\u001a\u00020\u00042\t\u0010=\u001a\u0005\u0018\u00010\u00cb\u0001H&JC\u0010\u00d1\u0001\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010N\u001a\u00020#2\t\u0010\u00cd\u0001\u001a\u0004\u0018\u00010]2\u0007\u0010\u00ce\u0001\u001a\u00020#2\u0007\u0010\u00cf\u0001\u001a\u00020\u001c2\t\u0010=\u001a\u0005\u0018\u00010\u00d0\u0001H&Jh\u0010\u00d8\u0001\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010N\u001a\u00020#2\t\u0010\u00cd\u0001\u001a\u0004\u0018\u00010]2\u0007\u0010\u00ce\u0001\u001a\u00020#2\u0007\u0010\u00d2\u0001\u001a\u00020#2\u0007\u0010\u00d3\u0001\u001a\u00020#2\u0007\u0010\u00cf\u0001\u001a\u00020\u001c2\u0007\u0010\u00d4\u0001\u001a\u00020\u001c2\b\u0010\u00d6\u0001\u001a\u00030\u00d5\u00012\t\u0010=\u001a\u0005\u0018\u00010\u00d7\u0001H&JW\u0010\u00dd\u0001\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010N\u001a\u00020#2\t\u0010\u00cd\u0001\u001a\u0004\u0018\u00010]2\u0007\u0010\u00ce\u0001\u001a\u00020#2\t\u0010\u00d9\u0001\u001a\u0004\u0018\u00010]2\u0007\u0010\u00da\u0001\u001a\u00020\u001c2\u0007\u0010\u00db\u0001\u001a\u00020+2\t\u0010=\u001a\u0005\u0018\u00010\u00dc\u0001H&J6\u0010\u00df\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2#\u0010\u00de\u0001\u001a\u001e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00170*j\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0017`-H&J\u001a\u0010\u00e1\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0007\u0010=\u001a\u00030\u00e0\u0001H&J\u001b\u0010\u00e2\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010=\u001a\u0004\u0018\u00010\rH&J5\u0010\u00e3\u0001\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u001e\u0010\u00e5\u0001\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\t\u0010\u000e\u001a\u0005\u0018\u00010\u00e4\u0001H&J<\u0010\u00e7\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0007\u0010\u00e6\u0001\u001a\u00020#2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'2\b\u0010=\u001a\u0004\u0018\u00010\rH&J%\u0010\u00e8\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0007\u0010\u00e6\u0001\u001a\u00020#2\t\u0010=\u001a\u0005\u0018\u00010\u00e4\u0001H&J$\u0010\u00e9\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0007\u0010\u00e6\u0001\u001a\u00020#2\b\u0010=\u001a\u0004\u0018\u00010\rH&J/\u0010\u00ee\u0001\u001a\u00020\u00042\u0007\u0010\u00ea\u0001\u001a\u00020\u001a2\b\u0010\u00ec\u0001\u001a\u00030\u00eb\u00012\u0007\u0010\u00ed\u0001\u001a\u00020\u001c2\b\u0010=\u001a\u0004\u0018\u00010\rH&JL\u0010\u00f5\u0001\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u00f0\u0001\u001a\u00030\u00ef\u00012\f\b\u0002\u0010\u00f2\u0001\u001a\u0005\u0018\u00010\u00f1\u00012\t\b\u0002\u0010\u00ed\u0001\u001a\u00020\u001c2\t\b\u0002\u0010\u00f3\u0001\u001a\u00020\u001c2\u000b\b\u0002\u0010=\u001a\u0005\u0018\u00010\u00f4\u0001H&J&\u0010\u00f8\u0001\u001a\u00020\u00042\u0007\u0010\u00ea\u0001\u001a\u00020\u001a2\b\u0010\u00f7\u0001\u001a\u00030\u00f6\u00012\b\u0010=\u001a\u0004\u0018\u00010\rH&J7\u0010\u00fb\u0001\u001a\u00020\u00042\u0007\u0010\u00ea\u0001\u001a\u00020\u001a2\u0007\u0010\u00f9\u0001\u001a\u00020#2\u0007\u0010\u008b\u0001\u001a\u00020&2\u0007\u0010\u00fa\u0001\u001a\u00020\u001c2\b\u0010=\u001a\u0004\u0018\u00010\rH&J/\u0010\u00fe\u0001\u001a\u00020\u00042\u0007\u0010\u00ea\u0001\u001a\u00020\u001a2\u0007\u0010\u00f9\u0001\u001a\u00020#2\b\u0010\u00fd\u0001\u001a\u00030\u00fc\u00012\b\u0010=\u001a\u0004\u0018\u00010\rH&J>\u0010\u0081\u0002\u001a\u00020\u00042\u0007\u0010\u00ff\u0001\u001a\u00020+2\u0007\u0010\u00f9\u0001\u001a\u00020#2\u0017\u0010\u0080\u0002\u001a\u0012\u0012\u0004\u0012\u00020#0%j\b\u0012\u0004\u0012\u00020#`'2\b\u0010=\u001a\u0004\u0018\u00010\rH&J>\u0010\u0082\u0002\u001a\u00020\u00042\u0007\u0010\u00ff\u0001\u001a\u00020+2\u0007\u0010\u00f9\u0001\u001a\u00020#2\u0017\u0010\u0080\u0002\u001a\u0012\u0012\u0004\u0012\u00020#0%j\b\u0012\u0004\u0012\u00020#`'2\b\u0010=\u001a\u0004\u0018\u00010\rH&J\u001b\u0010\u0083\u0002\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J+\u0010\u0085\u0002\u001a\u00020\u00042\u0017\u0010\u00ae\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001a0%j\b\u0012\u0004\u0012\u00020\u001a`'2\u0007\u0010=\u001a\u00030\u0084\u0002H&J\u001d\u0010\u0088\u0002\u001a\u00020\u00042\u0007\u0010W\u001a\u00030\u0086\u00022\t\u0010=\u001a\u0005\u0018\u00010\u0087\u0002H&J\u001d\u0010\u008b\u0002\u001a\u00020\u00042\u0007\u0010W\u001a\u00030\u0089\u00022\t\u0010=\u001a\u0005\u0018\u00010\u008a\u0002H&J\u001d\u0010\u008e\u0002\u001a\u00020\u00042\u0007\u0010W\u001a\u00030\u008c\u00022\t\u0010=\u001a\u0005\u0018\u00010\u008d\u0002H&J\u001d\u0010\u0091\u0002\u001a\u00020\u00042\u0007\u0010W\u001a\u00030\u008f\u00022\t\u0010=\u001a\u0005\u0018\u00010\u0090\u0002H&J\u001c\u0010\u0093\u0002\u001a\u00020\u00042\u0007\u0010\u0092\u0002\u001a\u00020+2\b\u0010=\u001a\u0004\u0018\u00010\rH&J0\u0010\u0096\u0002\u001a\u00020\u00042\u0007\u0010\u0092\u0002\u001a\u00020+2\u0011\u0010\u0094\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010]\u0018\u00010%2\t\u0010=\u001a\u0005\u0018\u00010\u0095\u0002H&J\t\u0010\u0097\u0002\u001a\u00020\u001cH&J\t\u0010\u0098\u0002\u001a\u00020\u001cH&J/\u0010\u009b\u0002\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010h\u001a\u00020#2\n\u0010\u009a\u0002\u001a\u0005\u0018\u00010\u0099\u00022\b\u0010=\u001a\u0004\u0018\u00010QH&J3\u0010\u009c\u0002\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010h\u001a\u00020#2\u0006\u0010N\u001a\u00020#2\b\u0010\u009a\u0002\u001a\u00030\u0099\u00022\u0006\u0010=\u001a\u00020QH&J3\u0010\u009d\u0002\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010h\u001a\u00020#2\u0006\u0010N\u001a\u00020#2\b\u0010\u009a\u0002\u001a\u00030\u0099\u00022\u0006\u0010=\u001a\u00020QH&J3\u0010\u009e\u0002\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010h\u001a\u00020#2\u0006\u0010N\u001a\u00020#2\b\u0010\u009a\u0002\u001a\u00030\u0099\u00022\u0006\u0010=\u001a\u00020QH&J3\u0010\u009f\u0002\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010h\u001a\u00020#2\u0006\u0010N\u001a\u00020#2\b\u0010\u009a\u0002\u001a\u00030\u0099\u00022\u0006\u0010=\u001a\u00020QH&J3\u0010\u00a0\u0002\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010h\u001a\u00020#2\u0006\u0010N\u001a\u00020#2\b\u0010\u009a\u0002\u001a\u00030\u0099\u00022\u0006\u0010=\u001a\u00020QH&J'\u0010\u00a3\u0002\u001a\u00020\u00042\u0012\u0010\u00a2\u0002\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010\u00a1\u0002\u0018\u00010%2\b\u0010=\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u00a5\u0002\u001a\u00020\u00042\u0007\u0010\u00a4\u0002\u001a\u00020\u001cH&J\u0013\u0010\u00a6\u0002\u001a\u00020\u00042\b\u0010=\u001a\u0004\u0018\u00010\rH&J\t\u0010\u00a7\u0002\u001a\u00020\u0004H&J\u0014\u0010\u00a9\u0002\u001a\u00020\u00042\t\u0010=\u001a\u0005\u0018\u00010\u00a8\u0002H&J\u0013\u0010\u00aa\u0002\u001a\u00020\u00042\b\u0010=\u001a\u0004\u0018\u00010\rH&J\u0014\u0010\u00ac\u0002\u001a\u00020\u00042\t\u0010=\u001a\u0005\u0018\u00010\u00ab\u0002H&J'\u0010\u00af\u0002\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0007\u0010\u00ad\u0002\u001a\u00020#2\t\u0010=\u001a\u0005\u0018\u00010\u00ae\u0002H&J-\u0010\u00b2\u0002\u001a\u00020\u00042\u0006\u00105\u001a\u00020+2\u0007\u0010\u00b0\u0002\u001a\u00020+2\u0007\u0010\u00b1\u0002\u001a\u00020]2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J(\u0010\u00b6\u0002\u001a\u00020\u00042\t\u0010\u00b3\u0002\u001a\u0004\u0018\u00010]2\u0007\u0010\u00b4\u0002\u001a\u00020\u001c2\t\u0010=\u001a\u0005\u0018\u00010\u00b5\u0002H&J\u001f\u0010\u00b8\u0002\u001a\u00020\u00042\t\u0010\u00b3\u0002\u001a\u0004\u0018\u00010]2\t\u0010=\u001a\u0005\u0018\u00010\u00b7\u0002H&J\u0017\u0010\u00ba\u0002\u001a\u0005\u0018\u00010\u00b9\u00022\t\u0010\u00b3\u0002\u001a\u0004\u0018\u00010]H&J\u0014\u0010\u00bb\u0002\u001a\u0004\u0018\u00010+H&\u00a2\u0006\u0006\b\u00bb\u0002\u0010\u00bc\u0002J\t\u0010\u00bd\u0002\u001a\u00020\u0004H&J%\u0010\u00bf\u0002\u001a\u0004\u0018\u00010+2\u0007\u0010\u00be\u0002\u001a\u00020#2\u0006\u00105\u001a\u00020+H&\u00a2\u0006\u0006\b\u00bf\u0002\u0010\u00c0\u0002J\u001c\u0010\u00c2\u0002\u001a\u00020\u00042\u0007\u0010\u00b3\u0002\u001a\u00020]2\b\u0010\u00c1\u0002\u001a\u00030\u00b9\u0002H&J\u001b\u0010\u00c5\u0002\u001a\u00020]2\u0007\u0010\u00c3\u0002\u001a\u00020#2\u0007\u0010\u00c4\u0002\u001a\u00020#H&J\u0014\u0010\u00c6\u0002\u001a\u00020\u00042\t\u0010=\u001a\u0005\u0018\u00010\u00a8\u0002H&J4\u0010\u00c8\u0002\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010h\u001a\u00020#2\u0006\u0010N\u001a\u00020#2\b\u0010\u009a\u0002\u001a\u00030\u0099\u00022\u0007\u0010=\u001a\u00030\u00c7\u0002H&J!\u0010\u00c9\u0002\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#2\u0006\u0010=\u001a\u00020\rH&J!\u0010\u00ca\u0002\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#2\u0006\u0010=\u001a\u00020\rH&J\u0014\u0010\u00cc\u0002\u001a\u00020\u00042\t\u00103\u001a\u0005\u0018\u00010\u00cb\u0002H&J.\u0010\u00cf\u0002\u001a\u00020\u00042\u0019\u0010\u00ce\u0002\u001a\u0014\u0012\u0005\u0012\u00030\u00cd\u00020%j\t\u0012\u0005\u0012\u00030\u00cd\u0002`'2\b\u00103\u001a\u0004\u0018\u00010\rH&J.\u0010\u00d0\u0002\u001a\u00020\u00042\u0019\u0010\u00ce\u0002\u001a\u0014\u0012\u0005\u0012\u00030\u00cd\u00020%j\t\u0012\u0005\u0012\u00030\u00cd\u0002`'2\b\u00103\u001a\u0004\u0018\u00010\rH&J\u0014\u0010\u00d1\u0002\u001a\u00020\u00042\t\u00103\u001a\u0005\u0018\u00010\u00cb\u0002H&J\u001f\u0010\u00d2\u0002\u001a\u00020\u00042\n\u0010\u00c1\u0002\u001a\u0005\u0018\u00010\u00cd\u00022\b\u00103\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u00d4\u0002\u001a\u00020\u00042\u0007\u0010=\u001a\u00030\u00d3\u0002H&J'\u0010\u00d6\u0002\u001a\u0004\u0018\u00010#2\b\u0010\u009a\u0002\u001a\u00030\u0099\u00022\u0007\u0010=\u001a\u00030\u00d5\u0002H&\u00a2\u0006\u0006\b\u00d6\u0002\u0010\u00d7\u0002JU\u0010\u00dd\u0002\u001a\u0004\u0018\u00010#2\u0019\u0010\u00d9\u0002\u001a\u0014\u0012\u0005\u0012\u00030\u00d8\u00020%j\t\u0012\u0005\u0012\u00030\u00d8\u0002`'2\u0019\u0010\u00db\u0002\u001a\u0014\u0012\u0005\u0012\u00030\u00da\u00020%j\t\u0012\u0005\u0012\u00030\u00da\u0002`'2\t\u0010=\u001a\u0005\u0018\u00010\u00dc\u0002H&\u00a2\u0006\u0006\b\u00dd\u0002\u0010\u00de\u0002J\u0015\u0010\u00df\u0002\u001a\u0004\u0018\u00010]2\b\u0010\u00c1\u0002\u001a\u00030\u00da\u0002H&J\"\u0010\u00e0\u0002\u001a\u00020\u00042\u0007\u0010\u00ea\u0001\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#2\u0006\u00103\u001a\u00020\rH&J\u0012\u0010\u00e2\u0002\u001a\u00020\u00042\u0007\u0010\u00e1\u0002\u001a\u00020\u001cH&J\u001d\u0010\u00e4\u0002\u001a\u00020\u00042\b\u0010\u00c1\u0002\u001a\u00030\u00e3\u00022\b\u0010=\u001a\u0004\u0018\u00010\rH&J\u001c\u0010\u00e5\u0002\u001a\u00020\u00042\u0006\u00105\u001a\u00020+2\t\u0010=\u001a\u0005\u0018\u00010\u00cb\u0001H&J-\u0010\u00ea\u0002\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u00e7\u0002\u001a\u00030\u00e6\u00022\b\u0010\u00e9\u0002\u001a\u00030\u00e8\u00022\u0006\u0010=\u001a\u00020\rH&J\u0014\u0010\u00eb\u0002\u001a\u0004\u0018\u00010#H&\u00a2\u0006\u0006\b\u00eb\u0002\u0010\u00ec\u0002J\u0012\u0010\u00ee\u0002\u001a\u00020\u00042\u0007\u0010\u00ed\u0002\u001a\u00020\u001cH&J-\u0010\u00ef\u0002\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u00e7\u0002\u001a\u00030\u00e6\u00022\b\u0010\u00e9\u0002\u001a\u00030\u00e8\u00022\u0006\u0010=\u001a\u00020\rH&J\u0019\u0010\u00f0\u0002\u001a\u00020\u00042\u0006\u00105\u001a\u00020+2\u0006\u0010=\u001a\u00020\rH&JZ\u0010\u00f6\u0002\u001a\u00020\u00042\b\u0010\u00f2\u0002\u001a\u00030\u00f1\u00022\u0017\u0010\u00f3\u0002\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'2#\u0010\u00f4\u0002\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*j\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,`-2\u0007\u0010=\u001a\u00030\u00f5\u0002H&J\u001f\u0010\u00f9\u0002\u001a\u00020\u00042\n\u0010\u00f8\u0002\u001a\u0005\u0018\u00010\u00f7\u00022\b\u0010=\u001a\u0004\u0018\u00010\rH&J\u001c\u0010\u00fd\u0002\u001a\u00020\u00042\b\u0010\u00fb\u0002\u001a\u00030\u00fa\u00022\u0007\u0010=\u001a\u00030\u00fc\u0002H&\u00a8\u0006\u00fe\u0002"}, d2 = {"Lcom/tencent/qqnt/kernel/api/w;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernel/invorker/b;", "listener", "", "m0", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "addMsgListener", "Lcom/tencent/qqnt/kernel/nativeinterface/ITempChatSigListener;", "addKernelTempChatSigListener", "removeMsgListener", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgImportToolListener;", "B", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "result", "getOnLineDev", "Lcom/tencent/qqnt/kernel/nativeinterface/DevInfo;", "devInfo", "kickOffLine", "switchForeGround", "Lcom/tencent/qqnt/kernel/nativeinterface/BackGroundInfo;", "backInfo", "switchBackGround", "", "tokenInfo", "setTokenForMqq", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "isTop", "setContactLocalTop", "getMsgSetting", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgSetting;", "msgSetting", "setMsgSetting", "", "msgId", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", UserInfo.SEX_FEMALE, "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "Lkotlin/collections/HashMap;", "msgAttrs", SmsPlugin.API_SEND_SMS, "o0", "Lcom/tencent/qqnt/kernel/nativeinterface/LocalAVRecordElement;", "localAVRecordElement", "callback", "addLocalAVRecordMsg", "chatType", "j0", "(I)Ljava/lang/Long;", "msgIds", "srcContact", "dstContacts", "commentElements", "Lcom/tencent/qqnt/kernel/nativeinterface/IForwardOperateCallback;", "cb", "forwardMsg", "rootMsgIds", "subMsgIds", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/TargetFileInfo;", "fileInfo", "dstContact", "forwardFile", "Lcom/tencent/qqnt/kernel/nativeinterface/MultiMsgInfo;", "msgInfos", "t0", "rootMsgId", "parentMsgId", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMultiMsgCallback;", "getMultiMsg", "startMsgSync", "msgSeq", "cnt", "queryOrder", "Lcom/tencent/qqnt/kernel/nativeinterface/IMsgOperateCallback;", "getMsgsBySeqAndCount", "callbackInMainThread", "includeDeleteMsg", "n0", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgsReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/IMsgsRspOperateCallback;", "getMsgsExt", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatPrepareInfo;", "preInfo", "prepareTempChat", "", "peerUid", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetTempChatInfoCallback;", "getTempChatInfo", "getMsgsByMsgId", "sourceMsgSeq", "getSourceOfReplyMsg", "replyMsgId", "getSourceOfReplyMsgV2", "getSingleMsg", "msgClientSeq", "msgTime", "getMsgByClientSeqAndTime", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgTypeFilter;", "typeFilters", "getMsgsByTypeFilters", "cancelSendMsg", "resendMsg", "reeditRecallMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardClickInfo;", "inlineKeyboardClickInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IClickInlineKeyboardButtonCallback;", "clickInlineKeyboardButton", "Lcom/tencent/qqnt/kernel/nativeinterface/TofuActionButton;", "button", "clickTofuActionButton", "stopGenerateMsg", "regenerateMsg", "recallMsg", "getRecallMsgsByMsgId", "deleteMsg", "elemId", "extBufForUI", "updateElementExtBufForUI", "extPbBufForUI", "updateMsgRecordExtPbBufForUI", "setFocusOnBase", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "getReq", "getRichMediaElement", "cancelGetRichMediaElement", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaFilePathInfo;", "richMediaFilePathInfo", "assembleMobileQQRichMediaFilePath", "getRichMediaFilePathForMobileQQSend", "getRichMediaFilePathForGuild", "msgElement", "translatePtt2Text", "translatePtt2TextAiVoice", "searchWord", "picId", "count", "direction", "isForceRefresh", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetHotPicInfoListCallback;", "getHotPicInfoListSearchString", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiHotPicSearchReqBody;", "reqBody", "Lcom/tencent/qqnt/kernel/nativeinterface/IEmojiGetHotPicSearchResultCallback;", "getHotPicSearchResult", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiHotPicGetHotWordsReqBody;", "Lcom/tencent/qqnt/kernel/nativeinterface/IEmojiGetHotPicHotWordsResultCallback;", "getHotPicHotWords", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiHotPicGetJumpInfoReqBody;", "Lcom/tencent/qqnt/kernel/nativeinterface/IEmojiHotPicGetJumpInfoResultCallback;", "getHotPicJumpInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/JoinDragonGroupEmojiReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IJoinDragonGroupCallback;", "i0", "setMsgRead", "setAllC2CAndGroupMsgRead", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "lastMsg", "setMsgReadAndReport", "setSpecificMsgReadAndReport", "setLocalMsgRead", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgAbstractsCallback;", "getMsgAbstract", "isMarkUnread", "setMarkUnreadFlag", "getLatestDbMsgs", "contacts", "getLastMessageList", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAioFirstViewLatestMsgCallback;", "getAioFirstViewLatestMsgs", "getMsgs", "getMsgsIncludeSelf", "Lcom/tencent/qqnt/kernel/nativeinterface/GetMsgsAndStatusRecord;", QQPermissionConstants.Permission.AUIDO_GROUP, "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgWithStatusCallback;", "getMsgsWithStatus", "getContactUnreadCnt", "peers", "j", "Lcom/tencent/qqnt/kernel/nativeinterface/GetArgMsgConfigReqInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetArkMsgConfigCallback;", "y", "Lcom/tencent/qqnt/kernel/nativeinterface/GetArkToMarkdownMsgTemplateReqInfo;", "reqInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetArkToMarkdownMsgTemplateCallback;", "k0", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgSeqCallback;", "getFirstUnreadMsgSeq", "time", "Lcom/tencent/qqnt/kernel/nativeinterface/IQueryFirstRoamMsgCallback;", "queryFirstRoamMsg", "clientSeq", "needIncludeSelf", "incloudeDeleteMsg", "getMsgsWithMsgTimeAndClientSeqForC2C", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetRecentUseEmojiListCallback;", "getRecentUseEmojiList", "emojiId", "emojiType", "setEmoji", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetMsgEmojiLikesCallback;", "setMsgEmojiLikes", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "taskType", "isGuest", "Lcom/tencent/qqnt/kernel/nativeinterface/AttaReportData;", "attaReportData", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetMsgEmojiLikesForRoleCallback;", "setMsgEmojiLikesForRole", "cookie", "bForward", "number", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgEmojiLikesListCallback;", "getMsgEmojiLikesList", "msgEventInfo", "setCurOnScreenMsgForMsgEvent", "Lcom/tencent/qqnt/kernel/nativeinterface/IClearMsgRecordsCallback;", "clearMsgRecords", "O", "setDraft", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetDraftOperateCallback;", "getDraft", "rootSeq", "setReplyDraft", "getReplyDraft", "deleteReplyDraft", "contact", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/LocalGrayTipElement;", "localGrayTipType", "needStore", "addLocalGrayTipMsg", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/JsonGrayElement;", "jsonGrayTipElement", "Lcom/tencent/qqnt/kernel/nativeinterface/JsonGrayMsgInfo;", "jsonGrayMsgInfo", "needRecentContact", "Lcom/tencent/qqnt/kernel/nativeinterface/IAddJsonGrayTipMsgCallback;", "y0", "Lcom/tencent/qqnt/kernel/nativeinterface/TofuRecordElement;", "tofuRecordElement", "addLocalTofuRecordMsg", QQBrowserActivity.KEY_MSG_TYPE, "front", "w", "Lcom/tencent/qqnt/kernel/nativeinterface/AddLocalRecordMsgParams;", "addLocalMsgParams", "b", "businessType", "msgSubType", "registerSysMsgNotification", "unregisterSysMsgNotification", "deleteDraft", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgsBoxesCallback;", "getABatchOfContactMsgBoxInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/DelMarketEmojiTabReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IDelMarketEmojiTableCallback;", "delMarketEmojiTab", "Lcom/tencent/qqnt/kernel/nativeinterface/FetchBottomEmojiTableListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IFetchBottomEmojiTableListCallback;", "fetchBottomEmojiTableList", "Lcom/tencent/qqnt/kernel/nativeinterface/MoveBottomEmojiTableReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IMoveBottomEmojiTableCallback;", "moveBottomEmojiTable", "Lcom/tencent/qqnt/kernel/nativeinterface/ModifyBottomEmojiTableSwitchStatusReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IModifyBottomEmojiTableSwitchStatusCallback;", "modifyBottomEmojiTableSwitchStatus", EmojiManagerServiceProxy.EPID, "fetchMarketEmotionJsonFile", "eIds", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMarketEmoticonEncryptKeysCallback;", "getMarketEmoticonEncryptKeys", "U", "J0", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryMsgsParams;", "params", "queryMsgsWithFilter", "queryMsgsWithFilterEx", "queryPicOrVideoMsgs", "queryEmoticonMsgs", "queryTroopEmoticonMsgs", "queryShortVideoMsgs", "Lcom/tencent/qqnt/kernel/nativeinterface/EnterOrExitAioInfo;", "infoList", "enterOrExitAio", "isPowerOn", "setPowerStatus", "importOldDbMsg", "stopImportOldDbMsgAndroid", "Lcom/tencent/qqnt/kernel/nativeinterface/ICanImportCallback;", "canImportOldDbMsg", "isMqqDataImportFinished", "Lcom/tencent/qqnt/kernel/nativeinterface/IDataImportTableNamesCallback;", "getMqqDataImportTableNames", "curDate", "Lcom/tencent/qqnt/kernel/nativeinterface/IQueryCalendarCallback;", "queryRoamCalendar", "eventType", "toUid", "sendShowInputStatusReq", "groupId", "isAnonymousChat", "Lcom/tencent/qqnt/kernel/nativeinterface/ISwitchAnonymousChatCallback;", "switchAnonymousChat", "Lcom/tencent/qqnt/kernel/nativeinterface/IRenameAnonymousChatNickCallback;", "renameAnonyChatNick", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupAnonymousInfo;", "getAnonymousInfo", "getDataImportUserLevel", "()Ljava/lang/Integer;", "importDataLineMsg", "uin", "getCurChatImportStatusByUin", "(JI)Ljava/lang/Integer;", "info", "updateAnonymousInfo", "selfTinyId", "peerTinyId", "createUidFromTinyId", "canProcessDataMigration", "Lcom/tencent/qqnt/kernel/nativeinterface/IQueryMsgsAndAbstractsWithFilterCallback;", "queryMsgsAndAbstractsWithFilter", "reqToOfflineSendMsg", "refuseReceiveOnlineFileMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateHiddenSessionCallback;", "getRecentHiddenSesionList", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentHiddenSesionInfo;", "infos", "setRecentHiddenSession", "delRecentHiddenSession", "getCurHiddenSession", "setCurHiddenSession", "Lcom/tencent/qqnt/kernel/nativeinterface/IDataMigrationGetAvailableContactListCallback;", "dataMigrationGetDataAvaiableContactList", "Lcom/tencent/qqnt/kernel/nativeinterface/IDataMigrationGetMsgListCalback;", "dataMigrationGetMsgList", "(Lcom/tencent/qqnt/kernel/nativeinterface/QueryMsgsParams;Lcom/tencent/qqnt/kernel/nativeinterface/IDataMigrationGetMsgListCalback;)Ljava/lang/Long;", "Lcom/tencent/qqnt/kernel/nativeinterface/DataMigrationMsgInfo;", "msgInfoList", "Lcom/tencent/qqnt/kernel/nativeinterface/DataMigrationResourceInfo;", "resourceInfoList", "Lcom/tencent/qqnt/kernel/nativeinterface/ITaskFinishCallback;", "dataMigrationImportMsgPbRecord", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/tencent/qqnt/kernel/nativeinterface/ITaskFinishCallback;)Ljava/lang/Long;", "dataMigrationGetResourceLocalDestinyPath", "o", "enable", "setSubscribeFolderUsingSmallRedPoint", "Lcom/tencent/qqnt/kernel/nativeinterface/PublicAccountInfo;", "updatePublicAccountInfo", "getRecentEmojiList", "Lcom/tencent/qqnt/kernel/nativeinterface/FeedBackMsgInfo;", "msgInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/FeedBackDataForMsg;", "feedBackData", "likeOrDislikeReportForMsg", "getGroupMsgStorageTime", "()Ljava/lang/Long;", "richFlag", "setMsgRichInfoFlag", "feedBackReportForMsg", "setMsgReadByChatType", "Lcom/tencent/qqnt/kernel/nativeinterface/SourceMsgInfoForReplyMsg;", "sourceMsgInfo", "replyElements", "msgAttributeInfos", "Lcom/tencent/qqnt/kernel/nativeinterface/IReplyMsgWithSourceMsgInfoCallback;", "replyMsgWithSourceMsgInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/MiscData;", "value", "setMiscDataVer2", "Lcom/tencent/qqnt/kernel/nativeinterface/MiscKeyInfo;", "keyInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMiscDataCallback;", "getMiscDataVer2", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface w extends j {
    void B(@NotNull IKernelMsgImportToolListener listener);

    void F(long msgId, @NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback result);

    boolean J0();

    void O(@NotNull Contact peer, @Nullable IOperateCallback cb5);

    boolean U();

    void addKernelTempChatSigListener(@NotNull ITempChatSigListener listener);

    void addLocalAVRecordMsg(@NotNull Contact peer, @NotNull LocalAVRecordElement localAVRecordElement, @NotNull IOperateCallback callback);

    void addLocalGrayTipMsg(@NotNull Contact contact, @NotNull LocalGrayTipElement localGrayTipType, boolean needStore, @Nullable IOperateCallback cb5);

    void addLocalTofuRecordMsg(@NotNull Contact contact, @NotNull TofuRecordElement tofuRecordElement, @Nullable IOperateCallback cb5);

    void addMsgListener(@NotNull IKernelMsgListener listener);

    @Nullable
    String assembleMobileQQRichMediaFilePath(@NotNull RichMediaFilePathInfo richMediaFilePathInfo);

    void b(@NotNull Contact contact, long msgType, @NotNull AddLocalRecordMsgParams addLocalMsgParams, @Nullable IOperateCallback cb5);

    void canImportOldDbMsg(@Nullable ICanImportCallback cb5);

    void canProcessDataMigration(@Nullable ICanImportCallback cb5);

    void cancelGetRichMediaElement(@NotNull RichMediaElementGetReq getReq);

    void cancelSendMsg(long msgId, @NotNull String peerUid, int chatType);

    void clearMsgRecords(@NotNull Contact peer, @NotNull IClearMsgRecordsCallback cb5);

    void clickInlineKeyboardButton(@NotNull InlineKeyboardClickInfo inlineKeyboardClickInfo, @NotNull IClickInlineKeyboardButtonCallback cb5);

    void clickTofuActionButton(@NotNull Contact peer, long msgId, @NotNull TofuActionButton button, @NotNull IOperateCallback cb5);

    @NotNull
    String createUidFromTinyId(long selfTinyId, long peerTinyId);

    void dataMigrationGetDataAvaiableContactList(@NotNull IDataMigrationGetAvailableContactListCallback cb5);

    @Nullable
    Long dataMigrationGetMsgList(@NotNull QueryMsgsParams params, @NotNull IDataMigrationGetMsgListCalback cb5);

    @Nullable
    String dataMigrationGetResourceLocalDestinyPath(@NotNull DataMigrationResourceInfo info);

    @Nullable
    Long dataMigrationImportMsgPbRecord(@NotNull ArrayList<DataMigrationMsgInfo> msgInfoList, @NotNull ArrayList<DataMigrationResourceInfo> resourceInfoList, @Nullable ITaskFinishCallback cb5);

    void delMarketEmojiTab(@NotNull DelMarketEmojiTabReq req, @Nullable IDelMarketEmojiTableCallback cb5);

    void delRecentHiddenSession(@NotNull ArrayList<RecentHiddenSesionInfo> infos, @Nullable IOperateCallback callback);

    void deleteDraft(@NotNull Contact peer, @Nullable IOperateCallback result);

    void deleteMsg(@NotNull Contact peer, @Nullable ArrayList<Long> msgIds, @Nullable IOperateCallback cb5);

    void deleteReplyDraft(@NotNull Contact peer, long rootSeq, @Nullable IOperateCallback cb5);

    void enterOrExitAio(@Nullable ArrayList<EnterOrExitAioInfo> infoList, @Nullable IOperateCallback cb5);

    void feedBackReportForMsg(@NotNull Contact peer, @NotNull FeedBackMsgInfo msgInfo, @NotNull FeedBackDataForMsg feedBackData, @NotNull IOperateCallback cb5);

    void fetchBottomEmojiTableList(@NotNull FetchBottomEmojiTableListReq req, @Nullable IFetchBottomEmojiTableListCallback cb5);

    void fetchMarketEmotionJsonFile(int epId, @Nullable IOperateCallback cb5);

    void forwardFile(@NotNull TargetFileInfo fileInfo, @NotNull Contact dstContact, @NotNull IOperateCallback cb5);

    void forwardMsg(@NotNull ArrayList<Long> msgIds, @NotNull Contact srcContact, @NotNull ArrayList<Contact> dstContacts, @Nullable ArrayList<MsgElement> commentElements, @NotNull IForwardOperateCallback cb5);

    void getABatchOfContactMsgBoxInfo(@NotNull ArrayList<Contact> contacts, @NotNull IGetMsgsBoxesCallback cb5);

    void getAioFirstViewLatestMsgs(@NotNull Contact peer, int cnt, @NotNull IGetAioFirstViewLatestMsgCallback cb5);

    @Nullable
    GroupAnonymousInfo getAnonymousInfo(@Nullable String groupId);

    void getContactUnreadCnt(@Nullable IOperateCallback result);

    void getContactUnreadCnt(@NotNull ArrayList<Contact> peers, @Nullable IOperateCallback cb5);

    @Nullable
    Integer getCurChatImportStatusByUin(long uin, int chatType);

    void getCurHiddenSession(@Nullable IOperateHiddenSessionCallback callback);

    @Nullable
    Integer getDataImportUserLevel();

    void getDraft(@Nullable Contact peer, @Nullable IGetDraftOperateCallback result);

    void getFirstUnreadMsgSeq(@NotNull Contact peer, @NotNull IGetMsgSeqCallback cb5);

    @Nullable
    Long getGroupMsgStorageTime();

    void getHotPicHotWords(@NotNull EmojiHotPicGetHotWordsReqBody reqBody, @NotNull IEmojiGetHotPicHotWordsResultCallback cb5);

    void getHotPicInfoListSearchString(@NotNull String searchWord, @NotNull String picId, int count, int direction, boolean isForceRefresh, @NotNull IGetHotPicInfoListCallback cb5);

    void getHotPicJumpInfo(@Nullable EmojiHotPicGetJumpInfoReqBody reqBody, @Nullable IEmojiHotPicGetJumpInfoResultCallback cb5);

    void getHotPicSearchResult(@NotNull EmojiHotPicSearchReqBody reqBody, @NotNull IEmojiGetHotPicSearchResultCallback cb5);

    void getLastMessageList(@NotNull ArrayList<Contact> contacts, @NotNull IMsgOperateCallback cb5);

    void getLatestDbMsgs(@NotNull Contact peer, int cnt, @NotNull IMsgOperateCallback cb5);

    void getMarketEmoticonEncryptKeys(int epId, @Nullable ArrayList<String> eIds, @Nullable IGetMarketEmoticonEncryptKeysCallback cb5);

    void getMiscDataVer2(@NotNull MiscKeyInfo keyInfo, @NotNull IGetMiscDataCallback cb5);

    void getMqqDataImportTableNames(@Nullable IDataImportTableNamesCallback cb5);

    void getMsgAbstract(@NotNull Contact peer, long msgId, @Nullable IGetMsgAbstractsCallback cb5);

    void getMsgByClientSeqAndTime(@Nullable Contact peer, long msgClientSeq, long msgTime, @Nullable IMsgOperateCallback cb5);

    void getMsgEmojiLikesList(@Nullable Contact peer, long msgSeq, @Nullable String emojiId, long emojiType, @Nullable String cookie, boolean bForward, int number, @Nullable IGetMsgEmojiLikesListCallback cb5);

    void getMsgSetting(@Nullable IOperateCallback result);

    @Deprecated(message = "9.0.30\u5f00\u59cb\u5e9f\u5f03\uff0c\u7531getMsgsExt\u66ff\u4ee3", replaceWith = @ReplaceWith(expression = "getMsgsExt", imports = {}))
    void getMsgs(@NotNull Contact peer, long msgId, int cnt, boolean queryOrder, @NotNull IMsgOperateCallback cb5);

    void getMsgsByMsgId(@Nullable Contact peer, @Nullable ArrayList<Long> msgIds, @Nullable IMsgOperateCallback result);

    @Deprecated(message = "9.0.30\u5f00\u59cb\u5e9f\u5f03\uff0c\u7531getMsgsExt\u66ff\u4ee3", replaceWith = @ReplaceWith(expression = "getMsgsExt", imports = {}))
    void getMsgsBySeqAndCount(@Nullable Contact peer, long msgSeq, int cnt, boolean queryOrder, @Nullable IMsgOperateCallback result);

    void getMsgsByTypeFilters(@Nullable Contact peer, long msgId, int cnt, boolean queryOrder, @Nullable ArrayList<MsgTypeFilter> typeFilters, @Nullable IMsgOperateCallback cb5);

    void getMsgsExt(@NotNull MsgsReq req, @Nullable IMsgsRspOperateCallback cb5);

    @Deprecated(message = "9.0.30\u5f00\u59cb\u5e9f\u5f03\uff0c\u7531getMsgsExt\u66ff\u4ee3", replaceWith = @ReplaceWith(expression = "getMsgsExt", imports = {}))
    void getMsgsIncludeSelf(@NotNull Contact peer, long msgId, int cnt, boolean queryOrder, @NotNull IMsgOperateCallback cb5);

    @Deprecated(message = "9.0.30\u5f00\u59cb\u5e9f\u5f03\uff0c\u7531getMsgsExt\u66ff\u4ee3", replaceWith = @ReplaceWith(expression = "getMsgsExt", imports = {}))
    void getMsgsWithMsgTimeAndClientSeqForC2C(@NotNull Contact peer, long msgTime, long clientSeq, int cnt, boolean needIncludeSelf, boolean queryOrder, boolean incloudeDeleteMsg, @NotNull IMsgOperateCallback cb5);

    void getMsgsWithStatus(@Nullable GetMsgsAndStatusRecord record, @Nullable IGetMsgWithStatusCallback cb5);

    void getMultiMsg(@NotNull Contact peer, long rootMsgId, long parentMsgId, @NotNull IGetMultiMsgCallback cb5);

    void getOnLineDev(@Nullable IOperateCallback result);

    void getRecallMsgsByMsgId(@Nullable Contact peer, @NotNull ArrayList<Long> msgIds, @Nullable IMsgOperateCallback listener);

    void getRecentEmojiList(int chatType, @Nullable IGetRecentUseEmojiListCallback cb5);

    void getRecentHiddenSesionList(@Nullable IOperateHiddenSessionCallback callback);

    void getRecentUseEmojiList(@Nullable IGetRecentUseEmojiListCallback cb5);

    void getReplyDraft(@NotNull Contact peer, long rootSeq, @Nullable IGetDraftOperateCallback cb5);

    void getRichMediaElement(@NotNull RichMediaElementGetReq getReq);

    @Nullable
    String getRichMediaFilePathForGuild(@NotNull RichMediaFilePathInfo richMediaFilePathInfo);

    @Nullable
    String getRichMediaFilePathForMobileQQSend(@NotNull RichMediaFilePathInfo richMediaFilePathInfo);

    void getSingleMsg(@Nullable Contact peer, long msgSeq, @Nullable IMsgOperateCallback cb5);

    void getSourceOfReplyMsg(@Nullable Contact peer, long msgId, long sourceMsgSeq, @Nullable IMsgOperateCallback cb5);

    void getSourceOfReplyMsgV2(@NotNull Contact peer, long rootMsgId, long replyMsgId, @NotNull IMsgOperateCallback cb5);

    void getTempChatInfo(int chatType, @Nullable String peerUid, @Nullable IGetTempChatInfoCallback cb5);

    void i0(@NotNull JoinDragonGroupEmojiReq req, @NotNull IJoinDragonGroupCallback cb5);

    void importDataLineMsg();

    void importOldDbMsg(@Nullable IOperateCallback cb5);

    void isMqqDataImportFinished(@Nullable IOperateCallback cb5);

    void j(@NotNull Contact peer, long msgId, long elemId, @NotNull IOperateCallback cb5);

    @Nullable
    Long j0(int chatType);

    void k(@NotNull ArrayList<Long> rootMsgIds, @NotNull ArrayList<Long> subMsgIds, @NotNull Contact srcContact, @NotNull ArrayList<Contact> dstContacts, @Nullable ArrayList<MsgElement> commentElements, @NotNull IForwardOperateCallback cb5);

    void k0(@NotNull GetArkToMarkdownMsgTemplateReqInfo reqInfo, @NotNull IGetArkToMarkdownMsgTemplateCallback callback);

    void kickOffLine(@NotNull DevInfo devInfo, @Nullable IOperateCallback result);

    void likeOrDislikeReportForMsg(@NotNull Contact peer, @NotNull FeedBackMsgInfo msgInfo, @NotNull FeedBackDataForMsg feedBackData, @NotNull IOperateCallback cb5);

    void m0(@NotNull com.tencent.qqnt.kernel.invorker.b listener);

    void modifyBottomEmojiTableSwitchStatus(@NotNull ModifyBottomEmojiTableSwitchStatusReq req, @Nullable IModifyBottomEmojiTableSwitchStatusCallback cb5);

    void moveBottomEmojiTable(@NotNull MoveBottomEmojiTableReq req, @Nullable IMoveBottomEmojiTableCallback cb5);

    @Deprecated(message = "9.0.30\u5f00\u59cb\u5e9f\u5f03\uff0c\u7531getMsgsExt\u66ff\u4ee3", replaceWith = @ReplaceWith(expression = "getMsgsExt", imports = {}))
    void n0(@Nullable Contact peer, long msgSeq, int cnt, boolean queryOrder, boolean callbackInMainThread, boolean includeDeleteMsg, @Nullable IMsgOperateCallback result);

    void o(@NotNull Contact contact, long msgId, @NotNull IOperateCallback callback);

    void o0(long msgId, @NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements);

    void prepareTempChat(@Nullable TempChatPrepareInfo preInfo, @Nullable IOperateCallback cb5);

    void queryEmoticonMsgs(long msgId, long msgTime, long msgSeq, @NotNull QueryMsgsParams params, @NotNull IMsgOperateCallback cb5);

    void queryFirstRoamMsg(@NotNull Contact peer, long time, @NotNull IQueryFirstRoamMsgCallback cb5);

    void queryMsgsAndAbstractsWithFilter(long msgId, long msgTime, long msgSeq, @NotNull QueryMsgsParams params, @NotNull IQueryMsgsAndAbstractsWithFilterCallback cb5);

    void queryMsgsWithFilter(long msgId, long msgTime, @Nullable QueryMsgsParams params, @Nullable IMsgOperateCallback cb5);

    void queryMsgsWithFilterEx(long msgId, long msgTime, long msgSeq, @NotNull QueryMsgsParams params, @NotNull IMsgOperateCallback cb5);

    void queryPicOrVideoMsgs(long msgId, long msgTime, long msgSeq, @NotNull QueryMsgsParams params, @NotNull IMsgOperateCallback cb5);

    void queryRoamCalendar(@Nullable Contact peer, long curDate, @Nullable IQueryCalendarCallback cb5);

    void queryShortVideoMsgs(long msgId, long msgTime, long msgSeq, @NotNull QueryMsgsParams params, @NotNull IMsgOperateCallback cb5);

    void queryTroopEmoticonMsgs(long msgId, long msgTime, long msgSeq, @NotNull QueryMsgsParams params, @NotNull IMsgOperateCallback cb5);

    void recallMsg(@NotNull Contact peer, long msgId, @Nullable IOperateCallback cb5);

    void reeditRecallMsg(@Nullable Contact peer, long msgId, @Nullable IOperateCallback cb5);

    void refuseReceiveOnlineFileMsg(@NotNull Contact peer, long msgId, @NotNull IOperateCallback cb5);

    void regenerateMsg(@NotNull Contact peer, long msgId, @Nullable IOperateCallback cb5);

    void registerSysMsgNotification(int businessType, long msgType, @NotNull ArrayList<Long> msgSubType, @Nullable IOperateCallback cb5);

    void removeMsgListener(@NotNull IKernelMsgListener listener);

    void renameAnonyChatNick(@Nullable String groupId, @Nullable IRenameAnonymousChatNickCallback cb5);

    void replyMsgWithSourceMsgInfo(@NotNull SourceMsgInfoForReplyMsg sourceMsgInfo, @NotNull ArrayList<MsgElement> replyElements, @NotNull HashMap<Integer, MsgAttributeInfo> msgAttributeInfos, @NotNull IReplyMsgWithSourceMsgInfoCallback cb5);

    void reqToOfflineSendMsg(@NotNull Contact peer, long msgId, @NotNull IOperateCallback cb5);

    void resendMsg(@NotNull Contact peer, long msgId, @Nullable IOperateCallback result);

    void sendMsg(long msgId, @NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements, @NotNull HashMap<Integer, MsgAttributeInfo> msgAttrs, @Nullable IOperateCallback result);

    void sendShowInputStatusReq(int chatType, int eventType, @NotNull String toUid, @Nullable IOperateCallback result);

    void setAllC2CAndGroupMsgRead(@Nullable IOperateCallback result);

    void setContactLocalTop(@Nullable Contact peer, boolean isTop, @Nullable IOperateCallback result);

    void setCurHiddenSession(@Nullable RecentHiddenSesionInfo info, @Nullable IOperateCallback callback);

    void setCurOnScreenMsgForMsgEvent(@NotNull Contact peer, @NotNull HashMap<Long, byte[]> msgEventInfo);

    void setDraft(@Nullable Contact peer, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback result);

    void setFocusOnBase(@NotNull Contact peer);

    void setLocalMsgRead(@NotNull Contact peer, @Nullable IOperateCallback listener);

    void setMarkUnreadFlag(@Nullable Contact peer, boolean isMarkUnread);

    void setMiscDataVer2(@Nullable MiscData value, @Nullable IOperateCallback cb5);

    void setMsgEmojiLikes(@Nullable Contact peer, long msgSeq, @Nullable String emojiId, long emojiType, boolean setEmoji, @Nullable ISetMsgEmojiLikesCallback cb5);

    void setMsgEmojiLikesForRole(@Nullable Contact peer, long msgSeq, @Nullable String emojiId, long emojiType, long taskId, long taskType, boolean setEmoji, boolean isGuest, @NotNull AttaReportData attaReportData, @Nullable ISetMsgEmojiLikesForRoleCallback cb5);

    void setMsgRead(@NotNull Contact peer, @Nullable IOperateCallback result);

    void setMsgReadAndReport(@NotNull Contact peer, @NotNull MsgRecord lastMsg, @Nullable IOperateCallback result);

    void setMsgReadByChatType(int chatType, @NotNull IOperateCallback cb5);

    void setMsgRichInfoFlag(boolean richFlag);

    void setMsgSetting(@NotNull MsgSetting msgSetting, @Nullable IOperateCallback result);

    void setPowerStatus(boolean isPowerOn);

    void setRecentHiddenSession(@NotNull ArrayList<RecentHiddenSesionInfo> infos, @Nullable IOperateCallback callback);

    void setReplyDraft(@NotNull Contact peer, long rootSeq, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback cb5);

    void setSpecificMsgReadAndReport(@NotNull Contact peer, long msgId, @Nullable IOperateCallback result);

    void setSubscribeFolderUsingSmallRedPoint(boolean enable);

    void setTokenForMqq(@NotNull byte[] tokenInfo, @Nullable IOperateCallback result);

    void startMsgSync();

    void stopGenerateMsg(@NotNull Contact peer, long msgId, @Nullable IOperateCallback cb5);

    void stopImportOldDbMsgAndroid();

    void switchAnonymousChat(@Nullable String groupId, boolean isAnonymousChat, @Nullable ISwitchAnonymousChatCallback cb5);

    void switchBackGround(@NotNull BackGroundInfo backInfo, @Nullable IOperateCallback result);

    void switchForeGround(@Nullable IOperateCallback result);

    void t0(@NotNull ArrayList<MultiMsgInfo> msgInfos, @NotNull Contact srcContact, @NotNull Contact dstContacts, @Nullable ArrayList<MsgElement> commentElements, @NotNull IOperateCallback cb5);

    void translatePtt2Text(long msgId, @NotNull Contact peer, @NotNull MsgElement msgElement, @NotNull IOperateCallback result);

    void translatePtt2TextAiVoice(long msgId, @NotNull Contact peer, @NotNull MsgElement msgElement, @NotNull IOperateCallback result);

    void unregisterSysMsgNotification(int businessType, long msgType, @NotNull ArrayList<Long> msgSubType, @Nullable IOperateCallback cb5);

    void updateAnonymousInfo(@NotNull String groupId, @NotNull GroupAnonymousInfo info);

    void updateElementExtBufForUI(@NotNull Contact peer, long rootMsgId, long elemId, @NotNull byte[] extBufForUI, @Nullable IOperateCallback cb5);

    void updateMsgRecordExtPbBufForUI(@NotNull Contact peer, long msgId, @NotNull byte[] extPbBufForUI, @Nullable IOperateCallback cb5);

    void updatePublicAccountInfo(@NotNull PublicAccountInfo info, @Nullable IOperateCallback cb5);

    void w(@NotNull Contact contact, long msgType, @NotNull MsgElement msgElement, boolean front, @Nullable IOperateCallback cb5);

    void y(@NotNull GetArgMsgConfigReqInfo req, @NotNull IGetArkMsgConfigCallback callback);

    void y0(@NotNull Contact peer, @NotNull JsonGrayElement jsonGrayTipElement, @Nullable JsonGrayMsgInfo jsonGrayMsgInfo, boolean needStore, boolean needRecentContact, @Nullable IAddJsonGrayTipMsgCallback cb5);
}

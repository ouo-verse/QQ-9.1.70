package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.JsonGrayElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.LocalGrayTipElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelMsgService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelMsgService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        CppProxy(long j3) {
            if (j3 != 0) {
                this.nativeRef = j3;
                return;
            }
            throw new RuntimeException("nativeRef is zero");
        }

        private native void nativeDestroy(long j3);

        private native ArrayList<Integer> native_GetMsgSubType(long j3, int i3, int i16);

        private native boolean native_IsC2CStyleChatType(long j3, int i3);

        private native boolean native_IsExistOldDb(long j3);

        private native boolean native_IsLocalJsonTipValid(long j3, int i3);

        private native boolean native_IsTempChatType(long j3, int i3);

        private native void native_JoinDragonGroupEmoji(long j3, JoinDragonGroupEmojiReq joinDragonGroupEmojiReq, IJoinDragonGroupCallback iJoinDragonGroupCallback);

        private native void native_addFavEmoji(long j3, AddFavEmojiReq addFavEmojiReq, IAddFavEmojiCallback iAddFavEmojiCallback);

        private native long native_addKernelMsgImportToolListener(long j3, IKernelMsgImportToolListener iKernelMsgImportToolListener);

        private native long native_addKernelMsgListener(long j3, IKernelMsgListener iKernelMsgListener);

        private native long native_addKernelTempChatSigListener(long j3, ITempChatSigListener iTempChatSigListener);

        private native void native_addLocalAVRecordMsg(long j3, Contact contact, LocalAVRecordElement localAVRecordElement, IOperateCallback iOperateCallback);

        private native void native_addLocalGrayTipMsg(long j3, Contact contact, LocalGrayTipElement localGrayTipElement, boolean z16, IOperateCallback iOperateCallback);

        private native void native_addLocalJsonGrayTipMsg(long j3, Contact contact, JsonGrayElement jsonGrayElement, boolean z16, boolean z17, IAddJsonGrayTipMsgCallback iAddJsonGrayTipMsgCallback);

        private native void native_addLocalJsonGrayTipMsgExt(long j3, Contact contact, JsonGrayMsgInfo jsonGrayMsgInfo, JsonGrayElement jsonGrayElement, boolean z16, boolean z17, IAddJsonGrayTipMsgCallback iAddJsonGrayTipMsgCallback);

        private native void native_addLocalRecordMsg(long j3, Contact contact, long j16, MsgElement msgElement, HashMap<Integer, MsgAttributeInfo> hashMap, boolean z16, IOperateCallback iOperateCallback);

        private native void native_addLocalRecordMsgWithExtInfos(long j3, Contact contact, long j16, AddLocalRecordMsgParams addLocalRecordMsgParams, IOperateCallback iOperateCallback);

        private native void native_addLocalTofuRecordMsg(long j3, Contact contact, TofuRecordElement tofuRecordElement, IOperateCallback iOperateCallback);

        private native void native_addRecentUsedFace(long j3, ArrayList<RecentUsedFace> arrayList);

        private native void native_addSendMsg(long j3, long j16, Contact contact, ArrayList<MsgElement> arrayList, HashMap<Integer, MsgAttributeInfo> hashMap);

        private native String native_assembleMobileQQRichMediaFilePath(long j3, RichMediaFilePathInfo richMediaFilePathInfo);

        private native void native_canImportOldDbMsg(long j3, ICanImportCallback iCanImportCallback);

        private native void native_canProcessDataMigration(long j3, ICanImportCallback iCanImportCallback);

        private native void native_cancelGetRichMediaElement(long j3, RichMediaElementGetReq richMediaElementGetReq);

        private native void native_cancelSendMsg(long j3, Contact contact, long j16);

        private native void native_checkMsgWithUrl(long j3, CheckUrlInfo checkUrlInfo, ICheckMsgWithUrlCallback iCheckMsgWithUrlCallback);

        private native void native_checkTabListStatus(long j3, IOperateCallback iOperateCallback);

        private native void native_clearMsgRecords(long j3, Contact contact, IClearMsgRecordsCallback iClearMsgRecordsCallback);

        private native void native_clickInlineKeyboardButton(long j3, InlineKeyboardClickInfo inlineKeyboardClickInfo, IClickInlineKeyboardButtonCallback iClickInlineKeyboardButtonCallback);

        private native void native_clickTofuActionButton(long j3, Contact contact, long j16, TofuActionButton tofuActionButton, IOperateCallback iOperateCallback);

        private native String native_createUidFromTinyId(long j3, long j16, long j17);

        private native void native_dataMigrationGetDataAvaiableContactList(long j3, IDataMigrationGetAvailableContactListCallback iDataMigrationGetAvailableContactListCallback);

        private native long native_dataMigrationGetMsgList(long j3, QueryMsgsParams queryMsgsParams, IDataMigrationGetMsgListCalback iDataMigrationGetMsgListCalback);

        private native String native_dataMigrationGetResourceLocalDestinyPath(long j3, DataMigrationResourceInfo dataMigrationResourceInfo);

        private native long native_dataMigrationImportMsgPbRecord(long j3, ArrayList<DataMigrationMsgInfo> arrayList, ArrayList<DataMigrationResourceInfo> arrayList2, ITaskFinishCallback iTaskFinishCallback);

        private native void native_dataMigrationSetIOSPathPrefix(long j3, String str);

        private native void native_dataMigrationStopOperation(long j3, long j16);

        private native void native_delMarketEmojiTab(long j3, DelMarketEmojiTabReq delMarketEmojiTabReq, IDelMarketEmojiTableCallback iDelMarketEmojiTableCallback);

        private native void native_delRecentHiddenSession(long j3, ArrayList<RecentHiddenSesionInfo> arrayList, IOperateCallback iOperateCallback);

        private native void native_deleteAllRoamMsgs(long j3, int i3, String str, IOperateCallback iOperateCallback);

        private native void native_deleteDraft(long j3, Contact contact, IOperateCallback iOperateCallback);

        private native void native_deleteFavEmoji(long j3, ArrayList<String> arrayList, IOperateCallback iOperateCallback);

        private native void native_deleteMsg(long j3, Contact contact, ArrayList<Long> arrayList, IOperateCallback iOperateCallback);

        private native void native_deleteReplyDraft(long j3, Contact contact, long j16, IOperateCallback iOperateCallback);

        private native void native_downloadEmojiPic(long j3, int i3, ArrayList<GproEmojiDownloadParams> arrayList, int i16, HashMap<String, String> hashMap);

        private native void native_downloadOnlineStatusBigIconByUrl(long j3, int i3, String str);

        private native void native_downloadOnlineStatusCommonByUrl(long j3, String str, String str2, IDownloadCommonStatusCallback iDownloadCommonStatusCallback);

        private native void native_downloadOnlineStatusSmallIconByUrl(long j3, int i3, String str);

        private native void native_downloadRichMedia(long j3, RichMediaElementGetReq richMediaElementGetReq);

        private native void native_enterOrExitAio(long j3, ArrayList<EnterOrExitAioInfo> arrayList, IOperateCallback iOperateCallback);

        private native void native_feedBackReportForMsg(long j3, Contact contact, FeedBackMsgInfo feedBackMsgInfo, FeedBackDataForMsg feedBackDataForMsg, IOperateCallback iOperateCallback);

        private native void native_fetchBottomEmojiTableList(long j3, FetchBottomEmojiTableListReq fetchBottomEmojiTableListReq, IFetchBottomEmojiTableListCallback iFetchBottomEmojiTableListCallback);

        private native void native_fetchFavEmojiList(long j3, String str, int i3, boolean z16, boolean z17, IFetchFavEmojiListCallback iFetchFavEmojiListCallback);

        private native void native_fetchGetHitEmotionsByWord(long j3, RelatedEmotionWordsInfo relatedEmotionWordsInfo, IFetchGetHitEmotionsByWordCallback iFetchGetHitEmotionsByWordCallback);

        private native void native_fetchLongMsg(long j3, Contact contact, long j16);

        private native void native_fetchLongMsgWithCb(long j3, Contact contact, long j16, IOperateCallback iOperateCallback);

        private native void native_fetchMarketEmoticonAioImage(long j3, MarketEmoticonAioImageReq marketEmoticonAioImageReq, IOperateCallback iOperateCallback);

        private native void native_fetchMarketEmoticonAuthDetail(long j3, MarketEmoticonAuthDetailReq marketEmoticonAuthDetailReq, IOperateCallback iOperateCallback);

        private native void native_fetchMarketEmoticonFaceImages(long j3, ArrayList<MarketEmoticonShowImageReq> arrayList);

        private native void native_fetchMarketEmoticonList(long j3, int i3, int i16, IFetchMarketEmoticonListCallback iFetchMarketEmoticonListCallback);

        private native void native_fetchMarketEmoticonShowImage(long j3, MarketEmoticonShowImageReq marketEmoticonShowImageReq, IOperateCallback iOperateCallback);

        private native void native_fetchMarketEmotionJsonFile(long j3, int i3, IOperateCallback iOperateCallback);

        private native void native_fetchStatusMgrInfo(long j3, IGetStatusMsgCallback iGetStatusMsgCallback);

        private native void native_fetchStatusUnitedConfigInfo(long j3, IGetStatusMsgCallback iGetStatusMsgCallback);

        private native void native_forwardFile(long j3, TargetFileInfo targetFileInfo, Contact contact, IOperateCallback iOperateCallback);

        private native void native_forwardMsg(long j3, ArrayList<Long> arrayList, Contact contact, ArrayList<Contact> arrayList2, HashMap<Integer, MsgAttributeInfo> hashMap, IForwardOperateCallback iForwardOperateCallback);

        private native void native_forwardMsgWithComment(long j3, ArrayList<Long> arrayList, Contact contact, ArrayList<Contact> arrayList2, ArrayList<MsgElement> arrayList3, HashMap<Integer, MsgAttributeInfo> hashMap, IForwardOperateCallback iForwardOperateCallback);

        private native void native_forwardRichMsgInVist(long j3, ArrayList<ForWardMsgInVisitReq> arrayList, ArrayList<Contact> arrayList2, IForwardOperateCallback iForwardOperateCallback);

        private native void native_forwardSubMsgWithComment(long j3, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, Contact contact, ArrayList<Contact> arrayList3, ArrayList<MsgElement> arrayList4, HashMap<Integer, MsgAttributeInfo> hashMap, IForwardOperateCallback iForwardOperateCallback);

        private native long native_generateMsgUniqueId(long j3, int i3, long j16);

        private native void native_getABatchOfContactMsgBoxInfo(long j3, ArrayList<Contact> arrayList, IGetMsgsBoxesCallback iGetMsgsBoxesCallback);

        private native void native_getAioFirstViewLatestMsgs(long j3, Contact contact, int i3, IGetAioFirstViewLatestMsgCallback iGetAioFirstViewLatestMsgCallback);

        private native void native_getAllOnlineFileMsgs(long j3, IMsgOperateCallback iMsgOperateCallback);

        private native GroupAnonymousInfo native_getAnonymousInfo(long j3, String str);

        private native void native_getArkMsgConfig(long j3, GetArgMsgConfigReqInfo getArgMsgConfigReqInfo, IGetArkMsgConfigCallback iGetArkMsgConfigCallback);

        private native void native_getArkToMarkdownMsgTemplate(long j3, GetArkToMarkdownMsgTemplateReqInfo getArkToMarkdownMsgTemplateReqInfo, IGetArkToMarkdownMsgTemplateCallback iGetArkToMarkdownMsgTemplateCallback);

        private native void native_getAutoReplyTextList(long j3, IGetAutoReplyTextListCallback iGetAutoReplyTextListCallback);

        private native void native_getBookmarkData(long j3, String str, IBookmarkStorageGetCallback iBookmarkStorageGetCallback);

        private native void native_getContactUnreadCnt(long j3, ArrayList<Contact> arrayList, IOperateCallback iOperateCallback);

        private native int native_getCurChatImportStatusByUin(long j3, long j16, int i3);

        private native void native_getCurHiddenSession(long j3, IOperateHiddenSessionCallback iOperateHiddenSessionCallback);

        private native int native_getDataImportUserLevel(long j3);

        private native void native_getDraft(long j3, Contact contact, IGetDraftOperateCallback iGetDraftOperateCallback);

        private native void native_getEmojiResourcePath(long j3, int i3, IGetEmojiResourcePathCallback iGetEmojiResourcePathCallback);

        private native void native_getFavMarketEmoticonInfo(long j3, int i3, String str, IGetFavMarketEmoticonInfoCallback iGetFavMarketEmoticonInfoCallback);

        private native String native_getFileThumbSavePath(long j3, String str, int i3, boolean z16);

        private native String native_getFileThumbSavePathForSend(long j3, int i3, boolean z16);

        private native void native_getFirstUnreadAtMsg(long j3, Contact contact, IGetFirstUnreadAtMsgCallback iGetFirstUnreadAtMsgCallback);

        private native void native_getFirstUnreadAtallMsg(long j3, Contact contact, IFetchChannelLatestSeqCallback iFetchChannelLatestSeqCallback);

        private native void native_getFirstUnreadAtmeMsg(long j3, Contact contact, IFetchChannelLatestSeqCallback iFetchChannelLatestSeqCallback);

        private native void native_getFirstUnreadMsgSeq(long j3, Contact contact, IGetMsgSeqCallback iGetMsgSeqCallback);

        private native long native_getGroupMsgStorageTime(long j3);

        private native void native_getHotPicHotWords(long j3, EmojiHotPicGetHotWordsReqBody emojiHotPicGetHotWordsReqBody, IEmojiGetHotPicHotWordsResultCallback iEmojiGetHotPicHotWordsResultCallback);

        private native void native_getHotPicInfoListSearchString(long j3, String str, String str2, int i3, int i16, boolean z16, IGetHotPicInfoListCallback iGetHotPicInfoListCallback);

        private native void native_getHotPicJumpInfo(long j3, EmojiHotPicGetJumpInfoReqBody emojiHotPicGetJumpInfoReqBody, IEmojiHotPicGetJumpInfoResultCallback iEmojiHotPicGetJumpInfoResultCallback);

        private native void native_getHotPicSearchResult(long j3, EmojiHotPicSearchReqBody emojiHotPicSearchReqBody, IEmojiGetHotPicSearchResultCallback iEmojiGetHotPicSearchResultCallback);

        private native void native_getKeyWordRelatedEmoji(long j3, KeyWordRelatedEmojiInfo keyWordRelatedEmojiInfo, IOperateCallback iOperateCallback);

        private native void native_getLastMessageList(long j3, ArrayList<Contact> arrayList, IMsgOperateCallback iMsgOperateCallback);

        private native void native_getLatestDbMsgs(long j3, Contact contact, int i3, IMsgOperateCallback iMsgOperateCallback);

        private native void native_getMarketEmoticonEncryptKeys(long j3, int i3, ArrayList<String> arrayList, IGetMarketEmoticonEncryptKeysCallback iGetMarketEmoticonEncryptKeysCallback);

        private native void native_getMarketEmoticonPath(long j3, int i3, ArrayList<String> arrayList, MarketEmojiPathServiceType marketEmojiPathServiceType, IGetMarketEmoticonPathCallback iGetMarketEmoticonPathCallback);

        private native HashMap<String, MarketEmoticonPath> native_getMarketEmoticonPathBySync(long j3, int i3, ArrayList<String> arrayList, MarketEmojiPathServiceType marketEmojiPathServiceType);

        private native void native_getMiscData(long j3, String str, IGProMiscStorageGetCallback iGProMiscStorageGetCallback);

        private native void native_getMiscDataVer2(long j3, MiscKeyInfo miscKeyInfo, IGetMiscDataCallback iGetMiscDataCallback);

        private native void native_getMqqDataImportTableNames(long j3, IDataImportTableNamesCallback iDataImportTableNamesCallback);

        private native void native_getMsgAbstract(long j3, Contact contact, long j16, IGetMsgAbstractsCallback iGetMsgAbstractsCallback);

        private native void native_getMsgByClientSeqAndTime(long j3, Contact contact, long j16, long j17, IMsgOperateCallback iMsgOperateCallback);

        private native void native_getMsgEmojiLikesList(long j3, Contact contact, long j16, String str, long j17, String str2, boolean z16, int i3, IGetMsgEmojiLikesListCallback iGetMsgEmojiLikesListCallback);

        private native void native_getMsgEventFlow(long j3, Contact contact);

        private native void native_getMsgQRCode(long j3, IGetMsgQRCodeCallback iGetMsgQRCodeCallback);

        private native void native_getMsgSetting(long j3, IOperateCallback iOperateCallback);

        private native void native_getMsgWithAbstractByFilterParam(long j3, Contact contact, long j16, long j17, int i3, MsgFilterParams msgFilterParams, IGetMsgWithAbstractCallback iGetMsgWithAbstractCallback);

        private native void native_getMsgs(long j3, Contact contact, long j16, int i3, boolean z16, IMsgOperateCallback iMsgOperateCallback);

        private native void native_getMsgsByMsgId(long j3, Contact contact, ArrayList<Long> arrayList, IMsgOperateCallback iMsgOperateCallback);

        private native void native_getMsgsBySeqAndCount(long j3, Contact contact, long j16, int i3, boolean z16, boolean z17, IMsgOperateCallback iMsgOperateCallback);

        private native void native_getMsgsByTypeFilter(long j3, Contact contact, long j16, ArrayList<MsgTypeFilter> arrayList, int i3, boolean z16, IMsgOperateCallback iMsgOperateCallback);

        private native void native_getMsgsByTypeFilters(long j3, Contact contact, long j16, int i3, boolean z16, ArrayList<MsgTypeFilter> arrayList, IMsgOperateCallback iMsgOperateCallback);

        private native void native_getMsgsExt(long j3, MsgsReq msgsReq, IMsgsRspOperateCallback iMsgsRspOperateCallback);

        private native void native_getMsgsIncludeSelf(long j3, Contact contact, long j16, int i3, boolean z16, IMsgOperateCallback iMsgOperateCallback);

        private native void native_getMsgsWithMsgTimeAndClientSeqForC2C(long j3, Contact contact, long j16, long j17, int i3, boolean z16, boolean z17, boolean z18, IMsgOperateCallback iMsgOperateCallback);

        private native void native_getMsgsWithStatus(long j3, GetMsgsAndStatusRecord getMsgsAndStatusRecord, IGetMsgWithStatusCallback iGetMsgWithStatusCallback);

        private native void native_getMultiMsg(long j3, Contact contact, long j16, long j17, IGetMultiMsgCallback iGetMultiMsgCallback);

        private native void native_getNtMsgSyncContactUnreadState(long j3, IGetNtMsgSyncContactUnreadStateCallback iGetNtMsgSyncContactUnreadStateCallback);

        private native void native_getOnLineDev(long j3, IOperateCallback iOperateCallback);

        private native void native_getOnlineFileMsgs(long j3, Contact contact, IMsgOperateCallback iMsgOperateCallback);

        private native void native_getOnlineStatusBigIconBasePath(long j3, IGetStatusMsgCallback iGetStatusMsgCallback);

        private native void native_getOnlineStatusCommonFileNameByUrl(long j3, String str, IGetStatusMsgCallback iGetStatusMsgCallback);

        private native void native_getOnlineStatusCommonPath(long j3, String str, IGetStatusMsgCallback iGetStatusMsgCallback);

        private native void native_getOnlineStatusSmallIconBasePath(long j3, IGetStatusMsgCallback iGetStatusMsgCallback);

        private native void native_getOnlineStatusSmallIconFileNameByUrl(long j3, String str, IGetStatusMsgCallback iGetStatusMsgCallback);

        private native void native_getRecallMsgsByMsgId(long j3, Contact contact, ArrayList<Long> arrayList, IMsgOperateCallback iMsgOperateCallback);

        private native void native_getRecentEmojiList(long j3, int i3, IGetRecentUseEmojiListCallback iGetRecentUseEmojiListCallback);

        private native void native_getRecentHiddenSesionList(long j3, IOperateHiddenSessionCallback iOperateHiddenSessionCallback);

        private native void native_getRecentUseEmojiList(long j3, IGetRecentUseEmojiListCallback iGetRecentUseEmojiListCallback);

        private native void native_getRecentUsedFaceList(long j3, int i3, IGetRecentUsedFaceListCallback iGetRecentUsedFaceListCallback);

        private native void native_getReplyDraft(long j3, Contact contact, long j16, IGetDraftOperateCallback iGetDraftOperateCallback);

        private native void native_getRichMediaElement(long j3, RichMediaElementGetReq richMediaElementGetReq);

        private native String native_getRichMediaFilePathForGuild(long j3, RichMediaFilePathInfo richMediaFilePathInfo);

        private native String native_getRichMediaFilePathForMobileQQSend(long j3, RichMediaFilePathInfo richMediaFilePathInfo);

        private native void native_getServiceAssistantSwitch(long j3, GetServiceAssistantSwitchReq getServiceAssistantSwitchReq, IGetServiceAssistantSwitchCallback iGetServiceAssistantSwitchCallback);

        private native void native_getSingleMsg(long j3, Contact contact, long j16, IMsgOperateCallback iMsgOperateCallback);

        private native void native_getSourceOfReplyMsg(long j3, Contact contact, long j16, long j17, IMsgOperateCallback iMsgOperateCallback);

        private native void native_getSourceOfReplyMsgByClientSeqAndTime(long j3, Contact contact, long j16, long j17, long j18, IMsgOperateCallback iMsgOperateCallback);

        private native void native_getSourceOfReplyMsgV2(long j3, Contact contact, long j16, long j17, IMsgOperateCallback iMsgOperateCallback);

        private native void native_getTempChatInfo(long j3, int i3, String str, IGetTempChatInfoCallback iGetTempChatInfoCallback);

        private native void native_grabRedBag(long j3, GrabRedBagReq grabRedBagReq, IGrabRedBagCallback iGrabRedBagCallback);

        private native void native_importDataLineMsg(long j3);

        private native void native_importOldDbMsg(long j3, IOperateCallback iOperateCallback);

        private native void native_insertMsgToMsgBox(long j3, Contact contact, long j16, int i3, IOperateCallback iOperateCallback);

        private native void native_isHitEmojiKeyword(long j3, RelatedEmotionWordsInfo relatedEmotionWordsInfo, IOperateCallback iOperateCallback);

        private native void native_isMqqDataImportFinished(long j3, IOperateCallback iOperateCallback);

        private native void native_isMsgMatched(long j3, MatchKey matchKey, IMatchedOperateCallback iMatchedOperateCallback);

        private native void native_kickOffLine(long j3, DevInfo devInfo, IOperateCallback iOperateCallback);

        private native void native_likeOrDislikeReportForMsg(long j3, Contact contact, FeedBackMsgInfo feedBackMsgInfo, FeedBackDataForMsg feedBackDataForMsg, IOperateCallback iOperateCallback);

        private native void native_modifyBottomEmojiTableSwitchStatus(long j3, ModifyBottomEmojiTableSwitchStatusReq modifyBottomEmojiTableSwitchStatusReq, IModifyBottomEmojiTableSwitchStatusCallback iModifyBottomEmojiTableSwitchStatusCallback);

        private native void native_modifyFavEmojiDesc(long j3, ArrayList<EmojiDescInfo> arrayList, IModifyFavEmojiDescCallback iModifyFavEmojiDescCallback);

        private native void native_moveBottomEmojiTable(long j3, MoveBottomEmojiTableReq moveBottomEmojiTableReq, IMoveBottomEmojiTableCallback iMoveBottomEmojiTableCallback);

        private native void native_multiForwardMsg(long j3, ArrayList<MultiMsgInfo> arrayList, Contact contact, Contact contact2, IOperateCallback iOperateCallback);

        private native void native_multiForwardMsgWithComment(long j3, ArrayList<MultiMsgInfo> arrayList, Contact contact, Contact contact2, ArrayList<MsgElement> arrayList2, HashMap<Integer, MsgAttributeInfo> hashMap, IOperateCallback iOperateCallback);

        private native void native_packRedBag(long j3, PackRedBagReq packRedBagReq, IPackRedBagCallback iPackRedBagCallback);

        private native void native_prepareTempChat(long j3, TempChatPrepareInfo tempChatPrepareInfo, IOperateCallback iOperateCallback);

        private native void native_pullDetail(long j3, PullDetailReq pullDetailReq, IPullDetailCallback iPullDetailCallback);

        private native void native_pullRedBagPasswordList(long j3, IPullRedBagPasswordListCallback iPullRedBagPasswordListCallback);

        private native void native_queryArkInfo(long j3, QueryArkInfoReq queryArkInfoReq, IKernelQueryArkInfoCallback iKernelQueryArkInfoCallback);

        private native void native_queryCalendar(long j3, Contact contact, long j16, IQueryCalendarCallback iQueryCalendarCallback);

        private native void native_queryEmoticonMsgs(long j3, long j16, long j17, long j18, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback);

        private native void native_queryFavEmojiByDesc(long j3, String str, IFetchFavEmojiListCallback iFetchFavEmojiListCallback);

        private native void native_queryFileMsgsDesktop(long j3, long j16, long j17, long j18, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback);

        private native void native_queryFirstMsgSeq(long j3, Contact contact, long j16, IQueryFirstMsgSeqCallback iQueryFirstMsgSeqCallback);

        private native void native_queryFirstRoamMsg(long j3, Contact contact, long j16, IQueryFirstRoamMsgCallback iQueryFirstRoamMsgCallback);

        private native void native_queryMsgsAndAbstractsWithFilter(long j3, long j16, long j17, long j18, QueryMsgsParams queryMsgsParams, IQueryMsgsAndAbstractsWithFilterCallback iQueryMsgsAndAbstractsWithFilterCallback);

        private native void native_queryMsgsWithFilter(long j3, long j16, long j17, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback);

        private native void native_queryMsgsWithFilterEx(long j3, long j16, long j17, long j18, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback);

        private native void native_queryMsgsWithFilterVer2(long j3, long j16, long j17, QueryMsgsParams queryMsgsParams, IQueryMsgsWithFilterVer2Callback iQueryMsgsWithFilterVer2Callback);

        private native void native_queryPicOrVideoMsgs(long j3, long j16, long j17, long j18, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback);

        private native void native_queryPicOrVideoMsgsDesktop(long j3, ChatInfo chatInfo, MsgIdInfo msgIdInfo, int i3, boolean z16, IMsgOperateCallback iMsgOperateCallback);

        private native void native_queryRoamCalendar(long j3, Contact contact, long j16, IQueryCalendarCallback iQueryCalendarCallback);

        private native void native_queryShortVideoMsgs(long j3, long j16, long j17, long j18, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback);

        private native void native_queryTroopEmoticonMsgs(long j3, long j16, long j17, long j18, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback);

        private native void native_queryUserSecQuality(long j3, IQueryUserSecQualityCallback iQueryUserSecQualityCallback);

        private native void native_recallMsg(long j3, Contact contact, ArrayList<Long> arrayList, IOperateCallback iOperateCallback);

        private native void native_recordEmoji(long j3, RecordType recordType, ArrayList<RecordEmojiInfo> arrayList);

        private native void native_reeditRecallMsg(long j3, Contact contact, long j16, IOperateCallback iOperateCallback);

        private native void native_refuseGetRichMediaElement(long j3, RichMediaElementGetReq richMediaElementGetReq);

        private native void native_refuseReceiveOnlineFileMsg(long j3, Contact contact, long j16, IOperateCallback iOperateCallback);

        private native void native_regenerateMsg(long j3, Contact contact, long j16, IOperateCallback iOperateCallback);

        private native void native_registerSysMsgNotification(long j3, int i3, long j16, ArrayList<Long> arrayList, IOperateCallback iOperateCallback);

        private native void native_removeKernelMsgListener(long j3, long j16);

        private native void native_removeKernelTempChatSigListener(long j3, long j16);

        private native void native_renameAnonyChatNick(long j3, String str, IRenameAnonymousChatNickCallback iRenameAnonymousChatNickCallback);

        private native void native_replyMsgWithSourceMsgInfo(long j3, SourceMsgInfoForReplyMsg sourceMsgInfoForReplyMsg, ArrayList<MsgElement> arrayList, HashMap<Integer, MsgAttributeInfo> hashMap, IReplyMsgWithSourceMsgInfoCallback iReplyMsgWithSourceMsgInfoCallback);

        private native void native_reqToOfflineSendMsg(long j3, Contact contact, long j16, IOperateCallback iOperateCallback);

        private native void native_requestTianshuAdv(long j3, ArrayList<TianShuAdPosItemData> arrayList, ITianShuGetAdvCallback iTianShuGetAdvCallback);

        private native void native_resendMsg(long j3, Contact contact, long j16, IOperateCallback iOperateCallback);

        private native void native_selectPasswordRedBag(long j3, GrabRedBagReq grabRedBagReq);

        private native void native_sendMsg(long j3, long j16, Contact contact, ArrayList<MsgElement> arrayList, HashMap<Integer, MsgAttributeInfo> hashMap, IOperateCallback iOperateCallback);

        private native void native_sendShowInputStatusReq(long j3, int i3, int i16, String str, IOperateCallback iOperateCallback);

        private native void native_setAllC2CAndGroupMsgRead(long j3, IOperateCallback iOperateCallback);

        private native void native_setAutoReplyTextList(long j3, ArrayList<AutoReplyText> arrayList, int i3, IOperateCallback iOperateCallback);

        private native void native_setBookmarkData(long j3, String str, String str2, IGProSimpleCallback iGProSimpleCallback);

        private native void native_setContactLocalTop(long j3, Contact contact, boolean z16, IOperateCallback iOperateCallback);

        private native void native_setCurHiddenSession(long j3, RecentHiddenSesionInfo recentHiddenSesionInfo, IOperateCallback iOperateCallback);

        private native void native_setCurOnScreenMsgForMsgEvent(long j3, Contact contact, HashMap<Long, byte[]> hashMap);

        private native void native_setDraft(long j3, Contact contact, ArrayList<MsgElement> arrayList, IOperateCallback iOperateCallback);

        private native void native_setFocusOnBase(long j3, Contact contact);

        private native void native_setIKernelPublicAccountAdapter(long j3, IKernelPublicAccountAdapter iKernelPublicAccountAdapter);

        private native void native_setIsStopKernelFetchLongMsg(long j3, boolean z16, IOperateCallback iOperateCallback);

        private native void native_setLocalMsgRead(long j3, Contact contact, IOperateCallback iOperateCallback);

        private native void native_setMarkUnreadFlag(long j3, Contact contact, boolean z16);

        private native void native_setMiscData(long j3, String str, String str2, IGProSimpleCallback iGProSimpleCallback);

        private native void native_setMiscDataVer2(long j3, MiscData miscData, IOperateCallback iOperateCallback);

        private native void native_setMsgEmojiLikes(long j3, Contact contact, long j16, String str, long j17, boolean z16, ISetMsgEmojiLikesCallback iSetMsgEmojiLikesCallback);

        private native void native_setMsgEmojiLikesForRole(long j3, Contact contact, long j16, String str, long j17, long j18, long j19, boolean z16, boolean z17, AttaReportData attaReportData, ISetMsgEmojiLikesForRoleCallback iSetMsgEmojiLikesForRoleCallback);

        private native void native_setMsgRead(long j3, Contact contact, IOperateCallback iOperateCallback);

        private native void native_setMsgReadAndReport(long j3, Contact contact, MsgRecord msgRecord, IOperateCallback iOperateCallback);

        private native void native_setMsgReadByChatType(long j3, int i3, IOperateCallback iOperateCallback);

        private native void native_setMsgRichInfoFlag(long j3, boolean z16);

        private native void native_setMsgSetting(long j3, MsgSetting msgSetting, IOperateCallback iOperateCallback);

        private native void native_setPowerStatus(long j3, boolean z16);

        private native void native_setPttPlayedState(long j3, long j16, Contact contact, long j17, IOperateCallback iOperateCallback);

        private native void native_setRecentHiddenSession(long j3, ArrayList<RecentHiddenSesionInfo> arrayList, IOperateCallback iOperateCallback);

        private native void native_setReplyDraft(long j3, Contact contact, long j16, ArrayList<MsgElement> arrayList, IOperateCallback iOperateCallback);

        private native void native_setServiceAssistantSwitch(long j3, SetServiceAssistantSwitchReq setServiceAssistantSwitchReq, IOperateCallback iOperateCallback);

        private native void native_setSpecificMsgReadAndReport(long j3, Contact contact, long j16, IOperateCallback iOperateCallback);

        private native void native_setStatus(long j3, StatusReq statusReq, IOperateCallback iOperateCallback);

        private native void native_setSubscribeFolderUsingSmallRedPoint(long j3, boolean z16);

        private native void native_setToken(long j3, TokenInfo tokenInfo, IOperateCallback iOperateCallback);

        private native void native_setTokenForMqq(long j3, byte[] bArr, IOperateCallback iOperateCallback);

        private native void native_startMsgSync(long j3);

        private native void native_stopGenerateMsg(long j3, Contact contact, long j16, IOperateCallback iOperateCallback);

        private native void native_stopImportOldDbMsgAndroid(long j3);

        private native void native_switchAnonymousChat(long j3, String str, boolean z16, ISwitchAnonymousChatCallback iSwitchAnonymousChatCallback);

        private native void native_switchBackGround(long j3, BackGroundInfo backGroundInfo, IOperateCallback iOperateCallback);

        private native void native_switchBackGroundForMqq(long j3, byte[] bArr, IOperateCallback iOperateCallback);

        private native void native_switchForeGround(long j3, IOperateCallback iOperateCallback);

        private native void native_switchForeGroundForMqq(long j3, byte[] bArr, IOperateCallback iOperateCallback);

        private native void native_switchToOfflineGetRichMediaElement(long j3, RichMediaElementGetReq richMediaElementGetReq);

        private native void native_switchToOfflineSendMsg(long j3, Contact contact, long j16);

        private native void native_tianshuMultiReport(long j3, ArrayList<TianShuReportData> arrayList, IOperateCallback iOperateCallback);

        private native void native_tianshuReport(long j3, TianShuReportData tianShuReportData, IOperateCallback iOperateCallback);

        private native void native_translatePtt2Text(long j3, long j16, Contact contact, MsgElement msgElement, IOperateCallback iOperateCallback);

        private native void native_translatePtt2TextAiVoice(long j3, long j16, Contact contact, MsgElement msgElement, IOperateCallback iOperateCallback);

        private native void native_unregisterSysMsgNotification(long j3, int i3, long j16, ArrayList<Long> arrayList, IOperateCallback iOperateCallback);

        private native void native_updateAnonymousInfo(long j3, String str, GroupAnonymousInfo groupAnonymousInfo);

        private native void native_updateElementExtBufForUI(long j3, Contact contact, long j16, long j17, byte[] bArr, IOperateCallback iOperateCallback);

        private native void native_updateMsgRecordExtPbBufForUI(long j3, Contact contact, long j16, byte[] bArr, IOperateCallback iOperateCallback);

        private native void native_updatePublicAccountInfo(long j3, PublicAccountInfo publicAccountInfo, IOperateCallback iOperateCallback);

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public ArrayList<Integer> GetMsgSubType(int i3, int i16) {
            return native_GetMsgSubType(this.nativeRef, i3, i16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public boolean IsC2CStyleChatType(int i3) {
            return native_IsC2CStyleChatType(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public boolean IsExistOldDb() {
            return native_IsExistOldDb(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public boolean IsLocalJsonTipValid(int i3) {
            return native_IsLocalJsonTipValid(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public boolean IsTempChatType(int i3) {
            return native_IsTempChatType(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void JoinDragonGroupEmoji(JoinDragonGroupEmojiReq joinDragonGroupEmojiReq, IJoinDragonGroupCallback iJoinDragonGroupCallback) {
            native_JoinDragonGroupEmoji(this.nativeRef, joinDragonGroupEmojiReq, iJoinDragonGroupCallback);
        }

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void addFavEmoji(AddFavEmojiReq addFavEmojiReq, IAddFavEmojiCallback iAddFavEmojiCallback) {
            native_addFavEmoji(this.nativeRef, addFavEmojiReq, iAddFavEmojiCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public long addKernelMsgImportToolListener(IKernelMsgImportToolListener iKernelMsgImportToolListener) {
            return native_addKernelMsgImportToolListener(this.nativeRef, iKernelMsgImportToolListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public long addKernelMsgListener(IKernelMsgListener iKernelMsgListener) {
            return native_addKernelMsgListener(this.nativeRef, iKernelMsgListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public long addKernelTempChatSigListener(ITempChatSigListener iTempChatSigListener) {
            return native_addKernelTempChatSigListener(this.nativeRef, iTempChatSigListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void addLocalAVRecordMsg(Contact contact, LocalAVRecordElement localAVRecordElement, IOperateCallback iOperateCallback) {
            native_addLocalAVRecordMsg(this.nativeRef, contact, localAVRecordElement, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void addLocalGrayTipMsg(Contact contact, LocalGrayTipElement localGrayTipElement, boolean z16, IOperateCallback iOperateCallback) {
            native_addLocalGrayTipMsg(this.nativeRef, contact, localGrayTipElement, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void addLocalJsonGrayTipMsg(Contact contact, JsonGrayElement jsonGrayElement, boolean z16, boolean z17, IAddJsonGrayTipMsgCallback iAddJsonGrayTipMsgCallback) {
            native_addLocalJsonGrayTipMsg(this.nativeRef, contact, jsonGrayElement, z16, z17, iAddJsonGrayTipMsgCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void addLocalJsonGrayTipMsgExt(Contact contact, JsonGrayMsgInfo jsonGrayMsgInfo, JsonGrayElement jsonGrayElement, boolean z16, boolean z17, IAddJsonGrayTipMsgCallback iAddJsonGrayTipMsgCallback) {
            native_addLocalJsonGrayTipMsgExt(this.nativeRef, contact, jsonGrayMsgInfo, jsonGrayElement, z16, z17, iAddJsonGrayTipMsgCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void addLocalRecordMsg(Contact contact, long j3, MsgElement msgElement, HashMap<Integer, MsgAttributeInfo> hashMap, boolean z16, IOperateCallback iOperateCallback) {
            native_addLocalRecordMsg(this.nativeRef, contact, j3, msgElement, hashMap, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void addLocalRecordMsgWithExtInfos(Contact contact, long j3, AddLocalRecordMsgParams addLocalRecordMsgParams, IOperateCallback iOperateCallback) {
            native_addLocalRecordMsgWithExtInfos(this.nativeRef, contact, j3, addLocalRecordMsgParams, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void addLocalTofuRecordMsg(Contact contact, TofuRecordElement tofuRecordElement, IOperateCallback iOperateCallback) {
            native_addLocalTofuRecordMsg(this.nativeRef, contact, tofuRecordElement, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void addRecentUsedFace(ArrayList<RecentUsedFace> arrayList) {
            native_addRecentUsedFace(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void addSendMsg(long j3, Contact contact, ArrayList<MsgElement> arrayList, HashMap<Integer, MsgAttributeInfo> hashMap) {
            native_addSendMsg(this.nativeRef, j3, contact, arrayList, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public String assembleMobileQQRichMediaFilePath(RichMediaFilePathInfo richMediaFilePathInfo) {
            return native_assembleMobileQQRichMediaFilePath(this.nativeRef, richMediaFilePathInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void canImportOldDbMsg(ICanImportCallback iCanImportCallback) {
            native_canImportOldDbMsg(this.nativeRef, iCanImportCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void canProcessDataMigration(ICanImportCallback iCanImportCallback) {
            native_canProcessDataMigration(this.nativeRef, iCanImportCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void cancelGetRichMediaElement(RichMediaElementGetReq richMediaElementGetReq) {
            native_cancelGetRichMediaElement(this.nativeRef, richMediaElementGetReq);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void cancelSendMsg(Contact contact, long j3) {
            native_cancelSendMsg(this.nativeRef, contact, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void checkMsgWithUrl(CheckUrlInfo checkUrlInfo, ICheckMsgWithUrlCallback iCheckMsgWithUrlCallback) {
            native_checkMsgWithUrl(this.nativeRef, checkUrlInfo, iCheckMsgWithUrlCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void checkTabListStatus(IOperateCallback iOperateCallback) {
            native_checkTabListStatus(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void clearMsgRecords(Contact contact, IClearMsgRecordsCallback iClearMsgRecordsCallback) {
            native_clearMsgRecords(this.nativeRef, contact, iClearMsgRecordsCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void clickInlineKeyboardButton(InlineKeyboardClickInfo inlineKeyboardClickInfo, IClickInlineKeyboardButtonCallback iClickInlineKeyboardButtonCallback) {
            native_clickInlineKeyboardButton(this.nativeRef, inlineKeyboardClickInfo, iClickInlineKeyboardButtonCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void clickTofuActionButton(Contact contact, long j3, TofuActionButton tofuActionButton, IOperateCallback iOperateCallback) {
            native_clickTofuActionButton(this.nativeRef, contact, j3, tofuActionButton, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public String createUidFromTinyId(long j3, long j16) {
            return native_createUidFromTinyId(this.nativeRef, j3, j16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void dataMigrationGetDataAvaiableContactList(IDataMigrationGetAvailableContactListCallback iDataMigrationGetAvailableContactListCallback) {
            native_dataMigrationGetDataAvaiableContactList(this.nativeRef, iDataMigrationGetAvailableContactListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public long dataMigrationGetMsgList(QueryMsgsParams queryMsgsParams, IDataMigrationGetMsgListCalback iDataMigrationGetMsgListCalback) {
            return native_dataMigrationGetMsgList(this.nativeRef, queryMsgsParams, iDataMigrationGetMsgListCalback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public String dataMigrationGetResourceLocalDestinyPath(DataMigrationResourceInfo dataMigrationResourceInfo) {
            return native_dataMigrationGetResourceLocalDestinyPath(this.nativeRef, dataMigrationResourceInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public long dataMigrationImportMsgPbRecord(ArrayList<DataMigrationMsgInfo> arrayList, ArrayList<DataMigrationResourceInfo> arrayList2, ITaskFinishCallback iTaskFinishCallback) {
            return native_dataMigrationImportMsgPbRecord(this.nativeRef, arrayList, arrayList2, iTaskFinishCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void dataMigrationSetIOSPathPrefix(String str) {
            native_dataMigrationSetIOSPathPrefix(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void dataMigrationStopOperation(long j3) {
            native_dataMigrationStopOperation(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void delMarketEmojiTab(DelMarketEmojiTabReq delMarketEmojiTabReq, IDelMarketEmojiTableCallback iDelMarketEmojiTableCallback) {
            native_delMarketEmojiTab(this.nativeRef, delMarketEmojiTabReq, iDelMarketEmojiTableCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void delRecentHiddenSession(ArrayList<RecentHiddenSesionInfo> arrayList, IOperateCallback iOperateCallback) {
            native_delRecentHiddenSession(this.nativeRef, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void deleteAllRoamMsgs(int i3, String str, IOperateCallback iOperateCallback) {
            native_deleteAllRoamMsgs(this.nativeRef, i3, str, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void deleteDraft(Contact contact, IOperateCallback iOperateCallback) {
            native_deleteDraft(this.nativeRef, contact, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void deleteFavEmoji(ArrayList<String> arrayList, IOperateCallback iOperateCallback) {
            native_deleteFavEmoji(this.nativeRef, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void deleteMsg(Contact contact, ArrayList<Long> arrayList, IOperateCallback iOperateCallback) {
            native_deleteMsg(this.nativeRef, contact, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void deleteReplyDraft(Contact contact, long j3, IOperateCallback iOperateCallback) {
            native_deleteReplyDraft(this.nativeRef, contact, j3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void downloadEmojiPic(int i3, ArrayList<GproEmojiDownloadParams> arrayList, int i16, HashMap<String, String> hashMap) {
            native_downloadEmojiPic(this.nativeRef, i3, arrayList, i16, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void downloadOnlineStatusBigIconByUrl(int i3, String str) {
            native_downloadOnlineStatusBigIconByUrl(this.nativeRef, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void downloadOnlineStatusCommonByUrl(String str, String str2, IDownloadCommonStatusCallback iDownloadCommonStatusCallback) {
            native_downloadOnlineStatusCommonByUrl(this.nativeRef, str, str2, iDownloadCommonStatusCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void downloadOnlineStatusSmallIconByUrl(int i3, String str) {
            native_downloadOnlineStatusSmallIconByUrl(this.nativeRef, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void downloadRichMedia(RichMediaElementGetReq richMediaElementGetReq) {
            native_downloadRichMedia(this.nativeRef, richMediaElementGetReq);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void enterOrExitAio(ArrayList<EnterOrExitAioInfo> arrayList, IOperateCallback iOperateCallback) {
            native_enterOrExitAio(this.nativeRef, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void feedBackReportForMsg(Contact contact, FeedBackMsgInfo feedBackMsgInfo, FeedBackDataForMsg feedBackDataForMsg, IOperateCallback iOperateCallback) {
            native_feedBackReportForMsg(this.nativeRef, contact, feedBackMsgInfo, feedBackDataForMsg, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void fetchBottomEmojiTableList(FetchBottomEmojiTableListReq fetchBottomEmojiTableListReq, IFetchBottomEmojiTableListCallback iFetchBottomEmojiTableListCallback) {
            native_fetchBottomEmojiTableList(this.nativeRef, fetchBottomEmojiTableListReq, iFetchBottomEmojiTableListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void fetchFavEmojiList(String str, int i3, boolean z16, boolean z17, IFetchFavEmojiListCallback iFetchFavEmojiListCallback) {
            native_fetchFavEmojiList(this.nativeRef, str, i3, z16, z17, iFetchFavEmojiListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void fetchGetHitEmotionsByWord(RelatedEmotionWordsInfo relatedEmotionWordsInfo, IFetchGetHitEmotionsByWordCallback iFetchGetHitEmotionsByWordCallback) {
            native_fetchGetHitEmotionsByWord(this.nativeRef, relatedEmotionWordsInfo, iFetchGetHitEmotionsByWordCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void fetchLongMsg(Contact contact, long j3) {
            native_fetchLongMsg(this.nativeRef, contact, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void fetchLongMsgWithCb(Contact contact, long j3, IOperateCallback iOperateCallback) {
            native_fetchLongMsgWithCb(this.nativeRef, contact, j3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void fetchMarketEmoticonAioImage(MarketEmoticonAioImageReq marketEmoticonAioImageReq, IOperateCallback iOperateCallback) {
            native_fetchMarketEmoticonAioImage(this.nativeRef, marketEmoticonAioImageReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void fetchMarketEmoticonAuthDetail(MarketEmoticonAuthDetailReq marketEmoticonAuthDetailReq, IOperateCallback iOperateCallback) {
            native_fetchMarketEmoticonAuthDetail(this.nativeRef, marketEmoticonAuthDetailReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void fetchMarketEmoticonFaceImages(ArrayList<MarketEmoticonShowImageReq> arrayList) {
            native_fetchMarketEmoticonFaceImages(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void fetchMarketEmoticonList(int i3, int i16, IFetchMarketEmoticonListCallback iFetchMarketEmoticonListCallback) {
            native_fetchMarketEmoticonList(this.nativeRef, i3, i16, iFetchMarketEmoticonListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void fetchMarketEmoticonShowImage(MarketEmoticonShowImageReq marketEmoticonShowImageReq, IOperateCallback iOperateCallback) {
            native_fetchMarketEmoticonShowImage(this.nativeRef, marketEmoticonShowImageReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void fetchMarketEmotionJsonFile(int i3, IOperateCallback iOperateCallback) {
            native_fetchMarketEmotionJsonFile(this.nativeRef, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void fetchStatusMgrInfo(IGetStatusMsgCallback iGetStatusMsgCallback) {
            native_fetchStatusMgrInfo(this.nativeRef, iGetStatusMsgCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void fetchStatusUnitedConfigInfo(IGetStatusMsgCallback iGetStatusMsgCallback) {
            native_fetchStatusUnitedConfigInfo(this.nativeRef, iGetStatusMsgCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void forwardFile(TargetFileInfo targetFileInfo, Contact contact, IOperateCallback iOperateCallback) {
            native_forwardFile(this.nativeRef, targetFileInfo, contact, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void forwardMsg(ArrayList<Long> arrayList, Contact contact, ArrayList<Contact> arrayList2, HashMap<Integer, MsgAttributeInfo> hashMap, IForwardOperateCallback iForwardOperateCallback) {
            native_forwardMsg(this.nativeRef, arrayList, contact, arrayList2, hashMap, iForwardOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void forwardMsgWithComment(ArrayList<Long> arrayList, Contact contact, ArrayList<Contact> arrayList2, ArrayList<MsgElement> arrayList3, HashMap<Integer, MsgAttributeInfo> hashMap, IForwardOperateCallback iForwardOperateCallback) {
            native_forwardMsgWithComment(this.nativeRef, arrayList, contact, arrayList2, arrayList3, hashMap, iForwardOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void forwardRichMsgInVist(ArrayList<ForWardMsgInVisitReq> arrayList, ArrayList<Contact> arrayList2, IForwardOperateCallback iForwardOperateCallback) {
            native_forwardRichMsgInVist(this.nativeRef, arrayList, arrayList2, iForwardOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void forwardSubMsgWithComment(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, Contact contact, ArrayList<Contact> arrayList3, ArrayList<MsgElement> arrayList4, HashMap<Integer, MsgAttributeInfo> hashMap, IForwardOperateCallback iForwardOperateCallback) {
            native_forwardSubMsgWithComment(this.nativeRef, arrayList, arrayList2, contact, arrayList3, arrayList4, hashMap, iForwardOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public long generateMsgUniqueId(int i3, long j3) {
            return native_generateMsgUniqueId(this.nativeRef, i3, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getABatchOfContactMsgBoxInfo(ArrayList<Contact> arrayList, IGetMsgsBoxesCallback iGetMsgsBoxesCallback) {
            native_getABatchOfContactMsgBoxInfo(this.nativeRef, arrayList, iGetMsgsBoxesCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getAioFirstViewLatestMsgs(Contact contact, int i3, IGetAioFirstViewLatestMsgCallback iGetAioFirstViewLatestMsgCallback) {
            native_getAioFirstViewLatestMsgs(this.nativeRef, contact, i3, iGetAioFirstViewLatestMsgCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getAllOnlineFileMsgs(IMsgOperateCallback iMsgOperateCallback) {
            native_getAllOnlineFileMsgs(this.nativeRef, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public GroupAnonymousInfo getAnonymousInfo(String str) {
            return native_getAnonymousInfo(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getArkMsgConfig(GetArgMsgConfigReqInfo getArgMsgConfigReqInfo, IGetArkMsgConfigCallback iGetArkMsgConfigCallback) {
            native_getArkMsgConfig(this.nativeRef, getArgMsgConfigReqInfo, iGetArkMsgConfigCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getArkToMarkdownMsgTemplate(GetArkToMarkdownMsgTemplateReqInfo getArkToMarkdownMsgTemplateReqInfo, IGetArkToMarkdownMsgTemplateCallback iGetArkToMarkdownMsgTemplateCallback) {
            native_getArkToMarkdownMsgTemplate(this.nativeRef, getArkToMarkdownMsgTemplateReqInfo, iGetArkToMarkdownMsgTemplateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getAutoReplyTextList(IGetAutoReplyTextListCallback iGetAutoReplyTextListCallback) {
            native_getAutoReplyTextList(this.nativeRef, iGetAutoReplyTextListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getBookmarkData(String str, IBookmarkStorageGetCallback iBookmarkStorageGetCallback) {
            native_getBookmarkData(this.nativeRef, str, iBookmarkStorageGetCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getContactUnreadCnt(ArrayList<Contact> arrayList, IOperateCallback iOperateCallback) {
            native_getContactUnreadCnt(this.nativeRef, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public int getCurChatImportStatusByUin(long j3, int i3) {
            return native_getCurChatImportStatusByUin(this.nativeRef, j3, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getCurHiddenSession(IOperateHiddenSessionCallback iOperateHiddenSessionCallback) {
            native_getCurHiddenSession(this.nativeRef, iOperateHiddenSessionCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public int getDataImportUserLevel() {
            return native_getDataImportUserLevel(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getDraft(Contact contact, IGetDraftOperateCallback iGetDraftOperateCallback) {
            native_getDraft(this.nativeRef, contact, iGetDraftOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getEmojiResourcePath(int i3, IGetEmojiResourcePathCallback iGetEmojiResourcePathCallback) {
            native_getEmojiResourcePath(this.nativeRef, i3, iGetEmojiResourcePathCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getFavMarketEmoticonInfo(int i3, String str, IGetFavMarketEmoticonInfoCallback iGetFavMarketEmoticonInfoCallback) {
            native_getFavMarketEmoticonInfo(this.nativeRef, i3, str, iGetFavMarketEmoticonInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public String getFileThumbSavePath(String str, int i3, boolean z16) {
            return native_getFileThumbSavePath(this.nativeRef, str, i3, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public String getFileThumbSavePathForSend(int i3, boolean z16) {
            return native_getFileThumbSavePathForSend(this.nativeRef, i3, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getFirstUnreadAtMsg(Contact contact, IGetFirstUnreadAtMsgCallback iGetFirstUnreadAtMsgCallback) {
            native_getFirstUnreadAtMsg(this.nativeRef, contact, iGetFirstUnreadAtMsgCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getFirstUnreadAtallMsg(Contact contact, IFetchChannelLatestSeqCallback iFetchChannelLatestSeqCallback) {
            native_getFirstUnreadAtallMsg(this.nativeRef, contact, iFetchChannelLatestSeqCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getFirstUnreadAtmeMsg(Contact contact, IFetchChannelLatestSeqCallback iFetchChannelLatestSeqCallback) {
            native_getFirstUnreadAtmeMsg(this.nativeRef, contact, iFetchChannelLatestSeqCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getFirstUnreadMsgSeq(Contact contact, IGetMsgSeqCallback iGetMsgSeqCallback) {
            native_getFirstUnreadMsgSeq(this.nativeRef, contact, iGetMsgSeqCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public long getGroupMsgStorageTime() {
            return native_getGroupMsgStorageTime(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getHotPicHotWords(EmojiHotPicGetHotWordsReqBody emojiHotPicGetHotWordsReqBody, IEmojiGetHotPicHotWordsResultCallback iEmojiGetHotPicHotWordsResultCallback) {
            native_getHotPicHotWords(this.nativeRef, emojiHotPicGetHotWordsReqBody, iEmojiGetHotPicHotWordsResultCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getHotPicInfoListSearchString(String str, String str2, int i3, int i16, boolean z16, IGetHotPicInfoListCallback iGetHotPicInfoListCallback) {
            native_getHotPicInfoListSearchString(this.nativeRef, str, str2, i3, i16, z16, iGetHotPicInfoListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getHotPicJumpInfo(EmojiHotPicGetJumpInfoReqBody emojiHotPicGetJumpInfoReqBody, IEmojiHotPicGetJumpInfoResultCallback iEmojiHotPicGetJumpInfoResultCallback) {
            native_getHotPicJumpInfo(this.nativeRef, emojiHotPicGetJumpInfoReqBody, iEmojiHotPicGetJumpInfoResultCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getHotPicSearchResult(EmojiHotPicSearchReqBody emojiHotPicSearchReqBody, IEmojiGetHotPicSearchResultCallback iEmojiGetHotPicSearchResultCallback) {
            native_getHotPicSearchResult(this.nativeRef, emojiHotPicSearchReqBody, iEmojiGetHotPicSearchResultCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getKeyWordRelatedEmoji(KeyWordRelatedEmojiInfo keyWordRelatedEmojiInfo, IOperateCallback iOperateCallback) {
            native_getKeyWordRelatedEmoji(this.nativeRef, keyWordRelatedEmojiInfo, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getLastMessageList(ArrayList<Contact> arrayList, IMsgOperateCallback iMsgOperateCallback) {
            native_getLastMessageList(this.nativeRef, arrayList, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getLatestDbMsgs(Contact contact, int i3, IMsgOperateCallback iMsgOperateCallback) {
            native_getLatestDbMsgs(this.nativeRef, contact, i3, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMarketEmoticonEncryptKeys(int i3, ArrayList<String> arrayList, IGetMarketEmoticonEncryptKeysCallback iGetMarketEmoticonEncryptKeysCallback) {
            native_getMarketEmoticonEncryptKeys(this.nativeRef, i3, arrayList, iGetMarketEmoticonEncryptKeysCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMarketEmoticonPath(int i3, ArrayList<String> arrayList, MarketEmojiPathServiceType marketEmojiPathServiceType, IGetMarketEmoticonPathCallback iGetMarketEmoticonPathCallback) {
            native_getMarketEmoticonPath(this.nativeRef, i3, arrayList, marketEmojiPathServiceType, iGetMarketEmoticonPathCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public HashMap<String, MarketEmoticonPath> getMarketEmoticonPathBySync(int i3, ArrayList<String> arrayList, MarketEmojiPathServiceType marketEmojiPathServiceType) {
            return native_getMarketEmoticonPathBySync(this.nativeRef, i3, arrayList, marketEmojiPathServiceType);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMiscData(String str, IGProMiscStorageGetCallback iGProMiscStorageGetCallback) {
            native_getMiscData(this.nativeRef, str, iGProMiscStorageGetCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMiscDataVer2(MiscKeyInfo miscKeyInfo, IGetMiscDataCallback iGetMiscDataCallback) {
            native_getMiscDataVer2(this.nativeRef, miscKeyInfo, iGetMiscDataCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMqqDataImportTableNames(IDataImportTableNamesCallback iDataImportTableNamesCallback) {
            native_getMqqDataImportTableNames(this.nativeRef, iDataImportTableNamesCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMsgAbstract(Contact contact, long j3, IGetMsgAbstractsCallback iGetMsgAbstractsCallback) {
            native_getMsgAbstract(this.nativeRef, contact, j3, iGetMsgAbstractsCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMsgByClientSeqAndTime(Contact contact, long j3, long j16, IMsgOperateCallback iMsgOperateCallback) {
            native_getMsgByClientSeqAndTime(this.nativeRef, contact, j3, j16, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMsgEmojiLikesList(Contact contact, long j3, String str, long j16, String str2, boolean z16, int i3, IGetMsgEmojiLikesListCallback iGetMsgEmojiLikesListCallback) {
            native_getMsgEmojiLikesList(this.nativeRef, contact, j3, str, j16, str2, z16, i3, iGetMsgEmojiLikesListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMsgEventFlow(Contact contact) {
            native_getMsgEventFlow(this.nativeRef, contact);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMsgQRCode(IGetMsgQRCodeCallback iGetMsgQRCodeCallback) {
            native_getMsgQRCode(this.nativeRef, iGetMsgQRCodeCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMsgSetting(IOperateCallback iOperateCallback) {
            native_getMsgSetting(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMsgWithAbstractByFilterParam(Contact contact, long j3, long j16, int i3, MsgFilterParams msgFilterParams, IGetMsgWithAbstractCallback iGetMsgWithAbstractCallback) {
            native_getMsgWithAbstractByFilterParam(this.nativeRef, contact, j3, j16, i3, msgFilterParams, iGetMsgWithAbstractCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMsgs(Contact contact, long j3, int i3, boolean z16, IMsgOperateCallback iMsgOperateCallback) {
            native_getMsgs(this.nativeRef, contact, j3, i3, z16, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMsgsByMsgId(Contact contact, ArrayList<Long> arrayList, IMsgOperateCallback iMsgOperateCallback) {
            native_getMsgsByMsgId(this.nativeRef, contact, arrayList, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMsgsBySeqAndCount(Contact contact, long j3, int i3, boolean z16, boolean z17, IMsgOperateCallback iMsgOperateCallback) {
            native_getMsgsBySeqAndCount(this.nativeRef, contact, j3, i3, z16, z17, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMsgsByTypeFilter(Contact contact, long j3, ArrayList<MsgTypeFilter> arrayList, int i3, boolean z16, IMsgOperateCallback iMsgOperateCallback) {
            native_getMsgsByTypeFilter(this.nativeRef, contact, j3, arrayList, i3, z16, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMsgsByTypeFilters(Contact contact, long j3, int i3, boolean z16, ArrayList<MsgTypeFilter> arrayList, IMsgOperateCallback iMsgOperateCallback) {
            native_getMsgsByTypeFilters(this.nativeRef, contact, j3, i3, z16, arrayList, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMsgsExt(MsgsReq msgsReq, IMsgsRspOperateCallback iMsgsRspOperateCallback) {
            native_getMsgsExt(this.nativeRef, msgsReq, iMsgsRspOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMsgsIncludeSelf(Contact contact, long j3, int i3, boolean z16, IMsgOperateCallback iMsgOperateCallback) {
            native_getMsgsIncludeSelf(this.nativeRef, contact, j3, i3, z16, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMsgsWithMsgTimeAndClientSeqForC2C(Contact contact, long j3, long j16, int i3, boolean z16, boolean z17, boolean z18, IMsgOperateCallback iMsgOperateCallback) {
            native_getMsgsWithMsgTimeAndClientSeqForC2C(this.nativeRef, contact, j3, j16, i3, z16, z17, z18, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMsgsWithStatus(GetMsgsAndStatusRecord getMsgsAndStatusRecord, IGetMsgWithStatusCallback iGetMsgWithStatusCallback) {
            native_getMsgsWithStatus(this.nativeRef, getMsgsAndStatusRecord, iGetMsgWithStatusCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getMultiMsg(Contact contact, long j3, long j16, IGetMultiMsgCallback iGetMultiMsgCallback) {
            native_getMultiMsg(this.nativeRef, contact, j3, j16, iGetMultiMsgCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getNtMsgSyncContactUnreadState(IGetNtMsgSyncContactUnreadStateCallback iGetNtMsgSyncContactUnreadStateCallback) {
            native_getNtMsgSyncContactUnreadState(this.nativeRef, iGetNtMsgSyncContactUnreadStateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getOnLineDev(IOperateCallback iOperateCallback) {
            native_getOnLineDev(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getOnlineFileMsgs(Contact contact, IMsgOperateCallback iMsgOperateCallback) {
            native_getOnlineFileMsgs(this.nativeRef, contact, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getOnlineStatusBigIconBasePath(IGetStatusMsgCallback iGetStatusMsgCallback) {
            native_getOnlineStatusBigIconBasePath(this.nativeRef, iGetStatusMsgCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getOnlineStatusCommonFileNameByUrl(String str, IGetStatusMsgCallback iGetStatusMsgCallback) {
            native_getOnlineStatusCommonFileNameByUrl(this.nativeRef, str, iGetStatusMsgCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getOnlineStatusCommonPath(String str, IGetStatusMsgCallback iGetStatusMsgCallback) {
            native_getOnlineStatusCommonPath(this.nativeRef, str, iGetStatusMsgCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getOnlineStatusSmallIconBasePath(IGetStatusMsgCallback iGetStatusMsgCallback) {
            native_getOnlineStatusSmallIconBasePath(this.nativeRef, iGetStatusMsgCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getOnlineStatusSmallIconFileNameByUrl(String str, IGetStatusMsgCallback iGetStatusMsgCallback) {
            native_getOnlineStatusSmallIconFileNameByUrl(this.nativeRef, str, iGetStatusMsgCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getRecallMsgsByMsgId(Contact contact, ArrayList<Long> arrayList, IMsgOperateCallback iMsgOperateCallback) {
            native_getRecallMsgsByMsgId(this.nativeRef, contact, arrayList, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getRecentEmojiList(int i3, IGetRecentUseEmojiListCallback iGetRecentUseEmojiListCallback) {
            native_getRecentEmojiList(this.nativeRef, i3, iGetRecentUseEmojiListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getRecentHiddenSesionList(IOperateHiddenSessionCallback iOperateHiddenSessionCallback) {
            native_getRecentHiddenSesionList(this.nativeRef, iOperateHiddenSessionCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getRecentUseEmojiList(IGetRecentUseEmojiListCallback iGetRecentUseEmojiListCallback) {
            native_getRecentUseEmojiList(this.nativeRef, iGetRecentUseEmojiListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getRecentUsedFaceList(int i3, IGetRecentUsedFaceListCallback iGetRecentUsedFaceListCallback) {
            native_getRecentUsedFaceList(this.nativeRef, i3, iGetRecentUsedFaceListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getReplyDraft(Contact contact, long j3, IGetDraftOperateCallback iGetDraftOperateCallback) {
            native_getReplyDraft(this.nativeRef, contact, j3, iGetDraftOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getRichMediaElement(RichMediaElementGetReq richMediaElementGetReq) {
            native_getRichMediaElement(this.nativeRef, richMediaElementGetReq);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public String getRichMediaFilePathForGuild(RichMediaFilePathInfo richMediaFilePathInfo) {
            return native_getRichMediaFilePathForGuild(this.nativeRef, richMediaFilePathInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public String getRichMediaFilePathForMobileQQSend(RichMediaFilePathInfo richMediaFilePathInfo) {
            return native_getRichMediaFilePathForMobileQQSend(this.nativeRef, richMediaFilePathInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getServiceAssistantSwitch(GetServiceAssistantSwitchReq getServiceAssistantSwitchReq, IGetServiceAssistantSwitchCallback iGetServiceAssistantSwitchCallback) {
            native_getServiceAssistantSwitch(this.nativeRef, getServiceAssistantSwitchReq, iGetServiceAssistantSwitchCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getSingleMsg(Contact contact, long j3, IMsgOperateCallback iMsgOperateCallback) {
            native_getSingleMsg(this.nativeRef, contact, j3, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getSourceOfReplyMsg(Contact contact, long j3, long j16, IMsgOperateCallback iMsgOperateCallback) {
            native_getSourceOfReplyMsg(this.nativeRef, contact, j3, j16, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getSourceOfReplyMsgByClientSeqAndTime(Contact contact, long j3, long j16, long j17, IMsgOperateCallback iMsgOperateCallback) {
            native_getSourceOfReplyMsgByClientSeqAndTime(this.nativeRef, contact, j3, j16, j17, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getSourceOfReplyMsgV2(Contact contact, long j3, long j16, IMsgOperateCallback iMsgOperateCallback) {
            native_getSourceOfReplyMsgV2(this.nativeRef, contact, j3, j16, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void getTempChatInfo(int i3, String str, IGetTempChatInfoCallback iGetTempChatInfoCallback) {
            native_getTempChatInfo(this.nativeRef, i3, str, iGetTempChatInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void grabRedBag(GrabRedBagReq grabRedBagReq, IGrabRedBagCallback iGrabRedBagCallback) {
            native_grabRedBag(this.nativeRef, grabRedBagReq, iGrabRedBagCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void importDataLineMsg() {
            native_importDataLineMsg(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void importOldDbMsg(IOperateCallback iOperateCallback) {
            native_importOldDbMsg(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void insertMsgToMsgBox(Contact contact, long j3, int i3, IOperateCallback iOperateCallback) {
            native_insertMsgToMsgBox(this.nativeRef, contact, j3, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void isHitEmojiKeyword(RelatedEmotionWordsInfo relatedEmotionWordsInfo, IOperateCallback iOperateCallback) {
            native_isHitEmojiKeyword(this.nativeRef, relatedEmotionWordsInfo, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void isMqqDataImportFinished(IOperateCallback iOperateCallback) {
            native_isMqqDataImportFinished(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void isMsgMatched(MatchKey matchKey, IMatchedOperateCallback iMatchedOperateCallback) {
            native_isMsgMatched(this.nativeRef, matchKey, iMatchedOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void kickOffLine(DevInfo devInfo, IOperateCallback iOperateCallback) {
            native_kickOffLine(this.nativeRef, devInfo, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void likeOrDislikeReportForMsg(Contact contact, FeedBackMsgInfo feedBackMsgInfo, FeedBackDataForMsg feedBackDataForMsg, IOperateCallback iOperateCallback) {
            native_likeOrDislikeReportForMsg(this.nativeRef, contact, feedBackMsgInfo, feedBackDataForMsg, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void modifyBottomEmojiTableSwitchStatus(ModifyBottomEmojiTableSwitchStatusReq modifyBottomEmojiTableSwitchStatusReq, IModifyBottomEmojiTableSwitchStatusCallback iModifyBottomEmojiTableSwitchStatusCallback) {
            native_modifyBottomEmojiTableSwitchStatus(this.nativeRef, modifyBottomEmojiTableSwitchStatusReq, iModifyBottomEmojiTableSwitchStatusCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void modifyFavEmojiDesc(ArrayList<EmojiDescInfo> arrayList, IModifyFavEmojiDescCallback iModifyFavEmojiDescCallback) {
            native_modifyFavEmojiDesc(this.nativeRef, arrayList, iModifyFavEmojiDescCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void moveBottomEmojiTable(MoveBottomEmojiTableReq moveBottomEmojiTableReq, IMoveBottomEmojiTableCallback iMoveBottomEmojiTableCallback) {
            native_moveBottomEmojiTable(this.nativeRef, moveBottomEmojiTableReq, iMoveBottomEmojiTableCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void multiForwardMsg(ArrayList<MultiMsgInfo> arrayList, Contact contact, Contact contact2, IOperateCallback iOperateCallback) {
            native_multiForwardMsg(this.nativeRef, arrayList, contact, contact2, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void multiForwardMsgWithComment(ArrayList<MultiMsgInfo> arrayList, Contact contact, Contact contact2, ArrayList<MsgElement> arrayList2, HashMap<Integer, MsgAttributeInfo> hashMap, IOperateCallback iOperateCallback) {
            native_multiForwardMsgWithComment(this.nativeRef, arrayList, contact, contact2, arrayList2, hashMap, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void packRedBag(PackRedBagReq packRedBagReq, IPackRedBagCallback iPackRedBagCallback) {
            native_packRedBag(this.nativeRef, packRedBagReq, iPackRedBagCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void prepareTempChat(TempChatPrepareInfo tempChatPrepareInfo, IOperateCallback iOperateCallback) {
            native_prepareTempChat(this.nativeRef, tempChatPrepareInfo, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void pullDetail(PullDetailReq pullDetailReq, IPullDetailCallback iPullDetailCallback) {
            native_pullDetail(this.nativeRef, pullDetailReq, iPullDetailCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void pullRedBagPasswordList(IPullRedBagPasswordListCallback iPullRedBagPasswordListCallback) {
            native_pullRedBagPasswordList(this.nativeRef, iPullRedBagPasswordListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void queryArkInfo(QueryArkInfoReq queryArkInfoReq, IKernelQueryArkInfoCallback iKernelQueryArkInfoCallback) {
            native_queryArkInfo(this.nativeRef, queryArkInfoReq, iKernelQueryArkInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void queryCalendar(Contact contact, long j3, IQueryCalendarCallback iQueryCalendarCallback) {
            native_queryCalendar(this.nativeRef, contact, j3, iQueryCalendarCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void queryEmoticonMsgs(long j3, long j16, long j17, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback) {
            native_queryEmoticonMsgs(this.nativeRef, j3, j16, j17, queryMsgsParams, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void queryFavEmojiByDesc(String str, IFetchFavEmojiListCallback iFetchFavEmojiListCallback) {
            native_queryFavEmojiByDesc(this.nativeRef, str, iFetchFavEmojiListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void queryFileMsgsDesktop(long j3, long j16, long j17, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback) {
            native_queryFileMsgsDesktop(this.nativeRef, j3, j16, j17, queryMsgsParams, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void queryFirstMsgSeq(Contact contact, long j3, IQueryFirstMsgSeqCallback iQueryFirstMsgSeqCallback) {
            native_queryFirstMsgSeq(this.nativeRef, contact, j3, iQueryFirstMsgSeqCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void queryFirstRoamMsg(Contact contact, long j3, IQueryFirstRoamMsgCallback iQueryFirstRoamMsgCallback) {
            native_queryFirstRoamMsg(this.nativeRef, contact, j3, iQueryFirstRoamMsgCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void queryMsgsAndAbstractsWithFilter(long j3, long j16, long j17, QueryMsgsParams queryMsgsParams, IQueryMsgsAndAbstractsWithFilterCallback iQueryMsgsAndAbstractsWithFilterCallback) {
            native_queryMsgsAndAbstractsWithFilter(this.nativeRef, j3, j16, j17, queryMsgsParams, iQueryMsgsAndAbstractsWithFilterCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void queryMsgsWithFilter(long j3, long j16, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback) {
            native_queryMsgsWithFilter(this.nativeRef, j3, j16, queryMsgsParams, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void queryMsgsWithFilterEx(long j3, long j16, long j17, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback) {
            native_queryMsgsWithFilterEx(this.nativeRef, j3, j16, j17, queryMsgsParams, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void queryMsgsWithFilterVer2(long j3, long j16, QueryMsgsParams queryMsgsParams, IQueryMsgsWithFilterVer2Callback iQueryMsgsWithFilterVer2Callback) {
            native_queryMsgsWithFilterVer2(this.nativeRef, j3, j16, queryMsgsParams, iQueryMsgsWithFilterVer2Callback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void queryPicOrVideoMsgs(long j3, long j16, long j17, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback) {
            native_queryPicOrVideoMsgs(this.nativeRef, j3, j16, j17, queryMsgsParams, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void queryPicOrVideoMsgsDesktop(ChatInfo chatInfo, MsgIdInfo msgIdInfo, int i3, boolean z16, IMsgOperateCallback iMsgOperateCallback) {
            native_queryPicOrVideoMsgsDesktop(this.nativeRef, chatInfo, msgIdInfo, i3, z16, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void queryRoamCalendar(Contact contact, long j3, IQueryCalendarCallback iQueryCalendarCallback) {
            native_queryRoamCalendar(this.nativeRef, contact, j3, iQueryCalendarCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void queryShortVideoMsgs(long j3, long j16, long j17, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback) {
            native_queryShortVideoMsgs(this.nativeRef, j3, j16, j17, queryMsgsParams, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void queryTroopEmoticonMsgs(long j3, long j16, long j17, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback) {
            native_queryTroopEmoticonMsgs(this.nativeRef, j3, j16, j17, queryMsgsParams, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void queryUserSecQuality(IQueryUserSecQualityCallback iQueryUserSecQualityCallback) {
            native_queryUserSecQuality(this.nativeRef, iQueryUserSecQualityCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void recallMsg(Contact contact, ArrayList<Long> arrayList, IOperateCallback iOperateCallback) {
            native_recallMsg(this.nativeRef, contact, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void recordEmoji(RecordType recordType, ArrayList<RecordEmojiInfo> arrayList) {
            native_recordEmoji(this.nativeRef, recordType, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void reeditRecallMsg(Contact contact, long j3, IOperateCallback iOperateCallback) {
            native_reeditRecallMsg(this.nativeRef, contact, j3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void refuseGetRichMediaElement(RichMediaElementGetReq richMediaElementGetReq) {
            native_refuseGetRichMediaElement(this.nativeRef, richMediaElementGetReq);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void refuseReceiveOnlineFileMsg(Contact contact, long j3, IOperateCallback iOperateCallback) {
            native_refuseReceiveOnlineFileMsg(this.nativeRef, contact, j3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void regenerateMsg(Contact contact, long j3, IOperateCallback iOperateCallback) {
            native_regenerateMsg(this.nativeRef, contact, j3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void registerSysMsgNotification(int i3, long j3, ArrayList<Long> arrayList, IOperateCallback iOperateCallback) {
            native_registerSysMsgNotification(this.nativeRef, i3, j3, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void removeKernelMsgListener(long j3) {
            native_removeKernelMsgListener(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void removeKernelTempChatSigListener(long j3) {
            native_removeKernelTempChatSigListener(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void renameAnonyChatNick(String str, IRenameAnonymousChatNickCallback iRenameAnonymousChatNickCallback) {
            native_renameAnonyChatNick(this.nativeRef, str, iRenameAnonymousChatNickCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void replyMsgWithSourceMsgInfo(SourceMsgInfoForReplyMsg sourceMsgInfoForReplyMsg, ArrayList<MsgElement> arrayList, HashMap<Integer, MsgAttributeInfo> hashMap, IReplyMsgWithSourceMsgInfoCallback iReplyMsgWithSourceMsgInfoCallback) {
            native_replyMsgWithSourceMsgInfo(this.nativeRef, sourceMsgInfoForReplyMsg, arrayList, hashMap, iReplyMsgWithSourceMsgInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void reqToOfflineSendMsg(Contact contact, long j3, IOperateCallback iOperateCallback) {
            native_reqToOfflineSendMsg(this.nativeRef, contact, j3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void requestTianshuAdv(ArrayList<TianShuAdPosItemData> arrayList, ITianShuGetAdvCallback iTianShuGetAdvCallback) {
            native_requestTianshuAdv(this.nativeRef, arrayList, iTianShuGetAdvCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void resendMsg(Contact contact, long j3, IOperateCallback iOperateCallback) {
            native_resendMsg(this.nativeRef, contact, j3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void selectPasswordRedBag(GrabRedBagReq grabRedBagReq) {
            native_selectPasswordRedBag(this.nativeRef, grabRedBagReq);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void sendMsg(long j3, Contact contact, ArrayList<MsgElement> arrayList, HashMap<Integer, MsgAttributeInfo> hashMap, IOperateCallback iOperateCallback) {
            native_sendMsg(this.nativeRef, j3, contact, arrayList, hashMap, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void sendShowInputStatusReq(int i3, int i16, String str, IOperateCallback iOperateCallback) {
            native_sendShowInputStatusReq(this.nativeRef, i3, i16, str, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setAllC2CAndGroupMsgRead(IOperateCallback iOperateCallback) {
            native_setAllC2CAndGroupMsgRead(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setAutoReplyTextList(ArrayList<AutoReplyText> arrayList, int i3, IOperateCallback iOperateCallback) {
            native_setAutoReplyTextList(this.nativeRef, arrayList, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setBookmarkData(String str, String str2, IGProSimpleCallback iGProSimpleCallback) {
            native_setBookmarkData(this.nativeRef, str, str2, iGProSimpleCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setContactLocalTop(Contact contact, boolean z16, IOperateCallback iOperateCallback) {
            native_setContactLocalTop(this.nativeRef, contact, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setCurHiddenSession(RecentHiddenSesionInfo recentHiddenSesionInfo, IOperateCallback iOperateCallback) {
            native_setCurHiddenSession(this.nativeRef, recentHiddenSesionInfo, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setCurOnScreenMsgForMsgEvent(Contact contact, HashMap<Long, byte[]> hashMap) {
            native_setCurOnScreenMsgForMsgEvent(this.nativeRef, contact, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setDraft(Contact contact, ArrayList<MsgElement> arrayList, IOperateCallback iOperateCallback) {
            native_setDraft(this.nativeRef, contact, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setFocusOnBase(Contact contact) {
            native_setFocusOnBase(this.nativeRef, contact);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setIKernelPublicAccountAdapter(IKernelPublicAccountAdapter iKernelPublicAccountAdapter) {
            native_setIKernelPublicAccountAdapter(this.nativeRef, iKernelPublicAccountAdapter);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setIsStopKernelFetchLongMsg(boolean z16, IOperateCallback iOperateCallback) {
            native_setIsStopKernelFetchLongMsg(this.nativeRef, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setLocalMsgRead(Contact contact, IOperateCallback iOperateCallback) {
            native_setLocalMsgRead(this.nativeRef, contact, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setMarkUnreadFlag(Contact contact, boolean z16) {
            native_setMarkUnreadFlag(this.nativeRef, contact, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setMiscData(String str, String str2, IGProSimpleCallback iGProSimpleCallback) {
            native_setMiscData(this.nativeRef, str, str2, iGProSimpleCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setMiscDataVer2(MiscData miscData, IOperateCallback iOperateCallback) {
            native_setMiscDataVer2(this.nativeRef, miscData, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setMsgEmojiLikes(Contact contact, long j3, String str, long j16, boolean z16, ISetMsgEmojiLikesCallback iSetMsgEmojiLikesCallback) {
            native_setMsgEmojiLikes(this.nativeRef, contact, j3, str, j16, z16, iSetMsgEmojiLikesCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setMsgEmojiLikesForRole(Contact contact, long j3, String str, long j16, long j17, long j18, boolean z16, boolean z17, AttaReportData attaReportData, ISetMsgEmojiLikesForRoleCallback iSetMsgEmojiLikesForRoleCallback) {
            native_setMsgEmojiLikesForRole(this.nativeRef, contact, j3, str, j16, j17, j18, z16, z17, attaReportData, iSetMsgEmojiLikesForRoleCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setMsgRead(Contact contact, IOperateCallback iOperateCallback) {
            native_setMsgRead(this.nativeRef, contact, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setMsgReadAndReport(Contact contact, MsgRecord msgRecord, IOperateCallback iOperateCallback) {
            native_setMsgReadAndReport(this.nativeRef, contact, msgRecord, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setMsgReadByChatType(int i3, IOperateCallback iOperateCallback) {
            native_setMsgReadByChatType(this.nativeRef, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setMsgRichInfoFlag(boolean z16) {
            native_setMsgRichInfoFlag(this.nativeRef, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setMsgSetting(MsgSetting msgSetting, IOperateCallback iOperateCallback) {
            native_setMsgSetting(this.nativeRef, msgSetting, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setPowerStatus(boolean z16) {
            native_setPowerStatus(this.nativeRef, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setPttPlayedState(long j3, Contact contact, long j16, IOperateCallback iOperateCallback) {
            native_setPttPlayedState(this.nativeRef, j3, contact, j16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setRecentHiddenSession(ArrayList<RecentHiddenSesionInfo> arrayList, IOperateCallback iOperateCallback) {
            native_setRecentHiddenSession(this.nativeRef, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setReplyDraft(Contact contact, long j3, ArrayList<MsgElement> arrayList, IOperateCallback iOperateCallback) {
            native_setReplyDraft(this.nativeRef, contact, j3, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setServiceAssistantSwitch(SetServiceAssistantSwitchReq setServiceAssistantSwitchReq, IOperateCallback iOperateCallback) {
            native_setServiceAssistantSwitch(this.nativeRef, setServiceAssistantSwitchReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setSpecificMsgReadAndReport(Contact contact, long j3, IOperateCallback iOperateCallback) {
            native_setSpecificMsgReadAndReport(this.nativeRef, contact, j3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setStatus(StatusReq statusReq, IOperateCallback iOperateCallback) {
            native_setStatus(this.nativeRef, statusReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setSubscribeFolderUsingSmallRedPoint(boolean z16) {
            native_setSubscribeFolderUsingSmallRedPoint(this.nativeRef, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setToken(TokenInfo tokenInfo, IOperateCallback iOperateCallback) {
            native_setToken(this.nativeRef, tokenInfo, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void setTokenForMqq(byte[] bArr, IOperateCallback iOperateCallback) {
            native_setTokenForMqq(this.nativeRef, bArr, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void startMsgSync() {
            native_startMsgSync(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void stopGenerateMsg(Contact contact, long j3, IOperateCallback iOperateCallback) {
            native_stopGenerateMsg(this.nativeRef, contact, j3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void stopImportOldDbMsgAndroid() {
            native_stopImportOldDbMsgAndroid(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void switchAnonymousChat(String str, boolean z16, ISwitchAnonymousChatCallback iSwitchAnonymousChatCallback) {
            native_switchAnonymousChat(this.nativeRef, str, z16, iSwitchAnonymousChatCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void switchBackGround(BackGroundInfo backGroundInfo, IOperateCallback iOperateCallback) {
            native_switchBackGround(this.nativeRef, backGroundInfo, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void switchBackGroundForMqq(byte[] bArr, IOperateCallback iOperateCallback) {
            native_switchBackGroundForMqq(this.nativeRef, bArr, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void switchForeGround(IOperateCallback iOperateCallback) {
            native_switchForeGround(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void switchForeGroundForMqq(byte[] bArr, IOperateCallback iOperateCallback) {
            native_switchForeGroundForMqq(this.nativeRef, bArr, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void switchToOfflineGetRichMediaElement(RichMediaElementGetReq richMediaElementGetReq) {
            native_switchToOfflineGetRichMediaElement(this.nativeRef, richMediaElementGetReq);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void switchToOfflineSendMsg(Contact contact, long j3) {
            native_switchToOfflineSendMsg(this.nativeRef, contact, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void tianshuMultiReport(ArrayList<TianShuReportData> arrayList, IOperateCallback iOperateCallback) {
            native_tianshuMultiReport(this.nativeRef, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void tianshuReport(TianShuReportData tianShuReportData, IOperateCallback iOperateCallback) {
            native_tianshuReport(this.nativeRef, tianShuReportData, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void translatePtt2Text(long j3, Contact contact, MsgElement msgElement, IOperateCallback iOperateCallback) {
            native_translatePtt2Text(this.nativeRef, j3, contact, msgElement, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void translatePtt2TextAiVoice(long j3, Contact contact, MsgElement msgElement, IOperateCallback iOperateCallback) {
            native_translatePtt2TextAiVoice(this.nativeRef, j3, contact, msgElement, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void unregisterSysMsgNotification(int i3, long j3, ArrayList<Long> arrayList, IOperateCallback iOperateCallback) {
            native_unregisterSysMsgNotification(this.nativeRef, i3, j3, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void updateAnonymousInfo(String str, GroupAnonymousInfo groupAnonymousInfo) {
            native_updateAnonymousInfo(this.nativeRef, str, groupAnonymousInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void updateElementExtBufForUI(Contact contact, long j3, long j16, byte[] bArr, IOperateCallback iOperateCallback) {
            native_updateElementExtBufForUI(this.nativeRef, contact, j3, j16, bArr, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void updateMsgRecordExtPbBufForUI(Contact contact, long j3, byte[] bArr, IOperateCallback iOperateCallback) {
            native_updateMsgRecordExtPbBufForUI(this.nativeRef, contact, j3, bArr, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
        public void updatePublicAccountInfo(PublicAccountInfo publicAccountInfo, IOperateCallback iOperateCallback) {
            native_updatePublicAccountInfo(this.nativeRef, publicAccountInfo, iOperateCallback);
        }
    }

    ArrayList<Integer> GetMsgSubType(int i3, int i16);

    boolean IsC2CStyleChatType(int i3);

    boolean IsExistOldDb();

    boolean IsLocalJsonTipValid(int i3);

    boolean IsTempChatType(int i3);

    void JoinDragonGroupEmoji(JoinDragonGroupEmojiReq joinDragonGroupEmojiReq, IJoinDragonGroupCallback iJoinDragonGroupCallback);

    void addFavEmoji(AddFavEmojiReq addFavEmojiReq, IAddFavEmojiCallback iAddFavEmojiCallback);

    long addKernelMsgImportToolListener(IKernelMsgImportToolListener iKernelMsgImportToolListener);

    long addKernelMsgListener(IKernelMsgListener iKernelMsgListener);

    long addKernelTempChatSigListener(ITempChatSigListener iTempChatSigListener);

    void addLocalAVRecordMsg(Contact contact, LocalAVRecordElement localAVRecordElement, IOperateCallback iOperateCallback);

    void addLocalGrayTipMsg(Contact contact, LocalGrayTipElement localGrayTipElement, boolean z16, IOperateCallback iOperateCallback);

    void addLocalJsonGrayTipMsg(Contact contact, JsonGrayElement jsonGrayElement, boolean z16, boolean z17, IAddJsonGrayTipMsgCallback iAddJsonGrayTipMsgCallback);

    void addLocalJsonGrayTipMsgExt(Contact contact, JsonGrayMsgInfo jsonGrayMsgInfo, JsonGrayElement jsonGrayElement, boolean z16, boolean z17, IAddJsonGrayTipMsgCallback iAddJsonGrayTipMsgCallback);

    void addLocalRecordMsg(Contact contact, long j3, MsgElement msgElement, HashMap<Integer, MsgAttributeInfo> hashMap, boolean z16, IOperateCallback iOperateCallback);

    void addLocalRecordMsgWithExtInfos(Contact contact, long j3, AddLocalRecordMsgParams addLocalRecordMsgParams, IOperateCallback iOperateCallback);

    void addLocalTofuRecordMsg(Contact contact, TofuRecordElement tofuRecordElement, IOperateCallback iOperateCallback);

    void addRecentUsedFace(ArrayList<RecentUsedFace> arrayList);

    void addSendMsg(long j3, Contact contact, ArrayList<MsgElement> arrayList, HashMap<Integer, MsgAttributeInfo> hashMap);

    String assembleMobileQQRichMediaFilePath(RichMediaFilePathInfo richMediaFilePathInfo);

    void canImportOldDbMsg(ICanImportCallback iCanImportCallback);

    void canProcessDataMigration(ICanImportCallback iCanImportCallback);

    void cancelGetRichMediaElement(RichMediaElementGetReq richMediaElementGetReq);

    void cancelSendMsg(Contact contact, long j3);

    void checkMsgWithUrl(CheckUrlInfo checkUrlInfo, ICheckMsgWithUrlCallback iCheckMsgWithUrlCallback);

    void checkTabListStatus(IOperateCallback iOperateCallback);

    void clearMsgRecords(Contact contact, IClearMsgRecordsCallback iClearMsgRecordsCallback);

    void clickInlineKeyboardButton(InlineKeyboardClickInfo inlineKeyboardClickInfo, IClickInlineKeyboardButtonCallback iClickInlineKeyboardButtonCallback);

    void clickTofuActionButton(Contact contact, long j3, TofuActionButton tofuActionButton, IOperateCallback iOperateCallback);

    String createUidFromTinyId(long j3, long j16);

    void dataMigrationGetDataAvaiableContactList(IDataMigrationGetAvailableContactListCallback iDataMigrationGetAvailableContactListCallback);

    long dataMigrationGetMsgList(QueryMsgsParams queryMsgsParams, IDataMigrationGetMsgListCalback iDataMigrationGetMsgListCalback);

    String dataMigrationGetResourceLocalDestinyPath(DataMigrationResourceInfo dataMigrationResourceInfo);

    long dataMigrationImportMsgPbRecord(ArrayList<DataMigrationMsgInfo> arrayList, ArrayList<DataMigrationResourceInfo> arrayList2, ITaskFinishCallback iTaskFinishCallback);

    void dataMigrationSetIOSPathPrefix(String str);

    void dataMigrationStopOperation(long j3);

    void delMarketEmojiTab(DelMarketEmojiTabReq delMarketEmojiTabReq, IDelMarketEmojiTableCallback iDelMarketEmojiTableCallback);

    void delRecentHiddenSession(ArrayList<RecentHiddenSesionInfo> arrayList, IOperateCallback iOperateCallback);

    void deleteAllRoamMsgs(int i3, String str, IOperateCallback iOperateCallback);

    void deleteDraft(Contact contact, IOperateCallback iOperateCallback);

    void deleteFavEmoji(ArrayList<String> arrayList, IOperateCallback iOperateCallback);

    void deleteMsg(Contact contact, ArrayList<Long> arrayList, IOperateCallback iOperateCallback);

    void deleteReplyDraft(Contact contact, long j3, IOperateCallback iOperateCallback);

    void downloadEmojiPic(int i3, ArrayList<GproEmojiDownloadParams> arrayList, int i16, HashMap<String, String> hashMap);

    void downloadOnlineStatusBigIconByUrl(int i3, String str);

    void downloadOnlineStatusCommonByUrl(String str, String str2, IDownloadCommonStatusCallback iDownloadCommonStatusCallback);

    void downloadOnlineStatusSmallIconByUrl(int i3, String str);

    void downloadRichMedia(RichMediaElementGetReq richMediaElementGetReq);

    void enterOrExitAio(ArrayList<EnterOrExitAioInfo> arrayList, IOperateCallback iOperateCallback);

    void feedBackReportForMsg(Contact contact, FeedBackMsgInfo feedBackMsgInfo, FeedBackDataForMsg feedBackDataForMsg, IOperateCallback iOperateCallback);

    void fetchBottomEmojiTableList(FetchBottomEmojiTableListReq fetchBottomEmojiTableListReq, IFetchBottomEmojiTableListCallback iFetchBottomEmojiTableListCallback);

    void fetchFavEmojiList(String str, int i3, boolean z16, boolean z17, IFetchFavEmojiListCallback iFetchFavEmojiListCallback);

    void fetchGetHitEmotionsByWord(RelatedEmotionWordsInfo relatedEmotionWordsInfo, IFetchGetHitEmotionsByWordCallback iFetchGetHitEmotionsByWordCallback);

    void fetchLongMsg(Contact contact, long j3);

    void fetchLongMsgWithCb(Contact contact, long j3, IOperateCallback iOperateCallback);

    void fetchMarketEmoticonAioImage(MarketEmoticonAioImageReq marketEmoticonAioImageReq, IOperateCallback iOperateCallback);

    void fetchMarketEmoticonAuthDetail(MarketEmoticonAuthDetailReq marketEmoticonAuthDetailReq, IOperateCallback iOperateCallback);

    void fetchMarketEmoticonFaceImages(ArrayList<MarketEmoticonShowImageReq> arrayList);

    void fetchMarketEmoticonList(int i3, int i16, IFetchMarketEmoticonListCallback iFetchMarketEmoticonListCallback);

    void fetchMarketEmoticonShowImage(MarketEmoticonShowImageReq marketEmoticonShowImageReq, IOperateCallback iOperateCallback);

    void fetchMarketEmotionJsonFile(int i3, IOperateCallback iOperateCallback);

    void fetchStatusMgrInfo(IGetStatusMsgCallback iGetStatusMsgCallback);

    void fetchStatusUnitedConfigInfo(IGetStatusMsgCallback iGetStatusMsgCallback);

    void forwardFile(TargetFileInfo targetFileInfo, Contact contact, IOperateCallback iOperateCallback);

    void forwardMsg(ArrayList<Long> arrayList, Contact contact, ArrayList<Contact> arrayList2, HashMap<Integer, MsgAttributeInfo> hashMap, IForwardOperateCallback iForwardOperateCallback);

    void forwardMsgWithComment(ArrayList<Long> arrayList, Contact contact, ArrayList<Contact> arrayList2, ArrayList<MsgElement> arrayList3, HashMap<Integer, MsgAttributeInfo> hashMap, IForwardOperateCallback iForwardOperateCallback);

    void forwardRichMsgInVist(ArrayList<ForWardMsgInVisitReq> arrayList, ArrayList<Contact> arrayList2, IForwardOperateCallback iForwardOperateCallback);

    void forwardSubMsgWithComment(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, Contact contact, ArrayList<Contact> arrayList3, ArrayList<MsgElement> arrayList4, HashMap<Integer, MsgAttributeInfo> hashMap, IForwardOperateCallback iForwardOperateCallback);

    long generateMsgUniqueId(int i3, long j3);

    void getABatchOfContactMsgBoxInfo(ArrayList<Contact> arrayList, IGetMsgsBoxesCallback iGetMsgsBoxesCallback);

    void getAioFirstViewLatestMsgs(Contact contact, int i3, IGetAioFirstViewLatestMsgCallback iGetAioFirstViewLatestMsgCallback);

    void getAllOnlineFileMsgs(IMsgOperateCallback iMsgOperateCallback);

    GroupAnonymousInfo getAnonymousInfo(String str);

    void getArkMsgConfig(GetArgMsgConfigReqInfo getArgMsgConfigReqInfo, IGetArkMsgConfigCallback iGetArkMsgConfigCallback);

    void getArkToMarkdownMsgTemplate(GetArkToMarkdownMsgTemplateReqInfo getArkToMarkdownMsgTemplateReqInfo, IGetArkToMarkdownMsgTemplateCallback iGetArkToMarkdownMsgTemplateCallback);

    void getAutoReplyTextList(IGetAutoReplyTextListCallback iGetAutoReplyTextListCallback);

    void getBookmarkData(String str, IBookmarkStorageGetCallback iBookmarkStorageGetCallback);

    void getContactUnreadCnt(ArrayList<Contact> arrayList, IOperateCallback iOperateCallback);

    int getCurChatImportStatusByUin(long j3, int i3);

    void getCurHiddenSession(IOperateHiddenSessionCallback iOperateHiddenSessionCallback);

    int getDataImportUserLevel();

    void getDraft(Contact contact, IGetDraftOperateCallback iGetDraftOperateCallback);

    void getEmojiResourcePath(int i3, IGetEmojiResourcePathCallback iGetEmojiResourcePathCallback);

    void getFavMarketEmoticonInfo(int i3, String str, IGetFavMarketEmoticonInfoCallback iGetFavMarketEmoticonInfoCallback);

    String getFileThumbSavePath(String str, int i3, boolean z16);

    String getFileThumbSavePathForSend(int i3, boolean z16);

    void getFirstUnreadAtMsg(Contact contact, IGetFirstUnreadAtMsgCallback iGetFirstUnreadAtMsgCallback);

    void getFirstUnreadAtallMsg(Contact contact, IFetchChannelLatestSeqCallback iFetchChannelLatestSeqCallback);

    void getFirstUnreadAtmeMsg(Contact contact, IFetchChannelLatestSeqCallback iFetchChannelLatestSeqCallback);

    void getFirstUnreadMsgSeq(Contact contact, IGetMsgSeqCallback iGetMsgSeqCallback);

    long getGroupMsgStorageTime();

    void getHotPicHotWords(EmojiHotPicGetHotWordsReqBody emojiHotPicGetHotWordsReqBody, IEmojiGetHotPicHotWordsResultCallback iEmojiGetHotPicHotWordsResultCallback);

    void getHotPicInfoListSearchString(String str, String str2, int i3, int i16, boolean z16, IGetHotPicInfoListCallback iGetHotPicInfoListCallback);

    void getHotPicJumpInfo(EmojiHotPicGetJumpInfoReqBody emojiHotPicGetJumpInfoReqBody, IEmojiHotPicGetJumpInfoResultCallback iEmojiHotPicGetJumpInfoResultCallback);

    void getHotPicSearchResult(EmojiHotPicSearchReqBody emojiHotPicSearchReqBody, IEmojiGetHotPicSearchResultCallback iEmojiGetHotPicSearchResultCallback);

    void getKeyWordRelatedEmoji(KeyWordRelatedEmojiInfo keyWordRelatedEmojiInfo, IOperateCallback iOperateCallback);

    void getLastMessageList(ArrayList<Contact> arrayList, IMsgOperateCallback iMsgOperateCallback);

    void getLatestDbMsgs(Contact contact, int i3, IMsgOperateCallback iMsgOperateCallback);

    void getMarketEmoticonEncryptKeys(int i3, ArrayList<String> arrayList, IGetMarketEmoticonEncryptKeysCallback iGetMarketEmoticonEncryptKeysCallback);

    void getMarketEmoticonPath(int i3, ArrayList<String> arrayList, MarketEmojiPathServiceType marketEmojiPathServiceType, IGetMarketEmoticonPathCallback iGetMarketEmoticonPathCallback);

    HashMap<String, MarketEmoticonPath> getMarketEmoticonPathBySync(int i3, ArrayList<String> arrayList, MarketEmojiPathServiceType marketEmojiPathServiceType);

    void getMiscData(String str, IGProMiscStorageGetCallback iGProMiscStorageGetCallback);

    void getMiscDataVer2(MiscKeyInfo miscKeyInfo, IGetMiscDataCallback iGetMiscDataCallback);

    void getMqqDataImportTableNames(IDataImportTableNamesCallback iDataImportTableNamesCallback);

    void getMsgAbstract(Contact contact, long j3, IGetMsgAbstractsCallback iGetMsgAbstractsCallback);

    void getMsgByClientSeqAndTime(Contact contact, long j3, long j16, IMsgOperateCallback iMsgOperateCallback);

    void getMsgEmojiLikesList(Contact contact, long j3, String str, long j16, String str2, boolean z16, int i3, IGetMsgEmojiLikesListCallback iGetMsgEmojiLikesListCallback);

    void getMsgEventFlow(Contact contact);

    void getMsgQRCode(IGetMsgQRCodeCallback iGetMsgQRCodeCallback);

    void getMsgSetting(IOperateCallback iOperateCallback);

    void getMsgWithAbstractByFilterParam(Contact contact, long j3, long j16, int i3, MsgFilterParams msgFilterParams, IGetMsgWithAbstractCallback iGetMsgWithAbstractCallback);

    void getMsgs(Contact contact, long j3, int i3, boolean z16, IMsgOperateCallback iMsgOperateCallback);

    void getMsgsByMsgId(Contact contact, ArrayList<Long> arrayList, IMsgOperateCallback iMsgOperateCallback);

    void getMsgsBySeqAndCount(Contact contact, long j3, int i3, boolean z16, boolean z17, IMsgOperateCallback iMsgOperateCallback);

    void getMsgsByTypeFilter(Contact contact, long j3, ArrayList<MsgTypeFilter> arrayList, int i3, boolean z16, IMsgOperateCallback iMsgOperateCallback);

    void getMsgsByTypeFilters(Contact contact, long j3, int i3, boolean z16, ArrayList<MsgTypeFilter> arrayList, IMsgOperateCallback iMsgOperateCallback);

    void getMsgsExt(MsgsReq msgsReq, IMsgsRspOperateCallback iMsgsRspOperateCallback);

    void getMsgsIncludeSelf(Contact contact, long j3, int i3, boolean z16, IMsgOperateCallback iMsgOperateCallback);

    void getMsgsWithMsgTimeAndClientSeqForC2C(Contact contact, long j3, long j16, int i3, boolean z16, boolean z17, boolean z18, IMsgOperateCallback iMsgOperateCallback);

    void getMsgsWithStatus(GetMsgsAndStatusRecord getMsgsAndStatusRecord, IGetMsgWithStatusCallback iGetMsgWithStatusCallback);

    void getMultiMsg(Contact contact, long j3, long j16, IGetMultiMsgCallback iGetMultiMsgCallback);

    void getNtMsgSyncContactUnreadState(IGetNtMsgSyncContactUnreadStateCallback iGetNtMsgSyncContactUnreadStateCallback);

    void getOnLineDev(IOperateCallback iOperateCallback);

    void getOnlineFileMsgs(Contact contact, IMsgOperateCallback iMsgOperateCallback);

    void getOnlineStatusBigIconBasePath(IGetStatusMsgCallback iGetStatusMsgCallback);

    void getOnlineStatusCommonFileNameByUrl(String str, IGetStatusMsgCallback iGetStatusMsgCallback);

    void getOnlineStatusCommonPath(String str, IGetStatusMsgCallback iGetStatusMsgCallback);

    void getOnlineStatusSmallIconBasePath(IGetStatusMsgCallback iGetStatusMsgCallback);

    void getOnlineStatusSmallIconFileNameByUrl(String str, IGetStatusMsgCallback iGetStatusMsgCallback);

    void getRecallMsgsByMsgId(Contact contact, ArrayList<Long> arrayList, IMsgOperateCallback iMsgOperateCallback);

    void getRecentEmojiList(int i3, IGetRecentUseEmojiListCallback iGetRecentUseEmojiListCallback);

    void getRecentHiddenSesionList(IOperateHiddenSessionCallback iOperateHiddenSessionCallback);

    void getRecentUseEmojiList(IGetRecentUseEmojiListCallback iGetRecentUseEmojiListCallback);

    void getRecentUsedFaceList(int i3, IGetRecentUsedFaceListCallback iGetRecentUsedFaceListCallback);

    void getReplyDraft(Contact contact, long j3, IGetDraftOperateCallback iGetDraftOperateCallback);

    void getRichMediaElement(RichMediaElementGetReq richMediaElementGetReq);

    String getRichMediaFilePathForGuild(RichMediaFilePathInfo richMediaFilePathInfo);

    String getRichMediaFilePathForMobileQQSend(RichMediaFilePathInfo richMediaFilePathInfo);

    void getServiceAssistantSwitch(GetServiceAssistantSwitchReq getServiceAssistantSwitchReq, IGetServiceAssistantSwitchCallback iGetServiceAssistantSwitchCallback);

    void getSingleMsg(Contact contact, long j3, IMsgOperateCallback iMsgOperateCallback);

    void getSourceOfReplyMsg(Contact contact, long j3, long j16, IMsgOperateCallback iMsgOperateCallback);

    void getSourceOfReplyMsgByClientSeqAndTime(Contact contact, long j3, long j16, long j17, IMsgOperateCallback iMsgOperateCallback);

    void getSourceOfReplyMsgV2(Contact contact, long j3, long j16, IMsgOperateCallback iMsgOperateCallback);

    void getTempChatInfo(int i3, String str, IGetTempChatInfoCallback iGetTempChatInfoCallback);

    void grabRedBag(GrabRedBagReq grabRedBagReq, IGrabRedBagCallback iGrabRedBagCallback);

    void importDataLineMsg();

    void importOldDbMsg(IOperateCallback iOperateCallback);

    void insertMsgToMsgBox(Contact contact, long j3, int i3, IOperateCallback iOperateCallback);

    void isHitEmojiKeyword(RelatedEmotionWordsInfo relatedEmotionWordsInfo, IOperateCallback iOperateCallback);

    void isMqqDataImportFinished(IOperateCallback iOperateCallback);

    void isMsgMatched(MatchKey matchKey, IMatchedOperateCallback iMatchedOperateCallback);

    void kickOffLine(DevInfo devInfo, IOperateCallback iOperateCallback);

    void likeOrDislikeReportForMsg(Contact contact, FeedBackMsgInfo feedBackMsgInfo, FeedBackDataForMsg feedBackDataForMsg, IOperateCallback iOperateCallback);

    void modifyBottomEmojiTableSwitchStatus(ModifyBottomEmojiTableSwitchStatusReq modifyBottomEmojiTableSwitchStatusReq, IModifyBottomEmojiTableSwitchStatusCallback iModifyBottomEmojiTableSwitchStatusCallback);

    void modifyFavEmojiDesc(ArrayList<EmojiDescInfo> arrayList, IModifyFavEmojiDescCallback iModifyFavEmojiDescCallback);

    void moveBottomEmojiTable(MoveBottomEmojiTableReq moveBottomEmojiTableReq, IMoveBottomEmojiTableCallback iMoveBottomEmojiTableCallback);

    void multiForwardMsg(ArrayList<MultiMsgInfo> arrayList, Contact contact, Contact contact2, IOperateCallback iOperateCallback);

    void multiForwardMsgWithComment(ArrayList<MultiMsgInfo> arrayList, Contact contact, Contact contact2, ArrayList<MsgElement> arrayList2, HashMap<Integer, MsgAttributeInfo> hashMap, IOperateCallback iOperateCallback);

    void packRedBag(PackRedBagReq packRedBagReq, IPackRedBagCallback iPackRedBagCallback);

    void prepareTempChat(TempChatPrepareInfo tempChatPrepareInfo, IOperateCallback iOperateCallback);

    void pullDetail(PullDetailReq pullDetailReq, IPullDetailCallback iPullDetailCallback);

    void pullRedBagPasswordList(IPullRedBagPasswordListCallback iPullRedBagPasswordListCallback);

    void queryArkInfo(QueryArkInfoReq queryArkInfoReq, IKernelQueryArkInfoCallback iKernelQueryArkInfoCallback);

    void queryCalendar(Contact contact, long j3, IQueryCalendarCallback iQueryCalendarCallback);

    void queryEmoticonMsgs(long j3, long j16, long j17, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback);

    void queryFavEmojiByDesc(String str, IFetchFavEmojiListCallback iFetchFavEmojiListCallback);

    void queryFileMsgsDesktop(long j3, long j16, long j17, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback);

    void queryFirstMsgSeq(Contact contact, long j3, IQueryFirstMsgSeqCallback iQueryFirstMsgSeqCallback);

    void queryFirstRoamMsg(Contact contact, long j3, IQueryFirstRoamMsgCallback iQueryFirstRoamMsgCallback);

    void queryMsgsAndAbstractsWithFilter(long j3, long j16, long j17, QueryMsgsParams queryMsgsParams, IQueryMsgsAndAbstractsWithFilterCallback iQueryMsgsAndAbstractsWithFilterCallback);

    void queryMsgsWithFilter(long j3, long j16, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback);

    void queryMsgsWithFilterEx(long j3, long j16, long j17, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback);

    void queryMsgsWithFilterVer2(long j3, long j16, QueryMsgsParams queryMsgsParams, IQueryMsgsWithFilterVer2Callback iQueryMsgsWithFilterVer2Callback);

    void queryPicOrVideoMsgs(long j3, long j16, long j17, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback);

    void queryPicOrVideoMsgsDesktop(ChatInfo chatInfo, MsgIdInfo msgIdInfo, int i3, boolean z16, IMsgOperateCallback iMsgOperateCallback);

    void queryRoamCalendar(Contact contact, long j3, IQueryCalendarCallback iQueryCalendarCallback);

    void queryShortVideoMsgs(long j3, long j16, long j17, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback);

    void queryTroopEmoticonMsgs(long j3, long j16, long j17, QueryMsgsParams queryMsgsParams, IMsgOperateCallback iMsgOperateCallback);

    void queryUserSecQuality(IQueryUserSecQualityCallback iQueryUserSecQualityCallback);

    void recallMsg(Contact contact, ArrayList<Long> arrayList, IOperateCallback iOperateCallback);

    void recordEmoji(RecordType recordType, ArrayList<RecordEmojiInfo> arrayList);

    void reeditRecallMsg(Contact contact, long j3, IOperateCallback iOperateCallback);

    void refuseGetRichMediaElement(RichMediaElementGetReq richMediaElementGetReq);

    void refuseReceiveOnlineFileMsg(Contact contact, long j3, IOperateCallback iOperateCallback);

    void regenerateMsg(Contact contact, long j3, IOperateCallback iOperateCallback);

    void registerSysMsgNotification(int i3, long j3, ArrayList<Long> arrayList, IOperateCallback iOperateCallback);

    void removeKernelMsgListener(long j3);

    void removeKernelTempChatSigListener(long j3);

    void renameAnonyChatNick(String str, IRenameAnonymousChatNickCallback iRenameAnonymousChatNickCallback);

    void replyMsgWithSourceMsgInfo(SourceMsgInfoForReplyMsg sourceMsgInfoForReplyMsg, ArrayList<MsgElement> arrayList, HashMap<Integer, MsgAttributeInfo> hashMap, IReplyMsgWithSourceMsgInfoCallback iReplyMsgWithSourceMsgInfoCallback);

    void reqToOfflineSendMsg(Contact contact, long j3, IOperateCallback iOperateCallback);

    void requestTianshuAdv(ArrayList<TianShuAdPosItemData> arrayList, ITianShuGetAdvCallback iTianShuGetAdvCallback);

    void resendMsg(Contact contact, long j3, IOperateCallback iOperateCallback);

    void selectPasswordRedBag(GrabRedBagReq grabRedBagReq);

    void sendMsg(long j3, Contact contact, ArrayList<MsgElement> arrayList, HashMap<Integer, MsgAttributeInfo> hashMap, IOperateCallback iOperateCallback);

    void sendShowInputStatusReq(int i3, int i16, String str, IOperateCallback iOperateCallback);

    void setAllC2CAndGroupMsgRead(IOperateCallback iOperateCallback);

    void setAutoReplyTextList(ArrayList<AutoReplyText> arrayList, int i3, IOperateCallback iOperateCallback);

    void setBookmarkData(String str, String str2, IGProSimpleCallback iGProSimpleCallback);

    void setContactLocalTop(Contact contact, boolean z16, IOperateCallback iOperateCallback);

    void setCurHiddenSession(RecentHiddenSesionInfo recentHiddenSesionInfo, IOperateCallback iOperateCallback);

    void setCurOnScreenMsgForMsgEvent(Contact contact, HashMap<Long, byte[]> hashMap);

    void setDraft(Contact contact, ArrayList<MsgElement> arrayList, IOperateCallback iOperateCallback);

    void setFocusOnBase(Contact contact);

    void setIKernelPublicAccountAdapter(IKernelPublicAccountAdapter iKernelPublicAccountAdapter);

    void setIsStopKernelFetchLongMsg(boolean z16, IOperateCallback iOperateCallback);

    void setLocalMsgRead(Contact contact, IOperateCallback iOperateCallback);

    void setMarkUnreadFlag(Contact contact, boolean z16);

    void setMiscData(String str, String str2, IGProSimpleCallback iGProSimpleCallback);

    void setMiscDataVer2(MiscData miscData, IOperateCallback iOperateCallback);

    void setMsgEmojiLikes(Contact contact, long j3, String str, long j16, boolean z16, ISetMsgEmojiLikesCallback iSetMsgEmojiLikesCallback);

    void setMsgEmojiLikesForRole(Contact contact, long j3, String str, long j16, long j17, long j18, boolean z16, boolean z17, AttaReportData attaReportData, ISetMsgEmojiLikesForRoleCallback iSetMsgEmojiLikesForRoleCallback);

    void setMsgRead(Contact contact, IOperateCallback iOperateCallback);

    void setMsgReadAndReport(Contact contact, MsgRecord msgRecord, IOperateCallback iOperateCallback);

    void setMsgReadByChatType(int i3, IOperateCallback iOperateCallback);

    void setMsgRichInfoFlag(boolean z16);

    void setMsgSetting(MsgSetting msgSetting, IOperateCallback iOperateCallback);

    void setPowerStatus(boolean z16);

    void setPttPlayedState(long j3, Contact contact, long j16, IOperateCallback iOperateCallback);

    void setRecentHiddenSession(ArrayList<RecentHiddenSesionInfo> arrayList, IOperateCallback iOperateCallback);

    void setReplyDraft(Contact contact, long j3, ArrayList<MsgElement> arrayList, IOperateCallback iOperateCallback);

    void setServiceAssistantSwitch(SetServiceAssistantSwitchReq setServiceAssistantSwitchReq, IOperateCallback iOperateCallback);

    void setSpecificMsgReadAndReport(Contact contact, long j3, IOperateCallback iOperateCallback);

    void setStatus(StatusReq statusReq, IOperateCallback iOperateCallback);

    void setSubscribeFolderUsingSmallRedPoint(boolean z16);

    void setToken(TokenInfo tokenInfo, IOperateCallback iOperateCallback);

    void setTokenForMqq(byte[] bArr, IOperateCallback iOperateCallback);

    void startMsgSync();

    void stopGenerateMsg(Contact contact, long j3, IOperateCallback iOperateCallback);

    void stopImportOldDbMsgAndroid();

    void switchAnonymousChat(String str, boolean z16, ISwitchAnonymousChatCallback iSwitchAnonymousChatCallback);

    void switchBackGround(BackGroundInfo backGroundInfo, IOperateCallback iOperateCallback);

    void switchBackGroundForMqq(byte[] bArr, IOperateCallback iOperateCallback);

    void switchForeGround(IOperateCallback iOperateCallback);

    void switchForeGroundForMqq(byte[] bArr, IOperateCallback iOperateCallback);

    void switchToOfflineGetRichMediaElement(RichMediaElementGetReq richMediaElementGetReq);

    void switchToOfflineSendMsg(Contact contact, long j3);

    void tianshuMultiReport(ArrayList<TianShuReportData> arrayList, IOperateCallback iOperateCallback);

    void tianshuReport(TianShuReportData tianShuReportData, IOperateCallback iOperateCallback);

    void translatePtt2Text(long j3, Contact contact, MsgElement msgElement, IOperateCallback iOperateCallback);

    void translatePtt2TextAiVoice(long j3, Contact contact, MsgElement msgElement, IOperateCallback iOperateCallback);

    void unregisterSysMsgNotification(int i3, long j3, ArrayList<Long> arrayList, IOperateCallback iOperateCallback);

    void updateAnonymousInfo(String str, GroupAnonymousInfo groupAnonymousInfo);

    void updateElementExtBufForUI(Contact contact, long j3, long j16, byte[] bArr, IOperateCallback iOperateCallback);

    void updateMsgRecordExtPbBufForUI(Contact contact, long j3, byte[] bArr, IOperateCallback iOperateCallback);

    void updatePublicAccountInfo(PublicAccountInfo publicAccountInfo, IOperateCallback iOperateCallback);
}

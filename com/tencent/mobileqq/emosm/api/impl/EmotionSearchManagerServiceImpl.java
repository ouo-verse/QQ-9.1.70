package com.tencent.mobileqq.emosm.api.impl;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.an;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.hotpicmsg.HotPicMsg$GetImgInfoRsp;
import com.tencent.pb.hotpicmsg.HotPicMsg$ImgInfo;
import com.tencent.pb.hotpicmsg.HotPicMsg$RspBody;
import com.tencent.pb.hotpicmsg.HotPicMsg$ThirdPartyInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicAioType;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicGetHotWordsReqBody;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicGetHotWordsRspBody;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicHotWordsItem;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchReqBody;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchRspBody;
import com.tencent.qqnt.kernel.nativeinterface.HotPicInfo;
import com.tencent.qqnt.kernel.nativeinterface.IEmojiGetHotPicHotWordsResultCallback;
import com.tencent.qqnt.kernel.nativeinterface.IEmojiGetHotPicSearchResultCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetHotPicInfoListCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public class EmotionSearchManagerServiceImpl implements IEmotionSearchManagerService {
    public static final String TAG = "EmotionSearchManager";
    volatile IEmotionSearchManagerService.EmotionSearchTask currentCompositeTask;
    volatile IEmotionSearchManagerService.EmotionSearchTask currentSearchingTask;
    WeakReference<IEmotionSearchManagerService.EmotionSearchResult> hotPicResultWR;
    volatile IEmotionSearchManagerService.EmotionSearchTask lastCompositeTask;
    volatile IEmotionSearchManagerService.EmotionSearchTask lastSearchTask;
    BaseQQAppInterface mApp;
    IEmotionSearchManagerService.a searchCallBack;
    List<EmotionSearchItem> emotionSearchItems = new ArrayList();
    List<EmotionSearchItem> emotionSearchTopItems = new ArrayList();
    List<EmotionSearchItem> emotionCompositeItems = new ArrayList();
    private Object statusLock = new Object();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements IEmojiGetHotPicHotWordsResultCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IEmotionSearchManagerService.b f204189a;

        a(IEmotionSearchManagerService.b bVar) {
            this.f204189a = bVar;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IEmojiGetHotPicHotWordsResultCallback
        public void onResult(int i3, String str, EmojiHotPicGetHotWordsRspBody emojiHotPicGetHotWordsRspBody) {
            int i16;
            ArrayList<EmojiHotPicHotWordsItem> arrayList;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getHotPicHotWords result:");
            sb5.append(i3);
            sb5.append(", errMsg:");
            sb5.append(str);
            sb5.append(", hotWords size:");
            if (emojiHotPicGetHotWordsRspBody != null) {
                i16 = emojiHotPicGetHotWordsRspBody.items.size();
            } else {
                i16 = 0;
            }
            sb5.append(i16);
            QLog.i(EmotionSearchManagerServiceImpl.TAG, 1, sb5.toString());
            if (i3 == 0 && emojiHotPicGetHotWordsRspBody != null && (arrayList = emojiHotPicGetHotWordsRspBody.items) != null) {
                this.f204189a.onResult(arrayList);
            } else {
                this.f204189a.onResult(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements IGetHotPicInfoListCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IEmotionSearchManagerService.EmotionSearchTask f204191a;

        b(IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask) {
            this.f204191a = emotionSearchTask;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetHotPicInfoListCallback
        public void onGetHotPicInfoList(int i3, String str, ArrayList<HotPicInfo> arrayList) {
            QLog.i(EmotionSearchManagerServiceImpl.TAG, 1, "getHotPicInfoListSearchString result:" + i3 + " errMsg:" + str);
            EmotionSearchManagerServiceImpl emotionSearchManagerServiceImpl = EmotionSearchManagerServiceImpl.this;
            IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask = this.f204191a;
            int i16 = emotionSearchTask.taskType;
            String str2 = emotionSearchTask.searchKeyWords;
            if (str2 == null) {
                str2 = "";
            }
            emotionSearchManagerServiceImpl.handleGetHotPicInfoListSearchString(i3, arrayList, i16, str2);
        }
    }

    private IEmotionSearchManagerService.EmotionSearchTask getCurrentTask(int i3) {
        return getCurrentTask(i3 == 2);
    }

    @NonNull
    private EmojiHotPicSearchReqBody getEmojiHotPicSearchReqBody(IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask, int i3) {
        int i16;
        EmojiHotPicSearchReqBody emojiHotPicSearchReqBody = new EmojiHotPicSearchReqBody();
        emojiHotPicSearchReqBody.srcUin = this.mApp.getLongAccountUin();
        String str = emotionSearchTask.searchKeyWords;
        if (str == null) {
            str = "";
        }
        emojiHotPicSearchReqBody.userText = str;
        emojiHotPicSearchReqBody.pageSize = i3;
        emojiHotPicSearchReqBody.pageIndex = 0;
        emojiHotPicSearchReqBody.sessionInfo = emotionSearchTask.sessionInfo;
        emojiHotPicSearchReqBody.sceneType = emotionSearchTask.sceneType;
        emojiHotPicSearchReqBody.aioType = emotionSearchTask.aioType;
        emojiHotPicSearchReqBody.guestUid = emotionSearchTask.guestUid;
        emojiHotPicSearchReqBody.groupCode = emotionSearchTask.groupCode;
        emojiHotPicSearchReqBody.guildID = emotionSearchTask.guildId;
        emojiHotPicSearchReqBody.channelID = emotionSearchTask.channelId;
        emojiHotPicSearchReqBody.isSupportCompose = emotionSearchTask.isSupportCompose;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("emoticon_search_support_mall_124908873", true);
        QLog.i(TAG, 1, "emoticon_search_support_mall_124908873" + isSwitchOn + ", task.isSupportMall:" + emotionSearchTask.isSupportMall);
        if (isSwitchOn && emotionSearchTask.isSupportMall) {
            if (emojiHotPicSearchReqBody.aioType == EmojiHotPicAioType.KC2C.ordinal() || emojiHotPicSearchReqBody.aioType == EmojiHotPicAioType.KGROUP.ordinal() || emojiHotPicSearchReqBody.aioType == EmojiHotPicAioType.KDISCUSS.ordinal() || emojiHotPicSearchReqBody.aioType == EmojiHotPicAioType.KTEMPORARY.ordinal() || (i16 = emotionSearchTask.chatType) == 104 || i16 == 119) {
                emojiHotPicSearchReqBody.isSupportMall = true;
            }
        } else {
            emojiHotPicSearchReqBody.isSupportMall = false;
        }
        return emojiHotPicSearchReqBody;
    }

    private List<EmotionSearchItem> getResultEmotionSearchItems(int i3, int i16) {
        boolean z16;
        List<EmotionSearchItem> list;
        int i17 = 0;
        if (i3 == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            list = this.emotionCompositeItems;
        } else {
            list = this.emotionSearchItems;
        }
        if (i16 == 0 && i3 != 0) {
            if (!z16 && this.emotionSearchTopItems.size() > 0) {
                int size = this.emotionSearchTopItems.size();
                while (i17 < this.emotionSearchTopItems.size()) {
                    EmotionSearchItem emotionSearchItem = this.emotionSearchTopItems.get(i17);
                    if (emotionSearchItem.picIndex != i17) {
                        emotionSearchItem.picIndex = i17;
                    }
                    i17++;
                }
                i17 = size;
            }
            while (i17 < list.size()) {
                EmotionSearchItem emotionSearchItem2 = list.get(i17);
                if (emotionSearchItem2.picIndex != i17) {
                    emotionSearchItem2.picIndex = i17;
                }
                i17++;
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void handleGetHotPicInfoListSearchString(int i3, ArrayList<HotPicInfo> arrayList, int i16, String str) {
        int i17;
        IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask = this.currentSearchingTask;
        if (emotionSearchTask == null) {
            QLog.e(TAG, 1, "handleGetHotPicInfoListSearchString currentSearchingTask is null");
            return;
        }
        if (!emotionSearchTask.checkIsThisTask(i16, str)) {
            QLog.e(TAG, 1, "handleGetHotPicInfoListSearchString resp not current task current");
            return;
        }
        if (i3 != -5) {
            if (i3 != 0) {
                i17 = -100;
            } else {
                i17 = 0;
            }
        } else {
            i17 = -104;
        }
        int i18 = i17;
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<HotPicInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(an.f306578a.b(it.next()));
            }
            handleResponseData(emotionSearchTask, arrayList2, null, 0, false);
            return;
        }
        handleResponseData(emotionSearchTask, arrayList2, null, i18, false);
    }

    private synchronized void handleGetHotPicSearchResult(int i3, EmojiHotPicSearchRspBody emojiHotPicSearchRspBody, int i16, String str) {
        int i17;
        boolean z16;
        ArrayList<EmojiHotPicSearchEmojiInfo> arrayList;
        boolean z17;
        IEmotionSearchManagerService.EmotionSearchTask currentTask = getCurrentTask(i16);
        if (currentTask == null) {
            QLog.e(TAG, 1, "handleGetHotPicSearchResult currentSearchingTask is null");
            return;
        }
        if (!currentTask.checkIsThisTask(i16, str)) {
            QLog.e(TAG, 1, "handleGetHotPicSearchResult resp not current task current");
            return;
        }
        if (i3 == 0) {
            i17 = 0;
        } else {
            i17 = -100;
        }
        if (i16 == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        ArrayList<EmojiHotPicSearchEmojiInfo> arrayList2 = null;
        if (z16) {
            if (emojiHotPicSearchRspBody != null) {
                arrayList = emojiHotPicSearchRspBody.getComposeEmojis();
            } else {
                arrayList = new ArrayList<>();
            }
        } else {
            if (emojiHotPicSearchRspBody != null) {
                arrayList = emojiHotPicSearchRspBody.getInfoArray();
            } else {
                arrayList = new ArrayList<>();
            }
            if (emojiHotPicSearchRspBody != null) {
                arrayList2 = emojiHotPicSearchRspBody.getComposeEmojis();
            }
        }
        if (i17 == 0) {
            IEmotionSearchManagerService.EmotionSearchTask currentTask2 = getCurrentTask(i16);
            if (emojiHotPicSearchRspBody != null) {
                currentTask2.sessionInfo = emojiHotPicSearchRspBody.getSessionInfo();
                currentTask2.hasMore = emojiHotPicSearchRspBody.getPageHasNext();
            }
        }
        ArrayList arrayList3 = new ArrayList();
        if (emojiHotPicSearchRspBody != null && emojiHotPicSearchRspBody.getAllowCompose()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<EmojiHotPicSearchEmojiInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList3.add(an.f306578a.a(it.next()));
            }
            ArrayList arrayList4 = new ArrayList();
            if (arrayList2 != null) {
                Iterator<EmojiHotPicSearchEmojiInfo> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    arrayList4.add(an.f306578a.a(it5.next()));
                }
            }
            handleResponseData(currentTask, arrayList3, arrayList4, i17, z17);
            return;
        }
        handleResponseData(currentTask, arrayList3, null, i17, z17);
    }

    private void handleResponseData(IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask, List<EmotionSearchItem> list, @Nullable List<EmotionSearchItem> list2, int i3, boolean z16) {
        int i16;
        List<EmotionSearchItem> list3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleResponsData: dataList size is ");
        if (list != null) {
            i16 = list.size();
        } else {
            i16 = 0;
        }
        sb5.append(i16);
        QLog.i(TAG, 1, sb5.toString());
        if (!isSameTask(emotionSearchTask)) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "handleResponsData requestTask not current error, requestTask = " + emotionSearchTask.taskType + "|" + emotionSearchTask.searchKeyWords);
                return;
            }
            return;
        }
        IEmotionSearchManagerService.EmotionSearchResult emotionSearchResult = new IEmotionSearchManagerService.EmotionSearchResult(i3);
        setRequestTaskHasMore(emotionSearchTask, false);
        if (i3 == 0 && list != null && list.size() > 0) {
            if (emotionSearchTask.taskType == 2) {
                list3 = this.emotionCompositeItems;
            } else {
                list3 = this.emotionSearchItems;
            }
            if (list3.size() == list.get(0).picIndex || TextUtils.isEmpty(list.get(0).picId)) {
                list3.addAll(list);
                setRequestTaskHasMore(emotionSearchTask, true);
            }
            if (list2 != null && list2.size() > 0) {
                this.emotionSearchTopItems.addAll(list2);
            }
        }
        emotionSearchResult.searchTask = emotionSearchTask;
        ArrayList<EmotionSearchItem> arrayList = new ArrayList<>();
        emotionSearchResult.itemList = arrayList;
        arrayList.addAll(getResultEmotionSearchItems(emotionSearchTask.taskType, i3));
        ArrayList<EmotionSearchItem> arrayList2 = new ArrayList<>();
        emotionSearchResult.topCompositeList = arrayList2;
        arrayList2.addAll(this.emotionSearchTopItems);
        emotionSearchResult.allowComposite = z16;
        synchronized (this.statusLock) {
            if (emotionSearchTask.taskType == 2) {
                this.lastCompositeTask = this.currentCompositeTask;
                this.currentCompositeTask = null;
            } else {
                this.lastSearchTask = this.currentSearchingTask;
                this.currentSearchingTask = null;
                if (emotionSearchTask.taskType == 0 && i3 == 0) {
                    this.hotPicResultWR = new WeakReference<>(emotionSearchResult);
                }
            }
        }
        notifySearchCallBack(emotionSearchResult);
    }

    private boolean isSameTask(IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask) {
        if (emotionSearchTask.taskType == 2) {
            return emotionSearchTask.isSame(this.currentCompositeTask);
        }
        return emotionSearchTask.isSame(this.currentSearchingTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestData$0(IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask, int i3, String str, EmojiHotPicSearchRspBody emojiHotPicSearchRspBody) {
        QLog.i(TAG, 1, "getHotPicSearchResult result:" + i3 + " errMsg:" + str);
        int i16 = emotionSearchTask.taskType;
        String str2 = emotionSearchTask.searchKeyWords;
        if (str2 == null) {
            str2 = "";
        }
        handleGetHotPicSearchResult(i3, emojiHotPicSearchRspBody, i16, str2);
    }

    private void notifySearchCallBack(IEmotionSearchManagerService.EmotionSearchResult emotionSearchResult) {
        int i3;
        String str;
        if (emotionSearchResult == null) {
            return;
        }
        IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask = emotionSearchResult.searchTask;
        if (emotionSearchTask == null) {
            i3 = 0;
        } else {
            i3 = emotionSearchTask.taskType;
        }
        if (emotionSearchTask == null) {
            str = "";
        } else {
            str = emotionSearchTask.searchKeyWords;
        }
        reportEmoSearchMonitor(emotionSearchResult.nResult, i3, str);
        IEmotionSearchManagerService.a aVar = this.searchCallBack;
        if (aVar != null) {
            aVar.onSearchCallBack(emotionSearchResult);
        }
    }

    private void requestData(final IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "requestData start");
        }
        if (emotionSearchTask == null) {
            QLog.e(TAG, 2, "requestData currentSearchingTask is null");
            return;
        }
        int i3 = emotionSearchTask.startIndex;
        int i16 = 16;
        if (i3 == 0) {
            if (emotionSearchTask.firstTimePullCount != 0) {
                i16 = 32;
            }
        } else if (emotionSearchTask.loadMorePullCount != 0) {
            i16 = 24;
        }
        int i17 = i16;
        w msgService = ((IKernelService) this.mApp.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.e(TAG, 1, "loadSearchPicData msgService is invalid!");
            return;
        }
        QLog.i(TAG, 1, "requestData: getHotPicInfoListSearchString will execute!");
        int i18 = emotionSearchTask.taskType;
        if (i18 != 1 && i18 != 2) {
            String str2 = emotionSearchTask.searchKeyWords;
            if (str2 == null) {
                str2 = "";
            }
            if (i3 == 0) {
                str = "";
            } else {
                str = this.emotionSearchItems.get(i3 - 1).picId;
            }
            msgService.getHotPicInfoListSearchString(str2, str, i17, 1, false, new b(emotionSearchTask));
            return;
        }
        msgService.getHotPicSearchResult(getEmojiHotPicSearchReqBody(emotionSearchTask, i17), new IEmojiGetHotPicSearchResultCallback() { // from class: com.tencent.mobileqq.emosm.api.impl.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IEmojiGetHotPicSearchResultCallback
            public final void onResult(int i19, String str3, EmojiHotPicSearchRspBody emojiHotPicSearchRspBody) {
                EmotionSearchManagerServiceImpl.this.lambda$requestData$0(emotionSearchTask, i19, str3, emojiHotPicSearchRspBody);
            }
        });
    }

    private void setRequestTaskHasMore(IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask, boolean z16) {
        if (emotionSearchTask.taskType == 0) {
            emotionSearchTask.hasMore = z16;
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService
    public void getHotPicTagsData(EmojiHotPicGetHotWordsReqBody emojiHotPicGetHotWordsReqBody, IEmotionSearchManagerService.b bVar) {
        w msgService = ((IKernelService) this.mApp.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.e(TAG, 1, "getHotPicTagsData msgService is invalid!");
        } else {
            QLog.i(TAG, 1, "getHotPicTagsData: getHotPicTagsData will execute!");
            msgService.getHotPicHotWords(emojiHotPicGetHotWordsReqBody, new a(bVar));
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService
    public IEmotionSearchManagerService.EmotionSearchTask getLastTask(boolean z16) {
        if (z16) {
            return this.lastCompositeTask;
        }
        return this.lastSearchTask;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService
    public IEmotionSearchManagerService.a getSearchCallBack() {
        return this.searchCallBack;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService
    public synchronized void handleResonpse(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        HotPicMsg$GetImgInfoRsp hotPicMsg$GetImgInfoRsp;
        int i16 = 0;
        int intExtra = intent.getIntExtra(IEmotionSearchManagerService.EMOTION_SEARCH_REQUEST_TYPE, 0);
        String stringExtra = intent.getStringExtra(IEmotionSearchManagerService.EMOTION_SEARCH_REQUEST_KEYWORDS);
        IEmotionSearchManagerService.EmotionSearchTask currentTask = getCurrentTask(intExtra);
        if (currentTask == null) {
            QLog.e(TAG, 2, "handleResonpse currentSearchingTask is null");
            return;
        }
        if (!currentTask.checkIsThisTask(intExtra, stringExtra)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleResonpse resp not current task current");
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (fromServiceMsg.getResultCode() == 1000) {
            int length = fromServiceMsg.getWupBuffer().length - 4;
            byte[] bArr = new byte[length];
            PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
            fromServiceMsg.putWupBuffer(bArr);
            try {
                byte[] wupBuffer = fromServiceMsg.getWupBuffer();
                HotPicMsg$RspBody hotPicMsg$RspBody = new HotPicMsg$RspBody();
                hotPicMsg$RspBody.mergeFrom(wupBuffer);
                hotPicMsg$GetImgInfoRsp = hotPicMsg$RspBody.msg_get_imginfo_rsp.get();
                try {
                } catch (InvalidProtocolBufferMicroException e16) {
                    e = e16;
                    e.printStackTrace();
                    i3 = i16;
                    handleResponseData(currentTask, arrayList, null, i3, false);
                }
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
                i16 = -100;
            }
            if (hotPicMsg$GetImgInfoRsp != null && (hotPicMsg$GetImgInfoRsp.int32_result.get() == 0 || hotPicMsg$GetImgInfoRsp.int32_result.get() == -5)) {
                int i17 = hotPicMsg$GetImgInfoRsp.uint32_build_ver.get();
                ArrayList arrayList2 = new ArrayList();
                List<HotPicMsg$ImgInfo> list = hotPicMsg$GetImgInfoRsp.rpt_msg_img_info.get();
                if (list != null && list.size() > 0) {
                    for (int i18 = 0; i18 < list.size(); i18++) {
                        HotPicMsg$ImgInfo hotPicMsg$ImgInfo = list.get(i18);
                        EmotionSearchItem emotionSearchItem = new EmotionSearchItem();
                        emotionSearchItem.version = i17;
                        emotionSearchItem.picIndex = hotPicMsg$ImgInfo.uint32_pic_index.get();
                        emotionSearchItem.fileType = hotPicMsg$ImgInfo.uint32_file_type.get();
                        emotionSearchItem.sourceType = hotPicMsg$ImgInfo.uint32_source_type.get();
                        emotionSearchItem.height = hotPicMsg$ImgInfo.uint32_thumb_file_height.get();
                        emotionSearchItem.width = hotPicMsg$ImgInfo.uint32_thumb_file_width.get();
                        emotionSearchItem.url = hotPicMsg$ImgInfo.bytes_thumb_down_url.get().toStringUtf8();
                        emotionSearchItem.md5 = hotPicMsg$ImgInfo.bytes_thumb_file_md5.get().toStringUtf8().toUpperCase();
                        emotionSearchItem.fileSize = hotPicMsg$ImgInfo.uint64_thumb_file_size.get();
                        emotionSearchItem.originalMD5 = hotPicMsg$ImgInfo.bytes_file_md5.get().toStringUtf8();
                        emotionSearchItem.originalUrl = hotPicMsg$ImgInfo.bytes_pic_down_url.get().toStringUtf8();
                        emotionSearchItem.originalHeight = hotPicMsg$ImgInfo.uint32_file_height.get();
                        emotionSearchItem.originalWidth = hotPicMsg$ImgInfo.uint32_file_width.get();
                        emotionSearchItem.oringinalSize = hotPicMsg$ImgInfo.uint64_file_size.get();
                        if (emotionSearchItem.sourceType == 3) {
                            HotPicMsg$ThirdPartyInfo hotPicMsg$ThirdPartyInfo = hotPicMsg$ImgInfo.msg_third_party_info;
                            emotionSearchItem.iconUrl = hotPicMsg$ThirdPartyInfo.bytes_icon_url.get().toStringUtf8();
                            emotionSearchItem.name = hotPicMsg$ThirdPartyInfo.bytes_name.get().toStringUtf8();
                            emotionSearchItem.jumpUrl = hotPicMsg$ThirdPartyInfo.bytes_jump_url.get().toStringUtf8();
                            emotionSearchItem.appid = hotPicMsg$ThirdPartyInfo.bytes_appid.get().toStringUtf8();
                        }
                        arrayList2.add(emotionSearchItem);
                    }
                }
                arrayList.addAll(arrayList2);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleResonpse,REQ_GET_PIC success,size:" + arrayList.size());
                }
            } else if (hotPicMsg$GetImgInfoRsp != null) {
                i16 = hotPicMsg$GetImgInfoRsp.int32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleResonpse,REQ_GET_PIC error,result:" + hotPicMsg$GetImgInfoRsp.int32_result.get());
                }
            } else {
                i16 = -100;
                i3 = i16;
            }
            i3 = i16;
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleResonpse,msg.getResultCode() error:" + fromServiceMsg.getResultCode());
            }
            i3 = -100;
        }
        handleResponseData(currentTask, arrayList, null, i3, false);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService
    public void loadMore() {
        loadMore(false);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mApp = (BaseQQAppInterface) appRuntime;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        resetData();
        this.mApp = null;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService
    public void pushEmotionSearchTask(IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask) {
        IEmotionSearchManagerService.EmotionSearchResult emotionSearchResult;
        if (emotionSearchTask == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("pushEmotionSearchTask start task = ");
            sb5.append(emotionSearchTask.taskType);
            sb5.append("|");
            String str = emotionSearchTask.searchKeyWords;
            if (str == null) {
                str = "";
            }
            sb5.append(str);
            QLog.d(TAG, 2, sb5.toString());
        }
        if (isSameTask(emotionSearchTask)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "pushEmotionSearchTask isSame task");
            }
            IEmotionSearchManagerService.EmotionSearchResult emotionSearchResult2 = new IEmotionSearchManagerService.EmotionSearchResult(-101);
            emotionSearchResult2.searchTask = emotionSearchTask;
            notifySearchCallBack(emotionSearchResult2);
            return;
        }
        synchronized (this.statusLock) {
            if (emotionSearchTask.taskType == 2) {
                this.currentCompositeTask = emotionSearchTask;
                this.emotionCompositeItems.clear();
            } else {
                this.currentSearchingTask = emotionSearchTask;
                this.emotionSearchItems.clear();
                this.emotionSearchTopItems.clear();
            }
        }
        if (emotionSearchTask.taskType == 0) {
            WeakReference<IEmotionSearchManagerService.EmotionSearchResult> weakReference = this.hotPicResultWR;
            if (weakReference != null && (emotionSearchResult = weakReference.get()) != null) {
                synchronized (this.statusLock) {
                    this.emotionSearchItems.addAll(emotionSearchResult.itemList);
                    this.lastSearchTask = this.currentSearchingTask;
                    this.currentSearchingTask = null;
                }
                reportEmoSearchCatchUseMonitor(true);
                notifySearchCallBack(emotionSearchResult);
                return;
            }
            reportEmoSearchCatchUseMonitor(false);
        }
        requestData(emotionSearchTask);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService
    public void reportEmoSearchCatchUseMonitor(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "reportEmoSearchCatchUseMonitor isUse: " + z16);
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.EMO_SEARCH_CATCH_USE_MONITOR, z16, 0L, 0L, null, null);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService
    public void reportEmoSearchMonitor(int i3, int i16, String str) {
        String str2;
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "reportEmoSearchMonitor result: " + i3);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        hashMap.put("keywords", str2);
        hashMap.put(QFSSearchBaseRequest.EXTRA_KEY_SEARCH_TYPE, i16 + "");
        hashMap.put("result", i3 + "");
        StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        statisticCollector.collectPerformance(null, StatisticCollector.EMO_SEARCH_MONITOR, z16, 0L, 0L, hashMap, null);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService
    public void resetData() {
        synchronized (this.statusLock) {
            this.lastSearchTask = null;
            this.lastCompositeTask = null;
            this.currentSearchingTask = null;
            this.currentCompositeTask = null;
            this.emotionSearchItems.clear();
            this.emotionSearchTopItems.clear();
            this.emotionCompositeItems.clear();
            this.searchCallBack = null;
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService
    public void setSearchCallBack(IEmotionSearchManagerService.a aVar) {
        this.searchCallBack = aVar;
    }

    private IEmotionSearchManagerService.EmotionSearchTask getCurrentTask(boolean z16) {
        if (z16) {
            return this.currentCompositeTask;
        }
        return this.currentSearchingTask;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService
    public void loadMore(boolean z16) {
        IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask;
        if (getCurrentTask(z16) != null) {
            notifySearchCallBack(new IEmotionSearchManagerService.EmotionSearchResult(-103));
            return;
        }
        if (getLastTask(z16) == null) {
            notifySearchCallBack(new IEmotionSearchManagerService.EmotionSearchResult(-102));
            return;
        }
        if (!getLastTask(z16).hasMore) {
            notifySearchCallBack(new IEmotionSearchManagerService.EmotionSearchResult(-104));
            return;
        }
        synchronized (this.statusLock) {
            if (z16) {
                this.currentCompositeTask = this.lastCompositeTask;
                this.currentCompositeTask.startIndex = this.emotionCompositeItems.size();
                emotionSearchTask = this.currentCompositeTask;
            } else {
                this.currentSearchingTask = this.lastSearchTask;
                this.currentSearchingTask.startIndex = this.emotionSearchItems.size();
                emotionSearchTask = this.currentSearchingTask;
            }
        }
        if (z16) {
            if (this.currentCompositeTask.sessionInfo == null || this.currentCompositeTask.sessionInfo.length == 0) {
                QLog.i(TAG, 1, "loadMore is return! currentCompositeTask.sessionInfo is empty!");
                return;
            }
        } else if (this.currentSearchingTask.taskType == 1 && (this.currentSearchingTask.sessionInfo == null || this.currentSearchingTask.sessionInfo.length == 0)) {
            QLog.i(TAG, 1, "loadMore is return! currentSearchingTask.sessionInfo is empty!");
            return;
        }
        requestData(emotionSearchTask);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService
    public void resetData(boolean z16) {
        synchronized (this.statusLock) {
            if (z16) {
                this.lastCompositeTask = null;
                this.currentCompositeTask = null;
                this.emotionCompositeItems.clear();
            } else {
                this.lastSearchTask = null;
                this.currentSearchingTask = null;
                this.emotionSearchItems.clear();
                this.emotionSearchTopItems.clear();
            }
        }
    }
}

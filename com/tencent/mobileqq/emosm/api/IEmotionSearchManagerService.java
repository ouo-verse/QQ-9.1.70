package com.tencent.mobileqq.emosm.api;

import android.content.Intent;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicAioType;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicGetHotWordsReqBody;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicHotWordsItem;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchSceneType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes6.dex */
public interface IEmotionSearchManagerService extends IRuntimeService {
    public static final String EMOTION_SEARCH_REQUEST_KEYWORDS = "EmoSearch_reqKeywords";
    public static final String EMOTION_SEARCH_REQUEST_TYPE = "EmoSearch_reqType";
    public static final String IS_FROM_EMOTION_SEARCH = "isFrom_EmoSearch";
    public static final String IS_FROM_POPUP_EMOTION_SEARCH = "isFrom_PopupEmoSearch";
    public static final int REQUEST_COUNT = 16;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class EmotionSearchResult implements Serializable {
        public boolean allowComposite;
        public ArrayList<EmotionSearchItem> itemList;
        public int nResult;
        public EmotionSearchTask searchTask;
        public ArrayList<EmotionSearchItem> topCompositeList;

        public EmotionSearchResult(int i3) {
            this.nResult = i3;
        }

        public List<EmotionSearchItem> getItemList() {
            return this.itemList;
        }

        public int getResult() {
            return this.nResult;
        }

        public List<EmotionSearchItem> getTopCompositeList() {
            return this.topCompositeList;
        }

        public boolean isHasMore() {
            EmotionSearchTask emotionSearchTask = this.searchTask;
            if (emotionSearchTask == null) {
                return false;
            }
            return emotionSearchTask.hasMore;
        }

        public void setResult(int i3) {
            this.nResult = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class EmotionSearchTask implements Serializable {
        public static final int EMOTION_SEARCH_TASK_TYPE_COMPOSITE = 2;
        public static final int EMOTION_SEARCH_TASK_TYPE_HOT_PIC = 0;
        public static final int EMOTION_SEARCH_TASK_TYPE_SEARCH = 1;
        public int aioType;
        public int buildver;
        public long channelId;
        public int chatType;
        public int firstTimePullCount;
        public long groupCode;
        public String guestUid;
        public long guildId;
        public boolean hasMore;
        public boolean isSupportCompose;
        public boolean isSupportMall;
        public int loadMorePullCount;
        public int sceneType;
        public String searchKeyWords;
        public byte[] sessionInfo;
        public int startIndex;
        public int taskType;

        public EmotionSearchTask(int i3) {
            this(i3, null);
        }

        public boolean checkIsThisTask(int i3, String str) {
            boolean z16;
            boolean equalsIgnoreCase;
            if (i3 == this.taskType) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (StringUtil.isEmpty(this.searchKeyWords)) {
                equalsIgnoreCase = StringUtil.isEmpty(str);
            } else {
                equalsIgnoreCase = this.searchKeyWords.equalsIgnoreCase(str);
            }
            if (z16 && equalsIgnoreCase) {
                return true;
            }
            return false;
        }

        public boolean isSame(EmotionSearchTask emotionSearchTask) {
            if (emotionSearchTask == null) {
                return false;
            }
            return checkIsThisTask(emotionSearchTask.taskType, emotionSearchTask.searchKeyWords);
        }

        public void setFirstTimePullCount(int i3) {
            this.firstTimePullCount = i3;
        }

        public void setHasMore(boolean z16) {
            this.hasMore = z16;
        }

        public void setLoadMorePullCount(int i3) {
            this.loadMorePullCount = i3;
        }

        public EmotionSearchTask(int i3, String str) {
            this.buildver = 0;
            this.hasMore = true;
            this.sessionInfo = null;
            this.sceneType = EmojiHotPicSearchSceneType.KUNDEFINED.ordinal();
            this.aioType = EmojiHotPicAioType.KUNDEFINED.ordinal();
            this.chatType = 0;
            this.taskType = i3;
            this.searchKeyWords = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void onSearchCallBack(EmotionSearchResult emotionSearchResult);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface b {
        void onResult(ArrayList<EmojiHotPicHotWordsItem> arrayList);
    }

    void getHotPicTagsData(EmojiHotPicGetHotWordsReqBody emojiHotPicGetHotWordsReqBody, b bVar);

    EmotionSearchTask getLastTask(boolean z16);

    a getSearchCallBack();

    void handleResonpse(Intent intent, FromServiceMsg fromServiceMsg);

    void loadMore();

    void loadMore(boolean z16);

    void pushEmotionSearchTask(EmotionSearchTask emotionSearchTask);

    void reportEmoSearchCatchUseMonitor(boolean z16);

    void reportEmoSearchMonitor(int i3, int i16, String str);

    void resetData();

    void resetData(boolean z16);

    void setSearchCallBack(a aVar);
}

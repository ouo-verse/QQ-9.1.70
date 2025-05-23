package com.tencent.mobileqq.vas.inject;

import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import java.io.Serializable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface ISignatureStatusManager {
    public static final int RESULT_ERROR = -1;
    public static final int RESULT_FILE = -3;
    public static final int RESULT_OK = 100;
    public static final int RESULT_UPDATE_LOCAL = 102;
    public static final int RESULT_UPDATE_REMOTE = 101;
    public static final int RESULT_WORD = -2;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface ISignatureStatusListener {
        void onChangeStatus(int i3, RichStatus richStatus, Object obj);

        void onGetSyncShuoShuo(int i3, boolean z16);

        void onSetSyncShuoShuo(int i3, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface ISignatureTopicObserver {
        void onGetRecommendTopic(boolean z16, int i3, List<TopicInfo> list);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class TopicInfo implements Serializable {
        public int friendNum;
        public int topicId;
        public String topicStr;
        public int totalNum;
    }

    void addRequestRecommendTopicObserver(ISignatureTopicObserver iSignatureTopicObserver);

    void addSyncShuoShuoListener(ISignatureStatusListener iSignatureStatusListener);

    boolean getSyncShuoShuo();

    VasResDrawable getVasResDrawable(int i3);

    void onDestroy();

    void removeSyncShuoShuoListener();

    void requestRecommendTopicList();

    int setSyncShuoShuo(boolean z16);
}

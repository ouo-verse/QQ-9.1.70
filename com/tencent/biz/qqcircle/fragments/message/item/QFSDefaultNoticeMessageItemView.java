package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import android.util.ArrayMap;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSCommentOrReplyMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSDiffTimeNoticeMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSFriendPushNoticeMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSKolMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSLikeMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSNewJoinMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSNumNoticeMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSPositiveFeedbackMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSPostPositiveMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSPushMoreMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSSystemMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSTopReplayMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSVisitorMessagePresenter;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSDefaultNoticeMessageItemView extends QFSBaseNoticeMessageItemView {
    private static final String TAG = "QFSDefaultNoticeMessageItemView";
    private static final Map<Integer, Class<? extends QFSBaseNoticeMessagePresenter>> sTypeToPresenter;

    static {
        ArrayMap arrayMap = new ArrayMap();
        sTypeToPresenter = arrayMap;
        arrayMap.put(3, QFSSystemMessagePresenter.class);
        arrayMap.put(25, QFSSystemMessagePresenter.class);
        arrayMap.put(0, QFSLikeMessagePresenter.class);
        arrayMap.put(7, QFSLikeMessagePresenter.class);
        arrayMap.put(6, QFSLikeMessagePresenter.class);
        arrayMap.put(24, QFSTopReplayMessagePresenter.class);
        arrayMap.put(29, QFSTopReplayMessagePresenter.class);
        arrayMap.put(8, QFSTopReplayMessagePresenter.class);
        arrayMap.put(19, QFSVisitorMessagePresenter.class);
        arrayMap.put(20, QFSVisitorMessagePresenter.class);
        arrayMap.put(22, QFSVisitorMessagePresenter.class);
        arrayMap.put(14, QFSKolMessagePresenter.class);
        arrayMap.put(31, QFSPushMoreMessagePresenter.class);
        arrayMap.put(21, QFSPostPositiveMessagePresenter.class);
        arrayMap.put(23, QFSNewJoinMessagePresenter.class);
        arrayMap.put(30, QFSPositiveFeedbackMessagePresenter.class);
        arrayMap.put(9, QFSCommentOrReplyMessagePresenter.class);
        arrayMap.put(10, QFSCommentOrReplyMessagePresenter.class);
        arrayMap.put(11, QFSCommentOrReplyMessagePresenter.class);
        arrayMap.put(1, QFSCommentOrReplyMessagePresenter.class);
        arrayMap.put(2, QFSCommentOrReplyMessagePresenter.class);
        arrayMap.put(5, QFSNumNoticeMessagePresenter.class);
        arrayMap.put(32, QFSNumNoticeMessagePresenter.class);
        arrayMap.put(34, QFSDiffTimeNoticeMessagePresenter.class);
        arrayMap.put(35, QFSDiffTimeNoticeMessagePresenter.class);
        arrayMap.put(36, QFSDiffTimeNoticeMessagePresenter.class);
        arrayMap.put(37, QFSDiffTimeNoticeMessagePresenter.class);
        arrayMap.put(39, QFSFriendPushNoticeMessagePresenter.class);
    }

    public QFSDefaultNoticeMessageItemView(Context context, int i3) {
        super(context, i3);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gib;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return TAG;
    }

    protected QFSBaseNoticeMessagePresenter getMessagePresenter(int i3) {
        Class<? extends QFSBaseNoticeMessagePresenter> cls = sTypeToPresenter.get(Integer.valueOf(i3));
        if (cls != null) {
            try {
                return cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(i3));
            } catch (Exception e16) {
                QLog.w(TAG, 1, "getMessagePresenter reflect error: viewType=" + i3 + ", presenter=" + cls + "\nerror: " + e16);
            }
        }
        return new QFSDefaultNoticeMessagePresenter(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.item.QFSBaseNoticeMessageItemView, com.tencent.biz.qqcircle.fragments.message.item.QFSBaseMessageItemView
    public QFSBaseNoticeMessagePresenter initPresenter() {
        return getMessagePresenter(getViewType());
    }
}

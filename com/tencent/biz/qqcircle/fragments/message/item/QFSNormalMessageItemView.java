package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSBusinessMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSLiveMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSUserPublishNewContentsMessagePresenter;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSNormalMessageItemView extends QFSBaseMessageItemView {
    private static final String TAG = "QFSNormalMessageItemView";
    private static final Map<Integer, Class<? extends QFSBaseNormalMessagePresenter>> sTypeToPresenter;

    static {
        ArrayMap arrayMap = new ArrayMap();
        sTypeToPresenter = arrayMap;
        arrayMap.put(18, QFSUserPublishNewContentsMessagePresenter.class);
        arrayMap.put(12, QFSUserPublishNewContentsMessagePresenter.class);
        arrayMap.put(33, QFSLiveMessagePresenter.class);
        arrayMap.put(15, QFSBusinessMessagePresenter.class);
    }

    public QFSNormalMessageItemView(@NonNull Context context, int i3) {
        super(context, i3);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gih;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return TAG;
    }

    protected QFSBaseNormalMessagePresenter getMessagePresenter(int i3) {
        Class<? extends QFSBaseNormalMessagePresenter> cls = sTypeToPresenter.get(Integer.valueOf(i3));
        if (cls != null) {
            try {
                return cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(i3));
            } catch (Exception e16) {
                QLog.w(TAG, 1, "getMessagePresenter reflect error: viewType=" + i3 + ", presenter=" + cls + "\nerror: " + e16);
            }
        }
        return new QFSBaseNormalMessagePresenter(i3);
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.item.QFSBaseMessageItemView
    protected com.tencent.biz.qqcircle.fragments.message.presenter.a initPresenter() {
        return getMessagePresenter(getViewType());
    }
}

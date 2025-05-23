package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.events.QFSPublicListInnerBlockRegisterEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes4.dex */
public class QFSMessageNewFriendLoadMorePresenter extends com.tencent.biz.qqcircle.fragments.message.presenter.a {
    private static final String TAG = "QFSMessageNewFriendLoadMorePresenter";
    private View mLoadMoreContainer;

    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SimpleEventBus.getInstance().dispatchEvent(new QFSPublicListInnerBlockRegisterEvent(false, 4));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QFSMessageNewFriendLoadMorePresenter(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initCustomView(Context context, @NonNull View view) {
        View findViewById = view.findViewById(R.id.f46901vu);
        this.mLoadMoreContainer = findViewById;
        findViewById.setOnClickListener(new a());
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initClickListener() {
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void bindCustomData(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3) {
    }
}

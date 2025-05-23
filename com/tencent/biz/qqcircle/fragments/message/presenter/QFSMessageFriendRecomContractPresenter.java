package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.util.Consumer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.events.QFSMessageFriendRecomItemRemoveEvent;
import com.tencent.biz.qqcircle.events.QFSMessageFriendRecomRefreshEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u001a\u001a\u00020\f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000f\u001a\u00020\u0002H\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/biz/qqcircle/fragments/message/presenter/QFSMessageFriendRecomContractPresenter;", "Lcom/tencent/biz/qqcircle/fragments/message/presenter/a;", "", "handleClickShield", "handleClickSee", "Landroid/content/Context;", "context", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initCustomView", "Lcom/tencent/biz/qqcircle/beans/QFSMessageItemInfo;", "itemInfo", "", "position", "bindCustomData", "initClickListener", "", "getLogTag", "Landroid/widget/ImageView;", "mIvAvatar", "Landroid/widget/ImageView;", "mTvShield", "Landroid/view/View;", "Landroid/widget/TextView;", "mTvSee", "Landroid/widget/TextView;", "viewType", "<init>", "(I)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSMessageFriendRecomContractPresenter extends a {

    @NotNull
    private static final String TAG = "QFSMessageFriendRecomContractPresenter";
    private ImageView mIvAvatar;
    private TextView mTvSee;
    private View mTvShield;

    public QFSMessageFriendRecomContractPresenter(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindCustomData$lambda$0(QFSMessageFriendRecomContractPresenter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleClickShield();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindCustomData$lambda$1(QFSMessageFriendRecomContractPresenter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleClickSee();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void handleClickSee() {
        Context context = this.mContext;
        if (context instanceof Activity) {
            com.tencent.biz.qqcircle.helpers.k kVar = com.tencent.biz.qqcircle.helpers.k.f84627a;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            com.tencent.biz.qqcircle.helpers.k.k(kVar, (Activity) context, false, new Consumer() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.j
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    QFSMessageFriendRecomContractPresenter.handleClickSee$lambda$2((Boolean) obj);
                }
            }, 2, null);
        } else {
            RFWLog.e(TAG, RFWLog.USR, "[handleClickSee] mContext is not Activity. mContext=" + context);
        }
        com.tencent.biz.qqcircle.helpers.k kVar2 = com.tencent.biz.qqcircle.helpers.k.f84627a;
        TextView textView = this.mTvSee;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvSee");
            textView = null;
        }
        kVar2.e(textView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleClickSee$lambda$2(Boolean allowed) {
        Intrinsics.checkNotNullExpressionValue(allowed, "allowed");
        if (allowed.booleanValue()) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSMessageFriendRecomRefreshEvent());
        }
    }

    private final void handleClickShield() {
        uq3.k.a().j("qfs_need_show_message_contract_guide", false);
        SimpleEventBus.getInstance().dispatchEvent(new QFSMessageFriendRecomItemRemoveEvent(this.mLastPos));
        com.tencent.biz.qqcircle.helpers.k kVar = com.tencent.biz.qqcircle.helpers.k.f84627a;
        View view = this.mTvShield;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvShield");
            view = null;
        }
        kVar.e(view, false);
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void bindCustomData(@NotNull QFSMessageItemInfo itemInfo, int position) {
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        Option obtain = Option.obtain();
        ImageView imageView = this.mIvAvatar;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvAvatar");
            imageView = null;
        }
        QCircleFeedPicLoader.g().loadImage(obtain.setTargetView(imageView).setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_skin_icon_msgpage_services_address_book")));
        View view = this.mTvShield;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvShield");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSMessageFriendRecomContractPresenter.bindCustomData$lambda$0(QFSMessageFriendRecomContractPresenter.this, view2);
            }
        });
        TextView textView2 = this.mTvSee;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvSee");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSMessageFriendRecomContractPresenter.bindCustomData$lambda$1(QFSMessageFriendRecomContractPresenter.this, view2);
            }
        });
        com.tencent.biz.qqcircle.helpers.k kVar = com.tencent.biz.qqcircle.helpers.k.f84627a;
        View mContainer = this.mContainer;
        Intrinsics.checkNotNullExpressionValue(mContainer, "mContainer");
        kVar.d(mContainer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    @NotNull
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initCustomView(@NotNull Context context, @NotNull View rootView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.f165909du3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.iv_avatar)");
        this.mIvAvatar = (ImageView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f111276ks);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tv_shield)");
        this.mTvShield = findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f111026k4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tv_see)");
        this.mTvSee = (TextView) findViewById3;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initClickListener() {
    }
}

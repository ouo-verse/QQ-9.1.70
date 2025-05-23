package com.tencent.biz.qqcircle.immersive.feed;

import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.events.QFSFriendFooterViewEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StItemContainer;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    protected View I;
    protected ImageView J;
    protected LinearLayout K;
    protected ImageView L;
    protected TextView M;
    protected ViewStub N;
    protected View P;
    protected LinearLayout Q;
    protected TextView R;

    private void g1(QFSFriendFooterViewEvent qFSFriendFooterViewEvent) {
        LinearLayout linearLayout;
        if (y0() == 504 && (linearLayout = this.K) != null) {
            if (qFSFriendFooterViewEvent.mIsPulling) {
                linearLayout.setVisibility(4);
            } else {
                linearLayout.setVisibility(0);
            }
        }
    }

    private void h1() {
        ImageView imageView = this.L;
        if (imageView == null) {
            return;
        }
        imageView.setRotation(180.0f);
        this.L.setBackgroundResource(R.drawable.kji);
        AnimationDrawable animationDrawable = (AnimationDrawable) this.L.getBackground();
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    private void i1() {
        if (this.N != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.I.findViewById(R.id.f44841q_);
        this.N = viewStub;
        if (viewStub == null) {
            QLog.e("QFSBaseDittoPresenter", 1, "[initSingleLineTitle] mSingleTitleViewStub should not be null.");
            return;
        }
        View inflate = viewStub.inflate();
        this.P = inflate;
        if (inflate == null) {
            QLog.e("QFSBaseDittoPresenter", 1, "[initSingleLineTitle] mTitleContainer should not be null.");
        } else {
            this.Q = (LinearLayout) inflate.findViewById(R.id.f46101to);
            this.R = (TextView) this.P.findViewById(R.id.f56312k_);
        }
    }

    private void k1(QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        i1();
        LinearLayout linearLayout = this.Q;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        TextView textView = this.R;
        if (textView != null) {
            textView.setText(qQCircleDitto$StItemContainer.title.get());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.I = view;
        this.J = (ImageView) view.findViewById(R.id.f44321ov);
        this.K = (LinearLayout) view.findViewById(R.id.f46151tt);
        this.L = (ImageView) view.findViewById(R.id.f44441p7);
        this.M = (TextView) view.findViewById(R.id.f56472kp);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSFriendFooterViewEvent.class);
        return eventClass;
    }

    /* renamed from: j1 */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = (QQCircleDitto$StCircleDittoDataNew) this.E.b(String.valueOf(feedCloudMeta$StFeed.dittoFeed.dittoId.get()));
        if (qQCircleDitto$StCircleDittoDataNew == null) {
            QLog.e("QFSBaseDittoPresenter", 1, "[onBindData] dittoData is null");
            return;
        }
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = qQCircleDitto$StCircleDittoDataNew.itemContainter.get();
        if (qQCircleDitto$StItemContainer == null) {
            QLog.e("QFSBaseDittoPresenter", 1, "[onBindData] itemContainer is null");
            return;
        }
        if (this.J != null) {
            String a16 = com.tencent.biz.qqcircle.immersive.utils.af.a(qQCircleDitto$StItemContainer.urlInfo.get(), IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_BACKGROUND_URL);
            if (TextUtils.isEmpty(a16)) {
                a16 = QCircleSkinHelper.getInstance().getUrl("pymk_feed_bg");
            }
            Option targetView = Option.obtain().setUrl(a16).setRequestWidth(com.tencent.biz.qqcircle.utils.cx.g()).setRequestHeight(com.tencent.biz.qqcircle.utils.cx.f()).setTargetView(this.J);
            targetView.setSupportRecycler(true);
            QCircleFeedPicLoader.g().loadImage(targetView, null);
        }
        TextView textView = this.M;
        if (textView != null) {
            textView.setText(QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemContainer.busiInfo.get(), "load_more_guide_text"));
        }
        k1(qQCircleDitto$StItemContainer);
        h1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        ImageView imageView = this.L;
        if (imageView != null && (imageView.getBackground() instanceof AnimationDrawable)) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.L.getBackground();
            if (animationDrawable.isRunning()) {
                return;
            }
            animationDrawable.start();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        ImageView imageView = this.L;
        if (imageView != null && (imageView.getBackground() instanceof AnimationDrawable)) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.L.getBackground();
            if (!animationDrawable.isRunning()) {
                return;
            }
            animationDrawable.stop();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSFriendFooterViewEvent) {
            g1((QFSFriendFooterViewEvent) simpleBaseEvent);
        }
    }
}

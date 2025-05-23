package com.tencent.biz.qqcircle.immersive.feed;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleShowSettingEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StItemContainer;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 52\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0016\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u001d0\u001cH\u0016R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00100\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010!R\u0016\u00102\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010%\u00a8\u00067"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/dn;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Landroid/view/View$OnClickListener;", "Lqqcircle/QQCircleDitto$StItemContainer;", "itemContainer", "", "j1", ICustomDataEditor.NUMBER_PARAM_1, "m1", "k1", "i1", "h1", "g1", "", "w0", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N0", "data", "", "position", "l1", "v", NodeProps.ON_CLICK, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "simpleBaseEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "mIvTitle", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "mTvTitle", "K", "mTvContent", "Landroid/widget/Button;", "L", "Landroid/widget/Button;", "mBtLater", "M", "mBtFindFriend", "N", "mMantleArrow", "P", "mTvGuideMore", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class dn extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView mIvTitle;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView mTvTitle;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView mTvContent;

    /* renamed from: L, reason: from kotlin metadata */
    private Button mBtLater;

    /* renamed from: M, reason: from kotlin metadata */
    private Button mBtFindFriend;

    /* renamed from: N, reason: from kotlin metadata */
    private ImageView mMantleArrow;

    /* renamed from: P, reason: from kotlin metadata */
    private TextView mTvGuideMore;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/dn$b", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends QCirclePicStateListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@Nullable LoadState state, @Nullable Option option) {
            Bitmap resultBitMap;
            super.onStateChange(state, option);
            if (option != null && (resultBitMap = option.getResultBitMap()) != null) {
                dn.this.C.setBackground(new BitmapDrawable(resultBitMap));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void g1() {
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(ua0.c.a((FeedCloudMeta$StFeed) this.f85017h).setFeedType1(3).setFeedType2(1).setActionType(901).setSubActionType(1).setIndex(this.f85018i).setPageId(y0())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void h1() {
        String str;
        PBStringField pBStringField;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) this.f85017h;
        Button button = null;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(str, 3));
        com.tencent.biz.qqcircle.helpers.k kVar = com.tencent.biz.qqcircle.helpers.k.f84627a;
        Button button2 = this.mBtLater;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtLater");
        } else {
            button = button2;
        }
        kVar.e(button, false);
    }

    private final void i1() {
        if (this.C.getContext() instanceof Activity) {
            com.tencent.biz.qqcircle.helpers.k kVar = com.tencent.biz.qqcircle.helpers.k.f84627a;
            Context context = this.C.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            com.tencent.biz.qqcircle.helpers.k.k(kVar, (Activity) context, false, null, 6, null);
        } else {
            RFWLog.e("QFSLayerFeedContractItemPresenter", RFWLog.USR, "[onClick] mRootView.context is not Activity.mRootView=" + this.C);
        }
        com.tencent.biz.qqcircle.helpers.k kVar2 = com.tencent.biz.qqcircle.helpers.k.f84627a;
        Button button = this.mBtFindFriend;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtFindFriend");
            button = null;
        }
        kVar2.e(button, true);
    }

    private final void j1(QQCircleDitto$StItemContainer itemContainer) {
        String a16 = com.tencent.biz.qqcircle.immersive.utils.af.a(itemContainer.urlInfo.get(), IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_BACKGROUND_URL);
        if (TextUtils.isEmpty(a16)) {
            RFWLog.i("QFSLayerFeedContractItemPresenter", RFWLog.USR, "[initBg] bgUrl is empty");
            a16 = QCircleSkinHelper.getInstance().getUrl("pymk_feed_bg");
        }
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(a16).setRequestWidth(com.tencent.biz.qqcircle.utils.cx.g()).setRequestHeight(com.tencent.biz.qqcircle.utils.cx.f()).setEnableAutoDeleteLocalCache(false).setLoadingDrawableColor(0).setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888), new b());
    }

    private final void k1() {
        ImageView imageView = this.mMantleArrow;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMantleArrow");
            imageView = null;
        }
        imageView.setBackgroundResource(R.drawable.kji);
        ImageView imageView3 = this.mMantleArrow;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMantleArrow");
        } else {
            imageView2 = imageView3;
        }
        Drawable background = imageView2.getBackground();
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        ((AnimationDrawable) background).start();
    }

    private final void m1(QQCircleDitto$StItemContainer itemContainer) {
        String valueFromListEntry = QCirclePluginUtil.getValueFromListEntry(itemContainer.busiInfo.get(), "load_more_guide_text");
        TextView textView = this.mTvGuideMore;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvGuideMore");
            textView = null;
        }
        textView.setText(valueFromListEntry);
        k1();
    }

    private final void n1() {
        Option obtain = Option.obtain();
        ImageView imageView = this.mIvTitle;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvTitle");
            imageView = null;
        }
        QCircleFeedPicLoader.g().loadImage(obtain.setTargetView(imageView).setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_icon_feed_address_book")));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.N0(rootView);
        View findViewById = rootView.findViewById(R.id.loi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.iv_title)");
        this.mIvTitle = (ImageView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.kbs);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tv_title)");
        this.mTvTitle = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.k6s);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tv_content)");
        this.mTvContent = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.tbs);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.bt_later)");
        this.mBtLater = (Button) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.tbq);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.bt_find_friend)");
        this.mBtFindFriend = (Button) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f46731vd);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.qfs_mantle_arrow)");
        this.mMantleArrow = (ImageView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f108396d0);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.tv_guide_more)");
        this.mTvGuideMore = (TextView) findViewById7;
        Button button = this.mBtLater;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtLater");
            button = null;
        }
        button.setOnClickListener(this);
        Button button3 = this.mBtFindFriend;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtFindFriend");
        } else {
            button2 = button3;
        }
        button2.setOnClickListener(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleShowSettingEvent.class);
        Intrinsics.checkNotNullExpressionValue(eventClass, "eventClass");
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        super.L0(data, position);
        if (data == null) {
            return;
        }
        n1();
        Object b16 = this.E.b(String.valueOf(data.dittoFeed.dittoId.get()));
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type qqcircle.QQCircleDitto.StCircleDittoDataNew");
        QQCircleDitto$StItemContainer itemContainer = ((QQCircleDitto$StCircleDittoDataNew) b16).itemContainter;
        Intrinsics.checkNotNullExpressionValue(itemContainer, "itemContainer");
        j1(itemContainer);
        TextView textView = this.mTvTitle;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
            textView = null;
        }
        textView.setText(itemContainer.title.get());
        TextView textView3 = this.mTvContent;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
        } else {
            textView2 = textView3;
        }
        textView2.setText(itemContainer.subTitle.get());
        m1(itemContainer);
        g1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        int id5 = v3.getId();
        if (id5 == R.id.tbs) {
            h1();
        } else if (id5 == R.id.tbq) {
            i1();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent simpleBaseEvent) {
        boolean z16;
        Intrinsics.checkNotNullParameter(simpleBaseEvent, "simpleBaseEvent");
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleShowSettingEvent) {
            QCircleShowSettingEvent qCircleShowSettingEvent = (QCircleShowSettingEvent) simpleBaseEvent;
            if (qCircleShowSettingEvent.mCode == 29) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (qCircleShowSettingEvent.mShow & z16) {
                h1();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSLayerFeedContractItemPresenter";
    }
}

package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.feed.ad.af;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdRenderHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0002)*B\u001f\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\tH\u0014J\b\u0010\u0010\u001a\u00020\tH\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006+"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/ad/QFSPublicAccountStaggeredTopAdItemView;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/ad/QFSPublicAccountStaggeredAdItemView;", "", "e1", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "h1", "f1", "i1", "", "from", "k1", "Le30/b;", "objData", "position", "bindData", "getLayoutId", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/ad/QFSPublicAccountStaggeredTopAdItemView$MuteOption;", "P", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/ad/QFSPublicAccountStaggeredTopAdItemView$MuteOption;", "muteOption", "Landroid/widget/Button;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/Button;", "button", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/ImageView;", "muteIcon", "Landroid/content/Context;", "context", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", JsonRuleKey.OPERATOR, "<init>", "(Landroid/content/Context;Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;)V", ExifInterface.LATITUDE_SOUTH, "a", "MuteOption", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountStaggeredTopAdItemView extends QFSPublicAccountStaggeredAdItemView {

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private MuteOption muteOption;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Button button;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final ImageView muteIcon;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/ad/QFSPublicAccountStaggeredTopAdItemView$MuteOption;", "", "(Ljava/lang/String;I)V", "NOT_SET", "IS_MUTE", "IS_NOT_MUTE", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public enum MuteOption {
        NOT_SET,
        IS_MUTE,
        IS_NOT_MUTE
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/ad/QFSPublicAccountStaggeredTopAdItemView$a;", "", "", "d", "c", "RATIO_HEIGHT", "I", "RATIO_WIDTH", "", "TAG", "Ljava/lang/String;", "VOLUME_FROM_INIT", "VOLUME_FROM_SWITCH", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.QFSPublicAccountStaggeredTopAdItemView$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c() {
            return (d() * 9) / 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d() {
            return DisplayUtil.getScreenWidth() - (com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o.INSTANCE.b() * 2);
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPublicAccountStaggeredTopAdItemView(@NotNull Context context, @NotNull QCircleInitBean initBean, @NotNull com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.a operator) {
        super(context, initBean, operator);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Intrinsics.checkNotNullParameter(operator, "operator");
        this.muteOption = MuteOption.NOT_SET;
        View findViewById = findViewById(R.id.sc5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_pup_btn)");
        this.button = (Button) findViewById;
        View findViewById2 = findViewById(R.id.zkm);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.mute_icon)");
        this.muteIcon = (ImageView) findViewById2;
    }

    private final void e1() {
        RelativeLayout feedCoverContainer = getFeedCoverContainer();
        Companion companion = INSTANCE;
        feedCoverContainer.setLayoutParams(new LinearLayout.LayoutParams(companion.d(), companion.c()));
    }

    private final void f1() {
        String str;
        this.button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountStaggeredTopAdItemView.g1(QFSPublicAccountStaggeredTopAdItemView.this, view);
            }
        });
        Button button = this.button;
        GdtAd gdtAd = getGdtAd();
        if (gdtAd != null) {
            GdtAd gdtAd2 = getGdtAd();
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            str = gdtAd.getButtonText(af.b(gdtAd2, (Activity) context));
        } else {
            str = null;
        }
        button.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(QFSPublicAccountStaggeredTopAdItemView this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.V0(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void h1(FeedCloudMeta$StFeed feed) {
        e1();
        int color = QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_tag_selected);
        Option supportRecycler = Option.obtain().setUrl(feed.cover.picUrl.get()).setTargetView(getFeedCoverView()).setFromPreLoad(false).setPredecode(true).setSupportRecycler(true);
        Companion companion = INSTANCE;
        Option failedDrawableId = supportRecycler.setRequestWidth(companion.d()).setRequestHeight(companion.c()).setLoadingDrawableColor(color).setFailedDrawableId(R.drawable.ojc);
        failedDrawableId.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        q50.b.e().q(failedDrawableId, false);
        QCircleFeedPicLoader.g().loadImage(failedDrawableId);
        MaskAdRenderHelper.INSTANCE.getMMaskAdSizeMap().put(MaskAdvName.QFS_PUB, new Pair<>(Integer.valueOf(companion.c()), 0));
    }

    private final void i1() {
        if (!com.tencent.biz.qqcircle.immersive.feed.ad.u.g(getGdtAd())) {
            this.muteIcon.setVisibility(8);
            return;
        }
        this.muteIcon.setVisibility(0);
        this.muteIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountStaggeredTopAdItemView.j1(QFSPublicAccountStaggeredTopAdItemView.this, view);
            }
        });
        k1(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(QFSPublicAccountStaggeredTopAdItemView this$0, View view) {
        MuteOption muteOption;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = !com.tencent.biz.qqcircle.richframework.widget.video.a.c().b(this$0.getAdPosition());
        com.tencent.biz.qqcircle.richframework.widget.video.a.c().k(this$0.getAdPosition(), z16);
        if (z16) {
            muteOption = MuteOption.IS_MUTE;
        } else {
            muteOption = MuteOption.IS_NOT_MUTE;
        }
        this$0.muteOption = muteOption;
        this$0.k1(4);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void k1(int from) {
        boolean z16;
        int i3;
        if (this.muteOption != MuteOption.IS_NOT_MUTE) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("QFSPublicAccountStaggeredTopAdItemView", 1, "refreshMuteLayout: from: " + from + ", muteOption: " + z16);
        if (z16) {
            i3 = R.drawable.nrv;
        } else {
            i3 = R.drawable.f162061ns0;
        }
        this.muteIcon.setImageResource(i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.QFSPublicAccountStaggeredAdItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.goi;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        e1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.QFSPublicAccountStaggeredAdItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(@Nullable e30.b objData, int position) {
        super.bindData(objData, position);
        FeedCloudMeta$StFeed c16 = com.tencent.biz.qqcircle.immersive.feed.ad.u.c(objData);
        Intrinsics.checkNotNullExpressionValue(c16, "getAdFeed(objData)");
        h1(c16);
        f1();
        i1();
    }
}

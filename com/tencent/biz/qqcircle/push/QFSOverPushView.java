package com.tencent.biz.qqcircle.push;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.l;
import com.tencent.biz.qqcircle.push.QFSFastPushRocketBtnItemView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uq3.k;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 x2\u00020\u0001:\u0002yzB'\b\u0007\u0012\u0006\u0010r\u001a\u00020q\u0012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010s\u0012\b\b\u0002\u0010u\u001a\u00020\u0006\u00a2\u0006\u0004\bv\u0010wJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0016\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00052\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J \u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J(\u0010#\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0002J\u0006\u0010$\u001a\u00020\u0002J\u000e\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0019R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010'R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010'R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010'R\u0016\u0010,\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010+R\u0016\u0010-\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010+R\u0016\u0010/\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010+R\u001a\u00103\u001a\b\u0012\u0004\u0012\u000201008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010'R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020<008\u0006\u00a2\u0006\f\n\u0004\b=\u0010'\u001a\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010BR\u0016\u0010F\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010BR\u0016\u0010H\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010BR\"\u0010N\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010B\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010U\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\b.\u0010R\"\u0004\bS\u0010TR$\u0010]\u001a\u0004\u0018\u00010V8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010d\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010h\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010_\u001a\u0004\bf\u0010a\"\u0004\bg\u0010cR\"\u0010l\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010B\u001a\u0004\bj\u0010K\"\u0004\bk\u0010MR\"\u0010p\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010_\u001a\u0004\bn\u0010a\"\u0004\bo\u0010c\u00a8\u0006{"}, d2 = {"Lcom/tencent/biz/qqcircle/push/QFSOverPushView;", "Landroid/widget/FrameLayout;", "", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "", "t", "choicesList", "f", "position", "size", "l", "p", "d", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "btnCnt", "y", "", "j", "", "k", "i", tl.h.F, "", "isNeedShowRocketEditPanel", "pushCnt", "pushType", "v", "url", "width", "height", "Landroid/widget/ImageView;", "imageView", "w", HippyTKDListViewAdapter.X, "isNeedAnimate", "g", "Ljava/util/List;", "pushConfigListV3", "pushConfigListV4", "pushConfigListV5", "Landroid/widget/ImageView;", "background", "mainRocketImg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "leadLine", "", "Lcom/tencent/biz/qqcircle/push/QFSFastPushRocketBtnItemView;", BdhLogUtil.LogTag.Tag_Conn, "btnViewList", "Landroid/view/View$OnClickListener;", "D", "Landroid/view/View$OnClickListener;", "dismissListener", "Lcom/tencent/biz/qqcircle/push/QFSFastPushRocketBtnItemView$c;", "E", "Lcom/tencent/biz/qqcircle/push/QFSFastPushRocketBtnItemView$c;", "btnAnimateFinishListener", "Lcom/tencent/biz/qqcircle/push/QFSOverPushView$b;", UserInfo.SEX_FEMALE, "o", "()Ljava/util/List;", "panelClickListeners", "G", "I", "showStatus", "H", "chosenCnt", "chosenType", "J", "chosenIndex", "K", "getHasPushedCnt", "()I", "setHasPushedCnt", "(I)V", "hasPushedCnt", "Lfeedcloud/FeedCloudMeta$StFeed;", "L", "Lfeedcloud/FeedCloudMeta$StFeed;", "()Lfeedcloud/FeedCloudMeta$StFeed;", "setFeed", "(Lfeedcloud/FeedCloudMeta$StFeed;)V", "feed", "Landroid/view/View;", "M", "Landroid/view/View;", "getParentView", "()Landroid/view/View;", "setParentView", "(Landroid/view/View;)V", "parentView", "N", "Z", "getShowCancelBtn", "()Z", "setShowCancelBtn", "(Z)V", "showCancelBtn", "P", DomainData.DOMAIN_NAME, "setOnlyShowCancelBtn", "onlyShowCancelBtn", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "getUserCurrentRocketCount", "setUserCurrentRocketCount", "userCurrentRocketCount", BdhLogUtil.LogTag.Tag_Req, "getSimpleMode", "setSimpleMode", "simpleMode", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", ExifInterface.LATITUDE_SOUTH, "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSOverPushView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<QFSFastPushRocketBtnItemView> btnViewList;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View.OnClickListener dismissListener;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private QFSFastPushRocketBtnItemView.c btnAnimateFinishListener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final List<b> panelClickListeners;

    /* renamed from: G, reason: from kotlin metadata */
    private int showStatus;

    /* renamed from: H, reason: from kotlin metadata */
    private int chosenCnt;

    /* renamed from: I, reason: from kotlin metadata */
    private int chosenType;

    /* renamed from: J, reason: from kotlin metadata */
    private int chosenIndex;

    /* renamed from: K, reason: from kotlin metadata */
    private int hasPushedCnt;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed feed;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private View parentView;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean showCancelBtn;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean onlyShowCancelBtn;

    /* renamed from: Q, reason: from kotlin metadata */
    private int userCurrentRocketCount;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean simpleMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> pushConfigListV3;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> pushConfigListV4;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> pushConfigListV5;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView background;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mainRocketImg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView leadLine;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/qqcircle/push/QFSOverPushView$b;", "", "", "isNeedShowRocketEditPanel", "", "pushCnt", "pushType", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean isNeedShowRocketEditPanel, int pushCnt, int pushType);
    }

    static {
        RFWMultiDownloadHelper rFWMultiDownloadHelper = new RFWMultiDownloadHelper();
        rFWMultiDownloadHelper.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/zip/defaultmode/893/rocket_v3/qvideo_rocket_feed_quickpush_3_seq.zip", com.tencent.biz.qqcircle.f.r()));
        rFWMultiDownloadHelper.start();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSOverPushView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(QFSOverPushView this$0, int i3, List popOutDegrees, int i16) {
        Object orNull;
        Object orNull2;
        int i17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(popOutDegrees, "$popOutDegrees");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this$0.btnViewList, i3);
        QFSFastPushRocketBtnItemView qFSFastPushRocketBtnItemView = (QFSFastPushRocketBtnItemView) orNull;
        if (qFSFastPushRocketBtnItemView != null) {
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(popOutDegrees, i3);
            Double d16 = (Double) orNull2;
            if (d16 != null) {
                double doubleValue = d16.doubleValue();
                qFSFastPushRocketBtnItemView.setVisibility(0);
                if (i16 == 1) {
                    i17 = 65;
                } else {
                    i17 = 90;
                }
                qFSFastPushRocketBtnItemView.v((int) (i17 * (-1) * Math.cos(doubleValue)), (int) (i17 * Math.sin(doubleValue)));
            }
        }
    }

    private final void d() {
        ImageView imageView = this.mainRocketImg;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainRocketImg");
            imageView = null;
        }
        imageView.setVisibility(0);
        ImageView imageView3 = this.background;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("background");
            imageView3 = null;
        }
        imageView3.setVisibility(0);
        ImageView imageView4 = this.mainRocketImg;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainRocketImg");
            imageView4 = null;
        }
        imageView4.setAlpha(0.0f);
        ImageView imageView5 = this.background;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("background");
            imageView5 = null;
        }
        imageView5.setAlpha(0.0f);
        ImageView imageView6 = this.background;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("background");
            imageView6 = null;
        }
        addView(imageView6);
        ImageView imageView7 = this.leadLine;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leadLine");
            imageView7 = null;
        }
        addView(imageView7);
        e();
        ImageView imageView8 = this.mainRocketImg;
        if (imageView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainRocketImg");
        } else {
            imageView2 = imageView8;
        }
        addView(imageView2);
    }

    private final void e() {
        if (l.b() && !this.onlyShowCancelBtn && !k.a().c("qfs_key_has_show_push_v5_guide_anim", false)) {
            k.a().j("qfs_key_has_show_push_v5_guide_anim", true);
            if (QCircleDeviceInfoUtils.isLowDevice()) {
                return;
            }
            ImageView imageView = new ImageView(getContext(), null, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cx.a(104.0f), cx.a(67.0f), 8388661);
            layoutParams.rightMargin = cx.a(30.0f);
            layoutParams.topMargin = cx.a(58.0f);
            imageView.setLayoutParams(layoutParams);
            String url = QCircleSkinHelper.getInstance().getUrl("qvideo_rocket_feed_guide_animation");
            Intrinsics.checkNotNullExpressionValue(url, "getInstance().getUrl(QCi\u2026KET_FEED_GUIDE_ANIMATION)");
            w(url, 104, 67, imageView);
            addView(imageView);
        }
    }

    private final void f(List<Integer> choicesList) {
        this.btnViewList.clear();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cx.a(54.0f), cx.a(54.0f), 8388629);
        layoutParams.rightMargin = cx.a(4.0f);
        Iterator<Integer> it = choicesList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i16 = i3 + 1;
            int intValue = it.next().intValue();
            QFSFastPushRocketBtnItemView qFSFastPushRocketBtnItemView = new QFSFastPushRocketBtnItemView(getContext());
            qFSFastPushRocketBtnItemView.setLayoutParams(layoutParams);
            qFSFastPushRocketBtnItemView.z();
            qFSFastPushRocketBtnItemView.setHasPushedCnt(this.hasPushedCnt);
            boolean z16 = true;
            qFSFastPushRocketBtnItemView.setEnableClickWhenLackRocket(true);
            qFSFastPushRocketBtnItemView.setUserCurrentRocketCount(this.userCurrentRocketCount);
            qFSFastPushRocketBtnItemView.r(2, false, intValue, this.btnAnimateFinishListener);
            if (!l.b() ? this.hasPushedCnt < intValue : this.hasPushedCnt < l.c()) {
                z16 = false;
            }
            if (z16) {
                qFSFastPushRocketBtnItemView.setBtnDisable();
            }
            qFSFastPushRocketBtnItemView.setBtnType(l(i3, choicesList.size()));
            qFSFastPushRocketBtnItemView.setPosition(i3);
            qFSFastPushRocketBtnItemView.setVisibility(4);
            this.btnViewList.add(qFSFastPushRocketBtnItemView);
            addView(qFSFastPushRocketBtnItemView);
            i3 = i16;
        }
        if (this.showCancelBtn) {
            QFSFastPushRocketBtnItemView qFSFastPushRocketBtnItemView2 = new QFSFastPushRocketBtnItemView(getContext());
            qFSFastPushRocketBtnItemView2.setLayoutParams(layoutParams);
            qFSFastPushRocketBtnItemView2.y();
            qFSFastPushRocketBtnItemView2.r(3, false, 0, this.btnAnimateFinishListener);
            qFSFastPushRocketBtnItemView2.setBtnType(8);
            qFSFastPushRocketBtnItemView2.setPosition(choicesList.size());
            qFSFastPushRocketBtnItemView2.setVisibility(4);
            this.btnViewList.add(qFSFastPushRocketBtnItemView2);
            addView(qFSFastPushRocketBtnItemView2);
        }
        setVisibility(8);
    }

    private final void h() {
        ImageView imageView = this.background;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("background");
            imageView = null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(200L);
        ofFloat.start();
        ImageView imageView3 = this.mainRocketImg;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainRocketImg");
            imageView3 = null;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView3, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.3f);
        ImageView imageView4 = this.mainRocketImg;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainRocketImg");
            imageView4 = null;
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView4, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.3f);
        ImageView imageView5 = this.mainRocketImg;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainRocketImg");
            imageView5 = null;
        }
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView5, BasicAnimation.KeyPath.SCALE_X, 1.3f, 1.0f);
        ImageView imageView6 = this.mainRocketImg;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainRocketImg");
            imageView6 = null;
        }
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(imageView6, BasicAnimation.KeyPath.SCALE_Y, 1.3f, 1.0f);
        ImageView imageView7 = this.mainRocketImg;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainRocketImg");
        } else {
            imageView2 = imageView7;
        }
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(imageView2, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat6.setStartDelay(160L);
        ofFloat6.setDuration(80L);
        ofFloat2.setDuration(80L);
        ofFloat3.setDuration(80L);
        ofFloat4.setDuration(160L);
        ofFloat5.setDuration(160L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.play(ofFloat2).with(ofFloat3).with(ofFloat6).before(ofFloat4).before(ofFloat5);
        animatorSet.setStartDelay(120L);
        animatorSet.start();
    }

    private final void i() {
        Iterator<QFSFastPushRocketBtnItemView> it = this.btnViewList.iterator();
        while (it.hasNext()) {
            it.next().n();
        }
    }

    private final String j(int size) {
        if (size != 1) {
            if (size != 3) {
                if (size != 4) {
                    if (size != 5) {
                        return "";
                    }
                    return "qvideo_rocket_feed_quickpush_bg_for5";
                }
                return "qvideo_rocket_feed_quickpush_bg_for4";
            }
            return "qvideo_rocket_feed_quickpush_bg_for3";
        }
        return "qvideo_rocket_feed_cancelrocket_bg_v4";
    }

    private final List<Double> k(int size) {
        List<Double> listOf;
        List<Double> listOf2;
        List<Double> listOf3;
        List<Double> listOf4;
        List<Double> emptyList;
        if (size == 1) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(Double.valueOf(0.0d));
            return listOf;
        }
        if (size == 3) {
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Double[]{Double.valueOf(-0.7853981633974483d), Double.valueOf(0.0d), Double.valueOf(0.7853981633974483d)});
            return listOf2;
        }
        if (size == 4) {
            listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new Double[]{Double.valueOf(-1.2217304763960306d), Double.valueOf(-0.5235987755982988d), Double.valueOf(0.5235987755982988d), Double.valueOf(1.2217304763960306d)});
            return listOf3;
        }
        if (size != 5) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        listOf4 = CollectionsKt__CollectionsKt.listOf((Object[]) new Double[]{Double.valueOf(-1.5707963267948966d), Double.valueOf(-0.7853981633974483d), Double.valueOf(0.0d), Double.valueOf(0.7853981633974483d), Double.valueOf(1.5707963267948966d)});
        return listOf4;
    }

    private final int l(int position, int size) {
        if (l.a()) {
            if (position == 0) {
                return 9;
            }
            if (position == size - 1) {
                return 3;
            }
            return 10;
        }
        if (position == size - 1) {
            return 3;
        }
        return 10;
    }

    private final void p() {
        VideoReport.setLogicParent(this, this.parentView);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        Map<String, Object> e16 = ua0.c.e(this.feed);
        Intrinsics.checkNotNullExpressionValue(e16, "convertDataToDTParamsMap(feed)");
        buildElementParams.putAll(e16);
        VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_PUSH_SHORTCUT_OPTIONS);
        VideoReport.setElementClickPolicy(this, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_imp", this, buildElementParams);
    }

    private final void q() {
        this.dismissListener = new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.push.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSOverPushView.r(QFSOverPushView.this, view);
            }
        };
        this.btnAnimateFinishListener = new QFSFastPushRocketBtnItemView.c() { // from class: com.tencent.biz.qqcircle.push.f
            @Override // com.tencent.biz.qqcircle.push.QFSFastPushRocketBtnItemView.c
            public final void a(a aVar) {
                QFSOverPushView.s(QFSOverPushView.this, aVar);
            }
        };
        setOnClickListener(this.dismissListener);
        ImageView imageView = this.mainRocketImg;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainRocketImg");
            imageView = null;
        }
        imageView.setOnClickListener(this.dismissListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(QFSOverPushView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(QFSOverPushView this$0, a aVar) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.chosenCnt = aVar.c();
        this$0.chosenType = aVar.a();
        if (aVar.a() != 8) {
            z16 = true;
        } else {
            z16 = false;
        }
        this$0.g(z16);
    }

    private final List<Integer> t() {
        List<Integer> emptyList;
        if (this.onlyShowCancelBtn) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        boolean z16 = false;
        if (l.b()) {
            List<Integer> list = l.d();
            List<Integer> list2 = list;
            if (list2 == null || list2.isEmpty()) {
                z16 = true;
            }
            if (z16) {
                return this.pushConfigListV5;
            }
            Intrinsics.checkNotNullExpressionValue(list, "list");
            return list;
        }
        if (l.a()) {
            List<Integer> list3 = l.d();
            List<Integer> list4 = list3;
            if (list4 == null || list4.isEmpty()) {
                z16 = true;
            }
            if (z16) {
                return this.pushConfigListV4;
            }
            Intrinsics.checkNotNullExpressionValue(list3, "list");
            return list3;
        }
        return this.pushConfigListV3;
    }

    private final void u() {
        ImageView imageView = null;
        this.background = new ImageView(getContext(), null, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cx.a(88.0f), cx.a(124.0f), 8388629);
        ImageView imageView2 = this.background;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("background");
            imageView2 = null;
        }
        imageView2.setLayoutParams(layoutParams);
        this.mainRocketImg = new ImageView(getContext(), null, 0);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(cx.a(34.0f), cx.a(34.0f), 8388629);
        layoutParams2.rightMargin = cx.a(13.0f);
        ImageView imageView3 = this.mainRocketImg;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainRocketImg");
            imageView3 = null;
        }
        imageView3.setLayoutParams(layoutParams2);
        ImageView imageView4 = this.mainRocketImg;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainRocketImg");
            imageView4 = null;
        }
        imageView4.setImageResource(com.tencent.biz.qqcircle.k.h());
        this.leadLine = new ImageView(getContext(), null, 0);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(cx.a(88.0f), cx.a(30.0f), 8388629);
        layoutParams3.rightMargin = cx.a(30.0f);
        ImageView imageView5 = this.leadLine;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leadLine");
            imageView5 = null;
        }
        imageView5.setLayoutParams(layoutParams3);
        ImageView imageView6 = this.leadLine;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leadLine");
            imageView6 = null;
        }
        imageView6.setVisibility(8);
        String url = QCircleSkinHelper.getInstance().getUrl("qvideo_rocket_feed_quickpush_light_v4");
        Intrinsics.checkNotNullExpressionValue(url, "getInstance().getUrl(QCi\u2026_FEED_QUICKPUSH_LIGHT_V4)");
        ImageView imageView7 = this.leadLine;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leadLine");
        } else {
            imageView = imageView7;
        }
        w(url, 88, 30, imageView);
        setVisibility(8);
    }

    private final void v(boolean isNeedShowRocketEditPanel, int pushCnt, int pushType) {
        if (this.panelClickListeners.size() == 0) {
            return;
        }
        Iterator<b> it = this.panelClickListeners.iterator();
        while (it.hasNext()) {
            it.next().a(isNeedShowRocketEditPanel, pushCnt, pushType);
        }
    }

    private final void w(String url, int width, int height, ImageView imageView) {
        Option loadingDrawableColor = Option.obtain().setUrl(url).setRequestWidth(ImmersiveUtils.dpToPx(width)).setRequestHeight(ImmersiveUtils.dpToPx(height)).setTargetView(imageView).setEnableAutoDeleteLocalCache(false).setLoadingDrawableColor(0);
        loadingDrawableColor.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(loadingDrawableColor);
    }

    private final void y(int btnCnt) {
        String url = QCircleSkinHelper.getInstance().getUrl(j(btnCnt));
        Intrinsics.checkNotNullExpressionValue(url, "getInstance().getUrl(getBgToken(btnCnt))");
        ImageView imageView = this.background;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("background");
            imageView = null;
        }
        w(url, 88, 124, imageView);
        ImageView imageView3 = this.background;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("background");
            imageView3 = null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView3, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(280L);
        ImageView imageView4 = this.mainRocketImg;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainRocketImg");
            imageView4 = null;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView4, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.5f);
        ImageView imageView5 = this.mainRocketImg;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainRocketImg");
            imageView5 = null;
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView5, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.5f);
        ImageView imageView6 = this.mainRocketImg;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainRocketImg");
            imageView6 = null;
        }
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView6, BasicAnimation.KeyPath.SCALE_X, 1.5f, 1.0f);
        ImageView imageView7 = this.mainRocketImg;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainRocketImg");
            imageView7 = null;
        }
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(imageView7, BasicAnimation.KeyPath.SCALE_Y, 1.5f, 1.0f);
        ImageView imageView8 = this.mainRocketImg;
        if (imageView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainRocketImg");
        } else {
            imageView2 = imageView8;
        }
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(imageView2, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat2.setDuration(160L);
        ofFloat3.setDuration(160L);
        ofFloat6.setDuration(160L);
        ofFloat4.setDuration(120L);
        ofFloat5.setDuration(120L);
        ofFloat6.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat2).with(ofFloat3).with(ofFloat6).with(ofFloat).before(ofFloat4).before(ofFloat5);
        animatorSet.start();
    }

    private final void z() {
        final List<Double> k3;
        int collectionSizeOrDefault;
        if (this.btnViewList.isEmpty()) {
            return;
        }
        final int size = this.btnViewList.size();
        if (this.simpleMode) {
            List<Double> k16 = k(size);
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(k16, 10);
            k3 = new ArrayList<>(collectionSizeOrDefault);
            Iterator<T> it = k16.iterator();
            while (it.hasNext()) {
                k3.add(Double.valueOf(((Number) it.next()).doubleValue() - 1.5707963267948966d));
            }
        } else {
            k3 = k(size);
        }
        for (final int i3 = 0; i3 < size; i3++) {
            postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.push.g
                @Override // java.lang.Runnable
                public final void run() {
                    QFSOverPushView.A(QFSOverPushView.this, i3, k3, size);
                }
            }, i3 * 40);
        }
    }

    public final void g(boolean isNeedAnimate) {
        if (this.showStatus == 0) {
            return;
        }
        this.showStatus = 0;
        if (isNeedAnimate) {
            i();
            h();
        } else {
            setVisibility(8);
        }
        v(false, this.chosenCnt, this.chosenType);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        if (feedCloudMeta$StFeed != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(2, feedCloudMeta$StFeed.f398449id.get(), false));
        }
    }

    @Nullable
    /* renamed from: m, reason: from getter */
    public final FeedCloudMeta$StFeed getFeed() {
        return this.feed;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getOnlyShowCancelBtn() {
        return this.onlyShowCancelBtn;
    }

    @NotNull
    public final List<b> o() {
        return this.panelClickListeners;
    }

    public final void setFeed(@Nullable FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.feed = feedCloudMeta$StFeed;
    }

    public final void setHasPushedCnt(int i3) {
        this.hasPushedCnt = i3;
    }

    public final void setOnlyShowCancelBtn(boolean z16) {
        this.onlyShowCancelBtn = z16;
    }

    public final void setParentView(@Nullable View view) {
        this.parentView = view;
    }

    public final void setShowCancelBtn(boolean z16) {
        this.showCancelBtn = z16;
    }

    public final void setSimpleMode(boolean z16) {
        this.simpleMode = z16;
    }

    public final void setUserCurrentRocketCount(int i3) {
        this.userCurrentRocketCount = i3;
    }

    public final void x() {
        Object orNull;
        FrameLayout.LayoutParams layoutParams;
        if (this.showStatus == 1) {
            return;
        }
        this.showStatus = 1;
        f(t());
        if (this.simpleMode) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.btnViewList, 0);
            QFSFastPushRocketBtnItemView qFSFastPushRocketBtnItemView = (QFSFastPushRocketBtnItemView) orNull;
            if (qFSFastPushRocketBtnItemView != null) {
                ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
                if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                    layoutParams = (FrameLayout.LayoutParams) layoutParams2;
                } else {
                    layoutParams = null;
                }
                if (layoutParams == null) {
                    layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 81;
                }
                qFSFastPushRocketBtnItemView.setLayoutParams(layoutParams);
            }
        } else {
            d();
            y(this.btnViewList.size());
        }
        z();
        setVisibility(0);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        if (feedCloudMeta$StFeed != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(2, feedCloudMeta$StFeed.f398449id.get(), true));
        }
        p();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSOverPushView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QFSOverPushView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSOverPushView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        List<Integer> listOf;
        List<Integer> listOf2;
        List<Integer> listOf3;
        Intrinsics.checkNotNullParameter(context, "context");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{10, 400});
        this.pushConfigListV3 = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 10, 400});
        this.pushConfigListV4 = listOf2;
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{10, 66, 188, 400});
        this.pushConfigListV5 = listOf3;
        this.btnViewList = new ArrayList();
        this.panelClickListeners = new ArrayList();
        this.chosenType = -1;
        this.chosenIndex = -1;
        this.showCancelBtn = true;
        u();
        q();
    }
}

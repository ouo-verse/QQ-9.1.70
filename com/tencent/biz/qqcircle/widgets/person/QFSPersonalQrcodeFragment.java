package com.tencent.biz.qqcircle.widgets.person;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.util.Consumer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSPersonalQrcodeChangeEvent;
import com.tencent.biz.qqcircle.utils.d;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StShare;
import feedcloud.FeedCloudMeta$StShareURLInfo;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import uq3.c;
import yb0.r;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0014J\b\u0010\t\u001a\u00020\u0005H\u0014J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0010\u001a\u00020\u0005J\u0014\u0010\u0014\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00180\u0017j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0018`\u0019H\u0016R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00128\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\u0014\u0010!\u001a\u00020\u00128\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006B"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/person/QFSPersonalQrcodeFragment;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "b", "e", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "shareInfo", "a", "c", "Landroidx/core/util/Consumer;", "", "consumer", "d", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "getShareInfo", "()Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "Ljava/lang/String;", "TAG", "f", "KEY_EXPIRE_TIME", "Lcom/tencent/biz/qqcircle/widgets/person/QFSPersonalNormalQrcodeView;", h.F, "Lcom/tencent/biz/qqcircle/widgets/person/QFSPersonalNormalQrcodeView;", "mNormalQrcodeView", "Lcom/tencent/biz/qqcircle/widgets/person/QFSPersonalAigcQrcodeView;", "i", "Lcom/tencent/biz/qqcircle/widgets/person/QFSPersonalAigcQrcodeView;", "mAigcQrcodeView", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/LinearLayout;", "mQrcodeLL", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "mChangeHighTextView", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "mQrcodeGenerateImageView", "", "E", "I", "ANIMATION_DURATION", "", UserInfo.SEX_FEMALE, "Z", "mISAigcShow", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "G", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "mOnPreDrawListener", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSPersonalQrcodeFragment extends FrameLayout implements View.OnClickListener, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView mChangeHighTextView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ImageView mQrcodeGenerateImageView;

    /* renamed from: E, reason: from kotlin metadata */
    private final int ANIMATION_DURATION;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mISAigcShow;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QCircleShareInfo shareInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String KEY_EXPIRE_TIME;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSPersonalNormalQrcodeView mNormalQrcodeView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSPersonalAigcQrcodeView mAigcQrcodeView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout mQrcodeLL;

    private final void b() {
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("eid", QCircleDaTongConstant.ElementId.EM_XSJ_QR_SETTING_SUCCESS_TOAST);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", params);
    }

    private final void e() {
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField;
        QFSPersonalNormalQrcodeView qFSPersonalNormalQrcodeView = this.mNormalQrcodeView;
        if (qFSPersonalNormalQrcodeView != null) {
            qFSPersonalNormalQrcodeView.setVisibility(4);
        }
        QFSPersonalAigcQrcodeView qFSPersonalAigcQrcodeView = this.mAigcQrcodeView;
        if (qFSPersonalAigcQrcodeView != null) {
            qFSPersonalAigcQrcodeView.setVisibility(0);
        }
        this.mISAigcShow = true;
        if (c.j0()) {
            QCircleShareInfo qCircleShareInfo = this.shareInfo;
            if (qCircleShareInfo != null && (feedCloudMeta$StFeed = qCircleShareInfo.feed) != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed.poster) != null && (pBStringField = feedCloudMeta$StUser.f398463id) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            if (QCirclePluginUtil.isOwner(str)) {
                TextView textView = this.mChangeHighTextView;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                LinearLayout linearLayout = this.mQrcodeLL;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                ImageView imageView = this.mQrcodeGenerateImageView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    return;
                }
                return;
            }
        }
        TextView textView2 = this.mChangeHighTextView;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.mQrcodeLL;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        ImageView imageView2 = this.mQrcodeGenerateImageView;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(@Nullable QCircleShareInfo shareInfo) {
        FeedCloudMeta$StShareURLInfo feedCloudMeta$StShareURLInfo;
        boolean z16;
        QFSPersonalAigcQrcodeView qFSPersonalAigcQrcodeView;
        QFSPersonalNormalQrcodeView qFSPersonalNormalQrcodeView;
        TextView textView;
        LinearLayout linearLayout;
        ImageView imageView;
        FeedCloudMeta$StShare feedCloudMeta$StShare;
        PBRepeatMessageField<FeedCloudMeta$StShareURLInfo> pBRepeatMessageField;
        List<FeedCloudMeta$StShareURLInfo> list;
        Object obj;
        boolean z17;
        if (shareInfo == null) {
            return;
        }
        if (r.h().r(shareInfo)) {
            QLog.d(this.TAG, 1, "share info need request");
            return;
        }
        QFSPersonalNormalQrcodeView qFSPersonalNormalQrcodeView2 = this.mNormalQrcodeView;
        if (qFSPersonalNormalQrcodeView2 != null) {
            qFSPersonalNormalQrcodeView2.a(shareInfo);
        }
        QFSPersonalAigcQrcodeView qFSPersonalAigcQrcodeView2 = this.mAigcQrcodeView;
        if (qFSPersonalAigcQrcodeView2 != null) {
            qFSPersonalAigcQrcodeView2.a(shareInfo);
        }
        this.mISAigcShow = false;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = shareInfo.feed;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StShare = feedCloudMeta$StFeed.share) != null && (pBRepeatMessageField = feedCloudMeta$StShare.url_infos) != null && (list = pBRepeatMessageField.get()) != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((FeedCloudMeta$StShareURLInfo) obj).type.get() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            feedCloudMeta$StShareURLInfo = (FeedCloudMeta$StShareURLInfo) obj;
        } else {
            feedCloudMeta$StShareURLInfo = null;
        }
        if (feedCloudMeta$StShareURLInfo != null && feedCloudMeta$StShareURLInfo.ext_info.has() && !feedCloudMeta$StShareURLInfo.ext_info.mapInfo.isEmpty()) {
            if (!TextUtils.isEmpty(QCirclePluginUtil.getValueFromListEntry(feedCloudMeta$StShareURLInfo.ext_info.mapInfo.get(), this.KEY_EXPIRE_TIME))) {
                try {
                } catch (Exception e16) {
                    QLog.e(this.TAG, 1, "bindData ", e16);
                }
                if (Integer.parseInt(r2) <= System.currentTimeMillis() / 1000) {
                    z16 = false;
                    if (!z16 && feedCloudMeta$StShareURLInfo != null && !TextUtils.isEmpty(feedCloudMeta$StShareURLInfo.url.get())) {
                        e();
                        return;
                    }
                    QLog.d(this.TAG, 1, "aigcQrcodeInfo url is empty");
                    qFSPersonalAigcQrcodeView = this.mAigcQrcodeView;
                    if (qFSPersonalAigcQrcodeView != null) {
                        qFSPersonalAigcQrcodeView.setVisibility(8);
                    }
                    qFSPersonalNormalQrcodeView = this.mNormalQrcodeView;
                    if (qFSPersonalNormalQrcodeView != null) {
                        qFSPersonalNormalQrcodeView.setVisibility(0);
                    }
                    if (!c.j0() && QCirclePluginUtil.isOwner(shareInfo.feed.poster.f398463id.get())) {
                        TextView textView2 = this.mChangeHighTextView;
                        if (textView2 != null) {
                            textView2.setVisibility(8);
                        }
                        LinearLayout linearLayout2 = this.mQrcodeLL;
                        if (linearLayout2 != null) {
                            linearLayout2.setVisibility(8);
                        }
                        ImageView imageView2 = this.mQrcodeGenerateImageView;
                        if (imageView2 != null) {
                            imageView2.setVisibility(0);
                        }
                        Option targetView = Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_btn_aigc_qrcode")).setTargetView(this.mQrcodeGenerateImageView);
                        ImageView imageView3 = this.mQrcodeGenerateImageView;
                        Intrinsics.checkNotNull(imageView3);
                        Option disableHardwareDecode = targetView.setRequestWidth(imageView3.getMeasuredWidth()).disableHardwareDecode();
                        ImageView imageView4 = this.mQrcodeGenerateImageView;
                        Intrinsics.checkNotNull(imageView4);
                        QCircleFeedPicLoader.g().loadImage(disableHardwareDecode.setRequestHeight(imageView4.getMeasuredHeight()), null);
                        return;
                    }
                    textView = this.mChangeHighTextView;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                    linearLayout = this.mQrcodeLL;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    imageView = this.mQrcodeGenerateImageView;
                    if (imageView == null) {
                        imageView.setVisibility(8);
                        return;
                    }
                    return;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
        QLog.d(this.TAG, 1, "aigcQrcodeInfo url is empty");
        qFSPersonalAigcQrcodeView = this.mAigcQrcodeView;
        if (qFSPersonalAigcQrcodeView != null) {
        }
        qFSPersonalNormalQrcodeView = this.mNormalQrcodeView;
        if (qFSPersonalNormalQrcodeView != null) {
        }
        if (!c.j0()) {
        }
        textView = this.mChangeHighTextView;
        if (textView != null) {
        }
        linearLayout = this.mQrcodeLL;
        if (linearLayout != null) {
        }
        imageView = this.mQrcodeGenerateImageView;
        if (imageView == null) {
        }
    }

    public final void c() {
        if (!this.mISAigcShow) {
            QFSPersonalNormalQrcodeView qFSPersonalNormalQrcodeView = this.mNormalQrcodeView;
            if (qFSPersonalNormalQrcodeView != null) {
                qFSPersonalNormalQrcodeView.i();
                return;
            }
            return;
        }
        QFSPersonalAigcQrcodeView qFSPersonalAigcQrcodeView = this.mAigcQrcodeView;
        if (qFSPersonalAigcQrcodeView != null) {
            qFSPersonalAigcQrcodeView.i();
        }
    }

    public final void d(@NotNull Consumer<String> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        if (!this.mISAigcShow) {
            QFSPersonalNormalQrcodeView qFSPersonalNormalQrcodeView = this.mNormalQrcodeView;
            if (qFSPersonalNormalQrcodeView != null) {
                qFSPersonalNormalQrcodeView.j(consumer);
                return;
            }
            return;
        }
        QFSPersonalAigcQrcodeView qFSPersonalAigcQrcodeView = this.mAigcQrcodeView;
        if (qFSPersonalAigcQrcodeView != null) {
            qFSPersonalAigcQrcodeView.j(consumer);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSPersonalQrcodeChangeEvent.class);
        return arrayListOf;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0076, code lost:
    
        if (r2 != false) goto L30;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(@Nullable View v3) {
        boolean z16;
        boolean z17;
        boolean z18;
        FeedCloudMeta$StShareURLInfo feedCloudMeta$StShareURLInfo;
        String str;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        FeedCloudMeta$StShare feedCloudMeta$StShare;
        PBRepeatMessageField<FeedCloudMeta$StShareURLInfo> pBRepeatMessageField;
        List<FeedCloudMeta$StShareURLInfo> list;
        Object obj;
        boolean z19;
        boolean z26;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null && v3.getId() == R.id.f34730zy) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mISAigcShow = false;
            LinearLayout linearLayout = this.mQrcodeLL;
            int i3 = this.ANIMATION_DURATION;
            d.l(linearLayout, i3, this.mChangeHighTextView, i3);
            QFSPersonalAigcQrcodeView qFSPersonalAigcQrcodeView = this.mAigcQrcodeView;
            int i16 = this.ANIMATION_DURATION;
            d.m(qFSPersonalAigcQrcodeView, i16, this.mNormalQrcodeView, i16, BasicAnimation.KeyPath.ROTATION_Y);
        } else {
            if (v3 != null && v3.getId() == R.id.f34720zx) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                this.mISAigcShow = true;
                TextView textView = this.mChangeHighTextView;
                int i17 = this.ANIMATION_DURATION;
                d.l(textView, i17, this.mQrcodeLL, i17);
                QFSPersonalNormalQrcodeView qFSPersonalNormalQrcodeView = this.mNormalQrcodeView;
                int i18 = this.ANIMATION_DURATION;
                d.m(qFSPersonalNormalQrcodeView, i18, this.mAigcQrcodeView, i18, BasicAnimation.KeyPath.ROTATION_Y);
            } else {
                if (v3 != null && v3.getId() == R.id.f43381mb) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18) {
                    if (v3 != null && v3.getId() == R.id.f34740zz) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                }
                QCircleShareInfo qCircleShareInfo = this.shareInfo;
                String str2 = null;
                if (qCircleShareInfo != null && (feedCloudMeta$StFeed = qCircleShareInfo.feed) != null && (feedCloudMeta$StShare = feedCloudMeta$StFeed.share) != null && (pBRepeatMessageField = feedCloudMeta$StShare.url_infos) != null && (list = pBRepeatMessageField.get()) != null) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (((FeedCloudMeta$StShareURLInfo) obj).type.get() == 1) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (z19) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    feedCloudMeta$StShareURLInfo = (FeedCloudMeta$StShareURLInfo) obj;
                } else {
                    feedCloudMeta$StShareURLInfo = null;
                }
                if (feedCloudMeta$StShareURLInfo != null && (pBStringField2 = feedCloudMeta$StShareURLInfo.url) != null) {
                    str = pBStringField2.get();
                } else {
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    QLog.d(this.TAG, 1, "QFSPersonalQrcodeFragment generate url is empty");
                } else {
                    Context context = getContext();
                    if (feedCloudMeta$StShareURLInfo != null && (pBStringField = feedCloudMeta$StShareURLInfo.url) != null) {
                        str2 = pBStringField.get();
                    }
                    com.tencent.biz.qqcircle.launcher.c.g(context, str2);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof QFSPersonalQrcodeChangeEvent) {
            QFSPersonalQrcodeChangeEvent qFSPersonalQrcodeChangeEvent = (QFSPersonalQrcodeChangeEvent) event;
            if (TextUtils.isEmpty(qFSPersonalQrcodeChangeEvent.getUrl())) {
                QLog.d(this.TAG, 1, "onReceiveEvent QFSPersonalQrcodeChangeEvent url is null");
                return;
            }
            QFSPersonalAigcQrcodeView qFSPersonalAigcQrcodeView = this.mAigcQrcodeView;
            if (qFSPersonalAigcQrcodeView != null) {
                qFSPersonalAigcQrcodeView.setQrcodeBackground(qFSPersonalQrcodeChangeEvent.getUrl());
            }
            e();
            b();
        }
    }
}

package com.tencent.biz.qqcircle.immersive.datacardcover.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.datacardcover.fragment.QFSPersonalCoverFeedFragment;
import com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverFeedItemView;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StVideo;
import feedcloud.FeedCloudMeta$StVideoUrl;
import h40.QFSPersonalCoverFeedInfo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J&\u0010\u0010\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u001c\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0011H\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J$\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0017j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\rH\u0014J\b\u0010 \u001a\u00020\bH\u0014R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006/"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverFeedItemView;", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverBaseItemView;", "Lh40/a;", "coverFeedInfo", "", "m0", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "", "v0", "", "Lfeedcloud/FeedCloudMeta$StVideoUrl;", "vecVideoList", "", "videoPrior", "objectWidth", "w0", "", "schemeAttrs", "", "x0", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/fragment/QFSPersonalCoverFeedFragment;", "u0", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "s0", "o0", "r0", "y0", "getLayoutId", c.G, "q0", "getLogTag", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "ivCover", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvPlayCount", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "f", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalCoverFeedItemView extends QFSPersonalCoverBaseItemView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView ivCover;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvPlayCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPersonalCoverFeedItemView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        y0();
    }

    private final void m0(final QFSPersonalCoverFeedInfo coverFeedInfo) {
        setOnClickListener(new View.OnClickListener() { // from class: k40.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPersonalCoverFeedItemView.n0(QFSPersonalCoverFeedItemView.this, coverFeedInfo, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(QFSPersonalCoverFeedItemView this$0, QFSPersonalCoverFeedInfo coverFeedInfo, View view) {
        PartManager partManager;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(coverFeedInfo, "$coverFeedInfo");
        HashMap<String, String> s06 = this$0.s0();
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setFeed(coverFeedInfo.getFeed());
        qCircleInitBean.setSchemeAttrs(s06);
        if (this$0.x0(s06)) {
            QFSPersonalCoverFeedFragment u06 = this$0.u0();
            if (u06 != null && (partManager = u06.getPartManager()) != null) {
                partManager.broadcastMessage("EVENT_DOWNLOAD_FEED", coverFeedInfo.getFeed());
            }
        } else if (Intrinsics.areEqual(s06.get("taskid"), "qq_dynamicAvatar")) {
            com.tencent.biz.qqcircle.launcher.c.D(this$0.getContext(), qCircleInitBean, this$0.v0(qCircleInitBean));
        } else {
            qCircleInitBean.setLaunchFrom("qq");
            com.tencent.biz.qqcircle.launcher.c.c0(this$0.getContext(), qCircleInitBean);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o0(final QFSPersonalCoverFeedInfo coverFeedInfo) {
        ImageView imageView = this.ivCover;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCover");
            imageView = null;
        }
        imageView.post(new Runnable() { // from class: k40.c
            @Override // java.lang.Runnable
            public final void run() {
                QFSPersonalCoverFeedItemView.p0(QFSPersonalCoverFeedInfo.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(QFSPersonalCoverFeedInfo coverFeedInfo, QFSPersonalCoverFeedItemView this$0) {
        Intrinsics.checkNotNullParameter(coverFeedInfo, "$coverFeedInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Option obtain = Option.obtain();
        obtain.setUrl(coverFeedInfo.getCoverUrl());
        ImageView imageView = this$0.ivCover;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCover");
            imageView = null;
        }
        obtain.setTargetView(imageView);
        obtain.setRequestWidth(this$0.getMeasuredWidth());
        obtain.setRequestHeight(this$0.getMeasuredHeight());
        obtain.setLoadingDrawableColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_skeleton));
        QCircleFeedPicLoader.g().loadImage(obtain);
    }

    private final void r0(QFSPersonalCoverFeedInfo coverFeedInfo) {
        TextView textView = this.tvPlayCount;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPlayCount");
            textView = null;
        }
        textView.setText(r.f(coverFeedInfo.getPlayCount()));
    }

    private final HashMap<String, String> s0() {
        Activity activity;
        Serializable serializable;
        QCircleInitBean qCircleInitBean;
        Intent intent;
        Context context = getContext();
        HashMap<String, String> hashMap = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && (intent = activity.getIntent()) != null) {
            serializable = intent.getSerializableExtra("key_bundle_common_init_bean");
        } else {
            serializable = null;
        }
        if (serializable instanceof QCircleInitBean) {
            qCircleInitBean = (QCircleInitBean) serializable;
        } else {
            qCircleInitBean = null;
        }
        if (qCircleInitBean != null) {
            hashMap = qCircleInitBean.getSchemeAttrs();
        }
        if (hashMap == null) {
            return new HashMap<>();
        }
        return hashMap;
    }

    private final QFSPersonalCoverFeedFragment u0() {
        FragmentActivity fragmentActivity;
        Fragment fragment;
        FragmentManager supportFragmentManager;
        Context context = getContext();
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null) {
            fragment = supportFragmentManager.findFragmentById(R.id.ckj);
        } else {
            fragment = null;
        }
        if (!(fragment instanceof QFSPersonalCoverFeedFragment)) {
            return null;
        }
        return (QFSPersonalCoverFeedFragment) fragment;
    }

    private final String v0(QCircleInitBean initBean) {
        String str;
        boolean z16;
        FeedCloudMeta$StVideo feedCloudMeta$StVideo = initBean.getFeed().video;
        if (feedCloudMeta$StVideo.videoPrior.get() == 4) {
            boolean isHighDevice = QCircleDeviceInfoUtils.isHighDevice();
            int i3 = feedCloudMeta$StVideo.width.get();
            List<FeedCloudMeta$StVideoUrl> list = feedCloudMeta$StVideo.vecVideoUrl.get();
            Intrinsics.checkNotNullExpressionValue(list, "video.vecVideoUrl.get()");
            boolean z17 = true;
            String w06 = w0(list, 1, i3);
            if (isHighDevice) {
                List<FeedCloudMeta$StVideoUrl> list2 = feedCloudMeta$StVideo.vecVideoUrl.get();
                Intrinsics.checkNotNullExpressionValue(list2, "video.vecVideoUrl.get()");
                str = w0(list2, 2, i3);
                if (str.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (w06.length() != 0) {
                        z17 = false;
                    }
                    if (z17) {
                        w06 = feedCloudMeta$StVideo.playUrl.get();
                    }
                }
                Intrinsics.checkNotNullExpressionValue(str, "{\n            // \u5982\u679c\u4e3a\u9ad8\u6027\u80fd\u8bbe\u2026}\n            }\n        }");
                return str;
            }
            if (w06.length() != 0) {
                z17 = false;
            }
            if (z17) {
                w06 = feedCloudMeta$StVideo.playUrl.get();
            }
            str = w06;
            Intrinsics.checkNotNullExpressionValue(str, "{\n            // \u5982\u679c\u4e3a\u9ad8\u6027\u80fd\u8bbe\u2026}\n            }\n        }");
            return str;
        }
        String str2 = feedCloudMeta$StVideo.playUrl.get();
        Intrinsics.checkNotNullExpressionValue(str2, "{\n            video.playUrl.get()\n        }");
        return str2;
    }

    private final String w0(List<FeedCloudMeta$StVideoUrl> vecVideoList, int videoPrior, int objectWidth) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Iterator<T> it = vecVideoList.iterator();
        String str = "";
        String str2 = str;
        while (true) {
            z16 = true;
            if (!it.hasNext()) {
                break;
            }
            FeedCloudMeta$StVideoUrl feedCloudMeta$StVideoUrl = (FeedCloudMeta$StVideoUrl) it.next();
            if (feedCloudMeta$StVideoUrl.videoPrior.get() == videoPrior) {
                if (feedCloudMeta$StVideoUrl.width.get() == objectWidth) {
                    String str3 = feedCloudMeta$StVideoUrl.playUrl.get();
                    Intrinsics.checkNotNullExpressionValue(str3, "it.playUrl.get()");
                    if (str3.length() > 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19) {
                        str = feedCloudMeta$StVideoUrl.playUrl.get();
                        Intrinsics.checkNotNullExpressionValue(str, "it.playUrl.get()");
                    }
                }
                if (str2.length() == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    String str4 = feedCloudMeta$StVideoUrl.playUrl.get();
                    Intrinsics.checkNotNullExpressionValue(str4, "it.playUrl.get()");
                    if (str4.length() <= 0) {
                        z16 = false;
                    }
                    if (z16) {
                        str2 = feedCloudMeta$StVideoUrl.playUrl.get();
                        Intrinsics.checkNotNullExpressionValue(str2, "it.playUrl.get()");
                    }
                }
            }
        }
        if (str.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return str;
        }
        if (str2.length() <= 0) {
            z16 = false;
        }
        if (!z16) {
            return "";
        }
        return str2;
    }

    private final boolean x0(Map<String, String> schemeAttrs) {
        Object obj;
        try {
            String str = schemeAttrs.get(QCircleScheme.AttrQQPublish.IS_FROM_RED_ENVELOPE);
            if (str != null) {
                obj = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
            } else {
                obj = null;
            }
        } catch (Exception e16) {
            QLog.w("QFSPersonalCoverFeedItemView", 1, "isFromMakeRedPacket, error ", e16);
            obj = Unit.INSTANCE;
        }
        return Intrinsics.areEqual(obj, (Object) 1);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gkq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    @NotNull
    public String getLogTag() {
        return "QFSPersonalCoverFeedItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void bindData(@NotNull QFSPersonalCoverFeedInfo coverFeedInfo, int pos) {
        Intrinsics.checkNotNullParameter(coverFeedInfo, "coverFeedInfo");
        o0(coverFeedInfo);
        r0(coverFeedInfo);
        m0(coverFeedInfo);
    }

    public void y0() {
        View findViewById = findViewById(R.id.duw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_cover)");
        this.ivCover = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.k_7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_play_count)");
        this.tvPlayCount = (TextView) findViewById2;
    }
}

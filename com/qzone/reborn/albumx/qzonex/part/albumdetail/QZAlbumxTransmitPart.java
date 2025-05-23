package com.qzone.reborn.albumx.qzonex.part.albumdetail;

import aa.f;
import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.bean.CommonTransmitBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxTaskDetailInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.queue.DownloadState;
import com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener;
import com.tencent.biz.richframework.queue.RFWDownloadTaskStateData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kc.b;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nc.bo;
import org.slf4j.Marker;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 k2\u00020\u00012\u00020\u0002:\u0001lB7\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\bi\u0010jJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u0012\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u000eH\u0003J\u0012\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u000eH\u0002J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\u0012\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u001c\u0010#\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010$\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010&\u001a\u00020%H\u0016R\u0016\u0010)\u001a\u0004\u0018\u00010%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u0004\u0018\u00010%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010.\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001b\u0010A\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R#\u0010G\u001a\n C*\u0004\u0018\u00010B0B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010>\u001a\u0004\bE\u0010FR#\u0010L\u001a\n C*\u0004\u0018\u00010H0H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u0010>\u001a\u0004\bJ\u0010KR\"\u0010S\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010[\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010^\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010V\u001a\u0004\b\\\u0010X\"\u0004\b]\u0010ZR\u0014\u0010`\u001a\u00020%8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b_\u0010(R\u0014\u0010b\u001a\u00020%8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\ba\u0010(R\u0014\u0010d\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bc\u0010NR\u0014\u0010f\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\be\u0010NR\u0016\u0010h\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010N\u00a8\u0006m"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/albumdetail/QZAlbumxTransmitPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/queue/RFWDownloadQueueResultListener;", "", "resId", "", "ca", "colorFilterId", "Landroid/graphics/drawable/Drawable;", "drawable", "ba", "Q9", "initData", "da", "", "showTypeIsDownload", "M9", "allSize", "L9", "aa", "showAnim", "Z9", "Y9", "Landroid/view/View;", "view", "N9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/biz/richframework/queue/RFWDownloadTaskStateData;", "taskStateData", "onStateChange", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "", "getLogTag", "d", "Ljava/lang/String;", "qzoneId", "e", "albumId", "f", "Ljava/lang/Integer;", "lottieSize", tl.h.F, "imageIconSizeDp", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "mIvTransmitQueenView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "mIvTransmitQueenRoot", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "mPublishBoxTaskNum", "Lnc/bo;", "D", "Lkotlin/Lazy;", "P9", "()Lnc/bo;", "publishQueueVm", "Lcom/qzone/reborn/albumx/common/viewmodel/m;", "kotlin.jvm.PlatformType", "E", "R9", "()Lcom/qzone/reborn/albumx/common/viewmodel/m;", "transmitVm", "Lnc/y;", UserInfo.SEX_FEMALE, "O9", "()Lnc/y;", "albumViewModel", "G", "I", "getMCurrentShowStatus", "()I", "setMCurrentShowStatus", "(I)V", "mCurrentShowStatus", "Lcom/airbnb/lottie/LottieDrawable;", "H", "Lcom/airbnb/lottie/LottieDrawable;", "getMPublishAnimation", "()Lcom/airbnb/lottie/LottieDrawable;", "setMPublishAnimation", "(Lcom/airbnb/lottie/LottieDrawable;)V", "mPublishAnimation", "getMDownloadAnimation", "setMDownloadAnimation", "mDownloadAnimation", "J", "UPLOAD_LOTTIE_ANIMATION_FILENAME", "K", "DOWNLOAD_LOTTIE_ANIMATION_FILENAME", "L", "LOTTIE_ANIMATION_W", "M", "LOTTIE_ANIMATION_H", "N", "lottieFilterColorId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "P", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxTransmitPart extends com.qzone.reborn.base.k implements RFWDownloadQueueResultListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mPublishBoxTaskNum;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy publishQueueVm;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy transmitVm;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy albumViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private int mCurrentShowStatus;

    /* renamed from: H, reason: from kotlin metadata */
    private LottieDrawable mPublishAnimation;

    /* renamed from: I, reason: from kotlin metadata */
    private LottieDrawable mDownloadAnimation;

    /* renamed from: J, reason: from kotlin metadata */
    private final String UPLOAD_LOTTIE_ANIMATION_FILENAME;

    /* renamed from: K, reason: from kotlin metadata */
    private final String DOWNLOAD_LOTTIE_ANIMATION_FILENAME;

    /* renamed from: L, reason: from kotlin metadata */
    private final int LOTTIE_ANIMATION_W;

    /* renamed from: M, reason: from kotlin metadata */
    private final int LOTTIE_ANIMATION_H;

    /* renamed from: N, reason: from kotlin metadata */
    private int lottieFilterColorId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String qzoneId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String albumId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Integer lottieSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Integer imageIconSizeDp;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mIvTransmitQueenView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View mIvTransmitQueenRoot;

    public /* synthetic */ QZAlbumxTransmitPart(String str, String str2, Integer num, Integer num2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : num, (i3 & 8) != 0 ? null : num2);
    }

    private final void L9(boolean showTypeIsDownload, int allSize) {
        String valueOf;
        View view = this.mIvTransmitQueenRoot;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenRoot");
            view = null;
        }
        view.setVisibility(0);
        if (showTypeIsDownload) {
            Y9(true);
        } else {
            Z9(true);
        }
        if (allSize > 99) {
            valueOf = 99 + Marker.ANY_NON_NULL_MARKER;
        } else {
            valueOf = String.valueOf(allSize);
        }
        TextView textView2 = this.mPublishBoxTaskNum;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishBoxTaskNum");
            textView2 = null;
        }
        textView2.setText(valueOf);
        TextView textView3 = this.mPublishBoxTaskNum;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishBoxTaskNum");
        } else {
            textView = textView3;
        }
        textView.setBackgroundResource(R.drawable.f170675);
    }

    private final void M9(boolean showTypeIsDownload) {
        View view = this.mIvTransmitQueenRoot;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenRoot");
            view = null;
        }
        view.setVisibility(0);
        if (showTypeIsDownload) {
            Y9(false);
        } else {
            Z9(false);
        }
    }

    private final nc.y O9() {
        return (nc.y) this.albumViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final bo P9() {
        return (bo) this.publishQueueVm.getValue();
    }

    private final int Q9() {
        int i3 = this.mCurrentShowStatus;
        if (i3 != 2) {
            return i3 != 3 ? 0 : 2;
        }
        return 1;
    }

    private final com.qzone.reborn.albumx.common.viewmodel.m R9() {
        return (com.qzone.reborn.albumx.common.viewmodel.m) this.transmitVm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(QZAlbumxTransmitPart this$0, LottieDrawable lottieDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LottieDrawable lottieDrawable2 = this$0.mPublishAnimation;
        if (lottieDrawable2 != null && lottieDrawable2.isRunning()) {
            lottieDrawable2.stop();
            lottieDrawable2.removeAllAnimatorListeners();
        }
        this$0.mPublishAnimation = lottieDrawable;
        this$0.ba(this$0.lottieFilterColorId, lottieDrawable);
        if (this$0.mPublishAnimation == null || this$0.mDownloadAnimation == null) {
            return;
        }
        this$0.da();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(QZAlbumxTransmitPart this$0, LottieDrawable lottieDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LottieDrawable lottieDrawable2 = this$0.mDownloadAnimation;
        if (lottieDrawable2 != null && lottieDrawable2.isRunning()) {
            lottieDrawable2.stop();
            lottieDrawable2.removeAllAnimatorListeners();
        }
        this$0.mDownloadAnimation = lottieDrawable;
        this$0.ba(this$0.lottieFilterColorId, lottieDrawable);
        if (this$0.mPublishAnimation == null || this$0.mDownloadAnimation == null) {
            return;
        }
        this$0.da();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(QZAlbumxTransmitPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.d("QZAlbumxTransmitPart", RFWLog.USR, "user click publish queen view");
        vb.b x16 = ho.i.x();
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String str = this$0.qzoneId;
        if (str == null) {
            str = "";
        }
        x16.k(context, new QZAlbumxTaskDetailInitBean(str, this$0.albumId, Integer.valueOf(this$0.Q9())));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void aa() {
        LottieDrawable lottieDrawable = this.mPublishAnimation;
        if (lottieDrawable != null) {
            lottieDrawable.stop();
        }
        LottieDrawable lottieDrawable2 = this.mDownloadAnimation;
        if (lottieDrawable2 != null) {
            lottieDrawable2.stop();
        }
    }

    private final void ba(int colorFilterId, Drawable drawable) {
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(getPartRootView().getResources().getColor(colorFilterId, null), PorterDuff.Mode.SRC_ATOP);
        KeyPath keyPath = new KeyPath("**");
        LottieValueCallback lottieValueCallback = new LottieValueCallback(porterDuffColorFilter);
        if (drawable != null && (drawable instanceof LottieDrawable)) {
            ((LottieDrawable) drawable).addValueCallback(keyPath, (KeyPath) LottieProperty.COLOR_FILTER, (LottieValueCallback<KeyPath>) lottieValueCallback);
        } else if (drawable != null) {
            drawable.setColorFilter(getContext().getResources().getColor(colorFilterId), PorterDuff.Mode.SRC_ATOP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ca(int resId) {
        this.lottieFilterColorId = resId;
        ba(resId, this.mPublishAnimation);
        ba(this.lottieFilterColorId, this.mDownloadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [android.view.View] */
    public final void da() {
        boolean z16;
        b.Companion companion = kc.b.INSTANCE;
        long j3 = companion.a().j(this.qzoneId);
        boolean k3 = companion.a().k(this.qzoneId);
        boolean l3 = companion.a().l(this.qzoneId);
        int i3 = companion.a().i(this.qzoneId);
        CommonTransmitBean value = P9().R1().getValue();
        boolean hasRunningTask = value != null ? value.getHasRunningTask() : false;
        CommonTransmitBean value2 = P9().R1().getValue();
        boolean hasWaitRunningTask = value2 != null ? value2.getHasWaitRunningTask() : false;
        CommonTransmitBean value3 = P9().R1().getValue();
        long lastBeginTime = value3 != null ? value3.getLastBeginTime() : 0L;
        CommonTransmitBean value4 = P9().R1().getValue();
        int taskSize = value4 != null ? value4.getTaskSize() : 0;
        int i16 = i3 + taskSize;
        TextView textView = null;
        if (i16 <= 0) {
            this.mCurrentShowStatus = 0;
            ?? r06 = this.mIvTransmitQueenRoot;
            if (r06 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenRoot");
            } else {
                textView = r06;
            }
            textView.setVisibility(8);
            return;
        }
        boolean z17 = j3 > lastBeginTime;
        if (hasRunningTask || k3) {
            z16 = (z17 && k3) || !hasRunningTask;
            this.mCurrentShowStatus = z16 ? 2 : 1;
            L9(z16, i16);
            return;
        }
        if (!hasWaitRunningTask && !l3) {
            View view = this.mIvTransmitQueenRoot;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenRoot");
                view = null;
            }
            view.setVisibility(0);
            if (i3 > 0) {
                this.mCurrentShowStatus = 2;
                LottieDrawable lottieDrawable = this.mDownloadAnimation;
                if (lottieDrawable != null) {
                    lottieDrawable.setFrame((int) lottieDrawable.getMaxFrame());
                    ImageView imageView = this.mIvTransmitQueenView;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
                        imageView = null;
                    }
                    imageView.setImageDrawable(lottieDrawable);
                    TextView textView2 = this.mPublishBoxTaskNum;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPublishBoxTaskNum");
                        textView2 = null;
                    }
                    textView2.setBackgroundResource(R.drawable.f17059q);
                }
            } else if (taskSize > 0) {
                this.mCurrentShowStatus = taskSize <= 0 ? 3 : 1;
                LottieDrawable lottieDrawable2 = this.mPublishAnimation;
                if (lottieDrawable2 != null) {
                    lottieDrawable2.setFrame((int) lottieDrawable2.getMaxFrame());
                    ImageView imageView2 = this.mIvTransmitQueenView;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
                        imageView2 = null;
                    }
                    imageView2.setImageDrawable(lottieDrawable2);
                    TextView textView3 = this.mPublishBoxTaskNum;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPublishBoxTaskNum");
                        textView3 = null;
                    }
                    textView3.setBackgroundResource(R.drawable.f17059q);
                }
            }
            aa();
            TextView textView4 = this.mPublishBoxTaskNum;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPublishBoxTaskNum");
            } else {
                textView = textView4;
            }
            textView.setText("");
            return;
        }
        z16 = (z17 && l3) || !hasWaitRunningTask;
        this.mCurrentShowStatus = z16 ? 2 : 1;
        M9(z16);
        TextView textView5 = this.mPublishBoxTaskNum;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishBoxTaskNum");
            textView5 = null;
        }
        textView5.setText("");
        TextView textView6 = this.mPublishBoxTaskNum;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishBoxTaskNum");
        } else {
            textView = textView6;
        }
        textView.setBackgroundResource(R.drawable.f17049p);
    }

    private final void initData() {
        bo P9 = P9();
        String str = this.qzoneId;
        if (str == null) {
            str = "";
        }
        P9.S1(str, this.albumId);
        LiveData<CommonTransmitBean> R1 = P9.R1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<CommonTransmitBean, Unit> function1 = new Function1<CommonTransmitBean, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxTransmitPart$initData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CommonTransmitBean commonTransmitBean) {
                invoke2(commonTransmitBean);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CommonTransmitBean commonTransmitBean) {
                QZAlbumxTransmitPart.this.da();
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.be
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxTransmitPart.S9(Function1.this, obj);
            }
        });
        da();
        MutableLiveData<CommonAlbumInfo> M1 = O9().M1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<CommonAlbumInfo, Unit> function12 = new Function1<CommonAlbumInfo, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxTransmitPart$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CommonAlbumInfo commonAlbumInfo) {
                invoke2(commonAlbumInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CommonAlbumInfo it) {
                bo P92;
                P92 = QZAlbumxTransmitPart.this.P9();
                com.qzone.reborn.albumx.qzonex.utils.k kVar = com.qzone.reborn.albumx.qzonex.utils.k.f53414a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                P92.X1(kVar.a(it));
            }
        };
        M1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.bf
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxTransmitPart.T9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxTransmitPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        kc.b.INSTANCE.a().r(this.qzoneId, this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        P9().onCleared();
        kc.b.INSTANCE.a().s(this.qzoneId, this);
        aa();
    }

    public QZAlbumxTransmitPart(String str, String str2, Integer num, Integer num2) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        this.qzoneId = str;
        this.albumId = str2;
        this.lottieSize = num;
        this.imageIconSizeDp = num2;
        RFWLog.i("QZAlbumxTransmitPart", RFWLog.USR, "init, qzoneId:" + str + ", albumId:" + str2);
        if (str == null || str.length() == 0) {
            RFWLog.fatal("QZAlbumxTransmitPart", RFWLog.USR, new RuntimeException("qzoneId should not be null or empty"));
        }
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<bo>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxTransmitPart$publishQueueVm$2
            @Override // kotlin.jvm.functions.Function0
            public final bo invoke() {
                return new bo();
            }
        });
        this.publishQueueVm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.qzone.reborn.albumx.common.viewmodel.m>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxTransmitPart$transmitVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.qzone.reborn.albumx.common.viewmodel.m invoke() {
                return (com.qzone.reborn.albumx.common.viewmodel.m) QZAlbumxTransmitPart.this.getViewModel(com.qzone.reborn.albumx.common.viewmodel.m.class);
            }
        });
        this.transmitVm = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<nc.y>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxTransmitPart$albumViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final nc.y invoke() {
                return (nc.y) QZAlbumxTransmitPart.this.getViewModel(nc.y.class);
            }
        });
        this.albumViewModel = lazy3;
        this.UPLOAD_LOTTIE_ANIMATION_FILENAME = "group_album/upload_lottie_animation.json";
        this.DOWNLOAD_LOTTIE_ANIMATION_FILENAME = "group_album/download_lottie_animation.json";
        this.LOTTIE_ANIMATION_W = 24;
        this.LOTTIE_ANIMATION_H = 24;
        this.lottieFilterColorId = R.color.qui_common_icon_nav_secondary;
    }

    private final void Y9(boolean showAnim) {
        ImageView imageView = null;
        if (showAnim) {
            LottieDrawable lottieDrawable = this.mDownloadAnimation;
            if (lottieDrawable == null || lottieDrawable.isRunning()) {
                return;
            }
            ImageView imageView2 = this.mIvTransmitQueenView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
            } else {
                imageView = imageView2;
            }
            imageView.setImageDrawable(lottieDrawable);
            lottieDrawable.start();
            return;
        }
        LottieDrawable lottieDrawable2 = this.mDownloadAnimation;
        if (lottieDrawable2 != null) {
            lottieDrawable2.setFrame((int) lottieDrawable2.getMaxFrame());
            ImageView imageView3 = this.mIvTransmitQueenView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
            } else {
                imageView = imageView3;
            }
            imageView.setImageDrawable(lottieDrawable2);
        }
    }

    private final void Z9(boolean showAnim) {
        ImageView imageView = null;
        if (showAnim) {
            LottieDrawable lottieDrawable = this.mPublishAnimation;
            if (lottieDrawable == null || lottieDrawable.isRunning()) {
                return;
            }
            ImageView imageView2 = this.mIvTransmitQueenView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
            } else {
                imageView = imageView2;
            }
            imageView.setImageDrawable(lottieDrawable);
            lottieDrawable.start();
            return;
        }
        LottieDrawable lottieDrawable2 = this.mPublishAnimation;
        if (lottieDrawable2 != null) {
            lottieDrawable2.setFrame((int) lottieDrawable2.getMaxFrame());
            ImageView imageView3 = this.mIvTransmitQueenView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
            } else {
                imageView = imageView3;
            }
            imageView.setImageDrawable(lottieDrawable2);
        }
    }

    @Override // com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener
    public void onStateChange(RFWDownloadTaskStateData taskStateData) {
        if ((taskStateData != null ? taskStateData.getState() : null) != DownloadState.STATE_RUNNING) {
            da();
        }
    }

    private final void N9(View view) {
        if (view == null) {
            return;
        }
        fo.c.o(view, "em_qz_outbox", new fo.b());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        int i3;
        int i16;
        int i17;
        int i18;
        MutableLiveData<Integer> M1;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        com.qzone.reborn.albumx.common.viewmodel.m R9 = R9();
        if (R9 != null && (M1 = R9.M1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxTransmitPart$onInitView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer it) {
                    QZAlbumxTransmitPart qZAlbumxTransmitPart = QZAlbumxTransmitPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    qZAlbumxTransmitPart.ca(it.intValue());
                }
            };
            M1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.ba
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZAlbumxTransmitPart.U9(Function1.this, obj);
                }
            });
        }
        Activity activity = getActivity();
        String str = this.UPLOAD_LOTTIE_ANIMATION_FILENAME;
        Integer num = this.lottieSize;
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = this.LOTTIE_ANIMATION_W;
        }
        int i19 = i3;
        Integer num2 = this.lottieSize;
        if (num2 != null) {
            i16 = num2.intValue();
        } else {
            i16 = this.LOTTIE_ANIMATION_H;
        }
        LottieHelper.b(activity, str, null, i19, i16, -1, new LottieHelper.d() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.bb
            @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
            public final void onLoad(LottieDrawable lottieDrawable) {
                QZAlbumxTransmitPart.V9(QZAlbumxTransmitPart.this, lottieDrawable);
            }
        });
        Activity activity2 = getActivity();
        String str2 = this.DOWNLOAD_LOTTIE_ANIMATION_FILENAME;
        Integer num3 = this.lottieSize;
        if (num3 != null) {
            i17 = num3.intValue();
        } else {
            i17 = this.LOTTIE_ANIMATION_W;
        }
        int i26 = i17;
        Integer num4 = this.lottieSize;
        if (num4 != null) {
            i18 = num4.intValue();
        } else {
            i18 = this.LOTTIE_ANIMATION_H;
        }
        LottieHelper.b(activity2, str2, null, i26, i18, -1, new LottieHelper.d() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.bc
            @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
            public final void onLoad(LottieDrawable lottieDrawable) {
                QZAlbumxTransmitPart.W9(QZAlbumxTransmitPart.this, lottieDrawable);
            }
        });
        View findViewById = rootView.findViewById(R.id.n6a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026mate_title_transmit_view)");
        this.mIvTransmitQueenRoot = findViewById;
        View findViewById2 = rootView.findViewById(R.id.n69);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026itle_transmit_image_view)");
        this.mIvTransmitQueenView = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.n6_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026title_transmit_text_view)");
        this.mPublishBoxTaskNum = (TextView) findViewById3;
        Integer num5 = this.imageIconSizeDp;
        ImageView imageView = null;
        if (num5 != null) {
            int intValue = num5.intValue();
            Integer num6 = this.imageIconSizeDp;
            if (num6 == null || num6.intValue() != 0) {
                ImageView imageView2 = this.mIvTransmitQueenView;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
                    imageView2 = null;
                }
                imageView2.getLayoutParams().width = ef.d.b(intValue);
                ImageView imageView3 = this.mIvTransmitQueenView;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
                    imageView3 = null;
                }
                imageView3.getLayoutParams().height = ef.d.b(intValue);
            }
        }
        ImageView imageView4 = this.mIvTransmitQueenView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
            imageView4 = null;
        }
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.bd
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZAlbumxTransmitPart.X9(QZAlbumxTransmitPart.this, view);
            }
        });
        f.Companion companion = aa.f.INSTANCE;
        View view = this.mIvTransmitQueenRoot;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenRoot");
            view = null;
        }
        companion.a(view);
        initData();
        ImageView imageView5 = this.mIvTransmitQueenView;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
        } else {
            imageView = imageView5;
        }
        N9(imageView);
    }
}

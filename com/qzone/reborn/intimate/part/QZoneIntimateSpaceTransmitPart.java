package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
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
import com.qzone.reborn.intimate.bean.init.QZoneIntimateTaskDetailInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.queue.DownloadState;
import com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener;
import com.tencent.biz.richframework.queue.RFWDownloadTaskStateData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.slf4j.Marker;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b!\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001]B\u001f\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010%\u00a2\u0006\u0004\b[\u0010\\J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u0012\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u000eH\u0003J\u0012\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u000eH\u0002J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u001c\u0010#\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010$\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010&\u001a\u00020%H\u0016R\u0016\u0010)\u001a\u0004\u0018\u00010%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u0004\u0018\u00010%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R#\u0010B\u001a\n >*\u0004\u0018\u00010=0=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u00109\u001a\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR$\u0010L\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010R\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010D\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010V\u001a\u00020\u00198\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bS\u0010G\u001a\u0004\bT\u0010I\"\u0004\bU\u0010KR\"\u0010Z\u001a\u00020\u00198\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bW\u0010G\u001a\u0004\bX\u0010I\"\u0004\bY\u0010K\u00a8\u0006^"}, d2 = {"Lcom/qzone/reborn/intimate/part/QZoneIntimateSpaceTransmitPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/queue/RFWDownloadQueueResultListener;", "", "resId", "", "Y9", "colorFilterId", "Landroid/graphics/drawable/Drawable;", "drawable", "X9", "N9", "initData", "Z9", "", "showTypeIsDownload", "I9", "allSize", "H9", "W9", "showAnim", "V9", "U9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/graphics/drawable/AnimationDrawable;", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/biz/richframework/queue/RFWDownloadTaskStateData;", "taskStateData", "onStateChange", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "", "getLogTag", "d", "Ljava/lang/String;", "spaceId", "e", "albumId", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mIvTransmitQueenView", tl.h.F, "Landroid/view/View;", "mIvTransmitQueenRoot", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mPublishBoxTaskNum", "Lnk/az;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "M9", "()Lnk/az;", "publishQueueVm", "Lcom/qzone/reborn/albumx/common/viewmodel/m;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "O9", "()Lcom/qzone/reborn/albumx/common/viewmodel/m;", "transmitVm", "D", "I", "lottieFilterColorId", "E", "Landroid/graphics/drawable/AnimationDrawable;", "getMCurrentAnimation", "()Landroid/graphics/drawable/AnimationDrawable;", "setMCurrentAnimation", "(Landroid/graphics/drawable/AnimationDrawable;)V", "mCurrentAnimation", UserInfo.SEX_FEMALE, "getMCurrentShowStatus", "()I", "setMCurrentShowStatus", "(I)V", "mCurrentShowStatus", "G", "L9", "T9", "mPublishAnimation", "H", "K9", "S9", "mDownloadAnimation", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateSpaceTransmitPart extends com.qzone.reborn.base.k implements RFWDownloadQueueResultListener {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy transmitVm;

    /* renamed from: D, reason: from kotlin metadata */
    private int lottieFilterColorId;

    /* renamed from: E, reason: from kotlin metadata */
    private AnimationDrawable mCurrentAnimation;

    /* renamed from: F, reason: from kotlin metadata */
    private int mCurrentShowStatus;

    /* renamed from: G, reason: from kotlin metadata */
    public AnimationDrawable mPublishAnimation;

    /* renamed from: H, reason: from kotlin metadata */
    public AnimationDrawable mDownloadAnimation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String spaceId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String albumId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mIvTransmitQueenView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View mIvTransmitQueenRoot;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mPublishBoxTaskNum;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy publishQueueVm;

    public /* synthetic */ QZoneIntimateSpaceTransmitPart(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2);
    }

    private final void H9(boolean showTypeIsDownload, int allSize) {
        String valueOf;
        View view = this.mIvTransmitQueenRoot;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenRoot");
            view = null;
        }
        view.setVisibility(0);
        if (showTypeIsDownload) {
            U9(true);
        } else {
            V9(true);
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

    private final void I9(boolean showTypeIsDownload) {
        View view = this.mIvTransmitQueenRoot;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenRoot");
            view = null;
        }
        view.setVisibility(0);
        if (showTypeIsDownload) {
            U9(false);
        } else {
            V9(false);
        }
    }

    private final AnimationDrawable J9(Activity activity, int resId) {
        Drawable drawable = ResourcesCompat.getDrawable(activity.getResources(), resId, null);
        if (drawable instanceof AnimationDrawable) {
            return (AnimationDrawable) drawable;
        }
        return new AnimationDrawable();
    }

    private final nk.az M9() {
        return (nk.az) this.publishQueueVm.getValue();
    }

    private final int N9() {
        return this.mCurrentShowStatus == 2 ? 1 : 0;
    }

    private final com.qzone.reborn.albumx.common.viewmodel.m O9() {
        return (com.qzone.reborn.albumx.common.viewmodel.m) this.transmitVm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(QZoneIntimateSpaceTransmitPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.d("QZoneIntimateSpaceTransmitPart", RFWLog.USR, "user click publish queen view");
        ck.c o16 = ho.i.o();
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String str = this$0.spaceId;
        if (str == null) {
            str = "";
        }
        o16.x(context, new QZoneIntimateTaskDetailInitBean(str, this$0.albumId, Integer.valueOf(this$0.N9())));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void W9() {
        AnimationDrawable animationDrawable = this.mCurrentAnimation;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
        this.mCurrentAnimation = null;
    }

    private final void X9(int colorFilterId, Drawable drawable) {
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
    public final void Y9(int resId) {
        this.lottieFilterColorId = resId;
        X9(resId, L9());
        X9(this.lottieFilterColorId, K9());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9() {
        long i3 = kj.b.l().i(this.spaceId);
        boolean j3 = kj.b.l().j(this.spaceId);
        boolean k3 = kj.b.l().k(this.spaceId);
        int h16 = kj.b.l().h(this.spaceId);
        CommonTransmitBean value = M9().R1().getValue();
        boolean hasRunningTask = value != null ? value.getHasRunningTask() : false;
        CommonTransmitBean value2 = M9().R1().getValue();
        boolean hasWaitRunningTask = value2 != null ? value2.getHasWaitRunningTask() : false;
        CommonTransmitBean value3 = M9().R1().getValue();
        long lastBeginTime = value3 != null ? value3.getLastBeginTime() : 0L;
        CommonTransmitBean value4 = M9().R1().getValue();
        int taskSize = (value4 != null ? value4.getTaskSize() : 0) + h16;
        View view = null;
        if (taskSize <= 0) {
            this.mCurrentShowStatus = 0;
            View view2 = this.mIvTransmitQueenRoot;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenRoot");
            } else {
                view = view2;
            }
            view.setVisibility(8);
            return;
        }
        boolean z16 = i3 > lastBeginTime;
        if (hasRunningTask || j3) {
            H9((z16 && j3) || !hasRunningTask, taskSize);
            return;
        }
        if (!hasWaitRunningTask && !k3) {
            View view3 = this.mIvTransmitQueenRoot;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenRoot");
                view3 = null;
            }
            view3.setVisibility(0);
            if (h16 > 0) {
                this.mCurrentShowStatus = 2;
                ImageView imageView = this.mIvTransmitQueenView;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
                    imageView = null;
                }
                imageView.setImageDrawable(K9().getFrame(K9().getNumberOfFrames() - 1));
            } else {
                this.mCurrentShowStatus = 1;
                ImageView imageView2 = this.mIvTransmitQueenView;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
                    imageView2 = null;
                }
                imageView2.setImageDrawable(L9().getFrame(L9().getNumberOfFrames() - 1));
            }
            W9();
            TextView textView = this.mPublishBoxTaskNum;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPublishBoxTaskNum");
                textView = null;
            }
            textView.setText("");
            TextView textView2 = this.mPublishBoxTaskNum;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPublishBoxTaskNum");
            } else {
                view = textView2;
            }
            view.setBackgroundResource(R.drawable.f17059q);
            return;
        }
        I9((z16 && k3) || !hasWaitRunningTask);
        TextView textView3 = this.mPublishBoxTaskNum;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishBoxTaskNum");
            textView3 = null;
        }
        textView3.setText("");
        TextView textView4 = this.mPublishBoxTaskNum;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishBoxTaskNum");
        } else {
            view = textView4;
        }
        view.setBackgroundResource(R.drawable.f17049p);
    }

    private final void initData() {
        nk.az M9 = M9();
        String str = this.spaceId;
        if (str == null) {
            str = "";
        }
        M9.S1(str, M9.getAlbumId());
        LiveData<CommonTransmitBean> R1 = M9.R1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<CommonTransmitBean, Unit> function1 = new Function1<CommonTransmitBean, Unit>() { // from class: com.qzone.reborn.intimate.part.QZoneIntimateSpaceTransmitPart$initData$1$1
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
                QZoneIntimateSpaceTransmitPart.this.Z9();
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.cv
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateSpaceTransmitPart.P9(Function1.this, obj);
            }
        });
        Z9();
    }

    public final AnimationDrawable K9() {
        AnimationDrawable animationDrawable = this.mDownloadAnimation;
        if (animationDrawable != null) {
            return animationDrawable;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDownloadAnimation");
        return null;
    }

    public final AnimationDrawable L9() {
        AnimationDrawable animationDrawable = this.mPublishAnimation;
        if (animationDrawable != null) {
            return animationDrawable;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPublishAnimation");
        return null;
    }

    public final void S9(AnimationDrawable animationDrawable) {
        Intrinsics.checkNotNullParameter(animationDrawable, "<set-?>");
        this.mDownloadAnimation = animationDrawable;
    }

    public final void T9(AnimationDrawable animationDrawable) {
        Intrinsics.checkNotNullParameter(animationDrawable, "<set-?>");
        this.mPublishAnimation = animationDrawable;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateSpaceTransmitPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        MutableLiveData<Integer> M1;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        com.qzone.reborn.albumx.common.viewmodel.m O9 = O9();
        if (O9 != null && (M1 = O9.M1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.qzone.reborn.intimate.part.QZoneIntimateSpaceTransmitPart$onInitView$1
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
                    try {
                        QZoneIntimateSpaceTransmitPart qZoneIntimateSpaceTransmitPart = QZoneIntimateSpaceTransmitPart.this;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        qZoneIntimateSpaceTransmitPart.Y9(it.intValue());
                    } catch (Throwable th5) {
                        QLog.e("QZoneIntimateSpaceTransmitPart", 1, "throwable is " + th5);
                    }
                }
            };
            M1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.ct
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZoneIntimateSpaceTransmitPart.Q9(Function1.this, obj);
                }
            });
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        T9(J9(activity, R.drawable.f171376));
        L9().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        S9(J9(activity2, R.drawable.f14532e));
        K9().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        View findViewById = rootView.findViewById(R.id.n6a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026mate_title_transmit_view)");
        this.mIvTransmitQueenRoot = findViewById;
        View findViewById2 = rootView.findViewById(R.id.n69);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026itle_transmit_image_view)");
        this.mIvTransmitQueenView = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.n6_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026title_transmit_text_view)");
        this.mPublishBoxTaskNum = (TextView) findViewById3;
        ImageView imageView = this.mIvTransmitQueenView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.cu
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneIntimateSpaceTransmitPart.R9(QZoneIntimateSpaceTransmitPart.this, view);
            }
        });
        initData();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        kj.b.l().s(this.spaceId, this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        M9().onCleared();
        kj.b.l().t(this.spaceId, this);
    }

    public QZoneIntimateSpaceTransmitPart(String str, String str2) {
        Lazy lazy;
        Lazy lazy2;
        this.spaceId = str;
        this.albumId = str2;
        RFWLog.i("QZoneIntimateSpaceTransmitPart", RFWLog.USR, "init, spaceId:" + str + ", albumId:" + str2);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<nk.az>() { // from class: com.qzone.reborn.intimate.part.QZoneIntimateSpaceTransmitPart$publishQueueVm$2
            @Override // kotlin.jvm.functions.Function0
            public final nk.az invoke() {
                return new nk.az();
            }
        });
        this.publishQueueVm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.qzone.reborn.albumx.common.viewmodel.m>() { // from class: com.qzone.reborn.intimate.part.QZoneIntimateSpaceTransmitPart$transmitVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.qzone.reborn.albumx.common.viewmodel.m invoke() {
                return (com.qzone.reborn.albumx.common.viewmodel.m) QZoneIntimateSpaceTransmitPart.this.getViewModel(com.qzone.reborn.albumx.common.viewmodel.m.class);
            }
        });
        this.transmitVm = lazy2;
        this.lottieFilterColorId = R.color.qui_common_text_primary;
    }

    private final void U9(boolean showAnim) {
        this.mCurrentShowStatus = 2;
        W9();
        ImageView imageView = null;
        if (showAnim) {
            this.mCurrentAnimation = K9();
            AnimationDrawable K9 = K9();
            ImageView imageView2 = this.mIvTransmitQueenView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
            } else {
                imageView = imageView2;
            }
            imageView.setImageDrawable(K9);
            K9.start();
            return;
        }
        ImageView imageView3 = this.mIvTransmitQueenView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
        } else {
            imageView = imageView3;
        }
        imageView.setImageDrawable(K9().getFrame(K9().getNumberOfFrames() - 1));
    }

    private final void V9(boolean showAnim) {
        this.mCurrentShowStatus = 1;
        W9();
        ImageView imageView = null;
        if (showAnim) {
            this.mCurrentAnimation = L9();
            AnimationDrawable L9 = L9();
            ImageView imageView2 = this.mIvTransmitQueenView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
            } else {
                imageView = imageView2;
            }
            imageView.setImageDrawable(L9);
            L9.start();
            return;
        }
        ImageView imageView3 = this.mIvTransmitQueenView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
        } else {
            imageView = imageView3;
        }
        imageView.setImageDrawable(L9().getFrame(L9().getNumberOfFrames() - 1));
    }

    @Override // com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener
    public void onStateChange(RFWDownloadTaskStateData taskStateData) {
        if ((taskStateData != null ? taskStateData.getState() : null) != DownloadState.STATE_RUNNING) {
            Z9();
        }
    }
}

package com.qzone.reborn.feedx.part.eventtag;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.feedx.viewmodel.QZoneFeedxEventTagViewModel;
import com.qzone.reborn.feedx.widget.eventtag.QZoneFeedEventTagHeadView;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.f;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneTagFeedList$GetTagFeedListHeadRsp;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/qzone/reborn/feedx/part/eventtag/QZoneFeedxEventTagHeadPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "M9", "K9", "initViewModel", "O9", "Lqzone/QZoneTagFeedList$GetTagFeedListHeadRsp;", "tagHeadData", "L9", "", "coverUrl", "T9", "P9", "U9", "getLogTag", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartDestroy", "Lcom/qzone/reborn/feedx/widget/eventtag/QZoneFeedEventTagHeadView;", "d", "Lcom/qzone/reborn/feedx/widget/eventtag/QZoneFeedEventTagHeadView;", "mEventTagHeadView", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "mFlCoverContainer", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "f", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "mCoverBlurView", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "mIvCoverView", "i", "mIvCoverMaskView", "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxEventTagViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxEventTagViewModel;", "mEventTagViewModel", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedxEventTagHeadPart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZoneFeedEventTagHeadView mEventTagHeadView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mFlCoverContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QQBlurViewWrapper mCoverBlurView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mIvCoverView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mIvCoverMaskView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneFeedxEventTagViewModel mEventTagViewModel;

    private final void K9() {
        FrameLayout frameLayout = this.mFlCoverContainer;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlCoverContainer");
            frameLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -1;
            layoutParams.height = QZoneFeedEventTagHeadView.INSTANCE.a() + ar.d(100.0f);
            FrameLayout frameLayout3 = this.mFlCoverContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFlCoverContainer");
                frameLayout3 = null;
            }
            frameLayout3.setLayoutParams(layoutParams);
        }
        FrameLayout frameLayout4 = this.mFlCoverContainer;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlCoverContainer");
            frameLayout4 = null;
        }
        if (frameLayout4.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            FrameLayout frameLayout5 = this.mFlCoverContainer;
            if (frameLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFlCoverContainer");
            } else {
                frameLayout2 = frameLayout5;
            }
            ViewGroup.LayoutParams layoutParams2 = frameLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = ar.d(100.0f) * (-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(QZoneTagFeedList$GetTagFeedListHeadRsp tagHeadData) {
        String str;
        RFWLog.i("QZoneFeedxEventTagHeadPart", RFWLog.USR, "bindTagCoverView config tag " + tagHeadData.is_operation_tag.get());
        if (QQTheme.isNowThemeIsNightForQzone()) {
            str = tagHeadData.tag_cover_dark_mode.get();
        } else {
            str = tagHeadData.tag_cover.get();
        }
        if (com.qzone.reborn.configx.g.f53821a.b().U()) {
            U9(str);
            return;
        }
        ImageView imageView = this.mIvCoverMaskView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvCoverMaskView");
            imageView = null;
        }
        imageView.setVisibility(0);
        if (tagHeadData.is_operation_tag.get()) {
            P9(str);
        } else {
            T9(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9() {
        Integer valueOf = Integer.valueOf("629");
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(QZoneClickReport\u2026ENT_TAG_FEED_ACTION_TYPE)");
        int intValue = valueOf.intValue();
        Integer valueOf2 = Integer.valueOf("1");
        Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(QZoneClickReport\u2026AG.EXPOSE_SUBACTION_TYPE)");
        int intValue2 = valueOf2.intValue();
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel = this.mEventTagViewModel;
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel2 = null;
        if (qZoneFeedxEventTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEventTagViewModel");
            qZoneFeedxEventTagViewModel = null;
        }
        Integer source2 = qZoneFeedxEventTagViewModel.v2().getSource2();
        int intValue3 = source2 != null ? source2.intValue() : 0;
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel3 = this.mEventTagViewModel;
        if (qZoneFeedxEventTagViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEventTagViewModel");
        } else {
            qZoneFeedxEventTagViewModel2 = qZoneFeedxEventTagViewModel3;
        }
        LpReportInfo_pf00064.allReport(intValue, intValue2, intValue3, qZoneFeedxEventTagViewModel2.v2().getEventTag());
    }

    private final void P9(String coverUrl) {
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(coverUrl);
        e16.disableHardwareDecode();
        e16.setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        FrameLayout frameLayout = this.mFlCoverContainer;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlCoverContainer");
            frameLayout = null;
        }
        e16.setRequestWidth(frameLayout.getLayoutParams().width);
        FrameLayout frameLayout3 = this.mFlCoverContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlCoverContainer");
        } else {
            frameLayout2 = frameLayout3;
        }
        e16.setRequestHeight(frameLayout2.getLayoutParams().height);
        e16.setLoadingDrawable(getActivity().getResources().getDrawable(R.drawable.f15123j));
        e16.setFailDrawable(getActivity().getResources().getDrawable(R.drawable.f15123j));
        com.tencent.mobileqq.qzone.picload.c.a().i(e16, new IPicLoadStateListener() { // from class: com.qzone.reborn.feedx.part.eventtag.e
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZoneFeedxEventTagHeadPart.Q9(QZoneFeedxEventTagHeadPart.this, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(final QZoneFeedxEventTagHeadPart this$0, LoadState loadState, final Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState.isFinish()) {
            if (!loadState.isFinishError() && option.getResultBitMap() != null) {
                RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.part.eventtag.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZoneFeedxEventTagHeadPart.R9(QZoneFeedxEventTagHeadPart.this, option);
                    }
                });
                return;
            }
            RFWLog.e("QZoneFeedxEventTagHeadPart", RFWLog.USR, "loadImage | state = " + loadState + " | url = " + option.getUrl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(final QZoneFeedxEventTagHeadPart this$0, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i40.a aVar = i40.a.f407180a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Bitmap resultBitMap = option.getResultBitMap();
        Intrinsics.checkNotNullExpressionValue(resultBitMap, "option.resultBitMap");
        final Bitmap b16 = i40.a.b(aVar, context, resultBitMap, 15.0f, 2, 0, 16, null);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.part.eventtag.g
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFeedxEventTagHeadPart.S9(QZoneFeedxEventTagHeadPart.this, b16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(QZoneFeedxEventTagHeadPart this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.mIvCoverView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvCoverView");
            imageView = null;
        }
        imageView.setImageBitmap(bitmap);
    }

    private final void T9(String coverUrl) {
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(coverUrl);
        ImageView imageView = this.mIvCoverView;
        FrameLayout frameLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvCoverView");
            imageView = null;
        }
        e16.setTargetView(imageView);
        FrameLayout frameLayout2 = this.mFlCoverContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlCoverContainer");
            frameLayout2 = null;
        }
        e16.setRequestWidth(frameLayout2.getLayoutParams().width);
        FrameLayout frameLayout3 = this.mFlCoverContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlCoverContainer");
        } else {
            frameLayout = frameLayout3;
        }
        e16.setRequestHeight(frameLayout.getLayoutParams().height);
        e16.setLoadingDrawable(getActivity().getResources().getDrawable(R.drawable.f15123j));
        e16.setFailDrawable(getActivity().getResources().getDrawable(R.drawable.f15123j));
        com.tencent.mobileqq.qzone.picload.c.a().h(e16);
    }

    private final void U9(String coverUrl) {
        final Drawable drawable = getActivity().getResources().getDrawable(R.drawable.f15123j);
        Option obtain = Option.obtain();
        obtain.setUrl(coverUrl);
        ImageView imageView = this.mIvCoverView;
        FrameLayout frameLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvCoverView");
            imageView = null;
        }
        obtain.setTargetView(imageView);
        FrameLayout frameLayout2 = this.mFlCoverContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlCoverContainer");
            frameLayout2 = null;
        }
        obtain.setRequestWidth(frameLayout2.getLayoutParams().width);
        FrameLayout frameLayout3 = this.mFlCoverContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlCoverContainer");
        } else {
            frameLayout = frameLayout3;
        }
        obtain.setRequestHeight(frameLayout.getLayoutParams().height);
        obtain.setLoadingDrawable(drawable);
        obtain.setFailDrawable(drawable);
        com.tencent.mobileqq.qzone.picload.c.a().i(obtain, new IPicLoadStateListener() { // from class: com.qzone.reborn.feedx.part.eventtag.d
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZoneFeedxEventTagHeadPart.V9(QZoneFeedxEventTagHeadPart.this, drawable, loadState, option);
            }
        });
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(QZoneFeedxEventTagViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneFeedxE\u2026TagViewModel::class.java)");
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel = (QZoneFeedxEventTagViewModel) viewModel;
        this.mEventTagViewModel = qZoneFeedxEventTagViewModel;
        if (qZoneFeedxEventTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEventTagViewModel");
            qZoneFeedxEventTagViewModel = null;
        }
        MutableLiveData<QZoneTagFeedList$GetTagFeedListHeadRsp> w26 = qZoneFeedxEventTagViewModel.w2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<QZoneTagFeedList$GetTagFeedListHeadRsp, Unit> function1 = new Function1<QZoneTagFeedList$GetTagFeedListHeadRsp, Unit>() { // from class: com.qzone.reborn.feedx.part.eventtag.QZoneFeedxEventTagHeadPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QZoneTagFeedList$GetTagFeedListHeadRsp qZoneTagFeedList$GetTagFeedListHeadRsp) {
                invoke2(qZoneTagFeedList$GetTagFeedListHeadRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QZoneTagFeedList$GetTagFeedListHeadRsp qZoneTagFeedList$GetTagFeedListHeadRsp) {
                QZoneFeedEventTagHeadView qZoneFeedEventTagHeadView;
                if (qZoneTagFeedList$GetTagFeedListHeadRsp != null) {
                    QZoneFeedxEventTagHeadPart qZoneFeedxEventTagHeadPart = QZoneFeedxEventTagHeadPart.this;
                    qZoneFeedEventTagHeadView = qZoneFeedxEventTagHeadPart.mEventTagHeadView;
                    if (qZoneFeedEventTagHeadView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEventTagHeadView");
                        qZoneFeedEventTagHeadView = null;
                    }
                    qZoneFeedEventTagHeadView.setData(qZoneTagFeedList$GetTagFeedListHeadRsp);
                    qZoneFeedxEventTagHeadPart.L9(qZoneTagFeedList$GetTagFeedListHeadRsp);
                    qZoneFeedxEventTagHeadPart.O9();
                }
            }
        };
        w26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.feedx.part.eventtag.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneFeedxEventTagHeadPart.N9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxEventTagHeadPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        M9(rootView);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QQBlurViewWrapper qQBlurViewWrapper = this.mCoverBlurView;
        QQBlurViewWrapper qQBlurViewWrapper2 = null;
        if (qQBlurViewWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverBlurView");
            qQBlurViewWrapper = null;
        }
        if (qQBlurViewWrapper.getVisibility() == 0) {
            QQBlurViewWrapper qQBlurViewWrapper3 = this.mCoverBlurView;
            if (qQBlurViewWrapper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCoverBlurView");
            } else {
                qQBlurViewWrapper2 = qQBlurViewWrapper3;
            }
            qQBlurViewWrapper2.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QQBlurViewWrapper qQBlurViewWrapper = this.mCoverBlurView;
        QQBlurViewWrapper qQBlurViewWrapper2 = null;
        if (qQBlurViewWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverBlurView");
            qQBlurViewWrapper = null;
        }
        if (qQBlurViewWrapper.getVisibility() == 0) {
            QQBlurViewWrapper qQBlurViewWrapper3 = this.mCoverBlurView;
            if (qQBlurViewWrapper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCoverBlurView");
            } else {
                qQBlurViewWrapper2 = qQBlurViewWrapper3;
            }
            qQBlurViewWrapper2.onPause();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QQBlurViewWrapper qQBlurViewWrapper = this.mCoverBlurView;
        QQBlurViewWrapper qQBlurViewWrapper2 = null;
        if (qQBlurViewWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverBlurView");
            qQBlurViewWrapper = null;
        }
        if (qQBlurViewWrapper.getVisibility() == 0) {
            QQBlurViewWrapper qQBlurViewWrapper3 = this.mCoverBlurView;
            if (qQBlurViewWrapper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCoverBlurView");
            } else {
                qQBlurViewWrapper2 = qQBlurViewWrapper3;
            }
            qQBlurViewWrapper2.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(QZoneFeedxEventTagHeadPart this$0, Drawable drawable, LoadState loadState, Option option) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState.isFinish()) {
            QQBlurViewWrapper qQBlurViewWrapper = this$0.mCoverBlurView;
            QQBlurViewWrapper qQBlurViewWrapper2 = null;
            if (qQBlurViewWrapper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCoverBlurView");
                qQBlurViewWrapper = null;
            }
            qQBlurViewWrapper.setVisibility(0);
            com.tencent.qui.quiblurview.c cVar = com.tencent.qui.quiblurview.c.f363628c;
            Activity activity = this$0.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            boolean b16 = cVar.b(activity);
            if (!loadState.isFinishError() && option.getResultBitMap() != null && b16) {
                QQBlurViewWrapper qQBlurViewWrapper3 = this$0.mCoverBlurView;
                if (qQBlurViewWrapper3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCoverBlurView");
                    qQBlurViewWrapper3 = null;
                }
                float e16 = ar.e(10.0f);
                ImageView imageView2 = this$0.mIvCoverView;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvCoverView");
                    imageView = null;
                } else {
                    imageView = imageView2;
                }
                f.a aVar = new f.a(true, e16, imageView, 0, new ColorDrawable(0), Integer.valueOf(R.drawable.qui_common_bg_nav_aio_bg));
                aVar.l(true);
                qQBlurViewWrapper3.a(aVar);
                return;
            }
            RFWLog.e("QZoneFeedxEventTagHeadPart", RFWLog.USR, "loadImage | state = " + loadState + " | url = " + option.getUrl());
            QQBlurViewWrapper qQBlurViewWrapper4 = this$0.mCoverBlurView;
            if (qQBlurViewWrapper4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCoverBlurView");
            } else {
                qQBlurViewWrapper2 = qQBlurViewWrapper4;
            }
            qQBlurViewWrapper2.setBackground(drawable);
        }
    }

    private final void M9(View rootView) {
        View findViewById = rootView.findViewById(R.id.mup);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_event_tag_head_view)");
        this.mEventTagHeadView = (QZoneFeedEventTagHeadView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.muk);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_event_tag_cover_container)");
        this.mFlCoverContainer = (FrameLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.muj);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_event_tag_cover_blur_view)");
        this.mCoverBlurView = (QQBlurViewWrapper) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.mul);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qzone_event_tag_cover_iv)");
        this.mIvCoverView = (ImageView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.mum);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qzone_event_tag_cover_mask)");
        this.mIvCoverMaskView = (ImageView) findViewById5;
        K9();
    }
}

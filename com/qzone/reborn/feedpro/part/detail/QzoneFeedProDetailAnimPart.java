package com.qzone.reborn.feedpro.part.detail;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedpro.utils.QzoneFeedProAnimTimeParams;
import com.qzone.reborn.feedx.event.QZoneFeedxDetailAnimEvent;
import com.qzone.reborn.feedx.widget.title.QZoneCommonTitle;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.api.AnimationParams;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/qzone/reborn/feedpro/part/detail/QzoneFeedProDetailAnimPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/guild/feed/api/AnimationParams;", "source", "", "C9", "D9", "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "onBackEvent", "Lcom/qzone/reborn/feedx/widget/title/QZoneCommonTitle;", "d", "Lcom/qzone/reborn/feedx/widget/title/QZoneCommonTitle;", "mTitleView", "e", "Z", "needFinishAnim", "", "f", UserInfo.SEX_FEMALE, "startScaleX", tl.h.F, "startScaleY", "i", "startTranslationX", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "startTranslationY", "Landroid/graphics/Rect;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/Rect;", "startClipBounds", "D", "endClipBounds", "Lcom/qzone/reborn/feedpro/utils/f;", "E", "Lcom/qzone/reborn/feedpro/utils/f;", "animTimeParams", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProDetailAnimPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZoneCommonTitle mTitleView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needFinishAnim;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float startTranslationX;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float startTranslationY;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float startScaleX = 1.0f;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float startScaleY = 1.0f;

    /* renamed from: C, reason: from kotlin metadata */
    private Rect startClipBounds = new Rect();

    /* renamed from: D, reason: from kotlin metadata */
    private Rect endClipBounds = new Rect();

    /* renamed from: E, reason: from kotlin metadata */
    private QzoneFeedProAnimTimeParams animTimeParams = new QzoneFeedProAnimTimeParams(165, 0, 55, 0);

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/feedpro/part/detail/QzoneFeedProDetailAnimPart$b", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f54029d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QzoneFeedProDetailAnimPart f54030e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AnimationParams f54031f;

        b(View view, QzoneFeedProDetailAnimPart qzoneFeedProDetailAnimPart, AnimationParams animationParams) {
            this.f54029d = view;
            this.f54030e = qzoneFeedProDetailAnimPart;
            this.f54031f = animationParams;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f54029d.getViewTreeObserver().removeOnPreDrawListener(this);
            QzoneFeedProDetailAnimPart qzoneFeedProDetailAnimPart = this.f54030e;
            QZoneCommonTitle qZoneCommonTitle = (QZoneCommonTitle) this.f54029d.findViewById(R.id.mz9);
            if (qZoneCommonTitle == null) {
                return true;
            }
            qzoneFeedProDetailAnimPart.mTitleView = qZoneCommonTitle;
            RFWLog.d("QzoneFeedProDetailAnimPart", RFWLog.USR, "source: " + this.f54031f.getScreenX() + " " + this.f54031f.getScreenY() + " " + this.f54031f.getWidthSource() + " " + this.f54031f.getHeightSource());
            this.f54030e.C9(this.f54031f);
            this.f54030e.D9();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D9() {
        RFWLog.d("QzoneFeedProDetailAnimPart", RFWLog.USR, "cur clipBounds: " + this.startClipBounds);
        View partRootView = getPartRootView();
        Float valueOf = Float.valueOf(this.startScaleX);
        Float valueOf2 = Float.valueOf(1.0f);
        Pair pair = TuplesKt.to(valueOf, valueOf2);
        Pair pair2 = TuplesKt.to(Float.valueOf(this.startScaleY), valueOf2);
        Float valueOf3 = Float.valueOf(this.startTranslationX);
        Float valueOf4 = Float.valueOf(0.0f);
        com.qzone.reborn.feedpro.utils.i.e(partRootView, pair, pair2, TuplesKt.to(valueOf3, valueOf4), TuplesKt.to(Float.valueOf(this.startTranslationY), valueOf4), TuplesKt.to(this.startClipBounds, this.endClipBounds), TuplesKt.to(valueOf4, valueOf2), this.animTimeParams, new Function0<Unit>() { // from class: com.qzone.reborn.feedpro.part.detail.QzoneFeedProDetailAnimPart$startOpenAnim$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SimpleEventBus.getInstance().dispatchEvent(new QZoneFeedxDetailAnimEvent(true));
            }
        }, new Function0<Unit>() { // from class: com.qzone.reborn.feedpro.part.detail.QzoneFeedProDetailAnimPart$startOpenAnim$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SimpleEventBus.getInstance().dispatchEvent(new QZoneFeedxDetailAnimEvent(false));
                QzoneFeedProDetailAnimPart.this.needFinishAnim = true;
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (!this.needFinishAnim) {
            return false;
        }
        E9();
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        AnimationParams animationParams = (AnimationParams) getActivity().getIntent().getParcelableExtra("feed_detail_animation_params");
        if (animationParams == null) {
            return;
        }
        rootView.getViewTreeObserver().addOnPreDrawListener(new b(rootView, this, animationParams));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C9(AnimationParams source) {
        this.startScaleX = 1.0f;
        this.startScaleY = 1.0f;
        QZoneCommonTitle qZoneCommonTitle = this.mTitleView;
        if (qZoneCommonTitle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
            qZoneCommonTitle = null;
        }
        int height = qZoneCommonTitle.getHeight();
        this.startTranslationX = 0.0f;
        float f16 = height;
        this.startTranslationY = source.getScreenY() - f16;
        RFWLog.d("QzoneFeedProDetailAnimPart", RFWLog.USR, "cur offsetY: " + height);
        this.startClipBounds = new Rect(0, height, getPartRootView().getWidth(), (int) (source.getHeightSource() / this.startScaleY));
        this.endClipBounds = new Rect(0, 0, getPartRootView().getWidth(), getPartRootView().getHeight());
        View partRootView = getPartRootView();
        partRootView.setPivotX(0.0f);
        partRootView.setPivotY(f16);
    }

    private final void E9() {
        QzoneFeedProAnimTimeParams a16;
        this.needFinishAnim = false;
        View partRootView = getPartRootView();
        Float valueOf = Float.valueOf(1.0f);
        Pair pair = TuplesKt.to(valueOf, Float.valueOf(this.startScaleX));
        Pair pair2 = TuplesKt.to(valueOf, Float.valueOf(this.startScaleY));
        Float valueOf2 = Float.valueOf(0.0f);
        Pair pair3 = TuplesKt.to(valueOf2, Float.valueOf(this.startTranslationX));
        Pair pair4 = TuplesKt.to(valueOf2, Float.valueOf(this.startTranslationY));
        Pair pair5 = TuplesKt.to(this.endClipBounds, this.startClipBounds);
        Pair pair6 = TuplesKt.to(valueOf, valueOf2);
        a16 = r9.a((r18 & 1) != 0 ? r9.totalDuration : 0L, (r18 & 2) != 0 ? r9.totalStartDelay : 0L, (r18 & 4) != 0 ? r9.alphaDuration : 0L, (r18 & 8) != 0 ? this.animTimeParams.alphaStartDelay : 110L);
        com.qzone.reborn.feedpro.utils.i.e(partRootView, pair, pair2, pair3, pair4, pair5, pair6, (r33 & 64) != 0 ? new QzoneFeedProAnimTimeParams(0L, 0L, 0L, 0L, 15, null) : a16, (r33 & 128) != 0 ? null : null, (r33 & 256) != 0 ? null : new Function0<Unit>() { // from class: com.qzone.reborn.feedpro.part.detail.QzoneFeedProDetailAnimPart$startReverseAnim$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Activity activity = QzoneFeedProDetailAnimPart.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
                Activity activity2 = QzoneFeedProDetailAnimPart.this.getActivity();
                if (activity2 != null) {
                    activity2.overridePendingTransition(0, 0);
                }
            }
        });
    }
}

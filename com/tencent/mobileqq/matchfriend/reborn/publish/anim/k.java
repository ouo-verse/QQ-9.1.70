package com.tencent.mobileqq.matchfriend.reborn.publish.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.publish.anim.k;
import com.tencent.mobileqq.matchfriend.widget.RoundCornerImageView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000 \u0082\u00012\u00020\u00012\u00020\u0002:\u0002\u0083\u0001B\u0013\u0012\b\b\u0002\u0010/\u001a\u00020\u0005\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u0011\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016J,\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u001c\u0010\u001c\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\u001c\u0010!\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010\"\u001a\u00020\u000bH\u0002J\b\u0010#\u001a\u00020\u000bH\u0002J\b\u0010$\u001a\u00020\u000bH\u0002J\b\u0010%\u001a\u00020\u000bH\u0002J\b\u0010&\u001a\u00020\u000bH\u0002J\u001c\u0010'\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u001c\u0010(\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020\u000bH\u0002R\u0014\u0010/\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R*\u00105\u001a\u0016\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000202\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R0\u0010;\u001a\u001c\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000208\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010JR\u0016\u0010U\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010QR\u0016\u0010W\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010QR\u0016\u0010Y\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010XR\u0016\u0010[\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010XR\u0016\u0010^\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010`\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010]R\u0016\u0010b\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010]R\u0016\u0010d\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010]R\u0016\u0010f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010]R\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010m\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010o\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010lR\u0016\u0010q\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010lR\u0016\u0010s\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010lR\u0016\u0010u\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010QR\u0014\u0010x\u001a\u00020v8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bw\u0010ZR\u0014\u0010z\u001a\u00020v8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\by\u0010ZR\u0016\u0010|\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010XR\u0016\u0010}\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010XR\u0014\u0010\u007f\u001a\u00020S8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b~\u0010Q\u00a8\u0006\u0084\u0001"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/k;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/n;", "", "isPartEnable", "", "getBizId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "onPartDestroy", "Landroid/view/View;", "startTextView", "startImageView", "o0", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/p;", "endTextViewInfo", "endPicViewInfo", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/b;", "extraPicInfo", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/c;", "extraTextInfo", "U1", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/m;", "picInfo", "M5", "W9", "content", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "J9", "I9", "X9", "V9", "S9", "U9", "R9", "Q9", "Landroid/animation/AnimatorSet;", "N9", "K9", "Y9", "d", "Ljava/lang/String;", "bizId", "Lkotlin/Function2;", "Landroid/content/Context;", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/o;", "e", "Lkotlin/jvm/functions/Function2;", "textDisplayFunc", "Lkotlin/Function3;", "", "Landroid/graphics/Point;", "f", "Lkotlin/jvm/functions/Function3;", "getPicSizeFunc", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/FeedDisplayType;", tl.h.F, "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/FeedDisplayType;", "feedDisplayType", "Landroid/widget/FrameLayout;", "i", "Landroid/widget/FrameLayout;", "rootLayout", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "textView", "Lcom/tencent/mobileqq/matchfriend/widget/RoundCornerImageView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/matchfriend/widget/RoundCornerImageView;", "picView", "D", "Landroid/view/View;", "animShadeView", "E", "textShadeView", UserInfo.SEX_FEMALE, "picShadeView", "", "G", "textStartFontSize", "H", "textEndFontSize", "I", "picShadeBgTokenId", "J", "textShadeBgTokenId", "K", "Z", "hasSetTextStartInfo", "L", "hasSetTextEndInfo", "M", "hasSetPicStartInfo", "N", "hasSetPicEndInfo", "P", "isAnimShowing", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/a;", "animBorderPadding", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/p;", "textViewStartInfo", ExifInterface.LATITUDE_SOUTH, "textViewEndInfo", "T", "picViewStartInfo", "U", "picViewEndInfo", "V", "textPicMargin", "", "W", "animDuration", "X", "protectionTimeInterval", "Y", "startBorderRadius", "endBorderRadius", "a0", "accelerateFactor", "<init>", "(Ljava/lang/String;)V", "b0", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class k extends Part implements n {

    /* renamed from: C, reason: from kotlin metadata */
    private RoundCornerImageView picView;

    /* renamed from: D, reason: from kotlin metadata */
    private View animShadeView;

    /* renamed from: E, reason: from kotlin metadata */
    private View textShadeView;

    /* renamed from: F, reason: from kotlin metadata */
    private RoundCornerImageView picShadeView;

    /* renamed from: G, reason: from kotlin metadata */
    private float textStartFontSize;

    /* renamed from: H, reason: from kotlin metadata */
    private float textEndFontSize;

    /* renamed from: I, reason: from kotlin metadata */
    private int picShadeBgTokenId;

    /* renamed from: J, reason: from kotlin metadata */
    private int textShadeBgTokenId;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean hasSetTextStartInfo;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean hasSetTextEndInfo;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean hasSetPicStartInfo;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean hasSetPicEndInfo;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isAnimShowing;

    /* renamed from: Q, reason: from kotlin metadata */
    private AnimBorderPadding animBorderPadding;

    /* renamed from: R, reason: from kotlin metadata */
    private ViewInfo textViewStartInfo;

    /* renamed from: S, reason: from kotlin metadata */
    private ViewInfo textViewEndInfo;

    /* renamed from: T, reason: from kotlin metadata */
    private ViewInfo picViewStartInfo;

    /* renamed from: U, reason: from kotlin metadata */
    private ViewInfo picViewEndInfo;

    /* renamed from: V, reason: from kotlin metadata */
    private float textPicMargin;

    /* renamed from: W, reason: from kotlin metadata */
    private final long animDuration;

    /* renamed from: X, reason: from kotlin metadata */
    private final long protectionTimeInterval;

    /* renamed from: Y, reason: from kotlin metadata */
    private int startBorderRadius;

    /* renamed from: Z, reason: from kotlin metadata */
    private int endBorderRadius;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final float accelerateFactor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String bizId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Function2<? super Context, ? super String, TextInfo> textDisplayFunc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function3<? super Context, ? super Integer, ? super Integer, ? extends Point> getPicSizeFunc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FeedDisplayType feedDisplayType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FrameLayout rootLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView textView;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f245276a;

        static {
            int[] iArr = new int[FeedDisplayType.values().length];
            try {
                iArr[FeedDisplayType.TEXT_TOP_PIC_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FeedDisplayType.TEXT_BOTTOM_PIC_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FeedDisplayType.TEXT_LEFT_PIC_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FeedDisplayType.TEXT_RIGHT_PIC_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f245276a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/publish/anim/k$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c extends AnimatorListenerAdapter {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(k this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.W9();
            this$0.V9();
            this$0.isAnimShowing = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationEnd(animation);
            if (QLog.isColorLevel()) {
                QLog.i("FeedPublishAnimationPart", 2, "Feed publish animation end.");
            }
            final k kVar = k.this;
            kVar.runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.anim.l
                @Override // java.lang.Runnable
                public final void run() {
                    k.c.b(k.this);
                }
            }, k.this.protectionTimeInterval);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            super.onAnimationStart(animation);
            k.this.isAnimShowing = true;
            if (QLog.isColorLevel()) {
                QLog.i("FeedPublishAnimationPart", 2, "Start to play feed publish animation.");
            }
        }
    }

    public k(String bizId) {
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        this.bizId = bizId;
        this.feedDisplayType = FeedDisplayType.TEXT_TOP_PIC_BOTTOM;
        this.textStartFontSize = 16.0f;
        this.textEndFontSize = 16.0f;
        this.picShadeBgTokenId = R.drawable.qui_common_fill_light_secondary_bg;
        this.textShadeBgTokenId = R.drawable.qui_common_fill_light_secondary_bg;
        this.animBorderPadding = new AnimBorderPadding(0, 0, 0, 0, 15, null);
        this.textViewStartInfo = new ViewInfo(0.0f, 0.0f, 0, 0, 15, null);
        this.textViewEndInfo = new ViewInfo(0.0f, 0.0f, 0, 0, 15, null);
        this.picViewStartInfo = new ViewInfo(0.0f, 0.0f, 0, 0, 15, null);
        this.picViewEndInfo = new ViewInfo(0.0f, 0.0f, 0, 0, 15, null);
        this.animDuration = 400L;
        this.protectionTimeInterval = 300L;
        this.accelerateFactor = 4.0f;
    }

    private final void I9() {
        View decorView = getActivity().getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        U9();
        S9();
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup != null) {
            viewGroup.addView(this.rootLayout);
            FrameLayout frameLayout = this.rootLayout;
            if (frameLayout != null) {
                frameLayout.addView(this.textShadeView);
            }
            FrameLayout frameLayout2 = this.rootLayout;
            if (frameLayout2 != null) {
                frameLayout2.addView(this.picShadeView);
            }
            FrameLayout frameLayout3 = this.rootLayout;
            if (frameLayout3 != null) {
                frameLayout3.addView(this.animShadeView);
            }
            FrameLayout frameLayout4 = this.rootLayout;
            if (frameLayout4 != null) {
                frameLayout4.addView(this.picView);
            }
            FrameLayout frameLayout5 = this.rootLayout;
            if (frameLayout5 != null) {
                frameLayout5.addView(this.textView);
            }
            viewGroup.bringToFront();
            FrameLayout frameLayout6 = this.rootLayout;
            if (frameLayout6 != null) {
                frameLayout6.bringChildToFront(this.textShadeView);
            }
            FrameLayout frameLayout7 = this.rootLayout;
            if (frameLayout7 != null) {
                frameLayout7.bringChildToFront(this.picShadeView);
            }
            FrameLayout frameLayout8 = this.rootLayout;
            if (frameLayout8 != null) {
                frameLayout8.bringChildToFront(this.animShadeView);
            }
            FrameLayout frameLayout9 = this.rootLayout;
            if (frameLayout9 != null) {
                frameLayout9.bringChildToFront(this.picView);
            }
            FrameLayout frameLayout10 = this.rootLayout;
            if (frameLayout10 != null) {
                frameLayout10.bringChildToFront(this.textView);
            }
        }
    }

    private final void J9(String content, Bitmap bitmap) {
        int i3 = b.f245276a[this.feedDisplayType.ordinal()];
        if (i3 == 1) {
            this.picViewEndInfo.h(this.textViewEndInfo.getY() + (content != null ? this.textViewEndInfo.getHeight() + this.textPicMargin : 0.0f));
            return;
        }
        if (i3 == 2) {
            this.textViewEndInfo.h(this.picViewEndInfo.getY() + (bitmap != null ? this.picViewEndInfo.getHeight() + this.textPicMargin : 0.0f));
        } else if (i3 == 3) {
            this.picViewEndInfo.g(this.textViewEndInfo.getX() + (content != null ? this.textViewEndInfo.getWidth() + this.textPicMargin : 0.0f));
        } else {
            if (i3 != 4) {
                return;
            }
            this.textViewEndInfo.g(this.picViewEndInfo.getX() + (bitmap != null ? this.picViewEndInfo.getWidth() + this.textPicMargin : 0.0f));
        }
    }

    private final AnimatorSet K9() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.picView, (Property<RoundCornerImageView, Float>) View.X, this.picViewStartInfo.getX(), this.picViewEndInfo.getX());
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(picView, View.X,\u2026Info.x, picViewEndInfo.x)");
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.picView, (Property<RoundCornerImageView, Float>) View.Y, this.picViewStartInfo.getY(), this.picViewEndInfo.getY());
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(picView, View.Y,\u2026Info.y, picViewEndInfo.y)");
        ValueAnimator ofInt = ValueAnimator.ofInt(this.picViewStartInfo.getWidth(), this.picViewEndInfo.getWidth());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.anim.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                k.L9(k.this, valueAnimator);
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(this.picViewStartInfo.getHeight(), this.picViewEndInfo.getHeight());
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.anim.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                k.M9(k.this, valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofInt, ofInt2);
        animatorSet.setDuration(this.animDuration);
        he0.b.l(animatorSet, R.anim.f154978ul);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(k this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        RoundCornerImageView roundCornerImageView = this$0.picView;
        ViewGroup.LayoutParams layoutParams = roundCornerImageView != null ? roundCornerImageView.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.width = intValue;
        }
        RoundCornerImageView roundCornerImageView2 = this$0.picView;
        if (roundCornerImageView2 == null) {
            return;
        }
        roundCornerImageView2.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(k this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        RoundCornerImageView roundCornerImageView = this$0.picView;
        ViewGroup.LayoutParams layoutParams = roundCornerImageView != null ? roundCornerImageView.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = intValue;
        }
        RoundCornerImageView roundCornerImageView2 = this$0.picView;
        if (roundCornerImageView2 == null) {
            return;
        }
        roundCornerImageView2.setLayoutParams(layoutParams);
    }

    private final AnimatorSet N9() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.textView, (Property<TextView, Float>) View.X, this.textViewStartInfo.getX(), this.textViewEndInfo.getX());
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(textView, View.X\u2026nfo.x, textViewEndInfo.x)");
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.textView, (Property<TextView, Float>) View.Y, this.textViewStartInfo.getY(), this.textViewEndInfo.getY());
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(textView, View.Y\u2026nfo.y, textViewEndInfo.y)");
        ValueAnimator ofInt = ValueAnimator.ofInt(this.textViewStartInfo.getWidth(), this.textViewEndInfo.getWidth());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.anim.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                k.O9(k.this, valueAnimator);
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(this.textViewStartInfo.getHeight(), this.textViewEndInfo.getHeight());
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.anim.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                k.P9(k.this, valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofInt, ofInt2);
        animatorSet.setDuration(this.animDuration);
        he0.b.l(animatorSet, R.anim.f154978ul);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(k this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        TextView textView = this$0.textView;
        ViewGroup.LayoutParams layoutParams = textView != null ? textView.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.width = intValue;
        }
        TextView textView2 = this$0.textView;
        if (textView2 == null) {
            return;
        }
        textView2.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(k this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        TextView textView = this$0.textView;
        ViewGroup.LayoutParams layoutParams = textView != null ? textView.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = intValue;
        }
        TextView textView2 = this$0.textView;
        if (textView2 == null) {
            return;
        }
        textView2.setLayoutParams(layoutParams);
    }

    private final void S9() {
        FrameLayout frameLayout = this.rootLayout;
        if (frameLayout != null) {
            frameLayout.setPadding(this.animBorderPadding.getLeft(), this.animBorderPadding.getTop(), this.animBorderPadding.getRight(), this.animBorderPadding.getBottom());
        }
        View view = new View(getContext());
        this.animShadeView = view;
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        view.setBackground(ContextCompat.getDrawable(view.getContext(), R.drawable.qui_common_fill_light_secondary_bg));
        view.setVisibility(0);
        View view2 = this.animShadeView;
        if (view2 != null) {
            view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.anim.e
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view3, MotionEvent motionEvent) {
                    boolean T9;
                    T9 = k.T9(view3, motionEvent);
                    return T9;
                }
            });
        }
        View view3 = new View(getContext());
        this.textShadeView = view3;
        view3.setBackground(ContextCompat.getDrawable(view3.getContext(), this.textShadeBgTokenId));
        view3.setVisibility(4);
        RoundCornerImageView roundCornerImageView = new RoundCornerImageView(getContext());
        this.picShadeView = roundCornerImageView;
        roundCornerImageView.setBackground(ContextCompat.getDrawable(roundCornerImageView.getContext(), this.picShadeBgTokenId));
        roundCornerImageView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean T9(View view, MotionEvent motionEvent) {
        return true;
    }

    private final void U9() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.rootLayout = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        TextView textView = new TextView(getContext());
        this.textView = textView;
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setVisibility(4);
        textView.setBreakStrategy(0);
        textView.setTextSize(0, ViewUtils.spToPx(this.textEndFontSize));
        textView.setTextColor(ContextCompat.getColorStateList(textView.getContext(), R.color.qui_common_text_primary));
        RoundCornerImageView roundCornerImageView = new RoundCornerImageView(getContext());
        this.picView = roundCornerImageView;
        roundCornerImageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        roundCornerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        roundCornerImageView.setVisibility(4);
        X9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9() {
        FrameLayout frameLayout = this.rootLayout;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        View decorView = getActivity().getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.rootLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9() {
        TextView textView = this.textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        RoundCornerImageView roundCornerImageView = this.picView;
        if (roundCornerImageView != null) {
            roundCornerImageView.setVisibility(8);
        }
        View view = this.animShadeView;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.textShadeView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        RoundCornerImageView roundCornerImageView2 = this.picShadeView;
        if (roundCornerImageView2 == null) {
            return;
        }
        roundCornerImageView2.setVisibility(8);
    }

    private final void X9() {
        View view = this.animShadeView;
        if (view != null) {
            view.setLayerType(2, null);
        }
        RoundCornerImageView roundCornerImageView = this.picView;
        if (roundCornerImageView != null) {
            roundCornerImageView.setLayerType(2, null);
        }
        TextView textView = this.textView;
        if (textView != null) {
            textView.setLayerType(2, null);
        }
    }

    private final void Y9() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.animShadeView, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(animShadeView, View.ALPHA, 1f, 0f)");
        ofFloat.setInterpolator(new AccelerateInterpolator(this.accelerateFactor));
        AnimatorSet N9 = N9();
        AnimatorSet K9 = K9();
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, N9, K9);
        animatorSet.setDuration(this.animDuration);
        animatorSet.addListener(new c());
        runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.anim.f
            @Override // java.lang.Runnable
            public final void run() {
                k.Z9(animatorSet);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(AnimatorSet wholeStepAnimSet) {
        Intrinsics.checkNotNullParameter(wholeStepAnimSet, "$wholeStepAnimSet");
        wholeStepAnimSet.start();
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.publish.anim.n
    public void U1(ViewInfo endTextViewInfo, ViewInfo endPicViewInfo, ExtraPicInfo extraPicInfo, ExtraTextInfo extraTextInfo) {
        float f16;
        float f17;
        int i3;
        int i16;
        int i17;
        float f18;
        int i18;
        Intrinsics.checkNotNullParameter(extraPicInfo, "extraPicInfo");
        Intrinsics.checkNotNullParameter(extraTextInfo, "extraTextInfo");
        if (this.isAnimShowing) {
            return;
        }
        boolean z16 = this.hasSetPicEndInfo;
        if (z16 && this.hasSetTextEndInfo) {
            return;
        }
        if (endPicViewInfo != null && !z16) {
            this.picViewEndInfo = endPicViewInfo;
            this.hasSetPicEndInfo = true;
        }
        if (endTextViewInfo != null && !this.hasSetTextEndInfo) {
            this.textViewEndInfo = endTextViewInfo;
            this.hasSetTextEndInfo = true;
        }
        Float textStartFontSize = extraTextInfo.getTextStartFontSize();
        if (textStartFontSize != null) {
            f16 = textStartFontSize.floatValue();
        } else {
            f16 = this.textStartFontSize;
        }
        this.textStartFontSize = f16;
        Float textEndFontSize = extraTextInfo.getTextEndFontSize();
        if (textEndFontSize != null) {
            f17 = textEndFontSize.floatValue();
        } else {
            f17 = this.textEndFontSize;
        }
        this.textEndFontSize = f17;
        Function2<Context, String, TextInfo> a16 = extraTextInfo.a();
        if (a16 != null) {
            this.textDisplayFunc = a16;
        }
        Integer textShadeBgTokenId = extraTextInfo.getTextShadeBgTokenId();
        if (textShadeBgTokenId != null) {
            i3 = textShadeBgTokenId.intValue();
        } else {
            i3 = this.textShadeBgTokenId;
        }
        this.textShadeBgTokenId = i3;
        Integer startBorderRadius = extraPicInfo.getStartBorderRadius();
        if (startBorderRadius != null) {
            i16 = startBorderRadius.intValue();
        } else {
            i16 = this.startBorderRadius;
        }
        this.startBorderRadius = i16;
        Integer endBorderRadius = extraPicInfo.getEndBorderRadius();
        if (endBorderRadius != null) {
            i17 = endBorderRadius.intValue();
        } else {
            i17 = this.endBorderRadius;
        }
        this.endBorderRadius = i17;
        Float textPicMargin = extraPicInfo.getTextPicMargin();
        if (textPicMargin != null) {
            f18 = textPicMargin.floatValue();
        } else {
            f18 = this.textPicMargin;
        }
        this.textPicMargin = f18;
        FeedDisplayType feedDisplayType = extraPicInfo.getFeedDisplayType();
        if (feedDisplayType == null) {
            feedDisplayType = this.feedDisplayType;
        }
        this.feedDisplayType = feedDisplayType;
        Function3<Context, Integer, Integer, Point> d16 = extraPicInfo.d();
        if (d16 != null) {
            this.getPicSizeFunc = d16;
        }
        AnimBorderPadding animBorderPadding = extraPicInfo.getAnimBorderPadding();
        if (animBorderPadding == null) {
            animBorderPadding = this.animBorderPadding;
        }
        this.animBorderPadding = animBorderPadding;
        Integer picShadeBgTokenId = extraPicInfo.getPicShadeBgTokenId();
        if (picShadeBgTokenId != null) {
            i18 = picShadeBgTokenId.intValue();
        } else {
            i18 = this.picShadeBgTokenId;
        }
        this.picShadeBgTokenId = i18;
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.publish.anim.n
    public String getBizId() {
        return this.bizId;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102969", false);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        d.f245261a.b(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        d.f245261a.d(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Q9(String content, PicInfo picInfo) {
        Bitmap bitmap;
        Function3<? super Context, ? super Integer, ? super Integer, ? extends Point> function3;
        int height;
        int width;
        RoundCornerImageView roundCornerImageView;
        RoundCornerImageView roundCornerImageView2;
        Integer imageHeight;
        Integer imageWidth;
        RoundCornerImageView roundCornerImageView3;
        TextInfo textInfo;
        int height2;
        int width2;
        CharSequence charSequence;
        Point point = null;
        if (picInfo != null) {
            View startImageView = picInfo.getStartImageView();
            Intrinsics.checkNotNull(startImageView, "null cannot be cast to non-null type android.widget.ImageView");
            Drawable drawable = ((ImageView) startImageView).getDrawable();
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (content != null) {
                    Function2<? super Context, ? super String, TextInfo> function2 = this.textDisplayFunc;
                    if (function2 != null) {
                        Context context = getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        textInfo = function2.invoke(context, content);
                    } else {
                        textInfo = null;
                    }
                    TextView textView = this.textView;
                    if (textView != null) {
                        if (textInfo == null || (charSequence = textInfo.getTextContent()) == null) {
                            charSequence = content;
                        }
                        textView.setText(charSequence);
                    }
                    ViewInfo viewInfo = this.textViewEndInfo;
                    if (textInfo != null) {
                        height2 = textInfo.getTextHeight();
                    } else {
                        height2 = viewInfo.getHeight();
                    }
                    viewInfo.e(height2);
                    ViewInfo viewInfo2 = this.textViewEndInfo;
                    if (textInfo != null) {
                        width2 = textInfo.getTextWidth();
                    } else {
                        width2 = viewInfo2.getWidth();
                    }
                    viewInfo2.f(width2);
                    if (bitmap != null) {
                        this.textViewStartInfo.h((this.picViewStartInfo.getY() - this.textPicMargin) - this.textViewEndInfo.getHeight());
                    }
                    TextView textView2 = this.textView;
                    if (textView2 != null) {
                        textView2.setX(this.textViewStartInfo.getX());
                        textView2.setY(this.textViewStartInfo.getY());
                        ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
                        layoutParams.height = this.textViewStartInfo.getHeight();
                        layoutParams.width = this.textViewStartInfo.getWidth();
                        textView2.setLayoutParams(layoutParams);
                        textView2.setVisibility(0);
                    }
                }
                if (bitmap != null && (roundCornerImageView3 = this.picView) != null) {
                    roundCornerImageView3.setImageBitmap(bitmap);
                }
                function3 = this.getPicSizeFunc;
                if (function3 != null) {
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    point = function3.invoke(context2, Integer.valueOf((picInfo == null || (imageWidth = picInfo.getImageWidth()) == null) ? 0 : imageWidth.intValue()), Integer.valueOf((picInfo == null || (imageHeight = picInfo.getImageHeight()) == null) ? 0 : imageHeight.intValue()));
                }
                ViewInfo viewInfo3 = this.picViewEndInfo;
                if (point == null) {
                    height = point.y;
                } else {
                    height = viewInfo3.getHeight();
                }
                viewInfo3.e(height);
                ViewInfo viewInfo4 = this.picViewEndInfo;
                if (point == null) {
                    width = point.x;
                } else {
                    width = viewInfo4.getWidth();
                }
                viewInfo4.f(width);
                roundCornerImageView = this.picView;
                if (roundCornerImageView != null) {
                    roundCornerImageView.setX(this.picViewStartInfo.getX());
                    roundCornerImageView.setY(this.picViewStartInfo.getY());
                    ViewGroup.LayoutParams layoutParams2 = roundCornerImageView.getLayoutParams();
                    layoutParams2.height = this.picViewStartInfo.getHeight();
                    layoutParams2.width = this.picViewStartInfo.getWidth();
                    roundCornerImageView.setLayoutParams(layoutParams2);
                    roundCornerImageView.setVisibility(0);
                }
                roundCornerImageView2 = this.picView;
                if (roundCornerImageView2 != null) {
                    int i3 = this.endBorderRadius;
                    roundCornerImageView2.setCorner(i3, i3, i3, i3);
                    roundCornerImageView2.setBorder(false);
                    roundCornerImageView2.invalidate();
                }
                J9(content, bitmap);
            }
        }
        bitmap = null;
        if (content != null) {
        }
        if (bitmap != null) {
            roundCornerImageView3.setImageBitmap(bitmap);
        }
        function3 = this.getPicSizeFunc;
        if (function3 != null) {
        }
        ViewInfo viewInfo32 = this.picViewEndInfo;
        if (point == null) {
        }
        viewInfo32.e(height);
        ViewInfo viewInfo42 = this.picViewEndInfo;
        if (point == null) {
        }
        viewInfo42.f(width);
        roundCornerImageView = this.picView;
        if (roundCornerImageView != null) {
        }
        roundCornerImageView2 = this.picView;
        if (roundCornerImageView2 != null) {
        }
        J9(content, bitmap);
    }

    private final void R9(String content, PicInfo picInfo) {
        RoundCornerImageView roundCornerImageView;
        View view;
        if (content != null && (view = this.textShadeView) != null) {
            view.setX(this.textViewEndInfo.getX());
            view.setY(this.textViewEndInfo.getY());
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.textViewEndInfo.getHeight();
            layoutParams.width = this.textViewEndInfo.getWidth();
            view.setLayoutParams(layoutParams);
            view.setVisibility(0);
        }
        Bitmap bitmap = null;
        if (picInfo != null) {
            View startImageView = picInfo.getStartImageView();
            Intrinsics.checkNotNull(startImageView, "null cannot be cast to non-null type android.widget.ImageView");
            Drawable drawable = ((ImageView) startImageView).getDrawable();
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            }
        }
        if (bitmap == null || (roundCornerImageView = this.picShadeView) == null) {
            return;
        }
        roundCornerImageView.setX(this.picViewEndInfo.getX());
        roundCornerImageView.setY(this.picViewEndInfo.getY());
        ViewGroup.LayoutParams layoutParams2 = roundCornerImageView.getLayoutParams();
        layoutParams2.height = this.picViewEndInfo.getHeight();
        layoutParams2.width = this.picViewEndInfo.getWidth();
        roundCornerImageView.setLayoutParams(layoutParams2);
        int i3 = this.endBorderRadius;
        roundCornerImageView.setCorner(i3, i3, i3, i3);
        roundCornerImageView.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.publish.anim.n
    public void M5(View startTextView, PicInfo picInfo) {
        String obj = startTextView != null ? ((TextView) startTextView).getText().toString() : null;
        if (obj == null || obj.length() == 0) {
            obj = null;
        }
        I9();
        Context context = startTextView != null ? startTextView.getContext() : null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            activity.finish();
            activity.overridePendingTransition(0, 0);
        }
        Q9(obj, picInfo);
        R9(obj, picInfo);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("content " + ((Object) obj));
            sb5.append(", ");
            sb5.append("margin " + this.textPicMargin);
            sb5.append(", ");
            sb5.append("textStartInfo " + this.textViewStartInfo);
            sb5.append(", ");
            sb5.append("textEndInfo " + this.textViewEndInfo);
            sb5.append(", ");
            sb5.append("picStartInfo " + this.picViewStartInfo);
            sb5.append(", ");
            sb5.append("picEndInfo " + this.picViewEndInfo);
            QLog.d("FeedPublishAnimationPart", 2, "[startAnimation]" + ((Object) sb5));
        }
        Y9();
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.publish.anim.n
    public void o0(View startTextView, View startImageView) {
        if (startImageView != null && !this.hasSetPicStartInfo) {
            startImageView.getLocationOnScreen(new int[2]);
            this.picViewStartInfo.g(r3[0] + startImageView.getPaddingLeft());
            this.picViewStartInfo.h(r3[1] + startImageView.getPaddingTop());
            this.picViewStartInfo.f(startImageView.getWidth());
            this.picViewStartInfo.e(startImageView.getHeight());
            this.hasSetPicStartInfo = true;
        }
        if (startTextView == null || this.hasSetTextStartInfo) {
            return;
        }
        startTextView.getLocationOnScreen(new int[2]);
        this.textViewStartInfo.g(r9[0] + startTextView.getPaddingLeft());
        this.textViewStartInfo.h(r9[1] + startTextView.getPaddingTop());
        this.textViewStartInfo.f(startTextView.getWidth());
        this.textViewStartInfo.e(startTextView.getHeight());
        this.hasSetTextStartInfo = true;
    }
}

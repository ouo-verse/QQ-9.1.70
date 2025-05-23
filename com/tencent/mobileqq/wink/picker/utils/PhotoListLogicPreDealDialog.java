package com.tencent.mobileqq.wink.picker.utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002*aB\u0017\u0012\u0006\u0010.\u001a\u00020)\u0012\u0006\u00103\u001a\u00020\u0002\u00a2\u0006\u0004\b^\u0010_B\u0011\b\u0016\u0012\u0006\u0010.\u001a\u00020)\u00a2\u0006\u0004\b^\u0010`J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002JR\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\tH\u0007J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\tJ\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\u0016\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\tJ\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\tJ\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\tJ\u000e\u0010#\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\tJ\u000e\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001dJ\u000e\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001dJ\u000e\u0010&\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001dJ\u0006\u0010(\u001a\u00020\u0004R\u0017\u0010.\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u00103\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00100R\u0016\u00107\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010\"R\u0016\u00109\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010\"R\u0016\u0010;\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010\"R\u0016\u0010=\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010\"R\u0016\u0010?\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010\"R\u0016\u0010A\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010\"R\u0016\u0010C\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010\"R$\u0010H\u001a\u0012\u0012\u0004\u0012\u00020\u001d0Dj\b\u0012\u0004\u0012\u00020\u001d`E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010L\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010JR\u0016\u0010M\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010JR\u0016\u0010O\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010JR\u0016\u0010P\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\"R\u0016\u0010R\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010\"R\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010\\\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010[R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010]\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/utils/PhotoListLogicPreDealDialog;", "", "", "progress", "", "J", DomainData.DOMAIN_NAME, "O", "compressMediaNum", "", "needSmartCut", "needExtract", "needFetchMusic", "needFetchMusicStuckPoint", "needFetchVideoTemplate", "isAutoTemplate", "isSyncPublish", "needTemplateLibPreprocess", "p", "Landroid/view/View$OnClickListener;", "listener", "v", "Lcom/tencent/mobileqq/wink/picker/utils/PhotoListLogicPreDealDialog$a;", "backListener", "u", "t", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "itemIndex", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "isDone", "B", "D", UserInfo.SEX_FEMALE, "H", BdhLogUtil.LogTag.Tag_Req, "P", "L", "K", HippyTKDListViewAdapter.X, "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "b", "I", "getRes", "()I", "res", "c", "compressNum", "d", "compressPart", "e", "extractPart", "f", "fetchMusicPart", "g", "fetchMusicStuckPart", tl.h.F, "fetchVideoTemplatePart", "i", "downloadTemplatePart", "j", "templateLibPreprocessPart", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "k", "Ljava/util/ArrayList;", "compressProgressList", "l", "Z", "extractDone", "fetchMusicDone", "fetchMusicStuckDone", "o", "fetchVideoTemplateDone", "downloadTemplateProgress", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "templateLibPreprocessProcess", "Landroid/animation/ValueAnimator;", "r", "Landroid/animation/ValueAnimator;", "animator", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "dialog", "Landroid/view/View$OnClickListener;", "cancelListener", "Lcom/tencent/mobileqq/wink/picker/utils/PhotoListLogicPreDealDialog$a;", "<init>", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "PreDealStep", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PhotoListLogicPreDealDialog {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int res;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int compressNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float compressPart;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float extractPart;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float fetchMusicPart;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float fetchMusicStuckPart;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float fetchVideoTemplatePart;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float downloadTemplatePart;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float templateLibPreprocessPart;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Float> compressProgressList;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean extractDone;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean fetchMusicDone;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean fetchMusicStuckDone;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean fetchVideoTemplateDone;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private float downloadTemplateProgress;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private float templateLibPreprocessProcess;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator animator;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleCommonLoadingDialog dialog;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener cancelListener;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a backListener;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/utils/PhotoListLogicPreDealDialog$PreDealStep;", "", "(Ljava/lang/String;I)V", "STEP_EXTRACT", "STEP_FETCH_MUSIC", "STEP_FETCH_MUSIC_STUCK", "STEP_FETCH_TEMPLATE", "STEP_FETCH_RECOMMEND_TEMPLATES", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum PreDealStep {
        STEP_EXTRACT,
        STEP_FETCH_MUSIC,
        STEP_FETCH_MUSIC_STUCK,
        STEP_FETCH_TEMPLATE,
        STEP_FETCH_RECOMMEND_TEMPLATES
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/utils/PhotoListLogicPreDealDialog$a;", "", "", "onBackPressed", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void onBackPressed();
    }

    public PhotoListLogicPreDealDialog(@NotNull Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.res = i3;
        this.extractPart = 0.1f;
        this.fetchMusicPart = 0.1f;
        this.fetchMusicStuckPart = 0.1f;
        this.fetchVideoTemplatePart = 0.1f;
        this.downloadTemplatePart = 0.1f;
        this.templateLibPreprocessPart = 0.1f;
        this.compressProgressList = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(int i3, PhotoListLogicPreDealDialog this$0, float f16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 >= this$0.compressProgressList.size()) {
            return;
        }
        this$0.compressProgressList.set(i3, Float.valueOf(f16));
        this$0.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(PhotoListLogicPreDealDialog this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.extractDone = z16;
        this$0.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(PhotoListLogicPreDealDialog this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.fetchMusicDone = z16;
        this$0.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(PhotoListLogicPreDealDialog this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.fetchMusicStuckDone = z16;
        this$0.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(PhotoListLogicPreDealDialog this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.fetchVideoTemplateDone = z16;
        this$0.O();
    }

    private final void J(int progress) {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.dialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.setProgress(progress);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(final PhotoListLogicPreDealDialog this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ValueAnimator valueAnimator = this$0.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(this$0.n(), i3);
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.wink.picker.utils.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                PhotoListLogicPreDealDialog.N(PhotoListLogicPreDealDialog.this, valueAnimator2);
            }
        });
        this$0.animator = ofInt;
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(PhotoListLogicPreDealDialog this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.J(((Integer) animatedValue).intValue());
    }

    private final void O() {
        float f16;
        int coerceIn;
        float coerceAtMost;
        Iterator<T> it = this.compressProgressList.iterator();
        float f17 = 0.0f;
        while (it.hasNext()) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(((Number) it.next()).floatValue(), 1.0f);
            f17 += coerceAtMost;
        }
        int i3 = this.compressNum;
        if (i3 == 0) {
            f16 = this.compressPart;
        } else {
            f16 = (this.compressPart * f17) / i3;
        }
        float f18 = f16 + 0.0f + (this.downloadTemplatePart * this.downloadTemplateProgress) + (this.templateLibPreprocessPart * this.templateLibPreprocessProcess);
        if (this.extractDone) {
            f18 += this.extractPart;
        }
        if (this.fetchMusicDone) {
            f18 += this.fetchMusicPart;
        }
        if (this.fetchMusicStuckDone) {
            f18 += this.fetchMusicStuckPart;
        }
        if (this.fetchVideoTemplateDone) {
            f18 += this.fetchVideoTemplatePart;
        }
        int n3 = n();
        coerceIn = RangesKt___RangesKt.coerceIn((int) (f18 * 100), 0, 100);
        if (n3 >= coerceIn) {
            return;
        }
        L(coerceIn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(PhotoListLogicPreDealDialog this$0, float f16) {
        float coerceIn;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        coerceIn = RangesKt___RangesKt.coerceIn(f16, 0.0f, 1.0f);
        this$0.templateLibPreprocessProcess = coerceIn;
        this$0.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(PhotoListLogicPreDealDialog this$0, float f16) {
        float coerceIn;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        coerceIn = RangesKt___RangesKt.coerceIn(f16, 0.0f, 1.0f);
        this$0.downloadTemplateProgress = coerceIn;
        this$0.O();
    }

    private final int n() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.dialog;
        if (qCircleCommonLoadingDialog != null) {
            return qCircleCommonLoadingDialog.k0();
        }
        return 0;
    }

    public static /* synthetic */ void q(PhotoListLogicPreDealDialog photoListLogicPreDealDialog, int i3, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28, boolean z29, int i16, Object obj) {
        boolean z36;
        if ((i16 & 256) != 0) {
            z36 = false;
        } else {
            z36 = z29;
        }
        photoListLogicPreDealDialog.p(i3, z16, z17, z18, z19, z26, z27, z28, z36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(PhotoListLogicPreDealDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.cancelListener;
        if (onClickListener != null) {
            onClickListener.onClick(null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean s(PhotoListLogicPreDealDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.backListener;
        if (aVar != null) {
            aVar.onBackPressed();
        }
        return Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(PhotoListLogicPreDealDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J(100);
        this$0.m();
    }

    public final void B(final boolean isDone) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.utils.d
            @Override // java.lang.Runnable
            public final void run() {
                PhotoListLogicPreDealDialog.C(PhotoListLogicPreDealDialog.this, isDone);
            }
        });
    }

    public final void D(final boolean isDone) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.utils.i
            @Override // java.lang.Runnable
            public final void run() {
                PhotoListLogicPreDealDialog.E(PhotoListLogicPreDealDialog.this, isDone);
            }
        });
    }

    public final void F(final boolean isDone) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.utils.g
            @Override // java.lang.Runnable
            public final void run() {
                PhotoListLogicPreDealDialog.G(PhotoListLogicPreDealDialog.this, isDone);
            }
        });
    }

    public final void H(final boolean isDone) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.utils.m
            @Override // java.lang.Runnable
            public final void run() {
                PhotoListLogicPreDealDialog.I(PhotoListLogicPreDealDialog.this, isDone);
            }
        });
    }

    public final void K(float progress) {
        L((int) (progress * 100));
    }

    public final void L(final int progress) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.utils.j
            @Override // java.lang.Runnable
            public final void run() {
                PhotoListLogicPreDealDialog.M(PhotoListLogicPreDealDialog.this, progress);
            }
        });
    }

    public final void P(final float progress) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.utils.h
            @Override // java.lang.Runnable
            public final void run() {
                PhotoListLogicPreDealDialog.Q(PhotoListLogicPreDealDialog.this, progress);
            }
        });
    }

    public final void R(final float progress) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.utils.o
            @Override // java.lang.Runnable
            public final void run() {
                PhotoListLogicPreDealDialog.S(PhotoListLogicPreDealDialog.this, progress);
            }
        });
    }

    public final void m() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.dialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.dismiss();
        }
    }

    @JvmOverloads
    public final void o(int i3, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28) {
        q(this, i3, z16, z17, z18, z19, z26, z27, z28, false, 256, null);
    }

    @JvmOverloads
    public final void p(int compressMediaNum, boolean needSmartCut, boolean needExtract, boolean needFetchMusic, boolean needFetchMusicStuckPoint, boolean needFetchVideoTemplate, boolean isAutoTemplate, boolean isSyncPublish, boolean needTemplateLibPreprocess) {
        int i3;
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        float f27;
        float coerceAtLeast;
        List<String> listOf;
        List<String> listOf2;
        QCircleCommonLoadingDialog.c cVar = new QCircleCommonLoadingDialog.c(this.context, this.res);
        int i16 = 1;
        if (isAutoTemplate) {
            if (needSmartCut) {
                listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{this.context.getResources().getString(R.string.f215235v2), this.context.getResources().getString(R.string.f215245v3), this.context.getResources().getString(R.string.f215255v4), this.context.getResources().getString(R.string.f215265v5)});
                cVar.q(listOf2);
            } else {
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{this.context.getResources().getString(R.string.f215235v2), this.context.getResources().getString(R.string.f215245v3), this.context.getResources().getString(R.string.f215255v4), this.context.getResources().getString(R.string.f215265v5)});
                cVar.q(listOf);
            }
        } else if (needSmartCut) {
            cVar.p(this.context.getResources().getString(R.string.f216125xg));
        } else if (isSyncPublish) {
            cVar.p(this.context.getResources().getString(R.string.f216275xv));
        } else {
            cVar.p(this.context.getResources().getString(R.string.f216115xf));
        }
        this.dialog = cVar.n(false).j("libtemplate").h(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.utils.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoListLogicPreDealDialog.r(PhotoListLogicPreDealDialog.this, view);
            }
        }).d(new Callable() { // from class: com.tencent.mobileqq.wink.picker.utils.l
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean s16;
                s16 = PhotoListLogicPreDealDialog.s(PhotoListLogicPreDealDialog.this);
                return s16;
            }
        }).o(true).m(false).a();
        if (needExtract) {
            i3 = compressMediaNum + 1;
        } else {
            i3 = compressMediaNum;
        }
        if (needFetchMusic) {
            i3++;
        }
        if (needFetchMusicStuckPoint) {
            i3++;
        }
        if (needFetchVideoTemplate) {
            i3 += 2;
        }
        if (needTemplateLibPreprocess) {
            i3++;
        }
        if (i3 != 0) {
            i16 = i3;
        }
        if (needExtract) {
            f16 = 1.0f / i16;
        } else {
            f16 = 0.0f;
        }
        this.extractPart = f16;
        if (needFetchMusic) {
            f17 = 1.0f / i16;
        } else {
            f17 = 0.0f;
        }
        this.fetchMusicPart = f17;
        if (needFetchMusicStuckPoint) {
            f18 = 1.0f / i16;
        } else {
            f18 = 0.0f;
        }
        this.fetchMusicStuckPart = f18;
        if (needFetchVideoTemplate) {
            f19 = 1.0f / i16;
        } else {
            f19 = 0.0f;
        }
        this.fetchVideoTemplatePart = f19;
        if (needFetchVideoTemplate) {
            f26 = 1.0f / i16;
        } else {
            f26 = 0.0f;
        }
        this.downloadTemplatePart = f26;
        if (needTemplateLibPreprocess) {
            f27 = 1.0f / i16;
        } else {
            f27 = 0.0f;
        }
        this.templateLibPreprocessPart = f27;
        this.compressNum = compressMediaNum;
        this.compressProgressList.clear();
        int i17 = this.compressNum;
        for (int i18 = 0; i18 < i17; i18++) {
            this.compressProgressList.add(Float.valueOf(0.0f));
        }
        this.extractDone = false;
        this.fetchMusicDone = false;
        this.fetchMusicStuckDone = false;
        this.fetchVideoTemplateDone = false;
        this.downloadTemplateProgress = 0.0f;
        this.templateLibPreprocessProcess = 0.0f;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((((((1.0f - this.extractPart) - this.fetchMusicPart) - this.fetchMusicStuckPart) - this.fetchVideoTemplatePart) - this.downloadTemplatePart) - this.templateLibPreprocessPart, 0.0f);
        this.compressPart = coerceAtLeast;
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = null;
        J(0);
    }

    public final boolean t() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.dialog;
        if (qCircleCommonLoadingDialog != null) {
            return qCircleCommonLoadingDialog.isShowing();
        }
        return false;
    }

    public final void u(@NotNull a backListener) {
        Intrinsics.checkNotNullParameter(backListener, "backListener");
        this.backListener = backListener;
    }

    public final void v(@NotNull View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.cancelListener = listener;
    }

    public final void w() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog;
        if (!t() && (qCircleCommonLoadingDialog = this.dialog) != null) {
            qCircleCommonLoadingDialog.show();
        }
    }

    public final void x() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.utils.e
            @Override // java.lang.Runnable
            public final void run() {
                PhotoListLogicPreDealDialog.y(PhotoListLogicPreDealDialog.this);
            }
        });
    }

    public final void z(final int itemIndex, final float progress) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.utils.n
            @Override // java.lang.Runnable
            public final void run() {
                PhotoListLogicPreDealDialog.A(itemIndex, this, progress);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PhotoListLogicPreDealDialog(@NotNull Context context) {
        this(context, R.style.a5k);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}

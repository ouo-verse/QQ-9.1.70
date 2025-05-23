package com.tencent.mobileqq.topicaggregation.part;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import b55.g;
import com.google.android.material.appbar.AppBarLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.ktx.i;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 U2\u00020\u0001:\u0001VB\u0007\u00a2\u0006\u0004\bS\u0010TJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u001c\u0010\u0013\u001a\u00020\u00032\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010\u001fR\u0016\u00104\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u0010#R\u0016\u00106\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u0010#R\u0016\u00108\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u0010'R\u0016\u0010:\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010'R\u0016\u0010<\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010'R\u001b\u0010B\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001d\u0010G\u001a\u0004\u0018\u00010C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010?\u001a\u0004\bE\u0010FR#\u0010K\u001a\n H*\u0004\u0018\u00010C0C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u0010?\u001a\u0004\bJ\u0010FR#\u0010P\u001a\n H*\u0004\u0018\u00010L0L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010?\u001a\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010D\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/topicaggregation/part/FlockTopicAggregationHeaderPart;", "Lcom/tencent/mobileqq/flock/base/b;", "Landroid/view/View;", "", "S9", "O9", "T9", "", "collapsed", "V9", "W9", "", "offsetRatio", "N9", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/tencent/mobileqq/flock/feeddetail/bean/a;", "it", "L9", "isError", "K9", "Lb55/g;", "M9", "", "coverUrl", "F9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "titleLayout", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "ivBack", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tvTitle", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", h.F, "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "coordinatorLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "i", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "headerLayout", BdhLogUtil.LogTag.Tag_Conn, "ivCover", "D", "ivTopic", "E", "tvTopic", UserInfo.SEX_FEMALE, "tvFeedCount", "G", "tvParticipantCount", "", "H", "Lkotlin/Lazy;", "I9", "()I", "statusBarHeight", "Landroid/graphics/drawable/Drawable;", "I", "G9", "()Landroid/graphics/drawable/Drawable;", "ivBackDrawableCollapsed", "kotlin.jvm.PlatformType", "J", "H9", "ivBackDrawableExpand", "Lcom/tencent/mobileqq/topicaggregation/viewmodel/a;", "K", "J9", "()Lcom/tencent/mobileqq/topicaggregation/viewmodel/a;", "vm", "L", "mCurVerticalOffset", "<init>", "()V", "M", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class FlockTopicAggregationHeaderPart extends com.tencent.mobileqq.flock.base.b {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int N;

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView ivCover;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView ivTopic;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView tvTopic;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView tvFeedCount;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView tvParticipantCount;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy statusBarHeight;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy ivBackDrawableCollapsed;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy ivBackDrawableExpand;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: L, reason: from kotlin metadata */
    private int mCurVerticalOffset;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout titleLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView ivBack;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private CoordinatorLayout coordinatorLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AppBarLayout appBarLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private FrameLayout headerLayout;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/topicaggregation/part/FlockTopicAggregationHeaderPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.topicaggregation.part.FlockTopicAggregationHeaderPart$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50706);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
            N = i.b(44);
        }
    }

    public FlockTopicAggregationHeaderPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.topicaggregation.part.FlockTopicAggregationHeaderPart$statusBarHeight$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockTopicAggregationHeaderPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Integer invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? Integer.valueOf(ImmersiveUtils.getStatusBarHeight(FlockTopicAggregationHeaderPart.this.getContext())) : (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.statusBarHeight = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.mobileqq.topicaggregation.part.FlockTopicAggregationHeaderPart$ivBackDrawableCollapsed$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockTopicAggregationHeaderPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Drawable invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? ResourcesCompat.getDrawable(FlockTopicAggregationHeaderPart.this.getContext().getResources(), R.drawable.qui_chevron_left, null) : (Drawable) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.ivBackDrawableCollapsed = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.mobileqq.topicaggregation.part.FlockTopicAggregationHeaderPart$ivBackDrawableExpand$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockTopicAggregationHeaderPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Drawable invoke() {
                    Drawable G9;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Drawable) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    com.tencent.mobileqq.flock.picloader.a a16 = com.tencent.mobileqq.flock.picloader.a.a();
                    G9 = FlockTopicAggregationHeaderPart.this.G9();
                    return a16.e(G9, FlockTopicAggregationHeaderPart.this.getContext().getResources().getColor(R.color.qui_common_icon_white));
                }
            });
            this.ivBackDrawableExpand = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.topicaggregation.viewmodel.a>() { // from class: com.tencent.mobileqq.topicaggregation.part.FlockTopicAggregationHeaderPart$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockTopicAggregationHeaderPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.topicaggregation.viewmodel.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.topicaggregation.viewmodel.a) FlockTopicAggregationHeaderPart.this.getViewModel(com.tencent.mobileqq.topicaggregation.viewmodel.a.class) : (com.tencent.mobileqq.topicaggregation.viewmodel.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.vm = lazy4;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void F9(String coverUrl) {
        com.tencent.mobileqq.flock.picloader.a a16 = com.tencent.mobileqq.flock.picloader.a.a();
        Option url = Option.obtain().setUrl(coverUrl);
        ImageView imageView = this.ivCover;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCover");
            imageView = null;
        }
        Option requestWidth = url.setRequestWidth(imageView.getLayoutParams().width);
        ImageView imageView3 = this.ivCover;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCover");
            imageView3 = null;
        }
        Option requestHeight = requestWidth.setRequestHeight(imageView3.getLayoutParams().height);
        ImageView imageView4 = this.ivCover;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCover");
        } else {
            imageView2 = imageView4;
        }
        a16.c(requestHeight.setTargetView(imageView2).setLoadingDrawableId(R.drawable.asd).setFailedDrawableId(R.drawable.asd));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable G9() {
        return (Drawable) this.ivBackDrawableCollapsed.getValue();
    }

    private final Drawable H9() {
        return (Drawable) this.ivBackDrawableExpand.getValue();
    }

    private final int I9() {
        return ((Number) this.statusBarHeight.getValue()).intValue();
    }

    private final com.tencent.mobileqq.topicaggregation.viewmodel.a J9() {
        return (com.tencent.mobileqq.topicaggregation.viewmodel.a) this.vm.getValue();
    }

    private final void K9(boolean isError) {
        int i3;
        CoordinatorLayout coordinatorLayout = this.coordinatorLayout;
        if (coordinatorLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
            coordinatorLayout = null;
        }
        if (isError) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        coordinatorLayout.setVisibility(i3);
        V9(isError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>> it) {
        RFWLog.i("FlockTopicAggregationHeaderPart", RFWLog.USR, "handleFeedListRsp, state:" + it.getState() + ", isLoadMore: " + it.getIsLoadMore());
        if (it.getIsLoadMore()) {
            return;
        }
        int state = it.getState();
        if (state != 0) {
            if (state != 2 && state != 3) {
                if (state != 4) {
                    return;
                }
            } else {
                K9(false);
                return;
            }
        }
        K9(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9(g it) {
        boolean z16;
        String str = it.f27975c;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            String str2 = it.f27975c;
            Intrinsics.checkNotNullExpressionValue(str2, "it.coverUrl");
            F9(str2);
        }
        TextView textView = this.tvTitle;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("#%s", Arrays.copyOf(new Object[]{it.f27974b}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
        TextView textView3 = this.tvTopic;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTopic");
            textView3 = null;
        }
        textView3.setText(it.f27974b);
        TextView textView4 = this.tvFeedCount;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvFeedCount");
            textView4 = null;
        }
        String format2 = String.format("%s\u4e2a\u6d3b\u52a8", Arrays.copyOf(new Object[]{Integer.valueOf(it.f27977e)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        textView4.setText(format2);
        TextView textView5 = this.tvParticipantCount;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvParticipantCount");
        } else {
            textView2 = textView5;
        }
        String format3 = String.format("\u5171%s\u4eba\u53c2\u4e0e", Arrays.copyOf(new Object[]{Integer.valueOf(it.f27976d)}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
        textView2.setText(format3);
    }

    private final void N9(float offsetRatio) {
        boolean z16;
        FrameLayout frameLayout = this.headerLayout;
        TextView textView = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerLayout");
            frameLayout = null;
        }
        frameLayout.setAlpha(1 - offsetRatio);
        if (offsetRatio < 1.0f) {
            TextView textView2 = this.tvTitle;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            W9(false);
            V9(false);
            return;
        }
        if (offsetRatio == 1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            TextView textView3 = this.tvTitle;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            } else {
                textView = textView3;
            }
            textView.setVisibility(0);
            W9(true);
            V9(true);
        }
    }

    private final void O9(View view) {
        View findViewById = view.findViewById(R.id.u9i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.coordinator_layout)");
        this.coordinatorLayout = (CoordinatorLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.sqk);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById2;
        appBarLayout.e(new AppBarLayout.g() { // from class: com.tencent.mobileqq.topicaggregation.part.c
            @Override // com.google.android.material.appbar.AppBarLayout.c
            public final void onOffsetChanged(AppBarLayout appBarLayout2, int i3) {
                FlockTopicAggregationHeaderPart.P9(FlockTopicAggregationHeaderPart.this, appBarLayout2, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<AppBarLayou\u2026\n            })\n        }");
        this.appBarLayout = appBarLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(FlockTopicAggregationHeaderPart this$0, AppBarLayout appBarLayout, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mCurVerticalOffset == i3) {
            return;
        }
        this$0.mCurVerticalOffset = i3;
        int p16 = appBarLayout.p();
        RFWLog.d("FlockTopicAggregationHeaderPart", RFWLog.DEV, "onOffsetChanged, verticalOffset:" + i3 + ", totalScrollRange:" + p16);
        this$0.N9(((float) Math.abs(i3)) / ((float) p16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void S9(View view) {
        View findViewById = view.findViewById(R.id.yei);
        FrameLayout frameLayout = (FrameLayout) findViewById;
        frameLayout.setMinimumHeight(N + I9());
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<FrameLayout\u2026statusBarHeight\n        }");
        this.headerLayout = frameLayout;
        View findViewById2 = view.findViewById(R.id.duw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_cover)");
        this.ivCover = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.y_6);
        ImageView imageView = (ImageView) findViewById3;
        Drawable e16 = com.tencent.mobileqq.flock.picloader.a.a().e(imageView.getDrawable(), imageView.getContext().getResources().getColor(R.color.qui_common_icon_white));
        if (e16 != null) {
            imageView.setImageDrawable(e16);
        }
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<ImageView>(\u2026              }\n        }");
        this.ivTopic = imageView;
        View findViewById4 = view.findViewById(R.id.me6);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_topic)");
        this.tvTopic = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.f107916bp);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.tv_feed_count)");
        this.tvFeedCount = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.e_1);
        findViewById6.setBackgroundColor(findViewById6.getContext().getResources().getColor(R.color.qui_common_border_superlight));
        View findViewById7 = view.findViewById(R.id.f109856gy);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.tv_participant_count)");
        this.tvParticipantCount = (TextView) findViewById7;
    }

    private final void T9(View view) {
        View findViewById = view.findViewById(R.id.yfs);
        FrameLayout initTitleLayout$lambda$8 = (FrameLayout) findViewById;
        Intrinsics.checkNotNullExpressionValue(initTitleLayout$lambda$8, "initTitleLayout$lambda$8");
        ViewGroup.LayoutParams layoutParams = initTitleLayout$lambda$8.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = N + I9();
            initTitleLayout$lambda$8.setPadding(initTitleLayout$lambda$8.getPaddingLeft(), initTitleLayout$lambda$8.getPaddingTop() + I9(), initTitleLayout$lambda$8.getPaddingRight(), initTitleLayout$lambda$8.getPaddingBottom());
            initTitleLayout$lambda$8.setLayoutParams(layoutParams2);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<FrameLayout\u2026)\n            }\n        }");
            this.titleLayout = initTitleLayout$lambda$8;
            View findViewById2 = view.findViewById(R.id.du6);
            ImageView imageView = (ImageView) findViewById2;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.topicaggregation.part.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FlockTopicAggregationHeaderPart.U9(FlockTopicAggregationHeaderPart.this, view2);
                }
            });
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ImageView>(\u2026)\n            }\n        }");
            this.ivBack = imageView;
            View findViewById3 = view.findViewById(R.id.kbs);
            TextView textView = (TextView) findViewById3;
            textView.setVisibility(8);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView>(R\u2026ity = View.GONE\n        }");
            this.tvTitle = textView;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(FlockTopicAggregationHeaderPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getActivity().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void V9(boolean collapsed) {
        ImageView imageView = null;
        if (collapsed) {
            ImageView imageView2 = this.ivBack;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            } else {
                imageView = imageView2;
            }
            imageView.setImageDrawable(G9());
            return;
        }
        Drawable H9 = H9();
        if (H9 != null) {
            ImageView imageView3 = this.ivBack;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            } else {
                imageView = imageView3;
            }
            imageView.setImageDrawable(H9);
        }
    }

    private final void W9(boolean collapsed) {
        FrameLayout frameLayout = null;
        if (collapsed) {
            FrameLayout frameLayout2 = this.titleLayout;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            } else {
                frameLayout = frameLayout2;
            }
            frameLayout.setBackgroundColor(getContext().getResources().getColor(R.color.qui_common_fill_light_secondary));
            return;
        }
        FrameLayout frameLayout3 = this.titleLayout;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
        } else {
            frameLayout = frameLayout3;
        }
        frameLayout.setBackgroundColor(getContext().getResources().getColor(17170445));
    }

    private final void initData() {
        LiveData<g> d26 = J9().d2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<g, Unit> function1 = new Function1<g, Unit>() { // from class: com.tencent.mobileqq.topicaggregation.part.FlockTopicAggregationHeaderPart$initData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockTopicAggregationHeaderPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(g gVar) {
                invoke2(gVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(g it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                FlockTopicAggregationHeaderPart flockTopicAggregationHeaderPart = FlockTopicAggregationHeaderPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                flockTopicAggregationHeaderPart.M9(it);
            }
        };
        d26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.topicaggregation.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockTopicAggregationHeaderPart.Q9(Function1.this, obj);
            }
        });
        LiveData<UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>>> R1 = J9().R1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<? extends com.tencent.mobileqq.flock.feeddetail.bean.a>>, Unit> function12 = new Function1<UIStateData<List<? extends com.tencent.mobileqq.flock.feeddetail.bean.a>>, Unit>() { // from class: com.tencent.mobileqq.topicaggregation.part.FlockTopicAggregationHeaderPart$initData$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockTopicAggregationHeaderPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends com.tencent.mobileqq.flock.feeddetail.bean.a>> uIStateData) {
                invoke2((UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>>) uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>> it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                FlockTopicAggregationHeaderPart flockTopicAggregationHeaderPart = FlockTopicAggregationHeaderPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                flockTopicAggregationHeaderPart.L9(it);
            }
        };
        R1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.topicaggregation.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockTopicAggregationHeaderPart.R9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            T9(rootView);
            O9(rootView);
            S9(rootView);
            initData();
        }
    }
}

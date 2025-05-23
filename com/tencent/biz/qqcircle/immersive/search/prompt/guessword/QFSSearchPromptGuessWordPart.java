package com.tencent.biz.qqcircle.immersive.search.prompt.guessword;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import circlesearch.CircleSearchExhibition$PromptGuess;
import circlesearch.CircleSearchExhibition$PromptGuessInfo;
import circlesearch.CircleSearchExhibition$StPromptResp;
import com.google.android.material.appbar.AppBarLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import ua0.i;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\r\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001eR\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001b\u0010B\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010?\u001a\u0004\bE\u0010F\u00a8\u0006J"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/guessword/QFSSearchPromptGuessWordPart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Landroid/view/View$OnClickListener;", "", "initView", "F9", "I9", "Lcirclesearch/CircleSearchExhibition$PromptGuess;", "promptGuess", "", "isRefresh", "E9", QAdRewardDefine$VideoParams.ISCACHE, "M9", "J9", "K9", "L9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "", "getLogTag", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "guessRootView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvRefresh", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "tvRefreshIcon", h.F, "tvTitle", "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/guessword/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/immersive/search/prompt/guessword/c;", "guessAdapter", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/guessword/f;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/immersive/search/prompt/guessword/f;", "skeletonAdapter", "Landroid/view/animation/RotateAnimation;", "D", "Landroid/view/animation/RotateAnimation;", "rotateAnimation", "Lcom/google/android/material/appbar/AppBarLayout;", "E", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "attachInfo", "Lp70/e;", "G", "Lkotlin/Lazy;", "D9", "()Lp70/e;", "viewModel", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/guessword/QFSSearchPromptGuessWordViewModel;", "H", "C9", "()Lcom/tencent/biz/qqcircle/immersive/search/prompt/guessword/QFSSearchPromptGuessWordViewModel;", "refreshViewModel", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSearchPromptGuessWordPart extends u implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private f skeletonAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private RotateAnimation rotateAnimation;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private AppBarLayout appBarLayout;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String attachInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy refreshViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup guessRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tvRefresh;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView tvRefreshIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tvTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c guessAdapter;

    public QFSSearchPromptGuessWordPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<p70.e>() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.guessword.QFSSearchPromptGuessWordPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final p70.e invoke() {
                return (p70.e) QFSSearchPromptGuessWordPart.this.getViewModel(p70.e.class);
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QFSSearchPromptGuessWordViewModel>() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.guessword.QFSSearchPromptGuessWordPart$refreshViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QFSSearchPromptGuessWordViewModel invoke() {
                return (QFSSearchPromptGuessWordViewModel) QFSSearchPromptGuessWordPart.this.getViewModel(QFSSearchPromptGuessWordViewModel.class);
            }
        });
        this.refreshViewModel = lazy2;
    }

    private final QFSSearchPromptGuessWordViewModel C9() {
        Object value = this.refreshViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-refreshViewModel>(...)");
        return (QFSSearchPromptGuessWordViewModel) value;
    }

    private final p70.e D9() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (p70.e) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E9(CircleSearchExhibition$PromptGuess promptGuess, boolean isRefresh) {
        String str;
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt;
        PBStringField pBStringField;
        QFSSearchPromptGuessWordViewModel C9 = C9();
        if (promptGuess != null && (feedCloudCommon$StCommonExt = promptGuess.ext_info) != null && (pBStringField = feedCloudCommon$StCommonExt.attachInfo) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        C9.S1(str);
        String L0 = QFSVideoView.L0();
        CircleSearchExhibition$PromptGuess b16 = h60.a.b(L0);
        if (b16 != null && !isRefresh) {
            M9(b16, true);
        } else {
            h60.a.f(L0, promptGuess);
            M9(promptGuess, false);
        }
    }

    private final void F9() {
        MutableLiveData<UIStateData<CircleSearchExhibition$StPromptResp>> M1 = D9().M1();
        QFSBaseFragment hostFragment = getHostFragment();
        final Function1<UIStateData<CircleSearchExhibition$StPromptResp>, Unit> function1 = new Function1<UIStateData<CircleSearchExhibition$StPromptResp>, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.guessword.QFSSearchPromptGuessWordPart$initObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<CircleSearchExhibition$StPromptResp> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<CircleSearchExhibition$StPromptResp> uIStateData) {
                if (uIStateData.getState() != 2 && uIStateData.getState() != 3) {
                    QLog.w(QFSSearchPromptGuessWordPart.this.getTAG(), 1, "[onChanged] invalid state");
                    QFSSearchPromptGuessWordPart.this.K9();
                } else {
                    QFSSearchPromptGuessWordPart qFSSearchPromptGuessWordPart = QFSSearchPromptGuessWordPart.this;
                    CircleSearchExhibition$StPromptResp data = uIStateData.getData();
                    qFSSearchPromptGuessWordPart.E9(data != null ? data.guess_prompt : null, false);
                }
            }
        };
        M1.observe(hostFragment, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.guessword.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSSearchPromptGuessWordPart.G9(Function1.this, obj);
            }
        });
        LiveData<CircleSearchExhibition$PromptGuess> Q1 = C9().Q1();
        QFSBaseFragment hostFragment2 = getHostFragment();
        final Function1<CircleSearchExhibition$PromptGuess, Unit> function12 = new Function1<CircleSearchExhibition$PromptGuess, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.guessword.QFSSearchPromptGuessWordPart$initObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CircleSearchExhibition$PromptGuess circleSearchExhibition$PromptGuess) {
                invoke2(circleSearchExhibition$PromptGuess);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable CircleSearchExhibition$PromptGuess circleSearchExhibition$PromptGuess) {
                if (circleSearchExhibition$PromptGuess != null) {
                    QFSSearchPromptGuessWordPart.this.E9(circleSearchExhibition$PromptGuess, true);
                } else {
                    QLog.w(QFSSearchPromptGuessWordPart.this.getTAG(), 1, "[refreshChanged] error");
                    QCircleToast.v(QCircleToast.f91645e, "\u5237\u65b0\u5931\u8d25", 0);
                }
            }
        };
        Q1.observe(hostFragment2, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.guessword.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSSearchPromptGuessWordPart.H9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void I9() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.rotateAnimation = rotateAnimation;
        rotateAnimation.setDuration(400L);
        RotateAnimation rotateAnimation2 = this.rotateAnimation;
        if (rotateAnimation2 != null) {
            rotateAnimation2.setInterpolator(new lc0.a(0.5f, 0.0f, 0.5f, 1.0f));
        }
    }

    private final void J9(CircleSearchExhibition$PromptGuess promptGuess) {
        StringBuilder sb5 = new StringBuilder();
        List<CircleSearchExhibition$PromptGuessInfo> list = promptGuess.guess_info.get();
        Intrinsics.checkNotNullExpressionValue(list, "promptGuess.guess_info.get()");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(((CircleSearchExhibition$PromptGuessInfo) it.next()).name.get());
            sb5.append(",");
        }
        HashMap hashMap = new HashMap();
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "allTextBuilder.toString()");
        hashMap.put("xsj_query_text", sb6);
        ViewGroup viewGroup = this.guessRootView;
        if (viewGroup != null) {
            i.k(viewGroup, QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_GUESS_CONTENT, hashMap, promptGuess.hashCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9() {
        int i3;
        AppBarLayout appBarLayout;
        ViewGroup viewGroup = this.guessRootView;
        if (viewGroup != null) {
            AppBarLayout appBarLayout2 = this.appBarLayout;
            if (appBarLayout2 != null) {
                i3 = appBarLayout2.indexOfChild(viewGroup);
            } else {
                i3 = -1;
            }
            if (i3 >= 0 && (appBarLayout = this.appBarLayout) != null) {
                appBarLayout.removeView(viewGroup);
            }
        }
    }

    private final void L9() {
        View view;
        int i3;
        int i16;
        AppBarLayout appBarLayout;
        AppBarLayout appBarLayout2 = this.appBarLayout;
        if (appBarLayout2 != null) {
            view = appBarLayout2.findViewById(R.id.f53962dx);
        } else {
            view = null;
        }
        if (view == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        ViewGroup viewGroup = this.guessRootView;
        if (viewGroup != null) {
            AppBarLayout appBarLayout3 = this.appBarLayout;
            if (appBarLayout3 != null) {
                i16 = appBarLayout3.indexOfChild(viewGroup);
            } else {
                i16 = -1;
            }
            if (i16 < 0 && (appBarLayout = this.appBarLayout) != null) {
                appBarLayout.addView(viewGroup, i3);
            }
        }
    }

    private final void M9(CircleSearchExhibition$PromptGuess promptGuess, boolean isCache) {
        Boolean bool;
        PBRepeatMessageField<CircleSearchExhibition$PromptGuessInfo> pBRepeatMessageField;
        PBBoolField pBBoolField;
        if (QLog.isColorLevel()) {
            String tag = getTAG();
            Integer num = null;
            if (promptGuess != null && (pBBoolField = promptGuess.show) != null) {
                bool = Boolean.valueOf(pBBoolField.get());
            } else {
                bool = null;
            }
            if (promptGuess != null && (pBRepeatMessageField = promptGuess.guess_info) != null) {
                num = Integer.valueOf(pBRepeatMessageField.size());
            }
            QLog.d(tag, 2, "[tryFillPromptGuess] isCache: " + isCache + ", show: " + bool + ", size: " + num);
        }
        if (promptGuess != null && promptGuess.has()) {
            if (!promptGuess.show.get()) {
                QLog.w(getTAG(), 1, "[tryFillPromptGuess] no show");
                K9();
                return;
            }
            if (promptGuess.guess_info.isEmpty()) {
                QLog.w(getTAG(), 1, "[tryFillPromptGuess] empty data");
                K9();
                return;
            }
            this.attachInfo = promptGuess.ext_info.attachInfo.get();
            TextView textView = this.tvTitle;
            if (textView != null) {
                textView.setText(promptGuess.name.get());
            }
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null) {
                recyclerView.setAdapter(this.guessAdapter);
            }
            c cVar = this.guessAdapter;
            if (cVar != null) {
                cVar.setData(promptGuess.guess_info.get());
            }
            ImageView imageView = this.tvRefreshIcon;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            TextView textView2 = this.tvRefresh;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            L9();
            J9(promptGuess);
            return;
        }
        QLog.w(getTAG(), 1, "[tryFillPromptGuess] invalid data");
        K9();
    }

    private final void initView() {
        TextView textView;
        ImageView imageView;
        TextView textView2;
        RecyclerView recyclerView;
        ViewGroup viewGroup = this.guessRootView;
        if (viewGroup != null) {
            textView = (TextView) viewGroup.findViewById(R.id.f53852dm);
        } else {
            textView = null;
        }
        this.tvRefresh = textView;
        ViewGroup viewGroup2 = this.guessRootView;
        if (viewGroup2 != null) {
            imageView = (ImageView) viewGroup2.findViewById(R.id.f53842dl);
        } else {
            imageView = null;
        }
        this.tvRefreshIcon = imageView;
        ViewGroup viewGroup3 = this.guessRootView;
        if (viewGroup3 != null) {
            textView2 = (TextView) viewGroup3.findViewById(R.id.f53882dp);
        } else {
            textView2 = null;
        }
        this.tvTitle = textView2;
        ViewGroup viewGroup4 = this.guessRootView;
        if (viewGroup4 != null) {
            recyclerView = (RecyclerView) viewGroup4.findViewById(R.id.f53862dn);
        } else {
            recyclerView = null;
        }
        this.recyclerView = recyclerView;
        TextView textView3 = this.tvTitle;
        if (textView3 != null) {
            textView3.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f194994de));
        }
        TextView textView4 = this.tvRefresh;
        if (textView4 != null) {
            textView4.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f194984dd));
        }
        Drawable o16 = ie0.a.f().o(getContext(), R.drawable.qui_refresh, R.color.qui_common_icon_secondary, 1000);
        ImageView imageView2 = this.tvRefreshIcon;
        if (imageView2 != null) {
            imageView2.setBackground(o16);
            i.k(imageView2, QCircleDaTongConstant.ElementId.EM_XSJ_CHANGE_BUTTON, null, 0);
            imageView2.setOnClickListener(this);
        }
        TextView textView5 = this.tvRefresh;
        if (textView5 != null) {
            textView5.setOnClickListener(this);
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new GridLayoutManager(recyclerView2.getContext(), 2));
            recyclerView2.setNestedScrollingEnabled(false);
            recyclerView2.addItemDecoration(new a());
            QCircleReportBean reportBean = getReportBean();
            Intrinsics.checkNotNullExpressionValue(reportBean, "reportBean");
            this.guessAdapter = new c(reportBean);
            f fVar = new f();
            this.skeletonAdapter = fVar;
            recyclerView2.setAdapter(fVar);
            f fVar2 = this.skeletonAdapter;
            if (fVar2 != null) {
                fVar2.notifyDataSetChanged();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSearchPromptGuessWordPart";
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r0 != false) goto L15;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(@Nullable View v3) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        boolean z17 = true;
        if (v3 != null && v3.getId() == R.id.f53852dm) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (v3 == null || v3.getId() != R.id.f53842dl) {
                z17 = false;
            }
        }
        ImageView imageView = this.tvRefreshIcon;
        if (imageView != null) {
            imageView.startAnimation(this.rotateAnimation);
        }
        C9().refresh();
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        AppBarLayout appBarLayout;
        super.onInitView(rootView);
        ViewGroup viewGroup = null;
        if (rootView != null) {
            appBarLayout = (AppBarLayout) rootView.findViewById(R.id.f53822dj);
        } else {
            appBarLayout = null;
        }
        this.appBarLayout = appBarLayout;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.f53892dq);
        }
        this.guessRootView = viewGroup;
        if (!r60.a.f430818a.b()) {
            K9();
            return;
        }
        initView();
        I9();
        F9();
    }
}

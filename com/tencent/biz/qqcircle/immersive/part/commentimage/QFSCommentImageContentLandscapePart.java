package com.tencent.biz.qqcircle.immersive.part.commentimage;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleCommentPicLayerBean;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.animation.transition.TransitionAnimUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUser;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageContentLandscapePart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/b;", "", "initData", "H9", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;", "info", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onSave", "l7", "", "getLogTag", "e7", "B6", "c8", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "d3", "Lfeedcloud/FeedCloudMeta$StUser;", QCircleAlphaUserReporter.KEY_USER, "L5", "Landroidx/viewpager2/widget/ViewPager2;", "d", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/aa;", "e", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/aa;", "contentAdapter", "", "f", "Ljava/util/Set;", "likeResultSet", tl.h.F, "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;", "currentInfo", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageViewModel;", "i", "Lkotlin/Lazy;", "G9", "()Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageViewModel;", "viewModel", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSCommentImageContentLandscapePart extends com.tencent.biz.qqcircle.immersive.part.u implements b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewPager2 viewPager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private aa contentAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> likeResultSet = new LinkedHashSet();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSCommentImageInfo currentInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageContentLandscapePart$a", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            QFSCommentImageContentLandscapePart.this.G9().a2(position);
            VideoReport.traverseExposure();
        }
    }

    public QFSCommentImageContentLandscapePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QFSCommentImageViewModel>() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.QFSCommentImageContentLandscapePart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QFSCommentImageViewModel invoke() {
                return (QFSCommentImageViewModel) QFSCommentImageContentLandscapePart.this.getViewModel(QFSCommentImageViewModel.class);
            }
        });
        this.viewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(QFSCommentImageInfo info) {
        int i3;
        String str;
        PBStringField pBStringField;
        if (info.getStReply() != null) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        int i16 = i3;
        boolean u16 = info.u();
        String str2 = info.getStComment().f398447id.get();
        FeedCloudMeta$StReply stReply = info.getStReply();
        if (stReply != null && (pBStringField = stReply.f398460id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentPraiseUpdateEvent(i16, u16 ? 1 : 0, info.getFeedId(), str2, str, info.n(), hashCode()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QFSCommentImageViewModel G9() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (QFSCommentImageViewModel) value;
    }

    private final void H9() {
        LiveData<QFSCommentImageInfo> Q1 = G9().Q1();
        QFSBaseFragment hostFragment = getHostFragment();
        final Function1<QFSCommentImageInfo, Unit> function1 = new Function1<QFSCommentImageInfo, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.QFSCommentImageContentLandscapePart$initObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QFSCommentImageInfo qFSCommentImageInfo) {
                invoke2(qFSCommentImageInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QFSCommentImageInfo qFSCommentImageInfo) {
                QFSCommentImageContentLandscapePart.this.currentInfo = qFSCommentImageInfo;
            }
        };
        Q1.observe(hostFragment, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSCommentImageContentLandscapePart.I9(Function1.this, obj);
            }
        });
        LiveData<Pair<String, Boolean>> X1 = G9().X1();
        QFSBaseFragment hostFragment2 = getHostFragment();
        final Function1<Pair<? extends String, ? extends Boolean>, Unit> function12 = new Function1<Pair<? extends String, ? extends Boolean>, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.QFSCommentImageContentLandscapePart$initObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends Boolean> pair) {
                invoke2((Pair<String, Boolean>) pair);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:12:0x0067, code lost:
            
                r6 = r5.this$0.contentAdapter;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(Pair<String, Boolean> pair) {
                Set set;
                aa aaVar;
                aa aaVar2;
                String tag = QFSCommentImageContentLandscapePart.this.getTAG();
                String first = pair.getFirst();
                QLog.d(tag, 1, "[initObserver] id=" + ((Object) first) + ", success=" + pair.getSecond());
                set = QFSCommentImageContentLandscapePart.this.likeResultSet;
                set.remove(pair.getFirst());
                aaVar = QFSCommentImageContentLandscapePart.this.contentAdapter;
                QFSCommentImageInfo i06 = aaVar != null ? aaVar.i0(pair.getFirst()) : null;
                if (!pair.getSecond().booleanValue()) {
                    if (i06 != null && aaVar2 != null) {
                        aaVar2.j0(i06);
                    }
                    QCircleToast.v(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f19228473), 0);
                    return;
                }
                if (i06 != null) {
                    QFSCommentImageContentLandscapePart qFSCommentImageContentLandscapePart = QFSCommentImageContentLandscapePart.this;
                    i06.d();
                    qFSCommentImageContentLandscapePart.F9(i06);
                }
            }
        };
        X1.observe(hostFragment2, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSCommentImageContentLandscapePart.J9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initData() {
        Serializable serializable;
        Intent intent;
        Activity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            serializable = intent.getSerializableExtra("key_bundle_common_init_bean");
        } else {
            serializable = null;
        }
        if (serializable instanceof QCircleCommentPicLayerBean) {
            G9().Z1((QCircleCommentPicLayerBean) serializable);
            aa aaVar = new aa(G9().W1(), TransitionAnimUtil.getCoverDrawable());
            this.contentAdapter = aaVar;
            aaVar.setData(G9().U1());
            aa aaVar2 = this.contentAdapter;
            if (aaVar2 != null) {
                aaVar2.n0(this);
            }
            ViewPager2 viewPager2 = this.viewPager;
            if (viewPager2 != null) {
                viewPager2.setAdapter(this.contentAdapter);
            }
            ViewPager2 viewPager22 = this.viewPager;
            if (viewPager22 != null) {
                viewPager22.setCurrentItem(G9().W1(), false);
                return;
            }
            return;
        }
        QLog.w(getTAG(), 1, "[initData] invalid initBean");
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.commentimage.b
    public void B6() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.commentimage.b
    public void L5(@NotNull FeedCloudMeta$StUser user) {
        Intrinsics.checkNotNullParameter(user, "user");
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.commentimage.b
    public void e7(@NotNull QFSCommentImageInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        QLog.d(getTAG(), 1, "[onLike] id=" + info.l());
        if (this.likeResultSet.contains(info.l())) {
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.ksw), 0);
        } else {
            this.likeResultSet.add(info.l());
            G9().P1(info);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSCommentImageContentLandscapePart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.commentimage.b
    public void l7() {
        broadcastMessage("2", null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewPager2 viewPager2;
        super.onInitView(rootView);
        if (rootView != null) {
            viewPager2 = (ViewPager2) rootView.findViewById(R.id.f3594138);
        } else {
            viewPager2 = null;
        }
        this.viewPager = viewPager2;
        if (viewPager2 != null) {
            viewPager2.registerOnPageChangeCallback(new a());
        }
        H9();
        initData();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.commentimage.b
    public void onSave() {
        broadcastMessage("1", null);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.commentimage.b
    public void c8() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.commentimage.b
    public void d3(int clickType) {
    }
}

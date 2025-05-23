package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stAcquisitionInfo;
import UserGrowth.stFeedIconOpConf;
import UserGrowth.stSimpleMetaFeed;
import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.WSDownloadStatus;
import com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.WSThreeSegmentDownloadHelper;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.ai;
import com.tencent.biz.pubaccount.weishi.view.RoundCornerImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.ProgressButton;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001IB!\u0012\u0006\u0010F\u001a\u00020E\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0014J\b\u0010\u000b\u001a\u00020\u0002H\u0014J\b\u0010\f\u001a\u00020\u0002H\u0014J\b\u0010\r\u001a\u00020\u0004H\u0014J\b\u0010\u000e\u001a\u00020\u0002H\u0014J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004H\u0014J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0014R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010%\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010'R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010*R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010-R\u0016\u00100\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006J"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/WSVerticalItemThreeSegmentBigCardController;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/c;", "", "H", "", "location", UserInfo.SEX_FEMALE, "G", "O", "P", "g", tl.h.F, "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "position", "u", "currentPosition", "v", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;", "getHolder", "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;", "holder", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "D", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "getFragment", "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "fragment", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/ai$c;", "E", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/ai$c;", "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/ai$c;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/ai$c;)V", "bigCardStatusChangeListener", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/h;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/h;", "animHelper", "Lcom/tencent/biz/pubaccount/weishi/view/RoundCornerImageView;", "Lcom/tencent/biz/pubaccount/weishi/view/RoundCornerImageView;", "ivIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tvTitle", "I", "tvDes", "Landroid/widget/ImageView;", "J", "Landroid/widget/ImageView;", "ivDelete", "Lcom/tencent/mobileqq/widget/ProgressButton;", "K", "Lcom/tencent/mobileqq/widget/ProgressButton;", "tvDownBtn", "Landroid/widget/FrameLayout;", "L", "Landroid/widget/FrameLayout;", "tvDownBtnContainer", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/m;", "M", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/m;", "downloadViewHelper", "Lez/b;", "N", "Lez/b;", "commercialInfo", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;)V", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSVerticalItemThreeSegmentBigCardController extends com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c {

    /* renamed from: C, reason: from kotlin metadata */
    private final au holder;

    /* renamed from: D, reason: from kotlin metadata */
    private final WSVerticalPageFragment fragment;

    /* renamed from: E, reason: from kotlin metadata */
    private ai.c bigCardStatusChangeListener;

    /* renamed from: F, reason: from kotlin metadata */
    private final com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.h animHelper;

    /* renamed from: G, reason: from kotlin metadata */
    private RoundCornerImageView ivIcon;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView tvTitle;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView tvDes;

    /* renamed from: J, reason: from kotlin metadata */
    private ImageView ivDelete;

    /* renamed from: K, reason: from kotlin metadata */
    private ProgressButton tvDownBtn;

    /* renamed from: L, reason: from kotlin metadata */
    private FrameLayout tvDownBtnContainer;

    /* renamed from: M, reason: from kotlin metadata */
    private com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.m downloadViewHelper;

    /* renamed from: N, reason: from kotlin metadata */
    private ez.b commercialInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/pubaccount/weishi/verticalvideo/holder/WSVerticalItemThreeSegmentBigCardController$b", "Lcom/tencent/biz/pubaccount/weishi/comment/n;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b extends com.tencent.biz.pubaccount.weishi.comment.n {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            ai.c bigCardStatusChangeListener = WSVerticalItemThreeSegmentBigCardController.this.getBigCardStatusChangeListener();
            if (bigCardStatusChangeListener != null) {
                bigCardStatusChangeListener.a();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/pubaccount/weishi/verticalvideo/holder/WSVerticalItemThreeSegmentBigCardController$c", "Lcom/tencent/biz/pubaccount/weishi/comment/n;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class c extends com.tencent.biz.pubaccount.weishi.comment.n {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            ai.c bigCardStatusChangeListener = WSVerticalItemThreeSegmentBigCardController.this.getBigCardStatusChangeListener();
            if (bigCardStatusChangeListener != null) {
                bigCardStatusChangeListener.b();
            }
            WSVerticalItemThreeSegmentBigCardController.this.O();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WSVerticalItemThreeSegmentBigCardController(Context context, au holder, WSVerticalPageFragment wSVerticalPageFragment) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.holder = holder;
        this.fragment = wSVerticalPageFragment;
        this.animHelper = new com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F(int location) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.i.d(this.fragment, (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) this.f80413i, "videotag_rich", location, 1, true);
    }

    private final void G() {
        View view = this.f80410e;
        if (view != null) {
            this.animHelper.e(view, 0, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(WSVerticalItemThreeSegmentBigCardController this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(WSVerticalItemThreeSegmentBigCardController this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(WSVerticalItemThreeSegmentBigCardController this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(WSVerticalItemThreeSegmentBigCardController this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(WSVerticalItemThreeSegmentBigCardController this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void N(WSVerticalItemThreeSegmentBigCardController this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.p.a(this$0.fragment, (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) this$0.f80413i, WSThreeSegmentDownloadHelper.f81856a.f());
        this$0.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void O() {
        Map mutableMapOf;
        WSVerticalPageFragment wSVerticalPageFragment = this.fragment;
        if (wSVerticalPageFragment != null) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("btn_status", String.valueOf(WSThreeSegmentDownloadHelper.f81856a.f().getType())));
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.W(wSVerticalPageFragment.getFrom(), wSVerticalPageFragment.getPlayScene(), "videotag_rich", (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) this.f80413i, true, mutableMapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P() {
        this.animHelper.a();
        ai.c cVar = this.bigCardStatusChangeListener;
        if (cVar != null) {
            cVar.a();
        }
        View view = this.f80410e;
        if (view != null) {
            view.setTranslationX(this.animHelper.b());
            view.setVisibility(8);
        }
    }

    /* renamed from: E, reason: from getter */
    public final ai.c getBigCardStatusChangeListener() {
        return this.bigCardStatusChangeListener;
    }

    public final void Q(ai.c cVar) {
        this.bigCardStatusChangeListener = cVar;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.m mVar = this.downloadViewHelper;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadViewHelper");
            mVar = null;
        }
        mVar.s();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        ez.a f16 = c().f();
        this.commercialInfo = f16 instanceof ez.b ? (ez.b) f16 : null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        ez.b bVar = this.commercialInfo;
        if (bVar != null) {
            WSPicLoader g16 = WSPicLoader.g();
            RoundCornerImageView roundCornerImageView = this.ivIcon;
            TextView textView = null;
            if (roundCornerImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
                roundCornerImageView = null;
            }
            g16.w(roundCornerImageView, bVar.h(), null);
            TextView textView2 = this.tvTitle;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
                textView2 = null;
            }
            textView2.setText(bVar.j());
            TextView textView3 = this.tvDes;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvDes");
            } else {
                textView = textView3;
            }
            textView.setText(bVar.f());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.d1w;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        FrameLayout frameLayout;
        ProgressButton progressButton;
        this.animHelper.c(com.tencent.biz.pubaccount.weishi.util.r.H(258.0f));
        View p16 = p(R.id.p3e);
        Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi.view.RoundCornerImageView");
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) p16;
        this.ivIcon = roundCornerImageView;
        if (roundCornerImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
            roundCornerImageView = null;
        }
        roundCornerImageView.setCorner(com.tencent.biz.pubaccount.weishi.util.r.H(42.0f));
        View p17 = p(R.id.p3c);
        Intrinsics.checkNotNull(p17, "null cannot be cast to non-null type android.widget.TextView");
        this.tvTitle = (TextView) p17;
        View p18 = p(R.id.p3b);
        Intrinsics.checkNotNull(p18, "null cannot be cast to non-null type android.widget.TextView");
        this.tvDes = (TextView) p18;
        View p19 = p(R.id.p3_);
        Intrinsics.checkNotNull(p19, "null cannot be cast to non-null type android.widget.ImageView");
        this.ivDelete = (ImageView) p19;
        View p26 = p(R.id.p6k);
        Intrinsics.checkNotNull(p26, "null cannot be cast to non-null type com.tencent.mobileqq.widget.ProgressButton");
        this.tvDownBtn = (ProgressButton) p26;
        View p27 = p(R.id.p6l);
        Intrinsics.checkNotNull(p27, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.tvDownBtnContainer = (FrameLayout) p27;
        H();
        WSVerticalPageFragment wSVerticalPageFragment = this.fragment;
        FrameLayout frameLayout2 = this.tvDownBtnContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDownBtnContainer");
            frameLayout = null;
        } else {
            frameLayout = frameLayout2;
        }
        ProgressButton progressButton2 = this.tvDownBtn;
        if (progressButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDownBtn");
            progressButton = null;
        } else {
            progressButton = progressButton2;
        }
        this.downloadViewHelper = new com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.m(wSVerticalPageFragment, frameLayout, progressButton, WSThreeSegmentDownloadHelper.f81856a.f(), "videotag_rich", true, new Function1<WSDownloadStatus, Unit>() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalItemThreeSegmentBigCardController$initView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WSDownloadStatus wSDownloadStatus) {
                invoke2(wSDownloadStatus);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WSDownloadStatus it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WSVerticalItemThreeSegmentBigCardController.this.P();
            }
        });
        P();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void u(int position) {
        stSimpleMetaFeed e16;
        stAcquisitionInfo stacquisitioninfo;
        stFeedIconOpConf stfeediconopconf;
        com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.m mVar = this.downloadViewHelper;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadViewHelper");
            mVar = null;
        }
        mVar.r((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) this.f80413i);
        View view = this.f80410e;
        if (view == null || com.tencent.biz.qqstory.utils.l.c(view.getContext()) || WSThreeSegmentDownloadHelper.f81856a.f() != WSDownloadStatus.Download) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) this.f80413i;
        this.animHelper.d(view, Math.max((jVar == null || (e16 = jVar.e()) == null || (stacquisitioninfo = e16.acquisitionInfo) == null || (stfeediconopconf = stacquisitioninfo.feedIconOpConf) == null) ? 6000 : stfeediconopconf.third, 6000), new c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void v(int currentPosition) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.m mVar = this.downloadViewHelper;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadViewHelper");
            mVar = null;
        }
        mVar.s();
        P();
    }

    private final void H() {
        p(R.id.p3a).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.holder.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WSVerticalItemThreeSegmentBigCardController.I(WSVerticalItemThreeSegmentBigCardController.this, view);
            }
        });
        TextView textView = this.tvDes;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDes");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.holder.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WSVerticalItemThreeSegmentBigCardController.J(WSVerticalItemThreeSegmentBigCardController.this, view);
            }
        });
        TextView textView2 = this.tvTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.holder.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WSVerticalItemThreeSegmentBigCardController.K(WSVerticalItemThreeSegmentBigCardController.this, view);
            }
        });
        RoundCornerImageView roundCornerImageView = this.ivIcon;
        if (roundCornerImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
            roundCornerImageView = null;
        }
        roundCornerImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.holder.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WSVerticalItemThreeSegmentBigCardController.L(WSVerticalItemThreeSegmentBigCardController.this, view);
            }
        });
        ProgressButton progressButton = this.tvDownBtn;
        if (progressButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDownBtn");
            progressButton = null;
        }
        progressButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.holder.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WSVerticalItemThreeSegmentBigCardController.M(WSVerticalItemThreeSegmentBigCardController.this, view);
            }
        });
        ImageView imageView2 = this.ivDelete;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivDelete");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.holder.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WSVerticalItemThreeSegmentBigCardController.N(WSVerticalItemThreeSegmentBigCardController.this, view);
            }
        });
    }
}

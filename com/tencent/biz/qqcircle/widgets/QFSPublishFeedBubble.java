package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import e40.QFSFeedBubbleInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001-BV\b\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u0012#\u0010'\u001a\u001f\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0003\u0018\u00010!\u0012\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u0011\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0005H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR1\u0010'\u001a\u001f\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0003\u0018\u00010!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/QFSPublishFeedBubble;", "Lcom/tencent/biz/qqcircle/widgets/QCircleRelativePopupWindow;", "Landroid/view/View$OnClickListener;", "", "l", "Landroid/view/View;", "o", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "p", "j", "Landroid/widget/ImageView;", "ivImage", "", "imageUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lkotlin/Function0;", "block", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "v", NodeProps.ON_CLICK, "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "Le40/a;", "e", "Le40/a;", "bubbleInfo", "", "f", "I", "whichArrow", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bubble", tl.h.F, "Lkotlin/jvm/functions/Function1;", "onSuccess", "i", "Lkotlin/jvm/functions/Function0;", "onBubbleClick", "<init>", "(Landroid/content/Context;Le40/a;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSPublishFeedBubble extends QCircleRelativePopupWindow implements View.OnClickListener {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QFSFeedBubbleInfo bubbleInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int whichArrow;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function1<QFSPublishFeedBubble, Unit> onSuccess;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function0<Unit> onBubbleClick;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019JW\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\b2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/QFSPublishFeedBubble$a;", "", "Landroid/content/Context;", "context", "Le40/a;", "bubbleInfo", "", "whichArrow", "Lkotlin/Function1;", "Lcom/tencent/biz/qqcircle/widgets/QFSPublishFeedBubble;", "Lkotlin/ParameterName;", "name", "bubble", "", "onSuccess", "Lkotlin/Function0;", "onBubbleClick", "a", "", "TAG", "Ljava/lang/String;", "WHICH_ARROW_BOTTOM", "I", "WHICH_ARROW_UP", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.widgets.QFSPublishFeedBubble$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QFSPublishFeedBubble a(@NotNull Context context, @NotNull QFSFeedBubbleInfo bubbleInfo, int whichArrow, @Nullable Function1<? super QFSPublishFeedBubble, Unit> onSuccess, @Nullable Function0<Unit> onBubbleClick) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
            return new QFSPublishFeedBubble(context, bubbleInfo, whichArrow, onSuccess, onBubbleClick, null);
        }

        Companion() {
        }
    }

    public /* synthetic */ QFSPublishFeedBubble(Context context, QFSFeedBubbleInfo qFSFeedBubbleInfo, int i3, Function1 function1, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, qFSFeedBubbleInfo, i3, function1, function0);
    }

    private final void j(View rootView) {
        View findViewById = rootView.findViewById(R.id.y07);
        View findViewById2 = rootView.findViewById(R.id.f165904y04);
        int i3 = this.whichArrow;
        if (i3 != 0) {
            if (i3 == 1) {
                findViewById.setVisibility(8);
                findViewById2.setVisibility(0);
                return;
            }
            return;
        }
        findViewById2.setVisibility(8);
        findViewById.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        m(new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.widgets.QFSPublishFeedBubble$callSuccessOnUIThread$1
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
                Function1 function1;
                function1 = QFSPublishFeedBubble.this.onSuccess;
                if (function1 != null) {
                    function1.invoke(QFSPublishFeedBubble.this);
                }
            }
        });
    }

    private final void l() {
        View o16 = o();
        setBackgroundDrawable(new ColorDrawable(0));
        o16.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        o16.setOnClickListener(this);
        setContentView(o16);
        p(o16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            block.invoke();
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.be
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPublishFeedBubble.n(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0067, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        if (r1.equals("relation") == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if (r1.equals("new_user") == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x005a, code lost:
    
        r0 = r0.inflate(com.tencent.mobileqq.R.layout.goy, (android.view.ViewGroup) null);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "inflater.inflate(R.layou\u2026_image_bottom_text, null)");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final View o() {
        LayoutInflater from = LayoutInflater.from(this.context);
        String showType = this.bubbleInfo.getShowType();
        int hashCode = showType.hashCode();
        if (hashCode != -554436100) {
            if (hashCode != 299066663) {
                if (hashCode == 1377369866) {
                }
            } else if (showType.equals(WadlProxyConsts.KEY_MATERIAL)) {
                View inflate = from.inflate(R.layout.gow, (ViewGroup) null);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026t_image_right_text, null)");
                return inflate;
            }
            View inflate2 = from.inflate(R.layout.gox, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflater.inflate(R.layou\u2026ed_bubble_one_text, null)");
            return inflate2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x00ea, code lost:
    
        if (r7.bubbleInfo.getIcon().length() != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x00ed, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x00ee, code lost:
    
        if (r3 == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00f0, code lost:
    
        k();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00f4, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "ivTopImg");
        q(r0, r7.bubbleInfo.getIcon());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0103, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a4, code lost:
    
        if (r0.equals("relation") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0044, code lost:
    
        if (r0.equals("new_user") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x00b9, code lost:
    
        r0 = (android.widget.ImageView) r8.findViewById(com.tencent.mobileqq.R.id.y_5);
        r1 = (android.widget.TextView) r8.findViewById(com.tencent.mobileqq.R.id.kbs);
        r8 = (android.widget.TextView) r8.findViewById(com.tencent.mobileqq.R.id.f167057me2);
        r1.setText(r7.bubbleInfo.getTitle());
        r8.setText(r7.bubbleInfo.getSubtitle());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void p(View rootView) {
        j(rootView);
        String showType = this.bubbleInfo.getShowType();
        boolean z16 = true;
        QLog.d("QFSPublishFeedBubble", 1, "initData, tipShowType: " + showType);
        int hashCode = showType.hashCode();
        if (hashCode != -554436100) {
            if (hashCode != 299066663) {
                if (hashCode == 1377369866) {
                }
            } else if (showType.equals(WadlProxyConsts.KEY_MATERIAL)) {
                ImageView ivLeftImg = (ImageView) rootView.findViewById(R.id.f165943lo1);
                TextView textView = (TextView) rootView.findViewById(R.id.kbs);
                TextView textView2 = (TextView) rootView.findViewById(R.id.f167057me2);
                textView.setText(this.bubbleInfo.getTitle());
                textView2.setText(this.bubbleInfo.getSubtitle());
                if (this.bubbleInfo.getIcon().length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    k();
                    return;
                } else {
                    Intrinsics.checkNotNullExpressionValue(ivLeftImg, "ivLeftImg");
                    q(ivLeftImg, this.bubbleInfo.getIcon());
                    return;
                }
            }
            ((TextView) rootView.findViewById(R.id.kbs)).setText(this.bubbleInfo.getTitle());
            k();
        }
    }

    private final void q(final ImageView ivImage, final String imageUrl) {
        QLog.d("QFSPublishFeedBubble", 1, "loadImage, imageUrl: " + imageUrl);
        QCircleFeedPicLoader g16 = QCircleFeedPicLoader.g();
        Option obtain = Option.obtain();
        obtain.setUrl(imageUrl);
        obtain.setPredecode(true);
        g16.loadImage(obtain, new QCirclePicStateListener() { // from class: com.tencent.biz.qqcircle.widgets.QFSPublishFeedBubble$loadImage$2
            @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
            public void onStateChange(@NotNull LoadState state, @NotNull final Option option) {
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(option, "option");
                QLog.d("QFSPublishFeedBubble", 1, "loadImage, onStateChange, state: " + state + ", option: " + option + ", imageUrl: " + imageUrl);
                if (state == LoadState.STATE_SUCCESS) {
                    QFSPublishFeedBubble qFSPublishFeedBubble = this;
                    final ImageView imageView = ivImage;
                    qFSPublishFeedBubble.m(new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.widgets.QFSPublishFeedBubble$loadImage$2$onStateChange$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            imageView.setImageDrawable(new BitmapDrawable(option.getResultBitMap()));
                        }
                    });
                    this.k();
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        Function0<Unit> function0 = this.onBubbleClick;
        if (function0 != null) {
            function0.invoke();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    QFSPublishFeedBubble(Context context, QFSFeedBubbleInfo qFSFeedBubbleInfo, int i3, Function1<? super QFSPublishFeedBubble, Unit> function1, Function0<Unit> function0) {
        super(context);
        this.context = context;
        this.bubbleInfo = qFSFeedBubbleInfo;
        this.whichArrow = i3;
        this.onSuccess = function1;
        this.onBubbleClick = function0;
        setTouchable(true);
        setOutsideTouchable(false);
        setFocusable(false);
        l();
    }
}

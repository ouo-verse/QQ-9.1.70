package com.tencent.robot.adelie.homepage.ugc.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.ui.VasPagImageView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGImageView;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001!B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001e\u0010\u001fJ.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bJ,\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ\b\u0010\u0010\u001a\u00020\nH\u0014R\u0016\u0010\u0013\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0017\u00a8\u0006\""}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/AdeliePagView;", "Landroid/widget/FrameLayout;", "Landroid/content/res/AssetManager;", "assets", "", "pagFileName", "", "repeatCount", "Lorg/libpag/PAGImageView$PAGImageViewListener;", "listener", "", "e", "setPagListener", "", "enablePlay", "f", NodeProps.ON_DETACHED_FROM_WINDOW, "d", "Z", "mEnablePlay", "Lorg/libpag/PAGImageView$PAGImageViewListener;", "mListener", "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "vasPagView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", tl.h.F, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdeliePagView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mEnablePlay;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PAGImageView.PAGImageViewListener mListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private VasPagImageView vasPagView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdeliePagView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void e(final AssetManager assets, final String pagFileName, final int repeatCount, PAGImageView.PAGImageViewListener listener) {
        setPagListener(listener);
        this.vasPagView.api().postAction(new Function1<PAGImageView, Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.view.AdeliePagView$doPlay$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGImageView pAGImageView) {
                invoke2(pAGImageView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PAGImageView pagView) {
                boolean z16;
                Intrinsics.checkNotNullParameter(pagView, "pagView");
                pagView.setComposition(PagViewMonitor.Load(assets, pagFileName));
                pagView.setScaleMode(3);
                pagView.setRepeatCount(repeatCount);
                z16 = this.mEnablePlay;
                if (z16) {
                    pagView.play();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(AdeliePagView this$0, AssetManager assets, String pagFileName, PAGImageView.PAGImageViewListener pAGImageViewListener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(assets, "$assets");
        Intrinsics.checkNotNullParameter(pagFileName, "$pagFileName");
        this$0.e(assets, pagFileName, 0, pAGImageViewListener);
    }

    public final void f(@NotNull final AssetManager assets, @NotNull final String pagFileName, boolean enablePlay, @Nullable final PAGImageView.PAGImageViewListener listener) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(pagFileName, "pagFileName");
        boolean z16 = true;
        QLog.i("TroopPagImageView", 1, "play pagFileName:" + pagFileName);
        if (pagFileName.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.mEnablePlay = enablePlay;
        if (!TextUtils.isEmpty(pagFileName)) {
            ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.robot.adelie.homepage.ugc.view.j
                @Override // java.lang.Runnable
                public final void run() {
                    AdeliePagView.g(AdeliePagView.this, assets, pagFileName, listener);
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void setPagListener(@Nullable final PAGImageView.PAGImageViewListener listener) {
        this.vasPagView.api().postAction(new Function1<PAGImageView, Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.view.AdeliePagView$setPagListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGImageView pAGImageView) {
                invoke2(pAGImageView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PAGImageView pagView) {
                PAGImageView.PAGImageViewListener pAGImageViewListener;
                PAGImageView.PAGImageViewListener pAGImageViewListener2;
                Intrinsics.checkNotNullParameter(pagView, "pagView");
                pAGImageViewListener = AdeliePagView.this.mListener;
                if (pAGImageViewListener != null) {
                    pAGImageViewListener2 = AdeliePagView.this.mListener;
                    pagView.removeListener(pAGImageViewListener2);
                }
                AdeliePagView.this.mListener = listener;
                PAGImageView.PAGImageViewListener pAGImageViewListener3 = listener;
                if (pAGImageViewListener3 != null) {
                    pagView.addListener(pAGImageViewListener3);
                }
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdeliePagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AdeliePagView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdeliePagView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mEnablePlay = true;
        View findViewById = LayoutInflater.from(context).inflate(R.layout.drq, (ViewGroup) this, true).findViewById(R.id.f116426yp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.vas_pag_view)");
        VasPagImageView vasPagImageView = (VasPagImageView) findViewById;
        this.vasPagView = vasPagImageView;
        vasPagImageView.api().build();
    }
}

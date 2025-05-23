package com.tencent.mobileqq.vas.gift;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.api.ITroopGiftApi;
import com.tencent.mobileqq.vas.gift.TroopGiftPagView;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.ttpic.videoshelf.data.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\u0006\u00101\u001a\u000200\u00a2\u0006\u0004\b2\u00103B\u0011\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b2\u00104B\u001b\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u00a2\u0006\u0004\b2\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0016\u0010!\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010 R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/vas/gift/TroopGiftPagView;", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "Lorg/libpag/PAGView;", "pagView", "", "v", "Lorg/libpag/PAGFile;", "pagFile", "", "isHeadPag", HippyTKDListViewAdapter.X, ReportConstant.COSTREPORT_PREFIX, "Landroid/graphics/Bitmap;", "mSendIconBm", "setSendBitmap", "mRecIconBm", "setRecBitmap", "", Constants.PAG_FILE_PATH, "setJumpFile", "isBirth", "setBirthType", "Lcom/tencent/mobileqq/vas/gift/c;", "listener", "setPlayEndListener", "w", "t", "u", "d", "Landroid/graphics/Bitmap;", "e", "f", "Z", "pagHeadJumpEnd", tl.h.F, "Ljava/lang/String;", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/vas/gift/c;", BdhLogUtil.LogTag.Tag_Conn, "Lorg/libpag/PAGFile;", "headPagFile", "D", "jumpPagFile", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class TroopGiftPagView extends VasPagView {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private PAGFile headPagFile;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private PAGFile jumpPagFile;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap mSendIconBm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap mRecIconBm;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean pagHeadJumpEnd;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pagFilePath;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isBirth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopGiftPagView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pagFilePath = "";
        api().build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        boolean z16;
        PAGFile Load;
        if (this.headPagFile == null) {
            if (this.isBirth) {
                Load = PagViewMonitor.Load(ITroopGiftApi.INSTANCE.getPAG_FILE_SAVE_PATH_FOR_BIRTH());
            } else {
                Load = PagViewMonitor.Load(ITroopGiftApi.INSTANCE.getPAG_FILE_SAVE_PATH());
            }
            this.headPagFile = Load;
        }
        if (this.pagFilePath.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.jumpPagFile == null) {
            this.jumpPagFile = PagViewMonitor.Load(this.pagFilePath);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(PAGView pagView) {
        if (this.pagHeadJumpEnd) {
            pagView.setRepeatCount(3);
            pagView.setComposition(this.headPagFile);
        } else {
            pagView.setRepeatCount(1);
            pagView.setComposition(this.jumpPagFile);
        }
        pagView.setProgress(0.0d);
        pagView.addListener(new a(pagView));
        if (!TroopGiftView.INSTANCE.a() && !pagView.isPlaying()) {
            pagView.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(PAGFile pagFile, boolean isHeadPag) {
        if (pagFile != null && pagFile.numImages() >= 2) {
            Bitmap bitmap = this.mSendIconBm;
            if (bitmap != null) {
                pagFile.replaceImage(!isHeadPag ? 1 : 0, PAGImage.FromBitmap(bitmap));
            }
            Bitmap bitmap2 = this.mRecIconBm;
            if (bitmap2 != null) {
                pagFile.replaceImage(isHeadPag ? 1 : 0, PAGImage.FromBitmap(bitmap2));
            }
        }
    }

    public final void setBirthType(boolean isBirth) {
        this.isBirth = isBirth;
    }

    public final void setJumpFile(@NotNull String pagFilePath) {
        Intrinsics.checkNotNullParameter(pagFilePath, "pagFilePath");
        this.pagFilePath = pagFilePath;
    }

    public final void setPlayEndListener(@NotNull c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void setRecBitmap(@Nullable Bitmap mRecIconBm) {
        this.mRecIconBm = mRecIconBm;
    }

    public final void setSendBitmap(@Nullable Bitmap mSendIconBm) {
        this.mSendIconBm = mSendIconBm;
    }

    public final void t() {
        api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.mobileqq.vas.gift.TroopGiftPagView$pausePag$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                invoke2(pAGView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PAGView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.isPlaying() && TroopGiftView.INSTANCE.a()) {
                    it.stop();
                }
            }
        });
    }

    public final void u() {
        api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.mobileqq.vas.gift.TroopGiftPagView$playPag$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                invoke2(pAGView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PAGView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.isPlaying() || TroopGiftView.INSTANCE.a()) {
                    return;
                }
                if ((!TroopGiftPagView.this.pagHeadJumpEnd || it.getProgress() >= 1.0d) && TroopGiftPagView.this.pagHeadJumpEnd) {
                    return;
                }
                it.play();
            }
        });
    }

    public final void w() {
        setVisibility(0);
        api().postAction(new TroopGiftPagView$show$1(this));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopGiftPagView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pagFilePath = "";
        api().build();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopGiftPagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pagFilePath = "";
        api().build();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/vas/gift/TroopGiftPagView$a", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements PAGView.PAGViewListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PAGView f309277e;

        a(PAGView pAGView) {
            this.f309277e = pAGView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(TroopGiftPagView this$0, PAGView pagView) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(pagView, "$pagView");
            this$0.v(pagView);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(@Nullable PAGView p06) {
            if (!TroopGiftPagView.this.pagHeadJumpEnd) {
                TroopGiftPagView.this.pagHeadJumpEnd = true;
                final TroopGiftPagView troopGiftPagView = TroopGiftPagView.this;
                final PAGView pAGView = this.f309277e;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.gift.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopGiftPagView.a.c(TroopGiftPagView.this, pAGView);
                    }
                }, 16, null, true);
                c cVar = TroopGiftPagView.this.listener;
                if (cVar != null) {
                    cVar.a();
                }
                TroopGiftPagView.this.listener = null;
            }
            if (p06 != null) {
                p06.removeListener(this);
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(@Nullable PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(@Nullable PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(@Nullable PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(@Nullable PAGView p06) {
        }
    }
}

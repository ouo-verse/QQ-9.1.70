package com.tencent.guild.api.gift;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.ui.PagViewProxy;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.data.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b,\u0010.B\u001b\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u00a2\u0006\u0004\b,\u0010/J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u00060"}, d2 = {"Lcom/tencent/guild/api/gift/GuildGiftHeadPagView;", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "Lorg/libpag/PAGFile;", "pagFile", "", "v", "Lorg/libpag/PAGView;", "pagView", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Landroid/graphics/Bitmap;", "mSendIconBm", "setSendIconBm", "mRecIconBm", "setRecIconBm", "", Constants.PAG_FILE_PATH, "setJumpFile", "Lcom/tencent/guild/api/gift/k;", "listener", "setPlayEndListener", "t", "u", "r", ReportConstant.COSTREPORT_PREFIX, "d", "Landroid/graphics/Bitmap;", "e", "f", "Z", "pagHeadJumpEnd", tl.h.F, "hasLoad", "i", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/guild/api/gift/k;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildGiftHeadPagView extends VasPagView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap mSendIconBm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap mRecIconBm;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean pagHeadJumpEnd;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasLoad;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pagFilePath;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private k listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGiftHeadPagView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pagFilePath = "";
        api().build();
    }

    private final PAGFile p() {
        boolean z16;
        if (this.pagHeadJumpEnd) {
            return PagViewMonitor.Load(GiftResourceLoader.f112513a.b());
        }
        if (this.pagFilePath.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        return PagViewMonitor.Load(this.pagFilePath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean q(PAGView pagView) {
        PAGFile p16 = p();
        if (p16 == null) {
            return false;
        }
        if (this.pagHeadJumpEnd) {
            pagView.setRepeatCount(3);
        } else {
            pagView.setRepeatCount(1);
        }
        v(p16);
        pagView.setComposition(p16);
        pagView.addListener(new a(pagView));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(PAGFile pagFile) {
        boolean z16 = false;
        if (pagFile != null && pagFile.numImages() == 2) {
            z16 = true;
        }
        if (z16) {
            Bitmap bitmap = this.mSendIconBm;
            if (bitmap != null) {
                pagFile.replaceImage(1 ^ (this.pagHeadJumpEnd ? 1 : 0), PAGImage.FromBitmap(bitmap));
            }
            Bitmap bitmap2 = this.mRecIconBm;
            if (bitmap2 != null) {
                pagFile.replaceImage(this.pagHeadJumpEnd ? 1 : 0, PAGImage.FromBitmap(bitmap2));
            }
        }
    }

    public final void r() {
        api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.guild.api.gift.GuildGiftHeadPagView$pausePag$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                invoke2(pAGView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PAGView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.isPlaying() && GuildGiftView.INSTANCE.b()) {
                    it.stop();
                }
            }
        });
    }

    public final void s() {
        api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.guild.api.gift.GuildGiftHeadPagView$playPag$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                invoke2(pAGView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PAGView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.isPlaying() || GuildGiftView.INSTANCE.b() || it.getProgress() >= 1.0d) {
                    return;
                }
                it.play();
            }
        });
    }

    public final void setJumpFile(@NotNull String pagFilePath) {
        Intrinsics.checkNotNullParameter(pagFilePath, "pagFilePath");
        this.pagFilePath = pagFilePath;
    }

    public final void setPlayEndListener(@NotNull k listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void setRecIconBm(@Nullable Bitmap mRecIconBm) {
        this.mRecIconBm = mRecIconBm;
    }

    public final void setSendIconBm(@Nullable Bitmap mSendIconBm) {
        this.mSendIconBm = mSendIconBm;
    }

    public final void t() {
        setVisibility(0);
        api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.guild.api.gift.GuildGiftHeadPagView$show$1
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
            public final void invoke2(@NotNull PAGView pagView) {
                boolean q16;
                boolean z16;
                boolean z17;
                Intrinsics.checkNotNullParameter(pagView, "pagView");
                GuildGiftHeadPagView guildGiftHeadPagView = GuildGiftHeadPagView.this;
                q16 = guildGiftHeadPagView.q(pagView);
                guildGiftHeadPagView.hasLoad = q16;
                z16 = GuildGiftHeadPagView.this.hasLoad;
                if (!z16 || GuildGiftView.INSTANCE.b() || pagView.isPlaying()) {
                    z17 = GuildGiftHeadPagView.this.hasLoad;
                    if (z17) {
                        return;
                    }
                    QLog.e(PagViewProxy.INSTANCE.getTAG(), 1, "GuildGiftHeadPagView pag loader fail");
                    return;
                }
                pagView.play();
            }
        });
    }

    public final void u() {
        api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.guild.api.gift.GuildGiftHeadPagView$updateAvatar$1
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
                boolean z16;
                Intrinsics.checkNotNullParameter(it, "it");
                z16 = GuildGiftHeadPagView.this.hasLoad;
                if (z16) {
                    GuildGiftHeadPagView guildGiftHeadPagView = GuildGiftHeadPagView.this;
                    PAGComposition composition = it.getComposition();
                    guildGiftHeadPagView.v(composition instanceof PAGFile ? (PAGFile) composition : null);
                    it.flush();
                }
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGiftHeadPagView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pagFilePath = "";
        api().build();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGiftHeadPagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pagFilePath = "";
        api().build();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/guild/api/gift/GuildGiftHeadPagView$a", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements PAGView.PAGViewListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PAGView f112525e;

        a(PAGView pAGView) {
            this.f112525e = pAGView;
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(@Nullable PAGView p06) {
            if (!GuildGiftHeadPagView.this.pagHeadJumpEnd) {
                GuildGiftHeadPagView.this.pagHeadJumpEnd = true;
                GuildGiftHeadPagView.this.t();
                k kVar = GuildGiftHeadPagView.this.listener;
                if (kVar != null) {
                    kVar.a();
                }
                GuildGiftHeadPagView.this.listener = null;
            }
            this.f112525e.removeListener(this);
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

package com.tencent.mobileqq.wink.editor.template;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateTextListMenuPart;
import com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateTextListMenuPart$playerListener$2;
import com.tencent.mobileqq.wink.editor.template.o;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 .2\u00020\u0001:\u0001GB\u0007\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0014J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0002H\u0014J\b\u0010\u0014\u001a\u00020\u0002H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0006\u0010\u0017\u001a\u00020\u0002R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010 \u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u001d\u0010#\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001cR\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00103\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010.R\u001b\u00107\u001a\u00020\u000b8TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010\u001a\u001a\u0004\b5\u00106R\u001b\u0010:\u001a\u00020\u000b8TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u0010\u001a\u001a\u0004\b9\u00106R\u001b\u0010?\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010\u001a\u001a\u0004\b=\u0010>R\u001b\u0010D\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010\u001a\u001a\u0004\bB\u0010C\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateTextListMenuPart;", "Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "", "Xa", "Ua", "initView", "Wa", "Ha", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "oa", "", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initAfterInflation", "Landroid/os/Bundle;", "args", "L9", "ma", "onDismiss", "", "onBackEvent", "Ia", "Landroid/widget/ImageView;", "M", "Lkotlin/Lazy;", "Ma", "()Landroid/widget/ImageView;", "playerToggleBtn", "N", "Ja", "cancelBtn", "P", "Ka", "confirmBtn", "Landroidx/recyclerview/widget/RecyclerView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Pa", "()Landroidx/recyclerview/widget/RecyclerView;", "textRecyclerView", "Lcom/tencent/mobileqq/wink/editor/template/o;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/wink/editor/template/o;", "textListAdapter", ExifInterface.LATITUDE_SOUTH, "Z", "switchToTemplateTextPart", "T", "needConfirmExit", "U", "backToTemplateMenuPart", "V", "Na", "()I", "slideUpPlayerBottomOffset", "W", "Oa", "slideUpPlayerTopOffset", "Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateTextListViewModel;", "X", "Qa", "()Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateTextListViewModel;", "viewModel", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "Y", "La", "()Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "playerListener", "<init>", "()V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkEditorTemplateTextListMenuPart extends WinkEditorMenuPart {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy playerToggleBtn;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy cancelBtn;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy confirmBtn;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy textRecyclerView;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private o textListAdapter;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean switchToTemplateTextPart;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean needConfirmExit;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean backToTemplateMenuPart;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy slideUpPlayerBottomOffset;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Lazy slideUpPlayerTopOffset;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy playerListener;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/template/WinkEditorTemplateTextListMenuPart$b", "Lcom/tencent/mobileqq/wink/editor/template/o$a;", "", "position", "Lcom/tencent/mobileqq/wink/editor/template/d;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements o.a {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.editor.template.o.a
        public void a(int position, @NotNull d item) {
            Intrinsics.checkNotNullParameter(item, "item");
            WinkEditorTemplateTextListMenuPart.this.Qa().T1(item);
            WinkEditorTemplateTextListMenuPart.this.broadcastMessage("ARGS_SWITCH_STICKER_IN_TEMPLATE_TEXT_LIST_SETTING", item.getStickerUid());
        }

        @Override // com.tencent.mobileqq.wink.editor.template.o.a
        public void b(int position, @NotNull d item) {
            Intrinsics.checkNotNullParameter(item, "item");
            WinkEditorTemplateTextListMenuPart.this.switchToTemplateTextPart = true;
            WinkEditorTemplateTextListMenuPart.this.needConfirmExit = true;
            WinkEditorTemplateTextListMenuPart.this.Qa().W1(item);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/editor/template/WinkEditorTemplateTextListMenuPart$c", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.LongRef f322275e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f322276f;

        c(Ref.LongRef longRef, d dVar) {
            this.f322275e = longRef;
            this.f322276f = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkEditorTemplateTextListMenuPart this$0, d it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "$it");
            this$0.broadcastMessage("ARGS_SWITCH_STICKER_IN_TEMPLATE_TEXT_LIST_SETTING", it.getStickerUid());
            this$0.textListAdapter.q0(it.getStickerUid());
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            View partRootView = WinkEditorTemplateTextListMenuPart.this.getPartRootView();
            if (partRootView != null && (viewTreeObserver = partRootView.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            View partRootView2 = WinkEditorTemplateTextListMenuPart.this.getPartRootView();
            if (partRootView2 != null) {
                final WinkEditorTemplateTextListMenuPart winkEditorTemplateTextListMenuPart = WinkEditorTemplateTextListMenuPart.this;
                final d dVar = this.f322276f;
                partRootView2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorTemplateTextListMenuPart.c.b(WinkEditorTemplateTextListMenuPart.this, dVar);
                    }
                }, this.f322275e.element);
            }
        }
    }

    public WinkEditorTemplateTextListMenuPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateTextListMenuPart$playerToggleBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ImageView invoke() {
                View partRootView = WinkEditorTemplateTextListMenuPart.this.getPartRootView();
                if (partRootView != null) {
                    return (ImageView) partRootView.findViewById(R.id.f25970c_);
                }
                return null;
            }
        });
        this.playerToggleBtn = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateTextListMenuPart$cancelBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ImageView invoke() {
                View partRootView = WinkEditorTemplateTextListMenuPart.this.getPartRootView();
                if (partRootView != null) {
                    return (ImageView) partRootView.findViewById(R.id.aou);
                }
                return null;
            }
        });
        this.cancelBtn = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateTextListMenuPart$confirmBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ImageView invoke() {
                View partRootView = WinkEditorTemplateTextListMenuPart.this.getPartRootView();
                if (partRootView != null) {
                    return (ImageView) partRootView.findViewById(R.id.b7p);
                }
                return null;
            }
        });
        this.confirmBtn = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateTextListMenuPart$textRecyclerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                View partRootView = WinkEditorTemplateTextListMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (RecyclerView) partRootView.findViewById(R.id.f93995b3);
            }
        });
        this.textRecyclerView = lazy4;
        this.textListAdapter = new o();
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateTextListMenuPart$slideUpPlayerBottomOffset$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(WinkEditorTemplateTextListMenuPart.this.getContext().getResources().getDimensionPixelSize(R.dimen.djx));
            }
        });
        this.slideUpPlayerBottomOffset = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateTextListMenuPart$slideUpPlayerTopOffset$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ImmersiveUtils.dpToPx(0.0f));
            }
        });
        this.slideUpPlayerTopOffset = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<WinkEditorTemplateTextListViewModel>() { // from class: com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateTextListMenuPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkEditorTemplateTextListViewModel invoke() {
                return (WinkEditorTemplateTextListViewModel) WinkEditorTemplateTextListMenuPart.this.getViewModel(WinkEditorTemplateTextListViewModel.class);
            }
        });
        this.viewModel = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<WinkEditorTemplateTextListMenuPart$playerListener$2.a>() { // from class: com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateTextListMenuPart$playerListener$2

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/template/WinkEditorTemplateTextListMenuPart$playerListener$2$a", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "status", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "iPlayer", "", "onStatusChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes21.dex */
            public static final class a implements IPlayer.PlayerListener {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ WinkEditorTemplateTextListMenuPart f322277a;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* renamed from: com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateTextListMenuPart$playerListener$2$a$a, reason: collision with other inner class name */
                /* loaded from: classes21.dex */
                public /* synthetic */ class C9041a {

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f322278a;

                    static {
                        int[] iArr = new int[IPlayer.PlayerStatus.values().length];
                        try {
                            iArr[IPlayer.PlayerStatus.PLAYING.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[IPlayer.PlayerStatus.REPLAY.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[IPlayer.PlayerStatus.PAUSED.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        f322278a = iArr;
                    }
                }

                a(WinkEditorTemplateTextListMenuPart winkEditorTemplateTextListMenuPart) {
                    this.f322277a = winkEditorTemplateTextListMenuPart;
                }

                @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
                public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
                    IPlayer.PlayerListener.DefaultImpls.onPlayerSourceReady(this, iPlayer);
                }

                @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
                public void onPositionChanged(long j3, long j16) {
                    IPlayer.PlayerListener.DefaultImpls.onPositionChanged(this, j3, j16);
                }

                /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
                
                    r2 = r1.f322277a.Ma();
                 */
                @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onStatusChanged(@Nullable IPlayer.PlayerStatus status, @NotNull IPlayer iPlayer) {
                    int i3;
                    ImageView Ma;
                    ImageView Ma2;
                    Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
                    if (status == null) {
                        i3 = -1;
                    } else {
                        i3 = C9041a.f322278a[status.ordinal()];
                    }
                    if (i3 == 1 || i3 == 2) {
                        Ma = this.f322277a.Ma();
                        if (Ma != null) {
                            Ma.setImageResource(R.drawable.oqq);
                            return;
                        }
                        return;
                    }
                    if (i3 == 3 && Ma2 != null) {
                        Ma2.setImageResource(R.drawable.oqs);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(WinkEditorTemplateTextListMenuPart.this);
            }
        });
        this.playerListener = lazy8;
    }

    private final void Ha() {
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
        com.tencent.mobileqq.wink.report.e.f(eVar, Pa(), WinkDaTongReportConstant.ElementId.EM_XSJ_BATCH_EDIT_PANEL, params, null, 8, null);
        com.tencent.mobileqq.wink.report.e.d(eVar, Pa(), WinkDaTongReportConstant.ElementId.EM_XSJ_BATCH_EDIT_PANEL, params, null, 8, null);
    }

    private final ImageView Ja() {
        return (ImageView) this.cancelBtn.getValue();
    }

    private final ImageView Ka() {
        return (ImageView) this.confirmBtn.getValue();
    }

    private final IPlayer.PlayerListener La() {
        return (IPlayer.PlayerListener) this.playerListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView Ma() {
        return (ImageView) this.playerToggleBtn.getValue();
    }

    private final RecyclerView Pa() {
        Object value = this.textRecyclerView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-textRecyclerView>(...)");
        return (RecyclerView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkEditorTemplateTextListViewModel Qa() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (WinkEditorTemplateTextListViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ra(WinkEditorTemplateTextListMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr H9 = this$0.H9();
        if (H9 != null) {
            if (H9.isPlaying()) {
                H9.pause();
            } else {
                this$0.textListAdapter.p0(-1);
                this$0.broadcastMessage("ARGS_SWITCH_STICKER_IN_TEMPLATE_TEXT_LIST_SETTING", null);
                H9.play();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sa(WinkEditorTemplateTextListMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.switchToTemplateTextPart = false;
        if (this$0.needConfirmExit) {
            this$0.Xa();
        } else {
            this$0.Ia();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ta(WinkEditorTemplateTextListMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.switchToTemplateTextPart = false;
        this$0.Wa();
        this$0.Ia();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Ua() {
        Qa().M1().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.template.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTemplateTextListMenuPart.Va(WinkEditorTemplateTextListMenuPart.this, (WinkStickerModel) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Va(WinkEditorTemplateTextListMenuPart this$0, WinkStickerModel winkStickerModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (winkStickerModel == null) {
            this$0.textListAdapter.p0(-1);
            return;
        }
        this$0.textListAdapter.q0(winkStickerModel.id);
        dr H9 = this$0.H9();
        if (H9 != null) {
            H9.pause();
        }
    }

    private final void Wa() {
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        ImageView Ka = Ka();
        if (Ka != null) {
            com.tencent.mobileqq.wink.report.e.k(com.tencent.mobileqq.wink.report.e.f326265a, Ka, WinkDaTongReportConstant.ElementId.EM_XSJ_BATCH_EDIT_PANEL_FINISH_BUTTON, params, null, 8, null);
        }
    }

    private final void Xa() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230);
        createCustomDialog.setTitle(R.string.f241037qs);
        createCustomDialog.setPositiveButton(R.string.a8j, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.template.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorTemplateTextListMenuPart.Ya(WinkEditorTemplateTextListMenuPart.this, dialogInterface, i3);
            }
        });
        createCustomDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.template.u
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorTemplateTextListMenuPart.Za(dialogInterface, i3);
            }
        });
        createCustomDialog.getTitleTextView().setSingleLine(false);
        createCustomDialog.getTitleTextView().setGravity(8388627);
        try {
            if (!createCustomDialog.isShowing()) {
                createCustomDialog.show();
            }
        } catch (Throwable th5) {
            w53.b.c(this.TAG, th5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ya(WinkEditorTemplateTextListMenuPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Qa().S1();
        this$0.Ia();
    }

    private final void initView() {
        ImageView Ma = Ma();
        if (Ma != null) {
            Ma.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.template.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorTemplateTextListMenuPart.Ra(WinkEditorTemplateTextListMenuPart.this, view);
                }
            });
        }
        Pa().setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        Pa().setAdapter(this.textListAdapter);
        this.textListAdapter.r0(new b());
        ImageView Ja = Ja();
        if (Ja != null) {
            Ja.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.template.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorTemplateTextListMenuPart.Sa(WinkEditorTemplateTextListMenuPart.this, view);
                }
            });
        }
        ImageView Ka = Ka();
        if (Ka != null) {
            Ka.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.template.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorTemplateTextListMenuPart.Ta(WinkEditorTemplateTextListMenuPart.this, view);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.f93925aw;
    }

    public final void Ia() {
        if (this.backToTemplateMenuPart) {
            WinkEditorViewModel.v5(G9(), MenuType.VIDEO_TEMPLATE, null, 2, null);
        } else {
            super.x9();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        Unit unit;
        d dVar;
        ViewTreeObserver viewTreeObserver;
        String string;
        super.L9(args);
        Ha();
        Ua();
        dr H9 = H9();
        if (H9 != null) {
            H9.addPlayerListener(La());
        }
        WinkEditorTemplateTextListViewModel Qa = Qa();
        dr H92 = H9();
        Intrinsics.checkNotNull(H92);
        Qa.Q1(H92);
        Ref.LongRef longRef = new Ref.LongRef();
        Unit unit2 = null;
        if (this.switchToTemplateTextPart) {
            this.switchToTemplateTextPart = false;
        } else {
            longRef.element = 300L;
            ra(Na(), Oa());
            Qa().L1();
            if (args != null) {
                this.backToTemplateMenuPart = args.getBoolean("back_to_template_menu_part");
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                this.backToTemplateMenuPart = false;
            }
        }
        this.textListAdapter.setItems(Qa().O1());
        if (args != null && (string = args.getString("selected_sticker_uid")) != null) {
            d l06 = this.textListAdapter.l0(string);
            unit2 = Unit.INSTANCE;
            dVar = l06;
        } else {
            dVar = null;
        }
        if (unit2 == null) {
            dVar = this.textListAdapter.k0(0);
        }
        if (dVar != null) {
            Qa().T1(dVar);
            View partRootView = getPartRootView();
            if (partRootView != null && (viewTreeObserver = partRootView.getViewTreeObserver()) != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new c(longRef, dVar));
            }
        }
        com.tencent.mobileqq.wink.report.e.f326265a.y();
    }

    protected int Na() {
        return ((Number) this.slideUpPlayerBottomOffset.getValue()).intValue();
    }

    protected int Oa() {
        return ((Number) this.slideUpPlayerTopOffset.getValue()).intValue();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.TEMPLATE_TEXT_LIST;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void ma() {
        if (!this.switchToTemplateTextPart) {
            qa();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (this.visible) {
            ImageView Ja = Ja();
            if (Ja != null) {
                Ja.performClick();
            }
            return true;
        }
        return super.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void onDismiss() {
        com.tencent.mobileqq.wink.report.e.f326265a.y();
        super.onDismiss();
        dr H9 = H9();
        if (H9 != null) {
            H9.removePlayerListener(La());
        }
        Qa().P1();
        if (!this.switchToTemplateTextPart) {
            dr H92 = H9();
            if (H92 != null) {
                H92.play();
            }
            this.needConfirmExit = false;
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Za(DialogInterface dialogInterface, int i3) {
    }
}

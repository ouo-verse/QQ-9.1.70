package com.tencent.mobileqq.nearbypro.avatar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.service.ImageService;
import com.tencent.state.square.avatar.AvatarAnimConfig;
import com.tencent.state.square.avatar.ISquareAvatarView;
import com.tencent.state.square.avatar.filament.SquareAvatarFilamentView;
import com.tencent.state.square.data.FilamentAvatarCoverUri;
import com.tencent.state.square.data.MapResourceType;
import com.tencent.state.square.data.RecordSource;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareItemKt;
import com.tencent.state.square.detail.DetailAvatarAnimator;
import com.tencent.state.square.detail.DetailAvatarConfig;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.square.media.PlayConfig;
import com.tencent.state.square.media.SquarePlayerPool;
import com.tencent.state.square.record.RecordType;
import com.tencent.state.square.resource.FilamentCoverRecordHelper;
import com.tencent.state.square.resource.FilamentCoverRecorder;
import com.tencent.state.utils.SquareSwitchUtils;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001@B\u0011\b\u0016\u0012\u0006\u00107\u001a\u000206\u00a2\u0006\u0004\b8\u00109B\u0019\b\u0016\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b8\u0010<B!\b\u0016\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u0010=\u001a\u00020\f\u00a2\u0006\u0004\b8\u0010>J8\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J0\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0014JN\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J.\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00070\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u0004R\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010'R\u0014\u0010*\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010)R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b\u001d\u0010.R\u0017\u00105\u001a\u0002008\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/avatar/NearbyAvatarView;", "Landroid/widget/RelativeLayout;", "", "tinyId", "", "isChangeResource", "Lkotlin/Function0;", "", "onImageLoaded", "onAnimationLoaded", "i", "isMe", "", "actionId", "isRemoteCoverExist", "isRemoteCoverCorrect", "isLocalCacheExist", h.F, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/nearbypro/avatar/b;", "data", "tapClickListener", "e", "Lcom/tencent/state/square/data/Resource;", "resource", "Lkotlin/Function1;", "callback", "needCleanAll", "j", "d", "Z", "isFilamentOn", "Lxa2/c;", "Lxa2/c;", "binding", "f", "Lcom/tencent/mobileqq/nearbypro/avatar/b;", "avatarData", "Lcom/tencent/state/square/avatar/ISquareAvatarView;", "Lcom/tencent/state/square/avatar/ISquareAvatarView;", "avatarView", "I", "defaultAvatarResId", "Lcom/tencent/state/square/detail/DetailAvatarAnimator;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "()Lcom/tencent/state/square/detail/DetailAvatarAnimator;", "animator", "Lcom/tencent/state/square/resource/FilamentCoverRecorder;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/state/square/resource/FilamentCoverRecorder;", "getRecorder", "()Lcom/tencent/state/square/resource/FilamentCoverRecorder;", "recorder", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyAvatarView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final FilamentCoverRecorder recorder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isFilamentOn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final xa2.c binding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AvatarData avatarData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ISquareAvatarView avatarView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int defaultAvatarResId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy animator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/nearbypro/avatar/NearbyAvatarView$b", "Lcom/tencent/state/square/resource/FilamentCoverRecorder$IRecordCallback;", "", "type", "Lcom/tencent/state/square/resource/FilamentCoverRecorder$RecordRequest;", Const.BUNDLE_KEY_REQUEST, "errorCode", "", "onRecordError", "Lcom/tencent/state/square/data/RecordSource;", "cover", "onRecordSuccess", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements FilamentCoverRecorder.IRecordCallback {
        b() {
        }

        @Override // com.tencent.state.square.resource.FilamentCoverRecorder.IRecordCallback
        public void onRecordError(int type, @NotNull FilamentCoverRecorder.RecordRequest request, int errorCode) {
            Intrinsics.checkNotNullParameter(request, "request");
        }

        @Override // com.tencent.state.square.resource.FilamentCoverRecorder.IRecordCallback
        public void onRecordSuccess(@NotNull FilamentCoverRecorder.RecordRequest request, @NotNull RecordSource cover) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(cover, "cover");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NearbyAvatarView(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        boolean enableFilamentDetail = SquareSwitchUtils.INSTANCE.enableFilamentDetail();
        this.isFilamentOn = enableFilamentDetail;
        xa2.c f16 = xa2.c.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        a aVar = a.f253200a;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        ISquareAvatarView a16 = aVar.a(enableFilamentDetail, context2);
        this.avatarView = a16;
        AvatarData avatarData = this.avatarData;
        int i3 = 1;
        this.defaultAvatarResId = (avatarData != null && avatarData.getMale()) != false ? R.drawable.n2x : R.drawable.n2w;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DetailAvatarAnimator>() { // from class: com.tencent.mobileqq.nearbypro.avatar.NearbyAvatarView$animator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DetailAvatarAnimator invoke() {
                xa2.c cVar;
                ISquareAvatarView iSquareAvatarView;
                cVar = NearbyAvatarView.this.binding;
                RelativeLayout relativeLayout = cVar.f447574b;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarImage");
                iSquareAvatarView = NearbyAvatarView.this.avatarView;
                DetailAvatarAnimator detailAvatarAnimator = new DetailAvatarAnimator(relativeLayout, iSquareAvatarView, NearbyAvatarView.this.getWidth(), NearbyAvatarView.this.getHeight(), DetailAvatarConfig.INSTANCE.defaultDetailConfig());
                detailAvatarAnimator.setScaleDuration(0L);
                return detailAvatarAnimator;
            }
        });
        this.animator = lazy;
        this.recorder = new FilamentCoverRecorder();
        a16.setConfig(new AvatarAnimConfig(false, new SquarePlayerPool(0 == true ? 1 : 0, i3, 0 == true ? 1 : 0), new PlayConfig(-1, true, null, 4, null), true));
        f16.f447575c.addView(a16 instanceof View ? (View) a16 : null);
        if (a16 instanceof SquareAvatarFilamentView) {
            ((SquareAvatarFilamentView) a16).setActionHelper(NearbyProAvatarActionHelper.f253199a);
        }
        ImageService.Companion companion = ImageService.INSTANCE;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        companion.initImageLoader(context3);
    }

    private final DetailAvatarAnimator d() {
        return (DetailAvatarAnimator) this.animator.getValue();
    }

    public static /* synthetic */ void f(NearbyAvatarView nearbyAvatarView, AvatarData avatarData, boolean z16, Function0 function0, Function0 function02, Function0 function03, int i3, Object obj) {
        Function0 function04;
        Function0 function05;
        Function0 function06;
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        boolean z17 = z16;
        if ((i3 & 4) != 0) {
            function04 = null;
        } else {
            function04 = function0;
        }
        if ((i3 & 8) != 0) {
            function05 = null;
        } else {
            function05 = function02;
        }
        if ((i3 & 16) != 0) {
            function06 = null;
        } else {
            function06 = function03;
        }
        nearbyAvatarView.e(avatarData, z17, function04, function05, function06);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(NearbyAvatarView this$0, AvatarData data, boolean z16, Function0 function0, final Function0 function02) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.i(data.getTid(), z16, function0, new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.avatar.NearbyAvatarView$initView$1$1
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
                Function0<Unit> function03 = function02;
                if (function03 != null) {
                    function03.invoke();
                }
                Log.e("NearbyAvatarView", "startEnterAnima: cb, ");
            }
        });
        this$0.binding.f447574b.setY((this$0.getHeight() - this$0.binding.f447574b.getHeight()) / 2.0f);
        this$0.binding.f447574b.setX((this$0.getWidth() - this$0.binding.f447574b.getWidth()) / 2.0f);
    }

    private final void h(boolean isMe, int actionId, boolean isRemoteCoverExist, boolean isRemoteCoverCorrect, boolean isLocalCacheExist) {
        int i3;
        int i16;
        Map mapOf;
        if (actionId <= 0) {
            return;
        }
        if (!isRemoteCoverExist) {
            i3 = 0;
        } else if (!isRemoteCoverCorrect) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        if (isRemoteCoverCorrect) {
            i16 = 1;
        } else if (isLocalCacheExist) {
            i16 = 2;
        } else {
            i16 = 0;
        }
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU"), TuplesKt.to("nearby_motion_id", Integer.valueOf(actionId)), TuplesKt.to("nearby_is_self", Boolean.valueOf(isMe)), TuplesKt.to("nearby_remote_cover_status", Integer.valueOf(i3)), TuplesKt.to("nearby_cover_display_mode", Integer.valueOf(i16)));
        VideoReport.reportEvent("ev_nearby_tech_cover_action_display", mapOf);
    }

    private final void i(String tinyId, boolean isChangeResource, Function0<Unit> onImageLoaded, final Function0<Unit> onAnimationLoaded) {
        MapPlayableSource mapPlayableSource;
        boolean z16;
        AvatarData avatarData = this.avatarData;
        if (avatarData == null) {
            return;
        }
        Resource resource = avatarData.getResource();
        if (this.isFilamentOn) {
            mapPlayableSource = SquareItemKt.toMapPlayableSource(resource, MapResourceType.Filament, avatarData.getTid(), Integer.valueOf(this.defaultAvatarResId));
        } else {
            mapPlayableSource = SquareItemKt.toMapPlayableSource(resource, Integer.valueOf(this.defaultAvatarResId));
        }
        d().enterScaleAnim(mapPlayableSource, isChangeResource, new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.avatar.NearbyAvatarView$startEnterAnima$1
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
                ISquareAvatarView iSquareAvatarView;
                iSquareAvatarView = NearbyAvatarView.this.avatarView;
                iSquareAvatarView.setImageViewVisibility(false);
                onAnimationLoaded.invoke();
            }
        });
        FilamentAvatarCoverUri filamentCoverUrl = resource.getFilamentCoverUrl();
        boolean z17 = false;
        if (filamentCoverUrl.getRemoteUrl().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isRemoteCorrect = filamentCoverUrl.isRemoteCorrect();
        if (isRemoteCorrect || filamentCoverUrl.isLocalCacheExists()) {
            z17 = !isRemoteCorrect;
            this.avatarView.setStaticSource(mapPlayableSource, true);
            if (onImageLoaded != null) {
                onImageLoaded.invoke();
            }
        }
        boolean areEqual = Intrinsics.areEqual(tinyId, String.valueOf(ab2.a.f25767a.m()));
        if (!filamentCoverUrl.isRemoteCorrect() && areEqual && resource.getActionId() > 0) {
            FilamentCoverRecordHelper.INSTANCE.checkAndRecord(this.recorder, tinyId + "_" + resource.getActionId(), tinyId, null, resource, true, RecordType.FILAMENT_NEARBY, new b());
        }
        h(areEqual, resource.getActionId(), z16, isRemoteCorrect, z17);
    }

    public final void e(@NotNull final AvatarData data, final boolean isChangeResource, @Nullable final Function0<Unit> onImageLoaded, @Nullable final Function0<Unit> onAnimationLoaded, @Nullable Function0<Unit> tapClickListener) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.avatarData = data;
        post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.avatar.g
            @Override // java.lang.Runnable
            public final void run() {
                NearbyAvatarView.g(NearbyAvatarView.this, data, isChangeResource, onImageLoaded, onAnimationLoaded);
            }
        });
        ISquareAvatarView iSquareAvatarView = this.avatarView;
        if (iSquareAvatarView instanceof SquareAvatarFilamentView) {
            ((SquareAvatarFilamentView) iSquareAvatarView).setTapClickListener(tapClickListener);
        }
    }

    public final void j(@NotNull Resource resource, @NotNull Function1<? super Boolean, Unit> callback, boolean needCleanAll) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AvatarData avatarData = this.avatarData;
        if (avatarData == null) {
            return;
        }
        if (this.isFilamentOn) {
            d().updateAvatarFilament(resource, avatarData.getTid(), callback, needCleanAll);
            MapPlayableSource mapPlayableSource = SquareItemKt.toMapPlayableSource(resource, MapResourceType.Filament, avatarData.getTid(), Integer.valueOf(this.defaultAvatarResId));
            FilamentAvatarCoverUri filamentCoverUrl = resource.getFilamentCoverUrl();
            if (filamentCoverUrl.isRemoteCorrect() || filamentCoverUrl.isLocalCacheExists()) {
                this.avatarView.setStaticSource(mapPlayableSource, true);
                return;
            }
            return;
        }
        d().updateAvatar(resource, callback);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ImageService.INSTANCE.destroy();
        this.recorder.onDestroy();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NearbyAvatarView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        boolean enableFilamentDetail = SquareSwitchUtils.INSTANCE.enableFilamentDetail();
        this.isFilamentOn = enableFilamentDetail;
        xa2.c f16 = xa2.c.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        a aVar = a.f253200a;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        ISquareAvatarView a16 = aVar.a(enableFilamentDetail, context2);
        this.avatarView = a16;
        AvatarData avatarData = this.avatarData;
        int i3 = 1;
        this.defaultAvatarResId = (avatarData != null && avatarData.getMale()) != false ? R.drawable.n2x : R.drawable.n2w;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DetailAvatarAnimator>() { // from class: com.tencent.mobileqq.nearbypro.avatar.NearbyAvatarView$animator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DetailAvatarAnimator invoke() {
                xa2.c cVar;
                ISquareAvatarView iSquareAvatarView;
                cVar = NearbyAvatarView.this.binding;
                RelativeLayout relativeLayout = cVar.f447574b;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarImage");
                iSquareAvatarView = NearbyAvatarView.this.avatarView;
                DetailAvatarAnimator detailAvatarAnimator = new DetailAvatarAnimator(relativeLayout, iSquareAvatarView, NearbyAvatarView.this.getWidth(), NearbyAvatarView.this.getHeight(), DetailAvatarConfig.INSTANCE.defaultDetailConfig());
                detailAvatarAnimator.setScaleDuration(0L);
                return detailAvatarAnimator;
            }
        });
        this.animator = lazy;
        this.recorder = new FilamentCoverRecorder();
        a16.setConfig(new AvatarAnimConfig(false, new SquarePlayerPool(0 == true ? 1 : 0, i3, 0 == true ? 1 : 0), new PlayConfig(-1, true, null, 4, null), true));
        f16.f447575c.addView(a16 instanceof View ? (View) a16 : null);
        if (a16 instanceof SquareAvatarFilamentView) {
            ((SquareAvatarFilamentView) a16).setActionHelper(NearbyProAvatarActionHelper.f253199a);
        }
        ImageService.Companion companion = ImageService.INSTANCE;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        companion.initImageLoader(context3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NearbyAvatarView(@NotNull Context context, @NotNull AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        boolean enableFilamentDetail = SquareSwitchUtils.INSTANCE.enableFilamentDetail();
        this.isFilamentOn = enableFilamentDetail;
        xa2.c f16 = xa2.c.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        a aVar = a.f253200a;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        ISquareAvatarView a16 = aVar.a(enableFilamentDetail, context2);
        this.avatarView = a16;
        AvatarData avatarData = this.avatarData;
        int i16 = 1;
        this.defaultAvatarResId = (avatarData != null && avatarData.getMale()) != false ? R.drawable.n2x : R.drawable.n2w;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DetailAvatarAnimator>() { // from class: com.tencent.mobileqq.nearbypro.avatar.NearbyAvatarView$animator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DetailAvatarAnimator invoke() {
                xa2.c cVar;
                ISquareAvatarView iSquareAvatarView;
                cVar = NearbyAvatarView.this.binding;
                RelativeLayout relativeLayout = cVar.f447574b;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarImage");
                iSquareAvatarView = NearbyAvatarView.this.avatarView;
                DetailAvatarAnimator detailAvatarAnimator = new DetailAvatarAnimator(relativeLayout, iSquareAvatarView, NearbyAvatarView.this.getWidth(), NearbyAvatarView.this.getHeight(), DetailAvatarConfig.INSTANCE.defaultDetailConfig());
                detailAvatarAnimator.setScaleDuration(0L);
                return detailAvatarAnimator;
            }
        });
        this.animator = lazy;
        this.recorder = new FilamentCoverRecorder();
        a16.setConfig(new AvatarAnimConfig(false, new SquarePlayerPool(0 == true ? 1 : 0, i16, 0 == true ? 1 : 0), new PlayConfig(-1, true, null, 4, null), true));
        f16.f447575c.addView(a16 instanceof View ? (View) a16 : null);
        if (a16 instanceof SquareAvatarFilamentView) {
            ((SquareAvatarFilamentView) a16).setActionHelper(NearbyProAvatarActionHelper.f253199a);
        }
        ImageService.Companion companion = ImageService.INSTANCE;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        companion.initImageLoader(context3);
    }
}

package com.tencent.mobileqq.qqlive.sail.ui.background;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.room.frame.activity.QQliveTranslucentRoomActivity;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.mobileqq.qqlive.sail.room.e;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.ui.room.RoomViewModel;
import com.tencent.mobileqq.qqlive.widget.roombg.CropImageView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import mi2.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt3.aa;
import tl.h;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001HB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\"R\u0018\u0010+\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010&R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u00109\u001a\u0004\b?\u0010@R\u0016\u0010E\u001a\u0004\u0018\u00010B8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bC\u0010D\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/background/QQLiveAudienceBgPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lmi2/d;", "", "ta", "Lcom/tencent/mobileqq/qqlive/sail/ui/background/a;", "info", "", "wa", "Ltq4/a;", "backgroundInfo", "xa", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "U9", "V9", "onFirstFrameRendered", "", "e", "I", "position", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "backgroundImageView", "Landroid/view/ViewStub;", h.F, "Landroid/view/ViewStub;", "roomSkinTopViewStub", "Lcom/tencent/mobileqq/qqlive/widget/roombg/CropImageView;", "i", "Lcom/tencent/mobileqq/qqlive/widget/roombg/CropImageView;", "roomSkinTopImageView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "roomSkinBottomViewStub", BdhLogUtil.LogTag.Tag_Conn, "roomSkinBottomImageView", "Landroid/util/Size;", "D", "Landroid/util/Size;", QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, "E", "Z", "useSeamless", "Lkotlinx/coroutines/Job;", UserInfo.SEX_FEMALE, "Lkotlinx/coroutines/Job;", "seamlessEnterWatchDog", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "G", "Lkotlin/Lazy;", "sa", "()Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "roomViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/background/BackgroundViewModel;", "H", "qa", "()Lcom/tencent/mobileqq/qqlive/sail/ui/background/BackgroundViewModel;", "bgViewModel", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "ra", "()Lcom/tencent/mobileqq/qqlive/sail/room/e;", "room", "<init>", "(I)V", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAudienceBgPart extends com.tencent.mobileqq.qqlive.sail.base.c implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private CropImageView roomSkinBottomImageView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Size videoSize;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean useSeamless;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Job seamlessEnterWatchDog;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy roomViewModel;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy bgViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int position;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView backgroundImageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewStub roomSkinTopViewStub;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CropImageView roomSkinTopImageView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewStub roomSkinBottomViewStub;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/background/QQLiveAudienceBgPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.background.QQLiveAudienceBgPart$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51513);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveAudienceBgPart(int i3) {
        Job launch$default;
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.position = i3;
        this.useSeamless = true;
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, CoroutineStart.LAZY, new QQLiveAudienceBgPart$seamlessEnterWatchDog$1(this, null), 1, null);
        this.seamlessEnterWatchDog = launch$default;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RoomViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.background.QQLiveAudienceBgPart$roomViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBgPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RoomViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (RoomViewModel) QQLiveAudienceBgPart.this.getViewModel(RoomViewModel.class) : (RoomViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.roomViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<BackgroundViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.background.QQLiveAudienceBgPart$bgViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBgPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BackgroundViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (BackgroundViewModel) QQLiveAudienceBgPart.this.getViewModel(BackgroundViewModel.class) : (BackgroundViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.bgViewModel = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BackgroundViewModel qa() {
        Object value = this.bgViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-bgViewModel>(...)");
        return (BackgroundViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e ra() {
        f a26 = sa().a2();
        if (a26 instanceof e) {
            return (e) a26;
        }
        return null;
    }

    private final RoomViewModel sa() {
        Object value = this.roomViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-roomViewModel>(...)");
        return (RoomViewModel) value;
    }

    private final boolean ta() {
        return getActivity() instanceof QQliveTranslucentRoomActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wa(a info) {
        Long l3;
        this.useSeamless = false;
        if (info == null) {
            AegisLogger.INSTANCE.w("Audience|QQLiveAudienceBgPart", "showBackground", "invalid info");
            return;
        }
        int i3 = getContext().getResources().getConfiguration().orientation;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        e ra5 = ra();
        if (ra5 != null) {
            l3 = Long.valueOf(ra5.getRoomId());
        } else {
            l3 = null;
        }
        companion.i("Audience|QQLiveAudienceBgPart", "showBackground", "roomId=" + l3 + ", priority=" + info.c() + ", orientation=" + i3);
        if (i3 == 2) {
            ImageView imageView = this.backgroundImageView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.backgroundImageView;
            if (imageView2 != null) {
                imageView2.setImageResource(R.color.black);
            }
            CropImageView cropImageView = this.roomSkinTopImageView;
            if (cropImageView != null) {
                cropImageView.setVisibility(8);
            }
            CropImageView cropImageView2 = this.roomSkinBottomImageView;
            if (cropImageView2 != null) {
                cropImageView2.setVisibility(8);
                return;
            }
            return;
        }
        Drawable a16 = info.a();
        if (a16 != null) {
            ImageView imageView3 = this.backgroundImageView;
            if (imageView3 != null) {
                imageView3.setScaleType(info.d());
            }
            ImageView imageView4 = this.backgroundImageView;
            if (imageView4 != null) {
                imageView4.setImageDrawable(a16);
            }
        }
        Drawable e16 = info.e();
        if (e16 != null) {
            ImageView imageView5 = this.backgroundImageView;
            if (imageView5 != null) {
                imageView5.setVisibility(8);
            }
            CropImageView cropImageView3 = this.roomSkinTopImageView;
            if (cropImageView3 != null) {
                cropImageView3.setVisibility(0);
                cropImageView3.setScaleType(info.d());
                cropImageView3.setImageDrawable(e16);
            }
        }
        Drawable b16 = info.b();
        if (b16 != null) {
            ImageView imageView6 = this.backgroundImageView;
            if (imageView6 != null) {
                imageView6.setVisibility(8);
            }
            CropImageView cropImageView4 = this.roomSkinBottomImageView;
            if (cropImageView4 != null) {
                cropImageView4.setVisibility(0);
                cropImageView4.setScaleType(info.d());
                cropImageView4.setImageDrawable(b16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xa(tq4.a backgroundInfo) {
        KeyEvent.Callback callback;
        View view;
        CropImageView cropImageView;
        QLog.d("Audience|QQLiveAudienceBgPart", 1, "tryFetchRoomSkinBackground up:" + backgroundInfo.f437140b + " down:" + backgroundInfo.f437141c);
        Size size = this.videoSize;
        if (size == null || size.getWidth() <= size.getHeight()) {
            return;
        }
        CropImageView cropImageView2 = null;
        if (this.roomSkinTopImageView == null) {
            ViewStub viewStub = this.roomSkinTopViewStub;
            if (viewStub != null) {
                view = viewStub.inflate();
            } else {
                view = null;
            }
            if (view instanceof CropImageView) {
                cropImageView = (CropImageView) view;
            } else {
                cropImageView = null;
            }
            this.roomSkinTopImageView = cropImageView;
            if (cropImageView != null) {
                cropImageView.setAlignTop(false);
            }
        }
        if (this.roomSkinBottomImageView == null) {
            ViewStub viewStub2 = this.roomSkinBottomViewStub;
            if (viewStub2 != null) {
                callback = viewStub2.inflate();
            } else {
                callback = null;
            }
            if (callback instanceof CropImageView) {
                cropImageView2 = (CropImageView) callback;
            }
            this.roomSkinBottomImageView = cropImageView2;
            if (cropImageView2 != null) {
                cropImageView2.setAlignTop(true);
            }
        }
        qa().W1(backgroundInfo.f437140b, backgroundInfo.f437141c);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        AudienceRoomInfo b16;
        aa q16;
        tq4.a aVar;
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isDevelopLevel()) {
            e ra5 = ra();
            if (ra5 != null) {
                l3 = Long.valueOf(ra5.getRoomId());
            } else {
                l3 = null;
            }
            companion.d("Audience|QQLiveAudienceBgPart", "onEnterRoom", "roomId=" + l3);
        }
        e ra6 = ra();
        if (ra6 != null && (b16 = ra6.b()) != null && (q16 = b16.q()) != null && (aVar = q16.f432225d) != null) {
            xa(aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.V9();
        this.useSeamless = false;
        Job.DefaultImpls.cancel$default(this.seamlessEnterWatchDog, (CancellationException) null, 1, (Object) null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) configuration);
        } else {
            super.onConfigurationChanged(configuration);
            wa(qa().X1().getValue());
        }
    }

    @Override // mi2.d
    public void onFirstFrameRendered() {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        e ra5 = ra();
        if (ra5 != null) {
            l3 = Long.valueOf(ra5.getRoomId());
        } else {
            l3 = null;
        }
        companion.i("Audience|QQLiveAudienceBgPart", "onFirstFrameRendered", "roomId=" + l3);
        Job.DefaultImpls.cancel$default(this.seamlessEnterWatchDog, (CancellationException) null, 1, (Object) null);
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new QQLiveAudienceBgPart$onFirstFrameRendered$1(this, null), 3, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ImageView imageView;
        ViewStub viewStub;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        ViewStub viewStub2 = null;
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.f60122uk);
        } else {
            imageView = null;
        }
        this.backgroundImageView = imageView;
        if (rootView != null) {
            viewStub = (ViewStub) rootView.findViewById(R.id.f60262uy);
        } else {
            viewStub = null;
        }
        this.roomSkinTopViewStub = viewStub;
        if (rootView != null) {
            viewStub2 = (ViewStub) rootView.findViewById(R.id.f60252ux);
        }
        this.roomSkinBottomViewStub = viewStub2;
        if (ta() && this.position == 0 && this.useSeamless) {
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBgPart", "onInitView", "seamless enter");
            this.seamlessEnterWatchDog.start();
            e ra5 = ra();
            if (ra5 != null) {
                ra5.registerFirstFrameRenderedListener(this);
            }
        } else {
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBgPart", "onInitView", "normal enter");
            this.useSeamless = false;
            qa().U1();
        }
        LiveData<a> X1 = qa().X1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<a, Unit> function1 = new Function1<a, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.background.QQLiveAudienceBgPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBgPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(a aVar) {
                e ra6;
                boolean z16;
                boolean z17;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                    return;
                }
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                ra6 = QQLiveAudienceBgPart.this.ra();
                Long valueOf = ra6 != null ? Long.valueOf(ra6.getRoomId()) : null;
                int c16 = aVar.c();
                z16 = QQLiveAudienceBgPart.this.useSeamless;
                companion.i("Audience|QQLiveAudienceBgPart", "bgDrawableChanged", "roomId=" + valueOf + ", priority=" + c16 + ", useSeamless=" + z16);
                z17 = QQLiveAudienceBgPart.this.useSeamless;
                if (z17) {
                    return;
                }
                QQLiveAudienceBgPart.this.wa(aVar);
            }
        };
        X1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.background.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBgPart.ua(Function1.this, obj);
            }
        });
        MutableLiveData<Size> d26 = sa().d2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Size, Unit> function12 = new Function1<Size, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.background.QQLiveAudienceBgPart$onInitView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBgPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                invoke2(size);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Size size) {
                e ra6;
                BackgroundViewModel qa5;
                e ra7;
                e ra8;
                AudienceRoomInfo b16;
                aa q16;
                tq4.a aVar;
                AudienceRoomInfo b17;
                e ra9;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) size);
                    return;
                }
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                r5 = null;
                String str = null;
                if (companion.isDevelopLevel()) {
                    ra9 = QQLiveAudienceBgPart.this.ra();
                    companion.d("Audience|QQLiveAudienceBgPart", "videoSizeChanged", "roomId=" + (ra9 != null ? Long.valueOf(ra9.getRoomId()) : null) + ", size=" + size);
                }
                QQLiveAudienceBgPart.this.videoSize = size;
                if (size.getWidth() > size.getHeight()) {
                    qa5 = QQLiveAudienceBgPart.this.qa();
                    ra7 = QQLiveAudienceBgPart.this.ra();
                    if (ra7 != null && (b17 = ra7.b()) != null) {
                        str = b17.getCover();
                    }
                    qa5.T1(str);
                    ra8 = QQLiveAudienceBgPart.this.ra();
                    if (ra8 == null || (b16 = ra8.b()) == null || (q16 = b16.q()) == null || (aVar = q16.f432225d) == null) {
                        return;
                    }
                    QQLiveAudienceBgPart.this.xa(aVar);
                    return;
                }
                ra6 = QQLiveAudienceBgPart.this.ra();
                companion.i("Audience|QQLiveAudienceBgPart", "videoSizeChanged", "roomId=" + (ra6 != null ? Long.valueOf(ra6.getRoomId()) : null) + ", no need to show blur background");
            }
        };
        d26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.background.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBgPart.va(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        e ra5 = ra();
        if (ra5 != null) {
            ra5.u(this);
        }
    }
}

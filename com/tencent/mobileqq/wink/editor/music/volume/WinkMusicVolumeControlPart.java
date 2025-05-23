package com.tencent.mobileqq.wink.editor.music.volume;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.view.StartPointSeekBar;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n*\u0002<@\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0001]B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001d\u00a2\u0006\u0004\bZ\u0010[J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0014\u0010\t\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016H\u0016R\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010)\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010-\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010$\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R\"\u00101\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010$\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R\"\u00105\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010$\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010ER\u0016\u0010M\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010HR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010PR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020T8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010V\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/volume/WinkMusicVolumeControlPart;", "Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "Landroid/view/View$OnClickListener;", "", "Ua", "initViewModel", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar;", "", NodeProps.ENABLED, "Ya", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "sliderType", "", "value", "Ja", "sliderValue", "Xa", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "oa", "", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "initAfterInflation", "onBackEvent", "v", NodeProps.ON_CLICK, "Landroidx/lifecycle/ViewModelStoreOwner;", "M", "Landroidx/lifecycle/ViewModelStoreOwner;", "Na", "()Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "N", UserInfo.SEX_FEMALE, "getOriginVolume", "()F", "setOriginVolume", "(F)V", "originVolume", "P", "getBgmVolume", "setBgmVolume", "bgmVolume", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "getNewOriginVolume", "Wa", "newOriginVolume", BdhLogUtil.LogTag.Tag_Req, "getNewBgmVolume", "Va", "newBgmVolume", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", ExifInterface.LATITUDE_SOUTH, "Lkotlin/Lazy;", "Ma", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "musicVolumeControlViewModel", "com/tencent/mobileqq/wink/editor/music/volume/WinkMusicVolumeControlPart$d", "T", "Lcom/tencent/mobileqq/wink/editor/music/volume/WinkMusicVolumeControlPart$d;", "originSeekBarOnChangeListener", "com/tencent/mobileqq/wink/editor/music/volume/WinkMusicVolumeControlPart$c", "U", "Lcom/tencent/mobileqq/wink/editor/music/volume/WinkMusicVolumeControlPart$c;", "bgmSeekBarOnChangeListener", "V", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar;", "sldOrigin", "W", "Landroid/view/View;", "sldOriginMask", "X", "sldMusic", "Y", "sldMusicMask", "Landroid/widget/TextView;", "Z", "Landroid/widget/TextView;", "tvOriginTip", "a0", "tvMusicTip", "Landroid/widget/ImageView;", "b0", "Landroid/widget/ImageView;", "leftBtn", "c0", "rightBtn", "<init>", "(Landroidx/lifecycle/ViewModelStoreOwner;)V", "d0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMusicVolumeControlPart extends WinkEditorMenuPart implements View.OnClickListener {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final ViewModelStoreOwner owner;

    /* renamed from: N, reason: from kotlin metadata */
    private float originVolume;

    /* renamed from: P, reason: from kotlin metadata */
    private float bgmVolume;

    /* renamed from: Q, reason: from kotlin metadata */
    private float newOriginVolume;

    /* renamed from: R, reason: from kotlin metadata */
    private float newBgmVolume;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy musicVolumeControlViewModel;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final d originSeekBarOnChangeListener;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final c bgmSeekBarOnChangeListener;

    /* renamed from: V, reason: from kotlin metadata */
    private StartPointSeekBar sldOrigin;

    /* renamed from: W, reason: from kotlin metadata */
    private View sldOriginMask;

    /* renamed from: X, reason: from kotlin metadata */
    private StartPointSeekBar sldMusic;

    /* renamed from: Y, reason: from kotlin metadata */
    private View sldMusicMask;

    /* renamed from: Z, reason: from kotlin metadata */
    private TextView tvOriginTip;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private TextView tvMusicTip;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ImageView leftBtn;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private ImageView rightBtn;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f321287a;

        static {
            int[] iArr = new int[MusicVolumeControlViewModel.VolumeType.values().length];
            try {
                iArr[MusicVolumeControlViewModel.VolumeType.ORIGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MusicVolumeControlViewModel.VolumeType.TEMPLATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MusicVolumeControlViewModel.VolumeType.BGM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f321287a = iArr;
        }
    }

    public WinkMusicVolumeControlPart(@NotNull ViewModelStoreOwner owner) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MusicVolumeControlViewModel>() { // from class: com.tencent.mobileqq.wink.editor.music.volume.WinkMusicVolumeControlPart$musicVolumeControlViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MusicVolumeControlViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(WinkMusicVolumeControlPart.this.getOwner()).get(MusicVolumeControlViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(owner)\u2026rolViewModel::class.java)");
                return (MusicVolumeControlViewModel) viewModel;
            }
        });
        this.musicVolumeControlViewModel = lazy;
        this.originSeekBarOnChangeListener = new d();
        this.bgmSeekBarOnChangeListener = new c();
    }

    private final void Ja(MusicVolumeControlViewModel.VolumeType sliderType, float value) {
        int i3 = b.f321287a[sliderType.ordinal()];
        float f16 = 0.0f;
        StartPointSeekBar startPointSeekBar = null;
        if (i3 != 1) {
            if (i3 == 2 || i3 == 3) {
                StartPointSeekBar startPointSeekBar2 = this.sldMusic;
                if (startPointSeekBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sldMusic");
                    startPointSeekBar2 = null;
                }
                if (startPointSeekBar2.isEnabled()) {
                    f16 = value;
                }
                QLog.d(this.TAG, 4, "[changeSliderValuePassive] change bgm slider to " + value);
                StartPointSeekBar startPointSeekBar3 = this.sldMusic;
                if (startPointSeekBar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sldMusic");
                    startPointSeekBar3 = null;
                }
                startPointSeekBar3.setOnSeekBarChangeListener(null);
                StartPointSeekBar startPointSeekBar4 = this.sldMusic;
                if (startPointSeekBar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sldMusic");
                    startPointSeekBar4 = null;
                }
                double d16 = f16 * 100;
                TextView textView = this.tvMusicTip;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvMusicTip");
                    textView = null;
                }
                Ka(startPointSeekBar4, d16, textView);
                StartPointSeekBar startPointSeekBar5 = this.sldMusic;
                if (startPointSeekBar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sldMusic");
                } else {
                    startPointSeekBar = startPointSeekBar5;
                }
                startPointSeekBar.setOnSeekBarChangeListener(this.bgmSeekBarOnChangeListener);
                return;
            }
            return;
        }
        StartPointSeekBar startPointSeekBar6 = this.sldOrigin;
        if (startPointSeekBar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sldOrigin");
            startPointSeekBar6 = null;
        }
        if (startPointSeekBar6.isEnabled()) {
            f16 = value;
        }
        QLog.d(this.TAG, 4, "[changeSliderValuePassive] change origin slider to " + value);
        StartPointSeekBar startPointSeekBar7 = this.sldOrigin;
        if (startPointSeekBar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sldOrigin");
            startPointSeekBar7 = null;
        }
        startPointSeekBar7.setOnSeekBarChangeListener(null);
        StartPointSeekBar startPointSeekBar8 = this.sldOrigin;
        if (startPointSeekBar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sldOrigin");
            startPointSeekBar8 = null;
        }
        double d17 = f16 * 100;
        TextView textView2 = this.tvOriginTip;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvOriginTip");
            textView2 = null;
        }
        Ka(startPointSeekBar8, d17, textView2);
        StartPointSeekBar startPointSeekBar9 = this.sldOrigin;
        if (startPointSeekBar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sldOrigin");
        } else {
            startPointSeekBar = startPointSeekBar9;
        }
        startPointSeekBar.setOnSeekBarChangeListener(this.originSeekBarOnChangeListener);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
    
        if (r4 < 0.0d) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void Ka(final StartPointSeekBar startPointSeekBar, final double d16, final TextView textView) {
        double d17 = 300.0d;
        if (d16 <= 300.0d) {
            d17 = 0.0d;
        }
        d16 = d17;
        startPointSeekBar.setProgress(com.tencent.mobileqq.wink.editor.performance.b.c(d16, 0, 1, null));
        com.tencent.qav.thread.a.d().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.volume.g
            @Override // java.lang.Runnable
            public final void run() {
                WinkMusicVolumeControlPart.La(StartPointSeekBar.this, d16, textView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void La(StartPointSeekBar slider, double d16, TextView tip) {
        int roundToInt;
        Intrinsics.checkNotNullParameter(slider, "$slider");
        Intrinsics.checkNotNullParameter(tip, "$tip");
        roundToInt = MathKt__MathJVMKt.roundToInt(d16);
        StartPointSeekBar.v(slider, String.valueOf(roundToInt), tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MusicVolumeControlViewModel Ma() {
        return (MusicVolumeControlViewModel) this.musicVolumeControlViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Oa(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pa(WinkMusicVolumeControlPart this$0, Float value) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.TAG, 4, "[bgmSliderLiveData] update to value " + value);
        MusicVolumeControlViewModel.VolumeType volumeType = MusicVolumeControlViewModel.VolumeType.BGM;
        Intrinsics.checkNotNullExpressionValue(value, "value");
        this$0.Ja(volumeType, value.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qa(WinkMusicVolumeControlPart this$0, Float value) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.TAG, 4, "[originSliderLiveData] update to value " + value);
        MusicVolumeControlViewModel.VolumeType volumeType = MusicVolumeControlViewModel.VolumeType.ORIGIN;
        Intrinsics.checkNotNullExpressionValue(value, "value");
        this$0.Ja(volumeType, value.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ra(WinkMusicVolumeControlPart this$0, Boolean it) {
        Float valueOf;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            valueOf = this$0.Ma().h2().getValue();
            if (valueOf == null) {
                valueOf = Float.valueOf(1.0f);
            }
        } else {
            valueOf = Float.valueOf(0.0f);
        }
        float floatValue = valueOf.floatValue();
        StartPointSeekBar startPointSeekBar = null;
        boolean z17 = false;
        if (it.booleanValue()) {
            View view = this$0.sldOriginMask;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sldOriginMask");
                view = null;
            }
            view.setVisibility(8);
        } else {
            View view2 = this$0.sldOriginMask;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sldOriginMask");
                view2 = null;
            }
            view2.setVisibility(0);
        }
        StartPointSeekBar startPointSeekBar2 = this$0.sldOrigin;
        if (startPointSeekBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sldOrigin");
        } else {
            startPointSeekBar = startPointSeekBar2;
        }
        this$0.Ya(startPointSeekBar, it.booleanValue());
        this$0.Ja(MusicVolumeControlViewModel.VolumeType.ORIGIN, floatValue);
        MusicVolumeControlViewModel Ma = this$0.Ma();
        if (it.booleanValue()) {
            if (floatValue == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = true;
            }
        }
        Ma.I2(z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sa(WinkMusicVolumeControlPart this$0, Boolean it) {
        Float valueOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            valueOf = this$0.Ma().i2().getValue();
            if (valueOf == null) {
                valueOf = Float.valueOf(1.0f);
            }
        } else {
            valueOf = Float.valueOf(0.0f);
        }
        this$0.Ja(MusicVolumeControlViewModel.VolumeType.ORIGIN, valueOf.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ta(WinkMusicVolumeControlPart this$0, MusicVolumeControlViewModel.VolumeType volumeType) {
        float f16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.TAG, 4, "[OperateBgmType] change to " + volumeType.name());
        View view = null;
        if (volumeType != MusicVolumeControlViewModel.VolumeType.NONE) {
            StartPointSeekBar startPointSeekBar = this$0.sldMusic;
            if (startPointSeekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sldMusic");
                startPointSeekBar = null;
            }
            this$0.Ya(startPointSeekBar, true);
            View view2 = this$0.sldMusicMask;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sldMusicMask");
            } else {
                view = view2;
            }
            view.setVisibility(8);
            f16 = this$0.Ma().Z1();
        } else {
            StartPointSeekBar startPointSeekBar2 = this$0.sldMusic;
            if (startPointSeekBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sldMusic");
                startPointSeekBar2 = null;
            }
            this$0.Ya(startPointSeekBar2, false);
            View view3 = this$0.sldMusicMask;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sldMusicMask");
            } else {
                view = view3;
            }
            view.setVisibility(0);
            f16 = 0.0f;
        }
        float f17 = f16;
        if (volumeType == MusicVolumeControlViewModel.VolumeType.ORIGIN) {
            this$0.Ma().Q1(this$0.Ma().d2());
        }
        this$0.Ma().S1(f17, MusicVolumeControlViewModel.VolumeType.BGM);
    }

    private final void Ua() {
        float f16;
        Unit unit;
        StartPointSeekBar startPointSeekBar = this.sldOrigin;
        StartPointSeekBar startPointSeekBar2 = null;
        if (startPointSeekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sldOrigin");
            startPointSeekBar = null;
        }
        startPointSeekBar.setSectionEnable(false);
        startPointSeekBar.setAbsoluteMinMaxValue(0.0d, 300.0d);
        startPointSeekBar.setDefaultValue(100.0f);
        startPointSeekBar.setOnSeekBarChangeListener(this.originSeekBarOnChangeListener);
        Float it = Ma().h2().getValue();
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            f16 = it.floatValue();
            unit = Unit.INSTANCE;
        } else {
            f16 = 0.0f;
            unit = null;
        }
        if (unit == null) {
            f16 = Ma().b2();
        }
        Ja(MusicVolumeControlViewModel.VolumeType.ORIGIN, f16);
        float f17 = 100;
        this.originVolume = f16 * f17;
        StartPointSeekBar startPointSeekBar3 = this.sldMusic;
        if (startPointSeekBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sldMusic");
        } else {
            startPointSeekBar2 = startPointSeekBar3;
        }
        startPointSeekBar2.setSectionEnable(false);
        startPointSeekBar2.setAbsoluteMinMaxValue(0.0d, 300.0d);
        startPointSeekBar2.setDefaultValue(100.0f);
        startPointSeekBar2.setOnSeekBarChangeListener(this.bgmSeekBarOnChangeListener);
        float Z1 = Ma().Z1();
        Ja(MusicVolumeControlViewModel.VolumeType.BGM, Z1);
        float f18 = Z1 * f17;
        this.bgmVolume = f18;
        w53.b.f(this.TAG, "initViews, originVolume:" + this.originVolume + ", bgmVolume:" + f18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float Xa(float sliderValue) {
        return sliderValue / 100.0f;
    }

    private final void Ya(StartPointSeekBar startPointSeekBar, boolean z16) {
        int i3;
        int i16;
        startPointSeekBar.setEnabled(z16);
        if (z16) {
            i3 = R.drawable.ony;
        } else {
            i3 = R.drawable.f160627oi2;
        }
        startPointSeekBar.setThumbDrawable(i3);
        if (z16) {
            i16 = R.drawable.nqd;
        } else {
            i16 = R.drawable.nqc;
        }
        startPointSeekBar.setBackgroundDrawable(i16);
    }

    private final void initViewModel() {
        Ma().U1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.volume.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMusicVolumeControlPart.Pa(WinkMusicVolumeControlPart.this, (Float) obj);
            }
        });
        Ma().i2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.volume.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMusicVolumeControlPart.Qa(WinkMusicVolumeControlPart.this, (Float) obj);
            }
        });
        Ma().g2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.volume.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMusicVolumeControlPart.Ra(WinkMusicVolumeControlPart.this, (Boolean) obj);
            }
        });
        Ma().k2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.volume.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMusicVolumeControlPart.Sa(WinkMusicVolumeControlPart.this, (Boolean) obj);
            }
        });
        Ma().X1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.volume.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMusicVolumeControlPart.Ta(WinkMusicVolumeControlPart.this, (MusicVolumeControlViewModel.VolumeType) obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.zjt;
    }

    @NotNull
    /* renamed from: Na, reason: from getter */
    public final ViewModelStoreOwner getOwner() {
        return this.owner;
    }

    public final void Va(float f16) {
        this.newBgmVolume = f16;
    }

    public final void Wa(float f16) {
        this.newOriginVolume = f16;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.MUSIC_VOLUME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        View findViewById = rootView.findViewById(R.id.f86204r1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<St\u2026tSeekBar>(R.id.sldOrigin)");
        this.sldOrigin = (StartPointSeekBar) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f86174qy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<St\u2026ntSeekBar>(R.id.sldMusic)");
        this.sldMusic = (StartPointSeekBar) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f10545662);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById<TextView>(R.id.tvOriginTip)");
        this.tvOriginTip = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f1054265z);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById<TextView>(R.id.tvMusicTip)");
        this.tvMusicTip = (TextView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.e7d);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById<ImageView>(R.id.left_btn)");
        ImageView imageView = (ImageView) findViewById5;
        this.leftBtn = imageView;
        View view = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftBtn");
            imageView = null;
        }
        imageView.setVisibility(8);
        View findViewById6 = rootView.findViewById(R.id.i_w);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById<ImageView>(R.id.right_btn)");
        this.rightBtn = (ImageView) findViewById6;
        ImageView imageView2 = this.leftBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftBtn");
            imageView2 = null;
        }
        imageView2.setOnClickListener(this);
        ImageView imageView3 = this.rightBtn;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightBtn");
            imageView3 = null;
        }
        imageView3.setOnClickListener(this);
        View findViewById7 = rootView.findViewById(R.id.f86224r3);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.sldOriginMask)");
        this.sldOriginMask = findViewById7;
        View findViewById8 = rootView.findViewById(R.id.f86194r0);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.sldMusicMask)");
        this.sldMusicMask = findViewById8;
        View view2 = this.sldOriginMask;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sldOriginMask");
            view2 = null;
        }
        view2.setOnClickListener(this);
        View view3 = this.sldMusicMask;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sldMusicMask");
        } else {
            view = view3;
        }
        view.setOnClickListener(this);
        Ua();
        initViewModel();
        ((ConstraintLayout) rootView.findViewById(R.id.b8q)).setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.wink.editor.music.volume.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view4, MotionEvent motionEvent) {
                boolean Oa;
                Oa = WinkMusicVolumeControlPart.Oa(view4, motionEvent);
                return Oa;
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (this.visible) {
            ImageView imageView = this.rightBtn;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightBtn");
                imageView = null;
            }
            imageView.performClick();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.e7d) {
            boolean z17 = true;
            if (this.originVolume == this.newOriginVolume) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                Ma().N2(Xa(this.originVolume));
            }
            if (this.bgmVolume != this.newBgmVolume) {
                z17 = false;
            }
            if (!z17) {
                Ma().L2(Xa(this.bgmVolume));
            }
            G9().u5(MenuType.MUSIC, null);
            w53.b.f(this.TAG, "reset volume: originVolume:" + this.originVolume + ", bgmVolume:" + this.bgmVolume + ", newOriginVolume:" + this.newOriginVolume + ", newBgmVolume:" + this.newBgmVolume);
        } else if (num != null && num.intValue() == R.id.i_w) {
            w53.b.f(this.TAG, "set volume: originVolume:" + this.originVolume + ", bgmVolume:" + this.bgmVolume + ", newOriginVolume:" + this.newOriginVolume + ", newBgmVolume:" + this.newBgmVolume);
            this.originVolume = this.newOriginVolume;
            this.bgmVolume = this.newBgmVolume;
            G9().l5();
        } else if (num != null && num.intValue() == R.id.f86224r3) {
            com.tencent.biz.qui.toast.b.j(getContext(), "\u6682\u65e0\u539f\u58f0").show();
        } else if (num != null && num.intValue() == R.id.f86194r0) {
            com.tencent.biz.qui.toast.b.j(getContext(), "\u6682\u65e0\u914d\u4e50").show();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/music/volume/WinkMusicVolumeControlPart$c", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar$a;", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar;", "bar", "", "value", "", "wd", "seekbar", "uc", "Fd", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements StartPointSeekBar.a {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void Fd(@Nullable StartPointSeekBar seekbar) {
            float f16;
            MusicVolumeControlViewModel Ma = WinkMusicVolumeControlPart.this.Ma();
            WinkMusicVolumeControlPart winkMusicVolumeControlPart = WinkMusicVolumeControlPart.this;
            float f17 = 0.0f;
            if (seekbar != null) {
                f16 = seekbar.h();
            } else {
                f16 = 0.0f;
            }
            Ma.L2(winkMusicVolumeControlPart.Xa(f16));
            WinkMusicVolumeControlPart.this.Ma().l2().postValue(Boolean.TRUE);
            WinkMusicVolumeControlPart winkMusicVolumeControlPart2 = WinkMusicVolumeControlPart.this;
            if (seekbar != null) {
                f17 = seekbar.h();
            }
            winkMusicVolumeControlPart2.Va(f17);
            WinkMusicVolumeControlPart.this.Ma().A2(true);
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void wd(@Nullable StartPointSeekBar bar, int value) {
            StartPointSeekBar startPointSeekBar = WinkMusicVolumeControlPart.this.sldMusic;
            TextView textView = null;
            if (startPointSeekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sldMusic");
                startPointSeekBar = null;
            }
            String valueOf = String.valueOf(value);
            TextView textView2 = WinkMusicVolumeControlPart.this.tvMusicTip;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvMusicTip");
            } else {
                textView = textView2;
            }
            StartPointSeekBar.v(startPointSeekBar, valueOf, textView);
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void uc(@Nullable StartPointSeekBar seekbar) {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/wink/editor/music/volume/WinkMusicVolumeControlPart$d", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar$a;", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar;", "bar", "", "value", "", "wd", "seekbar", "uc", "Fd", "d", "I", "getCurValue", "()I", "setCurValue", "(I)V", "curValue", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements StartPointSeekBar.a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int curValue = -1;

        d() {
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void Fd(@Nullable StartPointSeekBar seekbar) {
            float f16;
            MusicVolumeControlViewModel Ma = WinkMusicVolumeControlPart.this.Ma();
            WinkMusicVolumeControlPart winkMusicVolumeControlPart = WinkMusicVolumeControlPart.this;
            float f17 = 0.0f;
            if (seekbar != null) {
                f16 = seekbar.h();
            } else {
                f16 = 0.0f;
            }
            Ma.N2(winkMusicVolumeControlPart.Xa(f16));
            WinkMusicVolumeControlPart.this.Ma().J2(true);
            WinkMusicVolumeControlPart.this.Ma().x2(true);
            WinkMusicVolumeControlPart.this.Ma().l2().postValue(Boolean.TRUE);
            WinkMusicVolumeControlPart winkMusicVolumeControlPart2 = WinkMusicVolumeControlPart.this;
            if (seekbar != null) {
                f17 = seekbar.h();
            }
            winkMusicVolumeControlPart2.Wa(f17);
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void wd(@Nullable StartPointSeekBar bar, int value) {
            this.curValue = value;
            StartPointSeekBar startPointSeekBar = WinkMusicVolumeControlPart.this.sldOrigin;
            TextView textView = null;
            if (startPointSeekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sldOrigin");
                startPointSeekBar = null;
            }
            String valueOf = String.valueOf(value);
            TextView textView2 = WinkMusicVolumeControlPart.this.tvOriginTip;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvOriginTip");
            } else {
                textView = textView2;
            }
            StartPointSeekBar.v(startPointSeekBar, valueOf, textView);
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void uc(@Nullable StartPointSeekBar seekbar) {
        }
    }
}

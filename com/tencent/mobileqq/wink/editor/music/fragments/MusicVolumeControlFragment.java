package com.tencent.mobileqq.wink.editor.music.fragments;

import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import com.tencent.mobileqq.wink.view.StartPointSeekBar;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\t*\u0002,0\u0018\u0000 62\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0014\u0010\u0012\u001a\u00020\u0006*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002R\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicVolumeControlFragment;", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicMenuBaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "getLogTag", "initViews", "initViewModel", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar;", "", NodeProps.ENABLED, "Uh", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "sliderType", "", "value", "Eh", "sliderValue", "Th", "Lcom/tencent/mobileqq/wink/editor/music/vo/Scene;", "Kh", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "Jh", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "musicVolumeControlViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/a;", "G", "Hh", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/a;", "musicPlayViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "H", "Ih", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "musicSourceViewModel", "com/tencent/mobileqq/wink/editor/music/fragments/MusicVolumeControlFragment$d", "I", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicVolumeControlFragment$d;", "originSeekBarOnChangeListener", "com/tencent/mobileqq/wink/editor/music/fragments/MusicVolumeControlFragment$c", "J", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicVolumeControlFragment$c;", "bgmSeekBarOnChangeListener", "<init>", "()V", "L", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MusicVolumeControlFragment extends MusicMenuBaseFragment {

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String M = MusicVolumeControlFragment.class.getSimpleName();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy musicVolumeControlViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy musicPlayViewModel;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy musicSourceViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final d originSeekBarOnChangeListener;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final c bgmSeekBarOnChangeListener;

    @NotNull
    public Map<Integer, View> K = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u001c\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicVolumeControlFragment$a;", "", "Lcom/tencent/mobileqq/wink/editor/music/vo/Scene;", "scene", "Landroidx/lifecycle/ViewModelStoreOwner;", "storeOwner", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicVolumeControlFragment;", "a", "", "KEY_SCENE", "Ljava/lang/String;", "", "SEEK_BAR_MAX", "D", "SEEK_BAR_MIN", "kotlin.jvm.PlatformType", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.music.fragments.MusicVolumeControlFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MusicVolumeControlFragment a(@NotNull Scene scene, @Nullable ViewModelStoreOwner storeOwner) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            MusicVolumeControlFragment musicVolumeControlFragment = new MusicVolumeControlFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("scene", scene);
            musicVolumeControlFragment.setArguments(bundle);
            musicVolumeControlFragment.qh(storeOwner);
            return musicVolumeControlFragment;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f320807a;

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
            f320807a = iArr;
        }
    }

    public MusicVolumeControlFragment() {
        super(R.layout.hfp);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MusicVolumeControlViewModel>() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.MusicVolumeControlFragment$musicVolumeControlViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MusicVolumeControlViewModel invoke() {
                ViewModelStoreOwner mStoreOwner = MusicVolumeControlFragment.this.getMStoreOwner();
                if (mStoreOwner == null) {
                    mStoreOwner = MusicVolumeControlFragment.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(mStoreOwner, "requireActivity()");
                }
                ViewModel viewModel = new ViewModelProvider(mStoreOwner).get(MusicVolumeControlViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(mStore\u2026rolViewModel::class.java)");
                return (MusicVolumeControlViewModel) viewModel;
            }
        });
        this.musicVolumeControlViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.music.viewmodel.a>() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.MusicVolumeControlFragment$musicPlayViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.wink.editor.music.viewmodel.a invoke() {
                Scene Kh;
                Object systemService = MusicVolumeControlFragment.this.requireContext().getSystemService("audio");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
                AudioManager audioManager = (AudioManager) systemService;
                Kh = MusicVolumeControlFragment.this.Kh();
                ViewModelStoreOwner mStoreOwner = MusicVolumeControlFragment.this.getMStoreOwner();
                if (mStoreOwner == null) {
                    mStoreOwner = MusicVolumeControlFragment.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(mStoreOwner, "requireActivity()");
                }
                ViewModel viewModel = new ViewModelProvider(mStoreOwner, new com.tencent.mobileqq.wink.editor.music.viewmodel.f(audioManager, Kh)).get(com.tencent.mobileqq.wink.editor.music.viewmodel.a.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(mStore\u2026yerViewModel::class.java)");
                return (com.tencent.mobileqq.wink.editor.music.viewmodel.a) viewModel;
            }
        });
        this.musicPlayViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<MusicSourceViewModel>() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.MusicVolumeControlFragment$musicSourceViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MusicSourceViewModel invoke() {
                ViewModelStoreOwner mStoreOwner = MusicVolumeControlFragment.this.getMStoreOwner();
                if (mStoreOwner == null) {
                    mStoreOwner = MusicVolumeControlFragment.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(mStoreOwner, "requireActivity()");
                }
                ViewModel viewModel = new ViewModelProvider(mStoreOwner).get(MusicSourceViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(mStore\u2026rceViewModel::class.java)");
                return (MusicSourceViewModel) viewModel;
            }
        });
        this.musicSourceViewModel = lazy3;
        this.originSeekBarOnChangeListener = new d();
        this.bgmSeekBarOnChangeListener = new c();
    }

    private final void Eh(MusicVolumeControlViewModel.VolumeType sliderType, float value) {
        int i3 = b.f320807a[sliderType.ordinal()];
        float f16 = 0.0f;
        if (i3 != 1) {
            if (i3 == 2 || i3 == 3) {
                if (((StartPointSeekBar) Ah(R.id.f86174qy)).isEnabled()) {
                    f16 = value;
                }
                QLog.d(M, 4, "[changeSliderValuePassive] change bgm slider to " + value);
                ((StartPointSeekBar) Ah(R.id.f86174qy)).setOnSeekBarChangeListener(null);
                StartPointSeekBar sldMusic = (StartPointSeekBar) Ah(R.id.f86174qy);
                Intrinsics.checkNotNullExpressionValue(sldMusic, "sldMusic");
                TextView tvMusicTip = (TextView) Ah(R.id.f1054265z);
                Intrinsics.checkNotNullExpressionValue(tvMusicTip, "tvMusicTip");
                Fh(sldMusic, f16 * 100, tvMusicTip);
                ((StartPointSeekBar) Ah(R.id.f86174qy)).setOnSeekBarChangeListener(this.bgmSeekBarOnChangeListener);
                return;
            }
            return;
        }
        if (((StartPointSeekBar) Ah(R.id.f86204r1)).isEnabled()) {
            f16 = value;
        }
        QLog.d(M, 4, "[changeSliderValuePassive] change origin slider to " + value);
        ((StartPointSeekBar) Ah(R.id.f86204r1)).setOnSeekBarChangeListener(null);
        StartPointSeekBar sldOrigin = (StartPointSeekBar) Ah(R.id.f86204r1);
        Intrinsics.checkNotNullExpressionValue(sldOrigin, "sldOrigin");
        TextView tvOriginTip = (TextView) Ah(R.id.f10545662);
        Intrinsics.checkNotNullExpressionValue(tvOriginTip, "tvOriginTip");
        Fh(sldOrigin, f16 * 100, tvOriginTip);
        ((StartPointSeekBar) Ah(R.id.f86204r1)).setOnSeekBarChangeListener(this.originSeekBarOnChangeListener);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
    
        if (r4 < 0.0d) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void Fh(final StartPointSeekBar startPointSeekBar, final double d16, final TextView textView) {
        double d17 = 300.0d;
        if (d16 <= 300.0d) {
            d17 = 0.0d;
        }
        d16 = d17;
        startPointSeekBar.setProgress(com.tencent.mobileqq.wink.editor.performance.b.c(d16, 0, 1, null));
        com.tencent.qav.thread.a.d().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.o
            @Override // java.lang.Runnable
            public final void run() {
                MusicVolumeControlFragment.Gh(StartPointSeekBar.this, d16, textView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(StartPointSeekBar slider, double d16, TextView tip) {
        int roundToInt;
        Intrinsics.checkNotNullParameter(slider, "$slider");
        Intrinsics.checkNotNullParameter(tip, "$tip");
        roundToInt = MathKt__MathJVMKt.roundToInt(d16);
        StartPointSeekBar.v(slider, String.valueOf(roundToInt), tip);
    }

    private final com.tencent.mobileqq.wink.editor.music.viewmodel.a Hh() {
        return (com.tencent.mobileqq.wink.editor.music.viewmodel.a) this.musicPlayViewModel.getValue();
    }

    private final MusicSourceViewModel Ih() {
        return (MusicSourceViewModel) this.musicSourceViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MusicVolumeControlViewModel Jh() {
        return (MusicVolumeControlViewModel) this.musicVolumeControlViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Scene Kh() {
        Object obj;
        Bundle arguments = getArguments();
        Scene scene = null;
        if (arguments != null) {
            obj = arguments.get("scene");
        } else {
            obj = null;
        }
        if (obj instanceof Scene) {
            scene = (Scene) obj;
        }
        if (scene == null) {
            return Scene.EDIT;
        }
        return scene;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(MusicVolumeControlFragment this$0, Boolean it) {
        Float valueOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            valueOf = this$0.Jh().i2().getValue();
            if (valueOf == null) {
                valueOf = Float.valueOf(1.0f);
            }
        } else {
            valueOf = Float.valueOf(0.0f);
        }
        this$0.Eh(MusicVolumeControlViewModel.VolumeType.ORIGIN, valueOf.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(MusicVolumeControlFragment this$0, MusicVolumeControlViewModel.VolumeType volumeType) {
        float f16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(M, 4, "[OperateBgmType] change to " + volumeType.name());
        MusicVolumeControlViewModel.VolumeType volumeType2 = MusicVolumeControlViewModel.VolumeType.NONE;
        if (volumeType != volumeType2) {
            StartPointSeekBar sldMusic = (StartPointSeekBar) this$0.Ah(R.id.f86174qy);
            Intrinsics.checkNotNullExpressionValue(sldMusic, "sldMusic");
            this$0.Uh(sldMusic, true);
            f16 = this$0.Jh().Z1();
        } else {
            StartPointSeekBar sldMusic2 = (StartPointSeekBar) this$0.Ah(R.id.f86174qy);
            Intrinsics.checkNotNullExpressionValue(sldMusic2, "sldMusic");
            this$0.Uh(sldMusic2, false);
            f16 = 0.0f;
        }
        double d16 = f16;
        if (volumeType != volumeType2) {
            ((TextView) this$0.Ah(R.id.f1054165y)).setTextColor(this$0.getResources().getColor(R.color.bfp));
        } else {
            ((TextView) this$0.Ah(R.id.f1054165y)).setTextColor(this$0.getResources().getColor(R.color.bfq));
        }
        float f17 = (float) d16;
        if (volumeType == MusicVolumeControlViewModel.VolumeType.ORIGIN) {
            this$0.Jh().Q1(this$0.Jh().d2());
        }
        this$0.Jh().S1(f17, MusicVolumeControlViewModel.VolumeType.BGM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(MusicVolumeControlFragment this$0, Float value) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.editor.music.viewmodel.a Hh = this$0.Hh();
        Intrinsics.checkNotNullExpressionValue(value, "value");
        Hh.R1(value.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(MusicVolumeControlFragment this$0, Float value) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(M, 4, "[bgmSliderLiveData] update to value " + value);
        MusicVolumeControlViewModel.VolumeType volumeType = MusicVolumeControlViewModel.VolumeType.BGM;
        Intrinsics.checkNotNullExpressionValue(value, "value");
        this$0.Eh(volumeType, value.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(MusicVolumeControlFragment this$0, Float value) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(M, 4, "[originSliderLiveData] update to value " + value);
        MusicVolumeControlViewModel.VolumeType volumeType = MusicVolumeControlViewModel.VolumeType.ORIGIN;
        Intrinsics.checkNotNullExpressionValue(value, "value");
        this$0.Eh(volumeType, value.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(MusicVolumeControlFragment this$0, MusicInfoWrapper musicInfoWrapper) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.Kh() == Scene.CAMERA) {
            MusicVolumeControlViewModel Jh = this$0.Jh();
            boolean z17 = true;
            if (musicInfoWrapper.getMusicInfo() == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Jh.H2(z16);
            MusicVolumeControlViewModel Jh2 = this$0.Jh();
            if (musicInfoWrapper.getMusicInfo() == null) {
                z17 = false;
            }
            MusicVolumeControlViewModel.z2(Jh2, z17, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(MusicVolumeControlFragment this$0, Boolean it) {
        Float valueOf;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            valueOf = this$0.Jh().h2().getValue();
            if (valueOf == null) {
                valueOf = Float.valueOf(1.0f);
            }
        } else {
            valueOf = Float.valueOf(0.0f);
        }
        float floatValue = valueOf.floatValue();
        StartPointSeekBar sldOrigin = (StartPointSeekBar) this$0.Ah(R.id.f86204r1);
        Intrinsics.checkNotNullExpressionValue(sldOrigin, "sldOrigin");
        this$0.Uh(sldOrigin, it.booleanValue());
        if (it.booleanValue()) {
            ((TextView) this$0.Ah(R.id.f10544661)).setTextColor(this$0.getResources().getColor(R.color.bfp));
        } else {
            ((TextView) this$0.Ah(R.id.f10544661)).setTextColor(this$0.getResources().getColor(R.color.bfq));
        }
        this$0.Eh(MusicVolumeControlViewModel.VolumeType.ORIGIN, floatValue);
        MusicVolumeControlViewModel Jh = this$0.Jh();
        boolean z17 = false;
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
        Jh.I2(z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(MusicVolumeControlFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StartPointSeekBar.v((StartPointSeekBar) this$0.Ah(R.id.f86204r1), ((TextView) this$0.Ah(R.id.f10545662)).getText().toString(), (TextView) this$0.Ah(R.id.f10545662));
        StartPointSeekBar.v((StartPointSeekBar) this$0.Ah(R.id.f86174qy), ((TextView) this$0.Ah(R.id.f1054265z)).getText().toString(), (TextView) this$0.Ah(R.id.f1054265z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float Th(float sliderValue) {
        return sliderValue / 100.0f;
    }

    private final void Uh(StartPointSeekBar startPointSeekBar, boolean z16) {
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
        Jh().T1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicVolumeControlFragment.Nh(MusicVolumeControlFragment.this, (Float) obj);
            }
        });
        Jh().U1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicVolumeControlFragment.Oh(MusicVolumeControlFragment.this, (Float) obj);
            }
        });
        Jh().i2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicVolumeControlFragment.Ph(MusicVolumeControlFragment.this, (Float) obj);
            }
        });
        Ih().D2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicVolumeControlFragment.Qh(MusicVolumeControlFragment.this, (MusicInfoWrapper) obj);
            }
        });
        Jh().g2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicVolumeControlFragment.Rh(MusicVolumeControlFragment.this, (Boolean) obj);
            }
        });
        Jh().k2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicVolumeControlFragment.Lh(MusicVolumeControlFragment.this, (Boolean) obj);
            }
        });
        Jh().X1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicVolumeControlFragment.Mh(MusicVolumeControlFragment.this, (MusicVolumeControlViewModel.VolumeType) obj);
            }
        });
    }

    private final void initViews() {
        Unit unit;
        StartPointSeekBar startPointSeekBar = (StartPointSeekBar) Ah(R.id.f86204r1);
        startPointSeekBar.setSectionEnable(false);
        startPointSeekBar.setAbsoluteMinMaxValue(0.0d, 300.0d);
        startPointSeekBar.setDefaultValue(100.0f);
        startPointSeekBar.setOnSeekBarChangeListener(this.originSeekBarOnChangeListener);
        Float it = Jh().h2().getValue();
        if (it != null) {
            MusicVolumeControlViewModel.VolumeType volumeType = MusicVolumeControlViewModel.VolumeType.ORIGIN;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Eh(volumeType, it.floatValue());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Eh(MusicVolumeControlViewModel.VolumeType.ORIGIN, Jh().b2());
        }
        StartPointSeekBar startPointSeekBar2 = (StartPointSeekBar) Ah(R.id.f86174qy);
        startPointSeekBar2.setSectionEnable(false);
        startPointSeekBar2.setAbsoluteMinMaxValue(0.0d, 300.0d);
        startPointSeekBar2.setDefaultValue(100.0f);
        startPointSeekBar2.setOnSeekBarChangeListener(this.bgmSeekBarOnChangeListener);
        Eh(MusicVolumeControlViewModel.VolumeType.BGM, Jh().Z1());
    }

    @Nullable
    public View Ah(int i3) {
        View findViewById;
        Map<Integer, View> map = this.K;
        View view = map.get(Integer.valueOf(i3));
        if (view == null) {
            View view2 = getView();
            if (view2 != null && (findViewById = view2.findViewById(i3)) != null) {
                map.put(Integer.valueOf(i3), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // com.tencent.mobileqq.wink.editor.music.fragments.MusicMenuBaseFragment
    public void _$_clearFindViewByIdCache() {
        this.K.clear();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    @NotNull
    public String getLogTag() {
        String TAG = M;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        return TAG;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.n
            @Override // java.lang.Runnable
            public final void run() {
                MusicVolumeControlFragment.Sh(MusicVolumeControlFragment.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.music.fragments.MusicMenuBaseFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initViews();
        initViewModel();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/music/fragments/MusicVolumeControlFragment$c", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar$a;", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar;", "bar", "", "value", "", "wd", "seekbar", "uc", "Fd", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements StartPointSeekBar.a {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void Fd(@Nullable StartPointSeekBar seekbar) {
            float f16;
            MusicVolumeControlViewModel Jh = MusicVolumeControlFragment.this.Jh();
            MusicVolumeControlFragment musicVolumeControlFragment = MusicVolumeControlFragment.this;
            if (seekbar != null) {
                f16 = seekbar.h();
            } else {
                f16 = 0.0f;
            }
            Jh.L2(musicVolumeControlFragment.Th(f16));
            MusicVolumeControlFragment.this.Jh().l2().postValue(Boolean.TRUE);
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void wd(@Nullable StartPointSeekBar bar, int value) {
            StartPointSeekBar.v((StartPointSeekBar) MusicVolumeControlFragment.this.Ah(R.id.f86174qy), String.valueOf(value), (TextView) MusicVolumeControlFragment.this.Ah(R.id.f1054265z));
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void uc(@Nullable StartPointSeekBar seekbar) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/wink/editor/music/fragments/MusicVolumeControlFragment$d", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar$a;", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar;", "bar", "", "value", "", "wd", "seekbar", "uc", "Fd", "d", "I", "getCurValue", "()I", "setCurValue", "(I)V", "curValue", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements StartPointSeekBar.a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int curValue = -1;

        d() {
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void Fd(@Nullable StartPointSeekBar seekbar) {
            float f16;
            MusicVolumeControlViewModel Jh = MusicVolumeControlFragment.this.Jh();
            MusicVolumeControlFragment musicVolumeControlFragment = MusicVolumeControlFragment.this;
            if (seekbar != null) {
                f16 = seekbar.h();
            } else {
                f16 = 0.0f;
            }
            Jh.N2(musicVolumeControlFragment.Th(f16));
            MusicVolumeControlFragment.this.Jh().J2(true);
            MusicVolumeControlFragment.this.Jh().x2(true);
            MusicVolumeControlFragment.this.Jh().l2().postValue(Boolean.TRUE);
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void wd(@Nullable StartPointSeekBar bar, int value) {
            this.curValue = value;
            StartPointSeekBar.v((StartPointSeekBar) MusicVolumeControlFragment.this.Ah(R.id.f86204r1), String.valueOf(value), (TextView) MusicVolumeControlFragment.this.Ah(R.id.f10545662));
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void uc(@Nullable StartPointSeekBar seekbar) {
        }
    }
}

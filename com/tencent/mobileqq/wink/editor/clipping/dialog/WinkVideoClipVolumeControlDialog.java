package com.tencent.mobileqq.wink.editor.clipping.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.wink.utils.ac;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\u00020\u0001:\u000212B\u000f\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0017\u0010\u000b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u000bR\u0018\u0010 \u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010&\u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010+\u001a\u0004\u0018\u00010'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010*\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/dialog/WinkVideoClipVolumeControlDialog;", "Landroid/app/Dialog;", "", "X", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "b0", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "", "Z", "(Ljava/lang/Float;)V", "Landroid/view/View;", "anchorView", "offsetX", "offsetY", "a0", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/wink/editor/clipping/dialog/WinkVideoClipVolumeControlDialog$b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/clipping/dialog/WinkVideoClipVolumeControlDialog$b;", BdhLogUtil.LogTag.Tag_Req, "()Lcom/tencent/mobileqq/wink/editor/clipping/dialog/WinkVideoClipVolumeControlDialog$b;", "Y", "(Lcom/tencent/mobileqq/wink/editor/clipping/dialog/WinkVideoClipVolumeControlDialog$b;)V", "onVolumeChangeListener", "", "D", "canVibrate", "E", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/SeekBar;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "U", "()Landroid/widget/SeekBar;", "volumeSeekBar", "Landroid/widget/TextView;", "G", "W", "()Landroid/widget/TextView;", "volumeText", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "H", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkVideoClipVolumeControlDialog extends ReportDialog {
    private static final int I = ImmersiveUtils.dpToPx(76.0f);
    private static final int J = ImmersiveUtils.dpToPx(254.0f);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private b onVolumeChangeListener;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean canVibrate;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View rootView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy volumeSeekBar;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy volumeText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/dialog/WinkVideoClipVolumeControlDialog$b;", "", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void a(float volume);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkVideoClipVolumeControlDialog(@NotNull Context context) {
        super(context, R.style.f173460a10);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.canVibrate = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SeekBar>() { // from class: com.tencent.mobileqq.wink.editor.clipping.dialog.WinkVideoClipVolumeControlDialog$volumeSeekBar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final SeekBar invoke() {
                View view;
                view = WinkVideoClipVolumeControlDialog.this.rootView;
                if (view != null) {
                    return (SeekBar) view.findViewById(R.id.f12023790);
                }
                return null;
            }
        });
        this.volumeSeekBar = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.editor.clipping.dialog.WinkVideoClipVolumeControlDialog$volumeText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final TextView invoke() {
                View view;
                view = WinkVideoClipVolumeControlDialog.this.rootView;
                if (view != null) {
                    return (TextView) view.findViewById(R.id.f12024791);
                }
                return null;
            }
        });
        this.volumeText = lazy2;
        this.rootView = LayoutInflater.from(context).inflate(R.layout.hey, (ViewGroup) null);
    }

    private final SeekBar U() {
        return (SeekBar) this.volumeSeekBar.getValue();
    }

    private final TextView W() {
        return (TextView) this.volumeText.getValue();
    }

    private final void X() {
        SeekBar U = U();
        if (U != null) {
            U.setOnSeekBarChangeListener(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(int volume) {
        TextView W = W();
        if (W != null) {
            W.setText(String.valueOf(volume));
        }
        if (volume == 0) {
            TextView W2 = W();
            if (W2 != null) {
                W2.setTextColor(getContext().getResources().getColor(R.color.bfq));
                return;
            }
            return;
        }
        TextView W3 = W();
        if (W3 != null) {
            W3.setTextColor(getContext().getResources().getColor(R.color.bfp));
        }
    }

    @Nullable
    /* renamed from: R, reason: from getter */
    public final b getOnVolumeChangeListener() {
        return this.onVolumeChangeListener;
    }

    public final int S() {
        SeekBar U = U();
        if (U != null) {
            return U.getProgress();
        }
        return 0;
    }

    public final void Y(@Nullable b bVar) {
        this.onVolumeChangeListener = bVar;
    }

    public final void Z(@Nullable Float volume) {
        if (volume != null) {
            double floatValue = volume.floatValue() * 100;
            double d16 = 300.0d;
            if (floatValue <= 300.0d) {
                d16 = 0.0d;
                if (floatValue >= 0.0d) {
                    d16 = com.tencent.mobileqq.wink.editor.performance.b.c(floatValue, 0, 1, null);
                }
            }
            this.canVibrate = false;
            SeekBar U = U();
            if (U != null) {
                U.setProgress((int) d16);
            }
            this.canVibrate = true;
            b0((int) d16);
        }
    }

    public final void a0(@NotNull View anchorView, int offsetX, int offsetY) {
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Window window = getWindow();
        if (window != null) {
            window.setGravity(8388691);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                Intrinsics.checkNotNullExpressionValue(attributes, "attributes");
                attributes.dimAmount = 0.1f;
                attributes.x = ((int) anchorView.getX()) + ((anchorView.getWidth() - I) / 2) + offsetX;
                attributes.y = ((int) anchorView.getY()) + anchorView.getHeight() + offsetY;
            }
        }
        show();
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = this.rootView;
        Intrinsics.checkNotNull(view);
        setContentView(view);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(I, J);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        X();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/dialog/WinkVideoClipVolumeControlDialog$c", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/widget/SeekBar;", "seekbar", "", "progress", "", "fromUser", "", "onProgressChanged", "p0", "onStartTrackingTouch", "onStopTrackingTouch", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements SeekBar.OnSeekBarChangeListener {
        c() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@Nullable SeekBar seekbar, int progress, boolean fromUser) {
            WinkVideoClipVolumeControlDialog.this.b0(progress);
            b onVolumeChangeListener = WinkVideoClipVolumeControlDialog.this.getOnVolumeChangeListener();
            if (onVolumeChangeListener != null) {
                onVolumeChangeListener.a(progress / 100);
            }
            boolean z16 = false;
            if (WinkVideoClipVolumeControlDialog.this.canVibrate && progress == 100) {
                ac.f326659a.b(WinkVideoClipVolumeControlDialog.this.getContext(), 100L);
                WinkVideoClipVolumeControlDialog.this.canVibrate = false;
                return;
            }
            if (95 <= progress && progress < 106) {
                z16 = true;
            }
            if (!z16) {
                WinkVideoClipVolumeControlDialog.this.canVibrate = true;
            } else if (seekbar != null) {
                seekbar.setProgress(100);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@Nullable SeekBar p06) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@Nullable SeekBar p06) {
        }
    }
}

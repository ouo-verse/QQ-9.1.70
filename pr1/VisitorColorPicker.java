package pr1;

import android.graphics.Color;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import tl.h;
import xy2.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\"\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000eR*\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u001b\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u001c\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0014R\u0011\u0010\u001d\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0014\u00a8\u0006!"}, d2 = {"Lpr1/a;", "Landroidx/lifecycle/LiveData;", "", "toString", "", "<set-?>", "d", "Z", "g", "()Z", "shouldUseDarkForeground", "e", AppConstants.Key.COLUMN_IS_VALID, "setValid", "(Z)V", "", "color", "f", "I", "getBackgroundColor", "()I", "j", "(I)V", "backgroundColor", "i", "textColor", h.F, "subTitleColor", "cardBackgroundColor", NodeProps.SHADOW_COLOR, "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: pr1.a, reason: from toString */
/* loaded from: classes14.dex */
public final class VisitorColorPicker extends LiveData<VisitorColorPicker> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean shouldUseDarkForeground = true;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isValid;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int backgroundColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    private static final int f427053i = Color.parseColor("#ff222222");

    /* renamed from: m, reason: collision with root package name */
    private static final int f427054m = Color.parseColor("#73222222");
    private static final int C = Color.parseColor("#cdffffff");
    private static final int D = Color.parseColor("#0d000000");
    private static final int E = Color.parseColor("#ffffffff");
    private static final int F = Color.parseColor("#b4ffffff");
    private static final int G = Color.parseColor(GameCenterVideoViewController.GRAY_MASK);
    private static final int H = Color.parseColor("#0d000000");

    @NotNull
    private static final float[] I = new float[3];

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lpr1/a$a;", "", "", "color", "", "b", "LIGHT_TEXT_COLOR", "I", "a", "()I", "DARK_CARD_BACKGROUND", "DARK_SHADOW", "DARK_SUB_TITLE_COLOR", "DARK_TEXT_COLOR", "", "TAG", "Ljava/lang/String;", "", "tempHsl", "[F", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: pr1.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return VisitorColorPicker.E;
        }

        public final boolean b(int color) {
            b.d(color, VisitorColorPicker.I);
            boolean z16 = false;
            float f16 = VisitorColorPicker.I[0];
            float f17 = VisitorColorPicker.I[2];
            if ((0.0f <= f16 && f16 < 15.0f && 0.79d < f17 && f17 <= 1.0f) || ((15.0f <= f16 && f16 < 34.0f && 0.7d < f17 && f17 <= 1.0f) || ((34.0f <= f16 && f16 < 42.0f && 0.6d < f17 && f17 <= 1.0f) || ((42.0f <= f16 && f16 <= 50.0f && 0.5d < f17 && f17 <= 1.0f) || ((50.0f < f16 && f16 < 188.0f && 0.45d < f17 && f17 <= 1.0f) || ((188.0f <= f16 && f16 <= 190.0f && 0.5d < f17 && f17 <= 1.0f) || ((190.0f < f16 && f16 < 195.0f && 0.65d < f17 && f17 <= 1.0f) || ((195.0f <= f16 && f16 < 198.0f && 0.7d < f17 && f17 <= 1.0f) || ((198.0f <= f16 && f16 < 210.0f && 0.75d < f17 && f17 <= 1.0f) || (210.0f <= f16 && f16 <= 360.0f && 0.79d < f17 && f17 <= 1.0f)))))))))) {
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                Logger.f235387a.d().i("Guild.MF.Vst.ForegroundColorPicker", 1, "isLightColor:" + Integer.toHexString(color) + " h:" + f16 + " s:" + VisitorColorPicker.I[1] + " l:" + f17 + " res:" + z16);
            }
            return z16;
        }

        Companion() {
        }
    }

    public final int e() {
        if (this.shouldUseDarkForeground) {
            return C;
        }
        return G;
    }

    public final int f() {
        if (this.shouldUseDarkForeground) {
            return D;
        }
        return H;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getShouldUseDarkForeground() {
        return this.shouldUseDarkForeground;
    }

    public final int h() {
        if (this.shouldUseDarkForeground) {
            return f427054m;
        }
        return F;
    }

    public final int i() {
        if (this.shouldUseDarkForeground) {
            return f427053i;
        }
        return E;
    }

    public final void j(int i3) {
        s.f235620a.b();
        if (this.isValid && this.backgroundColor == i3) {
            return;
        }
        this.backgroundColor = i3;
        this.isValid = true;
        this.shouldUseDarkForeground = INSTANCE.b(i3);
        setValue(this);
    }

    @NotNull
    public String toString() {
        return "VisitorColorPicker(textColor=" + Integer.toHexString(i()) + ", subTitleColor=" + Integer.toHexString(h()) + ", cardBackgroundColor=" + Integer.toHexString(e()) + ", shadowColor=" + Integer.toHexString(f()) + ", shouldUseDarkForeground=" + this.shouldUseDarkForeground + ", isValid=" + this.isValid + ", backgroundColor=" + Integer.toHexString(this.backgroundColor) + ")";
    }
}

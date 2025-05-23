package ls0;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.guild.aio.input.GuildAioDefaultInputUIState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.utils.ViewUtils;
import fo0.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0003H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lls0/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lfo0/e;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "permissions", "", "h1", "", "g1", "e1", "d1", "f1", "Lcom/tencent/aio/base/mvvm/b;", "b1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "state", "c1", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "mMuteLayout", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mMuteIcon", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mMuteText", "<init>", "()V", h.F, "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends com.tencent.aio.base.mvvm.a<e, GuildAioDefaultInputUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mMuteLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mMuteIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mMuteText;

    /* renamed from: i, reason: collision with root package name */
    private static final int f415486i = ViewUtils.dip2px(14.0f);

    /* renamed from: m, reason: collision with root package name */
    private static final int f415487m = ViewUtils.dip2px(58.0f);
    private static final int C = ViewUtils.dip2px(22.0f);
    private static final float D = ViewUtils.dip2px(16.0f);
    private static final int E = ViewUtils.dip2px(8.0f);

    private final void d1() {
        ImageView imageView = new ImageView(getMContext());
        int i3 = C;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.setMarginEnd(E);
        layoutParams.gravity = 16;
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(R.drawable.guild_live_icon_mute);
        this.mMuteIcon = imageView;
    }

    private final void e1() {
        d1();
        f1();
        LinearLayout linearLayout = this.mMuteLayout;
        TextView textView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteLayout");
            linearLayout = null;
        }
        ImageView imageView = this.mMuteIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteIcon");
            imageView = null;
        }
        linearLayout.addView(imageView);
        LinearLayout linearLayout2 = this.mMuteLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteLayout");
            linearLayout2 = null;
        }
        TextView textView2 = this.mMuteText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteText");
        } else {
            textView = textView2;
        }
        linearLayout2.addView(textView);
    }

    private final void f1() {
        TextView textView = new TextView(getMContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, f415487m));
        textView.setIncludeFontPadding(false);
        textView.setGravity(17);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine(true);
        textView.setTextSize(0, D);
        textView.setText(getMContext().getResources().getString(R.string.f147510x3));
        textView.setTextColor(getMContext().getResources().getColor(R.color.bpw));
        this.mMuteText = textView;
    }

    private final boolean g1() {
        if (this.mMuteIcon != null) {
            return true;
        }
        return false;
    }

    private final void h1(int permissions) {
        int i3;
        LinearLayout linearLayout = this.mMuteLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteLayout");
            linearLayout = null;
        }
        if (yr0.a.f() && !GuildSpeakLimitStatus.INSTANCE.r(permissions)) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
        if (yr0.a.f() && !g1()) {
            e1();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<e, GuildAioDefaultInputUIState> createVM() {
        return new b();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildAioDefaultInputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildAioDefaultInputUIState.GuildUpdateMuteChange) {
            h1(((GuildAioDefaultInputUIState.GuildUpdateMuteChange) state).getPermissions());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        LinearLayout linearLayout = new LinearLayout(createViewParams.a());
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setGravity(17);
        int i3 = f415486i;
        linearLayout.setPadding(i3, 0, i3, 0);
        linearLayout.setVisibility(8);
        linearLayout.setBackgroundResource(R.drawable.guild_live_aio_mute_bg);
        this.mMuteLayout = linearLayout;
        return linearLayout;
    }
}

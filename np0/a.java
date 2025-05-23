package np0;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.input.GuildAioDefaultInputUIState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildMuteApi;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import fo0.e;
import fo0.f;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u000201B\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0019\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00062"}, d2 = {"Lnp0/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lfo0/e;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuildUpdateMuteChange;", "state", "", "h1", "", "g1", "e1", "d1", "f1", "isAdmin", "j1", "", "muteTxt", "i1", "Lcom/tencent/aio/base/mvvm/b;", "b1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "c1", "Lnp0/a$b;", "d", "Lnp0/a$b;", "getMuteUIStyle", "()Lnp0/a$b;", "muteUIStyle", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "mMuteLayout", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mMuteIcon", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "mMuteText", "Lfo0/f;", "businessPermissionCallback", "<init>", "(Lnp0/a$b;Lfo0/f;)V", "i", "a", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends com.tencent.aio.base.mvvm.a<e, GuildAioDefaultInputUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b muteUIStyle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mMuteLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mMuteIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mMuteText;

    /* renamed from: m, reason: collision with root package name */
    private static final int f420639m = ViewUtils.dip2px(14.0f);
    private static final int C = ViewUtils.dip2px(58.0f);
    private static final int D = ViewUtils.dip2px(22.0f);
    private static final float E = ViewUtils.dip2px(16.0f);
    private static final int F = ViewUtils.dip2px(26.0f);
    private static final int G = ViewUtils.dip2px(19.0f);
    private static final float H = ViewUtils.dip2px(13.0f);
    private static final int I = ViewUtils.dip2px(8.0f);

    public /* synthetic */ a(b bVar, f fVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new b(0, 0, 0, 7, null) : bVar, (i3 & 2) != 0 ? null : fVar);
    }

    private final void d1() {
        ImageView imageView = new ImageView(getMContext());
        int i3 = D;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.setMarginEnd(I);
        layoutParams.gravity = 16;
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(this.muteUIStyle.getMuteIconId());
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
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setIncludeFontPadding(false);
        textView.setGravity(17);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine(true);
        textView.setTextColor(getMContext().getResources().getColor(this.muteUIStyle.getMuteTextColorId()));
        this.mMuteText = textView;
    }

    private final boolean g1() {
        if (this.mMuteIcon != null) {
            return true;
        }
        return false;
    }

    private final void h1(GuildAioDefaultInputUIState.GuildUpdateMuteChange state) {
        String str;
        boolean z16;
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g16;
        int i3 = 8;
        LinearLayout linearLayout = null;
        boolean z17 = true;
        if (!state.getIsSelectMode() && !state.getShowRealAuth()) {
            int permissions = state.getPermissions();
            FrameworkVM mUIModel = getMUIModel();
            if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null && (g16 = aVar.g()) != null) {
                str = com.tencent.guild.aio.util.a.g(g16);
            } else {
                str = null;
            }
            GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
            boolean J = companion.J(permissions, str);
            QLog.i("GuildAioInput.MuteView", 1, "[onPermissionChange] muted = " + J + " isSubChannelAdminSelfMuteOnly = " + companion.N(permissions));
            LinearLayout linearLayout2 = this.mMuteLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMuteLayout");
            } else {
                linearLayout = linearLayout2;
            }
            if (J) {
                i3 = 0;
            }
            linearLayout.setVisibility(i3);
            if (!J) {
                return;
            }
            if (!g1()) {
                e1();
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16 || !((IGuildMuteApi) QRoute.api(IGuildMuteApi.class)).hasGuildMuteManagePermission(str)) {
                z17 = false;
            }
            j1(z17);
            return;
        }
        QLog.i("GuildAioInput.MuteView", 1, "[onPermissionChange] isMultiSelectMode " + state.getIsSelectMode() + ", showAuth " + state.getShowRealAuth() + " and hideMuteBar");
        LinearLayout linearLayout3 = this.mMuteLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteLayout");
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.setVisibility(8);
    }

    private final void i1(String muteTxt) {
        if (!g1()) {
            return;
        }
        TextView textView = this.mMuteText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteText");
            textView = null;
        }
        textView.setText(muteTxt);
    }

    private final void j1(boolean isAdmin) {
        int i3;
        int i16;
        float f16;
        int i17;
        if (isAdmin) {
            i3 = F;
            i16 = G;
            f16 = H;
            i17 = 8388627;
        } else {
            i3 = C;
            i16 = D;
            f16 = E;
            i17 = 17;
        }
        LinearLayout linearLayout = this.mMuteLayout;
        TextView textView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteLayout");
            linearLayout = null;
        }
        linearLayout.setGravity(i17);
        ImageView imageView = this.mMuteIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteIcon");
            imageView = null;
        }
        imageView.getLayoutParams().width = i16;
        ImageView imageView2 = this.mMuteIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteIcon");
            imageView2 = null;
        }
        imageView2.getLayoutParams().height = i16;
        TextView textView2 = this.mMuteText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteText");
            textView2 = null;
        }
        textView2.getLayoutParams().height = i3;
        TextView textView3 = this.mMuteText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteText");
            textView3 = null;
        }
        textView3.setTextSize(0, f16);
        TextView textView4 = this.mMuteText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteText");
        } else {
            textView = textView4;
        }
        textView.requestLayout();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<e, GuildAioDefaultInputUIState> createVM() {
        return new c();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildAioDefaultInputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildAioDefaultInputUIState.GuildUpdateMuteChange) {
            GuildAioDefaultInputUIState.GuildUpdateMuteChange guildUpdateMuteChange = (GuildAioDefaultInputUIState.GuildUpdateMuteChange) state;
            h1(guildUpdateMuteChange);
            i1(guildUpdateMuteChange.getMuteTxt());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        LinearLayout linearLayout = new LinearLayout(createViewParams.a());
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        int i3 = f420639m;
        linearLayout.setPadding(i3, 0, i3, 0);
        linearLayout.setVisibility(8);
        linearLayout.setBackgroundResource(this.muteUIStyle.getMuteLayoutBgId());
        this.mMuteLayout = linearLayout;
        return linearLayout;
    }

    public a(@NotNull b muteUIStyle, @Nullable f fVar) {
        Intrinsics.checkNotNullParameter(muteUIStyle, "muteUIStyle");
        this.muteUIStyle = muteUIStyle;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\bR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lnp0/a$b;", "", "", "a", "I", "b", "()I", "e", "(I)V", "muteLayoutBgId", "d", "muteIconId", "c", "f", "muteTextColorId", "<init>", "(III)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int muteLayoutBgId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int muteIconId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int muteTextColorId;

        public b(int i3, int i16, int i17) {
            this.muteLayoutBgId = i3;
            this.muteIconId = i16;
            this.muteTextColorId = i17;
        }

        /* renamed from: a, reason: from getter */
        public final int getMuteIconId() {
            return this.muteIconId;
        }

        /* renamed from: b, reason: from getter */
        public final int getMuteLayoutBgId() {
            return this.muteLayoutBgId;
        }

        /* renamed from: c, reason: from getter */
        public final int getMuteTextColorId() {
            return this.muteTextColorId;
        }

        public final void d(int i3) {
            this.muteIconId = i3;
        }

        public final void e(int i3) {
            this.muteLayoutBgId = i3;
        }

        public final void f(int i3) {
            this.muteTextColorId = i3;
        }

        public /* synthetic */ b(int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
            this((i18 & 1) != 0 ? R.drawable.guild_aio_mute_bg : i3, (i18 & 2) != 0 ? R.drawable.guild_token_mute_on_home_icon : i16, (i18 & 4) != 0 ? R.color.guild_aio_mute_text_color : i17);
        }
    }
}

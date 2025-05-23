package pp0;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.guild.aio.input.GuildAioDefaultInputUIState;
import com.tencent.guild.aio.input.readonly.GuildAioInputReadOnlyUIState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001)B1\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u0017\u0010\u0017\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006*"}, d2 = {"Lpp0/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lfo0/e;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "isShowReadOnlyView", "", "permissions", "", "d1", "Lcom/tencent/aio/base/mvvm/b;", "b1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "state", "c1", "d", "I", "getTextId", "()I", "textId", "e", "getTextColorId", "textColorId", "f", "getBgColorId", "bgColorId", h.F, "_textId", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mReadOnlyLayout", "Lfo0/f;", "businessPermissionCallback", "<init>", "(IIILfo0/f;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends com.tencent.aio.base.mvvm.a<e, GuildAioDefaultInputUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int textId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int textColorId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int bgColorId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int _textId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mReadOnlyLayout;
    private static final int C = ViewUtils.dip2px(60.0f);

    public /* synthetic */ a(int i3, int i16, int i17, f fVar, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? R.string.f197354js : i3, (i18 & 2) != 0 ? R.color.guild_aio_not_talk_text_color : i16, (i18 & 4) != 0 ? R.color.guild_aio_input_bar_bg : i17, (i18 & 8) != 0 ? null : fVar);
    }

    private final void d1(boolean isShowReadOnlyView, int permissions) {
        int i3;
        int i16;
        TextView textView = null;
        if (QLog.isColorLevel()) {
            QLog.i("GuildAioInput.ReadOnlyView", 2, "onUIChange isShowReadOnlyView:" + isShowReadOnlyView + ", permissions:" + permissions + ", isAllow = " + ((Object) null));
        }
        TextView textView2 = this.mReadOnlyLayout;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReadOnlyLayout");
            textView2 = null;
        }
        if (isShowReadOnlyView) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView2.setVisibility(i3);
        if (GuildSpeakLimitStatus.INSTANCE.H(permissions)) {
            i16 = R.string.f147530x5;
        } else {
            i16 = this.textId;
        }
        this._textId = i16;
        TextView textView3 = this.mReadOnlyLayout;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReadOnlyLayout");
            textView3 = null;
        }
        TextView textView4 = this.mReadOnlyLayout;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReadOnlyLayout");
        } else {
            textView = textView4;
        }
        textView3.setText(textView.getContext().getResources().getString(this._textId));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<e, GuildAioDefaultInputUIState> createVM() {
        return new b();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        if (this.bgColorId != 0) {
            TextView textView = this.mReadOnlyLayout;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mReadOnlyLayout");
                textView = null;
            }
            textView.setBackgroundColor(getMContext().getResources().getColor(this.bgColorId));
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildAioDefaultInputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildAioInputReadOnlyUIState.ShowReadOnlyView) {
            GuildAioInputReadOnlyUIState.ShowReadOnlyView showReadOnlyView = (GuildAioInputReadOnlyUIState.ShowReadOnlyView) state;
            d1(showReadOnlyView.getIsShowReadOnlyView(), showReadOnlyView.getPermissions());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        TextView textView = new TextView(createViewParams.a());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, C));
        textView.setTextSize(16.0f);
        textView.setTextColor(textView.getResources().getColor(this.textColorId));
        textView.setGravity(17);
        textView.setText(textView.getResources().getString(R.string.f197334jq));
        textView.setIncludeFontPadding(false);
        textView.setVisibility(8);
        if (this.bgColorId == 0) {
            textView.setBackground(null);
        }
        this.mReadOnlyLayout = textView;
        return textView;
    }

    public a(int i3, int i16, int i17, @Nullable f fVar) {
        this.textId = i3;
        this.textColorId = i16;
        this.bgColorId = i17;
        this._textId = i3;
    }
}

package go0;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.input.at.DMSlashUIState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.aiopopuppanel.service.api.IGuildAIOPopupPanelServiceApi;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import go0.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\t*\u00018\u0018\u0000 >2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u0016\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00120\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u0006H\u0016R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lgo0/e;", "Lcom/tencent/aio/base/mvvm/a;", "Lgo0/a;", "Lcom/tencent/guild/aio/input/at/DMSlashUIState;", "", "isEnable", "", "f1", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "m1", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "h1", "i1", "j1", "l1", "", "Ljava/lang/Class;", "getObserverStates", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "bindViewAndData", "Lgo0/b;", "e1", "state", "g1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lap0/b;", "d", "Lap0/b;", "mRobotSlashHelper", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "mGuildAioInputContainer", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "mRobotBtnLayout", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "mRobotBtnIcon", "Landroid/widget/EditText;", "i", "Landroid/widget/EditText;", "mEditText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mIsEnableSlashAbility", "go0/e$b", BdhLogUtil.LogTag.Tag_Conn, "Lgo0/e$b;", "mTextWatcher", "<init>", "()V", "D", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e extends com.tencent.aio.base.mvvm.a<a, DMSlashUIState> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mGuildAioInputContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mRobotBtnLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mRobotBtnIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private EditText mEditText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ap0.b mRobotSlashHelper = new ap0.b();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsEnableSlashAbility = true;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b mTextWatcher = new b();

    private final void f1(boolean isEnable) {
        this.mIsEnableSlashAbility = isEnable;
    }

    private final void h1(com.tencent.aio.api.runtime.a aioContext) {
        AIOParam aioParam = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(aioParam, "aioParam");
        if (i1(aioParam)) {
            ap0.b bVar = this.mRobotSlashHelper;
            ViewGroup viewGroup = this.mGuildAioInputContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildAioInputContainer");
                viewGroup = null;
            }
            ViewParent parent = viewGroup.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            bVar.d((ViewGroup) parent, aioParam, true, aioContext);
            return;
        }
        this.mRobotSlashHelper.g();
    }

    private final boolean i1(AIOParam aioParam) {
        if (aioParam.l().getInt(((IGuildRobotApi) QRoute.api(IGuildRobotApi.class)).getGuildDirectMsgTypeKey()) == 2) {
            return true;
        }
        return false;
    }

    private final void j1() {
        ap0.b bVar = ap0.f.guildSlashHelper;
        if (((IGuildAIOPopupPanelServiceApi) QRoute.api(IGuildAIOPopupPanelServiceApi.class)).currentPopupPanelType(0, -1) == 4) {
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        l1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void l1() {
        ViewGroup viewGroup = this.mGuildAioInputContainer;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildAioInputContainer");
            viewGroup = null;
        }
        View findViewById = viewGroup.findViewById(R.id.vxk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mGuildAioInputContainer.\u2026guild_aio_input_edittext)");
        EditText editText = (EditText) findViewById;
        ViewGroup viewGroup3 = this.mGuildAioInputContainer;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildAioInputContainer");
        } else {
            viewGroup2 = viewGroup3;
        }
        viewGroup2.getContext();
        ((IGuildRobotApi) QRoute.api(IGuildRobotApi.class)).openRobotSlashPanelFromBtn(editText);
    }

    private final void m1(AIOParam aioParam) {
        if (!i1(aioParam)) {
            LinearLayout linearLayout = this.mRobotBtnLayout;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRobotBtnLayout");
                linearLayout = null;
            }
            linearLayout.setVisibility(8);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        sendIntent(a.b.f402696d);
        sendIntent(a.C10391a.f402695d);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public go0.b createVM() {
        return new go0.b();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull DMSlashUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof DMSlashUIState.RefreshBotBtnUIState) {
            m1(((DMSlashUIState.RefreshBotBtnUIState) state).getAioParam());
            return;
        }
        if (state instanceof DMSlashUIState.InitSlashUIState) {
            h1(((DMSlashUIState.InitSlashUIState) state).getAioContext());
            return;
        }
        if (state instanceof DMSlashUIState.AioHideUIState) {
            this.mRobotSlashHelper.b();
        } else if (state instanceof DMSlashUIState.DismissSlashPanel) {
            this.mRobotSlashHelper.b();
        } else if (state instanceof DMSlashUIState.SetSlashAbilityUIState) {
            f1(((DMSlashUIState.SetSlashAbilityUIState) state).getIsEnable());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends DMSlashUIState>> getObserverStates() {
        List<Class<? extends DMSlashUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{DMSlashUIState.RefreshBotBtnUIState.class, DMSlashUIState.AioHideUIState.class, DMSlashUIState.InitSlashUIState.class, DMSlashUIState.SetSlashAbilityUIState.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View findViewById = createViewParams.b().findViewById(R.id.vxi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "createViewParams.parent.\u2026R.id.guild_aio_input_bar)");
        this.mGuildAioInputContainer = (ViewGroup) findViewById;
        View findViewById2 = createViewParams.b().findViewById(R.id.vyc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "createViewParams.parent.\u2026ld_aio_robot_func_layout)");
        LinearLayout linearLayout = (LinearLayout) findViewById2;
        this.mRobotBtnLayout = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRobotBtnLayout");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        View findViewById3 = createViewParams.b().findViewById(R.id.vyb);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "createViewParams.parent.\u2026uild_aio_robot_btn_image)");
        ImageView imageView = (ImageView) findViewById3;
        this.mRobotBtnIcon = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRobotBtnIcon");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: go0.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.k1(e.this, view);
            }
        });
        View findViewById4 = createViewParams.b().findViewById(R.id.vxk);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "createViewParams.parent.\u2026guild_aio_input_edittext)");
        EditText editText = (EditText) findViewById4;
        this.mEditText = editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        editText.addTextChangedListener(this.mTextWatcher);
        ImageView imageView2 = this.mRobotBtnIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRobotBtnIcon");
            return null;
        }
        return imageView2;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        editText.removeTextChangedListener(this.mTextWatcher);
        this.mRobotSlashHelper.g();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        super.onReuseView(reuseParam);
        LinearLayout linearLayout = this.mRobotBtnLayout;
        EditText editText = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRobotBtnLayout");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        EditText editText2 = this.mEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            editText = editText2;
        }
        editText.addTextChangedListener(this.mTextWatcher);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"go0/e$b", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence s16, int start, int count, int after) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence s16, int start, int before, int count) {
            Intrinsics.checkNotNullParameter(s16, "s");
            if (e.this.mIsEnableSlashAbility) {
                e.this.mRobotSlashHelper.h(s16, start, before, count);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
        }
    }
}

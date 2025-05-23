package mp0;

import android.view.LayoutInflater;
import android.view.View;
import com.tencent.guild.aio.input.GuildAioDefaultInputUIState;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mp0.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001!B\u0013\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0016\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00130\u0012H\u0016R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lmp0/c;", "Lcom/tencent/aio/base/mvvm/a;", "Lmp0/a;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "showTip", "isJuBao", "", "g1", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "c1", "state", "d1", "", "Ljava/lang/Class;", "getObserverStates", "", "d", "Ljava/lang/Integer;", "getBgId", "()Ljava/lang/Integer;", "bgId", "e", "Landroid/view/View;", "root", "<init>", "(Ljava/lang/Integer;)V", "f", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends com.tencent.aio.base.mvvm.a<a, GuildAioDefaultInputUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer bgId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View root;

    public /* synthetic */ c(Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num);
    }

    private final void e1() {
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        view.findViewById(R.id.sxj).setOnClickListener(new View.OnClickListener() { // from class: mp0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.f1(c.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("GuildAioInputGuestFaceAuthVB", 1, "authBtn onClicked");
        this$0.sendIntent(new a.C10798a(this$0.getMContext()));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void g1(boolean showTip, boolean isJuBao) {
        int i3 = 8;
        View view = null;
        if (isJuBao) {
            View view2 = this.root;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("root");
            } else {
                view = view2;
            }
            view.setVisibility(8);
            return;
        }
        View view3 = this.root;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
        } else {
            view = view3;
        }
        if (showTip) {
            i3 = 0;
        }
        view.setVisibility(i3);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<a, GuildAioDefaultInputUIState> createVM() {
        return new d();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildAioDefaultInputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildAioDefaultInputUIState.GuildGuestAuthTipVisibleChange) {
            GuildAioDefaultInputUIState.GuildGuestAuthTipVisibleChange guildGuestAuthTipVisibleChange = (GuildAioDefaultInputUIState.GuildGuestAuthTipVisibleChange) state;
            g1(guildGuestAuthTipVisibleChange.getShowTip(), guildGuestAuthTipVisibleChange.getIsJubao());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.StyleUpdateEvent) {
            View view = null;
            if (((GuildAioDefaultInputUIState.StyleUpdateEvent) state).getIsDarkMode()) {
                View view2 = this.root;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("root");
                } else {
                    view = view2;
                }
                view.setBackgroundResource(R.drawable.guild_guest_bottom_layout_dark_bg);
                return;
            }
            View view3 = this.root;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("root");
            } else {
                view = view3;
            }
            view.setBackgroundResource(R.drawable.guild_guest_bottom_layout_bg);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildAioDefaultInputUIState>> getObserverStates() {
        List<Class<? extends GuildAioDefaultInputUIState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(GuildAioDefaultInputUIState.GuildHandlerPermissionsChange.class);
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View inflate = LayoutInflater.from(createViewParams.a()).inflate(R.layout.f168099et1, createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(createViewParams.co\u2026ViewParams.parent, false)");
        this.root = inflate;
        Integer num = this.bgId;
        if (num != null) {
            int intValue = num.intValue();
            View view = this.root;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("root");
                view = null;
            }
            view.setBackgroundResource(intValue);
        }
        View view2 = this.root;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view2 = null;
        }
        view2.setVisibility(8);
        e1();
        View view3 = this.root;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            return null;
        }
        return view3;
    }

    public c(@Nullable Integer num) {
        this.bgId = num;
    }
}

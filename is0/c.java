package is0;

import android.view.View;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bH\u0016R\u0016\u0010\u000f\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lis0/c;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "Lcom/tencent/aio/base/mvvm/b;", "c1", "d", "Landroid/view/View;", "mRedPacketView", "<init>", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends com.tencent.aio.base.mvvm.a<ol3.b, MviUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mRedPacketView;

    private final void d1() {
        GuildLiveLogUtil.INSTANCE.e("MsgExt", "[onClickRedPacket] ");
        sendIntent(new a());
        View view = this.mRedPacketView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRedPacketView");
            view = null;
        }
        yr0.a.o("clck", view, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(c this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IGuildFastClickUtilApi iGuildFastClickUtilApi = (IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (!iGuildFastClickUtilApi.isFastClick(it)) {
            this$0.d1();
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        View view = this.mRedPacketView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRedPacketView");
            view = null;
        }
        yr0.a.q(view, "em_aio_red_package_icon", null, 4, null);
        View view2 = this.mRedPacketView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRedPacketView");
            view2 = null;
        }
        yr0.a.o("imp", view2, null, 4, null);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new d();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View findViewById = createViewParams.b().findViewById(R.id.wmz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "createViewParams.parent.\u2026id.guild_live_red_packet)");
        this.mRedPacketView = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRedPacketView");
            findViewById = null;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: is0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.e1(c.this, view);
            }
        });
        View view = this.mRedPacketView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRedPacketView");
            return null;
        }
        return view;
    }
}

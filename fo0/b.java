package fo0;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a \u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b\"\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "c", "Landroid/content/Context;", "context", "Landroid/view/View;", "clickedView", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "joinParam", "b", "a", "Z", "joinInvShowing", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f400131a;

    public static final boolean b(@NotNull Context context, @Nullable View view, @NotNull JumpGuildParam joinParam) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(joinParam, "joinParam");
        if (!((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).isGuest(joinParam.guildId)) {
            return false;
        }
        if (!f400131a) {
            String string = context.getResources().getString(R.string.f139200am);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026uild_aio_guust_join_tips)");
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).openJoinInvitationDialog(context, joinParam, string);
            f400131a = true;
            if (view != null) {
                view.postDelayed(new Runnable() { // from class: fo0.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.d();
                    }
                }, 200L);
            } else {
                f400131a = false;
            }
        }
        return true;
    }

    public static final boolean c(@Nullable com.tencent.aio.api.runtime.a aVar) {
        FragmentActivity activity;
        if (aVar != null && !com.tencent.guild.aio.util.ex.a.h(aVar)) {
            JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) aVar.g().l().getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
            int i3 = aVar.g().l().getInt(JumpGuildParam.EXTRA_KEY_OPEN_FROM);
            String f16 = com.tencent.guild.aio.util.ex.a.f(aVar);
            AIOParam g16 = aVar.g();
            Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
            JumpGuildParam jumpGuildParam = new JumpGuildParam(f16, com.tencent.guild.aio.util.a.b(g16), joinInfoParam);
            jumpGuildParam.extras.putInt(JumpGuildParam.EXTRA_KEY_OPEN_FROM, i3);
            Fragment c16 = aVar.c();
            if (c16 != null && (activity = c16.getActivity()) != null) {
                return b(activity, activity.getWindow().getDecorView(), jumpGuildParam);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        f400131a = false;
    }
}

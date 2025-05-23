package com.tencent.guild.aio.util.ex;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.monitor.trace.TraceTimeReport;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.appsetting.IAppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.nt.misc.api.IBeaconReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u001a\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/aio/data/AIOParam;", "aioParam", "Landroidx/fragment/app/FragmentManager;", "fm", "", "containerId", "Lcom/tencent/aio/api/perf/a;", "startUpTimeCallback", "Landroid/graphics/drawable/Drawable;", "background", "Lus/a;", "b", "", "a", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J4\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00032\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/guild/aio/util/ex/b$a", "Lcom/tencent/aio/monitor/trace/a;", "", "", "interestedIn", "()[Ljava/lang/String;", "tag", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements com.tencent.aio.monitor.trace.a {
        a() {
        }

        @Override // com.tencent.aio.monitor.trace.a
        public void a(@NotNull String tag, @NotNull HashMap<String, String> params) {
            HashMap hashMapOf;
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(params, "params");
            String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
            IBeaconReportApi iBeaconReportApi = (IBeaconReportApi) QRoute.api(IBeaconReportApi.class);
            hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair(tag, params.toString()));
            iBeaconReportApi.report(currentUin, "act_AIOCorePerf", hashMapOf, true);
        }

        @Override // com.tencent.aio.monitor.trace.a
        @NotNull
        public String[] interestedIn() {
            return new String[]{"AbsMsgListVB"};
        }
    }

    public static final void a() {
        boolean z16 = true;
        if (!((IAppSetting) QRoute.api(IAppSetting.class)).mo112public()) {
            TraceTimeReport.f69439e.d(true);
        } else {
            int nextInt = RandomKt.Random(0).nextInt(1000);
            TraceTimeReport traceTimeReport = TraceTimeReport.f69439e;
            if (nextInt != 666) {
                z16 = false;
            }
            traceTimeReport.d(z16);
        }
        TraceTimeReport.f69439e.a(new a());
    }

    @NotNull
    public static final us.a b(@NotNull AIOParam aioParam, @NotNull FragmentManager fm5, int i3, @Nullable com.tencent.aio.api.perf.a aVar, @Nullable Drawable drawable) {
        int i16;
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        Intrinsics.checkNotNullParameter(fm5, "fm");
        g12.b.f401087a.e(new g12.a(), ((IAppSetting) QRoute.api(IAppSetting.class)).mo112public(), ((IAppSetting) QRoute.api(IAppSetting.class)).gray(), ((IAppSetting) QRoute.api(IAppSetting.class)).debug());
        us.a c16 = com.tencent.aio.main.engine.b.f69377a.c(aioParam, fm5, i3, aVar);
        if (drawable != null) {
            c16.k(drawable);
        } else {
            Resources resources = BaseApplication.context.getResources();
            if (UIUtil.f112434a.A()) {
                i16 = R.drawable.skin_chat_background;
            } else {
                i16 = R.drawable.qui_common_bg_chat_bg;
            }
            Drawable drawable2 = ResourcesCompat.getDrawable(resources, i16, null);
            if (drawable2 != null) {
                c16.k(drawable2);
            }
        }
        a();
        return c16;
    }

    public static /* synthetic */ us.a c(AIOParam aIOParam, FragmentManager fragmentManager, int i3, com.tencent.aio.api.perf.a aVar, Drawable drawable, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = android.R.id.content;
        }
        if ((i16 & 8) != 0) {
            aVar = null;
        }
        if ((i16 & 16) != 0) {
            drawable = null;
        }
        return b(aIOParam, fragmentManager, i3, aVar, drawable);
    }
}

package com.tencent.robot.adelie.homepage.maintab;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.robot.adelie.homepage.maintab.b;
import com.tencent.robot.adelie.homepage.utils.n;
import com.tencent.robot.api.IRobotRouterApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002J\u0012\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00148\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/robot/adelie/homepage/maintab/PlusIconTab;", "Landroid/widget/FrameLayout;", "Lcom/tencent/robot/adelie/homepage/maintab/b;", "", "playNextTime", "", "c", "Landroid/content/Context;", "context", "a", "Lcom/tencent/robot/adelie/homepage/maintab/TabType;", "d", "Lcom/tencent/robot/adelie/homepage/maintab/TabType;", "type", "", "e", "Ljava/lang/Void;", "b", "()Ljava/lang/Void;", "fragment", "", "f", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "desc", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class PlusIconTab extends FrameLayout implements b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TabType type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Void fragment;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String desc;

    private final void c(boolean playNextTime) {
        String str;
        Context context = getContext();
        if (context != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("show_next_time", playNextTime);
            Unit unit = Unit.INSTANCE;
            l.e(context, "adelie_interrupt_guide_animation", jSONObject);
        }
        if (!playNextTime) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentUin();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_ADELIE);
            fromV2.remove("ADELIE_GUIDE_HAS_SHOWN_ANIMATION_" + str);
            fromV2.putString("ADELIE_GUIDE_HAS_SHOWN_ANIMATION_" + str, "true");
        }
    }

    static /* synthetic */ void d(PlusIconTab plusIconTab, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        plusIconTab.c(z16);
    }

    @Override // com.tencent.robot.adelie.homepage.maintab.b
    public void a(@NotNull Context context) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        b.C9756b.b(this, context);
        d(this, false, 1, null);
        ((IRobotRouterApi) QRoute.api(IRobotRouterApi.class)).launchScheme(context, n.f366680a.d("main_tab", ""));
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("tab_name", this.type.toReportValue()));
        VideoReport.reportEvent("clck", this, mapOf);
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public Void getFragment() {
        return this.fragment;
    }

    @Override // com.tencent.robot.adelie.homepage.maintab.b
    @NotNull
    public String getDesc() {
        return this.desc;
    }

    @Override // com.tencent.robot.adelie.homepage.maintab.b
    public /* bridge */ /* synthetic */ Fragment getFragment() {
        return (Fragment) getFragment();
    }

    @Override // com.tencent.robot.adelie.homepage.maintab.b
    public void setTabSelected(boolean z16) {
        b.C9756b.c(this, z16);
    }
}

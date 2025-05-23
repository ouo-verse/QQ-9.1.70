package kq2;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.cardcontainer.api.ICardContainerSwitchApi;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qq2.aa;
import qq2.ab;
import qq2.ag;
import qq2.ah;
import qq2.p;
import qq2.u;
import qq2.w;
import qq2.z;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0005H\u0016J\u0006\u0010\b\u001a\u00020\u0007J\"\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lkq2/c;", "Ljq2/c;", "", "e", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "", tl.h.F, "title", "Landroid/content/Context;", "context", "id", "", "f", "<init>", "()V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends jq2.c {
    @Override // jq2.c
    public ArrayList<jq2.c> c() {
        ArrayList<jq2.c> arrayList = new ArrayList<>();
        arrayList.add(new aa());
        arrayList.add(new qq2.c());
        if (!ElderModeManager.j()) {
            arrayList.add(new qq2.g());
        }
        arrayList.add(new qq2.f());
        arrayList.add(new u());
        arrayList.add(new ah());
        arrayList.add(new qq2.d());
        arrayList.add(new z());
        arrayList.add(new qq2.e());
        arrayList.add(new ab());
        arrayList.add(new p());
        if (h()) {
            arrayList.add(new w());
        }
        arrayList.add(new ag());
        return arrayList;
    }

    @Override // jq2.c
    /* renamed from: e */
    public String getDetailTitle() {
        return "\u901a\u7528";
    }

    @Override // jq2.c
    public void f(String title, Context context, String id5) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("setting_search_title", title);
        ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).startGeneralSettingFragmentPage(context, intent, 2004);
        QLog.d("AccountSafety", 2, "startRouteToPage ");
    }

    public final boolean h() {
        QRouteApi api = QRoute.api(ICardContainerSwitchApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ICardContainerSwitchApi::class.java)");
        ICardContainerSwitchApi iCardContainerSwitchApi = (ICardContainerSwitchApi) api;
        return iCardContainerSwitchApi.remoteShowCardContainerSwitch() && iCardContainerSwitchApi.getLocalCardContainerSwitchShowingState();
    }
}

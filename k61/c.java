package k61;

import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import j61.IntimateBaseModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\u000b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0014\u00a8\u0006\u000e"}, d2 = {"Lk61/c;", "Lk61/f;", "", "r", "Lj61/a;", "data", "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c extends f {
    private final void r() {
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_luckynumber", j61.d.f409515a.d(), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // k61.f, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: q */
    public void onBindData(@Nullable IntimateBaseModel data, int position, @Nullable List<Object> payload) {
        super.onBindData(data, position, payload);
        IntimateContentItemBaseView intimateBaseView = getIntimateBaseView();
        boolean z16 = false;
        if (intimateBaseView != null && intimateBaseView.isShown()) {
            z16 = true;
        }
        if (z16) {
            r();
        }
    }
}

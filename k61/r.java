package k61;

import android.view.View;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import j61.IntimateBaseModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J*\u0010\u000e\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0014\u00a8\u0006\u0011"}, d2 = {"Lk61/r;", "Lk61/d;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View;", "containerView", "onInitView", "Lj61/a;", "data", "", "position", "", "", "payload", "p", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class r extends d {
    private final void q() {
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_bas_mini_game_entry", j61.d.f409515a.d(), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable IntimateBaseModel data, int position, @Nullable List<Object> payload) {
        IntimateInfo intimateInfo;
        IntimatePlayTogetherMiniGameCardView intimatePlayTogetherMiniGameCardView;
        if (data != null && (intimateInfo = data.getIntimateInfo()) != null) {
            View view = this.mRootView;
            if (view instanceof IntimatePlayTogetherMiniGameCardView) {
                intimatePlayTogetherMiniGameCardView = (IntimatePlayTogetherMiniGameCardView) view;
            } else {
                intimatePlayTogetherMiniGameCardView = null;
            }
            if (intimatePlayTogetherMiniGameCardView != null) {
                intimatePlayTogetherMiniGameCardView.g(intimateInfo);
            }
        }
    }
}

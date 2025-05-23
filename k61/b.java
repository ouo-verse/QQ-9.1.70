package k61;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.activity.aio.intimate.view.ElegantNovelSpeciesView;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import j61.IntimateBaseModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J*\u0010\u000e\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lk61/b;", "Lk61/d;", "", "p", "Landroid/view/View;", "containerView", "onInitView", "Lj61/a;", "data", "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/activity/aio/intimate/view/ElegantNovelSpeciesView;", "e", "Lcom/tencent/mobileqq/activity/aio/intimate/view/ElegantNovelSpeciesView;", "elegantNovelSpeciesView", "", "f", "Ljava/lang/String;", "friendUin", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b extends d {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ElegantNovelSpeciesView elegantNovelSpeciesView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String friendUin = "";

    private final void p() {
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_newelement", j61.d.f409515a.d(), null);
    }

    @Override // k61.d, h61.a
    public void k() {
        ElegantNovelSpeciesView elegantNovelSpeciesView = this.elegantNovelSpeciesView;
        if (elegantNovelSpeciesView != null) {
            elegantNovelSpeciesView.o();
        }
    }

    @Override // k61.d, h61.a
    public void m() {
        ElegantNovelSpeciesView elegantNovelSpeciesView = this.elegantNovelSpeciesView;
        if (elegantNovelSpeciesView != null) {
            elegantNovelSpeciesView.n();
        }
    }

    @Override // k61.d, com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        ElegantNovelSpeciesView elegantNovelSpeciesView = this.elegantNovelSpeciesView;
        if (elegantNovelSpeciesView != null) {
            elegantNovelSpeciesView.m();
        }
        this.elegantNovelSpeciesView = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView instanceof ElegantNovelSpeciesView) {
            ElegantNovelSpeciesView elegantNovelSpeciesView = (ElegantNovelSpeciesView) containerView;
            this.elegantNovelSpeciesView = elegantNovelSpeciesView;
            if (elegantNovelSpeciesView != null) {
                elegantNovelSpeciesView.o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable IntimateBaseModel data, int position, @Nullable List<Object> payload) {
        if (data != null) {
            String friendUin = data.getFriendUin();
            this.friendUin = friendUin;
            ElegantNovelSpeciesView elegantNovelSpeciesView = this.elegantNovelSpeciesView;
            if (elegantNovelSpeciesView != null) {
                elegantNovelSpeciesView.t(friendUin);
            }
            ElegantNovelSpeciesView elegantNovelSpeciesView2 = this.elegantNovelSpeciesView;
            if (elegantNovelSpeciesView2 != null) {
                elegantNovelSpeciesView2.setFriendUin(data.getFriendUin());
            }
            ElegantNovelSpeciesView elegantNovelSpeciesView3 = this.elegantNovelSpeciesView;
            if (elegantNovelSpeciesView3 != null) {
                elegantNovelSpeciesView3.r(data.getIntimateInfo(), data.getFriendIntimateType());
            }
            p();
        }
    }
}

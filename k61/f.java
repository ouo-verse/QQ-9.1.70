package k61;

import android.view.View;
import androidx.annotation.CallSuper;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import j61.IntimateBaseModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J*\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0015J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lk61/f;", "Lk61/d;", "Landroid/view/View;", "containerView", "", "onInitView", "Lj61/a;", "data", "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/activity/aio/intimate/view/IntimateContentItemBaseView;", "e", "Lcom/tencent/mobileqq/activity/aio/intimate/view/IntimateContentItemBaseView;", "p", "()Lcom/tencent/mobileqq/activity/aio/intimate/view/IntimateContentItemBaseView;", "setIntimateBaseView", "(Lcom/tencent/mobileqq/activity/aio/intimate/view/IntimateContentItemBaseView;)V", "intimateBaseView", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public class f extends d {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IntimateContentItemBaseView intimateBaseView;

    @Override // k61.d, h61.a
    public void k() {
        IntimateContentItemBaseView intimateContentItemBaseView = this.intimateBaseView;
        if (intimateContentItemBaseView != null) {
            intimateContentItemBaseView.o();
        }
    }

    @Override // k61.d, h61.a
    public void m() {
        IntimateContentItemBaseView intimateContentItemBaseView = this.intimateBaseView;
        if (intimateContentItemBaseView != null) {
            intimateContentItemBaseView.n();
        }
    }

    @Override // k61.d, com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        IntimateContentItemBaseView intimateContentItemBaseView = this.intimateBaseView;
        if (intimateContentItemBaseView != null) {
            intimateContentItemBaseView.m();
        }
        this.intimateBaseView = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView instanceof IntimateContentItemBaseView) {
            IntimateContentItemBaseView intimateContentItemBaseView = (IntimateContentItemBaseView) containerView;
            this.intimateBaseView = intimateContentItemBaseView;
            if (intimateContentItemBaseView != null) {
                intimateContentItemBaseView.o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: p, reason: from getter */
    public final IntimateContentItemBaseView getIntimateBaseView() {
        return this.intimateBaseView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @CallSuper
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable IntimateBaseModel data, int position, @Nullable List<Object> payload) {
        if (data != null) {
            IntimateContentItemBaseView intimateContentItemBaseView = this.intimateBaseView;
            if (intimateContentItemBaseView != null) {
                intimateContentItemBaseView.setFriendUin(data.getFriendUin());
            }
            IntimateContentItemBaseView intimateContentItemBaseView2 = this.intimateBaseView;
            if (intimateContentItemBaseView2 != null) {
                intimateContentItemBaseView2.r(data.getIntimateInfo(), data.getFriendIntimateType());
            }
        }
    }
}

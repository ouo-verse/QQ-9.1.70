package k61;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import h61.b;
import j61.IntimateBaseModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b&\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016\u00a8\u0006\u0014"}, d2 = {"Lk61/d;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lj61/a;", "Lh61/a;", "Lh61/b;", "", "getViewStubLayoutId", "", "attached", "", "onAttachedChanged", NodeProps.VISIBLE, "onVisibleChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "d", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public abstract class d extends Section<IntimateBaseModel> implements h61.a, h61.b {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    public void k() {
        QLog.i("IntimateBaseSection", 1, "onDrawerOpened, hash=" + hashCode());
    }

    public void m() {
        QLog.i("IntimateBaseSection", 1, "onDrawerClosed, hash=" + hashCode());
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public final void onAttachedChanged(boolean attached) {
        QLog.i("IntimateBaseSection", 1, "onAttachedChanged attached=" + attached + ", hash=" + hashCode());
        if (attached) {
            h61.e eVar = h61.e.f404453a;
            eVar.f(this);
            eVar.e(this);
        } else {
            h61.e eVar2 = h61.e.f404453a;
            eVar2.g(this);
            eVar2.h(this);
        }
    }

    @Override // h61.b
    public boolean onBackEvent() {
        return b.a.a(this);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        h61.e eVar = h61.e.f404453a;
        eVar.g(this);
        eVar.h(this);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public final void onVisibleChanged(boolean visible) {
    }
}

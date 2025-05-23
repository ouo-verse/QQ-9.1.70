package n44;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"Ln44/f;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/robot/profile/data/g;", "", "getViewStubLayoutId", "", "attached", "", "onAttachedChanged", NodeProps.VISIBLE, "onVisibleChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", "d", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class f extends Section<com.tencent.robot.profile.data.g> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        QLog.i("RobotProfileBaseSection", 1, "onAttachedChanged attached=" + attached + ", hash=" + hashCode());
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        QLog.i("RobotProfileBaseSection", 1, "onDestroy, hash=" + hashCode());
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        QLog.i("RobotProfileBaseSection", 1, "onVisibleChanged visible=" + visible + ", hash=" + hashCode());
    }
}

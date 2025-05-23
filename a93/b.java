package a93;

import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\r"}, d2 = {"La93/b;", "Lcom/tencent/mobileqq/wink/newalbum/processor/b;", "", "g", DKHippyEvent.EVENT_STOP, "", "b", "()Ljava/lang/String;", "logTag", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class b extends com.tencent.mobileqq.wink.newalbum.processor.b {
    public b() {
        super(null, null, 3, null);
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    @NotNull
    public String b() {
        return super.b() + "WinkNewAlbumTerminatorProcessor";
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void g() {
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void onStop() {
    }
}

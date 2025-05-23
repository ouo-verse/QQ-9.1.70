package a93;

import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.model.MediaScanForwardResult;
import com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumContext;
import i83.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"La93/a;", "Lcom/tencent/mobileqq/wink/newalbum/processor/b;", "Lcom/tencent/mobileqq/wink/newalbum/processor/d;", "context", "", "a", "g", DKHippyEvent.EVENT_STOP, "Li83/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Li83/c;", "scanForwardListener", "<init>", "(Li83/c;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends com.tencent.mobileqq.wink.newalbum.processor.b {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c scanForwardListener;

    public a(@Nullable c cVar) {
        super(null, null, 3, null);
        this.scanForwardListener = cVar;
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b, com.tencent.mobileqq.wink.newalbum.processor.a
    public void a(@NotNull WinkNewAlbumContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        c cVar = this.scanForwardListener;
        if (cVar != null) {
            cVar.a(new MediaScanForwardResult(context.getMetaData().getPath(), context.getMetaData().getId(), context.getForwardResult().getPhotoFeature(), context.getMetaData().C(), context.getIsLast(), context.getMetaData().getWidth(), context.getMetaData().getHeight()));
        }
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void onStop() {
        this.scanForwardListener = null;
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void g() {
    }
}

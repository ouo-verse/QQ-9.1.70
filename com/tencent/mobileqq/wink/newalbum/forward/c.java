package com.tencent.mobileqq.wink.newalbum.forward;

import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumContext;
import com.tencent.qphone.base.util.QLog;
import e93.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0019\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0014\u0010\f\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/forward/c;", "Lcom/tencent/mobileqq/wink/newalbum/processor/b;", "", "j", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "Lz83/a;", "l", "g", DKHippyEvent.EVENT_STOP, "", s4.c.PICS, "k", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "getPics", "()Ljava/util/List;", "Lcom/tencent/mobileqq/wink/newalbum/processor/a;", "next", "", "traceId", "<init>", "(Lcom/tencent/mobileqq/wink/newalbum/processor/a;Ljava/lang/String;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c extends com.tencent.mobileqq.wink.newalbum.processor.b {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> pics;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@Nullable com.tencent.mobileqq.wink.newalbum.processor.a aVar, @NotNull String traceId) {
        super(aVar, traceId);
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        this.pics = new ArrayList();
    }

    private final void j() {
        Iterator<T> it = this.pics.iterator();
        while (it.hasNext()) {
            i(new WinkNewAlbumContext(l((LocalMediaInfo) it.next()), null, null, null, false, 0L, 0L, 0L, false, 0L, false, 0.0f, null, 8190, null));
        }
        i(new WinkNewAlbumContext(null, null, null, null, true, 0L, 0L, 0L, false, 0L, false, 0.0f, null, 8175, null));
    }

    private final z83.a l(LocalMediaInfo localMediaInfo) {
        int i3;
        z83.a aVar = new z83.a();
        String str = localMediaInfo.path;
        Intrinsics.checkNotNullExpressionValue(str, "localMediaInfo.path");
        aVar.P(str);
        aVar.S(localMediaInfo.modifiedDate * 1000);
        if (i.I(localMediaInfo)) {
            i3 = 2;
        } else if (i.F(localMediaInfo)) {
            i3 = 4;
        } else if (i.G(localMediaInfo)) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        aVar.N(i3);
        aVar.T((int) localMediaInfo.mDuration);
        aVar.U(localMediaInfo.mediaWidth);
        aVar.K(localMediaInfo.mediaHeight);
        aVar.O(localMediaInfo);
        return aVar;
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void g() {
        QLog.i("WinkNewAlbumForwardPreprocessor", 1, "onStart");
        j();
    }

    public final void k(@NotNull List<? extends LocalMediaInfo> pics) {
        Intrinsics.checkNotNullParameter(pics, "pics");
        this.pics.addAll(pics);
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void onStop() {
        QLog.i("WinkNewAlbumForwardPreprocessor", 1, DKHippyEvent.EVENT_STOP);
        this.pics.clear();
    }
}

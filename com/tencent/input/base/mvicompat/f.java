package com.tencent.input.base.mvicompat;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mvi.api.runtime.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/input/base/mvicompat/f;", "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "", "b", "(Lcom/tencent/mvi/api/runtime/b;Z)V", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public interface f<C extends com.tencent.mvi.api.runtime.b> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ void a(f fVar, com.tencent.mvi.api.runtime.b bVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                fVar.b(bVar, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCreate");
        }
    }

    void b(@NotNull C context, boolean reuse);

    void onDestroy();
}

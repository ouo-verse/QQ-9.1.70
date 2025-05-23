package com.tencent.mobileqq.wink.picker.core.viewmodel;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.picker.utils.PhotoListLogicPreDealDialog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH&J\u001a\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0004H&J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&J\b\u0010\u0013\u001a\u00020\u0002H&J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u0007H&J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/viewmodel/b;", "", "", "E0", "", "isError", "b0", "", "toCompressedMediaNum", "y0", "itemIndex", "", "progress", "e", "Lcom/tencent/mobileqq/wink/picker/utils/PhotoListLogicPreDealDialog$PreDealStep;", "step", "useVideoTemplate", "g0", "W0", "z0", "errorMsgResId", "l1", "i0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface b {
    void E0();

    void W0(float progress);

    void b0(boolean isError);

    void e(int itemIndex, float progress);

    void g0(@NotNull PhotoListLogicPreDealDialog.PreDealStep step, boolean useVideoTemplate);

    void i0(float progress);

    void l1(boolean isError, int errorMsgResId);

    void m(float progress);

    void y0(int toCompressedMediaNum);

    void z0();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, boolean z16, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                bVar.l1(z16, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopProcessMedia");
        }

        public static /* synthetic */ void c(b bVar, PhotoListLogicPreDealDialog.PreDealStep preDealStep, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                bVar.g0(preDealStep, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateProcessStep");
        }

        public static void b(@NotNull b bVar, float f16) {
        }
    }
}

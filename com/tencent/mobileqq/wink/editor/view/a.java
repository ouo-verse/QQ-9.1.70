package com.tencent.mobileqq.wink.editor.view;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J,\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H&J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/a;", "", "", "deltaX", "deltay", "", "c", "", "refreshPlayer", "scaleFromBorderView", "a", "changedOutsize", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.wink.editor.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C9048a {
        public static /* synthetic */ void a(a aVar, boolean z16, boolean z17, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z17 = true;
                }
                aVar.b(z16, z17);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onMovieAdjustWhenFinish");
        }

        public static /* synthetic */ void b(a aVar, float f16, float f17, boolean z16, boolean z17, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z16 = true;
                }
                if ((i3 & 8) != 0) {
                    z17 = true;
                }
                aVar.a(f16, f17, z16, z17);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onMovieScaleChange");
        }
    }

    void a(float deltaX, float deltay, boolean refreshPlayer, boolean scaleFromBorderView);

    void b(boolean changedOutsize, boolean refreshPlayer);

    void c(float deltaX, float deltay);
}

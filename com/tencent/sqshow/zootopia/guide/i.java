package com.tencent.sqshow.zootopia.guide;

import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002H&J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002H&J,\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/sqshow/zootopia/guide/i;", "", "", "sourceId", "groupId", "step", "", "b", "", "a", "skipAll", "c", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface i {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/guide/i$b;", "", "", "needGuide", "", "Lpv4/f;", "result", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void a(boolean needGuide, List<pv4.f> result);
    }

    boolean a(int sourceId, int groupId, int step);

    void b(int sourceId, int groupId, int step);

    void c(int sourceId, int groupId, int step, boolean skipAll);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class a {
        public static /* synthetic */ boolean a(i iVar, int i3, int i16, int i17, int i18, Object obj) {
            if (obj == null) {
                if ((i18 & 4) != 0) {
                    i17 = 1;
                }
                return iVar.a(i3, i16, i17);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closeGuideTask");
        }

        public static /* synthetic */ void b(i iVar, int i3, int i16, int i17, int i18, Object obj) {
            if (obj == null) {
                if ((i18 & 4) != 0) {
                    i17 = 1;
                }
                iVar.b(i3, i16, i17);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishGuideTask");
        }

        public static /* synthetic */ void c(i iVar, int i3, int i16, int i17, boolean z16, int i18, Object obj) {
            if (obj == null) {
                if ((i18 & 4) != 0) {
                    i17 = 1;
                }
                if ((i18 & 8) != 0) {
                    z16 = false;
                }
                iVar.c(i3, i16, i17, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: skipGuideTask");
        }
    }
}

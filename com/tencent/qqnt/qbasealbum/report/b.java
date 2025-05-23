package com.tencent.qqnt.qbasealbum.report;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/report/b;", "", "", "u3", "", "duration", "onPageOut", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, long j3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    j3 = 0;
                }
                bVar.onPageOut(j3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPageOut");
        }
    }

    void onPageOut(long duration);

    void u3();
}

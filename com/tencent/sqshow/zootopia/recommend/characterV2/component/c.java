package com.tencent.sqshow.zootopia.recommend.characterV2.component;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H&J$\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/c;", "", "", "withAnim", "Lkotlin/Function0;", "", "callback", "g", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface c {
    void A(boolean withAnim, Function0<Unit> callback);

    void g(boolean withAnim, Function0<Unit> callback);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(c cVar, boolean z16, Function0 function0, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                if ((i3 & 2) != 0) {
                    function0 = null;
                }
                cVar.A(z16, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideMidView");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(c cVar, boolean z16, Function0 function0, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                if ((i3 & 2) != 0) {
                    function0 = null;
                }
                cVar.g(z16, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMidView");
        }
    }
}

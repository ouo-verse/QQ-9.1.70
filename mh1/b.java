package mh1;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProSourceInfoBid;
import com.tencent.mobileqq.qqguildsdk.data.genc.t;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lmh1/b;", "", "", "pageFrom", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/t;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f416778a = new b();

    b() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0046, code lost:
    
        return r0;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final t a(int pageFrom) {
        t tVar = new t();
        switch (pageFrom) {
            case 0:
                tVar.d(GGProSourceInfoBid.PD_DISCOVER);
                tVar.e(10);
                break;
            case 1:
                tVar.d(GGProSourceInfoBid.OA_RECOMMEND);
                tVar.e(7);
                break;
            case 2:
                tVar.d(GGProSourceInfoBid.PD_DISCOVER);
                tVar.e(13);
                break;
            case 3:
                tVar.d(GGProSourceInfoBid.PD_DISCOVER);
                tVar.e(12);
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
                tVar.d(GGProSourceInfoBid.CHANNEL);
                tVar.e(14);
                break;
            case 8:
                tVar.d(GGProSourceInfoBid.PD_DISCOVER);
                tVar.e(16);
                break;
        }
    }
}

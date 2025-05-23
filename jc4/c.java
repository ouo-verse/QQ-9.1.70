package jc4;

import com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsListData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\r"}, d2 = {"Ljc4/c;", "", "", "uin", "", "pageInfo", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/h;", "callback", "", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"jc4/c$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Liw4/f;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.api.e<iw4.f> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<ZootopiaDetailFeedsListData> f409799d;

        a(com.tencent.mobileqq.zootopia.api.e<ZootopiaDetailFeedsListData> eVar) {
            this.f409799d = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(iw4.f result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.f409799d.onResultSuccess(ZootopiaDetailFeedsListData.INSTANCE.c(result));
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            this.f409799d.onResultFailure(error, message);
        }
    }

    public final void a(long uin, byte[] pageInfo, com.tencent.mobileqq.zootopia.api.e<ZootopiaDetailFeedsListData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        iw4.e eVar = new iw4.e();
        eVar.f408882a = uin;
        eVar.f408883b = pageInfo;
        yb4.a.d(yb4.a.f450048a, eVar, new a(callback), 0, 4, null);
    }
}

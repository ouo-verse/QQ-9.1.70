package p84;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.t;
import com.tencent.util.QQToastUtil;
import iw4.m;
import iw4.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pu4.l;
import pu4.s;
import su4.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004J\u0017\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a8\u0006\u0019"}, d2 = {"Lp84/a;", "", "", "id", "", "type", "originalPraiseNum", "Lcom/tencent/mobileqq/zootopia/api/e;", "Liw4/n;", "callback", "", "d", "", "uin", "currentRelation", "a", "relationType", "", "c", "(Ljava/lang/Integer;)Z", "Lpu4/n;", "dressFeedsInfo", "b", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f425784a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"p84/a$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lsu4/h;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: p84.a$a, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public static final class C10990a implements e<h> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f425785d;

        C10990a(String str) {
            this.f425785d = str;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(h result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ZootopiaDressCardHelper", 1, this.f425785d + " - onResultSuccess - " + result.f434790a);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("ZootopiaDressCardHelper", 1, this.f425785d + " - onResultFailure - " + error + " - " + message);
            if (error == 9200010 && !TextUtils.isEmpty(message)) {
                QQToastUtil.showQQToast(0, message);
            } else {
                QQToastUtil.showQQToast(0, R.string.xi6);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"p84/a$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Liw4/n;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements e<n> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f425786d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e<n> f425787e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f425788f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f425789h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f425790i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ m f425791m;

        b(String str, e<n> eVar, String str2, int i3, int i16, m mVar) {
            this.f425786d = str;
            this.f425787e = eVar;
            this.f425788f = str2;
            this.f425789h = i3;
            this.f425790i = i16;
            this.f425791m = mVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(n result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ZootopiaDressCardHelper", 1, this.f425786d + " - onResultSuccess, serverPraiseNum= " + result.f408905a);
            e<n> eVar = this.f425787e;
            if (eVar != null) {
                eVar.onResultSuccess(result);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZootopiaDressCardHelper", 1, this.f425786d + " - onResultFailure - " + error + " - " + message);
            if (!TextUtils.isEmpty(message)) {
                QQToastUtil.showQQToast(0, message == null ? "" : message);
                kb4.a.f411993a.f(this.f425788f, 5, Integer.valueOf(this.f425789h), Boolean.valueOf(this.f425790i != 0));
            }
            kb4.a aVar = kb4.a.f411993a;
            String str = this.f425791m.f408903a;
            Intrinsics.checkNotNullExpressionValue(str, "req.id");
            aVar.c(str, error);
            e<n> eVar = this.f425787e;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
        }
    }

    a() {
    }

    public final void a(long uin, int currentRelation) {
        hc4.a.f404730a.f(uin, currentRelation, new C10990a("clickFollowUser_" + uin + "_" + currentRelation));
    }

    public final boolean b(pu4.n dressFeedsInfo) {
        if (dressFeedsInfo == null) {
            return false;
        }
        try {
            l lVar = dressFeedsInfo.f427499b;
            String str = lVar != null ? lVar.f427476a : null;
            s sVar = dressFeedsInfo.f427500c;
            String str2 = sVar != null ? sVar.f427519b : null;
            String str3 = str + "\n" + str2 + "  " + t.f373300a.a(lVar != null ? lVar.f427478c : 0L);
            QLog.i("ZootopiaDressCardHelper", 1, "debugCopyFeedInfo -  " + str3);
            t74.b.a(BaseApplication.context, str3);
            QQToastUtil.showQQToast(0, "\u5df2\u590d\u5236\u5230\u526a\u8d34\u677f\n" + str3);
            return true;
        } catch (Exception e16) {
            QLog.e("ZootopiaDressCardHelper", 1, "debugCopyFeedInfo - exception", e16);
            return false;
        }
    }

    public final void d(String id5, int type, int originalPraiseNum, e<n> callback) {
        Intrinsics.checkNotNullParameter(id5, "id");
        m mVar = new m();
        mVar.f408903a = id5;
        mVar.f408904b = type;
        yb4.b.d(yb4.b.f450051a, mVar, new b("sendLikePradiseRequest, opLike_" + type + "_" + id5, callback, id5, originalPraiseNum, type, mVar), 0, 4, null);
    }

    public final boolean c(Integer relationType) {
        if (relationType != null && relationType.intValue() == 1) {
            return true;
        }
        return relationType != null && relationType.intValue() == 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(a aVar, String str, int i3, int i16, e eVar, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            eVar = null;
        }
        aVar.d(str, i3, i16, eVar);
    }
}

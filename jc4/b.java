package jc4;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsListData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import pv4.r;
import pv4.s;
import pv4.t;
import pv4.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\rR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Ljc4/b;", "", "", "error", "", "message", "", "d", "Law4/b;", "result", "e", "Lpv4/s;", "workData", "", "productId", "f", "uin", "g", "Landroidx/lifecycle/MutableLiveData;", "Ljc4/f;", "a", "Landroidx/lifecycle/MutableLiveData;", "c", "()Landroidx/lifecycle/MutableLiveData;", "mDataList", "<init>", "()V", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<UserCenterReqData> mDataList = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"jc4/b$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Law4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: jc4.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10580b implements com.tencent.mobileqq.zootopia.api.e<aw4.b> {
        C10580b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(aw4.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            b.this.e(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            b.this.d(error, message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(int error, String message) {
        QLog.e("UserCenterDataFetcher_", 1, "onReqFailed error:" + error + ", message:" + message);
        this.mDataList.postValue(new UserCenterReqData(error, message, false, new ArrayList(), null));
    }

    private final void f(s workData, long productId) {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(String.valueOf(productId));
            JSONArray a16 = kc4.a.f412032a.a(jSONArray);
            if (a16.length() <= 0) {
                QLog.e("UserCenterDataFetcher_", 1, " polish draft data fail!!! " + jSONArray);
                return;
            }
            Object obj = a16.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
            String optString = ((JSONObject) obj).optString("icon");
            if (TextUtils.isEmpty(optString)) {
                QLog.e("UserCenterDataFetcher_", 1, "modify draft data fail as url is empty " + a16);
                return;
            }
            pu4.g gVar = workData.f427681b;
            if (gVar == null) {
                gVar = new pu4.g();
            }
            gVar.f427435b = "png";
            gVar.f427434a = optString;
            workData.f427681b = gVar;
            QLog.d("UserCenterDataFetcher_", 1, " polish draft data : " + a16 + " " + optString);
        } catch (Exception e16) {
            QLog.e("UserCenterDataFetcher_", 1, " polish draft data error: " + e16);
        }
    }

    public final MutableLiveData<UserCenterReqData> c() {
        return this.mDataList;
    }

    public final void g(long uin) {
        aw4.a aVar = new aw4.a();
        aVar.f27087a = uin;
        QLog.i("UserCenterDataFetcher_", 1, "request uin:" + uin);
        d.b(d.f409800a, aVar, new C10580b(), 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(aw4.b result) {
        boolean z16;
        int i3;
        QLog.i("UserCenterDataFetcher_", 1, "onReqSucceed ");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UserCenterCardData(202230, result.f27088a, null, null, null, 28, null));
        t[] tVarArr = result.f27089b;
        Intrinsics.checkNotNullExpressionValue(tVarArr, "result.groupList");
        r rVar = null;
        for (t tVar : tVarArr) {
            r[] rVarArr = tVar.f427699d;
            Intrinsics.checkNotNullExpressionValue(rVarArr, "group.list");
            int length = rVarArr.length;
            int i16 = 0;
            while (i16 < length) {
                r listItem = rVarArr[i16];
                if (listItem.f427657a == 28) {
                    rVar = listItem;
                    i3 = i16;
                } else {
                    ZootopiaCardData.Companion companion = ZootopiaCardData.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(listItem, "listItem");
                    i3 = i16;
                    arrayList.add(new UserCenterCardData(k84.b.INSTANCE.a(listItem.f427657a), null, null, null, ZootopiaCardData.Companion.b(companion, listItem, null, i3, 0, null, 24, null), 14, null));
                }
                i16 = i3 + 1;
            }
        }
        QLog.i("UserCenterDataFetcher_", 1, "onReqSucceed personInfo:" + result.f27088a);
        QLog.i("UserCenterDataFetcher_", 1, "onReqSucceed worksData:" + rVar);
        if (rVar == null) {
            QLog.e("UserCenterDataFetcher_", 1, "onReqSucceed worksData is null!");
            arrayList.add(new UserCenterCardData(202233, null, null, null, null, 30, null));
        } else {
            u uVar = rVar.f427659c;
            if (uVar == null) {
                uVar = new u();
            }
            u uVar2 = rVar.f427660d;
            if (uVar2 == null) {
                uVar2 = new u();
            }
            arrayList.add(new UserCenterCardData(202231, null, new UserCenterTitleCardData(uVar, uVar2), null, null, 26, null));
            s[] sVarArr = rVar.f427671o;
            if (sVarArr != null) {
                if (!(sVarArr.length == 0)) {
                    z16 = false;
                    if (!z16) {
                        arrayList.add(new UserCenterCardData(202233, null, null, null, null, 30, null));
                    } else {
                        int length2 = sVarArr.length;
                        int i17 = 0;
                        while (i17 < length2) {
                            s detail = rVar.f427671o[i17];
                            if (i17 == 0 && result.f27090c > 0) {
                                Intrinsics.checkNotNullExpressionValue(detail, "detail");
                                f(detail, result.f27090c);
                            }
                            aw4.c[] cVarArr = result.f27091d;
                            arrayList.add(new UserCenterCardData(202232, null, null, new UserWorkItemData(detail, (cVarArr != null ? cVarArr.length : 0) > i17 ? cVarArr[i17] : null), null, 22, null));
                            i17++;
                        }
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        iw4.f fVar = result.f27092e;
        UserCenterReqData userCenterReqData = new UserCenterReqData(0, "", result.f27094g != 0, arrayList, fVar != null ? ZootopiaDetailFeedsListData.INSTANCE.c(fVar) : null);
        QLog.i("UserCenterDataFetcher_", 1, "onReqSucceed dataList size:" + arrayList.size());
        this.mDataList.postValue(userCenterReqData);
    }
}

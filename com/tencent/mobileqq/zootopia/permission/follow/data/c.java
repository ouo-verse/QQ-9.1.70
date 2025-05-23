package com.tencent.mobileqq.zootopia.permission.follow.data;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.util.QLog;
import hu4.d;
import hu4.g;
import hu4.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0004\u001a\u00020\u0003J\u0016\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zootopia/permission/follow/data/c;", "Lcom/tencent/mobileqq/mvvm/c;", "Lcom/tencent/mobileqq/zootopia/permission/follow/data/b;", "", "M1", "Lhu4/g;", "newPrivacyInfo", "oldPrivacyInfo", "N1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/zootopia/permission/follow/data/a;", "i", "Landroidx/lifecycle/MutableLiveData;", "L1", "()Landroidx/lifecycle/MutableLiveData;", "privacyData", "repository", "<init>", "(Lcom/tencent/mobileqq/zootopia/permission/follow/data/b;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c extends com.tencent.mobileqq.mvvm.c<com.tencent.mobileqq.zootopia.permission.follow.data.b> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<a> privacyData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/permission/follow/data/c$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lhu4/d;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements e<d> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(d result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.d("PrivacyViewModel", 4, "getPrivacyData onResultSuccess result.privacyInfo = " + result.f406346a);
            if (result.f406346a != null) {
                MutableLiveData<a> L1 = c.this.L1();
                RequestState requestState = RequestState.GET_SUCCESS;
                g gVar = result.f406346a;
                Intrinsics.checkNotNullExpressionValue(gVar, "result.privacyInfo");
                L1.postValue(new a(requestState, gVar, 0, ""));
                return;
            }
            c.this.L1().postValue(new a(RequestState.GET_FAILED, new g(), 0, "privacyInfo is null"));
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.d("PrivacyViewModel", 4, "getPrivacyData onResultFailure error=" + error + ", message=" + message);
            MutableLiveData<a> L1 = c.this.L1();
            RequestState requestState = RequestState.GET_FAILED;
            g gVar = new g();
            if (message == null) {
                message = "";
            }
            L1.postValue(new a(requestState, gVar, error, message));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/permission/follow/data/c$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lhu4/k;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.permission.follow.data.c$c, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C9115c implements e<k> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g f328663e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f328664f;

        C9115c(g gVar, g gVar2) {
            this.f328663e = gVar;
            this.f328664f = gVar2;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(k result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.d("PrivacyViewModel", 4, "setPrivacyData onResultSuccess result.code = " + result.f406383a);
            if (result.f406383a == 0) {
                c.this.L1().postValue(new a(RequestState.SET_SUCCESS, this.f328663e, 0, ""));
            } else {
                c.this.L1().postValue(new a(RequestState.SET_FAILED, this.f328664f, result.f406383a, ""));
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.d("PrivacyViewModel", 4, "setPrivacyData onResultFailure error=" + error + ", message=" + message);
            MutableLiveData<a> L1 = c.this.L1();
            RequestState requestState = RequestState.SET_FAILED;
            g gVar = this.f328664f;
            if (message == null) {
                message = "";
            }
            L1.postValue(new a(requestState, gVar, error, message));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(com.tencent.mobileqq.zootopia.permission.follow.data.b repository) {
        super(repository);
        Intrinsics.checkNotNullParameter(repository, "repository");
        MutableLiveData<a> mutableLiveData = new MutableLiveData<>();
        this.privacyData = mutableLiveData;
        mutableLiveData.postValue(new a(RequestState.INIT, new g(), 0, ""));
    }

    public final MutableLiveData<a> L1() {
        return this.privacyData;
    }

    public final void N1(g newPrivacyInfo, g oldPrivacyInfo) {
        Intrinsics.checkNotNullParameter(newPrivacyInfo, "newPrivacyInfo");
        Intrinsics.checkNotNullParameter(oldPrivacyInfo, "oldPrivacyInfo");
        QLog.d("PrivacyViewModel", 4, "setPrivacyData");
        this.privacyData.postValue(new a(RequestState.LOADING, oldPrivacyInfo, 0, ""));
        getRepository().k(newPrivacyInfo, new C9115c(newPrivacyInfo, oldPrivacyInfo));
    }

    public final void M1() {
        QLog.d("PrivacyViewModel", 4, "getPrivacyData");
        this.privacyData.postValue(new a(RequestState.LOADING, new g(), 0, ""));
        getRepository().j(0, new b());
    }
}

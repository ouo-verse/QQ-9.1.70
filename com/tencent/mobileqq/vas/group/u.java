package com.tencent.mobileqq.vas.group;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.data.SmallHomeInfo;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000e\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/vas/group/u;", "Lcom/tencent/mobileqq/mvvm/c;", "Lcom/tencent/mobileqq/vas/group/t;", "", "P1", "", "uin", "O1", "Q1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/vas/data/d;", "i", "Landroidx/lifecycle/MutableLiveData;", "M1", "()Landroidx/lifecycle/MutableLiveData;", "smallHomeInfo", "Lcom/tencent/sqshow/zootopia/data/m;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "L1", "detail", "Lcom/tencent/mobileqq/vas/data/e;", BdhLogUtil.LogTag.Tag_Conn, "N1", "smallHomePageInfo", "repository", "<init>", "(Lcom/tencent/mobileqq/vas/group/t;)V", "D", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class u extends com.tencent.mobileqq.mvvm.c<t> {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<com.tencent.mobileqq.vas.data.e> smallHomePageInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<SmallHomeInfo> smallHomeInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<ZootopiaMapDetail> detail;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(t repository) {
        super(repository);
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.smallHomeInfo = new MutableLiveData<>();
        this.detail = new MutableLiveData<>();
        this.smallHomePageInfo = new MutableLiveData<>();
    }

    public final MutableLiveData<ZootopiaMapDetail> L1() {
        return this.detail;
    }

    public final MutableLiveData<SmallHomeInfo> M1() {
        return this.smallHomeInfo;
    }

    public final MutableLiveData<com.tencent.mobileqq.vas.data.e> N1() {
        return this.smallHomePageInfo;
    }

    public final void O1(long uin) {
        getRepository().j(uin, new b());
    }

    public final void P1() {
        getRepository().k(new c());
    }

    public final void Q1(long uin) {
        getRepository().l(uin, new d());
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vas/group/u$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/vas/data/d;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<SmallHomeInfo> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(SmallHomeInfo result) {
            Intrinsics.checkNotNullParameter(result, "result");
            u.this.M1().postValue(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vas/group/u$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/m;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<ZootopiaMapDetail> {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaMapDetail result) {
            Intrinsics.checkNotNullParameter(result, "result");
            u.this.L1().postValue(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vas/group/u$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/vas/data/e;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<com.tencent.mobileqq.vas.data.e> {
        d() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(com.tencent.mobileqq.vas.data.e result) {
            Intrinsics.checkNotNullParameter(result, "result");
            u.this.N1().postValue(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
        }
    }
}

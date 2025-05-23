package fb4;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsListData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u0007R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\u00a8\u0006\""}, d2 = {"Lfb4/b;", "Lcom/tencent/mobileqq/mvvm/c;", "Lfb4/a;", "", "workId", "feedId", "uin", "", "isRefresh", "", "O1", "", "pageInfo", "P1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/sqshow/zootopia/data/h;", "i", "Landroidx/lifecycle/MutableLiveData;", "M1", "()Landroidx/lifecycle/MutableLiveData;", "listData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "N1", "listMoreData", "Lcom/tencent/sqshow/zootopia/data/a;", BdhLogUtil.LogTag.Tag_Conn, "L1", "errorMessage", "repository", "<init>", "(Lfb4/a;)V", "D", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends com.tencent.mobileqq.mvvm.c<a> {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<ErrorMessage> errorMessage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<ZootopiaDetailFeedsListData> listData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<ZootopiaDetailFeedsListData> listMoreData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lfb4/b$b;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "a", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "<init>", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fb4.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10298b implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final ZootopiaSource source;

        public C10298b(ZootopiaSource source) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            if (modelClass.isAssignableFrom(b.class)) {
                return new b(new a(this.source));
            }
            throw new IllegalArgumentException("unknown class name");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"fb4/b$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/h;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements e<ZootopiaDetailFeedsListData> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f398244d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f398245e;

        c(boolean z16, b bVar) {
            this.f398244d = z16;
            this.f398245e = bVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaDetailFeedsListData result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.d("ZplanDressDetailViewModel", 1, "onResultSuccess, result:" + result);
            result.g(this.f398244d);
            this.f398245e.M1().postValue(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.d("ZplanDressDetailViewModel", 1, "onResultFailure, error:" + error + ", message:" + message);
            this.f398245e.L1().postValue(new ErrorMessage(error, message));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"fb4/b$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/h;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class d implements e<ZootopiaDetailFeedsListData> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f398246d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f398247e;

        d(boolean z16, b bVar) {
            this.f398246d = z16;
            this.f398247e = bVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaDetailFeedsListData result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.d("ZplanDressDetailViewModel", 1, "onResultSuccess, result:" + result);
            result.g(this.f398246d);
            this.f398247e.N1().postValue(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.d("ZplanDressDetailViewModel", 1, "onResultFailure, error:" + error + ", message:" + message);
            this.f398247e.L1().postValue(new ErrorMessage(error, message));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a repository) {
        super(repository);
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.listData = new MutableLiveData<>();
        this.listMoreData = new MutableLiveData<>();
        this.errorMessage = new MutableLiveData<>();
    }

    public final MutableLiveData<ErrorMessage> L1() {
        return this.errorMessage;
    }

    public final MutableLiveData<ZootopiaDetailFeedsListData> M1() {
        return this.listData;
    }

    public final MutableLiveData<ZootopiaDetailFeedsListData> N1() {
        return this.listMoreData;
    }

    public final void O1(String workId, String feedId, String uin, boolean isRefresh) {
        Intrinsics.checkNotNullParameter(workId, "workId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(uin, "uin");
        getRepository().j(workId, feedId, uin, new c(isRefresh, this));
    }

    public final void P1(byte[] pageInfo, boolean isRefresh) {
        QLog.d("ZplanDressDetailViewModel", 1, "loadNextPageDetailData, pageInfo\uff1a" + pageInfo);
        getRepository().k(pageInfo, new d(isRefresh, this));
    }
}

package dc4;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskBlindBoxData;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskDailyRewardData;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskItemData;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskSystemMainData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0004\u001a\u00020\u0003R\u001f\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001f\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00058\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\nR%\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\nR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0017\u0010\n\u00a8\u0006\u001f"}, d2 = {"Ldc4/h;", "Lcom/tencent/mobileqq/mvvm/c;", "Ldc4/b;", "", "P1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/sqshow/zootopia/data/u;", "i", "Landroidx/lifecycle/MutableLiveData;", "M1", "()Landroidx/lifecycle/MutableLiveData;", "dailyRewardData", "Lcom/tencent/sqshow/zootopia/data/s;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "L1", "blindBoxData", "", "Lcom/tencent/sqshow/zootopia/data/v;", BdhLogUtil.LogTag.Tag_Conn, "O1", "taskList", "Lcom/tencent/sqshow/zootopia/data/a;", "D", "N1", "errorMessage", "repository", "<init>", "(Ldc4/b;)V", "E", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class h extends com.tencent.mobileqq.mvvm.c<dc4.b> {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<List<ZootopiaTaskItemData>> taskList;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<ErrorMessage> errorMessage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<ZootopiaTaskDailyRewardData> dailyRewardData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<ZootopiaTaskBlindBoxData> blindBoxData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Ldc4/h$b;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/tencent/common/app/AppInterface;", "a", "Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "b", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "<init>", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final AppInterface app;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final ZootopiaSource source;

        public b(AppInterface app, ZootopiaSource source) {
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(source, "source");
            this.app = app;
            this.source = source;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            if (modelClass.isAssignableFrom(h.class)) {
                return new h(new dc4.b(this.source));
            }
            throw new IllegalArgumentException("unknown class name");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"dc4/h$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/y;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<ZootopiaTaskSystemMainData> {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaTaskSystemMainData result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ZplanTaskSystemViewModel", 1, "getLeYuanTask - onResultSuccess,data" + result);
            h.this.M1().postValue(result.getDailyRewardData());
            h.this.L1().postValue(result.getBlindBoxData());
            h.this.O1().postValue(result.c());
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("ZplanTaskSystemViewModel", 1, "getLeYuanTask - onResultFailure, message" + message + ", error" + error);
            h.this.N1().postValue(new ErrorMessage(error, message));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(dc4.b repository) {
        super(repository);
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.dailyRewardData = new MutableLiveData<>();
        this.blindBoxData = new MutableLiveData<>();
        this.taskList = new MutableLiveData<>();
        this.errorMessage = new MutableLiveData<>();
    }

    public final MutableLiveData<ZootopiaTaskBlindBoxData> L1() {
        return this.blindBoxData;
    }

    public final MutableLiveData<ZootopiaTaskDailyRewardData> M1() {
        return this.dailyRewardData;
    }

    public final MutableLiveData<ErrorMessage> N1() {
        return this.errorMessage;
    }

    public final MutableLiveData<List<ZootopiaTaskItemData>> O1() {
        return this.taskList;
    }

    public final void P1() {
        getRepository().d(1L, new c());
    }
}

package g84;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r84.ZootopiaBrandMallItemData;
import r84.ZootopiaBrandMallListData;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0016\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R#\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\f8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\u001b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006!"}, d2 = {"Lg84/d;", "Lcom/tencent/mobileqq/mvvm/c;", "Lg84/b;", "Lr84/b;", "result", "", "Lr84/a;", "N1", "", "isFirstRequest", "", "O1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/sqshow/zootopia/data/a;", "i", "Landroidx/lifecycle/MutableLiveData;", "Q1", "()Landroidx/lifecycle/MutableLiveData;", "topRefreshErrorMessage", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getLoadMoreErrorMessage", "loadMoreErrorMessage", BdhLogUtil.LogTag.Tag_Conn, "P1", "dataList", "D", "Z", "isListEnd", "repository", "<init>", "(Lg84/b;)V", "E", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class d extends com.tencent.mobileqq.mvvm.c<g84.b> {

    /* renamed from: E, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String F = "ZplanBrandStoreViewModel";

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<List<ZootopiaBrandMallItemData>> dataList;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isListEnd;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<ErrorMessage> topRefreshErrorMessage;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<ErrorMessage> loadMoreErrorMessage;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lg84/d$a;", "", "", "TAG", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: g84.d$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return d.F;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"g84/d$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lr84/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements e<ZootopiaBrandMallListData> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaBrandMallListData result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i(d.INSTANCE.a(), 1, "getBrandMallInfoListFromCache - onResultSuccess");
            d.this.P1().postValue(d.this.N1(result));
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i(d.INSTANCE.a(), 1, "getBrandMallInfoListFromCache - onResultFailure - " + error);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"g84/d$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lr84/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements e<ZootopiaBrandMallListData> {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaBrandMallListData result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i(d.INSTANCE.a(), 1, "getBrandMallInfoList Net - onResultSuccess");
            d.this.P1().postValue(d.this.N1(result));
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            d.this.Q1().postValue(new ErrorMessage(error, message));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(g84.b repository) {
        super(repository);
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.topRefreshErrorMessage = new MutableLiveData<>();
        this.loadMoreErrorMessage = new MutableLiveData<>();
        this.dataList = new MutableLiveData<>();
        this.isListEnd = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ZootopiaBrandMallItemData> N1(ZootopiaBrandMallListData result) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        if (!result.a().isEmpty()) {
            Iterator<T> it = result.a().iterator();
            while (it.hasNext()) {
                arrayList.add(new ZootopiaBrandMallItemData((ZootopiaCardData) it.next(), null, 0));
            }
        }
        if (!result.b().isEmpty()) {
            arrayList.add(new ZootopiaBrandMallItemData(new ZootopiaCardData(0, 202204, 0, 0, null, result.getTitleData(), null, null, null, null, null, 0, null, null, null, 31744, null), null, 0));
            for (Object obj : result.b()) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(new ZootopiaBrandMallItemData(null, (pu4.b) obj, i3));
                i3 = i16;
            }
        }
        return arrayList;
    }

    public final MutableLiveData<List<ZootopiaBrandMallItemData>> P1() {
        return this.dataList;
    }

    public final MutableLiveData<ErrorMessage> Q1() {
        return this.topRefreshErrorMessage;
    }

    public void O1(boolean isFirstRequest) {
        if (isFirstRequest) {
            QLog.i(F, 1, "getBrandMallInfoListFromCache ");
            getRepository().m(new b());
        }
        getRepository().l(true, new c());
    }
}

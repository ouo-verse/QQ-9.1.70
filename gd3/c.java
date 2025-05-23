package gd3;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.data.ZootopiaMainRecommendListData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\b\u0016\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B\u000f\u0012\u0006\u0010-\u001a\u00020\u0002\u00a2\u0006\u0004\b.\u0010/J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0012\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0016R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00108\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00108\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015R\"\u0010\"\u001a\u00020\r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010,\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u00062"}, d2 = {"Lgd3/c;", "Lcom/tencent/mobileqq/mvvm/c;", "Lgd3/b;", "", "param", "", "S1", "", "type", "T1", "", "Lcom/tencent/sqshow/zootopia/data/c;", "Q1", "", "W1", "L1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/sqshow/zootopia/data/a;", "i", "Landroidx/lifecycle/MutableLiveData;", "P1", "()Landroidx/lifecycle/MutableLiveData;", "errorMessage", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "O1", "cardList", BdhLogUtil.LogTag.Tag_Conn, "R1", "redMapId", "D", "N1", "bagRedMapId", "E", "Z", "isCardListEnd", "()Z", "setCardListEnd", "(Z)V", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "getPageParam", "()Ljava/lang/String;", "setPageParam", "(Ljava/lang/String;)V", "pageParam", "repository", "<init>", "(Lgd3/b;)V", "G", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class c extends com.tencent.mobileqq.mvvm.c<gd3.b> {
    private static final String H = "ZplanCardFeedsViewModel";

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<Integer> redMapId;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<Integer> bagRedMapId;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isCardListEnd;

    /* renamed from: F, reason: from kotlin metadata */
    private String pageParam;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<ErrorMessage> errorMessage;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<ZootopiaCardData>> cardList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"gd3/c$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/k;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements e<ZootopiaMainRecommendListData> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaMainRecommendListData result) {
            Intrinsics.checkNotNullParameter(result, "result");
            c.this.O1().postValue(result.b());
            c.this.R1().postValue(Integer.valueOf(result.getMailReddotId()));
            c.this.N1().postValue(Integer.valueOf(result.getBagReddotId()));
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            c.this.P1().postValue(new ErrorMessage(error, message));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(gd3.b repository) {
        super(repository);
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.errorMessage = new MutableLiveData<>();
        this.cardList = new MutableLiveData<>();
        gb4.a aVar = gb4.a.f401894a;
        this.redMapId = aVar.c();
        this.bagRedMapId = aVar.a();
        this.pageParam = "";
    }

    public boolean L1(int type) {
        return this.isCardListEnd;
    }

    public final MutableLiveData<Integer> N1() {
        return this.bagRedMapId;
    }

    public final MutableLiveData<List<ZootopiaCardData>> O1() {
        return this.cardList;
    }

    public final MutableLiveData<ErrorMessage> P1() {
        return this.errorMessage;
    }

    public List<ZootopiaCardData> Q1() {
        List<ZootopiaCardData> value = this.cardList.getValue();
        return value == null ? new ArrayList() : value;
    }

    public final MutableLiveData<Integer> R1() {
        return this.redMapId;
    }

    public final void S1(String param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.pageParam = param;
        QLog.i(H, 1, "initPageParam - " + param);
    }

    public void T1(int type) {
        getRepository().j(this.pageParam, new b());
    }

    public boolean W1(int type) {
        return false;
    }

    public static /* synthetic */ boolean M1(c cVar, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 1) != 0) {
                i3 = 0;
            }
            return cVar.L1(i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkListIsEnd");
    }

    public static /* synthetic */ void U1(c cVar, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 1) != 0) {
                i3 = 0;
            }
            cVar.T1(i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadCardFeedsList");
    }

    public static /* synthetic */ boolean X1(c cVar, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 1) != 0) {
                i3 = 0;
            }
            return cVar.W1(i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadNextPageData");
    }
}

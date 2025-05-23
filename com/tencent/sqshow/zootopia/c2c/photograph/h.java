package com.tencent.sqshow.zootopia.c2c.photograph;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0003J\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tR#\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/sqshow/zootopia/c2c/photograph/h;", "Lcom/tencent/mobileqq/mvvm/c;", "Lcom/tencent/sqshow/zootopia/c2c/photograph/g;", "", "firstLoad", "", "P1", "Ljava/util/ArrayList;", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "Lkotlin/collections/ArrayList;", "N1", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "O1", "()Landroidx/lifecycle/MutableLiveData;", "templateList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "M1", "hasMore", "Lcom/tencent/sqshow/zootopia/data/a;", BdhLogUtil.LogTag.Tag_Conn, "L1", "errorMessage", "", "D", "I", "currentPage", "repository", "<init>", "(Lcom/tencent/sqshow/zootopia/c2c/photograph/g;)V", "E", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h extends com.tencent.mobileqq.mvvm.c<g> {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<ErrorMessage> errorMessage;

    /* renamed from: D, reason: from kotlin metadata */
    private int currentPage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<ZPlanTemplate>> templateList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> hasMore;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/c2c/photograph/h$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<List<ZPlanTemplate>> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(List<ZPlanTemplate> result) {
            Intrinsics.checkNotNullParameter(result, "result");
            List<ZPlanTemplate> list = result;
            if (!list.isEmpty()) {
                List<ZPlanTemplate> value = h.this.O1().getValue();
                if (value != null && (value.isEmpty() ^ true)) {
                    List<ZPlanTemplate> value2 = h.this.O1().getValue();
                    if (value2 != null) {
                        value2.addAll(list);
                    }
                    h.this.O1().postValue(h.this.O1().getValue());
                } else {
                    h.this.O1().postValue(result);
                }
            } else {
                List<ZPlanTemplate> value3 = h.this.O1().getValue();
                if (value3 != null && !value3.isEmpty()) {
                    r2 = false;
                }
                if (r2) {
                    h.this.L1().postValue(new ErrorMessage(-88, "\u6682\u65f6\u6ca1\u6709\u6570\u636e"));
                }
            }
            if (result.size() < 10) {
                h.this.M1().postValue(Boolean.FALSE);
            } else {
                h.this.M1().postValue(Boolean.TRUE);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            h.this.L1().postValue(new ErrorMessage(error, message));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g repository) {
        super(repository);
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.templateList = new MutableLiveData<>();
        this.hasMore = new MutableLiveData<>();
        this.errorMessage = new MutableLiveData<>();
        this.currentPage = 1;
    }

    public final MutableLiveData<ErrorMessage> L1() {
        return this.errorMessage;
    }

    public final MutableLiveData<Boolean> M1() {
        return this.hasMore;
    }

    public final ArrayList<ZPlanTemplate> N1() {
        List emptyList;
        List emptyList2;
        ArrayList<ZPlanTemplate> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < 6; i3++) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            arrayList.add(new ZPlanTemplate(-1, "", "", "", "", 0, false, 0L, "", "", emptyList, 1L, emptyList2, false, "", null, false, 98304, null));
        }
        return arrayList;
    }

    public final MutableLiveData<List<ZPlanTemplate>> O1() {
        return this.templateList;
    }

    public final void P1(boolean firstLoad) {
        if (!firstLoad || this.currentPage == 1) {
            g repository = getRepository();
            int i3 = this.currentPage;
            this.currentPage = i3 + 1;
            repository.j(i3, new b());
        }
    }

    public static /* synthetic */ void Q1(h hVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        hVar.P1(z16);
    }
}

package com.tencent.sqshow.zootopia.samestyle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.page.samestyle.SameStyleContentPageFrom;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\"\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R#\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/TemplateEntranceViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/common/app/AppInterface;", "app", "Lkotlin/Function0;", "", "preStartAction", "O1", "", "i", "Z", "isRequestTemplateCats", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateCat;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_templateCats", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "templateCats", "", "D", "Ljava/lang/String;", "getFrom", "()Ljava/lang/String;", "R1", "(Ljava/lang/String;)V", "from", "<init>", "()V", "E", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class TemplateEntranceViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final LiveData<List<ZPlanTemplateCat>> templateCats;

    /* renamed from: D, reason: from kotlin metadata */
    private String from;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isRequestTemplateCats;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<ZPlanTemplateCat>> _templateCats;

    public TemplateEntranceViewModel() {
        MutableLiveData<List<ZPlanTemplateCat>> mutableLiveData = new MutableLiveData<>();
        this._templateCats = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.collections.List<com.tencent.sqshow.zootopia.samestyle.ZPlanTemplateCat>>");
        this.templateCats = mutableLiveData;
        this.from = SameStyleContentPageFrom.FROM_SAME_STYLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(AppInterface app, TemplateEntranceViewModel this$0) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g gVar = g.f372915a;
        nv4.d dVar = new nv4.d();
        dVar.f421391a = Intrinsics.areEqual(this$0.from, SameStyleContentPageFrom.FROM_CONTENT_PUBLISH);
        Unit unit = Unit.INSTANCE;
        gVar.a(app, dVar, new TemplateEntranceViewModel$fetchTemplateCats$1$2(this$0));
    }

    public final void O1(final AppInterface app, Function0<Unit> preStartAction) {
        Intrinsics.checkNotNullParameter(app, "app");
        List<ZPlanTemplateCat> value = this._templateCats.getValue();
        if (!(value == null || value.isEmpty())) {
            QLog.i("TemplateEntranceViewModel", 1, "template cats is not empty, ignore fetch");
            return;
        }
        if (this.isRequestTemplateCats) {
            QLog.i("TemplateEntranceViewModel", 1, "is already request, ignore fetch");
            return;
        }
        this.isRequestTemplateCats = true;
        if (preStartAction != null) {
            preStartAction.invoke();
        }
        QLog.i("TemplateEntranceViewModel", 1, "start fetch template cats");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.c
            @Override // java.lang.Runnable
            public final void run() {
                TemplateEntranceViewModel.P1(AppInterface.this, this);
            }
        }, 16, null, true);
    }

    public final LiveData<List<ZPlanTemplateCat>> Q1() {
        return this.templateCats;
    }

    public final void R1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.from = str;
    }
}

package com.tencent.mobileqq.search;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.api.ISearchEntryRuntimeService;
import com.tencent.mobileqq.search.business.activatepage.ActivatePageRepo;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 C*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001DB\u0017\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010(\u001a\u00020\u001f\u00a2\u0006\u0004\bA\u0010BJ7\u0010\f\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0004J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0004R\u0016\u0010\"\u001a\u00020\u001f8\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\"\u0010(\u001a\u00020\u001f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010!\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010!\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R$\u00104\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b0\u00109R\u0016\u0010<\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/search/BaseSearchEntryModel;", "Landroid/view/View;", "T", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, ReportConstant.COSTREPORT_PREFIX, "(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "o", "onResume", "u", "t", "refresh", "Lcom/tencent/mobileqq/search/model/SearchEntryDataModel;", "model", "y", "", "isVisible", "v", "Landroid/content/res/Configuration;", "newConfig", "r", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "d", "I", "mTabType", "e", "getMFrom", "()I", "setMFrom", "(I)V", "mFrom", "f", DomainData.DOMAIN_NAME, HippyTKDListViewAdapter.X, "modelType", "", tl.h.F, "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "w", "(Ljava/lang/String;)V", "modelName", "", "i", "J", "mCreateTimestamp", "Z", "showDivider", BdhLogUtil.LogTag.Tag_Conn, "isCreatedView", "Lcom/tencent/mobileqq/search/business/activatepage/ActivatePageRepo;", "D", "Lcom/tencent/mobileqq/search/business/activatepage/ActivatePageRepo;", "mNtActivatePageRepo", "<init>", "(II)V", "E", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class BaseSearchEntryModel<T extends View> {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @JvmField
    public boolean isCreatedView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    protected int mTabType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mFrom;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int modelType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String modelName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public long mCreateTimestamp;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public boolean showDivider = true;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ActivatePageRepo mNtActivatePageRepo = new ActivatePageRepo();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011JJ\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH\u0007R\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/search/BaseSearchEntryModel$a;", "", "", "modelType", "tabType", "Lcom/tencent/mobileqq/search/util/z;", "expHelper", "from", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "hintWords", "Lcom/tencent/mobileqq/search/BaseSearchEntryModel;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.BaseSearchEntryModel$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
        @JvmStatic
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final BaseSearchEntryModel<?> a(int modelType, int tabType, @NotNull com.tencent.mobileqq.search.util.z expHelper, int from, @Nullable ArrayList<String> hintWords) {
            BaseSearchEntryModel<?> hotWordSearchEntryModel;
            Intrinsics.checkNotNullParameter(expHelper, "expHelper");
            if (modelType != 1) {
                if (modelType != 3) {
                    if (modelType != 256) {
                        if (modelType != 7 && modelType != 8) {
                            switch (modelType) {
                                case 10:
                                    hotWordSearchEntryModel = new t(tabType, from);
                                    break;
                                case 11:
                                    hotWordSearchEntryModel = new e(tabType, from);
                                    break;
                                case 12:
                                    hotWordSearchEntryModel = new o(tabType, from);
                                    break;
                                default:
                                    QLog.w("QQSearch.Local.entry.BaseSearchEntryModel", 2, "createSearchEntryModel, failed = " + modelType + ", tabType = " + tabType);
                                    hotWordSearchEntryModel = null;
                                    break;
                            }
                        }
                    } else {
                        hotWordSearchEntryModel = expHelper.a(tabType, from);
                    }
                } else {
                    b bVar = new b(tabType, from);
                    bVar.K(expHelper);
                    bVar.L(hintWords);
                    hotWordSearchEntryModel = bVar;
                }
                if (hotWordSearchEntryModel != null) {
                    hotWordSearchEntryModel.x(modelType);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QQSearch.Local.entry.BaseSearchEntryModel", 2, "createSearchEntryModel, modelType = " + modelType + ", tabType = " + tabType);
                }
                return hotWordSearchEntryModel;
            }
            hotWordSearchEntryModel = new HotWordSearchEntryModel(modelType, tabType, from);
            if (hotWordSearchEntryModel != null) {
            }
            if (QLog.isColorLevel()) {
            }
            return hotWordSearchEntryModel;
        }

        Companion() {
        }
    }

    public BaseSearchEntryModel(int i3, int i16) {
        this.mTabType = i3;
        this.mFrom = i16;
    }

    @JvmStatic
    @Nullable
    public static final BaseSearchEntryModel<?> l(int i3, int i16, @NotNull com.tencent.mobileqq.search.util.z zVar, int i17, @Nullable ArrayList<String> arrayList) {
        return INSTANCE.a(i3, i16, zVar, i17, arrayList);
    }

    @Nullable
    /* renamed from: m, reason: from getter */
    public final String getModelName() {
        return this.modelName;
    }

    /* renamed from: n, reason: from getter */
    public final int getModelType() {
        return this.modelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p(@NotNull SearchEntryDataModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        QLog.d("QQSearch.Local.entry.BaseSearchEntryModel", 2, "loadDataFromCache modelName=" + this.modelName + " modelType=" + this.modelType + " originFrom " + this.mFrom);
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ISearchEntryRuntimeService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
        SearchEntryDataModel searchEntryDataModelFromCache = ((ISearchEntryRuntimeService) runtimeService).getSearchEntryDataModelFromCache(this.modelType);
        if (searchEntryDataModelFromCache != null) {
            S(searchEntryDataModelFromCache);
            return;
        }
        QLog.e("QQSearch.Local.entry.BaseSearchEntryModel", 2, "loadDataFromCache not find item modelType=" + this.modelType);
        q(model);
    }

    protected final void q(@NotNull SearchEntryDataModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        QLog.d("QQSearch.Local.entry.BaseSearchEntryModel", 2, "load data from nt " + model + " originFrom " + this.mFrom);
        try {
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ISearchEntryRuntimeService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
            ((ISearchEntryRuntimeService) runtimeService).requestSearchDiscoveryDataByCache(ActivatePageRepo.INSTANCE.a(this.mFrom), new BaseSearchEntryModel$loadDataFromRepo$1(model, this));
        } catch (ActivatePageRepo.ThrowableWithError e16) {
            QLog.e("QQSearch.Local.entry.BaseSearchEntryModel", 1, "loadDataFromRepo failed  model:" + model, e16);
        }
    }

    @NotNull
    public abstract T s(@Nullable Context context, @Nullable QQAppInterface app, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    public final void w(@Nullable String str) {
        this.modelName = str;
    }

    public final void x(int i3) {
        this.modelType = i3;
    }

    public void o() {
    }

    public void onResume() {
    }

    public void refresh() {
    }

    public void t() {
    }

    public void u() {
    }

    public void r(@Nullable Configuration newConfig) {
    }

    public void v(boolean isVisible) {
    }

    /* renamed from: y */
    public void S(@Nullable SearchEntryDataModel model) {
    }
}

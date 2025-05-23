package com.tencent.mobileqq.search.model;

import circlesearch.CircleSearchExhibition$UnifySearchResultExt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.api.ISearchEntryRuntimeService;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisHotSearchItem;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisResult;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/search/model/aj;", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class aj {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J@\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\b\u001a\u00020\u0002H\u0007J\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00132\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u0012\u001a\u00020\u0002\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/search/model/aj$a;", "", "", "type", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisResult;", "pbItem", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "tabType", "", "invalidIndexList", "i", "Lcom/tencent/mobileqq/search/model/SearchEntryDataModel;", "a", "", "pbItemList", "c", "resultItemList", IProfileCardConst.KEY_FROM_TYPE, "Lcirclesearch/CircleSearchExhibition$UnifySearchResultExt;", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.model.aj$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final SearchEntryDataModel a(int type, UfsDisResult pbItem, QQAppInterface app, int tabType, List<Integer> invalidIndexList, int i3) {
            int collectionSizeOrDefault;
            HotWordSearchEntryDataModel hotWordSearchEntryDataModel;
            if (type != 1) {
                if (type != 3) {
                    if (type != 8) {
                        switch (type) {
                            case 10:
                                HotWordSearchEntryDataModel hotWordSearchEntryDataModel2 = new HotWordSearchEntryDataModel(10, tabType, true);
                                ak.e(hotWordSearchEntryDataModel2, pbItem);
                                boolean isEmpty = hotWordSearchEntryDataModel2.E.isEmpty();
                                hotWordSearchEntryDataModel = hotWordSearchEntryDataModel2;
                                if (isEmpty) {
                                    invalidIndexList.add(Integer.valueOf(i3));
                                    return null;
                                }
                                break;
                            case 11:
                                GuessSearchEntryDataModel guessSearchEntryDataModel = new GuessSearchEntryDataModel(11, tabType);
                                ak.d(guessSearchEntryDataModel, pbItem);
                                boolean isEmpty2 = guessSearchEntryDataModel.o().isEmpty();
                                hotWordSearchEntryDataModel = guessSearchEntryDataModel;
                                if (isEmpty2) {
                                    invalidIndexList.add(Integer.valueOf(i3));
                                    return null;
                                }
                                break;
                            case 12:
                                OperationHotSearchEntryDataModel operationHotSearchEntryDataModel = new OperationHotSearchEntryDataModel(12, tabType);
                                ak.f(operationHotSearchEntryDataModel, pbItem);
                                boolean isEmpty3 = operationHotSearchEntryDataModel.D.isEmpty();
                                hotWordSearchEntryDataModel = operationHotSearchEntryDataModel;
                                if (isEmpty3) {
                                    invalidIndexList.add(Integer.valueOf(i3));
                                    return null;
                                }
                                break;
                            default:
                                return null;
                        }
                        return hotWordSearchEntryDataModel;
                    }
                    ArrayList<UfsDisHotSearchItem> arrayList = pbItem.hotSearchItems;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "pbItem.hotSearchItems");
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = arrayList.iterator();
                    while (it.hasNext()) {
                        byte[] bArr = ((UfsDisHotSearchItem) it.next()).title;
                        Intrinsics.checkNotNullExpressionValue(bArr, "it.title");
                        Charset UTF_8 = StandardCharsets.UTF_8;
                        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                        arrayList2.add(new String(bArr, UTF_8));
                    }
                    Object[] array = arrayList2.toArray(new String[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    ea.g5(app.getCurrentAccountUin(), (String[]) array);
                    HotWordSearchEntryDataModel hotWordSearchEntryDataModel3 = new HotWordSearchEntryDataModel(type, tabType, true);
                    ak.e(hotWordSearchEntryDataModel3, pbItem);
                    return hotWordSearchEntryDataModel3;
                }
                b bVar = new b(type, tabType);
                ak.c(bVar, pbItem);
                return bVar;
            }
            ArrayList<UfsDisHotSearchItem> arrayList3 = pbItem.hotSearchItems;
            Intrinsics.checkNotNullExpressionValue(arrayList3, "pbItem.hotSearchItems");
            if (arrayList3.size() > 0 && arrayList3.size() < 6) {
                return null;
            }
            String[] strArr = new String[arrayList3.size()];
            for (int i16 = 0; i16 < arrayList3.size(); i16++) {
                byte[] bArr2 = arrayList3.get(i16).title;
                Intrinsics.checkNotNullExpressionValue(bArr2, "hotSearchItems[j].title");
                Charset UTF_82 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
                strArr[i16] = new String(bArr2, UTF_82);
            }
            ea.g5(app.getCurrentAccountUin(), strArr);
            HotWordSearchEntryDataModel hotWordSearchEntryDataModel4 = new HotWordSearchEntryDataModel(type, tabType, true);
            ak.e(hotWordSearchEntryDataModel4, pbItem);
            return hotWordSearchEntryDataModel4;
        }

        @Nullable
        public final CircleSearchExhibition$UnifySearchResultExt b(@NotNull List<UfsDisResult> resultItemList, int fromType) {
            Intrinsics.checkNotNullParameter(resultItemList, "resultItemList");
            if (fromType != 2 && fromType != 1) {
                return null;
            }
            for (UfsDisResult ufsDisResult : resultItemList) {
                if (ufsDisResult.type == 10) {
                    return ak.a(ufsDisResult);
                }
            }
            return null;
        }

        @JvmStatic
        @NotNull
        public final List<SearchEntryDataModel> c(@NotNull QQAppInterface app, @NotNull List<UfsDisResult> pbItemList, int tabType) {
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(pbItemList, "pbItemList");
            QLog.d("QQSearch.Local.entry.SearchEntryDataModelExt818searchProto_new", 2, "convertNTUnifyDataToModel");
            ArrayList arrayList = new ArrayList();
            int[] iArr = new int[pbItemList.size()];
            ArrayList arrayList2 = new ArrayList();
            if (!pbItemList.isEmpty()) {
                int size = pbItemList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    UfsDisResult ufsDisResult = pbItemList.get(i3);
                    iArr[i3] = pbItemList.get(i3).type;
                    SearchEntryDataModel a16 = a(ufsDisResult.type, ufsDisResult, app, tabType, arrayList2, i3);
                    if (a16 != null) {
                        arrayList.add(a16);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    iArr = SearchUtil.y(iArr, arrayList2);
                }
                boolean m3 = SearchEntryDataModel.m(iArr, nn2.a.d(app, tabType));
                nn2.a.l(app, tabType, m3);
                if (m3) {
                    IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ISearchEntryRuntimeService.class, "");
                    Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
                    ((ISearchEntryRuntimeService) runtimeService).updateModelListByTab(app, tabType, iArr);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("SearchEntryDataModel", 2, "convertPbDataToModel, modelList = " + arrayList.size());
            }
            return arrayList;
        }

        Companion() {
        }
    }
}

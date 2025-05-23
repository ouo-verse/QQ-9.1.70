package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import circlesearch.CircleSearchExhibition$UnifySearchResultExt;
import com.tencent.mobileqq.search.model.GuessSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.OperationHotSearchEntryDataModel;
import com.tencent.mobileqq.search.model.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisGuessWantItem;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisGuessWantSearch;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisHotSearchIcon;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisHotSearchItem;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisJumpLink;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisOperationHotSearch;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisOperationHotSearchItem;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisResult;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisRspBody;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisSubBusinessItem;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisTitleHeaderItem;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0004\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0006\u001a\u0012\u0010\r\u001a\u00020\f*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n\u001a\n\u0010\u0010\u001a\u00020\u000f*\u00020\u000e\u001a\u0014\u0010\u0015\u001a\u00020\u0014*\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u001a\u0014\u0010\u0017\u001a\u00020\u0014*\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u001a\u0012\u0010\u0019\u001a\u00020\u0014*\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0012\u001a\u0012\u0010\u001b\u001a\u00020\u0014*\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0012\u001a\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0012\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/search/model/SearchEntryDataModel;", "T", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisRspBody;", "target", "b", "(Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisRspBody;Lcom/tencent/mobileqq/search/model/SearchEntryDataModel;)Lcom/tencent/mobileqq/search/model/SearchEntryDataModel;", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisSubBusinessItem;", "Lcom/tencent/mobileqq/search/model/b$a;", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisHotSearchItem;", "", "type", "Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem;", "g", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisOperationHotSearchItem;", "Lcom/tencent/mobileqq/search/model/OperationHotSearchEntryDataModel$OperationHotSearchItemData;", tl.h.F, "Lcom/tencent/mobileqq/search/model/OperationHotSearchEntryDataModel;", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisResult;", "resultData", "", "f", "Lcom/tencent/mobileqq/search/model/GuessSearchEntryDataModel;", "d", "Lcom/tencent/mobileqq/search/model/b;", "c", "Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel;", "e", "result", "Lcirclesearch/CircleSearchExhibition$UnifySearchResultExt;", "a", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ak {
    @Nullable
    public static final CircleSearchExhibition$UnifySearchResultExt a(@Nullable UfsDisResult ufsDisResult) {
        byte[] bArr;
        if (ufsDisResult != null && (bArr = ufsDisResult.resultExt) != null) {
            CircleSearchExhibition$UnifySearchResultExt circleSearchExhibition$UnifySearchResultExt = new CircleSearchExhibition$UnifySearchResultExt();
            try {
                circleSearchExhibition$UnifySearchResultExt.mergeFrom(bArr);
                return circleSearchExhibition$UnifySearchResultExt;
            } catch (Exception e16) {
                QLog.w("QQSearch.Local.entry.SearchEntryDataModelExt", 1, e16.getMessage(), e16);
                return null;
            }
        }
        return null;
    }

    @NotNull
    public static final <T extends SearchEntryDataModel> T b(@NotNull UfsDisRspBody ufsDisRspBody, @NotNull T target) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(ufsDisRspBody, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        if (QLog.isColorLevel()) {
            QLog.d("QQSearch.Local.entry.SearchEntryDataModelExt", 1, " createFromUfsDisRspBod from " + target);
        }
        ArrayList<UfsDisResult> resultItems = ufsDisRspBody.resultItems;
        Intrinsics.checkNotNullExpressionValue(resultItems, "resultItems");
        Iterator<T> it = resultItems.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((UfsDisResult) obj).type == target.f283456f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        UfsDisResult ufsDisResult = (UfsDisResult) obj;
        if (ufsDisResult == null) {
            QLog.e("QQSearch.Local.entry.SearchEntryDataModelExt", 1, " can't find " + target);
            return target;
        }
        if (target instanceof GuessSearchEntryDataModel) {
            d((GuessSearchEntryDataModel) target, ufsDisResult);
        } else if (target instanceof HotWordSearchEntryDataModel) {
            e((HotWordSearchEntryDataModel) target, ufsDisResult);
        } else if (target instanceof OperationHotSearchEntryDataModel) {
            f((OperationHotSearchEntryDataModel) target, ufsDisResult);
        } else if (target instanceof b) {
            b bVar = (b) target;
            c(bVar, ufsDisResult);
            if (!bVar.u()) {
                bVar.o();
            }
        } else {
            QLog.e("QQSearch.Local.entry.SearchEntryDataModelExt", 1, " can't deal with " + target);
        }
        return target;
    }

    public static final void c(@NotNull b bVar, @NotNull UfsDisResult resultData) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        try {
            ArrayList<UfsDisSubBusinessItem> subBusinessItems = resultData.subBusinessItems;
            List<b.a> list = bVar.D;
            Intrinsics.checkNotNullExpressionValue(subBusinessItems, "subBusinessItems");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(subBusinessItems, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (UfsDisSubBusinessItem it : subBusinessItems) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(i(it));
            }
            list.addAll(arrayList);
            if (!bVar.u()) {
                bVar.o();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQSearch.Local.entry.SearchEntryDataModelExt", 1, "fabricateModel, UnifySearchDiscovery Exception e = " + e16);
            }
        }
        QLog.d("QQSearch.Local.entry.SearchEntryDataModelExt", 2, "fabricateModel");
    }

    public static final void d(@NotNull GuessSearchEntryDataModel guessSearchEntryDataModel, @Nullable UfsDisResult ufsDisResult) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(guessSearchEntryDataModel, "<this>");
        if (ufsDisResult == null) {
            guessSearchEntryDataModel.o().clear();
            return;
        }
        UfsDisGuessWantSearch ufsDisGuessWantSearch = ufsDisResult.guessWantItems;
        if (ufsDisGuessWantSearch == null) {
            return;
        }
        guessSearchEntryDataModel.r(ufsDisGuessWantSearch.title);
        ArrayList<UfsDisGuessWantItem> arrayList = ufsDisResult.guessWantItems.items;
        if (arrayList != null) {
            guessSearchEntryDataModel.o().clear();
            List<GuessSearchEntryDataModel.GuessSearchItem> o16 = guessSearchEntryDataModel.o();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (UfsDisGuessWantItem ufsDisGuessWantItem : arrayList) {
                GuessSearchEntryDataModel.GuessSearchItem guessSearchItem = new GuessSearchEntryDataModel.GuessSearchItem();
                guessSearchItem.word = ufsDisGuessWantItem.word;
                guessSearchItem.extension = ufsDisGuessWantItem.bytesExtension;
                guessSearchItem.reportData = ufsDisGuessWantItem.reportData;
                guessSearchItem.type = ufsDisGuessWantItem.type;
                guessSearchEntryDataModel.q(guessSearchItem);
                arrayList2.add(guessSearchItem);
            }
            o16.addAll(arrayList2);
        }
    }

    public static final void e(@NotNull HotWordSearchEntryDataModel hotWordSearchEntryDataModel, @NotNull UfsDisResult resultData) {
        int collectionSizeOrDefault;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(hotWordSearchEntryDataModel, "<this>");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        ArrayList<UfsDisHotSearchItem> hotSearchItems = resultData.hotSearchItems;
        UfsDisTitleHeaderItem ufsDisTitleHeaderItem = resultData.titleHeader;
        HotWordSearchEntryDataModel.a aVar = hotWordSearchEntryDataModel.F;
        byte[] bArr = ufsDisTitleHeaderItem.iconUrl;
        Intrinsics.checkNotNullExpressionValue(bArr, "titleHeaderItem.iconUrl");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        aVar.f283450b = new String(bArr, UTF_8);
        HotWordSearchEntryDataModel.a aVar2 = hotWordSearchEntryDataModel.F;
        byte[] bArr2 = ufsDisTitleHeaderItem.iconUrl;
        Intrinsics.checkNotNullExpressionValue(bArr2, "titleHeaderItem.iconUrl");
        Charset UTF_82 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
        aVar2.f283449a = new String(bArr2, UTF_82);
        HotWordSearchEntryDataModel.a aVar3 = hotWordSearchEntryDataModel.F;
        byte[] bArr3 = ufsDisTitleHeaderItem.mornText;
        Intrinsics.checkNotNullExpressionValue(bArr3, "titleHeaderItem.mornText");
        Charset UTF_83 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_83, "UTF_8");
        aVar3.f283451c = new String(bArr3, UTF_83);
        HotWordSearchEntryDataModel.a aVar4 = hotWordSearchEntryDataModel.F;
        byte[] bArr4 = ufsDisTitleHeaderItem.mornUrl;
        Intrinsics.checkNotNullExpressionValue(bArr4, "titleHeaderItem.mornUrl");
        Charset UTF_84 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_84, "UTF_8");
        aVar4.f283452d = new String(bArr4, UTF_84);
        hotWordSearchEntryDataModel.F.f283453e = ufsDisTitleHeaderItem.headerType;
        byte[] bArr5 = ufsDisTitleHeaderItem.qqIndexJumpUrl;
        if (bArr5 != null) {
            Charset UTF_85 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_85, "UTF_8");
            String str = new String(bArr5, UTF_85);
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!(!isBlank)) {
                str = null;
            }
            if (str != null) {
                hotWordSearchEntryDataModel.F.f283454f = str;
            }
        }
        Object obj = HotWordSearchEntryDataModel.K;
        Intrinsics.checkNotNullExpressionValue(obj, "obj");
        synchronized (obj) {
            hotWordSearchEntryDataModel.E.clear();
            Unit unit = Unit.INSTANCE;
        }
        if (!HotWordSearchEntryDataModel.u(hotWordSearchEntryDataModel.f283457h, true)) {
            Intrinsics.checkNotNullExpressionValue(hotSearchItems, "hotSearchItems");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(hotSearchItems, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (UfsDisHotSearchItem it : hotSearchItems) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(g(it, resultData.type));
            }
            Object obj2 = HotWordSearchEntryDataModel.K;
            Intrinsics.checkNotNullExpressionValue(obj2, "obj");
            synchronized (obj2) {
                hotWordSearchEntryDataModel.E.addAll(arrayList);
            }
        }
    }

    public static final void f(@NotNull OperationHotSearchEntryDataModel operationHotSearchEntryDataModel, @Nullable UfsDisResult ufsDisResult) {
        boolean z16;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(operationHotSearchEntryDataModel, "<this>");
        if (ufsDisResult == null) {
            operationHotSearchEntryDataModel.D.clear();
            return;
        }
        if (ufsDisResult.operationHotSearchItems == null) {
            return;
        }
        operationHotSearchEntryDataModel.D.clear();
        UfsDisOperationHotSearch ufsDisOperationHotSearch = ufsDisResult.operationHotSearchItems;
        if (ufsDisOperationHotSearch == null) {
            return;
        }
        String str = ufsDisOperationHotSearch.title;
        operationHotSearchEntryDataModel.E = str;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            com.tencent.mobileqq.search.util.w.z(operationHotSearchEntryDataModel.f283456f, operationHotSearchEntryDataModel.E);
        }
        operationHotSearchEntryDataModel.F = ufsDisOperationHotSearch.picUrl;
        UfsDisJumpLink ufsDisJumpLink = ufsDisOperationHotSearch.picJumpLink;
        if (ufsDisJumpLink != null) {
            operationHotSearchEntryDataModel.G = ufsDisJumpLink.jumpType;
            operationHotSearchEntryDataModel.H = ufsDisJumpLink.jumpUrl;
        }
        CopyOnWriteArrayList<OperationHotSearchEntryDataModel.OperationHotSearchItemData> copyOnWriteArrayList = operationHotSearchEntryDataModel.D;
        ArrayList<UfsDisOperationHotSearchItem> arrayList = ufsDisOperationHotSearch.items;
        Intrinsics.checkNotNullExpressionValue(arrayList, "opItems.items");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (UfsDisOperationHotSearchItem it : arrayList) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList2.add(h(it));
        }
        copyOnWriteArrayList.addAll(arrayList2);
    }

    @NotNull
    public static final HotWordSearchEntryDataModel.HotSearchItem g(@NotNull UfsDisHotSearchItem ufsDisHotSearchItem, int i3) {
        Intrinsics.checkNotNullParameter(ufsDisHotSearchItem, "<this>");
        HotWordSearchEntryDataModel.HotSearchItem hotSearchItem = new HotWordSearchEntryDataModel.HotSearchItem();
        byte[] title = ufsDisHotSearchItem.title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        hotSearchItem.title = new String(title, UTF_8);
        hotSearchItem.type = i3;
        hotSearchItem.showType = ufsDisHotSearchItem.showType;
        hotSearchItem.showCount = ufsDisHotSearchItem.wzTs;
        byte[] itemExt = ufsDisHotSearchItem.itemExt;
        Intrinsics.checkNotNullExpressionValue(itemExt, "itemExt");
        Charset UTF_82 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
        hotSearchItem.sExtInfo = new String(itemExt, UTF_82);
        byte[] recallWord = ufsDisHotSearchItem.recallWord;
        Intrinsics.checkNotNullExpressionValue(recallWord, "recallWord");
        Charset UTF_83 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_83, "UTF_8");
        String str = new String(recallWord, UTF_83);
        if (TextUtils.isEmpty(str)) {
            str = hotSearchItem.title;
        }
        hotSearchItem.recallWord = str;
        byte[] imgUrl = ufsDisHotSearchItem.imgUrl;
        Intrinsics.checkNotNullExpressionValue(imgUrl, "imgUrl");
        Charset UTF_84 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_84, "UTF_8");
        hotSearchItem.imgUrl = new String(imgUrl, UTF_84);
        byte[] detailText = ufsDisHotSearchItem.detailText;
        Intrinsics.checkNotNullExpressionValue(detailText, "detailText");
        Charset UTF_85 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_85, "UTF_8");
        hotSearchItem.detailText = new String(detailText, UTF_85);
        byte[] jumpUrl = ufsDisHotSearchItem.jumpUrl;
        Intrinsics.checkNotNullExpressionValue(jumpUrl, "jumpUrl");
        Charset UTF_86 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_86, "UTF_8");
        hotSearchItem.jumpUrl = new String(jumpUrl, UTF_86);
        byte[] markTextColor = ufsDisHotSearchItem.markTextColor;
        Intrinsics.checkNotNullExpressionValue(markTextColor, "markTextColor");
        Charset UTF_87 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_87, "UTF_8");
        hotSearchItem.indexTextColor = new String(markTextColor, UTF_87);
        byte[] markBgColor = ufsDisHotSearchItem.markBgColor;
        Intrinsics.checkNotNullExpressionValue(markBgColor, "markBgColor");
        Charset UTF_88 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_88, "UTF_8");
        hotSearchItem.indexBgColor = new String(markBgColor, UTF_88);
        byte[] imgBgUrl = ufsDisHotSearchItem.imgBgUrl;
        Intrinsics.checkNotNullExpressionValue(imgBgUrl, "imgBgUrl");
        Charset UTF_89 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_89, "UTF_8");
        hotSearchItem.imgBgUrl = new String(imgBgUrl, UTF_89);
        byte[] textColor = ufsDisHotSearchItem.textColor;
        Intrinsics.checkNotNullExpressionValue(textColor, "textColor");
        Charset UTF_810 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_810, "UTF_8");
        hotSearchItem.titleTextColor = new String(textColor, UTF_810);
        byte[] rightIconUrl = ufsDisHotSearchItem.rightIconUrl;
        Intrinsics.checkNotNullExpressionValue(rightIconUrl, "rightIconUrl");
        Charset UTF_811 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_811, "UTF_8");
        hotSearchItem.rightIconUrl = new String(rightIconUrl, UTF_811);
        if (!TextUtils.isEmpty(hotSearchItem.sExtInfo)) {
            try {
                JSONObject optJSONObject = new JSONObject(hotSearchItem.sExtInfo).optJSONObject("label");
                if (optJSONObject != null) {
                    hotSearchItem.tagColor = optJSONObject.optString("color");
                    hotSearchItem.tagInfo = optJSONObject.optString("text");
                    hotSearchItem.tagBGColor = optJSONObject.optString("background");
                }
            } catch (JSONException unused) {
            }
        }
        return hotSearchItem;
    }

    @NotNull
    public static final OperationHotSearchEntryDataModel.OperationHotSearchItemData h(@NotNull UfsDisOperationHotSearchItem ufsDisOperationHotSearchItem) {
        boolean startsWith$default;
        String replaceFirst$default;
        Intrinsics.checkNotNullParameter(ufsDisOperationHotSearchItem, "<this>");
        OperationHotSearchEntryDataModel.OperationHotSearchItemData operationHotSearchItemData = new OperationHotSearchEntryDataModel.OperationHotSearchItemData();
        operationHotSearchItemData.word = ufsDisOperationHotSearchItem.word;
        UfsDisHotSearchIcon ufsDisHotSearchIcon = ufsDisOperationHotSearchItem.icons;
        if (ufsDisHotSearchIcon != null) {
            operationHotSearchItemData.tagText = ufsDisHotSearchIcon.text;
            operationHotSearchItemData.tagColor = ufsDisHotSearchIcon.color;
            operationHotSearchItemData.tagBgColor = ufsDisHotSearchIcon.background;
        }
        operationHotSearchItemData.serialNumUrl = ufsDisOperationHotSearchItem.serialNumUrl;
        UfsDisJumpLink ufsDisJumpLink = ufsDisOperationHotSearchItem.jumpLink;
        if (ufsDisJumpLink != null) {
            operationHotSearchItemData.jumpType = ufsDisJumpLink.jumpType;
            String str = ufsDisJumpLink.jumpUrl;
            operationHotSearchItemData.jumpUrl = str;
            Intrinsics.checkNotNullExpressionValue(str, "item.jumpUrl");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "mqqapi://ecommerce", false, 2, null);
            if (startsWith$default) {
                String str2 = operationHotSearchItemData.jumpUrl;
                Intrinsics.checkNotNullExpressionValue(str2, "item.jumpUrl");
                replaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(str2, "mqqapi://ecommerce", "mqqapi://kuikly", false, 4, (Object) null);
                operationHotSearchItemData.jumpUrl = replaceFirst$default;
            }
        }
        byte[] reportData = ufsDisOperationHotSearchItem.reportData;
        Intrinsics.checkNotNullExpressionValue(reportData, "reportData");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        operationHotSearchItemData.reportData = new String(reportData, UTF_8);
        operationHotSearchItemData.isManualOperation = ufsDisOperationHotSearchItem.isManualOperation;
        operationHotSearchItemData.hotSearchTextId = ufsDisOperationHotSearchItem.hotSearchTextId;
        return operationHotSearchItemData;
    }

    @NotNull
    public static final b.a i(@NotNull UfsDisSubBusinessItem ufsDisSubBusinessItem) {
        long[] longArray;
        Intrinsics.checkNotNullParameter(ufsDisSubBusinessItem, "<this>");
        b.a aVar = new b.a();
        byte[] title = ufsDisSubBusinessItem.title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        aVar.f283518a = new String(title, UTF_8);
        byte[] iconUrl = ufsDisSubBusinessItem.iconUrl;
        Intrinsics.checkNotNullExpressionValue(iconUrl, "iconUrl");
        Charset UTF_82 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
        aVar.f283519b = new String(iconUrl, UTF_82);
        ArrayList<Long> groupMasks = ufsDisSubBusinessItem.groupMasks;
        Intrinsics.checkNotNullExpressionValue(groupMasks, "groupMasks");
        longArray = CollectionsKt___CollectionsKt.toLongArray(groupMasks);
        aVar.f283520c = longArray;
        byte[] jumpUrl = ufsDisSubBusinessItem.jumpUrl;
        Intrinsics.checkNotNullExpressionValue(jumpUrl, "jumpUrl");
        Charset UTF_83 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_83, "UTF_8");
        aVar.f283521d = new String(jumpUrl, UTF_83);
        aVar.f283522e = ufsDisSubBusinessItem.hasRedDot;
        aVar.f283523f = ufsDisSubBusinessItem.redSeq;
        aVar.f283524g = ufsDisSubBusinessItem.bzid;
        return aVar;
    }
}

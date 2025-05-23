package com.tencent.mobileqq.cardcontainer.data;

import android.text.TextUtils;
import com.tencent.mobileqq.cardcontainer.framework.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J.\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007JD\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007Jt\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0007j\b\u0012\u0004\u0012\u00020\u0011`\tH\u0002Jt\u0010\u001e\u001a\u00020\u001c2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0007j\b\u0012\u0004\u0012\u00020\u0011`\tH\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010 \u001a\u00020\u001fH\u0007J\b\u0010$\u001a\u00020#H\u0007R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/data/ContainerDataUtil;", "", "", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "cardList", "", "source", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "Lkotlin/collections/ArrayList;", "e", "", "dataId", "Lcom/tencent/mobileqq/cardcontainer/data/CardType;", "viewType", "busiName", "data", "Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;", "d", "Lorg/json/JSONArray;", "cardItemListJson", "containerViewType", "cardContainerBg", "cardContainerTitle", "cardContainerSummary", "extrInfo", "reportData", "containerItemList", "", "g", "f", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/mobileqq/cardcontainer/data/b;", "c", "", "b", "Lkotlin/Lazy;", "a", "()Z", "mPushSwitch", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ContainerDataUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ContainerDataUtil f201074a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mPushSwitch;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40089);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f201074a = new ContainerDataUtil();
        lazy = LazyKt__LazyJVMKt.lazy(ContainerDataUtil$mPushSwitch$2.INSTANCE);
        mPushSwitch = lazy;
    }

    ContainerDataUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a() {
        return ((Boolean) mPushSwitch.getValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean b() {
        return f201074a.a();
    }

    @JvmStatic
    @Nullable
    public static final b c(@NotNull JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        try {
            String id5 = jsonObject.optString("itemId", "");
            String optString = jsonObject.optString("itemUid", "");
            String optString2 = jsonObject.optString("itemTitle", "");
            String optString3 = jsonObject.optString("itemSummary", "");
            String optString4 = jsonObject.optString("itemBgUrl", "");
            String optString5 = jsonObject.optString("itemScheme", "");
            String optString6 = jsonObject.optString("itemExtrData", "");
            String reportData = jsonObject.optString("itemReportData", "");
            Intrinsics.checkNotNullExpressionValue(id5, "id");
            Intrinsics.checkNotNullExpressionValue(reportData, "reportData");
            return new b(id5, optString, optString2, optString3, optString4, optString5, optString6, reportData);
        } catch (Exception e16) {
            QLog.e("CardContainer.ContainerDataUtil", 1, "parseCardItem " + e16);
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final ArrayList<ContainerData> d(int dataId, @NotNull CardType viewType, @NotNull String busiName, @NotNull String data, @NotNull String source) {
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(busiName, "busiName");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            QLog.d("CardContainer.ContainerDataUtil", 1, "parseContainerData dataId " + dataId + " viewType " + viewType + " busiName " + busiName + " source " + source + " ");
            JSONObject jSONObject = new JSONObject(data);
            String optString = jSONObject.optString("cardTitle", "");
            String optString2 = jSONObject.optString("cardSummary", "");
            String optString3 = jSONObject.optString("cardBgUrl", "");
            String optString4 = jSONObject.optString("cardExtrInfo", "");
            String optString5 = jSONObject.optString("cardReportData", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("cardSubItems");
            boolean f16 = com.tencent.mobileqq.cardcontainer.b.f201051a.f(viewType);
            ArrayList<ContainerData> arrayList = new ArrayList<>();
            if (f16) {
                f201074a.f(optJSONArray, dataId, viewType, busiName, optString3, optString, optString2, optString4, optString5, arrayList);
            } else {
                f201074a.g(optJSONArray, dataId, viewType, busiName, optString3, optString, optString2, optString4, optString5, arrayList);
            }
            return arrayList;
        } catch (Exception e16) {
            QLog.e("CardContainer.ContainerDataUtil", 1, "parseContainerData " + e16);
            return null;
        }
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<a> e(@NotNull List<TianShuAccess.AdItem> cardList, @NotNull String source) {
        List<TianShuAccess.MapEntry> list;
        Intrinsics.checkNotNullParameter(cardList, "cardList");
        Intrinsics.checkNotNullParameter(source, "source");
        ArrayList<a> arrayList = new ArrayList<>();
        com.tencent.mobileqq.cardcontainer.config.a a16 = com.tencent.mobileqq.cardcontainer.config.a.INSTANCE.a();
        try {
            int size = cardList.size();
            for (int i3 = 0; i3 < size; i3++) {
                int i16 = cardList.get(i3).iAdId.get();
                if (i16 > 0 && (list = cardList.get(i3).argList.get()) != null && list.size() != 0) {
                    String str = "";
                    String str2 = "";
                    String str3 = str2;
                    for (TianShuAccess.MapEntry mapEntry : list) {
                        String str4 = mapEntry.key.get();
                        if (str4.equals("temp_type")) {
                            str2 = mapEntry.value.get();
                            Intrinsics.checkNotNullExpressionValue(str2, "it.value.get()");
                        } else if (str4.equals("busi_name")) {
                            str = mapEntry.value.get();
                            Intrinsics.checkNotNullExpressionValue(str, "it.value.get()");
                        } else if (str4.equals("busi_data")) {
                            str3 = mapEntry.value.get();
                            Intrinsics.checkNotNullExpressionValue(str3, "it.value.get()");
                        }
                    }
                    if (!TextUtils.isEmpty(str) && !a16.f(str)) {
                        CardType a17 = CardType.INSTANCE.a(str2);
                        if (!TextUtils.isEmpty(str2) && a17 != CardType.Unknown) {
                            if (TextUtils.isEmpty(str3)) {
                                QLog.i("CardContainer.ContainerDataUtil", 1, "busiName " + ((Object) str) + " valueType " + ((Object) str2) + " jsonString is empty");
                            } else {
                                ArrayList<ContainerData> d16 = d(i16, a17, str, str3, source);
                                if (d16 != null) {
                                    arrayList.addAll(h.a(d16));
                                }
                            }
                        }
                        QLog.i("CardContainer.ContainerDataUtil", 1, "busiName " + ((Object) str) + " valueType is empty cardType == CardType.Unknown " + ((Object) str2));
                    }
                    QLog.i("CardContainer.ContainerDataUtil", 1, "busiName is empty || is blackList");
                }
            }
        } catch (Exception e16) {
            QLog.e("CardContainer.ContainerDataUtil", 1, "parseDataFromPB " + e16);
        }
        return arrayList;
    }

    private final void f(JSONArray cardItemListJson, int dataId, CardType containerViewType, String busiName, String cardContainerBg, String cardContainerTitle, String cardContainerSummary, String extrInfo, String reportData, ArrayList<ContainerData> containerItemList) {
        ArrayList arrayList = new ArrayList();
        if (cardItemListJson != null) {
            int length = cardItemListJson.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = cardItemListJson.optJSONObject(i3);
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "it.optJSONObject(i)");
                b c16 = c(optJSONObject);
                if (c16 != null) {
                    arrayList.add(c16);
                }
            }
        }
        ContainerData g16 = com.tencent.mobileqq.cardcontainer.b.f201051a.g(new ContainerData(dataId, containerViewType, busiName, cardContainerBg, cardContainerTitle, cardContainerSummary, arrayList, extrInfo, reportData));
        if (g16 != null) {
            containerItemList.add(g16);
        }
    }

    private final void g(JSONArray cardItemListJson, int dataId, CardType containerViewType, String busiName, String cardContainerBg, String cardContainerTitle, String cardContainerSummary, String extrInfo, String reportData, ArrayList<ContainerData> containerItemList) {
        if (cardItemListJson != null) {
            int length = cardItemListJson.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = cardItemListJson.optJSONObject(i3);
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "it.optJSONObject(i)");
                b c16 = c(optJSONObject);
                if (c16 != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(c16);
                    ContainerData g16 = com.tencent.mobileqq.cardcontainer.b.f201051a.g(new ContainerData(dataId, containerViewType, busiName, cardContainerBg, cardContainerTitle, cardContainerSummary, arrayList, extrInfo, reportData));
                    if (g16 != null) {
                        containerItemList.add(g16);
                    }
                }
            }
        }
    }
}

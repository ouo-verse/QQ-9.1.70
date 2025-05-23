package com.tencent.mobileqq.guild.aisearch;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.aisearch.history.AIChatHistoryGroupItem;
import com.tencent.mobileqq.guild.aisearch.history.AIChatHistorySessionItem;
import com.tencent.mobileqq.guild.aisearch.models.HistoryCheckData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchGetSessionListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSession;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchUserSessionCategory;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.bj;
import wh2.em;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 H2\u00020\u0001:\u0001IB\u0007\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0018\u0010\u0016\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0014J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJY\u0010$\u001a\u00020\u00042Q\u0010#\u001aM\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00040\u001dJ\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R0\u00107\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001403j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014`48\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020\u0014088\u0006\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R-\u0010B\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020?0>j\b\u0012\u0004\u0012\u00020?`@088\u0006\u00a2\u0006\f\n\u0004\b1\u0010:\u001a\u0004\bA\u0010<R\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00020C088\u0006\u00a2\u0006\f\n\u0004\b)\u0010:\u001a\u0004\bD\u0010<\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/w;", "Lef1/b;", "", "e2", "", "m2", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAISearchUserSessionCategory;", "userSessionList", "Q1", "f2", "", "groupTitle", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAISearchSession;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/guild/aisearch/history/f;", "U1", SemanticAttributes.DbSystemValues.H2, "j2", "currentItem", "", "checked", "l2", "updateLiveData", "S1", "g2", "checkAll", "R1", "Z1", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "result", "errMsg", "deleteList", "callback", "W1", "Lkotlin/Pair;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", BdhLogUtil.LogTag.Tag_Conn, "J", "cookie", "D", "Z", "isCacheData", "E", "isCheckAllHistories", UserInfo.SEX_FEMALE, "I", "historyTotalCount", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "G", "Ljava/util/HashMap;", "checkedHistories", "Lko4/a;", "H", "Lko4/a;", "b2", "()Lko4/a;", "hasMoreLiveData", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/aisearch/history/a;", "Lkotlin/collections/ArrayList;", "d2", "historyListLiveData", "Lcom/tencent/mobileqq/guild/aisearch/models/g;", "c2", "historyCheckLiveData", "<init>", "()V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class w extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    private long cookie;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isCacheData;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isCheckAllHistories;

    /* renamed from: F, reason: from kotlin metadata */
    private int historyTotalCount;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, Boolean> checkedHistories = new HashMap<>();

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ko4.a<Boolean> hasMoreLiveData = new ko4.a<>();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ko4.a<ArrayList<AIChatHistoryGroupItem>> historyListLiveData = new ko4.a<>();

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final ko4.a<HistoryCheckData> historyCheckLiveData = new ko4.a<>();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v8, types: [T, java.lang.Object, com.tencent.mobileqq.guild.aisearch.history.a] */
    /* JADX WARN: Type inference failed for: r7v0, types: [T, java.lang.Object] */
    private final void Q1(List<? extends IGProAISearchUserSessionCategory> userSessionList) {
        ArrayList<IGProAISearchSession> arrayList;
        boolean z16;
        ?? lastOrNull;
        String str;
        ArrayList<IGProAISearchSession> sessionList;
        boolean z17;
        ArrayList value = this.historyListLiveData.getValue();
        if (value == null) {
            value = new ArrayList();
        }
        for (IGProAISearchUserSessionCategory iGProAISearchUserSessionCategory : userSessionList) {
            boolean z18 = true;
            if (iGProAISearchUserSessionCategory != null && (sessionList = iGProAISearchUserSessionCategory.getSessionList()) != null) {
                Intrinsics.checkNotNullExpressionValue(sessionList, "sessionList");
                arrayList = new ArrayList();
                for (Object obj : sessionList) {
                    IGProAISearchSession iGProAISearchSession = (IGProAISearchSession) obj;
                    if (iGProAISearchSession != null && iGProAISearchSession.getIsDeleted() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        arrayList.add(obj);
                    }
                }
            } else {
                arrayList = null;
            }
            ArrayList arrayList2 = arrayList;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends ??>) value);
                objectRef.element = lastOrNull;
                String categoryName = iGProAISearchUserSessionCategory.getCategoryName();
                if (categoryName == null) {
                    categoryName = "";
                }
                if (categoryName.length() != 0) {
                    z18 = false;
                }
                if (z18) {
                    categoryName = "\u672a\u77e5\u5206\u7ec4";
                }
                AIChatHistoryGroupItem aIChatHistoryGroupItem = (AIChatHistoryGroupItem) objectRef.element;
                if (aIChatHistoryGroupItem != null) {
                    str = aIChatHistoryGroupItem.getGroupTitle();
                } else {
                    str = null;
                }
                if (!Intrinsics.areEqual(categoryName, str)) {
                    ?? aIChatHistoryGroupItem2 = new AIChatHistoryGroupItem(categoryName, null, 2, null);
                    value.add(aIChatHistoryGroupItem2);
                    objectRef.element = aIChatHistoryGroupItem2;
                }
                for (IGProAISearchSession session : arrayList) {
                    Intrinsics.checkNotNullExpressionValue(session, "session");
                    ((AIChatHistoryGroupItem) objectRef.element).b().add(U1(categoryName, session));
                }
            }
        }
        this.historyListLiveData.setValue(value);
    }

    public static /* synthetic */ void T1(w wVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        wVar.S1(z16);
    }

    private final AIChatHistorySessionItem U1(String groupTitle, IGProAISearchSession item) {
        String sessionId = item.getSessionId();
        String firstMsgId = item.getFirstMsgId();
        String summary = item.getSummary();
        long timestamp = item.getTimestamp();
        Intrinsics.checkNotNullExpressionValue(sessionId, "sessionId");
        Intrinsics.checkNotNullExpressionValue(firstMsgId, "firstMsgId");
        Intrinsics.checkNotNullExpressionValue(summary, "summary");
        return new AIChatHistorySessionItem(sessionId, firstMsgId, summary, timestamp, groupTitle, 0, 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(w this$0, com.tencent.mobileqq.qqguildsdk.data.genc.a req, Function3 callback, int i3, String errMsg) {
        int i16;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        ArrayList arrayList = new ArrayList();
        if (i3 == 0) {
            ArrayList<AIChatHistoryGroupItem> value = this$0.historyListLiveData.getValue();
            if (value == null) {
                value = new ArrayList<>();
            }
            ArrayList<AIChatHistoryGroupItem> arrayList2 = new ArrayList<>();
            if (req.b()) {
                Iterator<AIChatHistoryGroupItem> it = value.iterator();
                i16 = 0;
                while (it.hasNext()) {
                    AIChatHistoryGroupItem next = it.next();
                    int size = next.b().size();
                    ArrayList<AIChatHistorySessionItem> b16 = next.b();
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : b16) {
                        AIChatHistorySessionItem aIChatHistorySessionItem = (AIChatHistorySessionItem) obj;
                        if (req.c().contains(aIChatHistorySessionItem.getSessionId())) {
                            z17 = true;
                        } else {
                            arrayList.add(aIChatHistorySessionItem.getSessionId());
                            z17 = false;
                        }
                        if (z17) {
                            arrayList3.add(obj);
                        }
                    }
                    next.c(new ArrayList<>(arrayList3));
                    i16 += size - next.b().size();
                    if (!next.b().isEmpty()) {
                        arrayList2.add(next);
                    }
                }
            } else {
                Iterator<AIChatHistoryGroupItem> it5 = value.iterator();
                i16 = 0;
                while (it5.hasNext()) {
                    AIChatHistoryGroupItem next2 = it5.next();
                    int size2 = next2.b().size();
                    ArrayList<AIChatHistorySessionItem> b17 = next2.b();
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj2 : b17) {
                        AIChatHistorySessionItem aIChatHistorySessionItem2 = (AIChatHistorySessionItem) obj2;
                        if (req.a().contains(aIChatHistorySessionItem2.getSessionId())) {
                            arrayList.add(aIChatHistorySessionItem2.getSessionId());
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (z16) {
                            arrayList4.add(obj2);
                        }
                    }
                    next2.c(new ArrayList<>(arrayList4));
                    i16 += size2 - next2.b().size();
                    if (!next2.b().isEmpty()) {
                        arrayList2.add(next2);
                    }
                }
            }
            this$0.historyListLiveData.setValue(arrayList2);
            int i17 = this$0.historyTotalCount;
            if (i17 > 0) {
                this$0.historyTotalCount = i17 - i16;
            }
            this$0.checkedHistories.clear();
            this$0.isCheckAllHistories = false;
            this$0.m2();
        }
        callback.invoke(Integer.valueOf(i3), errMsg, arrayList);
    }

    private final int e2() {
        int i3 = this.historyTotalCount;
        if (i3 > 0) {
            return i3;
        }
        ArrayList<AIChatHistoryGroupItem> value = this.historyListLiveData.getValue();
        int i16 = 0;
        if (value != null) {
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                i16 += ((AIChatHistoryGroupItem) it.next()).b().size();
            }
        }
        return i16;
    }

    private final void f2(List<? extends IGProAISearchUserSessionCategory> userSessionList) {
        boolean z16;
        Object first;
        Object first2;
        Object last;
        List plus;
        Object last2;
        ArrayList<IGProAISearchSession> arrayList;
        boolean z17;
        ArrayList<IGProAISearchSession> sessionList;
        boolean z18;
        boolean z19;
        ArrayList<AIChatHistoryGroupItem> value = this.historyListLiveData.getValue();
        if (value != null && !value.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) value);
            AIChatHistoryGroupItem aIChatHistoryGroupItem = (AIChatHistoryGroupItem) first;
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) aIChatHistoryGroupItem.b());
            AIChatHistorySessionItem aIChatHistorySessionItem = (AIChatHistorySessionItem) first2;
            ArrayList arrayList2 = new ArrayList();
            for (IGProAISearchUserSessionCategory iGProAISearchUserSessionCategory : userSessionList) {
                if (iGProAISearchUserSessionCategory != null && (sessionList = iGProAISearchUserSessionCategory.getSessionList()) != null) {
                    Intrinsics.checkNotNullExpressionValue(sessionList, "sessionList");
                    arrayList = new ArrayList();
                    for (Object obj : sessionList) {
                        IGProAISearchSession iGProAISearchSession = (IGProAISearchSession) obj;
                        if (iGProAISearchSession != null && iGProAISearchSession.getIsDeleted() == 0) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18 && iGProAISearchSession.getTimestamp() > aIChatHistorySessionItem.getQueryTime()) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (z19) {
                            arrayList.add(obj);
                        }
                    }
                } else {
                    arrayList = null;
                }
                ArrayList arrayList3 = arrayList;
                if (arrayList3 != null && !arrayList3.isEmpty()) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    String categoryName = iGProAISearchUserSessionCategory.getCategoryName();
                    Intrinsics.checkNotNullExpressionValue(categoryName, "item.categoryName");
                    AIChatHistoryGroupItem aIChatHistoryGroupItem2 = new AIChatHistoryGroupItem(categoryName, null, 2, null);
                    arrayList2.add(aIChatHistoryGroupItem2);
                    for (IGProAISearchSession session : arrayList) {
                        ArrayList<AIChatHistorySessionItem> b16 = aIChatHistoryGroupItem2.b();
                        String categoryName2 = iGProAISearchUserSessionCategory.getCategoryName();
                        Intrinsics.checkNotNullExpressionValue(categoryName2, "item.categoryName");
                        Intrinsics.checkNotNullExpressionValue(session, "session");
                        b16.add(U1(categoryName2, session));
                    }
                }
            }
            if (!arrayList2.isEmpty()) {
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList2);
                if (Intrinsics.areEqual(((AIChatHistoryGroupItem) last).getGroupTitle(), aIChatHistoryGroupItem.getGroupTitle())) {
                    ArrayList<AIChatHistorySessionItem> b17 = aIChatHistoryGroupItem.b();
                    last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList2);
                    b17.addAll(0, ((AIChatHistoryGroupItem) last2).b());
                    CollectionsKt__MutableCollectionsKt.removeLast(arrayList2);
                }
                ko4.a<ArrayList<AIChatHistoryGroupItem>> aVar = this.historyListLiveData;
                plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList2, (Iterable) value);
                aVar.setValue(new ArrayList<>(plus));
                return;
            }
            return;
        }
        Q1(userSessionList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(w this$0, int i3, String str, boolean z16, IGProAISearchGetSessionListRsp iGProAISearchGetSessionListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (iGProAISearchGetSessionListRsp == null) {
            if (str == null) {
                str = "";
            }
            com.tencent.mobileqq.guild.util.s.e("AIHistoryListViewModel", str, new RuntimeException("rsp is null"));
            return;
        }
        boolean z17 = false;
        if (i3 != 0) {
            if (!z16) {
                ArrayList<AIChatHistoryGroupItem> value = this$0.historyListLiveData.getValue();
                if (value == null || value.isEmpty()) {
                    z17 = true;
                }
                if (z17) {
                    SecurityTipHelperKt.F(null, i3, str, null, null, null, 56, null);
                }
            }
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "loadHistory error: " + str + ", result: " + i3;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("AIHistoryListViewModel", 1, (String) it.next(), null);
            }
            return;
        }
        if (!z16 && !this$0.isCacheData) {
            ArrayList<AIChatHistoryGroupItem> value2 = this$0.historyListLiveData.getValue();
            if (value2 == null || value2.isEmpty()) {
                z17 = true;
            }
            if (!z17) {
                ArrayList<IGProAISearchUserSessionCategory> userSessionList = iGProAISearchGetSessionListRsp.getUserSessionList();
                Intrinsics.checkNotNullExpressionValue(userSessionList, "rsp.userSessionList");
                this$0.f2(userSessionList);
                this$0.historyTotalCount = (int) iGProAISearchGetSessionListRsp.getTotalCount();
                this$0.isCacheData = z16;
            }
        }
        ArrayList<AIChatHistoryGroupItem> value3 = this$0.historyListLiveData.getValue();
        if (value3 != null) {
            value3.clear();
        }
        this$0.cookie = iGProAISearchGetSessionListRsp.getCookie();
        this$0.hasMoreLiveData.setValue(Boolean.valueOf(!iGProAISearchGetSessionListRsp.getIsFinished()));
        ArrayList<IGProAISearchUserSessionCategory> userSessionList2 = iGProAISearchGetSessionListRsp.getUserSessionList();
        Intrinsics.checkNotNullExpressionValue(userSessionList2, "rsp.userSessionList");
        this$0.Q1(userSessionList2);
        this$0.historyTotalCount = (int) iGProAISearchGetSessionListRsp.getTotalCount();
        this$0.isCacheData = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(w this$0, int i3, String str, boolean z16, IGProAISearchGetSessionListRsp iGProAISearchGetSessionListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (iGProAISearchGetSessionListRsp == null) {
            if (str == null) {
                str = "";
            }
            com.tencent.mobileqq.guild.util.s.e("AIHistoryListViewModel", str, new RuntimeException("rsp is null"));
            return;
        }
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "loadMoreHistory error: " + str + ", result: " + i3;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("AIHistoryListViewModel", 1, (String) it.next(), null);
            }
            return;
        }
        if (z16) {
            if (str == null) {
                str = "";
            }
            com.tencent.mobileqq.guild.util.s.e("AIHistoryListViewModel", str, new RuntimeException("cache data is unexpected"));
        }
        this$0.isCacheData = false;
        this$0.cookie = iGProAISearchGetSessionListRsp.getCookie();
        this$0.hasMoreLiveData.setValue(Boolean.valueOf(!iGProAISearchGetSessionListRsp.getIsFinished()));
        this$0.historyTotalCount = (int) iGProAISearchGetSessionListRsp.getTotalCount();
        ArrayList<IGProAISearchUserSessionCategory> userSessionList = iGProAISearchGetSessionListRsp.getUserSessionList();
        Intrinsics.checkNotNullExpressionValue(userSessionList, "rsp.userSessionList");
        this$0.Q1(userSessionList);
    }

    private final void m2() {
        int e26 = e2();
        int i3 = 0;
        if (this.isCheckAllHistories) {
            HashMap<String, Boolean> hashMap = this.checkedHistories;
            if (!hashMap.isEmpty()) {
                Iterator<Map.Entry<String, Boolean>> it = hashMap.entrySet().iterator();
                while (it.hasNext()) {
                    if (!it.next().getValue().booleanValue()) {
                        i3++;
                    }
                }
            }
            i3 = e26 - i3;
        } else {
            HashMap<String, Boolean> hashMap2 = this.checkedHistories;
            if (!hashMap2.isEmpty()) {
                Iterator<Map.Entry<String, Boolean>> it5 = hashMap2.entrySet().iterator();
                while (it5.hasNext()) {
                    if (it5.next().getValue().booleanValue()) {
                        i3++;
                    }
                }
            }
        }
        this.historyCheckLiveData.setValue(new HistoryCheckData(e26, i3));
    }

    public final void R1(boolean checkAll) {
        this.isCheckAllHistories = checkAll;
        this.checkedHistories.clear();
        m2();
    }

    public final void S1(boolean updateLiveData) {
        this.checkedHistories.clear();
        this.isCheckAllHistories = false;
        if (updateLiveData) {
            ArrayList<AIChatHistoryGroupItem> value = this.historyListLiveData.getValue();
            if (value == null) {
                value = new ArrayList<>();
            }
            this.historyListLiveData.setValue(new ArrayList<>(value));
        }
        m2();
    }

    public final void W1(@NotNull final Function3<? super Integer, ? super String, ? super List<String>, Unit> callback) {
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        final com.tencent.mobileqq.qqguildsdk.data.genc.a aVar = new com.tencent.mobileqq.qqguildsdk.data.genc.a();
        aVar.d(this.isCheckAllHistories);
        if (this.isCheckAllHistories) {
            HashMap<String, Boolean> hashMap = this.checkedHistories;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, Boolean> entry : hashMap.entrySet()) {
                if (!entry.getValue().booleanValue()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add((String) ((Map.Entry) it.next()).getKey());
            }
            aVar.c().addAll(arrayList);
        } else {
            HashMap<String, Boolean> hashMap2 = this.checkedHistories;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry<String, Boolean> entry2 : hashMap2.entrySet()) {
                if (entry2.getValue().booleanValue()) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            ArrayList arrayList2 = new ArrayList(linkedHashMap2.size());
            Iterator it5 = linkedHashMap2.entrySet().iterator();
            while (it5.hasNext()) {
                arrayList2.add((String) ((Map.Entry) it5.next()).getKey());
            }
            aVar.a().addAll(arrayList2);
        }
        if (iGPSService != null) {
            iGPSService.batchDeleteAISearchSession(aVar, new em() { // from class: com.tencent.mobileqq.guild.aisearch.v
                @Override // wh2.em
                public final void onResult(int i3, String str) {
                    w.X1(w.this, aVar, callback, i3, str);
                }
            });
        }
    }

    public final void Z1(@NotNull AIChatHistorySessionItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        ArrayList<AIChatHistoryGroupItem> value = this.historyListLiveData.getValue();
        if (value == null) {
            value = new ArrayList<>();
        }
        ArrayList<AIChatHistoryGroupItem> arrayList = new ArrayList<>();
        Iterator<AIChatHistoryGroupItem> it = value.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            AIChatHistoryGroupItem next = it.next();
            int size = next.b().size();
            ArrayList<AIChatHistorySessionItem> b16 = next.b();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : b16) {
                if (!Intrinsics.areEqual(((AIChatHistorySessionItem) obj).getSessionId(), item.getSessionId())) {
                    arrayList2.add(obj);
                }
            }
            next.c(new ArrayList<>(arrayList2));
            i3 += size - next.b().size();
            if (!next.b().isEmpty()) {
                arrayList.add(next);
            }
        }
        this.historyListLiveData.setValue(arrayList);
        int i16 = this.historyTotalCount;
        if (i16 > 0) {
            this.historyTotalCount = i16 - i3;
        }
    }

    @NotNull
    public final Pair<Boolean, List<String>> a2() {
        ArrayList arrayList;
        if (this.isCheckAllHistories) {
            HashMap<String, Boolean> hashMap = this.checkedHistories;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, Boolean> entry : hashMap.entrySet()) {
                if (!entry.getValue().booleanValue()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            arrayList = new ArrayList(linkedHashMap.size());
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add((String) ((Map.Entry) it.next()).getKey());
            }
        } else {
            HashMap<String, Boolean> hashMap2 = this.checkedHistories;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry<String, Boolean> entry2 : hashMap2.entrySet()) {
                if (entry2.getValue().booleanValue()) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            arrayList = new ArrayList(linkedHashMap2.size());
            Iterator it5 = linkedHashMap2.entrySet().iterator();
            while (it5.hasNext()) {
                arrayList.add((String) ((Map.Entry) it5.next()).getKey());
            }
        }
        return new Pair<>(Boolean.valueOf(this.isCheckAllHistories), arrayList);
    }

    @NotNull
    public final ko4.a<Boolean> b2() {
        return this.hasMoreLiveData;
    }

    @NotNull
    public final ko4.a<HistoryCheckData> c2() {
        return this.historyCheckLiveData;
    }

    @NotNull
    public final ko4.a<ArrayList<AIChatHistoryGroupItem>> d2() {
        return this.historyListLiveData;
    }

    public final boolean g2(@Nullable AIChatHistorySessionItem item) {
        String sessionId;
        if (item != null && (sessionId = item.getSessionId()) != null) {
            Boolean bool = this.checkedHistories.get(sessionId);
            if (bool == null) {
                return this.isCheckAllHistories;
            }
            return bool.booleanValue();
        }
        return false;
    }

    public final void h2() {
        boolean z16;
        com.tencent.mobileqq.qqguildsdk.data.genc.c cVar = new com.tencent.mobileqq.qqguildsdk.data.genc.c();
        cVar.b(0L);
        if (this.historyListLiveData.getValue() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).getAISearchSessionList(cVar, z16, new bj() { // from class: com.tencent.mobileqq.guild.aisearch.u
            @Override // wh2.bj
            public final void a(int i3, String str, boolean z17, IGProAISearchGetSessionListRsp iGProAISearchGetSessionListRsp) {
                w.i2(w.this, i3, str, z17, iGProAISearchGetSessionListRsp);
            }
        });
    }

    public final void j2() {
        com.tencent.mobileqq.qqguildsdk.data.genc.c cVar = new com.tencent.mobileqq.qqguildsdk.data.genc.c();
        cVar.b(this.cookie);
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).getAISearchSessionList(cVar, false, new bj() { // from class: com.tencent.mobileqq.guild.aisearch.t
            @Override // wh2.bj
            public final void a(int i3, String str, boolean z16, IGProAISearchGetSessionListRsp iGProAISearchGetSessionListRsp) {
                w.k2(w.this, i3, str, z16, iGProAISearchGetSessionListRsp);
            }
        });
    }

    public final void l2(@Nullable AIChatHistorySessionItem currentItem, boolean checked) {
        String sessionId;
        Logger.f235387a.d().d("AIHistoryListViewModel", 1, "updateSelected: " + currentItem + ", checked: " + checked);
        if (currentItem != null && (sessionId = currentItem.getSessionId()) != null) {
            this.checkedHistories.put(sessionId, Boolean.valueOf(checked));
            m2();
        }
    }
}

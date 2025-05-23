package com.tencent.qqnt.search.convert;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqdataline.api.IQQDataLineApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.nativeinterface.SearchBuddyChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatSummaryItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchHitInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgItem;
import com.tencent.qqnt.search.api.ISearchConvertAPI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0001H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0001H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0001H\u0016J2\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0001H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0001H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0001H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/search/convert/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatSummaryItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "", "splitKeyword", "", "d", "originObj", "", h.F, "g", "f", "keyword", "segmentKeyword", "b", "c", "e", "", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/search/convert/a$a;", "", "", "FACE_SIZE", "I", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.search.convert.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56023);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final CharSequence d(SearchChatSummaryItem item, List<String> splitKeyword) {
        Object first;
        if (item.msgCount != 1) {
            return null;
        }
        ArrayList<SearchMsgItem> arrayList = item.msgItem;
        Intrinsics.checkNotNullExpressionValue(arrayList, "item.msgItem");
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
        SearchMsgItem msgItem = (SearchMsgItem) first;
        ISearchConvertAPI iSearchConvertAPI = (ISearchConvertAPI) QRoute.api(ISearchConvertAPI.class);
        Intrinsics.checkNotNullExpressionValue(msgItem, "msgItem");
        return iSearchConvertAPI.getMsgHighLight(msgItem, splitKeyword);
    }

    public int a(@NotNull Object originObj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, originObj)).intValue();
        }
        Intrinsics.checkNotNullParameter(originObj, "originObj");
        if (!(originObj instanceof SearchChatSummaryItem)) {
            return 0;
        }
        return ((SearchChatSummaryItem) originObj).chatType;
    }

    @Nullable
    public CharSequence b(@NotNull Object originObj, @NotNull String keyword, @Nullable String segmentKeyword, @NotNull List<String> splitKeyword) {
        List<String> mutableList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CharSequence) iPatchRedirector.redirect((short) 5, this, originObj, keyword, segmentKeyword, splitKeyword);
        }
        Intrinsics.checkNotNullParameter(originObj, "originObj");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(splitKeyword, "splitKeyword");
        if (!(originObj instanceof SearchChatSummaryItem)) {
            return null;
        }
        SearchChatSummaryItem searchChatSummaryItem = (SearchChatSummaryItem) originObj;
        int i3 = searchChatSummaryItem.msgCount;
        if (i3 <= 1) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) splitKeyword);
            if (!mutableList.contains(keyword)) {
                mutableList.add(keyword);
            }
            if (segmentKeyword != null && !mutableList.contains(segmentKeyword)) {
                mutableList.add(segmentKeyword);
            }
            return d(searchChatSummaryItem, mutableList);
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        String string = mobileQQ.getString(R.string.f224686jl, Integer.valueOf(i3));
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026ips1, originObj.msgCount)");
        String string2 = mobileQQ.getString(R.string.f224696jm);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(com.te\u2026string.search_more_tips2)");
        SpannableStringBuilder append = new SpannableStringBuilder(string).append((CharSequence) keyword).append((CharSequence) string2);
        append.setSpan(new ForegroundColorSpan(com.tencent.mobileqq.search.util.a.a()), string.length(), string.length() + keyword.length(), 17);
        return append;
    }

    @Nullable
    public String c(@NotNull Object originObj) {
        Object firstOrNull;
        Object firstOrNull2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, originObj);
        }
        Intrinsics.checkNotNullParameter(originObj, "originObj");
        if (!(originObj instanceof SearchChatSummaryItem)) {
            return null;
        }
        ArrayList<SearchMsgItem> arrayList = ((SearchChatSummaryItem) originObj).msgItem;
        Intrinsics.checkNotNullExpressionValue(arrayList, "originObj.msgItem");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        SearchMsgItem searchMsgItem = (SearchMsgItem) firstOrNull;
        if (searchMsgItem == null) {
            return null;
        }
        ArrayList<SearchHitInfo> arrayList2 = searchMsgItem.hitsInfo;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "firstMsg.hitsInfo");
        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
        SearchHitInfo searchHitInfo = (SearchHitInfo) firstOrNull2;
        if (searchHitInfo == null) {
            return null;
        }
        String text = searchMsgItem.fieldText;
        Intrinsics.checkNotNullExpressionValue(text, "text");
        String substring = text.substring(searchHitInfo.start, searchHitInfo.end);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    @Nullable
    public String e(@NotNull Object originObj) {
        Object firstOrNull;
        IKernelService iKernelService;
        Object firstOrNull2;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, originObj);
        }
        Intrinsics.checkNotNullParameter(originObj, "originObj");
        Long l3 = null;
        if (!(originObj instanceof SearchChatSummaryItem)) {
            return null;
        }
        SearchChatSummaryItem searchChatSummaryItem = (SearchChatSummaryItem) originObj;
        if (searchChatSummaryItem.chatType == 1) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null || (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) == null) {
                return "";
            }
            ArrayList<SearchBuddyChatInfo> arrayList = searchChatSummaryItem.buddyChatInfo;
            Intrinsics.checkNotNullExpressionValue(arrayList, "originObj.buddyChatInfo");
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            SearchBuddyChatInfo searchBuddyChatInfo = (SearchBuddyChatInfo) firstOrNull2;
            if (searchBuddyChatInfo != null) {
                str = searchBuddyChatInfo.peerUid;
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            ag uixConvertService = iKernelService.getUixConvertService();
            if (uixConvertService != null) {
                l3 = uixConvertService.z0(str);
            }
            return String.valueOf(l3);
        }
        ArrayList<SearchGroupChatInfo> arrayList2 = searchChatSummaryItem.groupChatInfo;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "originObj.groupChatInfo");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
        SearchGroupChatInfo searchGroupChatInfo = (SearchGroupChatInfo) firstOrNull;
        if (searchGroupChatInfo != null) {
            l3 = Long.valueOf(searchGroupChatInfo.groupCode);
        }
        return String.valueOf(l3);
    }

    @Nullable
    public CharSequence f(@NotNull Object originObj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CharSequence) iPatchRedirector.redirect((short) 4, (Object) this, originObj);
        }
        Intrinsics.checkNotNullParameter(originObj, "originObj");
        return "";
    }

    @Nullable
    public CharSequence g(@NotNull Object originObj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this, originObj);
        }
        Intrinsics.checkNotNullParameter(originObj, "originObj");
        if (originObj instanceof SearchChatSummaryItem) {
            SearchChatSummaryItem searchChatSummaryItem = (SearchChatSummaryItem) originObj;
            Intrinsics.checkNotNullExpressionValue(searchChatSummaryItem.buddyChatInfo, "originObj.buddyChatInfo");
            boolean z17 = true;
            if (!r0.isEmpty()) {
                String title = searchChatSummaryItem.buddyChatInfo.get(0).remark;
                Intrinsics.checkNotNullExpressionValue(title, "title");
                if (title.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    title = searchChatSummaryItem.buddyChatInfo.get(0).peerNick;
                }
                Intrinsics.checkNotNullExpressionValue(title, "title");
                if (title.length() != 0) {
                    z17 = false;
                }
                if (z17) {
                    return String.valueOf(searchChatSummaryItem.buddyChatInfo.get(0).peerUin);
                }
                return title;
            }
            Intrinsics.checkNotNullExpressionValue(searchChatSummaryItem.groupChatInfo, "originObj.groupChatInfo");
            if (!r0.isEmpty()) {
                return searchChatSummaryItem.groupChatInfo.get(0).groupName;
            }
            Intrinsics.checkNotNullExpressionValue(searchChatSummaryItem.discussChatInfo, "originObj.discussChatInfo");
            if (!r0.isEmpty()) {
                return searchChatSummaryItem.discussChatInfo.get(0).discussName;
            }
            Intrinsics.checkNotNullExpressionValue(searchChatSummaryItem.dataLineChatInfo, "originObj.dataLineChatInfo");
            if (!r0.isEmpty()) {
                return ((IQQDataLineApi) QRoute.api(IQQDataLineApi.class)).getDeviceNameFromUid(BaseApplication.context, searchChatSummaryItem.dataLineChatInfo.get(0).uid);
            }
            return "";
        }
        return null;
    }

    public boolean h(@NotNull Object originObj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, originObj)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(originObj, "originObj");
        return originObj instanceof SearchChatSummaryItem;
    }
}

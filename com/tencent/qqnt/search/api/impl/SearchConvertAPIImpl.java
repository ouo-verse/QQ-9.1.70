package com.tencent.qqnt.search.api.impl;

import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatSummaryItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgItem;
import com.tencent.qqnt.search.api.ISearchConvertAPI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J2\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/search/api/impl/SearchConvertAPIImpl;", "Lcom/tencent/qqnt/search/api/ISearchConvertAPI;", "", "originObj", "Lcom/tencent/qqnt/search/convert/a;", "findProcessConverter", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatSummaryItem;", "searchMsg", "", "getSearchMsgCount", "", "interestedIn", "", "getTitle", "getSubTitle", "", "keyword", "segmentKeyword", "", "splitKeyword", "getDescription", "getKeyword", "getPeerUid", "getChatType", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;", "msgItem", "getMsgHighLight", "converterList", "Ljava/util/List;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class SearchConvertAPIImpl implements ISearchConvertAPI {
    static IPatchRedirector $redirector_;

    @NotNull
    private final List<com.tencent.qqnt.search.convert.a> converterList;

    public SearchConvertAPIImpl() {
        List<com.tencent.qqnt.search.convert.a> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new com.tencent.qqnt.search.convert.a());
            this.converterList = listOf;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.qqnt.search.convert.a findProcessConverter(Object originObj) {
        Object obj;
        Iterator<T> it = this.converterList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((com.tencent.qqnt.search.convert.a) obj).h(originObj)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (com.tencent.qqnt.search.convert.a) obj;
    }

    @Override // com.tencent.qqnt.search.api.ISearchConvertAPI
    public int getChatType(@NotNull Object originObj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, originObj)).intValue();
        }
        Intrinsics.checkNotNullParameter(originObj, "originObj");
        com.tencent.qqnt.search.convert.a findProcessConverter = findProcessConverter(originObj);
        if (findProcessConverter != null) {
            return findProcessConverter.a(originObj);
        }
        return 0;
    }

    @Override // com.tencent.qqnt.search.api.ISearchConvertAPI
    @Nullable
    public CharSequence getDescription(@NotNull Object originObj, @NotNull String keyword, @Nullable String segmentKeyword, @NotNull List<String> splitKeyword) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CharSequence) iPatchRedirector.redirect((short) 6, this, originObj, keyword, segmentKeyword, splitKeyword);
        }
        Intrinsics.checkNotNullParameter(originObj, "originObj");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(splitKeyword, "splitKeyword");
        com.tencent.qqnt.search.convert.a findProcessConverter = findProcessConverter(originObj);
        if (findProcessConverter != null) {
            return findProcessConverter.b(originObj, keyword, segmentKeyword, splitKeyword);
        }
        return null;
    }

    @Override // com.tencent.qqnt.search.api.ISearchConvertAPI
    @Nullable
    public String getKeyword(@NotNull Object originObj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, originObj);
        }
        Intrinsics.checkNotNullParameter(originObj, "originObj");
        com.tencent.qqnt.search.convert.a findProcessConverter = findProcessConverter(originObj);
        if (findProcessConverter != null) {
            return findProcessConverter.c(originObj);
        }
        return null;
    }

    @Override // com.tencent.qqnt.search.api.ISearchConvertAPI
    @NotNull
    public CharSequence getMsgHighLight(@NotNull SearchMsgItem msgItem, @NotNull List<String> splitKeyword) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (CharSequence) iPatchRedirector.redirect((short) 10, (Object) this, (Object) msgItem, (Object) splitKeyword);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(splitKeyword, "splitKeyword");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        MsgRecord msgRecord = msgItem.msgRecord;
        Intrinsics.checkNotNullExpressionValue(msgRecord, "msgItem.msgRecord");
        if (!com.tencent.mobileqq.aio.utils.d.G(msgRecord)) {
            MsgRecord msgRecord2 = msgItem.msgRecord;
            Intrinsics.checkNotNullExpressionValue(msgRecord2, "msgItem.msgRecord");
            if (!com.tencent.mobileqq.aio.utils.d.T(msgRecord2)) {
                MsgRecord msgRecord3 = msgItem.msgRecord;
                Intrinsics.checkNotNullExpressionValue(msgRecord3, "msgItem.msgRecord");
                if (!com.tencent.mobileqq.aio.utils.d.u(msgRecord3)) {
                    ArrayList<MsgElement> arrayList = msgItem.msgRecord.elements;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
                    Iterator<T> it = arrayList.iterator();
                    while (true) {
                        z16 = true;
                        if (!it.hasNext()) {
                            break;
                        }
                        MsgElement msgElement = (MsgElement) it.next();
                        int i3 = msgElement.elementType;
                        if (i3 == 6) {
                            IEmojiSpanService iEmojiSpanService = (IEmojiSpanService) QRoute.api(IEmojiSpanService.class);
                            FaceElement faceElement = msgElement.faceElement;
                            spannableStringBuilder.append(iEmojiSpanService.createEmojiSpanText(faceElement.faceType, faceElement.faceIndex, 0, false, 15)).toString();
                        } else if (i3 == 1) {
                            spannableStringBuilder.append((CharSequence) msgElement.textElement.content);
                        }
                    }
                    if (spannableStringBuilder.length() != 0) {
                        z16 = false;
                    }
                    if (z16) {
                        spannableStringBuilder.append((CharSequence) msgItem.fieldText);
                    }
                    return new QQText(SearchUtils.Y(spannableStringBuilder.toString(), 0, splitKeyword), 3, 15);
                }
            }
        }
        spannableStringBuilder.append((CharSequence) msgItem.fieldText);
        return new QQText(SearchUtils.Y(spannableStringBuilder.toString(), 0, splitKeyword), 3, 15);
    }

    @Override // com.tencent.qqnt.search.api.ISearchConvertAPI
    @Nullable
    public String getPeerUid(@NotNull Object originObj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, originObj);
        }
        Intrinsics.checkNotNullParameter(originObj, "originObj");
        com.tencent.qqnt.search.convert.a findProcessConverter = findProcessConverter(originObj);
        if (findProcessConverter != null) {
            return findProcessConverter.e(originObj);
        }
        return null;
    }

    @Override // com.tencent.qqnt.search.api.ISearchConvertAPI
    public int getSearchMsgCount(@NotNull SearchChatSummaryItem searchMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) searchMsg)).intValue();
        }
        Intrinsics.checkNotNullParameter(searchMsg, "searchMsg");
        return searchMsg.msgCount;
    }

    @Override // com.tencent.qqnt.search.api.ISearchConvertAPI
    @Nullable
    public CharSequence getSubTitle(@NotNull Object originObj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CharSequence) iPatchRedirector.redirect((short) 5, (Object) this, originObj);
        }
        Intrinsics.checkNotNullParameter(originObj, "originObj");
        com.tencent.qqnt.search.convert.a findProcessConverter = findProcessConverter(originObj);
        if (findProcessConverter != null) {
            return findProcessConverter.f(originObj);
        }
        return null;
    }

    @Override // com.tencent.qqnt.search.api.ISearchConvertAPI
    @Nullable
    public CharSequence getTitle(@NotNull Object originObj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CharSequence) iPatchRedirector.redirect((short) 4, (Object) this, originObj);
        }
        Intrinsics.checkNotNullParameter(originObj, "originObj");
        com.tencent.qqnt.search.convert.a findProcessConverter = findProcessConverter(originObj);
        if (findProcessConverter != null) {
            return findProcessConverter.g(originObj);
        }
        return null;
    }

    @Override // com.tencent.qqnt.search.api.ISearchConvertAPI
    public boolean interestedIn(@NotNull Object originObj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, originObj)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(originObj, "originObj");
        return true;
    }
}

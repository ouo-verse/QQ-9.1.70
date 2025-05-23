package com.tencent.mobileqq.search.ftsmsg;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.en;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeMsgsItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001Ba\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\u001a\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010 j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`!\u0012\u0010\u0010%\u001a\f\u0012\u0006\b\u0001\u0012\u00020$\u0018\u00010#\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/search/ftsmsg/i;", "Lep2/d;", "", "k", "", "l", "", "u", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "view", "", "v", "H", "G", "T", "Ljava/lang/String;", "getSelfGroupName", "()Ljava/lang/String;", "selfGroupName", "U", "getPeerId", "peerId", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchAtMeMsgsItem;", "V", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchAtMeMsgsItem;", "getSearchAtMeMsgsItem", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchAtMeMsgsItem;", "searchAtMeMsgsItem", "originalKeyword", "segmentKeyword", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "splitKeywords", "", "Lcom/tencent/mobileqq/fts/v1/FTSEntity;", "entityList", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/SearchAtMeMsgsItem;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class i extends ep2.d {

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final String selfGroupName;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final String peerId;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final SearchAtMeMsgsItem searchAtMeMsgsItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@Nullable String str, @Nullable String str2, @Nullable ArrayList<String> arrayList, @Nullable List<? extends FTSEntity> list, @NotNull String selfGroupName, @NotNull String peerId, @NotNull SearchAtMeMsgsItem searchAtMeMsgsItem) {
        super(str, str2, arrayList, list);
        Intrinsics.checkNotNullParameter(selfGroupName, "selfGroupName");
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        Intrinsics.checkNotNullParameter(searchAtMeMsgsItem, "searchAtMeMsgsItem");
        this.selfGroupName = selfGroupName;
        this.peerId = peerId;
        this.searchAtMeMsgsItem = searchAtMeMsgsItem;
        C(6);
        D(searchAtMeMsgsItem.senderUid);
    }

    @Override // ep2.d
    @Nullable
    public CharSequence G() {
        return null;
    }

    @Override // ep2.d
    @Nullable
    public CharSequence H() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.t
    @NotNull
    /* renamed from: l */
    public String getUin() {
        return String.valueOf(this.searchAtMeMsgsItem.senderUin);
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: m */
    public CharSequence getDescription() {
        Long l3;
        CharSequence charSequence;
        MsgRecord msgRecord = this.searchAtMeMsgsItem.msgRecord;
        if (msgRecord != null) {
            l3 = Long.valueOf(msgRecord.msgTime);
        } else {
            l3 = null;
        }
        if (l3 != null) {
            charSequence = en.d(MobileQQ.sMobileQQ, 3, l3.longValue() * 1000);
            Intrinsics.checkNotNullExpressionValue(charSequence, "formatDateTime(MobileQQ.\u2026ERDAY_WEEKDAY, it * 1000)");
        } else {
            charSequence = "";
        }
        return charSequence;
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: t */
    public CharSequence getSubTitleSpans() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList<MsgElement> arrayList = this.searchAtMeMsgsItem.msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "searchAtMeMsgsItem.msgRecord.elements");
        for (MsgElement msgElement : arrayList) {
            int i3 = msgElement.elementType;
            if (i3 == 6) {
                IEmojiSpanService iEmojiSpanService = (IEmojiSpanService) QRoute.api(IEmojiSpanService.class);
                FaceElement faceElement = msgElement.faceElement;
                spannableStringBuilder.append(iEmojiSpanService.createEmojiSpanText(faceElement.faceType, faceElement.faceIndex, 0, false, 15)).toString();
            } else {
                boolean z16 = true;
                if (i3 == 1) {
                    String str = msgElement.textElement.content;
                    String account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
                    if (msgElement.textElement.atType == 2) {
                        if (this.selfGroupName.length() <= 0) {
                            z16 = false;
                        }
                        if (z16 && Intrinsics.areEqual(String.valueOf(msgElement.textElement.atUid), account)) {
                            str = "@" + this.selfGroupName;
                        }
                    }
                    spannableStringBuilder.append((CharSequence) str);
                }
            }
        }
        return new QQText(spannableStringBuilder, 3, 15);
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        boolean z16;
        String str = this.searchAtMeMsgsItem.senderRemark;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            String str2 = this.searchAtMeMsgsItem.senderNick;
            Intrinsics.checkNotNullExpressionValue(str2, "{\n            searchAtMe\u2026Item.senderNick\n        }");
            return str2;
        }
        String str3 = this.searchAtMeMsgsItem.senderRemark;
        Intrinsics.checkNotNullExpressionValue(str3, "{\n            searchAtMe\u2026em.senderRemark\n        }");
        return str3;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(@Nullable View view) {
        Long l3;
        long j3;
        MsgRecord msgRecord = this.searchAtMeMsgsItem.msgRecord;
        Long l16 = null;
        if (msgRecord != null) {
            l3 = Long.valueOf(msgRecord.msgSeq);
        } else {
            l3 = null;
        }
        MsgRecord msgRecord2 = this.searchAtMeMsgsItem.msgRecord;
        if (msgRecord2 != null) {
            l16 = Long.valueOf(msgRecord2.msgId);
        }
        CharSequence titleSpans = getTitleSpans();
        String str = this.peerId;
        Bundle bundle = new Bundle();
        long j16 = 0;
        if (l16 != null) {
            j3 = l16.longValue();
        } else {
            j3 = 0;
        }
        bundle.putLong("key_navigate_msgid", j3);
        if (l3 != null) {
            j16 = l3.longValue();
        }
        bundle.putLong("key_navigate_msgseq", j16);
        IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOStarterApi.class);
        Intrinsics.checkNotNull(view);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view!!.context");
        IAIOStarterApi.a.b(iAIOStarterApi, context, 2, str, titleSpans.toString(), 0L, bundle, 16, null);
    }
}

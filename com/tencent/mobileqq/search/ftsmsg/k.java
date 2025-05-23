package com.tencent.mobileqq.search.ftsmsg;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.en;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.SearchHitInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgItem;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BS\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u000103j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`4\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010!\u001a\u00020\u0002\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u00040\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u000fR\u0016\u0010%\u001a\u0004\u0018\u00010\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u0016R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u0016R\"\u00100\u001a\u00020\u00068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/search/ftsmsg/k;", "Lep2/c;", "", "k", "", "l", "", "u", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "view", "", "v", "", "I", "kotlin.jvm.PlatformType", ReportConstant.COSTREPORT_PREFIX, "", "r", "J", "N", "Ljava/lang/String;", "keyword", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;", "P", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;", "searchMsgItem", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "peerUid", BdhLogUtil.LogTag.Tag_Req, "aioTitle", ExifInterface.LATITUDE_SOUTH, "type", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "T", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "tempChatGameSession", "U", "uid", "V", "uin", "W", "Ljava/lang/CharSequence;", "K", "()Ljava/lang/CharSequence;", "L", "(Ljava/lang/CharSequence;)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, "Lcom/tencent/common/app/AppInterface;", "app", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "splitKeywords", "<init>", "(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/util/ArrayList;Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;Ljava/lang/String;Ljava/lang/String;I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class k extends ep2.c {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final String keyword;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final SearchMsgItem searchMsgItem;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final String peerUid;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final String aioTitle;

    /* renamed from: S, reason: from kotlin metadata */
    private final int type;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private final TempChatGameSession tempChatGameSession;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private String uid;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private String uin;

    /* renamed from: W, reason: from kotlin metadata */
    public CharSequence showTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull AppInterface app, @NotNull String keyword, @Nullable ArrayList<String> arrayList, @NotNull SearchMsgItem searchMsgItem, @NotNull String peerUid, @NotNull String aioTitle, int i3) {
        super(app, keyword, arrayList, null);
        HashMap<Integer, MsgAttributeInfo> hashMap;
        MsgAttributeInfo msgAttributeInfo;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(searchMsgItem, "searchMsgItem");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(aioTitle, "aioTitle");
        TempChatGameSession tempChatGameSession = null;
        this.keyword = keyword;
        this.searchMsgItem = searchMsgItem;
        this.peerUid = peerUid;
        this.aioTitle = aioTitle;
        this.type = i3;
        this.uid = "";
        this.uin = "";
        MsgRecord msgRecord = searchMsgItem.msgRecord;
        if (msgRecord != null && (hashMap = msgRecord.msgAttrs) != null && (msgAttributeInfo = hashMap.get(6)) != null) {
            tempChatGameSession = msgAttributeInfo.gameChatSession;
        }
        this.tempChatGameSession = tempChatGameSession;
        if (tempChatGameSession != null) {
            QRouteApi api = QRoute.api(IGameMsgNtApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IGameMsgNtApi::class.java)");
            IGameMsgNtApi iGameMsgNtApi = (IGameMsgNtApi) api;
            this.uid = iGameMsgNtApi.createUidFromTinyId(tempChatGameSession.selfTinyId, tempChatGameSession.peerTinyId);
            this.uin = iGameMsgNtApi.createConvertUinFromTinyId(tempChatGameSession.selfTinyId, tempChatGameSession.peerTinyId);
        }
    }

    @Override // ep2.c
    public /* bridge */ /* synthetic */ CharSequence H() {
        return (CharSequence) J();
    }

    @Nullable
    public Void I() {
        return null;
    }

    @Nullable
    public Void J() {
        return null;
    }

    @NotNull
    public final CharSequence K() {
        CharSequence charSequence = this.showTime;
        if (charSequence != null) {
            return charSequence;
        }
        Intrinsics.throwUninitializedPropertyAccessException(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME);
        return null;
    }

    public final void L(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
        this.showTime = charSequence;
    }

    @Override // ep2.c, com.tencent.mobileqq.search.model.t
    public int k() {
        return 119;
    }

    @Override // com.tencent.mobileqq.search.model.t
    @NotNull
    /* renamed from: l, reason: from getter */
    public String getUin() {
        return this.uin;
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: m */
    public CharSequence getDescription() {
        if (this.showTime == null) {
            CharSequence d16 = en.d(MobileQQ.sMobileQQ, 3, this.searchMsgItem.msgTime * 1000);
            Intrinsics.checkNotNullExpressionValue(d16, "formatDateTime(\n        \u2026time * 1000\n            )");
            L(d16);
        }
        return K();
    }

    @Override // ep2.c, com.tencent.mobileqq.search.model.y
    public /* bridge */ /* synthetic */ CharSequence o() {
        return (CharSequence) I();
    }

    @Override // ep2.c, com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // ep2.c, com.tencent.mobileqq.search.model.y
    /* renamed from: s */
    public String getKeyword() {
        return this.H;
    }

    @Override // ep2.c, com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: t */
    public CharSequence getSubTitle() {
        SpannableString spannableString = new SpannableString(this.searchMsgItem.fieldText);
        Iterator<SearchHitInfo> it = this.searchMsgItem.hitsInfo.iterator();
        while (it.hasNext()) {
            SearchHitInfo next = it.next();
            if (spannableString.length() < next.end) {
                break;
            }
            spannableString.setSpan(new ForegroundColorSpan(com.tencent.mobileqq.search.util.a.a()), next.start, next.end, 17);
        }
        return spannableString;
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: u */
    public CharSequence getTitle() {
        TempChatGameSession tempChatGameSession = this.tempChatGameSession;
        if (tempChatGameSession != null) {
            return ((IGameMsgAioNtApi) QRoute.api(IGameMsgAioNtApi.class)).getFriendNickName(tempChatGameSession);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(@Nullable View view) {
        Context context;
        TempChatGameSession tempChatGameSession;
        if (view != null) {
            context = view.getContext();
        } else {
            context = null;
        }
        if (context == null || (tempChatGameSession = this.tempChatGameSession) == null) {
            return;
        }
        ((IGameMsgAioNtApi) QRoute.api(IGameMsgAioNtApi.class)).enterGameMsgAio(context, tempChatGameSession, 6);
    }
}

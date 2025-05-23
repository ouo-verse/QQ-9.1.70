package com.tencent.mobileqq.search.ftsmsg;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqdataline.api.IQQDataLineApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgItem;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.qqnt.search.api.ISearchConvertAPI;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.api.IRobotAIORouteApi;
import com.tencent.robot.api.RobotAIORouteArgs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u0001:\u0001=B[\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00106\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u001a\u00109\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u000107j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`8\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\n\u00a2\u0006\u0004\b:\u0010;J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0016R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0014\u0010%\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u001aR\u0014\u0010'\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u0003R\u0017\u0010*\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010\u001cR\u0014\u0010,\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010\u001aR\"\u00103\u001a\u00020\r8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/search/ftsmsg/j;", "Lep2/c;", "", "I", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "K", "", "k", "l", "", "u", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "Landroid/view/View;", "view", "v", ReportConstant.COSTREPORT_PREFIX, "", "r", "H", "N", "Ljava/lang/String;", "getOriginalKeyword", "()Ljava/lang/String;", "originalKeyword", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;", "P", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;", "searchMsgItem", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "peerUid", BdhLogUtil.LogTag.Tag_Req, "aioTitle", ExifInterface.LATITUDE_SOUTH, "type", "T", "getUid", "uid", "U", "tempUin", "V", "Ljava/lang/CharSequence;", "J", "()Ljava/lang/CharSequence;", "L", "(Ljava/lang/CharSequence;)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, "Lcom/tencent/common/app/AppInterface;", "app", "keyword", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "splitKeywords", "<init>", "(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;Ljava/lang/String;Ljava/lang/String;I)V", "W", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class j extends ep2.c {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final String originalKeyword;

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
    @NotNull
    private final String uid;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final String tempUin;

    /* renamed from: V, reason: from kotlin metadata */
    public CharSequence showTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull AppInterface app, @NotNull String keyword, @NotNull String originalKeyword, @Nullable ArrayList<String> arrayList, @NotNull SearchMsgItem searchMsgItem, @NotNull String peerUid, @NotNull String aioTitle, int i3) {
        super(app, keyword, arrayList, null);
        String valueOf;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(originalKeyword, "originalKeyword");
        Intrinsics.checkNotNullParameter(searchMsgItem, "searchMsgItem");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(aioTitle, "aioTitle");
        this.originalKeyword = originalKeyword;
        this.searchMsgItem = searchMsgItem;
        this.peerUid = peerUid;
        this.aioTitle = aioTitle;
        this.type = i3;
        String str = searchMsgItem.senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "searchMsgItem.senderUid");
        this.uid = str;
        long j3 = searchMsgItem.senderUin;
        if (j3 == 0) {
            valueOf = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(str);
            Intrinsics.checkNotNullExpressionValue(valueOf, "{\n            QRoute.api\u2026UinFromUid(uid)\n        }");
        } else {
            valueOf = String.valueOf(j3);
        }
        this.tempUin = valueOf;
    }

    private final String I() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (this.type == 8) {
            return ((IQQDataLineApi) QRoute.api(IQQDataLineApi.class)).getDeviceNameFromUid(BaseApplication.context, this.peerUid);
        }
        MsgRecord msgRecord = this.searchMsgItem.msgRecord;
        String str = msgRecord.sendNickName;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.sendNickName");
        boolean z26 = true;
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return msgRecord.sendNickName;
        }
        String str2 = msgRecord.sendMemberName;
        Intrinsics.checkNotNullExpressionValue(str2, "msgRecord.sendMemberName");
        if (str2.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return msgRecord.sendMemberName;
        }
        String str3 = this.searchMsgItem.senderRemark;
        Intrinsics.checkNotNullExpressionValue(str3, "searchMsgItem.senderRemark");
        if (str3.length() > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            return this.searchMsgItem.senderRemark;
        }
        String str4 = this.searchMsgItem.senderNick;
        Intrinsics.checkNotNullExpressionValue(str4, "searchMsgItem.senderNick");
        if (str4.length() > 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            return this.searchMsgItem.senderNick;
        }
        String name = ac.R((QQAppInterface) G(), getTempUin(), 1000);
        Intrinsics.checkNotNullExpressionValue(name, "name");
        if (name.length() != 0) {
            z26 = false;
        }
        if (z26) {
            return ac.R((QQAppInterface) G(), getTempUin(), 0);
        }
        return name;
    }

    private final void K(Context context, Bundle bundle) {
        if (!(context instanceof Activity)) {
            return;
        }
        ((IRobotAIORouteApi) QRoute.api(IRobotAIORouteApi.class)).fetchAndRouteToRobotAIO(new RobotAIORouteArgs((Activity) context, String.valueOf(this.searchMsgItem.msgRecord.peerUin), null, null, null, false, bundle, null, null, 444, null));
    }

    @Override // ep2.c
    @Nullable
    public CharSequence H() {
        return null;
    }

    @NotNull
    public final CharSequence J() {
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
        if (this.type == 8) {
            String str = this.peerUid;
            if (Intrinsics.areEqual(str, PeerUid.DATALINE_PAD_UID)) {
                return 107;
            }
            if (Intrinsics.areEqual(str, PeerUid.DATALINE_PHONE_UID)) {
                return 120;
            }
            return 102;
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.t
    @NotNull
    /* renamed from: l, reason: from getter */
    public String getTempUin() {
        return this.tempUin;
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
        return J();
    }

    @Override // ep2.c, com.tencent.mobileqq.search.model.y
    @Nullable
    public CharSequence o() {
        return null;
    }

    @Override // ep2.c, com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // ep2.c, com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: s */
    public String getKeyword() {
        String keyword = this.H;
        Intrinsics.checkNotNullExpressionValue(keyword, "keyword");
        return keyword;
    }

    @Override // ep2.c, com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: t */
    public CharSequence getSubTitleSpans() {
        List<String> mutableList;
        SearchMsgItem searchMsgItem = this.searchMsgItem;
        ArrayList<String> mSplitKeywords = this.I;
        Intrinsics.checkNotNullExpressionValue(mSplitKeywords, "mSplitKeywords");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) mSplitKeywords);
        if (!mutableList.contains(this.originalKeyword)) {
            mutableList.add(this.originalKeyword);
        }
        if (!mutableList.contains(this.H)) {
            mutableList.add(this.H);
        }
        return ((ISearchConvertAPI) QRoute.api(ISearchConvertAPI.class)).getMsgHighLight(searchMsgItem, mutableList);
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        String I = I();
        if (I == null) {
            return "";
        }
        return I;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(@Nullable View view) {
        Context context;
        SearchMsgItem searchMsgItem = this.searchMsgItem;
        long j3 = searchMsgItem.msgSeq;
        long j16 = searchMsgItem.msgId;
        Bundle bundle = new Bundle();
        bundle.putLong("key_navigate_msgid", j16);
        bundle.putLong("key_navigate_msgseq", j3);
        IRobotServiceApi iRobotServiceApi = (IRobotServiceApi) QRoute.api(IRobotServiceApi.class);
        MsgRecord msgRecord = this.searchMsgItem.msgRecord;
        Intrinsics.checkNotNullExpressionValue(msgRecord, "searchMsgItem.msgRecord");
        if (iRobotServiceApi.isRobotAioMsg(msgRecord)) {
            if (view != null) {
                context = view.getContext();
            } else {
                context = null;
            }
            K(context, bundle);
            return;
        }
        IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOStarterApi.class);
        Intrinsics.checkNotNull(view);
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view!!.context");
        IAIOStarterApi.a.b(iAIOStarterApi, context2, this.type, this.peerUid, this.aioTitle, 0L, bundle, 16, null);
    }
}

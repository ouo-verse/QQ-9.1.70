package com.tencent.mobileqq.guild.share;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.data.ark.AttaIdReportData;
import com.tencent.mobileqq.guild.share.util.GuildActionSheetAttaUtil;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0007B\u001b\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0014R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/share/GuildShareForwardReceiver;", "Landroid/os/ResultReceiver;", "Landroid/os/Bundle;", "extra", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "a", "", QzoneIPCModule.RESULT_CODE, "resultData", "", "onReceiveResult", "Lcom/tencent/mobileqq/guild/data/ark/AttaIdReportData;", "d", "Lcom/tencent/mobileqq/guild/data/ark/AttaIdReportData;", "attaData", "Lcom/tencent/mobileqq/guild/share/s;", "e", "Lcom/tencent/mobileqq/guild/share/s;", "callBack", "<init>", "(Lcom/tencent/mobileqq/guild/data/ark/AttaIdReportData;Lcom/tencent/mobileqq/guild/share/s;)V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildShareForwardReceiver extends ResultReceiver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AttaIdReportData attaData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final s callBack;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildShareForwardReceiver(@NotNull AttaIdReportData attaData, @Nullable s sVar) {
        super(new Handler(Looper.getMainLooper()));
        Intrinsics.checkNotNullParameter(attaData, "attaData");
        this.attaData = attaData;
        this.callBack = sVar;
    }

    private final ArrayList<ResultRecord> a(Bundle extra) {
        boolean z16;
        boolean z17;
        ArrayList<ResultRecord> arrayListOf;
        ArrayList<ResultRecord> parcelableArrayList = extra.getParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET);
        if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return parcelableArrayList;
        }
        String string = extra.getString("uin");
        int i3 = extra.getInt("uintype");
        String string2 = extra.getString("uinname");
        if (string != null && string.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            ResultRecord resultRecord = new ResultRecord();
            resultRecord.uin = string;
            resultRecord.uinType = i3;
            resultRecord.name = string2;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(resultRecord);
            return arrayListOf;
        }
        return new ArrayList<>();
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
        boolean z16;
        ArrayList<ResultRecord> arrayList;
        super.onReceiveResult(resultCode, resultData);
        if (resultData != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("GuildShareForwardReceiver", 1, "onReceiveResult resultCode:" + resultCode + ", resultData " + z16);
        if (resultData != null) {
            arrayList = a(resultData);
        } else {
            arrayList = new ArrayList<>();
        }
        if (arrayList.isEmpty()) {
            return;
        }
        GuildActionSheetAttaUtil.n(arrayList, this.attaData);
        s sVar = this.callBack;
        if (sVar != null) {
            sVar.onResult(resultCode, arrayList);
        }
    }
}

package com.tencent.mobileqq.filemanager.fileviewer.api.impl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.api.IFileReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import ec1.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ0\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/filemanager/fileviewer/api/impl/FileReportApiImpl;", "Lcom/tencent/mobileqq/filemanager/fileviewer/api/IFileReportApi;", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "entity", "", "peerUin", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "reportFile", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FileReportApiImpl implements IFileReportApi {

    @NotNull
    private static final String TAG = "FileReportApiImpl";

    @Override // com.tencent.mobileqq.filemanager.fileviewer.api.IFileReportApi
    public void reportFile(@Nullable AppRuntime appRuntime, @Nullable FileManagerEntity entity, @Nullable String peerUin, @Nullable Activity activity) {
        String str;
        String str2;
        String str3;
        List split$default;
        if (appRuntime != null && entity != null) {
            String str4 = entity.selfUin;
            String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str4);
            IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            boolean isFriend = iFriendsInfoService.isFriend(uid, TAG);
            if (peerUin == null) {
                str = "";
            } else {
                str = peerUin;
            }
            if (entity.isZipInnerFile) {
                str2 = entity.zipFilePath;
            } else {
                str2 = entity.strTroopFilePath;
            }
            int i3 = entity.busId;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "reportFile. uin=" + str4 + ",isFriend=" + isFriend + ",groupId=" + str + ",fileId=" + str2 + ",busId=" + i3 + ", nOpType=" + entity.nOpType + ", fileIdCrc=" + entity.fileIdCrc);
            }
            if (entity.nOpType == 58) {
                String contentId = entity.fileIdCrc;
                if (!TextUtils.isEmpty(contentId)) {
                    String str5 = entity.fileIdCrc;
                    Intrinsics.checkNotNullExpressionValue(str5, "entity.fileIdCrc");
                    split$default = StringsKt__StringsKt.split$default((CharSequence) str5, new String[]{"|"}, false, 0, 6, (Object) null);
                    if (split$default != null && split$default.size() > 0 && ((String) split$default.get(0)).length() > 7) {
                        String substring = ((String) split$default.get(0)).substring(7);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        str3 = substring;
                        a aVar = a.f396078a;
                        Intrinsics.checkNotNullExpressionValue(contentId, "contentId");
                        aVar.b(appRuntime, "101162", str, str3, str2, i3, 7, contentId, activity);
                        return;
                    }
                }
                str3 = "";
                a aVar2 = a.f396078a;
                Intrinsics.checkNotNullExpressionValue(contentId, "contentId");
                aVar2.b(appRuntime, "101162", str, str3, str2, i3, 7, contentId, activity);
                return;
            }
            a.f396078a.a(appRuntime, "100535", str, str4, str2, i3);
        }
    }
}

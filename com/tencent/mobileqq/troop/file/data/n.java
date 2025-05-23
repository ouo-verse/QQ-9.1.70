package com.tencent.mobileqq.troop.file.data;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQToastUtil;
import cooperation.qqfav.QfavBuilder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/troop/file/data/n;", "Lcom/tencent/mobileqq/richmedia/depend/f;", "Landroid/view/View;", "itemView", "", "mediaId", "", "g3", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "R1", "x7", "Landroid/content/Intent;", ICustomDataEditor.STRING_PARAM_3, "", "d", "J", "troopUin", "Lcom/tencent/mobileqq/troop/data/t;", "e", "Lcom/tencent/mobileqq/troop/data/t;", "fileInfo", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "f", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "entity", "<init>", "(JLcom/tencent/mobileqq/troop/data/t;Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V", tl.h.F, "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class n implements com.tencent.mobileqq.richmedia.depend.f {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final t fileInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final FileManagerEntity entity;

    public n(long j3, t fileInfo, FileManagerEntity entity) {
        Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.troopUin = j3;
        this.fileInfo = fileInfo;
        this.entity = entity;
    }

    @Override // com.tencent.mobileqq.richmedia.depend.f
    public void R1(Activity activity, String mediaId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        QLog.i("TroopFile.TroopFileMediaShareDepend", 1, "print, " + mediaId + ", " + this.fileInfo.f294987u + ", ignore");
    }

    @Override // com.tencent.mobileqq.richmedia.depend.f
    public void g3(View itemView, String mediaId) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        QLog.i("TroopFile.TroopFileMediaShareDepend", 1, "addFavorite, " + mediaId + ", " + this.fileInfo.f294987u);
        if (QfavBuilder.Y().v(TroopUtils.f(), itemView.getContext(), this.entity, null, false, "", false, false)) {
            QQToastUtil.showQQToastInUiThread(2, itemView.getContext().getString(R.string.b3n));
        }
    }

    @Override // com.tencent.mobileqq.richmedia.depend.f
    public Intent s3(String mediaId) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        QLog.i("TroopFile.TroopFileMediaShareDepend", 1, "getForwardIntent, " + mediaId + ", " + this.fileInfo.f294987u);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFileUtils.I(this.troopUin, this.fileInfo));
        ArrayList arrayList = new ArrayList();
        if (FileUtils.fileExistsAndNotEmpty(this.fileInfo.f294978l)) {
            arrayList.add(Uri.parse(this.fileInfo.f294978l));
        } else {
            arrayList.add(Uri.parse(""));
        }
        Intent K = QFileUtils.K(arrayListOf, arrayList, this.fileInfo.f294976j);
        Intrinsics.checkNotNullExpressionValue(K, "getForwardIntent(forward\u2026, fileInfo.ProgressTotal)");
        return K;
    }

    @Override // com.tencent.mobileqq.richmedia.depend.f
    public void x7(String mediaId) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        QLog.i("TroopFile.TroopFileMediaShareDepend", 1, "saveToWeiYun, " + mediaId + ", " + this.fileInfo.f294987u);
        TroopFileTransferManager O = TroopFileTransferManager.O(TroopUtils.f(), this.troopUin);
        if (O != null) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.fileInfo);
            O.z0(arrayListOf);
        }
    }
}

package com.tencent.mobileqq.zplan.room.impl.meeting;

import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import cooperation.qzone.QzoneIPCModule;
import gk3.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import vb3.a;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u001a\u0010\u0011\u001a\u00020\u00078\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingScreenCapturePermissionFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "doResume", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", BdhLogUtil.LogTag.Tag_Conn, "I", "getSTART_RECORD_REQUEST_CODE", "()I", "START_RECORD_REQUEST_CODE", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class QQMeetingScreenCapturePermissionFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private final int START_RECORD_REQUEST_CODE = 1002;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void doResume() {
        super.doResume();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.START_RECORD_REQUEST_CODE) {
            ((b) a.f441346a.a(b.class)).R0(resultCode == -1, data);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Object systemService = MobileQQ.sMobileQQ.getApplicationContext().getSystemService("media_projection");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.projection.MediaProjectionManager");
        startActivityForResult(((MediaProjectionManager) systemService).createScreenCaptureIntent(), this.START_RECORD_REQUEST_CODE);
    }
}

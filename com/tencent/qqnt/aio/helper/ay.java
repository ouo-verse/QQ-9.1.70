package com.tencent.qqnt.aio.helper;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ay;", "Lcom/tencent/aio/main/businesshelper/h;", "", "b", "c", "g", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Landroid/content/Context;", "e", "Landroid/content/Context;", "mContext", "", "f", "Ljava/util/List;", "mLatestMsgIdList", "", tl.h.F, "Z", "mIsShowReport", "<init>", "()V", "i", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ay implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<String> mLatestMsgIdList = new ArrayList();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsShowReport;

    private final void c() {
        AIOParam g16;
        Bundle l3;
        if (this.mIsShowReport) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar != null && (g16 = aVar.g()) != null && (l3 = g16.l()) != null) {
            final long j3 = l3.getLong("key_peerUin");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.ax
                @Override // java.lang.Runnable
                public final void run() {
                    ay.e(j3);
                }
            }, 32, null, false);
        }
        this.mIsShowReport = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(long j3) {
        com.tencent.gamecenter.common.util.l.o(String.valueOf(j3), "96902", "209042", null);
    }

    private final void g() {
        AIOParam g16;
        Bundle l3;
        QLog.d("GameCenterHelper", 1, "reportNotificationClick");
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (g16 = aVar.g()) == null || (l3 = g16.l()) == null || !l3.getBoolean(AppConstants.Key.KEY_NOTIFICATION_CLICK_ACTION)) {
            return;
        }
        long j3 = l3.getLong(AppConstants.Key.KEY_NOTIFICATION_MSG_ID);
        if (this.mLatestMsgIdList.contains(String.valueOf(j3))) {
            QLog.d("GameCenterHelper", 1, "reportNotificationClick, reported, abort");
            return;
        }
        com.tencent.gamecenter.common.util.l.p(false, new Contact(l3.getInt("key_chat_type"), l3.getString("key_peerId"), ""), String.valueOf(l3.getLong("key_peerUin")), j3);
        if (this.mLatestMsgIdList.size() > 100) {
            this.mLatestMsgIdList.clear();
        }
        this.mLatestMsgIdList.add(String.valueOf(j3));
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350667r;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "GameCenterHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Fragment c16;
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        Context requireContext = (a16 == null || (c16 = a16.c()) == null) ? null : c16.requireContext();
        Intrinsics.checkNotNull(requireContext);
        this.mContext = requireContext;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    private final void b() {
        QLog.d("GameCenterHelper", 1, "onResume");
        c();
        g();
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{3};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 3) {
            b();
        }
    }
}

package com.tencent.mobileqq.zootopia.download.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.download.ui.ZootopiaBaseDownloadFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import pb3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ui/ZootopiaBaseDownloadFragment;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "", "id", "", "ph", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "Lpb3/a;", BdhLogUtil.LogTag.Tag_Conn, "Lpb3/a;", "getManagerListener", "()Lpb3/a;", "managerListener", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class ZootopiaBaseDownloadFragment extends QBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private final pb3.a managerListener = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/download/ui/ZootopiaBaseDownloadFragment$a", "Lpb3/a;", "", "id", "", "onTaskDelete", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements pb3.a {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ZootopiaBaseDownloadFragment this$0, String id5) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(id5, "$id");
            this$0.ph(id5);
        }

        @Override // pb3.a
        public void onDownloadCountChanged(int i3) {
            a.C10996a.a(this, i3);
        }

        @Override // pb3.a
        public void onDownloadingCountChanged(int i3) {
            a.C10996a.b(this, i3);
        }

        @Override // pb3.a
        public void onTaskDelete(final String id5) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ZootopiaBaseDownloadFragment zootopiaBaseDownloadFragment = ZootopiaBaseDownloadFragment.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.ui.c
                @Override // java.lang.Runnable
                public final void run() {
                    ZootopiaBaseDownloadFragment.a.b(ZootopiaBaseDownloadFragment.this, id5);
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ZootopiaDownloadManager.f327992a.E0(this.managerListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ZootopiaDownloadManager.f327992a.H(this.managerListener);
    }

    public void ph(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
    }
}

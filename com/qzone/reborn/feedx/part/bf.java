package com.qzone.reborn.feedx.part;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\b\u001a\u00020\u0004R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/qzone/reborn/feedx/part/bf;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "getLogTag", "D9", "", "d", "Ljava/util/List;", "reportExpNameFeedListAndDetail", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class bf extends com.qzone.reborn.base.k {

    /* renamed from: f, reason: collision with root package name */
    private static boolean f55043f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<String> reportExpNameFeedListAndDetail;

    public bf() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("exp_xsj_synchro_video_autoplay_exp");
        this.reportExpNameFeedListAndDetail = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(bf this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.getTAG(), 1, "[reportTABExpExportWhenLoginFeedListAndDetail]");
        for (String str : this$0.reportExpNameFeedListAndDetail) {
            if (str.length() > 0) {
                com.qzone.reborn.a.f52169a.h(str);
            }
        }
    }

    public final void D9() {
        if (f55043f) {
            return;
        }
        f55043f = true;
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.part.be
            @Override // java.lang.Runnable
            public final void run() {
                bf.E9(bf.this);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxTABLoginReportPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        D9();
    }
}

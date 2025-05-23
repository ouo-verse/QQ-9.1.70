package com.tencent.mobileqq.zootopia.download.ui;

import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.os.MqqHandler;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaResData;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZootopiaDownloadManagerFragment$queryDataToPage$1 extends Lambda implements Function1<List<? extends ZootopiaResData>, Unit> {
    final /* synthetic */ ZootopiaDownloadManagerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDownloadManagerFragment$queryDataToPage$1(ZootopiaDownloadManagerFragment zootopiaDownloadManagerFragment) {
        super(1);
        this.this$0 = zootopiaDownloadManagerFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(List it, ZootopiaDownloadManagerFragment this$0) {
        Object obj;
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!it.isEmpty()) {
            Iterator it5 = it.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it5.next();
                    if (((ZootopiaResData) obj).getDownloadStatus() != 5) {
                        break;
                    }
                }
            }
            if (obj == null) {
                this$0.toDownloadedPage();
                return;
            }
        }
        fi3.p pVar = this$0.binding;
        if (pVar != null) {
            TextView textView = pVar.f399319e;
            Intrinsics.checkNotNullExpressionValue(textView, "it.downloading");
            this$0.onSelected(textView);
            TextView textView2 = pVar.f399318d;
            Intrinsics.checkNotNullExpressionValue(textView2, "it.downloaded");
            this$0.onUnSelected(textView2);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ZootopiaResData> list) {
        invoke2((List<ZootopiaResData>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final List<ZootopiaResData> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        MqqHandler uIHandler = ThreadManager.getUIHandler();
        final ZootopiaDownloadManagerFragment zootopiaDownloadManagerFragment = this.this$0;
        uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.ui.m
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaDownloadManagerFragment$queryDataToPage$1.b(it, zootopiaDownloadManagerFragment);
            }
        });
    }
}

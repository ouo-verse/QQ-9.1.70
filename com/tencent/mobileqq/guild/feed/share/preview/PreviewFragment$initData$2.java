package com.tencent.mobileqq.guild.feed.share.preview;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.contentshare.d;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/d;", "info", "", "invoke", "(Lcom/tencent/mobileqq/guild/contentshare/d;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class PreviewFragment$initData$2 extends Lambda implements Function1<d, Unit> {
    final /* synthetic */ PreviewFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewFragment$initData$2(PreviewFragment previewFragment) {
        super(1);
        this.this$0 = previewFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PreviewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.initView();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(d dVar) {
        invoke2(dVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable d dVar) {
        if (dVar == null) {
            QLog.i(QPublicBaseFragment.TAG, 1, "Failed to create share info.");
            return;
        }
        this.this$0.qh(dVar);
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final PreviewFragment previewFragment = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.share.preview.b
            @Override // java.lang.Runnable
            public final void run() {
                PreviewFragment$initData$2.b(PreviewFragment.this);
            }
        });
    }
}

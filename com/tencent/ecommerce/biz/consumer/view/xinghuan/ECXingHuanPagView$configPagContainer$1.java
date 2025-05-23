package com.tencent.ecommerce.biz.consumer.view.xinghuan;

import cg0.a;
import com.tencent.ecommerce.biz.hr.ktx.HRResourceExtKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.libpag.PAGView;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isLoadSuccess", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECXingHuanPagView$configPagContainer$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ String $pagUrl;
    final /* synthetic */ ECXingHuanPagView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECXingHuanPagView$configPagContainer$1(ECXingHuanPagView eCXingHuanPagView, String str) {
        super(1);
        this.this$0 = eCXingHuanPagView;
        this.$pagUrl = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        r4 = r3.this$0.pagView;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke(boolean z16) {
        PAGView pAGView;
        PAGView pAGView2;
        if (z16) {
            pAGView = this.this$0.pagView;
            if (pAGView != null && pAGView.isPlaying() && pAGView2 != null) {
                pAGView2.stop();
            }
            HRResourceExtKt.a(this.this$0.getContext(), this.$pagUrl, ".pag", new Function1<File, Unit>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanPagView$configPagContainer$1.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(File file) {
                    invoke2(file);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final File file) {
                    if (file == null) {
                        a.a("ECXingHuanPagView", "configPagContainer", "download pag file error, pagUrl: " + ECXingHuanPagView$configPagContainer$1.this.$pagUrl);
                        return;
                    }
                    ECXingHuanPagView$configPagContainer$1.this.this$0.post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanPagView.configPagContainer.1.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ECXingHuanPagView$configPagContainer$1.this.this$0.l();
                            ECXingHuanPagView$configPagContainer$1.this.this$0.f();
                            ECXingHuanPagView$configPagContainer$1.this.this$0.h(file.getAbsolutePath());
                        }
                    });
                }
            });
            return;
        }
        a.a("ECXingHuanPagView", "configPagContainer", "pag so load failure");
    }
}

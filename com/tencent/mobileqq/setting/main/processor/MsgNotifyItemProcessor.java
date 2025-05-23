package com.tencent.mobileqq.setting.main.processor;

import android.content.Context;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u001c\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R'\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/setting/main/processor/MsgNotifyItemProcessor;", "Lcom/tencent/mobileqq/setting/processor/c;", "", "E", "", "D", "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onCreate", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "o", "", "g", "Lkotlin/Lazy;", "B", "()Ljava/lang/String;", "leftText", tl.h.F, "Z", "firstExposure", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c$d;", "i", BdhLogUtil.LogTag.Tag_Conn, "()Lcom/tencent/mobileqq/widget/listitem/x;", "singleLineConfig", "com/tencent/mobileqq/setting/main/processor/MsgNotifyItemProcessor$a", "j", "Lcom/tencent/mobileqq/setting/main/processor/MsgNotifyItemProcessor$a;", "configObserver", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MsgNotifyItemProcessor extends com.tencent.mobileqq.setting.processor.c {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy leftText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean firstExposure;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy singleLineConfig;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final a configObserver;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/setting/main/processor/MsgNotifyItemProcessor$a", "Lcom/tencent/mobileqq/app/h;", "", ViewStickEventHelper.IS_SHOW, "", "i", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends com.tencent.mobileqq.app.h {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.h
        public void i(boolean isShow) {
            super.i(isShow);
            MsgNotifyItemProcessor.this.E();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgNotifyItemProcessor(final Context context) {
        super(context, 5);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.setting.main.processor.MsgNotifyItemProcessor$leftText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return context.getString(R.string.fsa);
            }
        });
        this.leftText = lazy;
        this.firstExposure = true;
        lazy2 = LazyKt__LazyJVMKt.lazy(new MsgNotifyItemProcessor$singleLineConfig$2(this));
        this.singleLineConfig = lazy2;
        this.configObserver = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String B() {
        return (String) this.leftText.getValue();
    }

    private final x<x.b.C8996b, x.c.d> C() {
        return (x) this.singleLineConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean D() {
        return ((IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class)).isShowWechatGuildSettingItemRedDot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.setting.main.processor.j
            @Override // java.lang.Runnable
            public final void run() {
                MsgNotifyItemProcessor.F(MsgNotifyItemProcessor.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(MsgNotifyItemProcessor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C().O().g(this$0.D());
        this$0.l();
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public void o() {
        super.o();
        AppInterface f16 = f();
        if (f16 != null) {
            f16.addObserver(this.configObserver);
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onCreate() {
        super.onCreate();
        AppInterface f16 = f();
        if (f16 != null) {
            f16.addObserver(this.configObserver);
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onDestroy() {
        super.onDestroy();
        AppInterface f16 = f();
        if (f16 != null) {
            f16.removeObserver(this.configObserver);
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onResume() {
        super.onResume();
        E();
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        return C();
    }
}

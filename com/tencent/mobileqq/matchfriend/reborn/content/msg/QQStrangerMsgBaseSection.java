package com.tencent.mobileqq.matchfriend.reborn.content.msg;

import android.os.Handler;
import android.os.Looper;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\b\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\u0004H\u0016R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/QQStrangerMsgBaseSection;", "T", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lkotlin/Function0;", "", "block", "", "delay", "r", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/os/Handler;", "d", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/os/Handler;", "uiHandler", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class QQStrangerMsgBaseSection<T> extends Section<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy uiHandler;

    public QQStrangerMsgBaseSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.QQStrangerMsgBaseSection$uiHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.uiHandler = lazy;
    }

    private final Handler q() {
        return (Handler) this.uiHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        q().removeCallbacksAndMessages(null);
    }

    public final void r(final Function0<Unit> block, long delay) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (delay == 0 && Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            block.invoke();
        } else {
            q().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.a
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerMsgBaseSection.s(Function0.this);
                }
            }, delay);
        }
    }
}

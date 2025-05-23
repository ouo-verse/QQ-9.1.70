package com.tencent.mobileqq.zplan.emoticon.panel.repository;

import com.tencent.mobileqq.zplan.manager.ZPlanThreadManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "code", "", "bgPath", "", "fgPath", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanEmoticon2DFactory$getEmoRes$2 extends Lambda implements Function3<Integer, String, String, Unit> {
    final /* synthetic */ String $url;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticon2DFactory$getEmoRes$2(String str) {
        super(3);
        this.$url = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String str, int i3, String str2, String str3) {
        ZPlanEmoticon2DFactory zPlanEmoticon2DFactory = ZPlanEmoticon2DFactory.f333159b;
        Intrinsics.checkNotNull(str);
        zPlanEmoticon2DFactory.l(str, i3, str2, str3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, String str2) {
        invoke(num.intValue(), str, str2);
        return Unit.INSTANCE;
    }

    public final void invoke(final int i3, final String str, final String str2) {
        ZPlanThreadManager zPlanThreadManager = ZPlanThreadManager.f333874a;
        final String str3 = this.$url;
        zPlanThreadManager.b(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.repository.d
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanEmoticon2DFactory$getEmoRes$2.c(str3, i3, str, str2);
            }
        });
    }
}

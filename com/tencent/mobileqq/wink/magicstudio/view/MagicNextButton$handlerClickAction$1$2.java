package com.tencent.mobileqq.wink.magicstudio.view;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "shareType", "", "isSuccess", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class MagicNextButton$handlerClickAction$1$2 extends Lambda implements Function2<String, Boolean, Unit> {
    final /* synthetic */ MagicNextButton this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicNextButton$handlerClickAction$1$2(MagicNextButton magicNextButton) {
        super(2);
        this.this$0 = magicNextButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MagicNextButton this$0, String shareType, boolean z16) {
        String str;
        Function0<Unit> h16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shareType, "$shareType");
        str = this$0.TAG;
        w53.b.a(str, "doMagicStudioActionShare shareType: " + shareType + ", success:" + z16);
        this$0.shareIsShowing = false;
        switch (shareType.hashCode()) {
            case -791575966:
                if (!shareType.equals("weixin")) {
                    return;
                }
                break;
            case -393543490:
                if (!shareType.equals("qqfriend")) {
                    return;
                }
                break;
            case -304161157:
                if (!shareType.equals("qzoneshuoshuo")) {
                    return;
                }
                break;
            case 154627506:
                if (!shareType.equals("weixincircle")) {
                    return;
                }
                break;
            case 2024098531:
                if (!shareType.equals("qqchannel")) {
                    return;
                }
                break;
            default:
                return;
        }
        if (z16 && (h16 = this$0.h()) != null) {
            h16.invoke();
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Boolean bool) {
        invoke(str, bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull final String shareType, final boolean z16) {
        Intrinsics.checkNotNullParameter(shareType, "shareType");
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final MagicNextButton magicNextButton = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.view.j
            @Override // java.lang.Runnable
            public final void run() {
                MagicNextButton$handlerClickAction$1$2.b(MagicNextButton.this, shareType, z16);
            }
        });
    }
}

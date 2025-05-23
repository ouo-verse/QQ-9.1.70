package com.tencent.mobileqq.guild.setting.guildsetting.fragment;

import com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildSettingQRCodeFragment$initViewModel$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ GuildSettingQRCodeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSettingQRCodeFragment$initViewModel$2(GuildSettingQRCodeFragment guildSettingQRCodeFragment) {
        super(1);
        this.this$0 = guildSettingQRCodeFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(int i3) {
        QLog.d("GuildSettingQRCodeFragment", 1, "mIvQRCode.refreshContent: code:" + i3);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String url) {
        QUIColorfulQRCodeView qUIColorfulQRCodeView;
        qUIColorfulQRCodeView = this.this$0.guildQrCode;
        yz1.p pVar = null;
        if (qUIColorfulQRCodeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildQrCode");
            qUIColorfulQRCodeView = null;
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        qUIColorfulQRCodeView.f(url, new com.tencent.mobileqq.component.qrcode.g() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.v
            @Override // com.tencent.mobileqq.component.qrcode.g
            public final void onResult(int i3) {
                GuildSettingQRCodeFragment$initViewModel$2.c(i3);
            }
        });
        yz1.p pVar2 = this.this$0.shareHelper;
        if (pVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareHelper");
        } else {
            pVar = pVar2;
        }
        pVar.w(url);
    }
}

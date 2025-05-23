package com.tencent.mobileqq.guild.setting.guildsetting.part;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public /* synthetic */ class GuildSettingItemPart$showGuildFolderGuideDialog$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildSettingItemPart$showGuildFolderGuideDialog$1(Object obj) {
        super(0, obj, GuildSettingItemPart.class, "onDismissListener", "onDismissListener()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((GuildSettingItemPart) this.receiver).sa();
    }
}

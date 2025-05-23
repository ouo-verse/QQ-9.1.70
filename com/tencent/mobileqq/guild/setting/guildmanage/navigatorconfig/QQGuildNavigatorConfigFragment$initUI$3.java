package com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig;

import com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.viewmodel.QQGuildNavigatorConfigViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
/* synthetic */ class QQGuildNavigatorConfigFragment$initUI$3 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public QQGuildNavigatorConfigFragment$initUI$3(Object obj) {
        super(0, obj, QQGuildNavigatorConfigViewModel.class, "updateNavigatorExpand", "updateNavigatorExpand()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((QQGuildNavigatorConfigViewModel) this.receiver).x2();
    }
}

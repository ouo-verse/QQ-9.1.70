package com.tencent.mobileqq.guild.home.parts;

import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildHomeHeaderNavigationBar;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
/* synthetic */ class GuildHomeHeaderPart$onInitView$6 extends FunctionReferenceImpl implements Function0<Pair<? extends Integer, ? extends GuildHomeHeaderNavigationBar>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildHomeHeaderPart$onInitView$6(Object obj) {
        super(0, obj, hp1.a.class, "getNavigationBar", "getNavigationBar()Lkotlin/Pair;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final Pair<? extends Integer, ? extends GuildHomeHeaderNavigationBar> invoke() {
        return ((hp1.a) this.receiver).k0();
    }
}

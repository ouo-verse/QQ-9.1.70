package com.tencent.timi.game.jump.api.impl;

import android.net.Uri;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.timi.game.jump.api.IQQLiveJumpParserApi;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R0\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/timi/game/jump/api/impl/QQLiveJumpParserApiImpl;", "Lcom/tencent/timi/game/jump/api/IQQLiveJumpParserApi;", "", "url", "Lcom/tencent/mobileqq/app/parser/av;", "getJumpParser", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "parsers", "Ljava/util/HashMap;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveJumpParserApiImpl implements IQQLiveJumpParserApi {

    @NotNull
    private final HashMap<String, av> parsers = new HashMap<>();

    @Override // com.tencent.timi.game.jump.api.IQQLiveJumpParserApi
    @Nullable
    public av getJumpParser(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return this.parsers.get(Uri.parse(url).getPath());
    }
}

package com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/EditorInstanceStateTranslator;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/e;", "Lorg/json/JSONObject;", "publishJson", "Lnm1/b;", "translateInfo", "", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class EditorInstanceStateTranslator implements e {
    @Override // com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e
    public void a(@NotNull JSONObject publishJson, @NotNull nm1.b translateInfo) {
        Intrinsics.checkNotNullParameter(publishJson, "publishJson");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        publishJson.putOpt("media_lock_count", Integer.valueOf(translateInfo.getUnmodifiableMediaSize()));
        EditorInstanceStateTranslator$translate$1 editorInstanceStateTranslator$translate$1 = EditorInstanceStateTranslator$translate$1.INSTANCE;
    }
}

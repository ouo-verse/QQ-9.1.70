package com.tencent.mobileqq.guild.feed.feedsquare.section;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.config.GuildFeedTextLineNumberConfigParser;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
/* synthetic */ class GuildFeedSquareFeedDescComponents$Companion$MAX_LINES$2 extends FunctionReferenceImpl implements Function0<GuildFeedTextLineNumberConfigParser.Data> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildFeedSquareFeedDescComponents$Companion$MAX_LINES$2(Object obj) {
        super(0, obj, MutableLiveData.class, HippyTextInputController.COMMAND_getValue, "getValue()Ljava/lang/Object;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final GuildFeedTextLineNumberConfigParser.Data invoke() {
        return (GuildFeedTextLineNumberConfigParser.Data) ((MutableLiveData) this.receiver).getValue();
    }
}

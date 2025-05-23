package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser;

import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002JV\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/b;", "T", "", "", "contents", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "parseConfig", "", "channelId", "guildId", "Lkotlin/Pair;", "Landroid/text/SpannableStringBuilder;", "Lcom/tencent/aio/widget/textView/view/b;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface b<T> {
    @NotNull
    Pair<SpannableStringBuilder, com.tencent.aio.widget.textView.view.b> a(@NotNull List<? extends T> contents, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam, @NotNull IParseRichTextConfig<T> parseConfig, @Nullable String channelId, @Nullable String guildId);
}

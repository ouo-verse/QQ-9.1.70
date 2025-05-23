package com.tencent.guild.aio.component.combinestyle;

import android.text.SpannableStringBuilder;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J:\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/ac;", "Lcom/tencent/guild/aio/component/combinestyle/z;", "Landroid/widget/ImageView;", "imageView", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Landroid/text/SpannableStringBuilder;", "spannedString", "Landroid/widget/TextView;", "textView", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "combineStyleAioItem", "", WadlProxyConsts.FLAGS, "", "b", "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface ac extends z {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ void a(ac acVar, ImageView imageView, GuildMsgItem guildMsgItem, SpannableStringBuilder spannableStringBuilder, TextView textView, aa aaVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 32) != 0) {
                    i3 = 17;
                }
                acVar.b(imageView, guildMsgItem, spannableStringBuilder, textView, aaVar, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: connectComponent");
        }
    }

    void b(@NotNull ImageView imageView, @NotNull GuildMsgItem msgItem, @NotNull SpannableStringBuilder spannedString, @NotNull TextView textView, @NotNull aa combineStyleAioItem, int flags);
}

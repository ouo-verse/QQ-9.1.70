package jv1;

import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.channel.node.ChannelNodeExtKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"Ljv1/c;", "Lcom/tencent/qqnt/chats/inject/summary/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "view", "", "b", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "c", "Landroid/view/View;", "a", "<init>", "()V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c extends com.tencent.qqnt.chats.inject.summary.a {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static Boolean f411003b;

    private final void b(g.e item, SingleLineTextView view) {
        boolean z16;
        int i3;
        boolean endsWith$default;
        String e16 = item.e();
        if (e16.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (f411003b == null) {
                f411003b = Boolean.valueOf(((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("is_recent_highlight_opt_enabled", false));
            }
            if (Intrinsics.areEqual(f411003b, Boolean.TRUE)) {
                i3 = R.color.qui_common_feedback_error;
            } else {
                i3 = R.color.ag5;
            }
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(e16, " ", false, 2, null);
            if (!endsWith$default) {
                e16 = e16 + " ";
            }
            view.setExtendTextColor(ColorStateList.valueOf(view.getContext().getResources().getColor(i3)), 1);
        }
        view.setExtendText(e16, 1);
    }

    private final void c(g item, SingleLineTextView view) {
        int i3;
        g.e v3 = item.v();
        if (!TextUtils.isEmpty(v3.e())) {
            view.setCompoundDrawablesWithIntrinsicBounds(0, 0);
            return;
        }
        int h16 = v3.h();
        if (h16 != 1) {
            if (h16 != 4) {
                if (h16 != 6) {
                    if (h16 != 9) {
                        if (h16 != 17) {
                            if (h16 != 18) {
                                i3 = 0;
                            }
                        } else {
                            i3 = R.drawable.guild_recent_msg_list_audio_music_icon;
                        }
                    }
                    i3 = R.drawable.guild_recent_msg_list_audio_game_icon;
                } else {
                    i3 = R.drawable.guild_recent_msg_list_audio_live_icon;
                }
            } else {
                i3 = R.drawable.guild_recent_msg_list_audio_chat_icon;
            }
        } else {
            i3 = R.drawable.guild_recent_msg_list_live_ing_icon;
        }
        view.setCompoundDrawablesWithIntrinsicBounds(i3, 0);
    }

    @Override // com.tencent.qqnt.chats.inject.summary.a
    public void a(@NotNull g item, @NotNull View view) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if ((!ChannelNodeExtKt.isAudioChannel(item) && !ChannelNodeExtKt.isLiveChannel(item)) || !(view instanceof SingleLineTextView)) {
            return;
        }
        g.e v3 = item.v();
        SingleLineTextView singleLineTextView = (SingleLineTextView) view;
        c(item, singleLineTextView);
        b(v3, singleLineTextView);
    }
}

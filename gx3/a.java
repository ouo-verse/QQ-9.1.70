package gx3;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lgx3/a;", "Lcom/tencent/qqnt/chats/inject/title/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "view", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a extends com.tencent.qqnt.chats.inject.title.a {
    @Override // com.tencent.qqnt.chats.inject.title.a
    public void a(@NotNull g item, @NotNull SingleLineTextView view) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if (item.n() == 106 && !TextUtils.isEmpty(item.w().b())) {
            view.setExtendText("", 2);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            int color = view.getResources().getColor(R.color.qui_common_bg_bottom_standard);
            int color2 = view.getResources().getColor(R.color.qui_common_text_secondary);
            String b16 = item.w().b();
            Intrinsics.checkNotNull(b16);
            b bVar = new b(context, color, 20, 5, 0, 12, color2, b16);
            SpannableString spannableString = new SpannableString(item.w().e() + "  ");
            spannableString.setSpan(bVar, item.w().e().length() + 1, item.w().e().length() + 2, 33);
            view.setText(spannableString);
        }
    }
}

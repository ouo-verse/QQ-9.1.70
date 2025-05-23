package com.tencent.mobileqq.search.searchdetail.content.template;

import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.aio.utils.ViewUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000\u00a8\u0006\u0006"}, d2 = {"", "buttonStatus", "Landroid/widget/TextView;", "tvRightButton", "", "a", "qqsearch-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class f {
    public static final void a(int i3, @Nullable TextView textView) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    if (textView != null) {
                        textView.setBackground(null);
                    }
                    if (textView != null) {
                        textView.setTextColor(textView.getContext().getColor(R.color.qui_common_text_secondary_light));
                        return;
                    }
                    return;
                }
                return;
            }
            if (textView != null) {
                textView.setBackground(rn2.j.f431768a.f(r2.a(4.0f), r2.a(4.0f), r2.a(4.0f), r2.a(4.0f), ViewUtils.f352270a.a(1.0f), textView.getContext().getColor(R.color.qui_button_border_secondary_disable), textView.getContext().getColor(R.color.qui_button_bg_secondary_disable)));
                textView.setTextColor(textView.getContext().getColor(R.color.qui_button_text_secondary_disable));
                return;
            }
            return;
        }
        if (textView != null) {
            textView.setBackground(rn2.j.f431768a.f(r2.a(4.0f), r2.a(4.0f), r2.a(4.0f), r2.a(4.0f), ViewUtils.f352270a.a(1.0f), textView.getContext().getColor(R.color.qui_button_border_secondary_default), textView.getContext().getColor(R.color.qui_button_bg_secondary_default)));
            textView.setTextColor(textView.getContext().getColor(R.color.qui_button_text_secondary_default));
        }
    }
}

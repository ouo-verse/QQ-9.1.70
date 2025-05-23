package com.tencent.mobileqq.guild.feed;

import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/e;", "Lcom/tencent/biz/richframework/part/Part;", "", "x9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "action", "", "args", "handleBroadcastMessage", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "getCenterView", "()Landroid/widget/TextView;", "centerView", "", "e", "I", "getType", "()I", "type", "<init>", "(Landroid/widget/TextView;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView centerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int type;

    public e(@NotNull TextView centerView, int i3) {
        Intrinsics.checkNotNullParameter(centerView, "centerView");
        this.centerView = centerView;
        this.type = i3;
    }

    private final String x9() {
        String string;
        int i3 = this.type;
        if (i3 != 2) {
            if (i3 != 3) {
                string = getContext().getString(R.string.f144440os);
            } else {
                string = getContext().getString(R.string.f144840pv, "");
            }
        } else {
            string = getContext().getString(R.string.f144430or);
        }
        Intrinsics.checkNotNullExpressionValue(string, "when(type) {\n           \u2026)\n            }\n        }");
        return string;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "message_update_title") && (args instanceof String)) {
            this.centerView.setText((CharSequence) args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        oh1.a.a(this.centerView, R.color.qui_common_text_primary);
        this.centerView.setText(x9());
    }
}

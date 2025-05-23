package i72;

import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Li72/j;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lc51/c;", "E", "Lc51/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lc51/c;", "binding", "", UserInfo.SEX_FEMALE, "Z", "l", "()Z", "p", "(Z)V", "attachedToWindow", "", "G", "I", "o", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(I)V", "emojiId", "<init>", "(Lc51/c;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class j extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private final c51.c binding;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean attachedToWindow;

    /* renamed from: G, reason: from kotlin metadata */
    private int emojiId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(c51.c binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getAttachedToWindow() {
        return this.attachedToWindow;
    }

    /* renamed from: m, reason: from getter */
    public final c51.c getBinding() {
        return this.binding;
    }

    /* renamed from: o, reason: from getter */
    public final int getEmojiId() {
        return this.emojiId;
    }

    public final void p(boolean z16) {
        this.attachedToWindow = z16;
    }

    public final void q(int i3) {
        this.emojiId = i3;
    }
}

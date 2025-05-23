package ka3;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumPreviewFragment;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.mobileqq.wink.view.RoundCornerImageView;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J)\u0010\t\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0014\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u000e\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0014\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0011\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lka3/e;", "Lka3/b;", "", "T", "U", "data", "", "position", "spanCount", "P", "(Lkotlin/Unit;II)V", BdhLogUtil.LogTag.Tag_Req, "(Lkotlin/Unit;)V", "M", "K", "L", "(Lkotlin/Unit;I)V", "I", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getOpen", "()Landroid/widget/TextView;", "open", "N", "getOpenTip", "openTip", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e extends b {

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private final TextView open;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private final TextView openTip;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.open = (TextView) itemView.findViewById(R.id.zyw);
        this.openTip = (TextView) itemView.findViewById(R.id.zyz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(e this$0, View view) {
        Activity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.itemView.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            ar.f326685a.m("ae_key_editor_need_show_memory_album_topic_new", false);
            MemoryAlbumPreviewFragment.INSTANCE.a(activity);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void T() {
        TextView textView = this.open;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    private final void U() {
        TextView textView = this.openTip;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    @Override // ka3.b, ja3.b
    /* renamed from: I */
    public void n(@NotNull Unit data) {
        Intrinsics.checkNotNullParameter(data, "data");
        TextView textView = this.open;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: ka3.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.Q(e.this, view);
                }
            });
        }
    }

    @Override // ka3.b, ja3.b
    /* renamed from: K */
    public void q(@NotNull Unit data) {
        Intrinsics.checkNotNullParameter(data, "data");
        TextView date = getDate();
        if (date != null) {
            date.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ka3.b, ja3.b
    /* renamed from: L */
    public void s(@NotNull Unit data, int spanCount) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.s(data, spanCount);
        J(getImageView(), "https://downv6.qq.com/shadow_qqcamera/memoryalbum/authorization_horizontal.png");
        N();
    }

    @Override // ka3.b, ja3.b
    /* renamed from: M */
    public void u(@NotNull Unit data) {
        Intrinsics.checkNotNullParameter(data, "data");
        TextView name = getName();
        if (name != null) {
            name.setVisibility(8);
        }
    }

    @Override // ja3.b
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void m(@Nullable Unit data, int position, int spanCount) {
        super.m(data, position, spanCount);
        T();
        U();
        B(this.open, WinkDaTongReportConstant.ElementId.EM_XSJ_MEMORIES_ALBUM_OPEN_BUTTON);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ja3.b
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void t(@NotNull Unit data) {
        Intrinsics.checkNotNullParameter(data, "data");
        RoundCornerImageView mask = getMask();
        if (mask != null) {
            mask.setVisibility(8);
        }
    }
}

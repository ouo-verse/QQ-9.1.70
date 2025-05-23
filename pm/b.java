package pm;

import android.content.Context;
import android.view.ViewGroup;
import com.qzone.reborn.publicaccount.area.RichContentAreaView;
import com.qzone.reborn.publicaccount.area.TextAreaView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellBottom;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellPlainText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lpm/b;", "", "Lnm/b;", "message", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "b", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f426462a = new b();

    b() {
    }

    private final void b(nm.b message, ViewGroup parent) {
        parent.removeAllViews();
        if (!message.m()) {
            parent.setVisibility(8);
            return;
        }
        parent.setVisibility(0);
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        RichContentAreaView richContentAreaView = new RichContentAreaView(context, null);
        QZoneOfficialAccountBase$CellPlainText cellPlainText = message.getCellPlainText();
        richContentAreaView.a(cellPlainText != null ? cellPlainText.get() : null);
        parent.addView(richContentAreaView);
    }

    public final void a(nm.b message, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (message.getCellBottom() != null) {
            QZoneOfficialAccountBase$CellBottom cellBottom = message.getCellBottom();
            Intrinsics.checkNotNull(cellBottom);
            if (cellBottom.bottom_type.get() != 0) {
                b(message, parent);
                return;
            }
        }
        parent.removeAllViews();
        TextAreaView.Companion companion = TextAreaView.INSTANCE;
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        parent.addView(companion.b(context, 1));
        parent.setVisibility(4);
    }
}

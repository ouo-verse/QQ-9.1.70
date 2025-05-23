package pm;

import android.content.Context;
import android.view.ViewGroup;
import com.qzone.reborn.publicaccount.area.AvatarListAreaView;
import com.qzone.reborn.publicaccount.area.SingleAvatarAreaView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellVisitor;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$UserInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\f"}, d2 = {"Lpm/d;", "", "Lnm/b;", "message", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "c", "b", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f426464a = new d();

    d() {
    }

    private final void b(nm.b message, ViewGroup parent) {
        parent.removeAllViews();
        QZoneOfficialAccountBase$CellVisitor cellVisitor = message.getCellVisitor();
        Intrinsics.checkNotNull(cellVisitor);
        if (!cellVisitor.user_list.has()) {
            parent.setVisibility(4);
            return;
        }
        parent.setVisibility(0);
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        AvatarListAreaView avatarListAreaView = new AvatarListAreaView(context);
        QZoneOfficialAccountBase$CellVisitor cellVisitor2 = message.getCellVisitor();
        Intrinsics.checkNotNull(cellVisitor2);
        List<QZoneOfficialAccountBase$UserInfo> list = cellVisitor2.user_list.get();
        Intrinsics.checkNotNullExpressionValue(list, "message.cellVisitor!!.user_list.get()");
        avatarListAreaView.a(list);
        parent.addView(avatarListAreaView);
    }

    private final void c(nm.b message, ViewGroup parent) {
        parent.removeAllViews();
        QZoneOfficialAccountBase$CellVisitor cellVisitor = message.getCellVisitor();
        Intrinsics.checkNotNull(cellVisitor);
        if (!cellVisitor.user_list.has()) {
            parent.setVisibility(4);
            return;
        }
        parent.setVisibility(0);
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        SingleAvatarAreaView singleAvatarAreaView = new SingleAvatarAreaView(context, message.l());
        QZoneOfficialAccountBase$CellVisitor cellVisitor2 = message.getCellVisitor();
        Intrinsics.checkNotNull(cellVisitor2);
        List<QZoneOfficialAccountBase$UserInfo> list = cellVisitor2.user_list.get();
        Intrinsics.checkNotNullExpressionValue(list, "message.cellVisitor!!.user_list.get()");
        singleAvatarAreaView.a(list);
        parent.addView(singleAvatarAreaView);
    }

    public final void a(nm.b message, ViewGroup parent) {
        if (parent == null) {
            return;
        }
        if (message != null && message.getCellVisitor() != null) {
            QZoneOfficialAccountBase$CellVisitor cellVisitor = message.getCellVisitor();
            Intrinsics.checkNotNull(cellVisitor);
            if (cellVisitor.visitor_type.get() != 0) {
                QZoneOfficialAccountBase$CellVisitor cellVisitor2 = message.getCellVisitor();
                Intrinsics.checkNotNull(cellVisitor2);
                if (cellVisitor2.visitor_type.get() == 1) {
                    c(message, parent);
                    return;
                }
                QZoneOfficialAccountBase$CellVisitor cellVisitor3 = message.getCellVisitor();
                Intrinsics.checkNotNull(cellVisitor3);
                if (cellVisitor3.visitor_type.get() == 2) {
                    b(message, parent);
                    return;
                }
                return;
            }
        }
        parent.removeAllViews();
        parent.setVisibility(4);
    }
}

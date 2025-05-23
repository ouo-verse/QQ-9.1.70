package pm;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.qzone.reborn.publicaccount.area.AvatarListAreaView;
import com.qzone.reborn.publicaccount.area.SingleAvatarAreaView;
import com.qzone.reborn.publicaccount.area.TextAreaView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellTitle;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$UserInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\r"}, d2 = {"Lpm/c;", "", "Lnm/b;", "message", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "d", "c", "b", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f426463a = new c();

    c() {
    }

    private final void b(nm.b message, ViewGroup parent) {
        parent.removeAllViews();
        QZoneOfficialAccountBase$CellTitle cellTitle = message.getCellTitle();
        Intrinsics.checkNotNull(cellTitle);
        if (!cellTitle.user_list.has()) {
            parent.setVisibility(8);
            return;
        }
        parent.setVisibility(0);
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        AvatarListAreaView avatarListAreaView = new AvatarListAreaView(context);
        QZoneOfficialAccountBase$CellTitle cellTitle2 = message.getCellTitle();
        Intrinsics.checkNotNull(cellTitle2);
        List<QZoneOfficialAccountBase$UserInfo> list = cellTitle2.user_list.get();
        Intrinsics.checkNotNullExpressionValue(list, "message.cellTitle!!.user_list.get()");
        avatarListAreaView.a(list);
        parent.addView(avatarListAreaView);
    }

    private final void c(nm.b message, ViewGroup parent) {
        parent.removeAllViews();
        QZoneOfficialAccountBase$CellTitle cellTitle = message.getCellTitle();
        Intrinsics.checkNotNull(cellTitle);
        if (!cellTitle.user_list.has()) {
            parent.setVisibility(8);
            return;
        }
        parent.setVisibility(0);
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        SingleAvatarAreaView singleAvatarAreaView = new SingleAvatarAreaView(context, message.l());
        QZoneOfficialAccountBase$CellTitle cellTitle2 = message.getCellTitle();
        Intrinsics.checkNotNull(cellTitle2);
        List<QZoneOfficialAccountBase$UserInfo> list = cellTitle2.user_list.get();
        Intrinsics.checkNotNullExpressionValue(list, "message.cellTitle!!.user_list.get()");
        singleAvatarAreaView.a(list);
        parent.addView(singleAvatarAreaView);
    }

    private final void d(nm.b message, ViewGroup parent) {
        parent.removeAllViews();
        TextAreaView.Companion companion = TextAreaView.INSTANCE;
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        TextAreaView b16 = companion.b(context, message.l());
        QZoneOfficialAccountBase$CellTitle cellTitle = message.getCellTitle();
        Intrinsics.checkNotNull(cellTitle);
        b16.setRichText(cellTitle.title.get());
        parent.addView(b16);
        QZoneOfficialAccountBase$CellTitle cellTitle2 = message.getCellTitle();
        Intrinsics.checkNotNull(cellTitle2);
        parent.setVisibility(TextUtils.isEmpty(cellTitle2.title.get()) ? 4 : 0);
    }

    public final void a(nm.b message, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (message.getCellTitle() != null) {
            QZoneOfficialAccountBase$CellTitle cellTitle = message.getCellTitle();
            Intrinsics.checkNotNull(cellTitle);
            if (cellTitle.title_type.get() != 0) {
                QZoneOfficialAccountBase$CellTitle cellTitle2 = message.getCellTitle();
                Intrinsics.checkNotNull(cellTitle2);
                if (cellTitle2.title_type.get() == 1) {
                    d(message, parent);
                    return;
                }
                QZoneOfficialAccountBase$CellTitle cellTitle3 = message.getCellTitle();
                Intrinsics.checkNotNull(cellTitle3);
                if (cellTitle3.title_type.get() == 2) {
                    c(message, parent);
                    return;
                }
                QZoneOfficialAccountBase$CellTitle cellTitle4 = message.getCellTitle();
                Intrinsics.checkNotNull(cellTitle4);
                if (cellTitle4.title_type.get() == 3) {
                    b(message, parent);
                    return;
                }
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

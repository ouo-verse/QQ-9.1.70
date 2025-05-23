package pm;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.qzone.reborn.publicaccount.area.InteractAreaView;
import com.qzone.reborn.publicaccount.area.TextAreaView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellBottom;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellPlainText;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$InteractionInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Lpm/a;", "", "Lnm/b;", "message", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "c", "b", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f426461a = new a();

    a() {
    }

    private final void b(nm.b message, ViewGroup parent) {
        parent.removeAllViews();
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        InteractAreaView interactAreaView = new InteractAreaView(context, message.l());
        QZoneOfficialAccountBase$CellBottom cellBottom = message.getCellBottom();
        Intrinsics.checkNotNull(cellBottom);
        QZoneOfficialAccountBase$InteractionInfo qZoneOfficialAccountBase$InteractionInfo = cellBottom.interaction.get();
        Intrinsics.checkNotNullExpressionValue(qZoneOfficialAccountBase$InteractionInfo, "message.cellBottom!!.interaction.get()");
        interactAreaView.a(qZoneOfficialAccountBase$InteractionInfo);
        parent.addView(interactAreaView);
        QZoneOfficialAccountBase$CellBottom cellBottom2 = message.getCellBottom();
        Intrinsics.checkNotNull(cellBottom2);
        parent.setVisibility(cellBottom2.interaction.has() ? 0 : 4);
    }

    private final void c(nm.b message, ViewGroup parent) {
        PBStringField pBStringField;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        parent.removeAllViews();
        String str = null;
        if (message.m()) {
            QZoneOfficialAccountBase$CellBottom cellBottom = message.getCellBottom();
            String str2 = (cellBottom == null || (pBStringField3 = cellBottom.text) == null) ? null : pBStringField3.get();
            QZoneOfficialAccountBase$CellPlainText cellPlainText = message.getCellPlainText();
            if (TextUtils.equals(str2, (cellPlainText == null || (pBStringField2 = cellPlainText.text) == null) ? null : pBStringField2.get()) && message.l() == 1) {
                parent.setVisibility(8);
                return;
            }
        }
        QZoneOfficialAccountBase$CellBottom cellBottom2 = message.getCellBottom();
        if (cellBottom2 != null && (pBStringField = cellBottom2.text) != null) {
            str = pBStringField.get();
        }
        if (TextUtils.isEmpty(str)) {
            parent.setVisibility(4);
            return;
        }
        parent.setVisibility(0);
        TextAreaView.Companion companion = TextAreaView.INSTANCE;
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        TextAreaView a16 = companion.a(context, message.l());
        QZoneOfficialAccountBase$CellBottom cellBottom3 = message.getCellBottom();
        Intrinsics.checkNotNull(cellBottom3);
        a16.setRichText(cellBottom3.text.get());
        parent.addView(a16);
    }

    public final void a(nm.b message, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (message.getCellBottom() != null) {
            QZoneOfficialAccountBase$CellBottom cellBottom = message.getCellBottom();
            Intrinsics.checkNotNull(cellBottom);
            if (cellBottom.bottom_type.get() != 0) {
                QZoneOfficialAccountBase$CellBottom cellBottom2 = message.getCellBottom();
                Intrinsics.checkNotNull(cellBottom2);
                if (cellBottom2.bottom_type.get() == 1) {
                    c(message, parent);
                    return;
                }
                QZoneOfficialAccountBase$CellBottom cellBottom3 = message.getCellBottom();
                Intrinsics.checkNotNull(cellBottom3);
                if (cellBottom3.bottom_type.get() == 2) {
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
        parent.addView(companion.a(context, 1));
        parent.setVisibility(4);
    }
}

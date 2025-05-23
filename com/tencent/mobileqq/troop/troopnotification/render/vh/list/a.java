package com.tencent.mobileqq.troop.troopnotification.render.vh.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.troopnotification.render.parser.TroopNotificationBaseButtonParser;
import com.tencent.mobileqq.troop.troopnotification.render.richtext.TroopNotificationRichTextView;
import com.tencent.mobileqq.troop.troopnotification.report.d;
import com.tencent.mobileqq.troop.troopnotification.utils.f;
import com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationListVM;
import com.tencent.mobileqq.troop.widget.swipe.CommonSwipeMenuLayout;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateType;
import com.tencent.widget.SimpleTextView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010%\u001a\u00020\u0010\u0012\u0006\u0010+\u001a\u00020&\u0012\u0006\u0010Z\u001a\u00020Y\u0012\u0006\u0010\\\u001a\u00020[\u00a2\u0006\u0004\b]\u0010^J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J6\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J \u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020\u0005H\u0016R\u0017\u0010%\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010+\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u00101\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0017\u00107\u001a\u0002028\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0017\u0010<\u001a\u0002088\u0006\u00a2\u0006\f\n\u0004\b\"\u00109\u001a\u0004\b:\u0010;R\u001a\u0010A\u001a\u00020\f8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010H\u001a\u00020\u00128&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bF\u0010GR\u0014\u0010J\u001a\u0002088&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bI\u0010;R\u0014\u0010N\u001a\u00020K8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bP\u0010QR\u0014\u0010T\u001a\u00020\u00108&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bS\u0010$R\u0014\u0010X\u001a\u00020U8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bV\u0010W\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/vh/list/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lpt2/a;", "Lcom/tencent/mobileqq/troop/troopnotification/render/parser/a;", "parser", "", "b", "Lcom/tencent/qqnt/notification/f;", "msg", "", "wildcardValue", "", "", "data", "", "a", "", "index", "Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/TroopNotificationRichTextView;", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/data/troop/d;", "info", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyOperateType;", "operateType", "Lcom/tencent/mobileqq/troop/troopnotification/render/parser/TroopNotificationBaseButtonParser$a;", "clickData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "doubtTips", "B", "w", "E", "I", "getStyleId", "()I", "styleId", "Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;", "getVm", "()Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;", "vm", "Lcom/tencent/mobileqq/troop/widget/swipe/CommonSwipeMenuLayout;", "G", "Lcom/tencent/mobileqq/troop/widget/swipe/CommonSwipeMenuLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/troop/widget/swipe/CommonSwipeMenuLayout;", "delLayout", "Lcom/tencent/widget/SimpleTextView;", "H", "Lcom/tencent/widget/SimpleTextView;", "o", "()Lcom/tencent/widget/SimpleTextView;", "delMenu", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/view/ViewGroup;", "root", "J", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "l", "()Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatar", "t", "()Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/TroopNotificationRichTextView;", "titleLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "messageLayout", "Landroid/widget/Button;", "r", "()Landroid/widget/Button;", "operationBtn", "Landroid/widget/TextView;", "p", "()Landroid/widget/TextView;", "hintBtn", "u", "titleTextColor", "", "v", "()F", "titleTextSize", "Landroid/content/Context;", "context", "Landroidx/viewbinding/ViewBinding;", "viewBinding", "<init>", "(ILcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;Landroid/content/Context;Landroidx/viewbinding/ViewBinding;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class a extends RecyclerView.ViewHolder implements pt2.a {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    private final int styleId;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TroopNotificationListVM vm;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final CommonSwipeMenuLayout delLayout;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final SimpleTextView delMenu;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ViewGroup root;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final String tag;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(int i3, @NotNull TroopNotificationListVM vm5, @NotNull Context context, @NotNull ViewBinding viewBinding) {
        super(r0.b(context, r1));
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        f fVar = f.f300930a;
        View root = viewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), vm5, context, viewBinding);
            return;
        }
        this.styleId = i3;
        this.vm = vm5;
        View view = this.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.troop.widget.swipe.CommonSwipeMenuLayout");
        this.delLayout = (CommonSwipeMenuLayout) view;
        View findViewById = this.itemView.findViewById(R.id.f10321600);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(co\u2026cation_item_swipe_delete)");
        this.delMenu = (SimpleTextView) findViewById;
        View root2 = viewBinding.getRoot();
        Intrinsics.checkNotNull(root2, "null cannot be cast to non-null type android.view.ViewGroup");
        this.root = (ViewGroup) root2;
        this.tag = "list";
    }

    public void A(@NotNull GroupNotifyOperateType operateType, @NotNull com.tencent.qqnt.notification.f msg2, @NotNull TroopNotificationBaseButtonParser.a clickData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, operateType, msg2, clickData);
            return;
        }
        Intrinsics.checkNotNullParameter(operateType, "operateType");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(clickData, "clickData");
        this.vm.F2(operateType, msg2, clickData);
        d.f300921a.i(operateType, msg2);
    }

    public void B(@NotNull String doubtTips) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) doubtTips);
        } else {
            Intrinsics.checkNotNullParameter(doubtTips, "doubtTips");
        }
    }

    public void C(@NotNull com.tencent.mobileqq.data.troop.d info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) info);
        } else {
            Intrinsics.checkNotNullParameter(info, "info");
        }
    }

    @Override // pt2.a
    public boolean a(@NotNull com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull com.tencent.mobileqq.troop.troopnotification.render.parser.a parser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, msg2, wildcardValue, data, parser)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(parser, "parser");
        return parser.c(msg2, wildcardValue, data, this);
    }

    @Override // pt2.a
    public void b(@NotNull com.tencent.mobileqq.troop.troopnotification.render.parser.a parser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) parser);
        } else {
            Intrinsics.checkNotNullParameter(parser, "parser");
            parser.d(this);
        }
    }

    @Override // pt2.a
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.tag;
    }

    @NotNull
    public abstract QQProAvatarView l();

    @NotNull
    public final CommonSwipeMenuLayout m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CommonSwipeMenuLayout) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.delLayout;
    }

    @NotNull
    public final SimpleTextView o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SimpleTextView) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.delMenu;
    }

    @NotNull
    public abstract TextView p();

    @NotNull
    public abstract ViewGroup q();

    @NotNull
    public abstract Button r();

    @NotNull
    public final ViewGroup s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.root;
    }

    @NotNull
    public abstract TroopNotificationRichTextView t();

    public abstract int u();

    public abstract float v();

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    @Nullable
    public TroopNotificationRichTextView y(int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (TroopNotificationRichTextView) iPatchRedirector.redirect((short) 10, (Object) this, index);
        }
        return null;
    }

    public void z(@NotNull com.tencent.qqnt.notification.f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) msg2);
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }
    }
}

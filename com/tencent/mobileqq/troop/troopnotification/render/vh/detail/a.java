package com.tencent.mobileqq.troop.troopnotification.render.vh.detail;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.troopnotification.render.parser.TroopNotificationBaseButtonParser;
import com.tencent.mobileqq.troop.troopnotification.render.richtext.TroopNotificationRichTextView;
import com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationDetailVM;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateType;
import com.tencent.qqnt.notification.f;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u00100\u001a\u00020\u000f\u0012\u0006\u0010^\u001a\u00020!\u0012\u0006\u0010`\u001a\u00020_\u00a2\u0006\u0004\ba\u0010bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J6\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001fH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u0015H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010)\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'H\u0016J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010,\u001a\u00020\u0004H\u0016R\u0017\u00100\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b#\u0010-\u001a\u0004\b.\u0010/R\u0017\u00106\u001a\u0002018\u0006\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0017\u0010<\u001a\u0002078\u0006\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001a\u0010@\u001a\u00020\u000b8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\"\u0010=\u001a\u0004\b>\u0010?R\u0014\u0010C\u001a\u00020A8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u0010BR\u0014\u0010F\u001a\u00020\u00118&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bD\u0010ER\u0014\u0010I\u001a\u00020!8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bK\u0010LR\u0014\u0010O\u001a\u00020J8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bN\u0010LR\u0014\u0010Q\u001a\u00020!8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bP\u0010HR\u0014\u0010S\u001a\u00020\u00158&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u0010RR\u0014\u0010U\u001a\u00020\u00158&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bT\u0010RR\u0014\u0010W\u001a\u00020J8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bV\u0010LR\u0014\u0010Y\u001a\u00020\u000f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bX\u0010/R\u0014\u0010]\u001a\u00020Z8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b[\u0010\\\u00a8\u0006c"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/vh/detail/a;", "Lpt2/a;", "Lcom/tencent/mobileqq/troop/troopnotification/render/parser/a;", "parser", "", "b", "Lcom/tencent/qqnt/notification/f;", "msg", "", "wildcardValue", "", "", "data", "", "a", "", "index", "Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/TroopNotificationRichTextView;", HippyTKDListViewAdapter.X, "w", "y", "Landroid/widget/TextView;", "p", "v", "Lcom/tencent/mobileqq/data/troop/d;", "info", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/troopcatalog/a;", "bean", "D", "u", "Lcom/tencent/mobileqq/data/Card;", "B", "Landroid/view/ViewGroup;", h.F, "d", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyOperateType;", "operateType", "Lcom/tencent/mobileqq/troop/troopnotification/render/parser/TroopNotificationBaseButtonParser$a;", "clickData", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "doubtTips", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "t", "I", "getStyleId", "()I", "styleId", "Landroid/view/View;", "e", "Landroid/view/View;", "o", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "f", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "k", "()Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "navBar", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "()Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatar", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/TroopNotificationRichTextView;", "titleLayout", "j", "()Landroid/view/ViewGroup;", "messageLayout", "Landroid/widget/Button;", "l", "()Landroid/widget/Button;", "operationBtn", "g", "cancelBtn", DomainData.DOMAIN_NAME, "reportLayout", "()Landroid/widget/TextView;", "blackListBtn", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "reportBtn", "c", "againBtn", "r", "titleTextColor", "", ReportConstant.COSTREPORT_PREFIX, "()F", "titleTextSize", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/viewbinding/ViewBinding;", "viewBinding", "<init>", "(ILandroid/view/ViewGroup;Landroidx/viewbinding/ViewBinding;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class a implements pt2.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int styleId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View rootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUISecNavBar navBar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    public a(int i3, @NotNull ViewGroup parent, @NotNull ViewBinding viewBinding) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), parent, viewBinding);
            return;
        }
        this.styleId = i3;
        View root = viewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
        this.rootView = root;
        View findViewById = parent.findViewById(R.id.idz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "parent.findViewById(R.id.rl_title_bar)");
        this.navBar = (QUISecNavBar) findViewById;
        this.tag = "detail";
    }

    public void A(@NotNull String doubtTips, @NotNull f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) doubtTips, (Object) msg2);
        } else {
            Intrinsics.checkNotNullParameter(doubtTips, "doubtTips");
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }
    }

    public void B(@NotNull Card info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) info);
        } else {
            Intrinsics.checkNotNullParameter(info, "info");
        }
    }

    public void C(@NotNull d info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) info);
        } else {
            Intrinsics.checkNotNullParameter(info, "info");
        }
    }

    public void D(@NotNull com.tencent.mobileqq.troop.troopcatalog.a bean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bean);
        } else {
            Intrinsics.checkNotNullParameter(bean, "bean");
        }
    }

    @Override // pt2.a
    public boolean a(@NotNull f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull com.tencent.mobileqq.troop.troopnotification.render.parser.a parser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, msg2, wildcardValue, data, parser)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(parser, "parser");
        return parser.a(msg2, wildcardValue, data, this);
    }

    @Override // pt2.a
    public void b(@NotNull com.tencent.mobileqq.troop.troopnotification.render.parser.a parser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) parser);
        } else {
            Intrinsics.checkNotNullParameter(parser, "parser");
            parser.b(this);
        }
    }

    @NotNull
    public abstract Button c();

    @Nullable
    public TextView d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (TextView) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return null;
    }

    @NotNull
    public abstract QQProAvatarView e();

    @NotNull
    public abstract TextView f();

    @NotNull
    public abstract Button g();

    @Override // pt2.a
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.tag;
    }

    @Nullable
    public ViewGroup h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return null;
    }

    @Nullable
    public TroopNotificationRichTextView i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (TroopNotificationRichTextView) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return null;
    }

    @NotNull
    public abstract ViewGroup j();

    @NotNull
    public final QUISecNavBar k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QUISecNavBar) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.navBar;
    }

    @NotNull
    public abstract Button l();

    @NotNull
    public abstract TextView m();

    @NotNull
    public abstract ViewGroup n();

    @NotNull
    public final View o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.rootView;
    }

    @Nullable
    public TextView p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (TextView) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return null;
    }

    @NotNull
    public abstract TroopNotificationRichTextView q();

    public abstract int r();

    public abstract float s();

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        }
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    @Nullable
    public TroopNotificationRichTextView w(int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TroopNotificationRichTextView) iPatchRedirector.redirect((short) 9, (Object) this, index);
        }
        return null;
    }

    @Nullable
    public TroopNotificationRichTextView x(int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TroopNotificationRichTextView) iPatchRedirector.redirect((short) 8, (Object) this, index);
        }
        return null;
    }

    public void y(@NotNull f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) msg2);
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }
    }

    public void z(@NotNull GroupNotifyOperateType operateType, @NotNull f msg2, @NotNull TroopNotificationBaseButtonParser.a clickData) {
        FragmentActivity fragmentActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, operateType, msg2, clickData);
            return;
        }
        Intrinsics.checkNotNullParameter(operateType, "operateType");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(clickData, "clickData");
        Context context = this.rootView.getContext();
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            TroopNotificationDetailVM a16 = TroopNotificationDetailVM.INSTANCE.a(fragmentActivity);
            if (operateType == GroupNotifyOperateType.KREFUSE && Intrinsics.areEqual(clickData.c(), "1")) {
                a16.i2(fragmentActivity, msg2, clickData);
            } else {
                a16.l2(operateType, msg2, clickData);
            }
        }
    }
}

package com.tencent.mobileqq.troop.appscenter.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/adapter/z;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "context", "", "o", "Lcom/tencent/mobileqq/troop/appscenter/data/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lds2/a;", "E", "Lds2/a;", "delegateListener", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "switchItem", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lds2/a;)V", "G", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class z extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ds2.a delegateListener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private QUISingleLineListItem switchItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/adapter/z$a;", "", "", "EM_GROUP_QUICK_APPLICATION_SWITCH", "Ljava/lang/String;", "GROUP_QUICK_APPLICATION_SWITCH", "", "OFF", "I", "ON", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.appscenter.adapter.z$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25499);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(@NotNull View itemView, @NotNull ds2.a delegateListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(delegateListener, "delegateListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView, (Object) delegateListener);
            return;
        }
        this.delegateListener = delegateListener;
        View findViewById = itemView.findViewById(R.id.f100995u0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026roop_app_aio_show_switch)");
        this.switchItem = (QUISingleLineListItem) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(z this$0, com.tencent.mobileqq.troop.appscenter.data.b item, CompoundButton compoundButton, boolean z16) {
        Map emptyMap;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        View view = this$0.itemView;
        emptyMap = MapsKt__MapsKt.emptyMap();
        VideoReport.reportEvent("dt_clck", view, emptyMap);
        this$0.delegateListener.d(z16);
        item.f(z16);
        if (z16 && this$0.o(this$0.itemView.getContext()) && item.e() && this$0.itemView.getContext() != null) {
            new com.tencent.mobileqq.troop.appscenter.view.b(this$0.itemView.getContext()).show();
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final boolean o(Context context) {
        String str;
        if (context == null) {
            return false;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getAccount();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        String str2 = "troopapp_aio_shortcut_bar_guide" + str;
        boolean z16 = defaultSharedPreferences.getBoolean(str2, true);
        if (z16) {
            SharedPreferences.Editor edit = defaultSharedPreferences.edit();
            edit.putBoolean(str2, false);
            edit.apply();
        }
        return z16;
    }

    public final void m(@NotNull final com.tencent.mobileqq.troop.appscenter.data.b item) {
        Map mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (!item.c()) {
            this.switchItem.setVisibility(8);
            return;
        }
        this.switchItem.setVisibility(0);
        VideoReport.setElementId(this.itemView, "em_group_quick_application_switch");
        View view = this.itemView;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("group_quick_application_switch", Integer.valueOf(item.d() ? 1 : 0)));
        VideoReport.setElementParams(view, mapOf);
        com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.d("\u5728\u804a\u5929\u5feb\u6377\u680f\u5c55\u793a\u7fa4\u5e94\u7528"), new x.c.f(item.d(), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.appscenter.adapter.y
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                z.n(z.this, item, compoundButton, z16);
            }
        }));
        this.switchItem.setConfig(xVar.K(), xVar.O());
        ((Switch) this.switchItem.findViewById(R.id.f66283a8)).setBackground(null);
        this.switchItem.setStyle(QUIListItemStyle.Card);
        this.switchItem.setBackgroundType(QUIListItemBackgroundType.None);
        QUISingleLineListItem qUISingleLineListItem = this.switchItem;
        QUIListItemBackgroundType.Companion companion = QUIListItemBackgroundType.INSTANCE;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        qUISingleLineListItem.setBackground(companion.a(context, 1000, R.color.qui_common_fill_standard_extra, ViewUtils.dpToPx(8.0f), ViewUtils.dpToPx(8.0f)));
    }
}

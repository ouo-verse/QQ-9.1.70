package com.tencent.mobileqq.troop.deletemember.inject.delegate;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.selectmember.adapter.AbsTroopSelectMemberDelegate;
import com.tencent.mobileqq.troop.selectmember.bean.c;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberIllegalInfoResult;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002)*B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J&\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0014J.\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0011H\u0014J\u0012\u0010\u001f\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R#\u0010%\u001a\n !*\u0004\u0018\u00010 0 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/troop/deletemember/inject/delegate/TroopDeleteMemberGroupDelegate;", "Lcom/tencent/mobileqq/troop/selectmember/adapter/AbsTroopSelectMemberDelegate;", "Lcom/tencent/mobileqq/troop/selectmember/bean/a;", "Lcom/tencent/mobileqq/troop/deletemember/inject/delegate/TroopDeleteMemberGroupDelegate$b;", "Landroid/view/View$OnClickListener;", "holder", "Lcom/tencent/mobileqq/troop/deletemember/inject/items/b;", "itemData", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/troop/deletemember/inject/items/c;", "illegalGroupInfo", "r", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "payloads", "p", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Ljava/lang/String;", "noChildSelectHintText", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopDeleteMemberGroupDelegate extends AbsTroopSelectMemberDelegate<com.tencent.mobileqq.troop.selectmember.bean.a, b> implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy noChildSelectHintText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/deletemember/inject/delegate/TroopDeleteMemberGroupDelegate$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.deletemember.inject.delegate.TroopDeleteMemberGroupDelegate$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00105\u001a\u00020\u0002\u00a2\u0006\u0004\b6\u00107R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012R*\u0010%\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00104\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u001a\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/troop/deletemember/inject/delegate/TroopDeleteMemberGroupDelegate$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "E", "Landroid/view/View;", "l", "()Landroid/view/View;", "groupContent", "Landroid/widget/CheckBox;", UserInfo.SEX_FEMALE, "Landroid/widget/CheckBox;", "p", "()Landroid/widget/CheckBox;", "indicator", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "groupName", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "o", "()Landroid/widget/ImageView;", "illegalMarkIcon", "I", ReportConstant.COSTREPORT_PREFIX, "selectedStatus", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "J", "Ljava/lang/StringBuilder;", "t", "()Ljava/lang/StringBuilder;", "setTalkback", "(Ljava/lang/StringBuilder;)V", "talkback", "Lcom/tencent/mobileqq/troop/deletemember/inject/items/b;", "K", "Lcom/tencent/mobileqq/troop/deletemember/inject/items/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/troop/deletemember/inject/items/b;", "u", "(Lcom/tencent/mobileqq/troop/deletemember/inject/items/b;)V", "itemData", "", "L", "r", "()I", "v", "(I)V", "itemPosition", "itemView", "<init>", "(Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View groupContent;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final CheckBox indicator;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView groupName;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final ImageView illegalMarkIcon;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final TextView selectedStatus;

        /* renamed from: J, reason: from kotlin metadata */
        @Nullable
        private StringBuilder talkback;

        /* renamed from: K, reason: from kotlin metadata */
        @Nullable
        private com.tencent.mobileqq.troop.deletemember.inject.items.b itemData;

        /* renamed from: L, reason: from kotlin metadata */
        private int itemPosition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
                return;
            }
            View findViewById = itemView.findViewById(R.id.vtx);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026roup_item_content_layout)");
            this.groupContent = findViewById;
            View findViewById2 = itemView.findViewById(R.id.dv_);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.iv_fake_indicator)");
            this.indicator = (CheckBox) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.group_name);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.group_name)");
            this.groupName = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.vtw);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.group_info_circle)");
            this.illegalMarkIcon = (ImageView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.f82764hr);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.selected_status)");
            this.selectedStatus = (TextView) findViewById5;
            this.itemPosition = -1;
        }

        @NotNull
        public final View l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.groupContent;
        }

        @NotNull
        public final TextView m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (TextView) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.groupName;
        }

        @NotNull
        public final ImageView o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (ImageView) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.illegalMarkIcon;
        }

        @NotNull
        public final CheckBox p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (CheckBox) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.indicator;
        }

        @Nullable
        public final com.tencent.mobileqq.troop.deletemember.inject.items.b q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (com.tencent.mobileqq.troop.deletemember.inject.items.b) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.itemData;
        }

        public final int r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return this.itemPosition;
        }

        @NotNull
        public final TextView s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (TextView) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.selectedStatus;
        }

        @Nullable
        public final StringBuilder t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (StringBuilder) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.talkback;
        }

        public final void u(@Nullable com.tencent.mobileqq.troop.deletemember.inject.items.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
            } else {
                this.itemData = bVar;
            }
        }

        public final void v(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, i3);
            } else {
                this.itemPosition = i3;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28553);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopDeleteMemberGroupDelegate() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(TroopDeleteMemberGroupDelegate$noChildSelectHintText$2.INSTANCE);
            this.noChildSelectHintText = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void l(b holder, com.tencent.mobileqq.troop.deletemember.inject.items.b itemData) {
        LiveData<List<c>> liveData;
        boolean z16;
        String format;
        TextView s16 = holder.s();
        com.tencent.mobileqq.troop.selectmember.vm.a g16 = g();
        if (g16 != null) {
            liveData = g16.P();
        } else {
            liveData = null;
        }
        List<c> j3 = itemData.j(liveData);
        List<c> list = j3;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            format = n();
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String qqStr = HardCodeUtil.qqStr(R.string.f2061157f);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qq_troop_member_cancel_select_text)");
            format = String.format(qqStr, Arrays.copyOf(new Object[]{String.valueOf(j3.size())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        }
        s16.setText(format);
        s16.setTag(holder);
        s16.setOnClickListener(this);
    }

    private final void m(b holder, com.tencent.mobileqq.troop.deletemember.inject.items.b itemData) {
        String str;
        StringBuilder t16 = holder.t();
        if (t16 == null) {
            t16 = new StringBuilder(24);
        } else {
            t16.delete(0, t16.length());
        }
        if (itemData.isExpanded()) {
            str = "\u5df2\u5c55\u5f00";
        } else {
            str = "\u5df2\u6298\u53e0";
        }
        t16.append(str);
        t16.append("\u5206\u7ec4");
        t16.append(holder.m().getText());
        holder.l().setContentDescription(t16);
        holder.l().setFocusable(true);
    }

    private final String n() {
        return (String) this.noChildSelectHintText.getValue();
    }

    private final void r(Context context, com.tencent.mobileqq.troop.deletemember.inject.items.c illegalGroupInfo) {
        if (com.tencent.mobileqq.troop.trooptodo.a.a("onGroupInfoIconClick")) {
            return;
        }
        GroupMemberIllegalInfoResult m3 = illegalGroupInfo.m();
        if (m3 == null) {
            QLog.w("TroopDeleteMemberGroupDelegate", 1, "[onGroupInfoIconClick] failed. result is null");
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230);
        if (!TextUtils.isEmpty(m3.getMsgBoxTitle())) {
            createCustomDialog.setTitle(m3.getMsgBoxTitle());
        }
        if (!TextUtils.isEmpty(m3.getMsgBoxContent())) {
            createCustomDialog.setMessage(m3.getMsgBoxContent());
            createCustomDialog.setPositiveButton("\u6211\u77e5\u9053\u4e86", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.deletemember.inject.delegate.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    TroopDeleteMemberGroupDelegate.s(dialogInterface, i3);
                }
            });
            createCustomDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull com.tencent.mobileqq.troop.selectmember.bean.a item, @NotNull List<com.tencent.mobileqq.troop.selectmember.bean.a> items, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, item, items, Integer.valueOf(position))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof com.tencent.mobileqq.troop.deletemember.inject.items.b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Object obj;
        b bVar;
        Integer num;
        com.tencent.mobileqq.troop.selectmember.bean.b bVar2;
        com.tencent.mobileqq.troop.deletemember.inject.items.b q16;
        List<c> a16;
        com.tencent.mobileqq.troop.deletemember.inject.items.b q17;
        AbsTroopSelectMemberDelegate.a c16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else {
            com.tencent.mobileqq.troop.deletemember.inject.items.c cVar = null;
            if (v3 != null) {
                obj = v3.getTag();
            } else {
                obj = null;
            }
            if (obj instanceof b) {
                bVar = (b) obj;
            } else {
                bVar = null;
            }
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.vtx) {
                if (bVar != null && (q17 = bVar.q()) != null && (c16 = c()) != null) {
                    c16.r3(q17, bVar.r());
                }
            } else if (num != null && num.intValue() == R.id.f82764hr) {
                if (bVar != null && (q16 = bVar.q()) != null && (a16 = q16.a()) != null) {
                    if (Intrinsics.areEqual(bVar.s().getText(), n())) {
                        com.tencent.mobileqq.troop.selectmember.vm.a g16 = g();
                        if (g16 != null) {
                            g16.j1(a16);
                        }
                    } else {
                        com.tencent.mobileqq.troop.selectmember.vm.a g17 = g();
                        if (g17 != null) {
                            g17.K(a16);
                        }
                    }
                }
            } else if (num != null && num.intValue() == R.id.vtw) {
                if (bVar != null) {
                    bVar2 = bVar.q();
                } else {
                    bVar2 = null;
                }
                if (bVar2 instanceof com.tencent.mobileqq.troop.deletemember.inject.items.c) {
                    cVar = (com.tencent.mobileqq.troop.deletemember.inject.items.c) bVar2;
                }
                if (cVar != null) {
                    Context context = v3.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "v.context");
                    r(context, cVar);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0073, code lost:
    
        if (r8 == false) goto L20;
     */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder2(@NotNull com.tencent.mobileqq.troop.selectmember.bean.a item, @NotNull b holder, int position, @NotNull List<Object> payloads) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, item, holder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        com.tencent.mobileqq.troop.deletemember.inject.items.b bVar = (com.tencent.mobileqq.troop.deletemember.inject.items.b) item;
        holder.u(bVar);
        holder.v(position);
        TextView m3 = holder.m();
        Object itemData = bVar.getItemData();
        Intrinsics.checkNotNull(itemData, "null cannot be cast to non-null type kotlin.String");
        m3.setText((String) itemData);
        holder.p().setChecked(bVar.isExpanded());
        if (bVar instanceof com.tencent.mobileqq.troop.deletemember.inject.items.c) {
            String l3 = ((com.tencent.mobileqq.troop.deletemember.inject.items.c) bVar).l();
            if (l3 != null && l3.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
        }
        z17 = false;
        ImageView o16 = holder.o();
        if (!z17) {
            i3 = 8;
        }
        o16.setVisibility(i3);
        o16.setOnClickListener(this);
        o16.setTag(holder);
        l(holder, bVar);
        holder.l().setTag(holder);
        holder.l().setOnClickListener(this);
        m(holder, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168571fy3, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new b(itemView);
    }
}

package com.tencent.mobileqq.troop.troopidentity.view.alltags;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.troopidentity.dialog.h;
import com.tencent.mobileqq.troop.troopidentity.dialog.i;
import com.tencent.mobileqq.troop.troopidentity.util.TroopIdentityHonorUtil;
import com.tencent.mobileqq.troop.troopidentity.view.alltags.a;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityInteractionTag;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u000212Bc\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012B\b\u0002\u0010(\u001a<\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fj\u0004\u0018\u0001`%\u00a2\u0006\u0004\b.\u0010/J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u001c\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u001c\u0010\u0010\u001a\u00020\u00062\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dRN\u0010(\u001a<\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fj\u0004\u0018\u0001`%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R$\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00040)j\b\u0012\u0004\u0012\u00020\u0004`*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/a$b;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityInteractionTag;", "tagList", "", "n0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "m0", "getItemCount", "holder", "position", "l0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "troopUin", "Lcom/tencent/mobileqq/troop/troopidentity/util/a;", "D", "Lcom/tencent/mobileqq/troop/troopidentity/util/a;", "reporter", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "iconInfo", "", "isSelected", "Lcom/tencent/mobileqq/troop/troopidentity/view/TroopIdentityInteractiveIconClickCallback;", "E", "Lkotlin/jvm/functions/Function2;", "cb", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "items", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mobileqq/troop/troopidentity/util/a;Lkotlin/jvm/functions/Function2;)V", "G", "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends RecyclerView.Adapter<b> {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.troopidentity.util.a reporter;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final Function2<GroupIdentityInteractionTag, Boolean, Unit> cb;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<GroupIdentityInteractionTag> items;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopidentity.view.alltags.a$a, reason: collision with other inner class name and from kotlin metadata */
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
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/a$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityInteractionTag;", "data", "", "r", "iconUrl", "", "u", ReportConstant.COSTREPORT_PREFIX, "t", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "Landroid/view/View;", "E", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "iconImg", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "iconText", "H", "setIcon", "I", "setDesc", "<init>", "(Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/a;Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public final class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View rootView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final ImageView iconImg;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView iconText;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final ImageView setIcon;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final TextView setDesc;
        final /* synthetic */ a J;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/troopidentity/view/alltags/a$b$a", "Lcom/tencent/mobileqq/troop/troopidentity/dialog/a;", "", "isSelected", "", "onSelected", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.troop.troopidentity.view.alltags.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        public static final class C8814a implements com.tencent.mobileqq.troop.troopidentity.dialog.a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ GroupIdentityInteractionTag f300430a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f300431b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ b f300432c;

            C8814a(GroupIdentityInteractionTag groupIdentityInteractionTag, a aVar, b bVar) {
                this.f300430a = groupIdentityInteractionTag;
                this.f300431b = aVar;
                this.f300432c = bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, groupIdentityInteractionTag, aVar, bVar);
                }
            }

            @Override // com.tencent.mobileqq.troop.troopidentity.dialog.a
            public void onSelected(boolean isSelected) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, isSelected);
                    return;
                }
                GroupIdentityInteractionTag groupIdentityInteractionTag = this.f300430a;
                QLog.i("InteractiveTagsGridAdapter", 1, "[onSelected] id:" + groupIdentityInteractionTag.interactionTagId + ", name:" + groupIdentityInteractionTag.name + ", isSelected:" + isSelected);
                this.f300431b.reporter.b(this.f300432c.t(this.f300430a), this.f300432c.q(this.f300430a));
                Function2 function2 = this.f300431b.cb;
                if (function2 != null) {
                    function2.invoke(this.f300430a, Boolean.valueOf(isSelected));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull a aVar, View rootView) {
            super(rootView);
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            this.J = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) rootView);
                return;
            }
            this.rootView = rootView;
            View findViewById = rootView.findViewById(R.id.f102125x2);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026.troop_identity_icon_img)");
            this.iconImg = (ImageView) findViewById;
            View findViewById2 = rootView.findViewById(R.id.f102145x4);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026troop_identity_icon_text)");
            this.iconText = (TextView) findViewById2;
            View findViewById3 = rootView.findViewById(R.id.f83524js);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.set_icon)");
            this.setIcon = (ImageView) findViewById3;
            View findViewById4 = rootView.findViewById(R.id.f83504jq);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.set_desc)");
            this.setDesc = (TextView) findViewById4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(b this$0, GroupIdentityInteractionTag data, String iconUrl, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(iconUrl, "$iconUrl");
            this$0.u(data, iconUrl);
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, Object> q(GroupIdentityInteractionTag data) {
            int i3;
            Map<String, Object> mapOf;
            Pair[] pairArr = new Pair[3];
            pairArr[0] = TuplesKt.to("group_interact_id", data.interactionTagId);
            if (data.isSet) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            pairArr[1] = TuplesKt.to("group_btn_type", Integer.valueOf(i3));
            pairArr[2] = TuplesKt.to("group_active_state", 1);
            mapOf = MapsKt__MapsKt.mapOf(pairArr);
            return mapOf;
        }

        private final String r(GroupIdentityInteractionTag data) {
            Integer intOrNull;
            String str = data.interactionTagId;
            Intrinsics.checkNotNullExpressionValue(str, "data.interactionTagId");
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
            if (data.isObtained) {
                return TroopIdentityHonorUtil.f300410a.a(intOrNull);
            }
            return TroopIdentityHonorUtil.f300410a.d(intOrNull);
        }

        private final String s(GroupIdentityInteractionTag data) {
            if (data.isObtained) {
                return "em_group_light_interact";
            }
            return "em_group_unlit_interact";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String t(GroupIdentityInteractionTag data) {
            if (data.isObtained) {
                return "em_group_light_pop";
            }
            return "em_group_unlit_pop";
        }

        private final void u(GroupIdentityInteractionTag data, String iconUrl) {
            Map<String, ? extends Object> mapOf;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            new h(context, this.J.troopUin, i.a(data, iconUrl), new C8814a(data, this.J, this)).show();
            this.J.reporter.d(t(data), q(data));
            com.tencent.mobileqq.troop.troopidentity.util.a aVar = this.J.reporter;
            String s16 = s(data);
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("group_interact_id", data.interactionTagId));
            aVar.b(s16, mapOf);
        }

        public final void o(@NotNull final GroupIdentityInteractionTag data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            final String r16 = r(data);
            if (!TextUtils.isEmpty(r16)) {
                Option option = Option.obtain().setUrl(r16).setTargetView(this.iconImg);
                QQPicLoader qQPicLoader = QQPicLoader.f201806a;
                Intrinsics.checkNotNullExpressionValue(option, "option");
                qQPicLoader.e(option, null);
            }
            this.iconText.setText(data.name);
            this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopidentity.view.alltags.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.b.p(a.b.this, data, r16, view);
                }
            });
            QLog.d("InteractiveTagsGridAdapter", 2, "[bind] name:" + data.name + ", isObtained:" + data.isObtained + ", isSet:" + data.isSet);
            if (data.isSet) {
                this.setIcon.setVisibility(0);
                this.setDesc.setVisibility(0);
                TroopIdentityHonorUtil.f300410a.i(this.setIcon, "https://downv6.qq.com/extendfriend/mutual_tag_peidai.png");
            } else {
                this.setIcon.setVisibility(8);
                this.setDesc.setVisibility(8);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57889);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull Context context, @NotNull String troopUin, @NotNull com.tencent.mobileqq.troop.troopidentity.util.a reporter, @Nullable Function2<? super GroupIdentityInteractionTag, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, troopUin, reporter, function2);
            return;
        }
        this.context = context;
        this.troopUin = troopUin;
        this.reporter = reporter;
        this.cb = function2;
        this.items = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        GroupIdentityInteractionTag groupIdentityInteractionTag = this.items.get(position);
        Intrinsics.checkNotNullExpressionValue(groupIdentityInteractionTag, "items[position]");
        holder.o(groupIdentityInteractionTag);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        View itemView = View.inflate(parent.getContext(), R.layout.g0m, null);
        int i16 = -2;
        itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        ab.e(itemView, ViewUtils.dpToPx(4.0f));
        int dpToPx = ViewUtils.dpToPx(8.0f);
        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        }
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = itemView.getLayoutParams();
            if (layoutParams2 != null) {
                i3 = layoutParams2.width;
            } else {
                i3 = -2;
            }
            ViewGroup.LayoutParams layoutParams3 = itemView.getLayoutParams();
            if (layoutParams3 != null) {
                i16 = layoutParams3.height;
            }
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, i16);
        }
        if (dpToPx != marginLayoutParams.bottomMargin) {
            marginLayoutParams.bottomMargin = dpToPx;
            itemView.setLayoutParams(marginLayoutParams);
        }
        return new b(this, itemView);
    }

    public final void n0(@NotNull List<GroupIdentityInteractionTag> tagList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) tagList);
            return;
        }
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        this.items.clear();
        this.items.addAll(tagList);
        notifyDataSetChanged();
    }
}

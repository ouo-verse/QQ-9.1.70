package com.tencent.mobileqq.troop.homework.common.trooplist.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.homework.common.trooplist.data.TroopItemType;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b \u0010!J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\n \r*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\n \r*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\n \r*\u0004\u0018\u00010\u00190\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001e\u001a\n \r*\u0004\u0018\u00010\u00190\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/trooplist/adapter/d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/troop/homework/common/trooplist/data/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/homework/common/trooplist/viewmodel/a;", "E", "Lcom/tencent/mobileqq/troop/homework/common/trooplist/viewmodel/a;", "getViewModel", "()Lcom/tencent/mobileqq/troop/homework/common/trooplist/viewmodel/a;", "viewModel", "Landroid/view/View;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "G", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "checkBox", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "H", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatar", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "content", "J", "studentCount", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/troop/homework/common/trooplist/viewmodel/a;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.homework.common.trooplist.viewmodel.a viewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private final View rootView;

    /* renamed from: G, reason: from kotlin metadata */
    private final QUICheckBox checkBox;

    /* renamed from: H, reason: from kotlin metadata */
    private final QQProAvatarView avatar;

    /* renamed from: I, reason: from kotlin metadata */
    private final TextView content;

    /* renamed from: J, reason: from kotlin metadata */
    private final TextView studentCount;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f296636a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45981);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[TroopItemType.values().length];
            try {
                iArr[TroopItemType.ITEM_TYPE_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TroopItemType.ITEM_TYPE_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f296636a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull View itemView, @NotNull com.tencent.mobileqq.troop.homework.common.trooplist.viewmodel.a viewModel) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView, (Object) viewModel);
            return;
        }
        this.viewModel = viewModel;
        this.rootView = itemView.findViewById(R.id.if5);
        this.checkBox = (QUICheckBox) itemView.findViewById(R.id.awy);
        this.avatar = (QQProAvatarView) itemView.findViewById(R.id.a2o);
        this.content = (TextView) itemView.findViewById(R.id.b_5);
        this.studentCount = (TextView) itemView.findViewById(R.id.f89504zy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(com.tencent.mobileqq.troop.homework.common.trooplist.data.a item, d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (item.e()) {
            item.g(!item.f());
            this$0.checkBox.setChecked(item.f());
            this$0.viewModel.Q1(item);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void m(@NotNull final com.tencent.mobileqq.troop.homework.common.trooplist.data.a item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        int i3 = a.f296636a[item.a().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                QQProAvatarView qQProAvatarView = this.avatar;
                qQProAvatarView.setVisibility(0);
                qQProAvatarView.x(4, item.d(), null);
                if (SimpleUIUtil.getSimpleUISwitch()) {
                    qQProAvatarView.setBackground(null);
                }
                TextView textView = this.studentCount;
                textView.setVisibility(0);
                textView.setText(item.b() + "\u4f4d\u5b66\u751f");
                this.content.setText(item.c());
            }
        } else {
            this.avatar.setVisibility(8);
            this.studentCount.setVisibility(8);
            this.content.setText("\u5168\u90e8");
        }
        QUICheckBox qUICheckBox = this.checkBox;
        qUICheckBox.setChecked(item.f());
        qUICheckBox.setClickable(false);
        qUICheckBox.setEnabled(item.e());
        this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.common.trooplist.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.n(com.tencent.mobileqq.troop.homework.common.trooplist.data.a.this, this, view);
            }
        });
    }
}

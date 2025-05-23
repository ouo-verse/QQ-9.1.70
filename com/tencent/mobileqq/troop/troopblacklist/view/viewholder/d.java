package com.tencent.mobileqq.troop.troopblacklist.view.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.troopblacklist.viewmodel.TroopBlackListViewModel;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\"\u0010#J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/troop/troopblacklist/view/viewholder/d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/troop/troopblacklist/model/c;", "model", "", "isRemoveState", "Lcom/tencent/mobileqq/troop/troopblacklist/viewmodel/TroopBlackListViewModel;", "viewModel", "", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "E", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/image/URLImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/image/URLImageView;", "avatarImageView", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "nickTextView", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "H", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "getCheckBox", "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "setCheckBox", "(Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;)V", "checkBox", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Landroid/content/Context;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private URLImageView avatarImageView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private TextView nickTextView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private QUICheckBox checkBox;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull View itemView, @NotNull Context context) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView, (Object) context);
            return;
        }
        this.context = context;
        View findViewById = itemView.findViewById(R.id.f101465v_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026.troop_black_item_header)");
        this.avatarImageView = (URLImageView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.f101475va);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.troop_black_item_name)");
        this.nickTextView = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.f101455v9);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026oop_black_item_check_box)");
        this.checkBox = (QUICheckBox) findViewById3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(TroopBlackListViewModel viewModel, com.tencent.mobileqq.troop.troopblacklist.model.c model, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(viewModel, "$viewModel");
        Intrinsics.checkNotNullParameter(model, "$model");
        viewModel.m2(model, z16);
        com.tencent.mobileqq.troop.troopblacklist.utils.a.f299464a.b(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(d this$0, TroopBlackListViewModel viewModel, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewModel, "$viewModel");
        if (!this$0.checkBox.isChecked() && viewModel.b2()) {
            Context context = this$0.context;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = context.getString(R.string.f2325474u);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ck_list_reach_select_max)");
            String format = String.format(string, Arrays.copyOf(new Object[]{100}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QQToast.makeText(context, 1, format, 0).show();
        } else {
            this$0.checkBox.setChecked(!r4.isChecked());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void n(@NotNull final com.tencent.mobileqq.troop.troopblacklist.model.c model, boolean isRemoveState, @NotNull final TroopBlackListViewModel viewModel) {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, model, Boolean.valueOf(isRemoveState), viewModel);
            return;
        }
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.nickTextView.setText(model.b());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(appInterface, 1, String.valueOf(model.c()));
        if (faceDrawable != null) {
            this.avatarImageView.setBackground(faceDrawable);
        } else {
            this.avatarImageView.setImageBitmap(BaseImageUtil.getDefaultFaceBitmap());
        }
        if (isRemoveState) {
            this.checkBox.setVisibility(0);
            boolean a26 = viewModel.a2(model.c());
            if (!a26 && viewModel.b2()) {
                z16 = false;
            }
            this.checkBox.setOnCheckedChangeListener(null);
            this.checkBox.setChecked(a26);
            this.checkBox.setEnabled(z16);
            this.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.troopblacklist.view.viewholder.b
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z17) {
                    d.o(TroopBlackListViewModel.this, model, compoundButton, z17);
                }
            });
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopblacklist.view.viewholder.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.p(d.this, viewModel, view);
                }
            });
            return;
        }
        this.checkBox.setVisibility(8);
        this.checkBox.setOnCheckedChangeListener(null);
        this.itemView.setOnClickListener(null);
    }
}

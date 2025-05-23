package com.tencent.mobileqq.troop.livesync.view.trooplist;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u001c\u0010\u000e\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\rR\u0014\u0010 \u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\rR\u0018\u0010#\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/troop/livesync/view/trooplist/TroopLiveSyncListItem;", "Landroid/widget/LinearLayout;", "", "b", "e", "Lcom/tencent/mobileqq/troop/livesync/view/trooplist/c;", DownloadInfo.spKey_Config, "d", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "Landroid/view/View;", "kotlin.jvm.PlatformType", "Landroid/view/View;", "layoutInflater", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "f", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "userHeader", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", h.F, "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "itemCheckBox", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "itemGroupCodeText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "itemGroupNickText", BdhLogUtil.LogTag.Tag_Conn, "itemIdentityOwner", "D", "itemIdentityManager", "E", "Lcom/tencent/mobileqq/troop/livesync/view/trooplist/c;", "mConfig", "<init>", "(Landroid/content/Context;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopLiveSyncListItem extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final View itemIdentityOwner;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View itemIdentityManager;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private c mConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View layoutInflater;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQProAvatarView userHeader;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUICheckBox itemCheckBox;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView itemGroupCodeText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView itemGroupNickText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopLiveSyncListItem(@NotNull Context mContext) {
        super(mContext, null);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mContext);
            return;
        }
        this.mContext = mContext;
        View inflate = View.inflate(getContext(), R.layout.hzx, this);
        this.layoutInflater = inflate;
        View findViewById = inflate.findViewById(R.id.f115276vl);
        Intrinsics.checkNotNullExpressionValue(findViewById, "layoutInflater.findViewById(R.id.user_header)");
        this.userHeader = (QQProAvatarView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.xsv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "layoutInflater.findViewById(R.id.item_check_box)");
        this.itemCheckBox = (QUICheckBox) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.xvb);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "layoutInflater.findViewB\u2026.id.item_group_code_text)");
        this.itemGroupCodeText = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.xve);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "layoutInflater.findViewB\u2026.id.item_group_nick_text)");
        this.itemGroupNickText = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.xvd);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "layoutInflater.findViewB\u2026tem_group_identity_owner)");
        this.itemIdentityOwner = findViewById5;
        View findViewById6 = inflate.findViewById(R.id.xvc);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "layoutInflater.findViewB\u2026m_group_identity_manager)");
        this.itemIdentityManager = findViewById6;
        b();
    }

    private final void b() {
        this.itemCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.livesync.view.trooplist.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopLiveSyncListItem.c(TroopLiveSyncListItem.this, view);
            }
        });
        if (QQTheme.isNowThemeIsNight()) {
            this.layoutInflater.findViewById(R.id.xvd).setBackgroundResource(R.drawable.lwf);
            this.layoutInflater.findViewById(R.id.xvc).setBackgroundResource(R.drawable.lwd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(TroopLiveSyncListItem this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void e() {
        Function2<CompoundButton, c, Unit> L;
        c cVar = this.mConfig;
        if (cVar != null) {
            if (cVar != null) {
                cVar.Q(this.itemCheckBox.isChecked());
            }
            c cVar2 = this.mConfig;
            if (cVar2 != null && (L = cVar2.L()) != null) {
                QUICheckBox qUICheckBox = this.itemCheckBox;
                c cVar3 = this.mConfig;
                Intrinsics.checkNotNull(cVar3);
                L.invoke(qUICheckBox, cVar3);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0041, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(@NotNull c config) {
        long j3;
        int i3;
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) config);
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        this.mConfig = config;
        this.itemCheckBox.setChecked(config.J());
        this.itemCheckBox.setEnabled(config.K());
        this.userHeader.w(4, config.N().getTroopUin());
        String troopUin = config.N().getTroopUin();
        if (troopUin != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        TextView textView = this.itemGroupCodeText;
        String string = this.mContext.getString(R.string.f234727_q);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.str\u2026ive_sync_group_code_text)");
        int i16 = 0;
        String format = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(j3)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        textView.setText(format);
        this.itemGroupNickText.setText(config.N().troopname);
        int i17 = config.M().cmduin_privilege.get();
        View view = this.itemIdentityOwner;
        if (i17 == TroopLiveSyncPrivilegeType.OWNER.getValue()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        View view2 = this.itemIdentityManager;
        if (i17 != TroopLiveSyncPrivilegeType.MANAGER.getValue()) {
            i16 = 8;
        }
        view2.setVisibility(i16);
    }
}

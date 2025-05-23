package com.tencent.mobileqq.guild.setting.qrcode;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.QQToastUtil;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.cd;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0019\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007H\u0002J$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0016J\u0016\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0005R\u0016\u0010\u001f\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010&\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0016\u0010(\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010!R\u0016\u0010+\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/qrcode/GuildQRCodeSettingDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/View$OnClickListener;", "", "initView", "", "choice", "", "isInit", "ph", "Landroid/widget/TextView;", "textView", "isSelected", "sh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onResume", "v", NodeProps.ON_CLICK, "", "guildId", "qrCodePeriod", "rh", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mRootView", "D", "Landroid/widget/TextView;", "m24HoursValidTime", "E", "m7DaysValidTime", UserInfo.SEX_FEMALE, "m30DaysValidTime", "G", "mPermanentValidTime", "H", "Ljava/lang/String;", "mGuildId", "I", "mQrCodePeriod", "<init>", "()V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildQRCodeSettingDialog extends BottomSheetDialogFragment implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView m24HoursValidTime;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView m7DaysValidTime;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView m30DaysValidTime;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView mPermanentValidTime;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String mGuildId = "";

    /* renamed from: I, reason: from kotlin metadata */
    private int mQrCodePeriod;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/setting/qrcode/GuildQRCodeSettingDialog$b", "Lvh2/cd;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "security", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements cd {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f234879b;

        b(int i3) {
            this.f234879b = i3;
        }

        @Override // vh2.cd
        public void a(int result, @Nullable String errMsg, @Nullable IGProSecurityResult security) {
            if (!GuildQRCodeSettingDialog.this.isVisible()) {
                Logger.f235387a.d().i("Guild.share.GuildQRCodeSettingDialog", 1, "setGuildQRCodePeriod onResult dialog dismiss");
                return;
            }
            if (result == 0 && ch.p(security)) {
                Logger logger = Logger.f235387a;
                int i3 = this.f234879b;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.share.GuildQRCodeSettingDialog", 2, "setGuildQRCodePeriod QRCodePeriod:" + i3 + " success");
                    return;
                }
                return;
            }
            QQToastUtil.showQQToast(1, R.string.f155831ik);
            Logger logger2 = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "setGuildQRCodePeriod errMsg:" + errMsg + " security:" + security;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.share.GuildQRCodeSettingDialog", 1, (String) it.next(), null);
            }
        }
    }

    private final void initView() {
        View view = this.mRootView;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.f116276ya);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.valid_time_24_hours)");
        this.m24HoursValidTime = (TextView) findViewById;
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.f116296yc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.valid_time_7_days)");
        this.m7DaysValidTime = (TextView) findViewById2;
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.f116286yb);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.valid_time_30_days)");
        this.m30DaysValidTime = (TextView) findViewById3;
        View view4 = this.mRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.f116306yd);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.valid_time_permanent)");
        this.mPermanentValidTime = (TextView) findViewById4;
        TextView textView2 = this.m24HoursValidTime;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("m24HoursValidTime");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        TextView textView3 = this.m7DaysValidTime;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("m7DaysValidTime");
            textView3 = null;
        }
        textView3.setOnClickListener(this);
        TextView textView4 = this.m30DaysValidTime;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("m30DaysValidTime");
            textView4 = null;
        }
        textView4.setOnClickListener(this);
        TextView textView5 = this.mPermanentValidTime;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPermanentValidTime");
        } else {
            textView = textView5;
        }
        textView.setOnClickListener(this);
        ph(this.mQrCodePeriod, true);
    }

    private final void ph(int choice, boolean isInit) {
        boolean z16;
        boolean z17;
        boolean z18;
        TextView textView = this.m24HoursValidTime;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("m24HoursValidTime");
            textView = null;
        }
        boolean z19 = false;
        if (choice == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        sh(textView, z16);
        TextView textView3 = this.m7DaysValidTime;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("m7DaysValidTime");
            textView3 = null;
        }
        if (choice == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        sh(textView3, z17);
        TextView textView4 = this.m30DaysValidTime;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("m30DaysValidTime");
            textView4 = null;
        }
        if (choice == 2) {
            z18 = true;
        } else {
            z18 = false;
        }
        sh(textView4, z18);
        TextView textView5 = this.mPermanentValidTime;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPermanentValidTime");
        } else {
            textView2 = textView5;
        }
        if (choice == 3) {
            z19 = true;
        }
        sh(textView2, z19);
        if (isInit) {
            return;
        }
        ((IGPSService) ch.R0(IGPSService.class)).setGuildQRCodePeriod(this.mGuildId, choice, new b(choice));
    }

    static /* synthetic */ void qh(GuildQRCodeSettingDialog guildQRCodeSettingDialog, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        guildQRCodeSettingDialog.ph(i3, z16);
    }

    private final void sh(TextView textView, boolean isSelected) {
        if (isSelected) {
            textView.setBackgroundResource(R.drawable.guild_button_blue_border_bg);
            textView.setTextColor(Color.parseColor("#0099FF"));
        } else {
            textView.setBackgroundResource(R.drawable.guild_button_gray_border_bg);
            textView.setTextColor(getResources().getColor(R.color.guild_skin_me_black_text_bg));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        TextView textView = this.m24HoursValidTime;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("m24HoursValidTime");
            textView = null;
        }
        if (Intrinsics.areEqual(v3, textView)) {
            qh(this, 1, false, 2, null);
        } else {
            TextView textView2 = this.m7DaysValidTime;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("m7DaysValidTime");
                textView2 = null;
            }
            if (Intrinsics.areEqual(v3, textView2)) {
                qh(this, 0, false, 2, null);
            } else {
                TextView textView3 = this.m30DaysValidTime;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("m30DaysValidTime");
                    textView3 = null;
                }
                if (Intrinsics.areEqual(v3, textView3)) {
                    qh(this, 2, false, 2, null);
                } else {
                    TextView textView4 = this.mPermanentValidTime;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPermanentValidTime");
                        textView4 = null;
                    }
                    if (Intrinsics.areEqual(v3, textView4)) {
                        qh(this, 3, false, 2, null);
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f168153f33, container);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026etting_dialog, container)");
        this.mRootView = inflate;
        initView();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setBackgroundColor(0);
    }

    public final void rh(@NotNull String guildId, int qrCodePeriod) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.mGuildId = guildId;
        this.mQrCodePeriod = qrCodePeriod;
    }
}

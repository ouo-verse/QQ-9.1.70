package com.tencent.mobileqq.guild.media.game.widget;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.notify.SwitchThemeEvent;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0002./B\u0017\u0012\u0006\u0010)\u001a\u00020#\u0012\u0006\u0010*\u001a\u00020\t\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u001d\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/widget/GuildTeamAuthDialog;", "Lcom/tencent/mobileqq/guild/media/game/widget/BaseBottomDialog;", "Landroid/view/View$OnClickListener;", "", "initListener", "yh", OcrConfig.CHINESE, "xh", "wh", "", "qh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "v", NodeProps.ON_CLICK, "Landroid/content/DialogInterface;", "dialog", "onDismiss", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mCancelView", "G", "mOnceConfirmView", "H", "mPermanentView", "I", "mIKnowBtn", "Landroid/widget/LinearLayout;", "J", "Landroid/widget/LinearLayout;", "mAuthBtnLl", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildTeamAuthDialog$b;", "K", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildTeamAuthDialog$b;", "mCallback", "L", HttpMsg.MTYPE, "callBack", "type", "<init>", "(Lcom/tencent/mobileqq/guild/media/game/widget/GuildTeamAuthDialog$b;I)V", "M", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildTeamAuthDialog extends BaseBottomDialog implements View.OnClickListener {

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mCancelView;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView mOnceConfirmView;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mPermanentView;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView mIKnowBtn;

    /* renamed from: J, reason: from kotlin metadata */
    private LinearLayout mAuthBtnLl;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final b mCallback;

    /* renamed from: L, reason: from kotlin metadata */
    private final int mType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/widget/GuildTeamAuthDialog$b;", "", "", "e", "b", "d", "c", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/GuildTeamAuthDialog$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ar;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.core.notify.o<SwitchThemeEvent> {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull SwitchThemeEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getNewThemeType() != 2) {
                GuildTeamAuthDialog.this.dismissAllowingStateLoss();
            }
        }
    }

    public GuildTeamAuthDialog(@NotNull b callBack, int i3) {
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        this.mCallback = callBack;
        this.mType = i3;
    }

    private final void initListener() {
        TextView textView = this.mCancelView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCancelView");
            textView = null;
        }
        textView.setOnClickListener(this);
        TextView textView3 = this.mOnceConfirmView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOnceConfirmView");
            textView3 = null;
        }
        textView3.setOnClickListener(this);
        TextView textView4 = this.mPermanentView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPermanentView");
            textView4 = null;
        }
        textView4.setOnClickListener(this);
        TextView textView5 = this.mIKnowBtn;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIKnowBtn");
        } else {
            textView2 = textView5;
        }
        textView2.setOnClickListener(this);
        com.tencent.mobileqq.guild.media.core.notify.p d16 = com.tencent.mobileqq.guild.media.core.j.d();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "this.viewLifecycleOwner");
        d16.k0(viewLifecycleOwner, SwitchThemeEvent.class, new c());
    }

    private final void wh() {
        this.mCallback.c();
        dismissAllowingStateLoss();
    }

    private final void xh() {
        this.mCallback.d();
    }

    private final void yh() {
        bw.w1("AUTH_ONLY_ONCE");
        this.mCallback.e();
    }

    private final void zh() {
        this.mCallback.b();
        bw.w1("AUTH_PERMANENT");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        int id5 = v3.getId();
        if (id5 == R.id.f165634x22) {
            yh();
        } else if (id5 == R.id.f165635x23) {
            zh();
        } else if (id5 == R.id.f165632x20) {
            xh();
        } else if (id5 == R.id.f165637x25) {
            wh();
        }
        dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        this.mCallback.a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = getRootView().findViewById(R.id.f165632x20);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.guild_team_auth_cancel)");
        this.mCancelView = (TextView) findViewById;
        View findViewById2 = getRootView().findViewById(R.id.f165634x22);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026d_team_auth_once_confirm)");
        this.mOnceConfirmView = (TextView) findViewById2;
        View findViewById3 = getRootView().findViewById(R.id.f165635x23);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026m_auth_permanent_confirm)");
        this.mPermanentView = (TextView) findViewById3;
        View findViewById4 = getRootView().findViewById(R.id.f165637x25);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.guild_team_i_know)");
        this.mIKnowBtn = (TextView) findViewById4;
        View findViewById5 = getRootView().findViewById(R.id.x1z);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026am_auth_button_container)");
        LinearLayout linearLayout = (LinearLayout) findViewById5;
        this.mAuthBtnLl = linearLayout;
        TextView textView = null;
        if (this.mType == 1) {
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAuthBtnLl");
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
        } else {
            TextView textView2 = this.mIKnowBtn;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIKnowBtn");
                textView2 = null;
            }
            textView2.setVisibility(0);
            TextView textView3 = this.mCancelView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCancelView");
            } else {
                textView = textView3;
            }
            textView.setVisibility(8);
        }
        initListener();
    }

    @Override // com.tencent.mobileqq.guild.media.game.widget.BaseBottomDialog
    public int qh() {
        return R.layout.esm;
    }
}

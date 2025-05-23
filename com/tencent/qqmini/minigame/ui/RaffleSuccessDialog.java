package com.tencent.qqmini.minigame.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;

/* compiled from: P */
/* loaded from: classes23.dex */
public class RaffleSuccessDialog extends ReportDialog {
    private static final long CHANGE_AFTER_RECEIVE_DELAY = 2000;
    private Drawable afterReceiveDrawable;
    private RelativeLayout afterReceiveLayout;
    private Context context;
    private Drawable goBackMainButtonDrawable;
    private boolean isHorizontal;
    private Drawable logoDrawable;
    private RaffleJsPlugin.OnRaffleSuccessListener onRaffleSuccessListener;
    private Drawable prizeDrawable;
    private RelativeLayout prizeLayout;
    private Button receiveButton;
    private Drawable wishingDrawable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (RaffleSuccessDialog.this.onRaffleSuccessListener != null) {
                RaffleSuccessDialog.this.onRaffleSuccessListener.onCloseCancel();
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (RaffleSuccessDialog.this.onRaffleSuccessListener != null) {
                RaffleSuccessDialog.this.onRaffleSuccessListener.onCloseCertain();
            }
            dialogInterface.dismiss();
            RaffleSuccessDialog.this.dismiss();
        }
    }

    public RaffleSuccessDialog(Context context, boolean z16, RaffleJsPlugin.OnRaffleSuccessListener onRaffleSuccessListener) {
        super(context);
        this.context = context;
        this.isHorizontal = z16;
        this.onRaffleSuccessListener = onRaffleSuccessListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeAfterReceive() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.ui.RaffleSuccessDialog.6
            @Override // java.lang.Runnable
            public void run() {
                if (RaffleSuccessDialog.this.prizeLayout != null) {
                    RaffleSuccessDialog.this.prizeLayout.setVisibility(4);
                }
                if (RaffleSuccessDialog.this.afterReceiveLayout != null) {
                    RaffleSuccessDialog.this.afterReceiveLayout.setVisibility(0);
                }
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forbidReceiveClick() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.ui.RaffleSuccessDialog.5
            @Override // java.lang.Runnable
            public void run() {
                if (RaffleSuccessDialog.this.receiveButton != null) {
                    RaffleSuccessDialog.this.receiveButton.setClickable(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeClickTemporary(final ImageView imageView) {
        Runnable runnable = new Runnable() { // from class: com.tencent.qqmini.minigame.ui.RaffleSuccessDialog.7
            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView2 = imageView;
                if (imageView2 != null) {
                    imageView2.setClickable(true);
                }
            }
        };
        imageView.setClickable(false);
        ThreadManager.getUIHandler().postDelayed(runnable, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHintDialog() {
        a aVar = new a();
        b bVar = new b();
        Context context = this.context;
        DialogUtil.createCloseAlertDialog(context, R.style.mini_sdk_MiniAppCloseDialog, context.getString(R.string.mini_sdk_game_raffle_success_close_hint), this.context.getString(R.string.mini_sdk_game_raffle_success_close_left_btn), this.context.getString(R.string.mini_sdk_game_raffle_success_close_right_btn), 100.0f, true, false, true, aVar, bVar).show();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        View inflate;
        super.onCreate(bundle);
        if (this.isHorizontal) {
            inflate = LayoutInflater.from(this.context).inflate(R.layout.mini_sdk_raffle_success_dialog_landscape, (ViewGroup) null);
        } else {
            inflate = LayoutInflater.from(this.context).inflate(R.layout.mini_sdk_raffle_success_dialog, (ViewGroup) null);
        }
        setCancelable(false);
        if (getWindow() != null) {
            getWindow().requestFeature(1);
            getWindow().setBackgroundDrawableResource(17170445);
        }
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.mini_sdk_raffle_success_prize_layout);
        this.prizeLayout = relativeLayout;
        relativeLayout.setVisibility(0);
        ((ImageView) inflate.findViewById(R.id.mini_sdk_raffle_success_logo_image)).setImageDrawable(this.logoDrawable);
        ((ImageView) inflate.findViewById(R.id.mini_sdk_raffle_success_wishing_image)).setImageDrawable(this.wishingDrawable);
        ((ImageView) inflate.findViewById(R.id.mini_sdk_raffle_success_prize_image)).setImageDrawable(this.prizeDrawable);
        Button button = (Button) inflate.findViewById(R.id.mini_sdk_raffle_success_receive_button);
        this.receiveButton = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.minigame.ui.RaffleSuccessDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (RaffleSuccessDialog.this.onRaffleSuccessListener != null && RaffleSuccessDialog.this.onRaffleSuccessListener.onReceive()) {
                    RaffleSuccessDialog.this.forbidReceiveClick();
                    RaffleSuccessDialog.this.changeAfterReceive();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        final ImageView imageView = (ImageView) inflate.findViewById(R.id.mini_sdk_raffle_success_close_button);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.minigame.ui.RaffleSuccessDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (RaffleSuccessDialog.this.onRaffleSuccessListener != null) {
                    RaffleSuccessDialog.this.onRaffleSuccessListener.onClose();
                }
                RaffleSuccessDialog.this.removeClickTemporary(imageView);
                RaffleSuccessDialog.this.showHintDialog();
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        RelativeLayout relativeLayout2 = (RelativeLayout) inflate.findViewById(R.id.mini_sdk_raffle_success_after_receive_layout);
        this.afterReceiveLayout = relativeLayout2;
        relativeLayout2.setVisibility(4);
        ((ImageView) inflate.findViewById(R.id.mini_sdk_raffle_success_after_receive_image)).setImageDrawable(this.afterReceiveDrawable);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.mini_sdk_raffle_success_go_back_main_image);
        imageView2.setImageDrawable(this.goBackMainButtonDrawable);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.minigame.ui.RaffleSuccessDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                RaffleSuccessDialog.this.dismiss();
                if (RaffleSuccessDialog.this.onRaffleSuccessListener != null) {
                    RaffleSuccessDialog.this.onRaffleSuccessListener.onGoBackMain();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        ((TextView) inflate.findViewById(R.id.mini_sdk_raffle_success_again_text)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.minigame.ui.RaffleSuccessDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                RaffleSuccessDialog.this.dismiss();
                if (RaffleSuccessDialog.this.onRaffleSuccessListener != null) {
                    RaffleSuccessDialog.this.onRaffleSuccessListener.onAgain();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        setContentView(inflate, new ViewGroup.LayoutParams(-1, -1));
    }

    public boolean setDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5) {
        if (drawable3 != null && drawable4 != null) {
            this.logoDrawable = drawable;
            this.wishingDrawable = drawable2;
            this.prizeDrawable = drawable3;
            this.afterReceiveDrawable = drawable4;
            this.goBackMainButtonDrawable = drawable5;
            return true;
        }
        return false;
    }
}

package com.tencent.qqmini.minigame.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;

/* compiled from: P */
/* loaded from: classes23.dex */
public class RaffleFailDialog extends ReportDialog {
    private boolean canShare;
    private boolean canWatchAd;
    private ImageView commonImageView;
    private Context context;
    private Drawable failDrawable;
    private ImageView firstImageView;
    private boolean isHorizontal;
    private RaffleJsPlugin.OnRaffleFailListener onRaffleFailListener;
    private ImageView secondImageView;
    private Drawable shareButtonDrawable;
    private Drawable watchAdButtonDrawable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f346767d;

        a(ImageView imageView) {
            this.f346767d = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RaffleFailDialog.this.removeClickTemporary(this.f346767d);
            if (RaffleFailDialog.this.onRaffleFailListener != null) {
                RaffleFailDialog.this.onRaffleFailListener.onWatchAd();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public RaffleFailDialog(Context context, boolean z16, RaffleJsPlugin.OnRaffleFailListener onRaffleFailListener) {
        super(context);
        this.canShare = false;
        this.canWatchAd = false;
        this.context = context;
        this.isHorizontal = z16;
        this.onRaffleFailListener = onRaffleFailListener;
    }

    private void initButton() {
        boolean z16 = this.canShare;
        if (z16 && this.canWatchAd) {
            this.commonImageView.setVisibility(8);
            this.firstImageView.setVisibility(0);
            this.secondImageView.setVisibility(0);
            this.firstImageView.setImageDrawable(this.shareButtonDrawable);
            this.secondImageView.setImageDrawable(this.watchAdButtonDrawable);
            setShareEvent(this.firstImageView);
            setWatchAdEvent(this.secondImageView);
            return;
        }
        if (z16) {
            this.commonImageView.setVisibility(0);
            this.firstImageView.setVisibility(8);
            this.secondImageView.setVisibility(8);
            this.commonImageView.setImageDrawable(this.shareButtonDrawable);
            setShareEvent(this.commonImageView);
            return;
        }
        if (this.canWatchAd) {
            this.commonImageView.setVisibility(0);
            this.firstImageView.setVisibility(8);
            this.secondImageView.setVisibility(8);
            this.commonImageView.setImageDrawable(this.watchAdButtonDrawable);
            setWatchAdEvent(this.commonImageView);
            return;
        }
        this.commonImageView.setVisibility(4);
        this.firstImageView.setVisibility(8);
        this.secondImageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeClickTemporary(final ImageView imageView) {
        Runnable runnable = new Runnable() { // from class: com.tencent.qqmini.minigame.ui.RaffleFailDialog.5
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

    private void setShareEvent(final ImageView imageView) {
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.minigame.ui.RaffleFailDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                RaffleFailDialog.this.removeClickTemporary(imageView);
                if (RaffleFailDialog.this.onRaffleFailListener != null) {
                    RaffleFailDialog.this.onRaffleFailListener.onShare();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    private void setWatchAdEvent(ImageView imageView) {
        imageView.setOnClickListener(new a(imageView));
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        View inflate;
        super.onCreate(bundle);
        if (this.isHorizontal) {
            inflate = LayoutInflater.from(this.context).inflate(R.layout.mini_sdk_raffle_fail_dialog_landscape, (ViewGroup) null);
        } else {
            inflate = LayoutInflater.from(this.context).inflate(R.layout.mini_sdk_raffle_fail_dialog, (ViewGroup) null);
        }
        setCancelable(false);
        if (getWindow() != null) {
            getWindow().requestFeature(1);
            getWindow().setBackgroundDrawableResource(17170445);
        }
        ((ImageView) inflate.findViewById(R.id.mini_sdk_raffle_fail_image)).setImageDrawable(this.failDrawable);
        this.commonImageView = (ImageView) inflate.findViewById(R.id.mini_sdk_raffle_fail_common_button_image);
        this.firstImageView = (ImageView) inflate.findViewById(R.id.mini_sdk_raffle_fail_fisrt_button_image);
        this.secondImageView = (ImageView) inflate.findViewById(R.id.mini_sdk_raffle_fail_second_button_image);
        final TextView textView = (TextView) inflate.findViewById(R.id.mini_sdk_raffle_fail_again_text);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.minigame.ui.RaffleFailDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                textView.setClickable(false);
                if (RaffleFailDialog.this.onRaffleFailListener != null) {
                    RaffleFailDialog.this.onRaffleFailListener.onAgain();
                }
                RaffleFailDialog.this.dismiss();
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        final ImageView imageView = (ImageView) inflate.findViewById(R.id.mini_sdk_raffle_fail_close_button);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.minigame.ui.RaffleFailDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                imageView.setClickable(false);
                if (RaffleFailDialog.this.onRaffleFailListener != null) {
                    RaffleFailDialog.this.onRaffleFailListener.onClose();
                }
                RaffleFailDialog.this.dismiss();
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        initButton();
        setContentView(inflate, new ViewGroup.LayoutParams(-1, -1));
    }

    public void setCanShare(boolean z16) {
        this.canShare = z16;
    }

    public void setCanWatchAd(boolean z16) {
        this.canWatchAd = z16;
    }

    public boolean setDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3) {
        if (drawable == null) {
            return false;
        }
        this.failDrawable = drawable;
        this.shareButtonDrawable = drawable2;
        this.watchAdButtonDrawable = drawable3;
        return true;
    }
}

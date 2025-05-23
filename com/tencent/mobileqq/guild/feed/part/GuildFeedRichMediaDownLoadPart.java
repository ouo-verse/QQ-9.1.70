package com.tencent.mobileqq.guild.feed.part;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.widget.GuildFeedProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.richframework.thread.RFWThreadManager;

/* loaded from: classes13.dex */
public class GuildFeedRichMediaDownLoadPart extends d {

    /* renamed from: d, reason: collision with root package name */
    private Dialog f222464d;

    /* renamed from: e, reason: collision with root package name */
    private GuildFeedProgress f222465e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f222466f;

    /* renamed from: h, reason: collision with root package name */
    private Context f222467h;

    /* JADX INFO: Access modifiers changed from: private */
    public void B9(boolean z16) {
        String string;
        int i3 = 2;
        QLog.d("GuildFeedRichMediaDownLoadPart", 2, "[downLoadResult] success: ", Boolean.valueOf(z16));
        Dialog dialog = this.f222464d;
        if (dialog != null && dialog.isShowing()) {
            if (z16) {
                C9(100);
            }
            try {
                this.f222464d.dismiss();
            } catch (IllegalArgumentException e16) {
                e16.printStackTrace();
            }
            if (!z16) {
                i3 = 1;
            }
            if (z16) {
                string = getContext().getResources().getString(R.string.f143990nk);
            } else {
                string = getContext().getResources().getString(R.string.f143980nj);
            }
            QQToast.makeText(getContext(), i3, string, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C9(int i3) {
        GuildFeedProgress guildFeedProgress = this.f222465e;
        if (guildFeedProgress != null) {
            guildFeedProgress.setProgress(i3);
        }
        TextView textView = this.f222466f;
        if (textView != null) {
            textView.setText(i3 + "%");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D9() {
        if (this.f222464d == null) {
            ReportDialog reportDialog = new ReportDialog(getContext(), R.style.f173523f9);
            this.f222464d = reportDialog;
            reportDialog.setCanceledOnTouchOutside(true);
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.eqh, (ViewGroup) null);
            GuildFeedProgress guildFeedProgress = (GuildFeedProgress) inflate.findViewById(R.id.w7d);
            this.f222465e = guildFeedProgress;
            guildFeedProgress.setStrokeWidth(4.0f);
            this.f222465e.setBgAndProgressColor(20, Color.parseColor(TipsElementData.DEFAULT_COLOR), 90, Color.parseColor(TipsElementData.DEFAULT_COLOR));
            this.f222466f = (TextView) inflate.findViewById(R.id.w7c);
            this.f222464d.setContentView(inflate);
            this.f222464d.setCancelable(false);
        }
        this.f222466f.setText("0%");
        this.f222465e.setProgress(0.0f);
        if (!this.f222464d.isShowing()) {
            try {
                this.f222464d.show();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Context getContext() {
        Context context = this.f222467h;
        if (context == null) {
            return super.getContext();
        }
        return context;
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "GuildFeedRichMediaDownLoadPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(final String str, final Object obj) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.GuildFeedRichMediaDownLoadPart.1
            @Override // java.lang.Runnable
            public void run() {
                if ("rich_media_download_show".equals(str)) {
                    GuildFeedRichMediaDownLoadPart.this.D9();
                    return;
                }
                if ("rich_media_download_status".equals(str)) {
                    Object obj2 = obj;
                    if (obj2 instanceof Boolean) {
                        GuildFeedRichMediaDownLoadPart.this.B9(((Boolean) obj2).booleanValue());
                        return;
                    }
                    return;
                }
                if ("rich_meida_download_progress".equals(str)) {
                    Object obj3 = obj;
                    if (obj3 instanceof Integer) {
                        GuildFeedRichMediaDownLoadPart.this.C9(((Integer) obj3).intValue());
                    }
                }
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        Dialog dialog = this.f222464d;
        if (dialog != null && dialog.isShowing()) {
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
    }
}

package com.tencent.mobileqq.guild.feed.publish.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildUploadHelper;
import com.tencent.mobileqq.guild.feed.publish.event.GuildCancelTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildSaveDraftTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.util.GuildFeedReportHelper;
import com.tencent.mobileqq.guild.feed.util.ak;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes13.dex */
public class e extends com.tencent.mobileqq.guild.feed.widget.a implements View.OnClickListener {
    private String C;
    private boolean D;
    private String E;
    private Context F;

    public e(@NonNull Context context, String str, boolean z16, boolean z17, String str2) {
        super(context);
        this.D = z16;
        this.C = str;
        this.E = str2;
        this.F = context;
        Q(z17);
        setCanceledOnTouchOutside(true);
    }

    private static void O(final GuildSaveDraftTaskOperationEvent guildSaveDraftTaskOperationEvent) {
        if (guildSaveDraftTaskOperationEvent.isOverIpcThresholdLength()) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild_Feed_", 1, "[dispatchSaveDraftEvent] save draft via file, mainTaskId=" + guildSaveDraftTaskOperationEvent.getMainTaskId());
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.widget.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.R(GuildSaveDraftTaskOperationEvent.this);
                }
            }, 64, null, false);
            return;
        }
        bl.c().b(guildSaveDraftTaskOperationEvent, true);
    }

    private void P() {
        dismiss();
        Context context = this.F;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    private void Q(boolean z16) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168084eq1, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.kbs);
        inflate.findViewById(R.id.f110876jp).setOnClickListener(this);
        inflate.findViewById(R.id.f109576g7).setOnClickListener(this);
        inflate.findViewById(R.id.f167033k60).setOnClickListener(this);
        if (z16) {
            textView.setText(((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getString(R.string.f144420oq));
        } else {
            ak.j();
        }
        setContentView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R(GuildSaveDraftTaskOperationEvent guildSaveDraftTaskOperationEvent) {
        guildSaveDraftTaskOperationEvent.saveInFile();
        bl.c().b(guildSaveDraftTaskOperationEvent, true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick(view)) {
            if (view.getId() == R.id.f167033k60) {
                dismiss();
                if (this.D) {
                    ak.c();
                } else {
                    ak.d();
                }
            } else if (view.getId() == R.id.f110876jp) {
                GuildSaveDraftTaskOperationEvent guildSaveDraftTaskOperationEvent = new GuildSaveDraftTaskOperationEvent(String.valueOf(System.currentTimeMillis()));
                guildSaveDraftTaskOperationEvent.setMainTaskId(GuildUploadHelper.i().h());
                guildSaveDraftTaskOperationEvent.setFeedJson(this.C);
                guildSaveDraftTaskOperationEvent.setFeedPublishJson(this.C);
                O(guildSaveDraftTaskOperationEvent);
                P();
                GuildFeedReportHelper.i().v();
                com.tencent.mobileqq.guild.feed.nativepublish.draft.a.d(this.E, false, "", "");
            } else if (view.getId() == R.id.f109576g7) {
                GuildCancelTaskOperationEvent guildCancelTaskOperationEvent = new GuildCancelTaskOperationEvent(2, GuildUploadHelper.i().h(), false);
                guildCancelTaskOperationEvent.setActionType(GuildCancelTaskOperationEvent.ACTION_TYPE_USER_OPERATION);
                guildCancelTaskOperationEvent.setReportCancelType(1);
                bl.c().b(guildCancelTaskOperationEvent, true);
                P();
                ak.h();
                GuildFeedReportHelper.i().u();
                com.tencent.mobileqq.guild.feed.nativepublish.draft.a.c(this.E, false, "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}

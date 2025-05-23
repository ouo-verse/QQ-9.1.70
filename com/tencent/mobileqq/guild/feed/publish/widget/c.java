package com.tencent.mobileqq.guild.feed.publish.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildUploadHelper;
import com.tencent.mobileqq.guild.feed.publish.event.GuildCancelTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildDraftH5AutoRestoreEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildDraftNativeAutoRestoreEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildDraftTaskResponseEvent;
import com.tencent.mobileqq.guild.feed.util.ak;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes13.dex */
public class c extends com.tencent.mobileqq.guild.feed.widget.a implements View.OnClickListener {
    public GuildDraftTaskResponseEvent C;
    private String D;

    public c(@NonNull Context context, GuildDraftTaskResponseEvent guildDraftTaskResponseEvent, String str) {
        super(context);
        initView();
        this.C = guildDraftTaskResponseEvent;
        this.D = str;
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168083eq0, (ViewGroup) null);
        inflate.findViewById(R.id.f112646oh).setOnClickListener(this);
        inflate.findViewById(R.id.f167033k60).setOnClickListener(this);
        setContentView(inflate);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick(view)) {
            if (view.getId() == R.id.f167033k60) {
                GuildUploadHelper.i().r();
                bl.c().a(new GuildDraftH5AutoRestoreEvent(null));
                dismiss();
                ak.g();
                GuildCancelTaskOperationEvent guildCancelTaskOperationEvent = new GuildCancelTaskOperationEvent(2, this.C.getMainTaskId(), false);
                guildCancelTaskOperationEvent.setActionType(GuildCancelTaskOperationEvent.ACTION_TYPE_USER_OPERATION);
                bl.c().b(guildCancelTaskOperationEvent, true);
            } else if (view.getId() == R.id.f112646oh) {
                GuildUploadHelper.i().s(this.C.getMainTaskId());
                bl.c().a(new GuildDraftH5AutoRestoreEvent(this.C.getFeedJson()));
                bl.c().b(new GuildDraftNativeAutoRestoreEvent(this.C.getMainTaskId()), true);
                com.tencent.mobileqq.guild.feed.nativepublish.draft.a.b(this.D, false, "", "");
                dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}

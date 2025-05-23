package com.tencent.mobileqq.guild.feed.part;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.event.GuildFeedGalleryShareViewEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.Serializable;
import java.util.HashMap;
import oj1.OnMoreIconMessage;

/* compiled from: P */
/* loaded from: classes13.dex */
public class m extends d implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private ImageButton f222570d;

    /* renamed from: e, reason: collision with root package name */
    private GuildFeedGalleryInitBean f222571e;

    private void initPageBean() {
        Intent intent;
        if (getActivity() != null && (intent = getActivity().getIntent()) != null && intent.hasExtra(com.tencent.mobileqq.guild.feed.b.f218115a)) {
            Serializable serializableExtra = intent.getSerializableExtra(com.tencent.mobileqq.guild.feed.b.f218115a);
            if (!(serializableExtra instanceof GuildFeedGalleryInitBean)) {
                return;
            }
            this.f222571e = (GuildFeedGalleryInitBean) serializableExtra;
        }
    }

    private void x9() {
        Object broadcastGetMessage = broadcastGetMessage("ACTION_GET_CURRENT_GALLERY_DATA", null);
        if ((broadcastGetMessage instanceof GuildFeedRichMediaData) && this.f222571e != null) {
            GuildFeedGalleryShareViewEvent guildFeedGalleryShareViewEvent = new GuildFeedGalleryShareViewEvent();
            guildFeedGalleryShareViewEvent.setSource(GuildSharePageSource.FEED_LIST);
            com.tencent.mobileqq.guild.feed.share.c cVar = new com.tencent.mobileqq.guild.feed.share.c();
            cVar.k(getContext().hashCode());
            cVar.o((GuildFeedRichMediaData) broadcastGetMessage);
            cVar.l(this.f222571e.getFeed());
            cVar.n(this.f222571e.getGuildId());
            cVar.j(this.f222571e.getChannelId());
            cVar.q(this.f222571e.getPosterId());
            cVar.m(this.f222571e.getFromPage());
            guildFeedGalleryShareViewEvent.setGalleryShareInfo(cVar);
            guildFeedGalleryShareViewEvent.setGalleryInitBean(this.f222571e);
            SimpleEventBus.getInstance().dispatchEvent(guildFeedGalleryShareViewEvent);
        }
    }

    private void z9(View view) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, "em_sgrp_forum_viewer_more");
        VideoReport.setElementParams(view, new HashMap());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        int i3;
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals(str, "message_page_more_icon") && (obj instanceof OnMoreIconMessage)) {
            boolean show = ((OnMoreIconMessage) obj).getShow();
            if (show && this.f222570d.getVisibility() != 0) {
                ImageButton imageButton = this.f222570d;
                if (this.f222571e.isShowMoreIcon()) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                imageButton.setVisibility(i3);
            }
            if (!show && this.f222570d.getVisibility() == 0) {
                this.f222570d.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        this.f222570d.setVisibility(8);
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!FastClickUtils.isFastDoubleClick("GuildFeedGalleryMorePar") && view.getId() == R.id.wkl) {
            x9();
            z9(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.wkl);
        this.f222570d = imageButton;
        imageButton.setOnClickListener(this);
        initPageBean();
        if (this.f222571e.isShowMoreIcon()) {
            this.f222570d.setVisibility(0);
        } else {
            this.f222570d.setVisibility(8);
        }
    }
}

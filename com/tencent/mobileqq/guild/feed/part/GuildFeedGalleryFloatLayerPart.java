package com.tencent.mobileqq.guild.feed.part;

import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.event.GuildFeedGalleryFloatLayerIconEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.video.GuildExchangeUrlManger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes13.dex */
public class GuildFeedGalleryFloatLayerPart extends d implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private ImageButton f222432d;

    /* renamed from: e, reason: collision with root package name */
    private GuildFeedGalleryInitBean f222433e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class a implements GuildExchangeUrlManger.b {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.video.GuildExchangeUrlManger.b
        public void a(long j3, String str) {
            QLog.e("GuildFeedGalleryMorePar", 1, "exchangeVideoUrl error!, errorCode: " + j3 + ", msg: " + str);
        }

        @Override // com.tencent.mobileqq.guild.feed.video.GuildExchangeUrlManger.b
        public void b(GProStVideo gProStVideo, boolean z16) {
            GuildFeedGalleryFloatLayerPart.this.G9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A9() {
        String str;
        GProStVideo C9 = C9();
        if (C9 != null) {
            str = C9.fileId;
        } else {
            str = "emptyFileId";
        }
        Object tag = this.f222432d.getTag();
        if (str.equals(tag)) {
            this.f222432d.setVisibility(0);
            if (QLog.isColorLevel()) {
                QLog.d("GuildFeedGalleryMorePar", 1, "showFloatBtnWhileExchangeSuccess " + str);
                return;
            }
            return;
        }
        QLog.e("GuildFeedGalleryMorePar", 1, "showFloatBtn error! curFileId: " + str + ", viewTag: " + tag);
    }

    private void B9(View view) {
        VideoReport.setElementId(view, "em_sgrp_forum_video_mini_window");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        VideoReport.setElementParams(view, hashMap);
    }

    private GProStVideo C9() {
        Object broadcastGetMessage = broadcastGetMessage("ACTION_GET_CURRENT_GALLERY_DATA", null);
        if (!(broadcastGetMessage instanceof GuildFeedRichMediaData)) {
            QLog.e("GuildFeedGalleryMorePar", 1, "exchangeVideoUrl currData error! " + broadcastGetMessage);
            return null;
        }
        return ((GuildFeedRichMediaData) broadcastGetMessage).getVideo();
    }

    private GProStVideo D9() {
        boolean z16;
        GProStVideo C9 = C9();
        if (C9 == null) {
            return null;
        }
        if (!GuildExchangeUrlManger.f().b(C9) && GuildExchangeUrlManger.f().c(C9)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildFeedGalleryMorePar", 1, "getNeedExchangeVideo, needExchange: " + z16 + ", fileId: " + C9.fileId);
        }
        if (!z16) {
            return null;
        }
        return C9;
    }

    private void E9() {
        Object broadcastGetMessage = broadcastGetMessage("ACTION_GET_CURRENT_GALLERY_DATA", null);
        if ((broadcastGetMessage instanceof GuildFeedRichMediaData) && this.f222433e != null) {
            com.tencent.mobileqq.guild.feed.share.c cVar = new com.tencent.mobileqq.guild.feed.share.c();
            cVar.k(getContext().hashCode());
            cVar.o((GuildFeedRichMediaData) broadcastGetMessage);
            cVar.l(this.f222433e.getFeed());
            F9(cVar);
        }
    }

    private void F9(com.tencent.mobileqq.guild.feed.share.c cVar) {
        com.tencent.mobileqq.guild.feed.share.p pVar = new com.tencent.mobileqq.guild.feed.share.p();
        pVar.d(getActivity());
        pVar.e(cVar);
        pVar.F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G9() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            A9();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.GuildFeedGalleryFloatLayerPart.2
                @Override // java.lang.Runnable
                public void run() {
                    GuildFeedGalleryFloatLayerPart.this.A9();
                }
            });
        }
    }

    private void H9() {
        GProStVideo D9 = D9();
        if (D9 == null) {
            this.f222432d.setTag("");
            this.f222432d.setVisibility(0);
            if (QLog.isColorLevel()) {
                QLog.d("GuildFeedGalleryMorePar", 1, "no need exchange url and set mFloatLayerIcon visible");
                return;
            }
            return;
        }
        this.f222432d.setTag(D9.fileId);
        GuildExchangeUrlManger.f().e(getContext().hashCode(), D9, new a());
    }

    private void initPageBean() {
        Intent intent;
        if (getActivity() != null && (intent = getActivity().getIntent()) != null && intent.hasExtra(com.tencent.mobileqq.guild.feed.b.f218115a)) {
            Serializable serializableExtra = intent.getSerializableExtra(com.tencent.mobileqq.guild.feed.b.f218115a);
            if (!(serializableExtra instanceof GuildFeedGalleryInitBean)) {
                return;
            }
            this.f222433e = (GuildFeedGalleryInitBean) serializableExtra;
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedGalleryFloatLayerIconEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        this.f222432d.setVisibility(8);
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!FastClickUtils.isFastDoubleClick("GuildFeedGalleryMorePar") && view.getId() == R.id.wka) {
            E9();
            B9(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.wka);
        this.f222432d = imageButton;
        imageButton.setOnClickListener(this);
        this.f222432d.setVisibility(8);
        initPageBean();
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        String str;
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof GuildFeedGalleryFloatLayerIconEvent) {
            boolean showIcon = ((GuildFeedGalleryFloatLayerIconEvent) simpleBaseEvent).showIcon();
            if (showIcon && this.f222432d.getVisibility() != 0) {
                H9();
                return;
            }
            if (!showIcon && this.f222432d.getVisibility() == 0) {
                this.f222432d.setVisibility(8);
                if (QLog.isColorLevel()) {
                    GProStVideo C9 = C9();
                    if (C9 != null) {
                        str = C9.fileId;
                    } else {
                        str = "emptyFileId";
                    }
                    QLog.d("GuildFeedGalleryMorePar", 1, "mFloatLayerIcon set Gone, fileId: " + str);
                }
            }
        }
    }
}

package com.tencent.mobileqq.qzoneplayer.cover.controller;

import android.content.Context;
import android.view.ViewStub;
import com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI;
import com.tencent.mobileqq.qzoneplayer.cover.view.VideoCoverController;
import com.tencent.mobileqq.qzoneplayer.cover.view.a;
import com.tencent.mobileqq.qzoneplayer.cover.widget.ErrorTipsPage;
import com.tencent.mobileqq.qzoneplayer.cover.widget.NetChangeWarnPage;
import com.tencent.mobileqq.qzoneplayer.cover.widget.b;
import com.tencent.mobileqq.qzoneplayer.cover.widget.c;
import com.tencent.mobileqq.qzoneplayer.cover.widget.d;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;

/* compiled from: P */
/* loaded from: classes35.dex */
public class CoverUIControllerFactory {
    private static final String TAG = "CoverUIControllerFactory";

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class ViewControllerType {
        public static final int TYPE_BASE_COVER = 2;
        public static final int TYPE_COMPLETE_PAGE = 6;
        public static final int TYPE_ERROR_PAGE = 5;
        public static final int TYPE_FLOAT_COMPLETE_PAGE = 4;
        public static final int TYPE_GDT_PASTER_AD_PAGE = 8;
        public static final int TYPE_LOADING_VIEW = 1;
        public static final int TYPE_NET_WARN_LAYOUT = 3;
        public static final int TYPE_PLAY_ICON_PAGE = 7;
    }

    public static AbsCoverUI create(Context context, ViewStub viewStub, BaseVideo baseVideo, int i3) {
        AbsCoverUI aVar;
        AbsCoverUI videoCoverController;
        switch (i3) {
            case 1:
                aVar = new a(context);
                aVar.initLayout(viewStub);
                break;
            case 2:
                videoCoverController = new VideoCoverController(context, baseVideo);
                videoCoverController.initLayout(viewStub);
                aVar = videoCoverController;
                break;
            case 3:
                videoCoverController = new NetChangeWarnPage(context, baseVideo);
                videoCoverController.initLayout(viewStub);
                aVar = videoCoverController;
                break;
            case 4:
                aVar = new d(context);
                aVar.initLayout(viewStub);
                break;
            case 5:
                aVar = new ErrorTipsPage(context);
                aVar.initLayout(viewStub);
                break;
            case 6:
                aVar = new c(context);
                aVar.initLayout(viewStub);
                break;
            case 7:
                aVar = new b(context);
                aVar.initLayout(viewStub);
                break;
            case 8:
                aVar = new com.tencent.mobileqq.qzoneplayer.cover.widget.a(context);
                aVar.initLayout(viewStub);
                break;
            default:
                aVar = null;
                break;
        }
        if (aVar != null) {
            aVar.setViewType(i3);
        }
        return aVar;
    }
}

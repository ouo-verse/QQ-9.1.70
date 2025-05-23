package com.tencent.qqnt.aio.gallery.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.guild.api.share.IGuildForwardUtilsApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.richframework.gallery.part.NTAIOLayerBasePart;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/aa;", "Lcom/tencent/richframework/gallery/part/NTAIOLayerBasePart;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class aa extends NTAIOLayerBasePart {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/aio/gallery/part/aa$a", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f350065d;

        a(View view) {
            this.f350065d = view;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f350065d.getViewTreeObserver().removeOnPreDrawListener(this);
            com.tencent.qqnt.trace.r.f362387a.findStream("GALLERY_PAGE").tagNode("SHOW_LIST");
            return true;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Bundle extras;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        rootView.getViewTreeObserver().addOnPreDrawListener(new a(rootView));
        Intent intent = getActivity().getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        String userType = extras.getString("extra.GUILD_USER_TYPE", "");
        Intrinsics.checkNotNullExpressionValue(userType, "userType");
        if (userType.length() == 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        String string = extras.getString(IGuildForwardUtilsApi.EXTRA_GUILD_ID, "");
        Intrinsics.checkNotNullExpressionValue(string, "it.getString(PeakUtils.EXTRA_GUILD_ID, \"\")");
        hashMap.put("sgrp_channel_id", string);
        String string2 = extras.getString(IGuildForwardUtilsApi.EXTRA_GUILD_CHANNEL_ID, "");
        Intrinsics.checkNotNullExpressionValue(string2, "it.getString(PeakUtils.EXTRA_GUILD_CHANNEL_ID, \"\")");
        hashMap.put("sgrp_sub_channel_id", string2);
        String string3 = extras.getString("extra.GUILD_AUTHOR_UIN", "");
        Intrinsics.checkNotNullExpressionValue(string3, "it.getString(PeakUtils.EXTRA_GUILD_AUTHOR_UIN, \"\")");
        hashMap.put("sgrp_author_uin", string3);
        hashMap.put("sgrp_user_type", userType);
        hashMap.put("sgrp_sub_channel_type", "1");
        hashMap.put("sgrp_duration_flag", "1");
        hashMap.put("aio_disappear_type", "0");
        Context context = rootView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        VideoReport.addToDetectionWhitelist((Activity) context);
        VideoReport.setPageId(rootView, "pg_sgrp_aio_viewer");
        VideoReport.setPageReportPolicy(rootView, PageReportPolicy.REPORT_ALL);
        VideoReport.setPageParams(rootView, new PageParams(hashMap));
    }

    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        com.tencent.qqnt.trace.r.f362387a.findStream("GALLERY_PAGE").tagNode("PAGE_INIT");
    }
}

package com.tencent.mobileqq.guild.feed.part;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.part.GalleryUtils.GalleryPicTransUtils;
import com.tencent.mobileqq.qqalbum.IPhotoTempUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import oj1.OnPageSelectMessage;
import oj1.OnUpdateMediaPath;

/* compiled from: P */
/* loaded from: classes13.dex */
public class o extends f implements View.OnClickListener {
    private ImageButton C;
    private HashMap<String, String> D = new HashMap<>();
    private HashMap<String, String> E = new HashMap<>();
    private GuildFeedGalleryInitBean F;

    /* renamed from: h, reason: collision with root package name */
    private ImageButton f222602h;

    /* renamed from: i, reason: collision with root package name */
    private View f222603i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f222604m;

    private void C9(String str, boolean z16) {
        Intent editPicActivityIntent = ((IPhotoTempUtils) QRoute.api(IPhotoTempUtils.class)).toEditPicActivityIntent(getActivity(), null, str, 2, new Bundle());
        if (z16) {
            editPicActivityIntent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 2);
        } else {
            editPicActivityIntent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0);
        }
        editPicActivityIntent.putExtra(PeakConstants.USE_NEW_ALBUM, true);
        editPicActivityIntent.putExtra("key_multi_edit_pic", true);
        editPicActivityIntent.putExtra("goEdit", true);
        editPicActivityIntent.putExtra("editFromPage", 2);
        getActivity().startActivityForResult(editPicActivityIntent, 10014);
    }

    private void D9(View view) {
        com.tencent.mobileqq.guild.feed.report.f.q(view, "em_sgrp_edit_button");
    }

    private String E9(String str) {
        if (this.E.containsKey(str)) {
            return this.E.get(str);
        }
        return str;
    }

    private void F9(Intent intent) {
        if (!(!intent.getBooleanExtra(PeakConstants.SEND_PICTURE_ORIGIN, false))) {
            return;
        }
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        String stringExtra2 = intent.getStringExtra(PeakConstants.KEY_MULIT_EDIT_SOURTH_PATH);
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            QLog.i("GuildFeedGalleryOperationPart", 2, "[handleEditActivityResult]--editedPicPath:" + stringExtra + ",originPath:" + stringExtra2);
            String E9 = E9(stringExtra2);
            if (this.D.containsKey(E9)) {
                String str = this.D.get(E9);
                this.D.remove(E9);
                this.D.put(stringExtra, str);
                broadcastMessage("message_page_update_media_path", new OnUpdateMediaPath(stringExtra));
                L9();
                return;
            }
            return;
        }
        QLog.e("GuildFeedGalleryOperationPart", 1, "[handleEditActivityResult]--editedPicPath or originPath is empty");
    }

    private void G9() {
        Object broadcastGetMessage = broadcastGetMessage("ACTION_GET_CURRENT_GALLERY_DATA", null);
        if ((broadcastGetMessage instanceof GuildFeedRichMediaData) && this.F != null) {
            GProStImage image = ((GuildFeedRichMediaData) broadcastGetMessage).getImage();
            if (image == null) {
                QLog.e("GuildFeedGalleryOperationPart", 1, "[openPicEditActivity]--stImage is null");
                return;
            }
            final String picUrl = image.getPicUrl();
            if (picUrl.startsWith("http")) {
                GalleryPicTransUtils.f222415a.d(image, new Function2() { // from class: com.tencent.mobileqq.guild.feed.part.n
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit J9;
                        J9 = o.this.J9(picUrl, (String) obj, (Boolean) obj2);
                        return J9;
                    }
                });
            } else {
                C9(picUrl, image.isOrig);
            }
        }
    }

    private void H9() {
        if (this.F.isShowCloseIcon()) {
            this.f222602h.setVisibility(0);
        } else {
            this.f222602h.setVisibility(8);
        }
        if (this.F.isShowEditBtn()) {
            this.C.setVisibility(0);
            D9(this.C);
        } else {
            this.C.setVisibility(8);
        }
    }

    private void I9() {
        GProStImage image;
        if (!this.F.isShowEditBtn() || !this.D.isEmpty() || this.F.getRichMediaDataList() == null) {
            return;
        }
        int size = this.F.getRichMediaDataList().size();
        for (int i3 = 0; i3 < size; i3++) {
            GuildFeedRichMediaData guildFeedRichMediaData = this.F.getRichMediaDataList().get(i3);
            if (guildFeedRichMediaData.getType() == 0 && (image = guildFeedRichMediaData.getImage()) != null) {
                HashMap<String, String> hashMap = this.D;
                String str = image.picUrl;
                hashMap.put(str, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit J9(String str, String str2, Boolean bool) {
        this.E.put(str2, str);
        broadcastMessage("message_page_update_media_path", new OnUpdateMediaPath(str2));
        C9(str2, bool.booleanValue());
        return null;
    }

    private void K9(View view) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, "em_sgrp_forum_video_close");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementParams(view, new HashMap());
    }

    private void M9() {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.F;
        if (guildFeedGalleryInitBean != null && guildFeedGalleryInitBean.isShowEditBtn()) {
            Object broadcastGetMessage = broadcastGetMessage("ACTION_GET_CURRENT_GALLERY_DATA", null);
            if (broadcastGetMessage instanceof GuildFeedRichMediaData) {
                if (((GuildFeedRichMediaData) broadcastGetMessage).getType() == 0) {
                    this.C.setVisibility(0);
                } else {
                    this.C.setVisibility(8);
                }
            }
        }
    }

    private void N9(int i3, int i16) {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.F;
        if (guildFeedGalleryInitBean == null || !guildFeedGalleryInitBean.isShowPageIndex() || i16 <= 1) {
            return;
        }
        String format = String.format(HardCodeUtil.qqStr(R.string.f158451pn), Integer.valueOf(i3 + 1), Integer.valueOf(i16));
        if (this.f222604m == null) {
            QLog.e("GuildFeedGalleryOperationPart", 1, "[updatePosition] mTvPosition is null");
        } else if (TextUtils.isEmpty(format)) {
            QLog.e("GuildFeedGalleryOperationPart", 1, "[updatePosition] text is null");
        } else {
            this.f222604m.setVisibility(0);
            this.f222604m.setText(format);
        }
    }

    private void initPageBean() {
        Intent intent;
        if (getActivity() != null && (intent = getActivity().getIntent()) != null && intent.hasExtra(com.tencent.mobileqq.guild.feed.b.f218115a)) {
            Serializable serializableExtra = intent.getSerializableExtra(com.tencent.mobileqq.guild.feed.b.f218115a);
            if (!(serializableExtra instanceof GuildFeedGalleryInitBean)) {
                return;
            }
            this.F = (GuildFeedGalleryInitBean) serializableExtra;
        }
    }

    public void L9() {
        Intent intent = new Intent();
        intent.putExtra(QAlbumConstants.KEY_EDIT_PATHS_MAP, this.D);
        getPartHost().getHostActivity().setResult(-1, intent);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GuildFeedGalleryOperationPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals(str, "message_page_select") && (obj instanceof OnPageSelectMessage)) {
            OnPageSelectMessage onPageSelectMessage = (OnPageSelectMessage) obj;
            N9(onPageSelectMessage.getSelectedPos(), onPageSelectMessage.getTotalSize());
            M9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i3 == 10014 && i16 == -1 && intent != null) {
            F9(intent);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        this.f222602h.setVisibility(8);
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.wk6) {
            broadcastMessage("message_page_close", new oj1.c());
        } else if (view.getId() == R.id.wk_) {
            G9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        initPageBean();
        this.f222602h = (ImageButton) view.findViewById(R.id.wk6);
        this.C = (ImageButton) view.findViewById(R.id.wk_);
        View findViewById = view.findViewById(R.id.wtw);
        this.f222603i = findViewById;
        ViewExtKt.f(findViewById, findViewById.getPaddingTop() + ImmersiveUtils.getStatusBarHeight(view.getContext()));
        this.f222604m = (TextView) this.f222603i.findViewById(R.id.x3r);
        this.f222602h.setOnClickListener(this);
        this.C.setOnClickListener(this);
        H9();
        I9();
        K9(this.f222602h);
    }
}

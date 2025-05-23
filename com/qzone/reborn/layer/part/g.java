package com.qzone.reborn.layer.part;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes37.dex */
public class g extends o {
    private View H;
    private TextView I;
    private TextView J;
    private TextView K;
    private ImageView L;

    private String R9(RFWLayerState rFWLayerState) {
        return "(" + C9(rFWLayerState) + "/" + D9(rFWLayerState) + ")";
    }

    private List<com.qzone.reborn.widget.b> S9(PhotoInfo photoInfo, RFWLayerPicInfo rFWLayerPicInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.qzone.reborn.widget.b(R.drawable.qui_calendar, new SimpleDateFormat("yyyy\u5e74M\u6708d\u65e5 EEEE HH:mm", Locale.CHINESE).format(new Date(photoInfo.uploadtime * 1000)), null));
        ea(photoInfo, rFWLayerPicInfo, arrayList);
        return arrayList;
    }

    private String T9() {
        String str;
        int i3;
        str = "";
        if (this.f57984d != null && this.f57988i != null) {
            if (Y9()) {
                i3 = this.f57984d.shootingTime;
            } else {
                i3 = this.f57984d.uploadtime;
            }
            String format = new SimpleDateFormat("yyyy\u5e74M\u6708d\u65e5").format(new Date(i3 * 1000));
            str = format != null ? format : "";
            if (ba()) {
                int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_NICK_MAX_LENGTH, 10);
                String str2 = this.f57984d.uploadOwner;
                if (str2.length() > config) {
                    str2 = str2.substring(0, config) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                return str + com.qzone.util.l.a(R.string.s3z) + str2 + com.qzone.util.l.a(R.string.f172559s43);
            }
        }
        return str;
    }

    private boolean Y9() {
        PhotoInfo photoInfo;
        PhotoParam photoParam = this.f57988i;
        if (photoParam == null || (photoInfo = this.f57984d) == null || photoInfo.shootingTime <= 0) {
            return false;
        }
        int i3 = photoParam.sortType;
        return i3 == 5 || i3 == 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
        if (B9() != null) {
            B9().u5();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aa(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        da();
        EventCollector.getInstance().onViewClicked(view);
    }

    private boolean ba() {
        if (this.f57984d == null) {
            return false;
        }
        PhotoParam photoParam = this.f57988i;
        return (photoParam != null && photoParam.isShareAlbum && this.D == 3) || this.D == 13;
    }

    private void ca() {
        long j3;
        if (this.f57984d == null) {
            return;
        }
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_PIC_INFO_URL, QzoneConfig.DefaultValue.DEFAULT_PICTURE_VIEWER_PIC_INFO_URL);
        String V9 = V9();
        Uri.Builder appendQueryParameter = Uri.parse(config.replace("{uin}", V9).replace("{album_id}", this.f57984d.albumId).replace("{photo_id}", this.f57984d.lloc)).buildUpon().appendQueryParameter("u", V9).appendQueryParameter("aid", this.f57984d.albumId).appendQueryParameter("pid", this.f57984d.lloc);
        if (com.qzone.util.z.b(this.f57984d)) {
            j3 = this.f57984d.videodata.originVideoSize;
        } else {
            j3 = this.f57984d.fileSize;
        }
        String Q9 = Q9(appendQueryParameter.appendQueryParameter("psize", String.valueOf(j3)).appendQueryParameter("t", String.valueOf(this.f57984d.imageResolution)).appendQueryParameter("_wv", String.valueOf(131072)).appendQueryParameter("_fv", String.valueOf(0)).appendQueryParameter("_proxy", String.valueOf(1)).toString());
        yo.d.n(getActivity(), Q9, true, R.anim.f154337z, Color.parseColor("#262626"), 9);
        if (B9() != null) {
            B9().V5();
        }
        QLog.d(getLogTag(), 1, "jump pic info url " + Q9);
    }

    private void da() {
        if (this.f57984d == null) {
            QLog.e("QZoneAlbumLayerHeaderPart", 1, "[showPicInfoPanelNew] select photo is null");
            return;
        }
        if (!com.qzone.reborn.configx.g.f53821a.b().N()) {
            ca();
            return;
        }
        com.qzone.reborn.widget.a aVar = new com.qzone.reborn.widget.a();
        aVar.d(1002);
        aVar.c(false);
        com.qzone.reborn.widget.f fVar = new com.qzone.reborn.widget.f(getActivity(), aVar);
        PhotoInfo photoInfo = this.f57984d;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        fVar.Y(S9(photoInfo, rFWLayerItemMediaInfo != null ? rFWLayerItemMediaInfo.getLayerPicInfo() : null));
        ef.d.f(fVar, getActivity());
    }

    protected String U9() {
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo != null && !TextUtils.isEmpty(photoInfo.albumName)) {
            return this.f57984d.albumName;
        }
        return "";
    }

    protected String V9() {
        return LoginData.getInstance().getUinString();
    }

    protected boolean W9() {
        return F9();
    }

    protected boolean X9() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QZoneAlbumLayerHeaderPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (intent == null) {
            RFWLog.e(getLogTag(), RFWLog.USR, "[onActivityResult] current data should not be null. error");
        } else if (i3 == 9 && i16 == -1 && B9() != null) {
            B9().n9();
        }
    }

    @Override // com.qzone.reborn.layer.part.o, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.clh, (ViewGroup) null);
        this.H = inflate;
        N9(inflate);
        this.I = (TextView) this.H.findViewById(R.id.mnr);
        this.J = (TextView) this.H.findViewById(R.id.mnq);
        this.K = (TextView) this.H.findViewById(R.id.mnp);
        this.I.setVisibility(0);
        this.J.setVisibility(X9() ? 0 : 8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getContext());
        ((ViewGroup) view).addView(this.H, layoutParams);
        ImageView imageView = (ImageView) this.H.findViewById(R.id.mnn);
        com.tencent.mobileqq.qzone.picload.c.a().m(imageView, -1);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.layer.part.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g.this.Z9(view2);
            }
        });
        this.L = (ImageView) this.H.findViewById(R.id.mnu);
        if (W9()) {
            this.L.setVisibility(8);
        } else {
            if (B9() != null) {
                B9().l9();
            }
            this.L.setVisibility(0);
            com.tencent.mobileqq.qzone.picload.c.a().m(this.L, -1);
            this.L.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.layer.part.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    g.this.aa(view2);
                }
            });
        }
        AccessibilityUtil.s(imageView, com.qzone.util.l.a(R.string.f2201668d));
    }

    @Override // com.qzone.reborn.layer.part.ap
    public void onLayerStateUpdate(RFWLayerState rFWLayerState) {
        if (this.f57984d == null) {
            this.H.setVisibility(8);
            return;
        }
        this.H.setVisibility(0);
        TextView textView = this.I;
        if (textView != null) {
            textView.setText(U9());
        }
        TextView textView2 = this.J;
        if (textView2 != null) {
            textView2.setText(R9(rFWLayerState));
        }
        TextView textView3 = this.K;
        if (textView3 != null) {
            textView3.setText(T9());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void ea(PhotoInfo photoInfo, RFWLayerPicInfo rFWLayerPicInfo, ArrayList<com.qzone.reborn.widget.b> arrayList) {
        com.qzone.reborn.widget.b bVar;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        if (rFWLayerPicInfo != null) {
            if (rFWLayerPicInfo.getDownloadPicInfo() != null) {
                currentPicInfo = rFWLayerPicInfo.getDownloadPicInfo();
            } else {
                currentPicInfo = rFWLayerPicInfo.getCurrentPicInfo();
            }
            if (currentPicInfo.getWidth() > 0 && currentPicInfo.getHeight() > 0) {
                bVar = new com.qzone.reborn.widget.b(R.drawable.qui_image, currentPicInfo.getWidth() + " X " + currentPicInfo.getHeight(), null);
                if (bVar == null && photoInfo != null && photoInfo.mOriginWidth > 0 && photoInfo.mOriginHeight > 0) {
                    bVar = new com.qzone.reborn.widget.b(R.drawable.qui_image, photoInfo.mOriginWidth + " X " + photoInfo.mOriginHeight, null);
                }
                if (bVar == null) {
                    arrayList.add(bVar);
                    return;
                }
                return;
            }
        }
        bVar = null;
        if (bVar == null) {
            bVar = new com.qzone.reborn.widget.b(R.drawable.qui_image, photoInfo.mOriginWidth + " X " + photoInfo.mOriginHeight, null);
        }
        if (bVar == null) {
        }
    }

    protected String Q9(String str) {
        return str;
    }
}

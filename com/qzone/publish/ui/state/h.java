package com.qzone.publish.ui.state;

import android.content.Intent;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.publish.ui.activity.QZoneUploadPhotoActivity;
import com.qzone.util.ToastUtil;
import com.qzone.util.image.NetImageInfo;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class h extends f {

    /* renamed from: g, reason: collision with root package name */
    private long f52090g;

    /* renamed from: h, reason: collision with root package name */
    private long f52091h;

    /* renamed from: i, reason: collision with root package name */
    private int f52092i;

    public h(QZoneUploadPhotoActivity qZoneUploadPhotoActivity) {
        super(qZoneUploadPhotoActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(BusinessAlbumInfo businessAlbumInfo, ArrayList arrayList, Object[] objArr) {
        QZoneWriteOperationService v06 = QZoneWriteOperationService.v0();
        String str = businessAlbumInfo.mAlbumId;
        String str2 = businessAlbumInfo.mTitle;
        String str3 = (String) objArr[0];
        long j3 = this.f52090g;
        long j16 = this.f52092i;
        QZoneUploadPhotoActivity qZoneUploadPhotoActivity = this.f51767a;
        v06.U1(str, str2, arrayList, str3, j3, j16, qZoneUploadPhotoActivity != null ? qZoneUploadPhotoActivity.getHandler() : null);
    }

    public ArrayList<NetImageInfo> B() {
        NetImageInfo netImageInfo;
        if (this.f52082c == null) {
            return null;
        }
        ArrayList<NetImageInfo> arrayList = new ArrayList<>();
        int size = this.f52082c.size();
        int size2 = this.f52085f.size();
        for (int i3 = 0; i3 < size && i3 < size2; i3++) {
            ArrayList<Long> arrayList2 = this.f52083d;
            if (arrayList2 != null && arrayList2.size() > i3) {
                netImageInfo = new NetImageInfo(this.f52082c.get(i3), this.f52085f.get(i3).longValue(), this.f52091h, this.f52083d.get(i3).longValue());
            } else {
                netImageInfo = new NetImageInfo(this.f52082c.get(i3), this.f52085f.get(i3).longValue());
            }
            arrayList.add(netImageInfo);
        }
        return arrayList;
    }

    public void D(int i3) {
        ArrayList<String> arrayList = this.f52082c;
        if (arrayList != null && this.f52085f != null && arrayList.size() > i3 && this.f52085f.size() > i3) {
            this.f52082c.remove(i3);
            this.f52085f.remove(i3);
        }
        ArrayList<Long> arrayList2 = this.f52083d;
        if (arrayList2 == null || arrayList2.size() <= i3) {
            return;
        }
        this.f52083d.remove(i3);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public String b() {
        return this.f51767a.getResources().getString(R.string.gdk);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void p() {
        long uin = LoginData.getInstance().getUin();
        String j06 = u5.b.j0("key_upload_photo_albun_id", "", uin);
        if (TextUtils.isEmpty(j06)) {
            return;
        }
        this.f51767a.L2 = BusinessAlbumInfo.create(j06);
        this.f51767a.L2.mTitle = u5.b.j0("key_upload_photo_albun_name", "", uin);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void q() {
        if (this.f51767a.L2 == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        u5.b.x0("key_upload_photo_albun_id", this.f51767a.L2.getId(), uin);
        u5.b.x0("key_upload_photo_albun_name", this.f51767a.L2.getTitle(), uin);
        u5.b.r0("key_upload_photo_albun_type", this.f51767a.L2.mAlbumType, uin);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void r() {
        this.f51767a.startActivityForResult(ak.x(this.f51767a.getActivity(), this.f51767a.getString(R.string.gng), 0), 2);
    }

    @Override // com.qzone.publish.ui.state.f
    protected void w(final BusinessAlbumInfo businessAlbumInfo, final Object... objArr) {
        final ArrayList<NetImageInfo> B = B();
        if (B == null) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastDataError", "\u6570\u636e\u5f02\u5e38"), 4);
        } else if (this.f51767a.Y2) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastQuoteYet", "\u5df2\u8f6c\u8f7d"), 5);
            this.f51767a.Y2 = false;
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.state.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.C(businessAlbumInfo, B, objArr);
                }
            });
        }
    }

    @Override // com.qzone.publish.ui.state.f
    protected void z(Intent intent) {
        String stringExtra = intent.getStringExtra(QZoneHelper.Constants.KEY_SRC_UIN);
        if (stringExtra != null) {
            try {
                this.f52090g = Long.parseLong(stringExtra);
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        }
        String stringExtra2 = intent.getStringExtra(QZoneHelper.Constants.KEY_QUN_ID);
        if (stringExtra2 != null) {
            try {
                this.f52091h = Long.parseLong(stringExtra2);
            } catch (NumberFormatException e17) {
                e17.printStackTrace();
            }
        }
        this.f52092i = intent.getIntExtra(QZoneHelper.Constants.KEY_QUOTE_SRC_TYPE, 1);
    }
}

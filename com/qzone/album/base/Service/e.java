package com.qzone.album.base.Service;

import NS_MOBILE_PHOTO.active_photo;
import NS_MOBILE_PHOTO.publish_active_album_rsp;
import NS_MOBILE_PHOTO.shuoshuo_privacy;
import android.text.TextUtils;
import com.qzone.album.protocol.QZoneQueryDynamicRequest;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.util.al;
import common.config.service.QzoneConfig;
import cooperation.qzone.album.QzonePhotoInfo;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e implements IQZoneServiceListener {
    private static final al<e, Void> I = new a();
    private b D;
    private String F;
    private int G;
    int H;

    /* renamed from: d, reason: collision with root package name */
    protected String f42047d;

    /* renamed from: e, reason: collision with root package name */
    private int f42048e;

    /* renamed from: f, reason: collision with root package name */
    private int f42049f;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<String> f42050h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<QzonePhotoInfo> f42051i = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    private boolean f42052m = false;
    private boolean C = false;
    private boolean E = false;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<e, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e a(Void r16) {
            return new e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void a(boolean z16, publish_active_album_rsp publish_active_album_rspVar);
    }

    e() {
        this.f42047d = "";
        this.f42048e = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DYNAMIC_MIN_PHOTO_NUM, 3);
        this.f42049f = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DYNAMIC_MAX_PHOTO_NUM, 60);
        this.f42047d = getClass().getSimpleName();
        try {
            String[] split = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_DYNAMIC_ALBUM_PHOTO_SELECT_NUM, this.f42049f + "," + this.f42048e).split(",");
            this.f42049f = Integer.valueOf(split[0]).intValue();
            this.f42048e = Integer.valueOf(split[1]).intValue();
        } catch (Exception unused) {
            this.f42049f = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DYNAMIC_MAX_PHOTO_NUM, 60);
            this.f42048e = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DYNAMIC_MIN_PHOTO_NUM, 3);
        }
    }

    public static e e() {
        return I.get(null);
    }

    public String a() {
        return this.F;
    }

    public int b() {
        return this.H;
    }

    public ArrayList<QzonePhotoInfo> c() {
        ArrayList<QzonePhotoInfo> arrayList = new ArrayList<>();
        arrayList.addAll(this.f42051i);
        this.f42051i.clear();
        return arrayList;
    }

    public void d(ArrayList<active_photo> arrayList, Map<String, String> map, shuoshuo_privacy shuoshuo_privacyVar, long j3, boolean z16, long j16) {
        String str;
        String uuid = UUID.randomUUID().toString();
        map.put("client_key", uuid);
        QZoneTask qZoneTask = new QZoneTask(new QZoneQueryDynamicRequest(arrayList, map, shuoshuo_privacyVar, j3, j16), null, null, 11);
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        qZoneTask.addParameter(QZoneJsConstants.DYNAMIC_ALBUM_SHARE_HAS_PREVIEWED, str);
        qZoneTask.clientKey = uuid;
        qZoneTask.setListener(this);
        qZoneTask.run();
    }

    public boolean f() {
        return this.f42052m;
    }

    public boolean g() {
        return this.C;
    }

    public ArrayList<String> h() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(this.f42050h);
        this.f42050h.clear();
        return arrayList;
    }

    public int i() {
        return this.G;
    }

    public int j() {
        return this.f42051i.size();
    }

    public int k() {
        return this.f42050h.size();
    }

    public int l() {
        return this.f42049f;
    }

    public int m() {
        return this.f42048e;
    }

    public boolean n() {
        return this.E;
    }

    public void o(String str) {
        this.F = str;
    }

    public void p(int i3) {
        this.H = i3;
    }

    public void r(boolean z16) {
        this.E = z16;
    }

    public void s(boolean z16) {
        this.f42052m = z16;
    }

    public void t(boolean z16) {
        this.C = z16;
    }

    public void u(b bVar) {
        this.D = bVar;
    }

    public void v(ArrayList<String> arrayList) {
        this.f42050h = arrayList;
    }

    public void w(int i3) {
        this.G = i3;
    }

    public void q(ArrayList<QzonePhotoInfo> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            this.f42051i.addAll(arrayList);
        } else {
            this.f42051i.clear();
        }
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask != null && qZoneTask.mType == 11) {
            u5.b.v0("key_dynamicalbum_has_checked_preview", (String) qZoneTask.getParameter(QZoneJsConstants.DYNAMIC_ALBUM_SHARE_HAS_PREVIEWED));
            publish_active_album_rsp publish_active_album_rspVar = (publish_active_album_rsp) qZoneTask.mUniAttr.getByClass("CreateActiveAlbum", new publish_active_album_rsp());
            if (publish_active_album_rspVar != null && !TextUtils.isEmpty(publish_active_album_rspVar.share_url) && !TextUtils.isEmpty(publish_active_album_rspVar.mgz_id)) {
                QZLog.d(QZLog.PUBLISH_QUEUE_TAG, 1, "get dynamicShareUrl succeed:" + publish_active_album_rspVar.share_url);
                u5.b.v0("key_dynamic_share_url", publish_active_album_rspVar.share_url);
                u5.b.v0("key_dynamic_mgz_id", publish_active_album_rspVar.mgz_id);
                b bVar = this.D;
                if (bVar != null) {
                    bVar.a(true, publish_active_album_rspVar);
                    return;
                }
                return;
            }
            u5.b.v0("key_dynamic_share_url", "null");
            u5.b.v0("key_dynamic_share_cover_url", "null");
            u5.b.v0("key_dynamic_client_ket", "null");
            u5.b.v0("key_dynamic_mgz_id", "null");
            b bVar2 = this.D;
            if (bVar2 != null) {
                bVar2.a(false, null);
            }
        }
    }
}

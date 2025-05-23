package com.qzone.proxy.feedcomponent.model;

import android.graphics.Bitmap;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FaceData implements SmartParcelable, Cloneable {
    public Bitmap bitmap;

    @NeedParcel
    public String faceUrl;

    /* renamed from: h, reason: collision with root package name */
    @NeedParcel
    public long f50234h;

    @NeedParcel
    public long opertime;

    @NeedParcel
    public long owner_uin;

    @NeedParcel
    public int quanstate;

    @NeedParcel
    public long targetuin;

    /* renamed from: w, reason: collision with root package name */
    @NeedParcel
    public long f50235w;

    @NeedParcel
    public long writeruin;

    /* renamed from: x, reason: collision with root package name */
    @NeedParcel
    public long f50236x;

    /* renamed from: y, reason: collision with root package name */
    @NeedParcel
    public long f50237y;
    public String album_id = "";

    @NeedParcel
    public String photo_id = "";

    @NeedParcel
    public String faceid = "";

    @NeedParcel
    public String quanid = "";

    @NeedParcel
    public String targetnick = "";

    @NeedParcel
    public String writernick = "";

    @NeedParcel
    public boolean isFromSystem = true;

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FaceData m81clone() {
        FaceData faceData = new FaceData();
        faceData.album_id = this.album_id;
        faceData.photo_id = this.photo_id;
        faceData.owner_uin = this.owner_uin;
        faceData.f50236x = this.f50236x;
        faceData.f50237y = this.f50237y;
        faceData.f50235w = this.f50235w;
        faceData.f50234h = this.f50234h;
        faceData.quanstate = this.quanstate;
        faceData.opertime = this.opertime;
        faceData.faceid = this.faceid;
        faceData.quanid = this.quanid;
        faceData.targetuin = this.targetuin;
        faceData.targetnick = this.targetnick;
        faceData.writeruin = this.writeruin;
        faceData.writernick = this.writernick;
        faceData.bitmap = null;
        faceData.faceUrl = this.faceUrl;
        faceData.isFromSystem = this.isFromSystem;
        return faceData;
    }
}

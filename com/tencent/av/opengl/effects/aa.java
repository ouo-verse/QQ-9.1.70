package com.tencent.av.opengl.effects;

import android.text.TextUtils;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;

/* compiled from: P */
/* loaded from: classes3.dex */
public class aa {

    /* renamed from: a, reason: collision with root package name */
    int f73905a = 0;

    /* renamed from: b, reason: collision with root package name */
    int f73906b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f73907c = 0;

    /* renamed from: d, reason: collision with root package name */
    int f73908d = 0;

    /* renamed from: e, reason: collision with root package name */
    int f73909e = 0;

    /* renamed from: f, reason: collision with root package name */
    boolean f73910f = false;

    /* renamed from: g, reason: collision with root package name */
    boolean f73911g = false;

    /* renamed from: h, reason: collision with root package name */
    String f73912h = null;

    /* renamed from: i, reason: collision with root package name */
    String f73913i = null;

    /* renamed from: j, reason: collision with root package name */
    String f73914j = null;

    public void a(String str, long j3, int i3, int i16, int i17, boolean z16, FilterDesc filterDesc, VideoMaterial videoMaterial, PendantItem pendantItem, com.tencent.avcore.camera.data.c cVar, int i18) {
        String str2;
        String str3;
        String videoMaterial2;
        String str4 = "null";
        if (filterDesc == null || (str2 = filterDesc.name) == null) {
            str2 = "null";
        }
        if (pendantItem == null || pendantItem.getId() == null) {
            str3 = "null";
        } else {
            str3 = pendantItem.getId();
        }
        if (videoMaterial == null) {
            videoMaterial2 = "null";
        } else {
            videoMaterial2 = videoMaterial.toString();
        }
        if (i3 != this.f73905a || i16 != this.f73906b || i17 != this.f73907c || z16 != this.f73911g || this.f73908d != cVar.f() || this.f73910f != cVar.f77447g || this.f73909e != i18 || !TextUtils.equals(str2, this.f73912h) || !TextUtils.equals(str3, this.f73913i) || !TextUtils.equals(videoMaterial2, this.f73914j)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("RenderInfoLog, frameIndex[");
            sb5.append(j3);
            sb5.append("], width[");
            sb5.append(this.f73905a);
            sb5.append("->");
            sb5.append(i3);
            sb5.append("], height[");
            sb5.append(this.f73906b);
            sb5.append("->");
            sb5.append(i16);
            sb5.append("], angle[");
            sb5.append(this.f73907c);
            sb5.append("->");
            sb5.append(i17);
            sb5.append("], needFaceData[");
            sb5.append(this.f73911g);
            sb5.append("->");
            sb5.append(z16);
            sb5.append("], mDataLen[");
            sb5.append(this.f73908d);
            sb5.append("->");
            sb5.append(cVar.f());
            sb5.append("], mBeautyLevel[");
            sb5.append(this.f73909e);
            sb5.append("->");
            sb5.append(i18);
            sb5.append("], isFront[");
            sb5.append(this.f73910f);
            sb5.append("->");
            sb5.append(cVar.f77447g);
            sb5.append("], getFrameAngle[");
            sb5.append(ad.a(cVar.f77447g));
            sb5.append("], fAngle[");
            sb5.append((((cVar.f77445e - ad.a(cVar.f77447g)) - 1) + 4) % 4);
            sb5.append("], strFilterDesc[");
            sb5.append(str2);
            sb5.append("], strPendantItem[");
            sb5.append(str3);
            sb5.append("], pendantItem[");
            if (pendantItem != null && pendantItem.getId() != null) {
                str4 = pendantItem.getId();
            }
            sb5.append(str4);
            sb5.append("], strFilters[");
            sb5.append(videoMaterial2);
            sb5.append("]");
            QLog.w(str, 1, sb5.toString());
            this.f73910f = cVar.f77447g;
            this.f73905a = i3;
            this.f73906b = i16;
            this.f73907c = i17;
            this.f73911g = z16;
            this.f73912h = str2;
            this.f73913i = str3;
            this.f73914j = videoMaterial2;
            this.f73908d = cVar.f();
            this.f73909e = i18;
        }
    }
}

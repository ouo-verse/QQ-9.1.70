package com.tencent.av.business.manager.magicface;

import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.util.JSONUtils;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends MagicFaceDataEntity {

    /* renamed from: t, reason: collision with root package name */
    protected MagicfaceDataMultiResultJason f73364t;

    /* renamed from: u, reason: collision with root package name */
    Rect f73365u;

    /* renamed from: v, reason: collision with root package name */
    int f73366v;

    public b(VideoAppInterface videoAppInterface, String str, String str2, String str3, boolean z16, int i3) {
        super(videoAppInterface, str, str2, str3, z16, i3);
        boolean z17 = false;
        this.f73366v = 0;
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (jSONObject.has("multiresult")) {
                this.f73364t = (MagicfaceDataMultiResultJason) JSONUtils.b(jSONObject.getJSONObject("multiresult"), MagicfaceDataMultiResultJason.class);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (this.f73364t == null) {
            this.f73364t = new MagicfaceDataMultiResultJason();
        }
        AVCoreLog.printErrorLog("MagicFaceDataEntityMultiResult", "multi: " + this.f73364t.toString());
        MagicfaceDataMultiResultJason magicfaceDataMultiResultJason = this.f73364t;
        int i16 = magicfaceDataMultiResultJason.divers_x;
        int i17 = magicfaceDataMultiResultJason.divers_y;
        this.f73365u = new Rect(i16, i17, magicfaceDataMultiResultJason.divers_wid + i16, magicfaceDataMultiResultJason.divers_hei + i17);
        if ((z16 && this.f73341p.get(1)) || (!z16 && this.f73341p.get(0))) {
            z17 = true;
        }
        this.f73339n = z17;
        AVCoreLog.printColorLog("MagicFaceDataEntityMultiResult", "MagicFaceDataEntityMultiResult constructor:");
    }

    private String O(MagicfaceDataPendantJason magicfaceDataPendantJason, String str) {
        if (magicfaceDataPendantJason != null && magicfaceDataPendantJason.mirror && !this.f73340o) {
            return str + "_mirror";
        }
        return str;
    }

    private String P(int i3, int i16) {
        AVCoreLog.printColorLog("MagicFaceDataEntityMultiResult", " getResultString:" + i16 + "|" + this.f73364t.divers_ani_start);
        if (i16 != 0) {
            if (i16 != 1) {
                return "";
            }
            return this.f73364t.divers_ani_hit;
        }
        return this.f73364t.divers_ani_miss;
    }

    private String Q() {
        int i3 = this.f73366v;
        if (i3 != 0) {
            if (i3 != 1) {
                return null;
            }
            return "hit";
        }
        return MagicfaceDataPendantJason.TRIGGER_MISS;
    }

    private int R() {
        int i3 = this.f73366v;
        if (i3 != 0) {
            if (i3 != 1) {
                return 0;
            }
            return this.f73364t.divers_ani_hit_frame;
        }
        return this.f73364t.divers_ani_miss_frame;
    }

    private void S(byte[] bArr, boolean z16) {
        int i3;
        int i16;
        int i17;
        if (z16) {
            i3 = 4;
        } else {
            i3 = 2;
        }
        int i18 = i3 * 64 * 2;
        if (bArr != null && bArr.length > i18 && this.f73365u != null) {
            AVCoreLog.printColorLog("MagicFaceDataEntityMultiResult", "isShot:" + this.f73366v + "|" + this.f73374h + "|" + this.f73364t.divers_ani_start + "|" + this.f73365u.toString() + "|" + bArr.length);
            if (this.f73366v == 0) {
                int i19 = this.f73374h;
                int i26 = this.f73364t.divers_ani_start;
                if (i19 >= i26 - 2 && i19 < i26) {
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    if (z16) {
                        i16 = wrap.getInt(i18) / 1000000;
                    } else {
                        i16 = wrap.getShort(i18);
                    }
                    float f16 = i16;
                    if (z16) {
                        i17 = wrap.getInt(i18 + i3) / 1000000;
                    } else {
                        i17 = wrap.getShort(i18 + i3);
                    }
                    float f17 = i17;
                    AVCoreLog.printColorLog("MagicFaceDataEntityMultiResult", "onReceiveFaceFeature Kill is:|" + f16 + "|" + f17 + "|" + this.f73365u.toString());
                    if (this.f73365u.contains((int) f16, (int) f17)) {
                        this.f73366v = 1;
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        AVCoreLog.printColorLog("MagicFaceDataEntityMultiResult", "isShot ERROR");
    }

    private boolean T() {
        if (this.f73341p.get(1) && !TextUtils.isEmpty(this.f73369c.tips)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.magicface.MagicFaceDataEntity
    public void A() {
        super.A();
        if (this.f73341p.get(0)) {
            F(true);
        }
        AVCoreLog.printColorLog("MagicFaceDataEntityMultiResult", "processStart:" + this.f73341p.get(2));
        if (!this.f73341p.get(2) && T()) {
            H(this.f73369c.tips);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.magicface.MagicFaceDataEntity
    public void C() {
        super.C();
        if (this.f73341p.get(0)) {
            F(false);
        }
        m(0);
        m(1);
        if (T()) {
            H(null);
        }
    }

    protected String N() {
        String str;
        String str2 = "";
        if (this.f73369c.hasMirrorRes) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("_");
            if (this.f73339n) {
                str = "mirror";
            } else {
                str = "normal";
            }
            sb5.append(str);
            str2 = sb5.toString();
        }
        AVCoreLog.printColorLog("MagicFaceDataEntityMultiResult", "getMirrorPath:" + this.f73369c.hasMirrorRes + "|" + this.f73339n + "|" + str2);
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.magicface.MagicFaceDataEntity, com.tencent.av.business.manager.magicface.c
    public int a() {
        return super.a() + R();
    }

    @Override // com.tencent.av.business.manager.magicface.MagicFaceDataEntity, com.tencent.av.business.manager.magicface.c
    public String c(int i3) {
        if (!TextUtils.isEmpty(this.f73369c.common_id)) {
            int a16 = a();
            AVCoreLog.printColorLog("MagicFaceDataEntityMultiResult", " getResPath:" + i3 + "|" + this.f73364t.divers_ani_start + "|" + a16);
            if (i3 >= this.f73364t.divers_ani_start && i3 < a16) {
                return this.f73369c.common_id + "_" + P(i3, this.f73366v) + N();
            }
            return this.f73369c.common_id + N();
        }
        return super.c(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.magicface.MagicFaceDataEntity
    public String o(MagicfaceDataPendantJason magicfaceDataPendantJason) {
        String str;
        String o16 = super.o(magicfaceDataPendantJason);
        AVCoreLog.printColorLog("MagicFaceDataEntityMultiResult", "getDecorateName :" + magicfaceDataPendantJason.toString());
        if (!TextUtils.isEmpty(o16)) {
            if (!TextUtils.isEmpty(magicfaceDataPendantJason.trigger)) {
                String Q = Q();
                AVCoreLog.printColorLog("MagicFaceDataEntityMultiResult", "getDecorateName 2:" + magicfaceDataPendantJason.trigger + "|" + Q);
                if (magicfaceDataPendantJason.trigger.equals(Q)) {
                    str = O(magicfaceDataPendantJason, o16);
                } else {
                    str = null;
                }
                o16 = str;
            } else {
                o16 = O(magicfaceDataPendantJason, o16);
            }
        }
        AVCoreLog.printColorLog("MagicFaceDataEntityMultiResult", "getDecorateName 3:" + o16);
        return o16;
    }

    @Override // com.tencent.av.business.manager.magicface.MagicFaceDataEntity
    public void y(String str, byte[] bArr, short s16, short s17, short s18, short s19, boolean z16) {
        super.y(str, bArr, s16, s17, s18, s19, z16);
        if (this.f73341p.get(0)) {
            if (!u(str)) {
                S(bArr, z16);
            }
        } else if (u(str)) {
            S(bArr, z16);
        }
    }
}

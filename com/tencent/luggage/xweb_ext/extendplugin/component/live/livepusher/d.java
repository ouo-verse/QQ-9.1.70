package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.live2.jsplugin.pusher.V2TXLivePusherJSAdapter;
import com.tencent.luggage.wxa.f8.BlusherStickInfo;
import com.tencent.luggage.wxa.f8.EyeBrowInfo;
import com.tencent.luggage.wxa.f8.EyeShadowInfoV2;
import com.tencent.luggage.wxa.f8.FaceContourInfo;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LipStickInfoV2;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
class d {

    /* renamed from: f, reason: collision with root package name */
    private static final String f146997f = "TXLivePusherWeEffectJSAdapter";

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private static b.InterfaceC7005b f146998g = b.InterfaceC7005b.INSTANCE;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final com.tencent.luggage.wxa.f8.n f146999a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f147000b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final b f147001c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f147002d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f147003e;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f147004a;

        static {
            int[] iArr = new int[a.d.values().length];
            f147004a = iArr;
            try {
                iArr[a.d.MAKEUP_LIP_STICK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f147004a[a.d.MAKEUP_EYE_SHADOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f147004a[a.d.MAKEUP_BLUSHER_STICK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f147004a[a.d.MAKEUP_FACE_CONTOUR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f147004a[a.d.MAKEUP_EYE_BROW.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public d(@NonNull TXLivePusher tXLivePusher) {
        this(com.tencent.luggage.wxa.f8.w.a(tXLivePusher));
    }

    public static void a(@NonNull b.InterfaceC7005b interfaceC7005b) {
        f146998g = interfaceC7005b;
    }

    private void b(@NonNull Bundle bundle) {
        a(bundle, com.tencent.luggage.wxa.c8.c.f123384n, a.b.FACE_THIN);
    }

    private void c(@NonNull Bundle bundle) {
        a(bundle, com.tencent.luggage.wxa.c8.c.f123382m, a.b.SKIN_SMOOTH);
    }

    private void d(@NonNull Bundle bundle) {
        a(bundle, com.tencent.luggage.wxa.c8.c.f123380l, a.b.SKIN_BRIGHT);
    }

    @Nullable
    private LipStickInfoV2.Color g(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("color");
        if (w0.c(optString)) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "parseColor, colorStr is empty");
            return null;
        }
        try {
            int parseColor = Color.parseColor(optString);
            return new LipStickInfoV2.Color(Color.red(parseColor), Color.green(parseColor), Color.blue(parseColor));
        } catch (Exception unused) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "parseColor, colorStr is illegal");
            return null;
        }
    }

    @Nullable
    private EyeBrowInfo h(@NonNull JSONObject jSONObject) {
        float a16 = a(jSONObject, com.tencent.luggage.wxa.c8.c.f123400v);
        int optInt = jSONObject.optInt(com.tencent.luggage.wxa.c8.c.T, 0);
        if (optInt != 0) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "parseEyeBrowInfo, faceModel is illegal");
            return null;
        }
        com.tencent.luggage.wxa.f8.a a17 = com.tencent.luggage.wxa.f8.a.a(jSONObject.optInt(com.tencent.luggage.wxa.c8.c.W, 0));
        if (a17 == null) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "parseEyeBrowInfo, blendMode is null");
            return null;
        }
        String optString = jSONObject.optString("path", "");
        if (w0.c(optString)) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "parseEyeBrowInfo, path is empty");
            return null;
        }
        return new EyeBrowInfo(a16, optInt, a17, optString, jSONObject.optString(com.tencent.luggage.wxa.c8.c.Y, ""), a(jSONObject, com.tencent.luggage.wxa.c8.c.f123369c0, 0.0f));
    }

    @Nullable
    private EyeShadowInfoV2 i(@NonNull JSONObject jSONObject) {
        float a16 = a(jSONObject, com.tencent.luggage.wxa.c8.c.f123400v);
        com.tencent.luggage.wxa.f8.a a17 = com.tencent.luggage.wxa.f8.a.a(jSONObject.optInt(com.tencent.luggage.wxa.c8.c.W, 0));
        if (a17 == null) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "parseEyeShadowInfoV2, blendMode is null");
            return null;
        }
        String optString = jSONObject.optString("path", "");
        if (w0.c(optString)) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "parseEyeShadowInfoV2, path is empty");
            return null;
        }
        String optString2 = jSONObject.optString(com.tencent.luggage.wxa.c8.c.Y, "");
        String optString3 = jSONObject.optString(com.tencent.luggage.wxa.c8.c.f123367a0, "");
        if (w0.c(optString3)) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "parseEyeShadowInfoV2, shimmerPosPath is empty");
            return null;
        }
        return new EyeShadowInfoV2(a16, a17, optString, optString2, optString3, jSONObject.optString(com.tencent.luggage.wxa.c8.c.f123368b0, ""));
    }

    @Nullable
    private FaceContourInfo j(@NonNull JSONObject jSONObject) {
        float a16 = a(jSONObject, com.tencent.luggage.wxa.c8.c.f123400v);
        String optString = jSONObject.optString("path", "");
        if (w0.c(optString)) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "parseFaceContourInfo, path is empty");
            return null;
        }
        String optString2 = jSONObject.optString(com.tencent.luggage.wxa.c8.c.Y, "");
        int optInt = jSONObject.optInt(com.tencent.luggage.wxa.c8.c.T, 0);
        if (optInt != 0) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "parseFaceContourInfo, faceModel is illegal");
            return null;
        }
        return new FaceContourInfo(optInt, a16, optString, optString2);
    }

    @Nullable
    private LipStickInfoV2 k(@NonNull JSONObject jSONObject) {
        float a16 = a(jSONObject, com.tencent.luggage.wxa.c8.c.f123400v);
        LipStickInfoV2.Color g16 = g(jSONObject);
        if (g16 == null) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "parseLipStickInfo, color is null");
            return null;
        }
        LipStickInfoV2.b a17 = LipStickInfoV2.b.a(jSONObject.optInt(com.tencent.luggage.wxa.c8.c.V, 0));
        if (a17 == null) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "parseLipStickInfo, type is null");
            return null;
        }
        int optInt = jSONObject.optInt(com.tencent.luggage.wxa.c8.c.T, 0);
        if (optInt != 0) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "parseLipStickInfo, faceModel is illegal");
            return null;
        }
        return new LipStickInfoV2(a16, g16, a17, optInt, LipStickInfoV2.EnumC7006c.STANDARD);
    }

    @Nullable
    private a.d l(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString(com.tencent.luggage.wxa.c8.c.M, null);
        if (w0.c(optString)) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "parseMakeupType, makeupTypeStr is empty");
            return null;
        }
        if (optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.O)) {
            return a.d.MAKEUP_LIP_STICK;
        }
        if (optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.P)) {
            return a.d.MAKEUP_EYE_SHADOW;
        }
        if (optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.Q)) {
            return a.d.MAKEUP_BLUSHER_STICK;
        }
        if (optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.R)) {
            return a.d.MAKEUP_FACE_CONTOUR;
        }
        if (optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.S)) {
            return a.d.MAKEUP_EYE_BROW;
        }
        com.tencent.luggage.wxa.tn.w.f(f146997f, "parseMakeupType, makeupTypeStr: " + optString);
        return null;
    }

    @Nullable
    private a.e m(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString(com.tencent.luggage.wxa.c8.c.f123402w, null);
        if (w0.c(optString)) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "parseStickerType, stickerTypeStr is empty");
            return null;
        }
        if (optString.equalsIgnoreCase("back")) {
            return a.e.STICKER_BACK;
        }
        if (optString.equalsIgnoreCase("front")) {
            return a.e.STICKER_FRONT;
        }
        if (optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.A)) {
            return a.e.STICKER_2D;
        }
        com.tencent.luggage.wxa.tn.w.f(f146997f, "parseStickerType, stickerTypeStr: " + optString);
        return null;
    }

    @Nullable
    private JSONObject n(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(com.tencent.luggage.wxa.c8.c.f123404x);
        if (optJSONObject == null) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "parseTemplateTransSet, templateTransSetJsonObj is null");
            return null;
        }
        return optJSONObject;
    }

    public void e(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        a(bundle, true);
        this.f147000b = true;
    }

    public void f(Bundle bundle) {
        if (bundle != null && this.f147000b) {
            a(bundle, false);
        }
    }

    public d(@NonNull V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter) {
        this(com.tencent.luggage.wxa.f8.w.a(v2TXLivePusherJSAdapter));
    }

    private boolean b() {
        if (!f()) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "clearFilters, useCustomEffect is false");
            return false;
        }
        a();
        com.tencent.luggage.wxa.tn.w.a(f146997f, com.tencent.luggage.wxa.c8.c.f123390q);
        this.f147001c.c();
        return true;
    }

    private boolean c(@NonNull JSONObject jSONObject) {
        if (!f()) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "applyMakeupWorkaround, useCustomEffect is false");
            return false;
        }
        a.d l3 = l(jSONObject);
        if (l3 == null) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "applyMakeupWorkaround, makeupType is null");
            return false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(com.tencent.luggage.wxa.c8.c.N);
        if (optJSONObject == null) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "applyMakeupWorkaround, makeupJsonObj is null");
            return false;
        }
        a();
        com.tencent.luggage.wxa.tn.w.a(f146997f, "applyMakeupWorkaround, makeupType: %s", l3);
        int i3 = a.f147004a[l3.ordinal()];
        if (i3 == 1) {
            LipStickInfoV2 k3 = k(optJSONObject);
            if (k3 == null) {
                com.tencent.luggage.wxa.tn.w.f(f146997f, "applyMakeupWorkaround, lipStickInfo is null");
                return false;
            }
            return this.f147001c.a(k3);
        }
        if (i3 == 2) {
            EyeShadowInfoV2 i16 = i(optJSONObject);
            if (i16 == null) {
                com.tencent.luggage.wxa.tn.w.f(f146997f, "applyMakeupWorkaround, eyeShadowInfo is null");
                return false;
            }
            return this.f147001c.a(i16);
        }
        if (i3 == 3) {
            BlusherStickInfo f16 = f(optJSONObject);
            if (f16 == null) {
                com.tencent.luggage.wxa.tn.w.f(f146997f, "applyMakeupWorkaround, blusherStickInfo is null");
                return false;
            }
            return this.f147001c.a(f16);
        }
        if (i3 == 4) {
            FaceContourInfo j3 = j(optJSONObject);
            if (j3 == null) {
                com.tencent.luggage.wxa.tn.w.f(f146997f, "applyMakeupWorkaround, faceContourInfo is null");
                return false;
            }
            return this.f147001c.a(j3);
        }
        if (i3 != 5) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "applyMakeupWorkaround, should not reach");
            return false;
        }
        EyeBrowInfo h16 = h(optJSONObject);
        if (h16 == null) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "applyMakeupWorkaround, eyeBrowInfo is null");
            return false;
        }
        return this.f147001c.a(h16);
    }

    private boolean d(@NonNull JSONObject jSONObject) {
        if (!f()) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "applySticker, useCustomEffect is false");
            return false;
        }
        String optString = jSONObject.optString("path", null);
        if (w0.c(optString)) {
            com.tencent.luggage.wxa.tn.w.d(f146997f, "applySticker, resourcePath is null");
            return e(jSONObject);
        }
        a.e m3 = m(jSONObject);
        if (m3 == null) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "applySticker, stickerType is null");
            return false;
        }
        a();
        com.tencent.luggage.wxa.tn.w.a(f146997f, "applySticker, stickerType: %s, resourcePath: %s", m3, optString);
        this.f147001c.a(m3, optString);
        return true;
    }

    public void a(TXCloudVideoView tXCloudVideoView, Bundle bundle) {
        if (tXCloudVideoView == null || bundle == null) {
            return;
        }
        a(bundle, true);
        this.f147000b = true;
    }

    public d(@NonNull com.tencent.luggage.wxa.f8.n nVar) {
        this.f147000b = false;
        this.f147001c = f146998g.create();
        this.f147002d = false;
        this.f147003e = false;
        this.f146999a = nVar;
    }

    private boolean f() {
        return this.f147003e && this.f147001c.isEnabled();
    }

    public void e() {
        this.f147000b = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0117 A[Catch: Exception -> 0x012b, TRY_LEAVE, TryCatch #0 {Exception -> 0x012b, blocks: (B:21:0x0054, B:51:0x006f, B:23:0x007e, B:25:0x008c, B:30:0x00cb, B:32:0x00d1, B:35:0x00de, B:37:0x00ed, B:42:0x0102, B:39:0x0117, B:44:0x0095, B:48:0x00a3, B:46:0x00b2), top: B:20:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0102 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean e(@NonNull JSONObject jSONObject) {
        int length;
        StickerItemInfo.Position position;
        StickerItemInfo.TriggerAction from;
        if (!f()) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "applyStickerWorkaround, useCustomEffect is false");
            return false;
        }
        a.e m3 = m(jSONObject);
        if (m3 == null) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "applyStickerWorkaround, stickerType is null");
            return false;
        }
        JSONObject n3 = n(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray(com.tencent.luggage.wxa.c8.c.B);
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            ArrayList arrayList = new ArrayList(length);
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject == null) {
                    com.tencent.luggage.wxa.tn.w.h(f146997f, "applyStickerWorkaround, stickerJsonObj(%d) is null", Integer.valueOf(i3));
                    return false;
                }
                try {
                    String string = optJSONObject.getString("title");
                    int i16 = optJSONObject.getInt(com.tencent.luggage.wxa.c8.c.E);
                    String string2 = optJSONObject.getString("path");
                    if (w0.c(string2)) {
                        com.tencent.luggage.wxa.tn.w.h(f146997f, "applyStickerWorkaround, i: %d, resDirPath is empty", Integer.valueOf(i3));
                        return false;
                    }
                    String optString = optJSONObject.optString("md5", "");
                    if (a.e.STICKER_2D != m3 && a.e.STICKER_FRONT != m3) {
                        position = null;
                        StickerItemInfo.Position position2 = position;
                        StickerItemInfo.StickerBackType stickerBackType = StickerItemInfo.StickerBackType.BACKGROUND;
                        if (a.e.STICKER_BACK != m3 && (stickerBackType = StickerItemInfo.StickerBackType.from(optJSONObject.getInt(com.tencent.luggage.wxa.c8.c.H))) == null) {
                            com.tencent.luggage.wxa.tn.w.h(f146997f, "applyStickerWorkaround, i: %d, type is null", Integer.valueOf(i3));
                            return false;
                        }
                        StickerItemInfo.StickerBackType stickerBackType2 = stickerBackType;
                        int optInt = optJSONObject.optInt("active", StickerItemInfo.TriggerAction.DEFAULT_ACTION_LOOP.getJsonVal());
                        from = StickerItemInfo.TriggerAction.from(optInt);
                        if (from != null) {
                            com.tencent.luggage.wxa.tn.w.h(f146997f, "applyStickerWorkaround, i: %d, actionInt: %d, action is null", Integer.valueOf(i3), Integer.valueOf(optInt));
                            return false;
                        }
                        arrayList.add(new StickerItemInfo(optJSONObject.optInt("id", i3), string, i16, from, string2, optString, position2, stickerBackType2));
                    }
                    JSONArray jSONArray = optJSONObject.getJSONArray(com.tencent.luggage.wxa.c8.c.G);
                    if (4 != jSONArray.length()) {
                        com.tencent.luggage.wxa.tn.w.h(f146997f, "applyStickerWorkaround, i: %d, length of posJsonArr is not 4", Integer.valueOf(i3));
                        return false;
                    }
                    position = new StickerItemInfo.Position(jSONArray.getDouble(0), jSONArray.getDouble(1), jSONArray.getDouble(2), jSONArray.getDouble(3));
                    StickerItemInfo.Position position22 = position;
                    StickerItemInfo.StickerBackType stickerBackType3 = StickerItemInfo.StickerBackType.BACKGROUND;
                    if (a.e.STICKER_BACK != m3) {
                    }
                    StickerItemInfo.StickerBackType stickerBackType22 = stickerBackType3;
                    int optInt2 = optJSONObject.optInt("active", StickerItemInfo.TriggerAction.DEFAULT_ACTION_LOOP.getJsonVal());
                    from = StickerItemInfo.TriggerAction.from(optInt2);
                    if (from != null) {
                    }
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.h(f146997f, "applyStickerWorkaround, i: %d, convert fail since %s", Integer.valueOf(i3), e16);
                    return false;
                }
            }
            a();
            com.tencent.luggage.wxa.tn.w.a(f146997f, "applyStickerWorkaround, stickerType: %s", m3);
            return this.f147001c.a(m3, arrayList, n3);
        }
        com.tencent.luggage.wxa.tn.w.f(f146997f, "applyStickerWorkaround, stickersJsonArr is empty");
        return false;
    }

    @Nullable
    private BlusherStickInfo f(@NonNull JSONObject jSONObject) {
        float a16 = a(jSONObject, com.tencent.luggage.wxa.c8.c.f123400v);
        com.tencent.luggage.wxa.f8.a a17 = com.tencent.luggage.wxa.f8.a.a(jSONObject.optInt(com.tencent.luggage.wxa.c8.c.W, 0));
        if (a17 == null) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "parseBlusherStickInfo, blendMode is null");
            return null;
        }
        String optString = jSONObject.optString("path", "");
        if (w0.c(optString)) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "parseBlusherStickInfo, path is empty");
            return null;
        }
        String optString2 = jSONObject.optString(com.tencent.luggage.wxa.c8.c.Y, "");
        int optInt = jSONObject.optInt(com.tencent.luggage.wxa.c8.c.T, 0);
        if (optInt != 0) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "parseBlusherStickInfo, faceModel is illegal");
            return null;
        }
        return new BlusherStickInfo(a16, optInt, a17, optString, optString2);
    }

    public com.tencent.luggage.wxa.ff.h a(@NonNull String str, JSONObject jSONObject) {
        boolean z16;
        if (str.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.f123388p)) {
            z16 = jSONObject != null && a(jSONObject);
            return new com.tencent.luggage.wxa.ff.h(z16 ? 0 : -2, z16 ? "Success" : "Failed");
        }
        if (str.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.f123390q)) {
            boolean b16 = b();
            return new com.tencent.luggage.wxa.ff.h(b16 ? 0 : -2, b16 ? "Success" : "Failed");
        }
        if (str.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.f123392r)) {
            z16 = jSONObject != null && d(jSONObject);
            return new com.tencent.luggage.wxa.ff.h(z16 ? 0 : -2, z16 ? "Success" : "Failed");
        }
        if (str.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.f123394s)) {
            boolean d16 = d();
            return new com.tencent.luggage.wxa.ff.h(d16 ? 0 : -2, d16 ? "Success" : "Failed");
        }
        if (str.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.K)) {
            z16 = jSONObject != null && b(jSONObject);
            return new com.tencent.luggage.wxa.ff.h(z16 ? 0 : -2, z16 ? "Success" : "Failed");
        }
        if (str.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.L)) {
            boolean c16 = c();
            return new com.tencent.luggage.wxa.ff.h(c16 ? 0 : -2, c16 ? "Success" : "Failed");
        }
        return new com.tencent.luggage.wxa.ff.h(-4, "invalid operate command");
    }

    private boolean b(@NonNull JSONObject jSONObject) {
        if (!f()) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "applyMakeup, useCustomEffect is false");
            return false;
        }
        return c(jSONObject);
    }

    private boolean d() {
        if (!f()) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "clearStickers, useCustomEffect is false");
            return false;
        }
        a();
        com.tencent.luggage.wxa.tn.w.a(f146997f, com.tencent.luggage.wxa.c8.c.f123394s);
        this.f147001c.e();
        return true;
    }

    private void a(Bundle bundle, boolean z16) {
        if (z16 || bundle.keySet().size() != 0) {
            this.f147003e = bundle.getBoolean(com.tencent.luggage.wxa.c8.c.f123378k, this.f147003e);
            if (f()) {
                com.tencent.luggage.wxa.tn.w.d(f146997f, "parseAndApplyParams, useCustomEffect");
                d(bundle);
                c(bundle);
                b(bundle);
                a(bundle);
            }
        }
    }

    private boolean c() {
        if (!f()) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "clearMakeups, useCustomEffect is false");
            return false;
        }
        a();
        com.tencent.luggage.wxa.tn.w.a(f146997f, com.tencent.luggage.wxa.c8.c.L);
        this.f147001c.d();
        return true;
    }

    private void a(@NonNull Bundle bundle) {
        a(bundle, com.tencent.luggage.wxa.c8.c.f123386o, a.b.EYE_BIGGER);
    }

    private boolean a(@NonNull JSONObject jSONObject) {
        if (!f()) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "applyFilter, useCustomEffect is false");
            return false;
        }
        String optString = jSONObject.optString("path", null);
        if (w0.c(optString)) {
            com.tencent.luggage.wxa.tn.w.f(f146997f, "applyFilter, resourcePath is null");
            return false;
        }
        float optDouble = (float) jSONObject.optDouble(com.tencent.luggage.wxa.c8.c.f123400v, 1.0d);
        if (optDouble < 0.0f) {
            com.tencent.luggage.wxa.tn.w.d(f146997f, "applyFaceBeautyIfNeed, alpha(%f) is illegal", Float.valueOf(optDouble));
            optDouble = 0.0f;
        }
        if (optDouble > 1.0f) {
            com.tencent.luggage.wxa.tn.w.d(f146997f, "applyFaceBeautyIfNeed, alpha(%f)  is illegal", Float.valueOf(optDouble));
            optDouble = 1.0f;
        }
        a();
        com.tencent.luggage.wxa.tn.w.a(f146997f, "applyFilter, resourcePath: %s, alpha: %f", optString, Float.valueOf(optDouble));
        this.f147001c.a(optString, optDouble);
        return true;
    }

    private float a(@NonNull JSONObject jSONObject, @NonNull String str) {
        return a(jSONObject, str, 1.0f);
    }

    private float a(@NonNull JSONObject jSONObject, @NonNull String str, float f16) {
        float optDouble = (float) jSONObject.optDouble(str, 1.0d);
        if (optDouble < 0.0f) {
            com.tencent.luggage.wxa.tn.w.d(f146997f, "parseRate, rate(%f) is illegal", Float.valueOf(optDouble));
            optDouble = 0.0f;
        }
        if (optDouble <= 1.0f) {
            return optDouble;
        }
        com.tencent.luggage.wxa.tn.w.d(f146997f, "parseRate, rate(%f)  is illegal", Float.valueOf(optDouble));
        return 1.0f;
    }

    private void a(@NonNull Bundle bundle, @NonNull String str, @NonNull a.b bVar) {
        if (!bundle.containsKey(str)) {
            com.tencent.luggage.wxa.tn.w.a(f146997f, "applyFaceBeautyIfNeed, %s is not exist in params", str);
            return;
        }
        float f16 = 0.0f;
        float f17 = bundle.getFloat(str, 0.0f);
        if (f17 < 0.0f) {
            com.tencent.luggage.wxa.tn.w.d(f146997f, "applyFaceBeautyIfNeed, rate(%f) of %s is illegal", Float.valueOf(f17), str);
        } else {
            f16 = f17;
        }
        if (f16 > 1.0f) {
            com.tencent.luggage.wxa.tn.w.d(f146997f, "applyFaceBeautyIfNeed, rate(%f) of %s is illegal", Float.valueOf(f16), str);
            f16 = 1.0f;
        }
        a();
        com.tencent.luggage.wxa.tn.w.a(f146997f, "applyFaceBeauty, faceBeautyType: %s, rate: %f", bVar, Float.valueOf(f16));
        this.f147001c.a(bVar, f16);
    }

    private void a() {
        if (this.f147002d) {
            return;
        }
        com.tencent.luggage.wxa.tn.w.a(f146997f, "applyWeEffect");
        this.f146999a.a(this.f147001c);
        this.f147002d = true;
    }
}

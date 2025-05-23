package com.tencent.mobileqq.guild.kuikly;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.kuikly.core.render.android.d;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.guild.home.views.embeddable.KuiklyFrameLayout;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelIdList;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import i01.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J=\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042+\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fj\u0004\u0018\u0001`\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J5\u0010\u0015\u001a\u00020\u00072+\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fj\u0004\u0018\u0001`\u0011H\u0002JI\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\r2+\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fj\u0004\u0018\u0001`\u0011H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/kuikly/c;", "Li01/e;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "c", "params", "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/home/views/embeddable/KuiklyFrameLayout;", "i", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "d", "j", "l", "method", "call", "Lcom/tencent/mobileqq/guild/home/views/embeddable/KuiklyFrameLayout;", "kuiklyLayout", "<init>", "()V", "e", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private KuiklyFrameLayout kuiklyLayout;

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0025: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:38), block:B:43:0x0025 */
    private final String c(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        String encodeToString;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            if (bitmap != null) {
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream(4096);
                } catch (Exception e16) {
                    e = e16;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (byteArrayOutputStream3 != null) {
                        try {
                            byteArrayOutputStream3.flush();
                            byteArrayOutputStream3.close();
                        } catch (IOException e17) {
                            QLog.e("GameGuildKuiklyModule", 1, "bitmapToBase64" + e17);
                        }
                    }
                    throw th;
                }
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                    encodeToString = PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream2.toByteArray(), 2);
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                } catch (Exception e18) {
                    e = e18;
                    QLog.e("GameGuildKuiklyModule", 1, "bitmapToBase64" + e);
                    if (byteArrayOutputStream2 == null) {
                        return null;
                    }
                    try {
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                        return null;
                    } catch (IOException e19) {
                        QLog.e("GameGuildKuiklyModule", 1, "bitmapToBase64" + e19);
                        return null;
                    }
                }
            } else {
                encodeToString = null;
            }
            if (byteArrayOutputStream3 != null) {
                try {
                    byteArrayOutputStream3.flush();
                    byteArrayOutputStream3.close();
                } catch (IOException e26) {
                    QLog.e("GameGuildKuiklyModule", 1, "bitmapToBase64" + e26);
                }
            }
            return encodeToString;
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream3 = byteArrayOutputStream;
        }
    }

    private final void d(String params, final Function1<Object, Unit> callback) {
        boolean z16;
        boolean z17 = true;
        if (params.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            params = "{}";
        }
        JSONObject jSONObject = new JSONObject(params);
        final String optString = jSONObject.optString("url");
        int optInt = jSONObject.optInt("reqWidth");
        int optInt2 = jSONObject.optInt("reqHeight");
        if (optString != null && optString.length() != 0) {
            z17 = false;
        }
        if (z17) {
            if (callback != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", optString);
                jSONObject2.put("retCode", -1);
                jSONObject2.put("msg", "url is empty");
                callback.invoke(jSONObject2);
                return;
            }
            return;
        }
        v.f(optString, optInt, optInt2, new GuildLevelRoleView.a() { // from class: com.tencent.mobileqq.guild.kuikly.b
            @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
            public final void a(Bitmap bitmap) {
                c.g(Function1.this, optString, this, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 function1, String str, c this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bitmap == null) {
            if (function1 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str);
                jSONObject.put("retCode", -2);
                jSONObject.put("msg", "no cache");
                function1.invoke(jSONObject);
                return;
            }
            return;
        }
        if (function1 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("url", str);
            jSONObject2.put("retCode", 0);
            jSONObject2.put("msg", "success");
            jSONObject2.put("data", this$0.c(bitmap));
            function1.invoke(jSONObject2);
        }
    }

    private final KuiklyFrameLayout i() {
        com.tencent.kuikly.core.render.android.a aVar;
        d O0;
        ViewGroup view;
        if (this.kuiklyLayout == null && (aVar = get_kuiklyRenderContext()) != null && (O0 = aVar.O0()) != null && (view = O0.getView()) != null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (parent == null) {
                    break;
                }
                if (parent instanceof KuiklyFrameLayout) {
                    this.kuiklyLayout = (KuiklyFrameLayout) parent;
                    break;
                }
                parent = parent.getParent();
            }
        }
        return this.kuiklyLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String j(String params) {
        byte b16;
        ArrayList<Integer> arrayListOf;
        boolean z16 = true;
        if (params.length() == 0) {
            b16 = true;
        } else {
            b16 = false;
        }
        if (b16 != false) {
            params = "{}";
        }
        String guildId = new JSONObject(params).optString("guildId");
        IGPSService iGPSService = (IGPSService) ch.S0(IGPSService.class, "");
        a aVar = a.f226430a;
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        long a16 = aVar.a(guildId, 0L);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(2);
        ArrayList<IGProCategoryChannelIdList> categoryChannelIdListExcludeCategoryType = iGPSService.getCategoryChannelIdListExcludeCategoryType(a16, arrayListOf);
        JSONObject jSONObject = new JSONObject();
        if (categoryChannelIdListExcludeCategoryType == null || !(!categoryChannelIdListExcludeCategoryType.isEmpty())) {
            z16 = false;
        }
        if (z16) {
            jSONObject.put("ret", 0);
            jSONObject.put("msg", "success");
            JSONArray jSONArray = new JSONArray();
            for (IGProCategoryChannelIdList iGProCategoryChannelIdList : categoryChannelIdListExcludeCategoryType) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(PictureConst.KEY_CATEGORY_TYPE, iGProCategoryChannelIdList.getCategoryType());
                jSONObject2.put(PictureConst.KEY_CATEGORY_ID, String.valueOf(iGProCategoryChannelIdList.getCategoryId()));
                jSONObject2.put("category_alias", iGProCategoryChannelIdList.getCategoryAlias());
                jSONObject2.put("is_off", iGProCategoryChannelIdList.getCloseSwitch() ? 1 : 0);
                jSONObject2.put("url", iGProCategoryChannelIdList.getUrl());
                jSONObject2.put("url_type", iGProCategoryChannelIdList.getUrlType());
                jSONObject2.put("name", iGProCategoryChannelIdList.getName());
                jSONArray.mo162put(jSONObject2);
            }
            jSONObject.put("data", jSONArray);
        } else {
            jSONObject.put("ret", -1);
            jSONObject.put("msg", " no category list");
            jSONObject.put("data", new JSONArray());
        }
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "resultJson.toString()");
        return jSONObject3;
    }

    private final void l(Function1<Object, Unit> callback) {
        KuiklyFrameLayout i3 = i();
        int[] iArr = new int[2];
        KuiklyFrameLayout kuiklyFrameLayout = this.kuiklyLayout;
        if (kuiklyFrameLayout != null) {
            kuiklyFrameLayout.getLocationOnScreen(iArr);
        }
        int screenWidth = ViewUtils.getScreenWidth() - iArr[0];
        int screenHeight = ViewUtils.getScreenHeight() - iArr[1];
        if (ScreenUtil.checkNavigationBarShow(getContext())) {
            screenHeight -= ScreenUtil.getNavigationBarHeight(getContext());
        }
        int a16 = com.tencent.guild.aio.util.c.a(screenWidth);
        int a17 = com.tencent.guild.aio.util.c.a(screenHeight);
        QLog.d("GameGuildKuiklyModule", 1, "getVisibleSize layout:" + i3 + ", widthDp:" + a16 + ", heightDp:" + a17);
        if (callback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retCode", 0);
            jSONObject.put("msg", "success");
            jSONObject.put("width", a16);
            jSONObject.put("height", a17);
            callback.invoke(jSONObject);
        }
    }

    private final void m(String params) {
        boolean z16;
        if (params.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            params = "{}";
        }
        JSONObject jSONObject = new JSONObject(params);
        int optInt = jSONObject.optInt("scrollX");
        int optInt2 = jSONObject.optInt("scrollY");
        if (QLog.isColorLevel()) {
            QLog.d("GameGuildKuiklyModule", 2, "notifyCurrentPageScroll scrollX:" + optInt + " scrollY:" + optInt2);
        }
        KuiklyFrameLayout i3 = i();
        if (i3 != null) {
            i3.i(optInt, optInt2);
        }
    }

    private final void o(String params) {
        boolean z16;
        if (params.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            params = "{}";
        }
        boolean optBoolean = new JSONObject(params).optBoolean("isDragging");
        KuiklyFrameLayout i3 = i();
        if (i3 != null) {
            i3.setKuiklyHorizontalDragging(optBoolean);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0017. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1874244203:
                if (method.equals("setHorizontalDragging")) {
                    Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
                    o((String) params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -509738403:
                if (method.equals("getVisibleSize")) {
                    l(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 768605189:
                if (method.equals("getGuildCachePic")) {
                    QLog.d("GameGuildKuiklyModule", 1, "call method=" + method + ", params=" + params);
                    Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
                    d((String) params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 900573260:
                if (method.equals("notifyCurrentPageScroll")) {
                    QLog.d("GameGuildKuiklyModule", 1, "call method=" + method + ", params=" + params);
                    Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
                    m((String) params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 961747817:
                if (method.equals("getSubTabList")) {
                    QLog.d("GameGuildKuiklyModule", 1, "call method=" + method + ", params=" + params);
                    Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
                    return j((String) params);
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }
}

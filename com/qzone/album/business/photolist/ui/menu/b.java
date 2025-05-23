package com.qzone.album.business.photolist.ui.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import b5.b;
import com.qzone.album.util.QZoneAlbumUtil;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends b5.b {

    /* renamed from: o, reason: collision with root package name */
    public static String f43695o = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumEdit", "\u7f16\u8f91\u76f8\u518c");

    /* renamed from: p, reason: collision with root package name */
    public static String f43696p = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumBigPreview", "\u5927\u56fe\u6d4f\u89c8");

    /* renamed from: q, reason: collision with root package name */
    public static String f43697q = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumSmallPreview", "\u5c0f\u56fe\u6d4f\u89c8");

    /* renamed from: r, reason: collision with root package name */
    public static String f43698r = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumQuoteBatch", "\u6279\u91cf\u8f6c\u8f7d");

    /* renamed from: s, reason: collision with root package name */
    public static String f43699s = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitleLookUpDressUp", "\u67e5\u770b\u8be5\u76f8\u518c\u88c5\u626e");

    /* renamed from: t, reason: collision with root package name */
    public static String f43700t = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumDressUp", "\u88c5\u626e\u76f8\u518c");

    /* renamed from: u, reason: collision with root package name */
    public static String f43701u = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumDlnaPlaying", "\u6295\u5c4f\u64ad\u653e");

    /* renamed from: v, reason: collision with root package name */
    public static String f43702v = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumUpdateTopic", "\u66f4\u6362\u4e3b\u9898");

    /* renamed from: w, reason: collision with root package name */
    public static String f43703w = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumUpdateTopic", "\u6dfb\u52a0\u5230\u4e3b\u5c4f\u5e55");

    /* renamed from: h, reason: collision with root package name */
    private b.c f43704h;

    /* renamed from: i, reason: collision with root package name */
    private b.c f43705i;

    /* renamed from: j, reason: collision with root package name */
    private b.c f43706j;

    /* renamed from: k, reason: collision with root package name */
    private b.c f43707k;

    /* renamed from: l, reason: collision with root package name */
    private b.c f43708l;

    /* renamed from: m, reason: collision with root package name */
    private b.c f43709m;

    /* renamed from: n, reason: collision with root package name */
    private b.c f43710n;

    public b(Context context) {
        super(context);
    }

    private void v(boolean z16) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        int i3;
        try {
            if (z16) {
                jSONObject = new JSONObject(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_HOST_MORE_POPUP_SETTING, "{\"needAddItem\":\"1\"}"));
            } else {
                jSONObject = new JSONObject(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_GUEST_MORE_POPUP_SETTING, "{\"needAddItem\":\"1\"}"));
            }
            boolean z17 = true;
            if (Integer.valueOf(jSONObject.optString("needAddItem")).intValue() == 1) {
                i3 = jSONObject.optInt("addCount");
                jSONArray = jSONObject.optJSONArray("addList");
                if (jSONArray.length() != i3) {
                    z17 = false;
                }
            } else {
                jSONArray = null;
                i3 = 0;
                z17 = false;
            }
            if (z17) {
                for (int i16 = 0; i16 < i3; i16++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i16);
                    if (jSONObject2 != null) {
                        String optString = jSONObject2.optString("title");
                        String optString2 = jSONObject2.optString("imageUrl");
                        String optString3 = jSONObject2.optString(WadlProxyConsts.KEY_JUMP_URL);
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                            b.c cVar = new b.c();
                            cVar.j(optString);
                            cVar.i(optString3);
                            ImageLoader.getInstance().loadImageAsync(optString2, new a(cVar));
                        }
                    }
                }
            }
        } catch (Exception e16) {
            com.qzone.album.env.common.a.m().g("QZonePhotoListMorePopupMenu", e16);
        }
    }

    public b.c o(int i3) {
        ArrayList<b.c> arrayList = this.f27877a;
        if (arrayList == null) {
            return null;
        }
        return arrayList.get(i3);
    }

    public void q(boolean z16) {
        if (this.f43708l == null) {
            b.c cVar = new b.c();
            this.f43708l = cVar;
            cVar.h(this.f27878b.getResources().getDrawable(R.drawable.f162199fy4));
            this.f43708l.j(f43699s);
            d(this.f43708l);
        }
        ViewGroup.LayoutParams layoutParams = this.f27880d.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        layoutParams.width = -1;
        this.f27880d.setLayoutParams(layoutParams);
        this.f43708l.k(z16);
    }

    public void r(Drawable drawable) {
        b.c cVar = this.f43707k;
        if (cVar != null) {
            cVar.h(drawable);
        }
    }

    public void s(Drawable drawable) {
        b.c cVar = this.f43708l;
        if (cVar != null) {
            cVar.h(drawable);
        }
    }

    public void t(Drawable drawable) {
        b.c cVar = this.f43706j;
        if (cVar != null) {
            cVar.h(drawable);
        }
    }

    public void u(boolean z16) {
        b.c cVar = this.f43706j;
        if (cVar != null) {
            if (z16) {
                cVar.j(f43696p);
            } else {
                cVar.j(f43697q);
            }
        }
    }

    public void w() {
        b.c cVar = this.f43705i;
        if (cVar != null) {
            cVar.k(true);
        }
        b.c cVar2 = this.f43706j;
        if (cVar2 != null) {
            cVar2.k(false);
        }
        b.c cVar3 = this.f43707k;
        if (cVar3 != null) {
            cVar3.k(true);
        }
        b.c cVar4 = this.f43709m;
        if (cVar4 != null) {
            cVar4.k(false);
        }
        this.f27880d.setPadding(0, u4.a.z().o(5.0f), 0, u4.a.z().o(5.0f));
    }

    public void x(int i3) {
        b.c cVar = this.f43705i;
        if (cVar != null) {
            cVar.k(false);
        }
        b.c cVar2 = this.f43706j;
        if (cVar2 != null) {
            cVar2.k(true);
        }
        y(i3);
    }

    public void y(int i3) {
        if (this.f43707k == null) {
            return;
        }
        if (QZoneAlbumUtil.r(i3) == 1) {
            this.f43707k.k(true);
        } else {
            this.f43707k.k(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b.c f43711d;

        a(b.c cVar) {
            this.f43711d = cVar;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            b.c cVar;
            if (drawable == null || (cVar = this.f43711d) == null) {
                return;
            }
            cVar.h(drawable);
            b.this.d(this.f43711d);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    public void p(boolean z16, int i3) {
        if (z16) {
            b.c cVar = new b.c();
            this.f43704h = cVar;
            cVar.h(this.f27878b.getResources().getDrawable(R.drawable.f162195fy0));
            this.f43704h.j(f43698r);
            d(this.f43704h);
            b.c cVar2 = new b.c();
            this.f43706j = cVar2;
            cVar2.h(this.f27878b.getResources().getDrawable(R.drawable.f162196fy1));
            this.f43706j.j(f43696p);
            d(this.f43706j);
            v(false);
            return;
        }
        b.c cVar3 = new b.c();
        this.f43705i = cVar3;
        cVar3.h(this.f27878b.getResources().getDrawable(R.drawable.fuq));
        this.f43705i.j(f43695o);
        this.f43705i.k(false);
        d(this.f43705i);
        b.c cVar4 = new b.c();
        this.f43707k = cVar4;
        cVar4.h(this.f27878b.getResources().getDrawable(R.drawable.f162199fy4));
        this.f43707k.j(f43700t);
        d(this.f43707k);
        y(i3);
        b.c cVar5 = new b.c();
        this.f43706j = cVar5;
        cVar5.h(this.f27878b.getResources().getDrawable(R.drawable.f162196fy1));
        this.f43706j.j(f43696p);
        d(this.f43706j);
        if (QZoneAlbumUtil.c()) {
            b.c cVar6 = new b.c();
            this.f43710n = cVar6;
            cVar6.h(this.f27878b.getResources().getDrawable(R.drawable.fue));
            this.f43710n.j(f43703w);
            d(this.f43710n);
            LpReportInfo_pf00064.allReport(326, 2, 49);
        }
        v(true);
    }
}

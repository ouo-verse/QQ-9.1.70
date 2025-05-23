package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class sq extends OverSeaTileProvider {

    /* renamed from: a, reason: collision with root package name */
    private sx f150375a;

    /* renamed from: b, reason: collision with root package name */
    private hi f150376b;

    /* renamed from: c, reason: collision with root package name */
    private Language f150377c;

    /* renamed from: d, reason: collision with root package name */
    private OverSeaSource f150378d;

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.sq$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f150379a;

        static {
            int[] iArr = new int[OverSeaSource.values().length];
            f150379a = iArr;
            try {
                iArr[OverSeaSource.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f150379a[OverSeaSource.SPARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public sq(@NonNull sx sxVar, OverSeaSource overSeaSource, hi hiVar) {
        super(sxVar.f150413a, sxVar.f150416d);
        this.f150377c = Language.zh;
        this.f150376b = hiVar;
        this.f150378d = overSeaSource;
        this.f150375a = sxVar;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider
    public final Bitmap getLogo(boolean z16) {
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider
    public final URL getTileUrl(int i3, int i16, int i17) {
        String replaceFirst;
        sx sxVar = this.f150375a;
        String name = this.f150377c.name();
        String str = sxVar.f150417e;
        int[] iArr = sxVar.f150418f;
        if (iArr.length == 0) {
            replaceFirst = str.replaceFirst("\\{range\\}", "");
        } else {
            replaceFirst = str.replaceFirst("\\{range\\}", Integer.toString(sx.a(i3 + i16, iArr.length)));
        }
        String replaceFirst2 = replaceFirst.replaceFirst("\\{z\\}", Integer.toString(i17)).replaceFirst("\\{x\\}", Integer.toString(i3)).replaceFirst("\\{y\\}", Integer.toString(i16)).replaceFirst("\\{style\\}", Integer.toString(sxVar.f150414b)).replaceFirst("\\{scene\\}", Integer.toString(sxVar.f150415c)).replaceFirst("\\{version\\}", Integer.toString(sxVar.f150416d)).replaceFirst("\\{ch\\}", name);
        if (replaceFirst2 != null) {
            LogUtil.c(ky.f149103i, "\u8bf7\u6c42\u6d77\u5916\u56fe\u74e6\u7247\uff1a".concat(replaceFirst2));
            try {
                return new URL(replaceFirst2);
            } catch (MalformedURLException e16) {
                LogUtil.d(Log.getStackTraceString(e16));
            }
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider
    public final boolean onLanguageChange(Language language) {
        this.f150377c = language;
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider
    public final NetResponse requestTileData(String str) {
        byte[] bArr;
        NetResponse doGet = NetManager.getInstance().builder().url(str).doGet();
        if (doGet != null) {
            bArr = doGet.data;
        } else {
            bArr = null;
        }
        if (bArr != null && bArr.length != 0 && this.f150376b != null) {
            int i3 = AnonymousClass1.f150379a[this.f150378d.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    this.f150376b.b().f148653b++;
                }
            } else {
                this.f150376b.b().f148652a++;
            }
        }
        return doGet;
    }
}

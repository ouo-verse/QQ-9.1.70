package com.tencent.qqmini.minigame.gpkg;

import com.tencent.qqmini.minigame.gpkg.GamePkgDownloadHandler;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f346450a;

    static {
        int[] iArr = new int[GamePkgDownloadHandler.MethodID.values().length];
        f346450a = iArr;
        iArr[GamePkgDownloadHandler.MethodID.PLUGIN_FAIL.ordinal()] = 1;
        iArr[GamePkgDownloadHandler.MethodID.PLUGIN_SUCCESS.ordinal()] = 2;
        iArr[GamePkgDownloadHandler.MethodID.PKG_FAIL.ordinal()] = 3;
        iArr[GamePkgDownloadHandler.MethodID.PKG_SUCCESS.ordinal()] = 4;
    }
}

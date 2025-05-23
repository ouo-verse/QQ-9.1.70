package com.tencent.mobileqq.zootopia.utils;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaDownloadBarType;
import java.io.InputStream;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGFile;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022#\u0010\n\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004J3\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2#\u0010\n\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004R0\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\u000fj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0002`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zootopia/utils/c;", "", "", "id", "Lkotlin/Function1;", "Lorg/libpag/PAGFile;", "Lkotlin/ParameterName;", "name", "pagFile", "", "callback", "c", "Lcom/tencent/sqshow/zootopia/data/ZootopiaDownloadBarType;", "pageType", "b", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "pagMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f329552a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<ZootopiaDownloadBarType, Integer> pagMap;

    static {
        HashMap<ZootopiaDownloadBarType, Integer> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(ZootopiaDownloadBarType.LIST_DOWNLOAD_BAR, Integer.valueOf(R.raw.f131037)), TuplesKt.to(ZootopiaDownloadBarType.BOTTOM_DOWNLOAD_BAR, Integer.valueOf(R.raw.f131026)));
        pagMap = hashMapOf;
    }

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(int i3, Function1 callback) {
        int available;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        InputStream openRawResource = BaseApplication.getContext().getResources().openRawResource(i3);
        Intrinsics.checkNotNullExpressionValue(openRawResource, "getContext().resources.openRawResource(id)");
        try {
            available = openRawResource.available();
        } finally {
            try {
            } finally {
            }
        }
        if (available <= 0) {
            QLog.e("ButtonLoadedUtils", 4, "readPagFromRaw error, size is 0");
            callback.invoke(null);
        } else {
            byte[] bArr = new byte[available];
            openRawResource.read(bArr, 0, available);
            callback.invoke(PAGFile.Load(bArr));
        }
    }

    public final void b(ZootopiaDownloadBarType pageType, Function1<? super PAGFile, Unit> callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Integer num = pagMap.get(pageType);
        if (num != null) {
            f329552a.c(num.intValue(), callback);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            callback.invoke(null);
        }
    }

    public final void c(final int id5, final Function1<? super PAGFile, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.utils.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(id5, callback);
            }
        }, 64, null, true);
    }
}

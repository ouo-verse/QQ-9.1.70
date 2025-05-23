package com.tencent.mobileqq.wink.newalbum.processor.poi;

import android.media.ExifInterface;
import com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp;
import com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/processor/poi/a;", "", "Lcom/tencent/mobileqq/wink/newalbum/processor/d;", "context", "Lcom/tencent/mobileqq/wink/newalbum/database/WinkNewAlbumDatabaseImp;", TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "", "a", "", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f324300a = new a();

    a() {
    }

    public final void a(@NotNull WinkNewAlbumContext context, @NotNull WinkNewAlbumDatabaseImp db5) {
        boolean z16;
        List<z83.a> listOf;
        boolean z17;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(db5, "db");
        if (context.getMetaData().getLatitude() == -1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (context.getMetaData().getLongitude() == -1.0f) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                return;
            }
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            float[] fArr = new float[2];
            if (new ExifInterface(context.getMetaData().getPath()).getLatLong(fArr)) {
                z83.a metaData = context.getMetaData();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(fArr[0])}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                metaData.L(Float.parseFloat(format));
                z83.a metaData2 = context.getMetaData();
                String format2 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(fArr[1])}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                metaData2.M(Float.parseFloat(format2));
            } else {
                context.getMetaData().L(0.0f);
                context.getMetaData().M(0.0f);
            }
            listOf = CollectionsKt__CollectionsJVMKt.listOf(context.getMetaData());
            db5.V(listOf, null);
            QLog.d(WinkNewAlbumPoiCollectorProcessor.INSTANCE.a(), 4, "gpscost:" + (System.currentTimeMillis() - currentTimeMillis) + " latitude:" + context.getMetaData().getLatitude() + ", longtitude:" + context.getMetaData().getLongitude() + ", path:" + context.getMetaData().getPath());
        } catch (Exception e16) {
            QLog.e(WinkNewAlbumPoiCollectorProcessor.INSTANCE.a(), 1, e16, new Object[0]);
        }
    }

    public final boolean b(@NotNull WinkNewAlbumContext context) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Intrinsics.checkNotNullParameter(context, "context");
        if (context.getMetaData().getLatitude() == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (context.getMetaData().getLongitude() == 0.0f) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                if (context.getMetaData().getLatitude() == -1.0f) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18) {
                    if (context.getMetaData().getLongitude() == -1.0f) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (!z19) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

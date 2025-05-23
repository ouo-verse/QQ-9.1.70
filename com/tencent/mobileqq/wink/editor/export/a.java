package com.tencent.mobileqq.wink.editor.export;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0004J\u0010\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0016\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/export/a;", "", "", "a", "", "durationMs", "e", "", "videoWidth", "videoHeight", "duration", "b", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "winkEditDataWrapper", "c", "mediaWidth", "mediaHeight", "d", "", "", "Ljava/util/List;", "DEFAULT_WHITE_LIST", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f320174a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> DEFAULT_WHITE_LIST;

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Mi 10 Pro", "LNA-AL00o", "DCO-AL00", "V2227A", "PFEM10"});
        DEFAULT_WHITE_LIST = listOf;
    }

    a() {
    }

    private final boolean a() {
        boolean z16;
        boolean contains$default;
        if (MobileQQ.sProcessId != 9) {
            return false;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_wink_publish_4k_video", true);
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_wink_device_white_list_of_4k_video", DEFAULT_WHITE_LIST.toString());
        String model = DeviceInfoMonitor.getModel();
        if (model == null || !isSwitchOn) {
            return false;
        }
        if (model.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) loadAsString, (CharSequence) model, false, 2, (Object) null);
            if (!contains$default) {
                return false;
            }
            return true;
        }
        return false;
    }

    private final boolean e(long durationMs) {
        if (durationMs < 30000) {
            return true;
        }
        return false;
    }

    public final boolean b(int videoWidth, int videoHeight, long duration) {
        if (a() && d(videoWidth, videoHeight) && e(duration)) {
            return true;
        }
        return false;
    }

    public final boolean c(@Nullable WinkEditDataWrapper winkEditDataWrapper) {
        boolean z16;
        ArrayList<LocalMediaInfo> originMediaInfos;
        if (!a()) {
            return false;
        }
        long j3 = 0;
        if (winkEditDataWrapper != null && (originMediaInfos = winkEditDataWrapper.getOriginMediaInfos()) != null) {
            z16 = false;
            for (LocalMediaInfo localMediaInfo : originMediaInfos) {
                boolean d16 = f320174a.d(localMediaInfo.mediaWidth, localMediaInfo.mediaHeight);
                if (!d16) {
                    return false;
                }
                j3 += localMediaInfo.mDuration;
                z16 = d16;
            }
        } else {
            z16 = false;
        }
        if (!z16 || !e(j3)) {
            return false;
        }
        return true;
    }

    public final boolean d(int mediaWidth, int mediaHeight) {
        int coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mediaWidth, mediaHeight);
        if (coerceAtLeast >= 3840) {
            return true;
        }
        return false;
    }
}

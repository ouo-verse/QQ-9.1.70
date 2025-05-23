package ce4;

import com.tencent.tav.core.AssetExportSession;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* synthetic */ class d {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f30764a;

    static {
        int[] iArr = new int[AssetExportSession.AssetExportSessionStatus.values().length];
        f30764a = iArr;
        iArr[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusExporting.ordinal()] = 1;
        iArr[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCompleted.ordinal()] = 2;
        iArr[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed.ordinal()] = 3;
        iArr[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusUnknown.ordinal()] = 4;
        iArr[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled.ordinal()] = 5;
    }
}

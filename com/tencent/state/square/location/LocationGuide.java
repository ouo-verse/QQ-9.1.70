package com.tencent.state.square.location;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.mmkv.IMMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/location/LocationGuide;", "", "()V", "open", "", "fragment", "Landroidx/fragment/app/Fragment;", "poiId", "", "openLocation", "setGuideHide", "context", "Landroid/content/Context;", "showDialogIfNeed", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class LocationGuide {
    /* JADX INFO: Access modifiers changed from: private */
    public final void openLocation(Fragment fragment, String poiId) {
        Square.INSTANCE.getConfig().getRouter().routeToLocationPage(fragment, poiId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setGuideHide(Context context) {
        IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Location.LOCATION_GUIDE_FLAG, false, null, false, 12, null);
    }

    private final boolean showDialogIfNeed(Context context) {
        return IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Location.LOCATION_GUIDE_FLAG, true, null, false, 12, null);
    }

    public final void open(final Fragment fragment, final String poiId) {
        final Context context;
        Intrinsics.checkNotNullParameter(poiId, "poiId");
        if (fragment == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        if (showDialogIfNeed(context)) {
            LocationDialogTips.INSTANCE.showDialog(context, new IGuide() { // from class: com.tencent.state.square.location.LocationGuide$open$1
                @Override // com.tencent.state.square.location.IGuide
                public void onGuideHide() {
                    LocationGuide.this.setGuideHide(context);
                    LocationGuide.this.openLocation(fragment, poiId);
                }
            });
        } else {
            openLocation(fragment, poiId);
        }
    }
}

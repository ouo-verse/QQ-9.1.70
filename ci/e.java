package ci;

import androidx.exifinterface.media.ExifInterface;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u001b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\"\u0010\u001f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010+\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&\u00a8\u0006."}, d2 = {"Lci/e;", "Lci/i;", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "Lkotlin/collections/ArrayList;", "mediaList", "", "y", "", "M", "Z", "m0", "()Z", "t0", "(Z)V", "isRefresh", "N", "j0", "o0", "isFetchLeft", "P", "k0", "p0", "isFetchRight", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "l0", "r0", "isLeftFinish", BdhLogUtil.LogTag.Tag_Req, "n0", "u0", "isRightFinish", "", ExifInterface.LATITUDE_SOUTH, "I", "i0", "()I", "s0", "(I)V", "mediumSum", "T", "h0", "q0", "initMediaPositionInAlbum", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class e extends i {

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isRefresh;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isFetchLeft;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isFetchRight;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isLeftFinish;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isRightFinish;

    /* renamed from: S, reason: from kotlin metadata */
    private int mediumSum;

    /* renamed from: T, reason: from kotlin metadata */
    private int initMediaPositionInAlbum;

    /* renamed from: h0, reason: from getter */
    public final int getInitMediaPositionInAlbum() {
        return this.initMediaPositionInAlbum;
    }

    /* renamed from: i0, reason: from getter */
    public final int getMediumSum() {
        return this.mediumSum;
    }

    /* renamed from: j0, reason: from getter */
    public final boolean getIsFetchLeft() {
        return this.isFetchLeft;
    }

    /* renamed from: k0, reason: from getter */
    public final boolean getIsFetchRight() {
        return this.isFetchRight;
    }

    /* renamed from: l0, reason: from getter */
    public final boolean getIsLeftFinish() {
        return this.isLeftFinish;
    }

    /* renamed from: m0, reason: from getter */
    public final boolean getIsRefresh() {
        return this.isRefresh;
    }

    /* renamed from: n0, reason: from getter */
    public final boolean getIsRightFinish() {
        return this.isRightFinish;
    }

    public final void o0(boolean z16) {
        this.isFetchLeft = z16;
    }

    public final void p0(boolean z16) {
        this.isFetchRight = z16;
    }

    public final void q0(int i3) {
        this.initMediaPositionInAlbum = i3;
    }

    public final void r0(boolean z16) {
        this.isLeftFinish = z16;
    }

    public final void s0(int i3) {
        this.mediumSum = i3;
    }

    public final void t0(boolean z16) {
        this.isRefresh = z16;
    }

    public final void u0(boolean z16) {
        this.isRightFinish = z16;
    }

    @Override // ci.i
    public void y(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return;
        }
        ArrayList<RFWLayerItemMediaInfo> arrayList = new ArrayList<>();
        Iterator<CommonStMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            CommonStMedia media = it.next();
            Intrinsics.checkNotNullExpressionValue(media, "media");
            RFWLayerItemMediaInfo z16 = z(media);
            z16.setExtraData(x(media));
            arrayList.add(z16);
        }
        o(arrayList);
    }
}

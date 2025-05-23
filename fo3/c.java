package fo3;

import android.graphics.Rect;
import android.widget.FrameLayout;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.qqlive.api.displayview.IDisplayViewApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.now.pkgame.pkgame.sei.Pos;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qo3.VideoScaleData;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u000e\u001a\u00020\rJ*\u0010\u000f\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lfo3/c;", "", "Lcom/tencent/now/pkgame/pkgame/sei/Pos;", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/mobileqq/activity/richmedia/i;", QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, "", "a", "", "liveViewWidth", "liveViewHeight", "Lqo3/c;", "d", "Landroid/widget/FrameLayout$LayoutParams;", "b", "c", "Lcom/tencent/now/pkgame/pkgame/sei/Pos;", "DEFAULT_POS", "Lcom/tencent/mobileqq/activity/richmedia/i;", "DEFAULT_VIDEO_SIZE", "<init>", "()V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f400182a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Pos DEFAULT_POS = new Pos(2, 0, 364, 540, com.tencent.luggage.wxa.he.e.CTRL_INDEX);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final i DEFAULT_VIDEO_SIZE = new i(1080, 1920);

    c() {
    }

    private final boolean a(Pos pos, i videoSize) {
        if (pos == null || videoSize == null || pos.getY() >= videoSize.a() / 2) {
            return false;
        }
        return true;
    }

    private final VideoScaleData d(int liveViewWidth, int liveViewHeight, i videoSize) {
        float f16 = liveViewHeight * 1.0f;
        float f17 = liveViewWidth;
        float f18 = f16 / f17;
        int i3 = videoSize.f185861b;
        int i16 = videoSize.f185860a;
        if ((i3 * 1.0f) / i16 > f18) {
            int i17 = (int) (i3 * ((f17 * 1.0f) / i16));
            return new VideoScaleData(1, liveViewWidth, i17, 0, (i17 - liveViewHeight) / 2);
        }
        int i18 = (int) (i3 * (f16 / i3));
        return new VideoScaleData(2, i18, liveViewHeight, (i18 - liveViewWidth) / 2, 0);
    }

    @NotNull
    public final FrameLayout.LayoutParams b() {
        com.tencent.now.linkscreengame.model.d dVar = com.tencent.now.linkscreengame.model.d.f338503a;
        Rect a16 = dVar.a();
        Rect b16 = dVar.b();
        if (a16 != null && b16 != null) {
            int i3 = b16.top;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b16.right, a16.bottom - a16.top);
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = i3;
            layoutParams.bottomMargin = (ViewUtils.getScreenHeight() - layoutParams.topMargin) - layoutParams.height;
            return layoutParams;
        }
        AegisLogger.INSTANCE.e("PK_Biz|PKVideoParamsCalculator", "getAnchorPKVideoParams error", "anchorRect:" + a16 + ", linkMicRect:" + b16);
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @NotNull
    public final FrameLayout.LayoutParams c(@Nullable Pos pos, @Nullable i videoSize, int liveViewHeight, int liveViewWidth) {
        boolean z16;
        Pos pos2;
        i iVar;
        if (liveViewWidth > liveViewHeight) {
            z16 = true;
        } else {
            z16 = false;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("PK_Biz|PKVideoParamsCalculator", "getAudiencePKVideoParams, \u6a2a\u5c4f\u6d41PK:" + z16);
        if (z16) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(liveViewWidth, liveViewHeight);
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = ((IDisplayViewApi) QRoute.api(IDisplayViewApi.class)).getHorizontalVideoTopMargin(true);
            layoutParams.bottomMargin = (ViewUtils.getScreenHeight() - layoutParams.topMargin) - layoutParams.height;
            return layoutParams;
        }
        if (pos == null) {
            pos2 = DEFAULT_POS;
        } else {
            pos2 = pos;
        }
        if (videoSize == null) {
            iVar = DEFAULT_VIDEO_SIZE;
        } else {
            iVar = videoSize;
        }
        if (!a(pos, videoSize)) {
            pos2 = DEFAULT_POS;
            iVar = DEFAULT_VIDEO_SIZE;
        }
        companion.i("PK_Biz|PKVideoParamsCalculator", "video fixedPos:" + pos2 + ", fixedVideoSize:" + iVar);
        VideoScaleData d16 = d(liveViewWidth, liveViewHeight, iVar);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("video scale data: ");
        sb5.append(d16);
        companion.i("PK_Biz|PKVideoParamsCalculator", sb5.toString());
        float realScaleWidth = (d16.getRealScaleWidth() * 1.0f) / iVar.b();
        float realScaleHeight = (d16.getRealScaleHeight() * 1.0f) / iVar.a();
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(liveViewWidth, (int) (pos2.getH() * realScaleHeight));
        layoutParams2.leftMargin = ((int) (pos2.getX() * realScaleWidth)) - d16.getCropLeft();
        int y16 = ((int) (pos2.getY() * realScaleHeight)) - d16.getCropTop();
        layoutParams2.topMargin = y16;
        layoutParams2.bottomMargin = (liveViewHeight - y16) - layoutParams2.height;
        return layoutParams2;
    }
}

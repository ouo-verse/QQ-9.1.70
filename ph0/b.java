package ph0;

import android.graphics.drawable.Drawable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b<\u0010=R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010!\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b\u0011\u0010\u001c\"\u0004\b \u0010\u001eR$\u0010$\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b\"\u0010\u001c\"\u0004\b#\u0010\u001eR$\u0010(\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR\"\u0010/\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b\n\u0010,\"\u0004\b-\u0010.R\"\u00101\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010+\u001a\u0004\b*\u0010,\"\u0004\b0\u0010.R\"\u00104\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010+\u001a\u0004\b2\u0010,\"\u0004\b3\u0010.R\"\u00107\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010+\u001a\u0004\b5\u0010,\"\u0004\b6\u0010.R\"\u00109\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010+\u001a\u0004\b%\u0010,\"\u0004\b8\u0010.R\"\u0010;\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010+\u001a\u0004\b\u0019\u0010,\"\u0004\b:\u0010.\u00a8\u0006>"}, d2 = {"Lph0/b;", "", "", "a", UserInfo.SEX_FEMALE, "()F", "o", "(F)V", "bgCorner", "", "b", "I", "l", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(I)V", "textSize", "c", "g", "u", "enableTextColor", "d", "r", "disableTextColor", "Landroid/graphics/drawable/Drawable;", "e", "Landroid/graphics/drawable/Drawable;", "f", "()Landroid/graphics/drawable/Drawable;", "t", "(Landroid/graphics/drawable/Drawable;)V", "enableBgDrawable", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "disableBgDrawable", "k", "y", "progressFgDrawable", h.F, "j", HippyTKDListViewAdapter.X, "progressBgDrawable", "", "i", "Ljava/lang/String;", "()Ljava/lang/String;", "p", "(Ljava/lang/String;)V", "canDownloadContent", "w", "pausedContent", DomainData.DOMAIN_NAME, "B", "waitSubscribeContent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "waitFollowContent", "v", "installedContent", ReportConstant.COSTREPORT_PREFIX, "downloadedContent", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float bgCorner;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int textSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int enableTextColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int disableTextColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable enableBgDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable disableBgDrawable;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable progressFgDrawable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable progressBgDrawable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String canDownloadContent = "";

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pausedContent = "";

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String waitSubscribeContent = "";

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String waitFollowContent = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String installedContent = "";

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String downloadedContent = "";

    public final void A(@NotNull String str) {
        this.waitFollowContent = str;
    }

    public final void B(@NotNull String str) {
        this.waitSubscribeContent = str;
    }

    /* renamed from: a, reason: from getter */
    public final float getBgCorner() {
        return this.bgCorner;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getCanDownloadContent() {
        return this.canDownloadContent;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Drawable getDisableBgDrawable() {
        return this.disableBgDrawable;
    }

    /* renamed from: d, reason: from getter */
    public final int getDisableTextColor() {
        return this.disableTextColor;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getDownloadedContent() {
        return this.downloadedContent;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final Drawable getEnableBgDrawable() {
        return this.enableBgDrawable;
    }

    /* renamed from: g, reason: from getter */
    public final int getEnableTextColor() {
        return this.enableTextColor;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getInstalledContent() {
        return this.installedContent;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getPausedContent() {
        return this.pausedContent;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final Drawable getProgressBgDrawable() {
        return this.progressBgDrawable;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final Drawable getProgressFgDrawable() {
        return this.progressFgDrawable;
    }

    /* renamed from: l, reason: from getter */
    public final int getTextSize() {
        return this.textSize;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getWaitFollowContent() {
        return this.waitFollowContent;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getWaitSubscribeContent() {
        return this.waitSubscribeContent;
    }

    public final void o(float f16) {
        this.bgCorner = f16;
    }

    public final void p(@NotNull String str) {
        this.canDownloadContent = str;
    }

    public final void q(@Nullable Drawable drawable) {
        this.disableBgDrawable = drawable;
    }

    public final void r(int i3) {
        this.disableTextColor = i3;
    }

    public final void s(@NotNull String str) {
        this.downloadedContent = str;
    }

    public final void t(@Nullable Drawable drawable) {
        this.enableBgDrawable = drawable;
    }

    public final void u(int i3) {
        this.enableTextColor = i3;
    }

    public final void v(@NotNull String str) {
        this.installedContent = str;
    }

    public final void w(@NotNull String str) {
        this.pausedContent = str;
    }

    public final void x(@Nullable Drawable drawable) {
        this.progressBgDrawable = drawable;
    }

    public final void y(@Nullable Drawable drawable) {
        this.progressFgDrawable = drawable;
    }

    public final void z(int i3) {
        this.textSize = i3;
    }
}

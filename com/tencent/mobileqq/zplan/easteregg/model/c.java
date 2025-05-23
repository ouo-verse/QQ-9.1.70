package com.tencent.mobileqq.zplan.easteregg.model;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.easteregg.u;
import com.tencent.mobileqq.zplan.easteregg.v;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0011\u00a2\u0006\u0004\bd\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0001H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0001H\u0016R\"\u0010\u001a\u001a\u00020\u00118\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\"\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R*\u0010/\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R*\u00101\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010*\u001a\u0004\b#\u0010,\"\u0004\b0\u0010.R*\u00105\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010*\u001a\u0004\b3\u0010,\"\u0004\b4\u0010.R*\u00108\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010*\u001a\u0004\b6\u0010,\"\u0004\b7\u0010.R$\u0010>\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b2\u0010;\"\u0004\b<\u0010=R$\u0010E\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010L\u001a\u00020F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010Q\u001a\u00020M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b9\u0010N\"\u0004\bO\u0010PR\"\u0010T\u001a\u00020M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010\u001c\u001a\u0004\b)\u0010N\"\u0004\bS\u0010PR\"\u0010W\u001a\u00020F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010G\u001a\u0004\bR\u0010I\"\u0004\bV\u0010KR\"\u0010Z\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010\u001d\u001a\u0004\bX\u0010\u001f\"\u0004\bY\u0010!R$\u0010a\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b\\\u0010^\"\u0004\b_\u0010`R\"\u0010c\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001d\u001a\u0004\bU\u0010\u001f\"\u0004\bb\u0010!\u00a8\u0006e"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/model/c;", "Lcom/tencent/mobileqq/zplan/easteregg/model/f;", "Landroid/view/View;", "pagView", "", "v", "t", HippyTKDListViewAdapter.X, "Landroid/widget/ImageView;", "headView", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/graphics/drawable/Drawable;", "drawable", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "task", "", "b", "", "seq", "a", "c", "J", "getTaskId", "()J", "setTaskId", "(J)V", MiniAppGetGameTaskTicketServlet.KEY_TASKID, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, UserInfo.SEX_FEMALE, "Z", "l", "()Z", "B", "(Z)V", "interrupt", "d", "r", "G", "timestamp", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/easteregg/v;", "e", "Lmqq/util/WeakReference;", "f", "()Lmqq/util/WeakReference;", "setAvatarAnimationView", "(Lmqq/util/WeakReference;)V", "avatarAnimationView", "setAtmosphereAnimationView", "atmosphereAnimationView", "g", "j", "setBackgroundAnimationView", "backgroundAnimationView", h.F, "setAvatarHeadView", "avatarHeadView", "i", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "setAvatarDrawable", "(Landroid/graphics/drawable/Drawable;)V", "avatarDrawable", "Lcom/tencent/mobileqq/zplan/easteregg/a;", "Lcom/tencent/mobileqq/zplan/easteregg/a;", "k", "()Lcom/tencent/mobileqq/zplan/easteregg/a;", "y", "(Lcom/tencent/mobileqq/zplan/easteregg/a;)V", DownloadInfo.spKey_Config, "", "Ljava/lang/String;", ReportConstant.COSTREPORT_PREFIX, "()Ljava/lang/String;", "H", "(Ljava/lang/String;)V", "uin", "", "()F", "w", "(F)V", "avatarScale", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", "atmosphereScale", DomainData.DOMAIN_NAME, "setMSceneSource", "mSceneSource", "o", "D", "needRecord", "Lcom/tencent/mobileqq/zplan/easteregg/u$a;", "p", "Lcom/tencent/mobileqq/zplan/easteregg/u$a;", "()Lcom/tencent/mobileqq/zplan/easteregg/u$a;", "E", "(Lcom/tencent/mobileqq/zplan/easteregg/u$a;)V", "reportParam", BdhLogUtil.LogTag.Tag_Conn, "needPlay", "<init>", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long taskId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long seq;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean interrupt;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long timestamp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<v> avatarAnimationView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<v> atmosphereAnimationView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<v> backgroundAnimationView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<ImageView> avatarHeadView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable avatarDrawable;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.zplan.easteregg.a config;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private u.EasterEggReportParam reportParam;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uin = "";

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private float avatarScale = 1.0f;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float atmosphereScale = 1.0f;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mSceneSource = "aio";

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean needRecord = true;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private volatile boolean needPlay = true;

    public c(long j3) {
        this.taskId = j3;
    }

    public final void A(@Nullable ImageView headView) {
        if (headView != null) {
            this.avatarHeadView = new WeakReference<>(headView);
        }
    }

    public final void B(boolean z16) {
        this.interrupt = z16;
    }

    public final void C(boolean z16) {
        this.needPlay = z16;
    }

    public final void D(boolean z16) {
        this.needRecord = z16;
    }

    public final void E(@Nullable u.EasterEggReportParam easterEggReportParam) {
        this.reportParam = easterEggReportParam;
    }

    public final void F(long j3) {
        this.seq = j3;
    }

    public final void G(long j3) {
        this.timestamp = j3;
    }

    public final void H(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uin = str;
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.model.f
    public boolean a(long seq) {
        if (this.seq == seq) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.model.f
    public boolean b(@NotNull f task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (!(task instanceof c) || this.seq != ((c) task).seq) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.model.f
    public boolean c(@NotNull f task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (!(task instanceof c) || getTaskId() != task.getTaskId() || this.seq != ((c) task).seq) {
            return false;
        }
        return true;
    }

    @Nullable
    public final WeakReference<v> d() {
        return this.atmosphereAnimationView;
    }

    /* renamed from: e, reason: from getter */
    public final float getAtmosphereScale() {
        return this.atmosphereScale;
    }

    @Nullable
    public final WeakReference<v> f() {
        return this.avatarAnimationView;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final Drawable getAvatarDrawable() {
        return this.avatarDrawable;
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.model.f
    public long getTaskId() {
        return this.taskId;
    }

    @Nullable
    public final WeakReference<ImageView> h() {
        return this.avatarHeadView;
    }

    /* renamed from: i, reason: from getter */
    public final float getAvatarScale() {
        return this.avatarScale;
    }

    @Nullable
    public final WeakReference<v> j() {
        return this.backgroundAnimationView;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final com.tencent.mobileqq.zplan.easteregg.a getConfig() {
        return this.config;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getInterrupt() {
        return this.interrupt;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getMSceneSource() {
        return this.mSceneSource;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getNeedPlay() {
        return this.needPlay;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getNeedRecord() {
        return this.needRecord;
    }

    @Nullable
    /* renamed from: p, reason: from getter */
    public final u.EasterEggReportParam getReportParam() {
        return this.reportParam;
    }

    /* renamed from: q, reason: from getter */
    public final long getSeq() {
        return this.seq;
    }

    /* renamed from: r, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public final void t(@Nullable View pagView) {
        if (pagView != null && (pagView instanceof v)) {
            this.atmosphereAnimationView = new WeakReference<>(pagView);
        }
    }

    public final void u(float f16) {
        this.atmosphereScale = f16;
    }

    public final void v(@Nullable View pagView) {
        if (pagView != null && (pagView instanceof v)) {
            this.avatarAnimationView = new WeakReference<>(pagView);
        }
    }

    public final void w(float f16) {
        this.avatarScale = f16;
    }

    public final void x(@Nullable View pagView) {
        if (pagView != null && (pagView instanceof v)) {
            this.backgroundAnimationView = new WeakReference<>(pagView);
        }
    }

    public final void y(@Nullable com.tencent.mobileqq.zplan.easteregg.a aVar) {
        this.config = aVar;
    }

    public final void z(@Nullable Drawable drawable) {
        if (drawable != null) {
            this.avatarDrawable = drawable;
        }
    }
}

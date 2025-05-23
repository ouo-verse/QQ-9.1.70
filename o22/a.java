package o22;

import android.content.Intent;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.mobileqq.icgame.base.room.f;
import com.tencent.mobileqq.icgame.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.room.LiveVideoStatus;
import com.tencent.mobileqq.qqlive.data.room.LiveWatchMediaInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import i22.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 32\u00020\u00012\u00020\u0002:\u0001\u001bB\u000f\u0012\u0006\u0010$\u001a\u00020\"\u00a2\u0006\u0004\b1\u00102J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020\fH\u0016J\b\u0010!\u001a\u00020\fH\u0016R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010#R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010&R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010,R\u0016\u00100\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00064"}, d2 = {"Lo22/a;", "", "Lo22/b;", "Landroid/content/Intent;", "intent", "", "b", "o", "Lcom/tencent/mobileqq/icgame/data/room/LiveInfo;", "liveInfo", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "c", "Lcom/tencent/mobileqq/icgame/data/anchor/room/QQLiveAnchorRoomInfo;", "getAnchorRoomInfo", "", "roomId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getRoomId", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "extra", "f", "k", "", WebAccelerateHelper.KEY_PRELOAD_URL, "r", "a", "", "getRoomType", "show", "e", "j", ReportConstant.COSTREPORT_PREFIX, "Lg32/h;", "Lg32/h;", "trigger", "Landroid/content/Intent;", "Lcom/tencent/mobileqq/icgame/data/room/LiveInfo;", "curLiveInfo", "d", "J", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "extraInfo", "Ljava/lang/String;", "preLoadVideoUrl", "g", "Z", "showFloatWindow", "<init>", "(Lg32/h;)V", h.F, "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g32.h trigger;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Intent intent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LiveInfo curLiveInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LiveRoomExtraInfo extraInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String preLoadVideoUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean showFloatWindow;

    public a(@NotNull g32.h trigger) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        this.trigger = trigger;
        this.roomId = -1L;
        this.preLoadVideoUrl = "";
    }

    @Override // o22.b
    @Nullable
    /* renamed from: a, reason: from getter */
    public String getPreLoadVideoUrl() {
        return this.preLoadVideoUrl;
    }

    public void b(@Nullable Intent intent) {
        this.intent = intent;
        if (intent != null) {
            this.trigger.w0(new j(intent));
        }
    }

    @Override // o22.b
    public boolean c() {
        return false;
    }

    @Override // o22.b
    public void e(boolean show) {
        this.showFloatWindow = show;
    }

    @Override // o22.b
    public void f(@Nullable LiveRoomExtraInfo extra) {
        this.extraInfo = extra;
    }

    @Override // o22.b
    @Nullable
    public QQLiveAnchorRoomInfo getAnchorRoomInfo() {
        f.a("ICGameRoomInfoAdapterImpl", "\u89c2\u4f17\u7aef\u4e0d\u53ef\u4ee5\u83b7\u53d6\u4e3b\u64ad\u623f\u95f4\u6570\u636e,\u8bf7\u901a\u8fc7getLiveInfo\u83b7\u53d6");
        return null;
    }

    @Override // o22.b
    public long getRoomId() {
        return this.roomId;
    }

    @Override // o22.b
    public int getRoomType() {
        LiveRoomExtraInfo liveRoomExtraInfo = this.extraInfo;
        if (liveRoomExtraInfo != null) {
            return liveRoomExtraInfo.f114882f;
        }
        return 0;
    }

    @Override // o22.b
    /* renamed from: j, reason: from getter */
    public boolean getShowFloatWindow() {
        return this.showFloatWindow;
    }

    @Override // o22.b
    @Nullable
    /* renamed from: k, reason: from getter */
    public LiveRoomExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    @Override // o22.b
    public void m(long roomId) {
        this.roomId = roomId;
    }

    @Override // o22.b
    public void n(@NotNull LiveInfo liveInfo) {
        Intrinsics.checkNotNullParameter(liveInfo, "liveInfo");
        this.curLiveInfo = liveInfo;
    }

    @Override // o22.b
    @Nullable
    /* renamed from: o, reason: from getter */
    public Intent getIntent() {
        return this.intent;
    }

    @Override // o22.b
    @Nullable
    /* renamed from: q, reason: from getter */
    public LiveInfo getCurLiveInfo() {
        return this.curLiveInfo;
    }

    @Override // o22.b
    public void r(@Nullable String preloadUrl) {
        this.preLoadVideoUrl = preloadUrl;
    }

    @Override // o22.b
    public boolean s() {
        LiveWatchMediaInfo liveWatchMediaInfo;
        LiveInfo liveInfo = this.curLiveInfo;
        if (liveInfo != null) {
            liveWatchMediaInfo = liveInfo.watchMediaInfo;
        } else {
            liveWatchMediaInfo = null;
        }
        if (liveWatchMediaInfo == null || liveWatchMediaInfo.mVideoStatus != LiveVideoStatus.Stop) {
            return false;
        }
        return true;
    }
}

package fm1;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b!\u0018\u0000 &2\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010!\u001a\u00020\u0004\u0012\u0006\u0010#\u001a\u00020\u000e\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0006\u0010\u0019\u001a\u00020\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\"R\u0016\u0010$\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\"R$\u0010*\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e8F@BX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010,R\u0014\u00101\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u0010\u001eR$\u00106\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u00108\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u0010'\u00a8\u0006;"}, d2 = {"Lfm1/c;", "Lfm1/i;", "", "f", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "", DomainData.DOMAIN_NAME, "", "getType", "", "getVideoDuration", "getWidth", "getHeight", "", "getTaskId", "b", "getPath", "newPath", "o", "a", "c", "getExtra", "extra", tl.h.F, "k", "Lorg/json/JSONObject;", "g", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "j", "()Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "setRealInfo", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V", "realInfo", "Ljava/lang/String;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "extras", "value", "d", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "beforeEditPath", "i", "()I", QCircleLpReportDc010001.KEY_MAINTYPE, "getSubType", QCircleLpReportDc010001.KEY_SUBTYPE, "e", "rawLocalMedia", "l", "()Z", "p", "(Z)V", "isQuality", "getThumbUrl", "thumbUrl", "<init>", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements i {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LocalMediaInfo realInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String taskId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String extras;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lfm1/c$a;", "", "", HippyControllerProps.STRING, "Lfm1/c;", "a", "GAME_SHARE_MEDIA_SOURCE_TYPE", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fm1.c$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final c a(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            JSONObject jSONObject = new JSONObject(string);
            LocalMediaInfo realInfo = LocalMediaInfo.formObjectByJsonString(jSONObject.getString("realInfo"));
            String taskId = jSONObject.getString(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
            Intrinsics.checkNotNullExpressionValue(realInfo, "realInfo");
            Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
            return new c(realInfo, taskId);
        }

        Companion() {
        }
    }

    public c(@NotNull LocalMediaInfo realInfo, @NotNull String taskId) {
        Intrinsics.checkNotNullParameter(realInfo, "realInfo");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        this.realInfo = realInfo;
        this.taskId = taskId;
        this.extras = "";
        if (realInfo.thumbnailPath == null) {
            realInfo.thumbnailPath = "";
        }
        m(getDocUrl());
    }

    private final void m(String str) {
        if (TextUtils.isEmpty(getRealInfo().picPathBeforeEdit)) {
            getRealInfo().picPathBeforeEdit = str;
        }
    }

    @Override // fm1.i
    @NotNull
    public String a() {
        String jSONObject = g().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toStFeedProtocolJson().toString()");
        return jSONObject;
    }

    @Override // fm1.i
    public boolean b() {
        return Intrinsics.areEqual("image/gif", this.realInfo.mMimeType);
    }

    @Override // fm1.i
    @NotNull
    /* renamed from: c */
    public String getVideoCoverUrl() {
        String str = this.realInfo.thumbnailPath;
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final String d() {
        if (!TextUtils.isEmpty(getRealInfo().picPathBeforeEdit)) {
            String str = getRealInfo().picPathBeforeEdit;
            Intrinsics.checkNotNullExpressionValue(str, "rawLocalMedia.picPathBeforeEdit");
            return str;
        }
        return "";
    }

    @Override // fm1.i
    @NotNull
    /* renamed from: e, reason: from getter */
    public LocalMediaInfo getRealInfo() {
        return this.realInfo;
    }

    @Override // fm1.i
    public boolean f() {
        return true;
    }

    @Override // fm1.i
    @NotNull
    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("realInfo", this.realInfo.toJsonString());
        jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, this.taskId);
        return jSONObject;
    }

    @Override // fm1.i
    @NotNull
    /* renamed from: getExtra, reason: from getter */
    public String getExtras() {
        return this.extras;
    }

    @Override // fm1.i
    public int getHeight() {
        LocalMediaInfo localMediaInfo = this.realInfo;
        if (localMediaInfo.rotation % 180 != 0) {
            return localMediaInfo.mediaWidth;
        }
        return localMediaInfo.mediaHeight;
    }

    @Override // fm1.i
    @NotNull
    /* renamed from: getPath */
    public String getDocUrl() {
        String str = this.realInfo.path;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // fm1.i
    /* renamed from: getSubType */
    public int getUrlType() {
        return QAlbumUtil.getMediaType(this.realInfo);
    }

    @Override // fm1.i
    @NotNull
    public String getTaskId() {
        return this.taskId;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        if (r0 == null) goto L12;
     */
    @Override // fm1.i
    @NotNull
    /* renamed from: getThumbUrl */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getImageUrl() {
        boolean z16;
        String str = this.realInfo.thumbnailPath;
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                str = null;
            }
        }
        str = this.realInfo.path;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // fm1.i
    public int getType() {
        return QAlbumUtil.getMediaType(this.realInfo);
    }

    @Override // fm1.i
    public long getVideoDuration() {
        return this.realInfo.mDuration;
    }

    @Override // fm1.i
    public int getWidth() {
        LocalMediaInfo localMediaInfo = this.realInfo;
        if (localMediaInfo.rotation % 180 != 0) {
            return localMediaInfo.mediaHeight;
        }
        return localMediaInfo.mediaWidth;
    }

    @Override // fm1.i
    public void h(@NotNull String extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.extras = extra;
    }

    @Override // fm1.i
    public int i() {
        return 0;
    }

    @NotNull
    public final LocalMediaInfo j() {
        return this.realInfo;
    }

    public final boolean k() {
        return Intrinsics.areEqual(getExtras(), "game_share_media_source_type");
    }

    public final boolean l() {
        return getRealInfo().isRwa;
    }

    public final void n(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        this.realInfo = localMediaInfo;
    }

    public void o(@NotNull String newPath) {
        Intrinsics.checkNotNullParameter(newPath, "newPath");
        this.realInfo.path = newPath;
        if (b()) {
            this.realInfo.mMimeType = "image";
        }
    }

    public final void p(boolean z16) {
        getRealInfo().isRwa = z16;
    }
}

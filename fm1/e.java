package fm1;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import fm1.i;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 22\u00020\u0001:\u0001\u000eBW\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\n\u0012\u0006\u0010 \u001a\u00020\u0006\u0012\u0006\u0010!\u001a\u00020\u0004\u0012\u0006\u0010#\u001a\u00020\u0004\u0012\u0006\u0010$\u001a\u00020\n\u0012\u0006\u0010%\u001a\u00020\n\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020\n\u0012\u0006\u0010+\u001a\u00020\n\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\nR\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\"\u0010\u001e\u001a\u00020\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001fR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0017R\u0014\u0010$\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010%\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0019R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u0019R\u0014\u0010+\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u0014\u0010-\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010,R\u0014\u0010/\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010,\u00a8\u00063"}, d2 = {"Lfm1/e;", "Lfm1/i;", "", "f", "", "getType", "", "getVideoDuration", "getWidth", "getHeight", "", "getTaskId", "getPath", "getExtra", "a", "b", "c", "Lorg/json/JSONObject;", "g", "isQuality", "Lfm1/c;", "j", "d", "I", "mediaType", "Ljava/lang/String;", "getThumbUrl", "()Ljava/lang/String;", "setThumbUrl", "(Ljava/lang/String;)V", "thumbUrl", "J", "videoDuration", "width", "e", "height", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "svrUrl", tl.h.F, "Z", NodeProps.CUSTOM_PROP_ISGIF, "i", "videoCover", "svrContentJson", "()I", QCircleLpReportDc010001.KEY_MAINTYPE, "getSubType", QCircleLpReportDc010001.KEY_SUBTYPE, "<init>", "(ILjava/lang/String;JIILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "k", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e implements i {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int mediaType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String thumbUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long videoDuration;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int width;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int height;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String taskId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String svrUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isGif;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String videoCover;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String svrContentJson;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lfm1/e$a;", "", "", HippyControllerProps.STRING, "Lfm1/e;", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fm1.e$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final e a(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            JSONObject jSONObject = new JSONObject(string);
            int i3 = jSONObject.getInt("mediaType");
            String string2 = jSONObject.getString("thumbUrl");
            Intrinsics.checkNotNullExpressionValue(string2, "mediaJson.getString(\"thumbUrl\")");
            long j3 = jSONObject.getLong("videoDuration");
            int i16 = jSONObject.getInt("width");
            int i17 = jSONObject.getInt("height");
            String string3 = jSONObject.getString(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
            Intrinsics.checkNotNullExpressionValue(string3, "mediaJson.getString(\"taskId\")");
            String string4 = jSONObject.getString("svrUrl");
            Intrinsics.checkNotNullExpressionValue(string4, "mediaJson.getString(\"svrUrl\")");
            boolean optBoolean = jSONObject.optBoolean(NodeProps.CUSTOM_PROP_ISGIF);
            String optString = jSONObject.optString("videoCover");
            Intrinsics.checkNotNullExpressionValue(optString, "mediaJson.optString(\"videoCover\")");
            String optString2 = jSONObject.optString("svrContentJson");
            Intrinsics.checkNotNullExpressionValue(optString2, "mediaJson.optString(\"svrContentJson\")");
            return new e(i3, string2, j3, i16, i17, string3, string4, optBoolean, optString, optString2);
        }

        Companion() {
        }
    }

    public e(int i3, @NotNull String thumbUrl, long j3, int i16, int i17, @NotNull String taskId, @NotNull String svrUrl, boolean z16, @NotNull String videoCover, @NotNull String svrContentJson) {
        Intrinsics.checkNotNullParameter(thumbUrl, "thumbUrl");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(svrUrl, "svrUrl");
        Intrinsics.checkNotNullParameter(videoCover, "videoCover");
        Intrinsics.checkNotNullParameter(svrContentJson, "svrContentJson");
        this.mediaType = i3;
        this.thumbUrl = thumbUrl;
        this.videoDuration = j3;
        this.width = i16;
        this.height = i17;
        this.taskId = taskId;
        this.svrUrl = svrUrl;
        this.isGif = z16;
        this.videoCover = videoCover;
        this.svrContentJson = svrContentJson;
    }

    @Override // fm1.i
    @NotNull
    public String a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mediaType", this.mediaType);
        jSONObject.put("thumbUrl", getThumbUrl());
        jSONObject.put("videoDuration", this.videoDuration);
        jSONObject.put("width", this.width);
        jSONObject.put("height", this.height);
        jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, this.taskId);
        jSONObject.put("svrUrl", this.svrUrl);
        jSONObject.put(NodeProps.CUSTOM_PROP_ISGIF, this.isGif);
        jSONObject.put("videoCover", this.videoCover);
        jSONObject.put("svrContentJson", this.svrContentJson);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    @Override // fm1.i
    /* renamed from: b, reason: from getter */
    public boolean getIsGif() {
        return this.isGif;
    }

    @Override // fm1.i
    @NotNull
    /* renamed from: c, reason: from getter */
    public String getVideoCover() {
        return this.videoCover;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getSvrUrl() {
        return this.svrUrl;
    }

    @Override // fm1.i
    @Nullable
    /* renamed from: e */
    public LocalMediaInfo getRealInfo() {
        return i.a.a(this);
    }

    @Override // fm1.i
    public boolean f() {
        return false;
    }

    @Override // fm1.i
    @NotNull
    public JSONObject g() {
        return new JSONObject();
    }

    @Override // fm1.i
    @NotNull
    /* renamed from: getExtra, reason: from getter */
    public String getSvrContentJson() {
        return this.svrContentJson;
    }

    @Override // fm1.i
    public int getHeight() {
        return this.height;
    }

    @Override // fm1.i
    @NotNull
    /* renamed from: getPath */
    public String getVideoPlayUrl() {
        return this.svrUrl;
    }

    @Override // fm1.i
    /* renamed from: getSubType, reason: from getter */
    public int getMediaType() {
        return this.mediaType;
    }

    @Override // fm1.i
    @NotNull
    public String getTaskId() {
        return this.taskId;
    }

    @Override // fm1.i
    @NotNull
    public String getThumbUrl() {
        return this.thumbUrl;
    }

    @Override // fm1.i
    public int getType() {
        return this.mediaType;
    }

    @Override // fm1.i
    public long getVideoDuration() {
        return this.videoDuration;
    }

    @Override // fm1.i
    public int getWidth() {
        return this.width;
    }

    @Override // fm1.i
    public void h(@NotNull String str) {
        i.a.b(this, str);
    }

    @Override // fm1.i
    public int i() {
        return 0;
    }

    @NotNull
    public final c j(boolean isQuality) {
        String str;
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.path = getVideoPlayUrl();
        if (d.e(this)) {
            str = "video";
        } else if (getIsGif()) {
            str = "image/gif";
        } else {
            str = "image";
        }
        localMediaInfo.mMimeType = str;
        localMediaInfo.isRwa = isQuality;
        return new c(localMediaInfo, com.tencent.mobileqq.guild.feed.nativepublish.publish.a.f222223a.b());
    }
}

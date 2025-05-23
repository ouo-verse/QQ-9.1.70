package com.tencent.mobileqq.gamecenter.data;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0003B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0016\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0016\u0010\u0017\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/p;", "", "", "a", "I", "source", "", "b", "Ljava/lang/String;", "url", "", "c", "J", "lastStartPrepareTime", "d", "lastBufferingStartTime", "e", "videoFps", "f", "dropFrameRecordStr", "", "g", UserInfo.SEX_FEMALE, "avgDropFrame", "<init>", "(ILjava/lang/String;)V", tl.h.F, "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class p {

    /* renamed from: i, reason: collision with root package name */
    private static final int f212067i = 0;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public String url;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public long lastStartPrepareTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public long lastBufferingStartTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public long videoFps;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String dropFrameRecordStr;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public float avgDropFrame;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: j, reason: collision with root package name */
    private static final int f212068j = 1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\bR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/p$a;", "", "", "SOURCE_HIPPY", "I", "a", "()I", "getSOURCE_HIPPY$annotations", "()V", "SOURCE_KUIKLY", "b", "getSOURCE_KUIKLY$annotations", "<init>", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.data.p$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return p.f212067i;
        }

        public final int b() {
            return p.f212068j;
        }

        Companion() {
        }
    }

    public p(int i3, @Nullable String str) {
        this.source = i3;
        this.url = str;
        this.dropFrameRecordStr = "";
    }

    public /* synthetic */ p(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? "" : str);
    }
}

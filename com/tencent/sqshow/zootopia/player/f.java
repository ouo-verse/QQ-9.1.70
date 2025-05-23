package com.tencent.sqshow.zootopia.player;

import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.sqshow.zootopia.player.preload.bean.VideoUrlBean;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 \u000e2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b@\u0010AJ\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tJ\b\u0010\f\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u000e\u001a\u00020\u00002\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\rJ\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\rJ\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0017J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0017J\b\u0010 \u001a\u0004\u0018\u00010\u0002J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0002J\b\u0010$\u001a\u0004\u0018\u00010#J\u0010\u0010&\u001a\u00020\u00002\b\u0010%\u001a\u0004\u0018\u00010#J\b\u0010'\u001a\u0004\u0018\u00010#J\u0010\u0010)\u001a\u00020\u00002\b\u0010(\u001a\u0004\u0018\u00010#J\u0010\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\rJ\u0018\u0010,\u001a\u00020\u00002\u0010\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\rR\u0016\u0010.\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010/R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010/R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u00101R\u0016\u00104\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u00103R\u0016\u00105\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u00106R \u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u00108R \u0010:\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010/R\u0016\u0010?\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00103\u00a8\u0006B"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/f;", "", "", "url", "p", "d", "fileId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "Lpu4/g;", "stVideoUrl", "v", tl.h.F, "", "o", "c", "vid", HippyTKDListViewAdapter.X, "j", "Lcom/tencent/sqshow/zootopia/player/e;", "listenerSet", "l", "b", "", "hasHitCache", "t", "k", "", "predictSpeed", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "hasDownLevel", DomainData.DOMAIN_NAME, "f", "realPlayUrl", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/sqshow/zootopia/player/preload/bean/VideoUrlBean;", "e", "realPlayBean", "r", "g", "serverPlayBean", "u", "i", "vecUrlBean", "w", "I", "mPredictSpeed", "Ljava/lang/String;", "playUrl", "Lcom/tencent/sqshow/zootopia/player/e;", "playerListenerSet", "Z", "mHasDownLevel", "mNeedToDownLevelUrl", "Lpu4/g;", "stVideoMaterial", "Ljava/util/List;", "materialList", "mVecUrlBean", "Lcom/tencent/sqshow/zootopia/player/preload/bean/VideoUrlBean;", "mServerPlayBean", "mRealPlayBean", "mRealPlayUrl", "mSelectUrlHitCache", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String playUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String fileId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String vid;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mHasDownLevel;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedToDownLevelUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private pu4.g stVideoMaterial;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private List<pu4.g> materialList;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private List<VideoUrlBean> mVecUrlBean;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private VideoUrlBean mServerPlayBean;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private VideoUrlBean mRealPlayBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String mRealPlayUrl;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean mSelectUrlHitCache;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mPredictSpeed = ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private e playerListenerSet = new e();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/f$a;", "", "Lcom/tencent/sqshow/zootopia/player/f;", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.player.f$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final f a() {
            return new f();
        }

        Companion() {
        }
    }

    public final String a() {
        if (!TextUtils.isEmpty(this.fileId)) {
            return this.fileId;
        }
        return f();
    }

    /* renamed from: b, reason: from getter */
    public final e getPlayerListenerSet() {
        return this.playerListenerSet;
    }

    public final List<pu4.g> c() {
        return this.materialList;
    }

    public final String d() {
        String str = this.playUrl;
        if (str == null || str.length() == 0) {
            return "";
        }
        String str2 = this.playUrl;
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    /* renamed from: e, reason: from getter */
    public final VideoUrlBean getMRealPlayBean() {
        return this.mRealPlayBean;
    }

    public final String f() {
        VideoUrlBean videoUrlBean = this.mRealPlayBean;
        if (videoUrlBean != null) {
            Intrinsics.checkNotNull(videoUrlBean);
            return videoUrlBean.getMUrl();
        }
        if (TextUtils.isEmpty(this.mRealPlayUrl)) {
            return d();
        }
        return this.mRealPlayUrl;
    }

    /* renamed from: g, reason: from getter */
    public final VideoUrlBean getMServerPlayBean() {
        return this.mServerPlayBean;
    }

    /* renamed from: h, reason: from getter */
    public final pu4.g getStVideoMaterial() {
        return this.stVideoMaterial;
    }

    public final List<VideoUrlBean> i() {
        return this.mVecUrlBean;
    }

    public final String j() {
        String str = this.vid;
        if (str == null || str.length() == 0) {
            return a();
        }
        String str2 = this.vid;
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getMNeedToDownLevelUrl() {
        return this.mNeedToDownLevelUrl;
    }

    public final f n(boolean hasDownLevel) {
        this.mHasDownLevel = hasDownLevel;
        return this;
    }

    public final f o(List<pu4.g> stVideoUrl) {
        this.materialList = stVideoUrl;
        return this;
    }

    public final f p(String url) {
        this.playUrl = url;
        return this;
    }

    public final f q(int predictSpeed) {
        this.mPredictSpeed = predictSpeed;
        return this;
    }

    public final f r(VideoUrlBean realPlayBean) {
        this.mRealPlayBean = realPlayBean;
        return this;
    }

    public final f s(String realPlayUrl) {
        Intrinsics.checkNotNullParameter(realPlayUrl, "realPlayUrl");
        if (TextUtils.isEmpty(realPlayUrl)) {
            realPlayUrl = "";
        }
        this.mRealPlayUrl = realPlayUrl;
        return this;
    }

    public final f t(boolean hasHitCache) {
        this.mSelectUrlHitCache = hasHitCache;
        return this;
    }

    public final f u(VideoUrlBean serverPlayBean) {
        this.mServerPlayBean = serverPlayBean;
        return this;
    }

    public final f v(pu4.g stVideoUrl) {
        this.stVideoMaterial = stVideoUrl;
        return this;
    }

    public final f w(List<VideoUrlBean> vecUrlBean) {
        this.mVecUrlBean = vecUrlBean;
        return this;
    }

    public final f x(String vid) {
        this.vid = vid;
        return this;
    }

    public final f m(String fileId) {
        if (fileId == null || fileId.length() == 0) {
            this.fileId = "";
        }
        this.fileId = fileId;
        return this;
    }

    public final f l(e listenerSet) {
        if (listenerSet == null) {
            return this;
        }
        this.playerListenerSet = listenerSet;
        return this;
    }
}

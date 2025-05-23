package com.tencent.sqshow.zootopia.player.preload.bean;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.publish.business.model.UploadVideoObject;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pu4.g;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b1\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 H2\u00020\u0001:\u0001IB\u0013\b\u0016\u0012\b\u0010C\u001a\u0004\u0018\u00010B\u00a2\u0006\u0004\bD\u0010EB\u0011\b\u0014\u0012\u0006\u0010F\u001a\u00020\u0004\u00a2\u0006\u0004\bD\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\f\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\f\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010R\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b)\u0010\u0010R\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\f\u001a\u0004\b,\u0010\u000e\"\u0004\b-\u0010\u0010R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\f\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u0010R\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\f\u001a\u0004\b4\u0010\u000e\"\u0004\b5\u0010\u0010R$\u0010:\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\u0013\u001a\u0004\b8\u0010\u0015\"\u0004\b9\u0010\u0017R\"\u0010A\u001a\u00020;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u00103\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@\u00a8\u0006J"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/preload/bean/VideoUrlBean;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "dest", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "toString", "d", "I", "b", "()I", "setMFormatId", "(I)V", "mFormatId", "e", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setMUrl", "(Ljava/lang/String;)V", "mUrl", "getMHost", "setMHost", "mHost", h.F, "getMShortSide", "setMShortSide", "mShortSide", "i", "getMLongSide", "setMLongSide", "mLongSide", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "setMVideoEncode", "mVideoEncode", BdhLogUtil.LogTag.Tag_Conn, "j", "mRate", "D", "getMResolutionLevel", "setMResolutionLevel", "mResolutionLevel", "E", "getMPlayLevel", "setMPlayLevel", "mPlayLevel", UserInfo.SEX_FEMALE, "c", "setMLevelType", "mLevelType", "G", "getMTraceId", "setMTraceId", "mTraceId", "", "H", "getMScore", "()F", "setMScore", "(F)V", "mScore", "Lpu4/g;", WadlProxyConsts.KEY_MATERIAL, "<init>", "(Lpu4/g;)V", "in", "(Landroid/os/Parcel;)V", "CREATOR", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class VideoUrlBean implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Pattern I = Pattern.compile("(.*).f(\\d*)");
    private static final int[] J = {500, PlayerResources.ViewId.EXTENDED_VIEW_BTN_BUTTON_TEXT, 700, 1000, 1200};
    private static final int[] K = {700, 1000};

    /* renamed from: C, reason: from kotlin metadata */
    private int mRate;

    /* renamed from: D, reason: from kotlin metadata */
    private int mResolutionLevel;

    /* renamed from: E, reason: from kotlin metadata */
    private int mPlayLevel;

    /* renamed from: F, reason: from kotlin metadata */
    private int mLevelType;

    /* renamed from: G, reason: from kotlin metadata */
    private String mTraceId;

    /* renamed from: H, reason: from kotlin metadata */
    private float mScore;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mFormatId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String mHost;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mShortSide;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mLongSide;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mVideoEncode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u001f\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0015J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0003R\u001f\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010%\u001a\u00020\u001a8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b)\u0010#R\u0014\u0010*\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010+\u001a\u00020\u001a8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b+\u0010&\u00a8\u0006."}, d2 = {"Lcom/tencent/sqshow/zootopia/player/preload/bean/VideoUrlBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/sqshow/zootopia/player/preload/bean/VideoUrlBean;", "", "shorSide", "", "splitLevelList", "f", "Landroid/os/Parcel;", "parcel", "b", "size", "", h.F, "(I)[Lcom/tencent/sqshow/zootopia/player/preload/bean/VideoUrlBean;", "bean", "", "i", "Landroid/net/Uri;", "realPlayUri", "e", "", "Lpu4/g;", "materials", "g", "encodeType", "", "c", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "FORMAT_ID_PATTERN", "Ljava/util/regex/Pattern;", "d", "()Ljava/util/regex/Pattern;", "H264", "I", "H265", "KEY_TRACE_ID", "Ljava/lang/String;", "PLAY_SPLIT", "[I", "RATE_BIT", "RESOLUTION_SPLIT", "TAG", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.player.preload.bean.VideoUrlBean$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion implements Parcelable.Creator<VideoUrlBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int f(int shorSide, int[] splitLevelList) {
            int length = splitLevelList.length;
            int i3 = 0;
            for (int i16 = 0; i16 < length && shorSide > splitLevelList[i16]; i16++) {
                i3++;
            }
            return i3;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public VideoUrlBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VideoUrlBean(parcel);
        }

        public final Pattern d() {
            return VideoUrlBean.I;
        }

        public final int e(Uri realPlayUri) {
            Intrinsics.checkNotNullParameter(realPlayUri, "realPlayUri");
            try {
                Matcher matcher = d().matcher(realPlayUri.getPath());
                if (!matcher.find()) {
                    return -1;
                }
                String formatIdStr = matcher.group(2);
                Intrinsics.checkNotNullExpressionValue(formatIdStr, "formatIdStr");
                return Integer.parseInt(formatIdStr);
            } catch (Exception e16) {
                QLog.e("QFSVideoUrlBean", 1, e16.getMessage(), e16);
                return -1;
            }
        }

        public final List<VideoUrlBean> g(List<g> materials) {
            ArrayList arrayList = new ArrayList();
            List<g> list = materials;
            if (list == null || list.isEmpty()) {
                return arrayList;
            }
            Iterator<g> it = materials.iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (!TextUtils.isEmpty(next != null ? next.f427434a : null)) {
                    arrayList.add(new VideoUrlBean(next));
                }
            }
            return arrayList;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public VideoUrlBean[] newArray(int size) {
            return new VideoUrlBean[size];
        }

        Companion() {
        }

        public final void i(VideoUrlBean bean) {
            if (bean == null || bean.getMRate() != 0) {
                return;
            }
            if (bean.getMLevelType() == 8) {
                bean.j(1100);
                return;
            }
            if (bean.getMLevelType() == 9) {
                bean.j(1500);
                return;
            }
            if (bean.getMLevelType() == 10) {
                bean.j(700);
                return;
            }
            if (bean.getMLevelType() == 18) {
                bean.j(1000);
                return;
            }
            if (bean.getMLevelType() == 16) {
                bean.j(600);
            } else if (bean.getMLevelType() == 17) {
                bean.j(900);
            } else {
                bean.j(2000);
            }
        }

        public final String c(int encodeType) {
            if (encodeType == 1) {
                return "h264";
            }
            if (encodeType != 2) {
                return "\u672a\u77e5";
            }
            return UploadVideoObject.VODEO_FORMAT_H265;
        }
    }

    public VideoUrlBean(g gVar) {
        pu4.h hVar;
        pu4.h hVar2;
        Uri realPlayUri = Uri.parse(gVar != null ? gVar.f427434a : null);
        this.mUrl = gVar != null ? gVar.f427434a : null;
        this.mHost = realPlayUri.getHost();
        this.mTraceId = realPlayUri.getQueryParameter("traceid");
        Companion companion = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(realPlayUri, "realPlayUri");
        this.mFormatId = companion.e(realPlayUri);
        int i3 = 0;
        this.mShortSide = Math.min(gVar != null ? gVar.f427439f : 0, gVar != null ? gVar.f427440g : 0);
        this.mLongSide = Math.max(gVar != null ? gVar.f427439f : 0, gVar != null ? gVar.f427440g : 0);
        this.mVideoEncode = gVar != null ? gVar.f427443j : 0;
        this.mRate = (gVar != null ? gVar.f427444k : 0) / 1024;
        this.mResolutionLevel = companion.f(this.mShortSide, J);
        this.mPlayLevel = companion.f(this.mShortSide, K);
        if (gVar != null && (hVar2 = gVar.f427446m) != null) {
            i3 = hVar2.f427448a;
        }
        this.mLevelType = i3;
        this.mScore = (gVar == null || (hVar = gVar.f427446m) == null) ? 0.0f : hVar.f427450c;
        companion.i(this);
    }

    /* renamed from: b, reason: from getter */
    public final int getMFormatId() {
        return this.mFormatId;
    }

    /* renamed from: c, reason: from getter */
    public final int getMLevelType() {
        return this.mLevelType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final int getMRate() {
        return this.mRate;
    }

    /* renamed from: f, reason: from getter */
    public final String getMUrl() {
        return this.mUrl;
    }

    /* renamed from: g, reason: from getter */
    public final int getMVideoEncode() {
        return this.mVideoEncode;
    }

    public final void j(int i3) {
        this.mRate = i3;
    }

    public String toString() {
        return " \u7801\u7387 " + this.mRate + "kb/s \u7f16\u7801 " + INSTANCE.c(this.mVideoEncode) + " \u6863\u4f4d " + this.mResolutionLevel + " \u5206\u8fa8\u7387 " + this.mShortSide + HippyTKDListViewAdapter.X + this.mLongSide + "\n \u57df\u540d " + this.mHost + "\n";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.mFormatId);
        dest.writeString(this.mUrl);
        dest.writeString(this.mHost);
        dest.writeInt(this.mShortSide);
        dest.writeInt(this.mLongSide);
        dest.writeInt(this.mVideoEncode);
        dest.writeInt(this.mRate);
        dest.writeInt(this.mResolutionLevel);
        dest.writeInt(this.mPlayLevel);
        dest.writeInt(this.mLevelType);
        dest.writeFloat(this.mScore);
    }

    protected VideoUrlBean(Parcel in5) {
        Intrinsics.checkNotNullParameter(in5, "in");
        this.mFormatId = in5.readInt();
        this.mUrl = in5.readString();
        this.mHost = in5.readString();
        this.mShortSide = in5.readInt();
        this.mLongSide = in5.readInt();
        this.mVideoEncode = in5.readInt();
        this.mRate = in5.readInt();
        this.mResolutionLevel = in5.readInt();
        this.mPlayLevel = in5.readInt();
        this.mLevelType = in5.readInt();
        this.mScore = in5.readFloat();
    }
}

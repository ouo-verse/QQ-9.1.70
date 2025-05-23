package com.qzone.reborn.comment.bean;

import NS_MOBILE_FEEDS.cnst.UNIVERSAL_MALL_QUAL;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.widget.RapidCommentExpressionInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 _2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\\\u0010]B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\\\u0010^J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tJ\b\u0010\f\u001a\u00020\nH\u0016R\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b \u0010\u0012R\"\u0010%\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\"\u0010'\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b&\u0010\u0012R2\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\n0(j\b\u0012\u0004\u0012\u00020\n`)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00106\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010:\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00101\u001a\u0004\b8\u00103\"\u0004\b9\u00105R\"\u0010>\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u00101\u001a\u0004\b<\u00103\"\u0004\b=\u00105R$\u0010E\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\b7\u0010DR$\u0010M\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010S\u001a\u0004\u0018\u00010N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010O\u001a\u0004\bP\u0010Q\"\u0004\b;\u0010RR$\u0010[\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010Z\u00a8\u0006`"}, d2 = {"Lcom/qzone/reborn/comment/bean/QZoneCommentPanelResultBean;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "", "a", "toString", "d", "Ljava/lang/String;", "l", "()Ljava/lang/String;", BdhLogUtil.LogTag.Tag_Conn, "(Ljava/lang/String;)V", "inputContent", "e", "j", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "feedId", "f", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()I", "D", "(I)V", "position", h.F, "v", "cacheUniKey", "i", "b", ReportConstant.COSTREPORT_PREFIX, "autoSaveUgcKey", "u", "cacheFeedsKey", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "g", "()Ljava/util/ArrayList;", "y", "(Ljava/util/ArrayList;)V", "commentPics", "", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Z", HippyTKDListViewAdapter.X, "(Z)V", "isCheckedPrivateIcon", "E", "p", "w", "isCheckedForwardAndComment", UserInfo.SEX_FEMALE, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "isEmoRapidComment", "Lcom/qzone/widget/RapidCommentExpressionInfo;", "G", "Lcom/qzone/widget/RapidCommentExpressionInfo;", DomainData.DOMAIN_NAME, "()Lcom/qzone/widget/RapidCommentExpressionInfo;", "(Lcom/qzone/widget/RapidCommentExpressionInfo;)V", "rapidCommentInfo", "Lcom/qzone/reborn/comment/bean/QZoneCommentFontInfo;", "H", "Lcom/qzone/reborn/comment/bean/QZoneCommentFontInfo;", "k", "()Lcom/qzone/reborn/comment/bean/QZoneCommentFontInfo;", "B", "(Lcom/qzone/reborn/comment/bean/QZoneCommentFontInfo;)V", "fontInfo", "Lcom/qzone/reborn/comment/bean/QZoneCommentSuperFontInfo;", "Lcom/qzone/reborn/comment/bean/QZoneCommentSuperFontInfo;", "o", "()Lcom/qzone/reborn/comment/bean/QZoneCommentSuperFontInfo;", "(Lcom/qzone/reborn/comment/bean/QZoneCommentSuperFontInfo;)V", "superFontInfo", "Lcom/qzone/reborn/comment/bean/QZoneCommentBarrageEffectInfo;", "J", "Lcom/qzone/reborn/comment/bean/QZoneCommentBarrageEffectInfo;", "c", "()Lcom/qzone/reborn/comment/bean/QZoneCommentBarrageEffectInfo;", "t", "(Lcom/qzone/reborn/comment/bean/QZoneCommentBarrageEffectInfo;)V", "barrageEffectInfo", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneCommentPanelResultBean implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private ArrayList<String> commentPics;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private boolean isCheckedPrivateIcon;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    private boolean isCheckedForwardAndComment;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    private boolean isEmoRapidComment;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    private RapidCommentExpressionInfo rapidCommentInfo;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    private QZoneCommentFontInfo fontInfo;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    private QZoneCommentSuperFontInfo superFontInfo;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    private QZoneCommentBarrageEffectInfo barrageEffectInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String inputContent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private String feedId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int position;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private String cacheUniKey;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private String autoSaveUgcKey;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private String cacheFeedsKey;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/comment/bean/QZoneCommentPanelResultBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelResultBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/comment/bean/QZoneCommentPanelResultBean;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<QZoneCommentPanelResultBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QZoneCommentPanelResultBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QZoneCommentPanelResultBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZoneCommentPanelResultBean[] newArray(int size) {
            return new QZoneCommentPanelResultBean[size];
        }

        Companion() {
        }
    }

    public QZoneCommentPanelResultBean() {
        this.inputContent = "";
        this.feedId = "";
        this.cacheUniKey = "";
        this.autoSaveUgcKey = "";
        this.cacheFeedsKey = "";
        this.commentPics = new ArrayList<>();
    }

    public final void A(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedId = str;
    }

    public final void B(QZoneCommentFontInfo qZoneCommentFontInfo) {
        this.fontInfo = qZoneCommentFontInfo;
    }

    public final void C(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.inputContent = str;
    }

    public final void D(int i3) {
        this.position = i3;
    }

    public final void E(RapidCommentExpressionInfo rapidCommentExpressionInfo) {
        this.rapidCommentInfo = rapidCommentExpressionInfo;
    }

    public final void F(QZoneCommentSuperFontInfo qZoneCommentSuperFontInfo) {
        this.superFontInfo = qZoneCommentSuperFontInfo;
    }

    public final Map<String, String> a() {
        HashMap hashMap = new HashMap();
        QZoneCommentFontInfo qZoneCommentFontInfo = this.fontInfo;
        if (qZoneCommentFontInfo != null) {
            Intrinsics.checkNotNull(qZoneCommentFontInfo);
            hashMap.put("diy_font_id", String.valueOf(qZoneCommentFontInfo.getId()));
            QZoneCommentFontInfo qZoneCommentFontInfo2 = this.fontInfo;
            Intrinsics.checkNotNull(qZoneCommentFontInfo2);
            hashMap.put("diy_font_type", String.valueOf(qZoneCommentFontInfo2.getFontFormatType()));
            QZoneCommentFontInfo qZoneCommentFontInfo3 = this.fontInfo;
            Intrinsics.checkNotNull(qZoneCommentFontInfo3);
            String fontUrl = qZoneCommentFontInfo3.getFontUrl();
            if (fontUrl == null) {
                fontUrl = "";
            }
            hashMap.put("diy_font_url", fontUrl);
        }
        QZoneCommentSuperFontInfo qZoneCommentSuperFontInfo = this.superFontInfo;
        if (qZoneCommentSuperFontInfo != null) {
            Intrinsics.checkNotNull(qZoneCommentSuperFontInfo);
            hashMap.put(QZoneHelper.QzoneFeedActionPanelConstants.KEY_SPARKLE_WORD_ID, String.valueOf(qZoneCommentSuperFontInfo.getId()));
            QZoneCommentSuperFontInfo qZoneCommentSuperFontInfo2 = this.superFontInfo;
            Intrinsics.checkNotNull(qZoneCommentSuperFontInfo2);
            String fontJson = qZoneCommentSuperFontInfo2.getFontJson();
            if (fontJson == null) {
                fontJson = "";
            }
            hashMap.put("sparkle_json", fontJson);
        }
        QZoneCommentBarrageEffectInfo qZoneCommentBarrageEffectInfo = this.barrageEffectInfo;
        if (qZoneCommentBarrageEffectInfo != null) {
            Intrinsics.checkNotNull(qZoneCommentBarrageEffectInfo);
            hashMap.put(UNIVERSAL_MALL_QUAL.value, String.valueOf(qZoneCommentBarrageEffectInfo.getId()));
            QZoneCommentBarrageEffectInfo qZoneCommentBarrageEffectInfo2 = this.barrageEffectInfo;
            Intrinsics.checkNotNull(qZoneCommentBarrageEffectInfo2);
            String barrageJson = qZoneCommentBarrageEffectInfo2.getBarrageJson();
            hashMap.put("private_barrage_data", barrageJson != null ? barrageJson : "");
        }
        return hashMap;
    }

    /* renamed from: b, reason: from getter */
    public final String getAutoSaveUgcKey() {
        return this.autoSaveUgcKey;
    }

    /* renamed from: c, reason: from getter */
    public final QZoneCommentBarrageEffectInfo getBarrageEffectInfo() {
        return this.barrageEffectInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final String getCacheFeedsKey() {
        return this.cacheFeedsKey;
    }

    /* renamed from: f, reason: from getter */
    public final String getCacheUniKey() {
        return this.cacheUniKey;
    }

    public final ArrayList<String> g() {
        return this.commentPics;
    }

    /* renamed from: j, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: k, reason: from getter */
    public final QZoneCommentFontInfo getFontInfo() {
        return this.fontInfo;
    }

    /* renamed from: l, reason: from getter */
    public final String getInputContent() {
        return this.inputContent;
    }

    /* renamed from: m, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* renamed from: n, reason: from getter */
    public final RapidCommentExpressionInfo getRapidCommentInfo() {
        return this.rapidCommentInfo;
    }

    /* renamed from: o, reason: from getter */
    public final QZoneCommentSuperFontInfo getSuperFontInfo() {
        return this.superFontInfo;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getIsCheckedForwardAndComment() {
        return this.isCheckedForwardAndComment;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getIsCheckedPrivateIcon() {
        return this.isCheckedPrivateIcon;
    }

    /* renamed from: r, reason: from getter */
    public final boolean getIsEmoRapidComment() {
        return this.isEmoRapidComment;
    }

    public final void s(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.autoSaveUgcKey = str;
    }

    public final void t(QZoneCommentBarrageEffectInfo qZoneCommentBarrageEffectInfo) {
        this.barrageEffectInfo = qZoneCommentBarrageEffectInfo;
    }

    public final void u(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cacheFeedsKey = str;
    }

    public final void v(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cacheUniKey = str;
    }

    public final void w(boolean z16) {
        this.isCheckedForwardAndComment = z16;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.inputContent);
        parcel.writeString(this.feedId);
        parcel.writeInt(this.position);
        parcel.writeString(this.cacheUniKey);
        parcel.writeString(this.autoSaveUgcKey);
        parcel.writeString(this.cacheFeedsKey);
        parcel.writeStringList(this.commentPics);
        parcel.writeByte(this.isCheckedPrivateIcon ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isCheckedForwardAndComment ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isEmoRapidComment ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.rapidCommentInfo, flags);
        parcel.writeParcelable(this.fontInfo, flags);
        parcel.writeParcelable(this.superFontInfo, flags);
        parcel.writeParcelable(this.barrageEffectInfo, flags);
    }

    public final void x(boolean z16) {
        this.isCheckedPrivateIcon = z16;
    }

    public final void y(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.commentPics = arrayList;
    }

    public final void z(boolean z16) {
        this.isEmoRapidComment = z16;
    }

    public String toString() {
        return "QZoneCommentPanelResultBean(inputContent='" + this.inputContent + "', feedId='" + this.feedId + "', position=" + this.position + ", cacheUniKey='" + this.cacheUniKey + "', autoSaveUgcKey='" + this.autoSaveUgcKey + "', cacheFeedsKey='" + this.cacheFeedsKey + "', commentPics=" + this.commentPics + ", isCheckedPrivateIcon=" + this.isCheckedPrivateIcon + ", isCheckedForwardAndComment=" + this.isCheckedForwardAndComment + ", isEmoRapidComment=" + this.isEmoRapidComment + ", rapidCommentInfo=" + this.rapidCommentInfo + ", fontInfo=" + this.fontInfo + ", superFontInfo=" + this.superFontInfo + ", barrageEffectInfo=" + this.barrageEffectInfo + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneCommentPanelResultBean(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.inputContent = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.feedId = readString2 == null ? "" : readString2;
        this.position = parcel.readInt();
        String readString3 = parcel.readString();
        this.cacheUniKey = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        this.autoSaveUgcKey = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        this.cacheFeedsKey = readString5 != null ? readString5 : "";
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        this.commentPics = createStringArrayList == null ? new ArrayList<>() : createStringArrayList;
        this.isCheckedPrivateIcon = parcel.readByte() != 0;
        this.isCheckedForwardAndComment = parcel.readByte() != 0;
        this.isEmoRapidComment = parcel.readByte() != 0;
        this.rapidCommentInfo = (RapidCommentExpressionInfo) parcel.readParcelable(RapidCommentExpressionInfo.class.getClassLoader());
        this.fontInfo = (QZoneCommentFontInfo) parcel.readParcelable(QZoneCommentFontInfo.class.getClassLoader());
        this.superFontInfo = (QZoneCommentSuperFontInfo) parcel.readParcelable(QZoneCommentSuperFontInfo.class.getClassLoader());
        this.barrageEffectInfo = (QZoneCommentBarrageEffectInfo) parcel.readParcelable(QZoneCommentBarrageEffectInfo.class.getClassLoader());
    }
}

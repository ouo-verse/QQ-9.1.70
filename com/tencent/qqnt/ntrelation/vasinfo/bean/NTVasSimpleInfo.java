package com.tencent.qqnt.ntrelation.vasinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.ntrelation.baseinfo.bean.a;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0012\n\u0002\b\u0012\b\u0016\u0018\u0000 s2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0010B\u001b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u00a2\u0006\u0004\bp\u0010qB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\bp\u0010rJ\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016R\"\u0010\u0014\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u0016\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010!\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010%\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001aR\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u001aR\u0016\u0010,\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001aR\u0016\u0010-\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR\u0016\u0010/\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u001aR\u0016\u00101\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010\u001aR\u0018\u00103\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u000fR\u0018\u00105\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010\u000fR\u0016\u00107\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010\u001aR\u0016\u00109\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010\u001aR\u0016\u0010;\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010\u001aR\u0016\u0010=\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010\u001aR\u0016\u0010?\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010\u001aR\u0018\u0010A\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010\u000fR\u0016\u0010C\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010\u001aR\u0016\u0010E\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010\u001aR\u0016\u0010G\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010 R\u0016\u0010I\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010\u001aR\u0016\u0010K\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010\u001aR\u0016\u0010M\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010 R\u0016\u0010O\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010\u001aR\u0016\u0010Q\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010\u001aR\u0016\u0010S\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010\u001aR$\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010T8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u001c\u0010[\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\f\n\u0004\bX\u0010 \u0012\u0004\bY\u0010ZR\u001c\u0010^\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\f\n\u0004\b\\\u0010 \u0012\u0004\b]\u0010ZR\u001c\u0010a\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\f\n\u0004\b_\u0010 \u0012\u0004\b`\u0010ZR\u001e\u0010f\u001a\u0004\u0018\u00010b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\f\n\u0004\bc\u0010d\u0012\u0004\be\u0010ZR\u001c\u0010i\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\f\n\u0004\bg\u0010 \u0012\u0004\bh\u0010ZR*\u0010l\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010T8\u0006@\u0006X\u0087\u000e\u00a2\u0006\f\n\u0004\bj\u0010V\u0012\u0004\bk\u0010ZR\u001e\u0010o\u001a\u0004\u0018\u00010b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\f\n\u0004\bm\u0010d\u0012\u0004\bn\u0010Z\u00a8\u0006t"}, d2 = {"Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;", "Lcom/tencent/qqnt/ntrelation/baseinfo/bean/a;", "", "Landroid/os/Parcelable;", "", "c", "", "toString", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "writeToParcel", "describeContents", h.F, "Ljava/lang/String;", "a", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "uid", "i", "b", "f", "uin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "qqVipInfo", BdhLogUtil.LogTag.Tag_Conn, "superVipInfo", "", "D", "J", "namePlateOfKingGameId", "E", "namePlateOfKingLoginTime", UserInfo.SEX_FEMALE, "namePlateOfKingDan", "", "G", "Ljava/lang/Boolean;", "namePlateOfKingDanDisplatSwitch", "H", "bigClubInfo", "gameCardId", "nameplateVipType", "K", "grayNameplateFlag", "L", "superQqInfo", "M", "medalsInfo", "N", "nameplateCfgInfo", "P", "superVipTemplateId", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "bigClubTemplateId", BdhLogUtil.LogTag.Tag_Req, "bigClubExtTemplateId", ExifInterface.LATITUDE_SOUTH, "diyFontId", "T", "vipStartFlag", "U", "vipIcons", "V", "vipDataFlag", "W", "cNewLoverDiamondFlag", "X", "pendantId", "Y", "pendantDiyId", "Z", "faceId", "a0", "uVipFont", "b0", "vipFontType", "c0", "magicFont", "d0", "fontEffect", "Ljava/util/concurrent/ConcurrentHashMap;", "e0", "Ljava/util/concurrent/ConcurrentHashMap;", "diyFontConfigMap", "f0", "getFaceIdUpdateTime$annotations", "()V", "faceIdUpdateTime", "g0", "getTimestamp$annotations", "timestamp", "h0", "getLastUpdateTime$annotations", WadlProxyConsts.LAST_UPDATE_TIME, "", "i0", "[B", "getDiyFontTimestampBytes$annotations", "diyFontTimestampBytes", "j0", "getFontEffectLastUpdateTime$annotations", "fontEffectLastUpdateTime", "k0", "getDiyFontTimestampMap$annotations", "diyFontTimestampMap", "l0", "getDiyFontConfigBytes$annotations", "diyFontConfigBytes", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public class NTVasSimpleInfo extends a implements Cloneable, Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @JvmField
    public int superVipInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @JvmField
    public long namePlateOfKingGameId;

    /* renamed from: E, reason: from kotlin metadata */
    @JvmField
    public long namePlateOfKingLoginTime;

    /* renamed from: F, reason: from kotlin metadata */
    @JvmField
    public int namePlateOfKingDan;

    /* renamed from: G, reason: from kotlin metadata */
    @JvmField
    @Nullable
    public Boolean namePlateOfKingDanDisplatSwitch;

    /* renamed from: H, reason: from kotlin metadata */
    @JvmField
    public int bigClubInfo;

    /* renamed from: I, reason: from kotlin metadata */
    @JvmField
    public int gameCardId;

    /* renamed from: J, reason: from kotlin metadata */
    @JvmField
    public int nameplateVipType;

    /* renamed from: K, reason: from kotlin metadata */
    @JvmField
    public int grayNameplateFlag;

    /* renamed from: L, reason: from kotlin metadata */
    @JvmField
    public int superQqInfo;

    /* renamed from: M, reason: from kotlin metadata */
    @JvmField
    @Nullable
    public String medalsInfo;

    /* renamed from: N, reason: from kotlin metadata */
    @JvmField
    @Nullable
    public String nameplateCfgInfo;

    /* renamed from: P, reason: from kotlin metadata */
    @JvmField
    public int superVipTemplateId;

    /* renamed from: Q, reason: from kotlin metadata */
    @JvmField
    public int bigClubTemplateId;

    /* renamed from: R, reason: from kotlin metadata */
    @JvmField
    public int bigClubExtTemplateId;

    /* renamed from: S, reason: from kotlin metadata */
    @JvmField
    public int diyFontId;

    /* renamed from: T, reason: from kotlin metadata */
    @JvmField
    public int vipStartFlag;

    /* renamed from: U, reason: from kotlin metadata */
    @JvmField
    @Nullable
    public String vipIcons;

    /* renamed from: V, reason: from kotlin metadata */
    @JvmField
    public int vipDataFlag;

    /* renamed from: W, reason: from kotlin metadata */
    @JvmField
    public int cNewLoverDiamondFlag;

    /* renamed from: X, reason: from kotlin metadata */
    @JvmField
    public long pendantId;

    /* renamed from: Y, reason: from kotlin metadata */
    @JvmField
    public int pendantDiyId;

    /* renamed from: Z, reason: from kotlin metadata */
    @JvmField
    public int faceId;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public long uVipFont;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int vipFontType;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int magicFont;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int fontEffect;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public ConcurrentHashMap<Integer, String> diyFontConfigMap;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public long faceIdUpdateTime;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public long timestamp;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uid;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public long lastUpdateTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uin;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public byte[] diyFontTimestampBytes;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public long fontEffectLastUpdateTime;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public ConcurrentHashMap<Integer, Integer> diyFontTimestampMap;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public byte[] diyFontConfigBytes;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int qqVipInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;", "<init>", "()V", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion implements Parcelable.Creator<NTVasSimpleInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NTVasSimpleInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new NTVasSimpleInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public NTVasSimpleInfo[] newArray(int size) {
            return new NTVasSimpleInfo[size];
        }

        Companion() {
        }
    }

    public NTVasSimpleInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.qqnt.ntrelation.baseinfo.bean.a
    @NotNull
    /* renamed from: a, reason: from getter */
    public String getUid() {
        return this.uid;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public String getUin() {
        return this.uin;
    }

    public final void c() {
        this.qqVipInfo = Integer.MIN_VALUE;
        this.superVipInfo = Integer.MIN_VALUE;
        this.namePlateOfKingGameId = Long.MIN_VALUE;
        this.namePlateOfKingLoginTime = Long.MIN_VALUE;
        this.namePlateOfKingDan = Integer.MIN_VALUE;
        this.namePlateOfKingDanDisplatSwitch = null;
        this.bigClubInfo = Integer.MIN_VALUE;
        this.gameCardId = Integer.MIN_VALUE;
        this.nameplateVipType = Integer.MIN_VALUE;
        this.grayNameplateFlag = Integer.MIN_VALUE;
        this.superQqInfo = Integer.MIN_VALUE;
        this.medalsInfo = null;
        this.nameplateCfgInfo = null;
        this.superVipTemplateId = Integer.MIN_VALUE;
        this.bigClubTemplateId = Integer.MIN_VALUE;
        this.bigClubExtTemplateId = Integer.MIN_VALUE;
        this.diyFontId = Integer.MIN_VALUE;
        this.vipStartFlag = Integer.MIN_VALUE;
        this.vipIcons = null;
        this.vipDataFlag = Integer.MIN_VALUE;
        this.cNewLoverDiamondFlag = Integer.MIN_VALUE;
        this.pendantId = Long.MIN_VALUE;
        this.pendantDiyId = Integer.MIN_VALUE;
        this.faceId = Integer.MIN_VALUE;
        this.uVipFont = Long.MIN_VALUE;
        this.vipFontType = Integer.MIN_VALUE;
        this.magicFont = Integer.MIN_VALUE;
        this.fontEffect = Integer.MIN_VALUE;
        this.diyFontConfigMap = null;
        this.faceIdUpdateTime = Long.MIN_VALUE;
        this.timestamp = Long.MIN_VALUE;
        this.lastUpdateTime = Long.MIN_VALUE;
        this.diyFontTimestampBytes = null;
        this.fontEffectLastUpdateTime = Long.MIN_VALUE;
        this.diyFontTimestampMap = null;
        this.diyFontConfigBytes = null;
    }

    @NotNull
    public Object clone() {
        return super.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uid = str;
    }

    public void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uin = str;
    }

    @NotNull
    public String toString() {
        String str = "NTVasSimpleInfo uin " + getUin() + " uid " + getUid();
        Field[] allFields = getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(allFields, "allFields");
        for (Field field : allFields) {
            field.setAccessible(true);
            try {
                str = str + " " + field.getName() + MsgSummary.STR_COLON + field.get(this);
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            } catch (IllegalArgumentException e17) {
                e17.printStackTrace();
            }
        }
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.qqVipInfo);
        parcel.writeInt(this.superVipInfo);
        parcel.writeLong(this.namePlateOfKingGameId);
        parcel.writeLong(this.namePlateOfKingLoginTime);
        parcel.writeInt(this.namePlateOfKingDan);
        parcel.writeByte(Intrinsics.areEqual(this.namePlateOfKingDanDisplatSwitch, Boolean.TRUE) ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.bigClubInfo);
        parcel.writeInt(this.gameCardId);
        parcel.writeInt(this.nameplateVipType);
        parcel.writeInt(this.grayNameplateFlag);
        parcel.writeInt(this.superQqInfo);
        parcel.writeString(this.medalsInfo);
        parcel.writeString(this.nameplateCfgInfo);
        parcel.writeInt(this.superVipTemplateId);
        parcel.writeInt(this.bigClubTemplateId);
        parcel.writeInt(this.bigClubExtTemplateId);
        parcel.writeInt(this.diyFontId);
        parcel.writeInt(this.vipStartFlag);
        parcel.writeString(this.vipIcons);
        parcel.writeInt(this.vipDataFlag);
        parcel.writeInt(this.cNewLoverDiamondFlag);
        parcel.writeLong(this.pendantId);
        parcel.writeInt(this.pendantDiyId);
        parcel.writeInt(this.faceId);
        parcel.writeLong(this.uVipFont);
        parcel.writeInt(this.vipFontType);
        parcel.writeInt(this.magicFont);
        parcel.writeInt(this.fontEffect);
        parcel.writeLong(this.faceIdUpdateTime);
        parcel.writeLong(this.timestamp);
        parcel.writeLong(this.lastUpdateTime);
        parcel.writeByteArray(this.diyFontTimestampBytes);
        parcel.writeLong(this.fontEffectLastUpdateTime);
        parcel.writeByteArray(this.diyFontConfigBytes);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTVasSimpleInfo(@NotNull String uid, @NotNull String uin) {
        super(uid, uin);
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uid = uid;
        this.uin = uin;
        this.namePlateOfKingDanDisplatSwitch = Boolean.FALSE;
        this.medalsInfo = "";
        this.nameplateCfgInfo = "";
        this.vipIcons = "";
        this.diyFontConfigMap = new ConcurrentHashMap<>();
        this.diyFontTimestampBytes = new byte[]{0};
        this.diyFontTimestampMap = new ConcurrentHashMap<>();
        this.diyFontConfigBytes = new byte[]{0};
    }

    public /* synthetic */ NTVasSimpleInfo(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NTVasSimpleInfo(@NotNull Parcel parcel) {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.qqVipInfo = parcel.readInt();
        this.superVipInfo = parcel.readInt();
        this.namePlateOfKingGameId = parcel.readLong();
        this.namePlateOfKingLoginTime = parcel.readLong();
        this.namePlateOfKingDan = parcel.readInt();
        this.namePlateOfKingDanDisplatSwitch = Boolean.valueOf(parcel.readByte() != 0);
        this.bigClubInfo = parcel.readInt();
        this.gameCardId = parcel.readInt();
        this.nameplateVipType = parcel.readInt();
        this.grayNameplateFlag = parcel.readInt();
        this.superQqInfo = parcel.readInt();
        this.medalsInfo = parcel.readString();
        this.nameplateCfgInfo = parcel.readString();
        this.superVipTemplateId = parcel.readInt();
        this.bigClubTemplateId = parcel.readInt();
        this.bigClubExtTemplateId = parcel.readInt();
        this.diyFontId = parcel.readInt();
        this.vipStartFlag = parcel.readInt();
        this.vipIcons = parcel.readString();
        this.vipDataFlag = parcel.readInt();
        this.cNewLoverDiamondFlag = parcel.readInt();
        this.pendantId = parcel.readLong();
        this.pendantDiyId = parcel.readInt();
        this.faceId = parcel.readInt();
        this.uVipFont = parcel.readLong();
        this.vipFontType = parcel.readInt();
        this.magicFont = parcel.readInt();
        this.fontEffect = parcel.readInt();
        this.faceIdUpdateTime = parcel.readLong();
        this.timestamp = parcel.readLong();
        this.lastUpdateTime = parcel.readLong();
        this.diyFontTimestampBytes = parcel.createByteArray();
        this.fontEffectLastUpdateTime = parcel.readLong();
        this.diyFontConfigBytes = parcel.createByteArray();
    }
}

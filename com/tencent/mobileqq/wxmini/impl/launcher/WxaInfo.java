package com.tencent.mobileqq.wxmini.impl.launcher;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wxmini.impl.report.WxaStartupReportData;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 G2\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\bD\u0010EB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\bD\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016R$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\"\u0010+\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR$\u0010.\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u0014\u001a\u0004\b(\u0010\u0016\"\u0004\b-\u0010\u0018R$\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016\"\u0004\b0\u0010\u0018R$\u00109\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R>\u0010C\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020;0:j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020;`<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/wxmini/impl/launcher/WxaInfo;", "Landroid/os/Parcelable;", "", "toString", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "Landroid/os/Bundle;", "d", "Landroid/os/Bundle;", "f", "()Landroid/os/Bundle;", "r", "(Landroid/os/Bundle;)V", "originBundle", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "o", "(Ljava/lang/String;)V", QQCustomArkDialogUtil.META_DATA, "I", "c", "()I", "p", "(I)V", "metaType", tl.h.F, "l", "v", "versionType", "i", "g", ReportConstant.COSTREPORT_PREFIX, "path", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "t", "scene", BdhLogUtil.LogTag.Tag_Conn, "w", "wxAppId", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "openId", "Lcom/tencent/mobileqq/wxmini/impl/report/WxaStartupReportData;", "E", "Lcom/tencent/mobileqq/wxmini/impl/report/WxaStartupReportData;", "k", "()Lcom/tencent/mobileqq/wxmini/impl/report/WxaStartupReportData;", "u", "(Lcom/tencent/mobileqq/wxmini/impl/report/WxaStartupReportData;)V", "startupReportData", "Ljava/util/HashMap;", "Ljava/lang/Object;", "Lkotlin/collections/HashMap;", UserInfo.SEX_FEMALE, "Ljava/util/HashMap;", "a", "()Ljava/util/HashMap;", DomainData.DOMAIN_NAME, "(Ljava/util/HashMap;)V", "hostExtraData", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class WxaInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private String wxAppId;

    /* renamed from: D, reason: from kotlin metadata */
    private String openId;

    /* renamed from: E, reason: from kotlin metadata */
    private WxaStartupReportData startupReportData;

    /* renamed from: F, reason: from kotlin metadata */
    private HashMap<String, Object> hostExtraData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Bundle originBundle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String metaData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int metaType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int versionType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String path;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int scene;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wxmini/impl/launcher/WxaInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wxmini/impl/launcher/WxaInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wxmini/impl/launcher/WxaInfo;", "<init>", "()V", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wxmini.impl.launcher.WxaInfo$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion implements Parcelable.Creator<WxaInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WxaInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WxaInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WxaInfo[] newArray(int size) {
            return new WxaInfo[size];
        }

        Companion() {
        }
    }

    public WxaInfo() {
        this.metaData = "";
        this.path = "";
        this.hostExtraData = new HashMap<>();
    }

    public final HashMap<String, Object> a() {
        return this.hostExtraData;
    }

    /* renamed from: b, reason: from getter */
    public final String getMetaData() {
        return this.metaData;
    }

    /* renamed from: c, reason: from getter */
    public final int getMetaType() {
        return this.metaType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final String getOpenId() {
        return this.openId;
    }

    /* renamed from: f, reason: from getter */
    public final Bundle getOriginBundle() {
        return this.originBundle;
    }

    /* renamed from: g, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: j, reason: from getter */
    public final int getScene() {
        return this.scene;
    }

    /* renamed from: k, reason: from getter */
    public final WxaStartupReportData getStartupReportData() {
        return this.startupReportData;
    }

    /* renamed from: l, reason: from getter */
    public final int getVersionType() {
        return this.versionType;
    }

    /* renamed from: m, reason: from getter */
    public final String getWxAppId() {
        return this.wxAppId;
    }

    public final void n(HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.hostExtraData = hashMap;
    }

    public final void o(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.metaData = str;
    }

    public final void p(int i3) {
        this.metaType = i3;
    }

    public final void q(String str) {
        this.openId = str;
    }

    public final void r(Bundle bundle) {
        this.originBundle = bundle;
    }

    public final void s(String str) {
        this.path = str;
    }

    public final void t(int i3) {
        this.scene = i3;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("WxaInfo[wxAppId:");
        sb5.append(this.wxAppId);
        sb5.append(",startupId:");
        WxaStartupReportData wxaStartupReportData = this.startupReportData;
        sb5.append(wxaStartupReportData != null ? wxaStartupReportData.getStartupId() : null);
        sb5.append(",scene:");
        sb5.append(this.scene);
        sb5.append(",metaData:");
        sb5.append(this.metaData);
        sb5.append(']');
        return sb5.toString();
    }

    public final void u(WxaStartupReportData wxaStartupReportData) {
        this.startupReportData = wxaStartupReportData;
    }

    public final void v(int i3) {
        this.versionType = i3;
    }

    public final void w(String str) {
        this.wxAppId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeBundle(this.originBundle);
        parcel.writeString(this.metaData);
        parcel.writeInt(this.metaType);
        parcel.writeInt(this.versionType);
        parcel.writeString(this.path);
        parcel.writeInt(this.scene);
        parcel.writeString(this.wxAppId);
        parcel.writeString(this.openId);
        parcel.writeParcelable(this.startupReportData, flags);
        parcel.writeMap(this.hostExtraData);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WxaInfo(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.originBundle = parcel.readBundle(Bundle.class.getClassLoader());
        String readString = parcel.readString();
        this.metaData = readString == null ? "" : readString;
        this.metaType = parcel.readInt();
        this.versionType = parcel.readInt();
        this.path = parcel.readString();
        this.scene = parcel.readInt();
        this.wxAppId = parcel.readString();
        this.openId = parcel.readString();
        this.startupReportData = (WxaStartupReportData) parcel.readParcelable(WxaStartupReportData.class.getClassLoader());
        HashMap<String, Object> hashMap = this.hostExtraData;
        parcel.readMap(hashMap, hashMap.getClass().getClassLoader());
    }
}

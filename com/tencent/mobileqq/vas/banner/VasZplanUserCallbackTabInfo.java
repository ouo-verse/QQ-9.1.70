package com.tencent.mobileqq.vas.banner;

import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0010\u0007\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b<\u0010=J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0019\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b#\u0010\u001cR\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR\"\u0010.\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010*\u001a\u0004\b\"\u0010+\"\u0004\b,\u0010-R\"\u00101\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u0019\u001a\u0004\b\u0014\u0010\u001a\"\u0004\b0\u0010\u001cR\"\u00104\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u0019\u001a\u0004\b3\u0010\u001a\"\u0004\b2\u0010\u001cR\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b%\u0010\u001a\"\u0004\b5\u0010\u001cR\"\u0010;\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u00107\u001a\u0004\b/\u00108\"\u0004\b9\u0010:\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/vas/banner/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", TangramHippyConstants.EXP_ID, "b", "I", "()I", "l", "(I)V", "exposureTime", "c", "getExposureNum", "k", "exposureNum", "d", "Ljava/lang/String;", "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "icon", "e", h.F, "t", "text", "f", "o", WadlProxyConsts.KEY_JUMP_URL, "g", "getModuleCode", "p", "moduleCode", "", UserInfo.SEX_FEMALE, "()F", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(F)V", "percentage", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "groupKey", "j", "getExpKey", "expKey", ReportConstant.COSTREPORT_PREFIX, "silenceText", "Z", "()Z", "r", "(Z)V", "isShowSilenceText", "<init>", "(J)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.vas.banner.d, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class VasZplanUserCallbackTabInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long expId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int exposureTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int exposureNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String icon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String text;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String jumpUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String moduleCode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float percentage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String groupKey;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String expKey;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String silenceText;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isShowSilenceText;

    public VasZplanUserCallbackTabInfo() {
        this(0L, 1, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getExpId() {
        return this.expId;
    }

    /* renamed from: b, reason: from getter */
    public final int getExposureTime() {
        return this.exposureTime;
    }

    /* renamed from: c, reason: from getter */
    public final String getGroupKey() {
        return this.groupKey;
    }

    /* renamed from: d, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: e, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    /* renamed from: f, reason: from getter */
    public final float getPercentage() {
        return this.percentage;
    }

    /* renamed from: g, reason: from getter */
    public final String getSilenceText() {
        return this.silenceText;
    }

    /* renamed from: h, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return c.a(this.expId);
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsShowSilenceText() {
        return this.isShowSilenceText;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.expKey = str;
    }

    public final void k(int i3) {
        this.exposureNum = i3;
    }

    public final void l(int i3) {
        this.exposureTime = i3;
    }

    public final void m(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupKey = str;
    }

    public final void n(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.icon = str;
    }

    public final void o(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpUrl = str;
    }

    public final void p(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.moduleCode = str;
    }

    public final void q(float f16) {
        this.percentage = f16;
    }

    public final void r(boolean z16) {
        this.isShowSilenceText = z16;
    }

    public final void s(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.silenceText = str;
    }

    public final void t(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public String toString() {
        return "VasZplanUserCallbackTabInfo(expId=" + this.expId + ")";
    }

    public VasZplanUserCallbackTabInfo(long j3) {
        this.expId = j3;
        this.icon = "";
        this.text = "";
        this.jumpUrl = "";
        this.moduleCode = "";
        this.groupKey = "";
        this.expKey = "";
        this.silenceText = "";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof VasZplanUserCallbackTabInfo) && this.expId == ((VasZplanUserCallbackTabInfo) other).expId;
    }

    public /* synthetic */ VasZplanUserCallbackTabInfo(long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3);
    }
}

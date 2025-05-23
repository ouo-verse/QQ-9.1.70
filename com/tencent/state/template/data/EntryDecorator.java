package com.tencent.state.template.data;

import com.tencent.gamecenter.wadl.api.IQQGameSwitchApi;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.state.data.Image;
import com.tencent.state.data.Text;
import com.tencent.state.map.Location;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\"\u001a\u00020\tH\u00c6\u0003J\t\u0010#\u001a\u00020\u000bH\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003Jc\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u00d6\u0003J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001J\t\u0010-\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006."}, d2 = {"Lcom/tencent/state/template/data/EntryDecorator;", "Lcom/tencent/state/template/data/Decorator;", "jumpType", "", WadlProxyConsts.KEY_JUMP_URL, "", IQQGameSwitchApi.PARAMS_KEY_HIPPY_INFO, "Lcom/tencent/state/template/data/CommonHippyInfo;", "img", "Lcom/tencent/state/data/Image;", "loc", "Lcom/tencent/state/map/Location;", FileReaderHelper.TXT_EXT, "Lcom/tencent/state/data/Text;", "bookshelfAnimate", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY, "(ILjava/lang/String;Lcom/tencent/state/template/data/CommonHippyInfo;Lcom/tencent/state/data/Image;Lcom/tencent/state/map/Location;Lcom/tencent/state/data/Text;Ljava/lang/String;Ljava/lang/String;)V", "getBookshelfAnimate", "()Ljava/lang/String;", "getHippyInfo", "()Lcom/tencent/state/template/data/CommonHippyInfo;", "getImg", "()Lcom/tencent/state/data/Image;", "getJumpType", "()I", "getJumpUrl", "getLoc", "()Lcom/tencent/state/map/Location;", "getReportKey", "getTxt", "()Lcom/tencent/state/data/Text;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class EntryDecorator extends Decorator {
    private final String bookshelfAnimate;
    private final CommonHippyInfo hippyInfo;
    private final Image img;
    private final int jumpType;
    private final String jumpUrl;
    private final Location loc;
    private final String reportKey;
    private final Text txt;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntryDecorator(int i3, String str, CommonHippyInfo commonHippyInfo, Image img, Location loc, Text text, String str2, String str3) {
        super(img, loc, text);
        Intrinsics.checkNotNullParameter(img, "img");
        Intrinsics.checkNotNullParameter(loc, "loc");
        this.jumpType = i3;
        this.jumpUrl = str;
        this.hippyInfo = commonHippyInfo;
        this.img = img;
        this.loc = loc;
        this.txt = text;
        this.bookshelfAnimate = str2;
        this.reportKey = str3;
    }

    /* renamed from: component1, reason: from getter */
    public final int getJumpType() {
        return this.jumpType;
    }

    /* renamed from: component2, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final CommonHippyInfo getHippyInfo() {
        return this.hippyInfo;
    }

    /* renamed from: component4, reason: from getter */
    public final Image getImg() {
        return this.img;
    }

    /* renamed from: component5, reason: from getter */
    public final Location getLoc() {
        return this.loc;
    }

    /* renamed from: component6, reason: from getter */
    public final Text getTxt() {
        return this.txt;
    }

    /* renamed from: component7, reason: from getter */
    public final String getBookshelfAnimate() {
        return this.bookshelfAnimate;
    }

    /* renamed from: component8, reason: from getter */
    public final String getReportKey() {
        return this.reportKey;
    }

    public final EntryDecorator copy(int jumpType, String jumpUrl, CommonHippyInfo hippyInfo, Image img, Location loc, Text txt, String bookshelfAnimate, String reportKey) {
        Intrinsics.checkNotNullParameter(img, "img");
        Intrinsics.checkNotNullParameter(loc, "loc");
        return new EntryDecorator(jumpType, jumpUrl, hippyInfo, img, loc, txt, bookshelfAnimate, reportKey);
    }

    public final String getBookshelfAnimate() {
        return this.bookshelfAnimate;
    }

    public final CommonHippyInfo getHippyInfo() {
        return this.hippyInfo;
    }

    public final Image getImg() {
        return this.img;
    }

    public final int getJumpType() {
        return this.jumpType;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final Location getLoc() {
        return this.loc;
    }

    public final String getReportKey() {
        return this.reportKey;
    }

    public final Text getTxt() {
        return this.txt;
    }

    public int hashCode() {
        int i3 = this.jumpType * 31;
        String str = this.jumpUrl;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        CommonHippyInfo commonHippyInfo = this.hippyInfo;
        int hashCode2 = (hashCode + (commonHippyInfo != null ? commonHippyInfo.hashCode() : 0)) * 31;
        Image image = this.img;
        int hashCode3 = (hashCode2 + (image != null ? image.hashCode() : 0)) * 31;
        Location location = this.loc;
        int hashCode4 = (hashCode3 + (location != null ? location.hashCode() : 0)) * 31;
        Text text = this.txt;
        int hashCode5 = (hashCode4 + (text != null ? text.hashCode() : 0)) * 31;
        String str2 = this.bookshelfAnimate;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.reportKey;
        return hashCode6 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "EntryDecorator(jumpType=" + this.jumpType + ", jumpUrl=" + this.jumpUrl + ", hippyInfo=" + this.hippyInfo + ", img=" + this.img + ", loc=" + this.loc + ", txt=" + this.txt + ", bookshelfAnimate=" + this.bookshelfAnimate + ", reportKey=" + this.reportKey + ")";
    }

    public /* synthetic */ EntryDecorator(int i3, String str, CommonHippyInfo commonHippyInfo, Image image, Location location, Text text, String str2, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, commonHippyInfo, image, location, (i16 & 32) != 0 ? null : text, (i16 & 64) != 0 ? null : str2, (i16 & 128) != 0 ? "" : str3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntryDecorator)) {
            return false;
        }
        EntryDecorator entryDecorator = (EntryDecorator) other;
        return this.jumpType == entryDecorator.jumpType && Intrinsics.areEqual(this.jumpUrl, entryDecorator.jumpUrl) && Intrinsics.areEqual(this.hippyInfo, entryDecorator.hippyInfo) && Intrinsics.areEqual(this.img, entryDecorator.img) && Intrinsics.areEqual(this.loc, entryDecorator.loc) && Intrinsics.areEqual(this.txt, entryDecorator.txt) && Intrinsics.areEqual(this.bookshelfAnimate, entryDecorator.bookshelfAnimate) && Intrinsics.areEqual(this.reportKey, entryDecorator.reportKey);
    }
}

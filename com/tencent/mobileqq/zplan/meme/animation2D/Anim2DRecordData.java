package com.tencent.mobileqq.zplan.meme.animation2D;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.zplan.meme.action.MODE;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u001b\u0012\b\b\u0002\u0010(\u001a\u00020#\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u00106\u001a\u00020\u0004\u0012\u0006\u00108\u001a\u00020\u0004\u00a2\u0006\u0004\b9\u0010:J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\t\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010)\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0018\u001a\u0004\b\u0011\u0010\u0019R$\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u000e\u0010\u0019\"\u0004\b*\u0010+R$\u0010.\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b$\u0010\u0019\"\u0004\b-\u0010+R$\u00100\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0018\u001a\u0004\b\u0014\u0010\u0019\"\u0004\b/\u0010+R$\u00103\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u0018\u001a\u0004\b1\u0010\u0019\"\u0004\b2\u0010+R\"\u00106\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\f\"\u0004\b4\u00105R\"\u00108\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0017\u0010\f\"\u0004\b7\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/animation2D/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "j", "()I", "id", "b", DomainData.DOMAIN_NAME, "width", "c", "i", "height", "d", h.F, "frameRate", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "avatarPath", "", "f", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()F", "setRadius", "(F)V", "radius", "Lcom/tencent/zplan/meme/action/MODE;", "g", "Lcom/tencent/zplan/meme/action/MODE;", "k", "()Lcom/tencent/zplan/meme/action/MODE;", "mode", "cacheDir", "setBgResDir", "(Ljava/lang/String;)V", "bgResDir", "setFgResDir", "fgResDir", "o", QQWinkConstants.COVER_PATH, "l", "p", "picPath", "setEncodeWidth", "(I)V", "encodeWidth", "setEncodeHeight", "encodeHeight", "<init>", "(IIIILjava/lang/String;FLcom/tencent/zplan/meme/action/MODE;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.meme.animation2D.c, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class Anim2DRecordData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int frameRate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String avatarPath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private float radius;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final MODE mode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final String cacheDir;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private String bgResDir;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private String fgResDir;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private String coverPath;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private String picPath;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private int encodeWidth;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private int encodeHeight;

    public Anim2DRecordData(int i3, int i16, int i17, int i18, String avatarPath, float f16, MODE mode, String str, String str2, String str3, String str4, String str5, int i19, int i26) {
        Intrinsics.checkNotNullParameter(avatarPath, "avatarPath");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.id = i3;
        this.width = i16;
        this.height = i17;
        this.frameRate = i18;
        this.avatarPath = avatarPath;
        this.radius = f16;
        this.mode = mode;
        this.cacheDir = str;
        this.bgResDir = str2;
        this.fgResDir = str3;
        this.coverPath = str4;
        this.picPath = str5;
        this.encodeWidth = i19;
        this.encodeHeight = i26;
    }

    /* renamed from: a, reason: from getter */
    public final String getAvatarPath() {
        return this.avatarPath;
    }

    /* renamed from: b, reason: from getter */
    public final String getBgResDir() {
        return this.bgResDir;
    }

    /* renamed from: c, reason: from getter */
    public final String getCacheDir() {
        return this.cacheDir;
    }

    /* renamed from: d, reason: from getter */
    public final String getCoverPath() {
        return this.coverPath;
    }

    /* renamed from: e, reason: from getter */
    public final int getEncodeHeight() {
        return this.encodeHeight;
    }

    /* renamed from: f, reason: from getter */
    public final int getEncodeWidth() {
        return this.encodeWidth;
    }

    /* renamed from: g, reason: from getter */
    public final String getFgResDir() {
        return this.fgResDir;
    }

    /* renamed from: h, reason: from getter */
    public final int getFrameRate() {
        return this.frameRate;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.id * 31) + this.width) * 31) + this.height) * 31) + this.frameRate) * 31) + this.avatarPath.hashCode()) * 31) + Float.floatToIntBits(this.radius)) * 31) + this.mode.hashCode()) * 31;
        String str = this.cacheDir;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.bgResDir;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fgResDir;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.coverPath;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.picPath;
        return ((((hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.encodeWidth) * 31) + this.encodeHeight;
    }

    /* renamed from: i, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: j, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: k, reason: from getter */
    public final MODE getMode() {
        return this.mode;
    }

    /* renamed from: l, reason: from getter */
    public final String getPicPath() {
        return this.picPath;
    }

    /* renamed from: m, reason: from getter */
    public final float getRadius() {
        return this.radius;
    }

    /* renamed from: n, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public final void o(String str) {
        this.coverPath = str;
    }

    public final void p(String str) {
        this.picPath = str;
    }

    public String toString() {
        return "Anim2DRecordData(id=" + this.id + ", width=" + this.width + ", height=" + this.height + ", frameRate=" + this.frameRate + ", avatarPath=" + this.avatarPath + ", radius=" + this.radius + ", mode=" + this.mode + ", cacheDir=" + this.cacheDir + ", bgResDir=" + this.bgResDir + ", fgResDir=" + this.fgResDir + ", coverPath=" + this.coverPath + ", picPath=" + this.picPath + ", encodeWidth=" + this.encodeWidth + ", encodeHeight=" + this.encodeHeight + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Anim2DRecordData)) {
            return false;
        }
        Anim2DRecordData anim2DRecordData = (Anim2DRecordData) other;
        return this.id == anim2DRecordData.id && this.width == anim2DRecordData.width && this.height == anim2DRecordData.height && this.frameRate == anim2DRecordData.frameRate && Intrinsics.areEqual(this.avatarPath, anim2DRecordData.avatarPath) && Float.compare(this.radius, anim2DRecordData.radius) == 0 && this.mode == anim2DRecordData.mode && Intrinsics.areEqual(this.cacheDir, anim2DRecordData.cacheDir) && Intrinsics.areEqual(this.bgResDir, anim2DRecordData.bgResDir) && Intrinsics.areEqual(this.fgResDir, anim2DRecordData.fgResDir) && Intrinsics.areEqual(this.coverPath, anim2DRecordData.coverPath) && Intrinsics.areEqual(this.picPath, anim2DRecordData.picPath) && this.encodeWidth == anim2DRecordData.encodeWidth && this.encodeHeight == anim2DRecordData.encodeHeight;
    }
}

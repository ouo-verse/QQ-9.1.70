package com.tencent.mobileqq.wink.editor.export;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001dBC\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0019\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/export/VideoFormatInfo;", "Ljava/io/Serializable;", "", "toString", "", "colorStandard", "I", "getColorStandard", "()I", "colorTransfer", "getColorTransfer", "profile", "getProfile", "level", "getLevel", "bitrate", "getBitrate", "", "hdrStaticInfo", "[B", "getHdrStaticInfo", "()[B", "hdr10PlusInfo", "getHdr10PlusInfo", "", "isHdrVideo", "()Z", "<init>", "(IIIII[B[B)V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class VideoFormatInfo implements Serializable {
    private final int bitrate;
    private final int colorStandard;
    private final int colorTransfer;

    @Nullable
    private final byte[] hdr10PlusInfo;

    @Nullable
    private final byte[] hdrStaticInfo;
    private final int level;
    private final int profile;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\bJ\u0010\u0010\n\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\bJ\u0006\u0010\f\u001a\u00020\u000bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\r\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\r\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R$\u0010$\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010'\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/export/VideoFormatInfo$a;", "", "", "value", "b", "c", "g", "f", "", "e", "d", "Lcom/tencent/mobileqq/wink/editor/export/VideoFormatInfo;", "a", "I", "getColorStandard", "()I", "setColorStandard", "(I)V", "colorStandard", "getColorTransfer", "setColorTransfer", "colorTransfer", "getProfile", "setProfile", "profile", "getLevel", "setLevel", "level", "getBitrate", "setBitrate", "bitrate", "[B", "getHdrStaticInfo", "()[B", "setHdrStaticInfo", "([B)V", "hdrStaticInfo", "getHdr10PlusInfo", "setHdr10PlusInfo", "hdr10PlusInfo", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int colorStandard;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int colorTransfer;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int profile;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int level;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int bitrate;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private byte[] hdrStaticInfo;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private byte[] hdr10PlusInfo;

        @NotNull
        public final VideoFormatInfo a() {
            return new VideoFormatInfo(this.colorStandard, this.colorTransfer, this.profile, this.level, this.bitrate, this.hdrStaticInfo, this.hdr10PlusInfo);
        }

        @NotNull
        public final a b(int value) {
            this.colorStandard = value;
            return this;
        }

        @NotNull
        public final a c(int value) {
            this.colorTransfer = value;
            return this;
        }

        @NotNull
        public final a d(@Nullable byte[] value) {
            this.hdr10PlusInfo = value;
            return this;
        }

        @NotNull
        public final a e(@Nullable byte[] value) {
            this.hdrStaticInfo = value;
            return this;
        }

        @NotNull
        public final a f(int value) {
            this.level = value;
            return this;
        }

        @NotNull
        public final a g(int value) {
            this.profile = value;
            return this;
        }
    }

    public VideoFormatInfo(int i3, int i16, int i17, int i18, int i19, @Nullable byte[] bArr, @Nullable byte[] bArr2) {
        this.colorStandard = i3;
        this.colorTransfer = i16;
        this.profile = i17;
        this.level = i18;
        this.bitrate = i19;
        this.hdrStaticInfo = bArr;
        this.hdr10PlusInfo = bArr2;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    public final int getColorStandard() {
        return this.colorStandard;
    }

    public final int getColorTransfer() {
        return this.colorTransfer;
    }

    @Nullable
    public final byte[] getHdr10PlusInfo() {
        return this.hdr10PlusInfo;
    }

    @Nullable
    public final byte[] getHdrStaticInfo() {
        return this.hdrStaticInfo;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getProfile() {
        return this.profile;
    }

    public final boolean isHdrVideo() {
        if (this.colorStandard == 6) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "VideoFormatInfo(colorStandard=" + this.colorStandard + ", colorTransfer=" + this.colorTransfer + ", profile=" + this.profile + ", level=" + this.level + ", bitrate=" + this.bitrate + ", hdrStaticInfo=" + this.hdrStaticInfo + ", hdr10PlusInfo=" + this.hdr10PlusInfo + ")";
    }
}

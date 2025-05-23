package com.tencent.richframework.gallery.bean;

import com.tencent.biz.richframework.util.RFWFileUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0002\u001f B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\t\u00a8\u0006!"}, d2 = {"Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo;", "Ljava/io/Serializable;", "()V", "_currentPicInfo", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;", "bigPicInfo", "getBigPicInfo", "()Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;", "setBigPicInfo", "(Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;)V", "picInfo", "currentPicInfo", "getCurrentPicInfo", "setCurrentPicInfo", "downloadPicInfo", "getDownloadPicInfo", "setDownloadPicInfo", "maxsizeFile", "", "getMaxsizeFile", "()Ljava/lang/String;", "originPicInfo", "getOriginPicInfo", "setOriginPicInfo", "picId", "getPicId", "setPicId", "(Ljava/lang/String;)V", "smallPicInfo", "getSmallPicInfo", "setSmallPicInfo", "PicType", "RFWPicInfo", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerPicInfo implements Serializable {
    private RFWPicInfo _currentPicInfo;

    @Nullable
    private RFWPicInfo bigPicInfo;

    @Nullable
    private RFWPicInfo downloadPicInfo;

    @Nullable
    private RFWPicInfo originPicInfo;

    @Nullable
    private String picId;

    @Nullable
    private RFWPicInfo smallPicInfo;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$PicType;", "", "(Ljava/lang/String;I)V", "THUMB", "LARGE", "ORIGIN", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public enum PicType {
        THUMB,
        LARGE,
        ORIGIN
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;", "Ljava/io/Serializable;", "()V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "isExist", "", "()Z", "localPath", "", "getLocalPath", "()Ljava/lang/String;", "setLocalPath", "(Ljava/lang/String;)V", "size", "", "getSize", "()J", "setSize", "(J)V", "url", "getUrl", "setUrl", "width", "getWidth", "setWidth", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class RFWPicInfo implements Serializable {
        private int height;

        @Nullable
        private String localPath;
        private long size;

        @Nullable
        private String url;
        private int width;

        public final int getHeight() {
            return this.height;
        }

        @Nullable
        public final String getLocalPath() {
            return this.localPath;
        }

        public final long getSize() {
            return this.size;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        public final int getWidth() {
            return this.width;
        }

        public final boolean isExist() {
            return RFWFileUtils.fileExists(this.localPath);
        }

        public final void setHeight(int i3) {
            this.height = i3;
        }

        public final void setLocalPath(@Nullable String str) {
            this.localPath = str;
        }

        public final void setSize(long j3) {
            this.size = j3;
        }

        public final void setUrl(@Nullable String str) {
            this.url = str;
        }

        public final void setWidth(int i3) {
            this.width = i3;
        }
    }

    @Nullable
    public final RFWPicInfo getBigPicInfo() {
        return this.bigPicInfo;
    }

    @NotNull
    public final RFWPicInfo getCurrentPicInfo() {
        RFWPicInfo rFWPicInfo = this._currentPicInfo;
        if (rFWPicInfo == null) {
            rFWPicInfo = this.bigPicInfo;
        }
        if (rFWPicInfo == null) {
            rFWPicInfo = this.originPicInfo;
        }
        if (rFWPicInfo == null) {
            rFWPicInfo = this.smallPicInfo;
        }
        if (rFWPicInfo == null) {
            return new RFWPicInfo();
        }
        return rFWPicInfo;
    }

    @Nullable
    public final RFWPicInfo getDownloadPicInfo() {
        return this.downloadPicInfo;
    }

    @Nullable
    public final String getMaxsizeFile() {
        RFWPicInfo rFWPicInfo = this.originPicInfo;
        if (rFWPicInfo != null) {
            Intrinsics.checkNotNull(rFWPicInfo);
            if (rFWPicInfo.isExist()) {
                RFWPicInfo rFWPicInfo2 = this.originPicInfo;
                Intrinsics.checkNotNull(rFWPicInfo2);
                return rFWPicInfo2.getLocalPath();
            }
        }
        RFWPicInfo rFWPicInfo3 = this.bigPicInfo;
        if (rFWPicInfo3 != null) {
            Intrinsics.checkNotNull(rFWPicInfo3);
            if (rFWPicInfo3.isExist()) {
                RFWPicInfo rFWPicInfo4 = this.bigPicInfo;
                Intrinsics.checkNotNull(rFWPicInfo4);
                return rFWPicInfo4.getLocalPath();
            }
        }
        RFWPicInfo rFWPicInfo5 = this.smallPicInfo;
        if (rFWPicInfo5 != null) {
            Intrinsics.checkNotNull(rFWPicInfo5);
            if (rFWPicInfo5.isExist()) {
                RFWPicInfo rFWPicInfo6 = this.smallPicInfo;
                Intrinsics.checkNotNull(rFWPicInfo6);
                return rFWPicInfo6.getLocalPath();
            }
        }
        return null;
    }

    @Nullable
    public final RFWPicInfo getOriginPicInfo() {
        return this.originPicInfo;
    }

    @Nullable
    public final String getPicId() {
        return this.picId;
    }

    @Nullable
    public final RFWPicInfo getSmallPicInfo() {
        return this.smallPicInfo;
    }

    public final void setBigPicInfo(@Nullable RFWPicInfo rFWPicInfo) {
        this.bigPicInfo = rFWPicInfo;
    }

    public final void setCurrentPicInfo(@NotNull RFWPicInfo picInfo) {
        Intrinsics.checkNotNullParameter(picInfo, "picInfo");
        this._currentPicInfo = picInfo;
    }

    public final void setDownloadPicInfo(@Nullable RFWPicInfo rFWPicInfo) {
        this.downloadPicInfo = rFWPicInfo;
    }

    public final void setOriginPicInfo(@Nullable RFWPicInfo rFWPicInfo) {
        this.originPicInfo = rFWPicInfo;
    }

    public final void setPicId(@Nullable String str) {
        this.picId = str;
    }

    public final void setSmallPicInfo(@Nullable RFWPicInfo rFWPicInfo) {
        this.smallPicInfo = rFWPicInfo;
    }
}

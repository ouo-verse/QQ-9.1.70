package com.tencent.mobileqq.winkpublish.model.params;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.msf.core.auth.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/MediaParams;", "Landroid/os/Parcelable;", "()V", "getMediaType", "", "Companion", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public abstract class MediaParams implements Parcelable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int MEDIA_TYPE_IMAGE = 0;
    public static final int MEDIA_TYPE_NET_VIDEO = 2;
    public static final int MEDIA_TYPE_VIDEO = 1;

    @NotNull
    private static final String TAG = "MediaParams";

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rJ&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/MediaParams$Companion;", "", "()V", "MEDIA_TYPE_IMAGE", "", "MEDIA_TYPE_NET_VIDEO", "MEDIA_TYPE_VIDEO", "TAG", "", k.f247491e, "", "Lcom/tencent/mobileqq/winkpublish/model/params/MediaParams;", "parcel", "Landroid/os/Parcel;", k.f247492f, "", "mediaParamsList", WadlProxyConsts.FLAGS, "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final List<MediaParams> read(@NotNull Parcel parcel) {
            NetVideoParams netVideoParams;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            if (readInt < 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < readInt; i3++) {
                int readInt2 = parcel.readInt();
                if (readInt2 != 0) {
                    if (readInt2 != 1) {
                        if (readInt2 == 2 && (netVideoParams = (NetVideoParams) parcel.readParcelable(NetVideoParams.class.getClassLoader())) != null) {
                            arrayList.add(netVideoParams);
                        }
                    } else {
                        VideoParams videoParams = (VideoParams) parcel.readParcelable(VideoParams.class.getClassLoader());
                        if (videoParams != null) {
                            arrayList.add(videoParams);
                        }
                    }
                } else {
                    ImageParams imageParams = (ImageParams) parcel.readParcelable(ImageParams.class.getClassLoader());
                    if (imageParams != null) {
                        arrayList.add(imageParams);
                    }
                }
            }
            return arrayList;
        }

        public final void write(@NotNull Parcel parcel, @Nullable List<? extends MediaParams> mediaParamsList, int flags) {
            boolean z16;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            List<? extends MediaParams> list = mediaParamsList;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                parcel.writeInt(-1);
                return;
            }
            parcel.writeInt(mediaParamsList.size());
            for (MediaParams mediaParams : mediaParamsList) {
                parcel.writeInt(mediaParams.getType());
                parcel.writeParcelable(mediaParams, flags);
            }
        }

        Companion() {
        }
    }

    /* renamed from: getMediaType */
    public abstract int getType();
}

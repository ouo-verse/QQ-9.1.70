package com.tencent.mobileqq.guild.feed.nativepublish.utils;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.guild.temp.api.IGuildFeedMediaApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005J\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorMediaFormatChecker;", "", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "source", "", "validMediaOutputList", "", "a", "b", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedEditorMediaFormatChecker {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FeedEditorMediaFormatChecker f222314a = new FeedEditorMediaFormatChecker();

    FeedEditorMediaFormatChecker() {
    }

    public final int a(@NotNull List<? extends LocalMediaInfo> source, @Nullable List<LocalMediaInfo> validMediaOutputList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(source, "source");
        QRouteApi api = QRoute.api(IGuildFeedMediaApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildFeedMediaApi::class.java)");
        com.tencent.mobileqq.guild.temp.api.e eVar = (com.tencent.mobileqq.guild.temp.api.e) api;
        String[] strArr = {""};
        if (validMediaOutputList == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        int size = source.size();
        for (int i3 = 0; i3 < size; i3++) {
            LocalMediaInfo localMediaInfo = source.get(i3);
            int mediaType = QAlbumUtil.getMediaType(localMediaInfo);
            if (mediaType != 0) {
                if (mediaType != 1) {
                    QLog.e("FeedEditorRichContentFormatChecker", 1, "[checkMediaContentType]: index=" + i3 + ", path=" + localMediaInfo.path + ", unknown media type: " + mediaType);
                    if (z16) {
                        return -1;
                    }
                } else {
                    int isValidVideo = eVar.isValidVideo(localMediaInfo, strArr);
                    if (isValidVideo != 0) {
                        QLog.e("FeedEditorRichContentFormatChecker", 1, "[checkMediaContentType]: index=" + i3 + ", path=" + localMediaInfo.path + ", invalid video reason=" + strArr[0]);
                        if (z16) {
                            return isValidVideo;
                        }
                    } else if (!z16) {
                        Intrinsics.checkNotNull(validMediaOutputList);
                        validMediaOutputList.add(localMediaInfo);
                    }
                }
            } else {
                int isValidImage = eVar.isValidImage(localMediaInfo, strArr);
                if (isValidImage != 0) {
                    QLog.e("FeedEditorRichContentFormatChecker", 1, "[checkMediaContentType]:  index=" + i3 + ", path=" + localMediaInfo.path + ", invalid image, reason=" + strArr[0]);
                    if (z16) {
                        return isValidImage;
                    }
                } else if (!z16) {
                    Intrinsics.checkNotNull(validMediaOutputList);
                    validMediaOutputList.add(localMediaInfo);
                }
            }
        }
        return 0;
    }

    @NotNull
    public final List<LocalMediaInfo> b(@NotNull List<? extends LocalMediaInfo> source) {
        Sequence asSequence;
        Sequence filter;
        List<LocalMediaInfo> list;
        Intrinsics.checkNotNullParameter(source, "source");
        QRouteApi api = QRoute.api(IGuildFeedMediaApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildFeedMediaApi::class.java)");
        final com.tencent.mobileqq.guild.temp.api.e eVar = (com.tencent.mobileqq.guild.temp.api.e) api;
        asSequence = CollectionsKt___CollectionsKt.asSequence(source);
        filter = SequencesKt___SequencesKt.filter(asSequence, new Function1<LocalMediaInfo, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.utils.FeedEditorMediaFormatChecker$filterQRCodeMediaList$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull LocalMediaInfo it) {
                boolean z16;
                Intrinsics.checkNotNullParameter(it, "it");
                if (QAlbumUtil.getMediaType(it) == 0) {
                    com.tencent.mobileqq.guild.temp.api.e eVar2 = com.tencent.mobileqq.guild.temp.api.e.this;
                    String str = it.path;
                    Intrinsics.checkNotNullExpressionValue(str, "it.path");
                    if (eVar2.hasQRCode(str)) {
                        z16 = true;
                        return Boolean.valueOf(z16);
                    }
                }
                z16 = false;
                return Boolean.valueOf(z16);
            }
        });
        list = SequencesKt___SequencesKt.toList(filter);
        return list;
    }
}

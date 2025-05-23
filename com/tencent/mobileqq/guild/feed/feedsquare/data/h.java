package com.tencent.mobileqq.guild.feed.feedsquare.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "", "", "b", "Lij1/g;", "a", "Lij1/g;", "()Lij1/g;", "blockData", "<init>", "(Lij1/g;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ij1.g blockData;

    public h(@NotNull ij1.g blockData) {
        Intrinsics.checkNotNullParameter(blockData, "blockData");
        this.blockData = blockData;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final ij1.g getBlockData() {
        return this.blockData;
    }

    public int b() {
        int i3 = this.blockData.b().recommendCard.cardType;
        if (i3 != 1) {
            if (i3 != 2) {
                int i16 = 3;
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (this.blockData.b().feedType != 2) {
                                int i17 = this.blockData.b().summary.layoutType;
                                if (i17 == 2) {
                                    return 4;
                                }
                                if (i17 == 3) {
                                    return 5;
                                }
                                if (i17 != 5) {
                                    i16 = 7;
                                    if (i17 != 7) {
                                        i16 = 8;
                                        if (i17 != 8) {
                                            i16 = 9;
                                            if (i17 != 9) {
                                                return 2;
                                            }
                                        }
                                    }
                                } else {
                                    return 6;
                                }
                            }
                            return i16;
                        }
                        return 19;
                    }
                    return 17;
                }
                return 15;
            }
            return 13;
        }
        return 14;
    }
}

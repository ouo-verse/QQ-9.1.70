package pa0;

import feedcloud.FeedCloudPubGuideSvr$GuideResource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0000\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u0000\u00a8\u0006\u0005"}, d2 = {"Lpa0/d;", "Lpa0/a;", "a", "Lpa0/b;", "b", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class e {
    @Nullable
    public static final PlusMenuIconData a(@Nullable PlusMenuServerData plusMenuServerData) {
        if (plusMenuServerData == null) {
            return null;
        }
        return new PlusMenuIconData(plusMenuServerData.a(), plusMenuServerData.c());
    }

    @Nullable
    public static final PlusMenuNewerPendentGuideData b(@Nullable PlusMenuServerData plusMenuServerData) {
        FeedCloudPubGuideSvr$GuideResource b16;
        boolean z16;
        boolean z17;
        if (plusMenuServerData == null || (b16 = plusMenuServerData.b()) == null) {
            return null;
        }
        String title = b16.guide_word.get();
        String iconUrl = b16.thumbnail_img.get();
        String tag = b16.guide_tag.get();
        boolean z18 = false;
        if (title != null && title.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        if (iconUrl != null && iconUrl.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            return null;
        }
        if (tag == null || tag.length() == 0) {
            z18 = true;
        }
        if (z18) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(title, "title");
        Intrinsics.checkNotNullExpressionValue(iconUrl, "iconUrl");
        Intrinsics.checkNotNullExpressionValue(tag, "tag");
        return new PlusMenuNewerPendentGuideData(title, iconUrl, tag);
    }
}

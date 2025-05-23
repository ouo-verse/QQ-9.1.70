package e05;

import com.tencent.mobileqq.nearbypro.profile.avatar.MyNearbyProBizScene;

/* compiled from: P */
/* loaded from: classes28.dex */
public final /* synthetic */ class a {
    public static /* synthetic */ int a(int i3) {
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return 1;
        }
        if (i3 == 3) {
            return 2;
        }
        if (i3 == 4) {
            return 3;
        }
        if (i3 == 5) {
            return 4;
        }
        if (i3 == 6) {
            return -1;
        }
        throw null;
    }

    public static /* synthetic */ String b(int i3) {
        if (i3 == 1) {
            return "DEFAULT_ACTION";
        }
        if (i3 == 2) {
            return "IMPRESSION";
        }
        if (i3 == 3) {
            return MyNearbyProBizScene.CLICK;
        }
        if (i3 == 4) {
            return "PAGE_VIEW";
        }
        if (i3 == 5) {
            return "PAGE_END";
        }
        if (i3 == 6) {
            return "UNRECOGNIZED";
        }
        return "null";
    }
}

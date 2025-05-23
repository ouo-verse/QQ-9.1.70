package com.tencent.state.square.detail;

import android.os.Bundle;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/detail/EntranceSource;", "", "main", "Lcom/tencent/state/square/detail/MainScene;", "sub", "Lcom/tencent/state/square/detail/SubScene;", "refSource", "", "(Lcom/tencent/state/square/detail/MainScene;Lcom/tencent/state/square/detail/SubScene;Ljava/lang/String;)V", "getMain", "()Lcom/tencent/state/square/detail/MainScene;", "getRefSource", "()Ljava/lang/String;", "getSub", "()Lcom/tencent/state/square/detail/SubScene;", "fromChatLandSquare", "", "fromSquare", "getReportSourceId", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class EntranceSource {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<Integer, MainScene> schemeSceneMap;
    private final MainScene main;
    private final String refSource;
    private final SubScene sub;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/square/detail/EntranceSource$Companion;", "", "()V", "schemeSceneMap", "Ljava/util/HashMap;", "", "Lcom/tencent/state/square/detail/MainScene;", "Lkotlin/collections/HashMap;", "covertFromScheme", "Lcom/tencent/state/square/detail/EntranceSource;", "bundle", "Landroid/os/Bundle;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
        
            r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final EntranceSource covertFromScheme(Bundle bundle) {
            String str;
            Integer intOrNull;
            int intValue = (bundle == null || (r0 = bundle.getString("scene")) == null || intOrNull == null) ? 0 : intOrNull.intValue();
            if (bundle == null || (str = bundle.getString("subReferer")) == null) {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "bundle?.getString(KEY_OP\u2026DETAIL_SUB_REFERER) ?: \"\"");
            MainScene mainScene = (MainScene) EntranceSource.schemeSceneMap.get(Integer.valueOf(intValue));
            if (mainScene == null) {
                mainScene = MainScene.UNKNOWN;
            }
            Intrinsics.checkNotNullExpressionValue(mainScene, "schemeSceneMap[scene] ?: MainScene.UNKNOWN");
            return new EntranceSource(mainScene, SubScene.UNKNOWN, str);
        }
    }

    static {
        HashMap<Integer, MainScene> hashMap = new HashMap<>();
        hashMap.put(0, MainScene.UNKNOWN);
        hashMap.put(1, MainScene.SQUARE);
        hashMap.put(2, MainScene.LIBRARY);
        hashMap.put(3, MainScene.REAL_MAP);
        hashMap.put(4, MainScene.POSTER);
        hashMap.put(5, MainScene.MYSTERY_BOX);
        hashMap.put(6, MainScene.AIO);
        hashMap.put(7, MainScene.H5);
        schemeSceneMap = hashMap;
    }

    public EntranceSource() {
        this(null, null, null, 7, null);
    }

    public final boolean fromChatLandSquare() {
        return this.main.compareTo(MainScene.SQUARE_CHAT_BLOCK) >= 0;
    }

    public final boolean fromSquare() {
        return this.main == MainScene.SQUARE;
    }

    public final MainScene getMain() {
        return this.main;
    }

    public final String getRefSource() {
        return this.refSource;
    }

    public final int getReportSourceId() {
        int ordinal = this.main.ordinal();
        if (ordinal == MainScene.SQUARE.ordinal()) {
            return this.sub == SubScene.SQUARE_FRIEND_STATUS_PANEL ? 11 : 1;
        }
        if (ordinal == MainScene.LIBRARY.ordinal()) {
            return 2;
        }
        if (ordinal == MainScene.REAL_MAP.ordinal()) {
            return 3;
        }
        if (ordinal == MainScene.POSTER.ordinal()) {
            return 4;
        }
        if (ordinal == MainScene.MYSTERY_BOX.ordinal()) {
            return 5;
        }
        if (ordinal == MainScene.AIO.ordinal()) {
            return 6;
        }
        if (ordinal == MainScene.H5.ordinal()) {
            return 7;
        }
        if (ordinal == MainScene.HIPPY.ordinal()) {
            return 9;
        }
        return ordinal == MainScene.COLLECT_CARD.ordinal() ? 10 : 0;
    }

    public final SubScene getSub() {
        return this.sub;
    }

    public EntranceSource(MainScene main, SubScene sub, String refSource) {
        Intrinsics.checkNotNullParameter(main, "main");
        Intrinsics.checkNotNullParameter(sub, "sub");
        Intrinsics.checkNotNullParameter(refSource, "refSource");
        this.main = main;
        this.sub = sub;
        this.refSource = refSource;
    }

    public /* synthetic */ EntranceSource(MainScene mainScene, SubScene subScene, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? MainScene.UNKNOWN : mainScene, (i3 & 2) != 0 ? SubScene.UNKNOWN : subScene, (i3 & 4) != 0 ? "" : str);
    }
}

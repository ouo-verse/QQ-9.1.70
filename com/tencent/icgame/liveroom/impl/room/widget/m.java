package com.tencent.icgame.liveroom.impl.room.widget;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ow0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/icgame/liveroom/impl/room/widget/m;", "", "a", "b", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f116192b = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J1\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0018\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0010R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006%"}, d2 = {"Lcom/tencent/icgame/liveroom/impl/room/widget/m$b;", "", "", "url", "", "dpHeight", "", "isRoom", "", "roomId", "", "a", "(Ljava/lang/String;FZLjava/lang/Long;)V", "b", "(Ljava/lang/Long;)V", "TAG", "Ljava/lang/String;", "TRICKS_HISTORY_TEST_URL", "TRICKS_HISTORY_URL", "", "TRICKS_OFFLINE_BID", "I", "TRICKS_POPUP_DIALOG_TEST_URL", "TRICKS_POPUP_DIALOG_URL", "TRICKS_POPUP_OFFLINE_BID", "TRICKS_TEST_URL", "TRICKS_URL", "com/tencent/icgame/liveroom/impl/room/widget/m$a", "callback", "Lcom/tencent/icgame/liveroom/impl/room/widget/m$a;", "isPreloadBid", "Z", "Lnw0/a;", "showDialogHelper", "Lnw0/a;", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.icgame.liveroom.impl.room.widget.m$b, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0099  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void a(String url, float dpHeight, boolean isRoom, Long roomId) {
            String str;
            int i3;
            float f16;
            int i16;
            String str2 = url + "&room_id=" + roomId;
            if (!isRoom) {
                str = "&front=1";
            } else {
                str = "&fromSetting=1";
            }
            String str3 = str2 + str;
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#ff06011c"));
            QBaseActivity b16 = bu0.a.b();
            a.C10963a a16 = ow0.a.a(str3);
            Map<String, String> map = a16.f424212b;
            if (map != null) {
                if (map.get("height") != null) {
                    int i17 = 0;
                    try {
                        i16 = x.h(b16, x.f(b16).f185861b);
                        try {
                            i17 = x.h(b16, x.f(b16).f185860a);
                            String str4 = a16.f424212b.get("height");
                            Intrinsics.checkNotNull(str4);
                            f16 = Float.parseFloat(str4);
                        } catch (Exception unused) {
                            i3 = i17;
                            i17 = i16;
                            QLog.e("ICGameUnknown|ICGameTricksViewClick", 1, "parseFloat error");
                            f16 = 1.0f;
                            int i18 = i3;
                            i16 = i17;
                            i17 = i18;
                            if (i16 > i17) {
                            }
                            dpHeight = i17 * f16;
                            if (a16.f424212b.get("bgColor") != null) {
                            }
                            com.tencent.icgame.game.liveroom.impl.room.livewebdialog.f.l(b16, x.c(b16, dpHeight), colorDrawable, str3);
                        }
                    } catch (Exception unused2) {
                        i3 = 0;
                    }
                    if (i16 > i17) {
                        i17 = i16;
                    }
                    dpHeight = i17 * f16;
                }
                if (a16.f424212b.get("bgColor") != null) {
                    String str5 = a16.f424212b.get("bgColor");
                    if (!TextUtils.isEmpty(str5)) {
                        try {
                            colorDrawable = new ColorDrawable(Color.parseColor("#" + str5));
                        } catch (Exception unused3) {
                            QLog.e("ICGameUnknown|ICGameTricksViewClick", 1, "onClickInner, parse bgColor error");
                        }
                    }
                }
            }
            com.tencent.icgame.game.liveroom.impl.room.livewebdialog.f.l(b16, x.c(b16, dpHeight), colorDrawable, str3);
        }

        public final void b(@Nullable Long roomId) {
            if (SSODebugUtil.isTestEnv()) {
                a("https://tde.qlive.qq.com/cos/live/h5/blessing-bag/user.html?_tde_id=6881&historyEntrance=1&loading=dark", 532.0f, true, roomId);
            } else {
                a("https://qlive.qq.com/cos/live/h5/blessing-bag/user.html?_bid=5177&historyEntrance=1&loading=dark", 532.0f, true, roomId);
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/icgame/liveroom/impl/room/widget/m$a", "Lcom/tencent/biz/common/offline/a;", "", "param1", "", "code", "", "loaded", "progress", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements com.tencent.biz.common.offline.a {
        a() {
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(@Nullable String param1, int code) {
            rt0.a.INSTANCE.k("ICGameUnknown|ICGameTricksViewClick", "AsyncBack", "offline url loaded bid=" + param1 + " code = " + code);
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int progress) {
        }
    }
}

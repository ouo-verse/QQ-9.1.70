package com.tencent.mobileqq.troop.recent;

import android.graphics.drawable.Drawable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mutualmark.nt.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.luckycharacter.api.ITroopLuckyCharacterService;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/recent/c;", "Lcom/tencent/mobileqq/troop/recent/a;", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "d", "", "troopUin", "a", "", "Landroid/graphics/drawable/Drawable;", "b", "", "c", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/troop/recent/b;", "Ljava/util/concurrent/ConcurrentHashMap;", "mRecentTroopLuckyCharCache", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, b> mRecentTroopLuckyCharCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/recent/c$a;", "", "", "LUCK_WORD_HEIGHT", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.recent.c$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62268);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mRecentTroopLuckyCharCache = new ConcurrentHashMap<>();
        }
    }

    private final boolean d(AppRuntime appRuntime, TroopInfo troopInfo) {
        boolean z16;
        List listOf;
        ArrayList arrayListOf;
        String luckyCharUrl = ((ITroopLuckyCharacterService) appRuntime.getRuntimeService(ITroopLuckyCharacterService.class, "")).getLuckyCharacterPicUrl(troopInfo);
        b bVar = this.mRecentTroopLuckyCharCache.get(troopInfo.getTroopUin());
        if (luckyCharUrl != null && luckyCharUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (bVar == null) {
                return false;
            }
            this.mRecentTroopLuckyCharCache.remove(troopInfo.getTroopUin());
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(luckyCharUrl, "luckyCharUrl");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(luckyCharUrl);
        if (bVar == null || !Intrinsics.areEqual(bVar.b(), listOf)) {
            SingleLineTextView.IconDrawableInfo iconDrawableInfo = new SingleLineTextView.IconDrawableInfo();
            iconDrawableInfo.icon_static_url = luckyCharUrl;
            Drawable i3 = f.f252196a.i(appRuntime.getApplicationContext(), iconDrawableInfo, 16.0f);
            ConcurrentHashMap<String, b> concurrentHashMap = this.mRecentTroopLuckyCharCache;
            String troopUin = troopInfo.getTroopUin();
            Intrinsics.checkNotNullExpressionValue(troopUin, "troopInfo.troopUin");
            String currentAccountUin = appRuntime.getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appRuntime.currentAccountUin");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(i3);
            concurrentHashMap.put(troopUin, new b(currentAccountUin, listOf, arrayListOf));
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.recent.a
    public boolean a(@NotNull AppRuntime appRuntime, @NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) troopUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        TroopInfo findTroopInfo = ((ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(troopUin);
        if (findTroopInfo != null) {
            return d(appRuntime, findTroopInfo);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.recent.a
    @Nullable
    public List<Drawable> b(@NotNull AppRuntime appRuntime, @NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        b bVar = this.mRecentTroopLuckyCharCache.get(troopUin);
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.troop.recent.a
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mRecentTroopLuckyCharCache.clear();
        }
    }
}

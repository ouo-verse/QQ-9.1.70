package com.tencent.mobileqq.troop.recent;

import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mutualmark.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.recent.api.IRecentTroopIconService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/recent/TroopIconTitleProcessor;", "Lcom/tencent/qqnt/chats/inject/title/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "view", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopIconTitleProcessor extends com.tencent.qqnt.chats.inject.title.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/recent/TroopIconTitleProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "", "UIN_TAG", "I", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.recent.TroopIconTitleProcessor$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62273);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopIconTitleProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.inject.title.a
    public void a(@NotNull g item, @NotNull final SingleLineTextView view) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if (item.n() == 2 && !((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).isExit(String.valueOf(item.l()), "TroopIconTitleProcessor", false)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Drawable[] drawableArr = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IRecentTroopIconService.class, "");
            } else {
                iRuntimeService = null;
            }
            IRecentTroopIconService iRecentTroopIconService = (IRecentTroopIconService) iRuntimeService;
            if (iRecentTroopIconService != null) {
                List<Drawable> troopIconListFromCache = iRecentTroopIconService.getTroopIconListFromCache(item.k());
                if (troopIconListFromCache != null) {
                    for (Drawable drawable : troopIconListFromCache) {
                        if (drawable instanceof e) {
                            eVar = (e) drawable;
                        } else {
                            eVar = null;
                        }
                        if (eVar != null) {
                            eVar.a(view);
                        }
                    }
                }
                if (troopIconListFromCache != null) {
                    Object[] array = troopIconListFromCache.toArray(new Drawable[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    drawableArr = (Drawable[]) array;
                }
                view.setIconDrawables(drawableArr, true);
                view.setTag(-10, item.k());
                iRecentTroopIconService.checkTroopIconListAsync(item.k(), troopIconListFromCache, new Function2<String, List<? extends Drawable>, Unit>() { // from class: com.tencent.mobileqq.troop.recent.TroopIconTitleProcessor$updateTitle$1$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SingleLineTextView.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(String str, List<? extends Drawable> list) {
                        invoke2(str, list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull String troopUin, @Nullable List<? extends Drawable> list) {
                        Drawable[] drawableArr2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopUin, (Object) list);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
                        Object tag = SingleLineTextView.this.getTag(-10);
                        String str = tag instanceof String ? (String) tag : null;
                        if (Intrinsics.areEqual(troopUin, str)) {
                            SingleLineTextView.this.setIconDrawablePadding(0, (int) com.tencent.qqnt.chats.tmp.a.a());
                            if (list != null) {
                                SingleLineTextView singleLineTextView = SingleLineTextView.this;
                                for (Drawable drawable2 : list) {
                                    e eVar2 = drawable2 instanceof e ? (e) drawable2 : null;
                                    if (eVar2 != null) {
                                        eVar2.a(singleLineTextView);
                                    }
                                }
                            }
                            SingleLineTextView singleLineTextView2 = SingleLineTextView.this;
                            if (list != null) {
                                Object[] array2 = list.toArray(new Drawable[0]);
                                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                drawableArr2 = (Drawable[]) array2;
                            } else {
                                drawableArr2 = null;
                            }
                            singleLineTextView2.setIconDrawables(drawableArr2, true);
                            QLog.i("TroopIconTitleProcessor", 1, "RecentTroopIcon TroopIconTitleProcessor  checkTroopIconListAsync callback success! view = " + SingleLineTextView.this.hashCode() + "  size = " + (list != null ? Integer.valueOf(list.size()) : null) + " troopUin = " + troopUin + " troopUinTag = " + str);
                        }
                    }
                });
                return;
            }
            return;
        }
        view.setTag(-10, "");
    }
}

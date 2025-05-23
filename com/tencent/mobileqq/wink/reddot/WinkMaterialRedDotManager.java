package com.tencent.mobileqq.wink.reddot;

import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.reddot.material.MaterialRedDotHandler;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\u0014\u0010\r\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004R/\u0010\u0015\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\u00110\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R@\u0010\u001e\u001a.\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00160\u001bj\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0016`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/wink/reddot/WinkMaterialRedDotManager;", "", "", "id", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "type", "", "d", "", "g", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", IVideoFilterTools.CATEGORYS, "i", "menuType", "a", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "b", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "notifyTypeChildClear", "Lcom/tencent/mobileqq/wink/reddot/a;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "c", "Lcom/tencent/mobileqq/wink/reddot/a;", "materialHandler", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "handlerMap", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMaterialRedDotManager {

    /* renamed from: a */
    @NotNull
    public static final WinkMaterialRedDotManager f326249a = new WinkMaterialRedDotManager();

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static final MutableLiveData<Pair<MenuType, List<String>>> notifyTypeChildClear = new MutableLiveData<>();

    /* renamed from: c, reason: from kotlin metadata */
    @NotNull
    private static final a<MetaCategory, MetaMaterial> materialHandler;

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private static final HashMap<MenuType, a<?, ?>> handlerMap;

    static {
        MaterialRedDotHandler materialRedDotHandler = new MaterialRedDotHandler();
        materialHandler = materialRedDotHandler;
        HashMap<MenuType, a<?, ?>> hashMap = new HashMap<>();
        handlerMap = hashMap;
        hashMap.put(MenuType.VIDEO_TEMPLATE, materialRedDotHandler);
    }

    WinkMaterialRedDotManager() {
    }

    public static /* synthetic */ void e(WinkMaterialRedDotManager winkMaterialRedDotManager, String str, MenuType menuType, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            menuType = MenuType.VIDEO_TEMPLATE;
        }
        winkMaterialRedDotManager.d(str, menuType);
    }

    public static /* synthetic */ boolean h(WinkMaterialRedDotManager winkMaterialRedDotManager, String str, MenuType menuType, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            menuType = MenuType.VIDEO_TEMPLATE;
        }
        return winkMaterialRedDotManager.g(str, menuType);
    }

    @NotNull
    public final String a(@NotNull MenuType menuType) {
        String c16;
        Intrinsics.checkNotNullParameter(menuType, "menuType");
        a<?, ?> aVar = handlerMap.get(menuType);
        if (aVar == null || (c16 = aVar.c()) == null) {
            return "";
        }
        return c16;
    }

    @NotNull
    public final MutableLiveData<Pair<MenuType, List<String>>> b() {
        return notifyTypeChildClear;
    }

    @JvmOverloads
    public final void c(@NotNull String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        e(this, id5, null, 2, null);
    }

    @JvmOverloads
    public final void d(@NotNull String id5, @NotNull MenuType type) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        a<?, ?> aVar = handlerMap.get(type);
        if (aVar != null) {
            aVar.b(id5, new Function1<List<? extends String>, Unit>() { // from class: com.tencent.mobileqq.wink.reddot.WinkMaterialRedDotManager$recordRedDotClicked$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                    invoke2((List<String>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull List<String> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    WinkMaterialRedDotManager.f326249a.b().setValue(TuplesKt.to(MenuType.VIDEO_TEMPLATE, it));
                }
            });
        }
    }

    @JvmOverloads
    public final boolean f(@NotNull String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        return h(this, id5, null, 2, null);
    }

    @JvmOverloads
    public final boolean g(@NotNull String id5, @NotNull MenuType type) {
        boolean z16;
        a<?, ?> aVar;
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        if (id5.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || (aVar = handlerMap.get(type)) == null) {
            return false;
        }
        return aVar.a(id5);
    }

    public final void i(@NotNull List<MetaCategory> r26) {
        Intrinsics.checkNotNullParameter(r26, "categorys");
        materialHandler.d(r26);
    }
}

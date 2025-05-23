package com.tencent.qqnt.chats.data.processor;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.data.GroupMemberStrangerTitleProcessor;
import com.tencent.mobileqq.mutualmark.nt.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.troop.troopgag.TroopGagConvertProcessor;
import com.tencent.mobileqq.vas.process.VasRecentInfoProcess;
import com.tencent.qqnt.chats.data.converter.e;
import com.tencent.qqnt.chats.data.converter.g;
import com.tencent.qqnt.chats.data.processor.part.SummaryConvertProcessor;
import com.tencent.qqnt.chats.data.processor.part.TitleConvertProcessor;
import com.tencent.qqnt.chats.data.processor.part.c;
import com.tencent.qqnt.chats.data.processor.part.d;
import cooperation.qzone.util.QZoneImageUtils;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/chats/data/processor/a;", "Lcom/tencent/qqnt/chats/data/converter/e;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", QZoneImageUtils.KEY_MATCH, "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "isFirst", "", "update", "", "Lcom/tencent/qqnt/chats/data/converter/g;", "a", "Ljava/util/List;", "mPartProcessorList", "b", "mBizProcessorList", "<init>", "()V", "c", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_ConvertProcessor.yml", version = 9)
    @NotNull
    private static final ArrayList<Class<g>> f355148d;

    /* renamed from: e, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_ConvertProcessor.yml", version = 9)
    @NotNull
    private static final ArrayList<Class<g>> f355149e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<g> mPartProcessorList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<g> mBizProcessorList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/data/processor/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.data.processor.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44798);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<g>> arrayList = new ArrayList<>();
        f355148d = arrayList;
        arrayList.add(d.class);
        arrayList.add(h.class);
        arrayList.add(VasRecentInfoProcess.class);
        arrayList.add(com.tencent.mobileqq.phonecontact.nt.a.class);
        arrayList.add(com.tencent.qqnt.chats.b.class);
        arrayList.add(com.tencent.qqnt.chats.data.processor.part.b.class);
        arrayList.add(GroupMemberStrangerTitleProcessor.class);
        arrayList.add(ja2.b.class);
        arrayList.add(y44.a.class);
        arrayList.add(TroopGagConvertProcessor.class);
        f355149e = new ArrayList<>();
    }

    public a() {
        int collectionSizeOrDefault;
        List<g> list;
        Object first;
        int collectionSizeOrDefault2;
        Object first2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList<Class<g>> arrayList = f355149e;
        if (!arrayList.isEmpty()) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
                Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
                first = ArraysKt___ArraysKt.first(constructors);
                Object newInstance = ((Constructor) first).newInstance(new Object[0]);
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.chats.data.converter.IPartConvertProcessor");
                arrayList2.add((g) newInstance);
            }
            list = arrayList2;
        } else {
            list = CollectionsKt__CollectionsKt.listOf((Object[]) new g[]{new com.tencent.qqnt.chats.main.lightbusiness.a(), new d(), new com.tencent.qqnt.chats.data.processor.part.a(), new TitleConvertProcessor(), new com.tencent.qqnt.chats.data.processor.part.e(), new SummaryConvertProcessor(false, 1, null), new c()});
        }
        this.mPartProcessorList = list;
        ArrayList<Class<g>> arrayList3 = f355148d;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = arrayList3.iterator();
        while (it5.hasNext()) {
            Constructor<?>[] constructors2 = ((Class) it5.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors2, "it.constructors");
            first2 = ArraysKt___ArraysKt.first(constructors2);
            Object newInstance2 = ((Constructor) first2).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance2, "null cannot be cast to non-null type com.tencent.qqnt.chats.data.converter.IPartConvertProcessor");
            arrayList4.add((g) newInstance2);
        }
        this.mBizProcessorList = arrayList4;
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public boolean match(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.n() == 2 || item.n() == 1 || item.n() == 3 || item.n() == 100 || item.n() == 111 || item.n() == 102 || item.n() == 117 || item.n() == 101 || item.n() == 119) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull com.tencent.qqnt.chats.data.converter.c params, boolean isFirst) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, item, params, Boolean.valueOf(isFirst));
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        if (isFirst) {
            for (g gVar : this.mPartProcessorList) {
                if (com.tencent.qqnt.chats.utils.g.f355548a.a(params.d(), gVar)) {
                    gVar.update(item, params);
                }
            }
        }
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull com.tencent.qqnt.chats.data.converter.c params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) item, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        for (g gVar : this.mPartProcessorList) {
            if (com.tencent.qqnt.chats.utils.g.f355548a.a(params.d(), gVar)) {
                gVar.update(item, params);
            }
        }
        for (g gVar2 : this.mBizProcessorList) {
            if (com.tencent.qqnt.chats.utils.g.f355548a.a(params.d(), gVar2)) {
                gVar2.update(item, params);
            }
        }
    }
}
